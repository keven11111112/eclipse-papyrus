/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
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

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.AbstractGenerator;
import org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.ElementTypesGenerator;
import org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.Identifiers;
import org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.ui.internal.Activator;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.uml2.uml.Profile;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * A wizard for generation of a new tooling model model for a UML Profile.
 */
public class GeneratorWizard extends Wizard {

	private final IWorkbenchPage page;
	private final GeneratorWizardModel model;

	public GeneratorWizard(IWorkbenchPage page, Profile profile) {
		super();

		setDialogSettings(DialogSettings.getOrCreateSection(Activator.getInstance().getDialogSettings(), GeneratorWizard.class.getName()));

		this.page = page;
		this.model = new GeneratorWizardModel(this, profile, getDialogSettings());

		setWindowTitle("Generate Element Types Model");
		setHelpAvailable(false);
	}

	@Override
	public void addPages() {
		super.addPages();

		addPage(createMainPage(model));
	}

	protected IGeneratorWizardPage createMainPage(GeneratorWizardModel model) {
		return new GeneratorMainPage(model, "Element Types Configuration Model", "Enter details of the element types model to generate.", "elementtypesconfigurations");
	}

	private void save() {
		for (IGeneratorWizardPage next : Iterables.filter(Arrays.asList(getPages()), IGeneratorWizardPage.class)) {
			next.save();
		}
	}

	@Override
	public boolean performFinish() {
		boolean result = false;

		save();

		Identifiers identifiers = new Identifiers();
		identifiers.setPrefix(model.getIdentifier());
		identifiers.setDiagramElementTypesSet(model.getSelectedElementTypeSet());

		List<AbstractGenerator<Profile, ?>> generators = Lists.newArrayListWithExpectedSize(1);
		addGenerators(generators, identifiers, model);

		IStatus status = Status.OK_STATUS;

		for (AbstractGenerator<Profile, ?> next : generators) {
			status = next.generate(model.getProfile(), getOutputURI(next, identifiers, model));

			if (status.getSeverity() >= IStatus.ERROR) {
				break;
			}
		}

		if (status.getSeverity() < IStatus.ERROR) {
			result = true;

			try {
				IDE.openEditor(page, model.getOutputModelFile());
			} catch (PartInitException e) {
				status = e.getStatus();
			}
		}

		if (status.getSeverity() >= IStatus.WARNING) {
			StatusManager.getManager().handle(status, StatusManager.BLOCK | StatusManager.LOG);
		}

		return result;
	}

	protected void addGenerators(List<? super AbstractGenerator<Profile, ?>> generators, Identifiers identifiers, GeneratorWizardModel wizardModel) {
		generators.add(new ElementTypesGenerator(identifiers));
	}

	protected URI getOutputURI(AbstractGenerator<Profile, ?> generator, Identifiers identifiers, GeneratorWizardModel wizardModel) {
		return wizardModel.getOutputModelURI();
	}
}
