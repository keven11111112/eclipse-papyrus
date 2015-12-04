/**
 * Copyright (c) 2015 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.editor.welcome;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.editor.welcome.WelcomePage#getSections <em>Section</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.editor.welcome.WelcomePage#getVisibleSections <em>Visible Section</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.editor.welcome.WelcomePackage#getWelcomePage()
 * @model
 * @generated
 */
public interface WelcomePage extends EObject {
	/**
	 * Returns the value of the '<em><b>Section</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.editor.welcome.WelcomeSection}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.editor.welcome.WelcomeSection#getPage <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Section</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Section</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.editor.welcome.WelcomePackage#getWelcomePage_Section()
	 * @see org.eclipse.papyrus.infra.editor.welcome.WelcomeSection#getPage
	 * @model opposite="page" containment="true"
	 * @generated
	 */
	EList<WelcomeSection> getSections();

	/**
	 * Creates a new {@link org.eclipse.papyrus.infra.editor.welcome.WelcomeSection} and appends it to the '<em><b>Section</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return The new {@link org.eclipse.papyrus.infra.editor.welcome.WelcomeSection}.
	 * @see #getSections()
	 * @generated
	 */
	WelcomeSection createSection();

	/**
	 * Returns the value of the '<em><b>Visible Section</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.editor.welcome.WelcomeSection}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.infra.editor.welcome.WelcomePage#getSections() <em>Section</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible Section</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Visible Section</em>' reference list.
	 * @see org.eclipse.papyrus.infra.editor.welcome.WelcomePackage#getWelcomePage_VisibleSection()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<WelcomeSection> getVisibleSections();

	/**
	 * Creates a new {@link org.eclipse.papyrus.infra.editor.welcome.WelcomeSection} and appends it to the '<em><b>Visible Section</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return The new {@link org.eclipse.papyrus.infra.editor.welcome.WelcomeSection}.
	 * @see #getVisibleSections()
	 * @generated
	 */
	WelcomeSection createVisibleSection();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @model ordered="false" identifierDataType="org.eclipse.uml2.types.String" identifierRequired="true" identifierOrdered="false"
	 * @generated
	 */
	WelcomeSection getSection(String identifier);

} // WelcomePage
