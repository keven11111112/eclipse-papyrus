/*****************************************************************************
 * Copyright (c) 2013, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *  Christian W. Damus - bugs 485220, 496299
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.ISavedState;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManagerFactory;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.papyrus.infra.emf.internal.resource.index.IndexManager;
import org.eclipse.papyrus.infra.emf.internal.resource.index.IndexPersistenceManager;
import org.eclipse.papyrus.infra.emf.spi.resolver.EObjectResolverService;
import org.eclipse.papyrus.infra.emf.spi.resolver.IEObjectResolver;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	/**
	 * The plug-in ID
	 */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.infra.emf"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The plug-in's logger
	 */
	public static LogHelper log;

	private ICustomizationManager fCustomizationManager;
	// temp resourceSet
	private ResourceSet facetRecsourceSet = new ResourceSetImpl();

	private EObjectResolverService resolverService;

	/**
	 * The constructor
	 */
	public Activator() {
		super();
	}

	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		log = new LogHelper(this);

		resolverService = new EObjectResolverService(context);

		// Set up for workspace save and loading from saved state
		WorkspaceSaveHelper saveHelper = new WorkspaceSaveHelper();
		List<WorkspaceSaveHelper.SaveDelegate> saveDelegates = getSaveDelegates();
		ISavedState state = ResourcesPlugin.getWorkspace().addSaveParticipant(
				PLUGIN_ID,
				saveHelper.createSaveParticipant(saveDelegates));
		if ((state != null) && (state.getSaveNumber() != 0)) {
			saveHelper.initializeSaveDelegates(state, saveDelegates);
		}

		// Kick off the workspace model indexing system
		new Job("Initialize workspace model index") {
			{
				setSystem(true);
			}

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				IndexManager.getInstance();

				return Status.OK_STATUS;
			}
		}.schedule();
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		resolverService.dispose();
		resolverService = null;

		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 *
	 * @return the customization manager in charge to adapt element in modisco
	 */
	public ICustomizationManager getCustomizationManager() {
		if (this.fCustomizationManager == null) {
			this.fCustomizationManager = ICustomizationManagerFactory.DEFAULT.getOrCreateICustomizationManager(facetRecsourceSet);
		}
		return this.fCustomizationManager;
	}

	/** @return the qualified name of the given metaclass */
	public static String getMetaclassQualifiedName(final EClassifier eClass) {
		final ArrayList<String> qualifiedNameParts = new ArrayList<String>();
		final StringBuilder builder = new StringBuilder();

		EPackage ePackage = eClass.getEPackage();
		while (ePackage != null) {
			qualifiedNameParts.add(ePackage.getName());
			ePackage = ePackage.getESuperPackage();
		}

		for (int i = qualifiedNameParts.size() - 1; i >= 0; i--) {
			builder.append(qualifiedNameParts.get(i) + "."); //$NON-NLS-1$
		}

		builder.append(eClass.getName());

		return builder.toString();
	}

	/**
	 * Obtain the instance of the {@link EObject} resolver service, if any.
	 * 
	 * @return the object resolver service (never {@code null} while this bundle is active)
	 * @since 2.0
	 */
	public IEObjectResolver getEObjectResolver() {
		return resolverService;
	}

	private List<WorkspaceSaveHelper.SaveDelegate> getSaveDelegates() {
		return Arrays.asList(
				new WorkspaceSaveHelper.SaveDelegate("index", //$NON-NLS-1$
						IndexPersistenceManager.INSTANCE.getSaveParticipant(),
						IndexPersistenceManager.INSTANCE::initialize));
	}
}
