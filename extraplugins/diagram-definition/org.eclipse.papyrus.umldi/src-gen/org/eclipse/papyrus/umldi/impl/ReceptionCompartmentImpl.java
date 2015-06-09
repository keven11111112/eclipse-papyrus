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

import org.eclipse.papyrus.umldi.ClassifierWithReceptionsShape;
import org.eclipse.papyrus.umldi.ReceptionCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reception Compartment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ReceptionCompartmentImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ReceptionCompartmentImpl#getClassifierWithReceptionShape <em>Classifier With Reception Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReceptionCompartmentImpl extends ListCompartmentImpl implements ReceptionCompartment {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ReceptionCompartmentImpl() {
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
		return UMLDIPackage.Literals.RECEPTION_COMPARTMENT;
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
		ClassifierWithReceptionsShape classifierWithReceptionShape = getClassifierWithReceptionShape();
		if(classifierWithReceptionShape != null) {
			return classifierWithReceptionShape;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ClassifierWithReceptionsShape getClassifierWithReceptionShape() {
		if(eContainerFeatureID() != UMLDIPackage.RECEPTION_COMPARTMENT__CLASSIFIER_WITH_RECEPTION_SHAPE)
			return null;
		return (ClassifierWithReceptionsShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetClassifierWithReceptionShape(ClassifierWithReceptionsShape newClassifierWithReceptionShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newClassifierWithReceptionShape, UMLDIPackage.RECEPTION_COMPARTMENT__CLASSIFIER_WITH_RECEPTION_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setClassifierWithReceptionShape(ClassifierWithReceptionsShape newClassifierWithReceptionShape) {
		if(newClassifierWithReceptionShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.RECEPTION_COMPARTMENT__CLASSIFIER_WITH_RECEPTION_SHAPE && newClassifierWithReceptionShape != null)) {
			if(EcoreUtil.isAncestor(this, newClassifierWithReceptionShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newClassifierWithReceptionShape != null)
				msgs = ((InternalEObject)newClassifierWithReceptionShape).eInverseAdd(this, UMLDIPackage.CLASSIFIER_WITH_RECEPTIONS_SHAPE__RECEPTION_COMPARTMENT, ClassifierWithReceptionsShape.class, msgs);
			msgs = basicSetClassifierWithReceptionShape(newClassifierWithReceptionShape, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.RECEPTION_COMPARTMENT__CLASSIFIER_WITH_RECEPTION_SHAPE, newClassifierWithReceptionShape, newClassifierWithReceptionShape));
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
		case UMLDIPackage.RECEPTION_COMPARTMENT__CLASSIFIER_WITH_RECEPTION_SHAPE:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetClassifierWithReceptionShape((ClassifierWithReceptionsShape)otherEnd, msgs);
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
		case UMLDIPackage.RECEPTION_COMPARTMENT__CLASSIFIER_WITH_RECEPTION_SHAPE:
			return basicSetClassifierWithReceptionShape(null, msgs);
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
		case UMLDIPackage.RECEPTION_COMPARTMENT__CLASSIFIER_WITH_RECEPTION_SHAPE:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.CLASSIFIER_WITH_RECEPTIONS_SHAPE__RECEPTION_COMPARTMENT, ClassifierWithReceptionsShape.class, msgs);
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
		case UMLDIPackage.RECEPTION_COMPARTMENT__CLASSIFIER_WITH_RECEPTION_SHAPE:
			return getClassifierWithReceptionShape();
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
		case UMLDIPackage.RECEPTION_COMPARTMENT__CLASSIFIER_WITH_RECEPTION_SHAPE:
			setClassifierWithReceptionShape((ClassifierWithReceptionsShape)newValue);
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
		case UMLDIPackage.RECEPTION_COMPARTMENT__CLASSIFIER_WITH_RECEPTION_SHAPE:
			setClassifierWithReceptionShape((ClassifierWithReceptionsShape)null);
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
		case UMLDIPackage.RECEPTION_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			return isSetOwningUmlDiagramElement();
		case UMLDIPackage.RECEPTION_COMPARTMENT__CLASSIFIER_WITH_RECEPTION_SHAPE:
			return getClassifierWithReceptionShape() != null;
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
		return super.isSetOwningUmlDiagramElement() || eIsSet(UMLDIPackage.RECEPTION_COMPARTMENT__CLASSIFIER_WITH_RECEPTION_SHAPE);
	}
} //ReceptionCompartmentImpl
