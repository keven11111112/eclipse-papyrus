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
	superClass=AbstractInternalContentAssistParser;
	backtrack=true;
	
}

@lexer::header {
package org.eclipse.papyrus.migration.rhapsody.parser.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.eclipse.papyrus.migration.rhapsody.parser.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.papyrus.migration.rhapsody.parser.services.RpySyntaxGrammarAccess;

}

@parser::members {
 
 	private RpySyntaxGrammarAccess grammarAccess;
 	
    public void setGrammarAccess(RpySyntaxGrammarAccess grammarAccess) {
    	this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected Grammar getGrammar() {
    	return grammarAccess.getGrammar();
    }
    
    @Override
    protected String getValueForTokenName(String tokenName) {
    	return tokenName;
    }

}




// Entry rule entryRuleRpyFile
entryRuleRpyFile 
:
{ before(grammarAccess.getRpyFileRule()); }
	 ruleRpyFile
{ after(grammarAccess.getRpyFileRule()); } 
	 EOF 
;

// Rule RpyFile
ruleRpyFile
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getRpyFileAccess().getGroup()); }
(rule__RpyFile__Group__0)
{ after(grammarAccess.getRpyFileAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRpyContent
entryRuleRpyContent 
:
{ before(grammarAccess.getRpyContentRule()); }
	 ruleRpyContent
{ after(grammarAccess.getRpyContentRule()); } 
	 EOF 
;

// Rule RpyContent
ruleRpyContent
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getRpyContentAccess().getAlternatives()); }
(rule__RpyContent__Alternatives)
{ after(grammarAccess.getRpyContentAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRpyNode
entryRuleRpyNode 
:
{ before(grammarAccess.getRpyNodeRule()); }
	 ruleRpyNode
{ after(grammarAccess.getRpyNodeRule()); } 
	 EOF 
;

// Rule RpyNode
ruleRpyNode
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getRpyNodeAccess().getGroup()); }
(rule__RpyNode__Group__0)
{ after(grammarAccess.getRpyNodeAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRpyFeature
entryRuleRpyFeature 
:
{ before(grammarAccess.getRpyFeatureRule()); }
	 ruleRpyFeature
{ after(grammarAccess.getRpyFeatureRule()); } 
	 EOF 
;

// Rule RpyFeature
ruleRpyFeature
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getRpyFeatureAccess().getGroup()); }
(rule__RpyFeature__Group__0)
{ after(grammarAccess.getRpyFeatureAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRpyFeatureValue
entryRuleRpyFeatureValue 
:
{ before(grammarAccess.getRpyFeatureValueRule()); }
	 ruleRpyFeatureValue
{ after(grammarAccess.getRpyFeatureValueRule()); } 
	 EOF 
;

// Rule RpyFeatureValue
ruleRpyFeatureValue
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getRpyFeatureValueAccess().getAlternatives()); }
(rule__RpyFeatureValue__Alternatives)
{ after(grammarAccess.getRpyFeatureValueAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRpyNodeList
entryRuleRpyNodeList 
:
{ before(grammarAccess.getRpyNodeListRule()); }
	 ruleRpyNodeList
{ after(grammarAccess.getRpyNodeListRule()); } 
	 EOF 
;

// Rule RpyNodeList
ruleRpyNodeList
    @init {
		int stackSize = keepStackSize();
    }
	:
(
(
{ before(grammarAccess.getRpyNodeListAccess().getValuesAssignment()); }
(rule__RpyNodeList__ValuesAssignment)
{ after(grammarAccess.getRpyNodeListAccess().getValuesAssignment()); }
)
(
{ before(grammarAccess.getRpyNodeListAccess().getValuesAssignment()); }
(rule__RpyNodeList__ValuesAssignment)*
{ after(grammarAccess.getRpyNodeListAccess().getValuesAssignment()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSimpleValueList
entryRuleSimpleValueList 
:
{ before(grammarAccess.getSimpleValueListRule()); }
	 ruleSimpleValueList
{ after(grammarAccess.getSimpleValueListRule()); } 
	 EOF 
;

// Rule SimpleValueList
ruleSimpleValueList
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSimpleValueListAccess().getGroup()); }
(rule__SimpleValueList__Group__0)
{ after(grammarAccess.getSimpleValueListAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRpySimpleValueElement
entryRuleRpySimpleValueElement 
:
{ before(grammarAccess.getRpySimpleValueElementRule()); }
	 ruleRpySimpleValueElement
{ after(grammarAccess.getRpySimpleValueElementRule()); } 
	 EOF 
;

// Rule RpySimpleValueElement
ruleRpySimpleValueElement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getRpySimpleValueElementAccess().getGroup()); }
(rule__RpySimpleValueElement__Group__0)
{ after(grammarAccess.getRpySimpleValueElementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleVALUE_TERMINAL
entryRuleVALUE_TERMINAL 
:
{ before(grammarAccess.getVALUE_TERMINALRule()); }
	 ruleVALUE_TERMINAL
{ after(grammarAccess.getVALUE_TERMINALRule()); } 
	 EOF 
;

// Rule VALUE_TERMINAL
ruleVALUE_TERMINAL
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getVALUE_TERMINALAccess().getAlternatives()); }
(rule__VALUE_TERMINAL__Alternatives)
{ after(grammarAccess.getVALUE_TERMINALAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRpyStringMap
entryRuleRpyStringMap 
:
{ before(grammarAccess.getRpyStringMapRule()); }
	 ruleRpyStringMap
{ after(grammarAccess.getRpyStringMapRule()); } 
	 EOF 
;

// Rule RpyStringMap
ruleRpyStringMap
    @init {
		int stackSize = keepStackSize();
    }
	:
(
(
{ before(grammarAccess.getRpyStringMapAccess().getEntriesAssignment()); }
(rule__RpyStringMap__EntriesAssignment)
{ after(grammarAccess.getRpyStringMapAccess().getEntriesAssignment()); }
)
(
{ before(grammarAccess.getRpyStringMapAccess().getEntriesAssignment()); }
(rule__RpyStringMap__EntriesAssignment)*
{ after(grammarAccess.getRpyStringMapAccess().getEntriesAssignment()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRpyStringMapEntry
entryRuleRpyStringMapEntry 
:
{ before(grammarAccess.getRpyStringMapEntryRule()); }
	 ruleRpyStringMapEntry
{ after(grammarAccess.getRpyStringMapEntryRule()); } 
	 EOF 
;

// Rule RpyStringMapEntry
ruleRpyStringMapEntry
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getRpyStringMapEntryAccess().getGroup()); }
(rule__RpyStringMapEntry__Group__0)
{ after(grammarAccess.getRpyStringMapEntryAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__RpyContent__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyContentAccess().getRpyNodeParserRuleCall_0()); }
	ruleRpyNode
{ after(grammarAccess.getRpyContentAccess().getRpyNodeParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getRpyContentAccess().getRpyFeatureParserRuleCall_1()); }
	ruleRpyFeature
{ after(grammarAccess.getRpyContentAccess().getRpyFeatureParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RpyFeatureValue__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyFeatureValueAccess().getSimpleValueListParserRuleCall_0()); }
	ruleSimpleValueList
{ after(grammarAccess.getRpyFeatureValueAccess().getSimpleValueListParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getRpyFeatureValueAccess().getRpyNodeListParserRuleCall_1()); }
	ruleRpyNodeList
{ after(grammarAccess.getRpyFeatureValueAccess().getRpyNodeListParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getRpyFeatureValueAccess().getRpyStringMapParserRuleCall_2()); }
	ruleRpyStringMap
{ after(grammarAccess.getRpyFeatureValueAccess().getRpyStringMapParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__VALUE_TERMINAL__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVALUE_TERMINALAccess().getSTRINGTerminalRuleCall_0()); }
	RULE_STRING
{ after(grammarAccess.getVALUE_TERMINALAccess().getSTRINGTerminalRuleCall_0()); }
)

    |(
{ before(grammarAccess.getVALUE_TERMINALAccess().getIDTerminalRuleCall_1()); }
	RULE_ID
{ after(grammarAccess.getVALUE_TERMINALAccess().getIDTerminalRuleCall_1()); }
)

    |(
{ before(grammarAccess.getVALUE_TERMINALAccess().getRPY_GUIDTerminalRuleCall_2()); }
	RULE_RPY_GUID
{ after(grammarAccess.getVALUE_TERMINALAccess().getRPY_GUIDTerminalRuleCall_2()); }
)

    |(
{ before(grammarAccess.getVALUE_TERMINALAccess().getINTTerminalRuleCall_3()); }
	RULE_INT
{ after(grammarAccess.getVALUE_TERMINALAccess().getINTTerminalRuleCall_3()); }
)

    |(
{ before(grammarAccess.getVALUE_TERMINALAccess().getRPY_TIMETerminalRuleCall_4()); }
	RULE_RPY_TIME
{ after(grammarAccess.getVALUE_TERMINALAccess().getRPY_TIMETerminalRuleCall_4()); }
)

    |(
{ before(grammarAccess.getVALUE_TERMINALAccess().getRPY_REALTerminalRuleCall_5()); }
	RULE_RPY_REAL
{ after(grammarAccess.getVALUE_TERMINALAccess().getRPY_REALTerminalRuleCall_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__RpyFile__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RpyFile__Group__0__Impl
	rule__RpyFile__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RpyFile__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyFileAccess().getILogixRPYArchiveKeyword_0()); }

	'I-Logix-RPY-Archive' 

{ after(grammarAccess.getRpyFileAccess().getILogixRPYArchiveKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RpyFile__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RpyFile__Group__1__Impl
	rule__RpyFile__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RpyFile__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyFileAccess().getVersionAssignment_1()); }
(rule__RpyFile__VersionAssignment_1)
{ after(grammarAccess.getRpyFileAccess().getVersionAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RpyFile__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RpyFile__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RpyFile__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyFileAccess().getContentsAssignment_2()); }
(rule__RpyFile__ContentsAssignment_2)*
{ after(grammarAccess.getRpyFileAccess().getContentsAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__RpyNode__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RpyNode__Group__0__Impl
	rule__RpyNode__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RpyNode__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyNodeAccess().getLeftCurlyBracketKeyword_0()); }

	'{' 

{ after(grammarAccess.getRpyNodeAccess().getLeftCurlyBracketKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RpyNode__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RpyNode__Group__1__Impl
	rule__RpyNode__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RpyNode__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyNodeAccess().getNameAssignment_1()); }
(rule__RpyNode__NameAssignment_1)
{ after(grammarAccess.getRpyNodeAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RpyNode__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RpyNode__Group__2__Impl
	rule__RpyNode__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RpyNode__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getRpyNodeAccess().getContentsAssignment_2()); }
(rule__RpyNode__ContentsAssignment_2)
{ after(grammarAccess.getRpyNodeAccess().getContentsAssignment_2()); }
)
(
{ before(grammarAccess.getRpyNodeAccess().getContentsAssignment_2()); }
(rule__RpyNode__ContentsAssignment_2)*
{ after(grammarAccess.getRpyNodeAccess().getContentsAssignment_2()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RpyNode__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RpyNode__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RpyNode__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyNodeAccess().getRightCurlyBracketKeyword_3()); }

	'}' 

{ after(grammarAccess.getRpyNodeAccess().getRightCurlyBracketKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__RpyFeature__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RpyFeature__Group__0__Impl
	rule__RpyFeature__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RpyFeature__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyFeatureAccess().getHyphenMinusKeyword_0()); }

	'-' 

{ after(grammarAccess.getRpyFeatureAccess().getHyphenMinusKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RpyFeature__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RpyFeature__Group__1__Impl
	rule__RpyFeature__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RpyFeature__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyFeatureAccess().getNameAssignment_1()); }
(rule__RpyFeature__NameAssignment_1)
{ after(grammarAccess.getRpyFeatureAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RpyFeature__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RpyFeature__Group__2__Impl
	rule__RpyFeature__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RpyFeature__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyFeatureAccess().getEqualsSignKeyword_2()); }

	'=' 

{ after(grammarAccess.getRpyFeatureAccess().getEqualsSignKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RpyFeature__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RpyFeature__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RpyFeature__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyFeatureAccess().getValueAssignment_3()); }
(rule__RpyFeature__ValueAssignment_3)
{ after(grammarAccess.getRpyFeatureAccess().getValueAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__SimpleValueList__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SimpleValueList__Group__0__Impl
	rule__SimpleValueList__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleValueList__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSimpleValueListAccess().getSimpleValueListAction_0()); }
(

)
{ after(grammarAccess.getSimpleValueListAccess().getSimpleValueListAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SimpleValueList__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SimpleValueList__Group__1__Impl
	rule__SimpleValueList__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleValueList__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSimpleValueListAccess().getIsOldIDAssignment_1()); }
(rule__SimpleValueList__IsOldIDAssignment_1)?
{ after(grammarAccess.getSimpleValueListAccess().getIsOldIDAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SimpleValueList__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SimpleValueList__Group__2__Impl
	rule__SimpleValueList__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleValueList__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSimpleValueListAccess().getIsGUIDAssignment_2()); }
(rule__SimpleValueList__IsGUIDAssignment_2)?
{ after(grammarAccess.getSimpleValueListAccess().getIsGUIDAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__SimpleValueList__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__SimpleValueList__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleValueList__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
(
{ before(grammarAccess.getSimpleValueListAccess().getValueElementsAssignment_3()); }
(rule__SimpleValueList__ValueElementsAssignment_3)
{ after(grammarAccess.getSimpleValueListAccess().getValueElementsAssignment_3()); }
)
(
{ before(grammarAccess.getSimpleValueListAccess().getValueElementsAssignment_3()); }
(rule__SimpleValueList__ValueElementsAssignment_3)*
{ after(grammarAccess.getSimpleValueListAccess().getValueElementsAssignment_3()); }
)
)

;
finally {
	restoreStackSize(stackSize);
}










rule__RpySimpleValueElement__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RpySimpleValueElement__Group__0__Impl
	rule__RpySimpleValueElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RpySimpleValueElement__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpySimpleValueElementAccess().getRpySimpleValueElementAction_0()); }
(

)
{ after(grammarAccess.getRpySimpleValueElementAccess().getRpySimpleValueElementAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RpySimpleValueElement__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RpySimpleValueElement__Group__1__Impl
	rule__RpySimpleValueElement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RpySimpleValueElement__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpySimpleValueElementAccess().getValuesAssignment_1()); }
(rule__RpySimpleValueElement__ValuesAssignment_1)*
{ after(grammarAccess.getRpySimpleValueElementAccess().getValuesAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RpySimpleValueElement__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RpySimpleValueElement__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RpySimpleValueElement__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpySimpleValueElementAccess().getSemicolonKeyword_2()); }

	';' 

{ after(grammarAccess.getRpySimpleValueElementAccess().getSemicolonKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__RpyStringMapEntry__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RpyStringMapEntry__Group__0__Impl
	rule__RpyStringMapEntry__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RpyStringMapEntry__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyStringMapEntryAccess().getKeyAssignment_0()); }
(rule__RpyStringMapEntry__KeyAssignment_0)
{ after(grammarAccess.getRpyStringMapEntryAccess().getKeyAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__RpyStringMapEntry__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__RpyStringMapEntry__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RpyStringMapEntry__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyStringMapEntryAccess().getValueAssignment_1()); }
(rule__RpyStringMapEntry__ValueAssignment_1)
{ after(grammarAccess.getRpyStringMapEntryAccess().getValueAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}







rule__RpyFile__VersionAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyFileAccess().getVersionRPY_VERSIONTerminalRuleCall_1_0()); }
	RULE_RPY_VERSION{ after(grammarAccess.getRpyFileAccess().getVersionRPY_VERSIONTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RpyFile__ContentsAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyFileAccess().getContentsRpyContentParserRuleCall_2_0()); }
	ruleRpyContent{ after(grammarAccess.getRpyFileAccess().getContentsRpyContentParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RpyNode__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyNodeAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getRpyNodeAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RpyNode__ContentsAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyNodeAccess().getContentsRpyContentParserRuleCall_2_0()); }
	ruleRpyContent{ after(grammarAccess.getRpyNodeAccess().getContentsRpyContentParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RpyFeature__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyFeatureAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getRpyFeatureAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RpyFeature__ValueAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyFeatureAccess().getValueRpyFeatureValueParserRuleCall_3_0()); }
	ruleRpyFeatureValue{ after(grammarAccess.getRpyFeatureAccess().getValueRpyFeatureValueParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RpyNodeList__ValuesAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyNodeListAccess().getValuesRpyNodeParserRuleCall_0()); }
	ruleRpyNode{ after(grammarAccess.getRpyNodeListAccess().getValuesRpyNodeParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleValueList__IsOldIDAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSimpleValueListAccess().getIsOldIDOLDIDKeyword_1_0()); }
(
{ before(grammarAccess.getSimpleValueListAccess().getIsOldIDOLDIDKeyword_1_0()); }

	'OLDID' 

{ after(grammarAccess.getSimpleValueListAccess().getIsOldIDOLDIDKeyword_1_0()); }
)

{ after(grammarAccess.getSimpleValueListAccess().getIsOldIDOLDIDKeyword_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleValueList__IsGUIDAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSimpleValueListAccess().getIsGUIDGUIDKeyword_2_0()); }
(
{ before(grammarAccess.getSimpleValueListAccess().getIsGUIDGUIDKeyword_2_0()); }

	'GUID' 

{ after(grammarAccess.getSimpleValueListAccess().getIsGUIDGUIDKeyword_2_0()); }
)

{ after(grammarAccess.getSimpleValueListAccess().getIsGUIDGUIDKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleValueList__ValueElementsAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSimpleValueListAccess().getValueElementsRpySimpleValueElementParserRuleCall_3_0()); }
	ruleRpySimpleValueElement{ after(grammarAccess.getSimpleValueListAccess().getValueElementsRpySimpleValueElementParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RpySimpleValueElement__ValuesAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpySimpleValueElementAccess().getValuesVALUE_TERMINALParserRuleCall_1_0()); }
	ruleVALUE_TERMINAL{ after(grammarAccess.getRpySimpleValueElementAccess().getValuesVALUE_TERMINALParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RpyStringMap__EntriesAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyStringMapAccess().getEntriesRpyStringMapEntryParserRuleCall_0()); }
	ruleRpyStringMapEntry{ after(grammarAccess.getRpyStringMapAccess().getEntriesRpyStringMapEntryParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RpyStringMapEntry__KeyAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyStringMapEntryAccess().getKeySTRINGTerminalRuleCall_0_0()); }
	RULE_STRING{ after(grammarAccess.getRpyStringMapEntryAccess().getKeySTRINGTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__RpyStringMapEntry__ValueAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRpyStringMapEntryAccess().getValueSTRINGTerminalRuleCall_1_0()); }
	RULE_STRING{ after(grammarAccess.getRpyStringMapEntryAccess().getValueSTRINGTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


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


