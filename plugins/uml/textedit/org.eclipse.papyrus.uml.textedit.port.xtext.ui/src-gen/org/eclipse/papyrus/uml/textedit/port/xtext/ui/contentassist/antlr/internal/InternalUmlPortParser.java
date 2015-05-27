package org.eclipse.papyrus.uml.textedit.port.xtext.ui.contentassist.antlr.internal; 

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
import org.eclipse.papyrus.uml.textedit.port.xtext.services.UmlPortGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlPortParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INT", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_INTEGER_VALUE", "RULE_WS", "RULE_ANY_OTHER", "'*'", "'+'", "'-'", "'#'", "'~'", "'readOnly'", "'union'", "'ordered'", "'unique'", "'true'", "'false'", "':'", "'::'", "'['", "']'", "'..'", "'{'", "'}'", "','", "'redefines'", "'subsets'", "'='", "'.'", "'null'", "'none'", "'/'", "'<Undefined>'"
    };
    public static final int RULE_ID=6;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_INTEGER_VALUE=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=4;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__12=12;
    public static final int T__38=38;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalUmlPortParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUmlPortParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUmlPortParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g"; }


     
     	private UmlPortGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(UmlPortGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRulePortRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:60:1: entryRulePortRule : rulePortRule EOF ;
    public final void entryRulePortRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:61:1: ( rulePortRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:62:1: rulePortRule EOF
            {
             before(grammarAccess.getPortRuleRule()); 
            pushFollow(FOLLOW_rulePortRule_in_entryRulePortRule61);
            rulePortRule();

            state._fsp--;

             after(grammarAccess.getPortRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortRule68); 

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
    // $ANTLR end "entryRulePortRule"


    // $ANTLR start "rulePortRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:69:1: rulePortRule : ( ( rule__PortRule__Group__0 ) ) ;
    public final void rulePortRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:73:2: ( ( ( rule__PortRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:74:1: ( ( rule__PortRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:74:1: ( ( rule__PortRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:75:1: ( rule__PortRule__Group__0 )
            {
             before(grammarAccess.getPortRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:76:1: ( rule__PortRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:76:2: rule__PortRule__Group__0
            {
            pushFollow(FOLLOW_rule__PortRule__Group__0_in_rulePortRule94);
            rule__PortRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPortRuleAccess().getGroup()); 

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
    // $ANTLR end "rulePortRule"


    // $ANTLR start "entryRuleVisibilityRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:88:1: entryRuleVisibilityRule : ruleVisibilityRule EOF ;
    public final void entryRuleVisibilityRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:89:1: ( ruleVisibilityRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:90:1: ruleVisibilityRule EOF
            {
             before(grammarAccess.getVisibilityRuleRule()); 
            pushFollow(FOLLOW_ruleVisibilityRule_in_entryRuleVisibilityRule121);
            ruleVisibilityRule();

            state._fsp--;

             after(grammarAccess.getVisibilityRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVisibilityRule128); 

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
    // $ANTLR end "entryRuleVisibilityRule"


    // $ANTLR start "ruleVisibilityRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:97:1: ruleVisibilityRule : ( ( rule__VisibilityRule__VisibilityAssignment ) ) ;
    public final void ruleVisibilityRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:101:2: ( ( ( rule__VisibilityRule__VisibilityAssignment ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:102:1: ( ( rule__VisibilityRule__VisibilityAssignment ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:102:1: ( ( rule__VisibilityRule__VisibilityAssignment ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:103:1: ( rule__VisibilityRule__VisibilityAssignment )
            {
             before(grammarAccess.getVisibilityRuleAccess().getVisibilityAssignment()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:104:1: ( rule__VisibilityRule__VisibilityAssignment )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:104:2: rule__VisibilityRule__VisibilityAssignment
            {
            pushFollow(FOLLOW_rule__VisibilityRule__VisibilityAssignment_in_ruleVisibilityRule154);
            rule__VisibilityRule__VisibilityAssignment();

            state._fsp--;


            }

             after(grammarAccess.getVisibilityRuleAccess().getVisibilityAssignment()); 

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
    // $ANTLR end "ruleVisibilityRule"


    // $ANTLR start "entryRuleTypeRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:116:1: entryRuleTypeRule : ruleTypeRule EOF ;
    public final void entryRuleTypeRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:117:1: ( ruleTypeRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:118:1: ruleTypeRule EOF
            {
             before(grammarAccess.getTypeRuleRule()); 
            pushFollow(FOLLOW_ruleTypeRule_in_entryRuleTypeRule181);
            ruleTypeRule();

            state._fsp--;

             after(grammarAccess.getTypeRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRule188); 

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
    // $ANTLR end "entryRuleTypeRule"


    // $ANTLR start "ruleTypeRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:125:1: ruleTypeRule : ( ( rule__TypeRule__Group__0 ) ) ;
    public final void ruleTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:129:2: ( ( ( rule__TypeRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:130:1: ( ( rule__TypeRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:130:1: ( ( rule__TypeRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:131:1: ( rule__TypeRule__Group__0 )
            {
             before(grammarAccess.getTypeRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:132:1: ( rule__TypeRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:132:2: rule__TypeRule__Group__0
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__0_in_ruleTypeRule214);
            rule__TypeRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypeRuleAccess().getGroup()); 

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
    // $ANTLR end "ruleTypeRule"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:144:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:145:1: ( ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:146:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName241);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName248); 

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:153:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:157:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:158:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:158:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:159:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:160:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:160:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName274);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleMultiplicityRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:172:1: entryRuleMultiplicityRule : ruleMultiplicityRule EOF ;
    public final void entryRuleMultiplicityRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:173:1: ( ruleMultiplicityRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:174:1: ruleMultiplicityRule EOF
            {
             before(grammarAccess.getMultiplicityRuleRule()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule301);
            ruleMultiplicityRule();

            state._fsp--;

             after(grammarAccess.getMultiplicityRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicityRule308); 

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
    // $ANTLR end "entryRuleMultiplicityRule"


    // $ANTLR start "ruleMultiplicityRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:181:1: ruleMultiplicityRule : ( ( rule__MultiplicityRule__Group__0 ) ) ;
    public final void ruleMultiplicityRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:185:2: ( ( ( rule__MultiplicityRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:186:1: ( ( rule__MultiplicityRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:186:1: ( ( rule__MultiplicityRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:187:1: ( rule__MultiplicityRule__Group__0 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:188:1: ( rule__MultiplicityRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:188:2: rule__MultiplicityRule__Group__0
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__0_in_ruleMultiplicityRule334);
            rule__MultiplicityRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicityRuleAccess().getGroup()); 

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
    // $ANTLR end "ruleMultiplicityRule"


    // $ANTLR start "entryRuleBoundSpecification"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:200:1: entryRuleBoundSpecification : ruleBoundSpecification EOF ;
    public final void entryRuleBoundSpecification() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:201:1: ( ruleBoundSpecification EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:202:1: ruleBoundSpecification EOF
            {
             before(grammarAccess.getBoundSpecificationRule()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification361);
            ruleBoundSpecification();

            state._fsp--;

             after(grammarAccess.getBoundSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoundSpecification368); 

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
    // $ANTLR end "entryRuleBoundSpecification"


    // $ANTLR start "ruleBoundSpecification"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:209:1: ruleBoundSpecification : ( ( rule__BoundSpecification__ValueAssignment ) ) ;
    public final void ruleBoundSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:213:2: ( ( ( rule__BoundSpecification__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:214:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:214:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:215:1: ( rule__BoundSpecification__ValueAssignment )
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:216:1: ( rule__BoundSpecification__ValueAssignment )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:216:2: rule__BoundSpecification__ValueAssignment
            {
            pushFollow(FOLLOW_rule__BoundSpecification__ValueAssignment_in_ruleBoundSpecification394);
            rule__BoundSpecification__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getBoundSpecificationAccess().getValueAssignment()); 

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
    // $ANTLR end "ruleBoundSpecification"


    // $ANTLR start "entryRuleUnlimitedLiteral"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:228:1: entryRuleUnlimitedLiteral : ruleUnlimitedLiteral EOF ;
    public final void entryRuleUnlimitedLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:229:1: ( ruleUnlimitedLiteral EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:230:1: ruleUnlimitedLiteral EOF
            {
             before(grammarAccess.getUnlimitedLiteralRule()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteral_in_entryRuleUnlimitedLiteral421);
            ruleUnlimitedLiteral();

            state._fsp--;

             after(grammarAccess.getUnlimitedLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedLiteral428); 

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
    // $ANTLR end "entryRuleUnlimitedLiteral"


    // $ANTLR start "ruleUnlimitedLiteral"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:237:1: ruleUnlimitedLiteral : ( ( rule__UnlimitedLiteral__Alternatives ) ) ;
    public final void ruleUnlimitedLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:241:2: ( ( ( rule__UnlimitedLiteral__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:242:1: ( ( rule__UnlimitedLiteral__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:242:1: ( ( rule__UnlimitedLiteral__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:243:1: ( rule__UnlimitedLiteral__Alternatives )
            {
             before(grammarAccess.getUnlimitedLiteralAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:244:1: ( rule__UnlimitedLiteral__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:244:2: rule__UnlimitedLiteral__Alternatives
            {
            pushFollow(FOLLOW_rule__UnlimitedLiteral__Alternatives_in_ruleUnlimitedLiteral454);
            rule__UnlimitedLiteral__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getUnlimitedLiteralAccess().getAlternatives()); 

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
    // $ANTLR end "ruleUnlimitedLiteral"


    // $ANTLR start "entryRuleStringLiteral"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:256:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:257:1: ( ruleStringLiteral EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:258:1: ruleStringLiteral EOF
            {
             before(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral481);
            ruleStringLiteral();

            state._fsp--;

             after(grammarAccess.getStringLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral488); 

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
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:265:1: ruleStringLiteral : ( RULE_STRING ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:269:2: ( ( RULE_STRING ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:270:1: ( RULE_STRING )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:270:1: ( RULE_STRING )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:271:1: RULE_STRING
            {
             before(grammarAccess.getStringLiteralAccess().getSTRINGTerminalRuleCall()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral514); 
             after(grammarAccess.getStringLiteralAccess().getSTRINGTerminalRuleCall()); 

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
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleModifiersRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:284:1: entryRuleModifiersRule : ruleModifiersRule EOF ;
    public final void entryRuleModifiersRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:285:1: ( ruleModifiersRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:286:1: ruleModifiersRule EOF
            {
             before(grammarAccess.getModifiersRuleRule()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule540);
            ruleModifiersRule();

            state._fsp--;

             after(grammarAccess.getModifiersRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifiersRule547); 

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
    // $ANTLR end "entryRuleModifiersRule"


    // $ANTLR start "ruleModifiersRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:293:1: ruleModifiersRule : ( ( rule__ModifiersRule__Group__0 ) ) ;
    public final void ruleModifiersRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:297:2: ( ( ( rule__ModifiersRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:298:1: ( ( rule__ModifiersRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:298:1: ( ( rule__ModifiersRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:299:1: ( rule__ModifiersRule__Group__0 )
            {
             before(grammarAccess.getModifiersRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:300:1: ( rule__ModifiersRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:300:2: rule__ModifiersRule__Group__0
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__0_in_ruleModifiersRule573);
            rule__ModifiersRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModifiersRuleAccess().getGroup()); 

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
    // $ANTLR end "ruleModifiersRule"


    // $ANTLR start "entryRuleModifierSpecification"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:312:1: entryRuleModifierSpecification : ruleModifierSpecification EOF ;
    public final void entryRuleModifierSpecification() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:313:1: ( ruleModifierSpecification EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:314:1: ruleModifierSpecification EOF
            {
             before(grammarAccess.getModifierSpecificationRule()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification600);
            ruleModifierSpecification();

            state._fsp--;

             after(grammarAccess.getModifierSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifierSpecification607); 

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
    // $ANTLR end "entryRuleModifierSpecification"


    // $ANTLR start "ruleModifierSpecification"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:321:1: ruleModifierSpecification : ( ( rule__ModifierSpecification__Alternatives ) ) ;
    public final void ruleModifierSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:325:2: ( ( ( rule__ModifierSpecification__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:326:1: ( ( rule__ModifierSpecification__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:326:1: ( ( rule__ModifierSpecification__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:327:1: ( rule__ModifierSpecification__Alternatives )
            {
             before(grammarAccess.getModifierSpecificationAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:328:1: ( rule__ModifierSpecification__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:328:2: rule__ModifierSpecification__Alternatives
            {
            pushFollow(FOLLOW_rule__ModifierSpecification__Alternatives_in_ruleModifierSpecification633);
            rule__ModifierSpecification__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getModifierSpecificationAccess().getAlternatives()); 

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
    // $ANTLR end "ruleModifierSpecification"


    // $ANTLR start "entryRuleRedefinesRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:340:1: entryRuleRedefinesRule : ruleRedefinesRule EOF ;
    public final void entryRuleRedefinesRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:341:1: ( ruleRedefinesRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:342:1: ruleRedefinesRule EOF
            {
             before(grammarAccess.getRedefinesRuleRule()); 
            pushFollow(FOLLOW_ruleRedefinesRule_in_entryRuleRedefinesRule660);
            ruleRedefinesRule();

            state._fsp--;

             after(grammarAccess.getRedefinesRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRedefinesRule667); 

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
    // $ANTLR end "entryRuleRedefinesRule"


    // $ANTLR start "ruleRedefinesRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:349:1: ruleRedefinesRule : ( ( rule__RedefinesRule__Group__0 ) ) ;
    public final void ruleRedefinesRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:353:2: ( ( ( rule__RedefinesRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:354:1: ( ( rule__RedefinesRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:354:1: ( ( rule__RedefinesRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:355:1: ( rule__RedefinesRule__Group__0 )
            {
             before(grammarAccess.getRedefinesRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:356:1: ( rule__RedefinesRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:356:2: rule__RedefinesRule__Group__0
            {
            pushFollow(FOLLOW_rule__RedefinesRule__Group__0_in_ruleRedefinesRule693);
            rule__RedefinesRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRedefinesRuleAccess().getGroup()); 

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
    // $ANTLR end "ruleRedefinesRule"


    // $ANTLR start "entryRuleSubsetsRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:368:1: entryRuleSubsetsRule : ruleSubsetsRule EOF ;
    public final void entryRuleSubsetsRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:369:1: ( ruleSubsetsRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:370:1: ruleSubsetsRule EOF
            {
             before(grammarAccess.getSubsetsRuleRule()); 
            pushFollow(FOLLOW_ruleSubsetsRule_in_entryRuleSubsetsRule720);
            ruleSubsetsRule();

            state._fsp--;

             after(grammarAccess.getSubsetsRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubsetsRule727); 

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
    // $ANTLR end "entryRuleSubsetsRule"


    // $ANTLR start "ruleSubsetsRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:377:1: ruleSubsetsRule : ( ( rule__SubsetsRule__Group__0 ) ) ;
    public final void ruleSubsetsRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:381:2: ( ( ( rule__SubsetsRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:382:1: ( ( rule__SubsetsRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:382:1: ( ( rule__SubsetsRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:383:1: ( rule__SubsetsRule__Group__0 )
            {
             before(grammarAccess.getSubsetsRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:384:1: ( rule__SubsetsRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:384:2: rule__SubsetsRule__Group__0
            {
            pushFollow(FOLLOW_rule__SubsetsRule__Group__0_in_ruleSubsetsRule753);
            rule__SubsetsRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSubsetsRuleAccess().getGroup()); 

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
    // $ANTLR end "ruleSubsetsRule"


    // $ANTLR start "entryRuleDefaultValueRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:396:1: entryRuleDefaultValueRule : ruleDefaultValueRule EOF ;
    public final void entryRuleDefaultValueRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:397:1: ( ruleDefaultValueRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:398:1: ruleDefaultValueRule EOF
            {
             before(grammarAccess.getDefaultValueRuleRule()); 
            pushFollow(FOLLOW_ruleDefaultValueRule_in_entryRuleDefaultValueRule780);
            ruleDefaultValueRule();

            state._fsp--;

             after(grammarAccess.getDefaultValueRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultValueRule787); 

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
    // $ANTLR end "entryRuleDefaultValueRule"


    // $ANTLR start "ruleDefaultValueRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:405:1: ruleDefaultValueRule : ( ( rule__DefaultValueRule__Group__0 ) ) ;
    public final void ruleDefaultValueRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:409:2: ( ( ( rule__DefaultValueRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:410:1: ( ( rule__DefaultValueRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:410:1: ( ( rule__DefaultValueRule__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:411:1: ( rule__DefaultValueRule__Group__0 )
            {
             before(grammarAccess.getDefaultValueRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:412:1: ( rule__DefaultValueRule__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:412:2: rule__DefaultValueRule__Group__0
            {
            pushFollow(FOLLOW_rule__DefaultValueRule__Group__0_in_ruleDefaultValueRule813);
            rule__DefaultValueRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDefaultValueRuleAccess().getGroup()); 

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
    // $ANTLR end "ruleDefaultValueRule"


    // $ANTLR start "entryRuleValue"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:424:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:425:1: ( ruleValue EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:426:1: ruleValue EOF
            {
             before(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue840);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue847); 

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
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:433:1: ruleValue : ( ( rule__Value__Alternatives ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:437:2: ( ( ( rule__Value__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:438:1: ( ( rule__Value__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:438:1: ( ( rule__Value__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:439:1: ( rule__Value__Alternatives )
            {
             before(grammarAccess.getValueAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:440:1: ( rule__Value__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:440:2: rule__Value__Alternatives
            {
            pushFollow(FOLLOW_rule__Value__Alternatives_in_ruleValue873);
            rule__Value__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getValueAccess().getAlternatives()); 

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
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleIntValue"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:452:1: entryRuleIntValue : ruleIntValue EOF ;
    public final void entryRuleIntValue() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:453:1: ( ruleIntValue EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:454:1: ruleIntValue EOF
            {
             before(grammarAccess.getIntValueRule()); 
            pushFollow(FOLLOW_ruleIntValue_in_entryRuleIntValue900);
            ruleIntValue();

            state._fsp--;

             after(grammarAccess.getIntValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntValue907); 

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
    // $ANTLR end "entryRuleIntValue"


    // $ANTLR start "ruleIntValue"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:461:1: ruleIntValue : ( ( rule__IntValue__LiteralIntegerAssignment ) ) ;
    public final void ruleIntValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:465:2: ( ( ( rule__IntValue__LiteralIntegerAssignment ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:466:1: ( ( rule__IntValue__LiteralIntegerAssignment ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:466:1: ( ( rule__IntValue__LiteralIntegerAssignment ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:467:1: ( rule__IntValue__LiteralIntegerAssignment )
            {
             before(grammarAccess.getIntValueAccess().getLiteralIntegerAssignment()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:468:1: ( rule__IntValue__LiteralIntegerAssignment )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:468:2: rule__IntValue__LiteralIntegerAssignment
            {
            pushFollow(FOLLOW_rule__IntValue__LiteralIntegerAssignment_in_ruleIntValue933);
            rule__IntValue__LiteralIntegerAssignment();

            state._fsp--;


            }

             after(grammarAccess.getIntValueAccess().getLiteralIntegerAssignment()); 

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
    // $ANTLR end "ruleIntValue"


    // $ANTLR start "entryRuleStringValue"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:480:1: entryRuleStringValue : ruleStringValue EOF ;
    public final void entryRuleStringValue() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:481:1: ( ruleStringValue EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:482:1: ruleStringValue EOF
            {
             before(grammarAccess.getStringValueRule()); 
            pushFollow(FOLLOW_ruleStringValue_in_entryRuleStringValue960);
            ruleStringValue();

            state._fsp--;

             after(grammarAccess.getStringValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringValue967); 

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
    // $ANTLR end "entryRuleStringValue"


    // $ANTLR start "ruleStringValue"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:489:1: ruleStringValue : ( ( rule__StringValue__LiteralStringAssignment ) ) ;
    public final void ruleStringValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:493:2: ( ( ( rule__StringValue__LiteralStringAssignment ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:494:1: ( ( rule__StringValue__LiteralStringAssignment ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:494:1: ( ( rule__StringValue__LiteralStringAssignment ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:495:1: ( rule__StringValue__LiteralStringAssignment )
            {
             before(grammarAccess.getStringValueAccess().getLiteralStringAssignment()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:496:1: ( rule__StringValue__LiteralStringAssignment )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:496:2: rule__StringValue__LiteralStringAssignment
            {
            pushFollow(FOLLOW_rule__StringValue__LiteralStringAssignment_in_ruleStringValue993);
            rule__StringValue__LiteralStringAssignment();

            state._fsp--;


            }

             after(grammarAccess.getStringValueAccess().getLiteralStringAssignment()); 

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
    // $ANTLR end "ruleStringValue"


    // $ANTLR start "entryRuleBooleanValue"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:508:1: entryRuleBooleanValue : ruleBooleanValue EOF ;
    public final void entryRuleBooleanValue() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:509:1: ( ruleBooleanValue EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:510:1: ruleBooleanValue EOF
            {
             before(grammarAccess.getBooleanValueRule()); 
            pushFollow(FOLLOW_ruleBooleanValue_in_entryRuleBooleanValue1020);
            ruleBooleanValue();

            state._fsp--;

             after(grammarAccess.getBooleanValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanValue1027); 

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
    // $ANTLR end "entryRuleBooleanValue"


    // $ANTLR start "ruleBooleanValue"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:517:1: ruleBooleanValue : ( ( rule__BooleanValue__LiteralBooleanAssignment ) ) ;
    public final void ruleBooleanValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:521:2: ( ( ( rule__BooleanValue__LiteralBooleanAssignment ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:522:1: ( ( rule__BooleanValue__LiteralBooleanAssignment ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:522:1: ( ( rule__BooleanValue__LiteralBooleanAssignment ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:523:1: ( rule__BooleanValue__LiteralBooleanAssignment )
            {
             before(grammarAccess.getBooleanValueAccess().getLiteralBooleanAssignment()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:524:1: ( rule__BooleanValue__LiteralBooleanAssignment )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:524:2: rule__BooleanValue__LiteralBooleanAssignment
            {
            pushFollow(FOLLOW_rule__BooleanValue__LiteralBooleanAssignment_in_ruleBooleanValue1053);
            rule__BooleanValue__LiteralBooleanAssignment();

            state._fsp--;


            }

             after(grammarAccess.getBooleanValueAccess().getLiteralBooleanAssignment()); 

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
    // $ANTLR end "ruleBooleanValue"


    // $ANTLR start "entryRuleRealValue"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:536:1: entryRuleRealValue : ruleRealValue EOF ;
    public final void entryRuleRealValue() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:537:1: ( ruleRealValue EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:538:1: ruleRealValue EOF
            {
             before(grammarAccess.getRealValueRule()); 
            pushFollow(FOLLOW_ruleRealValue_in_entryRuleRealValue1080);
            ruleRealValue();

            state._fsp--;

             after(grammarAccess.getRealValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealValue1087); 

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
    // $ANTLR end "entryRuleRealValue"


    // $ANTLR start "ruleRealValue"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:545:1: ruleRealValue : ( ( rule__RealValue__Alternatives ) ) ;
    public final void ruleRealValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:549:2: ( ( ( rule__RealValue__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:550:1: ( ( rule__RealValue__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:550:1: ( ( rule__RealValue__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:551:1: ( rule__RealValue__Alternatives )
            {
             before(grammarAccess.getRealValueAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:552:1: ( rule__RealValue__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:552:2: rule__RealValue__Alternatives
            {
            pushFollow(FOLLOW_rule__RealValue__Alternatives_in_ruleRealValue1113);
            rule__RealValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getRealValueAccess().getAlternatives()); 

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
    // $ANTLR end "ruleRealValue"


    // $ANTLR start "entryRuleNullValue"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:564:1: entryRuleNullValue : ruleNullValue EOF ;
    public final void entryRuleNullValue() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:565:1: ( ruleNullValue EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:566:1: ruleNullValue EOF
            {
             before(grammarAccess.getNullValueRule()); 
            pushFollow(FOLLOW_ruleNullValue_in_entryRuleNullValue1140);
            ruleNullValue();

            state._fsp--;

             after(grammarAccess.getNullValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullValue1147); 

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
    // $ANTLR end "entryRuleNullValue"


    // $ANTLR start "ruleNullValue"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:573:1: ruleNullValue : ( ( rule__NullValue__Group__0 ) ) ;
    public final void ruleNullValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:577:2: ( ( ( rule__NullValue__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:578:1: ( ( rule__NullValue__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:578:1: ( ( rule__NullValue__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:579:1: ( rule__NullValue__Group__0 )
            {
             before(grammarAccess.getNullValueAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:580:1: ( rule__NullValue__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:580:2: rule__NullValue__Group__0
            {
            pushFollow(FOLLOW_rule__NullValue__Group__0_in_ruleNullValue1173);
            rule__NullValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNullValueAccess().getGroup()); 

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
    // $ANTLR end "ruleNullValue"


    // $ANTLR start "entryRuleNoValue"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:592:1: entryRuleNoValue : ruleNoValue EOF ;
    public final void entryRuleNoValue() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:593:1: ( ruleNoValue EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:594:1: ruleNoValue EOF
            {
             before(grammarAccess.getNoValueRule()); 
            pushFollow(FOLLOW_ruleNoValue_in_entryRuleNoValue1200);
            ruleNoValue();

            state._fsp--;

             after(grammarAccess.getNoValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNoValue1207); 

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
    // $ANTLR end "entryRuleNoValue"


    // $ANTLR start "ruleNoValue"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:601:1: ruleNoValue : ( ( rule__NoValue__Group__0 ) ) ;
    public final void ruleNoValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:605:2: ( ( ( rule__NoValue__Group__0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:606:1: ( ( rule__NoValue__Group__0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:606:1: ( ( rule__NoValue__Group__0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:607:1: ( rule__NoValue__Group__0 )
            {
             before(grammarAccess.getNoValueAccess().getGroup()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:608:1: ( rule__NoValue__Group__0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:608:2: rule__NoValue__Group__0
            {
            pushFollow(FOLLOW_rule__NoValue__Group__0_in_ruleNoValue1233);
            rule__NoValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNoValueAccess().getGroup()); 

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
    // $ANTLR end "ruleNoValue"


    // $ANTLR start "ruleVisibilityKind"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:621:1: ruleVisibilityKind : ( ( rule__VisibilityKind__Alternatives ) ) ;
    public final void ruleVisibilityKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:625:1: ( ( ( rule__VisibilityKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:626:1: ( ( rule__VisibilityKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:626:1: ( ( rule__VisibilityKind__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:627:1: ( rule__VisibilityKind__Alternatives )
            {
             before(grammarAccess.getVisibilityKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:628:1: ( rule__VisibilityKind__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:628:2: rule__VisibilityKind__Alternatives
            {
            pushFollow(FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind1270);
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


    // $ANTLR start "ruleModifierKind"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:640:1: ruleModifierKind : ( ( rule__ModifierKind__Alternatives ) ) ;
    public final void ruleModifierKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:644:1: ( ( ( rule__ModifierKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:645:1: ( ( rule__ModifierKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:645:1: ( ( rule__ModifierKind__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:646:1: ( rule__ModifierKind__Alternatives )
            {
             before(grammarAccess.getModifierKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:647:1: ( rule__ModifierKind__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:647:2: rule__ModifierKind__Alternatives
            {
            pushFollow(FOLLOW_rule__ModifierKind__Alternatives_in_ruleModifierKind1306);
            rule__ModifierKind__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getModifierKindAccess().getAlternatives()); 

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
    // $ANTLR end "ruleModifierKind"


    // $ANTLR start "ruleBooleanLiterals"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:659:1: ruleBooleanLiterals : ( ( rule__BooleanLiterals__Alternatives ) ) ;
    public final void ruleBooleanLiterals() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:663:1: ( ( ( rule__BooleanLiterals__Alternatives ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:664:1: ( ( rule__BooleanLiterals__Alternatives ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:664:1: ( ( rule__BooleanLiterals__Alternatives ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:665:1: ( rule__BooleanLiterals__Alternatives )
            {
             before(grammarAccess.getBooleanLiteralsAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:666:1: ( rule__BooleanLiterals__Alternatives )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:666:2: rule__BooleanLiterals__Alternatives
            {
            pushFollow(FOLLOW_rule__BooleanLiterals__Alternatives_in_ruleBooleanLiterals1342);
            rule__BooleanLiterals__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBooleanLiteralsAccess().getAlternatives()); 

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
    // $ANTLR end "ruleBooleanLiterals"


    // $ANTLR start "rule__PortRule__Alternatives_3_2"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:677:1: rule__PortRule__Alternatives_3_2 : ( ( ( rule__PortRule__TypeAssignment_3_2_0 ) ) | ( ( rule__PortRule__TypeUndefinedAssignment_3_2_1 ) ) );
    public final void rule__PortRule__Alternatives_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:681:1: ( ( ( rule__PortRule__TypeAssignment_3_2_0 ) ) | ( ( rule__PortRule__TypeUndefinedAssignment_3_2_1 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            else if ( (LA1_0==38) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:682:1: ( ( rule__PortRule__TypeAssignment_3_2_0 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:682:1: ( ( rule__PortRule__TypeAssignment_3_2_0 ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:683:1: ( rule__PortRule__TypeAssignment_3_2_0 )
                    {
                     before(grammarAccess.getPortRuleAccess().getTypeAssignment_3_2_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:684:1: ( rule__PortRule__TypeAssignment_3_2_0 )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:684:2: rule__PortRule__TypeAssignment_3_2_0
                    {
                    pushFollow(FOLLOW_rule__PortRule__TypeAssignment_3_2_0_in_rule__PortRule__Alternatives_3_21377);
                    rule__PortRule__TypeAssignment_3_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPortRuleAccess().getTypeAssignment_3_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:688:6: ( ( rule__PortRule__TypeUndefinedAssignment_3_2_1 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:688:6: ( ( rule__PortRule__TypeUndefinedAssignment_3_2_1 ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:689:1: ( rule__PortRule__TypeUndefinedAssignment_3_2_1 )
                    {
                     before(grammarAccess.getPortRuleAccess().getTypeUndefinedAssignment_3_2_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:690:1: ( rule__PortRule__TypeUndefinedAssignment_3_2_1 )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:690:2: rule__PortRule__TypeUndefinedAssignment_3_2_1
                    {
                    pushFollow(FOLLOW_rule__PortRule__TypeUndefinedAssignment_3_2_1_in_rule__PortRule__Alternatives_3_21395);
                    rule__PortRule__TypeUndefinedAssignment_3_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getPortRuleAccess().getTypeUndefinedAssignment_3_2_1()); 

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
    // $ANTLR end "rule__PortRule__Alternatives_3_2"


    // $ANTLR start "rule__BoundSpecification__ValueAlternatives_0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:699:1: rule__BoundSpecification__ValueAlternatives_0 : ( ( ruleUnlimitedLiteral ) | ( ruleStringLiteral ) );
    public final void rule__BoundSpecification__ValueAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:703:1: ( ( ruleUnlimitedLiteral ) | ( ruleStringLiteral ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_INT||LA2_0==12) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_STRING) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:704:1: ( ruleUnlimitedLiteral )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:704:1: ( ruleUnlimitedLiteral )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:705:1: ruleUnlimitedLiteral
                    {
                     before(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_ruleUnlimitedLiteral_in_rule__BoundSpecification__ValueAlternatives_01428);
                    ruleUnlimitedLiteral();

                    state._fsp--;

                     after(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:710:6: ( ruleStringLiteral )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:710:6: ( ruleStringLiteral )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:711:1: ruleStringLiteral
                    {
                     before(grammarAccess.getBoundSpecificationAccess().getValueStringLiteralParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_ruleStringLiteral_in_rule__BoundSpecification__ValueAlternatives_01445);
                    ruleStringLiteral();

                    state._fsp--;

                     after(grammarAccess.getBoundSpecificationAccess().getValueStringLiteralParserRuleCall_0_1()); 

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
    // $ANTLR end "rule__BoundSpecification__ValueAlternatives_0"


    // $ANTLR start "rule__UnlimitedLiteral__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:721:1: rule__UnlimitedLiteral__Alternatives : ( ( RULE_INT ) | ( '*' ) );
    public final void rule__UnlimitedLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:725:1: ( ( RULE_INT ) | ( '*' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INT) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:726:1: ( RULE_INT )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:726:1: ( RULE_INT )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:727:1: RULE_INT
                    {
                     before(grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); 
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__UnlimitedLiteral__Alternatives1477); 
                     after(grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:732:6: ( '*' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:732:6: ( '*' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:733:1: '*'
                    {
                     before(grammarAccess.getUnlimitedLiteralAccess().getAsteriskKeyword_1()); 
                    match(input,12,FOLLOW_12_in_rule__UnlimitedLiteral__Alternatives1495); 
                     after(grammarAccess.getUnlimitedLiteralAccess().getAsteriskKeyword_1()); 

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
    // $ANTLR end "rule__UnlimitedLiteral__Alternatives"


    // $ANTLR start "rule__ModifierSpecification__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:745:1: rule__ModifierSpecification__Alternatives : ( ( ( rule__ModifierSpecification__ValueAssignment_0 ) ) | ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) ) | ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) ) );
    public final void rule__ModifierSpecification__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:749:1: ( ( ( rule__ModifierSpecification__ValueAssignment_0 ) ) | ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) ) | ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 17:
            case 18:
            case 19:
            case 20:
                {
                alt4=1;
                }
                break;
            case 31:
                {
                alt4=2;
                }
                break;
            case 32:
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
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:750:1: ( ( rule__ModifierSpecification__ValueAssignment_0 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:750:1: ( ( rule__ModifierSpecification__ValueAssignment_0 ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:751:1: ( rule__ModifierSpecification__ValueAssignment_0 )
                    {
                     before(grammarAccess.getModifierSpecificationAccess().getValueAssignment_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:752:1: ( rule__ModifierSpecification__ValueAssignment_0 )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:752:2: rule__ModifierSpecification__ValueAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ModifierSpecification__ValueAssignment_0_in_rule__ModifierSpecification__Alternatives1529);
                    rule__ModifierSpecification__ValueAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModifierSpecificationAccess().getValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:756:6: ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:756:6: ( ( rule__ModifierSpecification__RedefinesAssignment_1 ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:757:1: ( rule__ModifierSpecification__RedefinesAssignment_1 )
                    {
                     before(grammarAccess.getModifierSpecificationAccess().getRedefinesAssignment_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:758:1: ( rule__ModifierSpecification__RedefinesAssignment_1 )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:758:2: rule__ModifierSpecification__RedefinesAssignment_1
                    {
                    pushFollow(FOLLOW_rule__ModifierSpecification__RedefinesAssignment_1_in_rule__ModifierSpecification__Alternatives1547);
                    rule__ModifierSpecification__RedefinesAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getModifierSpecificationAccess().getRedefinesAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:762:6: ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:762:6: ( ( rule__ModifierSpecification__SubsetsAssignment_2 ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:763:1: ( rule__ModifierSpecification__SubsetsAssignment_2 )
                    {
                     before(grammarAccess.getModifierSpecificationAccess().getSubsetsAssignment_2()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:764:1: ( rule__ModifierSpecification__SubsetsAssignment_2 )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:764:2: rule__ModifierSpecification__SubsetsAssignment_2
                    {
                    pushFollow(FOLLOW_rule__ModifierSpecification__SubsetsAssignment_2_in_rule__ModifierSpecification__Alternatives1565);
                    rule__ModifierSpecification__SubsetsAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getModifierSpecificationAccess().getSubsetsAssignment_2()); 

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
    // $ANTLR end "rule__ModifierSpecification__Alternatives"


    // $ANTLR start "rule__Value__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:773:1: rule__Value__Alternatives : ( ( ruleIntValue ) | ( ruleStringValue ) | ( ruleBooleanValue ) | ( ruleRealValue ) | ( ruleNullValue ) | ( ruleNoValue ) );
    public final void rule__Value__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:777:1: ( ( ruleIntValue ) | ( ruleStringValue ) | ( ruleBooleanValue ) | ( ruleRealValue ) | ( ruleNullValue ) | ( ruleNoValue ) )
            int alt5=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==34) ) {
                    alt5=4;
                }
                else if ( (LA5_1==EOF) ) {
                    alt5=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
                {
                alt5=2;
                }
                break;
            case 21:
            case 22:
                {
                alt5=3;
                }
                break;
            case 34:
                {
                alt5=4;
                }
                break;
            case 35:
                {
                alt5=5;
                }
                break;
            case 36:
                {
                alt5=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:778:1: ( ruleIntValue )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:778:1: ( ruleIntValue )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:779:1: ruleIntValue
                    {
                     before(grammarAccess.getValueAccess().getIntValueParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIntValue_in_rule__Value__Alternatives1598);
                    ruleIntValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getIntValueParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:784:6: ( ruleStringValue )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:784:6: ( ruleStringValue )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:785:1: ruleStringValue
                    {
                     before(grammarAccess.getValueAccess().getStringValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleStringValue_in_rule__Value__Alternatives1615);
                    ruleStringValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getStringValueParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:790:6: ( ruleBooleanValue )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:790:6: ( ruleBooleanValue )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:791:1: ruleBooleanValue
                    {
                     before(grammarAccess.getValueAccess().getBooleanValueParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleBooleanValue_in_rule__Value__Alternatives1632);
                    ruleBooleanValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getBooleanValueParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:796:6: ( ruleRealValue )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:796:6: ( ruleRealValue )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:797:1: ruleRealValue
                    {
                     before(grammarAccess.getValueAccess().getRealValueParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleRealValue_in_rule__Value__Alternatives1649);
                    ruleRealValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getRealValueParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:802:6: ( ruleNullValue )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:802:6: ( ruleNullValue )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:803:1: ruleNullValue
                    {
                     before(grammarAccess.getValueAccess().getNullValueParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleNullValue_in_rule__Value__Alternatives1666);
                    ruleNullValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getNullValueParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:808:6: ( ruleNoValue )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:808:6: ( ruleNoValue )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:809:1: ruleNoValue
                    {
                     before(grammarAccess.getValueAccess().getNoValueParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleNoValue_in_rule__Value__Alternatives1683);
                    ruleNoValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getNoValueParserRuleCall_5()); 

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
    // $ANTLR end "rule__Value__Alternatives"


    // $ANTLR start "rule__RealValue__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:819:1: rule__RealValue__Alternatives : ( ( ( rule__RealValue__Group_0__0 ) ) | ( ( rule__RealValue__Group_1__0 ) ) | ( ( rule__RealValue__Group_2__0 ) ) );
    public final void rule__RealValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:823:1: ( ( ( rule__RealValue__Group_0__0 ) ) | ( ( rule__RealValue__Group_1__0 ) ) | ( ( rule__RealValue__Group_2__0 ) ) )
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_INT) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==34) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==EOF) ) {
                        alt6=1;
                    }
                    else if ( (LA6_3==RULE_INT) ) {
                        alt6=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA6_0==34) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:824:1: ( ( rule__RealValue__Group_0__0 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:824:1: ( ( rule__RealValue__Group_0__0 ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:825:1: ( rule__RealValue__Group_0__0 )
                    {
                     before(grammarAccess.getRealValueAccess().getGroup_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:826:1: ( rule__RealValue__Group_0__0 )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:826:2: rule__RealValue__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__RealValue__Group_0__0_in_rule__RealValue__Alternatives1715);
                    rule__RealValue__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getRealValueAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:830:6: ( ( rule__RealValue__Group_1__0 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:830:6: ( ( rule__RealValue__Group_1__0 ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:831:1: ( rule__RealValue__Group_1__0 )
                    {
                     before(grammarAccess.getRealValueAccess().getGroup_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:832:1: ( rule__RealValue__Group_1__0 )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:832:2: rule__RealValue__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__RealValue__Group_1__0_in_rule__RealValue__Alternatives1733);
                    rule__RealValue__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getRealValueAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:836:6: ( ( rule__RealValue__Group_2__0 ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:836:6: ( ( rule__RealValue__Group_2__0 ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:837:1: ( rule__RealValue__Group_2__0 )
                    {
                     before(grammarAccess.getRealValueAccess().getGroup_2()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:838:1: ( rule__RealValue__Group_2__0 )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:838:2: rule__RealValue__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__RealValue__Group_2__0_in_rule__RealValue__Alternatives1751);
                    rule__RealValue__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getRealValueAccess().getGroup_2()); 

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
    // $ANTLR end "rule__RealValue__Alternatives"


    // $ANTLR start "rule__VisibilityKind__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:847:1: rule__VisibilityKind__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) );
    public final void rule__VisibilityKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:851:1: ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt7=1;
                }
                break;
            case 14:
                {
                alt7=2;
                }
                break;
            case 15:
                {
                alt7=3;
                }
                break;
            case 16:
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
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:852:1: ( ( '+' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:852:1: ( ( '+' ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:853:1: ( '+' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:854:1: ( '+' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:854:3: '+'
                    {
                    match(input,13,FOLLOW_13_in_rule__VisibilityKind__Alternatives1785); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:859:6: ( ( '-' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:859:6: ( ( '-' ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:860:1: ( '-' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:861:1: ( '-' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:861:3: '-'
                    {
                    match(input,14,FOLLOW_14_in_rule__VisibilityKind__Alternatives1806); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:866:6: ( ( '#' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:866:6: ( ( '#' ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:867:1: ( '#' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:868:1: ( '#' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:868:3: '#'
                    {
                    match(input,15,FOLLOW_15_in_rule__VisibilityKind__Alternatives1827); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:873:6: ( ( '~' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:873:6: ( ( '~' ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:874:1: ( '~' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:875:1: ( '~' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:875:3: '~'
                    {
                    match(input,16,FOLLOW_16_in_rule__VisibilityKind__Alternatives1848); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3()); 

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


    // $ANTLR start "rule__ModifierKind__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:885:1: rule__ModifierKind__Alternatives : ( ( ( 'readOnly' ) ) | ( ( 'union' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) );
    public final void rule__ModifierKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:889:1: ( ( ( 'readOnly' ) ) | ( ( 'union' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt8=1;
                }
                break;
            case 18:
                {
                alt8=2;
                }
                break;
            case 19:
                {
                alt8=3;
                }
                break;
            case 20:
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
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:890:1: ( ( 'readOnly' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:890:1: ( ( 'readOnly' ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:891:1: ( 'readOnly' )
                    {
                     before(grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:892:1: ( 'readOnly' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:892:3: 'readOnly'
                    {
                    match(input,17,FOLLOW_17_in_rule__ModifierKind__Alternatives1884); 

                    }

                     after(grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:897:6: ( ( 'union' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:897:6: ( ( 'union' ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:898:1: ( 'union' )
                    {
                     before(grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:899:1: ( 'union' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:899:3: 'union'
                    {
                    match(input,18,FOLLOW_18_in_rule__ModifierKind__Alternatives1905); 

                    }

                     after(grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:904:6: ( ( 'ordered' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:904:6: ( ( 'ordered' ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:905:1: ( 'ordered' )
                    {
                     before(grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:906:1: ( 'ordered' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:906:3: 'ordered'
                    {
                    match(input,19,FOLLOW_19_in_rule__ModifierKind__Alternatives1926); 

                    }

                     after(grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:911:6: ( ( 'unique' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:911:6: ( ( 'unique' ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:912:1: ( 'unique' )
                    {
                     before(grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:913:1: ( 'unique' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:913:3: 'unique'
                    {
                    match(input,20,FOLLOW_20_in_rule__ModifierKind__Alternatives1947); 

                    }

                     after(grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3()); 

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
    // $ANTLR end "rule__ModifierKind__Alternatives"


    // $ANTLR start "rule__BooleanLiterals__Alternatives"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:923:1: rule__BooleanLiterals__Alternatives : ( ( ( 'true' ) ) | ( ( 'false' ) ) );
    public final void rule__BooleanLiterals__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:927:1: ( ( ( 'true' ) ) | ( ( 'false' ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            else if ( (LA9_0==22) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:928:1: ( ( 'true' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:928:1: ( ( 'true' ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:929:1: ( 'true' )
                    {
                     before(grammarAccess.getBooleanLiteralsAccess().getTrueEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:930:1: ( 'true' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:930:3: 'true'
                    {
                    match(input,21,FOLLOW_21_in_rule__BooleanLiterals__Alternatives1983); 

                    }

                     after(grammarAccess.getBooleanLiteralsAccess().getTrueEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:935:6: ( ( 'false' ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:935:6: ( ( 'false' ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:936:1: ( 'false' )
                    {
                     before(grammarAccess.getBooleanLiteralsAccess().getFalseEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:937:1: ( 'false' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:937:3: 'false'
                    {
                    match(input,22,FOLLOW_22_in_rule__BooleanLiterals__Alternatives2004); 

                    }

                     after(grammarAccess.getBooleanLiteralsAccess().getFalseEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__BooleanLiterals__Alternatives"


    // $ANTLR start "rule__PortRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:949:1: rule__PortRule__Group__0 : rule__PortRule__Group__0__Impl rule__PortRule__Group__1 ;
    public final void rule__PortRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:953:1: ( rule__PortRule__Group__0__Impl rule__PortRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:954:2: rule__PortRule__Group__0__Impl rule__PortRule__Group__1
            {
            pushFollow(FOLLOW_rule__PortRule__Group__0__Impl_in_rule__PortRule__Group__02037);
            rule__PortRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortRule__Group__1_in_rule__PortRule__Group__02040);
            rule__PortRule__Group__1();

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
    // $ANTLR end "rule__PortRule__Group__0"


    // $ANTLR start "rule__PortRule__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:961:1: rule__PortRule__Group__0__Impl : ( ( rule__PortRule__VisibilityAssignment_0 )? ) ;
    public final void rule__PortRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:965:1: ( ( ( rule__PortRule__VisibilityAssignment_0 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:966:1: ( ( rule__PortRule__VisibilityAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:966:1: ( ( rule__PortRule__VisibilityAssignment_0 )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:967:1: ( rule__PortRule__VisibilityAssignment_0 )?
            {
             before(grammarAccess.getPortRuleAccess().getVisibilityAssignment_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:968:1: ( rule__PortRule__VisibilityAssignment_0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=13 && LA10_0<=16)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:968:2: rule__PortRule__VisibilityAssignment_0
                    {
                    pushFollow(FOLLOW_rule__PortRule__VisibilityAssignment_0_in_rule__PortRule__Group__0__Impl2067);
                    rule__PortRule__VisibilityAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPortRuleAccess().getVisibilityAssignment_0()); 

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
    // $ANTLR end "rule__PortRule__Group__0__Impl"


    // $ANTLR start "rule__PortRule__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:978:1: rule__PortRule__Group__1 : rule__PortRule__Group__1__Impl rule__PortRule__Group__2 ;
    public final void rule__PortRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:982:1: ( rule__PortRule__Group__1__Impl rule__PortRule__Group__2 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:983:2: rule__PortRule__Group__1__Impl rule__PortRule__Group__2
            {
            pushFollow(FOLLOW_rule__PortRule__Group__1__Impl_in_rule__PortRule__Group__12098);
            rule__PortRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortRule__Group__2_in_rule__PortRule__Group__12101);
            rule__PortRule__Group__2();

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
    // $ANTLR end "rule__PortRule__Group__1"


    // $ANTLR start "rule__PortRule__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:990:1: rule__PortRule__Group__1__Impl : ( ( rule__PortRule__DerivedAssignment_1 )? ) ;
    public final void rule__PortRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:994:1: ( ( ( rule__PortRule__DerivedAssignment_1 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:995:1: ( ( rule__PortRule__DerivedAssignment_1 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:995:1: ( ( rule__PortRule__DerivedAssignment_1 )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:996:1: ( rule__PortRule__DerivedAssignment_1 )?
            {
             before(grammarAccess.getPortRuleAccess().getDerivedAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:997:1: ( rule__PortRule__DerivedAssignment_1 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==37) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:997:2: rule__PortRule__DerivedAssignment_1
                    {
                    pushFollow(FOLLOW_rule__PortRule__DerivedAssignment_1_in_rule__PortRule__Group__1__Impl2128);
                    rule__PortRule__DerivedAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPortRuleAccess().getDerivedAssignment_1()); 

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
    // $ANTLR end "rule__PortRule__Group__1__Impl"


    // $ANTLR start "rule__PortRule__Group__2"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1007:1: rule__PortRule__Group__2 : rule__PortRule__Group__2__Impl rule__PortRule__Group__3 ;
    public final void rule__PortRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1011:1: ( rule__PortRule__Group__2__Impl rule__PortRule__Group__3 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1012:2: rule__PortRule__Group__2__Impl rule__PortRule__Group__3
            {
            pushFollow(FOLLOW_rule__PortRule__Group__2__Impl_in_rule__PortRule__Group__22159);
            rule__PortRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortRule__Group__3_in_rule__PortRule__Group__22162);
            rule__PortRule__Group__3();

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
    // $ANTLR end "rule__PortRule__Group__2"


    // $ANTLR start "rule__PortRule__Group__2__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1019:1: rule__PortRule__Group__2__Impl : ( ( rule__PortRule__NameAssignment_2 ) ) ;
    public final void rule__PortRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1023:1: ( ( ( rule__PortRule__NameAssignment_2 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1024:1: ( ( rule__PortRule__NameAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1024:1: ( ( rule__PortRule__NameAssignment_2 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1025:1: ( rule__PortRule__NameAssignment_2 )
            {
             before(grammarAccess.getPortRuleAccess().getNameAssignment_2()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1026:1: ( rule__PortRule__NameAssignment_2 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1026:2: rule__PortRule__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__PortRule__NameAssignment_2_in_rule__PortRule__Group__2__Impl2189);
            rule__PortRule__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPortRuleAccess().getNameAssignment_2()); 

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
    // $ANTLR end "rule__PortRule__Group__2__Impl"


    // $ANTLR start "rule__PortRule__Group__3"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1036:1: rule__PortRule__Group__3 : rule__PortRule__Group__3__Impl rule__PortRule__Group__4 ;
    public final void rule__PortRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1040:1: ( rule__PortRule__Group__3__Impl rule__PortRule__Group__4 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1041:2: rule__PortRule__Group__3__Impl rule__PortRule__Group__4
            {
            pushFollow(FOLLOW_rule__PortRule__Group__3__Impl_in_rule__PortRule__Group__32219);
            rule__PortRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortRule__Group__4_in_rule__PortRule__Group__32222);
            rule__PortRule__Group__4();

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
    // $ANTLR end "rule__PortRule__Group__3"


    // $ANTLR start "rule__PortRule__Group__3__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1048:1: rule__PortRule__Group__3__Impl : ( ( rule__PortRule__Group_3__0 )? ) ;
    public final void rule__PortRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1052:1: ( ( ( rule__PortRule__Group_3__0 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1053:1: ( ( rule__PortRule__Group_3__0 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1053:1: ( ( rule__PortRule__Group_3__0 )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1054:1: ( rule__PortRule__Group_3__0 )?
            {
             before(grammarAccess.getPortRuleAccess().getGroup_3()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1055:1: ( rule__PortRule__Group_3__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1055:2: rule__PortRule__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__PortRule__Group_3__0_in_rule__PortRule__Group__3__Impl2249);
                    rule__PortRule__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPortRuleAccess().getGroup_3()); 

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
    // $ANTLR end "rule__PortRule__Group__3__Impl"


    // $ANTLR start "rule__PortRule__Group__4"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1065:1: rule__PortRule__Group__4 : rule__PortRule__Group__4__Impl rule__PortRule__Group__5 ;
    public final void rule__PortRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1069:1: ( rule__PortRule__Group__4__Impl rule__PortRule__Group__5 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1070:2: rule__PortRule__Group__4__Impl rule__PortRule__Group__5
            {
            pushFollow(FOLLOW_rule__PortRule__Group__4__Impl_in_rule__PortRule__Group__42280);
            rule__PortRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortRule__Group__5_in_rule__PortRule__Group__42283);
            rule__PortRule__Group__5();

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
    // $ANTLR end "rule__PortRule__Group__4"


    // $ANTLR start "rule__PortRule__Group__4__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1077:1: rule__PortRule__Group__4__Impl : ( ( rule__PortRule__MultiplicityAssignment_4 )? ) ;
    public final void rule__PortRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1081:1: ( ( ( rule__PortRule__MultiplicityAssignment_4 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1082:1: ( ( rule__PortRule__MultiplicityAssignment_4 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1082:1: ( ( rule__PortRule__MultiplicityAssignment_4 )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1083:1: ( rule__PortRule__MultiplicityAssignment_4 )?
            {
             before(grammarAccess.getPortRuleAccess().getMultiplicityAssignment_4()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1084:1: ( rule__PortRule__MultiplicityAssignment_4 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==25) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1084:2: rule__PortRule__MultiplicityAssignment_4
                    {
                    pushFollow(FOLLOW_rule__PortRule__MultiplicityAssignment_4_in_rule__PortRule__Group__4__Impl2310);
                    rule__PortRule__MultiplicityAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPortRuleAccess().getMultiplicityAssignment_4()); 

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
    // $ANTLR end "rule__PortRule__Group__4__Impl"


    // $ANTLR start "rule__PortRule__Group__5"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1094:1: rule__PortRule__Group__5 : rule__PortRule__Group__5__Impl rule__PortRule__Group__6 ;
    public final void rule__PortRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1098:1: ( rule__PortRule__Group__5__Impl rule__PortRule__Group__6 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1099:2: rule__PortRule__Group__5__Impl rule__PortRule__Group__6
            {
            pushFollow(FOLLOW_rule__PortRule__Group__5__Impl_in_rule__PortRule__Group__52341);
            rule__PortRule__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortRule__Group__6_in_rule__PortRule__Group__52344);
            rule__PortRule__Group__6();

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
    // $ANTLR end "rule__PortRule__Group__5"


    // $ANTLR start "rule__PortRule__Group__5__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1106:1: rule__PortRule__Group__5__Impl : ( ( rule__PortRule__ModifiersAssignment_5 )? ) ;
    public final void rule__PortRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1110:1: ( ( ( rule__PortRule__ModifiersAssignment_5 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1111:1: ( ( rule__PortRule__ModifiersAssignment_5 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1111:1: ( ( rule__PortRule__ModifiersAssignment_5 )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1112:1: ( rule__PortRule__ModifiersAssignment_5 )?
            {
             before(grammarAccess.getPortRuleAccess().getModifiersAssignment_5()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1113:1: ( rule__PortRule__ModifiersAssignment_5 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==28) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1113:2: rule__PortRule__ModifiersAssignment_5
                    {
                    pushFollow(FOLLOW_rule__PortRule__ModifiersAssignment_5_in_rule__PortRule__Group__5__Impl2371);
                    rule__PortRule__ModifiersAssignment_5();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPortRuleAccess().getModifiersAssignment_5()); 

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
    // $ANTLR end "rule__PortRule__Group__5__Impl"


    // $ANTLR start "rule__PortRule__Group__6"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1123:1: rule__PortRule__Group__6 : rule__PortRule__Group__6__Impl ;
    public final void rule__PortRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1127:1: ( rule__PortRule__Group__6__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1128:2: rule__PortRule__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__PortRule__Group__6__Impl_in_rule__PortRule__Group__62402);
            rule__PortRule__Group__6__Impl();

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
    // $ANTLR end "rule__PortRule__Group__6"


    // $ANTLR start "rule__PortRule__Group__6__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1134:1: rule__PortRule__Group__6__Impl : ( ( rule__PortRule__DefaultAssignment_6 )? ) ;
    public final void rule__PortRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1138:1: ( ( ( rule__PortRule__DefaultAssignment_6 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1139:1: ( ( rule__PortRule__DefaultAssignment_6 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1139:1: ( ( rule__PortRule__DefaultAssignment_6 )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1140:1: ( rule__PortRule__DefaultAssignment_6 )?
            {
             before(grammarAccess.getPortRuleAccess().getDefaultAssignment_6()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1141:1: ( rule__PortRule__DefaultAssignment_6 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==33) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1141:2: rule__PortRule__DefaultAssignment_6
                    {
                    pushFollow(FOLLOW_rule__PortRule__DefaultAssignment_6_in_rule__PortRule__Group__6__Impl2429);
                    rule__PortRule__DefaultAssignment_6();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPortRuleAccess().getDefaultAssignment_6()); 

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
    // $ANTLR end "rule__PortRule__Group__6__Impl"


    // $ANTLR start "rule__PortRule__Group_3__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1165:1: rule__PortRule__Group_3__0 : rule__PortRule__Group_3__0__Impl rule__PortRule__Group_3__1 ;
    public final void rule__PortRule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1169:1: ( rule__PortRule__Group_3__0__Impl rule__PortRule__Group_3__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1170:2: rule__PortRule__Group_3__0__Impl rule__PortRule__Group_3__1
            {
            pushFollow(FOLLOW_rule__PortRule__Group_3__0__Impl_in_rule__PortRule__Group_3__02474);
            rule__PortRule__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortRule__Group_3__1_in_rule__PortRule__Group_3__02477);
            rule__PortRule__Group_3__1();

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
    // $ANTLR end "rule__PortRule__Group_3__0"


    // $ANTLR start "rule__PortRule__Group_3__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1177:1: rule__PortRule__Group_3__0__Impl : ( ':' ) ;
    public final void rule__PortRule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1181:1: ( ( ':' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1182:1: ( ':' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1182:1: ( ':' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1183:1: ':'
            {
             before(grammarAccess.getPortRuleAccess().getColonKeyword_3_0()); 
            match(input,23,FOLLOW_23_in_rule__PortRule__Group_3__0__Impl2505); 
             after(grammarAccess.getPortRuleAccess().getColonKeyword_3_0()); 

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
    // $ANTLR end "rule__PortRule__Group_3__0__Impl"


    // $ANTLR start "rule__PortRule__Group_3__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1196:1: rule__PortRule__Group_3__1 : rule__PortRule__Group_3__1__Impl rule__PortRule__Group_3__2 ;
    public final void rule__PortRule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1200:1: ( rule__PortRule__Group_3__1__Impl rule__PortRule__Group_3__2 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1201:2: rule__PortRule__Group_3__1__Impl rule__PortRule__Group_3__2
            {
            pushFollow(FOLLOW_rule__PortRule__Group_3__1__Impl_in_rule__PortRule__Group_3__12536);
            rule__PortRule__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PortRule__Group_3__2_in_rule__PortRule__Group_3__12539);
            rule__PortRule__Group_3__2();

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
    // $ANTLR end "rule__PortRule__Group_3__1"


    // $ANTLR start "rule__PortRule__Group_3__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1208:1: rule__PortRule__Group_3__1__Impl : ( ( rule__PortRule__ConjugatedAssignment_3_1 )? ) ;
    public final void rule__PortRule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1212:1: ( ( ( rule__PortRule__ConjugatedAssignment_3_1 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1213:1: ( ( rule__PortRule__ConjugatedAssignment_3_1 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1213:1: ( ( rule__PortRule__ConjugatedAssignment_3_1 )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1214:1: ( rule__PortRule__ConjugatedAssignment_3_1 )?
            {
             before(grammarAccess.getPortRuleAccess().getConjugatedAssignment_3_1()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1215:1: ( rule__PortRule__ConjugatedAssignment_3_1 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==16) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1215:2: rule__PortRule__ConjugatedAssignment_3_1
                    {
                    pushFollow(FOLLOW_rule__PortRule__ConjugatedAssignment_3_1_in_rule__PortRule__Group_3__1__Impl2566);
                    rule__PortRule__ConjugatedAssignment_3_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPortRuleAccess().getConjugatedAssignment_3_1()); 

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
    // $ANTLR end "rule__PortRule__Group_3__1__Impl"


    // $ANTLR start "rule__PortRule__Group_3__2"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1225:1: rule__PortRule__Group_3__2 : rule__PortRule__Group_3__2__Impl ;
    public final void rule__PortRule__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1229:1: ( rule__PortRule__Group_3__2__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1230:2: rule__PortRule__Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__PortRule__Group_3__2__Impl_in_rule__PortRule__Group_3__22597);
            rule__PortRule__Group_3__2__Impl();

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
    // $ANTLR end "rule__PortRule__Group_3__2"


    // $ANTLR start "rule__PortRule__Group_3__2__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1236:1: rule__PortRule__Group_3__2__Impl : ( ( rule__PortRule__Alternatives_3_2 ) ) ;
    public final void rule__PortRule__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1240:1: ( ( ( rule__PortRule__Alternatives_3_2 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1241:1: ( ( rule__PortRule__Alternatives_3_2 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1241:1: ( ( rule__PortRule__Alternatives_3_2 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1242:1: ( rule__PortRule__Alternatives_3_2 )
            {
             before(grammarAccess.getPortRuleAccess().getAlternatives_3_2()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1243:1: ( rule__PortRule__Alternatives_3_2 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1243:2: rule__PortRule__Alternatives_3_2
            {
            pushFollow(FOLLOW_rule__PortRule__Alternatives_3_2_in_rule__PortRule__Group_3__2__Impl2624);
            rule__PortRule__Alternatives_3_2();

            state._fsp--;


            }

             after(grammarAccess.getPortRuleAccess().getAlternatives_3_2()); 

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
    // $ANTLR end "rule__PortRule__Group_3__2__Impl"


    // $ANTLR start "rule__TypeRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1259:1: rule__TypeRule__Group__0 : rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 ;
    public final void rule__TypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1263:1: ( rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1264:2: rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__0__Impl_in_rule__TypeRule__Group__02660);
            rule__TypeRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TypeRule__Group__1_in_rule__TypeRule__Group__02663);
            rule__TypeRule__Group__1();

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
    // $ANTLR end "rule__TypeRule__Group__0"


    // $ANTLR start "rule__TypeRule__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1271:1: rule__TypeRule__Group__0__Impl : ( ( rule__TypeRule__PathAssignment_0 )? ) ;
    public final void rule__TypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1275:1: ( ( ( rule__TypeRule__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1276:1: ( ( rule__TypeRule__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1276:1: ( ( rule__TypeRule__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1277:1: ( rule__TypeRule__PathAssignment_0 )?
            {
             before(grammarAccess.getTypeRuleAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1278:1: ( rule__TypeRule__PathAssignment_0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==24) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1278:2: rule__TypeRule__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__TypeRule__PathAssignment_0_in_rule__TypeRule__Group__0__Impl2690);
                    rule__TypeRule__PathAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeRuleAccess().getPathAssignment_0()); 

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
    // $ANTLR end "rule__TypeRule__Group__0__Impl"


    // $ANTLR start "rule__TypeRule__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1288:1: rule__TypeRule__Group__1 : rule__TypeRule__Group__1__Impl ;
    public final void rule__TypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1292:1: ( rule__TypeRule__Group__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1293:2: rule__TypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__1__Impl_in_rule__TypeRule__Group__12721);
            rule__TypeRule__Group__1__Impl();

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
    // $ANTLR end "rule__TypeRule__Group__1"


    // $ANTLR start "rule__TypeRule__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1299:1: rule__TypeRule__Group__1__Impl : ( ( rule__TypeRule__TypeAssignment_1 ) ) ;
    public final void rule__TypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1303:1: ( ( ( rule__TypeRule__TypeAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1304:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1304:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1305:1: ( rule__TypeRule__TypeAssignment_1 )
            {
             before(grammarAccess.getTypeRuleAccess().getTypeAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1306:1: ( rule__TypeRule__TypeAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1306:2: rule__TypeRule__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__TypeRule__TypeAssignment_1_in_rule__TypeRule__Group__1__Impl2748);
            rule__TypeRule__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeRuleAccess().getTypeAssignment_1()); 

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
    // $ANTLR end "rule__TypeRule__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1320:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1324:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1325:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02782);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02785);
            rule__QualifiedName__Group__1();

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
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1332:1: rule__QualifiedName__Group__0__Impl : ( ( rule__QualifiedName__PathAssignment_0 ) ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1336:1: ( ( ( rule__QualifiedName__PathAssignment_0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1337:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1337:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1338:1: ( rule__QualifiedName__PathAssignment_0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1339:1: ( rule__QualifiedName__PathAssignment_0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1339:2: rule__QualifiedName__PathAssignment_0
            {
            pushFollow(FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl2812);
            rule__QualifiedName__PathAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); 

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
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1349:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1353:1: ( rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1354:2: rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12842);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__12845);
            rule__QualifiedName__Group__2();

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
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1361:1: rule__QualifiedName__Group__1__Impl : ( '::' ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1365:1: ( ( '::' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1366:1: ( '::' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1366:1: ( '::' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1367:1: '::'
            {
             before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); 
            match(input,24,FOLLOW_24_in_rule__QualifiedName__Group__1__Impl2873); 
             after(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); 

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
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__2"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1380:1: rule__QualifiedName__Group__2 : rule__QualifiedName__Group__2__Impl ;
    public final void rule__QualifiedName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1384:1: ( rule__QualifiedName__Group__2__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1385:2: rule__QualifiedName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__22904);
            rule__QualifiedName__Group__2__Impl();

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
    // $ANTLR end "rule__QualifiedName__Group__2"


    // $ANTLR start "rule__QualifiedName__Group__2__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1391:1: rule__QualifiedName__Group__2__Impl : ( ( rule__QualifiedName__RemainingAssignment_2 )? ) ;
    public final void rule__QualifiedName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1395:1: ( ( ( rule__QualifiedName__RemainingAssignment_2 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1396:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1396:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1397:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1398:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==24) ) {
                    alt18=1;
                }
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1398:2: rule__QualifiedName__RemainingAssignment_2
                    {
                    pushFollow(FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl2931);
                    rule__QualifiedName__RemainingAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); 

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
    // $ANTLR end "rule__QualifiedName__Group__2__Impl"


    // $ANTLR start "rule__MultiplicityRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1414:1: rule__MultiplicityRule__Group__0 : rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 ;
    public final void rule__MultiplicityRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1418:1: ( rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1419:2: rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__0__Impl_in_rule__MultiplicityRule__Group__02968);
            rule__MultiplicityRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__1_in_rule__MultiplicityRule__Group__02971);
            rule__MultiplicityRule__Group__1();

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
    // $ANTLR end "rule__MultiplicityRule__Group__0"


    // $ANTLR start "rule__MultiplicityRule__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1426:1: rule__MultiplicityRule__Group__0__Impl : ( '[' ) ;
    public final void rule__MultiplicityRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1430:1: ( ( '[' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1431:1: ( '[' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1431:1: ( '[' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1432:1: '['
            {
             before(grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0()); 
            match(input,25,FOLLOW_25_in_rule__MultiplicityRule__Group__0__Impl2999); 
             after(grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0()); 

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
    // $ANTLR end "rule__MultiplicityRule__Group__0__Impl"


    // $ANTLR start "rule__MultiplicityRule__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1445:1: rule__MultiplicityRule__Group__1 : rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 ;
    public final void rule__MultiplicityRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1449:1: ( rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1450:2: rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__1__Impl_in_rule__MultiplicityRule__Group__13030);
            rule__MultiplicityRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__2_in_rule__MultiplicityRule__Group__13033);
            rule__MultiplicityRule__Group__2();

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
    // $ANTLR end "rule__MultiplicityRule__Group__1"


    // $ANTLR start "rule__MultiplicityRule__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1457:1: rule__MultiplicityRule__Group__1__Impl : ( ( rule__MultiplicityRule__Group_1__0 )? ) ;
    public final void rule__MultiplicityRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1461:1: ( ( ( rule__MultiplicityRule__Group_1__0 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1462:1: ( ( rule__MultiplicityRule__Group_1__0 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1462:1: ( ( rule__MultiplicityRule__Group_1__0 )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1463:1: ( rule__MultiplicityRule__Group_1__0 )?
            {
             before(grammarAccess.getMultiplicityRuleAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1464:1: ( rule__MultiplicityRule__Group_1__0 )?
            int alt19=2;
            switch ( input.LA(1) ) {
                case RULE_INT:
                    {
                    int LA19_1 = input.LA(2);

                    if ( (LA19_1==27) ) {
                        alt19=1;
                    }
                    }
                    break;
                case 12:
                    {
                    int LA19_2 = input.LA(2);

                    if ( (LA19_2==27) ) {
                        alt19=1;
                    }
                    }
                    break;
                case RULE_STRING:
                    {
                    int LA19_3 = input.LA(2);

                    if ( (LA19_3==27) ) {
                        alt19=1;
                    }
                    }
                    break;
            }

            switch (alt19) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1464:2: rule__MultiplicityRule__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__MultiplicityRule__Group_1__0_in_rule__MultiplicityRule__Group__1__Impl3060);
                    rule__MultiplicityRule__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMultiplicityRuleAccess().getGroup_1()); 

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
    // $ANTLR end "rule__MultiplicityRule__Group__1__Impl"


    // $ANTLR start "rule__MultiplicityRule__Group__2"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1474:1: rule__MultiplicityRule__Group__2 : rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 ;
    public final void rule__MultiplicityRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1478:1: ( rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1479:2: rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__2__Impl_in_rule__MultiplicityRule__Group__23091);
            rule__MultiplicityRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__3_in_rule__MultiplicityRule__Group__23094);
            rule__MultiplicityRule__Group__3();

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
    // $ANTLR end "rule__MultiplicityRule__Group__2"


    // $ANTLR start "rule__MultiplicityRule__Group__2__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1486:1: rule__MultiplicityRule__Group__2__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_2 ) ) ;
    public final void rule__MultiplicityRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1490:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_2 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1491:1: ( ( rule__MultiplicityRule__BoundsAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1491:1: ( ( rule__MultiplicityRule__BoundsAssignment_2 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1492:1: ( rule__MultiplicityRule__BoundsAssignment_2 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_2()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1493:1: ( rule__MultiplicityRule__BoundsAssignment_2 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1493:2: rule__MultiplicityRule__BoundsAssignment_2
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__BoundsAssignment_2_in_rule__MultiplicityRule__Group__2__Impl3121);
            rule__MultiplicityRule__BoundsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_2()); 

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
    // $ANTLR end "rule__MultiplicityRule__Group__2__Impl"


    // $ANTLR start "rule__MultiplicityRule__Group__3"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1503:1: rule__MultiplicityRule__Group__3 : rule__MultiplicityRule__Group__3__Impl ;
    public final void rule__MultiplicityRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1507:1: ( rule__MultiplicityRule__Group__3__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1508:2: rule__MultiplicityRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__3__Impl_in_rule__MultiplicityRule__Group__33151);
            rule__MultiplicityRule__Group__3__Impl();

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
    // $ANTLR end "rule__MultiplicityRule__Group__3"


    // $ANTLR start "rule__MultiplicityRule__Group__3__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1514:1: rule__MultiplicityRule__Group__3__Impl : ( ']' ) ;
    public final void rule__MultiplicityRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1518:1: ( ( ']' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1519:1: ( ']' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1519:1: ( ']' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1520:1: ']'
            {
             before(grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3()); 
            match(input,26,FOLLOW_26_in_rule__MultiplicityRule__Group__3__Impl3179); 
             after(grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3()); 

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
    // $ANTLR end "rule__MultiplicityRule__Group__3__Impl"


    // $ANTLR start "rule__MultiplicityRule__Group_1__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1541:1: rule__MultiplicityRule__Group_1__0 : rule__MultiplicityRule__Group_1__0__Impl rule__MultiplicityRule__Group_1__1 ;
    public final void rule__MultiplicityRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1545:1: ( rule__MultiplicityRule__Group_1__0__Impl rule__MultiplicityRule__Group_1__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1546:2: rule__MultiplicityRule__Group_1__0__Impl rule__MultiplicityRule__Group_1__1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group_1__0__Impl_in_rule__MultiplicityRule__Group_1__03218);
            rule__MultiplicityRule__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group_1__1_in_rule__MultiplicityRule__Group_1__03221);
            rule__MultiplicityRule__Group_1__1();

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
    // $ANTLR end "rule__MultiplicityRule__Group_1__0"


    // $ANTLR start "rule__MultiplicityRule__Group_1__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1553:1: rule__MultiplicityRule__Group_1__0__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_1_0 ) ) ;
    public final void rule__MultiplicityRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1557:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1558:1: ( ( rule__MultiplicityRule__BoundsAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1558:1: ( ( rule__MultiplicityRule__BoundsAssignment_1_0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1559:1: ( rule__MultiplicityRule__BoundsAssignment_1_0 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1560:1: ( rule__MultiplicityRule__BoundsAssignment_1_0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1560:2: rule__MultiplicityRule__BoundsAssignment_1_0
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__BoundsAssignment_1_0_in_rule__MultiplicityRule__Group_1__0__Impl3248);
            rule__MultiplicityRule__BoundsAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_1_0()); 

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
    // $ANTLR end "rule__MultiplicityRule__Group_1__0__Impl"


    // $ANTLR start "rule__MultiplicityRule__Group_1__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1570:1: rule__MultiplicityRule__Group_1__1 : rule__MultiplicityRule__Group_1__1__Impl ;
    public final void rule__MultiplicityRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1574:1: ( rule__MultiplicityRule__Group_1__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1575:2: rule__MultiplicityRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group_1__1__Impl_in_rule__MultiplicityRule__Group_1__13278);
            rule__MultiplicityRule__Group_1__1__Impl();

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
    // $ANTLR end "rule__MultiplicityRule__Group_1__1"


    // $ANTLR start "rule__MultiplicityRule__Group_1__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1581:1: rule__MultiplicityRule__Group_1__1__Impl : ( '..' ) ;
    public final void rule__MultiplicityRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1585:1: ( ( '..' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1586:1: ( '..' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1586:1: ( '..' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1587:1: '..'
            {
             before(grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_1_1()); 
            match(input,27,FOLLOW_27_in_rule__MultiplicityRule__Group_1__1__Impl3306); 
             after(grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_1_1()); 

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
    // $ANTLR end "rule__MultiplicityRule__Group_1__1__Impl"


    // $ANTLR start "rule__ModifiersRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1604:1: rule__ModifiersRule__Group__0 : rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 ;
    public final void rule__ModifiersRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1608:1: ( rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1609:2: rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__0__Impl_in_rule__ModifiersRule__Group__03341);
            rule__ModifiersRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__1_in_rule__ModifiersRule__Group__03344);
            rule__ModifiersRule__Group__1();

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
    // $ANTLR end "rule__ModifiersRule__Group__0"


    // $ANTLR start "rule__ModifiersRule__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1616:1: rule__ModifiersRule__Group__0__Impl : ( () ) ;
    public final void rule__ModifiersRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1620:1: ( ( () ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1621:1: ( () )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1621:1: ( () )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1622:1: ()
            {
             before(grammarAccess.getModifiersRuleAccess().getModifiersRuleAction_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1623:1: ()
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1625:1: 
            {
            }

             after(grammarAccess.getModifiersRuleAccess().getModifiersRuleAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModifiersRule__Group__0__Impl"


    // $ANTLR start "rule__ModifiersRule__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1635:1: rule__ModifiersRule__Group__1 : rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 ;
    public final void rule__ModifiersRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1639:1: ( rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1640:2: rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__1__Impl_in_rule__ModifiersRule__Group__13402);
            rule__ModifiersRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__2_in_rule__ModifiersRule__Group__13405);
            rule__ModifiersRule__Group__2();

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
    // $ANTLR end "rule__ModifiersRule__Group__1"


    // $ANTLR start "rule__ModifiersRule__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1647:1: rule__ModifiersRule__Group__1__Impl : ( '{' ) ;
    public final void rule__ModifiersRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1651:1: ( ( '{' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1652:1: ( '{' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1652:1: ( '{' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1653:1: '{'
            {
             before(grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,28,FOLLOW_28_in_rule__ModifiersRule__Group__1__Impl3433); 
             after(grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_1()); 

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
    // $ANTLR end "rule__ModifiersRule__Group__1__Impl"


    // $ANTLR start "rule__ModifiersRule__Group__2"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1666:1: rule__ModifiersRule__Group__2 : rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 ;
    public final void rule__ModifiersRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1670:1: ( rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1671:2: rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__2__Impl_in_rule__ModifiersRule__Group__23464);
            rule__ModifiersRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__3_in_rule__ModifiersRule__Group__23467);
            rule__ModifiersRule__Group__3();

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
    // $ANTLR end "rule__ModifiersRule__Group__2"


    // $ANTLR start "rule__ModifiersRule__Group__2__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1678:1: rule__ModifiersRule__Group__2__Impl : ( ( rule__ModifiersRule__Group_2__0 )? ) ;
    public final void rule__ModifiersRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1682:1: ( ( ( rule__ModifiersRule__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1683:1: ( ( rule__ModifiersRule__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1683:1: ( ( rule__ModifiersRule__Group_2__0 )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1684:1: ( rule__ModifiersRule__Group_2__0 )?
            {
             before(grammarAccess.getModifiersRuleAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1685:1: ( rule__ModifiersRule__Group_2__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=17 && LA20_0<=20)||(LA20_0>=31 && LA20_0<=32)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1685:2: rule__ModifiersRule__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ModifiersRule__Group_2__0_in_rule__ModifiersRule__Group__2__Impl3494);
                    rule__ModifiersRule__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModifiersRuleAccess().getGroup_2()); 

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
    // $ANTLR end "rule__ModifiersRule__Group__2__Impl"


    // $ANTLR start "rule__ModifiersRule__Group__3"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1695:1: rule__ModifiersRule__Group__3 : rule__ModifiersRule__Group__3__Impl ;
    public final void rule__ModifiersRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1699:1: ( rule__ModifiersRule__Group__3__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1700:2: rule__ModifiersRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__3__Impl_in_rule__ModifiersRule__Group__33525);
            rule__ModifiersRule__Group__3__Impl();

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
    // $ANTLR end "rule__ModifiersRule__Group__3"


    // $ANTLR start "rule__ModifiersRule__Group__3__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1706:1: rule__ModifiersRule__Group__3__Impl : ( '}' ) ;
    public final void rule__ModifiersRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1710:1: ( ( '}' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1711:1: ( '}' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1711:1: ( '}' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1712:1: '}'
            {
             before(grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3()); 
            match(input,29,FOLLOW_29_in_rule__ModifiersRule__Group__3__Impl3553); 
             after(grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3()); 

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
    // $ANTLR end "rule__ModifiersRule__Group__3__Impl"


    // $ANTLR start "rule__ModifiersRule__Group_2__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1733:1: rule__ModifiersRule__Group_2__0 : rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 ;
    public final void rule__ModifiersRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1737:1: ( rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1738:2: rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__0__Impl_in_rule__ModifiersRule__Group_2__03592);
            rule__ModifiersRule__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__1_in_rule__ModifiersRule__Group_2__03595);
            rule__ModifiersRule__Group_2__1();

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
    // $ANTLR end "rule__ModifiersRule__Group_2__0"


    // $ANTLR start "rule__ModifiersRule__Group_2__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1745:1: rule__ModifiersRule__Group_2__0__Impl : ( ( rule__ModifiersRule__ValuesAssignment_2_0 ) ) ;
    public final void rule__ModifiersRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1749:1: ( ( ( rule__ModifiersRule__ValuesAssignment_2_0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1750:1: ( ( rule__ModifiersRule__ValuesAssignment_2_0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1750:1: ( ( rule__ModifiersRule__ValuesAssignment_2_0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1751:1: ( rule__ModifiersRule__ValuesAssignment_2_0 )
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1752:1: ( rule__ModifiersRule__ValuesAssignment_2_0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1752:2: rule__ModifiersRule__ValuesAssignment_2_0
            {
            pushFollow(FOLLOW_rule__ModifiersRule__ValuesAssignment_2_0_in_rule__ModifiersRule__Group_2__0__Impl3622);
            rule__ModifiersRule__ValuesAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_0()); 

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
    // $ANTLR end "rule__ModifiersRule__Group_2__0__Impl"


    // $ANTLR start "rule__ModifiersRule__Group_2__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1762:1: rule__ModifiersRule__Group_2__1 : rule__ModifiersRule__Group_2__1__Impl ;
    public final void rule__ModifiersRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1766:1: ( rule__ModifiersRule__Group_2__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1767:2: rule__ModifiersRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__1__Impl_in_rule__ModifiersRule__Group_2__13652);
            rule__ModifiersRule__Group_2__1__Impl();

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
    // $ANTLR end "rule__ModifiersRule__Group_2__1"


    // $ANTLR start "rule__ModifiersRule__Group_2__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1773:1: rule__ModifiersRule__Group_2__1__Impl : ( ( rule__ModifiersRule__Group_2_1__0 )* ) ;
    public final void rule__ModifiersRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1777:1: ( ( ( rule__ModifiersRule__Group_2_1__0 )* ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1778:1: ( ( rule__ModifiersRule__Group_2_1__0 )* )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1778:1: ( ( rule__ModifiersRule__Group_2_1__0 )* )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1779:1: ( rule__ModifiersRule__Group_2_1__0 )*
            {
             before(grammarAccess.getModifiersRuleAccess().getGroup_2_1()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1780:1: ( rule__ModifiersRule__Group_2_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==30) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1780:2: rule__ModifiersRule__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ModifiersRule__Group_2_1__0_in_rule__ModifiersRule__Group_2__1__Impl3679);
            	    rule__ModifiersRule__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getModifiersRuleAccess().getGroup_2_1()); 

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
    // $ANTLR end "rule__ModifiersRule__Group_2__1__Impl"


    // $ANTLR start "rule__ModifiersRule__Group_2_1__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1794:1: rule__ModifiersRule__Group_2_1__0 : rule__ModifiersRule__Group_2_1__0__Impl rule__ModifiersRule__Group_2_1__1 ;
    public final void rule__ModifiersRule__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1798:1: ( rule__ModifiersRule__Group_2_1__0__Impl rule__ModifiersRule__Group_2_1__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1799:2: rule__ModifiersRule__Group_2_1__0__Impl rule__ModifiersRule__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2_1__0__Impl_in_rule__ModifiersRule__Group_2_1__03714);
            rule__ModifiersRule__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group_2_1__1_in_rule__ModifiersRule__Group_2_1__03717);
            rule__ModifiersRule__Group_2_1__1();

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
    // $ANTLR end "rule__ModifiersRule__Group_2_1__0"


    // $ANTLR start "rule__ModifiersRule__Group_2_1__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1806:1: rule__ModifiersRule__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__ModifiersRule__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1810:1: ( ( ',' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1811:1: ( ',' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1811:1: ( ',' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1812:1: ','
            {
             before(grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_1_0()); 
            match(input,30,FOLLOW_30_in_rule__ModifiersRule__Group_2_1__0__Impl3745); 
             after(grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_1_0()); 

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
    // $ANTLR end "rule__ModifiersRule__Group_2_1__0__Impl"


    // $ANTLR start "rule__ModifiersRule__Group_2_1__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1825:1: rule__ModifiersRule__Group_2_1__1 : rule__ModifiersRule__Group_2_1__1__Impl ;
    public final void rule__ModifiersRule__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1829:1: ( rule__ModifiersRule__Group_2_1__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1830:2: rule__ModifiersRule__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2_1__1__Impl_in_rule__ModifiersRule__Group_2_1__13776);
            rule__ModifiersRule__Group_2_1__1__Impl();

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
    // $ANTLR end "rule__ModifiersRule__Group_2_1__1"


    // $ANTLR start "rule__ModifiersRule__Group_2_1__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1836:1: rule__ModifiersRule__Group_2_1__1__Impl : ( ( rule__ModifiersRule__ValuesAssignment_2_1_1 ) ) ;
    public final void rule__ModifiersRule__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1840:1: ( ( ( rule__ModifiersRule__ValuesAssignment_2_1_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1841:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1841:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1842:1: ( rule__ModifiersRule__ValuesAssignment_2_1_1 )
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_1_1()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1843:1: ( rule__ModifiersRule__ValuesAssignment_2_1_1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1843:2: rule__ModifiersRule__ValuesAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__ValuesAssignment_2_1_1_in_rule__ModifiersRule__Group_2_1__1__Impl3803);
            rule__ModifiersRule__ValuesAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_1_1()); 

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
    // $ANTLR end "rule__ModifiersRule__Group_2_1__1__Impl"


    // $ANTLR start "rule__RedefinesRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1857:1: rule__RedefinesRule__Group__0 : rule__RedefinesRule__Group__0__Impl rule__RedefinesRule__Group__1 ;
    public final void rule__RedefinesRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1861:1: ( rule__RedefinesRule__Group__0__Impl rule__RedefinesRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1862:2: rule__RedefinesRule__Group__0__Impl rule__RedefinesRule__Group__1
            {
            pushFollow(FOLLOW_rule__RedefinesRule__Group__0__Impl_in_rule__RedefinesRule__Group__03837);
            rule__RedefinesRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RedefinesRule__Group__1_in_rule__RedefinesRule__Group__03840);
            rule__RedefinesRule__Group__1();

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
    // $ANTLR end "rule__RedefinesRule__Group__0"


    // $ANTLR start "rule__RedefinesRule__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1869:1: rule__RedefinesRule__Group__0__Impl : ( 'redefines' ) ;
    public final void rule__RedefinesRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1873:1: ( ( 'redefines' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1874:1: ( 'redefines' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1874:1: ( 'redefines' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1875:1: 'redefines'
            {
             before(grammarAccess.getRedefinesRuleAccess().getRedefinesKeyword_0()); 
            match(input,31,FOLLOW_31_in_rule__RedefinesRule__Group__0__Impl3868); 
             after(grammarAccess.getRedefinesRuleAccess().getRedefinesKeyword_0()); 

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
    // $ANTLR end "rule__RedefinesRule__Group__0__Impl"


    // $ANTLR start "rule__RedefinesRule__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1888:1: rule__RedefinesRule__Group__1 : rule__RedefinesRule__Group__1__Impl ;
    public final void rule__RedefinesRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1892:1: ( rule__RedefinesRule__Group__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1893:2: rule__RedefinesRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RedefinesRule__Group__1__Impl_in_rule__RedefinesRule__Group__13899);
            rule__RedefinesRule__Group__1__Impl();

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
    // $ANTLR end "rule__RedefinesRule__Group__1"


    // $ANTLR start "rule__RedefinesRule__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1899:1: rule__RedefinesRule__Group__1__Impl : ( ( rule__RedefinesRule__PortAssignment_1 ) ) ;
    public final void rule__RedefinesRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1903:1: ( ( ( rule__RedefinesRule__PortAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1904:1: ( ( rule__RedefinesRule__PortAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1904:1: ( ( rule__RedefinesRule__PortAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1905:1: ( rule__RedefinesRule__PortAssignment_1 )
            {
             before(grammarAccess.getRedefinesRuleAccess().getPortAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1906:1: ( rule__RedefinesRule__PortAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1906:2: rule__RedefinesRule__PortAssignment_1
            {
            pushFollow(FOLLOW_rule__RedefinesRule__PortAssignment_1_in_rule__RedefinesRule__Group__1__Impl3926);
            rule__RedefinesRule__PortAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRedefinesRuleAccess().getPortAssignment_1()); 

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
    // $ANTLR end "rule__RedefinesRule__Group__1__Impl"


    // $ANTLR start "rule__SubsetsRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1920:1: rule__SubsetsRule__Group__0 : rule__SubsetsRule__Group__0__Impl rule__SubsetsRule__Group__1 ;
    public final void rule__SubsetsRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1924:1: ( rule__SubsetsRule__Group__0__Impl rule__SubsetsRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1925:2: rule__SubsetsRule__Group__0__Impl rule__SubsetsRule__Group__1
            {
            pushFollow(FOLLOW_rule__SubsetsRule__Group__0__Impl_in_rule__SubsetsRule__Group__03960);
            rule__SubsetsRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SubsetsRule__Group__1_in_rule__SubsetsRule__Group__03963);
            rule__SubsetsRule__Group__1();

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
    // $ANTLR end "rule__SubsetsRule__Group__0"


    // $ANTLR start "rule__SubsetsRule__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1932:1: rule__SubsetsRule__Group__0__Impl : ( 'subsets' ) ;
    public final void rule__SubsetsRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1936:1: ( ( 'subsets' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1937:1: ( 'subsets' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1937:1: ( 'subsets' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1938:1: 'subsets'
            {
             before(grammarAccess.getSubsetsRuleAccess().getSubsetsKeyword_0()); 
            match(input,32,FOLLOW_32_in_rule__SubsetsRule__Group__0__Impl3991); 
             after(grammarAccess.getSubsetsRuleAccess().getSubsetsKeyword_0()); 

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
    // $ANTLR end "rule__SubsetsRule__Group__0__Impl"


    // $ANTLR start "rule__SubsetsRule__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1951:1: rule__SubsetsRule__Group__1 : rule__SubsetsRule__Group__1__Impl ;
    public final void rule__SubsetsRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1955:1: ( rule__SubsetsRule__Group__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1956:2: rule__SubsetsRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SubsetsRule__Group__1__Impl_in_rule__SubsetsRule__Group__14022);
            rule__SubsetsRule__Group__1__Impl();

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
    // $ANTLR end "rule__SubsetsRule__Group__1"


    // $ANTLR start "rule__SubsetsRule__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1962:1: rule__SubsetsRule__Group__1__Impl : ( ( rule__SubsetsRule__PortAssignment_1 ) ) ;
    public final void rule__SubsetsRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1966:1: ( ( ( rule__SubsetsRule__PortAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1967:1: ( ( rule__SubsetsRule__PortAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1967:1: ( ( rule__SubsetsRule__PortAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1968:1: ( rule__SubsetsRule__PortAssignment_1 )
            {
             before(grammarAccess.getSubsetsRuleAccess().getPortAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1969:1: ( rule__SubsetsRule__PortAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1969:2: rule__SubsetsRule__PortAssignment_1
            {
            pushFollow(FOLLOW_rule__SubsetsRule__PortAssignment_1_in_rule__SubsetsRule__Group__1__Impl4049);
            rule__SubsetsRule__PortAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSubsetsRuleAccess().getPortAssignment_1()); 

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
    // $ANTLR end "rule__SubsetsRule__Group__1__Impl"


    // $ANTLR start "rule__DefaultValueRule__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1983:1: rule__DefaultValueRule__Group__0 : rule__DefaultValueRule__Group__0__Impl rule__DefaultValueRule__Group__1 ;
    public final void rule__DefaultValueRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1987:1: ( rule__DefaultValueRule__Group__0__Impl rule__DefaultValueRule__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1988:2: rule__DefaultValueRule__Group__0__Impl rule__DefaultValueRule__Group__1
            {
            pushFollow(FOLLOW_rule__DefaultValueRule__Group__0__Impl_in_rule__DefaultValueRule__Group__04083);
            rule__DefaultValueRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DefaultValueRule__Group__1_in_rule__DefaultValueRule__Group__04086);
            rule__DefaultValueRule__Group__1();

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
    // $ANTLR end "rule__DefaultValueRule__Group__0"


    // $ANTLR start "rule__DefaultValueRule__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1995:1: rule__DefaultValueRule__Group__0__Impl : ( '=' ) ;
    public final void rule__DefaultValueRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:1999:1: ( ( '=' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2000:1: ( '=' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2000:1: ( '=' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2001:1: '='
            {
             before(grammarAccess.getDefaultValueRuleAccess().getEqualsSignKeyword_0()); 
            match(input,33,FOLLOW_33_in_rule__DefaultValueRule__Group__0__Impl4114); 
             after(grammarAccess.getDefaultValueRuleAccess().getEqualsSignKeyword_0()); 

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
    // $ANTLR end "rule__DefaultValueRule__Group__0__Impl"


    // $ANTLR start "rule__DefaultValueRule__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2014:1: rule__DefaultValueRule__Group__1 : rule__DefaultValueRule__Group__1__Impl ;
    public final void rule__DefaultValueRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2018:1: ( rule__DefaultValueRule__Group__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2019:2: rule__DefaultValueRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DefaultValueRule__Group__1__Impl_in_rule__DefaultValueRule__Group__14145);
            rule__DefaultValueRule__Group__1__Impl();

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
    // $ANTLR end "rule__DefaultValueRule__Group__1"


    // $ANTLR start "rule__DefaultValueRule__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2025:1: rule__DefaultValueRule__Group__1__Impl : ( ( rule__DefaultValueRule__DefaultAssignment_1 ) ) ;
    public final void rule__DefaultValueRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2029:1: ( ( ( rule__DefaultValueRule__DefaultAssignment_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2030:1: ( ( rule__DefaultValueRule__DefaultAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2030:1: ( ( rule__DefaultValueRule__DefaultAssignment_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2031:1: ( rule__DefaultValueRule__DefaultAssignment_1 )
            {
             before(grammarAccess.getDefaultValueRuleAccess().getDefaultAssignment_1()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2032:1: ( rule__DefaultValueRule__DefaultAssignment_1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2032:2: rule__DefaultValueRule__DefaultAssignment_1
            {
            pushFollow(FOLLOW_rule__DefaultValueRule__DefaultAssignment_1_in_rule__DefaultValueRule__Group__1__Impl4172);
            rule__DefaultValueRule__DefaultAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDefaultValueRuleAccess().getDefaultAssignment_1()); 

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
    // $ANTLR end "rule__DefaultValueRule__Group__1__Impl"


    // $ANTLR start "rule__RealValue__Group_0__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2046:1: rule__RealValue__Group_0__0 : rule__RealValue__Group_0__0__Impl rule__RealValue__Group_0__1 ;
    public final void rule__RealValue__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2050:1: ( rule__RealValue__Group_0__0__Impl rule__RealValue__Group_0__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2051:2: rule__RealValue__Group_0__0__Impl rule__RealValue__Group_0__1
            {
            pushFollow(FOLLOW_rule__RealValue__Group_0__0__Impl_in_rule__RealValue__Group_0__04206);
            rule__RealValue__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RealValue__Group_0__1_in_rule__RealValue__Group_0__04209);
            rule__RealValue__Group_0__1();

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
    // $ANTLR end "rule__RealValue__Group_0__0"


    // $ANTLR start "rule__RealValue__Group_0__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2058:1: rule__RealValue__Group_0__0__Impl : ( ( rule__RealValue__IntegerAssignment_0_0 ) ) ;
    public final void rule__RealValue__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2062:1: ( ( ( rule__RealValue__IntegerAssignment_0_0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2063:1: ( ( rule__RealValue__IntegerAssignment_0_0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2063:1: ( ( rule__RealValue__IntegerAssignment_0_0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2064:1: ( rule__RealValue__IntegerAssignment_0_0 )
            {
             before(grammarAccess.getRealValueAccess().getIntegerAssignment_0_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2065:1: ( rule__RealValue__IntegerAssignment_0_0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2065:2: rule__RealValue__IntegerAssignment_0_0
            {
            pushFollow(FOLLOW_rule__RealValue__IntegerAssignment_0_0_in_rule__RealValue__Group_0__0__Impl4236);
            rule__RealValue__IntegerAssignment_0_0();

            state._fsp--;


            }

             after(grammarAccess.getRealValueAccess().getIntegerAssignment_0_0()); 

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
    // $ANTLR end "rule__RealValue__Group_0__0__Impl"


    // $ANTLR start "rule__RealValue__Group_0__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2075:1: rule__RealValue__Group_0__1 : rule__RealValue__Group_0__1__Impl ;
    public final void rule__RealValue__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2079:1: ( rule__RealValue__Group_0__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2080:2: rule__RealValue__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__RealValue__Group_0__1__Impl_in_rule__RealValue__Group_0__14266);
            rule__RealValue__Group_0__1__Impl();

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
    // $ANTLR end "rule__RealValue__Group_0__1"


    // $ANTLR start "rule__RealValue__Group_0__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2086:1: rule__RealValue__Group_0__1__Impl : ( '.' ) ;
    public final void rule__RealValue__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2090:1: ( ( '.' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2091:1: ( '.' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2091:1: ( '.' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2092:1: '.'
            {
             before(grammarAccess.getRealValueAccess().getFullStopKeyword_0_1()); 
            match(input,34,FOLLOW_34_in_rule__RealValue__Group_0__1__Impl4294); 
             after(grammarAccess.getRealValueAccess().getFullStopKeyword_0_1()); 

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
    // $ANTLR end "rule__RealValue__Group_0__1__Impl"


    // $ANTLR start "rule__RealValue__Group_1__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2109:1: rule__RealValue__Group_1__0 : rule__RealValue__Group_1__0__Impl rule__RealValue__Group_1__1 ;
    public final void rule__RealValue__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2113:1: ( rule__RealValue__Group_1__0__Impl rule__RealValue__Group_1__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2114:2: rule__RealValue__Group_1__0__Impl rule__RealValue__Group_1__1
            {
            pushFollow(FOLLOW_rule__RealValue__Group_1__0__Impl_in_rule__RealValue__Group_1__04329);
            rule__RealValue__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RealValue__Group_1__1_in_rule__RealValue__Group_1__04332);
            rule__RealValue__Group_1__1();

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
    // $ANTLR end "rule__RealValue__Group_1__0"


    // $ANTLR start "rule__RealValue__Group_1__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2121:1: rule__RealValue__Group_1__0__Impl : ( '.' ) ;
    public final void rule__RealValue__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2125:1: ( ( '.' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2126:1: ( '.' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2126:1: ( '.' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2127:1: '.'
            {
             before(grammarAccess.getRealValueAccess().getFullStopKeyword_1_0()); 
            match(input,34,FOLLOW_34_in_rule__RealValue__Group_1__0__Impl4360); 
             after(grammarAccess.getRealValueAccess().getFullStopKeyword_1_0()); 

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
    // $ANTLR end "rule__RealValue__Group_1__0__Impl"


    // $ANTLR start "rule__RealValue__Group_1__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2140:1: rule__RealValue__Group_1__1 : rule__RealValue__Group_1__1__Impl ;
    public final void rule__RealValue__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2144:1: ( rule__RealValue__Group_1__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2145:2: rule__RealValue__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__RealValue__Group_1__1__Impl_in_rule__RealValue__Group_1__14391);
            rule__RealValue__Group_1__1__Impl();

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
    // $ANTLR end "rule__RealValue__Group_1__1"


    // $ANTLR start "rule__RealValue__Group_1__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2151:1: rule__RealValue__Group_1__1__Impl : ( ( rule__RealValue__FractionAssignment_1_1 ) ) ;
    public final void rule__RealValue__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2155:1: ( ( ( rule__RealValue__FractionAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2156:1: ( ( rule__RealValue__FractionAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2156:1: ( ( rule__RealValue__FractionAssignment_1_1 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2157:1: ( rule__RealValue__FractionAssignment_1_1 )
            {
             before(grammarAccess.getRealValueAccess().getFractionAssignment_1_1()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2158:1: ( rule__RealValue__FractionAssignment_1_1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2158:2: rule__RealValue__FractionAssignment_1_1
            {
            pushFollow(FOLLOW_rule__RealValue__FractionAssignment_1_1_in_rule__RealValue__Group_1__1__Impl4418);
            rule__RealValue__FractionAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getRealValueAccess().getFractionAssignment_1_1()); 

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
    // $ANTLR end "rule__RealValue__Group_1__1__Impl"


    // $ANTLR start "rule__RealValue__Group_2__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2172:1: rule__RealValue__Group_2__0 : rule__RealValue__Group_2__0__Impl rule__RealValue__Group_2__1 ;
    public final void rule__RealValue__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2176:1: ( rule__RealValue__Group_2__0__Impl rule__RealValue__Group_2__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2177:2: rule__RealValue__Group_2__0__Impl rule__RealValue__Group_2__1
            {
            pushFollow(FOLLOW_rule__RealValue__Group_2__0__Impl_in_rule__RealValue__Group_2__04452);
            rule__RealValue__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RealValue__Group_2__1_in_rule__RealValue__Group_2__04455);
            rule__RealValue__Group_2__1();

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
    // $ANTLR end "rule__RealValue__Group_2__0"


    // $ANTLR start "rule__RealValue__Group_2__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2184:1: rule__RealValue__Group_2__0__Impl : ( ( rule__RealValue__IntegerAssignment_2_0 ) ) ;
    public final void rule__RealValue__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2188:1: ( ( ( rule__RealValue__IntegerAssignment_2_0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2189:1: ( ( rule__RealValue__IntegerAssignment_2_0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2189:1: ( ( rule__RealValue__IntegerAssignment_2_0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2190:1: ( rule__RealValue__IntegerAssignment_2_0 )
            {
             before(grammarAccess.getRealValueAccess().getIntegerAssignment_2_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2191:1: ( rule__RealValue__IntegerAssignment_2_0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2191:2: rule__RealValue__IntegerAssignment_2_0
            {
            pushFollow(FOLLOW_rule__RealValue__IntegerAssignment_2_0_in_rule__RealValue__Group_2__0__Impl4482);
            rule__RealValue__IntegerAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getRealValueAccess().getIntegerAssignment_2_0()); 

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
    // $ANTLR end "rule__RealValue__Group_2__0__Impl"


    // $ANTLR start "rule__RealValue__Group_2__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2201:1: rule__RealValue__Group_2__1 : rule__RealValue__Group_2__1__Impl rule__RealValue__Group_2__2 ;
    public final void rule__RealValue__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2205:1: ( rule__RealValue__Group_2__1__Impl rule__RealValue__Group_2__2 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2206:2: rule__RealValue__Group_2__1__Impl rule__RealValue__Group_2__2
            {
            pushFollow(FOLLOW_rule__RealValue__Group_2__1__Impl_in_rule__RealValue__Group_2__14512);
            rule__RealValue__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RealValue__Group_2__2_in_rule__RealValue__Group_2__14515);
            rule__RealValue__Group_2__2();

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
    // $ANTLR end "rule__RealValue__Group_2__1"


    // $ANTLR start "rule__RealValue__Group_2__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2213:1: rule__RealValue__Group_2__1__Impl : ( '.' ) ;
    public final void rule__RealValue__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2217:1: ( ( '.' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2218:1: ( '.' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2218:1: ( '.' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2219:1: '.'
            {
             before(grammarAccess.getRealValueAccess().getFullStopKeyword_2_1()); 
            match(input,34,FOLLOW_34_in_rule__RealValue__Group_2__1__Impl4543); 
             after(grammarAccess.getRealValueAccess().getFullStopKeyword_2_1()); 

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
    // $ANTLR end "rule__RealValue__Group_2__1__Impl"


    // $ANTLR start "rule__RealValue__Group_2__2"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2232:1: rule__RealValue__Group_2__2 : rule__RealValue__Group_2__2__Impl ;
    public final void rule__RealValue__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2236:1: ( rule__RealValue__Group_2__2__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2237:2: rule__RealValue__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__RealValue__Group_2__2__Impl_in_rule__RealValue__Group_2__24574);
            rule__RealValue__Group_2__2__Impl();

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
    // $ANTLR end "rule__RealValue__Group_2__2"


    // $ANTLR start "rule__RealValue__Group_2__2__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2243:1: rule__RealValue__Group_2__2__Impl : ( ( rule__RealValue__FractionAssignment_2_2 ) ) ;
    public final void rule__RealValue__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2247:1: ( ( ( rule__RealValue__FractionAssignment_2_2 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2248:1: ( ( rule__RealValue__FractionAssignment_2_2 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2248:1: ( ( rule__RealValue__FractionAssignment_2_2 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2249:1: ( rule__RealValue__FractionAssignment_2_2 )
            {
             before(grammarAccess.getRealValueAccess().getFractionAssignment_2_2()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2250:1: ( rule__RealValue__FractionAssignment_2_2 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2250:2: rule__RealValue__FractionAssignment_2_2
            {
            pushFollow(FOLLOW_rule__RealValue__FractionAssignment_2_2_in_rule__RealValue__Group_2__2__Impl4601);
            rule__RealValue__FractionAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getRealValueAccess().getFractionAssignment_2_2()); 

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
    // $ANTLR end "rule__RealValue__Group_2__2__Impl"


    // $ANTLR start "rule__NullValue__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2266:1: rule__NullValue__Group__0 : rule__NullValue__Group__0__Impl rule__NullValue__Group__1 ;
    public final void rule__NullValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2270:1: ( rule__NullValue__Group__0__Impl rule__NullValue__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2271:2: rule__NullValue__Group__0__Impl rule__NullValue__Group__1
            {
            pushFollow(FOLLOW_rule__NullValue__Group__0__Impl_in_rule__NullValue__Group__04637);
            rule__NullValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NullValue__Group__1_in_rule__NullValue__Group__04640);
            rule__NullValue__Group__1();

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
    // $ANTLR end "rule__NullValue__Group__0"


    // $ANTLR start "rule__NullValue__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2278:1: rule__NullValue__Group__0__Impl : ( () ) ;
    public final void rule__NullValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2282:1: ( ( () ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2283:1: ( () )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2283:1: ( () )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2284:1: ()
            {
             before(grammarAccess.getNullValueAccess().getNullValueAction_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2285:1: ()
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2287:1: 
            {
            }

             after(grammarAccess.getNullValueAccess().getNullValueAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullValue__Group__0__Impl"


    // $ANTLR start "rule__NullValue__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2297:1: rule__NullValue__Group__1 : rule__NullValue__Group__1__Impl ;
    public final void rule__NullValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2301:1: ( rule__NullValue__Group__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2302:2: rule__NullValue__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__NullValue__Group__1__Impl_in_rule__NullValue__Group__14698);
            rule__NullValue__Group__1__Impl();

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
    // $ANTLR end "rule__NullValue__Group__1"


    // $ANTLR start "rule__NullValue__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2308:1: rule__NullValue__Group__1__Impl : ( 'null' ) ;
    public final void rule__NullValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2312:1: ( ( 'null' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2313:1: ( 'null' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2313:1: ( 'null' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2314:1: 'null'
            {
             before(grammarAccess.getNullValueAccess().getNullKeyword_1()); 
            match(input,35,FOLLOW_35_in_rule__NullValue__Group__1__Impl4726); 
             after(grammarAccess.getNullValueAccess().getNullKeyword_1()); 

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
    // $ANTLR end "rule__NullValue__Group__1__Impl"


    // $ANTLR start "rule__NoValue__Group__0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2331:1: rule__NoValue__Group__0 : rule__NoValue__Group__0__Impl rule__NoValue__Group__1 ;
    public final void rule__NoValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2335:1: ( rule__NoValue__Group__0__Impl rule__NoValue__Group__1 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2336:2: rule__NoValue__Group__0__Impl rule__NoValue__Group__1
            {
            pushFollow(FOLLOW_rule__NoValue__Group__0__Impl_in_rule__NoValue__Group__04761);
            rule__NoValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NoValue__Group__1_in_rule__NoValue__Group__04764);
            rule__NoValue__Group__1();

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
    // $ANTLR end "rule__NoValue__Group__0"


    // $ANTLR start "rule__NoValue__Group__0__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2343:1: rule__NoValue__Group__0__Impl : ( () ) ;
    public final void rule__NoValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2347:1: ( ( () ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2348:1: ( () )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2348:1: ( () )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2349:1: ()
            {
             before(grammarAccess.getNoValueAccess().getNoValueAction_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2350:1: ()
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2352:1: 
            {
            }

             after(grammarAccess.getNoValueAccess().getNoValueAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NoValue__Group__0__Impl"


    // $ANTLR start "rule__NoValue__Group__1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2362:1: rule__NoValue__Group__1 : rule__NoValue__Group__1__Impl ;
    public final void rule__NoValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2366:1: ( rule__NoValue__Group__1__Impl )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2367:2: rule__NoValue__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__NoValue__Group__1__Impl_in_rule__NoValue__Group__14822);
            rule__NoValue__Group__1__Impl();

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
    // $ANTLR end "rule__NoValue__Group__1"


    // $ANTLR start "rule__NoValue__Group__1__Impl"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2373:1: rule__NoValue__Group__1__Impl : ( 'none' ) ;
    public final void rule__NoValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2377:1: ( ( 'none' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2378:1: ( 'none' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2378:1: ( 'none' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2379:1: 'none'
            {
             before(grammarAccess.getNoValueAccess().getNoneKeyword_1()); 
            match(input,36,FOLLOW_36_in_rule__NoValue__Group__1__Impl4850); 
             after(grammarAccess.getNoValueAccess().getNoneKeyword_1()); 

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
    // $ANTLR end "rule__NoValue__Group__1__Impl"


    // $ANTLR start "rule__PortRule__VisibilityAssignment_0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2397:1: rule__PortRule__VisibilityAssignment_0 : ( ruleVisibilityRule ) ;
    public final void rule__PortRule__VisibilityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2401:1: ( ( ruleVisibilityRule ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2402:1: ( ruleVisibilityRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2402:1: ( ruleVisibilityRule )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2403:1: ruleVisibilityRule
            {
             before(grammarAccess.getPortRuleAccess().getVisibilityVisibilityRuleParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleVisibilityRule_in_rule__PortRule__VisibilityAssignment_04890);
            ruleVisibilityRule();

            state._fsp--;

             after(grammarAccess.getPortRuleAccess().getVisibilityVisibilityRuleParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__PortRule__VisibilityAssignment_0"


    // $ANTLR start "rule__PortRule__DerivedAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2412:1: rule__PortRule__DerivedAssignment_1 : ( ( '/' ) ) ;
    public final void rule__PortRule__DerivedAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2416:1: ( ( ( '/' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2417:1: ( ( '/' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2417:1: ( ( '/' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2418:1: ( '/' )
            {
             before(grammarAccess.getPortRuleAccess().getDerivedSolidusKeyword_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2419:1: ( '/' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2420:1: '/'
            {
             before(grammarAccess.getPortRuleAccess().getDerivedSolidusKeyword_1_0()); 
            match(input,37,FOLLOW_37_in_rule__PortRule__DerivedAssignment_14926); 
             after(grammarAccess.getPortRuleAccess().getDerivedSolidusKeyword_1_0()); 

            }

             after(grammarAccess.getPortRuleAccess().getDerivedSolidusKeyword_1_0()); 

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
    // $ANTLR end "rule__PortRule__DerivedAssignment_1"


    // $ANTLR start "rule__PortRule__NameAssignment_2"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2435:1: rule__PortRule__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__PortRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2439:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2440:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2440:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2441:1: RULE_ID
            {
             before(grammarAccess.getPortRuleAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PortRule__NameAssignment_24965); 
             after(grammarAccess.getPortRuleAccess().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__PortRule__NameAssignment_2"


    // $ANTLR start "rule__PortRule__ConjugatedAssignment_3_1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2450:1: rule__PortRule__ConjugatedAssignment_3_1 : ( ( '~' ) ) ;
    public final void rule__PortRule__ConjugatedAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2454:1: ( ( ( '~' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2455:1: ( ( '~' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2455:1: ( ( '~' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2456:1: ( '~' )
            {
             before(grammarAccess.getPortRuleAccess().getConjugatedTildeKeyword_3_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2457:1: ( '~' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2458:1: '~'
            {
             before(grammarAccess.getPortRuleAccess().getConjugatedTildeKeyword_3_1_0()); 
            match(input,16,FOLLOW_16_in_rule__PortRule__ConjugatedAssignment_3_15001); 
             after(grammarAccess.getPortRuleAccess().getConjugatedTildeKeyword_3_1_0()); 

            }

             after(grammarAccess.getPortRuleAccess().getConjugatedTildeKeyword_3_1_0()); 

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
    // $ANTLR end "rule__PortRule__ConjugatedAssignment_3_1"


    // $ANTLR start "rule__PortRule__TypeAssignment_3_2_0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2473:1: rule__PortRule__TypeAssignment_3_2_0 : ( ruleTypeRule ) ;
    public final void rule__PortRule__TypeAssignment_3_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2477:1: ( ( ruleTypeRule ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2478:1: ( ruleTypeRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2478:1: ( ruleTypeRule )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2479:1: ruleTypeRule
            {
             before(grammarAccess.getPortRuleAccess().getTypeTypeRuleParserRuleCall_3_2_0_0()); 
            pushFollow(FOLLOW_ruleTypeRule_in_rule__PortRule__TypeAssignment_3_2_05040);
            ruleTypeRule();

            state._fsp--;

             after(grammarAccess.getPortRuleAccess().getTypeTypeRuleParserRuleCall_3_2_0_0()); 

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
    // $ANTLR end "rule__PortRule__TypeAssignment_3_2_0"


    // $ANTLR start "rule__PortRule__TypeUndefinedAssignment_3_2_1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2488:1: rule__PortRule__TypeUndefinedAssignment_3_2_1 : ( ( '<Undefined>' ) ) ;
    public final void rule__PortRule__TypeUndefinedAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2492:1: ( ( ( '<Undefined>' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2493:1: ( ( '<Undefined>' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2493:1: ( ( '<Undefined>' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2494:1: ( '<Undefined>' )
            {
             before(grammarAccess.getPortRuleAccess().getTypeUndefinedUndefinedKeyword_3_2_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2495:1: ( '<Undefined>' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2496:1: '<Undefined>'
            {
             before(grammarAccess.getPortRuleAccess().getTypeUndefinedUndefinedKeyword_3_2_1_0()); 
            match(input,38,FOLLOW_38_in_rule__PortRule__TypeUndefinedAssignment_3_2_15076); 
             after(grammarAccess.getPortRuleAccess().getTypeUndefinedUndefinedKeyword_3_2_1_0()); 

            }

             after(grammarAccess.getPortRuleAccess().getTypeUndefinedUndefinedKeyword_3_2_1_0()); 

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
    // $ANTLR end "rule__PortRule__TypeUndefinedAssignment_3_2_1"


    // $ANTLR start "rule__PortRule__MultiplicityAssignment_4"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2511:1: rule__PortRule__MultiplicityAssignment_4 : ( ruleMultiplicityRule ) ;
    public final void rule__PortRule__MultiplicityAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2515:1: ( ( ruleMultiplicityRule ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2516:1: ( ruleMultiplicityRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2516:1: ( ruleMultiplicityRule )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2517:1: ruleMultiplicityRule
            {
             before(grammarAccess.getPortRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_rule__PortRule__MultiplicityAssignment_45115);
            ruleMultiplicityRule();

            state._fsp--;

             after(grammarAccess.getPortRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_4_0()); 

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
    // $ANTLR end "rule__PortRule__MultiplicityAssignment_4"


    // $ANTLR start "rule__PortRule__ModifiersAssignment_5"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2526:1: rule__PortRule__ModifiersAssignment_5 : ( ruleModifiersRule ) ;
    public final void rule__PortRule__ModifiersAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2530:1: ( ( ruleModifiersRule ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2531:1: ( ruleModifiersRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2531:1: ( ruleModifiersRule )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2532:1: ruleModifiersRule
            {
             before(grammarAccess.getPortRuleAccess().getModifiersModifiersRuleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_rule__PortRule__ModifiersAssignment_55146);
            ruleModifiersRule();

            state._fsp--;

             after(grammarAccess.getPortRuleAccess().getModifiersModifiersRuleParserRuleCall_5_0()); 

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
    // $ANTLR end "rule__PortRule__ModifiersAssignment_5"


    // $ANTLR start "rule__PortRule__DefaultAssignment_6"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2541:1: rule__PortRule__DefaultAssignment_6 : ( ruleDefaultValueRule ) ;
    public final void rule__PortRule__DefaultAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2545:1: ( ( ruleDefaultValueRule ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2546:1: ( ruleDefaultValueRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2546:1: ( ruleDefaultValueRule )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2547:1: ruleDefaultValueRule
            {
             before(grammarAccess.getPortRuleAccess().getDefaultDefaultValueRuleParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleDefaultValueRule_in_rule__PortRule__DefaultAssignment_65177);
            ruleDefaultValueRule();

            state._fsp--;

             after(grammarAccess.getPortRuleAccess().getDefaultDefaultValueRuleParserRuleCall_6_0()); 

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
    // $ANTLR end "rule__PortRule__DefaultAssignment_6"


    // $ANTLR start "rule__VisibilityRule__VisibilityAssignment"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2556:1: rule__VisibilityRule__VisibilityAssignment : ( ruleVisibilityKind ) ;
    public final void rule__VisibilityRule__VisibilityAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2560:1: ( ( ruleVisibilityKind ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2561:1: ( ruleVisibilityKind )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2561:1: ( ruleVisibilityKind )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2562:1: ruleVisibilityKind
            {
             before(grammarAccess.getVisibilityRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0()); 
            pushFollow(FOLLOW_ruleVisibilityKind_in_rule__VisibilityRule__VisibilityAssignment5208);
            ruleVisibilityKind();

            state._fsp--;

             after(grammarAccess.getVisibilityRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0()); 

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
    // $ANTLR end "rule__VisibilityRule__VisibilityAssignment"


    // $ANTLR start "rule__TypeRule__PathAssignment_0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2571:1: rule__TypeRule__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__TypeRule__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2575:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2576:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2576:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2577:1: ruleQualifiedName
            {
             before(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TypeRule__PathAssignment_05239);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__TypeRule__PathAssignment_0"


    // $ANTLR start "rule__TypeRule__TypeAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2586:1: rule__TypeRule__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRule__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2590:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2591:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2591:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2592:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRuleAccess().getTypeClassifierCrossReference_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2593:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2594:1: RULE_ID
            {
             before(grammarAccess.getTypeRuleAccess().getTypeClassifierIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TypeRule__TypeAssignment_15274); 
             after(grammarAccess.getTypeRuleAccess().getTypeClassifierIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getTypeRuleAccess().getTypeClassifierCrossReference_1_0()); 

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
    // $ANTLR end "rule__TypeRule__TypeAssignment_1"


    // $ANTLR start "rule__QualifiedName__PathAssignment_0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2605:1: rule__QualifiedName__PathAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__QualifiedName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2609:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2610:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2610:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2611:1: ( RULE_ID )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2612:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2613:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_05313); 
             after(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 

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
    // $ANTLR end "rule__QualifiedName__PathAssignment_0"


    // $ANTLR start "rule__QualifiedName__RemainingAssignment_2"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2624:1: rule__QualifiedName__RemainingAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__QualifiedName__RemainingAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2628:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2629:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2629:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2630:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_25348);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__QualifiedName__RemainingAssignment_2"


    // $ANTLR start "rule__MultiplicityRule__BoundsAssignment_1_0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2639:1: rule__MultiplicityRule__BoundsAssignment_1_0 : ( ruleBoundSpecification ) ;
    public final void rule__MultiplicityRule__BoundsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2643:1: ( ( ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2644:1: ( ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2644:1: ( ruleBoundSpecification )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2645:1: ruleBoundSpecification
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_1_05379);
            ruleBoundSpecification();

            state._fsp--;

             after(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0_0()); 

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
    // $ANTLR end "rule__MultiplicityRule__BoundsAssignment_1_0"


    // $ANTLR start "rule__MultiplicityRule__BoundsAssignment_2"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2654:1: rule__MultiplicityRule__BoundsAssignment_2 : ( ruleBoundSpecification ) ;
    public final void rule__MultiplicityRule__BoundsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2658:1: ( ( ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2659:1: ( ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2659:1: ( ruleBoundSpecification )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2660:1: ruleBoundSpecification
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_25410);
            ruleBoundSpecification();

            state._fsp--;

             after(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__MultiplicityRule__BoundsAssignment_2"


    // $ANTLR start "rule__BoundSpecification__ValueAssignment"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2669:1: rule__BoundSpecification__ValueAssignment : ( ( rule__BoundSpecification__ValueAlternatives_0 ) ) ;
    public final void rule__BoundSpecification__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2673:1: ( ( ( rule__BoundSpecification__ValueAlternatives_0 ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2674:1: ( ( rule__BoundSpecification__ValueAlternatives_0 ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2674:1: ( ( rule__BoundSpecification__ValueAlternatives_0 ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2675:1: ( rule__BoundSpecification__ValueAlternatives_0 )
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueAlternatives_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2676:1: ( rule__BoundSpecification__ValueAlternatives_0 )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2676:2: rule__BoundSpecification__ValueAlternatives_0
            {
            pushFollow(FOLLOW_rule__BoundSpecification__ValueAlternatives_0_in_rule__BoundSpecification__ValueAssignment5441);
            rule__BoundSpecification__ValueAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getBoundSpecificationAccess().getValueAlternatives_0()); 

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
    // $ANTLR end "rule__BoundSpecification__ValueAssignment"


    // $ANTLR start "rule__ModifiersRule__ValuesAssignment_2_0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2685:1: rule__ModifiersRule__ValuesAssignment_2_0 : ( ruleModifierSpecification ) ;
    public final void rule__ModifiersRule__ValuesAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2689:1: ( ( ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2690:1: ( ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2690:1: ( ruleModifierSpecification )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2691:1: ruleModifierSpecification
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_05474);
            ruleModifierSpecification();

            state._fsp--;

             after(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_0_0()); 

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
    // $ANTLR end "rule__ModifiersRule__ValuesAssignment_2_0"


    // $ANTLR start "rule__ModifiersRule__ValuesAssignment_2_1_1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2700:1: rule__ModifiersRule__ValuesAssignment_2_1_1 : ( ruleModifierSpecification ) ;
    public final void rule__ModifiersRule__ValuesAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2704:1: ( ( ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2705:1: ( ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2705:1: ( ruleModifierSpecification )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2706:1: ruleModifierSpecification
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_1_15505);
            ruleModifierSpecification();

            state._fsp--;

             after(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_1_0()); 

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
    // $ANTLR end "rule__ModifiersRule__ValuesAssignment_2_1_1"


    // $ANTLR start "rule__ModifierSpecification__ValueAssignment_0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2715:1: rule__ModifierSpecification__ValueAssignment_0 : ( ruleModifierKind ) ;
    public final void rule__ModifierSpecification__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2719:1: ( ( ruleModifierKind ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2720:1: ( ruleModifierKind )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2720:1: ( ruleModifierKind )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2721:1: ruleModifierKind
            {
             before(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleModifierKind_in_rule__ModifierSpecification__ValueAssignment_05536);
            ruleModifierKind();

            state._fsp--;

             after(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0_0()); 

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
    // $ANTLR end "rule__ModifierSpecification__ValueAssignment_0"


    // $ANTLR start "rule__ModifierSpecification__RedefinesAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2730:1: rule__ModifierSpecification__RedefinesAssignment_1 : ( ruleRedefinesRule ) ;
    public final void rule__ModifierSpecification__RedefinesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2734:1: ( ( ruleRedefinesRule ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2735:1: ( ruleRedefinesRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2735:1: ( ruleRedefinesRule )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2736:1: ruleRedefinesRule
            {
             before(grammarAccess.getModifierSpecificationAccess().getRedefinesRedefinesRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleRedefinesRule_in_rule__ModifierSpecification__RedefinesAssignment_15567);
            ruleRedefinesRule();

            state._fsp--;

             after(grammarAccess.getModifierSpecificationAccess().getRedefinesRedefinesRuleParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__ModifierSpecification__RedefinesAssignment_1"


    // $ANTLR start "rule__ModifierSpecification__SubsetsAssignment_2"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2745:1: rule__ModifierSpecification__SubsetsAssignment_2 : ( ruleSubsetsRule ) ;
    public final void rule__ModifierSpecification__SubsetsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2749:1: ( ( ruleSubsetsRule ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2750:1: ( ruleSubsetsRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2750:1: ( ruleSubsetsRule )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2751:1: ruleSubsetsRule
            {
             before(grammarAccess.getModifierSpecificationAccess().getSubsetsSubsetsRuleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleSubsetsRule_in_rule__ModifierSpecification__SubsetsAssignment_25598);
            ruleSubsetsRule();

            state._fsp--;

             after(grammarAccess.getModifierSpecificationAccess().getSubsetsSubsetsRuleParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__ModifierSpecification__SubsetsAssignment_2"


    // $ANTLR start "rule__RedefinesRule__PortAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2760:1: rule__RedefinesRule__PortAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__RedefinesRule__PortAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2764:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2765:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2765:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2766:1: ( RULE_ID )
            {
             before(grammarAccess.getRedefinesRuleAccess().getPortPortCrossReference_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2767:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2768:1: RULE_ID
            {
             before(grammarAccess.getRedefinesRuleAccess().getPortPortIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RedefinesRule__PortAssignment_15633); 
             after(grammarAccess.getRedefinesRuleAccess().getPortPortIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getRedefinesRuleAccess().getPortPortCrossReference_1_0()); 

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
    // $ANTLR end "rule__RedefinesRule__PortAssignment_1"


    // $ANTLR start "rule__SubsetsRule__PortAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2779:1: rule__SubsetsRule__PortAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__SubsetsRule__PortAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2783:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2784:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2784:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2785:1: ( RULE_ID )
            {
             before(grammarAccess.getSubsetsRuleAccess().getPortPortCrossReference_1_0()); 
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2786:1: ( RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2787:1: RULE_ID
            {
             before(grammarAccess.getSubsetsRuleAccess().getPortPortIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubsetsRule__PortAssignment_15672); 
             after(grammarAccess.getSubsetsRuleAccess().getPortPortIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getSubsetsRuleAccess().getPortPortCrossReference_1_0()); 

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
    // $ANTLR end "rule__SubsetsRule__PortAssignment_1"


    // $ANTLR start "rule__DefaultValueRule__DefaultAssignment_1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2798:1: rule__DefaultValueRule__DefaultAssignment_1 : ( ruleValue ) ;
    public final void rule__DefaultValueRule__DefaultAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2802:1: ( ( ruleValue ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2803:1: ( ruleValue )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2803:1: ( ruleValue )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2804:1: ruleValue
            {
             before(grammarAccess.getDefaultValueRuleAccess().getDefaultValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__DefaultValueRule__DefaultAssignment_15707);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getDefaultValueRuleAccess().getDefaultValueParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__DefaultValueRule__DefaultAssignment_1"


    // $ANTLR start "rule__IntValue__LiteralIntegerAssignment"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2813:1: rule__IntValue__LiteralIntegerAssignment : ( RULE_INT ) ;
    public final void rule__IntValue__LiteralIntegerAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2817:1: ( ( RULE_INT ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2818:1: ( RULE_INT )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2818:1: ( RULE_INT )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2819:1: RULE_INT
            {
             before(grammarAccess.getIntValueAccess().getLiteralIntegerINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__IntValue__LiteralIntegerAssignment5738); 
             after(grammarAccess.getIntValueAccess().getLiteralIntegerINTTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__IntValue__LiteralIntegerAssignment"


    // $ANTLR start "rule__StringValue__LiteralStringAssignment"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2828:1: rule__StringValue__LiteralStringAssignment : ( RULE_STRING ) ;
    public final void rule__StringValue__LiteralStringAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2832:1: ( ( RULE_STRING ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2833:1: ( RULE_STRING )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2833:1: ( RULE_STRING )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2834:1: RULE_STRING
            {
             before(grammarAccess.getStringValueAccess().getLiteralStringSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringValue__LiteralStringAssignment5769); 
             after(grammarAccess.getStringValueAccess().getLiteralStringSTRINGTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__StringValue__LiteralStringAssignment"


    // $ANTLR start "rule__BooleanValue__LiteralBooleanAssignment"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2843:1: rule__BooleanValue__LiteralBooleanAssignment : ( ruleBooleanLiterals ) ;
    public final void rule__BooleanValue__LiteralBooleanAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2847:1: ( ( ruleBooleanLiterals ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2848:1: ( ruleBooleanLiterals )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2848:1: ( ruleBooleanLiterals )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2849:1: ruleBooleanLiterals
            {
             before(grammarAccess.getBooleanValueAccess().getLiteralBooleanBooleanLiteralsEnumRuleCall_0()); 
            pushFollow(FOLLOW_ruleBooleanLiterals_in_rule__BooleanValue__LiteralBooleanAssignment5800);
            ruleBooleanLiterals();

            state._fsp--;

             after(grammarAccess.getBooleanValueAccess().getLiteralBooleanBooleanLiteralsEnumRuleCall_0()); 

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
    // $ANTLR end "rule__BooleanValue__LiteralBooleanAssignment"


    // $ANTLR start "rule__RealValue__IntegerAssignment_0_0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2858:1: rule__RealValue__IntegerAssignment_0_0 : ( RULE_INT ) ;
    public final void rule__RealValue__IntegerAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2862:1: ( ( RULE_INT ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2863:1: ( RULE_INT )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2863:1: ( RULE_INT )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2864:1: RULE_INT
            {
             before(grammarAccess.getRealValueAccess().getIntegerINTTerminalRuleCall_0_0_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__RealValue__IntegerAssignment_0_05831); 
             after(grammarAccess.getRealValueAccess().getIntegerINTTerminalRuleCall_0_0_0()); 

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
    // $ANTLR end "rule__RealValue__IntegerAssignment_0_0"


    // $ANTLR start "rule__RealValue__FractionAssignment_1_1"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2873:1: rule__RealValue__FractionAssignment_1_1 : ( RULE_INT ) ;
    public final void rule__RealValue__FractionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2877:1: ( ( RULE_INT ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2878:1: ( RULE_INT )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2878:1: ( RULE_INT )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2879:1: RULE_INT
            {
             before(grammarAccess.getRealValueAccess().getFractionINTTerminalRuleCall_1_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__RealValue__FractionAssignment_1_15862); 
             after(grammarAccess.getRealValueAccess().getFractionINTTerminalRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__RealValue__FractionAssignment_1_1"


    // $ANTLR start "rule__RealValue__IntegerAssignment_2_0"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2888:1: rule__RealValue__IntegerAssignment_2_0 : ( RULE_INT ) ;
    public final void rule__RealValue__IntegerAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2892:1: ( ( RULE_INT ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2893:1: ( RULE_INT )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2893:1: ( RULE_INT )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2894:1: RULE_INT
            {
             before(grammarAccess.getRealValueAccess().getIntegerINTTerminalRuleCall_2_0_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__RealValue__IntegerAssignment_2_05893); 
             after(grammarAccess.getRealValueAccess().getIntegerINTTerminalRuleCall_2_0_0()); 

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
    // $ANTLR end "rule__RealValue__IntegerAssignment_2_0"


    // $ANTLR start "rule__RealValue__FractionAssignment_2_2"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2903:1: rule__RealValue__FractionAssignment_2_2 : ( RULE_INT ) ;
    public final void rule__RealValue__FractionAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2907:1: ( ( RULE_INT ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2908:1: ( RULE_INT )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2908:1: ( RULE_INT )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/ui/contentassist/antlr/internal/InternalUmlPort.g:2909:1: RULE_INT
            {
             before(grammarAccess.getRealValueAccess().getFractionINTTerminalRuleCall_2_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__RealValue__FractionAssignment_2_25924); 
             after(grammarAccess.getRealValueAccess().getFractionINTTerminalRuleCall_2_2_0()); 

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
    // $ANTLR end "rule__RealValue__FractionAssignment_2_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_rulePortRule_in_entryRulePortRule61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortRule68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group__0_in_rulePortRule94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityRule_in_entryRuleVisibilityRule121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVisibilityRule128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibilityRule__VisibilityAssignment_in_ruleVisibilityRule154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRule_in_entryRuleTypeRule181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRule188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__0_in_ruleTypeRule214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityRule308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__0_in_ruleMultiplicityRule334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoundSpecification368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BoundSpecification__ValueAssignment_in_ruleBoundSpecification394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteral_in_entryRuleUnlimitedLiteral421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedLiteral428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnlimitedLiteral__Alternatives_in_ruleUnlimitedLiteral454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule540 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifiersRule547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__0_in_ruleModifiersRule573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification600 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifierSpecification607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierSpecification__Alternatives_in_ruleModifierSpecification633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRedefinesRule_in_entryRuleRedefinesRule660 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRedefinesRule667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RedefinesRule__Group__0_in_ruleRedefinesRule693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubsetsRule_in_entryRuleSubsetsRule720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubsetsRule727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubsetsRule__Group__0_in_ruleSubsetsRule753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultValueRule_in_entryRuleDefaultValueRule780 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultValueRule787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__Group__0_in_ruleDefaultValueRule813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Alternatives_in_ruleValue873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntValue_in_entryRuleIntValue900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntValue907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntValue__LiteralIntegerAssignment_in_ruleIntValue933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_entryRuleStringValue960 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringValue967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringValue__LiteralStringAssignment_in_ruleStringValue993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanValue_in_entryRuleBooleanValue1020 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanValue1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanValue__LiteralBooleanAssignment_in_ruleBooleanValue1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealValue_in_entryRuleRealValue1080 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealValue1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealValue__Alternatives_in_ruleRealValue1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullValue_in_entryRuleNullValue1140 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullValue1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NullValue__Group__0_in_ruleNullValue1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoValue_in_entryRuleNoValue1200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNoValue1207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NoValue__Group__0_in_ruleNoValue1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierKind__Alternatives_in_ruleModifierKind1306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiterals__Alternatives_in_ruleBooleanLiterals1342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__TypeAssignment_3_2_0_in_rule__PortRule__Alternatives_3_21377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__TypeUndefinedAssignment_3_2_1_in_rule__PortRule__Alternatives_3_21395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteral_in_rule__BoundSpecification__ValueAlternatives_01428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_rule__BoundSpecification__ValueAlternatives_01445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__UnlimitedLiteral__Alternatives1477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__UnlimitedLiteral__Alternatives1495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierSpecification__ValueAssignment_0_in_rule__ModifierSpecification__Alternatives1529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierSpecification__RedefinesAssignment_1_in_rule__ModifierSpecification__Alternatives1547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierSpecification__SubsetsAssignment_2_in_rule__ModifierSpecification__Alternatives1565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntValue_in_rule__Value__Alternatives1598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_rule__Value__Alternatives1615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanValue_in_rule__Value__Alternatives1632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealValue_in_rule__Value__Alternatives1649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullValue_in_rule__Value__Alternatives1666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoValue_in_rule__Value__Alternatives1683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealValue__Group_0__0_in_rule__RealValue__Alternatives1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealValue__Group_1__0_in_rule__RealValue__Alternatives1733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealValue__Group_2__0_in_rule__RealValue__Alternatives1751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__VisibilityKind__Alternatives1785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__VisibilityKind__Alternatives1806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__VisibilityKind__Alternatives1827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__VisibilityKind__Alternatives1848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ModifierKind__Alternatives1884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ModifierKind__Alternatives1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ModifierKind__Alternatives1926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ModifierKind__Alternatives1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__BooleanLiterals__Alternatives1983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__BooleanLiterals__Alternatives2004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group__0__Impl_in_rule__PortRule__Group__02037 = new BitSet(new long[]{0x0000002000000040L});
    public static final BitSet FOLLOW_rule__PortRule__Group__1_in_rule__PortRule__Group__02040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__VisibilityAssignment_0_in_rule__PortRule__Group__0__Impl2067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group__1__Impl_in_rule__PortRule__Group__12098 = new BitSet(new long[]{0x0000002000000040L});
    public static final BitSet FOLLOW_rule__PortRule__Group__2_in_rule__PortRule__Group__12101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__DerivedAssignment_1_in_rule__PortRule__Group__1__Impl2128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group__2__Impl_in_rule__PortRule__Group__22159 = new BitSet(new long[]{0x0000000212800000L});
    public static final BitSet FOLLOW_rule__PortRule__Group__3_in_rule__PortRule__Group__22162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__NameAssignment_2_in_rule__PortRule__Group__2__Impl2189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group__3__Impl_in_rule__PortRule__Group__32219 = new BitSet(new long[]{0x0000000212800000L});
    public static final BitSet FOLLOW_rule__PortRule__Group__4_in_rule__PortRule__Group__32222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group_3__0_in_rule__PortRule__Group__3__Impl2249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group__4__Impl_in_rule__PortRule__Group__42280 = new BitSet(new long[]{0x0000000212800000L});
    public static final BitSet FOLLOW_rule__PortRule__Group__5_in_rule__PortRule__Group__42283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__MultiplicityAssignment_4_in_rule__PortRule__Group__4__Impl2310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group__5__Impl_in_rule__PortRule__Group__52341 = new BitSet(new long[]{0x0000000212800000L});
    public static final BitSet FOLLOW_rule__PortRule__Group__6_in_rule__PortRule__Group__52344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__ModifiersAssignment_5_in_rule__PortRule__Group__5__Impl2371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group__6__Impl_in_rule__PortRule__Group__62402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__DefaultAssignment_6_in_rule__PortRule__Group__6__Impl2429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group_3__0__Impl_in_rule__PortRule__Group_3__02474 = new BitSet(new long[]{0x0000004000010040L});
    public static final BitSet FOLLOW_rule__PortRule__Group_3__1_in_rule__PortRule__Group_3__02477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__PortRule__Group_3__0__Impl2505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group_3__1__Impl_in_rule__PortRule__Group_3__12536 = new BitSet(new long[]{0x0000004000010040L});
    public static final BitSet FOLLOW_rule__PortRule__Group_3__2_in_rule__PortRule__Group_3__12539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__ConjugatedAssignment_3_1_in_rule__PortRule__Group_3__1__Impl2566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Group_3__2__Impl_in_rule__PortRule__Group_3__22597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PortRule__Alternatives_3_2_in_rule__PortRule__Group_3__2__Impl2624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__0__Impl_in_rule__TypeRule__Group__02660 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__1_in_rule__TypeRule__Group__02663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__PathAssignment_0_in_rule__TypeRule__Group__0__Impl2690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__1__Impl_in_rule__TypeRule__Group__12721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__TypeAssignment_1_in_rule__TypeRule__Group__1__Impl2748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02782 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl2812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12842 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__12845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__QualifiedName__Group__1__Impl2873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__22904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl2931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__0__Impl_in_rule__MultiplicityRule__Group__02968 = new BitSet(new long[]{0x0000000000001030L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__1_in_rule__MultiplicityRule__Group__02971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__MultiplicityRule__Group__0__Impl2999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__1__Impl_in_rule__MultiplicityRule__Group__13030 = new BitSet(new long[]{0x0000000000001030L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__2_in_rule__MultiplicityRule__Group__13033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_1__0_in_rule__MultiplicityRule__Group__1__Impl3060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__2__Impl_in_rule__MultiplicityRule__Group__23091 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__3_in_rule__MultiplicityRule__Group__23094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__BoundsAssignment_2_in_rule__MultiplicityRule__Group__2__Impl3121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__3__Impl_in_rule__MultiplicityRule__Group__33151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__MultiplicityRule__Group__3__Impl3179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_1__0__Impl_in_rule__MultiplicityRule__Group_1__03218 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_1__1_in_rule__MultiplicityRule__Group_1__03221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__BoundsAssignment_1_0_in_rule__MultiplicityRule__Group_1__0__Impl3248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_1__1__Impl_in_rule__MultiplicityRule__Group_1__13278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__MultiplicityRule__Group_1__1__Impl3306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__0__Impl_in_rule__ModifiersRule__Group__03341 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__1_in_rule__ModifiersRule__Group__03344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__1__Impl_in_rule__ModifiersRule__Group__13402 = new BitSet(new long[]{0x00000001A01E0000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__2_in_rule__ModifiersRule__Group__13405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ModifiersRule__Group__1__Impl3433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__2__Impl_in_rule__ModifiersRule__Group__23464 = new BitSet(new long[]{0x00000001A01E0000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__3_in_rule__ModifiersRule__Group__23467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__0_in_rule__ModifiersRule__Group__2__Impl3494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__3__Impl_in_rule__ModifiersRule__Group__33525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ModifiersRule__Group__3__Impl3553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__0__Impl_in_rule__ModifiersRule__Group_2__03592 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__1_in_rule__ModifiersRule__Group_2__03595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__ValuesAssignment_2_0_in_rule__ModifiersRule__Group_2__0__Impl3622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__1__Impl_in_rule__ModifiersRule__Group_2__13652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2_1__0_in_rule__ModifiersRule__Group_2__1__Impl3679 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2_1__0__Impl_in_rule__ModifiersRule__Group_2_1__03714 = new BitSet(new long[]{0x00000001801E0000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2_1__1_in_rule__ModifiersRule__Group_2_1__03717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ModifiersRule__Group_2_1__0__Impl3745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2_1__1__Impl_in_rule__ModifiersRule__Group_2_1__13776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__ValuesAssignment_2_1_1_in_rule__ModifiersRule__Group_2_1__1__Impl3803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RedefinesRule__Group__0__Impl_in_rule__RedefinesRule__Group__03837 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__RedefinesRule__Group__1_in_rule__RedefinesRule__Group__03840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__RedefinesRule__Group__0__Impl3868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RedefinesRule__Group__1__Impl_in_rule__RedefinesRule__Group__13899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RedefinesRule__PortAssignment_1_in_rule__RedefinesRule__Group__1__Impl3926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubsetsRule__Group__0__Impl_in_rule__SubsetsRule__Group__03960 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__SubsetsRule__Group__1_in_rule__SubsetsRule__Group__03963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__SubsetsRule__Group__0__Impl3991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubsetsRule__Group__1__Impl_in_rule__SubsetsRule__Group__14022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubsetsRule__PortAssignment_1_in_rule__SubsetsRule__Group__1__Impl4049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__Group__0__Impl_in_rule__DefaultValueRule__Group__04083 = new BitSet(new long[]{0x0000001C00600030L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__Group__1_in_rule__DefaultValueRule__Group__04086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__DefaultValueRule__Group__0__Impl4114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__Group__1__Impl_in_rule__DefaultValueRule__Group__14145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultValueRule__DefaultAssignment_1_in_rule__DefaultValueRule__Group__1__Impl4172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealValue__Group_0__0__Impl_in_rule__RealValue__Group_0__04206 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__RealValue__Group_0__1_in_rule__RealValue__Group_0__04209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealValue__IntegerAssignment_0_0_in_rule__RealValue__Group_0__0__Impl4236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealValue__Group_0__1__Impl_in_rule__RealValue__Group_0__14266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__RealValue__Group_0__1__Impl4294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealValue__Group_1__0__Impl_in_rule__RealValue__Group_1__04329 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__RealValue__Group_1__1_in_rule__RealValue__Group_1__04332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__RealValue__Group_1__0__Impl4360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealValue__Group_1__1__Impl_in_rule__RealValue__Group_1__14391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealValue__FractionAssignment_1_1_in_rule__RealValue__Group_1__1__Impl4418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealValue__Group_2__0__Impl_in_rule__RealValue__Group_2__04452 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__RealValue__Group_2__1_in_rule__RealValue__Group_2__04455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealValue__IntegerAssignment_2_0_in_rule__RealValue__Group_2__0__Impl4482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealValue__Group_2__1__Impl_in_rule__RealValue__Group_2__14512 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__RealValue__Group_2__2_in_rule__RealValue__Group_2__14515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__RealValue__Group_2__1__Impl4543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealValue__Group_2__2__Impl_in_rule__RealValue__Group_2__24574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealValue__FractionAssignment_2_2_in_rule__RealValue__Group_2__2__Impl4601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NullValue__Group__0__Impl_in_rule__NullValue__Group__04637 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__NullValue__Group__1_in_rule__NullValue__Group__04640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NullValue__Group__1__Impl_in_rule__NullValue__Group__14698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__NullValue__Group__1__Impl4726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NoValue__Group__0__Impl_in_rule__NoValue__Group__04761 = new BitSet(new long[]{0x0000001C00600030L});
    public static final BitSet FOLLOW_rule__NoValue__Group__1_in_rule__NoValue__Group__04764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NoValue__Group__1__Impl_in_rule__NoValue__Group__14822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__NoValue__Group__1__Impl4850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityRule_in_rule__PortRule__VisibilityAssignment_04890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__PortRule__DerivedAssignment_14926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PortRule__NameAssignment_24965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__PortRule__ConjugatedAssignment_3_15001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRule_in_rule__PortRule__TypeAssignment_3_2_05040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__PortRule__TypeUndefinedAssignment_3_2_15076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_rule__PortRule__MultiplicityAssignment_45115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_rule__PortRule__ModifiersAssignment_55146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultValueRule_in_rule__PortRule__DefaultAssignment_65177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_rule__VisibilityRule__VisibilityAssignment5208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TypeRule__PathAssignment_05239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRule__TypeAssignment_15274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_05313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_25348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_1_05379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_25410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BoundSpecification__ValueAlternatives_0_in_rule__BoundSpecification__ValueAssignment5441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_05474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_1_15505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierKind_in_rule__ModifierSpecification__ValueAssignment_05536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRedefinesRule_in_rule__ModifierSpecification__RedefinesAssignment_15567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubsetsRule_in_rule__ModifierSpecification__SubsetsAssignment_25598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RedefinesRule__PortAssignment_15633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubsetsRule__PortAssignment_15672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__DefaultValueRule__DefaultAssignment_15707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__IntValue__LiteralIntegerAssignment5738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringValue__LiteralStringAssignment5769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiterals_in_rule__BooleanValue__LiteralBooleanAssignment5800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__RealValue__IntegerAssignment_0_05831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__RealValue__FractionAssignment_1_15862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__RealValue__IntegerAssignment_2_05893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__RealValue__FractionAssignment_2_25924 = new BitSet(new long[]{0x0000000000000002L});

}