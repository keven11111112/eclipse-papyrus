/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.resource.sasheditor;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.util.DiUtils;

/**
 * A factory for commands that manipulate the configuration of the sash editor layout.
 */
public class SashLayoutCommandFactory {
	private final IMultiDiagramEditor editor;

	public SashLayoutCommandFactory(IMultiDiagramEditor editor) {
		super();

		this.editor = editor;
	}

	/**
	 * Creates a command that toggles whether the sash model is stored in the private
	 * workspace metadata area or in the shared {@code *.di} file.
	 * 
	 * @return a toggle command for the private layout storage
	 */
	public Command createTogglePrivateLayoutCommand() {
		Command result = UnexecutableCommand.INSTANCE;

		ModelSet modelSet = (ModelSet) editor.getAdapter(EditingDomain.class).getResourceSet();
		org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel sashModel = SashModelUtils.getSashModel(modelSet);
		if (sashModel != null) {
			result = new AbstractToggleCommand("Toggle Private Editor Layout") {

				@Override
				public void execute() {
					SashWindowsMngr toMove = DiUtils.lookupSashWindowsMngr(sashModel.getResource());

					// We don't record changes in the sash model for undo/redo,
					// so we cannot assume that any changes to the current page selections
					// are undoable in the usual way
					if (!sashModel.isLegacyMode()) {
						Resource sashResource = toMove.eResource();
						URI sharedURI = sashModel.getSharedResourceURI();

						// Move the contents into the DI model. If the DI resource isn't loaded,
						// give up because something is seriously wrong in that case
						Resource diResource = modelSet.getResource(sharedURI, false);
						if ((diResource != null) && diResource.isLoaded()) {
							SashWindowsMngr toReplace = DiUtils.lookupSashWindowsMngr(diResource);
							if (toReplace != null) {
								EcoreUtil.replace(toReplace, toMove);
							} else {
								diResource.getContents().add(0, toMove);
							}

							if (sashResource.getContents().isEmpty()) {
								// Schedule deletion on save
								modelSet.getResourcesToDeleteOnSave().add(sashResource.getURI());
							}
						}
					} else {
						Resource sashResource;
						URI privateURI = sashModel.getPrivateResourceURI();

						// Move the contents into the sash model. If the sash resource isn't loaded
						// or doesn't exist, it will have to be handled
						if (modelSet.getURIConverter().exists(privateURI, null)) {
							sashResource = modelSet.getResource(privateURI, true);
						} else {
							sashResource = modelSet.createResource(privateURI);
						}

						// In case we had marked it for deletion, earlier
						modelSet.getResourcesToDeleteOnSave().remove(privateURI);

						SashWindowsMngr toReplace = DiUtils.lookupSashWindowsMngr(sashResource);
						if (toReplace != null) {
							EcoreUtil.replace(toReplace, toMove);
						} else {
							sashResource.getContents().add(0, toMove);
						}
					}

					// Re-load from the new resource. Snippets might find this odd, but
					// it would be even more odd for there to be any snippets on this model
					sashModel.loadModel(modelSet.getURIWithoutExtension());
				}
			};
		}

		return result;
	}

	//
	// Nested types
	//

	private static abstract class AbstractToggleCommand extends AbstractCommand {

		AbstractToggleCommand(String label) {
			super(label);
		}

		@Override
		protected boolean prepare() {
			// Nothing to prepare
			return true;
		}

		@Override
		public void undo() {
			// It's a toggle, so yeah, just execute again
			execute();
		}

		@Override
		public void redo() {
			execute();
		}
	}
}
