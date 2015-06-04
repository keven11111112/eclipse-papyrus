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

import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * <p>
 * The Language Service provides information the {@linkplain ILanguage Modeling Languages} that are
 * instantiated in a Papyrus model.
 * </p>
 * <p>
 * In my capacity as an {@link IAdaptable}, I provide other services from the registry in which I
 * am provided as adapters, in addition to whatever other adapters may be contributed for me.
 * </p>
 * 
 * @see ILanguage
 */
public interface ILanguageService extends IAdaptable {
	/**
	 * Queries the languages that are instantiated in the specified model resource.
	 * 
	 * @param modelURI
	 *            the URI of a model resource, such as might be used to load a {@link ModelSet}
	 * @param uriHasFileExtension
	 *            whether the {@code modelURI} has a file extension. For example, if the {@link ModelSet}
	 *            is requesting languages, then the URI typically does not have an extension because a model-set comprising several
	 *            resources that all have the same base file name
	 * 
	 * @return the languages instantiated in the specified resource
	 */
	Set<ILanguage> getLanguages(URI modelURI, boolean uriHasFileExtension);

	/**
	 * Registers a language {@code provider}. Has no effect if the given {@code provider} is already registered.
	 * 
	 * @param provider
	 *            a language provider to add (may not be {@code null})
	 */
	void addLanguageProvider(ILanguageProvider provider);

	/**
	 * Unregisters a language {@code provider}. Has no effect if the given {@code provider} is not currently registered.
	 * 
	 * @param provider
	 *            a language provider to remove (may be {@code null}, which has no effect)
	 */
	void removeLanguageProvider(ILanguageProvider provider);
}
