/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.widgets.util;

import java.util.List;

/**
 * Common interface to use to find elements from a given string
 *
 */
public interface INameResolutionHelper {

	/**
	 * 
	 * @param aString
	 *            a string
	 * @return
	 * 		all elements whose the name starts with this string, or all found element if the string is <code>null</code> or empty
	 */
	public List<?> getMatchingElements(final String aString);

	/**
	 * 
	 * @param aString
	 *            a string
	 * @return
	 * 		all elements which have the wanted string as (qualified) name
	 */
	public List<?> getElementsByName(final String aString);


	/**
	 * Get the shortest qualified name.
	 * 
	 * @param element
	 *            The element to get the shortest qualified name.
	 * @return
	 * 		the shortest qualified to use for the element
	 * @deprecated since 1.2.0
	 */
	@Deprecated
	public List<String> getShortestQualifiedNames(final Object element);

	/**
	 * Get the shortest qualified name.
	 * 
	 * @param element
	 *            The element to get the shortest qualified name.
	 * @param manageDuplicate
	 *            Boolean to determinate if the duplicated shortest qualified names must be remove from the returned list.
	 * @return the shortest qualified to use for the element
	 */
	public List<String> getShortestQualifiedNames(final Object element, final boolean manageDuplicate);

}
