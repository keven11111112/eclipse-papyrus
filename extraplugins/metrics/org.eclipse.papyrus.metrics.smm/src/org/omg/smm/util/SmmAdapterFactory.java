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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.omg.smm.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.omg.smm.SmmPackage
 * @generated
 */
public class SmmAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SmmPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmmAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SmmPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SmmSwitch<Adapter> modelSwitch =
		new SmmSwitch<Adapter>() {
			@Override
			public Adapter caseAbstractMeasureElement(AbstractMeasureElement object) {
				return createAbstractMeasureElementAdapter();
			}
			@Override
			public Adapter caseSmmElement(SmmElement object) {
				return createSmmElementAdapter();
			}
			@Override
			public Adapter caseSmmRelationship(SmmRelationship object) {
				return createSmmRelationshipAdapter();
			}
			@Override
			public Adapter caseAttribute(Attribute object) {
				return createAttributeAdapter();
			}
			@Override
			public Adapter caseAnnotation(Annotation object) {
				return createAnnotationAdapter();
			}
			@Override
			public Adapter caseArgument(Argument object) {
				return createArgumentAdapter();
			}
			@Override
			public Adapter caseObservedMeasure(ObservedMeasure object) {
				return createObservedMeasureAdapter();
			}
			@Override
			public Adapter caseMeasurement(Measurement object) {
				return createMeasurementAdapter();
			}
			@Override
			public Adapter caseEquivalentMeasurementRelationship(EquivalentMeasurementRelationship object) {
				return createEquivalentMeasurementRelationshipAdapter();
			}
			@Override
			public Adapter caseMeasurementRelationship(MeasurementRelationship object) {
				return createMeasurementRelationshipAdapter();
			}
			@Override
			public Adapter caseRefinementMeasurementRelationship(RefinementMeasurementRelationship object) {
				return createRefinementMeasurementRelationshipAdapter();
			}
			@Override
			public Adapter caseMeasure(Measure object) {
				return createMeasureAdapter();
			}
			@Override
			public Adapter caseRefinementMeasureRelationship(RefinementMeasureRelationship object) {
				return createRefinementMeasureRelationshipAdapter();
			}
			@Override
			public Adapter caseMeasureRelationship(MeasureRelationship object) {
				return createMeasureRelationshipAdapter();
			}
			@Override
			public Adapter caseOperation(Operation object) {
				return createOperationAdapter();
			}
			@Override
			public Adapter caseEquivalentMeasureRelationship(EquivalentMeasureRelationship object) {
				return createEquivalentMeasureRelationshipAdapter();
			}
			@Override
			public Adapter caseMeasureCategory(MeasureCategory object) {
				return createMeasureCategoryAdapter();
			}
			@Override
			public Adapter caseScope(Scope object) {
				return createScopeAdapter();
			}
			@Override
			public Adapter caseCharacteristic(Characteristic object) {
				return createCharacteristicAdapter();
			}
			@Override
			public Adapter caseBase1MeasureRelationship(Base1MeasureRelationship object) {
				return createBase1MeasureRelationshipAdapter();
			}
			@Override
			public Adapter caseBaseMeasureRelationship(BaseMeasureRelationship object) {
				return createBaseMeasureRelationshipAdapter();
			}
			@Override
			public Adapter caseRescaledMeasure(RescaledMeasure object) {
				return createRescaledMeasureAdapter();
			}
			@Override
			public Adapter caseDimensionalMeasure(DimensionalMeasure object) {
				return createDimensionalMeasureAdapter();
			}
			@Override
			public Adapter caseBaseNMeasureRelationship(BaseNMeasureRelationship object) {
				return createBaseNMeasureRelationshipAdapter();
			}
			@Override
			public Adapter caseCollectiveMeasure(CollectiveMeasure object) {
				return createCollectiveMeasureAdapter();
			}
			@Override
			public Adapter caseBase2MeasureRelationship(Base2MeasureRelationship object) {
				return createBase2MeasureRelationshipAdapter();
			}
			@Override
			public Adapter caseBinaryMeasure(BinaryMeasure object) {
				return createBinaryMeasureAdapter();
			}
			@Override
			public Adapter caseRankingMeasureRelationship(RankingMeasureRelationship object) {
				return createRankingMeasureRelationshipAdapter();
			}
			@Override
			public Adapter caseRankingMeasure(RankingMeasure object) {
				return createRankingMeasureAdapter();
			}
			@Override
			public Adapter caseRankingInterval(RankingInterval object) {
				return createRankingIntervalAdapter();
			}
			@Override
			public Adapter caseInterval(Interval object) {
				return createIntervalAdapter();
			}
			@Override
			public Adapter caseRescaledMeasureRelationship(RescaledMeasureRelationship object) {
				return createRescaledMeasureRelationshipAdapter();
			}
			@Override
			public Adapter caseGradeMeasureRelationship(GradeMeasureRelationship object) {
				return createGradeMeasureRelationshipAdapter();
			}
			@Override
			public Adapter caseGradeMeasure(GradeMeasure object) {
				return createGradeMeasureAdapter();
			}
			@Override
			public Adapter caseGradeInterval(GradeInterval object) {
				return createGradeIntervalAdapter();
			}
			@Override
			public Adapter caseUnitOfMeasure(UnitOfMeasure object) {
				return createUnitOfMeasureAdapter();
			}
			@Override
			public Adapter caseBase1MeasurementRelationship(Base1MeasurementRelationship object) {
				return createBase1MeasurementRelationshipAdapter();
			}
			@Override
			public Adapter caseBaseMeasurementRelationship(BaseMeasurementRelationship object) {
				return createBaseMeasurementRelationshipAdapter();
			}
			@Override
			public Adapter caseDimensionalMeasurement(DimensionalMeasurement object) {
				return createDimensionalMeasurementAdapter();
			}
			@Override
			public Adapter caseBaseNMeasurementRelationship(BaseNMeasurementRelationship object) {
				return createBaseNMeasurementRelationshipAdapter();
			}
			@Override
			public Adapter caseCollectiveMeasurement(CollectiveMeasurement object) {
				return createCollectiveMeasurementAdapter();
			}
			@Override
			public Adapter caseBase2MeasurementRelationship(Base2MeasurementRelationship object) {
				return createBase2MeasurementRelationshipAdapter();
			}
			@Override
			public Adapter caseBinaryMeasurement(BinaryMeasurement object) {
				return createBinaryMeasurementAdapter();
			}
			@Override
			public Adapter caseGradeMeasurementRelationship(GradeMeasurementRelationship object) {
				return createGradeMeasurementRelationshipAdapter();
			}
			@Override
			public Adapter caseGradeMeasurement(GradeMeasurement object) {
				return createGradeMeasurementAdapter();
			}
			@Override
			public Adapter caseRescaledMeasurementRelationship(RescaledMeasurementRelationship object) {
				return createRescaledMeasurementRelationshipAdapter();
			}
			@Override
			public Adapter caseRescaledMeasurement(RescaledMeasurement object) {
				return createRescaledMeasurementAdapter();
			}
			@Override
			public Adapter caseRankingMeasurementRelationship(RankingMeasurementRelationship object) {
				return createRankingMeasurementRelationshipAdapter();
			}
			@Override
			public Adapter caseRankingMeasurement(RankingMeasurement object) {
				return createRankingMeasurementAdapter();
			}
			@Override
			public Adapter caseCategoryRelationship(CategoryRelationship object) {
				return createCategoryRelationshipAdapter();
			}
			@Override
			public Adapter caseCountingMeasurement(CountingMeasurement object) {
				return createCountingMeasurementAdapter();
			}
			@Override
			public Adapter caseDirectMeasurement(DirectMeasurement object) {
				return createDirectMeasurementAdapter();
			}
			@Override
			public Adapter caseCountingMeasure(CountingMeasure object) {
				return createCountingMeasureAdapter();
			}
			@Override
			public Adapter caseDirectMeasure(DirectMeasure object) {
				return createDirectMeasureAdapter();
			}
			@Override
			public Adapter caseMeasureLibrary(MeasureLibrary object) {
				return createMeasureLibraryAdapter();
			}
			@Override
			public Adapter caseNamedMeasure(NamedMeasure object) {
				return createNamedMeasureAdapter();
			}
			@Override
			public Adapter caseNamedMeasurement(NamedMeasurement object) {
				return createNamedMeasurementAdapter();
			}
			@Override
			public Adapter caseOCLOperation(OCLOperation object) {
				return createOCLOperationAdapter();
			}
			@Override
			public Adapter caseObservation(Observation object) {
				return createObservationAdapter();
			}
			@Override
			public Adapter caseObservationScope(ObservationScope object) {
				return createObservationScopeAdapter();
			}
			@Override
			public Adapter caseRatioMeasure(RatioMeasure object) {
				return createRatioMeasureAdapter();
			}
			@Override
			public Adapter caseRatioMeasurement(RatioMeasurement object) {
				return createRatioMeasurementAdapter();
			}
			@Override
			public Adapter caseSmmModel(SmmModel object) {
				return createSmmModelAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.AbstractMeasureElement <em>Abstract Measure Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.AbstractMeasureElement
	 * @generated
	 */
	public Adapter createAbstractMeasureElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.SmmElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.SmmElement
	 * @generated
	 */
	public Adapter createSmmElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.SmmRelationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.SmmRelationship
	 * @generated
	 */
	public Adapter createSmmRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.Attribute
	 * @generated
	 */
	public Adapter createAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.Annotation
	 * @generated
	 */
	public Adapter createAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.Argument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.Argument
	 * @generated
	 */
	public Adapter createArgumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.ObservedMeasure <em>Observed Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.ObservedMeasure
	 * @generated
	 */
	public Adapter createObservedMeasureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.Measurement <em>Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.Measurement
	 * @generated
	 */
	public Adapter createMeasurementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.EquivalentMeasurementRelationship <em>Equivalent Measurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.EquivalentMeasurementRelationship
	 * @generated
	 */
	public Adapter createEquivalentMeasurementRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.MeasurementRelationship <em>Measurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.MeasurementRelationship
	 * @generated
	 */
	public Adapter createMeasurementRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.RefinementMeasurementRelationship <em>Refinement Measurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.RefinementMeasurementRelationship
	 * @generated
	 */
	public Adapter createRefinementMeasurementRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.Measure <em>Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.Measure
	 * @generated
	 */
	public Adapter createMeasureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.RefinementMeasureRelationship <em>Refinement Measure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.RefinementMeasureRelationship
	 * @generated
	 */
	public Adapter createRefinementMeasureRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.MeasureRelationship <em>Measure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.MeasureRelationship
	 * @generated
	 */
	public Adapter createMeasureRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.Operation
	 * @generated
	 */
	public Adapter createOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.EquivalentMeasureRelationship <em>Equivalent Measure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.EquivalentMeasureRelationship
	 * @generated
	 */
	public Adapter createEquivalentMeasureRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.MeasureCategory <em>Measure Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.MeasureCategory
	 * @generated
	 */
	public Adapter createMeasureCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.Scope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.Scope
	 * @generated
	 */
	public Adapter createScopeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.Characteristic <em>Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.Characteristic
	 * @generated
	 */
	public Adapter createCharacteristicAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.Base1MeasureRelationship <em>Base1 Measure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.Base1MeasureRelationship
	 * @generated
	 */
	public Adapter createBase1MeasureRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.BaseMeasureRelationship <em>Base Measure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.BaseMeasureRelationship
	 * @generated
	 */
	public Adapter createBaseMeasureRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.RescaledMeasure <em>Rescaled Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.RescaledMeasure
	 * @generated
	 */
	public Adapter createRescaledMeasureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.DimensionalMeasure <em>Dimensional Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.DimensionalMeasure
	 * @generated
	 */
	public Adapter createDimensionalMeasureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.BaseNMeasureRelationship <em>Base NMeasure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.BaseNMeasureRelationship
	 * @generated
	 */
	public Adapter createBaseNMeasureRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.CollectiveMeasure <em>Collective Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.CollectiveMeasure
	 * @generated
	 */
	public Adapter createCollectiveMeasureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.Base2MeasureRelationship <em>Base2 Measure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.Base2MeasureRelationship
	 * @generated
	 */
	public Adapter createBase2MeasureRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.BinaryMeasure <em>Binary Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.BinaryMeasure
	 * @generated
	 */
	public Adapter createBinaryMeasureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.RankingMeasureRelationship <em>Ranking Measure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.RankingMeasureRelationship
	 * @generated
	 */
	public Adapter createRankingMeasureRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.RankingMeasure <em>Ranking Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.RankingMeasure
	 * @generated
	 */
	public Adapter createRankingMeasureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.RankingInterval <em>Ranking Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.RankingInterval
	 * @generated
	 */
	public Adapter createRankingIntervalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.Interval <em>Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.Interval
	 * @generated
	 */
	public Adapter createIntervalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.RescaledMeasureRelationship <em>Rescaled Measure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.RescaledMeasureRelationship
	 * @generated
	 */
	public Adapter createRescaledMeasureRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.GradeMeasureRelationship <em>Grade Measure Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.GradeMeasureRelationship
	 * @generated
	 */
	public Adapter createGradeMeasureRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.GradeMeasure <em>Grade Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.GradeMeasure
	 * @generated
	 */
	public Adapter createGradeMeasureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.GradeInterval <em>Grade Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.GradeInterval
	 * @generated
	 */
	public Adapter createGradeIntervalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.UnitOfMeasure <em>Unit Of Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.UnitOfMeasure
	 * @generated
	 */
	public Adapter createUnitOfMeasureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.Base1MeasurementRelationship <em>Base1 Measurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.Base1MeasurementRelationship
	 * @generated
	 */
	public Adapter createBase1MeasurementRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.BaseMeasurementRelationship <em>Base Measurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.BaseMeasurementRelationship
	 * @generated
	 */
	public Adapter createBaseMeasurementRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.DimensionalMeasurement <em>Dimensional Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.DimensionalMeasurement
	 * @generated
	 */
	public Adapter createDimensionalMeasurementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.BaseNMeasurementRelationship <em>Base NMeasurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.BaseNMeasurementRelationship
	 * @generated
	 */
	public Adapter createBaseNMeasurementRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.CollectiveMeasurement <em>Collective Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.CollectiveMeasurement
	 * @generated
	 */
	public Adapter createCollectiveMeasurementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.Base2MeasurementRelationship <em>Base2 Measurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.Base2MeasurementRelationship
	 * @generated
	 */
	public Adapter createBase2MeasurementRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.BinaryMeasurement <em>Binary Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.BinaryMeasurement
	 * @generated
	 */
	public Adapter createBinaryMeasurementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.GradeMeasurementRelationship <em>Grade Measurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.GradeMeasurementRelationship
	 * @generated
	 */
	public Adapter createGradeMeasurementRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.GradeMeasurement <em>Grade Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.GradeMeasurement
	 * @generated
	 */
	public Adapter createGradeMeasurementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.RescaledMeasurementRelationship <em>Rescaled Measurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.RescaledMeasurementRelationship
	 * @generated
	 */
	public Adapter createRescaledMeasurementRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.RescaledMeasurement <em>Rescaled Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.RescaledMeasurement
	 * @generated
	 */
	public Adapter createRescaledMeasurementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.RankingMeasurementRelationship <em>Ranking Measurement Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.RankingMeasurementRelationship
	 * @generated
	 */
	public Adapter createRankingMeasurementRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.RankingMeasurement <em>Ranking Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.RankingMeasurement
	 * @generated
	 */
	public Adapter createRankingMeasurementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.CategoryRelationship <em>Category Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.CategoryRelationship
	 * @generated
	 */
	public Adapter createCategoryRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.CountingMeasurement <em>Counting Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.CountingMeasurement
	 * @generated
	 */
	public Adapter createCountingMeasurementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.DirectMeasurement <em>Direct Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.DirectMeasurement
	 * @generated
	 */
	public Adapter createDirectMeasurementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.CountingMeasure <em>Counting Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.CountingMeasure
	 * @generated
	 */
	public Adapter createCountingMeasureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.DirectMeasure <em>Direct Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.DirectMeasure
	 * @generated
	 */
	public Adapter createDirectMeasureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.MeasureLibrary <em>Measure Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.MeasureLibrary
	 * @generated
	 */
	public Adapter createMeasureLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.NamedMeasure <em>Named Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.NamedMeasure
	 * @generated
	 */
	public Adapter createNamedMeasureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.NamedMeasurement <em>Named Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.NamedMeasurement
	 * @generated
	 */
	public Adapter createNamedMeasurementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.OCLOperation <em>OCL Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.OCLOperation
	 * @generated
	 */
	public Adapter createOCLOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.Observation <em>Observation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.Observation
	 * @generated
	 */
	public Adapter createObservationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.ObservationScope <em>Observation Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.ObservationScope
	 * @generated
	 */
	public Adapter createObservationScopeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.RatioMeasure <em>Ratio Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.RatioMeasure
	 * @generated
	 */
	public Adapter createRatioMeasureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.RatioMeasurement <em>Ratio Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.RatioMeasurement
	 * @generated
	 */
	public Adapter createRatioMeasurementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.smm.SmmModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.smm.SmmModel
	 * @generated
	 */
	public Adapter createSmmModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SmmAdapterFactory
