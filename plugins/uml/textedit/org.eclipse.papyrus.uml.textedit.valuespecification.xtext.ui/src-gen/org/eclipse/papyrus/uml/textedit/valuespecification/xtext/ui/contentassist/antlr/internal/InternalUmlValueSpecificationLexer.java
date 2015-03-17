package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlValueSpecificationLexer extends Lexer {
    public static final int T__19=19;
    public static final int RULE_ID=4;
    public static final int RULE_STRING=7;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__20=20;
    public static final int RULE_INT=5;
    public static final int RULE_WS=10;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_DOUBLE=6;
    public static final int RULE_ML_COMMENT=8;

    // delegates
    // delegators

    public InternalUmlValueSpecificationLexer() {;} 
    public InternalUmlValueSpecificationLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalUmlValueSpecificationLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:11:7: ( 'true' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:11:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:12:7: ( 'false' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:12:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:13:7: ( '=' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:13:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:14:7: ( 'null' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:14:9: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:15:7: ( '<Undefined>' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:15:9: '<Undefined>'
            {
            match("<Undefined>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:16:7: ( '+' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:16:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:17:7: ( '-' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:17:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:18:7: ( '#' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:18:9: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:19:7: ( '~' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:19:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "RULE_DOUBLE"
    public final void mRULE_DOUBLE() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:866:13: ( ( ( '0' .. '9' )+ ( '.' | ',' ) ( '0' .. '9' )* | ( '0' .. '9' )* ( '.' | ',' ) ( '0' .. '9' )+ ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:866:15: ( ( '0' .. '9' )+ ( '.' | ',' ) ( '0' .. '9' )* | ( '0' .. '9' )* ( '.' | ',' ) ( '0' .. '9' )+ )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:866:15: ( ( '0' .. '9' )+ ( '.' | ',' ) ( '0' .. '9' )* | ( '0' .. '9' )* ( '.' | ',' ) ( '0' .. '9' )+ )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:866:16: ( '0' .. '9' )+ ( '.' | ',' ) ( '0' .. '9' )*
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:866:16: ( '0' .. '9' )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:866:17: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);

                    if ( input.LA(1)==','||input.LA(1)=='.' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:866:38: ( '0' .. '9' )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:866:39: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:866:50: ( '0' .. '9' )* ( '.' | ',' ) ( '0' .. '9' )+
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:866:50: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:866:51: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    if ( input.LA(1)==','||input.LA(1)=='.' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:866:72: ( '0' .. '9' )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:866:73: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOUBLE"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:868:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:868:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:868:11: ( '^' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='^') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:868:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:868:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')||(LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:870:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:870:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:870:12: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:870:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\"') ) {
                alt11=1;
            }
            else if ( (LA11_0=='\'') ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop9:
                    do {
                        int alt9=3;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='\\') ) {
                            alt9=1;
                        }
                        else if ( ((LA9_0>='\u0000' && LA9_0<='!')||(LA9_0>='#' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                            alt9=2;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop10:
                    do {
                        int alt10=3;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0=='\\') ) {
                            alt10=1;
                        }
                        else if ( ((LA10_0>='\u0000' && LA10_0<='&')||(LA10_0>='(' && LA10_0<='[')||(LA10_0>=']' && LA10_0<='\uFFFF')) ) {
                            alt10=2;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:874:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:874:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:874:24: ( options {greedy=false; } : . )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='*') ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1=='/') ) {
                        alt12=2;
                    }
                    else if ( ((LA12_1>='\u0000' && LA12_1<='.')||(LA12_1>='0' && LA12_1<='\uFFFF')) ) {
                        alt12=1;
                    }


                }
                else if ( ((LA12_0>='\u0000' && LA12_0<=')')||(LA12_0>='+' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:874:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:876:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:876:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:876:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:876:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:876:40: ( ( '\\r' )? '\\n' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\n'||LA15_0=='\r') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:876:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:876:41: ( '\\r' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='\r') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:876:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:878:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:878:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:878:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\t' && LA16_0<='\n')||LA16_0=='\r'||LA16_0==' ') ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:880:16: ( . )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:880:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | RULE_DOUBLE | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt17=17;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:22: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:28: T__15
                {
                mT__15(); 

                }
                break;
            case 5 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:34: T__16
                {
                mT__16(); 

                }
                break;
            case 6 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:40: T__17
                {
                mT__17(); 

                }
                break;
            case 7 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:46: T__18
                {
                mT__18(); 

                }
                break;
            case 8 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:52: T__19
                {
                mT__19(); 

                }
                break;
            case 9 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:58: T__20
                {
                mT__20(); 

                }
                break;
            case 10 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:64: RULE_DOUBLE
                {
                mRULE_DOUBLE(); 

                }
                break;
            case 11 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:76: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 12 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:84: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 13 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:93: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 14 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:105: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 15 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:121: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 16 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:137: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 17 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:145: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA5_eotS =
        "\3\uffff\1\4\1\uffff";
    static final String DFA5_eofS =
        "\5\uffff";
    static final String DFA5_minS =
        "\2\54\1\uffff\1\0\1\uffff";
    static final String DFA5_maxS =
        "\2\71\1\uffff\1\0\1\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\2\1\uffff\1\1";
    static final String DFA5_specialS =
        "\5\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\2\1\uffff\1\2\1\uffff\12\1",
            "\1\3\1\uffff\1\3\1\uffff\12\1",
            "",
            "\1\uffff",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "866:15: ( ( '0' .. '9' )+ ( '.' | ',' ) ( '0' .. '9' )* | ( '0' .. '9' )* ( '.' | ',' ) ( '0' .. '9' )+ )";
        }
    }
    static final String DFA17_eotS =
        "\1\uffff\2\24\1\uffff\1\24\1\22\4\uffff\1\35\2\22\1\uffff\3\22"+
        "\2\uffff\1\24\1\uffff\1\24\1\uffff\1\24\7\uffff\1\35\4\uffff\3\24"+
        "\1\52\1\24\1\54\1\uffff\1\55\2\uffff";
    static final String DFA17_eofS =
        "\56\uffff";
    static final String DFA17_minS =
        "\1\0\1\162\1\141\1\uffff\1\165\1\125\4\uffff\1\54\1\60\1\101\1"+
        "\uffff\2\0\1\52\2\uffff\1\165\1\uffff\1\154\1\uffff\1\154\7\uffff"+
        "\1\54\4\uffff\1\145\1\163\1\154\1\60\1\145\1\60\1\uffff\1\60\2\uffff";
    static final String DFA17_maxS =
        "\1\uffff\1\162\1\141\1\uffff\1\165\1\125\4\uffff\2\71\1\172\1\uffff"+
        "\2\uffff\1\57\2\uffff\1\165\1\uffff\1\154\1\uffff\1\154\7\uffff"+
        "\1\71\4\uffff\1\145\1\163\1\154\1\172\1\145\1\172\1\uffff\1\172"+
        "\2\uffff";
    static final String DFA17_acceptS =
        "\3\uffff\1\3\2\uffff\1\6\1\7\1\10\1\11\3\uffff\1\13\3\uffff\1\20"+
        "\1\21\1\uffff\1\13\1\uffff\1\3\1\uffff\1\5\1\6\1\7\1\10\1\11\1\14"+
        "\1\12\1\uffff\1\15\1\16\1\17\1\20\6\uffff\1\1\1\uffff\1\4\1\2";
    static final String DFA17_specialS =
        "\1\0\15\uffff\1\1\1\2\36\uffff}>";
    static final String[] DFA17_transitionS = {
            "\11\22\2\21\2\22\1\21\22\22\1\21\1\22\1\16\1\10\3\22\1\17\3"+
            "\22\1\6\1\13\1\7\1\13\1\20\12\12\2\22\1\5\1\3\3\22\32\15\3\22"+
            "\1\14\1\15\1\22\5\15\1\2\7\15\1\4\5\15\1\1\6\15\3\22\1\11\uff81"+
            "\22",
            "\1\23",
            "\1\25",
            "",
            "\1\27",
            "\1\30",
            "",
            "",
            "",
            "",
            "\1\36\1\uffff\1\36\1\uffff\12\37",
            "\12\36",
            "\32\24\4\uffff\1\24\1\uffff\32\24",
            "",
            "\0\40",
            "\0\40",
            "\1\41\4\uffff\1\42",
            "",
            "",
            "\1\44",
            "",
            "\1\45",
            "",
            "\1\46",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\36\1\uffff\1\36\1\uffff\12\37",
            "",
            "",
            "",
            "",
            "\1\47",
            "\1\50",
            "\1\51",
            "\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
            "\1\53",
            "\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
            "",
            "\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff\32\24",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | RULE_DOUBLE | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_0 = input.LA(1);

                        s = -1;
                        if ( (LA17_0=='t') ) {s = 1;}

                        else if ( (LA17_0=='f') ) {s = 2;}

                        else if ( (LA17_0=='=') ) {s = 3;}

                        else if ( (LA17_0=='n') ) {s = 4;}

                        else if ( (LA17_0=='<') ) {s = 5;}

                        else if ( (LA17_0=='+') ) {s = 6;}

                        else if ( (LA17_0=='-') ) {s = 7;}

                        else if ( (LA17_0=='#') ) {s = 8;}

                        else if ( (LA17_0=='~') ) {s = 9;}

                        else if ( ((LA17_0>='0' && LA17_0<='9')) ) {s = 10;}

                        else if ( (LA17_0==','||LA17_0=='.') ) {s = 11;}

                        else if ( (LA17_0=='^') ) {s = 12;}

                        else if ( ((LA17_0>='A' && LA17_0<='Z')||LA17_0=='_'||(LA17_0>='a' && LA17_0<='e')||(LA17_0>='g' && LA17_0<='m')||(LA17_0>='o' && LA17_0<='s')||(LA17_0>='u' && LA17_0<='z')) ) {s = 13;}

                        else if ( (LA17_0=='\"') ) {s = 14;}

                        else if ( (LA17_0=='\'') ) {s = 15;}

                        else if ( (LA17_0=='/') ) {s = 16;}

                        else if ( ((LA17_0>='\t' && LA17_0<='\n')||LA17_0=='\r'||LA17_0==' ') ) {s = 17;}

                        else if ( ((LA17_0>='\u0000' && LA17_0<='\b')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\u001F')||LA17_0=='!'||(LA17_0>='$' && LA17_0<='&')||(LA17_0>='(' && LA17_0<='*')||(LA17_0>=':' && LA17_0<=';')||(LA17_0>='>' && LA17_0<='@')||(LA17_0>='[' && LA17_0<=']')||LA17_0=='`'||(LA17_0>='{' && LA17_0<='}')||(LA17_0>='\u007F' && LA17_0<='\uFFFF')) ) {s = 18;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_14 = input.LA(1);

                        s = -1;
                        if ( ((LA17_14>='\u0000' && LA17_14<='\uFFFF')) ) {s = 32;}

                        else s = 18;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_15 = input.LA(1);

                        s = -1;
                        if ( ((LA17_15>='\u0000' && LA17_15<='\uFFFF')) ) {s = 32;}

                        else s = 18;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 17, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}