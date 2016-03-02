/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.requirements.reqif.test;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.papyrus.requirements.reqif.integration.transformation.ReqIFImporterServiceEdit;
import org.eclipse.papyrus.requirements.reqif.transformation.ReqIFImporter;
import org.eclipse.papyrus.requirements.reqif.user.User;
import org.eclipse.papyrus.requirements.reqif.user.UserRegistry;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.junit.Assert;
import org.junit.Test;

public class ImportWithPattern extends AbstractReqIFTest {

	@Test
	public void importSpecObject() {
		//loading
		//now launch a class diagram
		try {
			UserRegistry.instance.setCurrentUser(new User() {

				@Override
				public String getID() {
					return "PatternUser";
				}

				@Override
				public String getDefaultProfileName() {
					return "MyProfile";
				}

				@Override
				public boolean canUseEnumerationPattern() {
					return true;
				}

				@Override
				public boolean canImportModel() {
					return true;
				}

				@Override
				public boolean canCreateProfile() {
					return true;
				}

				@Override
				public boolean canChooseTypeToImportInProfile() {
					return false;
				}

				@Override
				public boolean canChooseProfile() {
					return false;
				}
			});
			initModel("ImportReqIFProject", "importWithPattern", getBundle());
			getReqIFFile("importWithPattern.reqif");
			openDiagram(editor, "ClassDiagram");
			final DiagramEditPart diagramEditPart = editor.getAdapter(DiagramEditPart.class);
			Assert.assertNotNull("The diagram must be opened", diagramEditPart);
			RecordingCommand cmd = new RecordingCommand(getTransactionalEditingDomain(), "importReqIF") {

				@Override
				protected void doExecute() {
					//launch import
					Package root = (Package)diagramEditPart.resolveSemanticElement();
					ReqIFImporter sysMLReqIFTransfomation = new ReqIFImporterServiceEdit(domain, importedReqIFModel, root);
					sysMLReqIFTransfomation.setAttributeNameForPatternEnumeration("Attribute1");
					sysMLReqIFTransfomation.reImportReqIFModel(true, "id", true);
					Profile theprofile = sysMLReqIFTransfomation.getImpactedProfile();
					Assert.assertNotNull("The enumeration Importance has not been imported", theprofile.getOwnedMember("Importance"));
					Assert.assertNotNull("The enumeration Maturity has not been imported", theprofile.getOwnedMember("Maturity"));
					Enumeration enumerationImportance = (Enumeration)theprofile.getOwnedMember("Importance");
					Enumeration enumerationMaturity = (Enumeration)theprofile.getOwnedMember("Maturity");
					Assert.assertNotNull("The enumeration Importance has not Low literal", enumerationImportance.getOwnedMember("Low"));
					Assert.assertNotNull("The enumeration Importance has not Medium literal", enumerationImportance.getOwnedMember("Medium"));
					Assert.assertNotNull("The enumeration Importance has not High literal", enumerationImportance.getOwnedMember("High"));
					Assert.assertNotNull("The enumeration Maturity has not Idea literal", enumerationMaturity.getOwnedMember("Idea"));
					Assert.assertNotNull("The enumeration Maturity has not Proto literal", enumerationMaturity.getOwnedMember("Proto"));
					Assert.assertNotNull("The enumeration Maturity has not Advanced literal", enumerationMaturity.getOwnedMember("Advanced"));
					Assert.assertNotNull("The enumeration Maturity has not Specification literal", enumerationMaturity.getOwnedMember("Specification"));
					Assert.assertNotNull("The Stereotype ReqType1 has not been imported", theprofile.getOwnedMember("Type1"));
					Assert.assertNotNull("The Stereotype Low has not been imported", theprofile.getOwnedMember("Low"));
					Assert.assertNotNull("The Stereotype Medium has not been imported", theprofile.getOwnedMember("Medium"));
					Assert.assertNotNull("The Stereotype High has not been imported", theprofile.getOwnedMember("High"));
					Assert.assertNotNull("The Stereotype SysMLmodel has not been imported", theprofile.getOwnedMember("SysMLmodel"));
				}
			};
			getTransactionalEditingDomain().getCommandStack().execute(cmd);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("The test is not valided because of an exception " + e, false);
		}
	}

	/**
	 * @see org.eclipse.papyrus.junit.utils.tests.AbstractEditorTest#getSourcePath()
	 * @return
	 */
	@Override
	protected String getSourcePath() {
		return "models/import/importWithPattern/";
	}
}
