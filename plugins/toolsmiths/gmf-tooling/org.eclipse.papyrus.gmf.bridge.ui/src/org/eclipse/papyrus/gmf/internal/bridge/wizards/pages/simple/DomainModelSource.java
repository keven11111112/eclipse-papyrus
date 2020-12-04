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
public interface DomainModelSource {

	public EPackage getContents();

	/**
	 * EClass mapped to diagram canvas.
	 */
	public EClass getDiagramElement();

	/**
	 * Returns true if domain element should be ignored.
	 * When model is being reconciled these elements are
	 * represented in it and should not be processed.
	 */
	public boolean isDisabled(EObject domainElement);
}
