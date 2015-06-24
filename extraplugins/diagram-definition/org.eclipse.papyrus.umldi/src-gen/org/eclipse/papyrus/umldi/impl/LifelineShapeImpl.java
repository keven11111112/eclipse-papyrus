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
import org.eclipse.papyrus.umldi.ConstraintLabel;
import org.eclipse.papyrus.umldi.InteractionFragmentShape;
import org.eclipse.papyrus.umldi.LifelineShape;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lifeline Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.LifelineShapeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.LifelineShapeImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.LifelineShapeImpl#getSubfragmentShape <em>Subfragment Shape</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.LifelineShapeImpl#getNestingLifelineShape <em>Nesting Lifeline Shape</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.LifelineShapeImpl#getNestedLifelineShape <em>Nested Lifeline Shape</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.LifelineShapeImpl#getConstraintLabel <em>Constraint Label</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LifelineShapeImpl extends ElementShapeImpl implements LifelineShape {

	/**
	 * The cached value of the '{@link #getSubfragmentShape() <em>Subfragment Shape</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSubfragmentShape()
	 * @generated
	 * @ordered
	 */
	protected EList<InteractionFragmentShape> subfragmentShape;

	/**
	 * The cached value of the '{@link #getNestedLifelineShape() <em>Nested Lifeline Shape</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getNestedLifelineShape()
	 * @generated
	 * @ordered
	 */
	protected EList<LifelineShape> nestedLifelineShape;

	/**
	 * The cached value of the '{@link #getConstraintLabel() <em>Constraint Label</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getConstraintLabel()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintLabel> constraintLabel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected LifelineShapeImpl() {
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
		return UMLDIPackage.Literals.LIFELINE_SHAPE;
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
		LifelineShape nestingLifelineShape = getNestingLifelineShape();
		if(nestingLifelineShape != null) {
			return nestingLifelineShape;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<InteractionFragmentShape> getSubfragmentShape() {
		if(subfragmentShape == null) {
			subfragmentShape = new EObjectContainmentWithInverseEList<InteractionFragmentShape>(InteractionFragmentShape.class, this, UMLDIPackage.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE, UMLDIPackage.INTERACTION_FRAGMENT_SHAPE__LIFELINE_SHAPE);
		}
		return subfragmentShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.LIFELINE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
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
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.LIFELINE_SHAPE__STEREOTYPE_LABEL, UMLDIPackage.LIFELINE_SHAPE__MAIN_LABEL, UMLDIPackage.LIFELINE_SHAPE__STEREOTYPE_COMPARTMENT, UMLDIPackage.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE, UMLDIPackage.LIFELINE_SHAPE__NESTED_LIFELINE_SHAPE, UMLDIPackage.LIFELINE_SHAPE__CONSTRAINT_LABEL };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LifelineShape getNestingLifelineShape() {
		if(eContainerFeatureID() != UMLDIPackage.LIFELINE_SHAPE__NESTING_LIFELINE_SHAPE)
			return null;
		return (LifelineShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetNestingLifelineShape(LifelineShape newNestingLifelineShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newNestingLifelineShape, UMLDIPackage.LIFELINE_SHAPE__NESTING_LIFELINE_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNestingLifelineShape(LifelineShape newNestingLifelineShape) {
		if(newNestingLifelineShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.LIFELINE_SHAPE__NESTING_LIFELINE_SHAPE && newNestingLifelineShape != null)) {
			if(EcoreUtil.isAncestor(this, newNestingLifelineShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newNestingLifelineShape != null)
				msgs = ((InternalEObject)newNestingLifelineShape).eInverseAdd(this, UMLDIPackage.LIFELINE_SHAPE__NESTED_LIFELINE_SHAPE, LifelineShape.class, msgs);
			msgs = basicSetNestingLifelineShape(newNestingLifelineShape, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.LIFELINE_SHAPE__NESTING_LIFELINE_SHAPE, newNestingLifelineShape, newNestingLifelineShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<LifelineShape> getNestedLifelineShape() {
		if(nestedLifelineShape == null) {
			nestedLifelineShape = new EObjectContainmentWithInverseEList<LifelineShape>(LifelineShape.class, this, UMLDIPackage.LIFELINE_SHAPE__NESTED_LIFELINE_SHAPE, UMLDIPackage.LIFELINE_SHAPE__NESTING_LIFELINE_SHAPE);
		}
		return nestedLifelineShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ConstraintLabel> getConstraintLabel() {
		if(constraintLabel == null) {
			constraintLabel = new EObjectContainmentWithInverseEList<ConstraintLabel>(ConstraintLabel.class, this, UMLDIPackage.LIFELINE_SHAPE__CONSTRAINT_LABEL, UMLDIPackage.CONSTRAINT_LABEL__LIFELINE_SHAPE);
		}
		return constraintLabel;
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
		case UMLDIPackage.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubfragmentShape()).basicAdd(otherEnd, msgs);
		case UMLDIPackage.LIFELINE_SHAPE__NESTING_LIFELINE_SHAPE:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetNestingLifelineShape((LifelineShape)otherEnd, msgs);
		case UMLDIPackage.LIFELINE_SHAPE__NESTED_LIFELINE_SHAPE:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getNestedLifelineShape()).basicAdd(otherEnd, msgs);
		case UMLDIPackage.LIFELINE_SHAPE__CONSTRAINT_LABEL:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstraintLabel()).basicAdd(otherEnd, msgs);
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
		case UMLDIPackage.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE:
			return ((InternalEList<?>)getSubfragmentShape()).basicRemove(otherEnd, msgs);
		case UMLDIPackage.LIFELINE_SHAPE__NESTING_LIFELINE_SHAPE:
			return basicSetNestingLifelineShape(null, msgs);
		case UMLDIPackage.LIFELINE_SHAPE__NESTED_LIFELINE_SHAPE:
			return ((InternalEList<?>)getNestedLifelineShape()).basicRemove(otherEnd, msgs);
		case UMLDIPackage.LIFELINE_SHAPE__CONSTRAINT_LABEL:
			return ((InternalEList<?>)getConstraintLabel()).basicRemove(otherEnd, msgs);
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
		case UMLDIPackage.LIFELINE_SHAPE__NESTING_LIFELINE_SHAPE:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.LIFELINE_SHAPE__NESTED_LIFELINE_SHAPE, LifelineShape.class, msgs);
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
		case UMLDIPackage.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE:
			return getSubfragmentShape();
		case UMLDIPackage.LIFELINE_SHAPE__NESTING_LIFELINE_SHAPE:
			return getNestingLifelineShape();
		case UMLDIPackage.LIFELINE_SHAPE__NESTED_LIFELINE_SHAPE:
			return getNestedLifelineShape();
		case UMLDIPackage.LIFELINE_SHAPE__CONSTRAINT_LABEL:
			return getConstraintLabel();
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
		case UMLDIPackage.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE:
			getSubfragmentShape().clear();
			getSubfragmentShape().addAll((Collection<? extends InteractionFragmentShape>)newValue);
			return;
		case UMLDIPackage.LIFELINE_SHAPE__NESTING_LIFELINE_SHAPE:
			setNestingLifelineShape((LifelineShape)newValue);
			return;
		case UMLDIPackage.LIFELINE_SHAPE__NESTED_LIFELINE_SHAPE:
			getNestedLifelineShape().clear();
			getNestedLifelineShape().addAll((Collection<? extends LifelineShape>)newValue);
			return;
		case UMLDIPackage.LIFELINE_SHAPE__CONSTRAINT_LABEL:
			getConstraintLabel().clear();
			getConstraintLabel().addAll((Collection<? extends ConstraintLabel>)newValue);
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
		case UMLDIPackage.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE:
			getSubfragmentShape().clear();
			return;
		case UMLDIPackage.LIFELINE_SHAPE__NESTING_LIFELINE_SHAPE:
			setNestingLifelineShape((LifelineShape)null);
			return;
		case UMLDIPackage.LIFELINE_SHAPE__NESTED_LIFELINE_SHAPE:
			getNestedLifelineShape().clear();
			return;
		case UMLDIPackage.LIFELINE_SHAPE__CONSTRAINT_LABEL:
			getConstraintLabel().clear();
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
		case UMLDIPackage.LIFELINE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.LIFELINE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			return isSetOwningUmlDiagramElement();
		case UMLDIPackage.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE:
			return subfragmentShape != null && !subfragmentShape.isEmpty();
		case UMLDIPackage.LIFELINE_SHAPE__NESTING_LIFELINE_SHAPE:
			return getNestingLifelineShape() != null;
		case UMLDIPackage.LIFELINE_SHAPE__NESTED_LIFELINE_SHAPE:
			return nestedLifelineShape != null && !nestedLifelineShape.isEmpty();
		case UMLDIPackage.LIFELINE_SHAPE__CONSTRAINT_LABEL:
			return constraintLabel != null && !constraintLabel.isEmpty();
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
	public boolean isSetOwningUmlDiagramElement() {
		return super.isSetOwningUmlDiagramElement() || eIsSet(UMLDIPackage.LIFELINE_SHAPE__NESTING_LIFELINE_SHAPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isSetOwnedUmlDiagramElement() {
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE) || eIsSet(UMLDIPackage.LIFELINE_SHAPE__NESTED_LIFELINE_SHAPE) || eIsSet(UMLDIPackage.LIFELINE_SHAPE__CONSTRAINT_LABEL);
	}
} //LifelineShapeImpl
