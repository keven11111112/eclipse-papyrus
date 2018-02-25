/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent LORENZO (CEA LIST) - Initial API and implementation
 *      
 *****************************************************************************/

package org.eclipse.papyrus.internal.infra.nattable.model.resources;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

/**
 * @author Vincent LORENZO
 * @since 4.1
 */
public class NattableConfigurationResource extends XMIResourceImpl {

	/**
	 * the extension of the table configuration file
	 */
	public static final String NATTABLE_CONFIGURATION_RESOURCE_FILE_EXTENSION = "nattableconfiguration"; //$NON-NLS-1$
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param uri
	 */
	public NattableConfigurationResource(final URI uri) {
		super(uri);
	}

	/**
	 * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#useUUIDs()
	 *
	 * @return
	 */

	@Override
	protected boolean useUUIDs() {
		return false; // currently, will be done using new resource EMF
	}

	/**
	 * 
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl#save(java.util.Map)
	 *
	 * @param options
	 * @throws IOException
	 */
	@Override
	public final void save(Map<?, ?> options) throws IOException {
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
			final Map<Object, Object> saveOptions = super.getDefaultSaveOptions();
			saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
			saveOptions.put(Resource.OPTION_LINE_DELIMITER, Resource.OPTION_LINE_DELIMITER_UNSPECIFIED);
			saveOptions.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, true);
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
			super.getDefaultLoadOptions();
		}
		return this.defaultLoadOptions;
	}
}
