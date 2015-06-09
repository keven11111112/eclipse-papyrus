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
import org.eclipse.papyrus.umldi.StereotypeLabel;
import org.eclipse.papyrus.umldi.StereotypedDiagramElement;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotype Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.StereotypeLabelImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.StereotypeLabelImpl#getStereotypedDiagramElement <em>Stereotyped Diagram Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StereotypeLabelImpl extends UmlLabelImpl implements StereotypeLabel {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected StereotypeLabelImpl() {
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
		return UMLDIPackage.Literals.STEREOTYPE_LABEL;
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
		StereotypedDiagramElement stereotypedDiagramElement = getStereotypedDiagramElement();
		if(stereotypedDiagramElement != null) {
			return stereotypedDiagramElement;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StereotypedDiagramElement getStereotypedDiagramElement() {
		if(eContainerFeatureID() != UMLDIPackage.STEREOTYPE_LABEL__STEREOTYPED_DIAGRAM_ELEMENT)
			return null;
		return (StereotypedDiagramElement)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetStereotypedDiagramElement(StereotypedDiagramElement newStereotypedDiagramElement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newStereotypedDiagramElement, UMLDIPackage.STEREOTYPE_LABEL__STEREOTYPED_DIAGRAM_ELEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setStereotypedDiagramElement(StereotypedDiagramElement newStereotypedDiagramElement) {
		if(newStereotypedDiagramElement != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.STEREOTYPE_LABEL__STEREOTYPED_DIAGRAM_ELEMENT && newStereotypedDiagramElement != null)) {
			if(EcoreUtil.isAncestor(this, newStereotypedDiagramElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newStereotypedDiagramElement != null)
				msgs = ((InternalEObject)newStereotypedDiagramElement).eInverseAdd(this, UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__STEREOTYPE_LABEL, StereotypedDiagramElement.class, msgs);
			msgs = basicSetStereotypedDiagramElement(newStereotypedDiagramElement, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.STEREOTYPE_LABEL__STEREOTYPED_DIAGRAM_ELEMENT, newStereotypedDiagramElement, newStereotypedDiagramElement));
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
		case UMLDIPackage.STEREOTYPE_LABEL__STEREOTYPED_DIAGRAM_ELEMENT:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetStereotypedDiagramElement((StereotypedDiagramElement)otherEnd, msgs);
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
		case UMLDIPackage.STEREOTYPE_LABEL__STEREOTYPED_DIAGRAM_ELEMENT:
			return basicSetStereotypedDiagramElement(null, msgs);
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
		case UMLDIPackage.STEREOTYPE_LABEL__STEREOTYPED_DIAGRAM_ELEMENT:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__STEREOTYPE_LABEL, StereotypedDiagramElement.class, msgs);
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
		case UMLDIPackage.STEREOTYPE_LABEL__STEREOTYPED_DIAGRAM_ELEMENT:
			return getStereotypedDiagramElement();
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
		case UMLDIPackage.STEREOTYPE_LABEL__STEREOTYPED_DIAGRAM_ELEMENT:
			setStereotypedDiagramElement((StereotypedDiagramElement)newValue);
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
		case UMLDIPackage.STEREOTYPE_LABEL__STEREOTYPED_DIAGRAM_ELEMENT:
			setStereotypedDiagramElement((StereotypedDiagramElement)null);
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
		case UMLDIPackage.STEREOTYPE_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			return isSetOwningUmlDiagramElement();
		case UMLDIPackage.STEREOTYPE_LABEL__STEREOTYPED_DIAGRAM_ELEMENT:
			return getStereotypedDiagramElement() != null;
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
		return super.isSetOwningUmlDiagramElement() || eIsSet(UMLDIPackage.STEREOTYPE_LABEL__STEREOTYPED_DIAGRAM_ELEMENT);
	}
} //StereotypeLabelImpl
