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
*     CEA LIST. - initial API and implementation
*******************************************************************************/
package org.eclipse.papyrus.req.sysml.assistant.command;

import java.text.DecimalFormat;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.req.sysml.assistant.I_SysMLStereotype;
import org.eclipse.papyrus.req.sysml.preferences.Activator;
import org.eclipse.papyrus.req.sysml.preferences.PreferenceConstants;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Creates a new SysML requirements based on the Papyrus Req preferences page.
 *
 */
public class PapyrusReqSysMLRequirementCreateCommand extends RecordingCommand {
	protected Element selectedElement;

	public PapyrusReqSysMLRequirementCreateCommand(TransactionalEditingDomain domain, Element selectedElements) {
		super(domain, "PapyrusReqSysMLRequirementCreateCommand");
		this.selectedElement = selectedElements;
	}

	protected void createRequirement(org.eclipse.uml2.uml.Package owner, String text) {
		org.eclipse.uml2.uml.Class requirement = owner.createOwnedClass("tmpName", false);
		Stereotype reqStereotype = requirement.getApplicableStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE);
		requirement.applyStereotype(reqStereotype);
		String id = getNewIDReq(owner);
		requirement.setName(id);
		requirement.setValue(reqStereotype, I_SysMLStereotype.REQUIREMENT_ID_ATT, id);

	}

	/**
	 * get new name of Papyrus SysML requirement
	 * 
	 * @param owner
	 *            the package that will contain requirement
	 * @return the name for a potential requirement
	 */
	public static String getNewIDReq(org.eclipse.uml2.uml.Package owner) {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String prefix = store.getString(PreferenceConstants.REQUIREMENT_ID_PREFIX);
		int digit = store.getInt(PreferenceConstants.REQUIREMENT_ID_DIGIT);
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
			EList<PackageableElement> packelements = owner.getPackagedElements();
			for (Iterator<PackageableElement> iterator = packelements.iterator(); iterator.hasNext() && (!IDexist);) {
				PackageableElement packageableElement = (PackageableElement) iterator.next();
				// current element is a Req?
				Stereotype reqStereotype = packageableElement
						.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE);

				if (reqStereotype != null) {
					if (packageableElement.getValue(reqStereotype, I_SysMLStereotype.REQUIREMENT_ID_ATT) != null) {
						String existedID = (String) packageableElement.getValue(reqStereotype,
								I_SysMLStereotype.REQUIREMENT_ID_ATT);
						String newID = prefix + value;
						// id already exist so increment suffix
						if (newID.equals(existedID)) {
							IDexist = true;
						}
					}
				}
			}

		}
		return prefix + value;

	}

	@Override
	protected void doExecute() {
		if (selectedElement instanceof Package) {
			createRequirement((Package) selectedElement, "");
		}

	}

}