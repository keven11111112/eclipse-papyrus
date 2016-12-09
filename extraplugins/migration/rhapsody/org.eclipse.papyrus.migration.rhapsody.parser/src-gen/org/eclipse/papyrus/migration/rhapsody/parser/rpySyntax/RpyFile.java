/**
 */
package org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rpy File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFile#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFile#getContents <em>Contents</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage#getRpyFile()
 * @model
 * @generated
 */
public interface RpyFile extends EObject
{
  /**
   * Returns the value of the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Version</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Version</em>' attribute.
   * @see #setVersion(String)
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage#getRpyFile_Version()
   * @model
   * @generated
   */
  String getVersion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFile#getVersion <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version</em>' attribute.
   * @see #getVersion()
   * @generated
   */
  void setVersion(String value);

  /**
   * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyContent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contents</em>' containment reference list.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage#getRpyFile_Contents()
   * @model containment="true"
   * @generated
   */
  EList<RpyContent> getContents();

} // RpyFile
