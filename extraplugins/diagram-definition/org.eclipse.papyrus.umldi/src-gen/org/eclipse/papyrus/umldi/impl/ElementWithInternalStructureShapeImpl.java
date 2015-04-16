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

import org.eclipse.papyrus.umldi.ElementWithInternalStructureShape;
import org.eclipse.papyrus.umldi.InternalStructureCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element With Internal Structure Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ElementWithInternalStructureShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ElementWithInternalStructureShapeImpl#getInternalStructureCompartment <em>Internal Structure Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ElementWithInternalStructureShapeImpl extends ElementShapeImpl implements ElementWithInternalStructureShape {
	/**
	 * The cached value of the '{@link #getInternalStructureCompartment() <em>Internal Structure Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalStructureCompartment()
	 * @generated
	 * @ordered
	 */
	protected InternalStructureCompartment internalStructureCompartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementWithInternalStructureShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedUmlDiagramElement()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[] {UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__MAIN_LABEL, UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalStructureCompartment getInternalStructureCompartment() {
		return internalStructureCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInternalStructureCompartment(InternalStructureCompartment newInternalStructureCompartment, NotificationChain msgs) {
		InternalStructureCompartment oldInternalStructureCompartment = internalStructureCompartment;
		internalStructureCompartment = newInternalStructureCompartment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT, oldInternalStructureCompartment, newInternalStructureCompartment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalStructureCompartment(InternalStructureCompartment newInternalStructureCompartment) {
		if (newInternalStructureCompartment != internalStructureCompartment) {
			NotificationChain msgs = null;
			if (internalStructureCompartment != null)
				msgs = ((InternalEObject)internalStructureCompartment).eInverseRemove(this, UMLDIPackage.INTERNAL_STRUCTURE_COMPARTMENT__ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE, InternalStructureCompartment.class, msgs);
			if (newInternalStructureCompartment != null)
				msgs = ((InternalEObject)newInternalStructureCompartment).eInverseAdd(this, UMLDIPackage.INTERNAL_STRUCTURE_COMPARTMENT__ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE, InternalStructureCompartment.class, msgs);
			msgs = basicSetInternalStructureCompartment(newInternalStructureCompartment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT, newInternalStructureCompartment, newInternalStructureCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT:
				if (internalStructureCompartment != null)
					msgs = ((InternalEObject)internalStructureCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT, null, msgs);
				return basicSetInternalStructureCompartment((InternalStructureCompartment)otherEnd, msgs);
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
			case UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT:
				return basicSetInternalStructureCompartment(null, msgs);
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
			case UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT:
				return getInternalStructureCompartment();
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
			case UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT:
				setInternalStructureCompartment((InternalStructureCompartment)newValue);
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
			case UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT:
				setInternalStructureCompartment((InternalStructureCompartment)null);
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
			case UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
				return isSetOwnedUmlDiagramElement();
			case UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT:
				return internalStructureCompartment != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedUmlDiagramElement() {
		return super.isSetOwnedUmlDiagramElement()
			|| eIsSet(UMLDIPackage.ELEMENT_WITH_INTERNAL_STRUCTURE_SHAPE__INTERNAL_STRUCTURE_COMPARTMENT);
	}

} //ElementWithInternalStructureShapeImpl
