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

package org.eclipse.papyrus.aof.sync.emf;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.aof.core.IBox;

/**
 * An auto-disable hook that attaches an annotation recording synchronization exclusions
 * to {@linkplain EModelElement Ecore element}s.
 */
public class EcoreAutoDisableHook<E extends EModelElement> implements BiConsumer<IBox<? extends E>, Object>, BiPredicate<E, Object> {
	public static final String ANNOTATION_SOURCE = "http://www.eclipse.org/Papyrus/2015/sync"; //$NON-NLS-1$
	public static final String ANNOTATION_DETAIL_EXCLUSIONS = "excludeFeatures"; //$NON-NLS-1$

	private static final Pattern WHITESPACE = Pattern.compile("\\s+"); //$NON-NLS-1$

	/**
	 * Initializes me.
	 */
	public EcoreAutoDisableHook() {
		super();
	}

	@Override
	public void accept(IBox<? extends E> box, Object userData) {
		String featureName = getFeatureName(userData);
		if (featureName != null) {
			box.forEach(e -> annotate(e, featureName));
		}
	}

	/**
	 * Queries whether the synchronization of the given {@code property} is enabled for an
	 * {@code element} according to the configured auto-disablement hook.
	 * 
	 * @param element
	 *            a model element
	 * @param property
	 *            the property to be synchronized
	 * @param autoDisableHook
	 *            an auto-disablement hook configured for the requesting mapping, or
	 *            {@code null} if none
	 * 
	 * @return whether the {@code property} should be synchronized for this {@code element} according
	 *         to the hook, if it is of a type that we know how to query
	 * 
	 * @see #test(EModelElement, Object)
	 */
	public static <E extends EObject> boolean isEnabled(E element, Object property, BiConsumer<? super IBox<? extends E>, ?> autoDisableHook) {
		boolean result = true;

		if ((element instanceof EModelElement) && (autoDisableHook instanceof BiPredicate<?, ?>)) {
			@SuppressWarnings("unchecked")
			BiPredicate<? super E, Object> predicate = (BiPredicate<? super E, Object>) autoDisableHook;
			result = predicate.test(element, property);
		}

		return result;
	}

	static <E extends EObject> boolean isSyncEnabled(IBox<? extends E> toBox, Object identifiedBy, BiConsumer<IBox<? extends E>, Object> hook) {
		boolean result = true;

		if ((hook != null) && toBox.isSingleton() && (toBox.length() > 0)) {
			E element = toBox.get(0);
			result = EcoreAutoDisableHook.isEnabled(element, identifiedBy, hook);
		}

		return result;
	}

	/**
	 * Queries whether the synchronization of the given {@code property} is enabled for an
	 * {@code element}.
	 * 
	 * @param element
	 *            a model element
	 * @param property
	 *            the property to be synchronized
	 * 
	 * @return whether the {@code property} should be synchronized for this {@code element}
	 * 
	 * @see #isEnabled(EModelElement, EStructuralFeature)
	 */
	@Override
	public boolean test(E element, Object property) {
		boolean result = true;

		if (property instanceof EStructuralFeature) {
			result = isEnabled(element, (EStructuralFeature) property);
		}

		return result;
	}

	/**
	 * Queries whether the synchronization of the given {@code feature} is enabled for an
	 * {@code element}.
	 * 
	 * @param element
	 *            a model element
	 * @param feature
	 *            the feature to be synchronized
	 * 
	 * @return whether the {@code feature} should be synchronized for this {@code element}
	 */
	public boolean isEnabled(EModelElement element, EStructuralFeature feature) {
		boolean result = true;

		String exclusionsList = EcoreUtil.getAnnotation(element, ANNOTATION_SOURCE, ANNOTATION_DETAIL_EXCLUSIONS);
		if (exclusionsList != null) {
			result = !WHITESPACE.splitAsStream(exclusionsList)
					.anyMatch(excl -> feature.getName().equals(excl));
		}

		return result;
	}

	protected void annotate(E element, String featureName) {
		EAnnotation annotation = element.getEAnnotation(ANNOTATION_SOURCE);
		if (annotation == null) {
			annotation = EcoreFactory.eINSTANCE.createEAnnotation();
			annotation.setSource(ANNOTATION_SOURCE);
			annotation.setEModelElement(element);
		}

		Set<String> exclusions;
		String exclusionList = annotation.getDetails().get(ANNOTATION_DETAIL_EXCLUSIONS);
		if (exclusionList == null) {
			exclusionList = ""; //$NON-NLS-1$
			exclusions = new HashSet<>();
		} else {
			exclusions = WHITESPACE.splitAsStream(exclusionList)
					.filter(String::isEmpty)
					.collect(Collectors.toSet());
		}

		if (exclusions.add(featureName)) {
			exclusionList = exclusionList.isEmpty()
					? featureName
					: featureName + " " + exclusionList; //$NON-NLS-1$
			annotation.getDetails().put(ANNOTATION_DETAIL_EXCLUSIONS, exclusionList);
		}
	}

	private static String getFeatureName(Object userData) {
		String result = null;

		if (userData instanceof EStructuralFeature) {
			result = ((EStructuralFeature) userData).getName();
		}

		return result;
	}
}
