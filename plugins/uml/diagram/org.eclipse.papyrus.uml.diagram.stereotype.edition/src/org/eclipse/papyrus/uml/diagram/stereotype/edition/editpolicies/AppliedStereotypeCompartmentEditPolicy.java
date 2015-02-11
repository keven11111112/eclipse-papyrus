/*****************************************************************************
 * Copyright (c) 2012, 2014 CEA LIST and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 323802
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.fr - Bug 393532
 *  Celine Janssens (ALL4TEC) celine.janssens@all4tec.net - Bug 455311 : Refactor Stereotypes Display
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.stereotype.edition.editpolicies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.GMFUnsafe;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;
import org.eclipse.papyrus.uml.diagram.common.stereotype.StereotypeDisplayHelper;
import org.eclipse.papyrus.uml.diagram.common.stereotype.StereotypeDisplayUtils;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.command.CreateAppliedStereotypeViewCommand;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.command.CreateStereotypeLabelCommand;
import org.eclipse.papyrus.uml.tools.listeners.StereotypeElementListener.StereotypeExtensionNotification;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * this edit policy can be apply only on {@link IPapyrusEditPart} in order to
 * access to primary figure. the primary figure has to be a {@link IPapyrusNodeUMLElementFigure}
 */
public class AppliedStereotypeCompartmentEditPolicy extends AppliedStereotypeNodeLabelDisplayEditPolicy {

	/**
	 * Creates a new AppliedStereotype display edit policy
	 */
	public AppliedStereotypeCompartmentEditPolicy() {
		super();
	}

	@Override
	public void activate() {
		super.activate();

		// if stereotype has been applied, compartment has to be created
		Element umlElement = getUMLElement();
		// umlElement may be null if the semantic element has been deleted and the view hasn't been cleaned
		if (umlElement != null) {
			Iterator<EObject> iterator = umlElement.getStereotypeApplications().iterator();
			while (iterator.hasNext()) {
				final EObject appliedstereotype = iterator.next();
				createAppliedStereotypeLabel(appliedstereotype);
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
		// - the annotation corresponding to the display of the stereotype
		// changes
		// - the stereotype application list has changed
		final int eventType = notification.getEventType();

		if (eventType == StereotypeExtensionNotification.STEREOTYPE_APPLIED_TO_ELEMENT) {
			// a stereotype was applied to the notifier
			// then a new listener should be added to the stereotype application
			getDiagramEventBroker().addNotificationListener((EObject) notification.getNewValue(), this);

			createAppliedStereotypeLabel((EObject) notification.getNewValue());
			// Store entry in the Map
			storeInMap((EObject) notification.getNewValue(), ((GraphicalEditPart) getHost()).getNotationView());


		} else if (eventType == StereotypeExtensionNotification.STEREOTYPE_UNAPPLIED_FROM_ELEMENT) {
			getDiagramEventBroker().removeNotificationListener((EObject) notification.getOldValue(), this);

			removeAppliedStereotypeLabel((EObject) notification.getOldValue());
			removeAppliedStereotypeCompartment((EObject) notification.getOldValue());
			// delete entry in the Map
			deleteInMap((EObject) notification.getOldValue());

		}

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

				public void run() {
					Display.getCurrent().syncExec(new Runnable() {

						public void run() {
							CreateAppliedStereotypeViewCommand command = new CreateAppliedStereotypeViewCommand(editPart.getEditingDomain(), editPart.getNotationView(), stereotypeApplication, hasToDisplayCompartment(stereotypeApplication));

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
				public void run() {
					Display.getCurrent().syncExec(new Runnable() {

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

			editPart.getEditingDomain().runExclusive(new Runnable() {

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
	 * Execute the command to remove the Stereotype Compartment with Properties.
	 * 
	 * @param editPart
	 *            Edit Part on which the command is executed
	 * @param label
	 *            DecorationNode of the Stereotype Label that has to be removed
	 */
	protected void executeStereotypeCompartmentRemove(final GraphicalEditPart editPart, final View compartment) {
		try {

			editPart.getEditingDomain().runExclusive(new Runnable() {

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
	 * this method creates a node for the compartment of stereotype if it does not exist.
	 *
	 * @param stereotypeApplication
	 *            the stereotype application
	 */
	public void createAppliedStereotypeLabel(final EObject stereotypeApplication) {

		if (getHost() instanceof GraphicalEditPart) {
			final GraphicalEditPart editPart = (GraphicalEditPart) getHost();

			IFigure figure;
			if (editPart instanceof IPapyrusEditPart) {
				figure = ((IPapyrusEditPart) editPart).getPrimaryShape();
				final View node = editPart.getNotationView();
				// create only if the Label doesn't exist yet
				if (!StereotypeDisplayHelper.isLabelExist(node, stereotypeApplication)) {
					// Create the Decoration Node
					executeStereotypeLabelCreation(editPart, stereotypeApplication, StereotypeDisplayUtils.DEFAULT_VISIBILITY_VALUE);

					// Update the Figure accordingly
					updateLabelText(figure, node);

					// Create Compartment
					executeAppliedStereotypeCompartmentCreation(editPart, stereotypeApplication);

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
	public void removeAppliedStereotypeCompartment(final EObject stereotypeApplication) {

		GraphicalEditPart editPart = (GraphicalEditPart) getHost();

		// Remove the Label node
		BasicCompartment compartment = stereotypePropertyMap.get(stereotypeApplication);
		executeStereotypeCompartmentRemove(editPart, compartment);

		refreshDisplay();

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

		if (getHost() instanceof GraphicalEditPart) {

			final GraphicalEditPart editPart = (GraphicalEditPart) getHost();
			final View node = editPart.getNotationView();

			// Remove the Label node
			DecorationNode label = stereotypeMap.get(stereotypeApplication);
			executeStereotypeLabelRemove(editPart, label);

			// Update the Label displayed accordingly
			if (editPart instanceof IPapyrusEditPart) {
				IFigure figure = ((IPapyrusEditPart) editPart).getPrimaryShape();
				updateLabelText(figure, node);
			}
		}
	}

	/**
	 * Remove the stereotype entry from the Map
	 * 
	 * @param stereotypeApplication
	 * @param node
	 */
	protected void deleteInMap(EObject stereotypeApplication) {
		stereotypeMap.remove(stereotypeApplication);
		stereotypePropertyMap.remove(stereotypeApplication);

	}

	/**
	 * Store the entry (stereotypeApplication, StereotypeLabel)
	 * 
	 * @param stereotypeApplication
	 * @param node
	 */
	protected void storeInMap(EObject stereotypeApplication, View node) {

		// String stereoQN = UMLUtil.getStereotype(stereotypeApplication).getQualifiedName();
		if (stereotypeApplication != null && node != null) {

			DecorationNode label = StereotypeDisplayHelper.getStereotypeLabel(node, stereotypeApplication);
			stereotypeMap.put(stereotypeApplication, label);

			BasicCompartment compartment = StereotypeDisplayHelper.getStereotypeCompartment(node, stereotypeApplication);
			stereotypePropertyMap.put(stereotypeApplication, compartment);
		}
	}

	/**
	 * Refreshes the stereotype display
	 */
	@Override
	protected void refreshAppliedStereotypesPropertiesInCompartment(String stereotypesPropertiesToDisplay, IPapyrusNodeUMLElementFigure figure) {
		// Do Nothing
		// TODO Check if required into Parent
	}

	/**
	 * this method has in charge to calculate if a compartment must be displayed.
	 * To know that it computes if a property of stereotype is displayed into it.
	 *
	 * @param applicationOfStereotype
	 *            the eObject that represent the stereotype application
	 * @return true if the compartment display a property of stereotype
	 */
	protected boolean hasToDisplayCompartment(EObject applicationOfStereotype) {
		String stereotypesPropertiesToDisplay = AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay((View) getHost().getModel());
		String stereotypesLocalizationToDisplay = AppliedStereotypeHelper.getAppliedStereotypesPropertiesLocalization((View) getHost().getModel());
		if (!(stereotypesLocalizationToDisplay.equals(UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION))) {
			return false;
		}
		HashSet<org.eclipse.uml2.uml.Stereotype> stereoSet = new HashSet<org.eclipse.uml2.uml.Stereotype>();
		ArrayList<String> stPropList = new ArrayList<String>();

		// fill our data structure in order to generate the string
		StringTokenizer propStringTokenizer = new StringTokenizer(stereotypesPropertiesToDisplay, ",");
		while (propStringTokenizer.hasMoreElements()) {
			// extract property to display
			String propertyQN = propStringTokenizer.nextToken();
			// stereotype
			String stereotypeQN = propertyQN.substring(0, propertyQN.indexOf("."));

			Stereotype stereotype = hostSemanticElement.getAppliedStereotype(stereotypeQN);

			if (stereotype != null) {
				stereoSet.add(stereotype);
			}

			stPropList.add(propertyQN);
		}

		// Display each stereotype
		Iterator<org.eclipse.uml2.uml.Stereotype> stereoIter = stereoSet.iterator();
		while (stereoIter.hasNext()) {
			Stereotype stereotype = stereoIter.next();
			if (stereotype != null) {
				if (applicationOfStereotype.equals(hostSemanticElement.getStereotypeApplication(stereotype))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Method to set the Figure Label with the new modification.
	 * 
	 * @author Céline JANSSENS
	 * @param figure
	 *            Figure on which the update has to be done
	 * @param node
	 *            Node view of the element required to retrieve the stereotype label
	 *
	 */
	public void updateLabelText(IFigure figure, View node) {
		// Update Figure Label
		if (figure instanceof NodeNamedElementFigure) {

			String textToDisplay = StereotypeDisplayHelper.getStereotypeTextToDisplay(node);
			((NodeNamedElementFigure) figure).setStereotypes(textToDisplay);
		}
	}

}
