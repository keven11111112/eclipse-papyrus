/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.modelexplorer.tests.generator.common;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.uml2.uml.Element;

/**
 * Utility class to find diagram from EObject
 */
public class NotationUtils {

	public static Set<Diagram> getAllDiagrams(Element element) {
		Set<Diagram> diagrams = new HashSet<Diagram>();
		Resource notationResource = getNotationResource(element.eResource());
		for(EObject child : notationResource.getContents()) {
			if(child instanceof Diagram) { // should be...
				diagrams.add((Diagram)child);
			}
		}
		return diagrams;
	}

	public static Set<Diagram> getAssociatedDiagram(Element element) {
		Set<Diagram> diagrams = new HashSet<Diagram>();
		Resource notationResource = getNotationResource(element.eResource());
		for(EObject child : notationResource.getContents()) {
			if(child instanceof Diagram) { // should be...
				Diagram diagram = ((Diagram)child);
				if(element.equals(diagram.getElement())) {
					diagrams.add(diagram);
				}
			}
		}
		return diagrams;
	}

	protected static Resource getNotationResource(Resource resource) {
		ResourceSet resourceSet = resource.getResourceSet();
		URI notationURI = resource.getURI().trimFileExtension();
		notationURI = notationURI.appendFileExtension("notation");
		Resource notationResource = resourceSet.getResource(notationURI, true);
		return notationResource;
	}
}
