/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Mauricio Alferez (mauricio.alferez@cea.fr) CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.requirements.sysml.matrix.common.helpers;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;

@SuppressWarnings("deprecation")
public class Helper {
	/**
	 * Deletes a relationship between an stereotyped UML element represented in
	 * a column, and an element represented in the row.
	 * 
	 * @param domain
	 *            the TransactionalEditingDomain
	 * @param row
	 *            the element in the row represented by the IAxis using
	 *            IAxis.getElement(), otherwise the element itself
	 * @param colUMLElement
	 *            the UML element in the column
	 * @param columnStereotypeQN
	 *            the qualified name of the stereotype of the UML element in the
	 *            column, ex. "SysML::Requirements::Requirement"
	 * @param columnStereotypePropertyName
	 *            the qualified name of the property of the stereotype of the
	 *            UML element in the column, ex. "verifiedBy"
	 * @param abstractionStereotypeToDeleteQN
	 *            the qualified name of the stereotype of the abstraction that
	 *            we will deleted, ex. SysML::Requirements::Verify
	 */
	public static void deleteRelationshipInIntersection(final TransactionalEditingDomain domain, final Object row,
			final Element colUMLElement, final String columnStereotypeQN, final String columnStereotypePropertyName,
			final String abstractionStereotypeToDeleteQN) {
		EObject eObjectInRow = (EObject) row;
		Stereotype columnStereotype = colUMLElement.getAppliedStereotype(columnStereotypeQN);
		Object listOfPropertySatisfyingObjects = colUMLElement.getValue(columnStereotype, columnStereotypePropertyName);
		if (listOfPropertySatisfyingObjects instanceof EList<?>) {
			@SuppressWarnings("unchecked")
			EList<EObject> list = (EList<EObject>) listOfPropertySatisfyingObjects;
			// Check if the element in the current row is in the list
			Dependency toDestroy = null;
			for (EObject propertySatisfyingObject : list) {
				if (toDestroy == null) {
					if (eObjectInRow.equals(propertySatisfyingObject)) {
						EList<Dependency> dependencies = ((NamedElement) propertySatisfyingObject)
								.getClientDependencies();
						Iterator<Dependency> iter = dependencies.iterator();
						while (iter.hasNext() && toDestroy == null) {
							Dependency dependency = iter.next();
							if (dependency instanceof Abstraction) {
								if (dependency.getAppliedStereotype(abstractionStereotypeToDeleteQN) != null) {
									if (dependency.getClients().contains(row)
											&& dependency.getSuppliers().contains(colUMLElement)) {
										toDestroy = dependency;
									}
								}
							}
						}

					}
				}
			}

			if (toDestroy != null) {
				DestroyElementRequest req = new DestroyElementRequest(toDestroy, true);
				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(toDestroy);
				ICommand cmd = provider.getEditCommand(req);
				if (cmd != null && cmd.canExecute()) {
					domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
				}
			}
		}
	}
}
