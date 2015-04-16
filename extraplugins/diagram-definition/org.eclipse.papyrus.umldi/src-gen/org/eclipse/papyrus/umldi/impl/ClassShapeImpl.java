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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.umldi.BehavioredClassifierShape;
import org.eclipse.papyrus.umldi.ClassShape;
import org.eclipse.papyrus.umldi.ElementWithInternalStructureShape;
import org.eclipse.papyrus.umldi.ElementWithPortsShape;
import org.eclipse.papyrus.umldi.InternalStructureCompartment;
import org.eclipse.papyrus.umldi.OwnedBehaviorCompartment;
import org.eclipse.papyrus.umldi.PortShape;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ClassShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ClassShapeImpl#getOwnedBehaviorCompartment <em>Owned Behavior Compartment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ClassShapeImpl#getInternalStructureCompartment <em>Internal Structure Compartment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ClassShapeImpl#getPortShape <em>Port Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassShapeImpl extends ClassifierWithNestedClassifiersShapeImpl implements ClassShape {
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
	 * The cached value of the '{@link #getPortShape() <em>Port Shape</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortShape()
	 * @generated
	 * @ordered
	 */
	protected EList<PortShape> portShape;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.CLASS_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.CLASS_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedUmlDiagramElement()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[] {UMLDIPackage.CLASS_SHAPE__MAIN_LABEL, UMLDIPackage.CLASS_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT, UMLDIPackage.CLASS_SHAPE__OWNED_USE_CASE_COMPARTMENT, UMLDIPackage.CLASS_SHAPE__USE_CASE_COMPARTMENT, UMLDIPackage.CLASS_SHAPE__ATTRIBUTE_COMPARTMENT, UMLDIPackage.CLASS_SHAPE__OPERATION_COMPARTMENT, UMLDIPackage.CLASS_SHAPE__RECEPTION_COMPARTMENT, UMLDIPackage.CLASS_SHAPE__NESTED_CLASSIFIER_COMPARTMENT, UMLDIPackage.CLASS_SHAPE__OWNED_BEHAVIOR_COMPARTMENT, UMLDIPackage.CLASS_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT, UMLDIPackage.CLASS_SHAPE__PORT_SHAPE};

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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.CLASS_SHAPE__OWNED_BEHAVIOR_COMPARTMENT, oldOwnedBehaviorCompartment, newOwnedBehaviorCompartment);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.CLASS_SHAPE__OWNED_BEHAVIOR_COMPARTMENT, newOwnedBehaviorCompartment, newOwnedBehaviorCompartment));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.CLASS_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT, oldInternalStructureCompartment, newInternalStructureCompartment);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.CLASS_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT, newInternalStructureCompartment, newInternalStructureCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PortShape> getPortShape() {
		if (portShape == null) {
			portShape = new EObjectContainmentWithInverseEList<PortShape>(PortShape.class, this, UMLDIPackage.CLASS_SHAPE__PORT_SHAPE, UMLDIPackage.PORT_SHAPE__ELEMENT_WITH_PORTS_SHAPE);
		}
		return portShape;
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
			case UMLDIPackage.CLASS_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
				if (ownedBehaviorCompartment != null)
					msgs = ((InternalEObject)ownedBehaviorCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.CLASS_SHAPE__OWNED_BEHAVIOR_COMPARTMENT, null, msgs);
				return basicSetOwnedBehaviorCompartment((OwnedBehaviorCompartment)otherEnd, msgs);
			case UMLDIPackage.CLASS_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT:
				if (internalStructureCompartment != null)
					msgs = ((InternalEObject)internalStructureCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.CLASS_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT, null, msgs);
				return basicSetInternalStructureCompartment((InternalStructureCompartment)otherEnd, msgs);
			case UMLDIPackage.CLASS_SHAPE__PORT_SHAPE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPortShape()).basicAdd(otherEnd, msgs);
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
			case UMLDIPackage.CLASS_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
				return basicSetOwnedBehaviorCompartment(null, msgs);
			case UMLDIPackage.CLASS_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT:
				return basicSetInternalStructureCompartment(null, msgs);
			case UMLDIPackage.CLASS_SHAPE__PORT_SHAPE:
				return ((InternalEList<?>)getPortShape()).basicRemove(otherEnd, msgs);
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
			case UMLDIPackage.CLASS_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
				return getOwnedBehaviorCompartment();
			case UMLDIPackage.CLASS_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT:
				return getInternalStructureCompartment();
			case UMLDIPackage.CLASS_SHAPE__PORT_SHAPE:
				return getPortShape();
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
			case UMLDIPackage.CLASS_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
				setOwnedBehaviorCompartment((OwnedBehaviorCompartment)newValue);
				return;
			case UMLDIPackage.CLASS_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT:
				setInternalStructureCompartment((InternalStructureCompartment)newValue);
				return;
			case UMLDIPackage.CLASS_SHAPE__PORT_SHAPE:
				getPortShape().clear();
				getPortShape().addAll((Collection<? extends PortShape>)newValue);
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
			case UMLDIPackage.CLASS_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
				setOwnedBehaviorCompartment((OwnedBehaviorCompartment)null);
				return;
			case UMLDIPackage.CLASS_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT:
				setInternalStructureCompartment((InternalStructureCompartment)null);
				return;
			case UMLDIPackage.CLASS_SHAPE__PORT_SHAPE:
				getPortShape().clear();
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
			case UMLDIPackage.CLASS_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
				return isSetOwnedUmlDiagramElement();
			case UMLDIPackage.CLASS_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
				return ownedBehaviorCompartment != null;
			case UMLDIPackage.CLASS_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT:
				return internalStructureCompartment != null;
			case UMLDIPackage.CLASS_SHAPE__PORT_SHAPE:
				return portShape != null && !portShape.isEmpty();
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
				case UMLDIPackage.CLASS_SHAPE__OWNED_BEHAVIOR_COMPARTMENT: return UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_BEHAVIOR_COMPARTMENT;
				default: return -1;
			}
		}
		if (baseClass == ElementWithInternalStructureShape.class) {
			switch (derivedFeatureID) {
				case UMLDIPackage.CLASS_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT: return UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT;
				default: return -1;
			}
		}
		if (baseClass == ElementWithPortsShape.class) {
			switch (derivedFeatureID) {
				case UMLDIPackage.CLASS_SHAPE__PORT_SHAPE: return UMLDIPackage.ELEMENT_WITH_PORTS_SHAPE__PORT_SHAPE;
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
				case UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE__OWNED_BEHAVIOR_COMPARTMENT: return UMLDIPackage.CLASS_SHAPE__OWNED_BEHAVIOR_COMPARTMENT;
				default: return -1;
			}
		}
		if (baseClass == ElementWithInternalStructureShape.class) {
			switch (baseFeatureID) {
				case UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT: return UMLDIPackage.CLASS_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT;
				default: return -1;
			}
		}
		if (baseClass == ElementWithPortsShape.class) {
			switch (baseFeatureID) {
				case UMLDIPackage.ELEMENT_WITH_PORTS_SHAPE__PORT_SHAPE: return UMLDIPackage.CLASS_SHAPE__PORT_SHAPE;
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
			|| eIsSet(UMLDIPackage.CLASS_SHAPE__OWNED_BEHAVIOR_COMPARTMENT)
			|| eIsSet(UMLDIPackage.CLASS_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT)
			|| eIsSet(UMLDIPackage.CLASS_SHAPE__PORT_SHAPE);
	}

} //ClassShapeImpl
