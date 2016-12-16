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

package org.eclipse.papyrus.infra.ui.emf.providers;

import org.eclipse.emf.databinding.EObjectObservableValue;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.DelegatingStyledCellLabelProvider;

/**
 * LabelProvider used to show feature name and EObject of an EObjectObservaleValue.
 *
 */
public class EObjectObservableValueLabelProvider extends DelegatingStyledCellLabelProvider {

	/**
	 * Index of the EStructuralFeature.
	 */
	private static final int ESTRUCTURAL_FEATURE = 0;

	/**
	 * Index of the EObject.
	 */
	private static final int EOBJECT = 1;

	/**
	 * Constructor.
	 *
	 * @param styledLabelProvider
	 *            The {@link IStyledLabelProvider}.
	 */
	public EObjectObservableValueLabelProvider(final IStyledLabelProvider styledLabelProvider) {
		super(styledLabelProvider);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.DelegatingStyledCellLabelProvider#getColumnText(java.lang.Object, int)
	 */
	@Override
	public String getColumnText(final Object element, final int columnIndex) {
		if (element instanceof EObjectObservableValue) {
			String columnText = ""; //$NON-NLS-1$
			EObjectObservableValue elementObservableValue = (EObjectObservableValue) element;
			Object valueType = elementObservableValue.getValueType();
			if (valueType instanceof EAttribute) {
				switch (columnIndex) {
				case ESTRUCTURAL_FEATURE:
					if (valueType instanceof EStructuralFeature) {
						columnText = ((EStructuralFeature) valueType).getName();
					}
					break;
				case EOBJECT:
					if (null != elementObservableValue.getValue()) {
						columnText = elementObservableValue.getValue().toString();
					}
					break;
				default:
					columnText = super.getColumnText(element, columnIndex);
					break;
				}
			} else {
				if (ESTRUCTURAL_FEATURE == columnIndex) {
					if (valueType instanceof ENamedElement) {
						columnText = ((ENamedElement) valueType).getName();
					}
				}
			}

			return columnText;
		}
		return super.getColumnText(element, columnIndex);
	}
}
