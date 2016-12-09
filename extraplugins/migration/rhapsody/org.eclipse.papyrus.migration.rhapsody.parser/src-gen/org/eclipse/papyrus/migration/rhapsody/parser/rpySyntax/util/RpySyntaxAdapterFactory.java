/**
 */
package org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage
 * @generated
 */
public class RpySyntaxAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static RpySyntaxPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RpySyntaxAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = RpySyntaxPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RpySyntaxSwitch<Adapter> modelSwitch =
    new RpySyntaxSwitch<Adapter>()
    {
      @Override
      public Adapter caseRpyFile(RpyFile object)
      {
        return createRpyFileAdapter();
      }
      @Override
      public Adapter caseRpyContent(RpyContent object)
      {
        return createRpyContentAdapter();
      }
      @Override
      public Adapter caseRpyNode(RpyNode object)
      {
        return createRpyNodeAdapter();
      }
      @Override
      public Adapter caseRpyFeature(RpyFeature object)
      {
        return createRpyFeatureAdapter();
      }
      @Override
      public Adapter caseRpyFeatureValue(RpyFeatureValue object)
      {
        return createRpyFeatureValueAdapter();
      }
      @Override
      public Adapter caseRpyNodeList(RpyNodeList object)
      {
        return createRpyNodeListAdapter();
      }
      @Override
      public Adapter caseSimpleValueList(SimpleValueList object)
      {
        return createSimpleValueListAdapter();
      }
      @Override
      public Adapter caseRpySimpleValueElement(RpySimpleValueElement object)
      {
        return createRpySimpleValueElementAdapter();
      }
      @Override
      public Adapter caseRpyStringMap(RpyStringMap object)
      {
        return createRpyStringMapAdapter();
      }
      @Override
      public Adapter caseRpyStringMapEntry(RpyStringMapEntry object)
      {
        return createRpyStringMapEntryAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFile <em>Rpy File</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFile
   * @generated
   */
  public Adapter createRpyFileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyContent <em>Rpy Content</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyContent
   * @generated
   */
  public Adapter createRpyContentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNode <em>Rpy Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNode
   * @generated
   */
  public Adapter createRpyNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeature <em>Rpy Feature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeature
   * @generated
   */
  public Adapter createRpyFeatureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeatureValue <em>Rpy Feature Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeatureValue
   * @generated
   */
  public Adapter createRpyFeatureValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNodeList <em>Rpy Node List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNodeList
   * @generated
   */
  public Adapter createRpyNodeListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList <em>Simple Value List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList
   * @generated
   */
  public Adapter createSimpleValueListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySimpleValueElement <em>Rpy Simple Value Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySimpleValueElement
   * @generated
   */
  public Adapter createRpySimpleValueElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMap <em>Rpy String Map</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMap
   * @generated
   */
  public Adapter createRpyStringMapAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMapEntry <em>Rpy String Map Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMapEntry
   * @generated
   */
  public Adapter createRpyStringMapEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //RpySyntaxAdapterFactory
