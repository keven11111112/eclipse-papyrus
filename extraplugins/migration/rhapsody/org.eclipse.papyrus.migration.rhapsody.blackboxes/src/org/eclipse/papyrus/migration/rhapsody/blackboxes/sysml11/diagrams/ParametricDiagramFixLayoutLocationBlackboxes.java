/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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

package org.eclipse.papyrus.migration.rhapsody.blackboxes.sysml11.diagrams;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.migration.rhapsody.blackboxes.AbstractDiagramFixLayoutBlackboxes;

/**
 * @author VL222926
 * 
 *         Class to fix the location of the element of the SysML 1.1 Parametric Diagram
 *
 */
public class ParametricDiagramFixLayoutLocationBlackboxes extends AbstractDiagramFixLayoutBlackboxes {

	/**
	 * @see org.eclipse.papyrus.migration.rhapsody.blackboxes.AbstractDiagramFixLayoutBlackboxes#fixLayout(org.eclipse.gmf.runtime.notation.Diagram)
	 *
	 * @param diagram
	 */
	@Override
	public void fixLayout(Diagram diagram) {
		super.fixLayout(diagram);// required, QVT framework is not able to call method without this override
	}

	/**
	 * @see org.eclipse.papyrus.migration.rhapsody.blackboxes.AbstractDiagramFixLayoutBlackboxes#isManagedDiagram(org.eclipse.gmf.runtime.notation.Diagram)
	 *
	 * @param diagram
	 * @return
	 */
	@Override
	protected boolean isManagedDiagram(final Diagram diagram) {
		return "Parametric".equals(diagram.getType()); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.papyrus.migration.rhapsody.blackboxes.AbstractDiagramFixLayoutBlackboxes#get_X_OffsetFor(org.eclipse.gmf.runtime.notation.View)
	 *
	 * @param view
	 * @return
	 */
	@Override
	protected int get_X_OffsetFor(View view) {
		return 0;
	}

	/**
	 * @see org.eclipse.papyrus.migration.rhapsody.blackboxes.AbstractDiagramFixLayoutBlackboxes#get_Y_OffsetFor(org.eclipse.gmf.runtime.notation.View)
	 *
	 * @param view
	 * @return
	 */
	@Override
	protected int get_Y_OffsetFor(View view) {
		if (view instanceof Shape) {
			return -44;
		}
		return 0;
	}
}
