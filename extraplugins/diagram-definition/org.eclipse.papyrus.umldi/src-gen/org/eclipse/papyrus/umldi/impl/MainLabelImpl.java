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
import org.eclipse.papyrus.umldi.MainLabel;
import org.eclipse.papyrus.umldi.TopUmlDiagramElement;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Main Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.MainLabelImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.MainLabelImpl#getTopUmlDiagramElement <em>Top Uml Diagram Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MainLabelImpl extends UmlLabelImpl implements MainLabel {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MainLabelImpl() {
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
		return UMLDIPackage.Literals.MAIN_LABEL;
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
		TopUmlDiagramElement topUmlDiagramElement = getTopUmlDiagramElement();
		if(topUmlDiagramElement != null) {
			return topUmlDiagramElement;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TopUmlDiagramElement getTopUmlDiagramElement() {
		if(eContainerFeatureID() != UMLDIPackage.MAIN_LABEL__TOP_UML_DIAGRAM_ELEMENT)
			return null;
		return (TopUmlDiagramElement)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetTopUmlDiagramElement(TopUmlDiagramElement newTopUmlDiagramElement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTopUmlDiagramElement, UMLDIPackage.MAIN_LABEL__TOP_UML_DIAGRAM_ELEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTopUmlDiagramElement(TopUmlDiagramElement newTopUmlDiagramElement) {
		if(newTopUmlDiagramElement != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.MAIN_LABEL__TOP_UML_DIAGRAM_ELEMENT && newTopUmlDiagramElement != null)) {
			if(EcoreUtil.isAncestor(this, newTopUmlDiagramElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newTopUmlDiagramElement != null)
				msgs = ((InternalEObject)newTopUmlDiagramElement).eInverseAdd(this, UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__MAIN_LABEL, TopUmlDiagramElement.class, msgs);
			msgs = basicSetTopUmlDiagramElement(newTopUmlDiagramElement, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.MAIN_LABEL__TOP_UML_DIAGRAM_ELEMENT, newTopUmlDiagramElement, newTopUmlDiagramElement));
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
		case UMLDIPackage.MAIN_LABEL__TOP_UML_DIAGRAM_ELEMENT:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetTopUmlDiagramElement((TopUmlDiagramElement)otherEnd, msgs);
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
		case UMLDIPackage.MAIN_LABEL__TOP_UML_DIAGRAM_ELEMENT:
			return basicSetTopUmlDiagramElement(null, msgs);
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
		case UMLDIPackage.MAIN_LABEL__TOP_UML_DIAGRAM_ELEMENT:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__MAIN_LABEL, TopUmlDiagramElement.class, msgs);
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
		case UMLDIPackage.MAIN_LABEL__TOP_UML_DIAGRAM_ELEMENT:
			return getTopUmlDiagramElement();
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
		case UMLDIPackage.MAIN_LABEL__TOP_UML_DIAGRAM_ELEMENT:
			setTopUmlDiagramElement((TopUmlDiagramElement)newValue);
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
		case UMLDIPackage.MAIN_LABEL__TOP_UML_DIAGRAM_ELEMENT:
			setTopUmlDiagramElement((TopUmlDiagramElement)null);
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
		case UMLDIPackage.MAIN_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			return isSetOwningUmlDiagramElement();
		case UMLDIPackage.MAIN_LABEL__TOP_UML_DIAGRAM_ELEMENT:
			return getTopUmlDiagramElement() != null;
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
		return super.isSetOwningUmlDiagramElement() || eIsSet(UMLDIPackage.MAIN_LABEL__TOP_UML_DIAGRAM_ELEMENT);
	}
} //MainLabelImpl
