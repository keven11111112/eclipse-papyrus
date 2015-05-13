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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.papyrus.umldi.BehavioredClassifierShape;
import org.eclipse.papyrus.umldi.OwnedBehaviorCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Owned Behavior Compartment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.OwnedBehaviorCompartmentImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.OwnedBehaviorCompartmentImpl#getBehavioredClassifierShape <em>Behaviored Classifier Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OwnedBehaviorCompartmentImpl extends ClassifierCompartmentImpl implements OwnedBehaviorCompartment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OwnedBehaviorCompartmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.OWNED_BEHAVIOR_COMPARTMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UmlDiagramElement getOwningUmlDiagramElement() {
		UmlDiagramElement owningUmlDiagramElement = basicGetOwningUmlDiagramElement();
		return owningUmlDiagramElement != null && owningUmlDiagramElement.eIsProxy() ? (UmlDiagramElement)eResolveProxy((InternalEObject)owningUmlDiagramElement) : owningUmlDiagramElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UmlDiagramElement basicGetOwningUmlDiagramElement() {
		BehavioredClassifierShape behavioredClassifierShape = getBehavioredClassifierShape();			
		if (behavioredClassifierShape != null) {
			return behavioredClassifierShape;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioredClassifierShape getBehavioredClassifierShape() {
		if (eContainerFeatureID() != UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__BEHAVIORED_CLASSIFIER_SHAPE) return null;
		return (BehavioredClassifierShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBehavioredClassifierShape(BehavioredClassifierShape newBehavioredClassifierShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBehavioredClassifierShape, UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__BEHAVIORED_CLASSIFIER_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehavioredClassifierShape(BehavioredClassifierShape newBehavioredClassifierShape) {
		if (newBehavioredClassifierShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__BEHAVIORED_CLASSIFIER_SHAPE && newBehavioredClassifierShape != null)) {
			if (EcoreUtil.isAncestor(this, newBehavioredClassifierShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBehavioredClassifierShape != null)
				msgs = ((InternalEObject)newBehavioredClassifierShape).eInverseAdd(this, UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_BEHAVIOR_COMPARTMENT, BehavioredClassifierShape.class, msgs);
			msgs = basicSetBehavioredClassifierShape(newBehavioredClassifierShape, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__BEHAVIORED_CLASSIFIER_SHAPE, newBehavioredClassifierShape, newBehavioredClassifierShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__BEHAVIORED_CLASSIFIER_SHAPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetBehavioredClassifierShape((BehavioredClassifierShape)otherEnd, msgs);
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
			case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__BEHAVIORED_CLASSIFIER_SHAPE:
				return basicSetBehavioredClassifierShape(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__BEHAVIORED_CLASSIFIER_SHAPE:
				return eInternalContainer().eInverseRemove(this, UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_BEHAVIOR_COMPARTMENT, BehavioredClassifierShape.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__BEHAVIORED_CLASSIFIER_SHAPE:
				return getBehavioredClassifierShape();
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
			case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__BEHAVIORED_CLASSIFIER_SHAPE:
				setBehavioredClassifierShape((BehavioredClassifierShape)newValue);
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
			case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__BEHAVIORED_CLASSIFIER_SHAPE:
				setBehavioredClassifierShape((BehavioredClassifierShape)null);
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
			case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
				return isSetOwningUmlDiagramElement();
			case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__BEHAVIORED_CLASSIFIER_SHAPE:
				return getBehavioredClassifierShape() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwningUmlDiagramElement() {
		return super.isSetOwningUmlDiagramElement()
			|| eIsSet(UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__BEHAVIORED_CLASSIFIER_SHAPE);
	}

} //OwnedBehaviorCompartmentImpl
