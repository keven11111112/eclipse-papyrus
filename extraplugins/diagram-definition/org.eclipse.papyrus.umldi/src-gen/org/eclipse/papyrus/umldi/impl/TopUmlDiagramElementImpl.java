/**
 * Copyright (c) 2014 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.umldi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.umldi.DiagramCompartment;
import org.eclipse.papyrus.umldi.MainLabel;
import org.eclipse.papyrus.umldi.TopUmlDiagramElement;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagram;
import org.eclipse.papyrus.umldi.UmlDiagramElement;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Top Uml Diagram Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.TopUmlDiagramElementImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.TopUmlDiagramElementImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.TopUmlDiagramElementImpl#getUmlDiagram <em>Uml Diagram</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.TopUmlDiagramElementImpl#getDiagramCompartment <em>Diagram Compartment</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.TopUmlDiagramElementImpl#getMainLabel <em>Main Label</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TopUmlDiagramElementImpl extends StereotypedDiagramElementImpl implements TopUmlDiagramElement {

	/**
	 * The cached value of the '{@link #getMainLabel() <em>Main Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMainLabel()
	 * @generated
	 * @ordered
	 */
	protected MainLabel mainLabel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TopUmlDiagramElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.TOP_UML_DIAGRAM_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public UmlDiagramElement getOwningUmlDiagramElement() {
		UmlDiagramElement owningUmlDiagramElement = basicGetOwningUmlDiagramElement();
		return owningUmlDiagramElement != null && owningUmlDiagramElement.eIsProxy() ? (UmlDiagramElement)eResolveProxy((InternalEObject)owningUmlDiagramElement) : owningUmlDiagramElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public UmlDiagramElement basicGetOwningUmlDiagramElement() {
		UmlDiagram umlDiagram = getUmlDiagram();
		if(umlDiagram != null) {
			return umlDiagram;
		}
		DiagramCompartment diagramCompartment = getDiagramCompartment();
		if(diagramCompartment != null) {
			return diagramCompartment;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOwnedUmlDiagramElement()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[]{ UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__STEREOTYPE_LABEL, UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__MAIN_LABEL };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlDiagram getUmlDiagram() {
		if(eContainerFeatureID() != UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__UML_DIAGRAM)
			return null;
		return (UmlDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetUmlDiagram(UmlDiagram newUmlDiagram, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newUmlDiagram, UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__UML_DIAGRAM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setUmlDiagram(UmlDiagram newUmlDiagram) {
		if(newUmlDiagram != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__UML_DIAGRAM && newUmlDiagram != null)) {
			if(EcoreUtil.isAncestor(this, newUmlDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newUmlDiagram != null)
				msgs = ((InternalEObject)newUmlDiagram).eInverseAdd(this, UMLDIPackage.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UmlDiagram.class, msgs);
			msgs = basicSetUmlDiagram(newUmlDiagram, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__UML_DIAGRAM, newUmlDiagram, newUmlDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DiagramCompartment getDiagramCompartment() {
		if(eContainerFeatureID() != UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__DIAGRAM_COMPARTMENT)
			return null;
		return (DiagramCompartment)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetDiagramCompartment(DiagramCompartment newDiagramCompartment, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDiagramCompartment, UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__DIAGRAM_COMPARTMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDiagramCompartment(DiagramCompartment newDiagramCompartment) {
		if(newDiagramCompartment != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__DIAGRAM_COMPARTMENT && newDiagramCompartment != null)) {
			if(EcoreUtil.isAncestor(this, newDiagramCompartment))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newDiagramCompartment != null)
				msgs = ((InternalEObject)newDiagramCompartment).eInverseAdd(this, UMLDIPackage.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, DiagramCompartment.class, msgs);
			msgs = basicSetDiagramCompartment(newDiagramCompartment, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__DIAGRAM_COMPARTMENT, newDiagramCompartment, newDiagramCompartment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MainLabel getMainLabel() {
		return mainLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetMainLabel(MainLabel newMainLabel, NotificationChain msgs) {
		MainLabel oldMainLabel = mainLabel;
		mainLabel = newMainLabel;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__MAIN_LABEL, oldMainLabel, newMainLabel);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMainLabel(MainLabel newMainLabel) {
		if(newMainLabel != mainLabel) {
			NotificationChain msgs = null;
			if(mainLabel != null)
				msgs = ((InternalEObject)mainLabel).eInverseRemove(this, UMLDIPackage.MAIN_LABEL__TOP_UML_DIAGRAM_ELEMENT, MainLabel.class, msgs);
			if(newMainLabel != null)
				msgs = ((InternalEObject)newMainLabel).eInverseAdd(this, UMLDIPackage.MAIN_LABEL__TOP_UML_DIAGRAM_ELEMENT, MainLabel.class, msgs);
			msgs = basicSetMainLabel(newMainLabel, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__MAIN_LABEL, newMainLabel, newMainLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__UML_DIAGRAM:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetUmlDiagram((UmlDiagram)otherEnd, msgs);
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__DIAGRAM_COMPARTMENT:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetDiagramCompartment((DiagramCompartment)otherEnd, msgs);
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__MAIN_LABEL:
			if(mainLabel != null)
				msgs = ((InternalEObject)mainLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__MAIN_LABEL, null, msgs);
			return basicSetMainLabel((MainLabel)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__UML_DIAGRAM:
			return basicSetUmlDiagram(null, msgs);
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__DIAGRAM_COMPARTMENT:
			return basicSetDiagramCompartment(null, msgs);
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__MAIN_LABEL:
			return basicSetMainLabel(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch(eContainerFeatureID()) {
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__UML_DIAGRAM:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT, UmlDiagram.class, msgs);
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__DIAGRAM_COMPARTMENT:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, DiagramCompartment.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__UML_DIAGRAM:
			return getUmlDiagram();
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__DIAGRAM_COMPARTMENT:
			return getDiagramCompartment();
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__MAIN_LABEL:
			return getMainLabel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__UML_DIAGRAM:
			setUmlDiagram((UmlDiagram)newValue);
			return;
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__DIAGRAM_COMPARTMENT:
			setDiagramCompartment((DiagramCompartment)newValue);
			return;
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__MAIN_LABEL:
			setMainLabel((MainLabel)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__UML_DIAGRAM:
			setUmlDiagram((UmlDiagram)null);
			return;
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__DIAGRAM_COMPARTMENT:
			setDiagramCompartment((DiagramCompartment)null);
			return;
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__MAIN_LABEL:
			setMainLabel((MainLabel)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT:
			return isSetOwningUmlDiagramElement();
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT:
			return isSetOwnedUmlDiagramElement();
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__UML_DIAGRAM:
			return getUmlDiagram() != null;
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__DIAGRAM_COMPARTMENT:
			return getDiagramCompartment() != null;
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__MAIN_LABEL:
			return mainLabel != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isSetOwningUmlDiagramElement() {
		return super.isSetOwningUmlDiagramElement() || eIsSet(UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__UML_DIAGRAM) || eIsSet(UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__DIAGRAM_COMPARTMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isSetOwnedUmlDiagramElement() {
		return super.isSetOwnedUmlDiagramElement() || eIsSet(UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT__MAIN_LABEL);
	}
} //TopUmlDiagramElementImpl
