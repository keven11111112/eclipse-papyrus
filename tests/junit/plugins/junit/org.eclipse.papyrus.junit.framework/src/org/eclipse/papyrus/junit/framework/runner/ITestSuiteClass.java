/*****************************************************************************
 * Copyright (c) 2010, 2015 CEA LIST, Christian W. Damus, and others.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 451230
 *****************************************************************************/
package org.eclipse.papyrus.junit.framework.runner;


/**
 * Interface for all suite classes.
 */
public interface ITestSuiteClass {

	/**
	 * Returns the main test suite class for this entry
	 * 
	 * @return the main test suite class for this entry
	 */
	public Class<?> getMainTestSuiteClass();

}
