package org.eclipse.papyrus.aof.emf.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.impl.utils.cache.IUnaryCache;
import org.eclipse.papyrus.aof.core.impl.utils.cache.WeakKeysWeakValuesUnaryCache;
import org.eclipse.papyrus.aof.emf.EMFFactory;

public class PropertyAccessor<B,C extends EObject> implements IUnaryFunction<C, IBox<B>> {

	private EStructuralFeature feature;

	// cache defined for memory optimization
	private IUnaryCache<EObject, IBox<B>> cache = new WeakKeysWeakValuesUnaryCache<EObject, IBox<B>>();

	public PropertyAccessor(EStructuralFeature feature) {
		this.feature = feature;
	}

	@Override
	public IBox<B> apply(final C object) {
		IBox<B> result;
		if (object == null) {
			// Create a default box for its constraints (to satisfy CollectBox operation)
			result = EMFFactory.INSTANCE.createBox(new EMFConstraints(feature));
		} else {
			result = cache.get(object);
			if (result == null) {
				FeatureDelegate<B> delegate;
				if (feature.isMany()) {
					delegate = new ListFeatureDelegate<B>(object, feature);
				} else {
					delegate = new GetSetFeatureDelegate<B>(object, feature);
				}

				final IBox<B> box = ((EMFFactory) EMFFactory.INSTANCE).createBox(delegate, delegate);
				cache.put(object, box);

				delegate.onDisposed(new IDisposalDelegate() {
					@Override
					public void onDisposed(FeatureDelegate<?> delegate) {
						// We must not attempt to reuse this delegate, with
						// its now corrupt backing store, in the future
						cache.remove(object, box);
					}
				});

				result = box;
			}
		}
		return result;
	}

}