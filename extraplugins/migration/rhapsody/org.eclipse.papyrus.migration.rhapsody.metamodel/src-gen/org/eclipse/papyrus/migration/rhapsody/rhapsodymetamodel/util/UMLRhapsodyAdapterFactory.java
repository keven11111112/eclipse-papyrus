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
package org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage
 * @generated
 */
public class UMLRhapsodyAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UMLRhapsodyPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLRhapsodyAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UMLRhapsodyPackage.eINSTANCE;
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
	protected UMLRhapsodySwitch<Adapter> modelSwitch =
		new UMLRhapsodySwitch<Adapter>() {
			@Override
			public Adapter caseAssociationsType(AssociationsType object) {
				return createAssociationsTypeAdapter();
			}
			@Override
			public Adapter caseCCollaborationChart(CCollaborationChart object) {
				return createCCollaborationChartAdapter();
			}
			@Override
			public Adapter caseCGIActionState(CGIActionState object) {
				return createCGIActionStateAdapter();
			}
			@Override
			public Adapter caseCGIActiveX(CGIActiveX object) {
				return createCGIActiveXAdapter();
			}
			@Override
			public Adapter caseCGIAnchor(CGIAnchor object) {
				return createCGIAnchorAdapter();
			}
			@Override
			public Adapter caseCGIAnnotation(CGIAnnotation object) {
				return createCGIAnnotationAdapter();
			}
			@Override
			public Adapter caseCGIArrow(CGIArrow object) {
				return createCGIArrowAdapter();
			}
			@Override
			public Adapter caseCGIAssociationEnd(CGIAssociationEnd object) {
				return createCGIAssociationEndAdapter();
			}
			@Override
			public Adapter caseCGIAssociationRole(CGIAssociationRole object) {
				return createCGIAssociationRoleAdapter();
			}
			@Override
			public Adapter caseCGIBasicClass(CGIBasicClass object) {
				return createCGIBasicClassAdapter();
			}
			@Override
			public Adapter caseCGIBlockState(CGIBlockState object) {
				return createCGIBlockStateAdapter();
			}
			@Override
			public Adapter caseCGIBox(CGIBox object) {
				return createCGIBoxAdapter();
			}
			@Override
			public Adapter caseCGIButtonArray(CGIButtonArray object) {
				return createCGIButtonArrayAdapter();
			}
			@Override
			public Adapter caseCGIClass(CGIClass object) {
				return createCGIClassAdapter();
			}
			@Override
			public Adapter caseCGIClassChart(CGIClassChart object) {
				return createCGIClassChartAdapter();
			}
			@Override
			public Adapter caseCGIClassifierRole(CGIClassifierRole object) {
				return createCGIClassifierRoleAdapter();
			}
			@Override
			public Adapter caseCGICompartment(CGICompartment object) {
				return createCGICompartmentAdapter();
			}
			@Override
			public Adapter caseCGIComponent(CGIComponent object) {
				return createCGIComponentAdapter();
			}
			@Override
			public Adapter caseCGICompositeClass(CGICompositeClass object) {
				return createCGICompositeClassAdapter();
			}
			@Override
			public Adapter caseCGIConnector(CGIConnector object) {
				return createCGIConnectorAdapter();
			}
			@Override
			public Adapter caseCGIContainArrow(CGIContainArrow object) {
				return createCGIContainArrowAdapter();
			}
			@Override
			public Adapter caseCGIDiagramFrame(CGIDiagramFrame object) {
				return createCGIDiagramFrameAdapter();
			}
			@Override
			public Adapter caseCGIFreeShape(CGIFreeShape object) {
				return createCGIFreeShapeAdapter();
			}
			@Override
			public Adapter caseCGIFreeText(CGIFreeText object) {
				return createCGIFreeTextAdapter();
			}
			@Override
			public Adapter caseCGIGenericElement(CGIGenericElement object) {
				return createCGIGenericElementAdapter();
			}
			@Override
			public Adapter caseCGIImage(CGIImage object) {
				return createCGIImageAdapter();
			}
			@Override
			public Adapter caseCGIImageData(CGIImageData object) {
				return createCGIImageDataAdapter();
			}
			@Override
			public Adapter caseCGIInformationFlow(CGIInformationFlow object) {
				return createCGIInformationFlowAdapter();
			}
			@Override
			public Adapter caseCGIInheritance(CGIInheritance object) {
				return createCGIInheritanceAdapter();
			}
			@Override
			public Adapter caseCGIMFCCtrl(CGIMFCCtrl object) {
				return createCGIMFCCtrlAdapter();
			}
			@Override
			public Adapter caseCGIMessageLabel(CGIMessageLabel object) {
				return createCGIMessageLabelAdapter();
			}
			@Override
			public Adapter caseCGIMscChart(CGIMscChart object) {
				return createCGIMscChartAdapter();
			}
			@Override
			public Adapter caseCGIMscColumnCR(CGIMscColumnCR object) {
				return createCGIMscColumnCRAdapter();
			}
			@Override
			public Adapter caseCGIMscConditionMark(CGIMscConditionMark object) {
				return createCGIMscConditionMarkAdapter();
			}
			@Override
			public Adapter caseCGIMscExecutionOccurrence(CGIMscExecutionOccurrence object) {
				return createCGIMscExecutionOccurrenceAdapter();
			}
			@Override
			public Adapter caseCGIMscInteractionOccurrence(CGIMscInteractionOccurrence object) {
				return createCGIMscInteractionOccurrenceAdapter();
			}
			@Override
			public Adapter caseCGIMscInteractionOperand(CGIMscInteractionOperand object) {
				return createCGIMscInteractionOperandAdapter();
			}
			@Override
			public Adapter caseCGIMscInteractionOperator(CGIMscInteractionOperator object) {
				return createCGIMscInteractionOperatorAdapter();
			}
			@Override
			public Adapter caseCGIMscMessage(CGIMscMessage object) {
				return createCGIMscMessageAdapter();
			}
			@Override
			public Adapter caseCGIObjectInstance(CGIObjectInstance object) {
				return createCGIObjectInstanceAdapter();
			}
			@Override
			public Adapter caseCGIObjectLink(CGIObjectLink object) {
				return createCGIObjectLinkAdapter();
			}
			@Override
			public Adapter caseCGIPackage(CGIPackage object) {
				return createCGIPackageAdapter();
			}
			@Override
			public Adapter caseCGIPartition(CGIPartition object) {
				return createCGIPartitionAdapter();
			}
			@Override
			public Adapter caseCGIPortConnector(CGIPortConnector object) {
				return createCGIPortConnectorAdapter();
			}
			@Override
			public Adapter caseCGIState(CGIState object) {
				return createCGIStateAdapter();
			}
			@Override
			public Adapter caseCGIStateChart(CGIStateChart object) {
				return createCGIStateChartAdapter();
			}
			@Override
			public Adapter caseCGISwimlaneFrame(CGISwimlaneFrame object) {
				return createCGISwimlaneFrameAdapter();
			}
			@Override
			public Adapter caseCGIText(CGIText object) {
				return createCGITextAdapter();
			}
			@Override
			public Adapter caseCGITextBox(CGITextBox object) {
				return createCGITextBoxAdapter();
			}
			@Override
			public Adapter caseCGITrans(CGITrans object) {
				return createCGITransAdapter();
			}
			@Override
			public Adapter caseCollEvent(CollEvent object) {
				return createCollEventAdapter();
			}
			@Override
			public Adapter caseCompartmentsType(CompartmentsType object) {
				return createCompartmentsTypeAdapter();
			}
			@Override
			public Adapter caseComponentsType(ComponentsType object) {
				return createComponentsTypeAdapter();
			}
			@Override
			public Adapter caseConveyedType(ConveyedType object) {
				return createConveyedTypeAdapter();
			}
			@Override
			public Adapter caseDeclarativesType(DeclarativesType object) {
				return createDeclarativesTypeAdapter();
			}
			@Override
			public Adapter caseDefaultSubsystemType(DefaultSubsystemType object) {
				return createDefaultSubsystemTypeAdapter();
			}
			@Override
			public Adapter caseDefaultTransType(DefaultTransType object) {
				return createDefaultTransTypeAdapter();
			}
			@Override
			public Adapter caseDependsOnType(DependsOnType object) {
				return createDependsOnTypeAdapter();
			}
			@Override
			public Adapter caseDescriptionType(DescriptionType object) {
				return createDescriptionTypeAdapter();
			}
			@Override
			public Adapter caseElementsType(ElementsType object) {
				return createElementsTypeAdapter();
			}
			@Override
			public Adapter caseEmbededFilesType(EmbededFilesType object) {
				return createEmbededFilesTypeAdapter();
			}
			@Override
			public Adapter caseEnd1_Type(End1_Type object) {
				return createEnd1_TypeAdapter();
			}
			@Override
			public Adapter caseEnd2_Type(End2_Type object) {
				return createEnd2_TypeAdapter();
			}
			@Override
			public Adapter caseFilesType(FilesType object) {
				return createFilesTypeAdapter();
			}
			@Override
			public Adapter caseFromLinkType(FromLinkType object) {
				return createFromLinkTypeAdapter();
			}
			@Override
			public Adapter caseGraphElementsType(GraphElementsType object) {
				return createGraphElementsTypeAdapter();
			}
			@Override
			public Adapter caseGraphicChartType(GraphicChartType object) {
				return createGraphicChartTypeAdapter();
			}
			@Override
			public Adapter caseHyperLinksType(HyperLinksType object) {
				return createHyperLinksTypeAdapter();
			}
			@Override
			public Adapter caseIAcceptEventAction(IAcceptEventAction object) {
				return createIAcceptEventActionAdapter();
			}
			@Override
			public Adapter caseIAcceptTimeEvent(IAcceptTimeEvent object) {
				return createIAcceptTimeEventAdapter();
			}
			@Override
			public Adapter caseIAction(IAction object) {
				return createIActionAdapter();
			}
			@Override
			public Adapter caseIActivityDiagram(IActivityDiagram object) {
				return createIActivityDiagramAdapter();
			}
			@Override
			public Adapter caseIActivityGraph(IActivityGraph object) {
				return createIActivityGraphAdapter();
			}
			@Override
			public Adapter caseIActor(IActor object) {
				return createIActorAdapter();
			}
			@Override
			public Adapter caseIAnchor(IAnchor object) {
				return createIAnchorAdapter();
			}
			@Override
			public Adapter caseIAnnotation(IAnnotation object) {
				return createIAnnotationAdapter();
			}
			@Override
			public Adapter caseIArgument(IArgument object) {
				return createIArgumentAdapter();
			}
			@Override
			public Adapter caseIAssociationClass(IAssociationClass object) {
				return createIAssociationClassAdapter();
			}
			@Override
			public Adapter caseIAssociationEnd(IAssociationEnd object) {
				return createIAssociationEndAdapter();
			}
			@Override
			public Adapter caseIAssociationEndHandle(IAssociationEndHandle object) {
				return createIAssociationEndHandleAdapter();
			}
			@Override
			public Adapter caseIAssociationRole(IAssociationRole object) {
				return createIAssociationRoleAdapter();
			}
			@Override
			public Adapter caseIAttribute(IAttribute object) {
				return createIAttributeAdapter();
			}
			@Override
			public Adapter caseIBlock(IBlock object) {
				return createIBlockAdapter();
			}
			@Override
			public Adapter caseIBody(IBody object) {
				return createIBodyAdapter();
			}
			@Override
			public Adapter caseIBranch(IBranch object) {
				return createIBranchAdapter();
			}
			@Override
			public Adapter caseICallAction(ICallAction object) {
				return createICallActionAdapter();
			}
			@Override
			public Adapter caseICallOperation(ICallOperation object) {
				return createICallOperationAdapter();
			}
			@Override
			public Adapter caseIClass(IClass object) {
				return createIClassAdapter();
			}
			@Override
			public Adapter caseIClassHandle(IClassHandle object) {
				return createIClassHandleAdapter();
			}
			@Override
			public Adapter caseIClassInstance(IClassInstance object) {
				return createIClassInstanceAdapter();
			}
			@Override
			public Adapter caseIClassifier(IClassifier object) {
				return createIClassifierAdapter();
			}
			@Override
			public Adapter caseIClassifierRole(IClassifierRole object) {
				return createIClassifierRoleAdapter();
			}
			@Override
			public Adapter caseICodeGenConfigInfo(ICodeGenConfigInfo object) {
				return createICodeGenConfigInfoAdapter();
			}
			@Override
			public Adapter caseICodeGenConfigInfoHandle(ICodeGenConfigInfoHandle object) {
				return createICodeGenConfigInfoHandleAdapter();
			}
			@Override
			public Adapter caseICollaboration(ICollaboration object) {
				return createICollaborationAdapter();
			}
			@Override
			public Adapter caseICollaborationDiagram(ICollaborationDiagram object) {
				return createICollaborationDiagramAdapter();
			}
			@Override
			public Adapter caseIColor(IColor object) {
				return createIColorAdapter();
			}
			@Override
			public Adapter caseICombinedFragment(ICombinedFragment object) {
				return createICombinedFragmentAdapter();
			}
			@Override
			public Adapter caseIComment(IComment object) {
				return createICommentAdapter();
			}
			@Override
			public Adapter caseIComponent(IComponent object) {
				return createIComponentAdapter();
			}
			@Override
			public Adapter caseIComponentDiagram(IComponentDiagram object) {
				return createIComponentDiagramAdapter();
			}
			@Override
			public Adapter caseIComponentInstance(IComponentInstance object) {
				return createIComponentInstanceAdapter();
			}
			@Override
			public Adapter caseIConfiguration(IConfiguration object) {
				return createIConfigurationAdapter();
			}
			@Override
			public Adapter caseIConnector(IConnector object) {
				return createIConnectorAdapter();
			}
			@Override
			public Adapter caseIConstraint(IConstraint object) {
				return createIConstraintAdapter();
			}
			@Override
			public Adapter caseIConstructor(IConstructor object) {
				return createIConstructorAdapter();
			}
			@Override
			public Adapter caseIContextSpecification(IContextSpecification object) {
				return createIContextSpecificationAdapter();
			}
			@Override
			public Adapter caseIControlledFile(IControlledFile object) {
				return createIControlledFileAdapter();
			}
			@Override
			public Adapter caseIDefaultDrvdTrans(IDefaultDrvdTrans object) {
				return createIDefaultDrvdTransAdapter();
			}
			@Override
			public Adapter caseIDependency(IDependency object) {
				return createIDependencyAdapter();
			}
			@Override
			public Adapter caseIDeploymentDiagram(IDeploymentDiagram object) {
				return createIDeploymentDiagramAdapter();
			}
			@Override
			public Adapter caseIDescription(IDescription object) {
				return createIDescriptionAdapter();
			}
			@Override
			public Adapter caseIDestructor(IDestructor object) {
				return createIDestructorAdapter();
			}
			@Override
			public Adapter caseIDiagram(IDiagram object) {
				return createIDiagramAdapter();
			}
			@Override
			public Adapter caseIEmbededFile(IEmbededFile object) {
				return createIEmbededFileAdapter();
			}
			@Override
			public Adapter caseIEnumerationLiteral(IEnumerationLiteral object) {
				return createIEnumerationLiteralAdapter();
			}
			@Override
			public Adapter caseIEvent(IEvent object) {
				return createIEventAdapter();
			}
			@Override
			public Adapter caseIEventHandle(IEventHandle object) {
				return createIEventHandleAdapter();
			}
			@Override
			public Adapter caseIEventReception(IEventReception object) {
				return createIEventReceptionAdapter();
			}
			@Override
			public Adapter caseIExecutionOccurrence(IExecutionOccurrence object) {
				return createIExecutionOccurrenceAdapter();
			}
			@Override
			public Adapter caseIExternalHyperlink(IExternalHyperlink object) {
				return createIExternalHyperlinkAdapter();
			}
			@Override
			public Adapter caseIFile(IFile object) {
				return createIFileAdapter();
			}
			@Override
			public Adapter caseIFileFragment(IFileFragment object) {
				return createIFileFragmentAdapter();
			}
			@Override
			public Adapter caseIFlow(IFlow object) {
				return createIFlowAdapter();
			}
			@Override
			public Adapter caseIFlowItem(IFlowItem object) {
				return createIFlowItemAdapter();
			}
			@Override
			public Adapter caseIFlowchart(IFlowchart object) {
				return createIFlowchartAdapter();
			}
			@Override
			public Adapter caseIFolder(IFolder object) {
				return createIFolderAdapter();
			}
			@Override
			public Adapter caseIFork(IFork object) {
				return createIForkAdapter();
			}
			@Override
			public Adapter caseIGeneralization(IGeneralization object) {
				return createIGeneralizationAdapter();
			}
			@Override
			public Adapter caseIGuard(IGuard object) {
				return createIGuardAdapter();
			}
			@Override
			public Adapter caseIHandleWithData(IHandleWithData object) {
				return createIHandleWithDataAdapter();
			}
			@Override
			public Adapter caseIHistoryConnector(IHistoryConnector object) {
				return createIHistoryConnectorAdapter();
			}
			@Override
			public Adapter caseIHyperLink(IHyperLink object) {
				return createIHyperLinkAdapter();
			}
			@Override
			public Adapter caseIInformationFlow(IInformationFlow object) {
				return createIInformationFlowAdapter();
			}
			@Override
			public Adapter caseIInformationItem(IInformationItem object) {
				return createIInformationItemAdapter();
			}
			@Override
			public Adapter caseIInstance(IInstance object) {
				return createIInstanceAdapter();
			}
			@Override
			public Adapter caseIInstanceSlot(IInstanceSlot object) {
				return createIInstanceSlotAdapter();
			}
			@Override
			public Adapter caseIInstanceSpecification(IInstanceSpecification object) {
				return createIInstanceSpecificationAdapter();
			}
			@Override
			public Adapter caseIInstanceValue(IInstanceValue object) {
				return createIInstanceValueAdapter();
			}
			@Override
			public Adapter caseIInteractionOccurrence(IInteractionOccurrence object) {
				return createIInteractionOccurrenceAdapter();
			}
			@Override
			public Adapter caseIInteractionOperand(IInteractionOperand object) {
				return createIInteractionOperandAdapter();
			}
			@Override
			public Adapter caseIInteractionOperator(IInteractionOperator object) {
				return createIInteractionOperatorAdapter();
			}
			@Override
			public Adapter caseIInterfaceItem(IInterfaceItem object) {
				return createIInterfaceItemAdapter();
			}
			@Override
			public Adapter caseIInterfaceItemTrigger(IInterfaceItemTrigger object) {
				return createIInterfaceItemTriggerAdapter();
			}
			@Override
			public Adapter caseIInternalHyperlink(IInternalHyperlink object) {
				return createIInternalHyperlinkAdapter();
			}
			@Override
			public Adapter caseILabel(ILabel object) {
				return createILabelAdapter();
			}
			@Override
			public Adapter caseILink(ILink object) {
				return createILinkAdapter();
			}
			@Override
			public Adapter caseILinkInstance(ILinkInstance object) {
				return createILinkInstanceAdapter();
			}
			@Override
			public Adapter caseILiteralSpecification(ILiteralSpecification object) {
				return createILiteralSpecificationAdapter();
			}
			@Override
			public Adapter caseIMHyperLink(IMHyperLink object) {
				return createIMHyperLinkAdapter();
			}
			@Override
			public Adapter caseIMSC(IMSC object) {
				return createIMSCAdapter();
			}
			@Override
			public Adapter caseIMatrixInstance(IMatrixInstance object) {
				return createIMatrixInstanceAdapter();
			}
			@Override
			public Adapter caseIMatrixLayout(IMatrixLayout object) {
				return createIMatrixLayoutAdapter();
			}
			@Override
			public Adapter caseIMatrixView(IMatrixView object) {
				return createIMatrixViewAdapter();
			}
			@Override
			public Adapter caseIMessage(IMessage object) {
				return createIMessageAdapter();
			}
			@Override
			public Adapter caseIMessagePoint(IMessagePoint object) {
				return createIMessagePointAdapter();
			}
			@Override
			public Adapter caseIMetaLinkHandle(IMetaLinkHandle object) {
				return createIMetaLinkHandleAdapter();
			}
			@Override
			public Adapter caseIModelElement(IModelElement object) {
				return createIModelElementAdapter();
			}
			@Override
			public Adapter caseIModule(IModule object) {
				return createIModuleAdapter();
			}
			@Override
			public Adapter caseIMultiplicityItem(IMultiplicityItem object) {
				return createIMultiplicityItemAdapter();
			}
			@Override
			public Adapter caseINode(INode object) {
				return createINodeAdapter();
			}
			@Override
			public Adapter caseIObjectLink(IObjectLink object) {
				return createIObjectLinkAdapter();
			}
			@Override
			public Adapter caseIObjectLinkHandle(IObjectLinkHandle object) {
				return createIObjectLinkHandleAdapter();
			}
			@Override
			public Adapter caseIObjectModelDiagram(IObjectModelDiagram object) {
				return createIObjectModelDiagramAdapter();
			}
			@Override
			public Adapter caseIObjectNode(IObjectNode object) {
				return createIObjectNodeAdapter();
			}
			@Override
			public Adapter caseIOperation(IOperation object) {
				return createIOperationAdapter();
			}
			@Override
			public Adapter caseIPackage(IPackage object) {
				return createIPackageAdapter();
			}
			@Override
			public Adapter caseIPanelDiagram(IPanelDiagram object) {
				return createIPanelDiagramAdapter();
			}
			@Override
			public Adapter caseIPart(IPart object) {
				return createIPartAdapter();
			}
			@Override
			public Adapter caseIPin(IPin object) {
				return createIPinAdapter();
			}
			@Override
			public Adapter caseIPort(IPort object) {
				return createIPortAdapter();
			}
			@Override
			public Adapter caseIPrimitiveOperation(IPrimitiveOperation object) {
				return createIPrimitiveOperationAdapter();
			}
			@Override
			public Adapter caseIProfile(IProfile object) {
				return createIProfileAdapter();
			}
			@Override
			public Adapter caseIProject(IProject object) {
				return createIProjectAdapter();
			}
			@Override
			public Adapter caseIProperty(IProperty object) {
				return createIPropertyAdapter();
			}
			@Override
			public Adapter caseIPropertyContainer(IPropertyContainer object) {
				return createIPropertyContainerAdapter();
			}
			@Override
			public Adapter caseIPropertyMetaclass(IPropertyMetaclass object) {
				return createIPropertyMetaclassAdapter();
			}
			@Override
			public Adapter caseIPropertySubject(IPropertySubject object) {
				return createIPropertySubjectAdapter();
			}
			@Override
			public Adapter caseIReception(IReception object) {
				return createIReceptionAdapter();
			}
			@Override
			public Adapter caseIReferenceActivity(IReferenceActivity object) {
				return createIReferenceActivityAdapter();
			}
			@Override
			public Adapter caseIRelation(IRelation object) {
				return createIRelationAdapter();
			}
			@Override
			public Adapter caseIRequirement(IRequirement object) {
				return createIRequirementAdapter();
			}
			@Override
			public Adapter caseISendAction(ISendAction object) {
				return createISendActionAdapter();
			}
			@Override
			public Adapter caseISequenceDiagram(ISequenceDiagram object) {
				return createISequenceDiagramAdapter();
			}
			@Override
			public Adapter caseISlot(ISlot object) {
				return createISlotAdapter();
			}
			@Override
			public Adapter caseIState(IState object) {
				return createIStateAdapter();
			}
			@Override
			public Adapter caseIStateChart(IStateChart object) {
				return createIStateChartAdapter();
			}
			@Override
			public Adapter caseIStateChartDiagram(IStateChartDiagram object) {
				return createIStateChartDiagramAdapter();
			}
			@Override
			public Adapter caseIStateVertex(IStateVertex object) {
				return createIStateVertexAdapter();
			}
			@Override
			public Adapter caseIStereotype(IStereotype object) {
				return createIStereotypeAdapter();
			}
			@Override
			public Adapter caseIStructureDiagram(IStructureDiagram object) {
				return createIStructureDiagramAdapter();
			}
			@Override
			public Adapter caseISubsystem(ISubsystem object) {
				return createISubsystemAdapter();
			}
			@Override
			public Adapter caseISwimlane(ISwimlane object) {
				return createISwimlaneAdapter();
			}
			@Override
			public Adapter caseISysMLPort(ISysMLPort object) {
				return createISysMLPortAdapter();
			}
			@Override
			public Adapter caseITableInstance(ITableInstance object) {
				return createITableInstanceAdapter();
			}
			@Override
			public Adapter caseITableLayout(ITableLayout object) {
				return createITableLayoutAdapter();
			}
			@Override
			public Adapter caseITableView(ITableView object) {
				return createITableViewAdapter();
			}
			@Override
			public Adapter caseITag(ITag object) {
				return createITagAdapter();
			}
			@Override
			public Adapter caseITemplateInst(ITemplateInst object) {
				return createITemplateInstAdapter();
			}
			@Override
			public Adapter caseITemplateInstParam(ITemplateInstParam object) {
				return createITemplateInstParamAdapter();
			}
			@Override
			public Adapter caseITemplateInstantiation(ITemplateInstantiation object) {
				return createITemplateInstantiationAdapter();
			}
			@Override
			public Adapter caseITemplateInstantiationParameter(ITemplateInstantiationParameter object) {
				return createITemplateInstantiationParameterAdapter();
			}
			@Override
			public Adapter caseITemplateParameter(ITemplateParameter object) {
				return createITemplateParameterAdapter();
			}
			@Override
			public Adapter caseITimeEvent(ITimeEvent object) {
				return createITimeEventAdapter();
			}
			@Override
			public Adapter caseITimeout(ITimeout object) {
				return createITimeoutAdapter();
			}
			@Override
			public Adapter caseITransition(ITransition object) {
				return createITransitionAdapter();
			}
			@Override
			public Adapter caseITrigger(ITrigger object) {
				return createITriggerAdapter();
			}
			@Override
			public Adapter caseITriggered(ITriggered object) {
				return createITriggeredAdapter();
			}
			@Override
			public Adapter caseIType(IType object) {
				return createITypeAdapter();
			}
			@Override
			public Adapter caseIUCDiagram(IUCDiagram object) {
				return createIUCDiagramAdapter();
			}
			@Override
			public Adapter caseIUnit(IUnit object) {
				return createIUnitAdapter();
			}
			@Override
			public Adapter caseIUseCase(IUseCase object) {
				return createIUseCaseAdapter();
			}
			@Override
			public Adapter caseIUseCaseDiagram(IUseCaseDiagram object) {
				return createIUseCaseDiagramAdapter();
			}
			@Override
			public Adapter caseIUseCaseStereoType(IUseCaseStereoType object) {
				return createIUseCaseStereoTypeAdapter();
			}
			@Override
			public Adapter caseIValueSpecification(IValueSpecification object) {
				return createIValueSpecificationAdapter();
			}
			@Override
			public Adapter caseIVariable(IVariable object) {
				return createIVariableAdapter();
			}
			@Override
			public Adapter caseInverseType(InverseType object) {
				return createInverseTypeAdapter();
			}
			@Override
			public Adapter caseItemsType(ItemsType object) {
				return createItemsTypeAdapter();
			}
			@Override
			public Adapter caseItsLabelType(ItsLabelType object) {
				return createItsLabelTypeAdapter();
			}
			@Override
			public Adapter caseItsStateChartType(ItsStateChartType object) {
				return createItsStateChartTypeAdapter();
			}
			@Override
			public Adapter caseItsTargetType(ItsTargetType object) {
				return createItsTargetTypeAdapter();
			}
			@Override
			public Adapter caseItsTriggerType(ItsTriggerType object) {
				return createItsTriggerTypeAdapter();
			}
			@Override
			public Adapter caseLinksType(LinksType object) {
				return createLinksTypeAdapter();
			}
			@Override
			public Adapter caseM_hTargetType(M_hTargetType object) {
				return createM_hTargetTypeAdapter();
			}
			@Override
			public Adapter caseM_pBaseType(M_pBaseType object) {
				return createM_pBaseTypeAdapter();
			}
			@Override
			public Adapter caseM_pFormalMessageType(M_pFormalMessageType object) {
				return createM_pFormalMessageTypeAdapter();
			}
			@Override
			public Adapter caseM_pModelObjectType(M_pModelObjectType object) {
				return createM_pModelObjectTypeAdapter();
			}
			@Override
			public Adapter caseM_pRootType(M_pRootType object) {
				return createM_pRootTypeAdapter();
			}
			@Override
			public Adapter caseM_subjectType(M_subjectType object) {
				return createM_subjectTypeAdapter();
			}
			@Override
			public Adapter caseMatrixInstancesType(MatrixInstancesType object) {
				return createMatrixInstancesTypeAdapter();
			}
			@Override
			public Adapter caseNestedStateChartType(NestedStateChartType object) {
				return createNestedStateChartTypeAdapter();
			}
			@Override
			public Adapter caseObjectLinksType(ObjectLinksType object) {
				return createObjectLinksTypeAdapter();
			}
			@Override
			public Adapter caseOperationsType(OperationsType object) {
				return createOperationsTypeAdapter();
			}
			@Override
			public Adapter caseOwnerHandleType(OwnerHandleType object) {
				return createOwnerHandleTypeAdapter();
			}
			@Override
			public Adapter caseP_MessageHandlerType(P_MessageHandlerType object) {
				return createP_MessageHandlerTypeAdapter();
			}
			@Override
			public Adapter caseParentType(ParentType object) {
				return createParentTypeAdapter();
			}
			@Override
			public Adapter casePropertiesType(PropertiesType object) {
				return createPropertiesTypeAdapter();
			}
			@Override
			public Adapter caseTableDataDefinition(TableDataDefinition object) {
				return createTableDataDefinitionAdapter();
			}
			@Override
			public Adapter caseTableInstancesType(TableInstancesType object) {
				return createTableInstancesTypeAdapter();
			}
			@Override
			public Adapter caseTargetType(TargetType object) {
				return createTargetTypeAdapter();
			}
			@Override
			public Adapter caseTheMainDiagramType(TheMainDiagramType object) {
				return createTheMainDiagramTypeAdapter();
			}
			@Override
			public Adapter caseToLinkType(ToLinkType object) {
				return createToLinkTypeAdapter();
			}
			@Override
			public Adapter caseTransitionsType(TransitionsType object) {
				return createTransitionsTypeAdapter();
			}
			@Override
			public Adapter caseUnknownType(UnknownType object) {
				return createUnknownTypeAdapter();
			}
			@Override
			public Adapter caseValueType(ValueType object) {
				return createValueTypeAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.AssociationsType <em>Associations Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.AssociationsType
	 * @generated
	 */
	public Adapter createAssociationsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CCollaborationChart <em>CCollaboration Chart</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CCollaborationChart
	 * @generated
	 */
	public Adapter createCCollaborationChartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIActionState <em>CGI Action State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIActionState
	 * @generated
	 */
	public Adapter createCGIActionStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIActiveX <em>CGI Active X</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIActiveX
	 * @generated
	 */
	public Adapter createCGIActiveXAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIAnchor <em>CGI Anchor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIAnchor
	 * @generated
	 */
	public Adapter createCGIAnchorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIAnnotation <em>CGI Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIAnnotation
	 * @generated
	 */
	public Adapter createCGIAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIArrow <em>CGI Arrow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIArrow
	 * @generated
	 */
	public Adapter createCGIArrowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIAssociationEnd <em>CGI Association End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIAssociationEnd
	 * @generated
	 */
	public Adapter createCGIAssociationEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIAssociationRole <em>CGI Association Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIAssociationRole
	 * @generated
	 */
	public Adapter createCGIAssociationRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIBasicClass <em>CGI Basic Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIBasicClass
	 * @generated
	 */
	public Adapter createCGIBasicClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIBlockState <em>CGI Block State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIBlockState
	 * @generated
	 */
	public Adapter createCGIBlockStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIBox <em>CGI Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIBox
	 * @generated
	 */
	public Adapter createCGIBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIButtonArray <em>CGI Button Array</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIButtonArray
	 * @generated
	 */
	public Adapter createCGIButtonArrayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass <em>CGI Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClass
	 * @generated
	 */
	public Adapter createCGIClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClassChart <em>CGI Class Chart</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClassChart
	 * @generated
	 */
	public Adapter createCGIClassChartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClassifierRole <em>CGI Classifier Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIClassifierRole
	 * @generated
	 */
	public Adapter createCGIClassifierRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGICompartment <em>CGI Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGICompartment
	 * @generated
	 */
	public Adapter createCGICompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIComponent <em>CGI Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIComponent
	 * @generated
	 */
	public Adapter createCGIComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGICompositeClass <em>CGI Composite Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGICompositeClass
	 * @generated
	 */
	public Adapter createCGICompositeClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIConnector <em>CGI Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIConnector
	 * @generated
	 */
	public Adapter createCGIConnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIContainArrow <em>CGI Contain Arrow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIContainArrow
	 * @generated
	 */
	public Adapter createCGIContainArrowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIDiagramFrame <em>CGI Diagram Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIDiagramFrame
	 * @generated
	 */
	public Adapter createCGIDiagramFrameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIFreeShape <em>CGI Free Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIFreeShape
	 * @generated
	 */
	public Adapter createCGIFreeShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIFreeText <em>CGI Free Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIFreeText
	 * @generated
	 */
	public Adapter createCGIFreeTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIGenericElement <em>CGI Generic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIGenericElement
	 * @generated
	 */
	public Adapter createCGIGenericElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIImage <em>CGI Image</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIImage
	 * @generated
	 */
	public Adapter createCGIImageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIImageData <em>CGI Image Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIImageData
	 * @generated
	 */
	public Adapter createCGIImageDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIInformationFlow <em>CGI Information Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIInformationFlow
	 * @generated
	 */
	public Adapter createCGIInformationFlowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIInheritance <em>CGI Inheritance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIInheritance
	 * @generated
	 */
	public Adapter createCGIInheritanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMFCCtrl <em>CGIMFC Ctrl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMFCCtrl
	 * @generated
	 */
	public Adapter createCGIMFCCtrlAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMessageLabel <em>CGI Message Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMessageLabel
	 * @generated
	 */
	public Adapter createCGIMessageLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMscChart <em>CGI Msc Chart</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMscChart
	 * @generated
	 */
	public Adapter createCGIMscChartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMscColumnCR <em>CGI Msc Column CR</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMscColumnCR
	 * @generated
	 */
	public Adapter createCGIMscColumnCRAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMscConditionMark <em>CGI Msc Condition Mark</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMscConditionMark
	 * @generated
	 */
	public Adapter createCGIMscConditionMarkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMscExecutionOccurrence <em>CGI Msc Execution Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMscExecutionOccurrence
	 * @generated
	 */
	public Adapter createCGIMscExecutionOccurrenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMscInteractionOccurrence <em>CGI Msc Interaction Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMscInteractionOccurrence
	 * @generated
	 */
	public Adapter createCGIMscInteractionOccurrenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMscInteractionOperand <em>CGI Msc Interaction Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMscInteractionOperand
	 * @generated
	 */
	public Adapter createCGIMscInteractionOperandAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMscInteractionOperator <em>CGI Msc Interaction Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMscInteractionOperator
	 * @generated
	 */
	public Adapter createCGIMscInteractionOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMscMessage <em>CGI Msc Message</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIMscMessage
	 * @generated
	 */
	public Adapter createCGIMscMessageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIObjectInstance <em>CGI Object Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIObjectInstance
	 * @generated
	 */
	public Adapter createCGIObjectInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIObjectLink <em>CGI Object Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIObjectLink
	 * @generated
	 */
	public Adapter createCGIObjectLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIPackage <em>CGI Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIPackage
	 * @generated
	 */
	public Adapter createCGIPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIPartition <em>CGI Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIPartition
	 * @generated
	 */
	public Adapter createCGIPartitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIPortConnector <em>CGI Port Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIPortConnector
	 * @generated
	 */
	public Adapter createCGIPortConnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState <em>CGI State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIState
	 * @generated
	 */
	public Adapter createCGIStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIStateChart <em>CGI State Chart</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIStateChart
	 * @generated
	 */
	public Adapter createCGIStateChartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGISwimlaneFrame <em>CGI Swimlane Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGISwimlaneFrame
	 * @generated
	 */
	public Adapter createCGISwimlaneFrameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText <em>CGI Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIText
	 * @generated
	 */
	public Adapter createCGITextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGITextBox <em>CGI Text Box</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGITextBox
	 * @generated
	 */
	public Adapter createCGITextBoxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGITrans <em>CGI Trans</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGITrans
	 * @generated
	 */
	public Adapter createCGITransAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CollEvent <em>Coll Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CollEvent
	 * @generated
	 */
	public Adapter createCollEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CompartmentsType <em>Compartments Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CompartmentsType
	 * @generated
	 */
	public Adapter createCompartmentsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ComponentsType <em>Components Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ComponentsType
	 * @generated
	 */
	public Adapter createComponentsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ConveyedType <em>Conveyed Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ConveyedType
	 * @generated
	 */
	public Adapter createConveyedTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DeclarativesType <em>Declaratives Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DeclarativesType
	 * @generated
	 */
	public Adapter createDeclarativesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DefaultSubsystemType <em>Default Subsystem Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DefaultSubsystemType
	 * @generated
	 */
	public Adapter createDefaultSubsystemTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DefaultTransType <em>Default Trans Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DefaultTransType
	 * @generated
	 */
	public Adapter createDefaultTransTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DependsOnType <em>Depends On Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DependsOnType
	 * @generated
	 */
	public Adapter createDependsOnTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DescriptionType <em>Description Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.DescriptionType
	 * @generated
	 */
	public Adapter createDescriptionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ElementsType <em>Elements Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ElementsType
	 * @generated
	 */
	public Adapter createElementsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.EmbededFilesType <em>Embeded Files Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.EmbededFilesType
	 * @generated
	 */
	public Adapter createEmbededFilesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.End1_Type <em>End1 Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.End1_Type
	 * @generated
	 */
	public Adapter createEnd1_TypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.End2_Type <em>End2 Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.End2_Type
	 * @generated
	 */
	public Adapter createEnd2_TypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.FilesType <em>Files Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.FilesType
	 * @generated
	 */
	public Adapter createFilesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.FromLinkType <em>From Link Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.FromLinkType
	 * @generated
	 */
	public Adapter createFromLinkTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.GraphElementsType <em>Graph Elements Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.GraphElementsType
	 * @generated
	 */
	public Adapter createGraphElementsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.GraphicChartType <em>Graphic Chart Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.GraphicChartType
	 * @generated
	 */
	public Adapter createGraphicChartTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.HyperLinksType <em>Hyper Links Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.HyperLinksType
	 * @generated
	 */
	public Adapter createHyperLinksTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAcceptEventAction <em>IAccept Event Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAcceptEventAction
	 * @generated
	 */
	public Adapter createIAcceptEventActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAcceptTimeEvent <em>IAccept Time Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAcceptTimeEvent
	 * @generated
	 */
	public Adapter createIAcceptTimeEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAction <em>IAction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAction
	 * @generated
	 */
	public Adapter createIActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IActivityDiagram <em>IActivity Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IActivityDiagram
	 * @generated
	 */
	public Adapter createIActivityDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IActivityGraph <em>IActivity Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IActivityGraph
	 * @generated
	 */
	public Adapter createIActivityGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IActor <em>IActor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IActor
	 * @generated
	 */
	public Adapter createIActorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAnchor <em>IAnchor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAnchor
	 * @generated
	 */
	public Adapter createIAnchorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAnnotation <em>IAnnotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAnnotation
	 * @generated
	 */
	public Adapter createIAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IArgument <em>IArgument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IArgument
	 * @generated
	 */
	public Adapter createIArgumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationClass <em>IAssociation Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationClass
	 * @generated
	 */
	public Adapter createIAssociationClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationEnd <em>IAssociation End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationEnd
	 * @generated
	 */
	public Adapter createIAssociationEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationEndHandle <em>IAssociation End Handle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationEndHandle
	 * @generated
	 */
	public Adapter createIAssociationEndHandleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationRole <em>IAssociation Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAssociationRole
	 * @generated
	 */
	public Adapter createIAssociationRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAttribute <em>IAttribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAttribute
	 * @generated
	 */
	public Adapter createIAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IBlock <em>IBlock</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IBlock
	 * @generated
	 */
	public Adapter createIBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IBody <em>IBody</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IBody
	 * @generated
	 */
	public Adapter createIBodyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IBranch <em>IBranch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IBranch
	 * @generated
	 */
	public Adapter createIBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICallAction <em>ICall Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICallAction
	 * @generated
	 */
	public Adapter createICallActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICallOperation <em>ICall Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICallOperation
	 * @generated
	 */
	public Adapter createICallOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClass <em>IClass</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClass
	 * @generated
	 */
	public Adapter createIClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassHandle <em>IClass Handle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassHandle
	 * @generated
	 */
	public Adapter createIClassHandleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassInstance <em>IClass Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassInstance
	 * @generated
	 */
	public Adapter createIClassInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassifier <em>IClassifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassifier
	 * @generated
	 */
	public Adapter createIClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassifierRole <em>IClassifier Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IClassifierRole
	 * @generated
	 */
	public Adapter createIClassifierRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICodeGenConfigInfo <em>ICode Gen Config Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICodeGenConfigInfo
	 * @generated
	 */
	public Adapter createICodeGenConfigInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICodeGenConfigInfoHandle <em>ICode Gen Config Info Handle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICodeGenConfigInfoHandle
	 * @generated
	 */
	public Adapter createICodeGenConfigInfoHandleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICollaboration <em>ICollaboration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICollaboration
	 * @generated
	 */
	public Adapter createICollaborationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICollaborationDiagram <em>ICollaboration Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICollaborationDiagram
	 * @generated
	 */
	public Adapter createICollaborationDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IColor <em>IColor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IColor
	 * @generated
	 */
	public Adapter createIColorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICombinedFragment <em>ICombined Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICombinedFragment
	 * @generated
	 */
	public Adapter createICombinedFragmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IComment <em>IComment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IComment
	 * @generated
	 */
	public Adapter createICommentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IComponent <em>IComponent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IComponent
	 * @generated
	 */
	public Adapter createIComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IComponentDiagram <em>IComponent Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IComponentDiagram
	 * @generated
	 */
	public Adapter createIComponentDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IComponentInstance <em>IComponent Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IComponentInstance
	 * @generated
	 */
	public Adapter createIComponentInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IConfiguration <em>IConfiguration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IConfiguration
	 * @generated
	 */
	public Adapter createIConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IConnector <em>IConnector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IConnector
	 * @generated
	 */
	public Adapter createIConnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IConstraint <em>IConstraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IConstraint
	 * @generated
	 */
	public Adapter createIConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IConstructor <em>IConstructor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IConstructor
	 * @generated
	 */
	public Adapter createIConstructorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IContextSpecification <em>IContext Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IContextSpecification
	 * @generated
	 */
	public Adapter createIContextSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IControlledFile <em>IControlled File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IControlledFile
	 * @generated
	 */
	public Adapter createIControlledFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDefaultDrvdTrans <em>IDefault Drvd Trans</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDefaultDrvdTrans
	 * @generated
	 */
	public Adapter createIDefaultDrvdTransAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDependency <em>IDependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDependency
	 * @generated
	 */
	public Adapter createIDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDeploymentDiagram <em>IDeployment Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDeploymentDiagram
	 * @generated
	 */
	public Adapter createIDeploymentDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDescription <em>IDescription</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDescription
	 * @generated
	 */
	public Adapter createIDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDestructor <em>IDestructor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDestructor
	 * @generated
	 */
	public Adapter createIDestructorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDiagram <em>IDiagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDiagram
	 * @generated
	 */
	public Adapter createIDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IEmbededFile <em>IEmbeded File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IEmbededFile
	 * @generated
	 */
	public Adapter createIEmbededFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IEnumerationLiteral <em>IEnumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IEnumerationLiteral
	 * @generated
	 */
	public Adapter createIEnumerationLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IEvent <em>IEvent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IEvent
	 * @generated
	 */
	public Adapter createIEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IEventHandle <em>IEvent Handle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IEventHandle
	 * @generated
	 */
	public Adapter createIEventHandleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IEventReception <em>IEvent Reception</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IEventReception
	 * @generated
	 */
	public Adapter createIEventReceptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IExecutionOccurrence <em>IExecution Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IExecutionOccurrence
	 * @generated
	 */
	public Adapter createIExecutionOccurrenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IExternalHyperlink <em>IExternal Hyperlink</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IExternalHyperlink
	 * @generated
	 */
	public Adapter createIExternalHyperlinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFile <em>IFile</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFile
	 * @generated
	 */
	public Adapter createIFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFileFragment <em>IFile Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFileFragment
	 * @generated
	 */
	public Adapter createIFileFragmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFlow <em>IFlow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFlow
	 * @generated
	 */
	public Adapter createIFlowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFlowItem <em>IFlow Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFlowItem
	 * @generated
	 */
	public Adapter createIFlowItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFlowchart <em>IFlowchart</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFlowchart
	 * @generated
	 */
	public Adapter createIFlowchartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFolder <em>IFolder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFolder
	 * @generated
	 */
	public Adapter createIFolderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFork <em>IFork</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IFork
	 * @generated
	 */
	public Adapter createIForkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IGeneralization <em>IGeneralization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IGeneralization
	 * @generated
	 */
	public Adapter createIGeneralizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IGuard <em>IGuard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IGuard
	 * @generated
	 */
	public Adapter createIGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IHandleWithData <em>IHandle With Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IHandleWithData
	 * @generated
	 */
	public Adapter createIHandleWithDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IHistoryConnector <em>IHistory Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IHistoryConnector
	 * @generated
	 */
	public Adapter createIHistoryConnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IHyperLink <em>IHyper Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IHyperLink
	 * @generated
	 */
	public Adapter createIHyperLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInformationFlow <em>IInformation Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInformationFlow
	 * @generated
	 */
	public Adapter createIInformationFlowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInformationItem <em>IInformation Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInformationItem
	 * @generated
	 */
	public Adapter createIInformationItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInstance <em>IInstance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInstance
	 * @generated
	 */
	public Adapter createIInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInstanceSlot <em>IInstance Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInstanceSlot
	 * @generated
	 */
	public Adapter createIInstanceSlotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInstanceSpecification <em>IInstance Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInstanceSpecification
	 * @generated
	 */
	public Adapter createIInstanceSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInstanceValue <em>IInstance Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInstanceValue
	 * @generated
	 */
	public Adapter createIInstanceValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInteractionOccurrence <em>IInteraction Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInteractionOccurrence
	 * @generated
	 */
	public Adapter createIInteractionOccurrenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInteractionOperand <em>IInteraction Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInteractionOperand
	 * @generated
	 */
	public Adapter createIInteractionOperandAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInteractionOperator <em>IInteraction Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInteractionOperator
	 * @generated
	 */
	public Adapter createIInteractionOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInterfaceItem <em>IInterface Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInterfaceItem
	 * @generated
	 */
	public Adapter createIInterfaceItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInterfaceItemTrigger <em>IInterface Item Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInterfaceItemTrigger
	 * @generated
	 */
	public Adapter createIInterfaceItemTriggerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInternalHyperlink <em>IInternal Hyperlink</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInternalHyperlink
	 * @generated
	 */
	public Adapter createIInternalHyperlinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ILabel <em>ILabel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ILabel
	 * @generated
	 */
	public Adapter createILabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ILink <em>ILink</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ILink
	 * @generated
	 */
	public Adapter createILinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ILinkInstance <em>ILink Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ILinkInstance
	 * @generated
	 */
	public Adapter createILinkInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ILiteralSpecification <em>ILiteral Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ILiteralSpecification
	 * @generated
	 */
	public Adapter createILiteralSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMHyperLink <em>IM Hyper Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMHyperLink
	 * @generated
	 */
	public Adapter createIMHyperLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMSC <em>IMSC</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMSC
	 * @generated
	 */
	public Adapter createIMSCAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMatrixInstance <em>IMatrix Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMatrixInstance
	 * @generated
	 */
	public Adapter createIMatrixInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMatrixLayout <em>IMatrix Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMatrixLayout
	 * @generated
	 */
	public Adapter createIMatrixLayoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMatrixView <em>IMatrix View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMatrixView
	 * @generated
	 */
	public Adapter createIMatrixViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMessage <em>IMessage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMessage
	 * @generated
	 */
	public Adapter createIMessageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMessagePoint <em>IMessage Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMessagePoint
	 * @generated
	 */
	public Adapter createIMessagePointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMetaLinkHandle <em>IMeta Link Handle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMetaLinkHandle
	 * @generated
	 */
	public Adapter createIMetaLinkHandleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IModelElement <em>IModel Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IModelElement
	 * @generated
	 */
	public Adapter createIModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IModule <em>IModule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IModule
	 * @generated
	 */
	public Adapter createIModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMultiplicityItem <em>IMultiplicity Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMultiplicityItem
	 * @generated
	 */
	public Adapter createIMultiplicityItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.INode <em>INode</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.INode
	 * @generated
	 */
	public Adapter createINodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IObjectLink <em>IObject Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IObjectLink
	 * @generated
	 */
	public Adapter createIObjectLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IObjectLinkHandle <em>IObject Link Handle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IObjectLinkHandle
	 * @generated
	 */
	public Adapter createIObjectLinkHandleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IObjectModelDiagram <em>IObject Model Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IObjectModelDiagram
	 * @generated
	 */
	public Adapter createIObjectModelDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IObjectNode <em>IObject Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IObjectNode
	 * @generated
	 */
	public Adapter createIObjectNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IOperation <em>IOperation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IOperation
	 * @generated
	 */
	public Adapter createIOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPackage <em>IPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPackage
	 * @generated
	 */
	public Adapter createIPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPanelDiagram <em>IPanel Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPanelDiagram
	 * @generated
	 */
	public Adapter createIPanelDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPart <em>IPart</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPart
	 * @generated
	 */
	public Adapter createIPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPin <em>IPin</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPin
	 * @generated
	 */
	public Adapter createIPinAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPort <em>IPort</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPort
	 * @generated
	 */
	public Adapter createIPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPrimitiveOperation <em>IPrimitive Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPrimitiveOperation
	 * @generated
	 */
	public Adapter createIPrimitiveOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IProfile <em>IProfile</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IProfile
	 * @generated
	 */
	public Adapter createIProfileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IProject <em>IProject</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IProject
	 * @generated
	 */
	public Adapter createIProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IProperty <em>IProperty</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IProperty
	 * @generated
	 */
	public Adapter createIPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer <em>IProperty Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyContainer
	 * @generated
	 */
	public Adapter createIPropertyContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyMetaclass <em>IProperty Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertyMetaclass
	 * @generated
	 */
	public Adapter createIPropertyMetaclassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertySubject <em>IProperty Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IPropertySubject
	 * @generated
	 */
	public Adapter createIPropertySubjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IReception <em>IReception</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IReception
	 * @generated
	 */
	public Adapter createIReceptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IReferenceActivity <em>IReference Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IReferenceActivity
	 * @generated
	 */
	public Adapter createIReferenceActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IRelation <em>IRelation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IRelation
	 * @generated
	 */
	public Adapter createIRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IRequirement <em>IRequirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IRequirement
	 * @generated
	 */
	public Adapter createIRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISendAction <em>ISend Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISendAction
	 * @generated
	 */
	public Adapter createISendActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISequenceDiagram <em>ISequence Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISequenceDiagram
	 * @generated
	 */
	public Adapter createISequenceDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISlot <em>ISlot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISlot
	 * @generated
	 */
	public Adapter createISlotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState <em>IState</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState
	 * @generated
	 */
	public Adapter createIStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStateChart <em>IState Chart</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStateChart
	 * @generated
	 */
	public Adapter createIStateChartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStateChartDiagram <em>IState Chart Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStateChartDiagram
	 * @generated
	 */
	public Adapter createIStateChartDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStateVertex <em>IState Vertex</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStateVertex
	 * @generated
	 */
	public Adapter createIStateVertexAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype <em>IStereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype
	 * @generated
	 */
	public Adapter createIStereotypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStructureDiagram <em>IStructure Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStructureDiagram
	 * @generated
	 */
	public Adapter createIStructureDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISubsystem <em>ISubsystem</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISubsystem
	 * @generated
	 */
	public Adapter createISubsystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISwimlane <em>ISwimlane</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISwimlane
	 * @generated
	 */
	public Adapter createISwimlaneAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISysMLPort <em>ISys ML Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISysMLPort
	 * @generated
	 */
	public Adapter createISysMLPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITableInstance <em>ITable Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITableInstance
	 * @generated
	 */
	public Adapter createITableInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITableLayout <em>ITable Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITableLayout
	 * @generated
	 */
	public Adapter createITableLayoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITableView <em>ITable View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITableView
	 * @generated
	 */
	public Adapter createITableViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITag <em>ITag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITag
	 * @generated
	 */
	public Adapter createITagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITemplateInst <em>ITemplate Inst</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITemplateInst
	 * @generated
	 */
	public Adapter createITemplateInstAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITemplateInstParam <em>ITemplate Inst Param</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITemplateInstParam
	 * @generated
	 */
	public Adapter createITemplateInstParamAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITemplateInstantiation <em>ITemplate Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITemplateInstantiation
	 * @generated
	 */
	public Adapter createITemplateInstantiationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITemplateInstantiationParameter <em>ITemplate Instantiation Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITemplateInstantiationParameter
	 * @generated
	 */
	public Adapter createITemplateInstantiationParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITemplateParameter <em>ITemplate Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITemplateParameter
	 * @generated
	 */
	public Adapter createITemplateParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITimeEvent <em>ITime Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITimeEvent
	 * @generated
	 */
	public Adapter createITimeEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITimeout <em>ITimeout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITimeout
	 * @generated
	 */
	public Adapter createITimeoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITransition <em>ITransition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITransition
	 * @generated
	 */
	public Adapter createITransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITrigger <em>ITrigger</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITrigger
	 * @generated
	 */
	public Adapter createITriggerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered <em>ITriggered</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITriggered
	 * @generated
	 */
	public Adapter createITriggeredAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IType <em>IType</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IType
	 * @generated
	 */
	public Adapter createITypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUCDiagram <em>IUC Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUCDiagram
	 * @generated
	 */
	public Adapter createIUCDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUnit <em>IUnit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUnit
	 * @generated
	 */
	public Adapter createIUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUseCase <em>IUse Case</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUseCase
	 * @generated
	 */
	public Adapter createIUseCaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUseCaseDiagram <em>IUse Case Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUseCaseDiagram
	 * @generated
	 */
	public Adapter createIUseCaseDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUseCaseStereoType <em>IUse Case Stereo Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IUseCaseStereoType
	 * @generated
	 */
	public Adapter createIUseCaseStereoTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IValueSpecification <em>IValue Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IValueSpecification
	 * @generated
	 */
	public Adapter createIValueSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IVariable <em>IVariable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IVariable
	 * @generated
	 */
	public Adapter createIVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.InverseType <em>Inverse Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.InverseType
	 * @generated
	 */
	public Adapter createInverseTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItemsType <em>Items Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItemsType
	 * @generated
	 */
	public Adapter createItemsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItsLabelType <em>Its Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItsLabelType
	 * @generated
	 */
	public Adapter createItsLabelTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItsStateChartType <em>Its State Chart Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItsStateChartType
	 * @generated
	 */
	public Adapter createItsStateChartTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItsTargetType <em>Its Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItsTargetType
	 * @generated
	 */
	public Adapter createItsTargetTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItsTriggerType <em>Its Trigger Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ItsTriggerType
	 * @generated
	 */
	public Adapter createItsTriggerTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.LinksType <em>Links Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.LinksType
	 * @generated
	 */
	public Adapter createLinksTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_hTargetType <em>MhTarget Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_hTargetType
	 * @generated
	 */
	public Adapter createM_hTargetTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pBaseType <em>MpBase Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pBaseType
	 * @generated
	 */
	public Adapter createM_pBaseTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pFormalMessageType <em>MpFormal Message Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pFormalMessageType
	 * @generated
	 */
	public Adapter createM_pFormalMessageTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pModelObjectType <em>MpModel Object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pModelObjectType
	 * @generated
	 */
	public Adapter createM_pModelObjectTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pRootType <em>MpRoot Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pRootType
	 * @generated
	 */
	public Adapter createM_pRootTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_subjectType <em>Msubject Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_subjectType
	 * @generated
	 */
	public Adapter createM_subjectTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.MatrixInstancesType <em>Matrix Instances Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.MatrixInstancesType
	 * @generated
	 */
	public Adapter createMatrixInstancesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.NestedStateChartType <em>Nested State Chart Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.NestedStateChartType
	 * @generated
	 */
	public Adapter createNestedStateChartTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ObjectLinksType <em>Object Links Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ObjectLinksType
	 * @generated
	 */
	public Adapter createObjectLinksTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.OperationsType <em>Operations Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.OperationsType
	 * @generated
	 */
	public Adapter createOperationsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.OwnerHandleType <em>Owner Handle Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.OwnerHandleType
	 * @generated
	 */
	public Adapter createOwnerHandleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.P_MessageHandlerType <em>PMessage Handler Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.P_MessageHandlerType
	 * @generated
	 */
	public Adapter createP_MessageHandlerTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ParentType <em>Parent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ParentType
	 * @generated
	 */
	public Adapter createParentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.PropertiesType <em>Properties Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.PropertiesType
	 * @generated
	 */
	public Adapter createPropertiesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TableDataDefinition <em>Table Data Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TableDataDefinition
	 * @generated
	 */
	public Adapter createTableDataDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TableInstancesType <em>Table Instances Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TableInstancesType
	 * @generated
	 */
	public Adapter createTableInstancesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TargetType <em>Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TargetType
	 * @generated
	 */
	public Adapter createTargetTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TheMainDiagramType <em>The Main Diagram Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TheMainDiagramType
	 * @generated
	 */
	public Adapter createTheMainDiagramTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ToLinkType <em>To Link Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ToLinkType
	 * @generated
	 */
	public Adapter createToLinkTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TransitionsType <em>Transitions Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.TransitionsType
	 * @generated
	 */
	public Adapter createTransitionsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UnknownType <em>Unknown Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UnknownType
	 * @generated
	 */
	public Adapter createUnknownTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ValueType
	 * @generated
	 */
	public Adapter createValueTypeAdapter() {
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

} //UMLRhapsodyAdapterFactory
