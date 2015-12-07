/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.migration.rsa.tests.qvt;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.papyrusrt.umlrt.profile.UMLRealTime.Protocol;
import org.eclipse.papyrusrt.umlrt.profile.UMLRealTime.ProtocolContainer;
import org.eclipse.papyrusrt.umlrt.profile.UMLRealTime.RTMessageKind;
import org.eclipse.papyrusrt.umlrt.profile.UMLRealTime.RTMessageSet;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.junit.Assert;
import org.junit.Test;

public class ImportProfilesTest extends AbstractTransformationTest {

	protected void assertIsValidProtocol(Package protocolContainer) {
		String name = protocolContainer.getName();

		Assert.assertNotNull("The package Protocol1 should be stereotyped with ProtocolContainer", UMLUtil.getStereotypeApplication(protocolContainer, ProtocolContainer.class));

		Collaboration protocol = (Collaboration) protocolContainer.getMember(name, false, UMLPackage.eINSTANCE.getCollaboration());
		Assert.assertNotNull("The collaboration Protocol1 should be stereotyped with Protocol", UMLUtil.getStereotypeApplication(protocol, Protocol.class));

		Interface protocolIn = (Interface) protocolContainer.getMember(name, false, UMLPackage.eINSTANCE.getInterface());
		RTMessageSet messageSetIn = UMLUtil.getStereotypeApplication(protocolIn, RTMessageSet.class);
		Assert.assertEquals("The direction of the Protocol1 interface should be 'in'", RTMessageKind.IN, messageSetIn.getRtMsgKind());

		Interface protocolOut = (Interface) protocolContainer.getMember(name + "~", false, UMLPackage.eINSTANCE.getInterface());
		RTMessageSet messageSetOut = UMLUtil.getStereotypeApplication(protocolOut, RTMessageSet.class);
		Assert.assertEquals("The direction of the Protocol1~ interface should be 'out'", RTMessageKind.OUT, messageSetOut.getRtMsgKind());

		Interface protocolInOut = (Interface) protocolContainer.getMember(name + "IO", false, UMLPackage.eINSTANCE.getInterface());
		RTMessageSet messageSetInOut = UMLUtil.getStereotypeApplication(protocolInOut, RTMessageSet.class);
		Assert.assertEquals("The direction of the Protocol1 interface should be 'inOut'", RTMessageKind.IN_OUT, messageSetInOut.getRtMsgKind());
	}


	// customProfile/*
	@Test
	public void testRepairProfiles() throws Exception {
		String path = "resources/customProfile/";
		String profilePath = path + "ProfileUpdates.epx";

		// First, import the Profile
		simpleImport(profilePath, new String[0]);

		// Delete the profile (Avoid side-effect of broken Batch-import, already tested - and failing - in BatchImportTest#testProfiledFragmentedModel)
		mainModelFile.delete(true, new NullProgressMonitor());

		// Import the model
		String modelPath = path + "ProfiledModel.emx";

		simpleImport(modelPath, new String[0], true); // Use batch launcher to ensure profile is repaired

		openEditor();

		assertRSAModelsRemoved(true);

		Class class1 = (Class) rootPackage.getPackagedElement("Class1");
		Stereotype st3 = class1.getAppliedStereotype("ProfileUpdates::Stereotype3");
		Assert.assertNotNull("Class1 should be stereotyped with Stereotype3", st3);

		Interface interface1 = (Interface) rootPackage.getPackagedElement("Interface1");
		Stereotype st5 = interface1.getAppliedStereotype("ProfileUpdates::Stereotype5");
		Assert.assertNotNull("Interface1 should be stereotyped with Stereotype5", st5);
	}

	// ProfiledModel.emx + deployedProfile (Version n - 1: the model is profiled with a newer version than the one deployed)
	@Test
	public void testDeployedProfile() throws Exception {
		String path = "resources/customProfile/";
		String modelPath = path + "ProfiledModel.emx";

		simpleImport(modelPath, new String[0], true); // Use batch launcher to ensure profile is repaired

		openEditor();

		assertRSAModelsRemoved(true);

		Class class1 = (Class) rootPackage.getPackagedElement("Class1");
		Stereotype st3 = class1.getAppliedStereotype("ProfileUpdates::Stereotype3");
		Assert.assertNotNull("Class1 should be stereotyped with Stereotype3", st3);

		Interface interface1 = (Interface) rootPackage.getPackagedElement("Interface1");
		Stereotype st5 = interface1.getAppliedStereotype("ProfileUpdates::Stereotype5"); // Stereotype5 doesn't exist in the deployed version of the profile and should have been removed
		Assert.assertNull("Interface1 should not be stereotyped", st5);
	}
}
