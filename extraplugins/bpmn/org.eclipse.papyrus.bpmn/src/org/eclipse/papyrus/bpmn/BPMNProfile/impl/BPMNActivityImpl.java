/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

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

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProperty;
import org.eclipse.papyrus.bpmn.BPMNProfile.BoundaryEvent;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataInputAssociation;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataOutputAssociation;
import org.eclipse.papyrus.bpmn.BPMNProfile.LoopCharacteristics;
import org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole;
import org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow;

import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;

import org.eclipse.uml2.uml.Action;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BPMN Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNActivityImpl#isForCompensation <em>Is For Compensation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNActivityImpl#getStartQuantity <em>Start Quantity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNActivityImpl#getCompletionQuantity <em>Completion Quantity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNActivityImpl#getBase_Action <em>Base Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNActivityImpl#getActivityClass <em>Activity Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNActivityImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNActivityImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNActivityImpl#getBoundaryEventRefs <em>Boundary Event Refs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNActivityImpl#getDataInputAssociations <em>Data Input Associations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNActivityImpl#getDataOutputAssociations <em>Data Output Associations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNActivityImpl#getLoopCharacteristics <em>Loop Characteristics</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNActivityImpl#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BPMNActivityImpl extends FlowNodeImpl implements BPMNActivity {
	/**
	 * The default value of the '{@link #isForCompensation() <em>Is For Compensation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isForCompensation()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_FOR_COMPENSATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isForCompensation() <em>Is For Compensation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isForCompensation()
	 * @generated
	 * @ordered
	 */
	protected boolean isForCompensation = IS_FOR_COMPENSATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartQuantity() <em>Start Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartQuantity()
	 * @generated
	 * @ordered
	 */
	protected static final int START_QUANTITY_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getStartQuantity() <em>Start Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartQuantity()
	 * @generated
	 * @ordered
	 */
	protected int startQuantity = START_QUANTITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCompletionQuantity() <em>Completion Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompletionQuantity()
	 * @generated
	 * @ordered
	 */
	protected static final int COMPLETION_QUANTITY_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getCompletionQuantity() <em>Completion Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompletionQuantity()
	 * @generated
	 * @ordered
	 */
	protected int completionQuantity = COMPLETION_QUANTITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Action() <em>Base Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Action()
	 * @generated
	 * @ordered
	 */
	protected Action base_Action;

	/**
	 * The cached value of the '{@link #getActivityClass() <em>Activity Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivityClass()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class activityClass;

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
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected SequenceFlow default_;

	/**
	 * The cached value of the '{@link #getBoundaryEventRefs() <em>Boundary Event Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundaryEventRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<BoundaryEvent> boundaryEventRefs;

	/**
	 * The cached value of the '{@link #getDataInputAssociations() <em>Data Input Associations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataInputAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<DataInputAssociation> dataInputAssociations;

	/**
	 * The cached value of the '{@link #getDataOutputAssociations() <em>Data Output Associations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataOutputAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<DataOutputAssociation> dataOutputAssociations;

	/**
	 * The cached value of the '{@link #getLoopCharacteristics() <em>Loop Characteristics</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopCharacteristics()
	 * @generated
	 * @ordered
	 */
	protected LoopCharacteristics loopCharacteristics;

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
	protected BPMNActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getBPMNActivity();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isForCompensation() {
		return isForCompensation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsForCompensation(boolean newIsForCompensation) {
		boolean oldIsForCompensation = isForCompensation;
		isForCompensation = newIsForCompensation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_ACTIVITY__IS_FOR_COMPENSATION, oldIsForCompensation, isForCompensation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartQuantity() {
		return startQuantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartQuantity(int newStartQuantity) {
		int oldStartQuantity = startQuantity;
		startQuantity = newStartQuantity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_ACTIVITY__START_QUANTITY, oldStartQuantity, startQuantity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCompletionQuantity() {
		return completionQuantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompletionQuantity(int newCompletionQuantity) {
		int oldCompletionQuantity = completionQuantity;
		completionQuantity = newCompletionQuantity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_ACTIVITY__COMPLETION_QUANTITY, oldCompletionQuantity, completionQuantity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getBase_Action() {
		if (base_Action != null && base_Action.eIsProxy()) {
			InternalEObject oldBase_Action = (InternalEObject)base_Action;
			base_Action = (Action)eResolveProxy(oldBase_Action);
			if (base_Action != oldBase_Action) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.BPMN_ACTIVITY__BASE_ACTION, oldBase_Action, base_Action));
			}
		}
		return base_Action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetBase_Action() {
		return base_Action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Action(Action newBase_Action) {
		Action oldBase_Action = base_Action;
		base_Action = newBase_Action;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_ACTIVITY__BASE_ACTION, oldBase_Action, base_Action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getActivityClass() {
		if (activityClass != null && activityClass.eIsProxy()) {
			InternalEObject oldActivityClass = (InternalEObject)activityClass;
			activityClass = (org.eclipse.uml2.uml.Class)eResolveProxy(oldActivityClass);
			if (activityClass != oldActivityClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.BPMN_ACTIVITY__ACTIVITY_CLASS, oldActivityClass, activityClass));
			}
		}
		return activityClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetActivityClass() {
		return activityClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivityClass(org.eclipse.uml2.uml.Class newActivityClass) {
		org.eclipse.uml2.uml.Class oldActivityClass = activityClass;
		activityClass = newActivityClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_ACTIVITY__ACTIVITY_CLASS, oldActivityClass, activityClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BPMNProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectResolvingEList<BPMNProperty>(BPMNProperty.class, this, BPMNProfilePackage.BPMN_ACTIVITY__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceFlow getDefault() {
		if (default_ != null && default_.eIsProxy()) {
			InternalEObject oldDefault = (InternalEObject)default_;
			default_ = (SequenceFlow)eResolveProxy(oldDefault);
			if (default_ != oldDefault) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.BPMN_ACTIVITY__DEFAULT, oldDefault, default_));
			}
		}
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceFlow basicGetDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(SequenceFlow newDefault) {
		SequenceFlow oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_ACTIVITY__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BoundaryEvent> getBoundaryEventRefs() {
		if (boundaryEventRefs == null) {
			boundaryEventRefs = new EObjectResolvingEList<BoundaryEvent>(BoundaryEvent.class, this, BPMNProfilePackage.BPMN_ACTIVITY__BOUNDARY_EVENT_REFS);
		}
		return boundaryEventRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataInputAssociation> getDataInputAssociations() {
		if (dataInputAssociations == null) {
			dataInputAssociations = new EObjectResolvingEList<DataInputAssociation>(DataInputAssociation.class, this, BPMNProfilePackage.BPMN_ACTIVITY__DATA_INPUT_ASSOCIATIONS);
		}
		return dataInputAssociations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataOutputAssociation> getDataOutputAssociations() {
		if (dataOutputAssociations == null) {
			dataOutputAssociations = new EObjectResolvingEList<DataOutputAssociation>(DataOutputAssociation.class, this, BPMNProfilePackage.BPMN_ACTIVITY__DATA_OUTPUT_ASSOCIATIONS);
		}
		return dataOutputAssociations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopCharacteristics getLoopCharacteristics() {
		if (loopCharacteristics != null && loopCharacteristics.eIsProxy()) {
			InternalEObject oldLoopCharacteristics = (InternalEObject)loopCharacteristics;
			loopCharacteristics = (LoopCharacteristics)eResolveProxy(oldLoopCharacteristics);
			if (loopCharacteristics != oldLoopCharacteristics) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.BPMN_ACTIVITY__LOOP_CHARACTERISTICS, oldLoopCharacteristics, loopCharacteristics));
			}
		}
		return loopCharacteristics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopCharacteristics basicGetLoopCharacteristics() {
		return loopCharacteristics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopCharacteristics(LoopCharacteristics newLoopCharacteristics) {
		LoopCharacteristics oldLoopCharacteristics = loopCharacteristics;
		loopCharacteristics = newLoopCharacteristics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_ACTIVITY__LOOP_CHARACTERISTICS, oldLoopCharacteristics, loopCharacteristics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceRole> getResources() {
		if (resources == null) {
			resources = new EObjectResolvingEList<ResourceRole>(ResourceRole.class, this, BPMNProfilePackage.BPMN_ACTIVITY__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean BPMNActivityresources(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.BPMN_ACTIVITY__BPMN_ACTIVITYRESOURCES,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "BPMNActivityresources", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean BPMNActivitycontainer(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.BPMN_ACTIVITY__BPMN_ACTIVITYCONTAINER,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "BPMNActivitycontainer", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean BPMNActivityproperties(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.BPMN_ACTIVITY__BPMN_ACTIVITYPROPERTIES,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "BPMNActivityproperties", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean BPMNActivitydefault(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.BPMN_ACTIVITY__BPMN_ACTIVITYDEFAULT,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "BPMNActivitydefault", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean BPMNActivityboundaryEventsRefs(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.BPMN_ACTIVITY__BPMN_ACTIVITYBOUNDARY_EVENTS_REFS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "BPMNActivityboundaryEventsRefs", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean BPMNActivityloopCharacteristics(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.BPMN_ACTIVITY__BPMN_ACTIVITYLOOP_CHARACTERISTICS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "BPMNActivityloopCharacteristics", EObjectValidator.getObjectLabel(this, context) }),
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.BPMN_ACTIVITY__IS_FOR_COMPENSATION:
				return isForCompensation();
			case BPMNProfilePackage.BPMN_ACTIVITY__START_QUANTITY:
				return getStartQuantity();
			case BPMNProfilePackage.BPMN_ACTIVITY__COMPLETION_QUANTITY:
				return getCompletionQuantity();
			case BPMNProfilePackage.BPMN_ACTIVITY__BASE_ACTION:
				if (resolve) return getBase_Action();
				return basicGetBase_Action();
			case BPMNProfilePackage.BPMN_ACTIVITY__ACTIVITY_CLASS:
				if (resolve) return getActivityClass();
				return basicGetActivityClass();
			case BPMNProfilePackage.BPMN_ACTIVITY__PROPERTIES:
				return getProperties();
			case BPMNProfilePackage.BPMN_ACTIVITY__DEFAULT:
				if (resolve) return getDefault();
				return basicGetDefault();
			case BPMNProfilePackage.BPMN_ACTIVITY__BOUNDARY_EVENT_REFS:
				return getBoundaryEventRefs();
			case BPMNProfilePackage.BPMN_ACTIVITY__DATA_INPUT_ASSOCIATIONS:
				return getDataInputAssociations();
			case BPMNProfilePackage.BPMN_ACTIVITY__DATA_OUTPUT_ASSOCIATIONS:
				return getDataOutputAssociations();
			case BPMNProfilePackage.BPMN_ACTIVITY__LOOP_CHARACTERISTICS:
				if (resolve) return getLoopCharacteristics();
				return basicGetLoopCharacteristics();
			case BPMNProfilePackage.BPMN_ACTIVITY__RESOURCES:
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
			case BPMNProfilePackage.BPMN_ACTIVITY__IS_FOR_COMPENSATION:
				setIsForCompensation((Boolean)newValue);
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__START_QUANTITY:
				setStartQuantity((Integer)newValue);
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__COMPLETION_QUANTITY:
				setCompletionQuantity((Integer)newValue);
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__BASE_ACTION:
				setBase_Action((Action)newValue);
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__ACTIVITY_CLASS:
				setActivityClass((org.eclipse.uml2.uml.Class)newValue);
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends BPMNProperty>)newValue);
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__DEFAULT:
				setDefault((SequenceFlow)newValue);
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__BOUNDARY_EVENT_REFS:
				getBoundaryEventRefs().clear();
				getBoundaryEventRefs().addAll((Collection<? extends BoundaryEvent>)newValue);
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__DATA_INPUT_ASSOCIATIONS:
				getDataInputAssociations().clear();
				getDataInputAssociations().addAll((Collection<? extends DataInputAssociation>)newValue);
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__DATA_OUTPUT_ASSOCIATIONS:
				getDataOutputAssociations().clear();
				getDataOutputAssociations().addAll((Collection<? extends DataOutputAssociation>)newValue);
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__LOOP_CHARACTERISTICS:
				setLoopCharacteristics((LoopCharacteristics)newValue);
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__RESOURCES:
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
			case BPMNProfilePackage.BPMN_ACTIVITY__IS_FOR_COMPENSATION:
				setIsForCompensation(IS_FOR_COMPENSATION_EDEFAULT);
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__START_QUANTITY:
				setStartQuantity(START_QUANTITY_EDEFAULT);
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__COMPLETION_QUANTITY:
				setCompletionQuantity(COMPLETION_QUANTITY_EDEFAULT);
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__BASE_ACTION:
				setBase_Action((Action)null);
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__ACTIVITY_CLASS:
				setActivityClass((org.eclipse.uml2.uml.Class)null);
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__PROPERTIES:
				getProperties().clear();
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__DEFAULT:
				setDefault((SequenceFlow)null);
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__BOUNDARY_EVENT_REFS:
				getBoundaryEventRefs().clear();
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__DATA_INPUT_ASSOCIATIONS:
				getDataInputAssociations().clear();
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__DATA_OUTPUT_ASSOCIATIONS:
				getDataOutputAssociations().clear();
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__LOOP_CHARACTERISTICS:
				setLoopCharacteristics((LoopCharacteristics)null);
				return;
			case BPMNProfilePackage.BPMN_ACTIVITY__RESOURCES:
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
			case BPMNProfilePackage.BPMN_ACTIVITY__IS_FOR_COMPENSATION:
				return isForCompensation != IS_FOR_COMPENSATION_EDEFAULT;
			case BPMNProfilePackage.BPMN_ACTIVITY__START_QUANTITY:
				return startQuantity != START_QUANTITY_EDEFAULT;
			case BPMNProfilePackage.BPMN_ACTIVITY__COMPLETION_QUANTITY:
				return completionQuantity != COMPLETION_QUANTITY_EDEFAULT;
			case BPMNProfilePackage.BPMN_ACTIVITY__BASE_ACTION:
				return base_Action != null;
			case BPMNProfilePackage.BPMN_ACTIVITY__ACTIVITY_CLASS:
				return activityClass != null;
			case BPMNProfilePackage.BPMN_ACTIVITY__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case BPMNProfilePackage.BPMN_ACTIVITY__DEFAULT:
				return default_ != null;
			case BPMNProfilePackage.BPMN_ACTIVITY__BOUNDARY_EVENT_REFS:
				return boundaryEventRefs != null && !boundaryEventRefs.isEmpty();
			case BPMNProfilePackage.BPMN_ACTIVITY__DATA_INPUT_ASSOCIATIONS:
				return dataInputAssociations != null && !dataInputAssociations.isEmpty();
			case BPMNProfilePackage.BPMN_ACTIVITY__DATA_OUTPUT_ASSOCIATIONS:
				return dataOutputAssociations != null && !dataOutputAssociations.isEmpty();
			case BPMNProfilePackage.BPMN_ACTIVITY__LOOP_CHARACTERISTICS:
				return loopCharacteristics != null;
			case BPMNProfilePackage.BPMN_ACTIVITY__RESOURCES:
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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BPMNProfilePackage.BPMN_ACTIVITY___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP:
				return BPMNActivityresources((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.BPMN_ACTIVITY___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP:
				return BPMNActivitycontainer((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.BPMN_ACTIVITY___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP:
				return BPMNActivityproperties((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.BPMN_ACTIVITY___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP:
				return BPMNActivitydefault((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.BPMN_ACTIVITY___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP:
				return BPMNActivityboundaryEventsRefs((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.BPMN_ACTIVITY___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP:
				return BPMNActivityloopCharacteristics((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		result.append(" (isForCompensation: ");
		result.append(isForCompensation);
		result.append(", startQuantity: ");
		result.append(startQuantity);
		result.append(", completionQuantity: ");
		result.append(completionQuantity);
		result.append(')');
		return result.toString();
	}

} //BPMNActivityImpl
