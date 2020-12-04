/*****************************************************************************
 * Copyright (c) 2017 CEA LIST, ALL4TEC and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * CEA LIST - initial API and implementation
 * Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Bug 510587: the palette must not be generated by using GMF gen
 * 
 *****************************************************************************/
package aspects.xpt.plugin

import aspects.xpt.Common
import aspects.xpt.editor.palette.Utils_qvto
import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.Iterator
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.papyrus.gmf.codegen.gmfgen.AbstractToolEntry
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenEditorGenerator
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenExternalNodeLabel
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenLink
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenLinkLabel
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenPlugin
import org.eclipse.papyrus.gmf.codegen.gmfgen.ToolEntry
import org.eclipse.papyrus.gmf.codegen.gmfgen.ToolGroup
import org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView
import org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference
import xpt.editor.extensions
import xpt.plugin.pluginUtils
import java.io.File

@Singleton class plugin extends xpt.plugin.plugin {

	@Inject extension Common
	@Inject extension pluginUtils
	@Inject extension Utils_qvto

	@Inject extensions xptEditorExtension
	@Inject xpt.diagram.preferences.extensions xptPreferencesExtension
	@Inject xpt.propsheet.extensions xptPropsheetExtension
	@Inject xpt.navigator.extensions xptNavigatorExtension
	@Inject xpt.application.extensions xptApplicationExtension
	@Inject xpt.diagram.updater.extensions xptUpdaterExtension
	@Inject impl.actions.extensions xptActionExtension
	@Inject xpt.providers.extensions xptProvidersExtension

	override plugin(GenPlugin it) '''
		<?xml version="1.0" encoding="UTF-8"?>
		<?eclipse version="3.0"?>
		«xcopyright(it.editorGen)»
		<plugin>
		««««fileTypes()»
		««««extension_parser()»
		«xptEditorExtension.extensions(it.editorGen)»
		«««global actions handled in the diagram.common plugin
		««««pluginMenu()»
		«validation(it.editorGen.diagram)»
		«IF it.editorGen.metrics != null»«metrics(it.editorGen.metrics)»«ENDIF»
		«««RS: redefine palette generation
«««		«palettePredefinedEntries(editorGen)»
«««		«paletteEntries(editorGen)»
		«xptPreferencesExtension.extensions(it.editorGen.diagram)»
		«IF it.editorGen.propertySheet != null»«xptPropsheetExtension.extensions(it.editorGen.propertySheet)»«ENDIF»
		«xptProvidersExtension.extensions(it.editorGen.diagram)»
		«IF it.editorGen.navigator != null»«xptNavigatorExtension.extensions(it.editorGen.navigator)»«ENDIF»
		«IF it.editorGen.application != null»«xptApplicationExtension.extensions(it.editorGen.application)»«ENDIF»
		«extensionsConstraintProviders(it.editorGen)»
		«xptUpdaterExtension.extensions(it.editorGen.diagramUpdater)»
		«xptActionExtension.Main(it.editorGen)»
		«additions(it)»
		«notationTypesMap(editorGen)»
«««		«paletteConfiguration(editorGen)»
		</plugin>
	'''
	
	
	/**
	 * deprecated: palette configuration are now declared through architecture model.
	 */
	def paletteConfiguration(GenEditorGenerator it) '''
<extension point="org.eclipse.papyrus.infra.gmfdiag.common.paletteDefinition">
	«xmlGeneratedTag»
	<paletteDefinition
		ID="«plugin.ID».paletteconfiguration"
		class="org.eclipse.papyrus.infra.gmfdiag.common.service.palette.ExtendedPluginPaletteProvider"
		name="«plugin.name» Palette"
		path="«relativePath»/«modelID».paletteconfiguration"
		provider="Eclipse Modeling Project">
		<Priority
			name="Lowest">
		</Priority>
		<!-- Specify diagram to which this palette tool relates -->
		<editor
			id="«plugin.ID»">
		</editor>
	</paletteDefinition>
</extension>
	'''

	override additions(GenPlugin it) ''''''

	//	def category(GenDiagram it) '''«getDiagramPreferencePageCategory()».«editorGen.modelID»'''

	//RS: redefine palette generation, using predefined entries
	def palettePredefinedEntries(GenEditorGenerator it) '''
		«xmlGeneratedTag»
		<extension
			id="«plugin.name».palettedefinition"
			name="«plugin.name» Predefined Entries"
			point="org.eclipse.gmf.runtime.diagram.ui.paletteProviders"> 
			
			«xmlGeneratedTag»	
			<paletteProvider class="org.eclipse.gmf.runtime.diagram.ui.providers.DefaultPaletteProvider">
				<Priority name="Lowest"/>
				   		<contribution
				   		    	factoryClass="«it.diagram.palette.packageName».«it.diagram.palette.factoryClassName»">
				   		<predefinedEntry id="standardGroup/noteStack/noteTool" remove="true"/> 
				<predefinedEntry id="standardGroup/noteStack/textTool" remove="true"/> 
				<predefinedEntry id="standardGroup/noteStack/noteattachmentTool" remove="true"/>
				
				«FOR tool : collectTools(diagram.palette)»
					«predefinedEntryDefinition(tool)»
				«ENDFOR»
				
				</contribution>
			</paletteProvider>	
				
		</extension>
	'''

	//RS: redefine palette generation, using predefined entries
	def paletteEntries(GenEditorGenerator it) '''
		«xmlGeneratedTag»
		<extension
			id="«plugin.name».standard"
			name="«plugin.name» Standard Palette"
			point="org.eclipse.gmf.runtime.diagram.ui.paletteProviders"> 
			
			«xmlGeneratedTag»	
			<paletteProvider class="org.eclipse.gmf.runtime.diagram.ui.providers.DefaultPaletteProvider">
				<Priority name="Low"/>
				   		<contribution
				   		    	factoryClass="«it.diagram.palette.packageName».«it.diagram.palette.factoryClassName»">
				   		<predefinedEntry id="standardGroup/noteStack/noteTool" remove="true"/> 
				<predefinedEntry id="standardGroup/noteStack/textTool" remove="true"/> 
				<predefinedEntry id="standardGroup/noteStack/noteattachmentTool" remove="true"/>
				
				«FOR tool : diagram.palette.groups»
					«groupUsage(tool)»
				«ENDFOR»
				</contribution>
				<editor id="«plugin.ID»"/>
			</paletteProvider>	
				
		</extension>
	'''

	def groupUsage(ToolGroup it) '''
		<entry
		      description="«it.description»"
		      id=«IF isQuoted(id,'"')»«id»«ELSE»"«id»"«ENDIF»
		      kind="«IF it.stack && it.toolsOnly»stack«ELSE»drawer«ENDIF»"
		      label="«it.title»"
		      large_icon="«largeIconPath»"
		      path="«getPath(it)»"
		      small_icon="«smallIconPath»">
		   <expand
		         force="true">
		   </expand>
		</entry>
		««« TODO: call sub entries... 
		«FOR entry : it.entries.filter[e| e instanceof ToolEntry]»
			«toolUsage(entry, it)»
		«ENDFOR»
		«FOR entry : it.entries.filter[e| e instanceof ToolGroup]»
			«toolUsage(entry, it)»
		«ENDFOR»
	'''

	private def getPath(ToolEntry it) {
		return buildPath(it.eContainer);
	}

	private def getPath(ToolGroup it) {
		return buildPath(it.eContainer);
	}

	private def buildPath(EObject it) {
		var path = new StringBuilder();
		var container = it;
		while (container instanceof ToolGroup) {
			path.insert(0, getToolPath((container as ToolGroup).id));
			container = container.eContainer;
		}
		return if(path.length() != 0) path.toString else "/" ;
	}
	
	def dispatch toolUsage(ToolEntry it, ToolGroup group) '''
 		<predefinedEntry
 		        id=«IF isQuoted(id,'"')»«id»«ELSE»"«id»"«ENDIF»
 				path="«getPath(it)»">
 		  </predefinedEntry>
 	'''

	def dispatch toolUsage(ToolGroup it, ToolGroup group) '''
		«groupUsage(it)»
	'''

	def predefinedEntryDefinition(AbstractToolEntry it) '''
		<entry
		      defineOnly="true"
		      description="«it.description»"
		      id=«IF isQuoted(id,'"')»«id»«ELSE»"«id»"«ENDIF»
		      kind="tool"
		      label="«it.title»"
		      large_icon="«largeIconPath»"
		      path=""
		      small_icon="«smallIconPath»">
		</entry>
	'''
	
	//	set notation type mapping extension point
	def notationTypesMap(GenEditorGenerator it) '''	
«tripleSpace(0)»<extension point="org.eclipse.papyrus.infra.gmfdiag.common.notationTypesMapping"> 
«tripleSpace(1)»«xmlGeneratedTag»
«tripleSpace(1)»<diagramMappings diagramID="«modelID»">
«tripleSpace(1)»	<mapping type="«modelID»" humanReadableType="«modelID.replaceAll('Papyrus|UML|Diagram', '')»Diagram"/>
			«FOR compartment : diagram.compartments»
				«compartmentToTypeMap(compartment)»
			«ENDFOR»
			«FOR link : diagram.links»
				«linksToTypeMap(link)»
			«ENDFOR»
			«FOR externalLabel : diagram.eResource.allContents.filter(typeof (GenExternalNodeLabel)).toIterable»
				«floatingLabelToTypeMap(externalLabel)»
				«externalNodeLabelToTypeMap(externalLabel)»
			«ENDFOR»
«tripleSpace(1)»</diagramMappings>
«tripleSpace(0)»</extension>
	'''
	def compartmentToTypeMap(GenCompartment it) '''
		<mapping
			humanReadableType="«title.replaceAll('Compartment', '')»"
			type="«stringVisualID»">
		</mapping>
	'''

	def linksToTypeMap(GenLink it) '''
		«FOR label : labels»
			«linkLabelToTypeMap(label)»
		«ENDFOR»
	'''
	
	def linkLabelToTypeMap(GenLinkLabel it)'''
	«««	it is used on a LabelVisibilityPreference...
		«LabelVisibilityPreferenceToTypeMap(it.eResource.allContents.filter(typeof (LabelVisibilityPreference)).filter[v | v.linkLabels != null && v.linkLabels.contains(it) && v.role != null], stringVisualID)»	
	'''
	
	def externalNodeLabelToTypeMap(GenExternalNodeLabel it)'''
		«LabelVisibilityPreferenceToTypeMap(it.eResource.allContents.filter(typeof (LabelVisibilityPreference)).filter[v | v.externalNodeLabels != null && v.externalNodeLabels.contains(it) && v.role != null],stringVisualID)»	
	'''
	
	def LabelVisibilityPreferenceToTypeMap(Iterator<LabelVisibilityPreference> it, String visualID)'''
	«var List<LabelVisibilityPreference> links = it.toList»
	«IF links.size != 0»
		<mapping
			humanReadableType="«links.get(0).role»"
			type="«visualID»">
		</mapping>
	«ENDIF»	
	'''
		
	def floatingLabelToTypeMap(GenExternalNodeLabel it)'''
	«««	it is used on a ExtensionGenView...
	«IF it.eResource.allContents.filter(typeof (ExtendedGenView)).filter[v | v.genView.contains(it) && v.superOwnedEditPart != null].size != 0»
	«FOR extendedObject : it.eResource.allContents.filter(typeof (ExtendedGenView)).filter[v|v.genView.contains(it) && v.superOwnedEditPart != null].toIterable»
				«««...to be extended as floatingLabel			
				«IF "FloatingLabelEditPart".equals(extendedObject.name) »
					<mapping
						humanReadableType="Floating Label"
						type="«stringVisualID»">
					</mapping>
				«ENDIF»
	«ENDFOR»
	«ENDIF»	
	'''
}
