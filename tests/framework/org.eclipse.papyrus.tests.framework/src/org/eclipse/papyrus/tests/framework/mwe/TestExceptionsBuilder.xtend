/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.tests.framework.mwe

import java.util.Collection
import java.util.List
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec
import org.eclipse.papyrus.tests.framework.exceptions.ExceptionsFactory
import org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart
import org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation
import org.eclipse.papyrus.tests.framework.exceptions.ForbiddenReasonKind
import org.eclipse.papyrus.tests.framework.exceptions.OperatorKind
import org.eclipse.papyrus.tests.framework.exceptions.TestConstraint
import org.eclipse.papyrus.tests.framework.exceptions.TestExceptions
import org.eclipse.papyrus.tests.framework.xtend.annotations.LiteralConstants
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.Model
import org.eclipse.xtend.lib.annotations.Accessors

import static extension org.eclipse.papyrus.tests.framework.m2m.DefaultingList.*

/**
 * A builder DSL for an ad hoc test exclusions model in the transformation workflow's Guice module.
 */
class TestExceptionsBuilder {
	List<TestConstraintBuilder> constraints = newArrayList
	
	def editPart((ForbiddenEditPartBuilder)=>void constraintBuilder) {
		val forbidden = new ForbiddenEditPartBuilder
		constraintBuilder.apply(forbidden)
		constraints += forbidden
	}
	
	def permutation((ForbiddenEditPartPermutationBuilder)=>void permutationBuilder) {
		val forbidden = new ForbiddenEditPartPermutationBuilder
		permutationBuilder.apply(forbidden)
		constraints += forbidden
	}
	
	def TestExceptions build(Model frameworkBase, GenEditorGenerator gmfgen) {
		ExceptionsFactory.eINSTANCE.createTestExceptions => [model |
			// Process critical constraints first because if any non-critical constraints also match,
			// then we'll get test cases annotated out that shouldn't even be generated
			this.constraints.sortBy[if (isCritical) -1 else 1].forEach[build(frameworkBase, gmfgen, model.constraints)]
		]
	}
	
	//
	// Nested builders
	//
	
	abstract static class AbstractBuilder {
		def EditPartSpecBuilder named(String editPartClassName) {
			new EditPartRefBuilder(editPartClassName)
		}
		
		def EditPartSpecBuilder any() {
			AnyEditPartBuilder.INSTANCE
		}
	}
	
	abstract static class TestConstraintBuilder extends AbstractBuilder {
		boolean isCritical
		
		abstract package def void build(Model frameworkBase, GenEditorGenerator gmfgen, Collection<? super TestConstraint> products)
		
		def void critical() {
			isCritical = true
		}
		
		protected def configure(TestConstraint constraint) {
			constraint.omitOnFailure = isCritical
		}
	}

	abstract static class AbstractForbiddenEditPartsBuilder extends TestConstraintBuilder {
		@Accessors @LiteralConstants(isStatic = false) ForbiddenReasonKind kind = ForbiddenReasonKind.INVALID
		@Accessors String reason = "Capability not implemented."
		
		protected def dispatch configure(ForbiddenEditPart constraint) {
			super.configure(constraint)
			
			constraint.reasonKind = kind
			constraint.reason = reason
		}
		
		protected def dispatch configure(ForbiddenEditPartPermutation constraint) {
			super.configure(constraint)
			
			constraint.reasonKind = kind
			constraint.reason = reason
		}
	}
	
	static class ForbiddenEditPartBuilder extends AbstractForbiddenEditPartsBuilder {
		@Accessors(PUBLIC_SETTER) EditPartSpecBuilder editPart
		
		override package def build(Model frameworkBase, GenEditorGenerator gmfgen, Collection<? super TestConstraint> products) {
			products += ExceptionsFactory.eINSTANCE.createForbiddenEditPart => [
				configure
				
				it.editPart = editPart.build(frameworkBase, gmfgen)
			]
		}
	}
	
	static class ForbiddenEditPartPermutationBuilder extends AbstractForbiddenEditPartsBuilder {
		static final List<String> DEFAULT_CONTEXTS = #['AbstractPapyrusTestCase', 'AbstractSynchronizationTest']
		
		@Accessors Collection<String> testContexts = newDefaultingList
		List<EditPartsBuilder> editParts = newArrayList
		
		def editParts((EditPartsBuilder)=>void editPartsBuilder) {
			val spec = new EditPartsBuilder
			editPartsBuilder.apply(spec)
			editParts += spec
		}
		
		override package def build(Model frameworkBase, GenEditorGenerator gmfgen, Collection<? super TestConstraint> products) {
			products += editParts.map[leaves].flatten.map[builder |
				ExceptionsFactory.eINSTANCE.createForbiddenEditPartPermutation => [
					configure
					
					it.editParts += builder.build(frameworkBase, gmfgen)
					
					testClasses += (testContexts || DEFAULT_CONTEXTS).map[testContext |
						frameworkBase.allOwnedElements.filter(Class).findFirst[name == testContext] => [
							if (it == null) {
								throw new IllegalArgumentException('No such abtract test context in the framework: ' + testContext)
							}
						]
					].filterNull
				]
			]
		}
		
		public final def nodeAppearance() { 'AbstractAppearanceNodeTest'}
		public final def createNode() { 'AbstractCreateNodeFromPaletteTest'}
		public final def createLabel() { 'AbstractCreateChildLabelNodeFromPaletteTest'}
		public final def createLink() { 'AbstractCreateLinkFromPaletteTest'}
		public final def deleteNode() { 'AbstractDeleteNodeTest'}
		public final def directEditNode() { 'AbstractEditableNodeTest'}
		public final def dropNode() { 'AbstractDropNodeTest'}
		public final def synchronization() { 'AbstractSynchronizationTest'}
	}
	
	static class EditPartsBuilder extends AbstractBuilder {
		final EditPartRole roleToken = new EditPartRole(this)
		
		List<EditPartSpecBuilder> editParts = newArrayList
		
		EditPartsBuilder parent
		List<EditPartsBuilder> children = newArrayList
		
		new() {
			this(null)
		}
		
		new(EditPartsBuilder parent) {
			this.parent = parent
		}
		
		final def node() { roleToken }
		final def topNode() { roleToken }
		final def child() { roleToken }
		final def label() { roleToken }
		final def link() { roleToken }
		final def source() { roleToken }
		final def target() { roleToken }
		
		/**
		 * Nested edit-part filters.  Each nested group is combined with the edit-parts of the parent
		 * groups, in order from the root down.
		 */
		def editParts((EditPartsBuilder)=>void editPartsBuilder) {
			val spec = new EditPartsBuilder(this)
			editPartsBuilder.apply(spec)
			children += spec
		}
		
		/**
		 * Nested edit-part filters for link ends.  Specify two filters (for source and targets ends), which generate
		 * for the {@link #source() source} role a pair with an {@link TestExceptionsBuilder.AbstractBuilder#any() any} {@link #target() target}
		 * and vice versa for the {@link #target() target} role.
		 */
		def linkEnds((EditPartsBuilder)=>void editPartsBuilder) {
			val spec = new EditPartsBuilder(this)
			editPartsBuilder.apply(spec)
			children += spec.forSource
			children += spec.forTarget
		}
		
		package def Iterable<EditPartsBuilder> leaves() {
			if (children.empty) #[this] else children.map[leaves].flatten.toList
		}
		
		package def build(Model frameworkBase, GenEditorGenerator gmfgen) {
			allEditParts.map[build(frameworkBase, gmfgen)]
		}
		
		private def Iterable<EditPartsBuilder> parentChain() {
			if (parent == null) #[this] else parent.parentChain + #[this]
		}
		
		private def allEditParts() {
			if (parent == null) editParts else parentChain.map[editParts].flatten.toList
		}
		
		private def forSource() {
			new EditPartsBuilder(parent) => [
				it.editParts += this.editParts.get(0)
				it.editParts += any
			]
		}
		
		private def forTarget() {
			new EditPartsBuilder(parent) => [
				it.editParts += any
				it.editParts += this.editParts.get(1)
			]
		}
	}
	
	static final class EditPartRole {
		final EditPartsBuilder builder
		
		package new(EditPartsBuilder builder) {
			this.builder = builder
		}
		
		/** The {@code role} is only informative to the reader. */
		def operator_add(EditPartSpecBuilder builder) {
			this.builder.editParts += builder
			this
		}
	}
	
	static abstract class EditPartSpecBuilder {
		abstract package def EditPartSpec build(Model frameworkBase, GenEditorGenerator gmfgen)
		
		def EditPartSpecBuilder operator_and(EditPartSpecBuilder builder) {
			composite(OperatorKind.AND, this, builder) 
		}
		
		def EditPartSpecBuilder operator_or(EditPartSpecBuilder builder) {
			composite(OperatorKind.OR, this, builder) 
		}
		
		def EditPartSpecBuilder operator_not() {
			composite(OperatorKind.NOT, this) 
		}
		
		def EditPartSpecBuilder operator_and(String editPartClassName) {
			operator_and(new EditPartRefBuilder(editPartClassName)) 
		}
		
		def EditPartSpecBuilder operator_or(String editPartClassName) {
			operator_or(new EditPartRefBuilder(editPartClassName)) 
		}
		
		private def composite(OperatorKind operator, EditPartSpecBuilder... builders) {
			new CompositeEditPartSpecBuilder(operator, builders)
		}
	}
	
	private static class AnyEditPartBuilder extends EditPartSpecBuilder {
		static final AnyEditPartBuilder INSTANCE = new AnyEditPartBuilder
		
		override package EditPartSpec build(Model frameworkBase, GenEditorGenerator gmfgen) {
			ExceptionsFactory.eINSTANCE.createAnyEditPart
		}
	}
	
	private static class CompositeEditPartSpecBuilder extends EditPartSpecBuilder {
		final OperatorKind operator
		final List<EditPartSpecBuilder> editParts
		
		private new(OperatorKind operator, EditPartSpecBuilder... builders) {
			this.operator = operator
			this.editParts = newArrayList(builders)
		}
		
		override operator_and(EditPartSpecBuilder builder) {
			switch operator {
				case OperatorKind.AND : this => [editParts += builder]
				default: super.operator_and(builder)
			}
		}
		
		override operator_or(EditPartSpecBuilder builder) {
			switch operator {
				case OperatorKind.OR : this => [editParts += builder]
				default: super.operator_and(builder)
			}
		}
		
		override package EditPartSpec build(Model frameworkBase, GenEditorGenerator gmfgen) {
			ExceptionsFactory.eINSTANCE.createCompositeEditPartSpec => [
				it.operator = operator
				it.operands += editParts.map[build(frameworkBase, gmfgen)]
			]
		}
	}
	
	private static class EditPartRefBuilder extends EditPartSpecBuilder {
		final String editPartClassName
		
		new(String editPartClassName) {
			this.editPartClassName = editPartClassName
		}
		
		override package EditPartSpec build(Model frameworkBase, GenEditorGenerator gmfgen) {
			ExceptionsFactory.eINSTANCE.createEditPartRef => [
				it.editPart = gmfgen.eAllContents.filter(GenCommonBase).findFirst[it.editPartClassName == editPartClassName]
				
				if (it.editPart == null) {
					throw new IllegalArgumentException('No such edit part in the GMFGen model: ' + editPartClassName)
				}
			]
		}
	}
}
