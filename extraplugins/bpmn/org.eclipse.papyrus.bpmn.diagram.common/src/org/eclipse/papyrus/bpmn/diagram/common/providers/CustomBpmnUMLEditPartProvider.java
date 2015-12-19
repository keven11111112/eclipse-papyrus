package org.eclipse.papyrus.bpmn.diagram.common.providers;

import org.eclipse.papyrus.uml.diagram.activity.providers.CustomUMLEditPartProvider;

public class CustomBpmnUMLEditPartProvider extends CustomUMLEditPartProvider{
	public CustomBpmnUMLEditPartProvider() {
		super();
		setFactory(new CustomBpmnUMLEditPartFactory());
		setAllowCaching(true);
	}
}
