/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionDefinition;
import org.eclipse.uml2.uml.Stereotype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ExtensionDefinitionImpl#getBase_Stereotype <em>Base Stereotype</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ExtensionDefinitionImpl#getExtensionAttributeDefinitions <em>Extension Attribute Definitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExtensionDefinitionImpl extends MinimalEObjectImpl.Container implements ExtensionDefinition {
	/**
	 * The cached value of the '{@link #getBase_Stereotype() <em>Base Stereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Stereotype()
	 * @generated
	 * @ordered
	 */
	protected Stereotype base_Stereotype;

	/**
	 * The cached value of the '{@link #getExtensionAttributeDefinitions() <em>Extension Attribute Definitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionAttributeDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtensionAttributeDefinition> extensionAttributeDefinitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getExtensionDefinition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stereotype getBase_Stereotype() {
		if (base_Stereotype != null && base_Stereotype.eIsProxy()) {
			InternalEObject oldBase_Stereotype = (InternalEObject)base_Stereotype;
			base_Stereotype = (Stereotype)eResolveProxy(oldBase_Stereotype);
			if (base_Stereotype != oldBase_Stereotype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.EXTENSION_DEFINITION__BASE_STEREOTYPE, oldBase_Stereotype, base_Stereotype));
			}
		}
		return base_Stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stereotype basicGetBase_Stereotype() {
		return base_Stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Stereotype(Stereotype newBase_Stereotype) {
		Stereotype oldBase_Stereotype = base_Stereotype;
		base_Stereotype = newBase_Stereotype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.EXTENSION_DEFINITION__BASE_STEREOTYPE, oldBase_Stereotype, base_Stereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExtensionAttributeDefinition> getExtensionAttributeDefinitions() {
		if (extensionAttributeDefinitions == null) {
			extensionAttributeDefinitions = new EObjectResolvingEList<ExtensionAttributeDefinition>(ExtensionAttributeDefinition.class, this, BPMNProfilePackage.EXTENSION_DEFINITION__EXTENSION_ATTRIBUTE_DEFINITIONS);
		}
		return extensionAttributeDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.EXTENSION_DEFINITION__BASE_STEREOTYPE:
				if (resolve) return getBase_Stereotype();
				return basicGetBase_Stereotype();
			case BPMNProfilePackage.EXTENSION_DEFINITION__EXTENSION_ATTRIBUTE_DEFINITIONS:
				return getExtensionAttributeDefinitions();
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
			case BPMNProfilePackage.EXTENSION_DEFINITION__BASE_STEREOTYPE:
				setBase_Stereotype((Stereotype)newValue);
				return;
			case BPMNProfilePackage.EXTENSION_DEFINITION__EXTENSION_ATTRIBUTE_DEFINITIONS:
				getExtensionAttributeDefinitions().clear();
				getExtensionAttributeDefinitions().addAll((Collection<? extends ExtensionAttributeDefinition>)newValue);
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
			case BPMNProfilePackage.EXTENSION_DEFINITION__BASE_STEREOTYPE:
				setBase_Stereotype((Stereotype)null);
				return;
			case BPMNProfilePackage.EXTENSION_DEFINITION__EXTENSION_ATTRIBUTE_DEFINITIONS:
				getExtensionAttributeDefinitions().clear();
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
			case BPMNProfilePackage.EXTENSION_DEFINITION__BASE_STEREOTYPE:
				return base_Stereotype != null;
			case BPMNProfilePackage.EXTENSION_DEFINITION__EXTENSION_ATTRIBUTE_DEFINITIONS:
				return extensionAttributeDefinitions != null && !extensionAttributeDefinitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExtensionDefinitionImpl
