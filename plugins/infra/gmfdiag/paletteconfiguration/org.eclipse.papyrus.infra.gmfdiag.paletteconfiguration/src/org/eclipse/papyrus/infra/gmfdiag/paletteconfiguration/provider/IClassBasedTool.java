/*****************************************************************************
 * Copyright (c) 2017 CEA LIST, ALL4TEC and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.provider;

/**
 * Interface for tool based on class qualify name string.
 */
public interface IClassBasedTool {

	/**
	 * Get the tool class name.
	 */
	public String getToolClassName();


	/**
	 * Set the tool class name.
	 * 
	 * @param toolClassName
	 *            the tool class qualify name to set.
	 */
	public void setToolClassName(final String toolClassName);

}
