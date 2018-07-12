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
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.papyrus.infra.core.architecture.ADElement;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint;
import org.eclipse.papyrus.infra.core.architecture.Concern;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;

/**
 * An element that represents a merged collection of {@link org.eclipse.papyrus.infra.core.
 * architecture.ArchitectureViewpoint}s. This allows the definition of architecture 
 * viewpoints to be split across several architectural models (*.architecture). 
 * 
 * This class is a subclass of {@link org.eclipse.papyrus.infra.core.architecture.merged.
 * MergedADElement}s
 *  
 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint
 * @since 1.0
 */
public class MergedArchitectureViewpoint extends MergedADElement {

	/**
	 * Create a new '<em><b>Merged Architecture Viewpoint</b></em>'.
	 *
	 * @param context the merged parent context of this viewpoint
	 */
	public MergedArchitectureViewpoint(MergedArchitectureContext context) {
		super(context);
	}

	/**
	 * Gets the viewpoint's parent context
	 * 
	 * @return an architecture context
	 */
	public MergedArchitectureContext getContext() {
		return (MergedArchitectureContext) getParent();
	}

	/**
	 * Gets the viewpoint's merged concerns
	 * 
	 * @return a merged collection of concerns
	 */
	public Collection<Concern> getConcerns() {
		Set<Concern> concerns = new LinkedHashSet<>();
		for (ADElement element : elements) {
			ArchitectureViewpoint viewpoint = (ArchitectureViewpoint) element;
			concerns.addAll(viewpoint.getConcerns());
		}
		return Collections.unmodifiableCollection(concerns);
	}

	/**
	 * Gets the viewpoint's merged representation kinds
	 * 
	 * @return a merged collection of representation kinds
	 */
	public Collection<RepresentationKind> getRepresentationKinds() {
		Set<RepresentationKind> kinds = new LinkedHashSet<>();
		for (ADElement element : elements) {
			ArchitectureViewpoint viewpoint = (ArchitectureViewpoint) element;
			kinds.addAll(viewpoint.getRepresentationKinds());
		}
		return Collections.unmodifiableCollection(kinds);
	}

}
