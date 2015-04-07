/**
 * Copyright (c) 2014 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.umldi.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.papyrus.dd.dc.DCFactory;
import org.eclipse.papyrus.dd.di.DIPackage;

import org.eclipse.papyrus.umldi.UMLDIFactory;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagram;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.umldi.UmlDiagram} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class UmlDiagramItemProvider extends UmlDiagramElementItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, IItemColorProvider, IItemFontProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlDiagramItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if(itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);
			addNamePropertyDescriptor(object);
			addDocumentationPropertyDescriptor(object);
			addResolutionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Diagram_name_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Diagram_name_feature", "_UI_Diagram_type"), DIPackage.Literals.DIAGRAM__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Documentation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDocumentationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Diagram_documentation_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Diagram_documentation_feature", "_UI_Diagram_type"), DIPackage.Literals.DIAGRAM__DOCUMENTATION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Resolution feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addResolutionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Diagram_resolution_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Diagram_resolution_feature", "_UI_Diagram_type"), DIPackage.Literals.DIAGRAM__RESOLUTION, true, false, false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if(childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DIPackage.Literals.SHAPE__BOUNDS);
			childrenFeatures.add(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
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
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((UmlDiagram)object).getName();
		return label == null || label.length() == 0 ? getString("_UI_UmlDiagram_type") : getString("_UI_UmlDiagram_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		switch(notification.getFeatureID(UmlDiagram.class)) {
		case UMLDIPackage.UML_DIAGRAM__NAME:
		case UMLDIPackage.UML_DIAGRAM__DOCUMENTATION:
		case UMLDIPackage.UML_DIAGRAM__RESOLUTION:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case UMLDIPackage.UML_DIAGRAM__BOUNDS:
		case UMLDIPackage.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT:
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
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
		newChildDescriptors.add(createChildParameter(DIPackage.Literals.SHAPE__BOUNDS, DCFactory.eINSTANCE.createBounds()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createPackageShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createConstraintShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createEnumerationShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createAssociationEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createPropertyEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createGeneralizationSetEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createInstanceSpecificationEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createInstanceSpecificationShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createClassShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createInterfaceShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createDataTypeShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createPrimitiveTypeShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createSignalShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createModelShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createContainmentEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createGeneralizationEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createDependencyEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createAbstractionEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createRealizationEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createInterfaceRealizationEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createUsageEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createElementImportEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createPackageImportEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createPackageMergeEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createSubstitutionEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createInformationFlowEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createAssociationClassEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createCommentShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createAttachmentEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createAssociationClassShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createComponentShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createInformationItemShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createRepresentationEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createAssociationShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createDependencyShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createTimeObservationShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createDurationObservationShape()));
	}
}