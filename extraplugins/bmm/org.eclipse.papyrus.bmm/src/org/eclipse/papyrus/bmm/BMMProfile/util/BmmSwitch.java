/**
 */
package org.eclipse.papyrus.bmm.BMMProfile.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.bmm.BMMProfile.*;

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
 * @see org.eclipse.papyrus.bmm.BMMProfile.BmmPackage
 * @generated
 */
public class BmmSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BmmPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BmmSwitch() {
		if (modelPackage == null) {
			modelPackage = BmmPackage.eINSTANCE;
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
			case BmmPackage.MOTIVATION_ELEMENT: {
				MotivationElement motivationElement = (MotivationElement)theEObject;
				T result = caseMotivationElement(motivationElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ASSESSMENT: {
				Assessment assessment = (Assessment)theEObject;
				T result = caseAssessment(assessment);
				if (result == null) result = caseMotivationElement(assessment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ORGANIZATION_UNIT: {
				OrganizationUnit organizationUnit = (OrganizationUnit)theEObject;
				T result = caseOrganizationUnit(organizationUnit);
				if (result == null) result = caseMotivationElement(organizationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.STRATEGY: {
				Strategy strategy = (Strategy)theEObject;
				T result = caseStrategy(strategy);
				if (result == null) result = caseCourseOfAction(strategy);
				if (result == null) result = caseMeans(strategy);
				if (result == null) result = caseMotivationElement(strategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.COURSE_OF_ACTION: {
				CourseOfAction courseOfAction = (CourseOfAction)theEObject;
				T result = caseCourseOfAction(courseOfAction);
				if (result == null) result = caseMeans(courseOfAction);
				if (result == null) result = caseMotivationElement(courseOfAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.MEANS: {
				Means means = (Means)theEObject;
				T result = caseMeans(means);
				if (result == null) result = caseMotivationElement(means);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.DIRECTIVE: {
				Directive directive = (Directive)theEObject;
				T result = caseDirective(directive);
				if (result == null) result = caseMeans(directive);
				if (result == null) result = caseMotivationElement(directive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.POTENTIAL_IMPACT: {
				PotentialImpact potentialImpact = (PotentialImpact)theEObject;
				T result = casePotentialImpact(potentialImpact);
				if (result == null) result = caseMotivationElement(potentialImpact);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.REGULATION: {
				Regulation regulation = (Regulation)theEObject;
				T result = caseRegulation(regulation);
				if (result == null) result = caseExternalInfluencer(regulation);
				if (result == null) result = caseInfluencer(regulation);
				if (result == null) result = caseMotivationElement(regulation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.EXTERNAL_INFLUENCER: {
				ExternalInfluencer externalInfluencer = (ExternalInfluencer)theEObject;
				T result = caseExternalInfluencer(externalInfluencer);
				if (result == null) result = caseInfluencer(externalInfluencer);
				if (result == null) result = caseMotivationElement(externalInfluencer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.INFLUENCER: {
				Influencer influencer = (Influencer)theEObject;
				T result = caseInfluencer(influencer);
				if (result == null) result = caseMotivationElement(influencer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.INFLUENCING_ORGANIZATION: {
				InfluencingOrganization influencingOrganization = (InfluencingOrganization)theEObject;
				T result = caseInfluencingOrganization(influencingOrganization);
				if (result == null) result = caseMotivationElement(influencingOrganization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ORGANIZATION_CATEGORY: {
				OrganizationCategory organizationCategory = (OrganizationCategory)theEObject;
				T result = caseOrganizationCategory(organizationCategory);
				if (result == null) result = caseMotivationElement(organizationCategory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.INFLUENCER_CATEGORY: {
				InfluencerCategory influencerCategory = (InfluencerCategory)theEObject;
				T result = caseInfluencerCategory(influencerCategory);
				if (result == null) result = caseMotivationElement(influencerCategory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.DESIRED_RESULT: {
				DesiredResult desiredResult = (DesiredResult)theEObject;
				T result = caseDesiredResult(desiredResult);
				if (result == null) result = caseEnd(desiredResult);
				if (result == null) result = caseMotivationElement(desiredResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.END: {
				End end = (End)theEObject;
				T result = caseEnd(end);
				if (result == null) result = caseMotivationElement(end);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.DESIRED_RESULT_CATEGORY: {
				DesiredResultCategory desiredResultCategory = (DesiredResultCategory)theEObject;
				T result = caseDesiredResultCategory(desiredResultCategory);
				if (result == null) result = caseMotivationElement(desiredResultCategory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ASSET: {
				Asset asset = (Asset)theEObject;
				T result = caseAsset(asset);
				if (result == null) result = caseMotivationElement(asset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.BUSINESS_PROCESS: {
				BusinessProcess businessProcess = (BusinessProcess)theEObject;
				T result = caseBusinessProcess(businessProcess);
				if (result == null) result = caseMotivationElement(businessProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.BUSINESS_RULE: {
				BusinessRule businessRule = (BusinessRule)theEObject;
				T result = caseBusinessRule(businessRule);
				if (result == null) result = caseDirective(businessRule);
				if (result == null) result = caseMeans(businessRule);
				if (result == null) result = caseMotivationElement(businessRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.BUSINESS_POLICY: {
				BusinessPolicy businessPolicy = (BusinessPolicy)theEObject;
				T result = caseBusinessPolicy(businessPolicy);
				if (result == null) result = caseDirective(businessPolicy);
				if (result == null) result = caseMeans(businessPolicy);
				if (result == null) result = caseMotivationElement(businessPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.TACTIC: {
				Tactic tactic = (Tactic)theEObject;
				T result = caseTactic(tactic);
				if (result == null) result = caseCourseOfAction(tactic);
				if (result == null) result = caseMeans(tactic);
				if (result == null) result = caseMotivationElement(tactic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.OFFERING: {
				Offering offering = (Offering)theEObject;
				T result = caseOffering(offering);
				if (result == null) result = caseFixedAsset(offering);
				if (result == null) result = caseAsset(offering);
				if (result == null) result = caseMotivationElement(offering);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.FIXED_ASSET: {
				FixedAsset fixedAsset = (FixedAsset)theEObject;
				T result = caseFixedAsset(fixedAsset);
				if (result == null) result = caseAsset(fixedAsset);
				if (result == null) result = caseMotivationElement(fixedAsset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.RESOURCE: {
				Resource resource = (Resource)theEObject;
				T result = caseResource(resource);
				if (result == null) result = caseAsset(resource);
				if (result == null) result = caseMotivationElement(resource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.LIABILITY: {
				Liability liability = (Liability)theEObject;
				T result = caseLiability(liability);
				if (result == null) result = caseMotivationElement(liability);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.MISSION: {
				Mission mission = (Mission)theEObject;
				T result = caseMission(mission);
				if (result == null) result = caseMeans(mission);
				if (result == null) result = caseMotivationElement(mission);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.VISION: {
				Vision vision = (Vision)theEObject;
				T result = caseVision(vision);
				if (result == null) result = caseEnd(vision);
				if (result == null) result = caseMotivationElement(vision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.GOAL: {
				Goal goal = (Goal)theEObject;
				T result = caseGoal(goal);
				if (result == null) result = caseDesiredResult(goal);
				if (result == null) result = caseEnd(goal);
				if (result == null) result = caseMotivationElement(goal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.OBJECTIVE: {
				Objective objective = (Objective)theEObject;
				T result = caseObjective(objective);
				if (result == null) result = caseDesiredResult(objective);
				if (result == null) result = caseEnd(objective);
				if (result == null) result = caseMotivationElement(objective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ASSESSMENT_CATEGORY: {
				AssessmentCategory assessmentCategory = (AssessmentCategory)theEObject;
				T result = caseAssessmentCategory(assessmentCategory);
				if (result == null) result = caseMotivationElement(assessmentCategory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.INTERNAL_INFLUENCER: {
				InternalInfluencer internalInfluencer = (InternalInfluencer)theEObject;
				T result = caseInternalInfluencer(internalInfluencer);
				if (result == null) result = caseInfluencer(internalInfluencer);
				if (result == null) result = caseMotivationElement(internalInfluencer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.POTENTIAL_REWARD: {
				PotentialReward potentialReward = (PotentialReward)theEObject;
				T result = casePotentialReward(potentialReward);
				if (result == null) result = casePotentialImpact(potentialReward);
				if (result == null) result = caseMotivationElement(potentialReward);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.RISK: {
				Risk risk = (Risk)theEObject;
				T result = caseRisk(risk);
				if (result == null) result = casePotentialImpact(risk);
				if (result == null) result = caseMotivationElement(risk);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.MOTIVATION_EDGE: {
				MotivationEdge motivationEdge = (MotivationEdge)theEObject;
				T result = caseMotivationEdge(motivationEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.USING_ASSESSMENT_USES_USED_ASSESSMENT: {
				UsingAssessmentUsesUsedAssessment usingAssessmentUsesUsedAssessment = (UsingAssessmentUsesUsedAssessment)theEObject;
				T result = caseUsingAssessmentUsesUsedAssessment(usingAssessmentUsesUsedAssessment);
				if (result == null) result = caseMotivationEdge(usingAssessmentUsesUsedAssessment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ORGANIZATION_UNIT_MAKES_ASSESSMENT: {
				OrganizationUnitMakesAssessment organizationUnitMakesAssessment = (OrganizationUnitMakesAssessment)theEObject;
				T result = caseOrganizationUnitMakesAssessment(organizationUnitMakesAssessment);
				if (result == null) result = caseMotivationEdge(organizationUnitMakesAssessment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ASSESSMENT_CATEGORY_CATEGORIZES_ASSESSMENT: {
				AssessmentCategoryCategorizesAssessment assessmentCategoryCategorizesAssessment = (AssessmentCategoryCategorizesAssessment)theEObject;
				T result = caseAssessmentCategoryCategorizesAssessment(assessmentCategoryCategorizesAssessment);
				if (result == null) result = caseMotivationEdge(assessmentCategoryCategorizesAssessment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ASSESSMENT_IDENTIFIES_POTENTIAL_IMPACT: {
				AssessmentIdentifiesPotentialImpact assessmentIdentifiesPotentialImpact = (AssessmentIdentifiesPotentialImpact)theEObject;
				T result = caseAssessmentIdentifiesPotentialImpact(assessmentIdentifiesPotentialImpact);
				if (result == null) result = caseMotivationEdge(assessmentIdentifiesPotentialImpact);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ASSESSMENT_AFFECTS_ACHIEVEMENT_OF_END: {
				AssessmentAffectsAchievementOfEnd assessmentAffectsAchievementOfEnd = (AssessmentAffectsAchievementOfEnd)theEObject;
				T result = caseAssessmentAffectsAchievementOfEnd(assessmentAffectsAchievementOfEnd);
				if (result == null) result = caseMotivationEdge(assessmentAffectsAchievementOfEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ASSESSMENT_AFFECTS_EMPLOYMENT_OF_MEANS: {
				AssessmentAffectsEmploymentOfMeans assessmentAffectsEmploymentOfMeans = (AssessmentAffectsEmploymentOfMeans)theEObject;
				T result = caseAssessmentAffectsEmploymentOfMeans(assessmentAffectsEmploymentOfMeans);
				if (result == null) result = caseMotivationEdge(assessmentAffectsEmploymentOfMeans);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ASSESSMENT_PROVIDES_IMPETUS_FOR_DIRECTIVE: {
				AssessmentProvidesImpetusForDirective assessmentProvidesImpetusForDirective = (AssessmentProvidesImpetusForDirective)theEObject;
				T result = caseAssessmentProvidesImpetusForDirective(assessmentProvidesImpetusForDirective);
				if (result == null) result = caseMotivationEdge(assessmentProvidesImpetusForDirective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ASSESSMENT_IS_JUDGMENT_OF_INFLUENCER: {
				AssessmentIsJudgmentOfInfluencer assessmentIsJudgmentOfInfluencer = (AssessmentIsJudgmentOfInfluencer)theEObject;
				T result = caseAssessmentIsJudgmentOfInfluencer(assessmentIsJudgmentOfInfluencer);
				if (result == null) result = caseMotivationEdge(assessmentIsJudgmentOfInfluencer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.BROADER_ASSESSMENT_CATEGORY_CATEGORIZES_NARROWER_ASSESSMENT_CATEGORY: {
				BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory broaderAssessmentCategoryCategorizesNarrowerAssessmentCategory = (BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory)theEObject;
				T result = caseBroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory(broaderAssessmentCategoryCategorizesNarrowerAssessmentCategory);
				if (result == null) result = caseMotivationEdge(broaderAssessmentCategoryCategorizesNarrowerAssessmentCategory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.BUSINESS_PROCESS_MANAGES_ASSET: {
				BusinessProcessManagesAsset businessProcessManagesAsset = (BusinessProcessManagesAsset)theEObject;
				T result = caseBusinessProcessManagesAsset(businessProcessManagesAsset);
				if (result == null) result = caseMotivationEdge(businessProcessManagesAsset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_ASSET: {
				OrganizationUnitIsResponsibleForAsset organizationUnitIsResponsibleForAsset = (OrganizationUnitIsResponsibleForAsset)theEObject;
				T result = caseOrganizationUnitIsResponsibleForAsset(organizationUnitIsResponsibleForAsset);
				if (result == null) result = caseMotivationEdge(organizationUnitIsResponsibleForAsset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.COURSE_OF_ACTION_DEPLOYS_ASSET: {
				CourseOfActionDeploysAsset courseOfActionDeploysAsset = (CourseOfActionDeploysAsset)theEObject;
				T result = caseCourseOfActionDeploysAsset(courseOfActionDeploysAsset);
				if (result == null) result = caseMotivationEdge(courseOfActionDeploysAsset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.DIRECTIVE_GOVERNS_USE_OF_ASSET: {
				DirectiveGovernsUseOfAsset directiveGovernsUseOfAsset = (DirectiveGovernsUseOfAsset)theEObject;
				T result = caseDirectiveGovernsUseOfAsset(directiveGovernsUseOfAsset);
				if (result == null) result = caseMotivationEdge(directiveGovernsUseOfAsset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.BROADER_BUSINESS_POLICY_INCLUDES_MORE_SPECIFIC_BUSINESS_POLICY: {
				BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy broaderBusinessPolicyIncludesMoreSpecificBusinessPolicy = (BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy)theEObject;
				T result = caseBroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy(broaderBusinessPolicyIncludesMoreSpecificBusinessPolicy);
				if (result == null) result = caseMotivationEdge(broaderBusinessPolicyIncludesMoreSpecificBusinessPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.BUSINESS_POLICY_IS_BASIS_OF_BUSINESS_RULE: {
				BusinessPolicyIsBasisOfBusinessRule businessPolicyIsBasisOfBusinessRule = (BusinessPolicyIsBasisOfBusinessRule)theEObject;
				T result = caseBusinessPolicyIsBasisOfBusinessRule(businessPolicyIsBasisOfBusinessRule);
				if (result == null) result = caseMotivationEdge(businessPolicyIsBasisOfBusinessRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.BUSINESS_POLICY_GOVERNS_BUSINESS_PROCESS: {
				BusinessPolicyGovernsBusinessProcess businessPolicyGovernsBusinessProcess = (BusinessPolicyGovernsBusinessProcess)theEObject;
				T result = caseBusinessPolicyGovernsBusinessProcess(businessPolicyGovernsBusinessProcess);
				if (result == null) result = caseMotivationEdge(businessPolicyGovernsBusinessProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_BUSINESS_PROCESS: {
				OrganizationUnitIsResponsibleForBusinessProcess organizationUnitIsResponsibleForBusinessProcess = (OrganizationUnitIsResponsibleForBusinessProcess)theEObject;
				T result = caseOrganizationUnitIsResponsibleForBusinessProcess(organizationUnitIsResponsibleForBusinessProcess);
				if (result == null) result = caseMotivationEdge(organizationUnitIsResponsibleForBusinessProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.BUSINESS_RULE_GUIDES_BUSINESS_PROCESS: {
				BusinessRuleGuidesBusinessProcess businessRuleGuidesBusinessProcess = (BusinessRuleGuidesBusinessProcess)theEObject;
				T result = caseBusinessRuleGuidesBusinessProcess(businessRuleGuidesBusinessProcess);
				if (result == null) result = caseMotivationEdge(businessRuleGuidesBusinessProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.BUSINESS_PROCESS_REALIZES_COURSE_OF_ACTION: {
				BusinessProcessRealizesCourseOfAction businessProcessRealizesCourseOfAction = (BusinessProcessRealizesCourseOfAction)theEObject;
				T result = caseBusinessProcessRealizesCourseOfAction(businessProcessRealizesCourseOfAction);
				if (result == null) result = caseMotivationEdge(businessProcessRealizesCourseOfAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.BUSINESS_PROCESS_DELIVERS_OFFERING: {
				BusinessProcessDeliversOffering businessProcessDeliversOffering = (BusinessProcessDeliversOffering)theEObject;
				T result = caseBusinessProcessDeliversOffering(businessProcessDeliversOffering);
				if (result == null) result = caseMotivationEdge(businessProcessDeliversOffering);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.TACTIC_EFFECTS_ENFORCEMENT_LEVEL_OF_BUSINESS_RULE: {
				TacticEffectsEnforcementLevelOfBusinessRule tacticEffectsEnforcementLevelOfBusinessRule = (TacticEffectsEnforcementLevelOfBusinessRule)theEObject;
				T result = caseTacticEffectsEnforcementLevelOfBusinessRule(tacticEffectsEnforcementLevelOfBusinessRule);
				if (result == null) result = caseMotivationEdge(tacticEffectsEnforcementLevelOfBusinessRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.DIRECTIVE_GOVERNS_COURSE_OF_ACTION: {
				DirectiveGovernsCourseOfAction directiveGovernsCourseOfAction = (DirectiveGovernsCourseOfAction)theEObject;
				T result = caseDirectiveGovernsCourseOfAction(directiveGovernsCourseOfAction);
				if (result == null) result = caseMotivationEdge(directiveGovernsCourseOfAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.BROADER_COURSE_OF_ACTION_INCLUDES_MORE_SPECIFIC_COURSE_OF_ACTION: {
				BroaderCourseOfActionIncludesMoreSpecificCourseOfAction broaderCourseOfActionIncludesMoreSpecificCourseOfAction = (BroaderCourseOfActionIncludesMoreSpecificCourseOfAction)theEObject;
				T result = caseBroaderCourseOfActionIncludesMoreSpecificCourseOfAction(broaderCourseOfActionIncludesMoreSpecificCourseOfAction);
				if (result == null) result = caseMotivationEdge(broaderCourseOfActionIncludesMoreSpecificCourseOfAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ENABLING_COURSE_OF_ACTION_ENABLES_ENABLED_COURSE_OF_ACTION: {
				EnablingCourseOfActionEnablesEnabledCourseOfAction enablingCourseOfActionEnablesEnabledCourseOfAction = (EnablingCourseOfActionEnablesEnabledCourseOfAction)theEObject;
				T result = caseEnablingCourseOfActionEnablesEnabledCourseOfAction(enablingCourseOfActionEnablesEnabledCourseOfAction);
				if (result == null) result = caseMotivationEdge(enablingCourseOfActionEnablesEnabledCourseOfAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.COURSE_OF_ACTION_IS_FORMULATED_BASED_ON_DIRECTIVE: {
				CourseOfActionIsFormulatedBasedOnDirective courseOfActionIsFormulatedBasedOnDirective = (CourseOfActionIsFormulatedBasedOnDirective)theEObject;
				T result = caseCourseOfActionIsFormulatedBasedOnDirective(courseOfActionIsFormulatedBasedOnDirective);
				if (result == null) result = caseMotivationEdge(courseOfActionIsFormulatedBasedOnDirective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.COURSE_OF_ACTION_DEFINES_OFFERING: {
				CourseOfActionDefinesOffering courseOfActionDefinesOffering = (CourseOfActionDefinesOffering)theEObject;
				T result = caseCourseOfActionDefinesOffering(courseOfActionDefinesOffering);
				if (result == null) result = caseMotivationEdge(courseOfActionDefinesOffering);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.COURSE_OF_ACTION_DISCHARGES_LIABILITY: {
				CourseOfActionDischargesLiability courseOfActionDischargesLiability = (CourseOfActionDischargesLiability)theEObject;
				T result = caseCourseOfActionDischargesLiability(courseOfActionDischargesLiability);
				if (result == null) result = caseMotivationEdge(courseOfActionDischargesLiability);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.COURSE_OF_ACTION_CHANNELS_EFFORTS_TOWARDS_DESIRED_RESULT: {
				CourseOfActionChannelsEffortsTowardsDesiredResult courseOfActionChannelsEffortsTowardsDesiredResult = (CourseOfActionChannelsEffortsTowardsDesiredResult)theEObject;
				T result = caseCourseOfActionChannelsEffortsTowardsDesiredResult(courseOfActionChannelsEffortsTowardsDesiredResult);
				if (result == null) result = caseMotivationEdge(courseOfActionChannelsEffortsTowardsDesiredResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.BROADER_DESIRED_RESULT_INCLUDES_MORE_SPECIFIC_DESIRED_RESULT: {
				BroaderDesiredResultIncludesMoreSpecificDesiredResult broaderDesiredResultIncludesMoreSpecificDesiredResult = (BroaderDesiredResultIncludesMoreSpecificDesiredResult)theEObject;
				T result = caseBroaderDesiredResultIncludesMoreSpecificDesiredResult(broaderDesiredResultIncludesMoreSpecificDesiredResult);
				if (result == null) result = caseMotivationEdge(broaderDesiredResultIncludesMoreSpecificDesiredResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.DESIRED_RESULT_CATEGORY_CATEGORIZES_DESIRED_RESULT: {
				DesiredResultCategoryCategorizesDesiredResult desiredResultCategoryCategorizesDesiredResult = (DesiredResultCategoryCategorizesDesiredResult)theEObject;
				T result = caseDesiredResultCategoryCategorizesDesiredResult(desiredResultCategoryCategorizesDesiredResult);
				if (result == null) result = caseMotivationEdge(desiredResultCategoryCategorizesDesiredResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.DIRECTIVE_SUPPORTS_ACHIEVEMENT_OF_DESIRED_RESULT: {
				DirectiveSupportsAchievementOfDesiredResult directiveSupportsAchievementOfDesiredResult = (DirectiveSupportsAchievementOfDesiredResult)theEObject;
				T result = caseDirectiveSupportsAchievementOfDesiredResult(directiveSupportsAchievementOfDesiredResult);
				if (result == null) result = caseMotivationEdge(directiveSupportsAchievementOfDesiredResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.BROADER_DESIRED_CATEGORY_CATEGORIZES_MORE_SPECIFIC_DESIRED_RESULT_CATEGORY: {
				BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory broaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory = (BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory)theEObject;
				T result = caseBroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory(broaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory);
				if (result == null) result = caseMotivationEdge(broaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.POTENTIAL_IMPACT_PROVIDES_IMPETURS_FOR_DIRECTIVE: {
				PotentialImpactProvidesImpetursForDirective potentialImpactProvidesImpetursForDirective = (PotentialImpactProvidesImpetursForDirective)theEObject;
				T result = casePotentialImpactProvidesImpetursForDirective(potentialImpactProvidesImpetursForDirective);
				if (result == null) result = caseMotivationEdge(potentialImpactProvidesImpetursForDirective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.DIRECTIVE_ACTS_AS_REGULATION: {
				DirectiveActsAsRegulation directiveActsAsRegulation = (DirectiveActsAsRegulation)theEObject;
				T result = caseDirectiveActsAsRegulation(directiveActsAsRegulation);
				if (result == null) result = caseMotivationEdge(directiveActsAsRegulation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ORGANIZATION_UNIT_DEFINES_END: {
				OrganizationUnitDefinesEnd organizationUnitDefinesEnd = (OrganizationUnitDefinesEnd)theEObject;
				T result = caseOrganizationUnitDefinesEnd(organizationUnitDefinesEnd);
				if (result == null) result = caseMotivationEdge(organizationUnitDefinesEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.OFFERING_USES_FIXED_ASSET: {
				OfferingUsesFixedAsset offeringUsesFixedAsset = (OfferingUsesFixedAsset)theEObject;
				T result = caseOfferingUsesFixedAsset(offeringUsesFixedAsset);
				if (result == null) result = caseMotivationEdge(offeringUsesFixedAsset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.FIXED_ASSET_PROVIDES_RESOURCE: {
				FixedAssetProvidesResource fixedAssetProvidesResource = (FixedAssetProvidesResource)theEObject;
				T result = caseFixedAssetProvidesResource(fixedAssetProvidesResource);
				if (result == null) result = caseMotivationEdge(fixedAssetProvidesResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.OBJECTIVE_QUANTITIES_GOAL: {
				ObjectiveQuantitiesGoal objectiveQuantitiesGoal = (ObjectiveQuantitiesGoal)theEObject;
				T result = caseObjectiveQuantitiesGoal(objectiveQuantitiesGoal);
				if (result == null) result = caseMotivationEdge(objectiveQuantitiesGoal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.GOAL_AMPLIFIES_VISION: {
				GoalAmplifiesVision goalAmplifiesVision = (GoalAmplifiesVision)theEObject;
				T result = caseGoalAmplifiesVision(goalAmplifiesVision);
				if (result == null) result = caseMotivationEdge(goalAmplifiesVision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ORGANIZATION_UNIT_RECOGNIZES_INFLUENCER: {
				OrganizationUnitRecognizesInfluencer organizationUnitRecognizesInfluencer = (OrganizationUnitRecognizesInfluencer)theEObject;
				T result = caseOrganizationUnitRecognizesInfluencer(organizationUnitRecognizesInfluencer);
				if (result == null) result = caseMotivationEdge(organizationUnitRecognizesInfluencer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.INFLUENCING_ORGANIZATION_IS_SOURCEOF_INFLUENCER: {
				InfluencingOrganizationIsSourceofInfluencer influencingOrganizationIsSourceofInfluencer = (InfluencingOrganizationIsSourceofInfluencer)theEObject;
				T result = caseInfluencingOrganizationIsSourceofInfluencer(influencingOrganizationIsSourceofInfluencer);
				if (result == null) result = caseMotivationEdge(influencingOrganizationIsSourceofInfluencer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.INFLUENCER_CATEGORY_CATEGORIZES_INFLUENCER: {
				InfluencerCategoryCategorizesInfluencer influencerCategoryCategorizesInfluencer = (InfluencerCategoryCategorizesInfluencer)theEObject;
				T result = caseInfluencerCategoryCategorizesInfluencer(influencerCategoryCategorizesInfluencer);
				if (result == null) result = caseMotivationEdge(influencerCategoryCategorizesInfluencer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.BROADER_INFLUENCER_CATEGORIZES_NARROWER_INFLUENCER_CATEGORY: {
				BroaderInfluencerCategorizesNarrowerInfluencerCategory broaderInfluencerCategorizesNarrowerInfluencerCategory = (BroaderInfluencerCategorizesNarrowerInfluencerCategory)theEObject;
				T result = caseBroaderInfluencerCategorizesNarrowerInfluencerCategory(broaderInfluencerCategorizesNarrowerInfluencerCategory);
				if (result == null) result = caseMotivationEdge(broaderInfluencerCategorizesNarrowerInfluencerCategory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ORGANIZATION_CATEGORY_CATEGORIZES_INFLUENCING_ORGANIZATION: {
				OrganizationCategoryCategorizesInfluencingOrganization organizationCategoryCategorizesInfluencingOrganization = (OrganizationCategoryCategorizesInfluencingOrganization)theEObject;
				T result = caseOrganizationCategoryCategorizesInfluencingOrganization(organizationCategoryCategorizesInfluencingOrganization);
				if (result == null) result = caseMotivationEdge(organizationCategoryCategorizesInfluencingOrganization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ORGANIZATION_UNIT_ACTS_AS_INFLUENCING_ORGANIZATION: {
				OrganizationUnitActsAsInfluencingOrganization organizationUnitActsAsInfluencingOrganization = (OrganizationUnitActsAsInfluencingOrganization)theEObject;
				T result = caseOrganizationUnitActsAsInfluencingOrganization(organizationUnitActsAsInfluencingOrganization);
				if (result == null) result = caseMotivationEdge(organizationUnitActsAsInfluencingOrganization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_LIABILITY: {
				OrganizationUnitIsResponsibleForLiability organizationUnitIsResponsibleForLiability = (OrganizationUnitIsResponsibleForLiability)theEObject;
				T result = caseOrganizationUnitIsResponsibleForLiability(organizationUnitIsResponsibleForLiability);
				if (result == null) result = caseMotivationEdge(organizationUnitIsResponsibleForLiability);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.LIABILITY_CLAIMS_RESOURCE: {
				LiabilityClaimsResource liabilityClaimsResource = (LiabilityClaimsResource)theEObject;
				T result = caseLiabilityClaimsResource(liabilityClaimsResource);
				if (result == null) result = caseMotivationEdge(liabilityClaimsResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.ORGANIZATION_UNIT_ESTABLISHES_MEANS: {
				OrganizationUnitEstablishesMeans organizationUnitEstablishesMeans = (OrganizationUnitEstablishesMeans)theEObject;
				T result = caseOrganizationUnitEstablishesMeans(organizationUnitEstablishesMeans);
				if (result == null) result = caseMotivationEdge(organizationUnitEstablishesMeans);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.STRATEGY_IS_ACOMPONENTF_OF_THE_PLAN_FOR_MISSION: {
				StrategyIsAComponentfOfThe_PlanForMIssion strategyIsAComponentfOfThe_PlanForMIssion = (StrategyIsAComponentfOfThe_PlanForMIssion)theEObject;
				T result = caseStrategyIsAComponentfOfThe_PlanForMIssion(strategyIsAComponentfOfThe_PlanForMIssion);
				if (result == null) result = caseMotivationEdge(strategyIsAComponentfOfThe_PlanForMIssion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.MISSION_MAKES_OPERATIVE_VISION: {
				MissionMakesOperativeVision missionMakesOperativeVision = (MissionMakesOperativeVision)theEObject;
				T result = caseMissionMakesOperativeVision(missionMakesOperativeVision);
				if (result == null) result = caseMotivationEdge(missionMakesOperativeVision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.OFFERING_REQUIRES_RESOURCE: {
				OfferingRequiresResource offeringRequiresResource = (OfferingRequiresResource)theEObject;
				T result = caseOfferingRequiresResource(offeringRequiresResource);
				if (result == null) result = caseMotivationEdge(offeringRequiresResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.BROADER_ORGANIZATION_CATEGORY_CATEGORIZES_NARROWER_ORGANIZATION_CATEGORY: {
				BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory broaderOrganizationCategoryCategorizesNarrowerOrganizationCategory = (BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory)theEObject;
				T result = caseBroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory(broaderOrganizationCategoryCategorizesNarrowerOrganizationCategory);
				if (result == null) result = caseMotivationEdge(broaderOrganizationCategoryCategorizesNarrowerOrganizationCategory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.STRATEGY_DETERMINES_ORGANIZATION_UNIT: {
				StrategyDeterminesOrganizationUnit strategyDeterminesOrganizationUnit = (StrategyDeterminesOrganizationUnit)theEObject;
				T result = caseStrategyDeterminesOrganizationUnit(strategyDeterminesOrganizationUnit);
				if (result == null) result = caseMotivationEdge(strategyDeterminesOrganizationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BmmPackage.TACTIC_IMPLEMENTS_STRATEGY: {
				TacticImplementsStrategy tacticImplementsStrategy = (TacticImplementsStrategy)theEObject;
				T result = caseTacticImplementsStrategy(tacticImplementsStrategy);
				if (result == null) result = caseMotivationEdge(tacticImplementsStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Motivation Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Motivation Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMotivationElement(MotivationElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assessment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assessment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssessment(Assessment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Organization Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Organization Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrganizationUnit(OrganizationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStrategy(Strategy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Course Of Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Course Of Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCourseOfAction(CourseOfAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Means</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Means</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeans(Means object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirective(Directive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Potential Impact</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Potential Impact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePotentialImpact(PotentialImpact object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regulation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regulation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegulation(Regulation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Influencer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Influencer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalInfluencer(ExternalInfluencer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Influencer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Influencer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInfluencer(Influencer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Influencing Organization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Influencing Organization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInfluencingOrganization(InfluencingOrganization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Organization Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Organization Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrganizationCategory(OrganizationCategory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Influencer Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Influencer Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInfluencerCategory(InfluencerCategory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Desired Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Desired Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDesiredResult(DesiredResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnd(End object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Desired Result Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Desired Result Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDesiredResultCategory(DesiredResultCategory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Asset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Asset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAsset(Asset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Business Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Business Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusinessProcess(BusinessProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Business Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Business Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusinessRule(BusinessRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Business Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Business Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusinessPolicy(BusinessPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tactic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tactic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTactic(Tactic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Offering</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Offering</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOffering(Offering object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fixed Asset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fixed Asset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFixedAsset(FixedAsset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResource(Resource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Liability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Liability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiability(Liability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mission</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mission</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMission(Mission object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVision(Vision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Goal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Goal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGoal(Goal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Objective</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Objective</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjective(Objective object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assessment Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assessment Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssessmentCategory(AssessmentCategory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Influencer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Influencer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalInfluencer(InternalInfluencer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Potential Reward</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Potential Reward</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePotentialReward(PotentialReward object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Risk</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Risk</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRisk(Risk object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Motivation Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Motivation Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMotivationEdge(MotivationEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Using Assessment Uses Used Assessment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Using Assessment Uses Used Assessment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUsingAssessmentUsesUsedAssessment(UsingAssessmentUsesUsedAssessment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Organization Unit Makes Assessment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Organization Unit Makes Assessment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrganizationUnitMakesAssessment(OrganizationUnitMakesAssessment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assessment Category Categorizes Assessment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assessment Category Categorizes Assessment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssessmentCategoryCategorizesAssessment(AssessmentCategoryCategorizesAssessment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assessment Identifies Potential Impact</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assessment Identifies Potential Impact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssessmentIdentifiesPotentialImpact(AssessmentIdentifiesPotentialImpact object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assessment Affects Achievement Of End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assessment Affects Achievement Of End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssessmentAffectsAchievementOfEnd(AssessmentAffectsAchievementOfEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assessment Affects Employment Of Means</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assessment Affects Employment Of Means</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssessmentAffectsEmploymentOfMeans(AssessmentAffectsEmploymentOfMeans object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assessment Provides Impetus For Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assessment Provides Impetus For Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssessmentProvidesImpetusForDirective(AssessmentProvidesImpetusForDirective object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assessment Is Judgment Of Influencer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assessment Is Judgment Of Influencer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssessmentIsJudgmentOfInfluencer(AssessmentIsJudgmentOfInfluencer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Broader Assessment Category Categorizes Narrower Assessment Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Broader Assessment Category Categorizes Narrower Assessment Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory(BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Business Process Manages Asset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Business Process Manages Asset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusinessProcessManagesAsset(BusinessProcessManagesAsset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Organization Unit Is Responsible For Asset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Organization Unit Is Responsible For Asset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrganizationUnitIsResponsibleForAsset(OrganizationUnitIsResponsibleForAsset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Course Of Action Deploys Asset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Course Of Action Deploys Asset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCourseOfActionDeploysAsset(CourseOfActionDeploysAsset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Directive Governs Use Of Asset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Directive Governs Use Of Asset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirectiveGovernsUseOfAsset(DirectiveGovernsUseOfAsset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Broader Business Policy Includes More Specific Business Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Broader Business Policy Includes More Specific Business Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy(BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Business Policy Is Basis Of Business Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Business Policy Is Basis Of Business Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusinessPolicyIsBasisOfBusinessRule(BusinessPolicyIsBasisOfBusinessRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Business Policy Governs Business Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Business Policy Governs Business Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusinessPolicyGovernsBusinessProcess(BusinessPolicyGovernsBusinessProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Organization Unit Is Responsible For Business Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Organization Unit Is Responsible For Business Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrganizationUnitIsResponsibleForBusinessProcess(OrganizationUnitIsResponsibleForBusinessProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Business Rule Guides Business Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Business Rule Guides Business Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusinessRuleGuidesBusinessProcess(BusinessRuleGuidesBusinessProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Business Process Realizes Course Of Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Business Process Realizes Course Of Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusinessProcessRealizesCourseOfAction(BusinessProcessRealizesCourseOfAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Business Process Delivers Offering</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Business Process Delivers Offering</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusinessProcessDeliversOffering(BusinessProcessDeliversOffering object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tactic Effects Enforcement Level Of Business Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tactic Effects Enforcement Level Of Business Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTacticEffectsEnforcementLevelOfBusinessRule(TacticEffectsEnforcementLevelOfBusinessRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Directive Governs Course Of Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Directive Governs Course Of Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirectiveGovernsCourseOfAction(DirectiveGovernsCourseOfAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Broader Course Of Action Includes More Specific Course Of Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Broader Course Of Action Includes More Specific Course Of Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBroaderCourseOfActionIncludesMoreSpecificCourseOfAction(BroaderCourseOfActionIncludesMoreSpecificCourseOfAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enabling Course Of Action Enables Enabled Course Of Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enabling Course Of Action Enables Enabled Course Of Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnablingCourseOfActionEnablesEnabledCourseOfAction(EnablingCourseOfActionEnablesEnabledCourseOfAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Course Of Action Is Formulated Based On Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Course Of Action Is Formulated Based On Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCourseOfActionIsFormulatedBasedOnDirective(CourseOfActionIsFormulatedBasedOnDirective object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Course Of Action Defines Offering</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Course Of Action Defines Offering</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCourseOfActionDefinesOffering(CourseOfActionDefinesOffering object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Course Of Action Discharges Liability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Course Of Action Discharges Liability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCourseOfActionDischargesLiability(CourseOfActionDischargesLiability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Course Of Action Channels Efforts Towards Desired Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Course Of Action Channels Efforts Towards Desired Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCourseOfActionChannelsEffortsTowardsDesiredResult(CourseOfActionChannelsEffortsTowardsDesiredResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Broader Desired Result Includes More Specific Desired Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Broader Desired Result Includes More Specific Desired Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBroaderDesiredResultIncludesMoreSpecificDesiredResult(BroaderDesiredResultIncludesMoreSpecificDesiredResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Desired Result Category Categorizes Desired Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Desired Result Category Categorizes Desired Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDesiredResultCategoryCategorizesDesiredResult(DesiredResultCategoryCategorizesDesiredResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Directive Supports Achievement Of Desired Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Directive Supports Achievement Of Desired Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirectiveSupportsAchievementOfDesiredResult(DirectiveSupportsAchievementOfDesiredResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Broader Desired Category Categorizes More Specific Desired Result Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Broader Desired Category Categorizes More Specific Desired Result Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory(BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Potential Impact Provides Impeturs For Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Potential Impact Provides Impeturs For Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePotentialImpactProvidesImpetursForDirective(PotentialImpactProvidesImpetursForDirective object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Directive Acts As Regulation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Directive Acts As Regulation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirectiveActsAsRegulation(DirectiveActsAsRegulation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Organization Unit Defines End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Organization Unit Defines End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrganizationUnitDefinesEnd(OrganizationUnitDefinesEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Offering Uses Fixed Asset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Offering Uses Fixed Asset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOfferingUsesFixedAsset(OfferingUsesFixedAsset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fixed Asset Provides Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fixed Asset Provides Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFixedAssetProvidesResource(FixedAssetProvidesResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Objective Quantities Goal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Objective Quantities Goal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectiveQuantitiesGoal(ObjectiveQuantitiesGoal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Goal Amplifies Vision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Goal Amplifies Vision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGoalAmplifiesVision(GoalAmplifiesVision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Organization Unit Recognizes Influencer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Organization Unit Recognizes Influencer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrganizationUnitRecognizesInfluencer(OrganizationUnitRecognizesInfluencer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Influencing Organization Is Sourceof Influencer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Influencing Organization Is Sourceof Influencer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInfluencingOrganizationIsSourceofInfluencer(InfluencingOrganizationIsSourceofInfluencer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Influencer Category Categorizes Influencer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Influencer Category Categorizes Influencer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInfluencerCategoryCategorizesInfluencer(InfluencerCategoryCategorizesInfluencer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Broader Influencer Categorizes Narrower Influencer Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Broader Influencer Categorizes Narrower Influencer Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBroaderInfluencerCategorizesNarrowerInfluencerCategory(BroaderInfluencerCategorizesNarrowerInfluencerCategory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Organization Category Categorizes Influencing Organization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Organization Category Categorizes Influencing Organization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrganizationCategoryCategorizesInfluencingOrganization(OrganizationCategoryCategorizesInfluencingOrganization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Organization Unit Acts As Influencing Organization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Organization Unit Acts As Influencing Organization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrganizationUnitActsAsInfluencingOrganization(OrganizationUnitActsAsInfluencingOrganization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Organization Unit Is Responsible For Liability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Organization Unit Is Responsible For Liability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrganizationUnitIsResponsibleForLiability(OrganizationUnitIsResponsibleForLiability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Liability Claims Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Liability Claims Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiabilityClaimsResource(LiabilityClaimsResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Organization Unit Establishes Means</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Organization Unit Establishes Means</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrganizationUnitEstablishesMeans(OrganizationUnitEstablishesMeans object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Strategy Is AComponentf Of The Plan For MIssion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Strategy Is AComponentf Of The Plan For MIssion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStrategyIsAComponentfOfThe_PlanForMIssion(StrategyIsAComponentfOfThe_PlanForMIssion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mission Makes Operative Vision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mission Makes Operative Vision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMissionMakesOperativeVision(MissionMakesOperativeVision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Offering Requires Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Offering Requires Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOfferingRequiresResource(OfferingRequiresResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Broader Organization Category Categorizes Narrower Organization Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Broader Organization Category Categorizes Narrower Organization Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory(BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Strategy Determines Organization Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Strategy Determines Organization Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStrategyDeterminesOrganizationUnit(StrategyDeterminesOrganizationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tactic Implements Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tactic Implements Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTacticImplementsStrategy(TacticImplementsStrategy object) {
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

} //BmmSwitch
