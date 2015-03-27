/**
 */
package org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionModelPackage;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.GmftBasedRepresentation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gmft Based Representation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.GmftBasedRepresentationImpl#getReusedId <em>Reused Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GmftBasedRepresentationImpl extends RepresentationImpl implements GmftBasedRepresentation {
	/**
	 * The default value of the '{@link #getReusedId() <em>Reused Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReusedId()
	 * @generated
	 * @ordered
	 */
	protected static final String REUSED_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReusedId() <em>Reused Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReusedId()
	 * @generated
	 * @ordered
	 */
	protected String reusedId = REUSED_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GmftBasedRepresentationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpansionModelPackage.Literals.GMFT_BASED_REPRESENTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReusedId() {
		return reusedId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReusedId(String newReusedId) {
		String oldReusedId = reusedId;
		reusedId = newReusedId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpansionModelPackage.GMFT_BASED_REPRESENTATION__REUSED_ID, oldReusedId, reusedId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpansionModelPackage.GMFT_BASED_REPRESENTATION__REUSED_ID:
				return getReusedId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExpansionModelPackage.GMFT_BASED_REPRESENTATION__REUSED_ID:
				setReusedId((String)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExpansionModelPackage.GMFT_BASED_REPRESENTATION__REUSED_ID:
				setReusedId(REUSED_ID_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExpansionModelPackage.GMFT_BASED_REPRESENTATION__REUSED_ID:
				return REUSED_ID_EDEFAULT == null ? reusedId != null : !REUSED_ID_EDEFAULT.equals(reusedId);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (reusedId: ");
		result.append(reusedId);
		result.append(')');
		return result.toString();
	}

} //GmftBasedRepresentationImpl
