/*****************************************************************************
 * Copyright (c) 2009, 2014 LIFL, CEA LIST, and others. 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 392301
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.swt.graphics.Image;


/**
 * A fake page for testing purpose
 * 
 * @author dumoulin
 */
public class FakePageModel implements IPageModel {

	String title;

	static int count = 0;

	public FakePageModel() {
		title = "noname" + count++;
	}

	/**
	 * @param title
	 */
	public FakePageModel(String title) {
		this.title = title;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getRawModel() {
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getTabIcon() {
		
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getTabTitle() {
		
		return null;
	}

	public void dispose() {
		// Pass
	}
}
