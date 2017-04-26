/**
 * Copyright (c) 2017 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.emf.expressions.booleanexpressions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.emf.expressions.booleanexpressions.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BooleanExpressionsFactoryImpl extends EFactoryImpl implements BooleanExpressionsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BooleanExpressionsFactory init() {
		try {
			BooleanExpressionsFactory theBooleanExpressionsFactory = (BooleanExpressionsFactory)EPackage.Registry.INSTANCE.getEFactory(BooleanExpressionsPackage.eNS_URI);
			if (theBooleanExpressionsFactory != null) {
				return theBooleanExpressionsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BooleanExpressionsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanExpressionsFactoryImpl() {
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
			case BooleanExpressionsPackage.OR_EXPRESSION: return createOrExpression();
			case BooleanExpressionsPackage.AND_EXPRESSION: return createAndExpression();
			case BooleanExpressionsPackage.NOT_EXPRESSION: return createNotExpression();
			case BooleanExpressionsPackage.LITERAL_TRUE_EXPRESSION: return createLiteralTrueExpression();
			case BooleanExpressionsPackage.LITERAL_FALSE_EXPRESSION: return createLiteralFalseExpression();
			case BooleanExpressionsPackage.REFERENCE_BOOLEAN_EXPRESSION: return createReferenceBooleanExpression();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrExpression createOrExpression() {
		OrExpressionImpl orExpression = new OrExpressionImpl();
		return orExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndExpression createAndExpression() {
		AndExpressionImpl andExpression = new AndExpressionImpl();
		return andExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotExpression createNotExpression() {
		NotExpressionImpl notExpression = new NotExpressionImpl();
		return notExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralTrueExpression createLiteralTrueExpression() {
		LiteralTrueExpressionImpl literalTrueExpression = new LiteralTrueExpressionImpl();
		return literalTrueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralFalseExpression createLiteralFalseExpression() {
		LiteralFalseExpressionImpl literalFalseExpression = new LiteralFalseExpressionImpl();
		return literalFalseExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceBooleanExpression createReferenceBooleanExpression() {
		ReferenceBooleanExpressionImpl referenceBooleanExpression = new ReferenceBooleanExpressionImpl();
		return referenceBooleanExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanExpressionsPackage getBooleanExpressionsPackage() {
		return (BooleanExpressionsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BooleanExpressionsPackage getPackage() {
		return BooleanExpressionsPackage.eINSTANCE;
	}

} //BooleanExpressionsFactoryImpl
