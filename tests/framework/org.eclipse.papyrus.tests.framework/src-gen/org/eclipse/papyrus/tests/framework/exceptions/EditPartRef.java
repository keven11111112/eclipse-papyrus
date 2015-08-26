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
 */
package org.eclipse.papyrus.tests.framework.exceptions;

import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edit Part Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.EditPartRef#getEditPart <em>Edit Part</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getEditPartRef()
 * @model
 * @generated
 */
public interface EditPartRef extends EditPartSpec {
	/**
	 * Returns the value of the '<em><b>Edit Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edit Part</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Edit Part</em>' reference.
	 * @see #setEditPart(GenCommonBase)
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getEditPartRef_EditPart()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	GenCommonBase getEditPart();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.tests.framework.exceptions.EditPartRef#getEditPart <em>Edit Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Edit Part</em>' reference.
	 * @see #getEditPart()
	 * @generated
	 */
	void setEditPart(GenCommonBase value);

} // EditPartRef
