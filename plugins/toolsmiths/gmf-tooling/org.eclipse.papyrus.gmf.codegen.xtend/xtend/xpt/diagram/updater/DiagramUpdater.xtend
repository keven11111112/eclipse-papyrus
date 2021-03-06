/*******************************************************************************
 * Copyright (c) 2007, 2020 Borland Software Corporation, CEA LIST, Artal and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Borland) - [243151] explicit source/target for links
 *    Michael Golubev (Montages) - API extracted to gmf.tooling.runtime, template migrated to Xtend2  	  
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package xpt.diagram.updater

import com.google.inject.Inject
import metamodel.MetaModel
import org.eclipse.papyrus.gmf.codegen.gmfgen.FeatureLinkModelFacet
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenDiagramUpdater
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenLink
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenLinkEnd
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenNode
import org.eclipse.papyrus.gmf.codegen.gmfgen.LinkModelFacet
import org.eclipse.papyrus.gmf.codegen.gmfgen.TypeLinkModelFacet
import org.eclipse.papyrus.gmf.codegen.xtend.annotations.MetaDef
import xpt.CodeStyle
import xpt.Common
import xpt.Common_qvto
import xpt.GenModelUtils_qvto
import xpt.editor.VisualIDRegistry
import xpt.providers.ElementTypes

@com.google.inject.Singleton class DiagramUpdater {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension Utils_qvto;
	@Inject extension GenModelUtils_qvto;
	
	@Inject VisualIDRegistry xptVisualIDRegistry;
	@Inject MetaModel xptMetaModel;
	@Inject ElementTypes xptElementTypes;
	@Inject CodeStyle xptCodeStyle;
	@Inject NodeDescriptor nodeDescriptor;
	@Inject LinkDescriptor linkDescriptor;
	
	
	@MetaDef def getSemanticChildrenMethodName(GenContainerBase it) '''get«getUniqueIdentifier()»SemanticChildren'''

	@MetaDef def getSemanticChildrenMethodCall(GenContainerBase it) '''«qualifiedClassName(getDiagram().editorGen.diagramUpdater)».«getSemanticChildrenMethodName(it)»'''
	
	@MetaDef def getContainedLinksMethodCall(GenCommonBase it) '''«doGetSomeLinksMethodCall(it, UpdaterLinkType::CONTAINED)»'''
	
	@MetaDef def getIncomingLinksMethodCall(GenCommonBase it) '''«doGetSomeLinksMethodCall(it, UpdaterLinkType::INCOMING)»'''
	
	@MetaDef def getOutgoingLinksMethodCall(GenCommonBase it) '''«doGetSomeLinksMethodCall(it, UpdaterLinkType::OUTGOING)»'''
	
	@MetaDef protected def doGetSomeLinksMethodCall(GenCommonBase it, UpdaterLinkType linkType) '''«qualifiedClassName(it.getDiagram().diagramUpdater)».«linkGetterName(linkType)»'''
	
	@MetaDef protected def linkGetterName(GenCommonBase it, UpdaterLinkType linkType) '''get«it.uniqueIdentifier»«linkType.linkMethodSuffix»Links'''
	
	@MetaDef def runtimeTypedInstanceName(GenDiagramUpdater it) '''TYPED_INSTANCE'''

	@MetaDef def runtimeTypedInstanceCall(GenDiagramUpdater it) '''«qualifiedClassName(it)».«runtimeTypedInstanceName(it)»'''
	
	def className(GenDiagramUpdater it) '''«diagramUpdaterClassName»'''
	
	def packageName(GenDiagramUpdater it) '''«it.editorGen.editor.packageName»'''

	def qualifiedClassName(GenDiagramUpdater it) '''«packageName(it)».«className(it)»'''
	
	def fullPath(GenDiagramUpdater it) '''«qualifiedClassName(it)»'''
	
	def DiagramUpdater(GenDiagramUpdater it) '''
	«copyright(editorGen)»
	package «packageName(it)»;
	
	«generatedClassComment»
	public class «className(it)» {
		«isShortcutOrphaned(it)»
		«var semanticContainers = it.editorGen.diagram.allContainers.filter[container | hasSemanticChildren(container)]»
		«getGenericSemanticChildrenOfView(it, semanticContainers)»
		«FOR next : semanticContainers»
		«getSemanticChildrenOfView(next)»
		«ENDFOR»
		
		«getPhantomNodesIterator(it)»
	
		«getGenericConnectedLinks(it, getAllSemanticElements(editorGen.diagram), UpdaterLinkType::CONTAINED)»
		
		«getGenericConnectedLinks(it, getAllSemanticDiagramElements(editorGen.diagram), UpdaterLinkType::INCOMING)»
		
		«getGenericConnectedLinks(it, getAllSemanticDiagramElements(editorGen.diagram), UpdaterLinkType::OUTGOING)»
		«FOR e : getAllSemanticElements(editorGen.diagram)»
			«getContainedLinks(e)»
		«ENDFOR»
		«FOR e : getAllSemanticDiagramElements(editorGen.diagram)»
			«getIncomingLinks(e)»
		«ENDFOR»
		«FOR e : getAllSemanticDiagramElements(editorGen.diagram)»
			«getOutgoingLinks(e)»
		«ENDFOR»
		«FOR link : getAllContainedLinks(editorGen.diagram)»
			«getContainedLinksByTypeMethod(link)»
		«ENDFOR»
		«FOR link : getAllIncomingLinks(editorGen.diagram)»
			«getIncomingLinksByTypeMethod(link)»
		«ENDFOR»
		«FOR link : getAllOutgoingLinks(editorGen.diagram)»
			«getOutgoingLinksByTypeMethod(link)»
		«ENDFOR»
		
		«runtimeTypedInstance(it)»
	
		«additions(it)»
	}
	'''

	/**
	 * Currently shortcuts are supported only for domain-based diagram element.
	 * This means, view.isSetElement() == true.
	 */
	def isShortcutOrphaned(GenDiagramUpdater it) '''
		«IF editorGen.diagram.containsShortcutsTo.notEmpty»
		«generatedMemberComment»
		public static boolean isShortcutOrphaned(org.eclipse.gmf.runtime.notation.View view) {
			return !view.isSetElement() || view.getElement() == null || view.getElement().eIsProxy();
		}
		«ENDIF»
	'''

	protected def GenDiagramUpdater diagramUpdater(GenCommonBase base) {
		return base.diagram.editorGen.diagramUpdater
	}
	protected def nodeDescriptorQualifiedClassName(GenCommonBase it) '''«nodeDescriptor.qualifiedClassName(it.diagramUpdater)»'''
	protected def linkDescriptorQualifiedClassName(GenCommonBase it) '''«linkDescriptor.qualifiedClassName(it.diagramUpdater)»'''
	protected def dispatch CharSequence listOfNodeDescriptors(GenDiagramUpdater it) '''java.util.List<«nodeDescriptor.qualifiedClassName(it)»>'''
	protected def dispatch CharSequence listOfNodeDescriptors(GenCommonBase it) '''«listOfNodeDescriptors(it.diagramUpdater)»'''
	protected def dispatch CharSequence listOfLinkDescriptors(GenDiagramUpdater it) '''java.util.List<«linkDescriptor.qualifiedClassName(it)»>'''
	protected def dispatch CharSequence listOfLinkDescriptors(GenCommonBase it) '''«listOfLinkDescriptors(it.diagramUpdater)»'''
	protected def CharSequence newEmptyList() '''java.util.Collections.emptyList()'''
	protected def CharSequence newLinkedListOfNodeDescriptors(GenDiagramUpdater it, String varName) '''java.util.LinkedList<«nodeDescriptor.qualifiedClassName(it)»> result = new java.util.LinkedList<«it.nodeDescriptorQualifiedClassName»>'''
	protected def CharSequence newLinkedListOfLinkDescriptors(GenDiagramUpdater it, String varName) '''java.util.LinkedList<«linkDescriptor.qualifiedClassName(it)»> result = new java.util.LinkedList<«it.linkDescriptorQualifiedClassName»>'''
	protected def typeOfCrossReferenceMap() '''java.util.Map<org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>>'''

	def getGenericSemanticChildrenOfView(GenDiagramUpdater it, Iterable<GenContainerBase> semanticContainers) '''
	
		«generatedMemberComment»
	public static «listOfNodeDescriptors» getSemanticChildren(org.eclipse.gmf.runtime.notation.View view) {
		«IF semanticContainers.notEmpty»
		switch («xptVisualIDRegistry.getVisualIDMethodCall(editorGen.diagram)»(view)) {
			«FOR next : semanticContainers»
			«getSemanticChildrenCase(next)»
			«ENDFOR»
		}
		«ENDIF»
		return «newEmptyList()»;
	}
	'''

	def getSemanticChildrenCase(GenContainerBase it) '''
	«xptVisualIDRegistry.caseVisualID(it)»
		return «getSemanticChildrenMethodName(it)»(view);
	'''

	def getSemanticChildrenOfView(GenContainerBase it) '''
	
	«generatedMemberComment»
	public static «listOfNodeDescriptors» «getSemanticChildrenMethodName(it)»(org.eclipse.gmf.runtime.notation.View view) {
		«IF getSemanticChildrenChildFeatures(it).notEmpty || it.getPhantomNodes().notEmpty»
			«defineModelElement(it)»
			«newLinkedListOfNodeDescriptors(it.diagramUpdater, 'result')»();
			«/* childMetaFeature can be null here! */
			FOR childMetaFeature : getSemanticChildrenChildFeatures(it)»
			«IF null == childMetaFeature»
				{ 	/*FIXME no containment/child feature found in the genmodel, toolsmith need to specify Class here manually*/ childElement = 
					/*FIXME no containment/child feature found in the genmodel, toolsmith need to specify correct one here manually*/;
			«ELSEIF childMetaFeature.listType»
				for (java.util.Iterator<?> it = «xptMetaModel.getFeatureValue(childMetaFeature, 'modelElement', it.getModelElementType())».iterator(); it.hasNext();) {
				«xptMetaModel.DeclareAndAssign(childMetaFeature.typeGenClass, 'childElement', 'it.next()', true)»
			«ELSE»
				{ «xptMetaModel.DeclareAndAssign(childMetaFeature.typeGenClass, 'childElement', 'modelElement', it.getModelElementType(), childMetaFeature)»
			«ENDIF»
				int visualID = «xptVisualIDRegistry.getNodeVisualIDMethodCall(it.diagram)»(view, «xptMetaModel.DowncastToEObject(childMetaFeature.typeGenClass, 'childElement')»);
				«FOR next : getSemanticChildren(it, childMetaFeature)»
					«checkChildElementVisualID(next, null != childMetaFeature && childMetaFeature.listType)»
				«ENDFOR»
				}
			«ENDFOR»
			«IF it.getPhantomNodes.notEmpty»
				org.eclipse.emf.ecore.resource.Resource resource = modelElement.eResource();
				for (java.util.Iterator<org.eclipse.emf.ecore.EObject> it = getPhantomNodesIterator(resource); it.hasNext();) {
					org.eclipse.emf.ecore.EObject childElement = it.next();
					if (childElement == modelElement) {
						continue;
					}
					«FOR phantom : it.phantomNodes»
					«addNextIfPhantom(phantom)»
					«ENDFOR»
				}
			«ENDIF»		
			return result;
		«ELSE»
			return «newEmptyList()»;
		«ENDIF»
	}
	'''

	def dispatch defineModelElement(GenContainerBase it) '''
	if (!view.isSetElement()) {
		return «newEmptyList()»;
	}
	«xptMetaModel.DeclareAndAssign(it.getModelElementType(), 'modelElement', 'view.getElement()')»
	'''

	def dispatch defineModelElement(GenCompartment it) '''
	if (false == view.eContainer() instanceof org.eclipse.gmf.runtime.notation.View) {
		return «newEmptyList()»;
	}
	org.eclipse.gmf.runtime.notation.View containerView = (org.eclipse.gmf.runtime.notation.View) view.eContainer();
	if (!containerView.isSetElement()) {
		return «newEmptyList()»;
	}
	«xptMetaModel.DeclareAndAssign(it.getModelElementType(), 'modelElement', 'containerView.getElement()')»
	'''


	/**
	 * XXX: [MG] suspicious code inside, EVEN after I moved ", " into the IF, there still may be problem if inner IF condition is not met.
	 * Need to check with case when it.modelFacet.childMetaFeature == null    
	 */
	def checkChildElementVisualID(GenNode it, Boolean inLoop) '''
	if (visualID == «VisualIDRegistry::visualID(it)») {
		result.add(new «nodeDescriptor.qualifiedClassName(it.getDiagram().diagramUpdater)»(«IF null != modelFacet.childMetaFeature»«xptMetaModel.DowncastToEObject(modelFacet.childMetaFeature.typeGenClass, 'childElement')», «ENDIF»visualID));
	«IF inLoop»
		continue;
	«ENDIF»
	}
	'''

	def addNextIfPhantom(GenNode it) '''
	if («xptVisualIDRegistry.getNodeVisualIDMethodCall(it.diagram)»(view, childElement) == «VisualIDRegistry::visualID(it)») {
		result.add(new «nodeDescriptor.qualifiedClassName(it.getDiagram().diagramUpdater)»(childElement, «VisualIDRegistry::visualID(it)»));
		continue;
	}
	'''


	def getPhantomNodesIterator(GenDiagramUpdater it) '''
	«IF editorGen.diagram.hasPhantomNodes»
	
	«generatedMemberComment»
	private static java.util.Iterator<org.eclipse.emf.ecore.EObject> getPhantomNodesIterator(org.eclipse.emf.ecore.resource.Resource resource) {
		return resource.getAllContents();
	}
	«ENDIF»
	'''

	def getGenericConnectedLinks(GenDiagramUpdater it, Iterable<? extends GenCommonBase> linkContainers, UpdaterLinkType linkType) '''
	«generatedMemberComment»
	public static «listOfLinkDescriptors» get«linkType.linkMethodSuffix»Links(org.eclipse.gmf.runtime.notation.View view) {
		«IF linkContainers.notEmpty»
		switch («xptVisualIDRegistry.getVisualIDMethodCall(it.editorGen.diagram)»(view)) {
			«FOR next : linkContainers»
			«getContainedLinksCase(next, linkType)»
			«ENDFOR»
		}
		«ENDIF»
		return «newEmptyList»;
	}
	'''

	def getContainedLinksCase(GenCommonBase it, UpdaterLinkType linkType) '''
	«xptVisualIDRegistry.caseVisualID(it)»
		return «linkGetterName(linkType)»(view);
	'''

	def dispatch getContainedLinks(GenCommonBase it) '''
		«getConnectedLinks(it, computeContainedLinks(it.metaClass, diagram), UpdaterLinkType::CONTAINED, false)»
	'''
	
	def dispatch getContainedLinks(GenLink it) '''
		«getConnectedLinks(it, computeContainedLinks(it.metaClass, diagram), UpdaterLinkType::CONTAINED, false)»
	'''
	
	def getIncomingLinks(GenLinkEnd it) '''
		«getConnectedLinks(it, computeIncomingLinks(it), UpdaterLinkType::INCOMING, true)»
	'''
	
	def getOutgoingLinks(GenLinkEnd it) '''
		«getConnectedLinks(it, computeOutgoingLinks(it), UpdaterLinkType::OUTGOING, false)»
	'''

	def getConnectedLinks(GenCommonBase it, Iterable<GenLink> genLinks, UpdaterLinkType linkType, boolean needCrossReferencer) '''

	«generatedMemberComment»
	public static «listOfLinkDescriptors(it)» «linkGetterName(it, linkType)»(org.eclipse.gmf.runtime.notation.View view) {
	«IF genLinks.notEmpty»
		«xptMetaModel.DeclareAndAssign(it.metaClass, 'modelElement', 'view.getElement()')»
		«IF needCrossReferencer»
			«typeOfCrossReferenceMap» crossReferences = org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		«ENDIF»
		«newLinkedListOfLinkDescriptors(it.diagramUpdater, 'result')»();
		«FOR link : genLinks»
			«colectConnectedLinks(link, linkType, needCrossReferencer, isExternalInterface(it.metaClass))»
		«ENDFOR»
		return result;
	«ELSE»
		return «newEmptyList()»;
	«ENDIF»
	}
	'''

	def colectConnectedLinks(GenLink it, UpdaterLinkType linkType, boolean needCrossReferencer, boolean isExternalInterface) '''
	«IF it.modelFacet != null»
		«IF isExternalInterface && !it.modelFacet.oclIsKindOf(typeof(FeatureLinkModelFacet))»
			if («xptMetaModel.IsInstance(it.modelFacet.getLinkEndType(linkType), 'modelElement')») {
		«ENDIF»
			result.addAll(«chooseConnectedLinksByTypeMethodName(it.modelFacet, linkType, it)»(« //
				IF isExternalInterface && !it.modelFacet.oclIsKindOf(typeof(FeatureLinkModelFacet))»«xptMetaModel.CastEObject(it.modelFacet.getLinkEndType(linkType), 'modelElement')»«ELSE»modelElement«ENDIF»«IF needCrossReferencer», crossReferences«ENDIF»));	
		«IF isExternalInterface && !it.modelFacet.oclIsKindOf(typeof(FeatureLinkModelFacet))»
			}
		«ENDIF»
	«ENDIF»
	'''

	def dispatch chooseConnectedLinksByTypeMethodName(LinkModelFacet it, UpdaterLinkType type, GenLink genLink) '''«incorrectLinkModelFacet(it)»'''

	/**
	 *	For FeatureModelFacet-based links we are calling getOutgoing???Links instead of getContained???Links
	 */
	def dispatch chooseConnectedLinksByTypeMethodName(FeatureLinkModelFacet it, UpdaterLinkType type, GenLink genLink) '''
	«IF type == UpdaterLinkType::CONTAINED»
		«getConnectedLinksByTypeMethodName(genLink, UpdaterLinkType::OUTGOING)»
	«ELSE»
		«getConnectedLinksByTypeMethodName(genLink, type)»
	«ENDIF»
	'''

	/**
	 * For TypeModelFacet-based links without specified sourceMetaFeature, we are calling getContained???Links instead of getOutgoinf???Links
	 */
	def dispatch chooseConnectedLinksByTypeMethodName(TypeLinkModelFacet it, UpdaterLinkType type, GenLink genLink) '''
	«IF type == UpdaterLinkType::OUTGOING && sourceMetaFeature == null»
		«getConnectedLinksByTypeMethodName(genLink, UpdaterLinkType::CONTAINED)»
	«ELSE»
		«getConnectedLinksByTypeMethodName(genLink, type)»
	«ENDIF»
	'''

	def getContainedLinksByTypeMethod(GenLink it) '''«getContainedLinksByTypeMethod(it.modelFacet, it)»'''
	
	def getConnectedLinksByTypeMethodName(GenLink it, UpdaterLinkType linkType) '''get«linkType.linkMethodSuffix»«getConnectedLinksByTypeMethodFragment(modelFacet)»_«visualID»'''
	
	def dispatch getConnectedLinksByTypeMethodFragment(TypeLinkModelFacet it) '''TypeModelFacetLinks_«metaClass.ecoreClass.name»'''
	
	def dispatch getConnectedLinksByTypeMethodFragment(FeatureLinkModelFacet it) '''FeatureModelFacetLinks_«metaFeature.genClass.ecoreClass.name»_«metaFeature.ecoreFeature.name.toFirstUpper()»'''
	
	def dispatch getConnectedLinksByTypeMethodFragment(LinkModelFacet it) '''«incorrectLinkModelFacet(it)»'''
	
	def dispatch getContainedLinksByTypeMethod(LinkModelFacet it, GenLink genLink) '''«incorrectLinkModelFacet(it)»'''
	
	def dispatch getContainedLinksByTypeMethod(FeatureLinkModelFacet it, GenLink genLink) ''''''
	
	def dispatch getContainedLinksByTypeMethod(TypeLinkModelFacet it, GenLink genLink) '''

	«generatedMemberComment»
	private static java.util.Collection<«linkDescriptor.qualifiedClassName(genLink.diagramUpdater)»> «getConnectedLinksByTypeMethodName(genLink, UpdaterLinkType::CONTAINED)»(«xptMetaModel.QualifiedClassName(childMetaFeature.genClass)» container) {
		«getContainedLinksByTypeMethodBody(it, genLink, false)»
	}
	'''

	def getContainedLinksByTypeMethodBody(TypeLinkModelFacet it, GenLink genLink, boolean sourceVarDefined) '''
		«newLinkedListOfLinkDescriptors(genLink.diagramUpdater, 'result')»();
		«var inLoop = childMetaFeature.listType»
		«IF inLoop»
		for (java.util.Iterator<?> links = «xptMetaModel.getFeatureValue(childMetaFeature, 'container', childMetaFeature.genClass)».iterator(); links.hasNext();) {
			org.eclipse.emf.ecore.EObject linkObject = (org.eclipse.emf.ecore.EObject ) links.next();
			if («xptMetaModel.NotInstance(metaClass, 'linkObject')») {
				continue;
			}
			«xptMetaModel.DeclareAndAssign(metaClass, 'link', 'linkObject')»
		«ELSE»
			«IF childMetaFeature.typeGenClass == metaClass»
				«xptMetaModel.DeclareAndAssign(metaClass, 'link', 'container', it.sourceType, childMetaFeature)»
			«ELSE»
				«xptMetaModel.DeclareAndAssign(childMetaFeature.typeGenClass, 'linkObject', 'container', it.sourceType, childMetaFeature)»
				if («xptMetaModel.NotInstance(metaClass, 'linkObject')») {
					return result;
				}
				«xptMetaModel.DeclareAndAssign(metaClass, 'link', 'linkObject')»
			«ENDIF»
		«ENDIF»
		«checkLinkVisualID(it, genLink, inLoop)»
		«defineLinkDestination(it, inLoop)»
		«IF null != sourceMetaFeature»
			«defineLinkSource(it, inLoop)»
			«IF sourceVarDefined»
				«checkLinkSource(it, inLoop)»
			«ENDIF»
			«addLinkDescriptor(it, genLink, 'src', 'dst')»
		«ELSE»
			«addLinkDescriptor(it, genLink, 'container', 'dst')»
		«ENDIF»
		«IF inLoop»
		}
		«ENDIF»
		return result;	
	'''

	def addLinkDescriptor(TypeLinkModelFacet it, GenLink genLink, String srcVar, String dstVar) '''
	result.add(new «linkDescriptor.qualifiedClassName(genLink.diagramUpdater)»(«//
		xptMetaModel.DowncastToEObject(it.sourceType, srcVar)», «//
		xptMetaModel.DowncastToEObject(it.targetType, dstVar)», «//
		xptMetaModel.DowncastToEObject(metaClass, 'link')», «//
		xptElementTypes.accessElementType(genLink)», «VisualIDRegistry::visualID(genLink)»));
	'''

	def checkLinkVisualID(TypeLinkModelFacet it, GenLink genLink, boolean inLoop) '''
	if («VisualIDRegistry::visualID(genLink)» != «xptVisualIDRegistry.getLinkWithClassVisualIDMethodCall(genLink.diagram)»(«xptMetaModel.DowncastToEObject(metaClass, 'link')»)) {
		«stopLinkProcessing(inLoop)»
	}
	'''

	def defineLinkSource(TypeLinkModelFacet it, boolean inLoop) '''
		«IF sourceMetaFeature.listType»
		java.util.List sources = «xptMetaModel.getFeatureValue(sourceMetaFeature, 'link', metaClass)»;
		Object theSource = sources.size() == 1 ? sources.get(0) : null;
		if («xptMetaModel.NotInstance(it.sourceType, 'theSource')») {
			«stopLinkProcessing(inLoop)»
		}
		«xptMetaModel.DeclareAndAssign(it.sourceType, 'src', 'theSource', true)»
		«ELSE»
		«xptMetaModel.DeclareAndAssign(it.sourceType, 'src', 'link', metaClass, sourceMetaFeature)»
		«ENDIF»
	'''

	def checkLinkSource(TypeLinkModelFacet it, boolean inLoop) '''
	if (src != source) {
		«stopLinkProcessing(inLoop)»
	}
	'''

	def defineLinkDestination(TypeLinkModelFacet it, Boolean inLoop) '''
		«IF targetMetaFeature.listType»
		java.util.List targets = «xptMetaModel.getFeatureValue(it.targetMetaFeature, 'link', metaClass)»;
		Object theTarget = targets.size() == 1 ? targets.get(0) : null;
		if («xptMetaModel.NotInstance(it.targetType, 'theTarget')») {
			«stopLinkProcessing(inLoop)»
		}
		«xptMetaModel.DeclareAndAssign(it.targetType, 'dst', 'theTarget', true)»
		«ELSE»
		«xptMetaModel.DeclareAndAssign(it.targetType, 'dst', 'link', metaClass, targetMetaFeature)»
		«ENDIF»
	'''

	def stopLinkProcessing(boolean inLoop) '''
	«IF inLoop»
		continue;
	«ELSE»
		return result;
	«ENDIF»
	'''

	def getIncomingLinksByTypeMethod(GenLink it) '''
	
	«generatedMemberComment»
	private static java.util.Collection<«linkDescriptor.qualifiedClassName(it.diagramUpdater)»> «getConnectedLinksByTypeMethodName(UpdaterLinkType::INCOMING)»(«xptMetaModel.QualifiedClassName(it.modelFacet.targetType)» target, «typeOfCrossReferenceMap» crossReferences) {
		«newLinkedListOfLinkDescriptors(it.diagramUpdater, 'result')»();
		java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (org.eclipse.emf.ecore.EStructuralFeature.Setting setting : settings) {
			«getIncomingLinksByTypeMethodBody(it.modelFacet, it)»
		}
		return result;	
	}
	'''

	def dispatch getIncomingLinksByTypeMethodBody(TypeLinkModelFacet it, GenLink genLink) '''
	if (setting.getEStructuralFeature() != «xptMetaModel.MetaFeature(targetMetaFeature)» || «xptMetaModel.NotInstance(metaClass, 'setting.getEObject()')») {
		continue;
	}
	«xptMetaModel.DeclareAndAssign(metaClass, 'link', 'setting.getEObject()')»
		«checkLinkVisualID(it, genLink, true)»
		«IF null != sourceMetaFeature»
			«defineLinkSource(it, true)»
			«addLinkDescriptor(it, genLink, 'src', 'target')»
		«ELSE»
			«defineLinkContainer(it, true)»
			«addLinkDescriptor(it, genLink, 'container', 'target')»
			«extraLineBreak»
			«/*TODO: continue here.*/ //
		ENDIF»
	'''

	def defineLinkContainer(TypeLinkModelFacet it, boolean inLoop) '''
	if (false == «xptMetaModel.IsContainerInstance(containmentMetaFeature.genClass, 'link', metaClass)») {
		«stopLinkProcessing(inLoop)»
	}
	«xptMetaModel.DeclareAndAssignContainer(containmentMetaFeature.genClass, 'container', 'link', metaClass)»
	'''

	def dispatch getIncomingLinksByTypeMethodBody(FeatureLinkModelFacet it, GenLink genLink) '''
	if (setting.getEStructuralFeature() == «xptMetaModel.MetaFeature(it.metaFeature)») {
		result.add(new «linkDescriptor.qualifiedClassName(genLink.diagramUpdater)»(setting.getEObject(), « //
			xptMetaModel.DowncastToEObject(it.targetType, 'target')», « //
			xptElementTypes.accessElementType(genLink)», « //
			VisualIDRegistry::visualID(genLink)»));
	}
	'''

	def dispatch getIncomingLinksByTypeMethodBody(LinkModelFacet it, GenLink genLink) '''«incorrectLinkModelFacet(it)»'''

	def getOutgoingLinksByTypeMethod(GenLink it) '''
		«getOutgoingLinksByTypeMethod(it.modelFacet, it)»
	'''

	def getOutgoingLinksByTypeMethodSignature(GenLink it) //
	'''private static java.util.Collection<«linkDescriptor.qualifiedClassName(it.diagramUpdater)»> «getConnectedLinksByTypeMethodName(UpdaterLinkType::OUTGOING)»(«xptMetaModel.QualifiedClassName(it.modelFacet.sourceType)» source)'''

	def dispatch getOutgoingLinksByTypeMethod(FeatureLinkModelFacet it, GenLink genLink) '''
		«generatedMemberComment»
		«getOutgoingLinksByTypeMethodSignature(genLink)» {
			«newLinkedListOfLinkDescriptors(genLink.diagramUpdater, 'result')»();
			«IF it.metaFeature.listType»
			for (java.util.Iterator<?> destinations = «xptMetaModel.getFeatureValue(it.metaFeature, 'source', it.sourceType)».iterator(); destinations.hasNext();) {
				«xptMetaModel.DeclareAndAssign(it.targetType, 'destination', 'destinations.next()', true)»
			«ELSE»
			«xptMetaModel.DeclareAndAssign(it.targetType, 'destination', 'source', sourceType, metaFeature)»
			if (destination == null) {
				return result;
			}
			«ENDIF»
			result.add(new «linkDescriptor.qualifiedClassName(genLink.diagramUpdater)»(«xptMetaModel.DowncastToEObject(sourceType, 'source')», «xptMetaModel.DowncastToEObject(targetType, 'destination')», «xptElementTypes.accessElementType(genLink)», «VisualIDRegistry::visualID(genLink)»));
			«IF metaFeature.listType»
			}
			«ENDIF»
			return result;
		}
	'''

	/**
	 * More careful way to find container should be used here then GMF will be modified in accordance
	 */
	def dispatch getOutgoingLinksByTypeMethod(TypeLinkModelFacet it, GenLink genLink) '''
		«IF null != sourceMetaFeature»
		«generatedMemberComment»
		«getOutgoingLinksByTypeMethodSignature(genLink)» {
			«xptMetaModel.QualifiedClassName(containmentMetaFeature.genClass)» container = null;
			// Find container element for the link.
			// Climb up by containment hierarchy starting from the source
			// and return the first element that is instance of the container class.
			for (org.eclipse.emf.ecore.EObject element = «xptMetaModel.DowncastToEObject(sourceType, 'source')»; element != null && container == null; element = element.eContainer()) {
				if («xptMetaModel.IsInstance(containmentMetaFeature.genClass, 'element')») {
					container = «xptMetaModel.CastEObject(containmentMetaFeature.genClass, 'element')»;
				}
			}
			if (container == null) {
				return «newEmptyList()»;
			}
			«getContainedLinksByTypeMethodBody(it, genLink, true)»
		}		
		«ENDIF»
	'''

	def dispatch getOutgoingLinksByTypeMethod(LinkModelFacet it, GenLink genLink) '''«incorrectLinkModelFacet(it)»'''

	def incorrectLinkModelFacet(LinkModelFacet it) '''«ERROR('Incorrect LinkModelFacet: ' + it)»'''

	def runtimeTypedInstance(GenDiagramUpdater it) '''
		«generatedMemberComment»
		public static final org.eclipse.gmf.tooling.runtime.update.DiagramUpdater «runtimeTypedInstanceName(it)» = new org.eclipse.gmf.tooling.runtime.update.DiagramUpdater() {
			«generatedMemberComment»
			«xptCodeStyle.overrideI(it.editorGen.diagram)»
			public java.util.List<«nodeDescriptor.qualifiedClassName(it)»> getSemanticChildren(org.eclipse.gmf.runtime.notation.View view) {
				return «className(it)».getSemanticChildren(view);
			}
			
			«generatedMemberComment»
			«xptCodeStyle.overrideI(it.editorGen.diagram)»
			public java.util.List<«linkDescriptor.qualifiedClassName(it)»> getContainedLinks(org.eclipse.gmf.runtime.notation.View view) {
				return «className(it)».getContainedLinks(view);
			}
			
			«generatedMemberComment»
			«xptCodeStyle.overrideI(it.editorGen.diagram)»
			public java.util.List<«linkDescriptor.qualifiedClassName(it)»> getIncomingLinks(org.eclipse.gmf.runtime.notation.View view) {
				return «className(it)».getIncomingLinks(view);
			}
			
			«generatedMemberComment»
			«xptCodeStyle.overrideI(it.editorGen.diagram)»
			public java.util.List<«linkDescriptor.qualifiedClassName(it)»> getOutgoingLinks(org.eclipse.gmf.runtime.notation.View view) {
				return «className(it)».getOutgoingLinks(view);
			}
		}; 
	'''

	def additions(GenDiagramUpdater it) ''''''
}