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
import org.eclipse.papyrus.umldi.InteractionUseShape;
import org.eclipse.papyrus.umldi.TypeLabel;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interaction Use Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.InteractionUseShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.InteractionUseShapeImpl#getTypeLabel <em>Type Label</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InteractionUseShapeImpl extends InteractionFragmentWithGatesShapeImpl implements InteractionUseShape {

	/**
	 * The cached value of the '{@link #getTypeLabel() <em>Type Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTypeLabel()
	 * @generated
	 * @ordered
	 */
	protected TypeLabel typeLabel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected InteractionUseShapeImpl() {
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
		return UMLDIPackage.Literals.INTERACTION_USE_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.INTERACTION_USE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
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
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.INTERACTION_USE_SHAPE__STEREOTYPE_LABEL, UMLDIPackage.INTERACTION_USE_SHAPE__MAIN_LABEL, UMLDIPackage.INTERACTION_USE_SHAPE__STEREOTYPE_COMPARTMENT, UMLDIPackage.INTERACTION_USE_SHAPE__GATE_SHAPE, UMLDIPackage.INTERACTION_USE_SHAPE__TYPE_LABEL };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TypeLabel getTypeLabel() {
		return typeLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetTypeLabel(TypeLabel newTypeLabel, NotificationChain msgs) {
		TypeLabel oldTypeLabel = typeLabel;
		typeLabel = newTypeLabel;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.INTERACTION_USE_SHAPE__TYPE_LABEL, oldTypeLabel, newTypeLabel);
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
	public void setTypeLabel(TypeLabel newTypeLabel) {
		if(newTypeLabel != typeLabel) {
			NotificationChain msgs = null;
			if(typeLabel != null)
				msgs = ((InternalEObject)typeLabel).eInverseRemove(this, UMLDIPackage.TYPE_LABEL__INTERACTION_USE_SHAPE, TypeLabel.class, msgs);
			if(newTypeLabel != null)
				msgs = ((InternalEObject)newTypeLabel).eInverseAdd(this, UMLDIPackage.TYPE_LABEL__INTERACTION_USE_SHAPE, TypeLabel.class, msgs);
			msgs = basicSetTypeLabel(newTypeLabel, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.INTERACTION_USE_SHAPE__TYPE_LABEL, newTypeLabel, newTypeLabel));
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
		case UMLDIPackage.INTERACTION_USE_SHAPE__TYPE_LABEL:
			if(typeLabel != null)
				msgs = ((InternalEObject)typeLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.INTERACTION_USE_SHAPE__TYPE_LABEL, null, msgs);
			return basicSetTypeLabel((TypeLabel)otherEnd, msgs);
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
		case UMLDIPackage.INTERACTION_USE_SHAPE__TYPE_LABEL:
			return basicSetTypeLabel(null, msgs);
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
		case UMLDIPackage.INTERACTION_USE_SHAPE__TYPE_LABEL:
			return getTypeLabel();
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
		case UMLDIPackage.INTERACTION_USE_SHAPE__TYPE_LABEL:
			setTypeLabel((TypeLabel)newValue);
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
		case UMLDIPackage.INTERACTION_USE_SHAPE__TYPE_LABEL:
			setTypeLabel((TypeLabel)null);
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
		case UMLDIPackage.INTERACTION_USE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.INTERACTION_USE_SHAPE__TYPE_LABEL:
			return typeLabel != null;
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
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.INTERACTION_USE_SHAPE__TYPE_LABEL);
	}
} //InteractionUseShapeImpl
