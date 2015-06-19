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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.adl4eclipse.org.IADL4ECLIPSE_Stereotype;
import org.eclipse.papyrus.adltool.ADL4EclipseUtils;
import org.eclipse.papyrus.adltool.assistant.wizard.BundleSelectionPage;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.osgi.profile.IOSGIStereotype;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPart;
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
	 * Constructor.
	 *
	 * @param advanced true to launch the wizard in advanced mode.
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

		if (rootModel != null) {
			// Check if the required profiles are applied to the rootModel to initialize the modelSet
			Profile adlProfile = rootModel.getAppliedProfile(IADL4ECLIPSE_Stereotype.ADL4ECLIPSE);
			Profile osgiProfile = rootModel.getAppliedProfile(IOSGIStereotype.OSGI);

			if (adlProfile != null && osgiProfile != null) {
				try {
					// Initialize the modelSet and the TransactionalEditingDomain
					modelSet = ServiceUtilsForResource.getInstance().getModelSet(rootModel.eResource());
					transactionalEditingDomain = modelSet.getTransactionalEditingDomain();
					bundleSelectionPage.setSelectedModel(rootModel);
				} catch (ServiceException e) {
					e.printStackTrace();
				}
			} else {
				bundleSelectionPage.setErrorMessage("The selected model does not have the ADL and OSGI profiles applied.");
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
	public abstract boolean performFinish();
}
