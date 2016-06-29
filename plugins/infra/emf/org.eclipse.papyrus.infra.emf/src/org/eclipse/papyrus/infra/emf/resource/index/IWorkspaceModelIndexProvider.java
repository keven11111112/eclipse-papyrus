/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
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

package org.eclipse.papyrus.infra.emf.resource.index;

import java.util.function.Supplier;

/**
 * A provider of a model index on the <tt>org.eclipse.papyrus.infra.emf.index</tt>
 * extension point.
 * 
 * @since 2.1
 */
@FunctionalInterface
public interface IWorkspaceModelIndexProvider extends Supplier<WorkspaceModelIndex<?>> {
	// Nothing to add
}
