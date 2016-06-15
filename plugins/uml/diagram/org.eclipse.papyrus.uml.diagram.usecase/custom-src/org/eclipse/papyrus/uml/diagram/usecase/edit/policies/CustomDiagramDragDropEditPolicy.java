/*****************************************************************************
 * Copyright (c) 2009, 2015 Atos Origin, Christian W. Damus, and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *  Christian W. Damus - bug 468646
 *  Fanch Bonnabesse (ALL4TEC) fanch.bonnabesse@alltec.net - Bug 492893
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.edit.policies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.util.AssociationUtil;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.helper.UseCaseLinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Element;

/**
 * This class is used to execute the drag and drop from the outline. It can manage the drop of nodes
 * and binary links. To manage specific drop the method
 * CommonDiagramDragDropEditPolicy.getSpecificDropCommand has to be implemented
 */
public class CustomDiagramDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	/**
	 * Instantiates a new custom diagram drag drop edit policy with the right link mapping helper
	 */
	public CustomDiagramDragDropEditPolicy() {
		super(UseCaseLinkMappingHelper.getInstance());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Set<Integer> getDroppableElementVisualId() {
		Set<Integer> droppableElementsVisualId = new HashSet<Integer>();
		droppableElementsVisualId.add(AssociationEditPart.VISUAL_ID);
		return droppableElementsVisualId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IElementType getUMLElementType(int elementID) {
		return UMLElementTypes.getElementType(elementID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		return UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		return UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID, int linkVISUALID) {
		switch (linkVISUALID) {
		case AssociationEditPart.VISUAL_ID:
			return dropAssociation(dropRequest, semanticLink, linkVISUALID);
		default:
			return super.getSpecificDropCommand(dropRequest, semanticLink, nodeVISUALID, linkVISUALID);
		}
	}

	/**
	 * Specific drop action for association
	 *
	 * @param dropRequest
	 *            the drop request
	 * @param semanticLink
	 *            the semantic link
	 * @param linkVISUALID
	 *            the link visual Sid
	 *
	 * @return the command for association
	 */
	protected Command dropAssociation(final DropObjectsRequest dropRequest, final Element semanticLink, final int linkVISUALID) {
		final List<?> endtypes = new ArrayList<Object>(UseCaseLinkMappingHelper.getInstance().getSource(semanticLink));
		if (endtypes.size() == 1) {
			// Bug 468646: It is debatable whether self-associations on use cases or actors make sense, but
			// since we support creating them, we must also support dropping them into the diagram
			Element source = (Element) endtypes.get(0);
			Element target = (Element) endtypes.get(0);
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Association"), source, target, linkVISUALID, dropRequest.getLocation(), semanticLink)); //$NON-NLS-1$
		} else if (endtypes.size() == 2) {
			// Source link is based on the target property and the target link is based on the source property
			Element source = AssociationUtil.getTargetSecondEnd((Association) semanticLink).getType();
			Element target = AssociationUtil.getSourceFirstEnd((Association) semanticLink).getType();
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Association"), source, target, linkVISUALID, dropRequest.getLocation(), semanticLink)); //$NON-NLS-1$
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}
}
