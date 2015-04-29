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

import org.eclipse.papyrus.umldi.ContentCompartment;
import org.eclipse.papyrus.umldi.StructuredActivityNodeShape;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structured Activity Node Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.StructuredActivityNodeShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.StructuredActivityNodeShapeImpl#getContentCompartment <em>Content Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StructuredActivityNodeShapeImpl extends ActionShapeImpl implements StructuredActivityNodeShape {
	/**
	 * The cached value of the '{@link #getContentCompartment() <em>Content Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentCompartment()
	 * @generated
	 * @ordered
	 */
	protected ContentCompartment contentCompartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructuredActivityNodeShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.STRUCTURED_ACTIVITY_NODE_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedUmlDiagramElement()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[] {UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__MAIN_LABEL, UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__PIN_SHAPE, UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__CONTENT_COMPARTMENT};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContentCompartment getContentCompartment() {
		return contentCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContentCompartment(ContentCompartment newContentCompartment, NotificationChain msgs) {
		ContentCompartment oldContentCompartment = contentCompartment;
		contentCompartment = newContentCompartment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__CONTENT_COMPARTMENT, oldContentCompartment, newContentCompartment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContentCompartment(ContentCompartment newContentCompartment) {
		if (newContentCompartment != contentCompartment) {
			NotificationChain msgs = null;
			if (contentCompartment != null)
				msgs = ((InternalEObject)contentCompartment).eInverseRemove(this, UMLDIPackage.CONTENT_COMPARTMENT__STRUCTURED_ACTIVITY_NODE_SHAPE, ContentCompartment.class, msgs);
			if (newContentCompartment != null)
				msgs = ((InternalEObject)newContentCompartment).eInverseAdd(this, UMLDIPackage.CONTENT_COMPARTMENT__STRUCTURED_ACTIVITY_NODE_SHAPE, ContentCompartment.class, msgs);
			msgs = basicSetContentCompartment(newContentCompartment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__CONTENT_COMPARTMENT, newContentCompartment, newContentCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__CONTENT_COMPARTMENT:
				if (contentCompartment != null)
					msgs = ((InternalEObject)contentCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__CONTENT_COMPARTMENT, null, msgs);
				return basicSetContentCompartment((ContentCompartment)otherEnd, msgs);
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
			case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__CONTENT_COMPARTMENT:
				return basicSetContentCompartment(null, msgs);
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
			case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__CONTENT_COMPARTMENT:
				return getContentCompartment();
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
			case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__CONTENT_COMPARTMENT:
				setContentCompartment((ContentCompartment)newValue);
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
			case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__CONTENT_COMPARTMENT:
				setContentCompartment((ContentCompartment)null);
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
			case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
				return isSetOwnedUmlDiagramElement();
			case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__CONTENT_COMPARTMENT:
				return contentCompartment != null;
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
			|| eIsSet(UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__CONTENT_COMPARTMENT);
	}

} //StructuredActivityNodeShapeImpl
