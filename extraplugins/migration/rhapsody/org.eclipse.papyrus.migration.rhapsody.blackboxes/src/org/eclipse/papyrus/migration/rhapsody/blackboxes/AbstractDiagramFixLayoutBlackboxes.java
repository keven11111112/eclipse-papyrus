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

package org.eclipse.papyrus.migration.rhapsody.blackboxes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.ListCompartment;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;

/**
 * @author VL222926
 *         Abstract class to fix the layout of the created diagram
 */
public abstract class AbstractDiagramFixLayoutBlackboxes {

	/**
	 * This method is called by a QVTO file to fix all problems in the diagram created by a QVTO transfo.
	 * 
	 * @param diagram
	 *            a diagram
	 */
	@Operation(kind = Kind.HELPER)
	public void fixLayout(final Diagram diagram) {
		if (isManagedDiagram(diagram)) {
			fixShapePosition(diagram);
		}
	}

	/**
	 * 
	 * @param diagram
	 *            the diagram to fix
	 */
	protected void fixShapePosition(final Diagram diagram) {
		final List<?> children = diagram.getChildren();
		for (final Object current : children) {
			// nothing to do on first level
			if (current instanceof Shape) {
				fixChildrenShapePosition((Shape) current, Collections.singletonList((View) current));
			}
		}
	}

	/**
	 * 
	 * @param shape
	 *            the shape to fix
	 * @param parents
	 *            the graphical parents of the shape, excluding itself
	 */
	protected void fixChildrenShapePosition(final View shape, final List<View> parents) {
		final List<?> children = shape.getChildren();
		for (final Object current : children) {
			final List<View> newParents = new ArrayList<View>(parents);
			newParents.add((View) current);
			if ((!(current instanceof ListCompartment)) && current instanceof BasicCompartment) { // we only need to fix location for children located in a basic compartement. It is not required for affixed noeds and others elements
				fixChildrenShapePosition((View) current, newParents);
			}
			if (current instanceof Shape && ((Shape) current).eContainer() instanceof BasicCompartment) {// to ignore affixed nodes
				final Bounds bounds = (Bounds) ((Shape) current).getLayoutConstraint();
				if (null != bounds) {

					final int X_offset = get_X_Offset((View) current, parents);
					if (X_offset != 0) {
						bounds.setX(bounds.getX() + X_offset);
					}
					final int Y_offset = get_Y_Offset((View) current, parents);
					if (Y_offset != 0) {
						bounds.setY(bounds.getY() + Y_offset);
					}
				}
				fixChildrenShapePosition((View) current, newParents);
			}
		}
	}

	/**
	 * 
	 * @param viewToLocate
	 *            the view to locate
	 * @param parents
	 *            the graphical parents of the view to locate
	 * @return
	 * 		the y offset to locate the view
	 */
	private int get_Y_Offset(final View viewToLocate, final List<View> parents) {
		int offset = 0;
		for (final View current : parents) {
			offset += get_Y_OffsetFor(current);
		}
		return offset;
	}

	/**
	 * 
	 * @param viewToLocate
	 *            the view to locate
	 * @param parents
	 *            the graphical parents of the view to locate
	 * @return
	 * 		the x offset to locate the view
	 */
	private int get_X_Offset(final View viewToLocate, final List<View> parents) {
		int offset = 0;
		for (final View current : parents) {
			offset += get_X_OffsetFor(current);
		}
		return offset;

	}

	/**
	 * 
	 * @param view
	 *            a view
	 * @return
	 * 		the x offset to apply to children of this view
	 */
	protected abstract int get_X_OffsetFor(final View view);
	
	/**
	 * 
	 * @param view
	 *            a view
	 * @return
	 * 		the yF offset to apply to children of this view
	 */
	protected abstract int get_Y_OffsetFor(final View view);

	/**
	 * 
	 * @param diagram
	 *            a diagram
	 * @return
	 * 		<code>true</code> if this manage the given diagram
	 */
	protected abstract boolean isManagedDiagram(Diagram diagram);

}
