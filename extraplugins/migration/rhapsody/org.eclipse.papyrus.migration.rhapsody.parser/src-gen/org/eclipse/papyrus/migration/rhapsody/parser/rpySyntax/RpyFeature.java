/**
 */
package org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rpy Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeature#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage#getRpyFeature()
 * @model
 * @generated
 */
public interface RpyFeature extends RpyContent
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(RpyFeatureValue)
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage#getRpyFeature_Value()
   * @model containment="true"
   * @generated
   */
  RpyFeatureValue getValue();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeature#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(RpyFeatureValue value);

} // RpyFeature
