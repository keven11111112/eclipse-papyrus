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

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

/**
 * A factory that creates copiers for the Papyrus Clipboard.
 */
public class CopierFactory implements Supplier<Copier> {

	private static List<BiPredicate<? super EReference, ? super EObject>> referenceFilters = new CopyOnWriteArrayList<>();

	private final ResourceSet resourceSet;
	private final boolean useOriginalReferences;

	/**
	 * The default copier factory that provides the usual EMF
	 * copying semantics, except with filtering of references
	 * as directed by {@linkplain #registerReferenceFilter(BiPredicate) registered filters}.
	 * 
	 * @deprecated This does not provide copiers that account
	 *             for {@link EFactory} instances registered in
	 *             the context of the resource set
	 * @see <a href="http://eclip.se/508404">bug 508404</a>
	 */
	@Deprecated
	public static final CopierFactory DEFAULT = new CopierFactory(true);

	/**
	 * Initializes me.
	 * 
	 * @param useOriginalReferences
	 *            whether non-copied references should be used while copying
	 * 
	 * @deprecated This does not provide copiers that account
	 *             for {@link EFactory} instances registered in
	 *             the context of the resource set
	 * @see <a href="http://eclip.se/508404">bug 508404</a>
	 */
	@Deprecated
	public CopierFactory(boolean useOriginalReferences) {
		this(null, useOriginalReferences);
	}

	/**
	 * Initializes me with the resource set in which context I copy model elements.
	 * Copiers that I create will use original references.
	 * 
	 * @param resourceSet
	 *            my resource set context
	 */
	public CopierFactory(ResourceSet resourceSet) {
		this(resourceSet, true);
	}

	/**
	 * Initializes me with the resource set in which context I copy model elements.
	 * 
	 * @param resourceSet
	 *            my resource set context
	 * @param useOriginalReferences
	 *            whether non-copied references should be used while copying
	 */
	public CopierFactory(ResourceSet resourceSet, boolean useOriginalReferences) {
		super();

		this.resourceSet = resourceSet;
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
		Copier result;

		Optional<BiPredicate<? super EReference, ? super EObject>> referenceFilter = getReferenceFilter();
		result = referenceFilter.map(this::createReferenceFilteringCopier)
				.orElseGet(this::createBasicCopier);

		return result;
	}

	/**
	 * Obtains a predicate that accepts any reference not matching
	 * any of our registered filters (a {@code not} of the collective
	 * {@code or} of our filters).
	 * 
	 * @return the optional reference filter
	 */
	private Optional<BiPredicate<? super EReference, ? super EObject>> getReferenceFilter() {
		return referenceFilters.stream()
				.reduce(BiPredicate::or)
				.map(BiPredicate::negate);
	}

	private Copier createReferenceFilteringCopier(BiPredicate<? super EReference, ? super EObject> referencePredicate) {
		return new ReferenceFilteringCopier(true, isUseOriginalReferences(), getPackageRegistry(),
				referencePredicate);
	}

	private Copier createBasicCopier() {
		return new BasicCopier(true, isUseOriginalReferences(), getPackageRegistry());
	}

	private EPackage.Registry getPackageRegistry() {
		return (resourceSet == null) ? EPackage.Registry.INSTANCE : resourceSet.getPackageRegistry();
	}

	/**
	 * Registers a predicate that matches references to be excluded from copy operations.
	 * 
	 * @param filter
	 *            a predicate that matches a reference to be excluded for a given owner object
	 */
	public static void registerReferenceFilter(BiPredicate<? super EReference, ? super EObject> filter) {
		referenceFilters.add(filter);
	}

	//
	// Nested types
	//

	private static class BasicCopier extends Copier {
		private static final long serialVersionUID = 1L;

		private final EPackage.Registry packageRegistry;

		BasicCopier(boolean resolveReferences, boolean useOriginalReferences, EPackage.Registry registry) {
			super(resolveReferences, useOriginalReferences);

			this.packageRegistry = registry;
		}

		@Override
		protected EObject createCopy(EObject eObject) {
			EClass eClass = getTarget(eObject);
			EFactory eFactory = getEFactory(eClass);
			return eFactory.create(eClass);
		}

		EFactory getEFactory(EClass eClass) {
			EFactory result = packageRegistry.getEFactory(eClass.getEPackage().getNsURI());

			if (result == null) {
				result = eClass.getEPackage().getEFactoryInstance();
			}

			return result;
		}
	}

	private static class ReferenceFilteringCopier extends BasicCopier {
		private static final long serialVersionUID = 1L;

		private final BiPredicate<? super EReference, ? super EObject> referencePredicate;

		ReferenceFilteringCopier(boolean resolveReferences, boolean useOriginalReferences, EPackage.Registry registry, BiPredicate<? super EReference, ? super EObject> referencePredicate) {
			super(resolveReferences, useOriginalReferences, registry);

			this.referencePredicate = referencePredicate;
		}

		@Override
		protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject) {
			if (referencePredicate.test(eReference, eObject)) {
				super.copyReference(eReference, eObject, copyEObject);
			}
		}
	}
}
