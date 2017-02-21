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
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.helper;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.architecture.representation.PapyrusRepresentationKind;
import org.eclipse.papyrus.infra.gmfdiag.common.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.infra.gmfdiag.representation.PapyrusDiagram;
import org.eclipse.papyrus.infra.gmfdiag.representation.RepresentationPackage;
import org.eclipse.papyrus.infra.viewpoints.policy.IViewTypeHelper;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;

/**
 * Represents the dynamic contribution of a policy to menus
 *
 * @author Laurent Wouters
 */
public class GMFDiagramViewTypeHelper implements IViewTypeHelper {

	/**
	 * The cache of prototypes
	 */
	private Map<PapyrusDiagram, DiagramPrototype> cache;

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.IViewTypeHelper#isSupported(org.eclipse.emf.ecore.EClass)
	 */
	@Override
	public boolean isSupported(EClass type) {
		return EcoreUtil.equals(type, RepresentationPackage.eINSTANCE.getPapyrusDiagram());
	}

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.IViewTypeHelper#isSupported(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean isSupported(EObject view) {
		return (view instanceof Diagram);
	}

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.IViewTypeHelper#getPrototypeFor(org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusRepresentationKind)
	 */
	@Override
	public ViewPrototype getPrototypeFor(PapyrusRepresentationKind kind) {
		if (!(kind instanceof PapyrusDiagram)) {
			return null;
		}
		PapyrusDiagram diagramKind = (PapyrusDiagram) kind;
		if (cache == null) {
			cache = new HashMap<PapyrusDiagram, DiagramPrototype>();
		}
		if (cache.containsKey(diagramKind)) {
			return cache.get(diagramKind);
		}
		String language = diagramKind.getLanguage().getId();
		AbstractPapyrusGmfCreateDiagramCommandHandler command;
		try {
			Class<?> creationCommandClass = diagramKind.getCreationCommandClass();
			command = (AbstractPapyrusGmfCreateDiagramCommandHandler) creationCommandClass.newInstance();
		} catch (Exception e) {
			Activator.log.error(e);
			return null;
		}
		DiagramPrototype proto = new DiagramPrototype(diagramKind, language, command);
		cache.put(diagramKind, proto);
		return proto;
	}

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.IViewTypeHelper#getPrototypeOf(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public ViewPrototype getPrototypeOf(EObject view) {
		if (!isSupported(view)) {
			return null;
		}
		return DiagramUtils.getPrototype((Diagram) view);
	}

}
