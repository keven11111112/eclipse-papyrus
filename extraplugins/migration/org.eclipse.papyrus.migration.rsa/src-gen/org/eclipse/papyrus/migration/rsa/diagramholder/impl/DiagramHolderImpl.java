/**
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.migration.rsa.diagramholder.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EAnnotationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.gmf.runtime.notation.Diagram;

import org.eclipse.papyrus.migration.rsa.diagramholder.DiagramHolder;
import org.eclipse.papyrus.migration.rsa.diagramholder.DiagramHolderPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram Holder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rsa.diagramholder.impl.DiagramHolderImpl#getOwnedDiagrams <em>Owned Diagrams</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DiagramHolderImpl extends EAnnotationImpl implements DiagramHolder {
	/**
	 * The cached value of the '{@link #getOwnedDiagrams() <em>Owned Diagrams</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<Diagram> ownedDiagrams;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramHolderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramHolderPackage.Literals.DIAGRAM_HOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Diagram> getOwnedDiagrams() {
		if (ownedDiagrams == null) {
			ownedDiagrams = new EObjectResolvingEList<Diagram>(Diagram.class, this, DiagramHolderPackage.DIAGRAM_HOLDER__OWNED_DIAGRAMS);
		}
		return ownedDiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagramHolderPackage.DIAGRAM_HOLDER__OWNED_DIAGRAMS:
				return getOwnedDiagrams();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DiagramHolderPackage.DIAGRAM_HOLDER__OWNED_DIAGRAMS:
				getOwnedDiagrams().clear();
				getOwnedDiagrams().addAll((Collection<? extends Diagram>)newValue);
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
			case DiagramHolderPackage.DIAGRAM_HOLDER__OWNED_DIAGRAMS:
				getOwnedDiagrams().clear();
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
			case DiagramHolderPackage.DIAGRAM_HOLDER__OWNED_DIAGRAMS:
				return ownedDiagrams != null && !ownedDiagrams.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DiagramHolderImpl
