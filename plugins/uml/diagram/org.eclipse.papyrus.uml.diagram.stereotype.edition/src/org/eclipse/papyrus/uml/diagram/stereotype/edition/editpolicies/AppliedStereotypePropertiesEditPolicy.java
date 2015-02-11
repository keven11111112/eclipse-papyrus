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
 *  Gabriel Pascual (ALL4TEC) - Bug 441195
 *  Celine Janssens (ALL4TEC) celine.janssens@all4tec.net - Bug 455311 : Refactor Stereotypes Display
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.stereotype.edition.editpolicies;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.GMFUnsafe;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.stereotype.StereotypeDisplayUtils;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.command.CreateAppliedStereotypePropertyViewCommand;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This editPolicy is used to add dynamically labels of stereotypes into nodes in the context of AppliedStereorypeCompartmentEditpart
 */
public class AppliedStereotypePropertiesEditPolicy extends AppliedStereotypeNodeLabelDisplayEditPolicy {


	public static String APPLIED_STEREOTYPE_VISIBILITY_COMPARTMENT = "AppliedStereotypeVisibilityEditPolicy";

	/**
	 * Creates a new AppliedStereotype display edit policy
	 */
	public AppliedStereotypePropertiesEditPolicy() {
		super();
	}

	/**
	 * Returns the uml element controlled by the host edit part
	 *
	 * @return the uml element controlled by the host edit part
	 */
	@Override
	protected Element getUMLElement() {
		Element element = null;

		View view = getView();
		if (view != null) {

			EObject container = view.eContainer();
			if (container instanceof View) {
				element = (Element) ((View) container).getElement();
			}
		}

		return element;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.AbstractAppliedStereotypeDisplayEditPolicy#getView()
	 *
	 * @return
	 */
	@Override
	protected View getView() {
		View view = null;

		Object model = getHost().getModel();
		if (model instanceof View) {

			EObject container = ((View) model).eContainer();
			if (container instanceof View) {
				view = (View) container;
			}
		}
		return view;
	}


	/**
	 * this method is used to create a notation node for the property of the stereotype
	 *
	 * @param editPart
	 *            the editpart container
	 * @param stereotypeApplication
	 * @param stereotype
	 *            the stereotype associated to compartment node
	 */
	protected void executeAppliedStereotypePropertyViewCreation(final GraphicalEditPart editPart, final Property stereotypeProperty, final EObject stereotypeApplication) {
		try {
			editPart.getEditingDomain().runExclusive(new Runnable() {

				public void run() {
					Display.getCurrent().syncExec(new Runnable() {

						public void run() {

							// use to avoid to put it in the command stack
							CreateAppliedStereotypePropertyViewCommand command = new CreateAppliedStereotypePropertyViewCommand(editPart.getEditingDomain(), editPart.getNotationView(), stereotypeProperty, stereotypeApplication);
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
	 *
	 * {@inheritedDoc}
	 */
	@Override
	public void notifyChanged(Notification notification) {
		// refresh only when the EAnnotation about stereotype is added or remove
		// to update only property of stereotype application
		final int eventType = notification.getEventType();
		final Object newValue = notification.getNewValue();
		final Object notifier = notification.getNotifier();
		final Object oldValue = notification.getOldValue();

		if (eventType == Notification.ADD && newValue instanceof Node) {
			if (((Node) newValue).getType().equals(StereotypeDisplayUtils.STEREOTYPE_COMPARTMENT_TYPE)) {
				if (notifier instanceof Node) {

					// a stereotype was applied to the notifier
					// then a new listener should be added to the stereotype application
					getDiagramEventBroker().addNotificationListener((EObject) notification.getNewValue(), this);
					createAppliedStereotypeProperty((Node) newValue);
				}
			}

		} else if (eventType == Notification.REMOVE && oldValue instanceof Node) {
			if (((Node) oldValue).getType().equals(StereotypeDisplayUtils.STEREOTYPE_COMPARTMENT_TYPE)) {
				if (notifier instanceof Node) {
					getDiagramEventBroker().removeNotificationListener((EObject) notification.getOldValue(), this);

				}
			}
		}

	}


	/**
	 * maybe to remove
	 */
	protected void refreshEAnnotation() {
		final GraphicalEditPart editPart = (GraphicalEditPart) getHost();
		String presentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind((View) editPart.getNotationView().eContainer());
		EObject stereotypeApplication = editPart.resolveSemanticElement();
		Stereotype stereotype = UMLUtil.getStereotype(stereotypeApplication);
		final RecordingCommand command = AppliedStereotypeHelper.getAddAppliedStereotypeCommand(editPart.getEditingDomain(), editPart.getNotationView(), stereotype.getQualifiedName(), presentationKind);
		try {

			editPart.getEditingDomain().runExclusive(new Runnable() {

				public void run() {
					Display.getCurrent().syncExec(new Runnable() {

						public void run() {
							editPart.getEditingDomain().getCommandStack().execute(command);
						}
					});
				}
			});

		} catch (Exception e) {
			Activator.log.error(e);
		}
	}

	@Override
	protected void refreshStereotypeDisplay() {
	}

	/**
	 * In charge of property view creation
	 * 
	 * @param eObject
	 *            The Edit Part of which the Properties should be created
	 */
	public void createAppliedStereotypeProperty(Node compartment) {
		if (compartment != null) {
			if (getHost() instanceof GraphicalEditPart) {
				GraphicalEditPart editPart = (GraphicalEditPart) getHost();
				View view = editPart.getNotationView();
				if (view != null) {
					EObject stereotypeApplication = compartment.getElement();
					EObject element = view.getElement();
					Stereotype stereotype = UMLUtil.getStereotype(stereotypeApplication);
					if (stereotype != null) {
						EList<Property> properties = stereotype.allAttributes();
						for (Property property : properties) {

							// if stereotype is null all property of stereotype has to be removed!
							if (property != null && !property.getName().startsWith(Extension.METACLASS_ROLE_PREFIX)) {
								// go through each stereotype property
								if (element.equals(stereotypeApplication)) {
									executeAppliedStereotypePropertyViewCreation(editPart, property, stereotypeApplication);
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Refreshes the stereotype application property
	 */
	@Override
	public void refreshDisplay() {
		if (((View) getHost().getModel()).eContainer() != null) {

			final GraphicalEditPart editPart = (GraphicalEditPart) getHost();

		}
	}

}
