/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.GlobalScriptTask;
import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Global Script Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.GlobalScriptTaskImpl#getScript <em>Script</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.GlobalScriptTaskImpl#getScriptFormat <em>Script Format</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GlobalScriptTaskImpl extends GlobalTaskImpl implements GlobalScriptTask {
	/**
	 * The cached value of the '{@link #getScript() <em>Script</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScript()
	 * @generated
	 * @ordered
	 */
	protected EList<String> script;
	/**
	 * The cached value of the '{@link #getScriptFormat() <em>Script Format</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptFormat()
	 * @generated
	 * @ordered
	 */
	protected EList<String> scriptFormat;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GlobalScriptTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getGlobalScriptTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getScript() {
		if (script == null) {
			script = new EDataTypeEList<String>(String.class, this, BPMNProfilePackage.GLOBAL_SCRIPT_TASK__SCRIPT);
		}
		return script;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getScriptFormat() {
		if (scriptFormat == null) {
			scriptFormat = new EDataTypeUniqueEList<String>(String.class, this, BPMNProfilePackage.GLOBAL_SCRIPT_TASK__SCRIPT_FORMAT);
		}
		return scriptFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean GlobalScriptTaskscriptFormat(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.GLOBAL_SCRIPT_TASK__GLOBAL_SCRIPT_TASKSCRIPT_FORMAT,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "GlobalScriptTaskscriptFormat", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean GlobalScriptTaskscript(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.GLOBAL_SCRIPT_TASK__GLOBAL_SCRIPT_TASKSCRIPT,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "GlobalScriptTaskscript", EObjectValidator.getObjectLabel(this, context) }),
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
			case BPMNProfilePackage.GLOBAL_SCRIPT_TASK__SCRIPT:
				return getScript();
			case BPMNProfilePackage.GLOBAL_SCRIPT_TASK__SCRIPT_FORMAT:
				return getScriptFormat();
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
			case BPMNProfilePackage.GLOBAL_SCRIPT_TASK__SCRIPT:
				getScript().clear();
				getScript().addAll((Collection<? extends String>)newValue);
				return;
			case BPMNProfilePackage.GLOBAL_SCRIPT_TASK__SCRIPT_FORMAT:
				getScriptFormat().clear();
				getScriptFormat().addAll((Collection<? extends String>)newValue);
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
			case BPMNProfilePackage.GLOBAL_SCRIPT_TASK__SCRIPT:
				getScript().clear();
				return;
			case BPMNProfilePackage.GLOBAL_SCRIPT_TASK__SCRIPT_FORMAT:
				getScriptFormat().clear();
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
			case BPMNProfilePackage.GLOBAL_SCRIPT_TASK__SCRIPT:
				return script != null && !script.isEmpty();
			case BPMNProfilePackage.GLOBAL_SCRIPT_TASK__SCRIPT_FORMAT:
				return scriptFormat != null && !scriptFormat.isEmpty();
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
			case BPMNProfilePackage.GLOBAL_SCRIPT_TASK___GLOBAL_SCRIPT_TASKSCRIPT_FORMAT__DIAGNOSTICCHAIN_MAP:
				return GlobalScriptTaskscriptFormat((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.GLOBAL_SCRIPT_TASK___GLOBAL_SCRIPT_TASKSCRIPT__DIAGNOSTICCHAIN_MAP:
				return GlobalScriptTaskscript((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		result.append(" (script: ");
		result.append(script);
		result.append(", scriptFormat: ");
		result.append(scriptFormat);
		result.append(')');
		return result.toString();
	}

} //GlobalScriptTaskImpl
