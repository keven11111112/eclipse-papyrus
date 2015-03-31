/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.valuespecification.tests;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;

/**
 * The generic xtext editor tester.
 *
 * @param <T>
 *            The EObject to parse.
 */
public class XTextEditorTester<T extends EObject> {

	/**
	 * The xtext direct editor configuration used.
	 */
	protected DefaultXtextDirectEditorConfiguration editor;

	/**
	 * Constructor.
	 *
	 * @param editor
	 *            The xtext direct editor configuration used.
	 */
	public XTextEditorTester(final DefaultXtextDirectEditorConfiguration editor) {
		this.editor = editor;
	}

	/**
	 * This allow to parse text for the parent element.
	 * 
	 * @param parentElement
	 *            The parent element.
	 * @param initialElement
	 *            The initial element or the structural feature.
	 * @param textToParse
	 *            The text to parse.
	 * @return The initial element modified depending of the text parser.
	 * @throws Exception
	 *             All the exception for the parser.
	 */
	public T parseText(final EObject parentElement, final T initialElement, final String textToParse) throws Exception {
		IParser parser = editor.createParser(parentElement);
		ICommand parseCommand = parser.getParseCommand(new EObjectAdapter(initialElement), textToParse, 0);
		if (null != parseCommand) {
			parseCommand.execute(new NullProgressMonitor(), null);
		}

		return initialElement;
	}

	/**
	 * Get the initial text corresponding to the element.
	 * 
	 * @param element
	 *            The element to parse to string.
	 * @return The text representing the element.
	 */
	public String getInitialText(final Object element) {
		return editor.getTextToEdit(element);
	}

}
