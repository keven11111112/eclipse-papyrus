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

import org.eclipse.papyrus.umldi.GuardLabel;
import org.eclipse.papyrus.umldi.RelationshipWithGuardEdge;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guard Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.GuardLabelImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.GuardLabelImpl#getRelationshipWithGuardEdge <em>Relationship With Guard Edge</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GuardLabelImpl extends UmlLabelImpl implements GuardLabel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GuardLabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.GUARD_LABEL;
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
		RelationshipWithGuardEdge relationshipWithGuardEdge = getRelationshipWithGuardEdge();			
		if (relationshipWithGuardEdge != null) {
			return relationshipWithGuardEdge;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationshipWithGuardEdge getRelationshipWithGuardEdge() {
		if (eContainerFeatureID() != UMLDIPackage.GUARD_LABEL__RELATIONSHIP_WITH_GUARD_EDGE) return null;
		return (RelationshipWithGuardEdge)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRelationshipWithGuardEdge(RelationshipWithGuardEdge newRelationshipWithGuardEdge, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRelationshipWithGuardEdge, UMLDIPackage.GUARD_LABEL__RELATIONSHIP_WITH_GUARD_EDGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelationshipWithGuardEdge(RelationshipWithGuardEdge newRelationshipWithGuardEdge) {
		if (newRelationshipWithGuardEdge != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.GUARD_LABEL__RELATIONSHIP_WITH_GUARD_EDGE && newRelationshipWithGuardEdge != null)) {
			if (EcoreUtil.isAncestor(this, newRelationshipWithGuardEdge))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRelationshipWithGuardEdge != null)
				msgs = ((InternalEObject)newRelationshipWithGuardEdge).eInverseAdd(this, UMLDIPackage.RELATIONSHIP_WITH_GUARD_EDGE__GUARD_LABEL, RelationshipWithGuardEdge.class, msgs);
			msgs = basicSetRelationshipWithGuardEdge(newRelationshipWithGuardEdge, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.GUARD_LABEL__RELATIONSHIP_WITH_GUARD_EDGE, newRelationshipWithGuardEdge, newRelationshipWithGuardEdge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.GUARD_LABEL__RELATIONSHIP_WITH_GUARD_EDGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRelationshipWithGuardEdge((RelationshipWithGuardEdge)otherEnd, msgs);
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
			case UMLDIPackage.GUARD_LABEL__RELATIONSHIP_WITH_GUARD_EDGE:
				return basicSetRelationshipWithGuardEdge(null, msgs);
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
			case UMLDIPackage.GUARD_LABEL__RELATIONSHIP_WITH_GUARD_EDGE:
				return eInternalContainer().eInverseRemove(this, UMLDIPackage.RELATIONSHIP_WITH_GUARD_EDGE__GUARD_LABEL, RelationshipWithGuardEdge.class, msgs);
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
			case UMLDIPackage.GUARD_LABEL__RELATIONSHIP_WITH_GUARD_EDGE:
				return getRelationshipWithGuardEdge();
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
			case UMLDIPackage.GUARD_LABEL__RELATIONSHIP_WITH_GUARD_EDGE:
				setRelationshipWithGuardEdge((RelationshipWithGuardEdge)newValue);
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
			case UMLDIPackage.GUARD_LABEL__RELATIONSHIP_WITH_GUARD_EDGE:
				setRelationshipWithGuardEdge((RelationshipWithGuardEdge)null);
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
			case UMLDIPackage.GUARD_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
				return isSetOwningUmlDiagramElement();
			case UMLDIPackage.GUARD_LABEL__RELATIONSHIP_WITH_GUARD_EDGE:
				return getRelationshipWithGuardEdge() != null;
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
			|| eIsSet(UMLDIPackage.GUARD_LABEL__RELATIONSHIP_WITH_GUARD_EDGE);
	}

} //GuardLabelImpl
