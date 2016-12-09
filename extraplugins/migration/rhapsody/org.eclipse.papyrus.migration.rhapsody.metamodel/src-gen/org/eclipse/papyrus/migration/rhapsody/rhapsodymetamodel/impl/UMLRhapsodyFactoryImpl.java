/**
 *   Copyright (c) 2016 CEA LIST and others.
 *   
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *     CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UMLRhapsodyFactoryImpl extends EFactoryImpl implements UMLRhapsodyFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UMLRhapsodyFactory init() {
		try {
			UMLRhapsodyFactory theUMLRhapsodyFactory = (UMLRhapsodyFactory)EPackage.Registry.INSTANCE.getEFactory(UMLRhapsodyPackage.eNS_URI);
			if (theUMLRhapsodyFactory != null) {
				return theUMLRhapsodyFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UMLRhapsodyFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLRhapsodyFactoryImpl() {
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
			case UMLRhapsodyPackage.CCOLLABORATION_CHART: return createCCollaborationChart();
			case UMLRhapsodyPackage.CGI_ACTION_STATE: return createCGIActionState();
			case UMLRhapsodyPackage.CGI_ACTIVE_X: return createCGIActiveX();
			case UMLRhapsodyPackage.CGI_ANCHOR: return createCGIAnchor();
			case UMLRhapsodyPackage.CGI_ANNOTATION: return createCGIAnnotation();
			case UMLRhapsodyPackage.CGI_ARROW: return createCGIArrow();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_END: return createCGIAssociationEnd();
			case UMLRhapsodyPackage.CGI_ASSOCIATION_ROLE: return createCGIAssociationRole();
			case UMLRhapsodyPackage.CGI_BASIC_CLASS: return createCGIBasicClass();
			case UMLRhapsodyPackage.CGI_BLOCK_STATE: return createCGIBlockState();
			case UMLRhapsodyPackage.CGI_BOX: return createCGIBox();
			case UMLRhapsodyPackage.CGI_BUTTON_ARRAY: return createCGIButtonArray();
			case UMLRhapsodyPackage.CGI_CLASS: return createCGIClass();
			case UMLRhapsodyPackage.CGI_CLASS_CHART: return createCGIClassChart();
			case UMLRhapsodyPackage.CGI_CLASSIFIER_ROLE: return createCGIClassifierRole();
			case UMLRhapsodyPackage.CGI_COMPARTMENT: return createCGICompartment();
			case UMLRhapsodyPackage.CGI_COMPONENT: return createCGIComponent();
			case UMLRhapsodyPackage.CGI_COMPOSITE_CLASS: return createCGICompositeClass();
			case UMLRhapsodyPackage.CGI_CONNECTOR: return createCGIConnector();
			case UMLRhapsodyPackage.CGI_CONTAIN_ARROW: return createCGIContainArrow();
			case UMLRhapsodyPackage.CGI_DIAGRAM_FRAME: return createCGIDiagramFrame();
			case UMLRhapsodyPackage.CGI_FREE_SHAPE: return createCGIFreeShape();
			case UMLRhapsodyPackage.CGI_FREE_TEXT: return createCGIFreeText();
			case UMLRhapsodyPackage.CGI_GENERIC_ELEMENT: return createCGIGenericElement();
			case UMLRhapsodyPackage.CGI_IMAGE: return createCGIImage();
			case UMLRhapsodyPackage.CGI_IMAGE_DATA: return createCGIImageData();
			case UMLRhapsodyPackage.CGI_INFORMATION_FLOW: return createCGIInformationFlow();
			case UMLRhapsodyPackage.CGI_INHERITANCE: return createCGIInheritance();
			case UMLRhapsodyPackage.CGIMFC_CTRL: return createCGIMFCCtrl();
			case UMLRhapsodyPackage.CGI_MESSAGE_LABEL: return createCGIMessageLabel();
			case UMLRhapsodyPackage.CGI_MSC_CHART: return createCGIMscChart();
			case UMLRhapsodyPackage.CGI_MSC_COLUMN_CR: return createCGIMscColumnCR();
			case UMLRhapsodyPackage.CGI_MSC_CONDITION_MARK: return createCGIMscConditionMark();
			case UMLRhapsodyPackage.CGI_MSC_EXECUTION_OCCURRENCE: return createCGIMscExecutionOccurrence();
			case UMLRhapsodyPackage.CGI_MSC_INTERACTION_OCCURRENCE: return createCGIMscInteractionOccurrence();
			case UMLRhapsodyPackage.CGI_MSC_INTERACTION_OPERAND: return createCGIMscInteractionOperand();
			case UMLRhapsodyPackage.CGI_MSC_INTERACTION_OPERATOR: return createCGIMscInteractionOperator();
			case UMLRhapsodyPackage.CGI_MSC_MESSAGE: return createCGIMscMessage();
			case UMLRhapsodyPackage.CGI_OBJECT_INSTANCE: return createCGIObjectInstance();
			case UMLRhapsodyPackage.CGI_OBJECT_LINK: return createCGIObjectLink();
			case UMLRhapsodyPackage.CGI_PACKAGE: return createCGIPackage();
			case UMLRhapsodyPackage.CGI_PARTITION: return createCGIPartition();
			case UMLRhapsodyPackage.CGI_PORT_CONNECTOR: return createCGIPortConnector();
			case UMLRhapsodyPackage.CGI_STATE: return createCGIState();
			case UMLRhapsodyPackage.CGI_STATE_CHART: return createCGIStateChart();
			case UMLRhapsodyPackage.CGI_SWIMLANE_FRAME: return createCGISwimlaneFrame();
			case UMLRhapsodyPackage.CGI_TEXT: return createCGIText();
			case UMLRhapsodyPackage.CGI_TEXT_BOX: return createCGITextBox();
			case UMLRhapsodyPackage.CGI_TRANS: return createCGITrans();
			case UMLRhapsodyPackage.COLL_EVENT: return createCollEvent();
			case UMLRhapsodyPackage.IACCEPT_EVENT_ACTION: return createIAcceptEventAction();
			case UMLRhapsodyPackage.IACCEPT_TIME_EVENT: return createIAcceptTimeEvent();
			case UMLRhapsodyPackage.IACTION: return createIAction();
			case UMLRhapsodyPackage.IACTIVITY_DIAGRAM: return createIActivityDiagram();
			case UMLRhapsodyPackage.IACTIVITY_GRAPH: return createIActivityGraph();
			case UMLRhapsodyPackage.IACTOR: return createIActor();
			case UMLRhapsodyPackage.IANCHOR: return createIAnchor();
			case UMLRhapsodyPackage.IANNOTATION: return createIAnnotation();
			case UMLRhapsodyPackage.IARGUMENT: return createIArgument();
			case UMLRhapsodyPackage.IASSOCIATION_CLASS: return createIAssociationClass();
			case UMLRhapsodyPackage.IASSOCIATION_END: return createIAssociationEnd();
			case UMLRhapsodyPackage.IASSOCIATION_END_HANDLE: return createIAssociationEndHandle();
			case UMLRhapsodyPackage.IASSOCIATION_ROLE: return createIAssociationRole();
			case UMLRhapsodyPackage.IATTRIBUTE: return createIAttribute();
			case UMLRhapsodyPackage.IBLOCK: return createIBlock();
			case UMLRhapsodyPackage.IBODY: return createIBody();
			case UMLRhapsodyPackage.IBRANCH: return createIBranch();
			case UMLRhapsodyPackage.ICALL_ACTION: return createICallAction();
			case UMLRhapsodyPackage.ICALL_OPERATION: return createICallOperation();
			case UMLRhapsodyPackage.ICLASS: return createIClass();
			case UMLRhapsodyPackage.ICLASS_HANDLE: return createIClassHandle();
			case UMLRhapsodyPackage.ICLASS_INSTANCE: return createIClassInstance();
			case UMLRhapsodyPackage.ICLASSIFIER: return createIClassifier();
			case UMLRhapsodyPackage.ICLASSIFIER_ROLE: return createIClassifierRole();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO: return createICodeGenConfigInfo();
			case UMLRhapsodyPackage.ICODE_GEN_CONFIG_INFO_HANDLE: return createICodeGenConfigInfoHandle();
			case UMLRhapsodyPackage.ICOLLABORATION: return createICollaboration();
			case UMLRhapsodyPackage.ICOLLABORATION_DIAGRAM: return createICollaborationDiagram();
			case UMLRhapsodyPackage.ICOLOR: return createIColor();
			case UMLRhapsodyPackage.ICOMBINED_FRAGMENT: return createICombinedFragment();
			case UMLRhapsodyPackage.ICOMMENT: return createIComment();
			case UMLRhapsodyPackage.ICOMPONENT: return createIComponent();
			case UMLRhapsodyPackage.ICOMPONENT_DIAGRAM: return createIComponentDiagram();
			case UMLRhapsodyPackage.ICOMPONENT_INSTANCE: return createIComponentInstance();
			case UMLRhapsodyPackage.ICONFIGURATION: return createIConfiguration();
			case UMLRhapsodyPackage.ICONNECTOR: return createIConnector();
			case UMLRhapsodyPackage.ICONSTRAINT: return createIConstraint();
			case UMLRhapsodyPackage.ICONSTRUCTOR: return createIConstructor();
			case UMLRhapsodyPackage.ICONTEXT_SPECIFICATION: return createIContextSpecification();
			case UMLRhapsodyPackage.ICONTROLLED_FILE: return createIControlledFile();
			case UMLRhapsodyPackage.IDEFAULT_DRVD_TRANS: return createIDefaultDrvdTrans();
			case UMLRhapsodyPackage.IDEPENDENCY: return createIDependency();
			case UMLRhapsodyPackage.IDEPLOYMENT_DIAGRAM: return createIDeploymentDiagram();
			case UMLRhapsodyPackage.IDESCRIPTION: return createIDescription();
			case UMLRhapsodyPackage.IDESTRUCTOR: return createIDestructor();
			case UMLRhapsodyPackage.IDIAGRAM: return createIDiagram();
			case UMLRhapsodyPackage.IEMBEDED_FILE: return createIEmbededFile();
			case UMLRhapsodyPackage.IENUMERATION_LITERAL: return createIEnumerationLiteral();
			case UMLRhapsodyPackage.IEVENT: return createIEvent();
			case UMLRhapsodyPackage.IEVENT_HANDLE: return createIEventHandle();
			case UMLRhapsodyPackage.IEVENT_RECEPTION: return createIEventReception();
			case UMLRhapsodyPackage.IEXECUTION_OCCURRENCE: return createIExecutionOccurrence();
			case UMLRhapsodyPackage.IEXTERNAL_HYPERLINK: return createIExternalHyperlink();
			case UMLRhapsodyPackage.IFILE: return createIFile();
			case UMLRhapsodyPackage.IFILE_FRAGMENT: return createIFileFragment();
			case UMLRhapsodyPackage.IFLOW: return createIFlow();
			case UMLRhapsodyPackage.IFLOW_ITEM: return createIFlowItem();
			case UMLRhapsodyPackage.IFLOWCHART: return createIFlowchart();
			case UMLRhapsodyPackage.IFOLDER: return createIFolder();
			case UMLRhapsodyPackage.IFORK: return createIFork();
			case UMLRhapsodyPackage.IGENERALIZATION: return createIGeneralization();
			case UMLRhapsodyPackage.IGUARD: return createIGuard();
			case UMLRhapsodyPackage.IHANDLE_WITH_DATA: return createIHandleWithData();
			case UMLRhapsodyPackage.IHISTORY_CONNECTOR: return createIHistoryConnector();
			case UMLRhapsodyPackage.IHYPER_LINK: return createIHyperLink();
			case UMLRhapsodyPackage.IINFORMATION_FLOW: return createIInformationFlow();
			case UMLRhapsodyPackage.IINFORMATION_ITEM: return createIInformationItem();
			case UMLRhapsodyPackage.IINSTANCE: return createIInstance();
			case UMLRhapsodyPackage.IINSTANCE_SLOT: return createIInstanceSlot();
			case UMLRhapsodyPackage.IINSTANCE_SPECIFICATION: return createIInstanceSpecification();
			case UMLRhapsodyPackage.IINSTANCE_VALUE: return createIInstanceValue();
			case UMLRhapsodyPackage.IINTERACTION_OCCURRENCE: return createIInteractionOccurrence();
			case UMLRhapsodyPackage.IINTERACTION_OPERAND: return createIInteractionOperand();
			case UMLRhapsodyPackage.IINTERACTION_OPERATOR: return createIInteractionOperator();
			case UMLRhapsodyPackage.IINTERFACE_ITEM: return createIInterfaceItem();
			case UMLRhapsodyPackage.IINTERFACE_ITEM_TRIGGER: return createIInterfaceItemTrigger();
			case UMLRhapsodyPackage.IINTERNAL_HYPERLINK: return createIInternalHyperlink();
			case UMLRhapsodyPackage.ILABEL: return createILabel();
			case UMLRhapsodyPackage.ILINK: return createILink();
			case UMLRhapsodyPackage.ILINK_INSTANCE: return createILinkInstance();
			case UMLRhapsodyPackage.ILITERAL_SPECIFICATION: return createILiteralSpecification();
			case UMLRhapsodyPackage.IM_HYPER_LINK: return createIMHyperLink();
			case UMLRhapsodyPackage.IMSC: return createIMSC();
			case UMLRhapsodyPackage.IMATRIX_INSTANCE: return createIMatrixInstance();
			case UMLRhapsodyPackage.IMATRIX_LAYOUT: return createIMatrixLayout();
			case UMLRhapsodyPackage.IMATRIX_VIEW: return createIMatrixView();
			case UMLRhapsodyPackage.IMESSAGE: return createIMessage();
			case UMLRhapsodyPackage.IMESSAGE_POINT: return createIMessagePoint();
			case UMLRhapsodyPackage.IMETA_LINK_HANDLE: return createIMetaLinkHandle();
			case UMLRhapsodyPackage.IMODEL_ELEMENT: return createIModelElement();
			case UMLRhapsodyPackage.IMODULE: return createIModule();
			case UMLRhapsodyPackage.IMULTIPLICITY_ITEM: return createIMultiplicityItem();
			case UMLRhapsodyPackage.INODE: return createINode();
			case UMLRhapsodyPackage.IOBJECT_LINK: return createIObjectLink();
			case UMLRhapsodyPackage.IOBJECT_LINK_HANDLE: return createIObjectLinkHandle();
			case UMLRhapsodyPackage.IOBJECT_MODEL_DIAGRAM: return createIObjectModelDiagram();
			case UMLRhapsodyPackage.IOBJECT_NODE: return createIObjectNode();
			case UMLRhapsodyPackage.IOPERATION: return createIOperation();
			case UMLRhapsodyPackage.IPACKAGE: return createIPackage();
			case UMLRhapsodyPackage.IPANEL_DIAGRAM: return createIPanelDiagram();
			case UMLRhapsodyPackage.IPART: return createIPart();
			case UMLRhapsodyPackage.IPIN: return createIPin();
			case UMLRhapsodyPackage.IPORT: return createIPort();
			case UMLRhapsodyPackage.IPRIMITIVE_OPERATION: return createIPrimitiveOperation();
			case UMLRhapsodyPackage.IPROFILE: return createIProfile();
			case UMLRhapsodyPackage.IPROJECT: return createIProject();
			case UMLRhapsodyPackage.IPROPERTY: return createIProperty();
			case UMLRhapsodyPackage.IPROPERTY_CONTAINER: return createIPropertyContainer();
			case UMLRhapsodyPackage.IPROPERTY_METACLASS: return createIPropertyMetaclass();
			case UMLRhapsodyPackage.IPROPERTY_SUBJECT: return createIPropertySubject();
			case UMLRhapsodyPackage.IRECEPTION: return createIReception();
			case UMLRhapsodyPackage.IREFERENCE_ACTIVITY: return createIReferenceActivity();
			case UMLRhapsodyPackage.IRELATION: return createIRelation();
			case UMLRhapsodyPackage.IREQUIREMENT: return createIRequirement();
			case UMLRhapsodyPackage.ISEND_ACTION: return createISendAction();
			case UMLRhapsodyPackage.ISEQUENCE_DIAGRAM: return createISequenceDiagram();
			case UMLRhapsodyPackage.ISLOT: return createISlot();
			case UMLRhapsodyPackage.ISTATE: return createIState();
			case UMLRhapsodyPackage.ISTATE_CHART: return createIStateChart();
			case UMLRhapsodyPackage.ISTATE_CHART_DIAGRAM: return createIStateChartDiagram();
			case UMLRhapsodyPackage.ISTATE_VERTEX: return createIStateVertex();
			case UMLRhapsodyPackage.ISTEREOTYPE: return createIStereotype();
			case UMLRhapsodyPackage.ISTRUCTURE_DIAGRAM: return createIStructureDiagram();
			case UMLRhapsodyPackage.ISUBSYSTEM: return createISubsystem();
			case UMLRhapsodyPackage.ISWIMLANE: return createISwimlane();
			case UMLRhapsodyPackage.ISYS_ML_PORT: return createISysMLPort();
			case UMLRhapsodyPackage.ITABLE_INSTANCE: return createITableInstance();
			case UMLRhapsodyPackage.ITABLE_LAYOUT: return createITableLayout();
			case UMLRhapsodyPackage.ITABLE_VIEW: return createITableView();
			case UMLRhapsodyPackage.ITAG: return createITag();
			case UMLRhapsodyPackage.ITEMPLATE_INST: return createITemplateInst();
			case UMLRhapsodyPackage.ITEMPLATE_INST_PARAM: return createITemplateInstParam();
			case UMLRhapsodyPackage.ITEMPLATE_INSTANTIATION: return createITemplateInstantiation();
			case UMLRhapsodyPackage.ITEMPLATE_INSTANTIATION_PARAMETER: return createITemplateInstantiationParameter();
			case UMLRhapsodyPackage.ITEMPLATE_PARAMETER: return createITemplateParameter();
			case UMLRhapsodyPackage.ITIME_EVENT: return createITimeEvent();
			case UMLRhapsodyPackage.ITIMEOUT: return createITimeout();
			case UMLRhapsodyPackage.ITRANSITION: return createITransition();
			case UMLRhapsodyPackage.ITRIGGER: return createITrigger();
			case UMLRhapsodyPackage.ITRIGGERED: return createITriggered();
			case UMLRhapsodyPackage.ITYPE: return createIType();
			case UMLRhapsodyPackage.IUC_DIAGRAM: return createIUCDiagram();
			case UMLRhapsodyPackage.IUNIT: return createIUnit();
			case UMLRhapsodyPackage.IUSE_CASE: return createIUseCase();
			case UMLRhapsodyPackage.IUSE_CASE_DIAGRAM: return createIUseCaseDiagram();
			case UMLRhapsodyPackage.IUSE_CASE_STEREO_TYPE: return createIUseCaseStereoType();
			case UMLRhapsodyPackage.IVALUE_SPECIFICATION: return createIValueSpecification();
			case UMLRhapsodyPackage.IVARIABLE: return createIVariable();
			case UMLRhapsodyPackage.TABLE_DATA_DEFINITION: return createTableDataDefinition();
			case UMLRhapsodyPackage.UNKNOWN_TYPE: return createUnknownType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CCollaborationChart createCCollaborationChart() {
		CCollaborationChartImpl cCollaborationChart = new CCollaborationChartImpl();
		return cCollaborationChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIActionState createCGIActionState() {
		CGIActionStateImpl cgiActionState = new CGIActionStateImpl();
		return cgiActionState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIActiveX createCGIActiveX() {
		CGIActiveXImpl cgiActiveX = new CGIActiveXImpl();
		return cgiActiveX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIAnchor createCGIAnchor() {
		CGIAnchorImpl cgiAnchor = new CGIAnchorImpl();
		return cgiAnchor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIAnnotation createCGIAnnotation() {
		CGIAnnotationImpl cgiAnnotation = new CGIAnnotationImpl();
		return cgiAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIArrow createCGIArrow() {
		CGIArrowImpl cgiArrow = new CGIArrowImpl();
		return cgiArrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIAssociationEnd createCGIAssociationEnd() {
		CGIAssociationEndImpl cgiAssociationEnd = new CGIAssociationEndImpl();
		return cgiAssociationEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIAssociationRole createCGIAssociationRole() {
		CGIAssociationRoleImpl cgiAssociationRole = new CGIAssociationRoleImpl();
		return cgiAssociationRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIBasicClass createCGIBasicClass() {
		CGIBasicClassImpl cgiBasicClass = new CGIBasicClassImpl();
		return cgiBasicClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIBlockState createCGIBlockState() {
		CGIBlockStateImpl cgiBlockState = new CGIBlockStateImpl();
		return cgiBlockState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIBox createCGIBox() {
		CGIBoxImpl cgiBox = new CGIBoxImpl();
		return cgiBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIButtonArray createCGIButtonArray() {
		CGIButtonArrayImpl cgiButtonArray = new CGIButtonArrayImpl();
		return cgiButtonArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIClass createCGIClass() {
		CGIClassImpl cgiClass = new CGIClassImpl();
		return cgiClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIClassChart createCGIClassChart() {
		CGIClassChartImpl cgiClassChart = new CGIClassChartImpl();
		return cgiClassChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIClassifierRole createCGIClassifierRole() {
		CGIClassifierRoleImpl cgiClassifierRole = new CGIClassifierRoleImpl();
		return cgiClassifierRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGICompartment createCGICompartment() {
		CGICompartmentImpl cgiCompartment = new CGICompartmentImpl();
		return cgiCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIComponent createCGIComponent() {
		CGIComponentImpl cgiComponent = new CGIComponentImpl();
		return cgiComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGICompositeClass createCGICompositeClass() {
		CGICompositeClassImpl cgiCompositeClass = new CGICompositeClassImpl();
		return cgiCompositeClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIConnector createCGIConnector() {
		CGIConnectorImpl cgiConnector = new CGIConnectorImpl();
		return cgiConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIContainArrow createCGIContainArrow() {
		CGIContainArrowImpl cgiContainArrow = new CGIContainArrowImpl();
		return cgiContainArrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIDiagramFrame createCGIDiagramFrame() {
		CGIDiagramFrameImpl cgiDiagramFrame = new CGIDiagramFrameImpl();
		return cgiDiagramFrame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIFreeShape createCGIFreeShape() {
		CGIFreeShapeImpl cgiFreeShape = new CGIFreeShapeImpl();
		return cgiFreeShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIFreeText createCGIFreeText() {
		CGIFreeTextImpl cgiFreeText = new CGIFreeTextImpl();
		return cgiFreeText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIGenericElement createCGIGenericElement() {
		CGIGenericElementImpl cgiGenericElement = new CGIGenericElementImpl();
		return cgiGenericElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIImage createCGIImage() {
		CGIImageImpl cgiImage = new CGIImageImpl();
		return cgiImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIImageData createCGIImageData() {
		CGIImageDataImpl cgiImageData = new CGIImageDataImpl();
		return cgiImageData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIInformationFlow createCGIInformationFlow() {
		CGIInformationFlowImpl cgiInformationFlow = new CGIInformationFlowImpl();
		return cgiInformationFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIInheritance createCGIInheritance() {
		CGIInheritanceImpl cgiInheritance = new CGIInheritanceImpl();
		return cgiInheritance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIMFCCtrl createCGIMFCCtrl() {
		CGIMFCCtrlImpl cgimfcCtrl = new CGIMFCCtrlImpl();
		return cgimfcCtrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIMessageLabel createCGIMessageLabel() {
		CGIMessageLabelImpl cgiMessageLabel = new CGIMessageLabelImpl();
		return cgiMessageLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIMscChart createCGIMscChart() {
		CGIMscChartImpl cgiMscChart = new CGIMscChartImpl();
		return cgiMscChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIMscColumnCR createCGIMscColumnCR() {
		CGIMscColumnCRImpl cgiMscColumnCR = new CGIMscColumnCRImpl();
		return cgiMscColumnCR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIMscConditionMark createCGIMscConditionMark() {
		CGIMscConditionMarkImpl cgiMscConditionMark = new CGIMscConditionMarkImpl();
		return cgiMscConditionMark;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIMscExecutionOccurrence createCGIMscExecutionOccurrence() {
		CGIMscExecutionOccurrenceImpl cgiMscExecutionOccurrence = new CGIMscExecutionOccurrenceImpl();
		return cgiMscExecutionOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIMscInteractionOccurrence createCGIMscInteractionOccurrence() {
		CGIMscInteractionOccurrenceImpl cgiMscInteractionOccurrence = new CGIMscInteractionOccurrenceImpl();
		return cgiMscInteractionOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIMscInteractionOperand createCGIMscInteractionOperand() {
		CGIMscInteractionOperandImpl cgiMscInteractionOperand = new CGIMscInteractionOperandImpl();
		return cgiMscInteractionOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIMscInteractionOperator createCGIMscInteractionOperator() {
		CGIMscInteractionOperatorImpl cgiMscInteractionOperator = new CGIMscInteractionOperatorImpl();
		return cgiMscInteractionOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIMscMessage createCGIMscMessage() {
		CGIMscMessageImpl cgiMscMessage = new CGIMscMessageImpl();
		return cgiMscMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIObjectInstance createCGIObjectInstance() {
		CGIObjectInstanceImpl cgiObjectInstance = new CGIObjectInstanceImpl();
		return cgiObjectInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIObjectLink createCGIObjectLink() {
		CGIObjectLinkImpl cgiObjectLink = new CGIObjectLinkImpl();
		return cgiObjectLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIPackage createCGIPackage() {
		CGIPackageImpl cgiPackage = new CGIPackageImpl();
		return cgiPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIPartition createCGIPartition() {
		CGIPartitionImpl cgiPartition = new CGIPartitionImpl();
		return cgiPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIPortConnector createCGIPortConnector() {
		CGIPortConnectorImpl cgiPortConnector = new CGIPortConnectorImpl();
		return cgiPortConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIState createCGIState() {
		CGIStateImpl cgiState = new CGIStateImpl();
		return cgiState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIStateChart createCGIStateChart() {
		CGIStateChartImpl cgiStateChart = new CGIStateChartImpl();
		return cgiStateChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGISwimlaneFrame createCGISwimlaneFrame() {
		CGISwimlaneFrameImpl cgiSwimlaneFrame = new CGISwimlaneFrameImpl();
		return cgiSwimlaneFrame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGIText createCGIText() {
		CGITextImpl cgiText = new CGITextImpl();
		return cgiText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGITextBox createCGITextBox() {
		CGITextBoxImpl cgiTextBox = new CGITextBoxImpl();
		return cgiTextBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGITrans createCGITrans() {
		CGITransImpl cgiTrans = new CGITransImpl();
		return cgiTrans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollEvent createCollEvent() {
		CollEventImpl collEvent = new CollEventImpl();
		return collEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAcceptEventAction createIAcceptEventAction() {
		IAcceptEventActionImpl iAcceptEventAction = new IAcceptEventActionImpl();
		return iAcceptEventAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAcceptTimeEvent createIAcceptTimeEvent() {
		IAcceptTimeEventImpl iAcceptTimeEvent = new IAcceptTimeEventImpl();
		return iAcceptTimeEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAction createIAction() {
		IActionImpl iAction = new IActionImpl();
		return iAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IActivityDiagram createIActivityDiagram() {
		IActivityDiagramImpl iActivityDiagram = new IActivityDiagramImpl();
		return iActivityDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IActivityGraph createIActivityGraph() {
		IActivityGraphImpl iActivityGraph = new IActivityGraphImpl();
		return iActivityGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IActor createIActor() {
		IActorImpl iActor = new IActorImpl();
		return iActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAnchor createIAnchor() {
		IAnchorImpl iAnchor = new IAnchorImpl();
		return iAnchor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAnnotation createIAnnotation() {
		IAnnotationImpl iAnnotation = new IAnnotationImpl();
		return iAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IArgument createIArgument() {
		IArgumentImpl iArgument = new IArgumentImpl();
		return iArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAssociationClass createIAssociationClass() {
		IAssociationClassImpl iAssociationClass = new IAssociationClassImpl();
		return iAssociationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAssociationEnd createIAssociationEnd() {
		IAssociationEndImpl iAssociationEnd = new IAssociationEndImpl();
		return iAssociationEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAssociationEndHandle createIAssociationEndHandle() {
		IAssociationEndHandleImpl iAssociationEndHandle = new IAssociationEndHandleImpl();
		return iAssociationEndHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAssociationRole createIAssociationRole() {
		IAssociationRoleImpl iAssociationRole = new IAssociationRoleImpl();
		return iAssociationRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IAttribute createIAttribute() {
		IAttributeImpl iAttribute = new IAttributeImpl();
		return iAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IBlock createIBlock() {
		IBlockImpl iBlock = new IBlockImpl();
		return iBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IBody createIBody() {
		IBodyImpl iBody = new IBodyImpl();
		return iBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IBranch createIBranch() {
		IBranchImpl iBranch = new IBranchImpl();
		return iBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICallAction createICallAction() {
		ICallActionImpl iCallAction = new ICallActionImpl();
		return iCallAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICallOperation createICallOperation() {
		ICallOperationImpl iCallOperation = new ICallOperationImpl();
		return iCallOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClass createIClass() {
		IClassImpl iClass = new IClassImpl();
		return iClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassHandle createIClassHandle() {
		IClassHandleImpl iClassHandle = new IClassHandleImpl();
		return iClassHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassInstance createIClassInstance() {
		IClassInstanceImpl iClassInstance = new IClassInstanceImpl();
		return iClassInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifier createIClassifier() {
		IClassifierImpl iClassifier = new IClassifierImpl();
		return iClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IClassifierRole createIClassifierRole() {
		IClassifierRoleImpl iClassifierRole = new IClassifierRoleImpl();
		return iClassifierRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICodeGenConfigInfo createICodeGenConfigInfo() {
		ICodeGenConfigInfoImpl iCodeGenConfigInfo = new ICodeGenConfigInfoImpl();
		return iCodeGenConfigInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICodeGenConfigInfoHandle createICodeGenConfigInfoHandle() {
		ICodeGenConfigInfoHandleImpl iCodeGenConfigInfoHandle = new ICodeGenConfigInfoHandleImpl();
		return iCodeGenConfigInfoHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICollaboration createICollaboration() {
		ICollaborationImpl iCollaboration = new ICollaborationImpl();
		return iCollaboration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICollaborationDiagram createICollaborationDiagram() {
		ICollaborationDiagramImpl iCollaborationDiagram = new ICollaborationDiagramImpl();
		return iCollaborationDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IColor createIColor() {
		IColorImpl iColor = new IColorImpl();
		return iColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICombinedFragment createICombinedFragment() {
		ICombinedFragmentImpl iCombinedFragment = new ICombinedFragmentImpl();
		return iCombinedFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IComment createIComment() {
		ICommentImpl iComment = new ICommentImpl();
		return iComment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IComponent createIComponent() {
		IComponentImpl iComponent = new IComponentImpl();
		return iComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IComponentDiagram createIComponentDiagram() {
		IComponentDiagramImpl iComponentDiagram = new IComponentDiagramImpl();
		return iComponentDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IComponentInstance createIComponentInstance() {
		IComponentInstanceImpl iComponentInstance = new IComponentInstanceImpl();
		return iComponentInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IConfiguration createIConfiguration() {
		IConfigurationImpl iConfiguration = new IConfigurationImpl();
		return iConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IConnector createIConnector() {
		IConnectorImpl iConnector = new IConnectorImpl();
		return iConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IConstraint createIConstraint() {
		IConstraintImpl iConstraint = new IConstraintImpl();
		return iConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IConstructor createIConstructor() {
		IConstructorImpl iConstructor = new IConstructorImpl();
		return iConstructor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IContextSpecification createIContextSpecification() {
		IContextSpecificationImpl iContextSpecification = new IContextSpecificationImpl();
		return iContextSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IControlledFile createIControlledFile() {
		IControlledFileImpl iControlledFile = new IControlledFileImpl();
		return iControlledFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDefaultDrvdTrans createIDefaultDrvdTrans() {
		IDefaultDrvdTransImpl iDefaultDrvdTrans = new IDefaultDrvdTransImpl();
		return iDefaultDrvdTrans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDependency createIDependency() {
		IDependencyImpl iDependency = new IDependencyImpl();
		return iDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDeploymentDiagram createIDeploymentDiagram() {
		IDeploymentDiagramImpl iDeploymentDiagram = new IDeploymentDiagramImpl();
		return iDeploymentDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDescription createIDescription() {
		IDescriptionImpl iDescription = new IDescriptionImpl();
		return iDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDestructor createIDestructor() {
		IDestructorImpl iDestructor = new IDestructorImpl();
		return iDestructor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDiagram createIDiagram() {
		IDiagramImpl iDiagram = new IDiagramImpl();
		return iDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IEmbededFile createIEmbededFile() {
		IEmbededFileImpl iEmbededFile = new IEmbededFileImpl();
		return iEmbededFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IEnumerationLiteral createIEnumerationLiteral() {
		IEnumerationLiteralImpl iEnumerationLiteral = new IEnumerationLiteralImpl();
		return iEnumerationLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IEvent createIEvent() {
		IEventImpl iEvent = new IEventImpl();
		return iEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IEventHandle createIEventHandle() {
		IEventHandleImpl iEventHandle = new IEventHandleImpl();
		return iEventHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IEventReception createIEventReception() {
		IEventReceptionImpl iEventReception = new IEventReceptionImpl();
		return iEventReception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IExecutionOccurrence createIExecutionOccurrence() {
		IExecutionOccurrenceImpl iExecutionOccurrence = new IExecutionOccurrenceImpl();
		return iExecutionOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IExternalHyperlink createIExternalHyperlink() {
		IExternalHyperlinkImpl iExternalHyperlink = new IExternalHyperlinkImpl();
		return iExternalHyperlink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFile createIFile() {
		IFileImpl iFile = new IFileImpl();
		return iFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFileFragment createIFileFragment() {
		IFileFragmentImpl iFileFragment = new IFileFragmentImpl();
		return iFileFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFlow createIFlow() {
		IFlowImpl iFlow = new IFlowImpl();
		return iFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFlowItem createIFlowItem() {
		IFlowItemImpl iFlowItem = new IFlowItemImpl();
		return iFlowItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFlowchart createIFlowchart() {
		IFlowchartImpl iFlowchart = new IFlowchartImpl();
		return iFlowchart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFolder createIFolder() {
		IFolderImpl iFolder = new IFolderImpl();
		return iFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFork createIFork() {
		IForkImpl iFork = new IForkImpl();
		return iFork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IGeneralization createIGeneralization() {
		IGeneralizationImpl iGeneralization = new IGeneralizationImpl();
		return iGeneralization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IGuard createIGuard() {
		IGuardImpl iGuard = new IGuardImpl();
		return iGuard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IHandleWithData createIHandleWithData() {
		IHandleWithDataImpl iHandleWithData = new IHandleWithDataImpl();
		return iHandleWithData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IHistoryConnector createIHistoryConnector() {
		IHistoryConnectorImpl iHistoryConnector = new IHistoryConnectorImpl();
		return iHistoryConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IHyperLink createIHyperLink() {
		IHyperLinkImpl iHyperLink = new IHyperLinkImpl();
		return iHyperLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInformationFlow createIInformationFlow() {
		IInformationFlowImpl iInformationFlow = new IInformationFlowImpl();
		return iInformationFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInformationItem createIInformationItem() {
		IInformationItemImpl iInformationItem = new IInformationItemImpl();
		return iInformationItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInstance createIInstance() {
		IInstanceImpl iInstance = new IInstanceImpl();
		return iInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInstanceSlot createIInstanceSlot() {
		IInstanceSlotImpl iInstanceSlot = new IInstanceSlotImpl();
		return iInstanceSlot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInstanceSpecification createIInstanceSpecification() {
		IInstanceSpecificationImpl iInstanceSpecification = new IInstanceSpecificationImpl();
		return iInstanceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInstanceValue createIInstanceValue() {
		IInstanceValueImpl iInstanceValue = new IInstanceValueImpl();
		return iInstanceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInteractionOccurrence createIInteractionOccurrence() {
		IInteractionOccurrenceImpl iInteractionOccurrence = new IInteractionOccurrenceImpl();
		return iInteractionOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInteractionOperand createIInteractionOperand() {
		IInteractionOperandImpl iInteractionOperand = new IInteractionOperandImpl();
		return iInteractionOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInteractionOperator createIInteractionOperator() {
		IInteractionOperatorImpl iInteractionOperator = new IInteractionOperatorImpl();
		return iInteractionOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInterfaceItem createIInterfaceItem() {
		IInterfaceItemImpl iInterfaceItem = new IInterfaceItemImpl();
		return iInterfaceItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInterfaceItemTrigger createIInterfaceItemTrigger() {
		IInterfaceItemTriggerImpl iInterfaceItemTrigger = new IInterfaceItemTriggerImpl();
		return iInterfaceItemTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInternalHyperlink createIInternalHyperlink() {
		IInternalHyperlinkImpl iInternalHyperlink = new IInternalHyperlinkImpl();
		return iInternalHyperlink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILabel createILabel() {
		ILabelImpl iLabel = new ILabelImpl();
		return iLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILink createILink() {
		ILinkImpl iLink = new ILinkImpl();
		return iLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILinkInstance createILinkInstance() {
		ILinkInstanceImpl iLinkInstance = new ILinkInstanceImpl();
		return iLinkInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILiteralSpecification createILiteralSpecification() {
		ILiteralSpecificationImpl iLiteralSpecification = new ILiteralSpecificationImpl();
		return iLiteralSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMHyperLink createIMHyperLink() {
		IMHyperLinkImpl imHyperLink = new IMHyperLinkImpl();
		return imHyperLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMSC createIMSC() {
		IMSCImpl imsc = new IMSCImpl();
		return imsc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMatrixInstance createIMatrixInstance() {
		IMatrixInstanceImpl iMatrixInstance = new IMatrixInstanceImpl();
		return iMatrixInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMatrixLayout createIMatrixLayout() {
		IMatrixLayoutImpl iMatrixLayout = new IMatrixLayoutImpl();
		return iMatrixLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMatrixView createIMatrixView() {
		IMatrixViewImpl iMatrixView = new IMatrixViewImpl();
		return iMatrixView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMessage createIMessage() {
		IMessageImpl iMessage = new IMessageImpl();
		return iMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMessagePoint createIMessagePoint() {
		IMessagePointImpl iMessagePoint = new IMessagePointImpl();
		return iMessagePoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMetaLinkHandle createIMetaLinkHandle() {
		IMetaLinkHandleImpl iMetaLinkHandle = new IMetaLinkHandleImpl();
		return iMetaLinkHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IModelElement createIModelElement() {
		IModelElementImpl iModelElement = new IModelElementImpl();
		return iModelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IModule createIModule() {
		IModuleImpl iModule = new IModuleImpl();
		return iModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMultiplicityItem createIMultiplicityItem() {
		IMultiplicityItemImpl iMultiplicityItem = new IMultiplicityItemImpl();
		return iMultiplicityItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public INode createINode() {
		INodeImpl iNode = new INodeImpl();
		return iNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IObjectLink createIObjectLink() {
		IObjectLinkImpl iObjectLink = new IObjectLinkImpl();
		return iObjectLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IObjectLinkHandle createIObjectLinkHandle() {
		IObjectLinkHandleImpl iObjectLinkHandle = new IObjectLinkHandleImpl();
		return iObjectLinkHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IObjectModelDiagram createIObjectModelDiagram() {
		IObjectModelDiagramImpl iObjectModelDiagram = new IObjectModelDiagramImpl();
		return iObjectModelDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IObjectNode createIObjectNode() {
		IObjectNodeImpl iObjectNode = new IObjectNodeImpl();
		return iObjectNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IOperation createIOperation() {
		IOperationImpl iOperation = new IOperationImpl();
		return iOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPackage createIPackage() {
		IPackageImpl iPackage = new IPackageImpl();
		return iPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPanelDiagram createIPanelDiagram() {
		IPanelDiagramImpl iPanelDiagram = new IPanelDiagramImpl();
		return iPanelDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPart createIPart() {
		IPartImpl iPart = new IPartImpl();
		return iPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPin createIPin() {
		IPinImpl iPin = new IPinImpl();
		return iPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPort createIPort() {
		IPortImpl iPort = new IPortImpl();
		return iPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPrimitiveOperation createIPrimitiveOperation() {
		IPrimitiveOperationImpl iPrimitiveOperation = new IPrimitiveOperationImpl();
		return iPrimitiveOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IProfile createIProfile() {
		IProfileImpl iProfile = new IProfileImpl();
		return iProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IProject createIProject() {
		IProjectImpl iProject = new IProjectImpl();
		return iProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IProperty createIProperty() {
		IPropertyImpl iProperty = new IPropertyImpl();
		return iProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPropertyContainer createIPropertyContainer() {
		IPropertyContainerImpl iPropertyContainer = new IPropertyContainerImpl();
		return iPropertyContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPropertyMetaclass createIPropertyMetaclass() {
		IPropertyMetaclassImpl iPropertyMetaclass = new IPropertyMetaclassImpl();
		return iPropertyMetaclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPropertySubject createIPropertySubject() {
		IPropertySubjectImpl iPropertySubject = new IPropertySubjectImpl();
		return iPropertySubject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IReception createIReception() {
		IReceptionImpl iReception = new IReceptionImpl();
		return iReception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IReferenceActivity createIReferenceActivity() {
		IReferenceActivityImpl iReferenceActivity = new IReferenceActivityImpl();
		return iReferenceActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IRelation createIRelation() {
		IRelationImpl iRelation = new IRelationImpl();
		return iRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IRequirement createIRequirement() {
		IRequirementImpl iRequirement = new IRequirementImpl();
		return iRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISendAction createISendAction() {
		ISendActionImpl iSendAction = new ISendActionImpl();
		return iSendAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISequenceDiagram createISequenceDiagram() {
		ISequenceDiagramImpl iSequenceDiagram = new ISequenceDiagramImpl();
		return iSequenceDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISlot createISlot() {
		ISlotImpl iSlot = new ISlotImpl();
		return iSlot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IState createIState() {
		IStateImpl iState = new IStateImpl();
		return iState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStateChart createIStateChart() {
		IStateChartImpl iStateChart = new IStateChartImpl();
		return iStateChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStateChartDiagram createIStateChartDiagram() {
		IStateChartDiagramImpl iStateChartDiagram = new IStateChartDiagramImpl();
		return iStateChartDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStateVertex createIStateVertex() {
		IStateVertexImpl iStateVertex = new IStateVertexImpl();
		return iStateVertex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStereotype createIStereotype() {
		IStereotypeImpl iStereotype = new IStereotypeImpl();
		return iStereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStructureDiagram createIStructureDiagram() {
		IStructureDiagramImpl iStructureDiagram = new IStructureDiagramImpl();
		return iStructureDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISubsystem createISubsystem() {
		ISubsystemImpl iSubsystem = new ISubsystemImpl();
		return iSubsystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISwimlane createISwimlane() {
		ISwimlaneImpl iSwimlane = new ISwimlaneImpl();
		return iSwimlane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISysMLPort createISysMLPort() {
		ISysMLPortImpl iSysMLPort = new ISysMLPortImpl();
		return iSysMLPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITableInstance createITableInstance() {
		ITableInstanceImpl iTableInstance = new ITableInstanceImpl();
		return iTableInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITableLayout createITableLayout() {
		ITableLayoutImpl iTableLayout = new ITableLayoutImpl();
		return iTableLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITableView createITableView() {
		ITableViewImpl iTableView = new ITableViewImpl();
		return iTableView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITag createITag() {
		ITagImpl iTag = new ITagImpl();
		return iTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITemplateInst createITemplateInst() {
		ITemplateInstImpl iTemplateInst = new ITemplateInstImpl();
		return iTemplateInst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITemplateInstParam createITemplateInstParam() {
		ITemplateInstParamImpl iTemplateInstParam = new ITemplateInstParamImpl();
		return iTemplateInstParam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITemplateInstantiation createITemplateInstantiation() {
		ITemplateInstantiationImpl iTemplateInstantiation = new ITemplateInstantiationImpl();
		return iTemplateInstantiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITemplateInstantiationParameter createITemplateInstantiationParameter() {
		ITemplateInstantiationParameterImpl iTemplateInstantiationParameter = new ITemplateInstantiationParameterImpl();
		return iTemplateInstantiationParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITemplateParameter createITemplateParameter() {
		ITemplateParameterImpl iTemplateParameter = new ITemplateParameterImpl();
		return iTemplateParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITimeEvent createITimeEvent() {
		ITimeEventImpl iTimeEvent = new ITimeEventImpl();
		return iTimeEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITimeout createITimeout() {
		ITimeoutImpl iTimeout = new ITimeoutImpl();
		return iTimeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITransition createITransition() {
		ITransitionImpl iTransition = new ITransitionImpl();
		return iTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITrigger createITrigger() {
		ITriggerImpl iTrigger = new ITriggerImpl();
		return iTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ITriggered createITriggered() {
		ITriggeredImpl iTriggered = new ITriggeredImpl();
		return iTriggered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IType createIType() {
		ITypeImpl iType = new ITypeImpl();
		return iType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUCDiagram createIUCDiagram() {
		IUCDiagramImpl iucDiagram = new IUCDiagramImpl();
		return iucDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUnit createIUnit() {
		IUnitImpl iUnit = new IUnitImpl();
		return iUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUseCase createIUseCase() {
		IUseCaseImpl iUseCase = new IUseCaseImpl();
		return iUseCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUseCaseDiagram createIUseCaseDiagram() {
		IUseCaseDiagramImpl iUseCaseDiagram = new IUseCaseDiagramImpl();
		return iUseCaseDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IUseCaseStereoType createIUseCaseStereoType() {
		IUseCaseStereoTypeImpl iUseCaseStereoType = new IUseCaseStereoTypeImpl();
		return iUseCaseStereoType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IValueSpecification createIValueSpecification() {
		IValueSpecificationImpl iValueSpecification = new IValueSpecificationImpl();
		return iValueSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IVariable createIVariable() {
		IVariableImpl iVariable = new IVariableImpl();
		return iVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableDataDefinition createTableDataDefinition() {
		TableDataDefinitionImpl tableDataDefinition = new TableDataDefinitionImpl();
		return tableDataDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnknownType createUnknownType() {
		UnknownTypeImpl unknownType = new UnknownTypeImpl();
		return unknownType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLRhapsodyPackage getUMLRhapsodyPackage() {
		return (UMLRhapsodyPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UMLRhapsodyPackage getPackage() {
		return UMLRhapsodyPackage.eINSTANCE;
	}

} //UMLRhapsodyFactoryImpl
