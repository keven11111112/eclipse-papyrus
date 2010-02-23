package org.eclipse.papyrus.diagram.clazz.custom.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;

public class CustomReorientLinkCommand extends AbstractTransactionalCommand {

	private Request req;


	public CustomReorientLinkCommand(TransactionalEditingDomain domain, Request request) {
		super(domain, "CustomremoveCommand", null);
		req = request;

	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {


		EditPart target = (EditPart)((ReconnectRequest)req).getConnectionEditPart().getTarget();
		EditPart source = (EditPart)((ReconnectRequest)req).getTarget().getParent();
		PackageableElement sourceClassifier = (PackageableElement)((View)source.getModel()).getElement();
		PackageableElement targetClassifier = (PackageableElement)((View)target.getModel()).getElement();

		if(sourceClassifier instanceof org.eclipse.uml2.uml.Class) {
			org.eclipse.uml2.uml.Class sourceClass = (org.eclipse.uml2.uml.Class)sourceClassifier;
			org.eclipse.uml2.uml.Class targetClass = (org.eclipse.uml2.uml.Class)targetClassifier;
			org.eclipse.uml2.uml.Class oldsourceClass = (org.eclipse.uml2.uml.Class)targetClass.eContainer();

			EList<Classifier> listnestedclassifier = sourceClass.getNestedClassifiers();
			listnestedclassifier.add(targetClass);

		}
		if(sourceClassifier instanceof org.eclipse.uml2.uml.Package) {
			org.eclipse.uml2.uml.Package sourcePackage = (org.eclipse.uml2.uml.Package)sourceClassifier;
			org.eclipse.uml2.uml.Package targetPackage = (org.eclipse.uml2.uml.Package)targetClassifier;

			EList<Package> listnestedclassifier = sourcePackage.getNestedPackages();
			listnestedclassifier.add(targetPackage);

		}
		return CommandResult.newOKCommandResult();
	}

}
