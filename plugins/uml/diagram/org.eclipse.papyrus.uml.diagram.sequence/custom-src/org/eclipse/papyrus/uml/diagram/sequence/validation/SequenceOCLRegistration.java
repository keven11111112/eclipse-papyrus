/*****************************************************************************
 * Copyright (c) 2018 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.validation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.service.validation.AbstractOCLRegistration;
import org.eclipse.uml2.uml.Profile;

/**
 * Validation extension for OCL constraints specific to Interactions in a sequence diagram.
 */
public class SequenceOCLRegistration extends AbstractOCLRegistration {

	/**
	 * Initializes me.
	 */
	public SequenceOCLRegistration() {
		super();
	}

	@Override
	protected URI getOCLFileURI() {
		return URI.createPlatformPluginURI(UMLDiagramEditorPlugin.ID + "/model/seqd_constraints.ocl", true); //$NON-NLS-1$
	}

	@Override
	protected boolean isApplicable(EObject element) {
		EObject root = EcoreUtil.getRootContainer(element);
		return root instanceof org.eclipse.uml2.uml.Package && !(root instanceof Profile);
	}

}
