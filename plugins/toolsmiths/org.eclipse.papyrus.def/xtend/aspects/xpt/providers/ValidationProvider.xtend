/*****************************************************************************
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
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
 * Artem Tikhomirov (Borland) - introduced GenAuditContext entity straightforward and simple #validate() implementation
 * Michael Golubev (Montages) - #386838 - migrate to Xtend2
 * 
 *****************************************************************************/
package aspects.xpt.providers

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenAuditRoot
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenDiagramElementTarget
import xpt.Common
import xpt.Common_qvto
import xpt.GenAuditRoot_qvto
import xpt.editor.VisualIDRegistry
import plugin.Activator
import xpt.CodeStyle

@Singleton class ValidationProvider extends xpt.providers.ValidationProvider {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension GenAuditRoot_qvto; 
	@Inject extension CodeStyle
	
	@Inject VisualIDRegistry xptVisualIDRegistry;
	@Inject Activator xptActivator


	override selectors(GenAuditRoot it) '''
	«IF it !=null»
	«IF it.clientContexts !=null»
	«FOR ctx : it.clientContexts»
		«generatedMemberComment»
		public static class «ctx.className» implements org.eclipse.emf.validation.model.IClientSelector {
			
			«generatedMemberComment»
			public boolean selects(Object object) {
			«IF ctx.ruleTargets.filter(typeof(GenDiagramElementTarget)).notEmpty»
				if (isInDefaultEditorContext(object) && object instanceof org.eclipse.gmf.runtime.notation.View) {
					final String id = «xptVisualIDRegistry.getVisualIDMethodCall(editorGen.diagram)»((org.eclipse.gmf.runtime.notation.View) object);
					boolean result = false;
				«FOR e : getTargetDiagramElements(ctx)»
					result = result || «VisualIDRegistry::visualID(e)».equals(id);
				«ENDFOR»
					return result;
				}
				return false;
			«ELSE»
				return isInDefaultEditorContext(object);
			«ENDIF»
			}
		}
	«ENDFOR»
	«ENDIF»
	«ENDIF»
	'''

	override constraintAdapters(GenAuditRoot it, GenDiagram diagram) '''
		«IF it !=null»
		«IF diagram.editorGen.expressionProviders != null»
		«FOR next : it.rules.filter[a | a.requiresConstraintAdapter]»
			«constraintAdapter(next, diagram.editorGen.expressionProviders)»
		«ENDFOR»
		
		«IF it.rules.exists[a | a.requiresConstraintAdapter]»
		«constraintAdapters_formatMethod(it)»
		«ENDIF»
		«ENDIF»
		«ENDIF»
	'''
	
	override runWithActiveConstraints(GenDiagram it) '''
	«generatedMemberComment»
	public static void runWithConstraints(org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain, Runnable operation) {
		final Runnable op = operation;
		Runnable task = new Runnable() {
			«overrideI»
			public void run() {
				try {
					constraintsActive = true;
					op.run();
				} finally {
					constraintsActive = false;
				}
			}
		};
		if(editingDomain != null) {
			try {
				editingDomain.runExclusive(task);
			} catch (Exception e) {
				«xptActivator.qualifiedClassName(editorGen.plugin)».getInstance().logError("Validation failed", e); «nonNLS(1)»
			}
		} else {
			task.run();
		}
	}
	'''

	override def strategy_support(GenDiagram it) '''
	«IF hasDiagramElementTargetRule(editorGen.audits)»
	«generatedMemberComment»
	public static org.eclipse.emf.validation.service.ITraversalStrategy getNotationTraversalStrategy(
			org.eclipse.emf.validation.service.IBatchValidator validator) {
		return new CtxSwitchStrategy(validator);
	}

	«generatedMemberComment»
	private static class CtxSwitchStrategy implements org.eclipse.emf.validation.service.ITraversalStrategy {

		«generatedMemberComment»
		private org.eclipse.emf.validation.service.ITraversalStrategy defaultStrategy;

		«generatedMemberComment»
		private String currentSemanticCtxId;

		«generatedMemberComment»
		private boolean ctxChanged = true;

		«generatedMemberComment»
		private org.eclipse.emf.ecore.EObject currentTarget;

		«generatedMemberComment»
		private org.eclipse.emf.ecore.EObject preFetchedNextTarget;

		«generatedMemberComment»
		private final String[] contextSwitchingIdentifiers;

		«generatedMemberComment»
		CtxSwitchStrategy(org.eclipse.emf.validation.service.IBatchValidator validator) {
			this.defaultStrategy = validator.getDefaultTraversalStrategy();
			this.contextSwitchingIdentifiers = new String[] {
				«FOR e : getAllTargetDiagramElements(editorGen.audits) SEPARATOR ','»«VisualIDRegistry::visualID(e)»«ENDFOR»
			};
			java.util.Arrays.sort(this.contextSwitchingIdentifiers);
		}

		«generatedMemberComment»
		public void elementValidated(org.eclipse.emf.ecore.EObject element,
				org.eclipse.core.runtime.IStatus status) {
			defaultStrategy.elementValidated(element, status);
		}

		«generatedMemberComment»
		public boolean hasNext() {
			return defaultStrategy.hasNext();
		}

		«generatedMemberComment»
		public boolean isClientContextChanged() {
			if (preFetchedNextTarget == null) {
				preFetchedNextTarget = next();
				prepareNextClientContext(preFetchedNextTarget);
			}
			return ctxChanged;
		}

		«generatedMemberComment»
		public org.eclipse.emf.ecore.EObject next() {
			org.eclipse.emf.ecore.EObject nextTarget = preFetchedNextTarget;
			if (nextTarget == null) {
				nextTarget = defaultStrategy.next();
			}
			this.preFetchedNextTarget = null;
			return this.currentTarget = nextTarget;
		}

		«generatedMemberComment»
		public void startTraversal(java.util.Collection traversalRoots,	org.eclipse.core.runtime.IProgressMonitor monitor) {
			defaultStrategy.startTraversal(traversalRoots, monitor);
		}

		«generatedMemberComment»
		private void prepareNextClientContext(org.eclipse.emf.ecore.EObject nextTarget) { 
			if (nextTarget != null && currentTarget != null) {
				if (nextTarget instanceof org.eclipse.gmf.runtime.notation.View) {
					final String id = «xptVisualIDRegistry.getVisualIDMethodCall(editorGen.diagram)»((org.eclipse.gmf.runtime.notation.View) nextTarget);
					String nextSemanticId = (id != null && java.util.Arrays.binarySearch(contextSwitchingIdentifiers, id) >= 0) ? id : null;
					if ((currentSemanticCtxId != null && currentSemanticCtxId != nextSemanticId)
							|| (nextSemanticId != null && nextSemanticId != currentSemanticCtxId)) {
						this.ctxChanged = true;
					}«/*[artem] not sure why not ctxChanged = <expr>, is it intentional not to reset ctxChanged if condition did not match? I doubt. FIXME?*/»
					currentSemanticCtxId = nextSemanticId;
				} else {
					// context of domain model
					this.ctxChanged = currentSemanticCtxId != null;
					currentSemanticCtxId = null;
				}
			} else {
				this.ctxChanged = false;
			}
		}
	}
	«ENDIF»
	'''
}
