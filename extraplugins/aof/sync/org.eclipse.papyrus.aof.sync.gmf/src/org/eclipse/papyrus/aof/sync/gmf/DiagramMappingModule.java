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

package org.eclipse.papyrus.aof.sync.gmf;

import static org.eclipse.papyrus.aof.gmf.util.ViewUtil.SEMANTIC_CORRESPONDENCE;

import java.util.function.BiPredicate;

import javax.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.gmf.DiagramFactory;
import org.eclipse.papyrus.aof.gmf.util.ViewUtil;
import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.MappingModule;
import org.eclipse.papyrus.aof.sync.gmf.internal.DiagramMapping;
import org.eclipse.papyrus.aof.sync.gmf.internal.EdgeMapping;
import org.eclipse.papyrus.aof.sync.gmf.internal.LocationMapping;
import org.eclipse.papyrus.aof.sync.gmf.internal.NodeMapping;
import org.eclipse.papyrus.aof.sync.gmf.internal.SizeMapping;

import com.google.inject.Provides;

/**
 * Guice module for configuration of diagram mappings.
 */
public class DiagramMappingModule extends MappingModule {
	public DiagramMappingModule() {
		super();
	}

	@Override
	public IFactory provideFactory() {
		return DiagramFactory.INSTANCE;
	}

	public Class<? extends IMapping<Diagram>> getDiagramMappingBinding() {
		return DiagramMapping.class;
	}

	public Class<? extends IMapping<Node>> getNodeMappingBinding() {
		return NodeMapping.class;
	}

	public Class<? extends IMapping<Edge>> getEdgeMappingBinding() {
		return EdgeMapping.class;
	}

	public Class<? extends IMapping<Location>> getLocationMappingBinding() {
		return LocationMapping.class;
	}

	public Class<? extends IMapping<Size>> getSizeMappingBinding() {
		return SizeMapping.class;
	}

	@Provides
	public ICorrespondenceResolver<Node, View> provideNodeResolver(ViewUtil viewUtil) {
		return viewUtil::getCorrespondingNode;
	}

	@Provides
	public ICorrespondenceResolver<Edge, Diagram> provideEdgeResolver(ViewUtil viewUtil) {
		return viewUtil::getCorrespondingEdge;
	}

	@Provides
	public ICorrespondenceResolver<Node, Edge> provideEndPointResolver(ViewUtil viewUtil) {
		return viewUtil::getCorrespondingEndpoint;
	}

	@Provides
	public ICorrespondenceResolver<Location, Node> provideLocationResolver(ViewUtil viewUtil) {
		return viewUtil::getCorrespondingLayoutConstraint;
	}

	@Provides
	public ICorrespondenceResolver<Size, Node> provideSizeResolver(ViewUtil viewUtil) {
		return viewUtil::getCorrespondingLayoutConstraint;
	}

	@Provides
	public ICorrespondenceResolver<EObject, EObject> provideSemanticCorrespondence() {
		return (element, inParent) -> element;
	}

	/**
	 * Provides the visual correspondence resolver, which depends on resolution of semantic-element correspondence.
	 * 
	 * @param semanticCorrespondence
	 *            the semantic-element correspondence resolver that may be used in
	 *            calculation of visual correspondence
	 * 
	 * @return the visual correspondence resolver
	 */
	@Provides
	public ICorrespondenceResolver<EObject, View> provideVisualCorrespondence(ICorrespondenceResolver<EObject, EObject> semanticCorrespondence) {
		return (element, inParent) -> element;
	}

	/**
	 * Provides the semantic-element correspondence predicate required by the {@link ViewUtil}.
	 * 
	 * @return the semantic-element correspondence predicate
	 * 
	 * @see ViewUtil#getSemanticCorrespondence()
	 */
	@Provides
	@Named(SEMANTIC_CORRESPONDENCE)
	public BiPredicate<EObject, EObject> provideSemanticCorrespondencePredicate() {
		return (element, other) -> {
			if (element instanceof View) {
				element = ((View) element).getElement();
			}
			if (other instanceof View) {
				other = ((View) other).getElement();
			}

			return element == other;
		};
	}
}
