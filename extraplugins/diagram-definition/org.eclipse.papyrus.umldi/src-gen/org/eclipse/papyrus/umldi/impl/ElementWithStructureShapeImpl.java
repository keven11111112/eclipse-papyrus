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

import org.eclipse.papyrus.umldi.ElementWithStructureShape;
import org.eclipse.papyrus.umldi.StructureCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element With Structure Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ElementWithStructureShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ElementWithStructureShapeImpl#getStructureCompartment <em>Structure Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ElementWithStructureShapeImpl extends ElementShapeImpl implements ElementWithStructureShape {

	/**
	 * The cached value of the '{@link #getStructureCompartment() <em>Structure Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getStructureCompartment()
	 * @generated
	 * @ordered
	 */
	protected StructureCompartment structureCompartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ElementWithStructureShapeImpl() {
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
		return UMLDIPackage.Literals.ELEMENT_WITH_STRUCTURE_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOwnedUmlDiagramElement()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE__STEREOTYPE_LABEL, UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE__MAIN_LABEL, UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE__STEREOTYPE_COMPARTMENT, UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE__STRUCTURE_COMPARTMENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StructureCompartment getStructureCompartment() {
		return structureCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetStructureCompartment(StructureCompartment newStructureCompartment, NotificationChain msgs) {
		StructureCompartment oldStructureCompartment = structureCompartment;
		structureCompartment = newStructureCompartment;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE__STRUCTURE_COMPARTMENT, oldStructureCompartment, newStructureCompartment);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setStructureCompartment(StructureCompartment newStructureCompartment) {
		if(newStructureCompartment != structureCompartment) {
			NotificationChain msgs = null;
			if(structureCompartment != null)
				msgs = ((InternalEObject)structureCompartment).eInverseRemove(this, UMLDIPackage.STRUCTURE_COMPARTMENT__ELEMENT_WITH_STRUCTURE_SHAPE, StructureCompartment.class, msgs);
			if(newStructureCompartment != null)
				msgs = ((InternalEObject)newStructureCompartment).eInverseAdd(this, UMLDIPackage.STRUCTURE_COMPARTMENT__ELEMENT_WITH_STRUCTURE_SHAPE, StructureCompartment.class, msgs);
			msgs = basicSetStructureCompartment(newStructureCompartment, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE__STRUCTURE_COMPARTMENT, newStructureCompartment, newStructureCompartment));
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
		case UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE__STRUCTURE_COMPARTMENT:
			if(structureCompartment != null)
				msgs = ((InternalEObject)structureCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE__STRUCTURE_COMPARTMENT, null, msgs);
			return basicSetStructureCompartment((StructureCompartment)otherEnd, msgs);
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
		case UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE__STRUCTURE_COMPARTMENT:
			return basicSetStructureCompartment(null, msgs);
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE__STRUCTURE_COMPARTMENT:
			return getStructureCompartment();
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
		case UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE__STRUCTURE_COMPARTMENT:
			setStructureCompartment((StructureCompartment)newValue);
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
		case UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE__STRUCTURE_COMPARTMENT:
			setStructureCompartment((StructureCompartment)null);
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
		case UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE__STRUCTURE_COMPARTMENT:
			return structureCompartment != null;
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
	public boolean isSetOwnedUmlDiagramElement() {
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE__STRUCTURE_COMPARTMENT);
	}
} //ElementWithStructureShapeImpl
