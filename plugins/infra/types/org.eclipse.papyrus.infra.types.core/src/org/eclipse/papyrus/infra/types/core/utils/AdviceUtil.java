/*****************************************************************************
 * Copyright (c) 2017 EclipseSource and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   EclipseSource - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.infra.types.core.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.papyrus.infra.types.core.registries.ElementTypeSetConfigurationRegistry;

/**
 * @since 3.1
 */
public class AdviceUtil {

	/**
	 * Sorts the advices, taking dependencies of the specified element types into account
	 * @param advices
	 * @param types
	 * @param contextId
	 * @return
	 */
	public static IEditHelperAdvice[] sort(final IEditHelperAdvice[] advices, IElementType[] types, String contextId) {
		List<OrientedGraph<String>> dependencies = new ArrayList<OrientedGraph<String>>();

		for (IElementType iElementType : types) {
			dependencies.add(ElementTypeSetConfigurationRegistry.getInstance().getAdvicesDeps(iElementType.getId(), contextId));
		}

		return sort(advices, dependencies);
	}

	public static IEditHelperAdvice[] sort(IEditHelperAdvice[] advices, IElementType elementType, String contextId) {
		IElementType[] supertypes = elementType.getAllSuperTypes();
		IElementType[] allTypes = Arrays.copyOf(supertypes, supertypes.length + 1);
		allTypes[supertypes.length] = elementType;
		return sort(advices, allTypes, contextId);
	}

	private static IEditHelperAdvice[] sort(IEditHelperAdvice[] advices, Collection<OrientedGraph<String>> dependencies) {
		OrientedGraph<String> graph = mergeGraph(dependencies);
		if (graph == null) { // No dependencies
			return advices;
		}

		LinkedHashSet<IEditHelperAdvice> sortedAdvices = new LinkedHashSet<>();
		Map<String, IEditHelperAdvice> idToAdvice = Arrays.stream(advices).collect(Collectors.toMap(a -> a.getClass().getName(), a -> a));

		for (IEditHelperAdvice advice : advices) {
			collectSortedDependencies(advice.getClass().getName(), graph, idToAdvice, sortedAdvices);
		}

		return sortedAdvices.toArray(advices);
	}

	private static void collectSortedDependencies(String adviceName, OrientedGraph<String> dependencies, Map<String, IEditHelperAdvice> idToAdvice,
			LinkedHashSet<IEditHelperAdvice> result) {

		IEditHelperAdvice advice = idToAdvice.get(adviceName);
		if (advice != null && result.contains(advice)) {
			return;
		}

		Set<String> allDependencies = dependencies.getAllConnex(adviceName);
		for (String dependency : allDependencies) {
			collectSortedDependencies(dependency, dependencies, idToAdvice, result);
		}

		if (advice != null) {
			result.add(advice);
		}
	}

	private static <T> OrientedGraph<T> mergeGraph(Collection<OrientedGraph<T>> graphs) {
		OrientedGraph<T> result = null;
		for (OrientedGraph<T> graph : graphs) {
			if (result == null) {
				result = graph;
				continue;
			}

			for (Map.Entry<T, Set<T>> edge : graph.getEdges().entrySet()) {
				T source = edge.getKey();
				for (T target : edge.getValue()) {
					result.addEdge(source, target);
				}
			}
		}
		return result;
	}

}
