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
package org.omg.smm.impl;

import java.sql.Timestamp;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.uml2.uml.UMLPackage;

import org.omg.smm.AbstractMeasureElement;
import org.omg.smm.Accumulator;
import org.omg.smm.Annotation;
import org.omg.smm.Argument;
import org.omg.smm.Attribute;
import org.omg.smm.Base1MeasureRelationship;
import org.omg.smm.Base1MeasurementRelationship;
import org.omg.smm.Base2MeasureRelationship;
import org.omg.smm.Base2MeasurementRelationship;
import org.omg.smm.BaseMeasureRelationship;
import org.omg.smm.BaseMeasurementRelationship;
import org.omg.smm.BaseNMeasureRelationship;
import org.omg.smm.BaseNMeasurementRelationship;
import org.omg.smm.BinaryFunctor;
import org.omg.smm.BinaryMeasure;
import org.omg.smm.BinaryMeasurement;
import org.omg.smm.CategoryRelationship;
import org.omg.smm.Characteristic;
import org.omg.smm.CollectiveMeasure;
import org.omg.smm.CollectiveMeasurement;
import org.omg.smm.CountingMeasure;
import org.omg.smm.CountingMeasurement;
import org.omg.smm.DimensionalMeasure;
import org.omg.smm.DimensionalMeasurement;
import org.omg.smm.DirectMeasure;
import org.omg.smm.DirectMeasurement;
import org.omg.smm.EquivalentMeasureRelationship;
import org.omg.smm.EquivalentMeasurementRelationship;
import org.omg.smm.GradeInterval;
import org.omg.smm.GradeMeasure;
import org.omg.smm.GradeMeasureRelationship;
import org.omg.smm.GradeMeasurement;
import org.omg.smm.GradeMeasurementRelationship;
import org.omg.smm.Influence;
import org.omg.smm.Interval;
import org.omg.smm.Measure;
import org.omg.smm.MeasureCategory;
import org.omg.smm.MeasureLibrary;
import org.omg.smm.MeasureRelationship;
import org.omg.smm.Measurement;
import org.omg.smm.MeasurementRelationship;
import org.omg.smm.MeasurementScale;
import org.omg.smm.NamedMeasure;
import org.omg.smm.NamedMeasurement;
import org.omg.smm.OCLOperation;
import org.omg.smm.Observation;
import org.omg.smm.ObservationScope;
import org.omg.smm.ObservedMeasure;
import org.omg.smm.Operation;
import org.omg.smm.RankingInterval;
import org.omg.smm.RankingMeasure;
import org.omg.smm.RankingMeasureRelationship;
import org.omg.smm.RankingMeasurement;
import org.omg.smm.RankingMeasurementRelationship;
import org.omg.smm.RatioMeasure;
import org.omg.smm.RatioMeasurement;
import org.omg.smm.RefinementMeasureRelationship;
import org.omg.smm.RefinementMeasurementRelationship;
import org.omg.smm.RescaledMeasure;
import org.omg.smm.RescaledMeasureRelationship;
import org.omg.smm.RescaledMeasurement;
import org.omg.smm.RescaledMeasurementRelationship;
import org.omg.smm.ScaleOfMeasurement;
import org.omg.smm.Scope;
import org.omg.smm.SmmElement;
import org.omg.smm.SmmFactory;
import org.omg.smm.SmmModel;
import org.omg.smm.SmmPackage;
import org.omg.smm.SmmRelationship;
import org.omg.smm.UnitOfMeasure;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SmmPackageImpl extends EPackageImpl implements SmmPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMeasureElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass smmElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass smmRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass argumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass observedMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measurementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equivalentMeasurementRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measurementRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass refinementMeasurementRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass refinementMeasureRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measureRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equivalentMeasureRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measureCategoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characteristicEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass base1MeasureRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseMeasureRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rescaledMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dimensionalMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseNMeasureRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectiveMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass base2MeasureRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rankingMeasureRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rankingMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rankingIntervalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intervalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rescaledMeasureRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gradeMeasureRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gradeMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gradeIntervalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitOfMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass base1MeasurementRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseMeasurementRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dimensionalMeasurementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseNMeasurementRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectiveMeasurementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass base2MeasurementRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryMeasurementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gradeMeasurementRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gradeMeasurementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rescaledMeasurementRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rescaledMeasurementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rankingMeasurementRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rankingMeasurementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass countingMeasurementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directMeasurementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass countingMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measureLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedMeasurementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass observationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass observationScopeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ratioMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ratioMeasurementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass smmModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum accumulatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum influenceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum scaleOfMeasurementEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum binaryFunctorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum measurementScaleEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType timeStampEDataType = null;

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
	 * @see org.omg.smm.SmmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SmmPackageImpl() {
		super(eNS_URI, SmmFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SmmPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SmmPackage init() {
		if (isInited) return (SmmPackage)EPackage.Registry.INSTANCE.getEPackage(SmmPackage.eNS_URI);

		// Obtain or create and register package
		SmmPackageImpl theSmmPackage = (SmmPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SmmPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SmmPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSmmPackage.createPackageContents();

		// Initialize created meta-data
		theSmmPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSmmPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SmmPackage.eNS_URI, theSmmPackage);
		return theSmmPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractMeasureElement() {
		return abstractMeasureElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSmmElement() {
		return smmElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmmElement_Description() {
		return (EAttribute)smmElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmmElement_Name() {
		return (EAttribute)smmElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmmElement_ShortDescription() {
		return (EAttribute)smmElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmmElement_InRelationships() {
		return (EReference)smmElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmmElement_OutRelationships() {
		return (EReference)smmElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmmElement_Attributes() {
		return (EReference)smmElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmmElement_Annotations() {
		return (EReference)smmElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSmmRelationship() {
		return smmRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmmRelationship_From() {
		return (EReference)smmRelationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmmRelationship_To() {
		return (EReference)smmRelationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttribute() {
		return attributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_Tag() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_Value() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotation() {
		return annotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotation_Text() {
		return (EAttribute)annotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArgument() {
		return argumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArgument_Type() {
		return (EAttribute)argumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArgument_Value() {
		return (EAttribute)argumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArgument_ObservedMeasure() {
		return (EReference)argumentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObservedMeasure() {
		return observedMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObservedMeasure_Measurements() {
		return (EReference)observedMeasureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObservedMeasure_Measure() {
		return (EReference)observedMeasureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObservedMeasure_Arguments() {
		return (EReference)observedMeasureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasurement() {
		return measurementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasurement_BreakValue() {
		return (EAttribute)measurementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasurement_Error() {
		return (EAttribute)measurementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasurement_MeasurementRelationships() {
		return (EReference)measurementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasurement_ObservedMeasure() {
		return (EReference)measurementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMeasurement__GetMeasureLabel() {
		return measurementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMeasurement__GetMeasurementLabel() {
		return measurementEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquivalentMeasurementRelationship() {
		return equivalentMeasurementRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasurementRelationship() {
		return measurementRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRefinementMeasurementRelationship() {
		return refinementMeasurementRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasure() {
		return measureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasure_MeasureLabelFormat() {
		return (EAttribute)measureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasure_MeasurementLabelFormat() {
		return (EAttribute)measureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasure_Visible() {
		return (EAttribute)measureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasure_Source() {
		return (EAttribute)measureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasure_DefaultQuery() {
		return (EReference)measureEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasure_MeasureRelationships() {
		return (EReference)measureEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasure_Category() {
		return (EReference)measureEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasure_Scope() {
		return (EReference)measureEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasure_Trait() {
		return (EReference)measureEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasure_Scale() {
		return (EAttribute)measureEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasure_CustomScale() {
		return (EAttribute)measureEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMeasure__GetAllArguments() {
		return measureEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMeasure__GetArguments() {
		return measureEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRefinementMeasureRelationship() {
		return refinementMeasureRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasureRelationship() {
		return measureRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureRelationship_Influence() {
		return (EAttribute)measureRelationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasureRelationship_MeasurandQuery() {
		return (EReference)measureRelationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperation() {
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_Body() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_Language() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperation__GetParamStrings() {
		return operationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquivalentMeasureRelationship() {
		return equivalentMeasureRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquivalentMeasureRelationship_Mapping() {
		return (EReference)equivalentMeasureRelationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasureCategory() {
		return measureCategoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasureCategory_Category() {
		return (EReference)measureCategoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasureCategory_CategoryElement() {
		return (EReference)measureCategoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasureCategory_CategoryMeasure() {
		return (EReference)measureCategoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScope() {
		return scopeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScope_BreakCondition() {
		return (EReference)scopeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScope_Recognizer() {
		return (EReference)scopeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScope_Class() {
		return (EReference)scopeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScope_Stereotype() {
		return (EReference)scopeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacteristic() {
		return characteristicEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCharacteristic_Parent() {
		return (EReference)characteristicEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBase1MeasureRelationship() {
		return base1MeasureRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBaseMeasureRelationship() {
		return baseMeasureRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBaseMeasureRelationship_RescaledMeasure() {
		return (EReference)baseMeasureRelationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRescaledMeasure() {
		return rescaledMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRescaledMeasure_Operation() {
		return (EReference)rescaledMeasureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRescaledMeasure_Offset() {
		return (EAttribute)rescaledMeasureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRescaledMeasure_Multiplier() {
		return (EAttribute)rescaledMeasureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRescaledMeasure_Rescales() {
		return (EReference)rescaledMeasureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDimensionalMeasure() {
		return dimensionalMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDimensionalMeasure_Unit() {
		return (EReference)dimensionalMeasureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDimensionalMeasure_Formula() {
		return (EAttribute)dimensionalMeasureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBaseNMeasureRelationship() {
		return baseNMeasureRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectiveMeasure() {
		return collectiveMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectiveMeasure_Accumulator() {
		return (EAttribute)collectiveMeasureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectiveMeasure_CustomAccumulator() {
		return (EReference)collectiveMeasureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBase2MeasureRelationship() {
		return base2MeasureRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryMeasure() {
		return binaryMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinaryMeasure_Functor() {
		return (EAttribute)binaryMeasureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryMeasure_CustomFunctor() {
		return (EReference)binaryMeasureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRankingMeasureRelationship() {
		return rankingMeasureRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRankingMeasure() {
		return rankingMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRankingMeasure_Interval() {
		return (EReference)rankingMeasureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRankingInterval() {
		return rankingIntervalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRankingInterval_Value() {
		return (EAttribute)rankingIntervalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRankingInterval_Ranking() {
		return (EReference)rankingIntervalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterval() {
		return intervalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterval_MaximumEndpoint() {
		return (EAttribute)intervalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterval_MaximumOpen() {
		return (EAttribute)intervalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterval_MinimumEndpoint() {
		return (EAttribute)intervalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterval_MinimumOpen() {
		return (EAttribute)intervalEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRescaledMeasureRelationship() {
		return rescaledMeasureRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGradeMeasureRelationship() {
		return gradeMeasureRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGradeMeasure() {
		return gradeMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGradeMeasure_Interval() {
		return (EReference)gradeMeasureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGradeInterval() {
		return gradeIntervalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGradeInterval_Symbol() {
		return (EAttribute)gradeIntervalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitOfMeasure() {
		return unitOfMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBase1MeasurementRelationship() {
		return base1MeasurementRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBaseMeasurementRelationship() {
		return baseMeasurementRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDimensionalMeasurement() {
		return dimensionalMeasurementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDimensionalMeasurement_Value() {
		return (EAttribute)dimensionalMeasurementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBaseNMeasurementRelationship() {
		return baseNMeasurementRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectiveMeasurement() {
		return collectiveMeasurementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectiveMeasurement_IsBaseSupplied() {
		return (EAttribute)collectiveMeasurementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectiveMeasurement_BaseQuery() {
		return (EReference)collectiveMeasurementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBase2MeasurementRelationship() {
		return base2MeasurementRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryMeasurement() {
		return binaryMeasurementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinaryMeasurement_IsBaseSupplied() {
		return (EAttribute)binaryMeasurementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryMeasurement_BaseQuery() {
		return (EReference)binaryMeasurementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGradeMeasurementRelationship() {
		return gradeMeasurementRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGradeMeasurement() {
		return gradeMeasurementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGradeMeasurement_IsBaseSupplied() {
		return (EAttribute)gradeMeasurementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGradeMeasurement_Value() {
		return (EAttribute)gradeMeasurementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGradeMeasurement_BaseQuery() {
		return (EReference)gradeMeasurementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRescaledMeasurementRelationship() {
		return rescaledMeasurementRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRescaledMeasurement() {
		return rescaledMeasurementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRescaledMeasurement_IsBaseSupplied() {
		return (EAttribute)rescaledMeasurementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRescaledMeasurement_BaseQuery() {
		return (EReference)rescaledMeasurementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRankingMeasurementRelationship() {
		return rankingMeasurementRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRankingMeasurement() {
		return rankingMeasurementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRankingMeasurement_BaseQuery() {
		return (EReference)rankingMeasurementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRankingMeasurement_IsBaseSupplied() {
		return (EAttribute)rankingMeasurementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCategoryRelationship() {
		return categoryRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCountingMeasurement() {
		return countingMeasurementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectMeasurement() {
		return directMeasurementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCountingMeasure() {
		return countingMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectMeasure() {
		return directMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDirectMeasure_Operation() {
		return (EReference)directMeasureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasureLibrary() {
		return measureLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasureLibrary_MeasureElements() {
		return (EReference)measureLibraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasureLibrary_CategoryRelationships() {
		return (EReference)measureLibraryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedMeasure() {
		return namedMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedMeasurement() {
		return namedMeasurementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOCLOperation() {
		return oclOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOCLOperation_Body() {
		return (EAttribute)oclOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOCLOperation_Context() {
		return (EAttribute)oclOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObservation() {
		return observationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObservation_Observer() {
		return (EAttribute)observationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObservation_Tool() {
		return (EAttribute)observationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObservation_WhenObserved() {
		return (EAttribute)observationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObservation_Scopes() {
		return (EReference)observationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObservation_ObservedMeasures() {
		return (EReference)observationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObservation_Arguments() {
		return (EReference)observationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObservation_RequestedMeasures() {
		return (EReference)observationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObservationScope() {
		return observationScopeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObservationScope_ScopeUri() {
		return (EAttribute)observationScopeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRatioMeasure() {
		return ratioMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRatioMeasurement() {
		return ratioMeasurementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSmmModel() {
		return smmModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmmModel_Libraries() {
		return (EReference)smmModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmmModel_Observations() {
		return (EReference)smmModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAccumulator() {
		return accumulatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getInfluence() {
		return influenceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getScaleOfMeasurement() {
		return scaleOfMeasurementEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBinaryFunctor() {
		return binaryFunctorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMeasurementScale() {
		return measurementScaleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTimeStamp() {
		return timeStampEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmmFactory getSmmFactory() {
		return (SmmFactory)getEFactoryInstance();
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
		abstractMeasureElementEClass = createEClass(ABSTRACT_MEASURE_ELEMENT);

		smmElementEClass = createEClass(SMM_ELEMENT);
		createEAttribute(smmElementEClass, SMM_ELEMENT__DESCRIPTION);
		createEAttribute(smmElementEClass, SMM_ELEMENT__NAME);
		createEAttribute(smmElementEClass, SMM_ELEMENT__SHORT_DESCRIPTION);
		createEReference(smmElementEClass, SMM_ELEMENT__IN_RELATIONSHIPS);
		createEReference(smmElementEClass, SMM_ELEMENT__OUT_RELATIONSHIPS);
		createEReference(smmElementEClass, SMM_ELEMENT__ATTRIBUTES);
		createEReference(smmElementEClass, SMM_ELEMENT__ANNOTATIONS);

		smmRelationshipEClass = createEClass(SMM_RELATIONSHIP);
		createEReference(smmRelationshipEClass, SMM_RELATIONSHIP__FROM);
		createEReference(smmRelationshipEClass, SMM_RELATIONSHIP__TO);

		attributeEClass = createEClass(ATTRIBUTE);
		createEAttribute(attributeEClass, ATTRIBUTE__TAG);
		createEAttribute(attributeEClass, ATTRIBUTE__VALUE);

		annotationEClass = createEClass(ANNOTATION);
		createEAttribute(annotationEClass, ANNOTATION__TEXT);

		argumentEClass = createEClass(ARGUMENT);
		createEAttribute(argumentEClass, ARGUMENT__TYPE);
		createEAttribute(argumentEClass, ARGUMENT__VALUE);
		createEReference(argumentEClass, ARGUMENT__OBSERVED_MEASURE);

		observedMeasureEClass = createEClass(OBSERVED_MEASURE);
		createEReference(observedMeasureEClass, OBSERVED_MEASURE__MEASUREMENTS);
		createEReference(observedMeasureEClass, OBSERVED_MEASURE__MEASURE);
		createEReference(observedMeasureEClass, OBSERVED_MEASURE__ARGUMENTS);

		measurementEClass = createEClass(MEASUREMENT);
		createEAttribute(measurementEClass, MEASUREMENT__BREAK_VALUE);
		createEAttribute(measurementEClass, MEASUREMENT__ERROR);
		createEReference(measurementEClass, MEASUREMENT__MEASUREMENT_RELATIONSHIPS);
		createEReference(measurementEClass, MEASUREMENT__OBSERVED_MEASURE);
		createEOperation(measurementEClass, MEASUREMENT___GET_MEASURE_LABEL);
		createEOperation(measurementEClass, MEASUREMENT___GET_MEASUREMENT_LABEL);

		equivalentMeasurementRelationshipEClass = createEClass(EQUIVALENT_MEASUREMENT_RELATIONSHIP);

		measurementRelationshipEClass = createEClass(MEASUREMENT_RELATIONSHIP);

		refinementMeasurementRelationshipEClass = createEClass(REFINEMENT_MEASUREMENT_RELATIONSHIP);

		measureEClass = createEClass(MEASURE);
		createEAttribute(measureEClass, MEASURE__MEASURE_LABEL_FORMAT);
		createEAttribute(measureEClass, MEASURE__MEASUREMENT_LABEL_FORMAT);
		createEAttribute(measureEClass, MEASURE__VISIBLE);
		createEAttribute(measureEClass, MEASURE__SOURCE);
		createEReference(measureEClass, MEASURE__DEFAULT_QUERY);
		createEReference(measureEClass, MEASURE__MEASURE_RELATIONSHIPS);
		createEReference(measureEClass, MEASURE__CATEGORY);
		createEReference(measureEClass, MEASURE__SCOPE);
		createEReference(measureEClass, MEASURE__TRAIT);
		createEAttribute(measureEClass, MEASURE__SCALE);
		createEAttribute(measureEClass, MEASURE__CUSTOM_SCALE);
		createEOperation(measureEClass, MEASURE___GET_ALL_ARGUMENTS);
		createEOperation(measureEClass, MEASURE___GET_ARGUMENTS);

		refinementMeasureRelationshipEClass = createEClass(REFINEMENT_MEASURE_RELATIONSHIP);

		measureRelationshipEClass = createEClass(MEASURE_RELATIONSHIP);
		createEAttribute(measureRelationshipEClass, MEASURE_RELATIONSHIP__INFLUENCE);
		createEReference(measureRelationshipEClass, MEASURE_RELATIONSHIP__MEASURAND_QUERY);

		operationEClass = createEClass(OPERATION);
		createEAttribute(operationEClass, OPERATION__BODY);
		createEAttribute(operationEClass, OPERATION__LANGUAGE);
		createEOperation(operationEClass, OPERATION___GET_PARAM_STRINGS);

		equivalentMeasureRelationshipEClass = createEClass(EQUIVALENT_MEASURE_RELATIONSHIP);
		createEReference(equivalentMeasureRelationshipEClass, EQUIVALENT_MEASURE_RELATIONSHIP__MAPPING);

		measureCategoryEClass = createEClass(MEASURE_CATEGORY);
		createEReference(measureCategoryEClass, MEASURE_CATEGORY__CATEGORY);
		createEReference(measureCategoryEClass, MEASURE_CATEGORY__CATEGORY_ELEMENT);
		createEReference(measureCategoryEClass, MEASURE_CATEGORY__CATEGORY_MEASURE);

		scopeEClass = createEClass(SCOPE);
		createEReference(scopeEClass, SCOPE__BREAK_CONDITION);
		createEReference(scopeEClass, SCOPE__RECOGNIZER);
		createEReference(scopeEClass, SCOPE__CLASS);
		createEReference(scopeEClass, SCOPE__STEREOTYPE);

		characteristicEClass = createEClass(CHARACTERISTIC);
		createEReference(characteristicEClass, CHARACTERISTIC__PARENT);

		base1MeasureRelationshipEClass = createEClass(BASE1_MEASURE_RELATIONSHIP);

		baseMeasureRelationshipEClass = createEClass(BASE_MEASURE_RELATIONSHIP);
		createEReference(baseMeasureRelationshipEClass, BASE_MEASURE_RELATIONSHIP__RESCALED_MEASURE);

		rescaledMeasureEClass = createEClass(RESCALED_MEASURE);
		createEReference(rescaledMeasureEClass, RESCALED_MEASURE__OPERATION);
		createEAttribute(rescaledMeasureEClass, RESCALED_MEASURE__OFFSET);
		createEAttribute(rescaledMeasureEClass, RESCALED_MEASURE__MULTIPLIER);
		createEReference(rescaledMeasureEClass, RESCALED_MEASURE__RESCALES);

		dimensionalMeasureEClass = createEClass(DIMENSIONAL_MEASURE);
		createEReference(dimensionalMeasureEClass, DIMENSIONAL_MEASURE__UNIT);
		createEAttribute(dimensionalMeasureEClass, DIMENSIONAL_MEASURE__FORMULA);

		baseNMeasureRelationshipEClass = createEClass(BASE_NMEASURE_RELATIONSHIP);

		collectiveMeasureEClass = createEClass(COLLECTIVE_MEASURE);
		createEAttribute(collectiveMeasureEClass, COLLECTIVE_MEASURE__ACCUMULATOR);
		createEReference(collectiveMeasureEClass, COLLECTIVE_MEASURE__CUSTOM_ACCUMULATOR);

		base2MeasureRelationshipEClass = createEClass(BASE2_MEASURE_RELATIONSHIP);

		binaryMeasureEClass = createEClass(BINARY_MEASURE);
		createEAttribute(binaryMeasureEClass, BINARY_MEASURE__FUNCTOR);
		createEReference(binaryMeasureEClass, BINARY_MEASURE__CUSTOM_FUNCTOR);

		rankingMeasureRelationshipEClass = createEClass(RANKING_MEASURE_RELATIONSHIP);

		rankingMeasureEClass = createEClass(RANKING_MEASURE);
		createEReference(rankingMeasureEClass, RANKING_MEASURE__INTERVAL);

		rankingIntervalEClass = createEClass(RANKING_INTERVAL);
		createEAttribute(rankingIntervalEClass, RANKING_INTERVAL__VALUE);
		createEReference(rankingIntervalEClass, RANKING_INTERVAL__RANKING);

		intervalEClass = createEClass(INTERVAL);
		createEAttribute(intervalEClass, INTERVAL__MAXIMUM_ENDPOINT);
		createEAttribute(intervalEClass, INTERVAL__MAXIMUM_OPEN);
		createEAttribute(intervalEClass, INTERVAL__MINIMUM_ENDPOINT);
		createEAttribute(intervalEClass, INTERVAL__MINIMUM_OPEN);

		rescaledMeasureRelationshipEClass = createEClass(RESCALED_MEASURE_RELATIONSHIP);

		gradeMeasureRelationshipEClass = createEClass(GRADE_MEASURE_RELATIONSHIP);

		gradeMeasureEClass = createEClass(GRADE_MEASURE);
		createEReference(gradeMeasureEClass, GRADE_MEASURE__INTERVAL);

		gradeIntervalEClass = createEClass(GRADE_INTERVAL);
		createEAttribute(gradeIntervalEClass, GRADE_INTERVAL__SYMBOL);

		unitOfMeasureEClass = createEClass(UNIT_OF_MEASURE);

		base1MeasurementRelationshipEClass = createEClass(BASE1_MEASUREMENT_RELATIONSHIP);

		baseMeasurementRelationshipEClass = createEClass(BASE_MEASUREMENT_RELATIONSHIP);

		dimensionalMeasurementEClass = createEClass(DIMENSIONAL_MEASUREMENT);
		createEAttribute(dimensionalMeasurementEClass, DIMENSIONAL_MEASUREMENT__VALUE);

		baseNMeasurementRelationshipEClass = createEClass(BASE_NMEASUREMENT_RELATIONSHIP);

		collectiveMeasurementEClass = createEClass(COLLECTIVE_MEASUREMENT);
		createEAttribute(collectiveMeasurementEClass, COLLECTIVE_MEASUREMENT__IS_BASE_SUPPLIED);
		createEReference(collectiveMeasurementEClass, COLLECTIVE_MEASUREMENT__BASE_QUERY);

		base2MeasurementRelationshipEClass = createEClass(BASE2_MEASUREMENT_RELATIONSHIP);

		binaryMeasurementEClass = createEClass(BINARY_MEASUREMENT);
		createEAttribute(binaryMeasurementEClass, BINARY_MEASUREMENT__IS_BASE_SUPPLIED);
		createEReference(binaryMeasurementEClass, BINARY_MEASUREMENT__BASE_QUERY);

		gradeMeasurementRelationshipEClass = createEClass(GRADE_MEASUREMENT_RELATIONSHIP);

		gradeMeasurementEClass = createEClass(GRADE_MEASUREMENT);
		createEAttribute(gradeMeasurementEClass, GRADE_MEASUREMENT__IS_BASE_SUPPLIED);
		createEAttribute(gradeMeasurementEClass, GRADE_MEASUREMENT__VALUE);
		createEReference(gradeMeasurementEClass, GRADE_MEASUREMENT__BASE_QUERY);

		rescaledMeasurementRelationshipEClass = createEClass(RESCALED_MEASUREMENT_RELATIONSHIP);

		rescaledMeasurementEClass = createEClass(RESCALED_MEASUREMENT);
		createEAttribute(rescaledMeasurementEClass, RESCALED_MEASUREMENT__IS_BASE_SUPPLIED);
		createEReference(rescaledMeasurementEClass, RESCALED_MEASUREMENT__BASE_QUERY);

		rankingMeasurementRelationshipEClass = createEClass(RANKING_MEASUREMENT_RELATIONSHIP);

		rankingMeasurementEClass = createEClass(RANKING_MEASUREMENT);
		createEReference(rankingMeasurementEClass, RANKING_MEASUREMENT__BASE_QUERY);
		createEAttribute(rankingMeasurementEClass, RANKING_MEASUREMENT__IS_BASE_SUPPLIED);

		categoryRelationshipEClass = createEClass(CATEGORY_RELATIONSHIP);

		countingMeasurementEClass = createEClass(COUNTING_MEASUREMENT);

		directMeasurementEClass = createEClass(DIRECT_MEASUREMENT);

		countingMeasureEClass = createEClass(COUNTING_MEASURE);

		directMeasureEClass = createEClass(DIRECT_MEASURE);
		createEReference(directMeasureEClass, DIRECT_MEASURE__OPERATION);

		measureLibraryEClass = createEClass(MEASURE_LIBRARY);
		createEReference(measureLibraryEClass, MEASURE_LIBRARY__MEASURE_ELEMENTS);
		createEReference(measureLibraryEClass, MEASURE_LIBRARY__CATEGORY_RELATIONSHIPS);

		namedMeasureEClass = createEClass(NAMED_MEASURE);

		namedMeasurementEClass = createEClass(NAMED_MEASUREMENT);

		oclOperationEClass = createEClass(OCL_OPERATION);
		createEAttribute(oclOperationEClass, OCL_OPERATION__BODY);
		createEAttribute(oclOperationEClass, OCL_OPERATION__CONTEXT);

		observationEClass = createEClass(OBSERVATION);
		createEAttribute(observationEClass, OBSERVATION__OBSERVER);
		createEAttribute(observationEClass, OBSERVATION__TOOL);
		createEAttribute(observationEClass, OBSERVATION__WHEN_OBSERVED);
		createEReference(observationEClass, OBSERVATION__SCOPES);
		createEReference(observationEClass, OBSERVATION__OBSERVED_MEASURES);
		createEReference(observationEClass, OBSERVATION__ARGUMENTS);
		createEReference(observationEClass, OBSERVATION__REQUESTED_MEASURES);

		observationScopeEClass = createEClass(OBSERVATION_SCOPE);
		createEAttribute(observationScopeEClass, OBSERVATION_SCOPE__SCOPE_URI);

		ratioMeasureEClass = createEClass(RATIO_MEASURE);

		ratioMeasurementEClass = createEClass(RATIO_MEASUREMENT);

		smmModelEClass = createEClass(SMM_MODEL);
		createEReference(smmModelEClass, SMM_MODEL__LIBRARIES);
		createEReference(smmModelEClass, SMM_MODEL__OBSERVATIONS);

		// Create enums
		accumulatorEEnum = createEEnum(ACCUMULATOR);
		influenceEEnum = createEEnum(INFLUENCE);
		scaleOfMeasurementEEnum = createEEnum(SCALE_OF_MEASUREMENT);
		binaryFunctorEEnum = createEEnum(BINARY_FUNCTOR);
		measurementScaleEEnum = createEEnum(MEASUREMENT_SCALE);

		// Create data types
		timeStampEDataType = createEDataType(TIME_STAMP);
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
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractMeasureElementEClass.getESuperTypes().add(this.getSmmElement());
		smmRelationshipEClass.getESuperTypes().add(this.getSmmElement());
		attributeEClass.getESuperTypes().add(this.getSmmElement());
		annotationEClass.getESuperTypes().add(this.getSmmElement());
		argumentEClass.getESuperTypes().add(this.getSmmElement());
		observedMeasureEClass.getESuperTypes().add(this.getSmmElement());
		measurementEClass.getESuperTypes().add(this.getSmmElement());
		equivalentMeasurementRelationshipEClass.getESuperTypes().add(this.getMeasurementRelationship());
		measurementRelationshipEClass.getESuperTypes().add(this.getSmmRelationship());
		refinementMeasurementRelationshipEClass.getESuperTypes().add(this.getMeasurementRelationship());
		measureEClass.getESuperTypes().add(this.getAbstractMeasureElement());
		refinementMeasureRelationshipEClass.getESuperTypes().add(this.getMeasureRelationship());
		measureRelationshipEClass.getESuperTypes().add(this.getSmmRelationship());
		operationEClass.getESuperTypes().add(this.getAbstractMeasureElement());
		equivalentMeasureRelationshipEClass.getESuperTypes().add(this.getMeasureRelationship());
		measureCategoryEClass.getESuperTypes().add(this.getAbstractMeasureElement());
		scopeEClass.getESuperTypes().add(this.getAbstractMeasureElement());
		characteristicEClass.getESuperTypes().add(this.getAbstractMeasureElement());
		base1MeasureRelationshipEClass.getESuperTypes().add(this.getBaseMeasureRelationship());
		baseMeasureRelationshipEClass.getESuperTypes().add(this.getMeasureRelationship());
		rescaledMeasureEClass.getESuperTypes().add(this.getDimensionalMeasure());
		dimensionalMeasureEClass.getESuperTypes().add(this.getMeasure());
		baseNMeasureRelationshipEClass.getESuperTypes().add(this.getBaseMeasureRelationship());
		collectiveMeasureEClass.getESuperTypes().add(this.getDimensionalMeasure());
		base2MeasureRelationshipEClass.getESuperTypes().add(this.getBaseMeasureRelationship());
		binaryMeasureEClass.getESuperTypes().add(this.getDimensionalMeasure());
		rankingMeasureRelationshipEClass.getESuperTypes().add(this.getBaseMeasureRelationship());
		rankingMeasureEClass.getESuperTypes().add(this.getDimensionalMeasure());
		rankingIntervalEClass.getESuperTypes().add(this.getInterval());
		intervalEClass.getESuperTypes().add(this.getSmmElement());
		rescaledMeasureRelationshipEClass.getESuperTypes().add(this.getMeasureRelationship());
		gradeMeasureRelationshipEClass.getESuperTypes().add(this.getMeasureRelationship());
		gradeMeasureEClass.getESuperTypes().add(this.getMeasure());
		gradeIntervalEClass.getESuperTypes().add(this.getInterval());
		unitOfMeasureEClass.getESuperTypes().add(this.getAbstractMeasureElement());
		base1MeasurementRelationshipEClass.getESuperTypes().add(this.getBaseMeasurementRelationship());
		baseMeasurementRelationshipEClass.getESuperTypes().add(this.getMeasurementRelationship());
		dimensionalMeasurementEClass.getESuperTypes().add(this.getMeasurement());
		baseNMeasurementRelationshipEClass.getESuperTypes().add(this.getBaseMeasurementRelationship());
		collectiveMeasurementEClass.getESuperTypes().add(this.getDimensionalMeasurement());
		base2MeasurementRelationshipEClass.getESuperTypes().add(this.getBaseMeasurementRelationship());
		binaryMeasurementEClass.getESuperTypes().add(this.getDimensionalMeasurement());
		gradeMeasurementRelationshipEClass.getESuperTypes().add(this.getMeasurementRelationship());
		gradeMeasurementEClass.getESuperTypes().add(this.getMeasurement());
		rescaledMeasurementRelationshipEClass.getESuperTypes().add(this.getMeasurementRelationship());
		rescaledMeasurementEClass.getESuperTypes().add(this.getDimensionalMeasurement());
		rankingMeasurementRelationshipEClass.getESuperTypes().add(this.getMeasurementRelationship());
		rankingMeasurementEClass.getESuperTypes().add(this.getDimensionalMeasurement());
		categoryRelationshipEClass.getESuperTypes().add(this.getSmmRelationship());
		countingMeasurementEClass.getESuperTypes().add(this.getDirectMeasurement());
		directMeasurementEClass.getESuperTypes().add(this.getDimensionalMeasurement());
		countingMeasureEClass.getESuperTypes().add(this.getDirectMeasure());
		directMeasureEClass.getESuperTypes().add(this.getDimensionalMeasure());
		measureLibraryEClass.getESuperTypes().add(this.getSmmElement());
		namedMeasureEClass.getESuperTypes().add(this.getDimensionalMeasure());
		namedMeasurementEClass.getESuperTypes().add(this.getDimensionalMeasurement());
		oclOperationEClass.getESuperTypes().add(this.getAbstractMeasureElement());
		observationEClass.getESuperTypes().add(this.getSmmElement());
		observationScopeEClass.getESuperTypes().add(this.getSmmElement());
		ratioMeasureEClass.getESuperTypes().add(this.getBinaryMeasure());
		ratioMeasurementEClass.getESuperTypes().add(this.getBinaryMeasurement());
		smmModelEClass.getESuperTypes().add(this.getSmmElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(abstractMeasureElementEClass, AbstractMeasureElement.class, "AbstractMeasureElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(smmElementEClass, SmmElement.class, "SmmElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSmmElement_Description(), ecorePackage.getEString(), "description", null, 1, 1, SmmElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmmElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, SmmElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmmElement_ShortDescription(), ecorePackage.getEString(), "shortDescription", null, 1, 1, SmmElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSmmElement_InRelationships(), this.getSmmRelationship(), this.getSmmRelationship_To(), "inRelationships", null, 0, -1, SmmElement.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getSmmElement_OutRelationships(), this.getSmmRelationship(), this.getSmmRelationship_From(), "outRelationships", null, 0, -1, SmmElement.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getSmmElement_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, SmmElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSmmElement_Annotations(), this.getAnnotation(), null, "annotations", null, 0, -1, SmmElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(smmRelationshipEClass, SmmRelationship.class, "SmmRelationship", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSmmRelationship_From(), this.getSmmElement(), this.getSmmElement_OutRelationships(), "from", null, 1, 1, SmmRelationship.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSmmRelationship_To(), this.getSmmElement(), this.getSmmElement_InRelationships(), "to", null, 1, 1, SmmRelationship.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttribute_Tag(), ecorePackage.getEString(), "tag", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_Value(), ecorePackage.getEString(), "value", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationEClass, Annotation.class, "Annotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnnotation_Text(), ecorePackage.getEString(), "text", null, 1, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(argumentEClass, Argument.class, "Argument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArgument_Type(), ecorePackage.getEString(), "type", null, 1, 1, Argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArgument_Value(), ecorePackage.getEString(), "value", null, 1, 1, Argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArgument_ObservedMeasure(), this.getObservedMeasure(), this.getObservedMeasure_Arguments(), "observedMeasure", null, 0, 1, Argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(observedMeasureEClass, ObservedMeasure.class, "ObservedMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObservedMeasure_Measurements(), this.getMeasurement(), this.getMeasurement_ObservedMeasure(), "measurements", null, 0, -1, ObservedMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getObservedMeasure_Measure(), this.getMeasure(), null, "measure", null, 1, 1, ObservedMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObservedMeasure_Arguments(), this.getArgument(), this.getArgument_ObservedMeasure(), "arguments", null, 0, -1, ObservedMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(measurementEClass, Measurement.class, "Measurement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMeasurement_BreakValue(), ecorePackage.getEString(), "breakValue", null, 0, 1, Measurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasurement_Error(), ecorePackage.getEString(), "error", null, 0, 1, Measurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMeasurement_MeasurementRelationships(), this.getMeasurementRelationship(), null, "measurementRelationships", null, 0, -1, Measurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasurement_ObservedMeasure(), this.getObservedMeasure(), this.getObservedMeasure_Measurements(), "observedMeasure", null, 1, 1, Measurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMeasurement__GetMeasureLabel(), ecorePackage.getEString(), "getMeasureLabel", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMeasurement__GetMeasurementLabel(), ecorePackage.getEString(), "getMeasurementLabel", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(equivalentMeasurementRelationshipEClass, EquivalentMeasurementRelationship.class, "EquivalentMeasurementRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(measurementRelationshipEClass, MeasurementRelationship.class, "MeasurementRelationship", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(refinementMeasurementRelationshipEClass, RefinementMeasurementRelationship.class, "RefinementMeasurementRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(measureEClass, Measure.class, "Measure", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMeasure_MeasureLabelFormat(), ecorePackage.getEString(), "measureLabelFormat", null, 0, 1, Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasure_MeasurementLabelFormat(), ecorePackage.getEString(), "measurementLabelFormat", null, 0, 1, Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasure_Visible(), ecorePackage.getEBoolean(), "visible", "true", 0, 1, Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasure_Source(), ecorePackage.getEString(), "source", null, 0, 1, Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMeasure_DefaultQuery(), this.getOperation(), null, "defaultQuery", null, 0, 1, Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMeasure_MeasureRelationships(), this.getMeasureRelationship(), null, "measureRelationships", null, 0, -1, Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasure_Category(), this.getMeasureCategory(), this.getMeasureCategory_CategoryMeasure(), "category", null, 0, -1, Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasure_Scope(), this.getScope(), null, "scope", null, 1, 1, Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMeasure_Trait(), this.getCharacteristic(), null, "trait", null, 1, 1, Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasure_Scale(), this.getScaleOfMeasurement(), "scale", null, 0, 1, Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasure_CustomScale(), ecorePackage.getEString(), "customScale", null, 0, 1, Measure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMeasure__GetAllArguments(), this.getArgument(), "getAllArguments", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getMeasure__GetArguments(), this.getArgument(), "getArguments", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEClass(refinementMeasureRelationshipEClass, RefinementMeasureRelationship.class, "RefinementMeasureRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(measureRelationshipEClass, MeasureRelationship.class, "MeasureRelationship", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMeasureRelationship_Influence(), this.getInfluence(), "influence", null, 0, 1, MeasureRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMeasureRelationship_MeasurandQuery(), this.getOperation(), null, "measurandQuery", null, 0, 1, MeasureRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperation_Body(), ecorePackage.getEString(), "body", null, 1, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperation_Language(), ecorePackage.getEString(), "language", null, 1, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getOperation__GetParamStrings(), ecorePackage.getEString(), "getParamStrings", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(equivalentMeasureRelationshipEClass, EquivalentMeasureRelationship.class, "EquivalentMeasureRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEquivalentMeasureRelationship_Mapping(), this.getOperation(), null, "mapping", null, 0, 1, EquivalentMeasureRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(measureCategoryEClass, MeasureCategory.class, "MeasureCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMeasureCategory_Category(), this.getMeasureCategory(), this.getMeasureCategory_CategoryElement(), "category", null, 0, -1, MeasureCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasureCategory_CategoryElement(), this.getMeasureCategory(), this.getMeasureCategory_Category(), "categoryElement", null, 0, -1, MeasureCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasureCategory_CategoryMeasure(), this.getMeasure(), this.getMeasure_Category(), "categoryMeasure", null, 0, -1, MeasureCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(scopeEClass, Scope.class, "Scope", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScope_BreakCondition(), this.getOperation(), null, "breakCondition", null, 0, 1, Scope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScope_Recognizer(), this.getOperation(), null, "recognizer", null, 0, 1, Scope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScope_Class(), theUMLPackage.getClass_(), null, "class", null, 0, 1, Scope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScope_Stereotype(), theUMLPackage.getStereotype(), null, "stereotype", null, 0, 1, Scope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(characteristicEClass, Characteristic.class, "Characteristic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCharacteristic_Parent(), this.getCharacteristic(), null, "parent", null, 0, 1, Characteristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(base1MeasureRelationshipEClass, Base1MeasureRelationship.class, "Base1MeasureRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(baseMeasureRelationshipEClass, BaseMeasureRelationship.class, "BaseMeasureRelationship", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBaseMeasureRelationship_RescaledMeasure(), this.getRescaledMeasure(), this.getRescaledMeasure_Rescales(), "rescaledMeasure", null, 0, 1, BaseMeasureRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rescaledMeasureEClass, RescaledMeasure.class, "RescaledMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRescaledMeasure_Operation(), this.getOperation(), null, "operation", null, 0, 1, RescaledMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRescaledMeasure_Offset(), ecorePackage.getEBigDecimal(), "offset", null, 0, 1, RescaledMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRescaledMeasure_Multiplier(), ecorePackage.getEBigDecimal(), "multiplier", null, 0, 1, RescaledMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRescaledMeasure_Rescales(), this.getBaseMeasureRelationship(), this.getBaseMeasureRelationship_RescaledMeasure(), "rescales", null, 0, 1, RescaledMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dimensionalMeasureEClass, DimensionalMeasure.class, "DimensionalMeasure", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDimensionalMeasure_Unit(), this.getUnitOfMeasure(), null, "unit", null, 1, 1, DimensionalMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDimensionalMeasure_Formula(), ecorePackage.getEString(), "formula", null, 0, 1, DimensionalMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(baseNMeasureRelationshipEClass, BaseNMeasureRelationship.class, "BaseNMeasureRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(collectiveMeasureEClass, CollectiveMeasure.class, "CollectiveMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollectiveMeasure_Accumulator(), this.getAccumulator(), "accumulator", null, 1, 1, CollectiveMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectiveMeasure_CustomAccumulator(), this.getOperation(), null, "customAccumulator", null, 0, 1, CollectiveMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(base2MeasureRelationshipEClass, Base2MeasureRelationship.class, "Base2MeasureRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(binaryMeasureEClass, BinaryMeasure.class, "BinaryMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBinaryMeasure_Functor(), this.getBinaryFunctor(), "functor", null, 1, 1, BinaryMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryMeasure_CustomFunctor(), this.getOperation(), null, "customFunctor", null, 0, 1, BinaryMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rankingMeasureRelationshipEClass, RankingMeasureRelationship.class, "RankingMeasureRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rankingMeasureEClass, RankingMeasure.class, "RankingMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRankingMeasure_Interval(), this.getRankingInterval(), this.getRankingInterval_Ranking(), "interval", null, 1, -1, RankingMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rankingIntervalEClass, RankingInterval.class, "RankingInterval", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRankingInterval_Value(), ecorePackage.getEBigDecimal(), "value", null, 1, 1, RankingInterval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRankingInterval_Ranking(), this.getRankingMeasure(), this.getRankingMeasure_Interval(), "ranking", null, 1, 1, RankingInterval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intervalEClass, Interval.class, "Interval", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInterval_MaximumEndpoint(), ecorePackage.getEBigDecimal(), "maximumEndpoint", null, 0, 1, Interval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterval_MaximumOpen(), ecorePackage.getEBoolean(), "maximumOpen", "false", 0, 1, Interval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterval_MinimumEndpoint(), ecorePackage.getEBigDecimal(), "minimumEndpoint", null, 0, 1, Interval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterval_MinimumOpen(), ecorePackage.getEBoolean(), "minimumOpen", "false", 0, 1, Interval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rescaledMeasureRelationshipEClass, RescaledMeasureRelationship.class, "RescaledMeasureRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(gradeMeasureRelationshipEClass, GradeMeasureRelationship.class, "GradeMeasureRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(gradeMeasureEClass, GradeMeasure.class, "GradeMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGradeMeasure_Interval(), this.getGradeInterval(), null, "interval", null, 1, -1, GradeMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(gradeIntervalEClass, GradeInterval.class, "GradeInterval", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGradeInterval_Symbol(), ecorePackage.getEString(), "symbol", null, 1, 1, GradeInterval.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitOfMeasureEClass, UnitOfMeasure.class, "UnitOfMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(base1MeasurementRelationshipEClass, Base1MeasurementRelationship.class, "Base1MeasurementRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(baseMeasurementRelationshipEClass, BaseMeasurementRelationship.class, "BaseMeasurementRelationship", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dimensionalMeasurementEClass, DimensionalMeasurement.class, "DimensionalMeasurement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDimensionalMeasurement_Value(), ecorePackage.getEBigDecimal(), "value", null, 0, 1, DimensionalMeasurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(baseNMeasurementRelationshipEClass, BaseNMeasurementRelationship.class, "BaseNMeasurementRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(collectiveMeasurementEClass, CollectiveMeasurement.class, "CollectiveMeasurement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollectiveMeasurement_IsBaseSupplied(), ecorePackage.getEBoolean(), "isBaseSupplied", null, 1, 1, CollectiveMeasurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectiveMeasurement_BaseQuery(), this.getOperation(), null, "baseQuery", null, 0, 1, CollectiveMeasurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(base2MeasurementRelationshipEClass, Base2MeasurementRelationship.class, "Base2MeasurementRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(binaryMeasurementEClass, BinaryMeasurement.class, "BinaryMeasurement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBinaryMeasurement_IsBaseSupplied(), ecorePackage.getEBoolean(), "isBaseSupplied", null, 1, 1, BinaryMeasurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryMeasurement_BaseQuery(), this.getOperation(), null, "baseQuery", null, 0, 1, BinaryMeasurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(gradeMeasurementRelationshipEClass, GradeMeasurementRelationship.class, "GradeMeasurementRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(gradeMeasurementEClass, GradeMeasurement.class, "GradeMeasurement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGradeMeasurement_IsBaseSupplied(), ecorePackage.getEBoolean(), "isBaseSupplied", null, 1, 1, GradeMeasurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGradeMeasurement_Value(), ecorePackage.getEString(), "value", null, 0, 1, GradeMeasurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGradeMeasurement_BaseQuery(), this.getOperation(), null, "baseQuery", null, 0, 1, GradeMeasurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rescaledMeasurementRelationshipEClass, RescaledMeasurementRelationship.class, "RescaledMeasurementRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rescaledMeasurementEClass, RescaledMeasurement.class, "RescaledMeasurement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRescaledMeasurement_IsBaseSupplied(), ecorePackage.getEBoolean(), "isBaseSupplied", null, 1, 1, RescaledMeasurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRescaledMeasurement_BaseQuery(), this.getOperation(), null, "baseQuery", null, 0, 1, RescaledMeasurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rankingMeasurementRelationshipEClass, RankingMeasurementRelationship.class, "RankingMeasurementRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rankingMeasurementEClass, RankingMeasurement.class, "RankingMeasurement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRankingMeasurement_BaseQuery(), this.getOperation(), null, "baseQuery", null, 0, 1, RankingMeasurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRankingMeasurement_IsBaseSupplied(), ecorePackage.getEBoolean(), "isBaseSupplied", null, 1, 1, RankingMeasurement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(categoryRelationshipEClass, CategoryRelationship.class, "CategoryRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(countingMeasurementEClass, CountingMeasurement.class, "CountingMeasurement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(directMeasurementEClass, DirectMeasurement.class, "DirectMeasurement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(countingMeasureEClass, CountingMeasure.class, "CountingMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(directMeasureEClass, DirectMeasure.class, "DirectMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDirectMeasure_Operation(), this.getOperation(), null, "operation", null, 0, 1, DirectMeasure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(measureLibraryEClass, MeasureLibrary.class, "MeasureLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMeasureLibrary_MeasureElements(), this.getAbstractMeasureElement(), null, "measureElements", null, 0, -1, MeasureLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasureLibrary_CategoryRelationships(), this.getCategoryRelationship(), null, "categoryRelationships", null, 0, -1, MeasureLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(namedMeasureEClass, NamedMeasure.class, "NamedMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namedMeasurementEClass, NamedMeasurement.class, "NamedMeasurement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(oclOperationEClass, OCLOperation.class, "OCLOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOCLOperation_Body(), ecorePackage.getEString(), "body", null, 1, 1, OCLOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOCLOperation_Context(), ecorePackage.getEString(), "context", null, 1, 1, OCLOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(observationEClass, Observation.class, "Observation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getObservation_Observer(), ecorePackage.getEString(), "observer", null, 0, 1, Observation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObservation_Tool(), ecorePackage.getEString(), "tool", null, 0, 1, Observation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObservation_WhenObserved(), this.getTimeStamp(), "whenObserved", null, 0, 1, Observation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObservation_Scopes(), this.getObservationScope(), null, "scopes", null, 0, -1, Observation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getObservation_ObservedMeasures(), this.getObservedMeasure(), null, "observedMeasures", null, 0, -1, Observation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getObservation_Arguments(), this.getArgument(), null, "arguments", null, 0, -1, Observation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getObservation_RequestedMeasures(), this.getAbstractMeasureElement(), null, "requestedMeasures", null, 0, -1, Observation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(observationScopeEClass, ObservationScope.class, "ObservationScope", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getObservationScope_ScopeUri(), ecorePackage.getEString(), "scopeUri", null, 1, 1, ObservationScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ratioMeasureEClass, RatioMeasure.class, "RatioMeasure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ratioMeasurementEClass, RatioMeasurement.class, "RatioMeasurement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(smmModelEClass, SmmModel.class, "SmmModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSmmModel_Libraries(), this.getMeasureLibrary(), null, "libraries", null, 0, -1, SmmModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSmmModel_Observations(), this.getObservation(), null, "observations", null, 0, -1, SmmModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(accumulatorEEnum, Accumulator.class, "Accumulator");
		addEEnumLiteral(accumulatorEEnum, Accumulator.SUM);
		addEEnumLiteral(accumulatorEEnum, Accumulator.MAXIMUM);
		addEEnumLiteral(accumulatorEEnum, Accumulator.MINIMUM);
		addEEnumLiteral(accumulatorEEnum, Accumulator.AVERAGE);
		addEEnumLiteral(accumulatorEEnum, Accumulator.STANDARD_DEVIATION);
		addEEnumLiteral(accumulatorEEnum, Accumulator.PRODUCT);
		addEEnumLiteral(accumulatorEEnum, Accumulator.CUSTOM);

		initEEnum(influenceEEnum, Influence.class, "Influence");
		addEEnumLiteral(influenceEEnum, Influence.POSITIVE);
		addEEnumLiteral(influenceEEnum, Influence.NEGATIVE);

		initEEnum(scaleOfMeasurementEEnum, ScaleOfMeasurement.class, "ScaleOfMeasurement");
		addEEnumLiteral(scaleOfMeasurementEEnum, ScaleOfMeasurement.NOMINAL);
		addEEnumLiteral(scaleOfMeasurementEEnum, ScaleOfMeasurement.ORDINAL);
		addEEnumLiteral(scaleOfMeasurementEEnum, ScaleOfMeasurement.INTERVAL);
		addEEnumLiteral(scaleOfMeasurementEEnum, ScaleOfMeasurement.RATIO);
		addEEnumLiteral(scaleOfMeasurementEEnum, ScaleOfMeasurement.CUSTOM);

		initEEnum(binaryFunctorEEnum, BinaryFunctor.class, "BinaryFunctor");
		addEEnumLiteral(binaryFunctorEEnum, BinaryFunctor.PLUS);
		addEEnumLiteral(binaryFunctorEEnum, BinaryFunctor.MINUS);
		addEEnumLiteral(binaryFunctorEEnum, BinaryFunctor.MULTIPLY);
		addEEnumLiteral(binaryFunctorEEnum, BinaryFunctor.DIVIDE);
		addEEnumLiteral(binaryFunctorEEnum, BinaryFunctor.CUSTOM);

		initEEnum(measurementScaleEEnum, MeasurementScale.class, "MeasurementScale");
		addEEnumLiteral(measurementScaleEEnum, MeasurementScale.ORDINAL);
		addEEnumLiteral(measurementScaleEEnum, MeasurementScale.NOMINAL);
		addEEnumLiteral(measurementScaleEEnum, MeasurementScale.RATIO);
		addEEnumLiteral(measurementScaleEEnum, MeasurementScale.INTERVAL);

		// Initialize data types
		initEDataType(timeStampEDataType, Timestamp.class, "TimeStamp", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "uml", "../../org.eclipse.uml2.uml/model/UML.ecore#/"
		   });
	}

} //SmmPackageImpl
