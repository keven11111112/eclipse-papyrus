/******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.genmodel;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * @author artem
 */
public class FileGenModelAccess implements GenModelAccess {
	private final URI myLocation;
	private GenModel myModel;

	public FileGenModelAccess(URI genModelResource) {
		myLocation = genModelResource;
	}

	public FileGenModelAccess(IFile genModelWorkspaceFile) {
		this(URI.createPlatformResourceURI(genModelWorkspaceFile.getFullPath().toString(), true));
	}

	public GenModel model() {
		return myModel;
	}

	public IStatus load() {
		return load(new ResourceSetImpl());
	}

	public IStatus load(ResourceSet resourceSet) {
		if (myModel != null) {
			return Status.OK_STATUS;
		}
		try {
			Resource res = resourceSet.getResource(myLocation, true);
			Object root = res.getContents().get(0);
			if (root instanceof GenModel) {
				myModel = (GenModel) root;
				return Status.OK_STATUS;
			} else {
				return new Status(IStatus.ERROR, "org.eclipse.papyrus.gmf.bridge", 0, "Root object of resource " + myLocation + " is not GenModel", null);
			}
		} catch (RuntimeException ex) {
			return new Status(IStatus.ERROR, "org.eclipse.papyrus.gmf.bridge", 0, "Can't load resource " + myLocation, ex);
		}
	}

	public void unload() {
		if (myModel != null) {
			myModel.eResource().unload();
			myModel = null;
		}
	}

}
