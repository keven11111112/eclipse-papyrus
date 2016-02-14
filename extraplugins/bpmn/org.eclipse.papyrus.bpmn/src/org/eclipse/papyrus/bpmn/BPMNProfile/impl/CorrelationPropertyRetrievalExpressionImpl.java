/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNMessage;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyRetrievalExpression;
import org.eclipse.papyrus.bpmn.BPMNProfile.FormalExpression;
import org.eclipse.uml2.uml.Dependency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Correlation Property Retrieval Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CorrelationPropertyRetrievalExpressionImpl#getBase_Dependency <em>Base Dependency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CorrelationPropertyRetrievalExpressionImpl#getMessageRef <em>Message Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CorrelationPropertyRetrievalExpressionImpl#getMessagePath <em>Message Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CorrelationPropertyRetrievalExpressionImpl extends BaseElementImpl implements CorrelationPropertyRetrievalExpression {
	/**
	 * The cached value of the '{@link #getBase_Dependency() <em>Base Dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Dependency()
	 * @generated
	 * @ordered
	 */
	protected Dependency base_Dependency;

	/**
	 * The cached value of the '{@link #getMessageRef() <em>Message Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageRef()
	 * @generated
	 * @ordered
	 */
	protected BPMNMessage messageRef;
	/**
	 * The cached value of the '{@link #getMessagePath() <em>Message Path</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessagePath()
	 * @generated
	 * @ordered
	 */
	protected FormalExpression messagePath;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CorrelationPropertyRetrievalExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getCorrelationPropertyRetrievalExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency getBase_Dependency() {
		if (base_Dependency != null && base_Dependency.eIsProxy()) {
			InternalEObject oldBase_Dependency = (InternalEObject)base_Dependency;
			base_Dependency = (Dependency)eResolveProxy(oldBase_Dependency);
			if (base_Dependency != oldBase_Dependency) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__BASE_DEPENDENCY, oldBase_Dependency, base_Dependency));
			}
		}
		return base_Dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency basicGetBase_Dependency() {
		return base_Dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Dependency(Dependency newBase_Dependency) {
		Dependency oldBase_Dependency = base_Dependency;
		base_Dependency = newBase_Dependency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__BASE_DEPENDENCY, oldBase_Dependency, base_Dependency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNMessage getMessageRef() {
		if (messageRef != null && messageRef.eIsProxy()) {
			InternalEObject oldMessageRef = (InternalEObject)messageRef;
			messageRef = (BPMNMessage)eResolveProxy(oldMessageRef);
			if (messageRef != oldMessageRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_REF, oldMessageRef, messageRef));
			}
		}
		return messageRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNMessage basicGetMessageRef() {
		return messageRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessageRef(BPMNMessage newMessageRef) {
		BPMNMessage oldMessageRef = messageRef;
		messageRef = newMessageRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_REF, oldMessageRef, messageRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalExpression getMessagePath() {
		if (messagePath != null && messagePath.eIsProxy()) {
			InternalEObject oldMessagePath = (InternalEObject)messagePath;
			messagePath = (FormalExpression)eResolveProxy(oldMessagePath);
			if (messagePath != oldMessagePath) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_PATH, oldMessagePath, messagePath));
			}
		}
		return messagePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalExpression basicGetMessagePath() {
		return messagePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessagePath(FormalExpression newMessagePath) {
		FormalExpression oldMessagePath = messagePath;
		messagePath = newMessagePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_PATH, oldMessagePath, messagePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__BASE_DEPENDENCY:
				if (resolve) return getBase_Dependency();
				return basicGetBase_Dependency();
			case BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_REF:
				if (resolve) return getMessageRef();
				return basicGetMessageRef();
			case BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_PATH:
				if (resolve) return getMessagePath();
				return basicGetMessagePath();
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
			case BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__BASE_DEPENDENCY:
				setBase_Dependency((Dependency)newValue);
				return;
			case BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_REF:
				setMessageRef((BPMNMessage)newValue);
				return;
			case BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_PATH:
				setMessagePath((FormalExpression)newValue);
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
			case BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__BASE_DEPENDENCY:
				setBase_Dependency((Dependency)null);
				return;
			case BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_REF:
				setMessageRef((BPMNMessage)null);
				return;
			case BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_PATH:
				setMessagePath((FormalExpression)null);
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
			case BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__BASE_DEPENDENCY:
				return base_Dependency != null;
			case BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_REF:
				return messageRef != null;
			case BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_PATH:
				return messagePath != null;
		}
		return super.eIsSet(featureID);
	}

} //CorrelationPropertyRetrievalExpressionImpl
