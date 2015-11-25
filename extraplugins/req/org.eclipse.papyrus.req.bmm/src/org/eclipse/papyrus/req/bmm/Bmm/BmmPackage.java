/**
 */
package org.eclipse.papyrus.req.bmm.Bmm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.req.bmm.Bmm.BmmFactory
 * @model kind="package"
 * @generated
 */
public interface BmmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Bmm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.eclipse.org/papyrus/req/0.7.0/BMM/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Bmm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BmmPackage eINSTANCE = org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.MotivationElementImpl <em>Motivation Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.MotivationElementImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getMotivationElement()
	 * @generated
	 */
	int MOTIVATION_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIVATION_ELEMENT__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIVATION_ELEMENT__BASE_ARTIFACT = 1;

	/**
	 * The number of structural features of the '<em>Motivation Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIVATION_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Motivation Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIVATION_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentImpl <em>Assessment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getAssessment()
	 * @generated
	 */
	int ASSESSMENT = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT__DESCRIPTION = MOTIVATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT__BASE_ARTIFACT = MOTIVATION_ELEMENT__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Assessment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_FEATURE_COUNT = MOTIVATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Assessment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_OPERATION_COUNT = MOTIVATION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitImpl <em>Organization Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationUnit()
	 * @generated
	 */
	int ORGANIZATION_UNIT = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT__DESCRIPTION = MOTIVATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT__BASE_ARTIFACT = MOTIVATION_ELEMENT__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Organization Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_FEATURE_COUNT = MOTIVATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Organization Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_OPERATION_COUNT = MOTIVATION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.MeansImpl <em>Means</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.MeansImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getMeans()
	 * @generated
	 */
	int MEANS = 5;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEANS__DESCRIPTION = MOTIVATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEANS__BASE_ARTIFACT = MOTIVATION_ELEMENT__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Means</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEANS_FEATURE_COUNT = MOTIVATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Means</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEANS_OPERATION_COUNT = MOTIVATION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionImpl <em>Course Of Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getCourseOfAction()
	 * @generated
	 */
	int COURSE_OF_ACTION = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OF_ACTION__DESCRIPTION = MEANS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OF_ACTION__BASE_ARTIFACT = MEANS__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Course Of Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OF_ACTION_FEATURE_COUNT = MEANS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Course Of Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OF_ACTION_OPERATION_COUNT = MEANS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.StrategyImpl <em>Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.StrategyImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getStrategy()
	 * @generated
	 */
	int STRATEGY = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__DESCRIPTION = COURSE_OF_ACTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__BASE_ARTIFACT = COURSE_OF_ACTION__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_FEATURE_COUNT = COURSE_OF_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_OPERATION_COUNT = COURSE_OF_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveImpl <em>Directive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getDirective()
	 * @generated
	 */
	int DIRECTIVE = 6;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE__DESCRIPTION = MEANS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE__BASE_ARTIFACT = MEANS__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE_FEATURE_COUNT = MEANS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE_OPERATION_COUNT = MEANS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.PotentialImpactImpl <em>Potential Impact</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.PotentialImpactImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getPotentialImpact()
	 * @generated
	 */
	int POTENTIAL_IMPACT = 7;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_IMPACT__DESCRIPTION = MOTIVATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_IMPACT__BASE_ARTIFACT = MOTIVATION_ELEMENT__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Potential Impact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_IMPACT_FEATURE_COUNT = MOTIVATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Potential Impact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_IMPACT_OPERATION_COUNT = MOTIVATION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencerImpl <em>Influencer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencerImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getInfluencer()
	 * @generated
	 */
	int INFLUENCER = 10;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLUENCER__DESCRIPTION = MOTIVATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLUENCER__BASE_ARTIFACT = MOTIVATION_ELEMENT__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Influencer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLUENCER_FEATURE_COUNT = MOTIVATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Influencer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLUENCER_OPERATION_COUNT = MOTIVATION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.ExternalInfluencerImpl <em>External Influencer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.ExternalInfluencerImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getExternalInfluencer()
	 * @generated
	 */
	int EXTERNAL_INFLUENCER = 9;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_INFLUENCER__DESCRIPTION = INFLUENCER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_INFLUENCER__BASE_ARTIFACT = INFLUENCER__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>External Influencer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_INFLUENCER_FEATURE_COUNT = INFLUENCER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>External Influencer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_INFLUENCER_OPERATION_COUNT = INFLUENCER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.RegulationImpl <em>Regulation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.RegulationImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getRegulation()
	 * @generated
	 */
	int REGULATION = 8;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION__DESCRIPTION = EXTERNAL_INFLUENCER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION__BASE_ARTIFACT = EXTERNAL_INFLUENCER__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Regulation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_FEATURE_COUNT = EXTERNAL_INFLUENCER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Regulation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATION_OPERATION_COUNT = EXTERNAL_INFLUENCER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencingOrganizationImpl <em>Influencing Organization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencingOrganizationImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getInfluencingOrganization()
	 * @generated
	 */
	int INFLUENCING_ORGANIZATION = 11;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLUENCING_ORGANIZATION__DESCRIPTION = MOTIVATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLUENCING_ORGANIZATION__BASE_ARTIFACT = MOTIVATION_ELEMENT__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Influencing Organization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLUENCING_ORGANIZATION_FEATURE_COUNT = MOTIVATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Influencing Organization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLUENCING_ORGANIZATION_OPERATION_COUNT = MOTIVATION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationCategoryImpl <em>Organization Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationCategoryImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationCategory()
	 * @generated
	 */
	int ORGANIZATION_CATEGORY = 12;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_CATEGORY__DESCRIPTION = MOTIVATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_CATEGORY__BASE_ARTIFACT = MOTIVATION_ELEMENT__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Organization Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_CATEGORY_FEATURE_COUNT = MOTIVATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Organization Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_CATEGORY_OPERATION_COUNT = MOTIVATION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencerCategoryImpl <em>Influencer Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencerCategoryImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getInfluencerCategory()
	 * @generated
	 */
	int INFLUENCER_CATEGORY = 13;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLUENCER_CATEGORY__DESCRIPTION = MOTIVATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLUENCER_CATEGORY__BASE_ARTIFACT = MOTIVATION_ELEMENT__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Influencer Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLUENCER_CATEGORY_FEATURE_COUNT = MOTIVATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Influencer Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLUENCER_CATEGORY_OPERATION_COUNT = MOTIVATION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.EndImpl <em>End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.EndImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getEnd()
	 * @generated
	 */
	int END = 15;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__DESCRIPTION = MOTIVATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__BASE_ARTIFACT = MOTIVATION_ELEMENT__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_FEATURE_COUNT = MOTIVATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_OPERATION_COUNT = MOTIVATION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.DesiredResultImpl <em>Desired Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.DesiredResultImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getDesiredResult()
	 * @generated
	 */
	int DESIRED_RESULT = 14;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIRED_RESULT__DESCRIPTION = END__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIRED_RESULT__BASE_ARTIFACT = END__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Desired Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIRED_RESULT_FEATURE_COUNT = END_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Desired Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIRED_RESULT_OPERATION_COUNT = END_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.DesiredResultCategoryImpl <em>Desired Result Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.DesiredResultCategoryImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getDesiredResultCategory()
	 * @generated
	 */
	int DESIRED_RESULT_CATEGORY = 16;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIRED_RESULT_CATEGORY__DESCRIPTION = MOTIVATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIRED_RESULT_CATEGORY__BASE_ARTIFACT = MOTIVATION_ELEMENT__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Desired Result Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIRED_RESULT_CATEGORY_FEATURE_COUNT = MOTIVATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Desired Result Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIRED_RESULT_CATEGORY_OPERATION_COUNT = MOTIVATION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.AssetImpl <em>Asset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.AssetImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getAsset()
	 * @generated
	 */
	int ASSET = 17;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__DESCRIPTION = MOTIVATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__BASE_ARTIFACT = MOTIVATION_ELEMENT__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET_FEATURE_COUNT = MOTIVATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET_OPERATION_COUNT = MOTIVATION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessProcessImpl <em>Business Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessProcessImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBusinessProcess()
	 * @generated
	 */
	int BUSINESS_PROCESS = 18;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS__DESCRIPTION = MOTIVATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS__BASE_ARTIFACT = MOTIVATION_ELEMENT__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Business Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_FEATURE_COUNT = MOTIVATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Business Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_OPERATION_COUNT = MOTIVATION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessRuleImpl <em>Business Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessRuleImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBusinessRule()
	 * @generated
	 */
	int BUSINESS_RULE = 19;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE__DESCRIPTION = DIRECTIVE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE__BASE_ARTIFACT = DIRECTIVE__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Business Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_FEATURE_COUNT = DIRECTIVE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Business Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_OPERATION_COUNT = DIRECTIVE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessPolicyImpl <em>Business Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessPolicyImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBusinessPolicy()
	 * @generated
	 */
	int BUSINESS_POLICY = 20;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_POLICY__DESCRIPTION = DIRECTIVE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_POLICY__BASE_ARTIFACT = DIRECTIVE__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Business Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_POLICY_FEATURE_COUNT = DIRECTIVE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Business Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_POLICY_OPERATION_COUNT = DIRECTIVE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.TacticImpl <em>Tactic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.TacticImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getTactic()
	 * @generated
	 */
	int TACTIC = 21;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIC__DESCRIPTION = COURSE_OF_ACTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIC__BASE_ARTIFACT = COURSE_OF_ACTION__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Tactic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIC_FEATURE_COUNT = COURSE_OF_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tactic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIC_OPERATION_COUNT = COURSE_OF_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.FixedAssetImpl <em>Fixed Asset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.FixedAssetImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getFixedAsset()
	 * @generated
	 */
	int FIXED_ASSET = 23;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_ASSET__DESCRIPTION = ASSET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_ASSET__BASE_ARTIFACT = ASSET__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Fixed Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_ASSET_FEATURE_COUNT = ASSET_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Fixed Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_ASSET_OPERATION_COUNT = ASSET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OfferingImpl <em>Offering</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OfferingImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOffering()
	 * @generated
	 */
	int OFFERING = 22;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFERING__DESCRIPTION = FIXED_ASSET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFERING__BASE_ARTIFACT = FIXED_ASSET__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Offering</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFERING_FEATURE_COUNT = FIXED_ASSET_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Offering</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFERING_OPERATION_COUNT = FIXED_ASSET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.ResourceImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 24;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DESCRIPTION = ASSET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__BASE_ARTIFACT = ASSET__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = ASSET_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = ASSET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.LiabilityImpl <em>Liability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.LiabilityImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getLiability()
	 * @generated
	 */
	int LIABILITY = 25;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIABILITY__DESCRIPTION = MOTIVATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIABILITY__BASE_ARTIFACT = MOTIVATION_ELEMENT__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Liability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIABILITY_FEATURE_COUNT = MOTIVATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Liability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIABILITY_OPERATION_COUNT = MOTIVATION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.MissionImpl <em>Mission</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.MissionImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getMission()
	 * @generated
	 */
	int MISSION = 26;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION__DESCRIPTION = MEANS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION__BASE_ARTIFACT = MEANS__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Mission</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_FEATURE_COUNT = MEANS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mission</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_OPERATION_COUNT = MEANS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.VisionImpl <em>Vision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.VisionImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getVision()
	 * @generated
	 */
	int VISION = 27;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISION__DESCRIPTION = END__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISION__BASE_ARTIFACT = END__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Vision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISION_FEATURE_COUNT = END_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Vision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISION_OPERATION_COUNT = END_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.GoalImpl <em>Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.GoalImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getGoal()
	 * @generated
	 */
	int GOAL = 28;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__DESCRIPTION = DESIRED_RESULT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__BASE_ARTIFACT = DESIRED_RESULT__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_FEATURE_COUNT = DESIRED_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_OPERATION_COUNT = DESIRED_RESULT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.ObjectiveImpl <em>Objective</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.ObjectiveImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getObjective()
	 * @generated
	 */
	int OBJECTIVE = 29;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTIVE__DESCRIPTION = DESIRED_RESULT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTIVE__BASE_ARTIFACT = DESIRED_RESULT__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Objective</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTIVE_FEATURE_COUNT = DESIRED_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Objective</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTIVE_OPERATION_COUNT = DESIRED_RESULT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentCategoryImpl <em>Assessment Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentCategoryImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getAssessmentCategory()
	 * @generated
	 */
	int ASSESSMENT_CATEGORY = 30;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_CATEGORY__DESCRIPTION = MOTIVATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_CATEGORY__BASE_ARTIFACT = MOTIVATION_ELEMENT__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Assessment Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_CATEGORY_FEATURE_COUNT = MOTIVATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Assessment Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_CATEGORY_OPERATION_COUNT = MOTIVATION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.InternalInfluencerImpl <em>Internal Influencer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.InternalInfluencerImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getInternalInfluencer()
	 * @generated
	 */
	int INTERNAL_INFLUENCER = 31;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_INFLUENCER__DESCRIPTION = INFLUENCER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_INFLUENCER__BASE_ARTIFACT = INFLUENCER__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Internal Influencer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_INFLUENCER_FEATURE_COUNT = INFLUENCER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Internal Influencer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_INFLUENCER_OPERATION_COUNT = INFLUENCER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.PotentialRewardImpl <em>Potential Reward</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.PotentialRewardImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getPotentialReward()
	 * @generated
	 */
	int POTENTIAL_REWARD = 32;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_REWARD__DESCRIPTION = POTENTIAL_IMPACT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_REWARD__BASE_ARTIFACT = POTENTIAL_IMPACT__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Potential Reward</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_REWARD_FEATURE_COUNT = POTENTIAL_IMPACT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Potential Reward</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_REWARD_OPERATION_COUNT = POTENTIAL_IMPACT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.RiskImpl <em>Risk</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.RiskImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getRisk()
	 * @generated
	 */
	int RISK = 33;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RISK__DESCRIPTION = POTENTIAL_IMPACT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RISK__BASE_ARTIFACT = POTENTIAL_IMPACT__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Risk</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RISK_FEATURE_COUNT = POTENTIAL_IMPACT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Risk</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RISK_OPERATION_COUNT = POTENTIAL_IMPACT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.MotivationEdgeImpl <em>Motivation Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.MotivationEdgeImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getMotivationEdge()
	 * @generated
	 */
	int MOTIVATION_EDGE = 34;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIVATION_EDGE__BASE_DEPENDENCY = 0;

	/**
	 * The number of structural features of the '<em>Motivation Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIVATION_EDGE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Motivation Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIVATION_EDGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.UsingAssessmentUsesUsedAssessmentImpl <em>Using Assessment Uses Used Assessment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.UsingAssessmentUsesUsedAssessmentImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getUsingAssessmentUsesUsedAssessment()
	 * @generated
	 */
	int USING_ASSESSMENT_USES_USED_ASSESSMENT = 35;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USING_ASSESSMENT_USES_USED_ASSESSMENT__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Using Assessment Uses Used Assessment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USING_ASSESSMENT_USES_USED_ASSESSMENT_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Using Assessment Uses Used Assessment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USING_ASSESSMENT_USES_USED_ASSESSMENT_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitMakesAssessmentImpl <em>Organization Unit Makes Assessment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitMakesAssessmentImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationUnitMakesAssessment()
	 * @generated
	 */
	int ORGANIZATION_UNIT_MAKES_ASSESSMENT = 36;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_MAKES_ASSESSMENT__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Organization Unit Makes Assessment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_MAKES_ASSESSMENT_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Organization Unit Makes Assessment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_MAKES_ASSESSMENT_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentCategoryCategorizesAssessmentImpl <em>Assessment Category Categorizes Assessment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentCategoryCategorizesAssessmentImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getAssessmentCategoryCategorizesAssessment()
	 * @generated
	 */
	int ASSESSMENT_CATEGORY_CATEGORIZES_ASSESSMENT = 37;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_CATEGORY_CATEGORIZES_ASSESSMENT__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Assessment Category Categorizes Assessment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_CATEGORY_CATEGORIZES_ASSESSMENT_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Assessment Category Categorizes Assessment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_CATEGORY_CATEGORIZES_ASSESSMENT_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentIdentifiesPotentialImpactImpl <em>Assessment Identifies Potential Impact</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentIdentifiesPotentialImpactImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getAssessmentIdentifiesPotentialImpact()
	 * @generated
	 */
	int ASSESSMENT_IDENTIFIES_POTENTIAL_IMPACT = 38;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_IDENTIFIES_POTENTIAL_IMPACT__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Assessment Identifies Potential Impact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_IDENTIFIES_POTENTIAL_IMPACT_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Assessment Identifies Potential Impact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_IDENTIFIES_POTENTIAL_IMPACT_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentAffectsAchievementOfEndImpl <em>Assessment Affects Achievement Of End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentAffectsAchievementOfEndImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getAssessmentAffectsAchievementOfEnd()
	 * @generated
	 */
	int ASSESSMENT_AFFECTS_ACHIEVEMENT_OF_END = 39;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_AFFECTS_ACHIEVEMENT_OF_END__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Assessment Affects Achievement Of End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_AFFECTS_ACHIEVEMENT_OF_END_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Assessment Affects Achievement Of End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_AFFECTS_ACHIEVEMENT_OF_END_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentAffectsEmploymentOfMeansImpl <em>Assessment Affects Employment Of Means</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentAffectsEmploymentOfMeansImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getAssessmentAffectsEmploymentOfMeans()
	 * @generated
	 */
	int ASSESSMENT_AFFECTS_EMPLOYMENT_OF_MEANS = 40;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_AFFECTS_EMPLOYMENT_OF_MEANS__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Assessment Affects Employment Of Means</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_AFFECTS_EMPLOYMENT_OF_MEANS_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Assessment Affects Employment Of Means</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_AFFECTS_EMPLOYMENT_OF_MEANS_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentProvidesImpetusForDirectiveImpl <em>Assessment Provides Impetus For Directive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentProvidesImpetusForDirectiveImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getAssessmentProvidesImpetusForDirective()
	 * @generated
	 */
	int ASSESSMENT_PROVIDES_IMPETUS_FOR_DIRECTIVE = 41;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_PROVIDES_IMPETUS_FOR_DIRECTIVE__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Assessment Provides Impetus For Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_PROVIDES_IMPETUS_FOR_DIRECTIVE_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Assessment Provides Impetus For Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_PROVIDES_IMPETUS_FOR_DIRECTIVE_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentIsJudgmentOfInfluencerImpl <em>Assessment Is Judgment Of Influencer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentIsJudgmentOfInfluencerImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getAssessmentIsJudgmentOfInfluencer()
	 * @generated
	 */
	int ASSESSMENT_IS_JUDGMENT_OF_INFLUENCER = 42;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_IS_JUDGMENT_OF_INFLUENCER__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Assessment Is Judgment Of Influencer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_IS_JUDGMENT_OF_INFLUENCER_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Assessment Is Judgment Of Influencer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSESSMENT_IS_JUDGMENT_OF_INFLUENCER_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategoryImpl <em>Broader Assessment Category Categorizes Narrower Assessment Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategoryImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory()
	 * @generated
	 */
	int BROADER_ASSESSMENT_CATEGORY_CATEGORIZES_NARROWER_ASSESSMENT_CATEGORY = 43;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_ASSESSMENT_CATEGORY_CATEGORIZES_NARROWER_ASSESSMENT_CATEGORY__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Broader Assessment Category Categorizes Narrower Assessment Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_ASSESSMENT_CATEGORY_CATEGORIZES_NARROWER_ASSESSMENT_CATEGORY_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Broader Assessment Category Categorizes Narrower Assessment Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_ASSESSMENT_CATEGORY_CATEGORIZES_NARROWER_ASSESSMENT_CATEGORY_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessProcessManagesAssetImpl <em>Business Process Manages Asset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessProcessManagesAssetImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBusinessProcessManagesAsset()
	 * @generated
	 */
	int BUSINESS_PROCESS_MANAGES_ASSET = 44;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_MANAGES_ASSET__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Business Process Manages Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_MANAGES_ASSET_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Business Process Manages Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_MANAGES_ASSET_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitIsResponsibleForAssetImpl <em>Organization Unit Is Responsible For Asset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitIsResponsibleForAssetImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationUnitIsResponsibleForAsset()
	 * @generated
	 */
	int ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_ASSET = 45;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_ASSET__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Organization Unit Is Responsible For Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_ASSET_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Organization Unit Is Responsible For Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_ASSET_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionDeploysAssetImpl <em>Course Of Action Deploys Asset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionDeploysAssetImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getCourseOfActionDeploysAsset()
	 * @generated
	 */
	int COURSE_OF_ACTION_DEPLOYS_ASSET = 46;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OF_ACTION_DEPLOYS_ASSET__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Course Of Action Deploys Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OF_ACTION_DEPLOYS_ASSET_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Course Of Action Deploys Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OF_ACTION_DEPLOYS_ASSET_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveGovernsUseOfAssetImpl <em>Directive Governs Use Of Asset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveGovernsUseOfAssetImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getDirectiveGovernsUseOfAsset()
	 * @generated
	 */
	int DIRECTIVE_GOVERNS_USE_OF_ASSET = 47;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE_GOVERNS_USE_OF_ASSET__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Directive Governs Use Of Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE_GOVERNS_USE_OF_ASSET_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Directive Governs Use Of Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE_GOVERNS_USE_OF_ASSET_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicyImpl <em>Broader Business Policy Includes More Specific Business Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicyImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy()
	 * @generated
	 */
	int BROADER_BUSINESS_POLICY_INCLUDES_MORE_SPECIFIC_BUSINESS_POLICY = 48;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_BUSINESS_POLICY_INCLUDES_MORE_SPECIFIC_BUSINESS_POLICY__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Broader Business Policy Includes More Specific Business Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_BUSINESS_POLICY_INCLUDES_MORE_SPECIFIC_BUSINESS_POLICY_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Broader Business Policy Includes More Specific Business Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_BUSINESS_POLICY_INCLUDES_MORE_SPECIFIC_BUSINESS_POLICY_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessPolicyIsBasisOfBusinessRuleImpl <em>Business Policy Is Basis Of Business Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessPolicyIsBasisOfBusinessRuleImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBusinessPolicyIsBasisOfBusinessRule()
	 * @generated
	 */
	int BUSINESS_POLICY_IS_BASIS_OF_BUSINESS_RULE = 49;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_POLICY_IS_BASIS_OF_BUSINESS_RULE__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Business Policy Is Basis Of Business Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_POLICY_IS_BASIS_OF_BUSINESS_RULE_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Business Policy Is Basis Of Business Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_POLICY_IS_BASIS_OF_BUSINESS_RULE_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessPolicyGovernsBusinessProcessImpl <em>Business Policy Governs Business Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessPolicyGovernsBusinessProcessImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBusinessPolicyGovernsBusinessProcess()
	 * @generated
	 */
	int BUSINESS_POLICY_GOVERNS_BUSINESS_PROCESS = 50;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_POLICY_GOVERNS_BUSINESS_PROCESS__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Business Policy Governs Business Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_POLICY_GOVERNS_BUSINESS_PROCESS_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Business Policy Governs Business Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_POLICY_GOVERNS_BUSINESS_PROCESS_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitIsResponsibleForBusinessProcessImpl <em>Organization Unit Is Responsible For Business Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitIsResponsibleForBusinessProcessImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationUnitIsResponsibleForBusinessProcess()
	 * @generated
	 */
	int ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_BUSINESS_PROCESS = 51;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_BUSINESS_PROCESS__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Organization Unit Is Responsible For Business Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_BUSINESS_PROCESS_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Organization Unit Is Responsible For Business Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_BUSINESS_PROCESS_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessRuleGuidesBusinessProcessImpl <em>Business Rule Guides Business Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessRuleGuidesBusinessProcessImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBusinessRuleGuidesBusinessProcess()
	 * @generated
	 */
	int BUSINESS_RULE_GUIDES_BUSINESS_PROCESS = 52;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_GUIDES_BUSINESS_PROCESS__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Business Rule Guides Business Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_GUIDES_BUSINESS_PROCESS_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Business Rule Guides Business Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_GUIDES_BUSINESS_PROCESS_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessProcessRealizesCourseOfActionImpl <em>Business Process Realizes Course Of Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessProcessRealizesCourseOfActionImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBusinessProcessRealizesCourseOfAction()
	 * @generated
	 */
	int BUSINESS_PROCESS_REALIZES_COURSE_OF_ACTION = 53;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_REALIZES_COURSE_OF_ACTION__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Business Process Realizes Course Of Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_REALIZES_COURSE_OF_ACTION_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Business Process Realizes Course Of Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_REALIZES_COURSE_OF_ACTION_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessProcessDeliversOfferingImpl <em>Business Process Delivers Offering</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessProcessDeliversOfferingImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBusinessProcessDeliversOffering()
	 * @generated
	 */
	int BUSINESS_PROCESS_DELIVERS_OFFERING = 54;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_DELIVERS_OFFERING__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Business Process Delivers Offering</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_DELIVERS_OFFERING_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Business Process Delivers Offering</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_DELIVERS_OFFERING_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.TacticEffectsEnforcementLevelOfBusinessRuleImpl <em>Tactic Effects Enforcement Level Of Business Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.TacticEffectsEnforcementLevelOfBusinessRuleImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getTacticEffectsEnforcementLevelOfBusinessRule()
	 * @generated
	 */
	int TACTIC_EFFECTS_ENFORCEMENT_LEVEL_OF_BUSINESS_RULE = 55;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIC_EFFECTS_ENFORCEMENT_LEVEL_OF_BUSINESS_RULE__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Tactic Effects Enforcement Level Of Business Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIC_EFFECTS_ENFORCEMENT_LEVEL_OF_BUSINESS_RULE_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tactic Effects Enforcement Level Of Business Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIC_EFFECTS_ENFORCEMENT_LEVEL_OF_BUSINESS_RULE_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveGovernsCourseOfActionImpl <em>Directive Governs Course Of Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveGovernsCourseOfActionImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getDirectiveGovernsCourseOfAction()
	 * @generated
	 */
	int DIRECTIVE_GOVERNS_COURSE_OF_ACTION = 56;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE_GOVERNS_COURSE_OF_ACTION__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Directive Governs Course Of Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE_GOVERNS_COURSE_OF_ACTION_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Directive Governs Course Of Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE_GOVERNS_COURSE_OF_ACTION_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderCourseOfActionIncludesMoreSpecificCourseOfActionImpl <em>Broader Course Of Action Includes More Specific Course Of Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderCourseOfActionIncludesMoreSpecificCourseOfActionImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBroaderCourseOfActionIncludesMoreSpecificCourseOfAction()
	 * @generated
	 */
	int BROADER_COURSE_OF_ACTION_INCLUDES_MORE_SPECIFIC_COURSE_OF_ACTION = 57;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_COURSE_OF_ACTION_INCLUDES_MORE_SPECIFIC_COURSE_OF_ACTION__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Broader Course Of Action Includes More Specific Course Of Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_COURSE_OF_ACTION_INCLUDES_MORE_SPECIFIC_COURSE_OF_ACTION_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Broader Course Of Action Includes More Specific Course Of Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_COURSE_OF_ACTION_INCLUDES_MORE_SPECIFIC_COURSE_OF_ACTION_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.EnablingCourseOfActionEnablesEnabledCourseOfActionImpl <em>Enabling Course Of Action Enables Enabled Course Of Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.EnablingCourseOfActionEnablesEnabledCourseOfActionImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getEnablingCourseOfActionEnablesEnabledCourseOfAction()
	 * @generated
	 */
	int ENABLING_COURSE_OF_ACTION_ENABLES_ENABLED_COURSE_OF_ACTION = 58;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLING_COURSE_OF_ACTION_ENABLES_ENABLED_COURSE_OF_ACTION__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Enabling Course Of Action Enables Enabled Course Of Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLING_COURSE_OF_ACTION_ENABLES_ENABLED_COURSE_OF_ACTION_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Enabling Course Of Action Enables Enabled Course Of Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLING_COURSE_OF_ACTION_ENABLES_ENABLED_COURSE_OF_ACTION_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionIsFormulatedBasedOnDirectiveImpl <em>Course Of Action Is Formulated Based On Directive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionIsFormulatedBasedOnDirectiveImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getCourseOfActionIsFormulatedBasedOnDirective()
	 * @generated
	 */
	int COURSE_OF_ACTION_IS_FORMULATED_BASED_ON_DIRECTIVE = 59;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OF_ACTION_IS_FORMULATED_BASED_ON_DIRECTIVE__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Course Of Action Is Formulated Based On Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OF_ACTION_IS_FORMULATED_BASED_ON_DIRECTIVE_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Course Of Action Is Formulated Based On Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OF_ACTION_IS_FORMULATED_BASED_ON_DIRECTIVE_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionDefinesOfferingImpl <em>Course Of Action Defines Offering</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionDefinesOfferingImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getCourseOfActionDefinesOffering()
	 * @generated
	 */
	int COURSE_OF_ACTION_DEFINES_OFFERING = 60;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OF_ACTION_DEFINES_OFFERING__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Course Of Action Defines Offering</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OF_ACTION_DEFINES_OFFERING_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Course Of Action Defines Offering</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OF_ACTION_DEFINES_OFFERING_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionDischargesLiabilityImpl <em>Course Of Action Discharges Liability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionDischargesLiabilityImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getCourseOfActionDischargesLiability()
	 * @generated
	 */
	int COURSE_OF_ACTION_DISCHARGES_LIABILITY = 61;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OF_ACTION_DISCHARGES_LIABILITY__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Course Of Action Discharges Liability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OF_ACTION_DISCHARGES_LIABILITY_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Course Of Action Discharges Liability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OF_ACTION_DISCHARGES_LIABILITY_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionChannelsEffortsTowardsDesiredResultImpl <em>Course Of Action Channels Efforts Towards Desired Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionChannelsEffortsTowardsDesiredResultImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getCourseOfActionChannelsEffortsTowardsDesiredResult()
	 * @generated
	 */
	int COURSE_OF_ACTION_CHANNELS_EFFORTS_TOWARDS_DESIRED_RESULT = 62;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OF_ACTION_CHANNELS_EFFORTS_TOWARDS_DESIRED_RESULT__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Course Of Action Channels Efforts Towards Desired Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OF_ACTION_CHANNELS_EFFORTS_TOWARDS_DESIRED_RESULT_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Course Of Action Channels Efforts Towards Desired Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OF_ACTION_CHANNELS_EFFORTS_TOWARDS_DESIRED_RESULT_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderDesiredResultIncludesMoreSpecificDesiredResultImpl <em>Broader Desired Result Includes More Specific Desired Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderDesiredResultIncludesMoreSpecificDesiredResultImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBroaderDesiredResultIncludesMoreSpecificDesiredResult()
	 * @generated
	 */
	int BROADER_DESIRED_RESULT_INCLUDES_MORE_SPECIFIC_DESIRED_RESULT = 63;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_DESIRED_RESULT_INCLUDES_MORE_SPECIFIC_DESIRED_RESULT__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Broader Desired Result Includes More Specific Desired Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_DESIRED_RESULT_INCLUDES_MORE_SPECIFIC_DESIRED_RESULT_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Broader Desired Result Includes More Specific Desired Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_DESIRED_RESULT_INCLUDES_MORE_SPECIFIC_DESIRED_RESULT_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.DesiredResultCategoryCategorizesDesiredResultImpl <em>Desired Result Category Categorizes Desired Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.DesiredResultCategoryCategorizesDesiredResultImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getDesiredResultCategoryCategorizesDesiredResult()
	 * @generated
	 */
	int DESIRED_RESULT_CATEGORY_CATEGORIZES_DESIRED_RESULT = 64;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIRED_RESULT_CATEGORY_CATEGORIZES_DESIRED_RESULT__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Desired Result Category Categorizes Desired Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIRED_RESULT_CATEGORY_CATEGORIZES_DESIRED_RESULT_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Desired Result Category Categorizes Desired Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIRED_RESULT_CATEGORY_CATEGORIZES_DESIRED_RESULT_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveSupportsAchievementOfDesiredResultImpl <em>Directive Supports Achievement Of Desired Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveSupportsAchievementOfDesiredResultImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getDirectiveSupportsAchievementOfDesiredResult()
	 * @generated
	 */
	int DIRECTIVE_SUPPORTS_ACHIEVEMENT_OF_DESIRED_RESULT = 65;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE_SUPPORTS_ACHIEVEMENT_OF_DESIRED_RESULT__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Directive Supports Achievement Of Desired Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE_SUPPORTS_ACHIEVEMENT_OF_DESIRED_RESULT_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Directive Supports Achievement Of Desired Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE_SUPPORTS_ACHIEVEMENT_OF_DESIRED_RESULT_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategoryImpl <em>Broader Desired Category Categorizes More Specific Desired Result Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategoryImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory()
	 * @generated
	 */
	int BROADER_DESIRED_CATEGORY_CATEGORIZES_MORE_SPECIFIC_DESIRED_RESULT_CATEGORY = 66;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_DESIRED_CATEGORY_CATEGORIZES_MORE_SPECIFIC_DESIRED_RESULT_CATEGORY__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Broader Desired Category Categorizes More Specific Desired Result Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_DESIRED_CATEGORY_CATEGORIZES_MORE_SPECIFIC_DESIRED_RESULT_CATEGORY_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Broader Desired Category Categorizes More Specific Desired Result Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_DESIRED_CATEGORY_CATEGORIZES_MORE_SPECIFIC_DESIRED_RESULT_CATEGORY_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.PotentialImpactProvidesImpetursForDirectiveImpl <em>Potential Impact Provides Impeturs For Directive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.PotentialImpactProvidesImpetursForDirectiveImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getPotentialImpactProvidesImpetursForDirective()
	 * @generated
	 */
	int POTENTIAL_IMPACT_PROVIDES_IMPETURS_FOR_DIRECTIVE = 67;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_IMPACT_PROVIDES_IMPETURS_FOR_DIRECTIVE__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Potential Impact Provides Impeturs For Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_IMPACT_PROVIDES_IMPETURS_FOR_DIRECTIVE_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Potential Impact Provides Impeturs For Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_IMPACT_PROVIDES_IMPETURS_FOR_DIRECTIVE_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveActsAsRegulationImpl <em>Directive Acts As Regulation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveActsAsRegulationImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getDirectiveActsAsRegulation()
	 * @generated
	 */
	int DIRECTIVE_ACTS_AS_REGULATION = 68;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE_ACTS_AS_REGULATION__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Directive Acts As Regulation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE_ACTS_AS_REGULATION_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Directive Acts As Regulation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTIVE_ACTS_AS_REGULATION_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitDefinesEndImpl <em>Organization Unit Defines End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitDefinesEndImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationUnitDefinesEnd()
	 * @generated
	 */
	int ORGANIZATION_UNIT_DEFINES_END = 69;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_DEFINES_END__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Organization Unit Defines End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_DEFINES_END_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Organization Unit Defines End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_DEFINES_END_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OfferingUsesFixedAssetImpl <em>Offering Uses Fixed Asset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OfferingUsesFixedAssetImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOfferingUsesFixedAsset()
	 * @generated
	 */
	int OFFERING_USES_FIXED_ASSET = 70;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFERING_USES_FIXED_ASSET__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Offering Uses Fixed Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFERING_USES_FIXED_ASSET_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Offering Uses Fixed Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFERING_USES_FIXED_ASSET_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.FixedAssetProvidesResourceImpl <em>Fixed Asset Provides Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.FixedAssetProvidesResourceImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getFixedAssetProvidesResource()
	 * @generated
	 */
	int FIXED_ASSET_PROVIDES_RESOURCE = 71;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_ASSET_PROVIDES_RESOURCE__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Fixed Asset Provides Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_ASSET_PROVIDES_RESOURCE_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Fixed Asset Provides Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_ASSET_PROVIDES_RESOURCE_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.ObjectiveQuantitiesGoalImpl <em>Objective Quantities Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.ObjectiveQuantitiesGoalImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getObjectiveQuantitiesGoal()
	 * @generated
	 */
	int OBJECTIVE_QUANTITIES_GOAL = 72;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTIVE_QUANTITIES_GOAL__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Objective Quantities Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTIVE_QUANTITIES_GOAL_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Objective Quantities Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTIVE_QUANTITIES_GOAL_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.GoalAmplifiesVisionImpl <em>Goal Amplifies Vision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.GoalAmplifiesVisionImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getGoalAmplifiesVision()
	 * @generated
	 */
	int GOAL_AMPLIFIES_VISION = 73;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_AMPLIFIES_VISION__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Goal Amplifies Vision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_AMPLIFIES_VISION_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Goal Amplifies Vision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_AMPLIFIES_VISION_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitRecognizesInfluencerImpl <em>Organization Unit Recognizes Influencer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitRecognizesInfluencerImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationUnitRecognizesInfluencer()
	 * @generated
	 */
	int ORGANIZATION_UNIT_RECOGNIZES_INFLUENCER = 74;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_RECOGNIZES_INFLUENCER__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Organization Unit Recognizes Influencer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_RECOGNIZES_INFLUENCER_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Organization Unit Recognizes Influencer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_RECOGNIZES_INFLUENCER_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencingOrganizationIsSourceofInfluencerImpl <em>Influencing Organization Is Sourceof Influencer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencingOrganizationIsSourceofInfluencerImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getInfluencingOrganizationIsSourceofInfluencer()
	 * @generated
	 */
	int INFLUENCING_ORGANIZATION_IS_SOURCEOF_INFLUENCER = 75;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLUENCING_ORGANIZATION_IS_SOURCEOF_INFLUENCER__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Influencing Organization Is Sourceof Influencer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLUENCING_ORGANIZATION_IS_SOURCEOF_INFLUENCER_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Influencing Organization Is Sourceof Influencer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLUENCING_ORGANIZATION_IS_SOURCEOF_INFLUENCER_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencerCategoryCategorizesInfluencerImpl <em>Influencer Category Categorizes Influencer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencerCategoryCategorizesInfluencerImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getInfluencerCategoryCategorizesInfluencer()
	 * @generated
	 */
	int INFLUENCER_CATEGORY_CATEGORIZES_INFLUENCER = 76;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLUENCER_CATEGORY_CATEGORIZES_INFLUENCER__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Influencer Category Categorizes Influencer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLUENCER_CATEGORY_CATEGORIZES_INFLUENCER_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Influencer Category Categorizes Influencer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFLUENCER_CATEGORY_CATEGORIZES_INFLUENCER_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderInfluencerCategorizesNarrowerInfluencerCategoryImpl <em>Broader Influencer Categorizes Narrower Influencer Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderInfluencerCategorizesNarrowerInfluencerCategoryImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBroaderInfluencerCategorizesNarrowerInfluencerCategory()
	 * @generated
	 */
	int BROADER_INFLUENCER_CATEGORIZES_NARROWER_INFLUENCER_CATEGORY = 77;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_INFLUENCER_CATEGORIZES_NARROWER_INFLUENCER_CATEGORY__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Broader Influencer Categorizes Narrower Influencer Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_INFLUENCER_CATEGORIZES_NARROWER_INFLUENCER_CATEGORY_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Broader Influencer Categorizes Narrower Influencer Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_INFLUENCER_CATEGORIZES_NARROWER_INFLUENCER_CATEGORY_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationCategoryCategorizesInfluencingOrganizationImpl <em>Organization Category Categorizes Influencing Organization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationCategoryCategorizesInfluencingOrganizationImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationCategoryCategorizesInfluencingOrganization()
	 * @generated
	 */
	int ORGANIZATION_CATEGORY_CATEGORIZES_INFLUENCING_ORGANIZATION = 78;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_CATEGORY_CATEGORIZES_INFLUENCING_ORGANIZATION__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Organization Category Categorizes Influencing Organization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_CATEGORY_CATEGORIZES_INFLUENCING_ORGANIZATION_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Organization Category Categorizes Influencing Organization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_CATEGORY_CATEGORIZES_INFLUENCING_ORGANIZATION_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitActsAsInfluencingOrganizationImpl <em>Organization Unit Acts As Influencing Organization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitActsAsInfluencingOrganizationImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationUnitActsAsInfluencingOrganization()
	 * @generated
	 */
	int ORGANIZATION_UNIT_ACTS_AS_INFLUENCING_ORGANIZATION = 79;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_ACTS_AS_INFLUENCING_ORGANIZATION__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Organization Unit Acts As Influencing Organization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_ACTS_AS_INFLUENCING_ORGANIZATION_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Organization Unit Acts As Influencing Organization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_ACTS_AS_INFLUENCING_ORGANIZATION_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitIsResponsibleForLiabilityImpl <em>Organization Unit Is Responsible For Liability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitIsResponsibleForLiabilityImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationUnitIsResponsibleForLiability()
	 * @generated
	 */
	int ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_LIABILITY = 80;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_LIABILITY__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Organization Unit Is Responsible For Liability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_LIABILITY_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Organization Unit Is Responsible For Liability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_LIABILITY_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.LiabilityClaimsResourceImpl <em>Liability Claims Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.LiabilityClaimsResourceImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getLiabilityClaimsResource()
	 * @generated
	 */
	int LIABILITY_CLAIMS_RESOURCE = 81;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIABILITY_CLAIMS_RESOURCE__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Liability Claims Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIABILITY_CLAIMS_RESOURCE_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Liability Claims Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIABILITY_CLAIMS_RESOURCE_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitEstablishesMeansImpl <em>Organization Unit Establishes Means</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitEstablishesMeansImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationUnitEstablishesMeans()
	 * @generated
	 */
	int ORGANIZATION_UNIT_ESTABLISHES_MEANS = 82;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_ESTABLISHES_MEANS__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Organization Unit Establishes Means</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_ESTABLISHES_MEANS_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Organization Unit Establishes Means</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_UNIT_ESTABLISHES_MEANS_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.StrategyIsAComponentfOfThe_PlanForMIssionImpl <em>Strategy Is AComponentf Of The Plan For MIssion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.StrategyIsAComponentfOfThe_PlanForMIssionImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getStrategyIsAComponentfOfThe_PlanForMIssion()
	 * @generated
	 */
	int STRATEGY_IS_ACOMPONENTF_OF_THE_PLAN_FOR_MISSION = 83;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_IS_ACOMPONENTF_OF_THE_PLAN_FOR_MISSION__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Strategy Is AComponentf Of The Plan For MIssion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_IS_ACOMPONENTF_OF_THE_PLAN_FOR_MISSION_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Strategy Is AComponentf Of The Plan For MIssion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_IS_ACOMPONENTF_OF_THE_PLAN_FOR_MISSION_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.MissionMakesOperativeVisionImpl <em>Mission Makes Operative Vision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.MissionMakesOperativeVisionImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getMissionMakesOperativeVision()
	 * @generated
	 */
	int MISSION_MAKES_OPERATIVE_VISION = 84;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_MAKES_OPERATIVE_VISION__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Mission Makes Operative Vision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_MAKES_OPERATIVE_VISION_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mission Makes Operative Vision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSION_MAKES_OPERATIVE_VISION_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OfferingRequiresResourceImpl <em>Offering Requires Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OfferingRequiresResourceImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOfferingRequiresResource()
	 * @generated
	 */
	int OFFERING_REQUIRES_RESOURCE = 85;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFERING_REQUIRES_RESOURCE__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Offering Requires Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFERING_REQUIRES_RESOURCE_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Offering Requires Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFERING_REQUIRES_RESOURCE_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategoryImpl <em>Broader Organization Category Categorizes Narrower Organization Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategoryImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory()
	 * @generated
	 */
	int BROADER_ORGANIZATION_CATEGORY_CATEGORIZES_NARROWER_ORGANIZATION_CATEGORY = 86;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_ORGANIZATION_CATEGORY_CATEGORIZES_NARROWER_ORGANIZATION_CATEGORY__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Broader Organization Category Categorizes Narrower Organization Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_ORGANIZATION_CATEGORY_CATEGORIZES_NARROWER_ORGANIZATION_CATEGORY_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Broader Organization Category Categorizes Narrower Organization Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADER_ORGANIZATION_CATEGORY_CATEGORIZES_NARROWER_ORGANIZATION_CATEGORY_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.StrategyDeterminesOrganizationUnitImpl <em>Strategy Determines Organization Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.StrategyDeterminesOrganizationUnitImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getStrategyDeterminesOrganizationUnit()
	 * @generated
	 */
	int STRATEGY_DETERMINES_ORGANIZATION_UNIT = 87;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_DETERMINES_ORGANIZATION_UNIT__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Strategy Determines Organization Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_DETERMINES_ORGANIZATION_UNIT_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Strategy Determines Organization Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_DETERMINES_ORGANIZATION_UNIT_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.TacticImplementsStrategyImpl <em>Tactic Implements Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.TacticImplementsStrategyImpl
	 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getTacticImplementsStrategy()
	 * @generated
	 */
	int TACTIC_IMPLEMENTS_STRATEGY = 88;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIC_IMPLEMENTS_STRATEGY__BASE_DEPENDENCY = MOTIVATION_EDGE__BASE_DEPENDENCY;

	/**
	 * The number of structural features of the '<em>Tactic Implements Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIC_IMPLEMENTS_STRATEGY_FEATURE_COUNT = MOTIVATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tactic Implements Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIC_IMPLEMENTS_STRATEGY_OPERATION_COUNT = MOTIVATION_EDGE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.MotivationElement <em>Motivation Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Motivation Element</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.MotivationElement
	 * @generated
	 */
	EClass getMotivationElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.req.bmm.Bmm.MotivationElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.MotivationElement#getDescription()
	 * @see #getMotivationElement()
	 * @generated
	 */
	EAttribute getMotivationElement_Description();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.req.bmm.Bmm.MotivationElement#getBase_Artifact <em>Base Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Artifact</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.MotivationElement#getBase_Artifact()
	 * @see #getMotivationElement()
	 * @generated
	 */
	EReference getMotivationElement_Base_Artifact();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.Assessment <em>Assessment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assessment</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Assessment
	 * @generated
	 */
	EClass getAssessment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnit <em>Organization Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organization Unit</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnit
	 * @generated
	 */
	EClass getOrganizationUnit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.Strategy <em>Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Strategy</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Strategy
	 * @generated
	 */
	EClass getStrategy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.CourseOfAction <em>Course Of Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Course Of Action</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.CourseOfAction
	 * @generated
	 */
	EClass getCourseOfAction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.Means <em>Means</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Means</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Means
	 * @generated
	 */
	EClass getMeans();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.Directive <em>Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Directive</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Directive
	 * @generated
	 */
	EClass getDirective();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.PotentialImpact <em>Potential Impact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Potential Impact</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.PotentialImpact
	 * @generated
	 */
	EClass getPotentialImpact();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.Regulation <em>Regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Regulation</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Regulation
	 * @generated
	 */
	EClass getRegulation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.ExternalInfluencer <em>External Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Influencer</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.ExternalInfluencer
	 * @generated
	 */
	EClass getExternalInfluencer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.Influencer <em>Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Influencer</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Influencer
	 * @generated
	 */
	EClass getInfluencer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.InfluencingOrganization <em>Influencing Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Influencing Organization</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.InfluencingOrganization
	 * @generated
	 */
	EClass getInfluencingOrganization();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationCategory <em>Organization Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organization Category</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationCategory
	 * @generated
	 */
	EClass getOrganizationCategory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.InfluencerCategory <em>Influencer Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Influencer Category</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.InfluencerCategory
	 * @generated
	 */
	EClass getInfluencerCategory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.DesiredResult <em>Desired Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Desired Result</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.DesiredResult
	 * @generated
	 */
	EClass getDesiredResult();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.End <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.End
	 * @generated
	 */
	EClass getEnd();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.DesiredResultCategory <em>Desired Result Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Desired Result Category</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.DesiredResultCategory
	 * @generated
	 */
	EClass getDesiredResultCategory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.Asset <em>Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Asset</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Asset
	 * @generated
	 */
	EClass getAsset();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.BusinessProcess <em>Business Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business Process</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BusinessProcess
	 * @generated
	 */
	EClass getBusinessProcess();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.BusinessRule <em>Business Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business Rule</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BusinessRule
	 * @generated
	 */
	EClass getBusinessRule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.BusinessPolicy <em>Business Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business Policy</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BusinessPolicy
	 * @generated
	 */
	EClass getBusinessPolicy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.Tactic <em>Tactic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tactic</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Tactic
	 * @generated
	 */
	EClass getTactic();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.Offering <em>Offering</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Offering</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Offering
	 * @generated
	 */
	EClass getOffering();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.FixedAsset <em>Fixed Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed Asset</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.FixedAsset
	 * @generated
	 */
	EClass getFixedAsset();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.Liability <em>Liability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Liability</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Liability
	 * @generated
	 */
	EClass getLiability();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.Mission <em>Mission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mission</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Mission
	 * @generated
	 */
	EClass getMission();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.Vision <em>Vision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vision</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Vision
	 * @generated
	 */
	EClass getVision();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.Goal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Goal
	 * @generated
	 */
	EClass getGoal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.Objective <em>Objective</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Objective</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Objective
	 * @generated
	 */
	EClass getObjective();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.AssessmentCategory <em>Assessment Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assessment Category</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.AssessmentCategory
	 * @generated
	 */
	EClass getAssessmentCategory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.InternalInfluencer <em>Internal Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Influencer</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.InternalInfluencer
	 * @generated
	 */
	EClass getInternalInfluencer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.PotentialReward <em>Potential Reward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Potential Reward</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.PotentialReward
	 * @generated
	 */
	EClass getPotentialReward();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.Risk <em>Risk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Risk</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.Risk
	 * @generated
	 */
	EClass getRisk();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.MotivationEdge <em>Motivation Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Motivation Edge</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.MotivationEdge
	 * @generated
	 */
	EClass getMotivationEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.req.bmm.Bmm.MotivationEdge#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.MotivationEdge#getBase_Dependency()
	 * @see #getMotivationEdge()
	 * @generated
	 */
	EReference getMotivationEdge_Base_Dependency();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.UsingAssessmentUsesUsedAssessment <em>Using Assessment Uses Used Assessment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Using Assessment Uses Used Assessment</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.UsingAssessmentUsesUsedAssessment
	 * @generated
	 */
	EClass getUsingAssessmentUsesUsedAssessment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitMakesAssessment <em>Organization Unit Makes Assessment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organization Unit Makes Assessment</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitMakesAssessment
	 * @generated
	 */
	EClass getOrganizationUnitMakesAssessment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.AssessmentCategoryCategorizesAssessment <em>Assessment Category Categorizes Assessment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assessment Category Categorizes Assessment</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.AssessmentCategoryCategorizesAssessment
	 * @generated
	 */
	EClass getAssessmentCategoryCategorizesAssessment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.AssessmentIdentifiesPotentialImpact <em>Assessment Identifies Potential Impact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assessment Identifies Potential Impact</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.AssessmentIdentifiesPotentialImpact
	 * @generated
	 */
	EClass getAssessmentIdentifiesPotentialImpact();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.AssessmentAffectsAchievementOfEnd <em>Assessment Affects Achievement Of End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assessment Affects Achievement Of End</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.AssessmentAffectsAchievementOfEnd
	 * @generated
	 */
	EClass getAssessmentAffectsAchievementOfEnd();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.AssessmentAffectsEmploymentOfMeans <em>Assessment Affects Employment Of Means</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assessment Affects Employment Of Means</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.AssessmentAffectsEmploymentOfMeans
	 * @generated
	 */
	EClass getAssessmentAffectsEmploymentOfMeans();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.AssessmentProvidesImpetusForDirective <em>Assessment Provides Impetus For Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assessment Provides Impetus For Directive</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.AssessmentProvidesImpetusForDirective
	 * @generated
	 */
	EClass getAssessmentProvidesImpetusForDirective();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.AssessmentIsJudgmentOfInfluencer <em>Assessment Is Judgment Of Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assessment Is Judgment Of Influencer</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.AssessmentIsJudgmentOfInfluencer
	 * @generated
	 */
	EClass getAssessmentIsJudgmentOfInfluencer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory <em>Broader Assessment Category Categorizes Narrower Assessment Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Broader Assessment Category Categorizes Narrower Assessment Category</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory
	 * @generated
	 */
	EClass getBroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.BusinessProcessManagesAsset <em>Business Process Manages Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business Process Manages Asset</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BusinessProcessManagesAsset
	 * @generated
	 */
	EClass getBusinessProcessManagesAsset();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitIsResponsibleForAsset <em>Organization Unit Is Responsible For Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organization Unit Is Responsible For Asset</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitIsResponsibleForAsset
	 * @generated
	 */
	EClass getOrganizationUnitIsResponsibleForAsset();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionDeploysAsset <em>Course Of Action Deploys Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Course Of Action Deploys Asset</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionDeploysAsset
	 * @generated
	 */
	EClass getCourseOfActionDeploysAsset();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.DirectiveGovernsUseOfAsset <em>Directive Governs Use Of Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Directive Governs Use Of Asset</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.DirectiveGovernsUseOfAsset
	 * @generated
	 */
	EClass getDirectiveGovernsUseOfAsset();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy <em>Broader Business Policy Includes More Specific Business Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Broader Business Policy Includes More Specific Business Policy</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy
	 * @generated
	 */
	EClass getBroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.BusinessPolicyIsBasisOfBusinessRule <em>Business Policy Is Basis Of Business Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business Policy Is Basis Of Business Rule</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BusinessPolicyIsBasisOfBusinessRule
	 * @generated
	 */
	EClass getBusinessPolicyIsBasisOfBusinessRule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.BusinessPolicyGovernsBusinessProcess <em>Business Policy Governs Business Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business Policy Governs Business Process</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BusinessPolicyGovernsBusinessProcess
	 * @generated
	 */
	EClass getBusinessPolicyGovernsBusinessProcess();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitIsResponsibleForBusinessProcess <em>Organization Unit Is Responsible For Business Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organization Unit Is Responsible For Business Process</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitIsResponsibleForBusinessProcess
	 * @generated
	 */
	EClass getOrganizationUnitIsResponsibleForBusinessProcess();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.BusinessRuleGuidesBusinessProcess <em>Business Rule Guides Business Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business Rule Guides Business Process</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BusinessRuleGuidesBusinessProcess
	 * @generated
	 */
	EClass getBusinessRuleGuidesBusinessProcess();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.BusinessProcessRealizesCourseOfAction <em>Business Process Realizes Course Of Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business Process Realizes Course Of Action</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BusinessProcessRealizesCourseOfAction
	 * @generated
	 */
	EClass getBusinessProcessRealizesCourseOfAction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.BusinessProcessDeliversOffering <em>Business Process Delivers Offering</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business Process Delivers Offering</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BusinessProcessDeliversOffering
	 * @generated
	 */
	EClass getBusinessProcessDeliversOffering();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.TacticEffectsEnforcementLevelOfBusinessRule <em>Tactic Effects Enforcement Level Of Business Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tactic Effects Enforcement Level Of Business Rule</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.TacticEffectsEnforcementLevelOfBusinessRule
	 * @generated
	 */
	EClass getTacticEffectsEnforcementLevelOfBusinessRule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.DirectiveGovernsCourseOfAction <em>Directive Governs Course Of Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Directive Governs Course Of Action</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.DirectiveGovernsCourseOfAction
	 * @generated
	 */
	EClass getDirectiveGovernsCourseOfAction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.BroaderCourseOfActionIncludesMoreSpecificCourseOfAction <em>Broader Course Of Action Includes More Specific Course Of Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Broader Course Of Action Includes More Specific Course Of Action</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BroaderCourseOfActionIncludesMoreSpecificCourseOfAction
	 * @generated
	 */
	EClass getBroaderCourseOfActionIncludesMoreSpecificCourseOfAction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.EnablingCourseOfActionEnablesEnabledCourseOfAction <em>Enabling Course Of Action Enables Enabled Course Of Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enabling Course Of Action Enables Enabled Course Of Action</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.EnablingCourseOfActionEnablesEnabledCourseOfAction
	 * @generated
	 */
	EClass getEnablingCourseOfActionEnablesEnabledCourseOfAction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionIsFormulatedBasedOnDirective <em>Course Of Action Is Formulated Based On Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Course Of Action Is Formulated Based On Directive</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionIsFormulatedBasedOnDirective
	 * @generated
	 */
	EClass getCourseOfActionIsFormulatedBasedOnDirective();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionDefinesOffering <em>Course Of Action Defines Offering</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Course Of Action Defines Offering</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionDefinesOffering
	 * @generated
	 */
	EClass getCourseOfActionDefinesOffering();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionDischargesLiability <em>Course Of Action Discharges Liability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Course Of Action Discharges Liability</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionDischargesLiability
	 * @generated
	 */
	EClass getCourseOfActionDischargesLiability();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionChannelsEffortsTowardsDesiredResult <em>Course Of Action Channels Efforts Towards Desired Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Course Of Action Channels Efforts Towards Desired Result</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.CourseOfActionChannelsEffortsTowardsDesiredResult
	 * @generated
	 */
	EClass getCourseOfActionChannelsEffortsTowardsDesiredResult();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.BroaderDesiredResultIncludesMoreSpecificDesiredResult <em>Broader Desired Result Includes More Specific Desired Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Broader Desired Result Includes More Specific Desired Result</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BroaderDesiredResultIncludesMoreSpecificDesiredResult
	 * @generated
	 */
	EClass getBroaderDesiredResultIncludesMoreSpecificDesiredResult();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.DesiredResultCategoryCategorizesDesiredResult <em>Desired Result Category Categorizes Desired Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Desired Result Category Categorizes Desired Result</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.DesiredResultCategoryCategorizesDesiredResult
	 * @generated
	 */
	EClass getDesiredResultCategoryCategorizesDesiredResult();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.DirectiveSupportsAchievementOfDesiredResult <em>Directive Supports Achievement Of Desired Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Directive Supports Achievement Of Desired Result</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.DirectiveSupportsAchievementOfDesiredResult
	 * @generated
	 */
	EClass getDirectiveSupportsAchievementOfDesiredResult();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory <em>Broader Desired Category Categorizes More Specific Desired Result Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Broader Desired Category Categorizes More Specific Desired Result Category</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory
	 * @generated
	 */
	EClass getBroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.PotentialImpactProvidesImpetursForDirective <em>Potential Impact Provides Impeturs For Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Potential Impact Provides Impeturs For Directive</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.PotentialImpactProvidesImpetursForDirective
	 * @generated
	 */
	EClass getPotentialImpactProvidesImpetursForDirective();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.DirectiveActsAsRegulation <em>Directive Acts As Regulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Directive Acts As Regulation</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.DirectiveActsAsRegulation
	 * @generated
	 */
	EClass getDirectiveActsAsRegulation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitDefinesEnd <em>Organization Unit Defines End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organization Unit Defines End</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitDefinesEnd
	 * @generated
	 */
	EClass getOrganizationUnitDefinesEnd();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.OfferingUsesFixedAsset <em>Offering Uses Fixed Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Offering Uses Fixed Asset</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OfferingUsesFixedAsset
	 * @generated
	 */
	EClass getOfferingUsesFixedAsset();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.FixedAssetProvidesResource <em>Fixed Asset Provides Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed Asset Provides Resource</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.FixedAssetProvidesResource
	 * @generated
	 */
	EClass getFixedAssetProvidesResource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.ObjectiveQuantitiesGoal <em>Objective Quantities Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Objective Quantities Goal</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.ObjectiveQuantitiesGoal
	 * @generated
	 */
	EClass getObjectiveQuantitiesGoal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.GoalAmplifiesVision <em>Goal Amplifies Vision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal Amplifies Vision</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.GoalAmplifiesVision
	 * @generated
	 */
	EClass getGoalAmplifiesVision();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitRecognizesInfluencer <em>Organization Unit Recognizes Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organization Unit Recognizes Influencer</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitRecognizesInfluencer
	 * @generated
	 */
	EClass getOrganizationUnitRecognizesInfluencer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.InfluencingOrganizationIsSourceofInfluencer <em>Influencing Organization Is Sourceof Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Influencing Organization Is Sourceof Influencer</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.InfluencingOrganizationIsSourceofInfluencer
	 * @generated
	 */
	EClass getInfluencingOrganizationIsSourceofInfluencer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.InfluencerCategoryCategorizesInfluencer <em>Influencer Category Categorizes Influencer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Influencer Category Categorizes Influencer</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.InfluencerCategoryCategorizesInfluencer
	 * @generated
	 */
	EClass getInfluencerCategoryCategorizesInfluencer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.BroaderInfluencerCategorizesNarrowerInfluencerCategory <em>Broader Influencer Categorizes Narrower Influencer Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Broader Influencer Categorizes Narrower Influencer Category</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BroaderInfluencerCategorizesNarrowerInfluencerCategory
	 * @generated
	 */
	EClass getBroaderInfluencerCategorizesNarrowerInfluencerCategory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationCategoryCategorizesInfluencingOrganization <em>Organization Category Categorizes Influencing Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organization Category Categorizes Influencing Organization</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationCategoryCategorizesInfluencingOrganization
	 * @generated
	 */
	EClass getOrganizationCategoryCategorizesInfluencingOrganization();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitActsAsInfluencingOrganization <em>Organization Unit Acts As Influencing Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organization Unit Acts As Influencing Organization</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitActsAsInfluencingOrganization
	 * @generated
	 */
	EClass getOrganizationUnitActsAsInfluencingOrganization();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitIsResponsibleForLiability <em>Organization Unit Is Responsible For Liability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organization Unit Is Responsible For Liability</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitIsResponsibleForLiability
	 * @generated
	 */
	EClass getOrganizationUnitIsResponsibleForLiability();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.LiabilityClaimsResource <em>Liability Claims Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Liability Claims Resource</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.LiabilityClaimsResource
	 * @generated
	 */
	EClass getLiabilityClaimsResource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitEstablishesMeans <em>Organization Unit Establishes Means</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organization Unit Establishes Means</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OrganizationUnitEstablishesMeans
	 * @generated
	 */
	EClass getOrganizationUnitEstablishesMeans();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.StrategyIsAComponentfOfThe_PlanForMIssion <em>Strategy Is AComponentf Of The Plan For MIssion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Strategy Is AComponentf Of The Plan For MIssion</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.StrategyIsAComponentfOfThe_PlanForMIssion
	 * @generated
	 */
	EClass getStrategyIsAComponentfOfThe_PlanForMIssion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.MissionMakesOperativeVision <em>Mission Makes Operative Vision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mission Makes Operative Vision</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.MissionMakesOperativeVision
	 * @generated
	 */
	EClass getMissionMakesOperativeVision();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.OfferingRequiresResource <em>Offering Requires Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Offering Requires Resource</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.OfferingRequiresResource
	 * @generated
	 */
	EClass getOfferingRequiresResource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory <em>Broader Organization Category Categorizes Narrower Organization Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Broader Organization Category Categorizes Narrower Organization Category</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory
	 * @generated
	 */
	EClass getBroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.StrategyDeterminesOrganizationUnit <em>Strategy Determines Organization Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Strategy Determines Organization Unit</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.StrategyDeterminesOrganizationUnit
	 * @generated
	 */
	EClass getStrategyDeterminesOrganizationUnit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.req.bmm.Bmm.TacticImplementsStrategy <em>Tactic Implements Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tactic Implements Strategy</em>'.
	 * @see org.eclipse.papyrus.req.bmm.Bmm.TacticImplementsStrategy
	 * @generated
	 */
	EClass getTacticImplementsStrategy();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BmmFactory getBmmFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.MotivationElementImpl <em>Motivation Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.MotivationElementImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getMotivationElement()
		 * @generated
		 */
		EClass MOTIVATION_ELEMENT = eINSTANCE.getMotivationElement();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOTIVATION_ELEMENT__DESCRIPTION = eINSTANCE.getMotivationElement_Description();

		/**
		 * The meta object literal for the '<em><b>Base Artifact</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOTIVATION_ELEMENT__BASE_ARTIFACT = eINSTANCE.getMotivationElement_Base_Artifact();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentImpl <em>Assessment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getAssessment()
		 * @generated
		 */
		EClass ASSESSMENT = eINSTANCE.getAssessment();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitImpl <em>Organization Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationUnit()
		 * @generated
		 */
		EClass ORGANIZATION_UNIT = eINSTANCE.getOrganizationUnit();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.StrategyImpl <em>Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.StrategyImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getStrategy()
		 * @generated
		 */
		EClass STRATEGY = eINSTANCE.getStrategy();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionImpl <em>Course Of Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getCourseOfAction()
		 * @generated
		 */
		EClass COURSE_OF_ACTION = eINSTANCE.getCourseOfAction();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.MeansImpl <em>Means</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.MeansImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getMeans()
		 * @generated
		 */
		EClass MEANS = eINSTANCE.getMeans();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveImpl <em>Directive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getDirective()
		 * @generated
		 */
		EClass DIRECTIVE = eINSTANCE.getDirective();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.PotentialImpactImpl <em>Potential Impact</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.PotentialImpactImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getPotentialImpact()
		 * @generated
		 */
		EClass POTENTIAL_IMPACT = eINSTANCE.getPotentialImpact();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.RegulationImpl <em>Regulation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.RegulationImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getRegulation()
		 * @generated
		 */
		EClass REGULATION = eINSTANCE.getRegulation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.ExternalInfluencerImpl <em>External Influencer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.ExternalInfluencerImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getExternalInfluencer()
		 * @generated
		 */
		EClass EXTERNAL_INFLUENCER = eINSTANCE.getExternalInfluencer();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencerImpl <em>Influencer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencerImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getInfluencer()
		 * @generated
		 */
		EClass INFLUENCER = eINSTANCE.getInfluencer();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencingOrganizationImpl <em>Influencing Organization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencingOrganizationImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getInfluencingOrganization()
		 * @generated
		 */
		EClass INFLUENCING_ORGANIZATION = eINSTANCE.getInfluencingOrganization();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationCategoryImpl <em>Organization Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationCategoryImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationCategory()
		 * @generated
		 */
		EClass ORGANIZATION_CATEGORY = eINSTANCE.getOrganizationCategory();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencerCategoryImpl <em>Influencer Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencerCategoryImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getInfluencerCategory()
		 * @generated
		 */
		EClass INFLUENCER_CATEGORY = eINSTANCE.getInfluencerCategory();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.DesiredResultImpl <em>Desired Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.DesiredResultImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getDesiredResult()
		 * @generated
		 */
		EClass DESIRED_RESULT = eINSTANCE.getDesiredResult();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.EndImpl <em>End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.EndImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getEnd()
		 * @generated
		 */
		EClass END = eINSTANCE.getEnd();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.DesiredResultCategoryImpl <em>Desired Result Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.DesiredResultCategoryImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getDesiredResultCategory()
		 * @generated
		 */
		EClass DESIRED_RESULT_CATEGORY = eINSTANCE.getDesiredResultCategory();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.AssetImpl <em>Asset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.AssetImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getAsset()
		 * @generated
		 */
		EClass ASSET = eINSTANCE.getAsset();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessProcessImpl <em>Business Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessProcessImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBusinessProcess()
		 * @generated
		 */
		EClass BUSINESS_PROCESS = eINSTANCE.getBusinessProcess();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessRuleImpl <em>Business Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessRuleImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBusinessRule()
		 * @generated
		 */
		EClass BUSINESS_RULE = eINSTANCE.getBusinessRule();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessPolicyImpl <em>Business Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessPolicyImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBusinessPolicy()
		 * @generated
		 */
		EClass BUSINESS_POLICY = eINSTANCE.getBusinessPolicy();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.TacticImpl <em>Tactic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.TacticImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getTactic()
		 * @generated
		 */
		EClass TACTIC = eINSTANCE.getTactic();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OfferingImpl <em>Offering</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OfferingImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOffering()
		 * @generated
		 */
		EClass OFFERING = eINSTANCE.getOffering();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.FixedAssetImpl <em>Fixed Asset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.FixedAssetImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getFixedAsset()
		 * @generated
		 */
		EClass FIXED_ASSET = eINSTANCE.getFixedAsset();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.ResourceImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.LiabilityImpl <em>Liability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.LiabilityImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getLiability()
		 * @generated
		 */
		EClass LIABILITY = eINSTANCE.getLiability();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.MissionImpl <em>Mission</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.MissionImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getMission()
		 * @generated
		 */
		EClass MISSION = eINSTANCE.getMission();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.VisionImpl <em>Vision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.VisionImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getVision()
		 * @generated
		 */
		EClass VISION = eINSTANCE.getVision();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.GoalImpl <em>Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.GoalImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getGoal()
		 * @generated
		 */
		EClass GOAL = eINSTANCE.getGoal();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.ObjectiveImpl <em>Objective</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.ObjectiveImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getObjective()
		 * @generated
		 */
		EClass OBJECTIVE = eINSTANCE.getObjective();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentCategoryImpl <em>Assessment Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentCategoryImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getAssessmentCategory()
		 * @generated
		 */
		EClass ASSESSMENT_CATEGORY = eINSTANCE.getAssessmentCategory();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.InternalInfluencerImpl <em>Internal Influencer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.InternalInfluencerImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getInternalInfluencer()
		 * @generated
		 */
		EClass INTERNAL_INFLUENCER = eINSTANCE.getInternalInfluencer();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.PotentialRewardImpl <em>Potential Reward</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.PotentialRewardImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getPotentialReward()
		 * @generated
		 */
		EClass POTENTIAL_REWARD = eINSTANCE.getPotentialReward();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.RiskImpl <em>Risk</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.RiskImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getRisk()
		 * @generated
		 */
		EClass RISK = eINSTANCE.getRisk();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.MotivationEdgeImpl <em>Motivation Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.MotivationEdgeImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getMotivationEdge()
		 * @generated
		 */
		EClass MOTIVATION_EDGE = eINSTANCE.getMotivationEdge();

		/**
		 * The meta object literal for the '<em><b>Base Dependency</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOTIVATION_EDGE__BASE_DEPENDENCY = eINSTANCE.getMotivationEdge_Base_Dependency();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.UsingAssessmentUsesUsedAssessmentImpl <em>Using Assessment Uses Used Assessment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.UsingAssessmentUsesUsedAssessmentImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getUsingAssessmentUsesUsedAssessment()
		 * @generated
		 */
		EClass USING_ASSESSMENT_USES_USED_ASSESSMENT = eINSTANCE.getUsingAssessmentUsesUsedAssessment();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitMakesAssessmentImpl <em>Organization Unit Makes Assessment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitMakesAssessmentImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationUnitMakesAssessment()
		 * @generated
		 */
		EClass ORGANIZATION_UNIT_MAKES_ASSESSMENT = eINSTANCE.getOrganizationUnitMakesAssessment();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentCategoryCategorizesAssessmentImpl <em>Assessment Category Categorizes Assessment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentCategoryCategorizesAssessmentImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getAssessmentCategoryCategorizesAssessment()
		 * @generated
		 */
		EClass ASSESSMENT_CATEGORY_CATEGORIZES_ASSESSMENT = eINSTANCE.getAssessmentCategoryCategorizesAssessment();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentIdentifiesPotentialImpactImpl <em>Assessment Identifies Potential Impact</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentIdentifiesPotentialImpactImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getAssessmentIdentifiesPotentialImpact()
		 * @generated
		 */
		EClass ASSESSMENT_IDENTIFIES_POTENTIAL_IMPACT = eINSTANCE.getAssessmentIdentifiesPotentialImpact();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentAffectsAchievementOfEndImpl <em>Assessment Affects Achievement Of End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentAffectsAchievementOfEndImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getAssessmentAffectsAchievementOfEnd()
		 * @generated
		 */
		EClass ASSESSMENT_AFFECTS_ACHIEVEMENT_OF_END = eINSTANCE.getAssessmentAffectsAchievementOfEnd();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentAffectsEmploymentOfMeansImpl <em>Assessment Affects Employment Of Means</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentAffectsEmploymentOfMeansImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getAssessmentAffectsEmploymentOfMeans()
		 * @generated
		 */
		EClass ASSESSMENT_AFFECTS_EMPLOYMENT_OF_MEANS = eINSTANCE.getAssessmentAffectsEmploymentOfMeans();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentProvidesImpetusForDirectiveImpl <em>Assessment Provides Impetus For Directive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentProvidesImpetusForDirectiveImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getAssessmentProvidesImpetusForDirective()
		 * @generated
		 */
		EClass ASSESSMENT_PROVIDES_IMPETUS_FOR_DIRECTIVE = eINSTANCE.getAssessmentProvidesImpetusForDirective();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentIsJudgmentOfInfluencerImpl <em>Assessment Is Judgment Of Influencer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.AssessmentIsJudgmentOfInfluencerImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getAssessmentIsJudgmentOfInfluencer()
		 * @generated
		 */
		EClass ASSESSMENT_IS_JUDGMENT_OF_INFLUENCER = eINSTANCE.getAssessmentIsJudgmentOfInfluencer();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategoryImpl <em>Broader Assessment Category Categorizes Narrower Assessment Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderAssessmentCategoryCategorizesNarrowerAssessmentCategoryImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory()
		 * @generated
		 */
		EClass BROADER_ASSESSMENT_CATEGORY_CATEGORIZES_NARROWER_ASSESSMENT_CATEGORY = eINSTANCE.getBroaderAssessmentCategoryCategorizesNarrowerAssessmentCategory();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessProcessManagesAssetImpl <em>Business Process Manages Asset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessProcessManagesAssetImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBusinessProcessManagesAsset()
		 * @generated
		 */
		EClass BUSINESS_PROCESS_MANAGES_ASSET = eINSTANCE.getBusinessProcessManagesAsset();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitIsResponsibleForAssetImpl <em>Organization Unit Is Responsible For Asset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitIsResponsibleForAssetImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationUnitIsResponsibleForAsset()
		 * @generated
		 */
		EClass ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_ASSET = eINSTANCE.getOrganizationUnitIsResponsibleForAsset();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionDeploysAssetImpl <em>Course Of Action Deploys Asset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionDeploysAssetImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getCourseOfActionDeploysAsset()
		 * @generated
		 */
		EClass COURSE_OF_ACTION_DEPLOYS_ASSET = eINSTANCE.getCourseOfActionDeploysAsset();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveGovernsUseOfAssetImpl <em>Directive Governs Use Of Asset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveGovernsUseOfAssetImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getDirectiveGovernsUseOfAsset()
		 * @generated
		 */
		EClass DIRECTIVE_GOVERNS_USE_OF_ASSET = eINSTANCE.getDirectiveGovernsUseOfAsset();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicyImpl <em>Broader Business Policy Includes More Specific Business Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderBusinessPolicyIncludesMoreSpecificBusinessPolicyImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy()
		 * @generated
		 */
		EClass BROADER_BUSINESS_POLICY_INCLUDES_MORE_SPECIFIC_BUSINESS_POLICY = eINSTANCE.getBroaderBusinessPolicyIncludesMoreSpecificBusinessPolicy();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessPolicyIsBasisOfBusinessRuleImpl <em>Business Policy Is Basis Of Business Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessPolicyIsBasisOfBusinessRuleImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBusinessPolicyIsBasisOfBusinessRule()
		 * @generated
		 */
		EClass BUSINESS_POLICY_IS_BASIS_OF_BUSINESS_RULE = eINSTANCE.getBusinessPolicyIsBasisOfBusinessRule();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessPolicyGovernsBusinessProcessImpl <em>Business Policy Governs Business Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessPolicyGovernsBusinessProcessImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBusinessPolicyGovernsBusinessProcess()
		 * @generated
		 */
		EClass BUSINESS_POLICY_GOVERNS_BUSINESS_PROCESS = eINSTANCE.getBusinessPolicyGovernsBusinessProcess();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitIsResponsibleForBusinessProcessImpl <em>Organization Unit Is Responsible For Business Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitIsResponsibleForBusinessProcessImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationUnitIsResponsibleForBusinessProcess()
		 * @generated
		 */
		EClass ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_BUSINESS_PROCESS = eINSTANCE.getOrganizationUnitIsResponsibleForBusinessProcess();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessRuleGuidesBusinessProcessImpl <em>Business Rule Guides Business Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessRuleGuidesBusinessProcessImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBusinessRuleGuidesBusinessProcess()
		 * @generated
		 */
		EClass BUSINESS_RULE_GUIDES_BUSINESS_PROCESS = eINSTANCE.getBusinessRuleGuidesBusinessProcess();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessProcessRealizesCourseOfActionImpl <em>Business Process Realizes Course Of Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessProcessRealizesCourseOfActionImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBusinessProcessRealizesCourseOfAction()
		 * @generated
		 */
		EClass BUSINESS_PROCESS_REALIZES_COURSE_OF_ACTION = eINSTANCE.getBusinessProcessRealizesCourseOfAction();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessProcessDeliversOfferingImpl <em>Business Process Delivers Offering</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BusinessProcessDeliversOfferingImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBusinessProcessDeliversOffering()
		 * @generated
		 */
		EClass BUSINESS_PROCESS_DELIVERS_OFFERING = eINSTANCE.getBusinessProcessDeliversOffering();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.TacticEffectsEnforcementLevelOfBusinessRuleImpl <em>Tactic Effects Enforcement Level Of Business Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.TacticEffectsEnforcementLevelOfBusinessRuleImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getTacticEffectsEnforcementLevelOfBusinessRule()
		 * @generated
		 */
		EClass TACTIC_EFFECTS_ENFORCEMENT_LEVEL_OF_BUSINESS_RULE = eINSTANCE.getTacticEffectsEnforcementLevelOfBusinessRule();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveGovernsCourseOfActionImpl <em>Directive Governs Course Of Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveGovernsCourseOfActionImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getDirectiveGovernsCourseOfAction()
		 * @generated
		 */
		EClass DIRECTIVE_GOVERNS_COURSE_OF_ACTION = eINSTANCE.getDirectiveGovernsCourseOfAction();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderCourseOfActionIncludesMoreSpecificCourseOfActionImpl <em>Broader Course Of Action Includes More Specific Course Of Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderCourseOfActionIncludesMoreSpecificCourseOfActionImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBroaderCourseOfActionIncludesMoreSpecificCourseOfAction()
		 * @generated
		 */
		EClass BROADER_COURSE_OF_ACTION_INCLUDES_MORE_SPECIFIC_COURSE_OF_ACTION = eINSTANCE.getBroaderCourseOfActionIncludesMoreSpecificCourseOfAction();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.EnablingCourseOfActionEnablesEnabledCourseOfActionImpl <em>Enabling Course Of Action Enables Enabled Course Of Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.EnablingCourseOfActionEnablesEnabledCourseOfActionImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getEnablingCourseOfActionEnablesEnabledCourseOfAction()
		 * @generated
		 */
		EClass ENABLING_COURSE_OF_ACTION_ENABLES_ENABLED_COURSE_OF_ACTION = eINSTANCE.getEnablingCourseOfActionEnablesEnabledCourseOfAction();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionIsFormulatedBasedOnDirectiveImpl <em>Course Of Action Is Formulated Based On Directive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionIsFormulatedBasedOnDirectiveImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getCourseOfActionIsFormulatedBasedOnDirective()
		 * @generated
		 */
		EClass COURSE_OF_ACTION_IS_FORMULATED_BASED_ON_DIRECTIVE = eINSTANCE.getCourseOfActionIsFormulatedBasedOnDirective();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionDefinesOfferingImpl <em>Course Of Action Defines Offering</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionDefinesOfferingImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getCourseOfActionDefinesOffering()
		 * @generated
		 */
		EClass COURSE_OF_ACTION_DEFINES_OFFERING = eINSTANCE.getCourseOfActionDefinesOffering();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionDischargesLiabilityImpl <em>Course Of Action Discharges Liability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionDischargesLiabilityImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getCourseOfActionDischargesLiability()
		 * @generated
		 */
		EClass COURSE_OF_ACTION_DISCHARGES_LIABILITY = eINSTANCE.getCourseOfActionDischargesLiability();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionChannelsEffortsTowardsDesiredResultImpl <em>Course Of Action Channels Efforts Towards Desired Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.CourseOfActionChannelsEffortsTowardsDesiredResultImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getCourseOfActionChannelsEffortsTowardsDesiredResult()
		 * @generated
		 */
		EClass COURSE_OF_ACTION_CHANNELS_EFFORTS_TOWARDS_DESIRED_RESULT = eINSTANCE.getCourseOfActionChannelsEffortsTowardsDesiredResult();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderDesiredResultIncludesMoreSpecificDesiredResultImpl <em>Broader Desired Result Includes More Specific Desired Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderDesiredResultIncludesMoreSpecificDesiredResultImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBroaderDesiredResultIncludesMoreSpecificDesiredResult()
		 * @generated
		 */
		EClass BROADER_DESIRED_RESULT_INCLUDES_MORE_SPECIFIC_DESIRED_RESULT = eINSTANCE.getBroaderDesiredResultIncludesMoreSpecificDesiredResult();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.DesiredResultCategoryCategorizesDesiredResultImpl <em>Desired Result Category Categorizes Desired Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.DesiredResultCategoryCategorizesDesiredResultImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getDesiredResultCategoryCategorizesDesiredResult()
		 * @generated
		 */
		EClass DESIRED_RESULT_CATEGORY_CATEGORIZES_DESIRED_RESULT = eINSTANCE.getDesiredResultCategoryCategorizesDesiredResult();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveSupportsAchievementOfDesiredResultImpl <em>Directive Supports Achievement Of Desired Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveSupportsAchievementOfDesiredResultImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getDirectiveSupportsAchievementOfDesiredResult()
		 * @generated
		 */
		EClass DIRECTIVE_SUPPORTS_ACHIEVEMENT_OF_DESIRED_RESULT = eINSTANCE.getDirectiveSupportsAchievementOfDesiredResult();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategoryImpl <em>Broader Desired Category Categorizes More Specific Desired Result Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategoryImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory()
		 * @generated
		 */
		EClass BROADER_DESIRED_CATEGORY_CATEGORIZES_MORE_SPECIFIC_DESIRED_RESULT_CATEGORY = eINSTANCE.getBroaderDesiredCategoryCategorizesMoreSpecificDesiredResultCategory();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.PotentialImpactProvidesImpetursForDirectiveImpl <em>Potential Impact Provides Impeturs For Directive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.PotentialImpactProvidesImpetursForDirectiveImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getPotentialImpactProvidesImpetursForDirective()
		 * @generated
		 */
		EClass POTENTIAL_IMPACT_PROVIDES_IMPETURS_FOR_DIRECTIVE = eINSTANCE.getPotentialImpactProvidesImpetursForDirective();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveActsAsRegulationImpl <em>Directive Acts As Regulation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.DirectiveActsAsRegulationImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getDirectiveActsAsRegulation()
		 * @generated
		 */
		EClass DIRECTIVE_ACTS_AS_REGULATION = eINSTANCE.getDirectiveActsAsRegulation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitDefinesEndImpl <em>Organization Unit Defines End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitDefinesEndImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationUnitDefinesEnd()
		 * @generated
		 */
		EClass ORGANIZATION_UNIT_DEFINES_END = eINSTANCE.getOrganizationUnitDefinesEnd();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OfferingUsesFixedAssetImpl <em>Offering Uses Fixed Asset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OfferingUsesFixedAssetImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOfferingUsesFixedAsset()
		 * @generated
		 */
		EClass OFFERING_USES_FIXED_ASSET = eINSTANCE.getOfferingUsesFixedAsset();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.FixedAssetProvidesResourceImpl <em>Fixed Asset Provides Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.FixedAssetProvidesResourceImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getFixedAssetProvidesResource()
		 * @generated
		 */
		EClass FIXED_ASSET_PROVIDES_RESOURCE = eINSTANCE.getFixedAssetProvidesResource();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.ObjectiveQuantitiesGoalImpl <em>Objective Quantities Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.ObjectiveQuantitiesGoalImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getObjectiveQuantitiesGoal()
		 * @generated
		 */
		EClass OBJECTIVE_QUANTITIES_GOAL = eINSTANCE.getObjectiveQuantitiesGoal();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.GoalAmplifiesVisionImpl <em>Goal Amplifies Vision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.GoalAmplifiesVisionImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getGoalAmplifiesVision()
		 * @generated
		 */
		EClass GOAL_AMPLIFIES_VISION = eINSTANCE.getGoalAmplifiesVision();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitRecognizesInfluencerImpl <em>Organization Unit Recognizes Influencer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitRecognizesInfluencerImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationUnitRecognizesInfluencer()
		 * @generated
		 */
		EClass ORGANIZATION_UNIT_RECOGNIZES_INFLUENCER = eINSTANCE.getOrganizationUnitRecognizesInfluencer();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencingOrganizationIsSourceofInfluencerImpl <em>Influencing Organization Is Sourceof Influencer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencingOrganizationIsSourceofInfluencerImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getInfluencingOrganizationIsSourceofInfluencer()
		 * @generated
		 */
		EClass INFLUENCING_ORGANIZATION_IS_SOURCEOF_INFLUENCER = eINSTANCE.getInfluencingOrganizationIsSourceofInfluencer();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencerCategoryCategorizesInfluencerImpl <em>Influencer Category Categorizes Influencer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.InfluencerCategoryCategorizesInfluencerImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getInfluencerCategoryCategorizesInfluencer()
		 * @generated
		 */
		EClass INFLUENCER_CATEGORY_CATEGORIZES_INFLUENCER = eINSTANCE.getInfluencerCategoryCategorizesInfluencer();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderInfluencerCategorizesNarrowerInfluencerCategoryImpl <em>Broader Influencer Categorizes Narrower Influencer Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderInfluencerCategorizesNarrowerInfluencerCategoryImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBroaderInfluencerCategorizesNarrowerInfluencerCategory()
		 * @generated
		 */
		EClass BROADER_INFLUENCER_CATEGORIZES_NARROWER_INFLUENCER_CATEGORY = eINSTANCE.getBroaderInfluencerCategorizesNarrowerInfluencerCategory();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationCategoryCategorizesInfluencingOrganizationImpl <em>Organization Category Categorizes Influencing Organization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationCategoryCategorizesInfluencingOrganizationImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationCategoryCategorizesInfluencingOrganization()
		 * @generated
		 */
		EClass ORGANIZATION_CATEGORY_CATEGORIZES_INFLUENCING_ORGANIZATION = eINSTANCE.getOrganizationCategoryCategorizesInfluencingOrganization();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitActsAsInfluencingOrganizationImpl <em>Organization Unit Acts As Influencing Organization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitActsAsInfluencingOrganizationImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationUnitActsAsInfluencingOrganization()
		 * @generated
		 */
		EClass ORGANIZATION_UNIT_ACTS_AS_INFLUENCING_ORGANIZATION = eINSTANCE.getOrganizationUnitActsAsInfluencingOrganization();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitIsResponsibleForLiabilityImpl <em>Organization Unit Is Responsible For Liability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitIsResponsibleForLiabilityImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationUnitIsResponsibleForLiability()
		 * @generated
		 */
		EClass ORGANIZATION_UNIT_IS_RESPONSIBLE_FOR_LIABILITY = eINSTANCE.getOrganizationUnitIsResponsibleForLiability();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.LiabilityClaimsResourceImpl <em>Liability Claims Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.LiabilityClaimsResourceImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getLiabilityClaimsResource()
		 * @generated
		 */
		EClass LIABILITY_CLAIMS_RESOURCE = eINSTANCE.getLiabilityClaimsResource();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitEstablishesMeansImpl <em>Organization Unit Establishes Means</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OrganizationUnitEstablishesMeansImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOrganizationUnitEstablishesMeans()
		 * @generated
		 */
		EClass ORGANIZATION_UNIT_ESTABLISHES_MEANS = eINSTANCE.getOrganizationUnitEstablishesMeans();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.StrategyIsAComponentfOfThe_PlanForMIssionImpl <em>Strategy Is AComponentf Of The Plan For MIssion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.StrategyIsAComponentfOfThe_PlanForMIssionImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getStrategyIsAComponentfOfThe_PlanForMIssion()
		 * @generated
		 */
		EClass STRATEGY_IS_ACOMPONENTF_OF_THE_PLAN_FOR_MISSION = eINSTANCE.getStrategyIsAComponentfOfThe_PlanForMIssion();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.MissionMakesOperativeVisionImpl <em>Mission Makes Operative Vision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.MissionMakesOperativeVisionImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getMissionMakesOperativeVision()
		 * @generated
		 */
		EClass MISSION_MAKES_OPERATIVE_VISION = eINSTANCE.getMissionMakesOperativeVision();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.OfferingRequiresResourceImpl <em>Offering Requires Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.OfferingRequiresResourceImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getOfferingRequiresResource()
		 * @generated
		 */
		EClass OFFERING_REQUIRES_RESOURCE = eINSTANCE.getOfferingRequiresResource();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategoryImpl <em>Broader Organization Category Categorizes Narrower Organization Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BroaderOrganizationCategoryCategorizesNarrowerOrganizationCategoryImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getBroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory()
		 * @generated
		 */
		EClass BROADER_ORGANIZATION_CATEGORY_CATEGORIZES_NARROWER_ORGANIZATION_CATEGORY = eINSTANCE.getBroaderOrganizationCategoryCategorizesNarrowerOrganizationCategory();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.StrategyDeterminesOrganizationUnitImpl <em>Strategy Determines Organization Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.StrategyDeterminesOrganizationUnitImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getStrategyDeterminesOrganizationUnit()
		 * @generated
		 */
		EClass STRATEGY_DETERMINES_ORGANIZATION_UNIT = eINSTANCE.getStrategyDeterminesOrganizationUnit();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.req.bmm.Bmm.impl.TacticImplementsStrategyImpl <em>Tactic Implements Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.TacticImplementsStrategyImpl
		 * @see org.eclipse.papyrus.req.bmm.Bmm.impl.BmmPackageImpl#getTacticImplementsStrategy()
		 * @generated
		 */
		EClass TACTIC_IMPLEMENTS_STRATEGY = eINSTANCE.getTacticImplementsStrategy();

	}

} //BmmPackage
