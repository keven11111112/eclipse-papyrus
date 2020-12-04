/*******************************************************************************
 * Copyright (c) 2005, 2020 Borland Software Corporation, CEA LIST, ARTAL
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 * 
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     Borland - initial API and implementation
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id: ReferenceNewElementSpecImpl.java,v 1.5 2008/04/17 11:58:49 atikhomirov Exp $
 */
package org.eclipse.papyrus.gmf.mappings.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.gmf.mappings.FeatureSeqInitializer;
import org.eclipse.papyrus.gmf.mappings.GMFMapPackage;
import org.eclipse.papyrus.gmf.mappings.ReferenceNewElementSpec;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference New Element Spec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.impl.ReferenceNewElementSpecImpl#getNewElementInitializers <em>New Element Initializers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceNewElementSpecImpl extends FeatureInitializerImpl implements ReferenceNewElementSpec {
	/**
	 * The cached value of the '{@link #getNewElementInitializers() <em>New Element Initializers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewElementInitializers()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureSeqInitializer> newElementInitializers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceNewElementSpecImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFMapPackage.eINSTANCE.getReferenceNewElementSpec();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureSeqInitializer> getNewElementInitializers() {
		if (newElementInitializers == null) {
			newElementInitializers = new EObjectContainmentWithInverseEList<FeatureSeqInitializer>(FeatureSeqInitializer.class, this, GMFMapPackage.REFERENCE_NEW_ELEMENT_SPEC__NEW_ELEMENT_INITIALIZERS, GMFMapPackage.FEATURE_SEQ_INITIALIZER__CREATING_INITIALIZER);
		}
		return newElementInitializers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
		@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFMapPackage.REFERENCE_NEW_ELEMENT_SPEC__NEW_ELEMENT_INITIALIZERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNewElementInitializers()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFMapPackage.REFERENCE_NEW_ELEMENT_SPEC__NEW_ELEMENT_INITIALIZERS:
				return ((InternalEList<?>)getNewElementInitializers()).basicRemove(otherEnd, msgs);
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
			case GMFMapPackage.REFERENCE_NEW_ELEMENT_SPEC__NEW_ELEMENT_INITIALIZERS:
				return getNewElementInitializers();
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
			case GMFMapPackage.REFERENCE_NEW_ELEMENT_SPEC__NEW_ELEMENT_INITIALIZERS:
				getNewElementInitializers().clear();
				getNewElementInitializers().addAll((Collection<? extends FeatureSeqInitializer>)newValue);
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
			case GMFMapPackage.REFERENCE_NEW_ELEMENT_SPEC__NEW_ELEMENT_INITIALIZERS:
				getNewElementInitializers().clear();
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
			case GMFMapPackage.REFERENCE_NEW_ELEMENT_SPEC__NEW_ELEMENT_INITIALIZERS:
				return newElementInitializers != null && !newElementInitializers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ReferenceNewElementSpecImpl
