/*****************************************************************************
 * Copyright (c) 2016 CEA LIST, ALL4TEC and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.infra.widgets;

import org.eclipse.jface.viewers.DoubleClickEvent;

/**
 * An interface to add the possibility to fire programmatically double click and element such as viewer.
 */
public interface IFireDoubleClick {

	/**
	 * fire the double click.
	 * 
	 * @param event
	 *            The Doubleclick event.
	 */
	public void fireDoubleClick(DoubleClickEvent event);

}
