/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.facet.infra.facet.impl.FacetSetImpl;

import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.EObjectFacetRepresentation;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetPackage;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetSetImpl#getRepresentedElement_XMI_ID <em>Represented Element XMI ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetSetImpl#getProfileQualifiedName <em>Profile Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetSetImpl#getStereotypeFacets <em>Stereotype Facets</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetSetImpl#getSubProfileFacetSet <em>Sub Profile Facet Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProfileFacetSetImpl extends FacetSetImpl implements ProfileFacetSet {
	/**
	 * The default value of the '{@link #getRepresentedElement_XMI_ID() <em>Represented Element XMI ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresentedElement_XMI_ID()
	 * @generated
	 * @ordered
	 */
	protected static final String REPRESENTED_ELEMENT_XMI_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepresentedElement_XMI_ID() <em>Represented Element XMI ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresentedElement_XMI_ID()
	 * @generated
	 * @ordered
	 */
	protected String representedElement_XMI_ID = REPRESENTED_ELEMENT_XMI_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getProfileQualifiedName() <em>Profile Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROFILE_QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProfileQualifiedName() <em>Profile Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String profileQualifiedName = PROFILE_QUALIFIED_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStereotypeFacets() <em>Stereotype Facets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypeFacets()
	 * @generated
	 * @ordered
	 */
	protected EList<StereotypeFacet> stereotypeFacets;

	/**
	 * The cached value of the '{@link #getSubProfileFacetSet() <em>Sub Profile Facet Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubProfileFacetSet()
	 * @generated
	 * @ordered
	 */
	protected ProfileFacetSet subProfileFacetSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProfileFacetSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfileFacetPackage.Literals.PROFILE_FACET_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepresentedElement_XMI_ID() {
		return representedElement_XMI_ID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresentedElement_XMI_ID(String newRepresentedElement_XMI_ID) {
		String oldRepresentedElement_XMI_ID = representedElement_XMI_ID;
		representedElement_XMI_ID = newRepresentedElement_XMI_ID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID, oldRepresentedElement_XMI_ID, representedElement_XMI_ID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProfileQualifiedName() {
		return profileQualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileQualifiedName(String newProfileQualifiedName) {
		String oldProfileQualifiedName = profileQualifiedName;
		profileQualifiedName = newProfileQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME, oldProfileQualifiedName, profileQualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StereotypeFacet> getStereotypeFacets() {
		if (stereotypeFacets == null) {
			stereotypeFacets = new EObjectContainmentEList<StereotypeFacet>(StereotypeFacet.class, this, ProfileFacetPackage.PROFILE_FACET_SET__STEREOTYPE_FACETS);
		}
		return stereotypeFacets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfileFacetSet getSubProfileFacetSet() {
		return subProfileFacetSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubProfileFacetSet(ProfileFacetSet newSubProfileFacetSet, NotificationChain msgs) {
		ProfileFacetSet oldSubProfileFacetSet = subProfileFacetSet;
		subProfileFacetSet = newSubProfileFacetSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProfileFacetPackage.PROFILE_FACET_SET__SUB_PROFILE_FACET_SET, oldSubProfileFacetSet, newSubProfileFacetSet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubProfileFacetSet(ProfileFacetSet newSubProfileFacetSet) {
		if (newSubProfileFacetSet != subProfileFacetSet) {
			NotificationChain msgs = null;
			if (subProfileFacetSet != null)
				msgs = ((InternalEObject)subProfileFacetSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProfileFacetPackage.PROFILE_FACET_SET__SUB_PROFILE_FACET_SET, null, msgs);
			if (newSubProfileFacetSet != null)
				msgs = ((InternalEObject)newSubProfileFacetSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProfileFacetPackage.PROFILE_FACET_SET__SUB_PROFILE_FACET_SET, null, msgs);
			msgs = basicSetSubProfileFacetSet(newSubProfileFacetSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileFacetPackage.PROFILE_FACET_SET__SUB_PROFILE_FACET_SET, newSubProfileFacetSet, newSubProfileFacetSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProfileFacetPackage.PROFILE_FACET_SET__STEREOTYPE_FACETS:
				return ((InternalEList<?>)getStereotypeFacets()).basicRemove(otherEnd, msgs);
			case ProfileFacetPackage.PROFILE_FACET_SET__SUB_PROFILE_FACET_SET:
				return basicSetSubProfileFacetSet(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProfileFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID:
				return getRepresentedElement_XMI_ID();
			case ProfileFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME:
				return getProfileQualifiedName();
			case ProfileFacetPackage.PROFILE_FACET_SET__STEREOTYPE_FACETS:
				return getStereotypeFacets();
			case ProfileFacetPackage.PROFILE_FACET_SET__SUB_PROFILE_FACET_SET:
				return getSubProfileFacetSet();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProfileFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID:
				setRepresentedElement_XMI_ID((String)newValue);
				return;
			case ProfileFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME:
				setProfileQualifiedName((String)newValue);
				return;
			case ProfileFacetPackage.PROFILE_FACET_SET__STEREOTYPE_FACETS:
				getStereotypeFacets().clear();
				getStereotypeFacets().addAll((Collection<? extends StereotypeFacet>)newValue);
				return;
			case ProfileFacetPackage.PROFILE_FACET_SET__SUB_PROFILE_FACET_SET:
				setSubProfileFacetSet((ProfileFacetSet)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ProfileFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID:
				setRepresentedElement_XMI_ID(REPRESENTED_ELEMENT_XMI_ID_EDEFAULT);
				return;
			case ProfileFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME:
				setProfileQualifiedName(PROFILE_QUALIFIED_NAME_EDEFAULT);
				return;
			case ProfileFacetPackage.PROFILE_FACET_SET__STEREOTYPE_FACETS:
				getStereotypeFacets().clear();
				return;
			case ProfileFacetPackage.PROFILE_FACET_SET__SUB_PROFILE_FACET_SET:
				setSubProfileFacetSet((ProfileFacetSet)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ProfileFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID:
				return REPRESENTED_ELEMENT_XMI_ID_EDEFAULT == null ? representedElement_XMI_ID != null : !REPRESENTED_ELEMENT_XMI_ID_EDEFAULT.equals(representedElement_XMI_ID);
			case ProfileFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME:
				return PROFILE_QUALIFIED_NAME_EDEFAULT == null ? profileQualifiedName != null : !PROFILE_QUALIFIED_NAME_EDEFAULT.equals(profileQualifiedName);
			case ProfileFacetPackage.PROFILE_FACET_SET__STEREOTYPE_FACETS:
				return stereotypeFacets != null && !stereotypeFacets.isEmpty();
			case ProfileFacetPackage.PROFILE_FACET_SET__SUB_PROFILE_FACET_SET:
				return subProfileFacetSet != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EObject.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == EObjectFacetRepresentation.class) {
			switch (derivedFeatureID) {
				case ProfileFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID: return ProfileFacetPackage.EOBJECT_FACET_REPRESENTATION__REPRESENTED_ELEMENT_XMI_ID;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EObject.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == EObjectFacetRepresentation.class) {
			switch (baseFeatureID) {
				case ProfileFacetPackage.EOBJECT_FACET_REPRESENTATION__REPRESENTED_ELEMENT_XMI_ID: return ProfileFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (representedElement_XMI_ID: "); //$NON-NLS-1$
		result.append(representedElement_XMI_ID);
		result.append(", profileQualifiedName: "); //$NON-NLS-1$
		result.append(profileQualifiedName);
		result.append(')');
		return result.toString();
	}

} //ProfileFacetSetImpl
