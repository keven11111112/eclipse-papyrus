package org.eclipse.papyrus.adl4eclipsetool.assistant.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.adl4eclipse.org.ADL4Eclipse_Stereotypes;
import org.eclipse.papyrus.adltool.Activator;
import org.eclipse.papyrus.adltool.designer.ArchitectureRefactoring;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Package;

/**
 * Handler that refactors the ADL4Eclipse model, based on some rules
 */
public class ModelRefactoringHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		if (!selection.isEmpty() && selection instanceof IStructuredSelection) {
			final EObject rootModel = EMFHelper.getEObject(((IStructuredSelection) selection).getFirstElement());
			if (rootModel instanceof Package
					&& (((Package) rootModel).getAppliedProfile(ADL4Eclipse_Stereotypes.ADL4ECLIPSE) != null)) {
				Job refactoringJob = new Job("Refactoring Architecture Model") {

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						final Command command = ArchitectureRefactoring.getRefactoringCommand((Package) rootModel,
								monitor);
						if (command != null && command.canExecute()) {
							try {
								final TransactionalEditingDomain domain = ServiceUtilsForEObject.getInstance()
										.getTransactionalEditingDomain(rootModel);
								if (domain != null) {
									domain.getCommandStack().execute(command);
								}
							} catch (ServiceException e) {
								Activator.log.error(e);
								return new Status(IStatus.ERROR,
										org.eclipse.papyrus.adltool.assistant.Activator.PLUGIN_ID,
										e.getLocalizedMessage(), e);
							}
						}
						return Status.OK_STATUS;
					}
				};
				refactoringJob.schedule();
			}
		}
		return null;

	}
}
