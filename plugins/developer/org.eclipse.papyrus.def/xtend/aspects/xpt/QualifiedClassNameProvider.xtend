/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package aspects.xpt

import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenNode

@Singleton class QualifiedClassNameProvider extends xpt.QualifiedClassNameProvider {


	
	
	override dispatch getItemSemanticEditPolicyQualifiedClassName(GenDiagram it) '''org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCompartmentSemanticEditPolicy'''
	override dispatch getItemSemanticEditPolicyQualifiedClassName(GenCompartment it) '''org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCompartmentSemanticEditPolicy'''
	override dispatch getItemSemanticEditPolicyQualifiedClassName(GenLink it) '''org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultSemanticEditPolicy'''
	override dispatch getItemSemanticEditPolicyQualifiedClassName(GenNode it) '''org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultSemanticEditPolicy'''
	
	

}