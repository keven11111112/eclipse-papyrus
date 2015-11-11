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

package org.eclipse.papyrus.aof.sync;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.stream.StreamSupport;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.papyrus.aof.core.IObserver;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.impl.utils.cache.IBinaryCache;
import org.eclipse.papyrus.aof.core.impl.utils.cache.IUnaryCache;
import org.eclipse.papyrus.aof.core.impl.utils.cache.WeakKeysWeakValuesBinaryCache;
import org.eclipse.papyrus.aof.core.impl.utils.cache.WeakKeysWeakValuesUnaryCache;
import org.eclipse.papyrus.aof.core.utils.ObserverTracker;
import org.eclipse.papyrus.aof.core.utils.Observers;

/**
 * Default implementation of the mapping context protocol.
 */
@Singleton
public class MappingContext implements IMappingContext {

	private final AtomicInteger openDepth = new AtomicInteger();

	private final IBinaryCache<Object, IMapping<?, ?>, IMappingInstance<?, ?>> mappingInstances = new WeakKeysWeakValuesBinaryCache<>();
	private final ThreadLocal<IMappingInstance<?, ?>> currentMappingInstance = new ThreadLocal<>();

	private final IUnaryCache<IObserver<?>, IObserver<?>> observerWrappers = new WeakKeysWeakValuesUnaryCache<>();

	private final IMappingProvider provider;

	@Inject
	public MappingContext(IMappingProvider provider) {
		super();

		this.provider = provider;
	}

	@Override
	public void open() {
		openDepth.incrementAndGet();

		IMappingInstance<?, ?> context = currentMappingInstance.get();
		Observers.pushObserverIntercept((IObserver<?> o) -> wrapObserver(o, context));
	}

	@Override
	public boolean isOpen() {
		return openDepth.get() > 0;
	}

	@Override
	public void close() {
		if (openDepth.decrementAndGet() < 0) {
			// Undo
			openDepth.incrementAndGet();
			throw new IllegalStateException("already closed"); //$NON-NLS-1$
		}

		Observers.popObserverIntercept();
	}

	@Override
	public IMappingProvider getMappingProvider() {
		return provider;
	}

	@Override
	public <F, T> ObserverTracker run(IMappingInstance<F, T> instance, BiConsumer<? super IOne<F>, ? super IOne<T>> block) {
		ObserverTracker result;

		// Remember this instance for later ad hoc consequents
		mappingInstances.put(instance.getRight().get(), instance.getType(), instance);

		IMappingInstance<?, ?> parent = currentMappingInstance.get();
		if (parent != null) {
			parent.addConsequent(instance);
		} else {
			currentMappingInstance.set(instance);
		}

		try {
			result = run(instance.getLeft(), instance.getRight(), block);
		} finally {
			if (parent == null) {
				currentMappingInstance.remove();
			}
		}

		return result;
	}

	private <E> IObserver<? super E> wrapObserver(IObserver<E> observer, IMappingInstance<?, ?> context) {
		@SuppressWarnings("unchecked")
		IObserver<? super E> result = (IObserver<? super E>) observerWrappers.get(observer);

		if (result == null) {
			result = new ContextualObserver<E>(observer, context);
			observerWrappers.put(observer, result);
		}

		return result;
	}

	@Override
	public <T> Iterable<IMappingInstance<?, ? super T>> getMappingInstances(T target) {
		return new Iterable<IMappingInstance<?, ? super T>>() {
			@Override
			public Iterator<IMappingInstance<?, ? super T>> iterator() {
				@SuppressWarnings({ "unchecked", "rawtypes" })
				Iterator<IMappingInstance<?, ? super T>> result = (Iterator) StreamSupport.stream(mappingInstances.get(target).spliterator(), false)
						.map(Map.Entry::getValue)
						.iterator();
				return result;
			}
		};
	}

	@Override
	public boolean isSuppressAutoDisableHooks() {
		return false;
	}

	//
	// Nested types
	//

	private class ContextualObserver<E> implements IObserver<E> {
		private final IObserver<E> delegate;
		private final IMappingInstance<?, ?> context;

		ContextualObserver(IObserver<E> observer, IMappingInstance<?, ?> context) {
			super();

			this.delegate = observer;
			this.context = context;
		}

		@Override
		public boolean isDisabled() {
			return delegate.isDisabled();
		}

		@Override
		public void setDisabled(boolean disabled) {
			delegate.setDisabled(disabled);
		}

		@Override
		public void added(int index, E element) {
			IMappingInstance<?, ?> restore = pushContext();
			try {
				delegate.added(index, element);
			} finally {
				popContext(restore);
			}
		}

		@Override
		public void removed(int index, E element) {
			IMappingInstance<?, ?> restore = pushContext();
			try {
				delegate.removed(index, element);
			} finally {
				popContext(restore);
			}
		}

		@Override
		public void replaced(int index, E newElement, E oldElement) {
			IMappingInstance<?, ?> restore = pushContext();
			try {
				delegate.replaced(index, newElement, oldElement);
			} finally {
				popContext(restore);
			}
		}

		@Override
		public void moved(int newIndex, int oldIndex, E element) {
			IMappingInstance<?, ?> restore = pushContext();
			try {
				delegate.moved(newIndex, oldIndex, element);
			} finally {
				popContext(restore);
			}
		}

		private IMappingInstance<?, ?> pushContext() {
			IMappingInstance<?, ?> result = currentMappingInstance.get();
			currentMappingInstance.set(context);
			return result;
		}

		private void popContext(IMappingInstance<?, ?> restore) {
			currentMappingInstance.set(restore);
		}
	}
}
