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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGITextBox;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyFactory;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGITextBox} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CGITextBoxItemProvider extends GraphElementsTypeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGITextBoxItemProvider(AdapterFactory adapterFactory) {
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

			addM_pModelObjectPropertyDescriptor(object);
			addM_pParentPropertyDescriptor(object);
			addM_transformPropertyDescriptor(object);
			addM_polygonPropertyDescriptor(object);
			addM_nNameFormatPropertyDescriptor(object);
			addM_nIsNameFormatPropertyDescriptor(object);
			addCompartmentsPropertyDescriptor(object);
			addM_csModelObjPathPropertyDescriptor(object);
			addM_csNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the MpModel Object feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_pModelObjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGITextBox_m_pModelObject_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGITextBox_m_pModelObject_feature", "_UI_CGITextBox_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_pModelObject(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the MpParent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_pParentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGITextBox_m_pParent_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGITextBox_m_pParent_feature", "_UI_CGITextBox_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_pParent(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mtransform feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_transformPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGITextBox_m_transform_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGITextBox_m_transform_feature", "_UI_CGITextBox_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_transform(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mpolygon feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_polygonPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGITextBox_m_polygon_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGITextBox_m_polygon_feature", "_UI_CGITextBox_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_polygon(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the MnName Format feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_nNameFormatPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGITextBox_m_nNameFormat_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGITextBox_m_nNameFormat_feature", "_UI_CGITextBox_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_nNameFormat(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the MnIs Name Format feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_nIsNameFormatPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGITextBox_m_nIsNameFormat_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGITextBox_m_nIsNameFormat_feature", "_UI_CGITextBox_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_nIsNameFormat(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Compartments feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCompartmentsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGITextBox_Compartments_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGITextBox_Compartments_feature", "_UI_CGITextBox_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGITextBox_Compartments(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mcs Model Obj Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_csModelObjPathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGITextBox_m_csModelObjPath_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGITextBox_m_csModelObjPath_feature", "_UI_CGITextBox_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_csModelObjPath(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mcs Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_csNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGITextBox_m_csName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGITextBox_m_csName_feature", "_UI_CGITextBox_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_csName(),
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
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_Properties());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray());
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
	 * This returns CGITextBox.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CGITextBox")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((CGITextBox)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_CGITextBox_type") : //$NON-NLS-1$
			getString("_UI_CGITextBox_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(CGITextBox.class)) {
			case UMLRhapsodyPackage.CGI_TEXT_BOX__MTRANSFORM:
			case UMLRhapsodyPackage.CGI_TEXT_BOX__MPOLYGON:
			case UMLRhapsodyPackage.CGI_TEXT_BOX__MNNAME_FORMAT:
			case UMLRhapsodyPackage.CGI_TEXT_BOX__MNIS_NAME_FORMAT:
			case UMLRhapsodyPackage.CGI_TEXT_BOX__MCS_MODEL_OBJ_PATH:
			case UMLRhapsodyPackage.CGI_TEXT_BOX__MCS_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case UMLRhapsodyPackage.CGI_TEXT_BOX__PROPERTIES:
			case UMLRhapsodyPackage.CGI_TEXT_BOX__MPARTS_ARRAY:
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
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_Properties(),
				 UMLRhapsodyFactory.eINSTANCE.createIPropertyContainer()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIState()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIAcceptEventAction()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIAcceptTimeEvent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIActivityDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIActivityGraph()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIActor()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIAssociationClass()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createICallOperation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createICodeGenConfigInfo()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createICollaborationDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIComponent()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIComponentDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIDefaultDrvdTrans()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIDependency()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIDeploymentDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIHyperLink()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIInformationFlow()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIInformationItem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIMSC()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIMatrixInstance()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIMessage()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIModule()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIObjectLink()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIObjectModelDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIObjectNode()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIPanelDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIPart()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIPrimitiveOperation()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIProfile()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIReception()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIReferenceActivity()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIRequirement()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createISequenceDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIStateChart()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIStateChartDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIStereotype()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIStructureDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createISubsystem()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createISysMLPort()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createITableInstance()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createITransition()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIType()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIUCDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIUseCase()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGITextBox_M_PartsArray(),
				 UMLRhapsodyFactory.eINSTANCE.createIUseCaseDiagram()));
	}

}
