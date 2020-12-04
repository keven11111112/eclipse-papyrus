/******************************************************************************
 * Copyright (c) 2008, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    bblajer - initial API and implementation
 *    AurÃ©lien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *******************************************************************************/
package org.eclipse.papyrus.gmf.internal.xpand;

import java.util.List;

/**
 * @author bblajer
 */
public interface StreamsHolder {
	public String getStreamContents(String slotName);

	public List<String> getSlotNames();
}
