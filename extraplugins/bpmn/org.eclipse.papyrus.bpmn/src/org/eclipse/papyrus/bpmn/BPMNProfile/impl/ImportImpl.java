/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.Definitions;
import org.eclipse.papyrus.bpmn.BPMNProfile.Import;

import org.eclipse.uml2.uml.PackageImport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ImportImpl#getBase_PackageImport <em>Base Package Import</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ImportImpl#getImportType <em>Import Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ImportImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ImportImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ImportImpl#getDefinitions <em>Definitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImportImpl extends MinimalEObjectImpl.Container implements Import {
	/**
	 * The cached value of the '{@link #getBase_PackageImport() <em>Base Package Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_PackageImport()
	 * @generated
	 * @ordered
	 */
	protected PackageImport base_PackageImport;

	/**
	 * The default value of the '{@link #getImportType() <em>Import Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportType()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPORT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImportType() <em>Import Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportType()
	 * @generated
	 * @ordered
	 */
	protected String importType = IMPORT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected String namespace = NAMESPACE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefinitions() <em>Definitions</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitions()
	 * @generated
	 * @ordered
	 */
	protected Definitions definitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getImport();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageImport getBase_PackageImport() {
		if (base_PackageImport != null && base_PackageImport.eIsProxy()) {
			InternalEObject oldBase_PackageImport = (InternalEObject)base_PackageImport;
			base_PackageImport = (PackageImport)eResolveProxy(oldBase_PackageImport);
			if (base_PackageImport != oldBase_PackageImport) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.IMPORT__BASE_PACKAGE_IMPORT, oldBase_PackageImport, base_PackageImport));
			}
		}
		return base_PackageImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageImport basicGetBase_PackageImport() {
		return base_PackageImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_PackageImport(PackageImport newBase_PackageImport) {
		PackageImport oldBase_PackageImport = base_PackageImport;
		base_PackageImport = newBase_PackageImport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.IMPORT__BASE_PACKAGE_IMPORT, oldBase_PackageImport, base_PackageImport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImportType() {
		return importType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportType(String newImportType) {
		String oldImportType = importType;
		importType = newImportType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.IMPORT__IMPORT_TYPE, oldImportType, importType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.IMPORT__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespace(String newNamespace) {
		String oldNamespace = namespace;
		namespace = newNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.IMPORT__NAMESPACE, oldNamespace, namespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Definitions getDefinitions() {
		if (definitions != null && definitions.eIsProxy()) {
			InternalEObject oldDefinitions = (InternalEObject)definitions;
			definitions = (Definitions)eResolveProxy(oldDefinitions);
			if (definitions != oldDefinitions) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.IMPORT__DEFINITIONS, oldDefinitions, definitions));
			}
		}
		return definitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Definitions basicGetDefinitions() {
		return definitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinitions(Definitions newDefinitions) {
		Definitions oldDefinitions = definitions;
		definitions = newDefinitions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.IMPORT__DEFINITIONS, oldDefinitions, definitions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.IMPORT__BASE_PACKAGE_IMPORT:
				if (resolve) return getBase_PackageImport();
				return basicGetBase_PackageImport();
			case BPMNProfilePackage.IMPORT__IMPORT_TYPE:
				return getImportType();
			case BPMNProfilePackage.IMPORT__LOCATION:
				return getLocation();
			case BPMNProfilePackage.IMPORT__NAMESPACE:
				return getNamespace();
			case BPMNProfilePackage.IMPORT__DEFINITIONS:
				if (resolve) return getDefinitions();
				return basicGetDefinitions();
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
			case BPMNProfilePackage.IMPORT__BASE_PACKAGE_IMPORT:
				setBase_PackageImport((PackageImport)newValue);
				return;
			case BPMNProfilePackage.IMPORT__IMPORT_TYPE:
				setImportType((String)newValue);
				return;
			case BPMNProfilePackage.IMPORT__LOCATION:
				setLocation((String)newValue);
				return;
			case BPMNProfilePackage.IMPORT__NAMESPACE:
				setNamespace((String)newValue);
				return;
			case BPMNProfilePackage.IMPORT__DEFINITIONS:
				setDefinitions((Definitions)newValue);
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
			case BPMNProfilePackage.IMPORT__BASE_PACKAGE_IMPORT:
				setBase_PackageImport((PackageImport)null);
				return;
			case BPMNProfilePackage.IMPORT__IMPORT_TYPE:
				setImportType(IMPORT_TYPE_EDEFAULT);
				return;
			case BPMNProfilePackage.IMPORT__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case BPMNProfilePackage.IMPORT__NAMESPACE:
				setNamespace(NAMESPACE_EDEFAULT);
				return;
			case BPMNProfilePackage.IMPORT__DEFINITIONS:
				setDefinitions((Definitions)null);
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
			case BPMNProfilePackage.IMPORT__BASE_PACKAGE_IMPORT:
				return base_PackageImport != null;
			case BPMNProfilePackage.IMPORT__IMPORT_TYPE:
				return IMPORT_TYPE_EDEFAULT == null ? importType != null : !IMPORT_TYPE_EDEFAULT.equals(importType);
			case BPMNProfilePackage.IMPORT__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case BPMNProfilePackage.IMPORT__NAMESPACE:
				return NAMESPACE_EDEFAULT == null ? namespace != null : !NAMESPACE_EDEFAULT.equals(namespace);
			case BPMNProfilePackage.IMPORT__DEFINITIONS:
				return definitions != null;
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
		result.append(" (importType: ");
		result.append(importType);
		result.append(", location: ");
		result.append(location);
		result.append(", namespace: ");
		result.append(namespace);
		result.append(')');
		return result.toString();
	}

} //ImportImpl
