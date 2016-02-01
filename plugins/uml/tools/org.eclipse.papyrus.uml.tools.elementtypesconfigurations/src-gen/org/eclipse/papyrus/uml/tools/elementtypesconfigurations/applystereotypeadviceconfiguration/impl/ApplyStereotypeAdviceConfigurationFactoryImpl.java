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
package org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ApplyStereotypeAdviceConfigurationFactoryImpl extends EFactoryImpl implements ApplyStereotypeAdviceConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ApplyStereotypeAdviceConfigurationFactory init() {
		try {
			ApplyStereotypeAdviceConfigurationFactory theApplyStereotypeAdviceConfigurationFactory = (ApplyStereotypeAdviceConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(ApplyStereotypeAdviceConfigurationPackage.eNS_URI);
			if (theApplyStereotypeAdviceConfigurationFactory != null) {
				return theApplyStereotypeAdviceConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ApplyStereotypeAdviceConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplyStereotypeAdviceConfigurationFactoryImpl() {
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
			case ApplyStereotypeAdviceConfigurationPackage.APPLY_STEREOTYPE_ADVICE_CONFIGURATION: return createApplyStereotypeAdviceConfiguration();
			case ApplyStereotypeAdviceConfigurationPackage.STEREOTYPE_TO_APPLY: return createStereotypeToApply();
			case ApplyStereotypeAdviceConfigurationPackage.FEATURE_TO_SET: return createFeatureToSet();
			case ApplyStereotypeAdviceConfigurationPackage.LIST_VALUE: return createListValue();
			case ApplyStereotypeAdviceConfigurationPackage.CONSTANT_VALUE: return createConstantValue();
			case ApplyStereotypeAdviceConfigurationPackage.QUERY_EXECUTION_VALUE: return createQueryExecutionValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplyStereotypeAdviceConfiguration createApplyStereotypeAdviceConfiguration() {
		ApplyStereotypeAdviceConfigurationImpl applyStereotypeAdviceConfiguration = new ApplyStereotypeAdviceConfigurationImpl();
		return applyStereotypeAdviceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypeToApply createStereotypeToApply() {
		StereotypeToApplyImpl stereotypeToApply = new StereotypeToApplyImpl();
		return stereotypeToApply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureToSet createFeatureToSet() {
		FeatureToSetImpl featureToSet = new FeatureToSetImpl();
		return featureToSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListValue createListValue() {
		ListValueImpl listValue = new ListValueImpl();
		return listValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantValue createConstantValue() {
		ConstantValueImpl constantValue = new ConstantValueImpl();
		return constantValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryExecutionValue createQueryExecutionValue() {
		QueryExecutionValueImpl queryExecutionValue = new QueryExecutionValueImpl();
		return queryExecutionValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplyStereotypeAdviceConfigurationPackage getApplyStereotypeAdviceConfigurationPackage() {
		return (ApplyStereotypeAdviceConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ApplyStereotypeAdviceConfigurationPackage getPackage() {
		return ApplyStereotypeAdviceConfigurationPackage.eINSTANCE;
	}

} //ApplyStereotypeAdviceConfigurationFactoryImpl
