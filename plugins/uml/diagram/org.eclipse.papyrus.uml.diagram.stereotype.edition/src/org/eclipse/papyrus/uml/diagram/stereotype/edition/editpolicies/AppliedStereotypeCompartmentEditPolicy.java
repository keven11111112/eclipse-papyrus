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

import java.util.Iterator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.GMFUnsafe;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;
import org.eclipse.papyrus.uml.diagram.common.stereotype.StereotypeDisplayHelper;
import org.eclipse.papyrus.uml.diagram.common.stereotype.StereotypeDisplayUtils;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.command.CreateAppliedStereotypePropertyViewCommand;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.command.CreateAppliedStereotypeViewCommand;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.command.CreateStereotypeLabelCommand;
import org.eclipse.papyrus.uml.tools.listeners.StereotypeElementListener.StereotypeExtensionNotification;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * this edit policy can be apply only on {@link IPapyrusEditPart} in order to
 * access to primary figure. the primary figure has to be a {@link IPapyrusNodeUMLElementFigure}
 */
public class AppliedStereotypeCompartmentEditPolicy extends AppliedStereotypeNodeLabelDisplayEditPolicy {

	private GraphicalEditPart editPart;


	/**
	 * Creates a new AppliedStereotype display edit policy
	 */
	public AppliedStereotypeCompartmentEditPolicy() {
		super();

	}

	@Override
	public void activate() {
		super.activate();
		if (getHost() instanceof GraphicalEditPart) {
			editPart = (GraphicalEditPart) getHost();
		}
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
			createAppliedStereotypeCompartment((EObject) notification.getNewValue());
			createAppliedStereotypeProperty((EObject) notification.getNewValue());

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
	 * this method is used to create a notation node for the property of the stereotype
	 *
	 * @param editPart
	 *            the editPart container
	 * @param compartment
	 * @param stereotypeApplication
	 * @param stereotype
	 *            the stereotype associated to compartment node
	 */
	protected void executeAppliedStereotypePropertyViewCreation(final GraphicalEditPart editPart, final Node compartment, final Property stereotypeProperty, final EObject stereotypeApplication) {
		try {
			editPart.getEditingDomain().runExclusive(new Runnable() {

				public void run() {
					Display.getCurrent().syncExec(new Runnable() {

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
	 * This method creates a node for the compartment of stereotype if it does not exist.
	 *
	 * @param stereotypeApplication
	 *            the stereotype application
	 */
	protected void createAppliedStereotypeLabel(final EObject stereotypeApplication) {

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
		final View node = editPart.getNotationView();
		// doesn't exist already
		if (!StereotypeDisplayHelper.isCompartmentExist(node, stereotypeApplication)) {
			// Create Compartment
			executeAppliedStereotypeCompartmentCreation(editPart, stereotypeApplication);
		}
	}


	/**
	 * In charge of property view creation
	 * 
	 * @param eObject
	 *            The Edit Part of which the Properties should be created
	 */
	protected void createAppliedStereotypeProperty(EObject stereotypeApplication) {

		Node compartment = StereotypeDisplayHelper.getStereotypeCompartment(editPart.getNotationView(), stereotypeApplication);
		if (compartment != null) {
			Stereotype stereotype = UMLUtil.getStereotype(stereotypeApplication);
			if (stereotype != null) {
				EList<Property> properties = stereotype.allAttributes();
				for (Property property : properties) {
					// if stereotype is null all property of stereotype has to be removed!
					if (property != null && !property.getName().startsWith(Extension.METACLASS_ROLE_PREFIX)) {
						// go through each stereotype property
						executeAppliedStereotypePropertyViewCreation(editPart, compartment, property, stereotypeApplication);

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
		BasicCompartment compartment = stereotypePropertyMap.get(stereotypeApplication);
		executeStereotypeCompartmentRemove(editPart, compartment);

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
	 *            The Stereotype Application reference to delete
	 */
	protected void deleteInMap(EObject stereotypeApplication) {
		stereotypeMap.remove(stereotypeApplication);
		stereotypePropertyMap.remove(stereotypeApplication);
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

			DecorationNode label = StereotypeDisplayHelper.getStereotypeLabel(node, stereotypeApplication);
			stereotypeMap.put(stereotypeApplication, label);

			BasicCompartment compartment = StereotypeDisplayHelper.getStereotypeCompartment(node, stereotypeApplication);
			stereotypePropertyMap.put(stereotypeApplication, compartment);
		}
	}

	/**
	 * Method to set the Figure Label with the new modification.
	 * 
	 * @param figure
	 *            Figure on which the update has to be done
	 * @param node
	 *            Node view of the element required to retrieve the stereotype label
	 *
	 */
	protected void updateLabelText(IFigure figure, View node) {
		// Update Figure Label
		if (figure instanceof NodeNamedElementFigure) {

			String textToDisplay = StereotypeDisplayHelper.getStereotypeTextToDisplay(node);
			((NodeNamedElementFigure) figure).setStereotypes(textToDisplay);
		}
	}

}
