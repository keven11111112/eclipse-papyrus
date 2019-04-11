/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.toolsmiths.validation.profile.checkers;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.MarkersManagementUtils;
import org.eclipse.papyrus.toolsmiths.validation.profile.constants.ProfilePluginValidationConstants;
import org.eclipse.papyrus.uml.tools.profile.definition.IPapyrusVersionConstants;
import org.eclipse.papyrus.uml.tools.profile.definition.PapyrusDefinitionAnnotation;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This class allows to check profiles don't have any definition (because it's not working with static profile).
 */
public class ProfileDefinitionChecker {

	/**
	 * This allows to check that profiles does not have any definition.
	 *
	 * @param project
	 *            The current project to check.
	 * @param profileFile
	 *            The profile for which one to check.
	 * @param existingProfiles
	 *            The existing profiles in the UML file.
	 */
	public static void checkProfilesDefinition(final IProject project, final IFile profileFile, final Collection<Profile> existingProfiles) {

		// Create the conditions:
		// - Copy of existing profiles (that will be removed if there are found in uml generated package extension points)
		// - Boolean to check if the UMLProfile is defined for the profile
		final Collection<Profile> profiles = new HashSet<>(existingProfiles);

		final Iterator<Profile> profilesIt = profiles.iterator();
		while (profilesIt.hasNext()) {
			final Profile currentProfile = profilesIt.next();
			if (!hasProfileDefinition(currentProfile)) {
				profilesIt.remove();
			}
		}

		// Create markers (one by missing profile) for uml generated package extension point if needed
		if (!profiles.isEmpty()) {
			for (final Profile profile : profiles) {
				MarkersManagementUtils.createMarker(
						profileFile,
						ProfilePluginValidationConstants.PROFILE_PLUGIN_VALIDATION_TYPE,
						"The profile '" + profile.getName() + "' contain a definition but should not", //$NON-NLS-1$ //$NON-NLS-2$
						IMarker.SEVERITY_ERROR);
			}
		}
	}

	/**
	 * This allows to define if a profile definition is defined for the profile.
	 *
	 * @param profile
	 *            The profile to check.
	 * @return <code>true</code> if a definition for the profile is found, <code>false</code> otherwise.
	 */
	private static boolean hasProfileDefinition(final Profile profile) {
		boolean result = false;

		final EAnnotation umlAnnotation = profile.getEAnnotation(UMLUtil.UML2_UML_PACKAGE_2_0_NS_URI);
		if (null != umlAnnotation && !umlAnnotation.getContents().isEmpty()) {
			for (final EObject content : umlAnnotation.getContents()) {
				if (content instanceof EModelElement) {
					final EAnnotation papyrusVersionAnnotation = ((EModelElement) content).getEAnnotation(IPapyrusVersionConstants.PAPYRUS_EANNOTATION_SOURCE);
					if (null != papyrusVersionAnnotation) {
						final PapyrusDefinitionAnnotation parsedAnnotation = PapyrusDefinitionAnnotation.parseEAnnotation(papyrusVersionAnnotation);
						if (!PapyrusDefinitionAnnotation.UNDEFINED_ANNOTATION.equals(parsedAnnotation)) {
							result = true;
						}
					}
				}
			}
		}

		return result;
	}

}
