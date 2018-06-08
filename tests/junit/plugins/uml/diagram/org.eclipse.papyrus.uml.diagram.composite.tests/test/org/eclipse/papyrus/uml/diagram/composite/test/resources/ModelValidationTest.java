/*****************************************************************************
 * Copyright (c) 2018 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.composite.test.resources;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * This is a parameterized test to validate all model in the plugin
 * 
 * @author Benoit Maggi
 */
@SuppressWarnings("nls")
@RunWith(Parameterized.class)
public class ModelValidationTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
			{"/model/CompositeStructure.paletteconfiguration"},	
			{"/model/compositediagram.elementtypesconfigurations"},	
			{"/model/compositediagram.gmfgen"},
		});
	}
	
	private String modelPath; 
	    
	public ModelValidationTest(String modelPath) {
		this.modelPath = modelPath;
	}

	/**
	 * Validate the model with the rules defined in the meta-model tooling
	 */
	@Test
	public void validateModel() {
		String fullPath = "org.eclipse.papyrus.uml.diagram.composite"+ this.modelPath;
		URI modelPlatformURI = URI.createPlatformPluginURI(fullPath, true);
		Resource resource = new ResourceSetImpl().getResource(modelPlatformURI, true);
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		Assert.assertEquals("The "+modelPath+" model is invalid "+print(diagnostic), Diagnostic.OK, diagnostic.getSeverity());
	}

	// FIXME : Something should exist in API to do that
	private String print(Diagnostic diagnostic) {
		List<Diagnostic> children = diagnostic.getChildren();
		StringBuilder stringBuilder = new StringBuilder(diagnostic.getMessage());
		for (Diagnostic diagnosticChildren : children) {
			stringBuilder.append("\n"); //$NON-NLS-1$
			stringBuilder.append(diagnosticChildren.getMessage());
		}
		return stringBuilder.toString();
	}	
	
}
