/**
 */
package org.eclipse.papyrus.views.properties.contexts;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.views.properties.environment.ModelElementFactoryDescriptor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element Factory Substitution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.views.properties.contexts.ModelElementFactorySubstitution#getSourceFactoryType <em>Source Factory Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.views.properties.contexts.ModelElementFactorySubstitution#getTargetFactoryType <em>Target Factory Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.views.properties.contexts.ContextsPackage#getModelElementFactorySubstitution()
 * @model
 * @generated
 */
public interface ModelElementFactorySubstitution extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Factory Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Factory Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Source Factory Type</em>' reference.
	 * @see #setSourceFactoryType(ModelElementFactoryDescriptor)
	 * @see org.eclipse.papyrus.views.properties.contexts.ContextsPackage#getModelElementFactorySubstitution_SourceFactoryType()
	 * @model
	 * @generated
	 */
	ModelElementFactoryDescriptor getSourceFactoryType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.views.properties.contexts.ModelElementFactorySubstitution#getSourceFactoryType <em>Source Factory Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Source Factory Type</em>' reference.
	 * @see #getSourceFactoryType()
	 * @generated
	 */
	void setSourceFactoryType(ModelElementFactoryDescriptor value);

	/**
	 * Returns the value of the '<em><b>Target Factory Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Factory Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Target Factory Type</em>' reference.
	 * @see #setTargetFactoryType(ModelElementFactoryDescriptor)
	 * @see org.eclipse.papyrus.views.properties.contexts.ContextsPackage#getModelElementFactorySubstitution_TargetFactoryType()
	 * @model
	 * @generated
	 */
	ModelElementFactoryDescriptor getTargetFactoryType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.views.properties.contexts.ModelElementFactorySubstitution#getTargetFactoryType <em>Target Factory Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Target Factory Type</em>' reference.
	 * @see #getTargetFactoryType()
	 * @generated
	 */
	void setTargetFactoryType(ModelElementFactoryDescriptor value);

} // ModelElementFactorySubstitution
