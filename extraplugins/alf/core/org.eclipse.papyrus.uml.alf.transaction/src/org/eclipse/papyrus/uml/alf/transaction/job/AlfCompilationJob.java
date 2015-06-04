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
 *   Jeremie Tatibouet (CEA LIST)
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.alf.transaction.job;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.uml.alf.libraries.helper.AlfUtil;
import org.eclipse.papyrus.uml.alf.text.generation.DefaultEditStringRetrievalStrategy;
import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;
import org.eclipse.papyrus.uml.alf.transaction.commands.AlfCommandFactory;
import org.eclipse.uml2.uml.Activity;

public class AlfCompilationJob extends AlfAbstractJob {

	public static final String NAME = "Compile";

	public AlfCompilationJob(AlfTextualRepresentation representation) {
		super(NAME, representation);
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		IStatus jobStatus = Status.OK_STATUS;
		TransactionalEditingDomain domain = this.getEditingDomain();
		if (domain != null) {
			/* Protect the resource in case of concurrent jobs */
			Resource resource = this.modelElementState.getOwner().eResource();
			synchronized (resource) {
				/* 1. Do not listen to modifications that occur on the resource during compilation */
				resource.setTrackingModification(false);
				/* 2. Do compilation phase */
				try {
					domain.getCommandStack().execute(AlfCommandFactory.getInstance().createCompilationCommand(this.modelElementState));
				} catch (Exception e) {
					e.printStackTrace();
					jobStatus = Status.CANCEL_STATUS;
				}
				/* 3. Save the textual representation within the model */
				if (jobStatus.equals(Status.OK_STATUS)) {
					/*NOTE: does not update textual representation after compilation (u)*/
					if(!(this.modelElementState.getOwner() instanceof Activity)){
						this.modelElementState.setText(new DefaultEditStringRetrievalStrategy().getGeneratedEditString(this.modelElementState.getOwner()));
					}
					/* 3. Execute the commands */
					try {
						if(this.modelElementState.getSource()==null){
							this.modelElementState.setSource(AlfUtil.getInstance().getTextualRepresentationComment(this.modelElementState.getOwner()));
						}
						domain.getCommandStack().execute(AlfCommandFactory.getInstance().creatSaveCommand(this.modelElementState));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				/* 4. Restore the modification tracking */
				resource.setTrackingModification(true);
			}
		} else {
			jobStatus = Status.CANCEL_STATUS;
		}
		return jobStatus;
	}
}
