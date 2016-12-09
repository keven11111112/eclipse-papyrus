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
package org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICollaboration;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICollaborationDiagram;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ICollaboration Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICollaborationDiagramImpl#getM_pICollaboration <em>MpI Collaboration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ICollaborationDiagramImpl extends IDiagramImpl implements ICollaborationDiagram {
	/**
	 * The cached value of the '{@link #getM_pICollaboration() <em>MpI Collaboration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pICollaboration()
	 * @generated
	 * @ordered
	 */
	protected ICollaboration m_pICollaboration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ICollaborationDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getICollaborationDiagram();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICollaboration getM_pICollaboration() {
		if (m_pICollaboration != null && m_pICollaboration.eIsProxy()) {
			InternalEObject oldM_pICollaboration = (InternalEObject)m_pICollaboration;
			m_pICollaboration = (ICollaboration)eResolveProxy(oldM_pICollaboration);
			if (m_pICollaboration != oldM_pICollaboration) {
				InternalEObject newM_pICollaboration = (InternalEObject)m_pICollaboration;
				NotificationChain msgs = oldM_pICollaboration.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOLLABORATION_DIAGRAM__MPI_COLLABORATION, null, null);
				if (newM_pICollaboration.eInternalContainer() == null) {
					msgs = newM_pICollaboration.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOLLABORATION_DIAGRAM__MPI_COLLABORATION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICOLLABORATION_DIAGRAM__MPI_COLLABORATION, oldM_pICollaboration, m_pICollaboration));
			}
		}
		return m_pICollaboration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICollaboration basicGetM_pICollaboration() {
		return m_pICollaboration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_pICollaboration(ICollaboration newM_pICollaboration, NotificationChain msgs) {
		ICollaboration oldM_pICollaboration = m_pICollaboration;
		m_pICollaboration = newM_pICollaboration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOLLABORATION_DIAGRAM__MPI_COLLABORATION, oldM_pICollaboration, newM_pICollaboration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pICollaboration(ICollaboration newM_pICollaboration) {
		if (newM_pICollaboration != m_pICollaboration) {
			NotificationChain msgs = null;
			if (m_pICollaboration != null)
				msgs = ((InternalEObject)m_pICollaboration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOLLABORATION_DIAGRAM__MPI_COLLABORATION, null, msgs);
			if (newM_pICollaboration != null)
				msgs = ((InternalEObject)newM_pICollaboration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOLLABORATION_DIAGRAM__MPI_COLLABORATION, null, msgs);
			msgs = basicSetM_pICollaboration(newM_pICollaboration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOLLABORATION_DIAGRAM__MPI_COLLABORATION, newM_pICollaboration, newM_pICollaboration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.ICOLLABORATION_DIAGRAM__MPI_COLLABORATION:
				return basicSetM_pICollaboration(null, msgs);
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
			case UMLRhapsodyPackage.ICOLLABORATION_DIAGRAM__MPI_COLLABORATION:
				if (resolve) return getM_pICollaboration();
				return basicGetM_pICollaboration();
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
			case UMLRhapsodyPackage.ICOLLABORATION_DIAGRAM__MPI_COLLABORATION:
				setM_pICollaboration((ICollaboration)newValue);
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
			case UMLRhapsodyPackage.ICOLLABORATION_DIAGRAM__MPI_COLLABORATION:
				setM_pICollaboration((ICollaboration)null);
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
			case UMLRhapsodyPackage.ICOLLABORATION_DIAGRAM__MPI_COLLABORATION:
				return m_pICollaboration != null;
		}
		return super.eIsSet(featureID);
	}

} //ICollaborationDiagramImpl
