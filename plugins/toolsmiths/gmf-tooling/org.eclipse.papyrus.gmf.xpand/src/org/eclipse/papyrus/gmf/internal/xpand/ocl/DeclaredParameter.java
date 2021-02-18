/******************************************************************************
 * Copyright (c) 2008, 2020 Borland Software Corporation, CEA LIST, Artal
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
package org.eclipse.papyrus.gmf.internal.xpand.ocl;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.papyrus.gmf.internal.xpand.model.ExecutionContext;

/**
 * FIXME Might need to support init expressions for variables!
 * @author artem
 */
public class DeclaredParameter {

    private final VariableCS variableCS;
	private final TypeHelper type;

	public DeclaredParameter(VariableCS variableCS) {
		this.variableCS = variableCS;
		type = new TypeHelper(variableCS.getTypeCS());
    }

	public EClassifier getTypeForName(ExecutionContext ctx) {
		return type.getTypeForName(ctx);
	}

	public String getTypeName() {
		return type.getName();
	}

	public String getVarName() {
		return variableCS.getName();
	}

	public static DeclaredParameter[] create(List<VariableCS> p) {
		final DeclaredParameter[] params = new DeclaredParameter[p.size()];
		int i = 0;
		for (VariableCS v : p) {
			params[i++] = new DeclaredParameter(v);
		}
		return params;
	}
}
