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

import org.eclipse.papyrus.umldi.ConnectionPointReferenceShape;
import org.eclipse.papyrus.umldi.DeferrableTriggerCompartment;
import org.eclipse.papyrus.umldi.InternalBehaviorCompartment;
import org.eclipse.papyrus.umldi.InternalTransitionCompartment;
import org.eclipse.papyrus.umldi.StateShape;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.StateShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.StateShapeImpl#getConnectionPointReferenceShape <em>Connection Point Reference Shape</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.StateShapeImpl#getInternalTransitionCompartment <em>Internal Transition Compartment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.StateShapeImpl#getDeferrableTriggerCompartment <em>Deferrable Trigger Compartment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.StateShapeImpl#getInternalBehaviorCompartment <em>Internal Behavior Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StateShapeImpl extends BaseStateShapeImpl implements StateShape {
	/**
	 * The cached value of the '{@link #getConnectionPointReferenceShape() <em>Connection Point Reference Shape</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionPointReferenceShape()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectionPointReferenceShape> connectionPointReferenceShape;

	/**
	 * The cached value of the '{@link #getInternalTransitionCompartment() <em>Internal Transition Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalTransitionCompartment()
	 * @generated
	 * @ordered
	 */
	protected InternalTransitionCompartment internalTransitionCompartment;

	/**
	 * The cached value of the '{@link #getDeferrableTriggerCompartment() <em>Deferrable Trigger Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeferrableTriggerCompartment()
	 * @generated
	 * @ordered
	 */
	protected DeferrableTriggerCompartment deferrableTriggerCompartment;

	/**
	 * The cached value of the '{@link #getInternalBehaviorCompartment() <em>Internal Behavior Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalBehaviorCompartment()
	 * @generated
	 * @ordered
	 */
	protected InternalBehaviorCompartment internalBehaviorCompartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.STATE_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.STATE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedUmlDiagramElement()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[] {UMLDIPackage.STATE_SHAPE__MAIN_LABEL, UMLDIPackage.STATE_SHAPE__CONNECTION_POINT_SHAPE, UMLDIPackage.STATE_SHAPE__REGION_COMPARTMENT, UMLDIPackage.STATE_SHAPE__CONNECTION_POINT_REFERENCE_SHAPE, UMLDIPackage.STATE_SHAPE__INTERNAL_TRANSITION_COMPARTMENT, UMLDIPackage.STATE_SHAPE__DEFERRABLE_TRIGGER_COMPARTMENT, UMLDIPackage.STATE_SHAPE__INTERNAL_BEHAVIOR_COMPARTMENT};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConnectionPointReferenceShape> getConnectionPointReferenceShape() {
		if (connectionPointReferenceShape == null) {
			connectionPointReferenceShape = new EObjectContainmentWithInverseEList<ConnectionPointReferenceShape>(ConnectionPointReferenceShape.class, this, UMLDIPackage.STATE_SHAPE__CONNECTION_POINT_REFERENCE_SHAPE, UMLDIPackage.CONNECTION_POINT_REFERENCE_SHAPE__STATE_SHAPE);
		}
		return connectionPointReferenceShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalTransitionCompartment getInternalTransitionCompartment() {
		return internalTransitionCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInternalTransitionCompartment(InternalTransitionCompartment newInternalTransitionCompartment, NotificationChain msgs) {
		InternalTransitionCompartment oldInternalTransitionCompartment = internalTransitionCompartment;
		internalTransitionCompartment = newInternalTransitionCompartment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.STATE_SHAPE__INTERNAL_TRANSITION_COMPARTMENT, oldInternalTransitionCompartment, newInternalTransitionCompartment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalTransitionCompartment(InternalTransitionCompartment newInternalTransitionCompartment) {
		if (newInternalTransitionCompartment != internalTransitionCompartment) {
			NotificationChain msgs = null;
			if (internalTransitionCompartment != null)
				msgs = ((InternalEObject)internalTransitionCompartment).eInverseRemove(this, UMLDIPackage.INTERNAL_TRANSITION_COMPARTMENT__STATE_SHAPE, InternalTransitionCompartment.class, msgs);
			if (newInternalTransitionCompartment != null)
				msgs = ((InternalEObject)newInternalTransitionCompartment).eInverseAdd(this, UMLDIPackage.INTERNAL_TRANSITION_COMPARTMENT__STATE_SHAPE, InternalTransitionCompartment.class, msgs);
			msgs = basicSetInternalTransitionCompartment(newInternalTransitionCompartment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.STATE_SHAPE__INTERNAL_TRANSITION_COMPARTMENT, newInternalTransitionCompartment, newInternalTransitionCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeferrableTriggerCompartment getDeferrableTriggerCompartment() {
		return deferrableTriggerCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeferrableTriggerCompartment(DeferrableTriggerCompartment newDeferrableTriggerCompartment, NotificationChain msgs) {
		DeferrableTriggerCompartment oldDeferrableTriggerCompartment = deferrableTriggerCompartment;
		deferrableTriggerCompartment = newDeferrableTriggerCompartment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.STATE_SHAPE__DEFERRABLE_TRIGGER_COMPARTMENT, oldDeferrableTriggerCompartment, newDeferrableTriggerCompartment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeferrableTriggerCompartment(DeferrableTriggerCompartment newDeferrableTriggerCompartment) {
		if (newDeferrableTriggerCompartment != deferrableTriggerCompartment) {
			NotificationChain msgs = null;
			if (deferrableTriggerCompartment != null)
				msgs = ((InternalEObject)deferrableTriggerCompartment).eInverseRemove(this, UMLDIPackage.DEFERRABLE_TRIGGER_COMPARTMENT__STATE_SHAPE, DeferrableTriggerCompartment.class, msgs);
			if (newDeferrableTriggerCompartment != null)
				msgs = ((InternalEObject)newDeferrableTriggerCompartment).eInverseAdd(this, UMLDIPackage.DEFERRABLE_TRIGGER_COMPARTMENT__STATE_SHAPE, DeferrableTriggerCompartment.class, msgs);
			msgs = basicSetDeferrableTriggerCompartment(newDeferrableTriggerCompartment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.STATE_SHAPE__DEFERRABLE_TRIGGER_COMPARTMENT, newDeferrableTriggerCompartment, newDeferrableTriggerCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalBehaviorCompartment getInternalBehaviorCompartment() {
		return internalBehaviorCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInternalBehaviorCompartment(InternalBehaviorCompartment newInternalBehaviorCompartment, NotificationChain msgs) {
		InternalBehaviorCompartment oldInternalBehaviorCompartment = internalBehaviorCompartment;
		internalBehaviorCompartment = newInternalBehaviorCompartment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.STATE_SHAPE__INTERNAL_BEHAVIOR_COMPARTMENT, oldInternalBehaviorCompartment, newInternalBehaviorCompartment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalBehaviorCompartment(InternalBehaviorCompartment newInternalBehaviorCompartment) {
		if (newInternalBehaviorCompartment != internalBehaviorCompartment) {
			NotificationChain msgs = null;
			if (internalBehaviorCompartment != null)
				msgs = ((InternalEObject)internalBehaviorCompartment).eInverseRemove(this, UMLDIPackage.INTERNAL_BEHAVIOR_COMPARTMENT__STATE_SHAPE, InternalBehaviorCompartment.class, msgs);
			if (newInternalBehaviorCompartment != null)
				msgs = ((InternalEObject)newInternalBehaviorCompartment).eInverseAdd(this, UMLDIPackage.INTERNAL_BEHAVIOR_COMPARTMENT__STATE_SHAPE, InternalBehaviorCompartment.class, msgs);
			msgs = basicSetInternalBehaviorCompartment(newInternalBehaviorCompartment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.STATE_SHAPE__INTERNAL_BEHAVIOR_COMPARTMENT, newInternalBehaviorCompartment, newInternalBehaviorCompartment));
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
			case UMLDIPackage.STATE_SHAPE__CONNECTION_POINT_REFERENCE_SHAPE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConnectionPointReferenceShape()).basicAdd(otherEnd, msgs);
			case UMLDIPackage.STATE_SHAPE__INTERNAL_TRANSITION_COMPARTMENT:
				if (internalTransitionCompartment != null)
					msgs = ((InternalEObject)internalTransitionCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.STATE_SHAPE__INTERNAL_TRANSITION_COMPARTMENT, null, msgs);
				return basicSetInternalTransitionCompartment((InternalTransitionCompartment)otherEnd, msgs);
			case UMLDIPackage.STATE_SHAPE__DEFERRABLE_TRIGGER_COMPARTMENT:
				if (deferrableTriggerCompartment != null)
					msgs = ((InternalEObject)deferrableTriggerCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.STATE_SHAPE__DEFERRABLE_TRIGGER_COMPARTMENT, null, msgs);
				return basicSetDeferrableTriggerCompartment((DeferrableTriggerCompartment)otherEnd, msgs);
			case UMLDIPackage.STATE_SHAPE__INTERNAL_BEHAVIOR_COMPARTMENT:
				if (internalBehaviorCompartment != null)
					msgs = ((InternalEObject)internalBehaviorCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.STATE_SHAPE__INTERNAL_BEHAVIOR_COMPARTMENT, null, msgs);
				return basicSetInternalBehaviorCompartment((InternalBehaviorCompartment)otherEnd, msgs);
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
			case UMLDIPackage.STATE_SHAPE__CONNECTION_POINT_REFERENCE_SHAPE:
				return ((InternalEList<?>)getConnectionPointReferenceShape()).basicRemove(otherEnd, msgs);
			case UMLDIPackage.STATE_SHAPE__INTERNAL_TRANSITION_COMPARTMENT:
				return basicSetInternalTransitionCompartment(null, msgs);
			case UMLDIPackage.STATE_SHAPE__DEFERRABLE_TRIGGER_COMPARTMENT:
				return basicSetDeferrableTriggerCompartment(null, msgs);
			case UMLDIPackage.STATE_SHAPE__INTERNAL_BEHAVIOR_COMPARTMENT:
				return basicSetInternalBehaviorCompartment(null, msgs);
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
			case UMLDIPackage.STATE_SHAPE__CONNECTION_POINT_REFERENCE_SHAPE:
				return getConnectionPointReferenceShape();
			case UMLDIPackage.STATE_SHAPE__INTERNAL_TRANSITION_COMPARTMENT:
				return getInternalTransitionCompartment();
			case UMLDIPackage.STATE_SHAPE__DEFERRABLE_TRIGGER_COMPARTMENT:
				return getDeferrableTriggerCompartment();
			case UMLDIPackage.STATE_SHAPE__INTERNAL_BEHAVIOR_COMPARTMENT:
				return getInternalBehaviorCompartment();
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
			case UMLDIPackage.STATE_SHAPE__CONNECTION_POINT_REFERENCE_SHAPE:
				getConnectionPointReferenceShape().clear();
				getConnectionPointReferenceShape().addAll((Collection<? extends ConnectionPointReferenceShape>)newValue);
				return;
			case UMLDIPackage.STATE_SHAPE__INTERNAL_TRANSITION_COMPARTMENT:
				setInternalTransitionCompartment((InternalTransitionCompartment)newValue);
				return;
			case UMLDIPackage.STATE_SHAPE__DEFERRABLE_TRIGGER_COMPARTMENT:
				setDeferrableTriggerCompartment((DeferrableTriggerCompartment)newValue);
				return;
			case UMLDIPackage.STATE_SHAPE__INTERNAL_BEHAVIOR_COMPARTMENT:
				setInternalBehaviorCompartment((InternalBehaviorCompartment)newValue);
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
			case UMLDIPackage.STATE_SHAPE__CONNECTION_POINT_REFERENCE_SHAPE:
				getConnectionPointReferenceShape().clear();
				return;
			case UMLDIPackage.STATE_SHAPE__INTERNAL_TRANSITION_COMPARTMENT:
				setInternalTransitionCompartment((InternalTransitionCompartment)null);
				return;
			case UMLDIPackage.STATE_SHAPE__DEFERRABLE_TRIGGER_COMPARTMENT:
				setDeferrableTriggerCompartment((DeferrableTriggerCompartment)null);
				return;
			case UMLDIPackage.STATE_SHAPE__INTERNAL_BEHAVIOR_COMPARTMENT:
				setInternalBehaviorCompartment((InternalBehaviorCompartment)null);
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
			case UMLDIPackage.STATE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
				return isSetOwnedUmlDiagramElement();
			case UMLDIPackage.STATE_SHAPE__CONNECTION_POINT_REFERENCE_SHAPE:
				return connectionPointReferenceShape != null && !connectionPointReferenceShape.isEmpty();
			case UMLDIPackage.STATE_SHAPE__INTERNAL_TRANSITION_COMPARTMENT:
				return internalTransitionCompartment != null;
			case UMLDIPackage.STATE_SHAPE__DEFERRABLE_TRIGGER_COMPARTMENT:
				return deferrableTriggerCompartment != null;
			case UMLDIPackage.STATE_SHAPE__INTERNAL_BEHAVIOR_COMPARTMENT:
				return internalBehaviorCompartment != null;
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
			|| eIsSet(UMLDIPackage.STATE_SHAPE__CONNECTION_POINT_REFERENCE_SHAPE)
			|| eIsSet(UMLDIPackage.STATE_SHAPE__INTERNAL_TRANSITION_COMPARTMENT)
			|| eIsSet(UMLDIPackage.STATE_SHAPE__DEFERRABLE_TRIGGER_COMPARTMENT)
			|| eIsSet(UMLDIPackage.STATE_SHAPE__INTERNAL_BEHAVIOR_COMPARTMENT);
	}

} //StateShapeImpl
