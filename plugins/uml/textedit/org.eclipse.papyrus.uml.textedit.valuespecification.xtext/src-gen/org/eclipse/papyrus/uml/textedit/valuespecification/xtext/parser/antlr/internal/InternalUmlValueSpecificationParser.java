package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.services.UmlValueSpecificationGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlValueSpecificationParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_VALUE_SPECIFICATION_ID", "RULE_ID", "RULE_VALUE_SPECIFICATION_INT", "RULE_VALUE_SPECIFICATION_DOUBLE", "RULE_VALUE_SPECIFICATION_STRING", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'='", "'true'", "'false'", "'null'", "'<Undefined>'", "'+'", "'-'", "'#'", "'~'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_VALUE_SPECIFICATION_DOUBLE=7;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=14;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_VALUE_SPECIFICATION_INT=6;
    public static final int RULE_SL_COMMENT=12;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__19=19;
    public static final int RULE_STRING=10;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_VALUE_SPECIFICATION_STRING=8;
    public static final int RULE_INT=9;
    public static final int RULE_VALUE_SPECIFICATION_ID=4;
    public static final int RULE_WS=13;

    // delegates
    // delegators


        public InternalUmlValueSpecificationParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUmlValueSpecificationParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUmlValueSpecificationParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g"; }



     	private UmlValueSpecificationGrammarAccess grammarAccess;
     	
        public InternalUmlValueSpecificationParser(TokenStream input, UmlValueSpecificationGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "AbstractRule";	
       	}
       	
       	@Override
       	protected UmlValueSpecificationGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleAbstractRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:67:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:68:2: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:69:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             newCompositeNode(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule75);
            iv_ruleAbstractRule=ruleAbstractRule();

            state._fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule85); 

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
    // $ANTLR end "entryRuleAbstractRule"


    // $ANTLR start "ruleAbstractRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:76:1: ruleAbstractRule returns [EObject current=null] : ( ( ( (lv_visibility_0_0= ruleVisibilityKind ) )? ( ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) ) otherlv_2= '=' )? ( ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (otherlv_4= RULE_ID ) ) ) ) | ( (lv_undefined_5_0= ruleUndefinedRule ) ) ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_visibility_0_0 = null;

        EObject lv_value_3_1 = null;

        EObject lv_value_3_2 = null;

        EObject lv_value_3_3 = null;

        EObject lv_value_3_4 = null;

        EObject lv_value_3_5 = null;

        EObject lv_undefined_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:79:28: ( ( ( ( (lv_visibility_0_0= ruleVisibilityKind ) )? ( ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) ) otherlv_2= '=' )? ( ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (otherlv_4= RULE_ID ) ) ) ) | ( (lv_undefined_5_0= ruleUndefinedRule ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:80:1: ( ( ( (lv_visibility_0_0= ruleVisibilityKind ) )? ( ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) ) otherlv_2= '=' )? ( ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (otherlv_4= RULE_ID ) ) ) ) | ( (lv_undefined_5_0= ruleUndefinedRule ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:80:1: ( ( ( (lv_visibility_0_0= ruleVisibilityKind ) )? ( ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) ) otherlv_2= '=' )? ( ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (otherlv_4= RULE_ID ) ) ) ) | ( (lv_undefined_5_0= ruleUndefinedRule ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=RULE_VALUE_SPECIFICATION_ID && LA5_0<=RULE_VALUE_SPECIFICATION_STRING)||(LA5_0>=16 && LA5_0<=18)||(LA5_0>=20 && LA5_0<=23)) ) {
                alt5=1;
            }
            else if ( (LA5_0==19) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:80:2: ( ( (lv_visibility_0_0= ruleVisibilityKind ) )? ( ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) ) otherlv_2= '=' )? ( ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (otherlv_4= RULE_ID ) ) ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:80:2: ( ( (lv_visibility_0_0= ruleVisibilityKind ) )? ( ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) ) otherlv_2= '=' )? ( ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (otherlv_4= RULE_ID ) ) ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:80:3: ( (lv_visibility_0_0= ruleVisibilityKind ) )? ( ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) ) otherlv_2= '=' )? ( ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (otherlv_4= RULE_ID ) ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:80:3: ( (lv_visibility_0_0= ruleVisibilityKind ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( ((LA1_0>=20 && LA1_0<=23)) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:81:1: (lv_visibility_0_0= ruleVisibilityKind )
                            {
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:81:1: (lv_visibility_0_0= ruleVisibilityKind )
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:82:3: lv_visibility_0_0= ruleVisibilityKind
                            {
                             
                            	        newCompositeNode(grammarAccess.getAbstractRuleAccess().getVisibilityVisibilityKindParserRuleCall_0_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleVisibilityKind_in_ruleAbstractRule132);
                            lv_visibility_0_0=ruleVisibilityKind();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getAbstractRuleRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"visibility",
                                    		lv_visibility_0_0, 
                                    		"VisibilityKind");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:98:3: ( ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) ) otherlv_2= '=' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==RULE_VALUE_SPECIFICATION_ID) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:98:4: ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) ) otherlv_2= '='
                            {
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:98:4: ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) )
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:99:1: (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID )
                            {
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:99:1: (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID )
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:100:3: lv_name_1_0= RULE_VALUE_SPECIFICATION_ID
                            {
                            lv_name_1_0=(Token)match(input,RULE_VALUE_SPECIFICATION_ID,FOLLOW_RULE_VALUE_SPECIFICATION_ID_in_ruleAbstractRule151); 

                            			newLeafNode(lv_name_1_0, grammarAccess.getAbstractRuleAccess().getNameVALUE_SPECIFICATION_IDTerminalRuleCall_0_1_0_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getAbstractRuleRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"name",
                                    		lv_name_1_0, 
                                    		"VALUE_SPECIFICATION_ID");
                            	    

                            }


                            }

                            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleAbstractRule168); 

                                	newLeafNode(otherlv_2, grammarAccess.getAbstractRuleAccess().getEqualsSignKeyword_0_1_1());
                                

                            }
                            break;

                    }

                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:120:3: ( ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (otherlv_4= RULE_ID ) ) )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=RULE_VALUE_SPECIFICATION_INT && LA4_0<=RULE_VALUE_SPECIFICATION_STRING)||(LA4_0>=16 && LA4_0<=18)) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==RULE_ID) ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:120:4: ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) )
                            {
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:120:4: ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) )
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:121:1: ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) )
                            {
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:121:1: ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) )
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:122:1: (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule )
                            {
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:122:1: (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule )
                            int alt3=5;
                            switch ( input.LA(1) ) {
                            case 16:
                            case 17:
                                {
                                alt3=1;
                                }
                                break;
                            case RULE_VALUE_SPECIFICATION_INT:
                                {
                                alt3=2;
                                }
                                break;
                            case RULE_VALUE_SPECIFICATION_DOUBLE:
                                {
                                alt3=3;
                                }
                                break;
                            case 18:
                                {
                                alt3=4;
                                }
                                break;
                            case RULE_VALUE_SPECIFICATION_STRING:
                                {
                                alt3=5;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 0, input);

                                throw nvae;
                            }

                            switch (alt3) {
                                case 1 :
                                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:123:3: lv_value_3_1= ruleLiteralBooleanRule
                                    {
                                     
                                    	        newCompositeNode(grammarAccess.getAbstractRuleAccess().getValueLiteralBooleanRuleParserRuleCall_0_2_0_0_0()); 
                                    	    
                                    pushFollow(FOLLOW_ruleLiteralBooleanRule_in_ruleAbstractRule194);
                                    lv_value_3_1=ruleLiteralBooleanRule();

                                    state._fsp--;


                                    	        if (current==null) {
                                    	            current = createModelElementForParent(grammarAccess.getAbstractRuleRule());
                                    	        }
                                           		set(
                                           			current, 
                                           			"value",
                                            		lv_value_3_1, 
                                            		"LiteralBooleanRule");
                                    	        afterParserOrEnumRuleCall();
                                    	    

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:138:8: lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule
                                    {
                                     
                                    	        newCompositeNode(grammarAccess.getAbstractRuleAccess().getValueLiteralIntegerOrUnlimitedNaturalRuleParserRuleCall_0_2_0_0_1()); 
                                    	    
                                    pushFollow(FOLLOW_ruleLiteralIntegerOrUnlimitedNaturalRule_in_ruleAbstractRule213);
                                    lv_value_3_2=ruleLiteralIntegerOrUnlimitedNaturalRule();

                                    state._fsp--;


                                    	        if (current==null) {
                                    	            current = createModelElementForParent(grammarAccess.getAbstractRuleRule());
                                    	        }
                                           		set(
                                           			current, 
                                           			"value",
                                            		lv_value_3_2, 
                                            		"LiteralIntegerOrUnlimitedNaturalRule");
                                    	        afterParserOrEnumRuleCall();
                                    	    

                                    }
                                    break;
                                case 3 :
                                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:153:8: lv_value_3_3= ruleLiteralRealRule
                                    {
                                     
                                    	        newCompositeNode(grammarAccess.getAbstractRuleAccess().getValueLiteralRealRuleParserRuleCall_0_2_0_0_2()); 
                                    	    
                                    pushFollow(FOLLOW_ruleLiteralRealRule_in_ruleAbstractRule232);
                                    lv_value_3_3=ruleLiteralRealRule();

                                    state._fsp--;


                                    	        if (current==null) {
                                    	            current = createModelElementForParent(grammarAccess.getAbstractRuleRule());
                                    	        }
                                           		set(
                                           			current, 
                                           			"value",
                                            		lv_value_3_3, 
                                            		"LiteralRealRule");
                                    	        afterParserOrEnumRuleCall();
                                    	    

                                    }
                                    break;
                                case 4 :
                                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:168:8: lv_value_3_4= ruleLiteralNullRule
                                    {
                                     
                                    	        newCompositeNode(grammarAccess.getAbstractRuleAccess().getValueLiteralNullRuleParserRuleCall_0_2_0_0_3()); 
                                    	    
                                    pushFollow(FOLLOW_ruleLiteralNullRule_in_ruleAbstractRule251);
                                    lv_value_3_4=ruleLiteralNullRule();

                                    state._fsp--;


                                    	        if (current==null) {
                                    	            current = createModelElementForParent(grammarAccess.getAbstractRuleRule());
                                    	        }
                                           		set(
                                           			current, 
                                           			"value",
                                            		lv_value_3_4, 
                                            		"LiteralNullRule");
                                    	        afterParserOrEnumRuleCall();
                                    	    

                                    }
                                    break;
                                case 5 :
                                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:183:8: lv_value_3_5= ruleLiteralStringRule
                                    {
                                     
                                    	        newCompositeNode(grammarAccess.getAbstractRuleAccess().getValueLiteralStringRuleParserRuleCall_0_2_0_0_4()); 
                                    	    
                                    pushFollow(FOLLOW_ruleLiteralStringRule_in_ruleAbstractRule270);
                                    lv_value_3_5=ruleLiteralStringRule();

                                    state._fsp--;


                                    	        if (current==null) {
                                    	            current = createModelElementForParent(grammarAccess.getAbstractRuleRule());
                                    	        }
                                           		set(
                                           			current, 
                                           			"value",
                                            		lv_value_3_5, 
                                            		"LiteralStringRule");
                                    	        afterParserOrEnumRuleCall();
                                    	    

                                    }
                                    break;

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:202:6: ( (otherlv_4= RULE_ID ) )
                            {
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:202:6: ( (otherlv_4= RULE_ID ) )
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:203:1: (otherlv_4= RULE_ID )
                            {
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:203:1: (otherlv_4= RULE_ID )
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:204:3: otherlv_4= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getAbstractRuleRule());
                            	        }
                                    
                            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAbstractRule299); 

                            		newLeafNode(otherlv_4, grammarAccess.getAbstractRuleAccess().getInstanceSpecificationInstanceSpecificationCrossReference_0_2_1_0()); 
                            	

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:216:6: ( (lv_undefined_5_0= ruleUndefinedRule ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:216:6: ( (lv_undefined_5_0= ruleUndefinedRule ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:217:1: (lv_undefined_5_0= ruleUndefinedRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:217:1: (lv_undefined_5_0= ruleUndefinedRule )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:218:3: lv_undefined_5_0= ruleUndefinedRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getAbstractRuleAccess().getUndefinedUndefinedRuleParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUndefinedRule_in_ruleAbstractRule328);
                    lv_undefined_5_0=ruleUndefinedRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAbstractRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"undefined",
                            		lv_undefined_5_0, 
                            		"UndefinedRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractRule"


    // $ANTLR start "entryRuleLiteralBooleanRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:242:1: entryRuleLiteralBooleanRule returns [EObject current=null] : iv_ruleLiteralBooleanRule= ruleLiteralBooleanRule EOF ;
    public final EObject entryRuleLiteralBooleanRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralBooleanRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:243:2: (iv_ruleLiteralBooleanRule= ruleLiteralBooleanRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:244:2: iv_ruleLiteralBooleanRule= ruleLiteralBooleanRule EOF
            {
             newCompositeNode(grammarAccess.getLiteralBooleanRuleRule()); 
            pushFollow(FOLLOW_ruleLiteralBooleanRule_in_entryRuleLiteralBooleanRule364);
            iv_ruleLiteralBooleanRule=ruleLiteralBooleanRule();

            state._fsp--;

             current =iv_ruleLiteralBooleanRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralBooleanRule374); 

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
    // $ANTLR end "entryRuleLiteralBooleanRule"


    // $ANTLR start "ruleLiteralBooleanRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:251:1: ruleLiteralBooleanRule returns [EObject current=null] : ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) ) ;
    public final EObject ruleLiteralBooleanRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_1=null;
        Token lv_value_0_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:254:28: ( ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:255:1: ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:255:1: ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:256:1: ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:256:1: ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:257:1: (lv_value_0_1= 'true' | lv_value_0_2= 'false' )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:257:1: (lv_value_0_1= 'true' | lv_value_0_2= 'false' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            else if ( (LA6_0==17) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:258:3: lv_value_0_1= 'true'
                    {
                    lv_value_0_1=(Token)match(input,16,FOLLOW_16_in_ruleLiteralBooleanRule418); 

                            newLeafNode(lv_value_0_1, grammarAccess.getLiteralBooleanRuleAccess().getValueTrueKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLiteralBooleanRuleRule());
                    	        }
                           		setWithLastConsumed(current, "value", lv_value_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:270:8: lv_value_0_2= 'false'
                    {
                    lv_value_0_2=(Token)match(input,17,FOLLOW_17_in_ruleLiteralBooleanRule447); 

                            newLeafNode(lv_value_0_2, grammarAccess.getLiteralBooleanRuleAccess().getValueFalseKeyword_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLiteralBooleanRuleRule());
                    	        }
                           		setWithLastConsumed(current, "value", lv_value_0_2, null);
                    	    

                    }
                    break;

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralBooleanRule"


    // $ANTLR start "entryRuleLiteralIntegerOrUnlimitedNaturalRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:293:1: entryRuleLiteralIntegerOrUnlimitedNaturalRule returns [EObject current=null] : iv_ruleLiteralIntegerOrUnlimitedNaturalRule= ruleLiteralIntegerOrUnlimitedNaturalRule EOF ;
    public final EObject entryRuleLiteralIntegerOrUnlimitedNaturalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralIntegerOrUnlimitedNaturalRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:294:2: (iv_ruleLiteralIntegerOrUnlimitedNaturalRule= ruleLiteralIntegerOrUnlimitedNaturalRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:295:2: iv_ruleLiteralIntegerOrUnlimitedNaturalRule= ruleLiteralIntegerOrUnlimitedNaturalRule EOF
            {
             newCompositeNode(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleRule()); 
            pushFollow(FOLLOW_ruleLiteralIntegerOrUnlimitedNaturalRule_in_entryRuleLiteralIntegerOrUnlimitedNaturalRule498);
            iv_ruleLiteralIntegerOrUnlimitedNaturalRule=ruleLiteralIntegerOrUnlimitedNaturalRule();

            state._fsp--;

             current =iv_ruleLiteralIntegerOrUnlimitedNaturalRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralIntegerOrUnlimitedNaturalRule508); 

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
    // $ANTLR end "entryRuleLiteralIntegerOrUnlimitedNaturalRule"


    // $ANTLR start "ruleLiteralIntegerOrUnlimitedNaturalRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:302:1: ruleLiteralIntegerOrUnlimitedNaturalRule returns [EObject current=null] : ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_INT ) ) ;
    public final EObject ruleLiteralIntegerOrUnlimitedNaturalRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:305:28: ( ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_INT ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:306:1: ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_INT ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:306:1: ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_INT ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:307:1: (lv_value_0_0= RULE_VALUE_SPECIFICATION_INT )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:307:1: (lv_value_0_0= RULE_VALUE_SPECIFICATION_INT )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:308:3: lv_value_0_0= RULE_VALUE_SPECIFICATION_INT
            {
            lv_value_0_0=(Token)match(input,RULE_VALUE_SPECIFICATION_INT,FOLLOW_RULE_VALUE_SPECIFICATION_INT_in_ruleLiteralIntegerOrUnlimitedNaturalRule549); 

            			newLeafNode(lv_value_0_0, grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getValueVALUE_SPECIFICATION_INTTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"VALUE_SPECIFICATION_INT");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralIntegerOrUnlimitedNaturalRule"


    // $ANTLR start "entryRuleLiteralRealRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:332:1: entryRuleLiteralRealRule returns [EObject current=null] : iv_ruleLiteralRealRule= ruleLiteralRealRule EOF ;
    public final EObject entryRuleLiteralRealRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRealRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:333:2: (iv_ruleLiteralRealRule= ruleLiteralRealRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:334:2: iv_ruleLiteralRealRule= ruleLiteralRealRule EOF
            {
             newCompositeNode(grammarAccess.getLiteralRealRuleRule()); 
            pushFollow(FOLLOW_ruleLiteralRealRule_in_entryRuleLiteralRealRule589);
            iv_ruleLiteralRealRule=ruleLiteralRealRule();

            state._fsp--;

             current =iv_ruleLiteralRealRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralRealRule599); 

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
    // $ANTLR end "entryRuleLiteralRealRule"


    // $ANTLR start "ruleLiteralRealRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:341:1: ruleLiteralRealRule returns [EObject current=null] : ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE ) ) ;
    public final EObject ruleLiteralRealRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:344:28: ( ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:345:1: ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:345:1: ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:346:1: (lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:346:1: (lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:347:3: lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE
            {
            lv_value_0_0=(Token)match(input,RULE_VALUE_SPECIFICATION_DOUBLE,FOLLOW_RULE_VALUE_SPECIFICATION_DOUBLE_in_ruleLiteralRealRule640); 

            			newLeafNode(lv_value_0_0, grammarAccess.getLiteralRealRuleAccess().getValueVALUE_SPECIFICATION_DOUBLETerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLiteralRealRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"VALUE_SPECIFICATION_DOUBLE");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralRealRule"


    // $ANTLR start "entryRuleLiteralNullRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:371:1: entryRuleLiteralNullRule returns [EObject current=null] : iv_ruleLiteralNullRule= ruleLiteralNullRule EOF ;
    public final EObject entryRuleLiteralNullRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralNullRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:372:2: (iv_ruleLiteralNullRule= ruleLiteralNullRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:373:2: iv_ruleLiteralNullRule= ruleLiteralNullRule EOF
            {
             newCompositeNode(grammarAccess.getLiteralNullRuleRule()); 
            pushFollow(FOLLOW_ruleLiteralNullRule_in_entryRuleLiteralNullRule680);
            iv_ruleLiteralNullRule=ruleLiteralNullRule();

            state._fsp--;

             current =iv_ruleLiteralNullRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralNullRule690); 

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
    // $ANTLR end "entryRuleLiteralNullRule"


    // $ANTLR start "ruleLiteralNullRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:380:1: ruleLiteralNullRule returns [EObject current=null] : ( (lv_value_0_0= 'null' ) ) ;
    public final EObject ruleLiteralNullRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:383:28: ( ( (lv_value_0_0= 'null' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:384:1: ( (lv_value_0_0= 'null' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:384:1: ( (lv_value_0_0= 'null' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:385:1: (lv_value_0_0= 'null' )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:385:1: (lv_value_0_0= 'null' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:386:3: lv_value_0_0= 'null'
            {
            lv_value_0_0=(Token)match(input,18,FOLLOW_18_in_ruleLiteralNullRule732); 

                    newLeafNode(lv_value_0_0, grammarAccess.getLiteralNullRuleAccess().getValueNullKeyword_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLiteralNullRuleRule());
            	        }
                   		setWithLastConsumed(current, "value", lv_value_0_0, "null");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralNullRule"


    // $ANTLR start "entryRuleLiteralStringRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:407:1: entryRuleLiteralStringRule returns [EObject current=null] : iv_ruleLiteralStringRule= ruleLiteralStringRule EOF ;
    public final EObject entryRuleLiteralStringRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralStringRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:408:2: (iv_ruleLiteralStringRule= ruleLiteralStringRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:409:2: iv_ruleLiteralStringRule= ruleLiteralStringRule EOF
            {
             newCompositeNode(grammarAccess.getLiteralStringRuleRule()); 
            pushFollow(FOLLOW_ruleLiteralStringRule_in_entryRuleLiteralStringRule780);
            iv_ruleLiteralStringRule=ruleLiteralStringRule();

            state._fsp--;

             current =iv_ruleLiteralStringRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralStringRule790); 

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
    // $ANTLR end "entryRuleLiteralStringRule"


    // $ANTLR start "ruleLiteralStringRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:416:1: ruleLiteralStringRule returns [EObject current=null] : ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_STRING ) ) ;
    public final EObject ruleLiteralStringRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:419:28: ( ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_STRING ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:420:1: ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_STRING ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:420:1: ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_STRING ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:421:1: (lv_value_0_0= RULE_VALUE_SPECIFICATION_STRING )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:421:1: (lv_value_0_0= RULE_VALUE_SPECIFICATION_STRING )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:422:3: lv_value_0_0= RULE_VALUE_SPECIFICATION_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_VALUE_SPECIFICATION_STRING,FOLLOW_RULE_VALUE_SPECIFICATION_STRING_in_ruleLiteralStringRule831); 

            			newLeafNode(lv_value_0_0, grammarAccess.getLiteralStringRuleAccess().getValueVALUE_SPECIFICATION_STRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLiteralStringRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"VALUE_SPECIFICATION_STRING");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralStringRule"


    // $ANTLR start "entryRuleUndefinedRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:446:1: entryRuleUndefinedRule returns [EObject current=null] : iv_ruleUndefinedRule= ruleUndefinedRule EOF ;
    public final EObject entryRuleUndefinedRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUndefinedRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:447:2: (iv_ruleUndefinedRule= ruleUndefinedRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:448:2: iv_ruleUndefinedRule= ruleUndefinedRule EOF
            {
             newCompositeNode(grammarAccess.getUndefinedRuleRule()); 
            pushFollow(FOLLOW_ruleUndefinedRule_in_entryRuleUndefinedRule871);
            iv_ruleUndefinedRule=ruleUndefinedRule();

            state._fsp--;

             current =iv_ruleUndefinedRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUndefinedRule881); 

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
    // $ANTLR end "entryRuleUndefinedRule"


    // $ANTLR start "ruleUndefinedRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:455:1: ruleUndefinedRule returns [EObject current=null] : ( (lv_value_0_0= '<Undefined>' ) ) ;
    public final EObject ruleUndefinedRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:458:28: ( ( (lv_value_0_0= '<Undefined>' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:459:1: ( (lv_value_0_0= '<Undefined>' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:459:1: ( (lv_value_0_0= '<Undefined>' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:460:1: (lv_value_0_0= '<Undefined>' )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:460:1: (lv_value_0_0= '<Undefined>' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:461:3: lv_value_0_0= '<Undefined>'
            {
            lv_value_0_0=(Token)match(input,19,FOLLOW_19_in_ruleUndefinedRule923); 

                    newLeafNode(lv_value_0_0, grammarAccess.getUndefinedRuleAccess().getValueUndefinedKeyword_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUndefinedRuleRule());
            	        }
                   		setWithLastConsumed(current, "value", lv_value_0_0, "<Undefined>");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUndefinedRule"


    // $ANTLR start "entryRuleVisibilityKind"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:482:1: entryRuleVisibilityKind returns [EObject current=null] : iv_ruleVisibilityKind= ruleVisibilityKind EOF ;
    public final EObject entryRuleVisibilityKind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibilityKind = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:483:2: (iv_ruleVisibilityKind= ruleVisibilityKind EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:484:2: iv_ruleVisibilityKind= ruleVisibilityKind EOF
            {
             newCompositeNode(grammarAccess.getVisibilityKindRule()); 
            pushFollow(FOLLOW_ruleVisibilityKind_in_entryRuleVisibilityKind971);
            iv_ruleVisibilityKind=ruleVisibilityKind();

            state._fsp--;

             current =iv_ruleVisibilityKind; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVisibilityKind981); 

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
    // $ANTLR end "entryRuleVisibilityKind"


    // $ANTLR start "ruleVisibilityKind"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:491:1: ruleVisibilityKind returns [EObject current=null] : ( ( (lv_public_0_0= '+' ) ) | ( (lv_private_1_0= '-' ) ) | ( (lv_protected_2_0= '#' ) ) | ( (lv_package_3_0= '~' ) ) ) ;
    public final EObject ruleVisibilityKind() throws RecognitionException {
        EObject current = null;

        Token lv_public_0_0=null;
        Token lv_private_1_0=null;
        Token lv_protected_2_0=null;
        Token lv_package_3_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:494:28: ( ( ( (lv_public_0_0= '+' ) ) | ( (lv_private_1_0= '-' ) ) | ( (lv_protected_2_0= '#' ) ) | ( (lv_package_3_0= '~' ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:495:1: ( ( (lv_public_0_0= '+' ) ) | ( (lv_private_1_0= '-' ) ) | ( (lv_protected_2_0= '#' ) ) | ( (lv_package_3_0= '~' ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:495:1: ( ( (lv_public_0_0= '+' ) ) | ( (lv_private_1_0= '-' ) ) | ( (lv_protected_2_0= '#' ) ) | ( (lv_package_3_0= '~' ) ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt7=1;
                }
                break;
            case 21:
                {
                alt7=2;
                }
                break;
            case 22:
                {
                alt7=3;
                }
                break;
            case 23:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:495:2: ( (lv_public_0_0= '+' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:495:2: ( (lv_public_0_0= '+' ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:496:1: (lv_public_0_0= '+' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:496:1: (lv_public_0_0= '+' )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:497:3: lv_public_0_0= '+'
                    {
                    lv_public_0_0=(Token)match(input,20,FOLLOW_20_in_ruleVisibilityKind1024); 

                            newLeafNode(lv_public_0_0, grammarAccess.getVisibilityKindAccess().getPublicPlusSignKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVisibilityKindRule());
                    	        }
                           		setWithLastConsumed(current, "public", lv_public_0_0, "+");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:511:6: ( (lv_private_1_0= '-' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:511:6: ( (lv_private_1_0= '-' ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:512:1: (lv_private_1_0= '-' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:512:1: (lv_private_1_0= '-' )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:513:3: lv_private_1_0= '-'
                    {
                    lv_private_1_0=(Token)match(input,21,FOLLOW_21_in_ruleVisibilityKind1061); 

                            newLeafNode(lv_private_1_0, grammarAccess.getVisibilityKindAccess().getPrivateHyphenMinusKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVisibilityKindRule());
                    	        }
                           		setWithLastConsumed(current, "private", lv_private_1_0, "-");
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:527:6: ( (lv_protected_2_0= '#' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:527:6: ( (lv_protected_2_0= '#' ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:528:1: (lv_protected_2_0= '#' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:528:1: (lv_protected_2_0= '#' )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:529:3: lv_protected_2_0= '#'
                    {
                    lv_protected_2_0=(Token)match(input,22,FOLLOW_22_in_ruleVisibilityKind1098); 

                            newLeafNode(lv_protected_2_0, grammarAccess.getVisibilityKindAccess().getProtectedNumberSignKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVisibilityKindRule());
                    	        }
                           		setWithLastConsumed(current, "protected", lv_protected_2_0, "#");
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:543:6: ( (lv_package_3_0= '~' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:543:6: ( (lv_package_3_0= '~' ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:544:1: (lv_package_3_0= '~' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:544:1: (lv_package_3_0= '~' )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:545:3: lv_package_3_0= '~'
                    {
                    lv_package_3_0=(Token)match(input,23,FOLLOW_23_in_ruleVisibilityKind1135); 

                            newLeafNode(lv_package_3_0, grammarAccess.getVisibilityKindAccess().getPackageTildeKeyword_3_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVisibilityKindRule());
                    	        }
                           		setWithLastConsumed(current, "package", lv_package_3_0, "~");
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVisibilityKind"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_ruleAbstractRule132 = new BitSet(new long[]{0x00000000000701F0L});
    public static final BitSet FOLLOW_RULE_VALUE_SPECIFICATION_ID_in_ruleAbstractRule151 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAbstractRule168 = new BitSet(new long[]{0x00000000000701E0L});
    public static final BitSet FOLLOW_ruleLiteralBooleanRule_in_ruleAbstractRule194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralIntegerOrUnlimitedNaturalRule_in_ruleAbstractRule213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralRealRule_in_ruleAbstractRule232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralNullRule_in_ruleAbstractRule251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralStringRule_in_ruleAbstractRule270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAbstractRule299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUndefinedRule_in_ruleAbstractRule328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralBooleanRule_in_entryRuleLiteralBooleanRule364 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralBooleanRule374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleLiteralBooleanRule418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleLiteralBooleanRule447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralIntegerOrUnlimitedNaturalRule_in_entryRuleLiteralIntegerOrUnlimitedNaturalRule498 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralIntegerOrUnlimitedNaturalRule508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VALUE_SPECIFICATION_INT_in_ruleLiteralIntegerOrUnlimitedNaturalRule549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralRealRule_in_entryRuleLiteralRealRule589 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralRealRule599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VALUE_SPECIFICATION_DOUBLE_in_ruleLiteralRealRule640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralNullRule_in_entryRuleLiteralNullRule680 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralNullRule690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleLiteralNullRule732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralStringRule_in_entryRuleLiteralStringRule780 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralStringRule790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VALUE_SPECIFICATION_STRING_in_ruleLiteralStringRule831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUndefinedRule_in_entryRuleUndefinedRule871 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUndefinedRule881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleUndefinedRule923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_entryRuleVisibilityKind971 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVisibilityKind981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleVisibilityKind1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleVisibilityKind1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleVisibilityKind1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleVisibilityKind1135 = new BitSet(new long[]{0x0000000000000002L});

}