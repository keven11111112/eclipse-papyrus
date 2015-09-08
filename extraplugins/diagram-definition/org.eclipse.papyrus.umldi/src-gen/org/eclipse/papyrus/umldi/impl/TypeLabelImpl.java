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

import org.eclipse.papyrus.umldi.ExceptionHandlerEdge;
import org.eclipse.papyrus.umldi.InteractionUseShape;
import org.eclipse.papyrus.umldi.TypeLabel;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.TypeLabelImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.TypeLabelImpl#getInteractionUseShape <em>Interaction Use Shape</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.TypeLabelImpl#getExceptionHandlerEdge <em>Exception Handler Edge</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeLabelImpl extends UmlLabelImpl implements TypeLabel {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TypeLabelImpl() {
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
		return UMLDIPackage.Literals.TYPE_LABEL;
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
		InteractionUseShape interactionUseShape = getInteractionUseShape();
		if(interactionUseShape != null) {
			return interactionUseShape;
		}
		ExceptionHandlerEdge exceptionHandlerEdge = getExceptionHandlerEdge();
		if(exceptionHandlerEdge != null) {
			return exceptionHandlerEdge;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InteractionUseShape getInteractionUseShape() {
		if(eContainerFeatureID() != UMLDIPackage.TYPE_LABEL__INTERACTION_USE_SHAPE)
			return null;
		return (InteractionUseShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetInteractionUseShape(InteractionUseShape newInteractionUseShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInteractionUseShape, UMLDIPackage.TYPE_LABEL__INTERACTION_USE_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setInteractionUseShape(InteractionUseShape newInteractionUseShape) {
		if(newInteractionUseShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.TYPE_LABEL__INTERACTION_USE_SHAPE && newInteractionUseShape != null)) {
			if(EcoreUtil.isAncestor(this, newInteractionUseShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newInteractionUseShape != null)
				msgs = ((InternalEObject)newInteractionUseShape).eInverseAdd(this, UMLDIPackage.INTERACTION_USE_SHAPE__TYPE_LABEL, InteractionUseShape.class, msgs);
			msgs = basicSetInteractionUseShape(newInteractionUseShape, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.TYPE_LABEL__INTERACTION_USE_SHAPE, newInteractionUseShape, newInteractionUseShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExceptionHandlerEdge getExceptionHandlerEdge() {
		if(eContainerFeatureID() != UMLDIPackage.TYPE_LABEL__EXCEPTION_HANDLER_EDGE)
			return null;
		return (ExceptionHandlerEdge)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetExceptionHandlerEdge(ExceptionHandlerEdge newExceptionHandlerEdge, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newExceptionHandlerEdge, UMLDIPackage.TYPE_LABEL__EXCEPTION_HANDLER_EDGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setExceptionHandlerEdge(ExceptionHandlerEdge newExceptionHandlerEdge) {
		if(newExceptionHandlerEdge != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.TYPE_LABEL__EXCEPTION_HANDLER_EDGE && newExceptionHandlerEdge != null)) {
			if(EcoreUtil.isAncestor(this, newExceptionHandlerEdge))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newExceptionHandlerEdge != null)
				msgs = ((InternalEObject)newExceptionHandlerEdge).eInverseAdd(this, UMLDIPackage.EXCEPTION_HANDLER_EDGE__TYPE_LABEL, ExceptionHandlerEdge.class, msgs);
			msgs = basicSetExceptionHandlerEdge(newExceptionHandlerEdge, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.TYPE_LABEL__EXCEPTION_HANDLER_EDGE, newExceptionHandlerEdge, newExceptionHandlerEdge));
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
		case UMLDIPackage.TYPE_LABEL__INTERACTION_USE_SHAPE:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetInteractionUseShape((InteractionUseShape)otherEnd, msgs);
		case UMLDIPackage.TYPE_LABEL__EXCEPTION_HANDLER_EDGE:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetExceptionHandlerEdge((ExceptionHandlerEdge)otherEnd, msgs);
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
		case UMLDIPackage.TYPE_LABEL__INTERACTION_USE_SHAPE:
			return basicSetInteractionUseShape(null, msgs);
		case UMLDIPackage.TYPE_LABEL__EXCEPTION_HANDLER_EDGE:
			return basicSetExceptionHandlerEdge(null, msgs);
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
		case UMLDIPackage.TYPE_LABEL__INTERACTION_USE_SHAPE:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.INTERACTION_USE_SHAPE__TYPE_LABEL, InteractionUseShape.class, msgs);
		case UMLDIPackage.TYPE_LABEL__EXCEPTION_HANDLER_EDGE:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.EXCEPTION_HANDLER_EDGE__TYPE_LABEL, ExceptionHandlerEdge.class, msgs);
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
		case UMLDIPackage.TYPE_LABEL__INTERACTION_USE_SHAPE:
			return getInteractionUseShape();
		case UMLDIPackage.TYPE_LABEL__EXCEPTION_HANDLER_EDGE:
			return getExceptionHandlerEdge();
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
		case UMLDIPackage.TYPE_LABEL__INTERACTION_USE_SHAPE:
			setInteractionUseShape((InteractionUseShape)newValue);
			return;
		case UMLDIPackage.TYPE_LABEL__EXCEPTION_HANDLER_EDGE:
			setExceptionHandlerEdge((ExceptionHandlerEdge)newValue);
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
		case UMLDIPackage.TYPE_LABEL__INTERACTION_USE_SHAPE:
			setInteractionUseShape((InteractionUseShape)null);
			return;
		case UMLDIPackage.TYPE_LABEL__EXCEPTION_HANDLER_EDGE:
			setExceptionHandlerEdge((ExceptionHandlerEdge)null);
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
		case UMLDIPackage.TYPE_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			return isSetOwningUmlDiagramElement();
		case UMLDIPackage.TYPE_LABEL__INTERACTION_USE_SHAPE:
			return getInteractionUseShape() != null;
		case UMLDIPackage.TYPE_LABEL__EXCEPTION_HANDLER_EDGE:
			return getExceptionHandlerEdge() != null;
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
		return super.isSetOwningUmlDiagramElement() || eIsSet(UMLDIPackage.TYPE_LABEL__INTERACTION_USE_SHAPE) || eIsSet(UMLDIPackage.TYPE_LABEL__EXCEPTION_HANDLER_EDGE);
	}
} //TypeLabelImpl
