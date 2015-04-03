/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Celine JANSSENS (ALL4TEC) celine.janssens@all4tec.net - Initial API and implementation
 *   Celine JANSSENS (ALL4TEC) celine.janssens@all4tec.net - Bug 455311 : Refactor Stereotype Display
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.stereotype.migration.editpolicies;

import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editparts.UMLCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.stereotype.migration.commands.StereotypeNestedPropertiesMigrationCommand;

/**
 * Edit Policy to manage the migration of the object into Compartment :
 * <ul>
 * <li>Operations</li>
 * <li>Properties</li>
 * <li>Nested Element</li>
 * <li>Enumeration</li>
 * <li>....</li>
 * </ul>
 * 
 * To be applied on all the instances of {@link UMLCompartmentEditPart}.
 * 
 * @author Céline JANSSENS
 *
 */
public class StereotypeEAnnotationNestedMigrationEditPolicy extends StereotypeEAnnotationPropertiesMigrationEditPolicy {


	/**
	 * Constructor.
	 *
	 */
	public StereotypeEAnnotationNestedMigrationEditPolicy() {
		super();
	}


	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.stereotype.migration.editpolicies.StereotypeEAnnotationMigrationEditPolicy#activate()
	 *
	 */
	@Override
	public void activate() {
		if (getHost() instanceof GraphicalEditPart) {
			this.editPart = (GraphicalEditPart) getHost();
		}

		if (editPart instanceof UMLCompartmentEditPart && editPart.getModel() instanceof View) {
			this.hostView = (View) editPart.getModel();
		}

		if (editPart != null && hostView != null) {
			this.eAnnotation = migrationHelper.getStereotypeEAnnotation(hostView);
			migrateStereotype();
		}
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.stereotype.migration.editpolicies.StereotypeEAnnotationPropertiesMigrationEditPolicy#getStereotypeMigrationCommand(org.eclipse.gmf.runtime.notation.View)
	 * 
	 */
	@Override
	public Runnable getStereotypeMigrationCommand(View view) {

		return new StereotypeNestedPropertiesMigrationCommand(LABEL, view);
	}

}
