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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInformationFlow;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyFactory;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInformationFlow} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IInformationFlowItemProvider extends DeclarativesTypeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInformationFlowItemProvider(AdapterFactory adapterFactory) {
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
			addEnd1_PropertyDescriptor(object);
			addEnd2_PropertyDescriptor(object);
			addDirection_PropertyDescriptor(object);
			addModifiedTimeWeakPropertyDescriptor(object);
			addEnd1ObjectPort_PropertyDescriptor(object);
			addEnd2ObjectPort_PropertyDescriptor(object);
			addRequiremenTracabilityHandlePropertyDescriptor(object);
			addObjectCreationPropertyDescriptor(object);
			addUmlDependencyIDPropertyDescriptor(object);
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
				 getString("_UI_IInformationFlow_id_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IInformationFlow_id_feature", "_UI_IInformationFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Id(),
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
				 getString("_UI_IInformationFlow_myState_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IInformationFlow_myState_feature", "_UI_IInformationFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_MyState(),
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
				 getString("_UI_IInformationFlow_name_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IInformationFlow_name_feature", "_UI_IInformationFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Name(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the End1  feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnd1_PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IInformationFlow_end1__feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IInformationFlow_end1__feature", "_UI_IInformationFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_End1_(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the End2  feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnd2_PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IInformationFlow_end2__feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IInformationFlow_end2__feature", "_UI_IInformationFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_End2_(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Direction  feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDirection_PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IInformationFlow_direction__feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IInformationFlow_direction__feature", "_UI_IInformationFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Direction_(),
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
				 getString("_UI_IInformationFlow_modifiedTimeWeak_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IInformationFlow_modifiedTimeWeak_feature", "_UI_IInformationFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_ModifiedTimeWeak(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the End1 Object Port  feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnd1ObjectPort_PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IInformationFlow_end1ObjectPort__feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IInformationFlow_end1ObjectPort__feature", "_UI_IInformationFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_End1ObjectPort_(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the End2 Object Port  feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnd2ObjectPort_PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IInformationFlow_end2ObjectPort__feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IInformationFlow_end2ObjectPort__feature", "_UI_IInformationFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_End2ObjectPort_(),
				 true,
				 false,
				 true,
				 null,
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
				 getString("_UI_IInformationFlow_requiremenTracabilityHandle_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IInformationFlow_requiremenTracabilityHandle_feature", "_UI_IInformationFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_RequiremenTracabilityHandle(),
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
				 getString("_UI_IInformationFlow_objectCreation_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IInformationFlow_objectCreation_feature", "_UI_IInformationFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_ObjectCreation(),
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
				 getString("_UI_IInformationFlow_umlDependencyID_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IInformationFlow_umlDependencyID_feature", "_UI_IInformationFlow_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_UmlDependencyID(),
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
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Conveyed());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Description());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_HyperLinks());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Dependencies());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Annotations());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Tags());
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
	 * This returns IInformationFlow.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/IInformationFlow")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((IInformationFlow)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_IInformationFlow_type") : //$NON-NLS-1$
			getString("_UI_IInformationFlow_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(IInformationFlow.class)) {
			case UMLRhapsodyPackage.IINFORMATION_FLOW__ID:
			case UMLRhapsodyPackage.IINFORMATION_FLOW__MY_STATE:
			case UMLRhapsodyPackage.IINFORMATION_FLOW__NAME:
			case UMLRhapsodyPackage.IINFORMATION_FLOW__DIRECTION_:
			case UMLRhapsodyPackage.IINFORMATION_FLOW__MODIFIED_TIME_WEAK:
			case UMLRhapsodyPackage.IINFORMATION_FLOW__REQUIREMEN_TRACABILITY_HANDLE:
			case UMLRhapsodyPackage.IINFORMATION_FLOW__OBJECT_CREATION:
			case UMLRhapsodyPackage.IINFORMATION_FLOW__UML_DEPENDENCY_ID:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case UMLRhapsodyPackage.IINFORMATION_FLOW__CONVEYED:
			case UMLRhapsodyPackage.IINFORMATION_FLOW__DESCRIPTION:
			case UMLRhapsodyPackage.IINFORMATION_FLOW__HYPER_LINKS:
			case UMLRhapsodyPackage.IINFORMATION_FLOW__DEPENDENCIES:
			case UMLRhapsodyPackage.IINFORMATION_FLOW__ANNOTATIONS:
			case UMLRhapsodyPackage.IINFORMATION_FLOW__STEREOTYPES:
			case UMLRhapsodyPackage.IINFORMATION_FLOW__TAGS:
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
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Conveyed(),
				 UMLRhapsodyFactory.eINSTANCE.createIClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Conveyed(),
				 UMLRhapsodyFactory.eINSTANCE.createIAssociationClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Conveyed(),
				 UMLRhapsodyFactory.eINSTANCE.createIEvent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Conveyed(),
				 UMLRhapsodyFactory.eINSTANCE.createIInformationItem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Conveyed(),
				 UMLRhapsodyFactory.eINSTANCE.createIPart()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Conveyed(),
				 UMLRhapsodyFactory.eINSTANCE.createIStateChart()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Description(),
				 UMLRhapsodyFactory.eINSTANCE.createIDescription()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_HyperLinks(),
				 UMLRhapsodyFactory.eINSTANCE.createIMHyperLink()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Dependencies(),
				 UMLRhapsodyFactory.eINSTANCE.createIDependency()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Dependencies(),
				 UMLRhapsodyFactory.eINSTANCE.createIHyperLink()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Annotations(),
				 UMLRhapsodyFactory.eINSTANCE.createIRequirement()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIUnit()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIClassifier()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIActor()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIVariable()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIArgument()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIAssociationClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createICollaborationDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIComment()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIComponent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIComponentDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIControlledFile()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIDeploymentDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIInterfaceItem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIEvent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIEventReception()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIFile()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIFlowItem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIRelation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIInstance()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createILink()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIMatrixLayout()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIMatrixView()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIModule()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createINode()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIObjectModelDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIOperation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIPackage()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIPanelDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIPort()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIProfile()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIProject()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIRequirement()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createISequenceDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIStateChart()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIStateChartDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIStereotype()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIStructureDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createISysMLPort()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createITableLayout()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createITableView()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createITag()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createITemplateParameter()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIType()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIUseCase()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes(),
				 UMLRhapsodyFactory.eINSTANCE.createIUseCaseDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Tags(),
				 UMLRhapsodyFactory.eINSTANCE.createITag()));
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
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Conveyed() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Stereotypes() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Annotations() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIInformationFlow_Tags();

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
