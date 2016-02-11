/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
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

package org.eclipse.papyrus.infra.core.sasheditor.editor;

import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPart;

/**
 * A mixin interface, analogous to the Eclipse UI's {@link IWorkbenchPart}, that
 * defines the protocol for editors and other parts nested within the
 * {@linkplain IMultiPageEditorPart multi-page editor} that are conditionally
 * closeable. That is, parts that may not always be permitted to be closed by the
 * user.
 * 
 * @since 2.0
 */
public interface ICloseablePart {
	/**
	 * The Eclipse-style constant for the workbench property listener protocol,
	 * signalling changes in the {@link #canClose() canClose} property.
	 */
	int PROP_CAN_CLOSE = 0x100001;

	/**
	 * Queries whether I may be closed.
	 * 
	 * @return whether I may be closed
	 */
	boolean canClose();

	/**
	 * Adds a property listener to me, such as for observation of the
	 * {@link #PROP_CAN_CLOSE canClose} property.
	 * 
	 * @param listener
	 *            the listener to add
	 * 
	 * @see IWorkbenchPart#addPropertyListener(IPropertyListener)
	 */
	void addPropertyListener(IPropertyListener listener);

	/**
	 * Removes a property listener from me.
	 * 
	 * @param listener
	 *            the listener to remove
	 * 
	 * @see IWorkbenchPart#removePropertyListener(IPropertyListener)
	 */
	void removePropertyListener(IPropertyListener listener);
}
