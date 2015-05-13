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

import org.eclipse.papyrus.umldi.AssociationEdge;
import org.eclipse.papyrus.umldi.ConstraintLabel;
import org.eclipse.papyrus.umldi.GeneralizationSetEdge;
import org.eclipse.papyrus.umldi.ObjectNodeShape;
import org.eclipse.papyrus.umldi.PropertyEdge;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ConstraintLabelImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ConstraintLabelImpl#getAssociationEdge <em>Association Edge</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ConstraintLabelImpl#getGeneralizationSetEdge <em>Generalization Set Edge</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ConstraintLabelImpl#getObjectNodeShape <em>Object Node Shape</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ConstraintLabelImpl#getPropertyEdge <em>Property Edge</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConstraintLabelImpl extends UmlLabelImpl implements ConstraintLabel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintLabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.CONSTRAINT_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @generated
	 */
	@Override
	public UmlDiagramElement basicGetOwningUmlDiagramElement() {
		AssociationEdge associationEdge = getAssociationEdge();			
		if (associationEdge != null) {
			return associationEdge;
		}
		GeneralizationSetEdge generalizationSetEdge = getGeneralizationSetEdge();			
		if (generalizationSetEdge != null) {
			return generalizationSetEdge;
		}
		ObjectNodeShape objectNodeShape = getObjectNodeShape();			
		if (objectNodeShape != null) {
			return objectNodeShape;
		}
		PropertyEdge propertyEdge = getPropertyEdge();			
		if (propertyEdge != null) {
			return propertyEdge;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEdge getAssociationEdge() {
		if (eContainerFeatureID() != UMLDIPackage.CONSTRAINT_LABEL__ASSOCIATION_EDGE) return null;
		return (AssociationEdge)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssociationEdge(AssociationEdge newAssociationEdge, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAssociationEdge, UMLDIPackage.CONSTRAINT_LABEL__ASSOCIATION_EDGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociationEdge(AssociationEdge newAssociationEdge) {
		if (newAssociationEdge != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.CONSTRAINT_LABEL__ASSOCIATION_EDGE && newAssociationEdge != null)) {
			if (EcoreUtil.isAncestor(this, newAssociationEdge))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAssociationEdge != null)
				msgs = ((InternalEObject)newAssociationEdge).eInverseAdd(this, UMLDIPackage.ASSOCIATION_EDGE__END_CONSTRAINT_LABEL, AssociationEdge.class, msgs);
			msgs = basicSetAssociationEdge(newAssociationEdge, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.CONSTRAINT_LABEL__ASSOCIATION_EDGE, newAssociationEdge, newAssociationEdge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralizationSetEdge getGeneralizationSetEdge() {
		if (eContainerFeatureID() != UMLDIPackage.CONSTRAINT_LABEL__GENERALIZATION_SET_EDGE) return null;
		return (GeneralizationSetEdge)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGeneralizationSetEdge(GeneralizationSetEdge newGeneralizationSetEdge, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGeneralizationSetEdge, UMLDIPackage.CONSTRAINT_LABEL__GENERALIZATION_SET_EDGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneralizationSetEdge(GeneralizationSetEdge newGeneralizationSetEdge) {
		if (newGeneralizationSetEdge != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.CONSTRAINT_LABEL__GENERALIZATION_SET_EDGE && newGeneralizationSetEdge != null)) {
			if (EcoreUtil.isAncestor(this, newGeneralizationSetEdge))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGeneralizationSetEdge != null)
				msgs = ((InternalEObject)newGeneralizationSetEdge).eInverseAdd(this, UMLDIPackage.GENERALIZATION_SET_EDGE__CONSTRAINT_LABEL, GeneralizationSetEdge.class, msgs);
			msgs = basicSetGeneralizationSetEdge(newGeneralizationSetEdge, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.CONSTRAINT_LABEL__GENERALIZATION_SET_EDGE, newGeneralizationSetEdge, newGeneralizationSetEdge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectNodeShape getObjectNodeShape() {
		if (eContainerFeatureID() != UMLDIPackage.CONSTRAINT_LABEL__OBJECT_NODE_SHAPE) return null;
		return (ObjectNodeShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObjectNodeShape(ObjectNodeShape newObjectNodeShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newObjectNodeShape, UMLDIPackage.CONSTRAINT_LABEL__OBJECT_NODE_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectNodeShape(ObjectNodeShape newObjectNodeShape) {
		if (newObjectNodeShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.CONSTRAINT_LABEL__OBJECT_NODE_SHAPE && newObjectNodeShape != null)) {
			if (EcoreUtil.isAncestor(this, newObjectNodeShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newObjectNodeShape != null)
				msgs = ((InternalEObject)newObjectNodeShape).eInverseAdd(this, UMLDIPackage.OBJECT_NODE_SHAPE__CONSTRAINT_LABEL, ObjectNodeShape.class, msgs);
			msgs = basicSetObjectNodeShape(newObjectNodeShape, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.CONSTRAINT_LABEL__OBJECT_NODE_SHAPE, newObjectNodeShape, newObjectNodeShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyEdge getPropertyEdge() {
		if (eContainerFeatureID() != UMLDIPackage.CONSTRAINT_LABEL__PROPERTY_EDGE) return null;
		return (PropertyEdge)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPropertyEdge(PropertyEdge newPropertyEdge, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPropertyEdge, UMLDIPackage.CONSTRAINT_LABEL__PROPERTY_EDGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyEdge(PropertyEdge newPropertyEdge) {
		if (newPropertyEdge != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.CONSTRAINT_LABEL__PROPERTY_EDGE && newPropertyEdge != null)) {
			if (EcoreUtil.isAncestor(this, newPropertyEdge))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPropertyEdge != null)
				msgs = ((InternalEObject)newPropertyEdge).eInverseAdd(this, UMLDIPackage.PROPERTY_EDGE__CONSTRAINT_LABEL, PropertyEdge.class, msgs);
			msgs = basicSetPropertyEdge(newPropertyEdge, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.CONSTRAINT_LABEL__PROPERTY_EDGE, newPropertyEdge, newPropertyEdge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.CONSTRAINT_LABEL__ASSOCIATION_EDGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAssociationEdge((AssociationEdge)otherEnd, msgs);
			case UMLDIPackage.CONSTRAINT_LABEL__GENERALIZATION_SET_EDGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGeneralizationSetEdge((GeneralizationSetEdge)otherEnd, msgs);
			case UMLDIPackage.CONSTRAINT_LABEL__OBJECT_NODE_SHAPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetObjectNodeShape((ObjectNodeShape)otherEnd, msgs);
			case UMLDIPackage.CONSTRAINT_LABEL__PROPERTY_EDGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPropertyEdge((PropertyEdge)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.CONSTRAINT_LABEL__ASSOCIATION_EDGE:
				return basicSetAssociationEdge(null, msgs);
			case UMLDIPackage.CONSTRAINT_LABEL__GENERALIZATION_SET_EDGE:
				return basicSetGeneralizationSetEdge(null, msgs);
			case UMLDIPackage.CONSTRAINT_LABEL__OBJECT_NODE_SHAPE:
				return basicSetObjectNodeShape(null, msgs);
			case UMLDIPackage.CONSTRAINT_LABEL__PROPERTY_EDGE:
				return basicSetPropertyEdge(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case UMLDIPackage.CONSTRAINT_LABEL__ASSOCIATION_EDGE:
				return eInternalContainer().eInverseRemove(this, UMLDIPackage.ASSOCIATION_EDGE__END_CONSTRAINT_LABEL, AssociationEdge.class, msgs);
			case UMLDIPackage.CONSTRAINT_LABEL__GENERALIZATION_SET_EDGE:
				return eInternalContainer().eInverseRemove(this, UMLDIPackage.GENERALIZATION_SET_EDGE__CONSTRAINT_LABEL, GeneralizationSetEdge.class, msgs);
			case UMLDIPackage.CONSTRAINT_LABEL__OBJECT_NODE_SHAPE:
				return eInternalContainer().eInverseRemove(this, UMLDIPackage.OBJECT_NODE_SHAPE__CONSTRAINT_LABEL, ObjectNodeShape.class, msgs);
			case UMLDIPackage.CONSTRAINT_LABEL__PROPERTY_EDGE:
				return eInternalContainer().eInverseRemove(this, UMLDIPackage.PROPERTY_EDGE__CONSTRAINT_LABEL, PropertyEdge.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLDIPackage.CONSTRAINT_LABEL__ASSOCIATION_EDGE:
				return getAssociationEdge();
			case UMLDIPackage.CONSTRAINT_LABEL__GENERALIZATION_SET_EDGE:
				return getGeneralizationSetEdge();
			case UMLDIPackage.CONSTRAINT_LABEL__OBJECT_NODE_SHAPE:
				return getObjectNodeShape();
			case UMLDIPackage.CONSTRAINT_LABEL__PROPERTY_EDGE:
				return getPropertyEdge();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UMLDIPackage.CONSTRAINT_LABEL__ASSOCIATION_EDGE:
				setAssociationEdge((AssociationEdge)newValue);
				return;
			case UMLDIPackage.CONSTRAINT_LABEL__GENERALIZATION_SET_EDGE:
				setGeneralizationSetEdge((GeneralizationSetEdge)newValue);
				return;
			case UMLDIPackage.CONSTRAINT_LABEL__OBJECT_NODE_SHAPE:
				setObjectNodeShape((ObjectNodeShape)newValue);
				return;
			case UMLDIPackage.CONSTRAINT_LABEL__PROPERTY_EDGE:
				setPropertyEdge((PropertyEdge)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UMLDIPackage.CONSTRAINT_LABEL__ASSOCIATION_EDGE:
				setAssociationEdge((AssociationEdge)null);
				return;
			case UMLDIPackage.CONSTRAINT_LABEL__GENERALIZATION_SET_EDGE:
				setGeneralizationSetEdge((GeneralizationSetEdge)null);
				return;
			case UMLDIPackage.CONSTRAINT_LABEL__OBJECT_NODE_SHAPE:
				setObjectNodeShape((ObjectNodeShape)null);
				return;
			case UMLDIPackage.CONSTRAINT_LABEL__PROPERTY_EDGE:
				setPropertyEdge((PropertyEdge)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UMLDIPackage.CONSTRAINT_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
				return isSetOwningUmlDiagramElement();
			case UMLDIPackage.CONSTRAINT_LABEL__ASSOCIATION_EDGE:
				return getAssociationEdge() != null;
			case UMLDIPackage.CONSTRAINT_LABEL__GENERALIZATION_SET_EDGE:
				return getGeneralizationSetEdge() != null;
			case UMLDIPackage.CONSTRAINT_LABEL__OBJECT_NODE_SHAPE:
				return getObjectNodeShape() != null;
			case UMLDIPackage.CONSTRAINT_LABEL__PROPERTY_EDGE:
				return getPropertyEdge() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwningUmlDiagramElement() {
		return super.isSetOwningUmlDiagramElement()
			|| eIsSet(UMLDIPackage.CONSTRAINT_LABEL__ASSOCIATION_EDGE)
			|| eIsSet(UMLDIPackage.CONSTRAINT_LABEL__GENERALIZATION_SET_EDGE)
			|| eIsSet(UMLDIPackage.CONSTRAINT_LABEL__OBJECT_NODE_SHAPE)
			|| eIsSet(UMLDIPackage.CONSTRAINT_LABEL__PROPERTY_EDGE);
	}

} //ConstraintLabelImpl
