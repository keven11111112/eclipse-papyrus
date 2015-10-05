/*****************************************************************************
 * Copyright (c) 2015 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - bug 433206
 *   Christian W. Damus - bug 473148
 *   Christian W. Damus - bug 478558
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.canonical;

import static com.google.common.base.Predicates.and;
import static com.google.common.base.Predicates.not;
import static org.eclipse.papyrus.uml.tools.utils.UMLUtil.isAssociationEnd;
import static org.eclipse.papyrus.uml.tools.utils.UMLUtil.isRelationship;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.canonical.strategy.ISemanticChildrenStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.infra.tools.util.TypeUtils;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.util.UMLSwitch;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Default semantic children strategy for canonical UML views.
 */
public class DefaultUMLSemanticChildrenStrategy implements ISemanticChildrenStrategy {

	public DefaultUMLSemanticChildrenStrategy() {
		super();
	}

	@Override
	public List<? extends EObject> getCanonicalSemanticChildren(EObject semanticFromEditPart, View viewFromEditPart) {
		List<Element> result = null;

		if (semanticFromEditPart instanceof Element) {
			Element element = (Element) semanticFromEditPart;
			Iterable<Element> owned = element.getOwnedElements();

			// Never include relationships that are owned, because they would be found
			// when relationships are requested
			owned = Iterables.filter(owned, not(isRelationship()));

			// And also don't include association ends because we visualize the association,
			// unless we actually won't visualize the association because the other type
			// is not present in the diagram, in which case the attribute style is the only
			// way we can show the end
			owned = Iterables.filter(owned, not(and(isAssociationEnd(), isPropertyTypeVisualized(viewFromEditPart))));

			result = Lists.newArrayList(owned);
		}

		return result;
	}

	protected Predicate<Object> isPropertyTypeVisualized(View viewContext) {
		final Diagram diagram = viewContext.getDiagram();

		return new Predicate<Object>() {
			@Override
			public boolean apply(Object input) {
				boolean result = false;

				if (input instanceof Property) {
					Type type = ((Property) input).getType();
					if (type != null) {
						for (Object view : DiagramEditPartsUtil.getEObjectViews(type)) {
							if (((View) view).getDiagram() == diagram) {
								// type is visualized in the same diagram as the property
								result = true;
								break;
							}
						}
					}
				}

				return result;
			}
		};
	}

	@Override
	public List<? extends EObject> getCanonicalSemanticConnections(EObject semanticFromEditPart, View viewFromEditPart) {
		List<Element> result = null;

		if (semanticFromEditPart instanceof Element) {
			Element element = (Element) semanticFromEditPart;

			// Add relationships
			result = Lists.<Element> newArrayList(element.getRelationships());

			// But we don't visualize associations as relationships of properties (which can
			// be visualized as shapes in a composite structure diagram, for example)
			result = new CleanRelationshipsSwitch(viewFromEditPart, result).doSwitch(element);

			// And then add relationship-like elements
			result = new ConnectionsSwitch(viewFromEditPart, result).doSwitch(element);
		}

		return result;
	}


	@Override
	public Collection<? extends EObject> getCanonicalDependents(EObject semanticFromEditPart, View viewFromEditPart) {
		Collection<Element> result = null;

		if (semanticFromEditPart instanceof NamedElement) {
			// Handle changes to client/supplier dependencies
			// TODO: This will cause a lot of unneeded refresh. Performance problem? Better way?
			Element package_ = ((NamedElement) semanticFromEditPart).getNearestPackage();
			if (package_ != null) {
				result = Collections.singletonList(package_);
			}
		}

		return result;
	}

	protected Property getExpectedPartWithPort(View possiblePortView) {
		Property result = null;

		if (possiblePortView.getElement() instanceof Port) {
			View parentView = TypeUtils.as(possiblePortView.eContainer(), View.class);
			if (parentView != null) {
				result = TypeUtils.as(parentView.getElement(), Property.class);
			}
		}

		return result;
	}

	//
	// Nested types
	//

	private class ConnectionsSwitch extends UMLSwitch<List<Element>> {
		private final View visualContext;
		private final List<Element> result;

		ConnectionsSwitch(View visualContext, List<Element> result) {
			super();

			this.visualContext = visualContext;
			this.result = result;
		}

		@Override
		public List<Element> doSwitch(EObject eObject) {
			super.doSwitch(eObject);

			return result;
		}

		@Override
		public List<Element> caseConnectableElement(ConnectableElement object) {
			Property expectedPartWithPort = getExpectedPartWithPort(visualContext);

			for (ConnectorEnd next : object.getEnds()) {
				// Only report connectors for which the part-with-port matches in the visual context
				if (next.getPartWithPort() == expectedPartWithPort) {
					result.add(next.getOwner()); // the Connector
				}
			}
			return super.caseConnectableElement(object);
		}

		@Override
		public List<Element> caseActivityNode(ActivityNode object) {
			result.addAll(object.getOutgoings());
			result.addAll(object.getIncomings());
			return super.caseActivityNode(object);
		}

		@Override
		public List<Element> caseVertex(Vertex object) {
			result.addAll(object.getOutgoings());
			result.addAll(object.getIncomings());
			return super.caseVertex(object);
		}

		@Override
		public List<Element> caseMessageEnd(MessageEnd object) {
			result.add(object.getMessage());
			return super.caseMessageEnd(object);
		}
	}

	private class CleanRelationshipsSwitch extends UMLSwitch<List<Element>> {
		@SuppressWarnings("unused") // It isn't used, *yet*
		private final View visualContext;
		private final List<Element> result;

		CleanRelationshipsSwitch(View visualContext, List<Element> result) {
			super();

			this.visualContext = visualContext;
			this.result = result;
		}

		@Override
		public List<Element> doSwitch(EObject eObject) {
			super.doSwitch(eObject);

			return result;
		}

		@Override
		public List<Element> caseProperty(Property object) {
			if (object.getAssociation() != null) {
				result.remove(object.getAssociation());
			}
			return super.caseProperty(object);
		}
	}

}
