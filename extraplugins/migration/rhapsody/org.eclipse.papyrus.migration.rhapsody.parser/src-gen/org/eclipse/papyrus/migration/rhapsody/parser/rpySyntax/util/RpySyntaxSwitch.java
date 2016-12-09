/**
 */
package org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage
 * @generated
 */
public class RpySyntaxSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static RpySyntaxPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RpySyntaxSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = RpySyntaxPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case RpySyntaxPackage.RPY_FILE:
      {
        RpyFile rpyFile = (RpyFile)theEObject;
        T result = caseRpyFile(rpyFile);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RpySyntaxPackage.RPY_CONTENT:
      {
        RpyContent rpyContent = (RpyContent)theEObject;
        T result = caseRpyContent(rpyContent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RpySyntaxPackage.RPY_NODE:
      {
        RpyNode rpyNode = (RpyNode)theEObject;
        T result = caseRpyNode(rpyNode);
        if (result == null) result = caseRpyContent(rpyNode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RpySyntaxPackage.RPY_FEATURE:
      {
        RpyFeature rpyFeature = (RpyFeature)theEObject;
        T result = caseRpyFeature(rpyFeature);
        if (result == null) result = caseRpyContent(rpyFeature);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RpySyntaxPackage.RPY_FEATURE_VALUE:
      {
        RpyFeatureValue rpyFeatureValue = (RpyFeatureValue)theEObject;
        T result = caseRpyFeatureValue(rpyFeatureValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RpySyntaxPackage.RPY_NODE_LIST:
      {
        RpyNodeList rpyNodeList = (RpyNodeList)theEObject;
        T result = caseRpyNodeList(rpyNodeList);
        if (result == null) result = caseRpyFeatureValue(rpyNodeList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RpySyntaxPackage.SIMPLE_VALUE_LIST:
      {
        SimpleValueList simpleValueList = (SimpleValueList)theEObject;
        T result = caseSimpleValueList(simpleValueList);
        if (result == null) result = caseRpyFeatureValue(simpleValueList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RpySyntaxPackage.RPY_SIMPLE_VALUE_ELEMENT:
      {
        RpySimpleValueElement rpySimpleValueElement = (RpySimpleValueElement)theEObject;
        T result = caseRpySimpleValueElement(rpySimpleValueElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RpySyntaxPackage.RPY_STRING_MAP:
      {
        RpyStringMap rpyStringMap = (RpyStringMap)theEObject;
        T result = caseRpyStringMap(rpyStringMap);
        if (result == null) result = caseRpyFeatureValue(rpyStringMap);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RpySyntaxPackage.RPY_STRING_MAP_ENTRY:
      {
        RpyStringMapEntry rpyStringMapEntry = (RpyStringMapEntry)theEObject;
        T result = caseRpyStringMapEntry(rpyStringMapEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rpy File</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rpy File</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRpyFile(RpyFile object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rpy Content</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rpy Content</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRpyContent(RpyContent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rpy Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rpy Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRpyNode(RpyNode object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rpy Feature</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rpy Feature</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRpyFeature(RpyFeature object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rpy Feature Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rpy Feature Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRpyFeatureValue(RpyFeatureValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rpy Node List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rpy Node List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRpyNodeList(RpyNodeList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Value List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Value List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleValueList(SimpleValueList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rpy Simple Value Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rpy Simple Value Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRpySimpleValueElement(RpySimpleValueElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rpy String Map</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rpy String Map</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRpyStringMap(RpyStringMap object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rpy String Map Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rpy String Map Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRpyStringMapEntry(RpyStringMapEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //RpySyntaxSwitch
