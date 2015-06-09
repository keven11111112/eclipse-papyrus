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

import org.eclipse.papyrus.umldi.GateShape;
import org.eclipse.papyrus.umldi.InteractionFragmentWithGatesShape;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interaction Fragment With Gates Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.InteractionFragmentWithGatesShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.InteractionFragmentWithGatesShapeImpl#getGateShape <em>Gate Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class InteractionFragmentWithGatesShapeImpl extends InteractionFragmentShapeImpl implements InteractionFragmentWithGatesShape {

	/**
	 * The cached value of the '{@link #getGateShape() <em>Gate Shape</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGateShape()
	 * @generated
	 * @ordered
	 */
	protected EList<GateShape> gateShape;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected InteractionFragmentWithGatesShapeImpl() {
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
		return UMLDIPackage.Literals.INTERACTION_FRAGMENT_WITH_GATES_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
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
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE__STEREOTYPE_LABEL, UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE__MAIN_LABEL, UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE__STEREOTYPE_COMPARTMENT, UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE__GATE_SHAPE };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<GateShape> getGateShape() {
		if(gateShape == null) {
			gateShape = new EObjectContainmentWithInverseEList<GateShape>(GateShape.class, this, UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE__GATE_SHAPE, UMLDIPackage.GATE_SHAPE__INTERACTION_FRAGMENT_WITH_GATES_SHAPE);
		}
		return gateShape;
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
		case UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE__GATE_SHAPE:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getGateShape()).basicAdd(otherEnd, msgs);
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
		case UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE__GATE_SHAPE:
			return ((InternalEList<?>)getGateShape()).basicRemove(otherEnd, msgs);
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
		case UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE__GATE_SHAPE:
			return getGateShape();
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
		case UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE__GATE_SHAPE:
			getGateShape().clear();
			getGateShape().addAll((Collection<? extends GateShape>)newValue);
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
		case UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE__GATE_SHAPE:
			getGateShape().clear();
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
		case UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE__GATE_SHAPE:
			return gateShape != null && !gateShape.isEmpty();
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
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE__GATE_SHAPE);
	}
} //InteractionFragmentWithGatesShapeImpl
