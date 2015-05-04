/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.constraints.providers;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.validation.internal.EMFModelValidationDebugOptions;
import org.eclipse.emf.validation.internal.EMFModelValidationPlugin;
import org.eclipse.emf.validation.internal.EMFModelValidationStatusCodes;
import org.eclipse.emf.validation.internal.l10n.ValidationMessages;
import org.eclipse.emf.validation.internal.util.Log;
import org.eclipse.emf.validation.internal.util.Trace;
import org.eclipse.emf.validation.internal.util.XmlConfigurationElement;
import org.eclipse.emf.validation.internal.util.XmlConstraintDescriptor;
import org.eclipse.emf.validation.model.Category;
import org.eclipse.emf.validation.model.CategoryManager;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.AbstractConstraintProvider;
import org.eclipse.emf.validation.service.ConstraintExistsException;
import org.eclipse.emf.validation.service.ConstraintRegistry;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.emf.validation.util.XmlConfig;
import org.eclipse.emf.validation.xml.IXmlConstraintDescriptor;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.UMLPlugin;
import org.eclipse.uml2.uml.validation.IEValidatorProvider;

/**
 * A provider of constraints that delegate to an {@link EPackage}'s constraints
 * via its generated {@link EValidator} and can be overrided by the created constrains.
 */
@SuppressWarnings("restriction")
public class DelegatingConstraintProviderWithOverride
		extends AbstractConstraintProvider {

	/**
	 * The category element name.
	 */
	private static final String E_CATEGORY = "category"; //$NON-NLS-1$

	/**
	 * The path attribute name.
	 */
	private static final String A_PATH = "path"; //$NON-NLS-1$

	/**
	 * The eValidatorProvider element name.
	 */
	private static final String E_EVALIDATOR_PROVIDER = "eValidatorProvider"; //$NON-NLS-1$

	/**
	 * The class attribute name.
	 */
	private static final String A_CLASS = "class"; //$NON-NLS-1$
	
	/**
	 * Message for the text to replace an constraint unavailable
	 * constraint name.
	 */
	private static final String NO_NAME = ValidationMessages.constraint_not_init_name;

	/**
	 * Message for the text indicating that a constraint has no ID.
	 */
	private static final String REASON_NO_ID = ValidationMessages.constraint_reason_no_id;

	/**
	 * Message key for the text indicating that the XML file with
	 * errors is unknown.
	 */
	private static final String UNKNOWN_FILE = ValidationMessages.xml_unknown_file;
	
	/**
	 * Constructor.
	 */
	public DelegatingConstraintProviderWithOverride() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.uml2.uml.validation.DelegatingConstraintProvider#setInitializationData(org.eclipse.core.runtime.IConfigurationElement, java.lang.String, java.lang.Object)
	 */
	@Override
	public void setInitializationData(final IConfigurationElement config,
			final String propertyName, final Object data)
					throws CoreException {

		super.setInitializationData(config, propertyName, data);

		// first, grab the categories that I'll be assigning to my constraints
		final Set<Category> categories = getCategories(config);

		// get an EValidator provider
		IEValidatorProvider validatorProvider = getEValidatorProvider(config);

		// then find the constraints that I need to adapt
		for (String next : getNamespaceUris()) {
			// find the EValidator for this package
			EPackage epackage = EPackage.Registry.INSTANCE.getEPackage(next);

			if (epackage == null) {
				UMLPlugin.INSTANCE
					.log(new Status(
						IStatus.WARNING,
						UMLPlugin.INSTANCE.getSymbolicName(),
						"No such EPackage available for model validation: " + next)); //$NON-NLS-1$
			} else {
				EValidator validator = validatorProvider
					.getEValidator(epackage);
				if (validator == null) {
					UMLPlugin.INSTANCE
						.log(new Status(
							IStatus.WARNING,
							UMLPlugin.INSTANCE.getSymbolicName(),
							"No generated validator available for package: " + next)); //$NON-NLS-1$
				} else {
					EValidator.SubstitutionLabelProvider labelProvider = validatorProvider
						.getSubstitutionLabelProvider(epackage);

					try {
						Iterable<? extends IModelConstraint> constraints = createConstraints(
							config, epackage,
							validator, labelProvider);

						if (!categories.isEmpty()) {
							Category[] cats = categories
								.toArray(new Category[categories.size()]);
							for (IModelConstraint constraint : constraints) {
								IConstraintDescriptor desc = constraint
									.getDescriptor();
								for (int i = 0; i < cats.length; i++) {
									desc.addCategory(cats[i]);
								}
							}
						}
					} catch (ConstraintExistsException e) {
						throw new CoreException(new Status(IStatus.ERROR,
							UMLPlugin.INSTANCE.getSymbolicName(),
							"Failed to register model validation constraints.", //$NON-NLS-1$
							e));
					}
				}
			}
		}
	}

	/**
	 * Get the defined categories.
	 * 
	 * @param config The configuration element.
	 * @return The defined categories.
	 */
	private Set<Category> getCategories(final IConfigurationElement config) {
		final Set<Category> result = new java.util.HashSet<Category>();
		for (IConfigurationElement next : config.getChildren(E_CATEGORY)) {
			String path = next.getAttribute(A_PATH);

			if (!UML2Util.isEmpty(path)) {
				// if the category doesn't already exist, it is implicitly
				// created, so
				// we won't get a null category
				result.add(CategoryManager.getInstance().getCategory(path));
			}
		}

		return result;
	}

	/**
	 * Get the defined validator provider.
	 * 
	 * @param config The configuration eleemnt.
	 * @return the defined validator provider.
	 */
	private IEValidatorProvider getEValidatorProvider(
			final IConfigurationElement config) {

		IEValidatorProvider result = null;

		final IConfigurationElement[] vpConfig = config
			.getChildren(E_EVALIDATOR_PROVIDER);
		if (vpConfig.length > 0) {
			Object ext;
			try {
				ext = vpConfig[0].createExecutableExtension(A_CLASS);
				if (ext instanceof IEValidatorProvider) {
					result = (IEValidatorProvider) ext;
				}
			} catch (CoreException e) {
				UMLPlugin.INSTANCE.log(e.getStatus());
			}
		}

		if (result == null) {
			result = new IEValidatorProvider.Default();
		}

		return result;
	}
	
	/**
	 * This allow to get the defined constraints in the configuration.
	 * 
	 * @param config The configuration element.
	 * @return The list of defined constraints in the configuration.
	 * @throws CoreException The exception.
	 */
	private List<IModelConstraint> getDefinedConstraints(final IConfigurationElement config) throws CoreException{
		final List<IModelConstraint> definedConstraints = new ArrayList<IModelConstraint>();
		
		final IConfigurationElement[] constraintsElement = config.getChildren(
				XmlConfig.E_CONSTRAINTS);

		for (final IConfigurationElement constraintElement : constraintsElement) {
			final IConfigurationElement next = XmlConfig.parseConstraintsWithIncludes(constraintElement);

			final IConfigurationElement[] configs = next.getChildren();

			for (final IConfigurationElement constraintElements : configs) {
				definedConstraints.add(getConstraint(constraintElements));
			}
		}
		
		return definedConstraints;
	}
	
	/**
	 * This allow to create constraints and get it.
	 * 
	 * @param config The configuration element.
	 * @param epackage The package of the class.
	 * @param validator The validator to use.
	 * @param labelProvider The label Provider.
	 * @return The list of model constraints corresponding to the validate method in the class.
	 * @throws ConstraintExistsException The exception when a constraint already exist.
	 * @throws CoreException The core exception
	 */
	private Iterable<? extends IModelConstraint> createConstraints(
			final IConfigurationElement config,
			final EPackage epackage,
			final EValidator validator,
			final EValidator.SubstitutionLabelProvider labelProvider)
					throws ConstraintExistsException, CoreException {

		final List<IModelConstraint> result = new java.util.ArrayList<IModelConstraint>();
		final Matcher m = Pattern.compile("validate\\w+_validate(\\w+)") //$NON-NLS-1$
				.matcher(""); //$NON-NLS-1$
		final Map<Class<?>, EClass> eclasses = new java.util.HashMap<Class<?>, EClass>();
		final String namespace = config.getNamespaceIdentifier();

		final List<IModelConstraint> definedConstraints = getDefinedConstraints(config);

		for (Method next : validator.getClass().getDeclaredMethods()) {
			if (Modifier.isPublic(next.getModifiers())) {
				final Class<?>[] signature = next.getParameterTypes();

				m.reset(next.getName());
				if (m.matches()
						&& isConstraintMethod(next.getReturnType(), signature)) {

					EClass eclass = getEClass(eclasses, epackage, signature[0]);

					if (eclass != null) {
						if (!isRedefinedConstraints(definedConstraints, createIdentifier(next, eclass, namespace))) {

						// constraint methods could exist for EDataTypes; this
						// framework doesn't handle them
							result.add(new DelegatingModelConstraint(namespace,
									validator, labelProvider, eclass, next));
						}
					}	
				}
			}
		}

		result.addAll(definedConstraints);

		getConstraints().addAll(result);
		registerConstraints(result);

		return result;
	}

	/**
	 * This allow to create the identifier corresponding to the method.
	 * 
	 * @param method The method in the class.
	 * @param eclass The class corresponding.
	 * @param namespace The namespace.
	 * @return The identifier corresponding.
	 */
	protected static String createIdentifier(final Method method, final EClass eclass, final String namespace) {
		String name = method.getName();
		String expectedPrefix = String.format("validate%s_validate", //$NON-NLS-1$
				eclass.getName());
		if (name.startsWith(expectedPrefix)) {
			name = name.substring(expectedPrefix.length());
		}

		final StringBuilder buf = new StringBuilder();
		buf.append(namespace);
		buf.append('.').append(eclass.getEPackage().getName()).append('.')
				.append(eclass.getName());
		buf.append('.').append(name);
		return buf.toString();
	}

	/**
	 * This allow to define if the constraint id is already existing the list of contraint.
	 * 
	 * @param constraints The existing constrains.
	 * @param id The identifier to check.
	 * @return <code>true</code> if the constraint is already redefined, <code>false otherwise</code>.
	 */
	private static boolean isRedefinedConstraints(final List<IModelConstraint> constraints, final String id) {
		boolean result = false;

		final Iterator<IModelConstraint> contraintsIterator = constraints.iterator();
		while (contraintsIterator.hasNext() && !result) {
			if (contraintsIterator.next().getDescriptor().getId().equals(id)) {
				result = true;
			}
		}

		return result;
	}

	/**
	 * This allow to define if the method defined by the parameters is a contraint method.
	 * 
	 * @param returnType The return type of the method.
	 * @param parameterTypes The parameter types of the method.
	 * @return <code>true</code> if this is a contraint method, <code>false</code> otherwise.
	 */
	private static boolean isConstraintMethod(final Class<?> returnType,
			final Class<?>[] parameterTypes) {

		boolean result = false;

		if ((returnType == boolean.class) && (parameterTypes.length == 3)) {
			result = EObject.class.isAssignableFrom(parameterTypes[0])
					&& (parameterTypes[1] == DiagnosticChain.class)
					&& (parameterTypes[2] == Map.class);
		}

		return result;
	}

	/**
	 * Look up an {@link EClass} by instance-class, using a cache for
	 * performance of repeated queries.
	 * 
	 * @param cache
	 *            a cache of previous look-up results
	 * @param epackage
	 *            the epackage in which to find the eclass
	 * @param interfaceType
	 *            the Java interface type by which to look up the eclass
	 * 
	 * @return the eclass, or {@code null} if not found
	 */
	private static EClass getEClass(final Map<Class<?>, EClass> cache,
			final EPackage epackage, final Class<?> interfaceType) {

		EClass result = cache.get(interfaceType);

		if (result == null) {
			for (EClassifier next : epackage.getEClassifiers()) {
				if ((next.getInstanceClass() == interfaceType)
						&& (next instanceof EClass)) {
					result = (EClass) next;
					cache.put(interfaceType, result);
					break;
				}
			}
		}

		return result;
	}

	/**
	 * Adds a constraint to my collection, constructed from the specified XML
	 * content.
	 * 
	 * @param config
	 *            the <TT>&lt;constraint&gt;</TT> element
	 */
	private IModelConstraint getConstraint(final IConfigurationElement config) {
		IModelConstraint result = null;
		final String contributorId = config
				.getDeclaringExtension()
				.getNamespaceIdentifier();

		String id = config.getAttribute(XmlConfig.A_ID);
		if (id == null) {
			String name = config.getAttribute(XmlConfig.A_NAME);
			if (name == null) {
				String fileName;

				if (config instanceof XmlConfigurationElement) {
					fileName = ((XmlConfigurationElement) config).getFileName();
				} else {
					fileName = UNKNOWN_FILE;
				}

				name = EMFModelValidationPlugin.getMessage(
						NO_NAME,
						new Object[] { fileName });
			}

			Log.warningMessage(
					EMFModelValidationStatusCodes.CONSTRAINT_NOT_INITED,
					EMFModelValidationStatusCodes.CONSTRAINT_NOT_INITED_MSG,
					new Object[] {
							name,
							REASON_NO_ID, });
		} else {
			IConstraintDescriptor constraint = ConstraintRegistry.getInstance().getDescriptor(
					contributorId,
					id);

			if (constraint == null) {
				// why wasn't it already created?
				try {
					constraint = new XmlConstraintDescriptor(config);
				} catch (ConstraintExistsException e) {
					// shouldn't happen because I checked for existence.
					// Just leave 'constraint' null to skip it
				}
			}

			if (constraint instanceof IXmlConstraintDescriptor) {
				IXmlConstraintDescriptor xmlConstraint = (IXmlConstraintDescriptor) constraint;

				xmlConstraint.resolveTargetTypes(getNamespaceUris());

				IModelConstraint proxy = createModelConstraintProxy(xmlConstraint);

				result = proxy;

				Trace.trace(
						EMFModelValidationDebugOptions.PROVIDERS,
						"Added constraint proxy: " + constraint); //$NON-NLS-1$
			}
		}
		
		return result;
	}
}
