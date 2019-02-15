/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Modification to match IValidator
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.infra.widgets.messages.Messages;

/**
 * Validator for the Real
 */
public class RealValidator extends AbstractValidator {

	private final boolean allowNull;

	public RealValidator() {
		this(false);
	}

	/**
	 * Create a new {@link RealValidator}. If <code>allowNull</code>
	 * is true, null and empty strings will be considered valid values (These
	 * null/empty values can be used e.g. to reset or unset a real value)
	 *
	 * @since 3.5
	 */
	public RealValidator(boolean allowNull) {
		this.allowNull = allowNull;
	}

	/**
	 *
	 * @param newValue
	 * @return {@link Status#OK_STATUS} if the newValue is valid and {@link IStatus#ERROR} when newValue is
	 *         invalid
	 */
	@Override
	public IStatus validate(Object newValue) {
		if (newValue instanceof Double) {
			return Status.OK_STATUS;
		}

		if (newValue == null && allowNull) {
			return Status.OK_STATUS;
		}

		if (newValue instanceof String) {
			String strValue = (String) newValue;
			if (allowNull && strValue.isEmpty()) {
				return Status.OK_STATUS;
			}
			try {
				Double.parseDouble(strValue);
				return Status.OK_STATUS;
			} catch (NumberFormatException ex) {
				return error(Messages.RealInputValidator_NotaRealMessage);
			}
		}

		return error(Messages.RealInputValidator_NotaRealMessage);
	}


}
