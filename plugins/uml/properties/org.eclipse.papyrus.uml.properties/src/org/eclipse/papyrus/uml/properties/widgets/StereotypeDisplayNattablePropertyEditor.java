/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.hideshow.RowHideShowLayer;
import org.eclipse.nebula.widgets.nattable.hideshow.command.RowHideCommand;
import org.eclipse.papyrus.infra.nattable.manager.table.TreeNattableModelManager;
import org.eclipse.swt.widgets.Composite;

/**
 * The property editor for the stereotype display nattable widget.
 */
public class StereotypeDisplayNattablePropertyEditor extends NattablePropertyEditor {

	/**
	 * Constructor.
	 *
	 * @param parent
	 *            The parent composite.
	 * @param style
	 *            The style of the composite.
	 */
	public StereotypeDisplayNattablePropertyEditor(final Composite parent, final int style) {
		super(parent, style);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.properties.widgets.NattablePropertyEditor#configureTreeTable(org.eclipse.papyrus.infra.nattable.manager.table.TreeNattableModelManager, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature,
	 *      java.util.Collection)
	 */
	@Override
	protected void configureTreeTable(TreeNattableModelManager nattableManager, final EObject sourceElement, final EStructuralFeature feature, final Collection<?> rows) {
		super.configureTreeTable(nattableManager, sourceElement, feature, rows);
		// Bug 470252 : This allow to remove the 'view' rows
		if (null != rows && !rows.isEmpty()) {
			final RowHideShowLayer layer = nattableManager.getBodyLayerStack().getRowHideShowLayer();
			for (int cpt = 0; cpt < rows.size(); cpt++) {
				// Remove the views rows
				natTableWidget.doCommand(new RowHideCommand(layer, 0));
			}
		}
	}
}
