/******************************************************************************
 * Copyright (c) 2006, 2020 Eclipse.org, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Dmitry Stadnik - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.bridge.ui.dashboard;

import org.eclipse.swt.widgets.Shell;

/**
 * EXPERIMENTAL
 * 
 * @author dstadnik
 */
public interface DashboardFacade {

	public static final String LOCATION_DM = "domain_model"; //$NON-NLS-1$

	public static final String LOCATION_DGM = "domain_genmodel"; //$NON-NLS-1$

	public static final String LOCATION_GDM = "graphdef_model"; //$NON-NLS-1$

	public static final String LOCATION_TDM = "tooldef_model"; //$NON-NLS-1$

	public static final String LOCATION_MM = "map_model"; //$NON-NLS-1$

	public static final String LOCATION_GM = "genmodel"; //$NON-NLS-1$

	public static final String LOCATION_MM2GM = "map_model-genmodel"; //$NON-NLS-1$

	public static final String OPTION_RCP = "rcp"; //$NON-NLS-1$

	public DashboardState getState();

	public void updateStatus();

	public boolean isStrict();

	public Shell getShell();
}
