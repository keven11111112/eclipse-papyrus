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

import org.eclipse.papyrus.umldi.InteractionFragmentWithSubfragmentsShape;
import org.eclipse.papyrus.umldi.SubfragmentCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subfragment Compartment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.SubfragmentCompartmentImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.SubfragmentCompartmentImpl#getInteractionFragmentWithSubfragmentsShape <em>Interaction Fragment With
 * Subfragments Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubfragmentCompartmentImpl extends DiagramCompartmentImpl implements SubfragmentCompartment {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SubfragmentCompartmentImpl() {
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
		return UMLDIPackage.Literals.SUBFRAGMENT_COMPARTMENT;
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
		InteractionFragmentWithSubfragmentsShape interactionFragmentWithSubfragmentsShape = getInteractionFragmentWithSubfragmentsShape();
		if(interactionFragmentWithSubfragmentsShape != null) {
			return interactionFragmentWithSubfragmentsShape;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InteractionFragmentWithSubfragmentsShape getInteractionFragmentWithSubfragmentsShape() {
		if(eContainerFeatureID() != UMLDIPackage.SUBFRAGMENT_COMPARTMENT__INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE)
			return null;
		return (InteractionFragmentWithSubfragmentsShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetInteractionFragmentWithSubfragmentsShape(InteractionFragmentWithSubfragmentsShape newInteractionFragmentWithSubfragmentsShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInteractionFragmentWithSubfragmentsShape, UMLDIPackage.SUBFRAGMENT_COMPARTMENT__INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setInteractionFragmentWithSubfragmentsShape(InteractionFragmentWithSubfragmentsShape newInteractionFragmentWithSubfragmentsShape) {
		if(newInteractionFragmentWithSubfragmentsShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.SUBFRAGMENT_COMPARTMENT__INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE && newInteractionFragmentWithSubfragmentsShape != null)) {
			if(EcoreUtil.isAncestor(this, newInteractionFragmentWithSubfragmentsShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newInteractionFragmentWithSubfragmentsShape != null)
				msgs = ((InternalEObject)newInteractionFragmentWithSubfragmentsShape).eInverseAdd(this, UMLDIPackage.INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE__SUBFRAGMENT_COMPARTMENT, InteractionFragmentWithSubfragmentsShape.class, msgs);
			msgs = basicSetInteractionFragmentWithSubfragmentsShape(newInteractionFragmentWithSubfragmentsShape, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.SUBFRAGMENT_COMPARTMENT__INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE, newInteractionFragmentWithSubfragmentsShape, newInteractionFragmentWithSubfragmentsShape));
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
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT__INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetInteractionFragmentWithSubfragmentsShape((InteractionFragmentWithSubfragmentsShape)otherEnd, msgs);
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
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT__INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE:
			return basicSetInteractionFragmentWithSubfragmentsShape(null, msgs);
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
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT__INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE__SUBFRAGMENT_COMPARTMENT, InteractionFragmentWithSubfragmentsShape.class, msgs);
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
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT__INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE:
			return getInteractionFragmentWithSubfragmentsShape();
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
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT__INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE:
			setInteractionFragmentWithSubfragmentsShape((InteractionFragmentWithSubfragmentsShape)newValue);
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
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT__INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE:
			setInteractionFragmentWithSubfragmentsShape((InteractionFragmentWithSubfragmentsShape)null);
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
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			return isSetOwningUmlDiagramElement();
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT__INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE:
			return getInteractionFragmentWithSubfragmentsShape() != null;
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
		return super.isSetOwningUmlDiagramElement() || eIsSet(UMLDIPackage.SUBFRAGMENT_COMPARTMENT__INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE);
	}
} //SubfragmentCompartmentImpl
