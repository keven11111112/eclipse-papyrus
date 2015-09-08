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

import org.eclipse.papyrus.umldi.ClassifierShape;
import org.eclipse.papyrus.umldi.OwnedUseCaseCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;
import org.eclipse.papyrus.umldi.UseCaseCompartment;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ClassifierShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ClassifierShapeImpl#isUseClassifierNotation <em>Use Classifier Notation</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ClassifierShapeImpl#getOwnedUseCaseCompartment <em>Owned Use Case Compartment</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ClassifierShapeImpl#getUseCaseCompartment <em>Use Case Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ClassifierShapeImpl extends TemplateableElementShapeImpl implements ClassifierShape {

	/**
	 * The default value of the '{@link #isUseClassifierNotation() <em>Use Classifier Notation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isUseClassifierNotation()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_CLASSIFIER_NOTATION_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isUseClassifierNotation() <em>Use Classifier Notation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isUseClassifierNotation()
	 * @generated
	 * @ordered
	 */
	protected boolean useClassifierNotation = USE_CLASSIFIER_NOTATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedUseCaseCompartment() <em>Owned Use Case Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOwnedUseCaseCompartment()
	 * @generated
	 * @ordered
	 */
	protected OwnedUseCaseCompartment ownedUseCaseCompartment;

	/**
	 * The cached value of the '{@link #getUseCaseCompartment() <em>Use Case Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getUseCaseCompartment()
	 * @generated
	 * @ordered
	 */
	protected UseCaseCompartment useCaseCompartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ClassifierShapeImpl() {
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
		return UMLDIPackage.Literals.CLASSIFIER_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.CLASSIFIER_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
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
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.CLASSIFIER_SHAPE__STEREOTYPE_LABEL, UMLDIPackage.CLASSIFIER_SHAPE__MAIN_LABEL, UMLDIPackage.CLASSIFIER_SHAPE__STEREOTYPE_COMPARTMENT, UMLDIPackage.CLASSIFIER_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT, UMLDIPackage.CLASSIFIER_SHAPE__OWNED_USE_CASE_COMPARTMENT, UMLDIPackage.CLASSIFIER_SHAPE__USE_CASE_COMPARTMENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isUseClassifierNotation() {
		return useClassifierNotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setUseClassifierNotation(boolean newUseClassifierNotation) {
		boolean oldUseClassifierNotation = useClassifierNotation;
		useClassifierNotation = newUseClassifierNotation;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.CLASSIFIER_SHAPE__USE_CLASSIFIER_NOTATION, oldUseClassifierNotation, useClassifierNotation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OwnedUseCaseCompartment getOwnedUseCaseCompartment() {
		return ownedUseCaseCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetOwnedUseCaseCompartment(OwnedUseCaseCompartment newOwnedUseCaseCompartment, NotificationChain msgs) {
		OwnedUseCaseCompartment oldOwnedUseCaseCompartment = ownedUseCaseCompartment;
		ownedUseCaseCompartment = newOwnedUseCaseCompartment;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.CLASSIFIER_SHAPE__OWNED_USE_CASE_COMPARTMENT, oldOwnedUseCaseCompartment, newOwnedUseCaseCompartment);
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
	public void setOwnedUseCaseCompartment(OwnedUseCaseCompartment newOwnedUseCaseCompartment) {
		if(newOwnedUseCaseCompartment != ownedUseCaseCompartment) {
			NotificationChain msgs = null;
			if(ownedUseCaseCompartment != null)
				msgs = ((InternalEObject)ownedUseCaseCompartment).eInverseRemove(this, UMLDIPackage.OWNED_USE_CASE_COMPARTMENT__CLASSIFIER_SHAPE, OwnedUseCaseCompartment.class, msgs);
			if(newOwnedUseCaseCompartment != null)
				msgs = ((InternalEObject)newOwnedUseCaseCompartment).eInverseAdd(this, UMLDIPackage.OWNED_USE_CASE_COMPARTMENT__CLASSIFIER_SHAPE, OwnedUseCaseCompartment.class, msgs);
			msgs = basicSetOwnedUseCaseCompartment(newOwnedUseCaseCompartment, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.CLASSIFIER_SHAPE__OWNED_USE_CASE_COMPARTMENT, newOwnedUseCaseCompartment, newOwnedUseCaseCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UseCaseCompartment getUseCaseCompartment() {
		return useCaseCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetUseCaseCompartment(UseCaseCompartment newUseCaseCompartment, NotificationChain msgs) {
		UseCaseCompartment oldUseCaseCompartment = useCaseCompartment;
		useCaseCompartment = newUseCaseCompartment;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.CLASSIFIER_SHAPE__USE_CASE_COMPARTMENT, oldUseCaseCompartment, newUseCaseCompartment);
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
	public void setUseCaseCompartment(UseCaseCompartment newUseCaseCompartment) {
		if(newUseCaseCompartment != useCaseCompartment) {
			NotificationChain msgs = null;
			if(useCaseCompartment != null)
				msgs = ((InternalEObject)useCaseCompartment).eInverseRemove(this, UMLDIPackage.USE_CASE_COMPARTMENT__CLASSIFIER_SHAPE, UseCaseCompartment.class, msgs);
			if(newUseCaseCompartment != null)
				msgs = ((InternalEObject)newUseCaseCompartment).eInverseAdd(this, UMLDIPackage.USE_CASE_COMPARTMENT__CLASSIFIER_SHAPE, UseCaseCompartment.class, msgs);
			msgs = basicSetUseCaseCompartment(newUseCaseCompartment, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.CLASSIFIER_SHAPE__USE_CASE_COMPARTMENT, newUseCaseCompartment, newUseCaseCompartment));
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
		case UMLDIPackage.CLASSIFIER_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			if(ownedUseCaseCompartment != null)
				msgs = ((InternalEObject)ownedUseCaseCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.CLASSIFIER_SHAPE__OWNED_USE_CASE_COMPARTMENT, null, msgs);
			return basicSetOwnedUseCaseCompartment((OwnedUseCaseCompartment)otherEnd, msgs);
		case UMLDIPackage.CLASSIFIER_SHAPE__USE_CASE_COMPARTMENT:
			if(useCaseCompartment != null)
				msgs = ((InternalEObject)useCaseCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.CLASSIFIER_SHAPE__USE_CASE_COMPARTMENT, null, msgs);
			return basicSetUseCaseCompartment((UseCaseCompartment)otherEnd, msgs);
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
		case UMLDIPackage.CLASSIFIER_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			return basicSetOwnedUseCaseCompartment(null, msgs);
		case UMLDIPackage.CLASSIFIER_SHAPE__USE_CASE_COMPARTMENT:
			return basicSetUseCaseCompartment(null, msgs);
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
		case UMLDIPackage.CLASSIFIER_SHAPE__USE_CLASSIFIER_NOTATION:
			return isUseClassifierNotation();
		case UMLDIPackage.CLASSIFIER_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			return getOwnedUseCaseCompartment();
		case UMLDIPackage.CLASSIFIER_SHAPE__USE_CASE_COMPARTMENT:
			return getUseCaseCompartment();
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
		case UMLDIPackage.CLASSIFIER_SHAPE__USE_CLASSIFIER_NOTATION:
			setUseClassifierNotation((Boolean)newValue);
			return;
		case UMLDIPackage.CLASSIFIER_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			setOwnedUseCaseCompartment((OwnedUseCaseCompartment)newValue);
			return;
		case UMLDIPackage.CLASSIFIER_SHAPE__USE_CASE_COMPARTMENT:
			setUseCaseCompartment((UseCaseCompartment)newValue);
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
		case UMLDIPackage.CLASSIFIER_SHAPE__USE_CLASSIFIER_NOTATION:
			setUseClassifierNotation(USE_CLASSIFIER_NOTATION_EDEFAULT);
			return;
		case UMLDIPackage.CLASSIFIER_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			setOwnedUseCaseCompartment((OwnedUseCaseCompartment)null);
			return;
		case UMLDIPackage.CLASSIFIER_SHAPE__USE_CASE_COMPARTMENT:
			setUseCaseCompartment((UseCaseCompartment)null);
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
		case UMLDIPackage.CLASSIFIER_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.CLASSIFIER_SHAPE__USE_CLASSIFIER_NOTATION:
			return useClassifierNotation != USE_CLASSIFIER_NOTATION_EDEFAULT;
		case UMLDIPackage.CLASSIFIER_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			return ownedUseCaseCompartment != null;
		case UMLDIPackage.CLASSIFIER_SHAPE__USE_CASE_COMPARTMENT:
			return useCaseCompartment != null;
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
	public String toString() {
		if(eIsProxy())
			return super.toString();
		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (useClassifierNotation: ");
		result.append(useClassifierNotation);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isSetOwnedUmlDiagramElement() {
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.CLASSIFIER_SHAPE__OWNED_USE_CASE_COMPARTMENT) || eIsSet(UMLDIPackage.CLASSIFIER_SHAPE__USE_CASE_COMPARTMENT);
	}
} //ClassifierShapeImpl
