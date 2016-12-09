/**
 */
package org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage
 * @generated
 */
public interface RpySyntaxFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  RpySyntaxFactory eINSTANCE = org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Rpy File</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rpy File</em>'.
   * @generated
   */
  RpyFile createRpyFile();

  /**
   * Returns a new object of class '<em>Rpy Content</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rpy Content</em>'.
   * @generated
   */
  RpyContent createRpyContent();

  /**
   * Returns a new object of class '<em>Rpy Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rpy Node</em>'.
   * @generated
   */
  RpyNode createRpyNode();

  /**
   * Returns a new object of class '<em>Rpy Feature</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rpy Feature</em>'.
   * @generated
   */
  RpyFeature createRpyFeature();

  /**
   * Returns a new object of class '<em>Rpy Feature Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rpy Feature Value</em>'.
   * @generated
   */
  RpyFeatureValue createRpyFeatureValue();

  /**
   * Returns a new object of class '<em>Rpy Node List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rpy Node List</em>'.
   * @generated
   */
  RpyNodeList createRpyNodeList();

  /**
   * Returns a new object of class '<em>Simple Value List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple Value List</em>'.
   * @generated
   */
  SimpleValueList createSimpleValueList();

  /**
   * Returns a new object of class '<em>Rpy Simple Value Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rpy Simple Value Element</em>'.
   * @generated
   */
  RpySimpleValueElement createRpySimpleValueElement();

  /**
   * Returns a new object of class '<em>Rpy String Map</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rpy String Map</em>'.
   * @generated
   */
  RpyStringMap createRpyStringMap();

  /**
   * Returns a new object of class '<em>Rpy String Map Entry</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rpy String Map Entry</em>'.
   * @generated
   */
  RpyStringMapEntry createRpyStringMapEntry();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  RpySyntaxPackage getRpySyntaxPackage();

} //RpySyntaxFactory
