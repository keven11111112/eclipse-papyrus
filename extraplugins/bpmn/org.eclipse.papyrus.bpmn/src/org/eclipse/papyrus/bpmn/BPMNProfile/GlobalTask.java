/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.OpaqueBehavior;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalTask#getBase_OpaqueBehavior <em>Base Opaque Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalTask#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getGlobalTask()
 * @model
 * @generated
 */
public interface GlobalTask extends CallableElement {
	/**
	 * Returns the value of the '<em><b>Base Opaque Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Opaque Behavior</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Opaque Behavior</em>' reference.
	 * @see #setBase_OpaqueBehavior(OpaqueBehavior)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getGlobalTask_Base_OpaqueBehavior()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OpaqueBehavior getBase_OpaqueBehavior();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalTask#getBase_OpaqueBehavior <em>Base Opaque Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Opaque Behavior</em>' reference.
	 * @see #getBase_OpaqueBehavior()
	 * @generated
	 */
	void setBase_OpaqueBehavior(OpaqueBehavior value);

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getGlobalTask_Resources()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<ResourceRole> getResources();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * GlobalTask supportedInterfaceRefs are referenced by UML property RealizedInterface.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='GlobalTask.supportedInterfaceRefs'"
	 * @generated
	 */
	boolean GlobalTasksupportedInterfaceRefs(DiagnosticChain diagnostics, Map<Object, Object> context);

} // GlobalTask
