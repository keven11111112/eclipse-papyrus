/*******************************************************************************
 * Copyright (c) 2012 CEA LIST
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Ansgar Radermacher - Initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.cpp.codegen.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.cpp.codegen.preferences.CppCodeGenUtils;
import org.eclipse.papyrus.cpp.codegen.transformation.ModelElementsCreator;
import org.eclipse.papyrus.infra.core.utils.BusinessModelResolver;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.PrimitiveType;


/**
 * <b><u>SyncURI Handler</u></b>
 * <p>
 * Install a filter that only shows events corresponding to a selected URI
 */
public class GenerateCodeHandler extends AbstractHandler {

	// ------------------------------------------------------------------------
	// Execution
	// ------------------------------------------------------------------------

	private EObject selectedEObj;

	@Override
	public boolean isEnabled() {
		// intercept isEnabled operation in order to get selected eObject.

		// Get current selection
		Object selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

		// Get first element if the selection is an IStructuredSelection
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			selection = structuredSelection.getFirstElement();
		}

		// Treat non-null selected object (try to adapt and return EObject)
		if(selection != null) {
			Object businessObject = BusinessModelResolver.getInstance().getBusinessModel(selection);
			if(businessObject instanceof EObject) {

				selectedEObj = (EObject)businessObject;
				if((selectedEObj instanceof PrimitiveType) || (selectedEObj instanceof Enumeration)) {
					return false;
				}
				if((selectedEObj instanceof Class) ||
					(selectedEObj instanceof Interface) ||
					(selectedEObj instanceof DataType) ||
					(selectedEObj instanceof Package)) {
					return true;
				}
			}
		}

		selectedEObj = null;
		return super.isEnabled();
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {

		if(selectedEObj instanceof PackageableElement) {
			final PackageableElement pe = (PackageableElement)selectedEObj;

			URI uri = pe.eResource().getURI();

			// URIConverter uriConverter = resource.getResourceSet().getURIConverter();
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			if(uri.segmentCount() < 2) {
				return null;
			}
			final IProject modelProject = root.getProject(uri.segment(1));

			if(modelProject.exists()) {

				Job job = new Job("Create deployment model (OO)") {

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						// execute the task ...
						String headerSuffix = CppCodeGenUtils.getHeaderSuffix();
						String bodySuffix = CppCodeGenUtils.getBodySuffix();
						ModelElementsCreator mec = new ModelElementsCreator(modelProject, headerSuffix, bodySuffix, CppCodeGenUtils.getCommentHeader());
						generateCode(mec, pe, headerSuffix, bodySuffix);
						monitor.done();
						return Status.OK_STATUS;
					}
				};
				job.setUser(true);
				job.schedule();

			}
		}
		return null;
	}

	public void generateCode(ModelElementsCreator mec, PackageableElement pe, String headerSuffix, String bodySuffix) {
		String name = pe.getName();
		IContainer srcPkg = mec.getContainer(pe);

		try {
			mec.createPackageableElement(srcPkg, new NullProgressMonitor(), pe);

			IFile cppFile = srcPkg.getFile(new Path(name + "." + bodySuffix));
			IFile hFile = srcPkg.getFile(new Path(name + "." + headerSuffix));
			if(!cppFile.exists()) {
				return;
			}
			if(cppFile != null) {
				cppFile.refreshLocal(0, null);
			}
			if(hFile != null) {
				hFile.refreshLocal(0, null);
			}
		} catch (CoreException coreException) {
			return;
		}
	}
}
