/**
 */
package org.eclipse.papyrus.views.properties.contexts;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.infra.constraints.ConstraintDescriptor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Substitution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.views.properties.contexts.Substitution#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.views.properties.contexts.ContextsPackage#getSubstitution()
 * @model abstract="true"
 * @generated
 */
public interface Substitution extends EObject {
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.constraints.ConstraintDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see org.eclipse.papyrus.views.properties.contexts.ContextsPackage#getSubstitution_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintDescriptor> getConstraints();

} // Substitution
