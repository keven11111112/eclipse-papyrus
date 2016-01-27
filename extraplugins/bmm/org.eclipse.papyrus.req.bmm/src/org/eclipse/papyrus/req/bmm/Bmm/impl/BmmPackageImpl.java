/**
 */
package org.eclipse.papyrus.req.bmm.Bmm.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.req.bmm.Bmm.Assessment;
import org.eclipse.papyrus.req.bmm.Bmm.AssessmentAffectsAchievementOfEnd;
import org.eclipse.papyrus.req.bmm.Bmm.AssessmentAffectsEmploymentOfMeans;
import org.eclipse.papyrus.req.bmm.Bmm.AssessmentCategory;
import org.eclipse.papyrus.req.bmm.Bmm.AssessmentCategoryCategorizesAssessment;
import org.eclipse.papyrus.req.bmm.Bmm.AssessmentIdentifiesPotentialImpact;
import org.eclipse.papyrus.req.bmm.Bmm.AssessmentIsJudgmentOfInfluencer;
import org.eclipse.papyrus.req.bmm.Bmm.AssessmentProvidesImpetusForDirective;
import org.eclipse.papyrus.req.bmm.Bmm.Asset;
import org.eclipse.papyrus.req.bmm.Bmm.BmmFactory;
import org.eclipse.papyrus.req.bmm.Bmm.BmmPackage;
import org.eclipse.papyrus.req.bmm.Bmm.BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory;
import org.eclipse.papyrus.req.bmm.Bmm.BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy;
import org.eclipse.papyrus.req.bmm.Bmm.BroaderCourseOfActionIncludesMoreSpecificCourseOfAction;
import org.eclipse.papyrus.req.bmm.Bmm.BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory;
import org.eclipse.papyrus.req.bmm.Bmm.BroaderDesiredResultIncludesMoreSpecificDesiredResult;
import org.eclipse.papyrus.req.bmm.Bmm.BroaderInfluencerCategorizesNarrowerInfluencerCategory;
import org.eclipse.papyrus.req.bmm.Bmm.BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory;
import org.eclipse.papyrus.req.bmm.Bmm.BusinessPolicy;
import org.eclipse.papyrus.req.bmm.Bmm.BusinessPolicyGovernsBusinessProcess;
import org.eclipse.papyrus.req.bmm.Bmm.BusinessPolicyIsBasisOfBusinessRule;
import org.eclipse.papyrus.req.bmm.Bmm.BusinessProcess;
import org.eclipse.papyrus.req.bmm.Bmm.BusinessProcessDeliversOffering;
import org.eclipse.papyrus.req.bmm.Bmm.BusinessProcessManagesAsset;
import org.eclipse.papyrus.req.bmm.Bmm.BusinessProcessRealizesCourseOfAction;
import org.eclipse.papyrus.req.bmm.Bmm.BusinessRule;
import org.eclipse.papyrus.req.bmm.Bmm.BusinessRuleGuidesBusinessProcess;
import org.eclipse.papyrus.req.bmm.Bmm.CourseOfAction;
import org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionChannelsEffortsTowardsDesiredResult;
import org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionDefinesOffering;
import org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionDeploysAsset;
import org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionDischargesLiability;
import org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionIsFormulatedBasedOnDirective;
import org.eclipse.papyrus.req.bmm.Bmm.DesiredResult;
import org.eclipse.papyrus.req.bmm.Bmm.DesiredResultCategory;
import org.eclipse.papyrus.req.bmm.Bmm.DesiredResultCategoryCategorizesDesiredResult;
import org.eclipse.papyrus.req.bmm.Bmm.Directive;
import org.eclipse.papyrus.req.bmm.Bmm.DirectiveActsAsRegulation;
import org.eclipse.papyrus.req.bmm.Bmm.DirectiveGovernsCourseOfAction;
import org.eclipse.papyrus.req.bmm.Bmm.DirectiveGovernsUseOfAsset;
import org.eclipse.papyrus.req.bmm.Bmm.DirectiveSupportsAchievementOfDesiredResult;
import org.eclipse.papyrus.req.bmm.Bmm.EnablingCourseOfActionEnablesEnabledCourseOfAction;
import org.eclipse.papyrus.req.bmm.Bmm.End;
import org.eclipse.papyrus.req.bmm.Bmm.ExternalInfluencer;
import org.eclipse.papyrus.req.bmm.Bmm.FixedAsset;
import org.eclipse.papyrus.req.bmm.Bmm.FixedAssetProvidesResource;
import org.eclipse.papyrus.req.bmm.Bmm.Goal;
import org.eclipse.papyrus.req.bmm.Bmm.GoalAmplifiesVision;
import org.eclipse.papyrus.req.bmm.Bmm.Influencer;
import org.eclipse.papyrus.req.bmm.Bmm.InfluencerCategory;
import org.eclipse.papyrus.req.bmm.Bmm.InfluencerCategoryCategorizesInfluencer;
import org.eclipse.papyrus.req.bmm.Bmm.InfluencingOrganization;
import org.eclipse.papyrus.req.bmm.Bmm.InfluencingOrganizationIsSourceofInfluencer;
import org.eclipse.papyrus.req.bmm.Bmm.InternalInfluencer;
import org.eclipse.papyrus.req.bmm.Bmm.Liability;
import org.eclipse.papyrus.req.bmm.Bmm.LiabilityClaimsResource;
import org.eclipse.papyrus.req.bmm.Bmm.Means;
import org.eclipse.papyrus.req.bmm.Bmm.Mission;
import org.eclipse.papyrus.req.bmm.Bmm.MissionMakesOperativeVision;
import org.eclipse.papyrus.req.bmm.Bmm.MotivationEdge;
import org.eclipse.papyrus.req.bmm.Bmm.MotivationElement;
import org.eclipse.papyrus.req.bmm.Bmm.Objective;
import org.eclipse.papyrus.req.bmm.Bmm.ObjectiveQuantitiesGoal;
import org.eclipse.papyrus.req.bmm.Bmm.Offering;
import org.eclipse.papyrus.req.bmm.Bmm.OfferingRequiresResource;
import org.eclipse.papyrus.req.bmm.Bmm.OfferingUsesFixedAsset;
import org.eclipse.papyrus.req.bmm.Bmm.OrganizationCategory;
import org.eclipse.papyrus.req.bmm.Bmm.OrganizationCategoryCategorizesInfluencingOrganization;
import org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnit;
import org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitActsAsInfluencingOrganization;
import org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitDefinesEnd;
import org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitEstablishesMeans;
import org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitIsResponsibleForAsset;
import org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitIsResponsibleForBusinessProcess;
import org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitIsResponsibleForLiability;
import org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitMakesAssessment;
import org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitRecognizesInfluencer;
import org.eclipse.papyrus.req.bmm.Bmm.PotentialImpact;
import org.eclipse.papyrus.req.bmm.Bmm.PotentialImpactProvidesImpetursForDirective;
import org.eclipse.papyrus.req.bmm.Bmm.PotentialReward;
import org.eclipse.papyrus.req.bmm.Bmm.Regulation;
import org.eclipse.papyrus.req.bmm.Bmm.Resource;
import org.eclipse.papyrus.req.bmm.Bmm.Risk;
import org.eclipse.papyrus.req.bmm.Bmm.Strategy;
import org.eclipse.papyrus.req.bmm.Bmm.StrategyDeterminesOrganizationUnit;
import org.eclipse.papyrus.req.bmm.Bmm.StrategyIsAComponentfOfThe_PlanForMIssion;
import org.eclipse.papyrus.req.bmm.Bmm.Tactic;
import org.eclipse.papyrus.req.bmm.Bmm.TacticEffectsEnforcementLevelOfBusinessRule;
import org.eclipse.papyrus.req.bmm.Bmm.TacticImplementsStrategy;
import org.eclipse.papyrus.req.bmm.Bmm.UsingAssessmentUsesUsedAssessment;
import org.eclipse.papyrus.req.bmm.Bmm.Vision;

import org.eclipse.uml2.types.TypesPackage;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BmmPackageImpl extends EPackageImpl implements BmmPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass motivationElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assessmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass organizationUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass strategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass courseOfActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass meansEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass potentialImpactEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regulationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalInfluencerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass influencerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass influencingOrganizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass organizationCategoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass influencerCategoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass desiredResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass desiredResultCategoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass businessProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass businessRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass businessPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tacticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass offeringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fixedAssetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass liabilityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass missionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass goalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assessmentCategoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalInfluencerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass potentialRewardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass riskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass motivationEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass usingAssessmentUsesUsedAssessmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass organizationUnitMakesAssessmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assessmentCategoryCategorizesAssessmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assessmentIdentifiesPotentialImpactEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assessmentAffectsAchievementOfEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assessmentAffectsEmploymentOfMeansEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assessmentProvidesImpetusForDirectiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assessmentIsJudgmentOfInfluencerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass broaderAssessmentCategoryCategorizesNarrowerAssessmentCategoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass businessProcessManagesAssetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass organizationUnitIsResponsibleForAssetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass courseOfActionDeploysAssetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directiveGovernsUseOfAssetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass broaderBusinessPolicyIncludesMoreSpecificBusinessPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass businessPolicyIsBasisOfBusinessRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass businessPolicyGovernsBusinessProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass organizationUnitIsResponsibleForBusinessProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass businessRuleGuidesBusinessProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass businessProcessRealizesCourseOfActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass businessProcessDeliversOfferingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tacticEffectsEnforcementLevelOfBusinessRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directiveGovernsCourseOfActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass broaderCourseOfActionIncludesMoreSpecificCourseOfActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enablingCourseOfActionEnablesEnabledCourseOfActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass courseOfActionIsFormulatedBasedOnDirectiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass courseOfActionDefinesOfferingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass courseOfActionDischargesLiabilityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass courseOfActionChannelsEffortsTowardsDesiredResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass broaderDesiredResultIncludesMoreSpecificDesiredResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass desiredResultCategoryCategorizesDesiredResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directiveSupportsAchievementOfDesiredResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass broaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass potentialImpactProvidesImpetursForDirectiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directiveActsAsRegulationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass organizationUnitDefinesEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass offeringUsesFixedAssetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fixedAssetProvidesResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectiveQuantitiesGoalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass goalAmplifiesVisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass organizationUnitRecognizesInfluencerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass influencingOrganizationIsSourceofInfluencerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass influencerCategoryCategorizesInfluencerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass broaderInfluencerCategorizesNarrowerInfluencerCategoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass organizationCategoryCategorizesInfluencingOrganizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass organizationUnitActsAsInfluencingOrganizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass organizationUnitIsResponsibleForLiabilityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass liabilityClaimsResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass organizationUnitEstablishesMeansEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass strategyIsAComponentfOfThe_PlanForMIssionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass missionMakesOperativeVisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass offeringRequiresResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass broaderOrganizationCategoryCategorizesNarrowerOrganizationCategoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass strategyDeterminesOrganizationUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tacticImplementsStrategyEClass = null;

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
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BmmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BmmPackageImpl() {
		super(eNS_URI, BmmFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BmmPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BmmPackage init() {
		if (isInited) return (BmmPackage)EPackage.Registry.INSTANCE.getEPackage(BmmPackage.eNS_URI);

		// Obtain or create and register package
		BmmPackageImpl theBmmPackage = (BmmPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BmmPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BmmPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theBmmPackage.createPackageContents();

		// Initialize created meta-data
		theBmmPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBmmPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BmmPackage.eNS_URI, theBmmPackage);
		return theBmmPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMotivationElement() {
		return motivationElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMotivationElement_Description() {
		return (EAttribute)motivationElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMotivationElement_Base_Artifact() {
		return (EReference)motivationElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssessment() {
		return assessmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrganizationUnit() {
		return organizationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStrategy() {
		return strategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCourseOfAction() {
		return courseOfActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeans() {
		return meansEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirective() {
		return directiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPotentialImpact() {
		return potentialImpactEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegulation() {
		return regulationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalInfluencer() {
		return externalInfluencerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInfluencer() {
		return influencerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInfluencingOrganization() {
		return influencingOrganizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrganizationCategory() {
		return organizationCategoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInfluencerCategory() {
		return influencerCategoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDesiredResult() {
		return desiredResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnd() {
		return endEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDesiredResultCategory() {
		return desiredResultCategoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAsset() {
		return assetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusinessProcess() {
		return businessProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusinessRule() {
		return businessRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusinessPolicy() {
		return businessPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTactic() {
		return tacticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOffering() {
		return offeringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFixedAsset() {
		return fixedAssetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResource() {
		return resourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLiability() {
		return liabilityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMission() {
		return missionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVision() {
		return visionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGoal() {
		return goalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjective() {
		return objectiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssessmentCategory() {
		return assessmentCategoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalInfluencer() {
		return internalInfluencerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPotentialReward() {
		return potentialRewardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRisk() {
		return riskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMotivationEdge() {
		return motivationEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMotivationEdge_Base_Dependency() {
		return (EReference)motivationEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUsingAssessmentUsesUsedAssessment() {
		return usingAssessmentUsesUsedAssessmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrganizationUnitMakesAssessment() {
		return organizationUnitMakesAssessmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssessmentCategoryCategorizesAssessment() {
		return assessmentCategoryCategorizesAssessmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssessmentIdentifiesPotentialImpact() {
		return assessmentIdentifiesPotentialImpactEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssessmentAffectsAchievementOfEnd() {
		return assessmentAffectsAchievementOfEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssessmentAffectsEmploymentOfMeans() {
		return assessmentAffectsEmploymentOfMeansEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssessmentProvidesImpetusForDirective() {
		return assessmentProvidesImpetusForDirectiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssessmentIsJudgmentOfInfluencer() {
		return assessmentIsJudgmentOfInfluencerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory() {
		return broaderAssessmentCategoryCategorizesNarrowerAssessmentCategoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusinessProcessManagesAsset() {
		return businessProcessManagesAssetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrganizationUnitIsResponsibleForAsset() {
		return organizationUnitIsResponsibleForAssetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCourseOfActionDeploysAsset() {
		return courseOfActionDeploysAssetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectiveGovernsUseOfAsset() {
		return directiveGovernsUseOfAssetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy() {
		return broaderBusinessPolicyIncludesMoreSpecificBusinessPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusinessPolicyIsBasisOfBusinessRule() {
		return businessPolicyIsBasisOfBusinessRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusinessPolicyGovernsBusinessProcess() {
		return businessPolicyGovernsBusinessProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrganizationUnitIsResponsibleForBusinessProcess() {
		return organizationUnitIsResponsibleForBusinessProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusinessRuleGuidesBusinessProcess() {
		return businessRuleGuidesBusinessProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusinessProcessRealizesCourseOfAction() {
		return businessProcessRealizesCourseOfActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusinessProcessDeliversOffering() {
		return businessProcessDeliversOfferingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTacticEffectsEnforcementLevelOfBusinessRule() {
		return tacticEffectsEnforcementLevelOfBusinessRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectiveGovernsCourseOfAction() {
		return directiveGovernsCourseOfActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBroaderCourseOfActionIncludesMoreSpecificCourseOfAction() {
		return broaderCourseOfActionIncludesMoreSpecificCourseOfActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnablingCourseOfActionEnablesEnabledCourseOfAction() {
		return enablingCourseOfActionEnablesEnabledCourseOfActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCourseOfActionIsFormulatedBasedOnDirective() {
		return courseOfActionIsFormulatedBasedOnDirectiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCourseOfActionDefinesOffering() {
		return courseOfActionDefinesOfferingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCourseOfActionDischargesLiability() {
		return courseOfActionDischargesLiabilityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCourseOfActionChannelsEffortsTowardsDesiredResult() {
		return courseOfActionChannelsEffortsTowardsDesiredResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBroaderDesiredResultIncludesMoreSpecificDesiredResult() {
		return broaderDesiredResultIncludesMoreSpecificDesiredResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDesiredResultCategoryCategorizesDesiredResult() {
		return desiredResultCategoryCategorizesDesiredResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectiveSupportsAchievementOfDesiredResult() {
		return directiveSupportsAchievementOfDesiredResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory() {
		return broaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPotentialImpactProvidesImpetursForDirective() {
		return potentialImpactProvidesImpetursForDirectiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectiveActsAsRegulation() {
		return directiveActsAsRegulationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrganizationUnitDefinesEnd() {
		return organizationUnitDefinesEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOfferingUsesFixedAsset() {
		return offeringUsesFixedAssetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFixedAssetProvidesResource() {
		return fixedAssetProvidesResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectiveQuantitiesGoal() {
		return objectiveQuantitiesGoalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGoalAmplifiesVision() {
		return goalAmplifiesVisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrganizationUnitRecognizesInfluencer() {
		return organizationUnitRecognizesInfluencerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInfluencingOrganizationIsSourceofInfluencer() {
		return influencingOrganizationIsSourceofInfluencerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInfluencerCategoryCategorizesInfluencer() {
		return influencerCategoryCategorizesInfluencerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBroaderInfluencerCategorizesNarrowerInfluencerCategory() {
		return broaderInfluencerCategorizesNarrowerInfluencerCategoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrganizationCategoryCategorizesInfluencingOrganization() {
		return organizationCategoryCategorizesInfluencingOrganizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrganizationUnitActsAsInfluencingOrganization() {
		return organizationUnitActsAsInfluencingOrganizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrganizationUnitIsResponsibleForLiability() {
		return organizationUnitIsResponsibleForLiabilityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLiabilityClaimsResource() {
		return liabilityClaimsResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrganizationUnitEstablishesMeans() {
		return organizationUnitEstablishesMeansEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStrategyIsAComponentfOfThe_PlanForMIssion() {
		return strategyIsAComponentfOfThe_PlanForMIssionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMissionMakesOperativeVision() {
		return missionMakesOperativeVisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOfferingRequiresResource() {
		return offeringRequiresResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory() {
		return broaderOrganizationCategoryCategorizesNarrowerOrganizationCategoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStrategyDeterminesOrganizationUnit() {
		return strategyDeterminesOrganizationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTacticImplementsStrategy() {
		return tacticImplementsStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BmmFactory getBmmFactory() {
		return (BmmFactory)getEFactoryInstance();
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
		motivationElementEClass = createEClass(MOTIVATION_ELEMENT);
		createEAttribute(motivationElementEClass, MOTIVATION_ELEMENT__DESCRIPTION);
		createEReference(motivationElementEClass, MOTIVATION_ELEMENT__BASE_ARTIFACT);

		assessmentEClass = createEClass(ASSESSMENT);

		organizationUnitEClass = createEClass(ORGANIZATION_UNIT);

		strategyEClass = createEClass(STRATEGY);

		courseOfActionEClass = createEClass(COURSE_OF_ACTION);

		meansEClass = createEClass(MEANS);

		directiveEClass = createEClass(DIRECTIVE);

		potentialImpactEClass = createEClass(POTENTIAL_IMPACT);

		regulationEClass = createEClass(REGULATION);

		externalInfluencerEClass = createEClass(EXTERNAL_INFLUENCER);

		influencerEClass = createEClass(INFLUENCER);

		influencingOrganizationEClass = createEClass(INFLUENCING_ORGANIZATION);

		organizationCategoryEClass = createEClass(ORGANIZATION_CATEGORY);

		influencerCategoryEClass = createEClass(INFLUENCER_CATEGORY);

		desiredResultEClass = createEClass(DESIRED_RESULT);

		endEClass = createEClass(END);

		desiredResultCategoryEClass = createEClass(DESIRED_RESULT_CATEGORY);

		assetEClass = createEClass(ASSET);

		businessProcessEClass = createEClass(BUSINESS_PROCESS);

		businessRuleEClass = createEClass(BUSINESS_RULE);

		businessPolicyEClass = createEClass(BUSINESS_POLICY);

		tacticEClass = createEClass(TACTIC);

		offeringEClass = createEClass(OFFERING);

		fixedAssetEClass = createEClass(FIXED_ASSET);

		resourceEClass = createEClass(RESOURCE);

		liabilityEClass = createEClass(LIABILITY);

		missionEClass = createEClass(MISSION);

		visionEClass = createEClass(VISION);

		goalEClass = createEClass(GOAL);

		objectiveEClass = createEClass(OBJECTIVE);

		assessmentCategoryEClass = createEClass(ASSESSMENT_CATEGORY);

		internalInfluencerEClass = createEClass(INTERNAL_INFLUENCER);

		potentialRewardEClass = createEClass(POTENTIAL_REWARD);

		riskEClass = createEClass(RISK);

		motivationEdgeEClass = createEClass(MOTIVATION_EDGE);
		createEReference(motivationEdgeEClass, MOTIVATION_EDGE__BASE_DEPENDENCY);

		usingAssessmentUsesUsedAssessmentEClass = createEClass(USING_ASSESSMENT_USES_USED_ASSESSMENT);

		organizationUnitMakesAssessmentEClass = createEClass(ORGANIZATION_UNIT_MAKES_ASSESSMENT);

		assessmentCategoryCategorizesAssessmentEClass = createEClass(ASSESSMENT_CATEGORY_CATEGORIZES_ASSESSMENT);

		assessmentIdentifiesPotentialImpactEClass = createEClass(ASSESSMENT_IDENTIFIES_POTENTIAL_IMPACT);

		assessmentAffectsAchievementOfEndEClass = createEClass(ASSESSMENT_AFFECTS_ACHIEVEMENT_OF_END);

		assessmentAffectsEmploymentOfMeansEClass = createEClass(ASSESSMENT_AFFECTS_EMPLOYMENT_OF_MEANS);

		assessmentProvidesImpetusForDirectiveEClass = createEClass(ASSESSMENT_PROVIDES_IMPETUS_FOR_DIRECTIVE);

		assessmentIsJudgmentOfInfluencerEClass = createEClass(ASSESSMENT_IS_JUDGMENT_OF_INFLUENCER);

		broaderAssessmentCategoryCategorizesNarrowerAssessmentCategoryEClass = createEClass(BROADER_ASSESSMENT_CATEGORY_CATEGORIZES_NARROWER_ASSESSMENT_CATEGORY);

		businessProcessManagesAssetEClass = createEClass(BUSINESS_PROCESS_MANAGES_ASSET);

		organizationUnitIsResponsibleForAssetEClass = createEClass(ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_ASSET);

		courseOfActionDeploysAssetEClass = createEClass(COURSE_OF_ACTION_DEPLOYS_ASSET);

		directiveGovernsUseOfAssetEClass = createEClass(DIRECTIVE_GOVERNS_USE_OF_ASSET);

		broaderBusinessPolicyIncludesMoreSpecificBusinessPolicyEClass = createEClass(BROADER_BUSINESS_POLICY_INCLUDES_MORE_SPECIFIC_BUSINESS_POLICY);

		businessPolicyIsBasisOfBusinessRuleEClass = createEClass(BUSINESS_POLICY_IS_BASIS_OF_BUSINESS_RULE);

		businessPolicyGovernsBusinessProcessEClass = createEClass(BUSINESS_POLICY_GOVERNS_BUSINESS_PROCESS);

		organizationUnitIsResponsibleForBusinessProcessEClass = createEClass(ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_BUSINESS_PROCESS);

		businessRuleGuidesBusinessProcessEClass = createEClass(BUSINESS_RULE_GUIDES_BUSINESS_PROCESS);

		businessProcessRealizesCourseOfActionEClass = createEClass(BUSINESS_PROCESS_REALIZES_COURSE_OF_ACTION);

		businessProcessDeliversOfferingEClass = createEClass(BUSINESS_PROCESS_DELIVERS_OFFERING);

		tacticEffectsEnforcementLevelOfBusinessRuleEClass = createEClass(TACTIC_EFFECTS_ENFORCEMENT_LEVEL_OF_BUSINESS_RULE);

		directiveGovernsCourseOfActionEClass = createEClass(DIRECTIVE_GOVERNS_COURSE_OF_ACTION);

		broaderCourseOfActionIncludesMoreSpecificCourseOfActionEClass = createEClass(BROADER_COURSE_OF_ACTION_INCLUDES_MORE_SPECIFIC_COURSE_OF_ACTION);

		enablingCourseOfActionEnablesEnabledCourseOfActionEClass = createEClass(ENABLING_COURSE_OF_ACTION_ENABLES_ENABLED_COURSE_OF_ACTION);

		courseOfActionIsFormulatedBasedOnDirectiveEClass = createEClass(COURSE_OF_ACTION_IS_FORMULATED_BASED_ON_DIRECTIVE);

		courseOfActionDefinesOfferingEClass = createEClass(COURSE_OF_ACTION_DEFINES_OFFERING);

		courseOfActionDischargesLiabilityEClass = createEClass(COURSE_OF_ACTION_DISCHARGES_LIABILITY);

		courseOfActionChannelsEffortsTowardsDesiredResultEClass = createEClass(COURSE_OF_ACTION_CHANNELS_EFFORTS_TOWARDS_DESIRED_RESULT);

		broaderDesiredResultIncludesMoreSpecificDesiredResultEClass = createEClass(BROADER_DESIRED_RESULT_INCLUDES_MORE_SPECIFIC_DESIRED_RESULT);

		desiredResultCategoryCategorizesDesiredResultEClass = createEClass(DESIRED_RESULT_CATEGORY_CATEGORIZES_DESIRED_RESULT);

		directiveSupportsAchievementOfDesiredResultEClass = createEClass(DIRECTIVE_SUPPORTS_ACHIEVEMENT_OF_DESIRED_RESULT);

		broaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategoryEClass = createEClass(BROADER_DESIRED_CATEGORY_CATEGORIZES_MORE_SPECIFIC_DESIRED_RESULT_CATEGORY);

		potentialImpactProvidesImpetursForDirectiveEClass = createEClass(POTENTIAL_IMPACT_PROVIDES_IMPETURS_FOR_DIRECTIVE);

		directiveActsAsRegulationEClass = createEClass(DIRECTIVE_ACTS_AS_REGULATION);

		organizationUnitDefinesEndEClass = createEClass(ORGANIZATION_UNIT_DEFINES_END);

		offeringUsesFixedAssetEClass = createEClass(OFFERING_USES_FIXED_ASSET);

		fixedAssetProvidesResourceEClass = createEClass(FIXED_ASSET_PROVIDES_RESOURCE);

		objectiveQuantitiesGoalEClass = createEClass(OBJECTIVE_QUANTITIES_GOAL);

		goalAmplifiesVisionEClass = createEClass(GOAL_AMPLIFIES_VISION);

		organizationUnitRecognizesInfluencerEClass = createEClass(ORGANIZATION_UNIT_RECOGNIZES_INFLUENCER);

		influencingOrganizationIsSourceofInfluencerEClass = createEClass(INFLUENCING_ORGANIZATION_IS_SOURCEOF_INFLUENCER);

		influencerCategoryCategorizesInfluencerEClass = createEClass(INFLUENCER_CATEGORY_CATEGORIZES_INFLUENCER);

		broaderInfluencerCategorizesNarrowerInfluencerCategoryEClass = createEClass(BROADER_INFLUENCER_CATEGORIZES_NARROWER_INFLUENCER_CATEGORY);

		organizationCategoryCategorizesInfluencingOrganizationEClass = createEClass(ORGANIZATION_CATEGORY_CATEGORIZES_INFLUENCING_ORGANIZATION);

		organizationUnitActsAsInfluencingOrganizationEClass = createEClass(ORGANIZATION_UNIT_ACTS_AS_INFLUENCING_ORGANIZATION);

		organizationUnitIsResponsibleForLiabilityEClass = createEClass(ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_LIABILITY);

		liabilityClaimsResourceEClass = createEClass(LIABILITY_CLAIMS_RESOURCE);

		organizationUnitEstablishesMeansEClass = createEClass(ORGANIZATION_UNIT_ESTABLISHES_MEANS);

		strategyIsAComponentfOfThe_PlanForMIssionEClass = createEClass(STRATEGY_IS_ACOMPONENTF_OF_THE_PLAN_FOR_MISSION);

		missionMakesOperativeVisionEClass = createEClass(MISSION_MAKES_OPERATIVE_VISION);

		offeringRequiresResourceEClass = createEClass(OFFERING_REQUIRES_RESOURCE);

		broaderOrganizationCategoryCategorizesNarrowerOrganizationCategoryEClass = createEClass(BROADER_ORGANIZATION_CATEGORY_CATEGORIZES_NARROWER_ORGANIZATION_CATEGORY);

		strategyDeterminesOrganizationUnitEClass = createEClass(STRATEGY_DETERMINES_ORGANIZATION_UNIT);

		tacticImplementsStrategyEClass = createEClass(TACTIC_IMPLEMENTS_STRATEGY);
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
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		assessmentEClass.getESuperTypes().add(this.getMotivationElement());
		organizationUnitEClass.getESuperTypes().add(this.getMotivationElement());
		strategyEClass.getESuperTypes().add(this.getCourseOfAction());
		courseOfActionEClass.getESuperTypes().add(this.getMeans());
		meansEClass.getESuperTypes().add(this.getMotivationElement());
		directiveEClass.getESuperTypes().add(this.getMeans());
		potentialImpactEClass.getESuperTypes().add(this.getMotivationElement());
		regulationEClass.getESuperTypes().add(this.getExternalInfluencer());
		externalInfluencerEClass.getESuperTypes().add(this.getInfluencer());
		influencerEClass.getESuperTypes().add(this.getMotivationElement());
		influencingOrganizationEClass.getESuperTypes().add(this.getMotivationElement());
		organizationCategoryEClass.getESuperTypes().add(this.getMotivationElement());
		influencerCategoryEClass.getESuperTypes().add(this.getMotivationElement());
		desiredResultEClass.getESuperTypes().add(this.getEnd());
		endEClass.getESuperTypes().add(this.getMotivationElement());
		desiredResultCategoryEClass.getESuperTypes().add(this.getMotivationElement());
		assetEClass.getESuperTypes().add(this.getMotivationElement());
		businessProcessEClass.getESuperTypes().add(this.getMotivationElement());
		businessRuleEClass.getESuperTypes().add(this.getDirective());
		businessPolicyEClass.getESuperTypes().add(this.getDirective());
		tacticEClass.getESuperTypes().add(this.getCourseOfAction());
		offeringEClass.getESuperTypes().add(this.getFixedAsset());
		fixedAssetEClass.getESuperTypes().add(this.getAsset());
		resourceEClass.getESuperTypes().add(this.getAsset());
		liabilityEClass.getESuperTypes().add(this.getMotivationElement());
		missionEClass.getESuperTypes().add(this.getMeans());
		visionEClass.getESuperTypes().add(this.getEnd());
		goalEClass.getESuperTypes().add(this.getDesiredResult());
		objectiveEClass.getESuperTypes().add(this.getDesiredResult());
		assessmentCategoryEClass.getESuperTypes().add(this.getMotivationElement());
		internalInfluencerEClass.getESuperTypes().add(this.getInfluencer());
		potentialRewardEClass.getESuperTypes().add(this.getPotentialImpact());
		riskEClass.getESuperTypes().add(this.getPotentialImpact());
		usingAssessmentUsesUsedAssessmentEClass.getESuperTypes().add(this.getMotivationEdge());
		organizationUnitMakesAssessmentEClass.getESuperTypes().add(this.getMotivationEdge());
		assessmentCategoryCategorizesAssessmentEClass.getESuperTypes().add(this.getMotivationEdge());
		assessmentIdentifiesPotentialImpactEClass.getESuperTypes().add(this.getMotivationEdge());
		assessmentAffectsAchievementOfEndEClass.getESuperTypes().add(this.getMotivationEdge());
		assessmentAffectsEmploymentOfMeansEClass.getESuperTypes().add(this.getMotivationEdge());
		assessmentProvidesImpetusForDirectiveEClass.getESuperTypes().add(this.getMotivationEdge());
		assessmentIsJudgmentOfInfluencerEClass.getESuperTypes().add(this.getMotivationEdge());
		broaderAssessmentCategoryCategorizesNarrowerAssessmentCategoryEClass.getESuperTypes().add(this.getMotivationEdge());
		businessProcessManagesAssetEClass.getESuperTypes().add(this.getMotivationEdge());
		organizationUnitIsResponsibleForAssetEClass.getESuperTypes().add(this.getMotivationEdge());
		courseOfActionDeploysAssetEClass.getESuperTypes().add(this.getMotivationEdge());
		directiveGovernsUseOfAssetEClass.getESuperTypes().add(this.getMotivationEdge());
		broaderBusinessPolicyIncludesMoreSpecificBusinessPolicyEClass.getESuperTypes().add(this.getMotivationEdge());
		businessPolicyIsBasisOfBusinessRuleEClass.getESuperTypes().add(this.getMotivationEdge());
		businessPolicyGovernsBusinessProcessEClass.getESuperTypes().add(this.getMotivationEdge());
		organizationUnitIsResponsibleForBusinessProcessEClass.getESuperTypes().add(this.getMotivationEdge());
		businessRuleGuidesBusinessProcessEClass.getESuperTypes().add(this.getMotivationEdge());
		businessProcessRealizesCourseOfActionEClass.getESuperTypes().add(this.getMotivationEdge());
		businessProcessDeliversOfferingEClass.getESuperTypes().add(this.getMotivationEdge());
		tacticEffectsEnforcementLevelOfBusinessRuleEClass.getESuperTypes().add(this.getMotivationEdge());
		directiveGovernsCourseOfActionEClass.getESuperTypes().add(this.getMotivationEdge());
		broaderCourseOfActionIncludesMoreSpecificCourseOfActionEClass.getESuperTypes().add(this.getMotivationEdge());
		enablingCourseOfActionEnablesEnabledCourseOfActionEClass.getESuperTypes().add(this.getMotivationEdge());
		courseOfActionIsFormulatedBasedOnDirectiveEClass.getESuperTypes().add(this.getMotivationEdge());
		courseOfActionDefinesOfferingEClass.getESuperTypes().add(this.getMotivationEdge());
		courseOfActionDischargesLiabilityEClass.getESuperTypes().add(this.getMotivationEdge());
		courseOfActionChannelsEffortsTowardsDesiredResultEClass.getESuperTypes().add(this.getMotivationEdge());
		broaderDesiredResultIncludesMoreSpecificDesiredResultEClass.getESuperTypes().add(this.getMotivationEdge());
		desiredResultCategoryCategorizesDesiredResultEClass.getESuperTypes().add(this.getMotivationEdge());
		directiveSupportsAchievementOfDesiredResultEClass.getESuperTypes().add(this.getMotivationEdge());
		broaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategoryEClass.getESuperTypes().add(this.getMotivationEdge());
		potentialImpactProvidesImpetursForDirectiveEClass.getESuperTypes().add(this.getMotivationEdge());
		directiveActsAsRegulationEClass.getESuperTypes().add(this.getMotivationEdge());
		organizationUnitDefinesEndEClass.getESuperTypes().add(this.getMotivationEdge());
		offeringUsesFixedAssetEClass.getESuperTypes().add(this.getMotivationEdge());
		fixedAssetProvidesResourceEClass.getESuperTypes().add(this.getMotivationEdge());
		objectiveQuantitiesGoalEClass.getESuperTypes().add(this.getMotivationEdge());
		goalAmplifiesVisionEClass.getESuperTypes().add(this.getMotivationEdge());
		organizationUnitRecognizesInfluencerEClass.getESuperTypes().add(this.getMotivationEdge());
		influencingOrganizationIsSourceofInfluencerEClass.getESuperTypes().add(this.getMotivationEdge());
		influencerCategoryCategorizesInfluencerEClass.getESuperTypes().add(this.getMotivationEdge());
		broaderInfluencerCategorizesNarrowerInfluencerCategoryEClass.getESuperTypes().add(this.getMotivationEdge());
		organizationCategoryCategorizesInfluencingOrganizationEClass.getESuperTypes().add(this.getMotivationEdge());
		organizationUnitActsAsInfluencingOrganizationEClass.getESuperTypes().add(this.getMotivationEdge());
		organizationUnitIsResponsibleForLiabilityEClass.getESuperTypes().add(this.getMotivationEdge());
		liabilityClaimsResourceEClass.getESuperTypes().add(this.getMotivationEdge());
		organizationUnitEstablishesMeansEClass.getESuperTypes().add(this.getMotivationEdge());
		strategyIsAComponentfOfThe_PlanForMIssionEClass.getESuperTypes().add(this.getMotivationEdge());
		missionMakesOperativeVisionEClass.getESuperTypes().add(this.getMotivationEdge());
		offeringRequiresResourceEClass.getESuperTypes().add(this.getMotivationEdge());
		broaderOrganizationCategoryCategorizesNarrowerOrganizationCategoryEClass.getESuperTypes().add(this.getMotivationEdge());
		strategyDeterminesOrganizationUnitEClass.getESuperTypes().add(this.getMotivationEdge());
		tacticImplementsStrategyEClass.getESuperTypes().add(this.getMotivationEdge());

		// Initialize classes, features, and operations; add parameters
		initEClass(motivationElementEClass, MotivationElement.class, "MotivationElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMotivationElement_Description(), theTypesPackage.getString(), "description", null, 0, 1, MotivationElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMotivationElement_Base_Artifact(), theUMLPackage.getArtifact(), null, "base_Artifact", null, 1, 1, MotivationElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(assessmentEClass, Assessment.class, "Assessment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(organizationUnitEClass, OrganizationUnit.class, "OrganizationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(strategyEClass, Strategy.class, "Strategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(courseOfActionEClass, CourseOfAction.class, "CourseOfAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(meansEClass, Means.class, "Means", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(directiveEClass, Directive.class, "Directive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(potentialImpactEClass, PotentialImpact.class, "PotentialImpact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(regulationEClass, Regulation.class, "Regulation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalInfluencerEClass, ExternalInfluencer.class, "ExternalInfluencer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(influencerEClass, Influencer.class, "Influencer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(influencingOrganizationEClass, InfluencingOrganization.class, "InfluencingOrganization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(organizationCategoryEClass, OrganizationCategory.class, "OrganizationCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(influencerCategoryEClass, InfluencerCategory.class, "InfluencerCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(desiredResultEClass, DesiredResult.class, "DesiredResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(endEClass, End.class, "End", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(desiredResultCategoryEClass, DesiredResultCategory.class, "DesiredResultCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assetEClass, Asset.class, "Asset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(businessProcessEClass, BusinessProcess.class, "BusinessProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(businessRuleEClass, BusinessRule.class, "BusinessRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(businessPolicyEClass, BusinessPolicy.class, "BusinessPolicy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tacticEClass, Tactic.class, "Tactic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(offeringEClass, Offering.class, "Offering", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fixedAssetEClass, FixedAsset.class, "FixedAsset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resourceEClass, Resource.class, "Resource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(liabilityEClass, Liability.class, "Liability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(missionEClass, Mission.class, "Mission", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(visionEClass, Vision.class, "Vision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(goalEClass, Goal.class, "Goal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(objectiveEClass, Objective.class, "Objective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assessmentCategoryEClass, AssessmentCategory.class, "AssessmentCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(internalInfluencerEClass, InternalInfluencer.class, "InternalInfluencer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(potentialRewardEClass, PotentialReward.class, "PotentialReward", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(riskEClass, Risk.class, "Risk", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(motivationEdgeEClass, MotivationEdge.class, "MotivationEdge", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMotivationEdge_Base_Dependency(), theUMLPackage.getDependency(), null, "base_Dependency", null, 1, 1, MotivationEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(usingAssessmentUsesUsedAssessmentEClass, UsingAssessmentUsesUsedAssessment.class, "UsingAssessmentUsesUsedAssessment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(organizationUnitMakesAssessmentEClass, OrganizationUnitMakesAssessment.class, "OrganizationUnitMakesAssessment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assessmentCategoryCategorizesAssessmentEClass, AssessmentCategoryCategorizesAssessment.class, "AssessmentCategoryCategorizesAssessment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assessmentIdentifiesPotentialImpactEClass, AssessmentIdentifiesPotentialImpact.class, "AssessmentIdentifiesPotentialImpact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assessmentAffectsAchievementOfEndEClass, AssessmentAffectsAchievementOfEnd.class, "AssessmentAffectsAchievementOfEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assessmentAffectsEmploymentOfMeansEClass, AssessmentAffectsEmploymentOfMeans.class, "AssessmentAffectsEmploymentOfMeans", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assessmentProvidesImpetusForDirectiveEClass, AssessmentProvidesImpetusForDirective.class, "AssessmentProvidesImpetusForDirective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assessmentIsJudgmentOfInfluencerEClass, AssessmentIsJudgmentOfInfluencer.class, "AssessmentIsJudgmentOfInfluencer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(broaderAssessmentCategoryCategorizesNarrowerAssessmentCategoryEClass, BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory.class, "BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(businessProcessManagesAssetEClass, BusinessProcessManagesAsset.class, "BusinessProcessManagesAsset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(organizationUnitIsResponsibleForAssetEClass, OrganizationUnitIsResponsibleForAsset.class, "OrganizationUnitIsResponsibleForAsset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(courseOfActionDeploysAssetEClass, CourseOfActionDeploysAsset.class, "CourseOfActionDeploysAsset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(directiveGovernsUseOfAssetEClass, DirectiveGovernsUseOfAsset.class, "DirectiveGovernsUseOfAsset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(broaderBusinessPolicyIncludesMoreSpecificBusinessPolicyEClass, BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy.class, "BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(businessPolicyIsBasisOfBusinessRuleEClass, BusinessPolicyIsBasisOfBusinessRule.class, "BusinessPolicyIsBasisOfBusinessRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(businessPolicyGovernsBusinessProcessEClass, BusinessPolicyGovernsBusinessProcess.class, "BusinessPolicyGovernsBusinessProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(organizationUnitIsResponsibleForBusinessProcessEClass, OrganizationUnitIsResponsibleForBusinessProcess.class, "OrganizationUnitIsResponsibleForBusinessProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(businessRuleGuidesBusinessProcessEClass, BusinessRuleGuidesBusinessProcess.class, "BusinessRuleGuidesBusinessProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(businessProcessRealizesCourseOfActionEClass, BusinessProcessRealizesCourseOfAction.class, "BusinessProcessRealizesCourseOfAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(businessProcessDeliversOfferingEClass, BusinessProcessDeliversOffering.class, "BusinessProcessDeliversOffering", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tacticEffectsEnforcementLevelOfBusinessRuleEClass, TacticEffectsEnforcementLevelOfBusinessRule.class, "TacticEffectsEnforcementLevelOfBusinessRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(directiveGovernsCourseOfActionEClass, DirectiveGovernsCourseOfAction.class, "DirectiveGovernsCourseOfAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(broaderCourseOfActionIncludesMoreSpecificCourseOfActionEClass, BroaderCourseOfActionIncludesMoreSpecificCourseOfAction.class, "BroaderCourseOfActionIncludesMoreSpecificCourseOfAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(enablingCourseOfActionEnablesEnabledCourseOfActionEClass, EnablingCourseOfActionEnablesEnabledCourseOfAction.class, "EnablingCourseOfActionEnablesEnabledCourseOfAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(courseOfActionIsFormulatedBasedOnDirectiveEClass, CourseOfActionIsFormulatedBasedOnDirective.class, "CourseOfActionIsFormulatedBasedOnDirective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(courseOfActionDefinesOfferingEClass, CourseOfActionDefinesOffering.class, "CourseOfActionDefinesOffering", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(courseOfActionDischargesLiabilityEClass, CourseOfActionDischargesLiability.class, "CourseOfActionDischargesLiability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(courseOfActionChannelsEffortsTowardsDesiredResultEClass, CourseOfActionChannelsEffortsTowardsDesiredResult.class, "CourseOfActionChannelsEffortsTowardsDesiredResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(broaderDesiredResultIncludesMoreSpecificDesiredResultEClass, BroaderDesiredResultIncludesMoreSpecificDesiredResult.class, "BroaderDesiredResultIncludesMoreSpecificDesiredResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(desiredResultCategoryCategorizesDesiredResultEClass, DesiredResultCategoryCategorizesDesiredResult.class, "DesiredResultCategoryCategorizesDesiredResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(directiveSupportsAchievementOfDesiredResultEClass, DirectiveSupportsAchievementOfDesiredResult.class, "DirectiveSupportsAchievementOfDesiredResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(broaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategoryEClass, BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory.class, "BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(potentialImpactProvidesImpetursForDirectiveEClass, PotentialImpactProvidesImpetursForDirective.class, "PotentialImpactProvidesImpetursForDirective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(directiveActsAsRegulationEClass, DirectiveActsAsRegulation.class, "DirectiveActsAsRegulation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(organizationUnitDefinesEndEClass, OrganizationUnitDefinesEnd.class, "OrganizationUnitDefinesEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(offeringUsesFixedAssetEClass, OfferingUsesFixedAsset.class, "OfferingUsesFixedAsset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fixedAssetProvidesResourceEClass, FixedAssetProvidesResource.class, "FixedAssetProvidesResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(objectiveQuantitiesGoalEClass, ObjectiveQuantitiesGoal.class, "ObjectiveQuantitiesGoal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(goalAmplifiesVisionEClass, GoalAmplifiesVision.class, "GoalAmplifiesVision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(organizationUnitRecognizesInfluencerEClass, OrganizationUnitRecognizesInfluencer.class, "OrganizationUnitRecognizesInfluencer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(influencingOrganizationIsSourceofInfluencerEClass, InfluencingOrganizationIsSourceofInfluencer.class, "InfluencingOrganizationIsSourceofInfluencer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(influencerCategoryCategorizesInfluencerEClass, InfluencerCategoryCategorizesInfluencer.class, "InfluencerCategoryCategorizesInfluencer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(broaderInfluencerCategorizesNarrowerInfluencerCategoryEClass, BroaderInfluencerCategorizesNarrowerInfluencerCategory.class, "BroaderInfluencerCategorizesNarrowerInfluencerCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(organizationCategoryCategorizesInfluencingOrganizationEClass, OrganizationCategoryCategorizesInfluencingOrganization.class, "OrganizationCategoryCategorizesInfluencingOrganization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(organizationUnitActsAsInfluencingOrganizationEClass, OrganizationUnitActsAsInfluencingOrganization.class, "OrganizationUnitActsAsInfluencingOrganization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(organizationUnitIsResponsibleForLiabilityEClass, OrganizationUnitIsResponsibleForLiability.class, "OrganizationUnitIsResponsibleForLiability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(liabilityClaimsResourceEClass, LiabilityClaimsResource.class, "LiabilityClaimsResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(organizationUnitEstablishesMeansEClass, OrganizationUnitEstablishesMeans.class, "OrganizationUnitEstablishesMeans", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(strategyIsAComponentfOfThe_PlanForMIssionEClass, StrategyIsAComponentfOfThe_PlanForMIssion.class, "StrategyIsAComponentfOfThe_PlanForMIssion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(missionMakesOperativeVisionEClass, MissionMakesOperativeVision.class, "MissionMakesOperativeVision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(offeringRequiresResourceEClass, OfferingRequiresResource.class, "OfferingRequiresResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(broaderOrganizationCategoryCategorizesNarrowerOrganizationCategoryEClass, BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory.class, "BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(strategyDeterminesOrganizationUnitEClass, StrategyDeterminesOrganizationUnit.class, "StrategyDeterminesOrganizationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tacticImplementsStrategyEClass, TacticImplementsStrategy.class, "TacticImplementsStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //BmmPackageImpl
