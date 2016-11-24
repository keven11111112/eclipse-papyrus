/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.resource;

import org.eclipse.core.internal.preferences.AbstractScope;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

/**
 * This papyrus scope for the papyrus project preference store.
 * This need to manage the preference for the papyrus project with the papyrus project name (to retrieve the correct name).
 * 
 * @since 2.2
 */
@SuppressWarnings("restriction")
public class PapyrusProjectScope extends AbstractScope {

	/**
	 * String constant (value of <code>"papyrusProject"</code>) used for the scope name for this preference scope.
	 */
	public static final String SCOPE = "papyrusProject"; //$NON-NLS-1$

	/**
	 * The papyrus project name.
	 */
	private String papyrusProjectName;

	/**
	 * The context project.
	 */
	private IProject context;

	/**
	 * Constructor.
	 *
	 * @param project
	 *            The project.
	 * @param papyrusProjectName
	 *            The name of the '.di' file.
	 */
	public PapyrusProjectScope(final IProject project, final String papyrusProjectName) {
		this.context = project;
		this.papyrusProjectName = papyrusProjectName;
	}
	
	/**
	 * Default path hierarchy for nodes is /<scope>/<qualifier>.
	 * 
	 * @param qualifier The qualifier.
	 * @return The path hierarchy.
	 */
	@Override
	public IEclipsePreferences getNode(final String qualifier) {
		if (qualifier == null)
			throw new IllegalArgumentException();
		final StringBuilder node = new StringBuilder(context.getName());
		node.append("/"); //$NON-NLS-1$
		node.append(papyrusProjectName);
		return (IEclipsePreferences) Platform.getPreferencesService().getRootNode().node(SCOPE).node(node.toString()).node(qualifier);
	}

	/**
	 * The papyrus scope name.
	 * 
	 * @return The papyrus scope name.
	 */
	@Override
	public String getName() {
		return SCOPE;
	}

	/**
	 * The location of the scope.
	 * 
	 * @return The location of the scope.
	 */
	@Override
	public IPath getLocation() {
		// This must not be save
		return null;
	}
	
	/**
	 * This allows to determinate if the object in parameter is equals to the current.
	 * 
	 * @param obj The object to compare.
	 * @return <code>true</code> if this is equals, <code>false</code> otherwise.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof PapyrusProjectScope))
			return false;
		PapyrusProjectScope other = (PapyrusProjectScope) obj;
		return context.equals(other.context) && papyrusProjectName.equals(other.papyrusProjectName);
	}

	/**
	 * This allows to define the int hash code.
	 * 
	 * @return The int representing the hascode.
	 */
	@Override
	public int hashCode() {
		return super.hashCode() + context.getFullPath().hashCode() + "/".hashCode() + papyrusProjectName.hashCode(); //$NON-NLS-1$
	}

}
