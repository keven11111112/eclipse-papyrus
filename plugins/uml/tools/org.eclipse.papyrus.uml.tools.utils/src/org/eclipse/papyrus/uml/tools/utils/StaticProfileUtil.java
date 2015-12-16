/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation (Ansgar Radermacher)
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.utils;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;


/**
 * Obtain information about an eventually applied Ecore::EPackage stereotype.
 * The ecore profile should be a static one, but it is not. Therefore, information
 * needs to be retrieved using the generic functions and string constants.
 */
public class StaticProfileUtil {

	/**
	 * qualified name of EPackage stereotype (used for static profile detection)
	 */
	public static final String EPackage_QNAME = "Ecore::EPackage"; //$NON-NLS-1$
	/**
	 * Attributes of EPackage stereotype 
	 */
	public static final String EPKG_BASE_PACKAGE = "basePackage"; //$NON-NLS-1$
	public static final String EPKG_PACKAGE_NAME = "packageName"; //$NON-NLS-1$
	public static final String EPKG_NS_URI = "nsURI"; //$NON-NLS-1$
	public static final String EPKG_NS_PREFIX = "nsPrefix"; //$NON-NLS-1$
	
	/**
	 * set the profile information
	 * @param profile
	 */
	public StaticProfileUtil(Profile profile) {
		Stereotype ePkg = profile.getAppliedStereotype(EPackage_QNAME);
		if (ePkg != null) {
			basePackage = (String) profile.getValue(ePkg, EPKG_BASE_PACKAGE);
			packageName = (String) profile.getValue(ePkg, EPKG_PACKAGE_NAME);
			// create definition from stereotype
			definition = EcoreFactory.eINSTANCE.createEPackage();
			definition.setNsPrefix((String) profile.getValue(ePkg, EPKG_NS_PREFIX));
			definition.setNsURI((String) profile.getValue(ePkg, EPKG_NS_URI));
		}
		else {
			basePackage = null;
			packageName = null;
			definition = null;
		}
	}
	
	/**
	 * @return the base package.
	 */
	public String getBasePackage() {
		return basePackage;
	}

	/**
	 * @return the package name.
	 */
	public String getPackageName() {
		return packageName;
	}
	
	/**
	 * @return a "definition" filled with information about nsPrefix and nsURI.
	 */
	public EPackage getDefinition() {
			return definition;
	}
	
	protected static String basePackage;
	
	protected static String packageName;
	
	protected static EPackage definition;
}


