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

package org.eclipse.papyrus.uml.diagram.wizards;

import org.eclipse.ui.services.IEvaluationService;

/**
 * 
 * @deprecated use {@link org.eclipse.papyrus.uml.diagram.wizards.providers.NewModelStorageProviderRegistry}
 * 
 */

@Deprecated
public class NewModelStorageProviderRegistry extends org.eclipse.papyrus.uml.diagram.wizards.providers.NewModelStorageProviderRegistry {

	public NewModelStorageProviderRegistry(IEvaluationService evaluationService) {
		super(evaluationService);
	}

}
