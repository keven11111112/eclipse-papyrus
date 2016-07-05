/**
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 * Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.propertylifecycle.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.propertylifecycle.BasicTrigger;
import org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.propertylifecycle.BasicTrigger} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class BasicTriggerItemProvider extends AbstractTriggerItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public BasicTriggerItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addOnCreatePropertyDescriptor(object);
			addOnDeletePropertyDescriptor(object);
			addOnOpenPropertyDescriptor(object);
			addOnMovePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the On Create feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addOnCreatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_BasicTrigger_onCreate_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_BasicTrigger_onCreate_feature", "_UI_BasicTrigger_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				PropertylifecyclePackage.Literals.BASIC_TRIGGER__ON_CREATE,
				true,
				false,
				false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the On Delete feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addOnDeletePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_BasicTrigger_onDelete_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_BasicTrigger_onDelete_feature", "_UI_BasicTrigger_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				PropertylifecyclePackage.Literals.BASIC_TRIGGER__ON_DELETE,
				true,
				false,
				false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the On Open feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addOnOpenPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_BasicTrigger_onOpen_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_BasicTrigger_onOpen_feature", "_UI_BasicTrigger_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				PropertylifecyclePackage.Literals.BASIC_TRIGGER__ON_OPEN,
				true,
				false,
				false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This adds a property descriptor for the On Move feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addOnMovePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_BasicTrigger_onMove_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_BasicTrigger_onMove_feature", "_UI_BasicTrigger_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				PropertylifecyclePackage.Literals.BASIC_TRIGGER__ON_MOVE,
				true,
				false,
				false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				null,
				null));
	}

	/**
	 * This returns BasicTrigger.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BasicTrigger")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		BasicTrigger basicTrigger = (BasicTrigger) object;
		return getString("_UI_BasicTrigger_type") + " " + basicTrigger.isOnCreate(); //$NON-NLS-1$ //$NON-NLS-2$
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(BasicTrigger.class)) {
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_CREATE:
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_DELETE:
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_OPEN:
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_MOVE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
