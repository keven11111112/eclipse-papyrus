/**
 *   Copyright (c) 2016 CEA LIST and others.
 *   
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *     CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rhapsody Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhapsodyShapeImpl#getTransform <em>Transform</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhapsodyShapeImpl#getRectangle <em>Rectangle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhapsodyShapeImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhapsodyShapeImpl#getRhapsodyMetamodelObject <em>Rhapsody Metamodel Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhapsodyShapeImpl#getParentRelativePosition <em>Parent Relative Position</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhapsodyShapeImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhapsodyShapeImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhapsodyShapeImpl#getAbsolutePosition <em>Absolute Position</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RhapsodyShapeImpl extends MinimalEObjectImpl.Container implements RhapsodyShape {
	/**
	 * The cached value of the '{@link #getTransform() <em>Transform</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransform()
	 * @generated
	 * @ordered
	 */
	protected TransformMatrix transform;

	/**
	 * The cached value of the '{@link #getRectangle() <em>Rectangle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRectangle()
	 * @generated
	 * @ordered
	 */
	protected Rectangle rectangle;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected RhapsodyShape parent;

	/**
	 * The cached value of the '{@link #getRhapsodyMetamodelObject() <em>Rhapsody Metamodel Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhapsodyMetamodelObject()
	 * @generated
	 * @ordered
	 */
	protected EObject rhapsodyMetamodelObject;

	/**
	 * The cached value of the '{@link #getParentRelativePosition() <em>Parent Relative Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentRelativePosition()
	 * @generated
	 * @ordered
	 */
	protected Point parentRelativePosition;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final Integer HEIGHT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected Integer height = HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final Integer WIDTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected Integer width = WIDTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAbsolutePosition() <em>Absolute Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbsolutePosition()
	 * @generated
	 * @ordered
	 */
	protected Point absolutePosition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RhapsodyShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RhpGeometryPackage.Literals.RHAPSODY_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformMatrix getTransform() {
		return transform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransform(TransformMatrix newTransform, NotificationChain msgs) {
		TransformMatrix oldTransform = transform;
		transform = newTransform;
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransform(TransformMatrix newTransform) {
		if (newTransform != transform) {
			NotificationChain msgs = null;
			if (transform != null)
				msgs = ((InternalEObject)transform).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RhpGeometryPackage.RHAPSODY_SHAPE__TRANSFORM, null, msgs);
			if (newTransform != null)
				msgs = ((InternalEObject)newTransform).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RhpGeometryPackage.RHAPSODY_SHAPE__TRANSFORM, null, msgs);
			msgs = basicSetTransform(newTransform, msgs);
			if (msgs != null) msgs.dispatch();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rectangle getRectangle() {
		return rectangle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRectangle(Rectangle newRectangle, NotificationChain msgs) {
		Rectangle oldRectangle = rectangle;
		rectangle = newRectangle;
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRectangle(Rectangle newRectangle) {
		if (newRectangle != rectangle) {
			NotificationChain msgs = null;
			if (rectangle != null)
				msgs = ((InternalEObject)rectangle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RhpGeometryPackage.RHAPSODY_SHAPE__RECTANGLE, null, msgs);
			if (newRectangle != null)
				msgs = ((InternalEObject)newRectangle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RhpGeometryPackage.RHAPSODY_SHAPE__RECTANGLE, null, msgs);
			msgs = basicSetRectangle(newRectangle, msgs);
			if (msgs != null) msgs.dispatch();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RhapsodyShape getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (RhapsodyShape)eResolveProxy(oldParent);
			if (parent != oldParent) {
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RhapsodyShape basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(RhapsodyShape newParent) {
		parent = newParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getRhapsodyMetamodelObject() {
		if (rhapsodyMetamodelObject != null && rhapsodyMetamodelObject.eIsProxy()) {
			InternalEObject oldRhapsodyMetamodelObject = (InternalEObject)rhapsodyMetamodelObject;
			rhapsodyMetamodelObject = eResolveProxy(oldRhapsodyMetamodelObject);
			if (rhapsodyMetamodelObject != oldRhapsodyMetamodelObject) {
			}
		}
		return rhapsodyMetamodelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetRhapsodyMetamodelObject() {
		return rhapsodyMetamodelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRhapsodyMetamodelObject(EObject newRhapsodyMetamodelObject) {
		rhapsodyMetamodelObject = newRhapsodyMetamodelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point getParentRelativePosition() {
		return parentRelativePosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentRelativePosition(Point newParentRelativePosition, NotificationChain msgs) {
		Point oldParentRelativePosition = parentRelativePosition;
		parentRelativePosition = newParentRelativePosition;
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentRelativePosition(Point newParentRelativePosition) {
		if (newParentRelativePosition != parentRelativePosition) {
			NotificationChain msgs = null;
			if (parentRelativePosition != null)
				msgs = ((InternalEObject)parentRelativePosition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RhpGeometryPackage.RHAPSODY_SHAPE__PARENT_RELATIVE_POSITION, null, msgs);
			if (newParentRelativePosition != null)
				msgs = ((InternalEObject)newParentRelativePosition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RhpGeometryPackage.RHAPSODY_SHAPE__PARENT_RELATIVE_POSITION, null, msgs);
			msgs = basicSetParentRelativePosition(newParentRelativePosition, msgs);
			if (msgs != null) msgs.dispatch();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(Integer newHeight) {
		height = newHeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(Integer newWidth) {
		width = newWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point getAbsolutePosition() {
		return absolutePosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAbsolutePosition(Point newAbsolutePosition, NotificationChain msgs) {
		Point oldAbsolutePosition = absolutePosition;
		absolutePosition = newAbsolutePosition;
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbsolutePosition(Point newAbsolutePosition) {
		if (newAbsolutePosition != absolutePosition) {
			NotificationChain msgs = null;
			if (absolutePosition != null)
				msgs = ((InternalEObject)absolutePosition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RhpGeometryPackage.RHAPSODY_SHAPE__ABSOLUTE_POSITION, null, msgs);
			if (newAbsolutePosition != null)
				msgs = ((InternalEObject)newAbsolutePosition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RhpGeometryPackage.RHAPSODY_SHAPE__ABSOLUTE_POSITION, null, msgs);
			msgs = basicSetAbsolutePosition(newAbsolutePosition, msgs);
			if (msgs != null) msgs.dispatch();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RhpGeometryPackage.RHAPSODY_SHAPE__TRANSFORM:
				return basicSetTransform(null, msgs);
			case RhpGeometryPackage.RHAPSODY_SHAPE__RECTANGLE:
				return basicSetRectangle(null, msgs);
			case RhpGeometryPackage.RHAPSODY_SHAPE__PARENT_RELATIVE_POSITION:
				return basicSetParentRelativePosition(null, msgs);
			case RhpGeometryPackage.RHAPSODY_SHAPE__ABSOLUTE_POSITION:
				return basicSetAbsolutePosition(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RhpGeometryPackage.RHAPSODY_SHAPE__TRANSFORM:
				return getTransform();
			case RhpGeometryPackage.RHAPSODY_SHAPE__RECTANGLE:
				return getRectangle();
			case RhpGeometryPackage.RHAPSODY_SHAPE__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case RhpGeometryPackage.RHAPSODY_SHAPE__RHAPSODY_METAMODEL_OBJECT:
				if (resolve) return getRhapsodyMetamodelObject();
				return basicGetRhapsodyMetamodelObject();
			case RhpGeometryPackage.RHAPSODY_SHAPE__PARENT_RELATIVE_POSITION:
				return getParentRelativePosition();
			case RhpGeometryPackage.RHAPSODY_SHAPE__HEIGHT:
				return getHeight();
			case RhpGeometryPackage.RHAPSODY_SHAPE__WIDTH:
				return getWidth();
			case RhpGeometryPackage.RHAPSODY_SHAPE__ABSOLUTE_POSITION:
				return getAbsolutePosition();
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
			case RhpGeometryPackage.RHAPSODY_SHAPE__TRANSFORM:
				setTransform((TransformMatrix)newValue);
				return;
			case RhpGeometryPackage.RHAPSODY_SHAPE__RECTANGLE:
				setRectangle((Rectangle)newValue);
				return;
			case RhpGeometryPackage.RHAPSODY_SHAPE__PARENT:
				setParent((RhapsodyShape)newValue);
				return;
			case RhpGeometryPackage.RHAPSODY_SHAPE__RHAPSODY_METAMODEL_OBJECT:
				setRhapsodyMetamodelObject((EObject)newValue);
				return;
			case RhpGeometryPackage.RHAPSODY_SHAPE__PARENT_RELATIVE_POSITION:
				setParentRelativePosition((Point)newValue);
				return;
			case RhpGeometryPackage.RHAPSODY_SHAPE__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case RhpGeometryPackage.RHAPSODY_SHAPE__WIDTH:
				setWidth((Integer)newValue);
				return;
			case RhpGeometryPackage.RHAPSODY_SHAPE__ABSOLUTE_POSITION:
				setAbsolutePosition((Point)newValue);
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
			case RhpGeometryPackage.RHAPSODY_SHAPE__TRANSFORM:
				setTransform((TransformMatrix)null);
				return;
			case RhpGeometryPackage.RHAPSODY_SHAPE__RECTANGLE:
				setRectangle((Rectangle)null);
				return;
			case RhpGeometryPackage.RHAPSODY_SHAPE__PARENT:
				setParent((RhapsodyShape)null);
				return;
			case RhpGeometryPackage.RHAPSODY_SHAPE__RHAPSODY_METAMODEL_OBJECT:
				setRhapsodyMetamodelObject((EObject)null);
				return;
			case RhpGeometryPackage.RHAPSODY_SHAPE__PARENT_RELATIVE_POSITION:
				setParentRelativePosition((Point)null);
				return;
			case RhpGeometryPackage.RHAPSODY_SHAPE__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case RhpGeometryPackage.RHAPSODY_SHAPE__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case RhpGeometryPackage.RHAPSODY_SHAPE__ABSOLUTE_POSITION:
				setAbsolutePosition((Point)null);
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
			case RhpGeometryPackage.RHAPSODY_SHAPE__TRANSFORM:
				return transform != null;
			case RhpGeometryPackage.RHAPSODY_SHAPE__RECTANGLE:
				return rectangle != null;
			case RhpGeometryPackage.RHAPSODY_SHAPE__PARENT:
				return parent != null;
			case RhpGeometryPackage.RHAPSODY_SHAPE__RHAPSODY_METAMODEL_OBJECT:
				return rhapsodyMetamodelObject != null;
			case RhpGeometryPackage.RHAPSODY_SHAPE__PARENT_RELATIVE_POSITION:
				return parentRelativePosition != null;
			case RhpGeometryPackage.RHAPSODY_SHAPE__HEIGHT:
				return HEIGHT_EDEFAULT == null ? height != null : !HEIGHT_EDEFAULT.equals(height);
			case RhpGeometryPackage.RHAPSODY_SHAPE__WIDTH:
				return WIDTH_EDEFAULT == null ? width != null : !WIDTH_EDEFAULT.equals(width);
			case RhpGeometryPackage.RHAPSODY_SHAPE__ABSOLUTE_POSITION:
				return absolutePosition != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (height: "); //$NON-NLS-1$
		result.append(height);
		result.append(", width: "); //$NON-NLS-1$
		result.append(width);
		result.append(')');
		return result.toString();
	}

} //RhapsodyShapeImpl
