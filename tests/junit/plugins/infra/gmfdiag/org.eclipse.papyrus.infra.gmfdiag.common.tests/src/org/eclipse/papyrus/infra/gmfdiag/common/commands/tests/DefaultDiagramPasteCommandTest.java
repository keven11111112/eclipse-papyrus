/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.commands.tests;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.command.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.DefaultDiagramCopyCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.DefaultDiagramPasteCommand;
import org.eclipse.papyrus.junit.utils.rules.ActiveDiagram;
import org.eclipse.papyrus.junit.utils.rules.PapyrusEditorFixture;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for the {@link DefaultDiagramPasteCommand} class.
 */
@PluginResource("models/ExpansionModelTest.di")
@ActiveDiagram("NewDiagram")
public class DefaultDiagramPasteCommandTest {

	private final PapyrusEditorFixture editor = new PapyrusEditorFixture();

	@Rule
	public final CustomUMLFactoryFixture fixture = new CustomUMLFactoryFixture(editor);

	@Rule
	public final PapyrusClipboardFixture clipboard = new PapyrusClipboardFixture();

	@Test
	public void pasteElement() {
		org.eclipse.uml2.uml.Class myClass = (org.eclipse.uml2.uml.Class) editor.getModel().getOwnedType("MyClass");
		IGraphicalEditPart editPart = (IGraphicalEditPart) editor.findEditPart(myClass);

		Command copy = new DefaultDiagramCopyCommand(editor.getEditingDomain(), clipboard, singletonList(editPart));

		fixture.execute(copy);

		ICommand paste = new DefaultDiagramPasteCommand(editor.getEditingDomain(), "Paste", clipboard, editor.getActiveDiagram());

		// The copied class has its name set via a structural feature setting
		fixture.assertInvocation("eSetting");

		fixture.execute(paste);

		// Find the copy
		List<String> typeNamesLikeMyClass = editor.getModel().getOwnedTypes().stream()
				.map(NamedElement::getName)
				.filter(containsString(myClass.getName())::matches)
				.collect(Collectors.toList());
		assertThat(typeNamesLikeMyClass.size(), is(2));
	}

}
