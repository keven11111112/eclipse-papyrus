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
 *  Jeremie Tatibouet
 *  Arnaud Cuccuru
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.properties.xtext.configuration;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.alf.impl.ModelNamespaceImpl;
import org.eclipse.papyrus.uml.alf.libraries.helper.AlfUtil;
import org.eclipse.papyrus.uml.alf.libraries.helper.BackupUtil;
import org.eclipse.papyrus.uml.alf.parser.antlr.MutableAlfParser;
import org.eclipse.papyrus.uml.alf.ui.internal.AlfActivator;
import org.eclipse.papyrus.uml.alf.properties.xtext.parser.GMFAlfParser;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

import com.google.inject.Injector;

public abstract class AbstractAlfXtextEditorConfiguration extends DefaultXtextDirectEditorConfiguration {

	private void loadProfiles(Element context) {
		AlfUtil alfProfileHelper = AlfUtil.getInstance();
		BackupUtil backupProfileHelper = BackupUtil.getInstance();
		if (!alfProfileHelper.isActionLanguageProfileApplied(context)) {
			alfProfileHelper.applyActionLanguageProfile(context);
		}
		if (!backupProfileHelper.isBackupProfileApplied(context)) {
			backupProfileHelper.applyBackupProfile(context);
		}
	}

	/**
	 * Update the context in which the Alf representation will be validated.
	 * The context is the namespace of the editedObject if any
	 * 
	 * @param editedObject
	 */
	protected void updateAlfModelContext(EObject editedObject) {
		if (editedObject instanceof NamedElement) {
			NamedElement element = (NamedElement) editedObject;
			ModelNamespaceImpl.setContext(element.getNamespace());
			this.loadProfiles(element);
		}
	}

	/**
	 * Provide the injector with the location of the implementation of the Alf Language
	 */
	@Override
	public Injector getInjector() {
		return AlfActivator.getInstance().getInjector(AlfActivator.ORG_ECLIPSE_PAPYRUS_UML_ALF_ALF);
	}

	/**
	 * Provide a GMF wrapped parser
	 */
	public IParser createParser(final EObject semanticObject) {
		return new GMFAlfParser(semanticObject, this);
	}

	/**
	 * Not used - see GMFCompatibleAlfParser
	 */
	public String getEditString(IAdaptable element, int flags) {
		return null;
	}

	/**
	 * Not used - see GMFCompatibleAlfParser
	 */
	@Override
	protected ICommand getParseCommand(EObject umlObject, EObject xtextObject) {
		return null;
	}

	/**
	 * Executed before the editor opens
	 */
	public Object preEditAction(Object objectToEdit) {
		/* 1. Save a reference to the object to edit */
		this.setObjectToEdit(objectToEdit);
		/* 2. Change the compilation context */
		this.updateAlfModelContext((EObject) objectToEdit);
		/* 3. Let the parser access to the semantic element for which a textual representation is parsed */
		MutableAlfParser.SEMANTIC_ELEMENT = (EObject) objectToEdit; /* FIXME */
		return null;
	}


	/**
	 * Not used
	 */
	public ICommand createInvalidStringCommand(final String newString, EObject semanticElement) {
		return null;
	}

	public abstract String getEditString(EObject semanticObject);

	public abstract ICommand getParseCommand(String textualRepresentation, EObject umlObject, EObject xtextObject);
}
