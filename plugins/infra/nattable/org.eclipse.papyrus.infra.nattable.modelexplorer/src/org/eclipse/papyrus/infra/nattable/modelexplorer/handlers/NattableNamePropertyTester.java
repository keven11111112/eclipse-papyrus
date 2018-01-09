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
 *  Francois Le Fevre (CEA LIST) francois.le-fevre@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.modelexplorer.handlers;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableNamedElement;
import org.eclipse.papyrus.infra.ui.menu.NamePropertyTester;

public class NattableNamePropertyTester extends NamePropertyTester {

	protected boolean isNameChangeable(IStructuredSelection selection){
		boolean onlyWaitElement=true;
		if (!selection.isEmpty()) {
			Iterator<?> iter = selection.iterator();
			while (iter.hasNext()) {
				EObject object = EMFHelper.getEObject(iter.next());
				if ( !(object instanceof TableNamedElement)) {
					onlyWaitElement  =false;
					break;
				}
			}
		}
		return onlyWaitElement;
	}
}
