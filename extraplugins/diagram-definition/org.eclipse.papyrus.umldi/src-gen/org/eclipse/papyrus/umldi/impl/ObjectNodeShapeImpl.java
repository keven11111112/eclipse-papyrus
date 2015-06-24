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

import org.eclipse.papyrus.umldi.ConstraintLabel;
import org.eclipse.papyrus.umldi.ObjectNodeShape;
import org.eclipse.papyrus.umldi.SelectionLabel;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Node Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ObjectNodeShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ObjectNodeShapeImpl#getSelectionLabel <em>Selection Label</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ObjectNodeShapeImpl#getConstraintLabel <em>Constraint Label</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectNodeShapeImpl extends ActivityNodeShapeImpl implements ObjectNodeShape {

	/**
	 * The cached value of the '{@link #getSelectionLabel() <em>Selection Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSelectionLabel()
	 * @generated
	 * @ordered
	 */
	protected SelectionLabel selectionLabel;

	/**
	 * The cached value of the '{@link #getConstraintLabel() <em>Constraint Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getConstraintLabel()
	 * @generated
	 * @ordered
	 */
	protected ConstraintLabel constraintLabel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ObjectNodeShapeImpl() {
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
		return UMLDIPackage.Literals.OBJECT_NODE_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.OBJECT_NODE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
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
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.OBJECT_NODE_SHAPE__STEREOTYPE_LABEL, UMLDIPackage.OBJECT_NODE_SHAPE__MAIN_LABEL, UMLDIPackage.OBJECT_NODE_SHAPE__STEREOTYPE_COMPARTMENT, UMLDIPackage.OBJECT_NODE_SHAPE__SELECTION_LABEL, UMLDIPackage.OBJECT_NODE_SHAPE__CONSTRAINT_LABEL };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SelectionLabel getSelectionLabel() {
		return selectionLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetSelectionLabel(SelectionLabel newSelectionLabel, NotificationChain msgs) {
		SelectionLabel oldSelectionLabel = selectionLabel;
		selectionLabel = newSelectionLabel;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.OBJECT_NODE_SHAPE__SELECTION_LABEL, oldSelectionLabel, newSelectionLabel);
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
	public void setSelectionLabel(SelectionLabel newSelectionLabel) {
		if(newSelectionLabel != selectionLabel) {
			NotificationChain msgs = null;
			if(selectionLabel != null)
				msgs = ((InternalEObject)selectionLabel).eInverseRemove(this, UMLDIPackage.SELECTION_LABEL__OBJECT_NODE_SHAPE, SelectionLabel.class, msgs);
			if(newSelectionLabel != null)
				msgs = ((InternalEObject)newSelectionLabel).eInverseAdd(this, UMLDIPackage.SELECTION_LABEL__OBJECT_NODE_SHAPE, SelectionLabel.class, msgs);
			msgs = basicSetSelectionLabel(newSelectionLabel, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.OBJECT_NODE_SHAPE__SELECTION_LABEL, newSelectionLabel, newSelectionLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConstraintLabel getConstraintLabel() {
		return constraintLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintLabel(ConstraintLabel newConstraintLabel, NotificationChain msgs) {
		ConstraintLabel oldConstraintLabel = constraintLabel;
		constraintLabel = newConstraintLabel;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.OBJECT_NODE_SHAPE__CONSTRAINT_LABEL, oldConstraintLabel, newConstraintLabel);
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
	public void setConstraintLabel(ConstraintLabel newConstraintLabel) {
		if(newConstraintLabel != constraintLabel) {
			NotificationChain msgs = null;
			if(constraintLabel != null)
				msgs = ((InternalEObject)constraintLabel).eInverseRemove(this, UMLDIPackage.CONSTRAINT_LABEL__OBJECT_NODE_SHAPE, ConstraintLabel.class, msgs);
			if(newConstraintLabel != null)
				msgs = ((InternalEObject)newConstraintLabel).eInverseAdd(this, UMLDIPackage.CONSTRAINT_LABEL__OBJECT_NODE_SHAPE, ConstraintLabel.class, msgs);
			msgs = basicSetConstraintLabel(newConstraintLabel, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.OBJECT_NODE_SHAPE__CONSTRAINT_LABEL, newConstraintLabel, newConstraintLabel));
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
		case UMLDIPackage.OBJECT_NODE_SHAPE__SELECTION_LABEL:
			if(selectionLabel != null)
				msgs = ((InternalEObject)selectionLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.OBJECT_NODE_SHAPE__SELECTION_LABEL, null, msgs);
			return basicSetSelectionLabel((SelectionLabel)otherEnd, msgs);
		case UMLDIPackage.OBJECT_NODE_SHAPE__CONSTRAINT_LABEL:
			if(constraintLabel != null)
				msgs = ((InternalEObject)constraintLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.OBJECT_NODE_SHAPE__CONSTRAINT_LABEL, null, msgs);
			return basicSetConstraintLabel((ConstraintLabel)otherEnd, msgs);
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
		case UMLDIPackage.OBJECT_NODE_SHAPE__SELECTION_LABEL:
			return basicSetSelectionLabel(null, msgs);
		case UMLDIPackage.OBJECT_NODE_SHAPE__CONSTRAINT_LABEL:
			return basicSetConstraintLabel(null, msgs);
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
		case UMLDIPackage.OBJECT_NODE_SHAPE__SELECTION_LABEL:
			return getSelectionLabel();
		case UMLDIPackage.OBJECT_NODE_SHAPE__CONSTRAINT_LABEL:
			return getConstraintLabel();
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
		case UMLDIPackage.OBJECT_NODE_SHAPE__SELECTION_LABEL:
			setSelectionLabel((SelectionLabel)newValue);
			return;
		case UMLDIPackage.OBJECT_NODE_SHAPE__CONSTRAINT_LABEL:
			setConstraintLabel((ConstraintLabel)newValue);
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
		case UMLDIPackage.OBJECT_NODE_SHAPE__SELECTION_LABEL:
			setSelectionLabel((SelectionLabel)null);
			return;
		case UMLDIPackage.OBJECT_NODE_SHAPE__CONSTRAINT_LABEL:
			setConstraintLabel((ConstraintLabel)null);
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
		case UMLDIPackage.OBJECT_NODE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.OBJECT_NODE_SHAPE__SELECTION_LABEL:
			return selectionLabel != null;
		case UMLDIPackage.OBJECT_NODE_SHAPE__CONSTRAINT_LABEL:
			return constraintLabel != null;
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
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.OBJECT_NODE_SHAPE__SELECTION_LABEL) || eIsSet(UMLDIPackage.OBJECT_NODE_SHAPE__CONSTRAINT_LABEL);
	}
} //ObjectNodeShapeImpl
