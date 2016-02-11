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

/**
 * A EMF Command that wraps a GMF command. Each method is redirected to the GMF one.
 * 
 * @deprecated Use the {@link org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper} API, instead.
 */
@Deprecated
public class GMFtoEMFCommandWrapper extends org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper {

	static {
		// Configure legacy compatibility
		setWrapperFunction(GMFtoEMFCommandWrapper::new);
		setNonDirtyingWrapperFunction(NonDirtying::new);
	}

	/**
	 * Constructor.
	 *
	 * @param gmfCommand
	 *            the gmf command
	 */
	public GMFtoEMFCommandWrapper(ICommand gmfCommand) {
		super(gmfCommand);
	}

	/**
	 * Wraps the given {@code command}, accounting for possible non-dirty state.
	 *
	 * @param command
	 *            a command to wrap
	 * @return the best wrapper for the {@code command}
	 */
	public static Command wrap(ICommand command) {
		return org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper.wrap(command);
	}

	//
	// Nested types
	//

	/**
	 * A non-dirtying wrapper for non-dirtying commands.
	 * 
	 * @deprecated Use the {@link org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper.NonDirtying} API, instead.
	 */
	@Deprecated
	public static class NonDirtying extends org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper.NonDirtying {

		public NonDirtying(ICommand command) {
			super(command);
		}

	}

}
