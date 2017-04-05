/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.uml.decoratormodel.internal.properties.constraints;


import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.uml.decoratormodel.properties.Activator;

public class ProfileApplicationsConstraintException extends CoreException {
	ProfileApplicationsConstraintException() {
		super(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "ProfileApplicationsConstraintException"));
	}
}
