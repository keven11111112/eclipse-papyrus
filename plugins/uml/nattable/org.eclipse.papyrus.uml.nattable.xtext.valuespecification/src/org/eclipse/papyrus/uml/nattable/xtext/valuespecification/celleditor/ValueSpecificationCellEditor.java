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
package org.eclipse.papyrus.uml.nattable.xtext.valuespecification.celleditor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.papyrus.infra.nattable.manager.table.ITableAxisElementProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.uml.nattable.xtext.integration.celleditor.AbstractXtextCellEditor;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * {@link ICellEditor} implementation that wraps a SWT {@link Text} control to
 * support text editing. This is also the default editor in NatTable if you
 * didn't configure something else.
 */
public class ValueSpecificationCellEditor extends AbstractXtextCellEditor {

	/**
	 * Constructor.
	 *
	 * @param table
	 *            The table.
	 * @param axisElement
	 *            The axis element object.
	 * @param elementProvider
	 *            The element provider.
	 */
	public ValueSpecificationCellEditor(final Table table,
			final Object axisElement,
			final ITableAxisElementProvider elementProvider) {
		super(table, axisElement, elementProvider);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.AbstractPapyrusStyledTextCellEditor#getEditedEObject()
	 */
	@Override
	protected EObject getEditedEObject() {
		int columnIndex = this.layerCell.getColumnIndex();
		int rowIndex = this.layerCell.getRowIndex();
		Object row = this.elementProvider.getRowElement(rowIndex);
		Object column = this.elementProvider.getColumnElement(columnIndex);
		row = AxisUtils.getRepresentedElement(row);
		column = AxisUtils.getRepresentedElement(column);
		EObject editedEObject = null;
		if (row instanceof EObject && column instanceof EStructuralFeature) {
			if (UMLPackage.Literals.VALUE_SPECIFICATION == ((EStructuralFeature) column)
					.getEType()) {
				editedEObject = (EObject) row;
			}
		} else if (row instanceof EStructuralFeature && column instanceof EObject) {
			if (UMLPackage.Literals.VALUE_SPECIFICATION == ((EStructuralFeature) row)
					.getEType()) {
				editedEObject = (EObject) column;
			}
		}
		return editedEObject;
	}

	/**
	 * This allow to get the configuration for edited object.
	 * 
	 * @param editedEObject
	 *            The edited object.
	 * @return The {@link DefaultXtextDirectEditorConfiguration} corresponding
	 *         the the edited object.
	 */
	protected DefaultXtextDirectEditorConfiguration getConfigurationFromEditedEObject(
			final Object row, final Object column) {
		if (row instanceof EObject && column instanceof EStructuralFeature || row instanceof EStructuralFeature && column instanceof EObject) {

			final EStructuralFeature feature = (EStructuralFeature) (column instanceof EStructuralFeature ? column : row);
			final EObject eObject = (EObject) (row instanceof EObject ? row : column);

			IPreferenceStore store = Activator.getDefault()
					.getPreferenceStore();
			String semanticClassName = feature.getEType()
					.getInstanceClassName();

			String key = IDirectEditorsIds.EDITOR_FOR_ELEMENT
					+ semanticClassName;
			String languagePreferred = store.getString(key);

			if (languagePreferred != null && !languagePreferred.equals("")) { //$NON-NLS-1$
				IDirectEditorConfiguration configuration = DirectEditorsUtil
						.findEditorConfigurationWithPriority(languagePreferred,
								semanticClassName);
				if (configuration instanceof DefaultXtextDirectEditorConfiguration) {

					DefaultXtextDirectEditorConfiguration xtextConfiguration = (DefaultXtextDirectEditorConfiguration) configuration;
					xtextConfiguration.preEditAction(eObject.eGet(feature));
					return xtextConfiguration;
				}
			}
		}
		return null;
	}
}
