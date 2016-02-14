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
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataInput;
import org.eclipse.papyrus.bpmn.BPMNProfile.InputSet;
import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;
import org.eclipse.uml2.uml.ParameterSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputSetImpl#getBase_ParameterSet <em>Base Parameter Set</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputSetImpl#getOptionalInputRefs <em>Optional Input Refs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputSetImpl#getWhileExecutingInputRefs <em>While Executing Input Refs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputSetImpl#getDataInputRefs <em>Data Input Refs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InputSetImpl extends BaseElementImpl implements InputSet {
	/**
	 * The cached value of the '{@link #getBase_ParameterSet() <em>Base Parameter Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_ParameterSet()
	 * @generated
	 * @ordered
	 */
	protected ParameterSet base_ParameterSet;

	/**
	 * The cached value of the '{@link #getOptionalInputRefs() <em>Optional Input Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionalInputRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<DataInput> optionalInputRefs;
	/**
	 * The cached value of the '{@link #getWhileExecutingInputRefs() <em>While Executing Input Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhileExecutingInputRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<DataInput> whileExecutingInputRefs;
	/**
	 * The cached value of the '{@link #getDataInputRefs() <em>Data Input Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataInputRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<DataInput> dataInputRefs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getInputSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterSet getBase_ParameterSet() {
		if (base_ParameterSet != null && base_ParameterSet.eIsProxy()) {
			InternalEObject oldBase_ParameterSet = (InternalEObject)base_ParameterSet;
			base_ParameterSet = (ParameterSet)eResolveProxy(oldBase_ParameterSet);
			if (base_ParameterSet != oldBase_ParameterSet) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.INPUT_SET__BASE_PARAMETER_SET, oldBase_ParameterSet, base_ParameterSet));
			}
		}
		return base_ParameterSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterSet basicGetBase_ParameterSet() {
		return base_ParameterSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_ParameterSet(ParameterSet newBase_ParameterSet) {
		ParameterSet oldBase_ParameterSet = base_ParameterSet;
		base_ParameterSet = newBase_ParameterSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.INPUT_SET__BASE_PARAMETER_SET, oldBase_ParameterSet, base_ParameterSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataInput> getOptionalInputRefs() {
		if (optionalInputRefs == null) {
			optionalInputRefs = new EObjectWithInverseResolvingEList.ManyInverse<DataInput>(DataInput.class, this, BPMNProfilePackage.INPUT_SET__OPTIONAL_INPUT_REFS, BPMNProfilePackage.DATA_INPUT__INPUT_SET_WITH_OPTIONAL);
		}
		return optionalInputRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataInput> getWhileExecutingInputRefs() {
		if (whileExecutingInputRefs == null) {
			whileExecutingInputRefs = new EObjectWithInverseResolvingEList.ManyInverse<DataInput>(DataInput.class, this, BPMNProfilePackage.INPUT_SET__WHILE_EXECUTING_INPUT_REFS, BPMNProfilePackage.DATA_INPUT__INPUT_SET_WITH_WHILE_EXECUTING);
		}
		return whileExecutingInputRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataInput> getDataInputRefs() {
		if (dataInputRefs == null) {
			dataInputRefs = new EObjectWithInverseResolvingEList.ManyInverse<DataInput>(DataInput.class, this, BPMNProfilePackage.INPUT_SET__DATA_INPUT_REFS, BPMNProfilePackage.DATA_INPUT__INPUT_SET_REFS);
		}
		return dataInputRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean InputSetdataInputRefs(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.INPUT_SET__INPUT_SETDATA_INPUT_REFS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "InputSetdataInputRefs", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean InputSetoptionalInputRefs(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.INPUT_SET__INPUT_SETOPTIONAL_INPUT_REFS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "InputSetoptionalInputRefs", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean InputSetwhileExecutingInputRefs(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.INPUT_SET__INPUT_SETWHILE_EXECUTING_INPUT_REFS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "InputSetwhileExecutingInputRefs", EObjectValidator.getObjectLabel(this, context) }),
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
			case BPMNProfilePackage.INPUT_SET__OPTIONAL_INPUT_REFS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOptionalInputRefs()).basicAdd(otherEnd, msgs);
			case BPMNProfilePackage.INPUT_SET__WHILE_EXECUTING_INPUT_REFS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getWhileExecutingInputRefs()).basicAdd(otherEnd, msgs);
			case BPMNProfilePackage.INPUT_SET__DATA_INPUT_REFS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDataInputRefs()).basicAdd(otherEnd, msgs);
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
			case BPMNProfilePackage.INPUT_SET__OPTIONAL_INPUT_REFS:
				return ((InternalEList<?>)getOptionalInputRefs()).basicRemove(otherEnd, msgs);
			case BPMNProfilePackage.INPUT_SET__WHILE_EXECUTING_INPUT_REFS:
				return ((InternalEList<?>)getWhileExecutingInputRefs()).basicRemove(otherEnd, msgs);
			case BPMNProfilePackage.INPUT_SET__DATA_INPUT_REFS:
				return ((InternalEList<?>)getDataInputRefs()).basicRemove(otherEnd, msgs);
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
			case BPMNProfilePackage.INPUT_SET__BASE_PARAMETER_SET:
				if (resolve) return getBase_ParameterSet();
				return basicGetBase_ParameterSet();
			case BPMNProfilePackage.INPUT_SET__OPTIONAL_INPUT_REFS:
				return getOptionalInputRefs();
			case BPMNProfilePackage.INPUT_SET__WHILE_EXECUTING_INPUT_REFS:
				return getWhileExecutingInputRefs();
			case BPMNProfilePackage.INPUT_SET__DATA_INPUT_REFS:
				return getDataInputRefs();
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
			case BPMNProfilePackage.INPUT_SET__BASE_PARAMETER_SET:
				setBase_ParameterSet((ParameterSet)newValue);
				return;
			case BPMNProfilePackage.INPUT_SET__OPTIONAL_INPUT_REFS:
				getOptionalInputRefs().clear();
				getOptionalInputRefs().addAll((Collection<? extends DataInput>)newValue);
				return;
			case BPMNProfilePackage.INPUT_SET__WHILE_EXECUTING_INPUT_REFS:
				getWhileExecutingInputRefs().clear();
				getWhileExecutingInputRefs().addAll((Collection<? extends DataInput>)newValue);
				return;
			case BPMNProfilePackage.INPUT_SET__DATA_INPUT_REFS:
				getDataInputRefs().clear();
				getDataInputRefs().addAll((Collection<? extends DataInput>)newValue);
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
			case BPMNProfilePackage.INPUT_SET__BASE_PARAMETER_SET:
				setBase_ParameterSet((ParameterSet)null);
				return;
			case BPMNProfilePackage.INPUT_SET__OPTIONAL_INPUT_REFS:
				getOptionalInputRefs().clear();
				return;
			case BPMNProfilePackage.INPUT_SET__WHILE_EXECUTING_INPUT_REFS:
				getWhileExecutingInputRefs().clear();
				return;
			case BPMNProfilePackage.INPUT_SET__DATA_INPUT_REFS:
				getDataInputRefs().clear();
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
			case BPMNProfilePackage.INPUT_SET__BASE_PARAMETER_SET:
				return base_ParameterSet != null;
			case BPMNProfilePackage.INPUT_SET__OPTIONAL_INPUT_REFS:
				return optionalInputRefs != null && !optionalInputRefs.isEmpty();
			case BPMNProfilePackage.INPUT_SET__WHILE_EXECUTING_INPUT_REFS:
				return whileExecutingInputRefs != null && !whileExecutingInputRefs.isEmpty();
			case BPMNProfilePackage.INPUT_SET__DATA_INPUT_REFS:
				return dataInputRefs != null && !dataInputRefs.isEmpty();
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
			case BPMNProfilePackage.INPUT_SET___INPUT_SETDATA_INPUT_REFS__DIAGNOSTICCHAIN_MAP:
				return InputSetdataInputRefs((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.INPUT_SET___INPUT_SETOPTIONAL_INPUT_REFS__DIAGNOSTICCHAIN_MAP:
				return InputSetoptionalInputRefs((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.INPUT_SET___INPUT_SETWHILE_EXECUTING_INPUT_REFS__DIAGNOSTICCHAIN_MAP:
				return InputSetwhileExecutingInputRefs((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //InputSetImpl
