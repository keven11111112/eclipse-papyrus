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

import org.eclipse.papyrus.umldi.ObjectFlowEdge;
import org.eclipse.papyrus.umldi.ObjectNodeShape;
import org.eclipse.papyrus.umldi.SelectionLabel;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Selection Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.SelectionLabelImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.SelectionLabelImpl#getObjectFlowEdge <em>Object Flow Edge</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.SelectionLabelImpl#getObjectNodeShape <em>Object Node Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SelectionLabelImpl extends UmlLabelImpl implements SelectionLabel {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SelectionLabelImpl() {
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
		return UMLDIPackage.Literals.SELECTION_LABEL;
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
		ObjectFlowEdge objectFlowEdge = getObjectFlowEdge();
		if(objectFlowEdge != null) {
			return objectFlowEdge;
		}
		ObjectNodeShape objectNodeShape = getObjectNodeShape();
		if(objectNodeShape != null) {
			return objectNodeShape;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ObjectFlowEdge getObjectFlowEdge() {
		if(eContainerFeatureID() != UMLDIPackage.SELECTION_LABEL__OBJECT_FLOW_EDGE)
			return null;
		return (ObjectFlowEdge)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetObjectFlowEdge(ObjectFlowEdge newObjectFlowEdge, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newObjectFlowEdge, UMLDIPackage.SELECTION_LABEL__OBJECT_FLOW_EDGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setObjectFlowEdge(ObjectFlowEdge newObjectFlowEdge) {
		if(newObjectFlowEdge != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.SELECTION_LABEL__OBJECT_FLOW_EDGE && newObjectFlowEdge != null)) {
			if(EcoreUtil.isAncestor(this, newObjectFlowEdge))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newObjectFlowEdge != null)
				msgs = ((InternalEObject)newObjectFlowEdge).eInverseAdd(this, UMLDIPackage.OBJECT_FLOW_EDGE__SELECTION_LABEL, ObjectFlowEdge.class, msgs);
			msgs = basicSetObjectFlowEdge(newObjectFlowEdge, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.SELECTION_LABEL__OBJECT_FLOW_EDGE, newObjectFlowEdge, newObjectFlowEdge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ObjectNodeShape getObjectNodeShape() {
		if(eContainerFeatureID() != UMLDIPackage.SELECTION_LABEL__OBJECT_NODE_SHAPE)
			return null;
		return (ObjectNodeShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetObjectNodeShape(ObjectNodeShape newObjectNodeShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newObjectNodeShape, UMLDIPackage.SELECTION_LABEL__OBJECT_NODE_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setObjectNodeShape(ObjectNodeShape newObjectNodeShape) {
		if(newObjectNodeShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.SELECTION_LABEL__OBJECT_NODE_SHAPE && newObjectNodeShape != null)) {
			if(EcoreUtil.isAncestor(this, newObjectNodeShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newObjectNodeShape != null)
				msgs = ((InternalEObject)newObjectNodeShape).eInverseAdd(this, UMLDIPackage.OBJECT_NODE_SHAPE__SELECTION_LABEL, ObjectNodeShape.class, msgs);
			msgs = basicSetObjectNodeShape(newObjectNodeShape, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.SELECTION_LABEL__OBJECT_NODE_SHAPE, newObjectNodeShape, newObjectNodeShape));
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
		case UMLDIPackage.SELECTION_LABEL__OBJECT_FLOW_EDGE:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetObjectFlowEdge((ObjectFlowEdge)otherEnd, msgs);
		case UMLDIPackage.SELECTION_LABEL__OBJECT_NODE_SHAPE:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetObjectNodeShape((ObjectNodeShape)otherEnd, msgs);
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
		case UMLDIPackage.SELECTION_LABEL__OBJECT_FLOW_EDGE:
			return basicSetObjectFlowEdge(null, msgs);
		case UMLDIPackage.SELECTION_LABEL__OBJECT_NODE_SHAPE:
			return basicSetObjectNodeShape(null, msgs);
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
		case UMLDIPackage.SELECTION_LABEL__OBJECT_FLOW_EDGE:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.OBJECT_FLOW_EDGE__SELECTION_LABEL, ObjectFlowEdge.class, msgs);
		case UMLDIPackage.SELECTION_LABEL__OBJECT_NODE_SHAPE:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.OBJECT_NODE_SHAPE__SELECTION_LABEL, ObjectNodeShape.class, msgs);
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
		case UMLDIPackage.SELECTION_LABEL__OBJECT_FLOW_EDGE:
			return getObjectFlowEdge();
		case UMLDIPackage.SELECTION_LABEL__OBJECT_NODE_SHAPE:
			return getObjectNodeShape();
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
		case UMLDIPackage.SELECTION_LABEL__OBJECT_FLOW_EDGE:
			setObjectFlowEdge((ObjectFlowEdge)newValue);
			return;
		case UMLDIPackage.SELECTION_LABEL__OBJECT_NODE_SHAPE:
			setObjectNodeShape((ObjectNodeShape)newValue);
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
		case UMLDIPackage.SELECTION_LABEL__OBJECT_FLOW_EDGE:
			setObjectFlowEdge((ObjectFlowEdge)null);
			return;
		case UMLDIPackage.SELECTION_LABEL__OBJECT_NODE_SHAPE:
			setObjectNodeShape((ObjectNodeShape)null);
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
		case UMLDIPackage.SELECTION_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			return isSetOwningUmlDiagramElement();
		case UMLDIPackage.SELECTION_LABEL__OBJECT_FLOW_EDGE:
			return getObjectFlowEdge() != null;
		case UMLDIPackage.SELECTION_LABEL__OBJECT_NODE_SHAPE:
			return getObjectNodeShape() != null;
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
		return super.isSetOwningUmlDiagramElement() || eIsSet(UMLDIPackage.SELECTION_LABEL__OBJECT_FLOW_EDGE) || eIsSet(UMLDIPackage.SELECTION_LABEL__OBJECT_NODE_SHAPE);
	}
} //SelectionLabelImpl
