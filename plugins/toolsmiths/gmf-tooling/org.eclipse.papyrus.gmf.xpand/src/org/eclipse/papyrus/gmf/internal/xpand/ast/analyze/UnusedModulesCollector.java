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
package org.eclipse.papyrus.gmf.internal.xpand.ast.analyze;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.papyrus.gmf.internal.xpand.ast.AbstractAstVisitor;
import org.eclipse.papyrus.gmf.internal.xpand.ocl.ExpressionHelper;

public class UnusedModulesCollector extends AbstractAstVisitor {

	private Set<Module> myUnusedModules;

	public UnusedModulesCollector(Set<Module> allModules) {
		myUnusedModules = new LinkedHashSet<Module>(allModules);
	}

	public Set<Module> getUnusedModules() {
		return myUnusedModules;
	}

	@Override
	protected void visitExpressionHelper(ExpressionHelper expressionHelper) {
		if (myUnusedModules.size() == 0) {
			return;
		}
		if (expressionHelper.getOCLExpression() != null) {
			purgeUsedModule(expressionHelper.getOCLExpression());
			for (Iterator<EObject> it = expressionHelper.getOCLExpression().eAllContents(); it.hasNext();) {
				purgeUsedModule(it.next());
			}
		}
	}

	private void purgeUsedModule(EObject oclAstElement) {
		if (oclAstElement instanceof OperationCallExp) {
			OperationCallExp opCall = (OperationCallExp) oclAstElement;
			EOperation referredOperation = opCall.getReferredOperation();
			if (referredOperation != null) {
				EObject eContainer = referredOperation.eContainer();
				if (eContainer instanceof Module) {
					myUnusedModules.remove(eContainer);
				}
			}
		}
	}

}
