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
 *  Celine Janssens (ALL4TEC) celine.janssens@all4tec.net - Bug 455311 : Refactor Stereotypes Display
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.GMFUnsafe;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.stereotype.CreateAppliedStereotypePropertyViewCommand;
import org.eclipse.papyrus.uml.diagram.common.stereotype.CreateAppliedStereotypeViewCommand;
import org.eclipse.papyrus.uml.diagram.common.stereotype.CreateStereotypeLabelCommand;
import org.eclipse.papyrus.uml.diagram.common.stereotype.StereotypeDisplayUtils;
import org.eclipse.papyrus.uml.tools.listeners.StereotypeElementListener.StereotypeExtensionNotification;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Usage;
import org.eclipse.uml2.uml.util.UMLUtil;

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
	private Map<EObject, DecorationNode> stereotypeMap = new HashMap<EObject, DecorationNode>();

	/**
	 * Map between Stereotype Name and StereotypeLabel displayed
	 */
	private Map<EObject, BasicCompartment> stereotypePropertyMap = new HashMap<EObject, BasicCompartment>();


	private GraphicalEditPart hostEditPart;


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
	 * @return the stereotypePropertyMap
	 */
	public Map<EObject, BasicCompartment> getStereotypePropertyMap() {
		return stereotypePropertyMap;
	}

	/**
	 * @param stereotypePropertyMap
	 *            the stereotypePropertyMap to set
	 */
	public void setStereotypePropertyMap(Map<EObject, BasicCompartment> stereotypePropertyMap) {
		this.stereotypePropertyMap = stereotypePropertyMap;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void refreshDisplay() {
		refreshStereotypeDisplay();
	}

	@Override
	public void activate() {
		super.activate();
		if (getHost() instanceof GraphicalEditPart) {
			hostEditPart = (GraphicalEditPart) getHost();
		}
		// if stereotype has been applied, compartment has to be created
		Element umlElement = getUMLElement();
		// umlElement may be null if the semantic element has been deleted and the view hasn't been cleaned
		if (umlElement != null) {
			Iterator<EObject> iterator = umlElement.getStereotypeApplications().iterator();
			while (iterator.hasNext()) {
				final EObject appliedstereotype = iterator.next();
				createAppliedStereotypeLabel(appliedstereotype);
				createAppliedStereotypeCompartment(appliedstereotype);
				createAppliedStereotypeProperty(appliedstereotype);
			}
		}
	}

	/**
	 *
	 * {@inheritedDoc}
	 */
	@Override
	public void notifyChanged(Notification notification) {
		// change the label of the figure managed by the host edit part (managed
		// by the parent edit part in general...)
		// it must be changed only if:
		// - the stereotype application list has changed
		final int eventType = notification.getEventType();

		if (eventType == StereotypeExtensionNotification.STEREOTYPE_APPLIED_TO_ELEMENT) {
			// a stereotype was applied to the notifier
			// then a new listener should be added to the stereotype application
			getDiagramEventBroker().addNotificationListener((EObject) notification.getNewValue(), this);
			createAppliedStereotypeLabel((EObject) notification.getNewValue());
			createAppliedStereotypeCompartment((EObject) notification.getNewValue());
			createAppliedStereotypeProperty((EObject) notification.getNewValue());

			// Store entry in the Map
			storeInMap((EObject) notification.getNewValue(), hostEditPart.getNotationView());


		} else if (eventType == StereotypeExtensionNotification.STEREOTYPE_UNAPPLIED_FROM_ELEMENT) {
			getDiagramEventBroker().removeNotificationListener((EObject) notification.getOldValue(), this);
			removeAppliedStereotypeLabel((EObject) notification.getOldValue());
			removeAppliedStereotypeCompartment((EObject) notification.getOldValue());

			// delete entry in the Map
			deleteInMap((EObject) notification.getOldValue());

		}

	}

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
		String stereotypesToDisplay = helper.getStereotypeTextToDisplay((View) getHost().getModel());
		return stereotypesToDisplay;
	}

	/**
	 * @return the stereotypeMap
	 */
	public Map<EObject, DecorationNode> getStereotypeMap() {
		return stereotypeMap;
	}

	/**
	 * @param stereotypeMap
	 *            the stereotypeMap to set
	 */
	public void setStereotypeMap(Map<EObject, DecorationNode> stereotypeMap) {
		this.stereotypeMap = stereotypeMap;
	}


	/**
	 * the goal of this method is to execute the a command to create a notation node for a compartment of stereotype
	 *
	 * @param editPart
	 *            the editPart owner of the new compartment
	 * @param appliedstereotype
	 *            the stereotype application
	 */
	protected void executeAppliedStereotypeCompartmentCreation(final GraphicalEditPart editPart, final EObject stereotypeApplication) {
		try {
			editPart.getEditingDomain().runExclusive(new Runnable() {

				@Override
				public void run() {
					Display.getCurrent().syncExec(new Runnable() {

						@Override
						public void run() {
							CreateAppliedStereotypeViewCommand command = new CreateAppliedStereotypeViewCommand(editPart.getEditingDomain(), editPart.getNotationView(), stereotypeApplication);

							// use to avoid to put it in the command stack
							try {
								GMFUnsafe.write(editPart.getEditingDomain(), command);
							} catch (Exception e) {
								Activator.log.error(e);
							}
						}
					});

				}
			});
		} catch (Exception e) {
			Activator.log.error(e);
		}
	}


	/**
	 * this method is used to create a notation node for the property of the stereotype
	 *
	 * @param editPart
	 *            the editPart container
	 * @param compartment
	 * @param stereotypeApplication
	 * @param stereotype
	 *            the stereotype associated to compartment node
	 */
	protected void executeAppliedStereotypePropertyViewCreation(final GraphicalEditPart editPart, final Node compartment, final Property stereotypeProperty) {
		try {
			editPart.getEditingDomain().runExclusive(new Runnable() {

				@Override
				public void run() {
					Display.getCurrent().syncExec(new Runnable() {

						@Override
						public void run() {

							// use to avoid to put it in the command stack
							CreateAppliedStereotypePropertyViewCommand command = new CreateAppliedStereotypePropertyViewCommand(editPart.getEditingDomain(), compartment, stereotypeProperty);
							try {
								GMFUnsafe.write(editPart.getEditingDomain(), command);
							} catch (Exception e) {
								Activator.log.error(e);
							}
						}
					});
				}
			});

		} catch (Exception e) {
			Activator.log.error(e);
		}
	}


	/**
	 * Execute the command to remove the Stereotype Compartment with Properties.
	 * 
	 * @param editPart
	 *            Edit Part on which the command is executed
	 * @param label
	 *            DecorationNode of the Stereotype Label that has to be removed
	 */
	protected void executeAppliedStereotypeCompartmentRemove(final GraphicalEditPart editPart, final View compartment) {
		try {

			editPart.getEditingDomain().runExclusive(new Runnable() {

				@Override
				public void run() {
					DeleteCommand command = new DeleteCommand(compartment);
					// use to avoid to put it in the command stack
					try {
						GMFUnsafe.write(editPart.getEditingDomain(), command);
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
	 * This method creates a node for the compartment of stereotype if it does not exist.
	 *
	 * @param stereotypeApplication
	 *            the stereotype application
	 */
	protected void createAppliedStereotypeLabel(final EObject stereotypeApplication) {


		if (hostEditPart instanceof IPapyrusEditPart) {

			final View node = hostEditPart.getNotationView();
			// create only if the Label doesn't exist yet
			if (!helper.isLabelExist(node, stereotypeApplication)) {
				// Create the Decoration Node
				executeStereotypeLabelCreation(hostEditPart, stereotypeApplication, StereotypeDisplayUtils.DEFAULT_VISIBILITY_VALUE);


			}
		}

	}


	/**
	 * This method creates a node for the compartment of stereotype if it does not exist.
	 *
	 * @param stereotypeApplication
	 *            the stereotype application
	 */
	protected void createAppliedStereotypeCompartment(final EObject stereotypeApplication) {
		final View node = hostEditPart.getNotationView();
		// doesn't exist already
		if (!helper.isCompartmentExist(node, stereotypeApplication)) {
			// Create Compartment
			executeAppliedStereotypeCompartmentCreation(hostEditPart, stereotypeApplication);
		}
	}


	/**
	 * In charge of property view creation
	 * 
	 * @param eObject
	 *            The Edit Part of which the Properties should be created
	 */
	protected void createAppliedStereotypeProperty(EObject stereotypeApplication) {

		Node compartment = helper.getStereotypeCompartment(hostEditPart.getNotationView(), stereotypeApplication);
		if (compartment != null && helper.isStereotypeCompartment(compartment)) {
			Stereotype stereotype = UMLUtil.getStereotype(stereotypeApplication);
			if (stereotype != null) {
				EList<Property> properties = stereotype.allAttributes();
				for (Property property : properties) {
					// if stereotype is null all property of stereotype has to be removed!
					if (property != null && !property.getName().startsWith(Extension.METACLASS_ROLE_PREFIX)) {
						if (!helper.isPropertyExist((BasicCompartment) compartment, property)) {
							// go through each stereotype property
							executeAppliedStereotypePropertyViewCreation(hostEditPart, compartment, property);

						}
					}
				}
			}
		}
	}


	/**
	 * this method suppress the sub-nodes that references the stereotype application
	 * it cleans also all sub-nodes with the type ApplicationStereotype that not references an application of stereotypes
	 * (this is the case when a stereotype has been unapplied without suppress the compartment.
	 *
	 * @param stereotypeApplication
	 */
	protected void removeAppliedStereotypeCompartment(final EObject stereotypeApplication) {

		GraphicalEditPart editPart = (GraphicalEditPart) getHost();

		// Remove the Label node
		BasicCompartment compartment = getStereotypePropertyMap().get(stereotypeApplication);
		if (compartment != null && TransactionUtil.getEditingDomain(compartment) != null) {
			executeAppliedStereotypeCompartmentRemove(editPart, compartment);
		}
	}


	/**
	 * Remove the stereotype entry from the Map
	 * 
	 * @param stereotypeApplication
	 *            The Stereotype Application reference to delete
	 */
	protected void deleteInMap(EObject stereotypeApplication) {
		getStereotypePropertyMap().remove(stereotypeApplication);
		getStereotypeMap().remove(stereotypeApplication);
	}


	/**
	 * Store the entry (stereotypeApplication, StereotypeLabel)
	 * 
	 * @param stereotypeApplication
	 *            The Stereotype Application instance to store
	 * @param node
	 *            The parent view (i.e: CSSShapeImpl)
	 */
	protected void storeInMap(EObject stereotypeApplication, View node) {

		// String stereoQN = UMLUtil.getStereotype(stereotypeApplication).getQualifiedName();
		if (stereotypeApplication != null && node != null) {
			BasicCompartment compartment = helper.getStereotypeCompartment(node, stereotypeApplication);
			getStereotypePropertyMap().put(stereotypeApplication, compartment);
			DecorationNode label = helper.getStereotypeLabel(node, stereotypeApplication);
			getStereotypeMap().put(stereotypeApplication, label);
		}
	}


	/**
	 * The goal of this method is to execute the a command to create a notation node for a stereotype Label.
	 *
	 * @param editPart
	 *            the editPart owner of the new compartment
	 * @param appliedstereotype
	 *            the stereotype application
	 */
	protected void executeStereotypeLabelCreation(final GraphicalEditPart editPart, final EObject appliedstereotype, final boolean isVisible) {
		try {
			editPart.getEditingDomain().runExclusive(new Runnable() {
				@Override
				public void run() {
					Display.getCurrent().syncExec(new Runnable() {

						@Override
						public void run() {

							CreateStereotypeLabelCommand command = new CreateStereotypeLabelCommand(editPart.getEditingDomain(), editPart.getNotationView(), appliedstereotype, isVisible);
							// use to avoid to put it in the command stack
							try {
								GMFUnsafe.write(editPart.getEditingDomain(), command);
							} catch (Exception e) {
								Activator.log.error(e);
							}
						}
					});

				}
			});
		} catch (Exception e) {
			Activator.log.error(e);
		}
	}


	/**
	 * Execute the command to remove the Stereotype.
	 * 
	 * @param editPart
	 *            Edit Part on which the command is executed
	 * @param label
	 *            DecorationNode of the Stereotype Label that has to be removed
	 */
	protected void executeStereotypeLabelRemove(final GraphicalEditPart editPart, final View label) {
		try {


			TransactionUtil.getEditingDomain(getView()).runExclusive(new Runnable() {

				@Override
				public void run() {
					DeleteCommand command = new DeleteCommand(label);
					// use to avoid to put it in the command stack
					try {
						GMFUnsafe.write(editPart.getEditingDomain(), command);
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
	 * Remove the StereotypeLabel from an element from it's stereotype application.
	 * 
	 * @param stereotypeApplication
	 *            Associated Stereotype application to remove
	 */
	protected void removeAppliedStereotypeLabel(EObject stereotypeApplication) {
		if (stereotypeApplication == null) {
			return;
		}

		// Remove the Label node
		DecorationNode label = getStereotypeMap().get(stereotypeApplication);
		if (label != null && TransactionUtil.getEditingDomain(label) != null) {
			executeStereotypeLabelRemove(hostEditPart, label);
		}


	}


	/**
	 * Refreshes the stereotype display
	 */
	protected abstract void refreshStereotypeDisplay();


}
