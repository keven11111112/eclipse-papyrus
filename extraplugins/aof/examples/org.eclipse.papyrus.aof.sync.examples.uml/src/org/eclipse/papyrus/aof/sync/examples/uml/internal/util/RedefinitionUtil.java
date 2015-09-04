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

package org.eclipse.papyrus.aof.sync.examples.uml.internal.util;

import static org.eclipse.papyrus.aof.sync.examples.uml.internal.util.NamedElements.shallowCopy;

import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.RedefinableElement;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;

/**
 * Static utilities for resolving the redefining element of some element in a given context.
 */
public class RedefinitionUtil {
	private RedefinitionUtil() {
		super();
	}

	/**
	 * Finds the behavior in a given {@code context} that redefines the specified {@code behavior},
	 * or creates a new one if it doesn't yet exist.
	 */
	public static Behavior getRedefiningBehavior(Behavior behavior, BehavioredClassifier context) {
		// This is the reference that is actually stored and read from serialization
		return getInverseReferencers(behavior, UMLPackage.Literals.STATE_MACHINE__EXTENDED_STATE_MACHINE, Behavior.class)
				.filter(b -> b.getContext() == context)
				.findFirst().orElseGet(() -> shallowCopy(behavior));
	}

	private static <T extends EObject> Stream<T> getInverseReferencers(EObject object, EReference reference, Class<T> type) {
		return ECrossReferenceAdapter.getCrossReferenceAdapter(object).getInverseReferences(object).stream()
				.filter(s -> (s.getEStructuralFeature() == reference) && type.isInstance(s.getEObject()))
				.map(s -> type.cast(s.getEObject()));
	}

	/**
	 * Finds the region in a given {@code context} that redefines the specified {@code region},
	 * or creates a new one if it doesn't yet exist.
	 */
	public static Region getRedefiningRegion(Region region, StateMachine context) {
		return getInverseReferencers(region, UMLPackage.Literals.REGION__EXTENDED_REGION, Region.class)
				.filter(r -> r.getStateMachine() == context)
				.findFirst().orElseGet(() -> shallowCopy(region));
	}

	/**
	 * Finds the state in a given {@code context} that redefines the specified {@code state},
	 * or creates a new one if it doesn't yet exist.
	 */
	public static State getRedefiningState(State state, Region context) {
		return getInverseReferencers(state, UMLPackage.Literals.STATE__REDEFINED_STATE, State.class)
				.filter(s -> s.getContainer() == context)
				.findFirst().orElseGet(() -> shallowCopy(state));
	}

	/**
	 * Finds the vertex in a given {@code context} that redefines the specified {@code vertex},
	 * or creates a new one if it doesn't yet exist.
	 */
	public static <V extends Vertex> V getRedefiningVertex(V vertex, Region context) {
		@SuppressWarnings("unchecked")
		final Class<V> type = (Class<V>) vertex.getClass();

		V result;

		if (vertex instanceof State) {
			result = type.cast(getRedefiningState((State) vertex, context));
		} else {
			result = context.getSubvertices().stream()
					.filter(type::isInstance).map(type::cast)
					.filter(v -> Objects.equals(v.getName(), vertex.getName()) && v.eClass() == vertex.eClass())
					.findFirst().orElseGet(() -> shallowCopy(vertex));
		}

		return result;
	}

	/**
	 * Finds the transition in a given {@code context} that redefines the specified {@code transition},
	 * or creates a new one if it doesn't yet exist.
	 */
	public static Transition getRedefiningTransition(Transition transition, Region context) {
		return getInverseReferencers(transition, UMLPackage.Literals.TRANSITION__REDEFINED_TRANSITION, Transition.class)
				.filter(t -> t.getContainer() == context)
				.findFirst().orElseGet(() -> shallowCopy(transition));
	}

	/**
	 * This is used to resolve the matching transition when mapping the notation of a diagram.
	 * Does not create new transitions: the correspnoding transition element is expected to exist, already
	 * (notation mappings naturally fire after semantic mappings).
	 */
	public static Transition getRedefiningTransition(Transition transition, StateMachine context) {
		return getInverseReferencers(transition, UMLPackage.Literals.TRANSITION__REDEFINED_TRANSITION, Transition.class)
				.filter(t -> t.containingStateMachine() == context)
				.findFirst().orElse(null);
	}

	/**
	 * Queries whether two elements are in a redefinition relationship.
	 * 
	 * @return whether {@code element} redefines {@code other}, or vice versa
	 */
	public static boolean redefines(EObject element, EObject other) {
		boolean result = false;

		if ((element instanceof RedefinableElement) && (other instanceof RedefinableElement)) {
			result = ((RedefinableElement) element).getRedefinedElements().contains(other);
		} else if ((element instanceof Vertex) && (other instanceof Vertex)) {
			Vertex v1 = (Vertex) element;
			Vertex v2 = (Vertex) other;

			// Pseudostates correspond by name
			result = redefines(v1.getContainer(), v2.getContainer())
					&& Objects.equals(v1.getName(), v2.getName());
		}

		return result;
	}
}
