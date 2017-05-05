/**
* Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.core.architecture.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain;
import org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint;
import org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureContextImpl#getViewpoints <em>Viewpoints</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureContextImpl#getDefaultViewpoints <em>Default Viewpoints</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureContextImpl#getElementTypes <em>Element Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureContextImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureContextImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureContextImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureContextImpl#getExtensionPrefix <em>Extension Prefix</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureContextImpl#getCreationCommandClass <em>Creation Command Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.impl.ArchitectureContextImpl#getConversionCommandClass <em>Conversion Command Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ArchitectureContextImpl extends ADElementImpl implements ArchitectureContext {
	/**
	 * The cached value of the '{@link #getViewpoints() <em>Viewpoints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewpoints()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureViewpoint> viewpoints;

	/**
	 * The cached value of the '{@link #getDefaultViewpoints() <em>Default Viewpoints</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultViewpoints()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchitectureViewpoint> defaultViewpoints;

	/**
	 * The cached value of the '{@link #getElementTypes() <em>Element Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementTypeSetConfiguration> elementTypes;

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
	 * The default value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected String icon = ICON_EDEFAULT;

	/**
	 * The default value of the '{@link #getExtensionPrefix() <em>Extension Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTENSION_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtensionPrefix() <em>Extension Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionPrefix()
	 * @generated
	 * @ordered
	 */
	protected String extensionPrefix = EXTENSION_PREFIX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCreationCommandClass() <em>Creation Command Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationCommandClass()
	 * @generated
	 * @ordered
	 */
	protected Class<?> creationCommandClass;

	/**
	 * The cached value of the '{@link #getConversionCommandClass() <em>Conversion Command Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConversionCommandClass()
	 * @generated
	 * @ordered
	 */
	protected Class<?> conversionCommandClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArchitecturePackage.Literals.ARCHITECTURE_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureViewpoint> getViewpoints() {
		if (viewpoints == null) {
			viewpoints = new EObjectContainmentWithInverseEList<ArchitectureViewpoint>(ArchitectureViewpoint.class, this, ArchitecturePackage.ARCHITECTURE_CONTEXT__VIEWPOINTS, ArchitecturePackage.ARCHITECTURE_VIEWPOINT__CONTEXT);
		}
		return viewpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchitectureViewpoint> getDefaultViewpoints() {
		if (defaultViewpoints == null) {
			defaultViewpoints = new EObjectResolvingEList<ArchitectureViewpoint>(ArchitectureViewpoint.class, this, ArchitecturePackage.ARCHITECTURE_CONTEXT__DEFAULT_VIEWPOINTS);
		}
		return defaultViewpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementTypeSetConfiguration> getElementTypes() {
		if (elementTypes == null) {
			elementTypes = new EObjectResolvingEList<ElementTypeSetConfiguration>(ElementTypeSetConfiguration.class, this, ArchitecturePackage.ARCHITECTURE_CONTEXT__ELEMENT_TYPES);
		}
		return elementTypes;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.ARCHITECTURE_CONTEXT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcon(String newIcon) {
		String oldIcon = icon;
		icon = newIcon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.ARCHITECTURE_CONTEXT__ICON, oldIcon, icon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExtensionPrefix() {
		return extensionPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtensionPrefix(String newExtensionPrefix) {
		String oldExtensionPrefix = extensionPrefix;
		extensionPrefix = newExtensionPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.ARCHITECTURE_CONTEXT__EXTENSION_PREFIX, oldExtensionPrefix, extensionPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Class<?> getCreationCommandClass() {
		return creationCommandClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationCommandClass(Class<?> newCreationCommandClass) {
		Class<?> oldCreationCommandClass = creationCommandClass;
		creationCommandClass = newCreationCommandClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.ARCHITECTURE_CONTEXT__CREATION_COMMAND_CLASS, oldCreationCommandClass, creationCommandClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Class<?> getConversionCommandClass() {
		return conversionCommandClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConversionCommandClass(Class<?> newConversionCommandClass) {
		Class<?> oldConversionCommandClass = conversionCommandClass;
		conversionCommandClass = newConversionCommandClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.ARCHITECTURE_CONTEXT__CONVERSION_COMMAND_CLASS, oldConversionCommandClass, conversionCommandClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureDomain getDomain() {
		if (eContainerFeatureID() != ArchitecturePackage.ARCHITECTURE_CONTEXT__DOMAIN) return null;
		return (ArchitectureDomain)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomain(ArchitectureDomain newDomain, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDomain, ArchitecturePackage.ARCHITECTURE_CONTEXT__DOMAIN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomain(ArchitectureDomain newDomain) {
		if (newDomain != eInternalContainer() || (eContainerFeatureID() != ArchitecturePackage.ARCHITECTURE_CONTEXT__DOMAIN && newDomain != null)) {
			if (EcoreUtil.isAncestor(this, newDomain))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDomain != null)
				msgs = ((InternalEObject)newDomain).eInverseAdd(this, ArchitecturePackage.ARCHITECTURE_DOMAIN__CONTEXTS, ArchitectureDomain.class, msgs);
			msgs = basicSetDomain(newDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.ARCHITECTURE_CONTEXT__DOMAIN, newDomain, newDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__VIEWPOINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getViewpoints()).basicAdd(otherEnd, msgs);
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__DOMAIN:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDomain((ArchitectureDomain)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__VIEWPOINTS:
				return ((InternalEList<?>)getViewpoints()).basicRemove(otherEnd, msgs);
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__DOMAIN:
				return basicSetDomain(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__DOMAIN:
				return eInternalContainer().eInverseRemove(this, ArchitecturePackage.ARCHITECTURE_DOMAIN__CONTEXTS, ArchitectureDomain.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__VIEWPOINTS:
				return getViewpoints();
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__DEFAULT_VIEWPOINTS:
				return getDefaultViewpoints();
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__ELEMENT_TYPES:
				return getElementTypes();
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__DOMAIN:
				return getDomain();
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__ID:
				return getId();
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__ICON:
				return getIcon();
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__EXTENSION_PREFIX:
				return getExtensionPrefix();
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__CREATION_COMMAND_CLASS:
				return getCreationCommandClass();
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__CONVERSION_COMMAND_CLASS:
				return getConversionCommandClass();
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
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__VIEWPOINTS:
				getViewpoints().clear();
				getViewpoints().addAll((Collection<? extends ArchitectureViewpoint>)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__DEFAULT_VIEWPOINTS:
				getDefaultViewpoints().clear();
				getDefaultViewpoints().addAll((Collection<? extends ArchitectureViewpoint>)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__ELEMENT_TYPES:
				getElementTypes().clear();
				getElementTypes().addAll((Collection<? extends ElementTypeSetConfiguration>)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__DOMAIN:
				setDomain((ArchitectureDomain)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__ID:
				setId((String)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__ICON:
				setIcon((String)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__EXTENSION_PREFIX:
				setExtensionPrefix((String)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__CREATION_COMMAND_CLASS:
				setCreationCommandClass((Class<?>)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__CONVERSION_COMMAND_CLASS:
				setConversionCommandClass((Class<?>)newValue);
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
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__VIEWPOINTS:
				getViewpoints().clear();
				return;
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__DEFAULT_VIEWPOINTS:
				getDefaultViewpoints().clear();
				return;
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__ELEMENT_TYPES:
				getElementTypes().clear();
				return;
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__DOMAIN:
				setDomain((ArchitectureDomain)null);
				return;
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__ID:
				setId(ID_EDEFAULT);
				return;
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__ICON:
				setIcon(ICON_EDEFAULT);
				return;
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__EXTENSION_PREFIX:
				setExtensionPrefix(EXTENSION_PREFIX_EDEFAULT);
				return;
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__CREATION_COMMAND_CLASS:
				setCreationCommandClass((Class<?>)null);
				return;
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__CONVERSION_COMMAND_CLASS:
				setConversionCommandClass((Class<?>)null);
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
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__VIEWPOINTS:
				return viewpoints != null && !viewpoints.isEmpty();
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__DEFAULT_VIEWPOINTS:
				return defaultViewpoints != null && !defaultViewpoints.isEmpty();
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__ELEMENT_TYPES:
				return elementTypes != null && !elementTypes.isEmpty();
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__DOMAIN:
				return getDomain() != null;
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__ICON:
				return ICON_EDEFAULT == null ? icon != null : !ICON_EDEFAULT.equals(icon);
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__EXTENSION_PREFIX:
				return EXTENSION_PREFIX_EDEFAULT == null ? extensionPrefix != null : !EXTENSION_PREFIX_EDEFAULT.equals(extensionPrefix);
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__CREATION_COMMAND_CLASS:
				return creationCommandClass != null;
			case ArchitecturePackage.ARCHITECTURE_CONTEXT__CONVERSION_COMMAND_CLASS:
				return conversionCommandClass != null;
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
		result.append(", icon: "); //$NON-NLS-1$
		result.append(icon);
		result.append(", extensionPrefix: "); //$NON-NLS-1$
		result.append(extensionPrefix);
		result.append(", creationCommandClass: "); //$NON-NLS-1$
		result.append(creationCommandClass);
		result.append(", conversionCommandClass: "); //$NON-NLS-1$
		result.append(conversionCommandClass);
		result.append(')');
		return result.toString();
	}

} //ArchitectureContextImpl
