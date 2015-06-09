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

import org.eclipse.papyrus.umldi.ActivityPartitionShape;
import org.eclipse.papyrus.umldi.SubpartitionCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subpartition Compartment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.SubpartitionCompartmentImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.SubpartitionCompartmentImpl#getActivityPartitionShape <em>Activity Partition Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubpartitionCompartmentImpl extends DiagramCompartmentImpl implements SubpartitionCompartment {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SubpartitionCompartmentImpl() {
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
		return UMLDIPackage.Literals.SUBPARTITION_COMPARTMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
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
	 * 
	 * @generated
	 */
	@Override
	public UmlDiagramElement basicGetOwningUmlDiagramElement() {
		ActivityPartitionShape activityPartitionShape = getActivityPartitionShape();
		if(activityPartitionShape != null) {
			return activityPartitionShape;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivityPartitionShape getActivityPartitionShape() {
		if(eContainerFeatureID() != UMLDIPackage.SUBPARTITION_COMPARTMENT__ACTIVITY_PARTITION_SHAPE)
			return null;
		return (ActivityPartitionShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetActivityPartitionShape(ActivityPartitionShape newActivityPartitionShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newActivityPartitionShape, UMLDIPackage.SUBPARTITION_COMPARTMENT__ACTIVITY_PARTITION_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setActivityPartitionShape(ActivityPartitionShape newActivityPartitionShape) {
		if(newActivityPartitionShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.SUBPARTITION_COMPARTMENT__ACTIVITY_PARTITION_SHAPE && newActivityPartitionShape != null)) {
			if(EcoreUtil.isAncestor(this, newActivityPartitionShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newActivityPartitionShape != null)
				msgs = ((InternalEObject)newActivityPartitionShape).eInverseAdd(this, UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUBPARTITION_COMPARTMENT, ActivityPartitionShape.class, msgs);
			msgs = basicSetActivityPartitionShape(newActivityPartitionShape, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.SUBPARTITION_COMPARTMENT__ACTIVITY_PARTITION_SHAPE, newActivityPartitionShape, newActivityPartitionShape));
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
		case UMLDIPackage.SUBPARTITION_COMPARTMENT__ACTIVITY_PARTITION_SHAPE:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetActivityPartitionShape((ActivityPartitionShape)otherEnd, msgs);
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
		case UMLDIPackage.SUBPARTITION_COMPARTMENT__ACTIVITY_PARTITION_SHAPE:
			return basicSetActivityPartitionShape(null, msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch(eContainerFeatureID()) {
		case UMLDIPackage.SUBPARTITION_COMPARTMENT__ACTIVITY_PARTITION_SHAPE:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUBPARTITION_COMPARTMENT, ActivityPartitionShape.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
		case UMLDIPackage.SUBPARTITION_COMPARTMENT__ACTIVITY_PARTITION_SHAPE:
			return getActivityPartitionShape();
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
		case UMLDIPackage.SUBPARTITION_COMPARTMENT__ACTIVITY_PARTITION_SHAPE:
			setActivityPartitionShape((ActivityPartitionShape)newValue);
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
		case UMLDIPackage.SUBPARTITION_COMPARTMENT__ACTIVITY_PARTITION_SHAPE:
			setActivityPartitionShape((ActivityPartitionShape)null);
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
		case UMLDIPackage.SUBPARTITION_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			return isSetOwningUmlDiagramElement();
		case UMLDIPackage.SUBPARTITION_COMPARTMENT__ACTIVITY_PARTITION_SHAPE:
			return getActivityPartitionShape() != null;
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
	public boolean isSetOwningUmlDiagramElement() {
		return super.isSetOwningUmlDiagramElement() || eIsSet(UMLDIPackage.SUBPARTITION_COMPARTMENT__ACTIVITY_PARTITION_SHAPE);
	}
} //SubpartitionCompartmentImpl
