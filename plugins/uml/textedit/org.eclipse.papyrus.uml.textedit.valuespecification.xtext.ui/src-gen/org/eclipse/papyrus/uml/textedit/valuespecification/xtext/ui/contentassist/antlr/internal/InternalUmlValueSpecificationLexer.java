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
    public static final int RULE_ID=5;
    public static final int RULE_VALUE_SPECIFICATION_DOUBLE=7;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=14;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_VALUE_SPECIFICATION_INT=6;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=12;
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

    public InternalUmlValueSpecificationLexer() {;} 
    public InternalUmlValueSpecificationLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalUmlValueSpecificationLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
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
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
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
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
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
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
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
    // $ANTLR end "T__23"

    // $ANTLR start "RULE_VALUE_SPECIFICATION_ID"
    public final void mRULE_VALUE_SPECIFICATION_ID() throws RecognitionException {
        try {
            int _type = RULE_VALUE_SPECIFICATION_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:866:29: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:866:31: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:866:31: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:866:31: '^'
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

            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:866:60: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
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
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_VALUE_SPECIFICATION_ID"

    // $ANTLR start "RULE_VALUE_SPECIFICATION_INT"
    public final void mRULE_VALUE_SPECIFICATION_INT() throws RecognitionException {
        try {
            int _type = RULE_VALUE_SPECIFICATION_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:868:30: ( ( ( '-' )? ( '0' .. '9' )+ | '*' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:868:32: ( ( '-' )? ( '0' .. '9' )+ | '*' )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:868:32: ( ( '-' )? ( '0' .. '9' )+ | '*' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-'||(LA5_0>='0' && LA5_0<='9')) ) {
                alt5=1;
            }
            else if ( (LA5_0=='*') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:868:33: ( '-' )? ( '0' .. '9' )+
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:868:33: ( '-' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='-') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:868:33: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }

                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:868:38: ( '0' .. '9' )+
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
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:868:39: '0' .. '9'
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
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:868:50: '*'
                    {
                    match('*'); 

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
    // $ANTLR end "RULE_VALUE_SPECIFICATION_INT"

    // $ANTLR start "RULE_VALUE_SPECIFICATION_DOUBLE"
    public final void mRULE_VALUE_SPECIFICATION_DOUBLE() throws RecognitionException {
        try {
            int _type = RULE_VALUE_SPECIFICATION_DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:870:33: ( ( '-' )? ( ( '0' .. '9' )+ ( '.' | ',' ) ( '0' .. '9' )* | ( '0' .. '9' )* ( '.' | ',' ) ( '0' .. '9' )+ ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:870:35: ( '-' )? ( ( '0' .. '9' )+ ( '.' | ',' ) ( '0' .. '9' )* | ( '0' .. '9' )* ( '.' | ',' ) ( '0' .. '9' )+ )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:870:35: ( '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:870:35: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:870:40: ( ( '0' .. '9' )+ ( '.' | ',' ) ( '0' .. '9' )* | ( '0' .. '9' )* ( '.' | ',' ) ( '0' .. '9' )+ )
            int alt11=2;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:870:41: ( '0' .. '9' )+ ( '.' | ',' ) ( '0' .. '9' )*
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:870:41: ( '0' .. '9' )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:870:42: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    if ( input.LA(1)==','||input.LA(1)=='.' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:870:63: ( '0' .. '9' )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:870:64: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:870:75: ( '0' .. '9' )* ( '.' | ',' ) ( '0' .. '9' )+
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:870:75: ( '0' .. '9' )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:870:76: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    if ( input.LA(1)==','||input.LA(1)=='.' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:870:97: ( '0' .. '9' )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:870:98: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
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
    // $ANTLR end "RULE_VALUE_SPECIFICATION_DOUBLE"

    // $ANTLR start "RULE_VALUE_SPECIFICATION_STRING"
    public final void mRULE_VALUE_SPECIFICATION_STRING() throws RecognitionException {
        try {
            int _type = RULE_VALUE_SPECIFICATION_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:33: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:35: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:35: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\"') ) {
                alt14=1;
            }
            else if ( (LA14_0=='\'') ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:36: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:40: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop12:
                    do {
                        int alt12=3;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0=='\\') ) {
                            alt12=1;
                        }
                        else if ( ((LA12_0>='\u0000' && LA12_0<='!')||(LA12_0>='#' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFF')) ) {
                            alt12=2;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:41: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:48: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop12;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:68: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:73: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop13:
                    do {
                        int alt13=3;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='\\') ) {
                            alt13=1;
                        }
                        else if ( ((LA13_0>='\u0000' && LA13_0<='&')||(LA13_0>='(' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\uFFFF')) ) {
                            alt13=2;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:74: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:872:81: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop13;
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
    // $ANTLR end "RULE_VALUE_SPECIFICATION_STRING"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:874:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:874:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:874:11: ( '^' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='^') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:874:11: '^'
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

            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:874:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='0' && LA16_0<='9')||(LA16_0>='A' && LA16_0<='Z')||LA16_0=='_'||(LA16_0>='a' && LA16_0<='z')) ) {
                    alt16=1;
                }


                switch (alt16) {
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
            	    break loop16;
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:876:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:876:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:876:12: ( '0' .. '9' )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='0' && LA17_0<='9')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:876:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:878:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:878:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:878:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='\"') ) {
                alt20=1;
            }
            else if ( (LA20_0=='\'') ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:878:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:878:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop18:
                    do {
                        int alt18=3;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0=='\\') ) {
                            alt18=1;
                        }
                        else if ( ((LA18_0>='\u0000' && LA18_0<='!')||(LA18_0>='#' && LA18_0<='[')||(LA18_0>=']' && LA18_0<='\uFFFF')) ) {
                            alt18=2;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:878:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:878:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop18;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:878:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:878:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop19:
                    do {
                        int alt19=3;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0=='\\') ) {
                            alt19=1;
                        }
                        else if ( ((LA19_0>='\u0000' && LA19_0<='&')||(LA19_0>='(' && LA19_0<='[')||(LA19_0>=']' && LA19_0<='\uFFFF')) ) {
                            alt19=2;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:878:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:878:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop19;
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:880:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:880:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:880:24: ( options {greedy=false; } : . )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='*') ) {
                    int LA21_1 = input.LA(2);

                    if ( (LA21_1=='/') ) {
                        alt21=2;
                    }
                    else if ( ((LA21_1>='\u0000' && LA21_1<='.')||(LA21_1>='0' && LA21_1<='\uFFFF')) ) {
                        alt21=1;
                    }


                }
                else if ( ((LA21_0>='\u0000' && LA21_0<=')')||(LA21_0>='+' && LA21_0<='\uFFFF')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:880:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop21;
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:882:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:882:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:882:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>='\u0000' && LA22_0<='\t')||(LA22_0>='\u000B' && LA22_0<='\f')||(LA22_0>='\u000E' && LA22_0<='\uFFFF')) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:882:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop22;
                }
            } while (true);

            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:882:40: ( ( '\\r' )? '\\n' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='\n'||LA24_0=='\r') ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:882:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:882:41: ( '\\r' )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0=='\r') ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:882:41: '\\r'
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:884:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:884:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:884:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>='\t' && LA25_0<='\n')||LA25_0=='\r'||LA25_0==' ') ) {
                    alt25=1;
                }


                switch (alt25) {
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
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:886:16: ( . )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:886:18: .
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
        // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | RULE_VALUE_SPECIFICATION_ID | RULE_VALUE_SPECIFICATION_INT | RULE_VALUE_SPECIFICATION_DOUBLE | RULE_VALUE_SPECIFICATION_STRING | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt26=20;
        alt26 = dfa26.predict(input);
        switch (alt26) {
            case 1 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:10: T__15
                {
                mT__15(); 

                }
                break;
            case 2 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:16: T__16
                {
                mT__16(); 

                }
                break;
            case 3 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:22: T__17
                {
                mT__17(); 

                }
                break;
            case 4 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:28: T__18
                {
                mT__18(); 

                }
                break;
            case 5 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:34: T__19
                {
                mT__19(); 

                }
                break;
            case 6 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:40: T__20
                {
                mT__20(); 

                }
                break;
            case 7 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:46: T__21
                {
                mT__21(); 

                }
                break;
            case 8 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:52: T__22
                {
                mT__22(); 

                }
                break;
            case 9 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:58: T__23
                {
                mT__23(); 

                }
                break;
            case 10 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:64: RULE_VALUE_SPECIFICATION_ID
                {
                mRULE_VALUE_SPECIFICATION_ID(); 

                }
                break;
            case 11 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:92: RULE_VALUE_SPECIFICATION_INT
                {
                mRULE_VALUE_SPECIFICATION_INT(); 

                }
                break;
            case 12 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:121: RULE_VALUE_SPECIFICATION_DOUBLE
                {
                mRULE_VALUE_SPECIFICATION_DOUBLE(); 

                }
                break;
            case 13 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:153: RULE_VALUE_SPECIFICATION_STRING
                {
                mRULE_VALUE_SPECIFICATION_STRING(); 

                }
                break;
            case 14 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:185: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 15 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:193: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 16 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:202: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 17 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:214: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 18 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:230: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 19 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:246: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 20 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/ui/contentassist/antlr/internal/InternalUmlValueSpecification.g:1:254: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    protected DFA26 dfa26 = new DFA26(this);
    static final String DFA11_eotS =
        "\3\uffff\1\4\1\uffff";
    static final String DFA11_eofS =
        "\5\uffff";
    static final String DFA11_minS =
        "\2\54\1\uffff\1\0\1\uffff";
    static final String DFA11_maxS =
        "\2\71\1\uffff\1\0\1\uffff";
    static final String DFA11_acceptS =
        "\2\uffff\1\2\1\uffff\1\1";
    static final String DFA11_specialS =
        "\5\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\2\1\uffff\1\2\1\uffff\12\1",
            "\1\3\1\uffff\1\3\1\uffff\12\1",
            "",
            "\1\uffff",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "870:40: ( ( '0' .. '9' )+ ( '.' | ',' ) ( '0' .. '9' )* | ( '0' .. '9' )* ( '.' | ',' ) ( '0' .. '9' )+ )";
        }
    }
    static final String DFA26_eotS =
        "\1\uffff\2\26\1\uffff\1\26\1\23\1\uffff\1\36\2\uffff\1\23\1\26"+
        "\1\42\1\uffff\4\23\2\uffff\2\26\1\uffff\1\26\1\uffff\1\26\2\uffff"+
        "\1\42\4\uffff\1\26\1\uffff\1\42\11\uffff\3\26\3\uffff\1\66\1\26"+
        "\1\70\1\uffff\1\71\2\uffff";
    static final String DFA26_eofS =
        "\72\uffff";
    static final String DFA26_minS =
        "\1\0\2\60\1\uffff\1\60\1\125\1\uffff\1\54\2\uffff\1\101\1\60\1"+
        "\54\1\uffff\1\60\2\0\1\52\2\uffff\2\60\1\uffff\1\60\1\uffff\1\60"+
        "\2\uffff\1\54\4\uffff\1\60\1\uffff\1\54\2\0\1\uffff\2\0\4\uffff"+
        "\3\60\1\0\1\uffff\1\0\3\60\1\uffff\1\60\2\uffff";
    static final String DFA26_maxS =
        "\1\uffff\2\172\1\uffff\1\172\1\125\1\uffff\1\71\2\uffff\2\172\1"+
        "\71\1\uffff\1\71\2\uffff\1\57\2\uffff\2\172\1\uffff\1\172\1\uffff"+
        "\1\172\2\uffff\1\71\4\uffff\1\172\1\uffff\1\71\2\uffff\1\uffff\2"+
        "\uffff\4\uffff\3\172\1\uffff\1\uffff\1\uffff\3\172\1\uffff\1\172"+
        "\2\uffff";
    static final String DFA26_acceptS =
        "\3\uffff\1\3\2\uffff\1\6\1\uffff\1\10\1\11\3\uffff\1\13\4\uffff"+
        "\1\23\1\24\2\uffff\1\12\1\uffff\1\3\1\uffff\1\5\1\6\1\uffff\1\14"+
        "\1\7\1\10\1\11\1\uffff\1\13\3\uffff\1\15\2\uffff\1\15\1\21\1\22"+
        "\1\23\4\uffff\1\15\4\uffff\1\1\1\uffff\1\4\1\2";
    static final String DFA26_specialS =
        "\1\6\16\uffff\1\5\1\0\23\uffff\1\1\1\4\1\uffff\1\3\1\10\7\uffff"+
        "\1\2\1\uffff\1\7\7\uffff}>";
    static final String[] DFA26_transitionS = {
            "\11\23\2\22\2\23\1\22\22\23\1\22\1\23\1\17\1\10\3\23\1\20\2"+
            "\23\1\15\1\6\1\16\1\7\1\16\1\21\12\14\2\23\1\5\1\3\3\23\32\13"+
            "\3\23\1\12\1\13\1\23\5\13\1\2\7\13\1\4\5\13\1\1\6\13\3\23\1"+
            "\11\uff81\23",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\21\25\1\24\10\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\1\27\31\25",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\24\25\1\31\5\25",
            "\1\32",
            "",
            "\1\35\1\uffff\1\35\1\uffff\12\34",
            "",
            "",
            "\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\35\1\uffff\1\35\1\uffff\12\43",
            "",
            "\12\35",
            "\42\45\1\46\71\45\1\44\uffa3\45",
            "\47\50\1\51\64\50\1\47\uffa3\50",
            "\1\52\4\uffff\1\53",
            "",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\24\25\1\55\5\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\13\25\1\56\16\25",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\13\25\1\57\16\25",
            "",
            "",
            "\1\35\1\uffff\1\35\1\uffff\12\34",
            "",
            "",
            "",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\1\35\1\uffff\1\35\1\uffff\12\43",
            "\0\60",
            "\42\45\1\46\71\45\1\44\uffa3\45",
            "",
            "\0\62",
            "\47\50\1\51\64\50\1\47\uffa3\50",
            "",
            "",
            "",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\4\25\1\63\25\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\22\25\1\64\7\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\13\25\1\65\16\25",
            "\42\45\1\46\71\45\1\44\uffa3\45",
            "",
            "\47\50\1\51\64\50\1\47\uffa3\50",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\4\25\1\67\25\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            ""
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | RULE_VALUE_SPECIFICATION_ID | RULE_VALUE_SPECIFICATION_INT | RULE_VALUE_SPECIFICATION_DOUBLE | RULE_VALUE_SPECIFICATION_STRING | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_16 = input.LA(1);

                        s = -1;
                        if ( (LA26_16=='\\') ) {s = 39;}

                        else if ( ((LA26_16>='\u0000' && LA26_16<='&')||(LA26_16>='(' && LA26_16<='[')||(LA26_16>=']' && LA26_16<='\uFFFF')) ) {s = 40;}

                        else if ( (LA26_16=='\'') ) {s = 41;}

                        else s = 19;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA26_36 = input.LA(1);

                        s = -1;
                        if ( ((LA26_36>='\u0000' && LA26_36<='\uFFFF')) ) {s = 48;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA26_48 = input.LA(1);

                        s = -1;
                        if ( (LA26_48=='\"') ) {s = 38;}

                        else if ( (LA26_48=='\\') ) {s = 36;}

                        else if ( ((LA26_48>='\u0000' && LA26_48<='!')||(LA26_48>='#' && LA26_48<='[')||(LA26_48>=']' && LA26_48<='\uFFFF')) ) {s = 37;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA26_39 = input.LA(1);

                        s = -1;
                        if ( ((LA26_39>='\u0000' && LA26_39<='\uFFFF')) ) {s = 50;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA26_37 = input.LA(1);

                        s = -1;
                        if ( (LA26_37=='\"') ) {s = 38;}

                        else if ( (LA26_37=='\\') ) {s = 36;}

                        else if ( ((LA26_37>='\u0000' && LA26_37<='!')||(LA26_37>='#' && LA26_37<='[')||(LA26_37>=']' && LA26_37<='\uFFFF')) ) {s = 37;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA26_15 = input.LA(1);

                        s = -1;
                        if ( (LA26_15=='\\') ) {s = 36;}

                        else if ( ((LA26_15>='\u0000' && LA26_15<='!')||(LA26_15>='#' && LA26_15<='[')||(LA26_15>=']' && LA26_15<='\uFFFF')) ) {s = 37;}

                        else if ( (LA26_15=='\"') ) {s = 38;}

                        else s = 19;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA26_0 = input.LA(1);

                        s = -1;
                        if ( (LA26_0=='t') ) {s = 1;}

                        else if ( (LA26_0=='f') ) {s = 2;}

                        else if ( (LA26_0=='=') ) {s = 3;}

                        else if ( (LA26_0=='n') ) {s = 4;}

                        else if ( (LA26_0=='<') ) {s = 5;}

                        else if ( (LA26_0=='+') ) {s = 6;}

                        else if ( (LA26_0=='-') ) {s = 7;}

                        else if ( (LA26_0=='#') ) {s = 8;}

                        else if ( (LA26_0=='~') ) {s = 9;}

                        else if ( (LA26_0=='^') ) {s = 10;}

                        else if ( ((LA26_0>='A' && LA26_0<='Z')||LA26_0=='_'||(LA26_0>='a' && LA26_0<='e')||(LA26_0>='g' && LA26_0<='m')||(LA26_0>='o' && LA26_0<='s')||(LA26_0>='u' && LA26_0<='z')) ) {s = 11;}

                        else if ( ((LA26_0>='0' && LA26_0<='9')) ) {s = 12;}

                        else if ( (LA26_0=='*') ) {s = 13;}

                        else if ( (LA26_0==','||LA26_0=='.') ) {s = 14;}

                        else if ( (LA26_0=='\"') ) {s = 15;}

                        else if ( (LA26_0=='\'') ) {s = 16;}

                        else if ( (LA26_0=='/') ) {s = 17;}

                        else if ( ((LA26_0>='\t' && LA26_0<='\n')||LA26_0=='\r'||LA26_0==' ') ) {s = 18;}

                        else if ( ((LA26_0>='\u0000' && LA26_0<='\b')||(LA26_0>='\u000B' && LA26_0<='\f')||(LA26_0>='\u000E' && LA26_0<='\u001F')||LA26_0=='!'||(LA26_0>='$' && LA26_0<='&')||(LA26_0>='(' && LA26_0<=')')||(LA26_0>=':' && LA26_0<=';')||(LA26_0>='>' && LA26_0<='@')||(LA26_0>='[' && LA26_0<=']')||LA26_0=='`'||(LA26_0>='{' && LA26_0<='}')||(LA26_0>='\u007F' && LA26_0<='\uFFFF')) ) {s = 19;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA26_50 = input.LA(1);

                        s = -1;
                        if ( (LA26_50=='\'') ) {s = 41;}

                        else if ( (LA26_50=='\\') ) {s = 39;}

                        else if ( ((LA26_50>='\u0000' && LA26_50<='&')||(LA26_50>='(' && LA26_50<='[')||(LA26_50>=']' && LA26_50<='\uFFFF')) ) {s = 40;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA26_40 = input.LA(1);

                        s = -1;
                        if ( (LA26_40=='\'') ) {s = 41;}

                        else if ( (LA26_40=='\\') ) {s = 39;}

                        else if ( ((LA26_40>='\u0000' && LA26_40<='&')||(LA26_40>='(' && LA26_40<='[')||(LA26_40>=']' && LA26_40<='\uFFFF')) ) {s = 40;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 26, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}