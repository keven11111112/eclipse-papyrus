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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.DecorationNode;
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

	private final static String EMPTY_STRING = "";

	public static String getStereotypeTextToDisplay(View model) {
		String textToDisplay = null;
		String finalText = null;
		Iterator<?> iter = model.getChildren().iterator();
		Object object;
		DecorationNode label;
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

		if ((textToDisplay != null) && (!EMPTY_STRING.equals(textToDisplay))) {
			finalText = StereotypeDisplayUtils.BRACE_LEFT + textToDisplay + StereotypeDisplayUtils.BRACE_RIGHT;
		}

		return finalText;

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
	protected static String addStereotypeName(String textToDisplay, DecorationNode label, View model) {
		String newTextToDisplay = textToDisplay;
		if (!"".equals(newTextToDisplay) && (newTextToDisplay != null)) {
			newTextToDisplay = (newTextToDisplay + StereotypeDisplayUtils.STEREOTYPE_LABEL_SEPARATOR);
		}

		String name = StereotypeDisplayHelper.getName(label);
		String depth = StereotypeDisplayHelper.getDepth(label);

		String nameWithDepth = getStereotypeNameWithDepth(name, depth);
		newTextToDisplay = ((newTextToDisplay == null ? EMPTY_STRING : newTextToDisplay) + nameWithDepth);
		return newTextToDisplay;
	}

	/**
	 * Retrieve the Depth NamedStyle Value of a StereotypeLabel DecorationNode.
	 * The evaluation of the retrieved content is done into method {@link #computeDepthName(int, String) }.
	 * 
	 * @param label
	 *            StereotypeLabel Node
	 * @return the Depth as a String
	 */
	public static String getDepth(DecorationNode label) {
		String depth = EMPTY_STRING;
		if (StereotypeDisplayUtils.STEREOTYPE_LABEL_TYPE.equals(label.getType())) {

			depth = NotationUtils.getStringValue(label, StereotypeDisplayUtils.STEREOTYPE_LABEL_DEPTH, StereotypeDisplayUtils.DEFAULT_DEPTH_VALUE);

		}
		return depth;
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
	protected static String getStereotypeNameWithDepth(String qualifiedName, String depth) {

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

					if (depthRetrieve > -getMaxDepth(qualifiedName) && depthRetrieve < 0) { // between the minimum and the maximum depth (i.e.:-1)
						return computeDepthName(depthRetrieve, qualifiedName);
					} else if (depthRetrieve <= -getMaxDepth(qualifiedName)) { // if smaller than the depth (i.e: -42)
						return getMinimumDepthName(qualifiedName); // the Last segment is retrieve (i.e: Block)
					} else if (depthRetrieve == 0) { // mean full name
						return qualifiedName;
					} else { // in all other cases , this is the full name which is retrieve
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
	protected static String computeDepthName(int depthRetrieve, String qualifiedName) {

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
	public static String getMinimumDepthName(String qualifiedName) {
		String segment = "";
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
	protected static int getMaxDepth(String qualifiedName) {

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
	public static DecorationNode getStereotypeLabel(View node, String qualifiedName) {

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
	public static DecorationNode getStereotypeLabel(View node, EObject stereotypeApplication) {

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
	 * @return associated StereotypeLabel
	 */
	public static BasicCompartment getStereotypeCompartment(View node, EObject stereotypeApplication) {

		if ((stereotypeApplication != null) && (node != null)) {
			Object obj;
			Iterator<?> iter = node.getChildren().iterator();
			while (iter.hasNext()) {
				obj = iter.next();
				if (obj instanceof BasicCompartment) {
					BasicCompartment compartment = (BasicCompartment) obj;
					if (StereotypeDisplayUtils.STEREOTYPE_COMPARTMENT_TYPE.equals(compartment.getType())) {
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
	 * Define if the Object is a StereotypeLabel
	 * 
	 * @param element
	 *            The object on which the test is done
	 * 
	 * @return True if the Object is of type "StereotypeLabel"
	 */
	public static boolean isStereotypeLabel(Object element) {
		boolean stereotypeLabel = Boolean.FALSE;
		if (element instanceof DecorationNode) {
			stereotypeLabel = StereotypeDisplayUtils.STEREOTYPE_LABEL_TYPE.equals(((DecorationNode) element).getType());
		}
		return stereotypeLabel;
	}

	/**
	 * Define if the Object is a StereotypeCompartment
	 * 
	 * @param element
	 *            The object on which the test is done
	 * @return True if Object is a StereotypeCompartment
	 */
	public static boolean isStereotypeCompartment(EObject element) {
		boolean stereotypeCompartment = Boolean.FALSE;
		if (element instanceof BasicCompartment) {
			stereotypeCompartment = StereotypeDisplayUtils.STEREOTYPE_COMPARTMENT_TYPE.equals(((DecorationNode) element).getType());
		}
		return stereotypeCompartment;
	}

	/**
	 * Define if the Object is a StereotypeProperty
	 * 
	 * @param element
	 *            The object on which the test is done
	 * 
	 * @return true if Object is a StereotypeProperty Label
	 */
	public static boolean isStereotypeProperty(Object element) {
		boolean stereotypeProperty = Boolean.FALSE;
		if (element instanceof DecorationNode) {
			stereotypeProperty = StereotypeDisplayUtils.STEREOTYPE_PROPERTY_TYPE.equals(((DecorationNode) element).getType());
		}
		return stereotypeProperty;
	}

	/**
	 * Get the name of the Stereotype Label (it should be the Qualified Name of the related Stereotype )
	 * 
	 * @param label
	 *            The DecorationNode of type StereotypeLabel of which the name is retrieved
	 * @return The name of the Label
	 */
	public static String getName(DecorationNode label) {
		String name = EMPTY_STRING;
		if (StereotypeDisplayUtils.STEREOTYPE_LABEL_TYPE.equals(label.getType())) {
			name = NotationUtils.getStringValue(label, StereotypeDisplayUtils.STEREOTYPE_LABEL_NAME, "");
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
	public static String getName(BasicCompartment compartment) {
		String name = EMPTY_STRING;
		if (StereotypeDisplayUtils.STEREOTYPE_COMPARTMENT_TYPE.equals(compartment.getType())) {
			name = NotationUtils.getStringValue(compartment, StereotypeDisplayUtils.STEREOTYPE_COMPARTMENT_NAME, "");
		}
		return name;
	}

	/**
	 * Define if Label is present into the node
	 * 
	 * @param node
	 *            View of the node for which the test is done
	 * @param stereotypeApplication
	 *            The stereotype Application of the Label on which the test is done.
	 * @return True is the Node contains already a Label for the stereotype Application
	 */
	public static boolean isLabelExist(View node, EObject stereotypeApplication) {

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
	 * Set the visibility of a view
	 *
	 * @param view
	 *            The view on which the visibility has to be set
	 * @param isVisible
	 *            True to make the Compartment visible
	 */
	public static void setVisibility(final GraphicalEditPart editPart, final View view, final boolean isVisible) {
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
	 * Retrieve the property Text to display into the StereotypeCompartment
	 * 
	 * @param view
	 *            The StereotypeProperty (DecorationNode)
	 * @param property
	 *            The UML Property required to retrieve the value
	 * @return The property text to be displayed with the property name and its value (i.e.: "allocatedFrom=[]")
	 */
	public static String getStereotypePropertyToDisplay(View view, Property property) {
		String propertyAndValue = EMPTY_STRING;
		if (view instanceof DecorationNode) {
			if (view.getType().equals(StereotypeDisplayUtils.STEREOTYPE_PROPERTY_TYPE)) {

				if (view.isVisible()) {

					final EObject stereotypeApplication = ((View) view.eContainer()).getElement();
					final Stereotype stereotype = UMLUtil.getStereotype(stereotypeApplication);
					final Element umlElement = UMLUtil.getBaseElement(stereotypeApplication);

					if (stereotype != null && property != null && umlElement != null) {
						propertyAndValue = StereotypeUtil.displayPropertyValue(stereotype, property, umlElement, "");
					}
				}
			}
		}
		return propertyAndValue;

	}


}
