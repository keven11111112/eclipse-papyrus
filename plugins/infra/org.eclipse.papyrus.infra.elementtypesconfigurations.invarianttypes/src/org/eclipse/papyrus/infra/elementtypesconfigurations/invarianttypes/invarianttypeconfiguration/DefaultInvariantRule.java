/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypes.invarianttypeconfiguration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantRuleConfiguration;

public class DefaultInvariantRule implements IInvariantRule<InvariantRuleConfiguration> {



	/**
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypes.invarianttypeconfiguration.IInvariantRule#approveRequest(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypes.invarianttypeconfiguration.IInvariantRule#init(org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantRuleConfiguration)
	 *
	 * @param invariantRuleConfiguration
	 */
	@Override
	public void init(InvariantRuleConfiguration invariantRuleConfiguration) {

	}

	/**
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypes.invarianttypeconfiguration.IInvariantRule#matches(org.eclipse.emf.ecore.EObject)
	 *
	 * @param eObject
	 * @return
	 */
	@Override
	public boolean matches(EObject eObject) {
		return true;
	}


}
