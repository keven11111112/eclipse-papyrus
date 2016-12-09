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
package org.eclipse.papyrus.migration.rhapsody.parser.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class RpySyntaxGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class RpyFileElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpyFile");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cILogixRPYArchiveKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cVersionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cVersionRPY_VERSIONTerminalRuleCall_1_0 = (RuleCall)cVersionAssignment_1.eContents().get(0);
		private final Assignment cContentsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cContentsRpyContentParserRuleCall_2_0 = (RuleCall)cContentsAssignment_2.eContents().get(0);
		
		//RpyFile:
		//	'I-Logix-RPY-Archive' version=RPY_VERSION contents+=RpyContent*;
		@Override public ParserRule getRule() { return rule; }

		//'I-Logix-RPY-Archive' version=RPY_VERSION contents+=RpyContent*
		public Group getGroup() { return cGroup; }

		//'I-Logix-RPY-Archive'
		public Keyword getILogixRPYArchiveKeyword_0() { return cILogixRPYArchiveKeyword_0; }

		//version=RPY_VERSION
		public Assignment getVersionAssignment_1() { return cVersionAssignment_1; }

		//RPY_VERSION
		public RuleCall getVersionRPY_VERSIONTerminalRuleCall_1_0() { return cVersionRPY_VERSIONTerminalRuleCall_1_0; }

		//contents+=RpyContent*
		public Assignment getContentsAssignment_2() { return cContentsAssignment_2; }

		//RpyContent
		public RuleCall getContentsRpyContentParserRuleCall_2_0() { return cContentsRpyContentParserRuleCall_2_0; }
	}

	public class RpyContentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpyContent");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cRpyNodeParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cRpyFeatureParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//RpyContent:
		//	RpyNode | RpyFeature;
		@Override public ParserRule getRule() { return rule; }

		//RpyNode | RpyFeature
		public Alternatives getAlternatives() { return cAlternatives; }

		//RpyNode
		public RuleCall getRpyNodeParserRuleCall_0() { return cRpyNodeParserRuleCall_0; }

		//RpyFeature
		public RuleCall getRpyFeatureParserRuleCall_1() { return cRpyFeatureParserRuleCall_1; }
	}

	public class RpyNodeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpyNode");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Assignment cContentsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cContentsRpyContentParserRuleCall_2_0 = (RuleCall)cContentsAssignment_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//RpyNode:
		//	'{' name=ID contents+=RpyContent+ '}';
		@Override public ParserRule getRule() { return rule; }

		//'{' name=ID contents+=RpyContent+ '}'
		public Group getGroup() { return cGroup; }

		//'{'
		public Keyword getLeftCurlyBracketKeyword_0() { return cLeftCurlyBracketKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//contents+=RpyContent+
		public Assignment getContentsAssignment_2() { return cContentsAssignment_2; }

		//RpyContent
		public RuleCall getContentsRpyContentParserRuleCall_2_0() { return cContentsRpyContentParserRuleCall_2_0; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}

	public class RpyFeatureElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpyFeature");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cValueRpyFeatureValueParserRuleCall_3_0 = (RuleCall)cValueAssignment_3.eContents().get(0);
		
		//RpyFeature:
		//	'-' name=ID '=' value=RpyFeatureValue;
		@Override public ParserRule getRule() { return rule; }

		//'-' name=ID '=' value=RpyFeatureValue
		public Group getGroup() { return cGroup; }

		//'-'
		public Keyword getHyphenMinusKeyword_0() { return cHyphenMinusKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//'='
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }

		//value=RpyFeatureValue
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }

		//RpyFeatureValue
		public RuleCall getValueRpyFeatureValueParserRuleCall_3_0() { return cValueRpyFeatureValueParserRuleCall_3_0; }
	}

	public class RpyFeatureValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpyFeatureValue");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSimpleValueListParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cRpyNodeListParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cRpyStringMapParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//RpyFeatureValue:
		//	SimpleValueList | RpyNodeList | RpyStringMap;
		@Override public ParserRule getRule() { return rule; }

		//SimpleValueList | RpyNodeList | RpyStringMap
		public Alternatives getAlternatives() { return cAlternatives; }

		//SimpleValueList
		public RuleCall getSimpleValueListParserRuleCall_0() { return cSimpleValueListParserRuleCall_0; }

		//RpyNodeList
		public RuleCall getRpyNodeListParserRuleCall_1() { return cRpyNodeListParserRuleCall_1; }

		//RpyStringMap
		public RuleCall getRpyStringMapParserRuleCall_2() { return cRpyStringMapParserRuleCall_2; }
	}

	public class RpyNodeListElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpyNodeList");
		private final Assignment cValuesAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValuesRpyNodeParserRuleCall_0 = (RuleCall)cValuesAssignment.eContents().get(0);
		
		//RpyNodeList:
		//	values+=RpyNode+;
		@Override public ParserRule getRule() { return rule; }

		//values+=RpyNode+
		public Assignment getValuesAssignment() { return cValuesAssignment; }

		//RpyNode
		public RuleCall getValuesRpyNodeParserRuleCall_0() { return cValuesRpyNodeParserRuleCall_0; }
	}

	public class SimpleValueListElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.SimpleValueList");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cSimpleValueListAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cIsOldIDAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cIsOldIDOLDIDKeyword_1_0 = (Keyword)cIsOldIDAssignment_1.eContents().get(0);
		private final Assignment cIsGUIDAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Keyword cIsGUIDGUIDKeyword_2_0 = (Keyword)cIsGUIDAssignment_2.eContents().get(0);
		private final Assignment cValueElementsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cValueElementsRpySimpleValueElementParserRuleCall_3_0 = (RuleCall)cValueElementsAssignment_3.eContents().get(0);
		
		//SimpleValueList:
		//	{SimpleValueList} isOldID?='OLDID'? isGUID?='GUID'? valueElements+=RpySimpleValueElement+;
		@Override public ParserRule getRule() { return rule; }

		//{SimpleValueList} isOldID?='OLDID'? isGUID?='GUID'? valueElements+=RpySimpleValueElement+
		public Group getGroup() { return cGroup; }

		//{SimpleValueList}
		public Action getSimpleValueListAction_0() { return cSimpleValueListAction_0; }

		//isOldID?='OLDID'?
		public Assignment getIsOldIDAssignment_1() { return cIsOldIDAssignment_1; }

		//'OLDID'
		public Keyword getIsOldIDOLDIDKeyword_1_0() { return cIsOldIDOLDIDKeyword_1_0; }

		//isGUID?='GUID'?
		public Assignment getIsGUIDAssignment_2() { return cIsGUIDAssignment_2; }

		//'GUID'
		public Keyword getIsGUIDGUIDKeyword_2_0() { return cIsGUIDGUIDKeyword_2_0; }

		//valueElements+=RpySimpleValueElement+
		public Assignment getValueElementsAssignment_3() { return cValueElementsAssignment_3; }

		//RpySimpleValueElement
		public RuleCall getValueElementsRpySimpleValueElementParserRuleCall_3_0() { return cValueElementsRpySimpleValueElementParserRuleCall_3_0; }
	}

	public class RpySimpleValueElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpySimpleValueElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRpySimpleValueElementAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValuesAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValuesVALUE_TERMINALParserRuleCall_1_0 = (RuleCall)cValuesAssignment_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//RpySimpleValueElement:
		//	{RpySimpleValueElement} values+=VALUE_TERMINAL* ';';
		@Override public ParserRule getRule() { return rule; }

		//{RpySimpleValueElement} values+=VALUE_TERMINAL* ';'
		public Group getGroup() { return cGroup; }

		//{RpySimpleValueElement}
		public Action getRpySimpleValueElementAction_0() { return cRpySimpleValueElementAction_0; }

		//values+=VALUE_TERMINAL*
		public Assignment getValuesAssignment_1() { return cValuesAssignment_1; }

		//VALUE_TERMINAL
		public RuleCall getValuesVALUE_TERMINALParserRuleCall_1_0() { return cValuesVALUE_TERMINALParserRuleCall_1_0; }

		//';'
		public Keyword getSemicolonKeyword_2() { return cSemicolonKeyword_2; }
	}

	public class VALUE_TERMINALElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.VALUE_TERMINAL");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSTRINGTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cRPY_GUIDTerminalRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cINTTerminalRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cRPY_TIMETerminalRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cRPY_REALTerminalRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		
		//VALUE_TERMINAL:
		//	STRING | ID | RPY_GUID | INT | RPY_TIME | RPY_REAL;
		@Override public ParserRule getRule() { return rule; }

		//STRING | ID | RPY_GUID | INT | RPY_TIME | RPY_REAL
		public Alternatives getAlternatives() { return cAlternatives; }

		//STRING
		public RuleCall getSTRINGTerminalRuleCall_0() { return cSTRINGTerminalRuleCall_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }

		//RPY_GUID
		public RuleCall getRPY_GUIDTerminalRuleCall_2() { return cRPY_GUIDTerminalRuleCall_2; }

		//INT
		public RuleCall getINTTerminalRuleCall_3() { return cINTTerminalRuleCall_3; }

		//RPY_TIME
		public RuleCall getRPY_TIMETerminalRuleCall_4() { return cRPY_TIMETerminalRuleCall_4; }

		//RPY_REAL
		public RuleCall getRPY_REALTerminalRuleCall_5() { return cRPY_REALTerminalRuleCall_5; }
	}

	public class RpyStringMapElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpyStringMap");
		private final Assignment cEntriesAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cEntriesRpyStringMapEntryParserRuleCall_0 = (RuleCall)cEntriesAssignment.eContents().get(0);
		
		//RpyStringMap:
		//	entries+=RpyStringMapEntry+;
		@Override public ParserRule getRule() { return rule; }

		//entries+=RpyStringMapEntry+
		public Assignment getEntriesAssignment() { return cEntriesAssignment; }

		//RpyStringMapEntry
		public RuleCall getEntriesRpyStringMapEntryParserRuleCall_0() { return cEntriesRpyStringMapEntryParserRuleCall_0; }
	}

	public class RpyStringMapEntryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpyStringMapEntry");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cKeySTRINGTerminalRuleCall_0_0 = (RuleCall)cKeyAssignment_0.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//RpyStringMapEntry:
		//	key=STRING value=STRING;
		@Override public ParserRule getRule() { return rule; }

		//key=STRING value=STRING
		public Group getGroup() { return cGroup; }

		//key=STRING
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }

		//STRING
		public RuleCall getKeySTRINGTerminalRuleCall_0_0() { return cKeySTRINGTerminalRuleCall_0_0; }

		//value=STRING
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_1_0() { return cValueSTRINGTerminalRuleCall_1_0; }
	}
	
	
	private final RpyFileElements pRpyFile;
	private final RpyContentElements pRpyContent;
	private final RpyNodeElements pRpyNode;
	private final RpyFeatureElements pRpyFeature;
	private final RpyFeatureValueElements pRpyFeatureValue;
	private final RpyNodeListElements pRpyNodeList;
	private final SimpleValueListElements pSimpleValueList;
	private final RpySimpleValueElementElements pRpySimpleValueElement;
	private final VALUE_TERMINALElements pVALUE_TERMINAL;
	private final RpyStringMapElements pRpyStringMap;
	private final RpyStringMapEntryElements pRpyStringMapEntry;
	private final TerminalRule tRPY_GUID;
	private final TerminalRule tRPY_TIME;
	private final TerminalRule tRPY_REAL;
	private final TerminalRule tINT;
	private final TerminalRule tRPY_VERSION;
	
	private final Grammar grammar;

	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public RpySyntaxGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pRpyFile = new RpyFileElements();
		this.pRpyContent = new RpyContentElements();
		this.pRpyNode = new RpyNodeElements();
		this.pRpyFeature = new RpyFeatureElements();
		this.pRpyFeatureValue = new RpyFeatureValueElements();
		this.pRpyNodeList = new RpyNodeListElements();
		this.pSimpleValueList = new SimpleValueListElements();
		this.pRpySimpleValueElement = new RpySimpleValueElementElements();
		this.pVALUE_TERMINAL = new VALUE_TERMINALElements();
		this.pRpyStringMap = new RpyStringMapElements();
		this.pRpyStringMapEntry = new RpyStringMapEntryElements();
		this.tRPY_GUID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RPY_GUID");
		this.tRPY_TIME = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RPY_TIME");
		this.tRPY_REAL = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RPY_REAL");
		this.tINT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.INT");
		this.tRPY_VERSION = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RPY_VERSION");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax".equals(grammar.getName())) {
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
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//RpyFile:
	//	'I-Logix-RPY-Archive' version=RPY_VERSION contents+=RpyContent*;
	public RpyFileElements getRpyFileAccess() {
		return pRpyFile;
	}
	
	public ParserRule getRpyFileRule() {
		return getRpyFileAccess().getRule();
	}

	//RpyContent:
	//	RpyNode | RpyFeature;
	public RpyContentElements getRpyContentAccess() {
		return pRpyContent;
	}
	
	public ParserRule getRpyContentRule() {
		return getRpyContentAccess().getRule();
	}

	//RpyNode:
	//	'{' name=ID contents+=RpyContent+ '}';
	public RpyNodeElements getRpyNodeAccess() {
		return pRpyNode;
	}
	
	public ParserRule getRpyNodeRule() {
		return getRpyNodeAccess().getRule();
	}

	//RpyFeature:
	//	'-' name=ID '=' value=RpyFeatureValue;
	public RpyFeatureElements getRpyFeatureAccess() {
		return pRpyFeature;
	}
	
	public ParserRule getRpyFeatureRule() {
		return getRpyFeatureAccess().getRule();
	}

	//RpyFeatureValue:
	//	SimpleValueList | RpyNodeList | RpyStringMap;
	public RpyFeatureValueElements getRpyFeatureValueAccess() {
		return pRpyFeatureValue;
	}
	
	public ParserRule getRpyFeatureValueRule() {
		return getRpyFeatureValueAccess().getRule();
	}

	//RpyNodeList:
	//	values+=RpyNode+;
	public RpyNodeListElements getRpyNodeListAccess() {
		return pRpyNodeList;
	}
	
	public ParserRule getRpyNodeListRule() {
		return getRpyNodeListAccess().getRule();
	}

	//SimpleValueList:
	//	{SimpleValueList} isOldID?='OLDID'? isGUID?='GUID'? valueElements+=RpySimpleValueElement+;
	public SimpleValueListElements getSimpleValueListAccess() {
		return pSimpleValueList;
	}
	
	public ParserRule getSimpleValueListRule() {
		return getSimpleValueListAccess().getRule();
	}

	//RpySimpleValueElement:
	//	{RpySimpleValueElement} values+=VALUE_TERMINAL* ';';
	public RpySimpleValueElementElements getRpySimpleValueElementAccess() {
		return pRpySimpleValueElement;
	}
	
	public ParserRule getRpySimpleValueElementRule() {
		return getRpySimpleValueElementAccess().getRule();
	}

	//VALUE_TERMINAL:
	//	STRING | ID | RPY_GUID | INT | RPY_TIME | RPY_REAL;
	public VALUE_TERMINALElements getVALUE_TERMINALAccess() {
		return pVALUE_TERMINAL;
	}
	
	public ParserRule getVALUE_TERMINALRule() {
		return getVALUE_TERMINALAccess().getRule();
	}

	//RpyStringMap:
	//	entries+=RpyStringMapEntry+;
	public RpyStringMapElements getRpyStringMapAccess() {
		return pRpyStringMap;
	}
	
	public ParserRule getRpyStringMapRule() {
		return getRpyStringMapAccess().getRule();
	}

	//RpyStringMapEntry:
	//	key=STRING value=STRING;
	public RpyStringMapEntryElements getRpyStringMapEntryAccess() {
		return pRpyStringMapEntry;
	}
	
	public ParserRule getRpyStringMapEntryRule() {
		return getRpyStringMapEntryAccess().getRule();
	}

	//terminal RPY_GUID:
	//	('a'..'z' | 'A'..'Z' | '0'..'9')+ ('-' ('a'..'z' | 'A'..'Z' | '0'..'9')+)+;
	public TerminalRule getRPY_GUIDRule() {
		return tRPY_GUID;
	} 

	//terminal RPY_TIME:
	//	'0'..'9'+ '.' '0'..'9'+ '.' '0'..'9'+ '::' '0'..'9'+ ':' '0'..'9'+ ':' '0'..'9';
	public TerminalRule getRPY_TIMERule() {
		return tRPY_TIME;
	} 

	//terminal RPY_REAL:
	//	'-'? '0'..'9'+ '.' '0'..'9'+;
	public TerminalRule getRPY_REALRule() {
		return tRPY_REAL;
	} 

	//terminal INT returns ecore::EInt:
	//	'-'? '0'..'9'+;
	public TerminalRule getINTRule() {
		return tINT;
	} 

	//terminal RPY_VERSION:
	//	'version' !('\n' | '\r')* ('\n' | '\r');
	public TerminalRule getRPY_VERSIONRule() {
		return tRPY_VERSION;
	} 

	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"' | "'" ('\\' . | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	'/ *'->'* /';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
