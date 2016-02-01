/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.elementtypesconfigurations.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.elementtypesconfigurations.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ElementtypesconfigurationsFactoryImpl extends EFactoryImpl implements ElementtypesconfigurationsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ElementtypesconfigurationsFactory init() {
		try {
			ElementtypesconfigurationsFactory theElementtypesconfigurationsFactory = (ElementtypesconfigurationsFactory)EPackage.Registry.INSTANCE.getEFactory(ElementtypesconfigurationsPackage.eNS_URI);
			if (theElementtypesconfigurationsFactory != null) {
				return theElementtypesconfigurationsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ElementtypesconfigurationsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementtypesconfigurationsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_SET_CONFIGURATION: return createElementTypeSetConfiguration();
			case ElementtypesconfigurationsPackage.ICON_ENTRY: return createIconEntry();
			case ElementtypesconfigurationsPackage.SPECIALIZATION_TYPE_CONFIGURATION: return createSpecializationTypeConfiguration();
			case ElementtypesconfigurationsPackage.CONTAINER_CONFIGURATION: return createContainerConfiguration();
			case ElementtypesconfigurationsPackage.METAMODEL_TYPE_CONFIGURATION: return createMetamodelTypeConfiguration();
			case ElementtypesconfigurationsPackage.EDIT_HELPER_ADVICE_CONFIGURATION: return createEditHelperAdviceConfiguration();
			case ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION: return createAdviceBindingConfiguration();
			case ElementtypesconfigurationsPackage.MATCHER_CONFIGURATION: return createMatcherConfiguration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ElementtypesconfigurationsPackage.INHERITANCE_KIND:
				return createInheritanceKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ElementtypesconfigurationsPackage.INHERITANCE_KIND:
				return convertInheritanceKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementTypeSetConfiguration createElementTypeSetConfiguration() {
		ElementTypeSetConfigurationImpl elementTypeSetConfiguration = new ElementTypeSetConfigurationImpl();
		return elementTypeSetConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IconEntry createIconEntry() {
		IconEntryImpl iconEntry = new IconEntryImpl();
		return iconEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializationTypeConfiguration createSpecializationTypeConfiguration() {
		SpecializationTypeConfigurationImpl specializationTypeConfiguration = new SpecializationTypeConfigurationImpl();
		return specializationTypeConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerConfiguration createContainerConfiguration() {
		ContainerConfigurationImpl containerConfiguration = new ContainerConfigurationImpl();
		return containerConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelTypeConfiguration createMetamodelTypeConfiguration() {
		MetamodelTypeConfigurationImpl metamodelTypeConfiguration = new MetamodelTypeConfigurationImpl();
		return metamodelTypeConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditHelperAdviceConfiguration createEditHelperAdviceConfiguration() {
		EditHelperAdviceConfigurationImpl editHelperAdviceConfiguration = new EditHelperAdviceConfigurationImpl();
		return editHelperAdviceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdviceBindingConfiguration createAdviceBindingConfiguration() {
		AdviceBindingConfigurationImpl adviceBindingConfiguration = new AdviceBindingConfigurationImpl();
		return adviceBindingConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatcherConfiguration createMatcherConfiguration() {
		MatcherConfigurationImpl matcherConfiguration = new MatcherConfigurationImpl();
		return matcherConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InheritanceKind createInheritanceKindFromString(EDataType eDataType, String initialValue) {
		InheritanceKind result = InheritanceKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInheritanceKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementtypesconfigurationsPackage getElementtypesconfigurationsPackage() {
		return (ElementtypesconfigurationsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ElementtypesconfigurationsPackage getPackage() {
		return ElementtypesconfigurationsPackage.eINSTANCE;
	}

} //ElementtypesconfigurationsFactoryImpl
