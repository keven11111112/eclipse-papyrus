/******************************************************************************
 * Copyright (c) 2005, 2020 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *     committers of openArchitectureWare - initial API and implementation
 *     Artem Tikhomirov (Borland) - Migration to OCL expressions
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.xpand.model;

import org.eclipse.papyrus.gmf.internal.xpand.ocl.DeclaredParameter;
import org.eclipse.papyrus.gmf.internal.xpand.ocl.TypeHelper;

public interface XpandDefinition {

    XpandResource getOwner();

    void evaluate(ExecutionContext ctx);

    DeclaredParameter[] getParams();

    TypeHelper getTargetType();

    String getName();

}
