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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.gmf.mappings.FeatureInitializer;
import org.eclipse.papyrus.gmf.mappings.FeatureValueSpec;
import org.eclipse.papyrus.gmf.mappings.GMFMapFactory;
import org.eclipse.papyrus.gmf.mappings.GMFMapPackage;
import org.eclipse.papyrus.gmf.mappings.presentation.FilterUtil;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.gmf.mappings.FeatureValueSpec} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FeatureValueSpecItemProvider
	extends FeatureInitializerItemProvider
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
	public FeatureValueSpecItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(GMFMapPackage.eINSTANCE.getFeatureValueSpec_Value());
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
	 * This adds a property descriptor for the Feature feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addFeaturePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor(
				((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FeatureInitializer_feature_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureInitializer_feature_feature", "_UI_FeatureInitializer_type"),
				 GMFMapPackage.eINSTANCE.getFeatureInitializer_Feature(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null) {
					protected Collection<?> getComboBoxObjects(Object object) {
						if(object instanceof FeatureInitializer) {
							@SuppressWarnings("unchecked")
							final Collection<EStructuralFeature> original = (Collection<EStructuralFeature>) super.getComboBoxObjects(object);
							return FilterUtil.filterByFeatureInitializer(original, (FeatureInitializer)object);
						}
					
						return super.getComboBoxObjects(object);
					}				
			});
	}

	/**
	 * This returns FeatureValueSpec.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FeatureValueSpec"));
	}

	/**
	 * @generated
	 */
	public String getTextGen(Object object) {
		return getString("_UI_FeatureValueSpec_type");
	}

	/**
	 * This returns the label text for the adapted class.
	 * @generated NOT
	 */
	public String getText(Object object) {
		StringBuilder buf = new StringBuilder();
		buf.append(getTextGen(object));
		if(object instanceof FeatureValueSpec) { 
			FeatureValueSpec featureValueSpec = (FeatureValueSpec)object; 
			buf.append('<');
			
			String feature = (featureValueSpec.getFeature() != null) ? featureValueSpec.getFeature().getName() : null;
			if(feature != null && feature.length() > 0) {
				buf.append(feature).append(":=");
			}
			
			String body = crop(featureValueSpec.getValue() != null ? featureValueSpec.getValue().getBody() : null);			
			if(body != null && body.length() > 0) {
				buf.append(' ').append(body);
			}
			buf.append('>');
		}
		return buf.toString();
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

		switch (notification.getFeatureID(FeatureValueSpec.class)) {
			case GMFMapPackage.FEATURE_VALUE_SPEC__VALUE:
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
				(GMFMapPackage.eINSTANCE.getFeatureValueSpec_Value(),
				 GMFMapFactory.eINSTANCE.createValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(GMFMapPackage.eINSTANCE.getFeatureValueSpec_Value(),
				 GMFMapFactory.eINSTANCE.createConstraint()));
	}

}
