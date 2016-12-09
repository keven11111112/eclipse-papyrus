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
public class InternalRpySyntaxParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_RPY_VERSION", "RULE_ID", "RULE_STRING", "RULE_RPY_GUID", "RULE_INT", "RULE_RPY_TIME", "RULE_RPY_REAL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'I-Logix-RPY-Archive'", "'{'", "'}'", "'-'", "'='", "'OLDID'", "'GUID'", "';'"
    };
    public static final int RULE_RPY_GUID=7;
    public static final int RULE_RPY_TIME=9;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=13;
    public static final int RULE_RPY_VERSION=4;
    public static final int RULE_ANY_OTHER=14;
    public static final int RULE_INT=8;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=11;
    public static final int RULE_RPY_REAL=10;
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



    // $ANTLR start "entryRuleRpyFile"
    // InternalRpySyntax.g:82:1: entryRuleRpyFile returns [EObject current=null] : iv_ruleRpyFile= ruleRpyFile EOF ;
    public final EObject entryRuleRpyFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRpyFile = null;


        try {
            // InternalRpySyntax.g:83:2: (iv_ruleRpyFile= ruleRpyFile EOF )
            // InternalRpySyntax.g:84:2: iv_ruleRpyFile= ruleRpyFile EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRpyFileRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRpyFile=ruleRpyFile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRpyFile; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRpyFile"


    // $ANTLR start "ruleRpyFile"
    // InternalRpySyntax.g:91:1: ruleRpyFile returns [EObject current=null] : (otherlv_0= 'I-Logix-RPY-Archive' ( (lv_version_1_0= RULE_RPY_VERSION ) ) ( (lv_contents_2_0= ruleRpyContent ) )* ) ;
    public final EObject ruleRpyFile() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        EObject lv_contents_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRpySyntax.g:94:28: ( (otherlv_0= 'I-Logix-RPY-Archive' ( (lv_version_1_0= RULE_RPY_VERSION ) ) ( (lv_contents_2_0= ruleRpyContent ) )* ) )
            // InternalRpySyntax.g:95:1: (otherlv_0= 'I-Logix-RPY-Archive' ( (lv_version_1_0= RULE_RPY_VERSION ) ) ( (lv_contents_2_0= ruleRpyContent ) )* )
            {
            // InternalRpySyntax.g:95:1: (otherlv_0= 'I-Logix-RPY-Archive' ( (lv_version_1_0= RULE_RPY_VERSION ) ) ( (lv_contents_2_0= ruleRpyContent ) )* )
            // InternalRpySyntax.g:95:3: otherlv_0= 'I-Logix-RPY-Archive' ( (lv_version_1_0= RULE_RPY_VERSION ) ) ( (lv_contents_2_0= ruleRpyContent ) )*
            {
            otherlv_0=(Token)match(input,15,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRpyFileAccess().getILogixRPYArchiveKeyword_0());
                  
            }
            // InternalRpySyntax.g:99:1: ( (lv_version_1_0= RULE_RPY_VERSION ) )
            // InternalRpySyntax.g:100:1: (lv_version_1_0= RULE_RPY_VERSION )
            {
            // InternalRpySyntax.g:100:1: (lv_version_1_0= RULE_RPY_VERSION )
            // InternalRpySyntax.g:101:3: lv_version_1_0= RULE_RPY_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_RPY_VERSION,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_version_1_0, grammarAccess.getRpyFileAccess().getVersionRPY_VERSIONTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRpyFileRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"version",
                      		lv_version_1_0, 
                      		"org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RPY_VERSION");
              	    
            }

            }


            }

            // InternalRpySyntax.g:117:2: ( (lv_contents_2_0= ruleRpyContent ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16||LA1_0==18) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRpySyntax.g:118:1: (lv_contents_2_0= ruleRpyContent )
            	    {
            	    // InternalRpySyntax.g:118:1: (lv_contents_2_0= ruleRpyContent )
            	    // InternalRpySyntax.g:119:3: lv_contents_2_0= ruleRpyContent
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRpyFileAccess().getContentsRpyContentParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_contents_2_0=ruleRpyContent();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRpyFileRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"contents",
            	              		lv_contents_2_0, 
            	              		"org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpyContent");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRpyFile"


    // $ANTLR start "entryRuleRpyContent"
    // InternalRpySyntax.g:143:1: entryRuleRpyContent returns [EObject current=null] : iv_ruleRpyContent= ruleRpyContent EOF ;
    public final EObject entryRuleRpyContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRpyContent = null;


        try {
            // InternalRpySyntax.g:144:2: (iv_ruleRpyContent= ruleRpyContent EOF )
            // InternalRpySyntax.g:145:2: iv_ruleRpyContent= ruleRpyContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRpyContentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRpyContent=ruleRpyContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRpyContent; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRpyContent"


    // $ANTLR start "ruleRpyContent"
    // InternalRpySyntax.g:152:1: ruleRpyContent returns [EObject current=null] : (this_RpyNode_0= ruleRpyNode | this_RpyFeature_1= ruleRpyFeature ) ;
    public final EObject ruleRpyContent() throws RecognitionException {
        EObject current = null;

        EObject this_RpyNode_0 = null;

        EObject this_RpyFeature_1 = null;


         enterRule(); 
            
        try {
            // InternalRpySyntax.g:155:28: ( (this_RpyNode_0= ruleRpyNode | this_RpyFeature_1= ruleRpyFeature ) )
            // InternalRpySyntax.g:156:1: (this_RpyNode_0= ruleRpyNode | this_RpyFeature_1= ruleRpyFeature )
            {
            // InternalRpySyntax.g:156:1: (this_RpyNode_0= ruleRpyNode | this_RpyFeature_1= ruleRpyFeature )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==16) ) {
                alt2=1;
            }
            else if ( (LA2_0==18) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalRpySyntax.g:157:2: this_RpyNode_0= ruleRpyNode
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getRpyContentAccess().getRpyNodeParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_RpyNode_0=ruleRpyNode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RpyNode_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalRpySyntax.g:170:2: this_RpyFeature_1= ruleRpyFeature
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getRpyContentAccess().getRpyFeatureParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_RpyFeature_1=ruleRpyFeature();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RpyFeature_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRpyContent"


    // $ANTLR start "entryRuleRpyNode"
    // InternalRpySyntax.g:189:1: entryRuleRpyNode returns [EObject current=null] : iv_ruleRpyNode= ruleRpyNode EOF ;
    public final EObject entryRuleRpyNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRpyNode = null;


        try {
            // InternalRpySyntax.g:190:2: (iv_ruleRpyNode= ruleRpyNode EOF )
            // InternalRpySyntax.g:191:2: iv_ruleRpyNode= ruleRpyNode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRpyNodeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRpyNode=ruleRpyNode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRpyNode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRpyNode"


    // $ANTLR start "ruleRpyNode"
    // InternalRpySyntax.g:198:1: ruleRpyNode returns [EObject current=null] : (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) ( (lv_contents_2_0= ruleRpyContent ) )+ otherlv_3= '}' ) ;
    public final EObject ruleRpyNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        EObject lv_contents_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRpySyntax.g:201:28: ( (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) ( (lv_contents_2_0= ruleRpyContent ) )+ otherlv_3= '}' ) )
            // InternalRpySyntax.g:202:1: (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) ( (lv_contents_2_0= ruleRpyContent ) )+ otherlv_3= '}' )
            {
            // InternalRpySyntax.g:202:1: (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) ( (lv_contents_2_0= ruleRpyContent ) )+ otherlv_3= '}' )
            // InternalRpySyntax.g:202:3: otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) ( (lv_contents_2_0= ruleRpyContent ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRpyNodeAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // InternalRpySyntax.g:206:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRpySyntax.g:207:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRpySyntax.g:207:1: (lv_name_1_0= RULE_ID )
            // InternalRpySyntax.g:208:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getRpyNodeAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRpyNodeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            // InternalRpySyntax.g:224:2: ( (lv_contents_2_0= ruleRpyContent ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16||LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalRpySyntax.g:225:1: (lv_contents_2_0= ruleRpyContent )
            	    {
            	    // InternalRpySyntax.g:225:1: (lv_contents_2_0= ruleRpyContent )
            	    // InternalRpySyntax.g:226:3: lv_contents_2_0= ruleRpyContent
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRpyNodeAccess().getContentsRpyContentParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_7);
            	    lv_contents_2_0=ruleRpyContent();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRpyNodeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"contents",
            	              		lv_contents_2_0, 
            	              		"org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpyContent");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            otherlv_3=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getRpyNodeAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRpyNode"


    // $ANTLR start "entryRuleRpyFeature"
    // InternalRpySyntax.g:254:1: entryRuleRpyFeature returns [EObject current=null] : iv_ruleRpyFeature= ruleRpyFeature EOF ;
    public final EObject entryRuleRpyFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRpyFeature = null;


        try {
            // InternalRpySyntax.g:255:2: (iv_ruleRpyFeature= ruleRpyFeature EOF )
            // InternalRpySyntax.g:256:2: iv_ruleRpyFeature= ruleRpyFeature EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRpyFeatureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRpyFeature=ruleRpyFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRpyFeature; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRpyFeature"


    // $ANTLR start "ruleRpyFeature"
    // InternalRpySyntax.g:263:1: ruleRpyFeature returns [EObject current=null] : (otherlv_0= '-' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleRpyFeatureValue ) ) ) ;
    public final EObject ruleRpyFeature() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRpySyntax.g:266:28: ( (otherlv_0= '-' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleRpyFeatureValue ) ) ) )
            // InternalRpySyntax.g:267:1: (otherlv_0= '-' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleRpyFeatureValue ) ) )
            {
            // InternalRpySyntax.g:267:1: (otherlv_0= '-' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleRpyFeatureValue ) ) )
            // InternalRpySyntax.g:267:3: otherlv_0= '-' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleRpyFeatureValue ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRpyFeatureAccess().getHyphenMinusKeyword_0());
                  
            }
            // InternalRpySyntax.g:271:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRpySyntax.g:272:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRpySyntax.g:272:1: (lv_name_1_0= RULE_ID )
            // InternalRpySyntax.g:273:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getRpyFeatureAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRpyFeatureRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRpyFeatureAccess().getEqualsSignKeyword_2());
                  
            }
            // InternalRpySyntax.g:293:1: ( (lv_value_3_0= ruleRpyFeatureValue ) )
            // InternalRpySyntax.g:294:1: (lv_value_3_0= ruleRpyFeatureValue )
            {
            // InternalRpySyntax.g:294:1: (lv_value_3_0= ruleRpyFeatureValue )
            // InternalRpySyntax.g:295:3: lv_value_3_0= ruleRpyFeatureValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRpyFeatureAccess().getValueRpyFeatureValueParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleRpyFeatureValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRpyFeatureRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_3_0, 
                      		"org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpyFeatureValue");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRpyFeature"


    // $ANTLR start "entryRuleRpyFeatureValue"
    // InternalRpySyntax.g:319:1: entryRuleRpyFeatureValue returns [EObject current=null] : iv_ruleRpyFeatureValue= ruleRpyFeatureValue EOF ;
    public final EObject entryRuleRpyFeatureValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRpyFeatureValue = null;


        try {
            // InternalRpySyntax.g:320:2: (iv_ruleRpyFeatureValue= ruleRpyFeatureValue EOF )
            // InternalRpySyntax.g:321:2: iv_ruleRpyFeatureValue= ruleRpyFeatureValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRpyFeatureValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRpyFeatureValue=ruleRpyFeatureValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRpyFeatureValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRpyFeatureValue"


    // $ANTLR start "ruleRpyFeatureValue"
    // InternalRpySyntax.g:328:1: ruleRpyFeatureValue returns [EObject current=null] : (this_SimpleValueList_0= ruleSimpleValueList | this_RpyNodeList_1= ruleRpyNodeList | this_RpyStringMap_2= ruleRpyStringMap ) ;
    public final EObject ruleRpyFeatureValue() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleValueList_0 = null;

        EObject this_RpyNodeList_1 = null;

        EObject this_RpyStringMap_2 = null;


         enterRule(); 
            
        try {
            // InternalRpySyntax.g:331:28: ( (this_SimpleValueList_0= ruleSimpleValueList | this_RpyNodeList_1= ruleRpyNodeList | this_RpyStringMap_2= ruleRpyStringMap ) )
            // InternalRpySyntax.g:332:1: (this_SimpleValueList_0= ruleSimpleValueList | this_RpyNodeList_1= ruleRpyNodeList | this_RpyStringMap_2= ruleRpyStringMap )
            {
            // InternalRpySyntax.g:332:1: (this_SimpleValueList_0= ruleSimpleValueList | this_RpyNodeList_1= ruleRpyNodeList | this_RpyStringMap_2= ruleRpyStringMap )
            int alt4=3;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalRpySyntax.g:333:2: this_SimpleValueList_0= ruleSimpleValueList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getRpyFeatureValueAccess().getSimpleValueListParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_SimpleValueList_0=ruleSimpleValueList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SimpleValueList_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalRpySyntax.g:346:2: this_RpyNodeList_1= ruleRpyNodeList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getRpyFeatureValueAccess().getRpyNodeListParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_RpyNodeList_1=ruleRpyNodeList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RpyNodeList_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalRpySyntax.g:359:2: this_RpyStringMap_2= ruleRpyStringMap
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getRpyFeatureValueAccess().getRpyStringMapParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_RpyStringMap_2=ruleRpyStringMap();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RpyStringMap_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRpyFeatureValue"


    // $ANTLR start "entryRuleRpyNodeList"
    // InternalRpySyntax.g:378:1: entryRuleRpyNodeList returns [EObject current=null] : iv_ruleRpyNodeList= ruleRpyNodeList EOF ;
    public final EObject entryRuleRpyNodeList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRpyNodeList = null;


        try {
            // InternalRpySyntax.g:379:2: (iv_ruleRpyNodeList= ruleRpyNodeList EOF )
            // InternalRpySyntax.g:380:2: iv_ruleRpyNodeList= ruleRpyNodeList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRpyNodeListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRpyNodeList=ruleRpyNodeList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRpyNodeList; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRpyNodeList"


    // $ANTLR start "ruleRpyNodeList"
    // InternalRpySyntax.g:387:1: ruleRpyNodeList returns [EObject current=null] : ( (lv_values_0_0= ruleRpyNode ) )+ ;
    public final EObject ruleRpyNodeList() throws RecognitionException {
        EObject current = null;

        EObject lv_values_0_0 = null;


         enterRule(); 
            
        try {
            // InternalRpySyntax.g:390:28: ( ( (lv_values_0_0= ruleRpyNode ) )+ )
            // InternalRpySyntax.g:391:1: ( (lv_values_0_0= ruleRpyNode ) )+
            {
            // InternalRpySyntax.g:391:1: ( (lv_values_0_0= ruleRpyNode ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==16) ) {
                    int LA5_2 = input.LA(2);

                    if ( (synpred6_InternalRpySyntax()) ) {
                        alt5=1;
                    }


                }


                switch (alt5) {
            	case 1 :
            	    // InternalRpySyntax.g:392:1: (lv_values_0_0= ruleRpyNode )
            	    {
            	    // InternalRpySyntax.g:392:1: (lv_values_0_0= ruleRpyNode )
            	    // InternalRpySyntax.g:393:3: lv_values_0_0= ruleRpyNode
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRpyNodeListAccess().getValuesRpyNodeParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_values_0_0=ruleRpyNode();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRpyNodeListRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"values",
            	              		lv_values_0_0, 
            	              		"org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpyNode");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRpyNodeList"


    // $ANTLR start "entryRuleSimpleValueList"
    // InternalRpySyntax.g:417:1: entryRuleSimpleValueList returns [EObject current=null] : iv_ruleSimpleValueList= ruleSimpleValueList EOF ;
    public final EObject entryRuleSimpleValueList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleValueList = null;


        try {
            // InternalRpySyntax.g:418:2: (iv_ruleSimpleValueList= ruleSimpleValueList EOF )
            // InternalRpySyntax.g:419:2: iv_ruleSimpleValueList= ruleSimpleValueList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleValueListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSimpleValueList=ruleSimpleValueList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleValueList; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleValueList"


    // $ANTLR start "ruleSimpleValueList"
    // InternalRpySyntax.g:426:1: ruleSimpleValueList returns [EObject current=null] : ( () ( (lv_isOldID_1_0= 'OLDID' ) )? ( (lv_isGUID_2_0= 'GUID' ) )? ( (lv_valueElements_3_0= ruleRpySimpleValueElement ) )+ ) ;
    public final EObject ruleSimpleValueList() throws RecognitionException {
        EObject current = null;

        Token lv_isOldID_1_0=null;
        Token lv_isGUID_2_0=null;
        EObject lv_valueElements_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRpySyntax.g:429:28: ( ( () ( (lv_isOldID_1_0= 'OLDID' ) )? ( (lv_isGUID_2_0= 'GUID' ) )? ( (lv_valueElements_3_0= ruleRpySimpleValueElement ) )+ ) )
            // InternalRpySyntax.g:430:1: ( () ( (lv_isOldID_1_0= 'OLDID' ) )? ( (lv_isGUID_2_0= 'GUID' ) )? ( (lv_valueElements_3_0= ruleRpySimpleValueElement ) )+ )
            {
            // InternalRpySyntax.g:430:1: ( () ( (lv_isOldID_1_0= 'OLDID' ) )? ( (lv_isGUID_2_0= 'GUID' ) )? ( (lv_valueElements_3_0= ruleRpySimpleValueElement ) )+ )
            // InternalRpySyntax.g:430:2: () ( (lv_isOldID_1_0= 'OLDID' ) )? ( (lv_isGUID_2_0= 'GUID' ) )? ( (lv_valueElements_3_0= ruleRpySimpleValueElement ) )+
            {
            // InternalRpySyntax.g:430:2: ()
            // InternalRpySyntax.g:431:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getSimpleValueListAccess().getSimpleValueListAction_0(),
                          current);
                  
            }

            }

            // InternalRpySyntax.g:439:2: ( (lv_isOldID_1_0= 'OLDID' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalRpySyntax.g:440:1: (lv_isOldID_1_0= 'OLDID' )
                    {
                    // InternalRpySyntax.g:440:1: (lv_isOldID_1_0= 'OLDID' )
                    // InternalRpySyntax.g:441:3: lv_isOldID_1_0= 'OLDID'
                    {
                    lv_isOldID_1_0=(Token)match(input,20,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isOldID_1_0, grammarAccess.getSimpleValueListAccess().getIsOldIDOLDIDKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSimpleValueListRule());
                      	        }
                             		setWithLastConsumed(current, "isOldID", true, "OLDID");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalRpySyntax.g:454:3: ( (lv_isGUID_2_0= 'GUID' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalRpySyntax.g:455:1: (lv_isGUID_2_0= 'GUID' )
                    {
                    // InternalRpySyntax.g:455:1: (lv_isGUID_2_0= 'GUID' )
                    // InternalRpySyntax.g:456:3: lv_isGUID_2_0= 'GUID'
                    {
                    lv_isGUID_2_0=(Token)match(input,21,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isGUID_2_0, grammarAccess.getSimpleValueListAccess().getIsGUIDGUIDKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSimpleValueListRule());
                      	        }
                             		setWithLastConsumed(current, "isGUID", true, "GUID");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalRpySyntax.g:469:3: ( (lv_valueElements_3_0= ruleRpySimpleValueElement ) )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=RULE_ID && LA8_0<=RULE_RPY_REAL)||LA8_0==22) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalRpySyntax.g:470:1: (lv_valueElements_3_0= ruleRpySimpleValueElement )
            	    {
            	    // InternalRpySyntax.g:470:1: (lv_valueElements_3_0= ruleRpySimpleValueElement )
            	    // InternalRpySyntax.g:471:3: lv_valueElements_3_0= ruleRpySimpleValueElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSimpleValueListAccess().getValueElementsRpySimpleValueElementParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_12);
            	    lv_valueElements_3_0=ruleRpySimpleValueElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSimpleValueListRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"valueElements",
            	              		lv_valueElements_3_0, 
            	              		"org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpySimpleValueElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleValueList"


    // $ANTLR start "entryRuleRpySimpleValueElement"
    // InternalRpySyntax.g:495:1: entryRuleRpySimpleValueElement returns [EObject current=null] : iv_ruleRpySimpleValueElement= ruleRpySimpleValueElement EOF ;
    public final EObject entryRuleRpySimpleValueElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRpySimpleValueElement = null;


        try {
            // InternalRpySyntax.g:496:2: (iv_ruleRpySimpleValueElement= ruleRpySimpleValueElement EOF )
            // InternalRpySyntax.g:497:2: iv_ruleRpySimpleValueElement= ruleRpySimpleValueElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRpySimpleValueElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRpySimpleValueElement=ruleRpySimpleValueElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRpySimpleValueElement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRpySimpleValueElement"


    // $ANTLR start "ruleRpySimpleValueElement"
    // InternalRpySyntax.g:504:1: ruleRpySimpleValueElement returns [EObject current=null] : ( () ( (lv_values_1_0= ruleVALUE_TERMINAL ) )* otherlv_2= ';' ) ;
    public final EObject ruleRpySimpleValueElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_values_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRpySyntax.g:507:28: ( ( () ( (lv_values_1_0= ruleVALUE_TERMINAL ) )* otherlv_2= ';' ) )
            // InternalRpySyntax.g:508:1: ( () ( (lv_values_1_0= ruleVALUE_TERMINAL ) )* otherlv_2= ';' )
            {
            // InternalRpySyntax.g:508:1: ( () ( (lv_values_1_0= ruleVALUE_TERMINAL ) )* otherlv_2= ';' )
            // InternalRpySyntax.g:508:2: () ( (lv_values_1_0= ruleVALUE_TERMINAL ) )* otherlv_2= ';'
            {
            // InternalRpySyntax.g:508:2: ()
            // InternalRpySyntax.g:509:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRpySimpleValueElementAccess().getRpySimpleValueElementAction_0(),
                          current);
                  
            }

            }

            // InternalRpySyntax.g:517:2: ( (lv_values_1_0= ruleVALUE_TERMINAL ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=RULE_ID && LA9_0<=RULE_RPY_REAL)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalRpySyntax.g:518:1: (lv_values_1_0= ruleVALUE_TERMINAL )
            	    {
            	    // InternalRpySyntax.g:518:1: (lv_values_1_0= ruleVALUE_TERMINAL )
            	    // InternalRpySyntax.g:519:3: lv_values_1_0= ruleVALUE_TERMINAL
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRpySimpleValueElementAccess().getValuesVALUE_TERMINALParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_values_1_0=ruleVALUE_TERMINAL();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRpySimpleValueElementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"values",
            	              		lv_values_1_0, 
            	              		"org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.VALUE_TERMINAL");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_2=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRpySimpleValueElementAccess().getSemicolonKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRpySimpleValueElement"


    // $ANTLR start "entryRuleVALUE_TERMINAL"
    // InternalRpySyntax.g:547:1: entryRuleVALUE_TERMINAL returns [String current=null] : iv_ruleVALUE_TERMINAL= ruleVALUE_TERMINAL EOF ;
    public final String entryRuleVALUE_TERMINAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVALUE_TERMINAL = null;


        try {
            // InternalRpySyntax.g:548:2: (iv_ruleVALUE_TERMINAL= ruleVALUE_TERMINAL EOF )
            // InternalRpySyntax.g:549:2: iv_ruleVALUE_TERMINAL= ruleVALUE_TERMINAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVALUE_TERMINALRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVALUE_TERMINAL=ruleVALUE_TERMINAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVALUE_TERMINAL.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVALUE_TERMINAL"


    // $ANTLR start "ruleVALUE_TERMINAL"
    // InternalRpySyntax.g:556:1: ruleVALUE_TERMINAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | this_RPY_GUID_2= RULE_RPY_GUID | this_INT_3= RULE_INT | this_RPY_TIME_4= RULE_RPY_TIME | this_RPY_REAL_5= RULE_RPY_REAL ) ;
    public final AntlrDatatypeRuleToken ruleVALUE_TERMINAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;
        Token this_RPY_GUID_2=null;
        Token this_INT_3=null;
        Token this_RPY_TIME_4=null;
        Token this_RPY_REAL_5=null;

         enterRule(); 
            
        try {
            // InternalRpySyntax.g:559:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | this_RPY_GUID_2= RULE_RPY_GUID | this_INT_3= RULE_INT | this_RPY_TIME_4= RULE_RPY_TIME | this_RPY_REAL_5= RULE_RPY_REAL ) )
            // InternalRpySyntax.g:560:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | this_RPY_GUID_2= RULE_RPY_GUID | this_INT_3= RULE_INT | this_RPY_TIME_4= RULE_RPY_TIME | this_RPY_REAL_5= RULE_RPY_REAL )
            {
            // InternalRpySyntax.g:560:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | this_RPY_GUID_2= RULE_RPY_GUID | this_INT_3= RULE_INT | this_RPY_TIME_4= RULE_RPY_TIME | this_RPY_REAL_5= RULE_RPY_REAL )
            int alt10=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt10=1;
                }
                break;
            case RULE_ID:
                {
                alt10=2;
                }
                break;
            case RULE_RPY_GUID:
                {
                alt10=3;
                }
                break;
            case RULE_INT:
                {
                alt10=4;
                }
                break;
            case RULE_RPY_TIME:
                {
                alt10=5;
                }
                break;
            case RULE_RPY_REAL:
                {
                alt10=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalRpySyntax.g:560:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_STRING_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_STRING_0, grammarAccess.getVALUE_TERMINALAccess().getSTRINGTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalRpySyntax.g:568:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_1, grammarAccess.getVALUE_TERMINALAccess().getIDTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalRpySyntax.g:576:10: this_RPY_GUID_2= RULE_RPY_GUID
                    {
                    this_RPY_GUID_2=(Token)match(input,RULE_RPY_GUID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_RPY_GUID_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RPY_GUID_2, grammarAccess.getVALUE_TERMINALAccess().getRPY_GUIDTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalRpySyntax.g:584:10: this_INT_3= RULE_INT
                    {
                    this_INT_3=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_3, grammarAccess.getVALUE_TERMINALAccess().getINTTerminalRuleCall_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalRpySyntax.g:592:10: this_RPY_TIME_4= RULE_RPY_TIME
                    {
                    this_RPY_TIME_4=(Token)match(input,RULE_RPY_TIME,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_RPY_TIME_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RPY_TIME_4, grammarAccess.getVALUE_TERMINALAccess().getRPY_TIMETerminalRuleCall_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalRpySyntax.g:600:10: this_RPY_REAL_5= RULE_RPY_REAL
                    {
                    this_RPY_REAL_5=(Token)match(input,RULE_RPY_REAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_RPY_REAL_5);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RPY_REAL_5, grammarAccess.getVALUE_TERMINALAccess().getRPY_REALTerminalRuleCall_5()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVALUE_TERMINAL"


    // $ANTLR start "entryRuleRpyStringMap"
    // InternalRpySyntax.g:615:1: entryRuleRpyStringMap returns [EObject current=null] : iv_ruleRpyStringMap= ruleRpyStringMap EOF ;
    public final EObject entryRuleRpyStringMap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRpyStringMap = null;


        try {
            // InternalRpySyntax.g:616:2: (iv_ruleRpyStringMap= ruleRpyStringMap EOF )
            // InternalRpySyntax.g:617:2: iv_ruleRpyStringMap= ruleRpyStringMap EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRpyStringMapRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRpyStringMap=ruleRpyStringMap();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRpyStringMap; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRpyStringMap"


    // $ANTLR start "ruleRpyStringMap"
    // InternalRpySyntax.g:624:1: ruleRpyStringMap returns [EObject current=null] : ( (lv_entries_0_0= ruleRpyStringMapEntry ) )+ ;
    public final EObject ruleRpyStringMap() throws RecognitionException {
        EObject current = null;

        EObject lv_entries_0_0 = null;


         enterRule(); 
            
        try {
            // InternalRpySyntax.g:627:28: ( ( (lv_entries_0_0= ruleRpyStringMapEntry ) )+ )
            // InternalRpySyntax.g:628:1: ( (lv_entries_0_0= ruleRpyStringMapEntry ) )+
            {
            // InternalRpySyntax.g:628:1: ( (lv_entries_0_0= ruleRpyStringMapEntry ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_STRING) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalRpySyntax.g:629:1: (lv_entries_0_0= ruleRpyStringMapEntry )
            	    {
            	    // InternalRpySyntax.g:629:1: (lv_entries_0_0= ruleRpyStringMapEntry )
            	    // InternalRpySyntax.g:630:3: lv_entries_0_0= ruleRpyStringMapEntry
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRpyStringMapAccess().getEntriesRpyStringMapEntryParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_entries_0_0=ruleRpyStringMapEntry();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRpyStringMapRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"entries",
            	              		lv_entries_0_0, 
            	              		"org.eclipse.papyrus.migration.rhapsody.parser.RpySyntax.RpyStringMapEntry");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRpyStringMap"


    // $ANTLR start "entryRuleRpyStringMapEntry"
    // InternalRpySyntax.g:654:1: entryRuleRpyStringMapEntry returns [EObject current=null] : iv_ruleRpyStringMapEntry= ruleRpyStringMapEntry EOF ;
    public final EObject entryRuleRpyStringMapEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRpyStringMapEntry = null;


        try {
            // InternalRpySyntax.g:655:2: (iv_ruleRpyStringMapEntry= ruleRpyStringMapEntry EOF )
            // InternalRpySyntax.g:656:2: iv_ruleRpyStringMapEntry= ruleRpyStringMapEntry EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRpyStringMapEntryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRpyStringMapEntry=ruleRpyStringMapEntry();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRpyStringMapEntry; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRpyStringMapEntry"


    // $ANTLR start "ruleRpyStringMapEntry"
    // InternalRpySyntax.g:663:1: ruleRpyStringMapEntry returns [EObject current=null] : ( ( (lv_key_0_0= RULE_STRING ) ) ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleRpyStringMapEntry() throws RecognitionException {
        EObject current = null;

        Token lv_key_0_0=null;
        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // InternalRpySyntax.g:666:28: ( ( ( (lv_key_0_0= RULE_STRING ) ) ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalRpySyntax.g:667:1: ( ( (lv_key_0_0= RULE_STRING ) ) ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalRpySyntax.g:667:1: ( ( (lv_key_0_0= RULE_STRING ) ) ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalRpySyntax.g:667:2: ( (lv_key_0_0= RULE_STRING ) ) ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalRpySyntax.g:667:2: ( (lv_key_0_0= RULE_STRING ) )
            // InternalRpySyntax.g:668:1: (lv_key_0_0= RULE_STRING )
            {
            // InternalRpySyntax.g:668:1: (lv_key_0_0= RULE_STRING )
            // InternalRpySyntax.g:669:3: lv_key_0_0= RULE_STRING
            {
            lv_key_0_0=(Token)match(input,RULE_STRING,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_key_0_0, grammarAccess.getRpyStringMapEntryAccess().getKeySTRINGTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRpyStringMapEntryRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"key",
                      		lv_key_0_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }

            // InternalRpySyntax.g:685:2: ( (lv_value_1_0= RULE_STRING ) )
            // InternalRpySyntax.g:686:1: (lv_value_1_0= RULE_STRING )
            {
            // InternalRpySyntax.g:686:1: (lv_value_1_0= RULE_STRING )
            // InternalRpySyntax.g:687:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getRpyStringMapEntryAccess().getValueSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRpyStringMapEntryRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"org.eclipse.xtext.common.Terminals.STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRpyStringMapEntry"

    // $ANTLR start synpred6_InternalRpySyntax
    public final void synpred6_InternalRpySyntax_fragment() throws RecognitionException {   
        EObject lv_values_0_0 = null;


        // InternalRpySyntax.g:392:1: ( (lv_values_0_0= ruleRpyNode ) )
        // InternalRpySyntax.g:392:1: (lv_values_0_0= ruleRpyNode )
        {
        // InternalRpySyntax.g:392:1: (lv_values_0_0= ruleRpyNode )
        // InternalRpySyntax.g:393:3: lv_values_0_0= ruleRpyNode
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getRpyNodeListAccess().getValuesRpyNodeParserRuleCall_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_values_0_0=ruleRpyNode();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalRpySyntax

    // Delegated rules

    public final boolean synpred6_InternalRpySyntax() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalRpySyntax_fragment(); // can never throw exception
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
    static final String dfa_1s = "\6\uffff";
    static final String dfa_2s = "\4\uffff\1\5\1\uffff";
    static final String dfa_3s = "\1\5\1\uffff\1\5\1\uffff\1\5\1\uffff";
    static final String dfa_4s = "\1\26\1\uffff\1\26\1\uffff\1\26\1\uffff";
    static final String dfa_5s = "\1\uffff\1\1\1\uffff\1\2\1\uffff\1\3";
    static final String dfa_6s = "\6\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\1\2\4\1\5\uffff\1\3\3\uffff\3\1",
            "",
            "\1\1\1\4\4\1\13\uffff\1\1",
            "",
            "\1\1\1\2\4\1\5\uffff\3\5\3\uffff\1\1",
            ""
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
            return "332:1: (this_SimpleValueList_0= ruleSimpleValueList | this_RpyNodeList_1= ruleRpyNodeList | this_RpyStringMap_2= ruleRpyStringMap )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000007107E0L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000007007E0L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000007007E2L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000000004007E0L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000000007107E2L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000040L});

}