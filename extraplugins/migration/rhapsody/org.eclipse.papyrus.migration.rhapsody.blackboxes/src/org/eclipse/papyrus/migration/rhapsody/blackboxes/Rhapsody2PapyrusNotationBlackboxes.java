/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sebastien Revol (CEA LIST) sebastien.revol@cea.fr - Initial API and implementation
 *  Vincent Lorenzo (CEa LIST) vincent.lorenzo@cea.fr - bugs 496176, 499237 
 *****************************************************************************/

package org.eclipse.papyrus.migration.rhapsody.blackboxes;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg.KeyPoint;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryFactory;
import org.eclipse.papyrus.migration.rhapsody.geometry.utils.RhapsodyShapeOperations;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIAnchor;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIAssociationEnd;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIDiagramFrame;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.CGIObjectLink;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.GraphElementsType;

/**
 * @author sr246418
 *
 */

public class Rhapsody2PapyrusNotationBlackboxes {

	/** the size of the transform field */
	public static final int M_TRANSFORM_SIZE = 6;

	/** the index of intersting value in m transform */
	public static final int M_TRANSFORM_X_RATIO_INDEX = 0;
	public static final int M_TRANSFORM_Y_RATIO_INDEX = 3;
	public static final int M_TRANSFORM_X_POSITION_INDEX = 4;
	public static final int M_TRANSFORM_Y_POSITION_INDEX = 5;

	/** the index of the x and y value for each points of the rectangle */
	public static final int M_POLYGON__RECTANGLE_NB_POINTS_INDEX = 0;

	/** the index of the x and y value for each points of the rectangle */
	public static final int M_POLYGON__RECTANGLE_TOP_LEFT_CORNER_X_INDEX = 1;
	public static final int M_POLYGON__RECTANGLE_TOP_LEFT_CORNER_Y_INDEX = 2;
	public static final int M_POLYGON__RECTANGLE_BOTTOM_LEFT_CORNER_X_INDEX = 3;
	public static final int M_POLYGON__RECTANGLE_BOTTOM_LEFT_CORNER_Y_INDEX = 4;
	public static final int M_POLYGON__RECTANGLE_BOTTOM_RIGHT_CORNER_X_INDEX = 5;
	public static final int M_POLYGON__RECTANGLE_BOTTOM_RIGHT_CORNER__Y_INDEX = 6;
	public static final int M_POLYGON__RECTANGLE_TOP_RIGHT_CORNER_X_INDEX = 7;
	public static final int M_POLYGON__RECTANGLE_TOP_RIGHT_CORNER_Y_INDEX = 8;

	/** X and Y indexes for a point in an array */
	public static final int X_INDEX = 0;
	public static final int Y_INDEX = 1;

	/** code returned when we are not able to get the wanted value */
	public static final int ERROR_CODE = Integer.MAX_VALUE;

	/** names of structural feature */
	public static final String M_TRANSFORM = "m_transform"; //$NON-NLS-1$
	public static final String M_POLYGON = "m_polygon"; //$NON-NLS-1$
	public static final String M_pPARENT = "m_pParent"; //$NON-NLS-1$

	// TODO : try to link me to GMF value!
	private static final int MAGIC_NUMBER_FOR_ABSOLUTE_BENDPOINTS = -643984;

	@Operation(kind = Kind.HELPER)
	public boolean contains(final String aString, final String aPotentialSubString) {
		if (null == aString || aPotentialSubString == null) {
			return false;
		}
		return aString.contains(aPotentialSubString);
	}

	// TODO add GMF source and target object to get their size and location ?
	// 0 : source, 1 : target, 2, ... bendpoints if required
	// TODO : we advice to manage anchor and bendpoints in the same method, to be able to make required adjutment
	/**
	 * @param
	 * 			a
	 *            Rhapsody association
	 * @param
	 * 			result
	 * @return a list, where the 2 first values are the source anchor and the target anchors.
	 * 
	 *         TODO update documentation when we will manage bendpoint too in the same method
	 *         //TODO speak about the magic number
	 *         //TODO try to set one anchor term to 0 or 1 each time
	 *         //TODO : property m_line_style is not yet exploited : 0 is straight, 2 is rectilinear
	 * 
	 */
	@Operation(kind = Kind.QUERY)
	public void addAnchorsAndBendpoints(Object association, Connector result) {
		if (!isARhapsodyLink(association)) {
			return;
		}
		// 1. we need to get all in absolute position
		// find source and target anchor in absolute location
		final List<String> rpySourceAnchorAsString = getM_SourcePort(association);
		final List<String> rpyTargetAnchorAsString = getM_TargetPort(association);
		final GraphElementsType sourceGraphicalObject = getM_pSource(association);
		final GraphElementsType targetGraphicalObject = getM_pTarget(association);
		final RhapsodyShape sourceShape = RhapsodyShapeOperations.createRhapsodyShape(sourceGraphicalObject);
		final RhapsodyShape targetShape = RhapsodyShapeOperations.createRhapsodyShape(targetGraphicalObject);


		final Point rpySourceAnchor = RhpGeometryFactory.eINSTANCE.createPoint();
		rpySourceAnchor.setX(Double.valueOf(rpySourceAnchorAsString.get(0)));
		rpySourceAnchor.setY(Double.valueOf(rpySourceAnchorAsString.get(1)));
		final Point rpySourceAnchorInAbsolute = sourceShape.getTransform().multiply(rpySourceAnchor);


		final Point rpyTargetAnchor = RhpGeometryFactory.eINSTANCE.createPoint();
		rpyTargetAnchor.setX(Double.valueOf(rpyTargetAnchorAsString.get(0)));
		rpyTargetAnchor.setY(Double.valueOf(rpyTargetAnchorAsString.get(1)));
		final Point rpyTargetAnchorInAbsolute = targetShape.getTransform().multiply(rpyTargetAnchor);


		// 2. determine bendpoints in absolute location
		final List<String> rhapsodyBendpointsAsString = getM_arrow(association);
		final List<Point> rhapsodyBendpointsInAbsolute = new ArrayList<Point>();
		if (rhapsodyBendpointsAsString.size() > 0) {
			for (int i = 1; i < Integer.valueOf(rhapsodyBendpointsAsString.get(0)) * 2; i = i + 2) {
				Point newPoint = RhpGeometryFactory.eINSTANCE.createPoint();
				newPoint.setX(Double.valueOf(rhapsodyBendpointsAsString.get(i)));
				newPoint.setY(Double.valueOf(rhapsodyBendpointsAsString.get(i + 1)));
				rhapsodyBendpointsInAbsolute.add(newPoint);
			}
		}


		// 3. here we get the source anchor, the target anchor and the bendpoints in absolute location
		// it is here we could do some adjustment to fix round errors
		// TODO : fix round errors!?
		// /!\ fixing error could make problems for link linked to link ?
		// bendpoint could be not in the good location, if we add/remove an offset to the compartemnt contents!

		// 4. we can now determine source anchor, target anchor and bendpoints
		final Point sourceAnchorInRelative = RhpGeometryFactory.eINSTANCE.createPoint();
		sourceAnchorInRelative.setX(rpySourceAnchorInAbsolute.getX() - sourceShape.getAbsolutePosition().getX());
		sourceAnchorInRelative.setY(rpySourceAnchorInAbsolute.getY() - sourceShape.getAbsolutePosition().getY());

		final Point targetAnchorInRelative = RhpGeometryFactory.eINSTANCE.createPoint();
		targetAnchorInRelative.setX(rpyTargetAnchorInAbsolute.getX() - targetShape.getAbsolutePosition().getX());
		targetAnchorInRelative.setY(rpyTargetAnchorInAbsolute.getY() - targetShape.getAbsolutePosition().getY());

		final Point firstBendpoint = RhpGeometryFactory.eINSTANCE.createPoint();
		firstBendpoint.setX(rpySourceAnchorInAbsolute.getX());
		firstBendpoint.setY(rpySourceAnchorInAbsolute.getY());

		final Point lastBendpoint = RhpGeometryFactory.eINSTANCE.createPoint();
		lastBendpoint.setX(rpyTargetAnchorInAbsolute.getX());
		lastBendpoint.setY(rpyTargetAnchorInAbsolute.getY());


		// we create the bendpoints list
		List<RelativeBendpoint> gmfBendpoints = new ArrayList<RelativeBendpoint>();
		// source bendpoints
		gmfBendpoints.add(new RelativeBendpoint(firstBendpoint.getIntX(), firstBendpoint.getIntY(), MAGIC_NUMBER_FOR_ABSOLUTE_BENDPOINTS, MAGIC_NUMBER_FOR_ABSOLUTE_BENDPOINTS));

		// intermediate bendpoints
		for (Point current : rhapsodyBendpointsInAbsolute) {
			gmfBendpoints.add(new RelativeBendpoint(current.getIntX(), current.getIntY(), MAGIC_NUMBER_FOR_ABSOLUTE_BENDPOINTS, MAGIC_NUMBER_FOR_ABSOLUTE_BENDPOINTS));
		}

		// last bendpoints
		gmfBendpoints.add(new RelativeBendpoint(lastBendpoint.getIntX(), lastBendpoint.getIntY(), MAGIC_NUMBER_FOR_ABSOLUTE_BENDPOINTS, MAGIC_NUMBER_FOR_ABSOLUTE_BENDPOINTS));

		// we register the bendpoints into the connector
		RelativeBendpoints bendpoints12 = NotationFactory.eINSTANCE.createRelativeBendpoints();
		bendpoints12.setPoints(gmfBendpoints);
		result.setBendpoints(bendpoints12);

		IdentityAnchor sourceAnchor = NotationFactory.eINSTANCE.createIdentityAnchor();
		sourceAnchor.setId(getAnchorFromAbsolutePosition(sourceShape, sourceAnchorInRelative));

		IdentityAnchor targetAnchor = NotationFactory.eINSTANCE.createIdentityAnchor();
		targetAnchor.setId(getAnchorFromAbsolutePosition(targetShape, targetAnchorInRelative));

		result.setSourceAnchor(sourceAnchor);
		result.setTargetAnchor(targetAnchor);
		//

		// TODO : rewritte anchor code
		// String sourceAnchor = getAnchorFromAbsolutePosition(sourceShape, rpySourceAnchorAsString);
		// String targetAnchor = getAnchorFromAbsolutePosition(targetShape, rpyTargetAnchorAsString);
		// List<String> returnedValues = new ArrayList<>();
		// returnedValues.add(sourceAnchor);
		// returnedValues.add(targetAnchor);
		//
		// return returnedValues;
	}

	/**
	 * 
	 * @param anObject
	 *            an object
	 * @return
	 * 		<code>true</code> if the object can be considered as a rhapsody link
	 */
	private boolean isARhapsodyLink(final Object anObject) {
		if (getM_pSource(anObject) != null && getM_pTarget(anObject) != null && getM_SourcePort(anObject).size() == 2 && getM_TargetPort(anObject).size() == 2) {
			return true;
		}
		return false;
	}

	private List<String> getM_arrow(Object anObject) {
		if (anObject instanceof CGIObjectLink) {
			return ((CGIObjectLink) anObject).getM_arrow();
		} else if (anObject instanceof CGIAnchor) {
			return ((CGIAnchor) anObject).getM_arrow();
		} else if (anObject instanceof CGIAssociationEnd) {
			return ((CGIAssociationEnd) anObject).getM_arrow();
		}
		return Collections.emptyList();
	}

	private GraphElementsType getM_pSource(Object anObject) {
		if (anObject instanceof CGIObjectLink) {
			return (GraphElementsType) ((CGIObjectLink) anObject).getM_pSource();
		} else if (anObject instanceof CGIAnchor) {
			return (GraphElementsType) ((CGIAnchor) anObject).getM_pSource();
		} else if (anObject instanceof CGIAssociationEnd) {
			return (GraphElementsType) ((CGIAssociationEnd) anObject).getM_pSource();
		}
		return null;
	}

	private GraphElementsType getM_pTarget(Object anObject) {
		if (anObject instanceof CGIObjectLink) {
			return (GraphElementsType) ((CGIObjectLink) anObject).getM_pTarget();
		} else if (anObject instanceof CGIAnchor) {
			return (GraphElementsType) ((CGIAnchor) anObject).getM_pTarget();
		} else if (anObject instanceof CGIAssociationEnd) {
			return (GraphElementsType) ((CGIAssociationEnd) anObject).getM_pTarget();
		}
		return null;
	}

	private List<String> getM_SourcePort(Object anObject) {
		if (anObject instanceof CGIObjectLink) {
			return ((CGIObjectLink) anObject).getM_SourcePort();
		} else if (anObject instanceof CGIAnchor) {
			return ((CGIAnchor) anObject).getM_SourcePort();
		} else if (anObject instanceof CGIAssociationEnd) {
			return ((CGIAssociationEnd) anObject).getM_SourcePort();
		}
		return Collections.emptyList();
	}

	private List<String> getM_TargetPort(Object anObject) {
		if (anObject instanceof CGIObjectLink) {
			return ((CGIObjectLink) anObject).getM_TargetPort();
		} else if (anObject instanceof CGIAnchor) {
			return ((CGIAnchor) anObject).getM_TargetPort();
		} else if (anObject instanceof CGIAssociationEnd) {
			return ((CGIAssociationEnd) anObject).getM_TargetPort();
		}
		return Collections.emptyList();
	}


	/** This method has been developed (not yet finished and not yet usable) to be able to create link on link */
	@Operation(kind = Kind.QUERY)
	// TODO : finish me!
	public void addAnchorsAndBendpoints_V2_FOR_LinkONLink(CGIAnchor association, Connector result) {
		// 1. we need to get all in absolute position
		// find source and target anchor in absolute location
		final List<String> rpySourceAnchorAsString = association.getM_SourcePort();
		final List<String> rpyTargetAnchorAsString = association.getM_TargetPort();
		final GraphElementsType sourceGraphicalObject = (GraphElementsType) association.getM_pSource();
		final GraphElementsType targetGraphicalObject = (GraphElementsType) association.getM_pTarget();
		Point newTargetAnchorInAbsolute = null;// RhpGeometryFactory.eINSTANCE.createPoint();

		// ------------------this part of the code has been done to be able to create anchor on a link (comment link linked to an other link!!!!-----

		if (targetGraphicalObject instanceof CGIObjectLink) {// we are connected on a link, so rpyTargetAnchorAsString could have a first value in % and the second one seem be 0
			CGIObjectLink link = ((CGIObjectLink) targetGraphicalObject);
			Connector tmp = NotationFactory.eINSTANCE.createConnector();
			addAnchorsAndBendpoints(link, tmp);
			// 1. calculate the full length of the link:
			final RelativeBendpoints bendpoints = (RelativeBendpoints) tmp.getBendpoints();
			double length = 0;
			List<LineSeg> linesSegs = new ArrayList<LineSeg>();
			// Iterator<RelativeBendpoint> iter = bendpoints.getPoints().iterator();
			List<Double> cumulatedLength = new ArrayList<>();
			for (int i = 1; i < bendpoints.getPoints().size(); i++) {
				RelativeBendpoint pt1 = (RelativeBendpoint) bendpoints.getPoints().get(i - 1);
				RelativeBendpoint pt2 = (RelativeBendpoint) bendpoints.getPoints().get(i);
				linesSegs.add(new LineSeg(new org.eclipse.draw2d.geometry.Point(pt1.getSourceX(), pt1.getSourceY()), new org.eclipse.draw2d.geometry.Point(pt2.getSourceX(), pt2.getSourceY())));
			}


			for (LineSeg lineSeg : linesSegs) {
				length += lineSeg.length();
				cumulatedLength.add(Double.valueOf(length));
			}

			double percentage = Double.valueOf(rpyTargetAnchorAsString.get(0));
			double wantedLength = length * percentage / 100.00;

			int wantedLineSeg = -1;
			int iter = 0;
			while (wantedLineSeg == -1 && iter < cumulatedLength.size()) {
				if (cumulatedLength.get(iter) > wantedLength) {
					// i is the index of the lineseg on which the good length is obtained
					wantedLineSeg = iter;
				}
			}

			double needToCrossOnThisLineSeg = -1;
			if (iter == 0) {
				needToCrossOnThisLineSeg = wantedLength;
			} else {
				needToCrossOnThisLineSeg = wantedLength - cumulatedLength.get(wantedLineSeg - 1);
			}
			LineSeg w = linesSegs.get(iter);
			double percentage12 = 100 * needToCrossOnThisLineSeg / linesSegs.get(iter).length();
			double xOffset = ((double) w.getTerminus().x - (double) w.getOrigin().x) * percentage12 / 100.0;
			double yOffset = ((double) w.getTerminus().y - (double) w.getOrigin().y) * percentage12 / 100.0;
			newTargetAnchorInAbsolute = RhpGeometryFactory.eINSTANCE.createPoint();
			newTargetAnchorInAbsolute.setX(w.getOrigin().x + xOffset);
			newTargetAnchorInAbsolute.setY(w.getOrigin().y + yOffset);

			org.eclipse.draw2d.geometry.Point ptResult = new org.eclipse.draw2d.geometry.Point();
			KeyPoint toto = KeyPoint.ORIGIN;
			w.pointOn((long) needToCrossOnThisLineSeg, toto, ptResult);

			// double tmpLength = 0;
			// Iterator<LineSeg> iter = linesSegs.iterator();
			//
			// while (tmpLength < wantedLength && iter.hasNext()) {
			// LineSeg current = iter.next();
			// tmpLength += current.length();
			// }
			//
			// int segIndex = -1;
			// for (int i = 0; i < cumulatedLength.size(); i++) {
			// if (wantedLength > cumulatedLength.get(i)) {
			// segIndex = i - 1;
			// }
			// }
			// double requiredLengthOnThisSeg = wantedLength - cumulatedLength.get(segIndex);
			int j = 0;
			j++;
			Connector c = null;
			// c.
		}

		final RhapsodyShape sourceShape = RhapsodyShapeOperations.createRhapsodyShape(sourceGraphicalObject);
		final RhapsodyShape targetShape = RhapsodyShapeOperations.createRhapsodyShape(targetGraphicalObject);


		final Point rpySourceAnchor = RhpGeometryFactory.eINSTANCE.createPoint();
		rpySourceAnchor.setX(Double.valueOf(rpySourceAnchorAsString.get(0)));
		rpySourceAnchor.setY(Double.valueOf(rpySourceAnchorAsString.get(1)));
		final Point rpySourceAnchorInAbsolute = sourceShape.getTransform().multiply(rpySourceAnchor);


		final Point rpyTargetAnchor = RhpGeometryFactory.eINSTANCE.createPoint();
		rpyTargetAnchor.setX(Double.valueOf(rpyTargetAnchorAsString.get(0)));
		rpyTargetAnchor.setY(Double.valueOf(rpyTargetAnchorAsString.get(1)));
		final Point rpyTargetAnchorInAbsolute;
		if (newTargetAnchorInAbsolute == null) {
			rpyTargetAnchorInAbsolute = targetShape.getTransform().multiply(rpyTargetAnchor);
		} else {
			rpyTargetAnchorInAbsolute = newTargetAnchorInAbsolute;
		}

		// 2. determine bendpoints in absolute location
		final List<String> rhapsodyBendpointsAsString = association.getM_arrow();
		final List<Point> rhapsodyBendpointsInAbsolute = new ArrayList<Point>();
		if (rhapsodyBendpointsAsString.size() > 0) {
			for (int i = 1; i < Integer.valueOf(rhapsodyBendpointsAsString.get(0)) * 2; i = i + 2) {
				Point newPoint = RhpGeometryFactory.eINSTANCE.createPoint();
				newPoint.setX(Double.valueOf(rhapsodyBendpointsAsString.get(i)));
				newPoint.setY(Double.valueOf(rhapsodyBendpointsAsString.get(i + 1)));
				rhapsodyBendpointsInAbsolute.add(newPoint);
			}
		}


		// 3. here we get the source anchor, the target anchor and the bendpoints in absolute location
		// it is here we could do some adjustment to fix round errors
		// TODO : fix round errors!?
		// /!\ fixing error could make problems for link linked to link ?
		// bendpoint could be not in the good location, if we add/remove an offset to the compartemnt contents!



		// 4. we can now determine source anchor, target anchor and bendpoints
		final Point sourceAnchorInRelative = RhpGeometryFactory.eINSTANCE.createPoint();
		sourceAnchorInRelative.setX(rpySourceAnchorInAbsolute.getX() - sourceShape.getAbsolutePosition().getX());
		sourceAnchorInRelative.setY(rpySourceAnchorInAbsolute.getY() - sourceShape.getAbsolutePosition().getY());

		final Point targetAnchorInRelative = RhpGeometryFactory.eINSTANCE.createPoint();
		targetAnchorInRelative.setX(rpyTargetAnchorInAbsolute.getX() - targetShape.getAbsolutePosition().getX());
		targetAnchorInRelative.setY(rpyTargetAnchorInAbsolute.getY() - targetShape.getAbsolutePosition().getY());

		final Point firstBendpoint = RhpGeometryFactory.eINSTANCE.createPoint();
		firstBendpoint.setX(rpySourceAnchorInAbsolute.getX());
		firstBendpoint.setY(rpySourceAnchorInAbsolute.getY());

		final Point lastBendpoint = RhpGeometryFactory.eINSTANCE.createPoint();
		lastBendpoint.setX(rpyTargetAnchorInAbsolute.getX());
		lastBendpoint.setY(rpyTargetAnchorInAbsolute.getY());


		// we create the bendpoints list
		List<RelativeBendpoint> gmfBendpoints = new ArrayList<RelativeBendpoint>();
		// source bendpoints
		gmfBendpoints.add(new RelativeBendpoint(firstBendpoint.getIntX(), firstBendpoint.getIntY(), MAGIC_NUMBER_FOR_ABSOLUTE_BENDPOINTS, MAGIC_NUMBER_FOR_ABSOLUTE_BENDPOINTS));

		// intermediate bendpoints
		for (Point current : rhapsodyBendpointsInAbsolute) {
			gmfBendpoints.add(new RelativeBendpoint(current.getIntX(), current.getIntY(), MAGIC_NUMBER_FOR_ABSOLUTE_BENDPOINTS, MAGIC_NUMBER_FOR_ABSOLUTE_BENDPOINTS));
		}

		// last bendpoints
		gmfBendpoints.add(new RelativeBendpoint(lastBendpoint.getIntX(), lastBendpoint.getIntY(), MAGIC_NUMBER_FOR_ABSOLUTE_BENDPOINTS, MAGIC_NUMBER_FOR_ABSOLUTE_BENDPOINTS));

		// we register the bendpoints into the connector
		RelativeBendpoints bendpoints12 = NotationFactory.eINSTANCE.createRelativeBendpoints();
		bendpoints12.setPoints(gmfBendpoints);
		result.setBendpoints(bendpoints12);

		IdentityAnchor sourceAnchor = NotationFactory.eINSTANCE.createIdentityAnchor();
		sourceAnchor.setId(getAnchorFromAbsolutePosition(sourceShape, sourceAnchorInRelative));

		IdentityAnchor targetAnchor = NotationFactory.eINSTANCE.createIdentityAnchor();
		targetAnchor.setId(getAnchorFromAbsolutePosition(targetShape, targetAnchorInRelative));

		result.setSourceAnchor(sourceAnchor);
		result.setTargetAnchor(targetAnchor);
	}

	protected String getAnchorFromAbsolutePosition(RhapsodyShape shape, Point point) {
		float newxRatio = 0;// = new Float(xPort) / new Float(shape.getWidth());
		float newyRatio = 0;// = new Float(yPort) / new Float(shape.getHeight());
		newxRatio = new Float(point.getX()) / new Float(shape.getWidth());
		newyRatio = new Float(point.getY()) / new Float(shape.getHeight());
		if (newxRatio > 1) {
			newxRatio = 1;
		}
		if (newyRatio > 1) {
			newyRatio = 1;
		}

		String id = "(" + newxRatio + "," + newyRatio + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return id;
	}

	@Deprecated
	protected String getAnchorFromAbsolutePosition(RhapsodyShape shape, List<String> port) {
		// RhapsodyShape shape = RhapsodyShapeOperations.createRhapsodyShape(element);
		Point point = RhpGeometryFactory.eINSTANCE.createPoint();
		point.setX(Double.valueOf(port.get(0)));
		point.setY(Double.valueOf(port.get(1)));
		Point res = shape.getTransform().multiply(point);
		res.setX(res.getX() - shape.getAbsolutePosition().getX());
		res.setY(res.getY() - shape.getAbsolutePosition().getY());

		double[] topLeft = new double[] { shape.getParentRelativePosition().getX(), shape.getParentRelativePosition().getY() };
		double[] topRight = new double[] { shape.getParentRelativePosition().getX() + (double) shape.getWidth(), shape.getParentRelativePosition().getY() };
		double[] bottomLeft = new double[] { shape.getParentRelativePosition().getX(), shape.getParentRelativePosition().getY() + (double) shape.getHeight() };

		double xPort = Double.parseDouble(port.get(0));
		if (xPort < topLeft[X_INDEX]) {
			xPort = topLeft[X_INDEX];
		}
		if (xPort > topRight[X_INDEX]) {
			xPort = topRight[X_INDEX];
		}

		double yPort = Double.parseDouble(port.get(1));
		if (yPort < topLeft[Y_INDEX]) {
			yPort = topLeft[Y_INDEX];
		}
		if (yPort > bottomLeft[Y_INDEX]) {
			yPort = bottomLeft[Y_INDEX];
		}

		float newxRatio = new Float(xPort) / new Float(shape.getWidth());
		float newyRatio = new Float(yPort) / new Float(shape.getHeight());
		newxRatio = new Float(res.getX()) / new Float(shape.getWidth());
		newyRatio = new Float(res.getY()) / new Float(shape.getHeight());
		if (newxRatio > 1) {
			newxRatio = 1;
		}
		if (newyRatio > 1) {
			newyRatio = 1;
		}

		String id = "(" + newxRatio + "," + newyRatio + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return id;
	}

	@Operation(kind = Kind.HELPER)
	public String getAnchorId(List<String> polygon, List<String> transform, List<String> port) {

		// int[] topLeft = new int[] { Integer.parseInt(polygon.get(1)), Integer.parseInt(polygon.get(2)) };

		int[] topLeft = new int[] { Integer.parseInt(polygon.get(M_POLYGON__RECTANGLE_TOP_LEFT_CORNER_X_INDEX)), Integer.parseInt(polygon.get(M_POLYGON__RECTANGLE_TOP_LEFT_CORNER_Y_INDEX)) };
		int[] topRight = new int[] { Integer.parseInt(polygon.get(M_POLYGON__RECTANGLE_TOP_RIGHT_CORNER_X_INDEX)), Integer.parseInt(polygon.get(M_POLYGON__RECTANGLE_TOP_RIGHT_CORNER_Y_INDEX)) };
		int[] bottomLeft = new int[] { Integer.parseInt(polygon.get(M_POLYGON__RECTANGLE_BOTTOM_LEFT_CORNER_X_INDEX)), Integer.parseInt(polygon.get(M_POLYGON__RECTANGLE_BOTTOM_LEFT_CORNER_Y_INDEX)) };

		int xPort = Integer.parseInt(port.get(0));
		if (xPort < topLeft[X_INDEX]) {
			xPort = topLeft[X_INDEX];
		}
		if (xPort > topRight[X_INDEX]) {
			xPort = topRight[X_INDEX];
		}

		int yPort = Integer.parseInt(port.get(1));
		if (yPort < topLeft[Y_INDEX]) {
			yPort = topLeft[Y_INDEX];
		}
		if (yPort > bottomLeft[Y_INDEX]) {
			yPort = bottomLeft[Y_INDEX];
		}

		float newxRatio = new Float(xPort) / new Float(getRelativeWidth(topRight[0], topLeft[0]));
		float newyRatio = new Float(yPort) / new Float(getRelativeHeight(bottomLeft[1], topLeft[1]));

		if (newxRatio > 1) {
			newxRatio = 1;
		}
		if (newyRatio > 1) {
			newyRatio = 1;
		}

		String id = "(" + newxRatio + "," + newyRatio + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		return id;

	}

	public static int getRelativeHeight(int a, int b) {
		return (a - b);
	}

	public static int getRelativeWidth(int a, int b) {
		return (a - b);
	}

	/**
	 * 
	 * @param polygon
	 * @param transform
	 * @return
	 * 
	 * @deprecated since 0.7
	 */
	@Deprecated
	@Operation(kind = Kind.HELPER)
	public int getStateHeight(List<String> polygon, List<String> transform) {

		// State Partition (top left, top right, bottom right, bottom left) not
		// same for classes
		int[] topLeft = new int[] { Integer.parseInt(polygon.get(1)), Integer.parseInt(polygon.get(2)) };
		int[] topRight = new int[] { Integer.parseInt(polygon.get(3)), Integer.parseInt(polygon.get(4)) };
		int[] bottomRight = new int[] { Integer.parseInt(polygon.get(5)), Integer.parseInt(polygon.get(6)) };
		int[] bottomLeft = new int[] { Integer.parseInt(polygon.get(7)), Integer.parseInt(polygon.get(8)) };
		float xRatio = Float.parseFloat(transform.get(0));
		float yRatio = Float.parseFloat(transform.get(3));
		return Math.round(yRatio * (bottomLeft[1] - topLeft[1]));
	}

	/**
	 * 
	 * @param polygon
	 * @param transform
	 * @return
	 * 
	 * @deprecated since 0.7
	 */
	@Deprecated
	@Operation(kind = Kind.HELPER)
	public int getStateWidth(List<String> polygon, List<String> transform) {
		int[] topLeft = new int[] { Integer.parseInt(polygon.get(1)), Integer.parseInt(polygon.get(2)) };
		int[] topRight = new int[] { Integer.parseInt(polygon.get(3)), Integer.parseInt(polygon.get(4)) };
		int[] bottomRight = new int[] { Integer.parseInt(polygon.get(5)), Integer.parseInt(polygon.get(6)) };
		int[] bottomLeft = new int[] { Integer.parseInt(polygon.get(7)), Integer.parseInt(polygon.get(8)) };
		float xRatio = Float.parseFloat(transform.get(0));
		float yRatio = Float.parseFloat(transform.get(3));
		return Math.round(xRatio * (topRight[0] - topLeft[0]));
	}

	/**
	 * 
	 * @param polygon
	 * @param transform
	 * @return
	 * 
	 * @deprecated since 0.7
	 */
	@Deprecated
	@Operation(kind = Kind.HELPER)
	public int getClassHeight(List<String> polygon, List<String> transform) {

		// State Partition (top left, top right, bottom right, bottom left) not
		// same for classes
		int[] topLeft = new int[] { Integer.parseInt(polygon.get(1)), Integer.parseInt(polygon.get(2)) };
		int[] bottomLeft = new int[] { Integer.parseInt(polygon.get(3)), Integer.parseInt(polygon.get(4)) };
		int[] bottomRight = new int[] { Integer.parseInt(polygon.get(5)), Integer.parseInt(polygon.get(6)) };
		int[] topRight = new int[] { Integer.parseInt(polygon.get(7)), Integer.parseInt(polygon.get(8)) };
		float xRatio = Float.parseFloat(transform.get(0));
		float yRatio = Float.parseFloat(transform.get(3));
		return Math.round(yRatio * (bottomLeft[1] - topLeft[1]));
	}

	@Operation(kind = Kind.HELPER)
	public int getClassWidth(List<String> polygon, List<String> transform) {
		int[] topLeft = new int[] { Integer.parseInt(polygon.get(1)), Integer.parseInt(polygon.get(2)) };
		int[] bottomLeft = new int[] { Integer.parseInt(polygon.get(3)), Integer.parseInt(polygon.get(4)) };
		int[] bottomRight = new int[] { Integer.parseInt(polygon.get(5)), Integer.parseInt(polygon.get(6)) };
		int[] topRight = new int[] { Integer.parseInt(polygon.get(7)), Integer.parseInt(polygon.get(8)) };
		float xRatio = Float.parseFloat(transform.get(0));
		float yRatio = Float.parseFloat(transform.get(3));
		return Math.round(xRatio * (topRight[0] - topLeft[0]));
	}


	/**
	 * 
	 * @param m_polygon
	 *            the field polygon
	 * @param m_transform
	 *            the field transform
	 * @return the width of the object
	 * @deprecated since 0.7. use others method instead
	 */
	@Deprecated
	public int getWidth(List<String> m_polygon, List<String> m_transform) {
		int[] topLeft = new int[] { Integer.parseInt(m_polygon.get(1)), Integer.parseInt(m_polygon.get(2)) };
		// int[] bottomLeft = new int[] { Integer.parseInt(polygon.get(3)), Integer.parseInt(polygon.get(4)) };
		// int[] bottomRight = new int[] { Integer.parseInt(polygon.get(5)), Integer.parseInt(polygon.get(6)) };
		int[] topRight = new int[] { Integer.parseInt(m_polygon.get(7)), Integer.parseInt(m_polygon.get(8)) };
		float xRatio = Float.parseFloat(m_transform.get(0));
		// float yRatio = Float.parseFloat(transform.get(3));
		return Math.round(xRatio * (topRight[0] - topLeft[0]));
	}

	/**
	 * 
	 * @param polygon
	 *            the field polygon
	 * @param transform
	 *            the field transform
	 * @return the height of the object
	 * @deprecated since 0.7. use others method instead
	 */
	@Deprecated
	public int getHeight(List<String> polygon, List<String> transform) {
		int[] topLeft = new int[] { Integer.parseInt(polygon.get(1)), Integer.parseInt(polygon.get(2)) };
		int[] bottomLeft = new int[] { Integer.parseInt(polygon.get(3)), Integer.parseInt(polygon.get(4)) };
		// int[] bottomRight = new int[] { Integer.parseInt(polygon.get(5)), Integer.parseInt(polygon.get(6)) };
		// int[] topRight = new int[] { Integer.parseInt(polygon.get(7)), Integer.parseInt(polygon.get(8)) };
		// float xRatio = Float.parseFloat(transform.get(0));
		float yRatio = Float.parseFloat(transform.get(3));
		return Math.round(yRatio * (bottomLeft[1] - topLeft[1]));
	}


	/**
	 * 
	 * @param element
	 *            a graphical element
	 * @return
	 * 		the X ratio to apply on the object to get its width
	 */
	@Operation(kind = Kind.HELPER)
	public float get_X_Ratio(GraphElementsType element) {
		float result = 1;
		final List<String> mTransform = getTransformList(element);
		if (null != mTransform && mTransform.size() == M_TRANSFORM_SIZE) {
			result = Float.parseFloat(mTransform.get(M_TRANSFORM_X_RATIO_INDEX));
			final GraphElementsType parent = getParent(element);
			if (!(parent instanceof CGIDiagramFrame)) {
				result = result * get_X_Ratio(parent);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param element
	 *            a graphical element
	 * @return
	 * 		the X ratio to apply on the object to get its height
	 */
	@Operation(kind = Kind.HELPER)
	public float get_Y_Ratio(final GraphElementsType element) {
		float result = 1;
		final List<String> mTransform = getTransformList(element);
		if (null != mTransform && mTransform.size() == M_TRANSFORM_SIZE) {
			result = Float.parseFloat(mTransform.get(M_TRANSFORM_Y_RATIO_INDEX));
			final GraphElementsType parent = getParent(element);
			if (!(parent instanceof CGIDiagramFrame)) {
				result = result * get_Y_Ratio(parent);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param element
	 *            a graphical element
	 * @return
	 * 		the value of the m_pParent field if it exits for the given object or <code>null</code> in other case
	 */
	private final GraphElementsType getParent(final GraphElementsType element) {
		final EStructuralFeature paretnFeature = element.eClass().getEStructuralFeature("m_pParent"); //$NON-NLS-1$
		if (null != paretnFeature) {
			Object value = element.eGet(paretnFeature);
			if (value instanceof GraphElementsType) {
				return (GraphElementsType) value;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param element
	 *            a graphical element
	 * @return
	 * 		the value of the m_Transform field if it exits for the given object or <code>null</code> in other case
	 */
	@SuppressWarnings("unchecked")
	protected final List<String> getTransformList(final GraphElementsType element) {
		List<String> returnedValues = new ArrayList<String>();
		final EStructuralFeature mTransformFeature = element.eClass().getEStructuralFeature(M_TRANSFORM);
		if (null != mTransformFeature) {
			final Object mTransformValue = element.eGet(mTransformFeature);
			if (mTransformValue instanceof List<?>) {
				returnedValues.addAll((List<String>) mTransformValue);
			}
		}

		// We can consider number in e as 0;
		List<String> toReturn = new ArrayList<String>();
		if (returnedValues.size() != 6) {
			for (int i = 0; i < returnedValues.size(); i++) {
				String tmp = returnedValues.get(i);
				if (tmp.startsWith("e")) {
					continue;
				}
				if (!tmp.startsWith("e") && returnedValues.size() > (i + 1)) {
					String tmp2 = returnedValues.get(i + 1);
					if (tmp2.startsWith("e")) {
						tmp += tmp2;
					}
				}
				toReturn.add(tmp);
			}
			returnedValues = toReturn;
		}
		for (int i = 0; i < returnedValues.size(); i++) {
			String tmp = returnedValues.get(i);
			if (tmp.contains("e-")) {
				returnedValues.set(i, "0");
			}
		}

		return returnedValues;
	}

	/**
	 * 
	 * @param element
	 *            a graphical element
	 * @return
	 * 		the value of the m_Polygon field if it exits for the given object or <code>null</code> in other case
	 */
	@SuppressWarnings("unchecked")
	protected final List<String> getPolygonList(GraphElementsType element) {
		final EStructuralFeature mPolygonFeature = element.eClass().getEStructuralFeature(M_POLYGON);
		if (null != mPolygonFeature) {
			final Object mPolygonValue = element.eGet(mPolygonFeature);
			if (mPolygonValue instanceof List<?>) {
				return (List<String>) mPolygonValue;
			}
		}
		final EStructuralFeature mPositionlygonFeature = element.eClass().getEStructuralFeature("m_position");
		if (null != mPolygonFeature) {
			final Object mPolygonValue = element.eGet(mPolygonFeature);
			if (mPolygonValue instanceof List<?>) {
				return (List<String>) mPolygonValue;
			}
		}
		return null;
	}

	@Operation(kind = Kind.HELPER)
	public int getRectangleWidth(final GraphElementsType element) {
		RhapsodyShape shape = RhapsodyShapeOperations.createRhapsodyShape(element);
		return shape.getWidth();
	}

	@Operation(kind = Kind.HELPER)
	public int getRectangleHeight(final GraphElementsType element) {
		RhapsodyShape shape = RhapsodyShapeOperations.createRhapsodyShape(element);
		return shape.getHeight();
	}

	@Operation(kind = Kind.HELPER)
	public int getX(final GraphElementsType element) {
		RhapsodyShape shape = RhapsodyShapeOperations.createRhapsodyShape(element);
		return shape.getParentRelativePosition().getIntX();
	}


	@Operation(kind = Kind.HELPER)
	public int getY(final GraphElementsType element) {
		RhapsodyShape shape = RhapsodyShapeOperations.createRhapsodyShape(element);
		return shape.getParentRelativePosition().getIntY();
	}

	// TODO : move me into an upper plugin
	/**
	 * 
	 * @param aString
	 *            a string
	 * @return the parsed result of the string or {@link Integer#MAX_VALUE} if a problem occurred
	 */
	protected final int stringToInteger(final String aString) {
		int result = Integer.MAX_VALUE;
		if (aString.contains(".")) { //$NON-NLS-1$
			result = Float.valueOf(Float.parseFloat(aString)).intValue();
		} else {
			result = Integer.parseInt(aString);
		}
		return result;
	}
}
