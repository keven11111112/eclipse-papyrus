/**
 */
package org.eclipse.papyrus.req.bmm.Bmm.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.req.bmm.Bmm.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BmmFactoryImpl extends EFactoryImpl implements BmmFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BmmFactory init() {
		try {
			BmmFactory theBmmFactory = (BmmFactory)EPackage.Registry.INSTANCE.getEFactory(BmmPackage.eNS_URI);
			if (theBmmFactory != null) {
				return theBmmFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BmmFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BmmFactoryImpl() {
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
			case BmmPackage.ASSESSMENT: return createAssessment();
			case BmmPackage.ORGANIZATION_UNIT: return createOrganizationUnit();
			case BmmPackage.STRATEGY: return createStrategy();
			case BmmPackage.COURSE_OF_ACTION: return createCourseOfAction();
			case BmmPackage.MEANS: return createMeans();
			case BmmPackage.DIRECTIVE: return createDirective();
			case BmmPackage.POTENTIAL_IMPACT: return createPotentialImpact();
			case BmmPackage.REGULATION: return createRegulation();
			case BmmPackage.EXTERNAL_INFLUENCER: return createExternalInfluencer();
			case BmmPackage.INFLUENCER: return createInfluencer();
			case BmmPackage.INFLUENCING_ORGANIZATION: return createInfluencingOrganization();
			case BmmPackage.ORGANIZATION_CATEGORY: return createOrganizationCategory();
			case BmmPackage.INFLUENCER_CATEGORY: return createInfluencerCategory();
			case BmmPackage.DESIRED_RESULT: return createDesiredResult();
			case BmmPackage.END: return createEnd();
			case BmmPackage.DESIRED_RESULT_CATEGORY: return createDesiredResultCategory();
			case BmmPackage.ASSET: return createAsset();
			case BmmPackage.BUSINESS_PROCESS: return createBusinessProcess();
			case BmmPackage.BUSINESS_RULE: return createBusinessRule();
			case BmmPackage.BUSINESS_POLICY: return createBusinessPolicy();
			case BmmPackage.TACTIC: return createTactic();
			case BmmPackage.OFFERING: return createOffering();
			case BmmPackage.FIXED_ASSET: return createFixedAsset();
			case BmmPackage.RESOURCE: return createResource();
			case BmmPackage.LIABILITY: return createLiability();
			case BmmPackage.MISSION: return createMission();
			case BmmPackage.VISION: return createVision();
			case BmmPackage.GOAL: return createGoal();
			case BmmPackage.OBJECTIVE: return createObjective();
			case BmmPackage.ASSESSMENT_CATEGORY: return createAssessmentCategory();
			case BmmPackage.INTERNAL_INFLUENCER: return createInternalInfluencer();
			case BmmPackage.POTENTIAL_REWARD: return createPotentialReward();
			case BmmPackage.RISK: return createRisk();
			case BmmPackage.USING_ASSESSMENT_USES_USED_ASSESSMENT: return createUsingAssessmentUsesUsedAssessment();
			case BmmPackage.ORGANIZATION_UNIT_MAKES_ASSESSMENT: return createOrganizationUnitMakesAssessment();
			case BmmPackage.ASSESSMENT_CATEGORY_CATEGORIZES_ASSESSMENT: return createAssessmentCategoryCategorizesAssessment();
			case BmmPackage.ASSESSMENT_IDENTIFIES_POTENTIAL_IMPACT: return createAssessmentIdentifiesPotentialImpact();
			case BmmPackage.ASSESSMENT_AFFECTS_ACHIEVEMENT_OF_END: return createAssessmentAffectsAchievementOfEnd();
			case BmmPackage.ASSESSMENT_AFFECTS_EMPLOYMENT_OF_MEANS: return createAssessmentAffectsEmploymentOfMeans();
			case BmmPackage.ASSESSMENT_PROVIDES_IMPETUS_FOR_DIRECTIVE: return createAssessmentProvidesImpetusForDirective();
			case BmmPackage.ASSESSMENT_IS_JUDGMENT_OF_INFLUENCER: return createAssessmentIsJudgmentOfInfluencer();
			case BmmPackage.BROADER_ASSESSMENT_CATEGORY_CATEGORIZES_NARROWER_ASSESSMENT_CATEGORY: return createBroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory();
			case BmmPackage.BUSINESS_PROCESS_MANAGES_ASSET: return createBusinessProcessManagesAsset();
			case BmmPackage.ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_ASSET: return createOrganizationUnitIsResponsibleForAsset();
			case BmmPackage.COURSE_OF_ACTION_DEPLOYS_ASSET: return createCourseOfActionDeploysAsset();
			case BmmPackage.DIRECTIVE_GOVERNS_USE_OF_ASSET: return createDirectiveGovernsUseOfAsset();
			case BmmPackage.BROADER_BUSINESS_POLICY_INCLUDES_MORE_SPECIFIC_BUSINESS_POLICY: return createBroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy();
			case BmmPackage.BUSINESS_POLICY_IS_BASIS_OF_BUSINESS_RULE: return createBusinessPolicyIsBasisOfBusinessRule();
			case BmmPackage.BUSINESS_POLICY_GOVERNS_BUSINESS_PROCESS: return createBusinessPolicyGovernsBusinessProcess();
			case BmmPackage.ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_BUSINESS_PROCESS: return createOrganizationUnitIsResponsibleForBusinessProcess();
			case BmmPackage.BUSINESS_RULE_GUIDES_BUSINESS_PROCESS: return createBusinessRuleGuidesBusinessProcess();
			case BmmPackage.BUSINESS_PROCESS_REALIZES_COURSE_OF_ACTION: return createBusinessProcessRealizesCourseOfAction();
			case BmmPackage.BUSINESS_PROCESS_DELIVERS_OFFERING: return createBusinessProcessDeliversOffering();
			case BmmPackage.TACTIC_EFFECTS_ENFORCEMENT_LEVEL_OF_BUSINESS_RULE: return createTacticEffectsEnforcementLevelOfBusinessRule();
			case BmmPackage.DIRECTIVE_GOVERNS_COURSE_OF_ACTION: return createDirectiveGovernsCourseOfAction();
			case BmmPackage.BROADER_COURSE_OF_ACTION_INCLUDES_MORE_SPECIFIC_COURSE_OF_ACTION: return createBroaderCourseOfActionIncludesMoreSpecificCourseOfAction();
			case BmmPackage.ENABLING_COURSE_OF_ACTION_ENABLES_ENABLED_COURSE_OF_ACTION: return createEnablingCourseOfActionEnablesEnabledCourseOfAction();
			case BmmPackage.COURSE_OF_ACTION_IS_FORMULATED_BASED_ON_DIRECTIVE: return createCourseOfActionIsFormulatedBasedOnDirective();
			case BmmPackage.COURSE_OF_ACTION_DEFINES_OFFERING: return createCourseOfActionDefinesOffering();
			case BmmPackage.COURSE_OF_ACTION_DISCHARGES_LIABILITY: return createCourseOfActionDischargesLiability();
			case BmmPackage.COURSE_OF_ACTION_CHANNELS_EFFORTS_TOWARDS_DESIRED_RESULT: return createCourseOfActionChannelsEffortsTowardsDesiredResult();
			case BmmPackage.BROADER_DESIRED_RESULT_INCLUDES_MORE_SPECIFIC_DESIRED_RESULT: return createBroaderDesiredResultIncludesMoreSpecificDesiredResult();
			case BmmPackage.DESIRED_RESULT_CATEGORY_CATEGORIZES_DESIRED_RESULT: return createDesiredResultCategoryCategorizesDesiredResult();
			case BmmPackage.DIRECTIVE_SUPPORTS_ACHIEVEMENT_OF_DESIRED_RESULT: return createDirectiveSupportsAchievementOfDesiredResult();
			case BmmPackage.BROADER_DESIRED_CATEGORY_CATEGORIZES_MORE_SPECIFIC_DESIRED_RESULT_CATEGORY: return createBroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory();
			case BmmPackage.POTENTIAL_IMPACT_PROVIDES_IMPETURS_FOR_DIRECTIVE: return createPotentialImpactProvidesImpetursForDirective();
			case BmmPackage.DIRECTIVE_ACTS_AS_REGULATION: return createDirectiveActsAsRegulation();
			case BmmPackage.ORGANIZATION_UNIT_DEFINES_END: return createOrganizationUnitDefinesEnd();
			case BmmPackage.OFFERING_USES_FIXED_ASSET: return createOfferingUsesFixedAsset();
			case BmmPackage.FIXED_ASSET_PROVIDES_RESOURCE: return createFixedAssetProvidesResource();
			case BmmPackage.OBJECTIVE_QUANTITIES_GOAL: return createObjectiveQuantitiesGoal();
			case BmmPackage.GOAL_AMPLIFIES_VISION: return createGoalAmplifiesVision();
			case BmmPackage.ORGANIZATION_UNIT_RECOGNIZES_INFLUENCER: return createOrganizationUnitRecognizesInfluencer();
			case BmmPackage.INFLUENCING_ORGANIZATION_IS_SOURCEOF_INFLUENCER: return createInfluencingOrganizationIsSourceofInfluencer();
			case BmmPackage.INFLUENCER_CATEGORY_CATEGORIZES_INFLUENCER: return createInfluencerCategoryCategorizesInfluencer();
			case BmmPackage.BROADER_INFLUENCER_CATEGORIZES_NARROWER_INFLUENCER_CATEGORY: return createBroaderInfluencerCategorizesNarrowerInfluencerCategory();
			case BmmPackage.ORGANIZATION_CATEGORY_CATEGORIZES_INFLUENCING_ORGANIZATION: return createOrganizationCategoryCategorizesInfluencingOrganization();
			case BmmPackage.ORGANIZATION_UNIT_ACTS_AS_INFLUENCING_ORGANIZATION: return createOrganizationUnitActsAsInfluencingOrganization();
			case BmmPackage.ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_LIABILITY: return createOrganizationUnitIsResponsibleForLiability();
			case BmmPackage.LIABILITY_CLAIMS_RESOURCE: return createLiabilityClaimsResource();
			case BmmPackage.ORGANIZATION_UNIT_ESTABLISHES_MEANS: return createOrganizationUnitEstablishesMeans();
			case BmmPackage.STRATEGY_IS_ACOMPONENTF_OF_THE_PLAN_FOR_MISSION: return createStrategyIsAComponentfOfThe_PlanForMIssion();
			case BmmPackage.MISSION_MAKES_OPERATIVE_VISION: return createMissionMakesOperativeVision();
			case BmmPackage.OFFERING_REQUIRES_RESOURCE: return createOfferingRequiresResource();
			case BmmPackage.BROADER_ORGANIZATION_CATEGORY_CATEGORIZES_NARROWER_ORGANIZATION_CATEGORY: return createBroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory();
			case BmmPackage.STRATEGY_DETERMINES_ORGANIZATION_UNIT: return createStrategyDeterminesOrganizationUnit();
			case BmmPackage.TACTIC_IMPLEMENTS_STRATEGY: return createTacticImplementsStrategy();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assessment createAssessment() {
		AssessmentImpl assessment = new AssessmentImpl();
		return assessment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationUnit createOrganizationUnit() {
		OrganizationUnitImpl organizationUnit = new OrganizationUnitImpl();
		return organizationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Strategy createStrategy() {
		StrategyImpl strategy = new StrategyImpl();
		return strategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CourseOfAction createCourseOfAction() {
		CourseOfActionImpl courseOfAction = new CourseOfActionImpl();
		return courseOfAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Means createMeans() {
		MeansImpl means = new MeansImpl();
		return means;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Directive createDirective() {
		DirectiveImpl directive = new DirectiveImpl();
		return directive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PotentialImpact createPotentialImpact() {
		PotentialImpactImpl potentialImpact = new PotentialImpactImpl();
		return potentialImpact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Regulation createRegulation() {
		RegulationImpl regulation = new RegulationImpl();
		return regulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalInfluencer createExternalInfluencer() {
		ExternalInfluencerImpl externalInfluencer = new ExternalInfluencerImpl();
		return externalInfluencer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Influencer createInfluencer() {
		InfluencerImpl influencer = new InfluencerImpl();
		return influencer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfluencingOrganization createInfluencingOrganization() {
		InfluencingOrganizationImpl influencingOrganization = new InfluencingOrganizationImpl();
		return influencingOrganization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationCategory createOrganizationCategory() {
		OrganizationCategoryImpl organizationCategory = new OrganizationCategoryImpl();
		return organizationCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfluencerCategory createInfluencerCategory() {
		InfluencerCategoryImpl influencerCategory = new InfluencerCategoryImpl();
		return influencerCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DesiredResult createDesiredResult() {
		DesiredResultImpl desiredResult = new DesiredResultImpl();
		return desiredResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public End createEnd() {
		EndImpl end = new EndImpl();
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DesiredResultCategory createDesiredResultCategory() {
		DesiredResultCategoryImpl desiredResultCategory = new DesiredResultCategoryImpl();
		return desiredResultCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Asset createAsset() {
		AssetImpl asset = new AssetImpl();
		return asset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessProcess createBusinessProcess() {
		BusinessProcessImpl businessProcess = new BusinessProcessImpl();
		return businessProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessRule createBusinessRule() {
		BusinessRuleImpl businessRule = new BusinessRuleImpl();
		return businessRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessPolicy createBusinessPolicy() {
		BusinessPolicyImpl businessPolicy = new BusinessPolicyImpl();
		return businessPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tactic createTactic() {
		TacticImpl tactic = new TacticImpl();
		return tactic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Offering createOffering() {
		OfferingImpl offering = new OfferingImpl();
		return offering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedAsset createFixedAsset() {
		FixedAssetImpl fixedAsset = new FixedAssetImpl();
		return fixedAsset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource createResource() {
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Liability createLiability() {
		LiabilityImpl liability = new LiabilityImpl();
		return liability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mission createMission() {
		MissionImpl mission = new MissionImpl();
		return mission;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vision createVision() {
		VisionImpl vision = new VisionImpl();
		return vision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goal createGoal() {
		GoalImpl goal = new GoalImpl();
		return goal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Objective createObjective() {
		ObjectiveImpl objective = new ObjectiveImpl();
		return objective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssessmentCategory createAssessmentCategory() {
		AssessmentCategoryImpl assessmentCategory = new AssessmentCategoryImpl();
		return assessmentCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalInfluencer createInternalInfluencer() {
		InternalInfluencerImpl internalInfluencer = new InternalInfluencerImpl();
		return internalInfluencer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PotentialReward createPotentialReward() {
		PotentialRewardImpl potentialReward = new PotentialRewardImpl();
		return potentialReward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Risk createRisk() {
		RiskImpl risk = new RiskImpl();
		return risk;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsingAssessmentUsesUsedAssessment createUsingAssessmentUsesUsedAssessment() {
		UsingAssessmentUsesUsedAssessmentImpl usingAssessmentUsesUsedAssessment = new UsingAssessmentUsesUsedAssessmentImpl();
		return usingAssessmentUsesUsedAssessment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationUnitMakesAssessment createOrganizationUnitMakesAssessment() {
		OrganizationUnitMakesAssessmentImpl organizationUnitMakesAssessment = new OrganizationUnitMakesAssessmentImpl();
		return organizationUnitMakesAssessment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssessmentCategoryCategorizesAssessment createAssessmentCategoryCategorizesAssessment() {
		AssessmentCategoryCategorizesAssessmentImpl assessmentCategoryCategorizesAssessment = new AssessmentCategoryCategorizesAssessmentImpl();
		return assessmentCategoryCategorizesAssessment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssessmentIdentifiesPotentialImpact createAssessmentIdentifiesPotentialImpact() {
		AssessmentIdentifiesPotentialImpactImpl assessmentIdentifiesPotentialImpact = new AssessmentIdentifiesPotentialImpactImpl();
		return assessmentIdentifiesPotentialImpact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssessmentAffectsAchievementOfEnd createAssessmentAffectsAchievementOfEnd() {
		AssessmentAffectsAchievementOfEndImpl assessmentAffectsAchievementOfEnd = new AssessmentAffectsAchievementOfEndImpl();
		return assessmentAffectsAchievementOfEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssessmentAffectsEmploymentOfMeans createAssessmentAffectsEmploymentOfMeans() {
		AssessmentAffectsEmploymentOfMeansImpl assessmentAffectsEmploymentOfMeans = new AssessmentAffectsEmploymentOfMeansImpl();
		return assessmentAffectsEmploymentOfMeans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssessmentProvidesImpetusForDirective createAssessmentProvidesImpetusForDirective() {
		AssessmentProvidesImpetusForDirectiveImpl assessmentProvidesImpetusForDirective = new AssessmentProvidesImpetusForDirectiveImpl();
		return assessmentProvidesImpetusForDirective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssessmentIsJudgmentOfInfluencer createAssessmentIsJudgmentOfInfluencer() {
		AssessmentIsJudgmentOfInfluencerImpl assessmentIsJudgmentOfInfluencer = new AssessmentIsJudgmentOfInfluencerImpl();
		return assessmentIsJudgmentOfInfluencer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory createBroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory() {
		BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategoryImpl broaderAssessmentCategoryCategorizesNarrowerAssessmentCategory = new BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategoryImpl();
		return broaderAssessmentCategoryCategorizesNarrowerAssessmentCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessProcessManagesAsset createBusinessProcessManagesAsset() {
		BusinessProcessManagesAssetImpl businessProcessManagesAsset = new BusinessProcessManagesAssetImpl();
		return businessProcessManagesAsset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationUnitIsResponsibleForAsset createOrganizationUnitIsResponsibleForAsset() {
		OrganizationUnitIsResponsibleForAssetImpl organizationUnitIsResponsibleForAsset = new OrganizationUnitIsResponsibleForAssetImpl();
		return organizationUnitIsResponsibleForAsset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CourseOfActionDeploysAsset createCourseOfActionDeploysAsset() {
		CourseOfActionDeploysAssetImpl courseOfActionDeploysAsset = new CourseOfActionDeploysAssetImpl();
		return courseOfActionDeploysAsset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectiveGovernsUseOfAsset createDirectiveGovernsUseOfAsset() {
		DirectiveGovernsUseOfAssetImpl directiveGovernsUseOfAsset = new DirectiveGovernsUseOfAssetImpl();
		return directiveGovernsUseOfAsset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy createBroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy() {
		BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicyImpl broaderBusinessPolicyIncludesMoreSpecificBusinessPolicy = new BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicyImpl();
		return broaderBusinessPolicyIncludesMoreSpecificBusinessPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessPolicyIsBasisOfBusinessRule createBusinessPolicyIsBasisOfBusinessRule() {
		BusinessPolicyIsBasisOfBusinessRuleImpl businessPolicyIsBasisOfBusinessRule = new BusinessPolicyIsBasisOfBusinessRuleImpl();
		return businessPolicyIsBasisOfBusinessRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessPolicyGovernsBusinessProcess createBusinessPolicyGovernsBusinessProcess() {
		BusinessPolicyGovernsBusinessProcessImpl businessPolicyGovernsBusinessProcess = new BusinessPolicyGovernsBusinessProcessImpl();
		return businessPolicyGovernsBusinessProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationUnitIsResponsibleForBusinessProcess createOrganizationUnitIsResponsibleForBusinessProcess() {
		OrganizationUnitIsResponsibleForBusinessProcessImpl organizationUnitIsResponsibleForBusinessProcess = new OrganizationUnitIsResponsibleForBusinessProcessImpl();
		return organizationUnitIsResponsibleForBusinessProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessRuleGuidesBusinessProcess createBusinessRuleGuidesBusinessProcess() {
		BusinessRuleGuidesBusinessProcessImpl businessRuleGuidesBusinessProcess = new BusinessRuleGuidesBusinessProcessImpl();
		return businessRuleGuidesBusinessProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessProcessRealizesCourseOfAction createBusinessProcessRealizesCourseOfAction() {
		BusinessProcessRealizesCourseOfActionImpl businessProcessRealizesCourseOfAction = new BusinessProcessRealizesCourseOfActionImpl();
		return businessProcessRealizesCourseOfAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessProcessDeliversOffering createBusinessProcessDeliversOffering() {
		BusinessProcessDeliversOfferingImpl businessProcessDeliversOffering = new BusinessProcessDeliversOfferingImpl();
		return businessProcessDeliversOffering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TacticEffectsEnforcementLevelOfBusinessRule createTacticEffectsEnforcementLevelOfBusinessRule() {
		TacticEffectsEnforcementLevelOfBusinessRuleImpl tacticEffectsEnforcementLevelOfBusinessRule = new TacticEffectsEnforcementLevelOfBusinessRuleImpl();
		return tacticEffectsEnforcementLevelOfBusinessRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectiveGovernsCourseOfAction createDirectiveGovernsCourseOfAction() {
		DirectiveGovernsCourseOfActionImpl directiveGovernsCourseOfAction = new DirectiveGovernsCourseOfActionImpl();
		return directiveGovernsCourseOfAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BroaderCourseOfActionIncludesMoreSpecificCourseOfAction createBroaderCourseOfActionIncludesMoreSpecificCourseOfAction() {
		BroaderCourseOfActionIncludesMoreSpecificCourseOfActionImpl broaderCourseOfActionIncludesMoreSpecificCourseOfAction = new BroaderCourseOfActionIncludesMoreSpecificCourseOfActionImpl();
		return broaderCourseOfActionIncludesMoreSpecificCourseOfAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnablingCourseOfActionEnablesEnabledCourseOfAction createEnablingCourseOfActionEnablesEnabledCourseOfAction() {
		EnablingCourseOfActionEnablesEnabledCourseOfActionImpl enablingCourseOfActionEnablesEnabledCourseOfAction = new EnablingCourseOfActionEnablesEnabledCourseOfActionImpl();
		return enablingCourseOfActionEnablesEnabledCourseOfAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CourseOfActionIsFormulatedBasedOnDirective createCourseOfActionIsFormulatedBasedOnDirective() {
		CourseOfActionIsFormulatedBasedOnDirectiveImpl courseOfActionIsFormulatedBasedOnDirective = new CourseOfActionIsFormulatedBasedOnDirectiveImpl();
		return courseOfActionIsFormulatedBasedOnDirective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CourseOfActionDefinesOffering createCourseOfActionDefinesOffering() {
		CourseOfActionDefinesOfferingImpl courseOfActionDefinesOffering = new CourseOfActionDefinesOfferingImpl();
		return courseOfActionDefinesOffering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CourseOfActionDischargesLiability createCourseOfActionDischargesLiability() {
		CourseOfActionDischargesLiabilityImpl courseOfActionDischargesLiability = new CourseOfActionDischargesLiabilityImpl();
		return courseOfActionDischargesLiability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CourseOfActionChannelsEffortsTowardsDesiredResult createCourseOfActionChannelsEffortsTowardsDesiredResult() {
		CourseOfActionChannelsEffortsTowardsDesiredResultImpl courseOfActionChannelsEffortsTowardsDesiredResult = new CourseOfActionChannelsEffortsTowardsDesiredResultImpl();
		return courseOfActionChannelsEffortsTowardsDesiredResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BroaderDesiredResultIncludesMoreSpecificDesiredResult createBroaderDesiredResultIncludesMoreSpecificDesiredResult() {
		BroaderDesiredResultIncludesMoreSpecificDesiredResultImpl broaderDesiredResultIncludesMoreSpecificDesiredResult = new BroaderDesiredResultIncludesMoreSpecificDesiredResultImpl();
		return broaderDesiredResultIncludesMoreSpecificDesiredResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DesiredResultCategoryCategorizesDesiredResult createDesiredResultCategoryCategorizesDesiredResult() {
		DesiredResultCategoryCategorizesDesiredResultImpl desiredResultCategoryCategorizesDesiredResult = new DesiredResultCategoryCategorizesDesiredResultImpl();
		return desiredResultCategoryCategorizesDesiredResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectiveSupportsAchievementOfDesiredResult createDirectiveSupportsAchievementOfDesiredResult() {
		DirectiveSupportsAchievementOfDesiredResultImpl directiveSupportsAchievementOfDesiredResult = new DirectiveSupportsAchievementOfDesiredResultImpl();
		return directiveSupportsAchievementOfDesiredResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory createBroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory() {
		BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategoryImpl broaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory = new BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategoryImpl();
		return broaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PotentialImpactProvidesImpetursForDirective createPotentialImpactProvidesImpetursForDirective() {
		PotentialImpactProvidesImpetursForDirectiveImpl potentialImpactProvidesImpetursForDirective = new PotentialImpactProvidesImpetursForDirectiveImpl();
		return potentialImpactProvidesImpetursForDirective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectiveActsAsRegulation createDirectiveActsAsRegulation() {
		DirectiveActsAsRegulationImpl directiveActsAsRegulation = new DirectiveActsAsRegulationImpl();
		return directiveActsAsRegulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationUnitDefinesEnd createOrganizationUnitDefinesEnd() {
		OrganizationUnitDefinesEndImpl organizationUnitDefinesEnd = new OrganizationUnitDefinesEndImpl();
		return organizationUnitDefinesEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OfferingUsesFixedAsset createOfferingUsesFixedAsset() {
		OfferingUsesFixedAssetImpl offeringUsesFixedAsset = new OfferingUsesFixedAssetImpl();
		return offeringUsesFixedAsset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedAssetProvidesResource createFixedAssetProvidesResource() {
		FixedAssetProvidesResourceImpl fixedAssetProvidesResource = new FixedAssetProvidesResourceImpl();
		return fixedAssetProvidesResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectiveQuantitiesGoal createObjectiveQuantitiesGoal() {
		ObjectiveQuantitiesGoalImpl objectiveQuantitiesGoal = new ObjectiveQuantitiesGoalImpl();
		return objectiveQuantitiesGoal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoalAmplifiesVision createGoalAmplifiesVision() {
		GoalAmplifiesVisionImpl goalAmplifiesVision = new GoalAmplifiesVisionImpl();
		return goalAmplifiesVision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationUnitRecognizesInfluencer createOrganizationUnitRecognizesInfluencer() {
		OrganizationUnitRecognizesInfluencerImpl organizationUnitRecognizesInfluencer = new OrganizationUnitRecognizesInfluencerImpl();
		return organizationUnitRecognizesInfluencer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfluencingOrganizationIsSourceofInfluencer createInfluencingOrganizationIsSourceofInfluencer() {
		InfluencingOrganizationIsSourceofInfluencerImpl influencingOrganizationIsSourceofInfluencer = new InfluencingOrganizationIsSourceofInfluencerImpl();
		return influencingOrganizationIsSourceofInfluencer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfluencerCategoryCategorizesInfluencer createInfluencerCategoryCategorizesInfluencer() {
		InfluencerCategoryCategorizesInfluencerImpl influencerCategoryCategorizesInfluencer = new InfluencerCategoryCategorizesInfluencerImpl();
		return influencerCategoryCategorizesInfluencer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BroaderInfluencerCategorizesNarrowerInfluencerCategory createBroaderInfluencerCategorizesNarrowerInfluencerCategory() {
		BroaderInfluencerCategorizesNarrowerInfluencerCategoryImpl broaderInfluencerCategorizesNarrowerInfluencerCategory = new BroaderInfluencerCategorizesNarrowerInfluencerCategoryImpl();
		return broaderInfluencerCategorizesNarrowerInfluencerCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationCategoryCategorizesInfluencingOrganization createOrganizationCategoryCategorizesInfluencingOrganization() {
		OrganizationCategoryCategorizesInfluencingOrganizationImpl organizationCategoryCategorizesInfluencingOrganization = new OrganizationCategoryCategorizesInfluencingOrganizationImpl();
		return organizationCategoryCategorizesInfluencingOrganization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationUnitActsAsInfluencingOrganization createOrganizationUnitActsAsInfluencingOrganization() {
		OrganizationUnitActsAsInfluencingOrganizationImpl organizationUnitActsAsInfluencingOrganization = new OrganizationUnitActsAsInfluencingOrganizationImpl();
		return organizationUnitActsAsInfluencingOrganization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationUnitIsResponsibleForLiability createOrganizationUnitIsResponsibleForLiability() {
		OrganizationUnitIsResponsibleForLiabilityImpl organizationUnitIsResponsibleForLiability = new OrganizationUnitIsResponsibleForLiabilityImpl();
		return organizationUnitIsResponsibleForLiability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiabilityClaimsResource createLiabilityClaimsResource() {
		LiabilityClaimsResourceImpl liabilityClaimsResource = new LiabilityClaimsResourceImpl();
		return liabilityClaimsResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationUnitEstablishesMeans createOrganizationUnitEstablishesMeans() {
		OrganizationUnitEstablishesMeansImpl organizationUnitEstablishesMeans = new OrganizationUnitEstablishesMeansImpl();
		return organizationUnitEstablishesMeans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrategyIsAComponentfOfThe_PlanForMIssion createStrategyIsAComponentfOfThe_PlanForMIssion() {
		StrategyIsAComponentfOfThe_PlanForMIssionImpl strategyIsAComponentfOfThe_PlanForMIssion = new StrategyIsAComponentfOfThe_PlanForMIssionImpl();
		return strategyIsAComponentfOfThe_PlanForMIssion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MissionMakesOperativeVision createMissionMakesOperativeVision() {
		MissionMakesOperativeVisionImpl missionMakesOperativeVision = new MissionMakesOperativeVisionImpl();
		return missionMakesOperativeVision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OfferingRequiresResource createOfferingRequiresResource() {
		OfferingRequiresResourceImpl offeringRequiresResource = new OfferingRequiresResourceImpl();
		return offeringRequiresResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory createBroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory() {
		BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategoryImpl broaderOrganizationCategoryCategorizesNarrowerOrganizationCategory = new BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategoryImpl();
		return broaderOrganizationCategoryCategorizesNarrowerOrganizationCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrategyDeterminesOrganizationUnit createStrategyDeterminesOrganizationUnit() {
		StrategyDeterminesOrganizationUnitImpl strategyDeterminesOrganizationUnit = new StrategyDeterminesOrganizationUnitImpl();
		return strategyDeterminesOrganizationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TacticImplementsStrategy createTacticImplementsStrategy() {
		TacticImplementsStrategyImpl tacticImplementsStrategy = new TacticImplementsStrategyImpl();
		return tacticImplementsStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BmmPackage getBmmPackage() {
		return (BmmPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BmmPackage getPackage() {
		return BmmPackage.eINSTANCE;
	}

} //BmmFactoryImpl
