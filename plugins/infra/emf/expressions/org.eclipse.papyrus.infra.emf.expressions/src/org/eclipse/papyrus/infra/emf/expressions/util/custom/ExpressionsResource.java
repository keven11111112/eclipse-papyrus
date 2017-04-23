/**
 * Copyright (c) 2017 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.emf.expressions.util.custom;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

/**
 * 
 * We create our own resource to manage the save options with (I hope) no doubt.
 * The goal is to avoid formatting trouble between editors
 *
 */
public class ExpressionsResource extends XMIResourceImpl {

	/**
	 * The extension for the file owning Expressions
	 */
	public static final String EXPRESSIONS_RESOURCE_FILE_EXTENSION = "expressions"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 *
	 * @param uri
	 */
	public ExpressionsResource(URI uri) {
		super(uri);
	}

	/**
	 * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#useUUIDs()
	 *
	 * @return
	 */

	@Override
	protected boolean useUUIDs() {
		return true;
	}

	@Override
	public void save(Map<?, ?> options) throws IOException {
		super.save(getDefaultSaveOptions());// we bypass the options argument to avoid changes between editors (ExpressionEditor, Ecore Sample Reflexive Editor and Ecore Editor
	}

	/**
	 * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#getDefaultSaveOptions()
	 *
	 * @return
	 */

	@Override
	public Map<Object, Object> getDefaultSaveOptions() {
		if (null == this.defaultSaveOptions) {
			Map<Object, Object> options = super.getDefaultSaveOptions();

			// idem in Papyrus ModelSet
			options.put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware());


			// idem in MultiDiagramUtil
			options.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
			options.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

			// formating option about the size of the line in the file
			// options.put(XMLResource.OPTION_LINE_WIDTH, 10);
			options.put(Resource.OPTION_LINE_DELIMITER, Resource.OPTION_LINE_DELIMITER_UNSPECIFIED);

		}
		return this.defaultSaveOptions;

	}

	/**
	 * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#getDefaultLoadOptions()
	 *
	 * @return
	 */

	@Override
	public Map<Object, Object> getDefaultLoadOptions() {
		if (null == this.defaultLoadOptions) {
			Map<Object, Object> options = super.getDefaultLoadOptions();
			// the same as in Papyrus ModelSet
			options.put(XMLResource.OPTION_DEFER_ATTACHMENT, true);
			options.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, true);
			options.put(XMLResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);
			options.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
			options.put(XMLResource.OPTION_USE_PACKAGE_NS_URI_AS_LOCATION, Boolean.FALSE);
		}
		return this.defaultLoadOptions;
	}

}
