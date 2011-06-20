package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.inherited;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.*;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.ElementTypes;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.AbstractTest;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit tests for element creation test (via palette tools) in a Model compartment (TopNode - still inherited from class diagram).
 */
public class TestNodeCreationOnModelCompartmentCN extends AbstractTest {

	public static View containerView;

	@BeforeClass
	public static void prepareContainerForTest() throws Exception {
		try {
			// force custom provider loading...
			createFromPalette("blockdefinition.tool.block", getDiagramView(), true);
			//

			createFromPalette("blockdefinition.tool.model", getDiagramView(), true);
			View topNodeView = ViewUtil.getChildBySemanticHint(getDiagramView(), ElementTypes.MODEL.getSemanticHint());
			View topNodeCompartmentView = ViewUtil.getChildBySemanticHint(topNodeView, ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT);

			// Ensure the compartment is visible (required for EditPart to be found)
			if(!topNodeCompartmentView.isVisible()) {
				changeVisibility(topNodeCompartmentView);
			}

			createFromPalette("blockdefinition.tool.model", topNodeCompartmentView, true);
			View childNodeView = ViewUtil.getChildBySemanticHint(topNodeCompartmentView, ElementTypes.MODEL_CN.getSemanticHint());
			containerView = ViewUtil.getChildBySemanticHint(childNodeView, ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT);

			if(containerView == null) {
				throw new Exception("Unable to prepare container for test.");
			}

			// Ensure the compartment is visible (required for EditPart to be found)
			if(!containerView.isVisible()) {
				changeVisibility(containerView);
			}

		} catch (Exception e) {
			throw new Exception("Unable to prepare container for test.");
		}
	}

	@Test
	public void createActor() throws Exception {
		createFromPalette("blockdefinition.tool.actor", containerView, true);
	}

	@Test
	public void createBlock() throws Exception {
		createFromPalette("blockdefinition.tool.block", containerView, true);
	}

	@Test
	public void createComment() throws Exception {
		createFromPalette("blockdefinition.tool.comment", containerView, true);
	}

	@Test
	public void createConstraint() throws Exception {
		createFromPalette("blockdefinition.tool.constraint", containerView, true);
	}

	@Test
	public void createConstraintBlock() throws Exception {
		createFromPalette("blockdefinition.tool.constraintblock", containerView, true);
	}

	@Test
	public void createConstraintProperty() throws Exception {
		createFromPalette("blockdefinition.tool.constraintproperty", containerView, false);
	}

	@Test
	public void createDataType() throws Exception {
		createFromPalette("blockdefinition.tool.datatype", containerView, true);
	}

	@Test
	public void createDimension() throws Exception {
		createFromPalette("blockdefinition.tool.dimension", containerView, true);
	}

	@Test
	public void createEnumeration() throws Exception {
		createFromPalette("blockdefinition.tool.enumeration", containerView, true);
	}

	@Test
	public void createEnumerationLiteral() throws Exception {
		createFromPalette("blockdefinition.tool.enumerationliteral", containerView, false);
	}

	@Test
	public void createFlowPort() throws Exception {
		createFromPalette("blockdefinition.tool.flowport", containerView, false);
	}

	@Test
	public void createFlowProperty() throws Exception {
		createFromPalette("blockdefinition.tool.flowproperty", containerView, false);
	}

	@Test
	public void createFlowSpecification() throws Exception {
		createFromPalette("blockdefinition.tool.flowspecification", containerView, true);
	}

	@Test
	public void createInstanceSpecification() throws Exception {
		createFromPalette("blockdefinition.tool.instancespecification", containerView, true);
	}

	@Test
	public void createInterface() throws Exception {
		createFromPalette("blockdefinition.tool.interface", containerView, true);
	}

	@Test
	public void createModel() throws Exception {
		createFromPalette("blockdefinition.tool.model", containerView, true);
	}

	@Test
	public void createOperation() throws Exception {
		createFromPalette("blockdefinition.tool.operation", containerView, false);
	}

	@Test
	public void createPackage() throws Exception {
		createFromPalette("blockdefinition.tool.package", containerView, true);
	}

	@Test
	public void createPart() throws Exception {
		createFromPalette("blockdefinition.tool.part", containerView, false);
	}

	@Test
	public void createPort() throws Exception {
		createFromPalette("blockdefinition.tool.port", containerView, false);
	}

	@Test
	public void createPrimitiveType() throws Exception {
		createFromPalette("blockdefinition.tool.primitivetype", containerView, true);
	}

	@Test
	public void createProperty() throws Exception {
		createFromPalette("blockdefinition.tool.property", containerView, false);
	}

	@Test
	public void createReception() throws Exception {
		createFromPalette("blockdefinition.tool.reception", containerView, false);
	}

	@Test
	public void createReference() throws Exception {
		createFromPalette("blockdefinition.tool.reference", containerView, false);
	}

	@Test
	public void createSignal() throws Exception {
		createFromPalette("blockdefinition.tool.signal", containerView, true);
	}

	@Test
	public void createSlot() throws Exception {
		createFromPalette("blockdefinition.tool.slot", containerView, false);
	}

	@Test
	public void createUnit() throws Exception {
		createFromPalette("blockdefinition.tool.unit", containerView, true);
	}

	@Test
	public void createValue() throws Exception {
		createFromPalette("blockdefinition.tool.value", containerView, false);
	}

	@Test
	public void createValueType() throws Exception {
		createFromPalette("blockdefinition.tool.valuetype", containerView, true);
	}
}
