/*******************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - bug 464647
 *     
 ******************************************************************************/
package org.eclipse.papyrus.tests.framework.m2t.xtend.templates

import org.eclipse.uml2.uml.Operation

/**
 * Template for the tests class for creation of link edit-parts.
 */
class TestLinkTemplate extends AbstractTestTemplate {

    override purpose(Operation testCase, String componentName) '''Test to create link «componentName».'''
}
