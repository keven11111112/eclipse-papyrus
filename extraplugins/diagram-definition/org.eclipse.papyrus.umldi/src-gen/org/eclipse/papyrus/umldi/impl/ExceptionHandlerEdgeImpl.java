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
import org.eclipse.papyrus.umldi.ExceptionHandlerEdge;
import org.eclipse.papyrus.umldi.IconLabel;
import org.eclipse.papyrus.umldi.TypeLabel;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exception Handler Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ExceptionHandlerEdgeImpl#getOwnedUmlDiagramElement <em>Owned Uml Diagram Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ExceptionHandlerEdgeImpl#getTypeLabel <em>Type Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.impl.ExceptionHandlerEdgeImpl#getIconLabel <em>Icon Label</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExceptionHandlerEdgeImpl extends ElementEdgeImpl implements ExceptionHandlerEdge {
	/**
	 * The cached value of the '{@link #getTypeLabel() <em>Type Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeLabel()
	 * @generated
	 * @ordered
	 */
	protected TypeLabel typeLabel;
	/**
	 * The cached value of the '{@link #getIconLabel() <em>Icon Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconLabel()
	 * @generated
	 * @ordered
	 */
	protected IconLabel iconLabel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExceptionHandlerEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.EXCEPTION_HANDLER_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UmlDiagramElement> getOwnedUmlDiagramElement() {
		return new DerivedUnionEObjectEList<UmlDiagramElement>(UmlDiagramElement.class, this, UMLDIPackage.EXCEPTION_HANDLER_EDGE__OWNED_UML_DIAGRAM_ELEMENT, OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedUmlDiagramElement()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_UML_DIAGRAM_ELEMENT_ESUBSETS = new int[] {UMLDIPackage.EXCEPTION_HANDLER_EDGE__MAIN_LABEL, UMLDIPackage.EXCEPTION_HANDLER_EDGE__TYPE_LABEL, UMLDIPackage.EXCEPTION_HANDLER_EDGE__ICON_LABEL};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeLabel getTypeLabel() {
		return typeLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeLabel(TypeLabel newTypeLabel, NotificationChain msgs) {
		TypeLabel oldTypeLabel = typeLabel;
		typeLabel = newTypeLabel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.EXCEPTION_HANDLER_EDGE__TYPE_LABEL, oldTypeLabel, newTypeLabel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeLabel(TypeLabel newTypeLabel) {
		if (newTypeLabel != typeLabel) {
			NotificationChain msgs = null;
			if (typeLabel != null)
				msgs = ((InternalEObject)typeLabel).eInverseRemove(this, UMLDIPackage.TYPE_LABEL__EXCEPTION_HANDLER_EDGE, TypeLabel.class, msgs);
			if (newTypeLabel != null)
				msgs = ((InternalEObject)newTypeLabel).eInverseAdd(this, UMLDIPackage.TYPE_LABEL__EXCEPTION_HANDLER_EDGE, TypeLabel.class, msgs);
			msgs = basicSetTypeLabel(newTypeLabel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.EXCEPTION_HANDLER_EDGE__TYPE_LABEL, newTypeLabel, newTypeLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IconLabel getIconLabel() {
		return iconLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIconLabel(IconLabel newIconLabel, NotificationChain msgs) {
		IconLabel oldIconLabel = iconLabel;
		iconLabel = newIconLabel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLDIPackage.EXCEPTION_HANDLER_EDGE__ICON_LABEL, oldIconLabel, newIconLabel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconLabel(IconLabel newIconLabel) {
		if (newIconLabel != iconLabel) {
			NotificationChain msgs = null;
			if (iconLabel != null)
				msgs = ((InternalEObject)iconLabel).eInverseRemove(this, UMLDIPackage.ICON_LABEL__EXCEPTION_HANDLER_EDGE, IconLabel.class, msgs);
			if (newIconLabel != null)
				msgs = ((InternalEObject)newIconLabel).eInverseAdd(this, UMLDIPackage.ICON_LABEL__EXCEPTION_HANDLER_EDGE, IconLabel.class, msgs);
			msgs = basicSetIconLabel(newIconLabel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.EXCEPTION_HANDLER_EDGE__ICON_LABEL, newIconLabel, newIconLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDIPackage.EXCEPTION_HANDLER_EDGE__TYPE_LABEL:
				if (typeLabel != null)
					msgs = ((InternalEObject)typeLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.EXCEPTION_HANDLER_EDGE__TYPE_LABEL, null, msgs);
				return basicSetTypeLabel((TypeLabel)otherEnd, msgs);
			case UMLDIPackage.EXCEPTION_HANDLER_EDGE__ICON_LABEL:
				if (iconLabel != null)
					msgs = ((InternalEObject)iconLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLDIPackage.EXCEPTION_HANDLER_EDGE__ICON_LABEL, null, msgs);
				return basicSetIconLabel((IconLabel)otherEnd, msgs);
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
			case UMLDIPackage.EXCEPTION_HANDLER_EDGE__TYPE_LABEL:
				return basicSetTypeLabel(null, msgs);
			case UMLDIPackage.EXCEPTION_HANDLER_EDGE__ICON_LABEL:
				return basicSetIconLabel(null, msgs);
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
			case UMLDIPackage.EXCEPTION_HANDLER_EDGE__TYPE_LABEL:
				return getTypeLabel();
			case UMLDIPackage.EXCEPTION_HANDLER_EDGE__ICON_LABEL:
				return getIconLabel();
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
			case UMLDIPackage.EXCEPTION_HANDLER_EDGE__TYPE_LABEL:
				setTypeLabel((TypeLabel)newValue);
				return;
			case UMLDIPackage.EXCEPTION_HANDLER_EDGE__ICON_LABEL:
				setIconLabel((IconLabel)newValue);
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
			case UMLDIPackage.EXCEPTION_HANDLER_EDGE__TYPE_LABEL:
				setTypeLabel((TypeLabel)null);
				return;
			case UMLDIPackage.EXCEPTION_HANDLER_EDGE__ICON_LABEL:
				setIconLabel((IconLabel)null);
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
			case UMLDIPackage.EXCEPTION_HANDLER_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
				return isSetOwnedUmlDiagramElement();
			case UMLDIPackage.EXCEPTION_HANDLER_EDGE__TYPE_LABEL:
				return typeLabel != null;
			case UMLDIPackage.EXCEPTION_HANDLER_EDGE__ICON_LABEL:
				return iconLabel != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedUmlDiagramElement() {
		return super.isSetOwnedUmlDiagramElement()
			|| eIsSet(UMLDIPackage.EXCEPTION_HANDLER_EDGE__TYPE_LABEL)
			|| eIsSet(UMLDIPackage.EXCEPTION_HANDLER_EDGE__ICON_LABEL);
	}

} //ExceptionHandlerEdgeImpl
