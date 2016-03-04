/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   CEA LIST - Initial API and implementation
 * 
 */
package org.omg.smm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.omg.smm.SmmFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import uml='../../org.eclipse.uml2.uml/model/UML.ecore#/'"
 * @generated
 */
public interface SmmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "smm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.omg.org/spec/SMM/20150201/SMM.cmof";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "smm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SmmPackage eINSTANCE = org.omg.smm.impl.SmmPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.SmmElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.SmmElementImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getSmmElement()
	 * @generated
	 */
	int SMM_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_ELEMENT__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_ELEMENT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_ELEMENT__SHORT_DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_ELEMENT__IN_RELATIONSHIPS = 3;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_ELEMENT__OUT_RELATIONSHIPS = 4;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_ELEMENT__ATTRIBUTES = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_ELEMENT__ANNOTATIONS = 6;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_ELEMENT_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.AbstractMeasureElementImpl <em>Abstract Measure Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.AbstractMeasureElementImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getAbstractMeasureElement()
	 * @generated
	 */
	int ABSTRACT_MEASURE_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MEASURE_ELEMENT__DESCRIPTION = SMM_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MEASURE_ELEMENT__NAME = SMM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MEASURE_ELEMENT__SHORT_DESCRIPTION = SMM_ELEMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MEASURE_ELEMENT__IN_RELATIONSHIPS = SMM_ELEMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MEASURE_ELEMENT__OUT_RELATIONSHIPS = SMM_ELEMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MEASURE_ELEMENT__ATTRIBUTES = SMM_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MEASURE_ELEMENT__ANNOTATIONS = SMM_ELEMENT__ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Abstract Measure Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT = SMM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Abstract Measure Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MEASURE_ELEMENT_OPERATION_COUNT = SMM_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.SmmRelationshipImpl <em>Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.SmmRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getSmmRelationship()
	 * @generated
	 */
	int SMM_RELATIONSHIP = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_RELATIONSHIP__DESCRIPTION = SMM_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_RELATIONSHIP__NAME = SMM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_RELATIONSHIP__SHORT_DESCRIPTION = SMM_ELEMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_RELATIONSHIP__IN_RELATIONSHIPS = SMM_ELEMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_RELATIONSHIP__OUT_RELATIONSHIPS = SMM_ELEMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_RELATIONSHIP__ATTRIBUTES = SMM_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_RELATIONSHIP__ANNOTATIONS = SMM_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_RELATIONSHIP__FROM = SMM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_RELATIONSHIP__TO = SMM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_RELATIONSHIP_FEATURE_COUNT = SMM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_RELATIONSHIP_OPERATION_COUNT = SMM_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.AttributeImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__DESCRIPTION = SMM_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = SMM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__SHORT_DESCRIPTION = SMM_ELEMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IN_RELATIONSHIPS = SMM_ELEMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__OUT_RELATIONSHIPS = SMM_ELEMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__ATTRIBUTES = SMM_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__ANNOTATIONS = SMM_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__TAG = SMM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__VALUE = SMM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = SMM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = SMM_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.AnnotationImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__DESCRIPTION = SMM_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__NAME = SMM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__SHORT_DESCRIPTION = SMM_ELEMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__IN_RELATIONSHIPS = SMM_ELEMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__OUT_RELATIONSHIPS = SMM_ELEMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__ATTRIBUTES = SMM_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__ANNOTATIONS = SMM_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__TEXT = SMM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = SMM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_OPERATION_COUNT = SMM_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.ArgumentImpl <em>Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.ArgumentImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getArgument()
	 * @generated
	 */
	int ARGUMENT = 5;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__DESCRIPTION = SMM_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__NAME = SMM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__SHORT_DESCRIPTION = SMM_ELEMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__IN_RELATIONSHIPS = SMM_ELEMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__OUT_RELATIONSHIPS = SMM_ELEMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__ATTRIBUTES = SMM_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__ANNOTATIONS = SMM_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__TYPE = SMM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__VALUE = SMM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Observed Measure</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__OBSERVED_MEASURE = SMM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_FEATURE_COUNT = SMM_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_OPERATION_COUNT = SMM_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.ObservedMeasureImpl <em>Observed Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.ObservedMeasureImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getObservedMeasure()
	 * @generated
	 */
	int OBSERVED_MEASURE = 6;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVED_MEASURE__DESCRIPTION = SMM_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVED_MEASURE__NAME = SMM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVED_MEASURE__SHORT_DESCRIPTION = SMM_ELEMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVED_MEASURE__IN_RELATIONSHIPS = SMM_ELEMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVED_MEASURE__OUT_RELATIONSHIPS = SMM_ELEMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVED_MEASURE__ATTRIBUTES = SMM_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVED_MEASURE__ANNOTATIONS = SMM_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Measurements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVED_MEASURE__MEASUREMENTS = SMM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Measure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVED_MEASURE__MEASURE = SMM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVED_MEASURE__ARGUMENTS = SMM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Observed Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVED_MEASURE_FEATURE_COUNT = SMM_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Observed Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVED_MEASURE_OPERATION_COUNT = SMM_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.MeasurementImpl <em>Measurement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.MeasurementImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getMeasurement()
	 * @generated
	 */
	int MEASUREMENT = 7;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__DESCRIPTION = SMM_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__NAME = SMM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__SHORT_DESCRIPTION = SMM_ELEMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__IN_RELATIONSHIPS = SMM_ELEMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__OUT_RELATIONSHIPS = SMM_ELEMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__ATTRIBUTES = SMM_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__ANNOTATIONS = SMM_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Break Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__BREAK_VALUE = SMM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__ERROR = SMM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Measurement Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__MEASUREMENT_RELATIONSHIPS = SMM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Observed Measure</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__OBSERVED_MEASURE = SMM_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_FEATURE_COUNT = SMM_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Measure Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT___GET_MEASURE_LABEL = SMM_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Measurement Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT___GET_MEASUREMENT_LABEL = SMM_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_OPERATION_COUNT = SMM_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.MeasurementRelationshipImpl <em>Measurement Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.MeasurementRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getMeasurementRelationship()
	 * @generated
	 */
	int MEASUREMENT_RELATIONSHIP = 9;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_RELATIONSHIP__DESCRIPTION = SMM_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_RELATIONSHIP__NAME = SMM_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_RELATIONSHIP__SHORT_DESCRIPTION = SMM_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_RELATIONSHIP__IN_RELATIONSHIPS = SMM_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_RELATIONSHIP__OUT_RELATIONSHIPS = SMM_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_RELATIONSHIP__ATTRIBUTES = SMM_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_RELATIONSHIP__ANNOTATIONS = SMM_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_RELATIONSHIP__FROM = SMM_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_RELATIONSHIP__TO = SMM_RELATIONSHIP__TO;

	/**
	 * The number of structural features of the '<em>Measurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_RELATIONSHIP_FEATURE_COUNT = SMM_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Measurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_RELATIONSHIP_OPERATION_COUNT = SMM_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.EquivalentMeasurementRelationshipImpl <em>Equivalent Measurement Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.EquivalentMeasurementRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getEquivalentMeasurementRelationship()
	 * @generated
	 */
	int EQUIVALENT_MEASUREMENT_RELATIONSHIP = 8;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASUREMENT_RELATIONSHIP__DESCRIPTION = MEASUREMENT_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASUREMENT_RELATIONSHIP__NAME = MEASUREMENT_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASUREMENT_RELATIONSHIP__SHORT_DESCRIPTION = MEASUREMENT_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASUREMENT_RELATIONSHIP__IN_RELATIONSHIPS = MEASUREMENT_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASUREMENT_RELATIONSHIP__OUT_RELATIONSHIPS = MEASUREMENT_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASUREMENT_RELATIONSHIP__ATTRIBUTES = MEASUREMENT_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASUREMENT_RELATIONSHIP__ANNOTATIONS = MEASUREMENT_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASUREMENT_RELATIONSHIP__FROM = MEASUREMENT_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASUREMENT_RELATIONSHIP__TO = MEASUREMENT_RELATIONSHIP__TO;

	/**
	 * The number of structural features of the '<em>Equivalent Measurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASUREMENT_RELATIONSHIP_FEATURE_COUNT = MEASUREMENT_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Equivalent Measurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASUREMENT_RELATIONSHIP_OPERATION_COUNT = MEASUREMENT_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.RefinementMeasurementRelationshipImpl <em>Refinement Measurement Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.RefinementMeasurementRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getRefinementMeasurementRelationship()
	 * @generated
	 */
	int REFINEMENT_MEASUREMENT_RELATIONSHIP = 10;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASUREMENT_RELATIONSHIP__DESCRIPTION = MEASUREMENT_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASUREMENT_RELATIONSHIP__NAME = MEASUREMENT_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASUREMENT_RELATIONSHIP__SHORT_DESCRIPTION = MEASUREMENT_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASUREMENT_RELATIONSHIP__IN_RELATIONSHIPS = MEASUREMENT_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASUREMENT_RELATIONSHIP__OUT_RELATIONSHIPS = MEASUREMENT_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASUREMENT_RELATIONSHIP__ATTRIBUTES = MEASUREMENT_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASUREMENT_RELATIONSHIP__ANNOTATIONS = MEASUREMENT_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASUREMENT_RELATIONSHIP__FROM = MEASUREMENT_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASUREMENT_RELATIONSHIP__TO = MEASUREMENT_RELATIONSHIP__TO;

	/**
	 * The number of structural features of the '<em>Refinement Measurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASUREMENT_RELATIONSHIP_FEATURE_COUNT = MEASUREMENT_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Refinement Measurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASUREMENT_RELATIONSHIP_OPERATION_COUNT = MEASUREMENT_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.MeasureImpl <em>Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.MeasureImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getMeasure()
	 * @generated
	 */
	int MEASURE = 11;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__DESCRIPTION = ABSTRACT_MEASURE_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__NAME = ABSTRACT_MEASURE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__SHORT_DESCRIPTION = ABSTRACT_MEASURE_ELEMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__IN_RELATIONSHIPS = ABSTRACT_MEASURE_ELEMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__OUT_RELATIONSHIPS = ABSTRACT_MEASURE_ELEMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__ATTRIBUTES = ABSTRACT_MEASURE_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__ANNOTATIONS = ABSTRACT_MEASURE_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Measure Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__MEASURE_LABEL_FORMAT = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Measurement Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__MEASUREMENT_LABEL_FORMAT = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__VISIBLE = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__SOURCE = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Default Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__DEFAULT_QUERY = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Measure Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__MEASURE_RELATIONSHIPS = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Category</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__CATEGORY = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__SCOPE = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Trait</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__TRAIT = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__SCALE = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Custom Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE__CUSTOM_SCALE = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_FEATURE_COUNT = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The operation id for the '<em>Get All Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE___GET_ALL_ARGUMENTS = ABSTRACT_MEASURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE___GET_ARGUMENTS = ABSTRACT_MEASURE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_OPERATION_COUNT = ABSTRACT_MEASURE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.MeasureRelationshipImpl <em>Measure Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.MeasureRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getMeasureRelationship()
	 * @generated
	 */
	int MEASURE_RELATIONSHIP = 13;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_RELATIONSHIP__DESCRIPTION = SMM_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_RELATIONSHIP__NAME = SMM_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_RELATIONSHIP__SHORT_DESCRIPTION = SMM_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_RELATIONSHIP__IN_RELATIONSHIPS = SMM_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_RELATIONSHIP__OUT_RELATIONSHIPS = SMM_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_RELATIONSHIP__ATTRIBUTES = SMM_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_RELATIONSHIP__ANNOTATIONS = SMM_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_RELATIONSHIP__FROM = SMM_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_RELATIONSHIP__TO = SMM_RELATIONSHIP__TO;

	/**
	 * The feature id for the '<em><b>Influence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_RELATIONSHIP__INFLUENCE = SMM_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Measurand Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_RELATIONSHIP__MEASURAND_QUERY = SMM_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Measure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_RELATIONSHIP_FEATURE_COUNT = SMM_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Measure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_RELATIONSHIP_OPERATION_COUNT = SMM_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.RefinementMeasureRelationshipImpl <em>Refinement Measure Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.RefinementMeasureRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getRefinementMeasureRelationship()
	 * @generated
	 */
	int REFINEMENT_MEASURE_RELATIONSHIP = 12;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASURE_RELATIONSHIP__DESCRIPTION = MEASURE_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASURE_RELATIONSHIP__NAME = MEASURE_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASURE_RELATIONSHIP__SHORT_DESCRIPTION = MEASURE_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASURE_RELATIONSHIP__IN_RELATIONSHIPS = MEASURE_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASURE_RELATIONSHIP__OUT_RELATIONSHIPS = MEASURE_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASURE_RELATIONSHIP__ATTRIBUTES = MEASURE_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASURE_RELATIONSHIP__ANNOTATIONS = MEASURE_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASURE_RELATIONSHIP__FROM = MEASURE_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASURE_RELATIONSHIP__TO = MEASURE_RELATIONSHIP__TO;

	/**
	 * The feature id for the '<em><b>Influence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASURE_RELATIONSHIP__INFLUENCE = MEASURE_RELATIONSHIP__INFLUENCE;

	/**
	 * The feature id for the '<em><b>Measurand Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASURE_RELATIONSHIP__MEASURAND_QUERY = MEASURE_RELATIONSHIP__MEASURAND_QUERY;

	/**
	 * The number of structural features of the '<em>Refinement Measure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASURE_RELATIONSHIP_FEATURE_COUNT = MEASURE_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Refinement Measure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFINEMENT_MEASURE_RELATIONSHIP_OPERATION_COUNT = MEASURE_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.OperationImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 14;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__DESCRIPTION = ABSTRACT_MEASURE_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = ABSTRACT_MEASURE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__SHORT_DESCRIPTION = ABSTRACT_MEASURE_ELEMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__IN_RELATIONSHIPS = ABSTRACT_MEASURE_ELEMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OUT_RELATIONSHIPS = ABSTRACT_MEASURE_ELEMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__ATTRIBUTES = ABSTRACT_MEASURE_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__ANNOTATIONS = ABSTRACT_MEASURE_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__BODY = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__LANGUAGE = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Param Strings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION___GET_PARAM_STRINGS = ABSTRACT_MEASURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_OPERATION_COUNT = ABSTRACT_MEASURE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.EquivalentMeasureRelationshipImpl <em>Equivalent Measure Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.EquivalentMeasureRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getEquivalentMeasureRelationship()
	 * @generated
	 */
	int EQUIVALENT_MEASURE_RELATIONSHIP = 15;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASURE_RELATIONSHIP__DESCRIPTION = MEASURE_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASURE_RELATIONSHIP__NAME = MEASURE_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASURE_RELATIONSHIP__SHORT_DESCRIPTION = MEASURE_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASURE_RELATIONSHIP__IN_RELATIONSHIPS = MEASURE_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASURE_RELATIONSHIP__OUT_RELATIONSHIPS = MEASURE_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASURE_RELATIONSHIP__ATTRIBUTES = MEASURE_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASURE_RELATIONSHIP__ANNOTATIONS = MEASURE_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASURE_RELATIONSHIP__FROM = MEASURE_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASURE_RELATIONSHIP__TO = MEASURE_RELATIONSHIP__TO;

	/**
	 * The feature id for the '<em><b>Influence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASURE_RELATIONSHIP__INFLUENCE = MEASURE_RELATIONSHIP__INFLUENCE;

	/**
	 * The feature id for the '<em><b>Measurand Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASURE_RELATIONSHIP__MEASURAND_QUERY = MEASURE_RELATIONSHIP__MEASURAND_QUERY;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASURE_RELATIONSHIP__MAPPING = MEASURE_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Equivalent Measure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASURE_RELATIONSHIP_FEATURE_COUNT = MEASURE_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Equivalent Measure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENT_MEASURE_RELATIONSHIP_OPERATION_COUNT = MEASURE_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.MeasureCategoryImpl <em>Measure Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.MeasureCategoryImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getMeasureCategory()
	 * @generated
	 */
	int MEASURE_CATEGORY = 16;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CATEGORY__DESCRIPTION = ABSTRACT_MEASURE_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CATEGORY__NAME = ABSTRACT_MEASURE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CATEGORY__SHORT_DESCRIPTION = ABSTRACT_MEASURE_ELEMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CATEGORY__IN_RELATIONSHIPS = ABSTRACT_MEASURE_ELEMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CATEGORY__OUT_RELATIONSHIPS = ABSTRACT_MEASURE_ELEMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CATEGORY__ATTRIBUTES = ABSTRACT_MEASURE_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CATEGORY__ANNOTATIONS = ABSTRACT_MEASURE_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Category</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CATEGORY__CATEGORY = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Category Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CATEGORY__CATEGORY_ELEMENT = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Category Measure</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CATEGORY__CATEGORY_MEASURE = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Measure Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CATEGORY_FEATURE_COUNT = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Measure Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_CATEGORY_OPERATION_COUNT = ABSTRACT_MEASURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.ScopeImpl <em>Scope</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.ScopeImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getScope()
	 * @generated
	 */
	int SCOPE = 17;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE__DESCRIPTION = ABSTRACT_MEASURE_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE__NAME = ABSTRACT_MEASURE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE__SHORT_DESCRIPTION = ABSTRACT_MEASURE_ELEMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE__IN_RELATIONSHIPS = ABSTRACT_MEASURE_ELEMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE__OUT_RELATIONSHIPS = ABSTRACT_MEASURE_ELEMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE__ATTRIBUTES = ABSTRACT_MEASURE_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE__ANNOTATIONS = ABSTRACT_MEASURE_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Break Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE__BREAK_CONDITION = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Recognizer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE__RECOGNIZER = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE__CLASS = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE__STEREOTYPE = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Scope</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_FEATURE_COUNT = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Scope</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOPE_OPERATION_COUNT = ABSTRACT_MEASURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.CharacteristicImpl <em>Characteristic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.CharacteristicImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getCharacteristic()
	 * @generated
	 */
	int CHARACTERISTIC = 18;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC__DESCRIPTION = ABSTRACT_MEASURE_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC__NAME = ABSTRACT_MEASURE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC__SHORT_DESCRIPTION = ABSTRACT_MEASURE_ELEMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC__IN_RELATIONSHIPS = ABSTRACT_MEASURE_ELEMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC__OUT_RELATIONSHIPS = ABSTRACT_MEASURE_ELEMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC__ATTRIBUTES = ABSTRACT_MEASURE_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC__ANNOTATIONS = ABSTRACT_MEASURE_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC__PARENT = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_FEATURE_COUNT = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_OPERATION_COUNT = ABSTRACT_MEASURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.BaseMeasureRelationshipImpl <em>Base Measure Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.BaseMeasureRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getBaseMeasureRelationship()
	 * @generated
	 */
	int BASE_MEASURE_RELATIONSHIP = 20;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASURE_RELATIONSHIP__DESCRIPTION = MEASURE_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASURE_RELATIONSHIP__NAME = MEASURE_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASURE_RELATIONSHIP__SHORT_DESCRIPTION = MEASURE_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASURE_RELATIONSHIP__IN_RELATIONSHIPS = MEASURE_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASURE_RELATIONSHIP__OUT_RELATIONSHIPS = MEASURE_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASURE_RELATIONSHIP__ATTRIBUTES = MEASURE_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASURE_RELATIONSHIP__ANNOTATIONS = MEASURE_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASURE_RELATIONSHIP__FROM = MEASURE_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASURE_RELATIONSHIP__TO = MEASURE_RELATIONSHIP__TO;

	/**
	 * The feature id for the '<em><b>Influence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASURE_RELATIONSHIP__INFLUENCE = MEASURE_RELATIONSHIP__INFLUENCE;

	/**
	 * The feature id for the '<em><b>Measurand Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASURE_RELATIONSHIP__MEASURAND_QUERY = MEASURE_RELATIONSHIP__MEASURAND_QUERY;

	/**
	 * The feature id for the '<em><b>Rescaled Measure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASURE_RELATIONSHIP__RESCALED_MEASURE = MEASURE_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Base Measure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASURE_RELATIONSHIP_FEATURE_COUNT = MEASURE_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Base Measure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASURE_RELATIONSHIP_OPERATION_COUNT = MEASURE_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.Base1MeasureRelationshipImpl <em>Base1 Measure Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.Base1MeasureRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getBase1MeasureRelationship()
	 * @generated
	 */
	int BASE1_MEASURE_RELATIONSHIP = 19;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASURE_RELATIONSHIP__DESCRIPTION = BASE_MEASURE_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASURE_RELATIONSHIP__NAME = BASE_MEASURE_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASURE_RELATIONSHIP__SHORT_DESCRIPTION = BASE_MEASURE_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASURE_RELATIONSHIP__IN_RELATIONSHIPS = BASE_MEASURE_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASURE_RELATIONSHIP__OUT_RELATIONSHIPS = BASE_MEASURE_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASURE_RELATIONSHIP__ATTRIBUTES = BASE_MEASURE_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASURE_RELATIONSHIP__ANNOTATIONS = BASE_MEASURE_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASURE_RELATIONSHIP__FROM = BASE_MEASURE_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASURE_RELATIONSHIP__TO = BASE_MEASURE_RELATIONSHIP__TO;

	/**
	 * The feature id for the '<em><b>Influence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASURE_RELATIONSHIP__INFLUENCE = BASE_MEASURE_RELATIONSHIP__INFLUENCE;

	/**
	 * The feature id for the '<em><b>Measurand Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASURE_RELATIONSHIP__MEASURAND_QUERY = BASE_MEASURE_RELATIONSHIP__MEASURAND_QUERY;

	/**
	 * The feature id for the '<em><b>Rescaled Measure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASURE_RELATIONSHIP__RESCALED_MEASURE = BASE_MEASURE_RELATIONSHIP__RESCALED_MEASURE;

	/**
	 * The number of structural features of the '<em>Base1 Measure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASURE_RELATIONSHIP_FEATURE_COUNT = BASE_MEASURE_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Base1 Measure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASURE_RELATIONSHIP_OPERATION_COUNT = BASE_MEASURE_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.DimensionalMeasureImpl <em>Dimensional Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.DimensionalMeasureImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getDimensionalMeasure()
	 * @generated
	 */
	int DIMENSIONAL_MEASURE = 22;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__DESCRIPTION = MEASURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__NAME = MEASURE__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__SHORT_DESCRIPTION = MEASURE__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__IN_RELATIONSHIPS = MEASURE__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__OUT_RELATIONSHIPS = MEASURE__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__ATTRIBUTES = MEASURE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__ANNOTATIONS = MEASURE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Measure Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__MEASURE_LABEL_FORMAT = MEASURE__MEASURE_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Measurement Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__MEASUREMENT_LABEL_FORMAT = MEASURE__MEASUREMENT_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__VISIBLE = MEASURE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__SOURCE = MEASURE__SOURCE;

	/**
	 * The feature id for the '<em><b>Default Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__DEFAULT_QUERY = MEASURE__DEFAULT_QUERY;

	/**
	 * The feature id for the '<em><b>Measure Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__MEASURE_RELATIONSHIPS = MEASURE__MEASURE_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Category</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__CATEGORY = MEASURE__CATEGORY;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__SCOPE = MEASURE__SCOPE;

	/**
	 * The feature id for the '<em><b>Trait</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__TRAIT = MEASURE__TRAIT;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__SCALE = MEASURE__SCALE;

	/**
	 * The feature id for the '<em><b>Custom Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__CUSTOM_SCALE = MEASURE__CUSTOM_SCALE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__UNIT = MEASURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE__FORMULA = MEASURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dimensional Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE_FEATURE_COUNT = MEASURE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get All Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE___GET_ALL_ARGUMENTS = MEASURE___GET_ALL_ARGUMENTS;

	/**
	 * The operation id for the '<em>Get Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE___GET_ARGUMENTS = MEASURE___GET_ARGUMENTS;

	/**
	 * The number of operations of the '<em>Dimensional Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASURE_OPERATION_COUNT = MEASURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.RescaledMeasureImpl <em>Rescaled Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.RescaledMeasureImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getRescaledMeasure()
	 * @generated
	 */
	int RESCALED_MEASURE = 21;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__DESCRIPTION = DIMENSIONAL_MEASURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__NAME = DIMENSIONAL_MEASURE__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__SHORT_DESCRIPTION = DIMENSIONAL_MEASURE__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__IN_RELATIONSHIPS = DIMENSIONAL_MEASURE__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__OUT_RELATIONSHIPS = DIMENSIONAL_MEASURE__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__ATTRIBUTES = DIMENSIONAL_MEASURE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__ANNOTATIONS = DIMENSIONAL_MEASURE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Measure Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__MEASURE_LABEL_FORMAT = DIMENSIONAL_MEASURE__MEASURE_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Measurement Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__MEASUREMENT_LABEL_FORMAT = DIMENSIONAL_MEASURE__MEASUREMENT_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__VISIBLE = DIMENSIONAL_MEASURE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__SOURCE = DIMENSIONAL_MEASURE__SOURCE;

	/**
	 * The feature id for the '<em><b>Default Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__DEFAULT_QUERY = DIMENSIONAL_MEASURE__DEFAULT_QUERY;

	/**
	 * The feature id for the '<em><b>Measure Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__MEASURE_RELATIONSHIPS = DIMENSIONAL_MEASURE__MEASURE_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Category</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__CATEGORY = DIMENSIONAL_MEASURE__CATEGORY;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__SCOPE = DIMENSIONAL_MEASURE__SCOPE;

	/**
	 * The feature id for the '<em><b>Trait</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__TRAIT = DIMENSIONAL_MEASURE__TRAIT;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__SCALE = DIMENSIONAL_MEASURE__SCALE;

	/**
	 * The feature id for the '<em><b>Custom Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__CUSTOM_SCALE = DIMENSIONAL_MEASURE__CUSTOM_SCALE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__UNIT = DIMENSIONAL_MEASURE__UNIT;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__FORMULA = DIMENSIONAL_MEASURE__FORMULA;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__OPERATION = DIMENSIONAL_MEASURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__OFFSET = DIMENSIONAL_MEASURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Multiplier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__MULTIPLIER = DIMENSIONAL_MEASURE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Rescales</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE__RESCALES = DIMENSIONAL_MEASURE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Rescaled Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE_FEATURE_COUNT = DIMENSIONAL_MEASURE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get All Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE___GET_ALL_ARGUMENTS = DIMENSIONAL_MEASURE___GET_ALL_ARGUMENTS;

	/**
	 * The operation id for the '<em>Get Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE___GET_ARGUMENTS = DIMENSIONAL_MEASURE___GET_ARGUMENTS;

	/**
	 * The number of operations of the '<em>Rescaled Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE_OPERATION_COUNT = DIMENSIONAL_MEASURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.BaseNMeasureRelationshipImpl <em>Base NMeasure Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.BaseNMeasureRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getBaseNMeasureRelationship()
	 * @generated
	 */
	int BASE_NMEASURE_RELATIONSHIP = 23;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASURE_RELATIONSHIP__DESCRIPTION = BASE_MEASURE_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASURE_RELATIONSHIP__NAME = BASE_MEASURE_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASURE_RELATIONSHIP__SHORT_DESCRIPTION = BASE_MEASURE_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASURE_RELATIONSHIP__IN_RELATIONSHIPS = BASE_MEASURE_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASURE_RELATIONSHIP__OUT_RELATIONSHIPS = BASE_MEASURE_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASURE_RELATIONSHIP__ATTRIBUTES = BASE_MEASURE_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASURE_RELATIONSHIP__ANNOTATIONS = BASE_MEASURE_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASURE_RELATIONSHIP__FROM = BASE_MEASURE_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASURE_RELATIONSHIP__TO = BASE_MEASURE_RELATIONSHIP__TO;

	/**
	 * The feature id for the '<em><b>Influence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASURE_RELATIONSHIP__INFLUENCE = BASE_MEASURE_RELATIONSHIP__INFLUENCE;

	/**
	 * The feature id for the '<em><b>Measurand Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASURE_RELATIONSHIP__MEASURAND_QUERY = BASE_MEASURE_RELATIONSHIP__MEASURAND_QUERY;

	/**
	 * The feature id for the '<em><b>Rescaled Measure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASURE_RELATIONSHIP__RESCALED_MEASURE = BASE_MEASURE_RELATIONSHIP__RESCALED_MEASURE;

	/**
	 * The number of structural features of the '<em>Base NMeasure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASURE_RELATIONSHIP_FEATURE_COUNT = BASE_MEASURE_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Base NMeasure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASURE_RELATIONSHIP_OPERATION_COUNT = BASE_MEASURE_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.CollectiveMeasureImpl <em>Collective Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.CollectiveMeasureImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getCollectiveMeasure()
	 * @generated
	 */
	int COLLECTIVE_MEASURE = 24;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__DESCRIPTION = DIMENSIONAL_MEASURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__NAME = DIMENSIONAL_MEASURE__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__SHORT_DESCRIPTION = DIMENSIONAL_MEASURE__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__IN_RELATIONSHIPS = DIMENSIONAL_MEASURE__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__OUT_RELATIONSHIPS = DIMENSIONAL_MEASURE__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__ATTRIBUTES = DIMENSIONAL_MEASURE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__ANNOTATIONS = DIMENSIONAL_MEASURE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Measure Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__MEASURE_LABEL_FORMAT = DIMENSIONAL_MEASURE__MEASURE_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Measurement Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__MEASUREMENT_LABEL_FORMAT = DIMENSIONAL_MEASURE__MEASUREMENT_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__VISIBLE = DIMENSIONAL_MEASURE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__SOURCE = DIMENSIONAL_MEASURE__SOURCE;

	/**
	 * The feature id for the '<em><b>Default Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__DEFAULT_QUERY = DIMENSIONAL_MEASURE__DEFAULT_QUERY;

	/**
	 * The feature id for the '<em><b>Measure Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__MEASURE_RELATIONSHIPS = DIMENSIONAL_MEASURE__MEASURE_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Category</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__CATEGORY = DIMENSIONAL_MEASURE__CATEGORY;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__SCOPE = DIMENSIONAL_MEASURE__SCOPE;

	/**
	 * The feature id for the '<em><b>Trait</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__TRAIT = DIMENSIONAL_MEASURE__TRAIT;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__SCALE = DIMENSIONAL_MEASURE__SCALE;

	/**
	 * The feature id for the '<em><b>Custom Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__CUSTOM_SCALE = DIMENSIONAL_MEASURE__CUSTOM_SCALE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__UNIT = DIMENSIONAL_MEASURE__UNIT;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__FORMULA = DIMENSIONAL_MEASURE__FORMULA;

	/**
	 * The feature id for the '<em><b>Accumulator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__ACCUMULATOR = DIMENSIONAL_MEASURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Custom Accumulator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE__CUSTOM_ACCUMULATOR = DIMENSIONAL_MEASURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collective Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE_FEATURE_COUNT = DIMENSIONAL_MEASURE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get All Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE___GET_ALL_ARGUMENTS = DIMENSIONAL_MEASURE___GET_ALL_ARGUMENTS;

	/**
	 * The operation id for the '<em>Get Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE___GET_ARGUMENTS = DIMENSIONAL_MEASURE___GET_ARGUMENTS;

	/**
	 * The number of operations of the '<em>Collective Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASURE_OPERATION_COUNT = DIMENSIONAL_MEASURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.Base2MeasureRelationshipImpl <em>Base2 Measure Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.Base2MeasureRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getBase2MeasureRelationship()
	 * @generated
	 */
	int BASE2_MEASURE_RELATIONSHIP = 25;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASURE_RELATIONSHIP__DESCRIPTION = BASE_MEASURE_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASURE_RELATIONSHIP__NAME = BASE_MEASURE_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASURE_RELATIONSHIP__SHORT_DESCRIPTION = BASE_MEASURE_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASURE_RELATIONSHIP__IN_RELATIONSHIPS = BASE_MEASURE_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASURE_RELATIONSHIP__OUT_RELATIONSHIPS = BASE_MEASURE_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASURE_RELATIONSHIP__ATTRIBUTES = BASE_MEASURE_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASURE_RELATIONSHIP__ANNOTATIONS = BASE_MEASURE_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASURE_RELATIONSHIP__FROM = BASE_MEASURE_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASURE_RELATIONSHIP__TO = BASE_MEASURE_RELATIONSHIP__TO;

	/**
	 * The feature id for the '<em><b>Influence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASURE_RELATIONSHIP__INFLUENCE = BASE_MEASURE_RELATIONSHIP__INFLUENCE;

	/**
	 * The feature id for the '<em><b>Measurand Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASURE_RELATIONSHIP__MEASURAND_QUERY = BASE_MEASURE_RELATIONSHIP__MEASURAND_QUERY;

	/**
	 * The feature id for the '<em><b>Rescaled Measure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASURE_RELATIONSHIP__RESCALED_MEASURE = BASE_MEASURE_RELATIONSHIP__RESCALED_MEASURE;

	/**
	 * The number of structural features of the '<em>Base2 Measure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASURE_RELATIONSHIP_FEATURE_COUNT = BASE_MEASURE_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Base2 Measure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASURE_RELATIONSHIP_OPERATION_COUNT = BASE_MEASURE_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.BinaryMeasureImpl <em>Binary Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.BinaryMeasureImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getBinaryMeasure()
	 * @generated
	 */
	int BINARY_MEASURE = 26;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__DESCRIPTION = DIMENSIONAL_MEASURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__NAME = DIMENSIONAL_MEASURE__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__SHORT_DESCRIPTION = DIMENSIONAL_MEASURE__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__IN_RELATIONSHIPS = DIMENSIONAL_MEASURE__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__OUT_RELATIONSHIPS = DIMENSIONAL_MEASURE__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__ATTRIBUTES = DIMENSIONAL_MEASURE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__ANNOTATIONS = DIMENSIONAL_MEASURE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Measure Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__MEASURE_LABEL_FORMAT = DIMENSIONAL_MEASURE__MEASURE_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Measurement Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__MEASUREMENT_LABEL_FORMAT = DIMENSIONAL_MEASURE__MEASUREMENT_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__VISIBLE = DIMENSIONAL_MEASURE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__SOURCE = DIMENSIONAL_MEASURE__SOURCE;

	/**
	 * The feature id for the '<em><b>Default Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__DEFAULT_QUERY = DIMENSIONAL_MEASURE__DEFAULT_QUERY;

	/**
	 * The feature id for the '<em><b>Measure Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__MEASURE_RELATIONSHIPS = DIMENSIONAL_MEASURE__MEASURE_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Category</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__CATEGORY = DIMENSIONAL_MEASURE__CATEGORY;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__SCOPE = DIMENSIONAL_MEASURE__SCOPE;

	/**
	 * The feature id for the '<em><b>Trait</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__TRAIT = DIMENSIONAL_MEASURE__TRAIT;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__SCALE = DIMENSIONAL_MEASURE__SCALE;

	/**
	 * The feature id for the '<em><b>Custom Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__CUSTOM_SCALE = DIMENSIONAL_MEASURE__CUSTOM_SCALE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__UNIT = DIMENSIONAL_MEASURE__UNIT;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__FORMULA = DIMENSIONAL_MEASURE__FORMULA;

	/**
	 * The feature id for the '<em><b>Functor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__FUNCTOR = DIMENSIONAL_MEASURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Custom Functor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE__CUSTOM_FUNCTOR = DIMENSIONAL_MEASURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE_FEATURE_COUNT = DIMENSIONAL_MEASURE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get All Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE___GET_ALL_ARGUMENTS = DIMENSIONAL_MEASURE___GET_ALL_ARGUMENTS;

	/**
	 * The operation id for the '<em>Get Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE___GET_ARGUMENTS = DIMENSIONAL_MEASURE___GET_ARGUMENTS;

	/**
	 * The number of operations of the '<em>Binary Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASURE_OPERATION_COUNT = DIMENSIONAL_MEASURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.RankingMeasureRelationshipImpl <em>Ranking Measure Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.RankingMeasureRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getRankingMeasureRelationship()
	 * @generated
	 */
	int RANKING_MEASURE_RELATIONSHIP = 27;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE_RELATIONSHIP__DESCRIPTION = BASE_MEASURE_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE_RELATIONSHIP__NAME = BASE_MEASURE_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE_RELATIONSHIP__SHORT_DESCRIPTION = BASE_MEASURE_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE_RELATIONSHIP__IN_RELATIONSHIPS = BASE_MEASURE_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE_RELATIONSHIP__OUT_RELATIONSHIPS = BASE_MEASURE_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE_RELATIONSHIP__ATTRIBUTES = BASE_MEASURE_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE_RELATIONSHIP__ANNOTATIONS = BASE_MEASURE_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE_RELATIONSHIP__FROM = BASE_MEASURE_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE_RELATIONSHIP__TO = BASE_MEASURE_RELATIONSHIP__TO;

	/**
	 * The feature id for the '<em><b>Influence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE_RELATIONSHIP__INFLUENCE = BASE_MEASURE_RELATIONSHIP__INFLUENCE;

	/**
	 * The feature id for the '<em><b>Measurand Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE_RELATIONSHIP__MEASURAND_QUERY = BASE_MEASURE_RELATIONSHIP__MEASURAND_QUERY;

	/**
	 * The feature id for the '<em><b>Rescaled Measure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE_RELATIONSHIP__RESCALED_MEASURE = BASE_MEASURE_RELATIONSHIP__RESCALED_MEASURE;

	/**
	 * The number of structural features of the '<em>Ranking Measure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE_RELATIONSHIP_FEATURE_COUNT = BASE_MEASURE_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Ranking Measure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE_RELATIONSHIP_OPERATION_COUNT = BASE_MEASURE_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.RankingMeasureImpl <em>Ranking Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.RankingMeasureImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getRankingMeasure()
	 * @generated
	 */
	int RANKING_MEASURE = 28;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__DESCRIPTION = DIMENSIONAL_MEASURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__NAME = DIMENSIONAL_MEASURE__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__SHORT_DESCRIPTION = DIMENSIONAL_MEASURE__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__IN_RELATIONSHIPS = DIMENSIONAL_MEASURE__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__OUT_RELATIONSHIPS = DIMENSIONAL_MEASURE__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__ATTRIBUTES = DIMENSIONAL_MEASURE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__ANNOTATIONS = DIMENSIONAL_MEASURE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Measure Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__MEASURE_LABEL_FORMAT = DIMENSIONAL_MEASURE__MEASURE_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Measurement Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__MEASUREMENT_LABEL_FORMAT = DIMENSIONAL_MEASURE__MEASUREMENT_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__VISIBLE = DIMENSIONAL_MEASURE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__SOURCE = DIMENSIONAL_MEASURE__SOURCE;

	/**
	 * The feature id for the '<em><b>Default Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__DEFAULT_QUERY = DIMENSIONAL_MEASURE__DEFAULT_QUERY;

	/**
	 * The feature id for the '<em><b>Measure Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__MEASURE_RELATIONSHIPS = DIMENSIONAL_MEASURE__MEASURE_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Category</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__CATEGORY = DIMENSIONAL_MEASURE__CATEGORY;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__SCOPE = DIMENSIONAL_MEASURE__SCOPE;

	/**
	 * The feature id for the '<em><b>Trait</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__TRAIT = DIMENSIONAL_MEASURE__TRAIT;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__SCALE = DIMENSIONAL_MEASURE__SCALE;

	/**
	 * The feature id for the '<em><b>Custom Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__CUSTOM_SCALE = DIMENSIONAL_MEASURE__CUSTOM_SCALE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__UNIT = DIMENSIONAL_MEASURE__UNIT;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__FORMULA = DIMENSIONAL_MEASURE__FORMULA;

	/**
	 * The feature id for the '<em><b>Interval</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE__INTERVAL = DIMENSIONAL_MEASURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ranking Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE_FEATURE_COUNT = DIMENSIONAL_MEASURE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get All Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE___GET_ALL_ARGUMENTS = DIMENSIONAL_MEASURE___GET_ALL_ARGUMENTS;

	/**
	 * The operation id for the '<em>Get Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE___GET_ARGUMENTS = DIMENSIONAL_MEASURE___GET_ARGUMENTS;

	/**
	 * The number of operations of the '<em>Ranking Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASURE_OPERATION_COUNT = DIMENSIONAL_MEASURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.IntervalImpl <em>Interval</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.IntervalImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getInterval()
	 * @generated
	 */
	int INTERVAL = 30;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL__DESCRIPTION = SMM_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL__NAME = SMM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL__SHORT_DESCRIPTION = SMM_ELEMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL__IN_RELATIONSHIPS = SMM_ELEMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL__OUT_RELATIONSHIPS = SMM_ELEMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL__ATTRIBUTES = SMM_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL__ANNOTATIONS = SMM_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Maximum Endpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL__MAXIMUM_ENDPOINT = SMM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Maximum Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL__MAXIMUM_OPEN = SMM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Minimum Endpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL__MINIMUM_ENDPOINT = SMM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Minimum Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL__MINIMUM_OPEN = SMM_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Interval</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_FEATURE_COUNT = SMM_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Interval</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_OPERATION_COUNT = SMM_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.RankingIntervalImpl <em>Ranking Interval</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.RankingIntervalImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getRankingInterval()
	 * @generated
	 */
	int RANKING_INTERVAL = 29;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_INTERVAL__DESCRIPTION = INTERVAL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_INTERVAL__NAME = INTERVAL__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_INTERVAL__SHORT_DESCRIPTION = INTERVAL__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_INTERVAL__IN_RELATIONSHIPS = INTERVAL__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_INTERVAL__OUT_RELATIONSHIPS = INTERVAL__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_INTERVAL__ATTRIBUTES = INTERVAL__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_INTERVAL__ANNOTATIONS = INTERVAL__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Maximum Endpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_INTERVAL__MAXIMUM_ENDPOINT = INTERVAL__MAXIMUM_ENDPOINT;

	/**
	 * The feature id for the '<em><b>Maximum Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_INTERVAL__MAXIMUM_OPEN = INTERVAL__MAXIMUM_OPEN;

	/**
	 * The feature id for the '<em><b>Minimum Endpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_INTERVAL__MINIMUM_ENDPOINT = INTERVAL__MINIMUM_ENDPOINT;

	/**
	 * The feature id for the '<em><b>Minimum Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_INTERVAL__MINIMUM_OPEN = INTERVAL__MINIMUM_OPEN;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_INTERVAL__VALUE = INTERVAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ranking</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_INTERVAL__RANKING = INTERVAL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ranking Interval</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_INTERVAL_FEATURE_COUNT = INTERVAL_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Ranking Interval</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_INTERVAL_OPERATION_COUNT = INTERVAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.RescaledMeasureRelationshipImpl <em>Rescaled Measure Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.RescaledMeasureRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getRescaledMeasureRelationship()
	 * @generated
	 */
	int RESCALED_MEASURE_RELATIONSHIP = 31;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE_RELATIONSHIP__DESCRIPTION = MEASURE_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE_RELATIONSHIP__NAME = MEASURE_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE_RELATIONSHIP__SHORT_DESCRIPTION = MEASURE_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE_RELATIONSHIP__IN_RELATIONSHIPS = MEASURE_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE_RELATIONSHIP__OUT_RELATIONSHIPS = MEASURE_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE_RELATIONSHIP__ATTRIBUTES = MEASURE_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE_RELATIONSHIP__ANNOTATIONS = MEASURE_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE_RELATIONSHIP__FROM = MEASURE_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE_RELATIONSHIP__TO = MEASURE_RELATIONSHIP__TO;

	/**
	 * The feature id for the '<em><b>Influence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE_RELATIONSHIP__INFLUENCE = MEASURE_RELATIONSHIP__INFLUENCE;

	/**
	 * The feature id for the '<em><b>Measurand Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE_RELATIONSHIP__MEASURAND_QUERY = MEASURE_RELATIONSHIP__MEASURAND_QUERY;

	/**
	 * The number of structural features of the '<em>Rescaled Measure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE_RELATIONSHIP_FEATURE_COUNT = MEASURE_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Rescaled Measure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASURE_RELATIONSHIP_OPERATION_COUNT = MEASURE_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.GradeMeasureRelationshipImpl <em>Grade Measure Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.GradeMeasureRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getGradeMeasureRelationship()
	 * @generated
	 */
	int GRADE_MEASURE_RELATIONSHIP = 32;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE_RELATIONSHIP__DESCRIPTION = MEASURE_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE_RELATIONSHIP__NAME = MEASURE_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE_RELATIONSHIP__SHORT_DESCRIPTION = MEASURE_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE_RELATIONSHIP__IN_RELATIONSHIPS = MEASURE_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE_RELATIONSHIP__OUT_RELATIONSHIPS = MEASURE_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE_RELATIONSHIP__ATTRIBUTES = MEASURE_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE_RELATIONSHIP__ANNOTATIONS = MEASURE_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE_RELATIONSHIP__FROM = MEASURE_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE_RELATIONSHIP__TO = MEASURE_RELATIONSHIP__TO;

	/**
	 * The feature id for the '<em><b>Influence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE_RELATIONSHIP__INFLUENCE = MEASURE_RELATIONSHIP__INFLUENCE;

	/**
	 * The feature id for the '<em><b>Measurand Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE_RELATIONSHIP__MEASURAND_QUERY = MEASURE_RELATIONSHIP__MEASURAND_QUERY;

	/**
	 * The number of structural features of the '<em>Grade Measure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE_RELATIONSHIP_FEATURE_COUNT = MEASURE_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Grade Measure Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE_RELATIONSHIP_OPERATION_COUNT = MEASURE_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.GradeMeasureImpl <em>Grade Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.GradeMeasureImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getGradeMeasure()
	 * @generated
	 */
	int GRADE_MEASURE = 33;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE__DESCRIPTION = MEASURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE__NAME = MEASURE__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE__SHORT_DESCRIPTION = MEASURE__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE__IN_RELATIONSHIPS = MEASURE__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE__OUT_RELATIONSHIPS = MEASURE__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE__ATTRIBUTES = MEASURE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE__ANNOTATIONS = MEASURE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Measure Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE__MEASURE_LABEL_FORMAT = MEASURE__MEASURE_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Measurement Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE__MEASUREMENT_LABEL_FORMAT = MEASURE__MEASUREMENT_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE__VISIBLE = MEASURE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE__SOURCE = MEASURE__SOURCE;

	/**
	 * The feature id for the '<em><b>Default Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE__DEFAULT_QUERY = MEASURE__DEFAULT_QUERY;

	/**
	 * The feature id for the '<em><b>Measure Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE__MEASURE_RELATIONSHIPS = MEASURE__MEASURE_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Category</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE__CATEGORY = MEASURE__CATEGORY;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE__SCOPE = MEASURE__SCOPE;

	/**
	 * The feature id for the '<em><b>Trait</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE__TRAIT = MEASURE__TRAIT;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE__SCALE = MEASURE__SCALE;

	/**
	 * The feature id for the '<em><b>Custom Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE__CUSTOM_SCALE = MEASURE__CUSTOM_SCALE;

	/**
	 * The feature id for the '<em><b>Interval</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE__INTERVAL = MEASURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Grade Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE_FEATURE_COUNT = MEASURE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get All Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE___GET_ALL_ARGUMENTS = MEASURE___GET_ALL_ARGUMENTS;

	/**
	 * The operation id for the '<em>Get Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE___GET_ARGUMENTS = MEASURE___GET_ARGUMENTS;

	/**
	 * The number of operations of the '<em>Grade Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASURE_OPERATION_COUNT = MEASURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.GradeIntervalImpl <em>Grade Interval</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.GradeIntervalImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getGradeInterval()
	 * @generated
	 */
	int GRADE_INTERVAL = 34;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_INTERVAL__DESCRIPTION = INTERVAL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_INTERVAL__NAME = INTERVAL__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_INTERVAL__SHORT_DESCRIPTION = INTERVAL__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_INTERVAL__IN_RELATIONSHIPS = INTERVAL__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_INTERVAL__OUT_RELATIONSHIPS = INTERVAL__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_INTERVAL__ATTRIBUTES = INTERVAL__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_INTERVAL__ANNOTATIONS = INTERVAL__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Maximum Endpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_INTERVAL__MAXIMUM_ENDPOINT = INTERVAL__MAXIMUM_ENDPOINT;

	/**
	 * The feature id for the '<em><b>Maximum Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_INTERVAL__MAXIMUM_OPEN = INTERVAL__MAXIMUM_OPEN;

	/**
	 * The feature id for the '<em><b>Minimum Endpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_INTERVAL__MINIMUM_ENDPOINT = INTERVAL__MINIMUM_ENDPOINT;

	/**
	 * The feature id for the '<em><b>Minimum Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_INTERVAL__MINIMUM_OPEN = INTERVAL__MINIMUM_OPEN;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_INTERVAL__SYMBOL = INTERVAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Grade Interval</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_INTERVAL_FEATURE_COUNT = INTERVAL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Grade Interval</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_INTERVAL_OPERATION_COUNT = INTERVAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.UnitOfMeasureImpl <em>Unit Of Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.UnitOfMeasureImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getUnitOfMeasure()
	 * @generated
	 */
	int UNIT_OF_MEASURE = 35;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_OF_MEASURE__DESCRIPTION = ABSTRACT_MEASURE_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_OF_MEASURE__NAME = ABSTRACT_MEASURE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_OF_MEASURE__SHORT_DESCRIPTION = ABSTRACT_MEASURE_ELEMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_OF_MEASURE__IN_RELATIONSHIPS = ABSTRACT_MEASURE_ELEMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_OF_MEASURE__OUT_RELATIONSHIPS = ABSTRACT_MEASURE_ELEMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_OF_MEASURE__ATTRIBUTES = ABSTRACT_MEASURE_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_OF_MEASURE__ANNOTATIONS = ABSTRACT_MEASURE_ELEMENT__ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Unit Of Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_OF_MEASURE_FEATURE_COUNT = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Unit Of Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_OF_MEASURE_OPERATION_COUNT = ABSTRACT_MEASURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.BaseMeasurementRelationshipImpl <em>Base Measurement Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.BaseMeasurementRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getBaseMeasurementRelationship()
	 * @generated
	 */
	int BASE_MEASUREMENT_RELATIONSHIP = 37;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASUREMENT_RELATIONSHIP__DESCRIPTION = MEASUREMENT_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASUREMENT_RELATIONSHIP__NAME = MEASUREMENT_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASUREMENT_RELATIONSHIP__SHORT_DESCRIPTION = MEASUREMENT_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASUREMENT_RELATIONSHIP__IN_RELATIONSHIPS = MEASUREMENT_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASUREMENT_RELATIONSHIP__OUT_RELATIONSHIPS = MEASUREMENT_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASUREMENT_RELATIONSHIP__ATTRIBUTES = MEASUREMENT_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASUREMENT_RELATIONSHIP__ANNOTATIONS = MEASUREMENT_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASUREMENT_RELATIONSHIP__FROM = MEASUREMENT_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASUREMENT_RELATIONSHIP__TO = MEASUREMENT_RELATIONSHIP__TO;

	/**
	 * The number of structural features of the '<em>Base Measurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASUREMENT_RELATIONSHIP_FEATURE_COUNT = MEASUREMENT_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Base Measurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MEASUREMENT_RELATIONSHIP_OPERATION_COUNT = MEASUREMENT_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.Base1MeasurementRelationshipImpl <em>Base1 Measurement Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.Base1MeasurementRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getBase1MeasurementRelationship()
	 * @generated
	 */
	int BASE1_MEASUREMENT_RELATIONSHIP = 36;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASUREMENT_RELATIONSHIP__DESCRIPTION = BASE_MEASUREMENT_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASUREMENT_RELATIONSHIP__NAME = BASE_MEASUREMENT_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASUREMENT_RELATIONSHIP__SHORT_DESCRIPTION = BASE_MEASUREMENT_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASUREMENT_RELATIONSHIP__IN_RELATIONSHIPS = BASE_MEASUREMENT_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASUREMENT_RELATIONSHIP__OUT_RELATIONSHIPS = BASE_MEASUREMENT_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASUREMENT_RELATIONSHIP__ATTRIBUTES = BASE_MEASUREMENT_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASUREMENT_RELATIONSHIP__ANNOTATIONS = BASE_MEASUREMENT_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASUREMENT_RELATIONSHIP__FROM = BASE_MEASUREMENT_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASUREMENT_RELATIONSHIP__TO = BASE_MEASUREMENT_RELATIONSHIP__TO;

	/**
	 * The number of structural features of the '<em>Base1 Measurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASUREMENT_RELATIONSHIP_FEATURE_COUNT = BASE_MEASUREMENT_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Base1 Measurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE1_MEASUREMENT_RELATIONSHIP_OPERATION_COUNT = BASE_MEASUREMENT_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.DimensionalMeasurementImpl <em>Dimensional Measurement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.DimensionalMeasurementImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getDimensionalMeasurement()
	 * @generated
	 */
	int DIMENSIONAL_MEASUREMENT = 38;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASUREMENT__DESCRIPTION = MEASUREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASUREMENT__NAME = MEASUREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASUREMENT__SHORT_DESCRIPTION = MEASUREMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASUREMENT__IN_RELATIONSHIPS = MEASUREMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASUREMENT__OUT_RELATIONSHIPS = MEASUREMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASUREMENT__ATTRIBUTES = MEASUREMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASUREMENT__ANNOTATIONS = MEASUREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Break Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASUREMENT__BREAK_VALUE = MEASUREMENT__BREAK_VALUE;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASUREMENT__ERROR = MEASUREMENT__ERROR;

	/**
	 * The feature id for the '<em><b>Measurement Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASUREMENT__MEASUREMENT_RELATIONSHIPS = MEASUREMENT__MEASUREMENT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Observed Measure</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASUREMENT__OBSERVED_MEASURE = MEASUREMENT__OBSERVED_MEASURE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASUREMENT__VALUE = MEASUREMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dimensional Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASUREMENT_FEATURE_COUNT = MEASUREMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Measure Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASUREMENT___GET_MEASURE_LABEL = MEASUREMENT___GET_MEASURE_LABEL;

	/**
	 * The operation id for the '<em>Get Measurement Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASUREMENT___GET_MEASUREMENT_LABEL = MEASUREMENT___GET_MEASUREMENT_LABEL;

	/**
	 * The number of operations of the '<em>Dimensional Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSIONAL_MEASUREMENT_OPERATION_COUNT = MEASUREMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.BaseNMeasurementRelationshipImpl <em>Base NMeasurement Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.BaseNMeasurementRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getBaseNMeasurementRelationship()
	 * @generated
	 */
	int BASE_NMEASUREMENT_RELATIONSHIP = 39;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASUREMENT_RELATIONSHIP__DESCRIPTION = BASE_MEASUREMENT_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASUREMENT_RELATIONSHIP__NAME = BASE_MEASUREMENT_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASUREMENT_RELATIONSHIP__SHORT_DESCRIPTION = BASE_MEASUREMENT_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASUREMENT_RELATIONSHIP__IN_RELATIONSHIPS = BASE_MEASUREMENT_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASUREMENT_RELATIONSHIP__OUT_RELATIONSHIPS = BASE_MEASUREMENT_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASUREMENT_RELATIONSHIP__ATTRIBUTES = BASE_MEASUREMENT_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASUREMENT_RELATIONSHIP__ANNOTATIONS = BASE_MEASUREMENT_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASUREMENT_RELATIONSHIP__FROM = BASE_MEASUREMENT_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASUREMENT_RELATIONSHIP__TO = BASE_MEASUREMENT_RELATIONSHIP__TO;

	/**
	 * The number of structural features of the '<em>Base NMeasurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASUREMENT_RELATIONSHIP_FEATURE_COUNT = BASE_MEASUREMENT_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Base NMeasurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NMEASUREMENT_RELATIONSHIP_OPERATION_COUNT = BASE_MEASUREMENT_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.CollectiveMeasurementImpl <em>Collective Measurement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.CollectiveMeasurementImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getCollectiveMeasurement()
	 * @generated
	 */
	int COLLECTIVE_MEASUREMENT = 40;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASUREMENT__DESCRIPTION = DIMENSIONAL_MEASUREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASUREMENT__NAME = DIMENSIONAL_MEASUREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASUREMENT__SHORT_DESCRIPTION = DIMENSIONAL_MEASUREMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASUREMENT__IN_RELATIONSHIPS = DIMENSIONAL_MEASUREMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASUREMENT__OUT_RELATIONSHIPS = DIMENSIONAL_MEASUREMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASUREMENT__ATTRIBUTES = DIMENSIONAL_MEASUREMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASUREMENT__ANNOTATIONS = DIMENSIONAL_MEASUREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Break Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASUREMENT__BREAK_VALUE = DIMENSIONAL_MEASUREMENT__BREAK_VALUE;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASUREMENT__ERROR = DIMENSIONAL_MEASUREMENT__ERROR;

	/**
	 * The feature id for the '<em><b>Measurement Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASUREMENT__MEASUREMENT_RELATIONSHIPS = DIMENSIONAL_MEASUREMENT__MEASUREMENT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Observed Measure</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASUREMENT__OBSERVED_MEASURE = DIMENSIONAL_MEASUREMENT__OBSERVED_MEASURE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASUREMENT__VALUE = DIMENSIONAL_MEASUREMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Is Base Supplied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASUREMENT__IS_BASE_SUPPLIED = DIMENSIONAL_MEASUREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASUREMENT__BASE_QUERY = DIMENSIONAL_MEASUREMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collective Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASUREMENT_FEATURE_COUNT = DIMENSIONAL_MEASUREMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Measure Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASUREMENT___GET_MEASURE_LABEL = DIMENSIONAL_MEASUREMENT___GET_MEASURE_LABEL;

	/**
	 * The operation id for the '<em>Get Measurement Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASUREMENT___GET_MEASUREMENT_LABEL = DIMENSIONAL_MEASUREMENT___GET_MEASUREMENT_LABEL;

	/**
	 * The number of operations of the '<em>Collective Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_MEASUREMENT_OPERATION_COUNT = DIMENSIONAL_MEASUREMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.Base2MeasurementRelationshipImpl <em>Base2 Measurement Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.Base2MeasurementRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getBase2MeasurementRelationship()
	 * @generated
	 */
	int BASE2_MEASUREMENT_RELATIONSHIP = 41;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASUREMENT_RELATIONSHIP__DESCRIPTION = BASE_MEASUREMENT_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASUREMENT_RELATIONSHIP__NAME = BASE_MEASUREMENT_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASUREMENT_RELATIONSHIP__SHORT_DESCRIPTION = BASE_MEASUREMENT_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASUREMENT_RELATIONSHIP__IN_RELATIONSHIPS = BASE_MEASUREMENT_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASUREMENT_RELATIONSHIP__OUT_RELATIONSHIPS = BASE_MEASUREMENT_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASUREMENT_RELATIONSHIP__ATTRIBUTES = BASE_MEASUREMENT_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASUREMENT_RELATIONSHIP__ANNOTATIONS = BASE_MEASUREMENT_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASUREMENT_RELATIONSHIP__FROM = BASE_MEASUREMENT_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASUREMENT_RELATIONSHIP__TO = BASE_MEASUREMENT_RELATIONSHIP__TO;

	/**
	 * The number of structural features of the '<em>Base2 Measurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASUREMENT_RELATIONSHIP_FEATURE_COUNT = BASE_MEASUREMENT_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Base2 Measurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE2_MEASUREMENT_RELATIONSHIP_OPERATION_COUNT = BASE_MEASUREMENT_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.BinaryMeasurementImpl <em>Binary Measurement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.BinaryMeasurementImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getBinaryMeasurement()
	 * @generated
	 */
	int BINARY_MEASUREMENT = 42;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASUREMENT__DESCRIPTION = DIMENSIONAL_MEASUREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASUREMENT__NAME = DIMENSIONAL_MEASUREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASUREMENT__SHORT_DESCRIPTION = DIMENSIONAL_MEASUREMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASUREMENT__IN_RELATIONSHIPS = DIMENSIONAL_MEASUREMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASUREMENT__OUT_RELATIONSHIPS = DIMENSIONAL_MEASUREMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASUREMENT__ATTRIBUTES = DIMENSIONAL_MEASUREMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASUREMENT__ANNOTATIONS = DIMENSIONAL_MEASUREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Break Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASUREMENT__BREAK_VALUE = DIMENSIONAL_MEASUREMENT__BREAK_VALUE;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASUREMENT__ERROR = DIMENSIONAL_MEASUREMENT__ERROR;

	/**
	 * The feature id for the '<em><b>Measurement Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASUREMENT__MEASUREMENT_RELATIONSHIPS = DIMENSIONAL_MEASUREMENT__MEASUREMENT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Observed Measure</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASUREMENT__OBSERVED_MEASURE = DIMENSIONAL_MEASUREMENT__OBSERVED_MEASURE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASUREMENT__VALUE = DIMENSIONAL_MEASUREMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Is Base Supplied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASUREMENT__IS_BASE_SUPPLIED = DIMENSIONAL_MEASUREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASUREMENT__BASE_QUERY = DIMENSIONAL_MEASUREMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASUREMENT_FEATURE_COUNT = DIMENSIONAL_MEASUREMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Measure Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASUREMENT___GET_MEASURE_LABEL = DIMENSIONAL_MEASUREMENT___GET_MEASURE_LABEL;

	/**
	 * The operation id for the '<em>Get Measurement Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASUREMENT___GET_MEASUREMENT_LABEL = DIMENSIONAL_MEASUREMENT___GET_MEASUREMENT_LABEL;

	/**
	 * The number of operations of the '<em>Binary Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_MEASUREMENT_OPERATION_COUNT = DIMENSIONAL_MEASUREMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.GradeMeasurementRelationshipImpl <em>Grade Measurement Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.GradeMeasurementRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getGradeMeasurementRelationship()
	 * @generated
	 */
	int GRADE_MEASUREMENT_RELATIONSHIP = 43;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT_RELATIONSHIP__DESCRIPTION = MEASUREMENT_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT_RELATIONSHIP__NAME = MEASUREMENT_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT_RELATIONSHIP__SHORT_DESCRIPTION = MEASUREMENT_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT_RELATIONSHIP__IN_RELATIONSHIPS = MEASUREMENT_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT_RELATIONSHIP__OUT_RELATIONSHIPS = MEASUREMENT_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT_RELATIONSHIP__ATTRIBUTES = MEASUREMENT_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT_RELATIONSHIP__ANNOTATIONS = MEASUREMENT_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT_RELATIONSHIP__FROM = MEASUREMENT_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT_RELATIONSHIP__TO = MEASUREMENT_RELATIONSHIP__TO;

	/**
	 * The number of structural features of the '<em>Grade Measurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT_RELATIONSHIP_FEATURE_COUNT = MEASUREMENT_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Grade Measurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT_RELATIONSHIP_OPERATION_COUNT = MEASUREMENT_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.GradeMeasurementImpl <em>Grade Measurement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.GradeMeasurementImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getGradeMeasurement()
	 * @generated
	 */
	int GRADE_MEASUREMENT = 44;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT__DESCRIPTION = MEASUREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT__NAME = MEASUREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT__SHORT_DESCRIPTION = MEASUREMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT__IN_RELATIONSHIPS = MEASUREMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT__OUT_RELATIONSHIPS = MEASUREMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT__ATTRIBUTES = MEASUREMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT__ANNOTATIONS = MEASUREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Break Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT__BREAK_VALUE = MEASUREMENT__BREAK_VALUE;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT__ERROR = MEASUREMENT__ERROR;

	/**
	 * The feature id for the '<em><b>Measurement Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT__MEASUREMENT_RELATIONSHIPS = MEASUREMENT__MEASUREMENT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Observed Measure</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT__OBSERVED_MEASURE = MEASUREMENT__OBSERVED_MEASURE;

	/**
	 * The feature id for the '<em><b>Is Base Supplied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT__IS_BASE_SUPPLIED = MEASUREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT__VALUE = MEASUREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT__BASE_QUERY = MEASUREMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Grade Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT_FEATURE_COUNT = MEASUREMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Measure Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT___GET_MEASURE_LABEL = MEASUREMENT___GET_MEASURE_LABEL;

	/**
	 * The operation id for the '<em>Get Measurement Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT___GET_MEASUREMENT_LABEL = MEASUREMENT___GET_MEASUREMENT_LABEL;

	/**
	 * The number of operations of the '<em>Grade Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRADE_MEASUREMENT_OPERATION_COUNT = MEASUREMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.RescaledMeasurementRelationshipImpl <em>Rescaled Measurement Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.RescaledMeasurementRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getRescaledMeasurementRelationship()
	 * @generated
	 */
	int RESCALED_MEASUREMENT_RELATIONSHIP = 45;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT_RELATIONSHIP__DESCRIPTION = MEASUREMENT_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT_RELATIONSHIP__NAME = MEASUREMENT_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT_RELATIONSHIP__SHORT_DESCRIPTION = MEASUREMENT_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT_RELATIONSHIP__IN_RELATIONSHIPS = MEASUREMENT_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT_RELATIONSHIP__OUT_RELATIONSHIPS = MEASUREMENT_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT_RELATIONSHIP__ATTRIBUTES = MEASUREMENT_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT_RELATIONSHIP__ANNOTATIONS = MEASUREMENT_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT_RELATIONSHIP__FROM = MEASUREMENT_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT_RELATIONSHIP__TO = MEASUREMENT_RELATIONSHIP__TO;

	/**
	 * The number of structural features of the '<em>Rescaled Measurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT_RELATIONSHIP_FEATURE_COUNT = MEASUREMENT_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Rescaled Measurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT_RELATIONSHIP_OPERATION_COUNT = MEASUREMENT_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.RescaledMeasurementImpl <em>Rescaled Measurement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.RescaledMeasurementImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getRescaledMeasurement()
	 * @generated
	 */
	int RESCALED_MEASUREMENT = 46;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT__DESCRIPTION = DIMENSIONAL_MEASUREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT__NAME = DIMENSIONAL_MEASUREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT__SHORT_DESCRIPTION = DIMENSIONAL_MEASUREMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT__IN_RELATIONSHIPS = DIMENSIONAL_MEASUREMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT__OUT_RELATIONSHIPS = DIMENSIONAL_MEASUREMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT__ATTRIBUTES = DIMENSIONAL_MEASUREMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT__ANNOTATIONS = DIMENSIONAL_MEASUREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Break Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT__BREAK_VALUE = DIMENSIONAL_MEASUREMENT__BREAK_VALUE;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT__ERROR = DIMENSIONAL_MEASUREMENT__ERROR;

	/**
	 * The feature id for the '<em><b>Measurement Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT__MEASUREMENT_RELATIONSHIPS = DIMENSIONAL_MEASUREMENT__MEASUREMENT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Observed Measure</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT__OBSERVED_MEASURE = DIMENSIONAL_MEASUREMENT__OBSERVED_MEASURE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT__VALUE = DIMENSIONAL_MEASUREMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Is Base Supplied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT__IS_BASE_SUPPLIED = DIMENSIONAL_MEASUREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT__BASE_QUERY = DIMENSIONAL_MEASUREMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Rescaled Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT_FEATURE_COUNT = DIMENSIONAL_MEASUREMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Measure Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT___GET_MEASURE_LABEL = DIMENSIONAL_MEASUREMENT___GET_MEASURE_LABEL;

	/**
	 * The operation id for the '<em>Get Measurement Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT___GET_MEASUREMENT_LABEL = DIMENSIONAL_MEASUREMENT___GET_MEASUREMENT_LABEL;

	/**
	 * The number of operations of the '<em>Rescaled Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESCALED_MEASUREMENT_OPERATION_COUNT = DIMENSIONAL_MEASUREMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.RankingMeasurementRelationshipImpl <em>Ranking Measurement Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.RankingMeasurementRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getRankingMeasurementRelationship()
	 * @generated
	 */
	int RANKING_MEASUREMENT_RELATIONSHIP = 47;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT_RELATIONSHIP__DESCRIPTION = MEASUREMENT_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT_RELATIONSHIP__NAME = MEASUREMENT_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT_RELATIONSHIP__SHORT_DESCRIPTION = MEASUREMENT_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT_RELATIONSHIP__IN_RELATIONSHIPS = MEASUREMENT_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT_RELATIONSHIP__OUT_RELATIONSHIPS = MEASUREMENT_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT_RELATIONSHIP__ATTRIBUTES = MEASUREMENT_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT_RELATIONSHIP__ANNOTATIONS = MEASUREMENT_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT_RELATIONSHIP__FROM = MEASUREMENT_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT_RELATIONSHIP__TO = MEASUREMENT_RELATIONSHIP__TO;

	/**
	 * The number of structural features of the '<em>Ranking Measurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT_RELATIONSHIP_FEATURE_COUNT = MEASUREMENT_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Ranking Measurement Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT_RELATIONSHIP_OPERATION_COUNT = MEASUREMENT_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.RankingMeasurementImpl <em>Ranking Measurement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.RankingMeasurementImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getRankingMeasurement()
	 * @generated
	 */
	int RANKING_MEASUREMENT = 48;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT__DESCRIPTION = DIMENSIONAL_MEASUREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT__NAME = DIMENSIONAL_MEASUREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT__SHORT_DESCRIPTION = DIMENSIONAL_MEASUREMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT__IN_RELATIONSHIPS = DIMENSIONAL_MEASUREMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT__OUT_RELATIONSHIPS = DIMENSIONAL_MEASUREMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT__ATTRIBUTES = DIMENSIONAL_MEASUREMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT__ANNOTATIONS = DIMENSIONAL_MEASUREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Break Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT__BREAK_VALUE = DIMENSIONAL_MEASUREMENT__BREAK_VALUE;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT__ERROR = DIMENSIONAL_MEASUREMENT__ERROR;

	/**
	 * The feature id for the '<em><b>Measurement Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT__MEASUREMENT_RELATIONSHIPS = DIMENSIONAL_MEASUREMENT__MEASUREMENT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Observed Measure</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT__OBSERVED_MEASURE = DIMENSIONAL_MEASUREMENT__OBSERVED_MEASURE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT__VALUE = DIMENSIONAL_MEASUREMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Base Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT__BASE_QUERY = DIMENSIONAL_MEASUREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Base Supplied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT__IS_BASE_SUPPLIED = DIMENSIONAL_MEASUREMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ranking Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT_FEATURE_COUNT = DIMENSIONAL_MEASUREMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Measure Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT___GET_MEASURE_LABEL = DIMENSIONAL_MEASUREMENT___GET_MEASURE_LABEL;

	/**
	 * The operation id for the '<em>Get Measurement Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT___GET_MEASUREMENT_LABEL = DIMENSIONAL_MEASUREMENT___GET_MEASUREMENT_LABEL;

	/**
	 * The number of operations of the '<em>Ranking Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANKING_MEASUREMENT_OPERATION_COUNT = DIMENSIONAL_MEASUREMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.CategoryRelationshipImpl <em>Category Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.CategoryRelationshipImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getCategoryRelationship()
	 * @generated
	 */
	int CATEGORY_RELATIONSHIP = 49;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_RELATIONSHIP__DESCRIPTION = SMM_RELATIONSHIP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_RELATIONSHIP__NAME = SMM_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_RELATIONSHIP__SHORT_DESCRIPTION = SMM_RELATIONSHIP__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_RELATIONSHIP__IN_RELATIONSHIPS = SMM_RELATIONSHIP__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_RELATIONSHIP__OUT_RELATIONSHIPS = SMM_RELATIONSHIP__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_RELATIONSHIP__ATTRIBUTES = SMM_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_RELATIONSHIP__ANNOTATIONS = SMM_RELATIONSHIP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_RELATIONSHIP__FROM = SMM_RELATIONSHIP__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_RELATIONSHIP__TO = SMM_RELATIONSHIP__TO;

	/**
	 * The number of structural features of the '<em>Category Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_RELATIONSHIP_FEATURE_COUNT = SMM_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Category Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_RELATIONSHIP_OPERATION_COUNT = SMM_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.DirectMeasurementImpl <em>Direct Measurement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.DirectMeasurementImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getDirectMeasurement()
	 * @generated
	 */
	int DIRECT_MEASUREMENT = 51;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASUREMENT__DESCRIPTION = DIMENSIONAL_MEASUREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASUREMENT__NAME = DIMENSIONAL_MEASUREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASUREMENT__SHORT_DESCRIPTION = DIMENSIONAL_MEASUREMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASUREMENT__IN_RELATIONSHIPS = DIMENSIONAL_MEASUREMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASUREMENT__OUT_RELATIONSHIPS = DIMENSIONAL_MEASUREMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASUREMENT__ATTRIBUTES = DIMENSIONAL_MEASUREMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASUREMENT__ANNOTATIONS = DIMENSIONAL_MEASUREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Break Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASUREMENT__BREAK_VALUE = DIMENSIONAL_MEASUREMENT__BREAK_VALUE;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASUREMENT__ERROR = DIMENSIONAL_MEASUREMENT__ERROR;

	/**
	 * The feature id for the '<em><b>Measurement Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASUREMENT__MEASUREMENT_RELATIONSHIPS = DIMENSIONAL_MEASUREMENT__MEASUREMENT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Observed Measure</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASUREMENT__OBSERVED_MEASURE = DIMENSIONAL_MEASUREMENT__OBSERVED_MEASURE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASUREMENT__VALUE = DIMENSIONAL_MEASUREMENT__VALUE;

	/**
	 * The number of structural features of the '<em>Direct Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASUREMENT_FEATURE_COUNT = DIMENSIONAL_MEASUREMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Measure Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASUREMENT___GET_MEASURE_LABEL = DIMENSIONAL_MEASUREMENT___GET_MEASURE_LABEL;

	/**
	 * The operation id for the '<em>Get Measurement Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASUREMENT___GET_MEASUREMENT_LABEL = DIMENSIONAL_MEASUREMENT___GET_MEASUREMENT_LABEL;

	/**
	 * The number of operations of the '<em>Direct Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASUREMENT_OPERATION_COUNT = DIMENSIONAL_MEASUREMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.CountingMeasurementImpl <em>Counting Measurement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.CountingMeasurementImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getCountingMeasurement()
	 * @generated
	 */
	int COUNTING_MEASUREMENT = 50;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASUREMENT__DESCRIPTION = DIRECT_MEASUREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASUREMENT__NAME = DIRECT_MEASUREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASUREMENT__SHORT_DESCRIPTION = DIRECT_MEASUREMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASUREMENT__IN_RELATIONSHIPS = DIRECT_MEASUREMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASUREMENT__OUT_RELATIONSHIPS = DIRECT_MEASUREMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASUREMENT__ATTRIBUTES = DIRECT_MEASUREMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASUREMENT__ANNOTATIONS = DIRECT_MEASUREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Break Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASUREMENT__BREAK_VALUE = DIRECT_MEASUREMENT__BREAK_VALUE;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASUREMENT__ERROR = DIRECT_MEASUREMENT__ERROR;

	/**
	 * The feature id for the '<em><b>Measurement Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASUREMENT__MEASUREMENT_RELATIONSHIPS = DIRECT_MEASUREMENT__MEASUREMENT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Observed Measure</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASUREMENT__OBSERVED_MEASURE = DIRECT_MEASUREMENT__OBSERVED_MEASURE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASUREMENT__VALUE = DIRECT_MEASUREMENT__VALUE;

	/**
	 * The number of structural features of the '<em>Counting Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASUREMENT_FEATURE_COUNT = DIRECT_MEASUREMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Measure Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASUREMENT___GET_MEASURE_LABEL = DIRECT_MEASUREMENT___GET_MEASURE_LABEL;

	/**
	 * The operation id for the '<em>Get Measurement Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASUREMENT___GET_MEASUREMENT_LABEL = DIRECT_MEASUREMENT___GET_MEASUREMENT_LABEL;

	/**
	 * The number of operations of the '<em>Counting Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASUREMENT_OPERATION_COUNT = DIRECT_MEASUREMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.DirectMeasureImpl <em>Direct Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.DirectMeasureImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getDirectMeasure()
	 * @generated
	 */
	int DIRECT_MEASURE = 53;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__DESCRIPTION = DIMENSIONAL_MEASURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__NAME = DIMENSIONAL_MEASURE__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__SHORT_DESCRIPTION = DIMENSIONAL_MEASURE__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__IN_RELATIONSHIPS = DIMENSIONAL_MEASURE__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__OUT_RELATIONSHIPS = DIMENSIONAL_MEASURE__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__ATTRIBUTES = DIMENSIONAL_MEASURE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__ANNOTATIONS = DIMENSIONAL_MEASURE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Measure Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__MEASURE_LABEL_FORMAT = DIMENSIONAL_MEASURE__MEASURE_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Measurement Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__MEASUREMENT_LABEL_FORMAT = DIMENSIONAL_MEASURE__MEASUREMENT_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__VISIBLE = DIMENSIONAL_MEASURE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__SOURCE = DIMENSIONAL_MEASURE__SOURCE;

	/**
	 * The feature id for the '<em><b>Default Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__DEFAULT_QUERY = DIMENSIONAL_MEASURE__DEFAULT_QUERY;

	/**
	 * The feature id for the '<em><b>Measure Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__MEASURE_RELATIONSHIPS = DIMENSIONAL_MEASURE__MEASURE_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Category</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__CATEGORY = DIMENSIONAL_MEASURE__CATEGORY;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__SCOPE = DIMENSIONAL_MEASURE__SCOPE;

	/**
	 * The feature id for the '<em><b>Trait</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__TRAIT = DIMENSIONAL_MEASURE__TRAIT;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__SCALE = DIMENSIONAL_MEASURE__SCALE;

	/**
	 * The feature id for the '<em><b>Custom Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__CUSTOM_SCALE = DIMENSIONAL_MEASURE__CUSTOM_SCALE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__UNIT = DIMENSIONAL_MEASURE__UNIT;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__FORMULA = DIMENSIONAL_MEASURE__FORMULA;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE__OPERATION = DIMENSIONAL_MEASURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Direct Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE_FEATURE_COUNT = DIMENSIONAL_MEASURE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get All Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE___GET_ALL_ARGUMENTS = DIMENSIONAL_MEASURE___GET_ALL_ARGUMENTS;

	/**
	 * The operation id for the '<em>Get Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE___GET_ARGUMENTS = DIMENSIONAL_MEASURE___GET_ARGUMENTS;

	/**
	 * The number of operations of the '<em>Direct Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_MEASURE_OPERATION_COUNT = DIMENSIONAL_MEASURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.CountingMeasureImpl <em>Counting Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.CountingMeasureImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getCountingMeasure()
	 * @generated
	 */
	int COUNTING_MEASURE = 52;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__DESCRIPTION = DIRECT_MEASURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__NAME = DIRECT_MEASURE__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__SHORT_DESCRIPTION = DIRECT_MEASURE__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__IN_RELATIONSHIPS = DIRECT_MEASURE__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__OUT_RELATIONSHIPS = DIRECT_MEASURE__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__ATTRIBUTES = DIRECT_MEASURE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__ANNOTATIONS = DIRECT_MEASURE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Measure Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__MEASURE_LABEL_FORMAT = DIRECT_MEASURE__MEASURE_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Measurement Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__MEASUREMENT_LABEL_FORMAT = DIRECT_MEASURE__MEASUREMENT_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__VISIBLE = DIRECT_MEASURE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__SOURCE = DIRECT_MEASURE__SOURCE;

	/**
	 * The feature id for the '<em><b>Default Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__DEFAULT_QUERY = DIRECT_MEASURE__DEFAULT_QUERY;

	/**
	 * The feature id for the '<em><b>Measure Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__MEASURE_RELATIONSHIPS = DIRECT_MEASURE__MEASURE_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Category</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__CATEGORY = DIRECT_MEASURE__CATEGORY;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__SCOPE = DIRECT_MEASURE__SCOPE;

	/**
	 * The feature id for the '<em><b>Trait</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__TRAIT = DIRECT_MEASURE__TRAIT;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__SCALE = DIRECT_MEASURE__SCALE;

	/**
	 * The feature id for the '<em><b>Custom Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__CUSTOM_SCALE = DIRECT_MEASURE__CUSTOM_SCALE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__UNIT = DIRECT_MEASURE__UNIT;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__FORMULA = DIRECT_MEASURE__FORMULA;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE__OPERATION = DIRECT_MEASURE__OPERATION;

	/**
	 * The number of structural features of the '<em>Counting Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE_FEATURE_COUNT = DIRECT_MEASURE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get All Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE___GET_ALL_ARGUMENTS = DIRECT_MEASURE___GET_ALL_ARGUMENTS;

	/**
	 * The operation id for the '<em>Get Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE___GET_ARGUMENTS = DIRECT_MEASURE___GET_ARGUMENTS;

	/**
	 * The number of operations of the '<em>Counting Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTING_MEASURE_OPERATION_COUNT = DIRECT_MEASURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.MeasureLibraryImpl <em>Measure Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.MeasureLibraryImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getMeasureLibrary()
	 * @generated
	 */
	int MEASURE_LIBRARY = 54;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_LIBRARY__DESCRIPTION = SMM_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_LIBRARY__NAME = SMM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_LIBRARY__SHORT_DESCRIPTION = SMM_ELEMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_LIBRARY__IN_RELATIONSHIPS = SMM_ELEMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_LIBRARY__OUT_RELATIONSHIPS = SMM_ELEMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_LIBRARY__ATTRIBUTES = SMM_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_LIBRARY__ANNOTATIONS = SMM_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Measure Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_LIBRARY__MEASURE_ELEMENTS = SMM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Category Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_LIBRARY__CATEGORY_RELATIONSHIPS = SMM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Measure Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_LIBRARY_FEATURE_COUNT = SMM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Measure Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_LIBRARY_OPERATION_COUNT = SMM_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.NamedMeasureImpl <em>Named Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.NamedMeasureImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getNamedMeasure()
	 * @generated
	 */
	int NAMED_MEASURE = 55;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__DESCRIPTION = DIMENSIONAL_MEASURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__NAME = DIMENSIONAL_MEASURE__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__SHORT_DESCRIPTION = DIMENSIONAL_MEASURE__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__IN_RELATIONSHIPS = DIMENSIONAL_MEASURE__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__OUT_RELATIONSHIPS = DIMENSIONAL_MEASURE__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__ATTRIBUTES = DIMENSIONAL_MEASURE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__ANNOTATIONS = DIMENSIONAL_MEASURE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Measure Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__MEASURE_LABEL_FORMAT = DIMENSIONAL_MEASURE__MEASURE_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Measurement Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__MEASUREMENT_LABEL_FORMAT = DIMENSIONAL_MEASURE__MEASUREMENT_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__VISIBLE = DIMENSIONAL_MEASURE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__SOURCE = DIMENSIONAL_MEASURE__SOURCE;

	/**
	 * The feature id for the '<em><b>Default Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__DEFAULT_QUERY = DIMENSIONAL_MEASURE__DEFAULT_QUERY;

	/**
	 * The feature id for the '<em><b>Measure Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__MEASURE_RELATIONSHIPS = DIMENSIONAL_MEASURE__MEASURE_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Category</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__CATEGORY = DIMENSIONAL_MEASURE__CATEGORY;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__SCOPE = DIMENSIONAL_MEASURE__SCOPE;

	/**
	 * The feature id for the '<em><b>Trait</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__TRAIT = DIMENSIONAL_MEASURE__TRAIT;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__SCALE = DIMENSIONAL_MEASURE__SCALE;

	/**
	 * The feature id for the '<em><b>Custom Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__CUSTOM_SCALE = DIMENSIONAL_MEASURE__CUSTOM_SCALE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__UNIT = DIMENSIONAL_MEASURE__UNIT;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE__FORMULA = DIMENSIONAL_MEASURE__FORMULA;

	/**
	 * The number of structural features of the '<em>Named Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE_FEATURE_COUNT = DIMENSIONAL_MEASURE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get All Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE___GET_ALL_ARGUMENTS = DIMENSIONAL_MEASURE___GET_ALL_ARGUMENTS;

	/**
	 * The operation id for the '<em>Get Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE___GET_ARGUMENTS = DIMENSIONAL_MEASURE___GET_ARGUMENTS;

	/**
	 * The number of operations of the '<em>Named Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASURE_OPERATION_COUNT = DIMENSIONAL_MEASURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.NamedMeasurementImpl <em>Named Measurement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.NamedMeasurementImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getNamedMeasurement()
	 * @generated
	 */
	int NAMED_MEASUREMENT = 56;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASUREMENT__DESCRIPTION = DIMENSIONAL_MEASUREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASUREMENT__NAME = DIMENSIONAL_MEASUREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASUREMENT__SHORT_DESCRIPTION = DIMENSIONAL_MEASUREMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASUREMENT__IN_RELATIONSHIPS = DIMENSIONAL_MEASUREMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASUREMENT__OUT_RELATIONSHIPS = DIMENSIONAL_MEASUREMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASUREMENT__ATTRIBUTES = DIMENSIONAL_MEASUREMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASUREMENT__ANNOTATIONS = DIMENSIONAL_MEASUREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Break Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASUREMENT__BREAK_VALUE = DIMENSIONAL_MEASUREMENT__BREAK_VALUE;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASUREMENT__ERROR = DIMENSIONAL_MEASUREMENT__ERROR;

	/**
	 * The feature id for the '<em><b>Measurement Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASUREMENT__MEASUREMENT_RELATIONSHIPS = DIMENSIONAL_MEASUREMENT__MEASUREMENT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Observed Measure</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASUREMENT__OBSERVED_MEASURE = DIMENSIONAL_MEASUREMENT__OBSERVED_MEASURE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASUREMENT__VALUE = DIMENSIONAL_MEASUREMENT__VALUE;

	/**
	 * The number of structural features of the '<em>Named Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASUREMENT_FEATURE_COUNT = DIMENSIONAL_MEASUREMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Measure Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASUREMENT___GET_MEASURE_LABEL = DIMENSIONAL_MEASUREMENT___GET_MEASURE_LABEL;

	/**
	 * The operation id for the '<em>Get Measurement Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASUREMENT___GET_MEASUREMENT_LABEL = DIMENSIONAL_MEASUREMENT___GET_MEASUREMENT_LABEL;

	/**
	 * The number of operations of the '<em>Named Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MEASUREMENT_OPERATION_COUNT = DIMENSIONAL_MEASUREMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.OCLOperationImpl <em>OCL Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.OCLOperationImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getOCLOperation()
	 * @generated
	 */
	int OCL_OPERATION = 57;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATION__DESCRIPTION = ABSTRACT_MEASURE_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATION__NAME = ABSTRACT_MEASURE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATION__SHORT_DESCRIPTION = ABSTRACT_MEASURE_ELEMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATION__IN_RELATIONSHIPS = ABSTRACT_MEASURE_ELEMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATION__OUT_RELATIONSHIPS = ABSTRACT_MEASURE_ELEMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATION__ATTRIBUTES = ABSTRACT_MEASURE_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATION__ANNOTATIONS = ABSTRACT_MEASURE_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATION__BODY = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATION__CONTEXT = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>OCL Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATION_FEATURE_COUNT = ABSTRACT_MEASURE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>OCL Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATION_OPERATION_COUNT = ABSTRACT_MEASURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.ObservationImpl <em>Observation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.ObservationImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getObservation()
	 * @generated
	 */
	int OBSERVATION = 58;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION__DESCRIPTION = SMM_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION__NAME = SMM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION__SHORT_DESCRIPTION = SMM_ELEMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION__IN_RELATIONSHIPS = SMM_ELEMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION__OUT_RELATIONSHIPS = SMM_ELEMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION__ATTRIBUTES = SMM_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION__ANNOTATIONS = SMM_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Observer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION__OBSERVER = SMM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION__TOOL = SMM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>When Observed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION__WHEN_OBSERVED = SMM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION__SCOPES = SMM_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Observed Measures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION__OBSERVED_MEASURES = SMM_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION__ARGUMENTS = SMM_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Requested Measures</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION__REQUESTED_MEASURES = SMM_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Observation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION_FEATURE_COUNT = SMM_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Observation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION_OPERATION_COUNT = SMM_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.ObservationScopeImpl <em>Observation Scope</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.ObservationScopeImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getObservationScope()
	 * @generated
	 */
	int OBSERVATION_SCOPE = 59;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION_SCOPE__DESCRIPTION = SMM_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION_SCOPE__NAME = SMM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION_SCOPE__SHORT_DESCRIPTION = SMM_ELEMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION_SCOPE__IN_RELATIONSHIPS = SMM_ELEMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION_SCOPE__OUT_RELATIONSHIPS = SMM_ELEMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION_SCOPE__ATTRIBUTES = SMM_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION_SCOPE__ANNOTATIONS = SMM_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Scope Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION_SCOPE__SCOPE_URI = SMM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Observation Scope</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION_SCOPE_FEATURE_COUNT = SMM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Observation Scope</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION_SCOPE_OPERATION_COUNT = SMM_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.RatioMeasureImpl <em>Ratio Measure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.RatioMeasureImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getRatioMeasure()
	 * @generated
	 */
	int RATIO_MEASURE = 60;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__DESCRIPTION = BINARY_MEASURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__NAME = BINARY_MEASURE__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__SHORT_DESCRIPTION = BINARY_MEASURE__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__IN_RELATIONSHIPS = BINARY_MEASURE__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__OUT_RELATIONSHIPS = BINARY_MEASURE__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__ATTRIBUTES = BINARY_MEASURE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__ANNOTATIONS = BINARY_MEASURE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Measure Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__MEASURE_LABEL_FORMAT = BINARY_MEASURE__MEASURE_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Measurement Label Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__MEASUREMENT_LABEL_FORMAT = BINARY_MEASURE__MEASUREMENT_LABEL_FORMAT;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__VISIBLE = BINARY_MEASURE__VISIBLE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__SOURCE = BINARY_MEASURE__SOURCE;

	/**
	 * The feature id for the '<em><b>Default Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__DEFAULT_QUERY = BINARY_MEASURE__DEFAULT_QUERY;

	/**
	 * The feature id for the '<em><b>Measure Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__MEASURE_RELATIONSHIPS = BINARY_MEASURE__MEASURE_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Category</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__CATEGORY = BINARY_MEASURE__CATEGORY;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__SCOPE = BINARY_MEASURE__SCOPE;

	/**
	 * The feature id for the '<em><b>Trait</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__TRAIT = BINARY_MEASURE__TRAIT;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__SCALE = BINARY_MEASURE__SCALE;

	/**
	 * The feature id for the '<em><b>Custom Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__CUSTOM_SCALE = BINARY_MEASURE__CUSTOM_SCALE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__UNIT = BINARY_MEASURE__UNIT;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__FORMULA = BINARY_MEASURE__FORMULA;

	/**
	 * The feature id for the '<em><b>Functor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__FUNCTOR = BINARY_MEASURE__FUNCTOR;

	/**
	 * The feature id for the '<em><b>Custom Functor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE__CUSTOM_FUNCTOR = BINARY_MEASURE__CUSTOM_FUNCTOR;

	/**
	 * The number of structural features of the '<em>Ratio Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE_FEATURE_COUNT = BINARY_MEASURE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get All Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE___GET_ALL_ARGUMENTS = BINARY_MEASURE___GET_ALL_ARGUMENTS;

	/**
	 * The operation id for the '<em>Get Arguments</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE___GET_ARGUMENTS = BINARY_MEASURE___GET_ARGUMENTS;

	/**
	 * The number of operations of the '<em>Ratio Measure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASURE_OPERATION_COUNT = BINARY_MEASURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.RatioMeasurementImpl <em>Ratio Measurement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.RatioMeasurementImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getRatioMeasurement()
	 * @generated
	 */
	int RATIO_MEASUREMENT = 61;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASUREMENT__DESCRIPTION = BINARY_MEASUREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASUREMENT__NAME = BINARY_MEASUREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASUREMENT__SHORT_DESCRIPTION = BINARY_MEASUREMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASUREMENT__IN_RELATIONSHIPS = BINARY_MEASUREMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASUREMENT__OUT_RELATIONSHIPS = BINARY_MEASUREMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASUREMENT__ATTRIBUTES = BINARY_MEASUREMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASUREMENT__ANNOTATIONS = BINARY_MEASUREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Break Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASUREMENT__BREAK_VALUE = BINARY_MEASUREMENT__BREAK_VALUE;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASUREMENT__ERROR = BINARY_MEASUREMENT__ERROR;

	/**
	 * The feature id for the '<em><b>Measurement Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASUREMENT__MEASUREMENT_RELATIONSHIPS = BINARY_MEASUREMENT__MEASUREMENT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Observed Measure</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASUREMENT__OBSERVED_MEASURE = BINARY_MEASUREMENT__OBSERVED_MEASURE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASUREMENT__VALUE = BINARY_MEASUREMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Is Base Supplied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASUREMENT__IS_BASE_SUPPLIED = BINARY_MEASUREMENT__IS_BASE_SUPPLIED;

	/**
	 * The feature id for the '<em><b>Base Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASUREMENT__BASE_QUERY = BINARY_MEASUREMENT__BASE_QUERY;

	/**
	 * The number of structural features of the '<em>Ratio Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASUREMENT_FEATURE_COUNT = BINARY_MEASUREMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Measure Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASUREMENT___GET_MEASURE_LABEL = BINARY_MEASUREMENT___GET_MEASURE_LABEL;

	/**
	 * The operation id for the '<em>Get Measurement Label</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASUREMENT___GET_MEASUREMENT_LABEL = BINARY_MEASUREMENT___GET_MEASUREMENT_LABEL;

	/**
	 * The number of operations of the '<em>Ratio Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RATIO_MEASUREMENT_OPERATION_COUNT = BINARY_MEASUREMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.impl.SmmModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.impl.SmmModelImpl
	 * @see org.omg.smm.impl.SmmPackageImpl#getSmmModel()
	 * @generated
	 */
	int SMM_MODEL = 62;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_MODEL__DESCRIPTION = SMM_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_MODEL__NAME = SMM_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_MODEL__SHORT_DESCRIPTION = SMM_ELEMENT__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>In Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_MODEL__IN_RELATIONSHIPS = SMM_ELEMENT__IN_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Out Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_MODEL__OUT_RELATIONSHIPS = SMM_ELEMENT__OUT_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_MODEL__ATTRIBUTES = SMM_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_MODEL__ANNOTATIONS = SMM_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Libraries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_MODEL__LIBRARIES = SMM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Observations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_MODEL__OBSERVATIONS = SMM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_MODEL_FEATURE_COUNT = SMM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMM_MODEL_OPERATION_COUNT = SMM_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.omg.smm.Accumulator <em>Accumulator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.Accumulator
	 * @see org.omg.smm.impl.SmmPackageImpl#getAccumulator()
	 * @generated
	 */
	int ACCUMULATOR = 63;

	/**
	 * The meta object id for the '{@link org.omg.smm.Influence <em>Influence</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.Influence
	 * @see org.omg.smm.impl.SmmPackageImpl#getInfluence()
	 * @generated
	 */
	int INFLUENCE = 64;

	/**
	 * The meta object id for the '{@link org.omg.smm.ScaleOfMeasurement <em>Scale Of Measurement</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.ScaleOfMeasurement
	 * @see org.omg.smm.impl.SmmPackageImpl#getScaleOfMeasurement()
	 * @generated
	 */
	int SCALE_OF_MEASUREMENT = 65;

	/**
	 * The meta object id for the '{@link org.omg.smm.BinaryFunctor <em>Binary Functor</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.BinaryFunctor
	 * @see org.omg.smm.impl.SmmPackageImpl#getBinaryFunctor()
	 * @generated
	 */
	int BINARY_FUNCTOR = 66;

	/**
	 * The meta object id for the '{@link org.omg.smm.MeasurementScale <em>Measurement Scale</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.omg.smm.MeasurementScale
	 * @see org.omg.smm.impl.SmmPackageImpl#getMeasurementScale()
	 * @generated
	 */
	int MEASUREMENT_SCALE = 67;

	/**
	 * The meta object id for the '<em>Time Stamp</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.sql.Timestamp
	 * @see org.omg.smm.impl.SmmPackageImpl#getTimeStamp()
	 * @generated
	 */
	int TIME_STAMP = 68;


	/**
	 * Returns the meta object for class '{@link org.omg.smm.AbstractMeasureElement <em>Abstract Measure Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Measure Element</em>'.
	 * @see org.omg.smm.AbstractMeasureElement
	 * @generated
	 */
	EClass getAbstractMeasureElement();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.SmmElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.omg.smm.SmmElement
	 * @generated
	 */
	EClass getSmmElement();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.SmmElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.omg.smm.SmmElement#getDescription()
	 * @see #getSmmElement()
	 * @generated
	 */
	EAttribute getSmmElement_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.SmmElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.omg.smm.SmmElement#getName()
	 * @see #getSmmElement()
	 * @generated
	 */
	EAttribute getSmmElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.SmmElement#getShortDescription <em>Short Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Short Description</em>'.
	 * @see org.omg.smm.SmmElement#getShortDescription()
	 * @see #getSmmElement()
	 * @generated
	 */
	EAttribute getSmmElement_ShortDescription();

	/**
	 * Returns the meta object for the reference list '{@link org.omg.smm.SmmElement#getInRelationships <em>In Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In Relationships</em>'.
	 * @see org.omg.smm.SmmElement#getInRelationships()
	 * @see #getSmmElement()
	 * @generated
	 */
	EReference getSmmElement_InRelationships();

	/**
	 * Returns the meta object for the reference list '{@link org.omg.smm.SmmElement#getOutRelationships <em>Out Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Out Relationships</em>'.
	 * @see org.omg.smm.SmmElement#getOutRelationships()
	 * @see #getSmmElement()
	 * @generated
	 */
	EReference getSmmElement_OutRelationships();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.smm.SmmElement#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.omg.smm.SmmElement#getAttributes()
	 * @see #getSmmElement()
	 * @generated
	 */
	EReference getSmmElement_Attributes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.smm.SmmElement#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see org.omg.smm.SmmElement#getAnnotations()
	 * @see #getSmmElement()
	 * @generated
	 */
	EReference getSmmElement_Annotations();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.SmmRelationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relationship</em>'.
	 * @see org.omg.smm.SmmRelationship
	 * @generated
	 */
	EClass getSmmRelationship();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.SmmRelationship#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see org.omg.smm.SmmRelationship#getFrom()
	 * @see #getSmmRelationship()
	 * @generated
	 */
	EReference getSmmRelationship_From();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.SmmRelationship#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see org.omg.smm.SmmRelationship#getTo()
	 * @see #getSmmRelationship()
	 * @generated
	 */
	EReference getSmmRelationship_To();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see org.omg.smm.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Attribute#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tag</em>'.
	 * @see org.omg.smm.Attribute#getTag()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Tag();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Attribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.omg.smm.Attribute#getValue()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Value();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see org.omg.smm.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Annotation#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.omg.smm.Annotation#getText()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_Text();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.Argument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Argument</em>'.
	 * @see org.omg.smm.Argument
	 * @generated
	 */
	EClass getArgument();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Argument#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.omg.smm.Argument#getType()
	 * @see #getArgument()
	 * @generated
	 */
	EAttribute getArgument_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Argument#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.omg.smm.Argument#getValue()
	 * @see #getArgument()
	 * @generated
	 */
	EAttribute getArgument_Value();

	/**
	 * Returns the meta object for the container reference '{@link org.omg.smm.Argument#getObservedMeasure <em>Observed Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Observed Measure</em>'.
	 * @see org.omg.smm.Argument#getObservedMeasure()
	 * @see #getArgument()
	 * @generated
	 */
	EReference getArgument_ObservedMeasure();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.ObservedMeasure <em>Observed Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Observed Measure</em>'.
	 * @see org.omg.smm.ObservedMeasure
	 * @generated
	 */
	EClass getObservedMeasure();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.smm.ObservedMeasure#getMeasurements <em>Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Measurements</em>'.
	 * @see org.omg.smm.ObservedMeasure#getMeasurements()
	 * @see #getObservedMeasure()
	 * @generated
	 */
	EReference getObservedMeasure_Measurements();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.ObservedMeasure#getMeasure <em>Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Measure</em>'.
	 * @see org.omg.smm.ObservedMeasure#getMeasure()
	 * @see #getObservedMeasure()
	 * @generated
	 */
	EReference getObservedMeasure_Measure();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.smm.ObservedMeasure#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.omg.smm.ObservedMeasure#getArguments()
	 * @see #getObservedMeasure()
	 * @generated
	 */
	EReference getObservedMeasure_Arguments();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.Measurement <em>Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measurement</em>'.
	 * @see org.omg.smm.Measurement
	 * @generated
	 */
	EClass getMeasurement();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Measurement#getBreakValue <em>Break Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Break Value</em>'.
	 * @see org.omg.smm.Measurement#getBreakValue()
	 * @see #getMeasurement()
	 * @generated
	 */
	EAttribute getMeasurement_BreakValue();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Measurement#getError <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error</em>'.
	 * @see org.omg.smm.Measurement#getError()
	 * @see #getMeasurement()
	 * @generated
	 */
	EAttribute getMeasurement_Error();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.smm.Measurement#getMeasurementRelationships <em>Measurement Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Measurement Relationships</em>'.
	 * @see org.omg.smm.Measurement#getMeasurementRelationships()
	 * @see #getMeasurement()
	 * @generated
	 */
	EReference getMeasurement_MeasurementRelationships();

	/**
	 * Returns the meta object for the container reference '{@link org.omg.smm.Measurement#getObservedMeasure <em>Observed Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Observed Measure</em>'.
	 * @see org.omg.smm.Measurement#getObservedMeasure()
	 * @see #getMeasurement()
	 * @generated
	 */
	EReference getMeasurement_ObservedMeasure();

	/**
	 * Returns the meta object for the '{@link org.omg.smm.Measurement#getMeasureLabel() <em>Get Measure Label</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Measure Label</em>' operation.
	 * @see org.omg.smm.Measurement#getMeasureLabel()
	 * @generated
	 */
	EOperation getMeasurement__GetMeasureLabel();

	/**
	 * Returns the meta object for the '{@link org.omg.smm.Measurement#getMeasurementLabel() <em>Get Measurement Label</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Measurement Label</em>' operation.
	 * @see org.omg.smm.Measurement#getMeasurementLabel()
	 * @generated
	 */
	EOperation getMeasurement__GetMeasurementLabel();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.EquivalentMeasurementRelationship <em>Equivalent Measurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equivalent Measurement Relationship</em>'.
	 * @see org.omg.smm.EquivalentMeasurementRelationship
	 * @generated
	 */
	EClass getEquivalentMeasurementRelationship();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.MeasurementRelationship <em>Measurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measurement Relationship</em>'.
	 * @see org.omg.smm.MeasurementRelationship
	 * @generated
	 */
	EClass getMeasurementRelationship();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.RefinementMeasurementRelationship <em>Refinement Measurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Refinement Measurement Relationship</em>'.
	 * @see org.omg.smm.RefinementMeasurementRelationship
	 * @generated
	 */
	EClass getRefinementMeasurementRelationship();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.Measure <em>Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measure</em>'.
	 * @see org.omg.smm.Measure
	 * @generated
	 */
	EClass getMeasure();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Measure#getMeasureLabelFormat <em>Measure Label Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Measure Label Format</em>'.
	 * @see org.omg.smm.Measure#getMeasureLabelFormat()
	 * @see #getMeasure()
	 * @generated
	 */
	EAttribute getMeasure_MeasureLabelFormat();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Measure#getMeasurementLabelFormat <em>Measurement Label Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Measurement Label Format</em>'.
	 * @see org.omg.smm.Measure#getMeasurementLabelFormat()
	 * @see #getMeasure()
	 * @generated
	 */
	EAttribute getMeasure_MeasurementLabelFormat();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Measure#isVisible <em>Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visible</em>'.
	 * @see org.omg.smm.Measure#isVisible()
	 * @see #getMeasure()
	 * @generated
	 */
	EAttribute getMeasure_Visible();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Measure#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.omg.smm.Measure#getSource()
	 * @see #getMeasure()
	 * @generated
	 */
	EAttribute getMeasure_Source();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.Measure#getDefaultQuery <em>Default Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Query</em>'.
	 * @see org.omg.smm.Measure#getDefaultQuery()
	 * @see #getMeasure()
	 * @generated
	 */
	EReference getMeasure_DefaultQuery();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.smm.Measure#getMeasureRelationships <em>Measure Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Measure Relationships</em>'.
	 * @see org.omg.smm.Measure#getMeasureRelationships()
	 * @see #getMeasure()
	 * @generated
	 */
	EReference getMeasure_MeasureRelationships();

	/**
	 * Returns the meta object for the reference list '{@link org.omg.smm.Measure#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Category</em>'.
	 * @see org.omg.smm.Measure#getCategory()
	 * @see #getMeasure()
	 * @generated
	 */
	EReference getMeasure_Category();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.Measure#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scope</em>'.
	 * @see org.omg.smm.Measure#getScope()
	 * @see #getMeasure()
	 * @generated
	 */
	EReference getMeasure_Scope();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.Measure#getTrait <em>Trait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Trait</em>'.
	 * @see org.omg.smm.Measure#getTrait()
	 * @see #getMeasure()
	 * @generated
	 */
	EReference getMeasure_Trait();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Measure#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see org.omg.smm.Measure#getScale()
	 * @see #getMeasure()
	 * @generated
	 */
	EAttribute getMeasure_Scale();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Measure#getCustomScale <em>Custom Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Scale</em>'.
	 * @see org.omg.smm.Measure#getCustomScale()
	 * @see #getMeasure()
	 * @generated
	 */
	EAttribute getMeasure_CustomScale();

	/**
	 * Returns the meta object for the '{@link org.omg.smm.Measure#getAllArguments() <em>Get All Arguments</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get All Arguments</em>' operation.
	 * @see org.omg.smm.Measure#getAllArguments()
	 * @generated
	 */
	EOperation getMeasure__GetAllArguments();

	/**
	 * Returns the meta object for the '{@link org.omg.smm.Measure#getArguments() <em>Get Arguments</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Arguments</em>' operation.
	 * @see org.omg.smm.Measure#getArguments()
	 * @generated
	 */
	EOperation getMeasure__GetArguments();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.RefinementMeasureRelationship <em>Refinement Measure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Refinement Measure Relationship</em>'.
	 * @see org.omg.smm.RefinementMeasureRelationship
	 * @generated
	 */
	EClass getRefinementMeasureRelationship();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.MeasureRelationship <em>Measure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measure Relationship</em>'.
	 * @see org.omg.smm.MeasureRelationship
	 * @generated
	 */
	EClass getMeasureRelationship();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.MeasureRelationship#getInfluence <em>Influence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Influence</em>'.
	 * @see org.omg.smm.MeasureRelationship#getInfluence()
	 * @see #getMeasureRelationship()
	 * @generated
	 */
	EAttribute getMeasureRelationship_Influence();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.MeasureRelationship#getMeasurandQuery <em>Measurand Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Measurand Query</em>'.
	 * @see org.omg.smm.MeasureRelationship#getMeasurandQuery()
	 * @see #getMeasureRelationship()
	 * @generated
	 */
	EReference getMeasureRelationship_MeasurandQuery();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see org.omg.smm.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Operation#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see org.omg.smm.Operation#getBody()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Body();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Operation#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see org.omg.smm.Operation#getLanguage()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Language();

	/**
	 * Returns the meta object for the '{@link org.omg.smm.Operation#getParamStrings() <em>Get Param Strings</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Param Strings</em>' operation.
	 * @see org.omg.smm.Operation#getParamStrings()
	 * @generated
	 */
	EOperation getOperation__GetParamStrings();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.EquivalentMeasureRelationship <em>Equivalent Measure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equivalent Measure Relationship</em>'.
	 * @see org.omg.smm.EquivalentMeasureRelationship
	 * @generated
	 */
	EClass getEquivalentMeasureRelationship();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.EquivalentMeasureRelationship#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mapping</em>'.
	 * @see org.omg.smm.EquivalentMeasureRelationship#getMapping()
	 * @see #getEquivalentMeasureRelationship()
	 * @generated
	 */
	EReference getEquivalentMeasureRelationship_Mapping();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.MeasureCategory <em>Measure Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measure Category</em>'.
	 * @see org.omg.smm.MeasureCategory
	 * @generated
	 */
	EClass getMeasureCategory();

	/**
	 * Returns the meta object for the reference list '{@link org.omg.smm.MeasureCategory#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Category</em>'.
	 * @see org.omg.smm.MeasureCategory#getCategory()
	 * @see #getMeasureCategory()
	 * @generated
	 */
	EReference getMeasureCategory_Category();

	/**
	 * Returns the meta object for the reference list '{@link org.omg.smm.MeasureCategory#getCategoryElement <em>Category Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Category Element</em>'.
	 * @see org.omg.smm.MeasureCategory#getCategoryElement()
	 * @see #getMeasureCategory()
	 * @generated
	 */
	EReference getMeasureCategory_CategoryElement();

	/**
	 * Returns the meta object for the reference list '{@link org.omg.smm.MeasureCategory#getCategoryMeasure <em>Category Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Category Measure</em>'.
	 * @see org.omg.smm.MeasureCategory#getCategoryMeasure()
	 * @see #getMeasureCategory()
	 * @generated
	 */
	EReference getMeasureCategory_CategoryMeasure();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.Scope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scope</em>'.
	 * @see org.omg.smm.Scope
	 * @generated
	 */
	EClass getScope();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.Scope#getBreakCondition <em>Break Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Break Condition</em>'.
	 * @see org.omg.smm.Scope#getBreakCondition()
	 * @see #getScope()
	 * @generated
	 */
	EReference getScope_BreakCondition();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.Scope#getRecognizer <em>Recognizer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Recognizer</em>'.
	 * @see org.omg.smm.Scope#getRecognizer()
	 * @see #getScope()
	 * @generated
	 */
	EReference getScope_Recognizer();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.Scope#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class</em>'.
	 * @see org.omg.smm.Scope#getClass_()
	 * @see #getScope()
	 * @generated
	 */
	EReference getScope_Class();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.Scope#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Stereotype</em>'.
	 * @see org.omg.smm.Scope#getStereotype()
	 * @see #getScope()
	 * @generated
	 */
	EReference getScope_Stereotype();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.Characteristic <em>Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Characteristic</em>'.
	 * @see org.omg.smm.Characteristic
	 * @generated
	 */
	EClass getCharacteristic();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.Characteristic#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.omg.smm.Characteristic#getParent()
	 * @see #getCharacteristic()
	 * @generated
	 */
	EReference getCharacteristic_Parent();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.Base1MeasureRelationship <em>Base1 Measure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base1 Measure Relationship</em>'.
	 * @see org.omg.smm.Base1MeasureRelationship
	 * @generated
	 */
	EClass getBase1MeasureRelationship();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.BaseMeasureRelationship <em>Base Measure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Measure Relationship</em>'.
	 * @see org.omg.smm.BaseMeasureRelationship
	 * @generated
	 */
	EClass getBaseMeasureRelationship();

	/**
	 * Returns the meta object for the containment reference '{@link org.omg.smm.BaseMeasureRelationship#getRescaledMeasure <em>Rescaled Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rescaled Measure</em>'.
	 * @see org.omg.smm.BaseMeasureRelationship#getRescaledMeasure()
	 * @see #getBaseMeasureRelationship()
	 * @generated
	 */
	EReference getBaseMeasureRelationship_RescaledMeasure();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.RescaledMeasure <em>Rescaled Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rescaled Measure</em>'.
	 * @see org.omg.smm.RescaledMeasure
	 * @generated
	 */
	EClass getRescaledMeasure();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.RescaledMeasure#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see org.omg.smm.RescaledMeasure#getOperation()
	 * @see #getRescaledMeasure()
	 * @generated
	 */
	EReference getRescaledMeasure_Operation();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.RescaledMeasure#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.omg.smm.RescaledMeasure#getOffset()
	 * @see #getRescaledMeasure()
	 * @generated
	 */
	EAttribute getRescaledMeasure_Offset();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.RescaledMeasure#getMultiplier <em>Multiplier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplier</em>'.
	 * @see org.omg.smm.RescaledMeasure#getMultiplier()
	 * @see #getRescaledMeasure()
	 * @generated
	 */
	EAttribute getRescaledMeasure_Multiplier();

	/**
	 * Returns the meta object for the container reference '{@link org.omg.smm.RescaledMeasure#getRescales <em>Rescales</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Rescales</em>'.
	 * @see org.omg.smm.RescaledMeasure#getRescales()
	 * @see #getRescaledMeasure()
	 * @generated
	 */
	EReference getRescaledMeasure_Rescales();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.DimensionalMeasure <em>Dimensional Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimensional Measure</em>'.
	 * @see org.omg.smm.DimensionalMeasure
	 * @generated
	 */
	EClass getDimensionalMeasure();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.DimensionalMeasure#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unit</em>'.
	 * @see org.omg.smm.DimensionalMeasure#getUnit()
	 * @see #getDimensionalMeasure()
	 * @generated
	 */
	EReference getDimensionalMeasure_Unit();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.DimensionalMeasure#getFormula <em>Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Formula</em>'.
	 * @see org.omg.smm.DimensionalMeasure#getFormula()
	 * @see #getDimensionalMeasure()
	 * @generated
	 */
	EAttribute getDimensionalMeasure_Formula();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.BaseNMeasureRelationship <em>Base NMeasure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base NMeasure Relationship</em>'.
	 * @see org.omg.smm.BaseNMeasureRelationship
	 * @generated
	 */
	EClass getBaseNMeasureRelationship();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.CollectiveMeasure <em>Collective Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collective Measure</em>'.
	 * @see org.omg.smm.CollectiveMeasure
	 * @generated
	 */
	EClass getCollectiveMeasure();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.CollectiveMeasure#getAccumulator <em>Accumulator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Accumulator</em>'.
	 * @see org.omg.smm.CollectiveMeasure#getAccumulator()
	 * @see #getCollectiveMeasure()
	 * @generated
	 */
	EAttribute getCollectiveMeasure_Accumulator();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.CollectiveMeasure#getCustomAccumulator <em>Custom Accumulator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Custom Accumulator</em>'.
	 * @see org.omg.smm.CollectiveMeasure#getCustomAccumulator()
	 * @see #getCollectiveMeasure()
	 * @generated
	 */
	EReference getCollectiveMeasure_CustomAccumulator();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.Base2MeasureRelationship <em>Base2 Measure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base2 Measure Relationship</em>'.
	 * @see org.omg.smm.Base2MeasureRelationship
	 * @generated
	 */
	EClass getBase2MeasureRelationship();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.BinaryMeasure <em>Binary Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Measure</em>'.
	 * @see org.omg.smm.BinaryMeasure
	 * @generated
	 */
	EClass getBinaryMeasure();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.BinaryMeasure#getFunctor <em>Functor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Functor</em>'.
	 * @see org.omg.smm.BinaryMeasure#getFunctor()
	 * @see #getBinaryMeasure()
	 * @generated
	 */
	EAttribute getBinaryMeasure_Functor();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.BinaryMeasure#getCustomFunctor <em>Custom Functor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Custom Functor</em>'.
	 * @see org.omg.smm.BinaryMeasure#getCustomFunctor()
	 * @see #getBinaryMeasure()
	 * @generated
	 */
	EReference getBinaryMeasure_CustomFunctor();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.RankingMeasureRelationship <em>Ranking Measure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ranking Measure Relationship</em>'.
	 * @see org.omg.smm.RankingMeasureRelationship
	 * @generated
	 */
	EClass getRankingMeasureRelationship();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.RankingMeasure <em>Ranking Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ranking Measure</em>'.
	 * @see org.omg.smm.RankingMeasure
	 * @generated
	 */
	EClass getRankingMeasure();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.smm.RankingMeasure#getInterval <em>Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Interval</em>'.
	 * @see org.omg.smm.RankingMeasure#getInterval()
	 * @see #getRankingMeasure()
	 * @generated
	 */
	EReference getRankingMeasure_Interval();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.RankingInterval <em>Ranking Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ranking Interval</em>'.
	 * @see org.omg.smm.RankingInterval
	 * @generated
	 */
	EClass getRankingInterval();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.RankingInterval#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.omg.smm.RankingInterval#getValue()
	 * @see #getRankingInterval()
	 * @generated
	 */
	EAttribute getRankingInterval_Value();

	/**
	 * Returns the meta object for the container reference '{@link org.omg.smm.RankingInterval#getRanking <em>Ranking</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Ranking</em>'.
	 * @see org.omg.smm.RankingInterval#getRanking()
	 * @see #getRankingInterval()
	 * @generated
	 */
	EReference getRankingInterval_Ranking();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.Interval <em>Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interval</em>'.
	 * @see org.omg.smm.Interval
	 * @generated
	 */
	EClass getInterval();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Interval#getMaximumEndpoint <em>Maximum Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Endpoint</em>'.
	 * @see org.omg.smm.Interval#getMaximumEndpoint()
	 * @see #getInterval()
	 * @generated
	 */
	EAttribute getInterval_MaximumEndpoint();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Interval#isMaximumOpen <em>Maximum Open</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Open</em>'.
	 * @see org.omg.smm.Interval#isMaximumOpen()
	 * @see #getInterval()
	 * @generated
	 */
	EAttribute getInterval_MaximumOpen();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Interval#getMinimumEndpoint <em>Minimum Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Endpoint</em>'.
	 * @see org.omg.smm.Interval#getMinimumEndpoint()
	 * @see #getInterval()
	 * @generated
	 */
	EAttribute getInterval_MinimumEndpoint();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Interval#isMinimumOpen <em>Minimum Open</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Open</em>'.
	 * @see org.omg.smm.Interval#isMinimumOpen()
	 * @see #getInterval()
	 * @generated
	 */
	EAttribute getInterval_MinimumOpen();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.RescaledMeasureRelationship <em>Rescaled Measure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rescaled Measure Relationship</em>'.
	 * @see org.omg.smm.RescaledMeasureRelationship
	 * @generated
	 */
	EClass getRescaledMeasureRelationship();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.GradeMeasureRelationship <em>Grade Measure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grade Measure Relationship</em>'.
	 * @see org.omg.smm.GradeMeasureRelationship
	 * @generated
	 */
	EClass getGradeMeasureRelationship();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.GradeMeasure <em>Grade Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grade Measure</em>'.
	 * @see org.omg.smm.GradeMeasure
	 * @generated
	 */
	EClass getGradeMeasure();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.smm.GradeMeasure#getInterval <em>Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Interval</em>'.
	 * @see org.omg.smm.GradeMeasure#getInterval()
	 * @see #getGradeMeasure()
	 * @generated
	 */
	EReference getGradeMeasure_Interval();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.GradeInterval <em>Grade Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grade Interval</em>'.
	 * @see org.omg.smm.GradeInterval
	 * @generated
	 */
	EClass getGradeInterval();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.GradeInterval#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see org.omg.smm.GradeInterval#getSymbol()
	 * @see #getGradeInterval()
	 * @generated
	 */
	EAttribute getGradeInterval_Symbol();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.UnitOfMeasure <em>Unit Of Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Of Measure</em>'.
	 * @see org.omg.smm.UnitOfMeasure
	 * @generated
	 */
	EClass getUnitOfMeasure();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.Base1MeasurementRelationship <em>Base1 Measurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base1 Measurement Relationship</em>'.
	 * @see org.omg.smm.Base1MeasurementRelationship
	 * @generated
	 */
	EClass getBase1MeasurementRelationship();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.BaseMeasurementRelationship <em>Base Measurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Measurement Relationship</em>'.
	 * @see org.omg.smm.BaseMeasurementRelationship
	 * @generated
	 */
	EClass getBaseMeasurementRelationship();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.DimensionalMeasurement <em>Dimensional Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimensional Measurement</em>'.
	 * @see org.omg.smm.DimensionalMeasurement
	 * @generated
	 */
	EClass getDimensionalMeasurement();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.DimensionalMeasurement#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.omg.smm.DimensionalMeasurement#getValue()
	 * @see #getDimensionalMeasurement()
	 * @generated
	 */
	EAttribute getDimensionalMeasurement_Value();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.BaseNMeasurementRelationship <em>Base NMeasurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base NMeasurement Relationship</em>'.
	 * @see org.omg.smm.BaseNMeasurementRelationship
	 * @generated
	 */
	EClass getBaseNMeasurementRelationship();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.CollectiveMeasurement <em>Collective Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collective Measurement</em>'.
	 * @see org.omg.smm.CollectiveMeasurement
	 * @generated
	 */
	EClass getCollectiveMeasurement();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.CollectiveMeasurement#isIsBaseSupplied <em>Is Base Supplied</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Base Supplied</em>'.
	 * @see org.omg.smm.CollectiveMeasurement#isIsBaseSupplied()
	 * @see #getCollectiveMeasurement()
	 * @generated
	 */
	EAttribute getCollectiveMeasurement_IsBaseSupplied();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.CollectiveMeasurement#getBaseQuery <em>Base Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Query</em>'.
	 * @see org.omg.smm.CollectiveMeasurement#getBaseQuery()
	 * @see #getCollectiveMeasurement()
	 * @generated
	 */
	EReference getCollectiveMeasurement_BaseQuery();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.Base2MeasurementRelationship <em>Base2 Measurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base2 Measurement Relationship</em>'.
	 * @see org.omg.smm.Base2MeasurementRelationship
	 * @generated
	 */
	EClass getBase2MeasurementRelationship();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.BinaryMeasurement <em>Binary Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Measurement</em>'.
	 * @see org.omg.smm.BinaryMeasurement
	 * @generated
	 */
	EClass getBinaryMeasurement();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.BinaryMeasurement#isIsBaseSupplied <em>Is Base Supplied</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Base Supplied</em>'.
	 * @see org.omg.smm.BinaryMeasurement#isIsBaseSupplied()
	 * @see #getBinaryMeasurement()
	 * @generated
	 */
	EAttribute getBinaryMeasurement_IsBaseSupplied();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.BinaryMeasurement#getBaseQuery <em>Base Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Query</em>'.
	 * @see org.omg.smm.BinaryMeasurement#getBaseQuery()
	 * @see #getBinaryMeasurement()
	 * @generated
	 */
	EReference getBinaryMeasurement_BaseQuery();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.GradeMeasurementRelationship <em>Grade Measurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grade Measurement Relationship</em>'.
	 * @see org.omg.smm.GradeMeasurementRelationship
	 * @generated
	 */
	EClass getGradeMeasurementRelationship();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.GradeMeasurement <em>Grade Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grade Measurement</em>'.
	 * @see org.omg.smm.GradeMeasurement
	 * @generated
	 */
	EClass getGradeMeasurement();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.GradeMeasurement#isIsBaseSupplied <em>Is Base Supplied</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Base Supplied</em>'.
	 * @see org.omg.smm.GradeMeasurement#isIsBaseSupplied()
	 * @see #getGradeMeasurement()
	 * @generated
	 */
	EAttribute getGradeMeasurement_IsBaseSupplied();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.GradeMeasurement#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.omg.smm.GradeMeasurement#getValue()
	 * @see #getGradeMeasurement()
	 * @generated
	 */
	EAttribute getGradeMeasurement_Value();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.GradeMeasurement#getBaseQuery <em>Base Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Query</em>'.
	 * @see org.omg.smm.GradeMeasurement#getBaseQuery()
	 * @see #getGradeMeasurement()
	 * @generated
	 */
	EReference getGradeMeasurement_BaseQuery();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.RescaledMeasurementRelationship <em>Rescaled Measurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rescaled Measurement Relationship</em>'.
	 * @see org.omg.smm.RescaledMeasurementRelationship
	 * @generated
	 */
	EClass getRescaledMeasurementRelationship();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.RescaledMeasurement <em>Rescaled Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rescaled Measurement</em>'.
	 * @see org.omg.smm.RescaledMeasurement
	 * @generated
	 */
	EClass getRescaledMeasurement();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.RescaledMeasurement#isIsBaseSupplied <em>Is Base Supplied</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Base Supplied</em>'.
	 * @see org.omg.smm.RescaledMeasurement#isIsBaseSupplied()
	 * @see #getRescaledMeasurement()
	 * @generated
	 */
	EAttribute getRescaledMeasurement_IsBaseSupplied();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.RescaledMeasurement#getBaseQuery <em>Base Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Query</em>'.
	 * @see org.omg.smm.RescaledMeasurement#getBaseQuery()
	 * @see #getRescaledMeasurement()
	 * @generated
	 */
	EReference getRescaledMeasurement_BaseQuery();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.RankingMeasurementRelationship <em>Ranking Measurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ranking Measurement Relationship</em>'.
	 * @see org.omg.smm.RankingMeasurementRelationship
	 * @generated
	 */
	EClass getRankingMeasurementRelationship();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.RankingMeasurement <em>Ranking Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ranking Measurement</em>'.
	 * @see org.omg.smm.RankingMeasurement
	 * @generated
	 */
	EClass getRankingMeasurement();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.RankingMeasurement#getBaseQuery <em>Base Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Query</em>'.
	 * @see org.omg.smm.RankingMeasurement#getBaseQuery()
	 * @see #getRankingMeasurement()
	 * @generated
	 */
	EReference getRankingMeasurement_BaseQuery();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.RankingMeasurement#isIsBaseSupplied <em>Is Base Supplied</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Base Supplied</em>'.
	 * @see org.omg.smm.RankingMeasurement#isIsBaseSupplied()
	 * @see #getRankingMeasurement()
	 * @generated
	 */
	EAttribute getRankingMeasurement_IsBaseSupplied();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.CategoryRelationship <em>Category Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category Relationship</em>'.
	 * @see org.omg.smm.CategoryRelationship
	 * @generated
	 */
	EClass getCategoryRelationship();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.CountingMeasurement <em>Counting Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Counting Measurement</em>'.
	 * @see org.omg.smm.CountingMeasurement
	 * @generated
	 */
	EClass getCountingMeasurement();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.DirectMeasurement <em>Direct Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Direct Measurement</em>'.
	 * @see org.omg.smm.DirectMeasurement
	 * @generated
	 */
	EClass getDirectMeasurement();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.CountingMeasure <em>Counting Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Counting Measure</em>'.
	 * @see org.omg.smm.CountingMeasure
	 * @generated
	 */
	EClass getCountingMeasure();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.DirectMeasure <em>Direct Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Direct Measure</em>'.
	 * @see org.omg.smm.DirectMeasure
	 * @generated
	 */
	EClass getDirectMeasure();

	/**
	 * Returns the meta object for the reference '{@link org.omg.smm.DirectMeasure#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see org.omg.smm.DirectMeasure#getOperation()
	 * @see #getDirectMeasure()
	 * @generated
	 */
	EReference getDirectMeasure_Operation();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.MeasureLibrary <em>Measure Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measure Library</em>'.
	 * @see org.omg.smm.MeasureLibrary
	 * @generated
	 */
	EClass getMeasureLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.smm.MeasureLibrary#getMeasureElements <em>Measure Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Measure Elements</em>'.
	 * @see org.omg.smm.MeasureLibrary#getMeasureElements()
	 * @see #getMeasureLibrary()
	 * @generated
	 */
	EReference getMeasureLibrary_MeasureElements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.smm.MeasureLibrary#getCategoryRelationships <em>Category Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Category Relationships</em>'.
	 * @see org.omg.smm.MeasureLibrary#getCategoryRelationships()
	 * @see #getMeasureLibrary()
	 * @generated
	 */
	EReference getMeasureLibrary_CategoryRelationships();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.NamedMeasure <em>Named Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Measure</em>'.
	 * @see org.omg.smm.NamedMeasure
	 * @generated
	 */
	EClass getNamedMeasure();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.NamedMeasurement <em>Named Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Measurement</em>'.
	 * @see org.omg.smm.NamedMeasurement
	 * @generated
	 */
	EClass getNamedMeasurement();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.OCLOperation <em>OCL Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OCL Operation</em>'.
	 * @see org.omg.smm.OCLOperation
	 * @generated
	 */
	EClass getOCLOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.OCLOperation#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see org.omg.smm.OCLOperation#getBody()
	 * @see #getOCLOperation()
	 * @generated
	 */
	EAttribute getOCLOperation_Body();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.OCLOperation#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Context</em>'.
	 * @see org.omg.smm.OCLOperation#getContext()
	 * @see #getOCLOperation()
	 * @generated
	 */
	EAttribute getOCLOperation_Context();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.Observation <em>Observation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Observation</em>'.
	 * @see org.omg.smm.Observation
	 * @generated
	 */
	EClass getObservation();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Observation#getObserver <em>Observer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Observer</em>'.
	 * @see org.omg.smm.Observation#getObserver()
	 * @see #getObservation()
	 * @generated
	 */
	EAttribute getObservation_Observer();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Observation#getTool <em>Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tool</em>'.
	 * @see org.omg.smm.Observation#getTool()
	 * @see #getObservation()
	 * @generated
	 */
	EAttribute getObservation_Tool();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.Observation#getWhenObserved <em>When Observed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>When Observed</em>'.
	 * @see org.omg.smm.Observation#getWhenObserved()
	 * @see #getObservation()
	 * @generated
	 */
	EAttribute getObservation_WhenObserved();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.smm.Observation#getScopes <em>Scopes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scopes</em>'.
	 * @see org.omg.smm.Observation#getScopes()
	 * @see #getObservation()
	 * @generated
	 */
	EReference getObservation_Scopes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.smm.Observation#getObservedMeasures <em>Observed Measures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Observed Measures</em>'.
	 * @see org.omg.smm.Observation#getObservedMeasures()
	 * @see #getObservation()
	 * @generated
	 */
	EReference getObservation_ObservedMeasures();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.smm.Observation#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.omg.smm.Observation#getArguments()
	 * @see #getObservation()
	 * @generated
	 */
	EReference getObservation_Arguments();

	/**
	 * Returns the meta object for the reference list '{@link org.omg.smm.Observation#getRequestedMeasures <em>Requested Measures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requested Measures</em>'.
	 * @see org.omg.smm.Observation#getRequestedMeasures()
	 * @see #getObservation()
	 * @generated
	 */
	EReference getObservation_RequestedMeasures();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.ObservationScope <em>Observation Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Observation Scope</em>'.
	 * @see org.omg.smm.ObservationScope
	 * @generated
	 */
	EClass getObservationScope();

	/**
	 * Returns the meta object for the attribute '{@link org.omg.smm.ObservationScope#getScopeUri <em>Scope Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scope Uri</em>'.
	 * @see org.omg.smm.ObservationScope#getScopeUri()
	 * @see #getObservationScope()
	 * @generated
	 */
	EAttribute getObservationScope_ScopeUri();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.RatioMeasure <em>Ratio Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ratio Measure</em>'.
	 * @see org.omg.smm.RatioMeasure
	 * @generated
	 */
	EClass getRatioMeasure();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.RatioMeasurement <em>Ratio Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ratio Measurement</em>'.
	 * @see org.omg.smm.RatioMeasurement
	 * @generated
	 */
	EClass getRatioMeasurement();

	/**
	 * Returns the meta object for class '{@link org.omg.smm.SmmModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.omg.smm.SmmModel
	 * @generated
	 */
	EClass getSmmModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.smm.SmmModel#getLibraries <em>Libraries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Libraries</em>'.
	 * @see org.omg.smm.SmmModel#getLibraries()
	 * @see #getSmmModel()
	 * @generated
	 */
	EReference getSmmModel_Libraries();

	/**
	 * Returns the meta object for the containment reference list '{@link org.omg.smm.SmmModel#getObservations <em>Observations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Observations</em>'.
	 * @see org.omg.smm.SmmModel#getObservations()
	 * @see #getSmmModel()
	 * @generated
	 */
	EReference getSmmModel_Observations();

	/**
	 * Returns the meta object for enum '{@link org.omg.smm.Accumulator <em>Accumulator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Accumulator</em>'.
	 * @see org.omg.smm.Accumulator
	 * @generated
	 */
	EEnum getAccumulator();

	/**
	 * Returns the meta object for enum '{@link org.omg.smm.Influence <em>Influence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Influence</em>'.
	 * @see org.omg.smm.Influence
	 * @generated
	 */
	EEnum getInfluence();

	/**
	 * Returns the meta object for enum '{@link org.omg.smm.ScaleOfMeasurement <em>Scale Of Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Scale Of Measurement</em>'.
	 * @see org.omg.smm.ScaleOfMeasurement
	 * @generated
	 */
	EEnum getScaleOfMeasurement();

	/**
	 * Returns the meta object for enum '{@link org.omg.smm.BinaryFunctor <em>Binary Functor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Binary Functor</em>'.
	 * @see org.omg.smm.BinaryFunctor
	 * @generated
	 */
	EEnum getBinaryFunctor();

	/**
	 * Returns the meta object for enum '{@link org.omg.smm.MeasurementScale <em>Measurement Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Measurement Scale</em>'.
	 * @see org.omg.smm.MeasurementScale
	 * @generated
	 */
	EEnum getMeasurementScale();

	/**
	 * Returns the meta object for data type '{@link java.sql.Timestamp <em>Time Stamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Time Stamp</em>'.
	 * @see java.sql.Timestamp
	 * @model instanceClass="java.sql.Timestamp"
	 * @generated
	 */
	EDataType getTimeStamp();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SmmFactory getSmmFactory();

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
		 * The meta object literal for the '{@link org.omg.smm.impl.AbstractMeasureElementImpl <em>Abstract Measure Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.AbstractMeasureElementImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getAbstractMeasureElement()
		 * @generated
		 */
		EClass ABSTRACT_MEASURE_ELEMENT = eINSTANCE.getAbstractMeasureElement();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.SmmElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.SmmElementImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getSmmElement()
		 * @generated
		 */
		EClass SMM_ELEMENT = eINSTANCE.getSmmElement();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMM_ELEMENT__DESCRIPTION = eINSTANCE.getSmmElement_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMM_ELEMENT__NAME = eINSTANCE.getSmmElement_Name();

		/**
		 * The meta object literal for the '<em><b>Short Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMM_ELEMENT__SHORT_DESCRIPTION = eINSTANCE.getSmmElement_ShortDescription();

		/**
		 * The meta object literal for the '<em><b>In Relationships</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMM_ELEMENT__IN_RELATIONSHIPS = eINSTANCE.getSmmElement_InRelationships();

		/**
		 * The meta object literal for the '<em><b>Out Relationships</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMM_ELEMENT__OUT_RELATIONSHIPS = eINSTANCE.getSmmElement_OutRelationships();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMM_ELEMENT__ATTRIBUTES = eINSTANCE.getSmmElement_Attributes();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMM_ELEMENT__ANNOTATIONS = eINSTANCE.getSmmElement_Annotations();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.SmmRelationshipImpl <em>Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.SmmRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getSmmRelationship()
		 * @generated
		 */
		EClass SMM_RELATIONSHIP = eINSTANCE.getSmmRelationship();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMM_RELATIONSHIP__FROM = eINSTANCE.getSmmRelationship_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMM_RELATIONSHIP__TO = eINSTANCE.getSmmRelationship_To();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.AttributeImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__TAG = eINSTANCE.getAttribute_Tag();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.AnnotationImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION__TEXT = eINSTANCE.getAnnotation_Text();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.ArgumentImpl <em>Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.ArgumentImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getArgument()
		 * @generated
		 */
		EClass ARGUMENT = eINSTANCE.getArgument();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARGUMENT__TYPE = eINSTANCE.getArgument_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARGUMENT__VALUE = eINSTANCE.getArgument_Value();

		/**
		 * The meta object literal for the '<em><b>Observed Measure</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARGUMENT__OBSERVED_MEASURE = eINSTANCE.getArgument_ObservedMeasure();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.ObservedMeasureImpl <em>Observed Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.ObservedMeasureImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getObservedMeasure()
		 * @generated
		 */
		EClass OBSERVED_MEASURE = eINSTANCE.getObservedMeasure();

		/**
		 * The meta object literal for the '<em><b>Measurements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBSERVED_MEASURE__MEASUREMENTS = eINSTANCE.getObservedMeasure_Measurements();

		/**
		 * The meta object literal for the '<em><b>Measure</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBSERVED_MEASURE__MEASURE = eINSTANCE.getObservedMeasure_Measure();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBSERVED_MEASURE__ARGUMENTS = eINSTANCE.getObservedMeasure_Arguments();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.MeasurementImpl <em>Measurement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.MeasurementImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getMeasurement()
		 * @generated
		 */
		EClass MEASUREMENT = eINSTANCE.getMeasurement();

		/**
		 * The meta object literal for the '<em><b>Break Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASUREMENT__BREAK_VALUE = eINSTANCE.getMeasurement_BreakValue();

		/**
		 * The meta object literal for the '<em><b>Error</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASUREMENT__ERROR = eINSTANCE.getMeasurement_Error();

		/**
		 * The meta object literal for the '<em><b>Measurement Relationships</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASUREMENT__MEASUREMENT_RELATIONSHIPS = eINSTANCE.getMeasurement_MeasurementRelationships();

		/**
		 * The meta object literal for the '<em><b>Observed Measure</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASUREMENT__OBSERVED_MEASURE = eINSTANCE.getMeasurement_ObservedMeasure();

		/**
		 * The meta object literal for the '<em><b>Get Measure Label</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MEASUREMENT___GET_MEASURE_LABEL = eINSTANCE.getMeasurement__GetMeasureLabel();

		/**
		 * The meta object literal for the '<em><b>Get Measurement Label</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MEASUREMENT___GET_MEASUREMENT_LABEL = eINSTANCE.getMeasurement__GetMeasurementLabel();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.EquivalentMeasurementRelationshipImpl <em>Equivalent Measurement Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.EquivalentMeasurementRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getEquivalentMeasurementRelationship()
		 * @generated
		 */
		EClass EQUIVALENT_MEASUREMENT_RELATIONSHIP = eINSTANCE.getEquivalentMeasurementRelationship();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.MeasurementRelationshipImpl <em>Measurement Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.MeasurementRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getMeasurementRelationship()
		 * @generated
		 */
		EClass MEASUREMENT_RELATIONSHIP = eINSTANCE.getMeasurementRelationship();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.RefinementMeasurementRelationshipImpl <em>Refinement Measurement Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.RefinementMeasurementRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getRefinementMeasurementRelationship()
		 * @generated
		 */
		EClass REFINEMENT_MEASUREMENT_RELATIONSHIP = eINSTANCE.getRefinementMeasurementRelationship();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.MeasureImpl <em>Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.MeasureImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getMeasure()
		 * @generated
		 */
		EClass MEASURE = eINSTANCE.getMeasure();

		/**
		 * The meta object literal for the '<em><b>Measure Label Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE__MEASURE_LABEL_FORMAT = eINSTANCE.getMeasure_MeasureLabelFormat();

		/**
		 * The meta object literal for the '<em><b>Measurement Label Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE__MEASUREMENT_LABEL_FORMAT = eINSTANCE.getMeasure_MeasurementLabelFormat();

		/**
		 * The meta object literal for the '<em><b>Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE__VISIBLE = eINSTANCE.getMeasure_Visible();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE__SOURCE = eINSTANCE.getMeasure_Source();

		/**
		 * The meta object literal for the '<em><b>Default Query</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURE__DEFAULT_QUERY = eINSTANCE.getMeasure_DefaultQuery();

		/**
		 * The meta object literal for the '<em><b>Measure Relationships</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURE__MEASURE_RELATIONSHIPS = eINSTANCE.getMeasure_MeasureRelationships();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURE__CATEGORY = eINSTANCE.getMeasure_Category();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURE__SCOPE = eINSTANCE.getMeasure_Scope();

		/**
		 * The meta object literal for the '<em><b>Trait</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURE__TRAIT = eINSTANCE.getMeasure_Trait();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE__SCALE = eINSTANCE.getMeasure_Scale();

		/**
		 * The meta object literal for the '<em><b>Custom Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE__CUSTOM_SCALE = eINSTANCE.getMeasure_CustomScale();

		/**
		 * The meta object literal for the '<em><b>Get All Arguments</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MEASURE___GET_ALL_ARGUMENTS = eINSTANCE.getMeasure__GetAllArguments();

		/**
		 * The meta object literal for the '<em><b>Get Arguments</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MEASURE___GET_ARGUMENTS = eINSTANCE.getMeasure__GetArguments();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.RefinementMeasureRelationshipImpl <em>Refinement Measure Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.RefinementMeasureRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getRefinementMeasureRelationship()
		 * @generated
		 */
		EClass REFINEMENT_MEASURE_RELATIONSHIP = eINSTANCE.getRefinementMeasureRelationship();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.MeasureRelationshipImpl <em>Measure Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.MeasureRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getMeasureRelationship()
		 * @generated
		 */
		EClass MEASURE_RELATIONSHIP = eINSTANCE.getMeasureRelationship();

		/**
		 * The meta object literal for the '<em><b>Influence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_RELATIONSHIP__INFLUENCE = eINSTANCE.getMeasureRelationship_Influence();

		/**
		 * The meta object literal for the '<em><b>Measurand Query</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURE_RELATIONSHIP__MEASURAND_QUERY = eINSTANCE.getMeasureRelationship_MeasurandQuery();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.OperationImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__BODY = eINSTANCE.getOperation_Body();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__LANGUAGE = eINSTANCE.getOperation_Language();

		/**
		 * The meta object literal for the '<em><b>Get Param Strings</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPERATION___GET_PARAM_STRINGS = eINSTANCE.getOperation__GetParamStrings();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.EquivalentMeasureRelationshipImpl <em>Equivalent Measure Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.EquivalentMeasureRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getEquivalentMeasureRelationship()
		 * @generated
		 */
		EClass EQUIVALENT_MEASURE_RELATIONSHIP = eINSTANCE.getEquivalentMeasureRelationship();

		/**
		 * The meta object literal for the '<em><b>Mapping</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIVALENT_MEASURE_RELATIONSHIP__MAPPING = eINSTANCE.getEquivalentMeasureRelationship_Mapping();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.MeasureCategoryImpl <em>Measure Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.MeasureCategoryImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getMeasureCategory()
		 * @generated
		 */
		EClass MEASURE_CATEGORY = eINSTANCE.getMeasureCategory();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURE_CATEGORY__CATEGORY = eINSTANCE.getMeasureCategory_Category();

		/**
		 * The meta object literal for the '<em><b>Category Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURE_CATEGORY__CATEGORY_ELEMENT = eINSTANCE.getMeasureCategory_CategoryElement();

		/**
		 * The meta object literal for the '<em><b>Category Measure</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURE_CATEGORY__CATEGORY_MEASURE = eINSTANCE.getMeasureCategory_CategoryMeasure();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.ScopeImpl <em>Scope</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.ScopeImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getScope()
		 * @generated
		 */
		EClass SCOPE = eINSTANCE.getScope();

		/**
		 * The meta object literal for the '<em><b>Break Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOPE__BREAK_CONDITION = eINSTANCE.getScope_BreakCondition();

		/**
		 * The meta object literal for the '<em><b>Recognizer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOPE__RECOGNIZER = eINSTANCE.getScope_Recognizer();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOPE__CLASS = eINSTANCE.getScope_Class();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOPE__STEREOTYPE = eINSTANCE.getScope_Stereotype();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.CharacteristicImpl <em>Characteristic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.CharacteristicImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getCharacteristic()
		 * @generated
		 */
		EClass CHARACTERISTIC = eINSTANCE.getCharacteristic();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHARACTERISTIC__PARENT = eINSTANCE.getCharacteristic_Parent();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.Base1MeasureRelationshipImpl <em>Base1 Measure Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.Base1MeasureRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getBase1MeasureRelationship()
		 * @generated
		 */
		EClass BASE1_MEASURE_RELATIONSHIP = eINSTANCE.getBase1MeasureRelationship();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.BaseMeasureRelationshipImpl <em>Base Measure Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.BaseMeasureRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getBaseMeasureRelationship()
		 * @generated
		 */
		EClass BASE_MEASURE_RELATIONSHIP = eINSTANCE.getBaseMeasureRelationship();

		/**
		 * The meta object literal for the '<em><b>Rescaled Measure</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_MEASURE_RELATIONSHIP__RESCALED_MEASURE = eINSTANCE.getBaseMeasureRelationship_RescaledMeasure();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.RescaledMeasureImpl <em>Rescaled Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.RescaledMeasureImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getRescaledMeasure()
		 * @generated
		 */
		EClass RESCALED_MEASURE = eINSTANCE.getRescaledMeasure();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESCALED_MEASURE__OPERATION = eINSTANCE.getRescaledMeasure_Operation();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESCALED_MEASURE__OFFSET = eINSTANCE.getRescaledMeasure_Offset();

		/**
		 * The meta object literal for the '<em><b>Multiplier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESCALED_MEASURE__MULTIPLIER = eINSTANCE.getRescaledMeasure_Multiplier();

		/**
		 * The meta object literal for the '<em><b>Rescales</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESCALED_MEASURE__RESCALES = eINSTANCE.getRescaledMeasure_Rescales();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.DimensionalMeasureImpl <em>Dimensional Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.DimensionalMeasureImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getDimensionalMeasure()
		 * @generated
		 */
		EClass DIMENSIONAL_MEASURE = eINSTANCE.getDimensionalMeasure();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSIONAL_MEASURE__UNIT = eINSTANCE.getDimensionalMeasure_Unit();

		/**
		 * The meta object literal for the '<em><b>Formula</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSIONAL_MEASURE__FORMULA = eINSTANCE.getDimensionalMeasure_Formula();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.BaseNMeasureRelationshipImpl <em>Base NMeasure Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.BaseNMeasureRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getBaseNMeasureRelationship()
		 * @generated
		 */
		EClass BASE_NMEASURE_RELATIONSHIP = eINSTANCE.getBaseNMeasureRelationship();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.CollectiveMeasureImpl <em>Collective Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.CollectiveMeasureImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getCollectiveMeasure()
		 * @generated
		 */
		EClass COLLECTIVE_MEASURE = eINSTANCE.getCollectiveMeasure();

		/**
		 * The meta object literal for the '<em><b>Accumulator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTIVE_MEASURE__ACCUMULATOR = eINSTANCE.getCollectiveMeasure_Accumulator();

		/**
		 * The meta object literal for the '<em><b>Custom Accumulator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTIVE_MEASURE__CUSTOM_ACCUMULATOR = eINSTANCE.getCollectiveMeasure_CustomAccumulator();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.Base2MeasureRelationshipImpl <em>Base2 Measure Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.Base2MeasureRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getBase2MeasureRelationship()
		 * @generated
		 */
		EClass BASE2_MEASURE_RELATIONSHIP = eINSTANCE.getBase2MeasureRelationship();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.BinaryMeasureImpl <em>Binary Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.BinaryMeasureImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getBinaryMeasure()
		 * @generated
		 */
		EClass BINARY_MEASURE = eINSTANCE.getBinaryMeasure();

		/**
		 * The meta object literal for the '<em><b>Functor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_MEASURE__FUNCTOR = eINSTANCE.getBinaryMeasure_Functor();

		/**
		 * The meta object literal for the '<em><b>Custom Functor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_MEASURE__CUSTOM_FUNCTOR = eINSTANCE.getBinaryMeasure_CustomFunctor();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.RankingMeasureRelationshipImpl <em>Ranking Measure Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.RankingMeasureRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getRankingMeasureRelationship()
		 * @generated
		 */
		EClass RANKING_MEASURE_RELATIONSHIP = eINSTANCE.getRankingMeasureRelationship();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.RankingMeasureImpl <em>Ranking Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.RankingMeasureImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getRankingMeasure()
		 * @generated
		 */
		EClass RANKING_MEASURE = eINSTANCE.getRankingMeasure();

		/**
		 * The meta object literal for the '<em><b>Interval</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANKING_MEASURE__INTERVAL = eINSTANCE.getRankingMeasure_Interval();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.RankingIntervalImpl <em>Ranking Interval</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.RankingIntervalImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getRankingInterval()
		 * @generated
		 */
		EClass RANKING_INTERVAL = eINSTANCE.getRankingInterval();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANKING_INTERVAL__VALUE = eINSTANCE.getRankingInterval_Value();

		/**
		 * The meta object literal for the '<em><b>Ranking</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANKING_INTERVAL__RANKING = eINSTANCE.getRankingInterval_Ranking();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.IntervalImpl <em>Interval</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.IntervalImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getInterval()
		 * @generated
		 */
		EClass INTERVAL = eINSTANCE.getInterval();

		/**
		 * The meta object literal for the '<em><b>Maximum Endpoint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERVAL__MAXIMUM_ENDPOINT = eINSTANCE.getInterval_MaximumEndpoint();

		/**
		 * The meta object literal for the '<em><b>Maximum Open</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERVAL__MAXIMUM_OPEN = eINSTANCE.getInterval_MaximumOpen();

		/**
		 * The meta object literal for the '<em><b>Minimum Endpoint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERVAL__MINIMUM_ENDPOINT = eINSTANCE.getInterval_MinimumEndpoint();

		/**
		 * The meta object literal for the '<em><b>Minimum Open</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERVAL__MINIMUM_OPEN = eINSTANCE.getInterval_MinimumOpen();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.RescaledMeasureRelationshipImpl <em>Rescaled Measure Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.RescaledMeasureRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getRescaledMeasureRelationship()
		 * @generated
		 */
		EClass RESCALED_MEASURE_RELATIONSHIP = eINSTANCE.getRescaledMeasureRelationship();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.GradeMeasureRelationshipImpl <em>Grade Measure Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.GradeMeasureRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getGradeMeasureRelationship()
		 * @generated
		 */
		EClass GRADE_MEASURE_RELATIONSHIP = eINSTANCE.getGradeMeasureRelationship();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.GradeMeasureImpl <em>Grade Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.GradeMeasureImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getGradeMeasure()
		 * @generated
		 */
		EClass GRADE_MEASURE = eINSTANCE.getGradeMeasure();

		/**
		 * The meta object literal for the '<em><b>Interval</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRADE_MEASURE__INTERVAL = eINSTANCE.getGradeMeasure_Interval();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.GradeIntervalImpl <em>Grade Interval</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.GradeIntervalImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getGradeInterval()
		 * @generated
		 */
		EClass GRADE_INTERVAL = eINSTANCE.getGradeInterval();

		/**
		 * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRADE_INTERVAL__SYMBOL = eINSTANCE.getGradeInterval_Symbol();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.UnitOfMeasureImpl <em>Unit Of Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.UnitOfMeasureImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getUnitOfMeasure()
		 * @generated
		 */
		EClass UNIT_OF_MEASURE = eINSTANCE.getUnitOfMeasure();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.Base1MeasurementRelationshipImpl <em>Base1 Measurement Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.Base1MeasurementRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getBase1MeasurementRelationship()
		 * @generated
		 */
		EClass BASE1_MEASUREMENT_RELATIONSHIP = eINSTANCE.getBase1MeasurementRelationship();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.BaseMeasurementRelationshipImpl <em>Base Measurement Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.BaseMeasurementRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getBaseMeasurementRelationship()
		 * @generated
		 */
		EClass BASE_MEASUREMENT_RELATIONSHIP = eINSTANCE.getBaseMeasurementRelationship();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.DimensionalMeasurementImpl <em>Dimensional Measurement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.DimensionalMeasurementImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getDimensionalMeasurement()
		 * @generated
		 */
		EClass DIMENSIONAL_MEASUREMENT = eINSTANCE.getDimensionalMeasurement();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSIONAL_MEASUREMENT__VALUE = eINSTANCE.getDimensionalMeasurement_Value();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.BaseNMeasurementRelationshipImpl <em>Base NMeasurement Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.BaseNMeasurementRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getBaseNMeasurementRelationship()
		 * @generated
		 */
		EClass BASE_NMEASUREMENT_RELATIONSHIP = eINSTANCE.getBaseNMeasurementRelationship();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.CollectiveMeasurementImpl <em>Collective Measurement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.CollectiveMeasurementImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getCollectiveMeasurement()
		 * @generated
		 */
		EClass COLLECTIVE_MEASUREMENT = eINSTANCE.getCollectiveMeasurement();

		/**
		 * The meta object literal for the '<em><b>Is Base Supplied</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTIVE_MEASUREMENT__IS_BASE_SUPPLIED = eINSTANCE.getCollectiveMeasurement_IsBaseSupplied();

		/**
		 * The meta object literal for the '<em><b>Base Query</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTIVE_MEASUREMENT__BASE_QUERY = eINSTANCE.getCollectiveMeasurement_BaseQuery();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.Base2MeasurementRelationshipImpl <em>Base2 Measurement Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.Base2MeasurementRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getBase2MeasurementRelationship()
		 * @generated
		 */
		EClass BASE2_MEASUREMENT_RELATIONSHIP = eINSTANCE.getBase2MeasurementRelationship();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.BinaryMeasurementImpl <em>Binary Measurement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.BinaryMeasurementImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getBinaryMeasurement()
		 * @generated
		 */
		EClass BINARY_MEASUREMENT = eINSTANCE.getBinaryMeasurement();

		/**
		 * The meta object literal for the '<em><b>Is Base Supplied</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_MEASUREMENT__IS_BASE_SUPPLIED = eINSTANCE.getBinaryMeasurement_IsBaseSupplied();

		/**
		 * The meta object literal for the '<em><b>Base Query</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_MEASUREMENT__BASE_QUERY = eINSTANCE.getBinaryMeasurement_BaseQuery();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.GradeMeasurementRelationshipImpl <em>Grade Measurement Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.GradeMeasurementRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getGradeMeasurementRelationship()
		 * @generated
		 */
		EClass GRADE_MEASUREMENT_RELATIONSHIP = eINSTANCE.getGradeMeasurementRelationship();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.GradeMeasurementImpl <em>Grade Measurement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.GradeMeasurementImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getGradeMeasurement()
		 * @generated
		 */
		EClass GRADE_MEASUREMENT = eINSTANCE.getGradeMeasurement();

		/**
		 * The meta object literal for the '<em><b>Is Base Supplied</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRADE_MEASUREMENT__IS_BASE_SUPPLIED = eINSTANCE.getGradeMeasurement_IsBaseSupplied();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRADE_MEASUREMENT__VALUE = eINSTANCE.getGradeMeasurement_Value();

		/**
		 * The meta object literal for the '<em><b>Base Query</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRADE_MEASUREMENT__BASE_QUERY = eINSTANCE.getGradeMeasurement_BaseQuery();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.RescaledMeasurementRelationshipImpl <em>Rescaled Measurement Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.RescaledMeasurementRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getRescaledMeasurementRelationship()
		 * @generated
		 */
		EClass RESCALED_MEASUREMENT_RELATIONSHIP = eINSTANCE.getRescaledMeasurementRelationship();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.RescaledMeasurementImpl <em>Rescaled Measurement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.RescaledMeasurementImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getRescaledMeasurement()
		 * @generated
		 */
		EClass RESCALED_MEASUREMENT = eINSTANCE.getRescaledMeasurement();

		/**
		 * The meta object literal for the '<em><b>Is Base Supplied</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESCALED_MEASUREMENT__IS_BASE_SUPPLIED = eINSTANCE.getRescaledMeasurement_IsBaseSupplied();

		/**
		 * The meta object literal for the '<em><b>Base Query</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESCALED_MEASUREMENT__BASE_QUERY = eINSTANCE.getRescaledMeasurement_BaseQuery();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.RankingMeasurementRelationshipImpl <em>Ranking Measurement Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.RankingMeasurementRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getRankingMeasurementRelationship()
		 * @generated
		 */
		EClass RANKING_MEASUREMENT_RELATIONSHIP = eINSTANCE.getRankingMeasurementRelationship();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.RankingMeasurementImpl <em>Ranking Measurement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.RankingMeasurementImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getRankingMeasurement()
		 * @generated
		 */
		EClass RANKING_MEASUREMENT = eINSTANCE.getRankingMeasurement();

		/**
		 * The meta object literal for the '<em><b>Base Query</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANKING_MEASUREMENT__BASE_QUERY = eINSTANCE.getRankingMeasurement_BaseQuery();

		/**
		 * The meta object literal for the '<em><b>Is Base Supplied</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANKING_MEASUREMENT__IS_BASE_SUPPLIED = eINSTANCE.getRankingMeasurement_IsBaseSupplied();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.CategoryRelationshipImpl <em>Category Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.CategoryRelationshipImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getCategoryRelationship()
		 * @generated
		 */
		EClass CATEGORY_RELATIONSHIP = eINSTANCE.getCategoryRelationship();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.CountingMeasurementImpl <em>Counting Measurement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.CountingMeasurementImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getCountingMeasurement()
		 * @generated
		 */
		EClass COUNTING_MEASUREMENT = eINSTANCE.getCountingMeasurement();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.DirectMeasurementImpl <em>Direct Measurement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.DirectMeasurementImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getDirectMeasurement()
		 * @generated
		 */
		EClass DIRECT_MEASUREMENT = eINSTANCE.getDirectMeasurement();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.CountingMeasureImpl <em>Counting Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.CountingMeasureImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getCountingMeasure()
		 * @generated
		 */
		EClass COUNTING_MEASURE = eINSTANCE.getCountingMeasure();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.DirectMeasureImpl <em>Direct Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.DirectMeasureImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getDirectMeasure()
		 * @generated
		 */
		EClass DIRECT_MEASURE = eINSTANCE.getDirectMeasure();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECT_MEASURE__OPERATION = eINSTANCE.getDirectMeasure_Operation();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.MeasureLibraryImpl <em>Measure Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.MeasureLibraryImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getMeasureLibrary()
		 * @generated
		 */
		EClass MEASURE_LIBRARY = eINSTANCE.getMeasureLibrary();

		/**
		 * The meta object literal for the '<em><b>Measure Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURE_LIBRARY__MEASURE_ELEMENTS = eINSTANCE.getMeasureLibrary_MeasureElements();

		/**
		 * The meta object literal for the '<em><b>Category Relationships</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURE_LIBRARY__CATEGORY_RELATIONSHIPS = eINSTANCE.getMeasureLibrary_CategoryRelationships();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.NamedMeasureImpl <em>Named Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.NamedMeasureImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getNamedMeasure()
		 * @generated
		 */
		EClass NAMED_MEASURE = eINSTANCE.getNamedMeasure();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.NamedMeasurementImpl <em>Named Measurement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.NamedMeasurementImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getNamedMeasurement()
		 * @generated
		 */
		EClass NAMED_MEASUREMENT = eINSTANCE.getNamedMeasurement();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.OCLOperationImpl <em>OCL Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.OCLOperationImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getOCLOperation()
		 * @generated
		 */
		EClass OCL_OPERATION = eINSTANCE.getOCLOperation();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_OPERATION__BODY = eINSTANCE.getOCLOperation_Body();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_OPERATION__CONTEXT = eINSTANCE.getOCLOperation_Context();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.ObservationImpl <em>Observation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.ObservationImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getObservation()
		 * @generated
		 */
		EClass OBSERVATION = eINSTANCE.getObservation();

		/**
		 * The meta object literal for the '<em><b>Observer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBSERVATION__OBSERVER = eINSTANCE.getObservation_Observer();

		/**
		 * The meta object literal for the '<em><b>Tool</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBSERVATION__TOOL = eINSTANCE.getObservation_Tool();

		/**
		 * The meta object literal for the '<em><b>When Observed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBSERVATION__WHEN_OBSERVED = eINSTANCE.getObservation_WhenObserved();

		/**
		 * The meta object literal for the '<em><b>Scopes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBSERVATION__SCOPES = eINSTANCE.getObservation_Scopes();

		/**
		 * The meta object literal for the '<em><b>Observed Measures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBSERVATION__OBSERVED_MEASURES = eINSTANCE.getObservation_ObservedMeasures();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBSERVATION__ARGUMENTS = eINSTANCE.getObservation_Arguments();

		/**
		 * The meta object literal for the '<em><b>Requested Measures</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBSERVATION__REQUESTED_MEASURES = eINSTANCE.getObservation_RequestedMeasures();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.ObservationScopeImpl <em>Observation Scope</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.ObservationScopeImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getObservationScope()
		 * @generated
		 */
		EClass OBSERVATION_SCOPE = eINSTANCE.getObservationScope();

		/**
		 * The meta object literal for the '<em><b>Scope Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBSERVATION_SCOPE__SCOPE_URI = eINSTANCE.getObservationScope_ScopeUri();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.RatioMeasureImpl <em>Ratio Measure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.RatioMeasureImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getRatioMeasure()
		 * @generated
		 */
		EClass RATIO_MEASURE = eINSTANCE.getRatioMeasure();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.RatioMeasurementImpl <em>Ratio Measurement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.RatioMeasurementImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getRatioMeasurement()
		 * @generated
		 */
		EClass RATIO_MEASUREMENT = eINSTANCE.getRatioMeasurement();

		/**
		 * The meta object literal for the '{@link org.omg.smm.impl.SmmModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.impl.SmmModelImpl
		 * @see org.omg.smm.impl.SmmPackageImpl#getSmmModel()
		 * @generated
		 */
		EClass SMM_MODEL = eINSTANCE.getSmmModel();

		/**
		 * The meta object literal for the '<em><b>Libraries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMM_MODEL__LIBRARIES = eINSTANCE.getSmmModel_Libraries();

		/**
		 * The meta object literal for the '<em><b>Observations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMM_MODEL__OBSERVATIONS = eINSTANCE.getSmmModel_Observations();

		/**
		 * The meta object literal for the '{@link org.omg.smm.Accumulator <em>Accumulator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.Accumulator
		 * @see org.omg.smm.impl.SmmPackageImpl#getAccumulator()
		 * @generated
		 */
		EEnum ACCUMULATOR = eINSTANCE.getAccumulator();

		/**
		 * The meta object literal for the '{@link org.omg.smm.Influence <em>Influence</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.Influence
		 * @see org.omg.smm.impl.SmmPackageImpl#getInfluence()
		 * @generated
		 */
		EEnum INFLUENCE = eINSTANCE.getInfluence();

		/**
		 * The meta object literal for the '{@link org.omg.smm.ScaleOfMeasurement <em>Scale Of Measurement</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.ScaleOfMeasurement
		 * @see org.omg.smm.impl.SmmPackageImpl#getScaleOfMeasurement()
		 * @generated
		 */
		EEnum SCALE_OF_MEASUREMENT = eINSTANCE.getScaleOfMeasurement();

		/**
		 * The meta object literal for the '{@link org.omg.smm.BinaryFunctor <em>Binary Functor</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.BinaryFunctor
		 * @see org.omg.smm.impl.SmmPackageImpl#getBinaryFunctor()
		 * @generated
		 */
		EEnum BINARY_FUNCTOR = eINSTANCE.getBinaryFunctor();

		/**
		 * The meta object literal for the '{@link org.omg.smm.MeasurementScale <em>Measurement Scale</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.omg.smm.MeasurementScale
		 * @see org.omg.smm.impl.SmmPackageImpl#getMeasurementScale()
		 * @generated
		 */
		EEnum MEASUREMENT_SCALE = eINSTANCE.getMeasurementScale();

		/**
		 * The meta object literal for the '<em>Time Stamp</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.sql.Timestamp
		 * @see org.omg.smm.impl.SmmPackageImpl#getTimeStamp()
		 * @generated
		 */
		EDataType TIME_STAMP = eINSTANCE.getTimeStamp();

	}

} //SmmPackage
