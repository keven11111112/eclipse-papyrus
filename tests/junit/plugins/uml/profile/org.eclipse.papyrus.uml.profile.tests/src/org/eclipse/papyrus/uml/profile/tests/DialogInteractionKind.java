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

package org.eclipse.papyrus.uml.profile.tests;

/**
 * An enumeration of a test's possible modes of interaction
 * with the Papyrus editor's profile migration dialog.
 */
public enum DialogInteractionKind {
	/** No interaction: the dialog is not expected to appear. */
	NONE, //
	/** Cancel the dialog without migrating profiles. */
	CANCEL, //
	/** Press OK to apply the default profile migrations. */
	OK;
}
