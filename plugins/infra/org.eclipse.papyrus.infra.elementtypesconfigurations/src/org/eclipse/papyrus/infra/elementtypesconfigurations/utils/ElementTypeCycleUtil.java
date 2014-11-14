package org.eclipse.papyrus.infra.elementtypesconfigurations.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration;

//Implements Tarjan's strongly connected components algorithm
public class ElementTypeCycleUtil {


	protected static Collection<Collection<String>> computeStronglyConnectedComponents(Set<String> vertices, Map<String, List<String>> edges) {
		int index = 0;
		Map<String, Integer> lowIndex = new HashMap<String, Integer>();
		Collection<String> visitedVertices = new HashSet<String>();
		Stack<String> stack = new Stack<String>();
		Collection<Collection<String>> stronglyConnnectedComponents = new ArrayList<Collection<String>>();

		for (String vertex : vertices) {
			if (!visitedVertices.contains(vertex))
				dfs(vertex, vertices, edges, stronglyConnnectedComponents, stack, lowIndex, visitedVertices, index);
		}

		return stronglyConnnectedComponents;
	}


	protected static void dfs(String vertex, Set<String> vertices, Map<String, List<String>> edges, Collection<Collection<String>> stronglyConnnectedComponents, Stack<String> stack, Map<String, Integer> lowIndex, Collection<String> visitedVertices, int index)
	{
		lowIndex.put(vertex, index++);
		visitedVertices.add(vertex);
		stack.push(vertex);
		int minIndex = lowIndex.get(vertex);
		for (String targetVertex : edges.get(vertex))
		{
			if (!visitedVertices.contains(targetVertex))
				dfs(targetVertex, vertices, edges, stronglyConnnectedComponents, stack, lowIndex, visitedVertices, index);
			if (lowIndex.get(targetVertex) < minIndex)
				minIndex = lowIndex.get(targetVertex);
		}
		if (minIndex < lowIndex.get(vertex))
		{
			lowIndex.put(vertex, minIndex);
			return;
		}
		List<String> component = new ArrayList<String>();
		String memberVertex;
		do
		{
			memberVertex = stack.pop();
			component.add(memberVertex);
			lowIndex.put(memberVertex, vertices.size());
		} while (!memberVertex.equals(vertex));

		if (component.size() > 1) {
			stronglyConnnectedComponents.add(component);
		}
	}

	static public Collection<Collection<String>> getCycles(Collection<ElementTypeConfiguration> elementTypesConfigurations) {
		Map<String, List<String>> edges = new HashMap<String, List<String>>();
		Set<String> vertices = new HashSet<String>();

		for (ElementTypeConfiguration elementTypeConfiguration : elementTypesConfigurations) {
			String currentElementTypeID = elementTypeConfiguration.getIdentifier();

			// Add current to the vertices
			vertices.add(currentElementTypeID);

			// Add dependencies vertices
			if (elementTypeConfiguration instanceof SpecializationTypeConfiguration) {
				for (String specializedTypeID : ((SpecializationTypeConfiguration) elementTypeConfiguration).getSpecializedTypesID()) {
					vertices.add(specializedTypeID);
					if (edges.get(specializedTypeID) == null) {
						edges.put(specializedTypeID, new ArrayList<String>());
					}
				}
				edges.put(currentElementTypeID, ((SpecializationTypeConfiguration) elementTypeConfiguration).getSpecializedTypesID());
			} else {
				edges.put(currentElementTypeID, Collections.<String> emptyList());
			}
		}

		return computeStronglyConnectedComponents(vertices, edges);
	}
}
