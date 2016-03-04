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
package org.omg.smm.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.omg.smm.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.omg.smm.SmmPackage
 * @generated
 */
public class SmmSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SmmPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmmSwitch() {
		if (modelPackage == null) {
			modelPackage = SmmPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SmmPackage.ABSTRACT_MEASURE_ELEMENT: {
				AbstractMeasureElement abstractMeasureElement = (AbstractMeasureElement)theEObject;
				T result = caseAbstractMeasureElement(abstractMeasureElement);
				if (result == null) result = caseSmmElement(abstractMeasureElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.SMM_ELEMENT: {
				SmmElement smmElement = (SmmElement)theEObject;
				T result = caseSmmElement(smmElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.SMM_RELATIONSHIP: {
				SmmRelationship smmRelationship = (SmmRelationship)theEObject;
				T result = caseSmmRelationship(smmRelationship);
				if (result == null) result = caseSmmElement(smmRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.ATTRIBUTE: {
				Attribute attribute = (Attribute)theEObject;
				T result = caseAttribute(attribute);
				if (result == null) result = caseSmmElement(attribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.ANNOTATION: {
				Annotation annotation = (Annotation)theEObject;
				T result = caseAnnotation(annotation);
				if (result == null) result = caseSmmElement(annotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.ARGUMENT: {
				Argument argument = (Argument)theEObject;
				T result = caseArgument(argument);
				if (result == null) result = caseSmmElement(argument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.OBSERVED_MEASURE: {
				ObservedMeasure observedMeasure = (ObservedMeasure)theEObject;
				T result = caseObservedMeasure(observedMeasure);
				if (result == null) result = caseSmmElement(observedMeasure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.MEASUREMENT: {
				Measurement measurement = (Measurement)theEObject;
				T result = caseMeasurement(measurement);
				if (result == null) result = caseSmmElement(measurement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.EQUIVALENT_MEASUREMENT_RELATIONSHIP: {
				EquivalentMeasurementRelationship equivalentMeasurementRelationship = (EquivalentMeasurementRelationship)theEObject;
				T result = caseEquivalentMeasurementRelationship(equivalentMeasurementRelationship);
				if (result == null) result = caseMeasurementRelationship(equivalentMeasurementRelationship);
				if (result == null) result = caseSmmRelationship(equivalentMeasurementRelationship);
				if (result == null) result = caseSmmElement(equivalentMeasurementRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.MEASUREMENT_RELATIONSHIP: {
				MeasurementRelationship measurementRelationship = (MeasurementRelationship)theEObject;
				T result = caseMeasurementRelationship(measurementRelationship);
				if (result == null) result = caseSmmRelationship(measurementRelationship);
				if (result == null) result = caseSmmElement(measurementRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.REFINEMENT_MEASUREMENT_RELATIONSHIP: {
				RefinementMeasurementRelationship refinementMeasurementRelationship = (RefinementMeasurementRelationship)theEObject;
				T result = caseRefinementMeasurementRelationship(refinementMeasurementRelationship);
				if (result == null) result = caseMeasurementRelationship(refinementMeasurementRelationship);
				if (result == null) result = caseSmmRelationship(refinementMeasurementRelationship);
				if (result == null) result = caseSmmElement(refinementMeasurementRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.MEASURE: {
				Measure measure = (Measure)theEObject;
				T result = caseMeasure(measure);
				if (result == null) result = caseAbstractMeasureElement(measure);
				if (result == null) result = caseSmmElement(measure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.REFINEMENT_MEASURE_RELATIONSHIP: {
				RefinementMeasureRelationship refinementMeasureRelationship = (RefinementMeasureRelationship)theEObject;
				T result = caseRefinementMeasureRelationship(refinementMeasureRelationship);
				if (result == null) result = caseMeasureRelationship(refinementMeasureRelationship);
				if (result == null) result = caseSmmRelationship(refinementMeasureRelationship);
				if (result == null) result = caseSmmElement(refinementMeasureRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.MEASURE_RELATIONSHIP: {
				MeasureRelationship measureRelationship = (MeasureRelationship)theEObject;
				T result = caseMeasureRelationship(measureRelationship);
				if (result == null) result = caseSmmRelationship(measureRelationship);
				if (result == null) result = caseSmmElement(measureRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.OPERATION: {
				Operation operation = (Operation)theEObject;
				T result = caseOperation(operation);
				if (result == null) result = caseAbstractMeasureElement(operation);
				if (result == null) result = caseSmmElement(operation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.EQUIVALENT_MEASURE_RELATIONSHIP: {
				EquivalentMeasureRelationship equivalentMeasureRelationship = (EquivalentMeasureRelationship)theEObject;
				T result = caseEquivalentMeasureRelationship(equivalentMeasureRelationship);
				if (result == null) result = caseMeasureRelationship(equivalentMeasureRelationship);
				if (result == null) result = caseSmmRelationship(equivalentMeasureRelationship);
				if (result == null) result = caseSmmElement(equivalentMeasureRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.MEASURE_CATEGORY: {
				MeasureCategory measureCategory = (MeasureCategory)theEObject;
				T result = caseMeasureCategory(measureCategory);
				if (result == null) result = caseAbstractMeasureElement(measureCategory);
				if (result == null) result = caseSmmElement(measureCategory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.SCOPE: {
				Scope scope = (Scope)theEObject;
				T result = caseScope(scope);
				if (result == null) result = caseAbstractMeasureElement(scope);
				if (result == null) result = caseSmmElement(scope);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.CHARACTERISTIC: {
				Characteristic characteristic = (Characteristic)theEObject;
				T result = caseCharacteristic(characteristic);
				if (result == null) result = caseAbstractMeasureElement(characteristic);
				if (result == null) result = caseSmmElement(characteristic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.BASE1_MEASURE_RELATIONSHIP: {
				Base1MeasureRelationship base1MeasureRelationship = (Base1MeasureRelationship)theEObject;
				T result = caseBase1MeasureRelationship(base1MeasureRelationship);
				if (result == null) result = caseBaseMeasureRelationship(base1MeasureRelationship);
				if (result == null) result = caseMeasureRelationship(base1MeasureRelationship);
				if (result == null) result = caseSmmRelationship(base1MeasureRelationship);
				if (result == null) result = caseSmmElement(base1MeasureRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.BASE_MEASURE_RELATIONSHIP: {
				BaseMeasureRelationship baseMeasureRelationship = (BaseMeasureRelationship)theEObject;
				T result = caseBaseMeasureRelationship(baseMeasureRelationship);
				if (result == null) result = caseMeasureRelationship(baseMeasureRelationship);
				if (result == null) result = caseSmmRelationship(baseMeasureRelationship);
				if (result == null) result = caseSmmElement(baseMeasureRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.RESCALED_MEASURE: {
				RescaledMeasure rescaledMeasure = (RescaledMeasure)theEObject;
				T result = caseRescaledMeasure(rescaledMeasure);
				if (result == null) result = caseDimensionalMeasure(rescaledMeasure);
				if (result == null) result = caseMeasure(rescaledMeasure);
				if (result == null) result = caseAbstractMeasureElement(rescaledMeasure);
				if (result == null) result = caseSmmElement(rescaledMeasure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.DIMENSIONAL_MEASURE: {
				DimensionalMeasure dimensionalMeasure = (DimensionalMeasure)theEObject;
				T result = caseDimensionalMeasure(dimensionalMeasure);
				if (result == null) result = caseMeasure(dimensionalMeasure);
				if (result == null) result = caseAbstractMeasureElement(dimensionalMeasure);
				if (result == null) result = caseSmmElement(dimensionalMeasure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.BASE_NMEASURE_RELATIONSHIP: {
				BaseNMeasureRelationship baseNMeasureRelationship = (BaseNMeasureRelationship)theEObject;
				T result = caseBaseNMeasureRelationship(baseNMeasureRelationship);
				if (result == null) result = caseBaseMeasureRelationship(baseNMeasureRelationship);
				if (result == null) result = caseMeasureRelationship(baseNMeasureRelationship);
				if (result == null) result = caseSmmRelationship(baseNMeasureRelationship);
				if (result == null) result = caseSmmElement(baseNMeasureRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.COLLECTIVE_MEASURE: {
				CollectiveMeasure collectiveMeasure = (CollectiveMeasure)theEObject;
				T result = caseCollectiveMeasure(collectiveMeasure);
				if (result == null) result = caseDimensionalMeasure(collectiveMeasure);
				if (result == null) result = caseMeasure(collectiveMeasure);
				if (result == null) result = caseAbstractMeasureElement(collectiveMeasure);
				if (result == null) result = caseSmmElement(collectiveMeasure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.BASE2_MEASURE_RELATIONSHIP: {
				Base2MeasureRelationship base2MeasureRelationship = (Base2MeasureRelationship)theEObject;
				T result = caseBase2MeasureRelationship(base2MeasureRelationship);
				if (result == null) result = caseBaseMeasureRelationship(base2MeasureRelationship);
				if (result == null) result = caseMeasureRelationship(base2MeasureRelationship);
				if (result == null) result = caseSmmRelationship(base2MeasureRelationship);
				if (result == null) result = caseSmmElement(base2MeasureRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.BINARY_MEASURE: {
				BinaryMeasure binaryMeasure = (BinaryMeasure)theEObject;
				T result = caseBinaryMeasure(binaryMeasure);
				if (result == null) result = caseDimensionalMeasure(binaryMeasure);
				if (result == null) result = caseMeasure(binaryMeasure);
				if (result == null) result = caseAbstractMeasureElement(binaryMeasure);
				if (result == null) result = caseSmmElement(binaryMeasure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.RANKING_MEASURE_RELATIONSHIP: {
				RankingMeasureRelationship rankingMeasureRelationship = (RankingMeasureRelationship)theEObject;
				T result = caseRankingMeasureRelationship(rankingMeasureRelationship);
				if (result == null) result = caseBaseMeasureRelationship(rankingMeasureRelationship);
				if (result == null) result = caseMeasureRelationship(rankingMeasureRelationship);
				if (result == null) result = caseSmmRelationship(rankingMeasureRelationship);
				if (result == null) result = caseSmmElement(rankingMeasureRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.RANKING_MEASURE: {
				RankingMeasure rankingMeasure = (RankingMeasure)theEObject;
				T result = caseRankingMeasure(rankingMeasure);
				if (result == null) result = caseDimensionalMeasure(rankingMeasure);
				if (result == null) result = caseMeasure(rankingMeasure);
				if (result == null) result = caseAbstractMeasureElement(rankingMeasure);
				if (result == null) result = caseSmmElement(rankingMeasure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.RANKING_INTERVAL: {
				RankingInterval rankingInterval = (RankingInterval)theEObject;
				T result = caseRankingInterval(rankingInterval);
				if (result == null) result = caseInterval(rankingInterval);
				if (result == null) result = caseSmmElement(rankingInterval);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.INTERVAL: {
				Interval interval = (Interval)theEObject;
				T result = caseInterval(interval);
				if (result == null) result = caseSmmElement(interval);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.RESCALED_MEASURE_RELATIONSHIP: {
				RescaledMeasureRelationship rescaledMeasureRelationship = (RescaledMeasureRelationship)theEObject;
				T result = caseRescaledMeasureRelationship(rescaledMeasureRelationship);
				if (result == null) result = caseMeasureRelationship(rescaledMeasureRelationship);
				if (result == null) result = caseSmmRelationship(rescaledMeasureRelationship);
				if (result == null) result = caseSmmElement(rescaledMeasureRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.GRADE_MEASURE_RELATIONSHIP: {
				GradeMeasureRelationship gradeMeasureRelationship = (GradeMeasureRelationship)theEObject;
				T result = caseGradeMeasureRelationship(gradeMeasureRelationship);
				if (result == null) result = caseMeasureRelationship(gradeMeasureRelationship);
				if (result == null) result = caseSmmRelationship(gradeMeasureRelationship);
				if (result == null) result = caseSmmElement(gradeMeasureRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.GRADE_MEASURE: {
				GradeMeasure gradeMeasure = (GradeMeasure)theEObject;
				T result = caseGradeMeasure(gradeMeasure);
				if (result == null) result = caseMeasure(gradeMeasure);
				if (result == null) result = caseAbstractMeasureElement(gradeMeasure);
				if (result == null) result = caseSmmElement(gradeMeasure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.GRADE_INTERVAL: {
				GradeInterval gradeInterval = (GradeInterval)theEObject;
				T result = caseGradeInterval(gradeInterval);
				if (result == null) result = caseInterval(gradeInterval);
				if (result == null) result = caseSmmElement(gradeInterval);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.UNIT_OF_MEASURE: {
				UnitOfMeasure unitOfMeasure = (UnitOfMeasure)theEObject;
				T result = caseUnitOfMeasure(unitOfMeasure);
				if (result == null) result = caseAbstractMeasureElement(unitOfMeasure);
				if (result == null) result = caseSmmElement(unitOfMeasure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.BASE1_MEASUREMENT_RELATIONSHIP: {
				Base1MeasurementRelationship base1MeasurementRelationship = (Base1MeasurementRelationship)theEObject;
				T result = caseBase1MeasurementRelationship(base1MeasurementRelationship);
				if (result == null) result = caseBaseMeasurementRelationship(base1MeasurementRelationship);
				if (result == null) result = caseMeasurementRelationship(base1MeasurementRelationship);
				if (result == null) result = caseSmmRelationship(base1MeasurementRelationship);
				if (result == null) result = caseSmmElement(base1MeasurementRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.BASE_MEASUREMENT_RELATIONSHIP: {
				BaseMeasurementRelationship baseMeasurementRelationship = (BaseMeasurementRelationship)theEObject;
				T result = caseBaseMeasurementRelationship(baseMeasurementRelationship);
				if (result == null) result = caseMeasurementRelationship(baseMeasurementRelationship);
				if (result == null) result = caseSmmRelationship(baseMeasurementRelationship);
				if (result == null) result = caseSmmElement(baseMeasurementRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.DIMENSIONAL_MEASUREMENT: {
				DimensionalMeasurement dimensionalMeasurement = (DimensionalMeasurement)theEObject;
				T result = caseDimensionalMeasurement(dimensionalMeasurement);
				if (result == null) result = caseMeasurement(dimensionalMeasurement);
				if (result == null) result = caseSmmElement(dimensionalMeasurement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.BASE_NMEASUREMENT_RELATIONSHIP: {
				BaseNMeasurementRelationship baseNMeasurementRelationship = (BaseNMeasurementRelationship)theEObject;
				T result = caseBaseNMeasurementRelationship(baseNMeasurementRelationship);
				if (result == null) result = caseBaseMeasurementRelationship(baseNMeasurementRelationship);
				if (result == null) result = caseMeasurementRelationship(baseNMeasurementRelationship);
				if (result == null) result = caseSmmRelationship(baseNMeasurementRelationship);
				if (result == null) result = caseSmmElement(baseNMeasurementRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.COLLECTIVE_MEASUREMENT: {
				CollectiveMeasurement collectiveMeasurement = (CollectiveMeasurement)theEObject;
				T result = caseCollectiveMeasurement(collectiveMeasurement);
				if (result == null) result = caseDimensionalMeasurement(collectiveMeasurement);
				if (result == null) result = caseMeasurement(collectiveMeasurement);
				if (result == null) result = caseSmmElement(collectiveMeasurement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.BASE2_MEASUREMENT_RELATIONSHIP: {
				Base2MeasurementRelationship base2MeasurementRelationship = (Base2MeasurementRelationship)theEObject;
				T result = caseBase2MeasurementRelationship(base2MeasurementRelationship);
				if (result == null) result = caseBaseMeasurementRelationship(base2MeasurementRelationship);
				if (result == null) result = caseMeasurementRelationship(base2MeasurementRelationship);
				if (result == null) result = caseSmmRelationship(base2MeasurementRelationship);
				if (result == null) result = caseSmmElement(base2MeasurementRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.BINARY_MEASUREMENT: {
				BinaryMeasurement binaryMeasurement = (BinaryMeasurement)theEObject;
				T result = caseBinaryMeasurement(binaryMeasurement);
				if (result == null) result = caseDimensionalMeasurement(binaryMeasurement);
				if (result == null) result = caseMeasurement(binaryMeasurement);
				if (result == null) result = caseSmmElement(binaryMeasurement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.GRADE_MEASUREMENT_RELATIONSHIP: {
				GradeMeasurementRelationship gradeMeasurementRelationship = (GradeMeasurementRelationship)theEObject;
				T result = caseGradeMeasurementRelationship(gradeMeasurementRelationship);
				if (result == null) result = caseMeasurementRelationship(gradeMeasurementRelationship);
				if (result == null) result = caseSmmRelationship(gradeMeasurementRelationship);
				if (result == null) result = caseSmmElement(gradeMeasurementRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.GRADE_MEASUREMENT: {
				GradeMeasurement gradeMeasurement = (GradeMeasurement)theEObject;
				T result = caseGradeMeasurement(gradeMeasurement);
				if (result == null) result = caseMeasurement(gradeMeasurement);
				if (result == null) result = caseSmmElement(gradeMeasurement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.RESCALED_MEASUREMENT_RELATIONSHIP: {
				RescaledMeasurementRelationship rescaledMeasurementRelationship = (RescaledMeasurementRelationship)theEObject;
				T result = caseRescaledMeasurementRelationship(rescaledMeasurementRelationship);
				if (result == null) result = caseMeasurementRelationship(rescaledMeasurementRelationship);
				if (result == null) result = caseSmmRelationship(rescaledMeasurementRelationship);
				if (result == null) result = caseSmmElement(rescaledMeasurementRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.RESCALED_MEASUREMENT: {
				RescaledMeasurement rescaledMeasurement = (RescaledMeasurement)theEObject;
				T result = caseRescaledMeasurement(rescaledMeasurement);
				if (result == null) result = caseDimensionalMeasurement(rescaledMeasurement);
				if (result == null) result = caseMeasurement(rescaledMeasurement);
				if (result == null) result = caseSmmElement(rescaledMeasurement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.RANKING_MEASUREMENT_RELATIONSHIP: {
				RankingMeasurementRelationship rankingMeasurementRelationship = (RankingMeasurementRelationship)theEObject;
				T result = caseRankingMeasurementRelationship(rankingMeasurementRelationship);
				if (result == null) result = caseMeasurementRelationship(rankingMeasurementRelationship);
				if (result == null) result = caseSmmRelationship(rankingMeasurementRelationship);
				if (result == null) result = caseSmmElement(rankingMeasurementRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.RANKING_MEASUREMENT: {
				RankingMeasurement rankingMeasurement = (RankingMeasurement)theEObject;
				T result = caseRankingMeasurement(rankingMeasurement);
				if (result == null) result = caseDimensionalMeasurement(rankingMeasurement);
				if (result == null) result = caseMeasurement(rankingMeasurement);
				if (result == null) result = caseSmmElement(rankingMeasurement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.CATEGORY_RELATIONSHIP: {
				CategoryRelationship categoryRelationship = (CategoryRelationship)theEObject;
				T result = caseCategoryRelationship(categoryRelationship);
				if (result == null) result = caseSmmRelationship(categoryRelationship);
				if (result == null) result = caseSmmElement(categoryRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.COUNTING_MEASUREMENT: {
				CountingMeasurement countingMeasurement = (CountingMeasurement)theEObject;
				T result = caseCountingMeasurement(countingMeasurement);
				if (result == null) result = caseDirectMeasurement(countingMeasurement);
				if (result == null) result = caseDimensionalMeasurement(countingMeasurement);
				if (result == null) result = caseMeasurement(countingMeasurement);
				if (result == null) result = caseSmmElement(countingMeasurement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.DIRECT_MEASUREMENT: {
				DirectMeasurement directMeasurement = (DirectMeasurement)theEObject;
				T result = caseDirectMeasurement(directMeasurement);
				if (result == null) result = caseDimensionalMeasurement(directMeasurement);
				if (result == null) result = caseMeasurement(directMeasurement);
				if (result == null) result = caseSmmElement(directMeasurement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.COUNTING_MEASURE: {
				CountingMeasure countingMeasure = (CountingMeasure)theEObject;
				T result = caseCountingMeasure(countingMeasure);
				if (result == null) result = caseDirectMeasure(countingMeasure);
				if (result == null) result = caseDimensionalMeasure(countingMeasure);
				if (result == null) result = caseMeasure(countingMeasure);
				if (result == null) result = caseAbstractMeasureElement(countingMeasure);
				if (result == null) result = caseSmmElement(countingMeasure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.DIRECT_MEASURE: {
				DirectMeasure directMeasure = (DirectMeasure)theEObject;
				T result = caseDirectMeasure(directMeasure);
				if (result == null) result = caseDimensionalMeasure(directMeasure);
				if (result == null) result = caseMeasure(directMeasure);
				if (result == null) result = caseAbstractMeasureElement(directMeasure);
				if (result == null) result = caseSmmElement(directMeasure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.MEASURE_LIBRARY: {
				MeasureLibrary measureLibrary = (MeasureLibrary)theEObject;
				T result = caseMeasureLibrary(measureLibrary);
				if (result == null) result = caseSmmElement(measureLibrary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.NAMED_MEASURE: {
				NamedMeasure namedMeasure = (NamedMeasure)theEObject;
				T result = caseNamedMeasure(namedMeasure);
				if (result == null) result = caseDimensionalMeasure(namedMeasure);
				if (result == null) result = caseMeasure(namedMeasure);
				if (result == null) result = caseAbstractMeasureElement(namedMeasure);
				if (result == null) result = caseSmmElement(namedMeasure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.NAMED_MEASUREMENT: {
				NamedMeasurement namedMeasurement = (NamedMeasurement)theEObject;
				T result = caseNamedMeasurement(namedMeasurement);
				if (result == null) result = caseDimensionalMeasurement(namedMeasurement);
				if (result == null) result = caseMeasurement(namedMeasurement);
				if (result == null) result = caseSmmElement(namedMeasurement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.OCL_OPERATION: {
				OCLOperation oclOperation = (OCLOperation)theEObject;
				T result = caseOCLOperation(oclOperation);
				if (result == null) result = caseAbstractMeasureElement(oclOperation);
				if (result == null) result = caseSmmElement(oclOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.OBSERVATION: {
				Observation observation = (Observation)theEObject;
				T result = caseObservation(observation);
				if (result == null) result = caseSmmElement(observation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.OBSERVATION_SCOPE: {
				ObservationScope observationScope = (ObservationScope)theEObject;
				T result = caseObservationScope(observationScope);
				if (result == null) result = caseSmmElement(observationScope);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.RATIO_MEASURE: {
				RatioMeasure ratioMeasure = (RatioMeasure)theEObject;
				T result = caseRatioMeasure(ratioMeasure);
				if (result == null) result = caseBinaryMeasure(ratioMeasure);
				if (result == null) result = caseDimensionalMeasure(ratioMeasure);
				if (result == null) result = caseMeasure(ratioMeasure);
				if (result == null) result = caseAbstractMeasureElement(ratioMeasure);
				if (result == null) result = caseSmmElement(ratioMeasure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.RATIO_MEASUREMENT: {
				RatioMeasurement ratioMeasurement = (RatioMeasurement)theEObject;
				T result = caseRatioMeasurement(ratioMeasurement);
				if (result == null) result = caseBinaryMeasurement(ratioMeasurement);
				if (result == null) result = caseDimensionalMeasurement(ratioMeasurement);
				if (result == null) result = caseMeasurement(ratioMeasurement);
				if (result == null) result = caseSmmElement(ratioMeasurement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SmmPackage.SMM_MODEL: {
				SmmModel smmModel = (SmmModel)theEObject;
				T result = caseSmmModel(smmModel);
				if (result == null) result = caseSmmElement(smmModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Measure Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Measure Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractMeasureElement(AbstractMeasureElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSmmElement(SmmElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSmmRelationship(SmmRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttribute(Attribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotation(Annotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Argument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Argument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArgument(Argument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Observed Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Observed Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObservedMeasure(ObservedMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measurement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasurement(Measurement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equivalent Measurement Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equivalent Measurement Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEquivalentMeasurementRelationship(EquivalentMeasurementRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measurement Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measurement Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasurementRelationship(MeasurementRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Refinement Measurement Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Refinement Measurement Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRefinementMeasurementRelationship(RefinementMeasurementRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasure(Measure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Refinement Measure Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Refinement Measure Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRefinementMeasureRelationship(RefinementMeasureRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measure Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measure Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasureRelationship(MeasureRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperation(Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equivalent Measure Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equivalent Measure Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEquivalentMeasureRelationship(EquivalentMeasureRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measure Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measure Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasureCategory(MeasureCategory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scope</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scope</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScope(Scope object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Characteristic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCharacteristic(Characteristic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base1 Measure Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base1 Measure Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBase1MeasureRelationship(Base1MeasureRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Measure Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Measure Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseMeasureRelationship(BaseMeasureRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rescaled Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rescaled Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRescaledMeasure(RescaledMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dimensional Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dimensional Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDimensionalMeasure(DimensionalMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base NMeasure Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base NMeasure Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseNMeasureRelationship(BaseNMeasureRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collective Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collective Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectiveMeasure(CollectiveMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base2 Measure Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base2 Measure Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBase2MeasureRelationship(Base2MeasureRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryMeasure(BinaryMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ranking Measure Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ranking Measure Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRankingMeasureRelationship(RankingMeasureRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ranking Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ranking Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRankingMeasure(RankingMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ranking Interval</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ranking Interval</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRankingInterval(RankingInterval object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interval</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interval</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterval(Interval object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rescaled Measure Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rescaled Measure Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRescaledMeasureRelationship(RescaledMeasureRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grade Measure Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grade Measure Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGradeMeasureRelationship(GradeMeasureRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grade Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grade Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGradeMeasure(GradeMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grade Interval</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grade Interval</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGradeInterval(GradeInterval object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Of Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Of Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitOfMeasure(UnitOfMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base1 Measurement Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base1 Measurement Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBase1MeasurementRelationship(Base1MeasurementRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Measurement Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Measurement Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseMeasurementRelationship(BaseMeasurementRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dimensional Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dimensional Measurement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDimensionalMeasurement(DimensionalMeasurement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base NMeasurement Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base NMeasurement Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseNMeasurementRelationship(BaseNMeasurementRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collective Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collective Measurement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectiveMeasurement(CollectiveMeasurement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base2 Measurement Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base2 Measurement Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBase2MeasurementRelationship(Base2MeasurementRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Measurement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryMeasurement(BinaryMeasurement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grade Measurement Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grade Measurement Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGradeMeasurementRelationship(GradeMeasurementRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grade Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grade Measurement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGradeMeasurement(GradeMeasurement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rescaled Measurement Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rescaled Measurement Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRescaledMeasurementRelationship(RescaledMeasurementRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rescaled Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rescaled Measurement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRescaledMeasurement(RescaledMeasurement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ranking Measurement Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ranking Measurement Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRankingMeasurementRelationship(RankingMeasurementRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ranking Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ranking Measurement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRankingMeasurement(RankingMeasurement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Category Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Category Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCategoryRelationship(CategoryRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Counting Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Counting Measurement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCountingMeasurement(CountingMeasurement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Direct Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Direct Measurement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirectMeasurement(DirectMeasurement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Counting Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Counting Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCountingMeasure(CountingMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Direct Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Direct Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirectMeasure(DirectMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measure Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measure Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasureLibrary(MeasureLibrary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedMeasure(NamedMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Measurement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedMeasurement(NamedMeasurement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLOperation(OCLOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Observation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Observation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObservation(Observation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Observation Scope</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Observation Scope</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObservationScope(ObservationScope object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ratio Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ratio Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRatioMeasure(RatioMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ratio Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ratio Measurement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRatioMeasurement(RatioMeasurement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSmmModel(SmmModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SmmSwitch
