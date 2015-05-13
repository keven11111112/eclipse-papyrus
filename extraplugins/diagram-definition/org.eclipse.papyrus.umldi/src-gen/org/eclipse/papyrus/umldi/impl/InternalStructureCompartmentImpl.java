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

import org.eclipse.papyrus.umldi.ElementWithInternalStructureShape;
import org.eclipse.papyrus.umldi.InternalStructureCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal Structure Compartment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.InternalStructureCompartmentImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.InternalStructureCompartmentImpl#getElementWithInternalStructureShape <em>Element With Internal Structure Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InternalStructureCompartmentImpl extends DiagramCompartmentImpl implements InternalStructureCompartment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalStructureCompartmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.INTERNAL_STRUCTURE_COMPARTMENT;
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
		ElementWithInternalStructureShape elementWithInternalStructureShape = getElementWithInternalStructureShape();			
		if (elementWithInternalStructureShape != null) {
			return elementWithInternalStructureShape;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementWithInternalStructureShape getElementWithInternalStructureShape() {
		if (eContainerFeatureID() != UMLDIPackage.INTERNAL_STRUCTURE_COMPARTMENT__ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE) return null;
		return (ElementWithInternalStructureShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElementWithInternalStructureShape(ElementWithInternalStructureShape newElementWithInternalStructureShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newElementWithInternalStructureShape, UMLDIPackage.INTERNAL_STRUCTURE_COMPARTMENT__ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementWithInternalStructureShape(ElementWithInternalStructureShape newElementWithInternalStructureShape) {
		if (newElementWithInternalStructureShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.INTERNAL_STRUCTURE_COMPARTMENT__ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE && newElementWithInternalStructureShape != null)) {
			if (EcoreUtil.isAncestor(this, newElementWithInternalStructureShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newElementWithInternalStructureShape != null)
				msgs = ((InternalEObject)newElementWithInternalStructureShape).eInverseAdd(this, UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT, ElementWithInternalStructureShape.class, msgs);
			msgs = basicSetElementWithInternalStructureShape(newElementWithInternalStructureShape, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.INTERNAL_STRUCTURE_COMPARTMENT__ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE, newElementWithInternalStructureShape, newElementWithInternalStructureShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.INTERNAL_STRUCTURE_COMPARTMENT__ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetElementWithInternalStructureShape((ElementWithInternalStructureShape)otherEnd, msgs);
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
			case UMLDIPackage.INTERNAL_STRUCTURE_COMPARTMENT__ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE:
				return basicSetElementWithInternalStructureShape(null, msgs);
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
			case UMLDIPackage.INTERNAL_STRUCTURE_COMPARTMENT__ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE:
				return eInternalContainer().eInverseRemove(this, UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT, ElementWithInternalStructureShape.class, msgs);
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
			case UMLDIPackage.INTERNAL_STRUCTURE_COMPARTMENT__ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE:
				return getElementWithInternalStructureShape();
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
			case UMLDIPackage.INTERNAL_STRUCTURE_COMPARTMENT__ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE:
				setElementWithInternalStructureShape((ElementWithInternalStructureShape)newValue);
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
			case UMLDIPackage.INTERNAL_STRUCTURE_COMPARTMENT__ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE:
				setElementWithInternalStructureShape((ElementWithInternalStructureShape)null);
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
			case UMLDIPackage.INTERNAL_STRUCTURE_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
				return isSetOwningUmlDiagramElement();
			case UMLDIPackage.INTERNAL_STRUCTURE_COMPARTMENT__ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE:
				return getElementWithInternalStructureShape() != null;
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
			|| eIsSet(UMLDIPackage.INTERNAL_STRUCTURE_COMPARTMENT__ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE);
	}

} //InternalStructureCompartmentImpl
