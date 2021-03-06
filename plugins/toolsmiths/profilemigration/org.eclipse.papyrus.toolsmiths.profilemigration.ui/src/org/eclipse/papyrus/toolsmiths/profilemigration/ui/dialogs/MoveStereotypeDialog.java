/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Pauline DEVILLE (CEA LIST) pauline.deville@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.toolsmiths.profilemigration.ui.dialogs;

import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.toolsmiths.profilemigration.ui.Messages;
import org.eclipse.papyrus.toolsmiths.profilemigration.ui.preferences.ProfileMigrationPreferenceConstants;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Dialog to ask to user if he want to apply a profile or not
 */
public class MoveStereotypeDialog extends AbstractApplyNewProfileDialog {

	private static String DIALOG_TITLE = Messages.MoveStereotypeDialog_title;

	private Stereotype stereotype;

	private Profile newProfile;

	/**
	 * Constructor.
	 *
	 * @param shell
	 *            the active shell
	 * @param stereotype
	 *            the moved stereotype
	 * @param newProfile
	 *            the new profile to apply
	 */
	public MoveStereotypeDialog(Shell shell, Stereotype stereotype, Profile newProfile) {
		super(shell, DIALOG_TITLE, ProfileMigrationPreferenceConstants.STEREOTYPE_MOVE, newProfile);
		this.stereotype = stereotype;
		this.newProfile = newProfile;
	}

	@Override
	protected String getDecription() {
		return NLS.bind(Messages.MoveStereotypeDialog_description, stereotype.getName(), newProfile.getName());
	}

}
