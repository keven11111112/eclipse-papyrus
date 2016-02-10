/*****************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus - bug 459174
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.types.core;

import org.eclipse.gmf.runtime.emf.type.core.IAdviceBindingDescriptor;
import org.eclipse.papyrus.infra.types.AdviceConfiguration;

public interface IConfiguredEditHelperAdviceDescriptor<T extends AdviceConfiguration> extends IAdviceBindingDescriptor {

	public void init(T configuration);
}
