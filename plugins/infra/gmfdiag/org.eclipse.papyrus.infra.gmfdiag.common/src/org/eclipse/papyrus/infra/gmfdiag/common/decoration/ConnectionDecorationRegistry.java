/*****************************************************************************
 * Copyright (c) 2017 CEA LIST, ALL4TEC and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.decoration;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;

/**
 * Registry for connection decoration declared throw <i>org.eclipse.papyrus.infra.gmfdiag.common.connectionDecoration</i> extension point.
 * 
 * @author Mickaël ADAM
 * @since 3.1
 */
public class ConnectionDecorationRegistry {

	/** The extension point id for connection decoration declaration. */
	public static final String EXTENSION_ID = Activator.ID + ".connectionDecoration";//$NON-NLS-1$

	/** the registry. */
	private volatile static ConnectionDecorationRegistry registry;

	/** The decoration map. */
	protected Map<String, Class<? extends RotatableDecoration>> decorationMap = null;

	/**
	 * Constructor.
	 */
	private ConnectionDecorationRegistry() {
		super();
	}

	/**
	 * @return the singleton instance of this registry
	 */
	public static synchronized ConnectionDecorationRegistry getInstance() {
		if (null == registry) {
			registry = new ConnectionDecorationRegistry();
			registry.init();
		}
		return registry;
	}

	/**
	 * Initialize the registry.
	 */
	protected void init() {
		decorationMap = new HashMap<String, Class<? extends RotatableDecoration>>();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
		for (IConfigurationElement element : elements) {
			String decorationName = element.getAttribute("name"); //$NON-NLS-1$
			String decorationClass = element.getAttribute("class"); //$NON-NLS-1$
			Class<? extends RotatableDecoration> loadClass = ClassLoaderHelper.loadClass(decorationClass, RotatableDecoration.class);
			if (null != loadClass) {
				decorationMap.put(decorationName, loadClass);
			}
		}
	}

	/**
	 * Gets the decoration class.
	 * 
	 * @param decorationName
	 *            the decoration name
	 * @return the decoration class (null if not found)
	 */
	public Class<? extends RotatableDecoration> getDecorationClass(final String decorationName) {
		Class<? extends RotatableDecoration> decorationClass = null;
		if (null != decorationName) {
			decorationClass = decorationMap.get(decorationName);
		}
		return decorationClass;
	}

	/**
	 * @return the map of all available decorations.
	 */
	public Map<String, Class<? extends RotatableDecoration>> getAvailableDecoration() {
		return decorationMap;
	}

}
