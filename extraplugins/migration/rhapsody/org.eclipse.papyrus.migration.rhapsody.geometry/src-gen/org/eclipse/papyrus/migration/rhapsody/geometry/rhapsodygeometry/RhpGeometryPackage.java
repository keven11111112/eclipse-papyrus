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
package org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='RhapsodyGeometry'"
 * @generated
 */
public interface RhpGeometryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "rhapsodygeometry"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/rhpgeometry/1.0.0"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "rhpgeom"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RhpGeometryPackage eINSTANCE = org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhpGeometryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.TransformMatrixImpl <em>Transform Matrix</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.TransformMatrixImpl
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhpGeometryPackageImpl#getTransformMatrix()
	 * @generated
	 */
	int TRANSFORM_MATRIX = 0;

	/**
	 * The feature id for the '<em><b>A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_MATRIX__A = 0;

	/**
	 * The feature id for the '<em><b>B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_MATRIX__B = 1;

	/**
	 * The feature id for the '<em><b>C</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_MATRIX__C = 2;

	/**
	 * The feature id for the '<em><b>D</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_MATRIX__D = 3;

	/**
	 * The feature id for the '<em><b>E</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_MATRIX__E = 4;

	/**
	 * The feature id for the '<em><b>F</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_MATRIX__F = 5;

	/**
	 * The number of structural features of the '<em>Transform Matrix</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_MATRIX_FEATURE_COUNT = 6;

	/**
	 * The operation id for the '<em>Add</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_MATRIX___ADD__TRANSFORMMATRIX = 0;

	/**
	 * The operation id for the '<em>Minus</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_MATRIX___MINUS = 1;

	/**
	 * The operation id for the '<em>Minus</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_MATRIX___MINUS__TRANSFORMMATRIX = 2;

	/**
	 * The operation id for the '<em>Multiply</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_MATRIX___MULTIPLY__POINT = 3;

	/**
	 * The operation id for the '<em>Multiply</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_MATRIX___MULTIPLY__TRANSFORMMATRIX = 4;

	/**
	 * The number of operations of the '<em>Transform Matrix</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_MATRIX_OPERATION_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.PointImpl <em>Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.PointImpl
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhpGeometryPackageImpl#getPoint()
	 * @generated
	 */
	int POINT = 1;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__Y = 1;

	/**
	 * The number of structural features of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Minus</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT___MINUS = 0;

	/**
	 * The operation id for the '<em>Minus</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT___MINUS__POINT = 1;

	/**
	 * The operation id for the '<em>Add</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT___ADD__POINT = 2;

	/**
	 * The operation id for the '<em>Get Int X</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT___GET_INT_X = 3;

	/**
	 * The operation id for the '<em>Get Int Y</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT___GET_INT_Y = 4;

	/**
	 * The number of operations of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_OPERATION_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhapsodyShapeImpl <em>Rhapsody Shape</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhapsodyShapeImpl
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhpGeometryPackageImpl#getRhapsodyShape()
	 * @generated
	 */
	int RHAPSODY_SHAPE = 2;

	/**
	 * The feature id for the '<em><b>Transform</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_SHAPE__TRANSFORM = 0;

	/**
	 * The feature id for the '<em><b>Rectangle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_SHAPE__RECTANGLE = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_SHAPE__PARENT = 2;

	/**
	 * The feature id for the '<em><b>Rhapsody Metamodel Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_SHAPE__RHAPSODY_METAMODEL_OBJECT = 3;

	/**
	 * The feature id for the '<em><b>Parent Relative Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_SHAPE__PARENT_RELATIVE_POSITION = 4;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_SHAPE__HEIGHT = 5;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_SHAPE__WIDTH = 6;

	/**
	 * The feature id for the '<em><b>Absolute Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_SHAPE__ABSOLUTE_POSITION = 7;

	/**
	 * The number of structural features of the '<em>Rhapsody Shape</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_SHAPE_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Rhapsody Shape</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_SHAPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.PolygonImpl <em>Polygon</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.PolygonImpl
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhpGeometryPackageImpl#getPolygon()
	 * @generated
	 */
	int POLYGON = 4;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYGON__POINTS = 0;

	/**
	 * The number of structural features of the '<em>Polygon</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYGON_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Polygon</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYGON_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RectangleImpl <em>Rectangle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RectangleImpl
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhpGeometryPackageImpl#getRectangle()
	 * @generated
	 */
	int RECTANGLE = 3;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__POINTS = POLYGON__POINTS;

	/**
	 * The feature id for the '<em><b>Top Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__TOP_LEFT = POLYGON_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Top Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__TOP_RIGHT = POLYGON_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bottom Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__BOTTOM_LEFT = POLYGON_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Bottom Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__BOTTOM_RIGHT = POLYGON_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Rectangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_FEATURE_COUNT = POLYGON_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Rectangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_OPERATION_COUNT = POLYGON_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhapsodyPortImpl <em>Rhapsody Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhapsodyPortImpl
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhpGeometryPackageImpl#getRhapsodyPort()
	 * @generated
	 */
	int RHAPSODY_PORT = 5;

	/**
	 * The feature id for the '<em><b>Transform</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_PORT__TRANSFORM = RHAPSODY_SHAPE__TRANSFORM;

	/**
	 * The feature id for the '<em><b>Rectangle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_PORT__RECTANGLE = RHAPSODY_SHAPE__RECTANGLE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_PORT__PARENT = RHAPSODY_SHAPE__PARENT;

	/**
	 * The feature id for the '<em><b>Rhapsody Metamodel Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_PORT__RHAPSODY_METAMODEL_OBJECT = RHAPSODY_SHAPE__RHAPSODY_METAMODEL_OBJECT;

	/**
	 * The feature id for the '<em><b>Parent Relative Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_PORT__PARENT_RELATIVE_POSITION = RHAPSODY_SHAPE__PARENT_RELATIVE_POSITION;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_PORT__HEIGHT = RHAPSODY_SHAPE__HEIGHT;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_PORT__WIDTH = RHAPSODY_SHAPE__WIDTH;

	/**
	 * The feature id for the '<em><b>Absolute Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_PORT__ABSOLUTE_POSITION = RHAPSODY_SHAPE__ABSOLUTE_POSITION;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_PORT__POSITION = RHAPSODY_SHAPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rhapsody Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_PORT_FEATURE_COUNT = RHAPSODY_SHAPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Rhapsody Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHAPSODY_PORT_OPERATION_COUNT = RHAPSODY_SHAPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Position <em>Position</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Position
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhpGeometryPackageImpl#getPosition()
	 * @generated
	 */
	int POSITION = 6;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix <em>Transform Matrix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transform Matrix</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix
	 * @generated
	 */
	EClass getTransformMatrix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#getA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>A</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#getA()
	 * @see #getTransformMatrix()
	 * @generated
	 */
	EAttribute getTransformMatrix_A();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#getB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>B</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#getB()
	 * @see #getTransformMatrix()
	 * @generated
	 */
	EAttribute getTransformMatrix_B();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#getC <em>C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>C</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#getC()
	 * @see #getTransformMatrix()
	 * @generated
	 */
	EAttribute getTransformMatrix_C();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#getD <em>D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>D</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#getD()
	 * @see #getTransformMatrix()
	 * @generated
	 */
	EAttribute getTransformMatrix_D();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#getE <em>E</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>E</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#getE()
	 * @see #getTransformMatrix()
	 * @generated
	 */
	EAttribute getTransformMatrix_E();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#getF <em>F</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>F</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#getF()
	 * @see #getTransformMatrix()
	 * @generated
	 */
	EAttribute getTransformMatrix_F();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#add(org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix) <em>Add</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add</em>' operation.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#add(org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix)
	 * @generated
	 */
	EOperation getTransformMatrix__Add__TransformMatrix();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#minus() <em>Minus</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Minus</em>' operation.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#minus()
	 * @generated
	 */
	EOperation getTransformMatrix__Minus();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#minus(org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix) <em>Minus</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Minus</em>' operation.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#minus(org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix)
	 * @generated
	 */
	EOperation getTransformMatrix__Minus__TransformMatrix();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#multiply(org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point) <em>Multiply</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Multiply</em>' operation.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#multiply(org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point)
	 * @generated
	 */
	EOperation getTransformMatrix__Multiply__Point();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#multiply(org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix) <em>Multiply</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Multiply</em>' operation.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix#multiply(org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix)
	 * @generated
	 */
	EOperation getTransformMatrix__Multiply__TransformMatrix();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point
	 * @generated
	 */
	EClass getPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point#getX()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point#getY()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_Y();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point#minus() <em>Minus</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Minus</em>' operation.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point#minus()
	 * @generated
	 */
	EOperation getPoint__Minus();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point#minus(org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point) <em>Minus</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Minus</em>' operation.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point#minus(org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point)
	 * @generated
	 */
	EOperation getPoint__Minus__Point();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point#add(org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point) <em>Add</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add</em>' operation.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point#add(org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point)
	 * @generated
	 */
	EOperation getPoint__Add__Point();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point#getIntX() <em>Get Int X</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Int X</em>' operation.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point#getIntX()
	 * @generated
	 */
	EOperation getPoint__GetIntX();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point#getIntY() <em>Get Int Y</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Int Y</em>' operation.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point#getIntY()
	 * @generated
	 */
	EOperation getPoint__GetIntY();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape <em>Rhapsody Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rhapsody Shape</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape
	 * @generated
	 */
	EClass getRhapsodyShape();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getTransform <em>Transform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Transform</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getTransform()
	 * @see #getRhapsodyShape()
	 * @generated
	 */
	EReference getRhapsodyShape_Transform();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getRectangle <em>Rectangle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rectangle</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getRectangle()
	 * @see #getRhapsodyShape()
	 * @generated
	 */
	EReference getRhapsodyShape_Rectangle();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getParent()
	 * @see #getRhapsodyShape()
	 * @generated
	 */
	EReference getRhapsodyShape_Parent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getRhapsodyMetamodelObject <em>Rhapsody Metamodel Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rhapsody Metamodel Object</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getRhapsodyMetamodelObject()
	 * @see #getRhapsodyShape()
	 * @generated
	 */
	EReference getRhapsodyShape_RhapsodyMetamodelObject();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getParentRelativePosition <em>Parent Relative Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parent Relative Position</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getParentRelativePosition()
	 * @see #getRhapsodyShape()
	 * @generated
	 */
	EReference getRhapsodyShape_ParentRelativePosition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getHeight()
	 * @see #getRhapsodyShape()
	 * @generated
	 */
	EAttribute getRhapsodyShape_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getWidth()
	 * @see #getRhapsodyShape()
	 * @generated
	 */
	EAttribute getRhapsodyShape_Width();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getAbsolutePosition <em>Absolute Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Absolute Position</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getAbsolutePosition()
	 * @see #getRhapsodyShape()
	 * @generated
	 */
	EReference getRhapsodyShape_AbsolutePosition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle <em>Rectangle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rectangle</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle
	 * @generated
	 */
	EClass getRectangle();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getTopLeft <em>Top Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Top Left</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getTopLeft()
	 * @see #getRectangle()
	 * @generated
	 */
	EReference getRectangle_TopLeft();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getTopRight <em>Top Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Top Right</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getTopRight()
	 * @see #getRectangle()
	 * @generated
	 */
	EReference getRectangle_TopRight();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getBottomLeft <em>Bottom Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bottom Left</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getBottomLeft()
	 * @see #getRectangle()
	 * @generated
	 */
	EReference getRectangle_BottomLeft();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getBottomRight <em>Bottom Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bottom Right</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Rectangle#getBottomRight()
	 * @see #getRectangle()
	 * @generated
	 */
	EReference getRectangle_BottomRight();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Polygon <em>Polygon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Polygon</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Polygon
	 * @generated
	 */
	EClass getPolygon();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Polygon#getPoints <em>Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Points</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Polygon#getPoints()
	 * @see #getPolygon()
	 * @generated
	 */
	EReference getPolygon_Points();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyPort <em>Rhapsody Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rhapsody Port</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyPort
	 * @generated
	 */
	EClass getRhapsodyPort();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyPort#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyPort#getPosition()
	 * @see #getRhapsodyPort()
	 * @generated
	 */
	EAttribute getRhapsodyPort_Position();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Position <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Position</em>'.
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Position
	 * @generated
	 */
	EEnum getPosition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RhpGeometryFactory getRhpGeometryFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.TransformMatrixImpl <em>Transform Matrix</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.TransformMatrixImpl
		 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhpGeometryPackageImpl#getTransformMatrix()
		 * @generated
		 */
		EClass TRANSFORM_MATRIX = eINSTANCE.getTransformMatrix();

		/**
		 * The meta object literal for the '<em><b>A</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORM_MATRIX__A = eINSTANCE.getTransformMatrix_A();

		/**
		 * The meta object literal for the '<em><b>B</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORM_MATRIX__B = eINSTANCE.getTransformMatrix_B();

		/**
		 * The meta object literal for the '<em><b>C</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORM_MATRIX__C = eINSTANCE.getTransformMatrix_C();

		/**
		 * The meta object literal for the '<em><b>D</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORM_MATRIX__D = eINSTANCE.getTransformMatrix_D();

		/**
		 * The meta object literal for the '<em><b>E</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORM_MATRIX__E = eINSTANCE.getTransformMatrix_E();

		/**
		 * The meta object literal for the '<em><b>F</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORM_MATRIX__F = eINSTANCE.getTransformMatrix_F();

		/**
		 * The meta object literal for the '<em><b>Add</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRANSFORM_MATRIX___ADD__TRANSFORMMATRIX = eINSTANCE.getTransformMatrix__Add__TransformMatrix();

		/**
		 * The meta object literal for the '<em><b>Minus</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRANSFORM_MATRIX___MINUS = eINSTANCE.getTransformMatrix__Minus();

		/**
		 * The meta object literal for the '<em><b>Minus</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRANSFORM_MATRIX___MINUS__TRANSFORMMATRIX = eINSTANCE.getTransformMatrix__Minus__TransformMatrix();

		/**
		 * The meta object literal for the '<em><b>Multiply</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRANSFORM_MATRIX___MULTIPLY__POINT = eINSTANCE.getTransformMatrix__Multiply__Point();

		/**
		 * The meta object literal for the '<em><b>Multiply</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRANSFORM_MATRIX___MULTIPLY__TRANSFORMMATRIX = eINSTANCE.getTransformMatrix__Multiply__TransformMatrix();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.PointImpl <em>Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.PointImpl
		 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhpGeometryPackageImpl#getPoint()
		 * @generated
		 */
		EClass POINT = eINSTANCE.getPoint();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__X = eINSTANCE.getPoint_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__Y = eINSTANCE.getPoint_Y();

		/**
		 * The meta object literal for the '<em><b>Minus</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POINT___MINUS = eINSTANCE.getPoint__Minus();

		/**
		 * The meta object literal for the '<em><b>Minus</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POINT___MINUS__POINT = eINSTANCE.getPoint__Minus__Point();

		/**
		 * The meta object literal for the '<em><b>Add</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POINT___ADD__POINT = eINSTANCE.getPoint__Add__Point();

		/**
		 * The meta object literal for the '<em><b>Get Int X</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POINT___GET_INT_X = eINSTANCE.getPoint__GetIntX();

		/**
		 * The meta object literal for the '<em><b>Get Int Y</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation POINT___GET_INT_Y = eINSTANCE.getPoint__GetIntY();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhapsodyShapeImpl <em>Rhapsody Shape</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhapsodyShapeImpl
		 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhpGeometryPackageImpl#getRhapsodyShape()
		 * @generated
		 */
		EClass RHAPSODY_SHAPE = eINSTANCE.getRhapsodyShape();

		/**
		 * The meta object literal for the '<em><b>Transform</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RHAPSODY_SHAPE__TRANSFORM = eINSTANCE.getRhapsodyShape_Transform();

		/**
		 * The meta object literal for the '<em><b>Rectangle</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RHAPSODY_SHAPE__RECTANGLE = eINSTANCE.getRhapsodyShape_Rectangle();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RHAPSODY_SHAPE__PARENT = eINSTANCE.getRhapsodyShape_Parent();

		/**
		 * The meta object literal for the '<em><b>Rhapsody Metamodel Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RHAPSODY_SHAPE__RHAPSODY_METAMODEL_OBJECT = eINSTANCE.getRhapsodyShape_RhapsodyMetamodelObject();

		/**
		 * The meta object literal for the '<em><b>Parent Relative Position</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RHAPSODY_SHAPE__PARENT_RELATIVE_POSITION = eINSTANCE.getRhapsodyShape_ParentRelativePosition();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RHAPSODY_SHAPE__HEIGHT = eINSTANCE.getRhapsodyShape_Height();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RHAPSODY_SHAPE__WIDTH = eINSTANCE.getRhapsodyShape_Width();

		/**
		 * The meta object literal for the '<em><b>Absolute Position</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RHAPSODY_SHAPE__ABSOLUTE_POSITION = eINSTANCE.getRhapsodyShape_AbsolutePosition();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RectangleImpl <em>Rectangle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RectangleImpl
		 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhpGeometryPackageImpl#getRectangle()
		 * @generated
		 */
		EClass RECTANGLE = eINSTANCE.getRectangle();

		/**
		 * The meta object literal for the '<em><b>Top Left</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECTANGLE__TOP_LEFT = eINSTANCE.getRectangle_TopLeft();

		/**
		 * The meta object literal for the '<em><b>Top Right</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECTANGLE__TOP_RIGHT = eINSTANCE.getRectangle_TopRight();

		/**
		 * The meta object literal for the '<em><b>Bottom Left</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECTANGLE__BOTTOM_LEFT = eINSTANCE.getRectangle_BottomLeft();

		/**
		 * The meta object literal for the '<em><b>Bottom Right</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECTANGLE__BOTTOM_RIGHT = eINSTANCE.getRectangle_BottomRight();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.PolygonImpl <em>Polygon</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.PolygonImpl
		 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhpGeometryPackageImpl#getPolygon()
		 * @generated
		 */
		EClass POLYGON = eINSTANCE.getPolygon();

		/**
		 * The meta object literal for the '<em><b>Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POLYGON__POINTS = eINSTANCE.getPolygon_Points();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhapsodyPortImpl <em>Rhapsody Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhapsodyPortImpl
		 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhpGeometryPackageImpl#getRhapsodyPort()
		 * @generated
		 */
		EClass RHAPSODY_PORT = eINSTANCE.getRhapsodyPort();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RHAPSODY_PORT__POSITION = eINSTANCE.getRhapsodyPort_Position();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Position <em>Position</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Position
		 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.RhpGeometryPackageImpl#getPosition()
		 * @generated
		 */
		EEnum POSITION = eINSTANCE.getPosition();

	}

} //RhpGeometryPackage
