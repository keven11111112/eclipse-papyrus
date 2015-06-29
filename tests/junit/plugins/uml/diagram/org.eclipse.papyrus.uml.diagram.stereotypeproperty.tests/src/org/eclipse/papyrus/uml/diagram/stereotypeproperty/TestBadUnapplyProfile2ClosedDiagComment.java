/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Francois Le Fevre  francois.le-fevre@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.stereotypeproperty;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.junit.utils.rules.ActiveDiagram;
import org.eclipse.papyrus.junit.utils.rules.PapyrusEditorFixture;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpart.AppliedStereotypeEmptyEditPart;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.Rule;
import org.junit.Test;


/**
 *  The bad profile has been unapplied with the UML editor. The comments have to disappear.
 *
 */
@PluginResource({TestBadUnapplyProfile2ClosedDiagComment.MODEL_DI })
public class TestBadUnapplyProfile2ClosedDiagComment extends AbstractPapyrusTestCase {

	final static String MODEL_DI = "resource/BadUnapplyProfile.di"; //$NON-NLS-1$

	final static String STEREOTYPEDCLASS = "StereotypedClass"; //$NON-NLS-1$
	final static String CLASS1 = "Class1"; //$NON-NLS-1$
	final static String STEREOTYPEDLINK = "StereotypedLink"; //$NON-NLS-1$

	final static String PROFILE = "testProfile"; //$NON-NLS-1$

	@Rule
	public final PapyrusEditorFixture fixture = new PapyrusEditorFixture();


	@Test
	@ActiveDiagram("ClassDiagram")
	public void testUnApplyStereotypeApplication() {

		fixture.openDiagram("ClassDiagram"); //$NON-NLS-1$

		//Check initial model
		NamedElement stereotypedClass = fixture.getModel().getOwnedMember(STEREOTYPEDCLASS);
		EditPart stereotypedClassEditPart = fixture.findEditPart(stereotypedClass);
		for(Object o : stereotypedClassEditPart.getChildren()){
			if(o instanceof AppliedStereotypeEmptyEditPart){
				assertTrue(STEREOTYPEDCLASS+" do not refer to any AppliedStereotypeEmptyEditPart comment", true); //$NON-NLS-1$
			}
		}
		//List of EditPart
		//ClassNameEditPart
		//ClassAttributeCompartmentEditPart
		//ClassOperationCompartmentEditPart
		//ClassnestedclassifierCompartemtnEditPart
		//ClassFloatingNameEditPart
		assertEquals(STEREOTYPEDCLASS + " has not the right number of children", 5, stereotypedClassEditPart.getChildren().size()); //$NON-NLS-1$

		NamedElement stereotypedLink = fixture.getModel().getOwnedMember(STEREOTYPEDLINK);
		EditPart stereotypedLinkEditPart = fixture.findEditPart(stereotypedLink);
		for(Object o : stereotypedLinkEditPart.getChildren()){
			if(o instanceof AppliedStereotypeEmptyEditPart){
				assertTrue(STEREOTYPEDLINK+" do not refer to any AppliedStereotypeEmptyEditPart comment", true); //$NON-NLS-1$
			}
		}
		//List of EditPart
		//DependencyNameEditPart
		//AppliedStereotypeDependencyEditPart
		assertEquals(STEREOTYPEDLINK + " has not the right number of children", 2, stereotypedLinkEditPart.getChildren().size()); //$NON-NLS-1$
	}


}
