/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.sysml14.service.types.advice;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.papyrus.sysml14.util.SysmlResource;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The helper advice class used for Unit.
 *  - Init the type of the instance specification
 *  - create all slot corresponding to Unit attributes
 *
 */
public class UnitEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * 
	 */
	private static final String UNIT = "Unit";
	/**
	 * 
	 */
	private static final String UNIT_AND_QUANTITY_KIND = "UnitAndQuantityKind";


	// TODO : this method should be provided as API in an upper level (already exist ?)
	private Classifier getClassByNameSpace(Resource resource, String packageName, String classifierName) {

		EList<EObject> contents = resource.getContents();
		
		for (EObject eObject : contents) {
			if (eObject instanceof Package){
				Package pkg = (Package) eObject;
				
				PackageableElement packagedElement2 = pkg.getPackagedElement(packageName);
				PackageableElement packagedElement4 = ( (Package) packagedElement2).getPackagedElement(classifierName);
				return (Classifier) packagedElement4;
			}
		}
		return null;
	}	


	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		final InstanceSpecification instanceSpecification = (InstanceSpecification) request.getElementToConfigure();
		
		return new ConfigureElementCommand(request) {
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				// get sysml library
				
				ResourceSet rset = new ResourceSetImpl();
				URI createURI = URI.createURI(SysmlResource.LIBRARY_PATH);
				Resource res = rset.getResource(createURI,true);

				Classifier unitClassifier = getClassByNameSpace(res, UNIT_AND_QUANTITY_KIND, UNIT);
				
				// set classifier to unit
				instanceSpecification.getClassifiers().add(unitClassifier);
				EList<Property> attributes = unitClassifier.getAttributes();
				
				for (Property property : attributes) {
					Slot slot = instanceSpecification.createSlot();
					slot.createValue(property.getName(), property.getType(), UMLPackage.eINSTANCE.getLiteralString());
					slot.setDefiningFeature(property);
				}				
				
				return CommandResult.newOKCommandResult(instanceSpecification);
			}
		};
	}
}
