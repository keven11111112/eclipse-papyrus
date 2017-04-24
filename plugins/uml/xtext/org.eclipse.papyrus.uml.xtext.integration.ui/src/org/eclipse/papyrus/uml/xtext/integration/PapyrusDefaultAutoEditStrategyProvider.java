/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.xtext.integration;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;

/**
 * The Papyrus default auto edit strategy provider which deny the partition deletion that is not correctly managed in Papyrus XText editor.
 */
public class PapyrusDefaultAutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider#configureStringLiteral(org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider.IEditStrategyAcceptor)
	 */
	@Override
	protected void configureStringLiteral(final IEditStrategyAcceptor acceptor) {
		acceptor.accept(partitionInsert.newInstance("\"", "\""), IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(partitionInsert.newInstance("'", "'"), IDocument.DEFAULT_CONTENT_TYPE);
		// Don't add the partition deletion for the ' and " characters
		acceptor.accept(partitionEndSkippingEditStrategy.get(), TerminalsTokenTypeToPartitionMapper.STRING_LITERAL_PARTITION);
	}

	protected void configureCurlyBracesBlock(IEditStrategyAcceptor acceptor) {
		// Do nothing here
	}

	protected void configureSquareBrackets(IEditStrategyAcceptor acceptor) {
		// Do nothing here
	}

	protected void configureParenthesis(IEditStrategyAcceptor acceptor) {
		// Do nothing here
	}
}