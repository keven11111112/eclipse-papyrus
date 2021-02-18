/******************************************************************************
 * Copyright (c) 2008, 2020 Borland Software Corp, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Alexander Shatalin (Borland) - initial API and implementation
 *     AurÃ©lien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *******************************************************************************/
package org.eclipse.papyrus.gmf.internal.xpand.xtend.ast;

import java.util.List;
import java.util.Set;

import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.papyrus.gmf.internal.xpand.ResourceMarker;
import org.eclipse.papyrus.gmf.internal.xpand.model.XpandAnalyzable;

public interface QvtResource extends XpandAnalyzable, ResourceMarker {

	public static final String FILE_EXTENSION = MDAConstants.QVTO_FILE_EXTENSION;

	/**
	 * @return {@link QvtExtension}s declared in this {@link QvtResource} or
	 *         null in case of loading errors
	 */
	List<QvtExtension> getExtensions();
	
	Set<Module> getModules();
}
