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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIAssociationEnd;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyFactory;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIAssociationEnd} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CGIAssociationEndItemProvider extends GraphElementsTypeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIAssociationEndItemProvider(AdapterFactory adapterFactory) {
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
			addM_pSourcePropertyDescriptor(object);
			addM_sourceTypePropertyDescriptor(object);
			addM_pTargetPropertyDescriptor(object);
			addM_targetTypePropertyDescriptor(object);
			addM_directionPropertyDescriptor(object);
			addM_anglePoint1PropertyDescriptor(object);
			addM_anglePoint2PropertyDescriptor(object);
			addM_line_stylePropertyDescriptor(object);
			addM_SourcePortPropertyDescriptor(object);
			addM_TargetPortPropertyDescriptor(object);
			addM_bShowSourceMultiplicityPropertyDescriptor(object);
			addM_bShowSourceRolePropertyDescriptor(object);
			addM_bShowTargetMultiplicityPropertyDescriptor(object);
			addM_bShowTargetRolePropertyDescriptor(object);
			addM_bShowLinkNamePropertyDescriptor(object);
			addM_bShowSpecificTypePropertyDescriptor(object);
			addM_bInstancePropertyDescriptor(object);
			addM_bShowQualifier1PropertyDescriptor(object);
			addM_bShowQualifier2PropertyDescriptor(object);
			addM_specificTypePropertyDescriptor(object);
			addM_arrowPropertyDescriptor(object);
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
				 getString("_UI_CGIAssociationEnd_m_pModelObject_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_pModelObject_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_pModelObject(),
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
				 getString("_UI_CGIAssociationEnd_m_pParent_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_pParent_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_pParent(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the MpSource feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_pSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_pSource_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_pSource_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_pSource(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Msource Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_sourceTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_sourceType_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_sourceType_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_sourceType(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the MpTarget feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_pTargetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_pTarget_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_pTarget_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_pTarget(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mtarget Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_targetTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_targetType_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_targetType_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_targetType(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mdirection feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_directionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_direction_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_direction_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_direction(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mangle Point1 feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_anglePoint1PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_anglePoint1_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_anglePoint1_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_anglePoint1(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mangle Point2 feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_anglePoint2PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_anglePoint2_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_anglePoint2_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_anglePoint2(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mline style feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_line_stylePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_line_style_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_line_style_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_line_style(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the MSource Port feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_SourcePortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_SourcePort_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_SourcePort_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_SourcePort(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the MTarget Port feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_TargetPortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_TargetPort_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_TargetPort_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_TargetPort(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the MbShow Source Multiplicity feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_bShowSourceMultiplicityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_bShowSourceMultiplicity_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_bShowSourceMultiplicity_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_bShowSourceMultiplicity(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the MbShow Source Role feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_bShowSourceRolePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_bShowSourceRole_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_bShowSourceRole_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_bShowSourceRole(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the MbShow Target Multiplicity feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_bShowTargetMultiplicityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_bShowTargetMultiplicity_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_bShowTargetMultiplicity_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_bShowTargetMultiplicity(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the MbShow Target Role feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_bShowTargetRolePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_bShowTargetRole_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_bShowTargetRole_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_bShowTargetRole(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the MbShow Link Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_bShowLinkNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_bShowLinkName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_bShowLinkName_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_bShowLinkName(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the MbShow Specific Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_bShowSpecificTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_bShowSpecificType_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_bShowSpecificType_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_bShowSpecificType(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the MbInstance feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_bInstancePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_bInstance_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_bInstance_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_bInstance(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the MbShow Qualifier1 feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_bShowQualifier1PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_bShowQualifier1_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_bShowQualifier1_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_bShowQualifier1(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the MbShow Qualifier2 feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_bShowQualifier2PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_bShowQualifier2_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_bShowQualifier2_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_bShowQualifier2(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mspecific Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_specificTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_specificType_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_specificType_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_specificType(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Marrow feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM_arrowPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CGIAssociationEnd_m_arrow_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CGIAssociationEnd_m_arrow_feature", "_UI_CGIAssociationEnd_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_arrow(),
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
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_Properties());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_rpn());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_pInverseModelObject());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_pInstance());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_pInverseInstance());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_sourceRole());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_targetRole());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_sourceMultiplicity());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_targetMultiplicity());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_sourceQualifier());
			childrenFeatures.add(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_targetQualifier());
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
	 * This returns CGIAssociationEnd.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CGIAssociationEnd")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((CGIAssociationEnd)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_CGIAssociationEnd_type") : //$NON-NLS-1$
			getString("_UI_CGIAssociationEnd_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(CGIAssociationEnd.class)) {
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPPARENT:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_TYPE:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_TYPE:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MDIRECTION:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MANGLE_POINT1:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MANGLE_POINT2:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MLINE_STYLE:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_PORT:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_PORT:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_SOURCE_MULTIPLICITY:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_SOURCE_ROLE:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_TARGET_MULTIPLICITY:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_TARGET_ROLE:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_LINK_NAME:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_SPECIFIC_TYPE:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBINSTANCE:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_QUALIFIER1:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MBSHOW_QUALIFIER2:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSPECIFIC_TYPE:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MARROW:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__PROPERTIES:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MRPN:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_MODEL_OBJECT:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINSTANCE:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MPINVERSE_INSTANCE:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_ROLE:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_ROLE:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_MULTIPLICITY:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_MULTIPLICITY:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MSOURCE_QUALIFIER:
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END__MTARGET_QUALIFIER:
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
				(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_Properties(),
				 UMLRhapsodyFactory.eINSTANCE.createIPropertyContainer()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_rpn(),
				 UMLRhapsodyFactory.eINSTANCE.createCGIText()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_pInverseModelObject(),
				 UMLRhapsodyFactory.eINSTANCE.createIAssociationEndHandle()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_pInstance(),
				 UMLRhapsodyFactory.eINSTANCE.createIObjectLinkHandle()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_pInverseInstance(),
				 UMLRhapsodyFactory.eINSTANCE.createIObjectLinkHandle()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_sourceRole(),
				 UMLRhapsodyFactory.eINSTANCE.createCGIText()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_targetRole(),
				 UMLRhapsodyFactory.eINSTANCE.createCGIText()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_sourceMultiplicity(),
				 UMLRhapsodyFactory.eINSTANCE.createCGIText()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_targetMultiplicity(),
				 UMLRhapsodyFactory.eINSTANCE.createCGIText()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_sourceQualifier(),
				 UMLRhapsodyFactory.eINSTANCE.createCGIText()));

		newChildDescriptors.add
			(createChildParameter
				(UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_targetQualifier(),
				 UMLRhapsodyFactory.eINSTANCE.createCGIText()));
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
			childFeature == UMLRhapsodyPackage.eINSTANCE.getGraphElementsType_M_name() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_rpn() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_sourceRole() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_targetRole() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_sourceMultiplicity() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_targetMultiplicity() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_sourceQualifier() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_targetQualifier() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_pInstance() ||
			childFeature == UMLRhapsodyPackage.eINSTANCE.getCGIAssociationEnd_M_pInverseInstance();

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
