/*****************************************************************************
 * Copyright (c) 2010, 2016 CEA LIST, Christian W. Damus, and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *  Christian W. Damus - bugs 466850, 490936
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards.pages;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.uml.diagram.wizards.category.DiagramCategoryDescriptor;
import org.eclipse.papyrus.uml.diagram.wizards.category.DiagramCategoryRegistry;
import org.eclipse.papyrus.uml.diagram.wizards.messages.Messages;
import org.eclipse.papyrus.uml.diagram.wizards.utils.SettingsHelper;
import org.eclipse.papyrus.uml.diagram.wizards.wizards.CreateModelWizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;


/**
 * The Class SelectDiagramCategoryPage.
 */
public class SelectDiagramCategoryPage extends WizardPage {

	/** The my diagram kind buttons. */
	final private List<Button> myDiagramKindButtons = new ArrayList<Button>();

	/** The diagram category. */
	private final List<String> mySelectedDiagramCategoryIds = new LinkedList<String>();

	/** The most recently selected category, even if multiple selection is permitted. */
	private String lastSelectedCategory;

	/** The Constant PAGE_ID. */
	public static final String PAGE_ID = "SelectDiagramCategory"; //$NON-NLS-1$

	/** The Constant DEFAULT_EXTENSION. */
	public static final String DEFAULT_EXTENSION = "uml"; //$NON-NLS-1$

	/** uml core languages label */
	private static final List<String> umlCore = Arrays.asList("UML", "Profile"); //$NON-NLS-1$ //$NON-NLS-2$

	/** The my allow several categories. */
	private final boolean myAllowSeveralCategories;

	private SettingsHelper settingsHelper;

	private final Collator collator = Collator.getInstance();


	/**
	 * Instantiates a new select diagram category page.
	 *
	 */
	public SelectDiagramCategoryPage() {
		this(false);
	}

	/**
	 * Instantiates a new select diagram category page.
	 *
	 * @param allowSeveralCategories
	 *            the allow several categories
	 */
	public SelectDiagramCategoryPage(boolean allowSeveralCategories) {
		super(PAGE_ID);
		myAllowSeveralCategories = allowSeveralCategories;
		setTitle(Messages.SelectDiagramCategoryPage_select_language);
	}

	/**
	 * Sets the wizard.
	 *
	 * @param newWizard
	 *            the new wizard
	 * @see org.eclipse.jface.wizard.WizardPage#setWizard(org.eclipse.jface.wizard.IWizard)
	 */
	@Override
	public void setWizard(IWizard newWizard) {
		super.setWizard(newWizard);
		settingsHelper = new SettingsHelper(getDialogSettings());
		String[] defaultDiagramCategory = settingsHelper.getDefaultDiagramCategories();

		if (defaultDiagramCategory != null && defaultDiagramCategory.length > 0) {
			String defaultSelection = Arrays.asList(defaultDiagramCategory).contains(DEFAULT_EXTENSION) ? DEFAULT_EXTENSION : defaultDiagramCategory[0];
			if (myAllowSeveralCategories) {
				setDefaultDiagramCategories(defaultDiagramCategory);
			} else {
				String previousSelection = settingsHelper.getPreviousSelection();
				// Retrieves the previous selection or the selects the default behavior
				if (settingsHelper.rememberCurrentSelection(getDialogSettings()) && previousSelection != null) {
					setDefaultDiagramCategories(new String[] { previousSelection });
				} else {
					setDefaultDiagramCategories(new String[] { defaultSelection });
				}
			}
		}
	}

	/**
	 * Creates the control.
	 *
	 * @param parent
	 *            the parent
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		plate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout gridLayout = new GridLayout();
		gridLayout.marginWidth = 10;
		plate.setLayout(gridLayout);
		setControl(plate);
		createDiagramCategoryForm(plate);

		// Bug(466850): Do this later because the new-file page's resource group is not yet created
		plate.getDisplay().asyncExec(new Runnable() {

			@Override
			public void run() {
				setPageComplete(validatePage());
			}
		});
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);

		// re-validate in case the user changed the file name on previous page
		setPageComplete(validatePage());
	}


	/**
	 * Gets the diagram categories.
	 *
	 * @return the diagram categories
	 */
	public String[] getDiagramCategories() {
		return mySelectedDiagramCategoryIds.toArray(new String[mySelectedDiagramCategoryIds.size()]);
	}

	/**
	 * Sets the default diagram categories.
	 *
	 * @param categories
	 *            the new default diagram categories
	 */
	protected final void setDefaultDiagramCategories(String[] categories) {
		mySelectedDiagramCategoryIds.clear();
		mySelectedDiagramCategoryIds.addAll(Arrays.asList(categories));
	}


	/**
	 * Validate page.
	 *
	 * @return true, if successful
	 */
	protected boolean validatePage() {
		setMessage(null);
		setErrorMessage(null);
		String[] categories = getDiagramCategories();
		if (categories == null || categories.length == 0) {
			setErrorMessage(Messages.SelectDiagramCategoryPage_select_one_category);
			return false;
		}
		if (!validateFileExtension(categories)) {
			return false;
		}

		return true;
	}

	/**
	 * Validate file extension.
	 *
	 * @param categories
	 *            the categories
	 * @return true, if successful
	 */
	protected boolean validateFileExtension(String... categories) {
		IStatus status = ((CreateModelWizard) getWizard()).diagramCategoryChanged(categories);
		switch (status.getSeverity()) {
		// case Status.ERROR:
		// setErrorMessage(status.getMessage());
		// return false;
		case Status.WARNING:
			setMessage(status.getMessage(), IMessageProvider.WARNING);
			break;
		case IStatus.INFO:
			setMessage(status.getMessage(), IMessageProvider.INFORMATION);
			break;
		}
		return true;
	}

	/**
	 * Gets the diagram category map.
	 *
	 * @return the diagram category map
	 */
	protected Map<String, DiagramCategoryDescriptor> getDiagramCategoryMap() {
		return DiagramCategoryRegistry.getInstance().getDiagramCategoryMap();
	}

	/**
	 * Creates the diagram language form.
	 *
	 * @param composite
	 *            the composite
	 */
	private void createDiagramCategoryForm(Composite composite) {
		Group group = createGroup(composite, Messages.SelectDiagramCategoryPage_diagram_language_group);

		// To sort the different languages by name
		collator.setStrength(Collator.SECONDARY);
		Comparator<DiagramCategoryDescriptor> setComparator = new Comparator<DiagramCategoryDescriptor>() {

			@Override
			public int compare(DiagramCategoryDescriptor descriptor1, DiagramCategoryDescriptor descriptor2) {
				String button1Data = descriptor1.getLabel();
				String button2Data = descriptor2.getLabel();
				// Special consideration for the UML language as it should always be on top
				if (button2Data.equalsIgnoreCase(DEFAULT_EXTENSION)) {
					return 1;
				} else if (button1Data.equalsIgnoreCase(DEFAULT_EXTENSION)) {
					return -1;
				} else {
					// This if the usual sorting method
					return collator.compare(button1Data, button2Data);
				}
			}

		};
		// To store the different languages and display them
		SortedSet<DiagramCategoryDescriptor> descriptorUMLSet = new TreeSet<DiagramCategoryDescriptor>(setComparator);
		SortedSet<DiagramCategoryDescriptor> descriptorDSMLSet = new TreeSet<DiagramCategoryDescriptor>(setComparator);

		SelectionListener listener = new SelectionListener() {

			private SelectionEvent prevEvent;

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (e == prevEvent) {
					return;
				}
				Button selected = ((Button) e.widget);
				diagramCategorySelected((String) selected.getData(), selected.getSelection());
				setPageComplete(validatePage());
				prevEvent = e;
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};

		for (DiagramCategoryDescriptor diagramCategoryDescriptor : getDiagramCategoryMap().values()) {
			String descriptorLabel = diagramCategoryDescriptor.getLabel();
			if (umlCore.contains(descriptorLabel)) {
				descriptorUMLSet.add(diagramCategoryDescriptor);
			} else {
				descriptorDSMLSet.add(diagramCategoryDescriptor);
			}
		}

		if (!descriptorUMLSet.isEmpty()) {
			Label coreLabel = new Label(group, SWT.NONE);
			coreLabel.setText(Messages.SelectDiagramCategoryPage_umlGroup);
			for (DiagramCategoryDescriptor diagramCategoryDescriptor : descriptorUMLSet) {
				Button button = createCategoryButton(diagramCategoryDescriptor, group);
				button.addSelectionListener(listener);
				myDiagramKindButtons.add(button);
			}
		}

		if (!descriptorDSMLSet.isEmpty()) {
			Label dsmlLabel = new Label(group, SWT.NONE);
			dsmlLabel.setText(Messages.SelectDiagramCategoryPage_dsmlGroup);
			for (DiagramCategoryDescriptor diagramCategoryDescriptor : descriptorDSMLSet) {
				Button button = createCategoryButton(diagramCategoryDescriptor, group);
				button.addSelectionListener(listener);
				myDiagramKindButtons.add(button);
			}
		}

		checkDiagramCategoryButtons();
		// Initialize the first selection upon opening the wizard
		setDefaultSelection(DEFAULT_EXTENSION);
	}

	/**
	 * Sets the default language selection based on the DEFAULT_EXTENSION parameter
	 * 
	 * @param defaultExtension
	 */
	private void setDefaultSelection(String defaultExtension) {
		String previousSelection = settingsHelper.getPreviousSelection();
		String defaultSelection = previousSelection != null ? previousSelection : defaultExtension;

		for (Button button : myDiagramKindButtons) {
			if (defaultSelection.equalsIgnoreCase((String) button.getData())) {
				button.setSelection(true);
				diagramCategorySelected(defaultSelection, button.getSelection());
			}
		}
	}

	/**
	 * Diagram category selected.
	 *
	 * @param category
	 *            the category
	 * @param checked
	 *            the checked
	 */
	protected void diagramCategorySelected(String category, boolean checked) {
		if (checked) {
			if (!mySelectedDiagramCategoryIds.contains(category)) {
				if (!myAllowSeveralCategories) {
					// Can only have one selection
					mySelectedDiagramCategoryIds.clear();
				}
				mySelectedDiagramCategoryIds.add(category);
			}
			lastSelectedCategory = category;
		} else {
			mySelectedDiagramCategoryIds.remove(category);
			lastSelectedCategory = mySelectedDiagramCategoryIds.isEmpty()
					? null
					: mySelectedDiagramCategoryIds.get(mySelectedDiagramCategoryIds.size() - 1);
		}

	}

	/**
	 * Check diagram category buttons.
	 */
	protected void checkDiagramCategoryButtons() {
		checkButtonsFor(mySelectedDiagramCategoryIds.toArray(new String[mySelectedDiagramCategoryIds.size()]));
	}

	/**
	 * Check buttons for.
	 *
	 * @param diagramCategories
	 *            the diagram categories
	 */
	protected void checkButtonsFor(String... diagramCategories) {
		for (Button button : myDiagramKindButtons) {
			button.setSelection(false);
		}
		for (Button button : myDiagramKindButtons) {
			for (String diagramCategory : diagramCategories) {
				if (diagramCategory.equalsIgnoreCase((String) button.getData())) {
					button.setSelection(true);
				}
			}
		}
	}

	/**
	 * Creates the category button.
	 *
	 * @param diagramCategoryDescriptor
	 *            the diagram category descriptor
	 * @param group
	 *            the group
	 * @return the button
	 */
	private Button createCategoryButton(DiagramCategoryDescriptor diagramCategoryDescriptor, Group group) {
		Button button = new Button(group, myAllowSeveralCategories ? SWT.CHECK : SWT.RADIO);
		button.setText(diagramCategoryDescriptor.getLabel());
		button.setData(diagramCategoryDescriptor.getId());
		Image image = getImage(diagramCategoryDescriptor.getIcon());
		if (image != null) {
			button.setImage(image);
		}
		button.setToolTipText(diagramCategoryDescriptor.getDescription());
		return button;
	}

	/**
	 * Gets the image.
	 *
	 * @param imageDescriptor
	 *            the image descriptor
	 * @return the image
	 */
	private static Image getImage(ImageDescriptor imageDescriptor) {
		if (imageDescriptor != null) {
			return new Image(null, imageDescriptor.getImageData());
		}
		return null;
	}

	/**
	 * Creates the group.
	 *
	 * @param parent
	 *            the parent
	 * @param name
	 *            the name
	 * @return the group
	 */
	private static Group createGroup(Composite parent, String name) {
		Group group = new Group(parent, SWT.NONE);
		group.setText(name);
		GridLayout layout = new GridLayout(1, false);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		group.setLayout(layout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		group.setLayoutData(data);
		return group;
	}

	@Override
	public void performHelp() {
		PlatformUI.getWorkbench().getHelpSystem().displayHelp("org.eclipse.papyrus.uml.diagram.wizards.Category"); //$NON-NLS-1$

	}

	/**
	 * Respond to completion of the wizard. Includes saving settings for the next
	 * invocation of the wizard.
	 * 
	 * @since 2.0
	 */
	public void performFinish() {
		// Notifies the settings file that the selection has been set and to what
		settingsHelper.setCurrentSelection(lastSelectedCategory);
		settingsHelper.saveRememberCurrentSelection(true);

	}
}
