/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Andreas Muelder - muelder@itemis.de -  Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.xtext.integration;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.papyrus.extensionpoints.editors.configuration.DefaultDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Injector;

/**
 * 
 * abstract base implementation of {@link ICustomDirectEditorConfiguration}
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 * 
 */
public abstract class DefaultXtextDirectEditorConfiguration extends DefaultDirectEditorConfiguration implements
		ICustomDirectEditorConfiguration {

	public static final String ANNOTATION_SOURCE = "expression_source";

	public static final String ANNOTATION_DETAIL = "expression";
	
	/**
	 * returns the UI Injector for the Xtext language
	 * 
	 */
	public abstract Injector getInjector();

	/**
	 * returns the {@link ICommand} used to update the UML Model
	 * 
	 * @param umlObject
	 * @param xtextObject
	 * @return
	 */
	protected abstract ICommand getParseCommand(EObject umlObject, EObject xtextObject);

	/**
	 * Clients may override to change style to {@link SWT}.MULTI
	 */
	@Override
	public int getStyle() {
		return SWT.SINGLE;
	}

	public DirectEditManager createDirectEditManager(final ITextAwareEditPart host) {
		IContextElementProvider provider = new IContextElementProvider() {
			public EObject getContextObject() {
				if (host instanceof IGraphicalEditPart)
					return ((IGraphicalEditPart) host).resolveSemanticElement();
				return null;
			}
		};
		return new XtextDirectEditManager(host, getInjector(), getStyle(), provider);
	}

	/**
	 * Adapts {@link IDirectEditorConfiguration} to gmfs {@link IParser}
	 * interface for reuse in GMF direct editing infrastructure.
	 */
	public IParser createParser(final EObject semanticObject) {
		return new IParser() {
			public String getEditString(IAdaptable element, int flags) {
				return DefaultXtextDirectEditorConfiguration.this.getTextToEditInternal(semanticObject);
			}

			public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
				IContextElementProvider provider = new IContextElementProvider() {
					public EObject getContextObject() {
						return semanticObject;
					}
				};
				XtextFakeResourceContext context = new XtextFakeResourceContext(getInjector());
				context.getFakeResource().eAdapters().add(new ContextElementAdapter(provider));
				try {
					context.getFakeResource().load(new StringInputStream(newString), Collections.EMPTY_MAP);
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (!context.getFakeResource().getParseResult().hasSyntaxErrors()) {
					EObject xtextObject = context.getFakeResource().getParseResult().getRootASTElement();
					return DefaultXtextDirectEditorConfiguration.this.getParseCommand(semanticObject, xtextObject);
				} else {
					return createInvalidStringCommand(newString, semanticObject);
				}
			}

			public String getPrintString(IAdaptable element, int flags) {
				return DefaultXtextDirectEditorConfiguration.this.getTextToEdit(semanticObject);
			}

			public boolean isAffectingEvent(Object event, int flags) {
				return false;
			}

			public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
				// Not used
				return null;
			}

			public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
				// Not used
				return null;
			}
		};
	}

	protected String getTextToEditInternal(EObject semanticObject) {
		if (semanticObject instanceof EModelElement) {
			EAnnotation eAnnotation = ((EModelElement) semanticObject).getEAnnotation(ANNOTATION_SOURCE);
			if (eAnnotation != null) {
				return eAnnotation.getDetails().get(ANNOTATION_DETAIL);
			}
		}
		return getTextToEdit(semanticObject);
	}

	protected ICommand createInvalidStringCommand(String newString, EObject semanticElement) {
		if (semanticElement instanceof EModelElement) {
			EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(ANNOTATION_SOURCE);
			eAnnotation.getDetails().put(ANNOTATION_DETAIL, newString);
			return new SetValueCommand(new SetRequest(semanticElement,
					EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS, eAnnotation));
		}
		return UnexecutableCommand.INSTANCE;
	}
	
	
	public CellEditor createCellEditor(Composite parent, final EObject semanticObject) {
		IContextElementProvider provider = new IContextElementProvider() {
			public EObject getContextObject() {
				return semanticObject;
			}
		};
		XtextStyledTextCellEditorEx cellEditor = new XtextStyledTextCellEditorEx(
				SWT.MULTI | SWT.BORDER, getInjector(), provider) {

			// This is a workaround for bug
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=412732
			// We can not create SWT.SINGLE CellEditor here, so we have to hook
			// into the StyledTextListener to disable new line. Delete this when
			// the bug is fixed
			@Override
			protected StyledText createStyledText(Composite parent) {
				StyledText text = super.createStyledText(parent);
				text.addListener(3005, new Listener() {
					public void handleEvent(Event event) {
						if (event.character == SWT.CR
								&& !completionProposalAdapter
										.isProposalPopupOpen()) {
							focusLost();
						}
					}
				});
				return text;
			}
			// Workaround end
		};
		cellEditor.create(parent);
		return cellEditor;
	}
}
