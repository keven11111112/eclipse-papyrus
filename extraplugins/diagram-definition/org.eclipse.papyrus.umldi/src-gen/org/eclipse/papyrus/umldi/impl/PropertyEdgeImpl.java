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
import org.eclipse.papyrus.umldi.MultiplicityLabel;
import org.eclipse.papyrus.umldi.PropertyEdge;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.PropertyEdgeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.PropertyEdgeImpl#getConstraintLabel <em>Constraint Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.PropertyEdgeImpl#getMultiplicityLabel <em>Multiplicity Label</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyEdgeImpl extends ElementEdgeImpl implements PropertyEdge {
	/**
	 * The cached value of the '{@link #getConstraintLabel() <em>Constraint Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintLabel()
	 * @generated
	 * @ordered
	 */
	protected ConstraintLabel constraintLabel;

	/**
	 * The cached value of the '{@link #getMultiplicityLabel() <em>Multiplicity Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicityLabel()
	 * @generated
	 * @ordered
	 */
	protected MultiplicityLabel multiplicityLabel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.PROPERTY_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.PROPERTY_EDGE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedUmlDiagramElement()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[] {UMLDIPackage.PROPERTY_EDGE__MAIN_LABEL, UMLDIPackage.PROPERTY_EDGE__CONSTRAINT_LABEL, UMLDIPackage.PROPERTY_EDGE__MULTIPLICITY_LABEL};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintLabel getConstraintLabel() {
		return constraintLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraintLabel(ConstraintLabel newConstraintLabel, NotificationChain msgs) {
		ConstraintLabel oldConstraintLabel = constraintLabel;
		constraintLabel = newConstraintLabel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.PROPERTY_EDGE__CONSTRAINT_LABEL, oldConstraintLabel, newConstraintLabel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintLabel(ConstraintLabel newConstraintLabel) {
		if (newConstraintLabel != constraintLabel) {
			NotificationChain msgs = null;
			if (constraintLabel != null)
				msgs = ((InternalEObject)constraintLabel).eInverseRemove(this, UMLDIPackage.CONSTRAINT_LABEL__PROPERTY_EDGE, ConstraintLabel.class, msgs);
			if (newConstraintLabel != null)
				msgs = ((InternalEObject)newConstraintLabel).eInverseAdd(this, UMLDIPackage.CONSTRAINT_LABEL__PROPERTY_EDGE, ConstraintLabel.class, msgs);
			msgs = basicSetConstraintLabel(newConstraintLabel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.PROPERTY_EDGE__CONSTRAINT_LABEL, newConstraintLabel, newConstraintLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityLabel getMultiplicityLabel() {
		return multiplicityLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMultiplicityLabel(MultiplicityLabel newMultiplicityLabel, NotificationChain msgs) {
		MultiplicityLabel oldMultiplicityLabel = multiplicityLabel;
		multiplicityLabel = newMultiplicityLabel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.PROPERTY_EDGE__MULTIPLICITY_LABEL, oldMultiplicityLabel, newMultiplicityLabel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicityLabel(MultiplicityLabel newMultiplicityLabel) {
		if (newMultiplicityLabel != multiplicityLabel) {
			NotificationChain msgs = null;
			if (multiplicityLabel != null)
				msgs = ((InternalEObject)multiplicityLabel).eInverseRemove(this, UMLDIPackage.MULTIPLICITY_LABEL__PROPERTY_EDGE, MultiplicityLabel.class, msgs);
			if (newMultiplicityLabel != null)
				msgs = ((InternalEObject)newMultiplicityLabel).eInverseAdd(this, UMLDIPackage.MULTIPLICITY_LABEL__PROPERTY_EDGE, MultiplicityLabel.class, msgs);
			msgs = basicSetMultiplicityLabel(newMultiplicityLabel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.PROPERTY_EDGE__MULTIPLICITY_LABEL, newMultiplicityLabel, newMultiplicityLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.PROPERTY_EDGE__CONSTRAINT_LABEL:
				if (constraintLabel != null)
					msgs = ((InternalEObject)constraintLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.PROPERTY_EDGE__CONSTRAINT_LABEL, null, msgs);
				return basicSetConstraintLabel((ConstraintLabel)otherEnd, msgs);
			case UMLDIPackage.PROPERTY_EDGE__MULTIPLICITY_LABEL:
				if (multiplicityLabel != null)
					msgs = ((InternalEObject)multiplicityLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.PROPERTY_EDGE__MULTIPLICITY_LABEL, null, msgs);
				return basicSetMultiplicityLabel((MultiplicityLabel)otherEnd, msgs);
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
			case UMLDIPackage.PROPERTY_EDGE__CONSTRAINT_LABEL:
				return basicSetConstraintLabel(null, msgs);
			case UMLDIPackage.PROPERTY_EDGE__MULTIPLICITY_LABEL:
				return basicSetMultiplicityLabel(null, msgs);
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
			case UMLDIPackage.PROPERTY_EDGE__CONSTRAINT_LABEL:
				return getConstraintLabel();
			case UMLDIPackage.PROPERTY_EDGE__MULTIPLICITY_LABEL:
				return getMultiplicityLabel();
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
			case UMLDIPackage.PROPERTY_EDGE__CONSTRAINT_LABEL:
				setConstraintLabel((ConstraintLabel)newValue);
				return;
			case UMLDIPackage.PROPERTY_EDGE__MULTIPLICITY_LABEL:
				setMultiplicityLabel((MultiplicityLabel)newValue);
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
			case UMLDIPackage.PROPERTY_EDGE__CONSTRAINT_LABEL:
				setConstraintLabel((ConstraintLabel)null);
				return;
			case UMLDIPackage.PROPERTY_EDGE__MULTIPLICITY_LABEL:
				setMultiplicityLabel((MultiplicityLabel)null);
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
			case UMLDIPackage.PROPERTY_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
				return isSetOwnedUmlDiagramElement();
			case UMLDIPackage.PROPERTY_EDGE__CONSTRAINT_LABEL:
				return constraintLabel != null;
			case UMLDIPackage.PROPERTY_EDGE__MULTIPLICITY_LABEL:
				return multiplicityLabel != null;
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
			|| eIsSet(UMLDIPackage.PROPERTY_EDGE__CONSTRAINT_LABEL)
			|| eIsSet(UMLDIPackage.PROPERTY_EDGE__MULTIPLICITY_LABEL);
	}

} //PropertyEdgeImpl
