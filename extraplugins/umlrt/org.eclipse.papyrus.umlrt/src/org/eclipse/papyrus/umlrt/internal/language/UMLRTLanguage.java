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

package org.eclipse.papyrus.umlrt.internal.language;

import org.eclipse.papyrus.infra.core.language.Language;
import org.eclipse.papyrus.infra.core.language.Version;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * Implementation of the UML-RT language extension.
 */
public class UMLRTLanguage extends Language {

	public UMLRTLanguage() {
		super("org.eclipse.papyrus.umlrt.language", new Version(1, 1, 0), "UML Real-Time"); //$NON-NLS-1$
	}

	@Override
	public void install(ModelSet modelSet) {
		// TODO Implement me
		System.err.println("UML-RT Language installation is not implemented, yet."); //$NON-NLS-1$
	}

	@Override
	public void uninstall(ModelSet modelSet) {
		// TODO Implement me
	}
}
