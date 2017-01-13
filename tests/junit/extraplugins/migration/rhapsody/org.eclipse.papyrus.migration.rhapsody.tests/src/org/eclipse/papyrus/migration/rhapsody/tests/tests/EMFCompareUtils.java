/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.migration.rhapsody.tests.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.diff.DefaultDiffEngine;
import org.eclipse.emf.compare.diff.DiffBuilder;
import org.eclipse.emf.compare.diff.FeatureFilter;
import org.eclipse.emf.compare.diff.IDiffEngine;
import org.eclipse.emf.compare.diff.IDiffProcessor;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IEqualityHelperFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.eobject.WeightProviderDescriptorRegistryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.utils.EqualityHelper;
import org.eclipse.emf.compare.utils.IEqualityHelper;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import com.google.common.cache.LoadingCache;

/**
 * @author VL222926
 *
 */
public class EMFCompareUtils {

//	/**
//	 * 
//	 * @return
//	 * 		an EMF Compare ready for comparison and configured as follow:
//	 *         <ul>
//	 *         <li>comparison USE XMI_ID (UseIdentifiers.NEVER)</li>
//	 *         <li>redefining EqualityHelper to be able to match some UML Element not matching by default</li>
//	 *         <li>redefining the DiffEngine to ignore differences on features which are not ordered in UML</li>
//	 *         </ul>
//	 */
//	public static final EMFCompare createEMFCompare() {
//		// testing equality helper
//
//		// we override the equality helper to be able to match some objects which didn't match with the default one
		//final IEqualityHelperFactory helperFactory = createUMLEqualityHelper();
//		final IComparisonFactory comparisonFactory = new DefaultComparisonFactory(helperFactory);
//
//		// we override the DiffEngine to ignore differences for non ordered feature
//		final IDiffProcessor diffProcessor = new DiffBuilder();
//		final IDiffEngine diffEngine = createDiffEngineIgnoringNonOrderedFeature(diffProcessor);
//
//		final IMatchEngine.Factory.Registry registry = MatchEngineFactoryRegistryImpl.createStandaloneInstance();
//
//		final IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER, WeightProviderDescriptorRegistryImpl.createStandaloneInstance());
//		final MatchEngineFactoryImpl mathEnginefactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
//		registry.add(mathEnginefactory);
//		mathEnginefactory.setRanking(30); // default engine ranking is 10, must be higher to override.
//
//		// TODO : override the post processor too ?
//		return EMFCompare.builder().setDiffEngine(diffEngine).setMatchEngineFactoryRegistry(registry).build();
//	}


	public static final EMFCompare createEMFCompare() {
		// testing equality helper

		// we override the equality helper to be able to match some objects which didn't match with the default one
		//final IEqualityHelperFactory helperFactory = createUMLEqualityHelper();
		final IEqualityHelperFactory helperFactory = new DefaultEqualityHelperFactory();
		final IComparisonFactory comparisonFactory = new DefaultComparisonFactory(helperFactory);

		// we override the DiffEngine to ignore differences for non ordered feature
		final IDiffProcessor diffProcessor = new DiffBuilder();
		final IDiffEngine diffEngine = createDiffEngineIgnoringNonOrderedFeature(diffProcessor);

		final IMatchEngine.Factory.Registry registry = MatchEngineFactoryRegistryImpl.createStandaloneInstance();

//		final IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER, WeightProviderDescriptorRegistryImpl.createStandaloneInstance());
		final IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.ONLY, WeightProviderDescriptorRegistryImpl.createStandaloneInstance());
		final MatchEngineFactoryImpl mathEnginefactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
		registry.add(mathEnginefactory);
		mathEnginefactory.setRanking(30); // default engine ranking is 10, must be higher to override.

		// TODO : override the post processor too ?
		return EMFCompare.builder().setDiffEngine(diffEngine).setMatchEngineFactoryRegistry(registry).build();
	}
	
	// /**
	// *
	// * @return
	// * an EMF Compare ready for comparison and configured as follow:
	// * <ul>
	// * <li>comparison ignoring XMI_ID (UseIdentifiers.NEVER)</li>
	// * <li>redefining EqualityHelper to be able to match some UML Element not matching by default</li>
	// * <li>redefining the DiffEngine to ignore differences on features which are not ordered in UML</li>
	// * </ul>
	// */
	// public static final EMFCompare createEMFCompareV2() {
	// // testing equality helper
	//
	// // we override the equality helper to be able to match some objects which didn't match with the default one
	// final IEqualityHelperFactory helperFactory = createUMLEqualityHelper();
	// final IComparisonFactory comparisonFactory = new DefaultComparisonFactory(helperFactory);
	//
	// // we override the DiffEngine to ignore differences for non ordered feature
	// final IDiffProcessor diffProcessor = new DiffBuilder();
	// final IDiffEngine diffEngine = createDiffEngineIgnoringNonOrderedFeature(diffProcessor);
	//
	//
	// final IMatchEngine.Factory.Registry registry = MatchEngineFactoryRegistryImpl.createStandaloneInstance();
	// final EditionDistance editionDistance = new EditionDistance(WeightProviderDescriptorRegistryImpl.createStandaloneInstance());
	// final CachingDistance cachedDistance = new CachingDistance(editionDistance);
	//
	//
	// IEObjectMatcher matcher = new PapyrusProximityEObjectMatcher(cachedDistance){
	//
	// };
	//
	//// final IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER, WeightProviderDescriptorRegistryImpl.createStandaloneInstance());
	// final MatchEngineFactoryImpl mathEnginefactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
	// registry.add(mathEnginefactory);
	// mathEnginefactory.setRanking(30); // default engine ranking is 10, must be higher to override.
	// return EMFCompare.builder().setDiffEngine(diffEngine).setMatchEngineFactoryRegistry(registry).build();
	// }
	//
	// /**
	// *
	// * @return
	// * an EMF Compare ready for comparison and configured as follow:
	// * <ul>
	// * <li>comparison ignoring XMI_ID (UseIdentifiers.NEVER)</li>
	// * <li>redefining EqualityHelper to be able to match some UML Element not matching by default</li>
	// * <li>redefining the DiffEngine to ignore differences on features which are not ordered in UML</li>
	// * </ul>
	// */
	// public static final EMFCompare createEMFCompareV3() {
	// // testing equality helper
	//
	// // we override the equality helper to be able to match some objects which didn't match with the default one
	//// final IEqualityHelperFactory helperFactory = createUMLEqualityHelper();
	//// final IComparisonFactory comparisonFactory = new DefaultComparisonFactory(helperFactory);
	//
	// // we override the DiffEngine to ignore differences for non ordered feature
	// final IDiffProcessor diffProcessor = new DiffBuilder();
	// final IDiffEngine diffEngine = createDiffEngineIgnoringNonOrderedFeature(diffProcessor);
	//
	//
	// final IMatchEngine.Factory.Registry registry = MatchEngineFactoryRegistryImpl.createStandaloneInstance();
	// final EditionDistance editionDistance = new EditionDistance(WeightProviderDescriptorRegistryImpl.createStandaloneInstance());
	// final CachingDistance cachedDistance = new CachingDistance(editionDistance);
	//
	//
	// IEObjectMatcher matcher = new PapyrusProximityEObjectMatcher(cachedDistance);
	//
	//// final IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER, WeightProviderDescriptorRegistryImpl.createStandaloneInstance());
	// final MatchEngineFactoryImpl mathEnginefactory = new MatchEngineFactoryImpl(matcher, new DefaultComparisonFactory(new DefaultEqualityHelperFactory()));
	// registry.add(mathEnginefactory);
	// mathEnginefactory.setRanking(30); // default engine ranking is 10, must be higher to override.
	// return EMFCompare.builder().setDiffEngine(diffEngine).setMatchEngineFactoryRegistry(registry).build();
	// }


	/**
	 * 
	 * @return
	 * 		a new equality helper used for UML
	 */
	protected static final IEqualityHelperFactory createUMLEqualityHelper() {
		// we override the equality helper to be able to match some objects which didn't match with the default one
		final IEqualityHelperFactory helperFactory = new DefaultEqualityHelperFactory() {
			@Override
			public IEqualityHelper createEqualityHelper() {
				final LoadingCache<EObject, URI> cache = EqualityHelper.createDefaultCache(getCacheBuilder());
				return new UMLIgnoringIdentifiedEqualityHelper(cache);
			}
		};
		return helperFactory;
	}

	/**
	 * 
	 * @param diffProcessor
	 *            the diff processor
	 * @return
	 * 		a DiffEngine ignoring the feature where isOrdered() return false;s
	 */
	protected static final IDiffEngine createDiffEngineIgnoringNonOrderedFeature(IDiffProcessor diffProcessor) {
		return new DefaultDiffEngine(diffProcessor) {
			@Override
			protected FeatureFilter createFeatureFilter() {
				return new FeatureFilter() {


					/**
					 * 
					 * @see org.eclipse.emf.compare.diff.FeatureFilter#checkForOrderingChanges(org.eclipse.emf.ecore.EStructuralFeature)
					 *
					 * @param feature
					 * @return
					 */
					@Override
					public boolean checkForOrderingChanges(EStructuralFeature feature) {
						if (feature.isOrdered()) {
							if (feature.eClass().getEPackage() == EcorePackage.eINSTANCE) {
								return false;
							}
							System.out.println("ORDERED_FEATURE:  " + feature.getName());
						}
						return feature.isOrdered();
					}
				};
			}
		};
	}
}
