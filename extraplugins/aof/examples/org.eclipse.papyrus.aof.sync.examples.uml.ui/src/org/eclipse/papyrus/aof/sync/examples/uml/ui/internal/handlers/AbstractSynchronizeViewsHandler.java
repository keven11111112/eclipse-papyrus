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

import static org.eclipse.papyrus.infra.tools.util.StreamUtil.select;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Provider;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.ISyncCorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingModel;
import org.eclipse.papyrus.aof.sync.examples.uml.internal.UMLRTMappingModule;
import org.eclipse.papyrus.aof.sync.gmf.DiagramMappingFactory;
import org.eclipse.papyrus.aof.sync.gmf.DiagramMappingModule;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.infra.tools.util.StreamUtil;
import org.eclipse.papyrus.sync.ISyncMappingModel;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.base.Objects;
import com.google.inject.util.Modules;
import com.google.inject.util.Providers;

/**
 * Partial implementation of a command handler for synchronization of diagrams.
 * Given a selected diagram, it sets up mappings to synchronize it with all other
 * diagrams of the same {@link View#getType() type} that visual the same element
 * (or any other definition of "same" or "corresponding" that the domain defines,
 * such as redefining state machines in the UML-RT example).
 */
public abstract class AbstractSynchronizeViewsHandler<V extends View, E extends EditPart> extends AbstractHandler {
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

		@SuppressWarnings("unchecked")
		List<E> selection = sel.toList();
		synchronize(selection);

		return null;
	}

	/**
	 * Synchronize each of the specified selected edit-parts with the other edit-parts
	 * that visualize the same or otherwise corresponding element.
	 * 
	 * @param selectedEditParts
	 *            a selection of one or more edit-parts
	 */
	public void synchronize(Collection<? extends E> selectedEditParts) {
		List<E> selection = StreamUtil.select(selectedEditParts.stream(), editPartType).collect(Collectors.toList());
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((View) selection.get(0).getModel());
		ModelSet modelSet = (ModelSet) domain.getResourceSet();

		DiagramMappingFactory mappingFactory = getMappingFactory(domain);

		ISyncCorrespondenceResolver<EObject, EObject> correspondence = mappingFactory.getInstance(
				ISyncCorrespondenceResolver.class, EObject.class, EObject.class);

		domain.getCommandStack().execute(new RecordingCommand(domain, "Synchronize Views") {

			@Override
			protected void doExecute() {
				IMapping<V, V> mapping = mappingFactory.getMapping(viewType, viewType);
				MappingModel model = ISyncMappingModel.getInstance(modelSet).getMappingModel();

				selection.forEach(ep -> {
					View view = (View) ep.getModel();
					Diagram diagram = view.getDiagram();
					EObject element = view.getElement();
					for (EObject context : getContexts(element, view)) {
						EObject correspondent = correspondence.getCorrespondent(element, context);
						DiagramEditPartsUtil.getEObjectViews(correspondent).stream().map(DiagramEditPartsUtil::findEditParts).forEach(allEPs -> {
							allEPs.forEach(other -> {
								if (other != ep) {
									View otherView = (View) other.getModel();
									Diagram otherDiagram = (otherView == null) ? null : otherView.getDiagram();

									if (!Objects.equal(otherView, view)
											&& Objects.equal(diagram.getType(), otherDiagram.getType())
											&& Objects.equal(view.getType(), otherView.getType())) {

										// Of course the other is the same kind of edit part if it has a view of the same type
										model.getInstances().add(mapping.map(viewType.cast(ep.getModel()), viewType.cast(other.getModel())));
									}
								}
							});
						});
					}
				});
			}
		});
	}

	DiagramMappingFactory getMappingFactory(TransactionalEditingDomain editingDomain) {
		Provider<EditingDomain> editingDomainProvider = Providers.of(editingDomain);

		return new DiagramMappingFactory(
				Modules.override(new DiagramMappingModule(editingDomainProvider))
						.with(Modules.override(new UMLRTMappingModule(editingDomainProvider))
								.with(new StateMachineDiagramMappingModule())));
	}

	Iterable<? extends EObject> getContexts(EObject element, View view) {
		Iterable<? extends EObject> result;

		while ((view != null) && (view.getElement() == element)) {
			EObject container = view.eContainer();
			view = (container instanceof View) ? (View) container : null;
		}

		EObject selectionContext = (view != null) ? view.getElement() : element.eContainer();
		if (selectionContext instanceof org.eclipse.uml2.uml.Class) {
			// Get composite/behavior diagrams of the subclasses
			org.eclipse.uml2.uml.Class class_ = (org.eclipse.uml2.uml.Class) selectionContext;
			result = getSubclasses(class_);
		} else {
			// Just get other diagrams visualizing this same element
			result = Collections.singletonList(selectionContext);
		}

		return result;
	}

	Iterable<org.eclipse.uml2.uml.Class> getSubclasses(org.eclipse.uml2.uml.Class class_) {
		return select(select(class_.getTargetDirectedRelationships(UMLPackage.Literals.GENERALIZATION).stream(), Generalization.class)
				.map(Generalization::getSpecific), org.eclipse.uml2.uml.Class.class)
						.collect(Collectors.toList());
	}
}
