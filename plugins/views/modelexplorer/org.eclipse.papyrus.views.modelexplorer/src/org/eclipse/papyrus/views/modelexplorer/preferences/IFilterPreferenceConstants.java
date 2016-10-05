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

package org.eclipse.papyrus.views.modelexplorer.preferences;

/**
 * Interface to define preference constants for the filter field.
 */
public interface IFilterPreferenceConstants {

	/** The preference if the filter is in live validation. */
	public static final String PREF_FILTER_LIVE_VALIDATION = "liveValidation"; //$NON-NLS-1$

	/** The preference of the delay of live validation. */
	public static final String PREF_FILTER_VALIDATION_DELAY = "validateDelay"; //$NON-NLS-1$

	/** the default value for validation delay. */
	public static final String DEFAULT_VALIDATION_DELAY_VALUE = "600"; //$NON-NLS-1$

	/** the default value for the use of live validation in filter. */
	public static final String DEFAULT_FILTER_LIVE_VALIDATION_VALUE = "true"; //$NON-NLS-1$

}
