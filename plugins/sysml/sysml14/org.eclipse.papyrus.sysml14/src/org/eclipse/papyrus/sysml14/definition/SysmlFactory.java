/**
 * Copyright (c) 2015 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.sysml14.definition;

import org.eclipse.emf.ecore.EFactory;

public interface SysmlFactory extends EFactory {
	
	/**
	 * The singleton instance of the factory.
	 */
	SysmlFactory eINSTANCE = org.eclipse.papyrus.sysml14.definition.internal.impl.SysmlFactoryImpl.init();

	/**
	 * Returns the package supported by this factory.
	 * @return the package supported by this factory.
	 */
	SysmlPackage getSysmlPackage();

}
