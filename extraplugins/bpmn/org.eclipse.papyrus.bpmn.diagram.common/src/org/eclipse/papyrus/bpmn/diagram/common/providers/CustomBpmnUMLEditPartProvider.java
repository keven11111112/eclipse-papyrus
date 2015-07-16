package org.eclipse.papyrus.bpmn.diagram.common.providers;

<<<<<<< Upstream, based on origin/master
import org.eclipse.papyrus.uml.diagram.activity.edit.part.CustomUMLEditPartFactory;
=======
>>>>>>> c612c25 Papyrus BPMN customization Bundle info corrections
import org.eclipse.papyrus.uml.diagram.activity.providers.CustomUMLEditPartProvider;

public class CustomBpmnUMLEditPartProvider extends CustomUMLEditPartProvider{
	public CustomBpmnUMLEditPartProvider() {
		super();
		setFactory(new CustomBpmnUMLEditPartFactory());
		setAllowCaching(true);
	}
}
