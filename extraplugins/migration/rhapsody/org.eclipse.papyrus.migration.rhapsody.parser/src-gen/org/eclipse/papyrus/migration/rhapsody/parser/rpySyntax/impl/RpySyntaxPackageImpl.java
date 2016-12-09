/**
 */
package org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyContent;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeature;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeatureValue;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFile;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNode;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNodeList;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySimpleValueElement;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMap;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMapEntry;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxFactory;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RpySyntaxPackageImpl extends EPackageImpl implements RpySyntaxPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rpyFileEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rpyContentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rpyNodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rpyFeatureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rpyFeatureValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rpyNodeListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleValueListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rpySimpleValueElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rpyStringMapEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rpyStringMapEntryEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private RpySyntaxPackageImpl()
  {
    super(eNS_URI, RpySyntaxFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link RpySyntaxPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static RpySyntaxPackage init()
  {
    if (isInited) return (RpySyntaxPackage)EPackage.Registry.INSTANCE.getEPackage(RpySyntaxPackage.eNS_URI);

    // Obtain or create and register package
    RpySyntaxPackageImpl theRpySyntaxPackage = (RpySyntaxPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RpySyntaxPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RpySyntaxPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theRpySyntaxPackage.createPackageContents();

    // Initialize created meta-data
    theRpySyntaxPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theRpySyntaxPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(RpySyntaxPackage.eNS_URI, theRpySyntaxPackage);
    return theRpySyntaxPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRpyFile()
  {
    return rpyFileEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRpyFile_Version()
  {
    return (EAttribute)rpyFileEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRpyFile_Contents()
  {
    return (EReference)rpyFileEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRpyContent()
  {
    return rpyContentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRpyContent_Name()
  {
    return (EAttribute)rpyContentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRpyNode()
  {
    return rpyNodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRpyNode_Contents()
  {
    return (EReference)rpyNodeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRpyFeature()
  {
    return rpyFeatureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRpyFeature_Value()
  {
    return (EReference)rpyFeatureEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRpyFeatureValue()
  {
    return rpyFeatureValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRpyNodeList()
  {
    return rpyNodeListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRpyNodeList_Values()
  {
    return (EReference)rpyNodeListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleValueList()
  {
    return simpleValueListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleValueList_IsOldID()
  {
    return (EAttribute)simpleValueListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleValueList_IsGUID()
  {
    return (EAttribute)simpleValueListEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSimpleValueList_ValueElements()
  {
    return (EReference)simpleValueListEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRpySimpleValueElement()
  {
    return rpySimpleValueElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRpySimpleValueElement_Values()
  {
    return (EAttribute)rpySimpleValueElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRpyStringMap()
  {
    return rpyStringMapEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRpyStringMap_Entries()
  {
    return (EReference)rpyStringMapEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRpyStringMapEntry()
  {
    return rpyStringMapEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRpyStringMapEntry_Key()
  {
    return (EAttribute)rpyStringMapEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRpyStringMapEntry_Value()
  {
    return (EAttribute)rpyStringMapEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RpySyntaxFactory getRpySyntaxFactory()
  {
    return (RpySyntaxFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    rpyFileEClass = createEClass(RPY_FILE);
    createEAttribute(rpyFileEClass, RPY_FILE__VERSION);
    createEReference(rpyFileEClass, RPY_FILE__CONTENTS);

    rpyContentEClass = createEClass(RPY_CONTENT);
    createEAttribute(rpyContentEClass, RPY_CONTENT__NAME);

    rpyNodeEClass = createEClass(RPY_NODE);
    createEReference(rpyNodeEClass, RPY_NODE__CONTENTS);

    rpyFeatureEClass = createEClass(RPY_FEATURE);
    createEReference(rpyFeatureEClass, RPY_FEATURE__VALUE);

    rpyFeatureValueEClass = createEClass(RPY_FEATURE_VALUE);

    rpyNodeListEClass = createEClass(RPY_NODE_LIST);
    createEReference(rpyNodeListEClass, RPY_NODE_LIST__VALUES);

    simpleValueListEClass = createEClass(SIMPLE_VALUE_LIST);
    createEAttribute(simpleValueListEClass, SIMPLE_VALUE_LIST__IS_OLD_ID);
    createEAttribute(simpleValueListEClass, SIMPLE_VALUE_LIST__IS_GUID);
    createEReference(simpleValueListEClass, SIMPLE_VALUE_LIST__VALUE_ELEMENTS);

    rpySimpleValueElementEClass = createEClass(RPY_SIMPLE_VALUE_ELEMENT);
    createEAttribute(rpySimpleValueElementEClass, RPY_SIMPLE_VALUE_ELEMENT__VALUES);

    rpyStringMapEClass = createEClass(RPY_STRING_MAP);
    createEReference(rpyStringMapEClass, RPY_STRING_MAP__ENTRIES);

    rpyStringMapEntryEClass = createEClass(RPY_STRING_MAP_ENTRY);
    createEAttribute(rpyStringMapEntryEClass, RPY_STRING_MAP_ENTRY__KEY);
    createEAttribute(rpyStringMapEntryEClass, RPY_STRING_MAP_ENTRY__VALUE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    rpyNodeEClass.getESuperTypes().add(this.getRpyContent());
    rpyFeatureEClass.getESuperTypes().add(this.getRpyContent());
    rpyNodeListEClass.getESuperTypes().add(this.getRpyFeatureValue());
    simpleValueListEClass.getESuperTypes().add(this.getRpyFeatureValue());
    rpyStringMapEClass.getESuperTypes().add(this.getRpyFeatureValue());

    // Initialize classes and features; add operations and parameters
    initEClass(rpyFileEClass, RpyFile.class, "RpyFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRpyFile_Version(), ecorePackage.getEString(), "version", null, 0, 1, RpyFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRpyFile_Contents(), this.getRpyContent(), null, "contents", null, 0, -1, RpyFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rpyContentEClass, RpyContent.class, "RpyContent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRpyContent_Name(), ecorePackage.getEString(), "name", null, 0, 1, RpyContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rpyNodeEClass, RpyNode.class, "RpyNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRpyNode_Contents(), this.getRpyContent(), null, "contents", null, 0, -1, RpyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rpyFeatureEClass, RpyFeature.class, "RpyFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRpyFeature_Value(), this.getRpyFeatureValue(), null, "value", null, 0, 1, RpyFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rpyFeatureValueEClass, RpyFeatureValue.class, "RpyFeatureValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(rpyNodeListEClass, RpyNodeList.class, "RpyNodeList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRpyNodeList_Values(), this.getRpyNode(), null, "values", null, 0, -1, RpyNodeList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleValueListEClass, SimpleValueList.class, "SimpleValueList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimpleValueList_IsOldID(), ecorePackage.getEBoolean(), "isOldID", null, 0, 1, SimpleValueList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleValueList_IsGUID(), ecorePackage.getEBoolean(), "isGUID", null, 0, 1, SimpleValueList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSimpleValueList_ValueElements(), this.getRpySimpleValueElement(), null, "valueElements", null, 0, -1, SimpleValueList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rpySimpleValueElementEClass, RpySimpleValueElement.class, "RpySimpleValueElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRpySimpleValueElement_Values(), ecorePackage.getEString(), "values", null, 0, -1, RpySimpleValueElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rpyStringMapEClass, RpyStringMap.class, "RpyStringMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRpyStringMap_Entries(), this.getRpyStringMapEntry(), null, "entries", null, 0, -1, RpyStringMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rpyStringMapEntryEClass, RpyStringMapEntry.class, "RpyStringMapEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRpyStringMapEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, RpyStringMapEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRpyStringMapEntry_Value(), ecorePackage.getEString(), "value", null, 0, 1, RpyStringMapEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //RpySyntaxPackageImpl
