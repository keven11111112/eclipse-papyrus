/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement;
import org.eclipse.papyrus.bpmn.BPMNProfile.Documentation;
import org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeValue;
import org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionDefinition;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BaseElementImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BaseElementImpl#getExtensionValues <em>Extension Values</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BaseElementImpl#getBase_Element <em>Base Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BaseElementImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BaseElementImpl#getExtensionDefinitions <em>Extension Definitions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BaseElementImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BaseElementImpl#getIncoming <em>Incoming</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BaseElementImpl2 extends MinimalEObjectImpl.Container implements BaseElement {
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
	 * The cached value of the '{@link #getExtensionValues() <em>Extension Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionValues()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtensionAttributeValue> extensionValues;

	/**
	 * The cached value of the '{@link #getBase_Element() <em>Base Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Element()
	 * @generated
	 * @ordered
	 */
	protected Element base_Element;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BaseElementImpl2() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getBaseElement();
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
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BASE_ELEMENT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExtensionAttributeValue> getExtensionValues() {
		if (extensionValues == null) {
			extensionValues = new EObjectResolvingEList<ExtensionAttributeValue>(ExtensionAttributeValue.class, this, BPMNProfilePackage.BASE_ELEMENT__EXTENSION_VALUES);
		}
		return extensionValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getBase_Element() {
		if (base_Element != null && base_Element.eIsProxy()) {
			InternalEObject oldBase_Element = (InternalEObject)base_Element;
			base_Element = (Element)eResolveProxy(oldBase_Element);
			if (base_Element != oldBase_Element) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.BASE_ELEMENT__BASE_ELEMENT, oldBase_Element, base_Element));
			}
		}
		return base_Element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetBase_Element() {
		return base_Element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Element(Element newBase_Element) {
		Element oldBase_Element = base_Element;
		base_Element = newBase_Element;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BASE_ELEMENT__BASE_ELEMENT, oldBase_Element, base_Element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Documentation> getDocumentation() {
		// TODO: implement this method to return the 'Documentation' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExtensionDefinition> getExtensionDefinitions() {
		// TODO: implement this method to return the 'Extension Definitions' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNAssociation getOutgoing() {
		BPMNAssociation outgoing = basicGetOutgoing();
		return outgoing != null && outgoing.eIsProxy() ? (BPMNAssociation)eResolveProxy((InternalEObject)outgoing) : outgoing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public BPMNAssociation basicGetOutgoing() {
		// TODO: implement this method to return the 'Outgoing' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		//throw new UnsupportedOperationException();
		NamedElement ne = (NamedElement)base_Element;
		for (Dependency dependency : ne.getClientDependencies()) {
			EList<EObject> stereotypeApplications = dependency.getStereotypeApplications();
			for (EObject eObject : stereotypeApplications) {
				if(eObject instanceof BPMNAssociation){
					return (BPMNAssociation) eObject;
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutgoing(BPMNAssociation newOutgoing) {
		// TODO: implement this method to set the 'Outgoing' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNAssociation getIncoming() {
		BPMNAssociation incoming = basicGetIncoming();
		return incoming != null && incoming.eIsProxy() ? (BPMNAssociation)eResolveProxy((InternalEObject)incoming) : incoming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNAssociation basicGetIncoming() {
		// TODO: implement this method to return the 'Incoming' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		NamedElement ne = (NamedElement)base_Element;
		for (DirectedRelationship dependency : ne.getTargetDirectedRelationships()) {
			EList<EObject> stereotypeApplications = dependency.getStereotypeApplications();
			for (EObject eObject : stereotypeApplications) {
				if(eObject instanceof BPMNAssociation){
					return (BPMNAssociation) eObject;
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncoming(BPMNAssociation newIncoming) {
		// TODO: implement this method to set the 'Incoming' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.BASE_ELEMENT__ID:
				return getId();
			case BPMNProfilePackage.BASE_ELEMENT__EXTENSION_VALUES:
				return getExtensionValues();
			case BPMNProfilePackage.BASE_ELEMENT__BASE_ELEMENT:
				if (resolve) return getBase_Element();
				return basicGetBase_Element();
			case BPMNProfilePackage.BASE_ELEMENT__DOCUMENTATION:
				return getDocumentation();
			case BPMNProfilePackage.BASE_ELEMENT__EXTENSION_DEFINITIONS:
				return getExtensionDefinitions();
			case BPMNProfilePackage.BASE_ELEMENT__OUTGOING:
				if (resolve) return getOutgoing();
				return basicGetOutgoing();
			case BPMNProfilePackage.BASE_ELEMENT__INCOMING:
				if (resolve) return getIncoming();
				return basicGetIncoming();
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
			case BPMNProfilePackage.BASE_ELEMENT__ID:
				setId((String)newValue);
				return;
			case BPMNProfilePackage.BASE_ELEMENT__EXTENSION_VALUES:
				getExtensionValues().clear();
				getExtensionValues().addAll((Collection<? extends ExtensionAttributeValue>)newValue);
				return;
			case BPMNProfilePackage.BASE_ELEMENT__BASE_ELEMENT:
				setBase_Element((Element)newValue);
				return;
			case BPMNProfilePackage.BASE_ELEMENT__DOCUMENTATION:
				getDocumentation().clear();
				getDocumentation().addAll((Collection<? extends Documentation>)newValue);
				return;
			case BPMNProfilePackage.BASE_ELEMENT__EXTENSION_DEFINITIONS:
				getExtensionDefinitions().clear();
				getExtensionDefinitions().addAll((Collection<? extends ExtensionDefinition>)newValue);
				return;
			case BPMNProfilePackage.BASE_ELEMENT__OUTGOING:
				setOutgoing((BPMNAssociation)newValue);
				return;
			case BPMNProfilePackage.BASE_ELEMENT__INCOMING:
				setIncoming((BPMNAssociation)newValue);
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
			case BPMNProfilePackage.BASE_ELEMENT__ID:
				setId(ID_EDEFAULT);
				return;
			case BPMNProfilePackage.BASE_ELEMENT__EXTENSION_VALUES:
				getExtensionValues().clear();
				return;
			case BPMNProfilePackage.BASE_ELEMENT__BASE_ELEMENT:
				setBase_Element((Element)null);
				return;
			case BPMNProfilePackage.BASE_ELEMENT__DOCUMENTATION:
				getDocumentation().clear();
				return;
			case BPMNProfilePackage.BASE_ELEMENT__EXTENSION_DEFINITIONS:
				getExtensionDefinitions().clear();
				return;
			case BPMNProfilePackage.BASE_ELEMENT__OUTGOING:
				setOutgoing((BPMNAssociation)null);
				return;
			case BPMNProfilePackage.BASE_ELEMENT__INCOMING:
				setIncoming((BPMNAssociation)null);
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
			case BPMNProfilePackage.BASE_ELEMENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case BPMNProfilePackage.BASE_ELEMENT__EXTENSION_VALUES:
				return extensionValues != null && !extensionValues.isEmpty();
			case BPMNProfilePackage.BASE_ELEMENT__BASE_ELEMENT:
				return base_Element != null;
			case BPMNProfilePackage.BASE_ELEMENT__DOCUMENTATION:
				return !getDocumentation().isEmpty();
			case BPMNProfilePackage.BASE_ELEMENT__EXTENSION_DEFINITIONS:
				return !getExtensionDefinitions().isEmpty();
			case BPMNProfilePackage.BASE_ELEMENT__OUTGOING:
				return basicGetOutgoing() != null;
			case BPMNProfilePackage.BASE_ELEMENT__INCOMING:
				return basicGetIncoming() != null;
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
		result.append(" (id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //BaseElementImpl
