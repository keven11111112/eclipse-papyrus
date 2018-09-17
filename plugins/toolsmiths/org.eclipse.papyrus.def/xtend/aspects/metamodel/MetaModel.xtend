/*****************************************************************************
 * Copyright (c) 2015 Anatoliy Tischenko and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Anatoliy Tischenko - Initial API and implementation
 * 
 *****************************************************************************/
package aspects.metamodel

import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import com.google.inject.Inject
import metamodel.MetaModel_qvto
import com.google.inject.Singleton

@Singleton class MetaModel extends metamodel.MetaModel {
	
	@Inject extension MetaModel_qvto;
	
	override DeclareAndAssign2(GenClass it, String assignee, String src, GenClass srcMetaClass, GenFeature srcFeature, String srcExt, boolean needCast) //
		'''«getQualifiedInterfaceName(it)» «assignee» = «getFeatureValue(srcFeature, src, srcMetaClass)».«srcExt»;'''
	
}