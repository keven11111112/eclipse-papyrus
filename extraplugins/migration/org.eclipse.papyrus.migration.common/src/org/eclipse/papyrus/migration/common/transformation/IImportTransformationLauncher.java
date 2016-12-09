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

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;

/**
 * @author Vincent Lorenzo
 *
 */
public interface IImportTransformationLauncher {

	/**
	 * Executes the transformation (Asynchronous)
	 *
	 * @param urisToImport
	 */
	public void run(List<URI> urisToImport);
	
	/** Mainly for test purpose */
	public void waitForCompletion() throws Exception;
	
	/** Mainly for test purpose */
	public IStatus getResult();

}
