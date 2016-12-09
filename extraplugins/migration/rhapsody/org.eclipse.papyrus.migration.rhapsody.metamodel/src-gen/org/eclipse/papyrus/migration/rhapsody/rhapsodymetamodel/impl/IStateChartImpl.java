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
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStateChart;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStateChartDiagram;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItsStateChartType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItsTargetType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.NestedStateChartType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TransitionsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IState Chart</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateChartImpl#getDefNumber <em>Def Number</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateChartImpl#getGraphicChart <em>Graphic Chart</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateChartImpl#getLastModifiedTime <em>Last Modified Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateChartImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateChartImpl#getConnectors <em>Connectors</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateChartImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateChartImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateChartImpl#getBaseVersion <em>Base Version</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateChartImpl#getDiagram <em>Diagram</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateChartImpl#getViews <em>Views</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateChartImpl#getInheritsFromHandle <em>Inherits From Handle</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IStateChartImpl extends IClassImpl implements IStateChart {
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
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<IState> states;

	/**
	 * The cached value of the '{@link #getBaseVersion() <em>Base Version</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseVersion()
	 * @generated
	 * @ordered
	 */
	protected EList<String> baseVersion;

	/**
	 * The cached value of the '{@link #getDiagram() <em>Diagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagram()
	 * @generated
	 * @ordered
	 */
	protected IStateChartDiagram diagram;

	/**
	 * The cached value of the '{@link #getViews() <em>Views</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViews()
	 * @generated
	 * @ordered
	 */
	protected IStateChartDiagram views;

	/**
	 * The cached value of the '{@link #getInheritsFromHandle() <em>Inherits From Handle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritsFromHandle()
	 * @generated
	 * @ordered
	 */
	protected IStateChart inheritsFromHandle;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IStateChartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIStateChart();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE_CHART__DEF_NUMBER, oldDefNumber, defNumber));
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
				NotificationChain msgs = oldGraphicChart.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE_CHART__GRAPHIC_CHART, null, null);
				if (newGraphicChart.eInternalContainer() == null) {
					msgs = newGraphicChart.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE_CHART__GRAPHIC_CHART, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISTATE_CHART__GRAPHIC_CHART, oldGraphicChart, graphicChart));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE_CHART__GRAPHIC_CHART, oldGraphicChart, newGraphicChart);
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
				msgs = ((InternalEObject)graphicChart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE_CHART__GRAPHIC_CHART, null, msgs);
			if (newGraphicChart != null)
				msgs = ((InternalEObject)newGraphicChart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE_CHART__GRAPHIC_CHART, null, msgs);
			msgs = basicSetGraphicChart(newGraphicChart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE_CHART__GRAPHIC_CHART, newGraphicChart, newGraphicChart));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE_CHART__LAST_MODIFIED_TIME, oldLastModifiedTime, lastModifiedTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TransitionsType> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectContainmentEList.Resolving<TransitionsType>(TransitionsType.class, this, UMLRhapsodyPackage.ISTATE_CHART__TRANSITIONS);
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
			connectors = new EObjectContainmentEList.Resolving<ItsTargetType>(ItsTargetType.class, this, UMLRhapsodyPackage.ISTATE_CHART__CONNECTORS);
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
			version = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ISTATE_CHART__VERSION);
		}
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IState> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList.Resolving<IState>(IState.class, this, UMLRhapsodyPackage.ISTATE_CHART__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getBaseVersion() {
		if (baseVersion == null) {
			baseVersion = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ISTATE_CHART__BASE_VERSION);
		}
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStateChartDiagram getDiagram() {
		if (diagram != null && diagram.eIsProxy()) {
			InternalEObject oldDiagram = (InternalEObject)diagram;
			diagram = (IStateChartDiagram)eResolveProxy(oldDiagram);
			if (diagram != oldDiagram) {
				InternalEObject newDiagram = (InternalEObject)diagram;
				NotificationChain msgs = oldDiagram.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE_CHART__DIAGRAM, null, null);
				if (newDiagram.eInternalContainer() == null) {
					msgs = newDiagram.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE_CHART__DIAGRAM, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISTATE_CHART__DIAGRAM, oldDiagram, diagram));
			}
		}
		return diagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStateChartDiagram basicGetDiagram() {
		return diagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDiagram(IStateChartDiagram newDiagram, NotificationChain msgs) {
		IStateChartDiagram oldDiagram = diagram;
		diagram = newDiagram;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE_CHART__DIAGRAM, oldDiagram, newDiagram);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagram(IStateChartDiagram newDiagram) {
		if (newDiagram != diagram) {
			NotificationChain msgs = null;
			if (diagram != null)
				msgs = ((InternalEObject)diagram).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE_CHART__DIAGRAM, null, msgs);
			if (newDiagram != null)
				msgs = ((InternalEObject)newDiagram).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE_CHART__DIAGRAM, null, msgs);
			msgs = basicSetDiagram(newDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE_CHART__DIAGRAM, newDiagram, newDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStateChartDiagram getViews() {
		if (views != null && views.eIsProxy()) {
			InternalEObject oldViews = (InternalEObject)views;
			views = (IStateChartDiagram)eResolveProxy(oldViews);
			if (views != oldViews) {
				InternalEObject newViews = (InternalEObject)views;
				NotificationChain msgs = oldViews.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE_CHART__VIEWS, null, null);
				if (newViews.eInternalContainer() == null) {
					msgs = newViews.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE_CHART__VIEWS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISTATE_CHART__VIEWS, oldViews, views));
			}
		}
		return views;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStateChartDiagram basicGetViews() {
		return views;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetViews(IStateChartDiagram newViews, NotificationChain msgs) {
		IStateChartDiagram oldViews = views;
		views = newViews;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE_CHART__VIEWS, oldViews, newViews);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViews(IStateChartDiagram newViews) {
		if (newViews != views) {
			NotificationChain msgs = null;
			if (views != null)
				msgs = ((InternalEObject)views).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE_CHART__VIEWS, null, msgs);
			if (newViews != null)
				msgs = ((InternalEObject)newViews).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE_CHART__VIEWS, null, msgs);
			msgs = basicSetViews(newViews, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE_CHART__VIEWS, newViews, newViews));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStateChart getInheritsFromHandle() {
		if (inheritsFromHandle != null && inheritsFromHandle.eIsProxy()) {
			InternalEObject oldInheritsFromHandle = (InternalEObject)inheritsFromHandle;
			inheritsFromHandle = (IStateChart)eResolveProxy(oldInheritsFromHandle);
			if (inheritsFromHandle != oldInheritsFromHandle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISTATE_CHART__INHERITS_FROM_HANDLE, oldInheritsFromHandle, inheritsFromHandle));
			}
		}
		return inheritsFromHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStateChart basicGetInheritsFromHandle() {
		return inheritsFromHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritsFromHandle(IStateChart newInheritsFromHandle) {
		IStateChart oldInheritsFromHandle = inheritsFromHandle;
		inheritsFromHandle = newInheritsFromHandle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE_CHART__INHERITS_FROM_HANDLE, oldInheritsFromHandle, inheritsFromHandle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.ISTATE_CHART__GRAPHIC_CHART:
				return basicSetGraphicChart(null, msgs);
			case UMLRhapsodyPackage.ISTATE_CHART__TRANSITIONS:
				return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ISTATE_CHART__CONNECTORS:
				return ((InternalEList<?>)getConnectors()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ISTATE_CHART__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ISTATE_CHART__DIAGRAM:
				return basicSetDiagram(null, msgs);
			case UMLRhapsodyPackage.ISTATE_CHART__VIEWS:
				return basicSetViews(null, msgs);
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
			case UMLRhapsodyPackage.ISTATE_CHART__DEF_NUMBER:
				return getDefNumber();
			case UMLRhapsodyPackage.ISTATE_CHART__GRAPHIC_CHART:
				if (resolve) return getGraphicChart();
				return basicGetGraphicChart();
			case UMLRhapsodyPackage.ISTATE_CHART__LAST_MODIFIED_TIME:
				return getLastModifiedTime();
			case UMLRhapsodyPackage.ISTATE_CHART__TRANSITIONS:
				return getTransitions();
			case UMLRhapsodyPackage.ISTATE_CHART__CONNECTORS:
				return getConnectors();
			case UMLRhapsodyPackage.ISTATE_CHART__VERSION:
				return getVersion();
			case UMLRhapsodyPackage.ISTATE_CHART__STATES:
				return getStates();
			case UMLRhapsodyPackage.ISTATE_CHART__BASE_VERSION:
				return getBaseVersion();
			case UMLRhapsodyPackage.ISTATE_CHART__DIAGRAM:
				if (resolve) return getDiagram();
				return basicGetDiagram();
			case UMLRhapsodyPackage.ISTATE_CHART__VIEWS:
				if (resolve) return getViews();
				return basicGetViews();
			case UMLRhapsodyPackage.ISTATE_CHART__INHERITS_FROM_HANDLE:
				if (resolve) return getInheritsFromHandle();
				return basicGetInheritsFromHandle();
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
			case UMLRhapsodyPackage.ISTATE_CHART__DEF_NUMBER:
				setDefNumber((String)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__GRAPHIC_CHART:
				setGraphicChart((CGIStateChart)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__LAST_MODIFIED_TIME:
				setLastModifiedTime((String)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends TransitionsType>)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__CONNECTORS:
				getConnectors().clear();
				getConnectors().addAll((Collection<? extends ItsTargetType>)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__VERSION:
				getVersion().clear();
				getVersion().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends IState>)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__BASE_VERSION:
				getBaseVersion().clear();
				getBaseVersion().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__DIAGRAM:
				setDiagram((IStateChartDiagram)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__VIEWS:
				setViews((IStateChartDiagram)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__INHERITS_FROM_HANDLE:
				setInheritsFromHandle((IStateChart)newValue);
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
			case UMLRhapsodyPackage.ISTATE_CHART__DEF_NUMBER:
				setDefNumber(DEF_NUMBER_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__GRAPHIC_CHART:
				setGraphicChart((CGIStateChart)null);
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__LAST_MODIFIED_TIME:
				setLastModifiedTime(LAST_MODIFIED_TIME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__TRANSITIONS:
				getTransitions().clear();
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__CONNECTORS:
				getConnectors().clear();
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__VERSION:
				getVersion().clear();
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__STATES:
				getStates().clear();
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__BASE_VERSION:
				getBaseVersion().clear();
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__DIAGRAM:
				setDiagram((IStateChartDiagram)null);
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__VIEWS:
				setViews((IStateChartDiagram)null);
				return;
			case UMLRhapsodyPackage.ISTATE_CHART__INHERITS_FROM_HANDLE:
				setInheritsFromHandle((IStateChart)null);
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
			case UMLRhapsodyPackage.ISTATE_CHART__DEF_NUMBER:
				return DEF_NUMBER_EDEFAULT == null ? defNumber != null : !DEF_NUMBER_EDEFAULT.equals(defNumber);
			case UMLRhapsodyPackage.ISTATE_CHART__GRAPHIC_CHART:
				return graphicChart != null;
			case UMLRhapsodyPackage.ISTATE_CHART__LAST_MODIFIED_TIME:
				return LAST_MODIFIED_TIME_EDEFAULT == null ? lastModifiedTime != null : !LAST_MODIFIED_TIME_EDEFAULT.equals(lastModifiedTime);
			case UMLRhapsodyPackage.ISTATE_CHART__TRANSITIONS:
				return transitions != null && !transitions.isEmpty();
			case UMLRhapsodyPackage.ISTATE_CHART__CONNECTORS:
				return connectors != null && !connectors.isEmpty();
			case UMLRhapsodyPackage.ISTATE_CHART__VERSION:
				return version != null && !version.isEmpty();
			case UMLRhapsodyPackage.ISTATE_CHART__STATES:
				return states != null && !states.isEmpty();
			case UMLRhapsodyPackage.ISTATE_CHART__BASE_VERSION:
				return baseVersion != null && !baseVersion.isEmpty();
			case UMLRhapsodyPackage.ISTATE_CHART__DIAGRAM:
				return diagram != null;
			case UMLRhapsodyPackage.ISTATE_CHART__VIEWS:
				return views != null;
			case UMLRhapsodyPackage.ISTATE_CHART__INHERITS_FROM_HANDLE:
				return inheritsFromHandle != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ItsStateChartType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == NestedStateChartType.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.ISTATE_CHART__DEF_NUMBER: return UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__DEF_NUMBER;
				case UMLRhapsodyPackage.ISTATE_CHART__GRAPHIC_CHART: return UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__GRAPHIC_CHART;
				case UMLRhapsodyPackage.ISTATE_CHART__LAST_MODIFIED_TIME: return UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__LAST_MODIFIED_TIME;
				case UMLRhapsodyPackage.ISTATE_CHART__TRANSITIONS: return UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__TRANSITIONS;
				case UMLRhapsodyPackage.ISTATE_CHART__CONNECTORS: return UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__CONNECTORS;
				case UMLRhapsodyPackage.ISTATE_CHART__VERSION: return UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__VERSION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ItsStateChartType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == NestedStateChartType.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__DEF_NUMBER: return UMLRhapsodyPackage.ISTATE_CHART__DEF_NUMBER;
				case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__GRAPHIC_CHART: return UMLRhapsodyPackage.ISTATE_CHART__GRAPHIC_CHART;
				case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__LAST_MODIFIED_TIME: return UMLRhapsodyPackage.ISTATE_CHART__LAST_MODIFIED_TIME;
				case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__TRANSITIONS: return UMLRhapsodyPackage.ISTATE_CHART__TRANSITIONS;
				case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__CONNECTORS: return UMLRhapsodyPackage.ISTATE_CHART__CONNECTORS;
				case UMLRhapsodyPackage.NESTED_STATE_CHART_TYPE__VERSION: return UMLRhapsodyPackage.ISTATE_CHART__VERSION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(", baseVersion: "); //$NON-NLS-1$
		result.append(baseVersion);
		result.append(')');
		return result.toString();
	}

} //IStateChartImpl
