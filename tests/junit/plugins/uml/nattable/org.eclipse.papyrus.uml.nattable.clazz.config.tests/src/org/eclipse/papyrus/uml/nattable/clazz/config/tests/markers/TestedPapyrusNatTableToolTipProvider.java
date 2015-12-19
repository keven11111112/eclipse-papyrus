/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
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

package org.eclipse.papyrus.uml.nattable.clazz.config.tests.markers;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.papyrus.infra.nattable.provider.PapyrusNatTableToolTipProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Event;

/**
 * @author VL222926
 *
 */
public class TestedPapyrusNatTableToolTipProvider extends PapyrusNatTableToolTipProvider {

	/**
	 * Constructor.
	 *
	 * @param natTable
	 * @param tooltipRegions
	 */
	public TestedPapyrusNatTableToolTipProvider(NatTable natTable, String... tooltipRegions) {
		super(natTable, tooltipRegions);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.provider.PapyrusNatTableToolTipProvider#getCell(org.eclipse.swt.widgets.Event)
	 *
	 * @param event
	 * @return
	 */
	@Override
	public ILayerCell getCell(Event event) {
		return super.getCell(event);
	}
	
	/**
	 * @see org.eclipse.papyrus.infra.nattable.provider.PapyrusNatTableToolTipProvider#getText(org.eclipse.swt.widgets.Event)
	 *
	 * @param event
	 * @return
	 */
	@Override
	public String getText(Event event) {
		return super.getText(event);
	}
	
	/**
	 * @see org.eclipse.papyrus.infra.nattable.provider.PapyrusNatTableToolTipProvider#shouldCreateToolTip(org.eclipse.swt.widgets.Event)
	 *
	 * @param event
	 * @return
	 */
	@Override
	public boolean shouldCreateToolTip(Event event) {
		return super.shouldCreateToolTip(event);
	}
	/**
	 * @see org.eclipse.papyrus.infra.nattable.provider.PapyrusNatTableToolTipProvider#getImage(org.eclipse.swt.widgets.Event)
	 *
	 * @param event
	 * @return
	 */
	@Override
	public Image getImage(Event event) {
		return super.getImage(event);
	}
}
