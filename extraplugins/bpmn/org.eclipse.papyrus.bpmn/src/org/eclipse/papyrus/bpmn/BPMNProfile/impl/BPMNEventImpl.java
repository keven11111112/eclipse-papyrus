/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNEvent;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProperty;
import org.eclipse.papyrus.bpmn.BPMNProfile.EventDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BPMN Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNEventImpl#getEventClass <em>Event Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNEventImpl#get_eventDefinitions <em>event Definitions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNEventImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNEventImpl#getEventDefinitionRefs <em>Event Definition Refs</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BPMNEventImpl extends FlowNodeImpl implements BPMNEvent {
	/**
	 * The cached value of the '{@link #getEventClass() <em>Event Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventClass()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class eventClass;

	/**
	 * The cached value of the '{@link #get_eventDefinitions() <em>event Definitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #get_eventDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<EventDefinition> _eventDefinitions;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<BPMNProperty> properties;

	/**
	 * The cached value of the '{@link #getEventDefinitionRefs() <em>Event Definition Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventDefinitionRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<EventDefinition> eventDefinitionRefs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BPMNEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getBPMNEvent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getEventClass() {
		if (eventClass != null && eventClass.eIsProxy()) {
			InternalEObject oldEventClass = (InternalEObject)eventClass;
			eventClass = (org.eclipse.uml2.uml.Class)eResolveProxy(oldEventClass);
			if (eventClass != oldEventClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.BPMN_EVENT__EVENT_CLASS, oldEventClass, eventClass));
			}
		}
		return eventClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetEventClass() {
		return eventClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventClass(org.eclipse.uml2.uml.Class newEventClass) {
		org.eclipse.uml2.uml.Class oldEventClass = eventClass;
		eventClass = newEventClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_EVENT__EVENT_CLASS, oldEventClass, eventClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventDefinition> get_eventDefinitions() {
		if (_eventDefinitions == null) {
			_eventDefinitions = new EObjectResolvingEList<EventDefinition>(EventDefinition.class, this, BPMNProfilePackage.BPMN_EVENT__EVENT_DEFINITIONS);
		}
		return _eventDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BPMNProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectResolvingEList<BPMNProperty>(BPMNProperty.class, this, BPMNProfilePackage.BPMN_EVENT__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventDefinition> getEventDefinitionRefs() {
		if (eventDefinitionRefs == null) {
			eventDefinitionRefs = new EObjectResolvingEList<EventDefinition>(EventDefinition.class, this, BPMNProfilePackage.BPMN_EVENT__EVENT_DEFINITION_REFS);
		}
		return eventDefinitionRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.BPMN_EVENT__EVENT_CLASS:
				if (resolve) return getEventClass();
				return basicGetEventClass();
			case BPMNProfilePackage.BPMN_EVENT__EVENT_DEFINITIONS:
				return get_eventDefinitions();
			case BPMNProfilePackage.BPMN_EVENT__PROPERTIES:
				return getProperties();
			case BPMNProfilePackage.BPMN_EVENT__EVENT_DEFINITION_REFS:
				return getEventDefinitionRefs();
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
			case BPMNProfilePackage.BPMN_EVENT__EVENT_CLASS:
				setEventClass((org.eclipse.uml2.uml.Class)newValue);
				return;
			case BPMNProfilePackage.BPMN_EVENT__EVENT_DEFINITIONS:
				get_eventDefinitions().clear();
				get_eventDefinitions().addAll((Collection<? extends EventDefinition>)newValue);
				return;
			case BPMNProfilePackage.BPMN_EVENT__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends BPMNProperty>)newValue);
				return;
			case BPMNProfilePackage.BPMN_EVENT__EVENT_DEFINITION_REFS:
				getEventDefinitionRefs().clear();
				getEventDefinitionRefs().addAll((Collection<? extends EventDefinition>)newValue);
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
			case BPMNProfilePackage.BPMN_EVENT__EVENT_CLASS:
				setEventClass((org.eclipse.uml2.uml.Class)null);
				return;
			case BPMNProfilePackage.BPMN_EVENT__EVENT_DEFINITIONS:
				get_eventDefinitions().clear();
				return;
			case BPMNProfilePackage.BPMN_EVENT__PROPERTIES:
				getProperties().clear();
				return;
			case BPMNProfilePackage.BPMN_EVENT__EVENT_DEFINITION_REFS:
				getEventDefinitionRefs().clear();
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
			case BPMNProfilePackage.BPMN_EVENT__EVENT_CLASS:
				return eventClass != null;
			case BPMNProfilePackage.BPMN_EVENT__EVENT_DEFINITIONS:
				return _eventDefinitions != null && !_eventDefinitions.isEmpty();
			case BPMNProfilePackage.BPMN_EVENT__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case BPMNProfilePackage.BPMN_EVENT__EVENT_DEFINITION_REFS:
				return eventDefinitionRefs != null && !eventDefinitionRefs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BPMNEventImpl
