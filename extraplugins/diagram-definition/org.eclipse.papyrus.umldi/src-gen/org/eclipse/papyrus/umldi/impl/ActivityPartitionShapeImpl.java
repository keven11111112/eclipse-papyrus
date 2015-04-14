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
import org.eclipse.papyrus.umldi.SubPartitionCompartment;
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
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ActivityPartitionShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ActivityPartitionShapeImpl#isVertical <em>Is Vertical</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ActivityPartitionShapeImpl#getSubPartitionCompartment <em>Sub Partition Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActivityPartitionShapeImpl extends ActivityGroupShapeImpl implements ActivityPartitionShape {
	/**
	 * The default value of the '{@link #isVertical() <em>Is Vertical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVertical()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_VERTICAL_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isVertical() <em>Is Vertical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVertical()
	 * @generated
	 * @ordered
	 */
	protected boolean isVertical = IS_VERTICAL_EDEFAULT;
	/**
	 * The cached value of the '{@link #getSubPartitionCompartment() <em>Sub Partition Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubPartitionCompartment()
	 * @generated
	 * @ordered
	 */
	protected SubPartitionCompartment subPartitionCompartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityPartitionShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.ACTIVITY_PARTITION_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @see #getOwnedUmlDiagramElement()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[] {UMLDIPackage.ACTIVITY_PARTITION_SHAPE__MAIN_LABEL, UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUB_PARTITION_COMPARTMENT};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVertical() {
		return isVertical;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsVertical(boolean newIsVertical) {
		boolean oldIsVertical = isVertical;
		isVertical = newIsVertical;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.ACTIVITY_PARTITION_SHAPE__IS_VERTICAL, oldIsVertical, isVertical));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubPartitionCompartment getSubPartitionCompartment() {
		return subPartitionCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubPartitionCompartment(SubPartitionCompartment newSubPartitionCompartment, NotificationChain msgs) {
		SubPartitionCompartment oldSubPartitionCompartment = subPartitionCompartment;
		subPartitionCompartment = newSubPartitionCompartment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUB_PARTITION_COMPARTMENT, oldSubPartitionCompartment, newSubPartitionCompartment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubPartitionCompartment(SubPartitionCompartment newSubPartitionCompartment) {
		if (newSubPartitionCompartment != subPartitionCompartment) {
			NotificationChain msgs = null;
			if (subPartitionCompartment != null)
				msgs = ((InternalEObject)subPartitionCompartment).eInverseRemove(this, UMLDIPackage.SUB_PARTITION_COMPARTMENT__ACTIVITY_PARTITION_SHAPE, SubPartitionCompartment.class, msgs);
			if (newSubPartitionCompartment != null)
				msgs = ((InternalEObject)newSubPartitionCompartment).eInverseAdd(this, UMLDIPackage.SUB_PARTITION_COMPARTMENT__ACTIVITY_PARTITION_SHAPE, SubPartitionCompartment.class, msgs);
			msgs = basicSetSubPartitionCompartment(newSubPartitionCompartment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUB_PARTITION_COMPARTMENT, newSubPartitionCompartment, newSubPartitionCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUB_PARTITION_COMPARTMENT:
				if (subPartitionCompartment != null)
					msgs = ((InternalEObject)subPartitionCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUB_PARTITION_COMPARTMENT, null, msgs);
				return basicSetSubPartitionCompartment((SubPartitionCompartment)otherEnd, msgs);
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
			case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUB_PARTITION_COMPARTMENT:
				return basicSetSubPartitionCompartment(null, msgs);
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
			case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__IS_VERTICAL:
				return isVertical();
			case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUB_PARTITION_COMPARTMENT:
				return getSubPartitionCompartment();
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
			case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__IS_VERTICAL:
				setIsVertical((Boolean)newValue);
				return;
			case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUB_PARTITION_COMPARTMENT:
				setSubPartitionCompartment((SubPartitionCompartment)newValue);
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
			case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__IS_VERTICAL:
				setIsVertical(IS_VERTICAL_EDEFAULT);
				return;
			case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUB_PARTITION_COMPARTMENT:
				setSubPartitionCompartment((SubPartitionCompartment)null);
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
			case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
				return isSetOwnedUmlDiagramElement();
			case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__IS_VERTICAL:
				return isVertical != IS_VERTICAL_EDEFAULT;
			case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUB_PARTITION_COMPARTMENT:
				return subPartitionCompartment != null;
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
		result.append(" (isVertical: ");
		result.append(isVertical);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedUmlDiagramElement() {
		return super.isSetOwnedUmlDiagramElement()
			|| eIsSet(UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUB_PARTITION_COMPARTMENT);
	}

} //ActivityPartitionShapeImpl
