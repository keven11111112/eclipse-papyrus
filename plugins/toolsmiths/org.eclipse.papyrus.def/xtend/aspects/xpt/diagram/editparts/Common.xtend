/*****************************************************************************
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Dmitry Stadnik (Borland) - initial API and implementation
 * Michael Golubev (Montages) - #386838 - migrate to Xtend2
 * Patrick Tessier (CEA LIST)
 * 
 *****************************************************************************/
package aspects.xpt.diagram.editparts

import aspects.xpt.QualifiedClassNameProvider
import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase

//Documentation: PapyrusGenCode
//This template has been modified in order to remove canonical ediPolicies

@Singleton class Common extends xpt.diagram.editparts.Common {
	@Inject extension aspects.xpt.Common;
	
	@Inject QualifiedClassNameProvider qualifiedClassNameProvider;

	override installCanonicalEditPolicy(GenContainerBase it) '''
	«IF it.needsCanonicalEditPolicy»
		«««	BEGIN: PapyrusGenCode
		«««	Used to remove at each time canonical editpolicies
		//in Papyrus diagrams are not strongly synchronised
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new «getCanonicalEditPolicyQualifiedClassName()»());
		«««	END: PapyrusGenCode
	
	«ENDIF»
	'''

	override creationEditPolicyNewInstance(GenCommonBase it) 
	'''new org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCreationEditPolicy()'''


	override installSemanticEditPolicy(GenCommonBase it) '''
	«IF sansDomain»
	removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.SEMANTIC_ROLE);
	«ELSE»
	installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.SEMANTIC_ROLE, new «qualifiedClassNameProvider.getItemSemanticEditPolicyQualifiedClassName(it)»());
	«ENDIF»
	'''

	override def visualIDConstant(GenCommonBase it) '''
		«generatedMemberComment»
		public static final String VISUAL_ID = "«stringVisualID»";
	'''

}