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
package org.eclipse.papyrus.gmf.internal.bridge.resolver;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

/**
 * @author dstadnik
 */
public abstract class TypePattern {

	private EClass type;

	private EAttribute[] labels;

	public TypePattern(EClass node, EAttribute[] labels) {
		this.type = node;
		this.labels = labels;
	}

	public EClass getType() {
		return type;
	}

	public EAttribute[] getLabels() {
		return labels;
	}
}
