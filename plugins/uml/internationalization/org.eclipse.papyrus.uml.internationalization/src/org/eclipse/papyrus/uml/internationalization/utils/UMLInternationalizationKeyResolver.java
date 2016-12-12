/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.internationalization.utils;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.internationalization.InternationalizationEntry;
import org.eclipse.papyrus.infra.internationalization.utils.InternationalizationKeyResolver;
import org.eclipse.papyrus.uml.tools.utils.NameResolutionUtils;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * The internationalization key resolver for the UML elements.
 */
public class UMLInternationalizationKeyResolver extends InternationalizationKeyResolver {

	/**
	 * The singleton instance.
	 */
	private static UMLInternationalizationKeyResolver instance;

	/**
	 * The qualified name separator replacement into properties file.
	 */
	private static final String QUALIFIED_NAME_SEPARATOR_REPLACEMENT = "__"; //$NON-NLS-1$

	/**
	 * Constructor.
	 */
	public UMLInternationalizationKeyResolver() {
		// Do nothing
	}

	/**
	 * Get the singleton instance (create it if not existing).
	 * 
	 * @return The singleton instance.
	 */
	public static UMLInternationalizationKeyResolver getInstance() {
		if (null == instance) {
			instance = new UMLInternationalizationKeyResolver();
		}
		return instance;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.internationalization.utils.InternationalizationKeyResolver#createInternationalizationEntryByKey(java.lang.String,
	 *      org.eclipse.papyrus.infra.core.resource.ModelSet,
	 *      org.eclipse.emf.common.util.URI)
	 */
	@Override
	public InternationalizationEntry createInternationalizationEntryByKey(final String key,
			final ResourceSet resourceSet, final URI uri) {
		InternationalizationEntry entry = super.createInternationalizationEntryByKey(key, resourceSet, uri);

		Object entryKey = entry.getKey();
		if (entryKey instanceof String) {
			if (((String) entryKey).startsWith(LABEL_PREFIX)) {
				entryKey = ((String) entryKey).substring(LABEL_PREFIX.length());
			}
			final String qualifiedName = ((String) entryKey).replaceAll(QUALIFIED_NAME_SEPARATOR_REPLACEMENT,
					NamedElementUtil.QUALIFIED_NAME_SEPARATOR); // $NON-NLS-1$

			// TODO: is this the good way to get the named elements by
			// qualified names?
			final Resource umlResource = resourceSet
					.getResource(uri.trimFileExtension().appendFileExtension(UMLResource.FILE_EXTENSION), true);
			if (null != umlResource && null != umlResource.getContents() && !umlResource.getContents().isEmpty()) {
				final List<NamedElement> elements = NameResolutionUtils.getNamedElements(qualifiedName,
						((Element) umlResource.getContents().get(0)), null);

				if (!elements.isEmpty() && 1 == elements.size()) {
					final NamedElement umlElement = elements.get(0);
					entry.setKey(umlElement);
				}
			}
		}

		return entry;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.internationalization.utils.InternationalizationKeyResolver#getKey(org.eclipse.papyrus.infra.internationalization.InternationalizationEntry)
	 */
	@Override
	public String getKey(final InternationalizationEntry entry) {
		final StringBuilder stringBuilder = new StringBuilder();
		if (entry.getKey() instanceof NamedElement) {

			if (!(entry.getKey() instanceof Stereotype)) {
				stringBuilder.append(LABEL_PREFIX);
			}

			final Resource umlResource = ((NamedElement) entry.getKey()).eResource();

			Namespace superElementInSameResource = null;

			if (null != umlResource) {
				for (final EObject eObjectContent : umlResource.getContents()) {
					if (eObjectContent instanceof Namespace
							&& EcoreUtil.isAncestor(eObjectContent, (NamedElement) entry.getKey())) {
						superElementInSameResource = (Namespace) eObjectContent;
					}
				}
			}

			// Use the shortest qualified name for the control mode if needed
			boolean shortestQualifiedNameUsed = false;

			if (superElementInSameResource.eContainer() != null) {
				List<String> shortestQualifiedNames = NameResolutionUtils.getShortestQualifiedNames(
						(NamedElement) entry.getKey(), (Namespace) superElementInSameResource.eContainer(), false);
				if (!shortestQualifiedNames.isEmpty()) {
					stringBuilder.append(shortestQualifiedNames.get(0).replaceAll(
							NamedElementUtil.QUALIFIED_NAME_SEPARATOR, QUALIFIED_NAME_SEPARATOR_REPLACEMENT));
					shortestQualifiedNameUsed = true;
				}
			}
			if (!shortestQualifiedNameUsed) {
				stringBuilder.append(((NamedElement) entry.getKey()).getQualifiedName()
						.replaceAll(NamedElementUtil.QUALIFIED_NAME_SEPARATOR, QUALIFIED_NAME_SEPARATOR_REPLACEMENT));
			}
		}
		return 0 != stringBuilder.length() ? stringBuilder.toString() : super.getKey(entry);
	}

}
