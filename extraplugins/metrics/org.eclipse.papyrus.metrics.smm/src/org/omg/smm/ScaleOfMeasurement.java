/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   CEA LIST - Initial API and implementation
 * 
 */
package org.omg.smm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Scale Of Measurement</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.omg.smm.SmmPackage#getScaleOfMeasurement()
 * @model
 * @generated
 */
public enum ScaleOfMeasurement implements Enumerator {
	/**
	 * The '<em><b>Nominal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOMINAL_VALUE
	 * @generated
	 * @ordered
	 */
	NOMINAL(0, "nominal", "nominal"),

	/**
	 * The '<em><b>Ordinal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ORDINAL_VALUE
	 * @generated
	 * @ordered
	 */
	ORDINAL(1, "ordinal", "ordinal"),

	/**
	 * The '<em><b>Interval</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTERVAL_VALUE
	 * @generated
	 * @ordered
	 */
	INTERVAL(2, "interval", "interval"),

	/**
	 * The '<em><b>Ratio</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RATIO_VALUE
	 * @generated
	 * @ordered
	 */
	RATIO(3, "ratio", "ratio"),

	/**
	 * The '<em><b>Custom</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CUSTOM_VALUE
	 * @generated
	 * @ordered
	 */
	CUSTOM(4, "custom", "custom");

	/**
	 * The '<em><b>Nominal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Nominal</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOMINAL
	 * @model name="nominal"
	 * @generated
	 * @ordered
	 */
	public static final int NOMINAL_VALUE = 0;

	/**
	 * The '<em><b>Ordinal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ordinal</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ORDINAL
	 * @model name="ordinal"
	 * @generated
	 * @ordered
	 */
	public static final int ORDINAL_VALUE = 1;

	/**
	 * The '<em><b>Interval</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Interval</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTERVAL
	 * @model name="interval"
	 * @generated
	 * @ordered
	 */
	public static final int INTERVAL_VALUE = 2;

	/**
	 * The '<em><b>Ratio</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ratio</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RATIO
	 * @model name="ratio"
	 * @generated
	 * @ordered
	 */
	public static final int RATIO_VALUE = 3;

	/**
	 * The '<em><b>Custom</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Custom</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CUSTOM
	 * @model name="custom"
	 * @generated
	 * @ordered
	 */
	public static final int CUSTOM_VALUE = 4;

	/**
	 * An array of all the '<em><b>Scale Of Measurement</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ScaleOfMeasurement[] VALUES_ARRAY =
		new ScaleOfMeasurement[] {
			NOMINAL,
			ORDINAL,
			INTERVAL,
			RATIO,
			CUSTOM,
		};

	/**
	 * A public read-only list of all the '<em><b>Scale Of Measurement</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ScaleOfMeasurement> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Scale Of Measurement</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ScaleOfMeasurement get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ScaleOfMeasurement result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Scale Of Measurement</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ScaleOfMeasurement getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ScaleOfMeasurement result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Scale Of Measurement</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ScaleOfMeasurement get(int value) {
		switch (value) {
			case NOMINAL_VALUE: return NOMINAL;
			case ORDINAL_VALUE: return ORDINAL;
			case INTERVAL_VALUE: return INTERVAL;
			case RATIO_VALUE: return RATIO;
			case CUSTOM_VALUE: return CUSTOM;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ScaleOfMeasurement(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ScaleOfMeasurement
