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

import org.eclipse.papyrus.umldi.ActionShape;
import org.eclipse.papyrus.umldi.ConstraintLabel;
import org.eclipse.papyrus.umldi.PinShape;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ActionShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ActionShapeImpl#getPinShape <em>Pin Shape</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ActionShapeImpl#getConditionLabel <em>Condition Label</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActionShapeImpl extends ActivityNodeShapeImpl implements ActionShape {

	/**
	 * The cached value of the '{@link #getPinShape() <em>Pin Shape</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPinShape()
	 * @generated
	 * @ordered
	 */
	protected EList<PinShape> pinShape;

	/**
	 * The cached value of the '{@link #getConditionLabel() <em>Condition Label</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getConditionLabel()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintLabel> conditionLabel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ActionShapeImpl() {
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
		return UMLDIPackage.Literals.ACTION_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.ACTION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
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
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.ACTION_SHAPE__STEREOTYPE_LABEL, UMLDIPackage.ACTION_SHAPE__MAIN_LABEL, UMLDIPackage.ACTION_SHAPE__STEREOTYPE_COMPARTMENT, UMLDIPackage.ACTION_SHAPE__PIN_SHAPE, UMLDIPackage.ACTION_SHAPE__CONDITION_LABEL };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<PinShape> getPinShape() {
		if(pinShape == null) {
			pinShape = new EObjectContainmentWithInverseEList<PinShape>(PinShape.class, this, UMLDIPackage.ACTION_SHAPE__PIN_SHAPE, UMLDIPackage.PIN_SHAPE__ACTION_SHAPE);
		}
		return pinShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ConstraintLabel> getConditionLabel() {
		if(conditionLabel == null) {
			conditionLabel = new EObjectContainmentWithInverseEList<ConstraintLabel>(ConstraintLabel.class, this, UMLDIPackage.ACTION_SHAPE__CONDITION_LABEL, UMLDIPackage.CONSTRAINT_LABEL__ACTION_SHAPE);
		}
		return conditionLabel;
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
		case UMLDIPackage.ACTION_SHAPE__PIN_SHAPE:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getPinShape()).basicAdd(otherEnd, msgs);
		case UMLDIPackage.ACTION_SHAPE__CONDITION_LABEL:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getConditionLabel()).basicAdd(otherEnd, msgs);
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
		case UMLDIPackage.ACTION_SHAPE__PIN_SHAPE:
			return ((InternalEList<?>)getPinShape()).basicRemove(otherEnd, msgs);
		case UMLDIPackage.ACTION_SHAPE__CONDITION_LABEL:
			return ((InternalEList<?>)getConditionLabel()).basicRemove(otherEnd, msgs);
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
		case UMLDIPackage.ACTION_SHAPE__PIN_SHAPE:
			return getPinShape();
		case UMLDIPackage.ACTION_SHAPE__CONDITION_LABEL:
			return getConditionLabel();
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
		case UMLDIPackage.ACTION_SHAPE__PIN_SHAPE:
			getPinShape().clear();
			getPinShape().addAll((Collection<? extends PinShape>)newValue);
			return;
		case UMLDIPackage.ACTION_SHAPE__CONDITION_LABEL:
			getConditionLabel().clear();
			getConditionLabel().addAll((Collection<? extends ConstraintLabel>)newValue);
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
		case UMLDIPackage.ACTION_SHAPE__PIN_SHAPE:
			getPinShape().clear();
			return;
		case UMLDIPackage.ACTION_SHAPE__CONDITION_LABEL:
			getConditionLabel().clear();
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
		case UMLDIPackage.ACTION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.ACTION_SHAPE__PIN_SHAPE:
			return pinShape != null && !pinShape.isEmpty();
		case UMLDIPackage.ACTION_SHAPE__CONDITION_LABEL:
			return conditionLabel != null && !conditionLabel.isEmpty();
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
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.ACTION_SHAPE__PIN_SHAPE) || eIsSet(UMLDIPackage.ACTION_SHAPE__CONDITION_LABEL);
	}
} //ActionShapeImpl
