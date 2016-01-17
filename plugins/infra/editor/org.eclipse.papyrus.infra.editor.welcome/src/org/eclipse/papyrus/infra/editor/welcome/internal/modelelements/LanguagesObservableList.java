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

package org.eclipse.papyrus.infra.editor.welcome.internal.modelelements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.eclipse.papyrus.infra.core.language.ILanguage;
import org.eclipse.papyrus.infra.core.language.ILanguageChangeListener;
import org.eclipse.papyrus.infra.core.language.ILanguageService;
import org.eclipse.papyrus.infra.core.language.LanguageChangeEvent;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.editor.welcome.internal.Activator;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceSet;
import org.eclipse.papyrus.infra.tools.databinding.WritableListWithIterator;

/**
 * An observable list of the {@code LanguageObservable}s encapsulating the
 * {@link ILanguage}s instantiated in the model.
 */
public class LanguagesObservableList extends WritableListWithIterator<LanguageObservable> {
	private ILanguageService languageService;
	private ILanguageChangeListener languagesListener;


	public LanguagesObservableList(WelcomeModelElement owner) {
		super(new ArrayList<>(), LanguageObservable.class);

		try {
			this.languageService = ServiceUtilsForResourceSet.getInstance().getService(ILanguageService.class, owner.getDomain().getResourceSet());
			hookLanguagesListener();
		} catch (ServiceException e) {
			Activator.log.error("Cannot obtain language service. Languages will not be shown.", e); //$NON-NLS-1$
		}
	}

	@Override
	public synchronized void dispose() {
		if (languagesListener != null) {
			languageService.removeLanguageChangeListener(languagesListener);
			languagesListener = null;
			languageService = null;
		}

		super.dispose();
	}

	void hookLanguagesListener() {
		languagesListener = event -> {
			switch (event.getType()) {
			case LanguageChangeEvent.ADDED:
				addAll(event.getLanguages().stream().map(LanguageObservable::new).collect(Collectors.toList()));
				break;
			case LanguageChangeEvent.REMOVED:
				removeAll(getObservables(event.getLanguages()));
				break;
			}
		};

		ModelSet modelSet = languageService.getAdapter(ModelSet.class);
		addAll(languageService.getLanguages(modelSet.getURIWithoutExtension(), false).stream().map(LanguageObservable::new).collect(Collectors.toList()));
		languageService.addLanguageChangeListener(languagesListener);
	}

	Collection<LanguageObservable> getObservables(Collection<? extends ILanguage> languages) {
		return stream().filter(o -> languages.contains(o.getLanguage())).collect(Collectors.toList());
	}
}
