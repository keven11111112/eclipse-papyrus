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
package org.eclipse.papyrus.infra.elementtypesconfigurations;

import org.eclipse.gmf.runtime.emf.type.core.internal.descriptors.IEditHelperAdviceDescriptor;
import org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration;

@SuppressWarnings("restriction")
public interface IConfiguredEditHelperAdviceDescriptor<T extends AdviceConfiguration> extends IEditHelperAdviceDescriptor {

	public void init(T configuration);
}
