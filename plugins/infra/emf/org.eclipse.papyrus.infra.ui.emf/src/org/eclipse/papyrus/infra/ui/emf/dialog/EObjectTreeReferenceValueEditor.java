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

package org.eclipse.papyrus.infra.ui.emf.dialog;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.papyrus.infra.ui.emf.databinding.EObjectObservableValueEditingSupport;
import org.eclipse.papyrus.infra.ui.emf.databinding.EObjectStructuredObservableValue;
import org.eclipse.papyrus.infra.ui.emf.providers.EObjectObservableValueContentProvider;
import org.eclipse.papyrus.infra.ui.emf.providers.EObjectObservableValueLabelProvider;
import org.eclipse.papyrus.infra.widgets.editors.TreeReferenceValueEditor;
import org.eclipse.papyrus.infra.widgets.providers.DelegatingStyledLabelProvider;
import org.eclipse.swt.widgets.Composite;

/**
 * This class extends TreeReferenceDialog and allow the display of EObjectObservableValue.
 */
public class EObjectTreeReferenceValueEditor extends TreeReferenceValueEditor {

	/**
	 * Constructor.
	 *
	 * @param parent
	 *            the parent composite.
	 * @param style
	 *            The style of the composite to create.
	 */
	public EObjectTreeReferenceValueEditor(final Composite parent, final int style) {
		super(parent, style);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.editors.TreeReferenceValueEditor#setValueRootContentProvider()
	 */
	@Override
	public void setValueRootContentProvider() {
		if (null != treeViewer) {
			if (treeViewer.getContentProvider() instanceof EObjectObservableValueContentProvider) {
				((EObjectObservableValueContentProvider) treeViewer.getContentProvider()).setValueRoot(widgetObservable);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.editors.TreeReferenceValueEditor#setProvidersTreeViewer()
	 */
	@Override
	public void setProvidersTreeViewer() {
		treeViewer.setContentProvider(new EObjectObservableValueContentProvider(widgetObservable));
		if (labelProvider instanceof IStyledLabelProvider) {
			treeViewer.setLabelProvider(new EObjectObservableValueLabelProvider((IStyledLabelProvider) labelProvider));
		} else {
			treeViewer.setLabelProvider(new EObjectObservableValueLabelProvider(new DelegatingStyledLabelProvider(labelProvider)));
		}

		treeViewer.setInput(""); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.editors.TreeReferenceValueEditor#createWidgetObservable(org.eclipse.core.databinding.observable.value.IObservableValue)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public IObservableValue createWidgetObservable(final IObservableValue modelProperty) {
		EObjectStructuredObservableValue eObjectObser = null;
		if (modelProperty.getValue() instanceof EObject) {
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain((EObject) modelProperty.getValue());
			eObjectObser = new EObjectStructuredObservableValue((EObject) modelProperty.getValue(), null, editingDomain, true);
		}
		return eObjectObser;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.editors.TreeReferenceValueEditor#createEditingSupport()
	 */
	@Override
	public EditingSupport createEditingSupport() {
		return new EObjectObservableValueEditingSupport(treeViewer, valueFactory);
	}

}
