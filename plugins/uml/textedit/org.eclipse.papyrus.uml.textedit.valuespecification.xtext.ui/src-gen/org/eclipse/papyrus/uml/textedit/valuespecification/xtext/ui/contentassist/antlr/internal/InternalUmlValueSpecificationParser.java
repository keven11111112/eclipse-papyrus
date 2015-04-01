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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_VALUE_SPECIFICATION_ID", "RULE_ID", "RULE_VALUE_SPECIFICATION_INT", "RULE_VALUE_SPECIFICATION_DOUBLE", "RULE_VALUE_SPECIFICATION_STRING", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'='", "'null'", "'<Undefined>'", "'+'", "'-'", "'#'", "'~'"
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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:69:1: ruleAbstractRule : ( ( rule__AbstractRule__Alternatives ) ) ;
    public final void ruleAbstractRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:73:2: ( ( ( rule__AbstractRule__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:74:1: ( ( rule__AbstractRule__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:74:1: ( ( rule__AbstractRule__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:75:1: ( rule__AbstractRule__Alternatives )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:76:1: ( rule__AbstractRule__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:76:2: rule__AbstractRule__Alternatives
            {
            pushFollow(FOLLOW_rule__AbstractRule__Alternatives_in_ruleAbstractRule94);
            rule__AbstractRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractRuleAccess().getAlternatives()); 

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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:125:1: ruleLiteralIntegerOrUnlimitedNaturalRule : ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment ) ) ;
    public final void ruleLiteralIntegerOrUnlimitedNaturalRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:129:2: ( ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:130:1: ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:130:1: ( ( rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:131:1: ( rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment )
            {
             before(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:132:1: ( rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:132:2: rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment_in_ruleLiteralIntegerOrUnlimitedNaturalRule214);
            rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getValueAssignment()); 

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


    // $ANTLR start "rule__AbstractRule__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:284:1: rule__AbstractRule__Alternatives : ( ( ( rule__AbstractRule__Group_0__0 ) ) | ( ( rule__AbstractRule__UndefinedAssignment_1 ) ) );
    public final void rule__AbstractRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:288:1: ( ( ( rule__AbstractRule__Group_0__0 ) ) | ( ( rule__AbstractRule__UndefinedAssignment_1 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_VALUE_SPECIFICATION_ID && LA1_0<=RULE_VALUE_SPECIFICATION_STRING)||(LA1_0>=15 && LA1_0<=16)||LA1_0==18||(LA1_0>=20 && LA1_0<=23)) ) {
                alt1=1;
            }
            else if ( (LA1_0==19) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:289:1: ( ( rule__AbstractRule__Group_0__0 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:289:1: ( ( rule__AbstractRule__Group_0__0 ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:290:1: ( rule__AbstractRule__Group_0__0 )
                    {
                     before(grammarAccess.getAbstractRuleAccess().getGroup_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:291:1: ( rule__AbstractRule__Group_0__0 )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:291:2: rule__AbstractRule__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__AbstractRule__Group_0__0_in_rule__AbstractRule__Alternatives550);
                    rule__AbstractRule__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAbstractRuleAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:295:6: ( ( rule__AbstractRule__UndefinedAssignment_1 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:295:6: ( ( rule__AbstractRule__UndefinedAssignment_1 ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:296:1: ( rule__AbstractRule__UndefinedAssignment_1 )
                    {
                     before(grammarAccess.getAbstractRuleAccess().getUndefinedAssignment_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:297:1: ( rule__AbstractRule__UndefinedAssignment_1 )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:297:2: rule__AbstractRule__UndefinedAssignment_1
                    {
                    pushFollow(FOLLOW_rule__AbstractRule__UndefinedAssignment_1_in_rule__AbstractRule__Alternatives568);
                    rule__AbstractRule__UndefinedAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getAbstractRuleAccess().getUndefinedAssignment_1()); 

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
    // $ANTLR end "rule__AbstractRule__Alternatives"


    // $ANTLR start "rule__AbstractRule__Alternatives_0_2"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:306:1: rule__AbstractRule__Alternatives_0_2 : ( ( ( rule__AbstractRule__ValueAssignment_0_2_0 ) ) | ( ( rule__AbstractRule__InstanceSpecificationAssignment_0_2_1 ) ) );
    public final void rule__AbstractRule__Alternatives_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:310:1: ( ( ( rule__AbstractRule__ValueAssignment_0_2_0 ) ) | ( ( rule__AbstractRule__InstanceSpecificationAssignment_0_2_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=RULE_VALUE_SPECIFICATION_INT && LA2_0<=RULE_VALUE_SPECIFICATION_STRING)||(LA2_0>=15 && LA2_0<=16)||LA2_0==18) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:311:1: ( ( rule__AbstractRule__ValueAssignment_0_2_0 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:311:1: ( ( rule__AbstractRule__ValueAssignment_0_2_0 ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:312:1: ( rule__AbstractRule__ValueAssignment_0_2_0 )
                    {
                     before(grammarAccess.getAbstractRuleAccess().getValueAssignment_0_2_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:313:1: ( rule__AbstractRule__ValueAssignment_0_2_0 )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:313:2: rule__AbstractRule__ValueAssignment_0_2_0
                    {
                    pushFollow(FOLLOW_rule__AbstractRule__ValueAssignment_0_2_0_in_rule__AbstractRule__Alternatives_0_2601);
                    rule__AbstractRule__ValueAssignment_0_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAbstractRuleAccess().getValueAssignment_0_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:317:6: ( ( rule__AbstractRule__InstanceSpecificationAssignment_0_2_1 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:317:6: ( ( rule__AbstractRule__InstanceSpecificationAssignment_0_2_1 ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:318:1: ( rule__AbstractRule__InstanceSpecificationAssignment_0_2_1 )
                    {
                     before(grammarAccess.getAbstractRuleAccess().getInstanceSpecificationAssignment_0_2_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:319:1: ( rule__AbstractRule__InstanceSpecificationAssignment_0_2_1 )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:319:2: rule__AbstractRule__InstanceSpecificationAssignment_0_2_1
                    {
                    pushFollow(FOLLOW_rule__AbstractRule__InstanceSpecificationAssignment_0_2_1_in_rule__AbstractRule__Alternatives_0_2619);
                    rule__AbstractRule__InstanceSpecificationAssignment_0_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getAbstractRuleAccess().getInstanceSpecificationAssignment_0_2_1()); 

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
    // $ANTLR end "rule__AbstractRule__Alternatives_0_2"


    // $ANTLR start "rule__AbstractRule__ValueAlternatives_0_2_0_0"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:328:1: rule__AbstractRule__ValueAlternatives_0_2_0_0 : ( ( ruleLiteralBooleanRule ) | ( ruleLiteralIntegerOrUnlimitedNaturalRule ) | ( ruleLiteralRealRule ) | ( ruleLiteralNullRule ) | ( ruleLiteralStringRule ) );
    public final void rule__AbstractRule__ValueAlternatives_0_2_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:332:1: ( ( ruleLiteralBooleanRule ) | ( ruleLiteralIntegerOrUnlimitedNaturalRule ) | ( ruleLiteralRealRule ) | ( ruleLiteralNullRule ) | ( ruleLiteralStringRule ) )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 15:
            case 16:
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
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:333:1: ( ruleLiteralBooleanRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:333:1: ( ruleLiteralBooleanRule )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:334:1: ruleLiteralBooleanRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getValueLiteralBooleanRuleParserRuleCall_0_2_0_0_0()); 
                    pushFollow(FOLLOW_ruleLiteralBooleanRule_in_rule__AbstractRule__ValueAlternatives_0_2_0_0652);
                    ruleLiteralBooleanRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getValueLiteralBooleanRuleParserRuleCall_0_2_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:339:6: ( ruleLiteralIntegerOrUnlimitedNaturalRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:339:6: ( ruleLiteralIntegerOrUnlimitedNaturalRule )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:340:1: ruleLiteralIntegerOrUnlimitedNaturalRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getValueLiteralIntegerOrUnlimitedNaturalRuleParserRuleCall_0_2_0_0_1()); 
                    pushFollow(FOLLOW_ruleLiteralIntegerOrUnlimitedNaturalRule_in_rule__AbstractRule__ValueAlternatives_0_2_0_0669);
                    ruleLiteralIntegerOrUnlimitedNaturalRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getValueLiteralIntegerOrUnlimitedNaturalRuleParserRuleCall_0_2_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:345:6: ( ruleLiteralRealRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:345:6: ( ruleLiteralRealRule )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:346:1: ruleLiteralRealRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getValueLiteralRealRuleParserRuleCall_0_2_0_0_2()); 
                    pushFollow(FOLLOW_ruleLiteralRealRule_in_rule__AbstractRule__ValueAlternatives_0_2_0_0686);
                    ruleLiteralRealRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getValueLiteralRealRuleParserRuleCall_0_2_0_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:351:6: ( ruleLiteralNullRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:351:6: ( ruleLiteralNullRule )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:352:1: ruleLiteralNullRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getValueLiteralNullRuleParserRuleCall_0_2_0_0_3()); 
                    pushFollow(FOLLOW_ruleLiteralNullRule_in_rule__AbstractRule__ValueAlternatives_0_2_0_0703);
                    ruleLiteralNullRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getValueLiteralNullRuleParserRuleCall_0_2_0_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:357:6: ( ruleLiteralStringRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:357:6: ( ruleLiteralStringRule )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:358:1: ruleLiteralStringRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getValueLiteralStringRuleParserRuleCall_0_2_0_0_4()); 
                    pushFollow(FOLLOW_ruleLiteralStringRule_in_rule__AbstractRule__ValueAlternatives_0_2_0_0720);
                    ruleLiteralStringRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getValueLiteralStringRuleParserRuleCall_0_2_0_0_4()); 

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
    // $ANTLR end "rule__AbstractRule__ValueAlternatives_0_2_0_0"


    // $ANTLR start "rule__LiteralBooleanRule__ValueAlternatives_0"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:368:1: rule__LiteralBooleanRule__ValueAlternatives_0 : ( ( 'true' ) | ( 'false' ) );
    public final void rule__LiteralBooleanRule__ValueAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:372:1: ( ( 'true' ) | ( 'false' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
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
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:373:1: ( 'true' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:373:1: ( 'true' )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:374:1: 'true'
                    {
                     before(grammarAccess.getLiteralBooleanRuleAccess().getValueTrueKeyword_0_0()); 
                    match(input,15,FOLLOW_15_in_rule__LiteralBooleanRule__ValueAlternatives_0753); 
                     after(grammarAccess.getLiteralBooleanRuleAccess().getValueTrueKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:381:6: ( 'false' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:381:6: ( 'false' )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:382:1: 'false'
                    {
                     before(grammarAccess.getLiteralBooleanRuleAccess().getValueFalseKeyword_0_1()); 
                    match(input,16,FOLLOW_16_in_rule__LiteralBooleanRule__ValueAlternatives_0773); 
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


    // $ANTLR start "rule__VisibilityKind__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:394:1: rule__VisibilityKind__Alternatives : ( ( ( rule__VisibilityKind__PublicAssignment_0 ) ) | ( ( rule__VisibilityKind__PrivateAssignment_1 ) ) | ( ( rule__VisibilityKind__ProtectedAssignment_2 ) ) | ( ( rule__VisibilityKind__PackageAssignment_3 ) ) );
    public final void rule__VisibilityKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:398:1: ( ( ( rule__VisibilityKind__PublicAssignment_0 ) ) | ( ( rule__VisibilityKind__PrivateAssignment_1 ) ) | ( ( rule__VisibilityKind__ProtectedAssignment_2 ) ) | ( ( rule__VisibilityKind__PackageAssignment_3 ) ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt5=1;
                }
                break;
            case 21:
                {
                alt5=2;
                }
                break;
            case 22:
                {
                alt5=3;
                }
                break;
            case 23:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:399:1: ( ( rule__VisibilityKind__PublicAssignment_0 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:399:1: ( ( rule__VisibilityKind__PublicAssignment_0 ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:400:1: ( rule__VisibilityKind__PublicAssignment_0 )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPublicAssignment_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:401:1: ( rule__VisibilityKind__PublicAssignment_0 )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:401:2: rule__VisibilityKind__PublicAssignment_0
                    {
                    pushFollow(FOLLOW_rule__VisibilityKind__PublicAssignment_0_in_rule__VisibilityKind__Alternatives807);
                    rule__VisibilityKind__PublicAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVisibilityKindAccess().getPublicAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:405:6: ( ( rule__VisibilityKind__PrivateAssignment_1 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:405:6: ( ( rule__VisibilityKind__PrivateAssignment_1 ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:406:1: ( rule__VisibilityKind__PrivateAssignment_1 )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPrivateAssignment_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:407:1: ( rule__VisibilityKind__PrivateAssignment_1 )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:407:2: rule__VisibilityKind__PrivateAssignment_1
                    {
                    pushFollow(FOLLOW_rule__VisibilityKind__PrivateAssignment_1_in_rule__VisibilityKind__Alternatives825);
                    rule__VisibilityKind__PrivateAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getVisibilityKindAccess().getPrivateAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:411:6: ( ( rule__VisibilityKind__ProtectedAssignment_2 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:411:6: ( ( rule__VisibilityKind__ProtectedAssignment_2 ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:412:1: ( rule__VisibilityKind__ProtectedAssignment_2 )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getProtectedAssignment_2()); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:413:1: ( rule__VisibilityKind__ProtectedAssignment_2 )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:413:2: rule__VisibilityKind__ProtectedAssignment_2
                    {
                    pushFollow(FOLLOW_rule__VisibilityKind__ProtectedAssignment_2_in_rule__VisibilityKind__Alternatives843);
                    rule__VisibilityKind__ProtectedAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getVisibilityKindAccess().getProtectedAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:417:6: ( ( rule__VisibilityKind__PackageAssignment_3 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:417:6: ( ( rule__VisibilityKind__PackageAssignment_3 ) )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:418:1: ( rule__VisibilityKind__PackageAssignment_3 )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPackageAssignment_3()); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:419:1: ( rule__VisibilityKind__PackageAssignment_3 )
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:419:2: rule__VisibilityKind__PackageAssignment_3
                    {
                    pushFollow(FOLLOW_rule__VisibilityKind__PackageAssignment_3_in_rule__VisibilityKind__Alternatives861);
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


    // $ANTLR start "rule__AbstractRule__Group_0__0"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:430:1: rule__AbstractRule__Group_0__0 : rule__AbstractRule__Group_0__0__Impl rule__AbstractRule__Group_0__1 ;
    public final void rule__AbstractRule__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:434:1: ( rule__AbstractRule__Group_0__0__Impl rule__AbstractRule__Group_0__1 )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:435:2: rule__AbstractRule__Group_0__0__Impl rule__AbstractRule__Group_0__1
            {
            pushFollow(FOLLOW_rule__AbstractRule__Group_0__0__Impl_in_rule__AbstractRule__Group_0__0892);
            rule__AbstractRule__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AbstractRule__Group_0__1_in_rule__AbstractRule__Group_0__0895);
            rule__AbstractRule__Group_0__1();

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
    // $ANTLR end "rule__AbstractRule__Group_0__0"


    // $ANTLR start "rule__AbstractRule__Group_0__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:442:1: rule__AbstractRule__Group_0__0__Impl : ( ( rule__AbstractRule__VisibilityAssignment_0_0 )? ) ;
    public final void rule__AbstractRule__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:446:1: ( ( ( rule__AbstractRule__VisibilityAssignment_0_0 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:447:1: ( ( rule__AbstractRule__VisibilityAssignment_0_0 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:447:1: ( ( rule__AbstractRule__VisibilityAssignment_0_0 )? )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:448:1: ( rule__AbstractRule__VisibilityAssignment_0_0 )?
            {
             before(grammarAccess.getAbstractRuleAccess().getVisibilityAssignment_0_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:449:1: ( rule__AbstractRule__VisibilityAssignment_0_0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=20 && LA6_0<=23)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:449:2: rule__AbstractRule__VisibilityAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__AbstractRule__VisibilityAssignment_0_0_in_rule__AbstractRule__Group_0__0__Impl922);
                    rule__AbstractRule__VisibilityAssignment_0_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAbstractRuleAccess().getVisibilityAssignment_0_0()); 

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
    // $ANTLR end "rule__AbstractRule__Group_0__0__Impl"


    // $ANTLR start "rule__AbstractRule__Group_0__1"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:459:1: rule__AbstractRule__Group_0__1 : rule__AbstractRule__Group_0__1__Impl rule__AbstractRule__Group_0__2 ;
    public final void rule__AbstractRule__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:463:1: ( rule__AbstractRule__Group_0__1__Impl rule__AbstractRule__Group_0__2 )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:464:2: rule__AbstractRule__Group_0__1__Impl rule__AbstractRule__Group_0__2
            {
            pushFollow(FOLLOW_rule__AbstractRule__Group_0__1__Impl_in_rule__AbstractRule__Group_0__1953);
            rule__AbstractRule__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AbstractRule__Group_0__2_in_rule__AbstractRule__Group_0__1956);
            rule__AbstractRule__Group_0__2();

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
    // $ANTLR end "rule__AbstractRule__Group_0__1"


    // $ANTLR start "rule__AbstractRule__Group_0__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:471:1: rule__AbstractRule__Group_0__1__Impl : ( ( rule__AbstractRule__Group_0_1__0 )? ) ;
    public final void rule__AbstractRule__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:475:1: ( ( ( rule__AbstractRule__Group_0_1__0 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:476:1: ( ( rule__AbstractRule__Group_0_1__0 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:476:1: ( ( rule__AbstractRule__Group_0_1__0 )? )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:477:1: ( rule__AbstractRule__Group_0_1__0 )?
            {
             before(grammarAccess.getAbstractRuleAccess().getGroup_0_1()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:478:1: ( rule__AbstractRule__Group_0_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_VALUE_SPECIFICATION_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:478:2: rule__AbstractRule__Group_0_1__0
                    {
                    pushFollow(FOLLOW_rule__AbstractRule__Group_0_1__0_in_rule__AbstractRule__Group_0__1__Impl983);
                    rule__AbstractRule__Group_0_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAbstractRuleAccess().getGroup_0_1()); 

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
    // $ANTLR end "rule__AbstractRule__Group_0__1__Impl"


    // $ANTLR start "rule__AbstractRule__Group_0__2"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:488:1: rule__AbstractRule__Group_0__2 : rule__AbstractRule__Group_0__2__Impl ;
    public final void rule__AbstractRule__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:492:1: ( rule__AbstractRule__Group_0__2__Impl )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:493:2: rule__AbstractRule__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__AbstractRule__Group_0__2__Impl_in_rule__AbstractRule__Group_0__21014);
            rule__AbstractRule__Group_0__2__Impl();

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
    // $ANTLR end "rule__AbstractRule__Group_0__2"


    // $ANTLR start "rule__AbstractRule__Group_0__2__Impl"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:499:1: rule__AbstractRule__Group_0__2__Impl : ( ( rule__AbstractRule__Alternatives_0_2 ) ) ;
    public final void rule__AbstractRule__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:503:1: ( ( ( rule__AbstractRule__Alternatives_0_2 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:504:1: ( ( rule__AbstractRule__Alternatives_0_2 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:504:1: ( ( rule__AbstractRule__Alternatives_0_2 ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:505:1: ( rule__AbstractRule__Alternatives_0_2 )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives_0_2()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:506:1: ( rule__AbstractRule__Alternatives_0_2 )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:506:2: rule__AbstractRule__Alternatives_0_2
            {
            pushFollow(FOLLOW_rule__AbstractRule__Alternatives_0_2_in_rule__AbstractRule__Group_0__2__Impl1041);
            rule__AbstractRule__Alternatives_0_2();

            state._fsp--;


            }

             after(grammarAccess.getAbstractRuleAccess().getAlternatives_0_2()); 

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
    // $ANTLR end "rule__AbstractRule__Group_0__2__Impl"


    // $ANTLR start "rule__AbstractRule__Group_0_1__0"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:522:1: rule__AbstractRule__Group_0_1__0 : rule__AbstractRule__Group_0_1__0__Impl rule__AbstractRule__Group_0_1__1 ;
    public final void rule__AbstractRule__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:526:1: ( rule__AbstractRule__Group_0_1__0__Impl rule__AbstractRule__Group_0_1__1 )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:527:2: rule__AbstractRule__Group_0_1__0__Impl rule__AbstractRule__Group_0_1__1
            {
            pushFollow(FOLLOW_rule__AbstractRule__Group_0_1__0__Impl_in_rule__AbstractRule__Group_0_1__01077);
            rule__AbstractRule__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AbstractRule__Group_0_1__1_in_rule__AbstractRule__Group_0_1__01080);
            rule__AbstractRule__Group_0_1__1();

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
    // $ANTLR end "rule__AbstractRule__Group_0_1__0"


    // $ANTLR start "rule__AbstractRule__Group_0_1__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:534:1: rule__AbstractRule__Group_0_1__0__Impl : ( ( rule__AbstractRule__NameAssignment_0_1_0 ) ) ;
    public final void rule__AbstractRule__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:538:1: ( ( ( rule__AbstractRule__NameAssignment_0_1_0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:539:1: ( ( rule__AbstractRule__NameAssignment_0_1_0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:539:1: ( ( rule__AbstractRule__NameAssignment_0_1_0 ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:540:1: ( rule__AbstractRule__NameAssignment_0_1_0 )
            {
             before(grammarAccess.getAbstractRuleAccess().getNameAssignment_0_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:541:1: ( rule__AbstractRule__NameAssignment_0_1_0 )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:541:2: rule__AbstractRule__NameAssignment_0_1_0
            {
            pushFollow(FOLLOW_rule__AbstractRule__NameAssignment_0_1_0_in_rule__AbstractRule__Group_0_1__0__Impl1107);
            rule__AbstractRule__NameAssignment_0_1_0();

            state._fsp--;


            }

             after(grammarAccess.getAbstractRuleAccess().getNameAssignment_0_1_0()); 

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
    // $ANTLR end "rule__AbstractRule__Group_0_1__0__Impl"


    // $ANTLR start "rule__AbstractRule__Group_0_1__1"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:551:1: rule__AbstractRule__Group_0_1__1 : rule__AbstractRule__Group_0_1__1__Impl ;
    public final void rule__AbstractRule__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:555:1: ( rule__AbstractRule__Group_0_1__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:556:2: rule__AbstractRule__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AbstractRule__Group_0_1__1__Impl_in_rule__AbstractRule__Group_0_1__11137);
            rule__AbstractRule__Group_0_1__1__Impl();

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
    // $ANTLR end "rule__AbstractRule__Group_0_1__1"


    // $ANTLR start "rule__AbstractRule__Group_0_1__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:562:1: rule__AbstractRule__Group_0_1__1__Impl : ( '=' ) ;
    public final void rule__AbstractRule__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:566:1: ( ( '=' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:567:1: ( '=' )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:567:1: ( '=' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:568:1: '='
            {
             before(grammarAccess.getAbstractRuleAccess().getEqualsSignKeyword_0_1_1()); 
            match(input,17,FOLLOW_17_in_rule__AbstractRule__Group_0_1__1__Impl1165); 
             after(grammarAccess.getAbstractRuleAccess().getEqualsSignKeyword_0_1_1()); 

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
    // $ANTLR end "rule__AbstractRule__Group_0_1__1__Impl"


    // $ANTLR start "rule__AbstractRule__VisibilityAssignment_0_0"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:586:1: rule__AbstractRule__VisibilityAssignment_0_0 : ( ruleVisibilityKind ) ;
    public final void rule__AbstractRule__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:590:1: ( ( ruleVisibilityKind ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:591:1: ( ruleVisibilityKind )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:591:1: ( ruleVisibilityKind )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:592:1: ruleVisibilityKind
            {
             before(grammarAccess.getAbstractRuleAccess().getVisibilityVisibilityKindParserRuleCall_0_0_0()); 
            pushFollow(FOLLOW_ruleVisibilityKind_in_rule__AbstractRule__VisibilityAssignment_0_01205);
            ruleVisibilityKind();

            state._fsp--;

             after(grammarAccess.getAbstractRuleAccess().getVisibilityVisibilityKindParserRuleCall_0_0_0()); 

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
    // $ANTLR end "rule__AbstractRule__VisibilityAssignment_0_0"


    // $ANTLR start "rule__AbstractRule__NameAssignment_0_1_0"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:601:1: rule__AbstractRule__NameAssignment_0_1_0 : ( RULE_VALUE_SPECIFICATION_ID ) ;
    public final void rule__AbstractRule__NameAssignment_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:605:1: ( ( RULE_VALUE_SPECIFICATION_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:606:1: ( RULE_VALUE_SPECIFICATION_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:606:1: ( RULE_VALUE_SPECIFICATION_ID )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:607:1: RULE_VALUE_SPECIFICATION_ID
            {
             before(grammarAccess.getAbstractRuleAccess().getNameVALUE_SPECIFICATION_IDTerminalRuleCall_0_1_0_0()); 
            match(input,RULE_VALUE_SPECIFICATION_ID,FOLLOW_RULE_VALUE_SPECIFICATION_ID_in_rule__AbstractRule__NameAssignment_0_1_01236); 
             after(grammarAccess.getAbstractRuleAccess().getNameVALUE_SPECIFICATION_IDTerminalRuleCall_0_1_0_0()); 

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
    // $ANTLR end "rule__AbstractRule__NameAssignment_0_1_0"


    // $ANTLR start "rule__AbstractRule__ValueAssignment_0_2_0"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:616:1: rule__AbstractRule__ValueAssignment_0_2_0 : ( ( rule__AbstractRule__ValueAlternatives_0_2_0_0 ) ) ;
    public final void rule__AbstractRule__ValueAssignment_0_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:620:1: ( ( ( rule__AbstractRule__ValueAlternatives_0_2_0_0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:621:1: ( ( rule__AbstractRule__ValueAlternatives_0_2_0_0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:621:1: ( ( rule__AbstractRule__ValueAlternatives_0_2_0_0 ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:622:1: ( rule__AbstractRule__ValueAlternatives_0_2_0_0 )
            {
             before(grammarAccess.getAbstractRuleAccess().getValueAlternatives_0_2_0_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:623:1: ( rule__AbstractRule__ValueAlternatives_0_2_0_0 )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:623:2: rule__AbstractRule__ValueAlternatives_0_2_0_0
            {
            pushFollow(FOLLOW_rule__AbstractRule__ValueAlternatives_0_2_0_0_in_rule__AbstractRule__ValueAssignment_0_2_01267);
            rule__AbstractRule__ValueAlternatives_0_2_0_0();

            state._fsp--;


            }

             after(grammarAccess.getAbstractRuleAccess().getValueAlternatives_0_2_0_0()); 

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
    // $ANTLR end "rule__AbstractRule__ValueAssignment_0_2_0"


    // $ANTLR start "rule__AbstractRule__InstanceSpecificationAssignment_0_2_1"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:632:1: rule__AbstractRule__InstanceSpecificationAssignment_0_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__AbstractRule__InstanceSpecificationAssignment_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:636:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:637:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:637:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:638:1: ( RULE_ID )
            {
             before(grammarAccess.getAbstractRuleAccess().getInstanceSpecificationInstanceSpecificationCrossReference_0_2_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:639:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:640:1: RULE_ID
            {
             before(grammarAccess.getAbstractRuleAccess().getInstanceSpecificationInstanceSpecificationIDTerminalRuleCall_0_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AbstractRule__InstanceSpecificationAssignment_0_2_11304); 
             after(grammarAccess.getAbstractRuleAccess().getInstanceSpecificationInstanceSpecificationIDTerminalRuleCall_0_2_1_0_1()); 

            }

             after(grammarAccess.getAbstractRuleAccess().getInstanceSpecificationInstanceSpecificationCrossReference_0_2_1_0()); 

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
    // $ANTLR end "rule__AbstractRule__InstanceSpecificationAssignment_0_2_1"


    // $ANTLR start "rule__AbstractRule__UndefinedAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:651:1: rule__AbstractRule__UndefinedAssignment_1 : ( ruleUndefinedRule ) ;
    public final void rule__AbstractRule__UndefinedAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:655:1: ( ( ruleUndefinedRule ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:656:1: ( ruleUndefinedRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:656:1: ( ruleUndefinedRule )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:657:1: ruleUndefinedRule
            {
             before(grammarAccess.getAbstractRuleAccess().getUndefinedUndefinedRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleUndefinedRule_in_rule__AbstractRule__UndefinedAssignment_11339);
            ruleUndefinedRule();

            state._fsp--;

             after(grammarAccess.getAbstractRuleAccess().getUndefinedUndefinedRuleParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__AbstractRule__UndefinedAssignment_1"


    // $ANTLR start "rule__LiteralBooleanRule__ValueAssignment"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:666:1: rule__LiteralBooleanRule__ValueAssignment : ( ( rule__LiteralBooleanRule__ValueAlternatives_0 ) ) ;
    public final void rule__LiteralBooleanRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:670:1: ( ( ( rule__LiteralBooleanRule__ValueAlternatives_0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:671:1: ( ( rule__LiteralBooleanRule__ValueAlternatives_0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:671:1: ( ( rule__LiteralBooleanRule__ValueAlternatives_0 ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:672:1: ( rule__LiteralBooleanRule__ValueAlternatives_0 )
            {
             before(grammarAccess.getLiteralBooleanRuleAccess().getValueAlternatives_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:673:1: ( rule__LiteralBooleanRule__ValueAlternatives_0 )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:673:2: rule__LiteralBooleanRule__ValueAlternatives_0
            {
            pushFollow(FOLLOW_rule__LiteralBooleanRule__ValueAlternatives_0_in_rule__LiteralBooleanRule__ValueAssignment1370);
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


    // $ANTLR start "rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:682:1: rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment : ( RULE_VALUE_SPECIFICATION_INT ) ;
    public final void rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:686:1: ( ( RULE_VALUE_SPECIFICATION_INT ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:687:1: ( RULE_VALUE_SPECIFICATION_INT )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:687:1: ( RULE_VALUE_SPECIFICATION_INT )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:688:1: RULE_VALUE_SPECIFICATION_INT
            {
             before(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getValueVALUE_SPECIFICATION_INTTerminalRuleCall_0()); 
            match(input,RULE_VALUE_SPECIFICATION_INT,FOLLOW_RULE_VALUE_SPECIFICATION_INT_in_rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment1403); 
             after(grammarAccess.getLiteralIntegerOrUnlimitedNaturalRuleAccess().getValueVALUE_SPECIFICATION_INTTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment"


    // $ANTLR start "rule__LiteralRealRule__ValueAssignment"
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:697:1: rule__LiteralRealRule__ValueAssignment : ( RULE_VALUE_SPECIFICATION_DOUBLE ) ;
    public final void rule__LiteralRealRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:701:1: ( ( RULE_VALUE_SPECIFICATION_DOUBLE ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:702:1: ( RULE_VALUE_SPECIFICATION_DOUBLE )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:702:1: ( RULE_VALUE_SPECIFICATION_DOUBLE )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:703:1: RULE_VALUE_SPECIFICATION_DOUBLE
            {
             before(grammarAccess.getLiteralRealRuleAccess().getValueVALUE_SPECIFICATION_DOUBLETerminalRuleCall_0()); 
            match(input,RULE_VALUE_SPECIFICATION_DOUBLE,FOLLOW_RULE_VALUE_SPECIFICATION_DOUBLE_in_rule__LiteralRealRule__ValueAssignment1434); 
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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:712:1: rule__LiteralNullRule__ValueAssignment : ( ( 'null' ) ) ;
    public final void rule__LiteralNullRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:716:1: ( ( ( 'null' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:717:1: ( ( 'null' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:717:1: ( ( 'null' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:718:1: ( 'null' )
            {
             before(grammarAccess.getLiteralNullRuleAccess().getValueNullKeyword_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:719:1: ( 'null' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:720:1: 'null'
            {
             before(grammarAccess.getLiteralNullRuleAccess().getValueNullKeyword_0()); 
            match(input,18,FOLLOW_18_in_rule__LiteralNullRule__ValueAssignment1470); 
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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:735:1: rule__LiteralStringRule__ValueAssignment : ( RULE_VALUE_SPECIFICATION_STRING ) ;
    public final void rule__LiteralStringRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:739:1: ( ( RULE_VALUE_SPECIFICATION_STRING ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:740:1: ( RULE_VALUE_SPECIFICATION_STRING )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:740:1: ( RULE_VALUE_SPECIFICATION_STRING )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:741:1: RULE_VALUE_SPECIFICATION_STRING
            {
             before(grammarAccess.getLiteralStringRuleAccess().getValueVALUE_SPECIFICATION_STRINGTerminalRuleCall_0()); 
            match(input,RULE_VALUE_SPECIFICATION_STRING,FOLLOW_RULE_VALUE_SPECIFICATION_STRING_in_rule__LiteralStringRule__ValueAssignment1509); 
             after(grammarAccess.getLiteralStringRuleAccess().getValueVALUE_SPECIFICATION_STRINGTerminalRuleCall_0()); 

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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:750:1: rule__UndefinedRule__ValueAssignment : ( ( '<Undefined>' ) ) ;
    public final void rule__UndefinedRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:754:1: ( ( ( '<Undefined>' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:755:1: ( ( '<Undefined>' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:755:1: ( ( '<Undefined>' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:756:1: ( '<Undefined>' )
            {
             before(grammarAccess.getUndefinedRuleAccess().getValueUndefinedKeyword_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:757:1: ( '<Undefined>' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:758:1: '<Undefined>'
            {
             before(grammarAccess.getUndefinedRuleAccess().getValueUndefinedKeyword_0()); 
            match(input,19,FOLLOW_19_in_rule__UndefinedRule__ValueAssignment1545); 
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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:773:1: rule__VisibilityKind__PublicAssignment_0 : ( ( '+' ) ) ;
    public final void rule__VisibilityKind__PublicAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:777:1: ( ( ( '+' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:778:1: ( ( '+' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:778:1: ( ( '+' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:779:1: ( '+' )
            {
             before(grammarAccess.getVisibilityKindAccess().getPublicPlusSignKeyword_0_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:780:1: ( '+' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:781:1: '+'
            {
             before(grammarAccess.getVisibilityKindAccess().getPublicPlusSignKeyword_0_0()); 
            match(input,20,FOLLOW_20_in_rule__VisibilityKind__PublicAssignment_01589); 
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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:796:1: rule__VisibilityKind__PrivateAssignment_1 : ( ( '-' ) ) ;
    public final void rule__VisibilityKind__PrivateAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:800:1: ( ( ( '-' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:801:1: ( ( '-' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:801:1: ( ( '-' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:802:1: ( '-' )
            {
             before(grammarAccess.getVisibilityKindAccess().getPrivateHyphenMinusKeyword_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:803:1: ( '-' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:804:1: '-'
            {
             before(grammarAccess.getVisibilityKindAccess().getPrivateHyphenMinusKeyword_1_0()); 
            match(input,21,FOLLOW_21_in_rule__VisibilityKind__PrivateAssignment_11633); 
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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:819:1: rule__VisibilityKind__ProtectedAssignment_2 : ( ( '#' ) ) ;
    public final void rule__VisibilityKind__ProtectedAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:823:1: ( ( ( '#' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:824:1: ( ( '#' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:824:1: ( ( '#' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:825:1: ( '#' )
            {
             before(grammarAccess.getVisibilityKindAccess().getProtectedNumberSignKeyword_2_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:826:1: ( '#' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:827:1: '#'
            {
             before(grammarAccess.getVisibilityKindAccess().getProtectedNumberSignKeyword_2_0()); 
            match(input,22,FOLLOW_22_in_rule__VisibilityKind__ProtectedAssignment_21677); 
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
    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:842:1: rule__VisibilityKind__PackageAssignment_3 : ( ( '~' ) ) ;
    public final void rule__VisibilityKind__PackageAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:846:1: ( ( ( '~' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:847:1: ( ( '~' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:847:1: ( ( '~' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:848:1: ( '~' )
            {
             before(grammarAccess.getVisibilityKindAccess().getPackageTildeKeyword_3_0()); 
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:849:1: ( '~' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:850:1: '~'
            {
             before(grammarAccess.getVisibilityKindAccess().getPackageTildeKeyword_3_0()); 
            match(input,23,FOLLOW_23_in_rule__VisibilityKind__PackageAssignment_31721); 
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
    public static final BitSet FOLLOW_rule__AbstractRule__Alternatives_in_ruleAbstractRule94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralBooleanRule_in_entryRuleLiteralBooleanRule121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralBooleanRule128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralBooleanRule__ValueAssignment_in_ruleLiteralBooleanRule154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralIntegerOrUnlimitedNaturalRule_in_entryRuleLiteralIntegerOrUnlimitedNaturalRule181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralIntegerOrUnlimitedNaturalRule188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment_in_ruleLiteralIntegerOrUnlimitedNaturalRule214 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_rule__AbstractRule__Group_0__0_in_rule__AbstractRule__Alternatives550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__UndefinedAssignment_1_in_rule__AbstractRule__Alternatives568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__ValueAssignment_0_2_0_in_rule__AbstractRule__Alternatives_0_2601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__InstanceSpecificationAssignment_0_2_1_in_rule__AbstractRule__Alternatives_0_2619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralBooleanRule_in_rule__AbstractRule__ValueAlternatives_0_2_0_0652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralIntegerOrUnlimitedNaturalRule_in_rule__AbstractRule__ValueAlternatives_0_2_0_0669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralRealRule_in_rule__AbstractRule__ValueAlternatives_0_2_0_0686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralNullRule_in_rule__AbstractRule__ValueAlternatives_0_2_0_0703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralStringRule_in_rule__AbstractRule__ValueAlternatives_0_2_0_0720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__LiteralBooleanRule__ValueAlternatives_0753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__LiteralBooleanRule__ValueAlternatives_0773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibilityKind__PublicAssignment_0_in_rule__VisibilityKind__Alternatives807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibilityKind__PrivateAssignment_1_in_rule__VisibilityKind__Alternatives825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibilityKind__ProtectedAssignment_2_in_rule__VisibilityKind__Alternatives843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibilityKind__PackageAssignment_3_in_rule__VisibilityKind__Alternatives861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__Group_0__0__Impl_in_rule__AbstractRule__Group_0__0892 = new BitSet(new long[]{0x00000000000581F0L});
    public static final BitSet FOLLOW_rule__AbstractRule__Group_0__1_in_rule__AbstractRule__Group_0__0895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__VisibilityAssignment_0_0_in_rule__AbstractRule__Group_0__0__Impl922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__Group_0__1__Impl_in_rule__AbstractRule__Group_0__1953 = new BitSet(new long[]{0x00000000000581F0L});
    public static final BitSet FOLLOW_rule__AbstractRule__Group_0__2_in_rule__AbstractRule__Group_0__1956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__Group_0_1__0_in_rule__AbstractRule__Group_0__1__Impl983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__Group_0__2__Impl_in_rule__AbstractRule__Group_0__21014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__Alternatives_0_2_in_rule__AbstractRule__Group_0__2__Impl1041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__Group_0_1__0__Impl_in_rule__AbstractRule__Group_0_1__01077 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__AbstractRule__Group_0_1__1_in_rule__AbstractRule__Group_0_1__01080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__NameAssignment_0_1_0_in_rule__AbstractRule__Group_0_1__0__Impl1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__Group_0_1__1__Impl_in_rule__AbstractRule__Group_0_1__11137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__AbstractRule__Group_0_1__1__Impl1165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_rule__AbstractRule__VisibilityAssignment_0_01205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VALUE_SPECIFICATION_ID_in_rule__AbstractRule__NameAssignment_0_1_01236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRule__ValueAlternatives_0_2_0_0_in_rule__AbstractRule__ValueAssignment_0_2_01267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AbstractRule__InstanceSpecificationAssignment_0_2_11304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUndefinedRule_in_rule__AbstractRule__UndefinedAssignment_11339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralBooleanRule__ValueAlternatives_0_in_rule__LiteralBooleanRule__ValueAssignment1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VALUE_SPECIFICATION_INT_in_rule__LiteralIntegerOrUnlimitedNaturalRule__ValueAssignment1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VALUE_SPECIFICATION_DOUBLE_in_rule__LiteralRealRule__ValueAssignment1434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__LiteralNullRule__ValueAssignment1470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VALUE_SPECIFICATION_STRING_in_rule__LiteralStringRule__ValueAssignment1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__UndefinedRule__ValueAssignment1545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__VisibilityKind__PublicAssignment_01589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__VisibilityKind__PrivateAssignment_11633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__VisibilityKind__ProtectedAssignment_21677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__VisibilityKind__PackageAssignment_31721 = new BitSet(new long[]{0x0000000000000002L});

}