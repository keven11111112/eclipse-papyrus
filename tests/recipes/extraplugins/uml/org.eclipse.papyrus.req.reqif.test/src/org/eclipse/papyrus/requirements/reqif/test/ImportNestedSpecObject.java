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

public class ImportNestedSpecObject extends AbstractReqIFTest {

	@Test
	public void importNestedSpecObject() {
		//loading
		//now launch a class diagram
		try {
			UserRegistry.instance.setCurrentUser(new SampleUser());
			initModel("ImportReqIFProject", "importSpecObject", getBundle());
			getReqIFFile("SubSpecObject.reqif");
			openDiagram(editor, "ClassDiagram");
			final DiagramEditPart diagramEditPart = editor.getAdapter(DiagramEditPart.class);
			Assert.assertNotNull("The diagram must be opened", diagramEditPart);
			RecordingCommand cmd = new RecordingCommand(getTransactionalEditingDomain(), "importReqIF") {

				@Override
				protected void doExecute() {
					//launch import
					Package root = (Package)diagramEditPart.resolveSemanticElement();
					ReqIFImporter sysMLReqIFTransfomation = new ReqIFImporterServiceEdit(domain, importedReqIFModel, root);
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
					Assert.assertNotNull("The Stereotype ReqType1 has not been imported", theprofile.getOwnedMember("ReqType1"));
					Assert.assertNotNull("The Stereotype ReqType2 has not been imported", theprofile.getOwnedMember("ReqType2"));
					Assert.assertNotNull("The Stereotype ReqType3 has not been imported", theprofile.getOwnedMember("ReqType3"));
					Assert.assertNotNull("The Stereotype ReqType4 has not been imported", theprofile.getOwnedMember("ReqType4"));
					Assert.assertNotNull("The Stereotype ReqType5 has not been imported", theprofile.getOwnedMember("ReqType5"));
					Stereotype reqType1 = (Stereotype)theprofile.getMember("ReqType1");
					Stereotype reqType2 = (Stereotype)theprofile.getMember("ReqType2");
					Stereotype reqType3 = (Stereotype)theprofile.getMember("ReqType3");
					Stereotype reqType4 = (Stereotype)theprofile.getMember("ReqType4");
					Stereotype reqType5 = (Stereotype)theprofile.getMember("ReqType5");
					Assert.assertNull("The Stereotype reqType1 has  id ", reqType1.getOwnedMember("id"));
					Assert.assertNull("The Stereotype reqType1 has  text ", reqType1.getOwnedMember("text"));
					Assert.assertNotNull("The Stereotype reqType1 has not attribute1 ", reqType1.getOwnedMember("Attribute1"));
					Assert.assertNull("The Stereotype reqType2 has  id ", reqType2.getOwnedMember("id"));
					Assert.assertNull("The Stereotype reqType2 has  text ", reqType2.getOwnedMember("text"));
					Assert.assertNotNull("The Stereotype reqType2 has not attribute1", reqType2.getOwnedMember("Attribute1"));
					Assert.assertNull("The Stereotype reqType3 has  id ", reqType3.getOwnedMember("id"));
					Assert.assertNull("The Stereotype reqType3 has  text ", reqType3.getOwnedMember("text"));
					Assert.assertNotNull("The Stereotype reqType3 has not attribute1 ", reqType3.getOwnedMember("Attribute1"));
					Assert.assertNull("The Stereotype reqType4 has  id ", reqType4.getOwnedMember("id"));
					Assert.assertNull("The Stereotype reqType4 has  text ", reqType4.getOwnedMember("text"));
					Assert.assertNotNull("The Stereotype reqType4 has not attribute1 ", reqType4.getOwnedMember("Attribute1"));
					Assert.assertNull("The Stereotype ReqType0 has id  ", reqType5.getOwnedMember("id"));
					Assert.assertNull("The Stereotype ReqType0 has  text ", reqType5.getOwnedMember("text"));
					Assert.assertNotNull("The Stereotype reqType3 has not attribute1 ", reqType5.getOwnedMember("Attribute1"));
					Assert.assertNotNull("The Stereotype reqType3 has not attribute2 ", reqType5.getOwnedMember("Attribute2"));
					//test the model
					Assert.assertNotNull("The model must contain a sub package SysML", root.getOwnedMember("SysMLmodel"));
					Package generatedPackage = (Package)root.getOwnedMember("SysMLmodel");
					Assert.assertNotNull("The model must contain a requirement 1", generatedPackage.getOwnedMember("1"));
					org.eclipse.uml2.uml.Class req1 = (org.eclipse.uml2.uml.Class)generatedPackage.getOwnedMember("1");
					Assert.assertNotNull("The req1 must contain a requirement 2", req1.getOwnedMember("2"));
					org.eclipse.uml2.uml.Class req2 = (org.eclipse.uml2.uml.Class)req1.getOwnedMember("2");
					Assert.assertNotNull("The req1 must contain a requirement 5", req1.getOwnedMember("5"));
					org.eclipse.uml2.uml.Class req5 = (org.eclipse.uml2.uml.Class)req1.getOwnedMember("5");
					Assert.assertNotNull("The req2 must contain a requirement 3", req2.getOwnedMember("3"));
					Assert.assertNotNull("The req2 must contain a requirement 4", req2.getOwnedMember("4"));
					Assert.assertNotNull("The req5 must contain a requirement 6", req5.getOwnedMember("6"));
					org.eclipse.uml2.uml.Class req6 = (org.eclipse.uml2.uml.Class)req5.getOwnedMember("6");
					Assert.assertNotNull("The req6 must contain a requirement 7", req6.getOwnedMember("7"));
					org.eclipse.uml2.uml.Class req7 = (org.eclipse.uml2.uml.Class)req6.getOwnedMember("7");
					Assert.assertNotNull("The req7 must contain a requirement 8", req7.getOwnedMember("8"));
					org.eclipse.uml2.uml.Class req8 = (org.eclipse.uml2.uml.Class)req7.getOwnedMember("8");
					Assert.assertNotNull("The req8 must contain a requirement 9", req8.getOwnedMember("9"));
					Assert.assertNotNull("The req8 must contain a requirement 9", req8.getOwnedMember("10"));
				}
			};
			getTransactionalEditingDomain().getCommandStack().execute(cmd);
		} catch (Exception e) {
			Assert.assertTrue("The test is not valided because of an exception " + e, false);
			e.printStackTrace();
		}
	}

	/**
	 * @see org.eclipse.papyrus.junit.utils.tests.AbstractEditorTest#getSourcePath()
	 * @return
	 */
	@Override
	protected String getSourcePath() {
		return "models/import/subRequirement/";
	}
}
