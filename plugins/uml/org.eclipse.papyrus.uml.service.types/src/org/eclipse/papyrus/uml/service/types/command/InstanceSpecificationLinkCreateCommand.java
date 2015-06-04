/**
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.service.types.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.services.edit.utils.ElementTypeUtils;
import org.eclipse.papyrus.infra.services.edit.utils.RequestParameterConstants;
import org.eclipse.papyrus.uml.service.types.Activator;
import org.eclipse.papyrus.uml.service.types.helper.advice.InstanceSpecificationEditHelperAdvice;
import org.eclipse.papyrus.uml.service.types.ui.AssociationSelectionDialog;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

public class InstanceSpecificationLinkCreateCommand extends ConfigureElementCommand {

	protected  InstanceSpecification source=null;

	protected  InstanceSpecification target=null;

	protected HashSet<Association> commonAssociations;
	protected boolean useUI=true;

	protected static final String INSTANCE_END = "InstanceEnd";//

	public InstanceSpecificationLinkCreateCommand(ConfigureRequest request) {
		super(request);
		if(request.getParameter(CreateRelationshipRequest.SOURCE)instanceof InstanceSpecification){
			source=(InstanceSpecification)request.getParameter(CreateRelationshipRequest.SOURCE);
		}
		if(request.getParameter(CreateRelationshipRequest.TARGET)instanceof InstanceSpecification){
			target=(InstanceSpecification)request.getParameter(CreateRelationshipRequest.TARGET);
		}
		useUI=ElementTypeUtils.useGUI(request);
	}

	/**
	 *
	 * @param instance
	 *            link where instance end end are look for
	 * @return a list of two elements that are instance specfication : ends of this instance Link
	 *         if this is not an instance link : the size of the array list is 0
	 */
	protected List<InstanceSpecification> getEnds(InstanceSpecification instance) {
		List<InstanceSpecification> array = new ArrayList<InstanceSpecification>();
		EAnnotation endtypes = instance.getEAnnotation(INSTANCE_END);
		if (endtypes != null) {
			assert (endtypes.getReferences().size() == 2);
			array.add((InstanceSpecification) endtypes.getReferences().get(0));
			array.add((InstanceSpecification) endtypes.getReferences().get(1));
		}
		return array;
	}

	/**
	 * add an end in the instancespecification link by adding a eannotation if not exist
	 *
	 * @param instanceLink
	 * @param end
	 *            to add
	 */
	protected void addEnd(InstanceSpecification instanceLink, InstanceSpecification end) {
		EAnnotation endtypes = instanceLink.getEAnnotation(INSTANCE_END);
		if (endtypes == null) {
			endtypes = instanceLink.createEAnnotation(INSTANCE_END);
		}
		endtypes.getReferences().add(end);
	}

	/**
	 * remove an end in the instance specification link by adding a eannotation if not exist
	 *
	 * @param instanceLink
	 * @param end
	 *            to add
	 */
	protected void removeEnd(InstanceSpecification instanceLink, InstanceSpecification end) {
		EAnnotation endtypes = instanceLink.getEAnnotation(INSTANCE_END);
		if (endtypes == null) {
			endtypes = instanceLink.createEAnnotation(INSTANCE_END);
		}
		endtypes.getReferences().remove(end);
	}

	@Override
	public boolean canExecute() {
		return InstanceSpecificationEditHelperAdvice.canCreate(source, target);
	}

	/**
	 * Gets the instance associations.
	 *
	 * @param instance
	 *            the instance
	 * @return the instance associations
	 */
	private HashSet<Association> getInstanceAssociations(InstanceSpecification instance) {
		// Initialise set of associations
		HashSet<Association> instanceAssociationsSet = new HashSet<Association>();
		// Extract all associations of Instance Specification's classifiers
		Iterator<Classifier> iterator = getSpecificationClassifier(instance).iterator();
		while (iterator.hasNext()) {
			Classifier classifier = iterator.next();
			instanceAssociationsSet.addAll(classifier.getAssociations());
		}
		return instanceAssociationsSet;
	}

	/**
	 * Gets the specification classifiers.
	 *
	 * @param instance
	 *            the instance
	 * @return the specification classifiers
	 */
	private Set<Classifier> getSpecificationClassifier(InstanceSpecification instance) {
		// Initialise Set of Classifiers
		Set<Classifier> specificationClassicfiersSet = new HashSet<Classifier>();
		// Explore first rank classifiers
		for (Classifier classifier : instance.getClassifiers()) {

			// Explore only Classifier which are not already in Set
			if (!specificationClassicfiersSet.contains(classifier)) {
				specificationClassicfiersSet.add(classifier);
				specificationClassicfiersSet.addAll(getInheritedClassifier(classifier, null));
			}
		}
		return specificationClassicfiersSet;
	}

	/**
	 * Gets the inherited classifier.
	 *
	 * @param classifier
	 *            the classifier
	 * @return the inherited classifier
	 */
	private Set<Classifier> getInheritedClassifier(Classifier classifier, Set<Classifier> alreadyParsedClassifier) {


		// Initialise set of Classifier from Generalisation
		Set<Classifier> generalizationClassifiers = new HashSet<Classifier>();


		// Keep track of parsed Classifier to avoid loop
		Set<Classifier> parsedClassifiersSet = new HashSet<Classifier>();
		if (alreadyParsedClassifier != null) {
			parsedClassifiersSet.addAll(alreadyParsedClassifier);
		}

		// Explore only Classifier which are not already parsed
		if (!parsedClassifiersSet.contains(classifier)) {
			parsedClassifiersSet.add(classifier);

			// Explore all generalisation of Classifier
			EList<Classifier> classifierGeneralizations = classifier.parents();
			generalizationClassifiers.addAll(classifierGeneralizations);

			for (Classifier generalClassifier : classifierGeneralizations) {
				generalizationClassifiers.addAll(getInheritedClassifier(generalClassifier, parsedClassifiersSet));
			}
		}

		return generalizationClassifiers;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(useUI){
			if (((InstanceSpecification) source).getClassifiers().isEmpty() || ((InstanceSpecification) target).getClassifiers().isEmpty()) {
				return CommandResult.newOKCommandResult(getElementToEdit());
			}
			ServicesRegistry registry;
			try {
				registry = ServiceUtilsForResource.getInstance().getServiceRegistry(source.eResource());
			} catch (ServiceException e) {
				Activator.log.error(e);
				return CommandResult.newOKCommandResult(getElementToEdit());
			}
			AssociationSelectionDialog associationSelectionDialog = new AssociationSelectionDialog(new Shell(), SWT.NATIVE, getModelAssociations(), registry);
			associationSelectionDialog.open();
			Association selectedAssociation = associationSelectionDialog.getSelectedAssociation();
			if (selectedAssociation == null && associationSelectionDialog.isCanceled()) {
				return CommandResult.newOKCommandResult(getElementToEdit());
			}
			/*
			 * Creation of the instance specification link
			 * with a name a container, and set the source and target
			 */
			InstanceSpecification instanceSpecification=(InstanceSpecification)getElementToEdit();
			Set<Classifier> sourceSpecificationClassifiersSet = getSpecificationClassifier((InstanceSpecification) source);
			Set<Classifier> targetSpecificationClassifiersSet = getSpecificationClassifier((InstanceSpecification) target);
			boolean revertEnds = false;
			if (selectedAssociation != null) {
				instanceSpecification.getClassifiers().add(selectedAssociation);
				Type sourceType = selectedAssociation.getMemberEnds().get(0).getType();
				revertEnds = false == sourceSpecificationClassifiersSet.contains(sourceType);
			}
			if (revertEnds) {
				addEnd(instanceSpecification, ((InstanceSpecification) target));
				addEnd(instanceSpecification, ((InstanceSpecification) source));
			} else {
				addEnd(instanceSpecification, ((InstanceSpecification) source));
				addEnd(instanceSpecification, ((InstanceSpecification) target));
			}
			setupSlots(selectedAssociation, instanceSpecification, sourceSpecificationClassifiersSet, targetSpecificationClassifiersSet);
			return CommandResult.newOKCommandResult(instanceSpecification);
		}
		return CommandResult.newOKCommandResult(getElementToEdit());
	}

	private void setupSlots(Association selectedAssociation, InstanceSpecification instanceSpecification, Set<Classifier> sourceSpecificationClassifiersSet, Set<Classifier> targetSpecificationClassifiersSet) {
		if (selectedAssociation == null) {
			return;
		}
		// Creation of slots into the good instance by taking in account the association
		Iterator<Property> proIterator = selectedAssociation.getMemberEnds().iterator();
		while (proIterator.hasNext()) {
			Property property = proIterator.next();
			Slot slot = UMLFactory.eINSTANCE.createSlot();
			slot.setDefiningFeature(property);
			if (sourceSpecificationClassifiersSet.contains(property.getOwner())) {
				((InstanceSpecification) source).getSlots().add(slot);
				associateValue(((InstanceSpecification) target), slot, property.getType());
			} else if (targetSpecificationClassifiersSet.contains(property.getOwner())) {
				((InstanceSpecification) target).getSlots().add(slot);
				associateValue(((InstanceSpecification) source), slot, property.getType());
			} else {
				instanceSpecification.getSlots().add(slot);
				if (sourceSpecificationClassifiersSet.contains(property.getType())) {
					associateValue(((InstanceSpecification) source), slot, property.getType());
				} else {
					associateValue(((InstanceSpecification) target), slot, property.getType());
				}
			}
		}
	}

	private Set<Association> getModelAssociations() {
		if (source == null || target == null) {
			return Collections.emptySet();
		}
		if (false == source instanceof InstanceSpecification || false == target instanceof InstanceSpecification) {
			return Collections.emptySet();
		}
		Set<Association> result = new HashSet<Association>();
		result.addAll(getInstanceAssociations((InstanceSpecification) source));
		result.retainAll(getInstanceAssociations((InstanceSpecification) target));
		return result;
	}



	/**
	 * create an instanceValue for the slot (owner) with the reference to InstanceSpecification and the good type
	 *
	 * @param instanceSpecification
	 *            that is referenced by the instanceValue
	 * @param owner
	 *            of the instance value
	 * @param type
	 *            of the instanceValue
	 * @return a instanceValue
	 */
	protected InstanceValue associateValue(InstanceSpecification instanceSpecification, Slot owner, Type type) {
		InstanceValue instanceValue = UMLFactory.eINSTANCE.createInstanceValue();
		instanceValue.setName(NamedElementUtil.getDefaultNameWithIncrementFromBase(instanceValue.eClass().getName(), owner.eContents()));
		instanceValue.setType(type);
		instanceValue.setInstance(instanceSpecification);
		owner.getValues().add(instanceValue);
		return instanceValue;
	}

	@Override
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	protected Constraint getSource() {
		return (Constraint) source;
	}

	protected Namespace getTarget() {
		return (Namespace) target;
	}
}
