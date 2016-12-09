/**
 */
package org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rpy Node List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNodeList#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage#getRpyNodeList()
 * @model
 * @generated
 */
public interface RpyNodeList extends RpyFeatureValue
{
  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference list.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage#getRpyNodeList_Values()
   * @model containment="true"
   * @generated
   */
  EList<RpyNode> getValues();

} // RpyNodeList
