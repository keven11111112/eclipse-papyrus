/*****************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 433206
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.canonical.editpolicy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.TopGraphicEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.CanonicalStyle;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.util.CommandTreeIterator;
import org.eclipse.papyrus.commands.wrappers.GEFCommandWrapper;
import org.eclipse.papyrus.infra.core.utils.AdapterUtils;
import org.eclipse.papyrus.infra.gmfdiag.canonical.internal.Activator;
import org.eclipse.papyrus.infra.gmfdiag.canonical.strategy.ICreationTargetStrategy;
import org.eclipse.papyrus.infra.gmfdiag.canonical.strategy.ISemanticChildrenStrategy;
import org.eclipse.papyrus.infra.gmfdiag.canonical.strategy.IVisualChildrenStrategy;
import org.eclipse.papyrus.infra.gmfdiag.canonical.strategy.SemanticChildrenStrategyRegistry;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.requests.CanonicalDropObjectsRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.requests.RollingDeferredArrangeRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IPapyrusCanonicalEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.DiagramHelper;

import com.google.common.base.Optional;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * A specialization of the GMF {@link CanonicalEditPolicy} that alters the standard behaviour in a few key ways:
 * <ul>
 * <li>rather than using the View Service to create child views, delegate to the core drag-and-drop implementation generated for each diagram (by-passing the Papyrus exensible/pluggable drop strategies). This avoids the problems of determining a priori the
 * identifiers of child views to create in each compartment</li>
 * <li>treat incoming and outgoing edges on a top shape as child views for canonical synchronization</li>
 * <li>delegate determination of semantic children to pluggable strategies on an extension point</li>
 * </ul>
 */
public class PapyrusCanonicalEditPolicy extends CanonicalEditPolicy implements IPapyrusCanonicalEditPolicy {

	static final String FILTER_ID = "org.eclipse.papyrus.canonicalDependents"; //$NON-NLS-1$
	static final String SEMI_ACTIVE_FILTER_ID = "org.eclipse.papyrus.semiCanonical"; //$NON-NLS-1$

	private static final Set<View> createdByCanonical = Sets.newSetFromMap(new WeakHashMap<View, Boolean>());

	private final RollingDeferredArrangeRequest.IArrangementContext arrangeContext = new RollingDeferredArrangeRequest.IArrangementContext() {

		@Override
		public EditPart getHost() {
			return PapyrusCanonicalEditPolicy.this.getHost();
		}

		@Override
		public void execute(Command command) {
			executeCommand(command);
		}
	};

	private ISemanticChildrenStrategy semanticChildrenStrategy = null;
	private ICreationTargetStrategy creationTargetStrategy;

	private Collection<? extends EObject> dependents = null;

	private CanonicalStateListener canonicalStateListener;
	private CanonicalStateListener.Handler refreshHandler;

	private State state = State.INACTIVE;

	private boolean overrideEnabled;

	@Override
	public final void activate() {
		if (host().getNotationView() != null) {
			final SemanticChildrenStrategyRegistry reg = SemanticChildrenStrategyRegistry.getInstance();
			semanticChildrenStrategy = reg.getSemanticChildrenStrategy(getHost());
			creationTargetStrategy = ICreationTargetStrategy.Safe.safe(reg.getCreationTargetStrategy(getHost()));

			hookCanonicalStateListener();
			if (isEnabled()) {
				doActivate();
			} else {
				transition(State.SEMIACTIVE);
			}
		}
	}

	protected final void basicActivate() {
		transition(State.ACTIVE);
		super.activate();
	}

	protected void doActivate() {
		basicActivate();

		if (semanticChildrenStrategy != null) {
			dependents = semanticChildrenStrategy.getCanonicalDependents(getSemanticHost(), host().getNotationView());
			hookDependentsListener(dependents);
		}
	}

	@Override
	public final void deactivate() {
		if (host().getNotationView() != null) {
			unhookCanonicalStateListener();
		}

		doDeactivate();

		transition(State.INACTIVE);
	}

	protected final void basicDeactivate() {
		super.deactivate();
		transition(State.SEMIACTIVE);
	}

	protected void doDeactivate() {
		basicDeactivate();
	}

	private State transition(State newState) {
		final State result = state;

		if (newState != state) {
			if (!state.validateTransition(newState)) {
				Activator.log.warn(String.format("PapyrusCanonicalEditPolicy forcing invalid transition %s => %s ", state, newState)); //$NON-NLS-1$
			}

			switch (newState) {
			case INACTIVE:
				removeListenerFilter(SEMI_ACTIVE_FILTER_ID);
				break;
			case SEMIACTIVE:
				// Enter a semi-active state in which we only delete obsolete views that we had
				// originally created canonically while we were active
				EObject semanticHost = getSemanticHost();
				if (semanticHost != null) {
					addListenerFilter(SEMI_ACTIVE_FILTER_ID, this, semanticHost);
				}
				break;
			case ACTIVE:
				removeListenerFilter(SEMI_ACTIVE_FILTER_ID);
				break;
			}

			state = newState;
		}

		return result;
	}

	protected final boolean isInState(State state) {
		return this.state == state;
	}

	@Override
	public void enableRefresh(boolean enable) {
		// Only set ourselves 'enabled' when at least semi-active
		if (!isInState(State.INACTIVE)) {
			super.enableRefresh(enable);
		}
	}

	@Override
	public void refreshActive() {
		if (canonicalStateListener != null) {
			if (!isActive()) {
				if (isCanonicalStyleEnabled()) {
					doActivate();

					// I will not get this poke
					canonicalStateListener.pokeHandlers(refreshHandler, true);
				}
			} else {
				if (!isCanonicalStyleEnabled()) {
					doDeactivate();

					// I will not get this poke
					canonicalStateListener.pokeHandlers(refreshHandler, false);
				}
			}
		}
	}

	/**
	 * For CSS support, the canonical style of a compartment is inherited from its parent shape.
	 */
	@Override
	protected CanonicalStyle getCanonicalStyle() {
		return (CanonicalStyle) canonicalHost().getNotationView().getStyle(NotationPackage.eINSTANCE.getCanonicalStyle());
	}

	/**
	 * For CSS support, the canonical style of a compartment is inherited from its parent shape.
	 */
	protected final IGraphicalEditPart canonicalHost() {
		IGraphicalEditPart result = host();
		if (result instanceof IResizableCompartmentEditPart) {
			result = result.getTopGraphicEditPart();
		}
		return result;
	}

	private void hookCanonicalStateListener() {
		class Activate implements Runnable {
			@Override
			public void run() {
				doActivate();
			}
		}
		class Deactivate implements Runnable {
			@Override
			public void run() {
				doDeactivate();
			}
		}

		refreshHandler = new CanonicalStateListener.Handler() {
			@Override
			public Runnable handleAdd(CanonicalStyle style) {
				Runnable result = null;

				if (style.isCanonical()) {
					if (!isActive()) {
						result = new Activate();
					}
				} else if (isActive()) {
					result = new Deactivate();
				}

				return result;
			}

			@Override
			public Runnable handleRemove(CanonicalStyle style) {
				Runnable result = null;

				if (isActive()) {
					result = new Deactivate();
				}

				return result;
			}
		};

		canonicalStateListener = CanonicalStateListener.getInstance(canonicalHost());
		canonicalStateListener.addCanonicalRefreshHandler(refreshHandler);
	}

	private void unhookCanonicalStateListener() {
		if (canonicalStateListener != null) {
			canonicalStateListener.removeCanonicalRefreshHandler(refreshHandler);
			canonicalStateListener.release();
			canonicalStateListener = null;
		}
	}

	protected void hookDependentsListener(Iterable<? extends EObject> dependents) {
		if (dependents != null) {
			for (EObject next : dependents) {
				addListenerFilter(FILTER_ID, this, next);
			}
		}
	}

	@Override
	public boolean isEnabled() {
		if (overrideEnabled) {
			return true;
		}

		// by default there is no synchronization
		if (getCanonicalStyle() == null) {
			return false;
		}
		return super.isEnabled();
	}

	/**
	 * Queries whether I have the {@linkplain CanonicalStyle canonical style} applied and that style
	 * is {@linkplain CanonicalStyle#isCanonical() enabled}.
	 */
	protected boolean isCanonicalStyleEnabled() {
		CanonicalStyle style = getCanonicalStyle();
		return (style != null) && style.isCanonical();
	}

	@Override
	protected List<EObject> getSemanticChildrenList() {
		List<EObject> result = getSemanticChildrenList(ChildrenKind.NODE);

		if (isManageConnections()) {
			result = concat(result, getSemanticChildrenList(ChildrenKind.CONNECTION));
		}

		return result;
	}

	static <E> List<E> concat(Iterable<? extends E> list1, Iterable<? extends E> list2) {
		List<E> result = null;

		if (list1 != null) {
			result = Lists.newArrayList(list1);
		}

		if (list2 != null) {
			if (result != null) {
				Iterables.addAll(result, list2);
			} else {
				result = Lists.newArrayList(list2);
			}
		}

		return (result == null) ? Collections.<E> emptyList() : result;
	}

	protected List<EObject> getSemanticChildrenList(ChildrenKind kind) {
		if (semanticChildrenStrategy != null) {
			ArrayList<EObject> ancestor = getAllEObjectAncestor();

			List<? extends EObject> children;
			switch (kind) {
			case NODE:
				children = semanticChildrenStrategy.getCanonicalSemanticChildren(getSemanticHost(), host().getNotationView());
				break;
			case CONNECTION:
				children = semanticChildrenStrategy.getCanonicalSemanticConnections(getSemanticHost(), host().getNotationView());
				break;
			default:
				throw new IllegalArgumentException(kind.name());
			}

			if (children != null) {
				for (EObject next : children) {
					if (ancestor.contains(next)) {
						return Collections.emptyList();
					}
				}
				return Collections.unmodifiableList(children);
			}
		}

		return Collections.emptyList();
	}


	/**
	 * This method is used to calculate if a semantic element has been already display in parent to avoid loop of display
	 *
	 * @return the list of all semantic element display by parents edipart.
	 */
	protected ArrayList<EObject> getAllEObjectAncestor() {
		ArrayList<EObject> ancestor = new ArrayList<EObject>();
		EditPart currentEditPart = getHost();
		if (currentEditPart.getModel() instanceof View) {
			ancestor.add(((View) currentEditPart.getModel()).getElement());
		}
		while (currentEditPart.getParent() != null) {
			currentEditPart = currentEditPart.getParent();
			if (currentEditPart.getModel() instanceof View) {
				ancestor.add(((View) currentEditPart.getModel()).getElement());
			}
		}
		return ancestor;

	}

	@Override
	protected void handleNotificationEvent(Notification event) {
		// Override the enabled state to process deletions
		final boolean oldOverride = overrideEnabled;
		overrideEnabled = overrideEnabled || isInState(State.SEMIACTIVE);

		try {
			super.handleNotificationEvent(event);
			if (semanticChildrenStrategy != null) {
				if (dependents == null) {
					dependents = semanticChildrenStrategy.getCanonicalDependents(getSemanticHost(), host().getNotationView());
					hookDependentsListener(dependents);
				}
			}
		} finally {
			overrideEnabled = oldOverride;
		}
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#refreshSemantic()
	 *      In order to connect the drop mechanism this method has be overloaded
	 */
	@Override
	protected void refreshSemantic() {
		// First, process all child nodes now
		List<IAdaptable> createdViews = refreshSemanticChildren(ChildrenKind.NODE);
		makeViewsImmutable(createdViews);

		// Then, repeat later with connections included, if appropriate
		if (isManageConnections()) {
			ListenableFuture<List<IAdaptable>> createdConnections = DiagramHelper.submit(getHost(), new Callable<List<IAdaptable>>() {
				@Override
				public List<IAdaptable> call() throws Exception {
					return refreshSemanticChildren(ChildrenKind.CONNECTION);
				}
			});
			Futures.addCallback(createdConnections, new FutureCallback<List<IAdaptable>>() {
				@Override
				public void onSuccess(List<IAdaptable> result) {
					makeViewsImmutable(result);
				}

				@Override
				public void onFailure(Throwable t) {
					Activator.log.error(t);
				}
			});
		}
	}



	/**
	 * this method is extracted from refreshSemanticChildren
	 * but instead of using the service view it uses the drop
	 *
	 * @return
	 */
	protected List<IAdaptable> refreshSemanticChildren(ChildrenKind kind) {
		// -------------- code from superClass----------------
		// Don't try to refresh children if the semantic element
		// cannot be resolved.
		if (resolveSemanticElement() == null) {
			return Collections.emptyList();
		}

		if (isInState(State.SEMIACTIVE) && createdByCanonical.isEmpty()) {
			// No point in calculating anything because we have nothing to clean up
			return Collections.emptyList();
		}

		// current views
		List<View> viewChildren = getViewChildren(kind);
		List<EObject> semanticChildren = new ArrayList<EObject>(getSemanticChildrenList(kind));

		boolean changed = false;

		if (!isInState(State.INACTIVE)) {
			//
			// delete all the remaining orphaned views
			List<View> orphaned = cleanCanonicalSemanticChildren(viewChildren, semanticChildren);
			if (!orphaned.isEmpty() && isInState(State.SEMIACTIVE)) {
				// Furthermore, if we're only semiactive, then we should only delete views that we
				// had created canonically while we were active
				filterCanonicallyCreated(orphaned);
			}
			if (!orphaned.isEmpty()) {
				// We may be asynchronously processing the deletion of a relationship that
				// requires deletion of edges. If so, we may be only semi-active (the edge
				// could have been created by the edit-part at the other end)
				changed = deleteViews(orphaned);
			}
		}

		//
		// create a view for each remaining semantic element, if requested.
		List<IAdaptable> createdViews = Collections.emptyList();
		if (isInState(State.ACTIVE)) {
			if (!semanticChildren.isEmpty()) {
				createdViews = createViews(semanticChildren);
			}
		}

		if (changed || !createdViews.isEmpty()) {
			postProcessRefreshSemantic(createdViews);
		}

		return createdViews;
	}

	/**
	 * As {@link CanonicalEditPolicy#deleteViews(Iterator)}, deletes a list of views.
	 * The views will be deleted <tt>iff</tt> their semantic element has also been deleted.
	 * 
	 * @param views
	 *            an iterator on a list of views.
	 * @return <tt>true</tt> if the host editpart should be refreshed; either one one of the supplied
	 *         views was deleted or has been reparented.
	 */
	protected boolean deleteViews(Iterable<? extends View> views) {
		// Copied from CanonicalEditPolicy::deleteViews because that method is final, and
		// we need to be able to delete views even when we are only semi-active
		if (!isEnabled() && isInState(State.INACTIVE)) {
			return false;
		}
		final CompoundCommand cc = new CompoundCommand(DiagramUIMessages.DeleteCommand_Label);
		for (View view : views) {
			if (shouldDeleteView(view)) {
				cc.add(getDeleteViewCommand(view));
			}
		}

		boolean doDelete = !cc.isEmpty() && cc.canExecute();
		if (doDelete) {
			executeCommand(cc);
		}
		return doDelete;
	}

	@Override
	protected Command getCreateViewCommand(CreateRequest request) {
		Command result;

		if (!(request instanceof CreateViewRequest)) {
			result = super.getCreateViewCommand(request);
		} else {
			// Transform the request to a drop request serviced by the canonical drop policy
			CreateViewRequest createViewRequest = (CreateViewRequest) request;
			Iterable<? extends ViewDescriptor> descriptors = createViewRequest.getViewDescriptors();

			CompoundCommand compoundCommand = new CompoundCommand();
			for (ViewDescriptor viewDescriptor : descriptors) {
				EObject element = viewDescriptor.getElementAdapter().getAdapter(EObject.class);

				if (element != null) {
					List<EObject> elementToDrop = Collections.singletonList(element);
					DropObjectsRequest dropRequest = new DropObjectsRequest();
					dropRequest.setObjects(elementToDrop);
					dropRequest.setLocation(createViewRequest.getLocation());
					CanonicalDropObjectsRequest canonicalRequest = new CanonicalDropObjectsRequest(dropRequest);

					Command cmd = creationTargetStrategy.getTargetEditPart(getHost(), element).getCommand(canonicalRequest);
					if ((cmd != null) && cmd.canExecute()) {
						compoundCommand.add(cmd);
					}
				}
			}

			result = compoundCommand.unwrap();
			if (result.canExecute()) {
				result = tagAndArrange(result);
			}
		}

		return result;
	}

	@Override
	protected List<View> getViewChildren() {
		List<View> result = getViewChildren(ChildrenKind.NODE);

		if (isManageConnections()) {
			result.addAll(getViewChildren(ChildrenKind.CONNECTION));
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	protected List<View> getViewChildren(ChildrenKind kind) {
		final IGraphicalEditPart host = host();
		final View view = host.getNotationView();
		final IVisualChildrenStrategy strategy = SemanticChildrenStrategyRegistry.getInstance().getVisualChildrenStrategy(host);

		List<View> result;

		if (strategy != null) {
			List<? extends View> childViews;
			switch (kind) {
			case NODE:
				childViews = strategy.getCanonicalChildren(host, view);
				break;
			case CONNECTION:
				childViews = strategy.getCanonicalEdges(host, view);
				break;
			default:
				throw new IllegalArgumentException(kind.name());
			}
			result = (childViews == null) ? Collections.<View> emptyList() : Lists.newArrayList(childViews);
		} else {
			// Default strategy
			switch (kind) {
			case NODE:
				result = super.getViewChildren();

				// Filter out child views that visualize the same element as my view (these
				// should be compartments, decorations, labels)
				final EObject semantic = getSemanticHost();
				for (Iterator<? extends View> iter = result.iterator(); iter.hasNext();) {
					if (iter.next().getElement() == semantic) {
						iter.remove();
					}
				}
				break;
			case CONNECTION:
				// Get distinct incoming and outgoing edges of top shapes and border items.
				// Compartments of top shapes take care of their own contents
				List<View> edges = Lists.newArrayList();
				result = edges;
				if (view.eIsSet(NotationPackage.Literals.VIEW__SOURCE_EDGES)) {
					edges.addAll(view.getSourceEdges());
				}
				if (view.eIsSet(NotationPackage.Literals.VIEW__TARGET_EDGES)) {
					for (Edge next : (Iterable<? extends Edge>) view.getTargetEdges()) {
						if (next.getSource() != view) {
							// Didn't already get a self-edge from the source edges
							edges.add(next);
						}
					}
				}
				break;
			default:
				throw new IllegalArgumentException(kind.name());
			}
		}

		return result;
	}

	/**
	 * Queries whether I manage canonical connections. Edit parts such as top shapes and border items manage connections;
	 * other edit parts such as compartments manage contained views only.
	 * 
	 * @return whether I manage canonical connections
	 */
	protected boolean isManageConnections() {
		final EditPart host = host();
		return (host instanceof TopGraphicEditPart) || (host instanceof IBorderItemEditPart);
	}

	private Command tagAndArrange(Command creationCommand) {
		return new PostCreationWrapperCommand<List<IAdaptable>>(creationCommand) {

			@Override
			protected List<IAdaptable> createAccumulator() {
				return Lists.newArrayList();
			}

			@Override
			protected void postProcessView(Object viewish, List<IAdaptable> accumulator) {
				if (viewish instanceof IAdaptable) {
					View view = ((IAdaptable) viewish).getAdapter(View.class);
					if (view != null) {
						// Arrange the parent of a label, not the label
						if (view instanceof DecorationNode) {
							view = (View) view.eContainer();
							viewish = new EObjectAdapter(view);
						}

					}
					accumulator.add((IAdaptable) viewish);
				}
				super.postProcessView(viewish, accumulator);
			}

			@Override
			protected void postProcessView(View view, List<IAdaptable> accumulator) {
				createdByCanonical.add(view);
			}

			@Override
			protected void complete(List<IAdaptable> accumulator) {
				if (!accumulator.isEmpty()) {
					RollingDeferredArrangeRequest.post(arrangeContext, accumulator);
				}
			}
		};
	}

	private <C extends Collection<? extends View>> C filterCanonicallyCreated(C views) {
		for (Iterator<? extends View> iter = views.iterator(); iter.hasNext();) {
			if (!createdByCanonical.contains(iter.next())) {
				iter.remove();
			}
		}

		return views;
	}

	//
	// Nested types
	//

	protected enum State {
		INACTIVE, SEMIACTIVE, ACTIVE;

		boolean validateTransition(State next) {
			switch (this) {
			case INACTIVE:
			case SEMIACTIVE:
				return next != this;
			case ACTIVE:
				return next == SEMIACTIVE;
			default:
				throw new IllegalStateException("No such state: " + this); //$NON-NLS-1$
			}
		}
	}

	protected enum ChildrenKind {
		NODE, CONNECTION;
	}

	protected static abstract class PostCreationWrapperCommand<A> extends GEFCommandWrapper {
		public PostCreationWrapperCommand(Command command) {
			super(command);
		}

		@Override
		public void execute() {
			super.execute();

			A accumulator = createAccumulator();
			postProcessViews(getCommand(), accumulator);
			complete(accumulator);
		}

		protected A createAccumulator() {
			return null;
		}

		protected void complete(A accumulator) {
			// Pass
		}

		private void postProcessViews(Command command, A accumulator) {
			for (Iterator<ICommand> iter = CommandTreeIterator.iterateGMF(command); iter.hasNext();) {
				CommandResult result = iter.next().getCommandResult();
				if ((result != null) && ((result.getStatus() == null) || result.getStatus().isOK())) {
					Object returnValue = result.getReturnValue();
					if (returnValue instanceof Iterable<?>) {
						for (Object next : (Iterable<?>) returnValue) {
							postProcessView(next, accumulator);
						}
					} else if (returnValue != null) {
						postProcessView(returnValue, accumulator);
					}
				}
			}
		}

		protected void postProcessView(Object viewish, A accumulator) {
			Optional<View> view = AdapterUtils.adapt(viewish, View.class);
			if (view.isPresent()) {
				postProcessView(view.get(), accumulator);
			}
		}

		protected void postProcessView(View view, A accumulator) {
			// Pass
		}
	}
}
