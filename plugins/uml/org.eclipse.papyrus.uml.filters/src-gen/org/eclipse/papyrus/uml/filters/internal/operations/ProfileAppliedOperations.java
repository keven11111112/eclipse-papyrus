/**
 * Copyright (c) 2014 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 */
package org.eclipse.papyrus.uml.filters.internal.operations;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.filters.internal.UMLFiltersPlugin;
import org.eclipse.papyrus.uml.filters.ProfileApplied;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

import com.google.common.base.Strings;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Profile Applied</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.filters.Filter#matches(java.lang.Object) <em>Matches</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.filters.ProfileApplied#resolveProfile(java.lang.Object) <em>Resolve Profile</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProfileAppliedOperations
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ProfileAppliedOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static boolean matches(ProfileApplied profileApplied, Object input)
	{
		boolean result = false;

		if (!(input instanceof EObject) && (input instanceof IAdaptable)) {
			input = ((IAdaptable) input).getAdapter(EObject.class);
		}

		if (input instanceof Element) {
			Package package_ = ((Element) input).getNearestPackage();
			if (package_ != null) {
				Profile profile = profileApplied.resolveProfile(package_);
				if ((profile != null) && !profile.eIsProxy()) {
					// Test for exact profile application
					result = package_.getProfileApplication(profile, true) != null;
				} else if (!Strings.isNullOrEmpty(profileApplied.getProfileQualifiedName())) {
					String qname = profileApplied.getProfileQualifiedName();

					for (Profile next : package_.getAllAppliedProfiles()) {
						if (qname.equals(next.getQualifiedName())) {
							result = true;
							break;
						}
					}
				}
			}
		}

		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static Profile resolveProfile(ProfileApplied profileApplied, Object context)
	{
		Profile result = null;

		if (!(context instanceof EObject) && (context instanceof IAdaptable)) {
			context = ((IAdaptable) context).getAdapter(EObject.class);
		}

		if ((profileApplied.getProfileURI() != null) && (context instanceof EObject)) {
			Resource resource = ((EObject) context).eResource();
			ResourceSet rset = (resource == null) ? null : resource.getResourceSet();
			if (rset != null) {
				try {
					URI uri = URI.createURI(profileApplied.getProfileURI(), true);
					EObject resolved = rset.getEObject(uri, true);
					if (resolved instanceof Profile) {
						result = (Profile) resolved;
					}
				} catch (Exception e) {
					UMLFiltersPlugin.INSTANCE.log(e);
					// Fine. Unresolved
				}
			}
		}

		return result;
	}

} // ProfileAppliedOperations