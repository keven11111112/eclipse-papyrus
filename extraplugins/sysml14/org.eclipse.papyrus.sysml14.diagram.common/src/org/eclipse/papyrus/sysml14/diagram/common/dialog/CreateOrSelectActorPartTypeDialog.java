/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml14.diagram.common.dialog;

import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.papyrus.uml.diagram.common.dialogs.CreateOrSelectTypeDialog;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Dialog for initialization of Part (Property) type (the type is either selected or created).
 */
public class CreateOrSelectActorPartTypeDialog extends CreateOrSelectTypeDialog {

	/** Constructor */
	public CreateOrSelectActorPartTypeDialog(Shell shell, NamedElement owner) {
		super(shell, owner, ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Actor"), 
				UMLPackage.eINSTANCE.getTypedElement_Type(),
				UMLPackage.eINSTANCE.getActor(),
				UMLElementTypes.PACKAGE,
				UMLPackage.eINSTANCE.getPackage_PackagedElement(), null);
	}
}
