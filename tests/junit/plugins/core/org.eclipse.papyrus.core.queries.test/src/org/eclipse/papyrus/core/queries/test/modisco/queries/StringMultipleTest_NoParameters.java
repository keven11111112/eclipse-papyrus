/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.queries.test.modisco.queries;

import java.util.Arrays;
import java.util.Collection;
import org.eclipse.uml2.uml.Element;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;

/** test - string return multiple values - no parameters */
public class StringMultipleTest_NoParameters implements IJavaModelQuery<Element, Collection<String>> {

	/**
	 * {@inheritDoc}
	 */
	public Collection<String> evaluate(final Element context, final ParameterValueList parameterValues)
			throws ModelQueryExecutionException {
		// TODO Auto-generated method stub
		return Arrays.asList("Test1", "Test2");
	}
}
