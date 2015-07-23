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
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec;
import org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec;
import org.eclipse.papyrus.tests.framework.exceptions.ExceptionsFactory;
import org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage;
import org.eclipse.papyrus.tests.framework.exceptions.OperatorKind;

/**
 * This is the item provider adapter for a
 * {@link org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class CompositeEditPartSpecItemProvider extends EditPartSpecItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public CompositeEditPartSpecItemProvider(AdapterFactory adapterFactory) {
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

			addOperatorPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Operator feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addOperatorPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_CompositeEditPartSpec_operator_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_CompositeEditPartSpec_operator_feature",
								"_UI_CompositeEditPartSpec_type"),
				ExceptionsPackage.Literals.COMPOSITE_EDIT_PART_SPEC__OPERATOR, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
			childrenFeatures.add(ExceptionsPackage.Literals.COMPOSITE_EDIT_PART_SPEC__OPERAND);
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
	 * This returns CompositeEditPartSpec.gif. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CompositeEditPartSpec"));
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
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		CompositeEditPartSpec composite = (CompositeEditPartSpec) object;
		OperatorKind labelValue = composite.getOperator();
		String label = labelValue == null ? null : labelValue.toString();

		StringBuilder result = new StringBuilder();
		result.append(label).append('(');
		boolean first = true;
		for (EditPartSpec operand : composite.getOperands()) {
			if (first) {
				first = false;
			} else {
				result.append(", "); //$NON-NLS-1$
			}
			IItemLabelProvider labels = (IItemLabelProvider) getRootAdapterFactory().adapt(operand,
					IItemLabelProvider.class);
			result.append((labels == null) ? operand.eClass().getName() : labels.getText(operand));

			if (result.length() > 150) {
				// Too long: give up
				result.append(" ..."); //$NON-NLS-1$
			}
		}
		result.append(')');
		return result.toString();
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which
	 * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	public void notifyChangedGen(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(CompositeEditPartSpec.class)) {
		case ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC__OPERATOR:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC__OPERAND:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	@Override
	public void notifyChanged(Notification notification) {
		notifyChangedGen(notification);

		switch (notification.getFeatureID(CompositeEditPartSpec.class)) {
		case ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC__OPERAND:
			// Our label depends on this
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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

		newChildDescriptors.add(createChildParameter(ExceptionsPackage.Literals.COMPOSITE_EDIT_PART_SPEC__OPERAND,
				ExceptionsFactory.eINSTANCE.createCompositeEditPartSpec()));

		newChildDescriptors.add(createChildParameter(ExceptionsPackage.Literals.COMPOSITE_EDIT_PART_SPEC__OPERAND,
				ExceptionsFactory.eINSTANCE.createEditPartRef()));

		newChildDescriptors.add(createChildParameter(ExceptionsPackage.Literals.COMPOSITE_EDIT_PART_SPEC__OPERAND,
				ExceptionsFactory.eINSTANCE.createAnyEditPart()));
	}

}
