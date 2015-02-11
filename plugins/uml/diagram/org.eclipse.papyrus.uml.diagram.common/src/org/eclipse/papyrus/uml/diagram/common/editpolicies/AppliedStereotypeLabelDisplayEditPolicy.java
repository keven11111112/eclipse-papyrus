/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.stereotype.StereotypeDisplayHelper;
import org.eclipse.papyrus.uml.diagram.common.stereotype.StereotypeDisplayUtils;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Usage;

/**
 * Specific edit policy for label displaying stereotypes and their properties
 * for edges representing UML elements.
 * <p>
 * It also displays the tag for the links, for example "use" for {@link Usage}.
 *
 */
public abstract class AppliedStereotypeLabelDisplayEditPolicy extends AbstractAppliedStereotypeDisplayEditPolicy {

	/** constant for this edit policy role */
	public final static String STEREOTYPE_LABEL_POLICY = "AppliedStereotypeLabelDisplayEditPolicy";

	/** tag displayed for the UML element */
	public String tag;

	/**
	 * Map between Stereotype Name and StereotypeLabel displayed
	 */
	public Map<EObject, DecorationNode> stereotypeMap = new HashMap<EObject, DecorationNode>();

	/**
	 * Map between Stereotype Name and StereotypeLabel displayed
	 */
	public Map<EObject, BasicCompartment> stereotypePropertyMap = new HashMap<EObject, BasicCompartment>();

	/**
	 * Creates a new AppliedStereotypeLabelDisplayEditPolicy, with the specified
	 * tag for the element.
	 *
	 * @param tag
	 *            the tag for element, for example "use" for {@link Usage}.
	 */
	public AppliedStereotypeLabelDisplayEditPolicy(String tag) {
		super();
		this.tag = Activator.ST_LEFT + tag + Activator.ST_RIGHT;
	}

	/**
	 * Creates a new AppliedStereotypeLabelDisplayEditPolicy, with no tag for
	 * the element.
	 */
	public AppliedStereotypeLabelDisplayEditPolicy() {
		super();
		this.tag = "";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void refreshDisplay() {
		refreshStereotypeDisplay();
	}

	/**
	 * Refreshes the stereotype display
	 */
	protected abstract void refreshStereotypeDisplay();

	/**
	 * Returns the image to be displayed for the applied stereotypes.
	 *
	 * @return the image that represents the first applied stereotype or <code>null</code> if no image has to be displayed
	 */
	@Override
	public Image stereotypeIconToDisplay() {
		String stereotypespresentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind((View) getHost().getModel());
		if (stereotypespresentationKind == null) {
			return null;
		}
		if (stereotypespresentationKind.equals(UMLVisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION) || stereotypespresentationKind.equals(UMLVisualInformationPapyrusConstant.TEXT_ICON_STEREOTYPE_PRESENTATION)) {

			// retrieve the first stereotype in the list of displayed stereotype
			String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay((View) getHost().getModel());
			StringTokenizer tokenizer = new StringTokenizer(stereotypesToDisplay, ",");
			if (tokenizer.hasMoreTokens()) {
				String firstStereotypeName = tokenizer.nextToken();
				Stereotype stereotype = getUMLElement().getAppliedStereotype(firstStereotypeName);
				return Activator.getIconElement(getUMLElement(), stereotype, false);
			}
		}
		return null;
	}

	/**
	 * Returns a String that displays stereotypes (using their simple name or
	 * their qualified name) and their properties
	 *
	 * @param separator
	 *            the separator used to split the string representing the
	 *            stereotypes.
	 * @param stereotypesToDisplay
	 *            the list of stereotypes displayed
	 * @param stereotypeWithQualifiedName
	 *            the list of stereotypes displayed using their qualified names
	 * @param stereotypesPropertiesToDisplay
	 *            the list of properties to display
	 * @return a string that displays stereotypes (using their simple name or
	 *         their qualified name) and their properties
	 */
	public String stereotypesAndPropertiesToDisplay(String separator, String stereotypesToDisplay, String stereotypesPropertiesToDisplay) {
		// Get the preference from PreferenceStore. there should be an assert
		final IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		if (store == null) {
			Activator.log.warn("The preference store was not found");
			return "";
		}

		// changes the string of properties into a map, where the entries of the
		// map are the stereotype qualified name, and the properties to display are the data
		Map<String, List<String>> propertiesToDisplay = parseStereotypeProperties(stereotypesToDisplay, stereotypesPropertiesToDisplay);

		StringTokenizer strQualifiedName = new StringTokenizer(stereotypesToDisplay, StereotypeDisplayUtils.STEREOTYPE_LABEL_SEPARATOR);
		String out = "";
		while (strQualifiedName.hasMoreElements()) {
			String currentStereotype = strQualifiedName.nextToken();

			// check if current stereotype is applied
			final Element umlElement = getUMLElement();
			Stereotype stereotype = umlElement.getAppliedStereotype(currentStereotype);
			if (stereotype != null) {

				// now should add all properties associated to this stereotype
				List<String> properties = propertiesToDisplay.get(stereotype.getQualifiedName());
				if (properties != null) {
					// retrieve property
					for (String propertyName : properties) {
						out = out + StereotypeUtil.displayPropertyValue(stereotype, StereotypeUtil.getPropertyByName(stereotype, propertyName), getUMLElement(), "\n");
					}
				}
			}
		}
		if (out.endsWith(",")) {
			return out.substring(0, out.length() - 1);
		}
		if (out.endsWith(separator)) {
			return out.substring(0, out.length() - separator.length());
		}
		return out;
	}

	/**
	 * Get the list of stereotype to display.
	 *
	 * @return the list of stereotypes to display
	 */
	public String stereotypesToDisplay() {

		// try to display stereotype properties
		String stereotypesToDisplay = StereotypeDisplayHelper.getStereotypeTextToDisplay((View) getHost().getModel());
		return stereotypesToDisplay;
	}

}
