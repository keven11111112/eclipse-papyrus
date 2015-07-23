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

package org.eclipse.papyrus.tests.framework.gmfgenuml2utp

import com.google.common.collect.Sets
import com.google.inject.Singleton
import java.util.Collection
import java.util.Collections
import org.eclipse.emf.common.util.BasicDiagnostic
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.papyrus.tests.framework.exceptions.TestExceptions
import org.eclipse.uml2.uml.Behavior
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.InstanceSpecification
import org.eclipse.uml2.uml.UMLFactory
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart
import org.eclipse.papyrus.tests.framework.xtend.annotations.Cached

/**
 * An injectable component that determines whether a particular permutation of edit-parts may generate a
 * specific kind of test case.
 */
@Singleton
class TestExceptionManager {
	Collection<TestExceptions> testExceptions;

	BasicDiagnostic diagnostics = new BasicDiagnostic
	
	new() {
		this(Collections.emptyList)
	}

	new(Collection<TestExceptions> exceptions) {
		testExceptions = Sets.newHashSet(exceptions);
	}

	def addTestExceptions(TestExceptions exceptions) {
		testExceptions.add(exceptions);
		return this
	}
	
	def shouldGenerate(Class abstractTestClass, InstanceSpecification... editPart) {
		testExceptions.empty || {
			val editPartsEList = new BasicEList(editPart)
			testExceptions.forall[validate(editPartsEList, abstractTestClass, diagnostics)]
		}
	}
	
	/** Queries whether an edit-part is absolutely excluded from all tests. */
	@Cached def boolean isExcluded(InstanceSpecification editPart) {
		!testExceptions.empty && testExceptions.exists[
			constraints.filter(ForbiddenEditPart).exists[it.editPart.matches(editPart)]
		]
	}
	
	def boolean processExclusions(Class abstractTestClass, Behavior testMethod, InstanceSpecification... editPart) {
		var result = true
		
		val current = diagnostics.children.size
		if (!shouldGenerate(abstractTestClass, editPart)) {
			// Can only reasonably append one annotation in the generated code
			val newProblem = diagnostics.children.get(current)
			result = newProblem.severity < Diagnostic.ERROR

			// Don't bother with annotations if we'll be omitting the test case
			if (result) {
				testMethod.preconditions += UMLFactory.eINSTANCE.createConstraint => [
					name = newProblem.data.get(0).toString
					specification = UMLFactory.eINSTANCE.createLiteralString => [
						value = newProblem.message
					]
				]
			}
		}
		
		result
	}
}
