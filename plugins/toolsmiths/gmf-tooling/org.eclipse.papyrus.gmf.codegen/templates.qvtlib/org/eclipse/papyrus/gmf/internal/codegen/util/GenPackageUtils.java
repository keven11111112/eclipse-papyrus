/******************************************************************************
 * Copyright (c) 2012, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Andres Alvares Mattos - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/

package org.eclipse.papyrus.gmf.internal.codegen.util;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;

public class GenPackageUtils {
	
	@Operation(contextual = false, kind = Kind.HELPER)
	public static  String getGenPackageQualifiedPackageInterfaceName(GenPackage genPackage)
	{
	  return genPackage.getQualifiedPackageInterfaceName();
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public String getGenPackageQualifiedFactoryInterfaceName(GenPackage genPackage)
	{
	  return genPackage.getQualifiedFactoryInterfaceName();
	}
	
	@Operation(contextual = false, kind = Kind.HELPER)
	public static  String getGenPackageQualifiedInterfaceName(GenClass genClass)
	{
	  return genClass.getQualifiedInterfaceName();
	}
	
	
}
