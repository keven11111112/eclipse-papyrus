/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Fanch BONNABESSE (ALL4TEC) fanch.bonnabesse@all4tec.net - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.ui.emf.databinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.databinding.EObjectObservableValue;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor.EDataTypeCellEditor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.swt.SWT;

/**
 *
 * Editing Support used to edit EObservableValue on a TreeViewer.
 *
 */
public class EObjectObservableValueEditingSupport extends EditingSupport {

	/** proposals for boolean */
	protected final String[] booleanProposals = new String[] { "true", "false" }; //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * Constructor.
	 *
	 * @param viewer
	 *            Viewer in which editors will open.
	 * @param factory
	 *            The reference value factory.
	 */
	public EObjectObservableValueEditingSupport(final ColumnViewer viewer, final ReferenceValueFactory factory) {
		super(viewer);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#canEdit(java.lang.Object)
	 */
	@Override
	protected boolean canEdit(final Object element) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#getCellEditor(java.lang.Object)
	 */
	@Override
	protected CellEditor getCellEditor(final Object element) {
		if (element instanceof EObjectObservableValue) {
			Object valueType = ((EObjectObservableValue) element).getValueType();
			if (valueType instanceof EStructuralFeature) {
				EStructuralFeature feature = (EStructuralFeature) valueType;

				if (feature instanceof EReference) {
					return null;
				}

				EClassifier eType = feature.getEType();
				if (eType instanceof EEnum) {
					return createEnumerationEditor(feature);
				} else {
					String instanceTypeName = eType.getInstanceClassName();
					if (instanceTypeName.equals("boolean")) { //$NON-NLS-1$
						return createBooleanEditor();
					}
				}

				if (eType instanceof EDataType) {
					return new EDataTypeCellEditor((EDataType) eType, ((TreeViewer) getViewer()).getTree());
				}
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#getValue(java.lang.Object)
	 */
	@Override
	protected Object getValue(final Object element) {
		if (element instanceof EObjectObservableValue) {
			EStructuralFeature feature = (EStructuralFeature) ((EObjectObservableValue) element).getValueType();
			if (feature instanceof EReference) {
				return null;
				// return getReferenceValue((EReference) feature);
			}
			EClassifier eType = feature.getEType();
			Object object = ((EObjectObservableValue) element).getValue();
			if (eType instanceof EEnum) {
				return getEnumerationValue((EEnum) eType, object);
			} else {
				String instanceTypeName = eType.getInstanceClassName();
				if (instanceTypeName.equals("boolean")) { //$NON-NLS-1$
					return getBooleanValue(object);
				}

				return object;
			}
		}
		return null;
	}

	/**
	 * Returns the value from the feature.
	 *
	 * @param feature
	 *            The feature to edit.
	 * @param object
	 *            The object to search.
	 * @return the boolean value
	 */
	protected Object getEnumerationValue(final EEnum eType, final Object object) {
		List<EEnumLiteral> literals = eType.getELiterals();
		if (object == null) {
			return 0;
		} else {
			return literals.indexOf(object);
		}
	}

	/**
	 * Returns the value from the feature.
	 *
	 * @return the boolean value.
	 */
	protected Object getBooleanValue(final Object object) {
		List<String> booleans = Arrays.asList(booleanProposals);
		if (object == null || object.equals("")) {
			return 0;
		}
		return booleans.indexOf(object.toString());
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#setValue(java.lang.Object, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void setValue(final Object element, final Object value) {
		if (element instanceof EObjectObservableValue) {
			EStructuralFeature feature = (EStructuralFeature) ((EObjectObservableValue) element).getValueType();
			if (feature instanceof EReference) {
				// setReferenceValue(element, value);
			} else {
				EClassifier eType = feature.getEType();
				if (eType instanceof EEnum) {
					setEnumerationValue((EObjectObservableValue) element, value);
				} else {
					String instanceTypeName = eType.getInstanceClassName();
					if (instanceTypeName.equals("boolean")) { //$NON-NLS-1$
						setBooleanValue((EObjectObservableValue) element, value);
					} else {
						((EObjectObservableValue) element).setValue(value);
					}
				}
			}

			getViewer().update(element, null);
		}
	}

	/**
	 * This allows to set the enumeration value.
	 * 
	 * @param element
	 *            The element to manage.
	 * @param value
	 *            The value to set.
	 */
	@SuppressWarnings("unchecked")
	protected void setEnumerationValue(final EObjectObservableValue element, final Object value) {
		EStructuralFeature feature = (EStructuralFeature) element.getValueType();
		EEnum eType = (EEnum) feature.getEType();
		List<EEnumLiteral> literals = eType.getELiterals();
		List<String> proposals = new ArrayList<>();
		for (int i = 0; i < literals.size(); i++) {
			// i+1 because there is already the "" string
			proposals.add(i, literals.get(i).getLiteral());
		}
		if (null == value) {
			element.setValue(null);
		} else {
			// retrieve the index of the current value in the list
			int index = (Integer) value;
			if (index >= 0 && index < literals.size()) {
				element.setValue(literals.get(index));
			}
		}
	}

	/**
	 * Sets the new boolean value on the given element.
	 *
	 * @param element
	 *            The model element.
	 * @param value
	 *            The new value.
	 */
	@SuppressWarnings("unchecked")
	protected void setBooleanValue(final EObjectObservableValue element, final Object value) {
		if (null == value) {
			// propertiesToUpdate.remove(featureName);
		} else if (value.equals(0)) {
			element.setValue(Boolean.valueOf(booleanProposals[0]));
		} else if (value.equals(1)) {
			element.setValue(Boolean.valueOf(booleanProposals[1]));
		} else {
			Activator.log.error("impossible to set boolean value " + value, null); //$NON-NLS-1$
		}
	}

	/**
	 * Creates and return a combobox cell editor for a boolean type
	 *
	 * @return the newly created combo box cell editor
	 */
	protected CellEditor createBooleanEditor() {
		return new ComboBoxCellEditor(((TreeViewer) getViewer()).getTree(), booleanProposals, SWT.READ_ONLY);
	}

	/**
	 * Creates and return a combobox cell editor for an enumeration type
	 *
	 * @param feature
	 *            the feature to edit
	 * @return the newly created combo box cell editor
	 */
	protected CellEditor createEnumerationEditor(final EStructuralFeature feature) {
		EEnum eType = (EEnum) feature.getEType();
		List<EEnumLiteral> literals = eType.getELiterals();
		String[] proposals = new String[literals.size()];
		for (int i = 0; i < literals.size(); i++) {
			proposals[i] = literals.get(i).getLiteral();
		}
		return new ComboBoxCellEditor(((TreeViewer) getViewer()).getTree(), proposals, SWT.READ_ONLY);
	}

}
