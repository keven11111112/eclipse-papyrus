/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug.pro20130916;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.stereotype.StereotypeDisplayHelper;
import org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class BaseStereotypesTest extends AbstractNodeTest {

	private static final URI SYSML_PROFILE = URI.createURI("pathmap://SysML_PROFILES/SysML.profile.uml");

	private StereotypeDisplayHelper helper = StereotypeDisplayHelper.getInstance();

	protected void prepareStereotypes(EditPart editPart) {
		assertNotNull("editPart", editPart);
		View view = getDiagramElement(editPart);
		assertNotNull("view", view);
		Element element = getElement(editPart);
		assertNotNull("element", element);
		Stereotype appliedStereotype = applyStereotype(editPart);
		assertNotNull("appliedStereotype", appliedStereotype);
		waitForComplete();
	}

	protected void doTestDisplayStereotypeInCompartment(EditPart editPart, EditPart stereotypeEditPart) {

		// Check Label Figure
		if (stereotypeEditPart == null) {
			stereotypeEditPart = editPart;
		}

		prepareStereotypes(editPart);

		final View view = ((GraphicalEditPart) editPart).getNotationView();
		final View stereotypeLabelView = ((GraphicalEditPart) stereotypeEditPart).getNotationView();

		String labelName = "";
		if (helper.getStereotypeLabel(stereotypeLabelView, "SysML::Allocations::Allocated") != null) {
			labelName = helper.getStereotypeTextToDisplay(stereotypeLabelView);
		} else if (helper.getStereotypeLabel(view, "SysML::Allocations::Allocated") != null) {
			labelName = helper.getStereotypeTextToDisplay(view);

		}


		assertTrue("Label Name", labelName.equals(Activator.ST_LEFT + "Allocated" + Activator.ST_RIGHT) ||
				labelName.equals(Activator.ST_LEFT + "SysML::Allocations::Allocated" + Activator.ST_RIGHT));


		IFigure stereotypeFigure = null;
		IFigure primaryShape = null;
		if (stereotypeEditPart instanceof IPapyrusEditPart) {
			primaryShape = ((IPapyrusEditPart) stereotypeEditPart).getPrimaryShape();
		} else if (stereotypeEditPart instanceof org.eclipse.gef.GraphicalEditPart) {
			primaryShape = ((org.eclipse.gef.GraphicalEditPart) stereotypeEditPart).getFigure();
		}
		if (primaryShape instanceof IPapyrusNodeUMLElementFigure) {
			stereotypeFigure = ((IPapyrusNodeUMLElementFigure) primaryShape).getStereotypesLabel();
		}
		assertNotNull(stereotypeFigure);
		String actualValue = getFigureText(stereotypeFigure);
		assertEquals("stereotype displayed in Compartment", labelName, actualValue);



		// Check Compartment Figure
		Stereotype stereotype = getElement(editPart).getAppliedStereotype("SysML::Allocations::Allocated");
		assertNotNull(stereotype);
		View compartment = helper.getStereotypeCompartment(view, stereotype);

		List children = editPart.getChildren();
		EditPart compartmentEditPart = null;
		for (Object child : children) {
			if (compartment != null) {
				if (compartment.equals(((EditPart) child).getModel())) {
					compartmentEditPart = (EditPart) child;
				}
			}
		}

		if (compartmentEditPart != null) {
			IFigure figure = findLabelFigure(getFigure(compartmentEditPart), labelName);
			assertNotNull(figure);
		}


	}

	protected String getFigureText(IFigure figure) {
		if (figure instanceof Label) {
			return ((Label) figure).getText();
		} else if (figure instanceof WrappingLabel) {
			return ((WrappingLabel) figure).getText();
		} else if (figure instanceof ILabelFigure) {
			return ((ILabelFigure) figure).getText();
		} else if (figure instanceof TextFlow) {
			return ((TextFlow) figure).getText();
		}
		return null;
	}

	protected void doTestDisplayStereotypeWithBrace(EditPart editPart, EditPart stereotypeEditPart) {
		if (stereotypeEditPart == null) {
			stereotypeEditPart = editPart;
		}
		prepareStereotypes(editPart);
		final View diagramElement = getDiagramElement(stereotypeEditPart);
		View brace = null;
		// doCheck
		StereotypeDisplayHelper helper = StereotypeDisplayHelper.getInstance();
		for (Object child : diagramElement.getChildren()) {
			if (helper.isStereotypeBrace(child)) {
				brace = (View) child;
			}
		}


		assertNotNull("Brace Compartment", brace);
	}

	private IFigure findLabelFigure(IFigure figure, String labelText) {
		if (figure == null || labelText == null) {
			return null;
		}
		String value = getFigureText(figure);
		if (labelText.equals(value)) {
			return figure;
		}
		List children = figure.getChildren();
		for (Object object : children) {
			IFigure child = (IFigure) object;
			IFigure fig = findLabelFigure(child, labelText);
			if (fig != null) {
				return fig;
			}
		}
		return null;
	}

	private IFigure getFigure(EditPart editPart) {
		if (editPart instanceof org.eclipse.gef.GraphicalEditPart) {
			return ((org.eclipse.gef.GraphicalEditPart) editPart).getFigure();
		}
		return null;
	}

	protected void doTestDisplayStereotypeComment(EditPart editPart) {
		prepareStereotypes(editPart);
		final View diagramElement = getDiagramElement(editPart);

		// doCheck
		waitForComplete();
		Node commentNode = getAppliedStereotypeCommentNode(diagramElement);
		assertNotNull("commentNode", commentNode);
	}

	protected Node getAppliedStereotypeCommentNode(View semanticView) {
		if (semanticView == null) {
			return null;
		}
		Edge appliedStereotypeLink = null;
		// look for all links with the id AppliedStereotypesCommentLinkEditPart.ID
		@SuppressWarnings("unchecked")
		Iterator<Edge> edgeIterator = semanticView.getSourceEdges().iterator();
		while (edgeIterator.hasNext()) {
			Edge edge = edgeIterator.next();
			if (edge.getType().equals("StereotypeCommentLink")) {
				appliedStereotypeLink = edge;
			}

		}
		if (appliedStereotypeLink == null) {
			return null;
		}
		return (Node) appliedStereotypeLink.getTarget();

	}

	protected Stereotype applyStereotype(EditPart editPart) {
		assertNotNull("editPart", editPart);
		final Element element = getElement(editPart);
		assertNotNull("element", element);
		Model model = getModel(element);
		assertNotNull("model", model);
		Profile profile = applyProfile(model);
		assertNotNull("profile", profile);
		final View diagramElement = getDiagramElement(editPart);
		EList<PackageableElement> packagedElements = profile.getPackagedElements();
		for (PackageableElement elt : packagedElements) {
			if (elt instanceof Stereotype) {
				final Stereotype stereotype = (Stereotype) elt;
				if (!element.isStereotypeApplicable(stereotype)) {
					continue;
				}
				Stereotype appliedStereotype = element.getAppliedStereotype(stereotype.getQualifiedName());
				if (appliedStereotype == null) {
					// Apply the stereotype if possible.
					getCommandStack().execute(new RecordingCommand(getEditingDomain()) {

						@Override
						protected void doExecute() {
							element.applyStereotype(stereotype);
						}
					});
					appliedStereotype = element.getAppliedStereotype(stereotype.getQualifiedName());
					// Display current stereotype
					String presentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(diagramElement);
					getCommandStack().execute(AppliedStereotypeHelper.getAddAppliedStereotypeCommand(getEditingDomain(), diagramElement, appliedStereotype.getQualifiedName(), presentationKind));
					if (appliedStereotype != null) {
						// Display all properties of it.
						Iterator<Property> propIt = appliedStereotype.getAllAttributes().iterator();
						while (propIt.hasNext()) {
							final Property currentProp = propIt.next();
							boolean adding = false;
							// Select authorized properties
							if (currentProp.getAssociation() != null) {
								if (!currentProp.getName().startsWith("base_")) {
									adding = true;
								}
							} else {
								adding = true;
							}
							if (adding) {
								String appliedStereotypeListToAdd = stereotype.getQualifiedName() + "." + currentProp.getName();
								RecordingCommand command = AppliedStereotypeHelper.getAddAppliedStereotypePropertiesCommand(getEditingDomain(), diagramElement, appliedStereotypeListToAdd);
								getCommandStack().execute(command);
							}
						}
					}
				}
				return appliedStereotype;
			}
		}
		return null;
	}

	protected Profile applyProfile(final Model model) {
		ResourceSet resourceSet = model.eResource().getResourceSet();
		Resource resource = resourceSet.getResource(SYSML_PROFILE, true);
		Profile profileToApply = null;
		if (!resource.getContents().isEmpty()) {
			EObject eObject = resource.getContents().get(0);
			if (eObject instanceof Profile) {
				profileToApply = (Profile) eObject;
			}
		}
		assertNotNull("profileToApply", profileToApply);
		final Profile allocationsProfile = (Profile) profileToApply.getPackagedElement("Allocations");
		assertNotNull("allocationsProfile", allocationsProfile);
		getCommandStack().execute(new RecordingCommand(getEditingDomain()) {

			@Override
			protected void doExecute() {
				PackageUtil.applyProfile(model, allocationsProfile, true);
			}
		});
		return allocationsProfile;
	}

	protected View getDiagramElement(EditPart editPart) {
		if (editPart == null) {
			return null;
		}
		Object model = editPart.getModel();
		if (model instanceof View) {
			return (View) model;
		}
		return null;
	}

	protected Element getElement(EditPart editPart) {
		View diagramElement = getDiagramElement(editPart);
		if (diagramElement == null) {
			return null;
		}
		return (Element) ViewUtil.resolveSemanticElement(diagramElement);
	}

	protected Model getModel(EObject obj) {
		if (obj instanceof Model) {
			return (Model) obj;
		}
		EObject parent = obj.eContainer();
		while (parent != null && !(parent instanceof Model)) {
			parent = parent.eContainer();
		}
		return (Model) parent;
	}



	/**
	 * test apply profile to model and apply stereotype to a EditPart.
	 */
	protected void innerTestApplyProfile() {
		DiagramEditPart diagram = getDiagramEditPart();
		assertNotNull("diagram", diagram);
		Stereotype stereotype = applyStereotype(diagram);
		assertNotNull("appliedStereotype", stereotype);
	}

	public void checkConnectionHorizontally(ConnectionNodeEditPart conn, int tolerance) {
		assertNotNull("connection", conn);
		Point start = SequenceUtil.getAbsoluteEdgeExtremity(conn, true);
		Point end = SequenceUtil.getAbsoluteEdgeExtremity(conn, false);
		int distance = Math.abs(start.y - end.y);
		assertTrue("connection horizontally (" + distance + ")", distance <= tolerance);
	}

}
