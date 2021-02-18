/******************************************************************************
 * Copyright (c) 2005, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.genmodel;


import org.eclipse.papyrus.gmf.mappings.AuditContainer;
import org.eclipse.papyrus.gmf.mappings.CanvasMapping;
import org.eclipse.papyrus.gmf.mappings.LinkMapping;
import org.eclipse.papyrus.gmf.mappings.Mapping;
import org.eclipse.papyrus.gmf.mappings.MetricContainer;
import org.eclipse.papyrus.gmf.mappings.TopNodeReference;

/**
 * Encapsulates iteration over diagram definition.
 * @author artem
 */
public abstract class MappingTransformer {

	public void transform(Mapping m) {
		process(m.getDiagram());
		for (TopNodeReference element : m.getNodes()) {
			process(element);
		}
		for (LinkMapping element : m.getLinks()) {
			process(element);
		}
		
		process(m.getMetrics());		
		process(m.getAudits());
		complete();
	}

	protected abstract void process(CanvasMapping cme);
	protected abstract void process(TopNodeReference topNode);
	protected abstract void process(LinkMapping lme);
	protected abstract void process(AuditContainer audits);
	protected abstract void process(MetricContainer metrics);

	// chances for some late after-hours work, no-op by default
	protected void complete() {
	}
}
