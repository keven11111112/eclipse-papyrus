/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.bpmn.BPMNProfile.Auditing;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProperty;
import org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationSubscription;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowElementsContainer;
import org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet;
import org.eclipse.papyrus.bpmn.BPMNProfile.Monitoring;
import org.eclipse.papyrus.bpmn.BPMNProfile.ProcessType;
import org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole;

import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;

import org.eclipse.uml2.uml.Activity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BPMN Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProcessImpl#getLaneSets <em>Lane Sets</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProcessImpl#getFlowElements <em>Flow Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProcessImpl#getProcessType <em>Process Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProcessImpl#isClosed <em>Is Closed</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProcessImpl#getAuditing <em>Auditing</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProcessImpl#isExecutable <em>Is Executable</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProcessImpl#getDefinitionalCollaborationRef <em>Definitional Collaboration Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProcessImpl#getBase_Activity <em>Base Activity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProcessImpl#getCorrelationSubscriptions <em>Correlation Subscriptions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProcessImpl#getMonitoring <em>Monitoring</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProcessImpl#getSupports <em>Supports</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProcessImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProcessImpl#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BPMNProcessImpl extends CallableElementImpl implements BPMNProcess {
	/**
	 * The cached value of the '{@link #getLaneSets() <em>Lane Sets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaneSets()
	 * @generated
	 * @ordered
	 */
	protected EList<LaneSet> laneSets;

	/**
	 * The cached value of the '{@link #getFlowElements() <em>Flow Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlowElements()
	 * @generated
	 * @ordered
	 */
	protected EList<FlowElement> flowElements;

	/**
	 * The default value of the '{@link #getProcessType() <em>Process Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessType()
	 * @generated
	 * @ordered
	 */
	protected static final ProcessType PROCESS_TYPE_EDEFAULT = ProcessType.NONE;

	/**
	 * The cached value of the '{@link #getProcessType() <em>Process Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessType()
	 * @generated
	 * @ordered
	 */
	protected ProcessType processType = PROCESS_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isClosed() <em>Is Closed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClosed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CLOSED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isClosed() <em>Is Closed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClosed()
	 * @generated
	 * @ordered
	 */
	protected boolean isClosed = IS_CLOSED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAuditing() <em>Auditing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuditing()
	 * @generated
	 * @ordered
	 */
	protected Auditing auditing;

	/**
	 * The default value of the '{@link #isExecutable() <em>Is Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExecutable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_EXECUTABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExecutable() <em>Is Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExecutable()
	 * @generated
	 * @ordered
	 */
	protected boolean isExecutable = IS_EXECUTABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefinitionalCollaborationRef() <em>Definitional Collaboration Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitionalCollaborationRef()
	 * @generated
	 * @ordered
	 */
	protected BPMNCollaboration definitionalCollaborationRef;

	/**
	 * The cached value of the '{@link #getBase_Activity() <em>Base Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Activity()
	 * @generated
	 * @ordered
	 */
	protected Activity base_Activity;

	/**
	 * The cached value of the '{@link #getCorrelationSubscriptions() <em>Correlation Subscriptions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelationSubscriptions()
	 * @generated
	 * @ordered
	 */
	protected EList<CorrelationSubscription> correlationSubscriptions;

	/**
	 * The cached value of the '{@link #getMonitoring() <em>Monitoring</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonitoring()
	 * @generated
	 * @ordered
	 */
	protected Monitoring monitoring;

	/**
	 * The cached value of the '{@link #getSupports() <em>Supports</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupports()
	 * @generated
	 * @ordered
	 */
	protected BPMNProcess supports;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<BPMNProperty> properties;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceRole> resources;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BPMNProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getBPMNProcess();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LaneSet> getLaneSets() {
		if (laneSets == null) {
			laneSets = new EObjectWithInverseResolvingEList<LaneSet>(LaneSet.class, this, BPMNProfilePackage.BPMN_PROCESS__LANE_SETS, BPMNProfilePackage.LANE_SET__FLOW_ELEMENTS_CONTAINER);
		}
		return laneSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FlowElement> getFlowElements() {
		if (flowElements == null) {
			flowElements = new EObjectWithInverseResolvingEList<FlowElement>(FlowElement.class, this, BPMNProfilePackage.BPMN_PROCESS__FLOW_ELEMENTS, BPMNProfilePackage.FLOW_ELEMENT__CONTAINER);
		}
		return flowElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessType getProcessType() {
		return processType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessType(ProcessType newProcessType) {
		ProcessType oldProcessType = processType;
		processType = newProcessType == null ? PROCESS_TYPE_EDEFAULT : newProcessType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_PROCESS__PROCESS_TYPE, oldProcessType, processType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isClosed() {
		return isClosed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsClosed(boolean newIsClosed) {
		boolean oldIsClosed = isClosed;
		isClosed = newIsClosed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_PROCESS__IS_CLOSED, oldIsClosed, isClosed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Auditing getAuditing() {
		if (auditing != null && auditing.eIsProxy()) {
			InternalEObject oldAuditing = (InternalEObject)auditing;
			auditing = (Auditing)eResolveProxy(oldAuditing);
			if (auditing != oldAuditing) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.BPMN_PROCESS__AUDITING, oldAuditing, auditing));
			}
		}
		return auditing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Auditing basicGetAuditing() {
		return auditing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuditing(Auditing newAuditing) {
		Auditing oldAuditing = auditing;
		auditing = newAuditing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_PROCESS__AUDITING, oldAuditing, auditing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExecutable() {
		return isExecutable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsExecutable(boolean newIsExecutable) {
		boolean oldIsExecutable = isExecutable;
		isExecutable = newIsExecutable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_PROCESS__IS_EXECUTABLE, oldIsExecutable, isExecutable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNCollaboration getDefinitionalCollaborationRef() {
		if (definitionalCollaborationRef != null && definitionalCollaborationRef.eIsProxy()) {
			InternalEObject oldDefinitionalCollaborationRef = (InternalEObject)definitionalCollaborationRef;
			definitionalCollaborationRef = (BPMNCollaboration)eResolveProxy(oldDefinitionalCollaborationRef);
			if (definitionalCollaborationRef != oldDefinitionalCollaborationRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.BPMN_PROCESS__DEFINITIONAL_COLLABORATION_REF, oldDefinitionalCollaborationRef, definitionalCollaborationRef));
			}
		}
		return definitionalCollaborationRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNCollaboration basicGetDefinitionalCollaborationRef() {
		return definitionalCollaborationRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinitionalCollaborationRef(BPMNCollaboration newDefinitionalCollaborationRef) {
		BPMNCollaboration oldDefinitionalCollaborationRef = definitionalCollaborationRef;
		definitionalCollaborationRef = newDefinitionalCollaborationRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_PROCESS__DEFINITIONAL_COLLABORATION_REF, oldDefinitionalCollaborationRef, definitionalCollaborationRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getBase_Activity() {
		if (base_Activity != null && base_Activity.eIsProxy()) {
			InternalEObject oldBase_Activity = (InternalEObject)base_Activity;
			base_Activity = (Activity)eResolveProxy(oldBase_Activity);
			if (base_Activity != oldBase_Activity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.BPMN_PROCESS__BASE_ACTIVITY, oldBase_Activity, base_Activity));
			}
		}
		return base_Activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity basicGetBase_Activity() {
		return base_Activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Activity(Activity newBase_Activity) {
		Activity oldBase_Activity = base_Activity;
		base_Activity = newBase_Activity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_PROCESS__BASE_ACTIVITY, oldBase_Activity, base_Activity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CorrelationSubscription> getCorrelationSubscriptions() {
		if (correlationSubscriptions == null) {
			correlationSubscriptions = new EObjectResolvingEList<CorrelationSubscription>(CorrelationSubscription.class, this, BPMNProfilePackage.BPMN_PROCESS__CORRELATION_SUBSCRIPTIONS);
		}
		return correlationSubscriptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Monitoring getMonitoring() {
		if (monitoring != null && monitoring.eIsProxy()) {
			InternalEObject oldMonitoring = (InternalEObject)monitoring;
			monitoring = (Monitoring)eResolveProxy(oldMonitoring);
			if (monitoring != oldMonitoring) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.BPMN_PROCESS__MONITORING, oldMonitoring, monitoring));
			}
		}
		return monitoring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Monitoring basicGetMonitoring() {
		return monitoring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMonitoring(Monitoring newMonitoring) {
		Monitoring oldMonitoring = monitoring;
		monitoring = newMonitoring;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_PROCESS__MONITORING, oldMonitoring, monitoring));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNProcess getSupports() {
		if (supports != null && supports.eIsProxy()) {
			InternalEObject oldSupports = (InternalEObject)supports;
			supports = (BPMNProcess)eResolveProxy(oldSupports);
			if (supports != oldSupports) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.BPMN_PROCESS__SUPPORTS, oldSupports, supports));
			}
		}
		return supports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNProcess basicGetSupports() {
		return supports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupports(BPMNProcess newSupports) {
		BPMNProcess oldSupports = supports;
		supports = newSupports;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_PROCESS__SUPPORTS, oldSupports, supports));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BPMNProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectResolvingEList<BPMNProperty>(BPMNProperty.class, this, BPMNProfilePackage.BPMN_PROCESS__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceRole> getResources() {
		if (resources == null) {
			resources = new EObjectWithInverseResolvingEList<ResourceRole>(ResourceRole.class, this, BPMNProfilePackage.BPMN_PROCESS__RESOURCES, BPMNProfilePackage.RESOURCE_ROLE__PROCESS);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ProcesssupportedInterfaceRefs(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.BPMN_PROCESS__PROCESSSUPPORTED_INTERFACE_REFS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ProcesssupportedInterfaceRefs", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean Processsupports(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.BPMN_PROCESS__PROCESSSUPPORTS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "Processsupports", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean Processproperties(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.BPMN_PROCESS__PROCESSPROPERTIES,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "Processproperties", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ProcesslaneSets(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.BPMN_PROCESS__PROCESSLANE_SETS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ProcesslaneSets", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ProcessflowElements(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.BPMN_PROCESS__PROCESSFLOW_ELEMENTS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ProcessflowElements", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BPMNProfilePackage.BPMN_PROCESS__LANE_SETS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLaneSets()).basicAdd(otherEnd, msgs);
			case BPMNProfilePackage.BPMN_PROCESS__FLOW_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFlowElements()).basicAdd(otherEnd, msgs);
			case BPMNProfilePackage.BPMN_PROCESS__RESOURCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getResources()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BPMNProfilePackage.BPMN_PROCESS__LANE_SETS:
				return ((InternalEList<?>)getLaneSets()).basicRemove(otherEnd, msgs);
			case BPMNProfilePackage.BPMN_PROCESS__FLOW_ELEMENTS:
				return ((InternalEList<?>)getFlowElements()).basicRemove(otherEnd, msgs);
			case BPMNProfilePackage.BPMN_PROCESS__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
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
			case BPMNProfilePackage.BPMN_PROCESS__LANE_SETS:
				return getLaneSets();
			case BPMNProfilePackage.BPMN_PROCESS__FLOW_ELEMENTS:
				return getFlowElements();
			case BPMNProfilePackage.BPMN_PROCESS__PROCESS_TYPE:
				return getProcessType();
			case BPMNProfilePackage.BPMN_PROCESS__IS_CLOSED:
				return isClosed();
			case BPMNProfilePackage.BPMN_PROCESS__AUDITING:
				if (resolve) return getAuditing();
				return basicGetAuditing();
			case BPMNProfilePackage.BPMN_PROCESS__IS_EXECUTABLE:
				return isExecutable();
			case BPMNProfilePackage.BPMN_PROCESS__DEFINITIONAL_COLLABORATION_REF:
				if (resolve) return getDefinitionalCollaborationRef();
				return basicGetDefinitionalCollaborationRef();
			case BPMNProfilePackage.BPMN_PROCESS__BASE_ACTIVITY:
				if (resolve) return getBase_Activity();
				return basicGetBase_Activity();
			case BPMNProfilePackage.BPMN_PROCESS__CORRELATION_SUBSCRIPTIONS:
				return getCorrelationSubscriptions();
			case BPMNProfilePackage.BPMN_PROCESS__MONITORING:
				if (resolve) return getMonitoring();
				return basicGetMonitoring();
			case BPMNProfilePackage.BPMN_PROCESS__SUPPORTS:
				if (resolve) return getSupports();
				return basicGetSupports();
			case BPMNProfilePackage.BPMN_PROCESS__PROPERTIES:
				return getProperties();
			case BPMNProfilePackage.BPMN_PROCESS__RESOURCES:
				return getResources();
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
			case BPMNProfilePackage.BPMN_PROCESS__LANE_SETS:
				getLaneSets().clear();
				getLaneSets().addAll((Collection<? extends LaneSet>)newValue);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__FLOW_ELEMENTS:
				getFlowElements().clear();
				getFlowElements().addAll((Collection<? extends FlowElement>)newValue);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__PROCESS_TYPE:
				setProcessType((ProcessType)newValue);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__IS_CLOSED:
				setIsClosed((Boolean)newValue);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__AUDITING:
				setAuditing((Auditing)newValue);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__IS_EXECUTABLE:
				setIsExecutable((Boolean)newValue);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__DEFINITIONAL_COLLABORATION_REF:
				setDefinitionalCollaborationRef((BPMNCollaboration)newValue);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__BASE_ACTIVITY:
				setBase_Activity((Activity)newValue);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__CORRELATION_SUBSCRIPTIONS:
				getCorrelationSubscriptions().clear();
				getCorrelationSubscriptions().addAll((Collection<? extends CorrelationSubscription>)newValue);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__MONITORING:
				setMonitoring((Monitoring)newValue);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__SUPPORTS:
				setSupports((BPMNProcess)newValue);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends BPMNProperty>)newValue);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends ResourceRole>)newValue);
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
			case BPMNProfilePackage.BPMN_PROCESS__LANE_SETS:
				getLaneSets().clear();
				return;
			case BPMNProfilePackage.BPMN_PROCESS__FLOW_ELEMENTS:
				getFlowElements().clear();
				return;
			case BPMNProfilePackage.BPMN_PROCESS__PROCESS_TYPE:
				setProcessType(PROCESS_TYPE_EDEFAULT);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__IS_CLOSED:
				setIsClosed(IS_CLOSED_EDEFAULT);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__AUDITING:
				setAuditing((Auditing)null);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__IS_EXECUTABLE:
				setIsExecutable(IS_EXECUTABLE_EDEFAULT);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__DEFINITIONAL_COLLABORATION_REF:
				setDefinitionalCollaborationRef((BPMNCollaboration)null);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__BASE_ACTIVITY:
				setBase_Activity((Activity)null);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__CORRELATION_SUBSCRIPTIONS:
				getCorrelationSubscriptions().clear();
				return;
			case BPMNProfilePackage.BPMN_PROCESS__MONITORING:
				setMonitoring((Monitoring)null);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__SUPPORTS:
				setSupports((BPMNProcess)null);
				return;
			case BPMNProfilePackage.BPMN_PROCESS__PROPERTIES:
				getProperties().clear();
				return;
			case BPMNProfilePackage.BPMN_PROCESS__RESOURCES:
				getResources().clear();
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
			case BPMNProfilePackage.BPMN_PROCESS__LANE_SETS:
				return laneSets != null && !laneSets.isEmpty();
			case BPMNProfilePackage.BPMN_PROCESS__FLOW_ELEMENTS:
				return flowElements != null && !flowElements.isEmpty();
			case BPMNProfilePackage.BPMN_PROCESS__PROCESS_TYPE:
				return processType != PROCESS_TYPE_EDEFAULT;
			case BPMNProfilePackage.BPMN_PROCESS__IS_CLOSED:
				return isClosed != IS_CLOSED_EDEFAULT;
			case BPMNProfilePackage.BPMN_PROCESS__AUDITING:
				return auditing != null;
			case BPMNProfilePackage.BPMN_PROCESS__IS_EXECUTABLE:
				return isExecutable != IS_EXECUTABLE_EDEFAULT;
			case BPMNProfilePackage.BPMN_PROCESS__DEFINITIONAL_COLLABORATION_REF:
				return definitionalCollaborationRef != null;
			case BPMNProfilePackage.BPMN_PROCESS__BASE_ACTIVITY:
				return base_Activity != null;
			case BPMNProfilePackage.BPMN_PROCESS__CORRELATION_SUBSCRIPTIONS:
				return correlationSubscriptions != null && !correlationSubscriptions.isEmpty();
			case BPMNProfilePackage.BPMN_PROCESS__MONITORING:
				return monitoring != null;
			case BPMNProfilePackage.BPMN_PROCESS__SUPPORTS:
				return supports != null;
			case BPMNProfilePackage.BPMN_PROCESS__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case BPMNProfilePackage.BPMN_PROCESS__RESOURCES:
				return resources != null && !resources.isEmpty();
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
		if (baseClass == FlowElementsContainer.class) {
			switch (derivedFeatureID) {
				case BPMNProfilePackage.BPMN_PROCESS__LANE_SETS: return BPMNProfilePackage.FLOW_ELEMENTS_CONTAINER__LANE_SETS;
				case BPMNProfilePackage.BPMN_PROCESS__FLOW_ELEMENTS: return BPMNProfilePackage.FLOW_ELEMENTS_CONTAINER__FLOW_ELEMENTS;
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
		if (baseClass == FlowElementsContainer.class) {
			switch (baseFeatureID) {
				case BPMNProfilePackage.FLOW_ELEMENTS_CONTAINER__LANE_SETS: return BPMNProfilePackage.BPMN_PROCESS__LANE_SETS;
				case BPMNProfilePackage.FLOW_ELEMENTS_CONTAINER__FLOW_ELEMENTS: return BPMNProfilePackage.BPMN_PROCESS__FLOW_ELEMENTS;
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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BPMNProfilePackage.BPMN_PROCESS___PROCESSSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP:
				return ProcesssupportedInterfaceRefs((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.BPMN_PROCESS___PROCESSSUPPORTS__DIAGNOSTICCHAIN_MAP:
				return Processsupports((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.BPMN_PROCESS___PROCESSPROPERTIES__DIAGNOSTICCHAIN_MAP:
				return Processproperties((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.BPMN_PROCESS___PROCESSLANE_SETS__DIAGNOSTICCHAIN_MAP:
				return ProcesslaneSets((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.BPMN_PROCESS___PROCESSFLOW_ELEMENTS__DIAGNOSTICCHAIN_MAP:
				return ProcessflowElements((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (processType: ");
		result.append(processType);
		result.append(", isClosed: ");
		result.append(isClosed);
		result.append(", isExecutable: ");
		result.append(isExecutable);
		result.append(')');
		return result.toString();
	}

} //BPMNProcessImpl
