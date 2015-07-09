/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *	Saadia Dhouib (CEA LIST) - Implementation of loading diagrams from template files  (.uml, .di , .notation)
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

/**
 * The Class SelectModelTemplateComposite.
 */
public class SelectModelTemplateComposite extends Composite {

	private CheckboxTableViewer templateTableViewer;

	private ComboViewer singleTemplateCombo;

	private ModelTemplateDescription selectedTemplate;

	private GridData gridTable;

	/**
	 * Instantiates a new select model template composite.
	 *
	 * @param parent
	 *            the parent
	 */
	public SelectModelTemplateComposite(Composite parent) {
		super(parent, SWT.NONE);
		this.setLayout(new GridLayout());
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		createTemplatesViewer(this);
	}

	/**
	 * Disable.
	 */
	public void disable() {
		if (templateTableViewer != null) {
			templateTableViewer.getTable().setEnabled(false);
		}
	}

	/**
	 * Creates the templates viewer.
	 *
	 * @param composite
	 *            the composite
	 */
	private void createTemplatesViewer(Composite composite) {

		singleTemplateCombo = new ComboViewer(composite, SWT.READ_ONLY);
		singleTemplateCombo.getControl().setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		singleTemplateCombo.setContentProvider(new ModelTemplatesContentProvider());
		singleTemplateCombo.setLabelProvider(new LabelProvider() {

			/**
			 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
			 *
			 * @param element
			 * @return
			 */

			@Override
			public String getText(Object element) {
				if (element instanceof ModelTemplateDescription) {
					ModelTemplateDescription currentTemplate = (ModelTemplateDescription) element;
					return currentTemplate.getName();
				}
				return ""; //$NON-NLS-1$
			}


		});

		singleTemplateCombo.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				StructuredSelection template = (StructuredSelection) event.getSelection();
				selectedTemplate = (ModelTemplateDescription) template.getFirstElement();
			}
		});

		templateTableViewer = CheckboxTableViewer.newCheckList(composite, SWT.V_SCROLL);
		gridTable = new GridData(SWT.FILL, SWT.TOP, true, false);
		templateTableViewer.getTable().setLayoutData(gridTable);
		templateTableViewer.getTable().setBackground(composite.getBackground());
		templateTableViewer.setContentProvider(new ModelTemplateTransfoProvider());
		templateTableViewer.setLabelProvider(new ModelTemplatesLabelProvider());
	}

	/**
	 * Gets the uml model template path.
	 *
	 * @return the uml model template path
	 */
	public String getTemplatePath() {
		if (selectedTemplate != null) {
			return selectedTemplate.getUml_path();
		}
		return null;
	}

	/**
	 * Gets the di file template path.
	 *
	 * @return the di file template path
	 */
	public String getDiTemplatePath() {
		if (selectedTemplate != null) {
			return selectedTemplate.getDi_path();
		}
		return null;
	}

	/**
	 * Gets the notation template path.
	 *
	 * @return the notation template path
	 */
	public String getNotationTemplatePath() {
		if (selectedTemplate != null) {
			return selectedTemplate.getNotation_path();
		}
		return null;
	}

	/**
	 * Gets the template plugin id.
	 *
	 * @return the template plugin id
	 */
	public String getTemplatePluginId() {
		if (selectedTemplate != null) {
			return selectedTemplate.getPluginId();
		}
		return null;
	}

	/**
	 * Select template.
	 *
	 * @param toSelect
	 *            the to select
	 */
	public void selectElement(Object toSelect) {
		if (templateTableViewer != null) {
			templateTableViewer.setCheckedElements(new Object[] { toSelect });
		}
	}

	/**
	 * Gets the content provider.
	 *
	 * @return the content provider
	 */
	public ModelTemplatesContentProvider getContentProvider() {
		if (templateTableViewer != null) {
			return (ModelTemplatesContentProvider) templateTableViewer.getContentProvider();
		}
		return null;
	}


	public List<ModelTemplateDescription> getTemplateTransfoPath() {
		if (templateTableViewer != null) {
			Object[] selection = templateTableViewer.getCheckedElements();
			if (selection.length <= 1) {
				List<ModelTemplateDescription> templatePath = new ArrayList<ModelTemplateDescription>();
				for (Object currentObject : selection) {
					templatePath.add((ModelTemplateDescription) currentObject);
				}
				return templatePath;
			}
		}
		return null;
	}


	public List<String> getDiTemplateTransfoPath() {
		if (templateTableViewer != null) {
			Object[] selection = templateTableViewer.getCheckedElements();
			if (selection.length <= 1) {
				List<String> templatePath = new ArrayList<String>();
				for (Object currentObject : selection) {
					templatePath.add(((ModelTemplateDescription) currentObject).getDi_path());
				}
				return templatePath;
			}
		}
		return null;
	}

	public List<String> getNotationTemplateTransfoPath() {
		if (templateTableViewer != null) {
			Object[] selection = templateTableViewer.getCheckedElements();
			if (selection.length <= 1) {
				List<String> templatePath = new ArrayList<String>();
				for (Object currentObject : selection) {
					templatePath.add(((ModelTemplateDescription) currentObject).getNotation_path());
				}
				return templatePath;
			}
		}
		return null;
	}

	public List<String> getTemplateTransfoPluginID() {
		if (templateTableViewer != null) {
			Object[] selection = templateTableViewer.getCheckedElements();
			if (selection.length <= 1) {
				List<String> templatePath = new ArrayList<String>();
				for (Object currentObject : selection) {
					templatePath.add(((ModelTemplateDescription) currentObject).getPluginId());
				}
				return templatePath;
			}
		}
		return null;
	}


	/**
	 * Used to check the number of items displayed by the viewer
	 * 
	 * @return
	 * 		The viewer's Combo
	 */
	public Combo getTemplateCombo() {
		return singleTemplateCombo.getCombo();
	}


	/**
	 * Sets the input.
	 *
	 * @param input
	 *            the new input
	 */
	public void setInput(Object input) {
		if (templateTableViewer != null) {
			templateTableViewer.setInput(input);
		}
		singleTemplateCombo.setInput(input);

		// Resize the template table to minimize the space lost
		int tableItemHeight = templateTableViewer.getTable().getItemHeight();
		int tableItemCount = ((ModelTemplateTransfoProvider) templateTableViewer.getContentProvider()).getElements(input).length;
		gridTable.minimumHeight = tableItemCount != 0 ? tableItemHeight * Math.max(1, Math.round((tableItemCount / 2))) : 0;
		gridTable.heightHint = tableItemCount != 0 ? tableItemHeight * Math.max(1, Math.round((tableItemCount / 2))) : 0;

		// Notifies the shell that the layout needs to be resized
		((Composite) templateTableViewer.getControl()).layout(true, true);
	}

}
