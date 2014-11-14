/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.elementtypesconfigurations.factories;

import org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.IConfiguredEditHelperAdviceDescriptor;

public interface IEditHelperAdviceFactory<T extends AdviceConfiguration> {

	public IConfiguredEditHelperAdviceDescriptor<T> createEditHelperAdviceDescriptor(T configuration);
}
