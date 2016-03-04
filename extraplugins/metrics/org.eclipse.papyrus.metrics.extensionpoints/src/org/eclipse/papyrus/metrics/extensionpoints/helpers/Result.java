/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Mauricio Alferez (mauricio.alferez@cea.fr) CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.metrics.extensionpoints.helpers;

import org.eclipse.uml2.uml.Element;
import org.omg.smm.Measure;
import org.omg.smm.Scope;

public class Result {

	protected Measure measure;
	protected Object value;
	protected Element measurand;
	protected Scope scope;

	public Scope getScope() {
		return scope;
	}

	public void setScope(Scope scope) {
		this.scope = scope;
	}

	public Element getMeasurand() {
		return measurand;
	}

	public void setMeasurand(Element measurand) {
		this.measurand = measurand;
	}

	public Measure getMeasure() {
		return measure;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Result(Measure measure, Element measurand, Object value) {
		this.measure = measure;
		this.value = value;
		this.measurand = measurand;
		this.scope = measure.getScope();
	}

}
