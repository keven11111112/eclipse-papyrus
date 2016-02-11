/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *  Sebastien Gabel (Esterel Technologies) - Change implementation to consider denied permissions
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration;

import java.util.Arrays;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.extendedtypes.Activator;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.IInvariantContainerDescriptor;
import org.eclipse.papyrus.infra.services.edit.internal.context.TypeContext;

/**
 * @author RS211865
 */
public class InvariantContainerConfigurationContainerDescriptor implements IInvariantContainerDescriptor<InvariantContainerConfiguration> {

	protected EList<HierarchyPermission> permissions;

	private IClientContext sharedContext;

	private IElementMatcher matcher;

	/**
	 * {@inheritDoc}
	 */
	public IElementMatcher getMatcher() {
		if (matcher == null) {
			matcher = createMatcher();
		}
		return matcher;
	}

	/**
	 * @return
	 */
	protected IElementMatcher createMatcher() {
		return new IElementMatcher() {

			public boolean matches(EObject eObject) {
				if (eObject == null) {
					return false;
				}

				IElementType objectMetamodelType = ElementTypeRegistry.getInstance().getElementType(eObject, sharedContext);

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
							boolean matchesSpecialization = matcher.matches(eObject) && objectMetamodelType.equals(((ISpecializationType) type).getMetamodelType()); // the eObject matches the speciailization type that is permitted. Should then check the
							if (matchesSpecialization) { 
								// test the isStrict now... It will be false if it matches one of the sub-specialization type
								if (isStrict) {
									ISpecializationType[] subtypes = ElementTypeRegistry.getInstance().getSpecializationsOf(childType);
									if (subtypes != null && subtypes.length > 0) {
										for (ISpecializationType subType : subtypes) {
											isValid = subType.getMatcher().matches(eObject) ? isPermitted : !isPermitted; // the isStrict is not verified (one of the subtypes is matched whereas it shoud not)
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

				// IElementType[] types = ElementTypeRegistry.getInstance().getAllTypesMatching(eObject, sharedContext);
				// if (types == null || types.length == 0) {
				// return false;
				// }
				//
				// for (HierarchyPermission permission : permissions) {
				// boolean isPermitted = permission.isIsPermitted();
				// String childType = permission.getChildType();
				// boolean isStrict = permission.isIsStrict();
				// IElementType type = ElementTypeRegistry.getInstance().getType(childType);
				// if (type != null) {
				// if (isStrict) {
				// isValid = types[0].equals(type) ? isPermitted : !isPermitted;
				// } else {
				// // not strict. The super types of typeToCreate should contain the permission type if permitted, or not contain the permission type if not permitted
				// List<IElementType> allTypes = Arrays.asList(types);
				// isValid = allTypes.contains(type) ? isPermitted : !isPermitted;
				// }
				// }
				// }
				return isValid;
			}
		};
	}

	/**
	 * {@inheritDoc}
	 */
	public EReference[] getContainmentFeatures() {
		// TODO should implement in permissions...
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(InvariantContainerConfiguration ruleConfiguration) {
		this.permissions = ruleConfiguration.getPermissions();
		try {
			sharedContext = TypeContext.getContext();
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
	}
}
