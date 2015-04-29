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

import org.eclipse.papyrus.umldi.BehavioredClassifierShape;
import org.eclipse.papyrus.umldi.OwnedBehaviorCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behaviored Classifier Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.BehavioredClassifierShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.BehavioredClassifierShapeImpl#getOwnedBehaviorCompartment <em>Owned Behavior Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BehavioredClassifierShapeImpl extends ClassifierShapeImpl implements BehavioredClassifierShape {
	/**
	 * The cached value of the '{@link #getOwnedBehaviorCompartment() <em>Owned Behavior Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBehaviorCompartment()
	 * @generated
	 * @ordered
	 */
	protected OwnedBehaviorCompartment ownedBehaviorCompartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehavioredClassifierShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.BEHAVIORED_CLASSIFIER_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedUmlDiagramElement()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[] {UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__MAIN_LABEL, UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT, UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_USE_CASE_COMPARTMENT, UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__USE_CASE_COMPARTMENT, UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_BEHAVIOR_COMPARTMENT};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OwnedBehaviorCompartment getOwnedBehaviorCompartment() {
		return ownedBehaviorCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedBehaviorCompartment(OwnedBehaviorCompartment newOwnedBehaviorCompartment, NotificationChain msgs) {
		OwnedBehaviorCompartment oldOwnedBehaviorCompartment = ownedBehaviorCompartment;
		ownedBehaviorCompartment = newOwnedBehaviorCompartment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_BEHAVIOR_COMPARTMENT, oldOwnedBehaviorCompartment, newOwnedBehaviorCompartment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedBehaviorCompartment(OwnedBehaviorCompartment newOwnedBehaviorCompartment) {
		if (newOwnedBehaviorCompartment != ownedBehaviorCompartment) {
			NotificationChain msgs = null;
			if (ownedBehaviorCompartment != null)
				msgs = ((InternalEObject)ownedBehaviorCompartment).eInverseRemove(this, UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__BEHAVIORED_CLASSIFIER_SHAPE, OwnedBehaviorCompartment.class, msgs);
			if (newOwnedBehaviorCompartment != null)
				msgs = ((InternalEObject)newOwnedBehaviorCompartment).eInverseAdd(this, UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__BEHAVIORED_CLASSIFIER_SHAPE, OwnedBehaviorCompartment.class, msgs);
			msgs = basicSetOwnedBehaviorCompartment(newOwnedBehaviorCompartment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_BEHAVIOR_COMPARTMENT, newOwnedBehaviorCompartment, newOwnedBehaviorCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
				if (ownedBehaviorCompartment != null)
					msgs = ((InternalEObject)ownedBehaviorCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_BEHAVIOR_COMPARTMENT, null, msgs);
				return basicSetOwnedBehaviorCompartment((OwnedBehaviorCompartment)otherEnd, msgs);
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
			case UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
				return basicSetOwnedBehaviorCompartment(null, msgs);
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
			case UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
				return getOwnedBehaviorCompartment();
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
			case UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
				setOwnedBehaviorCompartment((OwnedBehaviorCompartment)newValue);
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
			case UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
				setOwnedBehaviorCompartment((OwnedBehaviorCompartment)null);
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
			case UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
				return isSetOwnedUmlDiagramElement();
			case UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
				return ownedBehaviorCompartment != null;
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
			|| eIsSet(UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_BEHAVIOR_COMPARTMENT);
	}

} //BehavioredClassifierShapeImpl
