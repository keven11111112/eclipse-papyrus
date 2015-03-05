/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Celine Janssens (ALL4TEC) celine.janssens@all4tec.net - Initial API and implementation
 *   Celine Janssens (ALL4TEC) celine.janssens@all4tec.net - Bug 455311 : Refactor Stereotypes Display
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.stereotype;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * @author Céline JANSSENS
 *
 */
public class CreateStereotypeLabelCommand extends RecordingCommand {

	private static final String STEREOTYPE_LABEL_COMMAND_NAME = "Stereotype Label Creation Command";


	protected View owner;

	protected Stereotype stereotype;

	protected boolean isVisible;

	protected Element element;

	/**
	 * Constructor.
	 *
	 * @param domain
	 *            Transactional domain
	 * @param owner
	 *            Owner of the Label Created
	 * @param stereoApplication
	 *            Stereotype application which the Label will be based on
	 * @param isVisible
	 *            if the Label is Visible when created
	 */
	public CreateStereotypeLabelCommand(TransactionalEditingDomain domain, View owner, Stereotype stereotype) {
		super(domain, STEREOTYPE_LABEL_COMMAND_NAME);
		this.owner = owner;
		this.stereotype = stereotype;

	}

	/**
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 *
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void doExecute() {


		// Create Label
		DecorationNode label = NotationFactory.eINSTANCE.createDecorationNode();
		label.setType(StereotypeDisplayUtils.STEREOTYPE_LABEL_TYPE);
		label.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		label.setElement(stereotype);

		// Create Stereotype Name Style
		StringValueStyle stereotypeNameStyle = NotationFactory.eINSTANCE.createStringValueStyle();
		stereotypeNameStyle.setName(StereotypeDisplayUtils.STEREOTYPE_LABEL_NAME);
		stereotypeNameStyle.setStringValue(stereotype.getQualifiedName());
		label.getStyles().add(stereotypeNameStyle);

		// Add the new Label to it's owner Object
		ViewUtil.insertChildView(owner, label, ViewUtil.APPEND, StereotypeDisplayUtils.PERSISTENT);

		label.setMutable(true);


	}
}
