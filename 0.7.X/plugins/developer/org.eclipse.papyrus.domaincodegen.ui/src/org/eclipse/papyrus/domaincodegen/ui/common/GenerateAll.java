/*******************************************************************************
 * Copyright (c) 2008, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.domaincodegen.ui.common;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.Bundle;


/**
 * Main entry point of the 'DomainCodegen' generation module.
 */
public class GenerateAll {

	/**
	 * The model URI.
	 */
	private URI modelURI;

	/**
	 * The output folder.
	 */
	private File targetFolder;

	/**
	 * The other arguments.
	 */
	List<? extends Object> arguments;

	/**
	 * Constructor.
	 * 
	 * @param modelURI
	 *            is the URI of the model.
	 * @param targetFolder
	 *            is the output folder
	 * @param arguments
	 *            are the other arguments
	 * @throws IOException
	 *             Thrown when the output cannot be saved.
	 * @generated
	 */
	public GenerateAll(URI modelURI, File targetFolder, List<? extends Object> arguments) {
    this.modelURI = modelURI;
    this.targetFolder = targetFolder;
    this.arguments = arguments;
  }

	/**
	 * Launches the generation.
	 *
	 * @param monitor
	 *            This will be used to display progress information to the user.
	 * @throws IOException
	 *             Thrown when the output cannot be saved.
	 * @generated
	 */
	public void doGenerate(IProgressMonitor monitor) throws IOException {
    if (!targetFolder.exists()) {
      targetFolder.mkdirs();
    }
    
    // final URI template0 = getTemplateURI("org.eclipse.papyrus.domaincontextcodegen", new Path("/org/eclipse/papyrus/domaincontextcodegen/generate.emtl"));
    // org.eclipse.papyrus.domaincontextcodegen.Generate gen0 = new org.eclipse.papyrus.domaincontextcodegen.Generate(modelURI, targetFolder, arguments) {
    //	protected URI createTemplateURI(String entry) {
    //		return template0;
    //	}
    //};
    //gen0.doGenerate(BasicMonitor.toMonitor(monitor));
    org.eclipse.papyrus.domaincontextcodegen.Generate gen0 = new org.eclipse.papyrus.domaincontextcodegen.Generate(modelURI, targetFolder, arguments);
    gen0.doGenerate(BasicMonitor.toMonitor(monitor));
      
    EObject model = gen0.getModel();
    if (model != null) {
        
      //final URI template1 = getTemplateURI("org.eclipse.papyrus.domaincontextcodegen", new Path("/org/eclipse/papyrus/domaincontextcodegen/generateElementTypeClass.emtl"));
      //org.eclipse.papyrus.domaincontextcodegen.GenerateElementTypeClass gen1 = new org.eclipse.papyrus.domaincontextcodegen.GenerateElementTypeClass(model, targetFolder, arguments) {
      //	protected URI createTemplateURI(String entry) {
      //		return template1;
      //	}
      //};
      //gen1.doGenerate(BasicMonitor.toMonitor(monitor));
      org.eclipse.papyrus.domaincontextcodegen.GenerateElementTypeClass gen1 = new org.eclipse.papyrus.domaincontextcodegen.GenerateElementTypeClass(model, targetFolder, arguments);
      gen1.doGenerate(BasicMonitor.toMonitor(monitor));
      //final URI template2 = getTemplateURI("org.eclipse.papyrus.domaincontextcodegen", new Path("/org/eclipse/papyrus/domaincontextcodegen/generateXMLElementType.emtl"));
      //org.eclipse.papyrus.domaincontextcodegen.GenerateXMLElementType gen2 = new org.eclipse.papyrus.domaincontextcodegen.GenerateXMLElementType(model, targetFolder, arguments) {
      //	protected URI createTemplateURI(String entry) {
      //		return template2;
      //	}
      //};
      //gen2.doGenerate(BasicMonitor.toMonitor(monitor));
      org.eclipse.papyrus.domaincontextcodegen.GenerateXMLElementType gen2 = new org.eclipse.papyrus.domaincontextcodegen.GenerateXMLElementType(model, targetFolder, arguments);
      gen2.doGenerate(BasicMonitor.toMonitor(monitor));
    }
      
    
  }
	
	/**
	 * Finds the template in the plug-in. Returns the template plug-in URI.
	 * 
	 * @param bundleID
	 *            is the plug-in ID
	 * @param relativePath
	 *            is the relative path of the template in the plug-in
	 * @return the template URI
	 * @throws IOException
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	private URI getTemplateURI(String bundleID, IPath relativePath) throws IOException {
    Bundle bundle = Platform.getBundle(bundleID);
    if (bundle == null) {
      // no need to go any further
      return URI.createPlatformResourceURI(new Path(bundleID).append(relativePath).toString(), false);
    }
    URL url = bundle.getEntry(relativePath.toString());
    if (url == null && relativePath.segmentCount() > 1) {
      Enumeration<URL> entries = bundle.findEntries("/", "*.emtl", true);
      if (entries != null) {
        String[] segmentsRelativePath = relativePath.segments();
        while (url == null && entries.hasMoreElements()) {
          URL entry = entries.nextElement();
          IPath path = new Path(entry.getPath());
          if (path.segmentCount() > relativePath.segmentCount()) {
            path = path.removeFirstSegments(path.segmentCount() - relativePath.segmentCount());
          }
          String[] segmentsPath = path.segments();
          boolean equals = segmentsPath.length == segmentsRelativePath.length;
          for (int i = 0; equals && i < segmentsPath.length; i++) {
            equals = segmentsPath[i].equals(segmentsRelativePath[i]);
          }
          if (equals) {
            url = bundle.getEntry(entry.getPath());
          }
        }
      }
    }
    URI result;
    if (url != null) {
      result = URI.createPlatformPluginURI(new Path(bundleID).append(new Path(url.getPath())).toString(), false);
    } else {
      result = URI.createPlatformResourceURI(new Path(bundleID).append(relativePath).toString(), false);
    }
    return result;
  }

}
