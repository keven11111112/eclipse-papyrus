/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.propertylifecycle.preferences.utils;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.propertylifecycle.PropertylifecycleFactory;
import org.eclipse.papyrus.propertylifecycle.StrategyElement;

/**
 * Convenience class used to create the custom model and its strategies
 * 
 */
public class AdvancedTabViewerUtils {

	/** The factory from which all the strategies are spawned */
	protected static PropertylifecycleFactory newModelFactory = PropertylifecycleFactory.eINSTANCE;

	/**
	 * Clone the selected strategy in the custom model
	 *
	 * @param selectedStrategy
	 *            The selected strategy
	 * @return
	 * 		The cloned strategy
	 */
	public static StrategyElement cloneStrategy(StrategyElement selectedStrategy) {
		StrategyElement clonedStrategy = EcoreUtil.copy(selectedStrategy);

		return clonedStrategy;
	}

}
