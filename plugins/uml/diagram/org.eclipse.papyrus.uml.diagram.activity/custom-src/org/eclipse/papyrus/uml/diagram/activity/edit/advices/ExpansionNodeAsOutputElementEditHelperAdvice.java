/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.advices;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.uml2.uml.ExpansionNode;
import org.eclipse.uml2.uml.ExpansionRegion;

/**
 * specific advice for expansion nodes as output element
 */
public class ExpansionNodeAsOutputElementEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		EObject elementToConfigure = request.getElementToConfigure();
		if(elementToConfigure instanceof ExpansionNode) {
			final ExpansionNode node = ((ExpansionNode)elementToConfigure);
			final EObject container = node.eContainer();
			if(container instanceof ExpansionRegion) {
				// add the element to the list of input elements
				RecordingCommand command = new RecordingCommand(request.getEditingDomain(), "Adding node as an output element") {
					
					@Override
					protected void doExecute() {
						((ExpansionRegion)container).getOutputElements().add(node);
					}
				};
				return new EMFtoGMFCommandWrapper(command);
			}
		}
		return super.getBeforeConfigureCommand(request);
	}
}
