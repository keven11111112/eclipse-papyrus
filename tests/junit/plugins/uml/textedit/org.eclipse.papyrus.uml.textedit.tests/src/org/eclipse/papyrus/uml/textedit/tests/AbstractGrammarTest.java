/*****************************************************************************
 * Copyright (c) 2014 CEA LIST
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.textedit.tests;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.rules.NoTransactionRule;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.Before;
import org.junit.Rule;

public abstract class AbstractGrammarTest<T extends EObject> extends AbstractPapyrusTest {

	protected DefaultXtextDirectEditorConfiguration editor;

	protected XTextEditorTester<T> tester;

	@Rule
	public NoTransactionRule noTransaction = new NoTransactionRule();

	@Before
	public void initEditor() {
		editor = getEditor();
		tester = new XTextEditorTester<T>(editor);
	}

	public <E extends NamedElement> E findElement(Class<E> type, String name) {
		for (E element : EMFHelper.allInstances(getModelResource(), type)) {
			if (element.getName().equals(name)) {
				return element;
			}
		}
		return null;
	}

	protected ResourceSet getResourceSet() {
		return noTransaction.getResourceSet();
	}

	protected Resource getModelResource() {
		return noTransaction.getModelResource();
	}

	public abstract DefaultXtextDirectEditorConfiguration getEditor();

}
