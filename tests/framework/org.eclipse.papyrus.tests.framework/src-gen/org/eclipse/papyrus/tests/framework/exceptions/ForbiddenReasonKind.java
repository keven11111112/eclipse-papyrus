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
package org.eclipse.papyrus.tests.framework.exceptions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Forbidden Reason Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getForbiddenReasonKind()
 * @model
 * @generated
 */
public enum ForbiddenReasonKind implements Enumerator {
	/**
	 * The '<em><b>Invalid</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #INVALID_VALUE
	 * @generated
	 * @ordered
	 */
	INVALID(0, "invalid", "invalid"),

	/**
	 * The '<em><b>Failing</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #FAILING_VALUE
	 * @generated
	 * @ordered
	 */
	FAILING(1, "failing", "failing"),

	/**
	 * The '<em><b>Unimplemented</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #UNIMPLEMENTED_VALUE
	 * @generated
	 * @ordered
	 */
	UNIMPLEMENTED(2, "unimplemented", "unimplemented"), /**
														 * The '<em><b>Interactive</b></em>' literal object.
														 * <!-- begin-user-doc -->
														 * <!-- end-user-doc -->
														 *
														 * @see #INTERACTIVE_VALUE
														 * @generated
														 * @ordered
														 */
	INTERACTIVE(3, "interactive", "interactive");

	/**
	 * The '<em><b>Invalid</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Invalid</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #INVALID
	 * @model name="invalid"
	 * @generated
	 * @ordered
	 */
	public static final int INVALID_VALUE = 0;

	/**
	 * The '<em><b>Failing</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates that the permutation of edit-parts is forbidden because the tests generated would fail.
	 * The system-under-test intends to support this permutation, but it does not work.
	 * <!-- end-model-doc -->
	 *
	 * @see #FAILING
	 * @model name="failing"
	 * @generated
	 * @ordered
	 */
	public static final int FAILING_VALUE = 1;

	/**
	 * The '<em><b>Unimplemented</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates that the permutation of edit-parts is forbidden because the
	 * system-under-test does not intend to support it, so generating tests
	 * would be pointless (they would only fail).
	 * <!-- end-model-doc -->
	 *
	 * @see #UNIMPLEMENTED
	 * @model name="unimplemented"
	 * @generated
	 * @ordered
	 */
	public static final int UNIMPLEMENTED_VALUE = 2;

	/**
	 * The '<em><b>Interactive</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Interactive</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @see #INTERACTIVE
	 * @model name="interactive"
	 * @generated
	 * @ordered
	 */
	public static final int INTERACTIVE_VALUE = 3;

	/**
	 * An array of all the '<em><b>Forbidden Reason Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static final ForbiddenReasonKind[] VALUES_ARRAY = new ForbiddenReasonKind[] {
			INVALID,
			FAILING,
			UNIMPLEMENTED,
			INTERACTIVE,
	};

	/**
	 * A public read-only list of all the '<em><b>Forbidden Reason Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final List<ForbiddenReasonKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Forbidden Reason Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param literal
	 *            the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ForbiddenReasonKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ForbiddenReasonKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Forbidden Reason Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param name
	 *            the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ForbiddenReasonKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ForbiddenReasonKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Forbidden Reason Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ForbiddenReasonKind get(int value) {
		switch (value) {
		case INVALID_VALUE:
			return INVALID;
		case FAILING_VALUE:
			return FAILING;
		case UNIMPLEMENTED_VALUE:
			return UNIMPLEMENTED;
		case INTERACTIVE_VALUE:
			return INTERACTIVE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private ForbiddenReasonKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // ForbiddenReasonKind
