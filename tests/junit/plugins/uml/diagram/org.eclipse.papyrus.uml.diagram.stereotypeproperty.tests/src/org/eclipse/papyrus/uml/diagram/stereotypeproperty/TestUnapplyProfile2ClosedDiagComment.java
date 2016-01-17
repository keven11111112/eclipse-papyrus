/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Francois Le Fevre - francois.le-fevre@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.stereotypeproperty;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.junit.framework.classification.InvalidTest;
import org.eclipse.papyrus.junit.utils.rules.ActiveDiagram;
import org.eclipse.papyrus.junit.utils.rules.ModelSetFixture;
import org.eclipse.papyrus.junit.utils.rules.PapyrusEditorFixture;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpart.AppliedStereotypeEmptyEditPart;
import org.eclipse.papyrus.uml.tools.commands.UnapplyProfileCommand;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.junit.Rule;
import org.junit.Test;

/**
 * Unapply Profile. The comments have to disappear.
 *
 */
@PluginResource({TestUnapplyProfile2ClosedDiagComment.MODEL_DI })
public class TestUnapplyProfile2ClosedDiagComment extends AbstractPapyrusTestCase {

	final static String MODEL_DI = "resource/UnapplyProfileDiagramClosed.di"; //$NON-NLS-1$

	final static String STEREOTYPEDCLASS = "StereotypedClass"; //$NON-NLS-1$
	final static String CLASS1 = "Class1"; //$NON-NLS-1$
	final static String STEREOTYPEDLINK = "StereotypedLink"; //$NON-NLS-1$

	final static String PROFILE = "testProfile"; //$NON-NLS-1$

	//@Rule
	//public final ModelSetFixture fixture = new ModelSetFixture();

	//FIXME may I have multiple rules
	@Rule
	public final PapyrusEditorFixture fixture = new PapyrusEditorFixture();

	@Test
	@InvalidTest
	public void testUnApplyStereotypeApplication() {

		fixture.openDiagram("ClassDiagram");

		//Check initial model
		NamedElement stereotypedClass = fixture.getModel().getOwnedMember(STEREOTYPEDCLASS);
		assertNotNull("stereotypedClass is null", stereotypedClass);

		NamedElement stereotypedLink = fixture.getModel().getOwnedMember(STEREOTYPEDLINK);
		assertNotNull("stereotypedLink is null", stereotypedLink);
		boolean isPresent=false;
		//Check initial model
		EditPart stereotypedClassEditPart = fixture.findEditPart(stereotypedClass);
		for(Object o : stereotypedClassEditPart.getChildren()){
			if(o instanceof AppliedStereotypeEmptyEditPart){
				isPresent=true;
			}
		}
		assertTrue(STEREOTYPEDCLASS+" do not refer to any AppliedStereotypeEmptyEditPart comment", isPresent); //$NON-NLS-1$
		
		EditPart stereotypedLinkEditPart = fixture.findEditPart(stereotypedLink);
		isPresent=false;
		for(Object o : stereotypedLinkEditPart.getChildren()){
			if(o instanceof AppliedStereotypeEmptyEditPart){
				isPresent=true;
			}
		}
		assertTrue(STEREOTYPEDLINK+" do not refer to any AppliedStereotypeEmptyEditPart comment", isPresent); //$NON-NLS-1$
		
		fixture.closeDiagram("ClassDiagram");

		//Remove the stereotypes
		TransactionalEditingDomain domain = fixture.getEditingDomain();
		EList<Profile> profiles= fixture.getModel().getAllAppliedProfiles();
		for(Profile profile : profiles){
			if(PROFILE.equals(profile.getName())){
				fixture.execute(new UnapplyProfileCommand(fixture.getModel(), profile, domain));
			}
		}
		
		fixture.openDiagram("ClassDiagram");
		//check the final model
		isPresent=false;
		for(Object ee : stereotypedClassEditPart.getChildren()){
			EditPart a = (EditPart)ee;
			if(a instanceof AppliedStereotypeEmptyEditPart){
				isPresent=true;
			}
		}
		assertTrue(STEREOTYPEDCLASS+" still refer to a AppliedStereotypeEmptyEditPart comment", !isPresent); //$NON-NLS-1$
		//List of EditPart
		isPresent=false;
		for(Object ee : stereotypedLinkEditPart.getChildren()){
			EditPart a = (EditPart)ee;
			if(a instanceof AppliedStereotypeEmptyEditPart){
				isPresent=true;
			}
		}
		assertTrue(STEREOTYPEDLINK+" still refer to a AppliedStereotypeEmptyEditPart comment", !isPresent); //$NON-NLS-1$
		
	}
}
