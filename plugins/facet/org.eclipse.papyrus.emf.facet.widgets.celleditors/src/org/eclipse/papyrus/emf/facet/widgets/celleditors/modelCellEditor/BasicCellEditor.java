/**
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 */
package org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Basic Cell Editor</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.BasicCellEditor#getBasicCellEditorImpl
 * <em>Basic Cell Editor Impl</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage#getBasicCellEditor()
 * @model
 * @generated
 */
public interface BasicCellEditor extends AbstractModelCellEditor {
	/**
	 * Returns the value of the '<em><b>Basic Cell Editor Impl</b></em>'
	 * attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Basic Cell Editor Impl</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Basic Cell Editor Impl</em>' attribute.
	 * @see #setBasicCellEditorImpl(String)
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage#getBasicCellEditor_BasicCellEditorImpl()
	 * @model required="true"
	 * @generated
	 */
	String getBasicCellEditorImpl();

	/**
	 * Sets the value of the ' {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.BasicCellEditor#getBasicCellEditorImpl
	 * <em>Basic Cell Editor Impl</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Basic Cell Editor Impl</em>'
	 *            attribute.
	 * @see #getBasicCellEditorImpl()
	 * @generated
	 */
	void setBasicCellEditorImpl(String value);

} // BasicCellEditor
