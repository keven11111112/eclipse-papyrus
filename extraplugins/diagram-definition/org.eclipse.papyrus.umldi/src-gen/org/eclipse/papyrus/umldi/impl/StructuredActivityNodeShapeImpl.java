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

import org.eclipse.papyrus.umldi.ActivityGroupShape;
import org.eclipse.papyrus.umldi.ActivityNodeCompartment;
import org.eclipse.papyrus.umldi.ElementWithActivityNodesShape;
import org.eclipse.papyrus.umldi.StructuredActivityNodeShape;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structured Activity Node Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.StructuredActivityNodeShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.StructuredActivityNodeShapeImpl#getActivityNodeCompartment <em>Activity Node Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StructuredActivityNodeShapeImpl extends ActionShapeImpl implements StructuredActivityNodeShape {

	/**
	 * The cached value of the '{@link #getActivityNodeCompartment() <em>Activity Node Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getActivityNodeCompartment()
	 * @generated
	 * @ordered
	 */
	protected ActivityNodeCompartment activityNodeCompartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected StructuredActivityNodeShapeImpl() {
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
		return UMLDIPackage.Literals.STRUCTURED_ACTIVITY_NODE_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
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
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__STEREOTYPE_LABEL, UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__MAIN_LABEL, UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__STEREOTYPE_COMPARTMENT, UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__PIN_SHAPE, UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__CONDITION_LABEL, UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__ACTIVITY_NODE_COMPARTMENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivityNodeCompartment getActivityNodeCompartment() {
		return activityNodeCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetActivityNodeCompartment(ActivityNodeCompartment newActivityNodeCompartment, NotificationChain msgs) {
		ActivityNodeCompartment oldActivityNodeCompartment = activityNodeCompartment;
		activityNodeCompartment = newActivityNodeCompartment;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__ACTIVITY_NODE_COMPARTMENT, oldActivityNodeCompartment, newActivityNodeCompartment);
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
	public void setActivityNodeCompartment(ActivityNodeCompartment newActivityNodeCompartment) {
		if(newActivityNodeCompartment != activityNodeCompartment) {
			NotificationChain msgs = null;
			if(activityNodeCompartment != null)
				msgs = ((InternalEObject)activityNodeCompartment).eInverseRemove(this, UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__ELEMENT_WITH_ACTIVITY_NODES_SHAPE, ActivityNodeCompartment.class, msgs);
			if(newActivityNodeCompartment != null)
				msgs = ((InternalEObject)newActivityNodeCompartment).eInverseAdd(this, UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__ELEMENT_WITH_ACTIVITY_NODES_SHAPE, ActivityNodeCompartment.class, msgs);
			msgs = basicSetActivityNodeCompartment(newActivityNodeCompartment, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__ACTIVITY_NODE_COMPARTMENT, newActivityNodeCompartment, newActivityNodeCompartment));
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
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__ACTIVITY_NODE_COMPARTMENT:
			if(activityNodeCompartment != null)
				msgs = ((InternalEObject)activityNodeCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__ACTIVITY_NODE_COMPARTMENT, null, msgs);
			return basicSetActivityNodeCompartment((ActivityNodeCompartment)otherEnd, msgs);
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
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__ACTIVITY_NODE_COMPARTMENT:
			return basicSetActivityNodeCompartment(null, msgs);
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
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__ACTIVITY_NODE_COMPARTMENT:
			return getActivityNodeCompartment();
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
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__ACTIVITY_NODE_COMPARTMENT:
			setActivityNodeCompartment((ActivityNodeCompartment)newValue);
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
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__ACTIVITY_NODE_COMPARTMENT:
			setActivityNodeCompartment((ActivityNodeCompartment)null);
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
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__ACTIVITY_NODE_COMPARTMENT:
			return activityNodeCompartment != null;
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if(baseClass == ElementWithActivityNodesShape.class) {
			switch(derivedFeatureID) {
			case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__ACTIVITY_NODE_COMPARTMENT:
				return UMLDIPackage.ELEMENT_WITH_ACTIVITY_NODES_SHAPE__ACTIVITY_NODE_COMPARTMENT;
			default:
				return -1;
			}
		}
		if(baseClass == ActivityGroupShape.class) {
			switch(derivedFeatureID) {
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if(baseClass == ElementWithActivityNodesShape.class) {
			switch(baseFeatureID) {
			case UMLDIPackage.ELEMENT_WITH_ACTIVITY_NODES_SHAPE__ACTIVITY_NODE_COMPARTMENT:
				return UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__ACTIVITY_NODE_COMPARTMENT;
			default:
				return -1;
			}
		}
		if(baseClass == ActivityGroupShape.class) {
			switch(baseFeatureID) {
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isSetOwnedUmlDiagramElement() {
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__ACTIVITY_NODE_COMPARTMENT);
	}
} //StructuredActivityNodeShapeImpl
