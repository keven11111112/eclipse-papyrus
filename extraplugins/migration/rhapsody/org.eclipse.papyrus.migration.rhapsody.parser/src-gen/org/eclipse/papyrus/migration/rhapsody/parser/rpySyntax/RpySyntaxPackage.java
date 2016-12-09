/**
 */
package org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxFactory
 * @model kind="package"
 * @generated
 */
public interface RpySyntaxPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "rpySyntax";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/papyrus/rhapsody/RpySyntax";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "rpySyntax";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  RpySyntaxPackage eINSTANCE = org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyFileImpl <em>Rpy File</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyFileImpl
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getRpyFile()
   * @generated
   */
  int RPY_FILE = 0;

  /**
   * The feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_FILE__VERSION = 0;

  /**
   * The feature id for the '<em><b>Contents</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_FILE__CONTENTS = 1;

  /**
   * The number of structural features of the '<em>Rpy File</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_FILE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyContentImpl <em>Rpy Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyContentImpl
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getRpyContent()
   * @generated
   */
  int RPY_CONTENT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_CONTENT__NAME = 0;

  /**
   * The number of structural features of the '<em>Rpy Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_CONTENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyNodeImpl <em>Rpy Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyNodeImpl
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getRpyNode()
   * @generated
   */
  int RPY_NODE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_NODE__NAME = RPY_CONTENT__NAME;

  /**
   * The feature id for the '<em><b>Contents</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_NODE__CONTENTS = RPY_CONTENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Rpy Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_NODE_FEATURE_COUNT = RPY_CONTENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyFeatureImpl <em>Rpy Feature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyFeatureImpl
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getRpyFeature()
   * @generated
   */
  int RPY_FEATURE = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_FEATURE__NAME = RPY_CONTENT__NAME;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_FEATURE__VALUE = RPY_CONTENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Rpy Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_FEATURE_FEATURE_COUNT = RPY_CONTENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyFeatureValueImpl <em>Rpy Feature Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyFeatureValueImpl
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getRpyFeatureValue()
   * @generated
   */
  int RPY_FEATURE_VALUE = 4;

  /**
   * The number of structural features of the '<em>Rpy Feature Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_FEATURE_VALUE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyNodeListImpl <em>Rpy Node List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyNodeListImpl
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getRpyNodeList()
   * @generated
   */
  int RPY_NODE_LIST = 5;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_NODE_LIST__VALUES = RPY_FEATURE_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Rpy Node List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_NODE_LIST_FEATURE_COUNT = RPY_FEATURE_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.SimpleValueListImpl <em>Simple Value List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.SimpleValueListImpl
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getSimpleValueList()
   * @generated
   */
  int SIMPLE_VALUE_LIST = 6;

  /**
   * The feature id for the '<em><b>Is Old ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_VALUE_LIST__IS_OLD_ID = RPY_FEATURE_VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Is GUID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_VALUE_LIST__IS_GUID = RPY_FEATURE_VALUE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Value Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_VALUE_LIST__VALUE_ELEMENTS = RPY_FEATURE_VALUE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Simple Value List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_VALUE_LIST_FEATURE_COUNT = RPY_FEATURE_VALUE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySimpleValueElementImpl <em>Rpy Simple Value Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySimpleValueElementImpl
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getRpySimpleValueElement()
   * @generated
   */
  int RPY_SIMPLE_VALUE_ELEMENT = 7;

  /**
   * The feature id for the '<em><b>Values</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_SIMPLE_VALUE_ELEMENT__VALUES = 0;

  /**
   * The number of structural features of the '<em>Rpy Simple Value Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_SIMPLE_VALUE_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyStringMapImpl <em>Rpy String Map</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyStringMapImpl
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getRpyStringMap()
   * @generated
   */
  int RPY_STRING_MAP = 8;

  /**
   * The feature id for the '<em><b>Entries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_STRING_MAP__ENTRIES = RPY_FEATURE_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Rpy String Map</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_STRING_MAP_FEATURE_COUNT = RPY_FEATURE_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyStringMapEntryImpl <em>Rpy String Map Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyStringMapEntryImpl
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getRpyStringMapEntry()
   * @generated
   */
  int RPY_STRING_MAP_ENTRY = 9;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_STRING_MAP_ENTRY__KEY = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_STRING_MAP_ENTRY__VALUE = 1;

  /**
   * The number of structural features of the '<em>Rpy String Map Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RPY_STRING_MAP_ENTRY_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFile <em>Rpy File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rpy File</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFile
   * @generated
   */
  EClass getRpyFile();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFile#getVersion <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Version</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFile#getVersion()
   * @see #getRpyFile()
   * @generated
   */
  EAttribute getRpyFile_Version();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFile#getContents <em>Contents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contents</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFile#getContents()
   * @see #getRpyFile()
   * @generated
   */
  EReference getRpyFile_Contents();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyContent <em>Rpy Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rpy Content</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyContent
   * @generated
   */
  EClass getRpyContent();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyContent#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyContent#getName()
   * @see #getRpyContent()
   * @generated
   */
  EAttribute getRpyContent_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNode <em>Rpy Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rpy Node</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNode
   * @generated
   */
  EClass getRpyNode();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNode#getContents <em>Contents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contents</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNode#getContents()
   * @see #getRpyNode()
   * @generated
   */
  EReference getRpyNode_Contents();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeature <em>Rpy Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rpy Feature</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeature
   * @generated
   */
  EClass getRpyFeature();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeature#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeature#getValue()
   * @see #getRpyFeature()
   * @generated
   */
  EReference getRpyFeature_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeatureValue <em>Rpy Feature Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rpy Feature Value</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeatureValue
   * @generated
   */
  EClass getRpyFeatureValue();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNodeList <em>Rpy Node List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rpy Node List</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNodeList
   * @generated
   */
  EClass getRpyNodeList();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNodeList#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNodeList#getValues()
   * @see #getRpyNodeList()
   * @generated
   */
  EReference getRpyNodeList_Values();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList <em>Simple Value List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Value List</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList
   * @generated
   */
  EClass getSimpleValueList();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList#isIsOldID <em>Is Old ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Old ID</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList#isIsOldID()
   * @see #getSimpleValueList()
   * @generated
   */
  EAttribute getSimpleValueList_IsOldID();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList#isIsGUID <em>Is GUID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is GUID</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList#isIsGUID()
   * @see #getSimpleValueList()
   * @generated
   */
  EAttribute getSimpleValueList_IsGUID();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList#getValueElements <em>Value Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Value Elements</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList#getValueElements()
   * @see #getSimpleValueList()
   * @generated
   */
  EReference getSimpleValueList_ValueElements();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySimpleValueElement <em>Rpy Simple Value Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rpy Simple Value Element</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySimpleValueElement
   * @generated
   */
  EClass getRpySimpleValueElement();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySimpleValueElement#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Values</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySimpleValueElement#getValues()
   * @see #getRpySimpleValueElement()
   * @generated
   */
  EAttribute getRpySimpleValueElement_Values();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMap <em>Rpy String Map</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rpy String Map</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMap
   * @generated
   */
  EClass getRpyStringMap();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMap#getEntries <em>Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entries</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMap#getEntries()
   * @see #getRpyStringMap()
   * @generated
   */
  EReference getRpyStringMap_Entries();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMapEntry <em>Rpy String Map Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rpy String Map Entry</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMapEntry
   * @generated
   */
  EClass getRpyStringMapEntry();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMapEntry#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMapEntry#getKey()
   * @see #getRpyStringMapEntry()
   * @generated
   */
  EAttribute getRpyStringMapEntry_Key();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMapEntry#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMapEntry#getValue()
   * @see #getRpyStringMapEntry()
   * @generated
   */
  EAttribute getRpyStringMapEntry_Value();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  RpySyntaxFactory getRpySyntaxFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyFileImpl <em>Rpy File</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyFileImpl
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getRpyFile()
     * @generated
     */
    EClass RPY_FILE = eINSTANCE.getRpyFile();

    /**
     * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RPY_FILE__VERSION = eINSTANCE.getRpyFile_Version();

    /**
     * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RPY_FILE__CONTENTS = eINSTANCE.getRpyFile_Contents();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyContentImpl <em>Rpy Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyContentImpl
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getRpyContent()
     * @generated
     */
    EClass RPY_CONTENT = eINSTANCE.getRpyContent();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RPY_CONTENT__NAME = eINSTANCE.getRpyContent_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyNodeImpl <em>Rpy Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyNodeImpl
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getRpyNode()
     * @generated
     */
    EClass RPY_NODE = eINSTANCE.getRpyNode();

    /**
     * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RPY_NODE__CONTENTS = eINSTANCE.getRpyNode_Contents();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyFeatureImpl <em>Rpy Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyFeatureImpl
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getRpyFeature()
     * @generated
     */
    EClass RPY_FEATURE = eINSTANCE.getRpyFeature();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RPY_FEATURE__VALUE = eINSTANCE.getRpyFeature_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyFeatureValueImpl <em>Rpy Feature Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyFeatureValueImpl
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getRpyFeatureValue()
     * @generated
     */
    EClass RPY_FEATURE_VALUE = eINSTANCE.getRpyFeatureValue();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyNodeListImpl <em>Rpy Node List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyNodeListImpl
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getRpyNodeList()
     * @generated
     */
    EClass RPY_NODE_LIST = eINSTANCE.getRpyNodeList();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RPY_NODE_LIST__VALUES = eINSTANCE.getRpyNodeList_Values();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.SimpleValueListImpl <em>Simple Value List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.SimpleValueListImpl
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getSimpleValueList()
     * @generated
     */
    EClass SIMPLE_VALUE_LIST = eINSTANCE.getSimpleValueList();

    /**
     * The meta object literal for the '<em><b>Is Old ID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_VALUE_LIST__IS_OLD_ID = eINSTANCE.getSimpleValueList_IsOldID();

    /**
     * The meta object literal for the '<em><b>Is GUID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_VALUE_LIST__IS_GUID = eINSTANCE.getSimpleValueList_IsGUID();

    /**
     * The meta object literal for the '<em><b>Value Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIMPLE_VALUE_LIST__VALUE_ELEMENTS = eINSTANCE.getSimpleValueList_ValueElements();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySimpleValueElementImpl <em>Rpy Simple Value Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySimpleValueElementImpl
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getRpySimpleValueElement()
     * @generated
     */
    EClass RPY_SIMPLE_VALUE_ELEMENT = eINSTANCE.getRpySimpleValueElement();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RPY_SIMPLE_VALUE_ELEMENT__VALUES = eINSTANCE.getRpySimpleValueElement_Values();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyStringMapImpl <em>Rpy String Map</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyStringMapImpl
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getRpyStringMap()
     * @generated
     */
    EClass RPY_STRING_MAP = eINSTANCE.getRpyStringMap();

    /**
     * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RPY_STRING_MAP__ENTRIES = eINSTANCE.getRpyStringMap_Entries();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyStringMapEntryImpl <em>Rpy String Map Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpyStringMapEntryImpl
     * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.RpySyntaxPackageImpl#getRpyStringMapEntry()
     * @generated
     */
    EClass RPY_STRING_MAP_ENTRY = eINSTANCE.getRpyStringMapEntry();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RPY_STRING_MAP_ENTRY__KEY = eINSTANCE.getRpyStringMapEntry_Key();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RPY_STRING_MAP_ENTRY__VALUE = eINSTANCE.getRpyStringMapEntry_Value();

  }

} //RpySyntaxPackage
