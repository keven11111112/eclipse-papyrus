/**
 * Copyright (c) 2015 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.ExpansionmodelPackage;
import org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.InducedRepresentation;
import org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.Representation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Representation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.impl.RepresentationImpl#getGraphicalElementType <em>Graphical Element Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.impl.RepresentationImpl#getInducedRepresentations <em>Induced Representations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.impl.RepresentationImpl#getSubRepresentations <em>Sub Representations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepresentationImpl extends AbstractRepresentationImpl implements Representation {
	/**
	 * The default value of the '{@link #getGraphicalElementType() <em>Graphical Element Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphicalElementType()
	 * @generated
	 * @ordered
	 */
	protected static final String GRAPHICAL_ELEMENT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGraphicalElementType() <em>Graphical Element Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphicalElementType()
	 * @generated
	 * @ordered
	 */
	protected String graphicalElementType = GRAPHICAL_ELEMENT_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInducedRepresentations() <em>Induced Representations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInducedRepresentations()
	 * @generated
	 * @ordered
	 */
	protected EList<InducedRepresentation> inducedRepresentations;

	/**
	 * The cached value of the '{@link #getSubRepresentations() <em>Sub Representations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubRepresentations()
	 * @generated
	 * @ordered
	 */
	protected EList<Representation> subRepresentations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepresentationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpansionmodelPackage.Literals.REPRESENTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGraphicalElementType() {
		return graphicalElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraphicalElementType(String newGraphicalElementType) {
		String oldGraphicalElementType = graphicalElementType;
		graphicalElementType = newGraphicalElementType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpansionmodelPackage.REPRESENTATION__GRAPHICAL_ELEMENT_TYPE, oldGraphicalElementType, graphicalElementType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InducedRepresentation> getInducedRepresentations() {
		if (inducedRepresentations == null) {
			inducedRepresentations = new EObjectResolvingEList<InducedRepresentation>(InducedRepresentation.class, this, ExpansionmodelPackage.REPRESENTATION__INDUCED_REPRESENTATIONS);
		}
		return inducedRepresentations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Representation> getSubRepresentations() {
		if (subRepresentations == null) {
			subRepresentations = new EObjectResolvingEList<Representation>(Representation.class, this, ExpansionmodelPackage.REPRESENTATION__SUB_REPRESENTATIONS);
		}
		return subRepresentations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpansionmodelPackage.REPRESENTATION__GRAPHICAL_ELEMENT_TYPE:
				return getGraphicalElementType();
			case ExpansionmodelPackage.REPRESENTATION__INDUCED_REPRESENTATIONS:
				return getInducedRepresentations();
			case ExpansionmodelPackage.REPRESENTATION__SUB_REPRESENTATIONS:
				return getSubRepresentations();
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
			case ExpansionmodelPackage.REPRESENTATION__GRAPHICAL_ELEMENT_TYPE:
				setGraphicalElementType((String)newValue);
				return;
			case ExpansionmodelPackage.REPRESENTATION__INDUCED_REPRESENTATIONS:
				getInducedRepresentations().clear();
				getInducedRepresentations().addAll((Collection<? extends InducedRepresentation>)newValue);
				return;
			case ExpansionmodelPackage.REPRESENTATION__SUB_REPRESENTATIONS:
				getSubRepresentations().clear();
				getSubRepresentations().addAll((Collection<? extends Representation>)newValue);
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
			case ExpansionmodelPackage.REPRESENTATION__GRAPHICAL_ELEMENT_TYPE:
				setGraphicalElementType(GRAPHICAL_ELEMENT_TYPE_EDEFAULT);
				return;
			case ExpansionmodelPackage.REPRESENTATION__INDUCED_REPRESENTATIONS:
				getInducedRepresentations().clear();
				return;
			case ExpansionmodelPackage.REPRESENTATION__SUB_REPRESENTATIONS:
				getSubRepresentations().clear();
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
			case ExpansionmodelPackage.REPRESENTATION__GRAPHICAL_ELEMENT_TYPE:
				return GRAPHICAL_ELEMENT_TYPE_EDEFAULT == null ? graphicalElementType != null : !GRAPHICAL_ELEMENT_TYPE_EDEFAULT.equals(graphicalElementType);
			case ExpansionmodelPackage.REPRESENTATION__INDUCED_REPRESENTATIONS:
				return inducedRepresentations != null && !inducedRepresentations.isEmpty();
			case ExpansionmodelPackage.REPRESENTATION__SUB_REPRESENTATIONS:
				return subRepresentations != null && !subRepresentations.isEmpty();
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
		result.append(" (graphicalElementType: ");
		result.append(graphicalElementType);
		result.append(')');
		return result.toString();
	}

} //RepresentationImpl
