/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Std_datatypesFactory
 * @model kind="package"
 * @generated
 */
public interface Std_datatypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "std_datatypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///RobotMLLibraries/RobotML_ModelLibrary/RobotML_DataTypes/std_datatypes.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Std_datatypesPackage eINSTANCE = org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.HeaderImpl <em>Header</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.HeaderImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getHeader()
	 * @generated
	 */
	int HEADER = 0;

	/**
	 * The feature id for the '<em><b>Seq</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER__SEQ = 0;

	/**
	 * The feature id for the '<em><b>Stamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER__STAMP = 1;

	/**
	 * The feature id for the '<em><b>Frame id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER__FRAME_ID = 2;

	/**
	 * The number of structural features of the '<em>Header</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Header</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.MultiArrayDimensionImpl <em>Multi Array Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.MultiArrayDimensionImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getMultiArrayDimension()
	 * @generated
	 */
	int MULTI_ARRAY_DIMENSION = 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ARRAY_DIMENSION__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ARRAY_DIMENSION__SIZE = 1;

	/**
	 * The feature id for the '<em><b>Stride</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ARRAY_DIMENSION__STRIDE = 2;

	/**
	 * The number of structural features of the '<em>Multi Array Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ARRAY_DIMENSION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Multi Array Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ARRAY_DIMENSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.MultiArrayLayoutImpl <em>Multi Array Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.MultiArrayLayoutImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getMultiArrayLayout()
	 * @generated
	 */
	int MULTI_ARRAY_LAYOUT = 2;

	/**
	 * The feature id for the '<em><b>Dim</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ARRAY_LAYOUT__DIM = 0;

	/**
	 * The feature id for the '<em><b>Data offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ARRAY_LAYOUT__DATA_OFFSET = 1;

	/**
	 * The number of structural features of the '<em>Multi Array Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ARRAY_LAYOUT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Multi Array Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ARRAY_LAYOUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.ByteMultiArrayImpl <em>Byte Multi Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.ByteMultiArrayImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getByteMultiArray()
	 * @generated
	 */
	int BYTE_MULTI_ARRAY = 3;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_MULTI_ARRAY__LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_MULTI_ARRAY__DATA = 1;

	/**
	 * The number of structural features of the '<em>Byte Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_MULTI_ARRAY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Byte Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_MULTI_ARRAY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.ColorRGBAImpl <em>Color RGBA</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.ColorRGBAImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getColorRGBA()
	 * @generated
	 */
	int COLOR_RGBA = 4;

	/**
	 * The feature id for the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_RGBA__R = 0;

	/**
	 * The feature id for the '<em><b>G</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_RGBA__G = 1;

	/**
	 * The feature id for the '<em><b>B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_RGBA__B = 2;

	/**
	 * The feature id for the '<em><b>A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_RGBA__A = 3;

	/**
	 * The number of structural features of the '<em>Color RGBA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_RGBA_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Color RGBA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_RGBA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Float32MultiArrayImpl <em>Float32 Multi Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Float32MultiArrayImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getFloat32MultiArray()
	 * @generated
	 */
	int FLOAT32_MULTI_ARRAY = 5;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT32_MULTI_ARRAY__LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT32_MULTI_ARRAY__DATA = 1;

	/**
	 * The number of structural features of the '<em>Float32 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT32_MULTI_ARRAY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Float32 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT32_MULTI_ARRAY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Int32MultiArrayImpl <em>Int32 Multi Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Int32MultiArrayImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getInt32MultiArray()
	 * @generated
	 */
	int INT32_MULTI_ARRAY = 6;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT32_MULTI_ARRAY__LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT32_MULTI_ARRAY__DATA = 1;

	/**
	 * The number of structural features of the '<em>Int32 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT32_MULTI_ARRAY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Int32 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT32_MULTI_ARRAY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Int8MultiArrayImpl <em>Int8 Multi Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Int8MultiArrayImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getInt8MultiArray()
	 * @generated
	 */
	int INT8_MULTI_ARRAY = 7;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT8_MULTI_ARRAY__LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT8_MULTI_ARRAY__DATA = 1;

	/**
	 * The number of structural features of the '<em>Int8 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT8_MULTI_ARRAY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Int8 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT8_MULTI_ARRAY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Int16MultiArrayImpl <em>Int16 Multi Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Int16MultiArrayImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getInt16MultiArray()
	 * @generated
	 */
	int INT16_MULTI_ARRAY = 8;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT16_MULTI_ARRAY__LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT16_MULTI_ARRAY__DATA = 1;

	/**
	 * The number of structural features of the '<em>Int16 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT16_MULTI_ARRAY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Int16 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT16_MULTI_ARRAY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Int64MultiArrayImpl <em>Int64 Multi Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Int64MultiArrayImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getInt64MultiArray()
	 * @generated
	 */
	int INT64_MULTI_ARRAY = 9;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT64_MULTI_ARRAY__LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT64_MULTI_ARRAY__DATA = 1;

	/**
	 * The number of structural features of the '<em>Int64 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT64_MULTI_ARRAY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Int64 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT64_MULTI_ARRAY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Float64MultiArrayImpl <em>Float64 Multi Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Float64MultiArrayImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getFloat64MultiArray()
	 * @generated
	 */
	int FLOAT64_MULTI_ARRAY = 10;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT64_MULTI_ARRAY__LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT64_MULTI_ARRAY__DATA = 1;

	/**
	 * The number of structural features of the '<em>Float64 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT64_MULTI_ARRAY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Float64 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT64_MULTI_ARRAY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.UInt64MultiArrayImpl <em>UInt64 Multi Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.UInt64MultiArrayImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getUInt64MultiArray()
	 * @generated
	 */
	int UINT64_MULTI_ARRAY = 11;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINT64_MULTI_ARRAY__LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINT64_MULTI_ARRAY__DATA = 1;

	/**
	 * The number of structural features of the '<em>UInt64 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINT64_MULTI_ARRAY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>UInt64 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINT64_MULTI_ARRAY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.UInt16MultiArrayImpl <em>UInt16 Multi Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.UInt16MultiArrayImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getUInt16MultiArray()
	 * @generated
	 */
	int UINT16_MULTI_ARRAY = 12;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINT16_MULTI_ARRAY__LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINT16_MULTI_ARRAY__DATA = 1;

	/**
	 * The number of structural features of the '<em>UInt16 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINT16_MULTI_ARRAY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>UInt16 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINT16_MULTI_ARRAY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.UInt32MultiArrayImpl <em>UInt32 Multi Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.UInt32MultiArrayImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getUInt32MultiArray()
	 * @generated
	 */
	int UINT32_MULTI_ARRAY = 13;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINT32_MULTI_ARRAY__LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINT32_MULTI_ARRAY__DATA = 1;

	/**
	 * The number of structural features of the '<em>UInt32 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINT32_MULTI_ARRAY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>UInt32 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINT32_MULTI_ARRAY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.UInt8MultiArrayImpl <em>UInt8 Multi Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.UInt8MultiArrayImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getUInt8MultiArray()
	 * @generated
	 */
	int UINT8_MULTI_ARRAY = 14;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINT8_MULTI_ARRAY__LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINT8_MULTI_ARRAY__DATA = 1;

	/**
	 * The number of structural features of the '<em>UInt8 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINT8_MULTI_ARRAY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>UInt8 Multi Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UINT8_MULTI_ARRAY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>UInt32</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see UInt32
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getUInt32()
	 * @generated
	 */
	int UINT32 = 15;

	/**
	 * The meta object id for the '<em>Time</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Time
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getTime()
	 * @generated
	 */
	int TIME = 16;

	/**
	 * The meta object id for the '<em>String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see String
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getString()
	 * @generated
	 */
	int STRING = 17;

	/**
	 * The meta object id for the '<em>Byte</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Byte
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getByte()
	 * @generated
	 */
	int BYTE = 18;

	/**
	 * The meta object id for the '<em>Float64</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Float64
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getFloat64()
	 * @generated
	 */
	int FLOAT64 = 19;

	/**
	 * The meta object id for the '<em>Int8</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Int8
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getInt8()
	 * @generated
	 */
	int INT8 = 20;

	/**
	 * The meta object id for the '<em>Bool</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Bool
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getBool()
	 * @generated
	 */
	int BOOL = 21;

	/**
	 * The meta object id for the '<em>UInt8</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see UInt8
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getUInt8()
	 * @generated
	 */
	int UINT8 = 22;

	/**
	 * The meta object id for the '<em>UInt16</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see UInt16
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getUInt16()
	 * @generated
	 */
	int UINT16 = 23;

	/**
	 * The meta object id for the '<em>Int32</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Int32
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getInt32()
	 * @generated
	 */
	int INT32 = 24;

	/**
	 * The meta object id for the '<em>Int16</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Int16
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getInt16()
	 * @generated
	 */
	int INT16 = 25;

	/**
	 * The meta object id for the '<em>Char</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Char
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getChar()
	 * @generated
	 */
	int CHAR = 26;

	/**
	 * The meta object id for the '<em>Duration</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Duration
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getDuration()
	 * @generated
	 */
	int DURATION = 27;

	/**
	 * The meta object id for the '<em>Int64</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Int64
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getInt64()
	 * @generated
	 */
	int INT64 = 28;

	/**
	 * The meta object id for the '<em>UInt64</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see UInt64
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getUInt64()
	 * @generated
	 */
	int UINT64 = 29;

	/**
	 * The meta object id for the '<em>Float32</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Float32
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getFloat32()
	 * @generated
	 */
	int FLOAT32 = 30;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Header</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header
	 * @generated
	 */
	EClass getHeader();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header#getSeq <em>Seq</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seq</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header#getSeq()
	 * @see #getHeader()
	 * @generated
	 */
	EAttribute getHeader_Seq();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header#getStamp <em>Stamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stamp</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header#getStamp()
	 * @see #getHeader()
	 * @generated
	 */
	EAttribute getHeader_Stamp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header#getFrame_id <em>Frame id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frame id</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header#getFrame_id()
	 * @see #getHeader()
	 * @generated
	 */
	EAttribute getHeader_Frame_id();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.MultiArrayDimension <em>Multi Array Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Array Dimension</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.MultiArrayDimension
	 * @generated
	 */
	EClass getMultiArrayDimension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.MultiArrayDimension#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.MultiArrayDimension#getLabel()
	 * @see #getMultiArrayDimension()
	 * @generated
	 */
	EAttribute getMultiArrayDimension_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.MultiArrayDimension#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.MultiArrayDimension#getSize()
	 * @see #getMultiArrayDimension()
	 * @generated
	 */
	EAttribute getMultiArrayDimension_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.MultiArrayDimension#getStride <em>Stride</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stride</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.MultiArrayDimension#getStride()
	 * @see #getMultiArrayDimension()
	 * @generated
	 */
	EAttribute getMultiArrayDimension_Stride();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.MultiArrayLayout <em>Multi Array Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Array Layout</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.MultiArrayLayout
	 * @generated
	 */
	EClass getMultiArrayLayout();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.MultiArrayLayout#getDim <em>Dim</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dim</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.MultiArrayLayout#getDim()
	 * @see #getMultiArrayLayout()
	 * @generated
	 */
	EReference getMultiArrayLayout_Dim();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.MultiArrayLayout#getData_offset <em>Data offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data offset</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.MultiArrayLayout#getData_offset()
	 * @see #getMultiArrayLayout()
	 * @generated
	 */
	EAttribute getMultiArrayLayout_Data_offset();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.ByteMultiArray <em>Byte Multi Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Byte Multi Array</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.ByteMultiArray
	 * @generated
	 */
	EClass getByteMultiArray();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.ByteMultiArray#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Layout</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.ByteMultiArray#getLayout()
	 * @see #getByteMultiArray()
	 * @generated
	 */
	EReference getByteMultiArray_Layout();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.ByteMultiArray#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Data</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.ByteMultiArray#getData()
	 * @see #getByteMultiArray()
	 * @generated
	 */
	EAttribute getByteMultiArray_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.ColorRGBA <em>Color RGBA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color RGBA</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.ColorRGBA
	 * @generated
	 */
	EClass getColorRGBA();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.ColorRGBA#getR <em>R</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>R</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.ColorRGBA#getR()
	 * @see #getColorRGBA()
	 * @generated
	 */
	EAttribute getColorRGBA_R();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.ColorRGBA#getG <em>G</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>G</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.ColorRGBA#getG()
	 * @see #getColorRGBA()
	 * @generated
	 */
	EAttribute getColorRGBA_G();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.ColorRGBA#getB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>B</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.ColorRGBA#getB()
	 * @see #getColorRGBA()
	 * @generated
	 */
	EAttribute getColorRGBA_B();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.ColorRGBA#getA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>A</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.ColorRGBA#getA()
	 * @see #getColorRGBA()
	 * @generated
	 */
	EAttribute getColorRGBA_A();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32MultiArray <em>Float32 Multi Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Float32 Multi Array</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32MultiArray
	 * @generated
	 */
	EClass getFloat32MultiArray();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32MultiArray#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Layout</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32MultiArray#getLayout()
	 * @see #getFloat32MultiArray()
	 * @generated
	 */
	EReference getFloat32MultiArray_Layout();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32MultiArray#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Data</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32MultiArray#getData()
	 * @see #getFloat32MultiArray()
	 * @generated
	 */
	EAttribute getFloat32MultiArray_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int32MultiArray <em>Int32 Multi Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int32 Multi Array</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int32MultiArray
	 * @generated
	 */
	EClass getInt32MultiArray();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int32MultiArray#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Layout</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int32MultiArray#getLayout()
	 * @see #getInt32MultiArray()
	 * @generated
	 */
	EReference getInt32MultiArray_Layout();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int32MultiArray#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Data</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int32MultiArray#getData()
	 * @see #getInt32MultiArray()
	 * @generated
	 */
	EAttribute getInt32MultiArray_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int8MultiArray <em>Int8 Multi Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int8 Multi Array</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int8MultiArray
	 * @generated
	 */
	EClass getInt8MultiArray();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int8MultiArray#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Layout</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int8MultiArray#getLayout()
	 * @see #getInt8MultiArray()
	 * @generated
	 */
	EReference getInt8MultiArray_Layout();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int8MultiArray#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Data</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int8MultiArray#getData()
	 * @see #getInt8MultiArray()
	 * @generated
	 */
	EAttribute getInt8MultiArray_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int16MultiArray <em>Int16 Multi Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int16 Multi Array</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int16MultiArray
	 * @generated
	 */
	EClass getInt16MultiArray();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int16MultiArray#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Layout</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int16MultiArray#getLayout()
	 * @see #getInt16MultiArray()
	 * @generated
	 */
	EReference getInt16MultiArray_Layout();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int16MultiArray#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Data</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int16MultiArray#getData()
	 * @see #getInt16MultiArray()
	 * @generated
	 */
	EAttribute getInt16MultiArray_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int64MultiArray <em>Int64 Multi Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int64 Multi Array</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int64MultiArray
	 * @generated
	 */
	EClass getInt64MultiArray();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int64MultiArray#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Layout</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int64MultiArray#getLayout()
	 * @see #getInt64MultiArray()
	 * @generated
	 */
	EReference getInt64MultiArray_Layout();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int64MultiArray#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Data</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Int64MultiArray#getData()
	 * @see #getInt64MultiArray()
	 * @generated
	 */
	EAttribute getInt64MultiArray_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float64MultiArray <em>Float64 Multi Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Float64 Multi Array</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float64MultiArray
	 * @generated
	 */
	EClass getFloat64MultiArray();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float64MultiArray#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Layout</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float64MultiArray#getLayout()
	 * @see #getFloat64MultiArray()
	 * @generated
	 */
	EReference getFloat64MultiArray_Layout();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float64MultiArray#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Data</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float64MultiArray#getData()
	 * @see #getFloat64MultiArray()
	 * @generated
	 */
	EAttribute getFloat64MultiArray_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt64MultiArray <em>UInt64 Multi Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UInt64 Multi Array</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt64MultiArray
	 * @generated
	 */
	EClass getUInt64MultiArray();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt64MultiArray#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Layout</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt64MultiArray#getLayout()
	 * @see #getUInt64MultiArray()
	 * @generated
	 */
	EReference getUInt64MultiArray_Layout();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt64MultiArray#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Data</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt64MultiArray#getData()
	 * @see #getUInt64MultiArray()
	 * @generated
	 */
	EAttribute getUInt64MultiArray_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt16MultiArray <em>UInt16 Multi Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UInt16 Multi Array</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt16MultiArray
	 * @generated
	 */
	EClass getUInt16MultiArray();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt16MultiArray#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Layout</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt16MultiArray#getLayout()
	 * @see #getUInt16MultiArray()
	 * @generated
	 */
	EReference getUInt16MultiArray_Layout();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt16MultiArray#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Data</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt16MultiArray#getData()
	 * @see #getUInt16MultiArray()
	 * @generated
	 */
	EAttribute getUInt16MultiArray_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt32MultiArray <em>UInt32 Multi Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UInt32 Multi Array</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt32MultiArray
	 * @generated
	 */
	EClass getUInt32MultiArray();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt32MultiArray#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Layout</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt32MultiArray#getLayout()
	 * @see #getUInt32MultiArray()
	 * @generated
	 */
	EReference getUInt32MultiArray_Layout();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt32MultiArray#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Data</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt32MultiArray#getData()
	 * @see #getUInt32MultiArray()
	 * @generated
	 */
	EAttribute getUInt32MultiArray_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt8MultiArray <em>UInt8 Multi Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UInt8 Multi Array</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt8MultiArray
	 * @generated
	 */
	EClass getUInt8MultiArray();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt8MultiArray#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Layout</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt8MultiArray#getLayout()
	 * @see #getUInt8MultiArray()
	 * @generated
	 */
	EReference getUInt8MultiArray_Layout();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt8MultiArray#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Data</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt8MultiArray#getData()
	 * @see #getUInt8MultiArray()
	 * @generated
	 */
	EAttribute getUInt8MultiArray_Data();

	/**
	 * Returns the meta object for data type '{@link UInt32 <em>UInt32</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>UInt32</em>'.
	 * @see UInt32
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getUInt32();

	/**
	 * Returns the meta object for data type '{@link Time <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Time</em>'.
	 * @see Time
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getTime();

	/**
	 * Returns the meta object for data type '{@link String <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String</em>'.
	 * @see String
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getString();

	/**
	 * Returns the meta object for data type '{@link Byte <em>Byte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Byte</em>'.
	 * @see Byte
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getByte();

	/**
	 * Returns the meta object for data type '{@link Float64 <em>Float64</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Float64</em>'.
	 * @see Float64
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getFloat64();

	/**
	 * Returns the meta object for data type '{@link Int8 <em>Int8</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Int8</em>'.
	 * @see Int8
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getInt8();

	/**
	 * Returns the meta object for data type '{@link Bool <em>Bool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Bool</em>'.
	 * @see Bool
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getBool();

	/**
	 * Returns the meta object for data type '{@link UInt8 <em>UInt8</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>UInt8</em>'.
	 * @see UInt8
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getUInt8();

	/**
	 * Returns the meta object for data type '{@link UInt16 <em>UInt16</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>UInt16</em>'.
	 * @see UInt16
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getUInt16();

	/**
	 * Returns the meta object for data type '{@link Int32 <em>Int32</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Int32</em>'.
	 * @see Int32
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getInt32();

	/**
	 * Returns the meta object for data type '{@link Int16 <em>Int16</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Int16</em>'.
	 * @see Int16
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getInt16();

	/**
	 * Returns the meta object for data type '{@link Char <em>Char</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Char</em>'.
	 * @see Char
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getChar();

	/**
	 * Returns the meta object for data type '{@link Duration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Duration</em>'.
	 * @see Duration
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getDuration();

	/**
	 * Returns the meta object for data type '{@link Int64 <em>Int64</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Int64</em>'.
	 * @see Int64
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getInt64();

	/**
	 * Returns the meta object for data type '{@link UInt64 <em>UInt64</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>UInt64</em>'.
	 * @see UInt64
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getUInt64();

	/**
	 * Returns the meta object for data type '{@link Float32 <em>Float32</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Float32</em>'.
	 * @see Float32
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getFloat32();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Std_datatypesFactory getStd_datatypesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each operation of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.HeaderImpl <em>Header</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.HeaderImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getHeader()
		 * @generated
		 */
		EClass HEADER = eINSTANCE.getHeader();

		/**
		 * The meta object literal for the '<em><b>Seq</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HEADER__SEQ = eINSTANCE.getHeader_Seq();

		/**
		 * The meta object literal for the '<em><b>Stamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HEADER__STAMP = eINSTANCE.getHeader_Stamp();

		/**
		 * The meta object literal for the '<em><b>Frame id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HEADER__FRAME_ID = eINSTANCE.getHeader_Frame_id();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.MultiArrayDimensionImpl <em>Multi Array Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.MultiArrayDimensionImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getMultiArrayDimension()
		 * @generated
		 */
		EClass MULTI_ARRAY_DIMENSION = eINSTANCE.getMultiArrayDimension();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_ARRAY_DIMENSION__LABEL = eINSTANCE.getMultiArrayDimension_Label();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_ARRAY_DIMENSION__SIZE = eINSTANCE.getMultiArrayDimension_Size();

		/**
		 * The meta object literal for the '<em><b>Stride</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_ARRAY_DIMENSION__STRIDE = eINSTANCE.getMultiArrayDimension_Stride();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.MultiArrayLayoutImpl <em>Multi Array Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.MultiArrayLayoutImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getMultiArrayLayout()
		 * @generated
		 */
		EClass MULTI_ARRAY_LAYOUT = eINSTANCE.getMultiArrayLayout();

		/**
		 * The meta object literal for the '<em><b>Dim</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_ARRAY_LAYOUT__DIM = eINSTANCE.getMultiArrayLayout_Dim();

		/**
		 * The meta object literal for the '<em><b>Data offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_ARRAY_LAYOUT__DATA_OFFSET = eINSTANCE.getMultiArrayLayout_Data_offset();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.ByteMultiArrayImpl <em>Byte Multi Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.ByteMultiArrayImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getByteMultiArray()
		 * @generated
		 */
		EClass BYTE_MULTI_ARRAY = eINSTANCE.getByteMultiArray();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BYTE_MULTI_ARRAY__LAYOUT = eINSTANCE.getByteMultiArray_Layout();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BYTE_MULTI_ARRAY__DATA = eINSTANCE.getByteMultiArray_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.ColorRGBAImpl <em>Color RGBA</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.ColorRGBAImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getColorRGBA()
		 * @generated
		 */
		EClass COLOR_RGBA = eINSTANCE.getColorRGBA();

		/**
		 * The meta object literal for the '<em><b>R</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_RGBA__R = eINSTANCE.getColorRGBA_R();

		/**
		 * The meta object literal for the '<em><b>G</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_RGBA__G = eINSTANCE.getColorRGBA_G();

		/**
		 * The meta object literal for the '<em><b>B</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_RGBA__B = eINSTANCE.getColorRGBA_B();

		/**
		 * The meta object literal for the '<em><b>A</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_RGBA__A = eINSTANCE.getColorRGBA_A();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Float32MultiArrayImpl <em>Float32 Multi Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Float32MultiArrayImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getFloat32MultiArray()
		 * @generated
		 */
		EClass FLOAT32_MULTI_ARRAY = eINSTANCE.getFloat32MultiArray();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOAT32_MULTI_ARRAY__LAYOUT = eINSTANCE.getFloat32MultiArray_Layout();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOAT32_MULTI_ARRAY__DATA = eINSTANCE.getFloat32MultiArray_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Int32MultiArrayImpl <em>Int32 Multi Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Int32MultiArrayImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getInt32MultiArray()
		 * @generated
		 */
		EClass INT32_MULTI_ARRAY = eINSTANCE.getInt32MultiArray();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT32_MULTI_ARRAY__LAYOUT = eINSTANCE.getInt32MultiArray_Layout();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT32_MULTI_ARRAY__DATA = eINSTANCE.getInt32MultiArray_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Int8MultiArrayImpl <em>Int8 Multi Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Int8MultiArrayImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getInt8MultiArray()
		 * @generated
		 */
		EClass INT8_MULTI_ARRAY = eINSTANCE.getInt8MultiArray();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT8_MULTI_ARRAY__LAYOUT = eINSTANCE.getInt8MultiArray_Layout();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT8_MULTI_ARRAY__DATA = eINSTANCE.getInt8MultiArray_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Int16MultiArrayImpl <em>Int16 Multi Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Int16MultiArrayImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getInt16MultiArray()
		 * @generated
		 */
		EClass INT16_MULTI_ARRAY = eINSTANCE.getInt16MultiArray();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT16_MULTI_ARRAY__LAYOUT = eINSTANCE.getInt16MultiArray_Layout();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT16_MULTI_ARRAY__DATA = eINSTANCE.getInt16MultiArray_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Int64MultiArrayImpl <em>Int64 Multi Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Int64MultiArrayImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getInt64MultiArray()
		 * @generated
		 */
		EClass INT64_MULTI_ARRAY = eINSTANCE.getInt64MultiArray();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT64_MULTI_ARRAY__LAYOUT = eINSTANCE.getInt64MultiArray_Layout();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT64_MULTI_ARRAY__DATA = eINSTANCE.getInt64MultiArray_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Float64MultiArrayImpl <em>Float64 Multi Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Float64MultiArrayImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getFloat64MultiArray()
		 * @generated
		 */
		EClass FLOAT64_MULTI_ARRAY = eINSTANCE.getFloat64MultiArray();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOAT64_MULTI_ARRAY__LAYOUT = eINSTANCE.getFloat64MultiArray_Layout();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOAT64_MULTI_ARRAY__DATA = eINSTANCE.getFloat64MultiArray_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.UInt64MultiArrayImpl <em>UInt64 Multi Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.UInt64MultiArrayImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getUInt64MultiArray()
		 * @generated
		 */
		EClass UINT64_MULTI_ARRAY = eINSTANCE.getUInt64MultiArray();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UINT64_MULTI_ARRAY__LAYOUT = eINSTANCE.getUInt64MultiArray_Layout();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UINT64_MULTI_ARRAY__DATA = eINSTANCE.getUInt64MultiArray_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.UInt16MultiArrayImpl <em>UInt16 Multi Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.UInt16MultiArrayImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getUInt16MultiArray()
		 * @generated
		 */
		EClass UINT16_MULTI_ARRAY = eINSTANCE.getUInt16MultiArray();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UINT16_MULTI_ARRAY__LAYOUT = eINSTANCE.getUInt16MultiArray_Layout();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UINT16_MULTI_ARRAY__DATA = eINSTANCE.getUInt16MultiArray_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.UInt32MultiArrayImpl <em>UInt32 Multi Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.UInt32MultiArrayImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getUInt32MultiArray()
		 * @generated
		 */
		EClass UINT32_MULTI_ARRAY = eINSTANCE.getUInt32MultiArray();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UINT32_MULTI_ARRAY__LAYOUT = eINSTANCE.getUInt32MultiArray_Layout();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UINT32_MULTI_ARRAY__DATA = eINSTANCE.getUInt32MultiArray_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.UInt8MultiArrayImpl <em>UInt8 Multi Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.UInt8MultiArrayImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getUInt8MultiArray()
		 * @generated
		 */
		EClass UINT8_MULTI_ARRAY = eINSTANCE.getUInt8MultiArray();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UINT8_MULTI_ARRAY__LAYOUT = eINSTANCE.getUInt8MultiArray_Layout();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UINT8_MULTI_ARRAY__DATA = eINSTANCE.getUInt8MultiArray_Data();

		/**
		 * The meta object literal for the '<em>UInt32</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see UInt32
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getUInt32()
		 * @generated
		 */
		EDataType UINT32 = eINSTANCE.getUInt32();

		/**
		 * The meta object literal for the '<em>Time</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Time
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getTime()
		 * @generated
		 */
		EDataType TIME = eINSTANCE.getTime();

		/**
		 * The meta object literal for the '<em>String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see String
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getString()
		 * @generated
		 */
		EDataType STRING = eINSTANCE.getString();

		/**
		 * The meta object literal for the '<em>Byte</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Byte
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getByte()
		 * @generated
		 */
		EDataType BYTE = eINSTANCE.getByte();

		/**
		 * The meta object literal for the '<em>Float64</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Float64
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getFloat64()
		 * @generated
		 */
		EDataType FLOAT64 = eINSTANCE.getFloat64();

		/**
		 * The meta object literal for the '<em>Int8</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Int8
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getInt8()
		 * @generated
		 */
		EDataType INT8 = eINSTANCE.getInt8();

		/**
		 * The meta object literal for the '<em>Bool</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Bool
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getBool()
		 * @generated
		 */
		EDataType BOOL = eINSTANCE.getBool();

		/**
		 * The meta object literal for the '<em>UInt8</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see UInt8
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getUInt8()
		 * @generated
		 */
		EDataType UINT8 = eINSTANCE.getUInt8();

		/**
		 * The meta object literal for the '<em>UInt16</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see UInt16
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getUInt16()
		 * @generated
		 */
		EDataType UINT16 = eINSTANCE.getUInt16();

		/**
		 * The meta object literal for the '<em>Int32</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Int32
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getInt32()
		 * @generated
		 */
		EDataType INT32 = eINSTANCE.getInt32();

		/**
		 * The meta object literal for the '<em>Int16</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Int16
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getInt16()
		 * @generated
		 */
		EDataType INT16 = eINSTANCE.getInt16();

		/**
		 * The meta object literal for the '<em>Char</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Char
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getChar()
		 * @generated
		 */
		EDataType CHAR = eINSTANCE.getChar();

		/**
		 * The meta object literal for the '<em>Duration</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Duration
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getDuration()
		 * @generated
		 */
		EDataType DURATION = eINSTANCE.getDuration();

		/**
		 * The meta object literal for the '<em>Int64</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Int64
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getInt64()
		 * @generated
		 */
		EDataType INT64 = eINSTANCE.getInt64();

		/**
		 * The meta object literal for the '<em>UInt64</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see UInt64
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getUInt64()
		 * @generated
		 */
		EDataType UINT64 = eINSTANCE.getUInt64();

		/**
		 * The meta object literal for the '<em>Float32</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Float32
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl#getFloat32()
		 * @generated
		 */
		EDataType FLOAT32 = eINSTANCE.getFloat32();

	}

} // Std_datatypesPackage
