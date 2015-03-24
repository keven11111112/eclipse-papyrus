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
package org.eclipse.papyrus.uml.alf.properties.xtext.parser;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.alf.properties.xtext.configuration.AbstractAlfXtextEditorConfiguration;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Provide the possibility to use the ALF parser directly in the context of GMF.
 */
public class GMFAlfParser implements IParser {

	protected final static String TEXTUAL_REPRESENTATION_ERROR = "/*String representation could not be computed*/";

	protected final EObject semanticObject;

	protected AbstractAlfXtextEditorConfiguration configuration;

	/**
	 * Retrieve the NamedElement hidden behind the adapter
	 * 
	 * @param adaptable
	 * @return the adapted element
	 */
	protected NamedElement adapt(IAdaptable adaptable) {
		Object o = EMFHelper.getEObject(adaptable);
		if (o != null && o instanceof NamedElement) {
			return (NamedElement) o;
		}
		return null;
	}

	/**
	 * Initializes the context in which type names are going to be resolved
	 */

	public GMFAlfParser(final EObject semanticObject, final AbstractAlfXtextEditorConfiguration configuration) {
		this.semanticObject = semanticObject;
		this.configuration = configuration;
	}

	/***
	 * Delegate computation of the textual representation to the configuration
	 */
	public String getEditString(IAdaptable element, int flags) {
		NamedElement target = this.adapt(element);
		if (target != null) {
			return this.configuration.getEditString(target);
		} else if (this.semanticObject != null) {
			return this.configuration.getEditString(this.semanticObject);
		} else {
			return TEXTUAL_REPRESENTATION_ERROR;
		}
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.EDITABLE_STATUS;
	}

	/**
	 * Delegate creation of the parse command to the configuration
	 */
	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		NamedElement target = this.adapt(element);
		if (target != null) {
			return this.configuration.getParseCommand(newString, target, null);
		} else if (this.semanticObject != null) {
			return this.configuration.getParseCommand(newString, this.semanticObject, null);
		} else {
			return null;
		}
	}

	/**
	 * No differences between results returned by getPrintString or getEditString
	 */
	public String getPrintString(IAdaptable element, int flags) {
		return this.getEditString(element, flags);
	}

	public boolean isAffectingEvent(Object event, int flags) {
		return false;
	}

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

}
