/*****************************************************************************
 * Copyright (c) 2020 Christian W. Damus, CEA LIST, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.toolsmiths.validation.elementtypes.internal.checkers;

import static org.eclipse.papyrus.toolsmiths.validation.common.utils.ModelResourceMapper.byExtension;
import static org.eclipse.papyrus.toolsmiths.validation.common.utils.ModelResourceMapper.rootsOfType;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.toolsmiths.validation.common.utils.ModelResourceMapper;
import org.eclipse.papyrus.toolsmiths.validation.elementtypes.Activator;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UMLPlugin;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.google.common.collect.Iterators;

/**
 * An index of available profiles that is local to a {@code ResourceSet}.
 * Unlike the <em>Papyrus Profile Index</em>, this doesn't only have profiles in the workspace
 * but also profiles in the target platform.
 */
public class LocalProfileIndex {

	private final ResourceSet resourceSet;
	private boolean workspaceLoaded;

	private LocalProfileIndex(ResourceSet resourceSet) {
		super();

		this.resourceSet = resourceSet;
	}

	/**
	 * Get the cached instance of the local profile index from the validation {@code context},
	 * creating it and putting it into the context if necessary.
	 *
	 * @param eObject
	 *            the model context from which to access a resource set (usually the model being validated)
	 * @param context
	 *            the validation context
	 * @return the local profile index
	 */
	static LocalProfileIndex getInstance(EObject eObject, Map<Object, Object> context) {
		return (LocalProfileIndex) context.computeIfAbsent(LocalProfileIndex.class, __ -> new LocalProfileIndex(eObject.eResource().getResourceSet()));
	}

	/**
	 * Get a profile by qualified name, in the context of the given model object.
	 *
	 * @param qualifiedName
	 *            the qualified name of the profile to retrieve
	 * @param context
	 *            the model context from which to access a resource set (usually the model being validated)
	 * @return the named profile, or {@code null} if not found
	 */
	public Profile getProfile(String qualifiedName, EObject context) {
		Profile result = null;

		out: for (URI registeredProfile : UMLPlugin.getEPackageNsURIToProfileLocationMap().values()) {
			try {
				Resource resource = resourceSet.getResource(registeredProfile.trimFragment(), true);
				Collection<Profile> loadedProfiles = EcoreUtil.getObjectsByType(resource.getContents(), UMLPackage.Literals.PROFILE);
				for (Profile profile : loadedProfiles) {
					if (qualifiedName.equals(profile.getQualifiedName())) {
						result = profile;
						break out;
					}
				}
			} catch (Exception e) {
				Activator.log.error("Failed to load registered profile.", e); //$NON-NLS-1$
			}
		}

		if (result == null) {
			// Look in the workspace
			loadWorkspace();
			result = (Profile) UMLUtil.findNamedElements(resourceSet, qualifiedName, false, UMLPackage.Literals.PROFILE)
					.stream().findAny().orElse(null);
		}

		return result;
	}

	/**
	 * Get a stereotype by qualified name, in the context of the given model object. With known profile
	 * qualified names as hints, we can optimize the search by looking into registered profiles, first.
	 *
	 * @param qualifiedName
	 *            the qualified name of the stereotype to retrieve
	 * @param profileQualifiedNames
	 *            to try first as hints
	 * @param context
	 *            the model context from which to access a resource set (usually the model being validated)
	 * @return the named profile, or {@code null} if not found
	 */
	public Stereotype getStereotype(String qualifiedName, Collection<String> profileQualifiedNames, EObject context) {
		Stereotype result = null;

		// First, search the profiles by URI
		for (Iterator<String> iter = profileQualifiedNames.iterator(); iter.hasNext() && result == null;) {
			// First-pass filter: check that the profile name is a prefix of the stereotype name
			String profileName = iter.next();
			if (!qualifiedName.startsWith(profileName + NamedElement.SEPARATOR)) {
				continue;
			}

			Profile profile = getProfile(profileName, context);
			if (profile != null) {
				result = (Stereotype) UMLUtil.findNamedElements(profile.eResource(), qualifiedName, false, UMLPackage.Literals.STEREOTYPE)
						.stream().findAny().orElse(null);
			}
		}

		if (result == null) {
			// Didn't find it the easy way? Look in the workspace
			loadWorkspace();
			result = (Stereotype) UMLUtil.findNamedElements(resourceSet, qualifiedName, false, UMLPackage.Literals.STEREOTYPE)
					.stream().findAny().orElse(null);
		}

		return result;
	}

	Iterator<EObject> resourceRoots() {
		@SuppressWarnings("serial")
		TreeIterator<?> roots = new AbstractTreeIterator<>(resourceSet, false) {
			@Override
			protected Iterator<? extends Object> getChildren(Object object) {
				if (object instanceof ResourceSet) {
					return ((ResourceSet) object).getResources().iterator();
				} else if (object instanceof Resource) {
					return ((Resource) object).getContents().iterator();
				} else {
					return Collections.emptyIterator();
				}
			}
		};

		return Iterators.filter(roots, EObject.class);
	}

	private void loadWorkspace() {
		if (!workspaceLoaded) {
			workspaceLoaded = true;

			ModelResourceMapper<Profile> profileMapper = new ModelResourceMapper<>(ResourcesPlugin.getWorkspace().getRoot());
			profileMapper.map(byExtension("uml"), __ -> resourceSet, rootsOfType(Profile.class));
		}
	}

}
