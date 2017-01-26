/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.OpaqueAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.UserTask#getBase_OpaqueAction <em>Base Opaque Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.UserTask#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.UserTask#getRenderings <em>Renderings</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getUserTask()
 * @model
 * @generated
 */
public interface UserTask extends Task {
	/**
	 * Returns the value of the '<em><b>Base Opaque Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Opaque Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Opaque Action</em>' reference.
	 * @see #setBase_OpaqueAction(OpaqueAction)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getUserTask_Base_OpaqueAction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OpaqueAction getBase_OpaqueAction();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.UserTask#getBase_OpaqueAction <em>Base Opaque Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Opaque Action</em>' reference.
	 * @see #getBase_OpaqueAction()
	 * @generated
	 */
	void setBase_OpaqueAction(OpaqueAction value);

	/**
	 * Returns the value of the '<em><b>Implementation</b></em>' attribute.
	 * The default value is <code>"##unspecified"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation</em>' attribute.
	 * @see #setImplementation(String)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getUserTask_Implementation()
	 * @model default="##unspecified" unique="false" dataType="org.eclipse.uml2.types.String" required="true"
	 * @generated
	 */
	String getImplementation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.UserTask#getImplementation <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation</em>' attribute.
	 * @see #getImplementation()
	 * @generated
	 */
	void setImplementation(String value);

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
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getUserTask_Renderings()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Rendering> getRenderings();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.implementation = self.base_OpaqueAction.body.first
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='UserTask.implementation'"
	 * @generated
	 */
	boolean UserTaskimplementation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * UserTask::/renderings : Image [*] = OpaqueAction.appliedStereotype.icon
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='UserTask.renderings'"
	 * @generated
	 */
	boolean UserTaskrenderings(DiagnosticChain diagnostics, Map<Object, Object> context);

} // UserTask
