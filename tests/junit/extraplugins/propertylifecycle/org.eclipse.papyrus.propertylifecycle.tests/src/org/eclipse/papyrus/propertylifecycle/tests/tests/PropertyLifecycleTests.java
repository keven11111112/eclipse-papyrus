/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.propertylifecycle.tests.tests;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.propertylifecycle.tests.Activator;
import org.eclipse.papyrus.propertylifecycle.tests.utils.ITestConstants;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.NamedElement;

public class PropertyLifecycleTests extends AbstractPropertyLifecycleTests implements ITestConstants {

	public static ICommand createCommand;

	public static EObject newElement;

	public static String SysmlProfile_URI = "http://www.eclipse.org/papyrus/0.7.0/SysML/Blocks";

	// @Test
	// public void testInitialization() {
	// Assert.assertTrue(true);
	// }

	// @Test
	// public void testCreateSysML14BlockInModel() throws ExecutionException {
	// IElementType blockType = ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.SysML14.Block");
	// Profile sysml14Profile = ProfileUtil.getProfile(org.eclipse.papyrus.sysml14.definition.SysmlPackage.eINSTANCE);
	// subModel.applyProfile(sysml14Profile);
	// Assert.assertTrue("The sysml14 profile should be applied to the subModel", subModel.getAllAppliedProfiles().contains(sysml14Profile));
	// createElementInPackage(subModel, blockType);
	// Assert.assertTrue("The new element should be a Block", newElement instanceof org.eclipse.papyrus.SysML14.Block);
	// String newName = ((NamedElement) newElement).getName();
	// Activator.log.trace(Activator.PLCSTRATEGY_TESTS_TRACE, newName);
	// Assert.assertTrue("The name of the new Componenet should be NewSysml14BlockName",
	// "NewSysml14BlockName".equalsIgnoreCase(((NamedElement) newElement).getName().replaceAll("[0-9]", "")));
	// createCommand.undo(monitor, null);
	// subModel.unapplyProfile(sysml14Profile);
	// }

	@Test
	public void testCreateComponentInPackage() throws ExecutionException {
		IElementType componentType = ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Component");
		Assert.assertTrue("componentPackage is instanceof Package", componentPackage instanceof Package);
		createElementInPackage(componentPackage, componentType);
		Assert.assertTrue("The new element should be a Component", newElement instanceof Component);
		String newName = ((NamedElement) newElement).getName();
		Activator.log.trace(Activator.PLCSTRATEGY_TESTS_TRACE, newName);
		Assert.assertTrue("The name of the new Componenet should be NewComponentName",
				"NewComponentName".equalsIgnoreCase(newName.replaceAll("[0-9]", "")));
		createCommand.undo(monitor, null);
	}

	@Test
	public void testCreateComponentInModel() throws ExecutionException {
		IElementType componentType = ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Component");
		createElementInPackage(subModel, componentType);
		Assert.assertTrue("The new element should be a Component", newElement instanceof Component);
		String newName = ((NamedElement) newElement).getName();
		Activator.log.trace(Activator.PLCSTRATEGY_TESTS_TRACE, newName);
		Assert.assertTrue("The name of the new Componenet should be NewComponentName",
				"NewComponentName".equalsIgnoreCase(((NamedElement) newElement).getName().replaceAll("[0-9]", "")));
		createCommand.undo(monitor, null);
	}

	@Test
	public void testCreateClassInPackage() throws ExecutionException {
		IElementType componentType = ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Class");
		Assert.assertTrue("classPackage is instanceof Package", classPackage instanceof Package);
		createElementInPackage(componentPackage, componentType);
		Assert.assertTrue("The new element should be a Class", newElement instanceof org.eclipse.uml2.uml.Class);
		String newName = ((NamedElement) newElement).getName();
		Activator.log.trace(Activator.PLCSTRATEGY_TESTS_TRACE, newName);
		Assert.assertTrue("The name of the new Class should be Class",
				"Class".equalsIgnoreCase(newName.replaceAll("[0-9]", "")));
		createCommand.undo(monitor, null);
	}

	@Test
	public void testCreateClassInModel() throws ExecutionException {
		IElementType componentType = ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Class");
		createElementInPackage(subModel, componentType);
		Assert.assertTrue("The new element should be a Class", newElement instanceof org.eclipse.uml2.uml.Class);
		String newName = ((NamedElement) newElement).getName();
		Activator.log.trace(Activator.PLCSTRATEGY_TESTS_TRACE, newName);
		Assert.assertTrue("The name of the new Class should be NewClassName",
				"NewClassName".equalsIgnoreCase(((NamedElement) newElement).getName().replaceAll("[0-9]", "")));
		createCommand.undo(monitor, null);
	}

	@Test
	public void testCreateSysmlBlockInModel() throws ExecutionException {
		IElementType blockType = ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.sysml.Block");
		Assert.assertTrue("The sysml profile should be applied to the subModel", subModel.getAllAppliedProfiles().size() > 0);
		createElementInPackage(subModel, blockType);
		Stereotype blockStereotype = null;
		for (Profile appliedProfile : subModel.getAppliedProfiles()) {
			if (appliedProfile.getURI() != null && appliedProfile.getURI().compareTo(SysmlProfile_URI) == 0) {
				blockStereotype = appliedProfile.getOwnedStereotype("Block", true);
				break;
			}
		}

		Assert.assertTrue("The new element should be a block", ((NamedElement) newElement).isStereotypeApplied(blockStereotype));
		String newName = ((NamedElement) newElement).getName();
		Activator.log.trace(Activator.PLCSTRATEGY_TESTS_TRACE, newName);
		Assert.assertTrue("The name of the new Componenet should be NewSysmlBlockName",
				"NewSysmlBlockName".equalsIgnoreCase(((NamedElement) newElement).getName().replaceAll("[0-9]", "")));
		createCommand.undo(monitor, null);
	}


	@Test
	public void testCreatePropertyInComponent() throws ExecutionException {
		IElementType propertyType = ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Property");
		createPropertyInClassifier((Classifier) component_ComponentPacakge, propertyType);
		Assert.assertTrue("The new element should be a Component", newElement instanceof Property);
		String newName = ((NamedElement) newElement).getName();
		Activator.log.trace(Activator.PLCSTRATEGY_TESTS_TRACE, newName);
		Assert.assertTrue("The name of the new Componenet should be Attribute",
				"Attribute".equalsIgnoreCase(((NamedElement) newElement).getName().replaceAll("[0-9]", "")));
		createCommand.undo(monitor, null);
	}

	@Test
	public void testCreatePropertyInClass() throws ExecutionException {
		IElementType propertyType = ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Property");
		createPropertyInClassifier((Classifier) class_ClassPackage, propertyType);
		Assert.assertTrue("The new element should be a Component", newElement instanceof Property);
		String newName = ((NamedElement) newElement).getName();
		Activator.log.trace(Activator.PLCSTRATEGY_TESTS_TRACE, newName);
		Assert.assertTrue("The name of the new Componenet should be Attribute",
				"Attribute".equalsIgnoreCase(((NamedElement) newElement).getName().replaceAll("[0-9]", "")));
		createCommand.undo(monitor, null);
	}


	@Test
	public void testRenameContainer() throws ExecutionException {
		EStructuralFeature nameFeature = component_ComponentPacakge.eClass().getEStructuralFeature("name");
		SetRequest request = new SetRequest(transactionalEditingDomain, component_ComponentPacakge, nameFeature, "afterSetComponentName");
		IElementEditService service = ElementEditServiceUtils.getCommandProvider(component_ComponentPacakge);
		ICommand setCommand = service.getEditCommand(request);
		Assert.assertTrue("The set command should be executable", setCommand.canExecute());
		IStatus status = setCommand.execute(monitor, null);
		Assert.assertTrue("The command should return OK", status.isOK());

		// 1- Verify that the set command did work
		Assert.assertTrue("The component name should be afterSetComponentName",
				"afterSetComponentName".equalsIgnoreCase(component_ComponentPacakge.getName().replaceAll("[0-9]", "")));

		// 2- Verify that the property strategy worked as excpected
		Property componentProperty = component_ComponentPacakge.getAttributes().get(0);
		Assert.assertTrue("The component's property name should be afterSetComponentName",
				"afterSetComponentName_Property".equalsIgnoreCase(componentProperty.getName().replaceAll("[0-9]", "")));

		// 3- Test the Undo/Redo
		Assert.assertTrue("The set command should be undoable", setCommand.canUndo());
		status = setCommand.undo(monitor, null);
		Assert.assertTrue("The undo status should return OK", status.isOK());
		Assert.assertTrue("The component name should be beforeStrategyComponent",
				"beforeStrategyComponent".equalsIgnoreCase(component_ComponentPacakge.getName().replaceAll("[0-9]", "")));
		Assert.assertTrue("The component's property name should be beforeStrategyComponentProperty",
				"beforeStrategyComponentProperty".equalsIgnoreCase(componentProperty.getName().replaceAll("[0-9]", "")));

		Assert.assertTrue("The set command should be redoable", setCommand.canRedo());
		status = setCommand.redo(monitor, null);
		Assert.assertTrue("The redo status should return OK", status.isOK());
		Assert.assertTrue("The component name should be afterSetComponentName",
				"afterSetComponentName".equalsIgnoreCase(component_ComponentPacakge.getName().replaceAll("[0-9]", "")));
		Assert.assertTrue("The component's property name should be afterSetComponentName",
				"afterSetComponentName_Property".equalsIgnoreCase(componentProperty.getName().replaceAll("[0-9]", "")));

	}


	@Test
	public void testReorientAssociation() throws ExecutionException {
		IElementType associationType = ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Association");
		IElementType classType = ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Class");
		IElementType componentType = ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Component");
		createElementInPackage(subModel, classType);
		EObject sourceClass = newElement;
		createElementInPackage(subModel, componentType);
		EObject targetComponent = newElement;

		Classifier sourceClassifier = (Classifier) sourceClass;
		List<EObject> originalElements = new ArrayList<EObject>(sourceClassifier.getOwnedElements());

		CreateRelationshipRequest request = new CreateRelationshipRequest(transactionalEditingDomain, sourceClass, targetComponent, associationType);
		IElementEditService service = ElementEditServiceUtils.getCommandProvider(subModel);
		createCommand = service.getEditCommand(request);
		Assert.assertTrue("The created command should be executable", createCommand.canExecute());
		IStatus status = createCommand.execute(monitor, null);
		Assert.assertTrue("The command should return OK", status.isOK());

		List<EObject> afterCreateElements = new ArrayList<EObject>(sourceClassifier.getOwnedElements());
		afterCreateElements.removeAll(originalElements);
		Assert.assertEquals("There should have been two created elements in the source: the owned association "
				+ "and the property pointing to the target", 2, afterCreateElements.size());
		for (EObject eobject : afterCreateElements) {
			newElement = eobject instanceof Association ? eobject : null;
		}
		Assert.assertNotNull("There should have been an Association created", newElement);

		// 2- Test the Undo/Redo
		Assert.assertTrue("The creation command should be undoable", createCommand.canUndo());
		status = createCommand.undo(monitor, null);
		Assert.assertTrue("The undo status should return OK", status.isOK());
		List<EObject> afterUndoElements = new ArrayList<EObject>(sourceClassifier.getOwnedElements());
		afterUndoElements.removeAll(originalElements);
		Assert.assertEquals("The model should return in the same state as before the creation command", 0,
				afterUndoElements.size());

		Assert.assertTrue("The creation command should be redoable", createCommand.canRedo());
		status = createCommand.redo(monitor, null);
		Assert.assertTrue("The redo status should return OK", status.isOK());
		List<EObject> afterRedoElements = new ArrayList<EObject>(sourceClassifier.getOwnedElements());
		afterRedoElements.removeAll(originalElements);
		Assert.assertEquals("There should be one element added afer the redo of the creation command", 2, afterRedoElements.size());

		// 3- Cache the memeberEnds
		Association currentAssociation = (Association) newElement;
		String beforeMoveName = currentAssociation.getLabel();
		Property targetProperty = currentAssociation.getMemberEnds().get(0);
		String targetPropertyName = targetProperty.getType().getName();
		Property sourceProperty = currentAssociation.getMemberEnds().get(1);
		String sourcePropertyName = sourceProperty.getType().getName();

		// 4- Create a new Target and move the relationship
		createElementInPackage(subModel, classType);
		EObject newTarget = newElement;
		ReorientRelationshipRequest reorientRequest = new ReorientRelationshipRequest(transactionalEditingDomain, currentAssociation,
				newTarget, targetComponent, ReorientRelationshipRequest.REORIENT_TARGET);
		createCommand = service.getEditCommand(reorientRequest);
		Assert.assertTrue("The created command should be executable", createCommand.canExecute());
		IStatus reorientStatus = createCommand.execute(monitor, null);
		Assert.assertTrue("The command should return OK", reorientStatus.isOK());
		String afterMoveName = currentAssociation.getLabel();

		// 4.1 - Test the new association name
		Assert.assertFalse("The new association should have a different label after the move", beforeMoveName.equals(afterMoveName));

		// 4.2- Test the new target name
		Association reorientedAssociation = currentAssociation;
		Property reorientTargetProperty = reorientedAssociation.getMemberEnds().get(0);
		String reorientTargetPropertyName = reorientTargetProperty.getType().getName();
		Assert.assertFalse("The name of the target should have changed", reorientTargetPropertyName.equalsIgnoreCase(targetPropertyName));
		Property reorientSourceProperty = reorientedAssociation.getMemberEnds().get(1);
		String reorientSourcePropertyName = reorientSourceProperty.getType().getName();
		Assert.assertTrue("The name of the source should not have changed", reorientSourcePropertyName.equalsIgnoreCase(sourcePropertyName));

	}


	@Test
	public void testRenameImmutableProperty() throws ExecutionException {
		EStructuralFeature nameFeature = property_class_subModel.eClass().getEStructuralFeature("name");
		SetRequest request = new SetRequest(transactionalEditingDomain, property_class_subModel, nameFeature, "afterSetPropertyName");
		IElementEditService service = ElementEditServiceUtils.getCommandProvider(property_class_subModel);
		ICommand setCommand = service.getEditCommand(request);
		Assert.assertTrue("The set command should be executable", setCommand.canExecute());
		IStatus status = setCommand.execute(monitor, null);
		Assert.assertTrue("The command should return OK", status.isOK());

		// 1- Verify that the property strategy worked as excpected
		Assert.assertTrue("The class' property name should be propertyNameIsImmutable",
				"propertyNameIsImmutable".equalsIgnoreCase(property_class_subModel.getName().replaceAll("[0-9]", "")));

		// 2- Test the Undo/Redo
		setCommand.undo(monitor, null);
		Assert.assertTrue("The class' property name should return to beforeStrategyClassProperty",
				"beforeStrategyClassProperty".equalsIgnoreCase(property_class_subModel.getName().replaceAll("[0-9]", "")));

		setCommand.redo(monitor, null);
		Assert.assertTrue("The class' property name should return to propertyNameIsImmutable",
				"propertyNameIsImmutable".equalsIgnoreCase(property_class_subModel.getName().replaceAll("[0-9]", "")));

		// 3- Return to initial state
		setCommand.undo(monitor, null);
		Assert.assertTrue("The class' property name should return to beforeStrategyClassProperty",
				"beforeStrategyClassProperty".equalsIgnoreCase(property_class_subModel.getName().replaceAll("[0-9]", "")));
	}

	@Test
	public void testRenameImmutablePropertyInClass() throws ExecutionException {
		EStructuralFeature nameFeature = class_subModel.eClass().getEStructuralFeature("name");
		CommandStack commandStack = transactionalEditingDomain.getCommandStack();
		commandStack.flush();
		SetRequest request = new SetRequest(transactionalEditingDomain, class_subModel, nameFeature, "afterSetClassName");
		IElementEditService service = ElementEditServiceUtils.getCommandProvider(class_subModel);
		ICommand setCommand = service.getEditCommand(request);
		Assert.assertTrue("The set command should be executable", setCommand.canExecute());
		// The command needs to be executed inside the commandStack first has it has nested commands and the undo on the
		// setCommand will only affect the first setRequest
		commandStack.execute(new GMFtoEMFCommandWrapper(setCommand));

		// 1- Verify that the set command did work
		Assert.assertTrue("The class name should be afterSetClassName",
				"afterSetClassName".equalsIgnoreCase(class_subModel.getName().replaceAll("[0-9]", "")));

		// 2- Verify that the property strategy worked as excpected
		Assert.assertTrue("The class' property name should be propertyNameIsImmutable",
				"propertyNameIsImmutable".equalsIgnoreCase(property_class_subModel.getName().replaceAll("[0-9]", "")));

		// 3- Test the Undo/Redo
		commandStack.undo();
		Assert.assertTrue("The class name should return to beforeStrategyClass",
				"beforeStrategyClass".equalsIgnoreCase(class_subModel.getName().replaceAll("[0-9]", "")));
		Assert.assertTrue("The class' property name should return to beforeStrategyClassProperty",
				"beforeStrategyClassProperty".equalsIgnoreCase(property_class_subModel.getName().replaceAll("[0-9]", "")));

		commandStack.redo();
		Assert.assertTrue("The class name should be afterSetClassName",
				"afterSetClassName".equalsIgnoreCase(class_subModel.getName().replaceAll("[0-9]", "")));
		Assert.assertTrue("The class' property name should return to propertyNameIsImmutable",
				"propertyNameIsImmutable".equalsIgnoreCase(property_class_subModel.getName().replaceAll("[0-9]", "")));

		// 4- Return to initial state
		commandStack.undo();

	}


	public void createPropertyInClassifier(Classifier container, IElementType elementType) throws ExecutionException {
		List<EObject> originalElements = new ArrayList<EObject>(container.getAttributes());
		CreateElementRequest request = new CreateElementRequest(transactionalEditingDomain, container, elementType);
		IElementEditService service = ElementEditServiceUtils.getCommandProvider(container);
		createCommand = service.getEditCommand(request);
		Assert.assertTrue("The created command should be executable", createCommand.canExecute());
		IStatus status = createCommand.execute(monitor, null);
		Assert.assertTrue("The command should return OK", status.isOK());

		List<EObject> afterCreateElements = new ArrayList<EObject>(container.getAttributes());
		afterCreateElements.removeAll(originalElements);
		Assert.assertEquals("There should have been only one created element", 1, afterCreateElements.size());

		// 2- Test the Undo/Redo
		assertUndoRedo(status, originalElements, container);

	}

	public void createElementInPackage(Package container, IElementType elementType) throws ExecutionException {
		// 1- Test the Creation of the new element
		List<EObject> originalElements = new ArrayList<EObject>(container.getPackagedElements());
		CreateElementRequest request = new CreateElementRequest(transactionalEditingDomain, container, elementType);
		IElementEditService service = ElementEditServiceUtils.getCommandProvider(container);
		createCommand = service.getEditCommand(request);
		Assert.assertTrue("The created command should be executable", createCommand.canExecute());
		IStatus status = createCommand.execute(monitor, null);
		Assert.assertTrue("The command should return OK", status.isOK());

		List<EObject> afterCreateElements = new ArrayList<EObject>(container.getPackagedElements());
		afterCreateElements.removeAll(originalElements);
		Assert.assertEquals("There should have been only one created element", 1, afterCreateElements.size());

		// 2- Test the Undo/Redo
		assertUndoRedo(status, originalElements, container);

	}

	public static void assertUndoRedo(IStatus status, List<EObject> originalElements, Classifier container) throws ExecutionException {
		Assert.assertTrue("The creation command should be undoable", createCommand.canUndo());
		status = createCommand.undo(monitor, null);
		Assert.assertTrue("The undo status should return OK", status.isOK());
		List<EObject> afterUndoElements = new ArrayList<EObject>(container.getAttributes());
		afterUndoElements.removeAll(originalElements);
		Assert.assertEquals("The model should return in the same state as before the creation command", 0,
				afterUndoElements.size());

		Assert.assertTrue("The creation command should be redoable", createCommand.canRedo());
		status = createCommand.redo(monitor, null);
		Assert.assertTrue("The redo status should return OK", status.isOK());
		List<EObject> afterRedoElements = new ArrayList<EObject>(container.getAttributes());
		afterRedoElements.removeAll(originalElements);
		Assert.assertEquals("There should be one element added afer the redo of the creation command", 1, afterRedoElements.size());
		newElement = afterRedoElements.get(0);
	}

	public static void assertUndoRedo(IStatus status, List<EObject> originalElements, Package container) throws ExecutionException {
		Assert.assertTrue("The creation command should be undoable", createCommand.canUndo());
		status = createCommand.undo(monitor, null);
		Assert.assertTrue("The undo status should return OK", status.isOK());
		List<EObject> afterUndoElements = new ArrayList<EObject>(container.getPackagedElements());
		afterUndoElements.removeAll(originalElements);
		Assert.assertEquals("The model should return in the same state as before the creation command", 0,
				afterUndoElements.size());

		Assert.assertTrue("The creation command should be redoable", createCommand.canRedo());
		status = createCommand.redo(monitor, null);
		Assert.assertTrue("The redo status should return OK", status.isOK());
		List<EObject> afterRedoElements = new ArrayList<EObject>(container.getPackagedElements());
		afterRedoElements.removeAll(originalElements);
		Assert.assertEquals("There should be one element added afer the redo of the creation command", 1, afterRedoElements.size());
		newElement = afterRedoElements.get(0);
	}

}
