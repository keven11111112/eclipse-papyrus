/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.nattable.richtext.celleditor;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.extension.nebula.richtext.RichTextCellEditor;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.nebula.widgets.richtext.RichTextEditor;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.infra.widgets.editors.richtext.GenericRichTextEditor;
import org.eclipse.papyrus.uml.ui.editors.UMLRichtextEditorWithReferences;
import org.eclipse.papyrus.uml.ui.editors.UMLToolbarConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.uml2.uml.Element;

/**
 * @author Vincent Lorenzo
 *
 */
public class RichTextCellEditorWithUMLReferences extends RichTextCellEditor {


	/**
	 * 
	 * Constructor.
	 *
	 */
	public RichTextCellEditorWithUMLReferences() {
		this(SWT.RESIZE);
	}

	/**
	 * 
	 * Constructor.
	 *
	 * @param style
	 */
	public RichTextCellEditorWithUMLReferences(int style) {
		this(new UMLToolbarConfiguration(), style);
	}

	/**
	 * 
	 * Constructor.
	 *
	 * @param toolbarConfiguration
	 * @param style
	 */
	public RichTextCellEditorWithUMLReferences(UMLToolbarConfiguration toolbarConfiguration, int style) {
		super(toolbarConfiguration, style);
	}

	/**
	 * 
	 * Constructor.
	 *
	 * @param toolbarConfiguration
	 */
	public RichTextCellEditorWithUMLReferences(UMLToolbarConfiguration toolbarConfiguration) {
		this(toolbarConfiguration, SWT.RESIZE);
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.extension.nebula.richtext.RichTextCellEditor#createRichTextEditor(org.eclipse.swt.widgets.Composite)
	 *
	 * @param parent
	 * @return
	 */
	@Override
	protected RichTextEditor createRichTextEditor(Composite parent) {
		return new UMLRichtextEditorWithReferences(parent, this.style) {
			@Override
			protected int getMinimumHeight() {
				return getMinimumDimension().y;
			}

			@Override
			protected int getMinimumWidth() {
				return getMinimumDimension().x;
			}
		};
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.extension.nebula.richtext.RichTextCellEditor#activateCell(org.eclipse.swt.widgets.Composite, java.lang.Object)
	 *
	 * @param parent
	 * @param originalCanonicalValue
	 * @return
	 */
	@Override
	protected Control activateCell(final Composite parent, final Object originalCanonicalValue) {
		Control ctrl = super.activateCell(parent, originalCanonicalValue);
		if (this.editor instanceof GenericRichTextEditor) {

			Element editedElement = getEditedElement();
			EStructuralFeature editedFeature = getEditedFeature();
			if (editedElement != null && editedFeature != null) {
				((GenericRichTextEditor) this.editor).configureEdition(editedElement, editedFeature);
			}
		}
		return ctrl;
	}

	/**
	 * @return
	 * 		the edited feature
	 */
	protected EStructuralFeature getEditedFeature() {
		final INattableModelManager manager = this.configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
		Object columnObject = AxisUtils.getRepresentedElement(manager.getColumnElement(getColumnIndex()));
		EStructuralFeature editedFeature = null;
		if (columnObject instanceof EStructuralFeature) {
			editedFeature = (EStructuralFeature) columnObject;
		} else {
			Object rowObject = AxisUtils.getRepresentedElement(manager.getRowElement(getRowIndex()));
			if (rowObject instanceof EStructuralFeature) {
				editedFeature = (EStructuralFeature) rowObject;
			}
		}
		return editedFeature;
	}

	/**
	 * @return
	 * 		the edited element
	 */
	protected Element getEditedElement() {
		final INattableModelManager manager = this.configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
		Object rowObject = AxisUtils.getRepresentedElement(manager.getRowElement(getRowIndex()));

		Element editedElement = null;
		if (rowObject instanceof Element) {
			editedElement = (Element) rowObject;
		} else {
			Object columnObject = AxisUtils.getRepresentedElement(manager.getColumnElement(getColumnIndex()));
			if (columnObject instanceof Element) {
				editedElement = (Element) rowObject;
			}
		}
		return editedElement;
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.extension.nebula.richtext.RichTextCellEditor#getMinimumDimension()
	 *
	 * @return
	 */
	@Override
	protected Point getMinimumDimension() {
		return new Point(370, 400);
	}

}
