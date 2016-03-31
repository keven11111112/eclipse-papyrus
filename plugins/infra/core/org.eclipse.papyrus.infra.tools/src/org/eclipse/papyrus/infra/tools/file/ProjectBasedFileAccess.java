/*****************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
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

package org.eclipse.papyrus.infra.tools.file;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

/**
 * A simple class providing access to the file system relative to a specified project
 *
 */
public class ProjectBasedFileAccess implements IPFileSystemAccess {

	IProject project;

	String subFolderName;

	/**
	 * force an update of resources (currently always true)
	 */
	final static boolean force = true;

	/**
	 * Create a project based file access for a specific project.
	 * 
	 * @param project
	 *            the project for which file system access is provided
	 */
	public ProjectBasedFileAccess(IProject project) {
		setProject(project, null);
	}

	/**
	 * Create a project based file access for a specific project.
	 * 
	 * @param project
	 *            the project for which file system access is provided
	 * @param subFolderName
	 *            a sub-folder within the project, e.g. "src"
	 */
	public ProjectBasedFileAccess(IProject project, String subFolderName) {
		setProject(project, subFolderName);
	}

	/**
	 * Set/update project, reset subFolderName to null
	 * 
	 * @param project
	 *            the project for which file system access is provided
	 */
	public void setProject(IProject project) {
		setProject(project, null);
	}

	/**
	 * Set/update project and sub-folder
	 *
	 * @param project
	 *            the project for which file system access is provided
	 * @param subFolderName
	 *            a sub-folder within the project, e.g. "src"
	 */
	public void setProject(IProject project, String subFolderName) {
		this.project = project;
		this.subFolderName = subFolderName;
	}

	/**
	 * @see org.eclipse.papyrus.infra.tools.util.IPFileSystemAccess.generator.IFileSystemAccess#generateFile(java.lang.String, java.lang.CharSequence)
	 *
	 * @param fileName
	 *            the filename relative to the project and sub-folder specified in the constructor. Use
	 *            '/' (IPFileSystemAccess.SEP_CHAR) as separation character
	 * @param contents
	 *            the content to write
	 */
	public void generateFile(String fileName, String content) {
		IFile file = getFile(fileName);
		InputStream contentStream = new ByteArrayInputStream(content.getBytes());
		try {
			if (file.exists()) {
				if (force) {
					file.setContents(contentStream, true, true, null);
				}
				// else - file is not updated
			} else {
				// the file does not exists
				file.create(contentStream, true, null);
			}
			// Refresh the container for the newly created files. This needs to be done even
			// during error because of the possibility for partial results.
			file.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.tools.util.IPFileSystemAccess.generator.IFileSystemAccess#deleteFile(java.lang.String)
	 *
	 * @param fileName
	 *            the filename relative to the project and sub-folder specified in the constructor
	 */
	public void deleteFile(String fileName) {
		IFile file = getFile(fileName);
		try {
			if (file.exists()) {
				file.delete(force, null);
			}
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Return a container (folder) for a given filename.
	 * Folders will be created, if the do not exist (comparable to "mkdir -p" in Unix).
	 *
	 * @param filename
	 *            a filename with the '/' as separation character
	 * @return file for this element
	 */
	public IFile getFile(String filename) {
		String paths[] = filename.split(IPFileSystemAccess.SEP_CHAR);
		IContainer packageContainer = getFolder(project, subFolderName);
		try {
			for (int i = 0; i < paths.length - 1; i++) {
				String path = paths[i];
				packageContainer = getFolder(packageContainer, path);
				if (!packageContainer.exists()) {
					// if packageContainer is a Project, it necessarily exists
					((IFolder) packageContainer).create(false, true, null);
				}
			}
			String last = paths[paths.length - 1];
			return getFile(packageContainer, last);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Return the a sub-folder from a given container
	 * 
	 * @param container
	 *            a container (must be a project or a folder)
	 * @param folderName
	 *            the name of a sub-folder within the container. If null, original container is returned.
	 * @return the sub-folder if it exists, null otherwise
	 */
	public IContainer getFolder(IContainer container, String folderName) {
		if (folderName == null) {
			return container;
		}
		if (container instanceof IFolder) {
			return ((IFolder) container).getFolder(folderName);
		} else if (container instanceof IProject) {
			return ((IProject) container).getFolder(folderName);
		}
		return null;
	}

	/**
	 * Return a file within a container
	 * 
	 * @param container
	 *            a container (must be a project or a folder)
	 * @param fileName
	 *            the name of a file within the container.
	 * @return the file if it exists, null otherwise
	 */
	public IFile getFile(IContainer container, String fileName) {
		if (container instanceof IFolder) {
			return ((IFolder) container).getFile(fileName);
		} else if (container instanceof IProject) {
			return ((IProject) container).getFile(fileName);
		}
		return null;
	}
}
