/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.widgets.util;

import org.eclipse.papyrus.infra.widgets.editors.AbstractValueEditor;
import org.eclipse.swt.widgets.Composite;

/**
 * The editor factory to create value editor.
 * 
 * @since 3.3
 */
@FunctionalInterface
public interface EditorFactory {
	AbstractValueEditor create(final Composite parent, final int style, final String label, final boolean commitOnFocusLost);
}
