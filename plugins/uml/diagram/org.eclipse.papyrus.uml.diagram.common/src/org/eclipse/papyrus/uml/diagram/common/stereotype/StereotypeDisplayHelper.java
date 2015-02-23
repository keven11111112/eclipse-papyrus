/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Céline Janssens (ALL4TEC) celine.janssens@all4tec.net - Initial API and implementation (Bug 455311)
 *   Céline Janssens (ALL4TEC) celine.janssens@all4tec.net - Bug 455311 : Refactor Stereotypes Display
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.stereotype;

import java.util.Iterator;
import java.util.StringTokenizer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.SetNodeVisibilityCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.GMFUnsafe;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This Helper contains all the Methods required in the using of Stereotype Display thanks
 * to the Notation View structure
 * 
 * @author Céline JANSSENS
 *
 */
public class StereotypeDisplayHelper {

	/**
	 * singleton instance
	 */
	private static StereotypeDisplayHelper labelHelper;

	/**
	 * Returns the singleton instance of this class
	 *
	 * @return the singleton instance.
	 */
	public static StereotypeDisplayHelper getInstance() {
		if (labelHelper == null) {
			labelHelper = new StereotypeDisplayHelper();
		}
		return labelHelper;
	}

	private static final String EMPTY_STRING = ""; // $NON-NLS-1$

	/**
	 * Get the Full label to display into the header
	 * 
	 * @param model
	 *            The corresponding View
	 * @return The label with Stereotype Name to display (i.e: "Blocks::Block, Allocation, SysML::Requirements::Requirement" )
	 */
	public String getStereotypeTextToDisplay(View model) {
		String textToDisplay = null;
		String finalText = null;
		Iterator<?> iter = model.getChildren().iterator();
		Object object;
		DecorationNode label;
		// For all children, check if it's a StereotypeLabel and add the Name
		while (iter.hasNext()) {
			object = iter.next();
			if (object instanceof DecorationNode) {
				label = (DecorationNode) object;

				if (StereotypeDisplayUtils.STEREOTYPE_LABEL_TYPE.equals(label.getType())) {
					if (label.isVisible()) {
						textToDisplay = addStereotypeName(textToDisplay, label, model);
					}
				}
			}
		}

		// Then add the ornament around the text.
		if ((textToDisplay != null) && (!EMPTY_STRING.equals(textToDisplay))) {
			finalText = StereotypeDisplayUtils.BRACE_LEFT + textToDisplay + StereotypeDisplayUtils.BRACE_RIGHT;
		}

		// Return the text or null if empty
		return finalText;
	}


	/**
	 * Get the entire String to display between braces.
	 * 
	 * @param notationView
	 *            The View of the Element on which the Stereotype has been applied.
	 * @param inComment
	 *            if this is the Property in the comment
	 * 
	 * @return The entire string to be displayed in braces
	 */
	public String getStereotypePropertiesInBrace(View notationView) {
		String textToDisplay = null;
		Iterator<?> iter = notationView.getChildren().iterator();
		Object object;
		// For each Stereotype Compartment, retrieve the property text to be added in Braces
		while (iter.hasNext()) {
			object = iter.next();
			if (isStereotypeCompartment(object)) {
				BasicCompartment compartment = (BasicCompartment) object;

				textToDisplay = addStereotypeCompartmentProperties(textToDisplay, compartment);

			}
		}
		return textToDisplay;
	}

	/**
	 * Add the Stereotype Name to the text to display.
	 * 
	 * @param textToDisplay
	 *            The actual string before adding the new Stereotype Name
	 * @param label
	 *            The StereotypeLabel of the new stereotype to added
	 * @param model
	 * 
	 * @return The String with the new StereotypeName and
	 */
	protected String addStereotypeName(String textToDisplay, DecorationNode label, View model) {
		String newTextToDisplay = textToDisplay;
		if (!EMPTY_STRING.equals(newTextToDisplay) && (newTextToDisplay != null)) {
			newTextToDisplay = (newTextToDisplay + StereotypeDisplayUtils.STEREOTYPE_LABEL_SEPARATOR);
		}
		// Retrieve Name and Depth from CSS or NamedStyle
		String name = getName(label);
		String depth = getDepth(label);

		// Compute name according to the depth
		String nameWithDepth = getStereotypeNameWithDepth(name, depth);
		newTextToDisplay = ((newTextToDisplay == null ? EMPTY_STRING : newTextToDisplay) + nameWithDepth);
		return newTextToDisplay;
	}


	/**
	 * Retrieve the Stereotype Name with its appropriate depth
	 * 
	 * @param text
	 *            The full name of the Stereotype (i.e: "SysML::Blocks::Block")
	 * @param depth
	 *            The Depth value (i.e: "-1" )
	 * @return The stereotype Name with the proper Depth (i.e: "Blocks::Block")
	 */
	protected String getStereotypeNameWithDepth(String qualifiedName, String depth) {

		if (depth != null && !EMPTY_STRING.equals(depth)) {
			if (StereotypeDisplayUtils.DEPTH_MIN.equals(depth)) {
				return getMinimumDepthName(qualifiedName);
			} else if (StereotypeDisplayUtils.DEPTH_MAX.equals(depth)) {
				return qualifiedName;
			} else if (StereotypeDisplayUtils.DEPTH_AUTO.equals(depth)) {
				// TODO to be computed
				return qualifiedName;
			} else {
				// In case the depth retrieve is a number
				try {
					int depthRetrieve = Integer.parseInt(depth);
					// Case the number is coherent
					if (depthRetrieve > -getMaxDepth(qualifiedName) && depthRetrieve < 0) {
						// Nominal Case (i.e : Depth = -1 => Compute the name accordingly)
						return computeDepthName(depthRetrieve, qualifiedName);
					} else if (depthRetrieve <= -getMaxDepth(qualifiedName)) {
						// Depth is too Small (i.e : -24 ) => Return the last segment
						return getMinimumDepthName(qualifiedName);
					} else if (depthRetrieve == 0) {
						// Depth is null => return the full name
						return qualifiedName;
					} else {
						// in all other cases return the full name
						return qualifiedName;
					}

				} catch (NumberFormatException e) {
					Activator.log.error("Wrong Depth value. Impossible to parse depth : " + depth, e);
				}
			}
		}
		return qualifiedName;
	}

	/**
	 * If the retrieve Depth is an appropriate number , compute the Name accordingly.
	 * 
	 * @param depthRetrieve
	 *            The depth retrieved (should be negative)
	 * @param qualifiedName
	 *            The Full Qualified Name
	 * @return the Name computed with the appropriate Depth
	 */
	protected String computeDepthName(int depthRetrieve, String qualifiedName) {

		StringBuffer name = new StringBuffer(qualifiedName);
		try {
			for (int i = 0; i > depthRetrieve; i--) {
				int index = name.indexOf(StereotypeDisplayUtils.STEREOTYPE_LABEL_DEPTH_SEPARATOR);
				name = name.delete(0, index + StereotypeDisplayUtils.STEREOTYPE_LABEL_DEPTH_SEPARATOR.length());
			}

		} catch (IndexOutOfBoundsException e) {
			Activator.log.error(e.getMessage(), e);
		}
		return name.toString();
	}

	/**
	 * Get the last segment of the full qualifiedName.
	 * 
	 * @param qualifiedName
	 *            The full path name
	 * @return The Last segment of the path.
	 */
	public String getMinimumDepthName(String qualifiedName) {
		String segment = EMPTY_STRING;
		StringBuffer name = new StringBuffer(qualifiedName);
		int index = name.lastIndexOf(StereotypeDisplayUtils.STEREOTYPE_LABEL_DEPTH_SEPARATOR);
		segment = name.substring(index + StereotypeDisplayUtils.STEREOTYPE_LABEL_DEPTH_SEPARATOR.length());
		return segment;
	}

	/**
	 * Get the number of deepness level. (Ex: SysML::Blocks::Block ==> Returns 3 )
	 * 
	 * @param qualifiedName
	 *            The full path name
	 * @return Number of deepness level of the full path
	 */
	protected int getMaxDepth(String qualifiedName) {

		StringTokenizer tok = new StringTokenizer(qualifiedName, StereotypeDisplayUtils.STEREOTYPE_LABEL_DEPTH_SEPARATOR);
		return tok.countTokens();

	}

	/**
	 * Return the associated DecorationNode of a node from it's qualified name.
	 * 
	 * @param node
	 *            Container Node of the StereotypeLabel
	 * @param qualifiedName
	 *            Qualified Name of the Stereotype associated to this Label
	 * @return associated StereotypeLabel
	 */
	public DecorationNode getStereotypeLabel(View node, String qualifiedName) {

		if ((qualifiedName != null) && (qualifiedName != EMPTY_STRING)) {
			Object obj;
			Iterator<?> iter = node.getChildren().iterator();
			while (iter.hasNext()) {
				obj = iter.next();
				if (obj instanceof DecorationNode) {
					DecorationNode label = (DecorationNode) obj;
					if (StereotypeDisplayUtils.STEREOTYPE_LABEL_TYPE.equals(label.getType())) {
						if (qualifiedName.equals(getName(label))) {
							return label;
						}
					}
				}
			}
		}

		return null;
	}


	/**
	 * Return the associated DecorationNode of a node from it's stereotypeAppplication.
	 * 
	 * @param node
	 *            Node on which the Stereotype Label is retrieved
	 * @param stereotypeApplication
	 *            Stereotype Application of the Label to be retrieved.
	 * @return associated StereotypeLabel
	 */
	public DecorationNode getStereotypeLabel(View node, EObject stereotypeApplication) {

		if ((stereotypeApplication != null) && (node != null)) {
			Object obj;
			Iterator<?> iter = node.getChildren().iterator();
			while (iter.hasNext()) {
				obj = iter.next();
				if (obj instanceof DecorationNode) {
					DecorationNode label = (DecorationNode) obj;
					if (StereotypeDisplayUtils.STEREOTYPE_LABEL_TYPE.equals(label.getType())) {
						if (label.getElement().equals(stereotypeApplication)) {
							return label;
						}
					}
				}
			}
		}

		return null;
	}

	/**
	 * Return the associated DecorationNode of a node from it's stereotypeAppplication.
	 * 
	 * @param node
	 *            Node on which the Stereotype Label is retrieved
	 * @param stereotypeApplication
	 *            Stereotype Application of the Label to be retrieved.
	 * @return associated StereotypeLabel or null if none
	 */
	public BasicCompartment getStereotypeCompartment(View node, EObject stereotypeApplication) {

		if ((stereotypeApplication != null) && (node != null)) {
			Object obj;
			Iterator<?> iter = node.getChildren().iterator();
			while (iter.hasNext()) {
				obj = iter.next();
				if (isStereotypeCompartment(obj)) {
					BasicCompartment compartment = (BasicCompartment) obj;
					if (compartment.getElement() != null) {
						if (compartment.getElement().equals(stereotypeApplication)) {
							return compartment;
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * return the comment nodes that represent stereotype properties
	 *
	 * @return may be null if nothing is founded
	 */
	public Node getStereotypeComment(View SemanticView) {
		Node node = null;
		if (SemanticView != null && SemanticView.getSourceEdges() != null) {
			// look for all links with the id AppliedStereotypesCommentLinkEditPart.ID
			Iterator<Edge> edgeIterator = SemanticView.getSourceEdges().iterator();
			Edge appliedStereotypeLink = null;
			while (edgeIterator.hasNext() && appliedStereotypeLink == null) {
				Edge edge = edgeIterator.next();
				if (edge.getType().equals(StereotypeDisplayUtils.STEREOTYPE_COMMENT_LINK_TYPE)) {
					appliedStereotypeLink = edge;
				}
			}
			if (appliedStereotypeLink == null) {
				return null;
			}
			node = (Node) appliedStereotypeLink.getTarget();
		}
		return node;

	}

	/**
	 * Define if the Object is a StereotypeLabel
	 * 
	 * @param element
	 *            The object on which the test is done
	 * 
	 * @return True if the Object is of type "StereotypeLabel"
	 */
	public boolean isStereotypeLabel(Object element) {
		boolean stereotypeLabel = Boolean.FALSE;
		if (element instanceof DecorationNode) {
			stereotypeLabel = StereotypeDisplayUtils.STEREOTYPE_LABEL_TYPE.equals(((DecorationNode) element).getType());

		}
		return stereotypeLabel;
	}

	/**
	 * Defines if the Object is a StereotypeCompartment
	 * 
	 * @param element
	 *            The object on which the test is done
	 * @return True if Object is a StereotypeCompartment
	 */
	public boolean isStereotypeCompartment(Object element) {
		boolean stereotypeCompartment = Boolean.FALSE;
		if (element instanceof BasicCompartment) {
			stereotypeCompartment = StereotypeDisplayUtils.STEREOTYPE_COMPARTMENT_TYPE.equals(((DecorationNode) element).getType());
		}
		return stereotypeCompartment;
	}

	/**
	 * Defines if the Object is a StereotypeProperty
	 * 
	 * @param element
	 *            The object on which the test is done
	 * 
	 * @return true if Object is a StereotypeProperty Label
	 */
	public boolean isStereotypeProperty(Object element) {
		boolean stereotypeProperty = Boolean.FALSE;
		if (element instanceof DecorationNode) {
			stereotypeProperty = StereotypeDisplayUtils.STEREOTYPE_PROPERTY_TYPE.equals(((DecorationNode) element).getType());
		}
		return stereotypeProperty;
	}

	/**
	 * Defines if the Object is a StereotypeComment
	 * 
	 * @param element
	 *            The object on which the test is done
	 * 
	 * @return true if Object is a StereotypeProperty Label
	 */
	public boolean isStereotypeComment(Object element) {
		boolean stereotypeComment = Boolean.FALSE;
		if (element instanceof Shape) {
			stereotypeComment = StereotypeDisplayUtils.STEREOTYPE_COMMENT_TYPE.equals(((Shape) element).getType());
		}
		return stereotypeComment;
	}



	/**
	 * Get the name of the Stereotype Label (it should be the Qualified Name of the related Stereotype )
	 * 
	 * @param label
	 *            The DecorationNode of type StereotypeLabel of which the name is retrieved
	 * @return The name of the Label
	 */
	public String getName(DecorationNode label) {
		String name = EMPTY_STRING;
		if (StereotypeDisplayUtils.STEREOTYPE_LABEL_TYPE.equals(label.getType())) {
			// Retrieve Name from CSS or NamedStyle from the Notation model.
			name = NotationUtils.getStringValue(label, StereotypeDisplayUtils.STEREOTYPE_LABEL_NAME, EMPTY_STRING);
		}
		return name;
	}

	/**
	 * Get the name of the Stereotype Compartment that contains Stereotype Properties (The name is the Qualified Name of the related Stereotype )
	 * 
	 * @param compartment
	 *            The BasicCompartment of the Applied Stereotype
	 * @return The name of the Compartment containing the Stereotype properties
	 */
	public String getName(BasicCompartment compartment) {
		String name = EMPTY_STRING;
		if (StereotypeDisplayUtils.STEREOTYPE_COMPARTMENT_TYPE.equals(compartment.getType())) {
			// Retrieve Name from CSS or NamedStyle from the Notation model.
			name = NotationUtils.getStringValue(compartment, StereotypeDisplayUtils.STEREOTYPE_COMPARTMENT_NAME, EMPTY_STRING);
		}
		return name;
	}

	/**
	 * Retrieve the Depth NamedStyle Value of a StereotypeLabel DecorationNode.
	 * The evaluation of the retrieved content is done into method {@link #computeDepthName(int, String) }.
	 * 
	 * @param label
	 *            StereotypeLabel Node
	 * @return the Depth as a String
	 */
	public String getDepth(DecorationNode label) {
		String depth = EMPTY_STRING;
		if (StereotypeDisplayUtils.STEREOTYPE_LABEL_TYPE.equals(label.getType())) {
			// Retrieve Depth from CSS or NamedStyle from the Notation model.
			depth = NotationUtils.getStringValue(label, StereotypeDisplayUtils.STEREOTYPE_LABEL_DEPTH, StereotypeDisplayUtils.DEFAULT_DEPTH_VALUE);

		}
		return depth;
	}


	/**
	 * Defines if Label is present into the node
	 * 
	 * @param node
	 *            View of the node for which the test is done
	 * @param stereotypeApplication
	 *            The stereotype Application of the Label on which the test is done.
	 * @return True is the Node contains already a Label for the stereotype Application
	 */
	public boolean isLabelExist(View node, EObject stereotypeApplication) {

		boolean exist = false;
		Iterator<?> iter = node.getChildren().iterator();
		while (!exist && iter.hasNext()) {
			Object obj = iter.next();
			if (obj instanceof DecorationNode) {

				DecorationNode stereo = (DecorationNode) obj;

				if (StereotypeDisplayUtils.STEREOTYPE_LABEL_TYPE.equals(stereo.getType())) {
					exist = stereo.getElement().equals(stereotypeApplication);
				}
			}
		}
		return exist;
	}

	/**
	 * Defines if the corresponding compartment is present into the node
	 * 
	 * @param node
	 *            View of the node for which the test is done
	 * @param stereotypeApplication
	 *            The stereotype Application of the Label on which the test is done.
	 * @return True is the Node contains already a Label for the stereotype Application
	 */
	public boolean isCompartmentExist(View node, EObject stereotypeApplication) {
		boolean exist = false;
		Iterator<?> iter = node.getChildren().iterator();
		while (!exist && iter.hasNext()) {
			Object obj = iter.next();
			if (obj instanceof BasicCompartment) {

				BasicCompartment compartment = (BasicCompartment) obj;

				if (StereotypeDisplayUtils.STEREOTYPE_COMPARTMENT_TYPE.equals(compartment.getType())) {
					exist = compartment.getElement().equals(stereotypeApplication);
				}
			}
		}
		return exist;
	}

	/**
	 * Defines if the corresponding property is present into the node
	 * 
	 * @param node
	 *            The Compartment of the
	 * @param stereotypeApplication
	 * @return
	 */
	public boolean isPropertyExist(BasicCompartment compartment, Property propertyUML) {
		boolean exist = false;
		Iterator<?> iter = compartment.getChildren().iterator();
		while (!exist && iter.hasNext()) {
			Object obj = iter.next();
			if (obj instanceof DecorationNode) {

				DecorationNode property = (DecorationNode) obj;

				if (StereotypeDisplayUtils.STEREOTYPE_PROPERTY_TYPE.equals(property.getType())) {
					exist = property.getElement().equals(propertyUML);
				}
			}
		}
		return exist;

	}


	/**
	 * Set the visibility of a view
	 *
	 * @param view
	 *            The view on which the visibility has to be set
	 * @param isVisible
	 *            True to make the Compartment visible
	 */
	public void setVisibility(final GraphicalEditPart editPart, final View view, final boolean isVisible) {
		try {

			editPart.getEditingDomain().runExclusive(new Runnable() {

				@Override
				public void run() {
					SetNodeVisibilityCommand setCommand = new SetNodeVisibilityCommand(editPart.getEditingDomain(), view, isVisible);
					// use to avoid to put it in the command stack
					try {
						GMFUnsafe.write(editPart.getEditingDomain(), setCommand);
					} catch (Exception e) {
						Activator.log.error(e);
					}
				}
			});
		} catch (Exception e) {
			Activator.log.error(e);
		}
	}


	/**
	 * Retrieves the property Text to display into the StereotypeCompartment
	 * 
	 * @param view
	 *            The StereotypeProperty (DecorationNode)
	 * @param property
	 *            The UML Property required to retrieve the value
	 * @return The property text to be displayed with the property name and its value (i.e.: "allocatedFrom=[]")
	 */
	public String getStereotypePropertyToDisplay(View view, Property property, StereotypeLocationEnum location) {
		String propertyAndValue = EMPTY_STRING;
		if (view instanceof DecorationNode) {
			DecorationNode node = ((DecorationNode) view);
			if (isStereotypeProperty(node)) {
				final EObject stereotypeApplication = ((View) node.eContainer()).getElement();
				final Stereotype stereotype = UMLUtil.getStereotype(stereotypeApplication);
				final Element umlElement = UMLUtil.getBaseElement(stereotypeApplication);

				if (isDisplayedAtLocation(node, location)) {

					if (stereotype != null && property != null && umlElement != null) {
						propertyAndValue = StereotypeUtil.displayPropertyValue(stereotype, property, umlElement, EMPTY_STRING);
					}
				}

			}
		}
		return propertyAndValue;
	}


	/**
	 * Defines if the Property should be displayed in the location
	 * 
	 * @param node
	 *            The StereotypeProperty node to display
	 * @param location
	 *            The Location on which the test is done
	 * @return True if the property node should be displayed at the location.
	 */
	public boolean isDisplayedAtLocation(Node node, StereotypeLocationEnum location) {
		boolean visibility = true;

		switch (location) {
		case IN_BRACE:
			visibility = isDisplayInBrace(node) && node.isVisible() && ((Node) node.eContainer()).isVisible();
			break;
		case IN_COMPARTMENT:
			visibility = isDisplayInCompartment(node) && node.isVisible() && ((Node) node.eContainer()).isVisible();
			break;
		case IN_COMMENT_BRACE:
			visibility = isDisplayInCommentBrace(node) && node.isVisible() && ((Node) node.eContainer()).isVisible();
			break;
		case IN_COMMENT_COMPARTMENT:
			visibility = isDisplayInCommentCompartment(node) && node.isVisible() && ((Node) node.eContainer()).isVisible();
			break;
		default:
			break;
		}

		return visibility;

	}

	/**
	 * Tests if the Property node should be displayed in the compartment of the Comment .
	 * 
	 * @param node
	 *            The property Node or the Compartment Node
	 * @return true if it should be displayed in The Compartment Comment
	 */
	protected boolean isDisplayInCommentCompartment(Node node) {
		boolean display = false;
		if (isStereotypeProperty(node)) {
			display = NotationUtils.getBooleanValue(node, StereotypeDisplayUtils.STEREOTYPE_PROPERTY_LOCATION_COMMENT, StereotypeDisplayUtils.DEFAULT_STEREOTYPE_PROPERTY_DISPLAY_COMMENT);
		} else {
			Activator.log.warn("The node " + node + " is not a StereotypeProperty node 1 ");
		}
		return display;
	}

	/**
	 * Tests if the Property node should be displayed in Comment.
	 * 
	 * @param property
	 *            The property Node
	 * @return the NamedStyle Value of the property "inBrace" that define if the node should be displayed into braces
	 */
	protected boolean isDisplayInCommentBrace(Node node) {
		boolean display = false;
		if (isStereotypeProperty(node)) {
			display = NotationUtils.getBooleanValue(node, StereotypeDisplayUtils.STEREOTYPE_PROPERTY_LOCATION_COMMENT_BRACE, StereotypeDisplayUtils.DEFAULT_STEREOTYPE_PROPERTY_DISPLAY_COMMENT_BRACE);
		} else {
			Activator.log.warn("The node " + node + " is not a StereotypeProperty node 2 ");
		}

		return display;

	}

	/**
	 * Tests if the Property node should be displayed in Compartment.
	 * 
	 * @param property
	 *            The property Node
	 * @return the NamedStyle Value of the property "inBrace" that define if the node should be displayed into braces
	 */
	protected boolean isDisplayInCompartment(Node node) {
		boolean display = false;
		if (isStereotypeProperty(node)) {
			display = NotationUtils.getBooleanValue(node, StereotypeDisplayUtils.STEREOTYPE_PROPERTY_LOCATION_COMPARTMENT, StereotypeDisplayUtils.DEFAULT_STEREOTYPE_PROPERTY_DISPLAY_COMPARTMENT);
		} else {
			Activator.log.warn("The node " + node + " is not a StereotypeProperty node 3");
		}
		return display;
	}

	/**
	 * Tests if the Property node should be displayed in Braces.
	 * 
	 * @param property
	 *            The property Node
	 * @return the NamedStyle Value of the property "inBrace" that define if the node should be displayed into braces
	 */
	protected boolean isDisplayInBrace(Node node) {
		boolean display = false;
		if (isStereotypeProperty(node)) {
			display = NotationUtils.getBooleanValue(node, StereotypeDisplayUtils.STEREOTYPE_PROPERTY_LOCATION_BRACE, StereotypeDisplayUtils.DEFAULT_STEREOTYPE_PROPERTY_DISPLAY_BRACE);
		} else {
			Activator.log.warn("The node " + node + " is not a StereotypeProperty node 4");
		}
		return display;
	}

	/**
	 * Tests if the node is contained into a Stereotype Comment.
	 * 
	 * @param node
	 *            The Node tested
	 * @return True if the Node is contained into a Stereotype Comment
	 *         False by default
	 */
	public boolean isInStereotypeComment(Node node) {
		boolean isComment = false;
		Object container = node.eContainer();
		if (container != null) {
			if (isStereotypeCompartment(node) || isStereotypeLabel(node)) {
				isComment = isStereotypeComment(node.eContainer());

			} else if (isStereotypeProperty(node)) {
				isComment = isStereotypeComment(node.eContainer().eContainer());
			}
		}

		return isComment;
	}


	/**
	 * Adds properties and value to the existing text.
	 * 
	 * @param textToDisplay
	 *            Initial Text (ie: "")
	 * @param compartment
	 *            Compartment containing the Properties to be added (i.e: Allocation property Compartment )
	 * @param inComment
	 * 
	 * @return the String with the new Properties and their values concatenated. (i.e: "allocatedFrom=[], allocatedTo[]")
	 */
	protected String addStereotypeCompartmentProperties(String textToDisplay, BasicCompartment compartment) {


		StringBuilder newTextToDisplay = new StringBuilder(textToDisplay == null ? "" : textToDisplay);

		StringBuilder propertiesText = new StringBuilder(EMPTY_STRING);
		EList<?> properties = compartment.getChildren();
		// For the compartment, concatenate all the properties Text (property name and values) that should be displayed in Braces
		for (Object property : properties) {
			if (isStereotypeProperty(property)) {
				DecorationNode propertyNode = (DecorationNode) property;
				Property propertyElement = (Property) propertyNode.getElement();
				// get the properties and values text (i.e: "allocatedFrom=[]")
				StereotypeLocationEnum location;
				if (isInStereotypeComment(compartment)) {
					location = StereotypeLocationEnum.IN_COMMENT_BRACE;
				} else {
					location = StereotypeLocationEnum.IN_BRACE;
				}
				String propAndValueText = getStereotypePropertyToDisplay(propertyNode, propertyElement, location);

				// add it to the String (i.e: "allocatedTo=[], allocatedFrom=[]")
				propertiesText = addTextWithSeparator(propertiesText, propAndValueText, StereotypeDisplayUtils.STEREOTYPE_LABEL_SEPARATOR);

			}
		}

		// And concatenate it to the existing text.(i.e: "isEncapsulated=false, allocatedTo=[], allocatedFrom=[]" )
		newTextToDisplay = addTextWithSeparator(newTextToDisplay, propertiesText.toString(), StereotypeDisplayUtils.STEREOTYPE_LABEL_SEPARATOR);

		String finalText = newTextToDisplay.toString();
		return finalText;
	}

	/**
	 * Concatenates Text to another text with a separator.
	 * 
	 * @param textToAdd
	 *            The fragment to add
	 * @param separator
	 *            The separator String (i.e: ", " or "; " or " ")
	 * 
	 * @return The new text with separator and no empty space
	 */
	protected StringBuilder addTextWithSeparator(final StringBuilder initialText, final String textToAdd, final String separator) {

		StringBuilder result = new StringBuilder(initialText == null ? "" : initialText);

		// if result and text to add is not empty, then add a separator
		if ((!EMPTY_STRING.equals(textToAdd) && (textToAdd != null))) {
			if ((result != null) && (!result.toString().equals(EMPTY_STRING))) {
				result.append(separator);
			}
			result.append(textToAdd);
		}
		return result;
	}



	/**
	 * Defines if the Comment has Property to display in brace
	 * 
	 * @param comment
	 *            the Comment Node
	 * @return true if the Brace text is not empty.
	 */
	protected boolean hasBraceLabel(Node comment) {
		boolean hasBrace = false;
		String braceTextInComment = getStereotypePropertiesInBrace(comment);

		if (braceTextInComment != null) {
			hasBrace = !braceTextInComment.isEmpty();
		}

		return hasBrace;
	}

	/**
	 * Defines if the Node has at least one Stereotype Compartment as Child
	 * 
	 * @param node
	 *            The node on which we do the test
	 * @return true if at least one Stereotype Compartment
	 */
	public boolean hasStereotypeCompartment(Node node) {
		Object obj;
		Iterator<?> iter = node.getChildren().iterator();
		boolean compartmentExist = false;
		while (iter.hasNext() && !compartmentExist) {
			obj = iter.next();
			compartmentExist = isStereotypeCompartment(obj);

		}
		return compartmentExist;
	}



	/**
	 * Defines if a Stereotype Comment Node has at least a brace or a compartment
	 * 
	 * @param comment
	 *            The Stereotype Comment Node on which the test is done
	 * @return true if the comment has no compartment and no braceLabel, false by default
	 */
	public boolean isCommentEmpty(Node comment) {
		boolean empty = false;
		empty = (!hasStereotypeCompartment(comment)) && (!hasBraceLabel(comment));
		return empty;
	}

	/**
	 * Define if a Node is empty or not. If at least one property should be displayed, the node is not empty for this location.
	 * 
	 * @param compartment
	 *            The main StereotypeCompartment that contains that property Nodes (not the Comment StereotypeCompartment)
	 * @param location
	 *            Location for which the test is done.
	 * @return true by default, false if at least one property node is displayed.
	 */
	public boolean isEmpty(Node compartment, StereotypeLocationEnum location) {
		boolean empty = true;
		if (compartment != null) {
			for (Object property : compartment.getChildren()) {
				if (isStereotypeProperty(property)) {
					if (isDisplayedAtLocation((Node) property, location)) {
						empty &= false;
					}
				}
			}
		}
		return empty;
	}




}
