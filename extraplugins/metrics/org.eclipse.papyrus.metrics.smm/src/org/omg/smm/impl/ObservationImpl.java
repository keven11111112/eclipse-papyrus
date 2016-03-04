/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   CEA LIST - Initial API and implementation
 * 
 */
package org.omg.smm.impl;

import java.sql.Timestamp;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.omg.smm.AbstractMeasureElement;
import org.omg.smm.Argument;
import org.omg.smm.Observation;
import org.omg.smm.ObservationScope;
import org.omg.smm.ObservedMeasure;
import org.omg.smm.SmmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Observation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.impl.ObservationImpl#getObserver <em>Observer</em>}</li>
 *   <li>{@link org.omg.smm.impl.ObservationImpl#getTool <em>Tool</em>}</li>
 *   <li>{@link org.omg.smm.impl.ObservationImpl#getWhenObserved <em>When Observed</em>}</li>
 *   <li>{@link org.omg.smm.impl.ObservationImpl#getScopes <em>Scopes</em>}</li>
 *   <li>{@link org.omg.smm.impl.ObservationImpl#getObservedMeasures <em>Observed Measures</em>}</li>
 *   <li>{@link org.omg.smm.impl.ObservationImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.omg.smm.impl.ObservationImpl#getRequestedMeasures <em>Requested Measures</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObservationImpl extends SmmElementImpl implements Observation {
	/**
	 * The default value of the '{@link #getObserver() <em>Observer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObserver()
	 * @generated
	 * @ordered
	 */
	protected static final String OBSERVER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObserver() <em>Observer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObserver()
	 * @generated
	 * @ordered
	 */
	protected String observer = OBSERVER_EDEFAULT;

	/**
	 * The default value of the '{@link #getTool() <em>Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTool()
	 * @generated
	 * @ordered
	 */
	protected static final String TOOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTool() <em>Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTool()
	 * @generated
	 * @ordered
	 */
	protected String tool = TOOL_EDEFAULT;

	/**
	 * The default value of the '{@link #getWhenObserved() <em>When Observed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhenObserved()
	 * @generated
	 * @ordered
	 */
	protected static final Timestamp WHEN_OBSERVED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWhenObserved() <em>When Observed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhenObserved()
	 * @generated
	 * @ordered
	 */
	protected Timestamp whenObserved = WHEN_OBSERVED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getScopes() <em>Scopes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopes()
	 * @generated
	 * @ordered
	 */
	protected EList<ObservationScope> scopes;

	/**
	 * The cached value of the '{@link #getObservedMeasures() <em>Observed Measures</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObservedMeasures()
	 * @generated
	 * @ordered
	 */
	protected EList<ObservedMeasure> observedMeasures;

	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<Argument> arguments;

	/**
	 * The cached value of the '{@link #getRequestedMeasures() <em>Requested Measures</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequestedMeasures()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractMeasureElement> requestedMeasures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObservationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmmPackage.Literals.OBSERVATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObserver() {
		return observer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObserver(String newObserver) {
		String oldObserver = observer;
		observer = newObserver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.OBSERVATION__OBSERVER, oldObserver, observer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTool() {
		return tool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTool(String newTool) {
		String oldTool = tool;
		tool = newTool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.OBSERVATION__TOOL, oldTool, tool));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Timestamp getWhenObserved() {
		return whenObserved;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhenObserved(Timestamp newWhenObserved) {
		Timestamp oldWhenObserved = whenObserved;
		whenObserved = newWhenObserved;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.OBSERVATION__WHEN_OBSERVED, oldWhenObserved, whenObserved));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObservationScope> getScopes() {
		if (scopes == null) {
			scopes = new EObjectContainmentEList<ObservationScope>(ObservationScope.class, this, SmmPackage.OBSERVATION__SCOPES);
		}
		return scopes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObservedMeasure> getObservedMeasures() {
		if (observedMeasures == null) {
			observedMeasures = new EObjectContainmentEList<ObservedMeasure>(ObservedMeasure.class, this, SmmPackage.OBSERVATION__OBSERVED_MEASURES);
		}
		return observedMeasures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Argument> getArguments() {
		if (arguments == null) {
			arguments = new EObjectContainmentEList<Argument>(Argument.class, this, SmmPackage.OBSERVATION__ARGUMENTS);
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractMeasureElement> getRequestedMeasures() {
		if (requestedMeasures == null) {
			requestedMeasures = new EObjectResolvingEList<AbstractMeasureElement>(AbstractMeasureElement.class, this, SmmPackage.OBSERVATION__REQUESTED_MEASURES);
		}
		return requestedMeasures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SmmPackage.OBSERVATION__SCOPES:
				return ((InternalEList<?>)getScopes()).basicRemove(otherEnd, msgs);
			case SmmPackage.OBSERVATION__OBSERVED_MEASURES:
				return ((InternalEList<?>)getObservedMeasures()).basicRemove(otherEnd, msgs);
			case SmmPackage.OBSERVATION__ARGUMENTS:
				return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
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
			case SmmPackage.OBSERVATION__OBSERVER:
				return getObserver();
			case SmmPackage.OBSERVATION__TOOL:
				return getTool();
			case SmmPackage.OBSERVATION__WHEN_OBSERVED:
				return getWhenObserved();
			case SmmPackage.OBSERVATION__SCOPES:
				return getScopes();
			case SmmPackage.OBSERVATION__OBSERVED_MEASURES:
				return getObservedMeasures();
			case SmmPackage.OBSERVATION__ARGUMENTS:
				return getArguments();
			case SmmPackage.OBSERVATION__REQUESTED_MEASURES:
				return getRequestedMeasures();
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
			case SmmPackage.OBSERVATION__OBSERVER:
				setObserver((String)newValue);
				return;
			case SmmPackage.OBSERVATION__TOOL:
				setTool((String)newValue);
				return;
			case SmmPackage.OBSERVATION__WHEN_OBSERVED:
				setWhenObserved((Timestamp)newValue);
				return;
			case SmmPackage.OBSERVATION__SCOPES:
				getScopes().clear();
				getScopes().addAll((Collection<? extends ObservationScope>)newValue);
				return;
			case SmmPackage.OBSERVATION__OBSERVED_MEASURES:
				getObservedMeasures().clear();
				getObservedMeasures().addAll((Collection<? extends ObservedMeasure>)newValue);
				return;
			case SmmPackage.OBSERVATION__ARGUMENTS:
				getArguments().clear();
				getArguments().addAll((Collection<? extends Argument>)newValue);
				return;
			case SmmPackage.OBSERVATION__REQUESTED_MEASURES:
				getRequestedMeasures().clear();
				getRequestedMeasures().addAll((Collection<? extends AbstractMeasureElement>)newValue);
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
			case SmmPackage.OBSERVATION__OBSERVER:
				setObserver(OBSERVER_EDEFAULT);
				return;
			case SmmPackage.OBSERVATION__TOOL:
				setTool(TOOL_EDEFAULT);
				return;
			case SmmPackage.OBSERVATION__WHEN_OBSERVED:
				setWhenObserved(WHEN_OBSERVED_EDEFAULT);
				return;
			case SmmPackage.OBSERVATION__SCOPES:
				getScopes().clear();
				return;
			case SmmPackage.OBSERVATION__OBSERVED_MEASURES:
				getObservedMeasures().clear();
				return;
			case SmmPackage.OBSERVATION__ARGUMENTS:
				getArguments().clear();
				return;
			case SmmPackage.OBSERVATION__REQUESTED_MEASURES:
				getRequestedMeasures().clear();
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
			case SmmPackage.OBSERVATION__OBSERVER:
				return OBSERVER_EDEFAULT == null ? observer != null : !OBSERVER_EDEFAULT.equals(observer);
			case SmmPackage.OBSERVATION__TOOL:
				return TOOL_EDEFAULT == null ? tool != null : !TOOL_EDEFAULT.equals(tool);
			case SmmPackage.OBSERVATION__WHEN_OBSERVED:
				return WHEN_OBSERVED_EDEFAULT == null ? whenObserved != null : !WHEN_OBSERVED_EDEFAULT.equals(whenObserved);
			case SmmPackage.OBSERVATION__SCOPES:
				return scopes != null && !scopes.isEmpty();
			case SmmPackage.OBSERVATION__OBSERVED_MEASURES:
				return observedMeasures != null && !observedMeasures.isEmpty();
			case SmmPackage.OBSERVATION__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
			case SmmPackage.OBSERVATION__REQUESTED_MEASURES:
				return requestedMeasures != null && !requestedMeasures.isEmpty();
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
		result.append(" (observer: ");
		result.append(observer);
		result.append(", tool: ");
		result.append(tool);
		result.append(", whenObserved: ");
		result.append(whenObserved);
		result.append(')');
		return result.toString();
	}

} //ObservationImpl
