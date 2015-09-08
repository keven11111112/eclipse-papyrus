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

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.papyrus.umldi.Placement;
import org.eclipse.papyrus.umldi.RegionShape;
import org.eclipse.papyrus.umldi.SubvertexCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Region Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.RegionShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.RegionShapeImpl#getPlacement <em>Placement</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.RegionShapeImpl#getSubvertexCompartment <em>Subvertex Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RegionShapeImpl extends ElementShapeImpl implements RegionShape {

	/**
	 * The cached value of the '{@link #getPlacement() <em>Placement</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPlacement()
	 * @generated
	 * @ordered
	 */
	protected EList<Placement> placement;

	/**
	 * The cached value of the '{@link #getSubvertexCompartment() <em>Subvertex Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSubvertexCompartment()
	 * @generated
	 * @ordered
	 */
	protected SubvertexCompartment subvertexCompartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RegionShapeImpl() {
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
		return UMLDIPackage.Literals.REGION_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.REGION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
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
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.REGION_SHAPE__STEREOTYPE_LABEL, UMLDIPackage.REGION_SHAPE__MAIN_LABEL, UMLDIPackage.REGION_SHAPE__STEREOTYPE_COMPARTMENT, UMLDIPackage.REGION_SHAPE__SUBVERTEX_COMPARTMENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Placement> getPlacement() {
		if(placement == null) {
			placement = new EDataTypeEList<Placement>(Placement.class, this, UMLDIPackage.REGION_SHAPE__PLACEMENT);
		}
		return placement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SubvertexCompartment getSubvertexCompartment() {
		return subvertexCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetSubvertexCompartment(SubvertexCompartment newSubvertexCompartment, NotificationChain msgs) {
		SubvertexCompartment oldSubvertexCompartment = subvertexCompartment;
		subvertexCompartment = newSubvertexCompartment;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.REGION_SHAPE__SUBVERTEX_COMPARTMENT, oldSubvertexCompartment, newSubvertexCompartment);
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
	public void setSubvertexCompartment(SubvertexCompartment newSubvertexCompartment) {
		if(newSubvertexCompartment != subvertexCompartment) {
			NotificationChain msgs = null;
			if(subvertexCompartment != null)
				msgs = ((InternalEObject)subvertexCompartment).eInverseRemove(this, UMLDIPackage.SUBVERTEX_COMPARTMENT__REGION_SHAPE, SubvertexCompartment.class, msgs);
			if(newSubvertexCompartment != null)
				msgs = ((InternalEObject)newSubvertexCompartment).eInverseAdd(this, UMLDIPackage.SUBVERTEX_COMPARTMENT__REGION_SHAPE, SubvertexCompartment.class, msgs);
			msgs = basicSetSubvertexCompartment(newSubvertexCompartment, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.REGION_SHAPE__SUBVERTEX_COMPARTMENT, newSubvertexCompartment, newSubvertexCompartment));
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
		case UMLDIPackage.REGION_SHAPE__SUBVERTEX_COMPARTMENT:
			if(subvertexCompartment != null)
				msgs = ((InternalEObject)subvertexCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.REGION_SHAPE__SUBVERTEX_COMPARTMENT, null, msgs);
			return basicSetSubvertexCompartment((SubvertexCompartment)otherEnd, msgs);
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
		case UMLDIPackage.REGION_SHAPE__SUBVERTEX_COMPARTMENT:
			return basicSetSubvertexCompartment(null, msgs);
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
		case UMLDIPackage.REGION_SHAPE__PLACEMENT:
			return getPlacement();
		case UMLDIPackage.REGION_SHAPE__SUBVERTEX_COMPARTMENT:
			return getSubvertexCompartment();
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
		case UMLDIPackage.REGION_SHAPE__PLACEMENT:
			getPlacement().clear();
			getPlacement().addAll((Collection<? extends Placement>)newValue);
			return;
		case UMLDIPackage.REGION_SHAPE__SUBVERTEX_COMPARTMENT:
			setSubvertexCompartment((SubvertexCompartment)newValue);
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
		case UMLDIPackage.REGION_SHAPE__PLACEMENT:
			getPlacement().clear();
			return;
		case UMLDIPackage.REGION_SHAPE__SUBVERTEX_COMPARTMENT:
			setSubvertexCompartment((SubvertexCompartment)null);
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
		case UMLDIPackage.REGION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.REGION_SHAPE__PLACEMENT:
			return placement != null && !placement.isEmpty();
		case UMLDIPackage.REGION_SHAPE__SUBVERTEX_COMPARTMENT:
			return subvertexCompartment != null;
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
		result.append(" (placement: ");
		result.append(placement);
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
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.REGION_SHAPE__SUBVERTEX_COMPARTMENT);
	}
} //RegionShapeImpl
