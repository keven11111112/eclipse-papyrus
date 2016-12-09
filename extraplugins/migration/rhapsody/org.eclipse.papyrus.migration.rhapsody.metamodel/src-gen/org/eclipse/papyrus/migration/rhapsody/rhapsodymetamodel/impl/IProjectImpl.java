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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DeclarativesType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DefaultSubsystemType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICollaborationDiagram;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IComponent;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IComponentDiagram;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDependency;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMHyperLink;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IModelElement;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMultiplicityItem;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPanelDiagram;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IProject;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUCDiagram;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IProject</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProjectImpl#getUserColors <em>User Colors</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProjectImpl#getDefaultSubsystem <em>Default Subsystem</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProjectImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProjectImpl#getMultiplicities <em>Multiplicities</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProjectImpl#getSubsystems <em>Subsystems</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProjectImpl#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProjectImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProjectImpl#getPanelDiagrams <em>Panel Diagrams</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProjectImpl#getHyperLinks <em>Hyper Links</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProjectImpl#getMSCS <em>MSCS</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProjectImpl#getUCDiagrams <em>UC Diagrams</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProjectImpl#getCollaborationDiagrams <em>Collaboration Diagrams</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProjectImpl#getDeclaratives <em>Declaratives</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProjectImpl#getComponentDiagrams <em>Component Diagrams</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProjectImpl#getUnitSccProjName <em>Unit Scc Proj Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProjectImpl#getUnitSccProjPath <em>Unit Scc Proj Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProjectImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProjectImpl#getCodeUpdateCGTime <em>Code Update CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IProjectImpl#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IProjectImpl extends IPackageImpl implements IProject {
	/**
	 * The cached value of the '{@link #getUserColors() <em>User Colors</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserColors()
	 * @generated
	 * @ordered
	 */
	protected EList<String> userColors;

	/**
	 * The cached value of the '{@link #getDefaultSubsystem() <em>Default Subsystem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultSubsystem()
	 * @generated
	 * @ordered
	 */
	protected DefaultSubsystemType defaultSubsystem;

	/**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected IComponent component;

	/**
	 * The cached value of the '{@link #getMultiplicities() <em>Multiplicities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicities()
	 * @generated
	 * @ordered
	 */
	protected EList<IMultiplicityItem> multiplicities;

	/**
	 * The cached value of the '{@link #getSubsystems() <em>Subsystems</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsystems()
	 * @generated
	 * @ordered
	 */
	protected EList<DefaultSubsystemType> subsystems;

	/**
	 * The cached value of the '{@link #getDiagrams() <em>Diagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<IModelElement> diagrams;

	/**
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<IModelElement> components;

	/**
	 * The cached value of the '{@link #getPanelDiagrams() <em>Panel Diagrams</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPanelDiagrams()
	 * @generated
	 * @ordered
	 */
	protected IPanelDiagram panelDiagrams;

	/**
	 * The cached value of the '{@link #getHyperLinks() <em>Hyper Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHyperLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<IMHyperLink> hyperLinks;

	/**
	 * The cached value of the '{@link #getMSCS() <em>MSCS</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMSCS()
	 * @generated
	 * @ordered
	 */
	protected EList<DeclarativesType> mscs;

	/**
	 * The cached value of the '{@link #getUCDiagrams() <em>UC Diagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUCDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<IUCDiagram> ucDiagrams;

	/**
	 * The cached value of the '{@link #getCollaborationDiagrams() <em>Collaboration Diagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollaborationDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<ICollaborationDiagram> collaborationDiagrams;

	/**
	 * The cached value of the '{@link #getDeclaratives() <em>Declaratives</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaratives()
	 * @generated
	 * @ordered
	 */
	protected IStereotype declaratives;

	/**
	 * The cached value of the '{@link #getComponentDiagrams() <em>Component Diagrams</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentDiagrams()
	 * @generated
	 * @ordered
	 */
	protected IComponentDiagram componentDiagrams;

	/**
	 * The default value of the '{@link #getUnitSccProjName() <em>Unit Scc Proj Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitSccProjName()
	 * @generated
	 * @ordered
	 */
	protected static final String UNIT_SCC_PROJ_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnitSccProjName() <em>Unit Scc Proj Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitSccProjName()
	 * @generated
	 * @ordered
	 */
	protected String unitSccProjName = UNIT_SCC_PROJ_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnitSccProjPath() <em>Unit Scc Proj Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitSccProjPath()
	 * @generated
	 * @ordered
	 */
	protected static final String UNIT_SCC_PROJ_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnitSccProjPath() <em>Unit Scc Proj Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitSccProjPath()
	 * @generated
	 * @ordered
	 */
	protected String unitSccProjPath = UNIT_SCC_PROJ_PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected IDependency dependencies;

	/**
	 * The cached value of the '{@link #getCodeUpdateCGTime() <em>Code Update CG Time</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodeUpdateCGTime()
	 * @generated
	 * @ordered
	 */
	protected EList<String> codeUpdateCGTime;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIProject();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getUserColors() {
		if (userColors == null) {
			userColors = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IPROJECT__USER_COLORS);
		}
		return userColors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultSubsystemType getDefaultSubsystem() {
		if (defaultSubsystem != null && defaultSubsystem.eIsProxy()) {
			InternalEObject oldDefaultSubsystem = (InternalEObject)defaultSubsystem;
			defaultSubsystem = (DefaultSubsystemType)eResolveProxy(oldDefaultSubsystem);
			if (defaultSubsystem != oldDefaultSubsystem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPROJECT__DEFAULT_SUBSYSTEM, oldDefaultSubsystem, defaultSubsystem));
			}
		}
		return defaultSubsystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultSubsystemType basicGetDefaultSubsystem() {
		return defaultSubsystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultSubsystem(DefaultSubsystemType newDefaultSubsystem) {
		DefaultSubsystemType oldDefaultSubsystem = defaultSubsystem;
		defaultSubsystem = newDefaultSubsystem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPROJECT__DEFAULT_SUBSYSTEM, oldDefaultSubsystem, defaultSubsystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IComponent getComponent() {
		if (component != null && component.eIsProxy()) {
			InternalEObject oldComponent = (InternalEObject)component;
			component = (IComponent)eResolveProxy(oldComponent);
			if (component != oldComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPROJECT__COMPONENT, oldComponent, component));
			}
		}
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IComponent basicGetComponent() {
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(IComponent newComponent) {
		IComponent oldComponent = component;
		component = newComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPROJECT__COMPONENT, oldComponent, component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IMultiplicityItem> getMultiplicities() {
		if (multiplicities == null) {
			multiplicities = new EObjectContainmentEList.Resolving<IMultiplicityItem>(IMultiplicityItem.class, this, UMLRhapsodyPackage.IPROJECT__MULTIPLICITIES);
		}
		return multiplicities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DefaultSubsystemType> getSubsystems() {
		if (subsystems == null) {
			subsystems = new EObjectContainmentEList.Resolving<DefaultSubsystemType>(DefaultSubsystemType.class, this, UMLRhapsodyPackage.IPROJECT__SUBSYSTEMS);
		}
		return subsystems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IModelElement> getDiagrams() {
		if (diagrams == null) {
			diagrams = new EObjectContainmentEList.Resolving<IModelElement>(IModelElement.class, this, UMLRhapsodyPackage.IPROJECT__DIAGRAMS);
		}
		return diagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IModelElement> getComponents() {
		if (components == null) {
			components = new EObjectContainmentEList.Resolving<IModelElement>(IModelElement.class, this, UMLRhapsodyPackage.IPROJECT__COMPONENTS);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPanelDiagram getPanelDiagrams() {
		if (panelDiagrams != null && panelDiagrams.eIsProxy()) {
			InternalEObject oldPanelDiagrams = (InternalEObject)panelDiagrams;
			panelDiagrams = (IPanelDiagram)eResolveProxy(oldPanelDiagrams);
			if (panelDiagrams != oldPanelDiagrams) {
				InternalEObject newPanelDiagrams = (InternalEObject)panelDiagrams;
				NotificationChain msgs = oldPanelDiagrams.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROJECT__PANEL_DIAGRAMS, null, null);
				if (newPanelDiagrams.eInternalContainer() == null) {
					msgs = newPanelDiagrams.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROJECT__PANEL_DIAGRAMS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPROJECT__PANEL_DIAGRAMS, oldPanelDiagrams, panelDiagrams));
			}
		}
		return panelDiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPanelDiagram basicGetPanelDiagrams() {
		return panelDiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPanelDiagrams(IPanelDiagram newPanelDiagrams, NotificationChain msgs) {
		IPanelDiagram oldPanelDiagrams = panelDiagrams;
		panelDiagrams = newPanelDiagrams;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPROJECT__PANEL_DIAGRAMS, oldPanelDiagrams, newPanelDiagrams);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPanelDiagrams(IPanelDiagram newPanelDiagrams) {
		if (newPanelDiagrams != panelDiagrams) {
			NotificationChain msgs = null;
			if (panelDiagrams != null)
				msgs = ((InternalEObject)panelDiagrams).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROJECT__PANEL_DIAGRAMS, null, msgs);
			if (newPanelDiagrams != null)
				msgs = ((InternalEObject)newPanelDiagrams).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROJECT__PANEL_DIAGRAMS, null, msgs);
			msgs = basicSetPanelDiagrams(newPanelDiagrams, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPROJECT__PANEL_DIAGRAMS, newPanelDiagrams, newPanelDiagrams));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IMHyperLink> getHyperLinks() {
		if (hyperLinks == null) {
			hyperLinks = new EObjectContainmentEList.Resolving<IMHyperLink>(IMHyperLink.class, this, UMLRhapsodyPackage.IPROJECT__HYPER_LINKS);
		}
		return hyperLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeclarativesType> getMSCS() {
		if (mscs == null) {
			mscs = new EObjectContainmentEList.Resolving<DeclarativesType>(DeclarativesType.class, this, UMLRhapsodyPackage.IPROJECT__MSCS);
		}
		return mscs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IUCDiagram> getUCDiagrams() {
		if (ucDiagrams == null) {
			ucDiagrams = new EObjectContainmentEList.Resolving<IUCDiagram>(IUCDiagram.class, this, UMLRhapsodyPackage.IPROJECT__UC_DIAGRAMS);
		}
		return ucDiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ICollaborationDiagram> getCollaborationDiagrams() {
		if (collaborationDiagrams == null) {
			collaborationDiagrams = new EObjectContainmentEList.Resolving<ICollaborationDiagram>(ICollaborationDiagram.class, this, UMLRhapsodyPackage.IPROJECT__COLLABORATION_DIAGRAMS);
		}
		return collaborationDiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStereotype getDeclaratives() {
		if (declaratives != null && declaratives.eIsProxy()) {
			InternalEObject oldDeclaratives = (InternalEObject)declaratives;
			declaratives = (IStereotype)eResolveProxy(oldDeclaratives);
			if (declaratives != oldDeclaratives) {
				InternalEObject newDeclaratives = (InternalEObject)declaratives;
				NotificationChain msgs = oldDeclaratives.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROJECT__DECLARATIVES, null, null);
				if (newDeclaratives.eInternalContainer() == null) {
					msgs = newDeclaratives.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROJECT__DECLARATIVES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPROJECT__DECLARATIVES, oldDeclaratives, declaratives));
			}
		}
		return declaratives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStereotype basicGetDeclaratives() {
		return declaratives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaratives(IStereotype newDeclaratives, NotificationChain msgs) {
		IStereotype oldDeclaratives = declaratives;
		declaratives = newDeclaratives;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPROJECT__DECLARATIVES, oldDeclaratives, newDeclaratives);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaratives(IStereotype newDeclaratives) {
		if (newDeclaratives != declaratives) {
			NotificationChain msgs = null;
			if (declaratives != null)
				msgs = ((InternalEObject)declaratives).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROJECT__DECLARATIVES, null, msgs);
			if (newDeclaratives != null)
				msgs = ((InternalEObject)newDeclaratives).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROJECT__DECLARATIVES, null, msgs);
			msgs = basicSetDeclaratives(newDeclaratives, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPROJECT__DECLARATIVES, newDeclaratives, newDeclaratives));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IComponentDiagram getComponentDiagrams() {
		if (componentDiagrams != null && componentDiagrams.eIsProxy()) {
			InternalEObject oldComponentDiagrams = (InternalEObject)componentDiagrams;
			componentDiagrams = (IComponentDiagram)eResolveProxy(oldComponentDiagrams);
			if (componentDiagrams != oldComponentDiagrams) {
				InternalEObject newComponentDiagrams = (InternalEObject)componentDiagrams;
				NotificationChain msgs = oldComponentDiagrams.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROJECT__COMPONENT_DIAGRAMS, null, null);
				if (newComponentDiagrams.eInternalContainer() == null) {
					msgs = newComponentDiagrams.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROJECT__COMPONENT_DIAGRAMS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPROJECT__COMPONENT_DIAGRAMS, oldComponentDiagrams, componentDiagrams));
			}
		}
		return componentDiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IComponentDiagram basicGetComponentDiagrams() {
		return componentDiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponentDiagrams(IComponentDiagram newComponentDiagrams, NotificationChain msgs) {
		IComponentDiagram oldComponentDiagrams = componentDiagrams;
		componentDiagrams = newComponentDiagrams;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPROJECT__COMPONENT_DIAGRAMS, oldComponentDiagrams, newComponentDiagrams);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentDiagrams(IComponentDiagram newComponentDiagrams) {
		if (newComponentDiagrams != componentDiagrams) {
			NotificationChain msgs = null;
			if (componentDiagrams != null)
				msgs = ((InternalEObject)componentDiagrams).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROJECT__COMPONENT_DIAGRAMS, null, msgs);
			if (newComponentDiagrams != null)
				msgs = ((InternalEObject)newComponentDiagrams).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROJECT__COMPONENT_DIAGRAMS, null, msgs);
			msgs = basicSetComponentDiagrams(newComponentDiagrams, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPROJECT__COMPONENT_DIAGRAMS, newComponentDiagrams, newComponentDiagrams));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUnitSccProjName() {
		return unitSccProjName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitSccProjName(String newUnitSccProjName) {
		String oldUnitSccProjName = unitSccProjName;
		unitSccProjName = newUnitSccProjName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPROJECT__UNIT_SCC_PROJ_NAME, oldUnitSccProjName, unitSccProjName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUnitSccProjPath() {
		return unitSccProjPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitSccProjPath(String newUnitSccProjPath) {
		String oldUnitSccProjPath = unitSccProjPath;
		unitSccProjPath = newUnitSccProjPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPROJECT__UNIT_SCC_PROJ_PATH, oldUnitSccProjPath, unitSccProjPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDependency getDependencies() {
		if (dependencies != null && dependencies.eIsProxy()) {
			InternalEObject oldDependencies = (InternalEObject)dependencies;
			dependencies = (IDependency)eResolveProxy(oldDependencies);
			if (dependencies != oldDependencies) {
				InternalEObject newDependencies = (InternalEObject)dependencies;
				NotificationChain msgs = oldDependencies.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROJECT__DEPENDENCIES, null, null);
				if (newDependencies.eInternalContainer() == null) {
					msgs = newDependencies.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROJECT__DEPENDENCIES, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IPROJECT__DEPENDENCIES, oldDependencies, dependencies));
			}
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDependency basicGetDependencies() {
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependencies(IDependency newDependencies, NotificationChain msgs) {
		IDependency oldDependencies = dependencies;
		dependencies = newDependencies;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPROJECT__DEPENDENCIES, oldDependencies, newDependencies);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependencies(IDependency newDependencies) {
		if (newDependencies != dependencies) {
			NotificationChain msgs = null;
			if (dependencies != null)
				msgs = ((InternalEObject)dependencies).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROJECT__DEPENDENCIES, null, msgs);
			if (newDependencies != null)
				msgs = ((InternalEObject)newDependencies).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLRhapsodyPackage.IPROJECT__DEPENDENCIES, null, msgs);
			msgs = basicSetDependencies(newDependencies, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPROJECT__DEPENDENCIES, newDependencies, newDependencies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCodeUpdateCGTime() {
		if (codeUpdateCGTime == null) {
			codeUpdateCGTime = new EDataTypeEList<String>(String.class, this, UMLRhapsodyPackage.IPROJECT__CODE_UPDATE_CG_TIME);
		}
		return codeUpdateCGTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IPROJECT__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLRhapsodyPackage.IPROJECT__MULTIPLICITIES:
				return ((InternalEList<?>)getMultiplicities()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IPROJECT__SUBSYSTEMS:
				return ((InternalEList<?>)getSubsystems()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IPROJECT__DIAGRAMS:
				return ((InternalEList<?>)getDiagrams()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IPROJECT__COMPONENTS:
				return ((InternalEList<?>)getComponents()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IPROJECT__PANEL_DIAGRAMS:
				return basicSetPanelDiagrams(null, msgs);
			case UMLRhapsodyPackage.IPROJECT__HYPER_LINKS:
				return ((InternalEList<?>)getHyperLinks()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IPROJECT__MSCS:
				return ((InternalEList<?>)getMSCS()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IPROJECT__UC_DIAGRAMS:
				return ((InternalEList<?>)getUCDiagrams()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IPROJECT__COLLABORATION_DIAGRAMS:
				return ((InternalEList<?>)getCollaborationDiagrams()).basicRemove(otherEnd, msgs);
			case UMLRhapsodyPackage.IPROJECT__DECLARATIVES:
				return basicSetDeclaratives(null, msgs);
			case UMLRhapsodyPackage.IPROJECT__COMPONENT_DIAGRAMS:
				return basicSetComponentDiagrams(null, msgs);
			case UMLRhapsodyPackage.IPROJECT__DEPENDENCIES:
				return basicSetDependencies(null, msgs);
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
			case UMLRhapsodyPackage.IPROJECT__USER_COLORS:
				return getUserColors();
			case UMLRhapsodyPackage.IPROJECT__DEFAULT_SUBSYSTEM:
				if (resolve) return getDefaultSubsystem();
				return basicGetDefaultSubsystem();
			case UMLRhapsodyPackage.IPROJECT__COMPONENT:
				if (resolve) return getComponent();
				return basicGetComponent();
			case UMLRhapsodyPackage.IPROJECT__MULTIPLICITIES:
				return getMultiplicities();
			case UMLRhapsodyPackage.IPROJECT__SUBSYSTEMS:
				return getSubsystems();
			case UMLRhapsodyPackage.IPROJECT__DIAGRAMS:
				return getDiagrams();
			case UMLRhapsodyPackage.IPROJECT__COMPONENTS:
				return getComponents();
			case UMLRhapsodyPackage.IPROJECT__PANEL_DIAGRAMS:
				if (resolve) return getPanelDiagrams();
				return basicGetPanelDiagrams();
			case UMLRhapsodyPackage.IPROJECT__HYPER_LINKS:
				return getHyperLinks();
			case UMLRhapsodyPackage.IPROJECT__MSCS:
				return getMSCS();
			case UMLRhapsodyPackage.IPROJECT__UC_DIAGRAMS:
				return getUCDiagrams();
			case UMLRhapsodyPackage.IPROJECT__COLLABORATION_DIAGRAMS:
				return getCollaborationDiagrams();
			case UMLRhapsodyPackage.IPROJECT__DECLARATIVES:
				if (resolve) return getDeclaratives();
				return basicGetDeclaratives();
			case UMLRhapsodyPackage.IPROJECT__COMPONENT_DIAGRAMS:
				if (resolve) return getComponentDiagrams();
				return basicGetComponentDiagrams();
			case UMLRhapsodyPackage.IPROJECT__UNIT_SCC_PROJ_NAME:
				return getUnitSccProjName();
			case UMLRhapsodyPackage.IPROJECT__UNIT_SCC_PROJ_PATH:
				return getUnitSccProjPath();
			case UMLRhapsodyPackage.IPROJECT__DEPENDENCIES:
				if (resolve) return getDependencies();
				return basicGetDependencies();
			case UMLRhapsodyPackage.IPROJECT__CODE_UPDATE_CG_TIME:
				return getCodeUpdateCGTime();
			case UMLRhapsodyPackage.IPROJECT__VERSION:
				return getVersion();
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
			case UMLRhapsodyPackage.IPROJECT__USER_COLORS:
				getUserColors().clear();
				getUserColors().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IPROJECT__DEFAULT_SUBSYSTEM:
				setDefaultSubsystem((DefaultSubsystemType)newValue);
				return;
			case UMLRhapsodyPackage.IPROJECT__COMPONENT:
				setComponent((IComponent)newValue);
				return;
			case UMLRhapsodyPackage.IPROJECT__MULTIPLICITIES:
				getMultiplicities().clear();
				getMultiplicities().addAll((Collection<? extends IMultiplicityItem>)newValue);
				return;
			case UMLRhapsodyPackage.IPROJECT__SUBSYSTEMS:
				getSubsystems().clear();
				getSubsystems().addAll((Collection<? extends DefaultSubsystemType>)newValue);
				return;
			case UMLRhapsodyPackage.IPROJECT__DIAGRAMS:
				getDiagrams().clear();
				getDiagrams().addAll((Collection<? extends IModelElement>)newValue);
				return;
			case UMLRhapsodyPackage.IPROJECT__COMPONENTS:
				getComponents().clear();
				getComponents().addAll((Collection<? extends IModelElement>)newValue);
				return;
			case UMLRhapsodyPackage.IPROJECT__PANEL_DIAGRAMS:
				setPanelDiagrams((IPanelDiagram)newValue);
				return;
			case UMLRhapsodyPackage.IPROJECT__HYPER_LINKS:
				getHyperLinks().clear();
				getHyperLinks().addAll((Collection<? extends IMHyperLink>)newValue);
				return;
			case UMLRhapsodyPackage.IPROJECT__MSCS:
				getMSCS().clear();
				getMSCS().addAll((Collection<? extends DeclarativesType>)newValue);
				return;
			case UMLRhapsodyPackage.IPROJECT__UC_DIAGRAMS:
				getUCDiagrams().clear();
				getUCDiagrams().addAll((Collection<? extends IUCDiagram>)newValue);
				return;
			case UMLRhapsodyPackage.IPROJECT__COLLABORATION_DIAGRAMS:
				getCollaborationDiagrams().clear();
				getCollaborationDiagrams().addAll((Collection<? extends ICollaborationDiagram>)newValue);
				return;
			case UMLRhapsodyPackage.IPROJECT__DECLARATIVES:
				setDeclaratives((IStereotype)newValue);
				return;
			case UMLRhapsodyPackage.IPROJECT__COMPONENT_DIAGRAMS:
				setComponentDiagrams((IComponentDiagram)newValue);
				return;
			case UMLRhapsodyPackage.IPROJECT__UNIT_SCC_PROJ_NAME:
				setUnitSccProjName((String)newValue);
				return;
			case UMLRhapsodyPackage.IPROJECT__UNIT_SCC_PROJ_PATH:
				setUnitSccProjPath((String)newValue);
				return;
			case UMLRhapsodyPackage.IPROJECT__DEPENDENCIES:
				setDependencies((IDependency)newValue);
				return;
			case UMLRhapsodyPackage.IPROJECT__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				getCodeUpdateCGTime().addAll((Collection<? extends String>)newValue);
				return;
			case UMLRhapsodyPackage.IPROJECT__VERSION:
				setVersion((String)newValue);
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
			case UMLRhapsodyPackage.IPROJECT__USER_COLORS:
				getUserColors().clear();
				return;
			case UMLRhapsodyPackage.IPROJECT__DEFAULT_SUBSYSTEM:
				setDefaultSubsystem((DefaultSubsystemType)null);
				return;
			case UMLRhapsodyPackage.IPROJECT__COMPONENT:
				setComponent((IComponent)null);
				return;
			case UMLRhapsodyPackage.IPROJECT__MULTIPLICITIES:
				getMultiplicities().clear();
				return;
			case UMLRhapsodyPackage.IPROJECT__SUBSYSTEMS:
				getSubsystems().clear();
				return;
			case UMLRhapsodyPackage.IPROJECT__DIAGRAMS:
				getDiagrams().clear();
				return;
			case UMLRhapsodyPackage.IPROJECT__COMPONENTS:
				getComponents().clear();
				return;
			case UMLRhapsodyPackage.IPROJECT__PANEL_DIAGRAMS:
				setPanelDiagrams((IPanelDiagram)null);
				return;
			case UMLRhapsodyPackage.IPROJECT__HYPER_LINKS:
				getHyperLinks().clear();
				return;
			case UMLRhapsodyPackage.IPROJECT__MSCS:
				getMSCS().clear();
				return;
			case UMLRhapsodyPackage.IPROJECT__UC_DIAGRAMS:
				getUCDiagrams().clear();
				return;
			case UMLRhapsodyPackage.IPROJECT__COLLABORATION_DIAGRAMS:
				getCollaborationDiagrams().clear();
				return;
			case UMLRhapsodyPackage.IPROJECT__DECLARATIVES:
				setDeclaratives((IStereotype)null);
				return;
			case UMLRhapsodyPackage.IPROJECT__COMPONENT_DIAGRAMS:
				setComponentDiagrams((IComponentDiagram)null);
				return;
			case UMLRhapsodyPackage.IPROJECT__UNIT_SCC_PROJ_NAME:
				setUnitSccProjName(UNIT_SCC_PROJ_NAME_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IPROJECT__UNIT_SCC_PROJ_PATH:
				setUnitSccProjPath(UNIT_SCC_PROJ_PATH_EDEFAULT);
				return;
			case UMLRhapsodyPackage.IPROJECT__DEPENDENCIES:
				setDependencies((IDependency)null);
				return;
			case UMLRhapsodyPackage.IPROJECT__CODE_UPDATE_CG_TIME:
				getCodeUpdateCGTime().clear();
				return;
			case UMLRhapsodyPackage.IPROJECT__VERSION:
				setVersion(VERSION_EDEFAULT);
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
			case UMLRhapsodyPackage.IPROJECT__USER_COLORS:
				return userColors != null && !userColors.isEmpty();
			case UMLRhapsodyPackage.IPROJECT__DEFAULT_SUBSYSTEM:
				return defaultSubsystem != null;
			case UMLRhapsodyPackage.IPROJECT__COMPONENT:
				return component != null;
			case UMLRhapsodyPackage.IPROJECT__MULTIPLICITIES:
				return multiplicities != null && !multiplicities.isEmpty();
			case UMLRhapsodyPackage.IPROJECT__SUBSYSTEMS:
				return subsystems != null && !subsystems.isEmpty();
			case UMLRhapsodyPackage.IPROJECT__DIAGRAMS:
				return diagrams != null && !diagrams.isEmpty();
			case UMLRhapsodyPackage.IPROJECT__COMPONENTS:
				return components != null && !components.isEmpty();
			case UMLRhapsodyPackage.IPROJECT__PANEL_DIAGRAMS:
				return panelDiagrams != null;
			case UMLRhapsodyPackage.IPROJECT__HYPER_LINKS:
				return hyperLinks != null && !hyperLinks.isEmpty();
			case UMLRhapsodyPackage.IPROJECT__MSCS:
				return mscs != null && !mscs.isEmpty();
			case UMLRhapsodyPackage.IPROJECT__UC_DIAGRAMS:
				return ucDiagrams != null && !ucDiagrams.isEmpty();
			case UMLRhapsodyPackage.IPROJECT__COLLABORATION_DIAGRAMS:
				return collaborationDiagrams != null && !collaborationDiagrams.isEmpty();
			case UMLRhapsodyPackage.IPROJECT__DECLARATIVES:
				return declaratives != null;
			case UMLRhapsodyPackage.IPROJECT__COMPONENT_DIAGRAMS:
				return componentDiagrams != null;
			case UMLRhapsodyPackage.IPROJECT__UNIT_SCC_PROJ_NAME:
				return UNIT_SCC_PROJ_NAME_EDEFAULT == null ? unitSccProjName != null : !UNIT_SCC_PROJ_NAME_EDEFAULT.equals(unitSccProjName);
			case UMLRhapsodyPackage.IPROJECT__UNIT_SCC_PROJ_PATH:
				return UNIT_SCC_PROJ_PATH_EDEFAULT == null ? unitSccProjPath != null : !UNIT_SCC_PROJ_PATH_EDEFAULT.equals(unitSccProjPath);
			case UMLRhapsodyPackage.IPROJECT__DEPENDENCIES:
				return dependencies != null;
			case UMLRhapsodyPackage.IPROJECT__CODE_UPDATE_CG_TIME:
				return codeUpdateCGTime != null && !codeUpdateCGTime.isEmpty();
			case UMLRhapsodyPackage.IPROJECT__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
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
		result.append(" (UserColors: "); //$NON-NLS-1$
		result.append(userColors);
		result.append(", unitSccProjName: "); //$NON-NLS-1$
		result.append(unitSccProjName);
		result.append(", unitSccProjPath: "); //$NON-NLS-1$
		result.append(unitSccProjPath);
		result.append(", codeUpdateCGTime: "); //$NON-NLS-1$
		result.append(codeUpdateCGTime);
		result.append(", version: "); //$NON-NLS-1$
		result.append(version);
		result.append(')');
		return result.toString();
	}

} //IProjectImpl
