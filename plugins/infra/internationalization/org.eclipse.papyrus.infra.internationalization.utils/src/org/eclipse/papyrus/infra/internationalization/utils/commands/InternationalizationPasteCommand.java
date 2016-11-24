/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.internationalization.utils.commands;

import java.util.Locale;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.internationalization.utils.utils.LabelInternationalizationUtils;

/**
 * A Command to set the internationalization of the object for the locale.
 */
public class InternationalizationPasteCommand extends RecordingCommand {
	
	/**
	 * The prefix to add.
	 */
	public static final String COPY_OF = "CopyOf_"; //$NON-NLS-1$
	
	
	/**
	 * The object to set the label.
	 */
	private EObject eObject;
	
	/**
	 * The label for the object.
	 */
	private String newLabel;
	
	/**
	 * The locale for the internationalization label for object.
	 */
	private Locale locale;
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param domain The editing domain.
	 * @param eObject The object to set the label.
	 * @param initialLabel The label for the object.
	 * @param locale The locale for the internationalization label for object.
	 */
	public InternationalizationPasteCommand(final TransactionalEditingDomain domain, final EObject eObject, final String initialLabel, final Locale locale) {
		super(domain);
		this.eObject = eObject;
		this.newLabel = getNewLabel(initialLabel);
		this.locale = locale;
	}
	
	/**
	 * Get the label modified from the initial label.
	 * 
	 * @param initialLabel The initial label.
	 * @return The modified label.
	 */
	private String getNewLabel(final String initialLabel){
		return new StringBuilder(COPY_OF).append(initialLabel).toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	@Override
	protected void doExecute() {
		LabelInternationalizationUtils.setLabel(eObject, newLabel, locale);
	}
}
