/*****************************************************************************
 * Copyright (c) 2007, 2010, 2013, 2017 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Dmitry Stadnik (Borland) - initial API and implementation
 * Michael Golubev (Montages) - #386838 - migrate to Xtend2
 * Vincent Lorenzo (CEA-LIST) - Bug 520882
 * 
 *****************************************************************************/
package aspects.xpt.providers

import aspects.xpt.Common
import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.MetamodelType
import org.eclipse.gmf.codegen.gmfgen.NotationType
import org.eclipse.gmf.codegen.gmfgen.SpecializationType
import parsers.ParserProvider
import xpt.diagram.Utils_qvto
import xpt.diagram.edithelpers.EditHelper
import xpt.diagram.edithelpers.EditHelperAdvice
import xpt.providers.ShortcutsDecoratorProvider

@Singleton class extensions extends xpt.providers.extensions {
	@Inject extension Common;
	@Inject extension Utils_qvto;

	@Inject ViewProvider viewProvider;
	@Inject xpt.providers.IconProvider iconProvider;
	@Inject xpt.providers.EditPartProvider editPartProvider;
	@Inject ParserProvider labelParsers;
	@Inject ShortcutsDecoratorProvider shorcutProvider;
	@Inject VisualTypeProvider visualTypeProvider;
	@Inject EditHelper editHelper;
	@Inject EditHelperAdvice editHelperAdvice;
	
	override extensions(GenDiagram it) '''
		«extraLineBreak»
		«tripleSpace(1)»<extension point="org.eclipse.gmf.runtime.diagram.core.viewProviders" id="view-provider">
		«tripleSpace(2)»«xmlGeneratedTag»
		«tripleSpace(2)»<viewProvider class="«viewProvider.qualifiedClassName(it)»">
		«tripleSpace(3)»<Priority name="«notationViewProviderPriority»"/>
				«IF ! shortcutsProvidedFor.empty/*allow provider activation when another diagram tries to create a node, perhaps ours*/»
		«tripleSpace(3)»<object id="referencing-diagrams" class="org.eclipse.gmf.runtime.notation.Diagram">
		«tripleSpace(4)»<method name="getType()" value="«FOR s : shortcutsProvidedFor SEPARATOR ','»«s»«ENDFOR»"/>
		«tripleSpace(3)»</object>
		«tripleSpace(3)»<context viewClass="org.eclipse.gmf.runtime.notation.Node" containerViews="referencing-diagrams"/>
				«ENDIF»
		«tripleSpace(3)»<context viewClass="org.eclipse.gmf.runtime.notation.Diagram" semanticHints="«editorGen.modelID»"/>
		«tripleSpace(3)»<context viewClass="org.eclipse.gmf.runtime.notation.Node" semanticHints="«commaSeparatedVisualIDs(allNodes)»"/>
				«IF ! links.empty/*it is unlikely there would be a diagram without a node, but a diagram without links deemed possible */»
		«tripleSpace(3)»<context viewClass="org.eclipse.gmf.runtime.notation.Edge" semanticHints="«commaSeparatedVisualIDs(links)»"/>
				«ENDIF»
		«tripleSpace(2)»</viewProvider>
		«tripleSpace(1)»</extension>
		
		«tripleSpace(1)»<extension point="org.eclipse.gmf.runtime.diagram.ui.editpartProviders" id="ep-provider">
		«tripleSpace(2)»«xmlGeneratedTag»
		«tripleSpace(2)»<editpartProvider class="«editPartProvider.qualifiedClassName(it)»">
		«tripleSpace(3)»<Priority name="«editPartProviderPriority»"/>
		«tripleSpace(3)»<object class="org.eclipse.gmf.runtime.notation.Diagram" id="generated-diagram">
		«tripleSpace(4)»<method name="getType()" value="«editorGen.modelID»"/>
		«tripleSpace(3)»</object>
		«tripleSpace(3)»<object class="org.eclipse.gmf.runtime.notation.Node" id="generated-nodes">
		«tripleSpace(4)»<method name="getType()" value="«commaSeparatedVisualIDs(allNodes)»"/>
		«tripleSpace(3)»</object>
		«tripleSpace(3)»<object class="org.eclipse.gmf.runtime.notation.Edge" id="generated-links">
		«tripleSpace(4)»<method name="getType()" value="«commaSeparatedVisualIDs(links)»"/>
		«tripleSpace(3)»</object>
		«tripleSpace(3)»<object class="org.eclipse.gmf.runtime.notation.Node" id="generated-labels">
		«tripleSpace(4)»<method name="getType()" value="«commaSeparatedVisualIDs(allNodes.map[n|n.labels].flatten)»"/>
		«tripleSpace(3)»</object>
		«tripleSpace(3)»<object class="org.eclipse.gmf.runtime.notation.Node" id="generated-compartments">
		«tripleSpace(4)»<method name="getType()" value="«commaSeparatedVisualIDs(compartments)»"/>
		«tripleSpace(3)»</object>
		«tripleSpace(3)»<context views="generated-diagram,generated-nodes,generated-links,generated-labels,generated-compartments"/>
		«tripleSpace(2)»</editpartProvider>
		«tripleSpace(1)»</extension>
		
«««		«modelingAssistantProvider(it)»
		
		«tripleSpace(1)»<extension point="org.eclipse.gmf.runtime.common.ui.services.iconProviders" id="icon-provider">
		«tripleSpace(2)»«xmlGeneratedTag»
		«tripleSpace(2)»<IconProvider class="«iconProvider.qualifiedClassName(it)»">
		«tripleSpace(3)»<Priority name="«iconProviderPriority»"/>
		«tripleSpace(2)»</IconProvider>
		«tripleSpace(1)»</extension>
		«IF editorGen.labelParsers != null && editorGen.labelParsers.extensibleViaService»
		«extraLineBreak»
		«tripleSpace(1)»<extension point="org.eclipse.gmf.runtime.common.ui.services.parserProviders" id="parser-provider">
		«tripleSpace(2)»«xmlGeneratedTag»
		«tripleSpace(2)»<ParserProvider class="«labelParsers.qualifiedClassName(editorGen.labelParsers)»">
		«tripleSpace(3)»<Priority name="«editorGen.labelParsers.providerPriority»"/>
		«tripleSpace(2)»</ParserProvider>
		«tripleSpace(1)»</extension>
		«ENDIF»
		«IF generateShortcutIcon()»
		«extraLineBreak»
		«tripleSpace(1)»<extension point="org.eclipse.gmf.runtime.diagram.ui.decoratorProviders" id="decorator-provider">
		«tripleSpace(2)»«xmlGeneratedTag»
		«tripleSpace(2)»<decoratorProvider class="«shorcutProvider.qualifiedClassName(it)»">
		«tripleSpace(3)»<Priority name="«shortcutsDecoratorProviderPriority»"/>
		«tripleSpace(3)»<object class="org.eclipse.gmf.runtime.notation.Node(org.eclipse.gmf.runtime.notation)" id="generated-top-nodes">
		«tripleSpace(4)»<method name="getType()" value="«commaSeparatedVisualIDs(it.topLevelNodes)/*generated code supports shortcuts only to top-level nodes*/»"/>
		«tripleSpace(3)»</object>
		«tripleSpace(3)»<context decoratorTargets="generated-top-nodes"/>
		«tripleSpace(2)»</decoratorProvider>
		«tripleSpace(1)»</extension>
		«ENDIF»
	
«««		commented for bug 520882
«««		«IF !getLocalDefineTypedElements(it).empty»
«««		«tripleSpace(1)»<extension point="org.eclipse.gmf.runtime.emf.type.core.elementTypes" id="element-types">
«««		«tripleSpace(2)»«xmlGeneratedTag»
«««		«FOR e : getLocalDefineTypedElements(it)»
«««		«elementTypeSafe(e.elementType)»
«««			«ENDFOR»
«««		«tripleSpace(1)»</extension>
«««		«ENDIF»
«««		
«««		«tripleSpace(1)»<extension point="org.eclipse.gmf.runtime.emf.type.core.elementTypeBindings" id="element-types-bindings">
«««		«tripleSpace(2)»«xmlGeneratedTag»
«««		«IF it.eResource.allContents.filter(typeof (GenerateUsingElementTypeCreationCommand)).size<1»
«««			«tripleSpace(2)»<clientContext id="«editorGen.plugin.ID».TypeContext">
«««			«tripleSpace(3)»<enablement>
«««			«tripleSpace(4)»<test
«««			«tripleSpace(5)»property="org.eclipse.gmf.runtime.emf.core.editingDomain"
«««			«tripleSpace(5)»value="«editingDomainID»"/>
«««			«tripleSpace(3)»</enablement>
«««			«tripleSpace(2)»</clientContext> 
«««			«tripleSpace(2)»<binding context="«editorGen.plugin.ID».TypeContext">
«««		«ENDIF»
«««		«IF it.eResource.allContents.filter(typeof (GenerateUsingElementTypeCreationCommand)).size>0»
«««
«««        <binding context="org.eclipse.papyrus.infra.services.edit.TypeContext">
«««        «ENDIF»
«««		«FOR e : getLocalDefineTypedElements(it)»
«««		«tripleSpace(3)»<elementType ref="«e.elementType.uniqueIdentifier»"/>
«««				«ENDFOR»
«««		«tripleSpace(3)»<advice ref="org.eclipse.gmf.runtime.diagram.core.advice.notationDepdendents"/>
«««		«tripleSpace(2)»</binding>
«««		«tripleSpace(1)»</extension>

		«extraLineBreak»
		«tripleSpace(1)»<extension point="org.eclipse.papyrus.infra.gmfdiag.common.visualTypeProviders">
		«tripleSpace(2)»«xmlGeneratedTag»
		«tripleSpace(2)»<visualTypeProvider
		«tripleSpace(4)»class="«visualTypeProvider.qualifiedClassName(it)»"
		«tripleSpace(4)»diagramType="«editorGen.modelID»">
		«tripleSpace(3)»</visualTypeProvider>
		«tripleSpace(1)»</extension>
	'''

	def getLocalDefineTypedElements(GenDiagram it) {
		getAllTypedElements(it).filter[et| false == et.elementType.definedExternally]
	}
//	override modelingAssistantProvider(GenDiagram it) '''
//	
//	   <extension point="org.eclipse.gmf.runtime.emf.ui.modelingAssistantProviders" id="modelassist-provider">
//      «xmlGeneratedTag»
//	      <modelingAssistantProvider class="«getModelingAssistantProviderQualifiedClassName()»">
//	         <Priority name="«modelingAssistantProviderPriority»"/>
//	         <object class="«getEditPartQualifiedClassName()»" id="«getUniqueIdentifier()»"/>
//	«FOR n :topLevelNodes»
//	         <object class="«n.getEditPartQualifiedClassName()»" id="«n.getUniqueIdentifier()»"/>
//	«ENDFOR»
//	«FOR n:childNodes»
//	         <object class="«n.getEditPartQualifiedClassName()»" id="«n.getUniqueIdentifier()»"/>
//	«ENDFOR»
//	         <context elements="«getUniqueIdentifier()»,«FOR n : topLevelNodes SEPARATOR ','»«n.getUniqueIdentifier()»«ENDFOR»,«FOR n : childNodes SEPARATOR ','»«n.getUniqueIdentifier()»«ENDFOR»"/>
//	      </modelingAssistantProvider>
//	   </extension>
//	
//
//	'''

	override def commaSeparatedVisualIDs(Iterable<? extends GenCommonBase> list) '''«FOR gcb : list SEPARATOR ','»«gcb.stringUniqueIdentifier»«ENDFOR»'''

	override def dispatch elementType(MetamodelType it) '''
		«tripleSpace(2)»<metamodel nsURI="«getMetaClass().genPackage.getEcorePackage.nsURI»">
		«tripleSpace(3)»<metamodelType
		«tripleSpace(5)»id="«uniqueIdentifier»"
				«IF null != displayName»
		«tripleSpace(5)»name="%metatype.name.«diagramElement.stringUniqueIdentifier»"
				«ENDIF»
		«tripleSpace(5)»kind="org.eclipse.gmf.runtime.emf.type.core.IHintedType"
		«tripleSpace(5)»eclass="«getMetaClass().ecoreClass.name»"
		«tripleSpace(5)»edithelper="«editHelper.qualifiedClassName(it)»">
		«tripleSpace(4)»<param name="semanticHint" value="«diagramElement.stringVisualID»"/>
		«tripleSpace(3)»</metamodelType>
		«tripleSpace(2)»</metamodel>
	'''

	override def specializationType(SpecializationType it) '''
		«tripleSpace(3)»<specializationType
		«tripleSpace(5)»id="«uniqueIdentifier»"
			«IF null != displayName»
		«tripleSpace(5)»name="%metatype.name.«diagramElement.stringUniqueIdentifier»"
			«ENDIF»
		«tripleSpace(5)»kind="org.eclipse.gmf.runtime.emf.type.core.IHintedType"«IF editHelperAdviceClassName != null»
		«tripleSpace(5)»edithelperadvice="«editHelperAdvice.qualifiedClassName(it)»"«ENDIF»>
		«tripleSpace(4)»<specializes id="«IF (null == metamodelType)»org.eclipse.gmf.runtime.emf.type.core.null«ELSE»«metamodelType.
				uniqueIdentifier»«ENDIF»"/>
		«tripleSpace(4)»<param name="semanticHint" value="«diagramElement.stringVisualID»"/>
		«tripleSpace(3)»</specializationType>
	'''

	override def dispatch elementType(NotationType it) '''
		«tripleSpace(2)»<specializationType
		«tripleSpace(4)»id="«uniqueIdentifier»"
			«IF null != displayName»
		«tripleSpace(4)»name="%metatype.name.«diagramElement.stringUniqueIdentifier»"
			«ENDIF»
		«tripleSpace(4)»kind="org.eclipse.gmf.runtime.diagram.ui.util.INotationType">
		«tripleSpace(3)»<specializes id="org.eclipse.gmf.runtime.emf.type.core.null"/>
		«tripleSpace(3)»<param name="semanticHint" value="«diagramElement.stringVisualID»"/>
		«tripleSpace(2)»</specializationType>
	'''
}
