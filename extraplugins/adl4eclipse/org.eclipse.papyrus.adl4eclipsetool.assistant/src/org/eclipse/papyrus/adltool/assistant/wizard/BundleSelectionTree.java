/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thomas Daniellou (CEA LIST) - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.adltool.assistant.wizard;

import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;

public class BundleSelectionTree extends FilteredTree {

	public BundleSelectionTree(Composite parent) {
		super(parent, SWT.CHECK | SWT.MULTI | SWT.V_SCROLL, new PatternFilter(), true);

		getPatternFilter().setIncludeLeadingWildcard(true);
	}

	@Override
	protected TreeViewer doCreateTreeViewer(Composite parent, int style) {
		return new CheckboxTreeViewer(parent, style);
	}

	@Override
	public CheckboxTreeViewer getViewer() {
		return (CheckboxTreeViewer) treeViewer;
	}
}
