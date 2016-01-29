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

package org.eclipse.papyrus.infra.elementtypesconfigurations.utils;

import java.util.Comparator;

import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.papyrus.infra.elementtypesconfigurations.registries.ElementTypeSetConfigurationRegistry;


public class AdviceComparator implements Comparator<IEditHelperAdvice> {

	OrientedGraph<String> dependencies;

	public AdviceComparator() {
		this.dependencies = ElementTypeSetConfigurationRegistry.getInstance().getAdvicesDeps();
	}

	@Override
	public int compare(IEditHelperAdvice arg0, IEditHelperAdvice arg1) {
		String arg0Name = arg0.getClass().getName();
		String arg1Name = arg1.getClass().getName();
		if (dependencies.getEdges().containsKey(arg0Name)) {
			if (dependencies.getAllConnex(arg0Name).contains(arg1Name)) {
				return -1;
			}
		}
		if (dependencies.getEdges().containsKey(arg1Name)) {
			if (dependencies.getAllConnex(arg1Name).contains(arg0Name)) {
				return 1;
			}
		}
		return 0;
	}

}
