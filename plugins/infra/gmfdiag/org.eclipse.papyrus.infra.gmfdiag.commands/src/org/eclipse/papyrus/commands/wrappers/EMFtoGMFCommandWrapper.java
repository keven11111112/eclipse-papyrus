/***************************************************************************
 * Copyright (c) 2007, 2014 Conselleria de Infraestructuras y Transporte, Generalitat de la Comunitat Valenciana, CEA, Christian W. Damus, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Mario Cervera Ubeda (Prodevelop)
 *    Christian W. Damus (CEA) - bug 430701
 *    Christian W. Damus - bug 485220
 *
 ******************************************************************************/
package org.eclipse.papyrus.commands.wrappers;

import org.eclipse.emf.common.command.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.commands.INonDirtying;

/**
 * A GMF Command that wraps an EMF command. Each method is redirected to the EMF one.
 * 
 * @deprecated Use the {@link org.eclipse.papyrus.infra.emf.gmf.command.EMFtoGMFCommandWrapper} API, instead.
 */
@Deprecated
public class EMFtoGMFCommandWrapper extends org.eclipse.papyrus.infra.emf.gmf.command.EMFtoGMFCommandWrapper {

	static {
		// Configure legacy compatibility
		setWrapperFunction(EMFtoGMFCommandWrapper::new);
		setNonDirtyingWrapperFunction(NonDirtying::new);
	}

	/**
	 * Constructor.
	 *
	 * @param emfCommand
	 *            the emf command
	 */
	public EMFtoGMFCommandWrapper(Command emfCommand) {
		super(emfCommand);
	}

	/**
	 * Wraps the given {@code command}, accounting for possible non-dirty state.
	 *
	 * @param command
	 *            a command to wrap
	 * @return the best wrapper for the {@code command}
	 */
	public static ICommand wrap(Command command) {
		return org.eclipse.papyrus.infra.emf.gmf.command.EMFtoGMFCommandWrapper.wrap(command);
	}

	//
	// Nested types
	//

	/**
	 * A non-dirtying wrapper for non-dirtying commands.
	 * 
	 * @deprecated Use the {@link org.eclipse.papyrus.infra.emf.gmf.command.EMFtoGMFCommandWrapper.NonDirtying} API, instead.
	 */
	@Deprecated
	public static class NonDirtying extends org.eclipse.papyrus.infra.emf.gmf.command.EMFtoGMFCommandWrapper.NonDirtying implements INonDirtying {

		public NonDirtying(org.eclipse.emf.common.command.Command command) {
			super(command);
		}

	}
}
