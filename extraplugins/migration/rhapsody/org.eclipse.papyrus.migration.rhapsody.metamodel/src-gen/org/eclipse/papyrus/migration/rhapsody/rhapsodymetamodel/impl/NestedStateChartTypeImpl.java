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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIStateChart;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItsTargetType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.NestedStateChartType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TransitionsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nested State Chart Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.NestedStateChartTypeImpl#getDefNumber <em>Def Number</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.NestedStateChartTypeImpl#getGraphicChart <em>Graphic Chart</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.NestedStateChartTypeImpl#getLastModifiedTime <em>Last Modified Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.NestedStateChartTypeImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.NestedStateChartTypeImpl#getConnectors <em>Connectors</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.NestedStateChartTypeImpl#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NestedStateChartTypeImpl extends ItsStateChartTypeImpl implements NestedStateChartType {
	/**
	 * The default value of the '{@link #getDefNumber() <em>Def Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String DEF_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefNumber() <em>Def Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefNumber()
	 * @generated
	 * @ordered
	 */
	protected String defNumber = DEF_NUMBER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGraphicChart() <em>Graphic Chart</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphicChart()
	 * @generated
	 * @ordered
	 */
	protected CGIStateChart graphicChart;

	/**
	 * The default value of the '{@link #getLastModifiedTime() <em>Last Modified Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastModifiedTime()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_MODIFIED_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastModifiedTime() <em>Last Modified Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastModifiedTime()
	 * @generated
	 * @ordered
	 */
	protected String lastModifiedTime = LAST_MODIFIED_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<TransitionsType> transitions;

	/**
	 * The cached value of the '{@link #getConnectors() <em>Connectors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectors()
	 * @generated
	 * @ordered
	 */
	protected EList<ItsTargetType> connectors;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected EList<String> version;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NestedStateChartTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getNestedStateChartType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefNumber() {
		return defNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefNumber(String newDefNumber) {
		String oldDefNumber = defNumber;
		defNumber = newDefNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__DEF_NUMBER, oldDefNumber, defNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIStateChart getGraphicChart() {
		if (graphicChart != null && graphicChart.eIsProxy()) {
			InternalEObject oldGraphicChart = (InternalEObject)graphicChart;
			graphicChart = (CGIStateChart)eResolveProxy(oldGraphicChart);
			if (graphicChart != oldGraphicChart) {
				InternalEObject newGraphicChart = (InternalEObject)graphicChart;
				NotificationChain msgs = oldGraphicChart.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__GRAPHIC_CHART, null, null);
				if (newGraphicChart.eInternalContainer() == null) {
					msgs = newGraphicChart.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__GRAPHIC_CHART, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__GRAPHIC_CHART, oldGraphicChart, graphicChart));
			}
		}
		return graphicChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIStateChart basicGetGraphicChart() {
		return graphicChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraphicChart(CGIStateChart newGraphicChart, NotificationChain msgs) {
		CGIStateChart oldGraphicChart = graphicChart;
		graphicChart = newGraphicChart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__GRAPHIC_CHART, oldGraphicChart, newGraphicChart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraphicChart(CGIStateChart newGraphicChart) {
		if (newGraphicChart != graphicChart) {
			NotificationChain msgs = null;
			if (graphicChart != null)
				msgs = ((InternalEObject)graphicChart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__GRAPHIC_CHART, null, msgs);
			if (newGraphicChart != null)
				msgs = ((InternalEObject)newGraphicChart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__GRAPHIC_CHART, null, msgs);
			msgs = basicSetGraphicChart(newGraphicChart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__GRAPHIC_CHART, newGraphicChart, newGraphicChart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastModifiedTime() {
		return lastModifiedTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastModifiedTime(String newLastModifiedTime) {
		String oldLastModifiedTime = lastModifiedTime;
		lastModifiedTime = newLastModifiedTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__LAST_MODIFIED_TIME, oldLastModifiedTime, lastModifiedTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TransitionsType> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectContainmentEList.Resolving<TransitionsType>(TransitionsType.class, this, UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__TRANSITIONS);
		}
		return transitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ItsTargetType> getConnectors() {
		if (connectors == null) {
			connectors = new EObjectContainmentEList.Resolving<ItsTargetType>(ItsTargetType.class, this, UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__CONNECTORS);
		}
		return connectors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getVersion() {
		if (version == null) {
			version = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__VERSION);
		}
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__GRAPHIC_CHART:
				return basicSetGraphicChart(null, msgs);
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__TRANSITIONS:
				return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__CONNECTORS:
				return ((InternalEList<?>)getConnectors()).basicRemove(otherEnd, msgs);
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
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__DEF_NUMBER:
				return getDefNumber();
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__GRAPHIC_CHART:
				if (resolve) return getGraphicChart();
				return basicGetGraphicChart();
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__LAST_MODIFIED_TIME:
				return getLastModifiedTime();
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__TRANSITIONS:
				return getTransitions();
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__CONNECTORS:
				return getConnectors();
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__VERSION:
				return getVersion();
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
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__DEF_NUMBER:
				setDefNumber((String)newValue);
				return;
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__GRAPHIC_CHART:
				setGraphicChart((CGIStateChart)newValue);
				return;
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__LAST_MODIFIED_TIME:
				setLastModifiedTime((String)newValue);
				return;
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends TransitionsType>)newValue);
				return;
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__CONNECTORS:
				getConnectors().clear();
				getConnectors().addAll((Collection<? extends ItsTargetType>)newValue);
				return;
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__VERSION:
				getVersion().clear();
				getVersion().addAll((Collection<? extends String>)newValue);
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
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__DEF_NUMBER:
				setDefNumber(DEF_NUMBER_EDEFAULT);
				return;
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__GRAPHIC_CHART:
				setGraphicChart((CGIStateChart)null);
				return;
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__LAST_MODIFIED_TIME:
				setLastModifiedTime(LAST_MODIFIED_TIME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__TRANSITIONS:
				getTransitions().clear();
				return;
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__CONNECTORS:
				getConnectors().clear();
				return;
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__VERSION:
				getVersion().clear();
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
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__DEF_NUMBER:
				return DEF_NUMBER_EDEFAULT == null ? defNumber != null : !DEF_NUMBER_EDEFAULT.equals(defNumber);
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__GRAPHIC_CHART:
				return graphicChart != null;
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__LAST_MODIFIED_TIME:
				return LAST_MODIFIED_TIME_EDEFAULT == null ? lastModifiedTime != null : !LAST_MODIFIED_TIME_EDEFAULT.equals(lastModifiedTime);
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__TRANSITIONS:
				return transitions != null && !transitions.isEmpty();
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__CONNECTORS:
				return connectors != null && !connectors.isEmpty();
			case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__VERSION:
				return version != null && !version.isEmpty();
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
		result.append(" (defNumber: "); //$NON-NLS-1$
		result.append(defNumber);
		result.append(", lastModifiedTime: "); //$NON-NLS-1$
		result.append(lastModifiedTime);
		result.append(", version: "); //$NON-NLS-1$
		result.append(version);
		result.append(')');
		return result.toString();
	}

} //NestedStateChartTypeImpl
