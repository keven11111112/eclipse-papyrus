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

package org.eclipse.papyrus.infra.elementtypesconfigurations.registries;

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
import org.eclipse.papyrus.infra.elementtypesconfigurations.Activator;
import org.eclipse.papyrus.infra.elementtypesconfigurations.extensionpoints.IUserElementTypeDefinitionsExtensionPoint;
import org.eclipse.papyrus.infra.elementtypesconfigurations.internal.registries.spi.IUserElementTypeDefinitionsProvider;

/**
 * Registry of {@link IUserElementTypeDefinitionsProvider}s.
 */
class UserElementTypeDefinitionsRegistry implements IUserElementTypeDefinitionsExtensionPoint, IUserElementTypeDefinitionsProvider {

	private static final UserElementTypeDefinitionsRegistry INSTANCE = new UserElementTypeDefinitionsRegistry();

	// Only should have the one in the UI bundle
	private final List<IUserElementTypeDefinitionsProvider> providers = new ArrayList<>(1);

	private UserElementTypeDefinitionsRegistry() {
		super();

		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT_ID);
		for (IConfigurationElement next : elements) {
			switch (next.getName()) {
			case E_PROVIDER:
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

	public static UserElementTypeDefinitionsRegistry getInstance() {
		return INSTANCE;
	}

	private IUserElementTypeDefinitionsProvider createProvider(IConfigurationElement config) throws CoreException {
		Object result = config.createExecutableExtension(A_CLASS);

		if (!(result instanceof IUserElementTypeDefinitionsProvider)) {
			throw new ClassCastException("Extension does not implement IUserElementTypeDefinitionsProvider interface in contributor " + config.getContributor().getName()); //$NON-NLS-1$
		}

		return (IUserElementTypeDefinitionsProvider) result;
	}

	@Override
	public String getElementTypesRedefinition(String elementTypesID) {
		switch (providers.size()) {
		case 0:
			return null;
		case 1:
			return providers.get(0).getElementTypesRedefinition(elementTypesID);
		default:
			return providers.stream()
					.map(p -> p.getElementTypesRedefinition(elementTypesID))
					.filter(Objects::nonNull)
					.findFirst()
					.orElse(null);
		}
	}

	@Override
	public Map<String, String> getLocalElementTypeDefinitions() {
		switch (providers.size()) {
		case 0:
			return Collections.emptyMap();
		case 1:
			return providers.get(0).getLocalElementTypeDefinitions();
		default:
			return providers.stream()
					.map(IUserElementTypeDefinitionsProvider::getLocalElementTypeDefinitions)
					.filter(Objects::nonNull)
					.filter(((Predicate<? super Map<String, String>>) Map::isEmpty).negate())
					.reduce(new HashMap<>(), (acc, elem) -> {
						acc.putAll(elem);
						return acc;
					});
		}
	}
}
