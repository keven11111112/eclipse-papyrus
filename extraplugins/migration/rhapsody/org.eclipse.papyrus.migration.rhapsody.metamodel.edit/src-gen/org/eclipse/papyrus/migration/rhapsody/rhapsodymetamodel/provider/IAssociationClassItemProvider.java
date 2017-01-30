/**
 *   Copyright (c) 2016 CEA LIST and others.
 *   
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *     CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationClass;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationClass} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IAssociationClassItemProvider extends IClassItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAssociationClassItemProvider(AdapterFactory adapterFactory) {
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

			addIsClassPropertyDescriptor(object);
			addM_end1PropertyDescriptor(object);
			addM_end2PropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Is Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IAssociationClass_isClass_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IAssociationClass_isClass_feature", "_UI_IAssociationClass_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIAssociationClass_IsClass(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mend1 feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_end1PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IAssociationClass_m_end1_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IAssociationClass_m_end1_feature", "_UI_IAssociationClass_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIAssociationClass_M_end1(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mend2 feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_end2PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IAssociationClass_m_end2_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IAssociationClass_m_end2_feature", "_UI_IAssociationClass_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIAssociationClass_M_end2(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns IAssociationClass.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/IAssociationClass")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((IAssociationClass)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_IAssociationClass_type") : //$NON-NLS-1$
			getString("_UI_IAssociationClass_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(IAssociationClass.class)) {
			case UMLRhapsodyPackage.IASSOCIATION_CLASS__IS_CLASS:
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
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIClass_Stereotypes() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIClass_Inheritances() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIClass_Attrs() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIClass_Annotations() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIClass_Declaratives() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIClass_EventHandles() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIClass_ComponentFiles() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIClass_Ports() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIClass_Links() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIClass_Associations() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIClass_StateCharts() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIClass_Tags() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIClass_TemplateParameters() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIClass_Operations() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIClass_PrimitiveOperations() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIClass_Dependencies() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIClass_HyperLinks() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIClass_ObjectLinks();

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
