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
package org.eclipse.papyrus.requirements.sysml.matrix.satisfiedBy.config.cellmanager;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.infra.nattable.manager.cell.AbstractCellManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.requirements.sysml.matrix.satisfiedBy.config.Activator;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

public class SameStereotypeCellManager extends AbstractCellManager {
	public static final String CELL_MANAGER_ID = Activator.PLUGIN_ID + ".SameStereotypeCellManager";

	@Override
	public boolean handles(Object columnElement, Object rowElement) {
		Object column = AxisUtils.getRepresentedElement(columnElement);
		Object row = AxisUtils.getRepresentedElement(rowElement);
		if (column instanceof Element && row instanceof Element) {
			Element colUMLElement = (Element) column;
			Element rowUMLElement = (Element) row;
			EList <Stereotype> stereotypesInRowUMLElement = rowUMLElement.getAppliedStereotypes();
			for (Stereotype s: colUMLElement.getAppliedStereotypes()){
				if (stereotypesInRowUMLElement.contains(s)){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	protected Object doGetValue(Object columnElement, Object rowElement, INattableModelManager tableManager) {
		return "N/A";//"No relationship";
	}

}
