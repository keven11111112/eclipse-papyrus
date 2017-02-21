/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *  Benoit Maggi    (Cea)        benoit.maggi@cea.fr - Add utility to get the containing diagram
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureViewpoint;
import org.eclipse.papyrus.infra.architecture.representation.PapyrusRepresentationKind;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.DiagramPrototype;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.infra.gmfdiag.style.PapyrusDiagramStyle;
import org.eclipse.papyrus.infra.gmfdiag.style.StylePackage;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;

/**
 * Utilities for the management of configuration-related data on views and diagrams
 *
 * @author Laurent Wouters
 */
public class DiagramUtils {

	/**
	 * Gets the diagram associated to the given edit part
	 *
	 * @param part
	 *            The edit part
	 * @return The diagram associated to the edit part, or <code>null</code> if none is found
	 */
	public static Diagram getDiagramFrom(EditPart part) {
		EditPart current = part;
		while (current != null) {
			Object model = current.getModel();
			if (model instanceof Diagram) {
				return (Diagram) model;
			}
			if (current.getParent() != null) {
				current = current.getParent();
			} else {
				// No more parent, assume this is a RenderedDiagramRootEditPart
				if (current.getChildren().size() == 0) {
					return null;
				}
				current = (EditPart) current.getChildren().get(0);
				model = current.getModel();
				return (model instanceof Diagram) ? (Diagram) model : null;
			}
		}
		return null;
	}

	/**
	 * Gets the owner of a diagram as it will appear in the model explorer.
	 * In the case where the diagram does not yet have a defined owner, the diagram's root element will be returned instead.
	 *
	 * @param diagram
	 *            A diagram
	 * @return The diagram's owner
	 */
	public static EObject getOwner(Diagram diagram) {
		PapyrusDiagramStyle pvs = getPapyrusDiagramStyle(diagram);
		if (pvs != null) {
			EObject value = pvs.getOwner();
			if (value != null) {
				return value;
			}
		}
		// This is the legacy fallback for old diagrams
		return diagram.getElement();
	}

	/**
	 * Sets the owner of a diagram as it will appear in the model explorer
	 *
	 * @param diagram
	 *            A diagram
	 * @param owner
	 *            The new diagram's owner
	 */
	public static void setOwner(Diagram diagram, EObject owner) {
		PapyrusDiagramStyle pvs = getPapyrusDiagramStyle(diagram);
		if (pvs != null) {
			pvs.setOwner(owner);
		} else {
			pvs = (PapyrusDiagramStyle) diagram.createStyle(StylePackage.Literals.PAPYRUS_DIAGRAM_STYLE);
			pvs.setOwner(owner);
		}
	}

	/**
	 * Returns the PapyrusRepresentationStyle owned by this diagram (if any)
	 *
	 * @param diagram
	 * @return
	 */
	public static final PapyrusDiagramStyle getPapyrusDiagramStyle(Diagram diagram) {
		for (Style ownedStyle : (List<Style>) diagram.getStyles()) { // Access all styles directly to avoid CSS computation, and use instanceof (Rather than reflexive EMF)
			if (ownedStyle instanceof PapyrusDiagramStyle) {
				return (PapyrusDiagramStyle) ownedStyle;
			}
		}
		return null;
	}

	/**
	 * Gets the prototype of a diagram
	 * Check if the selected viewpoint contains
	 * 1. the diagram model kind
	 * 2. an ancestor of the diagram model kind
	 * 3. a descendant of the diagram model kind
	 *
	 * @param diagram
	 *            A diagram
	 * @return The diagram's prototype
	 */
	public static ViewPrototype getPrototype(Diagram diagram) {
		PolicyChecker checker = PolicyChecker.getFor(diagram);
		PapyrusDiagramStyle pvs = getPapyrusDiagramStyle(diagram);
		if (pvs != null) {			
			PapyrusRepresentationKind repKind = pvs.getDiagramKind();

			// Check if the selected viewpoint contains the diagram model kind
			if (repKind != null) {
				
				if (checker.isInViewpoint(repKind)) {
					return ViewPrototype.get(repKind);
				}

				// Check if the selected viewpoint contains an ancestor of the diagram model kind
				PapyrusRepresentationKind diagramParentView = repKind.getParent();
				while (diagramParentView != null && !checker.isInViewpoint(diagramParentView)) {
					diagramParentView = diagramParentView.getParent();
				}
				if (diagramParentView != null) {
					return ViewPrototype.get(diagramParentView);
				}

				// Check if the selected viewpoint contains a descendant of the diagram model kind
				String diagramConfigName = repKind.getName();
				if (diagramConfigName != null) { // the model kind name is used as a "semantic" key to test equality
					for (MergedArchitectureViewpoint viewpoint : checker.getViewpoints()) {
						for (RepresentationKind representationKind : viewpoint.getRepresentationKinds()) {
							if (representationKind instanceof PapyrusRepresentationKind) {
								PapyrusRepresentationKind papyrusRepresentationKind = (PapyrusRepresentationKind) representationKind;
	
								if (diagramConfigName.equals(papyrusRepresentationKind.getName())) {
									ViewPrototype.get(papyrusRepresentationKind);
								}
	
								PapyrusRepresentationKind parentPapyrusRepresentationKind = papyrusRepresentationKind.getParent();
								while (parentPapyrusRepresentationKind != null && !diagramConfigName.equals(parentPapyrusRepresentationKind.getName())) {
									parentPapyrusRepresentationKind = parentPapyrusRepresentationKind.getParent();
								}
								if (parentPapyrusRepresentationKind != null) {
									return ViewPrototype.get(papyrusRepresentationKind);
								}
							}
						}
					}
				}

			}
			return ViewPrototype.get(checker, diagram.getType(), pvs.getOwner(), diagram.getElement());
		} else {
			return ViewPrototype.get(checker, diagram.getType(), diagram.getElement(), diagram.getElement());
		}
	}
	
	/**
	 * Sets the prototype of a diagram
	 *
	 * @param diagram
	 *            A diagram
	 * @param prototype
	 *            The new diagram's prototype
	 */
	public static void setPrototype(Diagram diagram, DiagramPrototype prototype) {
		PapyrusDiagramStyle pvs = getPapyrusDiagramStyle(diagram);
		if (pvs != null) {
			pvs.setDiagramKind(prototype.getRepresentationKind());
		} else {
			pvs = (PapyrusDiagramStyle) diagram.createStyle(StylePackage.Literals.PAPYRUS_DIAGRAM_STYLE);
			pvs.setDiagramKind(prototype.getRepresentationKind());
		}
	}


	/**
	 * Gets the diagrams associated to element.
	 *
	 * @param element
	 * @param resourceSet
	 *            can be null, it will then try to retrieve it from the element.
	 * @return the list of diagrams associated with the given element
	 */
	public static List<Diagram> getAssociatedDiagrams(EObject element, ResourceSet resourceSet) {
		if (resourceSet == null) {
			if (element != null && element.eResource() != null) {
				resourceSet = element.eResource().getResourceSet();
			}
		}

		if (resourceSet instanceof ModelSet) {
			Resource notationResource = NotationUtils.getNotationResource((ModelSet) resourceSet);
			return getAssociatedDiagramsFromNotationResource(element, notationResource);
		}

		return Collections.emptyList();
	}

	/**
	 * Gets the diagrams associated to element.
	 *
	 * @param element
	 * @param notationResource
	 *            the notation resource where to look for diagrams
	 * @return the list of diagrams associated with the given element
	 */
	public static List<Diagram> getAssociatedDiagramsFromNotationResource(EObject element, Resource notationResource) {
		if (notationResource != null) {
			LinkedList<Diagram> diagrams = new LinkedList<Diagram>();
			for (EObject eObj : notationResource.getContents()) {
				if (eObj instanceof Diagram) {
					Diagram diagram = (Diagram) eObj;
					if (element.equals(diagram.getElement())) {
						diagrams.add(diagram);
					}
				}
			}
			return diagrams;
		}
		return Collections.emptyList();
	}


	/**
	 * Return the diagram containing this view
	 *
	 * @param view
	 * @return
	 */
	public static Diagram getContainingDiagram(final View view) {
		if (view instanceof Diagram) {
			return (Diagram) view;
		}
		final EObject eContainer = view.eContainer();
		if (eContainer instanceof View) {
			return getContainingDiagram((View) eContainer);
		}
		return null;
	}

	/**
	 * Return the type of the diagram containing this view
	 *
	 * @param view
	 * @return
	 */
	public static String getContainingDiagramType(final View view) {
		Diagram containingDiagram = getContainingDiagram(view);
		if (containingDiagram != null) {
			return containingDiagram.getType();
		}
		return null;
	}
}
