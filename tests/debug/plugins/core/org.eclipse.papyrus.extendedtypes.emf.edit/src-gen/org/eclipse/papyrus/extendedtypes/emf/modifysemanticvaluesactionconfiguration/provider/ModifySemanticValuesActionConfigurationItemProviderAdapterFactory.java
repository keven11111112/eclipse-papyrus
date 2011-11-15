/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.extendedtypes.emf.modifysemanticvaluesactionconfiguration.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.util.ModifySemanticValuesActionConfigurationAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ModifySemanticValuesActionConfigurationItemProviderAdapterFactory extends ModifySemanticValuesActionConfigurationAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifySemanticValuesActionConfigurationItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfiguration} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifySemanticValuesActionConfigurationItemProvider modifySemanticValuesActionConfigurationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createModifySemanticValuesActionConfigurationAdapter() {
		if (modifySemanticValuesActionConfigurationItemProvider == null) {
			modifySemanticValuesActionConfigurationItemProvider = new ModifySemanticValuesActionConfigurationItemProvider(this);
		}

		return modifySemanticValuesActionConfigurationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.extendedtypes.emf.modifysemanticvaluesactionconfiguration.FeatureToSet} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureToSetItemProvider featureToSetItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.extendedtypes.emf.modifysemanticvaluesactionconfiguration.FeatureToSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFeatureToSetAdapter() {
		if (featureToSetItemProvider == null) {
			featureToSetItemProvider = new FeatureToSetItemProvider(this);
		}

		return featureToSetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.extendedtypes.emf.modifysemanticvaluesactionconfiguration.DynamicValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DynamicValueItemProvider dynamicValueItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.extendedtypes.emf.modifysemanticvaluesactionconfiguration.DynamicValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDynamicValueAdapter() {
		if (dynamicValueItemProvider == null) {
			dynamicValueItemProvider = new DynamicValueItemProvider(this);
		}

		return dynamicValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ConstantValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstantValueItemProvider constantValueItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ConstantValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConstantValueAdapter() {
		if (constantValueItemProvider == null) {
			constantValueItemProvider = new ConstantValueItemProvider(this);
		}

		return constantValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ListValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ListValueItemProvider listValueItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ListValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createListValueAdapter() {
		if (listValueItemProvider == null) {
			listValueItemProvider = new ListValueItemProvider(this);
		}

		return listValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.extendedtypes.emf.modifysemanticvaluesactionconfiguration.QueryExecutionValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QueryExecutionValueItemProvider queryExecutionValueItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.extendedtypes.emf.modifysemanticvaluesactionconfiguration.QueryExecutionValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createQueryExecutionValueAdapter() {
		if (queryExecutionValueItemProvider == null) {
			queryExecutionValueItemProvider = new QueryExecutionValueItemProvider(this);
		}

		return queryExecutionValueItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (modifySemanticValuesActionConfigurationItemProvider != null) modifySemanticValuesActionConfigurationItemProvider.dispose();
		if (featureToSetItemProvider != null) featureToSetItemProvider.dispose();
		if (dynamicValueItemProvider != null) dynamicValueItemProvider.dispose();
		if (constantValueItemProvider != null) constantValueItemProvider.dispose();
		if (listValueItemProvider != null) listValueItemProvider.dispose();
		if (queryExecutionValueItemProvider != null) queryExecutionValueItemProvider.dispose();
	}

}
