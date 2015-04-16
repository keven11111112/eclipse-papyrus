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
import org.eclipse.papyrus.umldi.CollaborationShape;
import org.eclipse.papyrus.umldi.ElementWithInternalStructureShape;
import org.eclipse.papyrus.umldi.InternalStructureCompartment;
import org.eclipse.papyrus.umldi.OwnedBehaviorCompartment;
import org.eclipse.papyrus.umldi.ReceptionCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collaboration Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.CollaborationShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.CollaborationShapeImpl#getOwnedBehaviorCompartment <em>Owned Behavior Compartment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.CollaborationShapeImpl#getInternalStructureCompartment <em>Internal Structure Compartment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.CollaborationShapeImpl#getReceptionCompartment <em>Reception Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollaborationShapeImpl extends ClassifierWithOperationsShapeImpl implements CollaborationShape {
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
	 * The cached value of the '{@link #getInternalStructureCompartment() <em>Internal Structure Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalStructureCompartment()
	 * @generated
	 * @ordered
	 */
	protected InternalStructureCompartment internalStructureCompartment;

	/**
	 * The cached value of the '{@link #getReceptionCompartment() <em>Reception Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceptionCompartment()
	 * @generated
	 * @ordered
	 */
	protected ReceptionCompartment receptionCompartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollaborationShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.COLLABORATION_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.COLLABORATION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedUmlDiagramElement()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[] {UMLDIPackage.COLLABORATION_SHAPE__MAIN_LABEL, UMLDIPackage.COLLABORATION_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT, UMLDIPackage.COLLABORATION_SHAPE__OWNED_USE_CASE_COMPARTMENT, UMLDIPackage.COLLABORATION_SHAPE__USE_CASE_COMPARTMENT, UMLDIPackage.COLLABORATION_SHAPE__ATTRIBUTE_COMPARTMENT, UMLDIPackage.COLLABORATION_SHAPE__OPERATION_COMPARTMENT, UMLDIPackage.COLLABORATION_SHAPE__OWNED_BEHAVIOR_COMPARTMENT, UMLDIPackage.COLLABORATION_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT, UMLDIPackage.COLLABORATION_SHAPE__RECEPTION_COMPARTMENT};

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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.COLLABORATION_SHAPE__OWNED_BEHAVIOR_COMPARTMENT, oldOwnedBehaviorCompartment, newOwnedBehaviorCompartment);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.COLLABORATION_SHAPE__OWNED_BEHAVIOR_COMPARTMENT, newOwnedBehaviorCompartment, newOwnedBehaviorCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalStructureCompartment getInternalStructureCompartment() {
		return internalStructureCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInternalStructureCompartment(InternalStructureCompartment newInternalStructureCompartment, NotificationChain msgs) {
		InternalStructureCompartment oldInternalStructureCompartment = internalStructureCompartment;
		internalStructureCompartment = newInternalStructureCompartment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.COLLABORATION_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT, oldInternalStructureCompartment, newInternalStructureCompartment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalStructureCompartment(InternalStructureCompartment newInternalStructureCompartment) {
		if (newInternalStructureCompartment != internalStructureCompartment) {
			NotificationChain msgs = null;
			if (internalStructureCompartment != null)
				msgs = ((InternalEObject)internalStructureCompartment).eInverseRemove(this, UMLDIPackage.INTERNAL_STRUCTURE_COMPARTMENT__ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE, InternalStructureCompartment.class, msgs);
			if (newInternalStructureCompartment != null)
				msgs = ((InternalEObject)newInternalStructureCompartment).eInverseAdd(this, UMLDIPackage.INTERNAL_STRUCTURE_COMPARTMENT__ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE, InternalStructureCompartment.class, msgs);
			msgs = basicSetInternalStructureCompartment(newInternalStructureCompartment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.COLLABORATION_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT, newInternalStructureCompartment, newInternalStructureCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReceptionCompartment getReceptionCompartment() {
		return receptionCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReceptionCompartment(ReceptionCompartment newReceptionCompartment, NotificationChain msgs) {
		ReceptionCompartment oldReceptionCompartment = receptionCompartment;
		receptionCompartment = newReceptionCompartment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.COLLABORATION_SHAPE__RECEPTION_COMPARTMENT, oldReceptionCompartment, newReceptionCompartment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReceptionCompartment(ReceptionCompartment newReceptionCompartment) {
		if (newReceptionCompartment != receptionCompartment) {
			NotificationChain msgs = null;
			if (receptionCompartment != null)
				msgs = ((InternalEObject)receptionCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.COLLABORATION_SHAPE__RECEPTION_COMPARTMENT, null, msgs);
			if (newReceptionCompartment != null)
				msgs = ((InternalEObject)newReceptionCompartment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.COLLABORATION_SHAPE__RECEPTION_COMPARTMENT, null, msgs);
			msgs = basicSetReceptionCompartment(newReceptionCompartment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.COLLABORATION_SHAPE__RECEPTION_COMPARTMENT, newReceptionCompartment, newReceptionCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.COLLABORATION_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
				if (ownedBehaviorCompartment != null)
					msgs = ((InternalEObject)ownedBehaviorCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.COLLABORATION_SHAPE__OWNED_BEHAVIOR_COMPARTMENT, null, msgs);
				return basicSetOwnedBehaviorCompartment((OwnedBehaviorCompartment)otherEnd, msgs);
			case UMLDIPackage.COLLABORATION_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT:
				if (internalStructureCompartment != null)
					msgs = ((InternalEObject)internalStructureCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.COLLABORATION_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT, null, msgs);
				return basicSetInternalStructureCompartment((InternalStructureCompartment)otherEnd, msgs);
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
			case UMLDIPackage.COLLABORATION_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
				return basicSetOwnedBehaviorCompartment(null, msgs);
			case UMLDIPackage.COLLABORATION_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT:
				return basicSetInternalStructureCompartment(null, msgs);
			case UMLDIPackage.COLLABORATION_SHAPE__RECEPTION_COMPARTMENT:
				return basicSetReceptionCompartment(null, msgs);
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
			case UMLDIPackage.COLLABORATION_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
				return getOwnedBehaviorCompartment();
			case UMLDIPackage.COLLABORATION_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT:
				return getInternalStructureCompartment();
			case UMLDIPackage.COLLABORATION_SHAPE__RECEPTION_COMPARTMENT:
				return getReceptionCompartment();
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
			case UMLDIPackage.COLLABORATION_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
				setOwnedBehaviorCompartment((OwnedBehaviorCompartment)newValue);
				return;
			case UMLDIPackage.COLLABORATION_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT:
				setInternalStructureCompartment((InternalStructureCompartment)newValue);
				return;
			case UMLDIPackage.COLLABORATION_SHAPE__RECEPTION_COMPARTMENT:
				setReceptionCompartment((ReceptionCompartment)newValue);
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
			case UMLDIPackage.COLLABORATION_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
				setOwnedBehaviorCompartment((OwnedBehaviorCompartment)null);
				return;
			case UMLDIPackage.COLLABORATION_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT:
				setInternalStructureCompartment((InternalStructureCompartment)null);
				return;
			case UMLDIPackage.COLLABORATION_SHAPE__RECEPTION_COMPARTMENT:
				setReceptionCompartment((ReceptionCompartment)null);
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
			case UMLDIPackage.COLLABORATION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
				return isSetOwnedUmlDiagramElement();
			case UMLDIPackage.COLLABORATION_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
				return ownedBehaviorCompartment != null;
			case UMLDIPackage.COLLABORATION_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT:
				return internalStructureCompartment != null;
			case UMLDIPackage.COLLABORATION_SHAPE__RECEPTION_COMPARTMENT:
				return receptionCompartment != null;
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
		if (baseClass == BehavioredClassifierShape.class) {
			switch (derivedFeatureID) {
				case UMLDIPackage.COLLABORATION_SHAPE__OWNED_BEHAVIOR_COMPARTMENT: return UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_BEHAVIOR_COMPARTMENT;
				default: return -1;
			}
		}
		if (baseClass == ElementWithInternalStructureShape.class) {
			switch (derivedFeatureID) {
				case UMLDIPackage.COLLABORATION_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT: return UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT;
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
		if (baseClass == BehavioredClassifierShape.class) {
			switch (baseFeatureID) {
				case UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_BEHAVIOR_COMPARTMENT: return UMLDIPackage.COLLABORATION_SHAPE__OWNED_BEHAVIOR_COMPARTMENT;
				default: return -1;
			}
		}
		if (baseClass == ElementWithInternalStructureShape.class) {
			switch (baseFeatureID) {
				case UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT: return UMLDIPackage.COLLABORATION_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT;
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
	public boolean isSetOwnedUmlDiagramElement() {
		return super.isSetOwnedUmlDiagramElement()
			|| eIsSet(UMLDIPackage.COLLABORATION_SHAPE__OWNED_BEHAVIOR_COMPARTMENT)
			|| eIsSet(UMLDIPackage.COLLABORATION_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT)
			|| eIsSet(UMLDIPackage.COLLABORATION_SHAPE__RECEPTION_COMPARTMENT);
	}

} //CollaborationShapeImpl
