/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thomas Daniellou (CEA LIST) - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.adl4eclipse.generation.generator;

import org.eclipse.core.runtime.CoreException;

public interface Generator {

	/**
	 * Generates the project's files.
	 *
	 * @throws CoreException
	 */
	void generate() throws CoreException;

}
