/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Correlation Subscription</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationSubscription#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationSubscription#getCorrelationKeyRef <em>Correlation Key Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationSubscription#getCorrelationPropertyBinding <em>Correlation Property Binding</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getCorrelationSubscription()
 * @model
 * @generated
 */
public interface CorrelationSubscription extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getCorrelationSubscription_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationSubscription#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Correlation Key Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correlation Key Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correlation Key Ref</em>' reference.
	 * @see #setCorrelationKeyRef(CorrelationKey)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getCorrelationSubscription_CorrelationKeyRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CorrelationKey getCorrelationKeyRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationSubscription#getCorrelationKeyRef <em>Correlation Key Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Correlation Key Ref</em>' reference.
	 * @see #getCorrelationKeyRef()
	 * @generated
	 */
	void setCorrelationKeyRef(CorrelationKey value);

	/**
	 * Returns the value of the '<em><b>Correlation Property Binding</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyBinding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correlation Property Binding</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correlation Property Binding</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getCorrelationSubscription_CorrelationPropertyBinding()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<CorrelationPropertyBinding> getCorrelationPropertyBinding();

} // CorrelationSubscription
