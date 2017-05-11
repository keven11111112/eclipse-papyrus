/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.tests.canonical;

import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.junit.Test;

/**
 * this class is used to test element as affixed node of the interaction
 *
 */
public  class TestInteractionAffixedChildNode extends AbstractTestSequenceAffixedChildNode{

	
	@Test
	public void testToManageGate() {
		testToManageChildNode(UMLElementTypes.Gate_Shape,1);
	}

	@Test
	public void testToManageDurationConstraint() {
		testToManageChildNode(UMLElementTypes.DurationConstraint_Shape 	,1);
	}
	
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return  new CreateSequenceDiagramCommand();
	}

}