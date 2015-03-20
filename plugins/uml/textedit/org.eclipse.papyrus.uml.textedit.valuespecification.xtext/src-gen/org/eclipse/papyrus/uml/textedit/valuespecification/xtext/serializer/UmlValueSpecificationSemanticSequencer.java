package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.services.UmlValueSpecificationGrammarAccess;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralBooleanRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralIntegerOrUnlimitedNaturalRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralNullRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralRealRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralStringRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationPackage;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UndefinedRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.VisibilityKind;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class UmlValueSpecificationSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private UmlValueSpecificationGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == UmlValueSpecificationPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case UmlValueSpecificationPackage.ABSTRACT_RULE:
				if(context == grammarAccess.getAbstractRuleRule()) {
					sequence_AbstractRule(context, (AbstractRule) semanticObject); 
					return; 
				}
				else break;
			case UmlValueSpecificationPackage.LITERAL_BOOLEAN_RULE:
				if(context == grammarAccess.getLiteralBooleanRuleRule()) {
					sequence_LiteralBooleanRule(context, (LiteralBooleanRule) semanticObject); 
					return; 
				}
				else break;
			case UmlValueSpecificationPackage.LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE:
				if(context == grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleRule()) {
					sequence_LiteralIntegerOrUnlimitedNaturalRule(context, (LiteralIntegerOrUnlimitedNaturalRule) semanticObject); 
					return; 
				}
				else break;
			case UmlValueSpecificationPackage.LITERAL_NULL_RULE:
				if(context == grammarAccess.getLiteralNullRuleRule()) {
					sequence_LiteralNullRule(context, (LiteralNullRule) semanticObject); 
					return; 
				}
				else break;
			case UmlValueSpecificationPackage.LITERAL_REAL_RULE:
				if(context == grammarAccess.getLiteralRealRuleRule()) {
					sequence_LiteralRealRule(context, (LiteralRealRule) semanticObject); 
					return; 
				}
				else break;
			case UmlValueSpecificationPackage.LITERAL_STRING_RULE:
				if(context == grammarAccess.getLiteralStringRuleRule()) {
					sequence_LiteralStringRule(context, (LiteralStringRule) semanticObject); 
					return; 
				}
				else break;
			case UmlValueSpecificationPackage.UNDEFINED_RULE:
				if(context == grammarAccess.getUndefinedRuleRule()) {
					sequence_UndefinedRule(context, (UndefinedRule) semanticObject); 
					return; 
				}
				else break;
			case UmlValueSpecificationPackage.VISIBILITY_KIND:
				if(context == grammarAccess.getVisibilityKindRule()) {
					sequence_VisibilityKind(context, (VisibilityKind) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             visibility=VisibilityKind? 
	 *             name=ID? 
	 *             (
	 *                 value=LiteralBooleanRule | 
	 *                 value=LiteralIntegerOrUnlimitedNaturalRule | 
	 *                 value=LiteralRealRule | 
	 *                 value=LiteralNullRule | 
	 *                 value=LiteralStringRule | 
	 *                 instanceSpecification=[InstanceSpecification|ID]
	 *             )
	 *         ) | 
	 *         undefined=UndefinedRule
	 *     )
	 */
	protected void sequence_AbstractRule(EObject context, AbstractRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value='true' | value='false')
	 */
	protected void sequence_LiteralBooleanRule(EObject context, LiteralBooleanRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=INT
	 */
	protected void sequence_LiteralIntegerOrUnlimitedNaturalRule(EObject context, LiteralIntegerOrUnlimitedNaturalRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlValueSpecificationPackage.Literals.LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlValueSpecificationPackage.Literals.LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getValueINTTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value='null'
	 */
	protected void sequence_LiteralNullRule(EObject context, LiteralNullRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlValueSpecificationPackage.Literals.LITERAL_NULL_RULE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlValueSpecificationPackage.Literals.LITERAL_NULL_RULE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLiteralNullRuleAccess().getValueNullKeyword_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=DOUBLE
	 */
	protected void sequence_LiteralRealRule(EObject context, LiteralRealRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlValueSpecificationPackage.Literals.LITERAL_REAL_RULE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlValueSpecificationPackage.Literals.LITERAL_REAL_RULE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLiteralRealRuleAccess().getValueDOUBLETerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_LiteralStringRule(EObject context, LiteralStringRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlValueSpecificationPackage.Literals.LITERAL_STRING_RULE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlValueSpecificationPackage.Literals.LITERAL_STRING_RULE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLiteralStringRuleAccess().getValueSTRINGTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value='<Undefined>'
	 */
	protected void sequence_UndefinedRule(EObject context, UndefinedRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlValueSpecificationPackage.Literals.UNDEFINED_RULE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlValueSpecificationPackage.Literals.UNDEFINED_RULE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUndefinedRuleAccess().getValueUndefinedKeyword_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (public='+' | private='-' | protected='#' | package='~')
	 */
	protected void sequence_VisibilityKind(EObject context, VisibilityKind semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
