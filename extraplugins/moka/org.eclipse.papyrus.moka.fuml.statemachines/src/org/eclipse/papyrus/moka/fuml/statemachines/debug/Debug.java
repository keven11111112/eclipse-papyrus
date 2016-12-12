/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Jeremie Tatibouet (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.statemachines.debug;

import static org.eclipse.papyrus.moka.fuml.statemachines.Activator.logger;

public class Debug {
	
	public static void log(final String message){
		// Papyrus specific implementation. Relies on the logger
		// mechanism provided by Papyrus.
		logger.info(message);
	}
	
}
