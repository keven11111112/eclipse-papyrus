/*******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, ARTAL
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 * 
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     Borland - initial API and implementation
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.gmf.gmfgraph.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.gmf.gmfgraph.ChildAccess;
import org.eclipse.papyrus.gmf.gmfgraph.Direction;
import org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.papyrus.gmf.gmfgraph.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.impl.NodeImpl#getResizeConstraint <em>Resize Constraint</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.impl.NodeImpl#getAffixedParentSide <em>Affixed Parent Side</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.impl.NodeImpl#getContentPane <em>Content Pane</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeImpl extends AbstractNodeImpl implements Node {
	/**
	 * The default value of the '{@link #getResizeConstraint() <em>Resize Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResizeConstraint()
	 * @generated
	 * @ordered
	 */
	protected static final Direction RESIZE_CONSTRAINT_EDEFAULT = Direction.NSEW_LITERAL;

	/**
	 * The cached value of the '{@link #getResizeConstraint() <em>Resize Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResizeConstraint()
	 * @generated
	 * @ordered
	 */
	protected Direction resizeConstraint = RESIZE_CONSTRAINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getAffixedParentSide() <em>Affixed Parent Side</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAffixedParentSide()
	 * @generated
	 * @ordered
	 */
	protected static final Direction AFFIXED_PARENT_SIDE_EDEFAULT = Direction.NONE_LITERAL;

	/**
	 * The cached value of the '{@link #getAffixedParentSide() <em>Affixed Parent Side</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAffixedParentSide()
	 * @generated
	 * @ordered
	 */
	protected Direction affixedParentSide = AFFIXED_PARENT_SIDE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContentPane() <em>Content Pane</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentPane()
	 * @generated
	 * @ordered
	 */
	protected ChildAccess contentPane;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFGraphPackage.eINSTANCE.getNode();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Direction getResizeConstraint() {
		return resizeConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResizeConstraint(Direction newResizeConstraint) {
		Direction oldResizeConstraint = resizeConstraint;
		resizeConstraint = newResizeConstraint == null ? RESIZE_CONSTRAINT_EDEFAULT : newResizeConstraint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGraphPackage.NODE__RESIZE_CONSTRAINT, oldResizeConstraint, resizeConstraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Direction getAffixedParentSide() {
		return affixedParentSide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAffixedParentSide(Direction newAffixedParentSide) {
		Direction oldAffixedParentSide = affixedParentSide;
		affixedParentSide = newAffixedParentSide == null ? AFFIXED_PARENT_SIDE_EDEFAULT : newAffixedParentSide;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGraphPackage.NODE__AFFIXED_PARENT_SIDE, oldAffixedParentSide, affixedParentSide));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildAccess getContentPane() {
		if (contentPane != null && contentPane.eIsProxy()) {
			InternalEObject oldContentPane = (InternalEObject)contentPane;
			contentPane = (ChildAccess)eResolveProxy(oldContentPane);
			if (contentPane != oldContentPane) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFGraphPackage.NODE__CONTENT_PANE, oldContentPane, contentPane));
			}
		}
		return contentPane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildAccess basicGetContentPane() {
		return contentPane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContentPane(ChildAccess newContentPane) {
		ChildAccess oldContentPane = contentPane;
		contentPane = newContentPane;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGraphPackage.NODE__CONTENT_PANE, oldContentPane, contentPane));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFGraphPackage.NODE__RESIZE_CONSTRAINT:
				return getResizeConstraint();
			case GMFGraphPackage.NODE__AFFIXED_PARENT_SIDE:
				return getAffixedParentSide();
			case GMFGraphPackage.NODE__CONTENT_PANE:
				if (resolve) return getContentPane();
				return basicGetContentPane();
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
			case GMFGraphPackage.NODE__RESIZE_CONSTRAINT:
				setResizeConstraint((Direction)newValue);
				return;
			case GMFGraphPackage.NODE__AFFIXED_PARENT_SIDE:
				setAffixedParentSide((Direction)newValue);
				return;
			case GMFGraphPackage.NODE__CONTENT_PANE:
				setContentPane((ChildAccess)newValue);
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
			case GMFGraphPackage.NODE__RESIZE_CONSTRAINT:
				setResizeConstraint(RESIZE_CONSTRAINT_EDEFAULT);
				return;
			case GMFGraphPackage.NODE__AFFIXED_PARENT_SIDE:
				setAffixedParentSide(AFFIXED_PARENT_SIDE_EDEFAULT);
				return;
			case GMFGraphPackage.NODE__CONTENT_PANE:
				setContentPane((ChildAccess)null);
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
			case GMFGraphPackage.NODE__RESIZE_CONSTRAINT:
				return resizeConstraint != RESIZE_CONSTRAINT_EDEFAULT;
			case GMFGraphPackage.NODE__AFFIXED_PARENT_SIDE:
				return affixedParentSide != AFFIXED_PARENT_SIDE_EDEFAULT;
			case GMFGraphPackage.NODE__CONTENT_PANE:
				return contentPane != null;
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
		result.append(" (resizeConstraint: ");
		result.append(resizeConstraint);
		result.append(", affixedParentSide: ");
		result.append(affixedParentSide);
		result.append(')');
		return result.toString();
	}

} //NodeImpl
