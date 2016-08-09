/*****************************************************************************
 * Copyright (c) 2010, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 485220
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.databinding;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.ui.databinding.PapyrusObservableList;

/**
 * An ObservableList used to edit collections of EObjects through
 * Papyrus commands
 *
 * @author Camille Letavernier
 *
 */
public class GMFObservableList extends PapyrusObservableList {

	/**
	 *
	 * Constructor.
	 *
	 * @param wrappedList
	 *            The list to be edited when #commit() is called
	 * @param domain
	 *            The editing domain on which the commands will be executed
	 * @param source
	 *            The EObject from which the list will be retrieved
	 * @param feature
	 *            The feature from which the list will be retrieved
	 */
	public GMFObservableList(List<?> wrappedList, EditingDomain domain, EObject source, EStructuralFeature feature) {
		super(wrappedList, domain, source, feature, GMFtoEMFCommandWrapper::wrap);
	}
}
