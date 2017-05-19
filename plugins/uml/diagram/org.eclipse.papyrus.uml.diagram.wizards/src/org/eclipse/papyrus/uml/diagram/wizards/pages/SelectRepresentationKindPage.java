/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo, Christian W. Damus, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *     Tatiana Fesenko(CEA) - improved look&feel
 *     Saadia Dhouib (CEA LIST) - Implementation of loading diagrams from template files  (.uml, .di , .notation)
 *     Christian W. Damus - bug 471453
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards.pages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
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
import org.eclipse.papyrus.infra.architecture.ArchitectureDomainManager;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureViewpoint;
import org.eclipse.papyrus.uml.diagram.wizards.Activator;
import org.eclipse.papyrus.uml.diagram.wizards.kind.DiagramKindLabelProvider;
import org.eclipse.papyrus.uml.diagram.wizards.kind.RepresentationKindComposite;
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
public class SelectRepresentationKindPage extends WizardPage {

	/** The Constant PAGE_ID. */
	public static final String PAGE_ID = "SelectDiagramKind"; //$NON-NLS-1$

	/** The diagram name text field. */
	private Text nameText;
	private boolean nameTextModified;

	/** The select template composite. */
	private SelectModelTemplateComposite selectTemplateComposite;

	/** the select diagram Kind composite */
	private RepresentationKindComposite representationKindComposite;

	private ProfileChooserComposite profileChooserComposite;

	/** The my context provider. */
	private final ContextProvider myContextProvider;

	/** The allow templates. */
	private final boolean allowTemplates;

	/** The my creation command registry. */
	private final ICreationCommandRegistry myCreationCommandRegistry;

	private NewModelWizardData wizardData;
	private IValueChangeListener<String> defaultModelNameListener;

	private static EObject modelRoot;

	/** The Constant DEFAULT_CREATION_COMMAND_REGISTRY. */
	public static final ICreationCommandRegistry DEFAULT_CREATION_COMMAND_REGISTRY = CreationCommandRegistry.getInstance(org.eclipse.papyrus.infra.ui.Activator.PLUGIN_ID);

	/**
	 * Instantiates a new select diagram kind page.
	 *
	 * @param viewpointProvider
	 *            the category provider
	 */
	public SelectRepresentationKindPage(ContextProvider contextProvider) {
		this(true, contextProvider, DEFAULT_CREATION_COMMAND_REGISTRY);
	}

	/**
	 * Instantiates a new select diagram kind page.
	 *
	 * @param allowTemplates
	 *            the allow templates
	 * @param viewpointProvider
	 *            the category provider
	 * @param creationCommandRegistry
	 *            the creation command registry
	 */
	public SelectRepresentationKindPage(boolean allowTemplates, ContextProvider contextProvider, ICreationCommandRegistry creationCommandRegistry) {
		super(PAGE_ID);
		setTitle(Messages.SelectRepresentationKindPage_page_title);
		setDescription(Messages.SelectRepresentationKindPage_page_desc);
		this.allowTemplates = allowTemplates;
		myContextProvider = contextProvider;
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

		Composite nameFormComposite = new Composite(pageComposite, SWT.NONE);
		nameFormComposite.setLayout(new GridLayout());
		nameFormComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		createNameForm(nameFormComposite);

		Composite representationKindComposite = new Composite(pageComposite, SWT.NONE);
		representationKindComposite.setLayout(new GridLayout());
		representationKindComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		createPresentationKindForm(representationKindComposite);

		Composite modelTemplateComposite = new Composite(pageComposite, SWT.NONE);
		modelTemplateComposite.setLayout(new GridLayout());
		modelTemplateComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		createModelTemplateComposite(modelTemplateComposite);

		fillInTables(getContexts(), getViewpoints());

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
		Group group = createGroup(parent, Messages.SelectRepresentationKindPage_0);
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
			fillInTables(getContexts(), getViewpoints());
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
	 * @param viewpoints
	 *            the viewpoints
	 */
	private void fillInTables(String[] contexts, String[] viewpoints) {
		if (viewpoints == null || contexts == null) {
			return;
		}
		representationKindComposite.setInput(viewpoints);
		selectTemplateComposite.setInput(contexts);

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
	 * Gets the contexts.
	 *
	 * @return the contexts
	 */
	private String[] getContexts() {
		return myContextProvider.getCurrentContexts();
	}

	/**
	 * Gets the viewpoints.
	 *
	 * @return the viewpoints
	 */
	private String[] getViewpoints() {
		return myContextProvider.getCurrentViewpoints();
	}


	/**
	 * Gets the diagram name.
	 *
	 * @return the new diagram name
	 */
	public List<String> getDiagramName() {
		return representationKindComposite.getDiagramName();
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
	 * Gets the selected representation kinds for a given viewpoint
	 *
	 * @param contextId
	 *            the architecture context id
	 * @return the selected repersentation kinds
	 */
	public List<RepresentationKind> getSelectedRepresentationKinds(String contextId) {
		MergedArchitectureContext context = ArchitectureDomainManager.getInstance().getArchitectureContextById(contextId);
		Set<RepresentationKind> allowedKinds = new HashSet<RepresentationKind>();
		for (MergedArchitectureViewpoint viewpoint : context.getViewpoints())
			allowedKinds.addAll(viewpoint.getRepresentationKinds());
		List<RepresentationKind> selectedKinds = new ArrayList<RepresentationKind>();
		for (RepresentationKind kind : getSelectedRepresentationKinds()) {
			if (allowedKinds.contains(kind))
				selectedKinds.add(kind);
		}
		return selectedKinds;
	}

	/**
	 * Creates the model template composite.
	 *
	 * @param composite
	 *            the composite
	 */
	private void createModelTemplateComposite(Composite composite) {
		Group group = createGroup(composite, Messages.SelectRepresentationKindPage_load_template_group);
		selectTemplateComposite = new SelectModelTemplateComposite(group);
	}

	/**
	 * Creates the diagram kind form.
	 *
	 * @param composite
	 *            the composite
	 */
	private void createPresentationKindForm(Composite composite) {
		Group group = createGroup(composite, Messages.SelectRepresentationKindPage_select_kind_group);
		representationKindComposite = new RepresentationKindComposite(group);
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
		Group group = createGroup(composite, Messages.SelectRepresentationKindPage_diagram_name_group);
		nameText = new Text(group, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		nameText.setText(getDefaultModelName().getValue());

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
						this.setErrorMessage(Messages.SelectRepresentationKindPage_Set_Root_Name_Error);
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
		if (!Objects.equals(nameText.getText(), getDefaultModelName().getValue())) {
			nameTextModified = true;
		}

		IStatus profileStatus = profileChooserComposite.getProfileDefinitionStatus();
		if (!profileStatus.isOK()) {
			this.setErrorMessage(profileStatus.getMessage());
			return false;
		} else {
			// Resets the displayed message
			this.setErrorMessage(null);
			this.setMessage(Messages.SelectRepresentationKindPage_page_desc);
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
	protected RepresentationKind[] getSelectedRepresentationKinds() {
		List<RepresentationKind> checked = representationKindComposite.getCheckElement();
		RepresentationKind[] result = checked.toArray(new RepresentationKind[checked.size()]);
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
	 * The Interface ContextProvider.
	 */
	public static interface ContextProvider {

		/**
		 * Gets the current contexts.
		 *
		 * @return the current contexts
		 */
		String[] getCurrentContexts();

		/**
		 * Gets the current viewpoints.
		 *
		 * @return the current viewpoints
		 */
		String[] getCurrentViewpoints();
	}

	public List<ModelTemplateDescription> getTemplateTransfo() {
		return selectTemplateComposite.getTemplateTransfoPath();
	}

	@Override
	public void performHelp() {
		PlatformUI.getWorkbench().getHelpSystem().displayHelp("org.eclipse.papyrus.uml.diagram.wizards.Kind"); //$NON-NLS-1$

	}

	public void setNewModelWizardData(NewModelWizardData wizardData) {
		if (this.wizardData == wizardData) {
			return;
		}

		if ((getDefaultModelName() != null) && (defaultModelNameListener != null)) {
			getDefaultModelName().removeValueChangeListener(defaultModelNameListener);
		}

		this.wizardData = wizardData;

		if (getDefaultModelName() != null) {
			getDefaultModelName().addValueChangeListener(getDefaultModelNameListener());
			updateDefaultModelName();
		}
	}

	protected IObservableValue<String> getDefaultModelName() {
		return (wizardData == null) ? null : wizardData.getDefaultModelName();
	}

	private IValueChangeListener<String> getDefaultModelNameListener() {
		if (defaultModelNameListener == null) {
			defaultModelNameListener = event -> updateDefaultModelName(event.diff.getNewValue());
		}

		return defaultModelNameListener;
	}

	protected void updateDefaultModelName(String newName) {
		if ((nameText != null) && !nameTextModified) {
			nameText.setText(newName);
			nameText.selectAll();
		}
	}

	private void updateDefaultModelName() {
		if (getDefaultModelName() != null) {
			updateDefaultModelName(getDefaultModelName().getValue());
		}
	}
}
