/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
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

package org.eclipse.papyrus.dev.tests.framework.internal;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * The Papyrus diagram tests project nature.
 */
public class PapyrusDiagramTestProjectNature implements IProjectNature {
	public static final String NATURE_ID = Activator.PLUGIN_ID + ".nature"; //$NON-NLS-1$

	private IProject project;

	public PapyrusDiagramTestProjectNature() {
		super();
	}

	public PapyrusDiagramTestProjectNature(IProject project) {
		super();

		this.project = project;
	}

	@Override
	public final IProject getProject() {
		return project;
	}

	@Override
	public final void setProject(IProject project) {
		this.project = project;
	}

	public boolean hasNature() {
		try {
			IProjectDescription desc = getProject().getDescription();
			return Arrays.asList(desc.getNatureIds()).contains(NATURE_ID);
		} catch (CoreException e) {
			// Well, obviously it doesn't have the nature, then
			return false;
		}
	}

	@Override
	public void configure() throws CoreException {
		IProjectDescription desc = getProject().getDescription();
		List<String> natures = Lists.newArrayList(desc.getNatureIds());

		boolean changed = false;

		if (!natures.contains(NATURE_ID)) {
			natures.add(NATURE_ID);
			desc.setNatureIds(Iterables.toArray(natures, String.class));
			changed = true;
		}

		boolean foundBuilder = false;
		List<ICommand> builders = Lists.newArrayList(desc.getBuildSpec());
		for (ICommand next : builders) {
			if (PapyrusDiagramTestsGenerationBuilder.BUILDER_ID.equals(next.getBuilderName())) {
				foundBuilder = true;
			}
		}
		if (!foundBuilder) {
			ICommand builder = desc.newCommand();
			builder.setBuilderName(PapyrusDiagramTestsGenerationBuilder.BUILDER_ID);
			builder.setBuilding(IncrementalProjectBuilder.CLEAN_BUILD, true);
			builder.setBuilding(IncrementalProjectBuilder.FULL_BUILD, true);
			builders.add(builder); // Needs to be after Java builder to compile the generator workflow!
			desc.setBuildSpec(Iterables.toArray(builders, ICommand.class));
			changed = true;
		}

		if (changed) {
			project.setDescription(desc, null);
		}
	}

	@Override
	public void deconfigure() throws CoreException {
		IProjectDescription desc = getProject().getDescription();
		List<String> natures = Lists.newArrayList(desc.getNatureIds());

		boolean changed = false;

		if (natures.remove(NATURE_ID)) {
			desc.setNatureIds(Iterables.toArray(natures, String.class));
			project.setDescription(desc, null);
			changed = true;
		}

		boolean foundBuilder = false;
		List<ICommand> builders = Lists.newArrayList(desc.getBuildSpec());
		for (Iterator<ICommand> iter = builders.iterator(); iter.hasNext();) {
			ICommand next = iter.next();
			if (PapyrusDiagramTestsGenerationBuilder.BUILDER_ID.equals(next.getBuilderName())) {
				iter.remove();
				foundBuilder = true;
			}
		}
		if (foundBuilder) {
			desc.setBuildSpec(Iterables.toArray(builders, ICommand.class));
			changed = true;
		}

		if (changed) {
			project.setDescription(desc, null);
		}
	}

}
