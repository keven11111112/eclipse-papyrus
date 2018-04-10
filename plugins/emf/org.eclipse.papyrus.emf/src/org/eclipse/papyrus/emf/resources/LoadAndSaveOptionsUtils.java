/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.emf.resources;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;

/**
 * @author Vincent LORENZO
 *
 *         This class provides the common load and save options to use in the Papyrus EMF models
 */
public final class LoadAndSaveOptionsUtils {

	/**
	 * the save options to use in Papyrus
	 */
	private static final Map<Object, Object> SAVE_OPTIONS;

	/**
	 * the load options to use in Papyrus
	 */
	private static final Map<Object, Object> LOAD_OPTIONS;

	static {

		// create the save options
		SAVE_OPTIONS = new HashMap<Object, Object>();
		// idem in Papyrus ModelSet
		SAVE_OPTIONS.put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware());


		// idem in MultiDiagramUtil
		SAVE_OPTIONS.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
		SAVE_OPTIONS.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

		// formating option about the size of the line in the file
		// options.put(XMLResource.OPTION_LINE_WIDTH, 10);
		SAVE_OPTIONS.put(Resource.OPTION_LINE_DELIMITER, Resource.OPTION_LINE_DELIMITER_UNSPECIFIED);

		// to force the save of the default content
		SAVE_OPTIONS.put(XMLResource.OPTION_KEEP_DEFAULT_CONTENT, Boolean.TRUE);
		SAVE_OPTIONS.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
		SAVE_OPTIONS.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);

		// create the load options
		// the same as in Papyrus ModelSet
		LOAD_OPTIONS = new HashMap<Object, Object>();
		LOAD_OPTIONS.put(XMLResource.OPTION_DEFER_ATTACHMENT,  Boolean.TRUE);
		LOAD_OPTIONS.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION,  Boolean.TRUE);
		LOAD_OPTIONS.put(XMLResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);
		LOAD_OPTIONS.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
		LOAD_OPTIONS.put(XMLResource.OPTION_USE_PACKAGE_NS_URI_AS_LOCATION, Boolean.FALSE);
	}

	/**
	 * Constructor.
	 *
	 */
	private LoadAndSaveOptionsUtils() {
		// to avoid instanciation
	}

	/**
	 * 
	 * @return
	 * 		the load options to use in the Papyrus EMF model
	 */
	public static final Map<Object, Object> getLoadOptions() {
		return new HashMap<Object, Object>(LOAD_OPTIONS);// we create a copy, to avoid non wanted changes
	}

	/**
	 * 
	 * @return
	 * 		the save options to use in the Papyrus EMF model
	 */
	public static final Map<Object, Object> getSaveOptions() {
		return new HashMap<Object, Object>(SAVE_OPTIONS);// we create a copy, to avoid non wanted changes
	}
}
