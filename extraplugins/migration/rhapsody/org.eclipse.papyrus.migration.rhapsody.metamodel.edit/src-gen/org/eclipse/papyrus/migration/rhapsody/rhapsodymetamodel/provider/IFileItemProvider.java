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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFile;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyFactory;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFile} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IFileItemProvider extends IUnitItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFileItemProvider(AdapterFactory adapterFactory) {
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

			addModifiedTimeWeakPropertyDescriptor(object);
			addIdPropertyDescriptor(object);
			addUmlDependencyIDPropertyDescriptor(object);
			addLastIDPropertyDescriptor(object);
			addMyStatePropertyDescriptor(object);
			addM_pathPropertyDescriptor(object);
			addObjectCreationPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addM_typePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_FilesType_modifiedTimeWeak_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_FilesType_modifiedTimeWeak_feature", "_UI_FilesType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getFilesType_ModifiedTimeWeak(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
				 getString("_UI_FilesType_id_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_FilesType_id_feature", "_UI_FilesType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getFilesType_Id(),
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
				 getString("_UI_FilesType_umlDependencyID_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_FilesType_umlDependencyID_feature", "_UI_FilesType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getFilesType_UmlDependencyID(),
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
				 getString("_UI_FilesType_lastID_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_FilesType_lastID_feature", "_UI_FilesType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getFilesType_LastID(),
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
				 getString("_UI_FilesType_myState_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_FilesType_myState_feature", "_UI_FilesType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getFilesType_MyState(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mpath feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_pathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FilesType_m_path_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_FilesType_m_path_feature", "_UI_FilesType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getFilesType_M_path(),
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
				 getString("_UI_FilesType_objectCreation_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_FilesType_objectCreation_feature", "_UI_FilesType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getFilesType_ObjectCreation(),
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
				 getString("_UI_FilesType_name_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_FilesType_name_feature", "_UI_FilesType_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getFilesType_Name(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mtype feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_typePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IFile_m_type_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_IFile_m_type_feature", "_UI_IFile_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getIFile_M_type(),
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
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIFile_Properties());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIFile_Description());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getIFile_Dependencies());
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
	 * This returns IFile.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/IFile")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((IFile)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_IFile_type") : //$NON-NLS-1$
			getString("_UI_IFile_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(IFile.class)) {
			case UMLRhapsodyPackage.IFILE__MODIFIED_TIME_WEAK:
			case UMLRhapsodyPackage.IFILE__ID:
			case UMLRhapsodyPackage.IFILE__UML_DEPENDENCY_ID:
			case UMLRhapsodyPackage.IFILE__LAST_ID:
			case UMLRhapsodyPackage.IFILE__MY_STATE:
			case UMLRhapsodyPackage.IFILE__MPATH:
			case UMLRhapsodyPackage.IFILE__OBJECT_CREATION:
			case UMLRhapsodyPackage.IFILE__NAME:
			case UMLRhapsodyPackage.IFILE__MTYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case UMLRhapsodyPackage.IFILE__PROPERTIES:
			case UMLRhapsodyPackage.IFILE__FRAGMENTS:
			case UMLRhapsodyPackage.IFILE__DESCRIPTION:
			case UMLRhapsodyPackage.IFILE__DEPENDENCIES:
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
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Properties(),
				 UMLRhapsodyFactory.eINSTANCE.createIPropertyContainer()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIModelElement()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIStateVertex()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIState()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIAcceptEventAction()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIAcceptTimeEvent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIAction()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIActivityGraph()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIUnit()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIClassifier()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIActor()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIVariable()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIArgument()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIAssociationClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIAssociationEnd()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIAssociationRole()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createICallOperation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIClassifierRole()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createICollaboration()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createICollaborationDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIComment()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIComponent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIComponentDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIComponentInstance()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIConnector()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIValueSpecification()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIContextSpecification()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIControlledFile()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIDependency()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIDeploymentDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIEnumerationLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIInterfaceItem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIEvent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIEventReception()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIExecutionOccurrence()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIExternalHyperlink()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIFile()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIFileFragment()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIFlow()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIFlowItem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIGeneralization()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIGuard()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIHyperLink()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIInformationFlow()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIRelation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIInstance()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIInstanceSlot()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIInstanceSpecification()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIInstanceValue()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIInteractionOccurrence()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIInteractionOperand()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIInteractionOperator()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIInternalHyperlink()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createILink()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createILiteralSpecification()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIMHyperLink()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIMatrixLayout()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIMatrixView()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIMessage()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIMessagePoint()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIModule()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createINode()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIObjectLink()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIObjectModelDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIObjectNode()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIOperation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIPackage()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIPanelDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIPart()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIPin()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIPort()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIPrimitiveOperation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIProfile()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIProject()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIRequirement()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createISendAction()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createISequenceDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIStateChart()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIStateChartDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIStereotype()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIStructureDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createISubsystem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createISwimlane()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createISysMLPort()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createITableLayout()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createITableView()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createITag()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createITemplateInstantiation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createITemplateInstantiationParameter()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createITemplateParameter()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createITransition()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createITrigger()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createITriggered()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIType()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIUseCase()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments(),
				 UMLRhapsodyFactory.eINSTANCE.createIUseCaseDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Description(),
				 UMLRhapsodyFactory.eINSTANCE.createIDescription()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Dependencies(),
				 UMLRhapsodyFactory.eINSTANCE.createIDependency()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getIFile_Dependencies(),
				 UMLRhapsodyFactory.eINSTANCE.createIHyperLink()));
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
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIFile_Fragments() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getIFile_Dependencies();

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
