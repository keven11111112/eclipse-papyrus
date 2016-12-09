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
package org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Polygon;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Position;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyPort;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryFactory;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RhpGeometryPackageImpl extends EPackageImpl implements RhpGeometryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformMatrixEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rhapsodyShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rectangleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass polygonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rhapsodyPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum positionEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RhpGeometryPackageImpl() {
		super(eNS_URI, RhpGeometryFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link RhpGeometryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RhpGeometryPackage init() {
		if (isInited) return (RhpGeometryPackage)EPackage.Registry.INSTANCE.getEPackage(RhpGeometryPackage.eNS_URI);

		// Obtain or create and register package
		RhpGeometryPackageImpl theRhpGeometryPackage = (RhpGeometryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RhpGeometryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RhpGeometryPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRhpGeometryPackage.createPackageContents();

		// Initialize created meta-data
		theRhpGeometryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRhpGeometryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RhpGeometryPackage.eNS_URI, theRhpGeometryPackage);
		return theRhpGeometryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformMatrix() {
		return transformMatrixEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformMatrix_A() {
		return (EAttribute)transformMatrixEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformMatrix_B() {
		return (EAttribute)transformMatrixEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformMatrix_C() {
		return (EAttribute)transformMatrixEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformMatrix_D() {
		return (EAttribute)transformMatrixEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformMatrix_E() {
		return (EAttribute)transformMatrixEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformMatrix_F() {
		return (EAttribute)transformMatrixEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTransformMatrix__Add__TransformMatrix() {
		return transformMatrixEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTransformMatrix__Minus() {
		return transformMatrixEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTransformMatrix__Minus__TransformMatrix() {
		return transformMatrixEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTransformMatrix__Multiply__Point() {
		return transformMatrixEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTransformMatrix__Multiply__TransformMatrix() {
		return transformMatrixEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPoint() {
		return pointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPoint_X() {
		return (EAttribute)pointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPoint_Y() {
		return (EAttribute)pointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPoint__Minus() {
		return pointEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPoint__Minus__Point() {
		return pointEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPoint__Add__Point() {
		return pointEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPoint__GetIntX() {
		return pointEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPoint__GetIntY() {
		return pointEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRhapsodyShape() {
		return rhapsodyShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRhapsodyShape_Transform() {
		return (EReference)rhapsodyShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRhapsodyShape_Rectangle() {
		return (EReference)rhapsodyShapeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRhapsodyShape_Parent() {
		return (EReference)rhapsodyShapeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRhapsodyShape_RhapsodyMetamodelObject() {
		return (EReference)rhapsodyShapeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRhapsodyShape_ParentRelativePosition() {
		return (EReference)rhapsodyShapeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRhapsodyShape_Height() {
		return (EAttribute)rhapsodyShapeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRhapsodyShape_Width() {
		return (EAttribute)rhapsodyShapeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRhapsodyShape_AbsolutePosition() {
		return (EReference)rhapsodyShapeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRectangle() {
		return rectangleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRectangle_TopLeft() {
		return (EReference)rectangleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRectangle_TopRight() {
		return (EReference)rectangleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRectangle_BottomLeft() {
		return (EReference)rectangleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRectangle_BottomRight() {
		return (EReference)rectangleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolygon() {
		return polygonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPolygon_Points() {
		return (EReference)polygonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRhapsodyPort() {
		return rhapsodyPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRhapsodyPort_Position() {
		return (EAttribute)rhapsodyPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPosition() {
		return positionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RhpGeometryFactory getRhpGeometryFactory() {
		return (RhpGeometryFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		transformMatrixEClass = createEClass(TRANSFORM_MATRIX);
		createEAttribute(transformMatrixEClass, TRANSFORM_MATRIX__A);
		createEAttribute(transformMatrixEClass, TRANSFORM_MATRIX__B);
		createEAttribute(transformMatrixEClass, TRANSFORM_MATRIX__C);
		createEAttribute(transformMatrixEClass, TRANSFORM_MATRIX__D);
		createEAttribute(transformMatrixEClass, TRANSFORM_MATRIX__E);
		createEAttribute(transformMatrixEClass, TRANSFORM_MATRIX__F);
		createEOperation(transformMatrixEClass, TRANSFORM_MATRIX___ADD__TRANSFORMMATRIX);
		createEOperation(transformMatrixEClass, TRANSFORM_MATRIX___MINUS);
		createEOperation(transformMatrixEClass, TRANSFORM_MATRIX___MINUS__TRANSFORMMATRIX);
		createEOperation(transformMatrixEClass, TRANSFORM_MATRIX___MULTIPLY__POINT);
		createEOperation(transformMatrixEClass, TRANSFORM_MATRIX___MULTIPLY__TRANSFORMMATRIX);

		pointEClass = createEClass(POINT);
		createEAttribute(pointEClass, POINT__X);
		createEAttribute(pointEClass, POINT__Y);
		createEOperation(pointEClass, POINT___MINUS);
		createEOperation(pointEClass, POINT___MINUS__POINT);
		createEOperation(pointEClass, POINT___ADD__POINT);
		createEOperation(pointEClass, POINT___GET_INT_X);
		createEOperation(pointEClass, POINT___GET_INT_Y);

		rhapsodyShapeEClass = createEClass(RHAPSODY_SHAPE);
		createEReference(rhapsodyShapeEClass, RHAPSODY_SHAPE__TRANSFORM);
		createEReference(rhapsodyShapeEClass, RHAPSODY_SHAPE__RECTANGLE);
		createEReference(rhapsodyShapeEClass, RHAPSODY_SHAPE__PARENT);
		createEReference(rhapsodyShapeEClass, RHAPSODY_SHAPE__RHAPSODY_METAMODEL_OBJECT);
		createEReference(rhapsodyShapeEClass, RHAPSODY_SHAPE__PARENT_RELATIVE_POSITION);
		createEAttribute(rhapsodyShapeEClass, RHAPSODY_SHAPE__HEIGHT);
		createEAttribute(rhapsodyShapeEClass, RHAPSODY_SHAPE__WIDTH);
		createEReference(rhapsodyShapeEClass, RHAPSODY_SHAPE__ABSOLUTE_POSITION);

		rectangleEClass = createEClass(RECTANGLE);
		createEReference(rectangleEClass, RECTANGLE__TOP_LEFT);
		createEReference(rectangleEClass, RECTANGLE__TOP_RIGHT);
		createEReference(rectangleEClass, RECTANGLE__BOTTOM_LEFT);
		createEReference(rectangleEClass, RECTANGLE__BOTTOM_RIGHT);

		polygonEClass = createEClass(POLYGON);
		createEReference(polygonEClass, POLYGON__POINTS);

		rhapsodyPortEClass = createEClass(RHAPSODY_PORT);
		createEAttribute(rhapsodyPortEClass, RHAPSODY_PORT__POSITION);

		// Create enums
		positionEEnum = createEEnum(POSITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		rectangleEClass.getESuperTypes().add(this.getPolygon());
		rhapsodyPortEClass.getESuperTypes().add(this.getRhapsodyShape());

		// Initialize classes, features, and operations; add parameters
		initEClass(transformMatrixEClass, TransformMatrix.class, "TransformMatrix", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTransformMatrix_A(), ecorePackage.getEDoubleObject(), "a", null, 1, 1, TransformMatrix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTransformMatrix_B(), ecorePackage.getEDoubleObject(), "b", null, 1, 1, TransformMatrix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTransformMatrix_C(), ecorePackage.getEDoubleObject(), "c", null, 1, 1, TransformMatrix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTransformMatrix_D(), ecorePackage.getEDoubleObject(), "d", null, 1, 1, TransformMatrix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTransformMatrix_E(), ecorePackage.getEDoubleObject(), "e", null, 1, 1, TransformMatrix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTransformMatrix_F(), ecorePackage.getEDoubleObject(), "f", null, 1, 1, TransformMatrix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		EOperation op = initEOperation(getTransformMatrix__Add__TransformMatrix(), this.getTransformMatrix(), "add", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getTransformMatrix(), "matrix", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEOperation(getTransformMatrix__Minus(), this.getTransformMatrix(), "minus", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getTransformMatrix__Minus__TransformMatrix(), this.getTransformMatrix(), "minus", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getTransformMatrix(), "matrix", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getTransformMatrix__Multiply__Point(), this.getPoint(), "multiply", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getPoint(), "point", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getTransformMatrix__Multiply__TransformMatrix(), this.getTransformMatrix(), "multiply", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getTransformMatrix(), "matrix", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(pointEClass, Point.class, "Point", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getPoint_X(), ecorePackage.getEDoubleObject(), "X", null, 1, 1, Point.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPoint_Y(), ecorePackage.getEDoubleObject(), "Y", null, 1, 1, Point.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEOperation(getPoint__Minus(), this.getPoint(), "minus", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getPoint__Minus__Point(), this.getPoint(), "minus", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getPoint(), "point", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getPoint__Add__Point(), this.getPoint(), "add", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getPoint(), "point", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEOperation(getPoint__GetIntX(), ecorePackage.getEIntegerObject(), "getIntX", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEOperation(getPoint__GetIntY(), ecorePackage.getEIntegerObject(), "getIntY", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(rhapsodyShapeEClass, RhapsodyShape.class, "RhapsodyShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getRhapsodyShape_Transform(), this.getTransformMatrix(), null, "transform", null, 1, 1, RhapsodyShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getRhapsodyShape_Rectangle(), this.getRectangle(), null, "rectangle", null, 1, 1, RhapsodyShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getRhapsodyShape_Parent(), this.getRhapsodyShape(), null, "parent", null, 0, 1, RhapsodyShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getRhapsodyShape_RhapsodyMetamodelObject(), theEcorePackage.getEObject(), null, "rhapsodyMetamodelObject", null, 1, 1, RhapsodyShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getRhapsodyShape_ParentRelativePosition(), this.getPoint(), null, "parentRelativePosition", null, 1, 1, RhapsodyShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getRhapsodyShape_Height(), ecorePackage.getEIntegerObject(), "height", null, 1, 1, RhapsodyShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getRhapsodyShape_Width(), ecorePackage.getEIntegerObject(), "width", null, 1, 1, RhapsodyShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getRhapsodyShape_AbsolutePosition(), this.getPoint(), null, "absolutePosition", null, 1, 1, RhapsodyShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(rectangleEClass, Rectangle.class, "Rectangle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getRectangle_TopLeft(), this.getPoint(), null, "topLeft", null, 1, 1, Rectangle.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getRectangle_TopRight(), this.getPoint(), null, "topRight", null, 1, 1, Rectangle.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getRectangle_BottomLeft(), this.getPoint(), null, "bottomLeft", null, 1, 1, Rectangle.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getRectangle_BottomRight(), this.getPoint(), null, "bottomRight", null, 1, 1, Rectangle.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(polygonEClass, Polygon.class, "Polygon", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPolygon_Points(), this.getPoint(), null, "points", null, 1, -1, Polygon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(rhapsodyPortEClass, RhapsodyPort.class, "RhapsodyPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getRhapsodyPort_Position(), this.getPosition(), "position", null, 1, 1, RhapsodyPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(positionEEnum, Position.class, "Position"); //$NON-NLS-1$
		addEEnumLiteral(positionEEnum, Position.NORTH);
		addEEnumLiteral(positionEEnum, Position.SOUTH);
		addEEnumLiteral(positionEEnum, Position.EAST);
		addEEnumLiteral(positionEEnum, Position.WEST);
		addEEnumLiteral(positionEEnum, Position.NORTH_EAST);
		addEEnumLiteral(positionEEnum, Position.NORTH_WEST);
		addEEnumLiteral(positionEEnum, Position.SOUTH_EAST);
		addEEnumLiteral(positionEEnum, Position.SOUTH_WEST);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML"; //$NON-NLS-1$	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "originalName", "RhapsodyGeometry" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //RhpGeometryPackageImpl
