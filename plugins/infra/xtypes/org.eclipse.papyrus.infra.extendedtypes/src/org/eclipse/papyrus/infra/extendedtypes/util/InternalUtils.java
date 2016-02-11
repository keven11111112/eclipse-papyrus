/*****************************************************************************
 * Copyright (c) 2013, 2016 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - bug 485220
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.extendedtypes.util;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

/**
 * Utilities for internal use by rthe ExtendedTypes bundle.
 * 
 * @noreference This class is not intended to be referenced by clients.
 */
public class InternalUtils {

	/** A map of classes that have been successfully loaded, keyed on the class name optionally prepended by the plugin ID, if specified. */
	private static Map<String, WeakReference<Class<?>>> successLookupTable = new HashMap<String, WeakReference<Class<?>>>();

	/** A map of classes that could not be loaded, keyed on the class name, optionally prepended by the plugin ID if specified. */
	private static Set<String> failureLookupTable = new HashSet<String>();

	/** A map to hold the bundle to exception list */
	private static Map<Bundle, Set<String>> bundleToExceptionsSetMap = new HashMap<Bundle, Set<String>>();

	private InternalUtils() {
		super();
	}

	/**
	 * A utility method to load a class using its name and a given class loader.
	 *
	 * @param className
	 *            The class name
	 * @param bundle
	 *            The class loader
	 * @return The loaded class or <code>null</code> if could not be loaded
	 */
	public static Class<?> loadClass(String className, String pluginId) {
		// FIXME: This method is grossly flawed, as it requires the class being loaded to be contained within the identified bundle, not anywhere on its classpath
		StringBuffer keyStringBuf = new StringBuffer(className.length() + pluginId.length() + 2); // 2 is for . and extra.
		keyStringBuf.append(pluginId);
		keyStringBuf.append('.');
		keyStringBuf.append(className);
		String keyString = keyStringBuf.toString();
		WeakReference<Class<?>> ref = successLookupTable.get(keyString);
		Class<?> found = (ref != null) ? ref.get() : null;
		if (found == null) {
			if (ref != null) {
				successLookupTable.remove(keyString);
			}
			if (!failureLookupTable.contains(keyString)) {
				try {
					Bundle bundle = basicGetPluginBundle(pluginId);
					if (bundle != null) {
						// never load the class if the bundle is not active other wise
						// we will cause the plugin to load
						// unless the class is in the exception list
						int state = bundle.getState();
						if (state == org.osgi.framework.Bundle.ACTIVE || isInExceptionList(bundle, className)) {
							found = bundle.loadClass(className);
							successLookupTable.put(keyString, new WeakReference<Class<?>>(found));
							if (state == org.osgi.framework.Bundle.ACTIVE) {
								bundleToExceptionsSetMap.remove(bundle);
							}
						}
					} else {
						failureLookupTable.add(keyString);
					}
				} catch (ClassNotFoundException e) {
					failureLookupTable.add(keyString);
				}
			}
		}
		return found;
	}

	private static boolean isInExceptionList(Bundle bundle, String className) {
		String packageName = className.substring(0, className.lastIndexOf('.'));
		Set<String> exceptionSet = bundleToExceptionsSetMap.get(bundle);
		if (exceptionSet == null) {
			Dictionary<String, String> dict = bundle.getHeaders();
			int index = -1;
			String value = dict.get("Bundle-ActivationPolicy"); //$NON-NLS-1$
			if (value != null) {
				index = value.indexOf("lazy"); //$NON-NLS-1$
				if (index >= 0) {
					index = value.indexOf("exclude", index); //$NON-NLS-1$
				}
			}
			if (index < 0) {
				// Try the (very) old way
				value = dict.get("Eclipse-LazyStart"); //$NON-NLS-1$
				if (value != null) {
					index = value.indexOf("exceptions"); //$NON-NLS-1$
				}
			}
			if (index >= 0) {
				try {
					int start = value.indexOf('"', index + 1);
					int end = value.indexOf('"', start + 1);
					String exceptions = value.substring(start + 1, end);
					exceptionSet = new HashSet<String>(2);
					StringTokenizer tokenizer = new StringTokenizer(exceptions, ","); //$NON-NLS-1$
					while (tokenizer.hasMoreTokens()) {
						exceptionSet.add(tokenizer.nextToken().trim());
					}
				} catch (IndexOutOfBoundsException exception) {
					// this means the MF did not follow the documented format for the exceptions list so i'll consider it empty
					exceptionSet = Collections.emptySet();
				}
			} else {
				exceptionSet = Collections.emptySet();
			}
			bundleToExceptionsSetMap.put(bundle, exceptionSet);
		}
		return exceptionSet.contains(packageName);
	}

	/**
	 * Given a bundle id, it checks if the bundle is found and activated. If it
	 * is, the method returns the bundle, otherwise it returns <code>null</code>.
	 *
	 * @param pluginId
	 *            the bundle ID
	 * @return the bundle, if found
	 */
	private static Bundle getPluginBundle(String pluginId) {
		Bundle bundle = basicGetPluginBundle(pluginId);
		if (null != bundle && bundle.getState() == org.osgi.framework.Bundle.ACTIVE) {
			return bundle;
		}
		return null;
	}

	private static Bundle basicGetPluginBundle(String pluginId) {
		return Platform.getBundle(pluginId);
	}

}
