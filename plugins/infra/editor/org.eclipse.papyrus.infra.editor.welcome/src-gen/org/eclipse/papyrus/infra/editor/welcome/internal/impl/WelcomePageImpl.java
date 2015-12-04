/**
 * Copyright (c) 2015 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.editor.welcome.internal.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.editor.welcome.WelcomePackage;
import org.eclipse.papyrus.infra.editor.welcome.WelcomePage;
import org.eclipse.papyrus.infra.editor.welcome.WelcomeSection;

import org.eclipse.papyrus.infra.editor.welcome.internal.operations.WelcomePageOperations;
import org.eclipse.uml2.common.util.CacheAdapter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.editor.welcome.internal.impl.WelcomePageImpl#getSections <em>Section</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.editor.welcome.internal.impl.WelcomePageImpl#getVisibleSections <em>Visible Section</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WelcomePageImpl extends MinimalEObjectImpl.Container implements WelcomePage {
	/**
	 * The cached value of the '{@link #getSections() <em>Section</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSections()
	 * @generated
	 * @ordered
	 */
	protected EList<WelcomeSection> sections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected WelcomePageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WelcomePackage.Literals.WELCOME_PAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<WelcomeSection> getSections() {
		if (sections == null) {
			sections = new EObjectContainmentWithInverseEList<WelcomeSection>(WelcomeSection.class, this, WelcomePackage.WELCOME_PAGE__SECTION, WelcomePackage.WELCOME_SECTION__PAGE);
		}
		return sections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public WelcomeSection createSection() {
		WelcomeSection newSection = (WelcomeSection) create(WelcomePackage.Literals.WELCOME_SECTION);
		getSections().add(newSection);
		return newSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<WelcomeSection> getVisibleSections() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			@SuppressWarnings("unchecked")
			EList<WelcomeSection> result = (EList<WelcomeSection>) cache.get(eResource(), this, WelcomePackage.Literals.WELCOME_PAGE__VISIBLE_SECTION);
			if (result == null) {
				cache.put(eResource(), this, WelcomePackage.Literals.WELCOME_PAGE__VISIBLE_SECTION, result = WelcomePageOperations.getVisibleSections(this));
			}
			return result;
		}
		return WelcomePageOperations.getVisibleSections(this);
	}

	/**
	 * The array of superset feature identifiers for the '{@link #getVisibleSections() <em>Visible Section</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getVisibleSections()
	 * @generated
	 * @ordered
	 */
	protected static final int[] VISIBLE_SECTION_ESUPERSETS = new int[] { WelcomePackage.WELCOME_PAGE__SECTION };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public WelcomeSection createVisibleSection() {
		WelcomeSection newVisibleSection = (WelcomeSection) create(WelcomePackage.Literals.WELCOME_SECTION);
		getVisibleSections().add(newVisibleSection);
		return newVisibleSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public WelcomeSection getSection(String identifier) {
		return WelcomePageOperations.getSection(this, identifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case WelcomePackage.WELCOME_PAGE__SECTION:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSections()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case WelcomePackage.WELCOME_PAGE__SECTION:
			return ((InternalEList<?>) getSections()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case WelcomePackage.WELCOME_PAGE__SECTION:
			return getSections();
		case WelcomePackage.WELCOME_PAGE__VISIBLE_SECTION:
			return getVisibleSections();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case WelcomePackage.WELCOME_PAGE__SECTION:
			getSections().clear();
			getSections().addAll((Collection<? extends WelcomeSection>) newValue);
			return;
		case WelcomePackage.WELCOME_PAGE__VISIBLE_SECTION:
			getVisibleSections().clear();
			getVisibleSections().addAll((Collection<? extends WelcomeSection>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case WelcomePackage.WELCOME_PAGE__SECTION:
			getSections().clear();
			return;
		case WelcomePackage.WELCOME_PAGE__VISIBLE_SECTION:
			getVisibleSections().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case WelcomePackage.WELCOME_PAGE__SECTION:
			return sections != null && !sections.isEmpty();
		case WelcomePackage.WELCOME_PAGE__VISIBLE_SECTION:
			return !getVisibleSections().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case WelcomePackage.WELCOME_PAGE___GET_SECTION__STRING:
			return getSection((String) arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * Creates a new instance of the specified Ecore class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param eClass
	 *            The Ecore class of the instance to create.
	 * @return The new instance.
	 * @generated
	 */
	protected EObject create(EClass eClass) {
		return EcoreUtil.create(eClass);
	}

	/**
	 * Retrieves the cache adapter for this '<em><b>Page</b></em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return The cache adapter for this '<em><b>Page</b></em>'.
	 * @generated
	 */
	protected CacheAdapter getCacheAdapter() {
		return CacheAdapter.getCacheAdapter(this);
	}

} // WelcomePageImpl
