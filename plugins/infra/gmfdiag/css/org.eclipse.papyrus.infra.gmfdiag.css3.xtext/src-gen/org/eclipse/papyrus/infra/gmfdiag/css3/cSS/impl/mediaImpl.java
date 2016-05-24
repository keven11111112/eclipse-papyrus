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
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.media;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.ruleset;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>media</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.mediaImpl#getMedialist <em>Medialist</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.mediaImpl#getRulesets <em>Rulesets</em>}</li>
 * </ul>
 *
 * @generated
 */
public class mediaImpl extends MinimalEObjectImpl.Container implements media {
	/**
	 * The default value of the '{@link #getMedialist() <em>Medialist</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getMedialist()
	 * @generated
	 * @ordered
	 */
	protected static final String MEDIALIST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMedialist() <em>Medialist</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getMedialist()
	 * @generated
	 * @ordered
	 */
	protected String medialist = MEDIALIST_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRulesets() <em>Rulesets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getRulesets()
	 * @generated
	 * @ordered
	 */
	protected EList<ruleset> rulesets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected mediaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSSPackage.Literals.MEDIA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getMedialist() {
		return medialist;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setMedialist(String newMedialist) {
		String oldMedialist = medialist;
		medialist = newMedialist;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, CSSPackage.MEDIA__MEDIALIST, oldMedialist, medialist));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<ruleset> getRulesets() {
		if (rulesets == null) {
			rulesets = new EObjectContainmentEList<>(ruleset.class, this, CSSPackage.MEDIA__RULESETS);
		}
		return rulesets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CSSPackage.MEDIA__RULESETS:
			return ((InternalEList<?>) getRulesets()).basicRemove(otherEnd, msgs);
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CSSPackage.MEDIA__MEDIALIST:
			return getMedialist();
		case CSSPackage.MEDIA__RULESETS:
			return getRulesets();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case CSSPackage.MEDIA__MEDIALIST:
			setMedialist((String) newValue);
			return;
		case CSSPackage.MEDIA__RULESETS:
			getRulesets().clear();
			getRulesets().addAll((Collection<? extends ruleset>) newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
		case CSSPackage.MEDIA__MEDIALIST:
			setMedialist(MEDIALIST_EDEFAULT);
			return;
		case CSSPackage.MEDIA__RULESETS:
			getRulesets().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case CSSPackage.MEDIA__MEDIALIST:
			return MEDIALIST_EDEFAULT == null ? medialist != null : !MEDIALIST_EDEFAULT.equals(medialist);
		case CSSPackage.MEDIA__RULESETS:
			return rulesets != null && !rulesets.isEmpty();
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
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (medialist: ");
		result.append(medialist);
		result.append(')');
		return result.toString();
	}

} // mediaImpl
