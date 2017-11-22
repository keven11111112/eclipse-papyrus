/*****************************************************************************
 * Copyright (c) 2013, 2017 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 527580
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.gmfdiag.common.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.infra.gmfdiag.representation.PapyrusDiagram;
import org.eclipse.papyrus.infra.viewpoints.policy.AbstractViewTypeHelper;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;

/**
 * Represents the dynamic contribution of a policy to menus
 *
 * @author Laurent Wouters
 */
public class GMFDiagramViewTypeHelper extends AbstractViewTypeHelper<PapyrusDiagram> {

	/**
	 * Initializes me.
	 */
	public GMFDiagramViewTypeHelper() {
		super(PapyrusDiagram.class);
	}

	@Override
	public boolean isSupported(EObject view) {
		return (view instanceof Diagram);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @since 3.2
	 */
	@Override
	protected ViewPrototype doGetPrototypeFor(PapyrusDiagram diagramKind) {
		String language = diagramKind.getLanguage().getId();
		AbstractPapyrusGmfCreateDiagramCommandHandler command;
		try {
			Class<?> creationCommandClass = diagramKind.getCreationCommandClass();
			command = (AbstractPapyrusGmfCreateDiagramCommandHandler) creationCommandClass.newInstance();
		} catch (Exception e) {
			Activator.log.error(e);
			return null;
		}
		return new DiagramPrototype(diagramKind, language, command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @since 3.2
	 */
	@Override
	protected ViewPrototype doGetPrototypeOf(EObject view) {
		Diagram diagram = (Diagram) view;

		PolicyChecker checker = getPolicyChecker(diagram);
		return DiagramUtils.getPrototype(diagram, checker);
	}
}
