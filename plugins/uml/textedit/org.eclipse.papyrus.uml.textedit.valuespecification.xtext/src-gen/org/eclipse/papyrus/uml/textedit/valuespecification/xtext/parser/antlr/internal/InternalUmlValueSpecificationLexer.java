package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


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
    public String getGrammarFileName() { return "../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:11:7: ( '=' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:11:9: '='
            {
            match('='); 

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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:12:7: ( 'true' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:12:9: 'true'
            {
            match("true"); 


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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:13:7: ( 'false' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:13:9: 'false'
            {
            match("false"); 


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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:14:7: ( 'null' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:14:9: 'null'
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:15:7: ( '<Undefined>' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:15:9: '<Undefined>'
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:16:7: ( '+' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:16:9: '+'
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:17:7: ( '-' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:17:9: '-'
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:18:7: ( '#' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:18:9: '#'
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:19:7: ( '~' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:19:9: '~'
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:565:29: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:565:31: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:565:31: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:565:31: '^'
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

            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:565:60: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:567:30: ( ( '0' .. '9' )+ )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:567:32: ( '0' .. '9' )+
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:567:32: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:567:33: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:569:33: ( ( ( '0' .. '9' )+ ( '.' | ',' ) ( '0' .. '9' )* | ( '0' .. '9' )* ( '.' | ',' ) ( '0' .. '9' )+ ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:569:35: ( ( '0' .. '9' )+ ( '.' | ',' ) ( '0' .. '9' )* | ( '0' .. '9' )* ( '.' | ',' ) ( '0' .. '9' )+ )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:569:35: ( ( '0' .. '9' )+ ( '.' | ',' ) ( '0' .. '9' )* | ( '0' .. '9' )* ( '.' | ',' ) ( '0' .. '9' )+ )
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:569:36: ( '0' .. '9' )+ ( '.' | ',' ) ( '0' .. '9' )*
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:569:36: ( '0' .. '9' )+
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
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:569:37: '0' .. '9'
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

                    if ( input.LA(1)==','||input.LA(1)=='.' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:569:58: ( '0' .. '9' )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:569:59: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:569:70: ( '0' .. '9' )* ( '.' | ',' ) ( '0' .. '9' )+
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:569:70: ( '0' .. '9' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:569:71: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    if ( input.LA(1)==','||input.LA(1)=='.' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:569:92: ( '0' .. '9' )+
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
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:569:93: '0' .. '9'
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:571:33: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:571:35: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:571:35: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:571:36: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:571:40: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:571:41: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:571:48: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:571:68: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:571:73: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:571:74: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:571:81: ~ ( ( '\\\\' | '\\'' ) )
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
    // $ANTLR end "RULE_VALUE_SPECIFICATION_STRING"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:573:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:573:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:573:11: ( '^' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='^') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:573:11: '^'
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

            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:573:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='0' && LA13_0<='9')||(LA13_0>='A' && LA13_0<='Z')||LA13_0=='_'||(LA13_0>='a' && LA13_0<='z')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:
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
            	    break loop13;
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:575:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:575:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:575:12: ( '0' .. '9' )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:575:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:577:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:577:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:577:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='\"') ) {
                alt17=1;
            }
            else if ( (LA17_0=='\'') ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:577:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:577:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop15:
                    do {
                        int alt15=3;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0=='\\') ) {
                            alt15=1;
                        }
                        else if ( ((LA15_0>='\u0000' && LA15_0<='!')||(LA15_0>='#' && LA15_0<='[')||(LA15_0>=']' && LA15_0<='\uFFFF')) ) {
                            alt15=2;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:577:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:577:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop15;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:577:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:577:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop16:
                    do {
                        int alt16=3;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0=='\\') ) {
                            alt16=1;
                        }
                        else if ( ((LA16_0>='\u0000' && LA16_0<='&')||(LA16_0>='(' && LA16_0<='[')||(LA16_0>=']' && LA16_0<='\uFFFF')) ) {
                            alt16=2;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:577:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:577:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop16;
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:579:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:579:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:579:24: ( options {greedy=false; } : . )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='*') ) {
                    int LA18_1 = input.LA(2);

                    if ( (LA18_1=='/') ) {
                        alt18=2;
                    }
                    else if ( ((LA18_1>='\u0000' && LA18_1<='.')||(LA18_1>='0' && LA18_1<='\uFFFF')) ) {
                        alt18=1;
                    }


                }
                else if ( ((LA18_0>='\u0000' && LA18_0<=')')||(LA18_0>='+' && LA18_0<='\uFFFF')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:579:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop18;
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:581:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:581:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:581:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='\u0000' && LA19_0<='\t')||(LA19_0>='\u000B' && LA19_0<='\f')||(LA19_0>='\u000E' && LA19_0<='\uFFFF')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:581:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop19;
                }
            } while (true);

            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:581:40: ( ( '\\r' )? '\\n' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='\n'||LA21_0=='\r') ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:581:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:581:41: ( '\\r' )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0=='\r') ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:581:41: '\\r'
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:583:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:583:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:583:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>='\t' && LA22_0<='\n')||LA22_0=='\r'||LA22_0==' ') ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:
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
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
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
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:585:16: ( . )
            // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:585:18: .
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
        // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | RULE_VALUE_SPECIFICATION_ID | RULE_VALUE_SPECIFICATION_INT | RULE_VALUE_SPECIFICATION_DOUBLE | RULE_VALUE_SPECIFICATION_STRING | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt23=20;
        alt23 = dfa23.predict(input);
        switch (alt23) {
            case 1 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:10: T__15
                {
                mT__15(); 

                }
                break;
            case 2 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:16: T__16
                {
                mT__16(); 

                }
                break;
            case 3 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:22: T__17
                {
                mT__17(); 

                }
                break;
            case 4 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:28: T__18
                {
                mT__18(); 

                }
                break;
            case 5 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:34: T__19
                {
                mT__19(); 

                }
                break;
            case 6 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:40: T__20
                {
                mT__20(); 

                }
                break;
            case 7 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:46: T__21
                {
                mT__21(); 

                }
                break;
            case 8 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:52: T__22
                {
                mT__22(); 

                }
                break;
            case 9 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:58: T__23
                {
                mT__23(); 

                }
                break;
            case 10 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:64: RULE_VALUE_SPECIFICATION_ID
                {
                mRULE_VALUE_SPECIFICATION_ID(); 

                }
                break;
            case 11 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:92: RULE_VALUE_SPECIFICATION_INT
                {
                mRULE_VALUE_SPECIFICATION_INT(); 

                }
                break;
            case 12 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:121: RULE_VALUE_SPECIFICATION_DOUBLE
                {
                mRULE_VALUE_SPECIFICATION_DOUBLE(); 

                }
                break;
            case 13 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:153: RULE_VALUE_SPECIFICATION_STRING
                {
                mRULE_VALUE_SPECIFICATION_STRING(); 

                }
                break;
            case 14 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:185: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 15 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:193: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 16 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:202: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 17 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:214: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 18 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:230: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 19 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:246: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 20 :
                // ../org.eclipse.papyrus.uml.textedit.valuespecification.xtext/src-gen/org/eclipse/papyrus/uml/textedit/valuespecification/xtext/parser/antlr/internal/InternalUmlValueSpecification.g:1:254: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    protected DFA23 dfa23 = new DFA23(this);
    static final String DFA8_eotS =
        "\3\uffff\1\4\1\uffff";
    static final String DFA8_eofS =
        "\5\uffff";
    static final String DFA8_minS =
        "\2\54\1\uffff\1\0\1\uffff";
    static final String DFA8_maxS =
        "\2\71\1\uffff\1\0\1\uffff";
    static final String DFA8_acceptS =
        "\2\uffff\1\2\1\uffff\1\1";
    static final String DFA8_specialS =
        "\5\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\2\1\uffff\1\2\1\uffff\12\1",
            "\1\3\1\uffff\1\3\1\uffff\12\1",
            "",
            "\1\uffff",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "569:35: ( ( '0' .. '9' )+ ( '.' | ',' ) ( '0' .. '9' )* | ( '0' .. '9' )* ( '.' | ',' ) ( '0' .. '9' )+ )";
        }
    }
    static final String DFA23_eotS =
        "\2\uffff\3\26\1\22\4\uffff\1\22\1\26\1\37\4\22\3\uffff\2\26\1\uffff"+
        "\2\26\5\uffff\1\26\1\uffff\1\37\12\uffff\3\26\3\uffff\1\64\1\26"+
        "\1\66\1\uffff\1\67\2\uffff";
    static final String DFA23_eofS =
        "\70\uffff";
    static final String DFA23_minS =
        "\1\0\1\uffff\3\60\1\125\4\uffff\1\101\1\60\1\54\1\60\2\0\1\52\3"+
        "\uffff\2\60\1\uffff\2\60\5\uffff\1\60\1\uffff\1\54\1\uffff\2\0\1"+
        "\uffff\2\0\4\uffff\3\60\1\0\1\uffff\1\0\3\60\1\uffff\1\60\2\uffff";
    static final String DFA23_maxS =
        "\1\uffff\1\uffff\3\172\1\125\4\uffff\2\172\2\71\2\uffff\1\57\3"+
        "\uffff\2\172\1\uffff\2\172\5\uffff\1\172\1\uffff\1\71\1\uffff\2"+
        "\uffff\1\uffff\2\uffff\4\uffff\3\172\1\uffff\1\uffff\1\uffff\3\172"+
        "\1\uffff\1\172\2\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\4\uffff\1\6\1\7\1\10\1\11\7\uffff\1\23\1\24\1\1\2"+
        "\uffff\1\12\2\uffff\1\5\1\6\1\7\1\10\1\11\1\uffff\1\13\1\uffff\1"+
        "\14\2\uffff\1\15\2\uffff\1\15\1\21\1\22\1\23\4\uffff\1\15\4\uffff"+
        "\1\2\1\uffff\1\4\1\3";
    static final String DFA23_specialS =
        "\1\4\15\uffff\1\1\1\3\22\uffff\1\6\1\10\1\uffff\1\2\1\7\7\uffff"+
        "\1\0\1\uffff\1\5\7\uffff}>";
    static final String[] DFA23_transitionS = {
            "\11\22\2\21\2\22\1\21\22\22\1\21\1\22\1\16\1\10\3\22\1\17\3"+
            "\22\1\6\1\15\1\7\1\15\1\20\12\14\2\22\1\5\1\1\3\22\32\13\3\22"+
            "\1\12\1\13\1\22\5\13\1\3\7\13\1\4\5\13\1\2\6\13\3\22\1\11\uff81"+
            "\22",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\21\25\1\24\10\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\1\27\31\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\24\25\1\30\5\25",
            "\1\31",
            "",
            "",
            "",
            "",
            "\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\41\1\uffff\1\41\1\uffff\12\40",
            "\12\41",
            "\42\43\1\44\71\43\1\42\uffa3\43",
            "\47\46\1\47\64\46\1\45\uffa3\46",
            "\1\50\4\uffff\1\51",
            "",
            "",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\24\25\1\53\5\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\13\25\1\54\16\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\13\25\1\55\16\25",
            "",
            "",
            "",
            "",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\1\41\1\uffff\1\41\1\uffff\12\40",
            "",
            "\0\56",
            "\42\43\1\44\71\43\1\42\uffa3\43",
            "",
            "\0\60",
            "\47\46\1\47\64\46\1\45\uffa3\46",
            "",
            "",
            "",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\4\25\1\61\25\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\22\25\1\62\7\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\13\25\1\63\16\25",
            "\42\43\1\44\71\43\1\42\uffa3\43",
            "",
            "\47\46\1\47\64\46\1\45\uffa3\46",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\4\25\1\65\25\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | RULE_VALUE_SPECIFICATION_ID | RULE_VALUE_SPECIFICATION_INT | RULE_VALUE_SPECIFICATION_DOUBLE | RULE_VALUE_SPECIFICATION_STRING | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_46 = input.LA(1);

                        s = -1;
                        if ( (LA23_46=='\"') ) {s = 36;}

                        else if ( (LA23_46=='\\') ) {s = 34;}

                        else if ( ((LA23_46>='\u0000' && LA23_46<='!')||(LA23_46>='#' && LA23_46<='[')||(LA23_46>=']' && LA23_46<='\uFFFF')) ) {s = 35;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA23_14 = input.LA(1);

                        s = -1;
                        if ( (LA23_14=='\\') ) {s = 34;}

                        else if ( ((LA23_14>='\u0000' && LA23_14<='!')||(LA23_14>='#' && LA23_14<='[')||(LA23_14>=']' && LA23_14<='\uFFFF')) ) {s = 35;}

                        else if ( (LA23_14=='\"') ) {s = 36;}

                        else s = 18;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA23_37 = input.LA(1);

                        s = -1;
                        if ( ((LA23_37>='\u0000' && LA23_37<='\uFFFF')) ) {s = 48;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA23_15 = input.LA(1);

                        s = -1;
                        if ( (LA23_15=='\\') ) {s = 37;}

                        else if ( ((LA23_15>='\u0000' && LA23_15<='&')||(LA23_15>='(' && LA23_15<='[')||(LA23_15>=']' && LA23_15<='\uFFFF')) ) {s = 38;}

                        else if ( (LA23_15=='\'') ) {s = 39;}

                        else s = 18;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA23_0 = input.LA(1);

                        s = -1;
                        if ( (LA23_0=='=') ) {s = 1;}

                        else if ( (LA23_0=='t') ) {s = 2;}

                        else if ( (LA23_0=='f') ) {s = 3;}

                        else if ( (LA23_0=='n') ) {s = 4;}

                        else if ( (LA23_0=='<') ) {s = 5;}

                        else if ( (LA23_0=='+') ) {s = 6;}

                        else if ( (LA23_0=='-') ) {s = 7;}

                        else if ( (LA23_0=='#') ) {s = 8;}

                        else if ( (LA23_0=='~') ) {s = 9;}

                        else if ( (LA23_0=='^') ) {s = 10;}

                        else if ( ((LA23_0>='A' && LA23_0<='Z')||LA23_0=='_'||(LA23_0>='a' && LA23_0<='e')||(LA23_0>='g' && LA23_0<='m')||(LA23_0>='o' && LA23_0<='s')||(LA23_0>='u' && LA23_0<='z')) ) {s = 11;}

                        else if ( ((LA23_0>='0' && LA23_0<='9')) ) {s = 12;}

                        else if ( (LA23_0==','||LA23_0=='.') ) {s = 13;}

                        else if ( (LA23_0=='\"') ) {s = 14;}

                        else if ( (LA23_0=='\'') ) {s = 15;}

                        else if ( (LA23_0=='/') ) {s = 16;}

                        else if ( ((LA23_0>='\t' && LA23_0<='\n')||LA23_0=='\r'||LA23_0==' ') ) {s = 17;}

                        else if ( ((LA23_0>='\u0000' && LA23_0<='\b')||(LA23_0>='\u000B' && LA23_0<='\f')||(LA23_0>='\u000E' && LA23_0<='\u001F')||LA23_0=='!'||(LA23_0>='$' && LA23_0<='&')||(LA23_0>='(' && LA23_0<='*')||(LA23_0>=':' && LA23_0<=';')||(LA23_0>='>' && LA23_0<='@')||(LA23_0>='[' && LA23_0<=']')||LA23_0=='`'||(LA23_0>='{' && LA23_0<='}')||(LA23_0>='\u007F' && LA23_0<='\uFFFF')) ) {s = 18;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA23_48 = input.LA(1);

                        s = -1;
                        if ( (LA23_48=='\'') ) {s = 39;}

                        else if ( (LA23_48=='\\') ) {s = 37;}

                        else if ( ((LA23_48>='\u0000' && LA23_48<='&')||(LA23_48>='(' && LA23_48<='[')||(LA23_48>=']' && LA23_48<='\uFFFF')) ) {s = 38;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA23_34 = input.LA(1);

                        s = -1;
                        if ( ((LA23_34>='\u0000' && LA23_34<='\uFFFF')) ) {s = 46;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA23_38 = input.LA(1);

                        s = -1;
                        if ( (LA23_38=='\'') ) {s = 39;}

                        else if ( (LA23_38=='\\') ) {s = 37;}

                        else if ( ((LA23_38>='\u0000' && LA23_38<='&')||(LA23_38>='(' && LA23_38<='[')||(LA23_38>=']' && LA23_38<='\uFFFF')) ) {s = 38;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA23_35 = input.LA(1);

                        s = -1;
                        if ( (LA23_35=='\"') ) {s = 36;}

                        else if ( (LA23_35=='\\') ) {s = 34;}

                        else if ( ((LA23_35>='\u0000' && LA23_35<='!')||(LA23_35>='#' && LA23_35<='[')||(LA23_35>=']' && LA23_35<='\uFFFF')) ) {s = 35;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}