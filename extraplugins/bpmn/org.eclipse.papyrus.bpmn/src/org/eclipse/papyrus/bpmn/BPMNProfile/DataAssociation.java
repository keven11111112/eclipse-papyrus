/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.ObjectFlow;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#getBase_ObjectFlow <em>Base Object Flow</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#getSourceRef <em>Source Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#getTargetRef <em>Target Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#getAssignment <em>Assignment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataAssociation()
 * @model abstract="true"
 * @generated
 */
public interface DataAssociation extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Base Object Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Object Flow</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Object Flow</em>' reference.
	 * @see #setBase_ObjectFlow(ObjectFlow)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataAssociation_Base_ObjectFlow()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ObjectFlow getBase_ObjectFlow();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#getBase_ObjectFlow <em>Base Object Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Object Flow</em>' reference.
	 * @see #getBase_ObjectFlow()
	 * @generated
	 */
	void setBase_ObjectFlow(ObjectFlow value);

	/**
	 * Returns the value of the '<em><b>Source Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Ref</em>' reference.
	 * @see #setSourceRef(ItemAwareElement)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataAssociation_SourceRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ItemAwareElement getSourceRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#getSourceRef <em>Source Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Ref</em>' reference.
	 * @see #getSourceRef()
	 * @generated
	 */
	void setSourceRef(ItemAwareElement value);

	/**
	 * Returns the value of the '<em><b>Target Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Ref</em>' reference.
	 * @see #setTargetRef(ItemAwareElement)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataAssociation_TargetRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ItemAwareElement getTargetRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#getTargetRef <em>Target Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Ref</em>' reference.
	 * @see #getTargetRef()
	 * @generated
	 */
	void setTargetRef(ItemAwareElement value);

	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' reference.
	 * @see #setTransformation(FormalExpression)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataAssociation_Transformation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FormalExpression getTransformation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#getTransformation <em>Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' reference.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(FormalExpression value);

	/**
	 * Returns the value of the '<em><b>Assignment</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.Assignment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignment</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignment</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataAssociation_Assignment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Assignment> getAssignment();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * DataAssociation source must be ItemAwareElement
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='DataAssociation.source'"
	 * @generated
	 */
	boolean DataAssociationsource(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * BPMN DataAssociation::/transformation : FormalExpression [0..1] = ObjectFlow::transformation.
	 * 
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='DataAssociation.transformation'"
	 * @generated
	 */
	boolean DataAssociationtransformation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * DataAssociation target must be ItemAwareElement
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='DataAssociation.target'"
	 * @generated
	 */
	boolean DataAssociationtarget(DiagnosticChain diagnostics, Map<Object, Object> context);

} // DataAssociation
