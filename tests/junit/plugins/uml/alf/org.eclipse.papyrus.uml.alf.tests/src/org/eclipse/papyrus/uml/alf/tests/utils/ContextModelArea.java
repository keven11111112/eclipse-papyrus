/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Jeremie Tatibouet
 * 
 *****************************************************************************/

package org.eclipse.papyrus.uml.alf.tests.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * This class initializes a UML model by applying required profiles and importing required libraries.
 * The model managed by the class can be retrieved by external entities in order to be modified
 */
public class ContextModelArea {

	/**
	 * The resource set in which the different resources (the model, the libraries and the profiles)
	 * will be loaded.
	 */
	private ResourceSet area;

	/**
	 * The model for applying profiles and importing registered libraries
	 */
	private Model model;


	/**
	 * Constructor
	 */
	public ContextModelArea(String modelName) {
		this.model = UMLFactory.eINSTANCE.createModel();
		this.model.setName(modelName);
		this.area = new ResourceSetImpl();
		this.addModelInresource();
		this.loadRequiredResources();
	}

	/**
	 * Place the model in a resource of the resourceSet
	 */
	private void addModelInresource() {
		Resource resource = this.area.createResource(URI.createURI("Model"), "UML");
		if (resource != null) {
			resource.getContents().add(this.model);
		}
	}

	/**
	 * Load elements that makes the model ready to be used
	 */
	protected void loadRequiredResources() {
		this.applyRequiredProfiles();
		this.importRequiredLibraries();
	}

	/**
	 * Apply the standard profile and the action language profile
	 */
	private void applyRequiredProfiles() {
		/* 1 Load and apply standard profile */
		Profile standardProfile = RegisteredItemLoader.getInstance().
				getProfile(RequiredElementsNames.STANDARD_PROFILE);
		if (standardProfile != null) {
			this.model.applyProfile(standardProfile);
		}
		/* 2. Load and apply action language profile */
		Profile actionLanguageProfile = RegisteredItemLoader.getInstance().
				getProfile(RequiredElementsNames.ACTION_LANGUAGE_PROFILE);
		if (actionLanguageProfile != null) {
			this.model.applyProfile(actionLanguageProfile);
		}
	}

	/**
	 * Import ALF library and UML primitive types in the model
	 */
	private void importRequiredLibraries() {
		List<PackageableElement> libraries = new ArrayList<PackageableElement>();
		PackageableElement alfLibrary = RegisteredItemLoader.getInstance().
				loadLibrary(this.area, RequiredElementsNames.ALF_LIBRARY);
		if (alfLibrary != null) {
			libraries.add(alfLibrary);
		}
		PackageableElement umlPrimitiveTypes = RegisteredItemLoader.getInstance().
				loadLibrary(this.area, RequiredElementsNames.UML_PRIMITIVE_TYPES);
		if (umlPrimitiveTypes != null) {
			libraries.add(umlPrimitiveTypes);
		}
		for (PackageableElement library : libraries) {
			ElementImport elementImport = UMLFactory.eINSTANCE.createElementImport();
			elementImport.setImportedElement(library);
			elementImport.setVisibility(VisibilityKind.PUBLIC_LITERAL);
			this.model.getElementImports().add(elementImport);
		}
	}

	/**
	 * Returns the model managed by this area
	 */
	public Model getModel() {
		return this.model;
	}

	public class RequiredElementsNames {
		/* Profiles */
		public final static String STANDARD_PROFILE = "Standard";
		public final static String ACTION_LANGUAGE_PROFILE = "ActionLanguage";
		/* Libraries */
		public final static String ALF_LIBRARY = "Alf Library";
		public final static String UML_PRIMITIVE_TYPES = "UMLPrimitiveTypes";
	}
}
