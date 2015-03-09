/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.commands;

import org.eclipse.emf.ecore.EObject;

/**
 * The Class SemanticAdapter used to package semantic or view element in a
 * deferred command
 * 
 * @deprecated since 1.1.0
 * use org.eclipse.papyrus.infra.gmfdiag.common.adapter.SemanticAdapter
 */
@Deprecated
public class SemanticAdapter extends org.eclipse.papyrus.infra.gmfdiag.common.adapter.SemanticAdapter {

	/**
	 * Constructor.
	 *
	 * @param element
	 * @param view
	 */
	public SemanticAdapter(EObject element, Object view) {
		super(element, view);
	}

}
