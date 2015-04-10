/**
 */
package org.eclipse.papyrus.views.properties.contexts;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.views.properties.environment.PropertyEditorType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Editor Type Substitution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.views.properties.contexts.PropertyEditorTypeSubstitution#getSourceEditorType <em>Source Editor Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.views.properties.contexts.PropertyEditorTypeSubstitution#getTargetEditorType <em>Target Editor Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.views.properties.contexts.ContextsPackage#getPropertyEditorTypeSubstitution()
 * @model
 * @generated
 */
public interface PropertyEditorTypeSubstitution extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Editor Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Editor Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Source Editor Type</em>' reference.
	 * @see #setSourceEditorType(PropertyEditorType)
	 * @see org.eclipse.papyrus.views.properties.contexts.ContextsPackage#getPropertyEditorTypeSubstitution_SourceEditorType()
	 * @model
	 * @generated
	 */
	PropertyEditorType getSourceEditorType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.views.properties.contexts.PropertyEditorTypeSubstitution#getSourceEditorType <em>Source Editor Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Source Editor Type</em>' reference.
	 * @see #getSourceEditorType()
	 * @generated
	 */
	void setSourceEditorType(PropertyEditorType value);

	/**
	 * Returns the value of the '<em><b>Target Editor Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Editor Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Target Editor Type</em>' reference.
	 * @see #setTargetEditorType(PropertyEditorType)
	 * @see org.eclipse.papyrus.views.properties.contexts.ContextsPackage#getPropertyEditorTypeSubstitution_TargetEditorType()
	 * @model
	 * @generated
	 */
	PropertyEditorType getTargetEditorType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.views.properties.contexts.PropertyEditorTypeSubstitution#getTargetEditorType <em>Target Editor Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Target Editor Type</em>' reference.
	 * @see #getTargetEditorType()
	 * @generated
	 */
	void setTargetEditorType(PropertyEditorType value);

} // PropertyEditorTypeSubstitution
