/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 * 		Géry Deloge (gery.deloge@cea.fr) CEATech AQUI - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.requirements.export;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.ui.command.AbstractCommandHandler;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.util.UMLUtil;

public class ExportRequirementCommandHandler extends AbstractCommandHandler {

	private final String FS = ",";
	private static Logger LOGGER = Logger.getLogger(ExportRequirementCommandHandler.class.getName());

	@Override
	protected Command getCommand(IEvaluationContext context) {

		List<EObject> selectedElements = getSelectedElements();
		if (selectedElements.size() == 1) {

			if (selectedElements.get(0) instanceof Package) {
				final Package myPackage = (Package) selectedElements.get(0);

				final String currentName = myPackage.getName();
				if (currentName != null) {
					TransactionalEditingDomain editingDomain = getEditingDomain(context);
					AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(editingDomain, "ExportCommand", //$NON-NLS-1$
							null, null) {

						/**
						 * @param monitor
						 * @param info
						 * @return
						 * @throws ExecutionException
						 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
						 *      org.eclipse.core.runtime.IAdaptable)
						 */
						@Override
						protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
								throws ExecutionException {
							FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
							dialog.setText("Save requirements as");
							dialog.setFileName(currentName + ".csv");
							dialog.setFilterPath(System.getProperty("user.home"));
							dialog.setOverwrite(true);
							String result = dialog.open();
							
							
							
							if (result != null) {
								try {
									saveRequirements(result);
								} catch (IOException e) {
									Activator.log.error("can't save to file " + result, e);
								}
							}
							return CommandResult.newOKCommandResult();
						}
						
						public boolean canUndo(){
							return false;
						}

					};
					return new GMFtoEMFCommandWrapper(cmd);
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	private Collection<Requirement> getRequirements(Package pkg) {
		Collection<Requirement> requirements = new ArrayList<Requirement>();

		for (NamedElement member : pkg.getMembers()) {
			Requirement requirement = UMLUtil.getStereotypeApplication(member, Requirement.class);

			if (requirement != null) {
				requirements.add(requirement);
			}
		}

		return requirements;
	}

	
	/*
	 * file format :
	 * package name , req ID , req name , req text
	 * package name is empty if the req parent is a requirement
	 * 
	 * encoding is current system encoding
	 */
	private void saveRequirements(String filename) throws IOException {

		List<EObject> selectedElements = getSelectedElements();
		if (selectedElements.size() == 1) {
			Package selectedPackage = (Package) selectedElements.get(0);
			List<String> msg = new ArrayList<>();
			addRequirements(selectedPackage, msg);

			Path path = Paths.get(filename);
			Files.write(path, msg, Charset.forName(System.getProperty("file.encoding", "UTF-8")));
		}
	}

	private void addRequirements(Package pkg, List<String> list) {
		for (Requirement req : getRequirements(pkg)) {

			list.add(getRow(req));

			EList<Classifier> classList = req.getBase_Class().getNestedClassifiers();
			for (Classifier classifier : classList) {

				Requirement requirement = UMLUtil.getStereotypeApplication(classifier, Requirement.class);
				if (requirement != null) {
					list.add(getRow(requirement));
				}
			}
		}

		// iterate over sub packages
		for (PackageableElement subPkg : pkg.getPackagedElements()) {
			if (subPkg instanceof Package) {
				addRequirements((Package) subPkg, list);
			}
		}
	}

	protected String formatCsvField(String field) {
		String ret = "";
		
		if(field != null){
			ret = field;
		}
		if (ret.contains("\"") || ret.contains(FS)) {
			String newField = field.replace("\"", "\"\"");
			if(ret.length() > 1 && newField.startsWith("\"") && newField.endsWith("\""))
				ret = newField;
			else 
				ret = "\"" + newField + "\"";
		}
		if (ret.contains("\r\n")) {
			ret = ret.replace("\r\n", " ");
		}
		if (ret.contains("\n")) {
			ret = ret.replace("\n", " ");
		}
		return ret;
	}

	private String getRow(Requirement req) {
		List<String> list = new ArrayList<>();

		Package ppackage = req.getBase_Class().getPackage();
		if (ppackage != null) {
			list.add(formatCsvField(ppackage.getQualifiedName()));
		} else {
			list.add("");
		}
		list.add(req.getId());
		list.add(formatCsvField(req.getBase_Class().getName()));
		list.add(formatCsvField(req.getText()));

		return list.stream().collect(Collectors.joining(FS));
	}
}
