/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Jérémie Tatibouet
 *  Arnaud Cuccuru
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.properties.xtext.configuration;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.uml.alf.text.generation.DefaultEditStringRetrievalStrategy;
import org.eclipse.papyrus.uml.alf.text.representation.AlfTextualRepresentation;
import org.eclipse.papyrus.uml.alf.transaction.commands.AlfCommandFactory;
import org.eclipse.papyrus.uml.xtext.integration.XtextFakeResourceContext;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProvider;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProviderWithInit;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;

/**
 * Configuration used by the DirectEditor for Alf
 */
public class DefaultAlfXtextEditorConfiguration extends
		AbstractAlfXtextEditorConfiguration {

	/**
	 * Called each time the editor using the configuration is refreshed
	 * 
	 * @param semanticObject
	 * @return the textual representation of a specific semantic object
	 */
	@Override
	public String getEditString(EObject semanticObject) {
		this.updateAlfModelContext(semanticObject);
		return new DefaultEditStringRetrievalStrategy().getEditString((NamedElement) semanticObject);
	}

	/**
	 * Build the parse command required to launch the compilation of the textual representation (only if it has no syntax errors).
	 * 
	 */
	@Override
	public ICommand getParseCommand(String textualRepresentation,
			EObject semanticObject, EObject xtextObject) {
		AlfTextualRepresentation representation = new AlfTextualRepresentation((NamedElement) semanticObject);
		IContextElementProvider provider = this.getContextProvider();
		XtextFakeResourceContext context = new XtextFakeResourceContext(this.getInjector());
		context.getFakeResource().eAdapters().add(new ContextElementAdapter(provider));
		try {
			context.getFakeResource().load(new StringInputStream(textualRepresentation), Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (provider instanceof IContextElementProviderWithInit) {
			((IContextElementProviderWithInit) provider).initResource(context.getFakeResource());
		}
		EcoreUtil2.resolveLazyCrossReferences(context.getFakeResource(), CancelIndicator.NullImpl);
		return new EMFtoGMFCommandWrapper(AlfCommandFactory.getInstance().createCompilationCommand(representation));
	}
}