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
 *      Mauricio Alferez (mauricio.alferez@cea.fr) CEA LIST - Improvements
 *
 *****************************************************************************/
package org.eclipse.papyrus.requirements.sysml.traceability.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UseCase;


/**
 * Used to create a link "Refine" between requirement and UseCase
 *
 */
public class RefinementCreateCommand extends RecordingCommand {
	private UseCase source;
	private NamedElement target;
	/**
	 * use to make an abstraction 
	 * @param domain the domain to execute a transaction
	 * @param source the source of the abstraction (the more concrete element) - client
	 * @param target the target of the abstraction (the more abstract element) - supplier
	 */
	public RefinementCreateCommand(TransactionalEditingDomain domain, UseCase source, NamedElement target){ 
		super(domain,"Create an Abstraction");
		this.source=source;
		this.target=target;
	}

	@Override
	protected void doExecute() {
		Abstraction theAbstraction= UMLFactory.eINSTANCE.createAbstraction();
		source.getNearestPackage().getPackagedElements().add(theAbstraction);
		theAbstraction.getSuppliers().add(target);
		theAbstraction.getClients().add(source);
		theAbstraction.setName("Refines_"+this.target.getName());
//		final String packageQN = UMLUtil.getProfile(StandardPackage.eINSTANCE, source.getNearestPackage()).getQualifiedName();
//		Stereotype refineStereotype= theAbstraction.getApplicableStereotype(packageQN+"::Refine");// now it is "StandardProfile::Refine" before it was "StandardProfileL2::Refine"
		Stereotype refineStereotype= theAbstraction.getApplicableStereotype("StandardProfile::Refine");
		theAbstraction.applyStereotype(refineStereotype);
	}

}
