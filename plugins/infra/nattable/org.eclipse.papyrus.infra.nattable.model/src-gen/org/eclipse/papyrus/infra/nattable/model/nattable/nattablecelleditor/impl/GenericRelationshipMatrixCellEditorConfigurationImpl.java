/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablecelleditor.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.emf.expressions.booleanexpressions.IBooleanEObjectExpression;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecelleditor.GenericRelationshipMatrixCellEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecelleditor.MatrixRelationShipDirection;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecelleditor.NattablecelleditorPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.impl.StyledElementImpl;

import org.eclipse.papyrus.infra.types.ElementTypeConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Relationship Matrix Cell Editor Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecelleditor.impl.GenericRelationshipMatrixCellEditorConfigurationImpl#getCellEditorId <em>Cell Editor Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecelleditor.impl.GenericRelationshipMatrixCellEditorConfigurationImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecelleditor.impl.GenericRelationshipMatrixCellEditorConfigurationImpl#getCellContentsFilter <em>Cell Contents Filter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecelleditor.impl.GenericRelationshipMatrixCellEditorConfigurationImpl#getEditedElement <em>Edited Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenericRelationshipMatrixCellEditorConfigurationImpl extends StyledElementImpl implements GenericRelationshipMatrixCellEditorConfiguration {
	/**
	 * The default value of the '{@link #getCellEditorId() <em>Cell Editor Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCellEditorId()
	 * @generated
	 * @ordered
	 */
	protected static final String CELL_EDITOR_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCellEditorId() <em>Cell Editor Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCellEditorId()
	 * @generated
	 * @ordered
	 */
	protected String cellEditorId = CELL_EDITOR_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final MatrixRelationShipDirection DIRECTION_EDEFAULT = MatrixRelationShipDirection.FROM_ROW_TO_COLUMN;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected MatrixRelationShipDirection direction = DIRECTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCellContentsFilter() <em>Cell Contents Filter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCellContentsFilter()
	 * @generated
	 * @ordered
	 */
	protected IBooleanEObjectExpression cellContentsFilter;

	/**
	 * The cached value of the '{@link #getEditedElement() <em>Edited Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditedElement()
	 * @generated
	 * @ordered
	 */
	protected ElementTypeConfiguration editedElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenericRelationshipMatrixCellEditorConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCellEditorId() {
		return cellEditorId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCellEditorId(String newCellEditorId) {
		String oldCellEditorId = cellEditorId;
		cellEditorId = newCellEditorId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_EDITOR_ID, oldCellEditorId, cellEditorId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatrixRelationShipDirection getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(MatrixRelationShipDirection newDirection) {
		MatrixRelationShipDirection oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__DIRECTION, oldDirection, direction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IBooleanEObjectExpression getCellContentsFilter() {
		return cellContentsFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCellContentsFilter(IBooleanEObjectExpression newCellContentsFilter, NotificationChain msgs) {
		IBooleanEObjectExpression oldCellContentsFilter = cellContentsFilter;
		cellContentsFilter = newCellContentsFilter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_CONTENTS_FILTER, oldCellContentsFilter, newCellContentsFilter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCellContentsFilter(IBooleanEObjectExpression newCellContentsFilter) {
		if (newCellContentsFilter != cellContentsFilter) {
			NotificationChain msgs = null;
			if (cellContentsFilter != null)
				msgs = ((InternalEObject)cellContentsFilter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_CONTENTS_FILTER, null, msgs);
			if (newCellContentsFilter != null)
				msgs = ((InternalEObject)newCellContentsFilter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_CONTENTS_FILTER, null, msgs);
			msgs = basicSetCellContentsFilter(newCellContentsFilter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_CONTENTS_FILTER, newCellContentsFilter, newCellContentsFilter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementTypeConfiguration getEditedElement() {
		if (editedElement != null && editedElement.eIsProxy()) {
			InternalEObject oldEditedElement = (InternalEObject)editedElement;
			editedElement = (ElementTypeConfiguration)eResolveProxy(oldEditedElement);
			if (editedElement != oldEditedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__EDITED_ELEMENT, oldEditedElement, editedElement));
			}
		}
		return editedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementTypeConfiguration basicGetEditedElement() {
		return editedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditedElement(ElementTypeConfiguration newEditedElement) {
		ElementTypeConfiguration oldEditedElement = editedElement;
		editedElement = newEditedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__EDITED_ELEMENT, oldEditedElement, editedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_CONTENTS_FILTER:
				return basicSetCellContentsFilter(null, msgs);
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
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_EDITOR_ID:
				return getCellEditorId();
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__DIRECTION:
				return getDirection();
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_CONTENTS_FILTER:
				return getCellContentsFilter();
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__EDITED_ELEMENT:
				if (resolve) return getEditedElement();
				return basicGetEditedElement();
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
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_EDITOR_ID:
				setCellEditorId((String)newValue);
				return;
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__DIRECTION:
				setDirection((MatrixRelationShipDirection)newValue);
				return;
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_CONTENTS_FILTER:
				setCellContentsFilter((IBooleanEObjectExpression)newValue);
				return;
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__EDITED_ELEMENT:
				setEditedElement((ElementTypeConfiguration)newValue);
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
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_EDITOR_ID:
				setCellEditorId(CELL_EDITOR_ID_EDEFAULT);
				return;
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__DIRECTION:
				setDirection(DIRECTION_EDEFAULT);
				return;
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_CONTENTS_FILTER:
				setCellContentsFilter((IBooleanEObjectExpression)null);
				return;
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__EDITED_ELEMENT:
				setEditedElement((ElementTypeConfiguration)null);
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
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_EDITOR_ID:
				return CELL_EDITOR_ID_EDEFAULT == null ? cellEditorId != null : !CELL_EDITOR_ID_EDEFAULT.equals(cellEditorId);
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__DIRECTION:
				return direction != DIRECTION_EDEFAULT;
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_CONTENTS_FILTER:
				return cellContentsFilter != null;
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__EDITED_ELEMENT:
				return editedElement != null;
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
		result.append(" (cellEditorId: "); //$NON-NLS-1$
		result.append(cellEditorId);
		result.append(", direction: "); //$NON-NLS-1$
		result.append(direction);
		result.append(')');
		return result.toString();
	}

} //GenericRelationshipMatrixCellEditorConfigurationImpl
