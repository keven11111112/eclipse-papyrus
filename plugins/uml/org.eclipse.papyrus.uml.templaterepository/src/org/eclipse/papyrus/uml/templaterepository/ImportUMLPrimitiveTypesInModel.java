/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Quentin Le Menez quentin.lemenez@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.templaterepository;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.uml.diagram.wizards.transformation.IGenerator;
//import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.uml2.uml.PackageImport;

//import org.eclipse.uml2.uml.UMLFactory;


public class ImportUMLPrimitiveTypesInModel implements IGenerator {
	// This class is used when the element is checked inside SelectModelTemplateComposite's templateTableViewer

	private ModelSet modelSet;

	private org.eclipse.uml2.uml.Package rootElement;

	private EObject primitiveTypes;


	public void execute() {
		// Get the umlModel from the modelSet
		// UmlModel umlModel = (UmlModel) modelSet.getModel(UmlModel.MODEL_ID);
		// Get its resource
		// Resource umlResource = umlModel.getResource();
		Resource umlResource = UmlUtils.getUmlModel(modelSet).getResource();

		// Select the root element to add the wanted imports
		rootElement = (org.eclipse.uml2.uml.Model) umlResource.getContents().get(0);

		// Load the needed libraries. Calling them directly with the path renders the resource folder obsolete ?
		URI primitiveTypesURI = URI.createURI("pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml").appendFragment("_0");
		primitiveTypes = modelSet.getEObject(primitiveTypesURI, true);

		// Creates the import packages at the root of the model (elements of type packageImport)
		this.getCommandStack(modelSet).execute(new RecordingCommand(modelSet.getTransactionalEditingDomain()) {

			@Override
			protected void doExecute() {
				// PackageImport packageImport = UMLFactory.eINSTANCE.createPackageImport();
				// packageImport.setImportedPackage((org.eclipse.uml2.uml.Package) ImportUMLPrimitiveTypesInModel.this.primitiveTypes);
				// rootElement.getPackageImports().add(packageImport);

				PackageImport importPrimitivePack = rootElement.createPackageImport((org.eclipse.uml2.uml.Package) primitiveTypes);
				if (!rootElement.getPackageImports().contains(importPrimitivePack)) {
					rootElement.getPackageImports().add(importPrimitivePack);
				}

				try {
					rootElement.eResource().save(Collections.EMPTY_MAP);
				} catch (IOException e) {
					Activator.log.error(e);
				}
			}
		});

	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.wizards.transformation.IGenerator#setModelSet(org.eclipse.papyrus.uml.diagram.wizards.transformation.ModelSet)
	 *
	 * @param modelSet
	 */
	public void setModelSet(ModelSet modelSet) {
		this.modelSet = modelSet;
	}

	protected final CommandStack getCommandStack(ModelSet modelSet) {
		return modelSet.getTransactionalEditingDomain().getCommandStack();
	}

	public ModelSet getModelSet() {
		return this.modelSet;
	}

}
