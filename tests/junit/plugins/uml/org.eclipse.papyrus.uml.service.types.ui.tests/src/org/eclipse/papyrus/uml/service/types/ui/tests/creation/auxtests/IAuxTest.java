/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.service.types.ui.tests.creation.auxtests;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

public interface IAuxTest {
	
	/**
	 * @param container
	 * @param source
	 * @param target
	 * @param hintedType
	 * @param commandResult
	 */
	public abstract void test(EObject container, EObject source, EObject target, IHintedType hintedType, Collection<?> commandResult);
}
