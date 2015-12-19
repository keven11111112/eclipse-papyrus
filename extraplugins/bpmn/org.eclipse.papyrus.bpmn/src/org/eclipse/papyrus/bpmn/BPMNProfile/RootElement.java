/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.PackageableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.RootElement#getBase_PackageableElement <em>Base Packageable Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.RootElement#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getRootElement()
 * @model abstract="true"
 * @generated
 */
public interface RootElement extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Packageable Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Packageable Element</em>' reference.
	 * @see #setBase_PackageableElement(PackageableElement)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getRootElement_Base_PackageableElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PackageableElement getBase_PackageableElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.RootElement#getBase_PackageableElement <em>Base Packageable Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Packageable Element</em>' reference.
	 * @see #getBase_PackageableElement()
	 * @generated
	 */
	void setBase_PackageableElement(PackageableElement value);

	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getRootElements <em>Root Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(Definitions)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getRootElement_Definition()
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getRootElements
	 * @model opposite="rootElements" ordered="false"
	 * @generated
	 */
	Definitions getDefinition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.RootElement#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(Definitions value);

} // RootElement
