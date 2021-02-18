/******************************************************************************
 * Copyright (c) 2008, 2020 Borland Software Corporation, CEA LIST, Artal and others
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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.PrimitiveTypeCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.papyrus.gmf.internal.xpand.model.ExecutionContext;

/**
 * FIXME Definition.toString gives native java string for TypeHelper 
 * @author artem
 */
public class TypeHelper {

	private final TypeCS typeCS;

	public TypeHelper(TypeCS typeCS) {
		this.typeCS = typeCS;
	}

	public EClassifier getTypeForName(ExecutionContext ctx) {
		EClassifier c = new EmbeddedOCLAnalyzer(ctx.getOCLEnvironment()).typeForName(typeCS);
		if (c == ctx.getOCLEnvironment().getOCLStandardLibrary().getOclVoid()) {
			return null;
		}
		return c;
	}

	public String getName() {
		if (typeCS instanceof PrimitiveTypeCS) {
			return ((PrimitiveTypeCS) typeCS).getValue();
		} else if (typeCS instanceof PathNameCS) {
			return toString((PathNameCS) typeCS);
		} else if (typeCS instanceof CollectionTypeCS) {
			CollectionTypeCS collTypeCS = (CollectionTypeCS) typeCS;
			return collTypeCS.getCollectionTypeIdentifier().getName() + '[' + new TypeHelper(collTypeCS.getTypeCS()).getName() + ']';
		}
		return typeCS.toString();
	}

	public static String toString(PathNameCS pathName) {
        StringBuilder sb = new StringBuilder();
        for (SimpleNameCS simpleName : pathName.getSimpleNames()) {
        	if (sb.length() > 0) {
        		sb.append("::");
        	}
        	sb.append(simpleName.getValue());
        }
        return sb.toString();
	}
}
