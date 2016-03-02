/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.req.reqif.user;

public class AdvancedUser implements User {

	public static final String ADVANCED_USER = "ADVANCED_USER";

	@Override
	public boolean canCreateProfile() {
		return true;
	}

	@Override
	public String getDefaultProfileName() {
		return "MyRequirementProfile";
	}

	@Override
	public String getID() {
		return ADVANCED_USER;
	}

	@Override
	public boolean canUseEnumerationPattern() {
		return true;
	}

	@Override
	public boolean canImportModel() {
		return true;
	}

	@Override
	public boolean canChooseProfile() {
		return true;
	}

	@Override
	public boolean canChooseTypeToImportInProfile() {
		return true;
	}
}
