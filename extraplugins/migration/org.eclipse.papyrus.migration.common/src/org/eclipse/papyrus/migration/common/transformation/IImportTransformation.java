/*****************************************************************************
 * Copyright (c) 2014, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.migration.common.transformation;

import org.eclipse.core.runtime.IStatus;

/**
 * @author Vincent Lorenzo
 *
 */
public interface IImportTransformation {

	/**
	 * @return
	 */
	long getLoadingTime();

	/**
	 * @return
	 */
	long getHandleDanglingRefTime();

	/**
	 * @return
	 */
	long getImportExtensionsTime();

	/**
	 * @return
	 */
	long getExecutionTime();

	/**
	 * @return
	 */
	String getModelName();

	/**
	 * @return
	 */
	IStatus getStatus();

	/**
	 * @return
	 */
	boolean isComplete();

	/**
	 * @param b
	 */
	void run(boolean b);

	/**
	 * 
	 */
	void cancel();

}