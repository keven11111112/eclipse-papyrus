/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
package org.eclipse.papyrus.infra.gmfdiag.common.figure.edge;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.RelativeBendpoint;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;

/**
 * 
 * @author VL222926
 * 
 */
public class CustomRelativeBendpoint extends RelativeBendpoint {

	/**
	 * value to follow start/source point
	 */
	public static final float FOLLOW_SOURCE = 0.0f;

	/**
	 * value to follow end/target point
	 */
	public static final float FOLLOW_TARGET = 1.0f;

	/**
	 * the weight to apply on x value for a relative bendpoint
	 */
	private float xWeight;

	/**
	 * the weight to apply on y value for a relative bendpoint
	 */
	private float yWeight;

	/**
	 * the dimension used to save the relative bendpoint
	 */
	private Dimension d1, d2;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param conn
	 *        the connection owning the bendpoints
	 */
	public CustomRelativeBendpoint(final Connection conn) {
		super(conn);
	}

	/**
	 * 
	 * @param xWeight
	 *        the weight to apply on the x value
	 * @param yWeight
	 *        the weight to apply on the y value
	 */
	public void setWeight(final float xWeight, final float yWeight) {
		this.xWeight = xWeight;
		this.yWeight = yWeight;
	}

	/**
	 * 
	 * @see org.eclipse.draw2d.RelativeBendpoint#setWeight(float)
	 * 
	 * @param w
	 */
	@Override
	public void setWeight(float w) {
		super.setWeight(w);
		this.xWeight = w;
		this.yWeight = w;
	}

	/**
	 * 
	 * @see org.eclipse.draw2d.RelativeBendpoint#setRelativeDimensions(org.eclipse.draw2d.geometry.Dimension, org.eclipse.draw2d.geometry.Dimension)
	 * 
	 * @param dim1
	 * @param dim2
	 */
	@Override
	public void setRelativeDimensions(Dimension dim1, Dimension dim2) {
		super.setRelativeDimensions(this.d1, this.d2);
		this.d1 = dim1;
		this.d2 = dim2;
	}

	/**
	 * 
	 * @see org.eclipse.draw2d.RelativeBendpoint#getLocation()
	 * 
	 * @return
	 */
	@Override
	public Point getLocation() {
		PrecisionPoint a1 = new PrecisionPoint(getConnection().getSourceAnchor().getReferencePoint());
		PrecisionPoint a2 = new PrecisionPoint(getConnection().getTargetAnchor().getReferencePoint());

		getConnection().translateToRelative(a1);
		getConnection().translateToRelative(a2);

		return new PrecisionPoint((a1.preciseX() + this.d1.preciseWidth()) * (1.0 - this.xWeight) + this.xWeight * (a2.preciseX() + this.d2.preciseWidth()), (a1.preciseY() + this.d1.preciseHeight()) * (1.0 - this.yWeight) + this.yWeight * (a2.preciseY() + this.d2.preciseHeight()));
	}

	/**
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("relative location=["); //$NON-NLS-1$
		builder.append(this.d1.preciseWidth());
		builder.append(","); //$NON-NLS-1$
		builder.append(this.d1.preciseHeight());
		builder.append(","); //$NON-NLS-1$
		builder.append(this.d2.preciseWidth());
		builder.append(","); //$NON-NLS-1$
		builder.append(this.d2.preciseHeight());
		builder.append("]"); //$NON-NLS-1$
		builder.append("  real location="); //$NON-NLS-1$
		builder.append(getLocation());
		return builder.toString();
	}

}
