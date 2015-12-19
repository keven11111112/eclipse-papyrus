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

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExpression;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.ComplexBehaviorDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataInput;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput;
import org.eclipse.papyrus.bpmn.BPMNProfile.EventDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.ItemAwareElement;
import org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceBehavior;
import org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics;

import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;

import org.eclipse.uml2.uml.ExpansionRegion;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Instance Loop Characteristics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MultiInstanceLoopCharacteristicsImpl#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MultiInstanceLoopCharacteristicsImpl#getLoopCardinality <em>Loop Cardinality</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MultiInstanceLoopCharacteristicsImpl#getCompletionCondition <em>Completion Condition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MultiInstanceLoopCharacteristicsImpl#getBase_ExpansionRegion <em>Base Expansion Region</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MultiInstanceLoopCharacteristicsImpl#isSequential <em>Is Sequential</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MultiInstanceLoopCharacteristicsImpl#getLoopDataInputRef <em>Loop Data Input Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MultiInstanceLoopCharacteristicsImpl#getLoopDataOutputRef <em>Loop Data Output Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MultiInstanceLoopCharacteristicsImpl#getOutputDataItem <em>Output Data Item</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MultiInstanceLoopCharacteristicsImpl#getInputDataItem <em>Input Data Item</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MultiInstanceLoopCharacteristicsImpl#getOneBehaviorEventRef <em>One Behavior Event Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MultiInstanceLoopCharacteristicsImpl#getNoneBehaviorEventRef <em>None Behavior Event Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MultiInstanceLoopCharacteristicsImpl#getComplexBehaviorDefinition <em>Complex Behavior Definition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MultiInstanceLoopCharacteristicsImpl extends LoopCharacteristicsImpl implements MultiInstanceLoopCharacteristics {
	/**
	 * The default value of the '{@link #getBehavior() <em>Behavior</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavior()
	 * @generated
	 * @ordered
	 */
	protected static final MultiInstanceBehavior BEHAVIOR_EDEFAULT = MultiInstanceBehavior.ALL;

	/**
	 * The cached value of the '{@link #getBehavior() <em>Behavior</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavior()
	 * @generated
	 * @ordered
	 */
	protected MultiInstanceBehavior behavior = BEHAVIOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLoopCardinality() <em>Loop Cardinality</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopCardinality()
	 * @generated
	 * @ordered
	 */
	protected BPMNExpression loopCardinality;

	/**
	 * The cached value of the '{@link #getCompletionCondition() <em>Completion Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompletionCondition()
	 * @generated
	 * @ordered
	 */
	protected BPMNExpression completionCondition;

	/**
	 * The cached value of the '{@link #getBase_ExpansionRegion() <em>Base Expansion Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_ExpansionRegion()
	 * @generated
	 * @ordered
	 */
	protected ExpansionRegion base_ExpansionRegion;

	/**
	 * The default value of the '{@link #isSequential() <em>Is Sequential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSequential()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SEQUENTIAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSequential() <em>Is Sequential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSequential()
	 * @generated
	 * @ordered
	 */
	protected boolean isSequential = IS_SEQUENTIAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLoopDataInputRef() <em>Loop Data Input Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopDataInputRef()
	 * @generated
	 * @ordered
	 */
	protected ItemAwareElement loopDataInputRef;

	/**
	 * The cached value of the '{@link #getLoopDataOutputRef() <em>Loop Data Output Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopDataOutputRef()
	 * @generated
	 * @ordered
	 */
	protected ItemAwareElement loopDataOutputRef;

	/**
	 * The cached value of the '{@link #getOutputDataItem() <em>Output Data Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputDataItem()
	 * @generated
	 * @ordered
	 */
	protected DataOutput outputDataItem;

	/**
	 * The cached value of the '{@link #getInputDataItem() <em>Input Data Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputDataItem()
	 * @generated
	 * @ordered
	 */
	protected DataInput inputDataItem;

	/**
	 * The cached value of the '{@link #getOneBehaviorEventRef() <em>One Behavior Event Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOneBehaviorEventRef()
	 * @generated
	 * @ordered
	 */
	protected EventDefinition oneBehaviorEventRef;

	/**
	 * The cached value of the '{@link #getNoneBehaviorEventRef() <em>None Behavior Event Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoneBehaviorEventRef()
	 * @generated
	 * @ordered
	 */
	protected EventDefinition noneBehaviorEventRef;

	/**
	 * The cached value of the '{@link #getComplexBehaviorDefinition() <em>Complex Behavior Definition</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComplexBehaviorDefinition()
	 * @generated
	 * @ordered
	 */
	protected EList<ComplexBehaviorDefinition> complexBehaviorDefinition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiInstanceLoopCharacteristicsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getMultiInstanceLoopCharacteristics();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiInstanceBehavior getBehavior() {
		return behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehavior(MultiInstanceBehavior newBehavior) {
		MultiInstanceBehavior oldBehavior = behavior;
		behavior = newBehavior == null ? BEHAVIOR_EDEFAULT : newBehavior;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__BEHAVIOR, oldBehavior, behavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNExpression getLoopCardinality() {
		if (loopCardinality != null && loopCardinality.eIsProxy()) {
			InternalEObject oldLoopCardinality = (InternalEObject)loopCardinality;
			loopCardinality = (BPMNExpression)eResolveProxy(oldLoopCardinality);
			if (loopCardinality != oldLoopCardinality) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_CARDINALITY, oldLoopCardinality, loopCardinality));
			}
		}
		return loopCardinality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNExpression basicGetLoopCardinality() {
		return loopCardinality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopCardinality(BPMNExpression newLoopCardinality) {
		BPMNExpression oldLoopCardinality = loopCardinality;
		loopCardinality = newLoopCardinality;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_CARDINALITY, oldLoopCardinality, loopCardinality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNExpression getCompletionCondition() {
		if (completionCondition != null && completionCondition.eIsProxy()) {
			InternalEObject oldCompletionCondition = (InternalEObject)completionCondition;
			completionCondition = (BPMNExpression)eResolveProxy(oldCompletionCondition);
			if (completionCondition != oldCompletionCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__COMPLETION_CONDITION, oldCompletionCondition, completionCondition));
			}
		}
		return completionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNExpression basicGetCompletionCondition() {
		return completionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompletionCondition(BPMNExpression newCompletionCondition) {
		BPMNExpression oldCompletionCondition = completionCondition;
		completionCondition = newCompletionCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__COMPLETION_CONDITION, oldCompletionCondition, completionCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionRegion getBase_ExpansionRegion() {
		if (base_ExpansionRegion != null && base_ExpansionRegion.eIsProxy()) {
			InternalEObject oldBase_ExpansionRegion = (InternalEObject)base_ExpansionRegion;
			base_ExpansionRegion = (ExpansionRegion)eResolveProxy(oldBase_ExpansionRegion);
			if (base_ExpansionRegion != oldBase_ExpansionRegion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__BASE_EXPANSION_REGION, oldBase_ExpansionRegion, base_ExpansionRegion));
			}
		}
		return base_ExpansionRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionRegion basicGetBase_ExpansionRegion() {
		return base_ExpansionRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_ExpansionRegion(ExpansionRegion newBase_ExpansionRegion) {
		ExpansionRegion oldBase_ExpansionRegion = base_ExpansionRegion;
		base_ExpansionRegion = newBase_ExpansionRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__BASE_EXPANSION_REGION, oldBase_ExpansionRegion, base_ExpansionRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSequential() {
		return isSequential;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSequential(boolean newIsSequential) {
		boolean oldIsSequential = isSequential;
		isSequential = newIsSequential;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__IS_SEQUENTIAL, oldIsSequential, isSequential));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemAwareElement getLoopDataInputRef() {
		if (loopDataInputRef != null && loopDataInputRef.eIsProxy()) {
			InternalEObject oldLoopDataInputRef = (InternalEObject)loopDataInputRef;
			loopDataInputRef = (ItemAwareElement)eResolveProxy(oldLoopDataInputRef);
			if (loopDataInputRef != oldLoopDataInputRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_DATA_INPUT_REF, oldLoopDataInputRef, loopDataInputRef));
			}
		}
		return loopDataInputRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemAwareElement basicGetLoopDataInputRef() {
		return loopDataInputRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopDataInputRef(ItemAwareElement newLoopDataInputRef) {
		ItemAwareElement oldLoopDataInputRef = loopDataInputRef;
		loopDataInputRef = newLoopDataInputRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_DATA_INPUT_REF, oldLoopDataInputRef, loopDataInputRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemAwareElement getLoopDataOutputRef() {
		if (loopDataOutputRef != null && loopDataOutputRef.eIsProxy()) {
			InternalEObject oldLoopDataOutputRef = (InternalEObject)loopDataOutputRef;
			loopDataOutputRef = (ItemAwareElement)eResolveProxy(oldLoopDataOutputRef);
			if (loopDataOutputRef != oldLoopDataOutputRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_DATA_OUTPUT_REF, oldLoopDataOutputRef, loopDataOutputRef));
			}
		}
		return loopDataOutputRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemAwareElement basicGetLoopDataOutputRef() {
		return loopDataOutputRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopDataOutputRef(ItemAwareElement newLoopDataOutputRef) {
		ItemAwareElement oldLoopDataOutputRef = loopDataOutputRef;
		loopDataOutputRef = newLoopDataOutputRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_DATA_OUTPUT_REF, oldLoopDataOutputRef, loopDataOutputRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataOutput getOutputDataItem() {
		if (outputDataItem != null && outputDataItem.eIsProxy()) {
			InternalEObject oldOutputDataItem = (InternalEObject)outputDataItem;
			outputDataItem = (DataOutput)eResolveProxy(oldOutputDataItem);
			if (outputDataItem != oldOutputDataItem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__OUTPUT_DATA_ITEM, oldOutputDataItem, outputDataItem));
			}
		}
		return outputDataItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataOutput basicGetOutputDataItem() {
		return outputDataItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputDataItem(DataOutput newOutputDataItem) {
		DataOutput oldOutputDataItem = outputDataItem;
		outputDataItem = newOutputDataItem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__OUTPUT_DATA_ITEM, oldOutputDataItem, outputDataItem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataInput getInputDataItem() {
		if (inputDataItem != null && inputDataItem.eIsProxy()) {
			InternalEObject oldInputDataItem = (InternalEObject)inputDataItem;
			inputDataItem = (DataInput)eResolveProxy(oldInputDataItem);
			if (inputDataItem != oldInputDataItem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__INPUT_DATA_ITEM, oldInputDataItem, inputDataItem));
			}
		}
		return inputDataItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataInput basicGetInputDataItem() {
		return inputDataItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputDataItem(DataInput newInputDataItem) {
		DataInput oldInputDataItem = inputDataItem;
		inputDataItem = newInputDataItem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__INPUT_DATA_ITEM, oldInputDataItem, inputDataItem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventDefinition getOneBehaviorEventRef() {
		if (oneBehaviorEventRef != null && oneBehaviorEventRef.eIsProxy()) {
			InternalEObject oldOneBehaviorEventRef = (InternalEObject)oneBehaviorEventRef;
			oneBehaviorEventRef = (EventDefinition)eResolveProxy(oldOneBehaviorEventRef);
			if (oneBehaviorEventRef != oldOneBehaviorEventRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__ONE_BEHAVIOR_EVENT_REF, oldOneBehaviorEventRef, oneBehaviorEventRef));
			}
		}
		return oneBehaviorEventRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventDefinition basicGetOneBehaviorEventRef() {
		return oneBehaviorEventRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOneBehaviorEventRef(EventDefinition newOneBehaviorEventRef) {
		EventDefinition oldOneBehaviorEventRef = oneBehaviorEventRef;
		oneBehaviorEventRef = newOneBehaviorEventRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__ONE_BEHAVIOR_EVENT_REF, oldOneBehaviorEventRef, oneBehaviorEventRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventDefinition getNoneBehaviorEventRef() {
		if (noneBehaviorEventRef != null && noneBehaviorEventRef.eIsProxy()) {
			InternalEObject oldNoneBehaviorEventRef = (InternalEObject)noneBehaviorEventRef;
			noneBehaviorEventRef = (EventDefinition)eResolveProxy(oldNoneBehaviorEventRef);
			if (noneBehaviorEventRef != oldNoneBehaviorEventRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__NONE_BEHAVIOR_EVENT_REF, oldNoneBehaviorEventRef, noneBehaviorEventRef));
			}
		}
		return noneBehaviorEventRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventDefinition basicGetNoneBehaviorEventRef() {
		return noneBehaviorEventRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoneBehaviorEventRef(EventDefinition newNoneBehaviorEventRef) {
		EventDefinition oldNoneBehaviorEventRef = noneBehaviorEventRef;
		noneBehaviorEventRef = newNoneBehaviorEventRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__NONE_BEHAVIOR_EVENT_REF, oldNoneBehaviorEventRef, noneBehaviorEventRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComplexBehaviorDefinition> getComplexBehaviorDefinition() {
		if (complexBehaviorDefinition == null) {
			complexBehaviorDefinition = new EObjectResolvingEList<ComplexBehaviorDefinition>(ComplexBehaviorDefinition.class, this, BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__COMPLEX_BEHAVIOR_DEFINITION);
		}
		return complexBehaviorDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean MultiinstanceLoopCharacteristicstarget(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.MULTI_INSTANCE_LOOP_CHARACTERISTICS__MULTIINSTANCE_LOOP_CHARACTERISTICSTARGET,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "MultiinstanceLoopCharacteristicstarget", EObjectValidator.getObjectLabel(this, context) }),
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
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__BEHAVIOR:
				return getBehavior();
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_CARDINALITY:
				if (resolve) return getLoopCardinality();
				return basicGetLoopCardinality();
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__COMPLETION_CONDITION:
				if (resolve) return getCompletionCondition();
				return basicGetCompletionCondition();
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__BASE_EXPANSION_REGION:
				if (resolve) return getBase_ExpansionRegion();
				return basicGetBase_ExpansionRegion();
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__IS_SEQUENTIAL:
				return isSequential();
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_DATA_INPUT_REF:
				if (resolve) return getLoopDataInputRef();
				return basicGetLoopDataInputRef();
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_DATA_OUTPUT_REF:
				if (resolve) return getLoopDataOutputRef();
				return basicGetLoopDataOutputRef();
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__OUTPUT_DATA_ITEM:
				if (resolve) return getOutputDataItem();
				return basicGetOutputDataItem();
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__INPUT_DATA_ITEM:
				if (resolve) return getInputDataItem();
				return basicGetInputDataItem();
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__ONE_BEHAVIOR_EVENT_REF:
				if (resolve) return getOneBehaviorEventRef();
				return basicGetOneBehaviorEventRef();
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__NONE_BEHAVIOR_EVENT_REF:
				if (resolve) return getNoneBehaviorEventRef();
				return basicGetNoneBehaviorEventRef();
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__COMPLEX_BEHAVIOR_DEFINITION:
				return getComplexBehaviorDefinition();
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
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__BEHAVIOR:
				setBehavior((MultiInstanceBehavior)newValue);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_CARDINALITY:
				setLoopCardinality((BPMNExpression)newValue);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__COMPLETION_CONDITION:
				setCompletionCondition((BPMNExpression)newValue);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__BASE_EXPANSION_REGION:
				setBase_ExpansionRegion((ExpansionRegion)newValue);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__IS_SEQUENTIAL:
				setIsSequential((Boolean)newValue);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_DATA_INPUT_REF:
				setLoopDataInputRef((ItemAwareElement)newValue);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_DATA_OUTPUT_REF:
				setLoopDataOutputRef((ItemAwareElement)newValue);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__OUTPUT_DATA_ITEM:
				setOutputDataItem((DataOutput)newValue);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__INPUT_DATA_ITEM:
				setInputDataItem((DataInput)newValue);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__ONE_BEHAVIOR_EVENT_REF:
				setOneBehaviorEventRef((EventDefinition)newValue);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__NONE_BEHAVIOR_EVENT_REF:
				setNoneBehaviorEventRef((EventDefinition)newValue);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__COMPLEX_BEHAVIOR_DEFINITION:
				getComplexBehaviorDefinition().clear();
				getComplexBehaviorDefinition().addAll((Collection<? extends ComplexBehaviorDefinition>)newValue);
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
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__BEHAVIOR:
				setBehavior(BEHAVIOR_EDEFAULT);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_CARDINALITY:
				setLoopCardinality((BPMNExpression)null);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__COMPLETION_CONDITION:
				setCompletionCondition((BPMNExpression)null);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__BASE_EXPANSION_REGION:
				setBase_ExpansionRegion((ExpansionRegion)null);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__IS_SEQUENTIAL:
				setIsSequential(IS_SEQUENTIAL_EDEFAULT);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_DATA_INPUT_REF:
				setLoopDataInputRef((ItemAwareElement)null);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_DATA_OUTPUT_REF:
				setLoopDataOutputRef((ItemAwareElement)null);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__OUTPUT_DATA_ITEM:
				setOutputDataItem((DataOutput)null);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__INPUT_DATA_ITEM:
				setInputDataItem((DataInput)null);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__ONE_BEHAVIOR_EVENT_REF:
				setOneBehaviorEventRef((EventDefinition)null);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__NONE_BEHAVIOR_EVENT_REF:
				setNoneBehaviorEventRef((EventDefinition)null);
				return;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__COMPLEX_BEHAVIOR_DEFINITION:
				getComplexBehaviorDefinition().clear();
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
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__BEHAVIOR:
				return behavior != BEHAVIOR_EDEFAULT;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_CARDINALITY:
				return loopCardinality != null;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__COMPLETION_CONDITION:
				return completionCondition != null;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__BASE_EXPANSION_REGION:
				return base_ExpansionRegion != null;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__IS_SEQUENTIAL:
				return isSequential != IS_SEQUENTIAL_EDEFAULT;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_DATA_INPUT_REF:
				return loopDataInputRef != null;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_DATA_OUTPUT_REF:
				return loopDataOutputRef != null;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__OUTPUT_DATA_ITEM:
				return outputDataItem != null;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__INPUT_DATA_ITEM:
				return inputDataItem != null;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__ONE_BEHAVIOR_EVENT_REF:
				return oneBehaviorEventRef != null;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__NONE_BEHAVIOR_EVENT_REF:
				return noneBehaviorEventRef != null;
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS__COMPLEX_BEHAVIOR_DEFINITION:
				return complexBehaviorDefinition != null && !complexBehaviorDefinition.isEmpty();
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
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS___MULTIINSTANCE_LOOP_CHARACTERISTICSTARGET__DIAGNOSTICCHAIN_MAP:
				return MultiinstanceLoopCharacteristicstarget((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		result.append(" (behavior: ");
		result.append(behavior);
		result.append(", isSequential: ");
		result.append(isSequential);
		result.append(')');
		return result.toString();
	}

} //MultiInstanceLoopCharacteristicsImpl
