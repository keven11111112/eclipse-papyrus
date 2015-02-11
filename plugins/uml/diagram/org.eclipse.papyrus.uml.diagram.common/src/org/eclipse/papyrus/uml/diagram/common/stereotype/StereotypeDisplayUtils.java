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

/**
 * This Class regroups the Constants required for the Stereotype Display
 * 
 * @author Céline JANSSENS
 *
 */
public class StereotypeDisplayUtils {

	public static final String STEREOTYPE_LABEL_DEPTH_SEPARATOR = "::";//$NON-NLS-1$

	public static final String STEREOTYPE_LABEL_TYPE = "StereotypeLabel"; //$NON-NLS-1$
	public static final String STEREOTYPE_PROPERTY_TYPE = "StereotypeProperty";//$NON-NLS-1$
	public static final String STEREOTYPE_COMPARTMENT_TYPE = "StereotypeCompartment";//$NON-NLS-1$
	public static final String STEREOTYPE_LABEL_NAME = "stereotype";//$NON-NLS-1$
	public static final String STEREOTYPE_COMPARTMENT_NAME = "stereotype";//$NON-NLS-1$
	public static final String STEREOTYPE_PROPERTY_NAME = "property";//$NON-NLS-1$
	public static final String STEREOTYPE_LABEL_DEPTH = "depth";//$NON-NLS-1$
	public static final String DEFAULT_DEPTH_VALUE = "full";//$NON-NLS-1$
	public static final String STEREOTYPE_LABEL_VSISIBLE = "visible";//$NON-NLS-1$
	public static final Boolean DEFAULT_VISIBILITY_VALUE = Boolean.TRUE;//$NON-NLS-1$
	public static final Boolean DEFAULT_PROPERTY_VISIBILITY_VALUE = Boolean.TRUE;//$NON-NLS-1$

	public static final String DEPTH_MAX = "full";//$NON-NLS-1$
	public static final String DEPTH_MIN = "none";//$NON-NLS-1$
	public static final String DEPTH_AUTO = "auto";//$NON-NLS-1$

	public static final String DEFAULT_STEREOTYPE_PROPERTY_LOCATION = "compartment";//$NON-NLS-1$
	public static final String STEREOTYPE_PROPERTY_LOCATION_BRACE = "inBrace";//$NON-NLS-1$
	public static final String STEREOTYPE_PROPERTY_LOCATION_COMPARTMENT = "inCompartment";//$NON-NLS-1$
	public static final String STEREOTYPE_PROPERTY_LOCATION_COMMENT = "inComment";//$NON-NLS-1$

	public final static String STEREOTYPE_LABEL_SEPARATOR = ", ";//$NON-NLS-1$
	public static final String STEREOTYPE_PROPERTY_SEPARATOR = "\n";//$NON-NLS-1$
	public static final String STEREOTYPE_PROPERTY_VALUE_SEPARATOR = " = ";//$NON-NLS-1$

	// TODO To be changed with the French brackets
	// In order to distinguish the NamedStyle Label from the EAnnotation
	public final static String BRACE_LEFT = "<== "; // String.valueOf("\u00AB");
	public final static String BRACE_RIGHT = " ==>"; // String.valueOf("\u00AA");

}
