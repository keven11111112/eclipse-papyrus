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
 * 
 * 		Patrick Tessier (patrick.tessier@cea.fr) CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.requirements.sysml.traceability.assistant.analysis;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Element;
/**
 * this interface defines the  contract to apply tracability
 *
 */
public interface ITracabilityRule {
	/**
	 * 
	 * @param element the current element
	 * @return true if the rules is interesting for this element
	 */
	public boolean canApplyTracability(Element element);
	
	/**
	 * if the element is interesting we can apply tracability defined in this Rules
	 * @param element the current element
	 * @param domain use to execute command
	 * @return true if the user has accepted to apply this rules.
	 */
	public boolean applyTracability(Element element, TransactionalEditingDomain domain);

}
