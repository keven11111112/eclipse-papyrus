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
package org.eclipse.papyrus.gmf.internal.graphdef.codegen;

import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.gmf.gmfgraph.FigureDescriptor;

class DiagramElementsCopier extends EcoreUtil.Copier {
	private final HashSet<FigureDescriptor> myOriginalFigures = new HashSet<FigureDescriptor>();
	
	public void registerSubstitution(FigureDescriptor original, FigureDescriptor substituted){
		put(original, substituted);
		myOriginalFigures.add(original);
	}

	public boolean isSubstituted(FigureDescriptor original) {
		return containsKey(original);
	}

	@SuppressWarnings("unchecked")
	public <T extends EObject> T xcopy(T original) {
		return (T) super.copy(original);
	}

	protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject) {
		if (EcoreUtil.isAncestor(myOriginalFigures, eObject)){
			//no such features in the CustomFigure's
			return;
		}
		super.copyReference(eReference, eObject, copyEObject);
	}
}