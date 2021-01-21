/**
 * Copyright (c) 2017, 2021 CEA LIST, Christian W. Damus, and others.
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
 *  Christian W. Damus - bug 570486
 *
 *
 */
package org.eclipse.papyrus.infra.core.architecture.merged;

import java.util.Collection;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
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

	private final EList<MergedArchitectureContext> contexts = new UniqueEList<>();

	/**
	 * Create a new '<em><b>Merged Architecture Domain</b></em>'.
	 *
	 * @deprecated the merge model now requires a backing model
	 */
	@Deprecated
	public MergedArchitectureDomain() {
		super(null);
	}

	public MergedArchitectureDomain(ArchitectureDomain domain) {
		super(null, domain);
	}

	@Override
	protected ArchitectureDomain getModel() {
		return (ArchitectureDomain) super.getModel();
	}

	/**
	 * Get a merged collection of the domain's stakeholders
	 *
	 * @return a collection of stakeholders
	 */
	public Collection<Stakeholder> getStakeholders() {
		return ECollections.unmodifiableEList(getModel().getStakeholders());
	}

	/**
	 * Get a merged collection of the domain's concerns
	 *
	 * @return a collection of concerns
	 */
	public Collection<Concern> getConcerns() {
		return ECollections.unmodifiableEList(getModel().getConcerns());
	}

	/**
	 * Get a merged collection of the domain's contexts
	 *
	 * @return a collection of contexts
	 */
	public Collection<MergedArchitectureContext> getContexts() {
		return ECollections.unmodifiableEList(contexts);
	}

	final void addContext(MergedArchitectureContext context) {
		contexts.add(context);
	}

	/**
	 * Merges the given domain element with the other merge increments
	 *
	 * @param domain
	 *            a given domain to merge
	 * @deprecated This merge algorithm is no longer implemented
	 */
	@Deprecated
	public void merge(ArchitectureDomain domain) {
		// Pass
	}

	@Override
	public boolean isMerged() {
		return super.isMerged() || getContexts().stream().anyMatch(MergedADElement::isMerged);
	}

}
