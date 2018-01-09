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
package org.eclipse.papyrus.uml.types.core.advices.applystereotype;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.uml.types.core.Activator;
import org.eclipse.papyrus.uml.types.core.requests.ApplyStereotypeRequest;
import org.eclipse.papyrus.uml.types.core.requests.SetStereotypeValueRequest;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * advice for the {@link ApplyStereotypeAdviceConfiguration}
 */
public class ApplyStereotypeAdviceEditHelperAdvice extends AbstractEditHelperAdvice {


	protected ApplyStereotypeAdviceConfiguration configuration;


	public ApplyStereotypeAdviceEditHelperAdvice(ApplyStereotypeAdviceConfiguration configuration) {
		this.configuration = configuration;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		if (request instanceof CreateElementRequest) {
			if (configuration == null) {
				return false;
			}
			if (!(((CreateElementRequest) request).getContainer() instanceof Element)) {
				return false;
			}
			Element container = (Element) ((CreateElementRequest) request).getContainer();
			Package nearestPackage = container.getNearestPackage();
			if (nearestPackage == null) {
				return false;
			}
			List<Profile> appliedProfiles = nearestPackage.getAllAppliedProfiles();
			if (appliedProfiles == null) {
				// no profiles applied, no stereotype can be applied
				return false;
			}
			List<String> appliedProfileNames = new ArrayList<String>();
			for (Profile profile : appliedProfiles) {
				appliedProfileNames.add(profile.getQualifiedName());
			}
			for (StereotypeToApply stereotypeToApply : configuration.getStereotypesToApply()) {
				List<String> requiredProfiles = stereotypeToApply.getRequiredProfiles();
				if (requiredProfiles != null) {
					for (String requiredProfile : requiredProfiles) {
						if (!appliedProfileNames.contains(requiredProfile)) {
							return false;
						}
					}
				}
			}
			return true;
		}

		return true;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		if (configuration == null) {
			return null;
		}
		ICommand resultCommand = null;
		// retrieve eobject
		EObject elementToConfigure = request.getElementToConfigure();
		if (!(elementToConfigure instanceof Element)) {
			return null;
		}

		TransactionalEditingDomain editingDomain = request.getEditingDomain();
		if (editingDomain == null) {
			return null;
		}
		// retrieve edit service to get features from configure command
		IElementEditService service = ElementEditServiceUtils.getCommandProvider(elementToConfigure);
		if (service == null) {
			Activator.log.error("Impossible to get edit service from element: " + elementToConfigure, null);
			return null;
		}

		// for each stereotype, apply stereotype and apply values
		for (StereotypeToApply stereotypeToApply : configuration.getStereotypesToApply()) {
			Stereotype stereotype = ((Element) elementToConfigure).getApplicableStereotype(stereotypeToApply.getStereotypeQualifiedName());

			if (stereotype != null) {

				ICommand applyStereotypeCommand = service.getEditCommand(new ApplyStereotypeRequest((Element) elementToConfigure, stereotype, editingDomain));

				if (resultCommand == null) {
					resultCommand = applyStereotypeCommand;
				} else {
					resultCommand = resultCommand.compose(applyStereotypeCommand);
				}

				if (stereotypeToApply.isUpdateName() && elementToConfigure instanceof NamedElement) {
					if (((NamedElement) elementToConfigure).getNamespace() != null) {
						String newName = NamedElementUtil.getDefaultNameWithIncrementFromBase(stereotype.getName(), ((NamedElement) elementToConfigure).getNamespace().getMembers());
						ICommand renameCommand = service.getEditCommand(new SetRequest(editingDomain, elementToConfigure, UMLPackage.eINSTANCE.getNamedElement_Name(), newName));

						if (resultCommand == null) {
							resultCommand = renameCommand;
						} else {
							resultCommand = resultCommand.compose(renameCommand);
						}
					}
				}

				// Set values
				for (FeatureToSet featureToSet : stereotypeToApply.getFeaturesToSet()) {
					// retrieve feature value
					ICommand command = getSetStereotypeFeatureValueCommand((Element) elementToConfigure, stereotype, featureToSet.getFeatureName(), featureToSet.getValue(), service, request);
					if (command != null) {
						if (resultCommand == null) {
							resultCommand = command;
						} else {
							resultCommand = resultCommand.compose(command);
						}
					}
				}
			}

		}

		if (resultCommand != null) {
			return resultCommand.reduce();
		}
		return super.getAfterConfigureCommand(request);
	}

	/**
	 * @param elementToConfigure
	 *            the eobject to configure
	 * @param name
	 *            the name of the feature to set
	 * @param value
	 *            the new value of the feature
	 */
	protected ICommand getSetStereotypeFeatureValueCommand(Element elementToConfigure, Stereotype stereotype, String name, FeatureValue featureValue, IElementEditService service, ConfigureRequest configureRequest) {
		if (name == null) {
			Activator.log.debug("No feature name has been set.");
			return null;
		}
		if (elementToConfigure.eClass() == null) {
			Activator.log.error("Impossible to find EClass from EObject: " + elementToConfigure, null);
			return null;
		}

		if (configureRequest.getEditingDomain() == null) {
			return null;
		}

		// retrieve structural feature for the element to configure
		TypedElement typedElement = (TypedElement) stereotype.getMember(name, true, UMLPackage.eINSTANCE.getTypedElement());
		if (typedElement == null) {
			Activator.log.error("Impossible to find feature " + name + " for eobject " + elementToConfigure, null);
			return null;
		}
		Object value = getStereotypeValue(elementToConfigure, stereotype, typedElement.getType(), featureValue);

		return service.getEditCommand(new SetStereotypeValueRequest(configureRequest.getEditingDomain(), stereotype, (Element) elementToConfigure, name, value));
	}


	/**
	 * @param elementToConfigure
	 * @param stereotype
	 * @param feature
	 * @param featureValue
	 * @return
	 */
	protected Object getStereotypeValue(Element elementToConfigure, Stereotype stereotype, Type type, FeatureValue featureValue) {
		return StereotypeFeatureValueUtils.getValue(elementToConfigure, stereotype, type, featureValue);
	}
}
