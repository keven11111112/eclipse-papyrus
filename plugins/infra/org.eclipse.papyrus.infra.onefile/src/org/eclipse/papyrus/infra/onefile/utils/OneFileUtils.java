/*****************************************************************************
 * Copyright (c) 2011, 2016 Atos Origin Integration, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin Integration) tristan.faure@atosorigin.com - Initial API and implementation
 *  Christian W. Damus - bug 485220
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.onefile.utils;

import java.util.ArrayList;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.PapyrusModelHelper;

/**
 * Utility methods
 *
 * @author tristan.faure@atosorigin.com
 *
 */
public class OneFileUtils {

	/**
	 * Determines if a di exist in the container from a file name
	 *
	 * @param fileName
	 * @param parent
	 * @return
	 */
	public static boolean diExists(String fileName, IContainer parent) {
		return getDi(fileName, parent) != null;
	}

	/**
	 * Determines if a di exist in the container from a file name
	 *
	 * @param fileName
	 * @param parent
	 * @return
	 */
	public static IFile getDi(String fileName, IContainer parent) {
		if (parent == null || parent.getType() == IResource.ROOT) {
			return null;
		}
		String substring = fileName;
		if (fileName.indexOf('.') > 0) {
			substring = fileName.substring(0, fileName.lastIndexOf('.'));
		}
		IFile file = parent.getFile(new Path(substring + "." + DiModel.DI_FILE_EXTENSION));
		if (file.exists()) {
			return file;
		}
		return null;
	}

	/**
	 * check if the element has children or not
	 *
	 * @param element
	 * @return
	 */
	public static boolean hasChildren(Object element) {
		if (element instanceof IContainer) {
			IContainer container = (IContainer) element;
			try {
				return container.members().length > 0;
			} catch (CoreException e) {
			}
		}
		if (element instanceof IPapyrusFile) {
			IPapyrusFile iPapyrusFile = (IPapyrusFile) element;
			return iPapyrusFile.getMainFile() != null && iPapyrusFile.getAssociatedResources().length > 1;
		}
		return false;
	}

	/**
	 * Check if the element in parameter is visible or not
	 *
	 * @param element
	 * @return
	 */
	public static boolean isVisible(Object element) {
		if (element instanceof IFile) {
			IFile file = (IFile) element;
			return !OneFileUtils.diExists(file.getName(), file.getParent());
		}
		return true; // Don't filter unknown types
	}

	/**
	 * Check if the resource is a Papyrus Di
	 *
	 * @param fileName
	 * @return
	 */
	public static boolean isDi(IResource fileName) {
		return PapyrusModelHelper.getPapyrusModelFactory().isDi(fileName);
	}

	/**
	 * Returns the name without the extension of the file
	 *
	 * @param res
	 * @return
	 */
	public static String withoutFileExtension(IResource res) {
		if (res.getFileExtension() != null && res.getFileExtension().length() > 0) {
			return res.getName().substring(0, res.getName().lastIndexOf('.'));
		} else {
			return res.getName();
		}
	}

	/**
	 * Check if the resource has a DI inside it
	 *
	 * @param resource
	 * @return
	 */
	public static boolean containsModelFiles(IResource resource) {
		if (resource instanceof IContainer) {
			IContainer container = (IContainer) resource;
			try {
				for (IResource m : container.members()) {
					if (isDi(m)) {
						return true;
					}
				}
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public static IFile[] getAssociatedFiles(IPapyrusFile papyrusFile) {
		ArrayList<IFile> files = new ArrayList<IFile>();
		for (IResource res : papyrusFile.getAssociatedResources()) {
			if (res instanceof IFile) {
				files.add((IFile) res);
			}
		}
		return files.toArray(new IFile[files.size()]);
	}
}
