/*******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, ARTAL
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 * 
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     Borland - initial API and implementation
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenJavaExpressionProvider.java,v 1.3 2008/05/07 13:56:01 atikhomirov Exp $
 */
package org.eclipse.papyrus.gmf.codegen.gmfgen;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Java Expression Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.codegen.gmfgen.GenJavaExpressionProvider#isThrowException <em>Throw Exception</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.codegen.gmfgen.GenJavaExpressionProvider#isInjectExpressionBody <em>Inject Expression Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.codegen.gmfgen.GMFGenPackage#getGenJavaExpressionProvider()
 * @model
 * @generated
 */
public interface GenJavaExpressionProvider extends GenExpressionProviderBase {
	/**
	 * Returns the value of the '<em><b>Throw Exception</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Throw Exception</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Throw Exception</em>' attribute.
	 * @see #setThrowException(boolean)
	 * @see org.eclipse.papyrus.gmf.codegen.gmfgen.GMFGenPackage#getGenJavaExpressionProvider_ThrowException()
	 * @model default="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel documentaion='Whether to generate default implementation that rises RuntimeException to signal unimplemented method'"
	 * @generated
	 */
	boolean isThrowException();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.codegen.gmfgen.GenJavaExpressionProvider#isThrowException <em>Throw Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Throw Exception</em>' attribute.
	 * @see #isThrowException()
	 * @generated
	 */
	void setThrowException(boolean value);

	/**
	 * Returns the value of the '<em><b>Inject Expression Body</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inject Expression Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inject Expression Body</em>' attribute.
	 * @see #setInjectExpressionBody(boolean)
	 * @see org.eclipse.papyrus.gmf.codegen.gmfgen.GMFGenPackage#getGenJavaExpressionProvider_InjectExpressionBody()
	 * @model default="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel documentaion='When \'true\', body of associated ValueExpression would get injected into Java code as-is, thus allowing to provide method implementations right within the model. Note, if body is empty, default implementation would be generated instead.'"
	 * @generated
	 */
	boolean isInjectExpressionBody();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.codegen.gmfgen.GenJavaExpressionProvider#isInjectExpressionBody <em>Inject Expression Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inject Expression Body</em>' attribute.
	 * @see #isInjectExpressionBody()
	 * @generated
	 */
	void setInjectExpressionBody(boolean value);

} // GenJavaExpressionProvider
