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

import org.eclipse.emf.ecore.EPackage;


/**
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * @see org.eclipse.papyrus.sysml.SysmlFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='SysML'"
 */
public interface SysmlPackage extends EPackage {
	/**
	 * The package name.
	 */
	String eNAME = "sysml"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/1.4/SysML"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 */
	String eNS_PREFIX = "SysML"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 */
	SysmlPackage eINSTANCE = org.eclipse.papyrus.sysml14.definition.internal.impl.SysmlPackageImpl.init();

	/**
	 * Returns the factory that creates the instances of the model.
	 * @return the factory that creates the instances of the model.
	 */
	SysmlFactory getSysmlFactory();

} 
