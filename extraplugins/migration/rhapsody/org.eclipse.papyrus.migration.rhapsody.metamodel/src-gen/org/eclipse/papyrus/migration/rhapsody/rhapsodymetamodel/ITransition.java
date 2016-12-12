/**
 *   Copyright (c) 2016 CEA LIST and others.
 *   
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *     CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ITransition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITransition#getItsSource <em>Its Source</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITransition#getInheritsFromHandle <em>Inherits From Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITransition#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITransition#getStereotypes <em>Stereotypes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getITransition()
 * @model
 * @generated
 */
public interface ITransition extends IModelElement, TransitionsType, DependsOnType, TargetType {
	/**
	 * Returns the value of the '<em><b>Its Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Its Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Its Source</em>' reference.
	 * @see #setItsSource(ItsTargetType)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getITransition_ItsSource()
	 * @model
	 * @generated
	 */
	ItsTargetType getItsSource();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITransition#getItsSource <em>Its Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Its Source</em>' reference.
	 * @see #getItsSource()
	 * @generated
	 */
	void setItsSource(ItsTargetType value);

	/**
	 * Returns the value of the '<em><b>Inherits From Handle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherits From Handle</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherits From Handle</em>' reference.
	 * @see #setInheritsFromHandle(ITransition)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getITransition_InheritsFromHandle()
	 * @model
	 * @generated
	 */
	ITransition getInheritsFromHandle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITransition#getInheritsFromHandle <em>Inherits From Handle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherits From Handle</em>' reference.
	 * @see #getInheritsFromHandle()
	 * @generated
	 */
	void setInheritsFromHandle(ITransition value);

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDependency}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' containment reference list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getITransition_Dependencies()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IDependency> getDependencies();

	/**
	 * Returns the value of the '<em><b>Stereotypes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotypes</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotypes</em>' reference.
	 * @see #setStereotypes(IClassifier)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getITransition_Stereotypes()
	 * @model
	 * @generated
	 */
	IClassifier getStereotypes();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITransition#getStereotypes <em>Stereotypes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotypes</em>' reference.
	 * @see #getStereotypes()
	 * @generated
	 */
	void setStereotypes(IClassifier value);

} // ITransition
