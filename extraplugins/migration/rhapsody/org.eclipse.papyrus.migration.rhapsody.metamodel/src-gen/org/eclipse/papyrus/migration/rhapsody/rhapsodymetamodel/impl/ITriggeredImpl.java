/**
 *   Copyright (c) 2016 CEA LIST and others.
 *   
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *     CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IModelElement;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IVariable;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItemsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pFormalMessageType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ITriggered</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITriggeredImpl#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITriggeredImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITriggeredImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITriggeredImpl#getArgs <em>Args</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITriggeredImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITriggeredImpl#getAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITriggeredImpl#getFinal <em>Final</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITriggeredImpl#getConcurrency <em>Concurrency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITriggeredImpl#getProtection <em>Protection</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITriggeredImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITriggeredImpl#getMyState <em>My State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ITriggeredImpl extends OperationsTypeImpl implements ITriggered {
	/**
	 * The default value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPLAY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected String displayName = DISPLAY_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgs()
	 * @generated
	 * @ordered
	 */
	protected EList<IVariable> args;

	/**
	 * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected IType returnType;

	/**
	 * The default value of the '{@link #getAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final String ABSTRACT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstract()
	 * @generated
	 * @ordered
	 */
	protected String abstract_ = ABSTRACT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFinal() <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinal()
	 * @generated
	 * @ordered
	 */
	protected static final String FINAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFinal() <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinal()
	 * @generated
	 * @ordered
	 */
	protected String final_ = FINAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getConcurrency() <em>Concurrency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcurrency()
	 * @generated
	 * @ordered
	 */
	protected static final String CONCURRENCY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConcurrency() <em>Concurrency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcurrency()
	 * @generated
	 * @ordered
	 */
	protected String concurrency = CONCURRENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getProtection() <em>Protection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtection()
	 * @generated
	 * @ordered
	 */
	protected static final String PROTECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProtection() <em>Protection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtection()
	 * @generated
	 * @ordered
	 */
	protected String protection = PROTECTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModifiedTimeWeak() <em>Modified Time Weak</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiedTimeWeak()
	 * @generated
	 * @ordered
	 */
	protected EList<String> modifiedTimeWeak;

	/**
	 * The default value of the '{@link #getMyState() <em>My State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyState()
	 * @generated
	 * @ordered
	 */
	protected static final String MY_STATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMyState() <em>My State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyState()
	 * @generated
	 * @ordered
	 */
	protected String myState = MY_STATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ITriggeredImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getITriggered();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITRIGGERED__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITRIGGERED__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayName(String newDisplayName) {
		String oldDisplayName = displayName;
		displayName = newDisplayName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITRIGGERED__DISPLAY_NAME, oldDisplayName, displayName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IVariable> getArgs() {
		if (args == null) {
			args = new EObjectContainmentEList.Resolving<IVariable>(IVariable.class, this, UMLRhapsodyPackage.ITRIGGERED__ARGS);
		}
		return args;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IType getReturnType() {
		if (returnType != null && returnType.eIsProxy()) {
			InternalEObject oldReturnType = (InternalEObject)returnType;
			returnType = (IType)eResolveProxy(oldReturnType);
			if (returnType != oldReturnType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ITRIGGERED__RETURN_TYPE, oldReturnType, returnType));
			}
		}
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IType basicGetReturnType() {
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnType(IType newReturnType) {
		IType oldReturnType = returnType;
		returnType = newReturnType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITRIGGERED__RETURN_TYPE, oldReturnType, returnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(String newAbstract) {
		String oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITRIGGERED__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFinal() {
		return final_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinal(String newFinal) {
		String oldFinal = final_;
		final_ = newFinal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITRIGGERED__FINAL, oldFinal, final_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConcurrency() {
		return concurrency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcurrency(String newConcurrency) {
		String oldConcurrency = concurrency;
		concurrency = newConcurrency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITRIGGERED__CONCURRENCY, oldConcurrency, concurrency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProtection() {
		return protection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtection(String newProtection) {
		String oldProtection = protection;
		protection = newProtection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITRIGGERED__PROTECTION, oldProtection, protection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.ITRIGGERED__MODIFIED_TIME_WEAK);
		}
		return modifiedTimeWeak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMyState() {
		return myState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMyState(String newMyState) {
		String oldMyState = myState;
		myState = newMyState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITRIGGERED__MY_STATE, oldMyState, myState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.ITRIGGERED__ARGS:
				return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.ITRIGGERED__DISPLAY_NAME:
				return getDisplayName();
			case UMLRhapsodyPackage.ITRIGGERED__ID:
				return getId();
			case UMLRhapsodyPackage.ITRIGGERED__NAME:
				return getName();
			case UMLRhapsodyPackage.ITRIGGERED__ARGS:
				return getArgs();
			case UMLRhapsodyPackage.ITRIGGERED__RETURN_TYPE:
				if (resolve) return getReturnType();
				return basicGetReturnType();
			case UMLRhapsodyPackage.ITRIGGERED__ABSTRACT:
				return getAbstract();
			case UMLRhapsodyPackage.ITRIGGERED__FINAL:
				return getFinal();
			case UMLRhapsodyPackage.ITRIGGERED__CONCURRENCY:
				return getConcurrency();
			case UMLRhapsodyPackage.ITRIGGERED__PROTECTION:
				return getProtection();
			case UMLRhapsodyPackage.ITRIGGERED__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.ITRIGGERED__MY_STATE:
				return getMyState();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UMLRhapsodyPackage.ITRIGGERED__DISPLAY_NAME:
				setDisplayName((String)newValue);
				return;
			case UMLRhapsodyPackage.ITRIGGERED__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.ITRIGGERED__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.ITRIGGERED__ARGS:
				getArgs().clear();
				getArgs().addAll((Collection<? extends IVariable>)newValue);
				return;
			case UMLRhapsodyPackage.ITRIGGERED__RETURN_TYPE:
				setReturnType((IType)newValue);
				return;
			case UMLRhapsodyPackage.ITRIGGERED__ABSTRACT:
				setAbstract((String)newValue);
				return;
			case UMLRhapsodyPackage.ITRIGGERED__FINAL:
				setFinal((String)newValue);
				return;
			case UMLRhapsodyPackage.ITRIGGERED__CONCURRENCY:
				setConcurrency((String)newValue);
				return;
			case UMLRhapsodyPackage.ITRIGGERED__PROTECTION:
				setProtection((String)newValue);
				return;
			case UMLRhapsodyPackage.ITRIGGERED__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.ITRIGGERED__MY_STATE:
				setMyState((String)newValue);
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
			case UMLRhapsodyPackage.ITRIGGERED__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ITRIGGERED__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ITRIGGERED__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ITRIGGERED__ARGS:
				getArgs().clear();
				return;
			case UMLRhapsodyPackage.ITRIGGERED__RETURN_TYPE:
				setReturnType((IType)null);
				return;
			case UMLRhapsodyPackage.ITRIGGERED__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ITRIGGERED__FINAL:
				setFinal(FINAL_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ITRIGGERED__CONCURRENCY:
				setConcurrency(CONCURRENCY_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ITRIGGERED__PROTECTION:
				setProtection(PROTECTION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ITRIGGERED__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.ITRIGGERED__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
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
			case UMLRhapsodyPackage.ITRIGGERED__DISPLAY_NAME:
				return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
			case UMLRhapsodyPackage.ITRIGGERED__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.ITRIGGERED__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.ITRIGGERED__ARGS:
				return args != null && !args.isEmpty();
			case UMLRhapsodyPackage.ITRIGGERED__RETURN_TYPE:
				return returnType != null;
			case UMLRhapsodyPackage.ITRIGGERED__ABSTRACT:
				return ABSTRACT_EDEFAULT == null ? abstract_ != null : !ABSTRACT_EDEFAULT.equals(abstract_);
			case UMLRhapsodyPackage.ITRIGGERED__FINAL:
				return FINAL_EDEFAULT == null ? final_ != null : !FINAL_EDEFAULT.equals(final_);
			case UMLRhapsodyPackage.ITRIGGERED__CONCURRENCY:
				return CONCURRENCY_EDEFAULT == null ? concurrency != null : !CONCURRENCY_EDEFAULT.equals(concurrency);
			case UMLRhapsodyPackage.ITRIGGERED__PROTECTION:
				return PROTECTION_EDEFAULT == null ? protection != null : !PROTECTION_EDEFAULT.equals(protection);
			case UMLRhapsodyPackage.ITRIGGERED__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.ITRIGGERED__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == M_pFormalMessageType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ItemsType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IModelElement.class) {
			switch (derivedFeatureID) {
				case UMLRhapsodyPackage.ITRIGGERED__DISPLAY_NAME: return UMLRhapsodyPackage.IMODEL_ELEMENT__DISPLAY_NAME;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == M_pFormalMessageType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ItemsType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IModelElement.class) {
			switch (baseFeatureID) {
				case UMLRhapsodyPackage.IMODEL_ELEMENT__DISPLAY_NAME: return UMLRhapsodyPackage.ITRIGGERED__DISPLAY_NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (displayName: "); //$NON-NLS-1$
		result.append(displayName);
		result.append(", id: "); //$NON-NLS-1$
		result.append(id);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", abstract: "); //$NON-NLS-1$
		result.append(abstract_);
		result.append(", final: "); //$NON-NLS-1$
		result.append(final_);
		result.append(", concurrency: "); //$NON-NLS-1$
		result.append(concurrency);
		result.append(", protection: "); //$NON-NLS-1$
		result.append(protection);
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(", myState: "); //$NON-NLS-1$
		result.append(myState);
		result.append(')');
		return result.toString();
	}

} //ITriggeredImpl
