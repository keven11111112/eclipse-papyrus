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
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.hideshow.RowHideShowLayer;
import org.eclipse.nebula.widgets.nattable.hideshow.command.RowHideCommand;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.TreeNattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.swt.widgets.Composite;

/**
 * The property editor for the stereotype display nattable widget.
 */
public class StereotypeDisplayNattablePropertyEditor extends TreeNattablePropertyEditor {

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
	 * 
	 * @deprecated since 2.0, done in the override of {@link #createNatTableWidget(INattableModelManager, Composite, int, Collection)}
	 */
	@Deprecated
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

	/**
	 * @see org.eclipse.papyrus.uml.properties.widgets.NattablePropertyEditor#createNatTableWidget(org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager, org.eclipse.swt.widgets.Composite, int, Collection)
	 *
	 * @param manager
	 * @param parent
	 * @param style
	 * @return
	 */
	@Override
	protected NatTable createNatTableWidget(INattableModelManager manager, Composite parent, int style, Collection<?> rows) {
		NatTable natTable = super.createNatTableWidget(manager, parent, style, rows);
		// Bug 470252 : This allow to remove the 'view' rows
		if (null != rows && !rows.isEmpty()) {
			// the widget is already expanded
			final RowHideShowLayer layer = nattableManager.getBodyLayerStack().getRowHideShowLayer();
			for (Object current : manager.getRowElementsList()) {
				if (rows.contains(AxisUtils.getRepresentedElement(current))) {
					int index = manager.getRowElementsList().indexOf(current);
					int realIndex = layer.underlyingToLocalRowPosition(natTable, index);
					natTable.doCommand(new RowHideCommand(layer, realIndex));
				}
			}
		}
		return natTable;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.properties.widgets.NattablePropertyEditor#getEObjectAsTableContext(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected EObject getEObjectAsTableContext(EObject element) {
		return element;
	}
}
