/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
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

package org.eclipse.papyrus.propertylifecycle.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.types.core.impl.ConfiguredHintedMetamodelElementType;
import org.eclipse.papyrus.infra.types.core.impl.ConfiguredHintedSpecializationElementType;
import org.eclipse.papyrus.propertylifecycle.Activator;
import org.eclipse.papyrus.propertylifecycle.ElementContainer;
import org.eclipse.papyrus.propertylifecycle.ElementProperty;
import org.eclipse.papyrus.propertylifecycle.StrategyElement;
import org.eclipse.papyrus.propertylifecycle.commands.LifeCycleEditElementCommand;
import org.eclipse.papyrus.propertylifecycle.preferences.utils.PropertyLifecyclePreferencesManager;


/**
 * Used to match the handled element against the selected strategies
 *
 */
public class PropertyLifecycleManager {

	/** The manager containing all the strategies informations */
	private PropertyLifecyclePreferencesManager preferencesManager = new PropertyLifecyclePreferencesManager();

	/** The element's type */
	private IElementType elementType;

	/** The handled element */
	private EObject element;

	/** The list of all loaded processors (reflexively accessed) */
	private Map<String, Object> accessedProcessors = new HashMap<String, Object>();

	/** The command encompassing the changes to the handled element */
	private ICommand command;

	/** The request used to extract the element's contextual informations */
	private AbstractEditCommandRequest request;

	/** The depth to which the strategies will be matched against the handled element's contents */
	private int depth;


	/**
	 * 
	 * Constructor. Default depth set to -1
	 *
	 * @param request
	 *            The {@link org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest} of the edited element
	 */
	public PropertyLifecycleManager(AbstractEditCommandRequest request) {
		this(request, -1);
	}

	/**
	 * 
	 * Constructor.
	 *
	 * @param request
	 *            The {@link org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest} of the edited element
	 * @param depth
	 *            The depth to which the strategies will be matched against the handled element's contents. Negative numbers for infinite depth.
	 */
	public PropertyLifecycleManager(AbstractEditCommandRequest request, int depth) {
		this.request = request;
		setElementsVariables(this.request);
		this.depth = depth;
	}

	/**
	 * Set the variables {@link #element} and {@link #elementType} used to filter the strategies
	 * 
	 * @param request
	 *            The manipulated {@link org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest}
	 */
	private void setElementsVariables(AbstractEditCommandRequest request) {
		if (request instanceof CreateElementRequest) {
			CreateElementRequest createRequest = (CreateElementRequest) request;
			elementType = createRequest.getElementType();
			// TODO do a better job at fishing out the created element
			// Object object = createRequest.getElementsToEdit().get(0);
			// element = object instanceof EObject ? (EObject) object : null;
			element = ((CreateElementRequest) request).getNewElement();
		}

		if (request instanceof ConfigureRequest) {
			ConfigureRequest confRequest = ((ConfigureRequest) request);
			elementType = confRequest.getTypeToConfigure();
			element = confRequest.getElementToConfigure();
		}

		if (request instanceof ReorientRelationshipRequest) {
			ReorientRelationshipRequest reorientRequest = (ReorientRelationshipRequest) request;
			element = reorientRequest.getRelationship();
			String testString = element.eClass().getInstanceClassName();
			// TODO find an alternative to this placeholder element type
			IElementType papyrusType = ElementTypeRegistry.getInstance().getType(testString.replace("org.eclipse.uml2", "org.eclipse.papyrus"));
			elementType = papyrusType != null ? papyrusType : ElementTypeRegistry.getInstance().getElementType(element.eClass());
		}

		if (request instanceof SetRequest) {
			SetRequest setRequest = (SetRequest) request;
			element = setRequest.getElementToEdit();
			String testString = element.eClass().getInstanceClassName();
			// TODO find an alternative to this placeholder element type
			IElementType papyrusType = ElementTypeRegistry.getInstance().getType(testString.replace("org.eclipse.uml2", "org.eclipse.papyrus"));
			elementType = papyrusType != null ? papyrusType : ElementTypeRegistry.getInstance().getElementType(element.eClass());
		}

	}


	/**
	 * Construct the {@link org.eclipse.gmf.runtime.common.core.command.ICommand} of the edition
	 * 
	 * @return
	 * 		The {@link org.eclipse.gmf.runtime.common.core.command.CompositeCommand} from the different changes brought by the current strategies
	 */
	public ICommand setAssociatedPropertyValues() {

		// This will avoid an NPE later and indicates that there is not yet a way to deal with the given request
		if (elementType == null || element == null) {
			return command;
		}

		Collection<StrategyElement> matchingStrategies = new LinkedList<StrategyElement>();
		matchingStrategies.addAll(preferencesManager.retrieveAllStrategies());

		matchingStrategies = filterOnContext(matchingStrategies, elementType, element);
		Activator.log.trace(Activator.PLCSTRATEGY_TRACE, matchingStrategies.size() + ": " + matchingStrategies);

		if (matchingStrategies.size() > 0) {
			Set<String> modifiableFeatures = getAllModifiableFeatures(matchingStrategies);

			if (modifiableFeatures.size() > 0) {
				HashMap<String, ElementProperty> newFeatureValues = getNewFeatureValues(matchingStrategies, modifiableFeatures);

				for (EStructuralFeature elementFeature : element.eClass().getEAllStructuralFeatures()) {
					String featureLabel = elementFeature.getName();
					if (newFeatureValues.keySet().contains(featureLabel)) {
						ElementProperty featureStrategy = newFeatureValues.get(featureLabel);
						if (command == null) {
							command = getAssociatedCommand(featureLabel, featureStrategy, request);
						} else {
							command = CompositeCommand.compose(command, getAssociatedCommand(featureLabel, featureStrategy, request));
						}
					}
				}
			}
		}

		// Iterate on all the nested elements, if any, to match them against the current strategies
		applyStrategiesToContents(element);

		return command;
	}


	/**
	 * Filter regrouping all the contextual information in which the element is created
	 * 
	 * @param strategies
	 *            The possible strategies
	 * @param elementType
	 *            The element type of the element
	 * @param element
	 *            The element
	 * @return
	 * 		The list of Strategies matching the element
	 */
	private Collection<StrategyElement> filterOnContext(Collection<StrategyElement> strategies, IElementType elementType, EObject element) {
		Map<String, StrategyElement> matchingStrategies = new HashMap<String, StrategyElement>();
		// LinkedList<IElementType> elementSuperTypes = new LinkedList<IElementType>(Arrays.asList(elementType.getAllSuperTypes()));
		String trimmedID = getTrimmedID(elementType);
		if (elementType != null) {
			Activator.log.trace(Activator.PLCSTRATEGY_TRACE, "IElementType_ID: " + elementType.getId());
			Activator.log.trace(Activator.PLCSTRATEGY_TRACE, "IElementType_trimmedID: " + trimmedID);
		}

		for (StrategyElement strategy : strategies) {

			if (trimmedID == null) {
				continue;
			}

			// Filter on the specified element specializedType
			if (!filterOnElement(elementType, element, strategy)) {
				continue;
			}

			// Verify that the user specified a container to the strategy element
			if (!filterOnContainer(element, strategy)) {
				continue;
			}

			// Filtered list
			matchingStrategies.put(strategy.getId(), strategy);
		}

		return matchingStrategies.values();

	}


	/**
	 * Filter based on the element's {@link org.eclipse.gmf.runtime.emf.type.core.ElementType}
	 * and its possible {@link org.eclipse.gmf.runtime.emf.type.core.SpecializationType}
	 * 
	 * @param elementType
	 *            The element type of the element
	 * @param element
	 *            The element's EObject
	 * @param strategy
	 *            The strategy the element is being matched against
	 * @return
	 * 		If the element is a match to the strategy or not
	 */
	private boolean filterOnElement(IElementType elementType, EObject element, StrategyElement strategy) {
		IElementType strategyBaseType = ElementTypeRegistry.getInstance().getType(strategy.getBaseType());
		IElementType strategySpeType = ElementTypeRegistry.getInstance().getType(strategy.getSpecializedType());

		// 1- Filter on the element baseType
		if (strategyBaseType == null) {
			return false;
		}
		// TEST1 - BEGIN
		if (strategyBaseType instanceof ConfiguredHintedMetamodelElementType) {
			ConfiguredHintedMetamodelElementType metatype = (ConfiguredHintedMetamodelElementType) strategyBaseType;
			Activator.log.trace(Activator.PLCSTRATEGY_TYPES_TRACE, "ConfiguredHintedMetamodelElementType: " + metatype);
		}
		if (strategyBaseType instanceof ConfiguredHintedSpecializationElementType) {
			ConfiguredHintedSpecializationElementType spetype = (ConfiguredHintedSpecializationElementType) strategyBaseType;
			Activator.log.trace(Activator.PLCSTRATEGY_TYPES_TRACE, "ConfiguredHintedSpecializationElementType: " + spetype);
		}
		// TEST1 - END

		if (strategyBaseType.equals(ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Element"))) {
			return true;
		}
		// If the base type is a metamodel type, there are no matchers to use
		if (strategyBaseType instanceof ConfiguredHintedMetamodelElementType) {
			ConfiguredHintedMetamodelElementType metaType = (ConfiguredHintedMetamodelElementType) strategyBaseType;
			Activator.log.trace(Activator.PLCSTRATEGY_TYPES_TRACE, "element: " + metaType.getEClass());
			Activator.log.trace(Activator.PLCSTRATEGY_TYPES_TRACE, "element: " + element.eClass());

			if (!metaType.getEClass().equals(element.eClass())) {
				return false;
			}
		}
		// If the base type is a specialization type as the base type, there is a matcher available
		if (strategyBaseType instanceof ConfiguredHintedSpecializationElementType) {
			ConfiguredHintedSpecializationElementType speType = (ConfiguredHintedSpecializationElementType) strategyBaseType;

			if (speType.getMatcher() == null) {
				// FIXME there are no matchers for: Extend(UseCase),
				Activator.log.trace(Activator.PLCSTRATEGY_TRACE, speType.getId() + ", hasNoMatcher");
				return false;
			} else {
				Activator.log.trace(Activator.PLCSTRATEGY_TRACE, speType.getId());
				if (!speType.getMatcher().matches(element)) {
					return false;
				}
			}
		}

		// 2- Filter on the element specializedType
		if (strategySpeType != null && elementType != null && !Arrays.asList(elementType.getAllSuperTypes()).contains(strategySpeType)) {
			return false;
		}


		// All the previous conditions are met
		return true;
	}


	/**
	 * Go through all the specified strategy's containers
	 * 
	 * @param element
	 *            The element
	 * @param strategy
	 *            The strategy
	 * @return
	 * 		If the element's container is a match or not
	 */
	private boolean filterOnContainer(EObject element, StrategyElement strategy) {
		Collection<ElementContainer> strategyContainers = strategy.getElementContainers();
		Boolean skip = true;

		// There were no specified containers hence the condition is always verified
		if (strategyContainers == null || strategyContainers.size() < 1) {
			return true;
		}

		for (ElementContainer container : strategyContainers) {
			// Filter on the possible element's container
			skip = matchContainers(element.eContainer(), container);
			if (skip) {
				return true;
			}
		}

		// All the previous conditions are met
		return false;
	}


	/**
	 * Go through all the specified strategy's container and its containers
	 * 
	 * @param element
	 *            The element
	 * @param container
	 *            The {@link org.eclipse.papyrus.propertylifecycle.ElementContainer container} specified in the strategy
	 * @return
	 * 		If the element's container is a match or not
	 */
	private boolean matchContainers(EObject element, ElementContainer container) {
		IElementType containerBaseType = ElementTypeRegistry.getInstance().getType(container.getBaseType());
		IElementType containerSpeType = ElementTypeRegistry.getInstance().getType(container.getSpecializedType());

		// 1- Filter on the element baseType
		if (containerBaseType == null) {
			return false;
		}

		// If the base type is a metamodel type, there are no matchers to use
		if (containerBaseType instanceof ConfiguredHintedMetamodelElementType) {
			ConfiguredHintedMetamodelElementType metaType = (ConfiguredHintedMetamodelElementType) containerBaseType;
			Activator.log.trace(Activator.PLCSTRATEGY_TYPES_TRACE, "container: " + metaType.getEClass());
			Activator.log.trace(Activator.PLCSTRATEGY_TYPES_TRACE, "container: " + element.eClass());

			if (!metaType.getEClass().equals(element.eClass())) {
				return false;
			}
		}
		// If the base type is a specialization type as the base type, there is a matcher available
		if (containerBaseType instanceof ConfiguredHintedSpecializationElementType) {
			ConfiguredHintedSpecializationElementType speType = (ConfiguredHintedSpecializationElementType) containerBaseType;

			if (!speType.getMatcher().matches(element)) {
				return false;
			}
		}

		// 2- Filter on the element specializedType
		// As there are no way to link an eObject to a specific elementType we only verify that the specialized type is contained by the baseType
		if (containerSpeType != null && !Arrays.asList(containerBaseType.getAllSuperTypes()).contains(containerSpeType)) {
			return false;
		}

		// 3- Filter on the possible element's container
		if (container.getContainersContainer() != null) {
			if (!matchContainers(element.eContainer(), container.getContainersContainer())) {
				return false;
			}
		}


		// All the previous conditions are met
		return true;
	}


	/**
	 * The possible changes brought by the current strategies
	 * 
	 * @param strategies
	 *            The strategies applicable to the element
	 * @return
	 * 		The list containing all the features affected by the applicable strategies
	 */
	private Set<String> getAllModifiableFeatures(Collection<StrategyElement> strategies) {
		Set<String> modifiableFeatures = new HashSet<String>();

		for (StrategyElement strategy : strategies) {
			for (ElementProperty property : strategy.getElementProperties()) {
				// The user did not set a label
				if (property.getFeatureLabel() == null) {
					continue;
				}
				modifiableFeatures.add(property.getFeatureLabel());
			}
		}

		return modifiableFeatures;
	}


	/**
	 * filter the possible strategies applicable to the features of the element and selecting them by their associated priorities
	 * 
	 * @param strategies
	 *            The strategies applicable to the element
	 * @param modifiableFeatures
	 *            The features that can be modified by them
	 * @return
	 * 		The map detailing which changes will be applied to the modifiable features of the element
	 */
	private HashMap<String, ElementProperty> getNewFeatureValues(Collection<StrategyElement> strategies, Set<String> modifiableFeatures) {
		HashMap<String, ElementProperty> newFeatureValues = new HashMap<String, ElementProperty>();

		for (String featureLabel : modifiableFeatures) {
			ElementProperty priorityProperty = filterOnPriority(featureLabel, strategies);
			newFeatureValues.put(featureLabel, priorityProperty);
		}

		return newFeatureValues;
	}


	/**
	 * Filter the possible changes based on their priority
	 * 
	 * @param featureLabel
	 *            The label of the element's feature to change
	 * @param strategies
	 *            The strategies applicable to the element
	 * @return
	 * 		The selected behavior
	 */
	private ElementProperty filterOnPriority(String featureLabel, Collection<StrategyElement> strategies) {
		HashMap<Integer, ElementProperty> weightedStrategies = new HashMap<Integer, ElementProperty>();
		int priority = 0;

		for (StrategyElement strategy : strategies) {
			for (ElementProperty property : strategy.getElementProperties()) {
				if (featureLabel.equals(property.getFeatureLabel())) {
					// The user did not set a priority
					if (property.getPriority() == null) {
						weightedStrategies.put(0, property);
						continue;
					}

					// The user defined this property value to be immutable
					if (property.getPriority() < 0) {
						Activator.log.trace(Activator.PLCSTRATEGY_TRACE, "Immutable priority: " + property.getPriority());
						return property;
					}

					weightedStrategies.put(property.getPriority(), property);
					priority = priority < property.getPriority() ? property.getPriority() : priority;
				}
			}
		}

		Activator.log.trace(Activator.PLCSTRATEGY_TRACE, "Highest priority: " + priority);
		return weightedStrategies.get(priority);
	}


	/**
	 * Get the associated {@link org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand} corresponding to the modifications on the element
	 * 
	 * @param featureLabel
	 *            The label of the feature to edit
	 * @param featureStrategy
	 *            The strategy applied to this feature
	 * @return
	 * 		The {@link org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand}
	 *         with its associated {@link org.eclipse.gmf.runtime.common.core.command.CommandResult}
	 */
	private EditElementCommand getAssociatedCommand(String featureLabel, ElementProperty featureStrategy, AbstractEditCommandRequest request) {
		return new LifeCycleEditElementCommand("LifecycleEditCommand", element, request, featureLabel, featureStrategy, accessedProcessors);
	}


	/**
	 * This method calls on the {@link #setAssociatedPropertyValues()} for the contents of the edited element
	 * It will do so until the maximum depth has been reached (set in the constructor)
	 * 
	 * @param element
	 *            The edited element
	 */
	private void applyStrategiesToContents(EObject element) {
		// The max depth has been reached
		if (depth == 0) {
			return;
		}

		if (element.eContents().size() > 0) {
			// Increase the depth of the matching
			depth -= 1;
			for (EObject eObject : element.eContents()) {
				// Reinitialize the element to test against the current strategies
				this.element = eObject;
				// TODO find an alternative (more precise) to this default value
				this.elementType = ElementTypeRegistry.getInstance().getElementType(eObject.eClass());
				setAssociatedPropertyValues();
			}
		}
	}


	/**
	 * @param elementType
	 *            The element's type
	 * @return
	 * 		The element type ID trimmed of any graphical extension
	 */
	private String getTrimmedID(IElementType elementType) {
		if (elementType == null) {
			return null;
		}

		if (!graphicalIDMatcher(elementType.getId())) {
			// The ID is already not a graphical one
			return elementType.getId();
		}

		IElementType[] elementSuperTypes = elementType.getAllSuperTypes();
		LinkedList<IElementType> superTypes = new LinkedList<IElementType>(Arrays.asList(elementSuperTypes));
		for (int i = elementSuperTypes.length - 1; i > 0; i--) {
			String typeID = superTypes.get(i).getId();
			Activator.log.trace(Activator.PLCSTRATEGY_TRACE, "typeID: " + typeID);

			if (!graphicalIDMatcher(typeID)) {
				return typeID;
			}
		}

		// A chain of graphical IDs, albeit nigh impossible, could lead to this case
		return null;
	}


	/**
	 * Detect the presence of a graphical extension in the element type ID
	 * 
	 * @param typeID
	 *            The element type ID
	 * @return
	 * 		isGraphical or not
	 */
	private boolean graphicalIDMatcher(String typeID) {
		if (typeID.matches("[A-Za-z].+_[0-9]+")) { // $NON-NLS-1$
			// The type ID is graphical
			return true;
		}

		return false;
	}

}
