/**
 */
package org.eclipse.papyrus.bmm.BMMProfile.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.bmm.BMMProfile.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.bmm.BMMProfile.BmmPackage
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.MotivationElement <em>Motivation Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.MotivationElement
	 * @generated
	 */
	public Adapter createMotivationElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.Assessment <em>Assessment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.Assessment
	 * @generated
	 */
	public Adapter createAssessmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.OrganizationUnit <em>Organization Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.OrganizationUnit
	 * @generated
	 */
	public Adapter createOrganizationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.Strategy <em>Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.Strategy
	 * @generated
	 */
	public Adapter createStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.CourseOfAction <em>Course Of Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.CourseOfAction
	 * @generated
	 */
	public Adapter createCourseOfActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.Means <em>Means</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.Means
	 * @generated
	 */
	public Adapter createMeansAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.Directive <em>Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.Directive
	 * @generated
	 */
	public Adapter createDirectiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.PotentialImpact <em>Potential Impact</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.PotentialImpact
	 * @generated
	 */
	public Adapter createPotentialImpactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.Regulation <em>Regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.Regulation
	 * @generated
	 */
	public Adapter createRegulationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.ExternalInfluencer <em>External Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.ExternalInfluencer
	 * @generated
	 */
	public Adapter createExternalInfluencerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.Influencer <em>Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.Influencer
	 * @generated
	 */
	public Adapter createInfluencerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.InfluencingOrganization <em>Influencing Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.InfluencingOrganization
	 * @generated
	 */
	public Adapter createInfluencingOrganizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.OrganizationCategory <em>Organization Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.OrganizationCategory
	 * @generated
	 */
	public Adapter createOrganizationCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.InfluencerCategory <em>Influencer Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.InfluencerCategory
	 * @generated
	 */
	public Adapter createInfluencerCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.DesiredResult <em>Desired Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.DesiredResult
	 * @generated
	 */
	public Adapter createDesiredResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.End <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.End
	 * @generated
	 */
	public Adapter createEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.DesiredResultCategory <em>Desired Result Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.DesiredResultCategory
	 * @generated
	 */
	public Adapter createDesiredResultCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.Asset <em>Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.Asset
	 * @generated
	 */
	public Adapter createAssetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.BusinessProcess <em>Business Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.BusinessProcess
	 * @generated
	 */
	public Adapter createBusinessProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.BusinessRule <em>Business Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.BusinessRule
	 * @generated
	 */
	public Adapter createBusinessRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.BusinessPolicy <em>Business Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.BusinessPolicy
	 * @generated
	 */
	public Adapter createBusinessPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.Tactic <em>Tactic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.Tactic
	 * @generated
	 */
	public Adapter createTacticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.Offering <em>Offering</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.Offering
	 * @generated
	 */
	public Adapter createOfferingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.FixedAsset <em>Fixed Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.FixedAsset
	 * @generated
	 */
	public Adapter createFixedAssetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.Liability <em>Liability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.Liability
	 * @generated
	 */
	public Adapter createLiabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.Mission <em>Mission</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.Mission
	 * @generated
	 */
	public Adapter createMissionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.Vision <em>Vision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.Vision
	 * @generated
	 */
	public Adapter createVisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.Goal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.Goal
	 * @generated
	 */
	public Adapter createGoalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.Objective <em>Objective</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.Objective
	 * @generated
	 */
	public Adapter createObjectiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.AssessmentCategory <em>Assessment Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.AssessmentCategory
	 * @generated
	 */
	public Adapter createAssessmentCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.InternalInfluencer <em>Internal Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.InternalInfluencer
	 * @generated
	 */
	public Adapter createInternalInfluencerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.PotentialReward <em>Potential Reward</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.PotentialReward
	 * @generated
	 */
	public Adapter createPotentialRewardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.Risk <em>Risk</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.Risk
	 * @generated
	 */
	public Adapter createRiskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.MotivationEdge <em>Motivation Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.MotivationEdge
	 * @generated
	 */
	public Adapter createMotivationEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.UsingAssessmentUsesUsedAssessment <em>Using Assessment Uses Used Assessment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.UsingAssessmentUsesUsedAssessment
	 * @generated
	 */
	public Adapter createUsingAssessmentUsesUsedAssessmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.OrganizationUnitMakesAssessment <em>Organization Unit Makes Assessment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.OrganizationUnitMakesAssessment
	 * @generated
	 */
	public Adapter createOrganizationUnitMakesAssessmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.AssessmentCategoryCategorizesAssessment <em>Assessment Category Categorizes Assessment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.AssessmentCategoryCategorizesAssessment
	 * @generated
	 */
	public Adapter createAssessmentCategoryCategorizesAssessmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.AssessmentIdentifiesPotentialImpact <em>Assessment Identifies Potential Impact</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.AssessmentIdentifiesPotentialImpact
	 * @generated
	 */
	public Adapter createAssessmentIdentifiesPotentialImpactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.AssessmentAffectsAchievementOfEnd <em>Assessment Affects Achievement Of End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.AssessmentAffectsAchievementOfEnd
	 * @generated
	 */
	public Adapter createAssessmentAffectsAchievementOfEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.AssessmentAffectsEmploymentOfMeans <em>Assessment Affects Employment Of Means</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.AssessmentAffectsEmploymentOfMeans
	 * @generated
	 */
	public Adapter createAssessmentAffectsEmploymentOfMeansAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.AssessmentProvidesImpetusForDirective <em>Assessment Provides Impetus For Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.AssessmentProvidesImpetusForDirective
	 * @generated
	 */
	public Adapter createAssessmentProvidesImpetusForDirectiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.AssessmentIsJudgmentOfInfluencer <em>Assessment Is Judgment Of Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.AssessmentIsJudgmentOfInfluencer
	 * @generated
	 */
	public Adapter createAssessmentIsJudgmentOfInfluencerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory <em>Broader Assessment Category Categorizes Narrower Assessment Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory
	 * @generated
	 */
	public Adapter createBroaderAssessmentCategoryCategorizesNarrowerAssessmentCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.BusinessProcessManagesAsset <em>Business Process Manages Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.BusinessProcessManagesAsset
	 * @generated
	 */
	public Adapter createBusinessProcessManagesAssetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.OrganizationUnitIsResponsibleForAsset <em>Organization Unit Is Responsible For Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.OrganizationUnitIsResponsibleForAsset
	 * @generated
	 */
	public Adapter createOrganizationUnitIsResponsibleForAssetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.CourseOfActionDeploysAsset <em>Course Of Action Deploys Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.CourseOfActionDeploysAsset
	 * @generated
	 */
	public Adapter createCourseOfActionDeploysAssetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.DirectiveGovernsUseOfAsset <em>Directive Governs Use Of Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.DirectiveGovernsUseOfAsset
	 * @generated
	 */
	public Adapter createDirectiveGovernsUseOfAssetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy <em>Broader Business Policy Includes More Specific Business Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy
	 * @generated
	 */
	public Adapter createBroaderBusinessPolicyIncludesMoreSpecificBusinessPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.BusinessPolicyIsBasisOfBusinessRule <em>Business Policy Is Basis Of Business Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.BusinessPolicyIsBasisOfBusinessRule
	 * @generated
	 */
	public Adapter createBusinessPolicyIsBasisOfBusinessRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.BusinessPolicyGovernsBusinessProcess <em>Business Policy Governs Business Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.BusinessPolicyGovernsBusinessProcess
	 * @generated
	 */
	public Adapter createBusinessPolicyGovernsBusinessProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.OrganizationUnitIsResponsibleForBusinessProcess <em>Organization Unit Is Responsible For Business Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.OrganizationUnitIsResponsibleForBusinessProcess
	 * @generated
	 */
	public Adapter createOrganizationUnitIsResponsibleForBusinessProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.BusinessRuleGuidesBusinessProcess <em>Business Rule Guides Business Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.BusinessRuleGuidesBusinessProcess
	 * @generated
	 */
	public Adapter createBusinessRuleGuidesBusinessProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.BusinessProcessRealizesCourseOfAction <em>Business Process Realizes Course Of Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.BusinessProcessRealizesCourseOfAction
	 * @generated
	 */
	public Adapter createBusinessProcessRealizesCourseOfActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.BusinessProcessDeliversOffering <em>Business Process Delivers Offering</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.BusinessProcessDeliversOffering
	 * @generated
	 */
	public Adapter createBusinessProcessDeliversOfferingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.TacticEffectsEnforcementLevelOfBusinessRule <em>Tactic Effects Enforcement Level Of Business Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.TacticEffectsEnforcementLevelOfBusinessRule
	 * @generated
	 */
	public Adapter createTacticEffectsEnforcementLevelOfBusinessRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.DirectiveGovernsCourseOfAction <em>Directive Governs Course Of Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.DirectiveGovernsCourseOfAction
	 * @generated
	 */
	public Adapter createDirectiveGovernsCourseOfActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.BroaderCourseOfActionIncludesMoreSpecificCourseOfAction <em>Broader Course Of Action Includes More Specific Course Of Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.BroaderCourseOfActionIncludesMoreSpecificCourseOfAction
	 * @generated
	 */
	public Adapter createBroaderCourseOfActionIncludesMoreSpecificCourseOfActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.EnablingCourseOfActionEnablesEnabledCourseOfAction <em>Enabling Course Of Action Enables Enabled Course Of Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.EnablingCourseOfActionEnablesEnabledCourseOfAction
	 * @generated
	 */
	public Adapter createEnablingCourseOfActionEnablesEnabledCourseOfActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.CourseOfActionIsFormulatedBasedOnDirective <em>Course Of Action Is Formulated Based On Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.CourseOfActionIsFormulatedBasedOnDirective
	 * @generated
	 */
	public Adapter createCourseOfActionIsFormulatedBasedOnDirectiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.CourseOfActionDefinesOffering <em>Course Of Action Defines Offering</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.CourseOfActionDefinesOffering
	 * @generated
	 */
	public Adapter createCourseOfActionDefinesOfferingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.CourseOfActionDischargesLiability <em>Course Of Action Discharges Liability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.CourseOfActionDischargesLiability
	 * @generated
	 */
	public Adapter createCourseOfActionDischargesLiabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.CourseOfActionChannelsEffortsTowardsDesiredResult <em>Course Of Action Channels Efforts Towards Desired Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.CourseOfActionChannelsEffortsTowardsDesiredResult
	 * @generated
	 */
	public Adapter createCourseOfActionChannelsEffortsTowardsDesiredResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.BroaderDesiredResultIncludesMoreSpecificDesiredResult <em>Broader Desired Result Includes More Specific Desired Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.BroaderDesiredResultIncludesMoreSpecificDesiredResult
	 * @generated
	 */
	public Adapter createBroaderDesiredResultIncludesMoreSpecificDesiredResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.DesiredResultCategoryCategorizesDesiredResult <em>Desired Result Category Categorizes Desired Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.DesiredResultCategoryCategorizesDesiredResult
	 * @generated
	 */
	public Adapter createDesiredResultCategoryCategorizesDesiredResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.DirectiveSupportsAchievementOfDesiredResult <em>Directive Supports Achievement Of Desired Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.DirectiveSupportsAchievementOfDesiredResult
	 * @generated
	 */
	public Adapter createDirectiveSupportsAchievementOfDesiredResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory <em>Broader Desired Category Categorizes More Specific Desired Result Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory
	 * @generated
	 */
	public Adapter createBroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.PotentialImpactProvidesImpetursForDirective <em>Potential Impact Provides Impeturs For Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.PotentialImpactProvidesImpetursForDirective
	 * @generated
	 */
	public Adapter createPotentialImpactProvidesImpetursForDirectiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.DirectiveActsAsRegulation <em>Directive Acts As Regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.DirectiveActsAsRegulation
	 * @generated
	 */
	public Adapter createDirectiveActsAsRegulationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.OrganizationUnitDefinesEnd <em>Organization Unit Defines End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.OrganizationUnitDefinesEnd
	 * @generated
	 */
	public Adapter createOrganizationUnitDefinesEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.OfferingUsesFixedAsset <em>Offering Uses Fixed Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.OfferingUsesFixedAsset
	 * @generated
	 */
	public Adapter createOfferingUsesFixedAssetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.FixedAssetProvidesResource <em>Fixed Asset Provides Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.FixedAssetProvidesResource
	 * @generated
	 */
	public Adapter createFixedAssetProvidesResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.ObjectiveQuantitiesGoal <em>Objective Quantities Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.ObjectiveQuantitiesGoal
	 * @generated
	 */
	public Adapter createObjectiveQuantitiesGoalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.GoalAmplifiesVision <em>Goal Amplifies Vision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.GoalAmplifiesVision
	 * @generated
	 */
	public Adapter createGoalAmplifiesVisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.OrganizationUnitRecognizesInfluencer <em>Organization Unit Recognizes Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.OrganizationUnitRecognizesInfluencer
	 * @generated
	 */
	public Adapter createOrganizationUnitRecognizesInfluencerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.InfluencingOrganizationIsSourceofInfluencer <em>Influencing Organization Is Sourceof Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.InfluencingOrganizationIsSourceofInfluencer
	 * @generated
	 */
	public Adapter createInfluencingOrganizationIsSourceofInfluencerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.InfluencerCategoryCategorizesInfluencer <em>Influencer Category Categorizes Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.InfluencerCategoryCategorizesInfluencer
	 * @generated
	 */
	public Adapter createInfluencerCategoryCategorizesInfluencerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.BroaderInfluencerCategorizesNarrowerInfluencerCategory <em>Broader Influencer Categorizes Narrower Influencer Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.BroaderInfluencerCategorizesNarrowerInfluencerCategory
	 * @generated
	 */
	public Adapter createBroaderInfluencerCategorizesNarrowerInfluencerCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.OrganizationCategoryCategorizesInfluencingOrganization <em>Organization Category Categorizes Influencing Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.OrganizationCategoryCategorizesInfluencingOrganization
	 * @generated
	 */
	public Adapter createOrganizationCategoryCategorizesInfluencingOrganizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.OrganizationUnitActsAsInfluencingOrganization <em>Organization Unit Acts As Influencing Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.OrganizationUnitActsAsInfluencingOrganization
	 * @generated
	 */
	public Adapter createOrganizationUnitActsAsInfluencingOrganizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.OrganizationUnitIsResponsibleForLiability <em>Organization Unit Is Responsible For Liability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.OrganizationUnitIsResponsibleForLiability
	 * @generated
	 */
	public Adapter createOrganizationUnitIsResponsibleForLiabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.LiabilityClaimsResource <em>Liability Claims Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.LiabilityClaimsResource
	 * @generated
	 */
	public Adapter createLiabilityClaimsResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.OrganizationUnitEstablishesMeans <em>Organization Unit Establishes Means</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.OrganizationUnitEstablishesMeans
	 * @generated
	 */
	public Adapter createOrganizationUnitEstablishesMeansAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.StrategyIsAComponentfOfThe_PlanForMIssion <em>Strategy Is AComponentf Of The Plan For MIssion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.StrategyIsAComponentfOfThe_PlanForMIssion
	 * @generated
	 */
	public Adapter createStrategyIsAComponentfOfThe_PlanForMIssionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.MissionMakesOperativeVision <em>Mission Makes Operative Vision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.MissionMakesOperativeVision
	 * @generated
	 */
	public Adapter createMissionMakesOperativeVisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.OfferingRequiresResource <em>Offering Requires Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.OfferingRequiresResource
	 * @generated
	 */
	public Adapter createOfferingRequiresResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory <em>Broader Organization Category Categorizes Narrower Organization Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory
	 * @generated
	 */
	public Adapter createBroaderOrganizationCategoryCategorizesNarrowerOrganizationCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.StrategyDeterminesOrganizationUnit <em>Strategy Determines Organization Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.StrategyDeterminesOrganizationUnit
	 * @generated
	 */
	public Adapter createStrategyDeterminesOrganizationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.bmm.BMMProfile.TacticImplementsStrategy <em>Tactic Implements Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.bmm.BMMProfile.TacticImplementsStrategy
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
