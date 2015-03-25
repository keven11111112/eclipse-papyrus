/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.css_declaration;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.keyframe_selector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>keyframe selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.keyframe_selectorImpl#getType <em>Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.keyframe_selectorImpl#getPercentage <em>Percentage</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.keyframe_selectorImpl#getDeclarations <em>Declarations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class keyframe_selectorImpl extends MinimalEObjectImpl.Container implements keyframe_selector
{
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPercentage() <em>Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double PERCENTAGE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPercentage() <em>Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getPercentage()
	 * @generated
	 * @ordered
	 */
	protected double percentage = PERCENTAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDeclarations() <em>Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<css_declaration> declarations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected keyframe_selectorImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return CSSPackage.Literals.KEYFRAME_SELECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getType()
	{
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setType(String newType)
	{
		String oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, CSSPackage.KEYFRAME_SELECTOR__TYPE, oldType, type));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public double getPercentage()
	{
		return percentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setPercentage(double newPercentage)
	{
		double oldPercentage = percentage;
		percentage = newPercentage;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, CSSPackage.KEYFRAME_SELECTOR__PERCENTAGE, oldPercentage, percentage));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<css_declaration> getDeclarations()
	{
		if (declarations == null)
		{
			declarations = new EObjectContainmentEList<css_declaration>(css_declaration.class, this, CSSPackage.KEYFRAME_SELECTOR__DECLARATIONS);
		}
		return declarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
		case CSSPackage.KEYFRAME_SELECTOR__DECLARATIONS:
			return ((InternalEList<?>) getDeclarations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
		case CSSPackage.KEYFRAME_SELECTOR__TYPE:
			return getType();
		case CSSPackage.KEYFRAME_SELECTOR__PERCENTAGE:
			return getPercentage();
		case CSSPackage.KEYFRAME_SELECTOR__DECLARATIONS:
			return getDeclarations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
		case CSSPackage.KEYFRAME_SELECTOR__TYPE:
			setType((String) newValue);
			return;
		case CSSPackage.KEYFRAME_SELECTOR__PERCENTAGE:
			setPercentage((Double) newValue);
			return;
		case CSSPackage.KEYFRAME_SELECTOR__DECLARATIONS:
			getDeclarations().clear();
			getDeclarations().addAll((Collection<? extends css_declaration>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
		case CSSPackage.KEYFRAME_SELECTOR__TYPE:
			setType(TYPE_EDEFAULT);
			return;
		case CSSPackage.KEYFRAME_SELECTOR__PERCENTAGE:
			setPercentage(PERCENTAGE_EDEFAULT);
			return;
		case CSSPackage.KEYFRAME_SELECTOR__DECLARATIONS:
			getDeclarations().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
		case CSSPackage.KEYFRAME_SELECTOR__TYPE:
			return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
		case CSSPackage.KEYFRAME_SELECTOR__PERCENTAGE:
			return percentage != PERCENTAGE_EDEFAULT;
		case CSSPackage.KEYFRAME_SELECTOR__DECLARATIONS:
			return declarations != null && !declarations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (type: ");
		result.append(type);
		result.append(", percentage: ");
		result.append(percentage);
		result.append(')');
		return result.toString();
	}

} // keyframe_selectorImpl
