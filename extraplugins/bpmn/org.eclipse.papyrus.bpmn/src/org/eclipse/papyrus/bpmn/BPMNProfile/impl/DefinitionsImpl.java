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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExtension;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNRelationship;
import org.eclipse.papyrus.bpmn.BPMNProfile.Definitions;
import org.eclipse.papyrus.bpmn.BPMNProfile.Import;
import org.eclipse.papyrus.bpmn.BPMNProfile.RootElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Definitions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DefinitionsImpl#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DefinitionsImpl#getTargetNamespace <em>Target Namespace</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DefinitionsImpl#getExpressionLanguage <em>Expression Language</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DefinitionsImpl#getTypeLanguage <em>Type Language</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DefinitionsImpl#getExporter <em>Exporter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DefinitionsImpl#getExporterVersion <em>Exporter Version</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DefinitionsImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DefinitionsImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DefinitionsImpl#getRelationships <em>Relationships</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DefinitionsImpl#getRootElements <em>Root Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DefinitionsImpl extends BaseElementImpl implements Definitions {
	/**
	 * The cached value of the '{@link #getBase_Package() <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Package()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Package base_Package;

	/**
	 * The default value of the '{@link #getTargetNamespace() <em>Target Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetNamespace() <em>Target Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetNamespace()
	 * @generated
	 * @ordered
	 */
	protected String targetNamespace = TARGET_NAMESPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpressionLanguage() <em>Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpressionLanguage() <em>Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected String expressionLanguage = EXPRESSION_LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypeLanguage() <em>Type Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeLanguage() <em>Type Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeLanguage()
	 * @generated
	 * @ordered
	 */
	protected String typeLanguage = TYPE_LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExporter() <em>Exporter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExporter()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPORTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExporter() <em>Exporter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExporter()
	 * @generated
	 * @ordered
	 */
	protected String exporter = EXPORTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getExporterVersion() <em>Exporter Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExporterVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPORTER_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExporterVersion() <em>Exporter Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExporterVersion()
	 * @generated
	 * @ordered
	 */
	protected String exporterVersion = EXPORTER_VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExtensions() <em>Extensions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<BPMNExtension> extensions;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<Import> imports;

	/**
	 * The cached value of the '{@link #getRelationships() <em>Relationships</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelationships()
	 * @generated
	 * @ordered
	 */
	protected EList<BPMNRelationship> relationships;

	/**
	 * The cached value of the '{@link #getRootElements() <em>Root Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootElements()
	 * @generated
	 * @ordered
	 */
	protected EList<RootElement> rootElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefinitionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getDefinitions();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package getBase_Package() {
		if (base_Package != null && base_Package.eIsProxy()) {
			InternalEObject oldBase_Package = (InternalEObject)base_Package;
			base_Package = (org.eclipse.uml2.uml.Package)eResolveProxy(oldBase_Package);
			if (base_Package != oldBase_Package) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.DEFINITIONS__BASE_PACKAGE, oldBase_Package, base_Package));
			}
		}
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package basicGetBase_Package() {
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Package(org.eclipse.uml2.uml.Package newBase_Package) {
		org.eclipse.uml2.uml.Package oldBase_Package = base_Package;
		base_Package = newBase_Package;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DEFINITIONS__BASE_PACKAGE, oldBase_Package, base_Package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetNamespace() {
		return targetNamespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetNamespace(String newTargetNamespace) {
		String oldTargetNamespace = targetNamespace;
		targetNamespace = newTargetNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DEFINITIONS__TARGET_NAMESPACE, oldTargetNamespace, targetNamespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpressionLanguage() {
		return expressionLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpressionLanguage(String newExpressionLanguage) {
		String oldExpressionLanguage = expressionLanguage;
		expressionLanguage = newExpressionLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DEFINITIONS__EXPRESSION_LANGUAGE, oldExpressionLanguage, expressionLanguage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypeLanguage() {
		return typeLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeLanguage(String newTypeLanguage) {
		String oldTypeLanguage = typeLanguage;
		typeLanguage = newTypeLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DEFINITIONS__TYPE_LANGUAGE, oldTypeLanguage, typeLanguage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExporter() {
		return exporter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExporter(String newExporter) {
		String oldExporter = exporter;
		exporter = newExporter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DEFINITIONS__EXPORTER, oldExporter, exporter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExporterVersion() {
		return exporterVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExporterVersion(String newExporterVersion) {
		String oldExporterVersion = exporterVersion;
		exporterVersion = newExporterVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DEFINITIONS__EXPORTER_VERSION, oldExporterVersion, exporterVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BPMNExtension> getExtensions() {
		if (extensions == null) {
			extensions = new EObjectResolvingEList<BPMNExtension>(BPMNExtension.class, this, BPMNProfilePackage.DEFINITIONS__EXTENSIONS);
		}
		return extensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Import> getImports() {
		if (imports == null) {
			imports = new EObjectResolvingEList<Import>(Import.class, this, BPMNProfilePackage.DEFINITIONS__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BPMNRelationship> getRelationships() {
		if (relationships == null) {
			relationships = new EObjectResolvingEList<BPMNRelationship>(BPMNRelationship.class, this, BPMNProfilePackage.DEFINITIONS__RELATIONSHIPS);
		}
		return relationships;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RootElement> getRootElements() {
		if (rootElements == null) {
			rootElements = new EObjectWithInverseResolvingEList<RootElement>(RootElement.class, this, BPMNProfilePackage.DEFINITIONS__ROOT_ELEMENTS, BPMNProfilePackage.ROOT_ELEMENT__DEFINITION);
		}
		return rootElements;
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
			case BPMNProfilePackage.DEFINITIONS__ROOT_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRootElements()).basicAdd(otherEnd, msgs);
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
			case BPMNProfilePackage.DEFINITIONS__ROOT_ELEMENTS:
				return ((InternalEList<?>)getRootElements()).basicRemove(otherEnd, msgs);
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
			case BPMNProfilePackage.DEFINITIONS__BASE_PACKAGE:
				if (resolve) return getBase_Package();
				return basicGetBase_Package();
			case BPMNProfilePackage.DEFINITIONS__TARGET_NAMESPACE:
				return getTargetNamespace();
			case BPMNProfilePackage.DEFINITIONS__EXPRESSION_LANGUAGE:
				return getExpressionLanguage();
			case BPMNProfilePackage.DEFINITIONS__TYPE_LANGUAGE:
				return getTypeLanguage();
			case BPMNProfilePackage.DEFINITIONS__EXPORTER:
				return getExporter();
			case BPMNProfilePackage.DEFINITIONS__EXPORTER_VERSION:
				return getExporterVersion();
			case BPMNProfilePackage.DEFINITIONS__EXTENSIONS:
				return getExtensions();
			case BPMNProfilePackage.DEFINITIONS__IMPORTS:
				return getImports();
			case BPMNProfilePackage.DEFINITIONS__RELATIONSHIPS:
				return getRelationships();
			case BPMNProfilePackage.DEFINITIONS__ROOT_ELEMENTS:
				return getRootElements();
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
			case BPMNProfilePackage.DEFINITIONS__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)newValue);
				return;
			case BPMNProfilePackage.DEFINITIONS__TARGET_NAMESPACE:
				setTargetNamespace((String)newValue);
				return;
			case BPMNProfilePackage.DEFINITIONS__EXPRESSION_LANGUAGE:
				setExpressionLanguage((String)newValue);
				return;
			case BPMNProfilePackage.DEFINITIONS__TYPE_LANGUAGE:
				setTypeLanguage((String)newValue);
				return;
			case BPMNProfilePackage.DEFINITIONS__EXPORTER:
				setExporter((String)newValue);
				return;
			case BPMNProfilePackage.DEFINITIONS__EXPORTER_VERSION:
				setExporterVersion((String)newValue);
				return;
			case BPMNProfilePackage.DEFINITIONS__EXTENSIONS:
				getExtensions().clear();
				getExtensions().addAll((Collection<? extends BPMNExtension>)newValue);
				return;
			case BPMNProfilePackage.DEFINITIONS__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends Import>)newValue);
				return;
			case BPMNProfilePackage.DEFINITIONS__RELATIONSHIPS:
				getRelationships().clear();
				getRelationships().addAll((Collection<? extends BPMNRelationship>)newValue);
				return;
			case BPMNProfilePackage.DEFINITIONS__ROOT_ELEMENTS:
				getRootElements().clear();
				getRootElements().addAll((Collection<? extends RootElement>)newValue);
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
			case BPMNProfilePackage.DEFINITIONS__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)null);
				return;
			case BPMNProfilePackage.DEFINITIONS__TARGET_NAMESPACE:
				setTargetNamespace(TARGET_NAMESPACE_EDEFAULT);
				return;
			case BPMNProfilePackage.DEFINITIONS__EXPRESSION_LANGUAGE:
				setExpressionLanguage(EXPRESSION_LANGUAGE_EDEFAULT);
				return;
			case BPMNProfilePackage.DEFINITIONS__TYPE_LANGUAGE:
				setTypeLanguage(TYPE_LANGUAGE_EDEFAULT);
				return;
			case BPMNProfilePackage.DEFINITIONS__EXPORTER:
				setExporter(EXPORTER_EDEFAULT);
				return;
			case BPMNProfilePackage.DEFINITIONS__EXPORTER_VERSION:
				setExporterVersion(EXPORTER_VERSION_EDEFAULT);
				return;
			case BPMNProfilePackage.DEFINITIONS__EXTENSIONS:
				getExtensions().clear();
				return;
			case BPMNProfilePackage.DEFINITIONS__IMPORTS:
				getImports().clear();
				return;
			case BPMNProfilePackage.DEFINITIONS__RELATIONSHIPS:
				getRelationships().clear();
				return;
			case BPMNProfilePackage.DEFINITIONS__ROOT_ELEMENTS:
				getRootElements().clear();
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
			case BPMNProfilePackage.DEFINITIONS__BASE_PACKAGE:
				return base_Package != null;
			case BPMNProfilePackage.DEFINITIONS__TARGET_NAMESPACE:
				return TARGET_NAMESPACE_EDEFAULT == null ? targetNamespace != null : !TARGET_NAMESPACE_EDEFAULT.equals(targetNamespace);
			case BPMNProfilePackage.DEFINITIONS__EXPRESSION_LANGUAGE:
				return EXPRESSION_LANGUAGE_EDEFAULT == null ? expressionLanguage != null : !EXPRESSION_LANGUAGE_EDEFAULT.equals(expressionLanguage);
			case BPMNProfilePackage.DEFINITIONS__TYPE_LANGUAGE:
				return TYPE_LANGUAGE_EDEFAULT == null ? typeLanguage != null : !TYPE_LANGUAGE_EDEFAULT.equals(typeLanguage);
			case BPMNProfilePackage.DEFINITIONS__EXPORTER:
				return EXPORTER_EDEFAULT == null ? exporter != null : !EXPORTER_EDEFAULT.equals(exporter);
			case BPMNProfilePackage.DEFINITIONS__EXPORTER_VERSION:
				return EXPORTER_VERSION_EDEFAULT == null ? exporterVersion != null : !EXPORTER_VERSION_EDEFAULT.equals(exporterVersion);
			case BPMNProfilePackage.DEFINITIONS__EXTENSIONS:
				return extensions != null && !extensions.isEmpty();
			case BPMNProfilePackage.DEFINITIONS__IMPORTS:
				return imports != null && !imports.isEmpty();
			case BPMNProfilePackage.DEFINITIONS__RELATIONSHIPS:
				return relationships != null && !relationships.isEmpty();
			case BPMNProfilePackage.DEFINITIONS__ROOT_ELEMENTS:
				return rootElements != null && !rootElements.isEmpty();
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
		result.append(" (targetNamespace: ");
		result.append(targetNamespace);
		result.append(", expressionLanguage: ");
		result.append(expressionLanguage);
		result.append(", typeLanguage: ");
		result.append(typeLanguage);
		result.append(", exporter: ");
		result.append(exporter);
		result.append(", exporterVersion: ");
		result.append(exporterVersion);
		result.append(')');
		return result.toString();
	}

} //DefinitionsImpl
