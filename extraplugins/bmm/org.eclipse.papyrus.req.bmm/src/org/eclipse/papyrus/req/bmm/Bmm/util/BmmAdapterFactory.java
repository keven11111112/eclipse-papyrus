/**
 */
package org.eclipse.papyrus.req.bmm.Bmm.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.req.bmm.Bmm.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.req.bmm.Bmm.BmmPackage
 * @generated
 */
public class BmmAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BmmPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BmmAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = BmmPackage.eINSTANCE;
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
	protected BmmSwitch<Adapter> modelSwitch =
		new BmmSwitch<Adapter>() {
			@Override
			public Adapter caseMotivationElement(MotivationElement object) {
				return createMotivationElementAdapter();
			}
			@Override
			public Adapter caseAssessment(Assessment object) {
				return createAssessmentAdapter();
			}
			@Override
			public Adapter caseOrganizationUnit(OrganizationUnit object) {
				return createOrganizationUnitAdapter();
			}
			@Override
			public Adapter caseStrategy(Strategy object) {
				return createStrategyAdapter();
			}
			@Override
			public Adapter caseCourseOfAction(CourseOfAction object) {
				return createCourseOfActionAdapter();
			}
			@Override
			public Adapter caseMeans(Means object) {
				return createMeansAdapter();
			}
			@Override
			public Adapter caseDirective(Directive object) {
				return createDirectiveAdapter();
			}
			@Override
			public Adapter casePotentialImpact(PotentialImpact object) {
				return createPotentialImpactAdapter();
			}
			@Override
			public Adapter caseRegulation(Regulation object) {
				return createRegulationAdapter();
			}
			@Override
			public Adapter caseExternalInfluencer(ExternalInfluencer object) {
				return createExternalInfluencerAdapter();
			}
			@Override
			public Adapter caseInfluencer(Influencer object) {
				return createInfluencerAdapter();
			}
			@Override
			public Adapter caseInfluencingOrganization(InfluencingOrganization object) {
				return createInfluencingOrganizationAdapter();
			}
			@Override
			public Adapter caseOrganizationCategory(OrganizationCategory object) {
				return createOrganizationCategoryAdapter();
			}
			@Override
			public Adapter caseInfluencerCategory(InfluencerCategory object) {
				return createInfluencerCategoryAdapter();
			}
			@Override
			public Adapter caseDesiredResult(DesiredResult object) {
				return createDesiredResultAdapter();
			}
			@Override
			public Adapter caseEnd(End object) {
				return createEndAdapter();
			}
			@Override
			public Adapter caseDesiredResultCategory(DesiredResultCategory object) {
				return createDesiredResultCategoryAdapter();
			}
			@Override
			public Adapter caseAsset(Asset object) {
				return createAssetAdapter();
			}
			@Override
			public Adapter caseBusinessProcess(BusinessProcess object) {
				return createBusinessProcessAdapter();
			}
			@Override
			public Adapter caseBusinessRule(BusinessRule object) {
				return createBusinessRuleAdapter();
			}
			@Override
			public Adapter caseBusinessPolicy(BusinessPolicy object) {
				return createBusinessPolicyAdapter();
			}
			@Override
			public Adapter caseTactic(Tactic object) {
				return createTacticAdapter();
			}
			@Override
			public Adapter caseOffering(Offering object) {
				return createOfferingAdapter();
			}
			@Override
			public Adapter caseFixedAsset(FixedAsset object) {
				return createFixedAssetAdapter();
			}
			@Override
			public Adapter caseResource(Resource object) {
				return createResourceAdapter();
			}
			@Override
			public Adapter caseLiability(Liability object) {
				return createLiabilityAdapter();
			}
			@Override
			public Adapter caseMission(Mission object) {
				return createMissionAdapter();
			}
			@Override
			public Adapter caseVision(Vision object) {
				return createVisionAdapter();
			}
			@Override
			public Adapter caseGoal(Goal object) {
				return createGoalAdapter();
			}
			@Override
			public Adapter caseObjective(Objective object) {
				return createObjectiveAdapter();
			}
			@Override
			public Adapter caseAssessmentCategory(AssessmentCategory object) {
				return createAssessmentCategoryAdapter();
			}
			@Override
			public Adapter caseInternalInfluencer(InternalInfluencer object) {
				return createInternalInfluencerAdapter();
			}
			@Override
			public Adapter casePotentialReward(PotentialReward object) {
				return createPotentialRewardAdapter();
			}
			@Override
			public Adapter caseRisk(Risk object) {
				return createRiskAdapter();
			}
			@Override
			public Adapter caseMotivationEdge(MotivationEdge object) {
				return createMotivationEdgeAdapter();
			}
			@Override
			public Adapter caseUsingAssessmentUsesUsedAssessment(UsingAssessmentUsesUsedAssessment object) {
				return createUsingAssessmentUsesUsedAssessmentAdapter();
			}
			@Override
			public Adapter caseOrganizationUnitMakesAssessment(OrganizationUnitMakesAssessment object) {
				return createOrganizationUnitMakesAssessmentAdapter();
			}
			@Override
			public Adapter caseAssessmentCategoryCategorizesAssessment(AssessmentCategoryCategorizesAssessment object) {
				return createAssessmentCategoryCategorizesAssessmentAdapter();
			}
			@Override
			public Adapter caseAssessmentIdentifiesPotentialImpact(AssessmentIdentifiesPotentialImpact object) {
				return createAssessmentIdentifiesPotentialImpactAdapter();
			}
			@Override
			public Adapter caseAssessmentAffectsAchievementOfEnd(AssessmentAffectsAchievementOfEnd object) {
				return createAssessmentAffectsAchievementOfEndAdapter();
			}
			@Override
			public Adapter caseAssessmentAffectsEmploymentOfMeans(AssessmentAffectsEmploymentOfMeans object) {
				return createAssessmentAffectsEmploymentOfMeansAdapter();
			}
			@Override
			public Adapter caseAssessmentProvidesImpetusForDirective(AssessmentProvidesImpetusForDirective object) {
				return createAssessmentProvidesImpetusForDirectiveAdapter();
			}
			@Override
			public Adapter caseAssessmentIsJudgmentOfInfluencer(AssessmentIsJudgmentOfInfluencer object) {
				return createAssessmentIsJudgmentOfInfluencerAdapter();
			}
			@Override
			public Adapter caseBroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory(BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory object) {
				return createBroaderAssessmentCategoryCategorizesNarrowerAssessmentCategoryAdapter();
			}
			@Override
			public Adapter caseBusinessProcessManagesAsset(BusinessProcessManagesAsset object) {
				return createBusinessProcessManagesAssetAdapter();
			}
			@Override
			public Adapter caseOrganizationUnitIsResponsibleForAsset(OrganizationUnitIsResponsibleForAsset object) {
				return createOrganizationUnitIsResponsibleForAssetAdapter();
			}
			@Override
			public Adapter caseCourseOfActionDeploysAsset(CourseOfActionDeploysAsset object) {
				return createCourseOfActionDeploysAssetAdapter();
			}
			@Override
			public Adapter caseDirectiveGovernsUseOfAsset(DirectiveGovernsUseOfAsset object) {
				return createDirectiveGovernsUseOfAssetAdapter();
			}
			@Override
			public Adapter caseBroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy(BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy object) {
				return createBroaderBusinessPolicyIncludesMoreSpecificBusinessPolicyAdapter();
			}
			@Override
			public Adapter caseBusinessPolicyIsBasisOfBusinessRule(BusinessPolicyIsBasisOfBusinessRule object) {
				return createBusinessPolicyIsBasisOfBusinessRuleAdapter();
			}
			@Override
			public Adapter caseBusinessPolicyGovernsBusinessProcess(BusinessPolicyGovernsBusinessProcess object) {
				return createBusinessPolicyGovernsBusinessProcessAdapter();
			}
			@Override
			public Adapter caseOrganizationUnitIsResponsibleForBusinessProcess(OrganizationUnitIsResponsibleForBusinessProcess object) {
				return createOrganizationUnitIsResponsibleForBusinessProcessAdapter();
			}
			@Override
			public Adapter caseBusinessRuleGuidesBusinessProcess(BusinessRuleGuidesBusinessProcess object) {
				return createBusinessRuleGuidesBusinessProcessAdapter();
			}
			@Override
			public Adapter caseBusinessProcessRealizesCourseOfAction(BusinessProcessRealizesCourseOfAction object) {
				return createBusinessProcessRealizesCourseOfActionAdapter();
			}
			@Override
			public Adapter caseBusinessProcessDeliversOffering(BusinessProcessDeliversOffering object) {
				return createBusinessProcessDeliversOfferingAdapter();
			}
			@Override
			public Adapter caseTacticEffectsEnforcementLevelOfBusinessRule(TacticEffectsEnforcementLevelOfBusinessRule object) {
				return createTacticEffectsEnforcementLevelOfBusinessRuleAdapter();
			}
			@Override
			public Adapter caseDirectiveGovernsCourseOfAction(DirectiveGovernsCourseOfAction object) {
				return createDirectiveGovernsCourseOfActionAdapter();
			}
			@Override
			public Adapter caseBroaderCourseOfActionIncludesMoreSpecificCourseOfAction(BroaderCourseOfActionIncludesMoreSpecificCourseOfAction object) {
				return createBroaderCourseOfActionIncludesMoreSpecificCourseOfActionAdapter();
			}
			@Override
			public Adapter caseEnablingCourseOfActionEnablesEnabledCourseOfAction(EnablingCourseOfActionEnablesEnabledCourseOfAction object) {
				return createEnablingCourseOfActionEnablesEnabledCourseOfActionAdapter();
			}
			@Override
			public Adapter caseCourseOfActionIsFormulatedBasedOnDirective(CourseOfActionIsFormulatedBasedOnDirective object) {
				return createCourseOfActionIsFormulatedBasedOnDirectiveAdapter();
			}
			@Override
			public Adapter caseCourseOfActionDefinesOffering(CourseOfActionDefinesOffering object) {
				return createCourseOfActionDefinesOfferingAdapter();
			}
			@Override
			public Adapter caseCourseOfActionDischargesLiability(CourseOfActionDischargesLiability object) {
				return createCourseOfActionDischargesLiabilityAdapter();
			}
			@Override
			public Adapter caseCourseOfActionChannelsEffortsTowardsDesiredResult(CourseOfActionChannelsEffortsTowardsDesiredResult object) {
				return createCourseOfActionChannelsEffortsTowardsDesiredResultAdapter();
			}
			@Override
			public Adapter caseBroaderDesiredResultIncludesMoreSpecificDesiredResult(BroaderDesiredResultIncludesMoreSpecificDesiredResult object) {
				return createBroaderDesiredResultIncludesMoreSpecificDesiredResultAdapter();
			}
			@Override
			public Adapter caseDesiredResultCategoryCategorizesDesiredResult(DesiredResultCategoryCategorizesDesiredResult object) {
				return createDesiredResultCategoryCategorizesDesiredResultAdapter();
			}
			@Override
			public Adapter caseDirectiveSupportsAchievementOfDesiredResult(DirectiveSupportsAchievementOfDesiredResult object) {
				return createDirectiveSupportsAchievementOfDesiredResultAdapter();
			}
			@Override
			public Adapter caseBroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory(BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory object) {
				return createBroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategoryAdapter();
			}
			@Override
			public Adapter casePotentialImpactProvidesImpetursForDirective(PotentialImpactProvidesImpetursForDirective object) {
				return createPotentialImpactProvidesImpetursForDirectiveAdapter();
			}
			@Override
			public Adapter caseDirectiveActsAsRegulation(DirectiveActsAsRegulation object) {
				return createDirectiveActsAsRegulationAdapter();
			}
			@Override
			public Adapter caseOrganizationUnitDefinesEnd(OrganizationUnitDefinesEnd object) {
				return createOrganizationUnitDefinesEndAdapter();
			}
			@Override
			public Adapter caseOfferingUsesFixedAsset(OfferingUsesFixedAsset object) {
				return createOfferingUsesFixedAssetAdapter();
			}
			@Override
			public Adapter caseFixedAssetProvidesResource(FixedAssetProvidesResource object) {
				return createFixedAssetProvidesResourceAdapter();
			}
			@Override
			public Adapter caseObjectiveQuantitiesGoal(ObjectiveQuantitiesGoal object) {
				return createObjectiveQuantitiesGoalAdapter();
			}
			@Override
			public Adapter caseGoalAmplifiesVision(GoalAmplifiesVision object) {
				return createGoalAmplifiesVisionAdapter();
			}
			@Override
			public Adapter caseOrganizationUnitRecognizesInfluencer(OrganizationUnitRecognizesInfluencer object) {
				return createOrganizationUnitRecognizesInfluencerAdapter();
			}
			@Override
			public Adapter caseInfluencingOrganizationIsSourceofInfluencer(InfluencingOrganizationIsSourceofInfluencer object) {
				return createInfluencingOrganizationIsSourceofInfluencerAdapter();
			}
			@Override
			public Adapter caseInfluencerCategoryCategorizesInfluencer(InfluencerCategoryCategorizesInfluencer object) {
				return createInfluencerCategoryCategorizesInfluencerAdapter();
			}
			@Override
			public Adapter caseBroaderInfluencerCategorizesNarrowerInfluencerCategory(BroaderInfluencerCategorizesNarrowerInfluencerCategory object) {
				return createBroaderInfluencerCategorizesNarrowerInfluencerCategoryAdapter();
			}
			@Override
			public Adapter caseOrganizationCategoryCategorizesInfluencingOrganization(OrganizationCategoryCategorizesInfluencingOrganization object) {
				return createOrganizationCategoryCategorizesInfluencingOrganizationAdapter();
			}
			@Override
			public Adapter caseOrganizationUnitActsAsInfluencingOrganization(OrganizationUnitActsAsInfluencingOrganization object) {
				return createOrganizationUnitActsAsInfluencingOrganizationAdapter();
			}
			@Override
			public Adapter caseOrganizationUnitIsResponsibleForLiability(OrganizationUnitIsResponsibleForLiability object) {
				return createOrganizationUnitIsResponsibleForLiabilityAdapter();
			}
			@Override
			public Adapter caseLiabilityClaimsResource(LiabilityClaimsResource object) {
				return createLiabilityClaimsResourceAdapter();
			}
			@Override
			public Adapter caseOrganizationUnitEstablishesMeans(OrganizationUnitEstablishesMeans object) {
				return createOrganizationUnitEstablishesMeansAdapter();
			}
			@Override
			public Adapter caseStrategyIsAComponentfOfThe_PlanForMIssion(StrategyIsAComponentfOfThe_PlanForMIssion object) {
				return createStrategyIsAComponentfOfThe_PlanForMIssionAdapter();
			}
			@Override
			public Adapter caseMissionMakesOperativeVision(MissionMakesOperativeVision object) {
				return createMissionMakesOperativeVisionAdapter();
			}
			@Override
			public Adapter caseOfferingRequiresResource(OfferingRequiresResource object) {
				return createOfferingRequiresResourceAdapter();
			}
			@Override
			public Adapter caseBroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory(BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory object) {
				return createBroaderOrganizationCategoryCategorizesNarrowerOrganizationCategoryAdapter();
			}
			@Override
			public Adapter caseStrategyDeterminesOrganizationUnit(StrategyDeterminesOrganizationUnit object) {
				return createStrategyDeterminesOrganizationUnitAdapter();
			}
			@Override
			public Adapter caseTacticImplementsStrategy(TacticImplementsStrategy object) {
				return createTacticImplementsStrategyAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.MotivationElement <em>Motivation Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.MotivationElement
	 * @generated
	 */
	public Adapter createMotivationElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.Assessment <em>Assessment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Assessment
	 * @generated
	 */
	public Adapter createAssessmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnit <em>Organization Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnit
	 * @generated
	 */
	public Adapter createOrganizationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.Strategy <em>Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Strategy
	 * @generated
	 */
	public Adapter createStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.CourseOfAction <em>Course Of Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.CourseOfAction
	 * @generated
	 */
	public Adapter createCourseOfActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.Means <em>Means</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Means
	 * @generated
	 */
	public Adapter createMeansAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.Directive <em>Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Directive
	 * @generated
	 */
	public Adapter createDirectiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.PotentialImpact <em>Potential Impact</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.PotentialImpact
	 * @generated
	 */
	public Adapter createPotentialImpactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.Regulation <em>Regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Regulation
	 * @generated
	 */
	public Adapter createRegulationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.ExternalInfluencer <em>External Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.ExternalInfluencer
	 * @generated
	 */
	public Adapter createExternalInfluencerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.Influencer <em>Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Influencer
	 * @generated
	 */
	public Adapter createInfluencerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.InfluencingOrganization <em>Influencing Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.InfluencingOrganization
	 * @generated
	 */
	public Adapter createInfluencingOrganizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationCategory <em>Organization Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationCategory
	 * @generated
	 */
	public Adapter createOrganizationCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.InfluencerCategory <em>Influencer Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.InfluencerCategory
	 * @generated
	 */
	public Adapter createInfluencerCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.DesiredResult <em>Desired Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.DesiredResult
	 * @generated
	 */
	public Adapter createDesiredResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.End <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.End
	 * @generated
	 */
	public Adapter createEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.DesiredResultCategory <em>Desired Result Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.DesiredResultCategory
	 * @generated
	 */
	public Adapter createDesiredResultCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.Asset <em>Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Asset
	 * @generated
	 */
	public Adapter createAssetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.BusinessProcess <em>Business Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BusinessProcess
	 * @generated
	 */
	public Adapter createBusinessProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.BusinessRule <em>Business Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BusinessRule
	 * @generated
	 */
	public Adapter createBusinessRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.BusinessPolicy <em>Business Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BusinessPolicy
	 * @generated
	 */
	public Adapter createBusinessPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.Tactic <em>Tactic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Tactic
	 * @generated
	 */
	public Adapter createTacticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.Offering <em>Offering</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Offering
	 * @generated
	 */
	public Adapter createOfferingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.FixedAsset <em>Fixed Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.FixedAsset
	 * @generated
	 */
	public Adapter createFixedAssetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.Liability <em>Liability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Liability
	 * @generated
	 */
	public Adapter createLiabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.Mission <em>Mission</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Mission
	 * @generated
	 */
	public Adapter createMissionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.Vision <em>Vision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Vision
	 * @generated
	 */
	public Adapter createVisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.Goal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Goal
	 * @generated
	 */
	public Adapter createGoalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.Objective <em>Objective</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Objective
	 * @generated
	 */
	public Adapter createObjectiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.AssessmentCategory <em>Assessment Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.AssessmentCategory
	 * @generated
	 */
	public Adapter createAssessmentCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.InternalInfluencer <em>Internal Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.InternalInfluencer
	 * @generated
	 */
	public Adapter createInternalInfluencerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.PotentialReward <em>Potential Reward</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.PotentialReward
	 * @generated
	 */
	public Adapter createPotentialRewardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.Risk <em>Risk</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Risk
	 * @generated
	 */
	public Adapter createRiskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.MotivationEdge <em>Motivation Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.MotivationEdge
	 * @generated
	 */
	public Adapter createMotivationEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.UsingAssessmentUsesUsedAssessment <em>Using Assessment Uses Used Assessment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.UsingAssessmentUsesUsedAssessment
	 * @generated
	 */
	public Adapter createUsingAssessmentUsesUsedAssessmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitMakesAssessment <em>Organization Unit Makes Assessment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitMakesAssessment
	 * @generated
	 */
	public Adapter createOrganizationUnitMakesAssessmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.AssessmentCategoryCategorizesAssessment <em>Assessment Category Categorizes Assessment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.AssessmentCategoryCategorizesAssessment
	 * @generated
	 */
	public Adapter createAssessmentCategoryCategorizesAssessmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.AssessmentIdentifiesPotentialImpact <em>Assessment Identifies Potential Impact</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.AssessmentIdentifiesPotentialImpact
	 * @generated
	 */
	public Adapter createAssessmentIdentifiesPotentialImpactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.AssessmentAffectsAchievementOfEnd <em>Assessment Affects Achievement Of End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.AssessmentAffectsAchievementOfEnd
	 * @generated
	 */
	public Adapter createAssessmentAffectsAchievementOfEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.AssessmentAffectsEmploymentOfMeans <em>Assessment Affects Employment Of Means</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.AssessmentAffectsEmploymentOfMeans
	 * @generated
	 */
	public Adapter createAssessmentAffectsEmploymentOfMeansAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.AssessmentProvidesImpetusForDirective <em>Assessment Provides Impetus For Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.AssessmentProvidesImpetusForDirective
	 * @generated
	 */
	public Adapter createAssessmentProvidesImpetusForDirectiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.AssessmentIsJudgmentOfInfluencer <em>Assessment Is Judgment Of Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.AssessmentIsJudgmentOfInfluencer
	 * @generated
	 */
	public Adapter createAssessmentIsJudgmentOfInfluencerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory <em>Broader Assessment Category Categorizes Narrower Assessment Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory
	 * @generated
	 */
	public Adapter createBroaderAssessmentCategoryCategorizesNarrowerAssessmentCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.BusinessProcessManagesAsset <em>Business Process Manages Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BusinessProcessManagesAsset
	 * @generated
	 */
	public Adapter createBusinessProcessManagesAssetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitIsResponsibleForAsset <em>Organization Unit Is Responsible For Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitIsResponsibleForAsset
	 * @generated
	 */
	public Adapter createOrganizationUnitIsResponsibleForAssetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionDeploysAsset <em>Course Of Action Deploys Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionDeploysAsset
	 * @generated
	 */
	public Adapter createCourseOfActionDeploysAssetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.DirectiveGovernsUseOfAsset <em>Directive Governs Use Of Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.DirectiveGovernsUseOfAsset
	 * @generated
	 */
	public Adapter createDirectiveGovernsUseOfAssetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy <em>Broader Business Policy Includes More Specific Business Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy
	 * @generated
	 */
	public Adapter createBroaderBusinessPolicyIncludesMoreSpecificBusinessPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.BusinessPolicyIsBasisOfBusinessRule <em>Business Policy Is Basis Of Business Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BusinessPolicyIsBasisOfBusinessRule
	 * @generated
	 */
	public Adapter createBusinessPolicyIsBasisOfBusinessRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.BusinessPolicyGovernsBusinessProcess <em>Business Policy Governs Business Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BusinessPolicyGovernsBusinessProcess
	 * @generated
	 */
	public Adapter createBusinessPolicyGovernsBusinessProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitIsResponsibleForBusinessProcess <em>Organization Unit Is Responsible For Business Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitIsResponsibleForBusinessProcess
	 * @generated
	 */
	public Adapter createOrganizationUnitIsResponsibleForBusinessProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.BusinessRuleGuidesBusinessProcess <em>Business Rule Guides Business Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BusinessRuleGuidesBusinessProcess
	 * @generated
	 */
	public Adapter createBusinessRuleGuidesBusinessProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.BusinessProcessRealizesCourseOfAction <em>Business Process Realizes Course Of Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BusinessProcessRealizesCourseOfAction
	 * @generated
	 */
	public Adapter createBusinessProcessRealizesCourseOfActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.BusinessProcessDeliversOffering <em>Business Process Delivers Offering</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BusinessProcessDeliversOffering
	 * @generated
	 */
	public Adapter createBusinessProcessDeliversOfferingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.TacticEffectsEnforcementLevelOfBusinessRule <em>Tactic Effects Enforcement Level Of Business Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.TacticEffectsEnforcementLevelOfBusinessRule
	 * @generated
	 */
	public Adapter createTacticEffectsEnforcementLevelOfBusinessRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.DirectiveGovernsCourseOfAction <em>Directive Governs Course Of Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.DirectiveGovernsCourseOfAction
	 * @generated
	 */
	public Adapter createDirectiveGovernsCourseOfActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.BroaderCourseOfActionIncludesMoreSpecificCourseOfAction <em>Broader Course Of Action Includes More Specific Course Of Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BroaderCourseOfActionIncludesMoreSpecificCourseOfAction
	 * @generated
	 */
	public Adapter createBroaderCourseOfActionIncludesMoreSpecificCourseOfActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.EnablingCourseOfActionEnablesEnabledCourseOfAction <em>Enabling Course Of Action Enables Enabled Course Of Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.EnablingCourseOfActionEnablesEnabledCourseOfAction
	 * @generated
	 */
	public Adapter createEnablingCourseOfActionEnablesEnabledCourseOfActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionIsFormulatedBasedOnDirective <em>Course Of Action Is Formulated Based On Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionIsFormulatedBasedOnDirective
	 * @generated
	 */
	public Adapter createCourseOfActionIsFormulatedBasedOnDirectiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionDefinesOffering <em>Course Of Action Defines Offering</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionDefinesOffering
	 * @generated
	 */
	public Adapter createCourseOfActionDefinesOfferingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionDischargesLiability <em>Course Of Action Discharges Liability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionDischargesLiability
	 * @generated
	 */
	public Adapter createCourseOfActionDischargesLiabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionChannelsEffortsTowardsDesiredResult <em>Course Of Action Channels Efforts Towards Desired Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionChannelsEffortsTowardsDesiredResult
	 * @generated
	 */
	public Adapter createCourseOfActionChannelsEffortsTowardsDesiredResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.BroaderDesiredResultIncludesMoreSpecificDesiredResult <em>Broader Desired Result Includes More Specific Desired Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BroaderDesiredResultIncludesMoreSpecificDesiredResult
	 * @generated
	 */
	public Adapter createBroaderDesiredResultIncludesMoreSpecificDesiredResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.DesiredResultCategoryCategorizesDesiredResult <em>Desired Result Category Categorizes Desired Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.DesiredResultCategoryCategorizesDesiredResult
	 * @generated
	 */
	public Adapter createDesiredResultCategoryCategorizesDesiredResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.DirectiveSupportsAchievementOfDesiredResult <em>Directive Supports Achievement Of Desired Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.DirectiveSupportsAchievementOfDesiredResult
	 * @generated
	 */
	public Adapter createDirectiveSupportsAchievementOfDesiredResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory <em>Broader Desired Category Categorizes More Specific Desired Result Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory
	 * @generated
	 */
	public Adapter createBroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.PotentialImpactProvidesImpetursForDirective <em>Potential Impact Provides Impeturs For Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.PotentialImpactProvidesImpetursForDirective
	 * @generated
	 */
	public Adapter createPotentialImpactProvidesImpetursForDirectiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.DirectiveActsAsRegulation <em>Directive Acts As Regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.DirectiveActsAsRegulation
	 * @generated
	 */
	public Adapter createDirectiveActsAsRegulationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitDefinesEnd <em>Organization Unit Defines End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitDefinesEnd
	 * @generated
	 */
	public Adapter createOrganizationUnitDefinesEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.OfferingUsesFixedAsset <em>Offering Uses Fixed Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OfferingUsesFixedAsset
	 * @generated
	 */
	public Adapter createOfferingUsesFixedAssetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.FixedAssetProvidesResource <em>Fixed Asset Provides Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.FixedAssetProvidesResource
	 * @generated
	 */
	public Adapter createFixedAssetProvidesResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.ObjectiveQuantitiesGoal <em>Objective Quantities Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.ObjectiveQuantitiesGoal
	 * @generated
	 */
	public Adapter createObjectiveQuantitiesGoalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.GoalAmplifiesVision <em>Goal Amplifies Vision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.GoalAmplifiesVision
	 * @generated
	 */
	public Adapter createGoalAmplifiesVisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitRecognizesInfluencer <em>Organization Unit Recognizes Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitRecognizesInfluencer
	 * @generated
	 */
	public Adapter createOrganizationUnitRecognizesInfluencerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.InfluencingOrganizationIsSourceofInfluencer <em>Influencing Organization Is Sourceof Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.InfluencingOrganizationIsSourceofInfluencer
	 * @generated
	 */
	public Adapter createInfluencingOrganizationIsSourceofInfluencerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.InfluencerCategoryCategorizesInfluencer <em>Influencer Category Categorizes Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.InfluencerCategoryCategorizesInfluencer
	 * @generated
	 */
	public Adapter createInfluencerCategoryCategorizesInfluencerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.BroaderInfluencerCategorizesNarrowerInfluencerCategory <em>Broader Influencer Categorizes Narrower Influencer Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BroaderInfluencerCategorizesNarrowerInfluencerCategory
	 * @generated
	 */
	public Adapter createBroaderInfluencerCategorizesNarrowerInfluencerCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationCategoryCategorizesInfluencingOrganization <em>Organization Category Categorizes Influencing Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationCategoryCategorizesInfluencingOrganization
	 * @generated
	 */
	public Adapter createOrganizationCategoryCategorizesInfluencingOrganizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitActsAsInfluencingOrganization <em>Organization Unit Acts As Influencing Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitActsAsInfluencingOrganization
	 * @generated
	 */
	public Adapter createOrganizationUnitActsAsInfluencingOrganizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitIsResponsibleForLiability <em>Organization Unit Is Responsible For Liability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitIsResponsibleForLiability
	 * @generated
	 */
	public Adapter createOrganizationUnitIsResponsibleForLiabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.LiabilityClaimsResource <em>Liability Claims Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.LiabilityClaimsResource
	 * @generated
	 */
	public Adapter createLiabilityClaimsResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitEstablishesMeans <em>Organization Unit Establishes Means</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitEstablishesMeans
	 * @generated
	 */
	public Adapter createOrganizationUnitEstablishesMeansAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.StrategyIsAComponentfOfThe_PlanForMIssion <em>Strategy Is AComponentf Of The Plan For MIssion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.StrategyIsAComponentfOfThe_PlanForMIssion
	 * @generated
	 */
	public Adapter createStrategyIsAComponentfOfThe_PlanForMIssionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.MissionMakesOperativeVision <em>Mission Makes Operative Vision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.MissionMakesOperativeVision
	 * @generated
	 */
	public Adapter createMissionMakesOperativeVisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.OfferingRequiresResource <em>Offering Requires Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OfferingRequiresResource
	 * @generated
	 */
	public Adapter createOfferingRequiresResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory <em>Broader Organization Category Categorizes Narrower Organization Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory
	 * @generated
	 */
	public Adapter createBroaderOrganizationCategoryCategorizesNarrowerOrganizationCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.StrategyDeterminesOrganizationUnit <em>Strategy Determines Organization Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.StrategyDeterminesOrganizationUnit
	 * @generated
	 */
	public Adapter createStrategyDeterminesOrganizationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.req.bmm.Bmm.TacticImplementsStrategy <em>Tactic Implements Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.TacticImplementsStrategy
	 * @generated
	 */
	public Adapter createTacticImplementsStrategyAdapter() {
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

} //BmmAdapterFactory
