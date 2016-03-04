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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.omg.smm.SmmPackage
 * @generated
 */
public interface SmmFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SmmFactory eINSTANCE = org.omg.smm.impl.SmmFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute</em>'.
	 * @generated
	 */
	Attribute createAttribute();

	/**
	 * Returns a new object of class '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation</em>'.
	 * @generated
	 */
	Annotation createAnnotation();

	/**
	 * Returns a new object of class '<em>Argument</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Argument</em>'.
	 * @generated
	 */
	Argument createArgument();

	/**
	 * Returns a new object of class '<em>Observed Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Observed Measure</em>'.
	 * @generated
	 */
	ObservedMeasure createObservedMeasure();

	/**
	 * Returns a new object of class '<em>Equivalent Measurement Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equivalent Measurement Relationship</em>'.
	 * @generated
	 */
	EquivalentMeasurementRelationship createEquivalentMeasurementRelationship();

	/**
	 * Returns a new object of class '<em>Refinement Measurement Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Refinement Measurement Relationship</em>'.
	 * @generated
	 */
	RefinementMeasurementRelationship createRefinementMeasurementRelationship();

	/**
	 * Returns a new object of class '<em>Refinement Measure Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Refinement Measure Relationship</em>'.
	 * @generated
	 */
	RefinementMeasureRelationship createRefinementMeasureRelationship();

	/**
	 * Returns a new object of class '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation</em>'.
	 * @generated
	 */
	Operation createOperation();

	/**
	 * Returns a new object of class '<em>Equivalent Measure Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equivalent Measure Relationship</em>'.
	 * @generated
	 */
	EquivalentMeasureRelationship createEquivalentMeasureRelationship();

	/**
	 * Returns a new object of class '<em>Measure Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Measure Category</em>'.
	 * @generated
	 */
	MeasureCategory createMeasureCategory();

	/**
	 * Returns a new object of class '<em>Scope</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scope</em>'.
	 * @generated
	 */
	Scope createScope();

	/**
	 * Returns a new object of class '<em>Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Characteristic</em>'.
	 * @generated
	 */
	Characteristic createCharacteristic();

	/**
	 * Returns a new object of class '<em>Base1 Measure Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base1 Measure Relationship</em>'.
	 * @generated
	 */
	Base1MeasureRelationship createBase1MeasureRelationship();

	/**
	 * Returns a new object of class '<em>Rescaled Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rescaled Measure</em>'.
	 * @generated
	 */
	RescaledMeasure createRescaledMeasure();

	/**
	 * Returns a new object of class '<em>Base NMeasure Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base NMeasure Relationship</em>'.
	 * @generated
	 */
	BaseNMeasureRelationship createBaseNMeasureRelationship();

	/**
	 * Returns a new object of class '<em>Collective Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collective Measure</em>'.
	 * @generated
	 */
	CollectiveMeasure createCollectiveMeasure();

	/**
	 * Returns a new object of class '<em>Base2 Measure Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base2 Measure Relationship</em>'.
	 * @generated
	 */
	Base2MeasureRelationship createBase2MeasureRelationship();

	/**
	 * Returns a new object of class '<em>Binary Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binary Measure</em>'.
	 * @generated
	 */
	BinaryMeasure createBinaryMeasure();

	/**
	 * Returns a new object of class '<em>Ranking Measure Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ranking Measure Relationship</em>'.
	 * @generated
	 */
	RankingMeasureRelationship createRankingMeasureRelationship();

	/**
	 * Returns a new object of class '<em>Ranking Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ranking Measure</em>'.
	 * @generated
	 */
	RankingMeasure createRankingMeasure();

	/**
	 * Returns a new object of class '<em>Ranking Interval</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ranking Interval</em>'.
	 * @generated
	 */
	RankingInterval createRankingInterval();

	/**
	 * Returns a new object of class '<em>Rescaled Measure Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rescaled Measure Relationship</em>'.
	 * @generated
	 */
	RescaledMeasureRelationship createRescaledMeasureRelationship();

	/**
	 * Returns a new object of class '<em>Grade Measure Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grade Measure Relationship</em>'.
	 * @generated
	 */
	GradeMeasureRelationship createGradeMeasureRelationship();

	/**
	 * Returns a new object of class '<em>Grade Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grade Measure</em>'.
	 * @generated
	 */
	GradeMeasure createGradeMeasure();

	/**
	 * Returns a new object of class '<em>Grade Interval</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grade Interval</em>'.
	 * @generated
	 */
	GradeInterval createGradeInterval();

	/**
	 * Returns a new object of class '<em>Unit Of Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit Of Measure</em>'.
	 * @generated
	 */
	UnitOfMeasure createUnitOfMeasure();

	/**
	 * Returns a new object of class '<em>Base1 Measurement Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base1 Measurement Relationship</em>'.
	 * @generated
	 */
	Base1MeasurementRelationship createBase1MeasurementRelationship();

	/**
	 * Returns a new object of class '<em>Base NMeasurement Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base NMeasurement Relationship</em>'.
	 * @generated
	 */
	BaseNMeasurementRelationship createBaseNMeasurementRelationship();

	/**
	 * Returns a new object of class '<em>Collective Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collective Measurement</em>'.
	 * @generated
	 */
	CollectiveMeasurement createCollectiveMeasurement();

	/**
	 * Returns a new object of class '<em>Base2 Measurement Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base2 Measurement Relationship</em>'.
	 * @generated
	 */
	Base2MeasurementRelationship createBase2MeasurementRelationship();

	/**
	 * Returns a new object of class '<em>Binary Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binary Measurement</em>'.
	 * @generated
	 */
	BinaryMeasurement createBinaryMeasurement();

	/**
	 * Returns a new object of class '<em>Grade Measurement Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grade Measurement Relationship</em>'.
	 * @generated
	 */
	GradeMeasurementRelationship createGradeMeasurementRelationship();

	/**
	 * Returns a new object of class '<em>Grade Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grade Measurement</em>'.
	 * @generated
	 */
	GradeMeasurement createGradeMeasurement();

	/**
	 * Returns a new object of class '<em>Rescaled Measurement Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rescaled Measurement Relationship</em>'.
	 * @generated
	 */
	RescaledMeasurementRelationship createRescaledMeasurementRelationship();

	/**
	 * Returns a new object of class '<em>Rescaled Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rescaled Measurement</em>'.
	 * @generated
	 */
	RescaledMeasurement createRescaledMeasurement();

	/**
	 * Returns a new object of class '<em>Ranking Measurement Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ranking Measurement Relationship</em>'.
	 * @generated
	 */
	RankingMeasurementRelationship createRankingMeasurementRelationship();

	/**
	 * Returns a new object of class '<em>Ranking Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ranking Measurement</em>'.
	 * @generated
	 */
	RankingMeasurement createRankingMeasurement();

	/**
	 * Returns a new object of class '<em>Category Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Category Relationship</em>'.
	 * @generated
	 */
	CategoryRelationship createCategoryRelationship();

	/**
	 * Returns a new object of class '<em>Counting Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Counting Measurement</em>'.
	 * @generated
	 */
	CountingMeasurement createCountingMeasurement();

	/**
	 * Returns a new object of class '<em>Direct Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Direct Measurement</em>'.
	 * @generated
	 */
	DirectMeasurement createDirectMeasurement();

	/**
	 * Returns a new object of class '<em>Counting Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Counting Measure</em>'.
	 * @generated
	 */
	CountingMeasure createCountingMeasure();

	/**
	 * Returns a new object of class '<em>Direct Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Direct Measure</em>'.
	 * @generated
	 */
	DirectMeasure createDirectMeasure();

	/**
	 * Returns a new object of class '<em>Measure Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Measure Library</em>'.
	 * @generated
	 */
	MeasureLibrary createMeasureLibrary();

	/**
	 * Returns a new object of class '<em>Named Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Measure</em>'.
	 * @generated
	 */
	NamedMeasure createNamedMeasure();

	/**
	 * Returns a new object of class '<em>Named Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Measurement</em>'.
	 * @generated
	 */
	NamedMeasurement createNamedMeasurement();

	/**
	 * Returns a new object of class '<em>OCL Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OCL Operation</em>'.
	 * @generated
	 */
	OCLOperation createOCLOperation();

	/**
	 * Returns a new object of class '<em>Observation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Observation</em>'.
	 * @generated
	 */
	Observation createObservation();

	/**
	 * Returns a new object of class '<em>Observation Scope</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Observation Scope</em>'.
	 * @generated
	 */
	ObservationScope createObservationScope();

	/**
	 * Returns a new object of class '<em>Ratio Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ratio Measure</em>'.
	 * @generated
	 */
	RatioMeasure createRatioMeasure();

	/**
	 * Returns a new object of class '<em>Ratio Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ratio Measurement</em>'.
	 * @generated
	 */
	RatioMeasurement createRatioMeasurement();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	SmmModel createSmmModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SmmPackage getSmmPackage();

} //SmmFactory
