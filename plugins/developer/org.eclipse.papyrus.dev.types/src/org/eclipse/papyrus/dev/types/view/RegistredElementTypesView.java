/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.dev.types.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.dev.types.providers.ElementTypesContentProvider;
import org.eclipse.papyrus.dev.types.providers.ElementTypesDetailsContentProvider;
import org.eclipse.papyrus.dev.types.providers.ElementTypesDetailsLabelProvider;
import org.eclipse.papyrus.dev.types.providers.ElementTypesLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.ViewPart;

public class RegistredElementTypesView extends ViewPart {

	FilteredTree detailsFilteredTree = null;
	SashForm sash = null;
	FilteredTree elementTypesFilteredTree = null;
	Combo combo = null;


	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, true));

		combo = new Combo(parent, SWT.NONE);
		final List<String> itemsList = new ArrayList<>();
		List<IClientContext> contexts = new ArrayList<IClientContext>(ClientContextManager.getInstance().getClientContexts());

		int index = -1;
		int i = 0;
		for (IClientContext context : contexts) {
			itemsList.add(context.getId());
			if (context.getId().equals(ClientContextManager.getDefaultClientContext().getId())) {
				index = i;
			}
			i++;
		}
		String[] items = new String[itemsList.size()];
		items = itemsList.toArray(items);
		combo.setItems(items);
		if (index != -1) {
			combo.select(index);
		}
		combo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = combo.getSelectionIndex();

				String clientContexId = itemsList.get(index);

				if (clientContexId != null) {
					IClientContext clientContex = ClientContextManager.getInstance().getClientContext(clientContexId);
					if (clientContex != null) {
						IElementType[] elementTypes = ElementTypeRegistry.getInstance().getElementTypes(clientContex);
						elementTypesFilteredTree.getViewer().setInput(elementTypes);
					}
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {


			}
		});

		sash = new SashForm(parent, SWT.HORIZONTAL);
		sash.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		elementTypesFilteredTree = new FilteredTree(sash, SWT.BORDER, new PatternFilter(), true);
		elementTypesFilteredTree.getViewer().setLabelProvider(new ElementTypesLabelProvider());
		elementTypesFilteredTree.getViewer().setContentProvider(new ElementTypesContentProvider());
		detailsFilteredTree = new FilteredTree(sash, SWT.BORDER, new PatternFilter(), true);
		detailsFilteredTree.getViewer().setLabelProvider(new ElementTypesDetailsLabelProvider());
		detailsFilteredTree.getViewer().setContentProvider(new ElementTypesDetailsContentProvider());

		if (index != -1) {
			combo.select(index);
		}

		elementTypesFilteredTree.getViewer().addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					detailsFilteredTree.getViewer().setInput(((IStructuredSelection) event.getSelection()).getFirstElement());
				}

			}
		});
	}

	@Override
	public void setFocus() {

	}
}
