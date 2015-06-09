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

import org.eclipse.papyrus.umldi.ComponentShape;
import org.eclipse.papyrus.umldi.ElementWithPackagedElementsShape;
import org.eclipse.papyrus.umldi.PackagedElementCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ComponentShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ComponentShapeImpl#getPackagedElementCompartment <em>Packaged Element Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComponentShapeImpl extends ClassShapeImpl implements ComponentShape {

	/**
	 * The cached value of the '{@link #getPackagedElementCompartment() <em>Packaged Element Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPackagedElementCompartment()
	 * @generated
	 * @ordered
	 */
	protected PackagedElementCompartment packagedElementCompartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ComponentShapeImpl() {
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
		return UMLDIPackage.Literals.COMPONENT_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.COMPONENT_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
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
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.COMPONENT_SHAPE__STEREOTYPE_LABEL, UMLDIPackage.COMPONENT_SHAPE__MAIN_LABEL, UMLDIPackage.COMPONENT_SHAPE__STEREOTYPE_COMPARTMENT, UMLDIPackage.COMPONENT_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT, UMLDIPackage.COMPONENT_SHAPE__OWNED_USE_CASE_COMPARTMENT, UMLDIPackage.COMPONENT_SHAPE__USE_CASE_COMPARTMENT, UMLDIPackage.COMPONENT_SHAPE__ATTRIBUTE_COMPARTMENT, UMLDIPackage.COMPONENT_SHAPE__OPERATION_COMPARTMENT, UMLDIPackage.COMPONENT_SHAPE__RECEPTION_COMPARTMENT, UMLDIPackage.COMPONENT_SHAPE__NESTED_CLASSIFIER_COMPARTMENT, UMLDIPackage.COMPONENT_SHAPE__OWNED_BEHAVIOR_COMPARTMENT, UMLDIPackage.COMPONENT_SHAPE__STRUCTURE_COMPARTMENT, UMLDIPackage.COMPONENT_SHAPE__PORT_SHAPE, UMLDIPackage.COMPONENT_SHAPE__PACKAGED_ELEMENT_COMPARTMENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PackagedElementCompartment getPackagedElementCompartment() {
		return packagedElementCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetPackagedElementCompartment(PackagedElementCompartment newPackagedElementCompartment, NotificationChain msgs) {
		PackagedElementCompartment oldPackagedElementCompartment = packagedElementCompartment;
		packagedElementCompartment = newPackagedElementCompartment;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.COMPONENT_SHAPE__PACKAGED_ELEMENT_COMPARTMENT, oldPackagedElementCompartment, newPackagedElementCompartment);
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
	public void setPackagedElementCompartment(PackagedElementCompartment newPackagedElementCompartment) {
		if(newPackagedElementCompartment != packagedElementCompartment) {
			NotificationChain msgs = null;
			if(packagedElementCompartment != null)
				msgs = ((InternalEObject)packagedElementCompartment).eInverseRemove(this, UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE, PackagedElementCompartment.class, msgs);
			if(newPackagedElementCompartment != null)
				msgs = ((InternalEObject)newPackagedElementCompartment).eInverseAdd(this, UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE, PackagedElementCompartment.class, msgs);
			msgs = basicSetPackagedElementCompartment(newPackagedElementCompartment, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.COMPONENT_SHAPE__PACKAGED_ELEMENT_COMPARTMENT, newPackagedElementCompartment, newPackagedElementCompartment));
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
		case UMLDIPackage.COMPONENT_SHAPE__PACKAGED_ELEMENT_COMPARTMENT:
			if(packagedElementCompartment != null)
				msgs = ((InternalEObject)packagedElementCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.COMPONENT_SHAPE__PACKAGED_ELEMENT_COMPARTMENT, null, msgs);
			return basicSetPackagedElementCompartment((PackagedElementCompartment)otherEnd, msgs);
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
		case UMLDIPackage.COMPONENT_SHAPE__PACKAGED_ELEMENT_COMPARTMENT:
			return basicSetPackagedElementCompartment(null, msgs);
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
		case UMLDIPackage.COMPONENT_SHAPE__PACKAGED_ELEMENT_COMPARTMENT:
			return getPackagedElementCompartment();
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
		case UMLDIPackage.COMPONENT_SHAPE__PACKAGED_ELEMENT_COMPARTMENT:
			setPackagedElementCompartment((PackagedElementCompartment)newValue);
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
		case UMLDIPackage.COMPONENT_SHAPE__PACKAGED_ELEMENT_COMPARTMENT:
			setPackagedElementCompartment((PackagedElementCompartment)null);
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
		case UMLDIPackage.COMPONENT_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.COMPONENT_SHAPE__PACKAGED_ELEMENT_COMPARTMENT:
			return packagedElementCompartment != null;
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if(baseClass == ElementWithPackagedElementsShape.class) {
			switch(derivedFeatureID) {
			case UMLDIPackage.COMPONENT_SHAPE__PACKAGED_ELEMENT_COMPARTMENT:
				return UMLDIPackage.ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE__PACKAGED_ELEMENT_COMPARTMENT;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if(baseClass == ElementWithPackagedElementsShape.class) {
			switch(baseFeatureID) {
			case UMLDIPackage.ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE__PACKAGED_ELEMENT_COMPARTMENT:
				return UMLDIPackage.COMPONENT_SHAPE__PACKAGED_ELEMENT_COMPARTMENT;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isSetOwnedUmlDiagramElement() {
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.COMPONENT_SHAPE__PACKAGED_ELEMENT_COMPARTMENT);
	}
} //ComponentShapeImpl
