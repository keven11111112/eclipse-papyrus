/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.migration.rhapsody.blackboxes;


import org.eclipse.core.runtime.Platform;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramVersioningUtils;
import org.osgi.framework.Bundle;

/**
 * @author VL222926
 *
 */
public class VersioningBlackboxes {

	/**
	 * Name of the bundle used for versioning
	 */
	private static final String BUNDLE_NAME_FOR_VERSIONING = "org.eclipse.papyrus.migration.rhapsody"; //$NON-NLS-1$

	/**
	 * Strings used by the EAnnotation to save the Papyrus and the Rhapsody import version
	 */
	public static final String VERSIONING_EANNOTATION_SOURCE = "Imported from a Rhapsody Model"; //$NON-NLS-1$
	public static final String VERSIONING_EANNOTATION_DETAIL_KEY_RHAPSODY_PROJECT_NAME = "Rhapsody Model Name"; //$NON-NLS-1$
	public static final String VERSIONING_EANNOTATION_DETAIL_KEY_RHAPSODY_VERSION = "Rhapsody Version"; //$NON-NLS-1$
	public static final String VERSIONING_EANNOTATION_DETAIL_KEY_PAPYRUS_RHAPSODY_IMPORT_BUNDLE_VERSION = "Papyrus Rhapsody Import Bundle Version"; //$NON-NLS-1$

	public static final String COMPATIBILITY_VERSION = DiagramVersioningUtils.COMPATIBILITY_VERSION;

	/**
	 * 
	 * @return
	 * 		the version of the Papyrus bundle used to improt Rhapsody model
	 */
	@Operation(kind = Kind.HELPER)
	public String getImportBundleRhapsodyVersion() {
		final Bundle bundle = Platform.getBundle(BUNDLE_NAME_FOR_VERSIONING);
		if (null != bundle) {
			return bundle.getVersion().toString();
		} else {
			Activator.log.info(NLS.bind("Version of {0} not found.", BUNDLE_NAME_FOR_VERSIONING)); //$NON-NLS-1$
		}

		return "version not found"; //$NON-NLS-1$
	}

	/**
	 * 
	 * @return
	 * 		the string used as key to save the Rhapsody project name
	 */
	@Operation(kind = Kind.HELPER)
	public String getEAnnotationSourceNameForVersioning() {
		return VERSIONING_EANNOTATION_SOURCE;
	}

	/**
	 * 
	 * @return
	 * 		the string used as key to save the Rhapsody project name
	 */
	@Operation(kind = Kind.HELPER)
	public String getKeyForRhapsodyModelName() {
		return VERSIONING_EANNOTATION_DETAIL_KEY_RHAPSODY_PROJECT_NAME;
	}

	/**
	 * 
	 * @return
	 * 		the string used as key to save the Rhapsody version
	 */
	@Operation(kind = Kind.HELPER)
	public String getKeyForRhapsodyVersion() {
		return VERSIONING_EANNOTATION_DETAIL_KEY_RHAPSODY_VERSION;
	}

	/**
	 * 
	 * @return
	 * 		the string used as key to save the Papyrus Import Rhapsody Bundle version
	 */
	@Operation(kind = Kind.HELPER)
	public String getKeyForPapyrusImportBundleVersion() {
		return VERSIONING_EANNOTATION_DETAIL_KEY_PAPYRUS_RHAPSODY_IMPORT_BUNDLE_VERSION;
	}

	/**
	 * 
	 * @return
	 * 		the string used as key to save the Papyrus Import Rhapsody Bundle version
	 */
	@Operation(kind = Kind.HELPER)
	public String getDiagramCompatibilityVersionKey() {
		return COMPATIBILITY_VERSION;
	}

	/**
	 * 
	 * @return
	 * 		the version used to create the diagram to fill the NamedStyle called "diagram_compatibility_version";
	 */
	@Operation(kind = Kind.HELPER)
	public String getDiagramCompatibilityVersion() {
		return "1.2.0"; //$NON-NLS-1$
	}
}
