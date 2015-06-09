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
import org.eclipse.papyrus.umldi.CombinedFragmentShape;
import org.eclipse.papyrus.umldi.InteractionFragmentWithSubfragmentsShape;
import org.eclipse.papyrus.umldi.SubfragmentCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Combined Fragment Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.CombinedFragmentShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.CombinedFragmentShapeImpl#getSubfragmentCompartment <em>Subfragment Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CombinedFragmentShapeImpl extends InteractionFragmentWithGatesShapeImpl implements CombinedFragmentShape {

	/**
	 * The cached value of the '{@link #getSubfragmentCompartment() <em>Subfragment Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSubfragmentCompartment()
	 * @generated
	 * @ordered
	 */
	protected SubfragmentCompartment subfragmentCompartment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CombinedFragmentShapeImpl() {
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
		return UMLDIPackage.Literals.COMBINED_FRAGMENT_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.COMBINED_FRAGMENT_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
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
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.COMBINED_FRAGMENT_SHAPE__STEREOTYPE_LABEL, UMLDIPackage.COMBINED_FRAGMENT_SHAPE__MAIN_LABEL, UMLDIPackage.COMBINED_FRAGMENT_SHAPE__STEREOTYPE_COMPARTMENT, UMLDIPackage.COMBINED_FRAGMENT_SHAPE__GATE_SHAPE, UMLDIPackage.COMBINED_FRAGMENT_SHAPE__SUBFRAGMENT_COMPARTMENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SubfragmentCompartment getSubfragmentCompartment() {
		return subfragmentCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetSubfragmentCompartment(SubfragmentCompartment newSubfragmentCompartment, NotificationChain msgs) {
		SubfragmentCompartment oldSubfragmentCompartment = subfragmentCompartment;
		subfragmentCompartment = newSubfragmentCompartment;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.COMBINED_FRAGMENT_SHAPE__SUBFRAGMENT_COMPARTMENT, oldSubfragmentCompartment, newSubfragmentCompartment);
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
	public void setSubfragmentCompartment(SubfragmentCompartment newSubfragmentCompartment) {
		if(newSubfragmentCompartment != subfragmentCompartment) {
			NotificationChain msgs = null;
			if(subfragmentCompartment != null)
				msgs = ((InternalEObject)subfragmentCompartment).eInverseRemove(this, UMLDIPackage.SUBFRAGMENT_COMPARTMENT__INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE, SubfragmentCompartment.class, msgs);
			if(newSubfragmentCompartment != null)
				msgs = ((InternalEObject)newSubfragmentCompartment).eInverseAdd(this, UMLDIPackage.SUBFRAGMENT_COMPARTMENT__INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE, SubfragmentCompartment.class, msgs);
			msgs = basicSetSubfragmentCompartment(newSubfragmentCompartment, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.COMBINED_FRAGMENT_SHAPE__SUBFRAGMENT_COMPARTMENT, newSubfragmentCompartment, newSubfragmentCompartment));
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
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__SUBFRAGMENT_COMPARTMENT:
			if(subfragmentCompartment != null)
				msgs = ((InternalEObject)subfragmentCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.COMBINED_FRAGMENT_SHAPE__SUBFRAGMENT_COMPARTMENT, null, msgs);
			return basicSetSubfragmentCompartment((SubfragmentCompartment)otherEnd, msgs);
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
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__SUBFRAGMENT_COMPARTMENT:
			return basicSetSubfragmentCompartment(null, msgs);
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
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__SUBFRAGMENT_COMPARTMENT:
			return getSubfragmentCompartment();
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
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__SUBFRAGMENT_COMPARTMENT:
			setSubfragmentCompartment((SubfragmentCompartment)newValue);
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
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__SUBFRAGMENT_COMPARTMENT:
			setSubfragmentCompartment((SubfragmentCompartment)null);
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
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__SUBFRAGMENT_COMPARTMENT:
			return subfragmentCompartment != null;
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
		if(baseClass == InteractionFragmentWithSubfragmentsShape.class) {
			switch(derivedFeatureID) {
			case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__SUBFRAGMENT_COMPARTMENT:
				return UMLDIPackage.INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE__SUBFRAGMENT_COMPARTMENT;
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
		if(baseClass == InteractionFragmentWithSubfragmentsShape.class) {
			switch(baseFeatureID) {
			case UMLDIPackage.INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE__SUBFRAGMENT_COMPARTMENT:
				return UMLDIPackage.COMBINED_FRAGMENT_SHAPE__SUBFRAGMENT_COMPARTMENT;
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
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.COMBINED_FRAGMENT_SHAPE__SUBFRAGMENT_COMPARTMENT);
	}
} //CombinedFragmentShapeImpl
