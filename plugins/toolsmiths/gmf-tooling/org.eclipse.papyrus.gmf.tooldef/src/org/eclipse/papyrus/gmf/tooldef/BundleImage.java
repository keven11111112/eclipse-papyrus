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
 * $Id$
 */
package org.eclipse.papyrus.gmf.tooldef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bundle Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Image bundled as part of distribution
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.tooldef.BundleImage#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.tooldef.BundleImage#getBundle <em>Bundle</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getBundleImage()
 * @model
 * @generated
 */
public interface BundleImage extends Image {

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Relative path to image
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getBundleImage_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.tooldef.BundleImage#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Empty value means image path is relative to generated bundle
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bundle</em>' attribute.
	 * @see #setBundle(String)
	 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getBundleImage_Bundle()
	 * @model
	 * @generated
	 */
	String getBundle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.tooldef.BundleImage#getBundle <em>Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundle</em>' attribute.
	 * @see #getBundle()
	 * @generated
	 */
	void setBundle(String value);

} // BundleImage
