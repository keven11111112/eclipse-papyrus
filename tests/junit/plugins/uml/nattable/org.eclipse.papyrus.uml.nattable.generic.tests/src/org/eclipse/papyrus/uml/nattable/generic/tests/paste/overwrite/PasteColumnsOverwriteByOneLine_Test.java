/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.selection.command.ClearAllSelectionsCommand;
import org.eclipse.nebula.widgets.nattable.selection.command.SelectColumnCommand;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;

/**
 * Test pastes overwrite all of selection with hidden categories when a single line is copied.
 */
public class PasteColumnsOverwriteByOneLine_Test extends AbstractPasteColumnsOverwriteTest {

	/**
	 * Constructor.
	 */
	public PasteColumnsOverwriteByOneLine_Test() {
		super();
	}

	/**
	 * Manage the selection with the shift key.
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.AbstractPasteOverwriteTest#manageSelection(org.eclipse.papyrus.infra.nattable.manager.table.TreeNattableModelManager)
	 */
	@Override
	public void manageSelection(final NattableModelManager manager) throws Exception {
		final NatTable natTable = (NatTable) manager.getAdapter(NatTable.class);
		natTable.doCommand(new ClearAllSelectionsCommand());
		manager.getBodyLayerStack().getSelectionLayer().doCommand(new SelectColumnCommand(manager.getBodyLayerStack().getSelectionLayer(), 1, 0, false, false));
		manager.getBodyLayerStack().getSelectionLayer().doCommand(new SelectColumnCommand(manager.getBodyLayerStack().getSelectionLayer(), 2, 0, true, false));
	}
}
