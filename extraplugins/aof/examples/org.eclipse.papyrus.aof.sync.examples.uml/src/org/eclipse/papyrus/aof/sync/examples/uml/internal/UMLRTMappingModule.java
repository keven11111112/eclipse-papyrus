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

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.emf.EMFFactory;
import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.MappingModule;
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
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.util.UMLSwitch;

import com.google.inject.Provides;

/**
 * Guice mapping module for configuration of capsule semantic model (esp. state machine)
 * mappings, inspired by UML-RT.
 */
public class UMLRTMappingModule extends MappingModule {

	@Override
	public IFactory provideFactory() {
		return EMFFactory.INSTANCE;
	}

	public java.lang.Class<? extends IMapping<Class>> getCapsuleMappingBinding() {
		return CapsuleMapping.class;
	}

	public java.lang.Class<? extends IMapping<StateMachine>> getStateMachineMappingBinding() {
		return StateMachineMapping.class;
	}

	public java.lang.Class<? extends IMapping<Region>> getRegionMappingBinding() {
		return RegionMapping.class;
	}

	public java.lang.Class<? extends IMapping<Vertex>> getVertexMappingBinding() {
		return VertexMapping.class;
	}

	public java.lang.Class<? extends IMapping<Transition>> getTransitionMappingBinding() {
		return TransitionMapping.class;
	}

	@Provides
	public ICorrespondenceResolver<Behavior, BehavioredClassifier> provideBehaviorRedefResolver() {
		return RedefinitionUtil::getRedefiningBehavior;
	}

	@Provides
	public ICorrespondenceResolver<Region, StateMachine> provideRegionRedefResolver() {
		return RedefinitionUtil::getRedefiningRegion;
	}

	@Provides
	public ICorrespondenceResolver<Vertex, Region> provideVertexRedefResolver() {
		return RedefinitionUtil::getRedefiningVertex;
	}

	@Provides
	public ICorrespondenceResolver<Transition, Region> provideTransitionRedefResolver() {
		return RedefinitionUtil::getRedefiningTransition;
	}

	public java.lang.Class<? extends ICorrespondenceResolver<EObject, EObject>> getRedefResolverBinding() {
		return CorrespondenceResolverSwitch.class;
	}

	/**
	 * This is used to resolve the matching transition when mapping the notation of a diagram.
	 */
	@Provides
	public ICorrespondenceResolver<Transition, StateMachine> provideTransitionInStatemachineRedefResolver() {
		return RedefinitionUtil::getRedefiningTransition;
	}

	//
	// Nested types
	//

	private static class CorrespondenceResolverSwitch implements ICorrespondenceResolver<EObject, EObject> {
		@Inject
		private ICorrespondenceResolver<Behavior, BehavioredClassifier> behavior;

		@Inject
		private ICorrespondenceResolver<Region, StateMachine> region;

		@Inject
		private ICorrespondenceResolver<Vertex, Region> vertex;

		@Inject
		private ICorrespondenceResolver<Transition, Region> transition;

		@Inject
		private ICorrespondenceResolver<Transition, StateMachine> transitionInStateMachine;

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
					StateMachine context = (parentContext instanceof Region)
							? ((Region) parentContext).getStateMachine()
							: (StateMachine) parentContext;
					return region.getCorrespondent(object, context);
				}

				@Override
				public EObject caseVertex(Vertex object) {
					Region context = (parentContext instanceof Vertex)
							? ((Vertex) parentContext).getContainer()
							: (Region) parentContext;
					return vertex.getCorrespondent(object, context);
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
