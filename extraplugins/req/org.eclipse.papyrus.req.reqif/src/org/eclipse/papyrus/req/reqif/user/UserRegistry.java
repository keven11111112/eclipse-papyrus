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

import java.util.ArrayList;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.req.reqif.Activator;
import org.eclipse.papyrus.req.reqif.preference.ReqIFPreferenceConstants;

public class UserRegistry implements User, IUserRegistry {

	public ArrayList<User> users = new ArrayList<User>();

	protected User currentUser = null;

	public static UserRegistry instance = new UserRegistry();

	@Override
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public UserRegistry() {
		super();
		this.users.add(new SampleUser());
		this.users.add(new AdvancedUser());
	}

	/**
	 * @see org.eclipse.papyrus.req.reqif.user.IUserRegistry#getCurrentUser()
	 *
	 * @return
	 */
	@Override
	public User getCurrentUser() {
		if(currentUser != null) {
			return currentUser;
		}
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String userkind_value = store.getString(ReqIFPreferenceConstants.USER_KIND);
		for(User user : users) {
			if(user.getID().equals(userkind_value)) {
				return user;
			}
		}
		return users.get(0);
	}

	@Override
	public String getID() {
		return getCurrentUser().getID();
	}

	@Override
	public boolean canCreateProfile() {
		return getCurrentUser().canCreateProfile();
	}

	@Override
	public String getDefaultProfileName() {
		return getCurrentUser().getDefaultProfileName();
	}

	@Override
	public boolean canUseEnumerationPattern() {
		return getCurrentUser().canUseEnumerationPattern();
	}

	@Override
	public boolean canImportModel() {
		return getCurrentUser().canImportModel();
	}

	@Override
	public boolean canChooseProfile() {
		return getCurrentUser().canChooseProfile();
	}

	@Override
	public boolean canChooseTypeToImportInProfile() {
		return getCurrentUser().canChooseTypeToImportInProfile();
	}
}
