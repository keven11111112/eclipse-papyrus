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

package org.eclipse.papyrus.uml.diagram.wizards.profile;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.uml.extensionpoints.profile.IRegisteredProfile;
import org.eclipse.swt.graphics.Image;

/**
 * @author Quentin Le Menez
 *
 */
public class ProfileChooserLabelProvider extends LabelProvider {

	/**
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof IRegisteredProfile) {
			return ((IRegisteredProfile) element).getName();
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof IRegisteredProfile) {
			return ((IRegisteredProfile) element).getImage();
		}
		return null;
	}

}
