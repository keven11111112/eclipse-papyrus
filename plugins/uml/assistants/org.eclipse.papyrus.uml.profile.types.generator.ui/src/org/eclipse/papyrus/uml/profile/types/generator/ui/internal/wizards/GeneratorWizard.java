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

package org.eclipse.papyrus.uml.profile.types.generator.ui.internal.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.ui.util.UIUtil;
import org.eclipse.papyrus.uml.profile.types.generator.AbstractGenerator;
import org.eclipse.papyrus.uml.profile.types.generator.ElementTypesGenerator;
import org.eclipse.papyrus.uml.profile.types.generator.Identifiers;
import org.eclipse.papyrus.uml.profile.types.generator.ui.internal.Activator;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.uml2.uml.Profile;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;

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
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		super.addPages();

		addPage(createMainPage(model));
	}

	protected IGeneratorWizardPage createMainPage(GeneratorWizardModel model) {
		return new GeneratorMainPage(model, "Element Types Configuration Model", "Enter details of the element types model to generate.", "typesconfigurations");
	}

	private void save() {
		for (IGeneratorWizardPage next : Iterables.filter(Arrays.asList(getPages()), IGeneratorWizardPage.class)) {
			next.save();
		}
	}

	@Override
	public boolean performFinish() {
		save();

		final IStatus[] status = { Status.CANCEL_STATUS };

		try {
			getContainer().run(true, false, new IRunnableWithProgress() {

				@Override
				public void run(IProgressMonitor monitor) {
					status[0] = doPerformFinish(monitor);
				}
			});
		} catch (InterruptedException e) {
			status[0] = Status.CANCEL_STATUS;
		} catch (InvocationTargetException e) {
			status[0] = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Model generation failed with an exception.", e.getTargetException());
		}

		if (status[0].matches(IStatus.WARNING | IStatus.ERROR)) {
			StatusManager.getManager().handle(status[0], StatusManager.BLOCK | StatusManager.LOG);
		}

		return status[0].getSeverity() < IStatus.ERROR;
	}

	protected IStatus doPerformFinish(IProgressMonitor monitor) {
		IStatus result = Status.OK_STATUS;

		Identifiers identifiers = new Identifiers();
		identifiers.setPrefix(model.getIdentifier());
		identifiers.setBaseElementTypesSet(model.getSelectedElementTypeSet());
		identifiers.setSuppressSemanticSuperElementTypes(model.isSuppressSemanticSuperElementTypes());

		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		identifiers.setAdapterFactory(adapterFactory);

		try {
			List<AbstractGenerator<Profile, ?>> generators = Lists.newArrayListWithExpectedSize(1);
			addGenerators(generators, identifiers, model);

			monitor.beginTask(NLS.bind("Generating {0}", generators.size() > 1 ? "models" : "model"), generators.size() + 1);

			for (AbstractGenerator<Profile, ?> next : generators) {
				monitor.subTask(next.getLabel());

				result = next.generate(model.getProfile(), getOutputURI(next, identifiers, model));

				if (result.getSeverity() >= IStatus.ERROR) {
					break;
				}

				monitor.worked(1);
			}

			if (result.getSeverity() < IStatus.ERROR) {
				monitor.subTask("Opening editor");
				try {
					Futures.getChecked(UIUtil.syncCall(getShell().getDisplay(), new Callable<Void>() {
						@Override
						public Void call() throws Exception {
							IDE.openEditor(page, model.getOutputModelFile());
							return null;
						}
					}), PartInitException.class);
				} catch (PartInitException e) {
					result = e.getStatus();
				}
			}
		} finally {
			adapterFactory.dispose();
			monitor.done();
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
