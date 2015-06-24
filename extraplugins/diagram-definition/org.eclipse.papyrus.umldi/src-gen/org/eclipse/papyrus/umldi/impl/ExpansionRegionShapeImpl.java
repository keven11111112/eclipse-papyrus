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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.umldi.ExpansionNodeShape;
import org.eclipse.papyrus.umldi.ExpansionRegionShape;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expansion Region Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ExpansionRegionShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ExpansionRegionShapeImpl#getExpansionNodeShape <em>Expansion Node Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpansionRegionShapeImpl extends StructuredActivityNodeShapeImpl implements ExpansionRegionShape {

	/**
	 * The cached value of the '{@link #getExpansionNodeShape() <em>Expansion Node Shape</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getExpansionNodeShape()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpansionNodeShape> expansionNodeShape;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ExpansionRegionShapeImpl() {
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
		return UMLDIPackage.Literals.EXPANSION_REGION_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.EXPANSION_REGION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
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
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.EXPANSION_REGION_SHAPE__STEREOTYPE_LABEL, UMLDIPackage.EXPANSION_REGION_SHAPE__MAIN_LABEL, UMLDIPackage.EXPANSION_REGION_SHAPE__STEREOTYPE_COMPARTMENT, UMLDIPackage.EXPANSION_REGION_SHAPE__PIN_SHAPE, UMLDIPackage.EXPANSION_REGION_SHAPE__CONDITION_LABEL, UMLDIPackage.EXPANSION_REGION_SHAPE__ACTIVITY_NODE_COMPARTMENT, UMLDIPackage.EXPANSION_REGION_SHAPE__EXPANSION_NODE_SHAPE };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ExpansionNodeShape> getExpansionNodeShape() {
		if(expansionNodeShape == null) {
			expansionNodeShape = new EObjectContainmentWithInverseEList<ExpansionNodeShape>(ExpansionNodeShape.class, this, UMLDIPackage.EXPANSION_REGION_SHAPE__EXPANSION_NODE_SHAPE, UMLDIPackage.EXPANSION_NODE_SHAPE__EXPANSION_REGION_SHAPE);
		}
		return expansionNodeShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case UMLDIPackage.EXPANSION_REGION_SHAPE__EXPANSION_NODE_SHAPE:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getExpansionNodeShape()).basicAdd(otherEnd, msgs);
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
		case UMLDIPackage.EXPANSION_REGION_SHAPE__EXPANSION_NODE_SHAPE:
			return ((InternalEList<?>)getExpansionNodeShape()).basicRemove(otherEnd, msgs);
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
		case UMLDIPackage.EXPANSION_REGION_SHAPE__EXPANSION_NODE_SHAPE:
			return getExpansionNodeShape();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case UMLDIPackage.EXPANSION_REGION_SHAPE__EXPANSION_NODE_SHAPE:
			getExpansionNodeShape().clear();
			getExpansionNodeShape().addAll((Collection<? extends ExpansionNodeShape>)newValue);
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
		case UMLDIPackage.EXPANSION_REGION_SHAPE__EXPANSION_NODE_SHAPE:
			getExpansionNodeShape().clear();
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
		case UMLDIPackage.EXPANSION_REGION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.EXPANSION_REGION_SHAPE__EXPANSION_NODE_SHAPE:
			return expansionNodeShape != null && !expansionNodeShape.isEmpty();
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
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.EXPANSION_REGION_SHAPE__EXPANSION_NODE_SHAPE);
	}
} //ExpansionRegionShapeImpl
