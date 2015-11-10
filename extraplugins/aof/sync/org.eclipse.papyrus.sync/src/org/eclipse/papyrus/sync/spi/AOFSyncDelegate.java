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

package org.eclipse.papyrus.sync.spi;

import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.IMappingInstance;
import org.eclipse.papyrus.aof.sync.MappingFactory;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingModel;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingPackage;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.IModelSnippet;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ResourceAdapter;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.tools.util.StreamUtil;
import org.eclipse.papyrus.sync.ISyncListener;
import org.eclipse.papyrus.sync.ISyncMappingModel;
import org.eclipse.papyrus.sync.SyncEvent;
import org.eclipse.papyrus.sync.internal.Activator;

/**
 * Partial implementation of synchronization service delegate that uses AOF
 * {@linkplain IMapping mappings} to synchronize model elements. Crucially, it
 * provides {@linkplain #doDiscoverInitialSynchronizations(Iterable) a hook} by
 * which concrete subclasses may discover model elements that should initially
 * or implicitly be synchronized.
 */
public abstract class AOFSyncDelegate implements ISyncDelegate {

	private final Set<IMappingInstance<?, ?>> mappings = new HashSet<>();

	private MappingFactory mappingFactory;

	private ModelSet modelSet;

	private MappingModel mappingModel;
	private Adapter mappingModelAdapter;

	private final CopyOnWriteArrayList<ISyncListener> listeners = new CopyOnWriteArrayList<>();

	public AOFSyncDelegate() {
		super();
	}

	@Override
	public boolean canSynchronize(Object source, Object target) {
		boolean result = false;

		if ((source instanceof EObject) && (target instanceof EObject)) {
			Type sourceType = ((EObject) source).eClass().getInstanceClass();
			Type targetType = ((EObject) target).eClass().getInstanceClass();

			result = (sourceType != null) && (targetType != null) && mappingFactory.hasMapping(sourceType, targetType);
		}

		return result;
	}

	@Override
	public IMappingInstance<?, ?> synchronize(Object source, Object target) {
		EObject eSource = (EObject) source;
		EObject eTarget = (EObject) target;

		@SuppressWarnings("unchecked")
		Class<? extends EObject> sourceType = (Class<? extends EObject>) eSource.eClass().getInstanceClass();
		@SuppressWarnings("unchecked")
		Class<? extends EObject> targetType = (Class<? extends EObject>) eTarget.eClass().getInstanceClass();

		return synchronize(eSource, sourceType, eTarget, targetType);
	}

	protected <F extends EObject, T extends EObject> IMappingInstance<F, T> synchronize(F source,
			Class<? extends F> sourceType, T target, Class<? extends T> targetType) {

		IMapping<F, T> mapping = mappingFactory.getMapping(sourceType, targetType);

		IMappingInstance<F, T> result = mapping.map(source, target);
		getMappings().add(result);
		mappingModel.getInstances().add(result);

		return result;
	}

	@Override
	public Collection<?> getSynchronizationReferences() {
		return Collections.unmodifiableCollection(getMappings());
	}

	protected Collection<IMappingInstance<?, ?>> getMappings() {
		return mappings;
	}

	@Override
	public boolean provides(Object synchronizationReference) {
		return (synchronizationReference instanceof IMappingInstance<?, ?>)
				&& getMappings().contains(synchronizationReference);
	}

	protected final IMappingInstance<?, ?> requireMappingInstance(Object synchReference) {
		if (!(synchReference instanceof IMappingInstance<?, ?>)) {
			throw new IllegalArgumentException("synchReference is not a mapping instance"); //$NON-NLS-1$
		}

		return (IMappingInstance<?, ?>) synchReference;
	}

	@Override
	public Object getSource(Object synchReference) {
		return requireMappingInstance(synchReference).getLeft().get();
	}

	@Override
	public Object getTarget(Object synchReference) {
		return requireMappingInstance(synchReference).getRight().get();
	}

	@Override
	public boolean unsynchronize(Object synchReference) {
		requireMappingInstance(synchReference).destroy();

		return true;
	}

	protected abstract MappingFactory createMappingFactory(ServicesRegistry serviceRegistry);

	protected final MappingFactory getMappingFactory() {
		return mappingFactory;
	}

	@Override
	public void install(ServicesRegistry serviceRegistry) throws ServiceException {
		mappingFactory = createMappingFactory(serviceRegistry);

		modelSet = ServiceUtils.getInstance().getModelSet(serviceRegistry);

		ISyncMappingModel.getInstance(modelSet).addModelSnippet(new IModelSnippet() {

			@Override
			public void start(IModel startingModel) {
				mappingModel = ISyncMappingModel.getInstance(modelSet).getMappingModel();
				if (mappingModel != null) {
					mappingModelAdapter = new MappingModelAdapter();
					mappingModel.eAdapters().add(mappingModelAdapter);

					modelSet.eAdapters().add(new ResourceAdapter() {
						@Override
						protected void handleResourceLoaded(Resource resource) {
							discoverInitialSynchronizations(resource.getContents());
						}

						@Override
						protected void handleRootAdded(Resource resource, EObject root) {
							discoverInitialSynchronizations(Collections.singleton(root));
						}
					});
				}
			}

			@Override
			public void dispose(IModel stoppingModel) {
				// The mappingModel could be null if we never started this
				// snippet (which does legitimately happen)
				if (mappingModel != null) {
					mappingModel.eAdapters().remove(mappingModelAdapter);
					mappingModelAdapter = null;
				}

				getMappings().clear();

				mappingModel = null;
			}
		});
	}

	protected TransactionalEditingDomain getEditingDomain() {
		return modelSet.getTransactionalEditingDomain();
	}

	protected final void discoverInitialSynchronizations(Iterable<?> scope) {
		InternalTransactionalEditingDomain domain = (InternalTransactionalEditingDomain) getEditingDomain();

		try {
			Transaction transaction = domain.startTransaction(false,
					Collections.singletonMap(Transaction.OPTION_UNPROTECTED, true));
			try {
				doDiscoverInitialSynchronizations(scope);
			} finally {
				transaction.commit();
			}
		} catch (RollbackException | InterruptedException e) {
			Activator.log.error("Failed to start transaction for initial synchronizations", e); //$NON-NLS-1$
		}
	}

	protected void doDiscoverInitialSynchronizations(Iterable<?> scope) {
		// Pass
	}

	protected ModelVisitorBuilder visitor(Iterable<?> scope) {
		return new ModelVisitorBuilder(scope);
	}

	@Override
	public void uninstall(ServicesRegistry serviceRegistry) throws ServiceException {
		modelSet = null;
	}

	@Override
	public void addSyncListener(ISyncListener listener) {
		listeners.addIfAbsent(listener);
	}

	@Override
	public void removeSyncListener(ISyncListener listener) {
		listeners.remove(listener);
	}

	protected void fireSynchronizationAdded(IMappingInstance<?, ?> mappingInstance) {
		if (!listeners.isEmpty()) {
			fireSynchronizationChanged(new SyncEvent(SyncEvent.SyncEventKind.SYNCHRONIZATION_ADDED, this,
					mappingInstance, mappingInstance.getLeft().get(), mappingInstance.getRight().get()));
		}
	}

	protected void fireSynchronizationRemoved(IMappingInstance<?, ?> mappingInstance) {
		if (!listeners.isEmpty()) {
			fireSynchronizationChanged(new SyncEvent(SyncEvent.SyncEventKind.SYNCHRONIZATION_REMOVED, this,
					mappingInstance, mappingInstance.getLeft().get(), mappingInstance.getRight().get()));
		}
	}

	private void fireSynchronizationChanged(SyncEvent event) {
		listeners.forEach(l -> {
			try {
				l.synchronizationChanged(event);
			} catch (Exception e) {
				Activator.log.error("Uncaught exception in synchronization listener.", e); //$NON-NLS-1$
			}
		});
	}

	//
	// Nested types
	//

	protected static class ModelVisitorBuilder {
		private final Collection<?> scope;
		private final Map<EClass, Consumer<?>> visitors = new HashMap<>();

		ModelVisitorBuilder(Iterable<?> scope) {
			super();

			this.scope = StreamUtil.asStream(scope.iterator()).collect(Collectors.toList());
		}

		public <T extends EObject> ModelVisitorBuilder addVisitor(EClass eclass, Consumer<? super T> visitor) {
			visitors.put(eclass, visitor);
			return this;
		}

		public void walkModel() {
			for (Iterator<?> iter = EcoreUtil.getAllContents(scope); iter.hasNext();) {
				Object next = iter.next();

				if (next instanceof EObject) {
					EObject eObject = (EObject) next;
					getVisitor(eObject).accept(eObject);
				}
			}
		}

		private Consumer<? super EObject> getVisitor(EObject eObject) {
			EClass eclass = eObject.eClass();
			Consumer<?> result = visitors.get(eclass);

			if (result == null) {
				// Breadth-first search of the hierarchy to find the best
				// matching eclass
				Queue<EClass> bfs = new ArrayDeque<EClass>(eclass.getESuperTypes());
				for (EClass next = bfs.poll(); (result == null) && (next != null); next = bfs.poll()) {
					result = visitors.get(next);
					if (result != null) {
						bfs.addAll(next.getESuperTypes());
					}
				}

				if (result == null) {
					result = o -> {
					}; // No-op
				}

				visitors.put(eclass, result);
			}

			@SuppressWarnings("unchecked")
			Consumer<? super EObject> result_ = (Consumer<? super EObject>) result;
			return result_;
		}
	}

	private class MappingModelAdapter extends AdapterImpl {
		@Override
		public void notifyChanged(Notification msg) {
			if (!msg.isTouch() && (msg.getFeature() == SyncMappingPackage.Literals.MAPPING_MODEL__INSTANCE)) {
				switch (msg.getEventType()) {
				case Notification.ADD:
					if (getMappings().contains(msg.getNewValue())) {
						fireSynchronizationAdded((IMappingInstance<?, ?>) msg.getNewValue());
					}
					break;
				case Notification.ADD_MANY:
					@SuppressWarnings("unchecked")
					Collection<? extends IMappingInstance<?, ?>> newValues = (Collection<? extends IMappingInstance<?, ?>>) msg
							.getNewValue();
					for (IMappingInstance<?, ?> next : newValues) {
						if (getMappings().contains(next)) {
							fireSynchronizationAdded(next);
						}
					}
					break;
				case Notification.REMOVE:
					if (getMappings().remove(msg.getOldValue())) {
						fireSynchronizationRemoved((IMappingInstance<?, ?>) msg.getOldValue());
					}
					break;
				case Notification.REMOVE_MANY:
					@SuppressWarnings("unchecked")
					Collection<? extends IMappingInstance<?, ?>> oldValues = (Collection<? extends IMappingInstance<?, ?>>) msg
							.getOldValue();
					for (IMappingInstance<?, ?> next : oldValues) {
						if (getMappings().remove(next)) {
							fireSynchronizationRemoved(next);
						}
					}
					break;
				case Notification.SET:
				case Notification.UNSET:
					if (getMappings().remove(msg.getOldValue())) {
						fireSynchronizationRemoved((IMappingInstance<?, ?>) msg.getOldValue());
					}
					if (getMappings().contains(msg.getNewValue())) {
						fireSynchronizationAdded((IMappingInstance<?, ?>) msg.getNewValue());
					}
					break;
				}
			}
		}
	}
}
