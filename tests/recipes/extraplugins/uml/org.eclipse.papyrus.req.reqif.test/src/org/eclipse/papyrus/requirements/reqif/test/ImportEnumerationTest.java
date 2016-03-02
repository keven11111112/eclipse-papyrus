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
import org.eclipse.papyrus.requirements.reqif.user.SampleUser;
import org.eclipse.papyrus.requirements.reqif.user.UserRegistry;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.junit.Assert;
import org.junit.Test;

public class ImportEnumerationTest extends AbstractReqIFTest {

	@Test
	public void importEnumeration() {
		//loading
		//now launch a class diagram
		try {
			UserRegistry.instance.setCurrentUser(new SampleUser());
			initModel("ImportReqIFProject", "EnumerationImport", getBundle());
			getReqIFFile("enumeration.reqif");
			openDiagram(editor, "ClassDiagram");
			final DiagramEditPart diagramEditPart = editor.getAdapter(DiagramEditPart.class);
			Assert.assertNotNull("The diagram must be opened", diagramEditPart);
			//launch import
			RecordingCommand cmd = new RecordingCommand(getTransactionalEditingDomain(), "importReqIF") {

				@Override
				protected void doExecute() {
					Package root = (Package)diagramEditPart.resolveSemanticElement();
					ReqIFImporter sysMLReqIFTransfomation = new ReqIFImporterServiceEdit(domain, importedReqIFModel, root);
					sysMLReqIFTransfomation.reImportReqIFModel(true, "id", true);
					Profile theprofile = sysMLReqIFTransfomation.getImpactedProfile();
					Assert.assertTrue("the imported profile muste be applied", root.getAllAppliedProfiles().contains(theprofile));
					Assert.assertNotNull("The enumeration Importance has not been imported", theprofile.getMember("Importance"));
					Assert.assertNotNull("The enumeration Maturity has not been imported", theprofile.getMember("Maturity"));
					Enumeration enumerationImportance = (Enumeration)theprofile.getMember("Importance");
					Enumeration enumerationMaturity = (Enumeration)theprofile.getMember("Maturity");
					Assert.assertNotNull("The enumeration Importance has not Low literal", enumerationImportance.getMember("Low"));
					Assert.assertNotNull("The enumeration Importance has not Medium literal", enumerationImportance.getMember("Medium"));
					Assert.assertNotNull("The enumeration Importance has not High literal", enumerationImportance.getMember("High"));
					Assert.assertNotNull("The enumeration Maturity has not Idea literal", enumerationMaturity.getMember("Idea"));
					Assert.assertNotNull("The enumeration Maturity has not Proto literal", enumerationMaturity.getMember("Proto"));
					Assert.assertNotNull("The enumeration Maturity has not Advanced literal", enumerationMaturity.getMember("Advanced"));
					Assert.assertNotNull("The enumeration Maturity has not Specification literal", enumerationMaturity.getMember("Specification"));
				}
			};
			getTransactionalEditingDomain().getCommandStack().execute(cmd);
		} catch (Exception e) {
			//System.err.println(e);
			e.printStackTrace();
			Assert.assertTrue("The test is not valided because of an exception " + e, false);
		}
	}

	/**
	 * @see org.eclipse.papyrus.junit.utils.tests.AbstractEditorTest#getSourcePath()
	 *
	 * @return
	 */
	@Override
	protected String getSourcePath() {
		return "models/import/importEnumeration/";
	}
}
