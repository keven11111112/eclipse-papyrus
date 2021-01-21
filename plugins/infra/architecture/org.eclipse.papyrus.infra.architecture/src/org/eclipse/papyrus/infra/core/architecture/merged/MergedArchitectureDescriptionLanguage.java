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
 *  Vincent Lorenzo (CEA LIST) - vincent.lorenzo@cea.fr - bug 565361
 *  Christian W. Damus - bug 570486
 *
 */
package org.eclipse.papyrus.infra.core.architecture.merged;

import java.util.Collection;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;
import org.eclipse.papyrus.infra.core.architecture.TreeViewerConfiguration;

/**
 * An element that represents a merged collection of {@link org.eclipse.papyrus.infra.core.
 * architecture.ArchitectureDescriptionLanguage}s. This allows the definition of architecture
 * description languages to be split across several architectural models (*.architecture).
 *
 * This class is a subclass of {@link org.eclipse.papyrus.infra.core.architecture.merged.
 * MergedArchitectureContext}s
 *
 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage
 * @since 1.0
 */
public class MergedArchitectureDescriptionLanguage extends MergedArchitectureContext {

	/**
	 * Create a new '<em><b>Merged Architecture Description Language</b></em>'.
	 *
	 * @param domain
	 *            the merged parent domain of this language
	 * @deprecated the merge model now requires a backing model
	 */
	@Deprecated
	public MergedArchitectureDescriptionLanguage(MergedArchitectureDomain domain) {
		this(domain, null);
	}

	public MergedArchitectureDescriptionLanguage(MergedArchitectureDomain domain, ArchitectureDescriptionLanguage language) {
		super(domain, language);
	}

	@Override
	protected ArchitectureDescriptionLanguage getModel() {
		return (ArchitectureDescriptionLanguage) super.getModel();
	}

	/**
	 * Get the language's metamodel EPackage
	 *
	 * @return an EPackage
	 */
	public EPackage getMetamodel() {
		return getModel().getMetamodel();
	}

	/**
	 * Get a merged collection of the language's profile EPackages
	 *
	 * @return a collection of EPackages
	 */
	public Collection<EPackage> getProfiles() {
		return ECollections.unmodifiableEList(getModel().getProfiles());
	}

	/**
	 * Get a merged collection of the language's representation kinds
	 *
	 * @return a collection of representation kinds
	 */
	public Collection<RepresentationKind> getRepresentationKinds() {
		return ECollections.unmodifiableEList(getModel().getRepresentationKinds());

	}

	/**
	 *
	 * @return
	 *         the a collection of TreeViewerConfiguration
	 * @since 3.0
	 */
	public Collection<TreeViewerConfiguration> getTreeViewerConfigurations() {
		return ECollections.unmodifiableEList(getModel().getTreeViewerConfigurations());

	}

}
