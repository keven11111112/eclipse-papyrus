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
package org.eclipse.papyrus.aof.sync.gmf.syncstyles;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sync Exclusion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncExclusion#getExcludedTypes <em>Excluded Types</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncStylesPackage#getSyncExclusion()
 * @model
 * @generated
 */
public interface SyncExclusion extends SyncStyle {
	/**
	 * Returns the value of the '<em><b>Excluded Types</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Class}&lt;?>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Excluded Types</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Excluded Types</em>' attribute list.
	 * @see org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncStylesPackage#getSyncExclusion_ExcludedTypes()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Class<?>> getExcludedTypes();

} // SyncExclusion
