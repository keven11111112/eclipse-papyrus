/******************************************************************************
 * Copyright (c) 2007, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.naming;

import org.eclipse.papyrus.gmf.codegen.gmfgen.FigureViewmap;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenLabel;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenLink;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenNode;
import org.eclipse.papyrus.gmf.codegen.gmfgen.InnerClassViewmap;
import org.eclipse.papyrus.gmf.codegen.gmfgen.ParentAssignedViewmap;
import org.eclipse.papyrus.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.papyrus.gmf.internal.common.NamesDispenser;

/**
 * Uses names from graphical definition elements if available.
 * 
 * @author dstadnik
 */
public class DesignGenNamingStrategy extends AbstractGenNamingStrategy {

	public DesignGenNamingStrategy(String suffix, NamesDispenser namesDispenser, GenNamingStrategy chainedNamingStrategy, GenNamingStrategy prefixNamingStrategy) {
		super(suffix, namesDispenser, chainedNamingStrategy, prefixNamingStrategy);
	}

	public String get(GenDiagram element) {
		String name = getDesignName(element.getViewmap());
		if (name != null) {
			return createClassName(name);
		}
		return super.get(element);
	}

	public String get(GenNode element) {
		String name = getDesignName(element.getViewmap());
		if (name != null) {
			return createClassName(name);
		}
		return super.get(element);
	}

	public String get(GenCompartment element) {
		String name = getDesignName(element.getViewmap());
		if (name != null) {
			return createClassName(getCompartmentHostPrefix(element) + name);
		}
		return super.get(element);
	}

	public String get(GenLink element) {
		String name = getDesignName(element.getViewmap());
		if (name != null) {
			return createClassName(name);
		}
		return super.get(element);
	}

	public String get(GenLabel element) {
		String name = getDesignName(element.getViewmap());
		if (name != null) {
			return createClassName(name);
		}
		return super.get(element);
	}

	/**
	 * Try to infer name from associated figure.
	 */
	protected String getDesignName(Viewmap viewmap) {
		if (viewmap == null) {
			return null;
		}
		String name = null;
		if (viewmap instanceof FigureViewmap) {
			name = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
		} else if (viewmap instanceof InnerClassViewmap) {
			name = ((InnerClassViewmap) viewmap).getClassName();
		} else if (viewmap instanceof ParentAssignedViewmap) {
			name = ((ParentAssignedViewmap) viewmap).getFigureQualifiedClassName();
		}
		if (name == null || name.length() == 0) {
			return null;
		}
		name = name.substring(name.lastIndexOf('.') + 1);
		if (name.endsWith("Figure") && name.length() > "Figure".length()) { //$NON-NLS-1$ //$NON-NLS-2$
			name = name.substring(0, name.length() - "Figure".length()); //$NON-NLS-1$
		}
		if (name.length() == 0) {
			return null;
		}
		if (name.length() < 2) {
			return name.toUpperCase();
		}
		return Character.toUpperCase(name.charAt(0)) + name.substring(1);
	}
}
