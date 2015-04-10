/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.expansion;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.DiagramExpansion;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionmodelPackage;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.UseContext;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.osgi.framework.Bundle;

/**
 * This class is used to load all extension point call org.eclipse.papyrus.infra.gmfdiag.diagramexpansion
 * It gives the set of all Diagram expansion that has to be used
 * #Req org.eclipse.papyrus.infra.gmfdiag.expansion.Req_060 
 * 
 */
public class DiagramExpansionsRegistry {

	private final String EXPANSION_MODEL_EXTENSION_ID = "org.eclipse.papyrus.infra.gmfdiag.common.diagramExpansion"; //$NON-NLS-1$
	private final String MODEL_ID = "model"; //$NON-NLS-1$
	private ArrayList<DiagramExpansion> diagramExpansions = new ArrayList<DiagramExpansion>();
	private HashMap<String,UseContext > usages= new HashMap<String, UseContext>();
	public HashMap<String,ChildrenListRepresentation > mapChildreen= new HashMap<String, ChildrenListRepresentation>();
	private static final boolean DEBUG_EXPANSION = "true".equalsIgnoreCase(Platform.getDebugOption(
			"org.eclipse.papyrus.infra.gmfdiag.common/debug/expansion"));

	/**
	 *
	 * Constructor.
	 *
	 */
	public DiagramExpansionsRegistry() {
		init();
	}

	/**
	 * this method load the extension points
	 */
	public void init() {
		// Obtain a new resource set
		ResourceSet resourceSet = Util.createTemporaryResourceSet();
		resourceSet.getPackageRegistry().put(ExpansionmodelPackage.eINSTANCE.getNsURI(), ExpansionmodelPackage.eINSTANCE);

		// Reading data from plugins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXPANSION_MODEL_EXTENSION_ID);
		for (int i = 0; i < configElements.length; i++) {
			DiagramExpansion diagramExpansion=initializeOneModel(resourceSet, configElements[i]);
			diagramExpansions.add(diagramExpansion);
			for (UseContext usage : diagramExpansion.getUsages()) {
				if( (usages.get(usage.getDiagramType()))==null){
					usages.put(usage.getDiagramType(), usage);
					ChildrenListRepresentation childrenListRepresentation= new ChildrenListRepresentation(usage);
					mapChildreen.put(usage.getDiagramType(), childrenListRepresentation);
					if(DEBUG_EXPANSION){
						System.out.println(childrenListRepresentation);
					}
				}
				else{
					//do not load --error
				}
			}
		}

	}

	/**
	 *
	 * @return the set of DiagramExpansion
	 */
	public ArrayList<DiagramExpansion> getDiagramExpansions() {
		return diagramExpansions;
	}

	/**
	 * get the usecontext associate to a diagram type
	 * @param diagramType the id of a diagram of the id of a view prototype
	 * @return a useConstext or null if not usage exist.
	 */
	public UseContext getUsage(String diagramType){
		return usages.get(diagramType);
	}


	/**
	 * Load one model
	 *
	 * @param element
	 *            the extension point
	 */
	private DiagramExpansion initializeOneModel(ResourceSet resourceSet, IConfigurationElement element) {
		try {
			return createExtension(resourceSet, element, element.getAttribute(MODEL_ID));

		} catch (Exception e) {
			Activator.log.error("model of new DiagramExpansion can not be loaded: ", e); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * Load a resource instanceof DiagramExpansion
	 *
	 * @param resourceSet
	 *            the resource set in which to load the menu model
	 * @param element
	 *            the extension point
	 * @param classAttribute
	 *            the name of the resource to load
	 * @return the loaded Folder
	 * @throws Exception
	 *             if the resource is not loaded
	 */
	private static DiagramExpansion createExtension(final ResourceSet resourceSet, final IConfigurationElement element, final String classAttribute) throws Exception {
		try {
			Bundle extensionBundle = Platform.getBundle(element.getDeclaringExtension().getNamespaceIdentifier());
			URL url = extensionBundle.getResource(classAttribute);

			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
			if (url != null) {
				URI uri = URI.createURI(url.toURI().toASCIIString());

				// Get the resource
				Resource resource = resourceSet.getResource(uri, true);
				if (resource.getContents().get(0) instanceof DiagramExpansion) {
					return (DiagramExpansion) resource.getContents().get(0);
				}
			}
			return null;
		} catch (Exception e) {
			throw new Exception("unable to create Extension" + e); //$NON-NLS-1$
		}
	}


}