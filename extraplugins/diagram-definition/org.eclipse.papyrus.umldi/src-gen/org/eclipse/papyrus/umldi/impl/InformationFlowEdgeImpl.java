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

import org.eclipse.papyrus.umldi.ConveyedLabel;
import org.eclipse.papyrus.umldi.InformationFlowEdge;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Information Flow Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.InformationFlowEdgeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.InformationFlowEdgeImpl#getConveyedLabel <em>Conveyed Label</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InformationFlowEdgeImpl extends ElementEdgeImpl implements InformationFlowEdge {

	/**
	 * The cached value of the '{@link #getConveyedLabel() <em>Conveyed Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getConveyedLabel()
	 * @generated
	 * @ordered
	 */
	protected ConveyedLabel conveyedLabel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected InformationFlowEdgeImpl() {
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
		return UMLDIPackage.Literals.INFORMATION_FLOW_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.INFORMATION_FLOW_EDGE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
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
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.INFORMATION_FLOW_EDGE__STEREOTYPE_LABEL, UMLDIPackage.INFORMATION_FLOW_EDGE__MAIN_LABEL, UMLDIPackage.INFORMATION_FLOW_EDGE__CONVEYED_LABEL };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConveyedLabel getConveyedLabel() {
		return conveyedLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConveyedLabel(ConveyedLabel newConveyedLabel, NotificationChain msgs) {
		ConveyedLabel oldConveyedLabel = conveyedLabel;
		conveyedLabel = newConveyedLabel;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.INFORMATION_FLOW_EDGE__CONVEYED_LABEL, oldConveyedLabel, newConveyedLabel);
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
	public void setConveyedLabel(ConveyedLabel newConveyedLabel) {
		if(newConveyedLabel != conveyedLabel) {
			NotificationChain msgs = null;
			if(conveyedLabel != null)
				msgs = ((InternalEObject)conveyedLabel).eInverseRemove(this, UMLDIPackage.CONVEYED_LABEL__INFORMATION_FLOW_EDGE, ConveyedLabel.class, msgs);
			if(newConveyedLabel != null)
				msgs = ((InternalEObject)newConveyedLabel).eInverseAdd(this, UMLDIPackage.CONVEYED_LABEL__INFORMATION_FLOW_EDGE, ConveyedLabel.class, msgs);
			msgs = basicSetConveyedLabel(newConveyedLabel, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.INFORMATION_FLOW_EDGE__CONVEYED_LABEL, newConveyedLabel, newConveyedLabel));
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
		case UMLDIPackage.INFORMATION_FLOW_EDGE__CONVEYED_LABEL:
			if(conveyedLabel != null)
				msgs = ((InternalEObject)conveyedLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.INFORMATION_FLOW_EDGE__CONVEYED_LABEL, null, msgs);
			return basicSetConveyedLabel((ConveyedLabel)otherEnd, msgs);
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
		case UMLDIPackage.INFORMATION_FLOW_EDGE__CONVEYED_LABEL:
			return basicSetConveyedLabel(null, msgs);
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
		case UMLDIPackage.INFORMATION_FLOW_EDGE__CONVEYED_LABEL:
			return getConveyedLabel();
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
		case UMLDIPackage.INFORMATION_FLOW_EDGE__CONVEYED_LABEL:
			setConveyedLabel((ConveyedLabel)newValue);
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
		case UMLDIPackage.INFORMATION_FLOW_EDGE__CONVEYED_LABEL:
			setConveyedLabel((ConveyedLabel)null);
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
		case UMLDIPackage.INFORMATION_FLOW_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.INFORMATION_FLOW_EDGE__CONVEYED_LABEL:
			return conveyedLabel != null;
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
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.INFORMATION_FLOW_EDGE__CONVEYED_LABEL);
	}
} //InformationFlowEdgeImpl
