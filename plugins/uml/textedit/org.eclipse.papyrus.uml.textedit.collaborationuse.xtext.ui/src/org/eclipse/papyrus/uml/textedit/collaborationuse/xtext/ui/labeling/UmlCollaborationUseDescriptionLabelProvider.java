/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.ui.labeling;

import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;

/**
 * Provides labels for a IEObjectDescriptions and IResourceDescriptions.
 *
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class UmlCollaborationUseDescriptionLabelProvider extends DefaultDescriptionLabelProvider {

	/*
	 * //Labels and icons can be computed like this:
	 * 
	 * String text(IEObjectDescription ele) {
	 * return "my "+ele.getName();
	 * }
	 * 
	 * String image(IEObjectDescription ele) {
	 * return ele.getEClass().getName() + ".gif";
	 * }
	 */

}
