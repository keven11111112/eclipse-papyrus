/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.RelativeBendpoint;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;


/**
 * Class that contains utililty methods on top of GMF constructs.
 */
public class Util {

	/**
	 * Test if an EditPart is an Affixed Child Node or not
	 * 
	 * @param ep
	 *        the editpart to test
	 * @return <ul>
	 *         <li> <code>true</code> if the editpart is an Affixed Child Node</li>
	 *         <li> <code>false</code>if not</li>
	 *         </ul>
	 */
	public static boolean isAffixedChildNode(EditPart ep) {
		if(ep instanceof BorderedBorderItemEditPart) {
			if(ep.getParent() instanceof CompartmentEditPart) {
				return false;
			} else if(ep.getParent() instanceof DiagramEditPart) {
				return false;
			}
			return true;
		}
		return false;
	}

	//FIXME : remove useless stringS
	public static final String RECONNECT_REQUEST_INITIAL_POINTS_LIST = "Initial_PointList";

	public static final String RECONNECT_REQUEST_INITIAL_CONSTRAINTS = "Initial_Constraint";

	/**
	 * 
	 * @return
	 *         the current constraints for the connection
	 */
	//TODO : move me
	public static final List<RelativeBendpoint> getConnectionConstraint(final Connection connection) {
		System.out.println("ask contraints///////////////////////////////////////////////////////////////////////////////////");
		Object value = connection.getConnectionRouter().getConstraint(connection);
		final List<RelativeBendpoint> contraints = new ArrayList<RelativeBendpoint>();
		if(value instanceof List<?>) {
			final List<RelativeBendpoint> obtainedList = new ArrayList<RelativeBendpoint>();
			for(int i = 0; i < ((List<?>)value).size(); i++) {
				Object current = ((List<?>)value).get(i);
				if(current instanceof RelativeBendpoint) {
					final RelativeBendpoint curr = (RelativeBendpoint)current;
					obtainedList.add(curr);
				}
			}

			//copy the list  TODO : using suivante methode
			final Point first = obtainedList.get(0).getLocation();
			final Point last = obtainedList.get(obtainedList.size() - 1).getLocation();
			for(int i = 0; i < obtainedList.size(); i++) {
				final Point current = obtainedList.get(i).getLocation();
				final Dimension s = current.getDifference(first);
				final Dimension t = current.getDifference(last);
				final RelativeBendpoint relatedBendpoint = new org.eclipse.draw2d.RelativeBendpoint(connection);
				relatedBendpoint.setRelativeDimensions(s, t);
				contraints.add(relatedBendpoint);
				//FIXME : add weight
			}
		}
		return contraints;
	}

	public static final List<RelativeBendpoint> copyRelatedBendpointList(final List<RelativeBendpoint> obtainedList, final Connection connection) {
		final List<RelativeBendpoint> contraints = new ArrayList<RelativeBendpoint>();
		final Point first = obtainedList.get(0).getLocation();
		final Point last = obtainedList.get(obtainedList.size() - 1).getLocation();
		for(int i = 0; i < obtainedList.size(); i++) {
			final Point current = obtainedList.get(i).getLocation();
			final Dimension s = current.getDifference(first);
			final Dimension t = current.getDifference(last);
			final RelativeBendpoint relatedBendpoint = new org.eclipse.draw2d.RelativeBendpoint(connection);
			relatedBendpoint.setRelativeDimensions(s, t);
			contraints.add(relatedBendpoint);
			//FIXME : add weight
		}
		return contraints;
	}
}
