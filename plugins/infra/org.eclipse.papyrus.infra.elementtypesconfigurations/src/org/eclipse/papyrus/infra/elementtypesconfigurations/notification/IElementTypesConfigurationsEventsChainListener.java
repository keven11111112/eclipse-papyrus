/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.elementtypesconfigurations.notification;

/**
 * Interface to implemented by listeners that want to be notified of {@link ElementTypesConfigurationsEventsChain}
 */
public interface IElementTypesConfigurationsEventsChainListener {

	public void notifyChain(ElementTypesConfigurationsEventsChain chain);
}
