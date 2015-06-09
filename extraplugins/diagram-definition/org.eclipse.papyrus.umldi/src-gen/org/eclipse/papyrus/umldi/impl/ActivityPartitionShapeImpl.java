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

import org.eclipse.papyrus.umldi.ActivityPartitionShape;
import org.eclipse.papyrus.umldi.SubpartitionCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity Partition Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ActivityPartitionShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ActivityPartitionShapeImpl#isVertical <em>Is Vertical</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ActivityPartitionShapeImpl#getSubpartitionCompartment <em>Subpartition Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActivityPartitionShapeImpl extends ActivityGroupShapeImpl implements ActivityPartitionShape {

	/**
	 * The default value of the '{@link #isVertical() <em>Is Vertical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isVertical()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_VERTICAL_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isVertical() <em>Is Vertical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isVertical()
	 * @generated
	 * @ordered
	 */
	protected boolean isVertical = IS_VERTICAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSubpartitionCompartment() <em>Subpartition Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSubpartitionCompartment()
	 * @generated
	 * @ordered
	 */
	protected SubpartitionCompartment subpartitionCompartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ActivityPartitionShapeImpl() {
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
		return UMLDIPackage.Literals.ACTIVITY_PARTITION_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.ACTIVITY_PARTITION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
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
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.ACTIVITY_PARTITION_SHAPE__STEREOTYPE_LABEL, UMLDIPackage.ACTIVITY_PARTITION_SHAPE__MAIN_LABEL, UMLDIPackage.ACTIVITY_PARTITION_SHAPE__STEREOTYPE_COMPARTMENT, UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUBPARTITION_COMPARTMENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isVertical() {
		return isVertical;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIsVertical(boolean newIsVertical) {
		boolean oldIsVertical = isVertical;
		isVertical = newIsVertical;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.ACTIVITY_PARTITION_SHAPE__IS_VERTICAL, oldIsVertical, isVertical));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SubpartitionCompartment getSubpartitionCompartment() {
		return subpartitionCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetSubpartitionCompartment(SubpartitionCompartment newSubpartitionCompartment, NotificationChain msgs) {
		SubpartitionCompartment oldSubpartitionCompartment = subpartitionCompartment;
		subpartitionCompartment = newSubpartitionCompartment;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUBPARTITION_COMPARTMENT, oldSubpartitionCompartment, newSubpartitionCompartment);
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
	public void setSubpartitionCompartment(SubpartitionCompartment newSubpartitionCompartment) {
		if(newSubpartitionCompartment != subpartitionCompartment) {
			NotificationChain msgs = null;
			if(subpartitionCompartment != null)
				msgs = ((InternalEObject)subpartitionCompartment).eInverseRemove(this, UMLDIPackage.SUBPARTITION_COMPARTMENT__ACTIVITY_PARTITION_SHAPE, SubpartitionCompartment.class, msgs);
			if(newSubpartitionCompartment != null)
				msgs = ((InternalEObject)newSubpartitionCompartment).eInverseAdd(this, UMLDIPackage.SUBPARTITION_COMPARTMENT__ACTIVITY_PARTITION_SHAPE, SubpartitionCompartment.class, msgs);
			msgs = basicSetSubpartitionCompartment(newSubpartitionCompartment, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUBPARTITION_COMPARTMENT, newSubpartitionCompartment, newSubpartitionCompartment));
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
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUBPARTITION_COMPARTMENT:
			if(subpartitionCompartment != null)
				msgs = ((InternalEObject)subpartitionCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUBPARTITION_COMPARTMENT, null, msgs);
			return basicSetSubpartitionCompartment((SubpartitionCompartment)otherEnd, msgs);
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
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUBPARTITION_COMPARTMENT:
			return basicSetSubpartitionCompartment(null, msgs);
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
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__IS_VERTICAL:
			return isVertical();
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUBPARTITION_COMPARTMENT:
			return getSubpartitionCompartment();
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
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__IS_VERTICAL:
			setIsVertical((Boolean)newValue);
			return;
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUBPARTITION_COMPARTMENT:
			setSubpartitionCompartment((SubpartitionCompartment)newValue);
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
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__IS_VERTICAL:
			setIsVertical(IS_VERTICAL_EDEFAULT);
			return;
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUBPARTITION_COMPARTMENT:
			setSubpartitionCompartment((SubpartitionCompartment)null);
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
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__IS_VERTICAL:
			return isVertical != IS_VERTICAL_EDEFAULT;
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUBPARTITION_COMPARTMENT:
			return subpartitionCompartment != null;
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
	public String toString() {
		if(eIsProxy())
			return super.toString();
		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isVertical: ");
		result.append(isVertical);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isSetOwnedUmlDiagramElement() {
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUBPARTITION_COMPARTMENT);
	}
} //ActivityPartitionShapeImpl
