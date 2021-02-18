/*****************************************************************************
 * Copyright (c) 2021 Christian W. Damus, CEA LIST, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.architecture.util;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.architecture.ADElement;
import org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage;
import org.eclipse.papyrus.infra.core.architecture.impl.ArchitecturePlugin;
import org.eclipse.papyrus.infra.tools.util.ClasspathHelper;
import org.osgi.framework.Bundle;

/**
 * Utilities for working with/resolving the command classes referenced by
 * <em>Architecture Models</em>.
 */
public class ArchitectureCommandUtils {

	private static final String CLASS_CONSTRAINT = "classConstraint"; //$NON-NLS-1$
	private static final String BUNDLECLASS = "bundleclass"; //$NON-NLS-1$

	private static final Map<EStructuralFeature, Class<?>> commandClassConstraints = new ConcurrentHashMap<>();

	/**
	 * Obtain the type constraining command classes referenced by the given feature.
	 *
	 * @param commandClassFeature
	 *            the model feature that names a command class
	 * @return the type to which command classes named by the feature must conform
	 */
	public static Optional<Class<?>> getCommandType(EStructuralFeature commandClassFeature) {
		return Optional.ofNullable(commandClassConstraints.computeIfAbsent(commandClassFeature, ArchitectureCommandUtils::loadClassAnnotation));
	}

	private static Class<?> loadClassAnnotation(EStructuralFeature feature) {
		Class<?> result = null;

		String classURI = EcoreUtil.getAnnotation(feature, ArchitecturePackage.eNS_URI, CLASS_CONSTRAINT);
		if (classURI != null) {
			URI uri = URI.createURI(classURI);
			if (!BUNDLECLASS.equals(uri.scheme())) {
				result = fail("Constraint class URI does not have bundleclass scheme: " + uri); //$NON-NLS-1$
			} else if (uri.authority() == null) {
				result = fail("Constraint class URI does not have an authority: " + uri); //$NON-NLS-1$
			} else if (uri.segmentCount() != 1) {
				result = fail("Constraint class URI must have exactly one segment: " + uri); //$NON-NLS-1$
			} else {
				Bundle bundle = Platform.getBundle(uri.authority());
				if (bundle == null) {
					result = fail("No such bundle in constraint class URI: " + uri); //$NON-NLS-1$
				} else {
					try {
						result = bundle.loadClass(uri.segment(0));
					} catch (Exception e) {
						result = fail(e);
					}
				}
			}
		}

		return result;
	}

	private static Class<?> fail(String message) {
		return fail(new IllegalArgumentException(message));
	}

	private static Class<?> fail(Throwable exception) {
		ArchitecturePlugin.INSTANCE.log(exception);
		return Void.class; // Bomb the usage of this class-name feature
	}

	/**
	 * Get the command class referenced by the given feature of an architecture model object.
	 *
	 * @param modelObject
	 *            the architecture model object for which to load a command class
	 * @param commandClassFeature
	 *            the model feature that names the command class
	 * @return
	 *         the referenced class, or {@code null} if the class doesn't exist or is invalid
	 *         (such as not conforming to its constraining type). In such a case, the
	 *         exception is logged. The result may be a Java {@link Class} or a JDT
	 *         {@code IType}, depending whether JDT is available
	 */
	public static Object getCommandClass(EObject modelObject, EStructuralFeature commandClassFeature) {
		if (commandClassFeature.getEType().getInstanceClass() == Class.class) {
			// Easy
			return modelObject.eGet(commandClassFeature);
		}

		String className = Optional.ofNullable(modelObject.eGet(commandClassFeature)).map(String::valueOf).orElse(null);
		if (className == null) {
			// Easy
			return null;
		}

		Optional<Class<?>> registeredType = getCommandType(commandClassFeature);
		URI context = getSourceURI(modelObject, commandClassFeature).trimFragment();

		return ClasspathHelper.INSTANCE.findClass(className, context, registeredType.orElse(null));
	}

	/**
	 * Get the URI of the object that is the source (via architecture model merge) of the value of the given
	 * command class feature.
	 *
	 * @param object
	 *            an architecture model element
	 * @param commandClassFeature
	 *            the command class feature to trace to the source
	 * @return the URI of the source object
	 */
	private static URI getSourceURI(EObject object, EStructuralFeature commandClassFeature) {
		URI result;

		if (!(object instanceof ADElement)) {
			// It wasn't merged, so it is its own source object (referenced directly wherever it is)
			result = EcoreUtil.getURI(object);
		} else {
			ADElement element = (ADElement) object;
			MergeTraceAdapter traces = MergeTraceAdapter.getMergeTraces(element);

			ADElement source = traces == null ? element : traces.trace(element, commandClassFeature);

			result = source == null
					? EcoreUtil.getURI(element) // Hope for the best
					: EcoreUtil.getURI(source);
		}

		return result;
	}

}
