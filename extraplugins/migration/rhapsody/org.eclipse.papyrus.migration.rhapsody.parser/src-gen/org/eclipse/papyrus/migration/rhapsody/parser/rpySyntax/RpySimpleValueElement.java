/**
 */
package org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rpy Simple Value Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySimpleValueElement#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage#getRpySimpleValueElement()
 * @model
 * @generated
 */
public interface RpySimpleValueElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Values</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' attribute list.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage#getRpySimpleValueElement_Values()
   * @model unique="false"
   * @generated
   */
  EList<String> getValues();

} // RpySimpleValueElement
