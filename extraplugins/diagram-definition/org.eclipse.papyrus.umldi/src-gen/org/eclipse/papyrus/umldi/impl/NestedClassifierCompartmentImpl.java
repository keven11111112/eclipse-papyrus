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

import org.eclipse.papyrus.umldi.ClassifierWithNestedClassifiersShape;
import org.eclipse.papyrus.umldi.NestedClassifierCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nested Classifier Compartment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.NestedClassifierCompartmentImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.NestedClassifierCompartmentImpl#getClassifierWithNestedClassifiersShape <em>Classifier With Nested
 * Classifiers Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NestedClassifierCompartmentImpl extends ClassifierCompartmentImpl implements NestedClassifierCompartment {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected NestedClassifierCompartmentImpl() {
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
		return UMLDIPackage.Literals.NESTED_CLASSIFIER_COMPARTMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
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
	 * 
	 * @generated
	 */
	@Override
	public UmlDiagramElement basicGetOwningUmlDiagramElement() {
		ClassifierWithNestedClassifiersShape classifierWithNestedClassifiersShape = getClassifierWithNestedClassifiersShape();
		if(classifierWithNestedClassifiersShape != null) {
			return classifierWithNestedClassifiersShape;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ClassifierWithNestedClassifiersShape getClassifierWithNestedClassifiersShape() {
		if(eContainerFeatureID() != UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE)
			return null;
		return (ClassifierWithNestedClassifiersShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetClassifierWithNestedClassifiersShape(ClassifierWithNestedClassifiersShape newClassifierWithNestedClassifiersShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newClassifierWithNestedClassifiersShape, UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setClassifierWithNestedClassifiersShape(ClassifierWithNestedClassifiersShape newClassifierWithNestedClassifiersShape) {
		if(newClassifierWithNestedClassifiersShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE && newClassifierWithNestedClassifiersShape != null)) {
			if(EcoreUtil.isAncestor(this, newClassifierWithNestedClassifiersShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newClassifierWithNestedClassifiersShape != null)
				msgs = ((InternalEObject)newClassifierWithNestedClassifiersShape).eInverseAdd(this, UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__NESTED_CLASSIFIER_COMPARTMENT, ClassifierWithNestedClassifiersShape.class, msgs);
			msgs = basicSetClassifierWithNestedClassifiersShape(newClassifierWithNestedClassifiersShape, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE, newClassifierWithNestedClassifiersShape, newClassifierWithNestedClassifiersShape));
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
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetClassifierWithNestedClassifiersShape((ClassifierWithNestedClassifiersShape)otherEnd, msgs);
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
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE:
			return basicSetClassifierWithNestedClassifiersShape(null, msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch(eContainerFeatureID()) {
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__NESTED_CLASSIFIER_COMPARTMENT, ClassifierWithNestedClassifiersShape.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE:
			return getClassifierWithNestedClassifiersShape();
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
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE:
			setClassifierWithNestedClassifiersShape((ClassifierWithNestedClassifiersShape)newValue);
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
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE:
			setClassifierWithNestedClassifiersShape((ClassifierWithNestedClassifiersShape)null);
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
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			return isSetOwningUmlDiagramElement();
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE:
			return getClassifierWithNestedClassifiersShape() != null;
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
	public boolean isSetOwningUmlDiagramElement() {
		return super.isSetOwningUmlDiagramElement() || eIsSet(UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE);
	}
} //NestedClassifierCompartmentImpl
