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

package org.eclipse.papyrus.uml.internationalization.modelresource;

import java.util.List;
import java.util.Locale;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.internationalization.InternationalizationEntry;
import org.eclipse.papyrus.infra.internationalization.InternationalizationLibrary;
import org.eclipse.papyrus.infra.internationalization.commands.ResetNameCommand;
import org.eclipse.papyrus.infra.internationalization.commands.ResetNameTransactionalCommand;
import org.eclipse.papyrus.infra.internationalization.common.utils.InternationalizationPreferencesUtils;
import org.eclipse.papyrus.infra.internationalization.modelresource.InternationalizationModelResource;
import org.eclipse.papyrus.uml.tools.utils.NameResolutionUtils;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * This allows to manage the UML internationalization resource.
 */
public class UMLInternationalizationModelResource extends InternationalizationModelResource {

	/**
	 * The qualified name separator replacement into properties file.
	 */
	private static final String QUALIFIED_NAME_SEPARATOR_REPLACEMENT = "__"; //$NON-NLS-1$

	/**
	 * Constructor.
	 */
	public UMLInternationalizationModelResource() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.internationalization.modelresource.InternationalizationModelResource#loadResource(org.eclipse.emf.common.util.URI,
	 *      java.util.Locale)
	 */
	@Override
	protected Resource loadResource(final URI uri, final Locale locale) {
		Resource resource = super.loadResource(uri, locale);

		if (null != resource) {
			convertInternationalizationToUMLElements(uri, locale);
		}

		return resource;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.internationalization.modelresource.InternationalizationModelResource#createModel(org.eclipse.emf.common.util.URI)
	 */
	@Override
	public void createModel(final URI uriWithoutExtension) {
		super.createModel(uriWithoutExtension);
		final URI uri = uriWithoutExtension.appendFileExtension(getModelFileExtension());
		convertInternationalizationToUMLElements(uri, InternationalizationPreferencesUtils.getLocalePreference(uri));
	}

	/**
	 * This allows to convert the internationalization entries from String to
	 * UML Named Element managed by their qualified names.
	 * 
	 * @param uri
	 *            The URI of the properties file with the extension.
	 * @param locale
	 *            The locale to use.
	 */
	protected void convertInternationalizationToUMLElements(final URI uri, final Locale locale) {
		final Resource resource = getResourceForURIAndLocale(uri, locale);

		if (null != resource && null != resource.getContents() && !resource.getContents().isEmpty()) {
			final InternationalizationLibrary library = (InternationalizationLibrary) resource.getContents().get(0);

			for (final InternationalizationEntry entry : library.getEntries()) {
				Object key = entry.getKey();
				if (key instanceof String) {
					if (((String) key).startsWith(LABEL_PREFIX)) {
						key = ((String) key).substring(LABEL_PREFIX.length());
					}
					final String qualifiedName = ((String) key).replaceAll(QUALIFIED_NAME_SEPARATOR_REPLACEMENT,
							NamedElementUtil.QUALIFIED_NAME_SEPARATOR); // $NON-NLS-1$

					// TODO: is this the good way to get the named elements by
					// qualified names?
					final Resource umlResource = modelSet
							.getResource(uri.trimFileExtension().appendFileExtension(UMLResource.FILE_EXTENSION), true);
					if (null != umlResource && null != umlResource.getContents()
							&& !umlResource.getContents().isEmpty()) {
						final List<NamedElement> elements = NameResolutionUtils.getNamedElements(qualifiedName,
								((Element) umlResource.getContents().get(0)), null);

						if (!elements.isEmpty() && 1 == elements.size()) {
							final NamedElement umlElement = elements.get(0);
							entry.setKey(umlElement);
							addModifiedAdapter(umlElement, resource);
						}
					}
				}
			}

			resource.setModified(false);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.internationalization.modelresource.InternationalizationModelResource#getSetNameValueCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected Command getSetNameValueCommand(final EditingDomain domain, final EObject eObject) {
		Command result = null;

		// Change name for named element
		if (eObject instanceof NamedElement) {
			if (domain instanceof TransactionalEditingDomain) {
				result = new GMFtoEMFCommandWrapper(new ResetNameTransactionalCommand(
						(TransactionalEditingDomain) domain, eObject, UMLPackage.eINSTANCE.getNamedElement_Name()));
			} else {
				result = new ResetNameCommand(domain, eObject, UMLPackage.eINSTANCE.getNamedElement_Name());
			}
		} else {
			result = super.getSetNameValueCommand(domain, eObject);
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.internationalization.modelresource.InternationalizationModelResource#setNameValue(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected void setNameValue(final EObject eObject) {

		// Change name for named element
		if (eObject instanceof NamedElement) {
			String oldName = ((NamedElement) eObject).getName();
			((NamedElement) eObject).setName(null);
			((NamedElement) eObject).setName(oldName);
		} else {
			super.setNameValue(eObject);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.internationalization.modelresource.InternationalizationModelResource#getKey(org.eclipse.papyrus.infra.internationalization.InternationalizationEntry)
	 */
	@Override
	protected String getKey(final InternationalizationEntry entry) {
		final StringBuilder stringBuilder = new StringBuilder();
		if (entry.getKey() instanceof NamedElement) {

			if (!(entry.getKey() instanceof Stereotype)) {
				stringBuilder.append(LABEL_PREFIX);
			}

			Resource umlResource = ((NamedElement) entry.getKey()).eResource();

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