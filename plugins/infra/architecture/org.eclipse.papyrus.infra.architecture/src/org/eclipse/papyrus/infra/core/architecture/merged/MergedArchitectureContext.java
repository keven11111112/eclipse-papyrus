/**
 * Copyright (c) 2017 CEA LIST.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 *
 *  SPDX-License-Identifier: EPL-2.0
 *
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *
 *
 */
package org.eclipse.papyrus.infra.core.architecture.merged;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.papyrus.infra.core.architecture.ADElement;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;
import org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration;

/**
 * An element that represents a merged collection of {@link org.eclipse.papyrus.infra.core.
 * architecture.ArchitectureContext}s. This allows the definition of architecture contexts
 * to be split across several architectural models (*.architecture).
 *
 * This class is a subclass of {@link org.eclipse.papyrus.infra.core.architecture.merged.
 * MergedADElement}s
 *
 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureContext
 * @since 1.0
 */
public abstract class MergedArchitectureContext extends MergedADElement {

	/**
	 * Create a new '<em><b>Merged Architecture Context</b></em>'.
	 *
	 * @param domain
	 *            the merged parent domain of this context
	 */
	public MergedArchitectureContext(MergedArchitectureDomain domain) {
		super(domain);
	}

	/**
	 * Gets the context's extension prefix
	 *
	 * @return an extension prefix
	 */
	public String getExtensionPrefix() {
		for (ADElement element : elements) {
			ArchitectureContext context = (ArchitectureContext) element;
			if (context.getExtensionPrefix() != null) {
				return context.getExtensionPrefix();
			}
		}
		return null;
	}

	/**
	 * Gets the context's creation command class
	 *
	 * @return a creation command class
	 */
	public Class<?> getCreationCommandClass() throws ClassNotFoundException {
		for (ADElement element : elements) {
			ArchitectureContext context = (ArchitectureContext) element;
			if (context.getCreationCommandClass() != null) {
				return ClassLoaderHelper.loadClass(context.getCreationCommandClass());
			}
		}
		return null;
	}

	/**
	 * Gets the context's conversion command class
	 *
	 * @return a conversion command class
	 */
	public Class<?> getConversionCommandClass() throws ClassNotFoundException {
		for (ADElement element : elements) {
			ArchitectureContext context = (ArchitectureContext) element;
			if (context.getConversionCommandClass() != null) {
				return ClassLoaderHelper.loadClass(context.getConversionCommandClass());
			}
		}
		return null;
	}

	/**
	 * Gets the context's creation command class name
	 *
	 * @return a creation command class name
	 * @since 2.0
	 */
	public String getCreationCommandClassName() {
		for (ADElement element : elements) {
			ArchitectureContext context = (ArchitectureContext) element;
			if (context.getCreationCommandClass() != null) {
				return context.getCreationCommandClass();
			}
		}
		return null;
	}

	/**
	 * Gets the context's conversion command class name
	 *
	 * @return a conversion command class name
	 * @since 2.0
	 */
	public String getConversionCommandClassName() {
		for (ADElement element : elements) {
			ArchitectureContext context = (ArchitectureContext) element;
			if (context.getConversionCommandClass() != null) {
				return context.getConversionCommandClass();
			}
		}
		return null;
	}

	/**
	 * Gets the context's parent domain
	 *
	 * @return the parent domain
	 */
	public MergedArchitectureDomain getDomain() {
		return (MergedArchitectureDomain) getParent();
	}

	/**
	 * Gets the context's element type set configurations
	 *
	 * @return a merged collection of element type set configurations
	 */
	public Collection<ElementTypeSetConfiguration> getElementTypes() {
		Set<ElementTypeSetConfiguration> configurations = new LinkedHashSet<>();
		for (ADElement element : elements) {
			ArchitectureContext context = (ArchitectureContext) element;
			configurations.addAll(context.getElementTypes());
		}
		return Collections.unmodifiableCollection(configurations);
	}

	/**
	 * Gets the context's viewpoints
	 *
	 * @return a merged collection of viewpoints
	 */
	public Collection<MergedArchitectureViewpoint> getViewpoints() {
		Map<String, MergedArchitectureViewpoint> viewpoints = new HashMap<>();
		for (ADElement element : elements) {
			ArchitectureContext context = (ArchitectureContext) element;
			for (ArchitectureViewpoint viewpoint : context.getViewpoints()) {
				MergedArchitectureViewpoint merged = viewpoints.get(viewpoint.getName());
				if (merged == null) {
					viewpoints.put(viewpoint.getName(), merged = new MergedArchitectureViewpoint(this));
				}
				merged.merge(viewpoint);
			}
		}
		return Collections.unmodifiableCollection(viewpoints.values());
	}

	/**
	 * Gets the context's default viewpoints
	 *
	 * @return a merged collection of viewpoints
	 */
	public Collection<MergedArchitectureViewpoint> getDefaultViewpoints() {
		Map<String, MergedArchitectureViewpoint> viewpoints = new HashMap<>();
		for (ADElement element : elements) {
			ArchitectureContext context = (ArchitectureContext) element;
			for (ArchitectureViewpoint viewpoint : context.getDefaultViewpoints()) {
				MergedArchitectureViewpoint merged = viewpoints.get(viewpoint.getName());
				if (merged == null) {
					viewpoints.put(viewpoint.getName(), merged = new MergedArchitectureViewpoint(this));
				}
				merged.merge(viewpoint);
			}
		}
		return Collections.unmodifiableCollection(viewpoints.values());
	}

}
