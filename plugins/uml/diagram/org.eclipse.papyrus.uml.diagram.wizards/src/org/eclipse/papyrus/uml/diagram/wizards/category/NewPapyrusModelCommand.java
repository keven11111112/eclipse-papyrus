/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Thibault Le Ouay (Sherpa Engineering) t.leouay@sherpa-eng.com  - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.wizards.category;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * 
 * @deprecated use {@link org.eclipse.papyrus.uml.diagram.wizards.command.NewPapyrusModelCommand}
 *
 */
@Deprecated
public class NewPapyrusModelCommand extends org.eclipse.papyrus.uml.diagram.wizards.command.NewPapyrusModelCommand {

	public NewPapyrusModelCommand(ModelSet modelSet, URI newURI) {
		super(modelSet, newURI);
	}

}
