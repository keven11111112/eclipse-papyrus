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

import org.eclipse.papyrus.umldi.DeployedArtifactCompartment;
import org.eclipse.papyrus.umldi.DeploymentTargetShape;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deployed Artifact Compartment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.DeployedArtifactCompartmentImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.DeployedArtifactCompartmentImpl#getDeploymentTargetShape <em>Deployment Target Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeployedArtifactCompartmentImpl extends ClassifierCompartmentImpl implements DeployedArtifactCompartment {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DeployedArtifactCompartmentImpl() {
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
		return UMLDIPackage.Literals.DEPLOYED_ARTIFACT_COMPARTMENT;
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
		DeploymentTargetShape deploymentTargetShape = getDeploymentTargetShape();
		if(deploymentTargetShape != null) {
			return deploymentTargetShape;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeploymentTargetShape getDeploymentTargetShape() {
		if(eContainerFeatureID() != UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__DEPLOYMENT_TARGET_SHAPE)
			return null;
		return (DeploymentTargetShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetDeploymentTargetShape(DeploymentTargetShape newDeploymentTargetShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDeploymentTargetShape, UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__DEPLOYMENT_TARGET_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDeploymentTargetShape(DeploymentTargetShape newDeploymentTargetShape) {
		if(newDeploymentTargetShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__DEPLOYMENT_TARGET_SHAPE && newDeploymentTargetShape != null)) {
			if(EcoreUtil.isAncestor(this, newDeploymentTargetShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newDeploymentTargetShape != null)
				msgs = ((InternalEObject)newDeploymentTargetShape).eInverseAdd(this, UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT, DeploymentTargetShape.class, msgs);
			msgs = basicSetDeploymentTargetShape(newDeploymentTargetShape, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__DEPLOYMENT_TARGET_SHAPE, newDeploymentTargetShape, newDeploymentTargetShape));
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
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__DEPLOYMENT_TARGET_SHAPE:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetDeploymentTargetShape((DeploymentTargetShape)otherEnd, msgs);
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
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__DEPLOYMENT_TARGET_SHAPE:
			return basicSetDeploymentTargetShape(null, msgs);
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
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__DEPLOYMENT_TARGET_SHAPE:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT, DeploymentTargetShape.class, msgs);
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
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__DEPLOYMENT_TARGET_SHAPE:
			return getDeploymentTargetShape();
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
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__DEPLOYMENT_TARGET_SHAPE:
			setDeploymentTargetShape((DeploymentTargetShape)newValue);
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
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__DEPLOYMENT_TARGET_SHAPE:
			setDeploymentTargetShape((DeploymentTargetShape)null);
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
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			return isSetOwningUmlDiagramElement();
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__DEPLOYMENT_TARGET_SHAPE:
			return getDeploymentTargetShape() != null;
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
		return super.isSetOwningUmlDiagramElement() || eIsSet(UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__DEPLOYMENT_TARGET_SHAPE);
	}
} //DeployedArtifactCompartmentImpl
