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

import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.IMappingContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sync Style</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncStylesPackage#getSyncStyle()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface SyncStyle extends Style {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @model required="true" mappingDataType="org.eclipse.papyrus.aof.sync.emf.syncmapping.Mapping<?, ?>" mappingRequired="true" contextDataType="org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingContext" contextRequired="true"
	 * @generated
	 */
	boolean isEnabled(IMapping<?, ?> mapping, IMappingContext context);

} // SyncStyle
