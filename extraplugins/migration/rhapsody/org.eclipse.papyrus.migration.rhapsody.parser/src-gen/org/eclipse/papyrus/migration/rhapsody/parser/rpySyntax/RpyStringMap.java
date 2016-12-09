/**
 */
package org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rpy String Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMap#getEntries <em>Entries</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage#getRpyStringMap()
 * @model
 * @generated
 */
public interface RpyStringMap extends RpyFeatureValue
{
  /**
   * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMapEntry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entries</em>' containment reference list.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage#getRpyStringMap_Entries()
   * @model containment="true"
   * @generated
   */
  EList<RpyStringMapEntry> getEntries();

} // RpyStringMap
