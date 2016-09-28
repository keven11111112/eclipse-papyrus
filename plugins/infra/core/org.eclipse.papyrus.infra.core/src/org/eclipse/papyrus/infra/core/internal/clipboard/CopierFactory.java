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

package org.eclipse.papyrus.infra.core.internal.clipboard;

import java.util.function.BiPredicate;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.papyrus.infra.core.clipboard.ICopierFactory;

/**
 * A factory that creates copiers for the Papyrus Clipboard.
 */
public class CopierFactory implements ICopierFactory {

	private final boolean useOriginalReferences;

	/**
	 * The default copier factory that provides the usual EMF
	 * copying semantics, except with filtering of references
	 * as directed by {@linkplain #registerReferenceFilter(BiPredicate) registered filters}.
	 */
	public static CopierFactory DEFAULT = new CopierFactory(true);

	/**
	 * Initializes me.
	 * 
	 * @param useOriginalReferences
	 *            whether non-copied references should be used while copying
	 */
	public CopierFactory(boolean useOriginalReferences) {
		super();

		this.useOriginalReferences = useOriginalReferences;
	}

	/**
	 * Queries whether non-copied references should be used while copying.
	 * 
	 * @return whether to use non-copied references
	 */
	public boolean isUseOriginalReferences() {
		return useOriginalReferences;
	}

	@Override
	public Copier get() {
		DefaultConfiguration configuration = new DefaultConfiguration(true, isUseOriginalReferences());
		CopierConfiguratorRegistry.INSTANCE.configureCopier(configuration);

		return createCopier(configuration);
	}

	private Copier createCopier(DefaultConfiguration configuration) {
		return configuration.isEmpty()
				? createBasicCopier()
				: new ConfiguredCopier(configuration);
	}

	private Copier createBasicCopier() {
		return new Copier(true, isUseOriginalReferences());
	}

	//
	// Nested types
	//

	private static class ConfiguredCopier extends Copier {
		private static final long serialVersionUID = 1L;

		private final DefaultConfiguration configuration;

		ConfiguredCopier(DefaultConfiguration configuration) {
			super(configuration.isResolveReferences(), configuration.isUseOriginalReferences());

			this.configuration = configuration;
		}

		@Override
		protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject) {
			if (configuration.shouldCopyReference(eReference, eObject)) {
				super.copyReference(eReference, eObject, copyEObject);
			}
		}
	}
}
