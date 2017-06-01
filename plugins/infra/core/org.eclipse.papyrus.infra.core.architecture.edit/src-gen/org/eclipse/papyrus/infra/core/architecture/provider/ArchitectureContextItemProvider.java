/**
* Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.core.architecture.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureFactory;
import org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ArchitectureContextItemProvider extends ADElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureContextItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addDefaultViewpointsPropertyDescriptor(object);
			addElementTypesPropertyDescriptor(object);
			addExtensionPrefixPropertyDescriptor(object);
			addCreationCommandClassPropertyDescriptor(object);
			addConversionCommandClassPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Default Viewpoints feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultViewpointsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ArchitectureContext_defaultViewpoints_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ArchitectureContext_defaultViewpoints_feature", "_UI_ArchitectureContext_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ArchitecturePackage.Literals.ARCHITECTURE_CONTEXT__DEFAULT_VIEWPOINTS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Element Types feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addElementTypesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ArchitectureContext_elementTypes_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ArchitectureContext_elementTypes_feature", "_UI_ArchitectureContext_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ArchitecturePackage.Literals.ARCHITECTURE_CONTEXT__ELEMENT_TYPES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Extension Prefix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExtensionPrefixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ArchitectureContext_extensionPrefix_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ArchitectureContext_extensionPrefix_feature", "_UI_ArchitectureContext_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ArchitecturePackage.Literals.ARCHITECTURE_CONTEXT__EXTENSION_PREFIX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Creation Command Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCreationCommandClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ArchitectureContext_creationCommandClass_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ArchitectureContext_creationCommandClass_feature", "_UI_ArchitectureContext_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ArchitecturePackage.Literals.ARCHITECTURE_CONTEXT__CREATION_COMMAND_CLASS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Conversion Command Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConversionCommandClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ArchitectureContext_conversionCommandClass_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ArchitectureContext_conversionCommandClass_feature", "_UI_ArchitectureContext_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ArchitecturePackage.Literals.ARCHITECTURE_CONTEXT__CONVERSION_COMMAND_CLASS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ArchitecturePackage.Literals.ARCHITECTURE_CONTEXT__VIEWPOINTS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ArchitectureContext)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ArchitectureContext_type") : //$NON-NLS-1$
			getString("_UI_ArchitectureContext_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ArchitectureContext.class)) {
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__EXTENSION_PREFIX:
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__CREATION_COMMAND_CLASS:
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__CONVERSION_COMMAND_CLASS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__VIEWPOINTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ArchitecturePackage.Literals.ARCHITECTURE_CONTEXT__VIEWPOINTS,
				 ArchitectureFactory.eINSTANCE.createArchitectureViewpoint()));
	}

}
