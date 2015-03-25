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
package org.eclipse.papyrus.uml.modelexplorer.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.ui.menu.NameNormalizationCommand;
import org.eclipse.uml2.uml.NamedElement;

public class UmlNameNormalizationCommand extends NameNormalizationCommand{

	public UmlNameNormalizationCommand(TransactionalEditingDomain domain, EObject source, String parameter){ 
		super(domain,source,parameter);
	}

	/**
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 *
	 */
	@Override
	protected void doExecute() {
		if(source instanceof NamedElement){
			String name  = ((NamedElement)source).getName();
			switch (parameter) {
			case UPPERCASE_ACTION:
				((NamedElement)source).setName(name.toUpperCase());
				break;
			case LOWERCASE_ACTION:
				((NamedElement)source).setName(name.toLowerCase());
				break;

			default:
				((NamedElement)source).setName(name.toUpperCase());
				break;
			}

		}
	}

}