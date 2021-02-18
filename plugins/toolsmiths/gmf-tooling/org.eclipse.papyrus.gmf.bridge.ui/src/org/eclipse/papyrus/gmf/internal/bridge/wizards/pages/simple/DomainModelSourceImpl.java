/******************************************************************************
 * Copyright (c) 2006, 2020 Eclipse.org, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Dmitry Stadnik - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.wizards.pages.simple;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * @author dstadnik
 */
public class DomainModelSourceImpl implements DomainModelSource {

	private final EPackage contents;

	private final EClass diagramElement;

	public DomainModelSourceImpl(EPackage contents, EClass diagramElement) {
		this.contents = contents;
		this.diagramElement = diagramElement;
	}

	public EPackage getContents() {
		return contents;
	}

	public EClass getDiagramElement() {
		return diagramElement;
	}

	public boolean isDisabled(EObject domainElement) {
		return false;
	}

	public boolean like(DomainModelSource another) {
		return contents == another.getContents() && diagramElement == another.getDiagramElement();
	}
}
