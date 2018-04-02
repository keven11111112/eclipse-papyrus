/**
 * Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.gmfdiag.representation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.architecture.representation.impl.PapyrusRepresentationKindImpl;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.PaletteConfiguration;
import org.eclipse.papyrus.infra.gmfdiag.representation.AssistantRule;
import org.eclipse.papyrus.infra.gmfdiag.representation.ChildRule;
import org.eclipse.papyrus.infra.gmfdiag.representation.PaletteRule;
import org.eclipse.papyrus.infra.gmfdiag.representation.PapyrusDiagram;
import org.eclipse.papyrus.infra.gmfdiag.representation.RepresentationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Papyrus
 * Diagram</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.representation.impl.PapyrusDiagramImpl#getCustomStyle <em>Custom Style</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.representation.impl.PapyrusDiagramImpl#getChildRules <em>Child Rules</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.representation.impl.PapyrusDiagramImpl#getPaletteRules <em>Palette Rules</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.representation.impl.PapyrusDiagramImpl#getAssistantRules <em>Assistant Rules</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.representation.impl.PapyrusDiagramImpl#getCreationCommandClass <em>Creation Command Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.representation.impl.PapyrusDiagramImpl#getPalettes <em>Palettes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PapyrusDiagramImpl extends PapyrusRepresentationKindImpl implements PapyrusDiagram {
	/**
	 * The default value of the '{@link #getCustomStyle() <em>Custom Style</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCustomStyle()
	 * @generated
	 * @ordered
	 */
	protected static final String CUSTOM_STYLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCustomStyle() <em>Custom Style</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCustomStyle()
	 * @generated
	 * @ordered
	 */
	protected String customStyle = CUSTOM_STYLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChildRules() <em>Child Rules</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getChildRules()
	 * @generated
	 * @ordered
	 */
	protected EList<ChildRule> childRules;

	/**
	 * The cached value of the '{@link #getPaletteRules() <em>Palette Rules</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getPaletteRules()
	 * @generated
	 * @ordered
	 */
	protected EList<PaletteRule> paletteRules;

	/**
	 * The cached value of the '{@link #getAssistantRules() <em>Assistant Rules</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getAssistantRules()
	 * @generated
	 * @ordered
	 */
	protected EList<AssistantRule> assistantRules;

	/**
	 * The cached value of the '{@link #getCreationCommandClass() <em>Creation
	 * Command Class</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getCreationCommandClass()
	 * @generated
	 * @ordered
	 */
	protected Class<?> creationCommandClass;

	/**
	 * The cached value of the '{@link #getPalettes() <em>Palettes</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPalettes()
	 * @generated
	 * @ordered
	 */
	protected EList<PaletteConfiguration> palettes;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PapyrusDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepresentationPackage.Literals.PAPYRUS_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCustomStyle() {
		return customStyle;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomStyle(String newCustomStyle) {
		String oldCustomStyle = customStyle;
		customStyle = newCustomStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepresentationPackage.PAPYRUS_DIAGRAM__CUSTOM_STYLE, oldCustomStyle, customStyle));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChildRule> getChildRules() {
		if (childRules == null) {
			childRules = new EObjectContainmentEList<ChildRule>(ChildRule.class, this, RepresentationPackage.PAPYRUS_DIAGRAM__CHILD_RULES);
		}
		return childRules;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PaletteRule> getPaletteRules() {
		if (paletteRules == null) {
			paletteRules = new EObjectContainmentEList<PaletteRule>(PaletteRule.class, this, RepresentationPackage.PAPYRUS_DIAGRAM__PALETTE_RULES);
		}
		return paletteRules;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AssistantRule> getAssistantRules() {
		if (assistantRules == null) {
			assistantRules = new EObjectContainmentEList<AssistantRule>(AssistantRule.class, this, RepresentationPackage.PAPYRUS_DIAGRAM__ASSISTANT_RULES);
		}
		return assistantRules;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Class<?> getCreationCommandClass() {
		return creationCommandClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationCommandClass(Class<?> newCreationCommandClass) {
		Class<?> oldCreationCommandClass = creationCommandClass;
		creationCommandClass = newCreationCommandClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepresentationPackage.PAPYRUS_DIAGRAM__CREATION_COMMAND_CLASS, oldCreationCommandClass, creationCommandClass));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PaletteConfiguration> getPalettes() {
		if (palettes == null) {
			palettes = new EObjectResolvingEList<PaletteConfiguration>(PaletteConfiguration.class, this, RepresentationPackage.PAPYRUS_DIAGRAM__PALETTES);
		}
		return palettes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepresentationPackage.PAPYRUS_DIAGRAM__CHILD_RULES:
				return ((InternalEList<?>)getChildRules()).basicRemove(otherEnd, msgs);
			case RepresentationPackage.PAPYRUS_DIAGRAM__PALETTE_RULES:
				return ((InternalEList<?>)getPaletteRules()).basicRemove(otherEnd, msgs);
			case RepresentationPackage.PAPYRUS_DIAGRAM__ASSISTANT_RULES:
				return ((InternalEList<?>)getAssistantRules()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepresentationPackage.PAPYRUS_DIAGRAM__CUSTOM_STYLE:
				return getCustomStyle();
			case RepresentationPackage.PAPYRUS_DIAGRAM__CHILD_RULES:
				return getChildRules();
			case RepresentationPackage.PAPYRUS_DIAGRAM__PALETTE_RULES:
				return getPaletteRules();
			case RepresentationPackage.PAPYRUS_DIAGRAM__ASSISTANT_RULES:
				return getAssistantRules();
			case RepresentationPackage.PAPYRUS_DIAGRAM__CREATION_COMMAND_CLASS:
				return getCreationCommandClass();
			case RepresentationPackage.PAPYRUS_DIAGRAM__PALETTES:
				return getPalettes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RepresentationPackage.PAPYRUS_DIAGRAM__CUSTOM_STYLE:
				setCustomStyle((String)newValue);
				return;
			case RepresentationPackage.PAPYRUS_DIAGRAM__CHILD_RULES:
				getChildRules().clear();
				getChildRules().addAll((Collection<? extends ChildRule>)newValue);
				return;
			case RepresentationPackage.PAPYRUS_DIAGRAM__PALETTE_RULES:
				getPaletteRules().clear();
				getPaletteRules().addAll((Collection<? extends PaletteRule>)newValue);
				return;
			case RepresentationPackage.PAPYRUS_DIAGRAM__ASSISTANT_RULES:
				getAssistantRules().clear();
				getAssistantRules().addAll((Collection<? extends AssistantRule>)newValue);
				return;
			case RepresentationPackage.PAPYRUS_DIAGRAM__CREATION_COMMAND_CLASS:
				setCreationCommandClass((Class<?>)newValue);
				return;
			case RepresentationPackage.PAPYRUS_DIAGRAM__PALETTES:
				getPalettes().clear();
				getPalettes().addAll((Collection<? extends PaletteConfiguration>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case RepresentationPackage.PAPYRUS_DIAGRAM__CUSTOM_STYLE:
				setCustomStyle(CUSTOM_STYLE_EDEFAULT);
				return;
			case RepresentationPackage.PAPYRUS_DIAGRAM__CHILD_RULES:
				getChildRules().clear();
				return;
			case RepresentationPackage.PAPYRUS_DIAGRAM__PALETTE_RULES:
				getPaletteRules().clear();
				return;
			case RepresentationPackage.PAPYRUS_DIAGRAM__ASSISTANT_RULES:
				getAssistantRules().clear();
				return;
			case RepresentationPackage.PAPYRUS_DIAGRAM__CREATION_COMMAND_CLASS:
				setCreationCommandClass((Class<?>)null);
				return;
			case RepresentationPackage.PAPYRUS_DIAGRAM__PALETTES:
				getPalettes().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RepresentationPackage.PAPYRUS_DIAGRAM__CUSTOM_STYLE:
				return CUSTOM_STYLE_EDEFAULT == null ? customStyle != null : !CUSTOM_STYLE_EDEFAULT.equals(customStyle);
			case RepresentationPackage.PAPYRUS_DIAGRAM__CHILD_RULES:
				return childRules != null && !childRules.isEmpty();
			case RepresentationPackage.PAPYRUS_DIAGRAM__PALETTE_RULES:
				return paletteRules != null && !paletteRules.isEmpty();
			case RepresentationPackage.PAPYRUS_DIAGRAM__ASSISTANT_RULES:
				return assistantRules != null && !assistantRules.isEmpty();
			case RepresentationPackage.PAPYRUS_DIAGRAM__CREATION_COMMAND_CLASS:
				return creationCommandClass != null;
			case RepresentationPackage.PAPYRUS_DIAGRAM__PALETTES:
				return palettes != null && !palettes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (customStyle: "); //$NON-NLS-1$
		result.append(customStyle);
		result.append(", creationCommandClass: "); //$NON-NLS-1$
		result.append(creationCommandClass);
		result.append(')');
		return result.toString();
	}

} // PapyrusDiagramImpl
