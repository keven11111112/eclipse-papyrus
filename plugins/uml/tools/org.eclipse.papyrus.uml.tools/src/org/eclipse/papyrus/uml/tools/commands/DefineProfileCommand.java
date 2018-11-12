/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST, Christian W. Damus, and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 451613
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Bug 447665
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.papyrus.uml.tools.profile.definition.PapyrusDefinitionAnnotation;
import org.eclipse.papyrus.uml.tools.profile.definition.ProfileRedefinition;
import org.eclipse.papyrus.uml.tools.util.IPapyrusProfileDefinition;
import org.eclipse.papyrus.uml.tools.utils.ProfileUtil;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.Profile2EPackageConverter;
import org.eclipse.uml2.uml.util.UMLUtil.UML2EcoreConverter;

/**
 * This command is used to define a profile
 *
 * @author Vincent Lorenzo
 * @since 4.2
 */
public class DefineProfileCommand extends RecordingCommand {

	/** The Constant COMMAND_LABEL. */
	private static final String COMMAND_LABEL = "Define Profile Command";

	/**
	 * the {@link PapyrusDefinitionAnnotation}
	 */
	private IPapyrusProfileDefinition papyrusAnnotation;

	/**
	 * the profile to define
	 */
	private Profile rootProfile;


	/**
	 * Instantiates a new define profile command.
	 *
	 * @param domain
	 *            the domain
	 * @param papyrusAnnotation
	 *            the papyrus annotation
	 * @param rootProfile
	 *            the root profile
	 */
	public DefineProfileCommand(final TransactionalEditingDomain domain, final IPapyrusProfileDefinition papyrusAnnotation, final Profile rootProfile) {
		super(domain, COMMAND_LABEL, null);
		this.rootProfile = rootProfile;
		this.papyrusAnnotation = papyrusAnnotation;
	}


	/**
	 * Define this package if it is a profile and its sub-profiles
	 *
	 * @param thePackage
	 *            the package to define (if it is a profile)
	 */
	public static List<EPackage> defineProfiles(Package thePackage, boolean saveConstraintInDef) {
		Map<String, String> options = new HashMap<>();

		options.put(UML2EcoreConverter.OPTION__ECORE_TAGGED_VALUES, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__DERIVED_FEATURES, UMLUtil.OPTION__REPORT);
		options.put(UML2EcoreConverter.OPTION__DUPLICATE_FEATURE_INHERITANCE, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__DUPLICATE_FEATURES, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__DUPLICATE_OPERATIONS, UMLUtil.OPTION__REPORT);
		options.put(UML2EcoreConverter.OPTION__DUPLICATE_OPERATION_INHERITANCE, UMLUtil.OPTION__REPORT);
		options.put(UML2EcoreConverter.OPTION__REDEFINING_OPERATIONS, UMLUtil.OPTION__REPORT);
		options.put(UML2EcoreConverter.OPTION__REDEFINING_PROPERTIES, UMLUtil.OPTION__REPORT);
		options.put(UML2EcoreConverter.OPTION__SUBSETTING_PROPERTIES, UMLUtil.OPTION__REPORT);
		options.put(UML2EcoreConverter.OPTION__UNION_PROPERTIES, UMLUtil.OPTION__PROCESS);
		options.put(UML2EcoreConverter.OPTION__SUPER_CLASS_ORDER, UMLUtil.OPTION__REPORT);
		options.put(UML2EcoreConverter.OPTION__ANNOTATION_DETAILS, UMLUtil.OPTION__REPORT);

		// Generate constraints for the validation
		String handleConstraints = saveConstraintInDef ? UMLUtil.OPTION__PROCESS : UMLUtil.OPTION__IGNORE;
		options.put(UML2EcoreConverter.OPTION__INVARIANT_CONSTRAINTS, handleConstraints);
		options.put(UML2EcoreConverter.OPTION__VALIDATION_DELEGATES, handleConstraints);
		options.put(UML2EcoreConverter.OPTION__INVOCATION_DELEGATES, handleConstraints);
		options.put(UML2EcoreConverter.OPTION__OPERATION_BODIES, handleConstraints);
		//

		options.put(UML2EcoreConverter.OPTION__COMMENTS, UMLUtil.OPTION__IGNORE);
		options.put(Profile2EPackageConverter.OPTION__FOREIGN_DEFINITIONS, UMLUtil.OPTION__PROCESS);

		options.put(UML2EcoreConverter.OPTION__UNTYPED_PROPERTIES, UMLUtil.OPTION__PROCESS); // Closer to the UML semantics of untyped properties

		List<Profile> toDefine = new ArrayList<>();
		for (TreeIterator<EObject> all = UML2Util.getAllContents(thePackage, true, false); all.hasNext();) {
			EObject next = all.next();
			if (next instanceof Profile) {
				toDefine.add((Profile) next);
			} else if (!(next instanceof Package)) {
				all.prune();
			}
		}

		if (toDefine.size() > 1) {
			// Sort the profiles in dependency order: used profiles ahead of the profiles that use them. This ensures that
			// Ecore definitions are available for reference in the 4.1.0-style annotations instead of 4.0.0-style
			ProfileUtil.sortProfiles(toDefine);
		}

		List<EPackage> result = new ArrayList<>(toDefine.size());
		for (Profile next : toDefine) {
			result.add(next.define(options, null, null));
		}

		return result;
	}


	/**
	 * Post validate.
	 *
	 * @param profileDefinitions
	 *            the profile definitions
	 * @return the i status
	 * @throws ExecutionException
	 *             the execution exception
	 */
	protected IStatus postValidate(List<EPackage> profileDefinitions) throws ExecutionException {

		EditingDomain domain = EMFHelper.resolveEditingDomain(rootProfile);
		AdapterFactory adapterFactory = domain instanceof AdapterFactoryEditingDomain ? ((AdapterFactoryEditingDomain) domain).getAdapterFactory() : null;
		Diagnostician diagnostician = createDiagnostician(adapterFactory, new NullProgressMonitor());
		diagnostic = diagnostician.createDefaultDiagnostic(rootProfile);
		Map<Object, Object> context = diagnostician.createDefaultContext();

		for (EPackage ePackage : profileDefinitions) {
			diagnostician.validate(ePackage, diagnostic, context);
		}

		if (diagnostic.getSeverity() == Diagnostic.ERROR) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The defined profile is invalid");
		}

		if (diagnostic.getSeverity() == Diagnostic.WARNING) {
			return new Status(IStatus.WARNING, Activator.PLUGIN_ID, "The profile has been successfully defined");
		}

		return Status.OK_STATUS;
	}

	protected BasicDiagnostic diagnostic;

	public Diagnostic getDiagnostic() {
		return diagnostic;
	}

	/**
	 * Creates the diagnostician.
	 *
	 * @param adapterFactory
	 *            the adapter factory
	 * @param progressMonitor
	 *            the progress monitor
	 * @return the diagnostician
	 */
	protected Diagnostician createDiagnostician(final AdapterFactory adapterFactory, final IProgressMonitor progressMonitor) {
		return new Diagnostician() {

			@Override
			public String getObjectLabel(EObject eObject) {
				if (adapterFactory != null && !eObject.eIsProxy()) {
					IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory.adapt(eObject, IItemLabelProvider.class);
					if (itemLabelProvider != null) {
						return itemLabelProvider.getText(eObject);
					}
				}
				return super.getObjectLabel(eObject);
			}

			@Override
			public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
				progressMonitor.worked(1);
				return super.validate(eClass, eObject, diagnostics, context);
			}
		};
	}


	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 *
	 */
	@Override
	protected void doExecute() {

		List<EPackage> profileDefinitions = defineProfiles(rootProfile, papyrusAnnotation.saveConstraintDefinition());

		ProfileRedefinition.redefineProfile(rootProfile, papyrusAnnotation.getPapyrusAnnotation());
		ProfileRedefinition.cleanProfile(rootProfile);
		try {
			postValidate(profileDefinitions);
		} catch (ExecutionException e) {
			Activator.log.error(e);
		}


	}
}
