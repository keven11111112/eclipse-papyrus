/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
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

package org.eclipse.papyrus.infra.gmfdiag.common.updater;

import java.util.List;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @since 3.0
 */
public interface DiagramUpdater {

	public List<? extends UpdaterNodeDescriptor> getSemanticChildren(View view);

	public List<? extends UpdaterLinkDescriptor> getContainedLinks(View view);

	public List<? extends UpdaterLinkDescriptor> getIncomingLinks(View view);

	public List<? extends UpdaterLinkDescriptor> getOutgoingLinks(View view);
}
