/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Mauricio Alferez (mauricio.alferez@cea.fr) CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.metrics.extensionpoints.helpers;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.omg.smm.Attribute;
import org.omg.smm.SmmFactory;
import org.omg.smm.SmmModel;
import org.omg.smm.SmmPackage;

public class SmmMetricsModelHelper {
	/**
	 * Allows to users to select the xmi file containing the smm model.
	 * 
	 * @return a string describing the absolute path of the first selected file,
	 *         or null if the dialog was cancelled or an error occurred.
	 */
	public String getSmmModelFileLocation() {
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.OPEN);
		dialog.setFilterExtensions(new String[] { "*.xmi" });
		dialog.setFilterPath(Platform.getLocation().toOSString());
		return dialog.open();
	}

	/**
	 * Load all the argument file path or URI as instance of the SMM model.
	 * 
	 * @param arg
	 *            the smm model file path or URI.
	 */
	public SmmModel getSmmModel(String arg) {
		// Create a resource set to hold the resources.
		ResourceSet resourceSet = new ResourceSetImpl();
		SmmModel model = null;

		if (arg.isEmpty()) {
			System.out.println("Enter a file path or URI that have content like this:");
			try {
				Resource resource = resourceSet.createResource(URI.createURI("http:///My.smm"));
				Attribute root = SmmFactory.eINSTANCE.createAttribute();
				resource.getContents().add(root);
				resource.save(System.out, null);
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		// Register the appropriate resource factory to handle all file
		// extensions.
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		resourceSet.getPackageRegistry().put(SmmPackage.eNS_URI, SmmPackage.eINSTANCE);
		// Construct the URI for the instance file.
		// The argument is treated as a file path only if it denotes an existing
		// file.
		// Otherwise, it's directly treated as a URL.
		File file = new File(arg);
		URI uri = file.isFile() ? URI.createFileURI(file.getAbsolutePath()) : URI.createURI(arg);

		try {
			// Demand load resource for this file.
			Resource resource = resourceSet.getResource(uri, true);
			System.out.println("Loaded " + uri);
			model = (SmmModel) resource.getContents().get(0);
		} catch (RuntimeException exception) {
			System.out.println("Problem loading " + uri);
			exception.printStackTrace();
		}
		return model;
	}
}
