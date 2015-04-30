/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Fadwa TMAR (CEA LIST) fadwa.tmar@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.soaml.diagram.common.commands;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.diagram.common.commands.ModelCreationCommandBase;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;

public class CreateSoamlModelCommand extends ModelCreationCommandBase {

	public static final String COMMAND_ID = "soaML";


	
	public static final String PROFILES_PATHMAP = "pathmap://SoaML_PROFILES/"; //$NON-NLS-1$


	public static final String SOAML_PROFILE_URI = PROFILES_PATHMAP + "SoaMLProfile.profile.uml"; //$NON-NLS-1$

	//public static final String FCM_PROFILE_URI = "pathmap://FCM_PROFILES/FCM.profile.uml";

	//public static final String SOAML_PROFILE_URI = PROFILES_PATHMAP + "SoaML.profile.uml"; //$NON-NLS-1$


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
		((org.eclipse.uml2.uml.Package)owner).setName(getModelName());

		// Retrieve soaml profile and apply with Sub-profile
		org.eclipse.uml2.uml.Package soaml = PackageUtil.loadPackage(URI.createURI(SOAML_PROFILE_URI), owner.eResource().getResourceSet());
		//org.eclipse.uml2.uml.Package fcm = PackageUtil.loadPackage(URI.createURI(FCM_PROFILE_URI), owner.eResource().getResourceSet());
		if((soaml != null) && (soaml instanceof Profile)) {
			PackageUtil.applyProfile(((org.eclipse.uml2.uml.Package)owner), (org.eclipse.uml2.uml.Profile)soaml, true);
			//PackageUtil.applyProfile(((org.eclipse.uml2.uml.Package)owner), (org.eclipse.uml2.uml.Profile) fcm, true);
		}
	}

	/**
	 * Gets the model name.
	 * 
	 * @return the model name
	 */
	protected String getModelName() {
		return "SoaMLModel";
	}


}
