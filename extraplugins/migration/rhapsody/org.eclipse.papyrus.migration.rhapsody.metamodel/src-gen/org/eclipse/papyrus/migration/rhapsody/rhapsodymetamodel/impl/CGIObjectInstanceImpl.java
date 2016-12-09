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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIImageData;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIObjectInstance;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CompartmentsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUnit;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pModelObjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pRootType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.OperationsType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CGI Object Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIObjectInstanceImpl#getM_pModelObject <em>MpModel Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIObjectInstanceImpl#getM_pParent <em>MpParent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIObjectInstanceImpl#getM_transform <em>Mtransform</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIObjectInstanceImpl#getM_AdditionalLabel <em>MAdditional Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIObjectInstanceImpl#getM_polygon <em>Mpolygon</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIObjectInstanceImpl#getM_nNameFormat <em>MnName Format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIObjectInstanceImpl#getM_nIsNameFormat <em>MnIs Name Format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIObjectInstanceImpl#getFrameset <em>Frameset</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIObjectInstanceImpl#getCompartments <em>Compartments</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIObjectInstanceImpl#getM_multiplicity <em>Mmultiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIObjectInstanceImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIObjectInstanceImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIObjectInstanceImpl#getAttrs <em>Attrs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIObjectInstanceImpl#getM_bFramesetModified <em>MbFrameset Modified</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.CGIObjectInstanceImpl#getM_pImageViewData <em>MpImage View Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGIObjectInstanceImpl extends GraphElementsTypeImpl implements CGIObjectInstance {
	/**
	 * The cached value of the '{@link #getM_pModelObject() <em>MpModel Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pModelObject()
	 * @generated
	 * @ordered
	 */
	protected M_pModelObjectType m_pModelObject;

	/**
	 * The cached value of the '{@link #getM_pParent() <em>MpParent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pParent()
	 * @generated
	 * @ordered
	 */
	protected M_pRootType m_pParent;

	/**
	 * The cached value of the '{@link #getM_transform() <em>Mtransform</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_transform()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_transform;

	/**
	 * The cached value of the '{@link #getM_AdditionalLabel() <em>MAdditional Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_AdditionalLabel()
	 * @generated
	 * @ordered
	 */
	protected CGIText m_AdditionalLabel;

	/**
	 * The cached value of the '{@link #getM_polygon() <em>Mpolygon</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_polygon()
	 * @generated
	 * @ordered
	 */
	protected EList<String> m_polygon;

	/**
	 * The default value of the '{@link #getM_nNameFormat() <em>MnName Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nNameFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String MNNAME_FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_nNameFormat() <em>MnName Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nNameFormat()
	 * @generated
	 * @ordered
	 */
	protected String m_nNameFormat = MNNAME_FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_nIsNameFormat() <em>MnIs Name Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nIsNameFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String MNIS_NAME_FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_nIsNameFormat() <em>MnIs Name Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_nIsNameFormat()
	 * @generated
	 * @ordered
	 */
	protected String m_nIsNameFormat = MNIS_NAME_FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFrameset() <em>Frameset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameset()
	 * @generated
	 * @ordered
	 */
	protected static final String FRAMESET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFrameset() <em>Frameset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameset()
	 * @generated
	 * @ordered
	 */
	protected String frameset = FRAMESET_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCompartments() <em>Compartments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompartments()
	 * @generated
	 * @ordered
	 */
	protected EList<CompartmentsType> compartments;

	/**
	 * The cached value of the '{@link #getM_multiplicity() <em>Mmultiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_multiplicity()
	 * @generated
	 * @ordered
	 */
	protected CGIText m_multiplicity;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected IPropertyContainer properties;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationsType> operations;

	/**
	 * The cached value of the '{@link #getAttrs() <em>Attrs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrs()
	 * @generated
	 * @ordered
	 */
	protected EList<IUnit> attrs;

	/**
	 * The default value of the '{@link #getM_bFramesetModified() <em>MbFrameset Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bFramesetModified()
	 * @generated
	 * @ordered
	 */
	protected static final String MBFRAMESET_MODIFIED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_bFramesetModified() <em>MbFrameset Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_bFramesetModified()
	 * @generated
	 * @ordered
	 */
	protected String m_bFramesetModified = MBFRAMESET_MODIFIED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_pImageViewData() <em>MpImage View Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pImageViewData()
	 * @generated
	 * @ordered
	 */
	protected CGIImageData m_pImageViewData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGIObjectInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getCGIObjectInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_pModelObjectType getM_pModelObject() {
		if (m_pModelObject != null && m_pModelObject.eIsProxy()) {
			InternalEObject oldM_pModelObject = (InternalEObject)m_pModelObject;
			m_pModelObject = (M_pModelObjectType)eResolveProxy(oldM_pModelObject);
			if (m_pModelObject != oldM_pModelObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPMODEL_OBJECT, oldM_pModelObject, m_pModelObject));
			}
		}
		return m_pModelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_pModelObjectType basicGetM_pModelObject() {
		return m_pModelObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pModelObject(M_pModelObjectType newM_pModelObject) {
		M_pModelObjectType oldM_pModelObject = m_pModelObject;
		m_pModelObject = newM_pModelObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPMODEL_OBJECT, oldM_pModelObject, m_pModelObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_pRootType getM_pParent() {
		if (m_pParent != null && m_pParent.eIsProxy()) {
			InternalEObject oldM_pParent = (InternalEObject)m_pParent;
			m_pParent = (M_pRootType)eResolveProxy(oldM_pParent);
			if (m_pParent != oldM_pParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPPARENT, oldM_pParent, m_pParent));
			}
		}
		return m_pParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_pRootType basicGetM_pParent() {
		return m_pParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pParent(M_pRootType newM_pParent) {
		M_pRootType oldM_pParent = m_pParent;
		m_pParent = newM_pParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPPARENT, oldM_pParent, m_pParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_transform() {
		if (m_transform == null) {
			m_transform = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MTRANSFORM);
		}
		return m_transform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText getM_AdditionalLabel() {
		if (m_AdditionalLabel != null && m_AdditionalLabel.eIsProxy()) {
			InternalEObject oldM_AdditionalLabel = (InternalEObject)m_AdditionalLabel;
			m_AdditionalLabel = (CGIText)eResolveProxy(oldM_AdditionalLabel);
			if (m_AdditionalLabel != oldM_AdditionalLabel) {
				InternalEObject newM_AdditionalLabel = (InternalEObject)m_AdditionalLabel;
				NotificationChain msgs = oldM_AdditionalLabel.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MADDITIONAL_LABEL, null, null);
				if (newM_AdditionalLabel.eInternalContainer() == null) {
					msgs = newM_AdditionalLabel.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MADDITIONAL_LABEL, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MADDITIONAL_LABEL, oldM_AdditionalLabel, m_AdditionalLabel));
			}
		}
		return m_AdditionalLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText basicGetM_AdditionalLabel() {
		return m_AdditionalLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_AdditionalLabel(CGIText newM_AdditionalLabel, NotificationChain msgs) {
		CGIText oldM_AdditionalLabel = m_AdditionalLabel;
		m_AdditionalLabel = newM_AdditionalLabel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MADDITIONAL_LABEL, oldM_AdditionalLabel, newM_AdditionalLabel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_AdditionalLabel(CGIText newM_AdditionalLabel) {
		if (newM_AdditionalLabel != m_AdditionalLabel) {
			NotificationChain msgs = null;
			if (m_AdditionalLabel != null)
				msgs = ((InternalEObject)m_AdditionalLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MADDITIONAL_LABEL, null, msgs);
			if (newM_AdditionalLabel != null)
				msgs = ((InternalEObject)newM_AdditionalLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MADDITIONAL_LABEL, null, msgs);
			msgs = basicSetM_AdditionalLabel(newM_AdditionalLabel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MADDITIONAL_LABEL, newM_AdditionalLabel, newM_AdditionalLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getM_polygon() {
		if (m_polygon == null) {
			m_polygon = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPOLYGON);
		}
		return m_polygon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_nNameFormat() {
		return m_nNameFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_nNameFormat(String newM_nNameFormat) {
		String oldM_nNameFormat = m_nNameFormat;
		m_nNameFormat = newM_nNameFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MNNAME_FORMAT, oldM_nNameFormat, m_nNameFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_nIsNameFormat() {
		return m_nIsNameFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_nIsNameFormat(String newM_nIsNameFormat) {
		String oldM_nIsNameFormat = m_nIsNameFormat;
		m_nIsNameFormat = newM_nIsNameFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MNIS_NAME_FORMAT, oldM_nIsNameFormat, m_nIsNameFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFrameset() {
		return frameset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrameset(String newFrameset) {
		String oldFrameset = frameset;
		frameset = newFrameset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__FRAMESET, oldFrameset, frameset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompartmentsType> getCompartments() {
		if (compartments == null) {
			compartments = new EObjectContainmentEList.Resolving<CompartmentsType>(CompartmentsType.class, this, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__COMPARTMENTS);
		}
		return compartments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText getM_multiplicity() {
		if (m_multiplicity != null && m_multiplicity.eIsProxy()) {
			InternalEObject oldM_multiplicity = (InternalEObject)m_multiplicity;
			m_multiplicity = (CGIText)eResolveProxy(oldM_multiplicity);
			if (m_multiplicity != oldM_multiplicity) {
				InternalEObject newM_multiplicity = (InternalEObject)m_multiplicity;
				NotificationChain msgs = oldM_multiplicity.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MMULTIPLICITY, null, null);
				if (newM_multiplicity.eInternalContainer() == null) {
					msgs = newM_multiplicity.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MMULTIPLICITY, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MMULTIPLICITY, oldM_multiplicity, m_multiplicity));
			}
		}
		return m_multiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText basicGetM_multiplicity() {
		return m_multiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetM_multiplicity(CGIText newM_multiplicity, NotificationChain msgs) {
		CGIText oldM_multiplicity = m_multiplicity;
		m_multiplicity = newM_multiplicity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MMULTIPLICITY, oldM_multiplicity, newM_multiplicity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_multiplicity(CGIText newM_multiplicity) {
		if (newM_multiplicity != m_multiplicity) {
			NotificationChain msgs = null;
			if (m_multiplicity != null)
				msgs = ((InternalEObject)m_multiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MMULTIPLICITY, null, msgs);
			if (newM_multiplicity != null)
				msgs = ((InternalEObject)newM_multiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MMULTIPLICITY, null, msgs);
			msgs = basicSetM_multiplicity(newM_multiplicity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MMULTIPLICITY, newM_multiplicity, newM_multiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPropertyContainer getProperties() {
		if (properties != null && properties.eIsProxy()) {
			InternalEObject oldProperties = (InternalEObject)properties;
			properties = (IPropertyContainer)eResolveProxy(oldProperties);
			if (properties != oldProperties) {
				InternalEObject newProperties = (InternalEObject)properties;
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__PROPERTIES, oldProperties, properties));
			}
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPropertyContainer basicGetProperties() {
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperties(IPropertyContainer newProperties, NotificationChain msgs) {
		IPropertyContainer oldProperties = properties;
		properties = newProperties;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__PROPERTIES, oldProperties, newProperties);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperties(IPropertyContainer newProperties) {
		if (newProperties != properties) {
			NotificationChain msgs = null;
			if (properties != null)
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__PROPERTIES, newProperties, newProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationsType> getOperations() {
		if (operations == null) {
			operations = new EObjectResolvingEList<OperationsType>(OperationsType.class, this, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IUnit> getAttrs() {
		if (attrs == null) {
			attrs = new EObjectResolvingEList<IUnit>(IUnit.class, this, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__ATTRS);
		}
		return attrs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_bFramesetModified() {
		return m_bFramesetModified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_bFramesetModified(String newM_bFramesetModified) {
		String oldM_bFramesetModified = m_bFramesetModified;
		m_bFramesetModified = newM_bFramesetModified;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MBFRAMESET_MODIFIED, oldM_bFramesetModified, m_bFramesetModified));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIImageData getM_pImageViewData() {
		if (m_pImageViewData != null && m_pImageViewData.eIsProxy()) {
			InternalEObject oldM_pImageViewData = (InternalEObject)m_pImageViewData;
			m_pImageViewData = (CGIImageData)eResolveProxy(oldM_pImageViewData);
			if (m_pImageViewData != oldM_pImageViewData) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPIMAGE_VIEW_DATA, oldM_pImageViewData, m_pImageViewData));
			}
		}
		return m_pImageViewData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIImageData basicGetM_pImageViewData() {
		return m_pImageViewData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pImageViewData(CGIImageData newM_pImageViewData) {
		CGIImageData oldM_pImageViewData = m_pImageViewData;
		m_pImageViewData = newM_pImageViewData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPIMAGE_VIEW_DATA, oldM_pImageViewData, m_pImageViewData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MADDITIONAL_LABEL:
				return basicSetM_AdditionalLabel(null, msgs);
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__COMPARTMENTS:
				return ((InternalEList<?>)getCompartments()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MMULTIPLICITY:
				return basicSetM_multiplicity(null, msgs);
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__PROPERTIES:
				return basicSetProperties(null, msgs);
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
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPMODEL_OBJECT:
				if (resolve) return getM_pModelObject();
				return basicGetM_pModelObject();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPPARENT:
				if (resolve) return getM_pParent();
				return basicGetM_pParent();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MTRANSFORM:
				return getM_transform();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MADDITIONAL_LABEL:
				if (resolve) return getM_AdditionalLabel();
				return basicGetM_AdditionalLabel();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPOLYGON:
				return getM_polygon();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MNNAME_FORMAT:
				return getM_nNameFormat();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MNIS_NAME_FORMAT:
				return getM_nIsNameFormat();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__FRAMESET:
				return getFrameset();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__COMPARTMENTS:
				return getCompartments();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MMULTIPLICITY:
				if (resolve) return getM_multiplicity();
				return basicGetM_multiplicity();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__PROPERTIES:
				if (resolve) return getProperties();
				return basicGetProperties();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__OPERATIONS:
				return getOperations();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__ATTRS:
				return getAttrs();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MBFRAMESET_MODIFIED:
				return getM_bFramesetModified();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPIMAGE_VIEW_DATA:
				if (resolve) return getM_pImageViewData();
				return basicGetM_pImageViewData();
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
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPMODEL_OBJECT:
				setM_pModelObject((M_pModelObjectType)newValue);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPPARENT:
				setM_pParent((M_pRootType)newValue);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MTRANSFORM:
				getM_transform().clear();
				getM_transform().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MADDITIONAL_LABEL:
				setM_AdditionalLabel((CGIText)newValue);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPOLYGON:
				getM_polygon().clear();
				getM_polygon().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MNNAME_FORMAT:
				setM_nNameFormat((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MNIS_NAME_FORMAT:
				setM_nIsNameFormat((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__FRAMESET:
				setFrameset((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__COMPARTMENTS:
				getCompartments().clear();
				getCompartments().addAll((Collection<? extends CompartmentsType>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MMULTIPLICITY:
				setM_multiplicity((CGIText)newValue);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__PROPERTIES:
				setProperties((IPropertyContainer)newValue);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends OperationsType>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__ATTRS:
				getAttrs().clear();
				getAttrs().addAll((Collection<? extends IUnit>)newValue);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MBFRAMESET_MODIFIED:
				setM_bFramesetModified((String)newValue);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPIMAGE_VIEW_DATA:
				setM_pImageViewData((CGIImageData)newValue);
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
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPMODEL_OBJECT:
				setM_pModelObject((M_pModelObjectType)null);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPPARENT:
				setM_pParent((M_pRootType)null);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MTRANSFORM:
				getM_transform().clear();
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MADDITIONAL_LABEL:
				setM_AdditionalLabel((CGIText)null);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPOLYGON:
				getM_polygon().clear();
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MNNAME_FORMAT:
				setM_nNameFormat(MNNAME_FORMAT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MNIS_NAME_FORMAT:
				setM_nIsNameFormat(MNIS_NAME_FORMAT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__FRAMESET:
				setFrameset(FRAMESET_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__COMPARTMENTS:
				getCompartments().clear();
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MMULTIPLICITY:
				setM_multiplicity((CGIText)null);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__PROPERTIES:
				setProperties((IPropertyContainer)null);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__OPERATIONS:
				getOperations().clear();
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__ATTRS:
				getAttrs().clear();
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MBFRAMESET_MODIFIED:
				setM_bFramesetModified(MBFRAMESET_MODIFIED_EDEFAULT);
				return;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPIMAGE_VIEW_DATA:
				setM_pImageViewData((CGIImageData)null);
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
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPMODEL_OBJECT:
				return m_pModelObject != null;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPPARENT:
				return m_pParent != null;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MTRANSFORM:
				return m_transform != null && !m_transform.isEmpty();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MADDITIONAL_LABEL:
				return m_AdditionalLabel != null;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPOLYGON:
				return m_polygon != null && !m_polygon.isEmpty();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MNNAME_FORMAT:
				return MNNAME_FORMAT_EDEFAULT == null ? m_nNameFormat != null : !MNNAME_FORMAT_EDEFAULT.equals(m_nNameFormat);
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MNIS_NAME_FORMAT:
				return MNIS_NAME_FORMAT_EDEFAULT == null ? m_nIsNameFormat != null : !MNIS_NAME_FORMAT_EDEFAULT.equals(m_nIsNameFormat);
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__FRAMESET:
				return FRAMESET_EDEFAULT == null ? frameset != null : !FRAMESET_EDEFAULT.equals(frameset);
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__COMPARTMENTS:
				return compartments != null && !compartments.isEmpty();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MMULTIPLICITY:
				return m_multiplicity != null;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__PROPERTIES:
				return properties != null;
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__ATTRS:
				return attrs != null && !attrs.isEmpty();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MBFRAMESET_MODIFIED:
				return MBFRAMESET_MODIFIED_EDEFAULT == null ? m_bFramesetModified != null : !MBFRAMESET_MODIFIED_EDEFAULT.equals(m_bFramesetModified);
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE__MPIMAGE_VIEW_DATA:
				return m_pImageViewData != null;
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
		result.append(" (m_transform: "); //$NON-NLS-1$
		result.append(m_transform);
		result.append(", m_polygon: "); //$NON-NLS-1$
		result.append(m_polygon);
		result.append(", m_nNameFormat: "); //$NON-NLS-1$
		result.append(m_nNameFormat);
		result.append(", m_nIsNameFormat: "); //$NON-NLS-1$
		result.append(m_nIsNameFormat);
		result.append(", frameset: "); //$NON-NLS-1$
		result.append(frameset);
		result.append(", m_bFramesetModified: "); //$NON-NLS-1$
		result.append(m_bFramesetModified);
		result.append(')');
		return result.toString();
	}

} //CGIObjectInstanceImpl
