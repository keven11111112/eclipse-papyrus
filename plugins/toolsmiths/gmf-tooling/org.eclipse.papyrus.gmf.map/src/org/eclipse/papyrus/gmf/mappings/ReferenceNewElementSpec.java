/*******************************************************************************
 * Copyright (c) 2005, 2020 Borland Software Corporation, CEA LIST, ARTAL
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
 * $Id: ReferenceNewElementSpec.java,v 1.3 2008/03/03 17:45:08 atikhomirov Exp $
 */
package org.eclipse.papyrus.gmf.mappings;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference New Element Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.ReferenceNewElementSpec#getNewElementInitializers <em>New Element Initializers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getReferenceNewElementSpec()
 * @model annotation="http://www.eclipse.org/gmf/2005/constraints ocl='feature.many = false implies not (newElementInitializers->size() > 1)' description='FeatureInitializer for single element EReference can\'t contain multiple element initializers'"
 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='let r: ecore::EReference = feature.oclAsType(ecore::EReference) in feature <> null implies r.containment' description='\'feature\' of \'ReferenceNewElementSpec\' must refer to containment ecore::EReference'"
 * @generated
 */
public interface ReferenceNewElementSpec extends FeatureInitializer {
	/**
	 * Returns the value of the '<em><b>New Element Initializers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.gmf.mappings.FeatureSeqInitializer}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.gmf.mappings.FeatureSeqInitializer#getCreatingInitializer <em>Creating Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Element Initializers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Element Initializers</em>' containment reference list.
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getReferenceNewElementSpec_NewElementInitializers()
	 * @see org.eclipse.papyrus.gmf.mappings.FeatureSeqInitializer#getCreatingInitializer
	 * @model opposite="creatingInitializer" containment="true" required="true"
	 * @generated
	 */
	EList<FeatureSeqInitializer> getNewElementInitializers();

} // ReferenceNewElementSpec
