/*****************************************************************************
 * Copyright (c) 2020 CEA LIST, EclipseSource and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Alexandra Buzila (EclipseSource) - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.toolsmiths.plugin.builder.quickfix;

import java.util.Optional;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.emf.utils.ResourceUtils;
import org.eclipse.papyrus.toolsmiths.plugin.builder.Activator;
import org.eclipse.papyrus.toolsmiths.plugin.builder.Messages;
import org.eclipse.papyrus.toolsmiths.validation.profile.constants.ProfilePluginValidationConstants;
import org.eclipse.pde.core.IBaseModel;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.ui.util.ModelModification;
import org.eclipse.pde.internal.ui.util.PDEModelUtility;
import org.eclipse.uml2.uml.Profile;

/**
 * Resolution that adds an entry for the 'org.eclipse.emf.ecore.generated_package' extension and configures it.
 */
@SuppressWarnings("restriction")
public class NoUMLGenPackageMarkerResolution extends AbstractPapyrusMarkerResolution {

	private IMarker marker;

	@Override
	public String getDescription() {
		return Messages.NoUMLGenPackageMarkerResolution_description;
	}

	@Override
	public String getLabel() {
		return Messages.NoUMLGenPackageMarkerResolution_label;
	}

	@Override
	public void run(IMarker marker) {
		this.marker = marker;
		if (!(marker.getResource() instanceof IFile)) {
			return;
		}
		ModelModification modification = new ModelModification((IFile) marker.getResource()) {
			@Override
			protected void modifyModel(IBaseModel model, IProgressMonitor monitor) throws CoreException {
				if (model instanceof IPluginModelBase) {
					addExtension((IPluginModelBase) model);
				}
			}
		};
		PDEModelUtility.modifyModel(modification, null);
	}

	private void addExtension(IPluginModelBase model) {
		try {
			IPluginExtension extension = model.getFactory().createExtension();
			extension.setPoint(ProfilePluginValidationConstants.UML_GENERATED_PACKAGE_EXTENSION_POINT);
			model.getPluginBase().add(extension);
			IPluginElement packageElement = model.getFactory().createElement(extension);
			packageElement.setName("profile"); //$NON-NLS-1$
			extension.add(packageElement);

			Optional<Profile> profileOptional = MarkerResolutionUtils.getProfile(marker);
			if (profileOptional.isEmpty()) {
				return;
			}
			Profile profile = profileOptional.get();
			String uri = MarkerResolutionUtils.getStereotypeUri(profile);
			if (uri != null) {
				packageElement.setAttribute("uri", uri); //$NON-NLS-1$
			}
			Resource resource = profile.eResource();
			String uriFragment = resource.getURIFragment(profile);
			IFile umlModelFile = MarkerResolutionUtils.getUMLModelFile(marker);
			if (umlModelFile != null) {
				String location = ResourceUtils.mapAndEncodePath(umlModelFile) + "#" + uriFragment; //$NON-NLS-1$
				packageElement.setAttribute("location", location); //$NON-NLS-1$
			}
		} catch (CoreException e) {
			Activator.log.error(e);
		}
	}

}
