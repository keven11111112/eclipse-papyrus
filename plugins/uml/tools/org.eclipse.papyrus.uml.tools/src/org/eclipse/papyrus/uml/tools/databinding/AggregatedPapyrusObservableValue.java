/*****************************************************************************
 * Copyright (c) 2011, 2016 CEA LIST, Christian W. Damus, and others.
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
package org.eclipse.papyrus.uml.tools.databinding;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @deprecated Use the {@link org.eclipse.papyrus.infra.services.edit.ui.databinding.AggregatedPapyrusObservableValue} API, instead.
 */
@Deprecated
public class AggregatedPapyrusObservableValue extends org.eclipse.papyrus.infra.services.edit.ui.databinding.AggregatedPapyrusObservableValue {

	public AggregatedPapyrusObservableValue(EditingDomain domain, IObservable... observableValues) {
		super(domain, observableValues);
	}

}
