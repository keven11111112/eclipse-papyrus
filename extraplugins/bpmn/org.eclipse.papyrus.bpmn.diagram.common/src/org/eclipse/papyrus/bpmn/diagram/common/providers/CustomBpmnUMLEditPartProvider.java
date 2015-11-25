/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.bpmn.diagram.common.providers;

import org.eclipse.papyrus.uml.diagram.activity.providers.CustomUMLEditPartProvider;

public class CustomBpmnUMLEditPartProvider extends CustomUMLEditPartProvider{
	public CustomBpmnUMLEditPartProvider() {
		super();
		setFactory(new CustomBpmnUMLEditPartFactory());
		setAllowCaching(true);
	}
}
