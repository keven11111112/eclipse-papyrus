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
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;
import org.eclipse.papyrus.umldi.UmlEdge;
import org.eclipse.papyrus.umldi.UmlShape;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Main Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.MainLabelImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.MainLabelImpl#getUmlShape <em>Uml Shape</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.MainLabelImpl#getUmlEdge <em>Uml Edge</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MainLabelImpl extends UmlLabelImpl implements MainLabel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MainLabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.MAIN_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @generated
	 */
	@Override
	public UmlDiagramElement basicGetOwningUmlDiagramElement() {
		UmlShape umlShape = getUmlShape();			
		if (umlShape != null) {
			return umlShape;
		}
		UmlEdge umlEdge = getUmlEdge();			
		if (umlEdge != null) {
			return umlEdge;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlShape getUmlShape() {
		if (eContainerFeatureID() != UMLDIPackage.MAIN_LABEL__UML_SHAPE) return null;
		return (UmlShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUmlShape(UmlShape newUmlShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newUmlShape, UMLDIPackage.MAIN_LABEL__UML_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlShape(UmlShape newUmlShape) {
		if (newUmlShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.MAIN_LABEL__UML_SHAPE && newUmlShape != null)) {
			if (EcoreUtil.isAncestor(this, newUmlShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newUmlShape != null)
				msgs = ((InternalEObject)newUmlShape).eInverseAdd(this, UMLDIPackage.UML_SHAPE__MAIN_LABEL, UmlShape.class, msgs);
			msgs = basicSetUmlShape(newUmlShape, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.MAIN_LABEL__UML_SHAPE, newUmlShape, newUmlShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlEdge getUmlEdge() {
		if (eContainerFeatureID() != UMLDIPackage.MAIN_LABEL__UML_EDGE) return null;
		return (UmlEdge)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUmlEdge(UmlEdge newUmlEdge, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newUmlEdge, UMLDIPackage.MAIN_LABEL__UML_EDGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlEdge(UmlEdge newUmlEdge) {
		if (newUmlEdge != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.MAIN_LABEL__UML_EDGE && newUmlEdge != null)) {
			if (EcoreUtil.isAncestor(this, newUmlEdge))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newUmlEdge != null)
				msgs = ((InternalEObject)newUmlEdge).eInverseAdd(this, UMLDIPackage.UML_EDGE__MAIN_LABEL, UmlEdge.class, msgs);
			msgs = basicSetUmlEdge(newUmlEdge, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.MAIN_LABEL__UML_EDGE, newUmlEdge, newUmlEdge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.MAIN_LABEL__UML_SHAPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetUmlShape((UmlShape)otherEnd, msgs);
			case UMLDIPackage.MAIN_LABEL__UML_EDGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetUmlEdge((UmlEdge)otherEnd, msgs);
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
			case UMLDIPackage.MAIN_LABEL__UML_SHAPE:
				return basicSetUmlShape(null, msgs);
			case UMLDIPackage.MAIN_LABEL__UML_EDGE:
				return basicSetUmlEdge(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case UMLDIPackage.MAIN_LABEL__UML_SHAPE:
				return eInternalContainer().eInverseRemove(this, UMLDIPackage.UML_SHAPE__MAIN_LABEL, UmlShape.class, msgs);
			case UMLDIPackage.MAIN_LABEL__UML_EDGE:
				return eInternalContainer().eInverseRemove(this, UMLDIPackage.UML_EDGE__MAIN_LABEL, UmlEdge.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLDIPackage.MAIN_LABEL__UML_SHAPE:
				return getUmlShape();
			case UMLDIPackage.MAIN_LABEL__UML_EDGE:
				return getUmlEdge();
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
			case UMLDIPackage.MAIN_LABEL__UML_SHAPE:
				setUmlShape((UmlShape)newValue);
				return;
			case UMLDIPackage.MAIN_LABEL__UML_EDGE:
				setUmlEdge((UmlEdge)newValue);
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
			case UMLDIPackage.MAIN_LABEL__UML_SHAPE:
				setUmlShape((UmlShape)null);
				return;
			case UMLDIPackage.MAIN_LABEL__UML_EDGE:
				setUmlEdge((UmlEdge)null);
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
			case UMLDIPackage.MAIN_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
				return isSetOwningUmlDiagramElement();
			case UMLDIPackage.MAIN_LABEL__UML_SHAPE:
				return getUmlShape() != null;
			case UMLDIPackage.MAIN_LABEL__UML_EDGE:
				return getUmlEdge() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwningUmlDiagramElement() {
		return super.isSetOwningUmlDiagramElement()
			|| eIsSet(UMLDIPackage.MAIN_LABEL__UML_SHAPE)
			|| eIsSet(UMLDIPackage.MAIN_LABEL__UML_EDGE);
	}

} //MainLabelImpl
