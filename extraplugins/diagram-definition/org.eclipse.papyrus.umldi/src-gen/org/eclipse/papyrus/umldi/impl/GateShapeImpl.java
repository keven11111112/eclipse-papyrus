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

import org.eclipse.papyrus.umldi.GateShape;
import org.eclipse.papyrus.umldi.InteractionFragmentWithGatesShape;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gate Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.GateShapeImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.GateShapeImpl#getInteractionFragmentWithGatesShape <em>Interaction Fragment With Gates Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GateShapeImpl extends ElementShapeImpl implements GateShape {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected GateShapeImpl() {
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
		return UMLDIPackage.Literals.GATE_SHAPE;
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
		InteractionFragmentWithGatesShape interactionFragmentWithGatesShape = getInteractionFragmentWithGatesShape();
		if(interactionFragmentWithGatesShape != null) {
			return interactionFragmentWithGatesShape;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InteractionFragmentWithGatesShape getInteractionFragmentWithGatesShape() {
		if(eContainerFeatureID() != UMLDIPackage.GATE_SHAPE__INTERACTION_FRAGMENT_WITH_GATES_SHAPE)
			return null;
		return (InteractionFragmentWithGatesShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetInteractionFragmentWithGatesShape(InteractionFragmentWithGatesShape newInteractionFragmentWithGatesShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInteractionFragmentWithGatesShape, UMLDIPackage.GATE_SHAPE__INTERACTION_FRAGMENT_WITH_GATES_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setInteractionFragmentWithGatesShape(InteractionFragmentWithGatesShape newInteractionFragmentWithGatesShape) {
		if(newInteractionFragmentWithGatesShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.GATE_SHAPE__INTERACTION_FRAGMENT_WITH_GATES_SHAPE && newInteractionFragmentWithGatesShape != null)) {
			if(EcoreUtil.isAncestor(this, newInteractionFragmentWithGatesShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newInteractionFragmentWithGatesShape != null)
				msgs = ((InternalEObject)newInteractionFragmentWithGatesShape).eInverseAdd(this, UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE__GATE_SHAPE, InteractionFragmentWithGatesShape.class, msgs);
			msgs = basicSetInteractionFragmentWithGatesShape(newInteractionFragmentWithGatesShape, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.GATE_SHAPE__INTERACTION_FRAGMENT_WITH_GATES_SHAPE, newInteractionFragmentWithGatesShape, newInteractionFragmentWithGatesShape));
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
		case UMLDIPackage.GATE_SHAPE__INTERACTION_FRAGMENT_WITH_GATES_SHAPE:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetInteractionFragmentWithGatesShape((InteractionFragmentWithGatesShape)otherEnd, msgs);
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
		case UMLDIPackage.GATE_SHAPE__INTERACTION_FRAGMENT_WITH_GATES_SHAPE:
			return basicSetInteractionFragmentWithGatesShape(null, msgs);
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
		case UMLDIPackage.GATE_SHAPE__INTERACTION_FRAGMENT_WITH_GATES_SHAPE:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE__GATE_SHAPE, InteractionFragmentWithGatesShape.class, msgs);
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
		case UMLDIPackage.GATE_SHAPE__INTERACTION_FRAGMENT_WITH_GATES_SHAPE:
			return getInteractionFragmentWithGatesShape();
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
		case UMLDIPackage.GATE_SHAPE__INTERACTION_FRAGMENT_WITH_GATES_SHAPE:
			setInteractionFragmentWithGatesShape((InteractionFragmentWithGatesShape)newValue);
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
		case UMLDIPackage.GATE_SHAPE__INTERACTION_FRAGMENT_WITH_GATES_SHAPE:
			setInteractionFragmentWithGatesShape((InteractionFragmentWithGatesShape)null);
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
		case UMLDIPackage.GATE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			return isSetOwningUmlDiagramElement();
		case UMLDIPackage.GATE_SHAPE__INTERACTION_FRAGMENT_WITH_GATES_SHAPE:
			return getInteractionFragmentWithGatesShape() != null;
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
		return super.isSetOwningUmlDiagramElement() || eIsSet(UMLDIPackage.GATE_SHAPE__INTERACTION_FRAGMENT_WITH_GATES_SHAPE);
	}
} //GateShapeImpl
