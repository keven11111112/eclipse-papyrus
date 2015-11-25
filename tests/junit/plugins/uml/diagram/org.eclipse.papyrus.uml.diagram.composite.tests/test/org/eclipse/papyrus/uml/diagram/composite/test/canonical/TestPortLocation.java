package org.eclipse.papyrus.uml.diagram.composite.test.canonical;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.composite.CreateCompositeDiagramCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ClassCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.composite.test.ICompositeDiagramTestsConstants;
import org.junit.Test;

public class TestPortLocation extends org.eclipse.papyrus.uml.diagram.tests.canonical.TestPortLocation {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateCompositeDiagramCommand();
	}

	@Override
	protected String getProjectName() {
		return ICompositeDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return ICompositeDiagramTestsConstants.FILE_NAME;
	}

	@Test
	public void testStateMachinePortLocation() {
		testPortLocation(UMLElementTypes.StateMachine_2063);
	}

	@Test
	public void testProtocolStateMachinePortLocation() {
		testPortLocation(UMLElementTypes.ProtocolStateMachine_2062);
	}

	@Test
	public void testInteractionItemPortLocation() {
		testPortLocation(UMLElementTypes.Interaction_2061);
	}

	@Test
	public void testClassPortLocation() {
		testPortLocation(UMLElementTypes.Class_2073);
	}

	@Test
	public void testClassPartPortLocation() {
		testPortLocation(UMLElementTypes.Class_2073, ClassCompositeCompartmentEditPart.VISUAL_ID, UMLElementTypes.Property_3070);
	}

	@Test
	public void testActivityPortLocation() {
		testPortLocation(UMLElementTypes.Activity_2060);
	}

	@Override
	protected IElementType getPortType() {
		return UMLElementTypes.Port_3069;
	}
}
