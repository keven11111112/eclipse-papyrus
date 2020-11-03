/*****************************************************************************
 * Copyright (c) 2020 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   remi - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.toolsmiths.plugin.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.editor.ModelSetServiceFactory;
import org.eclipse.papyrus.infra.core.resource.EditingDomainServiceFactory;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelsReader;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceDescriptor;
import org.eclipse.papyrus.infra.core.services.ServiceDescriptor.ServiceTypeKind;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceStartKind;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.toolsmiths.validation.profile.internal.checkers.ProfileExtensionsChecker;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.builders.PDEMarkerFactory;
import org.eclipse.uml2.uml.Profile;

/**
 * Builder that checks extensions for the plugin.xml file when project contains a static profile.
 */
@SuppressWarnings("restriction")
public class StaticProfileExtensionsBuilder extends AbstractPapyrusBuilder {

	@Override
	public IProject[] build(IProject builtProject, PapyrusPluginBuilder papyrusBuilder, int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {

		if (papyrusBuilder.isInterrupted() || monitor.isCanceled()) {
			return null;
		}
		final IPluginModelBase pluginModelBase = PluginRegistry.findModel(builtProject);
		if (pluginModelBase == null) {
			return null;
		}
		// check static profile presence?
		Map<IFile, List<Profile>> profiles = findStaticProfiles(builtProject);

		if (profiles.entrySet().isEmpty()) {
			return null;
		}
		// retrieve information from plugin extensions, warning, this iterates several time on the same parser with different file. Check that clean does not happen between various profiles
		for (Entry<IFile, List<Profile>> entry : profiles.entrySet()) {
			ProfileExtensionsChecker profileExtensionsChecker = new ProfileExtensionsChecker(builtProject, entry.getKey(), entry.getValue());
			profileExtensionsChecker.check(monitor);
		}

		return null;

	}

	@Override
	public void clean(IProgressMonitor monitor, IProject project) throws CoreException {
		super.clean(monitor, project);

		final IPluginModelBase pluginModelBase = PluginRegistry.findModel(project);
		if (pluginModelBase == null) {
			return;
		}

		// clean the kind of markers created by the specific plugin error reporter.
		pluginModelBase.getUnderlyingResource().deleteMarkers(PDEMarkerFactory.MARKER_ID, true, IResource.DEPTH_INFINITE);
		for (IPluginExtension extenstion : pluginModelBase.getExtensions().getExtensions()) {
			extenstion.getModel().getUnderlyingResource().deleteMarkers(PDEMarkerFactory.MARKER_ID, true, IResource.DEPTH_INFINITE);

			// clean only once the plugin.xml file
			break;
		}

	}

	private Map<IFile, List<Profile>> findStaticProfiles(IProject builtProject) {
		StaticProfileResourceVisitor visitor = new StaticProfileResourceVisitor();
		try {
			builtProject.accept(visitor, IResource.DEPTH_INFINITE, true);
			return visitor.foundProfiles;
		} catch (CoreException e) {
			Activator.log.error(e);
		}
		return null;
	}

	private static class StaticProfileResourceVisitor implements IResourceVisitor {

		private static final String GENMODEL_EXTENSION = "genmodel";
		private Map<IFile, List<Profile>> foundProfiles = new HashMap<>();

		@Override
		public boolean visit(IResource resource) throws CoreException {

			if (resource.getType() == IResource.FILE && DiModel.DI_FILE_EXTENSION.equals(resource.getFileExtension())) {
				// check sibling gen model file
				// full path for gen model
				String fileName = resource.getFullPath().lastSegment();
				String genModelName = fileName.substring(0, fileName.length() - DiModel.DI_FILE_EXTENSION.length()).concat(GENMODEL_EXTENSION);
				IResource genModelResource = resource.getParent().findMember(genModelName);
				if (genModelResource == null) {
					return resource instanceof IContainer;
				}

				// papyrus model found, now trying to load to see if this is a profile
				URI diFileUri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
				ModelSet modelSet = initialiseModelSet(diFileUri);
				try {
					EObject root = UmlUtils.getUmlModel(modelSet).lookupRoot();
					if (Profile.class.isInstance(root)) {
						Profile profile = Profile.class.cast(root);
						List<Profile> profiles = new ArrayList<>();
						profiles.add(profile);
						profiles.addAll(PackageUtil.getSubProfiles(profile));
						foundProfiles.put((IFile) resource, profiles);
					}
				} catch (NotFoundException e) {
				}
			}

			return resource instanceof IContainer;
		}

		private ModelSet initialiseModelSet(URI diFileUri) {
			ServicesRegistry service = null;

			try {
				service = new ExtensionServicesRegistry();
			} catch (ServiceException e) {
				Activator.log.error(e);
				service = new ServicesRegistry(); // This won't really work
			}

			// Override service factory for Model Set
			ServiceDescriptor descriptor = new ServiceDescriptor(ModelSet.class, ModelSetServiceFactory.class.getName(),
					ServiceStartKind.STARTUP, 10);
			descriptor.setServiceTypeKind(ServiceTypeKind.serviceFactory);
			service.add(descriptor);

			// Override factory for editing domain
			descriptor = new ServiceDescriptor(TransactionalEditingDomain.class,
					EditingDomainServiceFactory.class.getName(), ServiceStartKind.STARTUP, 10,
					Collections.singletonList(ModelSet.class.getName()));
			descriptor.setServiceTypeKind(ServiceTypeKind.serviceFactory);
			service.add(descriptor);

			try {
				service.startServicesByClassKeys(ModelSet.class, TransactionalEditingDomain.class);
			} catch (ServiceException e) {
				Activator.log.error(e);
			}

			ModelSet modelSet = null;
			try {
				modelSet = ServiceUtils.getInstance().getModelSet(service);
			} catch (ServiceException e) {
				// Ignore service exception
			}

			// Instantiate a Model set
			if (modelSet == null) {
				modelSet = new ModelSet();
				try {
					ModelSetServiceFactory.setServiceRegistry(modelSet, service);
				} catch (ServiceException e) {
					// Ignore service exception
				}
			}

			// Read all Model from selected file
			ModelsReader modelsReader = new ModelsReader();
			modelsReader.readModel(modelSet);
			try {
				modelSet.loadModels(diFileUri);
			} catch (ModelMultiException e) {
				Activator.log.error(e);
			}
			// Initialize an editing domain
			modelSet.getTransactionalEditingDomain();
			return modelSet;
		}
	}

}
