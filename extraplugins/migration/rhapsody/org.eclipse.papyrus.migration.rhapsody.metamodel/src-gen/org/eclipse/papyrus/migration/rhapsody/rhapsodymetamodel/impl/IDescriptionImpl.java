/**
 *   Copyright (c) 2016 CEA LIST and others.
 *   
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *     CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.HyperLinksType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDescription;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IDescription</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDescriptionImpl#getTextRTF <em>Text RTF</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDescriptionImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IDescriptionImpl#getHyperlinks <em>Hyperlinks</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IDescriptionImpl extends DescriptionTypeImpl implements IDescription {
	/**
	 * The default value of the '{@link #getTextRTF() <em>Text RTF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextRTF()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_RTF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTextRTF() <em>Text RTF</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextRTF()
	 * @generated
	 * @ordered
	 */
	protected String textRTF = TEXT_RTF_EDEFAULT;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHyperlinks() <em>Hyperlinks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHyperlinks()
	 * @generated
	 * @ordered
	 */
	protected EList<HyperLinksType> hyperlinks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIDescription();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextRTF() {
		return textRTF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextRTF(String newTextRTF) {
		String oldTextRTF = textRTF;
		textRTF = newTextRTF;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDESCRIPTION__TEXT_RTF, oldTextRTF, textRTF));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IDESCRIPTION__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HyperLinksType> getHyperlinks() {
		if (hyperlinks == null) {
			hyperlinks = new EObjectContainmentEList.Resolving<HyperLinksType>(HyperLinksType.class, this, UMLRhapsodyPackage.IDESCRIPTION__HYPERLINKS);
		}
		return hyperlinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.IDESCRIPTION__HYPERLINKS:
				return ((InternalEList<?>)getHyperlinks()).basicRemove(otherEnd, msgs);
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
			case UMLRhapsodyPackage.IDESCRIPTION__TEXT_RTF:
				return getTextRTF();
			case UMLRhapsodyPackage.IDESCRIPTION__TEXT:
				return getText();
			case UMLRhapsodyPackage.IDESCRIPTION__HYPERLINKS:
				return getHyperlinks();
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
			case UMLRhapsodyPackage.IDESCRIPTION__TEXT_RTF:
				setTextRTF((String)newValue);
				return;
			case UMLRhapsodyPackage.IDESCRIPTION__TEXT:
				setText((String)newValue);
				return;
			case UMLRhapsodyPackage.IDESCRIPTION__HYPERLINKS:
				getHyperlinks().clear();
				getHyperlinks().addAll((Collection<? extends HyperLinksType>)newValue);
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
			case UMLRhapsodyPackage.IDESCRIPTION__TEXT_RTF:
				setTextRTF(TEXT_RTF_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDESCRIPTION__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IDESCRIPTION__HYPERLINKS:
				getHyperlinks().clear();
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
			case UMLRhapsodyPackage.IDESCRIPTION__TEXT_RTF:
				return TEXT_RTF_EDEFAULT == null ? textRTF != null : !TEXT_RTF_EDEFAULT.equals(textRTF);
			case UMLRhapsodyPackage.IDESCRIPTION__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case UMLRhapsodyPackage.IDESCRIPTION__HYPERLINKS:
				return hyperlinks != null && !hyperlinks.isEmpty();
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
		result.append(" (textRTF: "); //$NON-NLS-1$
		result.append(textRTF);
		result.append(", text: "); //$NON-NLS-1$
		result.append(text);
		result.append(')');
		return result.toString();
	}

} //IDescriptionImpl
