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

package org.eclipse.papyrus.uml.tools.profile.index;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.core.language.ILanguage;
import org.eclipse.papyrus.infra.core.language.ILanguageProvider;
import org.eclipse.papyrus.infra.core.language.ILanguageService;
import org.eclipse.papyrus.infra.core.services.BadStateException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.Profile;
import org.osgi.framework.Bundle;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * <p>
 * A language provider based on UML profiles. It uses the {@link IProfileIndex} to efficiently
 * determine the profiles applied to UML resources and return languages based on the applied
 * profiles that it finds. It must be configured using the parameterized
 * <tt>{@literal <implementation>}</tt> element of the language extension point. Parameters
 * are of the form:
 * </p>
 * <table>
 * <tr>
 * <th>Name</th>
 * <th>Value</th>
 * <th>Comments</th>
 * </tr>
 * <tr valign="top">
 * <td><tt>profile.<i>N</i></tt></td>
 * <td>URI of a {@link Profile} element in a profile resource</td>
 * <td>where <i>N</i> is an unique index 1, 2, etc. distinguishing the profile parameters</td>
 * </tr>
 * <tr valign="top">
 * <td><tt>language.<i>N</i></tt></td>
 * <td>name of class implementing the {@link ILanguage} interface on the declaring plug-in's classpath</td>
 * <td>where <i>N</i> matches the corresponding profile parameter</td>
 * </tr>
 * </table>
 */
public class ProfileLanguageProvider implements ILanguageProvider, IExecutableExtension {
	private static final Pattern NAME_PATTERN = Pattern.compile("(?:(profile)|language)\\.(\\d+)"); //$NON-NLS-1$

	private IConfigurationElement config;
	private Map<URI, String> languageClasses;

	public ProfileLanguageProvider() {
		super();
	}

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
		this.config = config;

		if (!(data instanceof Map<?, ?>)) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Initialization parameter 'data' is not a Map in language provider from contributor " + config.getContributor().getName()));
		}

		// Gather configuration parameters
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) data;

		Map<String, URI> profileURIs = Maps.newHashMap();
		Map<String, String> languages = Maps.newHashMap();
		for (Map.Entry<String, String> next : map.entrySet()) {
			Matcher m = NAME_PATTERN.matcher(next.getKey());
			if (!m.find()) {
				Activator.log.warn(String.format("Invalid profile language provider parameter name %s from contributor %s", next.getKey(), config.getContributor().getName())); //$NON-NLS-1$
			} else {
				if (m.group(1) != null) {
					// it's a profile
					profileURIs.put(m.group(2), URI.createURI(next.getValue(), true));
				} else {
					// it's a language
					languages.put(m.group(2), next.getValue());
				}
			}
		}

		// Assemble the configuration parameters
		languageClasses = Maps.newHashMap();
		for (Map.Entry<String, URI> next : profileURIs.entrySet()) {
			String languageClass = languages.remove(next.getKey());
			if (languageClass == null) {
				Activator.log.warn(String.format("Missing language class for profile %s from contributor %s", next.getValue(), config.getContributor().getName())); //$NON-NLS-1$
			} else {
				languageClasses.put(next.getValue(), languageClass);
			}
		}

		// Any left over?
		for (String next : languages.values()) {
			Activator.log.warn(String.format("Missing profile URI for language class %s from contributor %s", next, config.getContributor().getName())); //$NON-NLS-1$
		}
	}

	@Override
	public Iterable<ILanguage> getLanguages(ILanguageService languageService, URI modelURI, boolean uriHasFileExtension) {
		Set<ILanguage> result = Sets.newHashSet();

		if (!uriHasFileExtension) {
			modelURI = modelURI.appendFileExtension(UmlModel.UML_FILE_EXTENSION);
		}

		try {
			IProfileIndex index = null;
			ServicesRegistry registry = languageService.getAdapter(ServicesRegistry.class);
			if (registry != null) {
				try {
					index = registry.getService(IProfileIndex.class);
				} catch (BadStateException e) {
					// The ModelSet is started before the rest of the registry, and it doesn't know about the profile
					// index service to start it. So, we must start the profile service explicitly
					registry.startServicesByClassKeys(IProfileIndex.class);
					index = registry.getService(IProfileIndex.class);
				}
			}

			if (index != null) {
				Set<URI> profiles = index.getAppliedProfiles(modelURI).get(10L, TimeUnit.MINUTES);
				for (URI next : profiles) {
					ILanguage language = getLanguage(next);
					if (language != null) {
						result.add(language);
					}
				}
			}
		} catch (Exception e) {
			Activator.log.error(String.format("Failed to access profile index for resource %s", modelURI), e); //$NON-NLS-1$
		}

		return result;
	}

	protected synchronized ILanguage getLanguage(URI profileURI) {
		ILanguage result = null;

		String className = languageClasses.get(profileURI);
		if (className != null) {
			Bundle bundle = Platform.getBundle(config.getContributor().getName());
			if (bundle != null) {
				try {
					Class<?> class_ = bundle.loadClass(className);
					if ((class_ == null) || !ILanguage.class.isAssignableFrom(class_)) {
						languageClasses.remove(profileURI); // Don't try this again
						Activator.log.error(String.format("Not a language class for profile %s in contributor %s: %s", profileURI, config.getContributor().getName(), className), null); //$NON-NLS-1$
					} else {
						result = class_.asSubclass(ILanguage.class).newInstance();
					}
				} catch (Exception e) {
					languageClasses.remove(profileURI); // Don't try this again
					Activator.log.error(String.format("Failed to instantiate language class %s for profile %s in contributor %s", className, profileURI, config.getContributor().getName()), e); //$NON-NLS-1$
				}
			}
		}

		return result;
	}
}
