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

import org.eclipse.papyrus.umldi.ElementWithPackagedElementsShape;
import org.eclipse.papyrus.umldi.PackagedElementCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Packaged Element Compartment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.PackagedElementCompartmentImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.PackagedElementCompartmentImpl#getElementWithPackagedElementsShape <em>Element With Packaged Elements Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PackagedElementCompartmentImpl extends DiagramCompartmentImpl implements PackagedElementCompartment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackagedElementCompartmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.PACKAGED_ELEMENT_COMPARTMENT;
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
		ElementWithPackagedElementsShape elementWithPackagedElementsShape = getElementWithPackagedElementsShape();			
		if (elementWithPackagedElementsShape != null) {
			return elementWithPackagedElementsShape;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementWithPackagedElementsShape getElementWithPackagedElementsShape() {
		if (eContainerFeatureID() != UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE) return null;
		return (ElementWithPackagedElementsShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElementWithPackagedElementsShape(ElementWithPackagedElementsShape newElementWithPackagedElementsShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newElementWithPackagedElementsShape, UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementWithPackagedElementsShape(ElementWithPackagedElementsShape newElementWithPackagedElementsShape) {
		if (newElementWithPackagedElementsShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE && newElementWithPackagedElementsShape != null)) {
			if (EcoreUtil.isAncestor(this, newElementWithPackagedElementsShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newElementWithPackagedElementsShape != null)
				msgs = ((InternalEObject)newElementWithPackagedElementsShape).eInverseAdd(this, UMLDIPackage.ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE__PACKAGED_ELEMENT_COMPARTMENT, ElementWithPackagedElementsShape.class, msgs);
			msgs = basicSetElementWithPackagedElementsShape(newElementWithPackagedElementsShape, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE, newElementWithPackagedElementsShape, newElementWithPackagedElementsShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetElementWithPackagedElementsShape((ElementWithPackagedElementsShape)otherEnd, msgs);
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
			case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE:
				return basicSetElementWithPackagedElementsShape(null, msgs);
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
			case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE:
				return eInternalContainer().eInverseRemove(this, UMLDIPackage.ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE__PACKAGED_ELEMENT_COMPARTMENT, ElementWithPackagedElementsShape.class, msgs);
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
			case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE:
				return getElementWithPackagedElementsShape();
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
			case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE:
				setElementWithPackagedElementsShape((ElementWithPackagedElementsShape)newValue);
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
			case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE:
				setElementWithPackagedElementsShape((ElementWithPackagedElementsShape)null);
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
			case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
				return isSetOwningUmlDiagramElement();
			case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE:
				return getElementWithPackagedElementsShape() != null;
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
			|| eIsSet(UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE);
	}

} //PackagedElementCompartmentImpl
