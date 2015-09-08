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

import org.eclipse.papyrus.umldi.StereotypeLabel;
import org.eclipse.papyrus.umldi.StereotypedDiagramElement;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotyped Diagram Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.StereotypedDiagramElementImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.StereotypedDiagramElementImpl#isShowStereotypeAttributes <em>Show Stereotype Attributes</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.StereotypedDiagramElementImpl#getStereotypeLabel <em>Stereotype Label</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class StereotypedDiagramElementImpl extends UmlDiagramElementImpl implements StereotypedDiagramElement {

	/**
	 * The default value of the '{@link #isShowStereotypeAttributes() <em>Show Stereotype Attributes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isShowStereotypeAttributes()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SHOW_STEREOTYPE_ATTRIBUTES_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isShowStereotypeAttributes() <em>Show Stereotype Attributes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isShowStereotypeAttributes()
	 * @generated
	 * @ordered
	 */
	protected boolean showStereotypeAttributes = SHOW_STEREOTYPE_ATTRIBUTES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStereotypeLabel() <em>Stereotype Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getStereotypeLabel()
	 * @generated
	 * @ordered
	 */
	protected StereotypeLabel stereotypeLabel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected StereotypedDiagramElementImpl() {
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
		return UMLDIPackage.Literals.STEREOTYPED_DIAGRAM_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
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
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__STEREOTYPE_LABEL };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isShowStereotypeAttributes() {
		return showStereotypeAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setShowStereotypeAttributes(boolean newShowStereotypeAttributes) {
		boolean oldShowStereotypeAttributes = showStereotypeAttributes;
		showStereotypeAttributes = newShowStereotypeAttributes;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__SHOW_STEREOTYPE_ATTRIBUTES, oldShowStereotypeAttributes, showStereotypeAttributes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StereotypeLabel getStereotypeLabel() {
		return stereotypeLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetStereotypeLabel(StereotypeLabel newStereotypeLabel, NotificationChain msgs) {
		StereotypeLabel oldStereotypeLabel = stereotypeLabel;
		stereotypeLabel = newStereotypeLabel;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__STEREOTYPE_LABEL, oldStereotypeLabel, newStereotypeLabel);
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
	public void setStereotypeLabel(StereotypeLabel newStereotypeLabel) {
		if(newStereotypeLabel != stereotypeLabel) {
			NotificationChain msgs = null;
			if(stereotypeLabel != null)
				msgs = ((InternalEObject)stereotypeLabel).eInverseRemove(this, UMLDIPackage.STEREOTYPE_LABEL__STEREOTYPED_DIAGRAM_ELEMENT, StereotypeLabel.class, msgs);
			if(newStereotypeLabel != null)
				msgs = ((InternalEObject)newStereotypeLabel).eInverseAdd(this, UMLDIPackage.STEREOTYPE_LABEL__STEREOTYPED_DIAGRAM_ELEMENT, StereotypeLabel.class, msgs);
			msgs = basicSetStereotypeLabel(newStereotypeLabel, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__STEREOTYPE_LABEL, newStereotypeLabel, newStereotypeLabel));
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
		case UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__STEREOTYPE_LABEL:
			if(stereotypeLabel != null)
				msgs = ((InternalEObject)stereotypeLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__STEREOTYPE_LABEL, null, msgs);
			return basicSetStereotypeLabel((StereotypeLabel)otherEnd, msgs);
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
		case UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__STEREOTYPE_LABEL:
			return basicSetStereotypeLabel(null, msgs);
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
		case UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__SHOW_STEREOTYPE_ATTRIBUTES:
			return isShowStereotypeAttributes();
		case UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__STEREOTYPE_LABEL:
			return getStereotypeLabel();
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
		case UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__SHOW_STEREOTYPE_ATTRIBUTES:
			setShowStereotypeAttributes((Boolean)newValue);
			return;
		case UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__STEREOTYPE_LABEL:
			setStereotypeLabel((StereotypeLabel)newValue);
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
		case UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__SHOW_STEREOTYPE_ATTRIBUTES:
			setShowStereotypeAttributes(SHOW_STEREOTYPE_ATTRIBUTES_EDEFAULT);
			return;
		case UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__STEREOTYPE_LABEL:
			setStereotypeLabel((StereotypeLabel)null);
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
		case UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__SHOW_STEREOTYPE_ATTRIBUTES:
			return showStereotypeAttributes != SHOW_STEREOTYPE_ATTRIBUTES_EDEFAULT;
		case UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__STEREOTYPE_LABEL:
			return stereotypeLabel != null;
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
	public String toString() {
		if(eIsProxy())
			return super.toString();
		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (showStereotypeAttributes: ");
		result.append(showStereotypeAttributes);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isSetOwnedUmlDiagramElement() {
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT__STEREOTYPE_LABEL);
	}
} //StereotypedDiagramElementImpl
