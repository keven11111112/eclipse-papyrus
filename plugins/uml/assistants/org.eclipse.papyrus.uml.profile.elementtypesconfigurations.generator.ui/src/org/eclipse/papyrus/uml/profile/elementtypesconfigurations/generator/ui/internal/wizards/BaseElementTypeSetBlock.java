/*****************************************************************************
 * Copyright (c) 2014, 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.ui.internal.wizards;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.util.Policy;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.nebula.jface.tablecomboviewer.TableComboViewer;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.registries.ElementTypeSetConfigurationRegistry;
import org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.ui.internal.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Ordering;

/**
 * @author damus
 *
 */
class BaseElementTypeSetBlock {

	private static final String DIAGRAM = "diagram"; //$NON-NLS-1$

	private static final String UML_ELEMENT_TYPE_SET = "org.eclipse.papyrus.uml.service.types.UMLElementTypeSet"; //$NON-NLS-1$

	private static final int COLUMN_NAME = 0;
	private static final int COLUMN_LOCATION = 1;

	private final GeneratorWizardModel model;

	private final BiMap<String, ElementTypeSetConfiguration> elementTypeSets;

	public BaseElementTypeSetBlock(GeneratorWizardModel model) {
		super();

		this.model = model;
		this.elementTypeSets = HashBiMap.create(ElementTypeSetConfigurationRegistry.getInstance().getElementTypeSetConfigurations());
	}

	public void createControl(Composite parent) {
		new Label(parent, SWT.NONE).setText("Base element types set:");

		// Use a two-column table because styled label providers don't work in the TableComboViewer
		TableComboViewer combo = new TableComboViewer(parent, SWT.READ_ONLY | SWT.BORDER | SWT.V_SCROLL);
		combo.getTableCombo().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		combo.getTableCombo().defineColumns(2);
		combo.getTableCombo().setDisplayColumnIndex(0);

		combo.setContentProvider(ArrayContentProvider.getInstance());
		combo.setLabelProvider(new DiagramLabelProvider(parent));

		// TableCombo doesn't use a ViewerComparator even when one is set
		combo.setInput(getOrdering().sortedCopy(elementTypeSets.values()));

		ElementTypeSetConfiguration initialSelection = getInitialSelection();
		if (initialSelection != null) {
			combo.setSelection(new StructuredSelection(initialSelection));
			elementTypeSetSelectionChanged((IStructuredSelection) combo.getSelection());
		}
		combo.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				elementTypeSetSelectionChanged((IStructuredSelection) event.getSelection());
				model.validatePage();
			}
		});
	}

	void elementTypeSetSelectionChanged(IStructuredSelection selection) {
		if (selection.isEmpty()) {
			setElementTypeSet(null);
		} else {
			setElementTypeSet((ElementTypeSetConfiguration) selection.getFirstElement());
		}
	}

	void setElementTypeSet(ElementTypeSetConfiguration elementTypeSet) {
		model.setSelectedElementTypeSet((elementTypeSet == null) ? null : elementTypeSets.inverse().get(elementTypeSet));
	}

	void save() {
		model.getDialogSettings().put(DIAGRAM, model.getSelectedElementTypeSet());
	}

	private ElementTypeSetConfiguration getInitialSelection() {
		ElementTypeSetConfiguration result = null;

		String id = model.getDialogSettings().get(DIAGRAM);
		if (id != null) {
			result = elementTypeSets.get(id);
		}

		if (result == null) {
			result = elementTypeSets.get(UML_ELEMENT_TYPE_SET);
		}

		return result;
	}

	static String getName(ElementTypeSetConfiguration elementTypeSet) {
		String result = elementTypeSet.getName();

		if (Strings.isNullOrEmpty(result)) {
			// Infer a name from the URI
			URI uri = elementTypeSet.eResource().getURI();
			result = uri.trimFileExtension().lastSegment();
		}

		return result;
	}

	private static Function<ElementTypeSetConfiguration, String> getNameFunction() {
		return new Function<ElementTypeSetConfiguration, String>() {
			@Override
			public String apply(ElementTypeSetConfiguration input) {
				return getName(input);
			}
		};
	}

	static String getLocation(ElementTypeSetConfiguration elementTypeSet) {
		URI uri = elementTypeSet.eResource().getURI();
		String result;

		if (uri.isPlatformResource()) {
			result = uri.trimSegments(1).toPlatformString(true);
		} else if (uri.isPlatformPlugin()) {
			result = uri.segment(1);
		} else {
			result = uri.toString();
		}

		return result;
	}

	private static Function<ElementTypeSetConfiguration, String> getLocationFunction() {
		return new Function<ElementTypeSetConfiguration, String>() {
			@Override
			public String apply(ElementTypeSetConfiguration input) {
				return getLocation(input);
			}
		};
	}

	static Ordering<ElementTypeSetConfiguration> getOrdering() {
		Ordering<Object> strings = Ordering.from(Policy.getComparator());

		return strings.onResultOf(getNameFunction()).compound(strings.onResultOf(getLocationFunction()));
	}

	//
	// Nested types
	//

	private static class DiagramLabelProvider extends LabelProvider implements IStyledLabelProvider, ITableLabelProvider, ITableColorProvider {
		private ResourceManager images;

		DiagramLabelProvider(Control owner) {
			super();

			// Because we specify an owner, the owner will take care of clean-up, so we
			// don't need a dispose() method of our own
			images = new LocalResourceManager(JFaceResources.getResources(), owner);
		}

		@Override
		public StyledString getStyledText(Object element) {
			return new StyledString(getColumnText(element, COLUMN_NAME)) //
					.append(NLS.bind(" - {0}", getColumnText(element, COLUMN_LOCATION)), StyledString.QUALIFIER_STYLER); //$NON-NLS-1$
		}

		@Override
		public String getColumnText(Object element, int column) {
			ElementTypeSetConfiguration elementTypeSet = (ElementTypeSetConfiguration) element;
			String result;

			switch (column) {
			case COLUMN_NAME:
				result = getName(elementTypeSet);
				break;
			case COLUMN_LOCATION:
				result = getLocation(elementTypeSet);
				break;
			default:
				throw new IllegalArgumentException("no such column: " + column); //$NON-NLS-1$
			}

			return result;
		}

		@Override
		public Image getColumnImage(Object element, int column) {
			Image result = null;

			if (column == COLUMN_NAME) {
				ElementTypeSetConfiguration set = (ElementTypeSetConfiguration) element;
				URI uri = set.eResource().getURI();

				if (uri.isPlatformPlugin()) {
					result = (Image) images.get(Activator.getInstance().getIcon("obj16/plugin.gif")); //$NON-NLS-1$
				} else if (uri.isPlatformResource()) {
					result = (Image) images.get(Activator.getInstance().getIcon("obj16/project.png")); //$NON-NLS-1$
				}
			}

			return result;
		}

		@Override
		public Color getForeground(Object element, int column) {
			Color result = null;

			if (column == COLUMN_LOCATION) {
				result = JFaceResources.getColorRegistry().get(JFacePreferences.QUALIFIER_COLOR);
			}

			return result;
		}

		@Override
		public Color getBackground(Object element, int columnIndex) {
			return null;
		}
	}
}
