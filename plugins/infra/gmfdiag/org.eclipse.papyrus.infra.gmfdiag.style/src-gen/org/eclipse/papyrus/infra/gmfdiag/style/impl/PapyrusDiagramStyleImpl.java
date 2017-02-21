/**
 * Copyright (c) 2013 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.gmfdiag.style.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.infra.gmfdiag.representation.PapyrusDiagram;
import org.eclipse.papyrus.infra.gmfdiag.style.PapyrusDiagramStyle;
import org.eclipse.papyrus.infra.gmfdiag.style.StylePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Papyrus Diagram Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.style.impl.PapyrusDiagramStyleImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.style.impl.PapyrusDiagramStyleImpl#getDiagramKind <em>Diagram Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PapyrusDiagramStyleImpl extends MinimalEObjectImpl.Container implements PapyrusDiagramStyle {
	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected EObject owner;

	/**
	 * The cached value of the '{@link #getDiagramKind() <em>Diagram Kind</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramKind()
	 * @generated
	 * @ordered
	 */
	protected PapyrusDiagram diagramKind;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PapyrusDiagramStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StylePackage.Literals.PAPYRUS_DIAGRAM_STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getOwner() {
		if (owner != null && owner.eIsProxy()) {
			InternalEObject oldOwner = (InternalEObject)owner;
			owner = eResolveProxy(oldOwner);
			if (owner != oldOwner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StylePackage.PAPYRUS_DIAGRAM_STYLE__OWNER, oldOwner, owner));
			}
		}
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(EObject newOwner) {
		EObject oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StylePackage.PAPYRUS_DIAGRAM_STYLE__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusDiagram getDiagramKind() {
		if (diagramKind != null && diagramKind.eIsProxy()) {
			InternalEObject oldDiagramKind = (InternalEObject)diagramKind;
			diagramKind = (PapyrusDiagram)eResolveProxy(oldDiagramKind);
			if (diagramKind != oldDiagramKind) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StylePackage.PAPYRUS_DIAGRAM_STYLE__DIAGRAM_KIND, oldDiagramKind, diagramKind));
			}
		}
		return diagramKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusDiagram basicGetDiagramKind() {
		return diagramKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagramKind(PapyrusDiagram newDiagramKind) {
		PapyrusDiagram oldDiagramKind = diagramKind;
		diagramKind = newDiagramKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StylePackage.PAPYRUS_DIAGRAM_STYLE__DIAGRAM_KIND, oldDiagramKind, diagramKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StylePackage.PAPYRUS_DIAGRAM_STYLE__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case StylePackage.PAPYRUS_DIAGRAM_STYLE__DIAGRAM_KIND:
				if (resolve) return getDiagramKind();
				return basicGetDiagramKind();
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
			case StylePackage.PAPYRUS_DIAGRAM_STYLE__OWNER:
				setOwner((EObject)newValue);
				return;
			case StylePackage.PAPYRUS_DIAGRAM_STYLE__DIAGRAM_KIND:
				setDiagramKind((PapyrusDiagram)newValue);
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
			case StylePackage.PAPYRUS_DIAGRAM_STYLE__OWNER:
				setOwner((EObject)null);
				return;
			case StylePackage.PAPYRUS_DIAGRAM_STYLE__DIAGRAM_KIND:
				setDiagramKind((PapyrusDiagram)null);
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
			case StylePackage.PAPYRUS_DIAGRAM_STYLE__OWNER:
				return owner != null;
			case StylePackage.PAPYRUS_DIAGRAM_STYLE__DIAGRAM_KIND:
				return diagramKind != null;
		}
		return super.eIsSet(featureID);
	}

} //PapyrusDiagramStyleImpl
