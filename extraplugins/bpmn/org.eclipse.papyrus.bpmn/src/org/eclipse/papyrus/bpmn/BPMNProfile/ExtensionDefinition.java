/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Stereotype;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionDefinition#getBase_Stereotype <em>Base Stereotype</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionDefinition#getExtensionAttributeDefinitions <em>Extension Attribute Definitions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getExtensionDefinition()
 * @model
 * @generated
 */
public interface ExtensionDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Stereotype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Stereotype</em>' reference.
	 * @see #setBase_Stereotype(Stereotype)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getExtensionDefinition_Base_Stereotype()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Stereotype getBase_Stereotype();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionDefinition#getBase_Stereotype <em>Base Stereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Stereotype</em>' reference.
	 * @see #getBase_Stereotype()
	 * @generated
	 */
	void setBase_Stereotype(Stereotype value);

	/**
	 * Returns the value of the '<em><b>Extension Attribute Definitions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Attribute Definitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Attribute Definitions</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getExtensionDefinition_ExtensionAttributeDefinitions()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<ExtensionAttributeDefinition> getExtensionAttributeDefinitions();

} // ExtensionDefinition
