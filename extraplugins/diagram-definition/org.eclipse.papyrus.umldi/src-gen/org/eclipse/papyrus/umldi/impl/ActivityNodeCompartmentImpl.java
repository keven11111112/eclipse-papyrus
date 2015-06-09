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

import org.eclipse.papyrus.umldi.ActivityNodeCompartment;
import org.eclipse.papyrus.umldi.ElementWithActivityNodesShape;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity Node Compartment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ActivityNodeCompartmentImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ActivityNodeCompartmentImpl#getElementWithActivityNodesShape <em>Element With Activity Nodes Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActivityNodeCompartmentImpl extends DiagramCompartmentImpl implements ActivityNodeCompartment {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ActivityNodeCompartmentImpl() {
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
		return UMLDIPackage.Literals.ACTIVITY_NODE_COMPARTMENT;
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
		ElementWithActivityNodesShape elementWithActivityNodesShape = getElementWithActivityNodesShape();
		if(elementWithActivityNodesShape != null) {
			return elementWithActivityNodesShape;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ElementWithActivityNodesShape getElementWithActivityNodesShape() {
		if(eContainerFeatureID() != UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__ELEMENT_WITH_ACTIVITY_NODES_SHAPE)
			return null;
		return (ElementWithActivityNodesShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetElementWithActivityNodesShape(ElementWithActivityNodesShape newElementWithActivityNodesShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newElementWithActivityNodesShape, UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__ELEMENT_WITH_ACTIVITY_NODES_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setElementWithActivityNodesShape(ElementWithActivityNodesShape newElementWithActivityNodesShape) {
		if(newElementWithActivityNodesShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__ELEMENT_WITH_ACTIVITY_NODES_SHAPE && newElementWithActivityNodesShape != null)) {
			if(EcoreUtil.isAncestor(this, newElementWithActivityNodesShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newElementWithActivityNodesShape != null)
				msgs = ((InternalEObject)newElementWithActivityNodesShape).eInverseAdd(this, UMLDIPackage.ELEMENT_WITH_ACTIVITY_NODES_SHAPE__ACTIVITY_NODE_COMPARTMENT, ElementWithActivityNodesShape.class, msgs);
			msgs = basicSetElementWithActivityNodesShape(newElementWithActivityNodesShape, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__ELEMENT_WITH_ACTIVITY_NODES_SHAPE, newElementWithActivityNodesShape, newElementWithActivityNodesShape));
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
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__ELEMENT_WITH_ACTIVITY_NODES_SHAPE:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetElementWithActivityNodesShape((ElementWithActivityNodesShape)otherEnd, msgs);
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
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__ELEMENT_WITH_ACTIVITY_NODES_SHAPE:
			return basicSetElementWithActivityNodesShape(null, msgs);
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
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__ELEMENT_WITH_ACTIVITY_NODES_SHAPE:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.ELEMENT_WITH_ACTIVITY_NODES_SHAPE__ACTIVITY_NODE_COMPARTMENT, ElementWithActivityNodesShape.class, msgs);
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
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__ELEMENT_WITH_ACTIVITY_NODES_SHAPE:
			return getElementWithActivityNodesShape();
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
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__ELEMENT_WITH_ACTIVITY_NODES_SHAPE:
			setElementWithActivityNodesShape((ElementWithActivityNodesShape)newValue);
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
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__ELEMENT_WITH_ACTIVITY_NODES_SHAPE:
			setElementWithActivityNodesShape((ElementWithActivityNodesShape)null);
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
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			return isSetOwningUmlDiagramElement();
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__ELEMENT_WITH_ACTIVITY_NODES_SHAPE:
			return getElementWithActivityNodesShape() != null;
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
		return super.isSetOwningUmlDiagramElement() || eIsSet(UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__ELEMENT_WITH_ACTIVITY_NODES_SHAPE);
	}
} //ActivityNodeCompartmentImpl
