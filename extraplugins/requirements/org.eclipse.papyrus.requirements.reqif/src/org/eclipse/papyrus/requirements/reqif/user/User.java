/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.requirements.reqif.user;

public interface User {

	public String getID();

	public boolean canCreateProfile();

	public boolean canChooseProfile();

	public boolean canChooseTypeToImportInProfile();

	public String getDefaultProfileName();

	public boolean canUseEnumerationPattern();

	public boolean canImportModel();
}
