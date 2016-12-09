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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassifier;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassifierRole;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMessage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IModelElement;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITag;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pFormalMessageType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IMessage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getMyState <em>My State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getM_szSequence <em>Msz Sequence</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getM_szActualArgs <em>Msz Actual Args</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getM_szReturnVal <em>Msz Return Val</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getM_pReceiver <em>MpReceiver</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getM_pSender <em>MpSender</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getM_pFormalMessage <em>MpFormal Message</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getM_eType <em>MeType</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getM_pCommunicationConnection <em>MpCommunication Connection</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getM_freeText <em>Mfree Text</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getM_targetExec <em>Mtarget Exec</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getM_srcExec <em>Msrc Exec</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IMessageImpl#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IMessageImpl extends IModelElementImpl implements IMessage {
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
	 * The default value of the '{@link #getM_szSequence() <em>Msz Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_szSequence()
	 * @generated
	 * @ordered
	 */
	protected static final String MSZ_SEQUENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_szSequence() <em>Msz Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_szSequence()
	 * @generated
	 * @ordered
	 */
	protected String m_szSequence = MSZ_SEQUENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_szActualArgs() <em>Msz Actual Args</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_szActualArgs()
	 * @generated
	 * @ordered
	 */
	protected static final String MSZ_ACTUAL_ARGS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_szActualArgs() <em>Msz Actual Args</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_szActualArgs()
	 * @generated
	 * @ordered
	 */
	protected String m_szActualArgs = MSZ_ACTUAL_ARGS_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_szReturnVal() <em>Msz Return Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_szReturnVal()
	 * @generated
	 * @ordered
	 */
	protected static final String MSZ_RETURN_VAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_szReturnVal() <em>Msz Return Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_szReturnVal()
	 * @generated
	 * @ordered
	 */
	protected String m_szReturnVal = MSZ_RETURN_VAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_pReceiver() <em>MpReceiver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pReceiver()
	 * @generated
	 * @ordered
	 */
	protected IClassifierRole m_pReceiver;

	/**
	 * The cached value of the '{@link #getM_pSender() <em>MpSender</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pSender()
	 * @generated
	 * @ordered
	 */
	protected IClassifierRole m_pSender;

	/**
	 * The cached value of the '{@link #getM_pFormalMessage() <em>MpFormal Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pFormalMessage()
	 * @generated
	 * @ordered
	 */
	protected M_pFormalMessageType m_pFormalMessage;

	/**
	 * The default value of the '{@link #getM_eType() <em>MeType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_eType()
	 * @generated
	 * @ordered
	 */
	protected static final String METYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_eType() <em>MeType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_eType()
	 * @generated
	 * @ordered
	 */
	protected String m_eType = METYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_pCommunicationConnection() <em>MpCommunication Connection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_pCommunicationConnection()
	 * @generated
	 * @ordered
	 */
	protected IModelElement m_pCommunicationConnection;

	/**
	 * The default value of the '{@link #getM_freeText() <em>Mfree Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_freeText()
	 * @generated
	 * @ordered
	 */
	protected static final String MFREE_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_freeText() <em>Mfree Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_freeText()
	 * @generated
	 * @ordered
	 */
	protected String m_freeText = MFREE_TEXT_EDEFAULT;

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
	 * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypes()
	 * @generated
	 * @ordered
	 */
	protected IClassifier stereotypes;

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList<ITag> tags;

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
	 * The cached value of the '{@link #getM_targetExec() <em>Mtarget Exec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_targetExec()
	 * @generated
	 * @ordered
	 */
	protected IModelElement m_targetExec;

	/**
	 * The cached value of the '{@link #getM_srcExec() <em>Msrc Exec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_srcExec()
	 * @generated
	 * @ordered
	 */
	protected IModelElement m_srcExec;

	/**
	 * The default value of the '{@link #getObjectCreation() <em>Object Creation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectCreation()
	 * @generated
	 * @ordered
	 */
	protected static final String OBJECT_CREATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObjectCreation() <em>Object Creation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectCreation()
	 * @generated
	 * @ordered
	 */
	protected String objectCreation = OBJECT_CREATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getUmlDependencyID() <em>Uml Dependency ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlDependencyID()
	 * @generated
	 * @ordered
	 */
	protected static final String UML_DEPENDENCY_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUmlDependencyID() <em>Uml Dependency ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlDependencyID()
	 * @generated
	 * @ordered
	 */
	protected String umlDependencyID = UML_DEPENDENCY_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IMessageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIMessage();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__MY_STATE, oldMyState, myState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__DISPLAY_NAME, oldDisplayName, displayName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_szSequence() {
		return m_szSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_szSequence(String newM_szSequence) {
		String oldM_szSequence = m_szSequence;
		m_szSequence = newM_szSequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__MSZ_SEQUENCE, oldM_szSequence, m_szSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_szActualArgs() {
		return m_szActualArgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_szActualArgs(String newM_szActualArgs) {
		String oldM_szActualArgs = m_szActualArgs;
		m_szActualArgs = newM_szActualArgs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__MSZ_ACTUAL_ARGS, oldM_szActualArgs, m_szActualArgs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_szReturnVal() {
		return m_szReturnVal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_szReturnVal(String newM_szReturnVal) {
		String oldM_szReturnVal = m_szReturnVal;
		m_szReturnVal = newM_szReturnVal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__MSZ_RETURN_VAL, oldM_szReturnVal, m_szReturnVal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifierRole getM_pReceiver() {
		if (m_pReceiver != null && m_pReceiver.eIsProxy()) {
			InternalEObject oldM_pReceiver = (InternalEObject)m_pReceiver;
			m_pReceiver = (IClassifierRole)eResolveProxy(oldM_pReceiver);
			if (m_pReceiver != oldM_pReceiver) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IMESSAGE__MPRECEIVER, oldM_pReceiver, m_pReceiver));
			}
		}
		return m_pReceiver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifierRole basicGetM_pReceiver() {
		return m_pReceiver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pReceiver(IClassifierRole newM_pReceiver) {
		IClassifierRole oldM_pReceiver = m_pReceiver;
		m_pReceiver = newM_pReceiver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__MPRECEIVER, oldM_pReceiver, m_pReceiver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifierRole getM_pSender() {
		if (m_pSender != null && m_pSender.eIsProxy()) {
			InternalEObject oldM_pSender = (InternalEObject)m_pSender;
			m_pSender = (IClassifierRole)eResolveProxy(oldM_pSender);
			if (m_pSender != oldM_pSender) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IMESSAGE__MPSENDER, oldM_pSender, m_pSender));
			}
		}
		return m_pSender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifierRole basicGetM_pSender() {
		return m_pSender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pSender(IClassifierRole newM_pSender) {
		IClassifierRole oldM_pSender = m_pSender;
		m_pSender = newM_pSender;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__MPSENDER, oldM_pSender, m_pSender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_pFormalMessageType getM_pFormalMessage() {
		if (m_pFormalMessage != null && m_pFormalMessage.eIsProxy()) {
			InternalEObject oldM_pFormalMessage = (InternalEObject)m_pFormalMessage;
			m_pFormalMessage = (M_pFormalMessageType)eResolveProxy(oldM_pFormalMessage);
			if (m_pFormalMessage != oldM_pFormalMessage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IMESSAGE__MPFORMAL_MESSAGE, oldM_pFormalMessage, m_pFormalMessage));
			}
		}
		return m_pFormalMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_pFormalMessageType basicGetM_pFormalMessage() {
		return m_pFormalMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pFormalMessage(M_pFormalMessageType newM_pFormalMessage) {
		M_pFormalMessageType oldM_pFormalMessage = m_pFormalMessage;
		m_pFormalMessage = newM_pFormalMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__MPFORMAL_MESSAGE, oldM_pFormalMessage, m_pFormalMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_eType() {
		return m_eType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_eType(String newM_eType) {
		String oldM_eType = m_eType;
		m_eType = newM_eType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__METYPE, oldM_eType, m_eType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IModelElement getM_pCommunicationConnection() {
		if (m_pCommunicationConnection != null && m_pCommunicationConnection.eIsProxy()) {
			InternalEObject oldM_pCommunicationConnection = (InternalEObject)m_pCommunicationConnection;
			m_pCommunicationConnection = (IModelElement)eResolveProxy(oldM_pCommunicationConnection);
			if (m_pCommunicationConnection != oldM_pCommunicationConnection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IMESSAGE__MPCOMMUNICATION_CONNECTION, oldM_pCommunicationConnection, m_pCommunicationConnection));
			}
		}
		return m_pCommunicationConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IModelElement basicGetM_pCommunicationConnection() {
		return m_pCommunicationConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_pCommunicationConnection(IModelElement newM_pCommunicationConnection) {
		IModelElement oldM_pCommunicationConnection = m_pCommunicationConnection;
		m_pCommunicationConnection = newM_pCommunicationConnection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__MPCOMMUNICATION_CONNECTION, oldM_pCommunicationConnection, m_pCommunicationConnection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_freeText() {
		return m_freeText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_freeText(String newM_freeText) {
		String oldM_freeText = m_freeText;
		m_freeText = newM_freeText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__MFREE_TEXT, oldM_freeText, m_freeText));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__MODIFIED_TIME_WEAK, oldModifiedTimeWeak, modifiedTimeWeak));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifier getStereotypes() {
		if (stereotypes != null && stereotypes.eIsProxy()) {
			InternalEObject oldStereotypes = (InternalEObject)stereotypes;
			stereotypes = (IClassifier)eResolveProxy(oldStereotypes);
			if (stereotypes != oldStereotypes) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IMESSAGE__STEREOTYPES, oldStereotypes, stereotypes));
			}
		}
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifier basicGetStereotypes() {
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotypes(IClassifier newStereotypes) {
		IClassifier oldStereotypes = stereotypes;
		stereotypes = newStereotypes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__STEREOTYPES, oldStereotypes, stereotypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ITag> getTags() {
		if (tags == null) {
			tags = new EObjectContainmentEList.Resolving<ITag>(ITag.class, this, UMLRhapsodyPackage.IMESSAGE__TAGS);
		}
		return tags;
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
				NotificationChain msgs = oldProperties.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMESSAGE__PROPERTIES, null, null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMESSAGE__PROPERTIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IMESSAGE__PROPERTIES, oldProperties, properties));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__PROPERTIES, oldProperties, newProperties);
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
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMESSAGE__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IMESSAGE__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__PROPERTIES, newProperties, newProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IModelElement getM_targetExec() {
		if (m_targetExec != null && m_targetExec.eIsProxy()) {
			InternalEObject oldM_targetExec = (InternalEObject)m_targetExec;
			m_targetExec = (IModelElement)eResolveProxy(oldM_targetExec);
			if (m_targetExec != oldM_targetExec) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IMESSAGE__MTARGET_EXEC, oldM_targetExec, m_targetExec));
			}
		}
		return m_targetExec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IModelElement basicGetM_targetExec() {
		return m_targetExec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_targetExec(IModelElement newM_targetExec) {
		IModelElement oldM_targetExec = m_targetExec;
		m_targetExec = newM_targetExec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__MTARGET_EXEC, oldM_targetExec, m_targetExec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IModelElement getM_srcExec() {
		if (m_srcExec != null && m_srcExec.eIsProxy()) {
			InternalEObject oldM_srcExec = (InternalEObject)m_srcExec;
			m_srcExec = (IModelElement)eResolveProxy(oldM_srcExec);
			if (m_srcExec != oldM_srcExec) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IMESSAGE__MSRC_EXEC, oldM_srcExec, m_srcExec));
			}
		}
		return m_srcExec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IModelElement basicGetM_srcExec() {
		return m_srcExec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_srcExec(IModelElement newM_srcExec) {
		IModelElement oldM_srcExec = m_srcExec;
		m_srcExec = newM_srcExec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__MSRC_EXEC, oldM_srcExec, m_srcExec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObjectCreation() {
		return objectCreation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectCreation(String newObjectCreation) {
		String oldObjectCreation = objectCreation;
		objectCreation = newObjectCreation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__OBJECT_CREATION, oldObjectCreation, objectCreation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUmlDependencyID() {
		return umlDependencyID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlDependencyID(String newUmlDependencyID) {
		String oldUmlDependencyID = umlDependencyID;
		umlDependencyID = newUmlDependencyID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IMESSAGE__UML_DEPENDENCY_ID, oldUmlDependencyID, umlDependencyID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.IMESSAGE__TAGS:
				return ((InternalEList<?>)getTags()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IMESSAGE__PROPERTIES:
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
			case UMLRhapsodyPackage.IMESSAGE__ID:
				return getId();
			case UMLRhapsodyPackage.IMESSAGE__MY_STATE:
				return getMyState();
			case UMLRhapsodyPackage.IMESSAGE__NAME:
				return getName();
			case UMLRhapsodyPackage.IMESSAGE__DISPLAY_NAME:
				return getDisplayName();
			case UMLRhapsodyPackage.IMESSAGE__MSZ_SEQUENCE:
				return getM_szSequence();
			case UMLRhapsodyPackage.IMESSAGE__MSZ_ACTUAL_ARGS:
				return getM_szActualArgs();
			case UMLRhapsodyPackage.IMESSAGE__MSZ_RETURN_VAL:
				return getM_szReturnVal();
			case UMLRhapsodyPackage.IMESSAGE__MPRECEIVER:
				if (resolve) return getM_pReceiver();
				return basicGetM_pReceiver();
			case UMLRhapsodyPackage.IMESSAGE__MPSENDER:
				if (resolve) return getM_pSender();
				return basicGetM_pSender();
			case UMLRhapsodyPackage.IMESSAGE__MPFORMAL_MESSAGE:
				if (resolve) return getM_pFormalMessage();
				return basicGetM_pFormalMessage();
			case UMLRhapsodyPackage.IMESSAGE__METYPE:
				return getM_eType();
			case UMLRhapsodyPackage.IMESSAGE__MPCOMMUNICATION_CONNECTION:
				if (resolve) return getM_pCommunicationConnection();
				return basicGetM_pCommunicationConnection();
			case UMLRhapsodyPackage.IMESSAGE__MFREE_TEXT:
				return getM_freeText();
			case UMLRhapsodyPackage.IMESSAGE__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.IMESSAGE__STEREOTYPES:
				if (resolve) return getStereotypes();
				return basicGetStereotypes();
			case UMLRhapsodyPackage.IMESSAGE__TAGS:
				return getTags();
			case UMLRhapsodyPackage.IMESSAGE__PROPERTIES:
				if (resolve) return getProperties();
				return basicGetProperties();
			case UMLRhapsodyPackage.IMESSAGE__MTARGET_EXEC:
				if (resolve) return getM_targetExec();
				return basicGetM_targetExec();
			case UMLRhapsodyPackage.IMESSAGE__MSRC_EXEC:
				if (resolve) return getM_srcExec();
				return basicGetM_srcExec();
			case UMLRhapsodyPackage.IMESSAGE__OBJECT_CREATION:
				return getObjectCreation();
			case UMLRhapsodyPackage.IMESSAGE__UML_DEPENDENCY_ID:
				return getUmlDependencyID();
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
			case UMLRhapsodyPackage.IMESSAGE__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MY_STATE:
				setMyState((String)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__DISPLAY_NAME:
				setDisplayName((String)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MSZ_SEQUENCE:
				setM_szSequence((String)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MSZ_ACTUAL_ARGS:
				setM_szActualArgs((String)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MSZ_RETURN_VAL:
				setM_szReturnVal((String)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MPRECEIVER:
				setM_pReceiver((IClassifierRole)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MPSENDER:
				setM_pSender((IClassifierRole)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MPFORMAL_MESSAGE:
				setM_pFormalMessage((M_pFormalMessageType)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__METYPE:
				setM_eType((String)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MPCOMMUNICATION_CONNECTION:
				setM_pCommunicationConnection((IModelElement)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MFREE_TEXT:
				setM_freeText((String)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MODIFIED_TIME_WEAK:
				setModifiedTimeWeak((String)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__STEREOTYPES:
				setStereotypes((IClassifier)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends ITag>)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__PROPERTIES:
				setProperties((IPropertyContainer)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MTARGET_EXEC:
				setM_targetExec((IModelElement)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MSRC_EXEC:
				setM_srcExec((IModelElement)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__OBJECT_CREATION:
				setObjectCreation((String)newValue);
				return;
			case UMLRhapsodyPackage.IMESSAGE__UML_DEPENDENCY_ID:
				setUmlDependencyID((String)newValue);
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
			case UMLRhapsodyPackage.IMESSAGE__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MY_STATE:
				setMyState(MY_STATE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IMESSAGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IMESSAGE__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MSZ_SEQUENCE:
				setM_szSequence(MSZ_SEQUENCE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MSZ_ACTUAL_ARGS:
				setM_szActualArgs(MSZ_ACTUAL_ARGS_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MSZ_RETURN_VAL:
				setM_szReturnVal(MSZ_RETURN_VAL_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MPRECEIVER:
				setM_pReceiver((IClassifierRole)null);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MPSENDER:
				setM_pSender((IClassifierRole)null);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MPFORMAL_MESSAGE:
				setM_pFormalMessage((M_pFormalMessageType)null);
				return;
			case UMLRhapsodyPackage.IMESSAGE__METYPE:
				setM_eType(METYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MPCOMMUNICATION_CONNECTION:
				setM_pCommunicationConnection((IModelElement)null);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MFREE_TEXT:
				setM_freeText(MFREE_TEXT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MODIFIED_TIME_WEAK:
				setModifiedTimeWeak(MODIFIED_TIME_WEAK_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IMESSAGE__STEREOTYPES:
				setStereotypes((IClassifier)null);
				return;
			case UMLRhapsodyPackage.IMESSAGE__TAGS:
				getTags().clear();
				return;
			case UMLRhapsodyPackage.IMESSAGE__PROPERTIES:
				setProperties((IPropertyContainer)null);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MTARGET_EXEC:
				setM_targetExec((IModelElement)null);
				return;
			case UMLRhapsodyPackage.IMESSAGE__MSRC_EXEC:
				setM_srcExec((IModelElement)null);
				return;
			case UMLRhapsodyPackage.IMESSAGE__OBJECT_CREATION:
				setObjectCreation(OBJECT_CREATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IMESSAGE__UML_DEPENDENCY_ID:
				setUmlDependencyID(UML_DEPENDENCY_ID_EDEFAULT);
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
			case UMLRhapsodyPackage.IMESSAGE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.IMESSAGE__MY_STATE:
				return MY_STATE_EDEFAULT == null ? myState != null : !MY_STATE_EDEFAULT.equals(myState);
			case UMLRhapsodyPackage.IMESSAGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.IMESSAGE__DISPLAY_NAME:
				return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
			case UMLRhapsodyPackage.IMESSAGE__MSZ_SEQUENCE:
				return MSZ_SEQUENCE_EDEFAULT == null ? m_szSequence != null : !MSZ_SEQUENCE_EDEFAULT.equals(m_szSequence);
			case UMLRhapsodyPackage.IMESSAGE__MSZ_ACTUAL_ARGS:
				return MSZ_ACTUAL_ARGS_EDEFAULT == null ? m_szActualArgs != null : !MSZ_ACTUAL_ARGS_EDEFAULT.equals(m_szActualArgs);
			case UMLRhapsodyPackage.IMESSAGE__MSZ_RETURN_VAL:
				return MSZ_RETURN_VAL_EDEFAULT == null ? m_szReturnVal != null : !MSZ_RETURN_VAL_EDEFAULT.equals(m_szReturnVal);
			case UMLRhapsodyPackage.IMESSAGE__MPRECEIVER:
				return m_pReceiver != null;
			case UMLRhapsodyPackage.IMESSAGE__MPSENDER:
				return m_pSender != null;
			case UMLRhapsodyPackage.IMESSAGE__MPFORMAL_MESSAGE:
				return m_pFormalMessage != null;
			case UMLRhapsodyPackage.IMESSAGE__METYPE:
				return METYPE_EDEFAULT == null ? m_eType != null : !METYPE_EDEFAULT.equals(m_eType);
			case UMLRhapsodyPackage.IMESSAGE__MPCOMMUNICATION_CONNECTION:
				return m_pCommunicationConnection != null;
			case UMLRhapsodyPackage.IMESSAGE__MFREE_TEXT:
				return MFREE_TEXT_EDEFAULT == null ? m_freeText != null : !MFREE_TEXT_EDEFAULT.equals(m_freeText);
			case UMLRhapsodyPackage.IMESSAGE__MODIFIED_TIME_WEAK:
				return MODIFIED_TIME_WEAK_EDEFAULT == null ? modifiedTimeWeak != null : !MODIFIED_TIME_WEAK_EDEFAULT.equals(modifiedTimeWeak);
			case UMLRhapsodyPackage.IMESSAGE__STEREOTYPES:
				return stereotypes != null;
			case UMLRhapsodyPackage.IMESSAGE__TAGS:
				return tags != null && !tags.isEmpty();
			case UMLRhapsodyPackage.IMESSAGE__PROPERTIES:
				return properties != null;
			case UMLRhapsodyPackage.IMESSAGE__MTARGET_EXEC:
				return m_targetExec != null;
			case UMLRhapsodyPackage.IMESSAGE__MSRC_EXEC:
				return m_srcExec != null;
			case UMLRhapsodyPackage.IMESSAGE__OBJECT_CREATION:
				return OBJECT_CREATION_EDEFAULT == null ? objectCreation != null : !OBJECT_CREATION_EDEFAULT.equals(objectCreation);
			case UMLRhapsodyPackage.IMESSAGE__UML_DEPENDENCY_ID:
				return UML_DEPENDENCY_ID_EDEFAULT == null ? umlDependencyID != null : !UML_DEPENDENCY_ID_EDEFAULT.equals(umlDependencyID);
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
		result.append(", myState: "); //$NON-NLS-1$
		result.append(myState);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", displayName: "); //$NON-NLS-1$
		result.append(displayName);
		result.append(", m_szSequence: "); //$NON-NLS-1$
		result.append(m_szSequence);
		result.append(", m_szActualArgs: "); //$NON-NLS-1$
		result.append(m_szActualArgs);
		result.append(", m_szReturnVal: "); //$NON-NLS-1$
		result.append(m_szReturnVal);
		result.append(", m_eType: "); //$NON-NLS-1$
		result.append(m_eType);
		result.append(", m_freeText: "); //$NON-NLS-1$
		result.append(m_freeText);
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(", objectCreation: "); //$NON-NLS-1$
		result.append(objectCreation);
		result.append(", umlDependencyID: "); //$NON-NLS-1$
		result.append(umlDependencyID);
		result.append(')');
		return result.toString();
	}

} //IMessageImpl
