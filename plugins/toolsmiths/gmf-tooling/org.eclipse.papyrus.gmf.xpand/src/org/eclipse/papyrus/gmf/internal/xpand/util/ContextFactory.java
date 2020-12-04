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
 *     Borland - initial API and implementation
 *     AurÃ©lien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *******************************************************************************/
 
package org.eclipse.papyrus.gmf.internal.xpand.util;

import java.util.Collection;

import org.eclipse.papyrus.gmf.internal.xpand.ResourceManager;
import org.eclipse.papyrus.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.papyrus.gmf.internal.xpand.model.ExecutionContextImpl;
import org.eclipse.papyrus.gmf.internal.xpand.model.Output;
import org.eclipse.papyrus.gmf.internal.xpand.model.Scope;
import org.eclipse.papyrus.gmf.internal.xpand.model.Variable;

/**
 * TODO remove?
 * @author artem
 */
public class ContextFactory {
	
	public static ExecutionContext createXpandContext(ResourceManager resourceManager) {
		return createXpandContext(resourceManager, null, null);
	}

	public static ExecutionContext createXpandContext(ResourceManager resourceManager, Output output, Collection<Variable> globalVars) {
		Scope scope = new Scope(resourceManager, globalVars, output);
		return new ExecutionContextImpl(scope);
	}
}
