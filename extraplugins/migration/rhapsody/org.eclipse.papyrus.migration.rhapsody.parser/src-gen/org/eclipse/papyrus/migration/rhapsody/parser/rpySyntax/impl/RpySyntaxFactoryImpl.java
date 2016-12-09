/**
 */
package org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RpySyntaxFactoryImpl extends EFactoryImpl implements RpySyntaxFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static RpySyntaxFactory init()
  {
    try
    {
      RpySyntaxFactory theRpySyntaxFactory = (RpySyntaxFactory)EPackage.Registry.INSTANCE.getEFactory(RpySyntaxPackage.eNS_URI);
      if (theRpySyntaxFactory != null)
      {
        return theRpySyntaxFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new RpySyntaxFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RpySyntaxFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case RpySyntaxPackage.RPY_FILE: return createRpyFile();
      case RpySyntaxPackage.RPY_CONTENT: return createRpyContent();
      case RpySyntaxPackage.RPY_NODE: return createRpyNode();
      case RpySyntaxPackage.RPY_FEATURE: return createRpyFeature();
      case RpySyntaxPackage.RPY_FEATURE_VALUE: return createRpyFeatureValue();
      case RpySyntaxPackage.RPY_NODE_LIST: return createRpyNodeList();
      case RpySyntaxPackage.SIMPLE_VALUE_LIST: return createSimpleValueList();
      case RpySyntaxPackage.RPY_SIMPLE_VALUE_ELEMENT: return createRpySimpleValueElement();
      case RpySyntaxPackage.RPY_STRING_MAP: return createRpyStringMap();
      case RpySyntaxPackage.RPY_STRING_MAP_ENTRY: return createRpyStringMapEntry();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RpyFile createRpyFile()
  {
    RpyFileImpl rpyFile = new RpyFileImpl();
    return rpyFile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RpyContent createRpyContent()
  {
    RpyContentImpl rpyContent = new RpyContentImpl();
    return rpyContent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RpyNode createRpyNode()
  {
    RpyNodeImpl rpyNode = new RpyNodeImpl();
    return rpyNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RpyFeature createRpyFeature()
  {
    RpyFeatureImpl rpyFeature = new RpyFeatureImpl();
    return rpyFeature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RpyFeatureValue createRpyFeatureValue()
  {
    RpyFeatureValueImpl rpyFeatureValue = new RpyFeatureValueImpl();
    return rpyFeatureValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RpyNodeList createRpyNodeList()
  {
    RpyNodeListImpl rpyNodeList = new RpyNodeListImpl();
    return rpyNodeList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleValueList createSimpleValueList()
  {
    SimpleValueListImpl simpleValueList = new SimpleValueListImpl();
    return simpleValueList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RpySimpleValueElement createRpySimpleValueElement()
  {
    RpySimpleValueElementImpl rpySimpleValueElement = new RpySimpleValueElementImpl();
    return rpySimpleValueElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RpyStringMap createRpyStringMap()
  {
    RpyStringMapImpl rpyStringMap = new RpyStringMapImpl();
    return rpyStringMap;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RpyStringMapEntry createRpyStringMapEntry()
  {
    RpyStringMapEntryImpl rpyStringMapEntry = new RpyStringMapEntryImpl();
    return rpyStringMapEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RpySyntaxPackage getRpySyntaxPackage()
  {
    return (RpySyntaxPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static RpySyntaxPackage getPackage()
  {
    return RpySyntaxPackage.eINSTANCE;
  }

} //RpySyntaxFactoryImpl
