/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.statemachine.tests.canonical;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.CommentEditPart;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Assert;
import org.junit.Test;

public class TestSemantic extends BaseTestCase {
	
	@Test
	public void testCommentInRegion() {
		IGraphicalEditPart commentEP = createChild(CommentEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		
		Comment comment = (Comment) commentEP.resolveSemanticElement();
		Region region = (Region) getRegionCompartmentEditPart().resolveSemanticElement();
		
		EReference expectedFeature = UMLPackage.eINSTANCE.getElement_OwnedComment();
		
		checkContainsChildren(region, comment, expectedFeature);
	}
	
	protected void checkContainsChildren(EObject parent, EObject child, EReference feature) {
		List<?> containmentList = (List<?>)parent.eGet(feature);
		String message = "Element [" + parent + "] don't contain [" + child +"] whith feature:" + feature.getName();
		Assert.assertTrue(message, containmentList.contains(child));
	}
}
