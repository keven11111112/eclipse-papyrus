/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.migration.rhapsody.tests.tests;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.core.internal.jobs.Worker;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Conflict;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.internal.spec.ReferenceChangeSpec;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.constraints.Activator;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.DisplayUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.junit.utils.rules.ModelSetFixture;
import org.eclipse.papyrus.migration.common.MigrationParameters.MigrationParametersFactory;
import org.eclipse.papyrus.migration.common.MigrationParameters.ThreadConfig;
import org.eclipse.papyrus.migration.common.transformation.AbstractImportTransformationLauncher;
import org.eclipse.papyrus.migration.rhapsody.blackboxes.VersioningBlackboxes;
import org.eclipse.papyrus.migration.rhapsody.importer.SelectedRhapsodyFilesImporter;
import org.eclipse.papyrus.migration.rhapsody.importer.utils.RpyProjectHandler;
import org.eclipse.papyrus.migration.rhapsody.importer.utils.RpyUtil;
import org.eclipse.papyrus.migration.rhapsody.transformations.RhapsodyImportTransformationLauncher;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author VL222926
 *
 *         abstract class used to test the import of Rhapsody Model into Papyrus
 */
@SuppressWarnings("nls")
public class AbstractImportRhapsodyModelTests extends AbstractPapyrusTest {

	/**
	 * the rhapsody file to import in Papyrus
	 */
	protected Set<IFile> rhapsodyFilesToImport = new HashSet<IFile>();

	/**
	 * the papyrus editor fixture used to load the expected model
	 */
	@Rule
	public final ModelSetFixture expectedResultFixture = new ModelSetFixture();

	/**
	 * This resource set contains the files created by the transformation
	 */
	protected final ResourceSet resultingResourceSet = new ResourceSetImpl();

	/**
	 * the resources created by the import
	 */
	protected Resource diResource = null;
	protected Resource notationResource = null;
	protected Resource umlResource = null;

	/**
	 * the created project used for the tests
	 */
	protected IProject project;

	/**
	 * the name of the rhapsody model to import
	 */
	protected String rhapsodyModelName;

	protected String resourcePath;

	protected IFile outputUmlFile = null;
	protected IFile outputNotationFile = null;
	protected IFile outputDiFile = null;


	/**
	 * 
	 * This method allows to create the project
	 * 
	 * @param projectName
	 *            the name of the project to create for the JUnit test
	 * @param resourcePath
	 *            the path where are stored the file to copy/load to execute the tests
	 * @param bundle
	 *            the bundle
	 * @throws CoreException
	 * @throws IOException
	 * @throws URISyntaxException
	 * 
	 */
	public void initTest(final String projectName, final String rhapsodyModelName, final String resourcePath, Bundle bundle) throws CoreException, IOException, URISyntaxException {
		this.rhapsodyModelName = rhapsodyModelName;
		this.project = ProjectUtils.createProject(projectName);

		importRhapsodyModelIntoProject(rhapsodyModelName, resourcePath, bundle, this.project);
		executeTransformation(this.rhapsodyFilesToImport);
		DisplayUtils.flushEventLoop();
		waitEndOfImportThread();
		DisplayUtils.flushEventLoop();
		initOutputIFilesFields();
	}


	protected void initOutputIFilesFields() {
		if (this.outputUmlFile == null) {
			this.outputUmlFile = checkUMLFileCreationAndGetIt();
		}
		if (this.outputNotationFile == null) {
			this.outputNotationFile = checkNotationFileCreationAndGetIt();
		}
		if (this.outputDiFile == null) {
			this.outputDiFile = checkDiFileCreationAndGetIt();
		}
	}


	protected void initOutputResourcesFields() {
		initOutputIFilesFields();
		if (this.umlResource == null) {
			this.umlResource = addFileToResourceSet(resultingResourceSet, outputUmlFile);
		}
		if (this.notationResource == null) {
			this.notationResource = addFileToResourceSet(resultingResourceSet, outputNotationFile);
		}
		if (this.diResource == null) {
			this.diResource = addFileToResourceSet(resultingResourceSet, outputDiFile);
		}
	}

	/**
	 * This method import the Rhapsody project into the workspace
	 * 
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public final void importRhapsodyModelIntoProject(final String rhapsodyModelName, final String sourcePath, final Bundle sourceBundle, final IProject targetProject) throws URISyntaxException, IOException {
		// TODO improve all this path with url, uri, string, ... emf URI will be a good solution
		final String currentRpyPath = sourcePath + rhapsodyModelName + "." + "rpy";
		URL url = sourceBundle.getResource(currentRpyPath);
		java.net.URI uri = FileLocator.resolve(url).toURI();
		RpyProjectHandler handler = new RpyProjectHandler(uri.getRawPath());
		URI rpyURI = handler.copyRhapsodyProjectToNewFolder(URI.createFileURI(targetProject.getLocationURI().getRawPath()));
		try {
			this.project.refreshLocal(IProject.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IPath location = Path.fromOSString(rpyURI.toFileString());
		IFile ifile = workspace.getRoot().getFileForLocation(location);
		rhapsodyFilesToImport.add(ifile);
	}

	private RhapsodyImportTransformationLauncher launcher;

	/**
	 * 
	 * @param rhapsodyFiles
	 *            the list of file to import
	 */
	protected void executeTransformation(final Set<IFile> rhapsodyFiles) {
		// TODO change the parameters of this method
		List<URI> urisToImport = new ArrayList<URI>();
		for (IFile current : rhapsodyFiles) {
			String path = null;
			if (current instanceof IFile) {
				path = ((IFile) current).getFullPath().toString();
			}
			if (path != null) {
				URI uri = URI.createPlatformResourceURI(path, true);
				urisToImport.add(uri);
			}
		}

		// SelectedRhapsodyFilesImporter importer = new SelectedRhapsodyFilesImporter(urisToImport);
		ThreadConfig config = MigrationParametersFactory.eINSTANCE.createThreadConfig();
		// List<URI> createdFilesURI = importer.getRhapsodyFilesToImportURI();
		launcher = new RhapsodyImportTransformationLauncher(config);
		// launcher.run(createdFilesURI);
		launcher.run(urisToImport);


	}

	/**
	 * 
	 * @return
	 * 		the uml file created by the QVTO tranformation if it exists
	 */
	protected IFile checkUMLFileCreationAndGetIt() {
		// TODO refactore this line!
		String outputFolder = /* project.getLocation().toOSString() + File.separator + */SelectedRhapsodyFilesImporter.OUTPUT_FOLDER + File.separator + rhapsodyModelName; // TODO output folder must be a parameter of the tranformation, it could be a project too
		// TODO : the SelectedFile importer must provide a method to get the target folder/project
		final IFile umlFile = project.getFile(outputFolder + File.separator + rhapsodyModelName + ".uml");
		try {
			umlFile.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue("The uml file has not been created." + umlFile.getFullPath(), umlFile.exists());
		return umlFile;
	}

	/**
	 * This method allows to wait the end of the import thread
	 * 
	 * TODO : refactore API to have a direct access to the import thread!
	 */
	@SuppressWarnings("restriction")
	protected void waitEndOfImportThread() {
		Set<Thread> threads = Thread.getAllStackTraces().keySet();
		for (Thread thread : threads) {
			if (thread instanceof Worker) {
				Job job = ((Worker) thread).currentJob();
				if (null != job) {
					if (job.getName().equals(AbstractImportTransformationLauncher.IMPORT_MODELS_JOB_NAME)) {
						try {
							job.join();
						} catch (InterruptedException e1) {
							Activator.log.error(e1);
						}
					}
				}
			}
		}
	}

	/**
	 * 
	 * @return
	 * 		the notation file created by the QVTO tranformation if it exists
	 */
	protected IFile checkNotationFileCreationAndGetIt() {
		// TODO refactore this line!
		String outputFolder = /* project.getLocation().toOSString() + File.separator + */SelectedRhapsodyFilesImporter.OUTPUT_FOLDER + File.separator + rhapsodyModelName; // TODO output folder must be a parameter of the tranformation, it could be a project too
		// TODO : the SelectedFile imported must provide a method to get the target folder/project
		final IFile notationFile = project.getFile(outputFolder + File.separator + rhapsodyModelName + ".notation");
		Assert.assertTrue("The notation file has not been created.", notationFile.exists());

		return notationFile;
	}

	/**
	 * 
	 * @return
	 * 		the notation file created by the QVTO tranformation if it exists
	 */
	protected IFile checkDiFileCreationAndGetIt() {
		// TODO refactore this line!
		String outputFolder = /* project.getLocation().toOSString() + File.separator + */SelectedRhapsodyFilesImporter.OUTPUT_FOLDER + File.separator + rhapsodyModelName; // TODO output folder must be a parameter of the tranformation, it could be a project too
		// TODO : the SelectedFile imported must provide a method to get the target folder/project
		final IFile diFile = project.getFile(outputFolder + File.separator + rhapsodyModelName + ".di");
		Assert.assertTrue("The di file has not been created.", diFile.exists());
		return diFile;
	}


	/**
	 * 
	 * @param resourceSet
	 *            a resource set
	 * @param fileToAdd
	 *            the file to add to the resource set
	 * @return
	 * 		the resource represented the added file
	 */
	protected Resource addFileToResourceSet(final ResourceSet resourceSet, final IFile fileToAdd) {
		String path = fileToAdd.getFullPath().toPortableString();
		URI umlURI = URI.createURI(path);
		boolean exist = resourceSet.getURIConverter().exists(umlURI, null);
		Assert.assertTrue(exist);
		return resourceSet.getResource(umlURI, true);
	}

	/**
	 * This test check the annotation added to the imported model
	 */
	@Test
	@Ignore
	public void checkUMLModel_ImportRhapsodyVersioning() {
		initOutputResourcesFields();
		Assert.assertTrue("The created uml resource is empty.", this.umlResource.getContents().size() > 0); //$NON-NLS-1$
		final Iterator<EObject> iter = this.umlResource.getContents().iterator();
		Package root = null;
		while (root == null && iter.hasNext()) {
			final EObject tmp = iter.next();
			if (tmp instanceof Package) {
				root = (Package) tmp;
			}
		}
		Assert.assertNotNull("The root of the imported model has not been found", root); //$NON-NLS-1$

		checkEAnnotationUsedForImportRhapsodyModelVersioning(root);
	}

	@Test
	@Ignore
	public void checkNotationModel_ImportRhapsodyVersioning() {
		initOutputResourcesFields();
		Assert.assertTrue("The created notation resource is empty.", this.notationResource.getContents().size() > 0); //$NON-NLS-1$
		for (final EObject current : this.notationResource.getContents()) {
			if (current instanceof Diagram) {
				checkEAnnotationUsedForImportRhapsodyModelVersioning((Diagram) current);
			}
		}
	}

	/**
	 * This method check that the EObject owns the required EAnnotation indicating the model Model or Diagram has been created from a Rhapsody Model
	 * 
	 * @param objectToTest
	 *            an object
	 */
	protected void checkEAnnotationUsedForImportRhapsodyModelVersioning(final EModelElement objectToTest) {
		Assert.assertTrue("Internal test checking that tested object is a NamedElement or a Diagram failed", objectToTest instanceof NamedElement || objectToTest instanceof Diagram); //$NON-NLS-1$
		String objectName = ""; //$NON-NLS-1$
		if (objectToTest instanceof NamedElement) {
			objectName = ((NamedElement) objectToTest).getName();
		} else {
			objectName = ((Diagram) objectToTest).getName();
		}
		final String eClassName = objectToTest.eClass().getName();
		final EAnnotation annotation = objectToTest.getEAnnotation(VersioningBlackboxes.VERSIONING_EANNOTATION_SOURCE);
		Assert.assertNotNull(NLS.bind("{0}:{1} : The EAnnotation used for versioning has not been found.", objectName, eClassName), annotation); //$NON-NLS-1$

		// we check the Papyrus Bundle version used for the import
		final String papyrusImportBundleVersion = annotation.getDetails().get(VersioningBlackboxes.VERSIONING_EANNOTATION_DETAIL_KEY_PAPYRUS_RHAPSODY_IMPORT_BUNDLE_VERSION);
		Assert.assertNotNull(NLS.bind("{0}:{1} : The string indicating the Papyrus import version has not been found.", objectName, eClassName), papyrusImportBundleVersion); //$NON-NLS-1$
		Assert.assertTrue(NLS.bind("{0}:{1} : The string indicating the Papyrus version is empty.", objectName, eClassName), !papyrusImportBundleVersion.isEmpty()); //$NON-NLS-1$

		final String RhapsodyVersion = annotation.getDetails().get(VersioningBlackboxes.VERSIONING_EANNOTATION_DETAIL_KEY_RHAPSODY_VERSION);
		Assert.assertNotNull(NLS.bind("{0}:{1} : The string indicating the Rhapsody version has not been found.", objectName, eClassName), RhapsodyVersion); //$NON-NLS-1$
		Assert.assertTrue(NLS.bind("{0}:{1} : The string indicating the Rhapsody version is empty.", objectName, eClassName), !RhapsodyVersion.isEmpty()); //$NON-NLS-1$

		final String rhapsodyModelName = annotation.getDetails().get(VersioningBlackboxes.VERSIONING_EANNOTATION_DETAIL_KEY_RHAPSODY_PROJECT_NAME);
		Assert.assertNotNull(NLS.bind("{0}:{1} : The string indicating the name of the Rhapsody model has not been found.", objectName, eClassName), rhapsodyModelName); //$NON-NLS-1$
		Assert.assertTrue(NLS.bind("{0}:{1} : The string indicating the name of the Rhapsody model.", objectName, eClassName), !rhapsodyModelName.isEmpty()); //$NON-NLS-1$
	}

	/**
	 * Check the compatibility diagram version for all imported diagrams
	 */
	@Test
	@Ignore
	public void checkImportedDiagramCompatibilityVersion() {
		initOutputResourcesFields();
		Assert.assertTrue("The created notation resource is empty.", this.notationResource.getContents().size() > 0); //$NON-NLS-1$
		for (final EObject current : this.notationResource.getContents()) {
			if (current instanceof Diagram) {
				final StringValueStyle style = (StringValueStyle) ((Diagram) current).getNamedStyle(NotationPackage.eINSTANCE.getStringValueStyle(), VersioningBlackboxes.COMPATIBILITY_VERSION);
				Assert.assertNotNull(NLS.bind("{0}:Diagram : The compatibility diagram version has not been found", ((Diagram) current).getName()), style); //$NON-NLS-1$
				Assert.assertTrue(NLS.bind("{0}:Diagram : The compatibility diagram version is empty", ((Diagram) current).getName()), style.getStringValue().length() > 0); //$NON-NLS-1$
			}
		}
	}

	/**
	 * This method allows to check the created UML Model with the expected one
	 * 
	 * FIXME : in some case, the result is wrong, we detect diff between PackageImport
	 */
	@Test
	public void checkSemanticWithEMFCompare() {
		initOutputResourcesFields();
		final ResourceSet resultSet = new ResourceSetImpl();
		Resource currentResultResource = resultSet.getResource(this.umlResource.getURI(), true);
		List<EObject> currentContents = new ArrayList<EObject>( currentResultResource.getContents());
		currentContents.sort(new XMI_ID_Sorter());
		currentResultResource.getContents().clear();
		currentResultResource.getContents().addAll(currentContents);
		
		final ResourceSet expectedSet = new ResourceSetImpl();
		Resource expectedResource = expectedSet.getResource(expectedResultFixture.getModelResource().getURI(), true);
		List<EObject> expectedContents = new ArrayList<EObject>(expectedResource.getContents());
		expectedContents.sort(new XMI_ID_Sorter());
		expectedResource.getContents().clear();
		expectedResource.getContents().addAll(expectedContents);
		
		final DefaultComparisonScope scope = new DefaultComparisonScope(resultSet, expectedSet, null);
		final Comparison result = EMFCompareUtils.createEMFCompare().compare(scope);
		final List<Conflict> conflicts = result.getConflicts();
		Assert.assertEquals("Conflicts have been detected", 0, conflicts.size()); //$NON-NLS-1$

		final List<Diff> differences = getFilteredDiff(new ArrayList<Diff>(result.getDifferences()));

		if (!differences.isEmpty()) {
			final StringBuilder builder = new StringBuilder(NLS.bind("{0} differences have been detected: \n", differences.size())); //$NON-NLS-1$
			final Iterator<Diff> iter = differences.iterator();
			while (iter.hasNext()) {
				final Diff current = iter.next();
				builder.append(current.toString());
				if (iter.hasNext()) {
					builder.append("\n"); //$NON-NLS-1$
				}
			}
			Assert.assertEquals(builder.toString(), 0, differences.size());
		}
	}

	public class XMI_ID_Sorter implements Comparator<EObject>{

		/**
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 *
		 * @param o1
		 * @param o2
		 * @return
		 */
		@Override
		public int compare(EObject o1, EObject o2) {
			XMIResource res1 = (XMIResource) o1.eResource();
			XMIResource res2 = (XMIResource) o2.eResource();
			String id1 = res1.getID(o1);
			String id2 = res2.getID(o2);
			return id1.compareTo(id2);
		}
		
	}

	protected List<Diff> getFilteredDiff(final List<Diff> diff) {
		List<Diff> returnedDiffs = new ArrayList<>(diff);
		for (Diff current : diff) {
			if (current instanceof ReferenceChangeSpec) {
				if (current.getKind() == DifferenceKind.ADD || current.getKind() == DifferenceKind.DELETE) {
					EObject value = ((ReferenceChangeSpec) current).getValue();
					if (value instanceof EStringToStringMapEntryImpl) {
						EStringToStringMapEntryImpl map = (EStringToStringMapEntryImpl) value;
						String key = map.getKey();
						if ("Rhapsody Version".equals(key) || "Papyrus Rhapsody Import Bundle Version".equals(key)) {
							returnedDiffs.remove(current);
						}
					}
				}
			}
		}
		return returnedDiffs;
	}


	/**
	 * This method allows to check the created UML Model with the expected one
	 */
	@Test
	@Ignore // doesn't work yet
	public void checkNotationWithEMFCompare() {
		final ResourceSet resultSet = new ResourceSetImpl();
		resultSet.getResource(this.umlResource.getURI(), true);
		resultSet.getResource(this.notationResource.getURI(), true);


		final ResourceSet expectedSet = new ResourceSetImpl();

		expectedSet.getResource(expectedResultFixture.getModelResource().getURI(), true);
		expectedSet.getResource(expectedResultFixture.getModelResource().getURI().trimFileExtension().appendFileExtension("notation"), true);


		final DefaultComparisonScope scope = new DefaultComparisonScope(resultSet, expectedSet, null);
		final Comparison result = EMFCompareUtils.createEMFCompare().compare(scope);
		final List<Conflict> conflicts = result.getConflicts();
		Assert.assertEquals("Conflicts have been detected", 0, conflicts.size()); //$NON-NLS-1$

		final List<Diff> differences = result.getDifferences();
		if (!differences.isEmpty()) {
			final StringBuilder builder = new StringBuilder(NLS.bind("{0} differences have been detected: \n", differences.size())); //$NON-NLS-1$
			final Iterator<Diff> iter = differences.iterator();
			while (iter.hasNext()) {
				final Diff current = iter.next();
				builder.append(current.toString());
				if (iter.hasNext()) {
					builder.append("\n"); //$NON-NLS-1$
				}
			}
			Assert.assertEquals(builder.toString(), 0, differences.size());
		}
	}

	/** relative path for some interesting folder to check */


	private static final String XMI_ID_ATTRIBUTE_NAME = "xmi:id"; // $NON-NLS-0$

	/**
	 * Checks that the XMI_ID are unique in the uml file
	 */
	@Test
	public void checkUnicityOfXMI_ID_In_UML_File() throws Exception {
		DocumentBuilder dBuilder;
		Document document = null;
		dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		document = dBuilder.parse(getUMLOutputFile());
		List<String> ids = new ArrayList<String>();
		List<Node> nodes = flattenDocument(document);
		for (Node node : nodes) {
			if (node.getAttributes() != null) {
				Node item = node.getAttributes().getNamedItem(XMI_ID_ATTRIBUTE_NAME);
				if (item != null) {
					String value = item.getNodeValue();
					ids.add(value);
				}
			}
		}
		Set<String> uniqueIds = new HashSet<>(ids);
		for (String t : uniqueIds) {
			// remove all method remove all instance, so it can't be used here
			ids.remove(t);
		}
		Assert.assertEquals("Some ids are duplicated in the UML model: " + ids.toString(), 0, ids.size());
	}

	/**
	 * Checks that the XMI_ID are unique in the uml file
	 */
	@Test
	@Ignore
	public void checkUnicityOfXMI_ID_In_Notation_File() throws Exception {
		DocumentBuilder dBuilder;
		Document document = null;
		dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		document = dBuilder.parse(getNotationOutputFile());
		List<String> ids = new ArrayList<String>();
		List<Node> nodes = flattenDocument(document);
		for (Node node : nodes) {
			if (node.getAttributes() != null) {
				Node item = node.getAttributes().getNamedItem(XMI_ID_ATTRIBUTE_NAME);
				if (item != null) {
					String value = item.getNodeValue();
					ids.add(value);
				}
			}
		}
		Set<String> uniqueIds = new HashSet<>(ids);
		for (String t : uniqueIds) {
			// remove all method remove all instance, so it can't be used here
			ids.remove(t);
		}
		Assert.assertEquals("Some ids are duplicated in the Notation model: " + ids.toString(), 0, ids.size());
	}

	/**
	 * Checks that all IDS contains the string GUID
	 */
	@Test
	public void checkIds_In_UML_File() throws Exception {
		DocumentBuilder dBuilder;
		Document document = null;
		dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		document = dBuilder.parse(getUMLOutputFile());
		List<String> ids = new ArrayList<String>();
		List<Node> nodes = flattenDocument(document);
		for (Node node : nodes) {
			if (node.getAttributes() != null) {
				Node item = node.getAttributes().getNamedItem(XMI_ID_ATTRIBUTE_NAME);
				if (item != null) {
					String value = item.getNodeValue();
					ids.add(value);
				}
			}
		}
		List<String> errorsIds = new ArrayList<String>();
		Consumer<? super String> action = (String param) -> {
			if (!param.contains(RpyUtil.GUID_STRING) && !param.contains(RpyUtil.OLDID_STRING)) {
				errorsIds.add(param);
			}
		};
		ids.forEach(action);
		Assert.assertEquals("Some ids doesn't contains the required string \"GUID\" or \"OLDID\":" + errorsIds.toString(), 0, errorsIds.size());
	}

	/**
	 * Checks that all IDS contains the string GUID
	 */
	@Test
	@Ignore // doesn't work yet
	public void checkIds_In_Notation_File() throws Exception {
		DocumentBuilder dBuilder;
		Document document = null;
		dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		document = dBuilder.parse(getNotationOutputFile());
		List<String> ids = new ArrayList<String>();
		List<Node> nodes = flattenDocument(document);
		for (Node node : nodes) {
			if (node.getAttributes() != null) {
				Node item = node.getAttributes().getNamedItem(XMI_ID_ATTRIBUTE_NAME);
				if (item != null) {
					String value = item.getNodeValue();
					ids.add(value);
				}
			}
		}
		List<String> errorsIds = new ArrayList<String>();
		Consumer<? super String> action = (String param) -> {
			if (!param.contains("GUID")) { // TODO reuse me
				errorsIds.add(param);
			}
		};
		ids.forEach(action);
		Assert.assertEquals("Some ids doesn't contains the required string \"GUID\":" + errorsIds.toString(), 0, errorsIds.size());
	}

	@Test
	public void checkAllElementInUMLFileHaveAnID() throws Exception {
		DocumentBuilder dBuilder;
		Document document = null;
		dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		document = dBuilder.parse(getUMLOutputFile());
		List<String> ids = new ArrayList<String>();
		List<Node> nodes = flattenDocument(document);
		for (Node node : nodes) {
			if (node.getAttributes() != null) {
				Node item = node.getAttributes().getNamedItem(XMI_ID_ATTRIBUTE_NAME);
				if (item != null) {
					String value = item.getNodeValue();
					ids.add(value);
				}
			}
		}
		int nbElements = 0;

		// here we need to load the umlResource to know how elements there are in the model.
		// it can fail if several elements have the same IDs and incompatible type
		initOutputResourcesFields();
		Iterator<EObject> iter = this.umlResource.getAllContents();
		while (iter.hasNext()) {
			iter.next();
			nbElements++;
		}
		Assert.assertEquals("I don't found the same number of XMI_ID than the number of element in the file", nbElements, ids.size());

	}

	@Test
	@Ignore // doesn't work yet
	public void checkAllElementInNotationFileHaveAnID() throws Exception {
		DocumentBuilder dBuilder;
		Document document = null;
		dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		document = dBuilder.parse(getNotationOutputFile());
		List<String> ids = new ArrayList<String>();
		List<Node> nodes = flattenDocument(document);
		for (Node node : nodes) {
			if (node.getAttributes() != null) {
				Node item = node.getAttributes().getNamedItem(XMI_ID_ATTRIBUTE_NAME);
				if (item != null) {
					String value = item.getNodeValue();
					ids.add(value);
				}
			}
		}
		int nbElements = 0;

		// here we need to load the umlResource to know how elements there are in the model.
		// it can fail if several elements have the same IDs and incompatible type
		initOutputResourcesFields();
		Iterator<EObject> iter = this.notationResource.getAllContents();
		while (iter.hasNext()) {
			iter.next();
			nbElements++;
		}
		Assert.assertEquals("I don't found the same number of XMI_ID than the number of element in the file", nbElements, ids.size());

	}

	private static final int DEFAULT_PORT_HEIGHT = 20;
	private static final int DEFAULT_PORT_WIDTH = 20;


	/**
	 * check the size of the port
	 * 
	 * This test must at least be valid for "shape_sysml_flowport_as_affixed"
	 */
	@Test
	@Ignore
	public void checkPortSize() {
		initOutputResourcesFields();
		final TreeIterator<EObject> iter = this.notationResource.getAllContents();
		while (iter.hasNext()) {
			final EObject current = iter.next();
			if (current instanceof Shape) {
				final Shape view = (Shape) current;
				final EObject eobject = view.getElement();
				if (eobject instanceof Port) {
					if (view.getLayoutConstraint() instanceof Bounds) {
						final Bounds bounds = (Bounds) view.getLayoutConstraint();
						Assert.assertEquals("The height of the port is not the expected one", DEFAULT_PORT_HEIGHT, bounds.getHeight());
						Assert.assertEquals("The width of the port is not the expected one", DEFAULT_PORT_WIDTH, bounds.getWidth());
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param document
	 *            a document
	 * @return
	 * 		all the nodes of the document
	 */
	public List<Node> flattenDocument(final Document document) {
		List<Node> nodes = new ArrayList<Node>();
		nodes = getAllChildren(document.getChildNodes());
		return nodes;
	}

	/**
	 * 
	 * @param nodeList
	 *            a node list
	 * @return
	 * 		all nodes and sub-nodes of the node list
	 */
	public List<Node> getAllChildren(NodeList nodeList) {
		List<Node> objects = new ArrayList<>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			objects.add(node);
			objects.addAll(getAllChildren(node.getChildNodes()));
		}
		return objects;
	}



	/**
	 * 
	 * @return
	 * 		the UML output file
	 */
	protected File getUMLOutputFile() {
		final IPath path = this.outputUmlFile.getRawLocation();
		final File file = path.toFile();
		return file;
	}

	/**
	 * 
	 * @return
	 * 		the Notation output file
	 */
	protected File getNotationOutputFile() {
		final IPath path = this.outputNotationFile.getRawLocation();
		final File file = path.toFile();
		return file;
	}

}
