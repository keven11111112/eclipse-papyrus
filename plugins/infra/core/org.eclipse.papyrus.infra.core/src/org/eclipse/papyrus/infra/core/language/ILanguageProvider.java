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

package org.eclipse.papyrus.infra.core.language;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.core.internal.language.LanguageProviderRegistry;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * A provider of {@link ILanguage}s to the {@linkplain ILanguageService service}.
 * Providers may be registered dynamically using the {@linkplain ILanguageService#addLanguageProvider(ILanguageProvider) service API}
 * or may be registered statically on the <tt>org.eclipse.papyrus.infra.core.language</tt> extension point.
 */
public interface ILanguageProvider {
	/**
	 * Queries the languages that are instantiated in the specified model resource.
	 * 
	 * @param languageService
	 *            the language service that is requesting languages
	 * @param modelURI
	 *            the URI of a model resource for which the service wants to determine languages
	 * @param uriHasFileExtension
	 *            whether the {@code modelURI} has a file extension. For example, if the {@link ModelSet}
	 *            is requesting languages, then the URI typically does not have an extension because a model-set comprising several
	 *            resources that all have the same base file name
	 * 
	 * @return the languages instantiated in the specified resource. May be empty if this provider does not recognize any languages in the resource
	 */
	Iterable<ILanguage> getLanguages(ILanguageService languageService, URI modelURI, boolean uriHasFileExtension);

	//
	// Nested types
	//

	interface Registry {
		Registry INSTANCE = new LanguageProviderRegistry();

		Collection<ILanguageProvider> getProviders();
	}
}
