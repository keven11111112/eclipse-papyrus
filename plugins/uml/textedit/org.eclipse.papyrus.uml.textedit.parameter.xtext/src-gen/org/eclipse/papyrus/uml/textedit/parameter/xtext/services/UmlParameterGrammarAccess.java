/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.parameter.xtext.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.papyrus.uml.textedit.common.xtext.services.UmlCommonGrammarAccess;

@Singleton
public class UmlParameterGrammarAccess extends AbstractGrammarElementFinder {


	public class ParameterRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ParameterRule");
		private final Group cGroup = (Group) rule.eContents().get(1);
		private final Assignment cVisibilityAssignment_0 = (Assignment) cGroup.eContents().get(0);
		private final RuleCall cVisibilityVisibilityKindEnumRuleCall_0_0 = (RuleCall) cVisibilityAssignment_0.eContents().get(0);
		private final Assignment cDirectionAssignment_1 = (Assignment) cGroup.eContents().get(1);
		private final RuleCall cDirectionDirectionEnumRuleCall_1_0 = (RuleCall) cDirectionAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment) cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall) cNameAssignment_2.eContents().get(0);
		private final Keyword cColonKeyword_3 = (Keyword) cGroup.eContents().get(3);
		private final Alternatives cAlternatives_4 = (Alternatives) cGroup.eContents().get(4);
		private final Assignment cTypeAssignment_4_0 = (Assignment) cAlternatives_4.eContents().get(0);
		private final RuleCall cTypeTypeRuleParserRuleCall_4_0_0 = (RuleCall) cTypeAssignment_4_0.eContents().get(0);
		private final Keyword cUndefinedKeyword_4_1 = (Keyword) cAlternatives_4.eContents().get(1);
		private final Assignment cMultiplicityAssignment_5 = (Assignment) cGroup.eContents().get(5);
		private final RuleCall cMultiplicityMultiplicityRuleParserRuleCall_5_0 = (RuleCall) cMultiplicityAssignment_5.eContents().get(0);
		private final Assignment cModifiersAssignment_6 = (Assignment) cGroup.eContents().get(6);
		private final RuleCall cModifiersModifiersRuleParserRuleCall_6_0 = (RuleCall) cModifiersAssignment_6.eContents().get(0);
		private final Assignment cEffectAssignment_7 = (Assignment) cGroup.eContents().get(7);
		private final RuleCall cEffectEffectRuleParserRuleCall_7_0 = (RuleCall) cEffectAssignment_7.eContents().get(0);

		// ParameterRule:
		//
		// visibility=VisibilityKind direction=Direction name=ID ":" (type=TypeRule | "<Undefined>")
		//
		// multiplicity=MultiplicityRule? modifiers=ModifiersRule? effect=EffectRule;
		@Override
		public ParserRule getRule() {
			return rule;
		}

		// visibility=VisibilityKind direction=Direction name=ID ":" (type=TypeRule | "<Undefined>") multiplicity=MultiplicityRule?
		//
		// modifiers=ModifiersRule? effect=EffectRule
		public Group getGroup() {
			return cGroup;
		}

		// visibility=VisibilityKind
		public Assignment getVisibilityAssignment_0() {
			return cVisibilityAssignment_0;
		}

		// VisibilityKind
		public RuleCall getVisibilityVisibilityKindEnumRuleCall_0_0() {
			return cVisibilityVisibilityKindEnumRuleCall_0_0;
		}

		// direction=Direction
		public Assignment getDirectionAssignment_1() {
			return cDirectionAssignment_1;
		}

		// Direction
		public RuleCall getDirectionDirectionEnumRuleCall_1_0() {
			return cDirectionDirectionEnumRuleCall_1_0;
		}

		// name=ID
		public Assignment getNameAssignment_2() {
			return cNameAssignment_2;
		}

		// ID
		public RuleCall getNameIDTerminalRuleCall_2_0() {
			return cNameIDTerminalRuleCall_2_0;
		}

		// ":"
		public Keyword getColonKeyword_3() {
			return cColonKeyword_3;
		}

		// type=TypeRule | "<Undefined>"
		public Alternatives getAlternatives_4() {
			return cAlternatives_4;
		}

		// type=TypeRule
		public Assignment getTypeAssignment_4_0() {
			return cTypeAssignment_4_0;
		}

		// TypeRule
		public RuleCall getTypeTypeRuleParserRuleCall_4_0_0() {
			return cTypeTypeRuleParserRuleCall_4_0_0;
		}

		// "<Undefined>"
		public Keyword getUndefinedKeyword_4_1() {
			return cUndefinedKeyword_4_1;
		}

		// multiplicity=MultiplicityRule?
		public Assignment getMultiplicityAssignment_5() {
			return cMultiplicityAssignment_5;
		}

		// MultiplicityRule
		public RuleCall getMultiplicityMultiplicityRuleParserRuleCall_5_0() {
			return cMultiplicityMultiplicityRuleParserRuleCall_5_0;
		}

		// modifiers=ModifiersRule?
		public Assignment getModifiersAssignment_6() {
			return cModifiersAssignment_6;
		}

		// ModifiersRule
		public RuleCall getModifiersModifiersRuleParserRuleCall_6_0() {
			return cModifiersModifiersRuleParserRuleCall_6_0;
		}

		// effect=EffectRule
		public Assignment getEffectAssignment_7() {
			return cEffectAssignment_7;
		}

		// EffectRule
		public RuleCall getEffectEffectRuleParserRuleCall_7_0() {
			return cEffectEffectRuleParserRuleCall_7_0;
		}
	}

	public class ModifiersRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ModifiersRule");
		private final Group cGroup = (Group) rule.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_0 = (Keyword) cGroup.eContents().get(0);
		private final Assignment cValuesAssignment_1 = (Assignment) cGroup.eContents().get(1);
		private final RuleCall cValuesModifierSpecificationParserRuleCall_1_0 = (RuleCall) cValuesAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group) cGroup.eContents().get(2);
		private final Keyword cCommaKeyword_2_0 = (Keyword) cGroup_2.eContents().get(0);
		private final Assignment cValuesAssignment_2_1 = (Assignment) cGroup_2.eContents().get(1);
		private final RuleCall cValuesModifierSpecificationParserRuleCall_2_1_0 = (RuleCall) cValuesAssignment_2_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword) cGroup.eContents().get(3);

		// ModifiersRule:
		//
		// "{" values+=ModifierSpecification ("," values+=ModifierSpecification)* "}";
		@Override
		public ParserRule getRule() {
			return rule;
		}

		// "{" values+=ModifierSpecification ("," values+=ModifierSpecification)* "}"
		public Group getGroup() {
			return cGroup;
		}

		// "{"
		public Keyword getLeftCurlyBracketKeyword_0() {
			return cLeftCurlyBracketKeyword_0;
		}

		// values+=ModifierSpecification
		public Assignment getValuesAssignment_1() {
			return cValuesAssignment_1;
		}

		// ModifierSpecification
		public RuleCall getValuesModifierSpecificationParserRuleCall_1_0() {
			return cValuesModifierSpecificationParserRuleCall_1_0;
		}

		// ("," values+=ModifierSpecification)*
		public Group getGroup_2() {
			return cGroup_2;
		}

		// ","
		public Keyword getCommaKeyword_2_0() {
			return cCommaKeyword_2_0;
		}

		// values+=ModifierSpecification
		public Assignment getValuesAssignment_2_1() {
			return cValuesAssignment_2_1;
		}

		// ModifierSpecification
		public RuleCall getValuesModifierSpecificationParserRuleCall_2_1_0() {
			return cValuesModifierSpecificationParserRuleCall_2_1_0;
		}

		// "}"
		public Keyword getRightCurlyBracketKeyword_3() {
			return cRightCurlyBracketKeyword_3;
		}
	}

	public class ModifierSpecificationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ModifierSpecification");
		private final Assignment cValueAssignment = (Assignment) rule.eContents().get(1);
		private final RuleCall cValueModifierKindEnumRuleCall_0 = (RuleCall) cValueAssignment.eContents().get(0);

		// ModifierSpecification:
		//
		// value=ModifierKind;
		@Override
		public ParserRule getRule() {
			return rule;
		}

		// value=ModifierKind
		public Assignment getValueAssignment() {
			return cValueAssignment;
		}

		// ModifierKind
		public RuleCall getValueModifierKindEnumRuleCall_0() {
			return cValueModifierKindEnumRuleCall_0;
		}
	}

	public class EffectRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EffectRule");
		private final Group cGroup = (Group) rule.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_0 = (Keyword) cGroup.eContents().get(0);
		private final Keyword cEffectKeyword_1 = (Keyword) cGroup.eContents().get(1);
		private final Assignment cEffectKindAssignment_2 = (Assignment) cGroup.eContents().get(2);
		private final RuleCall cEffectKindEffectKindEnumRuleCall_2_0 = (RuleCall) cEffectKindAssignment_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword) cGroup.eContents().get(3);

		// EffectRule:
		//
		// "{" "effect: " effectKind=EffectKind "}";
		@Override
		public ParserRule getRule() {
			return rule;
		}

		// "{" "effect: " effectKind=EffectKind "}"
		public Group getGroup() {
			return cGroup;
		}

		// "{"
		public Keyword getLeftCurlyBracketKeyword_0() {
			return cLeftCurlyBracketKeyword_0;
		}

		// "effect: "
		public Keyword getEffectKeyword_1() {
			return cEffectKeyword_1;
		}

		// effectKind=EffectKind
		public Assignment getEffectKindAssignment_2() {
			return cEffectKindAssignment_2;
		}

		// EffectKind
		public RuleCall getEffectKindEffectKindEnumRuleCall_2_0() {
			return cEffectKindEffectKindEnumRuleCall_2_0;
		}

		// "}"
		public Keyword getRightCurlyBracketKeyword_3() {
			return cRightCurlyBracketKeyword_3;
		}
	}


	public class ModifierKindElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "ModifierKind");
		private final Alternatives cAlternatives = (Alternatives) rule.eContents().get(1);
		private final EnumLiteralDeclaration cEXCEPTIONEnumLiteralDeclaration_0 = (EnumLiteralDeclaration) cAlternatives.eContents().get(0);
		private final Keyword cEXCEPTIONExceptionKeyword_0_0 = (Keyword) cEXCEPTIONEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cSTREAMEnumLiteralDeclaration_1 = (EnumLiteralDeclaration) cAlternatives.eContents().get(1);
		private final Keyword cSTREAMStreamKeyword_1_0 = (Keyword) cSTREAMEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cORDEREDEnumLiteralDeclaration_2 = (EnumLiteralDeclaration) cAlternatives.eContents().get(2);
		private final Keyword cORDEREDOrderedKeyword_2_0 = (Keyword) cORDEREDEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cUNIQUEEnumLiteralDeclaration_3 = (EnumLiteralDeclaration) cAlternatives.eContents().get(3);
		private final Keyword cUNIQUEUniqueKeyword_3_0 = (Keyword) cUNIQUEEnumLiteralDeclaration_3.eContents().get(0);

		// enum ModifierKind:
		//
		// EXCEPTION="exception" | STREAM="stream" | ORDERED="ordered" | UNIQUE="unique";
		@Override
		public EnumRule getRule() {
			return rule;
		}

		// EXCEPTION="exception" | STREAM="stream" | ORDERED="ordered" | UNIQUE="unique"
		public Alternatives getAlternatives() {
			return cAlternatives;
		}

		// EXCEPTION="exception"
		public EnumLiteralDeclaration getEXCEPTIONEnumLiteralDeclaration_0() {
			return cEXCEPTIONEnumLiteralDeclaration_0;
		}

		// "exception"
		public Keyword getEXCEPTIONExceptionKeyword_0_0() {
			return cEXCEPTIONExceptionKeyword_0_0;
		}

		// STREAM="stream"
		public EnumLiteralDeclaration getSTREAMEnumLiteralDeclaration_1() {
			return cSTREAMEnumLiteralDeclaration_1;
		}

		// "stream"
		public Keyword getSTREAMStreamKeyword_1_0() {
			return cSTREAMStreamKeyword_1_0;
		}

		// ORDERED="ordered"
		public EnumLiteralDeclaration getORDEREDEnumLiteralDeclaration_2() {
			return cORDEREDEnumLiteralDeclaration_2;
		}

		// "ordered"
		public Keyword getORDEREDOrderedKeyword_2_0() {
			return cORDEREDOrderedKeyword_2_0;
		}

		// UNIQUE="unique"
		public EnumLiteralDeclaration getUNIQUEEnumLiteralDeclaration_3() {
			return cUNIQUEEnumLiteralDeclaration_3;
		}

		// "unique"
		public Keyword getUNIQUEUniqueKeyword_3_0() {
			return cUNIQUEUniqueKeyword_3_0;
		}
	}

	public class EffectKindElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "EffectKind");
		private final Alternatives cAlternatives = (Alternatives) rule.eContents().get(1);
		private final EnumLiteralDeclaration cCREATEEnumLiteralDeclaration_0 = (EnumLiteralDeclaration) cAlternatives.eContents().get(0);
		private final Keyword cCREATECreateKeyword_0_0 = (Keyword) cCREATEEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cREADEnumLiteralDeclaration_1 = (EnumLiteralDeclaration) cAlternatives.eContents().get(1);
		private final Keyword cREADReadKeyword_1_0 = (Keyword) cREADEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cUPDATEEnumLiteralDeclaration_2 = (EnumLiteralDeclaration) cAlternatives.eContents().get(2);
		private final Keyword cUPDATEUpdateKeyword_2_0 = (Keyword) cUPDATEEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cDELETEEnumLiteralDeclaration_3 = (EnumLiteralDeclaration) cAlternatives.eContents().get(3);
		private final Keyword cDELETEDeleteKeyword_3_0 = (Keyword) cDELETEEnumLiteralDeclaration_3.eContents().get(0);

		// enum EffectKind:
		//
		// CREATE="create" | READ="read" | UPDATE="update" | DELETE="delete";
		@Override
		public EnumRule getRule() {
			return rule;
		}

		// CREATE="create" | READ="read" | UPDATE="update" | DELETE="delete"
		public Alternatives getAlternatives() {
			return cAlternatives;
		}

		// CREATE="create"
		public EnumLiteralDeclaration getCREATEEnumLiteralDeclaration_0() {
			return cCREATEEnumLiteralDeclaration_0;
		}

		// "create"
		public Keyword getCREATECreateKeyword_0_0() {
			return cCREATECreateKeyword_0_0;
		}

		// READ="read"
		public EnumLiteralDeclaration getREADEnumLiteralDeclaration_1() {
			return cREADEnumLiteralDeclaration_1;
		}

		// "read"
		public Keyword getREADReadKeyword_1_0() {
			return cREADReadKeyword_1_0;
		}

		// UPDATE="update"
		public EnumLiteralDeclaration getUPDATEEnumLiteralDeclaration_2() {
			return cUPDATEEnumLiteralDeclaration_2;
		}

		// "update"
		public Keyword getUPDATEUpdateKeyword_2_0() {
			return cUPDATEUpdateKeyword_2_0;
		}

		// DELETE="delete"
		public EnumLiteralDeclaration getDELETEEnumLiteralDeclaration_3() {
			return cDELETEEnumLiteralDeclaration_3;
		}

		// "delete"
		public Keyword getDELETEDeleteKeyword_3_0() {
			return cDELETEDeleteKeyword_3_0;
		}
	}

	private ParameterRuleElements pParameterRule;
	private ModifiersRuleElements pModifiersRule;
	private ModifierSpecificationElements pModifierSpecification;
	private ModifierKindElements unknownRuleModifierKind;
	private EffectKindElements unknownRuleEffectKind;
	private EffectRuleElements pEffectRule;

	private final Grammar grammar;

	private UmlCommonGrammarAccess gaUmlCommon;

	@Inject
	public UmlParameterGrammarAccess(GrammarProvider grammarProvider,
			UmlCommonGrammarAccess gaUmlCommon) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaUmlCommon = gaUmlCommon;
	}

	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.papyrus.uml.textedit.parameter.xtext.UmlParameter".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}


	@Override
	public Grammar getGrammar() {
		return grammar;
	}


	public UmlCommonGrammarAccess getUmlCommonGrammarAccess() {
		return gaUmlCommon;
	}


	// ParameterRule:
	//
	// visibility=VisibilityKind direction=Direction name=ID ":" (type=TypeRule | "<Undefined>")
	//
	// multiplicity=MultiplicityRule? modifiers=ModifiersRule? effect=EffectRule;
	public ParameterRuleElements getParameterRuleAccess() {
		return (pParameterRule != null) ? pParameterRule : (pParameterRule = new ParameterRuleElements());
	}

	public ParserRule getParameterRuleRule() {
		return getParameterRuleAccess().getRule();
	}

	// ModifiersRule:
	//
	// "{" values+=ModifierSpecification ("," values+=ModifierSpecification)* "}";
	public ModifiersRuleElements getModifiersRuleAccess() {
		return (pModifiersRule != null) ? pModifiersRule : (pModifiersRule = new ModifiersRuleElements());
	}

	public ParserRule getModifiersRuleRule() {
		return getModifiersRuleAccess().getRule();
	}

	// ModifierSpecification:
	//
	// value=ModifierKind;
	public ModifierSpecificationElements getModifierSpecificationAccess() {
		return (pModifierSpecification != null) ? pModifierSpecification : (pModifierSpecification = new ModifierSpecificationElements());
	}

	public ParserRule getModifierSpecificationRule() {
		return getModifierSpecificationAccess().getRule();
	}

	// enum ModifierKind:
	//
	// EXCEPTION="exception" | STREAM="stream" | ORDERED="ordered" | UNIQUE="unique";
	public ModifierKindElements getModifierKindAccess() {
		return (unknownRuleModifierKind != null) ? unknownRuleModifierKind : (unknownRuleModifierKind = new ModifierKindElements());
	}

	public EnumRule getModifierKindRule() {
		return getModifierKindAccess().getRule();
	}

	// enum EffectKind:
	//
	// CREATE="create" | READ="read" | UPDATE="update" | DELETE="delete";
	public EffectKindElements getEffectKindAccess() {
		return (unknownRuleEffectKind != null) ? unknownRuleEffectKind : (unknownRuleEffectKind = new EffectKindElements());
	}

	public EnumRule getEffectKindRule() {
		return getEffectKindAccess().getRule();
	}

	// EffectRule:
	//
	// "{" "effect: " effectKind=EffectKind "}";
	public EffectRuleElements getEffectRuleAccess() {
		return (pEffectRule != null) ? pEffectRule : (pEffectRule = new EffectRuleElements());
	}

	public ParserRule getEffectRuleRule() {
		return getEffectRuleAccess().getRule();
	}

	// QualifiedName:
	//
	// path=[uml::Namespace] "::" remaining=QualifiedName?;
	public UmlCommonGrammarAccess.QualifiedNameElements getQualifiedNameAccess() {
		return gaUmlCommon.getQualifiedNameAccess();
	}

	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}

	// TypeRule:
	//
	// path=QualifiedName? type=[uml::Type];
	public UmlCommonGrammarAccess.TypeRuleElements getTypeRuleAccess() {
		return gaUmlCommon.getTypeRuleAccess();
	}

	public ParserRule getTypeRuleRule() {
		return getTypeRuleAccess().getRule();
	}

	// enum VisibilityKind:
	//
	// public="+" | private="-" | protected="#" | package="~";
	public UmlCommonGrammarAccess.VisibilityKindElements getVisibilityKindAccess() {
		return gaUmlCommon.getVisibilityKindAccess();
	}

	public EnumRule getVisibilityKindRule() {
		return getVisibilityKindAccess().getRule();
	}

	// MultiplicityRule:
	//
	// "[" bounds+=BoundSpecification (".." bounds+=BoundSpecification)? "]";
	public UmlCommonGrammarAccess.MultiplicityRuleElements getMultiplicityRuleAccess() {
		return gaUmlCommon.getMultiplicityRuleAccess();
	}

	public ParserRule getMultiplicityRuleRule() {
		return getMultiplicityRuleAccess().getRule();
	}

	// BoundSpecification:
	//
	// value=UnlimitedLiteral;
	public UmlCommonGrammarAccess.BoundSpecificationElements getBoundSpecificationAccess() {
		return gaUmlCommon.getBoundSpecificationAccess();
	}

	public ParserRule getBoundSpecificationRule() {
		return getBoundSpecificationAccess().getRule();
	}

	// UnlimitedLiteral returns ecore::EString:
	//
	// INT | "*";
	public UmlCommonGrammarAccess.UnlimitedLiteralElements getUnlimitedLiteralAccess() {
		return gaUmlCommon.getUnlimitedLiteralAccess();
	}

	public ParserRule getUnlimitedLiteralRule() {
		return getUnlimitedLiteralAccess().getRule();
	}

	// enum Direction:
	//
	// IN="in" | OUT="out" | INOUT="inout" | RETURN="return";
	public UmlCommonGrammarAccess.DirectionElements getDirectionAccess() {
		return gaUmlCommon.getDirectionAccess();
	}

	public EnumRule getDirectionRule() {
		return getDirectionAccess().getRule();
	}

	// terminal INTEGER_VALUE:
	//
	// ("0" | "1".."9" ("_"? "0".."9")*) //DECIMAL
	//
	// // BINARY
	//
	// // HEX
	//
	// // OCT
	//
	// | ("0b" | "0B") "0".."1" ("_"? "0".."1")* | ("0x" | "0X") ("0".."9" | "a".."f" | "A".."F") ("_"? ("0".."9" | "a".."f" |
	//
	// "A".."F"))* | "0" "_"? "0".."7" ("_"? "0".."7")*;
	public TerminalRule getINTEGER_VALUERule() {
		return gaUmlCommon.getINTEGER_VALUERule();
	}

	// terminal ID:
	//
	// ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")* | "\'"->"\'";
	public TerminalRule getIDRule() {
		return gaUmlCommon.getIDRule();
	}

	// terminal STRING:
	//
	// "\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"";
	public TerminalRule getSTRINGRule() {
		return gaUmlCommon.getSTRINGRule();
	}

	// terminal ML_COMMENT:
	//
	// "/ *" !"@"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaUmlCommon.getML_COMMENTRule();
	}

	// //terminal DOUBLE_COLON : '::' ;
	//
	// //terminal IDENTIFIER : ID ;
	//
	// //terminal IDENTIFIER : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')* | ('\'' -> '\'') ;
	//
	// //terminal DOCUMENTATION_COMMENT : '/ *' -> '* /' ;
	//
	// //terminal ML_COMMENT : '/�' -> '�/';
	//
	// //terminal SL_COMMENT : '��' !('\n'|'\r')* ('\r'? '\n')?;
	//
	// //terminal WS : (' '|'\t'|'\r'|'\n')+; terminal SL_COMMENT:
	//
	// "//" !("\n" | "\r" | "@")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaUmlCommon.getSL_COMMENTRule();
	}

	// terminal INT returns ecore::EInt:
	//
	// "0".."9"+;
	public TerminalRule getINTRule() {
		return gaUmlCommon.getINTRule();
	}

	// terminal WS:
	//
	// (" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaUmlCommon.getWSRule();
	}

	// terminal ANY_OTHER:
	//
	// .;
	public TerminalRule getANY_OTHERRule() {
		return gaUmlCommon.getANY_OTHERRule();
	}
}
