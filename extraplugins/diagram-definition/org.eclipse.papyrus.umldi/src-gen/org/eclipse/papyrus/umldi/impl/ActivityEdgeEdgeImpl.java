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

import org.eclipse.papyrus.umldi.ActivityEdgeEdge;
import org.eclipse.papyrus.umldi.GuardLabel;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;
import org.eclipse.papyrus.umldi.WeightLabel;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity Edge Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ActivityEdgeEdgeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ActivityEdgeEdgeImpl#getGuardLabel <em>Guard Label</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ActivityEdgeEdgeImpl#getWeightLabel <em>Weight Label</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ActivityEdgeEdgeImpl extends ElementEdgeImpl implements ActivityEdgeEdge {

	/**
	 * The cached value of the '{@link #getGuardLabel() <em>Guard Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGuardLabel()
	 * @generated
	 * @ordered
	 */
	protected GuardLabel guardLabel;

	/**
	 * The cached value of the '{@link #getWeightLabel() <em>Weight Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getWeightLabel()
	 * @generated
	 * @ordered
	 */
	protected WeightLabel weightLabel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ActivityEdgeEdgeImpl() {
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
		return UMLDIPackage.Literals.ACTIVITY_EDGE_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.ACTIVITY_EDGE_EDGE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOwnedUmlDiagramElement()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.ACTIVITY_EDGE_EDGE__STEREOTYPE_LABEL, UMLDIPackage.ACTIVITY_EDGE_EDGE__MAIN_LABEL, UMLDIPackage.ACTIVITY_EDGE_EDGE__GUARD_LABEL, UMLDIPackage.ACTIVITY_EDGE_EDGE__WEIGHT_LABEL };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GuardLabel getGuardLabel() {
		return guardLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetGuardLabel(GuardLabel newGuardLabel, NotificationChain msgs) {
		GuardLabel oldGuardLabel = guardLabel;
		guardLabel = newGuardLabel;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.ACTIVITY_EDGE_EDGE__GUARD_LABEL, oldGuardLabel, newGuardLabel);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGuardLabel(GuardLabel newGuardLabel) {
		if(newGuardLabel != guardLabel) {
			NotificationChain msgs = null;
			if(guardLabel != null)
				msgs = ((InternalEObject)guardLabel).eInverseRemove(this, UMLDIPackage.GUARD_LABEL__ACTIVITY_EDGE_EDGE, GuardLabel.class, msgs);
			if(newGuardLabel != null)
				msgs = ((InternalEObject)newGuardLabel).eInverseAdd(this, UMLDIPackage.GUARD_LABEL__ACTIVITY_EDGE_EDGE, GuardLabel.class, msgs);
			msgs = basicSetGuardLabel(newGuardLabel, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.ACTIVITY_EDGE_EDGE__GUARD_LABEL, newGuardLabel, newGuardLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WeightLabel getWeightLabel() {
		return weightLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetWeightLabel(WeightLabel newWeightLabel, NotificationChain msgs) {
		WeightLabel oldWeightLabel = weightLabel;
		weightLabel = newWeightLabel;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.ACTIVITY_EDGE_EDGE__WEIGHT_LABEL, oldWeightLabel, newWeightLabel);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setWeightLabel(WeightLabel newWeightLabel) {
		if(newWeightLabel != weightLabel) {
			NotificationChain msgs = null;
			if(weightLabel != null)
				msgs = ((InternalEObject)weightLabel).eInverseRemove(this, UMLDIPackage.WEIGHT_LABEL__ACTIVITY_EDGE_EDGE, WeightLabel.class, msgs);
			if(newWeightLabel != null)
				msgs = ((InternalEObject)newWeightLabel).eInverseAdd(this, UMLDIPackage.WEIGHT_LABEL__ACTIVITY_EDGE_EDGE, WeightLabel.class, msgs);
			msgs = basicSetWeightLabel(newWeightLabel, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.ACTIVITY_EDGE_EDGE__WEIGHT_LABEL, newWeightLabel, newWeightLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case UMLDIPackage.ACTIVITY_EDGE_EDGE__GUARD_LABEL:
			if(guardLabel != null)
				msgs = ((InternalEObject)guardLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.ACTIVITY_EDGE_EDGE__GUARD_LABEL, null, msgs);
			return basicSetGuardLabel((GuardLabel)otherEnd, msgs);
		case UMLDIPackage.ACTIVITY_EDGE_EDGE__WEIGHT_LABEL:
			if(weightLabel != null)
				msgs = ((InternalEObject)weightLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.ACTIVITY_EDGE_EDGE__WEIGHT_LABEL, null, msgs);
			return basicSetWeightLabel((WeightLabel)otherEnd, msgs);
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
		switch(featureID) {
		case UMLDIPackage.ACTIVITY_EDGE_EDGE__GUARD_LABEL:
			return basicSetGuardLabel(null, msgs);
		case UMLDIPackage.ACTIVITY_EDGE_EDGE__WEIGHT_LABEL:
			return basicSetWeightLabel(null, msgs);
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
		switch(featureID) {
		case UMLDIPackage.ACTIVITY_EDGE_EDGE__GUARD_LABEL:
			return getGuardLabel();
		case UMLDIPackage.ACTIVITY_EDGE_EDGE__WEIGHT_LABEL:
			return getWeightLabel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case UMLDIPackage.ACTIVITY_EDGE_EDGE__GUARD_LABEL:
			setGuardLabel((GuardLabel)newValue);
			return;
		case UMLDIPackage.ACTIVITY_EDGE_EDGE__WEIGHT_LABEL:
			setWeightLabel((WeightLabel)newValue);
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
		switch(featureID) {
		case UMLDIPackage.ACTIVITY_EDGE_EDGE__GUARD_LABEL:
			setGuardLabel((GuardLabel)null);
			return;
		case UMLDIPackage.ACTIVITY_EDGE_EDGE__WEIGHT_LABEL:
			setWeightLabel((WeightLabel)null);
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
		switch(featureID) {
		case UMLDIPackage.ACTIVITY_EDGE_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.ACTIVITY_EDGE_EDGE__GUARD_LABEL:
			return guardLabel != null;
		case UMLDIPackage.ACTIVITY_EDGE_EDGE__WEIGHT_LABEL:
			return weightLabel != null;
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
	public boolean isSetOwnedUmlDiagramElement() {
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.ACTIVITY_EDGE_EDGE__GUARD_LABEL) || eIsSet(UMLDIPackage.ACTIVITY_EDGE_EDGE__WEIGHT_LABEL);
	}
} //ActivityEdgeEdgeImpl
