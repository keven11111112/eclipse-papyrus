/**
 * Copyright (c) 2017 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.emf.expressions.util.custom;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.emf.resources.AbstractEMFResource;

/**
 * 
 * We create our own resource to manage the save options with (I hope) no doubt.
 * The goal is to avoid formatting trouble between editors, to use ID, and to save default values, as provided by the super class
 *
 */
public class ExpressionsResource extends AbstractEMFResource {

	/**
	 * The extension for the file owning Expressions
	 */
	public static final String EXPRESSIONS_RESOURCE_FILE_EXTENSION = "expressions"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 *
	 * @param uri
	 */
	public ExpressionsResource(URI uri) {
		super(uri);
	}

}
