/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *  Christian W. Damus (CEA) - create model by URI, not IFile (CDO)
 *  Christian W. Damus (CEA) - Support creating models in repositories (CDO)
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards.category;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * @deprecated use {@link org.eclipse.papyrus.uml.diagram.wizards.command.PapyrusModelFromExistingDomainModelCommand}
 * 
 */
@Deprecated
public class PapyrusModelFromExistingDomainModelCommand extends org.eclipse.papyrus.uml.diagram.wizards.command.PapyrusModelFromExistingDomainModelCommand {

	public PapyrusModelFromExistingDomainModelCommand(ModelSet modelSet, URI newURI, EObject root) {
		super(modelSet, newURI, root);
	}

}
