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

import org.eclipse.papyrus.umldi.ArtifactShape;
import org.eclipse.papyrus.umldi.NestedArtifactCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nested Artifact Compartment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.NestedArtifactCompartmentImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.NestedArtifactCompartmentImpl#getArtifactShape <em>Artifact Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NestedArtifactCompartmentImpl extends ClassifierCompartmentImpl implements NestedArtifactCompartment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NestedArtifactCompartmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.NESTED_ARTIFACT_COMPARTMENT;
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
		ArtifactShape artifactShape = getArtifactShape();			
		if (artifactShape != null) {
			return artifactShape;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArtifactShape getArtifactShape() {
		if (eContainerFeatureID() != UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__ARTIFACT_SHAPE) return null;
		return (ArtifactShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArtifactShape(ArtifactShape newArtifactShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newArtifactShape, UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__ARTIFACT_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArtifactShape(ArtifactShape newArtifactShape) {
		if (newArtifactShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__ARTIFACT_SHAPE && newArtifactShape != null)) {
			if (EcoreUtil.isAncestor(this, newArtifactShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newArtifactShape != null)
				msgs = ((InternalEObject)newArtifactShape).eInverseAdd(this, UMLDIPackage.ARTIFACT_SHAPE__NESTED_ARTIFACT_COMPARTMENT, ArtifactShape.class, msgs);
			msgs = basicSetArtifactShape(newArtifactShape, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__ARTIFACT_SHAPE, newArtifactShape, newArtifactShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__ARTIFACT_SHAPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetArtifactShape((ArtifactShape)otherEnd, msgs);
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
			case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__ARTIFACT_SHAPE:
				return basicSetArtifactShape(null, msgs);
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
			case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__ARTIFACT_SHAPE:
				return eInternalContainer().eInverseRemove(this, UMLDIPackage.ARTIFACT_SHAPE__NESTED_ARTIFACT_COMPARTMENT, ArtifactShape.class, msgs);
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
			case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__ARTIFACT_SHAPE:
				return getArtifactShape();
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
			case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__ARTIFACT_SHAPE:
				setArtifactShape((ArtifactShape)newValue);
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
			case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__ARTIFACT_SHAPE:
				setArtifactShape((ArtifactShape)null);
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
			case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
				return isSetOwningUmlDiagramElement();
			case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__ARTIFACT_SHAPE:
				return getArtifactShape() != null;
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
			|| eIsSet(UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__ARTIFACT_SHAPE);
	}

} //NestedArtifactCompartmentImpl
