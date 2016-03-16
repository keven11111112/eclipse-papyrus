/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;

import java.util.Arrays;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.infra.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.PatternViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

/**
 * Selection dialog for icons in bundles.
 */
// TODO implement multiselection with multi return
public class ElementsExplorerDialog extends SelectionStatusDialog {


	/** indicates if several icons can be selected at the same time */
	protected final boolean allowMultiple;

	/** initial value */
	protected String initialValue;

	/** The resource set. */
	protected ResourceSet resourceSet = new ResourceSetImpl();

	/** The tree viewer. */
	protected TreeViewer elementsTreeViewer;

	/** The tree viewer filter. */
	protected PatternViewerFilterEx viewerFilter = new PatternViewerFilterEx();

	/** The information text. */
	private StyledText informationText;

	/** The default profile icon path. */
	private static final String ICONS_EXPAND_ALL = "/icons/expandAll.png";//$NON-NLS-1$

	/** The default profile icon path. */
	private static final String ICONS_COLLAPSE_ALL = "/icons/collapseAll.png";//$NON-NLS-1$

	/** the content provider. */
	private IStructuredContentProvider contentProvider;

	/** The label provider. */
	private IBaseLabelProvider labelProvider;

	/** The input. */
	private Object input;

	/** the return class type. */
	private Class<?> returnClass;

	public ElementsExplorerDialog(final Shell parentShell, final boolean allowMultiple, final String initialQualifyName) {
		super(parentShell);
		this.allowMultiple = allowMultiple;
		this.initialValue = initialQualifyName;
	}

	public ElementsExplorerDialog(final Shell parentShell, final String initialValue) {
		this(parentShell, false, initialValue);
	}

	public ElementsExplorerDialog(final Shell parentShell) {
		this(parentShell, false, "");//$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * Unloads resources.
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#close()
	 */
	@Override
	public boolean close() {
		for (Resource resource : resourceSet.getResources()) {
			if (resource.isLoaded()) {
				resource.unload();
			}
		}
		return super.close();
	}

	/**
	 * Return the selected {@link Stereotype}.
	 * {@inheritDoc}
	 */
	@Override
	protected void computeResult() {
		Object selectedElements = getSelectedElements();
		if (null != selectedElements) {
			setResult(Arrays.asList(selectedElements));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(final Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		initializeDialogUnits(composite);

		// creates the message area, as defined in the super class
		createMessageArea(composite);
		createFilterText(composite);
		createExpandCollapseButtons(composite);
		createFilteredList(composite);
		createInformationText(composite);

		selectInitialValue();
		refreshOkButton();
		return composite;
	}

	/**
	 * Create buttons to collapse and expand treeViewer.
	 */
	protected void createExpandCollapseButtons(final Composite composite) {
		if (contentProvider instanceof ITreeContentProvider) {
			Composite container = new Composite(composite, SWT.NONE);
			GridLayout layout = new GridLayout(2, true);
			layout.horizontalSpacing = 2;
			layout.marginBottom = -5;
			layout.marginBottom = -5;
			container.setLayout(layout);

			Label buttonExpand = new Label(container, SWT.NONE);
			Image imageExpand = Activator.getDefault().getImage(ICONS_EXPAND_ALL);
			buttonExpand.setImage(imageExpand);
			buttonExpand.addMouseListener(new MouseAdapter() {
				/**
				 * {@iniriteDoc]
				 * 
				 * @see org.eclipse.swt.events.MouseAdapter#mouseUp(org.eclipse.swt.events.MouseEvent)
				 */
				@Override
				public void mouseUp(MouseEvent event) {
					elementsTreeViewer.expandAll();
				}
			});

			Label buttonCollapse = new Label(container, SWT.NONE);
			Image imageCollapse = Activator.getDefault().getImage(ICONS_COLLAPSE_ALL);
			buttonCollapse.setImage(imageCollapse);
			buttonCollapse.addMouseListener(new MouseAdapter() {
				/**
				 * {@iniriteDoc]
				 * 
				 * @see org.eclipse.swt.events.MouseAdapter#mouseUp(org.eclipse.swt.events.MouseEvent)
				 */
				@Override
				public void mouseUp(MouseEvent event) {
					elementsTreeViewer.collapseAll();
				}
			});
		}
	}

	/**
	 * Selected the initial value in treeViewer.
	 */
	protected void selectInitialValue() {
		// //Select initialValue Stereotype
		if (!initialValue.isEmpty()) {
			ITreeContentProvider contentProvider = (ITreeContentProvider) elementsTreeViewer.getContentProvider();
			Object[] roots = contentProvider.getElements(null);
			// TODO select initial value
			// for (Object root : roots) {
			// Object[] profiles = contentProvider.getChildren(root);
			// for (Object profile : profiles) {
			// Object[] stereotypes = contentProvider.getChildren(profile);
			// for (Object stereotype : stereotypes) {
			// // if (stereotype instanceof Stereotype && initialValue.equals(((Stereotype) stereotype).getQualifiedName())) {
			// // elementsTreeViewer.expandToLevel(profile, 1);
			// // elementsTreeViewer.setSelection(new StructuredSelection(stereotype), true);
			// // break;
			// // }
			//
			// }
			// }
			// }
		}
	}

	/**
	 * Create information text field.
	 */
	protected void createInformationText(final Composite composite) {
		informationText = new StyledText(composite, SWT.BORDER | SWT.MULTI | SWT.READ_ONLY | SWT.H_SCROLL);
		informationText.setLayoutData(new GridData(SWT.FILL, SWT.WRAP, true, false));
		informationText.setAlwaysShowScrollBars(false);
	}

	/**
	 * Creates a filtered list.
	 *
	 * @param parent
	 *            the parent composite.
	 * @return returns the filtered list widget.
	 */
	protected TreeViewer createFilteredList(final Composite parent) {

		Tree tree = new Tree(parent, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		final GridLayout filterLayout = new GridLayout();
		filterLayout.marginHeight = 0;
		filterLayout.marginWidth = 0;
		tree.setLayout(filterLayout);
		{
			GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
			tree.setLayoutData(gridData);
		}

		TreeViewer treeViewer = new TreeViewer(tree);
		treeViewer.setContentProvider(new EncapsulatedContentProvider(contentProvider));
		treeViewer.setLabelProvider(labelProvider);

		treeViewer.setFilters(viewerFilter);

		treeViewer.setInput(null != input ? input : new Object());

		// Selection change listener to refresh button and information
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(final SelectionChangedEvent event) {
				refreshOkButton();
				refreshInformationText();
			}
		});

		// Double click listener to validate with double click
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(final DoubleClickEvent event) {
				if (getOkButton().isEnabled()) {
					okPressed();
				}
			}

		});

		treeViewer.refresh();
		elementsTreeViewer = treeViewer;

		return treeViewer;
	}

	/**
	 * Pattern viewer filter extension used to filter elements from stereotype tree viewer with the text field.
	 * Extended to filter only applicable {@link Stereotype} from source {@link Element}.
	 */
	private class PatternViewerFilterEx extends PatternViewerFilter {
		/**
		 * Only set it visible if we can load the profile.
		 * 
		 * @see org.eclipse.papyrus.infra.widgets.providers.PatternViewerFilter#isVisible(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		@Override
		public boolean isVisible(final Viewer viewer, final Object parentElement, final Object element) {

			boolean visible = super.isVisible(viewer, parentElement, element);
			visible &= ElementsExplorerDialog.this.isVisible(element);
			return visible;
		}

		/**
		 * Override to pass method from protected to public.
		 * 
		 * @see org.eclipse.papyrus.infra.widgets.providers.AbstractTreeFilter#clearCache()
		 */
		public void clearCache() {
			super.clearCache();
		}
	}

	/**
	 * Creates an area where a filter can be entered.
	 *
	 * @param parent
	 *            the parent composite where to create the filter text
	 * @return the created text area
	 */
	protected void createFilterText(final Composite parent) {
		// Create the filter composite
		final StringWithClearEditor filterText = new StringWithClearEditor(parent, SWT.BORDER);

		filterText.setValue("");//$NON-NLS-1$

		filterText.getText().addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(final ModifyEvent e) {
				String value = filterText.getValue();
				viewerFilter.setPattern(value);
				elementsTreeViewer.refresh();
				elementsTreeViewer.collapseAll();
				// If some text in filter expands to the stereotype level else to the profile level
				elementsTreeViewer.expandToLevel(value.isEmpty() ? 2 : 3);
			}
		});

		// Key listener to focus in the treviewer when presser arrow down key
		filterText.getText().addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void keyPressed(final KeyEvent e) {
				if (e.keyCode == SWT.ARROW_DOWN) {
					elementsTreeViewer.getControl().setFocus();
				}
			}
		});
	}

	/**
	 * Returns the currently selected element.
	 * To be called within or after open().
	 *
	 * @return returns the currently selected element.
	 */
	protected Object getSelectedElements() {
		Assert.isNotNull(elementsTreeViewer);
		return elementsTreeViewer.getStructuredSelection().getFirstElement();
	}

	/**
	 * Refresh the Ok button according to the selection.
	 */
	protected void refreshOkButton() {
		Object selectedElements = getSelectedElements();

		if (null != selectedElements && (null == returnClass || returnClass.isInstance(selectedElements))) {
			updateStatus(new Status(IStatus.OK, Activator.PLUGIN_ID, ""));//$NON-NLS-1$
		} else {
			updateStatus(new Status(IStatus.ERROR, Activator.PLUGIN_ID, ""));//$NON-NLS-1$
		}
	}

	/**
	 * Refresh the Information text according to the selection. To be implemented by client.
	 */
	protected void refreshInformationText() {
		// To be implemented by client.
	}


	/**
	 * Return true if element have to be visible. It can be used to force element to be visible even if the filter dosen't not match with them.
	 */
	protected boolean isVisible(final Object element) {
		return true;
	}

	/**
	 * Set the content provider of the treeviewer.
	 */
	public void setContentProvider(final IStructuredContentProvider contentProvider) {
		this.contentProvider = contentProvider;
		if (null != elementsTreeViewer) {
			elementsTreeViewer.setContentProvider(new EncapsulatedContentProvider(contentProvider));
		}
	}

	/**
	 * Set the label provider of the treeviewer.
	 */
	public void setLabelProvider(final IBaseLabelProvider labelProvider) {
		this.labelProvider = labelProvider;
		if (null != elementsTreeViewer) {
			elementsTreeViewer.setLabelProvider(labelProvider);
		}
	}

	/**
	 * Set the input.
	 */
	public void setInput(final Object input) {
		this.input = input;
		if (null != elementsTreeViewer) {
			elementsTreeViewer.setInput(input);
		}
	}

	/**
	 * Sets the return type Class that will be return.
	 */
	public void setReturnTypeClass(final Class<?> returnClass) {
		this.returnClass = returnClass;
	}

}
