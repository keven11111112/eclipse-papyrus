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


import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ImportModelsTest extends AbstractTransformationTest {


	// resources/fragments/*
	@Test
	public void testFragments() throws Exception {

		String path = "resources/fragments/";

		String mainFile = path + "Blank Package.emx";

		String[] additionalFiles = new String[] {
				path + "Class3.efx",
				path + "Interface - Fragment.efx",
				path + "Package - Fragment.efx"
		};

		simpleImport(mainFile, additionalFiles);

		openEditor();

		// Fragments should have been moved to the proper resource
		Package fragmentPackage = (Package) rootPackage.getMember("Package - Fragment");
		Assert.assertEquals("Package - Fragment.uml", URI.decode(EcoreUtil.getURI(fragmentPackage).lastSegment()));
		Assert.assertEquals("_0OuW4LZ7EeOu-9meM8ButQ", EcoreUtil.getURI(fragmentPackage).fragment()); // The XMI ID should be unchanged

		Class class3 = (Class) fragmentPackage.getMember("Class3");
		Assert.assertEquals("Class3.uml", EcoreUtil.getURI(class3).lastSegment());
		Assert.assertEquals("_ONlFkLZ8EeOu-9meM8ButQ", EcoreUtil.getURI(class3).fragment()); // The XMI ID should be unchanged

		// Diagrams associated to fragmented elements should have been moved to their own notation resource

		ModelSet modelSet = ServiceUtils.getInstance().getModelSet(editor.getServicesRegistry());
		String NotationResourcePath = (mainModelFile.getFullPath().removeLastSegments(1).append("Package - Fragment.notation")).toString();
		Resource fragmentPackageNotationResource = modelSet.getResource(URI.createPlatformResourceURI(NotationResourcePath, true), true);
		Assert.assertEquals(2, fragmentPackageNotationResource.getContents().size());

	}

	// resources/parameters/*
	@Test
	@Ignore("Not yet implemented")
	public void testTransformationParameters() throws Exception {

	}

	// Bug 459488
	// resources/anytypeReferences/*
	@Test
	public void testImportProfileReferences() throws Exception {
		String path = "resources/anytypeReferences/";
		String mainFile = path + "Blank Package.emx";
		String[] additionalFiles = new String[] {
				path + "ModelFragment_1.efx",
				path + "ModelFragment_2.efx",
				path + "ModelFragment_3.efx"
		};

		simpleImport(mainFile, additionalFiles, true);

		openEditor();

		Package fragments = rootPackage.getNestedPackage("Fragments");
		Class refOne = (Class) fragments.getOwnedType("RefOne");
		Class refMultiple = (Class) fragments.getOwnedType("RefMultiple");
		Class refMixed = (Class) fragments.getOwnedType("RefMixed");

		Stereotype st1 = refOne.getAppliedStereotype("Profile::Stereotype1");
		Stereotype st2 = refMultiple.getAppliedStereotype("Profile::Stereotype2");
		Stereotype st3 = refMixed.getAppliedStereotype("Profile::Stereotype2");

		Class referencedClass1 = (Class) refOne.getValue(st1, "class");
		Assert.assertNotNull("The reference to Class has disappeared", referencedClass1);
		Assert.assertFalse("The reference to Class cannot be resolved", referencedClass1.eIsProxy());

		List<?> referencedClasses = (List<?>) refMultiple.getValue(st2, "class");
		Assert.assertEquals("There should be 4 references to classes", 4, referencedClasses.size());
		for (Object value : referencedClasses) {
			EObject referencedObject = (EObject) value;
			Assert.assertFalse("The referenced element is not resolved", referencedObject.eIsProxy());
		}

		List<?> referencedClasses2 = (List<?>) refMixed.getValue(st3, "class");
		Assert.assertEquals("There should be 7 references to classes", 7, referencedClasses2.size());
		for (Object value : referencedClasses2) {
			EObject referencedObject = (EObject) value;
			Assert.assertFalse("The referenced element is not resolved", referencedObject.eIsProxy());
		}
	}


}
