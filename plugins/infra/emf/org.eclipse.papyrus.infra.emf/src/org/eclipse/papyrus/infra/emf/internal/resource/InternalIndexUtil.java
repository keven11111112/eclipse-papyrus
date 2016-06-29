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

package org.eclipse.papyrus.infra.emf.internal.resource;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.core.internal.language.ILanguageModel;
import org.eclipse.papyrus.infra.core.language.ILanguageService;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * Miscellaneous internal utilities supporting or using the model indexing facilities.
 */
public class InternalIndexUtil {

	/**
	 * Not instantiable by clients.
	 */
	private InternalIndexUtil() {
		super();
	}

	/**
	 * Determine the resource file extensions that contain "semantic model" content,
	 * using heuristics if necessary to make a best guess.
	 * 
	 * @param resourceSet
	 *            a resource set
	 * @return the set of file extensions for resources that are expected to contain
	 *         semantic model content that is interesting to index
	 */
	// in which the shard loading is important
	public static Set<String> getSemanticModelFileExtensions(ResourceSet resourceSet) {
		Set<String> result = null;

		try {
			if (resourceSet instanceof ModelSet) {
				ILanguageService.getLanguageModels((ModelSet) resourceSet).stream()
						.map(m -> m.getAdapter(ILanguageModel.class))
						.filter(Objects::nonNull) // Not all models provide the adapter
						.map(ILanguageModel::getModelFileExtension)
						.filter(Objects::nonNull) // They really should provide this, though
						.collect(Collectors.toSet());
			}
		} catch (Exception e) {
			// We seem not to have the Language Service? That's fine
		} catch (LinkageError e) {
			// We seem to be operating without the Eclipse/OSGi run-time? That's fine
		}

		if (result == null) {
			// Best guess for common Papyrus applications
			result = Collections.singleton("uml"); //$NON-NLS-1$
		}

		return result;
	}
}
