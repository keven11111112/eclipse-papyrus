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

package org.eclipse.papyrus.aof.sync.examples.uml.internal;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.aof.sync.ISyncCorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.ISyncMapping;
import org.eclipse.papyrus.aof.sync.emf.EMFMappingModule;
import org.eclipse.papyrus.aof.sync.examples.uml.internal.mappings.CapsuleMapping;
import org.eclipse.papyrus.aof.sync.examples.uml.internal.mappings.RegionMapping;
import org.eclipse.papyrus.aof.sync.examples.uml.internal.mappings.StateMachineMapping;
import org.eclipse.papyrus.aof.sync.examples.uml.internal.mappings.TransitionMapping;
import org.eclipse.papyrus.aof.sync.examples.uml.internal.mappings.VertexMapping;
import org.eclipse.papyrus.aof.sync.examples.uml.internal.util.RedefinitionUtil;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.util.UMLSwitch;

import com.google.inject.Provides;

/**
 * Guice mapping module for configuration of capsule semantic model (esp. state machine)
 * mappings, inspired by UML-RT.
 */
public class UMLRTMappingModule extends EMFMappingModule {
	private final Provider<EditingDomain> editingDomain;

	public UMLRTMappingModule() {
		this(() -> null);
	}

	public UMLRTMappingModule(Provider<EditingDomain> editingDomain) {
		super();

		this.editingDomain = editingDomain;
	}

	@Override
	public Provider<? extends EditingDomain> getEditingDomainBinding() {
		return editingDomain;
	}

	public java.lang.Class<? extends ISyncMapping<Class>> getCapsuleMappingBinding() {
		return CapsuleMapping.class;
	}

	public java.lang.Class<? extends ISyncMapping<StateMachine>> getStateMachineMappingBinding() {
		return StateMachineMapping.class;
	}

	public java.lang.Class<? extends ISyncMapping<Region>> getRegionMappingBinding() {
		return RegionMapping.class;
	}

	public java.lang.Class<? extends ISyncMapping<Vertex>> getVertexMappingBinding() {
		return VertexMapping.class;
	}

	public java.lang.Class<? extends ISyncMapping<Transition>> getTransitionMappingBinding() {
		return TransitionMapping.class;
	}

	@Provides
	public ISyncCorrespondenceResolver<Behavior, BehavioredClassifier> provideBehaviorRedefResolver() {
		return RedefinitionUtil::getRedefiningBehavior;
	}

	@Provides
	public ISyncCorrespondenceResolver<Region, StateMachine> provideRegionRedefResolver() {
		return RedefinitionUtil::getRedefiningRegion;
	}

	@Provides
	public ISyncCorrespondenceResolver<Region, State> provideCompositeStateRegionRedefResolver() {
		return RedefinitionUtil::getRedefiningCompositeStateRegion;
	}

	@Provides
	public ISyncCorrespondenceResolver<Vertex, Region> provideVertexRedefResolver() {
		return RedefinitionUtil::getRedefiningVertex;
	}

	@Provides
	public ISyncCorrespondenceResolver<Transition, Region> provideTransitionRedefResolver() {
		return RedefinitionUtil::getRedefiningTransition;
	}

	@Provides
	public ISyncCorrespondenceResolver<Vertex, Transition> provideTransitionEndRedefResolver() {
		return RedefinitionUtil::getRedefiningEnd;
	}

	public java.lang.Class<? extends ISyncCorrespondenceResolver<EObject, EObject>> getRedefResolverBinding() {
		return CorrespondenceResolverSwitch.class;
	}

	/**
	 * This is used to resolve the matching transition when mapping the notation of a diagram.
	 */
	@Provides
	public ISyncCorrespondenceResolver<Transition, StateMachine> provideTransitionInStatemachineRedefResolver() {
		return RedefinitionUtil::getRedefiningTransition;
	}

	//
	// Nested types
	//

	private static class CorrespondenceResolverSwitch implements ISyncCorrespondenceResolver<EObject, EObject> {
		@Inject
		private ISyncCorrespondenceResolver<Behavior, BehavioredClassifier> behavior;

		@Inject
		private ISyncCorrespondenceResolver<Region, StateMachine> region;

		@Inject
		private ISyncCorrespondenceResolver<Region, State> compositeStateRegion;

		@Inject
		private ISyncCorrespondenceResolver<Vertex, Region> vertex;

		@Inject
		private ISyncCorrespondenceResolver<Transition, Region> transition;

		@Inject
		private ISyncCorrespondenceResolver<Vertex, Transition> transitionEnd;

		@Inject
		private ISyncCorrespondenceResolver<Transition, StateMachine> transitionInStateMachine;

		@Override
		public EObject getCorrespondent(EObject element, EObject parentContext) {

			return new UMLSwitch<EObject>() {
				@Override
				public EObject defaultCase(EObject object) {
					return object;
				}

				@Override
				public EObject caseBehavior(Behavior object) {
					BehavioredClassifier context = (parentContext instanceof Behavior)
							? ((Behavior) parentContext).getContext()
							: (BehavioredClassifier) parentContext;
					return behavior.getCorrespondent(object, context);
				}

				@Override
				public EObject caseRegion(Region object) {
					return new UMLSwitch<Optional<Region>>() {
						@Override
						public Optional<Region> caseStateMachine(StateMachine machine) {
							return Optional.ofNullable(region.getCorrespondent(object, machine));
						}

						@Override
						public Optional<Region> caseState(State state) {
							return Optional.ofNullable(compositeStateRegion.getCorrespondent(object, state));
						}

						@Override
						public Optional<Region> caseRegion(Region region) {
							return doSwitch(region.eContainer());
						}
					}.doSwitch(parentContext).orElse(null);
				}

				@Override
				public EObject caseVertex(Vertex object) {
					return new UMLSwitch<Optional<Vertex>>() {
						@Override
						public Optional<Vertex> caseRegion(Region region) {
							return Optional.ofNullable(vertex.getCorrespondent(object, region));
						}

						@Override
						public Optional<Vertex> caseTransition(Transition transition) {
							return Optional.ofNullable(transitionEnd.getCorrespondent(object, transition));
						}

						@Override
						public Optional<Vertex> caseVertex(Vertex vertex) {
							return doSwitch(vertex.getContainer());
						}
					}.doSwitch(parentContext).orElse(null);
				}

				@Override
				public EObject caseTransition(Transition object) {
					if (parentContext instanceof StateMachine) {
						return transitionInStateMachine.getCorrespondent(object, (StateMachine) parentContext);
					} else {
						Region context = (parentContext instanceof Transition)
								? ((Transition) parentContext).getContainer()
								: (Region) parentContext;
						return transition.getCorrespondent(object, context);
					}
				}
			}.doSwitch(element);
		}
	};
}
