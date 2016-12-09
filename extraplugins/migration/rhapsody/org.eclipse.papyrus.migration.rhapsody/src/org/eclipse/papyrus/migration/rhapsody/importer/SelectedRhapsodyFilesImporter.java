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

package org.eclipse.papyrus.migration.rhapsody.importer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.infra.widgets.util.FileUtil;
import org.eclipse.papyrus.migration.rhapsody.Activator;
import org.eclipse.papyrus.migration.rhapsody.importer.utils.RhapsodyFileUtils;
import org.eclipse.swt.widgets.Display;

/**
 * This class allows us to convert easily the rpy file into the Papyrus EMF Rhapsody metamodel.
 * 
 * This file has been created using {@link SelectedFilesImporter}
 *
 */
public class SelectedRhapsodyFilesImporter {


	/**
	 * the uri initially selected by the user
	 */
	private Collection<URI> userSelectedFilesURI;

	// TODO : warning, it is used by JUnit tests too!
	// TODO : not common with RSA import
	// TODO : must be removed
	public static final String OUTPUT_FOLDER = "output";

	/**
	 * 
	 * Constructor.
	 *
	 * @param userSelectedFilesURI
	 *            the uri initially selected by the user
	 */
	public SelectedRhapsodyFilesImporter(final Collection<URI> userSelectedFilesURI) {
		this.userSelectedFilesURI = userSelectedFilesURI;
	}

	/**
	 * 
	 * @return
	 * 		the list of URI to import after transforming the selected rpy files into the EMF intermediate model
	 */
	public List<URI> getRhapsodyFilesToImportURI() {
		final Iterator<URI> iter = userSelectedFilesURI.iterator();
		Set<URI> urisToImport = new HashSet<URI>();
		while (iter.hasNext()) {
			final URI selectedURI = iter.next();
			String fileExtension = selectedURI.fileExtension();
			if (RhapsodyFileUtils.UML_RHAPSODY_FILE.equals(fileExtension)) {
				urisToImport.add(selectedURI);
			} else if (RhapsodyFileUtils.FILE_EXTENSION_RPY.equals(fileExtension)) {
				IFile res = FileUtil.getIFile(selectedURI.toPlatformString(true));
				IProject project = res.getProject();
				String projectinput = project.getLocation().toOSString();
				String projectOutput = getOutputFolderPath(selectedURI);
				UMLRhapsodyImporter importer = new UMLRhapsodyImporter(res.getLocation().toOSString(), projectOutput);
				// UMLRhapsodyImporter importer2 = new UMLRhapsodyImporter(selectedURI, projectOutput);
				importer.getRootProject();
				importer.save();
				try {
					project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				} catch (CoreException e) {
					Activator.log.error(e);
				}
				final URI rhapsodyEMFFileURI = getResultingUMLRhapsodyFileURI(selectedURI);
				urisToImport.add(rhapsodyEMFFileURI);
			}
		}
		return new ArrayList<URI>(urisToImport);
	}

	// TODO : should return a URI;
	public String getOutputFolderPath(final URI inputURI) {
		IFile res = FileUtil.getIFile(inputURI.toPlatformString(true));
		IProject project = res.getProject();
		URI projectURI = URI.createPlatformResourceURI(project.getLocation().toPortableString(), true);
		String lastSegment = inputURI.trimFileExtension().lastSegment();
		return projectURI.appendSegment(OUTPUT_FOLDER).appendSegment(lastSegment).toPlatformString(true);
	}

	/**
	 * 
	 * @param inputURI
	 *            the initial URI, it should be a rpy file
	 * @return
	 * 		the URI of the EMF version of the rpy file, with the extension RhapsodyFileUtils.UML_RHAPSODY_FILE
	 */
	public URI getResultingUMLRhapsodyFileURI(final URI inputURI) {
		final String str = getOutputFolderPath(inputURI);
		final IFile file = FileUtil.getIFile(str);
		final URI projectURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		final String fileName = inputURI.lastSegment();
		return projectURI.appendSegment(fileName).trimFileExtension().appendFileExtension(RhapsodyFileUtils.UML_RHAPSODY_FILE);
	}

}
