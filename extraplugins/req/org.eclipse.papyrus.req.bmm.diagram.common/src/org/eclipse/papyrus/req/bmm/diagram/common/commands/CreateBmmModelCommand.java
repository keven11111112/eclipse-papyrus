/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mauricio Alferez (CEA LIST) mauricio.alferez@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.req.bmm.diagram.common.commands;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.diagram.common.commands.ModelCreationCommandBase;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Creates a BMM model
 *
 */
public class CreateBmmModelCommand extends ModelCreationCommandBase {

	public static final String COMMAND_ID = "BMM";



	public static final String PROFILES_PATHMAP = "pathmap://BMM_PROFILE/"; //$NON-NLS-1$


	public static final String BMM_PROFILE_URI = PROFILES_PATHMAP + "Bmm.profile.uml"; //$NON-NLS-1$

	/**
	 * @see org.eclipse.papyrus.core.extension.commands.ModelCreationCommandBase#createRootElement()
	 *
	 * @return
	 */

	@Override
	protected EObject createRootElement() {
		return UMLFactory.eINSTANCE.createModel();
	}

	/**
	 * @see org.eclipse.papyrus.core.extension.commands.ModelCreationCommandBase#initializeModel(org.eclipse.emf.ecore.EObject)
	 *
	 * @param owner
	 */

	@Override
	protected void initializeModel(EObject owner) {
		super.initializeModel(owner);
		((org.eclipse.uml2.uml.Package) owner).setName(getModelName());

		org.eclipse.uml2.uml.Package bmmProfile = PackageUtil.loadPackage(URI.createURI(BMM_PROFILE_URI), owner.eResource().getResourceSet());
		if ((bmmProfile != null) && (bmmProfile instanceof Profile)) {
			PackageUtil.applyProfile(((org.eclipse.uml2.uml.Package) owner), (org.eclipse.uml2.uml.Profile) bmmProfile, true);
		}
	}

	/**
	 * Gets the model name.
	 *
	 * @return the model name
	 */
	protected String getModelName() {
		return "PapyrusBMMModel";
	}


}
