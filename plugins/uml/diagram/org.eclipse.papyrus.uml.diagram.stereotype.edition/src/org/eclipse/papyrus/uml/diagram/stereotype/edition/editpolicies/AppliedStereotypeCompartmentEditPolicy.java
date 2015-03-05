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

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.GMFUnsafe;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.stereotype.CreateAppliedStereotypePropertyViewCommand;
import org.eclipse.papyrus.uml.diagram.common.stereotype.CreateAppliedStereotypeViewCommand;
import org.eclipse.papyrus.uml.diagram.common.stereotype.StereotypeDisplayUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * this edit policy can be apply only on {@link IPapyrusEditPart} in order to
 * access to primary figure. the primary figure has to be a {@link IPapyrusNodeUMLElementFigure}
 * 
 */

public class AppliedStereotypeCompartmentEditPolicy extends AppliedStereotypeNodeLabelDisplayEditPolicy {

	/** constant for this edit policy role */
	public final static String STEREOTYPE_LABEL_POLICY = "AppliedStereotypeCompartmentEditPolicy"; //$NON-NLS-1$

	/**
	 * Creates a new AppliedStereotype display edit policy
	 */
	public AppliedStereotypeCompartmentEditPolicy() {
		super();
	}

	/**
	 * Refresh the NotationStructure of the Node for this Stereotype
	 * 
	 * @param notationView
	 * @param stereo
	 */
	@Override
	public void refreshStereotypeStructure() {

		// Build the structure from the Stereotype List
		if (!stereotypeList.isEmpty()) {
			for (Stereotype stereotype : stereotypeList) {
				refreshStereotypeCompartmentStructure(stereotype);
			}
		}
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy#refreshStereotypeDisplay()
	 *
	 */
	@Override
	protected void refreshStereotypeDisplay() {
		// Nothing to refresh
	}


	/**
	 * Refresh The StereotypeCompartment notation structure.
	 * 
	 * @param view
	 * @param stereotype
	 */

	protected void refreshStereotypeCompartmentStructure(Stereotype stereotype) {

		BasicCompartment compartment = helper.getStereotypeCompartment(hostView, stereotype);
		if (compartment == null) { // No Label Exist for this Stereotype
			createAppliedStereotypeCompartment(stereotype);
			createAppliedStereotypeProperties(stereotype);

		}
	}

	/**
	 * This method creates a node for the compartment of stereotype if it does not exist.
	 *
	 * @param stereotypeApplication
	 *            the stereotype application
	 */
	protected void createAppliedStereotypeCompartment(final Stereotype stereotype) {
		final View node = hostEditPart.getNotationView();
		// doesn't exist already
		if (!helper.isCompartmentExist(node, stereotype)) {
			// Create Compartment
			executeAppliedStereotypeCompartmentCreation(hostEditPart, stereotype);

		}
	}


	/**
	 * In charge of properties view creation
	 * 
	 * @param eObject
	 *            The Edit Part of which the Properties should be created
	 */

	protected void createAppliedStereotypeProperties(final Stereotype stereotype) {

		Node compartment = helper.getStereotypeCompartment(hostEditPart.getNotationView(), stereotype);
		if (compartment != null && stereotype != null) {

			EList<Property> properties = stereotype.allAttributes();
			for (Property property : properties) {
				createAppliedStereotypeProperty(compartment, property);
			}


		}
	}

	/**
	 * In Charge of PropertyView Creation
	 * 
	 * @param propertyType
	 *            Type of Property {@link StereotypeDisplayUtils#STEREOTYPE_PROPERTY_TYPE} or {@link StereotypeDisplayUtils#STEREOTYPE_PROPERTY_BRACE_TYPE}
	 * @param compartment
	 *            The Compartment owner of the Property that will be created
	 * @param property
	 *            The UML Property of the View to create
	 */

	protected void createAppliedStereotypeProperty(Node compartment, Property property) {
		// if stereotype is null all property of stereotype has to be removed!
		if (property != null && !property.getName().startsWith(Extension.METACLASS_ROLE_PREFIX)) {
			if (!helper.isPropertyExist(compartment, property)) {
				// go through each stereotype property
				executeAppliedStereotypePropertyViewCreation(hostEditPart, compartment, property);

			}
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

	protected void executeAppliedStereotypeCompartmentCreation(final IGraphicalEditPart editPart, final Stereotype stereotype) {
		try {
			editPart.getEditingDomain().runExclusive(new Runnable() {


				public void run() {
					Display.getCurrent().syncExec(new Runnable() {


						public void run() {
							CreateAppliedStereotypeViewCommand command = new CreateAppliedStereotypeViewCommand(editPart.getEditingDomain(), editPart.getNotationView(), stereotype, StereotypeDisplayUtils.STEREOTYPE_COMPARTMENT_TYPE);

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

	protected void executeAppliedStereotypePropertyViewCreation(final IGraphicalEditPart editPart, final Node compartment, final Property stereotypeProperty) {
		try {
			editPart.getEditingDomain().runExclusive(new Runnable() {


				public void run() {
					Display.getCurrent().syncExec(new Runnable() {


						public void run() {

							// use to avoid to put it in the command stack
							CreateAppliedStereotypePropertyViewCommand command = new CreateAppliedStereotypePropertyViewCommand(editPart.getEditingDomain(), compartment, stereotypeProperty, StereotypeDisplayUtils.STEREOTYPE_PROPERTY_TYPE);
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


}
