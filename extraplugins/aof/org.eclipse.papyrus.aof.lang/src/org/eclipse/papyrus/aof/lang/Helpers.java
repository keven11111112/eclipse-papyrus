/*******************************************************************************
 *  Copyright (c) 2015 ESEO.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Frederic Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.aof.lang;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IUnaryFunction;

/**
 * This class groups static helpers
 *
 * @author Frederic Jouault
 *
 */
public class Helpers {

	/**
	 * Finds an {@link EClass} by its name in the given {@link Resource}.
	 *
	 * @param resource
	 *            the resource to search in.
	 * @param name
	 *            the name of the {@link EClass} to search for.
	 * @return the found {@link EClass} or null if not found.
	 */
	// Possible optimization: add cache, but this should only be called in init phases anyway.
	public static EClass findEClass(Resource resource, String name) {
		for (EObject eo : getAllContents(resource)) {
			if (eo instanceof EClass && ((EClass) eo).getName().equals(name)) {
				return (EClass) eo;
			}
		}
		return null;
	}

	/**
	 * Finds an {@link EEnumLiteral} by its name and the name of its {@link EEnum} in the given {@link Resource}.
	 *
	 * @param resource
	 *            the resource to search in.
	 * @param enumName
	 *            the name of the {@link EEnum} containing the EEnumLiteral to search for.
	 * @param literalName
	 *            the name of the {@link EEnumLiteral} to search for.
	 * @return the found {@link EEnumLiteral} or null if not found.
	 */
	public static EEnumLiteral findEnumLiteral(Resource resource, String enumName, String literalName) {
		for (EObject eo : getAllContents(resource)) {
			if (eo instanceof EEnum && ((EEnum) eo).getName().equals(enumName)) {
				return ((EEnum) eo).getEEnumLiteralByLiteral(literalName);
			}
		}
		return null;
	}

	protected static Iterable<EObject> getAllContents(final Resource resource) {
		return new Iterable<EObject>() {
			@Override
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
	}

	/**
	 * A {@link ValueMapping} is a bidirectional mapping used to create both a collector
	 * and a reverseCollector for use with {@link IBox#collect(IUnaryFunction, IUnaryFunction)}
	 * from a value mapping table.
	 *
	 * In the collector, left values are mapped into right values.
	 * In the reverseCollector, right values are mapped into left values.
	 *
	 * @author Frederic Jouault
	 *
	 * @param <L>
	 *            the type of left elements.
	 * @param <R>
	 *            the type of right elements
	 */
	public static class ValueMapping<L, R> {
		private Map<L, R> forwardMappings = new HashMap<L, R>();
		private Map<R, L> reverseMappings = new HashMap<R, L>();
		private L forwardDefault = null;
		private R reverseDefault = null;

		/**
		 * Adds the given values to the mapping.
		 *
		 * @param left
		 *            the left value to map to the given right value.
		 * @param right
		 *            the right value to map to the given left value.
		 */
		public void put(L left, R right) {
			forwardMappings.put(left, right);
			reverseMappings.put(right, left);
		}

		/**
		 * The collector mapping left values into right values.
		 * It returns the default right value if no mapping is found for the given left value.
		 */
		public final IUnaryFunction<L, R> forward = new IUnaryFunction<L, R>() {
			@Override
			public R apply(L parameter) {
				R ret = forwardMappings.get(parameter);
				if (ret == null) {
					ret = reverseDefault;
				}
				return ret;
			}
		};

		/**
		 * The reverse collector mapping right values into left values.
		 * It returns the default left value if no mapping is found for the given right value.
		 */
		public final IUnaryFunction<R, L> reverse = new IUnaryFunction<R, L>() {
			@Override
			public L apply(R parameter) {
				L ret = reverseMappings.get(parameter);
				if (ret == null) {
					ret = forwardDefault;
				}
				return ret;
			}
		};

		/**
		 * Sets the left and right default values.
		 *
		 * @param leftDefault
		 * @param rightDefault
		 */
		public void setDefault(L leftDefault, R rightDefault) {
			this.forwardDefault = leftDefault;
			this.reverseDefault = rightDefault;
		}
	}
}
