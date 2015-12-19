/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Script Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalScriptTask#getScript <em>Script</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalScriptTask#getScriptFormat <em>Script Format</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getGlobalScriptTask()
 * @model
 * @generated
 */
public interface GlobalScriptTask extends GlobalTask {
	/**
	 * Returns the value of the '<em><b>Script</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script</em>' attribute list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getGlobalScriptTask_Script()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true"
	 * @generated
	 */
	EList<String> getScript();

	/**
	 * Returns the value of the '<em><b>Script Format</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Format</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Format</em>' attribute list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getGlobalScriptTask_ScriptFormat()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 * @generated
	 */
	EList<String> getScriptFormat();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * GlobalScriptTask::/scriptFormat : String [*] {ordered}= OpaqueBehavior.language
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='GlobalScriptTask.scriptFormat'"
	 * @generated
	 */
	boolean GlobalScriptTaskscriptFormat(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * GlobalScriptTask::/script : String [*] {ordered, non-unique}= OpaqueBehavior.body
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='GlobalScriptTask.script'"
	 * @generated
	 */
	boolean GlobalScriptTaskscript(DiagnosticChain diagnostics, Map<Object, Object> context);

} // GlobalScriptTask
