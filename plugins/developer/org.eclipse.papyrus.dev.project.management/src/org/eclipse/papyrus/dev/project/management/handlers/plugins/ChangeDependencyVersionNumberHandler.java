package org.eclipse.papyrus.dev.project.management.handlers.plugins;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.Manifest;
import java.util.jar.Attributes.Name;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.dev.project.management.Activator;
import org.eclipse.papyrus.dev.project.management.dialog.TwoInputDialog;
import org.eclipse.papyrus.dev.project.management.utils.Utils;
import org.eclipse.papyrus.eclipse.project.editors.file.ManifestEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor;
import org.eclipse.pde.core.project.IBundleProjectDescription;
import org.eclipse.pde.core.project.IBundleProjectService;
import org.eclipse.pde.core.project.IRequiredBundleDescription;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

//TODO should be covered with JUnit test
public class ChangeDependencyVersionNumberHandler extends AbstractHandler {

	private static final String TITLE = "Enter the new version number for Papyrus plugin.";


	private static final String INITIAL_VALUE = "0.0.0";

	private static final String WARNING_DIALOG_TITLE = "Change Version Name Report";

	private static final String WARNING_DIALOG_MESSAGE = "The following project were NOT managed : ";

	private static final String WARNING_DIALOG_MESSAGE2 = "Done.";

	private static final String PAPYRUS_NAME = "org.eclipse.papyrus";

	public Object execute(final ExecutionEvent event) throws ExecutionException {

		final IInputValidator validator = new IInputValidator() {

			public String isValid(final String newText) {
				final boolean match = newText.matches("[0-9]+\\.[0-9]+\\.[0-9]");
				if (!match) {
					return NLS.bind("The version number should be : something like this : {0}.", INITIAL_VALUE);
				}
				return null;
			}
		};
		final TwoInputDialog dialog = new TwoInputDialog(Display.getCurrent().getActiveShell(), TITLE, "Enter the new version for the Papyrus dependencies", "pattern plugin name", INITIAL_VALUE, PAPYRUS_NAME, validator);

		if (dialog.open() == Window.OK) {
			final String newVersion = dialog.getValue();
			final String pattern = dialog.getValue_2();

			Job job = new Job("Update dependency versions") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {

					final AtomicReference<IStatus> result = new AtomicReference<IStatus>();

					WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {

						@Override
						protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
							result.set(runAsJob(newVersion, pattern, monitor));
						}

					};

					try {
						operation.run(monitor);
					} catch (InvocationTargetException e) {
						return new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
					} catch (InterruptedException e) {
						return new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
					}

					return result.get();
				}

			};
			job.setUser(true);
			job.schedule();
		}
		return null;
	}

	protected IStatus runAsJob(final String newVersion, final String pattern, IProgressMonitor monitor) {
		String notManagedProjectNames = "";

		final IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();

		monitor.beginTask("Update dependency versions", projects.length);

		for (final IProject current : projects) {
			final String name = current.getName();

			if (name.startsWith(PAPYRUS_NAME)) {// TODO : add the possibility to manage other plugins
				setVersionNumber(current, pattern, newVersion, notManagedProjectNames);
			} else {
				notManagedProjectNames += NLS.bind("- {0} \n", current.getName());
			}

			monitor.worked(1);
		}


		final String textResult = notManagedProjectNames;
		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				if (textResult.equals("")) {
					final MessageDialog informationDialog = new MessageDialog(Display.getCurrent().getActiveShell(), WARNING_DIALOG_TITLE, null, WARNING_DIALOG_MESSAGE2, MessageDialog.INFORMATION, new String[] { "OK" }, 0);
					informationDialog.open();
				} else {
					final MessageDialog informationDialog = new MessageDialog(Display.getCurrent().getActiveShell(), WARNING_DIALOG_TITLE, null, WARNING_DIALOG_MESSAGE + "\n" + textResult, MessageDialog.INFORMATION, new String[] { "OK" }, 0);
					informationDialog.open();
				}
			}
		});

		return Status.OK_STATUS;
	}

	/**
	 *
	 * @param project
	 *            the project to manage
	 * @param dependencyPattern
	 *            the pattern used to find the dependency to update
	 * @param newVersion
	 *            the new version for the project
	 * @param notManagedProjectNames
	 *            a String used to build the message with the not managed projects
	 */
	private void setVersionNumber(final IProject project, final String dependencyPattern, final String newValue, String notManagedProjectNames) {
		if (project.isOpen()) {
			try {
				final boolean pluginnature = project.hasNature(Utils.PLUGIN_NATURE);
				if (pluginnature) {
					try {
						// final IManifestEditor editor = new ManifestEditor(project);
						// editor.init();
						// editor.setDependenciesVersion(dependencyPattern, newValue);
						// editor.save();
						MyManifestEditor editor = new MyManifestEditor(project);
						editor.init();
						editor.setDependenciesVersion(dependencyPattern, newValue);
						editor.save();
					} catch (final IOException e) {
						Activator.log.error(e);
						notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
					} catch (final Throwable e) {
						Activator.log.error(e);
						notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
					}

				}
			} catch (final CoreException e) {
				Activator.log.error(e);
			}
		} else {
			notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
		}
	}


	private class MyManifestEditor extends ManifestEditor {

		private static final String SEMICOLON = ";"; //$NON-NLS-1$

		private static final String COMMA = ","; //$NON-NLS-1$

		private static final String ASSIGN = "="; //$NON-NLS-1$

		private static final String BUNDLE_VERSION = "bundle-version"; //$NON-NLS-1$

		private static final String REQUIRED_BUNDLE = "Require-Bundle"; //$NON-NLS-1$

		private Manifest manifest;

		private IFile manifestFile;

		/**
		 * Constructor.
		 *
		 * @param project
		 * @throws IOException
		 * @throws CoreException
		 */
		public MyManifestEditor(IProject project) throws IOException, CoreException {
			super(project);
			manifestFile = project.getFile("META-INF/MANIFEST.MF");
			manifest = new Manifest(manifestFile.getContents());
		}

		/**
		 * @see org.eclipse.papyrus.eclipse.project.editors.file.ManifestEditor#setDependenciesVersion(java.lang.String, java.lang.String)
		 *
		 * @param dependencyPattern
		 * @param newVersion
		 */
		@Override
		public void setDependenciesVersion(String dependencyPattern, String newVersion) {
			final Name rqBundle = new Name(REQUIRED_BUNDLE);
			final String requireBundles = manifest.getMainAttributes().getValue(rqBundle);
			final String[] bundles = requireBundles.split(COMMA);
			String newRequiredBundles = ""; //$NON-NLS-1$
			for (int ii = 0; ii < bundles.length; ii++) {// we iterate on the declared dependencies
				final String currentDependency = bundles[ii];
				final String[] dependencyValue = currentDependency.split(SEMICOLON);
				if (dependencyValue[0].contains(dependencyPattern)) {
					String[] test = dependencyValue[1].split("[0-9]+\\.[0-9]+\\.[0-9]");
					String oldVersion = dependencyValue[1].substring(test[0].length(), test[0].length() + 5);
					// This test is necessary to take into account the versions tagged 0.*.*
					String newBundleVersion = BUNDLE_VERSION + ASSIGN + '"' + newVersion + '"';
					if (!oldVersion.matches("[1-9]+\\.[0-9]+\\.[0-9]")) {
						newBundleVersion = BUNDLE_VERSION + ASSIGN + '"' + oldVersion + '"';
					}
					newRequiredBundles += dependencyValue[0] + SEMICOLON + newBundleVersion;
					for (int i = 1; i < dependencyValue.length; i++) {
						final String declaration = dependencyValue[i];
						if (declaration.contains(BUNDLE_VERSION + ASSIGN)) {
							// we ignore it
						} else {
							newRequiredBundles += SEMICOLON + dependencyValue[i];// we add the others declaration
						}
					}
				} else {
					newRequiredBundles += currentDependency;// we copy the existing declaration
				}
				if (ii < (bundles.length - 1)) {
					newRequiredBundles += COMMA;
				}
			}
			setValue(REQUIRED_BUNDLE, newRequiredBundles);
		}
	}

}
