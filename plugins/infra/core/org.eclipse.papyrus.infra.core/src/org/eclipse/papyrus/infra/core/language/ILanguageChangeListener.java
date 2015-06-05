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

package org.eclipse.papyrus.infra.core.language;

import java.util.EventListener;

/**
 * A protocol for receipt of {@link LanguageChangeEvent}s.
 */
public interface ILanguageChangeListener extends EventListener {
	/**
	 * A notification that languages have changed in some resource(s) within my scope.
	 * This usually should only be sent by asynchronous {@linkplain ILanguageProvider language providers}.
	 * 
	 * @param event
	 *            the language change event
	 */
	void languagesChanged(LanguageChangeEvent event);
}
