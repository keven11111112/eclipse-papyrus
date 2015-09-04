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

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.examples.uml.internal.UMLRTMappingModule;
import org.eclipse.papyrus.aof.sync.gmf.DiagramMappingFactory;
import org.eclipse.papyrus.aof.sync.gmf.DiagramMappingModule;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.infra.tools.util.StreamUtil;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.common.base.Objects;
import com.google.inject.util.Modules;

/**
 * Partial implementation of a command handler for synchronization of diagrams.
 * Given a selected diagram, it sets up mappings to synchronize it with all other
 * diagrams of the same {@link View#getType() type} that visual the same element
 * (or any other definition of "same" or "corresponding" that the domain defines,
 * such as redefining state machines in the UML-RT example).
 */
abstract class AbstractSynchronizeViewsHandler<V extends View, E extends EditPart> extends AbstractHandler {
	private final Class<V> viewType;
	private final Class<E> editPartType;

	public AbstractSynchronizeViewsHandler(Class<V> viewType, Class<E> editPartType) {
		super();

		this.viewType = viewType;
		this.editPartType = editPartType;
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection sel = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);

		DiagramMappingFactory mappingFactory = getMappingFactory();
		IMapping<V> mapping = mappingFactory.getMapping(viewType);

		ICorrespondenceResolver<EObject, EObject> correspondence = mappingFactory.getInstance(
				ICorrespondenceResolver.class, EObject.class, EObject.class);

		List<E> selection = StreamUtil.select(((List<?>) sel.toList()).stream(), editPartType).collect(Collectors.toList());
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((View) selection.get(0).getModel());

		domain.getCommandStack().execute(new RecordingCommand(domain, "Synchronize Views") {

			@Override
			protected void doExecute() {
				selection.forEach(ep -> {
					View view = (View) ep.getModel();
					Diagram diagram = view.getDiagram();
					EObject element = view.getElement();
					EObject correspondent = correspondence.getCorrespondent(element, getContext(element, view));
					DiagramEditPartsUtil.getEObjectViews(correspondent).stream().map(DiagramEditPartsUtil::findEditParts).forEach(allEPs -> {
						allEPs.forEach(other -> {
							if (other != ep) {
								View otherView = (View) other.getModel();
								Diagram otherDiagram = (otherView == null) ? null : otherView.getDiagram();

								if (!Objects.equal(otherView, view)
										&& Objects.equal(diagram.getType(), otherDiagram.getType())
										&& Objects.equal(view.getType(), otherView.getType())) {

									// Of course the other is the same kind of edit part if it has a view of the same type
									mapping.map(viewType.cast(ep.getModel()), viewType.cast(other.getModel()));
								}
							}
						});
					});
				});
			}
		});

		return null;
	}

	DiagramMappingFactory getMappingFactory() {
		return new DiagramMappingFactory(
				Modules.override(new DiagramMappingModule())
						.with(Modules.override(new UMLRTMappingModule())
								.with(new StateMachineDiagramMappingModule())));
	}

	EObject getContext(EObject element, View view) {
		while ((view != null) && (view.getElement() == element)) {
			EObject container = view.eContainer();
			view = (container instanceof View) ? (View) container : null;
		}

		EObject result = (view != null) ? view.getElement() : element.eContainer();
		if (result instanceof org.eclipse.uml2.uml.Class) {
			org.eclipse.uml2.uml.Class class_ = (org.eclipse.uml2.uml.Class) result;
			result = SynchronizeCapsulesHandler.synchronizedCapsules.getOrDefault(class_, class_);
		}

		return result;
	}
}
