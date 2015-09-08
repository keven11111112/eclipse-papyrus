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

import org.eclipse.papyrus.umldi.ActivityNodeCompartment;
import org.eclipse.papyrus.umldi.ActivityParameterNodeShape;
import org.eclipse.papyrus.umldi.ActivityShape;
import org.eclipse.papyrus.umldi.ElementWithActivityNodesShape;
import org.eclipse.papyrus.umldi.ParameterCompartment;
import org.eclipse.papyrus.umldi.PostConditionCompartment;
import org.eclipse.papyrus.umldi.PreConditionCompartment;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ActivityShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ActivityShapeImpl#getActivityNodeCompartment <em>Activity Node Compartment</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ActivityShapeImpl#getParameterCompartment <em>Parameter Compartment</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ActivityShapeImpl#getPostConditionCompartment <em>Post Condition Compartment</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ActivityShapeImpl#getPreConditionCompartment <em>Pre Condition Compartment</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.ActivityShapeImpl#getActivityParameterNodeShape <em>Activity Parameter Node Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActivityShapeImpl extends ClassShapeImpl implements ActivityShape {

	/**
	 * The cached value of the '{@link #getActivityNodeCompartment() <em>Activity Node Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getActivityNodeCompartment()
	 * @generated
	 * @ordered
	 */
	protected ActivityNodeCompartment activityNodeCompartment;

	/**
	 * The cached value of the '{@link #getParameterCompartment() <em>Parameter Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getParameterCompartment()
	 * @generated
	 * @ordered
	 */
	protected ParameterCompartment parameterCompartment;

	/**
	 * The cached value of the '{@link #getPostConditionCompartment() <em>Post Condition Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPostConditionCompartment()
	 * @generated
	 * @ordered
	 */
	protected PostConditionCompartment postConditionCompartment;

	/**
	 * The cached value of the '{@link #getPreConditionCompartment() <em>Pre Condition Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPreConditionCompartment()
	 * @generated
	 * @ordered
	 */
	protected PreConditionCompartment preConditionCompartment;

	/**
	 * The cached value of the '{@link #getActivityParameterNodeShape() <em>Activity Parameter Node Shape</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getActivityParameterNodeShape()
	 * @generated
	 * @ordered
	 */
	protected EList<ActivityParameterNodeShape> activityParameterNodeShape;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ActivityShapeImpl() {
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
		return UMLDIPackage.Literals.ACTIVITY_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.ACTIVITY_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
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
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.ACTIVITY_SHAPE__STEREOTYPE_LABEL, UMLDIPackage.ACTIVITY_SHAPE__MAIN_LABEL, UMLDIPackage.ACTIVITY_SHAPE__STEREOTYPE_COMPARTMENT, UMLDIPackage.ACTIVITY_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT, UMLDIPackage.ACTIVITY_SHAPE__OWNED_USE_CASE_COMPARTMENT, UMLDIPackage.ACTIVITY_SHAPE__USE_CASE_COMPARTMENT, UMLDIPackage.ACTIVITY_SHAPE__ATTRIBUTE_COMPARTMENT, UMLDIPackage.ACTIVITY_SHAPE__OPERATION_COMPARTMENT, UMLDIPackage.ACTIVITY_SHAPE__RECEPTION_COMPARTMENT, UMLDIPackage.ACTIVITY_SHAPE__NESTED_CLASSIFIER_COMPARTMENT, UMLDIPackage.ACTIVITY_SHAPE__OWNED_BEHAVIOR_COMPARTMENT, UMLDIPackage.ACTIVITY_SHAPE__STRUCTURE_COMPARTMENT, UMLDIPackage.ACTIVITY_SHAPE__PORT_SHAPE, UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_NODE_COMPARTMENT, UMLDIPackage.ACTIVITY_SHAPE__PARAMETER_COMPARTMENT, UMLDIPackage.ACTIVITY_SHAPE__POST_CONDITION_COMPARTMENT, UMLDIPackage.ACTIVITY_SHAPE__PRE_CONDITION_COMPARTMENT, UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_PARAMETER_NODE_SHAPE };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivityNodeCompartment getActivityNodeCompartment() {
		return activityNodeCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetActivityNodeCompartment(ActivityNodeCompartment newActivityNodeCompartment, NotificationChain msgs) {
		ActivityNodeCompartment oldActivityNodeCompartment = activityNodeCompartment;
		activityNodeCompartment = newActivityNodeCompartment;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_NODE_COMPARTMENT, oldActivityNodeCompartment, newActivityNodeCompartment);
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
	public void setActivityNodeCompartment(ActivityNodeCompartment newActivityNodeCompartment) {
		if(newActivityNodeCompartment != activityNodeCompartment) {
			NotificationChain msgs = null;
			if(activityNodeCompartment != null)
				msgs = ((InternalEObject)activityNodeCompartment).eInverseRemove(this, UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__ELEMENT_WITH_ACTIVITY_NODES_SHAPE, ActivityNodeCompartment.class, msgs);
			if(newActivityNodeCompartment != null)
				msgs = ((InternalEObject)newActivityNodeCompartment).eInverseAdd(this, UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__ELEMENT_WITH_ACTIVITY_NODES_SHAPE, ActivityNodeCompartment.class, msgs);
			msgs = basicSetActivityNodeCompartment(newActivityNodeCompartment, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_NODE_COMPARTMENT, newActivityNodeCompartment, newActivityNodeCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ParameterCompartment getParameterCompartment() {
		return parameterCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParameterCompartment(ParameterCompartment newParameterCompartment, NotificationChain msgs) {
		ParameterCompartment oldParameterCompartment = parameterCompartment;
		parameterCompartment = newParameterCompartment;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.ACTIVITY_SHAPE__PARAMETER_COMPARTMENT, oldParameterCompartment, newParameterCompartment);
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
	public void setParameterCompartment(ParameterCompartment newParameterCompartment) {
		if(newParameterCompartment != parameterCompartment) {
			NotificationChain msgs = null;
			if(parameterCompartment != null)
				msgs = ((InternalEObject)parameterCompartment).eInverseRemove(this, UMLDIPackage.PARAMETER_COMPARTMENT__ACTIVITY_SHAPE, ParameterCompartment.class, msgs);
			if(newParameterCompartment != null)
				msgs = ((InternalEObject)newParameterCompartment).eInverseAdd(this, UMLDIPackage.PARAMETER_COMPARTMENT__ACTIVITY_SHAPE, ParameterCompartment.class, msgs);
			msgs = basicSetParameterCompartment(newParameterCompartment, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.ACTIVITY_SHAPE__PARAMETER_COMPARTMENT, newParameterCompartment, newParameterCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PostConditionCompartment getPostConditionCompartment() {
		return postConditionCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetPostConditionCompartment(PostConditionCompartment newPostConditionCompartment, NotificationChain msgs) {
		PostConditionCompartment oldPostConditionCompartment = postConditionCompartment;
		postConditionCompartment = newPostConditionCompartment;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.ACTIVITY_SHAPE__POST_CONDITION_COMPARTMENT, oldPostConditionCompartment, newPostConditionCompartment);
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
	public void setPostConditionCompartment(PostConditionCompartment newPostConditionCompartment) {
		if(newPostConditionCompartment != postConditionCompartment) {
			NotificationChain msgs = null;
			if(postConditionCompartment != null)
				msgs = ((InternalEObject)postConditionCompartment).eInverseRemove(this, UMLDIPackage.POST_CONDITION_COMPARTMENT__ACTIVITY_SHAPE, PostConditionCompartment.class, msgs);
			if(newPostConditionCompartment != null)
				msgs = ((InternalEObject)newPostConditionCompartment).eInverseAdd(this, UMLDIPackage.POST_CONDITION_COMPARTMENT__ACTIVITY_SHAPE, PostConditionCompartment.class, msgs);
			msgs = basicSetPostConditionCompartment(newPostConditionCompartment, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.ACTIVITY_SHAPE__POST_CONDITION_COMPARTMENT, newPostConditionCompartment, newPostConditionCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PreConditionCompartment getPreConditionCompartment() {
		return preConditionCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetPreConditionCompartment(PreConditionCompartment newPreConditionCompartment, NotificationChain msgs) {
		PreConditionCompartment oldPreConditionCompartment = preConditionCompartment;
		preConditionCompartment = newPreConditionCompartment;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.ACTIVITY_SHAPE__PRE_CONDITION_COMPARTMENT, oldPreConditionCompartment, newPreConditionCompartment);
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
	public void setPreConditionCompartment(PreConditionCompartment newPreConditionCompartment) {
		if(newPreConditionCompartment != preConditionCompartment) {
			NotificationChain msgs = null;
			if(preConditionCompartment != null)
				msgs = ((InternalEObject)preConditionCompartment).eInverseRemove(this, UMLDIPackage.PRE_CONDITION_COMPARTMENT__ACTIVITY_SHAPE, PreConditionCompartment.class, msgs);
			if(newPreConditionCompartment != null)
				msgs = ((InternalEObject)newPreConditionCompartment).eInverseAdd(this, UMLDIPackage.PRE_CONDITION_COMPARTMENT__ACTIVITY_SHAPE, PreConditionCompartment.class, msgs);
			msgs = basicSetPreConditionCompartment(newPreConditionCompartment, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.ACTIVITY_SHAPE__PRE_CONDITION_COMPARTMENT, newPreConditionCompartment, newPreConditionCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ActivityParameterNodeShape> getActivityParameterNodeShape() {
		if(activityParameterNodeShape == null) {
			activityParameterNodeShape = new EObjectContainmentWithInverseEList<ActivityParameterNodeShape>(ActivityParameterNodeShape.class, this, UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_PARAMETER_NODE_SHAPE, UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE__ACTIVITY_SHAPE);
		}
		return activityParameterNodeShape;
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
		case UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_NODE_COMPARTMENT:
			if(activityNodeCompartment != null)
				msgs = ((InternalEObject)activityNodeCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_NODE_COMPARTMENT, null, msgs);
			return basicSetActivityNodeCompartment((ActivityNodeCompartment)otherEnd, msgs);
		case UMLDIPackage.ACTIVITY_SHAPE__PARAMETER_COMPARTMENT:
			if(parameterCompartment != null)
				msgs = ((InternalEObject)parameterCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.ACTIVITY_SHAPE__PARAMETER_COMPARTMENT, null, msgs);
			return basicSetParameterCompartment((ParameterCompartment)otherEnd, msgs);
		case UMLDIPackage.ACTIVITY_SHAPE__POST_CONDITION_COMPARTMENT:
			if(postConditionCompartment != null)
				msgs = ((InternalEObject)postConditionCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.ACTIVITY_SHAPE__POST_CONDITION_COMPARTMENT, null, msgs);
			return basicSetPostConditionCompartment((PostConditionCompartment)otherEnd, msgs);
		case UMLDIPackage.ACTIVITY_SHAPE__PRE_CONDITION_COMPARTMENT:
			if(preConditionCompartment != null)
				msgs = ((InternalEObject)preConditionCompartment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.ACTIVITY_SHAPE__PRE_CONDITION_COMPARTMENT, null, msgs);
			return basicSetPreConditionCompartment((PreConditionCompartment)otherEnd, msgs);
		case UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_PARAMETER_NODE_SHAPE:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getActivityParameterNodeShape()).basicAdd(otherEnd, msgs);
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
		case UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_NODE_COMPARTMENT:
			return basicSetActivityNodeCompartment(null, msgs);
		case UMLDIPackage.ACTIVITY_SHAPE__PARAMETER_COMPARTMENT:
			return basicSetParameterCompartment(null, msgs);
		case UMLDIPackage.ACTIVITY_SHAPE__POST_CONDITION_COMPARTMENT:
			return basicSetPostConditionCompartment(null, msgs);
		case UMLDIPackage.ACTIVITY_SHAPE__PRE_CONDITION_COMPARTMENT:
			return basicSetPreConditionCompartment(null, msgs);
		case UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_PARAMETER_NODE_SHAPE:
			return ((InternalEList<?>)getActivityParameterNodeShape()).basicRemove(otherEnd, msgs);
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
		case UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_NODE_COMPARTMENT:
			return getActivityNodeCompartment();
		case UMLDIPackage.ACTIVITY_SHAPE__PARAMETER_COMPARTMENT:
			return getParameterCompartment();
		case UMLDIPackage.ACTIVITY_SHAPE__POST_CONDITION_COMPARTMENT:
			return getPostConditionCompartment();
		case UMLDIPackage.ACTIVITY_SHAPE__PRE_CONDITION_COMPARTMENT:
			return getPreConditionCompartment();
		case UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_PARAMETER_NODE_SHAPE:
			return getActivityParameterNodeShape();
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
		case UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_NODE_COMPARTMENT:
			setActivityNodeCompartment((ActivityNodeCompartment)newValue);
			return;
		case UMLDIPackage.ACTIVITY_SHAPE__PARAMETER_COMPARTMENT:
			setParameterCompartment((ParameterCompartment)newValue);
			return;
		case UMLDIPackage.ACTIVITY_SHAPE__POST_CONDITION_COMPARTMENT:
			setPostConditionCompartment((PostConditionCompartment)newValue);
			return;
		case UMLDIPackage.ACTIVITY_SHAPE__PRE_CONDITION_COMPARTMENT:
			setPreConditionCompartment((PreConditionCompartment)newValue);
			return;
		case UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_PARAMETER_NODE_SHAPE:
			getActivityParameterNodeShape().clear();
			getActivityParameterNodeShape().addAll((Collection<? extends ActivityParameterNodeShape>)newValue);
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
		case UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_NODE_COMPARTMENT:
			setActivityNodeCompartment((ActivityNodeCompartment)null);
			return;
		case UMLDIPackage.ACTIVITY_SHAPE__PARAMETER_COMPARTMENT:
			setParameterCompartment((ParameterCompartment)null);
			return;
		case UMLDIPackage.ACTIVITY_SHAPE__POST_CONDITION_COMPARTMENT:
			setPostConditionCompartment((PostConditionCompartment)null);
			return;
		case UMLDIPackage.ACTIVITY_SHAPE__PRE_CONDITION_COMPARTMENT:
			setPreConditionCompartment((PreConditionCompartment)null);
			return;
		case UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_PARAMETER_NODE_SHAPE:
			getActivityParameterNodeShape().clear();
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
		case UMLDIPackage.ACTIVITY_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_NODE_COMPARTMENT:
			return activityNodeCompartment != null;
		case UMLDIPackage.ACTIVITY_SHAPE__PARAMETER_COMPARTMENT:
			return parameterCompartment != null;
		case UMLDIPackage.ACTIVITY_SHAPE__POST_CONDITION_COMPARTMENT:
			return postConditionCompartment != null;
		case UMLDIPackage.ACTIVITY_SHAPE__PRE_CONDITION_COMPARTMENT:
			return preConditionCompartment != null;
		case UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_PARAMETER_NODE_SHAPE:
			return activityParameterNodeShape != null && !activityParameterNodeShape.isEmpty();
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
		if(baseClass == ElementWithActivityNodesShape.class) {
			switch(derivedFeatureID) {
			case UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_NODE_COMPARTMENT:
				return UMLDIPackage.ELEMENT_WITH_ACTIVITY_NODES_SHAPE__ACTIVITY_NODE_COMPARTMENT;
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
		if(baseClass == ElementWithActivityNodesShape.class) {
			switch(baseFeatureID) {
			case UMLDIPackage.ELEMENT_WITH_ACTIVITY_NODES_SHAPE__ACTIVITY_NODE_COMPARTMENT:
				return UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_NODE_COMPARTMENT;
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
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_NODE_COMPARTMENT) || eIsSet(UMLDIPackage.ACTIVITY_SHAPE__PARAMETER_COMPARTMENT) || eIsSet(UMLDIPackage.ACTIVITY_SHAPE__POST_CONDITION_COMPARTMENT) || eIsSet(UMLDIPackage.ACTIVITY_SHAPE__PRE_CONDITION_COMPARTMENT) || eIsSet(UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_PARAMETER_NODE_SHAPE);
	}
} //ActivityShapeImpl
