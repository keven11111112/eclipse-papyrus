/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier(CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.effbd.command;

import java.util.ArrayList;

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.UMLPackage;

public class UpdateOpaqueAction_body extends org.eclipse.emf.transaction.RecordingCommand {

	protected OpaqueAction opaqueAction;
	protected String text;
	protected TransactionalEditingDomain domain;

	public UpdateOpaqueAction_body(TransactionalEditingDomain domain, OpaqueAction opaqueAction, String text) {
		super(domain);
		this.opaqueAction = opaqueAction;
		this.text = text;
		this.domain = domain;
	}

	@Override
	protected void doExecute() {

		try {
			domain.runExclusive(new Runnable() {
				@Override
				public void run() {
					Display display = PlatformUI.getWorkbench().getDisplay();
					display.asyncExec(new Runnable() {
						@Override
						public void run() {
							ArrayList<String> list = new ArrayList<>();
							list.add(text);
							domain.getCommandStack().execute(new SetCommand(domain, opaqueAction, UMLPackage.eINSTANCE.getOpaqueAction_Body(), list));
						}
					});
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// if (opaqueAction.getBodies().size() > 0) {
		// opaqueAction.getBodies().add(text);
		// opaqueAction.getBodies().remove(0);
		// }
	}

}

