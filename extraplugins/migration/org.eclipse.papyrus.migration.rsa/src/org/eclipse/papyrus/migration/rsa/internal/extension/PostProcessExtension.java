/*****************************************************************************
 * Copyright (c) 2017 Christian W. Damus and others.
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

package org.eclipse.papyrus.migration.rsa.internal.extension;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.qvt.oml.ExecutionContext;

/**
 * <p>
 * Extension to the RSA-to-Papyrus transformation's post-processing phase
 * for dependency migration and stereotype repair. {@link TransformationExtension}s
 * may additionally implement this interface to be invoked after all other
 * post-processing is done by the core import framework.
 * </p>
 * <p>
 * This is provisional API.
 * </p>
 */
public interface PostProcessExtension extends TransformationExtension {
	/**
	 * <p>
	 * Post-processes the completed imported model. This method is invoked in the
	 * context of a write transaction, so the implementation is free to make any
	 * edits to the model directly, without the use of commands. Note that this
	 * does imply that the changes made to the model are not undoable and cannot
	 * be rolled back in case of any failure.
	 * </p>
	 * <p>
	 * <b>Note</b> also that this post-processing is performed in different resource
	 * set to the one in which the base transformation extensions are performed.
	 * Therefore, before this method is invoked, the receiver will have been
	 * assigned a new {@link #setResourceSet(ResourceSet) resourceSet}.
	 * </p>
	 * 
	 * @param context
	 *            the QVTo execution context
	 * @param monitor
	 *            for optional reporting of progress if the post-processing is
	 *            expected to be a long-running operation. This is a private
	 *            monitor for the extension that should be started and finished
	 *            as usual. So, the {@linkplain #getNumberOfSteps() number of steps}
	 *            reported by the base transformation must not include this
	 *            post-processing phase
	 * 
	 * @return a status indicating success or problems
	 * 
	 * @see #setResourceSet(ResourceSet)
	 * @see #getNumberOfSteps()
	 */
	IStatus postProcess(ExecutionContext context, IProgressMonitor monitor);
}
