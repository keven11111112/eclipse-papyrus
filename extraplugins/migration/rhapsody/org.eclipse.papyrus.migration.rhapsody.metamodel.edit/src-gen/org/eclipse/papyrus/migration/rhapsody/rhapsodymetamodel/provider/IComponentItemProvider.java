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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IComponent;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyFactory;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IComponent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IComponentItemProvider extends IUnitItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IComponentItemProvider(AdapterFactory adapterFactory) {
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

			addWeakCGTimePropertyDescriptor(object);
			addStrongCGTimePropertyDescriptor(object);
			addOwnerHandlePropertyDescriptor(object);
			addIdPropertyDescriptor(object);
			addMyStatePropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addModifiedTimeWeakPropertyDescriptor(object);
			addM_buildTypePropertyDescriptor(object);
			addM_librariesPropertyDescriptor(object);
			addM_additionalSourcesPropertyDescriptor(object);
			addM_standardHeadersPropertyDescriptor(object);
			addM_includePathPropertyDescriptor(object);
			addM_initializationCodePropertyDescriptor(object);
			addLastIDPropertyDescriptor(object);
			addRequiremenTracabilityHandlePropertyDescriptor(object);
			addCodeUpdateCGTimePropertyDescriptor(object);
			addObjectCreationPropertyDescriptor(object);
			addUmlDependencyIDPropertyDescriptor(object);
			addCmheaderPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Weak CG Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWeakCGTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OwnerHandleType_weakCGTime_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_OwnerHandleType_weakCGTime_feature", "_UI_OwnerHandleType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getOwnerHandleType_WeakCGTime(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Strong CG Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStrongCGTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OwnerHandleType_strongCGTime_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_OwnerHandleType_strongCGTime_feature", "_UI_OwnerHandleType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getOwnerHandleType_StrongCGTime(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Owner Handle feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOwnerHandlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IComponent_ownerHandle_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IComponent_ownerHandle_feature", "_UI_IComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIComponent_OwnerHandle(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
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
				 getString("_UI_IComponent_id_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IComponent_id_feature", "_UI_IComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIComponent_Id(),
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
				 getString("_UI_IComponent_myState_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IComponent_myState_feature", "_UI_IComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIComponent_MyState(),
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
				 getString("_UI_IComponent_name_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IComponent_name_feature", "_UI_IComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIComponent_Name(),
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
				 getString("_UI_IComponent_modifiedTimeWeak_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IComponent_modifiedTimeWeak_feature", "_UI_IComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIComponent_ModifiedTimeWeak(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mbuild Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_buildTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IComponent_m_buildType_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IComponent_m_buildType_feature", "_UI_IComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIComponent_M_buildType(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mlibraries feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_librariesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IComponent_m_libraries_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IComponent_m_libraries_feature", "_UI_IComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIComponent_M_libraries(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Madditional Sources feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_additionalSourcesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IComponent_m_additionalSources_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IComponent_m_additionalSources_feature", "_UI_IComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIComponent_M_additionalSources(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mstandard Headers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_standardHeadersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IComponent_m_standardHeaders_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IComponent_m_standardHeaders_feature", "_UI_IComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIComponent_M_standardHeaders(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Minclude Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_includePathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IComponent_m_includePath_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IComponent_m_includePath_feature", "_UI_IComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIComponent_M_includePath(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Minitialization Code feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_initializationCodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IComponent_m_initializationCode_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IComponent_m_initializationCode_feature", "_UI_IComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIComponent_M_initializationCode(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Last ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLastIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IComponent_lastID_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IComponent_lastID_feature", "_UI_IComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIComponent_LastID(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Requiremen Tracability Handle feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiremenTracabilityHandlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IComponent_requiremenTracabilityHandle_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IComponent_requiremenTracabilityHandle_feature", "_UI_IComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIComponent_RequiremenTracabilityHandle(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Code Update CG Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCodeUpdateCGTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IComponent_codeUpdateCGTime_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IComponent_codeUpdateCGTime_feature", "_UI_IComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIComponent_CodeUpdateCGTime(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Object Creation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addObjectCreationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IComponent_objectCreation_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IComponent_objectCreation_feature", "_UI_IComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIComponent_ObjectCreation(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Uml Dependency ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUmlDependencyIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IComponent_umlDependencyID_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IComponent_umlDependencyID_feature", "_UI_IComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIComponent_UmlDependencyID(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Cmheader feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCmheaderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IComponent_cmheader_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IComponent_cmheader_feature", "_UI_IComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIComponent_Cmheader(),
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
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIComponent_Stereotypes());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIComponent_M_folder());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIComponent_M_configActive());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIComponent_Configs());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIComponent_Dependencies());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIComponent_HandlesInMe());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIComponent_Properties());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIComponent_Description());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIComponent_HyperLinks());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants());
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
	 * This returns IComponent.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/IComponent")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((IComponent)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_IComponent_type") : //$NON-NLS-1$
			getString("_UI_IComponent_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(IComponent.class)) {
			case UMLRhapsodyPackage.ICOMPONENT__WEAK_CG_TIME:
			case UMLRhapsodyPackage.ICOMPONENT__STRONG_CG_TIME:
			case UMLRhapsodyPackage.ICOMPONENT__ID:
			case UMLRhapsodyPackage.ICOMPONENT__MY_STATE:
			case UMLRhapsodyPackage.ICOMPONENT__NAME:
			case UMLRhapsodyPackage.ICOMPONENT__MODIFIED_TIME_WEAK:
			case UMLRhapsodyPackage.ICOMPONENT__MBUILD_TYPE:
			case UMLRhapsodyPackage.ICOMPONENT__MLIBRARIES:
			case UMLRhapsodyPackage.ICOMPONENT__MADDITIONAL_SOURCES:
			case UMLRhapsodyPackage.ICOMPONENT__MSTANDARD_HEADERS:
			case UMLRhapsodyPackage.ICOMPONENT__MINCLUDE_PATH:
			case UMLRhapsodyPackage.ICOMPONENT__MINITIALIZATION_CODE:
			case UMLRhapsodyPackage.ICOMPONENT__LAST_ID:
			case UMLRhapsodyPackage.ICOMPONENT__REQUIREMEN_TRACABILITY_HANDLE:
			case UMLRhapsodyPackage.ICOMPONENT__CODE_UPDATE_CG_TIME:
			case UMLRhapsodyPackage.ICOMPONENT__OBJECT_CREATION:
			case UMLRhapsodyPackage.ICOMPONENT__UML_DEPENDENCY_ID:
			case UMLRhapsodyPackage.ICOMPONENT__CMHEADER:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case UMLRhapsodyPackage.ICOMPONENT__STEREOTYPES:
			case UMLRhapsodyPackage.ICOMPONENT__MFOLDER:
			case UMLRhapsodyPackage.ICOMPONENT__MCONFIG_ACTIVE:
			case UMLRhapsodyPackage.ICOMPONENT__CONFIGS:
			case UMLRhapsodyPackage.ICOMPONENT__DEPENDENCIES:
			case UMLRhapsodyPackage.ICOMPONENT__HANDLES_IN_ME:
			case UMLRhapsodyPackage.ICOMPONENT__PROPERTIES:
			case UMLRhapsodyPackage.ICOMPONENT__DESCRIPTION:
			case UMLRhapsodyPackage.ICOMPONENT__HYPER_LINKS:
			case UMLRhapsodyPackage.ICOMPONENT__DECLARATIVES:
			case UMLRhapsodyPackage.ICOMPONENT__VARIATION_POINTS:
			case UMLRhapsodyPackage.ICOMPONENT__SELECTED_VARIANTS:
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
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIClassifier()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIActor()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIAssociationClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIInterfaceItem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIEvent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIEventReception()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIFlowItem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createINode()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIOperation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIStateChart()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIStereotype()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIType()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIUseCase()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_M_folder(),
				 UMLRhapsodyFactory.eINSTANCE.createIFolder()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_M_configActive(),
				 UMLRhapsodyFactory.eINSTANCE.createICodeGenConfigInfoHandle()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Configs(),
				 UMLRhapsodyFactory.eINSTANCE.createICodeGenConfigInfo()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Dependencies(),
				 UMLRhapsodyFactory.eINSTANCE.createIDependency()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Dependencies(),
				 UMLRhapsodyFactory.eINSTANCE.createIHyperLink()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_HandlesInMe(),
				 UMLRhapsodyFactory.eINSTANCE.createIComponent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_HandlesInMe(),
				 UMLRhapsodyFactory.eINSTANCE.createIProfile()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_HandlesInMe(),
				 UMLRhapsodyFactory.eINSTANCE.createISubsystem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Properties(),
				 UMLRhapsodyFactory.eINSTANCE.createIPropertyContainer()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Description(),
				 UMLRhapsodyFactory.eINSTANCE.createIDescription()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_HyperLinks(),
				 UMLRhapsodyFactory.eINSTANCE.createIMHyperLink()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIUnit()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIClassifier()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIActor()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIVariable()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIArgument()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIAssociationClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createICollaborationDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIComment()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIComponent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIComponentDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIControlledFile()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIDeploymentDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIInterfaceItem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIEvent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIEventReception()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIFile()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIFlowItem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIRelation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIInstance()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createILink()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIMatrixLayout()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIMatrixView()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIModule()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createINode()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIObjectModelDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIOperation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIPackage()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIPanelDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIPort()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIProfile()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIProject()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIRequirement()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createISequenceDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIStateChart()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIStateChartDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIStereotype()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIStructureDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createISysMLPort()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createITableLayout()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createITableView()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createITag()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createITemplateParameter()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIType()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIUseCase()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives(),
				 UMLRhapsodyFactory.eINSTANCE.createIUseCaseDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIUnit()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIClassifier()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIActor()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIVariable()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIArgument()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIAssociationClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createICollaborationDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIComment()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIComponent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIComponentDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIControlledFile()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIDeploymentDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIInterfaceItem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIEvent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIEventReception()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIFile()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIFlowItem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIRelation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIInstance()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createILink()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIMatrixLayout()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIMatrixView()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIModule()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createINode()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIObjectModelDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIOperation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIPackage()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIPanelDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIPort()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIProfile()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIProject()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIRequirement()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createISequenceDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIStateChart()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIStateChartDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIStereotype()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIStructureDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createISysMLPort()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createITableLayout()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createITableView()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createITag()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createITemplateParameter()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIType()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIUseCase()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints(),
				 UMLRhapsodyFactory.eINSTANCE.createIUseCaseDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIUnit()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIClassifier()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIActor()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIVariable()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIArgument()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIAssociationClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createICollaborationDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIComment()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIComponent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIComponentDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIControlledFile()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIDeploymentDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIInterfaceItem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIEvent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIEventReception()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIFile()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIFlowItem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIRelation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIInstance()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createILink()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIMatrixLayout()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIMatrixView()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIModule()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createINode()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIObjectModelDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIOperation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIPackage()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIPanelDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIPort()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIProfile()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIProject()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIRequirement()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createISequenceDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIStateChart()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIStateChartDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIStereotype()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIStructureDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createISysMLPort()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createITableLayout()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createITableView()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createITag()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createITemplateParameter()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIType()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIUseCase()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants(),
				 UMLRhapsodyFactory.eINSTANCE.createIUseCaseDiagram()));
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
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIComponent_Stereotypes() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIComponent_Declaratives() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIComponent_VariationPoints() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIComponent_SelectedVariants() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIComponent_HandlesInMe();

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
