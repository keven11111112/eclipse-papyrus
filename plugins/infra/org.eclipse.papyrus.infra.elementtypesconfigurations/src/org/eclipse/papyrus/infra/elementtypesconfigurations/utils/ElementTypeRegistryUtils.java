/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.elementtypesconfigurations.utils;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.gmf.runtime.emf.type.core.ClientContext;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.internal.descriptors.IEditHelperAdviceDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.internal.impl.SpecializationTypeRegistry;
import org.eclipse.papyrus.infra.elementtypesconfigurations.Activator;

@SuppressWarnings("restriction")
public class ElementTypeRegistryUtils {

	static protected Map<String, Set<IEditHelperAdviceDescriptor>> adviceBindings = null;

	static protected Map<?, ?> metamodelTypeDescriptorsById = null;

	static protected Map<?, ?> metamodelTypeDescriptorsByNsURI = null;

	static protected SpecializationTypeRegistry specializationTypeRegistry = null;

	static protected Set<?> typeIdBindings = null;

	static public IElementType getType(IClientContext context, String elementTypeID) {
		IElementType[] elementTypes = ElementTypeRegistry.getInstance().getElementTypes(context);
		for (IElementType iElementType : elementTypes) {
			if (iElementType.getId().equals(elementTypeID)) {
				return iElementType;
			}
		}
		return null;
	}

	static public synchronized SpecializationTypeRegistry getSpecializationTypeRegistry() {
		if (specializationTypeRegistry == null) {
			Field declaredField = null;
			try {
				declaredField = ElementTypeRegistry.class.getDeclaredField("specializationTypeRegistry");
			} catch (SecurityException e1) {
				Activator.log.error(e1);
				return null;
			} catch (NoSuchFieldException e1) {
				Activator.log.error(e1);
				return null;
			}
			if (declaredField == null) {
				Activator.log.error("impossible to find specializationTypeRegistry", null);
				return null;
			}
			declaredField.setAccessible(true);
			try {
				specializationTypeRegistry = (SpecializationTypeRegistry) declaredField.get(ElementTypeRegistry.getInstance());
			} catch (IllegalArgumentException e) {
				Activator.log.error(e);
			} catch (IllegalAccessException e) {
				Activator.log.error(e);
			}
		}
		return specializationTypeRegistry;
	}

	@SuppressWarnings("unchecked")
	static public synchronized Map<String, Set<IEditHelperAdviceDescriptor>> getAdviceBindingsFromRegistry(SpecializationTypeRegistry registry) {
		if (adviceBindings == null) {
			Field adviceBindingsField = null;
			try {
				adviceBindingsField = SpecializationTypeRegistry.class.getDeclaredField("adviceBindings");
			} catch (SecurityException e1) {
				Activator.log.error(e1);
				return null;
			} catch (NoSuchFieldException e1) {
				Activator.log.error(e1);
				return null;
			}
			if (adviceBindingsField == null) {
				Activator.log.error("impossible to find adviceBindings", null);
				return null;
			}
			adviceBindingsField.setAccessible(true);
			try {
				adviceBindings = (Map<String, Set<IEditHelperAdviceDescriptor>>) adviceBindingsField.get(registry);
			} catch (IllegalArgumentException e) {
				Activator.log.error(e);
			} catch (IllegalAccessException e) {
				Activator.log.error(e);
			}
		}
		return adviceBindings;
	}

	static public void registerAdviceBinding(SpecializationTypeRegistry registry, IEditHelperAdviceDescriptor adviceDescriptor) {
		Map<String, Set<IEditHelperAdviceDescriptor>> adviceBindings = getAdviceBindingsFromRegistry(registry);
		String targetId = adviceDescriptor.getTypeId();
		Set<IEditHelperAdviceDescriptor> bindings = adviceBindings.get(targetId);
		if (bindings == null) {
			bindings = new HashSet<IEditHelperAdviceDescriptor>();
			adviceBindings.put(targetId, bindings);
		}
		bindings.add(adviceDescriptor);
	}

	static public void removeAdviceDescriptorFromBindings(SpecializationTypeRegistry registry, String targetId, IEditHelperAdviceDescriptor adviceDescriptor) {
		Map<?, ?> adviceBindings = getAdviceBindingsFromRegistry(registry);
		if (adviceBindings != null) {
			Set<?> bindings = (Set<?>) adviceBindings.get(targetId);
			if (bindings != null) {
				bindings.remove(adviceDescriptor);
			}
		}
	}

	static public void removeAdviceIDFromBindings(SpecializationTypeRegistry registry, String targetId, String adviceID) {
		Map<?, ?> adviceBindings = getAdviceBindingsFromRegistry(registry);
		if (adviceBindings != null) {
			Set<?> bindings = (Set<?>) adviceBindings.get(targetId);
			Iterator<?> it = bindings.iterator();
			Object foundBinding = null;
			while (it.hasNext() && foundBinding == null) {
				Object binding = it.next();
				if (binding instanceof IEditHelperAdviceDescriptor) {
					if (((IEditHelperAdviceDescriptor) binding).getId().equals(adviceID)) {
						foundBinding = binding;
					}
				}
			}
			if (foundBinding != null) {
				bindings.remove(foundBinding);
			}
		}
	}

	static public synchronized Map<?, ?> getMetamodelTypeDescriptorsByNsURI() {
		if (metamodelTypeDescriptorsByNsURI == null) {
			Field declaredField = null;
			try {
				declaredField = ElementTypeRegistry.class.getDeclaredField("metamodelTypeDescriptorsByNsURI");
			} catch (SecurityException e1) {
				Activator.log.error(e1);
				return null;
			} catch (NoSuchFieldException e1) {
				Activator.log.error(e1);
				return null;
			}
			if (declaredField == null) {
				Activator.log.error("impossible to find metamodelTypeDescriptorsByNsURI", null);
				return null;
			}
			declaredField.setAccessible(true);
			try {
				metamodelTypeDescriptorsByNsURI = (Map<?, ?>) declaredField.get(ElementTypeRegistry.getInstance());
			} catch (IllegalArgumentException e) {
				Activator.log.error(e);
			} catch (IllegalAccessException e) {
				Activator.log.error(e);
			}
		}
		return metamodelTypeDescriptorsByNsURI;
	}

	static public synchronized Map<?, ?> getMetamodelTypeDescriptorsById() {
		if (metamodelTypeDescriptorsById == null) {
			Field declaredField = null;
			try {
				declaredField = ElementTypeRegistry.class.getDeclaredField("metamodelTypeDescriptorsById");
			} catch (SecurityException e1) {
				Activator.log.error(e1);
				return null;
			} catch (NoSuchFieldException e1) {
				Activator.log.error(e1);
				return null;
			}
			if (declaredField == null) {
				Activator.log.error("impossible to find metamodelTypeDescriptorsById", null);
				return null;
			}
			declaredField.setAccessible(true);
			try {
				metamodelTypeDescriptorsById = (Map<?, ?>) declaredField.get(ElementTypeRegistry.getInstance());
			} catch (IllegalArgumentException e) {
				Activator.log.error(e);
			} catch (IllegalAccessException e) {
				Activator.log.error(e);
			}
		}
		return metamodelTypeDescriptorsById;
	}

	static public synchronized Set<?> getTypeIdBindings(IClientContext context) {
		if (typeIdBindings == null) {
			if (context instanceof ClientContext) {
				Field typeIdBindingsField = null;
				try {
					typeIdBindingsField = ClientContext.class.getDeclaredField("typeIdBindings");
				} catch (SecurityException e1) {
					Activator.log.error(e1);
					return null;
				} catch (NoSuchFieldException e1) {
					Activator.log.error(e1);
					return null;
				}
				if (typeIdBindingsField == null) {
					Activator.log.error("impossible to find typeIdBindingsField", null);
					return null;
				}
				typeIdBindingsField.setAccessible(true);
				try {
					typeIdBindings = (Set<?>) typeIdBindingsField.get(context);
				} catch (IllegalArgumentException e) {
					Activator.log.error(e);
				} catch (IllegalAccessException e) {
					Activator.log.error(e);
				}
			}
		}
		return typeIdBindings;
	}

	static public void unBindID(IClientContext context, String typeId) {
		Set<?> typeIdBindings = getTypeIdBindings(context);
		if (typeIdBindings != null) {
			typeIdBindings.remove(typeId);
		}
	}
}
