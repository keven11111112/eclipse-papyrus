/**
 * Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.architecture.commands;

import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * An Interface to convert a model in a model set
 * 
 * @since 1.0
 */
public interface IModelConversionCommand {

	/**
	 * Converts the model in the given model set
	 *
	 * @param modelSet the model set
	 */
	void convertModel(final ModelSet modelSet);

}
