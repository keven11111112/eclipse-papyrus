/*****************************************************************************
 * Copyright (c) 2011, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 506896
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.commands.handler;

import java.util.List;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.emf.gmf.command.ICommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.ui.command.AbstractCommandHandler;
import org.eclipse.papyrus.infra.ui.command.InteractiveCommandWrapper;
import org.eclipse.papyrus.views.modelexplorer.DirectEditorEditingSupport;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.base.Strings;

/**
 * This handler implements renaming of {@link NamedElement}s.
 */
public class RenameNamedElementHandler extends AbstractCommandHandler {

	@Override
	protected Command getCommand(IEvaluationContext context) {
		Command result = UnexecutableCommand.INSTANCE;

		TransactionalEditingDomain editingDomain = getEditingDomain(context);
		EObject selectedElement = getSelectedElement();
		if (selectedElement instanceof NamedElement) {
			final NamedElement namedElement = (NamedElement) selectedElement;
			final String currentName = namedElement.getName();

			if (currentName != null) {
				result = new InteractiveCommandWrapper("Rename", "Change the name of an element") {
					@Override
					protected Command createCommand() {
						Command result = UnexecutableCommand.INSTANCE;

						InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), "Rename...", "New name:", currentName, null);
						if (dialog.open() == Window.OK) {
							String name = dialog.getValue();

							if (!Strings.isNullOrEmpty(name) && !name.equals(currentName)) {
								IElementEditService edit = ElementEditServiceUtils.getCommandProvider(namedElement);
								SetRequest request = new SetRequest(editingDomain, namedElement, UMLPackage.Literals.NAMED_ELEMENT__NAME, name);
								if (edit.canEdit(request)) {
									result = ICommandWrapper.wrap(edit.getEditCommand(request), Command.class);
								}
							}
						}

						return result;
					}
				};
			}
		}

		return result;
	}

	@Override
	protected boolean computeEnabled(IEvaluationContext context) {
		boolean enabled = super.computeEnabled(context);
		if (enabled) {
			List<EObject> selectedElements = getSelectedElements();
			EObject selection = selectedElements.get(0);
			enabled = !EMFHelper.isReadOnly(selection) && !isHandledByDirectEditor(selection);
		}
		return enabled;
	}

	/**
	 * Check whether the editing of an element is handled by a direct editor. In this case, we do
	 * not want to open the rename pop-up.
	 *
	 * @param element
	 *            an element that should be edited.
	 * @return true, if handled by a direct editor
	 */
	protected boolean isHandledByDirectEditor(EObject element) {
		return DirectEditorEditingSupport.getConfiguration(element) != null;
	}
}
