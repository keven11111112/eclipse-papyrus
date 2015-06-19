/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.adltool.assistant.wizard;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;
import org.eclipse.swt.graphics.Image;

/**
 * This class is a label provider that helps displaying a list of bundle in a
 * GUI.
 */
public class BundleLabelProvider extends LabelProvider {

	/**
	 * Constructor.
	 */
	public BundleLabelProvider() {
	}

	@Override
	public Image getImage(Object bundleProject) {
		if (bundleProject instanceof ReversibleProject) {
			return ((ReversibleProject) bundleProject).getImage();
		}

		return super.getImage(bundleProject);
	}

	@Override
	public String getText(Object element) {
		if (element instanceof ReversibleProject) {
			return ((ReversibleProject) element).getId();
		}

		return super.getText(element);
	}
}
