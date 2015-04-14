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

import org.eclipse.papyrus.umldi.GuardLabel;
import org.eclipse.papyrus.umldi.RelationshipWithGuardEdge;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relationship With Guard Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.RelationshipWithGuardEdgeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.RelationshipWithGuardEdgeImpl#getGuardLabel <em>Guard Label</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RelationshipWithGuardEdgeImpl extends ElementEdgeImpl implements RelationshipWithGuardEdge {
	/**
	 * The cached value of the '{@link #getGuardLabel() <em>Guard Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuardLabel()
	 * @generated
	 * @ordered
	 */
	protected GuardLabel guardLabel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationshipWithGuardEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.RELATIONSHIP_WITH_GUARD_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.RELATIONSHIP_WITH_GUARD_EDGE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedUmlDiagramElement()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[] {UMLDIPackage.RELATIONSHIP_WITH_GUARD_EDGE__MAIN_LABEL, UMLDIPackage.RELATIONSHIP_WITH_GUARD_EDGE__GUARD_LABEL};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuardLabel getGuardLabel() {
		return guardLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGuardLabel(GuardLabel newGuardLabel, NotificationChain msgs) {
		GuardLabel oldGuardLabel = guardLabel;
		guardLabel = newGuardLabel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.RELATIONSHIP_WITH_GUARD_EDGE__GUARD_LABEL, oldGuardLabel, newGuardLabel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuardLabel(GuardLabel newGuardLabel) {
		if (newGuardLabel != guardLabel) {
			NotificationChain msgs = null;
			if (guardLabel != null)
				msgs = ((InternalEObject)guardLabel).eInverseRemove(this, UMLDIPackage.GUARD_LABEL__RELATIONSHIP_WITH_GUARD_EDGE, GuardLabel.class, msgs);
			if (newGuardLabel != null)
				msgs = ((InternalEObject)newGuardLabel).eInverseAdd(this, UMLDIPackage.GUARD_LABEL__RELATIONSHIP_WITH_GUARD_EDGE, GuardLabel.class, msgs);
			msgs = basicSetGuardLabel(newGuardLabel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.RELATIONSHIP_WITH_GUARD_EDGE__GUARD_LABEL, newGuardLabel, newGuardLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.RELATIONSHIP_WITH_GUARD_EDGE__GUARD_LABEL:
				if (guardLabel != null)
					msgs = ((InternalEObject)guardLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.RELATIONSHIP_WITH_GUARD_EDGE__GUARD_LABEL, null, msgs);
				return basicSetGuardLabel((GuardLabel)otherEnd, msgs);
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
			case UMLDIPackage.RELATIONSHIP_WITH_GUARD_EDGE__GUARD_LABEL:
				return basicSetGuardLabel(null, msgs);
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
			case UMLDIPackage.RELATIONSHIP_WITH_GUARD_EDGE__GUARD_LABEL:
				return getGuardLabel();
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
			case UMLDIPackage.RELATIONSHIP_WITH_GUARD_EDGE__GUARD_LABEL:
				setGuardLabel((GuardLabel)newValue);
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
			case UMLDIPackage.RELATIONSHIP_WITH_GUARD_EDGE__GUARD_LABEL:
				setGuardLabel((GuardLabel)null);
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
			case UMLDIPackage.RELATIONSHIP_WITH_GUARD_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
				return isSetOwnedUmlDiagramElement();
			case UMLDIPackage.RELATIONSHIP_WITH_GUARD_EDGE__GUARD_LABEL:
				return guardLabel != null;
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
			|| eIsSet(UMLDIPackage.RELATIONSHIP_WITH_GUARD_EDGE__GUARD_LABEL);
	}

} //RelationshipWithGuardEdgeImpl
