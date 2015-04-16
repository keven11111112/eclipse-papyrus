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

import org.eclipse.papyrus.umldi.ClassifierWithNestedClassifiersShape;
import org.eclipse.papyrus.umldi.NestedClassifierCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier With Nested Classifiers Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ClassifierWithNestedClassifiersShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ClassifierWithNestedClassifiersShapeImpl#getNestedClassifierCompartment <em>Nested Classifier Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ClassifierWithNestedClassifiersShapeImpl extends ClassifierWithReceptionsShapeImpl implements ClassifierWithNestedClassifiersShape {
	/**
	 * The cached value of the '{@link #getNestedClassifierCompartment() <em>Nested Classifier Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedClassifierCompartment()
	 * @generated
	 * @ordered
	 */
	protected NestedClassifierCompartment nestedClassifierCompartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassifierWithNestedClassifiersShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedUmlDiagramElement()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[] {UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__MAIN_LABEL, UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT, UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__OWNED_USE_CASE_COMPARTMENT, UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__USE_CASE_COMPARTMENT, UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__ATTRIBUTE_COMPARTMENT, UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__OPERATION_COMPARTMENT, UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__RECEPTION_COMPARTMENT, UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__NESTED_CLASSIFIER_COMPARTMENT};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedClassifierCompartment getNestedClassifierCompartment() {
		return nestedClassifierCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNestedClassifierCompartment(NestedClassifierCompartment newNestedClassifierCompartment, NotificationChain msgs) {
		NestedClassifierCompartment oldNestedClassifierCompartment = nestedClassifierCompartment;
		nestedClassifierCompartment = newNestedClassifierCompartment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__NESTED_CLASSIFIER_COMPARTMENT, oldNestedClassifierCompartment, newNestedClassifierCompartment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNestedClassifierCompartment(NestedClassifierCompartment newNestedClassifierCompartment) {
		if (newNestedClassifierCompartment != nestedClassifierCompartment) {
			NotificationChain msgs = null;
			if (nestedClassifierCompartment != null)
				msgs = ((InternalEObject)nestedClassifierCompartment).eInverseRemove(this, UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE, NestedClassifierCompartment.class, msgs);
			if (newNestedClassifierCompartment != null)
				msgs = ((InternalEObject)newNestedClassifierCompartment).eInverseAdd(this, UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE, NestedClassifierCompartment.class, msgs);
			msgs = basicSetNestedClassifierCompartment(newNestedClassifierCompartment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__NESTED_CLASSIFIER_COMPARTMENT, newNestedClassifierCompartment, newNestedClassifierCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
				if (nestedClassifierCompartment != null)
					msgs = ((InternalEObject)nestedClassifierCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__NESTED_CLASSIFIER_COMPARTMENT, null, msgs);
				return basicSetNestedClassifierCompartment((NestedClassifierCompartment)otherEnd, msgs);
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
			case UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
				return basicSetNestedClassifierCompartment(null, msgs);
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
			case UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
				return getNestedClassifierCompartment();
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
			case UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
				setNestedClassifierCompartment((NestedClassifierCompartment)newValue);
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
			case UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
				setNestedClassifierCompartment((NestedClassifierCompartment)null);
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
			case UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
				return isSetOwnedUmlDiagramElement();
			case UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
				return nestedClassifierCompartment != null;
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
			|| eIsSet(UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__NESTED_CLASSIFIER_COMPARTMENT);
	}

} //ClassifierWithNestedClassifiersShapeImpl
