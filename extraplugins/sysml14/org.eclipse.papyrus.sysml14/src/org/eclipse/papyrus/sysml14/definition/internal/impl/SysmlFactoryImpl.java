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
package org.eclipse.papyrus.sysml14.definition.internal.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.sysml14.definition.SysmlFactory;
import org.eclipse.papyrus.sysml14.definition.SysmlPackage;

/**
 * An implementation of the model <b>Factory</b>.
 */
public class SysmlFactoryImpl extends EFactoryImpl implements SysmlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SysmlFactory init() {
		try {
			SysmlFactory thesysmlFactory = (SysmlFactory)EPackage.Registry.INSTANCE.getEFactory(SysmlPackage.eNS_URI);
			if (thesysmlFactory != null) {
				return thesysmlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SysmlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SysmlFactoryImpl() {
		super();
	}

	/**
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 */
	public String createDummyFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}
	
	/**
	 */
	public SysmlPackage getSysmlPackage() {
		return (SysmlPackage)getEPackage();
	}

	/**
	 */
	@Deprecated
	public static SysmlPackage getPackage() {
		return SysmlPackage.eINSTANCE;
	}

} 
