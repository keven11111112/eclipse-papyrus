/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *     Tatiana Fesenko(CEA) - improved look&feel
 *     Saadia Dhouib (CEA LIST) - Implementation of loading diagrams from template files  (.uml, .di , .notation)
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards.pages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.commands.CreationCommandRegistry;
import org.eclipse.papyrus.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.infra.viewpoints.configuration.Category;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.papyrus.uml.diagram.wizards.Activator;
import org.eclipse.papyrus.uml.diagram.wizards.kind.DiagramKindComposite;
import org.eclipse.papyrus.uml.diagram.wizards.kind.DiagramKindLabelProvider;
import org.eclipse.papyrus.uml.diagram.wizards.messages.Messages;
import org.eclipse.papyrus.uml.diagram.wizards.profile.ProfileChooserComposite;
import org.eclipse.papyrus.uml.diagram.wizards.template.ModelTemplateDescription;
import org.eclipse.papyrus.uml.diagram.wizards.template.SelectModelTemplateComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.NamedElement;

/**
 * This WizardPage to select the kind of Papyrus Diagram. List all kind of diagrams registered with
 * creationCommand attribute in PapyrusDiagram Eclipse extension.
 *
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @author Tatiana Fesenko
 */
public class SelectDiagramKindPage extends WizardPage {

	/** The Constant PAGE_ID. */
	public static final String PAGE_ID = "SelectDiagramKind"; //$NON-NLS-1$

	/** The diagram name text field. */
	private Text nameText;

	/** The select template composite. */
	private SelectModelTemplateComposite selectTemplateComposite;

	/** the select diagram Kind composite */
	private DiagramKindComposite diagramKindComposite;

	private ProfileChooserComposite profileChooserComposite;

	/** The my category provider. */
	private final CategoryProvider myCategoryProvider;

	/** The allow templates. */
	private final boolean allowTemplates;

	/** The my creation command registry. */
	private final ICreationCommandRegistry myCreationCommandRegistry;

	private static EObject modelRoot;

	/** The Constant DEFAULT_CREATION_COMMAND_REGISTRY. */
	public static final ICreationCommandRegistry DEFAULT_CREATION_COMMAND_REGISTRY = CreationCommandRegistry.getInstance(org.eclipse.papyrus.infra.ui.Activator.PLUGIN_ID);

	/**
	 * Instantiates a new select diagram kind page.
	 *
	 * @param categoryProvider
	 *            the category provider
	 */
	public SelectDiagramKindPage(CategoryProvider categoryProvider) {
		this(true, categoryProvider, DEFAULT_CREATION_COMMAND_REGISTRY);
	}

	/**
	 * Instantiates a new select diagram kind page.
	 *
	 * @param allowTemplates
	 *            the allow templates
	 * @param categoryProvider
	 *            the category provider
	 * @param creationCommandRegistry
	 *            the creation command registry
	 */
	public SelectDiagramKindPage(boolean allowTemplates, CategoryProvider categoryProvider, ICreationCommandRegistry creationCommandRegistry) {
		super(PAGE_ID);
		setTitle(Messages.SelectDiagramKindPage_page_title);
		setDescription(Messages.SelectDiagramKindPage_page_desc);
		this.allowTemplates = allowTemplates;
		myCategoryProvider = categoryProvider;
		myCreationCommandRegistry = creationCommandRegistry;
	}

	/**
	 * Creates the control.
	 *
	 * @param parent
	 *            the parent {@inheritDoc}
	 */
	@Override
	public void createControl(Composite parent) {
		Composite pageComposite = new Composite(parent, SWT.NONE);
		pageComposite.setLayout(new GridLayout());
		pageComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		String[] categories = getDiagramCategories();

		Composite nameFormComposite = new Composite(pageComposite, SWT.NONE);
		nameFormComposite.setLayout(new GridLayout());
		nameFormComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		createNameForm(nameFormComposite);

		Composite diagramKindComposite = new Composite(pageComposite, SWT.NONE);
		diagramKindComposite.setLayout(new GridLayout());
		diagramKindComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		createDiagramKindForm(diagramKindComposite);
		this.diagramKindComposite.setInput(categories);

		Composite modelTemplateComposite = new Composite(pageComposite, SWT.NONE);
		modelTemplateComposite.setLayout(new GridLayout());
		modelTemplateComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		createModelTemplateComposite(modelTemplateComposite);
		fillInTables(categories);

		Composite profileChooserComposite = new Composite(pageComposite, SWT.NONE);
		profileChooserComposite.setLayout(new GridLayout());
		profileChooserComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		createProfileFileChooser(profileChooserComposite);

		setControl(pageComposite);
	}

	/**
	 * Create the filechooser composite
	 *
	 * @param parent
	 */
	private void createProfileFileChooser(Composite parent) {
		Group group = createGroup(parent, Messages.SelectDiagramKindPage_0);
		profileChooserComposite = new ProfileChooserComposite(group);
		profileChooserComposite.getTextField().addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent ev) {
				validatePage();
			}

		});
	}

	public String getProfileURI() {
		return profileChooserComposite.getProfileURI();
	}

	/**
	 * Check that the provided path matches against a known Profile and that it is defined
	 * 
	 * @return
	 * 		true if the retrieved profile is correctly defined, false otherwise
	 */
	public IStatus getProfileDefinitionStatus() {
		return profileChooserComposite.getProfileDefinitionStatus();
	}

	/**
	 * Sets the visible.
	 *
	 * @param visible
	 *            the new visible
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 */
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			fillInTables(getDiagramCategories());
			validatePage();
			// Deactivates the viewer if its contained list is empty
			Combo templateCombo = selectTemplateComposite.getTemplateCombo();
			if (templateCombo.getItemCount() == 0) {
				templateCombo.setEnabled(false);
			} else {
				templateCombo.setEnabled(true);
			}

			if (!allowTemplates) {
				selectTemplateComposite.disable();
			}
		}
	}

	/**
	 * Fill in tables.
	 *
	 * @param categories
	 *            the categories
	 */
	private void fillInTables(String[] categories) {
		if (categories == null || categories.length == 0) {
			return;
		}
		diagramKindComposite.setInput(categories);
		selectTemplateComposite.setInput(categories);

		getShell().pack(true);
	}


	/**
	 * Gets the uml model template path.
	 *
	 * @return the template path
	 */
	public String getTemplatePath() {
		return selectTemplateComposite.getTemplatePath();
	}

	/**
	 * Gets the notation model template path.
	 *
	 * @return the notation template path
	 */
	public String getNotationTemplatePath() {
		return selectTemplateComposite.getNotationTemplatePath();
	}

	/**
	 * Gets the di model template path.
	 *
	 * @return the di template path
	 */
	public String getDiTemplatePath() {
		return selectTemplateComposite.getDiTemplatePath();
	}

	/**
	 * Gets the template plugin id.
	 *
	 * @return the template plugin id
	 */
	public String getTemplatePluginId() {
		return selectTemplateComposite.getTemplatePluginId();
	}

	/**
	 * Gets the diagram category.
	 *
	 * @return the diagram category
	 */
	private String[] getDiagramCategories() {
		return myCategoryProvider.getCurrentCategories();
	}


	/**
	 * Gets the diagram name.
	 *
	 * @return the new diagram name
	 */
	public List<String> getDiagramName() {
		return diagramKindComposite.getDiagramName();
	}

	public String getRootElementName() {
		return nameText.getText();
	}

	/**
	 * Templates enabled.
	 *
	 * @return true, if successful
	 */
	public boolean templatesEnabled() {
		return allowTemplates;
	}

	/**
	 * Gets the selected command descriptors.
	 *
	 * @param categoryId
	 *            the category id
	 * @return the selected command descriptors
	 */
	public List<ViewPrototype> getSelectedPrototypes(String categoryId) {
		ViewPrototype[] selected = getSelectedPrototypes();
		List<ViewPrototype> commands = new ArrayList<ViewPrototype>();
		for (int i = 0; i < selected.length; i++) {
			for (Category category : selected[i].getCategories()) {
				if (category.getName().equals(categoryId)) {
					commands.add(selected[i]);
					break;
				}
			}
		}
		return commands;
	}

	/**
	 * Creates the model template composite.
	 *
	 * @param composite
	 *            the composite
	 */
	private void createModelTemplateComposite(Composite composite) {
		Group group = createGroup(composite, Messages.SelectDiagramKindPage_load_template_group);
		selectTemplateComposite = new SelectModelTemplateComposite(group);
	}

	/**
	 * Creates the diagram kind form.
	 *
	 * @param composite
	 *            the composite
	 */
	private void createDiagramKindForm(Composite composite) {
		Group group = createGroup(composite, Messages.SelectDiagramKindPage_select_kind_group);
		diagramKindComposite = new DiagramKindComposite(group);
	}

	/**
	 * Creates the diagram kind label provider.
	 *
	 * @return the i base label provider
	 */
	protected IBaseLabelProvider createDiagramKindLabelProvider() {
		return new DiagramKindLabelProvider();
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
		GridLayout layout = new GridLayout(1, true);
		// layout.marginHeight = 5;
		// layout.marginWidth = 5;
		group.setLayout(layout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		group.setLayoutData(data);
		return group;
	}

	/**
	 * Creates the name form.
	 *
	 * @param composite
	 *            the composite
	 */
	private void createNameForm(Composite composite) {
		Group group = createGroup(composite, Messages.SelectDiagramKindPage_diagram_name_group);
		nameText = new Text(group, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		nameText.setText(Messages.SelectDiagramKindPage_default_diagram_name);

		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() > 0) {
			IStructuredSelection sSelection = (IStructuredSelection) selection;
			Object selectedObject = sSelection.getFirstElement();

			// Should not be otherwise, but just in case
			if (selectedObject instanceof IAdaptable) {
				IFile selectedIFile = ((IAdaptable) selectedObject).getAdapter(IFile.class);
				if (selectedIFile != null) {
					try {
						// Load the resource associated with the selected object
						ResourceSet resourceSet = new ResourceSetImpl();
						Resource resource = resourceSet.getResource(URI.createURI(selectedIFile.getLocationURI().toString()), true);
						if (resource.getContents().size() > 0) {
							modelRoot = resource.getContents().get(0);
							if (modelRoot instanceof NamedElement) {
								NamedElement element = (NamedElement) modelRoot;
								nameText.setText(element.getName());
							} else {
								modelRoot = null;
							}
						}
					} catch (Exception e) {
						this.setErrorMessage(Messages.SelectDiagramKindPage_Set_Root_Name_Error);
						Activator.log.error(e);
					}
				}
			}
		}

		nameText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				validatePage();
			}
		});
	}

	public static EObject getModelRoot() {
		return modelRoot;
	}

	/**
	 * Validate page.
	 *
	 * @return true, if successful
	 */
	private boolean validatePage() {
		IStatus profileStatus = profileChooserComposite.getProfileDefinitionStatus();
		if (!profileStatus.isOK()) {
			this.setErrorMessage(profileStatus.getMessage());
			return false;
		} else {
			// Resets the displayed message
			this.setErrorMessage(null);
			this.setMessage(Messages.SelectDiagramKindPage_page_desc);
		}
		return true;
	}

	/**
	 * Gets the selected diagram kinds.
	 *
	 * @param categoryId
	 *            the category id
	 * @return the selected diagram kinds
	 */
	public String[] getSelectedDiagramKinds(String categoryId) {
		return new String[0];
	}

	/**
	 * Gets the selected diagram kind descriptors.
	 *
	 * @return the selected diagram kind descriptors
	 */
	protected ViewPrototype[] getSelectedPrototypes() {
		List<ViewPrototype> checked = diagramKindComposite.getCheckElement();
		ViewPrototype[] result = checked.toArray(new ViewPrototype[checked.size()]);
		return result;
	}


	/**
	 * Gets the creation command registry.
	 *
	 * @return the creation command registry
	 */
	protected final ICreationCommandRegistry getCreationCommandRegistry() {
		return myCreationCommandRegistry;
	}

	/**
	 * The Interface CategoryProvider.
	 */
	public static interface CategoryProvider {

		/**
		 * Gets the current categories.
		 *
		 * @return the current categories
		 */
		String[] getCurrentCategories();
	}

	public List<ModelTemplateDescription> getTemplateTransfo() {
		return selectTemplateComposite.getTemplateTransfoPath();
	}

	@Override
	public void performHelp() {
		PlatformUI.getWorkbench().getHelpSystem().displayHelp("org.eclipse.papyrus.uml.diagram.wizards.Kind"); //$NON-NLS-1$

	}

}
