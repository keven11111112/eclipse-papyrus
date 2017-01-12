/**
 * Copyright (c) 2006, 2014 Borland Software Corporation, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *    Christian W. Damus - bug 451230
 *    Benoit Maggi (CEA LIST) -#510281 change dependency to replace gmft-runtime
 */
package aspects.xpt.providers

import aspects.xpt.CodeStyle
import aspects.xpt.Common
import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import xpt.diagram.Utils_qvto
import xpt.editor.VisualIDRegistry
import plugin.Activator

@Singleton class ElementTypes extends xpt.providers.ElementTypes {
	@Inject extension Common;
	@Inject extension Utils_qvto;

	@Inject CodeStyle xptCodeStyle;
	@Inject VisualIDRegistry xptVisualIDRegistry;

	@Inject Activator xptActivator;

	override def attributes(GenDiagram it) '''
		«generatedMemberComment»
		private static java.util.Map<org.eclipse.gmf.runtime.emf.type.core.IElementType, org.eclipse.emf.ecore.ENamedElement> elements;
		
		«generatedMemberComment»
		private static org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages elementTypeImages = new org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages(« //
		xptActivator.qualifiedClassName(editorGen.plugin)».getInstance().getItemProvidersAdapterFactory());
		
		«generatedMemberComment»
		private static java.util.Set<org.eclipse.gmf.runtime.emf.type.core.IElementType> KNOWN_ELEMENT_TYPES;
	'''

	override def getElement(GenDiagram it) '''
		«generatedMemberComment('Returns \'type\' of the ecore object associated with the hint.\n')»
		public static synchronized org.eclipse.emf.ecore.ENamedElement getElement(org.eclipse.core.runtime.IAdaptable hint) {
			Object type = hint.getAdapter(org.eclipse.gmf.runtime.emf.type.core.IElementType.class);
			if (elements == null) {
				elements = new java.util.IdentityHashMap<org.eclipse.gmf.runtime.emf.type.core.IElementType, org.eclipse.emf.ecore.ENamedElement>();
				«IF domainDiagramElement != null»«bindUniqueIdentifierToNamedElement(domainDiagramElement, stringUniqueIdentifier())»«ENDIF»
				«FOR node : getAllNodes()»
					«IF node.modelFacet != null»«bindUniqueIdentifierToNamedElement(node.modelFacet, node.stringUniqueIdentifier())»«ENDIF»
				«ENDFOR»
				«FOR link : it.links»
					«IF link.modelFacet != null»«bindUniqueIdentifierToNamedElement(link.modelFacet, link.stringUniqueIdentifier())»«ENDIF»
				«ENDFOR»
			}
			return elements.get(type);
		}
	'''
	
	override def isKnownElementType(GenDiagram it) '''
		«generatedMemberComment»
		public static synchronized boolean isKnownElementType(org.eclipse.gmf.runtime.emf.type.core.IElementType elementType) {
			if (KNOWN_ELEMENT_TYPES == null) {
				KNOWN_ELEMENT_TYPES = new java.util.HashSet<org.eclipse.gmf.runtime.emf.type.core.IElementType>();
				«FOR e : it.getAllTypedElements()»
					«addKnownElementType(e)»
				«ENDFOR»
			}

		    boolean result = KNOWN_ELEMENT_TYPES.contains(elementType);

		    if (!result) {
		        org.eclipse.gmf.runtime.emf.type.core.IElementType[] supertypes = elementType.getAllSuperTypes();
		        for (int i = 0; !result && (i < supertypes.length); i++) {
		            result = KNOWN_ELEMENT_TYPES.contains(supertypes[i]);
		        }
		    }
		    
		    return result;
		}
	'''

    override def additions(GenDiagram it) '''
        «super.additions(it)»
        
        «generatedMemberComment»
        public static boolean isKindOf(org.eclipse.gmf.runtime.emf.type.core.IElementType subtype, org.eclipse.gmf.runtime.emf.type.core.IElementType supertype) {
            boolean result = subtype == supertype;

            if (!result) {
                org.eclipse.gmf.runtime.emf.type.core.IElementType[] supertypes = subtype.getAllSuperTypes();
                for (int i = 0; !result && (i < supertypes.length); i++) {
                    result = supertype == supertypes[i];
                }
            }

            return result;
        }
    '''

	override def getElementTypeByVisualID(GenDiagram it) '''
		«generatedMemberComment»
		public static org.eclipse.gmf.runtime.emf.type.core.IElementType getElementType(String visualID) {
			if (visualID != null) {
				switch (visualID) {
					«FOR e : it.getAllTypedElements().filter[el|el.elementType != null]»
						«caseElementType(e)»
					«ENDFOR»
				}
			}
			return null;
		}
	'''

	override def getElementType(GenDiagram it) '''
		«generatedMemberComment»
		private static org.eclipse.gmf.runtime.emf.type.core.IElementType getElementTypeByUniqueId(String id) {
			return org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry.getInstance().getType(id);
		}
	'''

	override def elementTypeField(GenCommonBase it) '''
		«IF null != elementType»
			«generatedMemberComment»
			public static final org.eclipse.gmf.runtime.emf.type.core.IElementType «stringUniqueIdentifier» = getElementTypeByUniqueId("«elementType.
			uniqueIdentifier»"); «nonNLS(1)»
		«ENDIF»
	'''

	override def typedInstance(GenDiagram it) '''
		«generatedClassComment»
		public static final org.eclipse.papyrus.infra.gmfdiag.common.providers.DiagramElementTypes TYPED_INSTANCE 
			= new org.eclipse.papyrus.infra.gmfdiag.common.providers.DiagramElementTypes(elementTypeImages) {
			
			«generatedMemberComment»
			«xptCodeStyle.overrideC(it)»
			public boolean isKnownElementType(org.eclipse.gmf.runtime.emf.type.core.IElementType elementType) {
				return «qualifiedClassName(it)».isKnownElementType(elementType);
			}
			
			«generatedMemberComment»
			«xptCodeStyle.overrideC(it)»
			public org.eclipse.gmf.runtime.emf.type.core.IElementType getElementTypeForVisualId(String visualID) {
				return «qualifiedClassName(it)».getElementType(visualID);
			}
			
			«generatedMemberComment»
			«xptCodeStyle.overrideC(it)»
			public org.eclipse.emf.ecore.ENamedElement getDefiningNamedElement(org.eclipse.core.runtime.IAdaptable elementTypeAdapter) {
				return «qualifiedClassName(it)».getElement(elementTypeAdapter);
			}
		}; 
	'''

	override def accessElementType(GenCommonBase it) '''«it.diagram.elementTypesQualifiedClassName».«stringUniqueIdentifier»'''

	override def caseElementType(GenCommonBase it) '''
		«xptVisualIDRegistry.caseVisualID(it)»
			return «stringUniqueIdentifier()»;
	'''

	override def addKnownElementType(GenCommonBase it) '''
		«IF null != elementType»
			KNOWN_ELEMENT_TYPES.add(«stringUniqueIdentifier()»);
		«ENDIF»
	'''
}