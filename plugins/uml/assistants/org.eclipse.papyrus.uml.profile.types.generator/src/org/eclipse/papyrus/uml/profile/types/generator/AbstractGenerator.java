/*****************************************************************************
 * Copyright (c) 2014, 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.profile.types.generator;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.profile.types.generator.internal.Activator;
import org.eclipse.uml2.common.util.UML2Util;

import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Scaffolding for an Xtend model-to-model transformation.
 * 
 * @param <T>
 *            the kind of model element that I generate from a UML profile
 */
public abstract class AbstractGenerator<I extends EObject, O extends EObject> {

	private final Injector injector;

	@Inject
	@InputModel
	private EClass inputType;

	@Inject
	@OutputModel
	private EClass outputType;

	@Inject
	private Identifiers identifiers;

	public AbstractGenerator(Identifiers identifiers) {
		this(new GeneratorModule(identifiers));
	}

	public AbstractGenerator(GeneratorModule module) {
		super();

		this.injector = Guice.createInjector(module);
		injector.injectMembers(this);
	}

	public String getLabel() {
		String result = identifiers.getLabel(outputType);

		return Strings.isNullOrEmpty(result) ? "output model" : result;
	}

	public IStatus generate(URI inputURI, URI outputURI) {
		IStatus result;
		ResourceSet resourceSet = new ResourceSetImpl();

		try {
			I input = UML2Util.load(resourceSet, inputURI, inputType);
			result = generate(input, outputURI);
		} finally {
			EMFHelper.unload(resourceSet);
		}

		return result;
	}

	public IStatus generate(I input, URI outputURI) {
		IStatus result;
		ResourceSet resourceSet = new ResourceSetImpl();

		try {
			Resource output = resourceSet.createResource(outputURI);

			result = generate(input, output.getContents());

			try {
				output.save(null);
			} catch (IOException e) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Failed to save output", e));
			}
			refreshContainer(outputURI);
		} catch (CoreException e) {
			result = e.getStatus();
		} finally {
			EMFHelper.unload(resourceSet);
		}

		return result;
	}

	public IStatus generate(I input, EList<? super EObject> output) {
		IStatus result = Status.OK_STATUS;

		output.add(generate(input));

		return result;
	}

	protected abstract O generate(I input);

	protected void refreshContainer(URI resourceURI) throws CoreException {
		if (resourceURI.isPlatformResource()) {
			IContainer container = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(resourceURI.toPlatformString(true))).getParent();
			if ((container != null) && container.isAccessible()) {
				container.refreshLocal(IResource.DEPTH_ONE, null);
			}
		} else if (resourceURI.isFile()) {
			try {
				IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(new java.net.URI(resourceURI.toString()));
				Set<IContainer> containers = Sets.newHashSet();
				for (IFile next : files) {
					containers.add(next.getParent());
				}

				for (IContainer next : containers) {
					next.refreshLocal(IResource.DEPTH_ONE, null);
				}
			} catch (URISyntaxException e) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Bad resource URI", e));
			}
		}
	}
}
