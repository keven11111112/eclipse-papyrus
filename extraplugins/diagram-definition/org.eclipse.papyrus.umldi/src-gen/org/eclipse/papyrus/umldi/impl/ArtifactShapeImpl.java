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

import org.eclipse.papyrus.umldi.ArtifactShape;
import org.eclipse.papyrus.umldi.NestedArtifactCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Artifact Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ArtifactShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ArtifactShapeImpl#getNestedArtifactCompartment <em>Nested Artifact Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArtifactShapeImpl extends ClassifierWithOperationsShapeImpl implements ArtifactShape {
	/**
	 * The cached value of the '{@link #getNestedArtifactCompartment() <em>Nested Artifact Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedArtifactCompartment()
	 * @generated
	 * @ordered
	 */
	protected NestedArtifactCompartment nestedArtifactCompartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArtifactShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.ARTIFACT_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.ARTIFACT_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedUmlDiagramElement()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[] {UMLDIPackage.ARTIFACT_SHAPE__MAIN_LABEL, UMLDIPackage.ARTIFACT_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT, UMLDIPackage.ARTIFACT_SHAPE__OWNED_USE_CASE_COMPARTMENT, UMLDIPackage.ARTIFACT_SHAPE__USE_CASE_COMPARTMENT, UMLDIPackage.ARTIFACT_SHAPE__ATTRIBUTE_COMPARTMENT, UMLDIPackage.ARTIFACT_SHAPE__OPERATION_COMPARTMENT, UMLDIPackage.ARTIFACT_SHAPE__NESTED_ARTIFACT_COMPARTMENT};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedArtifactCompartment getNestedArtifactCompartment() {
		return nestedArtifactCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNestedArtifactCompartment(NestedArtifactCompartment newNestedArtifactCompartment, NotificationChain msgs) {
		NestedArtifactCompartment oldNestedArtifactCompartment = nestedArtifactCompartment;
		nestedArtifactCompartment = newNestedArtifactCompartment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.ARTIFACT_SHAPE__NESTED_ARTIFACT_COMPARTMENT, oldNestedArtifactCompartment, newNestedArtifactCompartment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNestedArtifactCompartment(NestedArtifactCompartment newNestedArtifactCompartment) {
		if (newNestedArtifactCompartment != nestedArtifactCompartment) {
			NotificationChain msgs = null;
			if (nestedArtifactCompartment != null)
				msgs = ((InternalEObject)nestedArtifactCompartment).eInverseRemove(this, UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__ARTIFACT_SHAPE, NestedArtifactCompartment.class, msgs);
			if (newNestedArtifactCompartment != null)
				msgs = ((InternalEObject)newNestedArtifactCompartment).eInverseAdd(this, UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__ARTIFACT_SHAPE, NestedArtifactCompartment.class, msgs);
			msgs = basicSetNestedArtifactCompartment(newNestedArtifactCompartment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.ARTIFACT_SHAPE__NESTED_ARTIFACT_COMPARTMENT, newNestedArtifactCompartment, newNestedArtifactCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.ARTIFACT_SHAPE__NESTED_ARTIFACT_COMPARTMENT:
				if (nestedArtifactCompartment != null)
					msgs = ((InternalEObject)nestedArtifactCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.ARTIFACT_SHAPE__NESTED_ARTIFACT_COMPARTMENT, null, msgs);
				return basicSetNestedArtifactCompartment((NestedArtifactCompartment)otherEnd, msgs);
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
			case UMLDIPackage.ARTIFACT_SHAPE__NESTED_ARTIFACT_COMPARTMENT:
				return basicSetNestedArtifactCompartment(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLDIPackage.ARTIFACT_SHAPE__NESTED_ARTIFACT_COMPARTMENT:
				return getNestedArtifactCompartment();
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
			case UMLDIPackage.ARTIFACT_SHAPE__NESTED_ARTIFACT_COMPARTMENT:
				setNestedArtifactCompartment((NestedArtifactCompartment)newValue);
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
			case UMLDIPackage.ARTIFACT_SHAPE__NESTED_ARTIFACT_COMPARTMENT:
				setNestedArtifactCompartment((NestedArtifactCompartment)null);
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
			case UMLDIPackage.ARTIFACT_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
				return isSetOwnedUmlDiagramElement();
			case UMLDIPackage.ARTIFACT_SHAPE__NESTED_ARTIFACT_COMPARTMENT:
				return nestedArtifactCompartment != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedUmlDiagramElement() {
		return super.isSetOwnedUmlDiagramElement()
			|| eIsSet(UMLDIPackage.ARTIFACT_SHAPE__NESTED_ARTIFACT_COMPARTMENT);
	}

} //ArtifactShapeImpl
