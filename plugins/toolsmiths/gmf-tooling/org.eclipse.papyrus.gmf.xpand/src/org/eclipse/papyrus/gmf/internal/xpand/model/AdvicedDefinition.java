/******************************************************************************
 * Copyright (c) 2005, 2020 committers of openArchitectureWare, CEA LIST, Artal and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *     committers of openArchitectureWare - initial API and implementation
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.xpand.model;

import org.eclipse.papyrus.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.papyrus.gmf.internal.xpand.ast.Advice;
import org.eclipse.papyrus.gmf.internal.xpand.ocl.DeclaredParameter;
import org.eclipse.papyrus.gmf.internal.xpand.ocl.TypeHelper;

public class AdvicedDefinition implements XpandDefinition {

    private XpandAdvice advice;

    private XpandDefinition definition;

    public AdvicedDefinition(final XpandAdvice adv, final XpandDefinition def) {
        advice = adv;
        definition = def;
    }

    public XpandResource getOwner() {
        return definition.getOwner();
    }

    public void evaluate(final ExecutionContext ctx) {
        final ExecutionContext ctx1 = ctx.cloneWithVariable(new Variable(Advice.DEF_VAR_NAME, BuiltinMetaModel.DEFINITION_TYPE, new XpandDefinitionWrap(definition, ctx)));
        advice.evaluate(ctx1);
    }

    public DeclaredParameter[] getParams() {
        return definition.getParams();
    }

    public TypeHelper getTargetType() {
        return definition.getTargetType();
    }

    public String getName() {
        return definition.getName();
    }

    @Override
    public String toString() {
        return definition.toString() + " adviced by " + advice.toString();
    }
}