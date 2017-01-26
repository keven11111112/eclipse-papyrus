/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.bpmn.BPMNProfile.Auditing;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.CategoryValue;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowElementsContainer;
import org.eclipse.papyrus.bpmn.BPMNProfile.Monitoring;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.FlowElementImpl#getAuditing <em>Auditing</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.FlowElementImpl#getMonitoring <em>Monitoring</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.FlowElementImpl#get_categoryValueRef <em>category Value Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.FlowElementImpl#getContainer <em>Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FlowElementImpl extends BaseElementImpl implements FlowElement {
	/**
	 * The cached value of the '{@link #getAuditing() <em>Auditing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuditing()
	 * @generated
	 * @ordered
	 */
	protected Auditing auditing;

	/**
	 * The cached value of the '{@link #getMonitoring() <em>Monitoring</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonitoring()
	 * @generated
	 * @ordered
	 */
	protected Monitoring monitoring;

	/**
	 * The cached value of the '{@link #get_categoryValueRef() <em>category Value Ref</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #get_categoryValueRef()
	 * @generated
	 * @ordered
	 */
	protected EList<CategoryValue> _categoryValueRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getFlowElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Auditing getAuditing() {
		if (auditing != null && auditing.eIsProxy()) {
			InternalEObject oldAuditing = (InternalEObject)auditing;
			auditing = (Auditing)eResolveProxy(oldAuditing);
			if (auditing != oldAuditing) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.FLOW_ELEMENT__AUDITING, oldAuditing, auditing));
			}
		}
		return auditing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Auditing basicGetAuditing() {
		return auditing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuditing(Auditing newAuditing) {
		Auditing oldAuditing = auditing;
		auditing = newAuditing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.FLOW_ELEMENT__AUDITING, oldAuditing, auditing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Monitoring getMonitoring() {
		if (monitoring != null && monitoring.eIsProxy()) {
			InternalEObject oldMonitoring = (InternalEObject)monitoring;
			monitoring = (Monitoring)eResolveProxy(oldMonitoring);
			if (monitoring != oldMonitoring) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.FLOW_ELEMENT__MONITORING, oldMonitoring, monitoring));
			}
		}
		return monitoring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Monitoring basicGetMonitoring() {
		return monitoring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMonitoring(Monitoring newMonitoring) {
		Monitoring oldMonitoring = monitoring;
		monitoring = newMonitoring;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.FLOW_ELEMENT__MONITORING, oldMonitoring, monitoring));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CategoryValue> get_categoryValueRef() {
		if (_categoryValueRef == null) {
			_categoryValueRef = new EObjectWithInverseResolvingEList.ManyInverse<CategoryValue>(CategoryValue.class, this, BPMNProfilePackage.FLOW_ELEMENT__CATEGORY_VALUE_REF, BPMNProfilePackage.CATEGORY_VALUE__CATEGORIZED_FLOW_ELEMENTS);
		}
		return _categoryValueRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowElementsContainer getContainer() {
		FlowElementsContainer container = basicGetContainer();
		return container != null && container.eIsProxy() ? (FlowElementsContainer)eResolveProxy((InternalEObject)container) : container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FlowElementsContainer basicGetContainer() {
		return FlowElementCustom.basicGetContainer(this);
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
			case BPMNProfilePackage.FLOW_ELEMENT__CATEGORY_VALUE_REF:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)get_categoryValueRef()).basicAdd(otherEnd, msgs);
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
			case BPMNProfilePackage.FLOW_ELEMENT__CATEGORY_VALUE_REF:
				return ((InternalEList<?>)get_categoryValueRef()).basicRemove(otherEnd, msgs);
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
			case BPMNProfilePackage.FLOW_ELEMENT__AUDITING:
				if (resolve) return getAuditing();
				return basicGetAuditing();
			case BPMNProfilePackage.FLOW_ELEMENT__MONITORING:
				if (resolve) return getMonitoring();
				return basicGetMonitoring();
			case BPMNProfilePackage.FLOW_ELEMENT__CATEGORY_VALUE_REF:
				return get_categoryValueRef();
			case BPMNProfilePackage.FLOW_ELEMENT__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
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
			case BPMNProfilePackage.FLOW_ELEMENT__AUDITING:
				setAuditing((Auditing)newValue);
				return;
			case BPMNProfilePackage.FLOW_ELEMENT__MONITORING:
				setMonitoring((Monitoring)newValue);
				return;
			case BPMNProfilePackage.FLOW_ELEMENT__CATEGORY_VALUE_REF:
				get_categoryValueRef().clear();
				get_categoryValueRef().addAll((Collection<? extends CategoryValue>)newValue);
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
			case BPMNProfilePackage.FLOW_ELEMENT__AUDITING:
				setAuditing((Auditing)null);
				return;
			case BPMNProfilePackage.FLOW_ELEMENT__MONITORING:
				setMonitoring((Monitoring)null);
				return;
			case BPMNProfilePackage.FLOW_ELEMENT__CATEGORY_VALUE_REF:
				get_categoryValueRef().clear();
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
			case BPMNProfilePackage.FLOW_ELEMENT__AUDITING:
				return auditing != null;
			case BPMNProfilePackage.FLOW_ELEMENT__MONITORING:
				return monitoring != null;
			case BPMNProfilePackage.FLOW_ELEMENT__CATEGORY_VALUE_REF:
				return _categoryValueRef != null && !_categoryValueRef.isEmpty();
			case BPMNProfilePackage.FLOW_ELEMENT__CONTAINER:
				return basicGetContainer() != null;
		}
		return super.eIsSet(featureID);
	}

} //FlowElementImpl
