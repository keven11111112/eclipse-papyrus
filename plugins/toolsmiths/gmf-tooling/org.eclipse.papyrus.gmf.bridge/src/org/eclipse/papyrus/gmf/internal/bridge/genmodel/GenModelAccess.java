/******************************************************************************
 * Copyright (c) 2005, 2020 Borland Software Corporation, CEA LIST, Artal
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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author artem
 *
 */
public interface GenModelAccess {

	GenModel model();
	IStatus load();
	IStatus load(ResourceSet resourceSet);
	void unload();

	public class Adapter implements GenModelAccess {
		private final GenModel model;

		public Adapter(GenModel aModel) {
			model = aModel;
		}
		public GenModel model() {
			return model;
		}
		public IStatus load() {
			return Status.OK_STATUS;
		}
		public IStatus load(ResourceSet rs) {
			return load();
		}
		public void unload() {
			// do nothing
		}
	}
}
