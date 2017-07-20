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

package org.eclipse.papyrus.uml.profile.types.generator.ui.internal.wizards;

import static com.google.common.base.Strings.isNullOrEmpty;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.infra.emf.utils.ResourceUtils;
import org.eclipse.uml2.uml.Profile;

/**
 * @author damus
 *
 */
public class GeneratorWizardModel {

	private final IWizard owner;

	private final Profile profile;

	private final IDialogSettings settings;

	private String identifier;

	private String selectedElementTypeSet;

	private IPath containerPath;

	private String fileName;

	private boolean suppressSemanticSuperElementTypes;

	public GeneratorWizardModel(IWizard owner, Profile profile, IDialogSettings settings) {
		super();

		this.owner = owner;
		this.profile = profile;
		this.settings = settings;
	}

	public Profile getProfile() {
		return profile;
	}

	public IDialogSettings getDialogSettings() {
		return settings;
	}

	private WizardPage currentPage() {
		WizardPage result = (WizardPage) owner.getContainer().getCurrentPage();

		if (result == null) {
			result = (WizardPage) owner.getStartingPage();
		}

		return result;
	}

	public void setErrorMessage(String message) {
		currentPage().setErrorMessage(message);
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getSelectedElementTypeSet() {
		return selectedElementTypeSet;
	}

	public void setSelectedElementTypeSet(String selectedElementTypeSet) {
		this.selectedElementTypeSet = selectedElementTypeSet;
	}

	public void setContainerPath(IPath containerPath) {
		this.containerPath = containerPath;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setSuppressSemanticSuperElementTypes(boolean suppressSemanticSuperElementTypes) {
		this.suppressSemanticSuperElementTypes = suppressSemanticSuperElementTypes;
	}

	public boolean isSuppressSemanticSuperElementTypes() {
		return suppressSemanticSuperElementTypes;
	}

	public URI getOutputModelURI() {
		return URI.createPlatformResourceURI(containerPath.append(fileName).toString(), true);
	}

	public IFile getOutputModelFile() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(containerPath.append(fileName));
	}

	public void validatePage() {
		WizardPage current = currentPage();
		if (current instanceof IGeneratorWizardPage) {
			current.setPageComplete(((IGeneratorWizardPage) current).validatePage());
		}
	}

	public boolean validate() {
		boolean result = true;

		setErrorMessage(null);
		if (isNullOrEmpty(getIdentifier())) {
			setErrorMessage("An identifier is required.");//$NON-NLS-1$
			result = false;
		} else if (getSelectedElementTypeSet() == null) {
			setErrorMessage("A base element type set must be selected.");//$NON-NLS-1$
			result = false;
		}

		return result;
	}

	IStructuredSelection getDefaultContainerSelection() {
		IFile file = ResourceUtils.getFile(getProfile().eResource());
		return (file == null) ? StructuredSelection.EMPTY : new StructuredSelection(file.getParent());
	}

	String getDefaultFileName() {
		return trimExtensions(EcoreUtil.getURI(profile).trimFragment()).lastSegment();
	}

	static URI trimExtensions(URI uri) {
		URI result = uri.trimFileExtension();

		while (!result.equals(uri)) {
			uri = result;
			result = result.trimFileExtension();
		}

		return result;
	}
}
