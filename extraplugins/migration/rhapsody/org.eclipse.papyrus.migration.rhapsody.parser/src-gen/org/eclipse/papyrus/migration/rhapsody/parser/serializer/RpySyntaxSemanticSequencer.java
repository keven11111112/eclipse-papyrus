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
package org.eclipse.papyrus.migration.rhapsody.parser.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeature;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFile;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNode;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNodeList;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySimpleValueElement;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMap;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMapEntry;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpySyntaxPackage;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList;
import org.eclipse.papyrus.migration.rhapsody.parser.services.RpySyntaxGrammarAccess;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class RpySyntaxSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private RpySyntaxGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == RpySyntaxPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case RpySyntaxPackage.RPY_FEATURE:
				sequence_RpyFeature(context, (RpyFeature) semanticObject); 
				return; 
			case RpySyntaxPackage.RPY_FILE:
				sequence_RpyFile(context, (RpyFile) semanticObject); 
				return; 
			case RpySyntaxPackage.RPY_NODE:
				sequence_RpyNode(context, (RpyNode) semanticObject); 
				return; 
			case RpySyntaxPackage.RPY_NODE_LIST:
				sequence_RpyNodeList(context, (RpyNodeList) semanticObject); 
				return; 
			case RpySyntaxPackage.RPY_SIMPLE_VALUE_ELEMENT:
				sequence_RpySimpleValueElement(context, (RpySimpleValueElement) semanticObject); 
				return; 
			case RpySyntaxPackage.RPY_STRING_MAP:
				sequence_RpyStringMap(context, (RpyStringMap) semanticObject); 
				return; 
			case RpySyntaxPackage.RPY_STRING_MAP_ENTRY:
				sequence_RpyStringMapEntry(context, (RpyStringMapEntry) semanticObject); 
				return; 
			case RpySyntaxPackage.SIMPLE_VALUE_LIST:
				sequence_SimpleValueList(context, (SimpleValueList) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     RpyContent returns RpyFeature
	 *     RpyFeature returns RpyFeature
	 *
	 * Constraint:
	 *     (name=ID value=RpyFeatureValue)
	 */
	protected void sequence_RpyFeature(ISerializationContext context, RpyFeature semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RpySyntaxPackage.Literals.RPY_CONTENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RpySyntaxPackage.Literals.RPY_CONTENT__NAME));
			if (transientValues.isValueTransient(semanticObject, RpySyntaxPackage.Literals.RPY_FEATURE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RpySyntaxPackage.Literals.RPY_FEATURE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRpyFeatureAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getRpyFeatureAccess().getValueRpyFeatureValueParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     RpyFile returns RpyFile
	 *
	 * Constraint:
	 *     (version=RPY_VERSION contents+=RpyContent*)
	 */
	protected void sequence_RpyFile(ISerializationContext context, RpyFile semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RpyFeatureValue returns RpyNodeList
	 *     RpyNodeList returns RpyNodeList
	 *
	 * Constraint:
	 *     values+=RpyNode+
	 */
	protected void sequence_RpyNodeList(ISerializationContext context, RpyNodeList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RpyContent returns RpyNode
	 *     RpyNode returns RpyNode
	 *
	 * Constraint:
	 *     (name=ID contents+=RpyContent+)
	 */
	protected void sequence_RpyNode(ISerializationContext context, RpyNode semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RpySimpleValueElement returns RpySimpleValueElement
	 *
	 * Constraint:
	 *     values+=VALUE_TERMINAL*
	 */
	protected void sequence_RpySimpleValueElement(ISerializationContext context, RpySimpleValueElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RpyStringMapEntry returns RpyStringMapEntry
	 *
	 * Constraint:
	 *     (key=STRING value=STRING)
	 */
	protected void sequence_RpyStringMapEntry(ISerializationContext context, RpyStringMapEntry semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RpySyntaxPackage.Literals.RPY_STRING_MAP_ENTRY__KEY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RpySyntaxPackage.Literals.RPY_STRING_MAP_ENTRY__KEY));
			if (transientValues.isValueTransient(semanticObject, RpySyntaxPackage.Literals.RPY_STRING_MAP_ENTRY__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RpySyntaxPackage.Literals.RPY_STRING_MAP_ENTRY__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRpyStringMapEntryAccess().getKeySTRINGTerminalRuleCall_0_0(), semanticObject.getKey());
		feeder.accept(grammarAccess.getRpyStringMapEntryAccess().getValueSTRINGTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     RpyFeatureValue returns RpyStringMap
	 *     RpyStringMap returns RpyStringMap
	 *
	 * Constraint:
	 *     entries+=RpyStringMapEntry+
	 */
	protected void sequence_RpyStringMap(ISerializationContext context, RpyStringMap semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RpyFeatureValue returns SimpleValueList
	 *     SimpleValueList returns SimpleValueList
	 *
	 * Constraint:
	 *     (isOldID?='OLDID'? isGUID?='GUID'? valueElements+=RpySimpleValueElement+)
	 */
	protected void sequence_SimpleValueList(ISerializationContext context, SimpleValueList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
