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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.umldi.BaseStateShape;
import org.eclipse.papyrus.umldi.PseudostateShape;
import org.eclipse.papyrus.umldi.RegionCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base State Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.BaseStateShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.BaseStateShapeImpl#getConnectionPointShape <em>Connection Point Shape</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.BaseStateShapeImpl#getRegionCompartment <em>Region Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BaseStateShapeImpl extends ElementShapeImpl implements BaseStateShape {

	/**
	 * The cached value of the '{@link #getConnectionPointShape() <em>Connection Point Shape</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getConnectionPointShape()
	 * @generated
	 * @ordered
	 */
	protected EList<PseudostateShape> connectionPointShape;

	/**
	 * The cached value of the '{@link #getRegionCompartment() <em>Region Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRegionCompartment()
	 * @generated
	 * @ordered
	 */
	protected RegionCompartment regionCompartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BaseStateShapeImpl() {
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
		return UMLDIPackage.Literals.BASE_STATE_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.BASE_STATE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
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
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.BASE_STATE_SHAPE__STEREOTYPE_LABEL, UMLDIPackage.BASE_STATE_SHAPE__MAIN_LABEL, UMLDIPackage.BASE_STATE_SHAPE__STEREOTYPE_COMPARTMENT, UMLDIPackage.BASE_STATE_SHAPE__CONNECTION_POINT_SHAPE, UMLDIPackage.BASE_STATE_SHAPE__REGION_COMPARTMENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<PseudostateShape> getConnectionPointShape() {
		if(connectionPointShape == null) {
			connectionPointShape = new EObjectContainmentWithInverseEList<PseudostateShape>(PseudostateShape.class, this, UMLDIPackage.BASE_STATE_SHAPE__CONNECTION_POINT_SHAPE, UMLDIPackage.PSEUDOSTATE_SHAPE__BASE_STATE_SHAPE);
		}
		return connectionPointShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RegionCompartment getRegionCompartment() {
		return regionCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetRegionCompartment(RegionCompartment newRegionCompartment, NotificationChain msgs) {
		RegionCompartment oldRegionCompartment = regionCompartment;
		regionCompartment = newRegionCompartment;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.BASE_STATE_SHAPE__REGION_COMPARTMENT, oldRegionCompartment, newRegionCompartment);
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
	public void setRegionCompartment(RegionCompartment newRegionCompartment) {
		if(newRegionCompartment != regionCompartment) {
			NotificationChain msgs = null;
			if(regionCompartment != null)
				msgs = ((InternalEObject)regionCompartment).eInverseRemove(this, UMLDIPackage.REGION_COMPARTMENT__BASE_STATE_SHAPE, RegionCompartment.class, msgs);
			if(newRegionCompartment != null)
				msgs = ((InternalEObject)newRegionCompartment).eInverseAdd(this, UMLDIPackage.REGION_COMPARTMENT__BASE_STATE_SHAPE, RegionCompartment.class, msgs);
			msgs = basicSetRegionCompartment(newRegionCompartment, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.BASE_STATE_SHAPE__REGION_COMPARTMENT, newRegionCompartment, newRegionCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case UMLDIPackage.BASE_STATE_SHAPE__CONNECTION_POINT_SHAPE:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getConnectionPointShape()).basicAdd(otherEnd, msgs);
		case UMLDIPackage.BASE_STATE_SHAPE__REGION_COMPARTMENT:
			if(regionCompartment != null)
				msgs = ((InternalEObject)regionCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.BASE_STATE_SHAPE__REGION_COMPARTMENT, null, msgs);
			return basicSetRegionCompartment((RegionCompartment)otherEnd, msgs);
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
		case UMLDIPackage.BASE_STATE_SHAPE__CONNECTION_POINT_SHAPE:
			return ((InternalEList<?>)getConnectionPointShape()).basicRemove(otherEnd, msgs);
		case UMLDIPackage.BASE_STATE_SHAPE__REGION_COMPARTMENT:
			return basicSetRegionCompartment(null, msgs);
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
		case UMLDIPackage.BASE_STATE_SHAPE__CONNECTION_POINT_SHAPE:
			return getConnectionPointShape();
		case UMLDIPackage.BASE_STATE_SHAPE__REGION_COMPARTMENT:
			return getRegionCompartment();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case UMLDIPackage.BASE_STATE_SHAPE__CONNECTION_POINT_SHAPE:
			getConnectionPointShape().clear();
			getConnectionPointShape().addAll((Collection<? extends PseudostateShape>)newValue);
			return;
		case UMLDIPackage.BASE_STATE_SHAPE__REGION_COMPARTMENT:
			setRegionCompartment((RegionCompartment)newValue);
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
		case UMLDIPackage.BASE_STATE_SHAPE__CONNECTION_POINT_SHAPE:
			getConnectionPointShape().clear();
			return;
		case UMLDIPackage.BASE_STATE_SHAPE__REGION_COMPARTMENT:
			setRegionCompartment((RegionCompartment)null);
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
		case UMLDIPackage.BASE_STATE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.BASE_STATE_SHAPE__CONNECTION_POINT_SHAPE:
			return connectionPointShape != null && !connectionPointShape.isEmpty();
		case UMLDIPackage.BASE_STATE_SHAPE__REGION_COMPARTMENT:
			return regionCompartment != null;
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
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.BASE_STATE_SHAPE__CONNECTION_POINT_SHAPE) || eIsSet(UMLDIPackage.BASE_STATE_SHAPE__REGION_COMPARTMENT);
	}
} //BaseStateShapeImpl
