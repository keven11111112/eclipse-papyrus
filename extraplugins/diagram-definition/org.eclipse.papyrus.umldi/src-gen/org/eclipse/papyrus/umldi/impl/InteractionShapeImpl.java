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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.umldi.GateShape;
import org.eclipse.papyrus.umldi.InteractionFragmentShape;
import org.eclipse.papyrus.umldi.InteractionFragmentWithGatesShape;
import org.eclipse.papyrus.umldi.InteractionFragmentWithSubfragmentsShape;
import org.eclipse.papyrus.umldi.InteractionShape;
import org.eclipse.papyrus.umldi.LifelineShape;
import org.eclipse.papyrus.umldi.SubfragmentCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interaction Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.InteractionShapeImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.InteractionShapeImpl#getLifelineShape <em>Lifeline Shape</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.InteractionShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.InteractionShapeImpl#getGateShape <em>Gate Shape</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.InteractionShapeImpl#getSubfragmentCompartment <em>Subfragment Compartment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InteractionShapeImpl extends ClassShapeImpl implements InteractionShape {

	/**
	 * The cached value of the '{@link #getGateShape() <em>Gate Shape</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGateShape()
	 * @generated
	 * @ordered
	 */
	protected EList<GateShape> gateShape;

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
	protected InteractionShapeImpl() {
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
		return UMLDIPackage.Literals.INTERACTION_SHAPE;
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
		LifelineShape lifelineShape = getLifelineShape();
		if(lifelineShape != null) {
			return lifelineShape;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LifelineShape getLifelineShape() {
		if(eContainerFeatureID() != UMLDIPackage.INTERACTION_SHAPE__LIFELINE_SHAPE)
			return null;
		return (LifelineShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetLifelineShape(LifelineShape newLifelineShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newLifelineShape, UMLDIPackage.INTERACTION_SHAPE__LIFELINE_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLifelineShape(LifelineShape newLifelineShape) {
		if(newLifelineShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.INTERACTION_SHAPE__LIFELINE_SHAPE && newLifelineShape != null)) {
			if(EcoreUtil.isAncestor(this, newLifelineShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newLifelineShape != null)
				msgs = ((InternalEObject)newLifelineShape).eInverseAdd(this, UMLDIPackage.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE, LifelineShape.class, msgs);
			msgs = basicSetLifelineShape(newLifelineShape, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.INTERACTION_SHAPE__LIFELINE_SHAPE, newLifelineShape, newLifelineShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.INTERACTION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
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
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.INTERACTION_SHAPE__STEREOTYPE_LABEL, UMLDIPackage.INTERACTION_SHAPE__MAIN_LABEL, UMLDIPackage.INTERACTION_SHAPE__STEREOTYPE_COMPARTMENT, UMLDIPackage.INTERACTION_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT, UMLDIPackage.INTERACTION_SHAPE__OWNED_USE_CASE_COMPARTMENT, UMLDIPackage.INTERACTION_SHAPE__USE_CASE_COMPARTMENT, UMLDIPackage.INTERACTION_SHAPE__ATTRIBUTE_COMPARTMENT, UMLDIPackage.INTERACTION_SHAPE__OPERATION_COMPARTMENT, UMLDIPackage.INTERACTION_SHAPE__RECEPTION_COMPARTMENT, UMLDIPackage.INTERACTION_SHAPE__NESTED_CLASSIFIER_COMPARTMENT, UMLDIPackage.INTERACTION_SHAPE__OWNED_BEHAVIOR_COMPARTMENT, UMLDIPackage.INTERACTION_SHAPE__STRUCTURE_COMPARTMENT, UMLDIPackage.INTERACTION_SHAPE__PORT_SHAPE, UMLDIPackage.INTERACTION_SHAPE__GATE_SHAPE, UMLDIPackage.INTERACTION_SHAPE__SUBFRAGMENT_COMPARTMENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<GateShape> getGateShape() {
		if(gateShape == null) {
			gateShape = new EObjectContainmentWithInverseEList<GateShape>(GateShape.class, this, UMLDIPackage.INTERACTION_SHAPE__GATE_SHAPE, UMLDIPackage.GATE_SHAPE__INTERACTION_FRAGMENT_WITH_GATES_SHAPE);
		}
		return gateShape;
	}

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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.INTERACTION_SHAPE__SUBFRAGMENT_COMPARTMENT, oldSubfragmentCompartment, newSubfragmentCompartment);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.INTERACTION_SHAPE__SUBFRAGMENT_COMPARTMENT, newSubfragmentCompartment, newSubfragmentCompartment));
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
		case UMLDIPackage.INTERACTION_SHAPE__LIFELINE_SHAPE:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetLifelineShape((LifelineShape)otherEnd, msgs);
		case UMLDIPackage.INTERACTION_SHAPE__GATE_SHAPE:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getGateShape()).basicAdd(otherEnd, msgs);
		case UMLDIPackage.INTERACTION_SHAPE__SUBFRAGMENT_COMPARTMENT:
			if(subfragmentCompartment != null)
				msgs = ((InternalEObject)subfragmentCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.INTERACTION_SHAPE__SUBFRAGMENT_COMPARTMENT, null, msgs);
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
		case UMLDIPackage.INTERACTION_SHAPE__LIFELINE_SHAPE:
			return basicSetLifelineShape(null, msgs);
		case UMLDIPackage.INTERACTION_SHAPE__GATE_SHAPE:
			return ((InternalEList<?>)getGateShape()).basicRemove(otherEnd, msgs);
		case UMLDIPackage.INTERACTION_SHAPE__SUBFRAGMENT_COMPARTMENT:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch(eContainerFeatureID()) {
		case UMLDIPackage.INTERACTION_SHAPE__LIFELINE_SHAPE:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE, LifelineShape.class, msgs);
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
		case UMLDIPackage.INTERACTION_SHAPE__LIFELINE_SHAPE:
			return getLifelineShape();
		case UMLDIPackage.INTERACTION_SHAPE__GATE_SHAPE:
			return getGateShape();
		case UMLDIPackage.INTERACTION_SHAPE__SUBFRAGMENT_COMPARTMENT:
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case UMLDIPackage.INTERACTION_SHAPE__LIFELINE_SHAPE:
			setLifelineShape((LifelineShape)newValue);
			return;
		case UMLDIPackage.INTERACTION_SHAPE__GATE_SHAPE:
			getGateShape().clear();
			getGateShape().addAll((Collection<? extends GateShape>)newValue);
			return;
		case UMLDIPackage.INTERACTION_SHAPE__SUBFRAGMENT_COMPARTMENT:
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
		case UMLDIPackage.INTERACTION_SHAPE__LIFELINE_SHAPE:
			setLifelineShape((LifelineShape)null);
			return;
		case UMLDIPackage.INTERACTION_SHAPE__GATE_SHAPE:
			getGateShape().clear();
			return;
		case UMLDIPackage.INTERACTION_SHAPE__SUBFRAGMENT_COMPARTMENT:
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
		case UMLDIPackage.INTERACTION_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			return isSetOwningUmlDiagramElement();
		case UMLDIPackage.INTERACTION_SHAPE__LIFELINE_SHAPE:
			return getLifelineShape() != null;
		case UMLDIPackage.INTERACTION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.INTERACTION_SHAPE__GATE_SHAPE:
			return gateShape != null && !gateShape.isEmpty();
		case UMLDIPackage.INTERACTION_SHAPE__SUBFRAGMENT_COMPARTMENT:
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
		if(baseClass == InteractionFragmentShape.class) {
			switch(derivedFeatureID) {
			case UMLDIPackage.INTERACTION_SHAPE__LIFELINE_SHAPE:
				return UMLDIPackage.INTERACTION_FRAGMENT_SHAPE__LIFELINE_SHAPE;
			default:
				return -1;
			}
		}
		if(baseClass == InteractionFragmentWithGatesShape.class) {
			switch(derivedFeatureID) {
			case UMLDIPackage.INTERACTION_SHAPE__GATE_SHAPE:
				return UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE__GATE_SHAPE;
			default:
				return -1;
			}
		}
		if(baseClass == InteractionFragmentWithSubfragmentsShape.class) {
			switch(derivedFeatureID) {
			case UMLDIPackage.INTERACTION_SHAPE__SUBFRAGMENT_COMPARTMENT:
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
		if(baseClass == InteractionFragmentShape.class) {
			switch(baseFeatureID) {
			case UMLDIPackage.INTERACTION_FRAGMENT_SHAPE__LIFELINE_SHAPE:
				return UMLDIPackage.INTERACTION_SHAPE__LIFELINE_SHAPE;
			default:
				return -1;
			}
		}
		if(baseClass == InteractionFragmentWithGatesShape.class) {
			switch(baseFeatureID) {
			case UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE__GATE_SHAPE:
				return UMLDIPackage.INTERACTION_SHAPE__GATE_SHAPE;
			default:
				return -1;
			}
		}
		if(baseClass == InteractionFragmentWithSubfragmentsShape.class) {
			switch(baseFeatureID) {
			case UMLDIPackage.INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE__SUBFRAGMENT_COMPARTMENT:
				return UMLDIPackage.INTERACTION_SHAPE__SUBFRAGMENT_COMPARTMENT;
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
		return super.isSetOwningUmlDiagramElement() || eIsSet(UMLDIPackage.INTERACTION_SHAPE__LIFELINE_SHAPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isSetOwnedUmlDiagramElement() {
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.INTERACTION_SHAPE__GATE_SHAPE) || eIsSet(UMLDIPackage.INTERACTION_SHAPE__SUBFRAGMENT_COMPARTMENT);
	}
} //InteractionShapeImpl
