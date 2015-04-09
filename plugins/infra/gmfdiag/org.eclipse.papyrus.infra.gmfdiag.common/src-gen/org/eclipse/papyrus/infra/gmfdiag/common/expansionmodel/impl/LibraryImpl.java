/**
 * Copyright (c) 2015 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.AbstractRepresentation;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionmodelPackage;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Library;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.RepresentationKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.LibraryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.LibraryImpl#getRepresentationkinds <em>Representationkinds</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.LibraryImpl#getRepresentations <em>Representations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LibraryImpl extends MinimalEObjectImpl.Container implements Library {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRepresentationkinds() <em>Representationkinds</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresentationkinds()
	 * @generated
	 * @ordered
	 */
	protected EList<RepresentationKind> representationkinds;

	/**
	 * The cached value of the '{@link #getRepresentations() <em>Representations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresentations()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractRepresentation> representations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpansionmodelPackage.Literals.LIBRARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpansionmodelPackage.LIBRARY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RepresentationKind> getRepresentationkinds() {
		if (representationkinds == null) {
			representationkinds = new EObjectContainmentEList<RepresentationKind>(RepresentationKind.class, this, ExpansionmodelPackage.LIBRARY__REPRESENTATIONKINDS);
		}
		return representationkinds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractRepresentation> getRepresentations() {
		if (representations == null) {
			representations = new EObjectContainmentEList<AbstractRepresentation>(AbstractRepresentation.class, this, ExpansionmodelPackage.LIBRARY__REPRESENTATIONS);
		}
		return representations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpansionmodelPackage.LIBRARY__REPRESENTATIONKINDS:
				return ((InternalEList<?>)getRepresentationkinds()).basicRemove(otherEnd, msgs);
			case ExpansionmodelPackage.LIBRARY__REPRESENTATIONS:
				return ((InternalEList<?>)getRepresentations()).basicRemove(otherEnd, msgs);
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
			case ExpansionmodelPackage.LIBRARY__NAME:
				return getName();
			case ExpansionmodelPackage.LIBRARY__REPRESENTATIONKINDS:
				return getRepresentationkinds();
			case ExpansionmodelPackage.LIBRARY__REPRESENTATIONS:
				return getRepresentations();
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
			case ExpansionmodelPackage.LIBRARY__NAME:
				setName((String)newValue);
				return;
			case ExpansionmodelPackage.LIBRARY__REPRESENTATIONKINDS:
				getRepresentationkinds().clear();
				getRepresentationkinds().addAll((Collection<? extends RepresentationKind>)newValue);
				return;
			case ExpansionmodelPackage.LIBRARY__REPRESENTATIONS:
				getRepresentations().clear();
				getRepresentations().addAll((Collection<? extends AbstractRepresentation>)newValue);
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
			case ExpansionmodelPackage.LIBRARY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExpansionmodelPackage.LIBRARY__REPRESENTATIONKINDS:
				getRepresentationkinds().clear();
				return;
			case ExpansionmodelPackage.LIBRARY__REPRESENTATIONS:
				getRepresentations().clear();
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
			case ExpansionmodelPackage.LIBRARY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExpansionmodelPackage.LIBRARY__REPRESENTATIONKINDS:
				return representationkinds != null && !representationkinds.isEmpty();
			case ExpansionmodelPackage.LIBRARY__REPRESENTATIONS:
				return representations != null && !representations.isEmpty();
		}
		return super.eIsSet(featureID);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //LibraryImpl
