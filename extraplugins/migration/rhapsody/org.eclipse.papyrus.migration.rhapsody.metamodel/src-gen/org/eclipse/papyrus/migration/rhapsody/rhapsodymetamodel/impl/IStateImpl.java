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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DefaultTransType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAction;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAnnotation;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDependency;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDiagram;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IModelElement;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStateVertex;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISwimlane;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.NestedStateChartType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IState</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateImpl#getStateType <em>State Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateImpl#getDefaultTrans <em>Default Trans</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateImpl#getEntryAction <em>Entry Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateImpl#getInheritsFromHandle <em>Inherits From Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateImpl#getExitAction <em>Exit Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateImpl#getNestedStateChart <em>Nested State Chart</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateImpl#getRequiremenTracabilityHandle <em>Requiremen Tracability Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateImpl#getTheMainDiagram <em>The Main Diagram</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateImpl#getSwimlane <em>Swimlane</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IStateImpl#getCodeUpdateCGTime <em>Code Update CG Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IStateImpl extends IStateVertexImpl implements IState {
	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected IStateVertex parent;

	/**
	 * The default value of the '{@link #getStateType() <em>State Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateType()
	 * @generated
	 * @ordered
	 */
	protected static final String STATE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStateType() <em>State Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateType()
	 * @generated
	 * @ordered
	 */
	protected String stateType = STATE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefaultTrans() <em>Default Trans</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultTrans()
	 * @generated
	 * @ordered
	 */
	protected DefaultTransType defaultTrans;

	/**
	 * The cached value of the '{@link #getEntryAction() <em>Entry Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryAction()
	 * @generated
	 * @ordered
	 */
	protected IModelElement entryAction;

	/**
	 * The cached value of the '{@link #getInheritsFromHandle() <em>Inherits From Handle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritsFromHandle()
	 * @generated
	 * @ordered
	 */
	protected IState inheritsFromHandle;

	/**
	 * The cached value of the '{@link #getExitAction() <em>Exit Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExitAction()
	 * @generated
	 * @ordered
	 */
	protected IAction exitAction;

	/**
	 * The cached value of the '{@link #getNestedStateChart() <em>Nested State Chart</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedStateChart()
	 * @generated
	 * @ordered
	 */
	protected NestedStateChartType nestedStateChart;

	/**
	 * The default value of the '{@link #getRequiremenTracabilityHandle() <em>Requiremen Tracability Handle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiremenTracabilityHandle()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRequiremenTracabilityHandle() <em>Requiremen Tracability Handle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiremenTracabilityHandle()
	 * @generated
	 * @ordered
	 */
	protected String requiremenTracabilityHandle = REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<IAnnotation> annotations;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected IDependency dependencies;

	/**
	 * The cached value of the '{@link #getTheMainDiagram() <em>The Main Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheMainDiagram()
	 * @generated
	 * @ordered
	 */
	protected IDiagram theMainDiagram;

	/**
	 * The cached value of the '{@link #getSwimlane() <em>Swimlane</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwimlane()
	 * @generated
	 * @ordered
	 */
	protected ISwimlane swimlane;

	/**
	 * The cached value of the '{@link #getCodeUpdateCGTime() <em>Code Update CG Time</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodeUpdateCGTime()
	 * @generated
	 * @ordered
	 */
	protected EList<String> codeUpdateCGTime;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIState();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStateVertex getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (IStateVertex)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISTATE__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStateVertex basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(IStateVertex newParent) {
		IStateVertex oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStateType() {
		return stateType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateType(String newStateType) {
		String oldStateType = stateType;
		stateType = newStateType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE__STATE_TYPE, oldStateType, stateType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultTransType getDefaultTrans() {
		if (defaultTrans != null && defaultTrans.eIsProxy()) {
			InternalEObject oldDefaultTrans = (InternalEObject)defaultTrans;
			defaultTrans = (DefaultTransType)eResolveProxy(oldDefaultTrans);
			if (defaultTrans != oldDefaultTrans) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISTATE__DEFAULT_TRANS, oldDefaultTrans, defaultTrans));
			}
		}
		return defaultTrans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultTransType basicGetDefaultTrans() {
		return defaultTrans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultTrans(DefaultTransType newDefaultTrans) {
		DefaultTransType oldDefaultTrans = defaultTrans;
		defaultTrans = newDefaultTrans;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE__DEFAULT_TRANS, oldDefaultTrans, defaultTrans));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IModelElement getEntryAction() {
		if (entryAction != null && entryAction.eIsProxy()) {
			InternalEObject oldEntryAction = (InternalEObject)entryAction;
			entryAction = (IModelElement)eResolveProxy(oldEntryAction);
			if (entryAction != oldEntryAction) {
				InternalEObject newEntryAction = (InternalEObject)entryAction;
				NotificationChain msgs = oldEntryAction.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE__ENTRY_ACTION, null, null);
				if (newEntryAction.eInternalContainer() == null) {
					msgs = newEntryAction.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE__ENTRY_ACTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISTATE__ENTRY_ACTION, oldEntryAction, entryAction));
			}
		}
		return entryAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IModelElement basicGetEntryAction() {
		return entryAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEntryAction(IModelElement newEntryAction, NotificationChain msgs) {
		IModelElement oldEntryAction = entryAction;
		entryAction = newEntryAction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE__ENTRY_ACTION, oldEntryAction, newEntryAction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryAction(IModelElement newEntryAction) {
		if (newEntryAction != entryAction) {
			NotificationChain msgs = null;
			if (entryAction != null)
				msgs = ((InternalEObject)entryAction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE__ENTRY_ACTION, null, msgs);
			if (newEntryAction != null)
				msgs = ((InternalEObject)newEntryAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE__ENTRY_ACTION, null, msgs);
			msgs = basicSetEntryAction(newEntryAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE__ENTRY_ACTION, newEntryAction, newEntryAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IState getInheritsFromHandle() {
		if (inheritsFromHandle != null && inheritsFromHandle.eIsProxy()) {
			InternalEObject oldInheritsFromHandle = (InternalEObject)inheritsFromHandle;
			inheritsFromHandle = (IState)eResolveProxy(oldInheritsFromHandle);
			if (inheritsFromHandle != oldInheritsFromHandle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISTATE__INHERITS_FROM_HANDLE, oldInheritsFromHandle, inheritsFromHandle));
			}
		}
		return inheritsFromHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IState basicGetInheritsFromHandle() {
		return inheritsFromHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritsFromHandle(IState newInheritsFromHandle) {
		IState oldInheritsFromHandle = inheritsFromHandle;
		inheritsFromHandle = newInheritsFromHandle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE__INHERITS_FROM_HANDLE, oldInheritsFromHandle, inheritsFromHandle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAction getExitAction() {
		if (exitAction != null && exitAction.eIsProxy()) {
			InternalEObject oldExitAction = (InternalEObject)exitAction;
			exitAction = (IAction)eResolveProxy(oldExitAction);
			if (exitAction != oldExitAction) {
				InternalEObject newExitAction = (InternalEObject)exitAction;
				NotificationChain msgs = oldExitAction.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE__EXIT_ACTION, null, null);
				if (newExitAction.eInternalContainer() == null) {
					msgs = newExitAction.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE__EXIT_ACTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISTATE__EXIT_ACTION, oldExitAction, exitAction));
			}
		}
		return exitAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAction basicGetExitAction() {
		return exitAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExitAction(IAction newExitAction, NotificationChain msgs) {
		IAction oldExitAction = exitAction;
		exitAction = newExitAction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE__EXIT_ACTION, oldExitAction, newExitAction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExitAction(IAction newExitAction) {
		if (newExitAction != exitAction) {
			NotificationChain msgs = null;
			if (exitAction != null)
				msgs = ((InternalEObject)exitAction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE__EXIT_ACTION, null, msgs);
			if (newExitAction != null)
				msgs = ((InternalEObject)newExitAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE__EXIT_ACTION, null, msgs);
			msgs = basicSetExitAction(newExitAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE__EXIT_ACTION, newExitAction, newExitAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedStateChartType getNestedStateChart() {
		if (nestedStateChart != null && nestedStateChart.eIsProxy()) {
			InternalEObject oldNestedStateChart = (InternalEObject)nestedStateChart;
			nestedStateChart = (NestedStateChartType)eResolveProxy(oldNestedStateChart);
			if (nestedStateChart != oldNestedStateChart) {
				InternalEObject newNestedStateChart = (InternalEObject)nestedStateChart;
				NotificationChain msgs = oldNestedStateChart.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE__NESTED_STATE_CHART, null, null);
				if (newNestedStateChart.eInternalContainer() == null) {
					msgs = newNestedStateChart.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE__NESTED_STATE_CHART, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISTATE__NESTED_STATE_CHART, oldNestedStateChart, nestedStateChart));
			}
		}
		return nestedStateChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedStateChartType basicGetNestedStateChart() {
		return nestedStateChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNestedStateChart(NestedStateChartType newNestedStateChart, NotificationChain msgs) {
		NestedStateChartType oldNestedStateChart = nestedStateChart;
		nestedStateChart = newNestedStateChart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE__NESTED_STATE_CHART, oldNestedStateChart, newNestedStateChart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNestedStateChart(NestedStateChartType newNestedStateChart) {
		if (newNestedStateChart != nestedStateChart) {
			NotificationChain msgs = null;
			if (nestedStateChart != null)
				msgs = ((InternalEObject)nestedStateChart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE__NESTED_STATE_CHART, null, msgs);
			if (newNestedStateChart != null)
				msgs = ((InternalEObject)newNestedStateChart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE__NESTED_STATE_CHART, null, msgs);
			msgs = basicSetNestedStateChart(newNestedStateChart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE__NESTED_STATE_CHART, newNestedStateChart, newNestedStateChart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRequiremenTracabilityHandle() {
		return requiremenTracabilityHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiremenTracabilityHandle(String newRequiremenTracabilityHandle) {
		String oldRequiremenTracabilityHandle = requiremenTracabilityHandle;
		requiremenTracabilityHandle = newRequiremenTracabilityHandle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE__REQUIREMEN_TRACABILITY_HANDLE, oldRequiremenTracabilityHandle, requiremenTracabilityHandle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IAnnotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList.Resolving<IAnnotation>(IAnnotation.class, this, UMLRhapsodyPackage.ISTATE__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDependency getDependencies() {
		if (dependencies != null && dependencies.eIsProxy()) {
			InternalEObject oldDependencies = (InternalEObject)dependencies;
			dependencies = (IDependency)eResolveProxy(oldDependencies);
			if (dependencies != oldDependencies) {
				InternalEObject newDependencies = (InternalEObject)dependencies;
				NotificationChain msgs = oldDependencies.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE__DEPENDENCIES, null, null);
				if (newDependencies.eInternalContainer() == null) {
					msgs = newDependencies.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE__DEPENDENCIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISTATE__DEPENDENCIES, oldDependencies, dependencies));
			}
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDependency basicGetDependencies() {
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependencies(IDependency newDependencies, NotificationChain msgs) {
		IDependency oldDependencies = dependencies;
		dependencies = newDependencies;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE__DEPENDENCIES, oldDependencies, newDependencies);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependencies(IDependency newDependencies) {
		if (newDependencies != dependencies) {
			NotificationChain msgs = null;
			if (dependencies != null)
				msgs = ((InternalEObject)dependencies).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE__DEPENDENCIES, null, msgs);
			if (newDependencies != null)
				msgs = ((InternalEObject)newDependencies).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ISTATE__DEPENDENCIES, null, msgs);
			msgs = basicSetDependencies(newDependencies, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE__DEPENDENCIES, newDependencies, newDependencies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDiagram getTheMainDiagram() {
		if (theMainDiagram != null && theMainDiagram.eIsProxy()) {
			InternalEObject oldTheMainDiagram = (InternalEObject)theMainDiagram;
			theMainDiagram = (IDiagram)eResolveProxy(oldTheMainDiagram);
			if (theMainDiagram != oldTheMainDiagram) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISTATE__THE_MAIN_DIAGRAM, oldTheMainDiagram, theMainDiagram));
			}
		}
		return theMainDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDiagram basicGetTheMainDiagram() {
		return theMainDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTheMainDiagram(IDiagram newTheMainDiagram) {
		IDiagram oldTheMainDiagram = theMainDiagram;
		theMainDiagram = newTheMainDiagram;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE__THE_MAIN_DIAGRAM, oldTheMainDiagram, theMainDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISwimlane getSwimlane() {
		if (swimlane != null && swimlane.eIsProxy()) {
			InternalEObject oldSwimlane = (InternalEObject)swimlane;
			swimlane = (ISwimlane)eResolveProxy(oldSwimlane);
			if (swimlane != oldSwimlane) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ISTATE__SWIMLANE, oldSwimlane, swimlane));
			}
		}
		return swimlane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISwimlane basicGetSwimlane() {
		return swimlane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSwimlane(ISwimlane newSwimlane) {
		ISwimlane oldSwimlane = swimlane;
		swimlane = newSwimlane;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ISTATE__SWIMLANE, oldSwimlane, swimlane));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCodeUpdateCGTime() {
		if (codeUpdateCGTime == null) {
			codeUpdateCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ISTATE__CODE_UPDATE_CG_TIME);
		}
		return codeUpdateCGTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.ISTATE__ENTRY_ACTION:
				return basicSetEntryAction(null, msgs);
			case UMLRhapsodyPackage.ISTATE__EXIT_ACTION:
				return basicSetExitAction(null, msgs);
			case UMLRhapsodyPackage.ISTATE__NESTED_STATE_CHART:
				return basicSetNestedStateChart(null, msgs);
			case UMLRhapsodyPackage.ISTATE__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ISTATE__DEPENDENCIES:
				return basicSetDependencies(null, msgs);
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
			case UMLRhapsodyPackage.ISTATE__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case UMLRhapsodyPackage.ISTATE__STATE_TYPE:
				return getStateType();
			case UMLRhapsodyPackage.ISTATE__DEFAULT_TRANS:
				if (resolve) return getDefaultTrans();
				return basicGetDefaultTrans();
			case UMLRhapsodyPackage.ISTATE__ENTRY_ACTION:
				if (resolve) return getEntryAction();
				return basicGetEntryAction();
			case UMLRhapsodyPackage.ISTATE__INHERITS_FROM_HANDLE:
				if (resolve) return getInheritsFromHandle();
				return basicGetInheritsFromHandle();
			case UMLRhapsodyPackage.ISTATE__EXIT_ACTION:
				if (resolve) return getExitAction();
				return basicGetExitAction();
			case UMLRhapsodyPackage.ISTATE__NESTED_STATE_CHART:
				if (resolve) return getNestedStateChart();
				return basicGetNestedStateChart();
			case UMLRhapsodyPackage.ISTATE__REQUIREMEN_TRACABILITY_HANDLE:
				return getRequiremenTracabilityHandle();
			case UMLRhapsodyPackage.ISTATE__ANNOTATIONS:
				return getAnnotations();
			case UMLRhapsodyPackage.ISTATE__DEPENDENCIES:
				if (resolve) return getDependencies();
				return basicGetDependencies();
			case UMLRhapsodyPackage.ISTATE__THE_MAIN_DIAGRAM:
				if (resolve) return getTheMainDiagram();
				return basicGetTheMainDiagram();
			case UMLRhapsodyPackage.ISTATE__SWIMLANE:
				if (resolve) return getSwimlane();
				return basicGetSwimlane();
			case UMLRhapsodyPackage.ISTATE__CODE_UPDATE_CG_TIME:
				return getCodeUpdateCGTime();
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
			case UMLRhapsodyPackage.ISTATE__PARENT:
				setParent((IStateVertex)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE__STATE_TYPE:
				setStateType((String)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE__DEFAULT_TRANS:
				setDefaultTrans((DefaultTransType)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE__ENTRY_ACTION:
				setEntryAction((IModelElement)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE__INHERITS_FROM_HANDLE:
				setInheritsFromHandle((IState)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE__EXIT_ACTION:
				setExitAction((IAction)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE__NESTED_STATE_CHART:
				setNestedStateChart((NestedStateChartType)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle((String)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends IAnnotation>)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE__DEPENDENCIES:
				setDependencies((IDependency)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE__THE_MAIN_DIAGRAM:
				setTheMainDiagram((IDiagram)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE__SWIMLANE:
				setSwimlane((ISwimlane)newValue);
				return;
			case UMLRhapsodyPackage.ISTATE__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				getCodeUpdateCGTime().addAll((Collection<? extends String>)newValue);
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
			case UMLRhapsodyPackage.ISTATE__PARENT:
				setParent((IStateVertex)null);
				return;
			case UMLRhapsodyPackage.ISTATE__STATE_TYPE:
				setStateType(STATE_TYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ISTATE__DEFAULT_TRANS:
				setDefaultTrans((DefaultTransType)null);
				return;
			case UMLRhapsodyPackage.ISTATE__ENTRY_ACTION:
				setEntryAction((IModelElement)null);
				return;
			case UMLRhapsodyPackage.ISTATE__INHERITS_FROM_HANDLE:
				setInheritsFromHandle((IState)null);
				return;
			case UMLRhapsodyPackage.ISTATE__EXIT_ACTION:
				setExitAction((IAction)null);
				return;
			case UMLRhapsodyPackage.ISTATE__NESTED_STATE_CHART:
				setNestedStateChart((NestedStateChartType)null);
				return;
			case UMLRhapsodyPackage.ISTATE__REQUIREMEN_TRACABILITY_HANDLE:
				setRequiremenTracabilityHandle(REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ISTATE__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case UMLRhapsodyPackage.ISTATE__DEPENDENCIES:
				setDependencies((IDependency)null);
				return;
			case UMLRhapsodyPackage.ISTATE__THE_MAIN_DIAGRAM:
				setTheMainDiagram((IDiagram)null);
				return;
			case UMLRhapsodyPackage.ISTATE__SWIMLANE:
				setSwimlane((ISwimlane)null);
				return;
			case UMLRhapsodyPackage.ISTATE__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
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
			case UMLRhapsodyPackage.ISTATE__PARENT:
				return parent != null;
			case UMLRhapsodyPackage.ISTATE__STATE_TYPE:
				return STATE_TYPE_EDEFAULT == null ? stateType != null : !STATE_TYPE_EDEFAULT.equals(stateType);
			case UMLRhapsodyPackage.ISTATE__DEFAULT_TRANS:
				return defaultTrans != null;
			case UMLRhapsodyPackage.ISTATE__ENTRY_ACTION:
				return entryAction != null;
			case UMLRhapsodyPackage.ISTATE__INHERITS_FROM_HANDLE:
				return inheritsFromHandle != null;
			case UMLRhapsodyPackage.ISTATE__EXIT_ACTION:
				return exitAction != null;
			case UMLRhapsodyPackage.ISTATE__NESTED_STATE_CHART:
				return nestedStateChart != null;
			case UMLRhapsodyPackage.ISTATE__REQUIREMEN_TRACABILITY_HANDLE:
				return REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT == null ? requiremenTracabilityHandle != null : !REQUIREMEN_TRACABILITY_HANDLE_EDEFAULT.equals(requiremenTracabilityHandle);
			case UMLRhapsodyPackage.ISTATE__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case UMLRhapsodyPackage.ISTATE__DEPENDENCIES:
				return dependencies != null;
			case UMLRhapsodyPackage.ISTATE__THE_MAIN_DIAGRAM:
				return theMainDiagram != null;
			case UMLRhapsodyPackage.ISTATE__SWIMLANE:
				return swimlane != null;
			case UMLRhapsodyPackage.ISTATE__CODE_UPDATE_CG_TIME:
				return codeUpdateCGTime != null && !codeUpdateCGTime.isEmpty();
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
		result.append(" (stateType: "); //$NON-NLS-1$
		result.append(stateType);
		result.append(", requiremenTracabilityHandle: "); //$NON-NLS-1$
		result.append(requiremenTracabilityHandle);
		result.append(", codeUpdateCGTime: "); //$NON-NLS-1$
		result.append(codeUpdateCGTime);
		result.append(')');
		return result.toString();
	}

} //IStateImpl
