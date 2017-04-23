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
package org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.infra.emf.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.EObjectBooleanExpressionsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='BooleanExpressionsPackage'"
 * @generated
 */
public interface EObjectBooleanExpressionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "booleanexpressionspackage"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/expressions/eobjectbooleanexpressions"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "booleanexpressionspackage"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EObjectBooleanExpressionsPackage eINSTANCE = org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.EObjectBooleanExpressionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.IBooleanExpression <em>IBoolean Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.IBooleanExpression
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.EObjectBooleanExpressionsPackageImpl#getIBooleanExpression()
	 * @generated
	 */
	int IBOOLEAN_EXPRESSION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBOOLEAN_EXPRESSION__NAME = ExpressionsPackage.IEXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBOOLEAN_EXPRESSION__DESCRIPTION = ExpressionsPackage.IEXPRESSION__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>IBoolean Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBOOLEAN_EXPRESSION_FEATURE_COUNT = ExpressionsPackage.IEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Evaluate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBOOLEAN_EXPRESSION___EVALUATE__OBJECT = ExpressionsPackage.IEXPRESSION___EVALUATE__OBJECT;

	/**
	 * The number of operations of the '<em>IBoolean Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBOOLEAN_EXPRESSION_OPERATION_COUNT = ExpressionsPackage.IEXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.IBooleanEObjectExpression <em>IBoolean EObject Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.IBooleanEObjectExpression
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.EObjectBooleanExpressionsPackageImpl#getIBooleanEObjectExpression()
	 * @generated
	 */
	int IBOOLEAN_EOBJECT_EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBOOLEAN_EOBJECT_EXPRESSION__NAME = IBOOLEAN_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBOOLEAN_EOBJECT_EXPRESSION__DESCRIPTION = IBOOLEAN_EXPRESSION__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>IBoolean EObject Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBOOLEAN_EOBJECT_EXPRESSION_FEATURE_COUNT = IBOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Evaluate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBOOLEAN_EOBJECT_EXPRESSION___EVALUATE__OBJECT = IBOOLEAN_EXPRESSION___EVALUATE__OBJECT;

	/**
	 * The number of operations of the '<em>IBoolean EObject Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBOOLEAN_EOBJECT_EXPRESSION_OPERATION_COUNT = IBOOLEAN_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.OrExpressionImpl <em>Or Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.OrExpressionImpl
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.EObjectBooleanExpressionsPackageImpl#getOrExpression()
	 * @generated
	 */
	int OR_EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION__NAME = IBOOLEAN_EOBJECT_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION__DESCRIPTION = IBOOLEAN_EOBJECT_EXPRESSION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Owned Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION__OWNED_EXPRESSIONS = IBOOLEAN_EOBJECT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referenced Expressions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION__REFERENCED_EXPRESSIONS = IBOOLEAN_EOBJECT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Or Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION_FEATURE_COUNT = IBOOLEAN_EOBJECT_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Evaluate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION___EVALUATE__OBJECT = IBOOLEAN_EOBJECT_EXPRESSION___EVALUATE__OBJECT;

	/**
	 * The number of operations of the '<em>Or Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION_OPERATION_COUNT = IBOOLEAN_EOBJECT_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.AndExpressionImpl <em>And Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.AndExpressionImpl
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.EObjectBooleanExpressionsPackageImpl#getAndExpression()
	 * @generated
	 */
	int AND_EXPRESSION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION__NAME = IBOOLEAN_EOBJECT_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION__DESCRIPTION = IBOOLEAN_EOBJECT_EXPRESSION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Owned Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION__OWNED_EXPRESSIONS = IBOOLEAN_EOBJECT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referenced Expressions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION__REFERENCED_EXPRESSIONS = IBOOLEAN_EOBJECT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>And Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION_FEATURE_COUNT = IBOOLEAN_EOBJECT_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Evaluate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION___EVALUATE__OBJECT = IBOOLEAN_EOBJECT_EXPRESSION___EVALUATE__OBJECT;

	/**
	 * The number of operations of the '<em>And Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION_OPERATION_COUNT = IBOOLEAN_EOBJECT_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.NotExpressionImpl <em>Not Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.NotExpressionImpl
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.EObjectBooleanExpressionsPackageImpl#getNotExpression()
	 * @generated
	 */
	int NOT_EXPRESSION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION__NAME = IBOOLEAN_EOBJECT_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION__DESCRIPTION = IBOOLEAN_EOBJECT_EXPRESSION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION__OWNED_EXPRESSION = IBOOLEAN_EOBJECT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referenced Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION__REFERENCED_EXPRESSION = IBOOLEAN_EOBJECT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Not Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION_FEATURE_COUNT = IBOOLEAN_EOBJECT_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Evaluate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION___EVALUATE__OBJECT = IBOOLEAN_EOBJECT_EXPRESSION___EVALUATE__OBJECT;

	/**
	 * The number of operations of the '<em>Not Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION_OPERATION_COUNT = IBOOLEAN_EOBJECT_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.LiteralTrueExpressionImpl <em>Literal True Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.LiteralTrueExpressionImpl
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.EObjectBooleanExpressionsPackageImpl#getLiteralTrueExpression()
	 * @generated
	 */
	int LITERAL_TRUE_EXPRESSION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TRUE_EXPRESSION__NAME = IBOOLEAN_EOBJECT_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TRUE_EXPRESSION__DESCRIPTION = IBOOLEAN_EOBJECT_EXPRESSION__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Literal True Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TRUE_EXPRESSION_FEATURE_COUNT = IBOOLEAN_EOBJECT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Evaluate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TRUE_EXPRESSION___EVALUATE__OBJECT = IBOOLEAN_EOBJECT_EXPRESSION___EVALUATE__OBJECT;

	/**
	 * The number of operations of the '<em>Literal True Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_TRUE_EXPRESSION_OPERATION_COUNT = IBOOLEAN_EOBJECT_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.LiteralFalseExpressionImpl <em>Literal False Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.LiteralFalseExpressionImpl
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.EObjectBooleanExpressionsPackageImpl#getLiteralFalseExpression()
	 * @generated
	 */
	int LITERAL_FALSE_EXPRESSION = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FALSE_EXPRESSION__NAME = IBOOLEAN_EOBJECT_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FALSE_EXPRESSION__DESCRIPTION = IBOOLEAN_EOBJECT_EXPRESSION__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Literal False Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FALSE_EXPRESSION_FEATURE_COUNT = IBOOLEAN_EOBJECT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Evaluate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FALSE_EXPRESSION___EVALUATE__OBJECT = IBOOLEAN_EOBJECT_EXPRESSION___EVALUATE__OBJECT;

	/**
	 * The number of operations of the '<em>Literal False Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FALSE_EXPRESSION_OPERATION_COUNT = IBOOLEAN_EOBJECT_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.ReferenceBooleanExpressionImpl <em>Reference Boolean Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.ReferenceBooleanExpressionImpl
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.EObjectBooleanExpressionsPackageImpl#getReferenceBooleanExpression()
	 * @generated
	 */
	int REFERENCE_BOOLEAN_EXPRESSION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BOOLEAN_EXPRESSION__NAME = IBOOLEAN_EOBJECT_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BOOLEAN_EXPRESSION__DESCRIPTION = IBOOLEAN_EOBJECT_EXPRESSION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Referenced Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BOOLEAN_EXPRESSION__REFERENCED_EXPRESSION = IBOOLEAN_EOBJECT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Boolean Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BOOLEAN_EXPRESSION_FEATURE_COUNT = IBOOLEAN_EOBJECT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Evaluate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BOOLEAN_EXPRESSION___EVALUATE__OBJECT = IBOOLEAN_EOBJECT_EXPRESSION___EVALUATE__OBJECT;

	/**
	 * The number of operations of the '<em>Reference Boolean Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_BOOLEAN_EXPRESSION_OPERATION_COUNT = IBOOLEAN_EOBJECT_EXPRESSION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.OrExpression <em>Or Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Expression</em>'.
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.OrExpression
	 * @generated
	 */
	EClass getOrExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.OrExpression#getOwnedExpressions <em>Owned Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Expressions</em>'.
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.OrExpression#getOwnedExpressions()
	 * @see #getOrExpression()
	 * @generated
	 */
	EReference getOrExpression_OwnedExpressions();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.OrExpression#getReferencedExpressions <em>Referenced Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced Expressions</em>'.
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.OrExpression#getReferencedExpressions()
	 * @see #getOrExpression()
	 * @generated
	 */
	EReference getOrExpression_ReferencedExpressions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.IBooleanEObjectExpression <em>IBoolean EObject Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IBoolean EObject Expression</em>'.
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.IBooleanEObjectExpression
	 * @generated
	 */
	EClass getIBooleanEObjectExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.IBooleanExpression <em>IBoolean Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IBoolean Expression</em>'.
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.IBooleanExpression
	 * @generated
	 */
	EClass getIBooleanExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.AndExpression <em>And Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Expression</em>'.
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.AndExpression
	 * @generated
	 */
	EClass getAndExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.AndExpression#getOwnedExpressions <em>Owned Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Expressions</em>'.
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.AndExpression#getOwnedExpressions()
	 * @see #getAndExpression()
	 * @generated
	 */
	EReference getAndExpression_OwnedExpressions();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.AndExpression#getReferencedExpressions <em>Referenced Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced Expressions</em>'.
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.AndExpression#getReferencedExpressions()
	 * @see #getAndExpression()
	 * @generated
	 */
	EReference getAndExpression_ReferencedExpressions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.NotExpression <em>Not Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Expression</em>'.
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.NotExpression
	 * @generated
	 */
	EClass getNotExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.NotExpression#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.NotExpression#getOwnedExpression()
	 * @see #getNotExpression()
	 * @generated
	 */
	EReference getNotExpression_OwnedExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.NotExpression#getReferencedExpression <em>Referenced Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Expression</em>'.
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.NotExpression#getReferencedExpression()
	 * @see #getNotExpression()
	 * @generated
	 */
	EReference getNotExpression_ReferencedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.LiteralTrueExpression <em>Literal True Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal True Expression</em>'.
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.LiteralTrueExpression
	 * @generated
	 */
	EClass getLiteralTrueExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.LiteralFalseExpression <em>Literal False Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal False Expression</em>'.
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.LiteralFalseExpression
	 * @generated
	 */
	EClass getLiteralFalseExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.ReferenceBooleanExpression <em>Reference Boolean Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Boolean Expression</em>'.
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.ReferenceBooleanExpression
	 * @generated
	 */
	EClass getReferenceBooleanExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.ReferenceBooleanExpression#getReferencedExpression <em>Referenced Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Expression</em>'.
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.ReferenceBooleanExpression#getReferencedExpression()
	 * @see #getReferenceBooleanExpression()
	 * @generated
	 */
	EReference getReferenceBooleanExpression_ReferencedExpression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EObjectBooleanExpressionsFactory getEObjectBooleanExpressionsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.OrExpressionImpl <em>Or Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.OrExpressionImpl
		 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.EObjectBooleanExpressionsPackageImpl#getOrExpression()
		 * @generated
		 */
		EClass OR_EXPRESSION = eINSTANCE.getOrExpression();

		/**
		 * The meta object literal for the '<em><b>Owned Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OR_EXPRESSION__OWNED_EXPRESSIONS = eINSTANCE.getOrExpression_OwnedExpressions();

		/**
		 * The meta object literal for the '<em><b>Referenced Expressions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OR_EXPRESSION__REFERENCED_EXPRESSIONS = eINSTANCE.getOrExpression_ReferencedExpressions();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.IBooleanEObjectExpression <em>IBoolean EObject Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.IBooleanEObjectExpression
		 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.EObjectBooleanExpressionsPackageImpl#getIBooleanEObjectExpression()
		 * @generated
		 */
		EClass IBOOLEAN_EOBJECT_EXPRESSION = eINSTANCE.getIBooleanEObjectExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.IBooleanExpression <em>IBoolean Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.IBooleanExpression
		 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.EObjectBooleanExpressionsPackageImpl#getIBooleanExpression()
		 * @generated
		 */
		EClass IBOOLEAN_EXPRESSION = eINSTANCE.getIBooleanExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.AndExpressionImpl <em>And Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.AndExpressionImpl
		 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.EObjectBooleanExpressionsPackageImpl#getAndExpression()
		 * @generated
		 */
		EClass AND_EXPRESSION = eINSTANCE.getAndExpression();

		/**
		 * The meta object literal for the '<em><b>Owned Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AND_EXPRESSION__OWNED_EXPRESSIONS = eINSTANCE.getAndExpression_OwnedExpressions();

		/**
		 * The meta object literal for the '<em><b>Referenced Expressions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AND_EXPRESSION__REFERENCED_EXPRESSIONS = eINSTANCE.getAndExpression_ReferencedExpressions();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.NotExpressionImpl <em>Not Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.NotExpressionImpl
		 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.EObjectBooleanExpressionsPackageImpl#getNotExpression()
		 * @generated
		 */
		EClass NOT_EXPRESSION = eINSTANCE.getNotExpression();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT_EXPRESSION__OWNED_EXPRESSION = eINSTANCE.getNotExpression_OwnedExpression();

		/**
		 * The meta object literal for the '<em><b>Referenced Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT_EXPRESSION__REFERENCED_EXPRESSION = eINSTANCE.getNotExpression_ReferencedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.LiteralTrueExpressionImpl <em>Literal True Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.LiteralTrueExpressionImpl
		 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.EObjectBooleanExpressionsPackageImpl#getLiteralTrueExpression()
		 * @generated
		 */
		EClass LITERAL_TRUE_EXPRESSION = eINSTANCE.getLiteralTrueExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.LiteralFalseExpressionImpl <em>Literal False Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.LiteralFalseExpressionImpl
		 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.EObjectBooleanExpressionsPackageImpl#getLiteralFalseExpression()
		 * @generated
		 */
		EClass LITERAL_FALSE_EXPRESSION = eINSTANCE.getLiteralFalseExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.ReferenceBooleanExpressionImpl <em>Reference Boolean Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.ReferenceBooleanExpressionImpl
		 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.impl.EObjectBooleanExpressionsPackageImpl#getReferenceBooleanExpression()
		 * @generated
		 */
		EClass REFERENCE_BOOLEAN_EXPRESSION = eINSTANCE.getReferenceBooleanExpression();

		/**
		 * The meta object literal for the '<em><b>Referenced Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_BOOLEAN_EXPRESSION__REFERENCED_EXPRESSION = eINSTANCE.getReferenceBooleanExpression_ReferencedExpression();

	}

} //EObjectBooleanExpressionsPackage
