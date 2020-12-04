/*******************************************************************************
 * Copyright (c) 2005, 2020 Sven Efftinge, CEA LIST, Artal and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *     Sven Efftinge - Initial API and implementation
 *     Alexander Shatalin (Borland) - initial API and implementation
 *     AurÃ©lien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *******************************************************************************/
package org.eclipse.papyrus.gmf.internal.xpand;

import org.eclipse.papyrus.gmf.internal.xpand.model.XpandResource;
import org.eclipse.papyrus.gmf.internal.xpand.xtend.ast.QvtResource;


/**
 * FIXME no much sense to depend on File here, it's only builder who cares about files
 * TODO describe contract - when returns null
 */
public interface ResourceManager {

    XpandResource loadXpandResource(String fullyQualifiedName);
    
    QvtResource loadQvtResource(String fullyQualifiedName);
    
}
