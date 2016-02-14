/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataInput;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput;
import org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification;
import org.eclipse.papyrus.bpmn.BPMNProfile.InputSet;
import org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Behavior;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Output Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputOutputSpecificationImpl#getBase_Behavior <em>Base Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputOutputSpecificationImpl#getBase_Action <em>Base Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputOutputSpecificationImpl#getDataInputs <em>Data Inputs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputOutputSpecificationImpl#getDataOutputs <em>Data Outputs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputOutputSpecificationImpl#getInputSets <em>Input Sets</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputOutputSpecificationImpl#getOutputSets <em>Output Sets</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InputOutputSpecificationImpl extends BaseElementImpl implements InputOutputSpecification {
	/**
	 * The cached value of the '{@link #getBase_Behavior() <em>Base Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Behavior()
	 * @generated
	 * @ordered
	 */
	protected Behavior base_Behavior;

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
	 * The cached value of the '{@link #getDataInputs() <em>Data Inputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<DataInput> dataInputs;

	/**
	 * The cached value of the '{@link #getDataOutputs() <em>Data Outputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<DataOutput> dataOutputs;

	/**
	 * The cached value of the '{@link #getInputSets() <em>Input Sets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputSets()
	 * @generated
	 * @ordered
	 */
	protected EList<InputSet> inputSets;

	/**
	 * The cached value of the '{@link #getOutputSets() <em>Output Sets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputSets()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputSet> outputSets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputOutputSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getInputOutputSpecification();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behavior getBase_Behavior() {
		if (base_Behavior != null && base_Behavior.eIsProxy()) {
			InternalEObject oldBase_Behavior = (InternalEObject)base_Behavior;
			base_Behavior = (Behavior)eResolveProxy(oldBase_Behavior);
			if (base_Behavior != oldBase_Behavior) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__BASE_BEHAVIOR, oldBase_Behavior, base_Behavior));
			}
		}
		return base_Behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behavior basicGetBase_Behavior() {
		return base_Behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Behavior(Behavior newBase_Behavior) {
		Behavior oldBase_Behavior = base_Behavior;
		base_Behavior = newBase_Behavior;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__BASE_BEHAVIOR, oldBase_Behavior, base_Behavior));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__BASE_ACTION, oldBase_Action, base_Action));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__BASE_ACTION, oldBase_Action, base_Action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataInput> getDataInputs() {
		if (dataInputs == null) {
			dataInputs = new EObjectResolvingEList<DataInput>(DataInput.class, this, BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__DATA_INPUTS);
		}
		return dataInputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataOutput> getDataOutputs() {
		if (dataOutputs == null) {
			dataOutputs = new EObjectResolvingEList<DataOutput>(DataOutput.class, this, BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__DATA_OUTPUTS);
		}
		return dataOutputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputSet> getInputSets() {
		if (inputSets == null) {
			inputSets = new EObjectResolvingEList<InputSet>(InputSet.class, this, BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__INPUT_SETS);
		}
		return inputSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputSet> getOutputSets() {
		if (outputSets == null) {
			outputSets = new EObjectResolvingEList<OutputSet>(OutputSet.class, this, BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__OUTPUT_SETS);
		}
		return outputSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__BASE_BEHAVIOR:
				if (resolve) return getBase_Behavior();
				return basicGetBase_Behavior();
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__BASE_ACTION:
				if (resolve) return getBase_Action();
				return basicGetBase_Action();
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__DATA_INPUTS:
				return getDataInputs();
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__DATA_OUTPUTS:
				return getDataOutputs();
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__INPUT_SETS:
				return getInputSets();
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__OUTPUT_SETS:
				return getOutputSets();
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
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__BASE_BEHAVIOR:
				setBase_Behavior((Behavior)newValue);
				return;
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__BASE_ACTION:
				setBase_Action((Action)newValue);
				return;
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__DATA_INPUTS:
				getDataInputs().clear();
				getDataInputs().addAll((Collection<? extends DataInput>)newValue);
				return;
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__DATA_OUTPUTS:
				getDataOutputs().clear();
				getDataOutputs().addAll((Collection<? extends DataOutput>)newValue);
				return;
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__INPUT_SETS:
				getInputSets().clear();
				getInputSets().addAll((Collection<? extends InputSet>)newValue);
				return;
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__OUTPUT_SETS:
				getOutputSets().clear();
				getOutputSets().addAll((Collection<? extends OutputSet>)newValue);
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
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__BASE_BEHAVIOR:
				setBase_Behavior((Behavior)null);
				return;
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__BASE_ACTION:
				setBase_Action((Action)null);
				return;
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__DATA_INPUTS:
				getDataInputs().clear();
				return;
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__DATA_OUTPUTS:
				getDataOutputs().clear();
				return;
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__INPUT_SETS:
				getInputSets().clear();
				return;
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__OUTPUT_SETS:
				getOutputSets().clear();
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
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__BASE_BEHAVIOR:
				return base_Behavior != null;
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__BASE_ACTION:
				return base_Action != null;
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__DATA_INPUTS:
				return dataInputs != null && !dataInputs.isEmpty();
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__DATA_OUTPUTS:
				return dataOutputs != null && !dataOutputs.isEmpty();
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__INPUT_SETS:
				return inputSets != null && !inputSets.isEmpty();
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION__OUTPUT_SETS:
				return outputSets != null && !outputSets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InputOutputSpecificationImpl
