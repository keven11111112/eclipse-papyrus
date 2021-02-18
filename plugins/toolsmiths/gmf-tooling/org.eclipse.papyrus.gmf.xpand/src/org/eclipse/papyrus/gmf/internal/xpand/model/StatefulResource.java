/*******************************************************************************
 * Copyright (c) 2009, 2020 Borland Software Corp, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.xpand.model;

/**
 * This is a marker interface. Intention of this interface is to show that
 * implementing resource should be initialized with appropriate {@link Scope}
 * instance.
 */
public interface StatefulResource {

	/**
	 * Perform actual initialization
	 */
	void initialize(Scope scope);

	/**
	 * @return true if this instance was already initialized
	 */
	boolean isInitialized();

}
