/*****************************************************************************
 * Copyright (c) 2012, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 422257
 *  Christian W. Damus (CEA) - bug 434594
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.stereotypeproperty;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.PapyrusWrappingLabel;
import org.eclipse.papyrus.junit.utils.DisplayUtils;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.figure.node.AppliedStereotypeCompartmentFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.AutomaticCompartmentLayoutManager;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ClassifierFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.EditingFlowPage;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PackageFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.StereotypePropertiesCompartment;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayCommandExecution;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayConstant;
import org.eclipse.papyrus.uml.extensionpoints.profile.IRegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;
import org.eclipse.papyrus.uml.tools.commands.ApplyStereotypeCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Before;
import org.junit.Test;

/**
 * the purpose of this class is to test the layout on the Eclipse HIPP Hudson instance.
 *
 * FIXME : these tests will probably failed due to a difference on layout between Windows/Linux font definition
 */
public class TestLayoutWithStereotypeOnEclipseHIPPInstance extends AbstractPapyrusTestCase {

	protected static final String ST_LEFT = String.valueOf("\u00AB");

	protected static final String ST_RIGHT = String.valueOf("\u00BB");

	private static final String TEST_PROFILE_STEREOTYPE1 = "testProfile::Stereotype1";

	@Test
	public void testLayoutStereotypeApplicationOnClass() {
		testToCreateANode(UMLElementTypes.Class_2008);
	}

	@Test
	public void testLayoutStereotypeApplicationOnPackage() {
		testToCreateAPackage(UMLElementTypes.Package_2007);

	}

	/**
	 * Test to create a node.
	 *
	 * @param type
	 *            the type
	 */

	public void testToCreateANode(IElementType type) {

		// VARIABLES
		org.eclipse.uml2.uml.Class class1 = null;
		// stereotype that is applied on class1
		Stereotype stereotypeTest = null;
		// view of the class
		View notationClass1 = null;
		ClassifierFigure class1figure = null;
		// editpart of class1
		GraphicalEditPart classEditPart = null;
		// compartment of stereotype
		View appliedStereotypeCompartmentNotation = null;
		// compartment Shape
		View shapeCompartmentView = null;
		// the view of the applied stereotype property
		View stereotypePropertyView = null;
		GraphicalEditPart stereotypeCompartmentEdipart = null;
		GraphicalEditPart stereotypePropertyEdipart = null;


		// CREATION
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 0);

		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 1);
		// 1 element element due to the reference to the profile
		assertTrue(CREATION + INITIALIZATION_TEST, ((Model) getRootSemanticModel()).getAllAppliedProfiles().size() == 1);


		{// execution of the command
			CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getDiagramEditPart().getDiagramPreferencesHint());
			Command command = getDiagramEditPart().getCommand(requestcreation);
			assertNotNull(CREATION + COMMAND_NULL, command);
			assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
			assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
			assertTrue(CREATION + TEST_THE_EXECUTION, getRootView().getChildren().size() == 1);
		}



		// get the created Class
		class1 = (org.eclipse.uml2.uml.Class) ((org.eclipse.uml2.uml.Package) getRootSemanticModel()).getPackagedElement("Class1");
		assertNotNull("created class must be not null", class1);
		// look for the editpart that the class
		classEditPart = (ClassEditPart) getDiagramEditPart().getChildren().get(0);
		// test if stereotype can be applied
		assertTrue("stereotype1 must be applicable on class1", class1.getApplicableStereotype(TEST_PROFILE_STEREOTYPE1) != null);


		// look for the applied stereotype compartment
		notationClass1 = classEditPart.getNotationView();
		{// execution of the command
			SetBoundsCommand resizeCommand = new SetBoundsCommand(diagramEditor.getEditingDomain(), "resize", new EObjectAdapter(notationClass1), new Rectangle(0, 0, 200, 200));

			assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, resizeCommand.canExecute() == true);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(resizeCommand));
		}
		{// test about the layout
			org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure nodePlate = (org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure) ((BorderedNodeFigure) classEditPart.getFigure()).getChildren().get(0);
			// now verify position of each subfigure
			class1figure = ((ClassifierFigure) nodePlate.getChildren().get(0));
			class1figure.setBounds(new Rectangle(0, 0, 200, 200));
			assertEquals("The figure of class1 is not an automaticCompartmentLayoutManager", AutomaticCompartmentLayoutManager.class, class1figure.getLayoutManager().getClass());
			class1figure.getLayoutManager().layout(class1figure);
			assertDimension("The figure of the Class ", 0, 0, 200, 200, class1figure);

			// At this moment the class figure must contain 4 sub-figures 1label+ 3compartments
			assertEquals("The number of figure children must be equal to 5", 5, class1figure.getChildren().size());

			// wrappinglabel for name
			assertEquals("The sub figure [0] is not a wrapping label", PapyrusWrappingLabel.class, class1figure.getChildren().get(0).getClass());
			WrappingLabel labelClass = (WrappingLabel) class1figure.getChildren().get(0);
			assertDimension("The figure of the Class ", 0, 3, 200, 16, labelClass);
			assertEquals("The label of the Class does not display Class1", "Class1", labelClass.getText());

			assertEquals("The sub figure [0] is not a RectangleFigure", RectangleFigure.class, class1figure.getChildren().get(1).getClass());
			RectangleFigure propertiesClass = (RectangleFigure) class1figure.getChildren().get(1);
			assertEquals("The sub figure [0] is not the attribute compartment is not a ResizableCompartmentFigure", ResizableCompartmentFigure.class, propertiesClass.getChildren().get(0).getClass());

			// compartment for attribute
			assertDimension("The figure of the Class ", 0, 3, 200, 16, labelClass);


			// compartment for operation
			assertEquals("The figure of class1 is not an RectangleFigure", RectangleFigure.class, class1figure.getChildren().get(2).getClass());
			RectangleFigure operationsClass = (RectangleFigure) class1figure.getChildren().get(2);
			assertFigure("The figure of the Class", 0, 70, 200, 59, operationsClass, ResizableCompartmentFigure.class.toString());


			// compartment for nested classifier
			assertEquals("The figure of class1 is not an automaticCompartmentLayoutManager", RectangleFigure.class, class1figure.getChildren().get(3).getClass());
			RectangleFigure innerclassifiersClass = (RectangleFigure) class1figure.getChildren().get(3);
			assertFigure("The figure of the Class ", 0, 120, 200, 59, innerclassifiersClass, ResizableCompartmentFigure.class.toString());

		}

		{// execution of the application of the stereotype
			ArrayList<Stereotype> stereotypeslist = new ArrayList<Stereotype>();
			stereotypeslist.add(class1.getApplicableStereotype(TEST_PROFILE_STEREOTYPE1));
			ApplyStereotypeCommand applyStereotypeCommand = new ApplyStereotypeCommand(((Element) classEditPart.resolveSemanticElement()), stereotypeslist, diagramEditor.getEditingDomain());
			diagramEditor.getEditingDomain().getCommandStack().execute(applyStereotypeCommand);
			assertNotEquals("No applied stereotype found on the element ", 0, class1.getAppliedStereotypes().size());
		}


		appliedStereotypeCompartmentNotation = StereoUtil.getViewAppliedStereotypeCompartmentNotation2(notationClass1);
		shapeCompartmentView = StereoUtil.getViewShapeCompartment2(notationClass1);
		// for (int i = 0; i < notationClass1.getTransientChildren().size(); i++) {
		// View view = (View) notationClass1.getTransientChildren().get(i);
		// if (view.getType().equals(AppliedStereotypeCompartmentEditPart.ID)) {
		// appliedStereotypeCompartmentNotation = view;
		// }
		// if (view.getType().equals(IShapeCompartmentEditPart.VIEW_TYPE)) {
		// shapeCompartmentView = view;
		// }
		// }

		// the mechanism of stereotype display is running.
		// the thread is synchronous
		assertNotEquals("No stereotype Compartment found in the notation", null, appliedStereotypeCompartmentNotation);
		assertNotEquals("No stereotype  shape Compartment found in the notation", null, shapeCompartmentView);

		// now display stereotypes
		stereotypeTest = class1.getAppliedStereotypes().get(0);

		{// display stereotype1
			StereotypeDisplayCommandExecution.getInstance().setVisibility(diagramEditor.getEditingDomain(), appliedStereotypeCompartmentNotation, true, true);

			org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure nodePlate = (org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure) ((BorderedNodeFigure) classEditPart.getFigure()).getChildren().get(0);
			DisplayUtils.flushEventLoop();

			// get the label
			PapyrusWrappingLabel stereotypeLabel = ((ClassifierFigure) nodePlate.getChildren().get(0)).getStereotypesLabel();
			assertNotEquals("stereotype label must be not null", null, stereotypeLabel);
			assertEquals("text of stereotype label be equals to " + ST_LEFT + "stereotype1" + ST_RIGHT, stereotypeLabel.getText(), ST_LEFT + "Stereotype1" + ST_RIGHT);
		}

		{// test about the layout
			org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure nodePlate = (org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure) ((BorderedNodeFigure) classEditPart.getFigure()).getChildren().get(0);
			// now verify position of each subfigure
			class1figure = ((ClassifierFigure) nodePlate.getChildren().get(0));
			class1figure.setBounds(new Rectangle(0, 0, 200, 200));
			assertEquals("The figure of class1 is not an automaticCompartmentLayoutManager", AutomaticCompartmentLayoutManager.class, class1figure.getLayoutManager().getClass());
			class1figure.getLayoutManager().layout(class1figure);

			assertDimension("The figure of the Class ", 0, 0, 200, 200, class1figure);

			// At this moment the class figure must contain 5 sub-figures 1 label for stereotype+ 1label for name+ 3compartments
			assertEquals("The number of children «stereotype1»Class1 is not equals to 7", 7, class1figure.getChildren().size());


			// wrappingLabel for stereotype
			PapyrusWrappingLabel stereotypelabelClass = (PapyrusWrappingLabel) class1figure.getChildren().get(0);
			assertFigure("The figure of the «stereotype1»Class1 ", 0, 3, 200, 15, stereotypelabelClass, PapyrusWrappingLabel.class.toString());

			assertEquals("The label of the Class does not display " + ST_LEFT + "stereotype1" + ST_RIGHT, ST_LEFT + "Stereotype1" + ST_RIGHT, stereotypelabelClass.getText());

			// wrappingLabel for name
			assertEquals("The sub figure [1] of «stereotype1»Class1 is not a wrapping label", PapyrusWrappingLabel.class, class1figure.getChildren().get(1).getClass());
			WrappingLabel labelClass = (WrappingLabel) class1figure.getChildren().get(1);
			assertFigure("The figure of the «stereotype1»Class1 ", 0, 19, 200, 16, labelClass, WrappingLabel.class.toString());
			assertEquals("The label of the Class does not display Class1", "Class1", labelClass.getText());

			// compartment for property of stereotype
			assertEquals("The sub figure [0] of «stereotype1»Class1 is not a StereotypePropertiesCompartment", StereotypePropertiesCompartment.class, class1figure.getChildren().get(2).getClass());
			RectangleFigure stereotypePropertiesClass = (RectangleFigure) class1figure.getChildren().get(2);
			assertFigure("The sub figure [0] of «stereotype1»Class1  ", 0, 36, 200, 342, stereotypePropertiesClass, AppliedStereotypeCompartmentFigure.class.toString());

			// compartment for operation
			assertEquals("The sub figure [2] of «stereotype1»Class1 is not a RectangleFigure", RectangleFigure.class, class1figure.getChildren().get(3).getClass());
			RectangleFigure operationsClass = (RectangleFigure) class1figure.getChildren().get(3);
			assertFigure("The sub figure [2] is not the operation compartment", 0, 379, 200, -59, operationsClass, RectangleFigure.class.toString());

			// compartment for nested classifier
			assertEquals("The figure of class1 is not an automaticCompartmentLayoutManager", RectangleFigure.class, class1figure.getChildren().get(4).getClass());
			RectangleFigure innerclassifiersClass = (RectangleFigure) class1figure.getChildren().get(4);
			assertFigure("The sub figure [2] is not the operation compartment", 0, 321, 200, -59, innerclassifiersClass, RectangleFigure.class.toString());

		}


		{// test display of property of stereotype in compartment
			StereotypeDisplayCommandExecution.getInstance().setVisibility(diagramEditor.getEditingDomain(), appliedStereotypeCompartmentNotation, true, true);
			org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure nodePlate = (org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure) ((BorderedNodeFigure) classEditPart.getFigure()).getChildren().get(0);
			DisplayUtils.flushEventLoop();

			// the compartment must be visible
			assertEquals("the compartment must be visible", true, appliedStereotypeCompartmentNotation.isVisible());
			// look for view that represents the property of the applied stereotype
			// TODO flf
			stereotypePropertyView = (View) appliedStereotypeCompartmentNotation.getChildren().get(0);
			assertNotNull("the view of the applied stereotype property must be created", stereotypePropertyView);
			// look for the editpart that represents the property of applied stereotype
			stereotypeCompartmentEdipart = (GraphicalEditPart) classEditPart.getChildBySemanticHint(StereotypeDisplayConstant.STEREOTYPE_COMPARTMENT_TYPE);
			stereotypePropertyEdipart = (GraphicalEditPart) stereotypeCompartmentEdipart.getChildBySemanticHint(StereotypeDisplayConstant.STEREOTYPE_PROPERTY_TYPE);
			assertNotNull("the editpart of the applied stereotype compartment must be created", stereotypeCompartmentEdipart);
			assertNotNull("the editpart of the applied stereotype property must be created", stereotypePropertyEdipart);
			EditingFlowPage textarea = (EditingFlowPage) stereotypePropertyEdipart.getFigure();
			assertEquals("text of stereotype label be equals to «stereotype1» ", "testReftoStereotype2=[] ", ((TextFlowEx) textarea.getChildren().get(0)).getText());
		}

		{// test about the layout
			org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure nodePlate = (org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure) ((BorderedNodeFigure) classEditPart.getFigure()).getChildren().get(0);
			// now verify position of each subfigure
			class1figure = ((ClassifierFigure) nodePlate.getChildren().get(0));
			class1figure.setBounds(new Rectangle(0, 0, 200, 200));
			assertEquals("The figure of class1 is not an automaticCompartmentLayoutManager", AutomaticCompartmentLayoutManager.class, class1figure.getLayoutManager().getClass());
			class1figure.getLayoutManager().layout(class1figure);

			assertDimension("The figure of the Class ", 0, 0, 200, 200, class1figure);
			// At this moment the class figure must contain 5 sub-figures 1 label for stereotype+ 1label for name+ compartment of stereotypes+ 3compartments
			assertEquals("The number of children «stereotype1»Class1 is not equals to 7", 7, class1figure.getChildren().size());


			// label for stereotype
			assertEquals("The sub figure [0] of «stereotype1»Class1 is not a label", PapyrusWrappingLabel.class, class1figure.getChildren().get(0).getClass());
			PapyrusWrappingLabel stereotypelabelClass = (PapyrusWrappingLabel) class1figure.getChildren().get(0);
			assertEquals("The label of the Class does not display " + ST_LEFT + "stereotype1" + ST_RIGHT, ST_LEFT + "Stereotype1" + ST_RIGHT, stereotypelabelClass.getText());
			assertFigure("The figure of the Class ", 0, 3, 200, 15, stereotypelabelClass, PapyrusWrappingLabel.class.toString());


			// wrappingLabel for name
			assertEquals("The sub figure [1] of «stereotype1»Class1 is not a wrapping label", PapyrusWrappingLabel.class, class1figure.getChildren().get(1).getClass());
			PapyrusWrappingLabel labelClass = (PapyrusWrappingLabel) class1figure.getChildren().get(1);
			assertFigure("The figure of the Class ", 0, 19, 200, 16, labelClass, PapyrusWrappingLabel.class.toString());

			assertEquals("The label of the Class does not display Class1", "Class1", labelClass.getText());


			// compartment for property of stereotypes
			assertEquals("The sub figure [2] of «stereotype1»Class1 is not a compartment", StereotypePropertiesCompartment.class, class1figure.getChildren().get(2).getClass());
			StereotypePropertiesCompartment sterotypesPropertiesClass = (StereotypePropertiesCompartment) class1figure.getChildren().get(2);

			assertEquals("the stereotype properties compartment does not conent the compartment for a stereotype", AppliedStereotypeCompartmentFigure.class, sterotypesPropertiesClass.getChildren().get(0).getClass());
			AppliedStereotypeCompartmentFigure compartmentFigure = (AppliedStereotypeCompartmentFigure) sterotypesPropertiesClass.getChildren().get(0);
			assertEquals("The content of the sterotype properties compartment is not an EditingFlowPage", EditingFlowPage.class, compartmentFigure.getContentPane().getChildren().get(0).getClass());
			EditingFlowPage stereotypeProperty = (EditingFlowPage) compartmentFigure.getContentPane().getChildren().get(0);
			assertEquals("text of stereotype label be equals to «stereotype1» ", "testReftoStereotype2=[] ", ((TextFlowEx) stereotypeProperty.getChildren().get(0)).getText());
			assertFigure("The compartment property of stereotypes of the Class ", 0, 36, 200, 342, sterotypesPropertiesClass, EditingFlowPage.class.toString());

			// compartment for attribute
			assertEquals("The sub figure [3] of «stereotype1»Class1 is not a compartment", RectangleFigure.class, class1figure.getChildren().get(3).getClass());
			RectangleFigure propertiesClass = (RectangleFigure) class1figure.getChildren().get(3);
			assertFigure("The compartment attribute of the Class ", 0, 379, 200, -59, propertiesClass, RectangleFigure.class.toString());


			// compartment for operation
			assertEquals("The sub figure [4] of «stereotype1»Class1 is not a compartment", RectangleFigure.class, class1figure.getChildren().get(4).getClass());
			RectangleFigure operationsClass = (RectangleFigure) class1figure.getChildren().get(4);
			assertFigure("The compartment operation of the Class ", 0, 321, 200, -59, operationsClass, RectangleFigure.class.toString());

			// compartment for nested classifier
			assertEquals("The figure of class1 is not an automaticCompartmentLayoutManager", RectangleFigure.class, class1figure.getChildren().get(5).getClass());
			RectangleFigure innerclassifiersClass = (RectangleFigure) class1figure.getChildren().get(5);
			assertFigure("of the «stereotype1»Class1  ", 0, 263, 200, -59, innerclassifiersClass, RectangleFigure.class.toString());

		}
	}

	/**
	 * Test to create a node.
	 *
	 * @param type
	 *            the type
	 */
	public void testToCreateAPackage(IElementType type) {

		// VARIABLES
		org.eclipse.uml2.uml.Package package1 = null;
		// stereotype that is applied on class1
		Stereotype stereotypeTest = null;
		// view of the class
		View notationPackage1 = null;
		PackageFigure package1figure = null;
		// editpart of class1
		GraphicalEditPart packageEditPart = null;
		// compartment of stereotype
		View appliedStereotypeCompartmentNotation = null;
		// compartment Shape
		View shapeCompartmentView = null;
		// the view of the applied stereotype property
		View stereotypePropertyView = null;
		GraphicalEditPart stereotypeCompartmentEdipart = null;
		GraphicalEditPart stereotypePropertyEdipart = null;


		// CREATION
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 0);

		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 1);
		// 1 element element due to the reference to the profile
		assertTrue(CREATION + INITIALIZATION_TEST, ((Model) getRootSemanticModel()).getAllAppliedProfiles().size() == 1);


		{// execution of the command
			CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getDiagramEditPart().getDiagramPreferencesHint());
			Command command = getDiagramEditPart().getCommand(requestcreation);
			assertNotNull(CREATION + COMMAND_NULL, command);
			assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
			assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
			assertTrue(CREATION + TEST_THE_EXECUTION, getRootView().getChildren().size() == 1);
		}



		// get the created Class
		package1 = (org.eclipse.uml2.uml.Package) ((org.eclipse.uml2.uml.Package) getRootSemanticModel()).getPackagedElement("Package1");
		assertNotNull("created class must be not null", package1);
		// look for the editpart that the class
		packageEditPart = (PackageEditPart) getDiagramEditPart().getChildren().get(0);
		// test if stereotype can be applied
		assertTrue("stereotype1 must be applicable on class1", package1.getApplicableStereotype(TEST_PROFILE_STEREOTYPE1) != null);


		// look for the applied stereotype compartment
		notationPackage1 = packageEditPart.getNotationView();
		{// execution of the command
			SetBoundsCommand resizeCommand = new SetBoundsCommand(diagramEditor.getEditingDomain(), "resize", new EObjectAdapter(notationPackage1), new Rectangle(0, 0, 200, 200));

			assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, resizeCommand.canExecute() == true);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(resizeCommand));
		}
		{// test about the layout
			org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure nodePlate = (org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure) ((BorderedNodeFigure) packageEditPart.getFigure()).getChildren().get(0);
			// now verify position of each subfigure
			package1figure = ((PackageFigure) nodePlate.getChildren().get(0));
			package1figure.setBounds(new Rectangle(0, 0, 200, 200));
			assertTrue("The figure of package1 is not an automaticCompartmentLayoutManager", package1figure.getLayoutManager() instanceof AutomaticCompartmentLayoutManager);
			package1figure.getLayoutManager().layout(package1figure);
			assertDimension("of the «stereotype1»Class1  ", 0, 0, 200, 200, package1figure);

			// At this moment the class figure must contain 4 sub-figures 1label+ 3compartments
			assertEquals("The number of figure children must be equal to 4", 2, package1figure.getChildren().size());

			// wrappinglabel for name
			assertTrue("The sub figure [0] is not a wrapping label", package1figure.getChildren().get(0) instanceof WrappingLabel);
			WrappingLabel labelClass = (WrappingLabel) package1figure.getChildren().get(0);

			assertTrue("The label of the Class has not the good X coordinate", labelClass.getBounds().x == 0);// 1-->0
			assertTrue("The label of the Class has not the good Y coordinate", labelClass.getBounds().y == 3);
			assertEquals("The label of the Class has not the good width coordinate", 200, labelClass.getBounds().width);
			assertEquals("The label of the Class has not the good heightcoordinate", 18, labelClass.getBounds().height);// 16-->18
			// FLF
			// assertEquals("The label of the Class does not display Class1", labelClass.getText(), "Class1");

			assertTrue("The sub figure [0] is not a compartment", package1figure.getChildren().get(1) instanceof RectangleFigure);
			RectangleFigure propertiesClass = (RectangleFigure) package1figure.getChildren().get(1);
			assertTrue("The sub figure [0] is not the attribute compartment is not a ResizableCompartmentFigure", propertiesClass.getChildren().get(0) instanceof ResizableCompartmentFigure);

			// compartment for attribute
			assertDimension("of the «stereotype1»Class1  ", 0, 22, 200, 178, propertiesClass);

			// compartment for operation
			assertTrue("The figure of class1 is not an automaticCompartmentLayoutManager", package1figure.getChildren().get(1) instanceof RectangleFigure);
			RectangleFigure operationsClass = (RectangleFigure) package1figure.getChildren().get(1);
			assertTrue("The sub figure [0] is not the operation compartment is not a ResizableCompartmentFigure", operationsClass.getChildren().get(0) instanceof ResizableCompartmentFigure);
			assertDimension("of the «stereotype1»Class1  ", 0, 22, 200, 178, operationsClass);


			// compartment for nested classifier
			// TODO
			// assertEquals("The figure of class1 is not an automaticCompartmentLayoutManager", 2,package1figure.getChildren().size());
			// assertEquals("The figure of class1 is not an automaticCompartmentLayoutManager", RectangleFigure.class,package1figure.getChildren().get(3).getClass());
			// RectangleFigure innerclassifiersClass = (RectangleFigure) package1figure.getChildren().get(3);
			// assertEquals("The sub figure [0] is not the nested Classifier compartment is not a ResizableCompartmentFigure", innerclassifiersClass.getChildren().get(0) instanceof ResizableCompartmentFigure);
			// assertEquals("The compartment nested classifier of the Class has not the good X coordinate", innerclassifiersClass.getBounds().x == 0);//1-->0
			// assertEquals("The compartment nested classifier of the Class has not the good Y coordinate", 140, innerclassifiersClass.getBounds().y );
			// assertEquals("The compartment nested classifier of the Class has not the good width coordinate", 200, innerclassifiersClass.getBounds().width );
			// assertEquals("The compartment nested classifier of the Class has not the good Height coordinate", 59, innerclassifiersClass.getBounds().height);

		}

		{// execution of the application of the stereotype
			ArrayList<Stereotype> stereotypeslist = new ArrayList<Stereotype>();
			stereotypeslist.add(package1.getApplicableStereotype(TEST_PROFILE_STEREOTYPE1));
			ApplyStereotypeCommand applyStereotypeCommand = new ApplyStereotypeCommand(((Element) packageEditPart.resolveSemanticElement()), stereotypeslist, diagramEditor.getEditingDomain());
			diagramEditor.getEditingDomain().getCommandStack().execute(applyStereotypeCommand);
			assertNotEquals("No applied stereotype found on the element ", 0, package1.getAppliedStereotypes().size());
		}


		appliedStereotypeCompartmentNotation = StereoUtil.getViewAppliedStereotypeCompartmentNotation2(notationPackage1);
		shapeCompartmentView = StereoUtil.getViewShapeCompartment2(notationPackage1);
		// for (int i = 0; i < notationPackage1.getTransientChildren().size(); i++) {
		// View view = (View) notationPackage1.getTransientChildren().get(i);
		// if (view.getType().equals(AppliedStereotypeCompartmentEditPart.ID)) {
		// appliedStereotypeCompartmentNotation = view;
		// }
		// if (view.getType().equals(IShapeCompartmentEditPart.VIEW_TYPE)) {
		// shapeCompartmentView = view;
		// }
		// }

		// the mechanism of stereotype display is running.
		// the thread is synchronous
		assertNotEquals("No stereotype Compartment found in the notation", null, appliedStereotypeCompartmentNotation);
		assertNotEquals("No stereotype  shape Compartment found in the notation", null, shapeCompartmentView);

		// now display stereotypes
		stereotypeTest = package1.getAppliedStereotypes().get(0);

		{// display stereotype1
			StereotypeDisplayCommandExecution.getInstance().setVisibility(diagramEditor.getEditingDomain(), appliedStereotypeCompartmentNotation, true, true);

			org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure nodePlate = (org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure) ((BorderedNodeFigure) packageEditPart.getFigure()).getChildren().get(0);
			DisplayUtils.flushEventLoop();

			// get the label
			PapyrusWrappingLabel stereotypeLabel = ((PackageFigure) nodePlate.getChildren().get(0)).getStereotypesLabel();
			assertNotEquals("stereotype label must be not null", null, stereotypeLabel);
			assertEquals("text of stereotype label be equals to " + ST_LEFT + "stereotype1" + ST_RIGHT, ST_LEFT + "Stereotype1" + ST_RIGHT, stereotypeLabel.getText());
		}

		{// test about the layout
			org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure nodePlate = (org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure) ((BorderedNodeFigure) packageEditPart.getFigure()).getChildren().get(0);
			// now verify position of each subfigure
			package1figure = ((PackageFigure) nodePlate.getChildren().get(0));
			package1figure.setBounds(new Rectangle(0, 0, 200, 200));
			assertTrue("The figure of «stereotype1»Class1 is not an automaticCompartmentLayoutManager", package1figure.getLayoutManager() instanceof AutomaticCompartmentLayoutManager);
			package1figure.getLayoutManager().layout(package1figure);
			assertDimension("of the «stereotype1»Class1  ", 0, 0, 200, 200, package1figure);

			// At this moment the class figure must contain 5 sub-figures 1 label for stereotype+ 1label for name+ 3compartments
			assertEquals("The number of children «stereotype1»Class1 is not equals to 5", 5, package1figure.getChildren().size());


			// wrappingLabel for stereotype
			assertEquals("The sub figure [0] of «stereotype1»Class1 is not a label", PapyrusWrappingLabel.class, package1figure.getChildren().get(0).getClass());
			PapyrusWrappingLabel stereotypelabelClass = (PapyrusWrappingLabel) package1figure.getChildren().get(0);
			assertDimension("The figure of the Class", 0, 3, 200, 14, stereotypelabelClass);
			assertEquals("The label of the Class does not display " + ST_LEFT + "stereotype1" + ST_RIGHT, ST_LEFT + "Stereotype1" + ST_RIGHT, stereotypelabelClass.getText());


			// wrappingLabel for name
			assertTrue("The sub figure [1] of «stereotype1»Class1 is not a wrapping label", package1figure.getChildren().get(1) instanceof WrappingLabel);
			WrappingLabel labelPackage = (WrappingLabel) package1figure.getChildren().get(1);
			assertDimension("The figure of the  Class", 0, 18, 200, 18, labelPackage);
			assertEquals("The label of the Class does not display Class1", "Package1", labelPackage.getText());

			// compartment for property of stereotype
			assertEquals("The sub figure [2] of «stereotype1»Class1 is not a compartment", StereotypePropertiesCompartment.class, package1figure.getChildren().get(2).getClass());
			StereotypePropertiesCompartment stereotypePropertiesClass = (StereotypePropertiesCompartment) package1figure.getChildren().get(2);
			assertEquals("The sub figure [2] is not the attribute compartment is not a AppliedStereotypeCompartmentFigure", AppliedStereotypeCompartmentFigure.class, stereotypePropertiesClass.getChildren().get(0).getClass());
			assertFigure("The figure of the Class ", 0, 40, 200, 342, stereotypePropertiesClass, AppliedStereotypeCompartmentFigure.class.toString());

			// compartment attribute
			assertEquals("The sub figure [3] of «stereotype1»Class1 is not a compartment", RectangleFigure.class, package1figure.getChildren().get(3).getClass());
			RectangleFigure propertiesClass = (RectangleFigure) package1figure.getChildren().get(3);

			// FIXME was:<class org.eclipse.gmf.tooling.runtime.linklf.LinkLFShapeCompartmentEditPart$ShapeCompartmentFigureEx>
			// assertEquals("The sub figure [3] is not the attribute compartment is not a LinkLFShapeCompartmentEditPart", LinkLFShapeCompartmentEditPart.class,propertiesClass.getChildren().get(0).getClass());
			// assertDimension("The figure of the Class ", 0,383,200,-181,propertiesClass);


			// compartment for operation
			// TODO assertEquals("The sub figure [4] of «stereotype1»Class1 is not a compartment", AppliedStereotypeEmptyEditPart.class,package1figure.getChildren().get(4).getClass());
			// RectangleFigure operationsClass = (RectangleFigure) package1figure.getChildren().get(4);
			// assertEquals("The sub figure [4] is not the operation compartment is not a ResizableCompartmentFigure", ResizableCompartmentFigure.class,operationsClass.getChildren().get(0).getClass());
			// assertDimension("The figure of the Class ", 0,91,200,54,operationsClass);
			// assertFigure("The figure of the Class ", 0,0,0,0,(Figure)package1figure.getChildren().get(4), ResizableCompartmentFigure.class.toString());

			// compartment for nested classifier


		}





		{// test display of property of stereotype in compartment
			// RecordingCommand displayPropertyStereotypeCommand = AppliedStereotypeHelper.getAddAppliedStereotypePropertiesCommand(diagramEditor.getEditingDomain(), notationPackage1, stereotypeTest.getQualifiedName() + ".testInt");
			// diagramEditor.getEditingDomain().getCommandStack().execute(displayPropertyStereotypeCommand);
			StereotypeDisplayCommandExecution.getInstance().setVisibility(diagramEditor.getEditingDomain(), appliedStereotypeCompartmentNotation, true, true);
			org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure nodePlate = (org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure) ((BorderedNodeFigure) packageEditPart.getFigure()).getChildren().get(0);
			DisplayUtils.flushEventLoop();


			// the compartment must be visible
			assertEquals("the compartment must be visible", true, appliedStereotypeCompartmentNotation.isVisible());
			// look for view that represents the property of the applied stereotype
			stereotypePropertyView = (View) appliedStereotypeCompartmentNotation.getChildren().get(0);
			assertNotNull("the view of the applied stereotype property must be created", stereotypePropertyView);
			// look for the editpart that represents the property of applied stereotype

			stereotypeCompartmentEdipart = (GraphicalEditPart) packageEditPart.getChildBySemanticHint(StereotypeDisplayConstant.STEREOTYPE_COMPARTMENT_TYPE);
			stereotypePropertyEdipart = (GraphicalEditPart) stereotypeCompartmentEdipart.getChildBySemanticHint(StereotypeDisplayConstant.STEREOTYPE_PROPERTY_TYPE);
			assertNotNull("the editpart of the applied stereotype compartment must be created", stereotypeCompartmentEdipart);
			assertNotNull("the editpart of the applied stereotype property must be created", stereotypePropertyEdipart);
			EditingFlowPage textarea = (EditingFlowPage) stereotypePropertyEdipart.getFigure();
			assertEquals("text of stereotype label be equals to «stereotype1» ", "testReftoStereotype2=[] ", ((TextFlowEx) textarea.getChildren().get(0)).getText());
		}

		{// test about the layout
			org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure nodePlate = (org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure) ((BorderedNodeFigure) packageEditPart.getFigure()).getChildren().get(0);
			// now verify position of each subfigure
			package1figure = ((PackageFigure) nodePlate.getChildren().get(0));
			package1figure.setBounds(new Rectangle(0, 0, 200, 200));
			assertTrue("The figure of «stereotype1»Class1 is not an automaticCompartmentLayoutManager", package1figure.getLayoutManager() instanceof AutomaticCompartmentLayoutManager);
			package1figure.getLayoutManager().layout(package1figure);

			// assertDimension(0,0,200,200,package1figure);


			// At this moment the class figure must contain 5 sub-figures 1 label for stereotype+ 1label for name+ compartment of stereotypes+ 3compartments
			assertEquals("The number of children «stereotype1»Class1 is not equals to 5", 5, package1figure.getChildren().size());


			// label for stereotype
			assertEquals("The sub figure [0] of «stereotype1»Class1 is not a label", PapyrusWrappingLabel.class, package1figure.getChildren().get(0).getClass());
			PapyrusWrappingLabel stereotypelabelClass = (PapyrusWrappingLabel) package1figure.getChildren().get(0);
			// assertDimension("The figure of the Class ", 0,3,200,17,stereotypelabelClass);
			assertEquals("The label of the Class does not display " + ST_LEFT + "stereotype1" + ST_RIGHT, ST_LEFT + "Stereotype1" + ST_RIGHT, stereotypelabelClass.getText());


			// wrappingLabel for name
			assertEquals("The sub figure [1] of «stereotype1»Class1 is not a wrapping label", PapyrusWrappingLabel.class, package1figure.getChildren().get(1).getClass());
			PapyrusWrappingLabel labelClass = (PapyrusWrappingLabel) package1figure.getChildren().get(1);
			// assertDimension("The figure of the Class ", 0,21,200,18,labelClass);
			assertEquals("The label of the Class does not display Class1", "Package1", labelClass.getText());


			// compartment for property of stereotypes
			assertEquals("The sub figure [2] of «stereotype1»Class1 is not a compartment", StereotypePropertiesCompartment.class, package1figure.getChildren().get(2).getClass());
			StereotypePropertiesCompartment sterotypesPropertiesClass = (StereotypePropertiesCompartment) package1figure.getChildren().get(2);

			assertEquals("the stereotype properties compartment does not conent the compartment for a stereotype", AppliedStereotypeCompartmentFigure.class, sterotypesPropertiesClass.getChildren().get(0).getClass());
			AppliedStereotypeCompartmentFigure compartmentFigure = (AppliedStereotypeCompartmentFigure) sterotypesPropertiesClass.getChildren().get(0);
			assertEquals("The content of the sterotype properties compartment is not an EditingFlowPage", EditingFlowPage.class, compartmentFigure.getContentPane().getChildren().get(0).getClass());
			EditingFlowPage stereotypeProperty = (EditingFlowPage) compartmentFigure.getContentPane().getChildren().get(0);
			assertEquals("text of stereotype label be equals to «stereotype1» ", "testReftoStereotype2=[] ", ((TextFlowEx) stereotypeProperty.getChildren().get(0)).getText());
			// assertDimension("The figure of the Class ", 0,40,200,342,sterotypesPropertiesClass);

			// compartment for attribute
			assertEquals("The sub figure [3] of «stereotype1»Class1 is not a compartment", RectangleFigure.class, package1figure.getChildren().get(3).getClass());
			RectangleFigure propertiesClass = (RectangleFigure) package1figure.getChildren().get(3);
			// FIXME was:<class org.eclipse.gmf.tooling.runtime.linklf.LinkLFShapeCompartmentEditPart$ShapeCompartmentFigureEx>
			// assertEquals("The sub figure [0] is not the attribute compartment is not a ResizableCompartmentFigure", ShapeCompartmentFigure.class, propertiesClass.getChildren().get(0).getClass());
			// assertDimension("The figure of the Class ", 0,383,200,-181,propertiesClass);


			// compartment for operation
			// FIXME AppliedStereotypeEmptyEditPart
			/*
			 * assertEquals("The sub figure [4] of «stereotype1»Class1 is not a compartment", AppliedStereotypeEmptyEditPart.class,package1figure.getChildren().get(4).getClass() );
			 * RectangleFigure operationsClass = (RectangleFigure) package1figure.getChildren().get(4);
			 * assertEquals("The sub figure [0] is not the operation compartment is not a ResizableCompartmentFigure", ResizableCompartmentFigure.class,operationsClass.getChildren().get(0).getClass() );
			 * assertDimension("The figure of the Class ", 0,126,200,37,operationsClass);
			 */

		}
	}


	/**
	 * @param string
	 * @param x
	 * @param y
	 * @param w
	 * @param l
	 * @param figure
	 * @param class1
	 */
	private void assertFigure(String msgHeader, int x, int y, int w, int l, Figure figure, String class1) {
		// assertDimension(msgHeader, x,y,w,l,figure);
		assertEquals("The sub figure [0] of the nested Classifier compartment is not a " + class1, class1, figure.getChildren().get(0).getClass().toString());
	}

	/**
	 * @param i
	 * @param j
	 * @param k
	 * @param l
	 * @param figure
	 */
	private void assertDimension(int x, int y, int w, int h, Figure figure) {
		assertDimension("The figure ", x, y, w, h, figure);
	}

	/**
	 * @param i
	 * @param j
	 * @param k
	 * @param l
	 * @param figure
	 */
	private void assertDimension(String msgHeader, int x, int y, int w, int h, Figure figure) {
		assertEquals(msgHeader + " has not the good X coordinate", x, figure.getBounds().x);
		assertEquals(msgHeader + " has not the good Y coordinate", y, figure.getBounds().y);
		assertEquals(msgHeader + " has not the good width coordinate", w, figure.getBounds().width);
		assertEquals(msgHeader + " has not the good height coordinate", h, figure.getBounds().height);
	}

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		IRegisteredProfile registeredProfile = RegisteredProfile.getRegisteredProfile("TestProfile");
		final Model root = ((Model) getDiagramEditPart().resolveSemanticElement());
		URI modelUri = registeredProfile.getUri();
		final Resource modelResource = EMFHelper.getResourceSet(root).getResource(modelUri, true);
		final Profile profile = (Profile) modelResource.getContents().get(0);
		// PackageUtil.applyProfile(root,profile, false);
		final TransactionalEditingDomain domain = ServiceUtils.getInstance().getTransactionalEditingDomain(papyrusEditor.getServicesRegistry());
		AppliedProfileCommand appliedProfileCommand = new AppliedProfileCommand(domain, root, profile);
		domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(appliedProfileCommand));


	}
}
