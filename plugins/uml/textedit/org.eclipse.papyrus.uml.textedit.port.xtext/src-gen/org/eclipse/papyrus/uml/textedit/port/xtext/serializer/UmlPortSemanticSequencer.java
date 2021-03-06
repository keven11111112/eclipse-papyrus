/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.port.xtext.serializer;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.uml.textedit.port.xtext.services.UmlPortGrammarAccess;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BooleanValue;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BoundSpecification;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.DefaultValueRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.IntValue;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierSpecification;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifiersRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.NoValue;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.NullValue;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.QualifiedName;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RealValue;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RedefinesRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.StringValue;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.SubsetsRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.TypeRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.VisibilityRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class UmlPortSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private UmlPortGrammarAccess grammarAccess;

	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == UmlPortPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case UmlPortPackage.BOOLEAN_VALUE:
				sequence_BooleanValue(context, (BooleanValue) semanticObject);
				return;
			case UmlPortPackage.BOUND_SPECIFICATION:
				sequence_BoundSpecification(context, (BoundSpecification) semanticObject);
				return;
			case UmlPortPackage.DEFAULT_VALUE_RULE:
				sequence_DefaultValueRule(context, (DefaultValueRule) semanticObject);
				return;
			case UmlPortPackage.INT_VALUE:
				sequence_IntValue(context, (IntValue) semanticObject);
				return;
			case UmlPortPackage.MODIFIER_SPECIFICATION:
				sequence_ModifierSpecification(context, (ModifierSpecification) semanticObject);
				return;
			case UmlPortPackage.MODIFIERS_RULE:
				sequence_ModifiersRule(context, (ModifiersRule) semanticObject);
				return;
			case UmlPortPackage.MULTIPLICITY_RULE:
				sequence_MultiplicityRule(context, (MultiplicityRule) semanticObject);
				return;
			case UmlPortPackage.NO_VALUE:
				sequence_NoValue(context, (NoValue) semanticObject);
				return;
			case UmlPortPackage.NULL_VALUE:
				sequence_NullValue(context, (NullValue) semanticObject);
				return;
			case UmlPortPackage.PORT_RULE:
				sequence_PortRule(context, (PortRule) semanticObject);
				return;
			case UmlPortPackage.QUALIFIED_NAME:
				sequence_QualifiedName(context, (QualifiedName) semanticObject);
				return;
			case UmlPortPackage.REAL_VALUE:
				sequence_RealValue(context, (RealValue) semanticObject);
				return;
			case UmlPortPackage.REDEFINES_RULE:
				sequence_RedefinesRule(context, (RedefinesRule) semanticObject);
				return;
			case UmlPortPackage.STRING_VALUE:
				sequence_StringValue(context, (StringValue) semanticObject);
				return;
			case UmlPortPackage.SUBSETS_RULE:
				sequence_SubsetsRule(context, (SubsetsRule) semanticObject);
				return;
			case UmlPortPackage.TYPE_RULE:
				sequence_TypeRule(context, (TypeRule) semanticObject);
				return;
			case UmlPortPackage.VISIBILITY_RULE:
				sequence_VisibilityRule(context, (VisibilityRule) semanticObject);
				return;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}

	/**
	 * Contexts:
	 * Value returns BooleanValue
	 * BooleanValue returns BooleanValue
	 *
	 * Constraint:
	 * literalBoolean=BooleanLiterals
	 */
	protected void sequence_BooleanValue(ISerializationContext context, BooleanValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UmlPortPackage.Literals.BOOLEAN_VALUE__LITERAL_BOOLEAN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlPortPackage.Literals.BOOLEAN_VALUE__LITERAL_BOOLEAN));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBooleanValueAccess().getLiteralBooleanBooleanLiteralsEnumRuleCall_0(), semanticObject.getLiteralBoolean());
		feeder.finish();
	}


	/**
	 * Contexts:
	 * BoundSpecification returns BoundSpecification
	 *
	 * Constraint:
	 * (value=UnlimitedLiteral | value=StringLiteral)
	 */
	protected void sequence_BoundSpecification(ISerializationContext context, BoundSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 * DefaultValueRule returns DefaultValueRule
	 *
	 * Constraint:
	 * default=Value
	 */
	protected void sequence_DefaultValueRule(ISerializationContext context, DefaultValueRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UmlPortPackage.Literals.DEFAULT_VALUE_RULE__DEFAULT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlPortPackage.Literals.DEFAULT_VALUE_RULE__DEFAULT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDefaultValueRuleAccess().getDefaultValueParserRuleCall_1_0(), semanticObject.getDefault());
		feeder.finish();
	}


	/**
	 * Contexts:
	 * Value returns IntValue
	 * IntValue returns IntValue
	 *
	 * Constraint:
	 * literalInteger=INT
	 */
	protected void sequence_IntValue(ISerializationContext context, IntValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UmlPortPackage.Literals.INT_VALUE__LITERAL_INTEGER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlPortPackage.Literals.INT_VALUE__LITERAL_INTEGER));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIntValueAccess().getLiteralIntegerINTTerminalRuleCall_0(), semanticObject.getLiteralInteger());
		feeder.finish();
	}


	/**
	 * Contexts:
	 * ModifierSpecification returns ModifierSpecification
	 *
	 * Constraint:
	 * (value=ModifierKind | redefines=RedefinesRule | subsets=SubsetsRule)
	 */
	protected void sequence_ModifierSpecification(ISerializationContext context, ModifierSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 * ModifiersRule returns ModifiersRule
	 *
	 * Constraint:
	 * (values+=ModifierSpecification values+=ModifierSpecification*)?
	 */
	protected void sequence_ModifiersRule(ISerializationContext context, ModifiersRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 * MultiplicityRule returns MultiplicityRule
	 *
	 * Constraint:
	 * (bounds+=BoundSpecification? bounds+=BoundSpecification)
	 */
	protected void sequence_MultiplicityRule(ISerializationContext context, MultiplicityRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 * Value returns NoValue
	 * NoValue returns NoValue
	 *
	 * Constraint:
	 * {NoValue}
	 */
	protected void sequence_NoValue(ISerializationContext context, NoValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 * Value returns NullValue
	 * NullValue returns NullValue
	 *
	 * Constraint:
	 * {NullValue}
	 */
	protected void sequence_NullValue(ISerializationContext context, NullValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 * PortRule returns PortRule
	 *
	 * Constraint:
	 * (
	 * visibility=VisibilityRule?
	 * derived?='/'?
	 * name=ID
	 * (conjugated?='~'? (type=TypeRule | typeUndefined?='<Undefined>'))?
	 * multiplicity=MultiplicityRule?
	 * modifiers=ModifiersRule?
	 * default=DefaultValueRule?
	 * )
	 */
	protected void sequence_PortRule(ISerializationContext context, PortRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 * QualifiedName returns QualifiedName
	 *
	 * Constraint:
	 * (path=[Namespace|ID] remaining=QualifiedName?)
	 */
	protected void sequence_QualifiedName(ISerializationContext context, QualifiedName semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 * Value returns RealValue
	 * RealValue returns RealValue
	 *
	 * Constraint:
	 * (integer=INT | fraction=INT | (integer=INT fraction=INT))
	 */
	protected void sequence_RealValue(ISerializationContext context, RealValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 * RedefinesRule returns RedefinesRule
	 *
	 * Constraint:
	 * port=[Port|ID]
	 */
	protected void sequence_RedefinesRule(ISerializationContext context, RedefinesRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UmlPortPackage.Literals.REDEFINES_RULE__PORT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlPortPackage.Literals.REDEFINES_RULE__PORT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRedefinesRuleAccess().getPortPortIDTerminalRuleCall_1_0_1(), semanticObject.eGet(UmlPortPackage.Literals.REDEFINES_RULE__PORT, false));
		feeder.finish();
	}


	/**
	 * Contexts:
	 * Value returns StringValue
	 * StringValue returns StringValue
	 *
	 * Constraint:
	 * literalString=STRING
	 */
	protected void sequence_StringValue(ISerializationContext context, StringValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UmlPortPackage.Literals.STRING_VALUE__LITERAL_STRING) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlPortPackage.Literals.STRING_VALUE__LITERAL_STRING));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStringValueAccess().getLiteralStringSTRINGTerminalRuleCall_0(), semanticObject.getLiteralString());
		feeder.finish();
	}


	/**
	 * Contexts:
	 * SubsetsRule returns SubsetsRule
	 *
	 * Constraint:
	 * port=[Port|ID]
	 */
	protected void sequence_SubsetsRule(ISerializationContext context, SubsetsRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UmlPortPackage.Literals.SUBSETS_RULE__PORT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlPortPackage.Literals.SUBSETS_RULE__PORT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSubsetsRuleAccess().getPortPortIDTerminalRuleCall_1_0_1(), semanticObject.eGet(UmlPortPackage.Literals.SUBSETS_RULE__PORT, false));
		feeder.finish();
	}


	/**
	 * Contexts:
	 * TypeRule returns TypeRule
	 *
	 * Constraint:
	 * (path=QualifiedName? type=[Classifier|ID])
	 */
	protected void sequence_TypeRule(ISerializationContext context, TypeRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 * VisibilityRule returns VisibilityRule
	 *
	 * Constraint:
	 * visibility=VisibilityKind
	 */
	protected void sequence_VisibilityRule(ISerializationContext context, VisibilityRule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UmlPortPackage.Literals.VISIBILITY_RULE__VISIBILITY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlPortPackage.Literals.VISIBILITY_RULE__VISIBILITY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVisibilityRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0(), semanticObject.getVisibility());
		feeder.finish();
	}


}
