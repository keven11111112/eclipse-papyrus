/**
 */
package org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Representation Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionModelPackage#getRepresentationKind()
 * @model
 * @generated
 */
public enum RepresentationKind implements Enumerator {
	/**
	 * The '<em><b>Shape</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHAPE_VALUE
	 * @generated
	 * @ordered
	 */
	SHAPE(0, "shape", "shape"),

	/**
	 * The '<em><b>Label</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LABEL_VALUE
	 * @generated
	 * @ordered
	 */
	LABEL(1, "label", "label"),

	/**
	 * The '<em><b>Link</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINK_VALUE
	 * @generated
	 * @ordered
	 */
	LINK(2, "link", "link"),

	/**
	 * The '<em><b>Border Item</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BORDER_ITEM_VALUE
	 * @generated
	 * @ordered
	 */
	BORDER_ITEM(3, "borderItem", "borderItem"),

	/**
	 * The '<em><b>Border Item Label</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BORDER_ITEM_LABEL_VALUE
	 * @generated
	 * @ordered
	 */
	BORDER_ITEM_LABEL(4, "borderItemLabel", "borderItemLabel"),

	/**
	 * The '<em><b>Custom</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CUSTOM_VALUE
	 * @generated
	 * @ordered
	 */
	CUSTOM(5, "custom", "custom");

	/**
	 * The '<em><b>Shape</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Shape</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHAPE
	 * @model name="shape"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='Shape'"
	 * @generated
	 * @ordered
	 */
	public static final int SHAPE_VALUE = 0;

	/**
	 * The '<em><b>Label</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Label</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LABEL
	 * @model name="label"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='Label'"
	 * @generated
	 * @ordered
	 */
	public static final int LABEL_VALUE = 1;

	/**
	 * The '<em><b>Link</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Link</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LINK
	 * @model name="link"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='Link'"
	 * @generated
	 * @ordered
	 */
	public static final int LINK_VALUE = 2;

	/**
	 * The '<em><b>Border Item</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Border Item</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BORDER_ITEM
	 * @model name="borderItem"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='BorderItem'"
	 * @generated
	 * @ordered
	 */
	public static final int BORDER_ITEM_VALUE = 3;

	/**
	 * The '<em><b>Border Item Label</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Border Item Label</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BORDER_ITEM_LABEL
	 * @model name="borderItemLabel"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='BorderItemLabel'"
	 * @generated
	 * @ordered
	 */
	public static final int BORDER_ITEM_LABEL_VALUE = 4;

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
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='Custom'"
	 * @generated
	 * @ordered
	 */
	public static final int CUSTOM_VALUE = 5;

	/**
	 * An array of all the '<em><b>Representation Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RepresentationKind[] VALUES_ARRAY =
		new RepresentationKind[] {
			SHAPE,
			LABEL,
			LINK,
			BORDER_ITEM,
			BORDER_ITEM_LABEL,
			CUSTOM,
		};

	/**
	 * A public read-only list of all the '<em><b>Representation Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<RepresentationKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Representation Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RepresentationKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RepresentationKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Representation Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RepresentationKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RepresentationKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Representation Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RepresentationKind get(int value) {
		switch (value) {
			case SHAPE_VALUE: return SHAPE;
			case LABEL_VALUE: return LABEL;
			case LINK_VALUE: return LINK;
			case BORDER_ITEM_VALUE: return BORDER_ITEM;
			case BORDER_ITEM_LABEL_VALUE: return BORDER_ITEM_LABEL;
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
	private RepresentationKind(int value, String name, String literal) {
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
	
} //RepresentationKind
