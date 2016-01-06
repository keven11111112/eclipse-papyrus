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

import java.text.DecimalFormat;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.OpaqueAction;

public class ConfigureFunction extends RecordingCommand {
	private static final String PREFIX = "F";
	protected OpaqueAction opaqueAction;

	public ConfigureFunction(TransactionalEditingDomain domain, OpaqueAction opaqueAction) {
		super(domain);
		this.opaqueAction = opaqueAction;
	}

	@Override
	protected void doExecute() {
		opaqueAction.getLanguages().add("NaturalLanguage");
		opaqueAction.getBodies().add("Do function");
		opaqueAction.setName(getNewIDFunction(opaqueAction.getActivity()));
	}

	/**
	 * get new name of Papyrus SysML requirement
	 * 
	 * @param owner
	 *            the package that will contain requirement
	 * @return the name for a potential requirement
	 */
	public static String getNewIDFunction(org.eclipse.uml2.uml.Activity owner) {
		int digit = 3;
		int i = 0;

		DecimalFormat df = new DecimalFormat();
		// create suffix
		df.setMinimumIntegerDigits(digit);
		String value = (df.format(i));
		// got through all elements
		boolean IDexist = true;
		while (IDexist) {
			IDexist = false;
			i++;
			value = (df.format(i));
			EList<ActivityNode> node = owner.getOwnedNodes();
			for (Iterator<ActivityNode> iterator = node.iterator(); iterator.hasNext() && (!IDexist);) {
				ActivityNode currentNode = iterator.next();
				// current element is anOpaqueAction?

				if (currentNode instanceof OpaqueAction) {
					String existedID = currentNode.getName();
					String newID = PREFIX + value;
					// id already exist so increment suffix
					if (newID.equals(existedID)) {
						IDexist = true;
					}
				}
			}
		}

		return PREFIX + value;

	}

}
