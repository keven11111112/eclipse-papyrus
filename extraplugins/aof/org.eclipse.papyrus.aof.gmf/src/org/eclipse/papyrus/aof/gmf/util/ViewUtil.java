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

package org.eclipse.papyrus.aof.gmf.util;

import static org.eclipse.papyrus.infra.tools.util.StreamUtil.asStream;
import static org.eclipse.papyrus.infra.tools.util.StreamUtil.select;

import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;

/**
 * An object providing helpful services for working with notation views.
 */
@Singleton
public class ViewUtil {
	/**
	 * Injection key name for the function determining whether two semantic model elements
	 * correspond in a diagram mapping.
	 */
	public static final String SEMANTIC_CORRESPONDENCE = "semanticCorrespondence"; //$NON-NLS-1$

	private BiPredicate<EObject, EObject> semanticCorrespondence;

	public ViewUtil() {
		super();
	}

	/**
	 * Obtains the predicate that determines whether two semantic elements (visualized by diagram views,
	 * presumably) correspond in the contextual diagram mapping scheme.
	 * 
	 * @return the semantic-element correspondence predicate
	 * 
	 * @see #setSemanticCorrespondencePredicate(BiPredicate)
	 */
	public BiPredicate<EObject, EObject> getSemanticCorrespondence() {
		return semanticCorrespondence;
	}

	/**
	 * <p>
	 * Sets the predicate that determines whether two semantic elements (visualized by diagram views,
	 * presumably) correspond in the contextual diagram mapping scheme.
	 * </p>
	 * <p>
	 * The {@code predicate} will be passed {@link View}s whenever they are available (if it is not the
	 * case that only the semantic element is available for testing), so the {@code predicate} must be
	 * prepared for this and extract the semantic element as necessary. This is actually quite useful
	 * as correspondence of the semantic elements may sometimes depend on the context of the
	 * visualization, which is provided by the view (for example, inherited ports and ports on parts
	 * in UML composite structure diagrams).
	 * </p>
	 * 
	 * @param predicate
	 *            the semantic-element correspondence predicate
	 */
	@Inject
	public void setSemanticCorrespondencePredicate(@Named(SEMANTIC_CORRESPONDENCE) BiPredicate<EObject, EObject> predicate) {
		this.semanticCorrespondence = (predicate == null) ? Objects::equals : predicate;
	}

	/**
	 * Obtains the node in a specified view corresponding to the given {@code node}.
	 * 
	 * @param node
	 *            the node for which to look for a correspondent
	 * @param inParent
	 *            the contextual parent view in which to look for or create the corresponding node
	 * 
	 * @return the node in the specified context corresponding to the given {@code node}
	 */
	public Node getCorrespondingNode(Node node, View inParent) {
		return (Node) getCorrespondingView(node, inParent);
	}

	/**
	 * Obtains the edge in a specified diagram corresponding to the given {@code edge}.
	 * 
	 * @param edge
	 *            the edge for which to look for a correspondent
	 * @param inDiagram
	 *            the contextual diagram in which to look for or create the corresponding edge
	 * 
	 * @return the edge in the specified context corresponding to the given {@code edge}
	 */
	public Edge getCorrespondingEdge(Edge edge, Diagram inDiagram) {
		return (Edge) getCorrespondingView(edge, inDiagram);
	}

	/**
	 * Obtains the source/target end of a specified edge corresponding to the given {@code endpoint}.
	 * 
	 * @param endpoint
	 *            the edge end point for which to look for a correspondent
	 * @param ofEdge
	 *            the contextual edge in which to look for or create the corresponding end point
	 * 
	 * @return the end-point in the specified edge corresponding to the given {@code endpoint}
	 */
	public Node getCorrespondingEndpoint(Node endpoint, Edge ofEdge) {
		Node result = null;

		// End-point is null when calculating default result of an active operation
		if (endpoint != null) {
			result = select(asStream(ofEdge.getDiagram().eAllContents()), Node.class)
					.filter(n -> correspondsTo(n, endpoint))
					.findFirst()
					.orElse(null);
		}

		return result;
	}

	private View getCorrespondingView(View view, View inParent) {
		View result = null;

		// View is null when calculating default result of an active operation
		if (view != null) {
			result = select(inParent.eContents().stream(), View.class)
					.filter(v -> correspondsTo(v, view))
					.findFirst()
					.orElseGet(() -> shallowCopy(view));
		}

		return result;
	}

	private boolean correspondsTo(View one, View other) {
		return (one.eClass() == other.eClass())
				&& Objects.equals(one.getType(), other.getType())
				&& semanticCorrespondence.test(one, other);
	}

	/**
	 * Obtains the layout constraint in a specified node corresponding to the given {@code constraint}.
	 * 
	 * @param constraint
	 *            the layout constraint for which to look for a correspondent
	 * @param inNode
	 *            the contextual node view in which to look for or create the corresponding layout constraint
	 * 
	 * @return the constraint in the specified context corresponding to the given {@code constraint}, or
	 *         {@code null} if the contextual node already has a constraint and it is of a type incompatible with the
	 *         original {@code constraint}'s
	 */
	public <L extends LayoutConstraint> L getCorrespondingLayoutConstraint(L constraint, Node inNode) {
		L result = null;

		// Constraint is null when calculating default result of an active operation
		if (constraint != null) {
			// Construction of the copy is type-safe
			@SuppressWarnings("unchecked")
			Class<? extends L> type = (Class<? extends L>) constraint.getClass();

			LayoutConstraint existing = inNode.getLayoutConstraint();
			if (type.isInstance(existing)) {
				result = type.cast(existing);
			} else if (existing == null) {
				result = type.cast(EcoreUtil.copy(constraint));
			}
		}

		return result;
	}

	/**
	 * Obtains the attached style object in a specified view corresponding to the given {@code style}.
	 * 
	 * @param style
	 *            the discrete style for which to look for a correspondent
	 * @param inView
	 *            the contextual view in which to look for or create the corresponding style
	 * 
	 * @return the style in the specified context corresponding to the given {@code style}
	 */
	public <S extends Style> S getCorrespondingStyle(S style, View inView) {
		S result = null;

		// Style is null when calculating default result of an active operation
		if (style != null) {
			// Construction of the copy is type-safe
			@SuppressWarnings("unchecked")
			Class<? extends S> type = (Class<? extends S>) style.getClass();

			Style existing = inView.getStyle(style.eClass());
			if (type.isInstance(existing)) {
				result = type.cast(existing);
			} else {
				result = type.cast(EcoreUtil.copy(style));
			}
		}

		return result;
	}

	/**
	 * Gets the notation node that visualizes an {@code element} in some contextual parent view.
	 * 
	 * @param element
	 *            the semantic element for which to retrieve a node view
	 * @param inParent
	 *            the parent view in which children the node is to be found
	 * @param type
	 *            the "visual ID" type of the node to be sought
	 * @param newNodeFunction
	 *            an optional function that will create a new node from the element if an existing one is not found.
	 *            May be {@code null}
	 * 
	 * @return the existing node visualizing the {@code element}, a new node, or {@code null} if none is found or created
	 */
	public Node getNodeViewOf(EObject element, View inParent, String type, Function<? super EObject, ? extends Node> newNodeFunction) {
		Supplier<Node> creator = () -> (newNodeFunction == null) ? null : newNodeFunction.apply(element);

		Node result = select(inParent.getChildren().stream(), Node.class)
				.filter(n -> Objects.equals(n.getType(), type))
				.filter(n -> semanticCorrespondence.test(n, element))
				.findFirst().orElseGet(creator);

		return result;
	}

	/**
	 * <p>
	 * Creates a shallow copy of a {@code view}, especially not recursively copying children (which it
	 * is required would be generated by recursive active-operations, if necessary).
	 * </p>
	 * <p>
	 * What is copied:
	 * </p>
	 * <table>
	 * <tr>
	 * <th>View Kind</th>
	 * <th>Properties Copied</th>
	 * </tr>
	 * <tr>
	 * <td><i>{@link View}</i></td>
	 * <td>{@link View#getType() type}, {@link View#isVisible() visible}, {@link View#isMutable() mutable}</td>
	 * </tr>
	 * <tr>
	 * <td>{@link Node}</td>
	 * <td>{@link Node#getLayoutConstraint() layoutConstraint}</td>
	 * </tr>
	 * <tr>
	 * <td>{@link Edge}</td>
	 * <td>{@link Edge#getSourceAnchor() sourceAnchor}, {@link Edge#getTargetAnchor() targetAnchor}, {@link Edge#getBendpoints() bendpoints}</td>
	 * </tr>
	 * <tr>
	 * <td>{@link Diagram}</td>
	 * <td>{@link Diagram#getName() name}, {@link Diagram#getMeasurementUnit() measurementUnit}</td>
	 * </tr>
	 * </table>
	 * 
	 * @param view
	 *            a view to be copied
	 * 
	 * @return the shallow copy of the {@code view}
	 */
	public static <V extends View> V shallowCopy(V view) {
		@SuppressWarnings("unchecked")
		V result = (V) EcoreUtil.create(view.eClass());

		result.setType(view.getType());
		result.setVisible(view.isVisible());
		result.setMutable(view.isMutable());

		if (view instanceof Diagram) {
			Diagram diagram = (Diagram) view;
			Diagram resultDiagram = (Diagram) result;

			resultDiagram.setName(diagram.getName());
			resultDiagram.setMeasurementUnit(diagram.getMeasurementUnit());
		}
		if (view instanceof Node) {
			Node node = (Node) view;
			Node resultNode = (Node) result;
			if (node.getLayoutConstraint() != null) {
				resultNode.setLayoutConstraint(EcoreUtil.copy(node.getLayoutConstraint()));
			}
		}

		if (view instanceof Edge) {
			Edge edge = (Edge) view;
			Edge resultEdge = (Edge) result;
			if (edge.getSourceAnchor() != null) {
				resultEdge.setSourceAnchor(EcoreUtil.copy(edge.getSourceAnchor()));
			}
			if (edge.getTargetAnchor() != null) {
				resultEdge.setTargetAnchor(EcoreUtil.copy(edge.getTargetAnchor()));
			}
			if (edge.getBendpoints() != null) {
				resultEdge.setBendpoints(EcoreUtil.copy(edge.getBendpoints()));
			}
		}

		return result;
	}

	public static void setElement(View view, View ofElement) {
		if (ofElement.isSetElement()) {
			view.setElement(ofElement.getElement());
		} else {
			view.unsetElement();
		}
	}

	public <V extends View> V getAncestor(EObject object, Class<V> ofType) {
		V result = null;

		for (EObject scan = object; scan != null; scan = scan.eContainer()) {
			if (ofType.isInstance(scan)) {
				result = ofType.cast(scan);
				break;
			}
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public <S extends Style> S getStyle(View view, EClass type, boolean create) {
		Style result = view.getStyle(type);
		if ((result == null) && create) {
			result = view.createStyle(type);
		}
		return (S) result;
	}
}
