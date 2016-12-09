/**
 */
package org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Value List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList#isIsOldID <em>Is Old ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList#isIsGUID <em>Is GUID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList#getValueElements <em>Value Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage#getSimpleValueList()
 * @model
 * @generated
 */
public interface SimpleValueList extends RpyFeatureValue
{
  /**
   * Returns the value of the '<em><b>Is Old ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Old ID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Old ID</em>' attribute.
   * @see #setIsOldID(boolean)
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage#getSimpleValueList_IsOldID()
   * @model
   * @generated
   */
  boolean isIsOldID();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList#isIsOldID <em>Is Old ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Old ID</em>' attribute.
   * @see #isIsOldID()
   * @generated
   */
  void setIsOldID(boolean value);

  /**
   * Returns the value of the '<em><b>Is GUID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is GUID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is GUID</em>' attribute.
   * @see #setIsGUID(boolean)
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage#getSimpleValueList_IsGUID()
   * @model
   * @generated
   */
  boolean isIsGUID();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList#isIsGUID <em>Is GUID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is GUID</em>' attribute.
   * @see #isIsGUID()
   * @generated
   */
  void setIsGUID(boolean value);

  /**
   * Returns the value of the '<em><b>Value Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySimpleValueElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value Elements</em>' containment reference list.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage#getSimpleValueList_ValueElements()
   * @model containment="true"
   * @generated
   */
  EList<RpySimpleValueElement> getValueElements();

} // SimpleValueList
