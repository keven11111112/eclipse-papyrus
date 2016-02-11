/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Patrick Tessier (patrick.tessier@cea.fr) CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.requirements.sysml.traceability.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.ui.util.EditorUtils;
import org.eclipse.papyrus.infra.ui.util.ServiceUtilsForHandlers;
import org.eclipse.papyrus.requirements.sysml.traceability.assistant.analysis.TracabilityAnalyzer;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * this class launch the application of the SysML profile
 */

public class ApplyTracabilityHandler extends AbstractHandler { 

	protected TransactionalEditingDomain transactionalEditingDomain=null;
	protected org.eclipse.uml2.uml.Package selectedElement=null;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		ISelection selection = selectionService.getSelection();
		try {
			transactionalEditingDomain =ServiceUtilsForHandlers.getInstance().getService(TransactionalEditingDomain.class, event);
		} catch (Exception e) {
			System.err.println("impossible to get the Transactional Editing Domain "+e);
		}



		if(selection instanceof IStructuredSelection) {
			Object selectedobject = ((IStructuredSelection)selection).getFirstElement();
			EObject selectedEObject = (EObject)EMFHelper.getEObject(selectedobject);
			if (selectedEObject instanceof Model){
				selectedElement=(Package)selectedEObject;
			}


			if(selectedElement!=null){

				@SuppressWarnings("deprecation")
				TransactionalEditingDomain editingDomain = EditorUtils.getTransactionalEditingDomain();
				if (editingDomain != null && selectedElement!=null) {
					Command command = new RecordingCommand(editingDomain) {

						@Override
						protected void doExecute() {
							changeStructure(selectedElement);

						}
					};
					editingDomain.getCommandStack().execute(command);
					TracabilityAnalyzer analyzer= new TracabilityAnalyzer();
					analyzer.runAnalysis(getToPackage(selectedElement), editingDomain);
				}

			}
		}
		return null;
	}

	private Package getToPackage(Element elem){
		Package tmp= elem.getNearestPackage();
		while(tmp.getOwner()!=null && (tmp.getOwner()instanceof Package)){
			tmp= (Package)tmp.getOwner();
		}
		return tmp;
	}
	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return true if the handler is possible
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

	protected void changeStructure(Package currentPackage) {
		Package topPackage= getToPackage(currentPackage);
		//apply SysML profile
		RegisteredProfile SysMLregisteredProfile=(RegisteredProfile)RegisteredProfile.getRegisteredProfile("SysML");
		URI SysMLmodelUri = SysMLregisteredProfile.uri;
		@SuppressWarnings("deprecation")
		final Resource SysMLResource = Util.getResourceSet(topPackage).getResource(SysMLmodelUri, true);
		Profile sysMLprofile=(Profile) SysMLResource.getContents().get(0);
		topPackage.applyProfile(sysMLprofile);

		URI standardL2URI = URI.createURI("pathmap://UML_PROFILES/StandardL2.profile.uml");
		@SuppressWarnings("deprecation")
		final Resource standardL2Resource = Util.getResourceSet(topPackage).getResource(standardL2URI, true);
		Profile  standardL2Profile=(Profile) standardL2Resource.getContents().get(0);
		topPackage.applyProfile(standardL2Profile);
	}

}