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
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Assert;
import org.junit.Test;

public class ImportSpecRelationType extends AbstractReqIFTest {

	@Test
	public void importSpecRelationType() {
		//loading
		//now launch a class diagram
		try {
			UserRegistry.instance.setCurrentUser(new SampleUser());
			initModel("ImportReqIFProject", "importSpecRealtionType", getBundle());
			getReqIFFile("SpecRelationTypes.reqif");
			openDiagram(editor, "ClassDiagram");
			final DiagramEditPart diagramEditPart = editor.getAdapter(DiagramEditPart.class);
			Assert.assertNotNull("The diagram must be opened", diagramEditPart);
			//launch import
			//launch import
			RecordingCommand cmd = new RecordingCommand(getTransactionalEditingDomain(), "importReqIF") {

				@Override
				protected void doExecute() {
					Package root = (Package)diagramEditPart.resolveSemanticElement();
					ReqIFImporter sysMLReqIFTransfomation = new ReqIFImporterServiceEdit(domain, importedReqIFModel, root);
					sysMLReqIFTransfomation.reImportReqIFModel(true, "id", true);
					Profile theprofile = sysMLReqIFTransfomation.getImpactedProfile();
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
					Assert.assertNotNull("The enumeration RelationType0 has not been imported", theprofile.getMember("RelationType0"));
					Assert.assertNotNull("The enumeration RelationType1 has not been imported", theprofile.getMember("RelationType1"));
					Assert.assertNotNull("The enumeration RelationType2 has not been imported", theprofile.getMember("RelationType2"));
					Assert.assertNotNull("The enumeration RelationType3 has not been imported", theprofile.getMember("RelationType3"));
					Assert.assertNotNull("The enumeration RelationType4 has not been imported", theprofile.getMember("RelationType4"));
					Stereotype reqType0 = (Stereotype)theprofile.getMember("RelationType0");
					Stereotype reqType1 = (Stereotype)theprofile.getMember("RelationType1");
					Stereotype reqType2 = (Stereotype)theprofile.getMember("RelationType2");
					Stereotype reqType3 = (Stereotype)theprofile.getMember("RelationType3");
					Stereotype reqType4 = (Stereotype)theprofile.getMember("RelationType4");
					Assert.assertNull("The Stereotype RelationType0 has id  ", reqType0.getOwnedMember("id"));
					Assert.assertNull("The Stereotype RelationType0 has  text ", reqType0.getOwnedMember("text"));
					Assert.assertNotNull("The Stereotype RelationType0 has not attribute1 ", reqType0.getOwnedMember("Attribute1"));
					Assert.assertNull("The Stereotype RelationType1 has  id ", reqType1.getOwnedMember("id"));
					Assert.assertNull("The Stereotype RelationType1 has  text ", reqType1.getOwnedMember("text"));
					Assert.assertNotNull("The Stereotype RelationType1 has not attribute1 ", reqType1.getOwnedMember("Attribute1"));
					Assert.assertNull("The Stereotype RelationType2 has  id ", reqType2.getOwnedMember("id"));
					Assert.assertNull("The Stereotype RelationType2 has  text ", reqType2.getOwnedMember("text"));
					Assert.assertNotNull("The Stereotype RelationType2 has not attribute1", reqType2.getOwnedMember("Attribute1"));
					Assert.assertNull("The Stereotype RelationType3 has  id ", reqType3.getOwnedMember("id"));
					Assert.assertNull("The Stereotype RelationType3 has  text ", reqType3.getOwnedMember("text"));
					Assert.assertNotNull("The Stereotype RelationType3 has not attribute1 ", reqType3.getOwnedMember("Attribute1"));
					Assert.assertNotNull("The Stereotype RelationType3 has not attribute2 ", reqType3.getOwnedMember("Attribute2"));
					Assert.assertNull("The Stereotype RelationType4 has  id ", reqType4.getOwnedMember("id"));
					Assert.assertNull("The Stereotype RelationType4 has  text ", reqType4.getOwnedMember("text"));
					Assert.assertNotNull("The Stereotype RelationType4 has not attribute1 ", reqType4.getOwnedMember("Attribute1"));
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
		return "models/import/importSpecRelationTypes/";
	}
}
