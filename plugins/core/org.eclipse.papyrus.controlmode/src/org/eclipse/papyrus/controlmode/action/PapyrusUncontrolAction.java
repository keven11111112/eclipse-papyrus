/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.controlmode.action;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.edit.ui.action.CommandActionHandler;
import org.eclipse.gmt.modisco.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.controlmode.commands.UncontrolCommand;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.ui.PlatformUI;

/**
 * An action to uncontrol a papyrus resource.
 * 
 * @author eperico
 */
public class PapyrusUncontrolAction extends CommandActionHandler {

	/** The selected eObject. */
	private EObject eObject;

	private IStructuredSelection selection;

	/**
	 * Instantiates a new papyrus uncontrol action when a controlled model object is selected.
	 * 
	 * @param domain
	 *        the domain
	 */
	public PapyrusUncontrolAction(EditingDomain domain) {
		super(domain, EMFEditUIPlugin.INSTANCE.getString("_UI_Uncontrol_menu_item"));
		setDescription("_UI_Uncontrol_menu_item_description");
		setToolTipText("Merge the external model with the current model");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		return getEditingDomain().isControllable(eObject) && AdapterFactoryEditingDomain.isControlled(eObject);
	}

	/**
	 * The creation of AddCommand is done in the run() method, when the user specifies a target
	 * resource.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateSelection(IStructuredSelection theSelection) {
		boolean result = false;
		this.selection = theSelection;

		if(selection.size() == 1) {
			Object object = AdapterFactoryEditingDomain.unwrap(selection.getFirstElement());
			if(object instanceof ModelElementItem) {
				ModelElementItem eltItem = (ModelElementItem)object;
				object = eltItem.getEObject();
			}
			// Check whether the selected object is controllable
			result = domain.isControllable(object);
			if(result) {
				eObject = (EObject)object;
				result = AdapterFactoryEditingDomain.isControlled(eObject);
			} else {
				eObject = null;
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			UncontrolCommand transactionalCommand = new UncontrolCommand(EditorUtils.getTransactionalEditingDomain(), eObject, "Uncontrol", null);
			OperationHistoryFactory.getOperationHistory().execute(transactionalCommand, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), EMFEditUIPlugin.INSTANCE.getString("_UI_InvalidURI_label"), EMFEditUIPlugin.INSTANCE.getString("_WARN_CannotCreateResource"));
			EMFEditUIPlugin.INSTANCE.log(e);
		}
	}
}
