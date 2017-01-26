/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Enumeration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.Category#getBase_Enumeration <em>Base Enumeration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.Category#getCategoryValue <em>Category Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getCategory()
 * @model
 * @generated
 */
public interface Category extends RootElement {
	/**
	 * Returns the value of the '<em><b>Base Enumeration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Enumeration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Enumeration</em>' reference.
	 * @see #setBase_Enumeration(Enumeration)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getCategory_Base_Enumeration()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Enumeration getBase_Enumeration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Category#getBase_Enumeration <em>Base Enumeration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Enumeration</em>' reference.
	 * @see #getBase_Enumeration()
	 * @generated
	 */
	void setBase_Enumeration(Enumeration value);

	/**
	 * Returns the value of the '<em><b>Category Value</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.CategoryValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category Value</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category Value</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getCategory_CategoryValue()
	 * @model ordered="false"
	 * @generated
	 */
	EList<CategoryValue> getCategoryValue();

} // Category
