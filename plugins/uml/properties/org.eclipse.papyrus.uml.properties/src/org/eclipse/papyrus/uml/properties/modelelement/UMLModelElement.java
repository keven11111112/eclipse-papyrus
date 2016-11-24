/*****************************************************************************
 * Copyright (c) 2011, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 323802
 *  Christian W. Damus (CEA) - bug 440108
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.modelelement;

import static org.eclipse.uml2.uml.ParameterDirectionKind.INOUT_LITERAL;
import static org.eclipse.uml2.uml.ParameterDirectionKind.IN_LITERAL;
import static org.eclipse.uml2.uml.ParameterDirectionKind.OUT_LITERAL;
import static org.eclipse.uml2.uml.ParameterDirectionKind.RETURN_LITERAL;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.infra.emf.utils.HistoryUtil;
import org.eclipse.papyrus.infra.internationalization.utils.utils.InternationalizationConstants;
import org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement;
import org.eclipse.papyrus.infra.properties.ui.providers.FeatureContentProvider;
import org.eclipse.papyrus.infra.ui.emf.providers.EMFGraphicalContentProvider;
import org.eclipse.papyrus.infra.ui.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.ui.emf.utils.ProviderHelper;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.providers.EmptyContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.util.INameResolutionHelper;
import org.eclipse.papyrus.infra.widgets.util.IPapyrusConverter;
import org.eclipse.papyrus.uml.properties.creation.ConnectorTypeEditorFactory;
import org.eclipse.papyrus.uml.properties.creation.MessageValueSpecificationFactory;
import org.eclipse.papyrus.uml.properties.creation.OwnedRuleCreationFactory;
import org.eclipse.papyrus.uml.properties.creation.UMLPropertyEditorFactory;
import org.eclipse.papyrus.uml.properties.databinding.KeywordObservableValue;
import org.eclipse.papyrus.uml.properties.databinding.UMLLabelObservableValue;
import org.eclipse.papyrus.uml.tools.databinding.ExtensionRequiredObservableValue;
import org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableList;
import org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableValue;
import org.eclipse.papyrus.uml.tools.databinding.ProvidedInterfaceObservableList;
import org.eclipse.papyrus.uml.tools.databinding.RequiredInterfaceObservableList;
import org.eclipse.papyrus.uml.tools.databinding.UnsettableStringValue;
import org.eclipse.papyrus.uml.tools.providers.ConstrainedElementContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLContainerContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLFilteredLabelProvider;
import org.eclipse.papyrus.uml.tools.util.UMLReferenceConverter;
import org.eclipse.papyrus.uml.tools.utils.NameResolutionHelper;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A ModelElement representing a UML Element
 *
 * @author Camille Letavernier
 *
 */
public class UMLModelElement extends EMFModelElement {

	/**
	 *
	 * Constructor.
	 *
	 * @param source
	 *            The EObject represented by this ModelElement
	 */
	public UMLModelElement(final EObject source) {
		super(source);
	}

	/**
	 *
	 * Constructor.
	 *
	 * @param source
	 *            The EObject represented by this ModelElement
	 * @param domain
	 *            The EditingDomain on which the commands will be executed
	 */
	public UMLModelElement(final EObject source, final EditingDomain domain) {
		super(source, domain);
	}

	@Override
	public IObservable doGetObservable(final String propertyPath) {
		IObservable value = null;
		if (InternationalizationConstants.LABEL_PROPERTY_PATH.equals(propertyPath)) {
			value = new UMLLabelObservableValue((NamedElement) source, domain);
		} else if (InternationalizationConstants.KEYWORD_PROPERTY_PATH.equals(propertyPath)) {
			value = new KeywordObservableValue((Stereotype) source, domain);
		} else {
			FeaturePath featurePath = getFeaturePath(propertyPath);
			EStructuralFeature feature = getFeature(propertyPath);

			if (feature == UMLPackage.eINSTANCE.getExtension_IsRequired()) {
				value = new ExtensionRequiredObservableValue((Extension) source, domain);
			} else if (feature == UMLPackage.eINSTANCE.getPort_Provided()) {
				value = new ProvidedInterfaceObservableList((Port) source, domain);
			} else if (feature == UMLPackage.eINSTANCE.getPort_Required()) {
				value = new RequiredInterfaceObservableList((Port) source, domain);
			} else if (feature == null) {
				value = null;
			} else if (feature.getUpperBound() != 1) {
				IObservableList list = domain == null ? EMFProperties.list(featurePath).observe(source) : new PapyrusObservableList(EMFProperties.list(featurePath).observe(source), domain, getSource(featurePath), feature);
				value = list;
			} else if ((feature == UMLPackage.Literals.NAMED_ELEMENT__NAME) && (domain != null)) {
				// Empty string as a name is not useful, so we unset instead
				value = new UnsettableStringValue(getSource(featurePath), feature, domain);
			} else {
				value = domain == null ? EMFProperties.value(featurePath).observe(source) : new PapyrusObservableValue(getSource(featurePath), feature, domain);
			}
		}
		return value;
	}

	@Override
	protected boolean isFeatureEditable(final String propertyPath) {
		boolean result = false;
		if (InternationalizationConstants.LABEL_PROPERTY_PATH.equals(propertyPath) || InternationalizationConstants.KEYWORD_PROPERTY_PATH.equals(propertyPath)) {
			result = true;
		} else {
			EStructuralFeature feature = getFeature(propertyPath);
			if (feature == UMLPackage.eINSTANCE.getMessage_Signature()) {
				result = true;
			} else if (feature == UMLPackage.eINSTANCE.getExtension_IsRequired()) {
				result = true;
			} else if (feature == UMLPackage.eINSTANCE.getPort_Provided() || feature == UMLPackage.eINSTANCE.getPort_Required() &&
					source instanceof Port) {
				result = ((Port) source).getType() != null;
			} else {
				result = super.isFeatureEditable(propertyPath);
			}
		}
		return result;
	}

	@Override
	public IStaticContentProvider getContentProvider(final String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);

		if (feature == null) {
			return EmptyContentProvider.instance;
		}

		// Workaround: the standard ContentProvider does not correctly hide the selected elements in ReferenceSelector.
		// With a ContainmentBasedBrowseStrategy, it works better (But we don't have the infinite tree in the selection dialog).
		if (feature == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
			return new ConstrainedElementContentProvider(source, feature);
		}

		ResourceSet resourceSet = domain == null ? null : domain.getResourceSet();
		return new UMLContentProvider(source, feature, null, resourceSet);
	}

	@Override
	public boolean isOrdered(final String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if (feature == UMLPackage.eINSTANCE.getStereotype_Icon()) {
			return true;
		}
		return super.isOrdered(propertyPath);
	}

	@Override
	public ReferenceValueFactory getValueFactory(final String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if (!(feature instanceof EReference)) {
			return null;
		}
		EReference reference = (EReference) feature;
		if (reference == UMLPackage.eINSTANCE.getMessage_Argument()) {
			if (source instanceof Message) {
				Set<ParameterDirectionKind> directions = new HashSet<ParameterDirectionKind>();
				switch (((Message) source).getMessageSort()) {
				case REPLY_LITERAL:
					directions.add(OUT_LITERAL);
					directions.add(INOUT_LITERAL);
					directions.add(RETURN_LITERAL);
					return new MessageValueSpecificationFactory(reference, (Message) source, directions);
				case SYNCH_CALL_LITERAL:
				case ASYNCH_CALL_LITERAL:
				case ASYNCH_SIGNAL_LITERAL:
					directions.add(IN_LITERAL);
					directions.add(INOUT_LITERAL);
					return new MessageValueSpecificationFactory(reference, (Message) source, directions);
				}
			}
		}

		boolean isOwnedRuleSubset = ownedRuleSubsets.contains(reference);

		if (isOwnedRuleSubset) {
			return new OwnedRuleCreationFactory(reference);
		}

		UMLPropertyEditorFactory factory;

		if (reference == UMLPackage.eINSTANCE.getConnector_Type() && source instanceof Connector) {
			factory = new ConnectorTypeEditorFactory(reference);
		} else {
			factory = new UMLPropertyEditorFactory(reference);
		}

		EClass type = reference.getEReferenceType();

		factory.setContainerLabelProvider(new UMLFilteredLabelProvider());
		factory.setReferenceLabelProvider(new EMFLabelProvider());
		ITreeContentProvider contentProvider = new UMLContainerContentProvider(source, reference);

		ResourceSet rs = source == null ? null : source.eResource() == null ? null : source.eResource().getResourceSet();
		EMFGraphicalContentProvider provider = ProviderHelper.encapsulateProvider(contentProvider, rs, HistoryUtil.getHistoryID(source, feature, "container"));

		factory.setContainerContentProvider(provider);
		factory.setReferenceContentProvider(new FeatureContentProvider(type));

		return factory;
	}

	@Override
	public boolean isMandatory(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);

		// Avoid unsetting container references (i.e. reference to the parent)
		// (Which would result in detaching the edited object from the model)
		// See Bug 404445: [Constraint] Unsetting the context of a constraint destroys it (Semantically)
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=404445
		if (feature instanceof EReference) {
			EReference reference = (EReference) feature;
			if (reference.isContainer()) {
				return true;
			}
		}

		return super.isMandatory(propertyPath);
	}

	/**
	 * The set of all EStructuralFeature representing subsets of {@link Namespace#getOwnedRules()}
	 */
	public final static Set<EStructuralFeature> ownedRuleSubsets = new HashSet<EStructuralFeature>();

	static {
		// Behavior
		ownedRuleSubsets.add(UMLPackage.eINSTANCE.getBehavior_Precondition());
		ownedRuleSubsets.add(UMLPackage.eINSTANCE.getBehavior_Postcondition());

		// Operation
		ownedRuleSubsets.add(UMLPackage.eINSTANCE.getOperation_BodyCondition());
		ownedRuleSubsets.add(UMLPackage.eINSTANCE.getOperation_Precondition());
		ownedRuleSubsets.add(UMLPackage.eINSTANCE.getOperation_Postcondition());

		// ProtocolTransition
		ownedRuleSubsets.add(UMLPackage.eINSTANCE.getProtocolTransition_PreCondition());
		ownedRuleSubsets.add(UMLPackage.eINSTANCE.getProtocolTransition_PostCondition());

		// Transition
		ownedRuleSubsets.add(UMLPackage.eINSTANCE.getTransition_Guard());
	}

	@Override
	public IValidator getValidator(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if (feature == UMLPackage.eINSTANCE.getNamedElement_Name()) {

			return new org.eclipse.papyrus.uml.tools.databinding.NamedElementValidator(source);
		}

		// TODO improve if our model add his own constraint
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.infra.properties.ui.modelelement.AbstractModelElement#getNameResolutionHelper(java.lang.String)
	 *
	 * @param propertyPath
	 * @return
	 */
	@Override
	public INameResolutionHelper getNameResolutionHelper(String propertyPath) {
		EObject source = getSource();
		Object feature = getFeature(propertyPath);
		if (feature instanceof EStructuralFeature && source instanceof Element) {
			EStructuralFeature f = (EStructuralFeature) feature;
			EClassifier etype = f.getEType();
			if (etype instanceof EClass) {
				return new NameResolutionHelper((Element) source, (EClass) etype);
			}
		}
		return super.getNameResolutionHelper(propertyPath);
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.properties.ui.modelelement.AbstractModelElement#getPapyrusConverter(java.lang.String)
	 *
	 * @param propertyPath
	 * @return
	 */
	@Override
	public IPapyrusConverter getPapyrusConverter(String propertyPath) {
		INameResolutionHelper helper = getNameResolutionHelper(propertyPath);
		if (helper != null) {
			return new UMLReferenceConverter(helper, getFeature(propertyPath).isMany());
		}
		return null;
	}
}
