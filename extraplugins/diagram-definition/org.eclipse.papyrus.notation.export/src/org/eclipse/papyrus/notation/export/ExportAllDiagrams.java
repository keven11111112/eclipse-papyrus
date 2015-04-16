/**
 * Copyright (c) 2014 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.notation.export;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.statushandlers.StatusManager;

public class ExportAllDiagrams {

	private IFile file;

	/**
	 * Constructor
	 * 
	 * @param file
	 *            the *.*di file where the diagrams are stored, can be null if
	 *            you use export method with diagrams in parameter
	 */
	public ExportAllDiagrams(IFile file) {
		this.file = file;
	}

	/**
	 * Run the export of all diagrams of a *.di file
	 */
	public void export() {
		final IRunnableWithProgress op = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
				if (monitor == null)
					monitor = new NullProgressMonitor();
				export(monitor);
			}

		};
		Job job = new Job(Messages.ExportAllDiagrams_0) {
			@Override
			public IStatus run(IProgressMonitor monitor) {
				try {
					op.run(monitor);
				} catch (InvocationTargetException e) {
					Activator.getDefault().log(e);
				} catch (InterruptedException e) {
					Activator.getDefault().log(e);
				}
				return Status.OK_STATUS;
			}
		};
		job.setUser(true);
		job.schedule();

	}

	private void export(IProgressMonitor newMonitor) {
		newMonitor.beginTask(Messages.ExportAllDiagrams_1, 10);
		if (file != null) {
			ModelSet modelSet = null;
			try {
				ServicesRegistry registry = new ExtensionServicesRegistry(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);
				registry.startServicesByClassKeys(ModelSet.class);
				modelSet = (ModelSet) registry.getService(ModelSet.class);
				modelSet.loadModels(URI.createPlatformResourceURI(file.getFullPath().toString(), true));
				registry.startRegistry();
			} catch (Exception e) {
				/*ignore exceptions since some services may not have been started */
			}
			TransactionalEditingDomain domain = modelSet.getTransactionalEditingDomain();
			List<Diagram> diagrams = new ArrayList<Diagram>();
			if (newMonitor.isCanceled()) {
				return;
			}
			for (Iterator<Notifier> i = modelSet.getAllContents(); i.hasNext();) {
				Notifier n = i.next();
				if (n instanceof Diagram) {
					diagrams.add((Diagram) n);
				}
			}
			if (newMonitor.isCanceled()) {
				return;
			}
			newMonitor.worked(2);
			export(new SubProgressMonitor(newMonitor, 8), diagrams);
			unload(modelSet);
			domain.dispose();
		}
		newMonitor.done();
	}
	
	private void unload(ResourceSet resourceSet) {
		for (Resource next : resourceSet.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}
		resourceSet.getResources().clear();
		resourceSet.eAdapters().clear();
	}

	private void export(IProgressMonitor newMonitor, List<Diagram> diagrams) {
		newMonitor.beginTask(Messages.ExportAllDiagrams_4, 10);

		final IStatus status = exportDiagrams(new SubProgressMonitor(newMonitor, 9), diagrams);
		if (status != Status.OK_STATUS) {
			Activator.getDefault().getLog().log(status);
			StatusManager.getManager().handle(status, StatusManager.BLOCK);
		} else {
			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					MessageDialog.openInformation(Activator.getActiveWorkbenchShell(), Messages.ExportAllDiagrams_5, Messages.ExportAllDiagrams_5);
				}
			});
		}

	}

	/**
	 * Browse all the diagrams and export them
	 * 
	 * @param newMonitor
	 * @param findAllDiagrams
	 * @return
	 */
	private IStatus exportDiagrams(final IProgressMonitor newMonitor, List<Diagram> diagrams) {
		final ModelExtent input = new BasicModelExtent(diagrams);
		final ModelExtent output = new BasicModelExtent();

		final ExecutionContextImpl context = new ExecutionContextImpl();
		context.setConfigProperty("keepModeling", true);

		URI transformationURI = URI.createURI("platform:/plugin/org.eclipse.papyrus.notation2umldi/transforms/NotationToUmlDi.qvto");
		final TransformationExecutor executor = new TransformationExecutor(transformationURI);

		final ExecutionDiagnostic result[] = new ExecutionDiagnostic[1];
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				result[0] = executor.execute(context, input, output);
			}
		});

		if (result[0] != null && result[0].getSeverity() != Diagnostic.OK)
			return BasicDiagnostic.toIStatus(result[0]);

		try {
			List<EObject> outObjects = output.getContents();
			ResourceSet outResourceSet = new ResourceSetImpl();
			Resource outResource = outResourceSet
					.createResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true)
							.trimFileExtension()
							.appendFileExtension("umldi"));
			outResource.getContents().addAll(outObjects);
			outResource.save(Collections.emptyMap());
			return Status.OK_STATUS;
		} catch (IOException e) {
			return new Status(Status.ERROR, Activator.PLUGIN_ID, e.getMessage());
		}
	}

}
