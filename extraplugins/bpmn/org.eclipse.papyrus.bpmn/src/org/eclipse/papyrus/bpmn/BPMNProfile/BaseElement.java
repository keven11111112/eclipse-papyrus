/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getExtensionValues <em>Extension Values</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getBase_Element <em>Base Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getExtensionDefinitions <em>Extension Definitions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getIncoming <em>Incoming</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBaseElement()
 * @model abstract="true"
 * @generated
 */
public interface BaseElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBaseElement_Id()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Extension Values</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Values</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBaseElement_ExtensionValues()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ExtensionAttributeValue> getExtensionValues();

	/**
	 * Returns the value of the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Element</em>' reference.
	 * @see #setBase_Element(Element)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBaseElement_Base_Element()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Element getBase_Element();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getBase_Element <em>Base Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Element</em>' reference.
	 * @see #getBase_Element()
	 * @generated
	 */
	void setBase_Element(Element value);

	/**
	 * Returns the value of the '<em><b>Documentation</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.Documentation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Documentation</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documentation</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBaseElement_Documentation()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Documentation> getDocumentation();

	/**
	 * Returns the value of the '<em><b>Extension Definitions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Definitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Definitions</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBaseElement_ExtensionDefinitions()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ExtensionDefinition> getExtensionDefinitions();

	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation#getSourceRef <em>Source Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBaseElement_Outgoing()
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation#getSourceRef
	 * @model opposite="sourceRef" ordered="false"
	 * @generated
	 */
	EList<BPMNAssociation> getOutgoing();

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation#getTargetRef <em>Target Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBaseElement_Incoming()
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation#getTargetRef
	 * @model opposite="targetRef" ordered="false"
	 * @generated
	 */
	EList<BPMNAssociation> getIncoming();

} // BaseElement
