/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.extendedtypes.Activator;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.IInvariantElementMatcher;
import org.eclipse.papyrus.infra.services.edit.internal.context.TypeContext;

/**
 * Matcher of the hierarchy matcher
 */
public class InvariantContainerMatcher implements IInvariantElementMatcher<InvariantContainerConfiguration> {

	protected List<HierarchyPermission> permissions;
	
	protected IClientContext sharedContext;

	/**
	 *
	 */
	public InvariantContainerMatcher() {
		// nothing here. Trying not to create list to avoid unnecessary created objects
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EObject eObject) {
		EObject container = eObject.eContainer();

		if (container == null) {
			return false;
		}
		
		IElementType objectMetamodelType = ElementTypeRegistry.getInstance().getElementType(container, sharedContext);

		boolean isValid = false;
		for (HierarchyPermission permission : permissions) { // for each permission, get the matcher and matches directly
			boolean isPermitted = permission.isIsPermitted();
			String childType = permission.getChildType();
			boolean isStrict = permission.isIsStrict();
			IElementType type = ElementTypeRegistry.getInstance().getType(childType);
			
			// check is the permission type is a specialization type or a metamodel type, to enhance performances
			// if this is a metamodel type and strict, a simple equals can match or not if it is permitted or not
			// if this is a metamodel type and not strict, we only compare the list of supertypes of the eobject type with the permission Type 
			if (type instanceof IMetamodelType) {
				if (isStrict) {
					isValid = type.equals(objectMetamodelType) ? isPermitted : !isPermitted;
				} else {
					// this is not strict 
					// so any super metamodeltype of permission type that matches objectMetamodelType is OK
					isValid = Arrays.asList(objectMetamodelType.getAllSuperTypes()).contains(type) ? isPermitted : !isPermitted;
				}
			} else if (type instanceof ISpecializationType) {
				IElementMatcher matcher = ((ISpecializationType) type).getMatcher();
				if (matcher != null) {
					boolean matchesSpecialization = matcher.matches(container) && objectMetamodelType.equals(((ISpecializationType) type).getMetamodelType()); // the eObject matches the speciailization type that is permitted. Should then check the
					if (matchesSpecialization) { 
						// test the isStrict now... It will be false if it matches one of the sub-specialization type
						if (isStrict) {
							ISpecializationType[] subtypes = ElementTypeRegistry.getInstance().getSpecializationsOf(childType);
							if (subtypes != null && subtypes.length > 0) {
								for (ISpecializationType subType : subtypes) {
									isValid = subType.getMatcher().matches(container) ? isPermitted : !isPermitted; // the isStrict is not verified (one of the subtypes is matched whereas it shoud not)
								}
							} else { // there are no further sub specialization types. 
								isValid = isPermitted;
							}
						} else {
							// not strict
							isValid = isPermitted;
						}
					} else { // eObject type does not match the permission type
						isValid = !isPermitted;
						
					}
				}
			}
		}
		
		return isValid;
		
//		
//		
//		// retrieve element type
//		IElementType[] containerTypes = ElementTypeRegistry.getInstance().getAllTypesMatching(container, sharedContext);
//		if(containerTypes != null && containerTypes.length >0) {
//			return InvariantContainerUtils.isContainerValid(containerTypes, matches, permissions);
//		}
//		return false;
	}


	/**
	 * {@inheritDoc}
	 */
	public void init(InvariantContainerConfiguration configuration) {
		try {
			sharedContext = TypeContext.getContext();
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		this.permissions = configuration.getPermissions();
	}
}
