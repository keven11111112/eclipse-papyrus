/******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, Artal
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors: 
 *     Dmitri Stadnik (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.wizards;

import org.eclipse.papyrus.gmf.internal.common.ui.ResourceLocationProvider;

/**
 * Wizard operation mode property.
 * Supports the following lifecycle: user creates it, possibly changes mode
 * a number of times and detects reconcile mode. After this property should
 * not be accessed or modified.
 * 
 * @author dstadnik
 */
public final class WizardOperationMode {

	/**
	 * Wizard will detect in which mode it should operate.
	 */
	public static final String DETECT = "detect"; //$NON-NLS-1$

	/**
	 * Wizard will create new model.
	 */
	public static final String CREATE = "create"; //$NON-NLS-1$

	/**
	 * Wizard will reconcile changes with existing model.
	 */
	public static final String RECONCILE = "reconcile"; //$NON-NLS-1$

	private String fileExtension;

	private String mode;

	public WizardOperationMode(String fileExtension, String mode) {
		assert fileExtension != null;
		assertCorrectMode(mode);
		this.fileExtension = fileExtension;
		this.mode = mode;
	}

	public void setMode(String mode) {
		assertCorrectMode(mode);
		if (mode == null) {
			throw new IllegalStateException("Operation mode already detected"); //$NON-NLS-1$
		}
		this.mode = mode;
	}

	public boolean detectReconcile(ResourceLocationProvider rloc) {
		if (mode == null) {
			throw new IllegalStateException("Operation mode could be detected only once"); //$NON-NLS-1$
		}
		boolean reconcileMode;
		if (DETECT.equals(mode)) {
			// enabled when gmfgraph model selected
			reconcileMode = !rloc.getSelectedURIs(fileExtension, true).isEmpty();
		} else if (CREATE.equals(mode)) {
			reconcileMode = false;
		} else if (RECONCILE.equals(mode)) {
			reconcileMode = true;
		} else {
			throw new IllegalStateException("Illegal mode: " + mode); //$NON-NLS-1$
		}
		mode = null; // disable mode update
		return reconcileMode;
	}

	public static void assertCorrectMode(String mode) {
		assert DETECT.equals(mode) || CREATE.equals(mode) || RECONCILE.equals(mode);
	}
}
