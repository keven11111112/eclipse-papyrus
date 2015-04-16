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

import org.eclipse.papyrus.umldi.ActivityShape;
import org.eclipse.papyrus.umldi.ContentCompartment;
import org.eclipse.papyrus.umldi.StructuredActivityNodeShape;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Content Compartment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ContentCompartmentImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ContentCompartmentImpl#getStructuredActivityNodeShape <em>Structured Activity Node Shape</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ContentCompartmentImpl#getActivityShape <em>Activity Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContentCompartmentImpl extends DiagramCompartmentImpl implements ContentCompartment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContentCompartmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.CONTENT_COMPARTMENT;
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
		StructuredActivityNodeShape structuredActivityNodeShape = getStructuredActivityNodeShape();			
		if (structuredActivityNodeShape != null) {
			return structuredActivityNodeShape;
		}
		ActivityShape activityShape = getActivityShape();			
		if (activityShape != null) {
			return activityShape;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuredActivityNodeShape getStructuredActivityNodeShape() {
		if (eContainerFeatureID() != UMLDIPackage.CONTENT_COMPARTMENT__STRUCTURED_ACTIVITY_NODE_SHAPE) return null;
		return (StructuredActivityNodeShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStructuredActivityNodeShape(StructuredActivityNodeShape newStructuredActivityNodeShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newStructuredActivityNodeShape, UMLDIPackage.CONTENT_COMPARTMENT__STRUCTURED_ACTIVITY_NODE_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStructuredActivityNodeShape(StructuredActivityNodeShape newStructuredActivityNodeShape) {
		if (newStructuredActivityNodeShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.CONTENT_COMPARTMENT__STRUCTURED_ACTIVITY_NODE_SHAPE && newStructuredActivityNodeShape != null)) {
			if (EcoreUtil.isAncestor(this, newStructuredActivityNodeShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newStructuredActivityNodeShape != null)
				msgs = ((InternalEObject)newStructuredActivityNodeShape).eInverseAdd(this, UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__CONTENT_COMPARTMENT, StructuredActivityNodeShape.class, msgs);
			msgs = basicSetStructuredActivityNodeShape(newStructuredActivityNodeShape, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.CONTENT_COMPARTMENT__STRUCTURED_ACTIVITY_NODE_SHAPE, newStructuredActivityNodeShape, newStructuredActivityNodeShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityShape getActivityShape() {
		if (eContainerFeatureID() != UMLDIPackage.CONTENT_COMPARTMENT__ACTIVITY_SHAPE) return null;
		return (ActivityShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetActivityShape(ActivityShape newActivityShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newActivityShape, UMLDIPackage.CONTENT_COMPARTMENT__ACTIVITY_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivityShape(ActivityShape newActivityShape) {
		if (newActivityShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.CONTENT_COMPARTMENT__ACTIVITY_SHAPE && newActivityShape != null)) {
			if (EcoreUtil.isAncestor(this, newActivityShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newActivityShape != null)
				msgs = ((InternalEObject)newActivityShape).eInverseAdd(this, UMLDIPackage.ACTIVITY_SHAPE__CONTENT_COMPARTMENT, ActivityShape.class, msgs);
			msgs = basicSetActivityShape(newActivityShape, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.CONTENT_COMPARTMENT__ACTIVITY_SHAPE, newActivityShape, newActivityShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.CONTENT_COMPARTMENT__STRUCTURED_ACTIVITY_NODE_SHAPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetStructuredActivityNodeShape((StructuredActivityNodeShape)otherEnd, msgs);
			case UMLDIPackage.CONTENT_COMPARTMENT__ACTIVITY_SHAPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetActivityShape((ActivityShape)otherEnd, msgs);
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
			case UMLDIPackage.CONTENT_COMPARTMENT__STRUCTURED_ACTIVITY_NODE_SHAPE:
				return basicSetStructuredActivityNodeShape(null, msgs);
			case UMLDIPackage.CONTENT_COMPARTMENT__ACTIVITY_SHAPE:
				return basicSetActivityShape(null, msgs);
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
			case UMLDIPackage.CONTENT_COMPARTMENT__STRUCTURED_ACTIVITY_NODE_SHAPE:
				return eInternalContainer().eInverseRemove(this, UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__CONTENT_COMPARTMENT, StructuredActivityNodeShape.class, msgs);
			case UMLDIPackage.CONTENT_COMPARTMENT__ACTIVITY_SHAPE:
				return eInternalContainer().eInverseRemove(this, UMLDIPackage.ACTIVITY_SHAPE__CONTENT_COMPARTMENT, ActivityShape.class, msgs);
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
			case UMLDIPackage.CONTENT_COMPARTMENT__STRUCTURED_ACTIVITY_NODE_SHAPE:
				return getStructuredActivityNodeShape();
			case UMLDIPackage.CONTENT_COMPARTMENT__ACTIVITY_SHAPE:
				return getActivityShape();
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
			case UMLDIPackage.CONTENT_COMPARTMENT__STRUCTURED_ACTIVITY_NODE_SHAPE:
				setStructuredActivityNodeShape((StructuredActivityNodeShape)newValue);
				return;
			case UMLDIPackage.CONTENT_COMPARTMENT__ACTIVITY_SHAPE:
				setActivityShape((ActivityShape)newValue);
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
			case UMLDIPackage.CONTENT_COMPARTMENT__STRUCTURED_ACTIVITY_NODE_SHAPE:
				setStructuredActivityNodeShape((StructuredActivityNodeShape)null);
				return;
			case UMLDIPackage.CONTENT_COMPARTMENT__ACTIVITY_SHAPE:
				setActivityShape((ActivityShape)null);
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
			case UMLDIPackage.CONTENT_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
				return isSetOwningUmlDiagramElement();
			case UMLDIPackage.CONTENT_COMPARTMENT__STRUCTURED_ACTIVITY_NODE_SHAPE:
				return getStructuredActivityNodeShape() != null;
			case UMLDIPackage.CONTENT_COMPARTMENT__ACTIVITY_SHAPE:
				return getActivityShape() != null;
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
			|| eIsSet(UMLDIPackage.CONTENT_COMPARTMENT__STRUCTURED_ACTIVITY_NODE_SHAPE)
			|| eIsSet(UMLDIPackage.CONTENT_COMPARTMENT__ACTIVITY_SHAPE);
	}

} //ContentCompartmentImpl
