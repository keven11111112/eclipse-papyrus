package aspects.xpt.editor

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import xpt.Common

@Singleton class DiagramContentInitializer extends xpt.editor.DiagramContentInitializer {
	@Inject extension Common;

	@Inject VisualIDRegistry xptVisualIDRegistry;

	override def getCompartment(GenDiagram it) '''
		«generatedMemberComment»
		private org.eclipse.gmf.runtime.notation.Node getCompartment(org.eclipse.gmf.runtime.notation.View node, String visualID) {
			String type = «xptVisualIDRegistry.typeMethodCall(it, 'visualID')»;
			for (java.util.Iterator it = node.getChildren().iterator(); it.hasNext();) {
				org.eclipse.gmf.runtime.notation.View nextView = (org.eclipse.gmf.runtime.notation.View) it.next();
				if (nextView instanceof org.eclipse.gmf.runtime.notation.Node && type.equals(nextView.getType())) {
					return (org.eclipse.gmf.runtime.notation.Node) nextView;
				}
			}
			return null;
		}
	'''

}