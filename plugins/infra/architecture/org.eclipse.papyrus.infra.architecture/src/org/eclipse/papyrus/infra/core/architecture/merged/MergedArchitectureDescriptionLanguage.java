/**
 * Copyright (c) 2017, 2020 CEA LIST.
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
 *
 */
package org.eclipse.papyrus.infra.core.architecture.merged;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.infra.core.architecture.ADElement;
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
	 */
	public MergedArchitectureDescriptionLanguage(MergedArchitectureDomain domain) {
		super(domain);
	}




	/**
	 * Get the language's metamodel EPackage
	 *
	 * @return an EPackage
	 */
	public EPackage getMetamodel() {
		for (ADElement element : elements) {
			ArchitectureDescriptionLanguage language = (ArchitectureDescriptionLanguage) element;
			if (language.getMetamodel() != null) {
				return language.getMetamodel();
			}
		}
		return null;
	}

	/**
	 * Get a merged collection of the language's profile EPackages
	 *
	 * @return a collection of EPackages
	 */
	public Collection<EPackage> getProfiles() {
		Set<EPackage> profiles = new LinkedHashSet<>();
		for (ADElement element : elements) {
			ArchitectureDescriptionLanguage language = (ArchitectureDescriptionLanguage) element;
			profiles.addAll(language.getProfiles());
		}
		return Collections.unmodifiableCollection(profiles);
	}

	/**
	 * Get a merged collection of the language's representation kinds
	 *
	 * @return a collection of representation kinds
	 */
	public Collection<RepresentationKind> getRepresentationKinds() {
		Set<RepresentationKind> kinds = new LinkedHashSet<>();
		for (ADElement element : elements) {
			ArchitectureDescriptionLanguage language = (ArchitectureDescriptionLanguage) element;
			kinds.addAll(language.getRepresentationKinds());
		}
		return Collections.unmodifiableCollection(kinds);
	}

	/**
	 *
	 * @return
	 *         the a collection of TreeViewerConfiguration
	 * @since 3.0
	 */
	public Collection<TreeViewerConfiguration> getTreeViewerConfigurations() {
		Set<TreeViewerConfiguration> kinds = new LinkedHashSet<>();
		for (ADElement element : elements) {
			ArchitectureDescriptionLanguage language = (ArchitectureDescriptionLanguage) element;
			kinds.addAll(language.getTreeViewerConfigurations());
		}
		return Collections.unmodifiableCollection(kinds);
	}

}
