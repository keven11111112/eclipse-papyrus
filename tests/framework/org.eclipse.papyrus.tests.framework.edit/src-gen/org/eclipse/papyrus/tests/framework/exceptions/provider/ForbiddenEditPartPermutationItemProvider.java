/**
 * Copyright (c) 2015 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 */
package org.eclipse.papyrus.tests.framework.exceptions.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.papyrus.tests.framework.exceptions.ExceptionsFactory;
import org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage;
import org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation;

/**
 * This is the item provider adapter for a
 * {@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class ForbiddenEditPartPermutationItemProvider extends TestConstraintItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ForbiddenEditPartPermutationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addReasonKindPropertyDescriptor(object);
			addReasonPropertyDescriptor(object);
			addTestClassPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Reason Kind feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addReasonKindPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ForbiddenEditPartPermutation_reasonKind_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_ForbiddenEditPartPermutation_reasonKind_feature",
						"_UI_ForbiddenEditPartPermutation_type"),
				ExceptionsPackage.Literals.FORBIDDEN_EDIT_PART_PERMUTATION__REASON_KIND, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Reason feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addReasonPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ForbiddenEditPartPermutation_reason_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_ForbiddenEditPartPermutation_reason_feature",
						"_UI_ForbiddenEditPartPermutation_type"),
				ExceptionsPackage.Literals.FORBIDDEN_EDIT_PART_PERMUTATION__REASON, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Test Class feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addTestClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ForbiddenEditPartPermutation_testClass_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_ForbiddenEditPartPermutation_testClass_feature",
						"_UI_ForbiddenEditPartPermutation_type"),
				ExceptionsPackage.Literals.FORBIDDEN_EDIT_PART_PERMUTATION__TEST_CLASS, true, false, true, null, null,
				null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to
	 * deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in
	 * {@link #createCommand}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ExceptionsPackage.Literals.FORBIDDEN_EDIT_PART_PERMUTATION__EDIT_PART);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper
		// feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ForbiddenEditPartPermutation.gif. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ForbiddenEditPartPermutation"));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		ForbiddenEditPartPermutation forbiddenEditPartPermutation = (ForbiddenEditPartPermutation) object;
		return getString("_UI_ForbiddenEditPartPermutation_type") + " "
				+ forbiddenEditPartPermutation.isOmitOnFailure();
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which
	 * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ForbiddenEditPartPermutation.class)) {
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__REASON_KIND:
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__REASON:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__EDIT_PART:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors
				.add(createChildParameter(ExceptionsPackage.Literals.FORBIDDEN_EDIT_PART_PERMUTATION__EDIT_PART,
						ExceptionsFactory.eINSTANCE.createCompositeEditPartSpec()));

		newChildDescriptors
				.add(createChildParameter(ExceptionsPackage.Literals.FORBIDDEN_EDIT_PART_PERMUTATION__EDIT_PART,
						ExceptionsFactory.eINSTANCE.createEditPartRef()));

		newChildDescriptors
				.add(createChildParameter(ExceptionsPackage.Literals.FORBIDDEN_EDIT_PART_PERMUTATION__EDIT_PART,
						ExceptionsFactory.eINSTANCE.createAnyEditPart()));
	}

}
