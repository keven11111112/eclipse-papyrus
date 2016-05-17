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
package org.eclipse.papyrus.requirements.sysml.matrix.derivedFrom.config.cellmanager;

import org.eclipse.papyrus.infra.nattable.manager.cell.AbstractCellManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.ITreeItemAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.requirements.sysml.matrix.common.Activator;
import org.eclipse.uml2.uml.Element;

public class DerivedFromMatrixPackageCellManager extends AbstractCellManager {
	public static final String CELL_MANAGER_ID = Activator.PLUGIN_ID
			+ ".cellmanager.DerivedFromMatrixPackageCellManager";

	@Override
	public boolean handles(Object columnElement, Object rowElement) {
		Object column = AxisUtils.getRepresentedElement(columnElement);
		Object row = AxisUtils.getRepresentedElement(rowElement);
		if (rowElement instanceof ITreeItemAxis) {
			ITreeItemAxis axis = (ITreeItemAxis) rowElement;
			AxisManagerRepresentation manager = axis.getManager();
			TableConfiguration conf = (TableConfiguration) manager.eContainer().eContainer();
			String type = conf.getType();
			if (!type.equals("DerivedFromMatrix")) {
				return false;
			}
		}

		if (column instanceof Element && row instanceof Element) {
			Element colUMLElement = (Element) column;
			Element rowUMLElement = (Element) row;
			if (colUMLElement instanceof org.eclipse.uml2.uml.Package
					|| rowUMLElement instanceof org.eclipse.uml2.uml.Package) {
				return true;
			}
		}

		return false;
	}

	@Override
	protected Object doGetValue(Object columnElement, Object rowElement, INattableModelManager tableManager) {
		return "N/A";// "Packages are just for grouping requirements but are
						// shown in the matrix for grouping requirements"
	}

}
