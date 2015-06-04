/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
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

package org.eclipse.papyrus.infra.core.internal.language;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.core.language.ILanguage;
import org.eclipse.papyrus.infra.core.language.ILanguageProvider;
import org.eclipse.papyrus.infra.core.language.ILanguageService;
import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * The implementation of the Papyrus Modeling Language Service.
 */
public class LanguageService extends PlatformObject implements ILanguageService, IService {

	private final CopyOnWriteArrayList<ILanguageProvider> languageProviders = Lists.newCopyOnWriteArrayList();

	private ServicesRegistry registry;

	public LanguageService() {
		super();
	}

	@Override
	public Set<ILanguage> getLanguages(URI modelURI, boolean uriHasFileExtension) {
		Set<ILanguage> result = Sets.newHashSet();

		for (ILanguageProvider next : languageProviders) {
			Iterables.addAll(result, next.getLanguages(this, modelURI, uriHasFileExtension));
		}

		return result;
	}

	@Override
	public void addLanguageProvider(ILanguageProvider provider) {
		languageProviders.addIfAbsent(provider);
	}

	@Override
	public void removeLanguageProvider(ILanguageProvider provider) {
		if (provider != null) {
			languageProviders.remove(provider);
		}
	}

	//
	// Adaptable API
	//


	/**
	 * Adaptation to other services in the registry takes precedence over registered adapter factories.
	 */
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		T result;

		if (adapter.isInstance(registry)) {
			result = adapter.cast(registry);
		} else {
			result = (registry == null) ? null : ServiceUtils.getInstance().getService(adapter, registry, null);
		}

		return (result != null) ? result : super.getAdapter(adapter);
	}

	//
	// Service lifecycle API
	//

	@Override
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		this.registry = servicesRegistry;
	}

	@Override
	public void startService() throws ServiceException {
		languageProviders.addAllAbsent(ILanguageProvider.Registry.INSTANCE.getProviders());
	}

	@Override
	public void disposeService() throws ServiceException {
		languageProviders.clear();
		registry = null;
	}

}
