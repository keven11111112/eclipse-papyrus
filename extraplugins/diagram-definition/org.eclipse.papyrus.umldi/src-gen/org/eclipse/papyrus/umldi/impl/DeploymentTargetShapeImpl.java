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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.umldi.DeployedArtifactCompartment;
import org.eclipse.papyrus.umldi.DeploymentTargetShape;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deployment Target Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.DeploymentTargetShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.DeploymentTargetShapeImpl#getDeployedArtifactCompartment <em>Deployed Artifact Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DeploymentTargetShapeImpl extends ElementShapeImpl implements DeploymentTargetShape {

	/**
	 * The cached value of the '{@link #getDeployedArtifactCompartment() <em>Deployed Artifact Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDeployedArtifactCompartment()
	 * @generated
	 * @ordered
	 */
	protected DeployedArtifactCompartment deployedArtifactCompartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DeploymentTargetShapeImpl() {
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
		return UMLDIPackage.Literals.DEPLOYMENT_TARGET_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOwnedUmlDiagramElement()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__STEREOTYPE_LABEL, UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__MAIN_LABEL, UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__STEREOTYPE_COMPARTMENT, UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeployedArtifactCompartment getDeployedArtifactCompartment() {
		return deployedArtifactCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetDeployedArtifactCompartment(DeployedArtifactCompartment newDeployedArtifactCompartment, NotificationChain msgs) {
		DeployedArtifactCompartment oldDeployedArtifactCompartment = deployedArtifactCompartment;
		deployedArtifactCompartment = newDeployedArtifactCompartment;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT, oldDeployedArtifactCompartment, newDeployedArtifactCompartment);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDeployedArtifactCompartment(DeployedArtifactCompartment newDeployedArtifactCompartment) {
		if(newDeployedArtifactCompartment != deployedArtifactCompartment) {
			NotificationChain msgs = null;
			if(deployedArtifactCompartment != null)
				msgs = ((InternalEObject)deployedArtifactCompartment).eInverseRemove(this, UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__DEPLOYMENT_TARGET_SHAPE, DeployedArtifactCompartment.class, msgs);
			if(newDeployedArtifactCompartment != null)
				msgs = ((InternalEObject)newDeployedArtifactCompartment).eInverseAdd(this, UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__DEPLOYMENT_TARGET_SHAPE, DeployedArtifactCompartment.class, msgs);
			msgs = basicSetDeployedArtifactCompartment(newDeployedArtifactCompartment, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT, newDeployedArtifactCompartment, newDeployedArtifactCompartment));
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
		case UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT:
			if(deployedArtifactCompartment != null)
				msgs = ((InternalEObject)deployedArtifactCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT, null, msgs);
			return basicSetDeployedArtifactCompartment((DeployedArtifactCompartment)otherEnd, msgs);
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
		case UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT:
			return basicSetDeployedArtifactCompartment(null, msgs);
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT:
			return getDeployedArtifactCompartment();
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
		case UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT:
			setDeployedArtifactCompartment((DeployedArtifactCompartment)newValue);
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
		case UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT:
			setDeployedArtifactCompartment((DeployedArtifactCompartment)null);
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
		case UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT:
			return deployedArtifactCompartment != null;
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
	public boolean isSetOwnedUmlDiagramElement() {
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT);
	}
} //DeploymentTargetShapeImpl
