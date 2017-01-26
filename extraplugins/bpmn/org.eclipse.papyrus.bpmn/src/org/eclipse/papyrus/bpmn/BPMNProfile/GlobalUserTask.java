/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global User Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalUserTask#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalUserTask#getRenderings <em>Renderings</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getGlobalUserTask()
 * @model
 * @generated
 */
public interface GlobalUserTask extends GlobalTask {
	/**
	 * Returns the value of the '<em><b>Implementation</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation</em>' attribute list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getGlobalUserTask_Implementation()
	 * @model default="##unspecified" unique="false" dataType="org.eclipse.uml2.types.String"
	 * @generated
	 */
	EList<String> getImplementation();

	/**
	 * Returns the value of the '<em><b>Renderings</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.Rendering}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Renderings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Renderings</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getGlobalUserTask_Renderings()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Rendering> getRenderings();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * GlobalUserTask::/renderings: Image [*] = Stereotype.icon
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='GlobalUserTask.renderings'"
	 * @generated
	 */
	boolean GlobalUserTaskrenderings(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * GlobalUserTask::/implementation : String [*] {ordered,non-unique}= OpaqueBehavior.body (defaults to "##unspecified")
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='GlobalUserTask.implementation'"
	 * @generated
	 */
	boolean GlobalUserTaskimplementation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // GlobalUserTask
