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

package org.eclipse.papyrus.umlrt.ui.handlers;

import org.eclipse.papyrus.views.modelexplorer.handler.CopyHandler;

/**
 * Specific copy handler for model explorer
 */
public class RTProtocolCopyHandler extends CopyHandler {


	// /**
	// * Construct copy command from the selection
	// *
	// * @param editingDomain
	// * @param selectedElements
	// * @return
	// */
	// public static Command buildCopyCommand(TransactionalEditingDomain editingDomain, Collection<EObject> selectedElements) {
	//// DefaultCopyCommand defaultCopyCommand = new DefaultCopyCommand(editingDomain, papyrusClipboard, selectedElements);
	//// List<IStrategy> allStrategies = PasteStrategyManager.getInstance().getAllStrategies();
	//// for (IStrategy iStrategy : allStrategies) {
	//// IPasteStrategy iPasteStrategy = (IPasteStrategy) iStrategy;
	//// iPasteStrategy.prepare(papyrusClipboard, selectedElements);
	//// }
	//// return defaultCopyCommand;
	// return super.buildCopyCommand(editingDomain, selectedElements, )
	// }
}
