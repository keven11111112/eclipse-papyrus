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

import org.eclipse.papyrus.umldi.ElementWithStructureShape;
import org.eclipse.papyrus.umldi.StructureCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structure Compartment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.StructureCompartmentImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.StructureCompartmentImpl#getElementWithStructureShape <em>Element With Structure Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StructureCompartmentImpl extends DiagramCompartmentImpl implements StructureCompartment {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected StructureCompartmentImpl() {
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
		return UMLDIPackage.Literals.STRUCTURE_COMPARTMENT;
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
		ElementWithStructureShape elementWithStructureShape = getElementWithStructureShape();
		if(elementWithStructureShape != null) {
			return elementWithStructureShape;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ElementWithStructureShape getElementWithStructureShape() {
		if(eContainerFeatureID() != UMLDIPackage.STRUCTURE_COMPARTMENT__ELEMENT_WITH_STRUCTURE_SHAPE)
			return null;
		return (ElementWithStructureShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetElementWithStructureShape(ElementWithStructureShape newElementWithStructureShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newElementWithStructureShape, UMLDIPackage.STRUCTURE_COMPARTMENT__ELEMENT_WITH_STRUCTURE_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setElementWithStructureShape(ElementWithStructureShape newElementWithStructureShape) {
		if(newElementWithStructureShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.STRUCTURE_COMPARTMENT__ELEMENT_WITH_STRUCTURE_SHAPE && newElementWithStructureShape != null)) {
			if(EcoreUtil.isAncestor(this, newElementWithStructureShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newElementWithStructureShape != null)
				msgs = ((InternalEObject)newElementWithStructureShape).eInverseAdd(this, UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE__STRUCTURE_COMPARTMENT, ElementWithStructureShape.class, msgs);
			msgs = basicSetElementWithStructureShape(newElementWithStructureShape, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.STRUCTURE_COMPARTMENT__ELEMENT_WITH_STRUCTURE_SHAPE, newElementWithStructureShape, newElementWithStructureShape));
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
		case UMLDIPackage.STRUCTURE_COMPARTMENT__ELEMENT_WITH_STRUCTURE_SHAPE:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetElementWithStructureShape((ElementWithStructureShape)otherEnd, msgs);
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
		case UMLDIPackage.STRUCTURE_COMPARTMENT__ELEMENT_WITH_STRUCTURE_SHAPE:
			return basicSetElementWithStructureShape(null, msgs);
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
		case UMLDIPackage.STRUCTURE_COMPARTMENT__ELEMENT_WITH_STRUCTURE_SHAPE:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE__STRUCTURE_COMPARTMENT, ElementWithStructureShape.class, msgs);
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
		case UMLDIPackage.STRUCTURE_COMPARTMENT__ELEMENT_WITH_STRUCTURE_SHAPE:
			return getElementWithStructureShape();
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
		case UMLDIPackage.STRUCTURE_COMPARTMENT__ELEMENT_WITH_STRUCTURE_SHAPE:
			setElementWithStructureShape((ElementWithStructureShape)newValue);
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
		case UMLDIPackage.STRUCTURE_COMPARTMENT__ELEMENT_WITH_STRUCTURE_SHAPE:
			setElementWithStructureShape((ElementWithStructureShape)null);
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
		case UMLDIPackage.STRUCTURE_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			return isSetOwningUmlDiagramElement();
		case UMLDIPackage.STRUCTURE_COMPARTMENT__ELEMENT_WITH_STRUCTURE_SHAPE:
			return getElementWithStructureShape() != null;
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
		return super.isSetOwningUmlDiagramElement() || eIsSet(UMLDIPackage.STRUCTURE_COMPARTMENT__ELEMENT_WITH_STRUCTURE_SHAPE);
	}
} //StructureCompartmentImpl
