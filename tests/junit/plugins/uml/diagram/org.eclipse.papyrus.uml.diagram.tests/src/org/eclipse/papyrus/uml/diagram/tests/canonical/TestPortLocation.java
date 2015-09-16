package org.eclipse.papyrus.uml.diagram.tests.canonical;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GMFtoGEFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.common.locator.PortPositionLocator;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Assert;

public abstract class TestPortLocation extends AbstractPapyrusTestCase {

	protected abstract IElementType getPortType();

	protected void testPortLocation(IElementType container) {
		testPortLocation(container, 0, null);
	}

	protected void testPortLocation(IElementType container, int containerCompartmentVisualId, IElementType child) {
		IGraphicalEditPart parentEP = createChild(getDiagramEditPart(), container);
		EObject containerSemantic = parentEP.resolveSemanticElement();
		if (containerCompartmentVisualId > 0) {
			parentEP = findChildBySemanticHint(parentEP, containerCompartmentVisualId);
		}
		if (child != null) {
			parentEP = createChild(parentEP, child);
			EObject parentSemantic = parentEP.resolveSemanticElement();
			if (parentSemantic instanceof Property) {
				SetValueCommand setPropertyTypeCommand = new SetValueCommand(new SetRequest(parentSemantic, UMLPackage.eINSTANCE.getTypedElement_Type(), containerSemantic));
				executeOnUIThread(new GMFtoGEFCommandWrapper(setPropertyTypeCommand));
			}
		}
		parentEP.getFigure().setBounds(new Rectangle(new Point(0, 0), new Dimension(200, 200)));
		IGraphicalEditPart portEP = createChild(parentEP, getPortType(), new Point(50, 0));
		PortPositionLocator portPositionLocator = getConstraint(portEP);
		assertNotNull(portPositionLocator);
		assertNotNull(portPositionLocator.getConstraint());
		Assert.assertEquals(new Point(50, -10), portPositionLocator.getConstraint().getLocation());
	}

	private IGraphicalEditPart findChildBySemanticHint(IGraphicalEditPart parent, int vid) {
		IGraphicalEditPart childEP = parent.getChildBySemanticHint(Integer.toString(vid));
		assertNotNull("Parent " + parent + ", type " + parent.getNotationView() + " looking for: " + vid, childEP);
		return childEP;
	}

	private PortPositionLocator getConstraint(IGraphicalEditPart portEP) {
		if (false == portEP.getModel() instanceof View) {
			return null;
		}
		Object constraint = ((AbstractBorderedShapeEditPart) portEP.getParent()).getBorderedFigure().getBorderItemContainer().getLayoutManager().getConstraint(portEP.getFigure());
		if (false == constraint instanceof PortPositionLocator) {
			return null;
		}
		return (PortPositionLocator) constraint;
	}

	private IGraphicalEditPart createChild(IGraphicalEditPart container, IElementType childType) {
		return createChild(container, childType, new Point(0, 0));
	}

	private IGraphicalEditPart createChild(IGraphicalEditPart container, IElementType childType, Point location) {
		final CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(childType, container.getDiagramPreferencesHint());
		@SuppressWarnings("unchecked")
		Map<Object, Object> params = requestcreation.getExtendedData();
		params.put(AspectUnspecifiedTypeCreationTool.INITIAL_MOUSE_LOCATION_FOR_CREATION, location);
		requestcreation.setSize(new Dimension(10, 10));
		requestcreation.setLocation(location);
		Command command = container.getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute());
		executeOnUIThread(command);
		EditPart createdEditPart = (EditPart) container.getChildren().get((container.getChildren().size() - 1));
		Assert.assertNotNull("The editpart must be created", createdEditPart); //$NON-NLS-1$
		Assert.assertTrue(createdEditPart instanceof IGraphicalEditPart);
		return (IGraphicalEditPart) createdEditPart;
	}
}
