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
package org.eclipse.papyrus.tests.framework.internal.exceptions.operations;

import org.eclipse.papyrus.tests.framework.exceptions.EditPartRef;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Slot;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Edit Part Ref</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.EditPartRef#matches(org.eclipse.uml2.uml.InstanceSpecification) <em>Matches</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EditPartRefOperations extends EditPartSpecOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected EditPartRefOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static boolean matches(EditPartRef editPartRef, InstanceSpecification editPart) {
		String editPartClassName = getEditPartClassNameFunction().apply(editPart);
		return (editPartClassName != null) && editPartClassName.equals(editPartRef.getEditPart().getEditPartClassName());
	}

	protected static Predicate<NamedElement> named(final String name) {
		return new Predicate<NamedElement>() {
			@Override
			public boolean apply(NamedElement input) {
				return name.equals(input.getName());
			}
		};
	}

	protected static Predicate<Slot> slotDefinedBy(final String definingFeature) {
		return new Predicate<Slot>() {
			@Override
			public boolean apply(Slot input) {
				return (input.getDefiningFeature() != null) && definingFeature.equals(input.getDefiningFeature().getName());
			}
		};
	}

	protected static Function<InstanceSpecification, String> getEditPartClassNameFunction() {
		return new Function<InstanceSpecification, String>() {
			@Override
			public String apply(InstanceSpecification input) {
				Slot classNameSlot = Iterables.find(input.getSlots(), slotDefinedBy("editPartClassName"));
				return ((classNameSlot == null) || classNameSlot.getValues().isEmpty()) ? null : classNameSlot.getValues().get(0).stringValue();
			}
		};
	}

} // EditPartRefOperations
