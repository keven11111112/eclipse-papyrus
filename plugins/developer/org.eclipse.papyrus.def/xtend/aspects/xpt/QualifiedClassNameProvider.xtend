package aspects.xpt

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenNode
import xpt.diagram.editpolicies.LinkItemSemanticEditPolicy
import xpt.diagram.editpolicies.NodeItemSemanticEditPolicy

@Singleton class QualifiedClassNameProvider extends xpt.QualifiedClassNameProvider {


	
	
	override dispatch getItemSemanticEditPolicyQualifiedClassName(GenDiagram it) '''org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCompartmentSemanticEditPolicy'''
	override dispatch getItemSemanticEditPolicyQualifiedClassName(GenCompartment it) '''org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCompartmentSemanticEditPolicy'''
	override dispatch getItemSemanticEditPolicyQualifiedClassName(GenLink it) '''org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultSemanticEditPolicy'''
	override dispatch getItemSemanticEditPolicyQualifiedClassName(GenNode it) '''org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultSemanticEditPolicy'''
	
	

}