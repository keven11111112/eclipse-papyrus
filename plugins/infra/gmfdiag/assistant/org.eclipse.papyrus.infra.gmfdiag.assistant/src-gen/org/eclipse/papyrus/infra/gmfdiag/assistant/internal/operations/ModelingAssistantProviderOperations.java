/**
 * Copyright (c) 2014, 2015 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 */
package org.eclipse.papyrus.infra.gmfdiag.assistant.internal.operations;

import static org.eclipse.papyrus.infra.gmfdiag.assistant.core.util.ModelingAssistantUtil.alphabetical;
import static org.eclipse.papyrus.infra.gmfdiag.assistant.core.util.ModelingAssistantUtil.filterConnectionTypes;
import static org.eclipse.papyrus.infra.gmfdiag.assistant.core.util.ModelingAssistantUtil.isRelationship;

import java.util.Collection;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.GetRelTypesOnSourceOperation;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.GetRelTypesOnTargetOperation;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.GetTypesForPopupBarOperation;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.utils.AdapterUtils;
import org.eclipse.papyrus.infra.emf.utils.ECollections2;
import org.eclipse.papyrus.infra.emf.utils.ECollections2.ImmutableEListBuilder;
import org.eclipse.papyrus.infra.gmfdiag.assistant.ConnectionAssistant;
import org.eclipse.papyrus.infra.gmfdiag.assistant.ModelingAssistantProvider;
import org.eclipse.papyrus.infra.gmfdiag.assistant.PopupAssistant;
import org.eclipse.papyrus.infra.gmfdiag.assistant.core.util.ModelingAssistantUtil;
import org.eclipse.papyrus.infra.gmfdiag.assistant.impl.ModelingAssistantProviderImpl;
import org.eclipse.papyrus.infra.gmfdiag.assistant.internal.core.util.ProviderCache;
import org.eclipse.papyrus.infra.services.edit.utils.ElementTypeUtils;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.Sets;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Modeling Assistant Provider</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 * <li>{@link org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation) <em>Provides</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.common.core.service.IProvider#addProviderChangeListener(org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener) <em>Add Provider Change Listener</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.common.core.service.IProvider#removeProviderChangeListener(org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener) <em>Remove Provider Change Listener</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getTypes(java.lang.String, org.eclipse.core.runtime.IAdaptable) <em>Get Types</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getRelTypesOnSource(org.eclipse.core.runtime.IAdaptable) <em>Get Rel Types On Source</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getRelTypesOnTarget(org.eclipse.core.runtime.IAdaptable) <em>Get Rel Types On Target</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getRelTypesOnSourceAndTarget(org.eclipse.core.runtime.IAdaptable, org.eclipse.core.runtime.IAdaptable) <em>Get Rel Types On Source And Target</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getRelTypesForSREOnTarget(org.eclipse.core.runtime.IAdaptable) <em>Get Rel Types For SRE On Target</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getRelTypesForSREOnSource(org.eclipse.core.runtime.IAdaptable) <em>Get Rel Types For SRE On Source</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getTypesForSource(org.eclipse.core.runtime.IAdaptable, org.eclipse.gmf.runtime.emf.type.core.IElementType) <em>Get Types For Source</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getTypesForTarget(org.eclipse.core.runtime.IAdaptable, org.eclipse.gmf.runtime.emf.type.core.IElementType) <em>Get Types For Target</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#selectExistingElementForSource(org.eclipse.core.runtime.IAdaptable, org.eclipse.gmf.runtime.emf.type.core.IElementType) <em>Select Existing Element For Source
 * </em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#selectExistingElementForTarget(org.eclipse.core.runtime.IAdaptable, org.eclipse.gmf.runtime.emf.type.core.IElementType) <em>Select Existing Element For Target
 * </em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.IModelingAssistantProvider#getTypesForPopupBar(org.eclipse.core.runtime.IAdaptable) <em>Get Types For Popup Bar</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.assistant.ModelingAssistantProvider#getElementTypes() <em>Get Element Types</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.assistant.ModelingAssistantProvider#getClientContext() <em>Get Client Context</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.assistant.ModelingAssistantProvider#getElementType(java.lang.String) <em>Get Element Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.assistant.ModelingAssistantProvider#getExcludedElementTypes() <em>Get Excluded Element Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelingAssistantProviderOperations
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ModelingAssistantProviderOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static boolean provides(ModelingAssistantProvider modelingAssistantProvider, IOperation operation)
	{
		boolean result = false;

		switch (((IModelingAssistantOperation) operation).getId()) {
		case IModelingAssistantOperation.GET_TYPES_FOR_SOURCE_ID:
		case IModelingAssistantOperation.GET_TYPES_FOR_TARGET_ID:
		case IModelingAssistantOperation.GET_REL_TYPES_ON_SOURCE_ID:
		case IModelingAssistantOperation.GET_REL_TYPES_ON_TARGET_ID:
		case IModelingAssistantOperation.GET_REL_TYPES_ON_SOURCE_AND_TARGET_ID:
		case IModelingAssistantOperation.GET_TYPES_FOR_POPUP_BAR_ID:
			result = true;
			break;
		}

		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static void addProviderChangeListener(ModelingAssistantProvider modelingAssistantProvider, IProviderChangeListener listener)
	{
		((ModelingAssistantProviderImpl) modelingAssistantProvider).getListeners().add(listener);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static void removeProviderChangeListener(ModelingAssistantProvider modelingAssistantProvider, IProviderChangeListener listener)
	{
		((ModelingAssistantProviderImpl) modelingAssistantProvider).getListeners().remove(listener);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static EList<IElementType> getTypes(ModelingAssistantProvider modelingAssistantProvider, String hint, IAdaptable data)
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static EList<IElementType> getRelTypesOnSource(final ModelingAssistantProvider modelingAssistantProvider, IAdaptable source)
	{
		ProviderCache<IAdaptable, EList<IElementType>> cache = ProviderCache.getCache(modelingAssistantProvider, GetRelTypesOnSourceOperation.class);
		if (cache == null) {
			cache = ProviderCache.cache(modelingAssistantProvider, GetRelTypesOnSourceOperation.class, new Function<IAdaptable, EList<IElementType>>() {
				@Override
				public EList<IElementType> apply(IAdaptable input) {
					Set<IElementType> result = Sets.newLinkedHashSet();

					for (ConnectionAssistant next : modelingAssistantProvider.getConnectionAssistants()) {
						if ((next.getSourceFilter() == null) || next.getSourceFilter().matches(input)) {
							resolveAndAppendHintedTypes(next.getElementType(), modelingAssistantProvider, input, result);
						}
					}

					result.remove(null); // In case of an unresolved element type

					// Filter result on connections that we actually think we can create
					return filterConnectionTypes(result, input);
				}
			});
		}

		return cache.get(source);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static EList<IElementType> getRelTypesOnTarget(final ModelingAssistantProvider modelingAssistantProvider, IAdaptable target)
	{
		ProviderCache<IAdaptable, EList<IElementType>> cache = ProviderCache.getCache(modelingAssistantProvider, GetRelTypesOnTargetOperation.class);
		if (cache == null) {
			cache = ProviderCache.cache(modelingAssistantProvider, GetRelTypesOnTargetOperation.class, new Function<IAdaptable, EList<IElementType>>() {
				@Override
				public EList<IElementType> apply(IAdaptable input) {
					Set<IElementType> result = Sets.newLinkedHashSet();

					for (ConnectionAssistant next : modelingAssistantProvider.getConnectionAssistants()) {
						if ((next.getTargetFilter() == null) || next.getTargetFilter().matches(input)) {
							resolveAndAppendHintedTypes(next.getElementType(), modelingAssistantProvider, input, result);
						}
					}

					result.remove(null); // In case of an unresolved element type

					// Filter result on connections that we actually think we can create
					return filterConnectionTypes(result, input);
				}
			});
		}

		return cache.get(target);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static EList<IElementType> getRelTypesOnSourceAndTarget(ModelingAssistantProvider modelingAssistantProvider, IAdaptable source, IAdaptable target)
	{
		Set<IElementType> result = Sets.newLinkedHashSet();

		for (ConnectionAssistant next : modelingAssistantProvider.getConnectionAssistants()) {
			if (((next.getSourceFilter() == null) || next.getSourceFilter().matches(source))
					&& ((next.getTargetFilter() == null) || next.getTargetFilter().matches(target))) {
				resolveAndAppendHintedTypes(next.getElementType(), modelingAssistantProvider, source, result);
			}
		}

		result.remove(null); // In case of an unresolved element type

		// Filter result on connections that we actually think we can create
		return filterConnectionTypes(result, source);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static EList<IElementType> getRelTypesForSREOnTarget(ModelingAssistantProvider modelingAssistantProvider, IAdaptable target)
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static EList<IElementType> getRelTypesForSREOnSource(ModelingAssistantProvider modelingAssistantProvider, IAdaptable source)
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static EList<IElementType> getTypesForSource(ModelingAssistantProvider modelingAssistantProvider, IAdaptable target, IElementType relationshipType)
	{
		Set<IElementType> types = Sets.newLinkedHashSet();

		// In case we had to create a proxy for diagram-specific hinted types that are not modeled
		relationshipType = ModelingAssistantUtil.resolveSemanticType(relationshipType);

		for (ConnectionAssistant next : modelingAssistantProvider.getConnectionAssistants()) {
			if (Objects.equal(relationshipType, next.getElementType())) {
				if ((next.getTargetFilter() == null) || next.getTargetFilter().matches(target)) {
					for (IElementType sourceType : modelingAssistantProvider.getElementTypes()) {
						// The filter, if any, needs to match but we also don't want to propose connections
						// from relationships (only node-like things)
						if (((next.getSourceFilter() == null) || next.getSourceFilter().matches(sourceType))
								&& !isRelationship(modelingAssistantProvider, sourceType)) {
							ModelingAssistantUtil.collectAllConcreteSubtypes(sourceType, modelingAssistantProvider, types);
						}
					}
				}
			}
		}

		// And now resolve hinted types as necessary
		ImmutableEListBuilder<IElementType> result = ECollections2.immutableEListBuilder();
		for (IElementType next : types) {
			resolveAndAppendHintedTypes(next, modelingAssistantProvider, target, result);
		}

		return result.sort(alphabetical()).build();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static EList<IElementType> getTypesForTarget(ModelingAssistantProvider modelingAssistantProvider, IAdaptable source, IElementType relationshipType)
	{
		Set<IElementType> types = Sets.newLinkedHashSet();

		// In case we had to create a proxy for diagram-specific hinted types that are not modeled
		relationshipType = ModelingAssistantUtil.resolveSemanticType(relationshipType);

		for (ConnectionAssistant next : modelingAssistantProvider.getConnectionAssistants()) {
			if (Objects.equal(relationshipType, next.getElementType())) {
				if ((next.getSourceFilter() == null) || next.getSourceFilter().matches(source)) {
					for (IElementType targetType : modelingAssistantProvider.getElementTypes()) {
						// The filter, if any, needs to match but we also don't want to propose connections
						// to relationships (only node-like things)
						if (((next.getTargetFilter() == null) || next.getTargetFilter().matches(targetType))
								&& !isRelationship(modelingAssistantProvider, targetType)) {
							ModelingAssistantUtil.collectAllConcreteSubtypes(targetType, modelingAssistantProvider, types);
						}
					}
				}
			}
		}

		// And now resolve hinted types as necessary
		ImmutableEListBuilder<IElementType> result = ECollections2.immutableEListBuilder();
		for (IElementType next : types) {
			resolveAndAppendHintedTypes(next, modelingAssistantProvider, source, result);
		}

		return result.sort(alphabetical()).build();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static EObject selectExistingElementForSource(ModelingAssistantProvider modelingAssistantProvider, IAdaptable target, IElementType relationshipType)
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static EObject selectExistingElementForTarget(ModelingAssistantProvider modelingAssistantProvider, IAdaptable source, IElementType relationshipType)
	{
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static EList<IElementType> getTypesForPopupBar(final ModelingAssistantProvider modelingAssistantProvider, IAdaptable host)
	{
		ProviderCache<IAdaptable, EList<IElementType>> cache = ProviderCache.getCache(modelingAssistantProvider, GetTypesForPopupBarOperation.class);
		if (cache == null) {
			cache = ProviderCache.cache(modelingAssistantProvider, GetTypesForPopupBarOperation.class, new Function<IAdaptable, EList<IElementType>>() {
				@Override
				public EList<IElementType> apply(IAdaptable input) {
					Set<IElementType> types = Sets.newLinkedHashSet();

					for (PopupAssistant next : modelingAssistantProvider.getPopupAssistants()) {
						if ((next.getFilter() == null) || next.getFilter().matches(input)) {
							resolveAndAppendHintedTypes(next.getElementType(), modelingAssistantProvider, input, types);
						}
					}

					types.remove(null); // In case of an unresolved element type

					ImmutableEListBuilder<IElementType> result = ECollections2.immutableEListBuilder();
					result.addAll(types);
					return result.sort(alphabetical()).build();
				}
			});
		}

		return cache.get(host);
	}

	protected static void resolveAndAppendHintedTypes(IElementType typeToResolve, ModelingAssistantProvider provider, IAdaptable context, Collection<? super IElementType> resolvedTypes) {
		// The type can be null if the assistant specifies an element type that is not currently installed or not currently bound to the provider's client context
		if (typeToResolve != null) {
			if (hasVisualID(typeToResolve) || !isDiagramContext(context)) {
				resolvedTypes.add(typeToResolve);
			} else {
				resolvedTypes.addAll(ModelingAssistantUtil.getHintedTypes(typeToResolve, provider, context));
			}
		}
	}

	protected static boolean isDiagramContext(IAdaptable context) {
		return AdapterUtils.adapt(context, View.class).isPresent();
	}

	protected static boolean hasVisualID(IElementType type) {
		return ((type instanceof IHintedType) && ModelingAssistantUtil.isVisualID(((IHintedType) type).getSemanticHint()));
	}

	protected static void resolveAndAppendHintedTypes(IElementType typeToResolve, ModelingAssistantProvider provider, IAdaptable context, ImmutableEListBuilder<? super IElementType> resolvedTypes) {
		if (hasVisualID(typeToResolve) || !isDiagramContext(context)) {
			resolvedTypes.add(typeToResolve);
		} else {
			resolvedTypes.addAll(ModelingAssistantUtil.getHintedTypes(typeToResolve, provider, context));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static EList<IElementType> getElementTypes(ModelingAssistantProvider modelingAssistantProvider)
	{
		Set<IElementType> types = Sets.newLinkedHashSet();
		for (String next : modelingAssistantProvider.getElementTypeIDs()) {
			IElementType type = modelingAssistantProvider.getElementType(next);
			if (type != null) {
				types.add(type);
			}
		}

		ImmutableEListBuilder<IElementType> result = ECollections2.immutableEListBuilder();
		result.addAll(types);
		return result.sort(alphabetical()).build();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static IClientContext getClientContext(ModelingAssistantProvider modelingAssistantProvider)
	{
		IClientContext result = null;

		if (modelingAssistantProvider.getClientContextID() != null) {
			result = ClientContextManager.getInstance().getClientContext(modelingAssistantProvider.getClientContextID());
		}

		if (result == null) {
			result = ElementTypeUtils.getEditContext();

			if (result == null) {
				result = ClientContextManager.getDefaultClientContext();
			}
		}

		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static IElementType getElementType(ModelingAssistantProvider modelingAssistantProvider, String id)
	{
		IElementType result = null;

		// First, try metamodel types
		for (IElementType next : ElementTypeRegistry.getInstance().getMetamodelTypes(modelingAssistantProvider.getClientContext())) {
			if (Objects.equal(next.getId(), id)) {
				result = next;
				break;
			}
		}

		if (result == null) {
			// OK, try specializations
			for (IElementType next : ElementTypeRegistry.getInstance().getSpecializationTypes(modelingAssistantProvider.getClientContext())) {
				if (Objects.equal(next.getId(), id)) {
					result = next;
					break;
				}
			}
		}

		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static EList<IElementType> getExcludedElementTypes(ModelingAssistantProvider modelingAssistantProvider)
	{
		Set<IElementType> types = Sets.newLinkedHashSet();
		for (String next : modelingAssistantProvider.getExcludedElementTypeIDs()) {
			IElementType type = modelingAssistantProvider.getElementType(next);
			if (type != null) {
				types.add(type);
			}
		}

		ImmutableEListBuilder<IElementType> result = ECollections2.immutableEListBuilder();
		result.addAll(types);
		return result.sort(alphabetical()).build();
	}

} // ModelingAssistantProviderOperations