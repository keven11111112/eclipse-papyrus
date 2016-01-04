/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
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

package org.eclipse.papyrus.junit.framework.classification;

import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.UseParametersRunnerFactory;
import org.junit.runners.model.InitializationError;
import org.junit.runners.parameterized.ParametersRunnerFactory;
import org.junit.runners.parameterized.TestWithParameters;

/**
 * Factory for classification-sensitive parameterized test suites.
 * Specify this factory in the {@literal @}{@link UseParametersRunnerFactory}
 * annotation on your <tt>{@literal @}{@link RunWith}({@link Parameterized}.class)</tt>
 * test class to support the classfication and condition annotations of the Papyrus
 * test framework.
 * 
 * @see Parameterized
 * @see UseParametersRunnerFactory
 */
public class ClassificationRunnerWithParametersFactory implements ParametersRunnerFactory {

	public ClassificationRunnerWithParametersFactory() {
		super();
	}

	@Override
	public Runner createRunnerForTestWithParameters(TestWithParameters test) throws InitializationError {
		return new ClassificationRunnerWithParameters(test);
	}
}
