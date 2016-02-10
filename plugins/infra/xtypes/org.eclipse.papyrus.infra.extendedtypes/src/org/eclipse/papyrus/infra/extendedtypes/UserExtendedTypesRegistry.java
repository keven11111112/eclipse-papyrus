/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.extendedtypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.extendedtypes.internal.spi.IUserExtendedTypesProvider;
import org.eclipse.papyrus.infra.types.core.Activator;

/**
 * Registry of {@link IUserExtendedTypesProvider}s.
 */
class UserExtendedTypesRegistry implements IUserExtendedTypesProvider {

	private static final UserExtendedTypesRegistry INSTANCE = new UserExtendedTypesRegistry();

	// Only should have the one in the UI bundle
	private final List<IUserExtendedTypesProvider> providers = new ArrayList<>(1);

	private UserExtendedTypesRegistry() {
		super();

		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(Activator.PLUGIN_ID, "userExtendedTypes"); //$NON-NLS-1$
		for (IConfigurationElement next : elements) {
			switch (next.getName()) {
			case "provider": //$NON-NLS-1$
				try {
					providers.add(createProvider(next));
				} catch (ClassCastException e) {
					Activator.log.error(e);
				} catch (CoreException e) {
					Activator.log.log(e.getStatus());
				}
				break;
			}
		}
	}

	public static UserExtendedTypesRegistry getInstance() {
		return INSTANCE;
	}

	private IUserExtendedTypesProvider createProvider(IConfigurationElement config) throws CoreException {
		Object result = config.createExecutableExtension("class"); //$NON-NLS-1$

		if (!(result instanceof IUserExtendedTypesProvider)) {
			throw new ClassCastException("Extension does not implement IUserExtendedTypesProvider interface in contributor " + config.getContributor().getName()); //$NON-NLS-1$
		}

		return (IUserExtendedTypesProvider) result;
	}

	@Override
	public String getExtendedTypesRedefinition(String extendedTypesID) {
		switch (providers.size()) {
		case 0:
			return null;
		case 1:
			return providers.get(0).getExtendedTypesRedefinition(extendedTypesID);
		default:
			return providers.stream()
					.map(p -> p.getExtendedTypesRedefinition(extendedTypesID))
					.filter(Objects::nonNull)
					.findFirst()
					.orElse(null);
		}
	}

	@Override
	public Map<String, String> getLocalExtendedTypesDefinitions() {
		switch (providers.size()) {
		case 0:
			return Collections.emptyMap();
		case 1:
			return providers.get(0).getLocalExtendedTypesDefinitions();
		default:
			return providers.stream()
					.map(IUserExtendedTypesProvider::getLocalExtendedTypesDefinitions)
					.filter(Objects::nonNull)
					.filter(((Predicate<? super Map<String, String>>) Map::isEmpty).negate())
					.reduce(new HashMap<>(), (acc, elem) -> {
						acc.putAll(elem);
						return acc;
					});
		}
	}
}
