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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.uml.textedit.valuespecification.tests.rules.NoTransactionRule;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.Before;
import org.junit.Rule;

/**
 * This define the abstract grammar test used to declare an xtext grammar tester.
 * 
 * @param <T>
 *            The EObject
 */
public abstract class AbstractGrammarTest<T extends EObject> extends AbstractPapyrusTest {

	/**
	 * The xtext direct editor configuration used.
	 */
	protected DefaultXtextDirectEditorConfiguration editor;

	/**
	 * The xtext editor tester.
	 */
	protected XTextEditorTester<T> tester;

	/**
	 * The rule used.
	 */
	@Rule
	public NoTransactionRule noTransaction = new NoTransactionRule();

	/**
	 * This allow to initialize the editor.
	 */
	@Before
	public void initEditor() {
		editor = getEditor();
		tester = new XTextEditorTester<T>(editor);
	}

	/**
	 * This allow to find an element in the model.
	 * 
	 * @param type
	 *            The type of element to search.
	 * @param name
	 *            The name of element to search.
	 * @return The element find in the model of <code>null</code>.
	 */
	public <E extends NamedElement> E findElement(final Class<E> type, final String name) {
		for (E element : EMFHelper.allInstances(getModelResource(), type)) {
			if (element.getName().equals(name)) {
				return element;
			}
		}
		return null;
	}

	/**
	 * Get the resource set.
	 * 
	 * @return The resource set.
	 */
	protected ResourceSet getResourceSet() {
		return noTransaction.getResourceSet();
	}

	/**
	 * Get the model resource.
	 * 
	 * @return The model resource.
	 */
	protected Resource getModelResource() {
		return noTransaction.getModelResource();
	}

	/**
	 * This allow to define the xtext direct editor configuration used to parse.
	 * 
	 * @return The xtext direct editor configuration used.
	 */
	public abstract DefaultXtextDirectEditorConfiguration getEditor();

}
