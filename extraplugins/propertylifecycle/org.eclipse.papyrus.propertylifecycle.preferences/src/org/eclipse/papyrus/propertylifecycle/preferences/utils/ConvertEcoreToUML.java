/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.propertylifecycle.preferences.utils;

// package org.eclipse.papyrus.rename.strategies.preferences.utils;
//
// import java.lang.reflect.InvocationTargetException;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
//
// import org.eclipse.core.resources.IFile;
// import org.eclipse.core.runtime.IProgressMonitor;
// import org.eclipse.emf.common.command.UnexecutableCommand;
// import org.eclipse.emf.common.util.BasicDiagnostic;
// import org.eclipse.emf.common.util.Diagnostic;
// import org.eclipse.emf.common.util.EList;
// import org.eclipse.emf.common.util.TreeIterator;
// import org.eclipse.emf.common.util.URI;
// import org.eclipse.emf.ecore.EObject;
// import org.eclipse.emf.ecore.EPackage;
// import org.eclipse.emf.ecore.InternalEObject;
// import org.eclipse.emf.ecore.plugin.EcorePlugin;
// import org.eclipse.emf.ecore.resource.Resource;
// import org.eclipse.emf.ecore.resource.ResourceSet;
// import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
// import org.eclipse.emf.ecore.xmi.XMIResource;
// import org.eclipse.jface.action.IAction;
// import org.eclipse.jface.dialogs.ProgressMonitorDialog;
// import org.eclipse.jface.operation.IRunnableWithProgress;
// import org.eclipse.jface.viewers.ISelection;
// import org.eclipse.jface.viewers.StructuredSelection;
// import org.eclipse.jface.window.Window;
// import org.eclipse.swt.widgets.Shell;
// import org.eclipse.ui.PlatformUI;
// import org.eclipse.uml2.common.util.UML2Util;
// import org.eclipse.uml2.examples.uml.ui.UMLExamplesUIPlugin;
// import org.eclipse.uml2.examples.uml.ui.dialogs.Ecore2UMLConverterOptionsDialog;
// import org.eclipse.uml2.uml.Element;
// import org.eclipse.uml2.uml.UMLPlugin;
// import org.eclipse.uml2.uml.editor.dialogs.OptionsDialog;
// import org.eclipse.uml2.uml.resource.UMLResource;
// import org.eclipse.uml2.uml.util.UMLUtil;
// import org.eclipse.uml2.uml.util.UMLValidator;
//
//
// /**
// * Need only import org.eclipse.uml2.examples.uml.ui and activate the action in the RenameStrategiesPreferencePage
// *
// */
// public class ConvertEcoreToUML extends org.eclipse.uml2.examples.uml.ui.actions.ConvertToUMLModelAction {
//
// @Override
// public void run(IAction action) {
//
// if (command != UnexecutableCommand.INSTANCE) {
// ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
//
// IFile iFile = (IFile) ((StructuredSelection) selection).getFirstElement();
// ResourceSet resourceSet = new ResourceSetImpl();
// Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(iFile.getFullPath().toString(), true));
//
// EObject content = null;
// try {
// resource.load(null);
// content = resource.getContents().get(0);
// } catch (Exception e) {
// // do something
// }
//
// if (!(content instanceof EPackage)) {
// return;
// }
//
// final EPackage ePackage = (EPackage) content;
//
// final Shell shell = PlatformUI.getWorkbench()
// .getActiveWorkbenchWindow().getShell();
//
// final Map<String, String> options = new HashMap<String, String>();
//
// final String label = UMLExamplesUIPlugin.INSTANCE.getString(
// "_UI_ConvertToUMLActionCommand_label", //$NON-NLS-1$
// new Object[] { getObjectLabel(ePackage) });
//
// OptionsDialog optionsDialog = new Ecore2UMLConverterOptionsDialog(
// shell, label, UMLExamplesUIPlugin.INSTANCE
// .getString("_UI_OptionsDialog_message"), //$NON-NLS-1$
// options);
//
// if (optionsDialog.open() == Window.OK) {
// IRunnableWithProgress runnableWithProgress = new IRunnableWithProgress() {
//
// @Override
// public void run(final IProgressMonitor progressMonitor)
// throws InvocationTargetException,
// InterruptedException {
//
// try {
// final BasicDiagnostic diagnostics = new BasicDiagnostic(
// UMLValidator.DIAGNOSTIC_SOURCE, 0,
// EcorePlugin.INSTANCE.getString(
// "_UI_DiagnosticRoot_diagnostic", //$NON-NLS-1$
// new Object[] { getObjectLabel(ePackage) }),
// new Object[] { ePackage });
//
// Map<Object, Object> context = new HashMap<Object, Object>();
// context.put(UML2Util.QualifiedTextProvider.class,
// qualifiedTextProvider);
//
// progressMonitor.beginTask(
// UMLExamplesUIPlugin.INSTANCE.getString(
// "_UI_ConvertingToUML_message", //$NON-NLS-1$
// new Object[] { getObjectLabel(ePackage) }),
// IProgressMonitor.UNKNOWN);
//
// Resource resource = ePackage.eResource();
// ResourceSet resourceSet = resource.getResourceSet();
// URI uri = resourceSet.getURIConverter().normalize(
// resource.getURI()).trimFileExtension()
// .trimSegments(1);
//
// List<Resource> resources = new ArrayList<Resource>();
//
// for (org.eclipse.uml2.uml.Package package_ : UMLUtil
// .convertFromEcore(ePackage, options,
// diagnostics, context)) {
//
// resources.add(resource = resourceSet
// .createResource(uri.appendSegment(
// package_.getName())
// .appendFileExtension(
// UMLResource.FILE_EXTENSION)));
//
// EList<EObject> contents = resource
// .getContents();
//
// contents.add(package_);
//
// for (TreeIterator<EObject> allContents = UML2Util
// .getAllContents(package_, true, false); allContents
// .hasNext();) {
//
// EObject eObject = allContents.next();
//
// if (eObject instanceof Element) {
// contents.addAll(((Element) eObject)
// .getStereotypeApplications());
// }
// }
//
// if (UMLUtil.OPTION__PROCESS
// .equals(options
// .get(UMLUtil.Ecore2UMLConverter.OPTION__XMI_IDENTIFIERS))
// && resource instanceof XMIResource) {
//
// XMIResource xmiResource = (XMIResource) resource;
//
// for (TreeIterator<EObject> allContents = xmiResource
// .getAllContents(); allContents
// .hasNext();) {
//
// EObject eObject = allContents.next();
// String xmiIdentifier = UML2Util
// .getXMIIdentifier((InternalEObject) eObject);
//
// if (diagnostics != null) {
// diagnostics
// .add(new BasicDiagnostic(
// Diagnostic.INFO,
// UMLValidator.DIAGNOSTIC_SOURCE,
// UMLUtil.Ecore2UMLConverter.XMI_IDENTIFIER,
// UMLPlugin.INSTANCE
// .getString(
// "_UI_Ecore2UMLConverter_ProcessXMIIdentifier_diagnostic", //$NON-NLS-1$
// UML2Util
// .getMessageSubstitutions(
// context,
// eObject,
// xmiIdentifier)),
// new Object[] { eObject }));
// }
//
// xmiResource.setID(eObject,
// xmiIdentifier);
// }
// }
// }
//
// for (Resource r : resources) {
//
// try {
// r.save(null);
// } catch (Exception e) {
// UMLExamplesUIPlugin.INSTANCE.log(e);
// }
// }
//
// handleDiagnostic(progressMonitor.isCanceled()
// ? Diagnostic.CANCEL_INSTANCE
// : diagnostics, label);
// } finally {
// progressMonitor.done();
// }
// }
// };
//
// if (eclipseResourcesUtil != null) {
// runnableWithProgress = eclipseResourcesUtil
// .getWorkspaceModifyOperation(runnableWithProgress);
// }
//
// try {
// new ProgressMonitorDialog(shell).run(false, true,
// runnableWithProgress);
// } catch (Exception e) {
// UMLExamplesUIPlugin.INSTANCE.log(e);
// }
// }
// }
// }
//
// public String getObjectLabel(EObject eObject) {
// Resource eResource = eObject.eResource();
//
// String text = "";
// if (eResource != null) {
// String lastSegment = eResource.getURI()
// .lastSegment();
//
// if (lastSegment != null) {
// text += " - " + lastSegment; //$NON-NLS-1$
// }
// }
//
// return text;
// }
//
// }
