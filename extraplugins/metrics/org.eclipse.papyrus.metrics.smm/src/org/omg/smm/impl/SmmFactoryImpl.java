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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.omg.smm.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SmmFactoryImpl extends EFactoryImpl implements SmmFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SmmFactory init() {
		try {
			SmmFactory theSmmFactory = (SmmFactory)EPackage.Registry.INSTANCE.getEFactory(SmmPackage.eNS_URI);
			if (theSmmFactory != null) {
				return theSmmFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SmmFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmmFactoryImpl() {
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
			case SmmPackage.ATTRIBUTE: return createAttribute();
			case SmmPackage.ANNOTATION: return createAnnotation();
			case SmmPackage.ARGUMENT: return createArgument();
			case SmmPackage.OBSERVED_MEASURE: return createObservedMeasure();
			case SmmPackage.EQUIVALENT_MEASUREMENT_RELATIONSHIP: return createEquivalentMeasurementRelationship();
			case SmmPackage.REFINEMENT_MEASUREMENT_RELATIONSHIP: return createRefinementMeasurementRelationship();
			case SmmPackage.REFINEMENT_MEASURE_RELATIONSHIP: return createRefinementMeasureRelationship();
			case SmmPackage.OPERATION: return createOperation();
			case SmmPackage.EQUIVALENT_MEASURE_RELATIONSHIP: return createEquivalentMeasureRelationship();
			case SmmPackage.MEASURE_CATEGORY: return createMeasureCategory();
			case SmmPackage.SCOPE: return createScope();
			case SmmPackage.CHARACTERISTIC: return createCharacteristic();
			case SmmPackage.BASE1_MEASURE_RELATIONSHIP: return createBase1MeasureRelationship();
			case SmmPackage.RESCALED_MEASURE: return createRescaledMeasure();
			case SmmPackage.BASE_NMEASURE_RELATIONSHIP: return createBaseNMeasureRelationship();
			case SmmPackage.COLLECTIVE_MEASURE: return createCollectiveMeasure();
			case SmmPackage.BASE2_MEASURE_RELATIONSHIP: return createBase2MeasureRelationship();
			case SmmPackage.BINARY_MEASURE: return createBinaryMeasure();
			case SmmPackage.RANKING_MEASURE_RELATIONSHIP: return createRankingMeasureRelationship();
			case SmmPackage.RANKING_MEASURE: return createRankingMeasure();
			case SmmPackage.RANKING_INTERVAL: return createRankingInterval();
			case SmmPackage.RESCALED_MEASURE_RELATIONSHIP: return createRescaledMeasureRelationship();
			case SmmPackage.GRADE_MEASURE_RELATIONSHIP: return createGradeMeasureRelationship();
			case SmmPackage.GRADE_MEASURE: return createGradeMeasure();
			case SmmPackage.GRADE_INTERVAL: return createGradeInterval();
			case SmmPackage.UNIT_OF_MEASURE: return createUnitOfMeasure();
			case SmmPackage.BASE1_MEASUREMENT_RELATIONSHIP: return createBase1MeasurementRelationship();
			case SmmPackage.BASE_NMEASUREMENT_RELATIONSHIP: return createBaseNMeasurementRelationship();
			case SmmPackage.COLLECTIVE_MEASUREMENT: return createCollectiveMeasurement();
			case SmmPackage.BASE2_MEASUREMENT_RELATIONSHIP: return createBase2MeasurementRelationship();
			case SmmPackage.BINARY_MEASUREMENT: return createBinaryMeasurement();
			case SmmPackage.GRADE_MEASUREMENT_RELATIONSHIP: return createGradeMeasurementRelationship();
			case SmmPackage.GRADE_MEASUREMENT: return createGradeMeasurement();
			case SmmPackage.RESCALED_MEASUREMENT_RELATIONSHIP: return createRescaledMeasurementRelationship();
			case SmmPackage.RESCALED_MEASUREMENT: return createRescaledMeasurement();
			case SmmPackage.RANKING_MEASUREMENT_RELATIONSHIP: return createRankingMeasurementRelationship();
			case SmmPackage.RANKING_MEASUREMENT: return createRankingMeasurement();
			case SmmPackage.CATEGORY_RELATIONSHIP: return createCategoryRelationship();
			case SmmPackage.COUNTING_MEASUREMENT: return createCountingMeasurement();
			case SmmPackage.DIRECT_MEASUREMENT: return createDirectMeasurement();
			case SmmPackage.COUNTING_MEASURE: return createCountingMeasure();
			case SmmPackage.DIRECT_MEASURE: return createDirectMeasure();
			case SmmPackage.MEASURE_LIBRARY: return createMeasureLibrary();
			case SmmPackage.NAMED_MEASURE: return createNamedMeasure();
			case SmmPackage.NAMED_MEASUREMENT: return createNamedMeasurement();
			case SmmPackage.OCL_OPERATION: return createOCLOperation();
			case SmmPackage.OBSERVATION: return createObservation();
			case SmmPackage.OBSERVATION_SCOPE: return createObservationScope();
			case SmmPackage.RATIO_MEASURE: return createRatioMeasure();
			case SmmPackage.RATIO_MEASUREMENT: return createRatioMeasurement();
			case SmmPackage.SMM_MODEL: return createSmmModel();
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
			case SmmPackage.ACCUMULATOR:
				return createAccumulatorFromString(eDataType, initialValue);
			case SmmPackage.INFLUENCE:
				return createInfluenceFromString(eDataType, initialValue);
			case SmmPackage.SCALE_OF_MEASUREMENT:
				return createScaleOfMeasurementFromString(eDataType, initialValue);
			case SmmPackage.BINARY_FUNCTOR:
				return createBinaryFunctorFromString(eDataType, initialValue);
			case SmmPackage.MEASUREMENT_SCALE:
				return createMeasurementScaleFromString(eDataType, initialValue);
			case SmmPackage.TIME_STAMP:
				return createTimeStampFromString(eDataType, initialValue);
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
			case SmmPackage.ACCUMULATOR:
				return convertAccumulatorToString(eDataType, instanceValue);
			case SmmPackage.INFLUENCE:
				return convertInfluenceToString(eDataType, instanceValue);
			case SmmPackage.SCALE_OF_MEASUREMENT:
				return convertScaleOfMeasurementToString(eDataType, instanceValue);
			case SmmPackage.BINARY_FUNCTOR:
				return convertBinaryFunctorToString(eDataType, instanceValue);
			case SmmPackage.MEASUREMENT_SCALE:
				return convertMeasurementScaleToString(eDataType, instanceValue);
			case SmmPackage.TIME_STAMP:
				return convertTimeStampToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation createAnnotation() {
		AnnotationImpl annotation = new AnnotationImpl();
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Argument createArgument() {
		ArgumentImpl argument = new ArgumentImpl();
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObservedMeasure createObservedMeasure() {
		ObservedMeasureImpl observedMeasure = new ObservedMeasureImpl();
		return observedMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquivalentMeasurementRelationship createEquivalentMeasurementRelationship() {
		EquivalentMeasurementRelationshipImpl equivalentMeasurementRelationship = new EquivalentMeasurementRelationshipImpl();
		return equivalentMeasurementRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefinementMeasurementRelationship createRefinementMeasurementRelationship() {
		RefinementMeasurementRelationshipImpl refinementMeasurementRelationship = new RefinementMeasurementRelationshipImpl();
		return refinementMeasurementRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefinementMeasureRelationship createRefinementMeasureRelationship() {
		RefinementMeasureRelationshipImpl refinementMeasureRelationship = new RefinementMeasureRelationshipImpl();
		return refinementMeasureRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquivalentMeasureRelationship createEquivalentMeasureRelationship() {
		EquivalentMeasureRelationshipImpl equivalentMeasureRelationship = new EquivalentMeasureRelationshipImpl();
		return equivalentMeasureRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasureCategory createMeasureCategory() {
		MeasureCategoryImpl measureCategory = new MeasureCategoryImpl();
		return measureCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scope createScope() {
		ScopeImpl scope = new ScopeImpl();
		return scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Characteristic createCharacteristic() {
		CharacteristicImpl characteristic = new CharacteristicImpl();
		return characteristic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Base1MeasureRelationship createBase1MeasureRelationship() {
		Base1MeasureRelationshipImpl base1MeasureRelationship = new Base1MeasureRelationshipImpl();
		return base1MeasureRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RescaledMeasure createRescaledMeasure() {
		RescaledMeasureImpl rescaledMeasure = new RescaledMeasureImpl();
		return rescaledMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseNMeasureRelationship createBaseNMeasureRelationship() {
		BaseNMeasureRelationshipImpl baseNMeasureRelationship = new BaseNMeasureRelationshipImpl();
		return baseNMeasureRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectiveMeasure createCollectiveMeasure() {
		CollectiveMeasureImpl collectiveMeasure = new CollectiveMeasureImpl();
		return collectiveMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Base2MeasureRelationship createBase2MeasureRelationship() {
		Base2MeasureRelationshipImpl base2MeasureRelationship = new Base2MeasureRelationshipImpl();
		return base2MeasureRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryMeasure createBinaryMeasure() {
		BinaryMeasureImpl binaryMeasure = new BinaryMeasureImpl();
		return binaryMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RankingMeasureRelationship createRankingMeasureRelationship() {
		RankingMeasureRelationshipImpl rankingMeasureRelationship = new RankingMeasureRelationshipImpl();
		return rankingMeasureRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RankingMeasure createRankingMeasure() {
		RankingMeasureImpl rankingMeasure = new RankingMeasureImpl();
		return rankingMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RankingInterval createRankingInterval() {
		RankingIntervalImpl rankingInterval = new RankingIntervalImpl();
		return rankingInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RescaledMeasureRelationship createRescaledMeasureRelationship() {
		RescaledMeasureRelationshipImpl rescaledMeasureRelationship = new RescaledMeasureRelationshipImpl();
		return rescaledMeasureRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GradeMeasureRelationship createGradeMeasureRelationship() {
		GradeMeasureRelationshipImpl gradeMeasureRelationship = new GradeMeasureRelationshipImpl();
		return gradeMeasureRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GradeMeasure createGradeMeasure() {
		GradeMeasureImpl gradeMeasure = new GradeMeasureImpl();
		return gradeMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GradeInterval createGradeInterval() {
		GradeIntervalImpl gradeInterval = new GradeIntervalImpl();
		return gradeInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitOfMeasure createUnitOfMeasure() {
		UnitOfMeasureImpl unitOfMeasure = new UnitOfMeasureImpl();
		return unitOfMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Base1MeasurementRelationship createBase1MeasurementRelationship() {
		Base1MeasurementRelationshipImpl base1MeasurementRelationship = new Base1MeasurementRelationshipImpl();
		return base1MeasurementRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseNMeasurementRelationship createBaseNMeasurementRelationship() {
		BaseNMeasurementRelationshipImpl baseNMeasurementRelationship = new BaseNMeasurementRelationshipImpl();
		return baseNMeasurementRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectiveMeasurement createCollectiveMeasurement() {
		CollectiveMeasurementImpl collectiveMeasurement = new CollectiveMeasurementImpl();
		return collectiveMeasurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Base2MeasurementRelationship createBase2MeasurementRelationship() {
		Base2MeasurementRelationshipImpl base2MeasurementRelationship = new Base2MeasurementRelationshipImpl();
		return base2MeasurementRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryMeasurement createBinaryMeasurement() {
		BinaryMeasurementImpl binaryMeasurement = new BinaryMeasurementImpl();
		return binaryMeasurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GradeMeasurementRelationship createGradeMeasurementRelationship() {
		GradeMeasurementRelationshipImpl gradeMeasurementRelationship = new GradeMeasurementRelationshipImpl();
		return gradeMeasurementRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GradeMeasurement createGradeMeasurement() {
		GradeMeasurementImpl gradeMeasurement = new GradeMeasurementImpl();
		return gradeMeasurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RescaledMeasurementRelationship createRescaledMeasurementRelationship() {
		RescaledMeasurementRelationshipImpl rescaledMeasurementRelationship = new RescaledMeasurementRelationshipImpl();
		return rescaledMeasurementRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RescaledMeasurement createRescaledMeasurement() {
		RescaledMeasurementImpl rescaledMeasurement = new RescaledMeasurementImpl();
		return rescaledMeasurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RankingMeasurementRelationship createRankingMeasurementRelationship() {
		RankingMeasurementRelationshipImpl rankingMeasurementRelationship = new RankingMeasurementRelationshipImpl();
		return rankingMeasurementRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RankingMeasurement createRankingMeasurement() {
		RankingMeasurementImpl rankingMeasurement = new RankingMeasurementImpl();
		return rankingMeasurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CategoryRelationship createCategoryRelationship() {
		CategoryRelationshipImpl categoryRelationship = new CategoryRelationshipImpl();
		return categoryRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CountingMeasurement createCountingMeasurement() {
		CountingMeasurementImpl countingMeasurement = new CountingMeasurementImpl();
		return countingMeasurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectMeasurement createDirectMeasurement() {
		DirectMeasurementImpl directMeasurement = new DirectMeasurementImpl();
		return directMeasurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CountingMeasure createCountingMeasure() {
		CountingMeasureImpl countingMeasure = new CountingMeasureImpl();
		return countingMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectMeasure createDirectMeasure() {
		DirectMeasureImpl directMeasure = new DirectMeasureImpl();
		return directMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasureLibrary createMeasureLibrary() {
		MeasureLibraryImpl measureLibrary = new MeasureLibraryImpl();
		return measureLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedMeasure createNamedMeasure() {
		NamedMeasureImpl namedMeasure = new NamedMeasureImpl();
		return namedMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedMeasurement createNamedMeasurement() {
		NamedMeasurementImpl namedMeasurement = new NamedMeasurementImpl();
		return namedMeasurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLOperation createOCLOperation() {
		OCLOperationImpl oclOperation = new OCLOperationImpl();
		return oclOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Observation createObservation() {
		ObservationImpl observation = new ObservationImpl();
		return observation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObservationScope createObservationScope() {
		ObservationScopeImpl observationScope = new ObservationScopeImpl();
		return observationScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RatioMeasure createRatioMeasure() {
		RatioMeasureImpl ratioMeasure = new RatioMeasureImpl();
		return ratioMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RatioMeasurement createRatioMeasurement() {
		RatioMeasurementImpl ratioMeasurement = new RatioMeasurementImpl();
		return ratioMeasurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmmModel createSmmModel() {
		SmmModelImpl smmModel = new SmmModelImpl();
		return smmModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Accumulator createAccumulatorFromString(EDataType eDataType, String initialValue) {
		Accumulator result = Accumulator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAccumulatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Influence createInfluenceFromString(EDataType eDataType, String initialValue) {
		Influence result = Influence.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInfluenceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaleOfMeasurement createScaleOfMeasurementFromString(EDataType eDataType, String initialValue) {
		ScaleOfMeasurement result = ScaleOfMeasurement.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertScaleOfMeasurementToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryFunctor createBinaryFunctorFromString(EDataType eDataType, String initialValue) {
		BinaryFunctor result = BinaryFunctor.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBinaryFunctorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementScale createMeasurementScaleFromString(EDataType eDataType, String initialValue) {
		MeasurementScale result = MeasurementScale.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMeasurementScaleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Timestamp createTimeStampFromString(EDataType eDataType, String initialValue) {
		return (Timestamp)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTimeStampToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmmPackage getSmmPackage() {
		return (SmmPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SmmPackage getPackage() {
		return SmmPackage.eINSTANCE;
	}

} //SmmFactoryImpl
