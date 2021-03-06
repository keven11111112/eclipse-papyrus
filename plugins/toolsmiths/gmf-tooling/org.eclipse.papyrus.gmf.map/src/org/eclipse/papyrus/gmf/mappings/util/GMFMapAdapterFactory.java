/*******************************************************************************
 * Copyright (c) 2005, 2020 Borland Software Corporation, CEA LIST, ARTAL
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 * 
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     Borland - initial API and implementation
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.gmf.mappings.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.gmf.mappings.AppearanceSteward;
import org.eclipse.papyrus.gmf.mappings.AuditContainer;
import org.eclipse.papyrus.gmf.mappings.AuditRule;
import org.eclipse.papyrus.gmf.mappings.Auditable;
import org.eclipse.papyrus.gmf.mappings.AuditedMetricTarget;
import org.eclipse.papyrus.gmf.mappings.CanvasMapping;
import org.eclipse.papyrus.gmf.mappings.ChildReference;
import org.eclipse.papyrus.gmf.mappings.CompartmentMapping;
import org.eclipse.papyrus.gmf.mappings.Constraint;
import org.eclipse.papyrus.gmf.mappings.DesignLabelMapping;
import org.eclipse.papyrus.gmf.mappings.DiagramElementTarget;
import org.eclipse.papyrus.gmf.mappings.DomainAttributeTarget;
import org.eclipse.papyrus.gmf.mappings.DomainElementTarget;
import org.eclipse.papyrus.gmf.mappings.ElementInitializer;
import org.eclipse.papyrus.gmf.mappings.ExpressionLabelMapping;
import org.eclipse.papyrus.gmf.mappings.FeatureInitializer;
import org.eclipse.papyrus.gmf.mappings.FeatureLabelMapping;
import org.eclipse.papyrus.gmf.mappings.FeatureSeqInitializer;
import org.eclipse.papyrus.gmf.mappings.FeatureValueSpec;
import org.eclipse.papyrus.gmf.mappings.GMFMapPackage;
import org.eclipse.papyrus.gmf.mappings.LabelMapping;
import org.eclipse.papyrus.gmf.mappings.LinkConstraints;
import org.eclipse.papyrus.gmf.mappings.LinkMapping;
import org.eclipse.papyrus.gmf.mappings.Mapping;
import org.eclipse.papyrus.gmf.mappings.MappingEntry;
import org.eclipse.papyrus.gmf.mappings.Measurable;
import org.eclipse.papyrus.gmf.mappings.MenuOwner;
import org.eclipse.papyrus.gmf.mappings.MetricContainer;
import org.eclipse.papyrus.gmf.mappings.MetricRule;
import org.eclipse.papyrus.gmf.mappings.NeedsContainment;
import org.eclipse.papyrus.gmf.mappings.NodeMapping;
import org.eclipse.papyrus.gmf.mappings.NodeReference;
import org.eclipse.papyrus.gmf.mappings.NotationElementTarget;
import org.eclipse.papyrus.gmf.mappings.OclChoiceLabelMapping;
import org.eclipse.papyrus.gmf.mappings.ReferenceNewElementSpec;
import org.eclipse.papyrus.gmf.mappings.RuleBase;
import org.eclipse.papyrus.gmf.mappings.ToolOwner;
import org.eclipse.papyrus.gmf.mappings.TopNodeReference;
import org.eclipse.papyrus.gmf.mappings.ValueExpression;
import org.eclipse.papyrus.gmf.mappings.VisualEffectMapping;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage
 * @generated
 */
public class GMFMapAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GMFMapPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GMFMapAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GMFMapPackage.eINSTANCE;
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
	protected GMFMapSwitch<Adapter> modelSwitch =
		new GMFMapSwitch<Adapter>() {
			@Override
			public Adapter caseMapping(Mapping object) {
				return createMappingAdapter();
			}
			@Override
			public Adapter caseMappingEntry(MappingEntry object) {
				return createMappingEntryAdapter();
			}
			@Override
			public Adapter caseNeedsContainment(NeedsContainment object) {
				return createNeedsContainmentAdapter();
			}
			@Override
			public Adapter caseNodeReference(NodeReference object) {
				return createNodeReferenceAdapter();
			}
			@Override
			public Adapter caseChildReference(ChildReference object) {
				return createChildReferenceAdapter();
			}
			@Override
			public Adapter caseTopNodeReference(TopNodeReference object) {
				return createTopNodeReferenceAdapter();
			}
			@Override
			public Adapter caseNodeMapping(NodeMapping object) {
				return createNodeMappingAdapter();
			}
			@Override
			public Adapter caseCompartmentMapping(CompartmentMapping object) {
				return createCompartmentMappingAdapter();
			}
			@Override
			public Adapter caseLinkMapping(LinkMapping object) {
				return createLinkMappingAdapter();
			}
			@Override
			public Adapter caseCanvasMapping(CanvasMapping object) {
				return createCanvasMappingAdapter();
			}
			@Override
			public Adapter caseLabelMapping(LabelMapping object) {
				return createLabelMappingAdapter();
			}
			@Override
			public Adapter caseFeatureLabelMapping(FeatureLabelMapping object) {
				return createFeatureLabelMappingAdapter();
			}
			@Override
			public Adapter caseOclChoiceLabelMapping(OclChoiceLabelMapping object) {
				return createOclChoiceLabelMappingAdapter();
			}
			@Override
			public Adapter caseDesignLabelMapping(DesignLabelMapping object) {
				return createDesignLabelMappingAdapter();
			}
			@Override
			public Adapter caseExpressionLabelMapping(ExpressionLabelMapping object) {
				return createExpressionLabelMappingAdapter();
			}
			@Override
			public Adapter caseConstraint(Constraint object) {
				return createConstraintAdapter();
			}
			@Override
			public Adapter caseLinkConstraints(LinkConstraints object) {
				return createLinkConstraintsAdapter();
			}
			@Override
			public Adapter caseValueExpression(ValueExpression object) {
				return createValueExpressionAdapter();
			}
			@Override
			public Adapter caseElementInitializer(ElementInitializer object) {
				return createElementInitializerAdapter();
			}
			@Override
			public Adapter caseFeatureSeqInitializer(FeatureSeqInitializer object) {
				return createFeatureSeqInitializerAdapter();
			}
			@Override
			public Adapter caseFeatureInitializer(FeatureInitializer object) {
				return createFeatureInitializerAdapter();
			}
			@Override
			public Adapter caseFeatureValueSpec(FeatureValueSpec object) {
				return createFeatureValueSpecAdapter();
			}
			@Override
			public Adapter caseReferenceNewElementSpec(ReferenceNewElementSpec object) {
				return createReferenceNewElementSpecAdapter();
			}
			@Override
			public Adapter caseMenuOwner(MenuOwner object) {
				return createMenuOwnerAdapter();
			}
			@Override
			public Adapter caseToolOwner(ToolOwner object) {
				return createToolOwnerAdapter();
			}
			@Override
			public Adapter caseAppearanceSteward(AppearanceSteward object) {
				return createAppearanceStewardAdapter();
			}
			@Override
			public Adapter caseAuditContainer(AuditContainer object) {
				return createAuditContainerAdapter();
			}
			@Override
			public Adapter caseRuleBase(RuleBase object) {
				return createRuleBaseAdapter();
			}
			@Override
			public Adapter caseAuditRule(AuditRule object) {
				return createAuditRuleAdapter();
			}
			@Override
			public Adapter caseDomainElementTarget(DomainElementTarget object) {
				return createDomainElementTargetAdapter();
			}
			@Override
			public Adapter caseDomainAttributeTarget(DomainAttributeTarget object) {
				return createDomainAttributeTargetAdapter();
			}
			@Override
			public Adapter caseDiagramElementTarget(DiagramElementTarget object) {
				return createDiagramElementTargetAdapter();
			}
			@Override
			public Adapter caseNotationElementTarget(NotationElementTarget object) {
				return createNotationElementTargetAdapter();
			}
			@Override
			public Adapter caseMetricContainer(MetricContainer object) {
				return createMetricContainerAdapter();
			}
			@Override
			public Adapter caseMetricRule(MetricRule object) {
				return createMetricRuleAdapter();
			}
			@Override
			public Adapter caseAuditedMetricTarget(AuditedMetricTarget object) {
				return createAuditedMetricTargetAdapter();
			}
			@Override
			public Adapter caseAuditable(Auditable object) {
				return createAuditableAdapter();
			}
			@Override
			public Adapter caseMeasurable(Measurable object) {
				return createMeasurableAdapter();
			}
			@Override
			public Adapter caseVisualEffectMapping(VisualEffectMapping object) {
				return createVisualEffectMappingAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.MappingEntry <em>Mapping Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.MappingEntry
	 * @generated
	 */
	public Adapter createMappingEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.NeedsContainment <em>Needs Containment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.NeedsContainment
	 * @generated
	 */
	public Adapter createNeedsContainmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.NodeReference <em>Node Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.NodeReference
	 * @generated
	 */
	public Adapter createNodeReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.ChildReference <em>Child Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.ChildReference
	 * @generated
	 */
	public Adapter createChildReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.TopNodeReference <em>Top Node Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.TopNodeReference
	 * @generated
	 */
	public Adapter createTopNodeReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.NodeMapping <em>Node Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.NodeMapping
	 * @generated
	 */
	public Adapter createNodeMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.CompartmentMapping <em>Compartment Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.CompartmentMapping
	 * @generated
	 */
	public Adapter createCompartmentMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.LinkMapping <em>Link Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.LinkMapping
	 * @generated
	 */
	public Adapter createLinkMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.CanvasMapping <em>Canvas Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.CanvasMapping
	 * @generated
	 */
	public Adapter createCanvasMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.LabelMapping <em>Label Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.LabelMapping
	 * @generated
	 */
	public Adapter createLabelMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.FeatureLabelMapping <em>Feature Label Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.FeatureLabelMapping
	 * @generated
	 */
	public Adapter createFeatureLabelMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.OclChoiceLabelMapping <em>Ocl Choice Label Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.OclChoiceLabelMapping
	 * @generated
	 */
	public Adapter createOclChoiceLabelMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.DesignLabelMapping <em>Design Label Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.DesignLabelMapping
	 * @generated
	 */
	public Adapter createDesignLabelMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.ExpressionLabelMapping <em>Expression Label Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.ExpressionLabelMapping
	 * @generated
	 */
	public Adapter createExpressionLabelMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.Mapping
	 * @generated
	 */
	public Adapter createMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.LinkConstraints <em>Link Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.LinkConstraints
	 * @generated
	 */
	public Adapter createLinkConstraintsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.ValueExpression <em>Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.ValueExpression
	 * @generated
	 */
	public Adapter createValueExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.ElementInitializer <em>Element Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.ElementInitializer
	 * @generated
	 */
	public Adapter createElementInitializerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.FeatureSeqInitializer <em>Feature Seq Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.FeatureSeqInitializer
	 * @generated
	 */
	public Adapter createFeatureSeqInitializerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.FeatureInitializer <em>Feature Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.FeatureInitializer
	 * @generated
	 */
	public Adapter createFeatureInitializerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.FeatureValueSpec <em>Feature Value Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.FeatureValueSpec
	 * @generated
	 */
	public Adapter createFeatureValueSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.ReferenceNewElementSpec <em>Reference New Element Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.ReferenceNewElementSpec
	 * @generated
	 */
	public Adapter createReferenceNewElementSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.MenuOwner <em>Menu Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.MenuOwner
	 * @generated
	 */
	public Adapter createMenuOwnerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.ToolOwner <em>Tool Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.ToolOwner
	 * @generated
	 */
	public Adapter createToolOwnerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.AppearanceSteward <em>Appearance Steward</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.AppearanceSteward
	 * @generated
	 */
	public Adapter createAppearanceStewardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.AuditContainer <em>Audit Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.AuditContainer
	 * @generated
	 */
	public Adapter createAuditContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.AuditRule <em>Audit Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.AuditRule
	 * @generated
	 */
	public Adapter createAuditRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.RuleBase <em>Rule Base</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.RuleBase
	 * @generated
	 */
	public Adapter createRuleBaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.DomainElementTarget <em>Domain Element Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.DomainElementTarget
	 * @generated
	 */
	public Adapter createDomainElementTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.DomainAttributeTarget <em>Domain Attribute Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.DomainAttributeTarget
	 * @generated
	 */
	public Adapter createDomainAttributeTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.DiagramElementTarget <em>Diagram Element Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.DiagramElementTarget
	 * @generated
	 */
	public Adapter createDiagramElementTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.NotationElementTarget <em>Notation Element Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.NotationElementTarget
	 * @generated
	 */
	public Adapter createNotationElementTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.MetricContainer <em>Metric Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.MetricContainer
	 * @generated
	 */
	public Adapter createMetricContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.MetricRule <em>Metric Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.MetricRule
	 * @generated
	 */
	public Adapter createMetricRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.AuditedMetricTarget <em>Audited Metric Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.AuditedMetricTarget
	 * @generated
	 */
	public Adapter createAuditedMetricTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.Auditable <em>Auditable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.Auditable
	 * @generated
	 */
	public Adapter createAuditableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.Measurable <em>Measurable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.Measurable
	 * @generated
	 */
	public Adapter createMeasurableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.gmf.mappings.VisualEffectMapping <em>Visual Effect Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.gmf.mappings.VisualEffectMapping
	 * @generated
	 */
	public Adapter createVisualEffectMappingAdapter() {
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

} //GMFMapAdapterFactory
