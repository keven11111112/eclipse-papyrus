/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.Dependency;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Correlation Property Retrieval Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyRetrievalExpression#getBase_Dependency <em>Base Dependency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyRetrievalExpression#getMessageRef <em>Message Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyRetrievalExpression#getMessagePath <em>Message Path</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getCorrelationPropertyRetrievalExpression()
 * @model
 * @generated
 */
public interface CorrelationPropertyRetrievalExpression extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Dependency</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Dependency</em>' reference.
	 * @see #setBase_Dependency(Dependency)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getCorrelationPropertyRetrievalExpression_Base_Dependency()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Dependency getBase_Dependency();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyRetrievalExpression#getBase_Dependency <em>Base Dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Dependency</em>' reference.
	 * @see #getBase_Dependency()
	 * @generated
	 */
	void setBase_Dependency(Dependency value);

	/**
	 * Returns the value of the '<em><b>Message Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Ref</em>' reference.
	 * @see #setMessageRef(BPMNMessage)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getCorrelationPropertyRetrievalExpression_MessageRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BPMNMessage getMessageRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyRetrievalExpression#getMessageRef <em>Message Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Ref</em>' reference.
	 * @see #getMessageRef()
	 * @generated
	 */
	void setMessageRef(BPMNMessage value);

	/**
	 * Returns the value of the '<em><b>Message Path</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Path</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Path</em>' reference.
	 * @see #setMessagePath(FormalExpression)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getCorrelationPropertyRetrievalExpression_MessagePath()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FormalExpression getMessagePath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyRetrievalExpression#getMessagePath <em>Message Path</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Path</em>' reference.
	 * @see #getMessagePath()
	 * @generated
	 */
	void setMessagePath(FormalExpression value);

} // CorrelationPropertyRetrievalExpression
