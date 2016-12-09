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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClass;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITemplateInst;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITemplateInstParam;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ITemplate Inst</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITemplateInstImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITemplateInstImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITemplateInstImpl#getTemplateInstParams <em>Template Inst Params</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ITemplateInstImpl#getOfTemplate <em>Of Template</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ITemplateInstImpl extends MinimalEObjectImpl.Container implements ITemplateInst {
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
	 * The default value of the '{@link #getModifiedTimeWeak() <em>Modified Time Weak</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiedTimeWeak()
	 * @generated
	 * @ordered
	 */
	protected static final String MODIFIED_TIME_WEAK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModifiedTimeWeak() <em>Modified Time Weak</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiedTimeWeak()
	 * @generated
	 * @ordered
	 */
	protected String modifiedTimeWeak = MODIFIED_TIME_WEAK_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTemplateInstParams() <em>Template Inst Params</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateInstParams()
	 * @generated
	 * @ordered
	 */
	protected ITemplateInstParam templateInstParams;

	/**
	 * The cached value of the '{@link #getOfTemplate() <em>Of Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOfTemplate()
	 * @generated
	 * @ordered
	 */
	protected IClass ofTemplate;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ITemplateInstImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getITemplateInst();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITEMPLATE_INST__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModifiedTimeWeak() {
		return modifiedTimeWeak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModifiedTimeWeak(String newModifiedTimeWeak) {
		String oldModifiedTimeWeak = modifiedTimeWeak;
		modifiedTimeWeak = newModifiedTimeWeak;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITEMPLATE_INST__MODIFIED_TIME_WEAK, oldModifiedTimeWeak, modifiedTimeWeak));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITemplateInstParam getTemplateInstParams() {
		if (templateInstParams != null && templateInstParams.eIsProxy()) {
			InternalEObject oldTemplateInstParams = (InternalEObject)templateInstParams;
			templateInstParams = (ITemplateInstParam)eResolveProxy(oldTemplateInstParams);
			if (templateInstParams != oldTemplateInstParams) {
				InternalEObject newTemplateInstParams = (InternalEObject)templateInstParams;
				NotificationChain msgs = oldTemplateInstParams.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ITEMPLATE_INST__TEMPLATE_INST_PARAMS, null, null);
				if (newTemplateInstParams.eInternalContainer() == null) {
					msgs = newTemplateInstParams.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ITEMPLATE_INST__TEMPLATE_INST_PARAMS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ITEMPLATE_INST__TEMPLATE_INST_PARAMS, oldTemplateInstParams, templateInstParams));
			}
		}
		return templateInstParams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITemplateInstParam basicGetTemplateInstParams() {
		return templateInstParams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTemplateInstParams(ITemplateInstParam newTemplateInstParams, NotificationChain msgs) {
		ITemplateInstParam oldTemplateInstParams = templateInstParams;
		templateInstParams = newTemplateInstParams;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITEMPLATE_INST__TEMPLATE_INST_PARAMS, oldTemplateInstParams, newTemplateInstParams);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplateInstParams(ITemplateInstParam newTemplateInstParams) {
		if (newTemplateInstParams != templateInstParams) {
			NotificationChain msgs = null;
			if (templateInstParams != null)
				msgs = ((InternalEObject)templateInstParams).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ITEMPLATE_INST__TEMPLATE_INST_PARAMS, null, msgs);
			if (newTemplateInstParams != null)
				msgs = ((InternalEObject)newTemplateInstParams).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ITEMPLATE_INST__TEMPLATE_INST_PARAMS, null, msgs);
			msgs = basicSetTemplateInstParams(newTemplateInstParams, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITEMPLATE_INST__TEMPLATE_INST_PARAMS, newTemplateInstParams, newTemplateInstParams));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClass getOfTemplate() {
		if (ofTemplate != null && ofTemplate.eIsProxy()) {
			InternalEObject oldOfTemplate = (InternalEObject)ofTemplate;
			ofTemplate = (IClass)eResolveProxy(oldOfTemplate);
			if (ofTemplate != oldOfTemplate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ITEMPLATE_INST__OF_TEMPLATE, oldOfTemplate, ofTemplate));
			}
		}
		return ofTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClass basicGetOfTemplate() {
		return ofTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOfTemplate(IClass newOfTemplate) {
		IClass oldOfTemplate = ofTemplate;
		ofTemplate = newOfTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ITEMPLATE_INST__OF_TEMPLATE, oldOfTemplate, ofTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.ITEMPLATE_INST__TEMPLATE_INST_PARAMS:
				return basicSetTemplateInstParams(null, msgs);
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
			case UMLRhapsodyPackage.ITEMPLATE_INST__ID:
				return getId();
			case UMLRhapsodyPackage.ITEMPLATE_INST__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.ITEMPLATE_INST__TEMPLATE_INST_PARAMS:
				if (resolve) return getTemplateInstParams();
				return basicGetTemplateInstParams();
			case UMLRhapsodyPackage.ITEMPLATE_INST__OF_TEMPLATE:
				if (resolve) return getOfTemplate();
				return basicGetOfTemplate();
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
			case UMLRhapsodyPackage.ITEMPLATE_INST__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.ITEMPLATE_INST__MODIFIED_TIME_WEAK:
				setModifiedTimeWeak((String)newValue);
				return;
			case UMLRhapsodyPackage.ITEMPLATE_INST__TEMPLATE_INST_PARAMS:
				setTemplateInstParams((ITemplateInstParam)newValue);
				return;
			case UMLRhapsodyPackage.ITEMPLATE_INST__OF_TEMPLATE:
				setOfTemplate((IClass)newValue);
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
			case UMLRhapsodyPackage.ITEMPLATE_INST__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ITEMPLATE_INST__MODIFIED_TIME_WEAK:
				setModifiedTimeWeak(MODIFIED_TIME_WEAK_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ITEMPLATE_INST__TEMPLATE_INST_PARAMS:
				setTemplateInstParams((ITemplateInstParam)null);
				return;
			case UMLRhapsodyPackage.ITEMPLATE_INST__OF_TEMPLATE:
				setOfTemplate((IClass)null);
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
			case UMLRhapsodyPackage.ITEMPLATE_INST__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.ITEMPLATE_INST__MODIFIED_TIME_WEAK:
				return MODIFIED_TIME_WEAK_EDEFAULT == null ? modifiedTimeWeak != null : !MODIFIED_TIME_WEAK_EDEFAULT.equals(modifiedTimeWeak);
			case UMLRhapsodyPackage.ITEMPLATE_INST__TEMPLATE_INST_PARAMS:
				return templateInstParams != null;
			case UMLRhapsodyPackage.ITEMPLATE_INST__OF_TEMPLATE:
				return ofTemplate != null;
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
		result.append(" (id: "); //$NON-NLS-1$
		result.append(id);
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(')');
		return result.toString();
	}

} //ITemplateInstImpl
