/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - #372479, #386838
 */
package aspects.xpt.editor

import com.google.inject.Inject
import com.google.inject.Singleton
import metamodel.MetaModel
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet
import org.eclipse.gmf.codegen.gmfgen.ValueExpression
import xpt.CodeStyle
import xpt.Common
import xpt.Common_qvto
import xpt.diagram.editpolicies.LinkUtils_qvto
import xpt.diagram.updater.Utils_qvto

//XXX: [MG] decide what to do with @MetaDef methods
@Singleton class VisualIDRegistry extends xpt.editor.VisualIDRegistry {
	@Inject extension MetaModel
	@Inject extension Common
	@Inject extension Common_qvto;
	@Inject extension LinkUtils_qvto;
	@Inject extension Utils_qvto;
	
	@Inject CodeStyle xptCodeStyle;

	override getDiagramVisualID(GenDiagram it) '''
		«generatedMemberComment()»
		public static String «getDiagramVisualIDMethodName(it)»(org.eclipse.emf.ecore.EObject domainElement) {
			if (domainElement == null) {
				«unrecognizedVID(it)»
			}
			return «visualID(it)»;
		}
	'''

	/**
	 * Support for extra contstraints to check about model element.
	 * Includes expression fields for interpreted constrains (like ocl or regexp).
	 * For each model element that has an associated constraint, there's a method is<DomainElement>_<UID>()
	 * that performs extra specification as defined by value expression
	 * 
	 * FIXME don't use static fields, replace with instance/separate cache (e.g. accessible from Activator)
	 */
		override constraintMethods(GenDiagram it) '''
			«IF null != editorGen.expressionProviders»
				«FOR topNode : topLevelNodes.filter[n|!n.sansDomain].filter[n|n.modelFacet.modelElementSelector != null]»«constraintMethod(
				topNode)»«ENDFOR»
				«FOR childNode : childNodes.filter[n|!n.sansDomain].filter[n|n.modelFacet.modelElementSelector != null]»«constraintMethod(
				childNode)»«ENDFOR»
				«FOR link : links.filter[n|!n.sansDomain]»«constraintMethod(link.modelFacet, link)»«ENDFOR»
			«ENDIF»
		'''
	//[ExtendedConstraint] Model selector constraint
	override checkDomainElementConstraints(TypeModelFacet it, GenCommonBase commonBase) '''
«««		«IF null != modelElementSelector»
«««		//«it.eContainer»
«««		//->«modelElementSelector»
«««		«ENDIF»
		«««	 [ExtendedConstraint] START Testing the kind of ModelFacet (GenLink or Default case)
		«IF null != modelElementSelector»
			«IF commonBase instanceof GenLink || !(modelElementSelector.provider instanceof GenJavaExpressionProvider)»
				«««	[ExtendedConstraint] END   Testing the kind of ModelFacet (GenLink or Default case)
				 && «domainElementConstraintMethodName(commonBase)»(«CastEObject(metaClass,'domainElement')»)
				«««	[ExtendedConstraint] START Testing the kind of ModelFacet (GenLink or Default case) 
			«ELSE»
				 && «domainElementConstraintMethodName(commonBase)»(containerView, «CastEObject(metaClass, 'domainElement')»)
		«ENDIF»
		«ENDIF»
		«««	[ExtendedConstraint] END   Testing the kind of ModelFacet (GenLink or Default case)
	'''

//	override dispatch domainElementConstraintMethod(GenExpressionInterpreter it, GenCommonBase diagramElement,
//		ValueExpression expression, GenClass context) '''
//		«generatedMemberComment()»
//		«IF diagramElement instanceof GenLink»
//		
//		«ELSE»
//		private static boolean «domainElementConstraintMethodName(diagramElement)»(«QualifiedClassName(context)» domainElement) {
//			Object result = «xptGetExpression.getExpression(it, expression, context)».evaluate(domainElement);
//			return result instanceof Boolean && ((Boolean)result).booleanValue();
//		}			
//		«ENDIF»
//		
//	'''

	//	[ExtendedConstraint] Model selector constraint
	override dispatch domainElementConstraintMethod(GenJavaExpressionProvider it, GenCommonBase diagramElement,
		ValueExpression expression, GenClass context) '''
		«generatedMemberComment»
		«««	[ExtendedConstraint] START Testing the kind of ModelFacet (GenLink or Default case)
		«IF diagramElement instanceof GenLink»
			««« [ExtendedConstraint] END   Testing the kind of ModelFacet (GenLink or Default case)
		private static boolean «domainElementConstraintMethodName(diagramElement)»(«QualifiedClassName(context)» domainElement) {
		««« [ExtendedConstraint] START Testing the kind of ModelFacet (GenLink or Default case)
		«ELSE»
		private static boolean «domainElementConstraintMethodName(diagramElement)»(org.eclipse.gmf.runtime.notation.View containerView, «QualifiedClassName(
		context)» domainElement) {
		«ENDIF»
		««« [ExtendedConstraint] END   Testing the kind of ModelFacet (GenLink or Default case)
		«IF injectExpressionBody && (expression.body != null && expression.body.length() != 0)»
			«expression.body»
		«ELSEIF throwException || (injectExpressionBody && (expression.body == null || expression.body.length() == 0))»
			// FIXME: implement this method 
			// Ensure that you remove @generated or mark it @generated NOT
			throw new java.lang.UnsupportedOperationException("No java implementation provided in '« domainElementConstraintMethodName(diagramElement)»' operation");«nonNLS»
		«ELSE»
			return false;
		«ENDIF»
	}
	'''

	override runtimeTypedInstance(GenDiagram it) '''
		«generatedClassComment()»
		public static final org.eclipse.papyrus.infra.gmfdiag.common.structure.DiagramStructure «runtimeTypedInstanceName(it)» = new org.eclipse.papyrus.infra.gmfdiag.common.structure.DiagramStructure() {
			«generatedMemberComment()»
			«xptCodeStyle.overrideC(it)»
			public String «getVisualIdMethodName(it)»(org.eclipse.gmf.runtime.notation.View view) {
				return «getVisualIDMethodCall(it)»(view);
			}
			
			«generatedMemberComment()»
			«xptCodeStyle.overrideC(it)»
			public String «getModelIDMethodName(it)»(org.eclipse.gmf.runtime.notation.View view) {
				return «getModelIDMethodCall(it)»(view);
			}
			
			«generatedMemberComment()»
			«xptCodeStyle.overrideC(it)»
			public String «getNodeVisualIDMethodName(it)»(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.emf.ecore.EObject domainElement) {
				return «getNodeVisualIDMethodCall(it)»(containerView, domainElement);
			}
			
			«generatedMemberComment()»
			«xptCodeStyle.overrideC(it)»
			public boolean «checkNodeVisualIDMethodName(it)»(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.emf.ecore.EObject domainElement, String candidate) {
				return «checkNodeVisualIDMethodCall(it)»(containerView, domainElement, candidate);
			}
			
			«generatedMemberComment()»
			«xptCodeStyle.overrideC(it)»
			public boolean «isCompartmentVisualIDMethodName(it)»(String visualID) {
				return «isCompartmentVisualIDMethodCall(it)»(visualID);
			}
			
			«generatedMemberComment()»
			«xptCodeStyle.overrideC(it)»
			public boolean «isSemanticLeafVisualIDMethodName(it)»(String visualID) {
				return «isSemanticLeafVisualIDMethodCall(it)»(visualID);
			}
		};
	'''

	override getModelID(GenDiagram it) '''
		«generatedMemberComment()»
		public static String «getModelIDMethodName(it)»(org.eclipse.gmf.runtime.notation.View view) {
			org.eclipse.gmf.runtime.notation.View diagram = view.getDiagram();
			while (view != diagram) {
				org.eclipse.emf.ecore.EAnnotation annotation = view.getEAnnotation("Shortcut"); «nonNLS(1)»
				if (annotation != null) {
					return annotation.getDetails().get("modelID"); «nonNLS(1)»
				}
				view = (org.eclipse.gmf.runtime.notation.View) view.eContainer();
			}
			return diagram != null ? diagram.getType() : null;
		}
	'''

	override def getType(GenDiagram it) '''
	«generatedMemberComment()»
	public static String «getTypeMethodName(it)»(String visualID) {
		return visualID;
	}
	'''

	override def getViewVisualID(GenDiagram it) '''
		«generatedMemberComment()»
		public static String «getVisualIdMethodName(it)»(org.eclipse.gmf.runtime.notation.View view) {
			if (view instanceof org.eclipse.gmf.runtime.notation.Diagram) {
				if («modelID(it)».equals(view.getType())) {
					return «visualID(it)»;
				} else {
					«unrecognizedVID(it)»
				}
			}
			return «getVisualIDMethodCall(it)»(view.getType());
		}
	'''

	override def unrecognizedVID(GenDiagram it) '''
	return null;
	'''

	override def getVisualID(GenDiagram it) '''
		«generatedMemberComment()»
		public static String «getVisualIdMethodName(it)»(String type) {
			return type;
		}
	'''
	
	override def getNodeVisualID(GenDiagram it) '''
	«generatedMemberComment()»
	public static String «getNodeVisualIDMethodName(it)»(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.emf.ecore.EObject domainElement) {
		if (domainElement == null) {
			«unrecognizedVID(it)»
		}
		String containerModelID = «getModelIDMethodCall(it)»(containerView);
		if (!«modelID(it)».equals(containerModelID)«FOR spf : shortcutsProvidedFor»«checkContainerModelID(spf)»«ENDFOR») { «nonNLS_All(shortcutsProvidedFor)»
			«unrecognizedVID(it)»
		}
		String containerVisualID;
		if («modelID(it)».equals(containerModelID)) {
			containerVisualID = «getVisualIDMethodCall(it)»(containerView);
		} else {
			if (containerView instanceof org.eclipse.gmf.runtime.notation.Diagram) {
				containerVisualID = «visualID(it)»;		
			} else {
				«unrecognizedVID(it)»
			}
		}
		if (containerVisualID != null) {
			switch (containerVisualID) {
				«FOR container : allContainers»
				«caseDomainContainerVisualID(container)»
				«ENDFOR»
			}
		}
		«unrecognizedVID(it)»
	}
	'''

	override def getLinkWithClassVisualID(GenDiagram it) '''
	«generatedMemberComment()»
	public static String «getLinkWithClassVisualIDMethodName(it)»(org.eclipse.emf.ecore.EObject domainElement) {
		if (domainElement == null) {
			«unrecognizedVID(it)»
		}
		«FOR typeLink : links.filter[l|isTypeLink(l)]»«returnVisualID(typeLink)»«ENDFOR»
		«unrecognizedVID(it)»
	}
	'''

	override def canCreateNode(GenDiagram it) '''
	«generatedMemberComment()»
	public static boolean «canCreateNodeMethodName(it)»(org.eclipse.gmf.runtime.notation.View containerView, String nodeVisualID) {
		String containerModelID = «getModelIDMethodCall(it)»(containerView);
		if (!«modelID(it)».equals(containerModelID)«FOR spf : shortcutsProvidedFor»«checkContainerModelID(spf)»«ENDFOR») { «nonNLS_All(shortcutsProvidedFor)»
			return false;
		}
		String containerVisualID;
		if («modelID(it)».equals(containerModelID)) {
			containerVisualID = «getVisualIDMethodCall(it)»(containerView);
		} else {
			if (containerView instanceof org.eclipse.gmf.runtime.notation.Diagram) {
				containerVisualID = «visualID(it)»;		
			} else {
				return false;
			}
		}
		if (containerVisualID != null) {
			switch (containerVisualID) {
				«FOR container : allContainers.filter[e|getEssentialVisualChildren(e).notEmpty]»«checkEssentialChildren(container)»«ENDFOR»
				«FOR link : links.filter[l|getEssentialVisualChildren(l).notEmpty]»«checkEssentialChildren(link)»«ENDFOR»
			}
		}
		return false;
	}
	'''

	override def checkEssentialChild(GenCommonBase it) '''
	if («visualID(it)».equals(nodeVisualID)) {
		return true;
	}
	'''

	override def isCompartmentVisualID(GenDiagram it) '''
		«generatedMemberComment()»
		public static boolean «isCompartmentVisualIDMethodName(it)»(String visualID) {
			«IF compartments.notEmpty»
				if (visualID != null) {
					switch (visualID) {
						«FOR compartment : compartments»«caseVisualID(compartment)»«ENDFOR»
							return true;
					}
				}
			«ENDIF»
			return false;
		}
	'''

	override def isSemanticLeafVisualID(GenDiagram it) {
		var leafs = it.allNodes.filter[n | getSemanticChildren(n).empty && n.compartments.forall[c | getSemanticChildren(c).empty]].sortBy[n|n.visualID]
		return '''
		«generatedMemberComment()»
		public static boolean «isSemanticLeafVisualIDMethodName(it)»(String visualID) {
			if (visualID != null) {
				switch (visualID) {
					«/*We need to ensure at last one case, this is legitimate way*/
					caseVisualID(it)»
						return false;
					«IF leafs.notEmpty»
					«FOR leaf : leafs»«caseVisualID(leaf)»«ENDFOR»
						return true;
					«ENDIF»
				}
			}
			return false;
		}
	'''
	}

	override def checkNodeVisualID(GenDiagram it) '''
		«generatedMemberComment()»
		public static boolean «checkNodeVisualIDMethodName(it)»(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.emf.ecore.EObject domainElement, String candidate) {
			if (candidate == null){
				//unrecognized id is always bad
				return false;
			}
			String basic = «getNodeVisualIDMethodName(it)»(containerView, domainElement);
			return candidate.equals(basic);
		}
	'''

}
