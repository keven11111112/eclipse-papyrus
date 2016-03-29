/*****************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 468079
 *  Christian W. Damus - bug 471836
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.developper.mde.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.ui.util.ServiceUtilsForHandlers;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * Abstract handler in order to connect to papyrus
 *
 */
public abstract class IDMAbstractHandler extends AbstractHandler {

	protected TransactionalEditingDomain transactionalEditingDomain = null;
	protected PapyrusMultiDiagramEditor papyrusEditor;
	private static Map<Element, Element> elt2DocElt = new HashMap<Element, Element>();
	private static Map<String, String> href2DocHREF = new HashMap<String, String>();
	private static Map<Package, Package> Toc2DocElt = new HashMap<Package, Package>();

	/**
	 * get the root package
	 *
	 * @param elem
	 * @return the root package
	 */
	public Package getToPackage(Element elem) {
		Package tmp = elem.getNearestPackage();
		while (tmp.getOwner() != null && (tmp.getOwner() instanceof Package)) {
			tmp = (Package) tmp.getOwner();
		}
		return tmp;
	}

	// @Override
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			papyrusEditor = (PapyrusMultiDiagramEditor) ServiceUtilsForHandlers.getInstance().getService(IMultiDiagramEditor.class, event);
			transactionalEditingDomain = ServiceUtilsForHandlers.getInstance().getService(org.eclipse.emf.transaction.TransactionalEditingDomain.class, event);
		} catch (Exception e) {
			System.err.println("impossible to get the Transactional Editing Domain " + e); //$NON-NLS-1$
		}
		IProject project = getCurrentProject();
		IFolder docFolder = project.getFolder("doc");
		if (!docFolder.exists()) {
			try {
				docFolder.create(IResource.NONE, true, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		IFolder imgDoc = docFolder.getFolder("imgDOC");
		if (!imgDoc.exists()) {
			try {
				imgDoc.create(IResource.NONE, true, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * getSelected element in the diagram or in hte model explorer
	 *
	 * @return Element or null
	 */
	protected Element getSelection() {
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		ISelection selection = selectionService.getSelection();

		if (selection instanceof IStructuredSelection) {
			Object selectedobject = ((IStructuredSelection) selection).getFirstElement();

			EObject selectedElement = EMFHelper.getEObject(selectedobject);
			if (selectedElement instanceof Element) {
				return (Element) selectedElement;
			}
		}
		return null;
	}

	/**
	 * getSelected element in the diagram or in hte model explorer
	 *
	 * @return Element or null
	 */
	protected ArrayList<Element> getSelectionSet() {
		ArrayList<Element> selectedSet = new ArrayList<Element>();
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		ISelection selection = selectionService.getSelection();

		// look for papyrus

		if (selection instanceof IStructuredSelection) {
			@SuppressWarnings("rawtypes")
			Iterator selectedobjectIteractor = ((IStructuredSelection) selection).iterator();
			while (selectedobjectIteractor.hasNext()) {
				Object currentSelection = selectedobjectIteractor.next();
				EObject selectedElement = EMFHelper.getEObject(currentSelection);
				if (selectedElement instanceof Element) {
					selectedSet.add((Element) selectedElement);
				}
			}


		}
		return selectedSet;
	}

	protected IProject getCurrentProject() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IPath path = new Path(getSelection().eResource().getURI().toPlatformString(true));
		return root.getProject(path.segment(0));
	}

	public static void clear() {
		elt2DocElt.clear();
		href2DocHREF.clear();
		Toc2DocElt.clear();
	}

	public static Element getDocElement(Element modelElement) {
		return elt2DocElt.get(modelElement);
	}

	public static String getDocHREF(String href) {
		return href2DocHREF.get(href);
	}

	public static void putDocElement(Element modelElement, Element docElement) {
		elt2DocElt.put(modelElement, docElement);
		href2DocHREF.put(modelElement.eResource().getURIFragment(modelElement), docElement.eResource().getURIFragment(docElement));
	}

	public static Package getDocPackageForTOC(Package tocPackage) {
		return Toc2DocElt.get(tocPackage);
	}

	public static void putTOCPackage(Package tocPackage, Package docPackage) {
		Toc2DocElt.put(tocPackage, docPackage);
	}
}
