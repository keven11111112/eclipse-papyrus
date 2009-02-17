/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.navigator.actions;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.di.Diagram;

/**
 * Provider used to create actions applicable on diagrams
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class DiagramActionProvider extends AbstractSubmenuActionProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fillContextMenu(IMenuManager menu) {
		Object selectedElement = getFirstSelectedElement();
		if (selectedElement instanceof Diagram) {
			Diagram diagram = (Diagram) selectedElement;

			// Create Rename Diagram action
			RenameDiagramAction renameDiagramAction = new RenameDiagramAction(diagram);
			menu.add(renameDiagramAction);

			// Create Delete Diagram action
			DeleteDiagramAction deleteDiagramAction = new DeleteDiagramAction(diagram);
			menu.add(deleteDiagramAction);

			// Create Duplicate Diagram action
			DuplicateDiagramAction duplicateDiagramAction = new DuplicateDiagramAction(diagram);
			menu.add(duplicateDiagramAction);
		}
	}

}
