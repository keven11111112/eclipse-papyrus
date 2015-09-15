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

package org.eclipse.papyrus.aof.sync.examples.uml.ui.tests;

import static org.eclipse.papyrus.infra.tools.util.StreamUtil.select;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeThat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.function.Predicate;

import javax.inject.Inject;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.aof.sync.examples.uml.ui.internal.handlers.AbstractSynchronizeViewsHandler;
import org.eclipse.papyrus.aof.sync.tests.runners.GuiceRunner;
import org.eclipse.papyrus.aof.sync.tests.runners.InjectWith;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.utils.AdapterUtils;
import org.eclipse.papyrus.infra.emf.utils.TreeIterators;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.services.edit.utils.ElementTypeUtils;
import org.eclipse.papyrus.infra.tools.util.StreamUtil;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.JUnitUtils;
import org.eclipse.papyrus.junit.utils.rules.AbstractHouseKeeperRule.CleanUp;
import org.eclipse.papyrus.junit.utils.rules.AnnotationRule;
import org.eclipse.papyrus.junit.utils.rules.HouseKeeper;
import org.eclipse.papyrus.junit.utils.rules.PapyrusEditorFixture;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;

/**
 * Common implementation of diagram synchronization test cases.
 */
@RunWith(GuiceRunner.class)
@InjectWith(TestDiagramModule.class)
public abstract class AbstractDiagramSyncTest extends AbstractPapyrusTest {
	@Rule
	public final HouseKeeper houseKeeper = new HouseKeeper();

	@Rule
	public final AnnotationRule<Boolean> needUIEvents = AnnotationRule.createExists(NeedsUIEvents.class);

	@Rule
	public final PapyrusEditorFixture editor = new PapyrusEditorFixture();

	@CleanUp
	private ComposedAdapterFactory adapterFactory;

	@Inject
	private AbstractSynchronizeViewsHandler<Diagram, DiagramEditPart> syncHandler;

	public AbstractDiagramSyncTest() {
		super();
	}

	@Before
	public void createAdapterFactory() {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
	}

	@Before
	public void synchronizeActiveDiagram() {
		syncHandler.synchronize(Collections.singleton(getDiagramEditPart()));
		waitForUIEvents();
	}

	protected DiagramEditPart getDiagramEditPart() {
		return editor.getActiveDiagramEditor().getDiagramEditPart();
	}

	protected TreeIterator<IGraphicalEditPart> allContents(EditPart root, boolean includeRoot) {
		return TreeIterators.filter(DiagramEditPartsUtil.getAllContents(root, includeRoot), IGraphicalEditPart.class);
	}

	protected IGraphicalEditPart getEditPart(EObject element) {
		return getEditPart(element, getDiagramEditPart());
	}

	protected IGraphicalEditPart getEditPart(EObject element, IGraphicalEditPart scope) {
		IGraphicalEditPart result = null;

		for (Iterator<IGraphicalEditPart> iter = allContents(scope, true); iter.hasNext();) {
			IGraphicalEditPart next = iter.next();
			View view = next.getNotationView();
			if ((view != null) && (view.getElement() == element)) {
				result = next;
				break;
			}
		}

		return result;
	}

	protected IGraphicalEditPart requireEditPart(EObject element) {
		IGraphicalEditPart result = getEditPart(element, getDiagramEditPart());
		assertThat("No edit part for " + label(element), result, notNullValue());
		return result;
	}

	protected IGraphicalEditPart getConnectionEditPart(EObject element) {
		IGraphicalEditPart result = null;

		for (Iterator<IGraphicalEditPart> iter = Iterators.filter(getDiagramEditPart().getConnections().iterator(), IGraphicalEditPart.class); iter.hasNext();) {
			IGraphicalEditPart next = iter.next();
			View view = next.getNotationView();
			if ((view != null) && (view.getElement() == element)) {
				result = next;
				break;
			}
		}

		return result;
	}

	protected IGraphicalEditPart requireConnectionEditPart(EObject element) {
		IGraphicalEditPart result = getConnectionEditPart(element);
		assertThat("No connection edit part for " + label(element), result, notNullValue());
		return result;
	}

	protected View getView(EObject element, View scope) {
		View result = null;

		for (Iterator<View> iter = Iterators.filter(scope.eAllContents(), View.class); (result == null) && iter.hasNext();) {
			View next = iter.next();
			if (next.getElement() == element) {
				result = next;
			}
		}

		return result;
	}

	protected View requireView(EObject element, View scope) {
		View result = getView(element, scope);
		assertThat("View not found: " + label(element), result, notNullValue());
		return result;
	}

	protected Shape getShape(EObject element, View scope) {
		Shape result = null;

		for (Iterator<Shape> iter = Iterators.filter(scope.eAllContents(), Shape.class); (result == null) && iter.hasNext();) {
			Shape next = iter.next();
			if (next.getElement() == element) {
				result = next;
			}
		}

		return result;
	}

	protected Shape requireShape(EObject element, View scope) {
		Shape result = getShape(element, scope);
		assertThat("Shape not found: " + label(element), result, notNullValue());
		return result;
	}

	protected void assertNoView(EObject element, View scope) {
		View view = getView(element, scope);
		assertThat("View exists: " + label(element), view, nullValue());
	}

	protected <T extends DirectedRelationship> T getRelationship(NamedElement from, NamedElement to, Class<T> type) {
		T result = null;

		for (T next : Iterables.filter(from.getSourceDirectedRelationships(), type)) {
			if (next.getTargets().contains(to)) {
				result = next;
				break;
			}
		}

		return result;
	}

	protected void execute(ICommand command) {
		execute(GMFtoEMFCommandWrapper.wrap(command));
	}

	protected void execute(Command command) {
		execute(GEFtoEMFCommandWrapper.wrap(command));
	}

	protected void execute(org.eclipse.emf.common.command.Command command) {
		assertThat("Cannot execute command", command.canExecute(), is(true));
		editor.getEditingDomain().getCommandStack().execute(command);
		waitForUIEvents();
	}

	protected final void waitForUIEvents() {
		// If we're running the tests in the IDE, we should see what's happening. Or, it could be that a
		// particular test actually needs UI events to be processed before proceeding
		if (!JUnitUtils.isAutomatedBuildExecution() || isNeedUIEvents()) {
			editor.flushDisplayEvents();
		}
	}

	protected final boolean isNeedUIEvents() {
		return needUIEvents.get();
	}

	protected void execute(final Runnable writeOperation) {
		execute(new RecordingCommand(editor.getEditingDomain()) {

			@Override
			protected void doExecute() {
				writeOperation.run();
			}
		});
	}

	protected <V> V execute(final Callable<V> writeOperation) {
		final FutureTask<V> result = new FutureTask<>(writeOperation);
		execute(result);
		return Futures.getUnchecked(result);
	}

	protected void undo() {
		CommandStack stack = editor.getEditingDomain().getCommandStack();
		assertThat("Cannot undo", stack.canUndo(), is(true));
		stack.undo();
		waitForUIEvents();
	}

	protected void redo() {
		CommandStack stack = editor.getEditingDomain().getCommandStack();
		assertThat("Cannot redo", stack.canRedo(), is(true));
		stack.redo();
		waitForUIEvents();
	}

	/**
	 * Creates a new semantic element in the model with its notation view.
	 */
	protected <T extends EObject> T createWithView(EObject owner, EClass metaclass, Class<T> type) {
		IGraphicalEditPart editPart = requireEditPart(owner);

		Command command = findNodeCreationCommand(editPart, owner, metaclass,
				((Predicate<IElementType>) UMLElementTypes::isKnownElementType).or(
						org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes::isKnownElementType));
		assertThat("No executable command provided to create " + label(metaclass), command, notNullValue());
		execute(command);

		return getNewObject(command, type);
	}

	private Command findNodeCreationCommand(EditPart editPart, EObject owner, EClass metaclass, Predicate<IElementType> isKnown) {
		Command result = null;

		for (IElementType next : getDiagramElementTypes(metaclass, isKnown)) {
			Command command = getNodeCreationCommand(editPart, owner, next);
			if ((command != null) && command.canExecute()) {
				result = command;
				break;
			}
		}

		return result;
	}

	private Command getNodeCreationCommand(EditPart editPart, EObject owner, IElementType elementType) {
		CreateElementRequestAdapter adapter = new CreateElementRequestAdapter(new CreateElementRequest(owner, elementType));
		String hint = (elementType instanceof IHintedType) ? ((IHintedType) elementType).getSemanticHint() : null;
		CreateViewAndElementRequest.ViewAndElementDescriptor descriptor = new CreateViewAndElementRequest.ViewAndElementDescriptor(adapter, Node.class, hint, editor.getPreferencesHint());
		CreateViewAndElementRequest request = new CreateViewAndElementRequest(descriptor);

		EditPart targetEditPart = editPart.getTargetEditPart(request);
		return targetEditPart.getCommand(request);
	}

	private List<? extends IElementType> getDiagramElementTypes(EClass metaclass, Predicate<IElementType> isKnown) {
		List<IElementType> result = Lists.newArrayListWithExpectedSize(3);
		IElementType base = ElementTypeRegistry.getInstance().getElementType(metaclass, ElementTypeUtils.getEditContext());

		// Filter for class diagram types matching the exact metaclass (e.g., no Usage for Dependency or Port for Property)
		for (IElementType next : ElementTypeRegistry.getInstance().getSpecializationsOf(base.getId())) {
			if ((next.getEClass() == metaclass) && isKnown.test(next)) {
				result.add(next);
			}
		}

		return result;
	}

	private <T extends EObject> T getNewObject(Command command, Class<T> type) {
		Iterator<ICommandProxy> proxies = Iterators.filter(leafCommands(command), ICommandProxy.class);

		Object adapter = Iterators.find(Iterators.transform(proxies, new Function<ICommandProxy, Object>() {
			@Override
			public Object apply(ICommandProxy input) {
				CommandResult result = input.getICommand().getCommandResult();
				Object resultValue = (result == null) ? null : result.getReturnValue();
				if (resultValue instanceof Iterable<?>) {
					for (Object next : (Iterable<?>) resultValue) {
						resultValue = AdapterUtils.adapt(next, EObject.class, null);
						if (resultValue != null) {
							break;
						}
					}
				} else {
					resultValue = AdapterUtils.adapt(resultValue, EObject.class, null);
				}
				return resultValue;
			}
		}), Predicates.notNull());

		T result;

		EObject eObject = AdapterUtils.adapt(adapter, EObject.class, null);
		if (eObject instanceof View) {
			result = type.cast(((View) eObject).getElement());
		} else {
			result = type.cast(eObject);
		}

		return result;
	}

	private Iterator<Command> leafCommands(Command command) {
		return new AbstractTreeIterator<Command>(command, true) {
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("unchecked")
			@Override
			protected Iterator<? extends Command> getChildren(Object object) {
				if (object instanceof CompoundCommand) {
					return ((Iterable<? extends Command>) ((CompoundCommand) object).getCommands()).iterator();
				} else {
					return Collections.emptyIterator();
				}
			}
		};
	}

	/**
	 * Creates a new dependency in the model with its notation view.
	 */
	protected Dependency createDependencyWithView(NamedElement client, NamedElement supplier) {
		EditPart sourceEditPart = requireEditPart(client);
		EditPart targetEditPart = requireEditPart(supplier);

		Command command = findConnectionCreationCommand(sourceEditPart, targetEditPart,
				UMLPackage.Literals.DEPENDENCY, UMLElementTypes::isKnownElementType);

		assertThat("No executable command provided to create dependency", command, notNullValue());
		execute(command);

		return getNewObject(command, Dependency.class);
	}

	private Command findConnectionCreationCommand(EditPart sourceEditPart, EditPart targetEditPart, EClass metaclass, Predicate<IElementType> isKnown) {
		Command result = null;

		for (IElementType next : getDiagramElementTypes(metaclass, isKnown)) {
			Command command = getConnectionCreationCommand(sourceEditPart, targetEditPart, next);
			if ((command != null) && command.canExecute()) {
				result = command;
				break;
			}
		}

		return result;
	}

	private Command getConnectionCreationCommand(EditPart sourceEditPart, EditPart targetEditPart, IElementType elementType) {
		Command result = null;

		String hint = (elementType instanceof IHintedType) ? ((IHintedType) elementType).getSemanticHint() : null;
		// Don't attempt to create relationship "nodes" like the DependencyNode or AssociationNode
		if ((hint != null) && Integer.parseInt(hint) >= 4000) {
			CreateConnectionViewAndElementRequest request = new CreateConnectionViewAndElementRequest(elementType, hint, editor.getPreferencesHint());
			request.setType(RequestConstants.REQ_CONNECTION_START);
			request.setLocation(new Point(0, 0));

			Command command = sourceEditPart.getCommand(request);
			if ((command != null) && command.canExecute()) {
				request.setSourceEditPart(sourceEditPart);
				request.setTargetEditPart(targetEditPart);
				request.setType(RequestConstants.REQ_CONNECTION_END);
				request.setLocation(new Point(0, 0));

				result = targetEditPart.getCommand(request);
			}
		}

		return result;
	}

	/**
	 * Creates a new final state in the model with its notation view.
	 */
	protected FinalState createFinalStateWithView(Region container, String name) {
		EditPart regionEditPart = requireEditPart(container);
		EditPart contentsEditPart = getShapeCompartment(regionEditPart);

		Command createCommand = findNodeCreationCommand(contentsEditPart, container,
				UMLPackage.Literals.FINAL_STATE,
				org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes::isKnownElementType);

		assertThat("No executable command provided to create final state", createCommand, notNullValue());

		return create(FinalState.class, createCommand, name);
	}

	protected EditPart getShapeCompartment(EditPart parent) {
		return select(((List<?>) parent.getChildren()).stream(), ShapeCompartmentEditPart.class)
				.findAny().orElse(null);
	}

	/**
	 * Creates a new transition in the model with its notation view.
	 */
	protected Transition createTransitionWithView(Vertex source, Vertex target, String name) {
		EditPart sourceEditPart = requireEditPart(source);
		EditPart targetEditPart = requireEditPart(target);

		Command createCommand = findConnectionCreationCommand(sourceEditPart, targetEditPart,
				UMLPackage.Literals.TRANSITION,
				org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes::isKnownElementType);

		assertThat("No executable command provided to create transition", createCommand, notNullValue());

		return create(Transition.class, createCommand, name);
	}

	/**
	 * Uses the edit-service {@linkplain #DestroyElementRequest destroy} command to effect deletion of the semantic {@code element} and all of its views.
	 */
	protected void removeWithView(EObject element) {
		IElementEditService service = ElementEditServiceUtils.getCommandProvider(element.eContainer());
		ICommand command = service.getEditCommand(new DestroyElementRequest(element, false));
		assertThat("No command provided to delete " + label(element), command, notNullValue());
		assertThat("Cannot execute command to delete " + label(element), command.canExecute(), is(true));
		execute(command);
	}

	protected void delete(EditPart editPart) {
		Command command = editPart.getCommand(new GroupRequest(RequestConstants.REQ_DELETE));
		assertThat("No view deletion command provided", command, notNullValue());
		assertThat("Cannot execute view deletion command", command.canExecute(), is(true));
		execute(command);
	}

	protected String label(EObject object) {
		String result;

		if (object instanceof ENamedElement) {
			result = ((UMLUtil.getQualifiedName((ENamedElement) object, NamedElement.SEPARATOR)));
		} else if (object != null) {
			IItemLabelProvider labels = (IItemLabelProvider) adapterFactory.adapt(object, IItemLabelProvider.class);
			result = (labels == null) ? String.valueOf(object) : labels.getText(object);
		} else {
			result = String.valueOf(object);
		}

		return result;
	}

	protected View getView(EObject object) {
		IGraphicalEditPart editPart = getEditPart(object);
		if (editPart == null) {
			// Maybe it's an edge
			editPart = getConnectionEditPart(object);
		}
		return (editPart == null) ? null : editPart.getNotationView();
	}

	protected View requireView(EObject object) {
		View result = getView(object);
		assertThat("No view for " + label(object), result, notNullValue());
		return result;
	}

	protected Shape getShape(EObject object) {
		IGraphicalEditPart result = null;
		IGraphicalEditPart editPart = getEditPart(object);
		if ((editPart != null) && (editPart.getNotationView() instanceof Shape)) {
			result = editPart;
		}
		return (result == null) ? null : (Shape) result.getNotationView();
	}

	protected Shape requireShape(EObject object) {
		View result = getView(object);
		assertThat("No shape for " + label(object), result, notNullValue());
		assertThat("Not a shape node for " + label(object), result, instanceOf(Shape.class));
		return (Shape) result;
	}

	protected Edge requireEdge(View oneEnd, View otherEnd) {
		Edge result = getEdge(oneEnd, otherEnd);
		assertThat("No edge between " + label(oneEnd) + " and " + label(otherEnd), result, notNullValue());
		return result;
	}

	protected Edge getEdge(View oneEnd, View otherEnd) {
		Edge result = null;

		for (Edge next : Iterables.filter(oneEnd.getSourceEdges(), Edge.class)) {
			if (next.getTarget() == otherEnd) {
				result = next;
				break;
			}
		}

		if (result == null) {
			// Try the other way around
			for (Edge next : Iterables.filter(oneEnd.getTargetEdges(), Edge.class)) {
				if (next.getSource() == otherEnd) {
					result = next;
					break;
				}
			}
		}

		return result;
	}

	protected void assertNoView(EObject object) {
		View view = getView(object);
		assertThat("View exists for " + label(object), view, nullValue());
	}

	protected void assumeNoView(EObject object) {
		View view = getView(object);
		assumeThat("View exists for " + label(object), view, nullValue());
	}

	protected Map<EObject, View> getViews(Iterable<? extends EObject> objects) {
		Map<EObject, View> result = Maps.newHashMap();

		for (EObject object : objects) {
			IGraphicalEditPart editPart = getEditPart(object);
			if (editPart == null) {
				// Maybe it's an edge
				editPart = getConnectionEditPart(object);
			}
			if ((editPart != null) && (editPart.getNotationView() != null)) {
				result.put(object, editPart.getNotationView());
			}
		}

		return result;
	}

	protected Map<EObject, View> getViews(EObject first, EObject second, EObject... rest) {
		return getViews(Lists.asList(first, second, rest));
	}

	protected Map<EObject, View> requireViews(Iterable<? extends EObject> objects) {
		Map<EObject, View> result = Maps.newHashMap();

		for (EObject object : objects) {
			result.put(object, requireView(object));
		}

		return result;
	}

	protected Map<EObject, View> requireViews(EObject first, EObject second, EObject... rest) {
		return requireViews(Lists.asList(first, second, rest));
	}

	protected void assertNoViews(Iterable<? extends EObject> objects) {
		Map<EObject, View> views = getViews(objects);

		if (!views.isEmpty()) {
			fail("View exists for " + label(Iterables.getFirst(views.keySet(), null)));
		}
	}

	protected void assertNoViews(EObject first, EObject second, EObject... rest) {
		assertNoViews(Lists.asList(first, second, rest));
	}

	protected void assertAttached(EObject element) {
		assertThat("Model does not contain " + label(element), element.eResource(), notNullValue());
	}

	protected void assertAttached(Iterable<? extends EObject> elements) {
		for (EObject next : elements) {
			assertAttached(next);
		}
	}

	protected void assertAttached(EObject first, EObject second, EObject... rest) {
		assertAttached(Lists.asList(first, second, rest));
	}

	protected void assertDetached(EObject element) {
		assertThat("Model must not contain " + label(element), element.eResource(), nullValue());
	}

	protected void assertDetached(Iterable<? extends EObject> elements) {
		for (EObject next : elements) {
			assertDetached(next);
		}
	}

	protected void assertDetached(EObject first, EObject second, EObject... rest) {
		assertDetached(Lists.asList(first, second, rest));
	}

	protected void assumeDetached(EObject element) {
		assumeThat("Model must not contain " + label(element), element.eResource(), nullValue());
	}

	protected <E extends NamedElement> E create(Class<E> resultType, Command creationCommand, String name) {
		CreateAndConfigureCommand<E> command = new CreateAndConfigureCommand<>(resultType, creationCommand,
				newObject -> SetCommand.create(editor.getEditingDomain(), newObject, UMLPackage.Literals.NAMED_ELEMENT__NAME, name));

		execute(command);

		return command.getNewObject();
	}

	//
	// Nested types
	//

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.TYPE, ElementType.METHOD })
	protected @interface NeedsUIEvents {
		// Empty
	}

	public class CreateAndConfigureCommand<E extends EObject> extends org.eclipse.emf.common.command.CompoundCommand {
		private final Command creationCommand;
		private final Class<E> resultType;
		private final Function<? super E, org.eclipse.emf.common.command.Command> configureCommandFunction;

		public CreateAndConfigureCommand(Class<E> resultType, Command creationCommand, Function<? super E, org.eclipse.emf.common.command.Command> configureCommandFunction) {
			super(org.eclipse.emf.common.command.CompoundCommand.LAST_COMMAND_ALL, creationCommand.getLabel());

			this.creationCommand = creationCommand;
			this.resultType = resultType;
			this.configureCommandFunction = configureCommandFunction;

			append(GEFtoEMFCommandWrapper.wrap(creationCommand));
		}

		public E getNewObject() {
			return StreamUtil.select(getResult().stream(), resultType).findFirst().orElse(null);
		}

		@Override
		protected boolean prepare() {
			boolean result = super.prepare();

			if (result) {
				append(new CommandWrapper() {

					E newObject;

					@Override
					public boolean canExecute() {
						return true;
					}

					@Override
					public void execute() {
						assertThat(prepare(), is(true));
						super.execute();
					}

					@Override
					protected org.eclipse.emf.common.command.Command createCommand() {
						newObject = AbstractDiagramSyncTest.this.getNewObject(creationCommand, resultType);

						return createConfigureCommand(newObject);
					}

					@Override
					public Collection<?> getResult() {
						return Collections.singletonList(newObject);
					}
				});
			}

			return result;
		}

		protected org.eclipse.emf.common.command.Command createConfigureCommand(E newObject) {
			return configureCommandFunction.apply(newObject);
		}
	}
}
