/**
 * Copyright (c) 2014 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.dd.qvt;

import java.awt.Color;

import org.eclipse.papyrus.dd.dc.DCFactory;
import org.eclipse.papyrus.dd.dc.DCPackage;

/**
 * A utility library of black-box operations used in the umldi2dg QVTO
 * transformation
 */
public class DDUtilities {

	public DDUtilities() {
		super();
	}

	public Color createColor(String colorStr) {
		return (Color) DCFactory.eINSTANCE.createFromString(
				DCPackage.eINSTANCE.getColor(), colorStr);
	}

	public double getAngle(double x1, double y1, double x2, double y2) {
		double a = Math.atan2(y2-y1, x2-x1);
		return a * 180 / Math.PI;
	}

	public double sin(double angle) {
		return Math.sin(angle * Math.PI / 180);
	}

	public double cos(double angle) {
		return Math.cos(angle * Math.PI / 180);
	}

	public double tan(double angle) {
		return Math.tan(angle * Math.PI / 180);
	}

}
