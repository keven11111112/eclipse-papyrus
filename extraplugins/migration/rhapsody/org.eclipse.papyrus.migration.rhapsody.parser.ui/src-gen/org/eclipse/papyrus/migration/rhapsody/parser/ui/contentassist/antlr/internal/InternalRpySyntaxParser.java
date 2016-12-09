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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
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
@SuppressWarnings("all")
public class InternalRpySyntaxParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_RPY_GUID", "RULE_INT", "RULE_RPY_TIME", "RULE_RPY_REAL", "RULE_RPY_VERSION", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'I-Logix-RPY-Archive'", "'{'", "'}'", "'-'", "'='", "';'", "'OLDID'", "'GUID'"
    };
    public static final int RULE_RPY_GUID=6;
    public static final int RULE_RPY_TIME=8;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=13;
    public static final int RULE_RPY_VERSION=10;
    public static final int RULE_ANY_OTHER=14;
    public static final int RULE_INT=7;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=11;
    public static final int RULE_RPY_REAL=9;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalRpySyntaxParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRpySyntaxParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRpySyntaxParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRpySyntax.g"; }


     
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




    // $ANTLR start "entryRuleRpyFile"
    // InternalRpySyntax.g:70:1: entryRuleRpyFile : ruleRpyFile EOF ;
    public final void entryRuleRpyFile() throws RecognitionException {
        try {
            // InternalRpySyntax.g:71:1: ( ruleRpyFile EOF )
            // InternalRpySyntax.g:72:1: ruleRpyFile EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyFileRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRpyFile();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyFileRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRpyFile"


    // $ANTLR start "ruleRpyFile"
    // InternalRpySyntax.g:79:1: ruleRpyFile : ( ( rule__RpyFile__Group__0 ) ) ;
    public final void ruleRpyFile() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:83:2: ( ( ( rule__RpyFile__Group__0 ) ) )
            // InternalRpySyntax.g:84:1: ( ( rule__RpyFile__Group__0 ) )
            {
            // InternalRpySyntax.g:84:1: ( ( rule__RpyFile__Group__0 ) )
            // InternalRpySyntax.g:85:1: ( rule__RpyFile__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyFileAccess().getGroup()); 
            }
            // InternalRpySyntax.g:86:1: ( rule__RpyFile__Group__0 )
            // InternalRpySyntax.g:86:2: rule__RpyFile__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RpyFile__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyFileAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRpyFile"


    // $ANTLR start "entryRuleRpyContent"
    // InternalRpySyntax.g:98:1: entryRuleRpyContent : ruleRpyContent EOF ;
    public final void entryRuleRpyContent() throws RecognitionException {
        try {
            // InternalRpySyntax.g:99:1: ( ruleRpyContent EOF )
            // InternalRpySyntax.g:100:1: ruleRpyContent EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyContentRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRpyContent();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyContentRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRpyContent"


    // $ANTLR start "ruleRpyContent"
    // InternalRpySyntax.g:107:1: ruleRpyContent : ( ( rule__RpyContent__Alternatives ) ) ;
    public final void ruleRpyContent() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:111:2: ( ( ( rule__RpyContent__Alternatives ) ) )
            // InternalRpySyntax.g:112:1: ( ( rule__RpyContent__Alternatives ) )
            {
            // InternalRpySyntax.g:112:1: ( ( rule__RpyContent__Alternatives ) )
            // InternalRpySyntax.g:113:1: ( rule__RpyContent__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyContentAccess().getAlternatives()); 
            }
            // InternalRpySyntax.g:114:1: ( rule__RpyContent__Alternatives )
            // InternalRpySyntax.g:114:2: rule__RpyContent__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__RpyContent__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyContentAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRpyContent"


    // $ANTLR start "entryRuleRpyNode"
    // InternalRpySyntax.g:126:1: entryRuleRpyNode : ruleRpyNode EOF ;
    public final void entryRuleRpyNode() throws RecognitionException {
        try {
            // InternalRpySyntax.g:127:1: ( ruleRpyNode EOF )
            // InternalRpySyntax.g:128:1: ruleRpyNode EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyNodeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRpyNode();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyNodeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRpyNode"


    // $ANTLR start "ruleRpyNode"
    // InternalRpySyntax.g:135:1: ruleRpyNode : ( ( rule__RpyNode__Group__0 ) ) ;
    public final void ruleRpyNode() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:139:2: ( ( ( rule__RpyNode__Group__0 ) ) )
            // InternalRpySyntax.g:140:1: ( ( rule__RpyNode__Group__0 ) )
            {
            // InternalRpySyntax.g:140:1: ( ( rule__RpyNode__Group__0 ) )
            // InternalRpySyntax.g:141:1: ( rule__RpyNode__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyNodeAccess().getGroup()); 
            }
            // InternalRpySyntax.g:142:1: ( rule__RpyNode__Group__0 )
            // InternalRpySyntax.g:142:2: rule__RpyNode__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RpyNode__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyNodeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRpyNode"


    // $ANTLR start "entryRuleRpyFeature"
    // InternalRpySyntax.g:154:1: entryRuleRpyFeature : ruleRpyFeature EOF ;
    public final void entryRuleRpyFeature() throws RecognitionException {
        try {
            // InternalRpySyntax.g:155:1: ( ruleRpyFeature EOF )
            // InternalRpySyntax.g:156:1: ruleRpyFeature EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyFeatureRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRpyFeature();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyFeatureRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRpyFeature"


    // $ANTLR start "ruleRpyFeature"
    // InternalRpySyntax.g:163:1: ruleRpyFeature : ( ( rule__RpyFeature__Group__0 ) ) ;
    public final void ruleRpyFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:167:2: ( ( ( rule__RpyFeature__Group__0 ) ) )
            // InternalRpySyntax.g:168:1: ( ( rule__RpyFeature__Group__0 ) )
            {
            // InternalRpySyntax.g:168:1: ( ( rule__RpyFeature__Group__0 ) )
            // InternalRpySyntax.g:169:1: ( rule__RpyFeature__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyFeatureAccess().getGroup()); 
            }
            // InternalRpySyntax.g:170:1: ( rule__RpyFeature__Group__0 )
            // InternalRpySyntax.g:170:2: rule__RpyFeature__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RpyFeature__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyFeatureAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRpyFeature"


    // $ANTLR start "entryRuleRpyFeatureValue"
    // InternalRpySyntax.g:182:1: entryRuleRpyFeatureValue : ruleRpyFeatureValue EOF ;
    public final void entryRuleRpyFeatureValue() throws RecognitionException {
        try {
            // InternalRpySyntax.g:183:1: ( ruleRpyFeatureValue EOF )
            // InternalRpySyntax.g:184:1: ruleRpyFeatureValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyFeatureValueRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRpyFeatureValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyFeatureValueRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRpyFeatureValue"


    // $ANTLR start "ruleRpyFeatureValue"
    // InternalRpySyntax.g:191:1: ruleRpyFeatureValue : ( ( rule__RpyFeatureValue__Alternatives ) ) ;
    public final void ruleRpyFeatureValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:195:2: ( ( ( rule__RpyFeatureValue__Alternatives ) ) )
            // InternalRpySyntax.g:196:1: ( ( rule__RpyFeatureValue__Alternatives ) )
            {
            // InternalRpySyntax.g:196:1: ( ( rule__RpyFeatureValue__Alternatives ) )
            // InternalRpySyntax.g:197:1: ( rule__RpyFeatureValue__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyFeatureValueAccess().getAlternatives()); 
            }
            // InternalRpySyntax.g:198:1: ( rule__RpyFeatureValue__Alternatives )
            // InternalRpySyntax.g:198:2: rule__RpyFeatureValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__RpyFeatureValue__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyFeatureValueAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRpyFeatureValue"


    // $ANTLR start "entryRuleRpyNodeList"
    // InternalRpySyntax.g:210:1: entryRuleRpyNodeList : ruleRpyNodeList EOF ;
    public final void entryRuleRpyNodeList() throws RecognitionException {
        try {
            // InternalRpySyntax.g:211:1: ( ruleRpyNodeList EOF )
            // InternalRpySyntax.g:212:1: ruleRpyNodeList EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyNodeListRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRpyNodeList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyNodeListRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRpyNodeList"


    // $ANTLR start "ruleRpyNodeList"
    // InternalRpySyntax.g:219:1: ruleRpyNodeList : ( ( ( rule__RpyNodeList__ValuesAssignment ) ) ( ( rule__RpyNodeList__ValuesAssignment )* ) ) ;
    public final void ruleRpyNodeList() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:223:2: ( ( ( ( rule__RpyNodeList__ValuesAssignment ) ) ( ( rule__RpyNodeList__ValuesAssignment )* ) ) )
            // InternalRpySyntax.g:224:1: ( ( ( rule__RpyNodeList__ValuesAssignment ) ) ( ( rule__RpyNodeList__ValuesAssignment )* ) )
            {
            // InternalRpySyntax.g:224:1: ( ( ( rule__RpyNodeList__ValuesAssignment ) ) ( ( rule__RpyNodeList__ValuesAssignment )* ) )
            // InternalRpySyntax.g:225:1: ( ( rule__RpyNodeList__ValuesAssignment ) ) ( ( rule__RpyNodeList__ValuesAssignment )* )
            {
            // InternalRpySyntax.g:225:1: ( ( rule__RpyNodeList__ValuesAssignment ) )
            // InternalRpySyntax.g:226:1: ( rule__RpyNodeList__ValuesAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyNodeListAccess().getValuesAssignment()); 
            }
            // InternalRpySyntax.g:227:1: ( rule__RpyNodeList__ValuesAssignment )
            // InternalRpySyntax.g:227:2: rule__RpyNodeList__ValuesAssignment
            {
            pushFollow(FOLLOW_3);
            rule__RpyNodeList__ValuesAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyNodeListAccess().getValuesAssignment()); 
            }

            }

            // InternalRpySyntax.g:230:1: ( ( rule__RpyNodeList__ValuesAssignment )* )
            // InternalRpySyntax.g:231:1: ( rule__RpyNodeList__ValuesAssignment )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyNodeListAccess().getValuesAssignment()); 
            }
            // InternalRpySyntax.g:232:1: ( rule__RpyNodeList__ValuesAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16) ) {
                    int LA1_2 = input.LA(2);

                    if ( (synpred1_InternalRpySyntax()) ) {
                        alt1=1;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // InternalRpySyntax.g:232:2: rule__RpyNodeList__ValuesAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__RpyNodeList__ValuesAssignment();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyNodeListAccess().getValuesAssignment()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRpyNodeList"


    // $ANTLR start "entryRuleSimpleValueList"
    // InternalRpySyntax.g:245:1: entryRuleSimpleValueList : ruleSimpleValueList EOF ;
    public final void entryRuleSimpleValueList() throws RecognitionException {
        try {
            // InternalRpySyntax.g:246:1: ( ruleSimpleValueList EOF )
            // InternalRpySyntax.g:247:1: ruleSimpleValueList EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleValueListRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleSimpleValueList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleValueListRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSimpleValueList"


    // $ANTLR start "ruleSimpleValueList"
    // InternalRpySyntax.g:254:1: ruleSimpleValueList : ( ( rule__SimpleValueList__Group__0 ) ) ;
    public final void ruleSimpleValueList() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:258:2: ( ( ( rule__SimpleValueList__Group__0 ) ) )
            // InternalRpySyntax.g:259:1: ( ( rule__SimpleValueList__Group__0 ) )
            {
            // InternalRpySyntax.g:259:1: ( ( rule__SimpleValueList__Group__0 ) )
            // InternalRpySyntax.g:260:1: ( rule__SimpleValueList__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleValueListAccess().getGroup()); 
            }
            // InternalRpySyntax.g:261:1: ( rule__SimpleValueList__Group__0 )
            // InternalRpySyntax.g:261:2: rule__SimpleValueList__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SimpleValueList__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleValueListAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSimpleValueList"


    // $ANTLR start "entryRuleRpySimpleValueElement"
    // InternalRpySyntax.g:273:1: entryRuleRpySimpleValueElement : ruleRpySimpleValueElement EOF ;
    public final void entryRuleRpySimpleValueElement() throws RecognitionException {
        try {
            // InternalRpySyntax.g:274:1: ( ruleRpySimpleValueElement EOF )
            // InternalRpySyntax.g:275:1: ruleRpySimpleValueElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpySimpleValueElementRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRpySimpleValueElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpySimpleValueElementRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRpySimpleValueElement"


    // $ANTLR start "ruleRpySimpleValueElement"
    // InternalRpySyntax.g:282:1: ruleRpySimpleValueElement : ( ( rule__RpySimpleValueElement__Group__0 ) ) ;
    public final void ruleRpySimpleValueElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:286:2: ( ( ( rule__RpySimpleValueElement__Group__0 ) ) )
            // InternalRpySyntax.g:287:1: ( ( rule__RpySimpleValueElement__Group__0 ) )
            {
            // InternalRpySyntax.g:287:1: ( ( rule__RpySimpleValueElement__Group__0 ) )
            // InternalRpySyntax.g:288:1: ( rule__RpySimpleValueElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpySimpleValueElementAccess().getGroup()); 
            }
            // InternalRpySyntax.g:289:1: ( rule__RpySimpleValueElement__Group__0 )
            // InternalRpySyntax.g:289:2: rule__RpySimpleValueElement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RpySimpleValueElement__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpySimpleValueElementAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRpySimpleValueElement"


    // $ANTLR start "entryRuleVALUE_TERMINAL"
    // InternalRpySyntax.g:301:1: entryRuleVALUE_TERMINAL : ruleVALUE_TERMINAL EOF ;
    public final void entryRuleVALUE_TERMINAL() throws RecognitionException {
        try {
            // InternalRpySyntax.g:302:1: ( ruleVALUE_TERMINAL EOF )
            // InternalRpySyntax.g:303:1: ruleVALUE_TERMINAL EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVALUE_TERMINALRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleVALUE_TERMINAL();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVALUE_TERMINALRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVALUE_TERMINAL"


    // $ANTLR start "ruleVALUE_TERMINAL"
    // InternalRpySyntax.g:310:1: ruleVALUE_TERMINAL : ( ( rule__VALUE_TERMINAL__Alternatives ) ) ;
    public final void ruleVALUE_TERMINAL() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:314:2: ( ( ( rule__VALUE_TERMINAL__Alternatives ) ) )
            // InternalRpySyntax.g:315:1: ( ( rule__VALUE_TERMINAL__Alternatives ) )
            {
            // InternalRpySyntax.g:315:1: ( ( rule__VALUE_TERMINAL__Alternatives ) )
            // InternalRpySyntax.g:316:1: ( rule__VALUE_TERMINAL__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVALUE_TERMINALAccess().getAlternatives()); 
            }
            // InternalRpySyntax.g:317:1: ( rule__VALUE_TERMINAL__Alternatives )
            // InternalRpySyntax.g:317:2: rule__VALUE_TERMINAL__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__VALUE_TERMINAL__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVALUE_TERMINALAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVALUE_TERMINAL"


    // $ANTLR start "entryRuleRpyStringMap"
    // InternalRpySyntax.g:329:1: entryRuleRpyStringMap : ruleRpyStringMap EOF ;
    public final void entryRuleRpyStringMap() throws RecognitionException {
        try {
            // InternalRpySyntax.g:330:1: ( ruleRpyStringMap EOF )
            // InternalRpySyntax.g:331:1: ruleRpyStringMap EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyStringMapRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRpyStringMap();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyStringMapRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRpyStringMap"


    // $ANTLR start "ruleRpyStringMap"
    // InternalRpySyntax.g:338:1: ruleRpyStringMap : ( ( ( rule__RpyStringMap__EntriesAssignment ) ) ( ( rule__RpyStringMap__EntriesAssignment )* ) ) ;
    public final void ruleRpyStringMap() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:342:2: ( ( ( ( rule__RpyStringMap__EntriesAssignment ) ) ( ( rule__RpyStringMap__EntriesAssignment )* ) ) )
            // InternalRpySyntax.g:343:1: ( ( ( rule__RpyStringMap__EntriesAssignment ) ) ( ( rule__RpyStringMap__EntriesAssignment )* ) )
            {
            // InternalRpySyntax.g:343:1: ( ( ( rule__RpyStringMap__EntriesAssignment ) ) ( ( rule__RpyStringMap__EntriesAssignment )* ) )
            // InternalRpySyntax.g:344:1: ( ( rule__RpyStringMap__EntriesAssignment ) ) ( ( rule__RpyStringMap__EntriesAssignment )* )
            {
            // InternalRpySyntax.g:344:1: ( ( rule__RpyStringMap__EntriesAssignment ) )
            // InternalRpySyntax.g:345:1: ( rule__RpyStringMap__EntriesAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyStringMapAccess().getEntriesAssignment()); 
            }
            // InternalRpySyntax.g:346:1: ( rule__RpyStringMap__EntriesAssignment )
            // InternalRpySyntax.g:346:2: rule__RpyStringMap__EntriesAssignment
            {
            pushFollow(FOLLOW_4);
            rule__RpyStringMap__EntriesAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyStringMapAccess().getEntriesAssignment()); 
            }

            }

            // InternalRpySyntax.g:349:1: ( ( rule__RpyStringMap__EntriesAssignment )* )
            // InternalRpySyntax.g:350:1: ( rule__RpyStringMap__EntriesAssignment )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyStringMapAccess().getEntriesAssignment()); 
            }
            // InternalRpySyntax.g:351:1: ( rule__RpyStringMap__EntriesAssignment )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_STRING) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalRpySyntax.g:351:2: rule__RpyStringMap__EntriesAssignment
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__RpyStringMap__EntriesAssignment();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyStringMapAccess().getEntriesAssignment()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRpyStringMap"


    // $ANTLR start "entryRuleRpyStringMapEntry"
    // InternalRpySyntax.g:364:1: entryRuleRpyStringMapEntry : ruleRpyStringMapEntry EOF ;
    public final void entryRuleRpyStringMapEntry() throws RecognitionException {
        try {
            // InternalRpySyntax.g:365:1: ( ruleRpyStringMapEntry EOF )
            // InternalRpySyntax.g:366:1: ruleRpyStringMapEntry EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyStringMapEntryRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRpyStringMapEntry();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyStringMapEntryRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRpyStringMapEntry"


    // $ANTLR start "ruleRpyStringMapEntry"
    // InternalRpySyntax.g:373:1: ruleRpyStringMapEntry : ( ( rule__RpyStringMapEntry__Group__0 ) ) ;
    public final void ruleRpyStringMapEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:377:2: ( ( ( rule__RpyStringMapEntry__Group__0 ) ) )
            // InternalRpySyntax.g:378:1: ( ( rule__RpyStringMapEntry__Group__0 ) )
            {
            // InternalRpySyntax.g:378:1: ( ( rule__RpyStringMapEntry__Group__0 ) )
            // InternalRpySyntax.g:379:1: ( rule__RpyStringMapEntry__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyStringMapEntryAccess().getGroup()); 
            }
            // InternalRpySyntax.g:380:1: ( rule__RpyStringMapEntry__Group__0 )
            // InternalRpySyntax.g:380:2: rule__RpyStringMapEntry__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RpyStringMapEntry__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyStringMapEntryAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRpyStringMapEntry"


    // $ANTLR start "rule__RpyContent__Alternatives"
    // InternalRpySyntax.g:392:1: rule__RpyContent__Alternatives : ( ( ruleRpyNode ) | ( ruleRpyFeature ) );
    public final void rule__RpyContent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:396:1: ( ( ruleRpyNode ) | ( ruleRpyFeature ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            else if ( (LA3_0==18) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalRpySyntax.g:397:1: ( ruleRpyNode )
                    {
                    // InternalRpySyntax.g:397:1: ( ruleRpyNode )
                    // InternalRpySyntax.g:398:1: ruleRpyNode
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRpyContentAccess().getRpyNodeParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleRpyNode();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRpyContentAccess().getRpyNodeParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRpySyntax.g:403:6: ( ruleRpyFeature )
                    {
                    // InternalRpySyntax.g:403:6: ( ruleRpyFeature )
                    // InternalRpySyntax.g:404:1: ruleRpyFeature
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRpyContentAccess().getRpyFeatureParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleRpyFeature();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRpyContentAccess().getRpyFeatureParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyContent__Alternatives"


    // $ANTLR start "rule__RpyFeatureValue__Alternatives"
    // InternalRpySyntax.g:414:1: rule__RpyFeatureValue__Alternatives : ( ( ruleSimpleValueList ) | ( ruleRpyNodeList ) | ( ruleRpyStringMap ) );
    public final void rule__RpyFeatureValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:418:1: ( ( ruleSimpleValueList ) | ( ruleRpyNodeList ) | ( ruleRpyStringMap ) )
            int alt4=3;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalRpySyntax.g:419:1: ( ruleSimpleValueList )
                    {
                    // InternalRpySyntax.g:419:1: ( ruleSimpleValueList )
                    // InternalRpySyntax.g:420:1: ruleSimpleValueList
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRpyFeatureValueAccess().getSimpleValueListParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleSimpleValueList();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRpyFeatureValueAccess().getSimpleValueListParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRpySyntax.g:425:6: ( ruleRpyNodeList )
                    {
                    // InternalRpySyntax.g:425:6: ( ruleRpyNodeList )
                    // InternalRpySyntax.g:426:1: ruleRpyNodeList
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRpyFeatureValueAccess().getRpyNodeListParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleRpyNodeList();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRpyFeatureValueAccess().getRpyNodeListParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRpySyntax.g:431:6: ( ruleRpyStringMap )
                    {
                    // InternalRpySyntax.g:431:6: ( ruleRpyStringMap )
                    // InternalRpySyntax.g:432:1: ruleRpyStringMap
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRpyFeatureValueAccess().getRpyStringMapParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleRpyStringMap();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRpyFeatureValueAccess().getRpyStringMapParserRuleCall_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyFeatureValue__Alternatives"


    // $ANTLR start "rule__VALUE_TERMINAL__Alternatives"
    // InternalRpySyntax.g:442:1: rule__VALUE_TERMINAL__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) | ( RULE_RPY_GUID ) | ( RULE_INT ) | ( RULE_RPY_TIME ) | ( RULE_RPY_REAL ) );
    public final void rule__VALUE_TERMINAL__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:446:1: ( ( RULE_STRING ) | ( RULE_ID ) | ( RULE_RPY_GUID ) | ( RULE_INT ) | ( RULE_RPY_TIME ) | ( RULE_RPY_REAL ) )
            int alt5=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt5=1;
                }
                break;
            case RULE_ID:
                {
                alt5=2;
                }
                break;
            case RULE_RPY_GUID:
                {
                alt5=3;
                }
                break;
            case RULE_INT:
                {
                alt5=4;
                }
                break;
            case RULE_RPY_TIME:
                {
                alt5=5;
                }
                break;
            case RULE_RPY_REAL:
                {
                alt5=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalRpySyntax.g:447:1: ( RULE_STRING )
                    {
                    // InternalRpySyntax.g:447:1: ( RULE_STRING )
                    // InternalRpySyntax.g:448:1: RULE_STRING
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVALUE_TERMINALAccess().getSTRINGTerminalRuleCall_0()); 
                    }
                    match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVALUE_TERMINALAccess().getSTRINGTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRpySyntax.g:453:6: ( RULE_ID )
                    {
                    // InternalRpySyntax.g:453:6: ( RULE_ID )
                    // InternalRpySyntax.g:454:1: RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVALUE_TERMINALAccess().getIDTerminalRuleCall_1()); 
                    }
                    match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVALUE_TERMINALAccess().getIDTerminalRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRpySyntax.g:459:6: ( RULE_RPY_GUID )
                    {
                    // InternalRpySyntax.g:459:6: ( RULE_RPY_GUID )
                    // InternalRpySyntax.g:460:1: RULE_RPY_GUID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVALUE_TERMINALAccess().getRPY_GUIDTerminalRuleCall_2()); 
                    }
                    match(input,RULE_RPY_GUID,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVALUE_TERMINALAccess().getRPY_GUIDTerminalRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalRpySyntax.g:465:6: ( RULE_INT )
                    {
                    // InternalRpySyntax.g:465:6: ( RULE_INT )
                    // InternalRpySyntax.g:466:1: RULE_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVALUE_TERMINALAccess().getINTTerminalRuleCall_3()); 
                    }
                    match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVALUE_TERMINALAccess().getINTTerminalRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalRpySyntax.g:471:6: ( RULE_RPY_TIME )
                    {
                    // InternalRpySyntax.g:471:6: ( RULE_RPY_TIME )
                    // InternalRpySyntax.g:472:1: RULE_RPY_TIME
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVALUE_TERMINALAccess().getRPY_TIMETerminalRuleCall_4()); 
                    }
                    match(input,RULE_RPY_TIME,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVALUE_TERMINALAccess().getRPY_TIMETerminalRuleCall_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalRpySyntax.g:477:6: ( RULE_RPY_REAL )
                    {
                    // InternalRpySyntax.g:477:6: ( RULE_RPY_REAL )
                    // InternalRpySyntax.g:478:1: RULE_RPY_REAL
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVALUE_TERMINALAccess().getRPY_REALTerminalRuleCall_5()); 
                    }
                    match(input,RULE_RPY_REAL,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVALUE_TERMINALAccess().getRPY_REALTerminalRuleCall_5()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VALUE_TERMINAL__Alternatives"


    // $ANTLR start "rule__RpyFile__Group__0"
    // InternalRpySyntax.g:490:1: rule__RpyFile__Group__0 : rule__RpyFile__Group__0__Impl rule__RpyFile__Group__1 ;
    public final void rule__RpyFile__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:494:1: ( rule__RpyFile__Group__0__Impl rule__RpyFile__Group__1 )
            // InternalRpySyntax.g:495:2: rule__RpyFile__Group__0__Impl rule__RpyFile__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__RpyFile__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RpyFile__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyFile__Group__0"


    // $ANTLR start "rule__RpyFile__Group__0__Impl"
    // InternalRpySyntax.g:502:1: rule__RpyFile__Group__0__Impl : ( 'I-Logix-RPY-Archive' ) ;
    public final void rule__RpyFile__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:506:1: ( ( 'I-Logix-RPY-Archive' ) )
            // InternalRpySyntax.g:507:1: ( 'I-Logix-RPY-Archive' )
            {
            // InternalRpySyntax.g:507:1: ( 'I-Logix-RPY-Archive' )
            // InternalRpySyntax.g:508:1: 'I-Logix-RPY-Archive'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyFileAccess().getILogixRPYArchiveKeyword_0()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyFileAccess().getILogixRPYArchiveKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyFile__Group__0__Impl"


    // $ANTLR start "rule__RpyFile__Group__1"
    // InternalRpySyntax.g:521:1: rule__RpyFile__Group__1 : rule__RpyFile__Group__1__Impl rule__RpyFile__Group__2 ;
    public final void rule__RpyFile__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:525:1: ( rule__RpyFile__Group__1__Impl rule__RpyFile__Group__2 )
            // InternalRpySyntax.g:526:2: rule__RpyFile__Group__1__Impl rule__RpyFile__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__RpyFile__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RpyFile__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyFile__Group__1"


    // $ANTLR start "rule__RpyFile__Group__1__Impl"
    // InternalRpySyntax.g:533:1: rule__RpyFile__Group__1__Impl : ( ( rule__RpyFile__VersionAssignment_1 ) ) ;
    public final void rule__RpyFile__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:537:1: ( ( ( rule__RpyFile__VersionAssignment_1 ) ) )
            // InternalRpySyntax.g:538:1: ( ( rule__RpyFile__VersionAssignment_1 ) )
            {
            // InternalRpySyntax.g:538:1: ( ( rule__RpyFile__VersionAssignment_1 ) )
            // InternalRpySyntax.g:539:1: ( rule__RpyFile__VersionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyFileAccess().getVersionAssignment_1()); 
            }
            // InternalRpySyntax.g:540:1: ( rule__RpyFile__VersionAssignment_1 )
            // InternalRpySyntax.g:540:2: rule__RpyFile__VersionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__RpyFile__VersionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyFileAccess().getVersionAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyFile__Group__1__Impl"


    // $ANTLR start "rule__RpyFile__Group__2"
    // InternalRpySyntax.g:550:1: rule__RpyFile__Group__2 : rule__RpyFile__Group__2__Impl ;
    public final void rule__RpyFile__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:554:1: ( rule__RpyFile__Group__2__Impl )
            // InternalRpySyntax.g:555:2: rule__RpyFile__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RpyFile__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyFile__Group__2"


    // $ANTLR start "rule__RpyFile__Group__2__Impl"
    // InternalRpySyntax.g:561:1: rule__RpyFile__Group__2__Impl : ( ( rule__RpyFile__ContentsAssignment_2 )* ) ;
    public final void rule__RpyFile__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:565:1: ( ( ( rule__RpyFile__ContentsAssignment_2 )* ) )
            // InternalRpySyntax.g:566:1: ( ( rule__RpyFile__ContentsAssignment_2 )* )
            {
            // InternalRpySyntax.g:566:1: ( ( rule__RpyFile__ContentsAssignment_2 )* )
            // InternalRpySyntax.g:567:1: ( rule__RpyFile__ContentsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyFileAccess().getContentsAssignment_2()); 
            }
            // InternalRpySyntax.g:568:1: ( rule__RpyFile__ContentsAssignment_2 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==16||LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalRpySyntax.g:568:2: rule__RpyFile__ContentsAssignment_2
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__RpyFile__ContentsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyFileAccess().getContentsAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyFile__Group__2__Impl"


    // $ANTLR start "rule__RpyNode__Group__0"
    // InternalRpySyntax.g:584:1: rule__RpyNode__Group__0 : rule__RpyNode__Group__0__Impl rule__RpyNode__Group__1 ;
    public final void rule__RpyNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:588:1: ( rule__RpyNode__Group__0__Impl rule__RpyNode__Group__1 )
            // InternalRpySyntax.g:589:2: rule__RpyNode__Group__0__Impl rule__RpyNode__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__RpyNode__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RpyNode__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyNode__Group__0"


    // $ANTLR start "rule__RpyNode__Group__0__Impl"
    // InternalRpySyntax.g:596:1: rule__RpyNode__Group__0__Impl : ( '{' ) ;
    public final void rule__RpyNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:600:1: ( ( '{' ) )
            // InternalRpySyntax.g:601:1: ( '{' )
            {
            // InternalRpySyntax.g:601:1: ( '{' )
            // InternalRpySyntax.g:602:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyNodeAccess().getLeftCurlyBracketKeyword_0()); 
            }
            match(input,16,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyNodeAccess().getLeftCurlyBracketKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyNode__Group__0__Impl"


    // $ANTLR start "rule__RpyNode__Group__1"
    // InternalRpySyntax.g:615:1: rule__RpyNode__Group__1 : rule__RpyNode__Group__1__Impl rule__RpyNode__Group__2 ;
    public final void rule__RpyNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:619:1: ( rule__RpyNode__Group__1__Impl rule__RpyNode__Group__2 )
            // InternalRpySyntax.g:620:2: rule__RpyNode__Group__1__Impl rule__RpyNode__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__RpyNode__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RpyNode__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyNode__Group__1"


    // $ANTLR start "rule__RpyNode__Group__1__Impl"
    // InternalRpySyntax.g:627:1: rule__RpyNode__Group__1__Impl : ( ( rule__RpyNode__NameAssignment_1 ) ) ;
    public final void rule__RpyNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:631:1: ( ( ( rule__RpyNode__NameAssignment_1 ) ) )
            // InternalRpySyntax.g:632:1: ( ( rule__RpyNode__NameAssignment_1 ) )
            {
            // InternalRpySyntax.g:632:1: ( ( rule__RpyNode__NameAssignment_1 ) )
            // InternalRpySyntax.g:633:1: ( rule__RpyNode__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyNodeAccess().getNameAssignment_1()); 
            }
            // InternalRpySyntax.g:634:1: ( rule__RpyNode__NameAssignment_1 )
            // InternalRpySyntax.g:634:2: rule__RpyNode__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__RpyNode__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyNodeAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyNode__Group__1__Impl"


    // $ANTLR start "rule__RpyNode__Group__2"
    // InternalRpySyntax.g:644:1: rule__RpyNode__Group__2 : rule__RpyNode__Group__2__Impl rule__RpyNode__Group__3 ;
    public final void rule__RpyNode__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:648:1: ( rule__RpyNode__Group__2__Impl rule__RpyNode__Group__3 )
            // InternalRpySyntax.g:649:2: rule__RpyNode__Group__2__Impl rule__RpyNode__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__RpyNode__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RpyNode__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyNode__Group__2"


    // $ANTLR start "rule__RpyNode__Group__2__Impl"
    // InternalRpySyntax.g:656:1: rule__RpyNode__Group__2__Impl : ( ( ( rule__RpyNode__ContentsAssignment_2 ) ) ( ( rule__RpyNode__ContentsAssignment_2 )* ) ) ;
    public final void rule__RpyNode__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:660:1: ( ( ( ( rule__RpyNode__ContentsAssignment_2 ) ) ( ( rule__RpyNode__ContentsAssignment_2 )* ) ) )
            // InternalRpySyntax.g:661:1: ( ( ( rule__RpyNode__ContentsAssignment_2 ) ) ( ( rule__RpyNode__ContentsAssignment_2 )* ) )
            {
            // InternalRpySyntax.g:661:1: ( ( ( rule__RpyNode__ContentsAssignment_2 ) ) ( ( rule__RpyNode__ContentsAssignment_2 )* ) )
            // InternalRpySyntax.g:662:1: ( ( rule__RpyNode__ContentsAssignment_2 ) ) ( ( rule__RpyNode__ContentsAssignment_2 )* )
            {
            // InternalRpySyntax.g:662:1: ( ( rule__RpyNode__ContentsAssignment_2 ) )
            // InternalRpySyntax.g:663:1: ( rule__RpyNode__ContentsAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyNodeAccess().getContentsAssignment_2()); 
            }
            // InternalRpySyntax.g:664:1: ( rule__RpyNode__ContentsAssignment_2 )
            // InternalRpySyntax.g:664:2: rule__RpyNode__ContentsAssignment_2
            {
            pushFollow(FOLLOW_7);
            rule__RpyNode__ContentsAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyNodeAccess().getContentsAssignment_2()); 
            }

            }

            // InternalRpySyntax.g:667:1: ( ( rule__RpyNode__ContentsAssignment_2 )* )
            // InternalRpySyntax.g:668:1: ( rule__RpyNode__ContentsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyNodeAccess().getContentsAssignment_2()); 
            }
            // InternalRpySyntax.g:669:1: ( rule__RpyNode__ContentsAssignment_2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==16||LA7_0==18) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalRpySyntax.g:669:2: rule__RpyNode__ContentsAssignment_2
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__RpyNode__ContentsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyNodeAccess().getContentsAssignment_2()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyNode__Group__2__Impl"


    // $ANTLR start "rule__RpyNode__Group__3"
    // InternalRpySyntax.g:680:1: rule__RpyNode__Group__3 : rule__RpyNode__Group__3__Impl ;
    public final void rule__RpyNode__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:684:1: ( rule__RpyNode__Group__3__Impl )
            // InternalRpySyntax.g:685:2: rule__RpyNode__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RpyNode__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyNode__Group__3"


    // $ANTLR start "rule__RpyNode__Group__3__Impl"
    // InternalRpySyntax.g:691:1: rule__RpyNode__Group__3__Impl : ( '}' ) ;
    public final void rule__RpyNode__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:695:1: ( ( '}' ) )
            // InternalRpySyntax.g:696:1: ( '}' )
            {
            // InternalRpySyntax.g:696:1: ( '}' )
            // InternalRpySyntax.g:697:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyNodeAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyNodeAccess().getRightCurlyBracketKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyNode__Group__3__Impl"


    // $ANTLR start "rule__RpyFeature__Group__0"
    // InternalRpySyntax.g:718:1: rule__RpyFeature__Group__0 : rule__RpyFeature__Group__0__Impl rule__RpyFeature__Group__1 ;
    public final void rule__RpyFeature__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:722:1: ( rule__RpyFeature__Group__0__Impl rule__RpyFeature__Group__1 )
            // InternalRpySyntax.g:723:2: rule__RpyFeature__Group__0__Impl rule__RpyFeature__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__RpyFeature__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RpyFeature__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyFeature__Group__0"


    // $ANTLR start "rule__RpyFeature__Group__0__Impl"
    // InternalRpySyntax.g:730:1: rule__RpyFeature__Group__0__Impl : ( '-' ) ;
    public final void rule__RpyFeature__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:734:1: ( ( '-' ) )
            // InternalRpySyntax.g:735:1: ( '-' )
            {
            // InternalRpySyntax.g:735:1: ( '-' )
            // InternalRpySyntax.g:736:1: '-'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyFeatureAccess().getHyphenMinusKeyword_0()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyFeatureAccess().getHyphenMinusKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyFeature__Group__0__Impl"


    // $ANTLR start "rule__RpyFeature__Group__1"
    // InternalRpySyntax.g:749:1: rule__RpyFeature__Group__1 : rule__RpyFeature__Group__1__Impl rule__RpyFeature__Group__2 ;
    public final void rule__RpyFeature__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:753:1: ( rule__RpyFeature__Group__1__Impl rule__RpyFeature__Group__2 )
            // InternalRpySyntax.g:754:2: rule__RpyFeature__Group__1__Impl rule__RpyFeature__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__RpyFeature__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RpyFeature__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyFeature__Group__1"


    // $ANTLR start "rule__RpyFeature__Group__1__Impl"
    // InternalRpySyntax.g:761:1: rule__RpyFeature__Group__1__Impl : ( ( rule__RpyFeature__NameAssignment_1 ) ) ;
    public final void rule__RpyFeature__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:765:1: ( ( ( rule__RpyFeature__NameAssignment_1 ) ) )
            // InternalRpySyntax.g:766:1: ( ( rule__RpyFeature__NameAssignment_1 ) )
            {
            // InternalRpySyntax.g:766:1: ( ( rule__RpyFeature__NameAssignment_1 ) )
            // InternalRpySyntax.g:767:1: ( rule__RpyFeature__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyFeatureAccess().getNameAssignment_1()); 
            }
            // InternalRpySyntax.g:768:1: ( rule__RpyFeature__NameAssignment_1 )
            // InternalRpySyntax.g:768:2: rule__RpyFeature__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__RpyFeature__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyFeatureAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyFeature__Group__1__Impl"


    // $ANTLR start "rule__RpyFeature__Group__2"
    // InternalRpySyntax.g:778:1: rule__RpyFeature__Group__2 : rule__RpyFeature__Group__2__Impl rule__RpyFeature__Group__3 ;
    public final void rule__RpyFeature__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:782:1: ( rule__RpyFeature__Group__2__Impl rule__RpyFeature__Group__3 )
            // InternalRpySyntax.g:783:2: rule__RpyFeature__Group__2__Impl rule__RpyFeature__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__RpyFeature__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RpyFeature__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyFeature__Group__2"


    // $ANTLR start "rule__RpyFeature__Group__2__Impl"
    // InternalRpySyntax.g:790:1: rule__RpyFeature__Group__2__Impl : ( '=' ) ;
    public final void rule__RpyFeature__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:794:1: ( ( '=' ) )
            // InternalRpySyntax.g:795:1: ( '=' )
            {
            // InternalRpySyntax.g:795:1: ( '=' )
            // InternalRpySyntax.g:796:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyFeatureAccess().getEqualsSignKeyword_2()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyFeatureAccess().getEqualsSignKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyFeature__Group__2__Impl"


    // $ANTLR start "rule__RpyFeature__Group__3"
    // InternalRpySyntax.g:809:1: rule__RpyFeature__Group__3 : rule__RpyFeature__Group__3__Impl ;
    public final void rule__RpyFeature__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:813:1: ( rule__RpyFeature__Group__3__Impl )
            // InternalRpySyntax.g:814:2: rule__RpyFeature__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RpyFeature__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyFeature__Group__3"


    // $ANTLR start "rule__RpyFeature__Group__3__Impl"
    // InternalRpySyntax.g:820:1: rule__RpyFeature__Group__3__Impl : ( ( rule__RpyFeature__ValueAssignment_3 ) ) ;
    public final void rule__RpyFeature__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:824:1: ( ( ( rule__RpyFeature__ValueAssignment_3 ) ) )
            // InternalRpySyntax.g:825:1: ( ( rule__RpyFeature__ValueAssignment_3 ) )
            {
            // InternalRpySyntax.g:825:1: ( ( rule__RpyFeature__ValueAssignment_3 ) )
            // InternalRpySyntax.g:826:1: ( rule__RpyFeature__ValueAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyFeatureAccess().getValueAssignment_3()); 
            }
            // InternalRpySyntax.g:827:1: ( rule__RpyFeature__ValueAssignment_3 )
            // InternalRpySyntax.g:827:2: rule__RpyFeature__ValueAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__RpyFeature__ValueAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyFeatureAccess().getValueAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyFeature__Group__3__Impl"


    // $ANTLR start "rule__SimpleValueList__Group__0"
    // InternalRpySyntax.g:845:1: rule__SimpleValueList__Group__0 : rule__SimpleValueList__Group__0__Impl rule__SimpleValueList__Group__1 ;
    public final void rule__SimpleValueList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:849:1: ( rule__SimpleValueList__Group__0__Impl rule__SimpleValueList__Group__1 )
            // InternalRpySyntax.g:850:2: rule__SimpleValueList__Group__0__Impl rule__SimpleValueList__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__SimpleValueList__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SimpleValueList__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleValueList__Group__0"


    // $ANTLR start "rule__SimpleValueList__Group__0__Impl"
    // InternalRpySyntax.g:857:1: rule__SimpleValueList__Group__0__Impl : ( () ) ;
    public final void rule__SimpleValueList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:861:1: ( ( () ) )
            // InternalRpySyntax.g:862:1: ( () )
            {
            // InternalRpySyntax.g:862:1: ( () )
            // InternalRpySyntax.g:863:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleValueListAccess().getSimpleValueListAction_0()); 
            }
            // InternalRpySyntax.g:864:1: ()
            // InternalRpySyntax.g:866:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleValueListAccess().getSimpleValueListAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleValueList__Group__0__Impl"


    // $ANTLR start "rule__SimpleValueList__Group__1"
    // InternalRpySyntax.g:876:1: rule__SimpleValueList__Group__1 : rule__SimpleValueList__Group__1__Impl rule__SimpleValueList__Group__2 ;
    public final void rule__SimpleValueList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:880:1: ( rule__SimpleValueList__Group__1__Impl rule__SimpleValueList__Group__2 )
            // InternalRpySyntax.g:881:2: rule__SimpleValueList__Group__1__Impl rule__SimpleValueList__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__SimpleValueList__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SimpleValueList__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleValueList__Group__1"


    // $ANTLR start "rule__SimpleValueList__Group__1__Impl"
    // InternalRpySyntax.g:888:1: rule__SimpleValueList__Group__1__Impl : ( ( rule__SimpleValueList__IsOldIDAssignment_1 )? ) ;
    public final void rule__SimpleValueList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:892:1: ( ( ( rule__SimpleValueList__IsOldIDAssignment_1 )? ) )
            // InternalRpySyntax.g:893:1: ( ( rule__SimpleValueList__IsOldIDAssignment_1 )? )
            {
            // InternalRpySyntax.g:893:1: ( ( rule__SimpleValueList__IsOldIDAssignment_1 )? )
            // InternalRpySyntax.g:894:1: ( rule__SimpleValueList__IsOldIDAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleValueListAccess().getIsOldIDAssignment_1()); 
            }
            // InternalRpySyntax.g:895:1: ( rule__SimpleValueList__IsOldIDAssignment_1 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalRpySyntax.g:895:2: rule__SimpleValueList__IsOldIDAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__SimpleValueList__IsOldIDAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleValueListAccess().getIsOldIDAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleValueList__Group__1__Impl"


    // $ANTLR start "rule__SimpleValueList__Group__2"
    // InternalRpySyntax.g:905:1: rule__SimpleValueList__Group__2 : rule__SimpleValueList__Group__2__Impl rule__SimpleValueList__Group__3 ;
    public final void rule__SimpleValueList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:909:1: ( rule__SimpleValueList__Group__2__Impl rule__SimpleValueList__Group__3 )
            // InternalRpySyntax.g:910:2: rule__SimpleValueList__Group__2__Impl rule__SimpleValueList__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__SimpleValueList__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SimpleValueList__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleValueList__Group__2"


    // $ANTLR start "rule__SimpleValueList__Group__2__Impl"
    // InternalRpySyntax.g:917:1: rule__SimpleValueList__Group__2__Impl : ( ( rule__SimpleValueList__IsGUIDAssignment_2 )? ) ;
    public final void rule__SimpleValueList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:921:1: ( ( ( rule__SimpleValueList__IsGUIDAssignment_2 )? ) )
            // InternalRpySyntax.g:922:1: ( ( rule__SimpleValueList__IsGUIDAssignment_2 )? )
            {
            // InternalRpySyntax.g:922:1: ( ( rule__SimpleValueList__IsGUIDAssignment_2 )? )
            // InternalRpySyntax.g:923:1: ( rule__SimpleValueList__IsGUIDAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleValueListAccess().getIsGUIDAssignment_2()); 
            }
            // InternalRpySyntax.g:924:1: ( rule__SimpleValueList__IsGUIDAssignment_2 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalRpySyntax.g:924:2: rule__SimpleValueList__IsGUIDAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__SimpleValueList__IsGUIDAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleValueListAccess().getIsGUIDAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleValueList__Group__2__Impl"


    // $ANTLR start "rule__SimpleValueList__Group__3"
    // InternalRpySyntax.g:934:1: rule__SimpleValueList__Group__3 : rule__SimpleValueList__Group__3__Impl ;
    public final void rule__SimpleValueList__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:938:1: ( rule__SimpleValueList__Group__3__Impl )
            // InternalRpySyntax.g:939:2: rule__SimpleValueList__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SimpleValueList__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleValueList__Group__3"


    // $ANTLR start "rule__SimpleValueList__Group__3__Impl"
    // InternalRpySyntax.g:945:1: rule__SimpleValueList__Group__3__Impl : ( ( ( rule__SimpleValueList__ValueElementsAssignment_3 ) ) ( ( rule__SimpleValueList__ValueElementsAssignment_3 )* ) ) ;
    public final void rule__SimpleValueList__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:949:1: ( ( ( ( rule__SimpleValueList__ValueElementsAssignment_3 ) ) ( ( rule__SimpleValueList__ValueElementsAssignment_3 )* ) ) )
            // InternalRpySyntax.g:950:1: ( ( ( rule__SimpleValueList__ValueElementsAssignment_3 ) ) ( ( rule__SimpleValueList__ValueElementsAssignment_3 )* ) )
            {
            // InternalRpySyntax.g:950:1: ( ( ( rule__SimpleValueList__ValueElementsAssignment_3 ) ) ( ( rule__SimpleValueList__ValueElementsAssignment_3 )* ) )
            // InternalRpySyntax.g:951:1: ( ( rule__SimpleValueList__ValueElementsAssignment_3 ) ) ( ( rule__SimpleValueList__ValueElementsAssignment_3 )* )
            {
            // InternalRpySyntax.g:951:1: ( ( rule__SimpleValueList__ValueElementsAssignment_3 ) )
            // InternalRpySyntax.g:952:1: ( rule__SimpleValueList__ValueElementsAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleValueListAccess().getValueElementsAssignment_3()); 
            }
            // InternalRpySyntax.g:953:1: ( rule__SimpleValueList__ValueElementsAssignment_3 )
            // InternalRpySyntax.g:953:2: rule__SimpleValueList__ValueElementsAssignment_3
            {
            pushFollow(FOLLOW_13);
            rule__SimpleValueList__ValueElementsAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleValueListAccess().getValueElementsAssignment_3()); 
            }

            }

            // InternalRpySyntax.g:956:1: ( ( rule__SimpleValueList__ValueElementsAssignment_3 )* )
            // InternalRpySyntax.g:957:1: ( rule__SimpleValueList__ValueElementsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleValueListAccess().getValueElementsAssignment_3()); 
            }
            // InternalRpySyntax.g:958:1: ( rule__SimpleValueList__ValueElementsAssignment_3 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=RULE_STRING && LA10_0<=RULE_RPY_REAL)||LA10_0==20) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalRpySyntax.g:958:2: rule__SimpleValueList__ValueElementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__SimpleValueList__ValueElementsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleValueListAccess().getValueElementsAssignment_3()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleValueList__Group__3__Impl"


    // $ANTLR start "rule__RpySimpleValueElement__Group__0"
    // InternalRpySyntax.g:977:1: rule__RpySimpleValueElement__Group__0 : rule__RpySimpleValueElement__Group__0__Impl rule__RpySimpleValueElement__Group__1 ;
    public final void rule__RpySimpleValueElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:981:1: ( rule__RpySimpleValueElement__Group__0__Impl rule__RpySimpleValueElement__Group__1 )
            // InternalRpySyntax.g:982:2: rule__RpySimpleValueElement__Group__0__Impl rule__RpySimpleValueElement__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__RpySimpleValueElement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RpySimpleValueElement__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpySimpleValueElement__Group__0"


    // $ANTLR start "rule__RpySimpleValueElement__Group__0__Impl"
    // InternalRpySyntax.g:989:1: rule__RpySimpleValueElement__Group__0__Impl : ( () ) ;
    public final void rule__RpySimpleValueElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:993:1: ( ( () ) )
            // InternalRpySyntax.g:994:1: ( () )
            {
            // InternalRpySyntax.g:994:1: ( () )
            // InternalRpySyntax.g:995:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpySimpleValueElementAccess().getRpySimpleValueElementAction_0()); 
            }
            // InternalRpySyntax.g:996:1: ()
            // InternalRpySyntax.g:998:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpySimpleValueElementAccess().getRpySimpleValueElementAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpySimpleValueElement__Group__0__Impl"


    // $ANTLR start "rule__RpySimpleValueElement__Group__1"
    // InternalRpySyntax.g:1008:1: rule__RpySimpleValueElement__Group__1 : rule__RpySimpleValueElement__Group__1__Impl rule__RpySimpleValueElement__Group__2 ;
    public final void rule__RpySimpleValueElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1012:1: ( rule__RpySimpleValueElement__Group__1__Impl rule__RpySimpleValueElement__Group__2 )
            // InternalRpySyntax.g:1013:2: rule__RpySimpleValueElement__Group__1__Impl rule__RpySimpleValueElement__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__RpySimpleValueElement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RpySimpleValueElement__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpySimpleValueElement__Group__1"


    // $ANTLR start "rule__RpySimpleValueElement__Group__1__Impl"
    // InternalRpySyntax.g:1020:1: rule__RpySimpleValueElement__Group__1__Impl : ( ( rule__RpySimpleValueElement__ValuesAssignment_1 )* ) ;
    public final void rule__RpySimpleValueElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1024:1: ( ( ( rule__RpySimpleValueElement__ValuesAssignment_1 )* ) )
            // InternalRpySyntax.g:1025:1: ( ( rule__RpySimpleValueElement__ValuesAssignment_1 )* )
            {
            // InternalRpySyntax.g:1025:1: ( ( rule__RpySimpleValueElement__ValuesAssignment_1 )* )
            // InternalRpySyntax.g:1026:1: ( rule__RpySimpleValueElement__ValuesAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpySimpleValueElementAccess().getValuesAssignment_1()); 
            }
            // InternalRpySyntax.g:1027:1: ( rule__RpySimpleValueElement__ValuesAssignment_1 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=RULE_STRING && LA11_0<=RULE_RPY_REAL)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalRpySyntax.g:1027:2: rule__RpySimpleValueElement__ValuesAssignment_1
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__RpySimpleValueElement__ValuesAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpySimpleValueElementAccess().getValuesAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpySimpleValueElement__Group__1__Impl"


    // $ANTLR start "rule__RpySimpleValueElement__Group__2"
    // InternalRpySyntax.g:1037:1: rule__RpySimpleValueElement__Group__2 : rule__RpySimpleValueElement__Group__2__Impl ;
    public final void rule__RpySimpleValueElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1041:1: ( rule__RpySimpleValueElement__Group__2__Impl )
            // InternalRpySyntax.g:1042:2: rule__RpySimpleValueElement__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RpySimpleValueElement__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpySimpleValueElement__Group__2"


    // $ANTLR start "rule__RpySimpleValueElement__Group__2__Impl"
    // InternalRpySyntax.g:1048:1: rule__RpySimpleValueElement__Group__2__Impl : ( ';' ) ;
    public final void rule__RpySimpleValueElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1052:1: ( ( ';' ) )
            // InternalRpySyntax.g:1053:1: ( ';' )
            {
            // InternalRpySyntax.g:1053:1: ( ';' )
            // InternalRpySyntax.g:1054:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpySimpleValueElementAccess().getSemicolonKeyword_2()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpySimpleValueElementAccess().getSemicolonKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpySimpleValueElement__Group__2__Impl"


    // $ANTLR start "rule__RpyStringMapEntry__Group__0"
    // InternalRpySyntax.g:1073:1: rule__RpyStringMapEntry__Group__0 : rule__RpyStringMapEntry__Group__0__Impl rule__RpyStringMapEntry__Group__1 ;
    public final void rule__RpyStringMapEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1077:1: ( rule__RpyStringMapEntry__Group__0__Impl rule__RpyStringMapEntry__Group__1 )
            // InternalRpySyntax.g:1078:2: rule__RpyStringMapEntry__Group__0__Impl rule__RpyStringMapEntry__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__RpyStringMapEntry__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RpyStringMapEntry__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyStringMapEntry__Group__0"


    // $ANTLR start "rule__RpyStringMapEntry__Group__0__Impl"
    // InternalRpySyntax.g:1085:1: rule__RpyStringMapEntry__Group__0__Impl : ( ( rule__RpyStringMapEntry__KeyAssignment_0 ) ) ;
    public final void rule__RpyStringMapEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1089:1: ( ( ( rule__RpyStringMapEntry__KeyAssignment_0 ) ) )
            // InternalRpySyntax.g:1090:1: ( ( rule__RpyStringMapEntry__KeyAssignment_0 ) )
            {
            // InternalRpySyntax.g:1090:1: ( ( rule__RpyStringMapEntry__KeyAssignment_0 ) )
            // InternalRpySyntax.g:1091:1: ( rule__RpyStringMapEntry__KeyAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyStringMapEntryAccess().getKeyAssignment_0()); 
            }
            // InternalRpySyntax.g:1092:1: ( rule__RpyStringMapEntry__KeyAssignment_0 )
            // InternalRpySyntax.g:1092:2: rule__RpyStringMapEntry__KeyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__RpyStringMapEntry__KeyAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyStringMapEntryAccess().getKeyAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyStringMapEntry__Group__0__Impl"


    // $ANTLR start "rule__RpyStringMapEntry__Group__1"
    // InternalRpySyntax.g:1102:1: rule__RpyStringMapEntry__Group__1 : rule__RpyStringMapEntry__Group__1__Impl ;
    public final void rule__RpyStringMapEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1106:1: ( rule__RpyStringMapEntry__Group__1__Impl )
            // InternalRpySyntax.g:1107:2: rule__RpyStringMapEntry__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RpyStringMapEntry__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyStringMapEntry__Group__1"


    // $ANTLR start "rule__RpyStringMapEntry__Group__1__Impl"
    // InternalRpySyntax.g:1113:1: rule__RpyStringMapEntry__Group__1__Impl : ( ( rule__RpyStringMapEntry__ValueAssignment_1 ) ) ;
    public final void rule__RpyStringMapEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1117:1: ( ( ( rule__RpyStringMapEntry__ValueAssignment_1 ) ) )
            // InternalRpySyntax.g:1118:1: ( ( rule__RpyStringMapEntry__ValueAssignment_1 ) )
            {
            // InternalRpySyntax.g:1118:1: ( ( rule__RpyStringMapEntry__ValueAssignment_1 ) )
            // InternalRpySyntax.g:1119:1: ( rule__RpyStringMapEntry__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyStringMapEntryAccess().getValueAssignment_1()); 
            }
            // InternalRpySyntax.g:1120:1: ( rule__RpyStringMapEntry__ValueAssignment_1 )
            // InternalRpySyntax.g:1120:2: rule__RpyStringMapEntry__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__RpyStringMapEntry__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyStringMapEntryAccess().getValueAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyStringMapEntry__Group__1__Impl"


    // $ANTLR start "rule__RpyFile__VersionAssignment_1"
    // InternalRpySyntax.g:1135:1: rule__RpyFile__VersionAssignment_1 : ( RULE_RPY_VERSION ) ;
    public final void rule__RpyFile__VersionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1139:1: ( ( RULE_RPY_VERSION ) )
            // InternalRpySyntax.g:1140:1: ( RULE_RPY_VERSION )
            {
            // InternalRpySyntax.g:1140:1: ( RULE_RPY_VERSION )
            // InternalRpySyntax.g:1141:1: RULE_RPY_VERSION
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyFileAccess().getVersionRPY_VERSIONTerminalRuleCall_1_0()); 
            }
            match(input,RULE_RPY_VERSION,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyFileAccess().getVersionRPY_VERSIONTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyFile__VersionAssignment_1"


    // $ANTLR start "rule__RpyFile__ContentsAssignment_2"
    // InternalRpySyntax.g:1150:1: rule__RpyFile__ContentsAssignment_2 : ( ruleRpyContent ) ;
    public final void rule__RpyFile__ContentsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1154:1: ( ( ruleRpyContent ) )
            // InternalRpySyntax.g:1155:1: ( ruleRpyContent )
            {
            // InternalRpySyntax.g:1155:1: ( ruleRpyContent )
            // InternalRpySyntax.g:1156:1: ruleRpyContent
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyFileAccess().getContentsRpyContentParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRpyContent();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyFileAccess().getContentsRpyContentParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyFile__ContentsAssignment_2"


    // $ANTLR start "rule__RpyNode__NameAssignment_1"
    // InternalRpySyntax.g:1165:1: rule__RpyNode__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__RpyNode__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1169:1: ( ( RULE_ID ) )
            // InternalRpySyntax.g:1170:1: ( RULE_ID )
            {
            // InternalRpySyntax.g:1170:1: ( RULE_ID )
            // InternalRpySyntax.g:1171:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyNodeAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyNodeAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyNode__NameAssignment_1"


    // $ANTLR start "rule__RpyNode__ContentsAssignment_2"
    // InternalRpySyntax.g:1180:1: rule__RpyNode__ContentsAssignment_2 : ( ruleRpyContent ) ;
    public final void rule__RpyNode__ContentsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1184:1: ( ( ruleRpyContent ) )
            // InternalRpySyntax.g:1185:1: ( ruleRpyContent )
            {
            // InternalRpySyntax.g:1185:1: ( ruleRpyContent )
            // InternalRpySyntax.g:1186:1: ruleRpyContent
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyNodeAccess().getContentsRpyContentParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRpyContent();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyNodeAccess().getContentsRpyContentParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyNode__ContentsAssignment_2"


    // $ANTLR start "rule__RpyFeature__NameAssignment_1"
    // InternalRpySyntax.g:1195:1: rule__RpyFeature__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__RpyFeature__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1199:1: ( ( RULE_ID ) )
            // InternalRpySyntax.g:1200:1: ( RULE_ID )
            {
            // InternalRpySyntax.g:1200:1: ( RULE_ID )
            // InternalRpySyntax.g:1201:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyFeatureAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyFeatureAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyFeature__NameAssignment_1"


    // $ANTLR start "rule__RpyFeature__ValueAssignment_3"
    // InternalRpySyntax.g:1210:1: rule__RpyFeature__ValueAssignment_3 : ( ruleRpyFeatureValue ) ;
    public final void rule__RpyFeature__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1214:1: ( ( ruleRpyFeatureValue ) )
            // InternalRpySyntax.g:1215:1: ( ruleRpyFeatureValue )
            {
            // InternalRpySyntax.g:1215:1: ( ruleRpyFeatureValue )
            // InternalRpySyntax.g:1216:1: ruleRpyFeatureValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyFeatureAccess().getValueRpyFeatureValueParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRpyFeatureValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyFeatureAccess().getValueRpyFeatureValueParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyFeature__ValueAssignment_3"


    // $ANTLR start "rule__RpyNodeList__ValuesAssignment"
    // InternalRpySyntax.g:1225:1: rule__RpyNodeList__ValuesAssignment : ( ruleRpyNode ) ;
    public final void rule__RpyNodeList__ValuesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1229:1: ( ( ruleRpyNode ) )
            // InternalRpySyntax.g:1230:1: ( ruleRpyNode )
            {
            // InternalRpySyntax.g:1230:1: ( ruleRpyNode )
            // InternalRpySyntax.g:1231:1: ruleRpyNode
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyNodeListAccess().getValuesRpyNodeParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRpyNode();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyNodeListAccess().getValuesRpyNodeParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyNodeList__ValuesAssignment"


    // $ANTLR start "rule__SimpleValueList__IsOldIDAssignment_1"
    // InternalRpySyntax.g:1240:1: rule__SimpleValueList__IsOldIDAssignment_1 : ( ( 'OLDID' ) ) ;
    public final void rule__SimpleValueList__IsOldIDAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1244:1: ( ( ( 'OLDID' ) ) )
            // InternalRpySyntax.g:1245:1: ( ( 'OLDID' ) )
            {
            // InternalRpySyntax.g:1245:1: ( ( 'OLDID' ) )
            // InternalRpySyntax.g:1246:1: ( 'OLDID' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleValueListAccess().getIsOldIDOLDIDKeyword_1_0()); 
            }
            // InternalRpySyntax.g:1247:1: ( 'OLDID' )
            // InternalRpySyntax.g:1248:1: 'OLDID'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleValueListAccess().getIsOldIDOLDIDKeyword_1_0()); 
            }
            match(input,21,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleValueListAccess().getIsOldIDOLDIDKeyword_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleValueListAccess().getIsOldIDOLDIDKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleValueList__IsOldIDAssignment_1"


    // $ANTLR start "rule__SimpleValueList__IsGUIDAssignment_2"
    // InternalRpySyntax.g:1263:1: rule__SimpleValueList__IsGUIDAssignment_2 : ( ( 'GUID' ) ) ;
    public final void rule__SimpleValueList__IsGUIDAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1267:1: ( ( ( 'GUID' ) ) )
            // InternalRpySyntax.g:1268:1: ( ( 'GUID' ) )
            {
            // InternalRpySyntax.g:1268:1: ( ( 'GUID' ) )
            // InternalRpySyntax.g:1269:1: ( 'GUID' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleValueListAccess().getIsGUIDGUIDKeyword_2_0()); 
            }
            // InternalRpySyntax.g:1270:1: ( 'GUID' )
            // InternalRpySyntax.g:1271:1: 'GUID'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleValueListAccess().getIsGUIDGUIDKeyword_2_0()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleValueListAccess().getIsGUIDGUIDKeyword_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleValueListAccess().getIsGUIDGUIDKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleValueList__IsGUIDAssignment_2"


    // $ANTLR start "rule__SimpleValueList__ValueElementsAssignment_3"
    // InternalRpySyntax.g:1286:1: rule__SimpleValueList__ValueElementsAssignment_3 : ( ruleRpySimpleValueElement ) ;
    public final void rule__SimpleValueList__ValueElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1290:1: ( ( ruleRpySimpleValueElement ) )
            // InternalRpySyntax.g:1291:1: ( ruleRpySimpleValueElement )
            {
            // InternalRpySyntax.g:1291:1: ( ruleRpySimpleValueElement )
            // InternalRpySyntax.g:1292:1: ruleRpySimpleValueElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleValueListAccess().getValueElementsRpySimpleValueElementParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRpySimpleValueElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleValueListAccess().getValueElementsRpySimpleValueElementParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleValueList__ValueElementsAssignment_3"


    // $ANTLR start "rule__RpySimpleValueElement__ValuesAssignment_1"
    // InternalRpySyntax.g:1301:1: rule__RpySimpleValueElement__ValuesAssignment_1 : ( ruleVALUE_TERMINAL ) ;
    public final void rule__RpySimpleValueElement__ValuesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1305:1: ( ( ruleVALUE_TERMINAL ) )
            // InternalRpySyntax.g:1306:1: ( ruleVALUE_TERMINAL )
            {
            // InternalRpySyntax.g:1306:1: ( ruleVALUE_TERMINAL )
            // InternalRpySyntax.g:1307:1: ruleVALUE_TERMINAL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpySimpleValueElementAccess().getValuesVALUE_TERMINALParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleVALUE_TERMINAL();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpySimpleValueElementAccess().getValuesVALUE_TERMINALParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpySimpleValueElement__ValuesAssignment_1"


    // $ANTLR start "rule__RpyStringMap__EntriesAssignment"
    // InternalRpySyntax.g:1316:1: rule__RpyStringMap__EntriesAssignment : ( ruleRpyStringMapEntry ) ;
    public final void rule__RpyStringMap__EntriesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1320:1: ( ( ruleRpyStringMapEntry ) )
            // InternalRpySyntax.g:1321:1: ( ruleRpyStringMapEntry )
            {
            // InternalRpySyntax.g:1321:1: ( ruleRpyStringMapEntry )
            // InternalRpySyntax.g:1322:1: ruleRpyStringMapEntry
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyStringMapAccess().getEntriesRpyStringMapEntryParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRpyStringMapEntry();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyStringMapAccess().getEntriesRpyStringMapEntryParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyStringMap__EntriesAssignment"


    // $ANTLR start "rule__RpyStringMapEntry__KeyAssignment_0"
    // InternalRpySyntax.g:1331:1: rule__RpyStringMapEntry__KeyAssignment_0 : ( RULE_STRING ) ;
    public final void rule__RpyStringMapEntry__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1335:1: ( ( RULE_STRING ) )
            // InternalRpySyntax.g:1336:1: ( RULE_STRING )
            {
            // InternalRpySyntax.g:1336:1: ( RULE_STRING )
            // InternalRpySyntax.g:1337:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyStringMapEntryAccess().getKeySTRINGTerminalRuleCall_0_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyStringMapEntryAccess().getKeySTRINGTerminalRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyStringMapEntry__KeyAssignment_0"


    // $ANTLR start "rule__RpyStringMapEntry__ValueAssignment_1"
    // InternalRpySyntax.g:1346:1: rule__RpyStringMapEntry__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__RpyStringMapEntry__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalRpySyntax.g:1350:1: ( ( RULE_STRING ) )
            // InternalRpySyntax.g:1351:1: ( RULE_STRING )
            {
            // InternalRpySyntax.g:1351:1: ( RULE_STRING )
            // InternalRpySyntax.g:1352:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRpyStringMapEntryAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRpyStringMapEntryAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RpyStringMapEntry__ValueAssignment_1"

    // $ANTLR start synpred1_InternalRpySyntax
    public final void synpred1_InternalRpySyntax_fragment() throws RecognitionException {   
        // InternalRpySyntax.g:232:2: ( rule__RpyNodeList__ValuesAssignment )
        // InternalRpySyntax.g:232:2: rule__RpyNodeList__ValuesAssignment
        {
        pushFollow(FOLLOW_2);
        rule__RpyNodeList__ValuesAssignment();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalRpySyntax

    // Delegated rules

    public final boolean synpred1_InternalRpySyntax() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalRpySyntax_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String dfa_1s = "\10\uffff";
    static final String dfa_2s = "\4\uffff\1\6\2\uffff\1\6";
    static final String dfa_3s = "\1\4\1\uffff\1\4\1\uffff\2\4\1\uffff\1\4";
    static final String dfa_4s = "\1\26\1\uffff\1\24\1\uffff\2\24\1\uffff\1\24";
    static final String dfa_5s = "\1\uffff\1\1\1\uffff\1\2\2\uffff\1\3\1\uffff";
    static final String dfa_6s = "\10\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\5\1\6\uffff\1\3\3\uffff\3\1",
            "",
            "\1\4\5\1\12\uffff\1\1",
            "",
            "\1\5\5\1\6\uffff\3\6\1\uffff\1\1",
            "\1\7\5\1\12\uffff\1\1",
            "",
            "\1\5\5\1\6\uffff\3\6\1\uffff\1\1"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "414:1: rule__RpyFeatureValue__Alternatives : ( ( ruleSimpleValueList ) | ( ruleRpyNodeList ) | ( ruleRpyStringMap ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000007103F0L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000007003F0L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000000007003F2L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000000000003F2L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000010L});

}