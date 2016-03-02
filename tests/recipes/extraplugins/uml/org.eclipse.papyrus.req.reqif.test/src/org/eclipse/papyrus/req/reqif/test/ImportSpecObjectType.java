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
package org.eclipse.papyrus.req.reqif.test;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.papyrus.req.reqif.integration.transformation.ReqIFImporterServiceEdit;
import org.eclipse.papyrus.req.reqif.transformation.ReqIFImporter;
import org.eclipse.papyrus.req.reqif.user.SampleUser;
import org.eclipse.papyrus.req.reqif.user.UserRegistry;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Assert;
import org.junit.Test;

public class ImportSpecObjectType extends AbstractReqIFTest {

	@Test
	public void importSpecObjectType() {
		//loading
		//now launch a class diagram
		try {
			UserRegistry.instance.setCurrentUser(new SampleUser());
			initModel("ImportReqIFProject", "importSpecObjectType", getBundle());
			getReqIFFile("specObjectTypes.reqif");
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
					Assert.assertNotNull("The enumeration ReqType0 has not been imported", theprofile.getMember("ReqType0"));
					Assert.assertNotNull("The enumeration ReqType1 has not been imported", theprofile.getMember("ReqType1"));
					Assert.assertNotNull("The enumeration ReqType2 has not been imported", theprofile.getMember("ReqType2"));
					Assert.assertNotNull("The enumeration ReqType3 has not been imported", theprofile.getMember("ReqType3"));
					Assert.assertNotNull("The enumeration ReqType3 has not been imported", theprofile.getMember("ReqType4"));
					Stereotype reqType0 = (Stereotype)theprofile.getMember("ReqType0");
					Stereotype reqType1 = (Stereotype)theprofile.getMember("ReqType1");
					Stereotype reqType2 = (Stereotype)theprofile.getMember("ReqType2");
					Stereotype reqType3 = (Stereotype)theprofile.getMember("ReqType3");
					Stereotype reqType4 = (Stereotype)theprofile.getMember("ReqType4");
					Assert.assertNull("The Stereotype ReqType0 has id  ", reqType0.getOwnedMember("id"));
					Assert.assertNull("The Stereotype ReqType0 has  text ", reqType0.getOwnedMember("text"));
					Assert.assertNotNull("The Stereotype ReqType0 has not attribute1 ", reqType0.getOwnedMember("Attribute1"));
					Assert.assertNull("The Stereotype reqType1 has  id ", reqType1.getOwnedMember("id"));
					Assert.assertNull("The Stereotype reqType1 has  text ", reqType1.getOwnedMember("text"));
					Assert.assertNotNull("The Stereotype reqType1 has not attribute1 ", reqType1.getOwnedMember("Attribute1"));
					Assert.assertNull("The Stereotype reqType2 has  id ", reqType2.getOwnedMember("id"));
					Assert.assertNull("The Stereotype reqType2 has  text ", reqType2.getOwnedMember("text"));
					Assert.assertNotNull("The Stereotype reqType2 has not attribute1", reqType2.getOwnedMember("Attribute1"));
					Assert.assertNull("The Stereotype reqType3 has  id ", reqType3.getOwnedMember("id"));
					Assert.assertNull("The Stereotype reqType3 has  text ", reqType3.getOwnedMember("text"));
					Assert.assertNotNull("The Stereotype reqType3 has not attribute1 ", reqType3.getOwnedMember("Attribute1"));
					Assert.assertNotNull("The Stereotype reqType3 has not attribute2 ", reqType3.getOwnedMember("Attribute2"));
					Assert.assertNull("The Stereotype reqType4 has  id ", reqType4.getOwnedMember("id"));
					Assert.assertNull("The Stereotype reqType4 has  text ", reqType4.getOwnedMember("text"));
					Assert.assertNotNull("The Stereotype reqType4 has not attribute1 ", reqType4.getOwnedMember("Attribute1"));
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
		return "models/import/importSpecObjectTypes/";
	}
}
