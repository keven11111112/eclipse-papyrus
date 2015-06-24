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

import org.eclipse.papyrus.umldi.ExpansionNodeShape;
import org.eclipse.papyrus.umldi.ExpansionRegionShape;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expansion Node Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ExpansionNodeShapeImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ExpansionNodeShapeImpl#getExpansionRegionShape <em>Expansion Region Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpansionNodeShapeImpl extends ObjectNodeShapeImpl implements ExpansionNodeShape {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ExpansionNodeShapeImpl() {
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
		return UMLDIPackage.Literals.EXPANSION_NODE_SHAPE;
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
		ExpansionRegionShape expansionRegionShape = getExpansionRegionShape();
		if(expansionRegionShape != null) {
			return expansionRegionShape;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExpansionRegionShape getExpansionRegionShape() {
		if(eContainerFeatureID() != UMLDIPackage.EXPANSION_NODE_SHAPE__EXPANSION_REGION_SHAPE)
			return null;
		return (ExpansionRegionShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetExpansionRegionShape(ExpansionRegionShape newExpansionRegionShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newExpansionRegionShape, UMLDIPackage.EXPANSION_NODE_SHAPE__EXPANSION_REGION_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setExpansionRegionShape(ExpansionRegionShape newExpansionRegionShape) {
		if(newExpansionRegionShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.EXPANSION_NODE_SHAPE__EXPANSION_REGION_SHAPE && newExpansionRegionShape != null)) {
			if(EcoreUtil.isAncestor(this, newExpansionRegionShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newExpansionRegionShape != null)
				msgs = ((InternalEObject)newExpansionRegionShape).eInverseAdd(this, UMLDIPackage.EXPANSION_REGION_SHAPE__EXPANSION_NODE_SHAPE, ExpansionRegionShape.class, msgs);
			msgs = basicSetExpansionRegionShape(newExpansionRegionShape, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.EXPANSION_NODE_SHAPE__EXPANSION_REGION_SHAPE, newExpansionRegionShape, newExpansionRegionShape));
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
		case UMLDIPackage.EXPANSION_NODE_SHAPE__EXPANSION_REGION_SHAPE:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetExpansionRegionShape((ExpansionRegionShape)otherEnd, msgs);
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
		case UMLDIPackage.EXPANSION_NODE_SHAPE__EXPANSION_REGION_SHAPE:
			return basicSetExpansionRegionShape(null, msgs);
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
		case UMLDIPackage.EXPANSION_NODE_SHAPE__EXPANSION_REGION_SHAPE:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.EXPANSION_REGION_SHAPE__EXPANSION_NODE_SHAPE, ExpansionRegionShape.class, msgs);
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
		case UMLDIPackage.EXPANSION_NODE_SHAPE__EXPANSION_REGION_SHAPE:
			return getExpansionRegionShape();
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
		case UMLDIPackage.EXPANSION_NODE_SHAPE__EXPANSION_REGION_SHAPE:
			setExpansionRegionShape((ExpansionRegionShape)newValue);
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
		case UMLDIPackage.EXPANSION_NODE_SHAPE__EXPANSION_REGION_SHAPE:
			setExpansionRegionShape((ExpansionRegionShape)null);
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
		case UMLDIPackage.EXPANSION_NODE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			return isSetOwningUmlDiagramElement();
		case UMLDIPackage.EXPANSION_NODE_SHAPE__EXPANSION_REGION_SHAPE:
			return getExpansionRegionShape() != null;
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
		return super.isSetOwningUmlDiagramElement() || eIsSet(UMLDIPackage.EXPANSION_NODE_SHAPE__EXPANSION_REGION_SHAPE);
	}
} //ExpansionNodeShapeImpl
