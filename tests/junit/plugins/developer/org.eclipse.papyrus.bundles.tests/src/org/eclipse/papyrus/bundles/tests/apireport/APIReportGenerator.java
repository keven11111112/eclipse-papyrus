/*
 * Copyright (c) 2012, 2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Christian W. Damus - adapt for Papyrus bundle tests (bug 440910)
 */
package org.eclipse.papyrus.bundles.tests.apireport;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.papyrus.bundles.tests.Activator;
import org.eclipse.papyrus.bundles.tests.BundleTestsUtils;
import org.eclipse.pde.api.tools.internal.comparator.DeltaXmlVisitor;
import org.eclipse.pde.api.tools.internal.model.ApiModelFactory;
import org.eclipse.pde.api.tools.internal.model.BundleComponent;
import org.eclipse.pde.api.tools.internal.provisional.VisibilityModifiers;
import org.eclipse.pde.api.tools.internal.provisional.comparator.ApiComparator;
import org.eclipse.pde.api.tools.internal.provisional.comparator.ApiScope;
import org.eclipse.pde.api.tools.internal.provisional.comparator.IDelta;
import org.eclipse.pde.api.tools.internal.provisional.model.IApiBaseline;
import org.eclipse.pde.api.tools.internal.provisional.model.IApiComponent;
import org.eclipse.pde.api.tools.internal.provisional.model.IApiScope;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * <p>
 * A generator of API delta reports: given an API baseline (a set of plug-ins
 * from the "previous" or "latest" stable release of Papyrus), computes the
 * changes in the current installed/workspace versions of the same bundles.
 * These changes are of three kinds:
 * </p>
 * <ul>
 * <li>incompatible/breaking changes in public APIs</li>
 * <li>compatible changes in public APIs</li>
 * <li>changes in APIs re-exported by the plug-ins included in the report</li>
 * </ul>
 * <p>
 * The plug-ins in the scope of the report are all plug-ins that don't match any
 * of the exclusion filters in the <tt>excludes.txt</tt> file in this package.
 * The format of the file is the same as the exclusion/inclusion filters used
 * by the PDE API Tools Ant tasks.
 * </p>
 */
public class APIReportGenerator {
	// A decreasing sequence of bundle IDs that won't clash with those allocated by API Tools
	private static AtomicInteger nextDevWorkspaceBundleID = new AtomicInteger(Integer.MAX_VALUE);

	/**
	 * Match a bundle location that is a <tt>file:</tt> URI optionally preceded
	 * by <tt>reference:</tt>, <tt>initial@reference:</tt>, or other. for the purpose
	 * of extracting the file URI.
	 */
	private final Pattern bundleLocation = Pattern.compile("([^:]+:)?file:(.*)");

	private final File baselineLocation;
	private final File apiXML;

	/**
	 * Initializes me.
	 *
	 * @param baselineLocation
	 *            a directory in the local filesystem containing the plug-ins
	 *            that comprise the baseline of API comparison. This should usually be either a
	 *            self-contained (non-bundle-pooled) Eclipse installation or a leaf-level (single release)
	 *            p2 repository. In any case, the report generator searches within this location for a
	 *            <tt>plugins/</tt> directory and scans that for JAR and directory bundles. This must be
	 *            an absolute path
	 * @param apiXML
	 *            the XML file (absolute path) to generate
	 */
	public APIReportGenerator(File baselineLocation, File apiXML) {
		super();

		this.baselineLocation = baselineLocation;
		this.apiXML = apiXML;
	}

	/**
	 * Generates the XML API delta report file.
	 */
	public IStatus generate(IProgressMonitor monitor) throws CoreException {
		Pattern[] exclusionPatterns = loadExclusions("excludes.txt"); //$NON-NLS-1$

		SubMonitor progress = SubMonitor.convert(monitor, 100);

		try {
			try {
				try (BufferedWriter writer = new BufferedWriter(new FileWriter(apiXML))) {
					progress.subTask("Discovering API baseline...");
					IApiBaseline baseline = getBaseline(exclusionPatterns, progress.newChild(25));
					if (baseline == null) {
						return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "No API baseline configured");
					}
					checkCancellation(progress);

					progress.subTask("Discovering current API...");
					IApiScope scope = getAPIToCompare(exclusionPatterns, progress.newChild(25));
					checkCancellation(progress);

					progress.subTask("Computing deltas...");
					IDelta delta = ApiComparator.compare(scope, baseline, VisibilityModifiers.API, false, true, progress.newChild(25));
					if (delta != null) {
						checkCancellation(progress);

						DeltaXmlVisitor visitor = new DeltaXmlVisitor();
						delta.accept(visitor);

						writer.write(visitor.getXML());
						writer.flush();

						progress.done();
					}
				} catch (IOException e) {
					Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "I/O problem in API analysis", e));
				} catch (CoreException e) {
					Activator.getDefault().getLog().log(e.getStatus());
				}

				progress.worked(25);
				return Status.OK_STATUS;
			} catch (OperationCanceledException e) {
				// ignore
			}
		} finally {
			monitor.done();
		}

		return Status.CANCEL_STATUS;
	}

	IApiBaseline getBaseline(Pattern[] exclusionPatterns, IProgressMonitor monitor) throws IOException, CoreException {
		IApiBaseline result = ApiModelFactory.newApiBaseline("Configured Baseline");
		List<IApiComponent> components = new ArrayList<>();

		Files.walkFileTree(Paths.get(baselineLocation.toURI()), new SimpleFileVisitor<Path>() {
			private boolean inPlugins;

			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				FileVisitResult result = FileVisitResult.CONTINUE;

				// Don't delve into directory bundles
				if (inPlugins) {
					result = FileVisitResult.SKIP_SUBTREE;
				}
				// Don't clear this flag on directories nested within 'plugins'
				else if ("plugins".equals(dir.getFileName().toString())) {
					inPlugins = true;
				}

				return result;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				FileVisitResult result = FileVisitResult.CONTINUE;

				if ("plugins".equals(dir.getFileName().toString())) {
					inPlugins = false;
					result = FileVisitResult.TERMINATE;
				}

				return result;
			}

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				if (inPlugins) {
					try {
						IApiComponent component = ApiModelFactory.newApiComponent(result, file.toString());
						if ((component != null) && !isExcluded(exclusionPatterns, component.getSymbolicName())) {
							components.add(component);
							monitor.subTask(" added component " + component.getSymbolicName());
						}
					} catch (CoreException e) {
						// It's fine, it's not a bundle (maybe it's a pack200 archive)
					}
				}

				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
				System.out.printf("Error visiting %s: %s%n", file, exc.getMessage());
				return FileVisitResult.CONTINUE;
			}
		});

		result.addApiComponents(components.toArray(new IApiComponent[components.size()]));

		return result;
	}

	private static boolean isExcluded(Pattern[] patterns, String name) {
		for (Pattern pattern : patterns) {
			Matcher matcher = pattern.matcher(name);
			if (matcher.matches()) {
				return true;
			}
		}

		return false;
	}

	ApiScope getAPIToCompare(Pattern[] exclusionPatterns, IProgressMonitor monitor) throws CoreException {
		ApiScope result = new ApiScope();

		IApiBaseline currentBaseline = ApiModelFactory.newApiBaseline("Test Baseline");
		if (currentBaseline != null) {
			for (Bundle next : BundleTestsUtils.getPapyrusBundles()) {
				if (((next.getState() & (Bundle.INSTALLED | Bundle.STARTING | Bundle.ACTIVE)) != 0)
						&& !isExcluded(exclusionPatterns, next.getSymbolicName())) {

					try {
						String installLocation = getInstallLocation(next);
						if (installLocation != null) {
							IApiComponent component = null;
							Path installPath = Paths.get(installLocation);
							Path dotClasspath = installPath.resolve(".classpath");
							if (Files.isDirectory(installPath) && Files.exists(dotClasspath)) {
								// It's a project in the development workspace (we are a run-time instance)
								component = createDevWorkspaceComponent(currentBaseline, installPath, dotClasspath);
							} else {
								// Standard approach for JAR bundles and expanded installed bundles
								component = ApiModelFactory.newApiComponent(currentBaseline, installLocation);
							}

							if (component != null) {
								result.addElement(component);
								monitor.subTask(" added component " + component.getSymbolicName());
							}
						}
					} catch (CoreException e) {
						// Hmm, shouldn't happen for a successfully installed bundle
						Activator.getDefault().getLog().log(e.getStatus());
					}
				}
			}

			List<IApiComponent> allComponents = Stream.of(result.getApiElements())
					.filter(IApiComponent.class::isInstance)
					.map(IApiComponent.class::cast)
					.collect(Collectors.toList());
			currentBaseline.addApiComponents(allComponents.toArray(new IApiComponent[allComponents.size()]));
		}

		return result;
	}

	/**
	 * Obtains the location in the local filesystem where the specified {@code bundle} is installed.
	 * 
	 * @param bundle
	 *            an installed bundle
	 * @return its location in the local filesystem, or {@code null} if it could not be determined
	 */
	String getInstallLocation(Bundle bundle) {
		String result = null;

		Matcher m = bundleLocation.matcher(bundle.getLocation());
		if (m.matches()) {
			// Don't try to create a URI-based file using the file: URI because
			// in some installations, it will actually be a relative URI, which
			// the File(URI) constructor would reject
			result = new File(m.group(2)).getAbsolutePath();
		}

		return result;
	}

	protected IApiComponent createDevWorkspaceComponent(IApiBaseline parent, Path installLocation, Path dotClasspath) throws CoreException {
		BundleComponent result = new BundleComponent(parent, installLocation.toString(), nextDevWorkspaceBundleID()) {
			@Override
			protected String[] getClasspathEntries(Map<String, String> manifest) throws BundleException {
				List<String> classpathEntries = parseClasspath(dotClasspath);
				return classpathEntries.toArray(new String[classpathEntries.size()]);
			}
		};

		return result;
	}

	private static int nextDevWorkspaceBundleID() {
		return nextDevWorkspaceBundleID.getAndDecrement();
	}

	protected List<String> parseClasspath(Path dotClasspath) throws BundleException {
		List<String> result = new ArrayList<>();

		try {
			SAXParserFactory.newInstance().newSAXParser().parse(dotClasspath.toFile(), new DefaultHandler() {
				@Override
				public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
					if ("classpathentry".equals(qName)) {
						String kind = attributes.getValue("kind");
						if (kind != null) {
							switch (kind) {
							case "lib":
							case "output":
								result.add(attributes.getValue("path"));
								break;
							}
						}
					}
				}
			});
		} catch (SAXException | IOException | ParserConfigurationException e) {
			throw new BundleException("Failed to parse bundle classpath", e);
		}

		return result;
	}

	private static void checkCancellation(IProgressMonitor monitor) throws OperationCanceledException {
		if (monitor == null) {
			return;
		}

		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
	}

	private static Pattern[] loadExclusions(String resourceName) {
		List<Pattern> result;

		URL url = APIReportGenerator.class.getResource(resourceName);

		try (BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
			result = input.lines()
					.map(String::trim)
					.filter(((Predicate<String>) String::isEmpty).negate())
					.filter(line -> !line.startsWith("#")) //$NON-NLS-1$
					.map(pattern -> {
						if (pattern.startsWith("R:")) { //$NON-NLS-1$
							pattern = pattern.substring("R:".length()); //$NON-NLS-1$
						} else {
							pattern = Pattern.quote(pattern);
						}
						return Pattern.compile(pattern);
					})
					.collect(Collectors.toList());
		} catch (IOException e) {
			// Fine, no exclusions, then
			result = Collections.emptyList();
		}

		return result.toArray(new Pattern[result.size()]);
	}
}
