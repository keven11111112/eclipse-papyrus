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
import org.eclipse.papyrus.umldi.NestedNodeCompartment;
import org.eclipse.papyrus.umldi.NodeShape;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.NodeShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.NodeShapeImpl#getDeployedArtifactCompartment <em>Deployed Artifact Compartment</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.NodeShapeImpl#getNestedNodeCompartment <em>Nested Node Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeShapeImpl extends ClassShapeImpl implements NodeShape {

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
	 * The cached value of the '{@link #getNestedNodeCompartment() <em>Nested Node Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getNestedNodeCompartment()
	 * @generated
	 * @ordered
	 */
	protected NestedNodeCompartment nestedNodeCompartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected NodeShapeImpl() {
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
		return UMLDIPackage.Literals.NODE_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.NODE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
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
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.NODE_SHAPE__STEREOTYPE_LABEL, UMLDIPackage.NODE_SHAPE__MAIN_LABEL, UMLDIPackage.NODE_SHAPE__STEREOTYPE_COMPARTMENT, UMLDIPackage.NODE_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT, UMLDIPackage.NODE_SHAPE__OWNED_USE_CASE_COMPARTMENT, UMLDIPackage.NODE_SHAPE__USE_CASE_COMPARTMENT, UMLDIPackage.NODE_SHAPE__ATTRIBUTE_COMPARTMENT, UMLDIPackage.NODE_SHAPE__OPERATION_COMPARTMENT, UMLDIPackage.NODE_SHAPE__RECEPTION_COMPARTMENT, UMLDIPackage.NODE_SHAPE__NESTED_CLASSIFIER_COMPARTMENT, UMLDIPackage.NODE_SHAPE__OWNED_BEHAVIOR_COMPARTMENT, UMLDIPackage.NODE_SHAPE__STRUCTURE_COMPARTMENT, UMLDIPackage.NODE_SHAPE__PORT_SHAPE, UMLDIPackage.NODE_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT, UMLDIPackage.NODE_SHAPE__NESTED_NODE_COMPARTMENT };

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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.NODE_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT, oldDeployedArtifactCompartment, newDeployedArtifactCompartment);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.NODE_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT, newDeployedArtifactCompartment, newDeployedArtifactCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NestedNodeCompartment getNestedNodeCompartment() {
		return nestedNodeCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetNestedNodeCompartment(NestedNodeCompartment newNestedNodeCompartment, NotificationChain msgs) {
		NestedNodeCompartment oldNestedNodeCompartment = nestedNodeCompartment;
		nestedNodeCompartment = newNestedNodeCompartment;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.NODE_SHAPE__NESTED_NODE_COMPARTMENT, oldNestedNodeCompartment, newNestedNodeCompartment);
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
	public void setNestedNodeCompartment(NestedNodeCompartment newNestedNodeCompartment) {
		if(newNestedNodeCompartment != nestedNodeCompartment) {
			NotificationChain msgs = null;
			if(nestedNodeCompartment != null)
				msgs = ((InternalEObject)nestedNodeCompartment).eInverseRemove(this, UMLDIPackage.NESTED_NODE_COMPARTMENT__NODE_SHAPE, NestedNodeCompartment.class, msgs);
			if(newNestedNodeCompartment != null)
				msgs = ((InternalEObject)newNestedNodeCompartment).eInverseAdd(this, UMLDIPackage.NESTED_NODE_COMPARTMENT__NODE_SHAPE, NestedNodeCompartment.class, msgs);
			msgs = basicSetNestedNodeCompartment(newNestedNodeCompartment, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.NODE_SHAPE__NESTED_NODE_COMPARTMENT, newNestedNodeCompartment, newNestedNodeCompartment));
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
		case UMLDIPackage.NODE_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT:
			if(deployedArtifactCompartment != null)
				msgs = ((InternalEObject)deployedArtifactCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.NODE_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT, null, msgs);
			return basicSetDeployedArtifactCompartment((DeployedArtifactCompartment)otherEnd, msgs);
		case UMLDIPackage.NODE_SHAPE__NESTED_NODE_COMPARTMENT:
			if(nestedNodeCompartment != null)
				msgs = ((InternalEObject)nestedNodeCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.NODE_SHAPE__NESTED_NODE_COMPARTMENT, null, msgs);
			return basicSetNestedNodeCompartment((NestedNodeCompartment)otherEnd, msgs);
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
		case UMLDIPackage.NODE_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT:
			return basicSetDeployedArtifactCompartment(null, msgs);
		case UMLDIPackage.NODE_SHAPE__NESTED_NODE_COMPARTMENT:
			return basicSetNestedNodeCompartment(null, msgs);
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
		case UMLDIPackage.NODE_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT:
			return getDeployedArtifactCompartment();
		case UMLDIPackage.NODE_SHAPE__NESTED_NODE_COMPARTMENT:
			return getNestedNodeCompartment();
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
		case UMLDIPackage.NODE_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT:
			setDeployedArtifactCompartment((DeployedArtifactCompartment)newValue);
			return;
		case UMLDIPackage.NODE_SHAPE__NESTED_NODE_COMPARTMENT:
			setNestedNodeCompartment((NestedNodeCompartment)newValue);
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
		case UMLDIPackage.NODE_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT:
			setDeployedArtifactCompartment((DeployedArtifactCompartment)null);
			return;
		case UMLDIPackage.NODE_SHAPE__NESTED_NODE_COMPARTMENT:
			setNestedNodeCompartment((NestedNodeCompartment)null);
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
		case UMLDIPackage.NODE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.NODE_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT:
			return deployedArtifactCompartment != null;
		case UMLDIPackage.NODE_SHAPE__NESTED_NODE_COMPARTMENT:
			return nestedNodeCompartment != null;
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if(baseClass == DeploymentTargetShape.class) {
			switch(derivedFeatureID) {
			case UMLDIPackage.NODE_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT:
				return UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if(baseClass == DeploymentTargetShape.class) {
			switch(baseFeatureID) {
			case UMLDIPackage.DEPLOYMENT_TARGET_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT:
				return UMLDIPackage.NODE_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isSetOwnedUmlDiagramElement() {
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.NODE_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT) || eIsSet(UMLDIPackage.NODE_SHAPE__NESTED_NODE_COMPARTMENT);
	}
} //NodeShapeImpl
