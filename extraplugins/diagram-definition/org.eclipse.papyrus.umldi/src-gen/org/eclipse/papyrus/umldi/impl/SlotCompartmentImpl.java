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

import org.eclipse.papyrus.umldi.InstanceSpecificationShape;
import org.eclipse.papyrus.umldi.SlotCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slot Compartment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.SlotCompartmentImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.SlotCompartmentImpl#getInstanceSpecificationShape <em>Instance Specification Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SlotCompartmentImpl extends ListCompartmentImpl implements SlotCompartment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SlotCompartmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.SLOT_COMPARTMENT;
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
		InstanceSpecificationShape instanceSpecificationShape = getInstanceSpecificationShape();			
		if (instanceSpecificationShape != null) {
			return instanceSpecificationShape;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSpecificationShape getInstanceSpecificationShape() {
		if (eContainerFeatureID() != UMLDIPackage.SLOT_COMPARTMENT__INSTANCE_SPECIFICATION_SHAPE) return null;
		return (InstanceSpecificationShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInstanceSpecificationShape(InstanceSpecificationShape newInstanceSpecificationShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInstanceSpecificationShape, UMLDIPackage.SLOT_COMPARTMENT__INSTANCE_SPECIFICATION_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceSpecificationShape(InstanceSpecificationShape newInstanceSpecificationShape) {
		if (newInstanceSpecificationShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.SLOT_COMPARTMENT__INSTANCE_SPECIFICATION_SHAPE && newInstanceSpecificationShape != null)) {
			if (EcoreUtil.isAncestor(this, newInstanceSpecificationShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInstanceSpecificationShape != null)
				msgs = ((InternalEObject)newInstanceSpecificationShape).eInverseAdd(this, UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE__SLOT_COMPARTMENT, InstanceSpecificationShape.class, msgs);
			msgs = basicSetInstanceSpecificationShape(newInstanceSpecificationShape, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.SLOT_COMPARTMENT__INSTANCE_SPECIFICATION_SHAPE, newInstanceSpecificationShape, newInstanceSpecificationShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.SLOT_COMPARTMENT__INSTANCE_SPECIFICATION_SHAPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInstanceSpecificationShape((InstanceSpecificationShape)otherEnd, msgs);
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
			case UMLDIPackage.SLOT_COMPARTMENT__INSTANCE_SPECIFICATION_SHAPE:
				return basicSetInstanceSpecificationShape(null, msgs);
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
			case UMLDIPackage.SLOT_COMPARTMENT__INSTANCE_SPECIFICATION_SHAPE:
				return eInternalContainer().eInverseRemove(this, UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE__SLOT_COMPARTMENT, InstanceSpecificationShape.class, msgs);
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
			case UMLDIPackage.SLOT_COMPARTMENT__INSTANCE_SPECIFICATION_SHAPE:
				return getInstanceSpecificationShape();
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
			case UMLDIPackage.SLOT_COMPARTMENT__INSTANCE_SPECIFICATION_SHAPE:
				setInstanceSpecificationShape((InstanceSpecificationShape)newValue);
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
			case UMLDIPackage.SLOT_COMPARTMENT__INSTANCE_SPECIFICATION_SHAPE:
				setInstanceSpecificationShape((InstanceSpecificationShape)null);
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
			case UMLDIPackage.SLOT_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
				return isSetOwningUmlDiagramElement();
			case UMLDIPackage.SLOT_COMPARTMENT__INSTANCE_SPECIFICATION_SHAPE:
				return getInstanceSpecificationShape() != null;
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
			|| eIsSet(UMLDIPackage.SLOT_COMPARTMENT__INSTANCE_SPECIFICATION_SHAPE);
	}

} //SlotCompartmentImpl
