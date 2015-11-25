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
import org.eclipse.papyrus.infra.emf.nattable.selection.EObjectSelectionExtractor;
import org.eclipse.papyrus.infra.nattable.manager.table.TreeNattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.tree.CollapseAndExpandActionsEnum;
import org.eclipse.papyrus.infra.nattable.utils.NattableModelManagerFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
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
	 * This allow to create the table widget.
	 * 
	 * @param sourceElement
	 *            The source Element.
	 * @param feature
	 *            The feature.
	 * @param rows
	 *            The rows of the table.
	 */
	protected void createTableWidget(final EObject sourceElement, final EStructuralFeature feature, final Collection<?> rows) {

		// Create the table
		final Table table = createTable(sourceElement, feature, rows);
		if (null == table) {
			displayError("Cannot initialize the table"); //$NON-NLS-1$
			return;
		}

		// Create the widget
		nattableManager = NattableModelManagerFactory.INSTANCE.createNatTableModelManager(table, new EObjectSelectionExtractor());
		natTableWidget = nattableManager.createNattable(self, SWT.NONE, null);
		if (nattableManager instanceof TreeNattableModelManager) {
			// Bug 470252 : This allow to remove the 'view' rows
			if (null != rows && !rows.isEmpty()) {
				final RowHideShowLayer layer = nattableManager.getBodyLayerStack().getRowHideShowLayer();
				for (int cpt = 0; cpt < rows.size(); cpt++) {
					// Remove the views rows
					natTableWidget.doCommand(new RowHideCommand(layer, 0));
				}
			}
			((TreeNattableModelManager) nattableManager).doCollapseExpandAction(CollapseAndExpandActionsEnum.EXPAND_ALL, null);
		}

		self.addDisposeListener(getDisposeListener());
		natTableWidget.setBackground(self.getBackground());
		
		// Adapt the group to the table prefered size (with sub of removed rows size)
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.minimumHeight = natTableWidget.getPreferredHeight()-(rows.size()*70);
		self.setLayoutData(data);

		natTableWidget.layout();
		self.layout();
	}
}
