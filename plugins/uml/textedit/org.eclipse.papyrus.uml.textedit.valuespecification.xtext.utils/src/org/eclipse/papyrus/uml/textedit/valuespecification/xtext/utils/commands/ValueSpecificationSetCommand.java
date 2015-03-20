/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.utils.commands;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.services.validation.commands.AbstractValidateCommand;
import org.eclipse.papyrus.infra.services.validation.commands.AsyncValidateSubtreeCommand;
import org.eclipse.papyrus.uml.service.validation.UMLDiagnostician;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralBooleanRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralIntegerOrUnlimitedNaturalRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralNullRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralRealRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralStringRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.utils.Activator;
import org.eclipse.papyrus.uml.xtext.integration.XtextFakeResourceContext;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProvider;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProviderWithInit;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Injector;

/**
 * This class allow to create the Set command from a xtext string value fill by
 * the user.
 */
public class ValueSpecificationSetCommand {

	/**
	 * The instance of the class.
	 */
	private static ValueSpecificationSetCommand instance = new ValueSpecificationSetCommand();

	/**
	 * Constructor.
	 */
	public ValueSpecificationSetCommand() {
		// Nothing
	}

	/**
	 * Get the single instance of ValueSpecificationSetCommand.
	 * 
	 * @return The single instance of ValueSpecificationSetCommand.
	 */
	public static ValueSpecificationSetCommand getInstance() {
		return instance;
	}

	/**
	 * This allow to create the set command for the value specification from a
	 * xtext string value (need to parse it with xtext parser).
	 * 
	 * @param injector
	 *            The injector used to parse the xtext string value.
	 * @param objectToEdit
	 *            The parent object of value specification.
	 * @param structuralFeature
	 *            The structural feature.
	 * @param xtextStringValue
	 *            The initial xtext string value.
	 * @param defaultLanguages
	 *            The default languages for an opaque expression.
	 * @return The created set command allow to set the value specification on
	 *         the objectToEdit.
	 */
	public CompositeCommand createSetCommand(final Injector injector,
			final EObject objectToEdit,
			final EStructuralFeature structuralFeature,
			final String xtextStringValue,
			final Collection<String> defaultLanguages) {

		// Get the initial value specification
		ValueSpecification initialValueSpecification = null;
		if (null != structuralFeature) {
			initialValueSpecification = (ValueSpecification) objectToEdit
					.eGet(structuralFeature);
		}

		// Prepare the composite command
		final CompositeCommand result = new CompositeCommand("validation"); //$NON-NLS-1$
		final IContextElementProvider provider = getContextProvider(objectToEdit);

		// Get the xtext face resource context (needed to parse the xtext string
		// value
		XtextFakeResourceContext context = new XtextFakeResourceContext(
				injector);
		context.getFakeResource().eAdapters()
				.add(new ContextElementAdapter(provider));
		// Load the xtext string value
		try {
			context.getFakeResource().load(
					new StringInputStream(xtextStringValue),
					Collections.EMPTY_MAP);
		} catch (IOException e) {
			Activator.log.error(e);
		}
		if (provider instanceof IContextElementProviderWithInit) {
			((IContextElementProviderWithInit) provider).initResource(context
					.getFakeResource());
		}
		EcoreUtil2.resolveLazyCrossReferences(context.getFakeResource(),
				CancelIndicator.NullImpl);
		if (!context.getFakeResource().getParseResult().hasSyntaxErrors()
				&& context.getFakeResource().getErrors().size() == 0) {
			// No error during the parser of xtext string value
			EObject xtextObject = context.getFakeResource().getParseResult()
					.getRootASTElement();
			ICommand cmd = getParseCommand(objectToEdit,
					initialValueSpecification, structuralFeature, xtextObject,
					xtextStringValue, defaultLanguages);
			if (null != cmd) {
				result.add(cmd);
			}
		} else {
			// The parser of xtext string value throw errors
			result.add(getOpaqueExpressionCommand(objectToEdit,
					initialValueSpecification, structuralFeature,
					xtextStringValue, defaultLanguages));
		}
		AbstractValidateCommand validationCommand = new AsyncValidateSubtreeCommand(
				objectToEdit, new UMLDiagnostician());
		validationCommand.disableUIFeedback();
		result.add(validationCommand);
		return result;
	}

	/**
	 * This allow to create the parse command of value specification (manage to
	 * create the value specification or the opaque expression).
	 * 
	 * @param objectToEdit
	 *            The parent object of value specification.
	 * @param structuralFeature
	 *            The structural feature.
	 * @param xtextObject
	 *            The xtext object.
	 * @param xtextStringValue
	 *            The initial xtext string value.
	 * @param defaultLanguages
	 *            The default languages for an opaque expression.
	 * @return The created set command allow to set the value specification on
	 *         the objectToEdit.
	 */
	public ICommand getParseCommand(final EObject objectToEdit,
			final EStructuralFeature structuralFeature,
			final EObject xtextObject, final String xtextStringValue,
			final Collection<String> defaultLanguages) {

		// Get the initial value specification
		ValueSpecification initialValueSpecification = null;
		if (null != structuralFeature) {
			initialValueSpecification = (ValueSpecification) objectToEdit
					.eGet(structuralFeature);
		}

		return getParseCommand(objectToEdit, initialValueSpecification,
				structuralFeature, xtextObject, xtextStringValue,
				defaultLanguages);
	}

	/**
	 * This allow to create the parse command of value specification (manage to
	 * create the value specification or the opaque expression).
	 * 
	 * @param objectToEdit
	 *            The parent object of value specification.
	 * @param initialValueSpecification
	 *            The initial value specfication.
	 * @param structuralFeature
	 *            The structural feature.
	 * @param xtextObject
	 *            The xtext object.
	 * @param xtextStringValue
	 *            The initial xtext string value.
	 * @param defaultLanguages
	 *            The default languages for an opaque expression.
	 * @return The created set command allow to set the value specification on
	 *         the objectToEdit.
	 */
	protected ICommand getParseCommand(final EObject objectToEdit,
			final ValueSpecification initialValueSpecification,
			final EStructuralFeature structuralFeature,
			final EObject xtextObject, final String xtextStringValue,
			final Collection<String> defaultLanguages) {

		ValueSpecification createdValueSpecification = null;

		// Check if the object to edit is not multi-valued
		if (null != objectToEdit
				&& (!(objectToEdit instanceof MultiplicityElement) || !(((MultiplicityElement) objectToEdit)
						.isMultivalued()))) {
			createdValueSpecification = createValueSpecification(objectToEdit,
					initialValueSpecification, xtextObject, xtextStringValue,
					defaultLanguages);
		} else {
			// The object is multi-valued, create an opaque expression
			createdValueSpecification = createOpaqueExpression(
					initialValueSpecification, xtextStringValue,
					defaultLanguages);
		}
		return createCommand((EObject) objectToEdit, structuralFeature,
				createdValueSpecification);
	}

	/**
	 * Create he command for the opaque expression creation.
	 * 
	 * @param objectToEdit
	 *            The parent object of value specification.
	 * @param initialValueSpecification
	 *            The initial value specification.
	 * @param structuralFeature
	 *            The structural feature.
	 * @param xtextStringValue
	 *            The initial xtext string value.
	 * @param defaultLanguages
	 *            The default languages for an opaque expression.
	 * @return The command to set the value specification.
	 */
	protected ICommand getOpaqueExpressionCommand(final EObject objectToEdit,
			final ValueSpecification initialValueSpecification,
			final EStructuralFeature structuralFeature,
			final String xtextStringValue,
			final Collection<String> defaultLanguages) {

		// Just return a command of opaque expression
		return createCommand(
				objectToEdit,
				structuralFeature,
				createOpaqueExpression(initialValueSpecification,
						xtextStringValue, defaultLanguages));
	}

	/**
	 * This allow to create the command from the request.
	 * 
	 * @param objectToEdit
	 *            The parent object of value specification.
	 * @param structuralFeature
	 *            The structural feature.
	 * @param valueSpecification
	 *            The value specification created.
	 * @return The command corresponding to the request.
	 */
	protected ICommand createCommand(final EObject objectToEdit,
			final EStructuralFeature structuralFeature,
			final ValueSpecification valueSpecification) {

		final CompositeCommand setValueCommand = new CompositeCommand(
				"Set Value Specification Command"); //$NON-NLS-1$

		final SetRequest request = new SetRequest(objectToEdit,
				structuralFeature, valueSpecification);

		final IElementEditService commandProvider = ElementEditServiceUtils
				.getCommandProvider(objectToEdit);
		ICommand setDefaultValueCommand = commandProvider
				.getEditCommand(request);
		if (null != setDefaultValueCommand
				&& setDefaultValueCommand.canExecute()) {
			setValueCommand.add(setDefaultValueCommand);
		} else {
			setValueCommand
					.add(org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE);
		}
		return setValueCommand.isEmpty() ? null : setValueCommand;
	}

	/**
	 * This allow to create the value specification from the xtext parser.
	 * 
	 * @param objectToEdit
	 *            The parent object of value specification.
	 * @param initialValueSpecification
	 *            The initial value specification.
	 * @param xtextObject
	 *            The object created by the text parsing.
	 * @param xtextStringValue
	 *            The string parsed.
	 * @param defaultLanguages
	 *            The default languages for an opaque expression.
	 * @return The create {@link ValueSpecification}
	 */
	protected ValueSpecification createValueSpecification(
			final EObject objectToEdit,
			final ValueSpecification initialValueSpecification,
			final EObject xtextObject, final String xtextStringValue,
			final Collection<String> defaultLanguages) {

		ValueSpecification createdValueSpecification = null;

		// Check that the xtext object parsed is the correct one
		if (xtextObject instanceof AbstractRule
				&& null == ((AbstractRule) xtextObject).getUndefined()) {
			final AbstractRule abstractRule = (AbstractRule) xtextObject;
			final EObject value = abstractRule.getValue();
			if (null != abstractRule.getInstanceSpecification()) {
				// Create an instance value with specification value
				createdValueSpecification = UMLFactory.eINSTANCE
						.createInstanceValue();
				((InstanceValue) createdValueSpecification)
						.setInstance(abstractRule.getInstanceSpecification());
			} else {
				if (value instanceof LiteralBooleanRule) {
					// Check that the type of the parent is a boolean
					if (isTypeNeeeded(objectToEdit,
							UMLPackage.Literals.LITERAL_BOOLEAN)) {
						// Create a literal boolean
						createdValueSpecification = UMLFactory.eINSTANCE
								.createLiteralBoolean();
						copyFeatureValues(createdValueSpecification,
								initialValueSpecification);
						((LiteralBoolean) createdValueSpecification)
								.setValue(Boolean
										.parseBoolean(((LiteralBooleanRule) value)
												.getValue()));
					}
				} else if (value instanceof LiteralIntegerOrUnlimitedNaturalRule) {
					boolean created = false;
					final LiteralIntegerOrUnlimitedNaturalRule integerValue = (LiteralIntegerOrUnlimitedNaturalRule) value;
					// Check that the value is upper than 0 and the type of the
					// parent is a integer
					if (0 <= integerValue.getValue()
							&& isTypeNeeeded(
									objectToEdit,
									UMLPackage.Literals.LITERAL_UNLIMITED_NATURAL)) {
						// Create a literal unlimited natural
						createdValueSpecification = UMLFactory.eINSTANCE
								.createLiteralUnlimitedNatural();
						copyFeatureValues(createdValueSpecification,
								initialValueSpecification);
						((LiteralUnlimitedNatural) createdValueSpecification)
								.setValue(integerValue.getValue());
						created = true;
					}

					// Check that the value specification is not already created
					// and the type of the parent is an integer
					if (!created
							&& isTypeNeeeded(objectToEdit,
									UMLPackage.Literals.LITERAL_INTEGER)) {
						// Create a literal unlimited natural
						createdValueSpecification = UMLFactory.eINSTANCE
								.createLiteralInteger();
						copyFeatureValues(createdValueSpecification,
								initialValueSpecification);
						((LiteralInteger) createdValueSpecification)
								.setValue(integerValue.getValue());
						created = true;
					}

					// Check that the value specification is not already created
					// and the type of the parent is a real
					if (!created
							&& isTypeNeeeded(objectToEdit,
									UMLPackage.Literals.LITERAL_REAL)) {
						// Create a literal unlimited natural
						createdValueSpecification = UMLFactory.eINSTANCE
								.createLiteralReal();
						copyFeatureValues(createdValueSpecification,
								initialValueSpecification);
						((LiteralReal) createdValueSpecification)
								.setValue(integerValue.getValue());
					}
				} else if (value instanceof LiteralRealRule) {
					// Check that the type of the parent is a real
					if (isTypeNeeeded(objectToEdit,
							UMLPackage.Literals.LITERAL_REAL)) {
						// Create a literal real
						createdValueSpecification = UMLFactory.eINSTANCE
								.createLiteralReal();
						copyFeatureValues(createdValueSpecification,
								initialValueSpecification);
						((LiteralReal) createdValueSpecification)
								.setValue(((LiteralRealRule) value).getValue());
					}
				} else if (value instanceof LiteralNullRule) {
					// Create a literal null
					createdValueSpecification = UMLFactory.eINSTANCE
							.createLiteralNull();
					copyFeatureValues(createdValueSpecification,
							initialValueSpecification);
				} else if (value instanceof LiteralStringRule) {
					// Create a literal real
					createdValueSpecification = UMLFactory.eINSTANCE
							.createLiteralString();
					copyFeatureValues(createdValueSpecification,
							initialValueSpecification);
					((LiteralString) createdValueSpecification)
							.setValue(((LiteralStringRule) value).getValue());
				}
			}

			if (null != createdValueSpecification) {
				// Affect the name and the visibility
				affectAttributes(createdValueSpecification, abstractRule);
			} else {
				// Create the opaque expression if no value specification
				// was created
				createdValueSpecification = createOpaqueExpression(
						initialValueSpecification, xtextStringValue,
						defaultLanguages);
			}
		}
		return createdValueSpecification;
	}

	/**
	 * This allow to affect the attributes of the value specification (name and
	 * visibility).
	 * 
	 * @param createdValueSpecification
	 *            The created {@link ValueSpecification}.
	 * @param abstractRule
	 *            The abstract rule.
	 */
	protected void affectAttributes(
			final ValueSpecification createdValueSpecification,
			final AbstractRule abstractRule) {
		// Check that the visibility was set
		if (null != abstractRule.getVisibility()) {
			VisibilityKind visibility = null;
			if (null != abstractRule.getVisibility().getPublic()) {
				visibility = VisibilityKind.PUBLIC_LITERAL;
			} else if (null != abstractRule.getVisibility().getPackage()) {
				visibility = VisibilityKind.PACKAGE_LITERAL;
			} else if (null != abstractRule.getVisibility().getProtected()) {
				visibility = VisibilityKind.PROTECTED_LITERAL;
			} else if (null != abstractRule.getVisibility().getPrivate()) {
				visibility = VisibilityKind.PRIVATE_LITERAL;
			}
			// Affect the correct visibility
			createdValueSpecification.setVisibility(visibility);
		}

		// Set the name if it was created
		if (null != abstractRule.getName()) {
			createdValueSpecification.setName(abstractRule.getName());
		}
	}

	/**
	 * This allow to copy all the old feature values from the existing object to
	 * the new one.
	 * 
	 * @param newValueSpecification
	 *            The new value specification.
	 * @param existingObject
	 *            The existing {@link EObject}.
	 */
	protected void copyFeatureValues(
			final ValueSpecification newValueSpecification,
			final EObject existingObject) {

		if (null != existingObject
				&& existingObject instanceof ValueSpecification) {
			ValueSpecification existingValueSpecification = (ValueSpecification) existingObject;
			// Loop on each structural features
			for (EStructuralFeature structuralFeature : existingValueSpecification
					.eClass().getEAllStructuralFeatures()) {
				// Check that the structural is changeable and that the new
				// value specification contains this structural feature (it is
				// needed because the sub classes of ValueSpecification
				if (structuralFeature.isChangeable()
						&& newValueSpecification.eClass()
								.getEAllStructuralFeatures()
								.contains(structuralFeature)) {
					newValueSpecification.eSet(structuralFeature,
							existingObject.eGet(structuralFeature));
				}
			}
		}
	}

	/**
	 * Check the type of the object with the type needed (represented by
	 * string).
	 * 
	 * @param object
	 *            The object to check.
	 * @param typeNeeded
	 *            The type needed.
	 * @return <code>true</code> if the object allow the typed needed,
	 *         <code>false</code> otherwise.
	 */
	protected boolean isTypeNeeeded(final Object object, final Object typeNeeded) {

		boolean result = false;
		if (!(object instanceof TypedElement)) {
			// If the object is a typed element
			result = true;
		} else {
			TypedElement typedElement = (TypedElement) object;
			if (null == typedElement.getType()
					|| !(typedElement.getType() instanceof PrimitiveType)) {
				result = true;
			} else if (typedElement.getType() instanceof PrimitiveType) {
				PrimitiveType type = (PrimitiveType) typedElement.getType();
				if (typeNeeded.equals(UMLPackage.Literals.LITERAL_BOOLEAN)) {
					result = UMLUtil.isBoolean(type);
				} else if (typeNeeded
						.equals(UMLPackage.Literals.LITERAL_UNLIMITED_NATURAL)) {
					result = UMLUtil.isUnlimitedNatural(type);
				} else if (typeNeeded
						.equals(UMLPackage.Literals.LITERAL_INTEGER)) {
					result = UMLUtil.isInteger(type);
				} else if (typeNeeded.equals(UMLPackage.Literals.LITERAL_REAL)) {
					result = UMLUtil.isReal(type);
				}
			}
		}
		return result;
	}

	/**
	 * This allow to create the opaque expression.
	 * 
	 * @param initialEObject
	 *            The initial EObject.
	 * @param xtextStringValue
	 *            The xtext string value.
	 * @param defaultLanguages
	 *            The default languages for an opaque expression.
	 * @return The created {@link OpaqueExpression}.
	 */
	protected ValueSpecification createOpaqueExpression(
			final EObject initialEObject, final String xtextStringValue,
			final Collection<String> defaultLanguages) {

		if (!xtextStringValue.isEmpty()) {
			// Create the opaque expression
			ValueSpecification valueSpecification = UMLFactory.eINSTANCE
					.createOpaqueExpression();
			copyFeatureValues(valueSpecification, initialEObject);
			((OpaqueExpression) valueSpecification).getLanguages().addAll(
					defaultLanguages);
			valueSpecification.setName(xtextStringValue);
			return valueSpecification;
		}
		return null;
	}

	/**
	 * Get the context provider of the object to edit.
	 * 
	 * @param objectToEdit
	 *            The object to edit.
	 * @return The context element provider corresponding to the object to edit.
	 */
	protected IContextElementProvider getContextProvider(
			final EObject objectToEdit) {

		return new IContextElementProvider() {

			public EObject getContextObject() {
				if (objectToEdit instanceof EObject) {
					return (EObject) objectToEdit;
				}
				return null;
			}
		};
	}
}
