/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.moka.composites.Semantics.Actions.IntermediateActions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.CompositeStructures.StructuredClasses.CS_InteractionPoint;
import org.eclipse.papyrus.moka.composites.Semantics.CompositeStructures.StructuredClasses.CS_Link;
import org.eclipse.papyrus.moka.composites.Semantics.CompositeStructures.StructuredClasses.CS_Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.IntermediateActions.RemoveStructuralFeatureValueActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.FeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Link;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.StructuredValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.UnlimitedNaturalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ChoiceStrategy;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.RemoveStructuralFeatureValueAction;
import org.eclipse.uml2.uml.StructuralFeature;

public class CS_RemoveStructuralFeatureValueActionActivation extends RemoveStructuralFeatureValueActionActivation {

	@Override
	public void doAction() {
		// Get the values of the object and value input pins. 
		// If the given feature is an association end, then destroy any
		// matching links. Otherwise, if the object input is a structural
		// value, remove values from the given feature and destroy all links
		// in which the removed values are involved.
		// If isRemoveDuplicates is true, then destroy all current matching
		// links or remove all values equal to the input value.
		// If isRemoveDuplicates is false and there is no removeAt input pin,
		// remove any one feature value equal to the input value (if there are
		// any that are equal).
		// If isRemoveDuplicates is false, and there is a removeAt input pin
		// remove the feature value at that position.
		RemoveStructuralFeatureValueAction action = (RemoveStructuralFeatureValueAction) (this.node);
		StructuralFeature feature = action.getStructuralFeature();
		Association association = this.getAssociation(feature);
		Value value = this.takeTokens(action.getObject()).get(0);
		Value inputValue = null;
		if (action.getValue() != null) {
			// NOTE: Multiplicity of the value input pin is required to be 1..1.
			inputValue = this.takeTokens(action.getValue()).get(0);
		}
		int removeAt = 0;
		if (action.getRemoveAt() != null) {
			removeAt = ((UnlimitedNaturalValue) this.takeTokens(action.getRemoveAt()).get(0)).value;
		}
		if (association != null) {
			List<Link> links = this.getMatchingLinksForEndValue(association, feature, value, inputValue);
			if (action.isRemoveDuplicates()) {
				for (int i = 0; i < links.size(); i++) {
					Link link = links.get(i);
					link.destroy();
				}
			} else if (action.getRemoveAt() == null) {
				// *** If there is more than one matching link,
				// non-deterministically choose one. ***
				if (links.size() > 0) {
					int i = ((ChoiceStrategy) this.getExecutionLocus().factory.getStrategy("choice")).choose(links.size());
					links.get(i - 1).destroy();
				}
			} else {
				boolean notFound = true;
				int i = 1;
				while (notFound & i <= links.size()) {
					Link link = links.get(i - 1);
					if (link.getFeatureValue(feature).position == removeAt) {
						notFound = false;
						link.destroy();
					}
				}
			}
		} else if (value instanceof StructuredValue) {
			// If the value is a data value, then it must be copied before
			// any change is made.
			if (!(value instanceof Reference)) {
				value = value.copy();
			}
			FeatureValue featureValue = ((StructuredValue) value).getFeatureValue(action.getStructuralFeature());
			List<Value> removedValues = new ArrayList<Value>();
			if (action.isRemoveDuplicates()) {
				int j = this.position(inputValue, featureValue.values, 1);
				while (j > 0) {
					removedValues.add(featureValue.values.get(j - 1));
					featureValue.values.remove(j - 1);
					j = this.position(inputValue, featureValue.values, j);
				}
			} else if (action.getRemoveAt() == null) {
				List<Integer> positions = new ArrayList<Integer>();
				int j = this.position(inputValue, featureValue.values, 1);
				while (j > 0) {
					positions.add(j);
					j = this.position(inputValue, featureValue.values, j);
				}
				if (positions.size() > 0) {
					// *** Nondeterministically choose which value to remove.
					// ***
					int k = ((ChoiceStrategy) this.getExecutionLocus().factory.getStrategy("choice")).choose(positions.size());
					removedValues.add(featureValue.values.get(positions.get(k - 1) - 1));
					featureValue.values.remove(positions.get(k - 1) - 1);
				}
			} else {
				if (featureValue.values.size() >= removeAt) {
					removedValues.add(featureValue.values.get(removeAt - 1));
					featureValue.values.remove(removeAt - 1);
				}
			}
			// When values are removed from the list of values associated to the feature 
			// (in the context of the target), these latter may be involved in links representing
			// instance of connectors. If this is the case, links in which the removed values are
			// involved are destroyed.
			for(int i = 0; i < removedValues.size(); i++){
				List<CS_Link> linkToDestroy = this.getLinksToDestroy((StructuredValue)value, feature, removedValues.get(i));
				for(int j = 0; j < linkToDestroy.size(); j++){
					linkToDestroy.get(j).destroy();
				}
			}
		}
		if (action.getResult() != null) {
			this.putToken(action.getResult(), value);
		}
	}
	
	public List<CS_Link> getLinksToDestroy(StructuredValue value, StructuralFeature feature, Value removedValue) {
		// Get all links that are required to be destroyed due to the removal of the removedValue
		List<CS_Link> linksToDestroy = new ArrayList<CS_Link>();
		if (value instanceof CS_Reference) {
			CS_Reference context = (CS_Reference) value;
			// Retrieves the feature values for the structural feature associated with this action,
			// in the context of this reference
			if (feature instanceof Port) {
				// The removed value is an interaction point.
				// All links in which this interaction is involved must be destroyed.
				CS_InteractionPoint interactionPoint = (CS_InteractionPoint) removedValue;
				List<CS_Link> connectorInstances = context.compositeReferent.getLinks(interactionPoint);
				for (int j = 0; j < connectorInstances.size(); j++) {
					CS_Link link = connectorInstances.get(j);
					linksToDestroy.add(link);
				}
			} else { 
				// Feature is not a Port. Search for all potential link
				// ends existing in the context of this object.
				List<Value> allValuesForFeature = new ArrayList<Value>();
				for (int i = 0; i < context.referent.featureValues.size(); i++) {
					StructuralFeature currentFeature = context.referent.featureValues.get(i).feature;
					if(feature != currentFeature){
						List<Value> values = this.getPotentialLinkEnds(context, currentFeature);
						for (int j = 0; j < values.size(); j++) {
							allValuesForFeature.add(values.get(j));
						}
					}
				}
				// Retrieves all links available at the locus
				List<ExtensionalValue> extensionalValues = this.getExecutionLocus().extensionalValues;
				List<CS_Link> allLinks = new ArrayList<CS_Link>();
				for (int i = 0; i < extensionalValues.size(); i++) {
					ExtensionalValue extensionalValue = extensionalValues.get(i);
					if (extensionalValue instanceof CS_Link) {
						allLinks.add((CS_Link) extensionalValue);
					}
				}
				// In the set of links involving potential link ends. Search for all
				// links that involve the removed value in other end. Any link in that
				// fulfill this condition is registered in the set of link to be destroyed.
				for (int i = 0; i < allLinks.size(); i++) {
					CS_Link link = allLinks.get(i);
					boolean linkHasToBeDestroyed = false;
					for (int j = 0; j < allValuesForFeature.size() && !linkHasToBeDestroyed; j++) {
						Value v = allValuesForFeature.get(j);
						StructuralFeature featureForV = link.getFeature(v);
						if (featureForV != null) {
							for (int k = 0; k < link.featureValues.size() && !linkHasToBeDestroyed; k++) {
								FeatureValue otherFeatureValue = link.featureValues.get(k);
								if (otherFeatureValue.feature != featureForV) {
									for (int l = 0; l < otherFeatureValue.values.size() && !linkHasToBeDestroyed; l++) {
										if(otherFeatureValue.values.get(l) == removedValue){
											linkHasToBeDestroyed = true;
										}
									}
								}
							}
						}
					}
					if (linkHasToBeDestroyed) {
						linksToDestroy.add(link);
					}
				}
			}
		}
		return linksToDestroy;
	}
	
	public List<Value> getPotentialLinkEnds(CS_Reference context, StructuralFeature feature) {
		// Retrieves all feature values for the context object for the given feature,
		// as well as all interaction point for these values
		List<Value> potentialLinkEnds = new ArrayList<Value>();
		FeatureValue featureValue = context.getFeatureValue(feature);
		for (int i = 0; i < featureValue.values.size(); i++) {
			Value v = featureValue.values.get(i);
			potentialLinkEnds.add(v);
			if (v instanceof CS_Reference) {
				// add all interaction points associated with v
				for (int j = 0; j < ((CS_Reference) v).referent.featureValues.size(); j++) {
					if (((CS_Reference) v).referent.featureValues.get(j).feature instanceof Port) {
						List<Value> interactionPoints = (((CS_Reference) v).referent.featureValues.get(j)).values;
						for (int k = 0; k < interactionPoints.size(); k++) {
							potentialLinkEnds.add(interactionPoints.get(k));
						}
					}
				}
			}
		}
		return potentialLinkEnds;
	}
	
}
