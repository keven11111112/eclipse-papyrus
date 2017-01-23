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

package org.eclipse.papyrus.infra.gmfdiag.common.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.icon.GetIconOperation;
import org.eclipse.gmf.runtime.common.ui.services.icon.IIconProvider;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.swt.graphics.Image;

/**
 *
 * @author melaasar
 *
 */
public class DefaultElementTypeIconProvider extends AbstractProvider implements IIconProvider {

	private final DiagramElementTypes myElementTypes;

	public DefaultElementTypeIconProvider(DiagramElementTypes elementTypes) {
		myElementTypes = elementTypes;
	}

	public final DiagramElementTypes getElementTypes() {
		return myElementTypes;
	}

	public final DiagramElementTypeImages getElementTypeImages() {
		return myElementTypes.getElementTypeImages();
	}

	public Image getIcon(IAdaptable hint, int flags) {
		ENamedElement definingElement = getElementTypes().getDefiningNamedElement(hint);
		return definingElement == null ? null : getElementTypeImages().getImage(definingElement);
	}

	public boolean provides(IOperation operation) {
		if (operation instanceof GetIconOperation) {
			return ((GetIconOperation) operation).execute(this) != null;
		}
		return false;
	}
}
