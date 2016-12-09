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
grammar InternalRpySyntax;

options {
	superClass=AbstractInternalAntlrParser;
	backtrack=true;
	
}

@lexer::header {
package org.eclipse.papyrus.migration.rhapsody.parser.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.papyrus.migration.rhapsody.parser.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.papyrus.migration.rhapsody.parser.services.RpySyntaxGrammarAccess;

}

@parser::members {

/*
  This grammar contains a lot of empty actions to work around a bug in ANTLR.
  Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
*/
 
 	private RpySyntaxGrammarAccess grammarAccess;
 	
    public InternalRpySyntaxParser(TokenStream input, RpySyntaxGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "RpyFile";	
   	}
   	
   	@Override
   	protected RpySyntaxGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleRpyFile
entryRuleRpyFile returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRpyFileRule()); }
	 iv_ruleRpyFile=ruleRpyFile 
	 { $current=$iv_ruleRpyFile.current; } 
	 EOF 
;

// Rule RpyFile
ruleRpyFile returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='I-Logix-RPY-Archive' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getRpyFileAccess().getILogixRPYArchiveKeyword_0());
    }
(
(
		lv_version_1_0=RULE_RPY_VERSION
		{
			newLeafNode(lv_version_1_0, grammarAccess.getRpyFileAccess().getVersionRPY_VERSIONTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getRpyFileRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"version",
        		lv_version_1_0, 
        		"org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RPY_VERSION");
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getRpyFileAccess().getContentsRpyContentParserRuleCall_2_0()); 
	    }
		lv_contents_2_0=ruleRpyContent		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRpyFileRule());
	        }
       		add(
       			$current, 
       			"contents",
        		lv_contents_2_0, 
        		"org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpyContent");
	        afterParserOrEnumRuleCall();
	    }

)
)*)
;





// Entry rule entryRuleRpyContent
entryRuleRpyContent returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRpyContentRule()); }
	 iv_ruleRpyContent=ruleRpyContent 
	 { $current=$iv_ruleRpyContent.current; } 
	 EOF 
;

// Rule RpyContent
ruleRpyContent returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getRpyContentAccess().getRpyNodeParserRuleCall_0()); 
    }
    this_RpyNode_0=ruleRpyNode
    { 
        $current = $this_RpyNode_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getRpyContentAccess().getRpyFeatureParserRuleCall_1()); 
    }
    this_RpyFeature_1=ruleRpyFeature
    { 
        $current = $this_RpyFeature_1.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleRpyNode
entryRuleRpyNode returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRpyNodeRule()); }
	 iv_ruleRpyNode=ruleRpyNode 
	 { $current=$iv_ruleRpyNode.current; } 
	 EOF 
;

// Rule RpyNode
ruleRpyNode returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='{' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getRpyNodeAccess().getLeftCurlyBracketKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getRpyNodeAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getRpyNodeRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"org.eclipse.xtext.common.Terminals.ID");
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getRpyNodeAccess().getContentsRpyContentParserRuleCall_2_0()); 
	    }
		lv_contents_2_0=ruleRpyContent		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRpyNodeRule());
	        }
       		add(
       			$current, 
       			"contents",
        		lv_contents_2_0, 
        		"org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpyContent");
	        afterParserOrEnumRuleCall();
	    }

)
)+	otherlv_3='}' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getRpyNodeAccess().getRightCurlyBracketKeyword_3());
    }
)
;





// Entry rule entryRuleRpyFeature
entryRuleRpyFeature returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRpyFeatureRule()); }
	 iv_ruleRpyFeature=ruleRpyFeature 
	 { $current=$iv_ruleRpyFeature.current; } 
	 EOF 
;

// Rule RpyFeature
ruleRpyFeature returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='-' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getRpyFeatureAccess().getHyphenMinusKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getRpyFeatureAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getRpyFeatureRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"org.eclipse.xtext.common.Terminals.ID");
	    }

)
)	otherlv_2='=' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getRpyFeatureAccess().getEqualsSignKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getRpyFeatureAccess().getValueRpyFeatureValueParserRuleCall_3_0()); 
	    }
		lv_value_3_0=ruleRpyFeatureValue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRpyFeatureRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_3_0, 
        		"org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpyFeatureValue");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleRpyFeatureValue
entryRuleRpyFeatureValue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRpyFeatureValueRule()); }
	 iv_ruleRpyFeatureValue=ruleRpyFeatureValue 
	 { $current=$iv_ruleRpyFeatureValue.current; } 
	 EOF 
;

// Rule RpyFeatureValue
ruleRpyFeatureValue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getRpyFeatureValueAccess().getSimpleValueListParserRuleCall_0()); 
    }
    this_SimpleValueList_0=ruleSimpleValueList
    { 
        $current = $this_SimpleValueList_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getRpyFeatureValueAccess().getRpyNodeListParserRuleCall_1()); 
    }
    this_RpyNodeList_1=ruleRpyNodeList
    { 
        $current = $this_RpyNodeList_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getRpyFeatureValueAccess().getRpyStringMapParserRuleCall_2()); 
    }
    this_RpyStringMap_2=ruleRpyStringMap
    { 
        $current = $this_RpyStringMap_2.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleRpyNodeList
entryRuleRpyNodeList returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRpyNodeListRule()); }
	 iv_ruleRpyNodeList=ruleRpyNodeList 
	 { $current=$iv_ruleRpyNodeList.current; } 
	 EOF 
;

// Rule RpyNodeList
ruleRpyNodeList returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getRpyNodeListAccess().getValuesRpyNodeParserRuleCall_0()); 
	    }
		lv_values_0_0=ruleRpyNode		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRpyNodeListRule());
	        }
       		add(
       			$current, 
       			"values",
        		lv_values_0_0, 
        		"org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpyNode");
	        afterParserOrEnumRuleCall();
	    }

)
)+
;





// Entry rule entryRuleSimpleValueList
entryRuleSimpleValueList returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSimpleValueListRule()); }
	 iv_ruleSimpleValueList=ruleSimpleValueList 
	 { $current=$iv_ruleSimpleValueList.current; } 
	 EOF 
;

// Rule SimpleValueList
ruleSimpleValueList returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getSimpleValueListAccess().getSimpleValueListAction_0(),
            $current);
    }
)(
(
		lv_isOldID_1_0=	'OLDID' 
    {
        newLeafNode(lv_isOldID_1_0, grammarAccess.getSimpleValueListAccess().getIsOldIDOLDIDKeyword_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSimpleValueListRule());
	        }
       		setWithLastConsumed($current, "isOldID", true, "OLDID");
	    }

)
)?(
(
		lv_isGUID_2_0=	'GUID' 
    {
        newLeafNode(lv_isGUID_2_0, grammarAccess.getSimpleValueListAccess().getIsGUIDGUIDKeyword_2_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSimpleValueListRule());
	        }
       		setWithLastConsumed($current, "isGUID", true, "GUID");
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getSimpleValueListAccess().getValueElementsRpySimpleValueElementParserRuleCall_3_0()); 
	    }
		lv_valueElements_3_0=ruleRpySimpleValueElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSimpleValueListRule());
	        }
       		add(
       			$current, 
       			"valueElements",
        		lv_valueElements_3_0, 
        		"org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpySimpleValueElement");
	        afterParserOrEnumRuleCall();
	    }

)
)+)
;





// Entry rule entryRuleRpySimpleValueElement
entryRuleRpySimpleValueElement returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRpySimpleValueElementRule()); }
	 iv_ruleRpySimpleValueElement=ruleRpySimpleValueElement 
	 { $current=$iv_ruleRpySimpleValueElement.current; } 
	 EOF 
;

// Rule RpySimpleValueElement
ruleRpySimpleValueElement returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	{ 
	  /* */ 
	}
    {
        $current = forceCreateModelElement(
            grammarAccess.getRpySimpleValueElementAccess().getRpySimpleValueElementAction_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getRpySimpleValueElementAccess().getValuesVALUE_TERMINALParserRuleCall_1_0()); 
	    }
		lv_values_1_0=ruleVALUE_TERMINAL		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRpySimpleValueElementRule());
	        }
       		add(
       			$current, 
       			"values",
        		lv_values_1_0, 
        		"org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.VALUE_TERMINAL");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_2=';' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getRpySimpleValueElementAccess().getSemicolonKeyword_2());
    }
)
;





// Entry rule entryRuleVALUE_TERMINAL
entryRuleVALUE_TERMINAL returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getVALUE_TERMINALRule()); } 
	 iv_ruleVALUE_TERMINAL=ruleVALUE_TERMINAL 
	 { $current=$iv_ruleVALUE_TERMINAL.current.getText(); }  
	 EOF 
;

// Rule VALUE_TERMINAL
ruleVALUE_TERMINAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_STRING_0=RULE_STRING    {
		$current.merge(this_STRING_0);
    }

    { 
    newLeafNode(this_STRING_0, grammarAccess.getVALUE_TERMINALAccess().getSTRINGTerminalRuleCall_0()); 
    }

    |    this_ID_1=RULE_ID    {
		$current.merge(this_ID_1);
    }

    { 
    newLeafNode(this_ID_1, grammarAccess.getVALUE_TERMINALAccess().getIDTerminalRuleCall_1()); 
    }

    |    this_RPY_GUID_2=RULE_RPY_GUID    {
		$current.merge(this_RPY_GUID_2);
    }

    { 
    newLeafNode(this_RPY_GUID_2, grammarAccess.getVALUE_TERMINALAccess().getRPY_GUIDTerminalRuleCall_2()); 
    }

    |    this_INT_3=RULE_INT    {
		$current.merge(this_INT_3);
    }

    { 
    newLeafNode(this_INT_3, grammarAccess.getVALUE_TERMINALAccess().getINTTerminalRuleCall_3()); 
    }

    |    this_RPY_TIME_4=RULE_RPY_TIME    {
		$current.merge(this_RPY_TIME_4);
    }

    { 
    newLeafNode(this_RPY_TIME_4, grammarAccess.getVALUE_TERMINALAccess().getRPY_TIMETerminalRuleCall_4()); 
    }

    |    this_RPY_REAL_5=RULE_RPY_REAL    {
		$current.merge(this_RPY_REAL_5);
    }

    { 
    newLeafNode(this_RPY_REAL_5, grammarAccess.getVALUE_TERMINALAccess().getRPY_REALTerminalRuleCall_5()); 
    }
)
    ;





// Entry rule entryRuleRpyStringMap
entryRuleRpyStringMap returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRpyStringMapRule()); }
	 iv_ruleRpyStringMap=ruleRpyStringMap 
	 { $current=$iv_ruleRpyStringMap.current; } 
	 EOF 
;

// Rule RpyStringMap
ruleRpyStringMap returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getRpyStringMapAccess().getEntriesRpyStringMapEntryParserRuleCall_0()); 
	    }
		lv_entries_0_0=ruleRpyStringMapEntry		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRpyStringMapRule());
	        }
       		add(
       			$current, 
       			"entries",
        		lv_entries_0_0, 
        		"org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpyStringMapEntry");
	        afterParserOrEnumRuleCall();
	    }

)
)+
;





// Entry rule entryRuleRpyStringMapEntry
entryRuleRpyStringMapEntry returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRpyStringMapEntryRule()); }
	 iv_ruleRpyStringMapEntry=ruleRpyStringMapEntry 
	 { $current=$iv_ruleRpyStringMapEntry.current; } 
	 EOF 
;

// Rule RpyStringMapEntry
ruleRpyStringMapEntry returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_key_0_0=RULE_STRING
		{
			newLeafNode(lv_key_0_0, grammarAccess.getRpyStringMapEntryAccess().getKeySTRINGTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getRpyStringMapEntryRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"key",
        		lv_key_0_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
)(
(
		lv_value_1_0=RULE_STRING
		{
			newLeafNode(lv_value_1_0, grammarAccess.getRpyStringMapEntryAccess().getValueSTRINGTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getRpyStringMapEntryRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"value",
        		lv_value_1_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
))
;





RULE_RPY_GUID : ('a'..'z'|'A'..'Z'|'0'..'9')+ ('-' ('a'..'z'|'A'..'Z'|'0'..'9')+)+;

RULE_RPY_TIME : ('0'..'9')+ '.' ('0'..'9')+ '.' ('0'..'9')+ '::' ('0'..'9')+ ':' ('0'..'9')+ ':' '0'..'9';

RULE_RPY_REAL : '-'? ('0'..'9')+ '.' ('0'..'9')+;

RULE_INT : '-'? ('0'..'9')+;

RULE_RPY_VERSION : 'version' ~(('\n'|'\r'))* ('\n'|'\r');

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


