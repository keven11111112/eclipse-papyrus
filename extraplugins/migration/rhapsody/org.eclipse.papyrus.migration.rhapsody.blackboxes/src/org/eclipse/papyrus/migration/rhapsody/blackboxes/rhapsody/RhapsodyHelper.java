/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.migration.rhapsody.blackboxes.rhapsody;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IProject;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ISubsystem;

/**
 * This blackboxes provides helper for the Rhapsody metamodel
 *
 */
public class RhapsodyHelper {

	/**
	 * 
	 * @param project
	 *            an IProject
	 * @return
	 * 		the subsystem providing from Rhapsody files and referenced by the user model
	 */
	@Operation(kind = Kind.HELPER)
	public List<ISubsystem> getISubsystemsFromRhapsodyLibraries(final IProject project) {
		EcoreUtil.resolveAll(project);
		final ResourceSet set = project.eResource().getResourceSet();
		final List<ISubsystem> subs = new ArrayList<ISubsystem>();
		for (Resource current : set.getResources()) {
			if (isRhapsodyLibraryResource(current)) {
				final List<EObject> contents = current.getContents();
				for (EObject curr : contents) {
					if (curr instanceof ISubsystem) {
						subs.add((ISubsystem) curr);
					}
				}
			}
		}
		return subs;
	}




	/**
	 * text used for EAnnotation created during the Rhapsody import
	 */
	public static final String RHAPSODY_IMPORTER_EANNOTATION_SOURCE = "RhapsodyImporter";//$NON-NLS-1$

	/**
	 * String used to define if the created resource represents a Rhapsody Library (<code>true</code>) or a user resource (<code>false</code>)
	 */
	public static final String RHAPSODY_IMPORTER_IS_RHAPSODY_LIBRARY_RESOURCE_KEY = "IsRhapsodyLibraryResource";//$NON-NLS-1$

	/**
	 * TODO : duplicated from RhapsodyShareFolderUtils
	 * 
	 * @param resource
	 *            a resource
	 * @return
	 * 		<code>true</code> if the resource represents a Rhapsody Library. <code>false</code> otherwise
	 */
	public boolean isRhapsodyLibraryResource(final Resource resource) {
		for (EObject content : resource.getContents()) {
			if (content instanceof EAnnotation) {
				EAnnotation annotation = (EAnnotation) content;
				if (RHAPSODY_IMPORTER_EANNOTATION_SOURCE.equals(annotation.getSource())) {
					return Boolean.TRUE.toString().equals(annotation.getDetails().get(RHAPSODY_IMPORTER_IS_RHAPSODY_LIBRARY_RESOURCE_KEY));
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param eobject
	 *            an eobject
	 * @return
	 * 		<code>true</code> if the eobject comes from a Rhapsody Library
	 */
	public boolean isComingFromARhapsodyLibraryResource(final EObject eobject) {
		return isRhapsodyLibraryResource(eobject.eResource());
	}
}
