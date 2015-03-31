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
package org.eclipse.papyrus.uml.properties.xtext.widget;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.infra.emf.dialog.NestedEditingDialogContext;
import org.eclipse.papyrus.infra.widgets.editors.StyledTextReferenceDialog;
import org.eclipse.papyrus.infra.widgets.editors.StyledTextStringEditor;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.papyrus.uml.xtext.integration.StyledTextXtextAdapter;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProvider;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProviderWithInit;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;

/**
 * This class provides a ReferenceValueEditor, with a text field with the xtext
 * completion and syntax instead of the CLabel.
 */
public class UMLXtextReferenceValueEditor extends StyledTextReferenceDialog
		implements IContextElementProvider, SelectionListener {

	/**
	 * The xtext adapter.
	 */
	private StyledTextXtextAdapter xtextAdapter;

	/**
	 * The xtext direct editor configuration used.
	 */
	private DefaultXtextDirectEditorConfiguration configuration;

	/**
	 * The context element adapter.
	 */
	private final ContextElementAdapter contextElementAdapter = new ContextElementAdapter(
			this);

	/**
	 * This allow to manage the focus lsot manually (for the 'ENTER' key).
	 */
	private boolean isFocus = false;

	/**
	 * The object instance class name edited.
	 */
	private String objectInstance;

	/**
	 * Constructor.
	 *
	 * @param parent
	 *            The composite in which the widget will be displayed.
	 * @param style
	 *            The style for the widget.
	 */
	public UMLXtextReferenceValueEditor(final Composite parent, final int style) {
		super(parent, style);
		styledTextStringEditor.getText().addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				if (isFocus) {
					IParser parser = getParser();
					if (null == xtextAdapter) {
						return;
					}

					if (null != xtextAdapter
							&& null != xtextAdapter.getCompletionProposalAdapter()
							&& xtextAdapter.getCompletionProposalAdapter()
									.delayedIsPopupOpen()) {
						// ignore focus lost
						return;
					}
					manageParserCommand(parser);

					// Manage the color field and the control decoration
					styledTextStringEditor.notifyListeners(SWT.FocusOut, new Event());
					styledTextStringEditor.changeColorField();
					controlDecoration.hide();
					isFocus = false;
				}
			}

			public void focusGained(FocusEvent e) {
				isFocus = true;
			}
		});
	}

	/**
	 * This allow to manage the parser command.
	 * 
	 * @param parser
	 *            The parser used.
	 */
	protected void manageParserCommand(final IParser parser) {
		if (null != parser) {
			ICommand command = null;
			if (null != modelProperty
					&& modelProperty.getValueType() instanceof EStructuralFeature) {
				command = parser.getParseCommand(new EObjectAdapter(
						(EStructuralFeature) modelProperty.getValueType()),
						styledTextStringEditor.getText().getText(), 0);
			} else {
				command = parser.getParseCommand(new EObjectAdapter(
						(EObject) getValue()), styledTextStringEditor.getText()
								.getText(),
						0);
			}

			TransactionalEditingDomain domain = TransactionUtil
					.getEditingDomain(getContextElement());
			if (null == domain) {
				// can be null for opaque expression that have been
				// created but have not been added to parent
				// try to get resource set from nested dialog context
				ResourceSet rs = NestedEditingDialogContext.getInstance()
						.getResourceSet();
				domain = TransactionUtil.getEditingDomain(rs);
			}
			if (null != domain) {
				domain.getCommandStack().execute(
						new GMFtoEMFCommandWrapper(command));
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.editors.StyledTextReferenceDialog#createStyledTextStringEditor(org.eclipse.swt.widgets.Composite, java.lang.String, int)
	 */
	@Override
	protected StyledTextStringEditor createStyledTextStringEditor(
			final Composite parent, final String initialValue, final int style) {
		// Change the style to set the singleText to a single line
		int createdStyle = style | SWT.SINGLE;
		return new StyledTextStringEditor(parent, createdStyle) {
			public StyledText createStyledText(Composite parent, String value,
					int createdStyle) {
				StyledText txt = new StyledText(parent, createdStyle);
				if (null != labelProvider) {
					txt.setText(labelProvider.getText(getValue()));
				}
				return txt;
			}
		};
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.editors.StyledTextReferenceDialog#update()
	 */
	@Override
	public void update() {
		super.update();
		updateControls();
	}

	/**
	 * This allow to update the xtext adapter for the styled text.
	 * 
	 * @param styledText
	 *            The styled text which one to adapt the xtext adapter.
	 */
	protected void updateXtextAdapters(final Control styledText) {
		final Object oldObjectToEdit = null != configuration ? configuration
				.getObjectToEdit() : null;

		final DefaultXtextDirectEditorConfiguration newConfiguration = getConfigurationFromSelection();
		// Check if configuration has changed and update adapters
		if (null != newConfiguration && newConfiguration != configuration) {
			if (null != xtextAdapter) {
				xtextAdapter.getFakeResourceContext().getFakeResource()
						.eAdapters().remove(contextElementAdapter);
			}
			configuration = newConfiguration;
			xtextAdapter = new StyledTextXtextAdapter(
					configuration.getInjector());

			EObject semanticElement = (EObject) getValue();
			if (null != semanticElement) {
				newConfiguration.preEditAction(semanticElement);
			}

			xtextAdapter.getFakeResourceContext().getFakeResource().eAdapters()
					.add(contextElementAdapter);
			xtextAdapter.adapt((StyledText) styledText);
		}

		if (null != configuration
				&& configuration.getObjectToEdit() != oldObjectToEdit) {
			IContextElementProvider provider = configuration
					.getContextProvider();
			if (provider instanceof IContextElementProviderWithInit) {
				// update resource, if required by text editor
				if (null != xtextAdapter) {
					((IContextElementProviderWithInit) provider)
							.initResource(xtextAdapter.getFakeResourceContext()
									.getFakeResource());
				}
			}
		}
	}

	/**
	 * This allow to get the xtext direct editor configuration depending on the
	 * value of the styled text.
	 * 
	 * @return The {@link DefaultXtextDirectEditorConfiguration} corresponding.
	 */
	protected DefaultXtextDirectEditorConfiguration getConfigurationFromSelection() {
		if (null != objectInstance && !objectInstance.isEmpty()) {
			Object feature = null;
			Object contextElement = null;
			if (null != modelProperty) {
				feature = modelProperty.getValueType();
				contextElement = getContextElement();
			} else {
				contextElement = getValue();
			}

			if (contextElement instanceof EObject) {
				// allow to init the extension point and allow to get existing language for the elements
				final List<String> languages = DirectEditorsUtil.getLanguages(objectInstance);

				// if we are here, the default is not a Xtext editor
				for (String currentLanguage : languages) {
					IDirectEditorConfiguration directEditorConfiguration = DirectEditorsUtil.findEditorConfigurationWithPriority(currentLanguage, objectInstance);
					if (directEditorConfiguration instanceof DefaultXtextDirectEditorConfiguration) {
						DefaultXtextDirectEditorConfiguration xtextConfiguration = (DefaultXtextDirectEditorConfiguration) directEditorConfiguration;
						if (null != feature) {
							xtextConfiguration.preEditAction(((EObject) contextElement)
									.eGet((EStructuralFeature) feature));
						} else {
							xtextConfiguration.preEditAction((EObject) contextElement);
						}
						return xtextConfiguration;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Get the parser corresponding to the value.
	 * 
	 * @return The {@link IParser}
	 */
	protected IParser getParser() {
		EObject parentSemanticElement = null;
		final Object contextElement = getContextElement();
		if (null != contextElement && contextElement instanceof EObject) {
			parentSemanticElement = (EObject) contextElement;
		}
		if (null != configuration && null != parentSemanticElement) {
			return configuration.createParser(parentSemanticElement);
		}
		return null;
	}

	/**
	 * {@inheritDoc} Update the xtext adapter.
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.editors.StyledTextReferenceDialog#doBinding()
	 */
	@Override
	protected void doBinding() {
		super.doBinding();
		updateXtextAdapters(styledTextStringEditor.getText());
		styledTextStringEditor.setValue(labelProvider.getText(getValue()));
		updateLabel();
	}

	/**
	 * {@inheritDoc} Dispose the xtext adapter.
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.editors.StyledTextReferenceDialog#dispose()
	 *
	 */
	@Override
	public void dispose() {
		// dispose resources to avoid memory leaks
		if (null != styledTextStringEditor) {
			styledTextStringEditor.dispose();
		}
		if (null != xtextAdapter) {
			xtextAdapter.getFakeResourceContext().getFakeResource().eAdapters()
					.remove(contextElementAdapter);
			xtextAdapter.dispose();
			xtextAdapter = null;
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProvider#getContextObject()
	 */
	public EObject getContextObject() {
		final Object value = getValue();
		return value instanceof EObject ? (EObject) value : null;
	}

	/**
	 * Sets the object instance class name.
	 * 
	 * @param objectInstance
	 *            The object instance class name.
	 */
	public void setObjectInstance(String objectInstance) {
		this.objectInstance = objectInstance;
	}
}
