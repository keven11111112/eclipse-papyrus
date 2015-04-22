/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 * 		Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * this helper has been specified in order to prevent to create or move a component into a component by using the role
 * "nestedClassifier". The good role is "packagedElement"
 *
 */
public class ComponentEditHelper extends ElementEditHelper {

	/**
	 * Constructor.
	 *
	 */
	public ComponentEditHelper() {
		getDefaultContainmentFeatures().put(UMLPackage.eINSTANCE.getClassifier(), UMLPackage.eINSTANCE.getComponent_PackagedElement());
	}

	@Override
	protected ICommand getCreateCommand(CreateElementRequest req) {

		// override the creation in order to prevent to create a component into a component by using the role "nestedClassifier"
		EObject owner = req.getContainer();
		EReference eref = req.getContainmentFeature();

		if (owner instanceof Component && eref == UMLPackage.eINSTANCE.getClass_NestedClassifier() && req.getElementType().getEClass() == UMLPackage.eINSTANCE.getComponent()) {
			return UnexecutableCommand.INSTANCE;
		}

		return super.getCreateCommand(req);
	}

	@Override
	protected ICommand getMoveCommand(MoveRequest req) {
		// override the creation in order to prevent to move a component into a component by using the role "nestedClassifier"
		for (Object elementToMove : req.getElementsToMove().keySet()) {
			if (elementToMove instanceof Component && (UMLPackage.eINSTANCE.getClass_NestedClassifier().equals(req.getTargetFeature((EObject) elementToMove)))) {
				return UnexecutableCommand.INSTANCE;
			}
		}

		return super.getMoveCommand(req);
	}

	@Override
	protected ICommand getSetCommand(SetRequest req) {
		// override the creation in order to prevent to set a component into a component by using the role "nestedClassifier"
		EObject eobject = req.getElementToEdit();
		if (eobject instanceof Component && (UMLPackage.eINSTANCE.getComponent_PackagedElement().equals(req.getFeature()))) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.getSetCommand(req);
	}

}
