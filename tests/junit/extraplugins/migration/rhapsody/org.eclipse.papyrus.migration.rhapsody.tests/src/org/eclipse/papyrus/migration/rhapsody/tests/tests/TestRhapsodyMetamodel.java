/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.migration.rhapsody.tests.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;
import org.junit.Assert;
import org.junit.Test;

/**
 * This class tests Rhapsody metamodel properties for which we are sure of them
 *
 */
@SuppressWarnings("nls")
public class TestRhapsodyMetamodel {

	/**
	 * the list of the elements which must not have the displayName feature (partial list)
	 */
	private static final List<EClass> withoutDisplayNameFeature = new ArrayList<EClass>();

	/**
	 * the list of the elements which must not have the displayName feature (partial list)
	 */
	private static final List<EClass> withDisplayNameFeature = new ArrayList<EClass>();


	static {
//		withoutDisplayNameFeature.add(UMLRhapsodyPackage.eINSTANCE.getIAssociationEnd());
		
		withDisplayNameFeature.add(UMLRhapsodyPackage.eINSTANCE.getIAssociationEnd());
		withDisplayNameFeature.add(UMLRhapsodyPackage.eINSTANCE.getIObjectLink());
		withDisplayNameFeature.add(UMLRhapsodyPackage.eINSTANCE.getIInformationFlow());
		withDisplayNameFeature.add(UMLRhapsodyPackage.eINSTANCE.getIType());
	}

	/**
	 * Check objects for which we are sure they must not have the displayName feature
	 */
	@Test
	public void testObjectWithoutDisplayNameFeature() {
		for (EClass current : withoutDisplayNameFeature) {
			Assert.assertFalse("The eClass " + current.getName() + " must not contain a feature called " + UMLRhapsodyPackage.eINSTANCE.getIModelElement_DisplayName().getName() + ".",
					current.getEAllStructuralFeatures().contains(UMLRhapsodyPackage.eINSTANCE.getIModelElement_DisplayName()));
		}
	}

	/**
	 * Check objects for which we are sure they must have the displayName feature
	 */
	@Test
	public void textObjectWithDisplayNameFeature() {
		for (EClass current : withDisplayNameFeature) {
			Assert.assertTrue("The eClass " + current.getName() + " must contain a feature called " + UMLRhapsodyPackage.eINSTANCE.getIModelElement_DisplayName().getName() + ".",
					current.getEAllStructuralFeatures().contains(UMLRhapsodyPackage.eINSTANCE.getIModelElement_DisplayName()));
		}
	}

}
