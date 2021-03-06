/*******************************************************************************
 * Copyright (c) 2005, 2020 Borland Software Corporation, CEA LIST, ARTAL
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 * 
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     Borland - initial API and implementation
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.gmf.mappings.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.gmf.mappings.GMFMapFactory;
import org.eclipse.papyrus.gmf.mappings.GMFMapPackage;
import org.eclipse.papyrus.gmf.mappings.MappingEntry;
import org.eclipse.papyrus.gmf.mappings.presentation.FilterUtil;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.gmf.mappings.MappingEntry} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MappingEntryItemProvider
	extends ItemProviderAdapter
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingEntryItemProvider(AdapterFactory adapterFactory) {
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

			addDomainMetaElementPropertyDescriptor(object);
			addRelatedDiagramsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Domain Meta Element feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDomainMetaElementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), 
				 getResourceLocator(),
				 getString("_UI_MappingEntry_domainMetaElement_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MappingEntry_domainMetaElement_feature", "_UI_MappingEntry_type"),
				 GMFMapPackage.eINSTANCE.getMappingEntry_DomainMetaElement(), 
				 true, 
				 null, 
				 getString("_UI_DomainmetainformationPropertyCategory"), 
				 null) {
						protected Collection<?> getComboBoxObjects(Object object) {
							@SuppressWarnings("unchecked")
							Collection<EClass> original = (Collection<EClass>) super.getComboBoxObjects(object);
							return FilterUtil.filterByContainmentFeature(original, (MappingEntry) object);
						}
				 });
	}

	/**
	 * This adds a property descriptor for the Related Diagrams feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRelatedDiagramsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MappingEntry_relatedDiagrams_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MappingEntry_relatedDiagrams_feature", "_UI_MappingEntry_type"),
				 GMFMapPackage.eINSTANCE.getMappingEntry_RelatedDiagrams(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Containment Feature feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addContainmentFeaturePropertyDescriptor(Object object) {
		throw new UnsupportedOperationException("Subclasses should override");
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
			childrenFeatures.add(GMFMapPackage.eINSTANCE.getMappingEntry_DomainSpecialization());
			childrenFeatures.add(GMFMapPackage.eINSTANCE.getMappingEntry_DomainInitializer());
			childrenFeatures.add(GMFMapPackage.eINSTANCE.getMappingEntry_LabelMappings());
			childrenFeatures.add(GMFMapPackage.eINSTANCE.getMappingEntry_VisualEffects());
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
		return getString("_UI_MappingEntry_type");
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

		switch (notification.getFeatureID(MappingEntry.class)) {
			case GMFMapPackage.MAPPING_ENTRY__DOMAIN_SPECIALIZATION:
			case GMFMapPackage.MAPPING_ENTRY__DOMAIN_INITIALIZER:
			case GMFMapPackage.MAPPING_ENTRY__LABEL_MAPPINGS:
			case GMFMapPackage.MAPPING_ENTRY__VISUAL_EFFECTS:
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
				(GMFMapPackage.eINSTANCE.getMappingEntry_DomainSpecialization(),
				 GMFMapFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(GMFMapPackage.eINSTANCE.getMappingEntry_DomainInitializer(),
				 GMFMapFactory.eINSTANCE.createFeatureSeqInitializer()));

		newChildDescriptors.add
			(createChildParameter
				(GMFMapPackage.eINSTANCE.getMappingEntry_LabelMappings(),
				 GMFMapFactory.eINSTANCE.createLabelMapping()));

		newChildDescriptors.add
			(createChildParameter
				(GMFMapPackage.eINSTANCE.getMappingEntry_LabelMappings(),
				 GMFMapFactory.eINSTANCE.createFeatureLabelMapping()));

		newChildDescriptors.add
			(createChildParameter
				(GMFMapPackage.eINSTANCE.getMappingEntry_LabelMappings(),
				 GMFMapFactory.eINSTANCE.createOclChoiceLabelMapping()));

		newChildDescriptors.add
			(createChildParameter
				(GMFMapPackage.eINSTANCE.getMappingEntry_LabelMappings(),
				 GMFMapFactory.eINSTANCE.createDesignLabelMapping()));

		newChildDescriptors.add
			(createChildParameter
				(GMFMapPackage.eINSTANCE.getMappingEntry_LabelMappings(),
				 GMFMapFactory.eINSTANCE.createExpressionLabelMapping()));

		newChildDescriptors.add
			(createChildParameter
				(GMFMapPackage.eINSTANCE.getMappingEntry_VisualEffects(),
				 GMFMapFactory.eINSTANCE.createVisualEffectMapping()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return GMFMapEditPlugin.INSTANCE;
	}

}
