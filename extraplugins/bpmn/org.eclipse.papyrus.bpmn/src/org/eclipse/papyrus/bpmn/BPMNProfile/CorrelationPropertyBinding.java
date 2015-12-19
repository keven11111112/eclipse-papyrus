/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Correlation Property Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyBinding#getBase_Property <em>Base Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyBinding#getDataPath <em>Data Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyBinding#getCorrelationPropertyRef <em>Correlation Property Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getCorrelationPropertyBinding()
 * @model
 * @generated
 */
public interface CorrelationPropertyBinding extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Property</em>' reference.
	 * @see #setBase_Property(Property)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getCorrelationPropertyBinding_Base_Property()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getBase_Property();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyBinding#getBase_Property <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Property</em>' reference.
	 * @see #getBase_Property()
	 * @generated
	 */
	void setBase_Property(Property value);

	/**
	 * Returns the value of the '<em><b>Data Path</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Path</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Path</em>' reference.
	 * @see #setDataPath(FormalExpression)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getCorrelationPropertyBinding_DataPath()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FormalExpression getDataPath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyBinding#getDataPath <em>Data Path</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Path</em>' reference.
	 * @see #getDataPath()
	 * @generated
	 */
	void setDataPath(FormalExpression value);

	/**
	 * Returns the value of the '<em><b>Correlation Property Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correlation Property Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correlation Property Ref</em>' reference.
	 * @see #setCorrelationPropertyRef(CorrelationProperty)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getCorrelationPropertyBinding_CorrelationPropertyRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CorrelationProperty getCorrelationPropertyRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyBinding#getCorrelationPropertyRef <em>Correlation Property Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Correlation Property Ref</em>' reference.
	 * @see #getCorrelationPropertyRef()
	 * @generated
	 */
	void setCorrelationPropertyRef(CorrelationProperty value);

} // CorrelationPropertyBinding
