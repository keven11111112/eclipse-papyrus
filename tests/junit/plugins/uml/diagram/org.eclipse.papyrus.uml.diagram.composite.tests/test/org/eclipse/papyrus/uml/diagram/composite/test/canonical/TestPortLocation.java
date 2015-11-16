package org.eclipse.papyrus.uml.diagram.composite.test.canonical;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.junit.framework.classification.FailingTest;
import org.eclipse.papyrus.uml.diagram.composite.CreateCompositeDiagramCommand;
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

	@FailingTest
	@Test
	public void testStateMachinePortLocation() {
		testPortLocation(UMLElementTypes.StateMachine_2063);
	}

	@FailingTest
	@Test
	public void testProtocolStateMachinePortLocation() {
		testPortLocation(UMLElementTypes.ProtocolStateMachine_2062);
	}

	@FailingTest
	@Test
	public void testInteractionItemPortLocation() {
		testPortLocation(UMLElementTypes.Interaction_2061);
	}

	@FailingTest
	@Test
	public void testClassPortLocation() {
		testPortLocation(UMLElementTypes.Class_2073);
	}

	@FailingTest
	@Test
	public void testActivityPortLocation() {
		testPortLocation(UMLElementTypes.Activity_2060);
	}

	@Override
	protected IElementType getPortType() {
		return UMLElementTypes.Port_3069;
	}
}
