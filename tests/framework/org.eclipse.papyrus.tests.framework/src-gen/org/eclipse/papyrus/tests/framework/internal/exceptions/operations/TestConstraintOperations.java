/**
 * Copyright (c) 2015 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 */
package org.eclipse.papyrus.tests.framework.internal.exceptions.operations;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.tests.framework.Activator;
import org.eclipse.papyrus.tests.framework.exceptions.ForbiddenReasonKind;
import org.eclipse.papyrus.tests.framework.exceptions.TestConstraint;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.InstanceSpecification;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Test Constraint</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.TestConstraint#validate(org.eclipse.emf.common.util.EList, org.eclipse.uml2.uml.Class, org.eclipse.emf.common.util.DiagnosticChain) <em>Validate</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestConstraintOperations {
	private static final String CLASSIFICATION_PACKAGE = "org.eclipse.papyrus.junit.framework.classification"; //$NON-NLS-1$

	private static final Map<ForbiddenReasonKind, String> ANNOTATIONS = Maps.immutableEnumMap(ImmutableMap.of(
			ForbiddenReasonKind.FAILING, CLASSIFICATION_PACKAGE + ".FailingTest", //$NON-NLS-1$
			ForbiddenReasonKind.INVALID, CLASSIFICATION_PACKAGE + ".InvalidTest", //$NON-NLS-1$
			ForbiddenReasonKind.UNIMPLEMENTED, CLASSIFICATION_PACKAGE + ".NotImplemented", //$NON-NLS-1$
			ForbiddenReasonKind.INTERACTIVE, CLASSIFICATION_PACKAGE + ".InteractiveTest")); //$NON-NLS-1$

	private static Logger logger = Logger.getLogger(TestConstraintOperations.class);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected TestConstraintOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static boolean validate(TestConstraint testConstraint, EList<InstanceSpecification> editPart, org.eclipse.uml2.uml.Class testClass, DiagnosticChain diagnostics) {
		throw new UnsupportedOperationException("abstract operation");
	}

	protected static Diagnostic createDiagnostic(TestConstraint constraint, ForbiddenReasonKind reasonKind, String reason, Class testClass, Iterable<? extends InstanceSpecification> editPart) {
		String editPartNames = Joiner.on(", ").join(Iterables.transform(editPart, EditPartRefOperations.getEditPartClassNameFunction()));
		String message = NLS.bind("{0} {1} {2} test case for {3}: {4}", new Object[] {
				constraint.isOmitOnFailure() ? "Omitting" : "Annotating",
				reasonKind.getLiteral(),
				testClass == null ? "any" : testClass.getName(),
				editPartNames,
				reason
		});
		logger.info(message);

		String annotationName;
		switch (reasonKind) {
		case FAILING:
		case INVALID:
		case UNIMPLEMENTED:
		case INTERACTIVE:
			annotationName = ANNOTATIONS.get(reasonKind);
			break;
		default:
			throw new IllegalArgumentException("unsupported reason kind: " + reasonKind); //$NON-NLS-1$
		}

		int severity = constraint.isOmitOnFailure() ? Diagnostic.ERROR : Diagnostic.WARNING;
		return new BasicDiagnostic(severity, Activator.PLUGIN_ID, 0, reason, new Object[] { annotationName });
	}

} // TestConstraintOperations
