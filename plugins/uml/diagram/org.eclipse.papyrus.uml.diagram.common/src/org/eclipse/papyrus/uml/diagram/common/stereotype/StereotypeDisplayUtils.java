/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Celine Janssens (ALL4TEC) celine.janssens@all4tec.net - Initial API and implementation
 *   Celine Janssens (ALL4TEC) celine.janssens@all4tec.net - Bug 455311 : Refactor Stereotypes Display
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.stereotype;

import org.eclipse.papyrus.uml.diagram.common.Activator;



/**
 * This Class regroups the Constants required for the Stereotype Display
 * 
 * @author Celine JANSSENS
 *
 */
public class StereotypeDisplayUtils {

	// Depth Separator of the Stereotype Name
	public static final String STEREOTYPE_LABEL_DEPTH_SEPARATOR = "::";//$NON-NLS-1$

	// Name of Style for Comment Node to point to related main Object
	public static final String STEREOTYPE_COMMENT_RELATION_NAME = "BASE_ELEMENT";//$NON-NLS-1$

	// Type Notation Value
	public static final String STEREOTYPE_LABEL_TYPE = "StereotypeLabel"; //$NON-NLS-1$

	public static final String STEREOTYPE_COMPARTMENT_TYPE = "StereotypeCompartment";//$NON-NLS-1$
	public static final String STEREOTYPE_BRACE_TYPE = "StereotypeBrace";//$NON-NLS-1$

	public static final String STEREOTYPE_PROPERTY_TYPE = "StereotypeProperty";//$NON-NLS-1$
	public static final String STEREOTYPE_PROPERTY_BRACE_TYPE = "StereotypePropertyBrace";//$NON-NLS-1$

	public static final String STEREOTYPE_COMMENT_TYPE = "StereotypeComment";//$NON-NLS-1$
	public static final String STEREOTYPE_COMMENT_LINK_TYPE = "StereotypeCommentLink";

	// Name notation value
	public static final String STEREOTYPE_LABEL_NAME = "stereotype";//$NON-NLS-1$
	public static final String STEREOTYPE_COMPARTMENT_NAME = "stereotype";//$NON-NLS-1$
	public static final String STEREOTYPE_PROPERTY_NAME = "property";//$NON-NLS-1$

	// Depth Named Style
	public static final String STEREOTYPE_LABEL_DEPTH = "depth";//$NON-NLS-1$

	// Depth Constants
	public static final String DEPTH_MAX = "full";//$NON-NLS-1$
	public static final String DEPTH_MIN = "none";//$NON-NLS-1$
	public static final String DEPTH_AUTO = "auto";//$NON-NLS-1$
	public static final String DEFAULT_DEPTH_VALUE = "full";//$NON-NLS-1$


	// Special Char Constants
	public final static String STEREOTYPE_LABEL_SEPARATOR = ", ";//$NON-NLS-1$
	public static final String STEREOTYPE_PROPERTY_SEPARATOR = "\n";//$NON-NLS-1$
	public static final String STEREOTYPE_PROPERTY_VALUE_SEPARATOR = " = ";//$NON-NLS-1$
	public static final String STEREOTYPE_PROPERTIES_SEPARATOR = " ";//$NON-NLS-1$

	// Ornament Constants
	public final static String QUOTE_LEFT = Activator.ST_LEFT;
	public final static String QUOTE_RIGHT = Activator.ST_RIGHT;
	public final static String BRACE_LEFT = "{";
	public final static String BRACE_RIGHT = "}";



	public static final boolean PERSISTENT = false;//$NON-NLS-1$

}
