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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationRole;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassifierRole;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICollaboration;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICombinedFragment;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IConstraint;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IExecutionOccurrence;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInteractionOccurrence;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMessage;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.P_MessageHandlerType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ICollaboration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICollaborationImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICollaborationImpl#getClassifierRoles <em>Classifier Roles</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICollaborationImpl#getMessages <em>Messages</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICollaborationImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICollaborationImpl#getAssociationRoles <em>Association Roles</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICollaborationImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICollaborationImpl#getCombinedFragments <em>Combined Fragments</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICollaborationImpl#getP_MessageHandler <em>PMessage Handler</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICollaborationImpl#getInteractionOccurrences <em>Interaction Occurrences</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICollaborationImpl#getExecutionOccurrences <em>Execution Occurrences</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICollaborationImpl#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICollaborationImpl#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ICollaborationImpl extends IModelElementImpl implements ICollaboration {
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
	 * The cached value of the '{@link #getClassifierRoles() <em>Classifier Roles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifierRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<IClassifierRole> classifierRoles;

	/**
	 * The cached value of the '{@link #getMessages() <em>Messages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessages()
	 * @generated
	 * @ordered
	 */
	protected EList<IMessage> messages;

	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected IConstraint annotations;

	/**
	 * The cached value of the '{@link #getAssociationRoles() <em>Association Roles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<IAssociationRole> associationRoles;

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
	 * The cached value of the '{@link #getCombinedFragments() <em>Combined Fragments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCombinedFragments()
	 * @generated
	 * @ordered
	 */
	protected EList<ICombinedFragment> combinedFragments;

	/**
	 * The cached value of the '{@link #getP_MessageHandler() <em>PMessage Handler</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getP_MessageHandler()
	 * @generated
	 * @ordered
	 */
	protected EList<P_MessageHandlerType> p_MessageHandler;

	/**
	 * The cached value of the '{@link #getInteractionOccurrences() <em>Interaction Occurrences</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteractionOccurrences()
	 * @generated
	 * @ordered
	 */
	protected IInteractionOccurrence interactionOccurrences;

	/**
	 * The cached value of the '{@link #getExecutionOccurrences() <em>Execution Occurrences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionOccurrences()
	 * @generated
	 * @ordered
	 */
	protected EList<IExecutionOccurrence> executionOccurrences;

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
	protected ICollaborationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getICollaboration();
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOLLABORATION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IClassifierRole> getClassifierRoles() {
		if (classifierRoles == null) {
			classifierRoles = new EObjectContainmentEList.Resolving<IClassifierRole>(IClassifierRole.class, this, UMLRhapsodyPackage.ICOLLABORATION__CLASSIFIER_ROLES);
		}
		return classifierRoles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IMessage> getMessages() {
		if (messages == null) {
			messages = new EObjectContainmentEList.Resolving<IMessage>(IMessage.class, this, UMLRhapsodyPackage.ICOLLABORATION__MESSAGES);
		}
		return messages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IConstraint getAnnotations() {
		if (annotations != null && annotations.eIsProxy()) {
			InternalEObject oldAnnotations = (InternalEObject)annotations;
			annotations = (IConstraint)eResolveProxy(oldAnnotations);
			if (annotations != oldAnnotations) {
				InternalEObject newAnnotations = (InternalEObject)annotations;
				NotificationChain msgs = oldAnnotations.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOLLABORATION__ANNOTATIONS, null, null);
				if (newAnnotations.eInternalContainer() == null) {
					msgs = newAnnotations.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOLLABORATION__ANNOTATIONS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICOLLABORATION__ANNOTATIONS, oldAnnotations, annotations));
			}
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IConstraint basicGetAnnotations() {
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnnotations(IConstraint newAnnotations, NotificationChain msgs) {
		IConstraint oldAnnotations = annotations;
		annotations = newAnnotations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOLLABORATION__ANNOTATIONS, oldAnnotations, newAnnotations);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotations(IConstraint newAnnotations) {
		if (newAnnotations != annotations) {
			NotificationChain msgs = null;
			if (annotations != null)
				msgs = ((InternalEObject)annotations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOLLABORATION__ANNOTATIONS, null, msgs);
			if (newAnnotations != null)
				msgs = ((InternalEObject)newAnnotations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOLLABORATION__ANNOTATIONS, null, msgs);
			msgs = basicSetAnnotations(newAnnotations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOLLABORATION__ANNOTATIONS, newAnnotations, newAnnotations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IAssociationRole> getAssociationRoles() {
		if (associationRoles == null) {
			associationRoles = new EObjectContainmentEList.Resolving<IAssociationRole>(IAssociationRole.class, this, UMLRhapsodyPackage.ICOLLABORATION__ASSOCIATION_ROLES);
		}
		return associationRoles;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOLLABORATION__MODIFIED_TIME_WEAK, oldModifiedTimeWeak, modifiedTimeWeak));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ICombinedFragment> getCombinedFragments() {
		if (combinedFragments == null) {
			combinedFragments = new EObjectContainmentEList.Resolving<ICombinedFragment>(ICombinedFragment.class, this, UMLRhapsodyPackage.ICOLLABORATION__COMBINED_FRAGMENTS);
		}
		return combinedFragments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<P_MessageHandlerType> getP_MessageHandler() {
		if (p_MessageHandler == null) {
			p_MessageHandler = new EObjectContainmentEList.Resolving<P_MessageHandlerType>(P_MessageHandlerType.class, this, UMLRhapsodyPackage.ICOLLABORATION__PMESSAGE_HANDLER);
		}
		return p_MessageHandler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInteractionOccurrence getInteractionOccurrences() {
		if (interactionOccurrences != null && interactionOccurrences.eIsProxy()) {
			InternalEObject oldInteractionOccurrences = (InternalEObject)interactionOccurrences;
			interactionOccurrences = (IInteractionOccurrence)eResolveProxy(oldInteractionOccurrences);
			if (interactionOccurrences != oldInteractionOccurrences) {
				InternalEObject newInteractionOccurrences = (InternalEObject)interactionOccurrences;
				NotificationChain msgs = oldInteractionOccurrences.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOLLABORATION__INTERACTION_OCCURRENCES, null, null);
				if (newInteractionOccurrences.eInternalContainer() == null) {
					msgs = newInteractionOccurrences.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOLLABORATION__INTERACTION_OCCURRENCES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICOLLABORATION__INTERACTION_OCCURRENCES, oldInteractionOccurrences, interactionOccurrences));
			}
		}
		return interactionOccurrences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInteractionOccurrence basicGetInteractionOccurrences() {
		return interactionOccurrences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInteractionOccurrences(IInteractionOccurrence newInteractionOccurrences, NotificationChain msgs) {
		IInteractionOccurrence oldInteractionOccurrences = interactionOccurrences;
		interactionOccurrences = newInteractionOccurrences;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOLLABORATION__INTERACTION_OCCURRENCES, oldInteractionOccurrences, newInteractionOccurrences);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInteractionOccurrences(IInteractionOccurrence newInteractionOccurrences) {
		if (newInteractionOccurrences != interactionOccurrences) {
			NotificationChain msgs = null;
			if (interactionOccurrences != null)
				msgs = ((InternalEObject)interactionOccurrences).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOLLABORATION__INTERACTION_OCCURRENCES, null, msgs);
			if (newInteractionOccurrences != null)
				msgs = ((InternalEObject)newInteractionOccurrences).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.ICOLLABORATION__INTERACTION_OCCURRENCES, null, msgs);
			msgs = basicSetInteractionOccurrences(newInteractionOccurrences, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOLLABORATION__INTERACTION_OCCURRENCES, newInteractionOccurrences, newInteractionOccurrences));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IExecutionOccurrence> getExecutionOccurrences() {
		if (executionOccurrences == null) {
			executionOccurrences = new EObjectContainmentEList.Resolving<IExecutionOccurrence>(IExecutionOccurrence.class, this, UMLRhapsodyPackage.ICOLLABORATION__EXECUTION_OCCURRENCES);
		}
		return executionOccurrences;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOLLABORATION__OBJECT_CREATION, oldObjectCreation, objectCreation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICOLLABORATION__UML_DEPENDENCY_ID, oldUmlDependencyID, umlDependencyID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.ICOLLABORATION__CLASSIFIER_ROLES:
				return ((InternalEList<?>)getClassifierRoles()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICOLLABORATION__MESSAGES:
				return ((InternalEList<?>)getMessages()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICOLLABORATION__ANNOTATIONS:
				return basicSetAnnotations(null, msgs);
			case UMLRhapsodyPackage.ICOLLABORATION__ASSOCIATION_ROLES:
				return ((InternalEList<?>)getAssociationRoles()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICOLLABORATION__COMBINED_FRAGMENTS:
				return ((InternalEList<?>)getCombinedFragments()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICOLLABORATION__PMESSAGE_HANDLER:
				return ((InternalEList<?>)getP_MessageHandler()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.ICOLLABORATION__INTERACTION_OCCURRENCES:
				return basicSetInteractionOccurrences(null, msgs);
			case UMLRhapsodyPackage.ICOLLABORATION__EXECUTION_OCCURRENCES:
				return ((InternalEList<?>)getExecutionOccurrences()).basicRemove(otherEnd, msgs);
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
			case UMLRhapsodyPackage.ICOLLABORATION__ID:
				return getId();
			case UMLRhapsodyPackage.ICOLLABORATION__CLASSIFIER_ROLES:
				return getClassifierRoles();
			case UMLRhapsodyPackage.ICOLLABORATION__MESSAGES:
				return getMessages();
			case UMLRhapsodyPackage.ICOLLABORATION__ANNOTATIONS:
				if (resolve) return getAnnotations();
				return basicGetAnnotations();
			case UMLRhapsodyPackage.ICOLLABORATION__ASSOCIATION_ROLES:
				return getAssociationRoles();
			case UMLRhapsodyPackage.ICOLLABORATION__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.ICOLLABORATION__COMBINED_FRAGMENTS:
				return getCombinedFragments();
			case UMLRhapsodyPackage.ICOLLABORATION__PMESSAGE_HANDLER:
				return getP_MessageHandler();
			case UMLRhapsodyPackage.ICOLLABORATION__INTERACTION_OCCURRENCES:
				if (resolve) return getInteractionOccurrences();
				return basicGetInteractionOccurrences();
			case UMLRhapsodyPackage.ICOLLABORATION__EXECUTION_OCCURRENCES:
				return getExecutionOccurrences();
			case UMLRhapsodyPackage.ICOLLABORATION__OBJECT_CREATION:
				return getObjectCreation();
			case UMLRhapsodyPackage.ICOLLABORATION__UML_DEPENDENCY_ID:
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
			case UMLRhapsodyPackage.ICOLLABORATION__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__CLASSIFIER_ROLES:
				getClassifierRoles().clear();
				getClassifierRoles().addAll((Collection<? extends IClassifierRole>)newValue);
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__MESSAGES:
				getMessages().clear();
				getMessages().addAll((Collection<? extends IMessage>)newValue);
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__ANNOTATIONS:
				setAnnotations((IConstraint)newValue);
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__ASSOCIATION_ROLES:
				getAssociationRoles().clear();
				getAssociationRoles().addAll((Collection<? extends IAssociationRole>)newValue);
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__MODIFIED_TIME_WEAK:
				setModifiedTimeWeak((String)newValue);
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__COMBINED_FRAGMENTS:
				getCombinedFragments().clear();
				getCombinedFragments().addAll((Collection<? extends ICombinedFragment>)newValue);
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__PMESSAGE_HANDLER:
				getP_MessageHandler().clear();
				getP_MessageHandler().addAll((Collection<? extends P_MessageHandlerType>)newValue);
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__INTERACTION_OCCURRENCES:
				setInteractionOccurrences((IInteractionOccurrence)newValue);
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__EXECUTION_OCCURRENCES:
				getExecutionOccurrences().clear();
				getExecutionOccurrences().addAll((Collection<? extends IExecutionOccurrence>)newValue);
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__OBJECT_CREATION:
				setObjectCreation((String)newValue);
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__UML_DEPENDENCY_ID:
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
			case UMLRhapsodyPackage.ICOLLABORATION__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__CLASSIFIER_ROLES:
				getClassifierRoles().clear();
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__MESSAGES:
				getMessages().clear();
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__ANNOTATIONS:
				setAnnotations((IConstraint)null);
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__ASSOCIATION_ROLES:
				getAssociationRoles().clear();
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__MODIFIED_TIME_WEAK:
				setModifiedTimeWeak(MODIFIED_TIME_WEAK_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__COMBINED_FRAGMENTS:
				getCombinedFragments().clear();
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__PMESSAGE_HANDLER:
				getP_MessageHandler().clear();
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__INTERACTION_OCCURRENCES:
				setInteractionOccurrences((IInteractionOccurrence)null);
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__EXECUTION_OCCURRENCES:
				getExecutionOccurrences().clear();
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__OBJECT_CREATION:
				setObjectCreation(OBJECT_CREATION_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICOLLABORATION__UML_DEPENDENCY_ID:
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
			case UMLRhapsodyPackage.ICOLLABORATION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.ICOLLABORATION__CLASSIFIER_ROLES:
				return classifierRoles != null && !classifierRoles.isEmpty();
			case UMLRhapsodyPackage.ICOLLABORATION__MESSAGES:
				return messages != null && !messages.isEmpty();
			case UMLRhapsodyPackage.ICOLLABORATION__ANNOTATIONS:
				return annotations != null;
			case UMLRhapsodyPackage.ICOLLABORATION__ASSOCIATION_ROLES:
				return associationRoles != null && !associationRoles.isEmpty();
			case UMLRhapsodyPackage.ICOLLABORATION__MODIFIED_TIME_WEAK:
				return MODIFIED_TIME_WEAK_EDEFAULT == null ? modifiedTimeWeak != null : !MODIFIED_TIME_WEAK_EDEFAULT.equals(modifiedTimeWeak);
			case UMLRhapsodyPackage.ICOLLABORATION__COMBINED_FRAGMENTS:
				return combinedFragments != null && !combinedFragments.isEmpty();
			case UMLRhapsodyPackage.ICOLLABORATION__PMESSAGE_HANDLER:
				return p_MessageHandler != null && !p_MessageHandler.isEmpty();
			case UMLRhapsodyPackage.ICOLLABORATION__INTERACTION_OCCURRENCES:
				return interactionOccurrences != null;
			case UMLRhapsodyPackage.ICOLLABORATION__EXECUTION_OCCURRENCES:
				return executionOccurrences != null && !executionOccurrences.isEmpty();
			case UMLRhapsodyPackage.ICOLLABORATION__OBJECT_CREATION:
				return OBJECT_CREATION_EDEFAULT == null ? objectCreation != null : !OBJECT_CREATION_EDEFAULT.equals(objectCreation);
			case UMLRhapsodyPackage.ICOLLABORATION__UML_DEPENDENCY_ID:
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
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(", objectCreation: "); //$NON-NLS-1$
		result.append(objectCreation);
		result.append(", umlDependencyID: "); //$NON-NLS-1$
		result.append(umlDependencyID);
		result.append(')');
		return result.toString();
	}

} //ICollaborationImpl
