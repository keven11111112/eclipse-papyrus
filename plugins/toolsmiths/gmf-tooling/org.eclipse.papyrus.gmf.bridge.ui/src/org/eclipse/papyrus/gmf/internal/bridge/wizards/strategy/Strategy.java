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
package org.eclipse.papyrus.gmf.internal.bridge.wizards.strategy;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

/**
 * @author artem
 */
public interface Strategy<T extends EObject> {

	String getID();

	/**
	 * @param soFar list to filter, should be modified directly
	 * @param hierarchy accessor to domain model  
	 * @return 
	 */
	void filter(Collection<T> soFar, Hierarchy hierarchy);
}
