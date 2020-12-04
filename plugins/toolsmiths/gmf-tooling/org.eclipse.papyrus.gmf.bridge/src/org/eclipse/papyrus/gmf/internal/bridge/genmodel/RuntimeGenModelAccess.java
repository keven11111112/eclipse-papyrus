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

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.gmf.runtime.notation.NotationPackage;

/**
 * @author artem
 *
 */
public class RuntimeGenModelAccess extends BasicGenModelAccess {

	private GenPackage genPackage;

	public RuntimeGenModelAccess() {
		super(NotationPackage.eINSTANCE);
		registerLocation(fromExtpoint());
	}

	/**
	 * Make sure genmodel is initialized prior to calling this method.
	 * @return
	 */
	public GenPackage genPackage() {
		if (genPackage == null) {
		// XXX perhaps, different logic could be here to 
		// workaround elements from same metamodel are not equal case  
			genPackage = model().findGenPackage(NotationPackage.eINSTANCE);
		}
		return genPackage;
	}
}
