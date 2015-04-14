/**
 * Copyright (c) 2014 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.umldi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.umldi.ExtensionPointCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;
import org.eclipse.papyrus.umldi.UseCaseShape;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Case Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.UseCaseShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.UseCaseShapeImpl#getExtensionPointCompartment <em>Extension Point Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UseCaseShapeImpl extends BehavioredClassifierShapeImpl implements UseCaseShape {
	/**
	 * The cached value of the '{@link #getExtensionPointCompartment() <em>Extension Point Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionPointCompartment()
	 * @generated
	 * @ordered
	 */
	protected ExtensionPointCompartment extensionPointCompartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseCaseShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.USE_CASE_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.USE_CASE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedUmlDiagramElement()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[] {UMLDIPackage.USE_CASE_SHAPE__MAIN_LABEL, UMLDIPackage.USE_CASE_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT, UMLDIPackage.USE_CASE_SHAPE__OWNED_USE_CASE_COMPARTMENT, UMLDIPackage.USE_CASE_SHAPE__USE_CASE_COMPARTMENT, UMLDIPackage.USE_CASE_SHAPE__OWNED_BEHAVIOR_COMPARTMENT, UMLDIPackage.USE_CASE_SHAPE__EXTENSION_POINT_COMPARTMENT};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionPointCompartment getExtensionPointCompartment() {
		return extensionPointCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtensionPointCompartment(ExtensionPointCompartment newExtensionPointCompartment, NotificationChain msgs) {
		ExtensionPointCompartment oldExtensionPointCompartment = extensionPointCompartment;
		extensionPointCompartment = newExtensionPointCompartment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.USE_CASE_SHAPE__EXTENSION_POINT_COMPARTMENT, oldExtensionPointCompartment, newExtensionPointCompartment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtensionPointCompartment(ExtensionPointCompartment newExtensionPointCompartment) {
		if (newExtensionPointCompartment != extensionPointCompartment) {
			NotificationChain msgs = null;
			if (extensionPointCompartment != null)
				msgs = ((InternalEObject)extensionPointCompartment).eInverseRemove(this, UMLDIPackage.EXTENSION_POINT_COMPARTMENT__USE_CASE_SHAPE, ExtensionPointCompartment.class, msgs);
			if (newExtensionPointCompartment != null)
				msgs = ((InternalEObject)newExtensionPointCompartment).eInverseAdd(this, UMLDIPackage.EXTENSION_POINT_COMPARTMENT__USE_CASE_SHAPE, ExtensionPointCompartment.class, msgs);
			msgs = basicSetExtensionPointCompartment(newExtensionPointCompartment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.USE_CASE_SHAPE__EXTENSION_POINT_COMPARTMENT, newExtensionPointCompartment, newExtensionPointCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.USE_CASE_SHAPE__EXTENSION_POINT_COMPARTMENT:
				if (extensionPointCompartment != null)
					msgs = ((InternalEObject)extensionPointCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.USE_CASE_SHAPE__EXTENSION_POINT_COMPARTMENT, null, msgs);
				return basicSetExtensionPointCompartment((ExtensionPointCompartment)otherEnd, msgs);
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
			case UMLDIPackage.USE_CASE_SHAPE__EXTENSION_POINT_COMPARTMENT:
				return basicSetExtensionPointCompartment(null, msgs);
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
			case UMLDIPackage.USE_CASE_SHAPE__EXTENSION_POINT_COMPARTMENT:
				return getExtensionPointCompartment();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UMLDIPackage.USE_CASE_SHAPE__EXTENSION_POINT_COMPARTMENT:
				setExtensionPointCompartment((ExtensionPointCompartment)newValue);
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
			case UMLDIPackage.USE_CASE_SHAPE__EXTENSION_POINT_COMPARTMENT:
				setExtensionPointCompartment((ExtensionPointCompartment)null);
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
			case UMLDIPackage.USE_CASE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
				return isSetOwnedUmlDiagramElement();
			case UMLDIPackage.USE_CASE_SHAPE__EXTENSION_POINT_COMPARTMENT:
				return extensionPointCompartment != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedUmlDiagramElement() {
		return super.isSetOwnedUmlDiagramElement()
			|| eIsSet(UMLDIPackage.USE_CASE_SHAPE__EXTENSION_POINT_COMPARTMENT);
	}

} //UseCaseShapeImpl
