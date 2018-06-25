/**
 * Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain;
import org.eclipse.papyrus.infra.core.architecture.Concern;
import org.eclipse.papyrus.infra.core.architecture.Stakeholder;

/**
 * An element that represents a merged collection of {@link org.eclipse.papyrus.infra.core.
 * architecture.ArchitectureDomain}s. This allows the definition of architecture 
 * domains to be split across several architectural models (*.architecture). 
 * 
 * This class is a subclass of {@link org.eclipse.papyrus.infra.core.architecture.merged.
 * MergedADElement}s
 *  
 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain
 * @since 1.0
 */
public class MergedArchitectureDomain extends MergedADElement {

	/**
	 * Create a new '<em><b>Merged Architecture Domain</b></em>'.
	 */
	public MergedArchitectureDomain() {
		super(null);
	}
	
	/**
	 * Get a merged collection of the domain's stakeholders
	 * 
	 * @return a collection of stakeholders
	 */
	public Collection<Stakeholder> getStakeholders() {
		Set<Stakeholder> stakeholders = new LinkedHashSet<>();
		for (ADElement element : elements) {
			ArchitectureDomain domain = (ArchitectureDomain) element;
			stakeholders.addAll(domain.getStakeholders());
		}
		return Collections.unmodifiableCollection(stakeholders);
	}

	/**
	 * Get a merged collection of the domain's concerns
	 * 
	 * @return a collection of concerns
	 */
	public Collection<Concern> getConcerns() {
		Set<Concern> concerns = new LinkedHashSet<>();
		for (ADElement element : elements) {
			ArchitectureDomain domain = (ArchitectureDomain) element;
			concerns.addAll(domain.getConcerns());
		}
		return Collections.unmodifiableCollection(concerns);
	}

	/**
	 * Get a merged collection of the domain's contexts
	 * 
	 * @return a collection of contexts
	 */
	public Collection<MergedArchitectureContext> getContexts() {
		Map<String, MergedArchitectureContext> contexts = new HashMap<>();
		for (ADElement element : elements) {
			ArchitectureDomain domain = (ArchitectureDomain) element;
			for (ArchitectureContext context : domain.getContexts()) {
				MergedArchitectureContext merged = contexts.get(context.getName());
				if (merged == null) {
					if (context instanceof ArchitectureDescriptionLanguage)
						contexts.put(context.getName(), merged = new MergedArchitectureDescriptionLanguage(this));
					else
						contexts.put(context.getName(), merged = new MergedArchitectureFramework(this));
				}
				merged.merge(context);
			}
		}
		return Collections.unmodifiableCollection(contexts.values());
	}

	/**
	 * Merges the given domain element with the other merge increments
	 * 
	 * @param domain a given domain to merge
	 */
	public void merge(ArchitectureDomain domain) {
		elements.add(domain);
	}
	
}
