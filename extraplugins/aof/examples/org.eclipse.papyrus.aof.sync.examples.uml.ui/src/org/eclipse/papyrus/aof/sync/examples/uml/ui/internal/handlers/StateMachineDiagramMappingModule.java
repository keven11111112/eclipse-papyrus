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

package org.eclipse.papyrus.aof.sync.examples.uml.ui.internal.handlers;

import static org.eclipse.papyrus.aof.gmf.util.ViewUtil.SEMANTIC_CORRESPONDENCE;

import java.util.function.BiPredicate;

import javax.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.gmf.DiagramFactory;
import org.eclipse.papyrus.aof.sync.ISyncCorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.examples.uml.internal.util.RedefinitionUtil;
import org.eclipse.papyrus.aof.sync.gmf.DiagramMappingFactory;
import org.eclipse.papyrus.aof.sync.gmf.DiagramMappingModule;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

/**
 * A Guice configuration module that overrides a few significant bindings provided
 * by the {@link DiagramMappingModule} for the {@link DiagramMappingFactory} to
 * implement the special redefinition-correspondence semantics in UML-RT style
 * state machines.
 */
public class StateMachineDiagramMappingModule extends AbstractModule {

	public StateMachineDiagramMappingModule() {
		super();
	}

	@Override
	protected void configure() {
		// All bindings are by provider methods
	}

	@Provides
	public IFactory provideFactory() {
		return DiagramFactory.INSTANCE;
	}

	/**
	 * Provide a correspondence resolver that associates not views of the same element but views
	 * of elements in a redefinition relationship.
	 */
	@Provides
	public ISyncCorrespondenceResolver<EObject, View> provideVisualCorrespondence(ISyncCorrespondenceResolver<EObject, EObject> semanticCorrespondence) {
		return new ISyncCorrespondenceResolver<EObject, View>() {
			private ISyncCorrespondenceResolver<EObject, EObject> correspondence = semanticCorrespondence.cached();

			@Override
			public EObject getCorrespondent(EObject element, View parentContext) {
				EObject result;

				if ((element != null) && isInStateMachineDiagram(parentContext)) {
					result = correspondence.getCorrespondent(element, parentContext.getElement());
				} else {
					// Regular diagrams
					result = element;
				}

				return result;
			}
		};
	}

	/**
	 * Provide a semantic correspondence predicate that (in state machine diagram context) tests for
	 * redefinition relationship, not identity, of the semantic elements of views.
	 */
	@Provides
	@Named(SEMANTIC_CORRESPONDENCE)
	public BiPredicate<EObject, EObject> provideSemanticCorrespondencePredicate() {
		return new BiPredicate<EObject, EObject>() {
			@Override
			public boolean test(EObject t, EObject u) {
				boolean isStateMachineDiagram = false;
				if (t instanceof View) {
					View view = (View) t;
					isStateMachineDiagram = isInStateMachineDiagram(view);
					t = view.getElement();
				}
				if (u instanceof View) {
					View view = (View) u;
					isStateMachineDiagram = isStateMachineDiagram || isInStateMachineDiagram(view);
					u = view.getElement();
				}

				return isStateMachineDiagram
						? RedefinitionUtil.redefines(t, u) || RedefinitionUtil.redefines(u, t)
						: t == u;
			}
		};
	}

	static boolean isInStateMachineDiagram(View view) {
		return "PapyrusUMLStateMachineDiagram".equals(getDiagramType(view));
	}

	static String getDiagramType(View view) {
		String result = null;

		Diagram diagram = view.getDiagram();
		if (diagram != null) {
			result = diagram.getType();
		}

		return result;
	}
}
