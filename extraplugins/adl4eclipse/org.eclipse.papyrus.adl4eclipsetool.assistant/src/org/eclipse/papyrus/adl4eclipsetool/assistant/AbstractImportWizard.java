/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thomas Daniellou (CEA LIST) - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.adl4eclipsetool.assistant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.adl4eclipse.org.ADL4Eclipse_Stereotypes;
import org.eclipse.papyrus.adltool.ADL4EclipseUtils;
import org.eclipse.papyrus.adltool.assistant.wizard.BundleSelectionPage;
import org.eclipse.papyrus.adltool.command.CompleteArchitectureSnapshotCommand;
import org.eclipse.papyrus.adltool.designer.ReverseSettings;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.osgi.profile.OSGIStereotypes;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * This abstract class specifies the default functionality of the import wizard
 * used to launch a reverse on a set of
 * {@link org.eclipse.papyrus.adltool.reversible.project.ReversibleProject
 * ReversibleProject}.
 *
 * <p>
 * <b>Note</b>: In order to extend this abstract class, the user needs to
 * initialize the {@link #reversibleList} field and implement the
 * {@link #performFinish()} method.
 * </p>
 */
public abstract class AbstractImportWizard extends Wizard implements IImportWizard {

	/**
	 * The list of reversible projects to be displayed in the
	 * {@link org.eclipse.papyrus.adltool.assistant.wizard.BundleSelectionPage
	 * BundleSelectionPage}.
	 */
	protected Set<ReversibleProject> reversibleList;

	/**
	 * Whether the import wizard is in "Advanced mode" or not.
	 */
	protected boolean advanced;

	/**
	 * The Wizard page that will help selecting bundles or features to import
	 * for the reverse engineering.
	 */
	protected BundleSelectionPage bundleSelectionPage;

	/**
	 * The object used to perform transactions on the models.
	 */
	protected TransactionalEditingDomain transactionalEditingDomain;

	/**
	 * The service used to access the Papyrus' models.
	 */
	protected ModelSet modelSet;

	/**
	 * The command used to launch the reverse.
	 */
	protected RecordingCommand command;

	/**
	 * Constructor.
	 *
	 * @param advanced
	 *            true to launch the wizard in advanced mode.
	 */
	public AbstractImportWizard(boolean advanced) {
		super();
		setNeedsProgressMonitor(true);

		this.advanced = advanced;
	}

	@Override
	public void addPages() {
		addPage(bundleSelectionPage);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		reversibleList = getReversibleList();
		bundleSelectionPage = new BundleSelectionPage(reversibleList, advanced);

		Package rootModel = null;
		Object selectedModel = selection.getFirstElement();

		if (selectedModel instanceof ModelEditPart) {
			// Get the root model from the diagram view
			EObject element = ((ModelEditPart) selectedModel).getDiagramView().getElement();

			if (element instanceof Model) {
				rootModel = (Model) element;
			}
		} else {
			// Get the root model from the selection
			List<Element> selectionSet = getSelectionSet();

			if (!selectionSet.isEmpty()) {
				Element selectedElement = selectionSet.get(0);

				rootModel = ADL4EclipseUtils.getRootModel(selectedElement);
			} else {
				bundleSelectionPage.setErrorMessage("You must select a Papyrus Model before running the import.");
			}
		}

		if (rootModel != null && !rootModel.isModelLibrary()) {
			// Check if the required profiles are applied to the rootModel to
			// initialize the modelSet
			Profile adlProfile = rootModel.getAppliedProfile(ADL4Eclipse_Stereotypes.ADL4ECLIPSE);
			Profile osgiProfile = rootModel.getAppliedProfile(OSGIStereotypes.OSGI);

			if (adlProfile == null && osgiProfile == null) {
				bundleSelectionPage
						.setMessage("Info: The selected model does not have the ADL and OSGI profiles applied.");
			}

			try {
				// Initialize the modelSet and the TransactionalEditingDomain
				modelSet = ServiceUtilsForResource.getInstance().getModelSet(rootModel.eResource());
				transactionalEditingDomain = modelSet.getTransactionalEditingDomain();
				bundleSelectionPage.setSelectedModel(rootModel);
			} catch (ServiceException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Gets the selected element in the diagram or in the model explorer.
	 *
	 * @return Element or null
	 */
	protected List<Element> getSelectionSet() {
		List<Element> selectedSet = new ArrayList<>();
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		ISelection selection = selectionService.getSelection();

		if (selection instanceof IStructuredSelection) {
			Iterator<?> selectedobjectIteractor = ((IStructuredSelection) selection).iterator();

			while (selectedobjectIteractor.hasNext()) {
				Object currentSelection = selectedobjectIteractor.next();
				EObject selectedEObject = EMFHelper.getEObject(currentSelection);

				if (selectedEObject instanceof Element) {
					selectedSet.add((Element) selectedEObject);
				}
			}
		}

		return selectedSet;
	}

	@Override
	public boolean canFinish() {
		return bundleSelectionPage.isPageComplete();
	}

	/**
	 * Gets the selected reversible project from the
	 * {@link org.eclipse.papyrus.adltool.assistant.wizard.BundleSelectionPage
	 * BundleSelectionPage} and launches the architecture snapshot command that
	 * will reverse the projects.
	 *
	 * @return true if the command has launched, false if not
	 */
	@Override
	public boolean performFinish() {
		final Set<ReversibleProject> selectedBundles = bundleSelectionPage.getResult();

		// One bundle must be selected
		if (selectedBundles.size() > 0) {
			final Package selection = bundleSelectionPage.getSelectedModel();

			if (selection != null) {
				final ReverseSettings reverseSettings = bundleSelectionPage.getReverseSettings();
				Job importJob = new Job("Import") {

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						// Launch the advanced reverse engineering
						command = new CompleteArchitectureSnapshotCommand(transactionalEditingDomain, selection,
								selectedBundles, reverseSettings);
						monitor.worked(1);
						transactionalEditingDomain.getCommandStack().execute(command);
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								MessageDialog.openInformation(getShell(), "Import finished", "Import is finished on "+ selectedBundles.size() +" bundles.");
							}
						});
						return Status.OK_STATUS;
					}
				};
				importJob.schedule();

				return true;
			}
		}

		return false;
	}

	protected abstract Set<ReversibleProject> getReversibleList();
}
