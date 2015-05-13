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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_VALUE_SPECIFICATION_ID", "RULE_ID", "RULE_INT", "RULE_VALUE_SPECIFICATION_NEGATIVE_INT", "RULE_VALUE_SPECIFICATION_DOUBLE", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'*'", "'null'", "'<Undefined>'", "'+'", "'-'", "'#'", "'~'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_VALUE_SPECIFICATION_DOUBLE=8;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=13;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=11;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__19=19;
    public static final int RULE_STRING=9;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int RULE_INT=6;
    public static final int RULE_VALUE_SPECIFICATION_ID=4;
    public static final int RULE_WS=12;
    public static final int RULE_VALUE_SPECIFICATION_NEGATIVE_INT=7;

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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:76:1: ruleAbstractRule returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibilityKind ) )? ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) )? ( ( (otherlv_2= RULE_ID ) ) | ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (lv_undefined_4_0= ruleUndefinedRule ) ) ) ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_visibility_0_0 = null;

        EObject lv_value_3_1 = null;

        EObject lv_value_3_2 = null;

        EObject lv_value_3_3 = null;

        EObject lv_value_3_4 = null;

        EObject lv_value_3_5 = null;

        EObject lv_undefined_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:79:28: ( ( ( (lv_visibility_0_0= ruleVisibilityKind ) )? ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) )? ( ( (otherlv_2= RULE_ID ) ) | ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (lv_undefined_4_0= ruleUndefinedRule ) ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:80:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) )? ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) )? ( ( (otherlv_2= RULE_ID ) ) | ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (lv_undefined_4_0= ruleUndefinedRule ) ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:80:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) )? ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) )? ( ( (otherlv_2= RULE_ID ) ) | ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (lv_undefined_4_0= ruleUndefinedRule ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:80:2: ( (lv_visibility_0_0= ruleVisibilityKind ) )? ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) )? ( ( (otherlv_2= RULE_ID ) ) | ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (lv_undefined_4_0= ruleUndefinedRule ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:80:2: ( (lv_visibility_0_0= ruleVisibilityKind ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=19 && LA1_0<=22)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:81:1: (lv_visibility_0_0= ruleVisibilityKind )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:81:1: (lv_visibility_0_0= ruleVisibilityKind )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:82:3: lv_visibility_0_0= ruleVisibilityKind
                    {
                     
                    	        newCompositeNode(grammarAccess.getAbstractRuleAccess().getVisibilityVisibilityKindParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVisibilityKind_in_ruleAbstractRule131);
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

            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:98:3: ( (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_VALUE_SPECIFICATION_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:99:1: (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:99:1: (lv_name_1_0= RULE_VALUE_SPECIFICATION_ID )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:100:3: lv_name_1_0= RULE_VALUE_SPECIFICATION_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_VALUE_SPECIFICATION_ID,FOLLOW_RULE_VALUE_SPECIFICATION_ID_in_ruleAbstractRule149); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getAbstractRuleAccess().getNameVALUE_SPECIFICATION_IDTerminalRuleCall_1_0()); 
                    		

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
                    break;

            }

            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:116:3: ( ( (otherlv_2= RULE_ID ) ) | ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) ) | ( (lv_undefined_4_0= ruleUndefinedRule ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt4=1;
                }
                break;
            case RULE_INT:
            case RULE_VALUE_SPECIFICATION_NEGATIVE_INT:
            case RULE_VALUE_SPECIFICATION_DOUBLE:
            case RULE_STRING:
            case 14:
            case 15:
            case 16:
            case 17:
                {
                alt4=2;
                }
                break;
            case 18:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:116:4: ( (otherlv_2= RULE_ID ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:116:4: ( (otherlv_2= RULE_ID ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:117:1: (otherlv_2= RULE_ID )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:117:1: (otherlv_2= RULE_ID )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:118:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getAbstractRuleRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAbstractRule176); 

                    		newLeafNode(otherlv_2, grammarAccess.getAbstractRuleAccess().getInstanceSpecificationInstanceSpecificationCrossReference_2_0_0()); 
                    	

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:130:6: ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:130:6: ( ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:131:1: ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:131:1: ( (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:132:1: (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:132:1: (lv_value_3_1= ruleLiteralBooleanRule | lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule | lv_value_3_3= ruleLiteralRealRule | lv_value_3_4= ruleLiteralNullRule | lv_value_3_5= ruleLiteralStringRule )
                    int alt3=5;
                    switch ( input.LA(1) ) {
                    case 14:
                    case 15:
                        {
                        alt3=1;
                        }
                        break;
                    case RULE_INT:
                    case RULE_VALUE_SPECIFICATION_NEGATIVE_INT:
                    case 16:
                        {
                        alt3=2;
                        }
                        break;
                    case RULE_VALUE_SPECIFICATION_DOUBLE:
                        {
                        alt3=3;
                        }
                        break;
                    case 17:
                        {
                        alt3=4;
                        }
                        break;
                    case RULE_STRING:
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
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:133:3: lv_value_3_1= ruleLiteralBooleanRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getAbstractRuleAccess().getValueLiteralBooleanRuleParserRuleCall_2_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleLiteralBooleanRule_in_ruleAbstractRule205);
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
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:148:8: lv_value_3_2= ruleLiteralIntegerOrUnlimitedNaturalRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getAbstractRuleAccess().getValueLiteralIntegerOrUnlimitedNaturalRuleParserRuleCall_2_1_0_1()); 
                            	    
                            pushFollow(FOLLOW_ruleLiteralIntegerOrUnlimitedNaturalRule_in_ruleAbstractRule224);
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
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:163:8: lv_value_3_3= ruleLiteralRealRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getAbstractRuleAccess().getValueLiteralRealRuleParserRuleCall_2_1_0_2()); 
                            	    
                            pushFollow(FOLLOW_ruleLiteralRealRule_in_ruleAbstractRule243);
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
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:178:8: lv_value_3_4= ruleLiteralNullRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getAbstractRuleAccess().getValueLiteralNullRuleParserRuleCall_2_1_0_3()); 
                            	    
                            pushFollow(FOLLOW_ruleLiteralNullRule_in_ruleAbstractRule262);
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
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:193:8: lv_value_3_5= ruleLiteralStringRule
                            {
                             
                            	        newCompositeNode(grammarAccess.getAbstractRuleAccess().getValueLiteralStringRuleParserRuleCall_2_1_0_4()); 
                            	    
                            pushFollow(FOLLOW_ruleLiteralStringRule_in_ruleAbstractRule281);
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
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:212:6: ( (lv_undefined_4_0= ruleUndefinedRule ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:212:6: ( (lv_undefined_4_0= ruleUndefinedRule ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:213:1: (lv_undefined_4_0= ruleUndefinedRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:213:1: (lv_undefined_4_0= ruleUndefinedRule )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:214:3: lv_undefined_4_0= ruleUndefinedRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getAbstractRuleAccess().getUndefinedUndefinedRuleParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUndefinedRule_in_ruleAbstractRule311);
                    lv_undefined_4_0=ruleUndefinedRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAbstractRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"undefined",
                            		lv_undefined_4_0, 
                            		"UndefinedRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleAbstractRule"


    // $ANTLR start "entryRuleLiteralBooleanRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:238:1: entryRuleLiteralBooleanRule returns [EObject current=null] : iv_ruleLiteralBooleanRule= ruleLiteralBooleanRule EOF ;
    public final EObject entryRuleLiteralBooleanRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralBooleanRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:239:2: (iv_ruleLiteralBooleanRule= ruleLiteralBooleanRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:240:2: iv_ruleLiteralBooleanRule= ruleLiteralBooleanRule EOF
            {
             newCompositeNode(grammarAccess.getLiteralBooleanRuleRule()); 
            pushFollow(FOLLOW_ruleLiteralBooleanRule_in_entryRuleLiteralBooleanRule348);
            iv_ruleLiteralBooleanRule=ruleLiteralBooleanRule();

            state._fsp--;

             current =iv_ruleLiteralBooleanRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralBooleanRule358); 

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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:247:1: ruleLiteralBooleanRule returns [EObject current=null] : ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) ) ;
    public final EObject ruleLiteralBooleanRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_1=null;
        Token lv_value_0_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:250:28: ( ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:251:1: ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:251:1: ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:252:1: ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:252:1: ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:253:1: (lv_value_0_1= 'true' | lv_value_0_2= 'false' )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:253:1: (lv_value_0_1= 'true' | lv_value_0_2= 'false' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            else if ( (LA5_0==15) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:254:3: lv_value_0_1= 'true'
                    {
                    lv_value_0_1=(Token)match(input,14,FOLLOW_14_in_ruleLiteralBooleanRule402); 

                            newLeafNode(lv_value_0_1, grammarAccess.getLiteralBooleanRuleAccess().getValueTrueKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLiteralBooleanRuleRule());
                    	        }
                           		setWithLastConsumed(current, "value", lv_value_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:266:8: lv_value_0_2= 'false'
                    {
                    lv_value_0_2=(Token)match(input,15,FOLLOW_15_in_ruleLiteralBooleanRule431); 

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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:289:1: entryRuleLiteralIntegerOrUnlimitedNaturalRule returns [EObject current=null] : iv_ruleLiteralIntegerOrUnlimitedNaturalRule= ruleLiteralIntegerOrUnlimitedNaturalRule EOF ;
    public final EObject entryRuleLiteralIntegerOrUnlimitedNaturalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralIntegerOrUnlimitedNaturalRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:290:2: (iv_ruleLiteralIntegerOrUnlimitedNaturalRule= ruleLiteralIntegerOrUnlimitedNaturalRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:291:2: iv_ruleLiteralIntegerOrUnlimitedNaturalRule= ruleLiteralIntegerOrUnlimitedNaturalRule EOF
            {
             newCompositeNode(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleRule()); 
            pushFollow(FOLLOW_ruleLiteralIntegerOrUnlimitedNaturalRule_in_entryRuleLiteralIntegerOrUnlimitedNaturalRule482);
            iv_ruleLiteralIntegerOrUnlimitedNaturalRule=ruleLiteralIntegerOrUnlimitedNaturalRule();

            state._fsp--;

             current =iv_ruleLiteralIntegerOrUnlimitedNaturalRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralIntegerOrUnlimitedNaturalRule492); 

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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:298:1: ruleLiteralIntegerOrUnlimitedNaturalRule returns [EObject current=null] : ( ( ( (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT ) ) ) | ( (lv_unlimited_1_0= '*' ) ) ) ;
    public final EObject ruleLiteralIntegerOrUnlimitedNaturalRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_1=null;
        Token lv_value_0_2=null;
        Token lv_unlimited_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:301:28: ( ( ( ( (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT ) ) ) | ( (lv_unlimited_1_0= '*' ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:302:1: ( ( ( (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT ) ) ) | ( (lv_unlimited_1_0= '*' ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:302:1: ( ( ( (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT ) ) ) | ( (lv_unlimited_1_0= '*' ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_INT && LA7_0<=RULE_VALUE_SPECIFICATION_NEGATIVE_INT)) ) {
                alt7=1;
            }
            else if ( (LA7_0==16) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:302:2: ( ( (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT ) ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:302:2: ( ( (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT ) ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:303:1: ( (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:303:1: ( (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:304:1: (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:304:1: (lv_value_0_1= RULE_INT | lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==RULE_INT) ) {
                        alt6=1;
                    }
                    else if ( (LA6_0==RULE_VALUE_SPECIFICATION_NEGATIVE_INT) ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:305:3: lv_value_0_1= RULE_INT
                            {
                            lv_value_0_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLiteralIntegerOrUnlimitedNaturalRule536); 

                            			newLeafNode(lv_value_0_1, grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getValueINTTerminalRuleCall_0_0_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"value",
                                    		lv_value_0_1, 
                                    		"INT");
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:320:8: lv_value_0_2= RULE_VALUE_SPECIFICATION_NEGATIVE_INT
                            {
                            lv_value_0_2=(Token)match(input,RULE_VALUE_SPECIFICATION_NEGATIVE_INT,FOLLOW_RULE_VALUE_SPECIFICATION_NEGATIVE_INT_in_ruleLiteralIntegerOrUnlimitedNaturalRule556); 

                            			newLeafNode(lv_value_0_2, grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getValueVALUE_SPECIFICATION_NEGATIVE_INTTerminalRuleCall_0_0_1()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"value",
                                    		lv_value_0_2, 
                                    		"VALUE_SPECIFICATION_NEGATIVE_INT");
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:339:6: ( (lv_unlimited_1_0= '*' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:339:6: ( (lv_unlimited_1_0= '*' ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:340:1: (lv_unlimited_1_0= '*' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:340:1: (lv_unlimited_1_0= '*' )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:341:3: lv_unlimited_1_0= '*'
                    {
                    lv_unlimited_1_0=(Token)match(input,16,FOLLOW_16_in_ruleLiteralIntegerOrUnlimitedNaturalRule588); 

                            newLeafNode(lv_unlimited_1_0, grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getUnlimitedAsteriskKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleRule());
                    	        }
                           		setWithLastConsumed(current, "unlimited", lv_unlimited_1_0, "*");
                    	    

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
    // $ANTLR end "ruleLiteralIntegerOrUnlimitedNaturalRule"


    // $ANTLR start "entryRuleLiteralRealRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:362:1: entryRuleLiteralRealRule returns [EObject current=null] : iv_ruleLiteralRealRule= ruleLiteralRealRule EOF ;
    public final EObject entryRuleLiteralRealRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRealRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:363:2: (iv_ruleLiteralRealRule= ruleLiteralRealRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:364:2: iv_ruleLiteralRealRule= ruleLiteralRealRule EOF
            {
             newCompositeNode(grammarAccess.getLiteralRealRuleRule()); 
            pushFollow(FOLLOW_ruleLiteralRealRule_in_entryRuleLiteralRealRule637);
            iv_ruleLiteralRealRule=ruleLiteralRealRule();

            state._fsp--;

             current =iv_ruleLiteralRealRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralRealRule647); 

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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:371:1: ruleLiteralRealRule returns [EObject current=null] : ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE ) ) ;
    public final EObject ruleLiteralRealRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:374:28: ( ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:375:1: ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:375:1: ( (lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:376:1: (lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:376:1: (lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:377:3: lv_value_0_0= RULE_VALUE_SPECIFICATION_DOUBLE
            {
            lv_value_0_0=(Token)match(input,RULE_VALUE_SPECIFICATION_DOUBLE,FOLLOW_RULE_VALUE_SPECIFICATION_DOUBLE_in_ruleLiteralRealRule688); 

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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:401:1: entryRuleLiteralNullRule returns [EObject current=null] : iv_ruleLiteralNullRule= ruleLiteralNullRule EOF ;
    public final EObject entryRuleLiteralNullRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralNullRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:402:2: (iv_ruleLiteralNullRule= ruleLiteralNullRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:403:2: iv_ruleLiteralNullRule= ruleLiteralNullRule EOF
            {
             newCompositeNode(grammarAccess.getLiteralNullRuleRule()); 
            pushFollow(FOLLOW_ruleLiteralNullRule_in_entryRuleLiteralNullRule728);
            iv_ruleLiteralNullRule=ruleLiteralNullRule();

            state._fsp--;

             current =iv_ruleLiteralNullRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralNullRule738); 

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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:410:1: ruleLiteralNullRule returns [EObject current=null] : ( (lv_value_0_0= 'null' ) ) ;
    public final EObject ruleLiteralNullRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:413:28: ( ( (lv_value_0_0= 'null' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:414:1: ( (lv_value_0_0= 'null' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:414:1: ( (lv_value_0_0= 'null' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:415:1: (lv_value_0_0= 'null' )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:415:1: (lv_value_0_0= 'null' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:416:3: lv_value_0_0= 'null'
            {
            lv_value_0_0=(Token)match(input,17,FOLLOW_17_in_ruleLiteralNullRule780); 

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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:437:1: entryRuleLiteralStringRule returns [EObject current=null] : iv_ruleLiteralStringRule= ruleLiteralStringRule EOF ;
    public final EObject entryRuleLiteralStringRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralStringRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:438:2: (iv_ruleLiteralStringRule= ruleLiteralStringRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:439:2: iv_ruleLiteralStringRule= ruleLiteralStringRule EOF
            {
             newCompositeNode(grammarAccess.getLiteralStringRuleRule()); 
            pushFollow(FOLLOW_ruleLiteralStringRule_in_entryRuleLiteralStringRule828);
            iv_ruleLiteralStringRule=ruleLiteralStringRule();

            state._fsp--;

             current =iv_ruleLiteralStringRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralStringRule838); 

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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:446:1: ruleLiteralStringRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleLiteralStringRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:449:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:450:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:450:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:451:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:451:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:452:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLiteralStringRule879); 

            			newLeafNode(lv_value_0_0, grammarAccess.getLiteralStringRuleAccess().getValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLiteralStringRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"STRING");
            	    

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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:476:1: entryRuleUndefinedRule returns [EObject current=null] : iv_ruleUndefinedRule= ruleUndefinedRule EOF ;
    public final EObject entryRuleUndefinedRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUndefinedRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:477:2: (iv_ruleUndefinedRule= ruleUndefinedRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:478:2: iv_ruleUndefinedRule= ruleUndefinedRule EOF
            {
             newCompositeNode(grammarAccess.getUndefinedRuleRule()); 
            pushFollow(FOLLOW_ruleUndefinedRule_in_entryRuleUndefinedRule919);
            iv_ruleUndefinedRule=ruleUndefinedRule();

            state._fsp--;

             current =iv_ruleUndefinedRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUndefinedRule929); 

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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:485:1: ruleUndefinedRule returns [EObject current=null] : ( (lv_value_0_0= '<Undefined>' ) ) ;
    public final EObject ruleUndefinedRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:488:28: ( ( (lv_value_0_0= '<Undefined>' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:489:1: ( (lv_value_0_0= '<Undefined>' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:489:1: ( (lv_value_0_0= '<Undefined>' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:490:1: (lv_value_0_0= '<Undefined>' )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:490:1: (lv_value_0_0= '<Undefined>' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:491:3: lv_value_0_0= '<Undefined>'
            {
            lv_value_0_0=(Token)match(input,18,FOLLOW_18_in_ruleUndefinedRule971); 

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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:512:1: entryRuleVisibilityKind returns [EObject current=null] : iv_ruleVisibilityKind= ruleVisibilityKind EOF ;
    public final EObject entryRuleVisibilityKind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibilityKind = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:513:2: (iv_ruleVisibilityKind= ruleVisibilityKind EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:514:2: iv_ruleVisibilityKind= ruleVisibilityKind EOF
            {
             newCompositeNode(grammarAccess.getVisibilityKindRule()); 
            pushFollow(FOLLOW_ruleVisibilityKind_in_entryRuleVisibilityKind1019);
            iv_ruleVisibilityKind=ruleVisibilityKind();

            state._fsp--;

             current =iv_ruleVisibilityKind; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVisibilityKind1029); 

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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:521:1: ruleVisibilityKind returns [EObject current=null] : ( ( (lv_public_0_0= '+' ) ) | ( (lv_private_1_0= '-' ) ) | ( (lv_protected_2_0= '#' ) ) | ( (lv_package_3_0= '~' ) ) ) ;
    public final EObject ruleVisibilityKind() throws RecognitionException {
        EObject current = null;

        Token lv_public_0_0=null;
        Token lv_private_1_0=null;
        Token lv_protected_2_0=null;
        Token lv_package_3_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:524:28: ( ( ( (lv_public_0_0= '+' ) ) | ( (lv_private_1_0= '-' ) ) | ( (lv_protected_2_0= '#' ) ) | ( (lv_package_3_0= '~' ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:525:1: ( ( (lv_public_0_0= '+' ) ) | ( (lv_private_1_0= '-' ) ) | ( (lv_protected_2_0= '#' ) ) | ( (lv_package_3_0= '~' ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:525:1: ( ( (lv_public_0_0= '+' ) ) | ( (lv_private_1_0= '-' ) ) | ( (lv_protected_2_0= '#' ) ) | ( (lv_package_3_0= '~' ) ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt8=1;
                }
                break;
            case 20:
                {
                alt8=2;
                }
                break;
            case 21:
                {
                alt8=3;
                }
                break;
            case 22:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:525:2: ( (lv_public_0_0= '+' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:525:2: ( (lv_public_0_0= '+' ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:526:1: (lv_public_0_0= '+' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:526:1: (lv_public_0_0= '+' )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:527:3: lv_public_0_0= '+'
                    {
                    lv_public_0_0=(Token)match(input,19,FOLLOW_19_in_ruleVisibilityKind1072); 

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
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:541:6: ( (lv_private_1_0= '-' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:541:6: ( (lv_private_1_0= '-' ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:542:1: (lv_private_1_0= '-' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:542:1: (lv_private_1_0= '-' )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:543:3: lv_private_1_0= '-'
                    {
                    lv_private_1_0=(Token)match(input,20,FOLLOW_20_in_ruleVisibilityKind1109); 

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
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:557:6: ( (lv_protected_2_0= '#' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:557:6: ( (lv_protected_2_0= '#' ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:558:1: (lv_protected_2_0= '#' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:558:1: (lv_protected_2_0= '#' )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:559:3: lv_protected_2_0= '#'
                    {
                    lv_protected_2_0=(Token)match(input,21,FOLLOW_21_in_ruleVisibilityKind1146); 

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
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:573:6: ( (lv_package_3_0= '~' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:573:6: ( (lv_package_3_0= '~' ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:574:1: (lv_package_3_0= '~' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:574:1: (lv_package_3_0= '~' )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:575:3: lv_package_3_0= '~'
                    {
                    lv_package_3_0=(Token)match(input,22,FOLLOW_22_in_ruleVisibilityKind1183); 

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
    public static final BitSet FOLLOW_ruleVisibilityKind_in_ruleAbstractRule131 = new BitSet(new long[]{0x000000000007C3F0L});
    public static final BitSet FOLLOW_RULE_VALUE_SPECIFICATION_ID_in_ruleAbstractRule149 = new BitSet(new long[]{0x000000000007C3F0L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAbstractRule176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralBooleanRule_in_ruleAbstractRule205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralIntegerOrUnlimitedNaturalRule_in_ruleAbstractRule224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralRealRule_in_ruleAbstractRule243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralNullRule_in_ruleAbstractRule262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralStringRule_in_ruleAbstractRule281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUndefinedRule_in_ruleAbstractRule311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralBooleanRule_in_entryRuleLiteralBooleanRule348 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralBooleanRule358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleLiteralBooleanRule402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleLiteralBooleanRule431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralIntegerOrUnlimitedNaturalRule_in_entryRuleLiteralIntegerOrUnlimitedNaturalRule482 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralIntegerOrUnlimitedNaturalRule492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLiteralIntegerOrUnlimitedNaturalRule536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VALUE_SPECIFICATION_NEGATIVE_INT_in_ruleLiteralIntegerOrUnlimitedNaturalRule556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleLiteralIntegerOrUnlimitedNaturalRule588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralRealRule_in_entryRuleLiteralRealRule637 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralRealRule647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VALUE_SPECIFICATION_DOUBLE_in_ruleLiteralRealRule688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralNullRule_in_entryRuleLiteralNullRule728 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralNullRule738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleLiteralNullRule780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralStringRule_in_entryRuleLiteralStringRule828 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralStringRule838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLiteralStringRule879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUndefinedRule_in_entryRuleUndefinedRule919 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUndefinedRule929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleUndefinedRule971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_entryRuleVisibilityKind1019 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVisibilityKind1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleVisibilityKind1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleVisibilityKind1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleVisibilityKind1146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleVisibilityKind1183 = new BitSet(new long[]{0x0000000000000002L});

}