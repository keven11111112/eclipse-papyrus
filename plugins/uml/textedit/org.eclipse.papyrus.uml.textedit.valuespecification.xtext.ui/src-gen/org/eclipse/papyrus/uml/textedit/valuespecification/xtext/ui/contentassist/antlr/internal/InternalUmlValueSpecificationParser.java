package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui.contentassist.antlr.internal; 

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
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.services.UmlValueSpecificationGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlValueSpecificationParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_VALUE_SPECIFICATION_NEGATIVE_INT", "RULE_VALUE_SPECIFICATION_ID", "RULE_ID", "RULE_VALUE_SPECIFICATION_DOUBLE", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'*'", "'null'", "'<Undefined>'", "'+'", "'-'", "'#'", "'~'"
    };
    public static final int RULE_ID=7;
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
    public static final int RULE_INT=4;
    public static final int RULE_VALUE_SPECIFICATION_ID=6;
    public static final int RULE_WS=12;
    public static final int RULE_VALUE_SPECIFICATION_NEGATIVE_INT=5;

    // delegates
    // delegators


        public InternalUmlValueSpecificationParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUmlValueSpecificationParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUmlValueSpecificationParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g"; }


     
     	private UmlValueSpecificationGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(UmlValueSpecificationGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleAbstractRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:60:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:61:1: ( ruleAbstractRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:62:1: ruleAbstractRule EOF
            {
             before(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule61);
            ruleAbstractRule();

            state._fsp--;

             after(grammarAccess.getAbstractRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule68); 

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
    // $ANTLR end "entryRuleAbstractRule"


    // $ANTLR start "ruleAbstractRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:69:1: ruleAbstractRule : ( ( rule__AbstractRule__Group__0 ) ) ;
    public final void ruleAbstractRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:73:2: ( ( ( rule__AbstractRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:74:1: ( ( rule__AbstractRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:74:1: ( ( rule__AbstractRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:75:1: ( rule__AbstractRule__Group__0 )
            {
             before(grammarAccess.getAbstractRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:76:1: ( rule__AbstractRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:76:2: rule__AbstractRule__Group__0
            {
            pushFollow(FOLLOW_rule__AbstractRule__Group__0_in_ruleAbstractRule94);
            rule__AbstractRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAbstractRuleAccess().getGroup()); 

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
    // $ANTLR end "ruleAbstractRule"


    // $ANTLR start "entryRuleLiteralBooleanRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:88:1: entryRuleLiteralBooleanRule : ruleLiteralBooleanRule EOF ;
    public final void entryRuleLiteralBooleanRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:89:1: ( ruleLiteralBooleanRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:90:1: ruleLiteralBooleanRule EOF
            {
             before(grammarAccess.getLiteralBooleanRuleRule()); 
            pushFollow(FOLLOW_ruleLiteralBooleanRule_in_entryRuleLiteralBooleanRule121);
            ruleLiteralBooleanRule();

            state._fsp--;

             after(grammarAccess.getLiteralBooleanRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralBooleanRule128); 

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
    // $ANTLR end "entryRuleLiteralBooleanRule"


    // $ANTLR start "ruleLiteralBooleanRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:97:1: ruleLiteralBooleanRule : ( ( rule__LiteralBooleanRule__ValueAssignment ) ) ;
    public final void ruleLiteralBooleanRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:101:2: ( ( ( rule__LiteralBooleanRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:102:1: ( ( rule__LiteralBooleanRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:102:1: ( ( rule__LiteralBooleanRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:103:1: ( rule__LiteralBooleanRule__ValueAssignment )
            {
             before(grammarAccess.getLiteralBooleanRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:104:1: ( rule__LiteralBooleanRule__ValueAssignment )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:104:2: rule__LiteralBooleanRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__LiteralBooleanRule__ValueAssignment_in_ruleLiteralBooleanRule154);
            rule__LiteralBooleanRule__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getLiteralBooleanRuleAccess().getValueAssignment()); 

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
    // $ANTLR end "ruleLiteralBooleanRule"


    // $ANTLR start "entryRuleLiteralIntegerOrUnlimitedNaturalRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:116:1: entryRuleLiteralIntegerOrUnlimitedNaturalRule : ruleLiteralIntegerOrUnlimitedNaturalRule EOF ;
    public final void entryRuleLiteralIntegerOrUnlimitedNaturalRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:117:1: ( ruleLiteralIntegerOrUnlimitedNaturalRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:118:1: ruleLiteralIntegerOrUnlimitedNaturalRule EOF
            {
             before(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleRule()); 
            pushFollow(FOLLOW_ruleLiteralIntegerOrUnlimitedNaturalRule_in_entryRuleLiteralIntegerOrUnlimitedNaturalRule181);
            ruleLiteralIntegerOrUnlimitedNaturalRule();

            state._fsp--;

             after(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralIntegerOrUnlimitedNaturalRule188); 

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
    // $ANTLR end "entryRuleLiteralIntegerOrUnlimitedNaturalRule"


    // $ANTLR start "ruleLiteralIntegerOrUnlimitedNaturalRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:125:1: ruleLiteralIntegerOrUnlimitedNaturalRule : ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__Alternatives ) ) ;
    public final void ruleLiteralIntegerOrUnlimitedNaturalRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:129:2: ( ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:130:1: ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:130:1: ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:131:1: ( rule__LiteralIntegerOrUnlimitedNaturalRule__Alternatives )
            {
             before(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:132:1: ( rule__LiteralIntegerOrUnlimitedNaturalRule__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:132:2: rule__LiteralIntegerOrUnlimitedNaturalRule__Alternatives
            {
            pushFollow(FOLLOW_rule__LiteralIntegerOrUnlimitedNaturalRule__Alternatives_in_ruleLiteralIntegerOrUnlimitedNaturalRule214);
            rule__LiteralIntegerOrUnlimitedNaturalRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getAlternatives()); 

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
    // $ANTLR end "ruleLiteralIntegerOrUnlimitedNaturalRule"


    // $ANTLR start "entryRuleLiteralRealRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:144:1: entryRuleLiteralRealRule : ruleLiteralRealRule EOF ;
    public final void entryRuleLiteralRealRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:145:1: ( ruleLiteralRealRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:146:1: ruleLiteralRealRule EOF
            {
             before(grammarAccess.getLiteralRealRuleRule()); 
            pushFollow(FOLLOW_ruleLiteralRealRule_in_entryRuleLiteralRealRule241);
            ruleLiteralRealRule();

            state._fsp--;

             after(grammarAccess.getLiteralRealRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralRealRule248); 

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
    // $ANTLR end "entryRuleLiteralRealRule"


    // $ANTLR start "ruleLiteralRealRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:153:1: ruleLiteralRealRule : ( ( rule__LiteralRealRule__ValueAssignment ) ) ;
    public final void ruleLiteralRealRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:157:2: ( ( ( rule__LiteralRealRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:158:1: ( ( rule__LiteralRealRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:158:1: ( ( rule__LiteralRealRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:159:1: ( rule__LiteralRealRule__ValueAssignment )
            {
             before(grammarAccess.getLiteralRealRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:160:1: ( rule__LiteralRealRule__ValueAssignment )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:160:2: rule__LiteralRealRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__LiteralRealRule__ValueAssignment_in_ruleLiteralRealRule274);
            rule__LiteralRealRule__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getLiteralRealRuleAccess().getValueAssignment()); 

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
    // $ANTLR end "ruleLiteralRealRule"


    // $ANTLR start "entryRuleLiteralNullRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:172:1: entryRuleLiteralNullRule : ruleLiteralNullRule EOF ;
    public final void entryRuleLiteralNullRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:173:1: ( ruleLiteralNullRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:174:1: ruleLiteralNullRule EOF
            {
             before(grammarAccess.getLiteralNullRuleRule()); 
            pushFollow(FOLLOW_ruleLiteralNullRule_in_entryRuleLiteralNullRule301);
            ruleLiteralNullRule();

            state._fsp--;

             after(grammarAccess.getLiteralNullRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralNullRule308); 

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
    // $ANTLR end "entryRuleLiteralNullRule"


    // $ANTLR start "ruleLiteralNullRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:181:1: ruleLiteralNullRule : ( ( rule__LiteralNullRule__ValueAssignment ) ) ;
    public final void ruleLiteralNullRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:185:2: ( ( ( rule__LiteralNullRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:186:1: ( ( rule__LiteralNullRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:186:1: ( ( rule__LiteralNullRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:187:1: ( rule__LiteralNullRule__ValueAssignment )
            {
             before(grammarAccess.getLiteralNullRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:188:1: ( rule__LiteralNullRule__ValueAssignment )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:188:2: rule__LiteralNullRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__LiteralNullRule__ValueAssignment_in_ruleLiteralNullRule334);
            rule__LiteralNullRule__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getLiteralNullRuleAccess().getValueAssignment()); 

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
    // $ANTLR end "ruleLiteralNullRule"


    // $ANTLR start "entryRuleLiteralStringRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:200:1: entryRuleLiteralStringRule : ruleLiteralStringRule EOF ;
    public final void entryRuleLiteralStringRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:201:1: ( ruleLiteralStringRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:202:1: ruleLiteralStringRule EOF
            {
             before(grammarAccess.getLiteralStringRuleRule()); 
            pushFollow(FOLLOW_ruleLiteralStringRule_in_entryRuleLiteralStringRule361);
            ruleLiteralStringRule();

            state._fsp--;

             after(grammarAccess.getLiteralStringRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralStringRule368); 

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
    // $ANTLR end "entryRuleLiteralStringRule"


    // $ANTLR start "ruleLiteralStringRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:209:1: ruleLiteralStringRule : ( ( rule__LiteralStringRule__ValueAssignment ) ) ;
    public final void ruleLiteralStringRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:213:2: ( ( ( rule__LiteralStringRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:214:1: ( ( rule__LiteralStringRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:214:1: ( ( rule__LiteralStringRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:215:1: ( rule__LiteralStringRule__ValueAssignment )
            {
             before(grammarAccess.getLiteralStringRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:216:1: ( rule__LiteralStringRule__ValueAssignment )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:216:2: rule__LiteralStringRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__LiteralStringRule__ValueAssignment_in_ruleLiteralStringRule394);
            rule__LiteralStringRule__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getLiteralStringRuleAccess().getValueAssignment()); 

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
    // $ANTLR end "ruleLiteralStringRule"


    // $ANTLR start "entryRuleUndefinedRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:228:1: entryRuleUndefinedRule : ruleUndefinedRule EOF ;
    public final void entryRuleUndefinedRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:229:1: ( ruleUndefinedRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:230:1: ruleUndefinedRule EOF
            {
             before(grammarAccess.getUndefinedRuleRule()); 
            pushFollow(FOLLOW_ruleUndefinedRule_in_entryRuleUndefinedRule421);
            ruleUndefinedRule();

            state._fsp--;

             after(grammarAccess.getUndefinedRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUndefinedRule428); 

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
    // $ANTLR end "entryRuleUndefinedRule"


    // $ANTLR start "ruleUndefinedRule"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:237:1: ruleUndefinedRule : ( ( rule__UndefinedRule__ValueAssignment ) ) ;
    public final void ruleUndefinedRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:241:2: ( ( ( rule__UndefinedRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:242:1: ( ( rule__UndefinedRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:242:1: ( ( rule__UndefinedRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:243:1: ( rule__UndefinedRule__ValueAssignment )
            {
             before(grammarAccess.getUndefinedRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:244:1: ( rule__UndefinedRule__ValueAssignment )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:244:2: rule__UndefinedRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__UndefinedRule__ValueAssignment_in_ruleUndefinedRule454);
            rule__UndefinedRule__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getUndefinedRuleAccess().getValueAssignment()); 

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
    // $ANTLR end "ruleUndefinedRule"


    // $ANTLR start "entryRuleVisibilityKind"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:256:1: entryRuleVisibilityKind : ruleVisibilityKind EOF ;
    public final void entryRuleVisibilityKind() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:257:1: ( ruleVisibilityKind EOF )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:258:1: ruleVisibilityKind EOF
            {
             before(grammarAccess.getVisibilityKindRule()); 
            pushFollow(FOLLOW_ruleVisibilityKind_in_entryRuleVisibilityKind481);
            ruleVisibilityKind();

            state._fsp--;

             after(grammarAccess.getVisibilityKindRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVisibilityKind488); 

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
    // $ANTLR end "entryRuleVisibilityKind"


    // $ANTLR start "ruleVisibilityKind"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:265:1: ruleVisibilityKind : ( ( rule__VisibilityKind__Alternatives ) ) ;
    public final void ruleVisibilityKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:269:2: ( ( ( rule__VisibilityKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:270:1: ( ( rule__VisibilityKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:270:1: ( ( rule__VisibilityKind__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:271:1: ( rule__VisibilityKind__Alternatives )
            {
             before(grammarAccess.getVisibilityKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:272:1: ( rule__VisibilityKind__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:272:2: rule__VisibilityKind__Alternatives
            {
            pushFollow(FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind514);
            rule__VisibilityKind__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVisibilityKindAccess().getAlternatives()); 

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
    // $ANTLR end "ruleVisibilityKind"


    // $ANTLR start "rule__AbstractRule__Alternatives_2"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:284:1: rule__AbstractRule__Alternatives_2 : ( ( ( rule__AbstractRule__InstanceSpecificationAssignment_2_0 ) ) | ( ( rule__AbstractRule__ValueAssignment_2_1 ) ) | ( ( rule__AbstractRule__UndefinedAssignment_2_2 ) ) );
    public final void rule__AbstractRule__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:288:1: ( ( ( rule__AbstractRule__InstanceSpecificationAssignment_2_0 ) ) | ( ( rule__AbstractRule__ValueAssignment_2_1 ) ) | ( ( rule__AbstractRule__UndefinedAssignment_2_2 ) ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt1=1;
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
                alt1=2;
                }
                break;
            case 18:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:289:1: ( ( rule__AbstractRule__InstanceSpecificationAssignment_2_0 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:289:1: ( ( rule__AbstractRule__InstanceSpecificationAssignment_2_0 ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:290:1: ( rule__AbstractRule__InstanceSpecificationAssignment_2_0 )
                    {
                     before(grammarAccess.getAbstractRuleAccess().getInstanceSpecificationAssignment_2_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:291:1: ( rule__AbstractRule__InstanceSpecificationAssignment_2_0 )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:291:2: rule__AbstractRule__InstanceSpecificationAssignment_2_0
                    {
                    pushFollow(FOLLOW_rule__AbstractRule__InstanceSpecificationAssignment_2_0_in_rule__AbstractRule__Alternatives_2550);
                    rule__AbstractRule__InstanceSpecificationAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAbstractRuleAccess().getInstanceSpecificationAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:295:6: ( ( rule__AbstractRule__ValueAssignment_2_1 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:295:6: ( ( rule__AbstractRule__ValueAssignment_2_1 ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:296:1: ( rule__AbstractRule__ValueAssignment_2_1 )
                    {
                     before(grammarAccess.getAbstractRuleAccess().getValueAssignment_2_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:297:1: ( rule__AbstractRule__ValueAssignment_2_1 )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:297:2: rule__AbstractRule__ValueAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__AbstractRule__ValueAssignment_2_1_in_rule__AbstractRule__Alternatives_2568);
                    rule__AbstractRule__ValueAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getAbstractRuleAccess().getValueAssignment_2_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:301:6: ( ( rule__AbstractRule__UndefinedAssignment_2_2 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:301:6: ( ( rule__AbstractRule__UndefinedAssignment_2_2 ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:302:1: ( rule__AbstractRule__UndefinedAssignment_2_2 )
                    {
                     before(grammarAccess.getAbstractRuleAccess().getUndefinedAssignment_2_2()); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:303:1: ( rule__AbstractRule__UndefinedAssignment_2_2 )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:303:2: rule__AbstractRule__UndefinedAssignment_2_2
                    {
                    pushFollow(FOLLOW_rule__AbstractRule__UndefinedAssignment_2_2_in_rule__AbstractRule__Alternatives_2586);
                    rule__AbstractRule__UndefinedAssignment_2_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getAbstractRuleAccess().getUndefinedAssignment_2_2()); 

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
    // $ANTLR end "rule__AbstractRule__Alternatives_2"


    // $ANTLR start "rule__AbstractRule__ValueAlternatives_2_1_0"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:312:1: rule__AbstractRule__ValueAlternatives_2_1_0 : ( ( ruleLiteralBooleanRule ) | ( ruleLiteralIntegerOrUnlimitedNaturalRule ) | ( ruleLiteralRealRule ) | ( ruleLiteralNullRule ) | ( ruleLiteralStringRule ) );
    public final void rule__AbstractRule__ValueAlternatives_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:316:1: ( ( ruleLiteralBooleanRule ) | ( ruleLiteralIntegerOrUnlimitedNaturalRule ) | ( ruleLiteralRealRule ) | ( ruleLiteralNullRule ) | ( ruleLiteralStringRule ) )
            int alt2=5;
            switch ( input.LA(1) ) {
            case 14:
            case 15:
                {
                alt2=1;
                }
                break;
            case RULE_INT:
            case RULE_VALUE_SPECIFICATION_NEGATIVE_INT:
            case 16:
                {
                alt2=2;
                }
                break;
            case RULE_VALUE_SPECIFICATION_DOUBLE:
                {
                alt2=3;
                }
                break;
            case 17:
                {
                alt2=4;
                }
                break;
            case RULE_STRING:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:317:1: ( ruleLiteralBooleanRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:317:1: ( ruleLiteralBooleanRule )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:318:1: ruleLiteralBooleanRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getValueLiteralBooleanRuleParserRuleCall_2_1_0_0()); 
                    pushFollow(FOLLOW_ruleLiteralBooleanRule_in_rule__AbstractRule__ValueAlternatives_2_1_0619);
                    ruleLiteralBooleanRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getValueLiteralBooleanRuleParserRuleCall_2_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:323:6: ( ruleLiteralIntegerOrUnlimitedNaturalRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:323:6: ( ruleLiteralIntegerOrUnlimitedNaturalRule )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:324:1: ruleLiteralIntegerOrUnlimitedNaturalRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getValueLiteralIntegerOrUnlimitedNaturalRuleParserRuleCall_2_1_0_1()); 
                    pushFollow(FOLLOW_ruleLiteralIntegerOrUnlimitedNaturalRule_in_rule__AbstractRule__ValueAlternatives_2_1_0636);
                    ruleLiteralIntegerOrUnlimitedNaturalRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getValueLiteralIntegerOrUnlimitedNaturalRuleParserRuleCall_2_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:329:6: ( ruleLiteralRealRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:329:6: ( ruleLiteralRealRule )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:330:1: ruleLiteralRealRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getValueLiteralRealRuleParserRuleCall_2_1_0_2()); 
                    pushFollow(FOLLOW_ruleLiteralRealRule_in_rule__AbstractRule__ValueAlternatives_2_1_0653);
                    ruleLiteralRealRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getValueLiteralRealRuleParserRuleCall_2_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:335:6: ( ruleLiteralNullRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:335:6: ( ruleLiteralNullRule )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:336:1: ruleLiteralNullRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getValueLiteralNullRuleParserRuleCall_2_1_0_3()); 
                    pushFollow(FOLLOW_ruleLiteralNullRule_in_rule__AbstractRule__ValueAlternatives_2_1_0670);
                    ruleLiteralNullRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getValueLiteralNullRuleParserRuleCall_2_1_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:341:6: ( ruleLiteralStringRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:341:6: ( ruleLiteralStringRule )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:342:1: ruleLiteralStringRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getValueLiteralStringRuleParserRuleCall_2_1_0_4()); 
                    pushFollow(FOLLOW_ruleLiteralStringRule_in_rule__AbstractRule__ValueAlternatives_2_1_0687);
                    ruleLiteralStringRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getValueLiteralStringRuleParserRuleCall_2_1_0_4()); 

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
    // $ANTLR end "rule__AbstractRule__ValueAlternatives_2_1_0"


    // $ANTLR start "rule__LiteralBooleanRule__ValueAlternatives_0"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:352:1: rule__LiteralBooleanRule__ValueAlternatives_0 : ( ( 'true' ) | ( 'false' ) );
    public final void rule__LiteralBooleanRule__ValueAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:356:1: ( ( 'true' ) | ( 'false' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            else if ( (LA3_0==15) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:357:1: ( 'true' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:357:1: ( 'true' )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:358:1: 'true'
                    {
                     before(grammarAccess.getLiteralBooleanRuleAccess().getValueTrueKeyword_0_0()); 
                    match(input,14,FOLLOW_14_in_rule__LiteralBooleanRule__ValueAlternatives_0720); 
                     after(grammarAccess.getLiteralBooleanRuleAccess().getValueTrueKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:365:6: ( 'false' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:365:6: ( 'false' )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:366:1: 'false'
                    {
                     before(grammarAccess.getLiteralBooleanRuleAccess().getValueFalseKeyword_0_1()); 
                    match(input,15,FOLLOW_15_in_rule__LiteralBooleanRule__ValueAlternatives_0740); 
                     after(grammarAccess.getLiteralBooleanRuleAccess().getValueFalseKeyword_0_1()); 

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
    // $ANTLR end "rule__LiteralBooleanRule__ValueAlternatives_0"


    // $ANTLR start "rule__LiteralIntegerOrUnlimitedNaturalRule__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:378:1: rule__LiteralIntegerOrUnlimitedNaturalRule__Alternatives : ( ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment_0 ) ) | ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__UnlimitedAssignment_1 ) ) );
    public final void rule__LiteralIntegerOrUnlimitedNaturalRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:382:1: ( ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment_0 ) ) | ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__UnlimitedAssignment_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=RULE_INT && LA4_0<=RULE_VALUE_SPECIFICATION_NEGATIVE_INT)) ) {
                alt4=1;
            }
            else if ( (LA4_0==16) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:383:1: ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment_0 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:383:1: ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment_0 ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:384:1: ( rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment_0 )
                    {
                     before(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getValueAssignment_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:385:1: ( rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment_0 )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:385:2: rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment_0
                    {
                    pushFollow(FOLLOW_rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment_0_in_rule__LiteralIntegerOrUnlimitedNaturalRule__Alternatives774);
                    rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:389:6: ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__UnlimitedAssignment_1 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:389:6: ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__UnlimitedAssignment_1 ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:390:1: ( rule__LiteralIntegerOrUnlimitedNaturalRule__UnlimitedAssignment_1 )
                    {
                     before(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getUnlimitedAssignment_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:391:1: ( rule__LiteralIntegerOrUnlimitedNaturalRule__UnlimitedAssignment_1 )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:391:2: rule__LiteralIntegerOrUnlimitedNaturalRule__UnlimitedAssignment_1
                    {
                    pushFollow(FOLLOW_rule__LiteralIntegerOrUnlimitedNaturalRule__UnlimitedAssignment_1_in_rule__LiteralIntegerOrUnlimitedNaturalRule__Alternatives792);
                    rule__LiteralIntegerOrUnlimitedNaturalRule__UnlimitedAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getUnlimitedAssignment_1()); 

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
    // $ANTLR end "rule__LiteralIntegerOrUnlimitedNaturalRule__Alternatives"


    // $ANTLR start "rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAlternatives_0_0"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:400:1: rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAlternatives_0_0 : ( ( RULE_INT ) | ( RULE_VALUE_SPECIFICATION_NEGATIVE_INT ) );
    public final void rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:404:1: ( ( RULE_INT ) | ( RULE_VALUE_SPECIFICATION_NEGATIVE_INT ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_VALUE_SPECIFICATION_NEGATIVE_INT) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:405:1: ( RULE_INT )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:405:1: ( RULE_INT )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:406:1: RULE_INT
                    {
                     before(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getValueINTTerminalRuleCall_0_0_0()); 
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAlternatives_0_0825); 
                     after(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getValueINTTerminalRuleCall_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:411:6: ( RULE_VALUE_SPECIFICATION_NEGATIVE_INT )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:411:6: ( RULE_VALUE_SPECIFICATION_NEGATIVE_INT )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:412:1: RULE_VALUE_SPECIFICATION_NEGATIVE_INT
                    {
                     before(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getValueVALUE_SPECIFICATION_NEGATIVE_INTTerminalRuleCall_0_0_1()); 
                    match(input,RULE_VALUE_SPECIFICATION_NEGATIVE_INT,FOLLOW_RULE_VALUE_SPECIFICATION_NEGATIVE_INT_in_rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAlternatives_0_0842); 
                     after(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getValueVALUE_SPECIFICATION_NEGATIVE_INTTerminalRuleCall_0_0_1()); 

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
    // $ANTLR end "rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAlternatives_0_0"


    // $ANTLR start "rule__VisibilityKind__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:422:1: rule__VisibilityKind__Alternatives : ( ( ( rule__VisibilityKind__PublicAssignment_0 ) ) | ( ( rule__VisibilityKind__PrivateAssignment_1 ) ) | ( ( rule__VisibilityKind__ProtectedAssignment_2 ) ) | ( ( rule__VisibilityKind__PackageAssignment_3 ) ) );
    public final void rule__VisibilityKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:426:1: ( ( ( rule__VisibilityKind__PublicAssignment_0 ) ) | ( ( rule__VisibilityKind__PrivateAssignment_1 ) ) | ( ( rule__VisibilityKind__ProtectedAssignment_2 ) ) | ( ( rule__VisibilityKind__PackageAssignment_3 ) ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt6=1;
                }
                break;
            case 20:
                {
                alt6=2;
                }
                break;
            case 21:
                {
                alt6=3;
                }
                break;
            case 22:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:427:1: ( ( rule__VisibilityKind__PublicAssignment_0 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:427:1: ( ( rule__VisibilityKind__PublicAssignment_0 ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:428:1: ( rule__VisibilityKind__PublicAssignment_0 )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPublicAssignment_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:429:1: ( rule__VisibilityKind__PublicAssignment_0 )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:429:2: rule__VisibilityKind__PublicAssignment_0
                    {
                    pushFollow(FOLLOW_rule__VisibilityKind__PublicAssignment_0_in_rule__VisibilityKind__Alternatives874);
                    rule__VisibilityKind__PublicAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVisibilityKindAccess().getPublicAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:433:6: ( ( rule__VisibilityKind__PrivateAssignment_1 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:433:6: ( ( rule__VisibilityKind__PrivateAssignment_1 ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:434:1: ( rule__VisibilityKind__PrivateAssignment_1 )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPrivateAssignment_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:435:1: ( rule__VisibilityKind__PrivateAssignment_1 )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:435:2: rule__VisibilityKind__PrivateAssignment_1
                    {
                    pushFollow(FOLLOW_rule__VisibilityKind__PrivateAssignment_1_in_rule__VisibilityKind__Alternatives892);
                    rule__VisibilityKind__PrivateAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getVisibilityKindAccess().getPrivateAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:439:6: ( ( rule__VisibilityKind__ProtectedAssignment_2 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:439:6: ( ( rule__VisibilityKind__ProtectedAssignment_2 ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:440:1: ( rule__VisibilityKind__ProtectedAssignment_2 )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getProtectedAssignment_2()); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:441:1: ( rule__VisibilityKind__ProtectedAssignment_2 )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:441:2: rule__VisibilityKind__ProtectedAssignment_2
                    {
                    pushFollow(FOLLOW_rule__VisibilityKind__ProtectedAssignment_2_in_rule__VisibilityKind__Alternatives910);
                    rule__VisibilityKind__ProtectedAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getVisibilityKindAccess().getProtectedAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:445:6: ( ( rule__VisibilityKind__PackageAssignment_3 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:445:6: ( ( rule__VisibilityKind__PackageAssignment_3 ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:446:1: ( rule__VisibilityKind__PackageAssignment_3 )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPackageAssignment_3()); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:447:1: ( rule__VisibilityKind__PackageAssignment_3 )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:447:2: rule__VisibilityKind__PackageAssignment_3
                    {
                    pushFollow(FOLLOW_rule__VisibilityKind__PackageAssignment_3_in_rule__VisibilityKind__Alternatives928);
                    rule__VisibilityKind__PackageAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getVisibilityKindAccess().getPackageAssignment_3()); 

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
    // $ANTLR end "rule__VisibilityKind__Alternatives"


    // $ANTLR start "rule__AbstractRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:458:1: rule__AbstractRule__Group__0 : rule__AbstractRule__Group__0__Impl rule__AbstractRule__Group__1 ;
    public final void rule__AbstractRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:462:1: ( rule__AbstractRule__Group__0__Impl rule__AbstractRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:463:2: rule__AbstractRule__Group__0__Impl rule__AbstractRule__Group__1
            {
            pushFollow(FOLLOW_rule__AbstractRule__Group__0__Impl_in_rule__AbstractRule__Group__0959);
            rule__AbstractRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AbstractRule__Group__1_in_rule__AbstractRule__Group__0962);
            rule__AbstractRule__Group__1();

            state._fsp--;


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
    // $ANTLR end "rule__AbstractRule__Group__0"


    // $ANTLR start "rule__AbstractRule__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:470:1: rule__AbstractRule__Group__0__Impl : ( ( rule__AbstractRule__VisibilityAssignment_0 )? ) ;
    public final void rule__AbstractRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:474:1: ( ( ( rule__AbstractRule__VisibilityAssignment_0 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:475:1: ( ( rule__AbstractRule__VisibilityAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:475:1: ( ( rule__AbstractRule__VisibilityAssignment_0 )? )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:476:1: ( rule__AbstractRule__VisibilityAssignment_0 )?
            {
             before(grammarAccess.getAbstractRuleAccess().getVisibilityAssignment_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:477:1: ( rule__AbstractRule__VisibilityAssignment_0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=19 && LA7_0<=22)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:477:2: rule__AbstractRule__VisibilityAssignment_0
                    {
                    pushFollow(FOLLOW_rule__AbstractRule__VisibilityAssignment_0_in_rule__AbstractRule__Group__0__Impl989);
                    rule__AbstractRule__VisibilityAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAbstractRuleAccess().getVisibilityAssignment_0()); 

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
    // $ANTLR end "rule__AbstractRule__Group__0__Impl"


    // $ANTLR start "rule__AbstractRule__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:487:1: rule__AbstractRule__Group__1 : rule__AbstractRule__Group__1__Impl rule__AbstractRule__Group__2 ;
    public final void rule__AbstractRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:491:1: ( rule__AbstractRule__Group__1__Impl rule__AbstractRule__Group__2 )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:492:2: rule__AbstractRule__Group__1__Impl rule__AbstractRule__Group__2
            {
            pushFollow(FOLLOW_rule__AbstractRule__Group__1__Impl_in_rule__AbstractRule__Group__11020);
            rule__AbstractRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AbstractRule__Group__2_in_rule__AbstractRule__Group__11023);
            rule__AbstractRule__Group__2();

            state._fsp--;


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
    // $ANTLR end "rule__AbstractRule__Group__1"


    // $ANTLR start "rule__AbstractRule__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:499:1: rule__AbstractRule__Group__1__Impl : ( ( rule__AbstractRule__NameAssignment_1 )? ) ;
    public final void rule__AbstractRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:503:1: ( ( ( rule__AbstractRule__NameAssignment_1 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:504:1: ( ( rule__AbstractRule__NameAssignment_1 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:504:1: ( ( rule__AbstractRule__NameAssignment_1 )? )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:505:1: ( rule__AbstractRule__NameAssignment_1 )?
            {
             before(grammarAccess.getAbstractRuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:506:1: ( rule__AbstractRule__NameAssignment_1 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_VALUE_SPECIFICATION_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:506:2: rule__AbstractRule__NameAssignment_1
                    {
                    pushFollow(FOLLOW_rule__AbstractRule__NameAssignment_1_in_rule__AbstractRule__Group__1__Impl1050);
                    rule__AbstractRule__NameAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAbstractRuleAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__AbstractRule__Group__1__Impl"


    // $ANTLR start "rule__AbstractRule__Group__2"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:516:1: rule__AbstractRule__Group__2 : rule__AbstractRule__Group__2__Impl ;
    public final void rule__AbstractRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:520:1: ( rule__AbstractRule__Group__2__Impl )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:521:2: rule__AbstractRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__AbstractRule__Group__2__Impl_in_rule__AbstractRule__Group__21081);
            rule__AbstractRule__Group__2__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__AbstractRule__Group__2"


    // $ANTLR start "rule__AbstractRule__Group__2__Impl"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:527:1: rule__AbstractRule__Group__2__Impl : ( ( rule__AbstractRule__Alternatives_2 ) ) ;
    public final void rule__AbstractRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:531:1: ( ( ( rule__AbstractRule__Alternatives_2 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:532:1: ( ( rule__AbstractRule__Alternatives_2 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:532:1: ( ( rule__AbstractRule__Alternatives_2 ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:533:1: ( rule__AbstractRule__Alternatives_2 )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives_2()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:534:1: ( rule__AbstractRule__Alternatives_2 )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:534:2: rule__AbstractRule__Alternatives_2
            {
            pushFollow(FOLLOW_rule__AbstractRule__Alternatives_2_in_rule__AbstractRule__Group__2__Impl1108);
            rule__AbstractRule__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getAbstractRuleAccess().getAlternatives_2()); 

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
    // $ANTLR end "rule__AbstractRule__Group__2__Impl"


    // $ANTLR start "rule__AbstractRule__VisibilityAssignment_0"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:551:1: rule__AbstractRule__VisibilityAssignment_0 : ( ruleVisibilityKind ) ;
    public final void rule__AbstractRule__VisibilityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:555:1: ( ( ruleVisibilityKind ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:556:1: ( ruleVisibilityKind )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:556:1: ( ruleVisibilityKind )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:557:1: ruleVisibilityKind
            {
             before(grammarAccess.getAbstractRuleAccess().getVisibilityVisibilityKindParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleVisibilityKind_in_rule__AbstractRule__VisibilityAssignment_01149);
            ruleVisibilityKind();

            state._fsp--;

             after(grammarAccess.getAbstractRuleAccess().getVisibilityVisibilityKindParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__AbstractRule__VisibilityAssignment_0"


    // $ANTLR start "rule__AbstractRule__NameAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:566:1: rule__AbstractRule__NameAssignment_1 : ( RULE_VALUE_SPECIFICATION_ID ) ;
    public final void rule__AbstractRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:570:1: ( ( RULE_VALUE_SPECIFICATION_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:571:1: ( RULE_VALUE_SPECIFICATION_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:571:1: ( RULE_VALUE_SPECIFICATION_ID )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:572:1: RULE_VALUE_SPECIFICATION_ID
            {
             before(grammarAccess.getAbstractRuleAccess().getNameVALUE_SPECIFICATION_IDTerminalRuleCall_1_0()); 
            match(input,RULE_VALUE_SPECIFICATION_ID,FOLLOW_RULE_VALUE_SPECIFICATION_ID_in_rule__AbstractRule__NameAssignment_11180); 
             after(grammarAccess.getAbstractRuleAccess().getNameVALUE_SPECIFICATION_IDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__AbstractRule__NameAssignment_1"


    // $ANTLR start "rule__AbstractRule__InstanceSpecificationAssignment_2_0"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:581:1: rule__AbstractRule__InstanceSpecificationAssignment_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__AbstractRule__InstanceSpecificationAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:585:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:586:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:586:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:587:1: ( RULE_ID )
            {
             before(grammarAccess.getAbstractRuleAccess().getInstanceSpecificationInstanceSpecificationCrossReference_2_0_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:588:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:589:1: RULE_ID
            {
             before(grammarAccess.getAbstractRuleAccess().getInstanceSpecificationInstanceSpecificationIDTerminalRuleCall_2_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AbstractRule__InstanceSpecificationAssignment_2_01215); 
             after(grammarAccess.getAbstractRuleAccess().getInstanceSpecificationInstanceSpecificationIDTerminalRuleCall_2_0_0_1()); 

            }

             after(grammarAccess.getAbstractRuleAccess().getInstanceSpecificationInstanceSpecificationCrossReference_2_0_0()); 

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
    // $ANTLR end "rule__AbstractRule__InstanceSpecificationAssignment_2_0"


    // $ANTLR start "rule__AbstractRule__ValueAssignment_2_1"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:600:1: rule__AbstractRule__ValueAssignment_2_1 : ( ( rule__AbstractRule__ValueAlternatives_2_1_0 ) ) ;
    public final void rule__AbstractRule__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:604:1: ( ( ( rule__AbstractRule__ValueAlternatives_2_1_0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:605:1: ( ( rule__AbstractRule__ValueAlternatives_2_1_0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:605:1: ( ( rule__AbstractRule__ValueAlternatives_2_1_0 ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:606:1: ( rule__AbstractRule__ValueAlternatives_2_1_0 )
            {
             before(grammarAccess.getAbstractRuleAccess().getValueAlternatives_2_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:607:1: ( rule__AbstractRule__ValueAlternatives_2_1_0 )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:607:2: rule__AbstractRule__ValueAlternatives_2_1_0
            {
            pushFollow(FOLLOW_rule__AbstractRule__ValueAlternatives_2_1_0_in_rule__AbstractRule__ValueAssignment_2_11250);
            rule__AbstractRule__ValueAlternatives_2_1_0();

            state._fsp--;


            }

             after(grammarAccess.getAbstractRuleAccess().getValueAlternatives_2_1_0()); 

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
    // $ANTLR end "rule__AbstractRule__ValueAssignment_2_1"


    // $ANTLR start "rule__AbstractRule__UndefinedAssignment_2_2"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:616:1: rule__AbstractRule__UndefinedAssignment_2_2 : ( ruleUndefinedRule ) ;
    public final void rule__AbstractRule__UndefinedAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:620:1: ( ( ruleUndefinedRule ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:621:1: ( ruleUndefinedRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:621:1: ( ruleUndefinedRule )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:622:1: ruleUndefinedRule
            {
             before(grammarAccess.getAbstractRuleAccess().getUndefinedUndefinedRuleParserRuleCall_2_2_0()); 
            pushFollow(FOLLOW_ruleUndefinedRule_in_rule__AbstractRule__UndefinedAssignment_2_21283);
            ruleUndefinedRule();

            state._fsp--;

             after(grammarAccess.getAbstractRuleAccess().getUndefinedUndefinedRuleParserRuleCall_2_2_0()); 

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
    // $ANTLR end "rule__AbstractRule__UndefinedAssignment_2_2"


    // $ANTLR start "rule__LiteralBooleanRule__ValueAssignment"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:631:1: rule__LiteralBooleanRule__ValueAssignment : ( ( rule__LiteralBooleanRule__ValueAlternatives_0 ) ) ;
    public final void rule__LiteralBooleanRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:635:1: ( ( ( rule__LiteralBooleanRule__ValueAlternatives_0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:636:1: ( ( rule__LiteralBooleanRule__ValueAlternatives_0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:636:1: ( ( rule__LiteralBooleanRule__ValueAlternatives_0 ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:637:1: ( rule__LiteralBooleanRule__ValueAlternatives_0 )
            {
             before(grammarAccess.getLiteralBooleanRuleAccess().getValueAlternatives_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:638:1: ( rule__LiteralBooleanRule__ValueAlternatives_0 )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:638:2: rule__LiteralBooleanRule__ValueAlternatives_0
            {
            pushFollow(FOLLOW_rule__LiteralBooleanRule__ValueAlternatives_0_in_rule__LiteralBooleanRule__ValueAssignment1314);
            rule__LiteralBooleanRule__ValueAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getLiteralBooleanRuleAccess().getValueAlternatives_0()); 

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
    // $ANTLR end "rule__LiteralBooleanRule__ValueAssignment"


    // $ANTLR start "rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment_0"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:647:1: rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment_0 : ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAlternatives_0_0 ) ) ;
    public final void rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:651:1: ( ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAlternatives_0_0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:652:1: ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAlternatives_0_0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:652:1: ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAlternatives_0_0 ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:653:1: ( rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAlternatives_0_0 )
            {
             before(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getValueAlternatives_0_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:654:1: ( rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAlternatives_0_0 )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:654:2: rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAlternatives_0_0
            {
            pushFollow(FOLLOW_rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAlternatives_0_0_in_rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment_01347);
            rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getValueAlternatives_0_0()); 

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
    // $ANTLR end "rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment_0"


    // $ANTLR start "rule__LiteralIntegerOrUnlimitedNaturalRule__UnlimitedAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:663:1: rule__LiteralIntegerOrUnlimitedNaturalRule__UnlimitedAssignment_1 : ( ( '*' ) ) ;
    public final void rule__LiteralIntegerOrUnlimitedNaturalRule__UnlimitedAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:667:1: ( ( ( '*' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:668:1: ( ( '*' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:668:1: ( ( '*' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:669:1: ( '*' )
            {
             before(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getUnlimitedAsteriskKeyword_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:670:1: ( '*' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:671:1: '*'
            {
             before(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getUnlimitedAsteriskKeyword_1_0()); 
            match(input,16,FOLLOW_16_in_rule__LiteralIntegerOrUnlimitedNaturalRule__UnlimitedAssignment_11385); 
             after(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getUnlimitedAsteriskKeyword_1_0()); 

            }

             after(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getUnlimitedAsteriskKeyword_1_0()); 

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
    // $ANTLR end "rule__LiteralIntegerOrUnlimitedNaturalRule__UnlimitedAssignment_1"


    // $ANTLR start "rule__LiteralRealRule__ValueAssignment"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:686:1: rule__LiteralRealRule__ValueAssignment : ( RULE_VALUE_SPECIFICATION_DOUBLE ) ;
    public final void rule__LiteralRealRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:690:1: ( ( RULE_VALUE_SPECIFICATION_DOUBLE ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:691:1: ( RULE_VALUE_SPECIFICATION_DOUBLE )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:691:1: ( RULE_VALUE_SPECIFICATION_DOUBLE )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:692:1: RULE_VALUE_SPECIFICATION_DOUBLE
            {
             before(grammarAccess.getLiteralRealRuleAccess().getValueVALUE_SPECIFICATION_DOUBLETerminalRuleCall_0()); 
            match(input,RULE_VALUE_SPECIFICATION_DOUBLE,FOLLOW_RULE_VALUE_SPECIFICATION_DOUBLE_in_rule__LiteralRealRule__ValueAssignment1424); 
             after(grammarAccess.getLiteralRealRuleAccess().getValueVALUE_SPECIFICATION_DOUBLETerminalRuleCall_0()); 

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
    // $ANTLR end "rule__LiteralRealRule__ValueAssignment"


    // $ANTLR start "rule__LiteralNullRule__ValueAssignment"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:701:1: rule__LiteralNullRule__ValueAssignment : ( ( 'null' ) ) ;
    public final void rule__LiteralNullRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:705:1: ( ( ( 'null' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:706:1: ( ( 'null' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:706:1: ( ( 'null' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:707:1: ( 'null' )
            {
             before(grammarAccess.getLiteralNullRuleAccess().getValueNullKeyword_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:708:1: ( 'null' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:709:1: 'null'
            {
             before(grammarAccess.getLiteralNullRuleAccess().getValueNullKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__LiteralNullRule__ValueAssignment1460); 
             after(grammarAccess.getLiteralNullRuleAccess().getValueNullKeyword_0()); 

            }

             after(grammarAccess.getLiteralNullRuleAccess().getValueNullKeyword_0()); 

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
    // $ANTLR end "rule__LiteralNullRule__ValueAssignment"


    // $ANTLR start "rule__LiteralStringRule__ValueAssignment"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:724:1: rule__LiteralStringRule__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__LiteralStringRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:728:1: ( ( RULE_STRING ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:729:1: ( RULE_STRING )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:729:1: ( RULE_STRING )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:730:1: RULE_STRING
            {
             before(grammarAccess.getLiteralStringRuleAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__LiteralStringRule__ValueAssignment1499); 
             after(grammarAccess.getLiteralStringRuleAccess().getValueSTRINGTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__LiteralStringRule__ValueAssignment"


    // $ANTLR start "rule__UndefinedRule__ValueAssignment"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:739:1: rule__UndefinedRule__ValueAssignment : ( ( '<Undefined>' ) ) ;
    public final void rule__UndefinedRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:743:1: ( ( ( '<Undefined>' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:744:1: ( ( '<Undefined>' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:744:1: ( ( '<Undefined>' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:745:1: ( '<Undefined>' )
            {
             before(grammarAccess.getUndefinedRuleAccess().getValueUndefinedKeyword_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:746:1: ( '<Undefined>' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:747:1: '<Undefined>'
            {
             before(grammarAccess.getUndefinedRuleAccess().getValueUndefinedKeyword_0()); 
            match(input,18,FOLLOW_18_in_rule__UndefinedRule__ValueAssignment1535); 
             after(grammarAccess.getUndefinedRuleAccess().getValueUndefinedKeyword_0()); 

            }

             after(grammarAccess.getUndefinedRuleAccess().getValueUndefinedKeyword_0()); 

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
    // $ANTLR end "rule__UndefinedRule__ValueAssignment"


    // $ANTLR start "rule__VisibilityKind__PublicAssignment_0"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:762:1: rule__VisibilityKind__PublicAssignment_0 : ( ( '+' ) ) ;
    public final void rule__VisibilityKind__PublicAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:766:1: ( ( ( '+' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:767:1: ( ( '+' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:767:1: ( ( '+' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:768:1: ( '+' )
            {
             before(grammarAccess.getVisibilityKindAccess().getPublicPlusSignKeyword_0_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:769:1: ( '+' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:770:1: '+'
            {
             before(grammarAccess.getVisibilityKindAccess().getPublicPlusSignKeyword_0_0()); 
            match(input,19,FOLLOW_19_in_rule__VisibilityKind__PublicAssignment_01579); 
             after(grammarAccess.getVisibilityKindAccess().getPublicPlusSignKeyword_0_0()); 

            }

             after(grammarAccess.getVisibilityKindAccess().getPublicPlusSignKeyword_0_0()); 

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
    // $ANTLR end "rule__VisibilityKind__PublicAssignment_0"


    // $ANTLR start "rule__VisibilityKind__PrivateAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:785:1: rule__VisibilityKind__PrivateAssignment_1 : ( ( '-' ) ) ;
    public final void rule__VisibilityKind__PrivateAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:789:1: ( ( ( '-' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:790:1: ( ( '-' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:790:1: ( ( '-' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:791:1: ( '-' )
            {
             before(grammarAccess.getVisibilityKindAccess().getPrivateHyphenMinusKeyword_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:792:1: ( '-' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:793:1: '-'
            {
             before(grammarAccess.getVisibilityKindAccess().getPrivateHyphenMinusKeyword_1_0()); 
            match(input,20,FOLLOW_20_in_rule__VisibilityKind__PrivateAssignment_11623); 
             after(grammarAccess.getVisibilityKindAccess().getPrivateHyphenMinusKeyword_1_0()); 

            }

             after(grammarAccess.getVisibilityKindAccess().getPrivateHyphenMinusKeyword_1_0()); 

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
    // $ANTLR end "rule__VisibilityKind__PrivateAssignment_1"


    // $ANTLR start "rule__VisibilityKind__ProtectedAssignment_2"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:808:1: rule__VisibilityKind__ProtectedAssignment_2 : ( ( '#' ) ) ;
    public final void rule__VisibilityKind__ProtectedAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:812:1: ( ( ( '#' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:813:1: ( ( '#' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:813:1: ( ( '#' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:814:1: ( '#' )
            {
             before(grammarAccess.getVisibilityKindAccess().getProtectedNumberSignKeyword_2_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:815:1: ( '#' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:816:1: '#'
            {
             before(grammarAccess.getVisibilityKindAccess().getProtectedNumberSignKeyword_2_0()); 
            match(input,21,FOLLOW_21_in_rule__VisibilityKind__ProtectedAssignment_21667); 
             after(grammarAccess.getVisibilityKindAccess().getProtectedNumberSignKeyword_2_0()); 

            }

             after(grammarAccess.getVisibilityKindAccess().getProtectedNumberSignKeyword_2_0()); 

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
    // $ANTLR end "rule__VisibilityKind__ProtectedAssignment_2"


    // $ANTLR start "rule__VisibilityKind__PackageAssignment_3"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:831:1: rule__VisibilityKind__PackageAssignment_3 : ( ( '~' ) ) ;
    public final void rule__VisibilityKind__PackageAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:835:1: ( ( ( '~' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:836:1: ( ( '~' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:836:1: ( ( '~' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:837:1: ( '~' )
            {
             before(grammarAccess.getVisibilityKindAccess().getPackageTildeKeyword_3_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:838:1: ( '~' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:839:1: '~'
            {
             before(grammarAccess.getVisibilityKindAccess().getPackageTildeKeyword_3_0()); 
            match(input,22,FOLLOW_22_in_rule__VisibilityKind__PackageAssignment_31711); 
             after(grammarAccess.getVisibilityKindAccess().getPackageTildeKeyword_3_0()); 

            }

             after(grammarAccess.getVisibilityKindAccess().getPackageTildeKeyword_3_0()); 

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
    // $ANTLR end "rule__VisibilityKind__PackageAssignment_3"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__Group__0_in_ruleAbstractRule94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralBooleanRule_in_entryRuleLiteralBooleanRule121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralBooleanRule128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralBooleanRule__ValueAssignment_in_ruleLiteralBooleanRule154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralIntegerOrUnlimitedNaturalRule_in_entryRuleLiteralIntegerOrUnlimitedNaturalRule181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralIntegerOrUnlimitedNaturalRule188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralIntegerOrUnlimitedNaturalRule__Alternatives_in_ruleLiteralIntegerOrUnlimitedNaturalRule214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralRealRule_in_entryRuleLiteralRealRule241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralRealRule248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralRealRule__ValueAssignment_in_ruleLiteralRealRule274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralNullRule_in_entryRuleLiteralNullRule301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralNullRule308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralNullRule__ValueAssignment_in_ruleLiteralNullRule334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralStringRule_in_entryRuleLiteralStringRule361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralStringRule368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralStringRule__ValueAssignment_in_ruleLiteralStringRule394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUndefinedRule_in_entryRuleUndefinedRule421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUndefinedRule428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UndefinedRule__ValueAssignment_in_ruleUndefinedRule454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_entryRuleVisibilityKind481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVisibilityKind488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__InstanceSpecificationAssignment_2_0_in_rule__AbstractRule__Alternatives_2550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__ValueAssignment_2_1_in_rule__AbstractRule__Alternatives_2568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__UndefinedAssignment_2_2_in_rule__AbstractRule__Alternatives_2586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralBooleanRule_in_rule__AbstractRule__ValueAlternatives_2_1_0619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralIntegerOrUnlimitedNaturalRule_in_rule__AbstractRule__ValueAlternatives_2_1_0636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralRealRule_in_rule__AbstractRule__ValueAlternatives_2_1_0653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralNullRule_in_rule__AbstractRule__ValueAlternatives_2_1_0670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralStringRule_in_rule__AbstractRule__ValueAlternatives_2_1_0687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__LiteralBooleanRule__ValueAlternatives_0720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__LiteralBooleanRule__ValueAlternatives_0740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment_0_in_rule__LiteralIntegerOrUnlimitedNaturalRule__Alternatives774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralIntegerOrUnlimitedNaturalRule__UnlimitedAssignment_1_in_rule__LiteralIntegerOrUnlimitedNaturalRule__Alternatives792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAlternatives_0_0825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VALUE_SPECIFICATION_NEGATIVE_INT_in_rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAlternatives_0_0842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibilityKind__PublicAssignment_0_in_rule__VisibilityKind__Alternatives874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibilityKind__PrivateAssignment_1_in_rule__VisibilityKind__Alternatives892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibilityKind__ProtectedAssignment_2_in_rule__VisibilityKind__Alternatives910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibilityKind__PackageAssignment_3_in_rule__VisibilityKind__Alternatives928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__Group__0__Impl_in_rule__AbstractRule__Group__0959 = new BitSet(new long[]{0x000000000007C3F0L});
    public static final BitSet FOLLOW_rule__AbstractRule__Group__1_in_rule__AbstractRule__Group__0962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__VisibilityAssignment_0_in_rule__AbstractRule__Group__0__Impl989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__Group__1__Impl_in_rule__AbstractRule__Group__11020 = new BitSet(new long[]{0x000000000007C3F0L});
    public static final BitSet FOLLOW_rule__AbstractRule__Group__2_in_rule__AbstractRule__Group__11023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__NameAssignment_1_in_rule__AbstractRule__Group__1__Impl1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__Group__2__Impl_in_rule__AbstractRule__Group__21081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__Alternatives_2_in_rule__AbstractRule__Group__2__Impl1108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_rule__AbstractRule__VisibilityAssignment_01149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VALUE_SPECIFICATION_ID_in_rule__AbstractRule__NameAssignment_11180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AbstractRule__InstanceSpecificationAssignment_2_01215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__ValueAlternatives_2_1_0_in_rule__AbstractRule__ValueAssignment_2_11250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUndefinedRule_in_rule__AbstractRule__UndefinedAssignment_2_21283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralBooleanRule__ValueAlternatives_0_in_rule__LiteralBooleanRule__ValueAssignment1314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAlternatives_0_0_in_rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment_01347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__LiteralIntegerOrUnlimitedNaturalRule__UnlimitedAssignment_11385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VALUE_SPECIFICATION_DOUBLE_in_rule__LiteralRealRule__ValueAssignment1424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__LiteralNullRule__ValueAssignment1460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__LiteralStringRule__ValueAssignment1499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__UndefinedRule__ValueAssignment1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__VisibilityKind__PublicAssignment_01579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__VisibilityKind__PrivateAssignment_11623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__VisibilityKind__ProtectedAssignment_21667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__VisibilityKind__PackageAssignment_31711 = new BitSet(new long[]{0x0000000000000002L});

}