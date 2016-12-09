/**
 */
package org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySimpleValueElement;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Value List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.SimpleValueListImpl#isIsOldID <em>Is Old ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.SimpleValueListImpl#isIsGUID <em>Is GUID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.impl.SimpleValueListImpl#getValueElements <em>Value Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimpleValueListImpl extends RpyFeatureValueImpl implements SimpleValueList
{
  /**
   * The default value of the '{@link #isIsOldID() <em>Is Old ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsOldID()
   * @generated
   * @ordered
   */
  protected static final boolean IS_OLD_ID_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsOldID() <em>Is Old ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsOldID()
   * @generated
   * @ordered
   */
  protected boolean isOldID = IS_OLD_ID_EDEFAULT;

  /**
   * The default value of the '{@link #isIsGUID() <em>Is GUID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsGUID()
   * @generated
   * @ordered
   */
  protected static final boolean IS_GUID_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsGUID() <em>Is GUID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsGUID()
   * @generated
   * @ordered
   */
  protected boolean isGUID = IS_GUID_EDEFAULT;

  /**
   * The cached value of the '{@link #getValueElements() <em>Value Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueElements()
   * @generated
   * @ordered
   */
  protected EList<RpySimpleValueElement> valueElements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SimpleValueListImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return RpySyntaxPackage.Literals.SIMPLE_VALUE_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsOldID()
  {
    return isOldID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsOldID(boolean newIsOldID)
  {
    boolean oldIsOldID = isOldID;
    isOldID = newIsOldID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RpySyntaxPackage.SIMPLE_VALUE_LIST__IS_OLD_ID, oldIsOldID, isOldID));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsGUID()
  {
    return isGUID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsGUID(boolean newIsGUID)
  {
    boolean oldIsGUID = isGUID;
    isGUID = newIsGUID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RpySyntaxPackage.SIMPLE_VALUE_LIST__IS_GUID, oldIsGUID, isGUID));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RpySimpleValueElement> getValueElements()
  {
    if (valueElements == null)
    {
      valueElements = new EObjectContainmentEList<RpySimpleValueElement>(RpySimpleValueElement.class, this, RpySyntaxPackage.SIMPLE_VALUE_LIST__VALUE_ELEMENTS);
    }
    return valueElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case RpySyntaxPackage.SIMPLE_VALUE_LIST__VALUE_ELEMENTS:
        return ((InternalEList<?>)getValueElements()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case RpySyntaxPackage.SIMPLE_VALUE_LIST__IS_OLD_ID:
        return isIsOldID();
      case RpySyntaxPackage.SIMPLE_VALUE_LIST__IS_GUID:
        return isIsGUID();
      case RpySyntaxPackage.SIMPLE_VALUE_LIST__VALUE_ELEMENTS:
        return getValueElements();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case RpySyntaxPackage.SIMPLE_VALUE_LIST__IS_OLD_ID:
        setIsOldID((Boolean)newValue);
        return;
      case RpySyntaxPackage.SIMPLE_VALUE_LIST__IS_GUID:
        setIsGUID((Boolean)newValue);
        return;
      case RpySyntaxPackage.SIMPLE_VALUE_LIST__VALUE_ELEMENTS:
        getValueElements().clear();
        getValueElements().addAll((Collection<? extends RpySimpleValueElement>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case RpySyntaxPackage.SIMPLE_VALUE_LIST__IS_OLD_ID:
        setIsOldID(IS_OLD_ID_EDEFAULT);
        return;
      case RpySyntaxPackage.SIMPLE_VALUE_LIST__IS_GUID:
        setIsGUID(IS_GUID_EDEFAULT);
        return;
      case RpySyntaxPackage.SIMPLE_VALUE_LIST__VALUE_ELEMENTS:
        getValueElements().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case RpySyntaxPackage.SIMPLE_VALUE_LIST__IS_OLD_ID:
        return isOldID != IS_OLD_ID_EDEFAULT;
      case RpySyntaxPackage.SIMPLE_VALUE_LIST__IS_GUID:
        return isGUID != IS_GUID_EDEFAULT;
      case RpySyntaxPackage.SIMPLE_VALUE_LIST__VALUE_ELEMENTS:
        return valueElements != null && !valueElements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (isOldID: ");
    result.append(isOldID);
    result.append(", isGUID: ");
    result.append(isGUID);
    result.append(')');
    return result.toString();
  }

} //SimpleValueListImpl
