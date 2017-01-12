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

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITableInstance;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyFactory;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITableInstance} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ITableInstanceItemProvider extends TableInstancesTypeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITableInstanceItemProvider(AdapterFactory adapterFactory) {
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

			addIdPropertyDescriptor(object);
			addMyStatePropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addModifiedTimeWeakPropertyDescriptor(object);
			addLayoutHandlePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ITableInstance_id_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ITableInstance_id_feature", "_UI_ITableInstance_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getITableInstance_Id(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the My State feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMyStatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ITableInstance_myState_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ITableInstance_myState_feature", "_UI_ITableInstance_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getITableInstance_MyState(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ITableInstance_name_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ITableInstance_name_feature", "_UI_ITableInstance_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getITableInstance_Name(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Modified Time Weak feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModifiedTimeWeakPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ITableInstance_modifiedTimeWeak_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ITableInstance_modifiedTimeWeak_feature", "_UI_ITableInstance_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getITableInstance_ModifiedTimeWeak(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Layout Handle feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLayoutHandlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ITableInstance_LayoutHandle_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ITableInstance_LayoutHandle_feature", "_UI_ITableInstance_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getITableInstance_LayoutHandle(),
				 true,
				 false,
				 true,
				 null,
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
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getITableInstance_Properties());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getITableInstance_Stereotypes());
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
	 * This returns ITableInstance.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ITableInstance")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ITableInstance)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ITableInstance_type") : //$NON-NLS-1$
			getString("_UI_ITableInstance_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(ITableInstance.class)) {
			case UMLRhapsodyPackage.ITABLE_INSTANCE__ID:
			case UMLRhapsodyPackage.ITABLE_INSTANCE__MY_STATE:
			case UMLRhapsodyPackage.ITABLE_INSTANCE__NAME:
			case UMLRhapsodyPackage.ITABLE_INSTANCE__MODIFIED_TIME_WEAK:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case UMLRhapsodyPackage.ITABLE_INSTANCE__PROPERTIES:
			case UMLRhapsodyPackage.ITABLE_INSTANCE__SCOPE_HANDLES:
			case UMLRhapsodyPackage.ITABLE_INSTANCE__STEREOTYPES:
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
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_Properties(),
				 UMLRhapsodyFactory.eINSTANCE.createIPropertyContainer()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIState()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIAcceptEventAction()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIAcceptTimeEvent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIActivityGraph()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIActor()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIAnchor()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIAssociationClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIAssociationEnd()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIBlock()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createICallOperation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIClassHandle()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIClassInstance()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createICollaboration()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createICollaborationDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIComponent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIComponentDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIDeploymentDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIEvent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIInteractionOperand()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createILink()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createILinkInstance()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIMetaLinkHandle()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIModule()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIObjectLink()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIObjectModelDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIObjectNode()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIPanelDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIPart()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIPrimitiveOperation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIProject()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createISequenceDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIStateChart()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIStateChartDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIStereotype()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIStructureDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createISubsystem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createITag()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIType()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIUCDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles(),
				 UMLRhapsodyFactory.eINSTANCE.createIUseCaseDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIClassifier()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIActor()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIAssociationClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIInterfaceItem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIEvent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIEventReception()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIFlowItem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createINode()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIOperation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIStateChart()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIStereotype()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIType()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getITableInstance_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIUseCase()));
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
			childFeature == UMLRhapsodyPackage.eINSTANCE.getITableInstance_ScopeHandles() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getITableInstance_Stereotypes();

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
