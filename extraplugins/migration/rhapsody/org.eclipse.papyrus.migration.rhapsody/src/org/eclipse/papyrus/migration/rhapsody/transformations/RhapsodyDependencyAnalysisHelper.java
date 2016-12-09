/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.migration.rhapsody.transformations;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.papyrus.migration.common.MigrationParameters.ThreadConfig;
import org.eclipse.papyrus.migration.common.transformation.AbstractDependencyAnalysisHelper;
import org.eclipse.papyrus.migration.rhapsody.importer.utils.RhapsodyFileUtils;
//import org.eclipse.rhapsody2papyrus.utils.concurrent.ThreadSafeResourceSet;
import org.eclipse.uml2.uml.Element;

import com.google.common.collect.Sets;

/**
 * 
 * @author Vincent Lorenzo
 *
 */
public class RhapsodyDependencyAnalysisHelper extends AbstractDependencyAnalysisHelper {

	protected final static Set<String> rhapsodyExtensions = Sets.newHashSet(RhapsodyFileUtils.UML_RHAPSODY_FILE,RhapsodyFileUtils.FILE_EXTENSION_RPY);

	protected final static String rhapsodyProfileExtension = RhapsodyFileUtils.UML_RHAPSODY_FILE; 

	public RhapsodyDependencyAnalysisHelper(final ThreadConfig config) {
		super(config, rhapsodyExtensions, rhapsodyProfileExtension);
	}

	//TODO : not really sure of this part...
	@Override
	protected boolean isInvalidStereotypeApplication(EObject eObject) {
		if (eObject instanceof Element) {
			return false;
		}

		// The package is not resolved: probably a missing profile
		if (eObject instanceof AnyType) {
			return true;
		}

		// If the package is resolved but is contained in an EPX resource, it
		// needs to be mapped to the Papyrus equivalent
		EPackage ePackage = eObject.eClass().getEPackage();
		if (RhapsodyFileUtils.UML_RHAPSODY_FILE.equals(ePackage.eResource().getURI().fileExtension())) {
			return true;
		}

		return false;
	}

}
