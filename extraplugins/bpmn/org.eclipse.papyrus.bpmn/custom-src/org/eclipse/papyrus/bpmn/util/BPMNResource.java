/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.bpmn.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage.Literals;

public class BPMNResource {

	public static final String UML_PROFILE = "pathmap://UML_PROFILES/Standard.profile.uml";
	public static final String BPMN_PROFILE = "pathmap://BPMN_PROF/bpmn.profile.uml";

	private BPMNResource(){
	}
	
	public static Model createBPMNModel(){
		String modelName = "test";
		String resourceName = "test.uml";
		ResourceSet resourceSet = new ResourceSetImpl();
		
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName(modelName);
		URI createURI = URI.createURI(resourceName);
		Resource resource = resourceSet.createResource(createURI);
		resource.getContents().add(model);
        Resource standardProfileResource = resourceSet.getResource(URI.createURI(UML_PROFILE), true);
        Profile umlStdProfile = (Profile)EcoreUtil.getObjectByType(standardProfileResource.getContents(), Literals.PACKAGE);
        model.applyProfile(umlStdProfile);
        Resource bpmnProfileResource = resourceSet.getResource(URI.createURI(BPMN_PROFILE), true);
        Profile bpmnProfile = (Profile)EcoreUtil.getObjectByType(bpmnProfileResource.getContents(), Literals.PACKAGE);
        model.applyProfile(bpmnProfile);
        return model;
	}
}
