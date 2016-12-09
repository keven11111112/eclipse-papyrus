package org.eclipse.papyrus.migration.rhapsody.parser.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRpySyntaxLexer extends Lexer {
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

    public InternalRpySyntaxLexer() {;} 
    public InternalRpySyntaxLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalRpySyntaxLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalRpySyntax.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRpySyntax.g:11:7: ( 'I-Logix-RPY-Archive' )
            // InternalRpySyntax.g:11:9: 'I-Logix-RPY-Archive'
            {
            match("I-Logix-RPY-Archive"); 


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
            // InternalRpySyntax.g:12:7: ( '{' )
            // InternalRpySyntax.g:12:9: '{'
            {
            match('{'); 

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
            // InternalRpySyntax.g:13:7: ( '}' )
            // InternalRpySyntax.g:13:9: '}'
            {
            match('}'); 

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
            // InternalRpySyntax.g:14:7: ( '-' )
            // InternalRpySyntax.g:14:9: '-'
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
            // InternalRpySyntax.g:15:7: ( '=' )
            // InternalRpySyntax.g:15:9: '='
            {
            match('='); 

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
            // InternalRpySyntax.g:16:7: ( ';' )
            // InternalRpySyntax.g:16:9: ';'
            {
            match(';'); 

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
            // InternalRpySyntax.g:17:7: ( 'OLDID' )
            // InternalRpySyntax.g:17:9: 'OLDID'
            {
            match("OLDID"); 


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
            // InternalRpySyntax.g:18:7: ( 'GUID' )
            // InternalRpySyntax.g:18:9: 'GUID'
            {
            match("GUID"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "RULE_RPY_GUID"
    public final void mRULE_RPY_GUID() throws RecognitionException {
        try {
            int _type = RULE_RPY_GUID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRpySyntax.g:1362:15: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ ( '-' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ )+ )
            // InternalRpySyntax.g:1362:17: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ ( '-' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ )+
            {
            // InternalRpySyntax.g:1362:17: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRpySyntax.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

            // InternalRpySyntax.g:1362:47: ( '-' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='-') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalRpySyntax.g:1362:48: '-' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
            	    {
            	    match('-'); 
            	    // InternalRpySyntax.g:1362:52: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
            	    int cnt2=0;
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||(LA2_0>='a' && LA2_0<='z')) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // InternalRpySyntax.g:
            	    	    {
            	    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	    	        input.consume();

            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	    	        recover(mse);
            	    	        throw mse;}


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt2 >= 1 ) break loop2;
            	                EarlyExitException eee =
            	                    new EarlyExitException(2, input);
            	                throw eee;
            	        }
            	        cnt2++;
            	    } while (true);


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
    // $ANTLR end "RULE_RPY_GUID"

    // $ANTLR start "RULE_RPY_TIME"
    public final void mRULE_RPY_TIME() throws RecognitionException {
        try {
            int _type = RULE_RPY_TIME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRpySyntax.g:1364:15: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ '.' ( '0' .. '9' )+ '::' ( '0' .. '9' )+ ':' ( '0' .. '9' )+ ':' '0' .. '9' )
            // InternalRpySyntax.g:1364:17: ( '0' .. '9' )+ '.' ( '0' .. '9' )+ '.' ( '0' .. '9' )+ '::' ( '0' .. '9' )+ ':' ( '0' .. '9' )+ ':' '0' .. '9'
            {
            // InternalRpySyntax.g:1364:17: ( '0' .. '9' )+
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
            	    // InternalRpySyntax.g:1364:18: '0' .. '9'
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

            match('.'); 
            // InternalRpySyntax.g:1364:33: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalRpySyntax.g:1364:34: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            match('.'); 
            // InternalRpySyntax.g:1364:49: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalRpySyntax.g:1364:50: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            match("::"); 

            // InternalRpySyntax.g:1364:66: ( '0' .. '9' )+
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
            	    // InternalRpySyntax.g:1364:67: '0' .. '9'
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

            match(':'); 
            // InternalRpySyntax.g:1364:82: ( '0' .. '9' )+
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
            	    // InternalRpySyntax.g:1364:83: '0' .. '9'
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

            match(':'); 
            matchRange('0','9'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RPY_TIME"

    // $ANTLR start "RULE_RPY_REAL"
    public final void mRULE_RPY_REAL() throws RecognitionException {
        try {
            int _type = RULE_RPY_REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRpySyntax.g:1366:15: ( ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            // InternalRpySyntax.g:1366:17: ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+
            {
            // InternalRpySyntax.g:1366:17: ( '-' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='-') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalRpySyntax.g:1366:17: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // InternalRpySyntax.g:1366:22: ( '0' .. '9' )+
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
            	    // InternalRpySyntax.g:1366:23: '0' .. '9'
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

            match('.'); 
            // InternalRpySyntax.g:1366:38: ( '0' .. '9' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalRpySyntax.g:1366:39: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RPY_REAL"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRpySyntax.g:1368:10: ( ( '-' )? ( '0' .. '9' )+ )
            // InternalRpySyntax.g:1368:12: ( '-' )? ( '0' .. '9' )+
            {
            // InternalRpySyntax.g:1368:12: ( '-' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='-') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalRpySyntax.g:1368:12: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // InternalRpySyntax.g:1368:17: ( '0' .. '9' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalRpySyntax.g:1368:18: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_RPY_VERSION"
    public final void mRULE_RPY_VERSION() throws RecognitionException {
        try {
            int _type = RULE_RPY_VERSION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRpySyntax.g:1370:18: ( 'version' (~ ( ( '\\n' | '\\r' ) ) )* ( '\\n' | '\\r' ) )
            // InternalRpySyntax.g:1370:20: 'version' (~ ( ( '\\n' | '\\r' ) ) )* ( '\\n' | '\\r' )
            {
            match("version"); 

            // InternalRpySyntax.g:1370:30: (~ ( ( '\\n' | '\\r' ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalRpySyntax.g:1370:30: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop14;
                }
            } while (true);

            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RPY_VERSION"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRpySyntax.g:1372:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalRpySyntax.g:1372:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalRpySyntax.g:1372:11: ( '^' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='^') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalRpySyntax.g:1372:11: '^'
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

            // InternalRpySyntax.g:1372:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='0' && LA16_0<='9')||(LA16_0>='A' && LA16_0<='Z')||LA16_0=='_'||(LA16_0>='a' && LA16_0<='z')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalRpySyntax.g:
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

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRpySyntax.g:1374:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalRpySyntax.g:1374:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalRpySyntax.g:1374:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='\"') ) {
                alt19=1;
            }
            else if ( (LA19_0=='\'') ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalRpySyntax.g:1374:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalRpySyntax.g:1374:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop17:
                    do {
                        int alt17=3;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0=='\\') ) {
                            alt17=1;
                        }
                        else if ( ((LA17_0>='\u0000' && LA17_0<='!')||(LA17_0>='#' && LA17_0<='[')||(LA17_0>=']' && LA17_0<='\uFFFF')) ) {
                            alt17=2;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalRpySyntax.g:1374:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalRpySyntax.g:1374:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop17;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalRpySyntax.g:1374:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalRpySyntax.g:1374:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop18:
                    do {
                        int alt18=3;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0=='\\') ) {
                            alt18=1;
                        }
                        else if ( ((LA18_0>='\u0000' && LA18_0<='&')||(LA18_0>='(' && LA18_0<='[')||(LA18_0>=']' && LA18_0<='\uFFFF')) ) {
                            alt18=2;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalRpySyntax.g:1374:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalRpySyntax.g:1374:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop18;
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
            // InternalRpySyntax.g:1376:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalRpySyntax.g:1376:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalRpySyntax.g:1376:24: ( options {greedy=false; } : . )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0=='*') ) {
                    int LA20_1 = input.LA(2);

                    if ( (LA20_1=='/') ) {
                        alt20=2;
                    }
                    else if ( ((LA20_1>='\u0000' && LA20_1<='.')||(LA20_1>='0' && LA20_1<='\uFFFF')) ) {
                        alt20=1;
                    }


                }
                else if ( ((LA20_0>='\u0000' && LA20_0<=')')||(LA20_0>='+' && LA20_0<='\uFFFF')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalRpySyntax.g:1376:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop20;
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
            // InternalRpySyntax.g:1378:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalRpySyntax.g:1378:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalRpySyntax.g:1378:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='\u0000' && LA21_0<='\t')||(LA21_0>='\u000B' && LA21_0<='\f')||(LA21_0>='\u000E' && LA21_0<='\uFFFF')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalRpySyntax.g:1378:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop21;
                }
            } while (true);

            // InternalRpySyntax.g:1378:40: ( ( '\\r' )? '\\n' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='\n'||LA23_0=='\r') ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalRpySyntax.g:1378:41: ( '\\r' )? '\\n'
                    {
                    // InternalRpySyntax.g:1378:41: ( '\\r' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0=='\r') ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalRpySyntax.g:1378:41: '\\r'
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
            // InternalRpySyntax.g:1380:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalRpySyntax.g:1380:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalRpySyntax.g:1380:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>='\t' && LA24_0<='\n')||LA24_0=='\r'||LA24_0==' ') ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalRpySyntax.g:
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
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
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
            // InternalRpySyntax.g:1382:16: ( . )
            // InternalRpySyntax.g:1382:18: .
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
        // InternalRpySyntax.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | RULE_RPY_GUID | RULE_RPY_TIME | RULE_RPY_REAL | RULE_INT | RULE_RPY_VERSION | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt25=19;
        alt25 = dfa25.predict(input);
        switch (alt25) {
            case 1 :
                // InternalRpySyntax.g:1:10: T__15
                {
                mT__15(); 

                }
                break;
            case 2 :
                // InternalRpySyntax.g:1:16: T__16
                {
                mT__16(); 

                }
                break;
            case 3 :
                // InternalRpySyntax.g:1:22: T__17
                {
                mT__17(); 

                }
                break;
            case 4 :
                // InternalRpySyntax.g:1:28: T__18
                {
                mT__18(); 

                }
                break;
            case 5 :
                // InternalRpySyntax.g:1:34: T__19
                {
                mT__19(); 

                }
                break;
            case 6 :
                // InternalRpySyntax.g:1:40: T__20
                {
                mT__20(); 

                }
                break;
            case 7 :
                // InternalRpySyntax.g:1:46: T__21
                {
                mT__21(); 

                }
                break;
            case 8 :
                // InternalRpySyntax.g:1:52: T__22
                {
                mT__22(); 

                }
                break;
            case 9 :
                // InternalRpySyntax.g:1:58: RULE_RPY_GUID
                {
                mRULE_RPY_GUID(); 

                }
                break;
            case 10 :
                // InternalRpySyntax.g:1:72: RULE_RPY_TIME
                {
                mRULE_RPY_TIME(); 

                }
                break;
            case 11 :
                // InternalRpySyntax.g:1:86: RULE_RPY_REAL
                {
                mRULE_RPY_REAL(); 

                }
                break;
            case 12 :
                // InternalRpySyntax.g:1:100: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 13 :
                // InternalRpySyntax.g:1:109: RULE_RPY_VERSION
                {
                mRULE_RPY_VERSION(); 

                }
                break;
            case 14 :
                // InternalRpySyntax.g:1:126: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 15 :
                // InternalRpySyntax.g:1:134: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 16 :
                // InternalRpySyntax.g:1:146: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 17 :
                // InternalRpySyntax.g:1:162: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 18 :
                // InternalRpySyntax.g:1:178: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 19 :
                // InternalRpySyntax.g:1:186: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA25 dfa25 = new DFA25(this);
    static final String DFA25_eotS =
        "\1\uffff\1\24\2\uffff\1\31\2\uffff\2\24\1\41\2\24\1\22\1\uffff\3\22\4\uffff\1\24\2\uffff\1\41\3\uffff\1\24\1\uffff\1\24\1\uffff\1\41\1\uffff\1\24\4\uffff\1\35\1\uffff\2\24\1\50\1\24\1\35\1\24\1\64\1\uffff\1\24\1\35\1\67\1\uffff\1\24\1\35\1\uffff\1\24\1\35\1\24\1\uffff\1\24\2\uffff\1\24\4\35\1\uffff\6\35\1\114\1\uffff";
    static final String DFA25_eofS =
        "\115\uffff";
    static final String DFA25_minS =
        "\1\0\1\55\2\uffff\1\60\2\uffff\5\55\1\101\1\uffff\2\0\1\52\2\uffff\1\60\1\uffff\1\55\2\uffff\1\56\3\uffff\1\55\1\uffff\1\55\1\60\1\55\1\uffff\1\55\4\uffff\1\157\1\uffff\2\55\1\56\1\55\1\147\2\55\1\uffff\1\55\1\151\1\55\1\uffff\1\55\1\170\1\uffff\2\55\1\0\1\60\1\0\1\uffff\2\0\1\120\1\0\1\131\1\55\1\60\1\162\1\143\1\150\1\151\1\166\1\145\1\55\1\uffff";
    static final String DFA25_maxS =
        "\1\uffff\1\172\2\uffff\1\71\2\uffff\6\172\1\uffff\2\uffff\1\57\2\uffff\1\172\1\uffff\1\172\2\uffff\1\71\3\uffff\1\172\1\uffff\1\172\1\71\1\172\1\uffff\1\172\4\uffff\1\157\1\uffff\2\172\1\71\1\172\1\147\2\172\1\uffff\1\172\1\151\1\172\1\uffff\1\172\1\170\1\uffff\1\172\1\55\1\uffff\1\172\1\uffff\1\uffff\2\uffff\1\120\1\uffff\1\131\1\55\1\172\1\162\1\143\1\150\1\151\1\166\1\145\1\172\1\uffff";
    static final String DFA25_acceptS =
        "\2\uffff\1\2\1\3\1\uffff\1\5\1\6\6\uffff\1\16\3\uffff\1\22\1\23\1\uffff\1\16\1\uffff\1\2\1\3\1\uffff\1\4\1\5\1\6\1\uffff\1\11\3\uffff\1\14\1\uffff\1\17\1\20\1\21\1\22\1\uffff\1\13\7\uffff\1\12\3\uffff\1\10\2\uffff\1\7\5\uffff\1\15\16\uffff\1\1";
    static final String DFA25_specialS =
        "\1\3\15\uffff\1\4\1\6\52\uffff\1\1\1\uffff\1\0\1\uffff\1\5\1\2\1\uffff\1\7\13\uffff}>";
    static final String[] DFA25_transitionS = {
            "\11\22\2\21\2\22\1\21\22\22\1\21\1\22\1\16\4\22\1\17\5\22\1\4\1\22\1\20\12\11\1\22\1\6\1\22\1\5\3\22\6\13\1\10\1\13\1\1\5\13\1\7\13\13\3\22\1\14\1\15\1\22\25\13\1\12\4\13\1\2\1\22\1\3\uff82\22",
            "\1\23\2\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "",
            "",
            "\12\30",
            "",
            "",
            "\1\35\2\uffff\12\25\7\uffff\13\25\1\34\16\25\6\uffff\32\25",
            "\1\35\2\uffff\12\25\7\uffff\24\25\1\36\5\25\6\uffff\32\25",
            "\1\35\1\37\1\uffff\12\40\7\uffff\32\35\6\uffff\32\35",
            "\1\35\2\uffff\12\25\7\uffff\32\25\6\uffff\4\25\1\42\25\25",
            "\1\35\2\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "\32\24\4\uffff\1\24\1\uffff\32\24",
            "",
            "\0\43",
            "\0\43",
            "\1\44\4\uffff\1\45",
            "",
            "",
            "\12\35\7\uffff\13\35\1\47\16\35\6\uffff\32\35",
            "",
            "\1\35\2\uffff\12\25\7\uffff\32\25\6\uffff\32\25",
            "",
            "",
            "\1\50\1\uffff\12\30",
            "",
            "",
            "",
            "\1\35\2\uffff\12\25\7\uffff\3\25\1\51\26\25\6\uffff\32\25",
            "",
            "\1\35\2\uffff\12\25\7\uffff\10\25\1\52\21\25\6\uffff\32\25",
            "\12\53",
            "\1\35\1\37\1\uffff\12\40\7\uffff\32\35\6\uffff\32\35",
            "",
            "\1\35\2\uffff\12\25\7\uffff\32\25\6\uffff\21\25\1\54\10\25",
            "",
            "",
            "",
            "",
            "\1\55",
            "",
            "\1\35\2\uffff\12\25\7\uffff\10\25\1\56\21\25\6\uffff\32\25",
            "\1\35\2\uffff\12\25\7\uffff\3\25\1\57\26\25\6\uffff\32\25",
            "\1\60\1\uffff\12\53",
            "\1\35\2\uffff\12\25\7\uffff\32\25\6\uffff\22\25\1\61\7\25",
            "\1\62",
            "\1\35\2\uffff\12\25\7\uffff\3\25\1\63\26\25\6\uffff\32\25",
            "\1\35\2\uffff\12\25\7\uffff\32\25\4\uffff\1\24\1\uffff\32\25",
            "",
            "\1\35\2\uffff\12\25\7\uffff\32\25\6\uffff\10\25\1\65\21\25",
            "\1\66",
            "\1\35\2\uffff\12\25\7\uffff\32\25\4\uffff\1\24\1\uffff\32\25",
            "",
            "\1\35\2\uffff\12\25\7\uffff\32\25\6\uffff\16\25\1\70\13\25",
            "\1\71",
            "",
            "\1\35\2\uffff\12\25\7\uffff\32\25\6\uffff\15\25\1\72\14\25",
            "\1\73",
            "\55\75\1\76\2\75\12\74\7\75\32\74\4\75\1\77\1\75\32\74\uff85\75",
            "\12\35\7\uffff\21\35\1\100\10\35\6\uffff\32\35",
            "\55\75\1\76\2\75\12\74\7\75\32\74\4\75\1\77\1\75\32\74\uff85\75",
            "",
            "\60\75\12\101\7\75\32\101\6\75\32\101\uff85\75",
            "\60\75\12\77\7\75\32\77\4\75\1\77\1\75\32\77\uff85\75",
            "\1\102",
            "\55\75\1\76\2\75\12\101\7\75\32\101\6\75\32\101\uff85\75",
            "\1\103",
            "\1\104",
            "\12\35\7\uffff\1\105\31\35\6\uffff\32\35",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\35\2\uffff\12\35\7\uffff\32\35\6\uffff\32\35",
            ""
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | RULE_RPY_GUID | RULE_RPY_TIME | RULE_RPY_REAL | RULE_INT | RULE_RPY_VERSION | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_60 = input.LA(1);

                        s = -1;
                        if ( ((LA25_60>='\u0000' && LA25_60<=',')||(LA25_60>='.' && LA25_60<='/')||(LA25_60>=':' && LA25_60<='@')||(LA25_60>='[' && LA25_60<='^')||LA25_60=='`'||(LA25_60>='{' && LA25_60<='\uFFFF')) ) {s = 61;}

                        else if ( ((LA25_60>='0' && LA25_60<='9')||(LA25_60>='A' && LA25_60<='Z')||(LA25_60>='a' && LA25_60<='z')) ) {s = 60;}

                        else if ( (LA25_60=='-') ) {s = 62;}

                        else if ( (LA25_60=='_') ) {s = 63;}

                        else s = 20;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_58 = input.LA(1);

                        s = -1;
                        if ( ((LA25_58>='0' && LA25_58<='9')||(LA25_58>='A' && LA25_58<='Z')||(LA25_58>='a' && LA25_58<='z')) ) {s = 60;}

                        else if ( ((LA25_58>='\u0000' && LA25_58<=',')||(LA25_58>='.' && LA25_58<='/')||(LA25_58>=':' && LA25_58<='@')||(LA25_58>='[' && LA25_58<='^')||LA25_58=='`'||(LA25_58>='{' && LA25_58<='\uFFFF')) ) {s = 61;}

                        else if ( (LA25_58=='-') ) {s = 62;}

                        else if ( (LA25_58=='_') ) {s = 63;}

                        else s = 20;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_63 = input.LA(1);

                        s = -1;
                        if ( ((LA25_63>='\u0000' && LA25_63<='/')||(LA25_63>=':' && LA25_63<='@')||(LA25_63>='[' && LA25_63<='^')||LA25_63=='`'||(LA25_63>='{' && LA25_63<='\uFFFF')) ) {s = 61;}

                        else if ( ((LA25_63>='0' && LA25_63<='9')||(LA25_63>='A' && LA25_63<='Z')||LA25_63=='_'||(LA25_63>='a' && LA25_63<='z')) ) {s = 63;}

                        else s = 20;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA25_0 = input.LA(1);

                        s = -1;
                        if ( (LA25_0=='I') ) {s = 1;}

                        else if ( (LA25_0=='{') ) {s = 2;}

                        else if ( (LA25_0=='}') ) {s = 3;}

                        else if ( (LA25_0=='-') ) {s = 4;}

                        else if ( (LA25_0=='=') ) {s = 5;}

                        else if ( (LA25_0==';') ) {s = 6;}

                        else if ( (LA25_0=='O') ) {s = 7;}

                        else if ( (LA25_0=='G') ) {s = 8;}

                        else if ( ((LA25_0>='0' && LA25_0<='9')) ) {s = 9;}

                        else if ( (LA25_0=='v') ) {s = 10;}

                        else if ( ((LA25_0>='A' && LA25_0<='F')||LA25_0=='H'||(LA25_0>='J' && LA25_0<='N')||(LA25_0>='P' && LA25_0<='Z')||(LA25_0>='a' && LA25_0<='u')||(LA25_0>='w' && LA25_0<='z')) ) {s = 11;}

                        else if ( (LA25_0=='^') ) {s = 12;}

                        else if ( (LA25_0=='_') ) {s = 13;}

                        else if ( (LA25_0=='\"') ) {s = 14;}

                        else if ( (LA25_0=='\'') ) {s = 15;}

                        else if ( (LA25_0=='/') ) {s = 16;}

                        else if ( ((LA25_0>='\t' && LA25_0<='\n')||LA25_0=='\r'||LA25_0==' ') ) {s = 17;}

                        else if ( ((LA25_0>='\u0000' && LA25_0<='\b')||(LA25_0>='\u000B' && LA25_0<='\f')||(LA25_0>='\u000E' && LA25_0<='\u001F')||LA25_0=='!'||(LA25_0>='#' && LA25_0<='&')||(LA25_0>='(' && LA25_0<=',')||LA25_0=='.'||LA25_0==':'||LA25_0=='<'||(LA25_0>='>' && LA25_0<='@')||(LA25_0>='[' && LA25_0<=']')||LA25_0=='`'||LA25_0=='|'||(LA25_0>='~' && LA25_0<='\uFFFF')) ) {s = 18;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA25_14 = input.LA(1);

                        s = -1;
                        if ( ((LA25_14>='\u0000' && LA25_14<='\uFFFF')) ) {s = 35;}

                        else s = 18;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA25_62 = input.LA(1);

                        s = -1;
                        if ( ((LA25_62>='0' && LA25_62<='9')||(LA25_62>='A' && LA25_62<='Z')||(LA25_62>='a' && LA25_62<='z')) ) {s = 65;}

                        else if ( ((LA25_62>='\u0000' && LA25_62<='/')||(LA25_62>=':' && LA25_62<='@')||(LA25_62>='[' && LA25_62<='`')||(LA25_62>='{' && LA25_62<='\uFFFF')) ) {s = 61;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA25_15 = input.LA(1);

                        s = -1;
                        if ( ((LA25_15>='\u0000' && LA25_15<='\uFFFF')) ) {s = 35;}

                        else s = 18;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA25_65 = input.LA(1);

                        s = -1;
                        if ( (LA25_65=='-') ) {s = 62;}

                        else if ( ((LA25_65>='0' && LA25_65<='9')||(LA25_65>='A' && LA25_65<='Z')||(LA25_65>='a' && LA25_65<='z')) ) {s = 65;}

                        else if ( ((LA25_65>='\u0000' && LA25_65<=',')||(LA25_65>='.' && LA25_65<='/')||(LA25_65>=':' && LA25_65<='@')||(LA25_65>='[' && LA25_65<='`')||(LA25_65>='{' && LA25_65<='\uFFFF')) ) {s = 61;}

                        else s = 29;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}