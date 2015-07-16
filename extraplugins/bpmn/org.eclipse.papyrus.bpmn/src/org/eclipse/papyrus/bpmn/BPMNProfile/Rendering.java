/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.Image;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rendering</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.Rendering#getBase_Image <em>Base Image</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getRendering()
 * @model
 * @generated
 */
public interface Rendering extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Base Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Image</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Image</em>' reference.
	 * @see #setBase_Image(Image)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getRendering_Base_Image()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Image getBase_Image();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Rendering#getBase_Image <em>Base Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Image</em>' reference.
	 * @see #getBase_Image()
	 * @generated
	 */
	void setBase_Image(Image value);

} // Rendering
