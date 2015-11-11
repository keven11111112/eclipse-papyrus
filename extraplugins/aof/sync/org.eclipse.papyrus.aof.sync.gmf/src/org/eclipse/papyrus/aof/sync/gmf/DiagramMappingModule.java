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

import java.util.Collections;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.gmf.DiagramFactory;
import org.eclipse.papyrus.aof.gmf.util.ViewUtil;
import org.eclipse.papyrus.aof.sync.AutoDisableHook;
import org.eclipse.papyrus.aof.sync.IMappingContext;
import org.eclipse.papyrus.aof.sync.IMappingInstance;
import org.eclipse.papyrus.aof.sync.ISyncCorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.ISyncMapping;
import org.eclipse.papyrus.aof.sync.emf.EMFMappingModule;
import org.eclipse.papyrus.aof.sync.gmf.internal.DiagramMapping;
import org.eclipse.papyrus.aof.sync.gmf.internal.EdgeMapping;
import org.eclipse.papyrus.aof.sync.gmf.internal.LocationMapping;
import org.eclipse.papyrus.aof.sync.gmf.internal.NodeMapping;
import org.eclipse.papyrus.aof.sync.gmf.internal.SizeMapping;
import org.eclipse.papyrus.aof.sync.gmf.internal.StyleMapping;
import org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncExclusion;
import org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncStyle;
import org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncStylesPackage;

import com.google.inject.Provides;

/**
 * Guice module for configuration of diagram mappings.
 */
public class DiagramMappingModule extends EMFMappingModule {
	private final Provider<EditingDomain> editingDomain;

	public DiagramMappingModule() {
		this(() -> null);
	}

	public DiagramMappingModule(Provider<EditingDomain> editingDomain) {
		super();

		this.editingDomain = editingDomain;
	}

	@Override
	protected IFactory getDefaultFactory() {
		return DiagramFactory.INSTANCE;
	}

	@Override
	public Provider<? extends EditingDomain> getEditingDomainBinding() {
		return editingDomain;
	}

	public Class<? extends ISyncMapping<Diagram>> getDiagramMappingBinding() {
		return DiagramMapping.class;
	}

	public Class<? extends ISyncMapping<Node>> getNodeMappingBinding() {
		return NodeMapping.class;
	}

	public Class<? extends ISyncMapping<Edge>> getEdgeMappingBinding() {
		return EdgeMapping.class;
	}

	public Class<? extends ISyncMapping<Location>> getLocationMappingBinding() {
		return LocationMapping.class;
	}

	public Class<? extends ISyncMapping<Size>> getSizeMappingBinding() {
		return SizeMapping.class;
	}

	public Class<? extends ISyncMapping<Style>> getStyleMappingBinding() {
		return StyleMapping.class;
	}

	@Provides
	public ISyncCorrespondenceResolver<Node, View> provideNodeResolver(ViewUtil viewUtil) {
		return viewUtil::getCorrespondingNode;
	}

	@Provides
	public ISyncCorrespondenceResolver<Edge, Diagram> provideEdgeResolver(ViewUtil viewUtil) {
		return viewUtil::getCorrespondingEdge;
	}

	@Provides
	public ISyncCorrespondenceResolver<Node, Edge> provideEndPointResolver(ViewUtil viewUtil) {
		return viewUtil::getCorrespondingEndpoint;
	}

	@Provides
	public ISyncCorrespondenceResolver<Location, Node> provideLocationResolver(ViewUtil viewUtil) {
		return viewUtil::getCorrespondingLayoutConstraint;
	}

	@Provides
	public ISyncCorrespondenceResolver<Size, Node> provideSizeResolver(ViewUtil viewUtil) {
		return viewUtil::getCorrespondingLayoutConstraint;
	}

	@Provides
	public ISyncCorrespondenceResolver<Style, View> provideStyleResolver(ViewUtil viewUtil) {
		return viewUtil::getCorrespondingStyle;
	}

	@Provides
	public ISyncCorrespondenceResolver<EObject, EObject> provideSemanticCorrespondence() {
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
	public ISyncCorrespondenceResolver<EObject, View> provideVisualCorrespondence(ISyncCorrespondenceResolver<EObject, EObject> semanticCorrespondence) {
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

	@Provides
	@Singleton
	@AutoDisableHook
	public BiConsumer<IBox<? extends Size>, Object> provideSizeAutoDisableHook(ViewUtil util, IMappingContext context) {
		return getShapeLayoutAutoDisableHook(util, context);
	}

	@Provides
	@Singleton
	@AutoDisableHook
	public BiConsumer<IBox<? extends Location>, Object> provideLocationAutoDisableHook(ViewUtil util, IMappingContext context) {
		return getShapeLayoutAutoDisableHook(util, context);
	}

	private <T extends EObject> BiConsumer<IBox<? extends T>, Object> getShapeLayoutAutoDisableHook(ViewUtil util, IMappingContext context) {
		return (box, data) -> {
			for (T next : box) {
				Shape shape = util.getAncestor(next, Shape.class);
				if (shape != null) {
					purgeLayoutMappings(shape, util, context);
				}
			}
		};
	}

	private void purgeLayoutMappings(Shape shape, ViewUtil util, IMappingContext context) {
		SyncExclusion style = util.getStyle(shape, SyncStylesPackage.Literals.SYNC_EXCLUSION, true);

		// Ensure that it excludes layout synchronization
		boolean updated = false;
		updated = style.getExcludedTypes().add(Location.class) || updated;
		updated = style.getExcludedTypes().add(Size.class) || updated;

		if (updated) {
			// Newly excluded? Purge existing mappings
			apply(style, shape, util, context);
		}
	}

	private void apply(SyncStyle syncStyle, View toView, ViewUtil util, IMappingContext context) {
		EcoreUtil.getAllContents(Collections.singleton(toView)).forEachRemaining(object -> {
			for (IMappingInstance<?, ?> mapping : context.getMappingInstances(object)) {
				if (!syncStyle.isEnabled(mapping.getType(), context)) {
					mapping.destroy();
				}
			}
		});
	}
}
