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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.papyrus.dd.dc.Bounds;
import org.eclipse.papyrus.dd.di.DIPackage;
import org.eclipse.papyrus.dd.di.Shape;
import org.eclipse.papyrus.umldi.ListCompartment;
import org.eclipse.papyrus.umldi.ListItemLabel;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;
import org.eclipse.papyrus.umldi.UmlLabel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Item Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ListItemLabelImpl#getBounds <em>Bounds</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ListItemLabelImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ListItemLabelImpl#getListCompartment <em>List Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ListItemLabelImpl extends StereotypedDiagramElementImpl implements ListItemLabel {

	/**
	 * The cached value of the '{@link #getBounds() <em>Bounds</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBounds()
	 * @generated
	 * @ordered
	 */
	protected Bounds bounds;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ListItemLabelImpl() {
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
		return UMLDIPackage.Literals.LIST_ITEM_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Bounds getBounds() {
		return bounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetBounds(Bounds newBounds, NotificationChain msgs) {
		Bounds oldBounds = bounds;
		bounds = newBounds;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.LIST_ITEM_LABEL__BOUNDS, oldBounds, newBounds);
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
	public void setBounds(Bounds newBounds) {
		if(newBounds != bounds) {
			NotificationChain msgs = null;
			if(bounds != null)
				msgs = ((InternalEObject)bounds).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.LIST_ITEM_LABEL__BOUNDS, null, msgs);
			if(newBounds != null)
				msgs = ((InternalEObject)newBounds).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.LIST_ITEM_LABEL__BOUNDS, null, msgs);
			msgs = basicSetBounds(newBounds, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.LIST_ITEM_LABEL__BOUNDS, newBounds, newBounds));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public UmlDiagramElement getOwningUmlDiagramElement() {
		UmlDiagramElement owningUmlDiagramElement = basicGetOwningUmlDiagramElement();
		return owningUmlDiagramElement != null && owningUmlDiagramElement.eIsProxy() ? (UmlDiagramElement)eResolveProxy((InternalEObject)owningUmlDiagramElement) : owningUmlDiagramElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public UmlDiagramElement basicGetOwningUmlDiagramElement() {
		ListCompartment listCompartment = getListCompartment();
		if(listCompartment != null) {
			return listCompartment;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ListCompartment getListCompartment() {
		if(eContainerFeatureID() != UMLDIPackage.LIST_ITEM_LABEL__LIST_COMPARTMENT)
			return null;
		return (ListCompartment)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetListCompartment(ListCompartment newListCompartment, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newListCompartment, UMLDIPackage.LIST_ITEM_LABEL__LIST_COMPARTMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setListCompartment(ListCompartment newListCompartment) {
		if(newListCompartment != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.LIST_ITEM_LABEL__LIST_COMPARTMENT && newListCompartment != null)) {
			if(EcoreUtil.isAncestor(this, newListCompartment))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newListCompartment != null)
				msgs = ((InternalEObject)newListCompartment).eInverseAdd(this, UMLDIPackage.LIST_COMPARTMENT__LIST_ITEM_LABEL, ListCompartment.class, msgs);
			msgs = basicSetListCompartment(newListCompartment, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.LIST_ITEM_LABEL__LIST_COMPARTMENT, newListCompartment, newListCompartment));
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
		case UMLDIPackage.LIST_ITEM_LABEL__LIST_COMPARTMENT:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetListCompartment((ListCompartment)otherEnd, msgs);
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
		case UMLDIPackage.LIST_ITEM_LABEL__BOUNDS:
			return basicSetBounds(null, msgs);
		case UMLDIPackage.LIST_ITEM_LABEL__LIST_COMPARTMENT:
			return basicSetListCompartment(null, msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch(eContainerFeatureID()) {
		case UMLDIPackage.LIST_ITEM_LABEL__LIST_COMPARTMENT:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.LIST_COMPARTMENT__LIST_ITEM_LABEL, ListCompartment.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
		case UMLDIPackage.LIST_ITEM_LABEL__BOUNDS:
			return getBounds();
		case UMLDIPackage.LIST_ITEM_LABEL__LIST_COMPARTMENT:
			return getListCompartment();
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
		case UMLDIPackage.LIST_ITEM_LABEL__BOUNDS:
			setBounds((Bounds)newValue);
			return;
		case UMLDIPackage.LIST_ITEM_LABEL__LIST_COMPARTMENT:
			setListCompartment((ListCompartment)newValue);
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
		case UMLDIPackage.LIST_ITEM_LABEL__BOUNDS:
			setBounds((Bounds)null);
			return;
		case UMLDIPackage.LIST_ITEM_LABEL__LIST_COMPARTMENT:
			setListCompartment((ListCompartment)null);
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
		case UMLDIPackage.LIST_ITEM_LABEL__BOUNDS:
			return bounds != null;
		case UMLDIPackage.LIST_ITEM_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			return isSetOwningUmlDiagramElement();
		case UMLDIPackage.LIST_ITEM_LABEL__LIST_COMPARTMENT:
			return getListCompartment() != null;
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
		if(baseClass == Shape.class) {
			switch(derivedFeatureID) {
			case UMLDIPackage.LIST_ITEM_LABEL__BOUNDS:
				return DIPackage.SHAPE__BOUNDS;
			default:
				return -1;
			}
		}
		if(baseClass == UmlLabel.class) {
			switch(derivedFeatureID) {
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
		if(baseClass == Shape.class) {
			switch(baseFeatureID) {
			case DIPackage.SHAPE__BOUNDS:
				return UMLDIPackage.LIST_ITEM_LABEL__BOUNDS;
			default:
				return -1;
			}
		}
		if(baseClass == UmlLabel.class) {
			switch(baseFeatureID) {
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
	public boolean isSetOwningUmlDiagramElement() {
		return super.isSetOwningUmlDiagramElement() || eIsSet(UMLDIPackage.LIST_ITEM_LABEL__LIST_COMPARTMENT);
	}
} //ListItemLabelImpl
