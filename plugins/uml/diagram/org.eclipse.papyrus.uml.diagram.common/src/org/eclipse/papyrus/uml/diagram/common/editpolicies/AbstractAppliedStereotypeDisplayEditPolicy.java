/*****************************************************************************
 * Copyright (c) 2009, 2014 CEA LIST and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *  Nizar GUEDIDI (CEA LIST) - update getUMLElement()
 *  Christian W. Damus (CEA) - bug 440197
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Bug 393532
 *  Celine JANSSENS (ALL4TEC) celine.janssens@all4tec.net - Bug 455311 Stereotype Display
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.GraphicalEditPolicyEx;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.command.CreateAppliedStereotypeCompartmentCommand;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.command.CreateAppliedStereotypePropertyViewCommand;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.command.CreateStereotypeLabelCommand;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayConstant;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayUtil;
import org.eclipse.papyrus.uml.diagram.common.stereotype.migration.StereotypeMigrationHelper;
import org.eclipse.papyrus.uml.diagram.common.util.CommandUtil;
import org.eclipse.papyrus.uml.tools.listeners.StereotypeElementListener.StereotypeExtensionNotification;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Specific edit policy for label displaying stereotypes and their properties
 * for representing UML elements.
 */
public abstract class AbstractAppliedStereotypeDisplayEditPolicy extends GraphicalEditPolicyEx implements NotificationListener, IPapyrusListener {

	protected String EMPTY_STRING = "";//$NON-NLS-1$

	/** constant for this edit policy role */
	public final static String STEREOTYPE_LABEL_POLICY = "AppliedStereotypeDisplayEditPolicy";//$NON-NLS-1$

	/** host semantic element */
	protected Element hostSemanticElement;

	/** Helper to manipulate applied Stereotype Display model */
	protected StereotypeDisplayUtil helper = StereotypeDisplayUtil.getInstance();
	protected StereotypeMigrationHelper migrationHelper = StereotypeMigrationHelper.getInstance();



	protected IGraphicalEditPart hostEditPart;

	protected View hostView = null;

	protected List<Stereotype> stereotypeList = Collections.emptyList();


	/**
	 * Creates a new AppliedStereotype display edit policy
	 */
	public AbstractAppliedStereotypeDisplayEditPolicy() {
		super();
	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public void activate() {

		if (getHost() instanceof IGraphicalEditPart) {
			initialisation();
			// getDiagramEventBroker().addNotificationListener(view, this);
			getDiagramEventBroker().addNotificationListener(hostSemanticElement, this);

			// Create and Delete nodes if necessary
			refreshNotationStructure();


		}

	}



	/**
	 * Initialize Variables.
	 */
	private void initialisation() {
		hostEditPart = (IGraphicalEditPart) getHost();
		hostSemanticElement = getUMLElement();
		hostView = hostEditPart.getNotationView();
		if (hostSemanticElement != null) {
			stereotypeList = hostSemanticElement.getAppliedStereotypes();
		}
	}



	/**
	 * @see org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.GraphicalEditPolicyEx#refresh()
	 *      This method must extend GraphicalEditPolicyEx, in order to call the edit policy refresh method when the EditPart is Refreshed
	 */
	@Override
	public void refresh() {

		initialisation();
		refreshDisplay();
	}

	/**
	 * Refreshes the display for the element controlled by the edit part with
	 * this edit policies
	 */
	public abstract void refreshDisplay();



	/**
	 *
	 * {@inheritedDoc}
	 */
	@Override
	public void notifyChanged(Notification notification) {

		int eventType = notification.getEventType();

		if (eventType == StereotypeExtensionNotification.STEREOTYPE_APPLIED_TO_ELEMENT) {
			initialisation();
			refreshNotationStructure();

		} else if (eventType == StereotypeExtensionNotification.STEREOTYPE_UNAPPLIED_FROM_ELEMENT) {
			initialisation();
			refreshNotationStructure();
		}
	}

	/**
	 * Create the Notation Structure according to the UML Model for the Stereotypes
	 */
	public void refreshNotationStructure() {

		if (hostView != null) {

			removeUnappliedStereotypes(hostView);

			if (!stereotypeList.isEmpty()) {
				refreshStereotypeStructure();
			}
		}
	}

	/**
	 * Refresh the NotationStructure of the Node for the StereotypeList
	 *
	 */
	public void refreshStereotypeStructure() {

		// rebuild the structure from the Stereotype List
		if (!stereotypeList.isEmpty()) {
			for (Stereotype stereotype : stereotypeList) {
				refreshStereotypeLabelStructure(stereotype);
				refreshStereotypeBraceStructure(stereotype);
			}
		}
	}

	/**
	 * Refresh Brace Compartment and Properties Structure into notation model.
	 *
	 * @param stereotype
	 *            The stereotype for which the Structure is Refreshed
	 */
	public void refreshStereotypeBraceStructure(Stereotype stereotype) {
		BasicCompartment compartment = helper.getStereotypeBraceCompartment(hostView, stereotype);
		if (compartment == null) { // No Label Exist for this Stereotype
			createAppliedStereotypeBraceCompartment(stereotype);
			createAppliedStereotypeBraceProperties(stereotype);

		}

	}

	/**
	 * Refresh The StereotypeLabel notation structure.
	 *
	 * @param stereotype
	 *            The stereotype of which the Label has to be refreshed.
	 */
	public void refreshStereotypeLabelStructure(Stereotype stereotype) {

		DecorationNode label = helper.getStereotypeLabel(hostView, stereotype);
		if (label == null) { // No Label Exist for this Stereotype
			createAppliedStereotypeLabel(stereotype);
		}
	}

	/**
	 * Returns the image to be displayed for the applied stereotypes.
	 *
	 * @return the image that represents the first applied stereotype or <code>null</code> if no image has to be displayed
	 */
	public Image stereotypeIconToDisplay() {
		Image icon = null;
		boolean displayIcon = NotationUtils.getBooleanValue(hostView, StereotypeDisplayConstant.DISPLAY_ICON, false);
		if (displayIcon) {
			// retrieve the first stereotype in the list of displayed stereotype
			Stereotype appliedStereotype;
			Iterator<Stereotype> stereotypeIterator = getUMLElement().getAppliedStereotypes().iterator();
			while (stereotypeIterator.hasNext() && null == icon) {
				appliedStereotype = stereotypeIterator.next();
				icon = Activator.getIconElement(getUMLElement(), appliedStereotype, false);
			}

		}
		return icon;
	}

	/**
	 * This method creates a node for the compartment of stereotype if it does not exist.
	 *
	 * @param stereotype
	 *            the stereotype of which the Label is created
	 */
	protected void createAppliedStereotypeLabel(final Stereotype stereotype) {

		final View node = hostEditPart.getNotationView();
		// create only if the Label doesn't exist yet
		if (!helper.isLabelExist(node, stereotype)) {
			// Create the Decoration Node
			executeStereotypeLabelCreation(hostEditPart, stereotype);
		}
	}


	/**
	 * This method creates a node for the compartment of stereotype if it does not exist.
	 *
	 * @param stereotypeApplication
	 *            the stereotype application
	 */
	protected void createAppliedStereotypeBraceCompartment(final Stereotype stereotype) {
		final View node = hostEditPart.getNotationView();
		// doesn't exist already
		if (!helper.isBraceCompartmentExist(node, stereotype)) {
			// Create Compartment
			executeAppliedStereotypeBraceCompartmentCreation(hostEditPart, stereotype);

		}
	}

	/**
	 * In charge of properties view creation
	 *
	 * @param stereotype
	 *            The stereotype of which the Properties should be created
	 */
	protected void createAppliedStereotypeBraceProperties(final Stereotype stereotype) {

		Node compartment = helper.getStereotypeBraceCompartment(hostEditPart.getNotationView(), stereotype);
		if (compartment != null && stereotype != null) {

			EList<Property> properties = stereotype.allAttributes();
			for (Property property : properties) {
				createAppliedStereotypeBraceProperty(compartment, property);
			}
		}
	}



	/**
	 * In Charge of PropertyView Creation
	 *
	 * @param compartment
	 *            The Compartment owner of the Property that will be created
	 * @param property
	 *            The UML Property of the View to create
	 */
	protected void createAppliedStereotypeBraceProperty(Node compartment, Property property) {
		// if stereotype is null all property of stereotype has to be removed!
		if (property != null && !property.getName().startsWith(Extension.METACLASS_ROLE_PREFIX)) {
			if (!helper.isBracePropertyExist(compartment, property)) {
				// go through each stereotype property
				executeAppliedStereotypeBracePropertyViewCreation(hostEditPart, compartment, property);

			}
		}
	}

	/**
	 * List on all the existing node contained into the main view.
	 * For each node related to the stereotype structure, check if the related Stereotype is still applied
	 * If no, remove the non relevant node.
	 *
	 * @param view
	 *            The main parent view of the host EditPart
	 */
	protected void removeUnappliedStereotypes(View view) {

		if (view != null) {
			List<Object> children = new ArrayList<Object>(view.getChildren());
			Iterator<Object> iter = children.iterator();
			while (iter.hasNext()) {
				Object child = iter.next();
				if (helper.isStereotypeView(child)) {
					if (((View) child).getElement() instanceof Stereotype) {
						Stereotype childStereotype = (Stereotype) ((View) child).getElement();
						if (!hostSemanticElement.isStereotypeApplied(childStereotype)) {
							executeStereotypeViewRemove(hostEditPart, (View) child);
						}
					}
				}
			}
		}
	}

	/**
	 * The goal of this method is to execute the a command to create a notation node for a compartment of stereotype
	 *
	 * @param editPart
	 *            the editPart owner of the new compartment
	 * @param appliedstereotype
	 *            the stereotype application
	 */
	protected void executeAppliedStereotypeBraceCompartmentCreation(final IGraphicalEditPart editPart, final Stereotype stereotype) {
		CreateAppliedStereotypeCompartmentCommand command = new CreateAppliedStereotypeCompartmentCommand(editPart.getEditingDomain(), editPart.getNotationView(), stereotype, StereotypeDisplayConstant.STEREOTYPE_BRACE_TYPE);
		CommandUtil.executeUnsafeCommand(command, editPart);

	}


	/**
	 * This method is used to create a notation node for the property of the stereotype.
	 *
	 * @param editPart
	 *            the editPart container
	 * @param compartment
	 * @param stereotypeApplication
	 * @param stereotype
	 *            the stereotype associated to compartment node
	 */
	protected void executeAppliedStereotypeBracePropertyViewCreation(final IGraphicalEditPart editPart, final Node compartment, final Property stereotypeProperty) {
		CreateAppliedStereotypePropertyViewCommand command = new CreateAppliedStereotypePropertyViewCommand(editPart.getEditingDomain(), compartment, stereotypeProperty, StereotypeDisplayConstant.STEREOTYPE_PROPERTY_BRACE_TYPE);
		CommandUtil.executeUnsafeCommand(command, editPart);

	}

	/**
	 * The goal of this method is to execute the a command to create a notation node for a stereotype Label.
	 *
	 * @param editPart
	 *            The editPart owner of the new compartment
	 * @param stereotype
	 *            The stereotype related to the Label
	 */
	protected void executeStereotypeLabelCreation(final IGraphicalEditPart editPart, final Stereotype stereotype) {
		CreateStereotypeLabelCommand command = new CreateStereotypeLabelCommand(editPart.getEditingDomain(), editPart.getNotationView(), stereotype);
		CommandUtil.executeUnsafeCommand(command, editPart);


	}

	/**
	 * Gets the diagram event broker from the editing domain.
	 *
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		if (theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}

	/**
	 * Returns the uml element controlled by the host edit part
	 *
	 * @return the uml element controlled by the host edit part
	 */
	protected Element getUMLElement() {
		EObject element = getView().getElement();
		if (element instanceof Element) {
			return (Element) element;
		}
		return null;
	}

	/**
	 * Returns the view controlled by the host edit part
	 *
	 * @return the view controlled by the host edit part
	 */
	protected View getView() {
		return (View) getHost().getModel();
	}

	/**
	 * Execute the command to remove the Stereotype.
	 *
	 * @param editPart
	 *            Edit Part on which the command is executed
	 * @param label
	 *            DecorationNode of the Stereotype Label that has to be removed
	 */
	protected void executeStereotypeViewRemove(final IGraphicalEditPart editPart, final View view) {

		DeleteCommand command = new DeleteCommand(view);
		CommandUtil.executeUnsafeCommand(command, editPart);

	}


	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public void deactivate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if (view != null) {
			getDiagramEventBroker().removeNotificationListener(view, this);
			if (hostSemanticElement != null) {

				// remove listeners to applied stereotyped
				for (EObject stereotypeApplication : hostSemanticElement.getStereotypeApplications()) {
					getDiagramEventBroker().removeNotificationListener(stereotypeApplication, this);
				}
				// remove notification on element
				getDiagramEventBroker().removeNotificationListener(hostSemanticElement, this);
				// removes the reference to the semantic element
				hostSemanticElement = null;
			}
		}
	}

}
