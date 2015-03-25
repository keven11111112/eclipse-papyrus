/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Francois Le Fevre (CEA LIST) francois.le-fevre@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.ui.menu;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * this command is used to create a link "satisfyBy" between requirement and namedElement
 *
 */
public abstract class NameNormalizationCommand extends RecordingCommand{
	protected EObject source;
	protected String parameter;
	
	public static final String NAME_ACTION="name quick formatting action";//$NON-NLS-1$
	
	public static final String DEFAULT_ACTION="default";//$NON-NLS-1$
	public static final String UPPERCASE_ACTION="uppercase";//$NON-NLS-1$
	public static final String LOWERCASE_ACTION="lowercase";//$NON-NLS-1$
	

	public NameNormalizationCommand(TransactionalEditingDomain domain, EObject source, String normalization){ 
		super(domain,NAME_ACTION+": "+normalization);
		this.source=source;
		this.parameter=normalization;
	}

}