/******************************************************************************
 * Copyright (c) 2007, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0 which
 * accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *    Borland - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.map.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.gmf.internal.common.ToolingResourceFactory;
import org.eclipse.papyrus.gmf.internal.common.migrate.MigrationResource;

public class GMFMapResource extends MigrationResource {
	public static class Factory extends ToolingResourceFactory {
		@Override
		public Resource createResource(URI uri) {
			return new GMFMapResource(uri);
		}
	}

	private GMFMapResource(URI uri) {
		super(uri);
	}

	@Override
	protected org.eclipse.papyrus.gmf.internal.common.migrate.MigrationDelegate createDelegate() {
		MigrationDelegate migrationHelper = new MigrationDelegate();
		migrationHelper.init();
		return migrationHelper;
	}
}
