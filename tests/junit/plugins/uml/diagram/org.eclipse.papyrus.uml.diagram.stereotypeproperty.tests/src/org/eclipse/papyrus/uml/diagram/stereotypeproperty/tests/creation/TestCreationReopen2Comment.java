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
 *   Francois Le Fevre  francois.le-fevre@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.stereotypeproperty.tests.creation;

import static org.junit.Assert.assertTrue;

import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.junit.utils.rules.ActiveDiagram;
import org.eclipse.papyrus.junit.utils.rules.PapyrusEditorFixture;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpart.AppliedStereotypeEmptyEditPart;
import org.eclipse.papyrus.uml.diagram.tests.canonical.AbstractPapyrusTestCase;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.Rule;
import org.junit.Test;


/**
 * Display stereotype directly as Sterotyped has been already displayed, normaly you have to see in "comment shape"
 */
@PluginResource({ TestCreationReopen2Comment.MODEL_DI })
public class TestCreationReopen2Comment extends AbstractPapyrusTestCase {
	/** name of the test project */
	public final String PROJECT_NAME = "StereotypeTestProject";

	/** name of the test model */
	public final String FILE_NAME = "StereotypeTest.di";

	final static String MODEL_DI = "resource/ReopenFile.di"; //$NON-NLS-1$

	final static String STEREOTYPEDCLASS = "StereotypedClass"; //$NON-NLS-1$
	final static String CLASS1 = "Class1"; //$NON-NLS-1$
	final static String STEREOTYPEDLINK = "StereotypedLink"; //$NON-NLS-1$

	final static String PROFILE = "testProfile"; //$NON-NLS-1$

	private IMultiDiagramEditor editor;

	@Rule
	public final PapyrusEditorFixture fixture = new PapyrusEditorFixture();


	@Test
	@ActiveDiagram("ClassDiagram")
	public void testUnApplyStereotypeApplication() {

		editor = fixture.getEditor(MODEL_DI);
		fixture.openDiagram("ClassDiagram"); //$NON-NLS-1$
		boolean isPresent = false;
		// Check initial model
		NamedElement stereotypedClass = fixture.getModel().getOwnedMember(STEREOTYPEDCLASS);
		EditPart stereotypedClassEditPart = fixture.findEditPart(stereotypedClass);
		for (Object o : stereotypedClassEditPart.getChildren()) {
			if (o instanceof AppliedStereotypeEmptyEditPart) {
				isPresent = true;
			}
		}
		assertTrue(STEREOTYPEDCLASS + " do not refer to any AppliedStereotypeEmptyEditPart comment", isPresent); //$NON-NLS-1$

		NamedElement stereotypedLink = fixture.getModel().getOwnedMember(STEREOTYPEDLINK);
		EditPart stereotypedLinkEditPart = fixture.findEditPart(stereotypedLink);
		isPresent = false;
		for (Object o : stereotypedLinkEditPart.getChildren()) {
			if (o instanceof AppliedStereotypeEmptyEditPart) {
				isPresent = true;
			}
		}
		assertTrue(STEREOTYPEDLINK + " do not refer to any AppliedStereotypeEmptyEditPart comment", isPresent); //$NON-NLS-1$

	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.tests.canonical.AbstractPapyrusTestCase#getDiagramCommandCreation()
	 *
	 * @return
	 */
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateClassDiagramCommand();
	}


	/**
	 * @see org.eclipse.papyrus.uml.diagram.tests.canonical.AbstractPapyrusTestCase#getProjectName()
	 *
	 * @return
	 */
	@Override
	protected String getProjectName() {
		return PROJECT_NAME;
	}


	/**
	 * @see org.eclipse.papyrus.uml.diagram.tests.canonical.AbstractPapyrusTestCase#getFileName()
	 *
	 * @return
	 */
	@Override
	protected String getFileName() {
		return FILE_NAME;
	}

}
