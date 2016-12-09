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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDescription;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFileFragment;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITag;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_subjectType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IFile Fragment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IFileFragmentImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IFileFragmentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IFileFragmentImpl#getM_type <em>Mtype</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IFileFragmentImpl#getM_text <em>Mtext</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IFileFragmentImpl#getM_startRow <em>Mstart Row</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IFileFragmentImpl#getM_startCol <em>Mstart Col</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IFileFragmentImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IFileFragmentImpl#getM_startCol_Short <em>Mstart Col Short</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IFileFragmentImpl#getM_endRow <em>Mend Row</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IFileFragmentImpl#getM_endCol_Short <em>Mend Col Short</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IFileFragmentImpl#getM_subject <em>Msubject</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IFileFragmentImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IFileFragmentImpl#getFragments <em>Fragments</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IFileFragmentImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IFileFragmentImpl#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IFileFragmentImpl#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IFileFragmentImpl extends IModelElementImpl implements IFileFragment {
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
	 * The default value of the '{@link #getM_type() <em>Mtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_type()
	 * @generated
	 * @ordered
	 */
	protected static final String MTYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_type() <em>Mtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_type()
	 * @generated
	 * @ordered
	 */
	protected String m_type = MTYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_text() <em>Mtext</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_text()
	 * @generated
	 * @ordered
	 */
	protected static final String MTEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_text() <em>Mtext</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_text()
	 * @generated
	 * @ordered
	 */
	protected String m_text = MTEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_startRow() <em>Mstart Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_startRow()
	 * @generated
	 * @ordered
	 */
	protected static final String MSTART_ROW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_startRow() <em>Mstart Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_startRow()
	 * @generated
	 * @ordered
	 */
	protected String m_startRow = MSTART_ROW_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_startCol() <em>Mstart Col</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_startCol()
	 * @generated
	 * @ordered
	 */
	protected static final String MSTART_COL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_startCol() <em>Mstart Col</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_startCol()
	 * @generated
	 * @ordered
	 */
	protected String m_startCol = MSTART_COL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected IDescription description;

	/**
	 * The default value of the '{@link #getM_startCol_Short() <em>Mstart Col Short</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_startCol_Short()
	 * @generated
	 * @ordered
	 */
	protected static final String MSTART_COL_SHORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_startCol_Short() <em>Mstart Col Short</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_startCol_Short()
	 * @generated
	 * @ordered
	 */
	protected String m_startCol_Short = MSTART_COL_SHORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_endRow() <em>Mend Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_endRow()
	 * @generated
	 * @ordered
	 */
	protected static final String MEND_ROW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_endRow() <em>Mend Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_endRow()
	 * @generated
	 * @ordered
	 */
	protected String m_endRow = MEND_ROW_EDEFAULT;

	/**
	 * The default value of the '{@link #getM_endCol_Short() <em>Mend Col Short</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_endCol_Short()
	 * @generated
	 * @ordered
	 */
	protected static final String MEND_COL_SHORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM_endCol_Short() <em>Mend Col Short</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_endCol_Short()
	 * @generated
	 * @ordered
	 */
	protected String m_endCol_Short = MEND_COL_SHORT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getM_subject() <em>Msubject</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM_subject()
	 * @generated
	 * @ordered
	 */
	protected M_subjectType m_subject;

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
	 * The cached value of the '{@link #getFragments() <em>Fragments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragments()
	 * @generated
	 * @ordered
	 */
	protected EList<IFileFragment> fragments;

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
	protected IFileFragmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIFileFragment();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IFILE_FRAGMENT__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IFILE_FRAGMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_type() {
		return m_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_type(String newM_type) {
		String oldM_type = m_type;
		m_type = newM_type;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IFILE_FRAGMENT__MTYPE, oldM_type, m_type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_text() {
		return m_text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_text(String newM_text) {
		String oldM_text = m_text;
		m_text = newM_text;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IFILE_FRAGMENT__MTEXT, oldM_text, m_text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_startRow() {
		return m_startRow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_startRow(String newM_startRow) {
		String oldM_startRow = m_startRow;
		m_startRow = newM_startRow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IFILE_FRAGMENT__MSTART_ROW, oldM_startRow, m_startRow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_startCol() {
		return m_startCol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_startCol(String newM_startCol) {
		String oldM_startCol = m_startCol;
		m_startCol = newM_startCol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IFILE_FRAGMENT__MSTART_COL, oldM_startCol, m_startCol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDescription getDescription() {
		if (description != null && description.eIsProxy()) {
			InternalEObject oldDescription = (InternalEObject)description;
			description = (IDescription)eResolveProxy(oldDescription);
			if (description != oldDescription) {
				InternalEObject newDescription = (InternalEObject)description;
				NotificationChain msgs = oldDescription.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IFILE_FRAGMENT__DESCRIPTION, null, null);
				if (newDescription.eInternalContainer() == null) {
					msgs = newDescription.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IFILE_FRAGMENT__DESCRIPTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IFILE_FRAGMENT__DESCRIPTION, oldDescription, description));
			}
		}
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDescription basicGetDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescription(IDescription newDescription, NotificationChain msgs) {
		IDescription oldDescription = description;
		description = newDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IFILE_FRAGMENT__DESCRIPTION, oldDescription, newDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(IDescription newDescription) {
		if (newDescription != description) {
			NotificationChain msgs = null;
			if (description != null)
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IFILE_FRAGMENT__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IFILE_FRAGMENT__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IFILE_FRAGMENT__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_startCol_Short() {
		return m_startCol_Short;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_startCol_Short(String newM_startCol_Short) {
		String oldM_startCol_Short = m_startCol_Short;
		m_startCol_Short = newM_startCol_Short;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IFILE_FRAGMENT__MSTART_COL_SHORT, oldM_startCol_Short, m_startCol_Short));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_endRow() {
		return m_endRow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_endRow(String newM_endRow) {
		String oldM_endRow = m_endRow;
		m_endRow = newM_endRow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IFILE_FRAGMENT__MEND_ROW, oldM_endRow, m_endRow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM_endCol_Short() {
		return m_endCol_Short;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_endCol_Short(String newM_endCol_Short) {
		String oldM_endCol_Short = m_endCol_Short;
		m_endCol_Short = newM_endCol_Short;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IFILE_FRAGMENT__MEND_COL_SHORT, oldM_endCol_Short, m_endCol_Short));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_subjectType getM_subject() {
		if (m_subject != null && m_subject.eIsProxy()) {
			InternalEObject oldM_subject = (InternalEObject)m_subject;
			m_subject = (M_subjectType)eResolveProxy(oldM_subject);
			if (m_subject != oldM_subject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IFILE_FRAGMENT__MSUBJECT, oldM_subject, m_subject));
			}
		}
		return m_subject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_subjectType basicGetM_subject() {
		return m_subject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM_subject(M_subjectType newM_subject) {
		M_subjectType oldM_subject = m_subject;
		m_subject = newM_subject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IFILE_FRAGMENT__MSUBJECT, oldM_subject, m_subject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ITag> getTags() {
		if (tags == null) {
			tags = new EObjectContainmentEList.Resolving<ITag>(ITag.class, this, UMLRhapsodyPackage.IFILE_FRAGMENT__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IFileFragment> getFragments() {
		if (fragments == null) {
			fragments = new EObjectContainmentEList.Resolving<IFileFragment>(IFileFragment.class, this, UMLRhapsodyPackage.IFILE_FRAGMENT__FRAGMENTS);
		}
		return fragments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getModifiedTimeWeak() {
		if (modifiedTimeWeak == null) {
			modifiedTimeWeak = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IFILE_FRAGMENT__MODIFIED_TIME_WEAK);
		}
		return modifiedTimeWeak;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IFILE_FRAGMENT__OBJECT_CREATION, oldObjectCreation, objectCreation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IFILE_FRAGMENT__UML_DEPENDENCY_ID, oldUmlDependencyID, umlDependencyID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.IFILE_FRAGMENT__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case UMLRhapsodyPackage.IFILE_FRAGMENT__TAGS:
				return ((InternalEList<?>)getTags()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IFILE_FRAGMENT__FRAGMENTS:
				return ((InternalEList<?>)getFragments()).basicRemove(otherEnd, msgs);
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
			case UMLRhapsodyPackage.IFILE_FRAGMENT__ID:
				return getId();
			case UMLRhapsodyPackage.IFILE_FRAGMENT__NAME:
				return getName();
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MTYPE:
				return getM_type();
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MTEXT:
				return getM_text();
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MSTART_ROW:
				return getM_startRow();
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MSTART_COL:
				return getM_startCol();
			case UMLRhapsodyPackage.IFILE_FRAGMENT__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MSTART_COL_SHORT:
				return getM_startCol_Short();
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MEND_ROW:
				return getM_endRow();
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MEND_COL_SHORT:
				return getM_endCol_Short();
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MSUBJECT:
				if (resolve) return getM_subject();
				return basicGetM_subject();
			case UMLRhapsodyPackage.IFILE_FRAGMENT__TAGS:
				return getTags();
			case UMLRhapsodyPackage.IFILE_FRAGMENT__FRAGMENTS:
				return getFragments();
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.IFILE_FRAGMENT__OBJECT_CREATION:
				return getObjectCreation();
			case UMLRhapsodyPackage.IFILE_FRAGMENT__UML_DEPENDENCY_ID:
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
			case UMLRhapsodyPackage.IFILE_FRAGMENT__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__NAME:
				setName((String)newValue);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MTYPE:
				setM_type((String)newValue);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MTEXT:
				setM_text((String)newValue);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MSTART_ROW:
				setM_startRow((String)newValue);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MSTART_COL:
				setM_startCol((String)newValue);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__DESCRIPTION:
				setDescription((IDescription)newValue);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MSTART_COL_SHORT:
				setM_startCol_Short((String)newValue);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MEND_ROW:
				setM_endRow((String)newValue);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MEND_COL_SHORT:
				setM_endCol_Short((String)newValue);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MSUBJECT:
				setM_subject((M_subjectType)newValue);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends ITag>)newValue);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__FRAGMENTS:
				getFragments().clear();
				getFragments().addAll((Collection<? extends IFileFragment>)newValue);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				getModifiedTimeWeak().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__OBJECT_CREATION:
				setObjectCreation((String)newValue);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__UML_DEPENDENCY_ID:
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
			case UMLRhapsodyPackage.IFILE_FRAGMENT__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MTYPE:
				setM_type(MTYPE_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MTEXT:
				setM_text(MTEXT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MSTART_ROW:
				setM_startRow(MSTART_ROW_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MSTART_COL:
				setM_startCol(MSTART_COL_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__DESCRIPTION:
				setDescription((IDescription)null);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MSTART_COL_SHORT:
				setM_startCol_Short(MSTART_COL_SHORT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MEND_ROW:
				setM_endRow(MEND_ROW_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MEND_COL_SHORT:
				setM_endCol_Short(MEND_COL_SHORT_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MSUBJECT:
				setM_subject((M_subjectType)null);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__TAGS:
				getTags().clear();
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__FRAGMENTS:
				getFragments().clear();
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MODIFIED_TIME_WEAK:
				getModifiedTimeWeak().clear();
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__OBJECT_CREATION:
				setObjectCreation(OBJECT_CREATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__UML_DEPENDENCY_ID:
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
			case UMLRhapsodyPackage.IFILE_FRAGMENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.IFILE_FRAGMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MTYPE:
				return MTYPE_EDEFAULT == null ? m_type != null : !MTYPE_EDEFAULT.equals(m_type);
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MTEXT:
				return MTEXT_EDEFAULT == null ? m_text != null : !MTEXT_EDEFAULT.equals(m_text);
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MSTART_ROW:
				return MSTART_ROW_EDEFAULT == null ? m_startRow != null : !MSTART_ROW_EDEFAULT.equals(m_startRow);
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MSTART_COL:
				return MSTART_COL_EDEFAULT == null ? m_startCol != null : !MSTART_COL_EDEFAULT.equals(m_startCol);
			case UMLRhapsodyPackage.IFILE_FRAGMENT__DESCRIPTION:
				return description != null;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MSTART_COL_SHORT:
				return MSTART_COL_SHORT_EDEFAULT == null ? m_startCol_Short != null : !MSTART_COL_SHORT_EDEFAULT.equals(m_startCol_Short);
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MEND_ROW:
				return MEND_ROW_EDEFAULT == null ? m_endRow != null : !MEND_ROW_EDEFAULT.equals(m_endRow);
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MEND_COL_SHORT:
				return MEND_COL_SHORT_EDEFAULT == null ? m_endCol_Short != null : !MEND_COL_SHORT_EDEFAULT.equals(m_endCol_Short);
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MSUBJECT:
				return m_subject != null;
			case UMLRhapsodyPackage.IFILE_FRAGMENT__TAGS:
				return tags != null && !tags.isEmpty();
			case UMLRhapsodyPackage.IFILE_FRAGMENT__FRAGMENTS:
				return fragments != null && !fragments.isEmpty();
			case UMLRhapsodyPackage.IFILE_FRAGMENT__MODIFIED_TIME_WEAK:
				return modifiedTimeWeak != null && !modifiedTimeWeak.isEmpty();
			case UMLRhapsodyPackage.IFILE_FRAGMENT__OBJECT_CREATION:
				return OBJECT_CREATION_EDEFAULT == null ? objectCreation != null : !OBJECT_CREATION_EDEFAULT.equals(objectCreation);
			case UMLRhapsodyPackage.IFILE_FRAGMENT__UML_DEPENDENCY_ID:
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
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", m_type: "); //$NON-NLS-1$
		result.append(m_type);
		result.append(", m_text: "); //$NON-NLS-1$
		result.append(m_text);
		result.append(", m_startRow: "); //$NON-NLS-1$
		result.append(m_startRow);
		result.append(", m_startCol: "); //$NON-NLS-1$
		result.append(m_startCol);
		result.append(", m_startCol_Short: "); //$NON-NLS-1$
		result.append(m_startCol_Short);
		result.append(", m_endRow: "); //$NON-NLS-1$
		result.append(m_endRow);
		result.append(", m_endCol_Short: "); //$NON-NLS-1$
		result.append(m_endCol_Short);
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(", objectCreation: "); //$NON-NLS-1$
		result.append(objectCreation);
		result.append(", umlDependencyID: "); //$NON-NLS-1$
		result.append(umlDependencyID);
		result.append(')');
		return result.toString();
	}

} //IFileFragmentImpl
