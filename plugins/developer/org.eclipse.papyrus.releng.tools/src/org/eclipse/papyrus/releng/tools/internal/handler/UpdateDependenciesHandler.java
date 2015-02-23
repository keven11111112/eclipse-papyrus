/*******************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 366567 - [Releng] Tool to update rmaps
 *     Camille Letavernier (CEA LIST) - camille.letavernier@cea.fr - Generalize to handle POMs
 *     Christian W. Damus (CEA) - Add support for updating Oomph setup models
 *     Christian W. Damus - Support updating of multiple selected files
 *     
 *******************************************************************************/
package org.eclipse.papyrus.releng.tools.internal.handler;

import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import org.eclipse.b3.aggregator.Aggregation;
import org.eclipse.b3.aggregator.AggregatorPackage;
import org.eclipse.b3.aggregator.transformer.TransformationManager;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.releng.tools.internal.Activator;
import org.eclipse.papyrus.releng.tools.internal.Messages;
import org.eclipse.papyrus.releng.tools.internal.popup.actions.DependencyUpdater;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.framework.Bundle;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;


public class UpdateDependenciesHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		Shell activeShell = HandlerUtil.getActiveShell(event);
		List<IFile> updated = Lists.newArrayListWithExpectedSize(4);
		IFile aggregationBuildFile = null;
		boolean cancelled = false;

		try {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				List<IFile> files = ImmutableList.copyOf(Iterables.filter(structuredSelection.toList(), IFile.class));
				if (!files.isEmpty()) {
					List<IFile> aggregationBuildFiles = findAggregationBuildFiles();
					aggregationBuildFile = chooseAggregationBuildFile(aggregationBuildFiles, activeShell);
					if (aggregationBuildFile == null) {
						cancelled = true;
					} else {
						Aggregation aggregation = loadAggregationModel(aggregationBuildFile);
						if (aggregation != null) {
							Map<Object, Object> context = Maps.newHashMap();
							for (IFile file : files) {
								if (updateFile(file, aggregation, activeShell, context)) {
									updated.add(file);
								}
							}
						}
					}
				}
			}
		} catch (OperationCanceledException e) {
			cancelled = true;
		} catch (Exception e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error", e)); //$NON-NLS-1$
			MessageDialog.openError(activeShell, Messages.UpdateRMapAction_error, e.getLocalizedMessage());
		}

		if (updated.isEmpty()) {
			// Don't waste the user's attention on this if he cancelled
			if (!cancelled) {
				MessageDialog.openInformation(activeShell, "No Files Updated", "No files were updated for new dependencies.");
			}
		} else {
			String fileList = Joiner.on(", ").join(Iterables.transform(updated, new Function<IFile, IPath>() {
				@Override
				public IPath apply(IFile input) {
					return input.getFullPath();
				}
			}));
			MessageDialog.openInformation(activeShell, Messages.UpdateRMapAction_mapWasUpdatedTitle, NLS.bind(Messages.UpdateRMapAction_mapWasUpdated, fileList, aggregationBuildFile.getFullPath().toString()));
		}

		return null;
	}

	protected static List<IFile> findAggregationBuildFiles() throws CoreException {
		List<IFile> aggregationBuildFiles = new ArrayList<IFile>();
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject project : projects) {
			if (!project.isOpen()) {
				continue;
			}
			IResource[] members = project.members();
			for (IResource resource : members) {
				if (resource.getType() == IResource.FILE && resource.getName().endsWith(".b3aggr")) { //$NON-NLS-1$
					aggregationBuildFiles.add((IFile) resource);
				}
			}
		}
		return aggregationBuildFiles;
	}

	protected static IFile chooseAggregationBuildFile(final List<IFile> aggregationBuildFiles, Shell activeShell) {
		if (aggregationBuildFiles.size() == 0) {
			MessageDialog.openWarning(activeShell, Messages.UpdateRMapAction_noBuildModelFound, Messages.UpdateRMapAction_noBuildModelFoundLong);
			return null;
		}
		LabelProvider labelProvider = new LabelProvider() {

			@Override
			public String getText(final Object element) {
				if (element instanceof IFile) {
					IFile file = (IFile) element;
					return file.getProject().getName() + "/" + file.getName(); //$NON-NLS-1$
				}
				return super.getText(element);
			}
		};

		ElementListSelectionDialog dialog = new ElementListSelectionDialog(activeShell, labelProvider);
		dialog.setTitle(Messages.UpdateRMapAction_chooseBuildModel);
		dialog.setMessage(Messages.UpdateRMapAction_chooseBuildModelLong);
		dialog.setElements(aggregationBuildFiles.toArray());
		dialog.open();
		return (IFile) dialog.getFirstResult();
	}

	protected static Aggregation loadAggregationModel(IFile aggregationBuildFile) throws CoreException {
		Aggregation result = null;

		// make sure the EPackage is initialized
		AggregatorPackage.eINSTANCE.getEFactoryInstance();
		URI uri = URI.createPlatformResourceURI(aggregationBuildFile.getFullPath().toString(), true);

		final ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = null;
		try {
			// with the latest version of the metamodel
			resource = resourceSet.getResource(uri, true);
			resource.load(null);
		} catch (Exception e) {
			// with an older version of the metamodel
			try {
				TransformationManager transformationManager = new TransformationManager(uri);
				resource = transformationManager.transformResource(true);
			} catch (Exception e1) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error loading b3aggr. Make sure you have the latest version of B3 installed. : " + e.getLocalizedMessage(), e1)); //$NON-NLS-1$
			}
		}

		if (resource.getContents().size() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The b3aggr resource is empty")); //$NON-NLS-1$
		}

		EObject root = resource.getContents().get(0);
		if (root instanceof Aggregation) {
			result = (Aggregation) root;
		} else {
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The b3aggr resource does not contain an aggregation model")); //$NON-NLS-1$
		}

		return result;
	}

	protected boolean updateFile(IFile selectedFile, Aggregation aggregationModel, Shell activeShell, Map<Object, Object> context) throws CoreException {
		boolean result = false;

		DependencyUpdater updater = findDependencyUpdater(selectedFile);
		if (updater != null) {
			updater.updateDocument(activeShell, selectedFile, aggregationModel.getAllContributions(true), context);
			result = true;
		}

		return result;
	}

	protected DependencyUpdater findDependencyUpdater(IFile mapFile) throws CoreException {
		final String path = "org/eclipse/papyrus/releng/tools/internal/popup/actions/"; //$NON-NLS-1$
		DependencyUpdater result = null;
		Bundle bundle = Activator.getDefault().getBundle();

		// Try dev mode, first
		Enumeration<URL> urls = bundle.findEntries("bin/" + path, "*.class", false);
		if (urls == null) {
			// Deployed mode
			urls = bundle.findEntries(path, "*.class", false);
		}

		while (urls.hasMoreElements()) {
			URL classURL = urls.nextElement();
			URI classURI = URI.createURI(classURL.toExternalForm(), true);

			try {
				String className = classURI.trimFileExtension().lastSegment();
				if (!"DependencyUpdater".equals(className) && className.endsWith("Updater")) {
					Class<? extends DependencyUpdater> updaterClass = bundle.loadClass(path.replace('/', '.') + className).asSubclass(DependencyUpdater.class);
					if (!Modifier.isAbstract(updaterClass.getModifiers())) {
						DependencyUpdater updater = updaterClass.newInstance();
						if (updater.canUpdate(mapFile)) {
							result = updater;
							break;
						}
					}
				}
			} catch (ClassNotFoundException e) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "No such class: " + classURI.lastSegment(), e));
			} catch (IllegalAccessException | InstantiationException e) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Failed to instantiated " + classURI.lastSegment(), e));
			}
		}

		return result;
	}
}
