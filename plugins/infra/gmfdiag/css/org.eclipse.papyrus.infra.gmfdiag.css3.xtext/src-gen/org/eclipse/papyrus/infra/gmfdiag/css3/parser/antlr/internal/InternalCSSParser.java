package org.eclipse.papyrus.infra.gmfdiag.css3.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.papyrus.infra.gmfdiag.css3.services.CSSGrammarAccess;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class InternalCSSParser extends AbstractInternalAntlrParser {
	public static final String[] tokenNames = new String[] {
			"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_CSSSTRING", "RULE_COLON", "RULE_COMMA", "RULE_PERCENT", "RULE_WS", "RULE_INCLUDES", "RULE_DASHMATCH", "RULE_HASHMARK", "RULE_IMPORTANT_SYM", "RULE_PLUS", "RULE_DASH", "RULE_UNDERSCORE",
			"RULE_ONE_HEX_LETTER", "RULE_ONE_NON_HEX_LETTER", "RULE_ONE_INT", "RULE_ML_COMMENT", "'@charset'", "'@CHARSET'", "';'", "'@import'", "'@IMPORT'", "'@page'", "'@PAGE'", "'{'", "'}'", "'@media'", "'@MEDIA'", "'@font-face'", "'@FONT-FACE'",
			"'@keyframes'", "'@KEYFRAMES'", "'['", "'^='", "'$='", "'*='", "'='", "']'", "'.'", "'*'", "'|'", "')'", "'('", "'not('", "'>'", "'~'", "'url('", "'/'", "'?'", "'@'", "'!'", "'$'", "'&'", "'not'", "'no'", "'url'", "'ur'", "'\\\\ '", "'\\\\('",
			"'\\\\)'", "'\\\\\\''", "'\\\\\"'"
	};
	public static final int T__50 = 50;
	public static final int RULE_IMPORTANT_SYM = 12;
	public static final int T__59 = 59;
	public static final int RULE_CSSSTRING = 4;
	public static final int RULE_UNDERSCORE = 15;
	public static final int T__55 = 55;
	public static final int T__56 = 56;
	public static final int T__57 = 57;
	public static final int T__58 = 58;
	public static final int RULE_PERCENT = 7;
	public static final int T__51 = 51;
	public static final int T__52 = 52;
	public static final int T__53 = 53;
	public static final int T__54 = 54;
	public static final int T__60 = 60;
	public static final int T__61 = 61;
	public static final int RULE_COMMA = 6;
	public static final int RULE_COLON = 5;
	public static final int RULE_HASHMARK = 11;
	public static final int T__26 = 26;
	public static final int T__27 = 27;
	public static final int RULE_DASHMATCH = 10;
	public static final int T__28 = 28;
	public static final int T__29 = 29;
	public static final int T__22 = 22;
	public static final int RULE_ML_COMMENT = 19;
	public static final int T__23 = 23;
	public static final int T__24 = 24;
	public static final int T__25 = 25;
	public static final int T__62 = 62;
	public static final int T__63 = 63;
	public static final int T__20 = 20;
	public static final int T__64 = 64;
	public static final int RULE_INCLUDES = 9;
	public static final int T__21 = 21;
	public static final int RULE_ONE_HEX_LETTER = 16;
	public static final int T__37 = 37;
	public static final int T__38 = 38;
	public static final int T__39 = 39;
	public static final int RULE_DASH = 14;
	public static final int RULE_ONE_INT = 18;
	public static final int T__33 = 33;
	public static final int T__34 = 34;
	public static final int T__35 = 35;
	public static final int RULE_PLUS = 13;
	public static final int T__36 = 36;
	public static final int EOF = -1;
	public static final int T__30 = 30;
	public static final int T__31 = 31;
	public static final int RULE_ONE_NON_HEX_LETTER = 17;
	public static final int T__32 = 32;
	public static final int RULE_WS = 8;
	public static final int T__48 = 48;
	public static final int T__49 = 49;
	public static final int T__44 = 44;
	public static final int T__45 = 45;
	public static final int T__46 = 46;
	public static final int T__47 = 47;
	public static final int T__40 = 40;
	public static final int T__41 = 41;
	public static final int T__42 = 42;
	public static final int T__43 = 43;

	// delegates
	// delegators


	public InternalCSSParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public InternalCSSParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);

	}


	public String[] getTokenNames() {
		return InternalCSSParser.tokenNames;
	}

	public String getGrammarFileName() {
		return "../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g";
	}



	private CSSGrammarAccess grammarAccess;

	public InternalCSSParser(TokenStream input, CSSGrammarAccess grammarAccess) {
		this(input);
		this.grammarAccess = grammarAccess;
		registerRules(grammarAccess.getGrammar());
	}

	@Override
	protected String getFirstRuleName() {
		return "stylesheet";
	}

	@Override
	protected CSSGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}



	// $ANTLR start "entryRulestylesheet"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:67:1: entryRulestylesheet returns [EObject current=null] : iv_rulestylesheet= rulestylesheet EOF ;
	public final EObject entryRulestylesheet() throws RecognitionException {
		EObject current = null;

		EObject iv_rulestylesheet = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:68:2: (iv_rulestylesheet= rulestylesheet EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:69:2: iv_rulestylesheet= rulestylesheet EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getStylesheetRule());
				}
				pushFollow(FOLLOW_rulestylesheet_in_entryRulestylesheet75);
				iv_rulestylesheet = rulestylesheet();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_rulestylesheet;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRulestylesheet85);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulestylesheet"


	// $ANTLR start "rulestylesheet"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:76:1: rulestylesheet returns [EObject current=null] : ( ( (lv_charset_0_0= rulecharset ) )? ( (lv_imports_1_0=
	// ruleimportExpression ) )* ( ( (lv_ruleset_2_0= ruleruleset ) ) | ( (lv_media_3_0= rulemedia ) ) | ( (lv_page_4_0= rulepage ) ) | ( (lv_font_face_5_0= rulefont_face ) ) | ( (lv_keyframes_6_0= rulekeyframes ) ) )* ) ;
	public final EObject rulestylesheet() throws RecognitionException {
		EObject current = null;

		EObject lv_charset_0_0 = null;

		EObject lv_imports_1_0 = null;

		EObject lv_ruleset_2_0 = null;

		EObject lv_media_3_0 = null;

		EObject lv_page_4_0 = null;

		EObject lv_font_face_5_0 = null;

		EObject lv_keyframes_6_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:79:28: ( ( ( (lv_charset_0_0= rulecharset ) )? ( (lv_imports_1_0= ruleimportExpression ) )* ( ( (lv_ruleset_2_0=
			// ruleruleset ) ) | ( (lv_media_3_0= rulemedia ) ) | ( (lv_page_4_0= rulepage ) ) | ( (lv_font_face_5_0= rulefont_face ) ) | ( (lv_keyframes_6_0= rulekeyframes ) ) )* ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:80:1: ( ( (lv_charset_0_0= rulecharset ) )? ( (lv_imports_1_0= ruleimportExpression ) )* ( ( (lv_ruleset_2_0=
			// ruleruleset ) ) | ( (lv_media_3_0= rulemedia ) ) | ( (lv_page_4_0= rulepage ) ) | ( (lv_font_face_5_0= rulefont_face ) ) | ( (lv_keyframes_6_0= rulekeyframes ) ) )* )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:80:1: ( ( (lv_charset_0_0= rulecharset ) )? ( (lv_imports_1_0= ruleimportExpression ) )* ( ( (lv_ruleset_2_0=
				// ruleruleset ) ) | ( (lv_media_3_0= rulemedia ) ) | ( (lv_page_4_0= rulepage ) ) | ( (lv_font_face_5_0= rulefont_face ) ) | ( (lv_keyframes_6_0= rulekeyframes ) ) )* )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:80:2: ( (lv_charset_0_0= rulecharset ) )? ( (lv_imports_1_0= ruleimportExpression ) )* ( ( (lv_ruleset_2_0=
				// ruleruleset ) ) | ( (lv_media_3_0= rulemedia ) ) | ( (lv_page_4_0= rulepage ) ) | ( (lv_font_face_5_0= rulefont_face ) ) | ( (lv_keyframes_6_0= rulekeyframes ) ) )*
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:80:2: ( (lv_charset_0_0= rulecharset ) )?
					int alt1 = 2;
					int LA1_0 = input.LA(1);

					if (((LA1_0 >= 20 && LA1_0 <= 21))) {
						alt1 = 1;
					}
					switch (alt1) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:81:1: (lv_charset_0_0= rulecharset )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:81:1: (lv_charset_0_0= rulecharset )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:82:3: lv_charset_0_0= rulecharset
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getStylesheetAccess().getCharsetCharsetParserRuleCall_0_0());

							}
							pushFollow(FOLLOW_rulecharset_in_rulestylesheet131);
							lv_charset_0_0 = rulecharset();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getStylesheetRule());
								}
								set(
										current,
										"charset",
										lv_charset_0_0,
										"charset");
								afterParserOrEnumRuleCall();

							}

						}


					}
						break;

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:98:3: ( (lv_imports_1_0= ruleimportExpression ) )*
					loop2: do {
						int alt2 = 2;
						int LA2_0 = input.LA(1);

						if (((LA2_0 >= 23 && LA2_0 <= 24))) {
							alt2 = 1;
						}


						switch (alt2) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:99:1: (lv_imports_1_0= ruleimportExpression )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:99:1: (lv_imports_1_0= ruleimportExpression )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:100:3: lv_imports_1_0= ruleimportExpression
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getStylesheetAccess().getImportsImportExpressionParserRuleCall_1_0());

								}
								pushFollow(FOLLOW_ruleimportExpression_in_rulestylesheet153);
								lv_imports_1_0 = ruleimportExpression();

								state._fsp--;
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getStylesheetRule());
									}
									add(
											current,
											"imports",
											lv_imports_1_0,
											"importExpression");
									afterParserOrEnumRuleCall();

								}

							}


						}
							break;

						default:
							break loop2;
						}
					} while (true);

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:116:3: ( ( (lv_ruleset_2_0= ruleruleset ) ) | ( (lv_media_3_0= rulemedia ) ) | ( (lv_page_4_0= rulepage )
					// ) | ( (lv_font_face_5_0= rulefont_face ) ) | ( (lv_keyframes_6_0= rulekeyframes ) ) )*
					loop3: do {
						int alt3 = 6;
						switch (input.LA(1)) {
						case RULE_COLON:
						case RULE_HASHMARK:
						case RULE_DASH:
						case RULE_UNDERSCORE:
						case RULE_ONE_HEX_LETTER:
						case RULE_ONE_NON_HEX_LETTER:
						case 35:
						case 41:
						case 42:
						case 43:
						case 56:
						case 57:
						case 58:
						case 59: {
							alt3 = 1;
						}
							break;
						case 29:
						case 30: {
							alt3 = 2;
						}
							break;
						case 25:
						case 26: {
							alt3 = 3;
						}
							break;
						case 31:
						case 32: {
							alt3 = 4;
						}
							break;
						case 33:
						case 34: {
							alt3 = 5;
						}
							break;

						}

						switch (alt3) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:116:4: ( (lv_ruleset_2_0= ruleruleset ) )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:116:4: ( (lv_ruleset_2_0= ruleruleset ) )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:117:1: (lv_ruleset_2_0= ruleruleset )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:117:1: (lv_ruleset_2_0= ruleruleset )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:118:3: lv_ruleset_2_0= ruleruleset
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getStylesheetAccess().getRulesetRulesetParserRuleCall_2_0_0());

									}
									pushFollow(FOLLOW_ruleruleset_in_rulestylesheet176);
									lv_ruleset_2_0 = ruleruleset();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getStylesheetRule());
										}
										add(
												current,
												"ruleset",
												lv_ruleset_2_0,
												"ruleset");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;
						case 2:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:135:6: ( (lv_media_3_0= rulemedia ) )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:135:6: ( (lv_media_3_0= rulemedia ) )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:136:1: (lv_media_3_0= rulemedia )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:136:1: (lv_media_3_0= rulemedia )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:137:3: lv_media_3_0= rulemedia
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getStylesheetAccess().getMediaMediaParserRuleCall_2_1_0());

									}
									pushFollow(FOLLOW_rulemedia_in_rulestylesheet203);
									lv_media_3_0 = rulemedia();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getStylesheetRule());
										}
										add(
												current,
												"media",
												lv_media_3_0,
												"media");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;
						case 3:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:154:6: ( (lv_page_4_0= rulepage ) )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:154:6: ( (lv_page_4_0= rulepage ) )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:155:1: (lv_page_4_0= rulepage )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:155:1: (lv_page_4_0= rulepage )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:156:3: lv_page_4_0= rulepage
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getStylesheetAccess().getPagePageParserRuleCall_2_2_0());

									}
									pushFollow(FOLLOW_rulepage_in_rulestylesheet230);
									lv_page_4_0 = rulepage();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getStylesheetRule());
										}
										add(
												current,
												"page",
												lv_page_4_0,
												"page");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;
						case 4:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:173:6: ( (lv_font_face_5_0= rulefont_face ) )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:173:6: ( (lv_font_face_5_0= rulefont_face ) )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:174:1: (lv_font_face_5_0= rulefont_face )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:174:1: (lv_font_face_5_0= rulefont_face )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:175:3: lv_font_face_5_0= rulefont_face
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getStylesheetAccess().getFont_faceFont_faceParserRuleCall_2_3_0());

									}
									pushFollow(FOLLOW_rulefont_face_in_rulestylesheet257);
									lv_font_face_5_0 = rulefont_face();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getStylesheetRule());
										}
										add(
												current,
												"font_face",
												lv_font_face_5_0,
												"font_face");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;
						case 5:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:192:6: ( (lv_keyframes_6_0= rulekeyframes ) )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:192:6: ( (lv_keyframes_6_0= rulekeyframes ) )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:193:1: (lv_keyframes_6_0= rulekeyframes )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:193:1: (lv_keyframes_6_0= rulekeyframes )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:194:3: lv_keyframes_6_0= rulekeyframes
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getStylesheetAccess().getKeyframesKeyframesParserRuleCall_2_4_0());

									}
									pushFollow(FOLLOW_rulekeyframes_in_rulestylesheet284);
									lv_keyframes_6_0 = rulekeyframes();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getStylesheetRule());
										}
										add(
												current,
												"keyframes",
												lv_keyframes_6_0,
												"keyframes");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;

						default:
							break loop3;
						}
					} while (true);


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulestylesheet"


	// $ANTLR start "entryRulecharset"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:218:1: entryRulecharset returns [EObject current=null] : iv_rulecharset= rulecharset EOF ;
	public final EObject entryRulecharset() throws RecognitionException {
		EObject current = null;

		EObject iv_rulecharset = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:219:2: (iv_rulecharset= rulecharset EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:220:2: iv_rulecharset= rulecharset EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getCharsetRule());
				}
				pushFollow(FOLLOW_rulecharset_in_entryRulecharset322);
				iv_rulecharset = rulecharset();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_rulecharset;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRulecharset332);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulecharset"


	// $ANTLR start "rulecharset"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:227:1: rulecharset returns [EObject current=null] : ( (otherlv_0= '@charset' | otherlv_1= '@CHARSET' ) ( (lv_charset_2_0=
	// RULE_CSSSTRING ) ) otherlv_3= ';' ) ;
	public final EObject rulecharset() throws RecognitionException {
		EObject current = null;

		Token otherlv_0 = null;
		Token otherlv_1 = null;
		Token lv_charset_2_0 = null;
		Token otherlv_3 = null;

		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:230:28: ( ( (otherlv_0= '@charset' | otherlv_1= '@CHARSET' ) ( (lv_charset_2_0= RULE_CSSSTRING ) ) otherlv_3= ';'
			// ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:231:1: ( (otherlv_0= '@charset' | otherlv_1= '@CHARSET' ) ( (lv_charset_2_0= RULE_CSSSTRING ) ) otherlv_3= ';' )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:231:1: ( (otherlv_0= '@charset' | otherlv_1= '@CHARSET' ) ( (lv_charset_2_0= RULE_CSSSTRING ) ) otherlv_3= ';'
				// )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:231:2: (otherlv_0= '@charset' | otherlv_1= '@CHARSET' ) ( (lv_charset_2_0= RULE_CSSSTRING ) ) otherlv_3= ';'
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:231:2: (otherlv_0= '@charset' | otherlv_1= '@CHARSET' )
					int alt4 = 2;
					int LA4_0 = input.LA(1);

					if ((LA4_0 == 20)) {
						alt4 = 1;
					} else if ((LA4_0 == 21)) {
						alt4 = 2;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 4, 0, input);

						throw nvae;
					}
					switch (alt4) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:231:4: otherlv_0= '@charset'
					{
						otherlv_0 = (Token) match(input, 20, FOLLOW_20_in_rulecharset370);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							newLeafNode(otherlv_0, grammarAccess.getCharsetAccess().getCharsetKeyword_0_0());

						}

					}
						break;
					case 2:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:236:7: otherlv_1= '@CHARSET'
					{
						otherlv_1 = (Token) match(input, 21, FOLLOW_21_in_rulecharset388);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							newLeafNode(otherlv_1, grammarAccess.getCharsetAccess().getCHARSETKeyword_0_1());

						}

					}
						break;

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:240:2: ( (lv_charset_2_0= RULE_CSSSTRING ) )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:241:1: (lv_charset_2_0= RULE_CSSSTRING )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:241:1: (lv_charset_2_0= RULE_CSSSTRING )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:242:3: lv_charset_2_0= RULE_CSSSTRING
						{
							lv_charset_2_0 = (Token) match(input, RULE_CSSSTRING, FOLLOW_RULE_CSSSTRING_in_rulecharset406);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								newLeafNode(lv_charset_2_0, grammarAccess.getCharsetAccess().getCharsetCSSSTRINGTerminalRuleCall_1_0());

							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElement(grammarAccess.getCharsetRule());
								}
								setWithLastConsumed(
										current,
										"charset",
										lv_charset_2_0,
										"CSSSTRING");

							}

						}


					}

					otherlv_3 = (Token) match(input, 22, FOLLOW_22_in_rulecharset423);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_3, grammarAccess.getCharsetAccess().getSemicolonKeyword_2());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulecharset"


	// $ANTLR start "entryRuleimportExpression"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:270:1: entryRuleimportExpression returns [EObject current=null] : iv_ruleimportExpression= ruleimportExpression EOF ;
	public final EObject entryRuleimportExpression() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleimportExpression = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:271:2: (iv_ruleimportExpression= ruleimportExpression EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:272:2: iv_ruleimportExpression= ruleimportExpression EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getImportExpressionRule());
				}
				pushFollow(FOLLOW_ruleimportExpression_in_entryRuleimportExpression459);
				iv_ruleimportExpression = ruleimportExpression();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleimportExpression;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleimportExpression469);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleimportExpression"


	// $ANTLR start "ruleimportExpression"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:279:1: ruleimportExpression returns [EObject current=null] : ( (otherlv_0= '@import' | otherlv_1= '@IMPORT' ) ( (
	// (lv_value_2_0= RULE_CSSSTRING ) ) | (this_URLType_3= ruleURLType ( (lv_mediaList_4_0= rulemedia_list ) )? ) ) otherlv_5= ';' ) ;
	public final EObject ruleimportExpression() throws RecognitionException {
		EObject current = null;

		Token otherlv_0 = null;
		Token otherlv_1 = null;
		Token lv_value_2_0 = null;
		Token otherlv_5 = null;
		EObject this_URLType_3 = null;

		AntlrDatatypeRuleToken lv_mediaList_4_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:282:28: ( ( (otherlv_0= '@import' | otherlv_1= '@IMPORT' ) ( ( (lv_value_2_0= RULE_CSSSTRING ) ) |
			// (this_URLType_3= ruleURLType ( (lv_mediaList_4_0= rulemedia_list ) )? ) ) otherlv_5= ';' ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:283:1: ( (otherlv_0= '@import' | otherlv_1= '@IMPORT' ) ( ( (lv_value_2_0= RULE_CSSSTRING ) ) | (this_URLType_3=
			// ruleURLType ( (lv_mediaList_4_0= rulemedia_list ) )? ) ) otherlv_5= ';' )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:283:1: ( (otherlv_0= '@import' | otherlv_1= '@IMPORT' ) ( ( (lv_value_2_0= RULE_CSSSTRING ) ) |
				// (this_URLType_3= ruleURLType ( (lv_mediaList_4_0= rulemedia_list ) )? ) ) otherlv_5= ';' )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:283:2: (otherlv_0= '@import' | otherlv_1= '@IMPORT' ) ( ( (lv_value_2_0= RULE_CSSSTRING ) ) | (this_URLType_3=
				// ruleURLType ( (lv_mediaList_4_0= rulemedia_list ) )? ) ) otherlv_5= ';'
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:283:2: (otherlv_0= '@import' | otherlv_1= '@IMPORT' )
					int alt5 = 2;
					int LA5_0 = input.LA(1);

					if ((LA5_0 == 23)) {
						alt5 = 1;
					} else if ((LA5_0 == 24)) {
						alt5 = 2;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 5, 0, input);

						throw nvae;
					}
					switch (alt5) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:283:4: otherlv_0= '@import'
					{
						otherlv_0 = (Token) match(input, 23, FOLLOW_23_in_ruleimportExpression507);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							newLeafNode(otherlv_0, grammarAccess.getImportExpressionAccess().getImportKeyword_0_0());

						}

					}
						break;
					case 2:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:288:7: otherlv_1= '@IMPORT'
					{
						otherlv_1 = (Token) match(input, 24, FOLLOW_24_in_ruleimportExpression525);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							newLeafNode(otherlv_1, grammarAccess.getImportExpressionAccess().getIMPORTKeyword_0_1());

						}

					}
						break;

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:292:2: ( ( (lv_value_2_0= RULE_CSSSTRING ) ) | (this_URLType_3= ruleURLType ( (lv_mediaList_4_0=
					// rulemedia_list ) )? ) )
					int alt7 = 2;
					int LA7_0 = input.LA(1);

					if ((LA7_0 == RULE_CSSSTRING)) {
						alt7 = 1;
					} else if ((LA7_0 == 49)) {
						alt7 = 2;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 7, 0, input);

						throw nvae;
					}
					switch (alt7) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:292:3: ( (lv_value_2_0= RULE_CSSSTRING ) )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:292:3: ( (lv_value_2_0= RULE_CSSSTRING ) )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:293:1: (lv_value_2_0= RULE_CSSSTRING )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:293:1: (lv_value_2_0= RULE_CSSSTRING )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:294:3: lv_value_2_0= RULE_CSSSTRING
							{
								lv_value_2_0 = (Token) match(input, RULE_CSSSTRING, FOLLOW_RULE_CSSSTRING_in_ruleimportExpression544);
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									newLeafNode(lv_value_2_0, grammarAccess.getImportExpressionAccess().getValueCSSSTRINGTerminalRuleCall_1_0_0());

								}
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElement(grammarAccess.getImportExpressionRule());
									}
									setWithLastConsumed(
											current,
											"value",
											lv_value_2_0,
											"CSSSTRING");

								}

							}


						}


					}
						break;
					case 2:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:311:6: (this_URLType_3= ruleURLType ( (lv_mediaList_4_0= rulemedia_list ) )? )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:311:6: (this_URLType_3= ruleURLType ( (lv_mediaList_4_0= rulemedia_list ) )? )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:312:5: this_URLType_3= ruleURLType ( (lv_mediaList_4_0= rulemedia_list ) )?
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getImportExpressionAccess().getURLTypeParserRuleCall_1_1_0());

							}
							pushFollow(FOLLOW_ruleURLType_in_ruleimportExpression578);
							this_URLType_3 = ruleURLType();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								current = this_URLType_3;
								afterParserOrEnumRuleCall();

							}
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:320:1: ( (lv_mediaList_4_0= rulemedia_list ) )?
							int alt6 = 2;
							int LA6_0 = input.LA(1);

							if (((LA6_0 >= RULE_DASH && LA6_0 <= RULE_ONE_NON_HEX_LETTER) || (LA6_0 >= 56 && LA6_0 <= 59))) {
								alt6 = 1;
							}
							switch (alt6) {
							case 1:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:321:1: (lv_mediaList_4_0= rulemedia_list )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:321:1: (lv_mediaList_4_0= rulemedia_list )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:322:3: lv_mediaList_4_0= rulemedia_list
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getImportExpressionAccess().getMediaListMedia_listParserRuleCall_1_1_1_0());

									}
									pushFollow(FOLLOW_rulemedia_list_in_ruleimportExpression598);
									lv_mediaList_4_0 = rulemedia_list();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getImportExpressionRule());
										}
										set(
												current,
												"mediaList",
												lv_mediaList_4_0,
												"media_list");
										afterParserOrEnumRuleCall();

									}

								}


							}
								break;

							}


						}


					}
						break;

					}

					otherlv_5 = (Token) match(input, 22, FOLLOW_22_in_ruleimportExpression613);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_5, grammarAccess.getImportExpressionAccess().getSemicolonKeyword_2());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleimportExpression"


	// $ANTLR start "entryRulepage"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:350:1: entryRulepage returns [EObject current=null] : iv_rulepage= rulepage EOF ;
	public final EObject entryRulepage() throws RecognitionException {
		EObject current = null;

		EObject iv_rulepage = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:351:2: (iv_rulepage= rulepage EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:352:2: iv_rulepage= rulepage EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getPageRule());
				}
				pushFollow(FOLLOW_rulepage_in_entryRulepage649);
				iv_rulepage = rulepage();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_rulepage;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRulepage659);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulepage"


	// $ANTLR start "rulepage"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:359:1: rulepage returns [EObject current=null] : ( () (otherlv_1= '@page' | otherlv_2= '@PAGE' ) ( (lv_pseudoPage_3_0=
	// rulepseudo_page ) )? otherlv_4= '{' ( (lv_declarations_5_0= rulecss_declaration ) )? (otherlv_6= ';' ( (lv_declarations_7_0= rulecss_declaration ) )? )* otherlv_8= '}' ) ;
	public final EObject rulepage() throws RecognitionException {
		EObject current = null;

		Token otherlv_1 = null;
		Token otherlv_2 = null;
		Token otherlv_4 = null;
		Token otherlv_6 = null;
		Token otherlv_8 = null;
		AntlrDatatypeRuleToken lv_pseudoPage_3_0 = null;

		EObject lv_declarations_5_0 = null;

		EObject lv_declarations_7_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:362:28: ( ( () (otherlv_1= '@page' | otherlv_2= '@PAGE' ) ( (lv_pseudoPage_3_0= rulepseudo_page ) )? otherlv_4=
			// '{' ( (lv_declarations_5_0= rulecss_declaration ) )? (otherlv_6= ';' ( (lv_declarations_7_0= rulecss_declaration ) )? )* otherlv_8= '}' ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:363:1: ( () (otherlv_1= '@page' | otherlv_2= '@PAGE' ) ( (lv_pseudoPage_3_0= rulepseudo_page ) )? otherlv_4= '{' (
			// (lv_declarations_5_0= rulecss_declaration ) )? (otherlv_6= ';' ( (lv_declarations_7_0= rulecss_declaration ) )? )* otherlv_8= '}' )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:363:1: ( () (otherlv_1= '@page' | otherlv_2= '@PAGE' ) ( (lv_pseudoPage_3_0= rulepseudo_page ) )? otherlv_4=
				// '{' ( (lv_declarations_5_0= rulecss_declaration ) )? (otherlv_6= ';' ( (lv_declarations_7_0= rulecss_declaration ) )? )* otherlv_8= '}' )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:363:2: () (otherlv_1= '@page' | otherlv_2= '@PAGE' ) ( (lv_pseudoPage_3_0= rulepseudo_page ) )? otherlv_4= '{'
				// ( (lv_declarations_5_0= rulecss_declaration ) )? (otherlv_6= ';' ( (lv_declarations_7_0= rulecss_declaration ) )? )* otherlv_8= '}'
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:363:2: ()
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:364:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getPageAccess().getPageAction_0(),
									current);

						}

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:369:2: (otherlv_1= '@page' | otherlv_2= '@PAGE' )
					int alt8 = 2;
					int LA8_0 = input.LA(1);

					if ((LA8_0 == 25)) {
						alt8 = 1;
					} else if ((LA8_0 == 26)) {
						alt8 = 2;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 8, 0, input);

						throw nvae;
					}
					switch (alt8) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:369:4: otherlv_1= '@page'
					{
						otherlv_1 = (Token) match(input, 25, FOLLOW_25_in_rulepage706);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							newLeafNode(otherlv_1, grammarAccess.getPageAccess().getPageKeyword_1_0());

						}

					}
						break;
					case 2:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:374:7: otherlv_2= '@PAGE'
					{
						otherlv_2 = (Token) match(input, 26, FOLLOW_26_in_rulepage724);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							newLeafNode(otherlv_2, grammarAccess.getPageAccess().getPAGEKeyword_1_1());

						}

					}
						break;

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:378:2: ( (lv_pseudoPage_3_0= rulepseudo_page ) )?
					int alt9 = 2;
					int LA9_0 = input.LA(1);

					if ((LA9_0 == RULE_COLON)) {
						alt9 = 1;
					}
					switch (alt9) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:379:1: (lv_pseudoPage_3_0= rulepseudo_page )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:379:1: (lv_pseudoPage_3_0= rulepseudo_page )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:380:3: lv_pseudoPage_3_0= rulepseudo_page
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getPageAccess().getPseudoPagePseudo_pageParserRuleCall_2_0());

							}
							pushFollow(FOLLOW_rulepseudo_page_in_rulepage746);
							lv_pseudoPage_3_0 = rulepseudo_page();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getPageRule());
								}
								set(
										current,
										"pseudoPage",
										lv_pseudoPage_3_0,
										"pseudo_page");
								afterParserOrEnumRuleCall();

							}

						}


					}
						break;

					}

					otherlv_4 = (Token) match(input, 27, FOLLOW_27_in_rulepage759);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_4, grammarAccess.getPageAccess().getLeftCurlyBracketKeyword_3());

					}
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:400:1: ( (lv_declarations_5_0= rulecss_declaration ) )?
					int alt10 = 2;
					int LA10_0 = input.LA(1);

					if ((LA10_0 == RULE_WS || (LA10_0 >= RULE_DASH && LA10_0 <= RULE_ONE_NON_HEX_LETTER) || (LA10_0 >= 56 && LA10_0 <= 59))) {
						alt10 = 1;
					}
					switch (alt10) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:401:1: (lv_declarations_5_0= rulecss_declaration )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:401:1: (lv_declarations_5_0= rulecss_declaration )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:402:3: lv_declarations_5_0= rulecss_declaration
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getPageAccess().getDeclarationsCss_declarationParserRuleCall_4_0());

							}
							pushFollow(FOLLOW_rulecss_declaration_in_rulepage780);
							lv_declarations_5_0 = rulecss_declaration();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getPageRule());
								}
								add(
										current,
										"declarations",
										lv_declarations_5_0,
										"css_declaration");
								afterParserOrEnumRuleCall();

							}

						}


					}
						break;

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:418:3: (otherlv_6= ';' ( (lv_declarations_7_0= rulecss_declaration ) )? )*
					loop12: do {
						int alt12 = 2;
						int LA12_0 = input.LA(1);

						if ((LA12_0 == 22)) {
							alt12 = 1;
						}


						switch (alt12) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:418:5: otherlv_6= ';' ( (lv_declarations_7_0= rulecss_declaration ) )?
						{
							otherlv_6 = (Token) match(input, 22, FOLLOW_22_in_rulepage794);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								newLeafNode(otherlv_6, grammarAccess.getPageAccess().getSemicolonKeyword_5_0());

							}
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:422:1: ( (lv_declarations_7_0= rulecss_declaration ) )?
							int alt11 = 2;
							int LA11_0 = input.LA(1);

							if ((LA11_0 == RULE_WS || (LA11_0 >= RULE_DASH && LA11_0 <= RULE_ONE_NON_HEX_LETTER) || (LA11_0 >= 56 && LA11_0 <= 59))) {
								alt11 = 1;
							}
							switch (alt11) {
							case 1:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:423:1: (lv_declarations_7_0= rulecss_declaration )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:423:1: (lv_declarations_7_0= rulecss_declaration )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:424:3: lv_declarations_7_0= rulecss_declaration
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getPageAccess().getDeclarationsCss_declarationParserRuleCall_5_1_0());

									}
									pushFollow(FOLLOW_rulecss_declaration_in_rulepage815);
									lv_declarations_7_0 = rulecss_declaration();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getPageRule());
										}
										add(
												current,
												"declarations",
												lv_declarations_7_0,
												"css_declaration");
										afterParserOrEnumRuleCall();

									}

								}


							}
								break;

							}


						}
							break;

						default:
							break loop12;
						}
					} while (true);

					otherlv_8 = (Token) match(input, 28, FOLLOW_28_in_rulepage830);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_8, grammarAccess.getPageAccess().getRightCurlyBracketKeyword_6());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulepage"


	// $ANTLR start "entryRulepseudo_page"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:452:1: entryRulepseudo_page returns [String current=null] : iv_rulepseudo_page= rulepseudo_page EOF ;
	public final String entryRulepseudo_page() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_rulepseudo_page = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:453:2: (iv_rulepseudo_page= rulepseudo_page EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:454:2: iv_rulepseudo_page= rulepseudo_page EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getPseudo_pageRule());
				}
				pushFollow(FOLLOW_rulepseudo_page_in_entryRulepseudo_page867);
				iv_rulepseudo_page = rulepseudo_page();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_rulepseudo_page.getText();
				}
				match(input, EOF, FOLLOW_EOF_in_entryRulepseudo_page878);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulepseudo_page"


	// $ANTLR start "rulepseudo_page"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:461:1: rulepseudo_page returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_COLON_0= RULE_COLON
	// this_Identifier_1= ruleIdentifier ) ;
	public final AntlrDatatypeRuleToken rulepseudo_page() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_COLON_0 = null;
		AntlrDatatypeRuleToken this_Identifier_1 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:464:28: ( (this_COLON_0= RULE_COLON this_Identifier_1= ruleIdentifier ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:465:1: (this_COLON_0= RULE_COLON this_Identifier_1= ruleIdentifier )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:465:1: (this_COLON_0= RULE_COLON this_Identifier_1= ruleIdentifier )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:465:6: this_COLON_0= RULE_COLON this_Identifier_1= ruleIdentifier
				{
					this_COLON_0 = (Token) match(input, RULE_COLON, FOLLOW_RULE_COLON_in_rulepseudo_page918);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(this_COLON_0);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_COLON_0, grammarAccess.getPseudo_pageAccess().getCOLONTerminalRuleCall_0());

					}
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getPseudo_pageAccess().getIdentifierParserRuleCall_1());

					}
					pushFollow(FOLLOW_ruleIdentifier_in_rulepseudo_page945);
					this_Identifier_1 = ruleIdentifier();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(this_Identifier_1);

					}
					if (state.backtracking == 0) {

						afterParserOrEnumRuleCall();

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulepseudo_page"


	// $ANTLR start "entryRulemedia"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:491:1: entryRulemedia returns [EObject current=null] : iv_rulemedia= rulemedia EOF ;
	public final EObject entryRulemedia() throws RecognitionException {
		EObject current = null;

		EObject iv_rulemedia = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:492:2: (iv_rulemedia= rulemedia EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:493:2: iv_rulemedia= rulemedia EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getMediaRule());
				}
				pushFollow(FOLLOW_rulemedia_in_entryRulemedia990);
				iv_rulemedia = rulemedia();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_rulemedia;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRulemedia1000);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulemedia"


	// $ANTLR start "rulemedia"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:500:1: rulemedia returns [EObject current=null] : ( (otherlv_0= '@media' | otherlv_1= '@MEDIA' ) ( (lv_medialist_2_0=
	// rulemedia_list ) ) otherlv_3= '{' ( (lv_rulesets_4_0= ruleruleset ) )* otherlv_5= '}' ) ;
	public final EObject rulemedia() throws RecognitionException {
		EObject current = null;

		Token otherlv_0 = null;
		Token otherlv_1 = null;
		Token otherlv_3 = null;
		Token otherlv_5 = null;
		AntlrDatatypeRuleToken lv_medialist_2_0 = null;

		EObject lv_rulesets_4_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:503:28: ( ( (otherlv_0= '@media' | otherlv_1= '@MEDIA' ) ( (lv_medialist_2_0= rulemedia_list ) ) otherlv_3= '{' (
			// (lv_rulesets_4_0= ruleruleset ) )* otherlv_5= '}' ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:504:1: ( (otherlv_0= '@media' | otherlv_1= '@MEDIA' ) ( (lv_medialist_2_0= rulemedia_list ) ) otherlv_3= '{' (
			// (lv_rulesets_4_0= ruleruleset ) )* otherlv_5= '}' )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:504:1: ( (otherlv_0= '@media' | otherlv_1= '@MEDIA' ) ( (lv_medialist_2_0= rulemedia_list ) ) otherlv_3= '{' (
				// (lv_rulesets_4_0= ruleruleset ) )* otherlv_5= '}' )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:504:2: (otherlv_0= '@media' | otherlv_1= '@MEDIA' ) ( (lv_medialist_2_0= rulemedia_list ) ) otherlv_3= '{' (
				// (lv_rulesets_4_0= ruleruleset ) )* otherlv_5= '}'
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:504:2: (otherlv_0= '@media' | otherlv_1= '@MEDIA' )
					int alt13 = 2;
					int LA13_0 = input.LA(1);

					if ((LA13_0 == 29)) {
						alt13 = 1;
					} else if ((LA13_0 == 30)) {
						alt13 = 2;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 13, 0, input);

						throw nvae;
					}
					switch (alt13) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:504:4: otherlv_0= '@media'
					{
						otherlv_0 = (Token) match(input, 29, FOLLOW_29_in_rulemedia1038);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							newLeafNode(otherlv_0, grammarAccess.getMediaAccess().getMediaKeyword_0_0());

						}

					}
						break;
					case 2:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:509:7: otherlv_1= '@MEDIA'
					{
						otherlv_1 = (Token) match(input, 30, FOLLOW_30_in_rulemedia1056);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							newLeafNode(otherlv_1, grammarAccess.getMediaAccess().getMEDIAKeyword_0_1());

						}

					}
						break;

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:513:2: ( (lv_medialist_2_0= rulemedia_list ) )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:514:1: (lv_medialist_2_0= rulemedia_list )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:514:1: (lv_medialist_2_0= rulemedia_list )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:515:3: lv_medialist_2_0= rulemedia_list
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getMediaAccess().getMedialistMedia_listParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_rulemedia_list_in_rulemedia1078);
							lv_medialist_2_0 = rulemedia_list();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getMediaRule());
								}
								set(
										current,
										"medialist",
										lv_medialist_2_0,
										"media_list");
								afterParserOrEnumRuleCall();

							}

						}


					}

					otherlv_3 = (Token) match(input, 27, FOLLOW_27_in_rulemedia1090);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_3, grammarAccess.getMediaAccess().getLeftCurlyBracketKeyword_2());

					}
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:535:1: ( (lv_rulesets_4_0= ruleruleset ) )*
					loop14: do {
						int alt14 = 2;
						int LA14_0 = input.LA(1);

						if ((LA14_0 == RULE_COLON || LA14_0 == RULE_HASHMARK || (LA14_0 >= RULE_DASH && LA14_0 <= RULE_ONE_NON_HEX_LETTER) || LA14_0 == 35 || (LA14_0 >= 41 && LA14_0 <= 43) || (LA14_0 >= 56 && LA14_0 <= 59))) {
							alt14 = 1;
						}


						switch (alt14) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:536:1: (lv_rulesets_4_0= ruleruleset )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:536:1: (lv_rulesets_4_0= ruleruleset )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:537:3: lv_rulesets_4_0= ruleruleset
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getMediaAccess().getRulesetsRulesetParserRuleCall_3_0());

								}
								pushFollow(FOLLOW_ruleruleset_in_rulemedia1111);
								lv_rulesets_4_0 = ruleruleset();

								state._fsp--;
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getMediaRule());
									}
									add(
											current,
											"rulesets",
											lv_rulesets_4_0,
											"ruleset");
									afterParserOrEnumRuleCall();

								}

							}


						}
							break;

						default:
							break loop14;
						}
					} while (true);

					otherlv_5 = (Token) match(input, 28, FOLLOW_28_in_rulemedia1124);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_5, grammarAccess.getMediaAccess().getRightCurlyBracketKeyword_4());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulemedia"


	// $ANTLR start "entryRulemedia_list"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:565:1: entryRulemedia_list returns [String current=null] : iv_rulemedia_list= rulemedia_list EOF ;
	public final String entryRulemedia_list() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_rulemedia_list = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:566:2: (iv_rulemedia_list= rulemedia_list EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:567:2: iv_rulemedia_list= rulemedia_list EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getMedia_listRule());
				}
				pushFollow(FOLLOW_rulemedia_list_in_entryRulemedia_list1161);
				iv_rulemedia_list = rulemedia_list();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_rulemedia_list.getText();
				}
				match(input, EOF, FOLLOW_EOF_in_entryRulemedia_list1172);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulemedia_list"


	// $ANTLR start "rulemedia_list"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:574:1: rulemedia_list returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_medium_0= rulemedium
	// (this_COMMA_1= RULE_COMMA this_medium_2= rulemedium )* ) ;
	public final AntlrDatatypeRuleToken rulemedia_list() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_COMMA_1 = null;
		AntlrDatatypeRuleToken this_medium_0 = null;

		AntlrDatatypeRuleToken this_medium_2 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:577:28: ( (this_medium_0= rulemedium (this_COMMA_1= RULE_COMMA this_medium_2= rulemedium )* ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:578:1: (this_medium_0= rulemedium (this_COMMA_1= RULE_COMMA this_medium_2= rulemedium )* )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:578:1: (this_medium_0= rulemedium (this_COMMA_1= RULE_COMMA this_medium_2= rulemedium )* )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:579:5: this_medium_0= rulemedium (this_COMMA_1= RULE_COMMA this_medium_2= rulemedium )*
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getMedia_listAccess().getMediumParserRuleCall_0());

					}
					pushFollow(FOLLOW_rulemedium_in_rulemedia_list1219);
					this_medium_0 = rulemedium();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(this_medium_0);

					}
					if (state.backtracking == 0) {

						afterParserOrEnumRuleCall();

					}
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:589:1: (this_COMMA_1= RULE_COMMA this_medium_2= rulemedium )*
					loop15: do {
						int alt15 = 2;
						int LA15_0 = input.LA(1);

						if ((LA15_0 == RULE_COMMA)) {
							alt15 = 1;
						}


						switch (alt15) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:589:6: this_COMMA_1= RULE_COMMA this_medium_2= rulemedium
						{
							this_COMMA_1 = (Token) match(input, RULE_COMMA, FOLLOW_RULE_COMMA_in_rulemedia_list1240);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								current.merge(this_COMMA_1);

							}
							if (state.backtracking == 0) {

								newLeafNode(this_COMMA_1, grammarAccess.getMedia_listAccess().getCOMMATerminalRuleCall_1_0());

							}
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getMedia_listAccess().getMediumParserRuleCall_1_1());

							}
							pushFollow(FOLLOW_rulemedium_in_rulemedia_list1267);
							this_medium_2 = rulemedium();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								current.merge(this_medium_2);

							}
							if (state.backtracking == 0) {

								afterParserOrEnumRuleCall();

							}

						}
							break;

						default:
							break loop15;
						}
					} while (true);


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulemedia_list"


	// $ANTLR start "entryRulemedium"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:615:1: entryRulemedium returns [String current=null] : iv_rulemedium= rulemedium EOF ;
	public final String entryRulemedium() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_rulemedium = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:616:2: (iv_rulemedium= rulemedium EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:617:2: iv_rulemedium= rulemedium EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getMediumRule());
				}
				pushFollow(FOLLOW_rulemedium_in_entryRulemedium1315);
				iv_rulemedium = rulemedium();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_rulemedium.getText();
				}
				match(input, EOF, FOLLOW_EOF_in_entryRulemedium1326);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulemedium"


	// $ANTLR start "rulemedium"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:624:1: rulemedium returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0=
	// ruleIdentifier ;
	public final AntlrDatatypeRuleToken rulemedium() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		AntlrDatatypeRuleToken this_Identifier_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:627:28: (this_Identifier_0= ruleIdentifier )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:629:5: this_Identifier_0= ruleIdentifier
			{
				if (state.backtracking == 0) {

					newCompositeNode(grammarAccess.getMediumAccess().getIdentifierParserRuleCall());

				}
				pushFollow(FOLLOW_ruleIdentifier_in_rulemedium1372);
				this_Identifier_0 = ruleIdentifier();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {

					current.merge(this_Identifier_0);

				}
				if (state.backtracking == 0) {

					afterParserOrEnumRuleCall();

				}

			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulemedium"


	// $ANTLR start "entryRulefont_face"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:647:1: entryRulefont_face returns [EObject current=null] : iv_rulefont_face= rulefont_face EOF ;
	public final EObject entryRulefont_face() throws RecognitionException {
		EObject current = null;

		EObject iv_rulefont_face = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:648:2: (iv_rulefont_face= rulefont_face EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:649:2: iv_rulefont_face= rulefont_face EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getFont_faceRule());
				}
				pushFollow(FOLLOW_rulefont_face_in_entryRulefont_face1416);
				iv_rulefont_face = rulefont_face();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_rulefont_face;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRulefont_face1426);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulefont_face"


	// $ANTLR start "rulefont_face"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:656:1: rulefont_face returns [EObject current=null] : ( () (otherlv_1= '@font-face' | otherlv_2= '@FONT-FACE' ) otherlv_3=
	// '{' ( (lv_declarations_4_0= rulecss_declaration ) )? (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )? )* otherlv_7= '}' ) ;
	public final EObject rulefont_face() throws RecognitionException {
		EObject current = null;

		Token otherlv_1 = null;
		Token otherlv_2 = null;
		Token otherlv_3 = null;
		Token otherlv_5 = null;
		Token otherlv_7 = null;
		EObject lv_declarations_4_0 = null;

		EObject lv_declarations_6_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:659:28: ( ( () (otherlv_1= '@font-face' | otherlv_2= '@FONT-FACE' ) otherlv_3= '{' ( (lv_declarations_4_0=
			// rulecss_declaration ) )? (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )? )* otherlv_7= '}' ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:660:1: ( () (otherlv_1= '@font-face' | otherlv_2= '@FONT-FACE' ) otherlv_3= '{' ( (lv_declarations_4_0=
			// rulecss_declaration ) )? (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )? )* otherlv_7= '}' )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:660:1: ( () (otherlv_1= '@font-face' | otherlv_2= '@FONT-FACE' ) otherlv_3= '{' ( (lv_declarations_4_0=
				// rulecss_declaration ) )? (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )? )* otherlv_7= '}' )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:660:2: () (otherlv_1= '@font-face' | otherlv_2= '@FONT-FACE' ) otherlv_3= '{' ( (lv_declarations_4_0=
				// rulecss_declaration ) )? (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )? )* otherlv_7= '}'
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:660:2: ()
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:661:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getFont_faceAccess().getFont_faceAction_0(),
									current);

						}

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:666:2: (otherlv_1= '@font-face' | otherlv_2= '@FONT-FACE' )
					int alt16 = 2;
					int LA16_0 = input.LA(1);

					if ((LA16_0 == 31)) {
						alt16 = 1;
					} else if ((LA16_0 == 32)) {
						alt16 = 2;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 16, 0, input);

						throw nvae;
					}
					switch (alt16) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:666:4: otherlv_1= '@font-face'
					{
						otherlv_1 = (Token) match(input, 31, FOLLOW_31_in_rulefont_face1473);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							newLeafNode(otherlv_1, grammarAccess.getFont_faceAccess().getFontFaceKeyword_1_0());

						}

					}
						break;
					case 2:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:671:7: otherlv_2= '@FONT-FACE'
					{
						otherlv_2 = (Token) match(input, 32, FOLLOW_32_in_rulefont_face1491);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							newLeafNode(otherlv_2, grammarAccess.getFont_faceAccess().getFONTFACEKeyword_1_1());

						}

					}
						break;

					}

					otherlv_3 = (Token) match(input, 27, FOLLOW_27_in_rulefont_face1504);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_3, grammarAccess.getFont_faceAccess().getLeftCurlyBracketKeyword_2());

					}
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:679:1: ( (lv_declarations_4_0= rulecss_declaration ) )?
					int alt17 = 2;
					int LA17_0 = input.LA(1);

					if ((LA17_0 == RULE_WS || (LA17_0 >= RULE_DASH && LA17_0 <= RULE_ONE_NON_HEX_LETTER) || (LA17_0 >= 56 && LA17_0 <= 59))) {
						alt17 = 1;
					}
					switch (alt17) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:680:1: (lv_declarations_4_0= rulecss_declaration )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:680:1: (lv_declarations_4_0= rulecss_declaration )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:681:3: lv_declarations_4_0= rulecss_declaration
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getFont_faceAccess().getDeclarationsCss_declarationParserRuleCall_3_0());

							}
							pushFollow(FOLLOW_rulecss_declaration_in_rulefont_face1525);
							lv_declarations_4_0 = rulecss_declaration();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getFont_faceRule());
								}
								add(
										current,
										"declarations",
										lv_declarations_4_0,
										"css_declaration");
								afterParserOrEnumRuleCall();

							}

						}


					}
						break;

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:697:3: (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )? )*
					loop19: do {
						int alt19 = 2;
						int LA19_0 = input.LA(1);

						if ((LA19_0 == 22)) {
							alt19 = 1;
						}


						switch (alt19) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:697:5: otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )?
						{
							otherlv_5 = (Token) match(input, 22, FOLLOW_22_in_rulefont_face1539);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								newLeafNode(otherlv_5, grammarAccess.getFont_faceAccess().getSemicolonKeyword_4_0());

							}
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:701:1: ( (lv_declarations_6_0= rulecss_declaration ) )?
							int alt18 = 2;
							int LA18_0 = input.LA(1);

							if ((LA18_0 == RULE_WS || (LA18_0 >= RULE_DASH && LA18_0 <= RULE_ONE_NON_HEX_LETTER) || (LA18_0 >= 56 && LA18_0 <= 59))) {
								alt18 = 1;
							}
							switch (alt18) {
							case 1:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:702:1: (lv_declarations_6_0= rulecss_declaration )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:702:1: (lv_declarations_6_0= rulecss_declaration )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:703:3: lv_declarations_6_0= rulecss_declaration
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getFont_faceAccess().getDeclarationsCss_declarationParserRuleCall_4_1_0());

									}
									pushFollow(FOLLOW_rulecss_declaration_in_rulefont_face1560);
									lv_declarations_6_0 = rulecss_declaration();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getFont_faceRule());
										}
										add(
												current,
												"declarations",
												lv_declarations_6_0,
												"css_declaration");
										afterParserOrEnumRuleCall();

									}

								}


							}
								break;

							}


						}
							break;

						default:
							break loop19;
						}
					} while (true);

					otherlv_7 = (Token) match(input, 28, FOLLOW_28_in_rulefont_face1575);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_7, grammarAccess.getFont_faceAccess().getRightCurlyBracketKeyword_5());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulefont_face"


	// $ANTLR start "entryRulekeyframes"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:731:1: entryRulekeyframes returns [EObject current=null] : iv_rulekeyframes= rulekeyframes EOF ;
	public final EObject entryRulekeyframes() throws RecognitionException {
		EObject current = null;

		EObject iv_rulekeyframes = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:732:2: (iv_rulekeyframes= rulekeyframes EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:733:2: iv_rulekeyframes= rulekeyframes EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getKeyframesRule());
				}
				pushFollow(FOLLOW_rulekeyframes_in_entryRulekeyframes1611);
				iv_rulekeyframes = rulekeyframes();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_rulekeyframes;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRulekeyframes1621);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulekeyframes"


	// $ANTLR start "rulekeyframes"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:740:1: rulekeyframes returns [EObject current=null] : ( () (otherlv_1= '@keyframes' | otherlv_2= '@KEYFRAMES' ) (
	// (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '{' ( (lv_keyframeselectors_5_0= rulekeyframe_selector ) )? (otherlv_6= ';' ( (lv_keyframeselectors_7_0= rulekeyframe_selector ) )? )* otherlv_8= '}' ) ;
	public final EObject rulekeyframes() throws RecognitionException {
		EObject current = null;

		Token otherlv_1 = null;
		Token otherlv_2 = null;
		Token otherlv_4 = null;
		Token otherlv_6 = null;
		Token otherlv_8 = null;
		AntlrDatatypeRuleToken lv_name_3_0 = null;

		EObject lv_keyframeselectors_5_0 = null;

		EObject lv_keyframeselectors_7_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:743:28: ( ( () (otherlv_1= '@keyframes' | otherlv_2= '@KEYFRAMES' ) ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4=
			// '{' ( (lv_keyframeselectors_5_0= rulekeyframe_selector ) )? (otherlv_6= ';' ( (lv_keyframeselectors_7_0= rulekeyframe_selector ) )? )* otherlv_8= '}' ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:744:1: ( () (otherlv_1= '@keyframes' | otherlv_2= '@KEYFRAMES' ) ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '{'
			// ( (lv_keyframeselectors_5_0= rulekeyframe_selector ) )? (otherlv_6= ';' ( (lv_keyframeselectors_7_0= rulekeyframe_selector ) )? )* otherlv_8= '}' )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:744:1: ( () (otherlv_1= '@keyframes' | otherlv_2= '@KEYFRAMES' ) ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4=
				// '{' ( (lv_keyframeselectors_5_0= rulekeyframe_selector ) )? (otherlv_6= ';' ( (lv_keyframeselectors_7_0= rulekeyframe_selector ) )? )* otherlv_8= '}' )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:744:2: () (otherlv_1= '@keyframes' | otherlv_2= '@KEYFRAMES' ) ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4=
				// '{' ( (lv_keyframeselectors_5_0= rulekeyframe_selector ) )? (otherlv_6= ';' ( (lv_keyframeselectors_7_0= rulekeyframe_selector ) )? )* otherlv_8= '}'
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:744:2: ()
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:745:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getKeyframesAccess().getFont_faceAction_0(),
									current);

						}

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:750:2: (otherlv_1= '@keyframes' | otherlv_2= '@KEYFRAMES' )
					int alt20 = 2;
					int LA20_0 = input.LA(1);

					if ((LA20_0 == 33)) {
						alt20 = 1;
					} else if ((LA20_0 == 34)) {
						alt20 = 2;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 20, 0, input);

						throw nvae;
					}
					switch (alt20) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:750:4: otherlv_1= '@keyframes'
					{
						otherlv_1 = (Token) match(input, 33, FOLLOW_33_in_rulekeyframes1668);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							newLeafNode(otherlv_1, grammarAccess.getKeyframesAccess().getKeyframesKeyword_1_0());

						}

					}
						break;
					case 2:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:755:7: otherlv_2= '@KEYFRAMES'
					{
						otherlv_2 = (Token) match(input, 34, FOLLOW_34_in_rulekeyframes1686);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							newLeafNode(otherlv_2, grammarAccess.getKeyframesAccess().getKEYFRAMESKeyword_1_1());

						}

					}
						break;

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:759:2: ( (lv_name_3_0= ruleIdentifier ) )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:760:1: (lv_name_3_0= ruleIdentifier )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:760:1: (lv_name_3_0= ruleIdentifier )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:761:3: lv_name_3_0= ruleIdentifier
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getKeyframesAccess().getNameIdentifierParserRuleCall_2_0());

							}
							pushFollow(FOLLOW_ruleIdentifier_in_rulekeyframes1708);
							lv_name_3_0 = ruleIdentifier();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getKeyframesRule());
								}
								set(
										current,
										"name",
										lv_name_3_0,
										"Identifier");
								afterParserOrEnumRuleCall();

							}

						}


					}

					otherlv_4 = (Token) match(input, 27, FOLLOW_27_in_rulekeyframes1720);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_4, grammarAccess.getKeyframesAccess().getLeftCurlyBracketKeyword_3());

					}
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:781:1: ( (lv_keyframeselectors_5_0= rulekeyframe_selector ) )?
					int alt21 = 2;
					int LA21_0 = input.LA(1);

					if (((LA21_0 >= RULE_PLUS && LA21_0 <= RULE_ONE_INT) || LA21_0 == 41 || (LA21_0 >= 56 && LA21_0 <= 59))) {
						alt21 = 1;
					}
					switch (alt21) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:782:1: (lv_keyframeselectors_5_0= rulekeyframe_selector )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:782:1: (lv_keyframeselectors_5_0= rulekeyframe_selector )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:783:3: lv_keyframeselectors_5_0= rulekeyframe_selector
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getKeyframesAccess().getKeyframeselectorsKeyframe_selectorParserRuleCall_4_0());

							}
							pushFollow(FOLLOW_rulekeyframe_selector_in_rulekeyframes1741);
							lv_keyframeselectors_5_0 = rulekeyframe_selector();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getKeyframesRule());
								}
								add(
										current,
										"keyframeselectors",
										lv_keyframeselectors_5_0,
										"keyframe_selector");
								afterParserOrEnumRuleCall();

							}

						}


					}
						break;

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:799:3: (otherlv_6= ';' ( (lv_keyframeselectors_7_0= rulekeyframe_selector ) )? )*
					loop23: do {
						int alt23 = 2;
						int LA23_0 = input.LA(1);

						if ((LA23_0 == 22)) {
							alt23 = 1;
						}


						switch (alt23) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:799:5: otherlv_6= ';' ( (lv_keyframeselectors_7_0= rulekeyframe_selector ) )?
						{
							otherlv_6 = (Token) match(input, 22, FOLLOW_22_in_rulekeyframes1755);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								newLeafNode(otherlv_6, grammarAccess.getKeyframesAccess().getSemicolonKeyword_5_0());

							}
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:803:1: ( (lv_keyframeselectors_7_0= rulekeyframe_selector ) )?
							int alt22 = 2;
							int LA22_0 = input.LA(1);

							if (((LA22_0 >= RULE_PLUS && LA22_0 <= RULE_ONE_INT) || LA22_0 == 41 || (LA22_0 >= 56 && LA22_0 <= 59))) {
								alt22 = 1;
							}
							switch (alt22) {
							case 1:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:804:1: (lv_keyframeselectors_7_0= rulekeyframe_selector )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:804:1: (lv_keyframeselectors_7_0= rulekeyframe_selector )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:805:3: lv_keyframeselectors_7_0= rulekeyframe_selector
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getKeyframesAccess().getKeyframeselectorsKeyframe_selectorParserRuleCall_5_1_0());

									}
									pushFollow(FOLLOW_rulekeyframe_selector_in_rulekeyframes1776);
									lv_keyframeselectors_7_0 = rulekeyframe_selector();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getKeyframesRule());
										}
										add(
												current,
												"keyframeselectors",
												lv_keyframeselectors_7_0,
												"keyframe_selector");
										afterParserOrEnumRuleCall();

									}

								}


							}
								break;

							}


						}
							break;

						default:
							break loop23;
						}
					} while (true);

					otherlv_8 = (Token) match(input, 28, FOLLOW_28_in_rulekeyframes1791);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_8, grammarAccess.getKeyframesAccess().getRightCurlyBracketKeyword_6());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulekeyframes"


	// $ANTLR start "entryRulekeyframe_selector"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:833:1: entryRulekeyframe_selector returns [EObject current=null] : iv_rulekeyframe_selector= rulekeyframe_selector EOF ;
	public final EObject entryRulekeyframe_selector() throws RecognitionException {
		EObject current = null;

		EObject iv_rulekeyframe_selector = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:834:2: (iv_rulekeyframe_selector= rulekeyframe_selector EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:835:2: iv_rulekeyframe_selector= rulekeyframe_selector EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getKeyframe_selectorRule());
				}
				pushFollow(FOLLOW_rulekeyframe_selector_in_entryRulekeyframe_selector1827);
				iv_rulekeyframe_selector = rulekeyframe_selector();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_rulekeyframe_selector;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRulekeyframe_selector1837);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulekeyframe_selector"


	// $ANTLR start "rulekeyframe_selector"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:842:1: rulekeyframe_selector returns [EObject current=null] : ( ( ( (lv_type_0_0= ruleIdentifier ) ) | ( (
	// (lv_percentage_1_0= ruleNum ) ) this_PERCENT_2= RULE_PERCENT ) ) otherlv_3= '{' ( (lv_declarations_4_0= rulecss_declaration ) )? (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )? )* otherlv_7= '}' ) ;
	public final EObject rulekeyframe_selector() throws RecognitionException {
		EObject current = null;

		Token this_PERCENT_2 = null;
		Token otherlv_3 = null;
		Token otherlv_5 = null;
		Token otherlv_7 = null;
		AntlrDatatypeRuleToken lv_type_0_0 = null;

		AntlrDatatypeRuleToken lv_percentage_1_0 = null;

		EObject lv_declarations_4_0 = null;

		EObject lv_declarations_6_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:845:28: ( ( ( ( (lv_type_0_0= ruleIdentifier ) ) | ( ( (lv_percentage_1_0= ruleNum ) ) this_PERCENT_2=
			// RULE_PERCENT ) ) otherlv_3= '{' ( (lv_declarations_4_0= rulecss_declaration ) )? (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )? )* otherlv_7= '}' ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:846:1: ( ( ( (lv_type_0_0= ruleIdentifier ) ) | ( ( (lv_percentage_1_0= ruleNum ) ) this_PERCENT_2= RULE_PERCENT )
			// ) otherlv_3= '{' ( (lv_declarations_4_0= rulecss_declaration ) )? (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )? )* otherlv_7= '}' )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:846:1: ( ( ( (lv_type_0_0= ruleIdentifier ) ) | ( ( (lv_percentage_1_0= ruleNum ) ) this_PERCENT_2=
				// RULE_PERCENT ) ) otherlv_3= '{' ( (lv_declarations_4_0= rulecss_declaration ) )? (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )? )* otherlv_7= '}' )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:846:2: ( ( (lv_type_0_0= ruleIdentifier ) ) | ( ( (lv_percentage_1_0= ruleNum ) ) this_PERCENT_2= RULE_PERCENT
				// ) ) otherlv_3= '{' ( (lv_declarations_4_0= rulecss_declaration ) )? (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )? )* otherlv_7= '}'
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:846:2: ( ( (lv_type_0_0= ruleIdentifier ) ) | ( ( (lv_percentage_1_0= ruleNum ) ) this_PERCENT_2=
					// RULE_PERCENT ) )
					int alt24 = 2;
					switch (input.LA(1)) {
					case RULE_DASH: {
						int LA24_1 = input.LA(2);

						if ((LA24_1 == RULE_ONE_INT || LA24_1 == 41)) {
							alt24 = 2;
						} else if (((LA24_1 >= RULE_UNDERSCORE && LA24_1 <= RULE_ONE_NON_HEX_LETTER) || (LA24_1 >= 56 && LA24_1 <= 59))) {
							alt24 = 1;
						} else {
							if (state.backtracking > 0) {
								state.failed = true;
								return current;
							}
							NoViableAltException nvae = new NoViableAltException("", 24, 1, input);

							throw nvae;
						}
					}
						break;
					case RULE_UNDERSCORE:
					case RULE_ONE_HEX_LETTER:
					case RULE_ONE_NON_HEX_LETTER:
					case 56:
					case 57:
					case 58:
					case 59: {
						alt24 = 1;
					}
						break;
					case RULE_PLUS:
					case RULE_ONE_INT:
					case 41: {
						alt24 = 2;
					}
						break;
					default:
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 24, 0, input);

						throw nvae;
					}

					switch (alt24) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:846:3: ( (lv_type_0_0= ruleIdentifier ) )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:846:3: ( (lv_type_0_0= ruleIdentifier ) )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:847:1: (lv_type_0_0= ruleIdentifier )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:847:1: (lv_type_0_0= ruleIdentifier )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:848:3: lv_type_0_0= ruleIdentifier
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getKeyframe_selectorAccess().getTypeIdentifierParserRuleCall_0_0_0());

								}
								pushFollow(FOLLOW_ruleIdentifier_in_rulekeyframe_selector1884);
								lv_type_0_0 = ruleIdentifier();

								state._fsp--;
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getKeyframe_selectorRule());
									}
									set(
											current,
											"type",
											lv_type_0_0,
											"Identifier");
									afterParserOrEnumRuleCall();

								}

							}


						}


					}
						break;
					case 2:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:865:6: ( ( (lv_percentage_1_0= ruleNum ) ) this_PERCENT_2= RULE_PERCENT )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:865:6: ( ( (lv_percentage_1_0= ruleNum ) ) this_PERCENT_2= RULE_PERCENT )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:865:7: ( (lv_percentage_1_0= ruleNum ) ) this_PERCENT_2= RULE_PERCENT
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:865:7: ( (lv_percentage_1_0= ruleNum ) )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:866:1: (lv_percentage_1_0= ruleNum )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:866:1: (lv_percentage_1_0= ruleNum )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:867:3: lv_percentage_1_0= ruleNum
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getKeyframe_selectorAccess().getPercentageNumParserRuleCall_0_1_0_0());

									}
									pushFollow(FOLLOW_ruleNum_in_rulekeyframe_selector1912);
									lv_percentage_1_0 = ruleNum();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getKeyframe_selectorRule());
										}
										set(
												current,
												"percentage",
												lv_percentage_1_0,
												"Num");
										afterParserOrEnumRuleCall();

									}

								}


							}

							this_PERCENT_2 = (Token) match(input, RULE_PERCENT, FOLLOW_RULE_PERCENT_in_rulekeyframe_selector1923);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								newLeafNode(this_PERCENT_2, grammarAccess.getKeyframe_selectorAccess().getPERCENTTerminalRuleCall_0_1_1());

							}

						}


					}
						break;

					}

					otherlv_3 = (Token) match(input, 27, FOLLOW_27_in_rulekeyframe_selector1936);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_3, grammarAccess.getKeyframe_selectorAccess().getLeftCurlyBracketKeyword_1());

					}
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:891:1: ( (lv_declarations_4_0= rulecss_declaration ) )?
					int alt25 = 2;
					int LA25_0 = input.LA(1);

					if ((LA25_0 == RULE_WS || (LA25_0 >= RULE_DASH && LA25_0 <= RULE_ONE_NON_HEX_LETTER) || (LA25_0 >= 56 && LA25_0 <= 59))) {
						alt25 = 1;
					}
					switch (alt25) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:892:1: (lv_declarations_4_0= rulecss_declaration )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:892:1: (lv_declarations_4_0= rulecss_declaration )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:893:3: lv_declarations_4_0= rulecss_declaration
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getKeyframe_selectorAccess().getDeclarationsCss_declarationParserRuleCall_2_0());

							}
							pushFollow(FOLLOW_rulecss_declaration_in_rulekeyframe_selector1957);
							lv_declarations_4_0 = rulecss_declaration();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getKeyframe_selectorRule());
								}
								add(
										current,
										"declarations",
										lv_declarations_4_0,
										"css_declaration");
								afterParserOrEnumRuleCall();

							}

						}


					}
						break;

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:909:3: (otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )? )*
					loop27: do {
						int alt27 = 2;
						int LA27_0 = input.LA(1);

						if ((LA27_0 == 22)) {
							alt27 = 1;
						}


						switch (alt27) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:909:5: otherlv_5= ';' ( (lv_declarations_6_0= rulecss_declaration ) )?
						{
							otherlv_5 = (Token) match(input, 22, FOLLOW_22_in_rulekeyframe_selector1971);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								newLeafNode(otherlv_5, grammarAccess.getKeyframe_selectorAccess().getSemicolonKeyword_3_0());

							}
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:913:1: ( (lv_declarations_6_0= rulecss_declaration ) )?
							int alt26 = 2;
							int LA26_0 = input.LA(1);

							if ((LA26_0 == RULE_WS || (LA26_0 >= RULE_DASH && LA26_0 <= RULE_ONE_NON_HEX_LETTER) || (LA26_0 >= 56 && LA26_0 <= 59))) {
								alt26 = 1;
							}
							switch (alt26) {
							case 1:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:914:1: (lv_declarations_6_0= rulecss_declaration )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:914:1: (lv_declarations_6_0= rulecss_declaration )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:915:3: lv_declarations_6_0= rulecss_declaration
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getKeyframe_selectorAccess().getDeclarationsCss_declarationParserRuleCall_3_1_0());

									}
									pushFollow(FOLLOW_rulecss_declaration_in_rulekeyframe_selector1992);
									lv_declarations_6_0 = rulecss_declaration();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getKeyframe_selectorRule());
										}
										add(
												current,
												"declarations",
												lv_declarations_6_0,
												"css_declaration");
										afterParserOrEnumRuleCall();

									}

								}


							}
								break;

							}


						}
							break;

						default:
							break loop27;
						}
					} while (true);

					otherlv_7 = (Token) match(input, 28, FOLLOW_28_in_rulekeyframe_selector2007);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_7, grammarAccess.getKeyframe_selectorAccess().getRightCurlyBracketKeyword_4());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulekeyframe_selector"


	// $ANTLR start "entryRuleruleset"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:943:1: entryRuleruleset returns [EObject current=null] : iv_ruleruleset= ruleruleset EOF ;
	public final EObject entryRuleruleset() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleruleset = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:944:2: (iv_ruleruleset= ruleruleset EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:945:2: iv_ruleruleset= ruleruleset EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getRulesetRule());
				}
				pushFollow(FOLLOW_ruleruleset_in_entryRuleruleset2043);
				iv_ruleruleset = ruleruleset();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleruleset;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleruleset2053);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleruleset"


	// $ANTLR start "ruleruleset"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:952:1: ruleruleset returns [EObject current=null] : ( ( (lv_selectors_0_0= ruleselector ) ) ( (this_WS_1= RULE_WS )*
	// this_COMMA_2= RULE_COMMA ( (lv_selectors_3_0= ruleselector ) ) )* (this_WS_4= RULE_WS )* otherlv_5= '{' ( ( (lv_declarations_6_0= rulecss_declaration ) ) (otherlv_7= ';' ( (lv_declarations_8_0= rulecss_declaration ) ) )* (otherlv_9= ';' )? )?
	// otherlv_10= '}' ) ;
	public final EObject ruleruleset() throws RecognitionException {
		EObject current = null;

		Token this_WS_1 = null;
		Token this_COMMA_2 = null;
		Token this_WS_4 = null;
		Token otherlv_5 = null;
		Token otherlv_7 = null;
		Token otherlv_9 = null;
		Token otherlv_10 = null;
		EObject lv_selectors_0_0 = null;

		EObject lv_selectors_3_0 = null;

		EObject lv_declarations_6_0 = null;

		EObject lv_declarations_8_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:955:28: ( ( ( (lv_selectors_0_0= ruleselector ) ) ( (this_WS_1= RULE_WS )* this_COMMA_2= RULE_COMMA (
			// (lv_selectors_3_0= ruleselector ) ) )* (this_WS_4= RULE_WS )* otherlv_5= '{' ( ( (lv_declarations_6_0= rulecss_declaration ) ) (otherlv_7= ';' ( (lv_declarations_8_0= rulecss_declaration ) ) )* (otherlv_9= ';' )? )? otherlv_10= '}' ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:956:1: ( ( (lv_selectors_0_0= ruleselector ) ) ( (this_WS_1= RULE_WS )* this_COMMA_2= RULE_COMMA (
			// (lv_selectors_3_0= ruleselector ) ) )* (this_WS_4= RULE_WS )* otherlv_5= '{' ( ( (lv_declarations_6_0= rulecss_declaration ) ) (otherlv_7= ';' ( (lv_declarations_8_0= rulecss_declaration ) ) )* (otherlv_9= ';' )? )? otherlv_10= '}' )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:956:1: ( ( (lv_selectors_0_0= ruleselector ) ) ( (this_WS_1= RULE_WS )* this_COMMA_2= RULE_COMMA (
				// (lv_selectors_3_0= ruleselector ) ) )* (this_WS_4= RULE_WS )* otherlv_5= '{' ( ( (lv_declarations_6_0= rulecss_declaration ) ) (otherlv_7= ';' ( (lv_declarations_8_0= rulecss_declaration ) ) )* (otherlv_9= ';' )? )? otherlv_10= '}' )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:956:2: ( (lv_selectors_0_0= ruleselector ) ) ( (this_WS_1= RULE_WS )* this_COMMA_2= RULE_COMMA (
				// (lv_selectors_3_0= ruleselector ) ) )* (this_WS_4= RULE_WS )* otherlv_5= '{' ( ( (lv_declarations_6_0= rulecss_declaration ) ) (otherlv_7= ';' ( (lv_declarations_8_0= rulecss_declaration ) ) )* (otherlv_9= ';' )? )? otherlv_10= '}'
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:956:2: ( (lv_selectors_0_0= ruleselector ) )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:957:1: (lv_selectors_0_0= ruleselector )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:957:1: (lv_selectors_0_0= ruleselector )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:958:3: lv_selectors_0_0= ruleselector
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getRulesetAccess().getSelectorsSelectorParserRuleCall_0_0());

							}
							pushFollow(FOLLOW_ruleselector_in_ruleruleset2099);
							lv_selectors_0_0 = ruleselector();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getRulesetRule());
								}
								add(
										current,
										"selectors",
										lv_selectors_0_0,
										"selector");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:974:2: ( (this_WS_1= RULE_WS )* this_COMMA_2= RULE_COMMA ( (lv_selectors_3_0= ruleselector ) ) )*
					loop29: do {
						int alt29 = 2;
						alt29 = dfa29.predict(input);
						switch (alt29) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:974:3: (this_WS_1= RULE_WS )* this_COMMA_2= RULE_COMMA ( (lv_selectors_3_0= ruleselector ) )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:974:3: (this_WS_1= RULE_WS )*
							loop28: do {
								int alt28 = 2;
								int LA28_0 = input.LA(1);

								if ((LA28_0 == RULE_WS)) {
									alt28 = 1;
								}


								switch (alt28) {
								case 1:
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:974:4: this_WS_1= RULE_WS
								{
									this_WS_1 = (Token) match(input, RULE_WS, FOLLOW_RULE_WS_in_ruleruleset2112);
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										newLeafNode(this_WS_1, grammarAccess.getRulesetAccess().getWSTerminalRuleCall_1_0());

									}

								}
									break;

								default:
									break loop28;
								}
							} while (true);

							this_COMMA_2 = (Token) match(input, RULE_COMMA, FOLLOW_RULE_COMMA_in_ruleruleset2124);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								newLeafNode(this_COMMA_2, grammarAccess.getRulesetAccess().getCOMMATerminalRuleCall_1_1());

							}
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:982:1: ( (lv_selectors_3_0= ruleselector ) )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:983:1: (lv_selectors_3_0= ruleselector )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:983:1: (lv_selectors_3_0= ruleselector )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:984:3: lv_selectors_3_0= ruleselector
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getRulesetAccess().getSelectorsSelectorParserRuleCall_1_2_0());

									}
									pushFollow(FOLLOW_ruleselector_in_ruleruleset2144);
									lv_selectors_3_0 = ruleselector();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getRulesetRule());
										}
										add(
												current,
												"selectors",
												lv_selectors_3_0,
												"selector");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;

						default:
							break loop29;
						}
					} while (true);

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1000:4: (this_WS_4= RULE_WS )*
					loop30: do {
						int alt30 = 2;
						int LA30_0 = input.LA(1);

						if ((LA30_0 == RULE_WS)) {
							alt30 = 1;
						}


						switch (alt30) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1000:5: this_WS_4= RULE_WS
						{
							this_WS_4 = (Token) match(input, RULE_WS, FOLLOW_RULE_WS_in_ruleruleset2158);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								newLeafNode(this_WS_4, grammarAccess.getRulesetAccess().getWSTerminalRuleCall_2());

							}

						}
							break;

						default:
							break loop30;
						}
					} while (true);

					otherlv_5 = (Token) match(input, 27, FOLLOW_27_in_ruleruleset2171);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_5, grammarAccess.getRulesetAccess().getLeftCurlyBracketKeyword_3());

					}
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1008:1: ( ( (lv_declarations_6_0= rulecss_declaration ) ) (otherlv_7= ';' ( (lv_declarations_8_0=
					// rulecss_declaration ) ) )* (otherlv_9= ';' )? )?
					int alt33 = 2;
					int LA33_0 = input.LA(1);

					if ((LA33_0 == RULE_WS || (LA33_0 >= RULE_DASH && LA33_0 <= RULE_ONE_NON_HEX_LETTER) || (LA33_0 >= 56 && LA33_0 <= 59))) {
						alt33 = 1;
					}
					switch (alt33) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1008:2: ( (lv_declarations_6_0= rulecss_declaration ) ) (otherlv_7= ';' ( (lv_declarations_8_0=
					// rulecss_declaration ) ) )* (otherlv_9= ';' )?
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1008:2: ( (lv_declarations_6_0= rulecss_declaration ) )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1009:1: (lv_declarations_6_0= rulecss_declaration )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1009:1: (lv_declarations_6_0= rulecss_declaration )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1010:3: lv_declarations_6_0= rulecss_declaration
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getRulesetAccess().getDeclarationsCss_declarationParserRuleCall_4_0_0());

								}
								pushFollow(FOLLOW_rulecss_declaration_in_ruleruleset2193);
								lv_declarations_6_0 = rulecss_declaration();

								state._fsp--;
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getRulesetRule());
									}
									add(
											current,
											"declarations",
											lv_declarations_6_0,
											"css_declaration");
									afterParserOrEnumRuleCall();

								}

							}


						}

						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1026:2: (otherlv_7= ';' ( (lv_declarations_8_0= rulecss_declaration ) ) )*
						loop31: do {
							int alt31 = 2;
							int LA31_0 = input.LA(1);

							if ((LA31_0 == 22)) {
								int LA31_1 = input.LA(2);

								if ((LA31_1 == RULE_WS || (LA31_1 >= RULE_DASH && LA31_1 <= RULE_ONE_NON_HEX_LETTER) || (LA31_1 >= 56 && LA31_1 <= 59))) {
									alt31 = 1;
								}


							}


							switch (alt31) {
							case 1:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1026:4: otherlv_7= ';' ( (lv_declarations_8_0= rulecss_declaration ) )
							{
								otherlv_7 = (Token) match(input, 22, FOLLOW_22_in_ruleruleset2206);
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									newLeafNode(otherlv_7, grammarAccess.getRulesetAccess().getSemicolonKeyword_4_1_0());

								}
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1030:1: ( (lv_declarations_8_0= rulecss_declaration ) )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1031:1: (lv_declarations_8_0= rulecss_declaration )
								{
									// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1031:1: (lv_declarations_8_0= rulecss_declaration )
									// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1032:3: lv_declarations_8_0= rulecss_declaration
									{
										if (state.backtracking == 0) {

											newCompositeNode(grammarAccess.getRulesetAccess().getDeclarationsCss_declarationParserRuleCall_4_1_1_0());

										}
										pushFollow(FOLLOW_rulecss_declaration_in_ruleruleset2227);
										lv_declarations_8_0 = rulecss_declaration();

										state._fsp--;
										if (state.failed)
											return current;
										if (state.backtracking == 0) {

											if (current == null) {
												current = createModelElementForParent(grammarAccess.getRulesetRule());
											}
											add(
													current,
													"declarations",
													lv_declarations_8_0,
													"css_declaration");
											afterParserOrEnumRuleCall();

										}

									}


								}


							}
								break;

							default:
								break loop31;
							}
						} while (true);

						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1048:4: (otherlv_9= ';' )?
						int alt32 = 2;
						int LA32_0 = input.LA(1);

						if ((LA32_0 == 22)) {
							alt32 = 1;
						}
						switch (alt32) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1048:6: otherlv_9= ';'
						{
							otherlv_9 = (Token) match(input, 22, FOLLOW_22_in_ruleruleset2242);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								newLeafNode(otherlv_9, grammarAccess.getRulesetAccess().getSemicolonKeyword_4_2());

							}

						}
							break;

						}


					}
						break;

					}

					otherlv_10 = (Token) match(input, 28, FOLLOW_28_in_ruleruleset2258);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_10, grammarAccess.getRulesetAccess().getRightCurlyBracketKeyword_5());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleruleset"


	// $ANTLR start "entryRuleselector"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1064:1: entryRuleselector returns [EObject current=null] : iv_ruleselector= ruleselector EOF ;
	public final EObject entryRuleselector() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleselector = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1065:2: (iv_ruleselector= ruleselector EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1066:2: iv_ruleselector= ruleselector EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getSelectorRule());
				}
				pushFollow(FOLLOW_ruleselector_in_entryRuleselector2294);
				iv_ruleselector = ruleselector();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleselector;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleselector2304);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleselector"


	// $ANTLR start "ruleselector"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1073:1: ruleselector returns [EObject current=null] : ( ( (lv_simpleselectors_0_0= rulesimple_selector ) ) ( ( (
	// (lv_combinator_1_0= rulecombinator ) ) (this_WS_2= RULE_WS )* ( (lv_selector_3_0= ruleselector ) ) ) | ( (this_WS_4= RULE_WS )+ ( ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )* )? ( (lv_selector_7_0= ruleselector ) ) ) )? ) ;
	public final EObject ruleselector() throws RecognitionException {
		EObject current = null;

		Token this_WS_2 = null;
		Token this_WS_4 = null;
		Token this_WS_6 = null;
		EObject lv_simpleselectors_0_0 = null;

		AntlrDatatypeRuleToken lv_combinator_1_0 = null;

		EObject lv_selector_3_0 = null;

		AntlrDatatypeRuleToken lv_combinator_5_0 = null;

		EObject lv_selector_7_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1076:28: ( ( ( (lv_simpleselectors_0_0= rulesimple_selector ) ) ( ( ( (lv_combinator_1_0= rulecombinator ) )
			// (this_WS_2= RULE_WS )* ( (lv_selector_3_0= ruleselector ) ) ) | ( (this_WS_4= RULE_WS )+ ( ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )* )? ( (lv_selector_7_0= ruleselector ) ) ) )? ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1077:1: ( ( (lv_simpleselectors_0_0= rulesimple_selector ) ) ( ( ( (lv_combinator_1_0= rulecombinator ) )
			// (this_WS_2= RULE_WS )* ( (lv_selector_3_0= ruleselector ) ) ) | ( (this_WS_4= RULE_WS )+ ( ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )* )? ( (lv_selector_7_0= ruleselector ) ) ) )? )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1077:1: ( ( (lv_simpleselectors_0_0= rulesimple_selector ) ) ( ( ( (lv_combinator_1_0= rulecombinator ) )
				// (this_WS_2= RULE_WS )* ( (lv_selector_3_0= ruleselector ) ) ) | ( (this_WS_4= RULE_WS )+ ( ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )* )? ( (lv_selector_7_0= ruleselector ) ) ) )? )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1077:2: ( (lv_simpleselectors_0_0= rulesimple_selector ) ) ( ( ( (lv_combinator_1_0= rulecombinator ) )
				// (this_WS_2= RULE_WS )* ( (lv_selector_3_0= ruleselector ) ) ) | ( (this_WS_4= RULE_WS )+ ( ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )* )? ( (lv_selector_7_0= ruleselector ) ) ) )?
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1077:2: ( (lv_simpleselectors_0_0= rulesimple_selector ) )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1078:1: (lv_simpleselectors_0_0= rulesimple_selector )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1078:1: (lv_simpleselectors_0_0= rulesimple_selector )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1079:3: lv_simpleselectors_0_0= rulesimple_selector
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getSelectorAccess().getSimpleselectorsSimple_selectorParserRuleCall_0_0());

							}
							pushFollow(FOLLOW_rulesimple_selector_in_ruleselector2350);
							lv_simpleselectors_0_0 = rulesimple_selector();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getSelectorRule());
								}
								add(
										current,
										"simpleselectors",
										lv_simpleselectors_0_0,
										"simple_selector");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1095:2: ( ( ( (lv_combinator_1_0= rulecombinator ) ) (this_WS_2= RULE_WS )* ( (lv_selector_3_0=
					// ruleselector ) ) ) | ( (this_WS_4= RULE_WS )+ ( ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )* )? ( (lv_selector_7_0= ruleselector ) ) ) )?
					int alt38 = 3;
					alt38 = dfa38.predict(input);
					switch (alt38) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1095:3: ( ( (lv_combinator_1_0= rulecombinator ) ) (this_WS_2= RULE_WS )* ( (lv_selector_3_0= ruleselector
					// ) ) )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1095:3: ( ( (lv_combinator_1_0= rulecombinator ) ) (this_WS_2= RULE_WS )* ( (lv_selector_3_0=
						// ruleselector ) ) )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1095:4: ( (lv_combinator_1_0= rulecombinator ) ) (this_WS_2= RULE_WS )* ( (lv_selector_3_0=
						// ruleselector ) )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1095:4: ( (lv_combinator_1_0= rulecombinator ) )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1096:1: (lv_combinator_1_0= rulecombinator )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1096:1: (lv_combinator_1_0= rulecombinator )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1097:3: lv_combinator_1_0= rulecombinator
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getSelectorAccess().getCombinatorCombinatorParserRuleCall_1_0_0_0());

									}
									pushFollow(FOLLOW_rulecombinator_in_ruleselector2373);
									lv_combinator_1_0 = rulecombinator();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getSelectorRule());
										}
										set(
												current,
												"combinator",
												lv_combinator_1_0,
												"combinator");
										afterParserOrEnumRuleCall();

									}

								}


							}

							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1113:2: (this_WS_2= RULE_WS )*
							loop34: do {
								int alt34 = 2;
								int LA34_0 = input.LA(1);

								if ((LA34_0 == RULE_WS)) {
									alt34 = 1;
								}


								switch (alt34) {
								case 1:
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1113:3: this_WS_2= RULE_WS
								{
									this_WS_2 = (Token) match(input, RULE_WS, FOLLOW_RULE_WS_in_ruleselector2385);
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										newLeafNode(this_WS_2, grammarAccess.getSelectorAccess().getWSTerminalRuleCall_1_0_1());

									}

								}
									break;

								default:
									break loop34;
								}
							} while (true);

							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1117:3: ( (lv_selector_3_0= ruleselector ) )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1118:1: (lv_selector_3_0= ruleselector )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1118:1: (lv_selector_3_0= ruleselector )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1119:3: lv_selector_3_0= ruleselector
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getSelectorAccess().getSelectorSelectorParserRuleCall_1_0_2_0());

									}
									pushFollow(FOLLOW_ruleselector_in_ruleselector2407);
									lv_selector_3_0 = ruleselector();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getSelectorRule());
										}
										set(
												current,
												"selector",
												lv_selector_3_0,
												"selector");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}


					}
						break;
					case 2:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1136:6: ( (this_WS_4= RULE_WS )+ ( ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )* )? (
					// (lv_selector_7_0= ruleselector ) ) )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1136:6: ( (this_WS_4= RULE_WS )+ ( ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )* )?
						// ( (lv_selector_7_0= ruleselector ) ) )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1136:7: (this_WS_4= RULE_WS )+ ( ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )* )? (
						// (lv_selector_7_0= ruleselector ) )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1136:7: (this_WS_4= RULE_WS )+
							int cnt35 = 0;
							loop35: do {
								int alt35 = 2;
								int LA35_0 = input.LA(1);

								if ((LA35_0 == RULE_WS)) {
									alt35 = 1;
								}


								switch (alt35) {
								case 1:
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1136:8: this_WS_4= RULE_WS
								{
									this_WS_4 = (Token) match(input, RULE_WS, FOLLOW_RULE_WS_in_ruleselector2427);
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										newLeafNode(this_WS_4, grammarAccess.getSelectorAccess().getWSTerminalRuleCall_1_1_0());

									}

								}
									break;

								default:
									if (cnt35 >= 1)
										break loop35;
									if (state.backtracking > 0) {
										state.failed = true;
										return current;
									}
									EarlyExitException eee = new EarlyExitException(35, input);
									throw eee;
								}
								cnt35++;
							} while (true);

							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1140:3: ( ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )* )?
							int alt37 = 2;
							int LA37_0 = input.LA(1);

							if ((LA37_0 == RULE_PLUS || (LA37_0 >= 47 && LA37_0 <= 48))) {
								alt37 = 1;
							}
							switch (alt37) {
							case 1:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1140:4: ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )*
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1140:4: ( (lv_combinator_5_0= rulecombinator ) )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1141:1: (lv_combinator_5_0= rulecombinator )
								{
									// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1141:1: (lv_combinator_5_0= rulecombinator )
									// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1142:3: lv_combinator_5_0= rulecombinator
									{
										if (state.backtracking == 0) {

											newCompositeNode(grammarAccess.getSelectorAccess().getCombinatorCombinatorParserRuleCall_1_1_1_0_0());

										}
										pushFollow(FOLLOW_rulecombinator_in_ruleselector2450);
										lv_combinator_5_0 = rulecombinator();

										state._fsp--;
										if (state.failed)
											return current;
										if (state.backtracking == 0) {

											if (current == null) {
												current = createModelElementForParent(grammarAccess.getSelectorRule());
											}
											set(
													current,
													"combinator",
													lv_combinator_5_0,
													"combinator");
											afterParserOrEnumRuleCall();

										}

									}


								}

								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1158:2: (this_WS_6= RULE_WS )*
								loop36: do {
									int alt36 = 2;
									int LA36_0 = input.LA(1);

									if ((LA36_0 == RULE_WS)) {
										alt36 = 1;
									}


									switch (alt36) {
									case 1:
									// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1158:3: this_WS_6= RULE_WS
									{
										this_WS_6 = (Token) match(input, RULE_WS, FOLLOW_RULE_WS_in_ruleselector2462);
										if (state.failed)
											return current;
										if (state.backtracking == 0) {

											newLeafNode(this_WS_6, grammarAccess.getSelectorAccess().getWSTerminalRuleCall_1_1_1_1());

										}

									}
										break;

									default:
										break loop36;
									}
								} while (true);


							}
								break;

							}

							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1162:5: ( (lv_selector_7_0= ruleselector ) )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1163:1: (lv_selector_7_0= ruleselector )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1163:1: (lv_selector_7_0= ruleselector )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1164:3: lv_selector_7_0= ruleselector
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getSelectorAccess().getSelectorSelectorParserRuleCall_1_1_2_0());

									}
									pushFollow(FOLLOW_ruleselector_in_ruleselector2486);
									lv_selector_7_0 = ruleselector();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getSelectorRule());
										}
										set(
												current,
												"selector",
												lv_selector_7_0,
												"selector");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}


					}
						break;

					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleselector"


	// $ANTLR start "entryRuleSimpleSelectorForNegation"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1188:1: entryRuleSimpleSelectorForNegation returns [EObject current=null] : iv_ruleSimpleSelectorForNegation=
	// ruleSimpleSelectorForNegation EOF ;
	public final EObject entryRuleSimpleSelectorForNegation() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleSimpleSelectorForNegation = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1189:2: (iv_ruleSimpleSelectorForNegation= ruleSimpleSelectorForNegation EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1190:2: iv_ruleSimpleSelectorForNegation= ruleSimpleSelectorForNegation EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getSimpleSelectorForNegationRule());
				}
				pushFollow(FOLLOW_ruleSimpleSelectorForNegation_in_entryRuleSimpleSelectorForNegation2525);
				iv_ruleSimpleSelectorForNegation = ruleSimpleSelectorForNegation();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleSimpleSelectorForNegation;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleSimpleSelectorForNegation2535);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleSimpleSelectorForNegation"


	// $ANTLR start "ruleSimpleSelectorForNegation"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1197:1: ruleSimpleSelectorForNegation returns [EObject current=null] : ( ( ( ( (lv_element_0_0= ruleElementSelector ) ) |
	// ( (lv_universal_1_0= ruleUniversalSelector ) ) ) ( (lv_subSelectors_2_0= ruleSubSelectorForNegation ) )* ) | ( ( ( ruleSubSelectorForNegation ) )=> (lv_subSelectors_3_0= ruleSubSelectorForNegation ) )+ ) ;
	public final EObject ruleSimpleSelectorForNegation() throws RecognitionException {
		EObject current = null;

		EObject lv_element_0_0 = null;

		EObject lv_universal_1_0 = null;

		EObject lv_subSelectors_2_0 = null;

		EObject lv_subSelectors_3_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1200:28: ( ( ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) (
			// (lv_subSelectors_2_0= ruleSubSelectorForNegation ) )* ) | ( ( ( ruleSubSelectorForNegation ) )=> (lv_subSelectors_3_0= ruleSubSelectorForNegation ) )+ ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1201:1: ( ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) (
			// (lv_subSelectors_2_0= ruleSubSelectorForNegation ) )* ) | ( ( ( ruleSubSelectorForNegation ) )=> (lv_subSelectors_3_0= ruleSubSelectorForNegation ) )+ )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1201:1: ( ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) (
				// (lv_subSelectors_2_0= ruleSubSelectorForNegation ) )* ) | ( ( ( ruleSubSelectorForNegation ) )=> (lv_subSelectors_3_0= ruleSubSelectorForNegation ) )+ )
				int alt42 = 2;
				int LA42_0 = input.LA(1);

				if (((LA42_0 >= RULE_DASH && LA42_0 <= RULE_ONE_NON_HEX_LETTER) || (LA42_0 >= 42 && LA42_0 <= 43) || (LA42_0 >= 56 && LA42_0 <= 59))) {
					alt42 = 1;
				} else if ((LA42_0 == RULE_COLON || LA42_0 == RULE_HASHMARK || LA42_0 == 35 || LA42_0 == 41)) {
					alt42 = 2;
				} else {
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 42, 0, input);

					throw nvae;
				}
				switch (alt42) {
				case 1:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1201:2: ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) (
				// (lv_subSelectors_2_0= ruleSubSelectorForNegation ) )* )
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1201:2: ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) )
					// ( (lv_subSelectors_2_0= ruleSubSelectorForNegation ) )* )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1201:3: ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) (
					// (lv_subSelectors_2_0= ruleSubSelectorForNegation ) )*
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1201:3: ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) )
						// )
						int alt39 = 2;
						alt39 = dfa39.predict(input);
						switch (alt39) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1201:4: ( (lv_element_0_0= ruleElementSelector ) )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1201:4: ( (lv_element_0_0= ruleElementSelector ) )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1202:1: (lv_element_0_0= ruleElementSelector )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1202:1: (lv_element_0_0= ruleElementSelector )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1203:3: lv_element_0_0= ruleElementSelector
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getSimpleSelectorForNegationAccess().getElementElementSelectorParserRuleCall_0_0_0_0());

									}
									pushFollow(FOLLOW_ruleElementSelector_in_ruleSimpleSelectorForNegation2583);
									lv_element_0_0 = ruleElementSelector();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getSimpleSelectorForNegationRule());
										}
										set(
												current,
												"element",
												lv_element_0_0,
												"ElementSelector");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;
						case 2:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1220:6: ( (lv_universal_1_0= ruleUniversalSelector ) )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1220:6: ( (lv_universal_1_0= ruleUniversalSelector ) )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1221:1: (lv_universal_1_0= ruleUniversalSelector )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1221:1: (lv_universal_1_0= ruleUniversalSelector )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1222:3: lv_universal_1_0= ruleUniversalSelector
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getSimpleSelectorForNegationAccess().getUniversalUniversalSelectorParserRuleCall_0_0_1_0());

									}
									pushFollow(FOLLOW_ruleUniversalSelector_in_ruleSimpleSelectorForNegation2610);
									lv_universal_1_0 = ruleUniversalSelector();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getSimpleSelectorForNegationRule());
										}
										set(
												current,
												"universal",
												lv_universal_1_0,
												"UniversalSelector");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;

						}

						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1238:3: ( (lv_subSelectors_2_0= ruleSubSelectorForNegation ) )*
						loop40: do {
							int alt40 = 2;
							int LA40_0 = input.LA(1);

							if ((LA40_0 == RULE_COLON || LA40_0 == RULE_HASHMARK || LA40_0 == 35 || LA40_0 == 41)) {
								alt40 = 1;
							}


							switch (alt40) {
							case 1:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1239:1: (lv_subSelectors_2_0= ruleSubSelectorForNegation )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1239:1: (lv_subSelectors_2_0= ruleSubSelectorForNegation )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1240:3: lv_subSelectors_2_0= ruleSubSelectorForNegation
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getSimpleSelectorForNegationAccess().getSubSelectorsSubSelectorForNegationParserRuleCall_0_1_0());

									}
									pushFollow(FOLLOW_ruleSubSelectorForNegation_in_ruleSimpleSelectorForNegation2632);
									lv_subSelectors_2_0 = ruleSubSelectorForNegation();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getSimpleSelectorForNegationRule());
										}
										add(
												current,
												"subSelectors",
												lv_subSelectors_2_0,
												"SubSelectorForNegation");
										afterParserOrEnumRuleCall();

									}

								}


							}
								break;

							default:
								break loop40;
							}
						} while (true);


					}


				}
					break;
				case 2:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1257:6: ( ( ( ruleSubSelectorForNegation ) )=> (lv_subSelectors_3_0= ruleSubSelectorForNegation ) )+
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1257:6: ( ( ( ruleSubSelectorForNegation ) )=> (lv_subSelectors_3_0= ruleSubSelectorForNegation ) )+
					int cnt41 = 0;
					loop41: do {
						int alt41 = 2;
						int LA41_0 = input.LA(1);

						if ((LA41_0 == RULE_HASHMARK) && (synpred1_InternalCSS())) {
							alt41 = 1;
						} else if ((LA41_0 == 41) && (synpred1_InternalCSS())) {
							alt41 = 1;
						} else if ((LA41_0 == 35) && (synpred1_InternalCSS())) {
							alt41 = 1;
						} else if ((LA41_0 == RULE_COLON) && (synpred1_InternalCSS())) {
							alt41 = 1;
						}


						switch (alt41) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1257:7: ( ( ruleSubSelectorForNegation ) )=> (lv_subSelectors_3_0= ruleSubSelectorForNegation )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1262:1: (lv_subSelectors_3_0= ruleSubSelectorForNegation )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1263:3: lv_subSelectors_3_0= ruleSubSelectorForNegation
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getSimpleSelectorForNegationAccess().getSubSelectorsSubSelectorForNegationParserRuleCall_1_0());

								}
								pushFollow(FOLLOW_ruleSubSelectorForNegation_in_ruleSimpleSelectorForNegation2671);
								lv_subSelectors_3_0 = ruleSubSelectorForNegation();

								state._fsp--;
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getSimpleSelectorForNegationRule());
									}
									add(
											current,
											"subSelectors",
											lv_subSelectors_3_0,
											"SubSelectorForNegation");
									afterParserOrEnumRuleCall();

								}

							}


						}
							break;

						default:
							if (cnt41 >= 1)
								break loop41;
							if (state.backtracking > 0) {
								state.failed = true;
								return current;
							}
							EarlyExitException eee = new EarlyExitException(41, input);
							throw eee;
						}
						cnt41++;
					} while (true);


				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleSimpleSelectorForNegation"


	// $ANTLR start "entryRuleSubSelectorForNegation"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1287:1: entryRuleSubSelectorForNegation returns [EObject current=null] : iv_ruleSubSelectorForNegation=
	// ruleSubSelectorForNegation EOF ;
	public final EObject entryRuleSubSelectorForNegation() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleSubSelectorForNegation = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1288:2: (iv_ruleSubSelectorForNegation= ruleSubSelectorForNegation EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1289:2: iv_ruleSubSelectorForNegation= ruleSubSelectorForNegation EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getSubSelectorForNegationRule());
				}
				pushFollow(FOLLOW_ruleSubSelectorForNegation_in_entryRuleSubSelectorForNegation2708);
				iv_ruleSubSelectorForNegation = ruleSubSelectorForNegation();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleSubSelectorForNegation;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleSubSelectorForNegation2718);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleSubSelectorForNegation"


	// $ANTLR start "ruleSubSelectorForNegation"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1296:1: ruleSubSelectorForNegation returns [EObject current=null] : (this_IdSelector_0= ruleIdSelector |
	// this_ClassSelector_1= ruleClassSelector | this_AttributeSelector_2= ruleAttributeSelector | this_PseudoClass_3= rulePseudoClass ) ;
	public final EObject ruleSubSelectorForNegation() throws RecognitionException {
		EObject current = null;

		EObject this_IdSelector_0 = null;

		EObject this_ClassSelector_1 = null;

		EObject this_AttributeSelector_2 = null;

		EObject this_PseudoClass_3 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1299:28: ( (this_IdSelector_0= ruleIdSelector | this_ClassSelector_1= ruleClassSelector |
			// this_AttributeSelector_2= ruleAttributeSelector | this_PseudoClass_3= rulePseudoClass ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1300:1: (this_IdSelector_0= ruleIdSelector | this_ClassSelector_1= ruleClassSelector | this_AttributeSelector_2=
			// ruleAttributeSelector | this_PseudoClass_3= rulePseudoClass )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1300:1: (this_IdSelector_0= ruleIdSelector | this_ClassSelector_1= ruleClassSelector |
				// this_AttributeSelector_2= ruleAttributeSelector | this_PseudoClass_3= rulePseudoClass )
				int alt43 = 4;
				switch (input.LA(1)) {
				case RULE_HASHMARK: {
					alt43 = 1;
				}
					break;
				case 41: {
					alt43 = 2;
				}
					break;
				case 35: {
					alt43 = 3;
				}
					break;
				case RULE_COLON: {
					alt43 = 4;
				}
					break;
				default:
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 43, 0, input);

					throw nvae;
				}

				switch (alt43) {
				case 1:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1301:5: this_IdSelector_0= ruleIdSelector
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getSubSelectorForNegationAccess().getIdSelectorParserRuleCall_0());

					}
					pushFollow(FOLLOW_ruleIdSelector_in_ruleSubSelectorForNegation2765);
					this_IdSelector_0 = ruleIdSelector();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current = this_IdSelector_0;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 2:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1311:5: this_ClassSelector_1= ruleClassSelector
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getSubSelectorForNegationAccess().getClassSelectorParserRuleCall_1());

					}
					pushFollow(FOLLOW_ruleClassSelector_in_ruleSubSelectorForNegation2792);
					this_ClassSelector_1 = ruleClassSelector();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current = this_ClassSelector_1;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 3:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1321:5: this_AttributeSelector_2= ruleAttributeSelector
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getSubSelectorForNegationAccess().getAttributeSelectorParserRuleCall_2());

					}
					pushFollow(FOLLOW_ruleAttributeSelector_in_ruleSubSelectorForNegation2819);
					this_AttributeSelector_2 = ruleAttributeSelector();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current = this_AttributeSelector_2;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 4:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1331:5: this_PseudoClass_3= rulePseudoClass
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getSubSelectorForNegationAccess().getPseudoClassParserRuleCall_3());

					}
					pushFollow(FOLLOW_rulePseudoClass_in_ruleSubSelectorForNegation2846);
					this_PseudoClass_3 = rulePseudoClass();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current = this_PseudoClass_3;
						afterParserOrEnumRuleCall();

					}

				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleSubSelectorForNegation"


	// $ANTLR start "entryRulesimple_selector"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1347:1: entryRulesimple_selector returns [EObject current=null] : iv_rulesimple_selector= rulesimple_selector EOF ;
	public final EObject entryRulesimple_selector() throws RecognitionException {
		EObject current = null;

		EObject iv_rulesimple_selector = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1348:2: (iv_rulesimple_selector= rulesimple_selector EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1349:2: iv_rulesimple_selector= rulesimple_selector EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getSimple_selectorRule());
				}
				pushFollow(FOLLOW_rulesimple_selector_in_entryRulesimple_selector2881);
				iv_rulesimple_selector = rulesimple_selector();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_rulesimple_selector;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRulesimple_selector2891);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulesimple_selector"


	// $ANTLR start "rulesimple_selector"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1356:1: rulesimple_selector returns [EObject current=null] : ( ( ( ( (lv_element_0_0= ruleElementSelector ) ) | (
	// (lv_universal_1_0= ruleUniversalSelector ) ) ) ( (lv_subSelectors_2_0= ruleSubSelector ) )* ) | ( (lv_subSelectors_3_0= ruleSubSelector ) )+ ) ;
	public final EObject rulesimple_selector() throws RecognitionException {
		EObject current = null;

		EObject lv_element_0_0 = null;

		EObject lv_universal_1_0 = null;

		EObject lv_subSelectors_2_0 = null;

		EObject lv_subSelectors_3_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1359:28: ( ( ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) (
			// (lv_subSelectors_2_0= ruleSubSelector ) )* ) | ( (lv_subSelectors_3_0= ruleSubSelector ) )+ ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1360:1: ( ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) (
			// (lv_subSelectors_2_0= ruleSubSelector ) )* ) | ( (lv_subSelectors_3_0= ruleSubSelector ) )+ )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1360:1: ( ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) (
				// (lv_subSelectors_2_0= ruleSubSelector ) )* ) | ( (lv_subSelectors_3_0= ruleSubSelector ) )+ )
				int alt47 = 2;
				int LA47_0 = input.LA(1);

				if (((LA47_0 >= RULE_DASH && LA47_0 <= RULE_ONE_NON_HEX_LETTER) || (LA47_0 >= 42 && LA47_0 <= 43) || (LA47_0 >= 56 && LA47_0 <= 59))) {
					alt47 = 1;
				} else if ((LA47_0 == RULE_COLON || LA47_0 == RULE_HASHMARK || LA47_0 == 35 || LA47_0 == 41)) {
					alt47 = 2;
				} else {
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 47, 0, input);

					throw nvae;
				}
				switch (alt47) {
				case 1:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1360:2: ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) (
				// (lv_subSelectors_2_0= ruleSubSelector ) )* )
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1360:2: ( ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) )
					// ( (lv_subSelectors_2_0= ruleSubSelector ) )* )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1360:3: ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) ) (
					// (lv_subSelectors_2_0= ruleSubSelector ) )*
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1360:3: ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) )
						// )
						int alt44 = 2;
						alt44 = dfa44.predict(input);
						switch (alt44) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1360:4: ( (lv_element_0_0= ruleElementSelector ) )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1360:4: ( (lv_element_0_0= ruleElementSelector ) )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1361:1: (lv_element_0_0= ruleElementSelector )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1361:1: (lv_element_0_0= ruleElementSelector )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1362:3: lv_element_0_0= ruleElementSelector
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getSimple_selectorAccess().getElementElementSelectorParserRuleCall_0_0_0_0());

									}
									pushFollow(FOLLOW_ruleElementSelector_in_rulesimple_selector2939);
									lv_element_0_0 = ruleElementSelector();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getSimple_selectorRule());
										}
										set(
												current,
												"element",
												lv_element_0_0,
												"ElementSelector");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;
						case 2:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1379:6: ( (lv_universal_1_0= ruleUniversalSelector ) )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1379:6: ( (lv_universal_1_0= ruleUniversalSelector ) )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1380:1: (lv_universal_1_0= ruleUniversalSelector )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1380:1: (lv_universal_1_0= ruleUniversalSelector )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1381:3: lv_universal_1_0= ruleUniversalSelector
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getSimple_selectorAccess().getUniversalUniversalSelectorParserRuleCall_0_0_1_0());

									}
									pushFollow(FOLLOW_ruleUniversalSelector_in_rulesimple_selector2966);
									lv_universal_1_0 = ruleUniversalSelector();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getSimple_selectorRule());
										}
										set(
												current,
												"universal",
												lv_universal_1_0,
												"UniversalSelector");
										afterParserOrEnumRuleCall();

									}

								}


							}


						}
							break;

						}

						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1397:3: ( (lv_subSelectors_2_0= ruleSubSelector ) )*
						loop45: do {
							int alt45 = 2;
							int LA45_0 = input.LA(1);

							if ((LA45_0 == RULE_COLON || LA45_0 == RULE_HASHMARK || LA45_0 == 35 || LA45_0 == 41)) {
								alt45 = 1;
							}


							switch (alt45) {
							case 1:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1398:1: (lv_subSelectors_2_0= ruleSubSelector )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1398:1: (lv_subSelectors_2_0= ruleSubSelector )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1399:3: lv_subSelectors_2_0= ruleSubSelector
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getSimple_selectorAccess().getSubSelectorsSubSelectorParserRuleCall_0_1_0());

									}
									pushFollow(FOLLOW_ruleSubSelector_in_rulesimple_selector2988);
									lv_subSelectors_2_0 = ruleSubSelector();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getSimple_selectorRule());
										}
										add(
												current,
												"subSelectors",
												lv_subSelectors_2_0,
												"SubSelector");
										afterParserOrEnumRuleCall();

									}

								}


							}
								break;

							default:
								break loop45;
							}
						} while (true);


					}


				}
					break;
				case 2:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1416:6: ( (lv_subSelectors_3_0= ruleSubSelector ) )+
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1416:6: ( (lv_subSelectors_3_0= ruleSubSelector ) )+
					int cnt46 = 0;
					loop46: do {
						int alt46 = 2;
						int LA46_0 = input.LA(1);

						if ((LA46_0 == RULE_COLON || LA46_0 == RULE_HASHMARK || LA46_0 == 35 || LA46_0 == 41)) {
							alt46 = 1;
						}


						switch (alt46) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1417:1: (lv_subSelectors_3_0= ruleSubSelector )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1417:1: (lv_subSelectors_3_0= ruleSubSelector )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1418:3: lv_subSelectors_3_0= ruleSubSelector
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getSimple_selectorAccess().getSubSelectorsSubSelectorParserRuleCall_1_0());

								}
								pushFollow(FOLLOW_ruleSubSelector_in_rulesimple_selector3017);
								lv_subSelectors_3_0 = ruleSubSelector();

								state._fsp--;
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getSimple_selectorRule());
									}
									add(
											current,
											"subSelectors",
											lv_subSelectors_3_0,
											"SubSelector");
									afterParserOrEnumRuleCall();

								}

							}


						}
							break;

						default:
							if (cnt46 >= 1)
								break loop46;
							if (state.backtracking > 0) {
								state.failed = true;
								return current;
							}
							EarlyExitException eee = new EarlyExitException(46, input);
							throw eee;
						}
						cnt46++;
					} while (true);


				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulesimple_selector"


	// $ANTLR start "entryRuleSubSelector"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1442:1: entryRuleSubSelector returns [EObject current=null] : iv_ruleSubSelector= ruleSubSelector EOF ;
	public final EObject entryRuleSubSelector() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleSubSelector = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1443:2: (iv_ruleSubSelector= ruleSubSelector EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1444:2: iv_ruleSubSelector= ruleSubSelector EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getSubSelectorRule());
				}
				pushFollow(FOLLOW_ruleSubSelector_in_entryRuleSubSelector3054);
				iv_ruleSubSelector = ruleSubSelector();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleSubSelector;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleSubSelector3064);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleSubSelector"


	// $ANTLR start "ruleSubSelector"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1451:1: ruleSubSelector returns [EObject current=null] : (this_IdSelector_0= ruleIdSelector | this_ClassSelector_1=
	// ruleClassSelector | this_AttributeSelector_2= ruleAttributeSelector | this_PseudoClassOrFunc_3= rulePseudoClassOrFunc ) ;
	public final EObject ruleSubSelector() throws RecognitionException {
		EObject current = null;

		EObject this_IdSelector_0 = null;

		EObject this_ClassSelector_1 = null;

		EObject this_AttributeSelector_2 = null;

		EObject this_PseudoClassOrFunc_3 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1454:28: ( (this_IdSelector_0= ruleIdSelector | this_ClassSelector_1= ruleClassSelector |
			// this_AttributeSelector_2= ruleAttributeSelector | this_PseudoClassOrFunc_3= rulePseudoClassOrFunc ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1455:1: (this_IdSelector_0= ruleIdSelector | this_ClassSelector_1= ruleClassSelector | this_AttributeSelector_2=
			// ruleAttributeSelector | this_PseudoClassOrFunc_3= rulePseudoClassOrFunc )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1455:1: (this_IdSelector_0= ruleIdSelector | this_ClassSelector_1= ruleClassSelector |
				// this_AttributeSelector_2= ruleAttributeSelector | this_PseudoClassOrFunc_3= rulePseudoClassOrFunc )
				int alt48 = 4;
				switch (input.LA(1)) {
				case RULE_HASHMARK: {
					alt48 = 1;
				}
					break;
				case 41: {
					alt48 = 2;
				}
					break;
				case 35: {
					alt48 = 3;
				}
					break;
				case RULE_COLON: {
					alt48 = 4;
				}
					break;
				default:
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 48, 0, input);

					throw nvae;
				}

				switch (alt48) {
				case 1:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1456:5: this_IdSelector_0= ruleIdSelector
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getSubSelectorAccess().getIdSelectorParserRuleCall_0());

					}
					pushFollow(FOLLOW_ruleIdSelector_in_ruleSubSelector3111);
					this_IdSelector_0 = ruleIdSelector();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current = this_IdSelector_0;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 2:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1466:5: this_ClassSelector_1= ruleClassSelector
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getSubSelectorAccess().getClassSelectorParserRuleCall_1());

					}
					pushFollow(FOLLOW_ruleClassSelector_in_ruleSubSelector3138);
					this_ClassSelector_1 = ruleClassSelector();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current = this_ClassSelector_1;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 3:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1476:5: this_AttributeSelector_2= ruleAttributeSelector
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getSubSelectorAccess().getAttributeSelectorParserRuleCall_2());

					}
					pushFollow(FOLLOW_ruleAttributeSelector_in_ruleSubSelector3165);
					this_AttributeSelector_2 = ruleAttributeSelector();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current = this_AttributeSelector_2;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 4:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1486:5: this_PseudoClassOrFunc_3= rulePseudoClassOrFunc
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getSubSelectorAccess().getPseudoClassOrFuncParserRuleCall_3());

					}
					pushFollow(FOLLOW_rulePseudoClassOrFunc_in_ruleSubSelector3192);
					this_PseudoClassOrFunc_3 = rulePseudoClassOrFunc();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current = this_PseudoClassOrFunc_3;
						afterParserOrEnumRuleCall();

					}

				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleSubSelector"


	// $ANTLR start "entryRuleAttributeSelector"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1502:1: entryRuleAttributeSelector returns [EObject current=null] : iv_ruleAttributeSelector= ruleAttributeSelector EOF ;
	public final EObject entryRuleAttributeSelector() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleAttributeSelector = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1503:2: (iv_ruleAttributeSelector= ruleAttributeSelector EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1504:2: iv_ruleAttributeSelector= ruleAttributeSelector EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getAttributeSelectorRule());
				}
				pushFollow(FOLLOW_ruleAttributeSelector_in_entryRuleAttributeSelector3227);
				iv_ruleAttributeSelector = ruleAttributeSelector();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleAttributeSelector;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleAttributeSelector3237);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleAttributeSelector"


	// $ANTLR start "ruleAttributeSelector"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1511:1: ruleAttributeSelector returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_name_2_0= ruleIdentifier ) ) ( (
	// ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5= RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH ) ) ) ( ( (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) ) ) )? otherlv_5= ']' ) ;
	public final EObject ruleAttributeSelector() throws RecognitionException {
		EObject current = null;

		Token otherlv_1 = null;
		Token lv_op_3_1 = null;
		Token lv_op_3_2 = null;
		Token lv_op_3_3 = null;
		Token lv_op_3_4 = null;
		Token lv_op_3_5 = null;
		Token lv_op_3_6 = null;
		Token lv_value_4_2 = null;
		Token otherlv_5 = null;
		AntlrDatatypeRuleToken lv_name_2_0 = null;

		AntlrDatatypeRuleToken lv_value_4_1 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1514:28: ( ( () otherlv_1= '[' ( (lv_name_2_0= ruleIdentifier ) ) ( ( ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' |
			// lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5= RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH ) ) ) ( ( (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) ) ) )? otherlv_5= ']' ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1515:1: ( () otherlv_1= '[' ( (lv_name_2_0= ruleIdentifier ) ) ( ( ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' |
			// lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5= RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH ) ) ) ( ( (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) ) ) )? otherlv_5= ']' )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1515:1: ( () otherlv_1= '[' ( (lv_name_2_0= ruleIdentifier ) ) ( ( ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' |
				// lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5= RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH ) ) ) ( ( (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) ) ) )? otherlv_5= ']' )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1515:2: () otherlv_1= '[' ( (lv_name_2_0= ruleIdentifier ) ) ( ( ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' |
				// lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5= RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH ) ) ) ( ( (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) ) ) )? otherlv_5= ']'
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1515:2: ()
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1516:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getAttributeSelectorAccess().getAttributeSelectorAction_0(),
									current);

						}

					}

					otherlv_1 = (Token) match(input, 35, FOLLOW_35_in_ruleAttributeSelector3283);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_1, grammarAccess.getAttributeSelectorAccess().getLeftSquareBracketKeyword_1());

					}
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1525:1: ( (lv_name_2_0= ruleIdentifier ) )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1526:1: (lv_name_2_0= ruleIdentifier )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1526:1: (lv_name_2_0= ruleIdentifier )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1527:3: lv_name_2_0= ruleIdentifier
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getAttributeSelectorAccess().getNameIdentifierParserRuleCall_2_0());

							}
							pushFollow(FOLLOW_ruleIdentifier_in_ruleAttributeSelector3304);
							lv_name_2_0 = ruleIdentifier();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getAttributeSelectorRule());
								}
								set(
										current,
										"name",
										lv_name_2_0,
										"Identifier");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1543:2: ( ( ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5=
					// RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH ) ) ) ( ( (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) ) ) )?
					int alt51 = 2;
					int LA51_0 = input.LA(1);

					if (((LA51_0 >= RULE_INCLUDES && LA51_0 <= RULE_DASHMATCH) || (LA51_0 >= 36 && LA51_0 <= 39))) {
						alt51 = 1;
					}
					switch (alt51) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1543:3: ( ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5=
					// RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH ) ) ) ( ( (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) ) )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1543:3: ( ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5=
						// RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH ) ) )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1544:1: ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5=
						// RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH ) )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1544:1: ( (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5=
							// RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH ) )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1545:1: (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5=
							// RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1545:1: (lv_op_3_1= '^=' | lv_op_3_2= '$=' | lv_op_3_3= '*=' | lv_op_3_4= '=' | lv_op_3_5=
								// RULE_INCLUDES | lv_op_3_6= RULE_DASHMATCH )
								int alt49 = 6;
								switch (input.LA(1)) {
								case 36: {
									alt49 = 1;
								}
									break;
								case 37: {
									alt49 = 2;
								}
									break;
								case 38: {
									alt49 = 3;
								}
									break;
								case 39: {
									alt49 = 4;
								}
									break;
								case RULE_INCLUDES: {
									alt49 = 5;
								}
									break;
								case RULE_DASHMATCH: {
									alt49 = 6;
								}
									break;
								default:
									if (state.backtracking > 0) {
										state.failed = true;
										return current;
									}
									NoViableAltException nvae = new NoViableAltException("", 49, 0, input);

									throw nvae;
								}

								switch (alt49) {
								case 1:
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1546:3: lv_op_3_1= '^='
								{
									lv_op_3_1 = (Token) match(input, 36, FOLLOW_36_in_ruleAttributeSelector3325);
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										newLeafNode(lv_op_3_1, grammarAccess.getAttributeSelectorAccess().getOpCircumflexAccentEqualsSignKeyword_3_0_0_0());

									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElement(grammarAccess.getAttributeSelectorRule());
										}
										setWithLastConsumed(current, "op", lv_op_3_1, null);

									}

								}
									break;
								case 2:
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1558:8: lv_op_3_2= '$='
								{
									lv_op_3_2 = (Token) match(input, 37, FOLLOW_37_in_ruleAttributeSelector3354);
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										newLeafNode(lv_op_3_2, grammarAccess.getAttributeSelectorAccess().getOpDollarSignEqualsSignKeyword_3_0_0_1());

									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElement(grammarAccess.getAttributeSelectorRule());
										}
										setWithLastConsumed(current, "op", lv_op_3_2, null);

									}

								}
									break;
								case 3:
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1570:8: lv_op_3_3= '*='
								{
									lv_op_3_3 = (Token) match(input, 38, FOLLOW_38_in_ruleAttributeSelector3383);
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										newLeafNode(lv_op_3_3, grammarAccess.getAttributeSelectorAccess().getOpAsteriskEqualsSignKeyword_3_0_0_2());

									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElement(grammarAccess.getAttributeSelectorRule());
										}
										setWithLastConsumed(current, "op", lv_op_3_3, null);

									}

								}
									break;
								case 4:
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1582:8: lv_op_3_4= '='
								{
									lv_op_3_4 = (Token) match(input, 39, FOLLOW_39_in_ruleAttributeSelector3412);
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										newLeafNode(lv_op_3_4, grammarAccess.getAttributeSelectorAccess().getOpEqualsSignKeyword_3_0_0_3());

									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElement(grammarAccess.getAttributeSelectorRule());
										}
										setWithLastConsumed(current, "op", lv_op_3_4, null);

									}

								}
									break;
								case 5:
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1594:8: lv_op_3_5= RULE_INCLUDES
								{
									lv_op_3_5 = (Token) match(input, RULE_INCLUDES, FOLLOW_RULE_INCLUDES_in_ruleAttributeSelector3440);
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										newLeafNode(lv_op_3_5, grammarAccess.getAttributeSelectorAccess().getOpINCLUDESTerminalRuleCall_3_0_0_4());

									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElement(grammarAccess.getAttributeSelectorRule());
										}
										setWithLastConsumed(
												current,
												"op",
												lv_op_3_5,
												"INCLUDES");

									}

								}
									break;
								case 6:
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1609:8: lv_op_3_6= RULE_DASHMATCH
								{
									lv_op_3_6 = (Token) match(input, RULE_DASHMATCH, FOLLOW_RULE_DASHMATCH_in_ruleAttributeSelector3460);
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										newLeafNode(lv_op_3_6, grammarAccess.getAttributeSelectorAccess().getOpDASHMATCHTerminalRuleCall_3_0_0_5());

									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElement(grammarAccess.getAttributeSelectorRule());
										}
										setWithLastConsumed(
												current,
												"op",
												lv_op_3_6,
												"DASHMATCH");

									}

								}
									break;

								}


							}


						}

						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1627:2: ( ( (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) ) )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1628:1: ( (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1628:1: ( (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING ) )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1629:1: (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1629:1: (lv_value_4_1= ruleIdentifier | lv_value_4_2= RULE_CSSSTRING )
								int alt50 = 2;
								int LA50_0 = input.LA(1);

								if (((LA50_0 >= RULE_DASH && LA50_0 <= RULE_ONE_NON_HEX_LETTER) || (LA50_0 >= 56 && LA50_0 <= 59))) {
									alt50 = 1;
								} else if ((LA50_0 == RULE_CSSSTRING)) {
									alt50 = 2;
								} else {
									if (state.backtracking > 0) {
										state.failed = true;
										return current;
									}
									NoViableAltException nvae = new NoViableAltException("", 50, 0, input);

									throw nvae;
								}
								switch (alt50) {
								case 1:
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1630:3: lv_value_4_1= ruleIdentifier
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getAttributeSelectorAccess().getValueIdentifierParserRuleCall_3_1_0_0());

									}
									pushFollow(FOLLOW_ruleIdentifier_in_ruleAttributeSelector3491);
									lv_value_4_1 = ruleIdentifier();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getAttributeSelectorRule());
										}
										set(
												current,
												"value",
												lv_value_4_1,
												"Identifier");
										afterParserOrEnumRuleCall();

									}

								}
									break;
								case 2:
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1645:8: lv_value_4_2= RULE_CSSSTRING
								{
									lv_value_4_2 = (Token) match(input, RULE_CSSSTRING, FOLLOW_RULE_CSSSTRING_in_ruleAttributeSelector3506);
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										newLeafNode(lv_value_4_2, grammarAccess.getAttributeSelectorAccess().getValueCSSSTRINGTerminalRuleCall_3_1_0_1());

									}
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElement(grammarAccess.getAttributeSelectorRule());
										}
										setWithLastConsumed(
												current,
												"value",
												lv_value_4_2,
												"CSSSTRING");

									}

								}
									break;

								}


							}


						}


					}
						break;

					}

					otherlv_5 = (Token) match(input, 40, FOLLOW_40_in_ruleAttributeSelector3528);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_5, grammarAccess.getAttributeSelectorAccess().getRightSquareBracketKeyword_4());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleAttributeSelector"


	// $ANTLR start "entryRuleClassSelector"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1675:1: entryRuleClassSelector returns [EObject current=null] : iv_ruleClassSelector= ruleClassSelector EOF ;
	public final EObject entryRuleClassSelector() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleClassSelector = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1676:2: (iv_ruleClassSelector= ruleClassSelector EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1677:2: iv_ruleClassSelector= ruleClassSelector EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getClassSelectorRule());
				}
				pushFollow(FOLLOW_ruleClassSelector_in_entryRuleClassSelector3564);
				iv_ruleClassSelector = ruleClassSelector();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleClassSelector;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleClassSelector3574);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleClassSelector"


	// $ANTLR start "ruleClassSelector"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1684:1: ruleClassSelector returns [EObject current=null] : ( () otherlv_1= '.' ( (lv_name_2_0= ruleIdentifier ) ) ) ;
	public final EObject ruleClassSelector() throws RecognitionException {
		EObject current = null;

		Token otherlv_1 = null;
		AntlrDatatypeRuleToken lv_name_2_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1687:28: ( ( () otherlv_1= '.' ( (lv_name_2_0= ruleIdentifier ) ) ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1688:1: ( () otherlv_1= '.' ( (lv_name_2_0= ruleIdentifier ) ) )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1688:1: ( () otherlv_1= '.' ( (lv_name_2_0= ruleIdentifier ) ) )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1688:2: () otherlv_1= '.' ( (lv_name_2_0= ruleIdentifier ) )
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1688:2: ()
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1689:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getClassSelectorAccess().getClassSelectorAction_0(),
									current);

						}

					}

					otherlv_1 = (Token) match(input, 41, FOLLOW_41_in_ruleClassSelector3620);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_1, grammarAccess.getClassSelectorAccess().getFullStopKeyword_1());

					}
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1698:1: ( (lv_name_2_0= ruleIdentifier ) )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1699:1: (lv_name_2_0= ruleIdentifier )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1699:1: (lv_name_2_0= ruleIdentifier )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1700:3: lv_name_2_0= ruleIdentifier
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getClassSelectorAccess().getNameIdentifierParserRuleCall_2_0());

							}
							pushFollow(FOLLOW_ruleIdentifier_in_ruleClassSelector3641);
							lv_name_2_0 = ruleIdentifier();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getClassSelectorRule());
								}
								set(
										current,
										"name",
										lv_name_2_0,
										"Identifier");
								afterParserOrEnumRuleCall();

							}

						}


					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleClassSelector"


	// $ANTLR start "entryRuleElementSelector"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1724:1: entryRuleElementSelector returns [EObject current=null] : iv_ruleElementSelector= ruleElementSelector EOF ;
	public final EObject entryRuleElementSelector() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleElementSelector = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1725:2: (iv_ruleElementSelector= ruleElementSelector EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1726:2: iv_ruleElementSelector= ruleElementSelector EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getElementSelectorRule());
				}
				pushFollow(FOLLOW_ruleElementSelector_in_entryRuleElementSelector3677);
				iv_ruleElementSelector = ruleElementSelector();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleElementSelector;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleElementSelector3687);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleElementSelector"


	// $ANTLR start "ruleElementSelector"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1733:1: ruleElementSelector returns [EObject current=null] : ( () ( (lv_name_1_0= ruleIdentifier ) ) ) ;
	public final EObject ruleElementSelector() throws RecognitionException {
		EObject current = null;

		AntlrDatatypeRuleToken lv_name_1_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1736:28: ( ( () ( (lv_name_1_0= ruleIdentifier ) ) ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1737:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1737:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1737:2: () ( (lv_name_1_0= ruleIdentifier ) )
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1737:2: ()
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1738:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getElementSelectorAccess().getElementSelectorAction_0(),
									current);

						}

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1743:2: ( (lv_name_1_0= ruleIdentifier ) )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1744:1: (lv_name_1_0= ruleIdentifier )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1744:1: (lv_name_1_0= ruleIdentifier )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1745:3: lv_name_1_0= ruleIdentifier
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getElementSelectorAccess().getNameIdentifierParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_ruleIdentifier_in_ruleElementSelector3742);
							lv_name_1_0 = ruleIdentifier();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getElementSelectorRule());
								}
								set(
										current,
										"name",
										lv_name_1_0,
										"Identifier");
								afterParserOrEnumRuleCall();

							}

						}


					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleElementSelector"


	// $ANTLR start "entryRuleUniversalSelector"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1769:1: entryRuleUniversalSelector returns [EObject current=null] : iv_ruleUniversalSelector= ruleUniversalSelector EOF ;
	public final EObject entryRuleUniversalSelector() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleUniversalSelector = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1770:2: (iv_ruleUniversalSelector= ruleUniversalSelector EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1771:2: iv_ruleUniversalSelector= ruleUniversalSelector EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getUniversalSelectorRule());
				}
				pushFollow(FOLLOW_ruleUniversalSelector_in_entryRuleUniversalSelector3778);
				iv_ruleUniversalSelector = ruleUniversalSelector();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleUniversalSelector;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleUniversalSelector3788);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleUniversalSelector"


	// $ANTLR start "ruleUniversalSelector"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1778:1: ruleUniversalSelector returns [EObject current=null] : ( () ( (lv_namespace_1_0= rulecss_namespace_prefix ) )?
	// otherlv_2= '*' ) ;
	public final EObject ruleUniversalSelector() throws RecognitionException {
		EObject current = null;

		Token otherlv_2 = null;
		AntlrDatatypeRuleToken lv_namespace_1_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1781:28: ( ( () ( (lv_namespace_1_0= rulecss_namespace_prefix ) )? otherlv_2= '*' ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1782:1: ( () ( (lv_namespace_1_0= rulecss_namespace_prefix ) )? otherlv_2= '*' )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1782:1: ( () ( (lv_namespace_1_0= rulecss_namespace_prefix ) )? otherlv_2= '*' )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1782:2: () ( (lv_namespace_1_0= rulecss_namespace_prefix ) )? otherlv_2= '*'
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1782:2: ()
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1783:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getUniversalSelectorAccess().getUniversalSelectorAction_0(),
									current);

						}

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1788:2: ( (lv_namespace_1_0= rulecss_namespace_prefix ) )?
					int alt52 = 2;
					int LA52_0 = input.LA(1);

					if (((LA52_0 >= RULE_DASH && LA52_0 <= RULE_ONE_NON_HEX_LETTER) || LA52_0 == 43 || (LA52_0 >= 56 && LA52_0 <= 59))) {
						alt52 = 1;
					} else if ((LA52_0 == 42)) {
						int LA52_2 = input.LA(2);

						if ((LA52_2 == 43)) {
							alt52 = 1;
						}
					}
					switch (alt52) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1789:1: (lv_namespace_1_0= rulecss_namespace_prefix )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1789:1: (lv_namespace_1_0= rulecss_namespace_prefix )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1790:3: lv_namespace_1_0= rulecss_namespace_prefix
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getUniversalSelectorAccess().getNamespaceCss_namespace_prefixParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_rulecss_namespace_prefix_in_ruleUniversalSelector3843);
							lv_namespace_1_0 = rulecss_namespace_prefix();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getUniversalSelectorRule());
								}
								set(
										current,
										"namespace",
										lv_namespace_1_0,
										"css_namespace_prefix");
								afterParserOrEnumRuleCall();

							}

						}


					}
						break;

					}

					otherlv_2 = (Token) match(input, 42, FOLLOW_42_in_ruleUniversalSelector3856);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_2, grammarAccess.getUniversalSelectorAccess().getAsteriskKeyword_2());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleUniversalSelector"


	// $ANTLR start "entryRuleIdSelector"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1818:1: entryRuleIdSelector returns [EObject current=null] : iv_ruleIdSelector= ruleIdSelector EOF ;
	public final EObject entryRuleIdSelector() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleIdSelector = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1819:2: (iv_ruleIdSelector= ruleIdSelector EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1820:2: iv_ruleIdSelector= ruleIdSelector EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getIdSelectorRule());
				}
				pushFollow(FOLLOW_ruleIdSelector_in_entryRuleIdSelector3892);
				iv_ruleIdSelector = ruleIdSelector();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleIdSelector;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleIdSelector3902);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleIdSelector"


	// $ANTLR start "ruleIdSelector"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1827:1: ruleIdSelector returns [EObject current=null] : ( () this_HASHMARK_1= RULE_HASHMARK ( (lv_name_2_0= ruleIdentifier
	// ) ) ) ;
	public final EObject ruleIdSelector() throws RecognitionException {
		EObject current = null;

		Token this_HASHMARK_1 = null;
		AntlrDatatypeRuleToken lv_name_2_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1830:28: ( ( () this_HASHMARK_1= RULE_HASHMARK ( (lv_name_2_0= ruleIdentifier ) ) ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1831:1: ( () this_HASHMARK_1= RULE_HASHMARK ( (lv_name_2_0= ruleIdentifier ) ) )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1831:1: ( () this_HASHMARK_1= RULE_HASHMARK ( (lv_name_2_0= ruleIdentifier ) ) )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1831:2: () this_HASHMARK_1= RULE_HASHMARK ( (lv_name_2_0= ruleIdentifier ) )
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1831:2: ()
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1832:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getIdSelectorAccess().getIdSelectorAction_0(),
									current);

						}

					}

					this_HASHMARK_1 = (Token) match(input, RULE_HASHMARK, FOLLOW_RULE_HASHMARK_in_ruleIdSelector3947);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(this_HASHMARK_1, grammarAccess.getIdSelectorAccess().getHASHMARKTerminalRuleCall_1());

					}
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1841:1: ( (lv_name_2_0= ruleIdentifier ) )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1842:1: (lv_name_2_0= ruleIdentifier )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1842:1: (lv_name_2_0= ruleIdentifier )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1843:3: lv_name_2_0= ruleIdentifier
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getIdSelectorAccess().getNameIdentifierParserRuleCall_2_0());

							}
							pushFollow(FOLLOW_ruleIdentifier_in_ruleIdSelector3967);
							lv_name_2_0 = ruleIdentifier();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getIdSelectorRule());
								}
								set(
										current,
										"name",
										lv_name_2_0,
										"Identifier");
								afterParserOrEnumRuleCall();

							}

						}


					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleIdSelector"


	// $ANTLR start "entryRulecss_namespace_prefix"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1867:1: entryRulecss_namespace_prefix returns [String current=null] : iv_rulecss_namespace_prefix=
	// rulecss_namespace_prefix EOF ;
	public final String entryRulecss_namespace_prefix() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_rulecss_namespace_prefix = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1868:2: (iv_rulecss_namespace_prefix= rulecss_namespace_prefix EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1869:2: iv_rulecss_namespace_prefix= rulecss_namespace_prefix EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getCss_namespace_prefixRule());
				}
				pushFollow(FOLLOW_rulecss_namespace_prefix_in_entryRulecss_namespace_prefix4004);
				iv_rulecss_namespace_prefix = rulecss_namespace_prefix();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_rulecss_namespace_prefix.getText();
				}
				match(input, EOF, FOLLOW_EOF_in_entryRulecss_namespace_prefix4015);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulecss_namespace_prefix"


	// $ANTLR start "rulecss_namespace_prefix"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1876:1: rulecss_namespace_prefix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (
	// (this_Identifier_0= ruleIdentifier | kw= '*' )? kw= '|' ) ;
	public final AntlrDatatypeRuleToken rulecss_namespace_prefix() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token kw = null;
		AntlrDatatypeRuleToken this_Identifier_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1879:28: ( ( (this_Identifier_0= ruleIdentifier | kw= '*' )? kw= '|' ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1880:1: ( (this_Identifier_0= ruleIdentifier | kw= '*' )? kw= '|' )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1880:1: ( (this_Identifier_0= ruleIdentifier | kw= '*' )? kw= '|' )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1880:2: (this_Identifier_0= ruleIdentifier | kw= '*' )? kw= '|'
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1880:2: (this_Identifier_0= ruleIdentifier | kw= '*' )?
					int alt53 = 3;
					int LA53_0 = input.LA(1);

					if (((LA53_0 >= RULE_DASH && LA53_0 <= RULE_ONE_NON_HEX_LETTER) || (LA53_0 >= 56 && LA53_0 <= 59))) {
						alt53 = 1;
					} else if ((LA53_0 == 42)) {
						alt53 = 2;
					}
					switch (alt53) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1881:5: this_Identifier_0= ruleIdentifier
					{
						if (state.backtracking == 0) {

							newCompositeNode(grammarAccess.getCss_namespace_prefixAccess().getIdentifierParserRuleCall_0_0());

						}
						pushFollow(FOLLOW_ruleIdentifier_in_rulecss_namespace_prefix4063);
						this_Identifier_0 = ruleIdentifier();

						state._fsp--;
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							current.merge(this_Identifier_0);

						}
						if (state.backtracking == 0) {

							afterParserOrEnumRuleCall();

						}

					}
						break;
					case 2:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1893:2: kw= '*'
					{
						kw = (Token) match(input, 42, FOLLOW_42_in_rulecss_namespace_prefix4087);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getCss_namespace_prefixAccess().getAsteriskKeyword_0_1());

						}

					}
						break;

					}

					kw = (Token) match(input, 43, FOLLOW_43_in_rulecss_namespace_prefix4102);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getCss_namespace_prefixAccess().getVerticalLineKeyword_1());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulecss_namespace_prefix"


	// $ANTLR start "entryRulecss_declaration"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1912:1: entryRulecss_declaration returns [EObject current=null] : iv_rulecss_declaration= rulecss_declaration EOF ;
	public final EObject entryRulecss_declaration() throws RecognitionException {
		EObject current = null;

		EObject iv_rulecss_declaration = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1913:2: (iv_rulecss_declaration= rulecss_declaration EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1914:2: iv_rulecss_declaration= rulecss_declaration EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getCss_declarationRule());
				}
				pushFollow(FOLLOW_rulecss_declaration_in_entryRulecss_declaration4142);
				iv_rulecss_declaration = rulecss_declaration();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_rulecss_declaration;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRulecss_declaration4152);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulecss_declaration"


	// $ANTLR start "rulecss_declaration"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1921:1: rulecss_declaration returns [EObject current=null] : ( (this_WS_0= RULE_WS )* ( (lv_property_1_0= rulecss_property
	// ) ) (this_WS_2= RULE_WS )* this_COLON_3= RULE_COLON ( (lv_valueTokens_4_0= ruleCssTok ) )+ ( (lv_important_5_0= RULE_IMPORTANT_SYM ) )? ) ;
	public final EObject rulecss_declaration() throws RecognitionException {
		EObject current = null;

		Token this_WS_0 = null;
		Token this_WS_2 = null;
		Token this_COLON_3 = null;
		Token lv_important_5_0 = null;
		EObject lv_property_1_0 = null;

		EObject lv_valueTokens_4_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1924:28: ( ( (this_WS_0= RULE_WS )* ( (lv_property_1_0= rulecss_property ) ) (this_WS_2= RULE_WS )* this_COLON_3=
			// RULE_COLON ( (lv_valueTokens_4_0= ruleCssTok ) )+ ( (lv_important_5_0= RULE_IMPORTANT_SYM ) )? ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1925:1: ( (this_WS_0= RULE_WS )* ( (lv_property_1_0= rulecss_property ) ) (this_WS_2= RULE_WS )* this_COLON_3=
			// RULE_COLON ( (lv_valueTokens_4_0= ruleCssTok ) )+ ( (lv_important_5_0= RULE_IMPORTANT_SYM ) )? )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1925:1: ( (this_WS_0= RULE_WS )* ( (lv_property_1_0= rulecss_property ) ) (this_WS_2= RULE_WS )* this_COLON_3=
				// RULE_COLON ( (lv_valueTokens_4_0= ruleCssTok ) )+ ( (lv_important_5_0= RULE_IMPORTANT_SYM ) )? )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1925:2: (this_WS_0= RULE_WS )* ( (lv_property_1_0= rulecss_property ) ) (this_WS_2= RULE_WS )* this_COLON_3=
				// RULE_COLON ( (lv_valueTokens_4_0= ruleCssTok ) )+ ( (lv_important_5_0= RULE_IMPORTANT_SYM ) )?
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1925:2: (this_WS_0= RULE_WS )*
					loop54: do {
						int alt54 = 2;
						int LA54_0 = input.LA(1);

						if ((LA54_0 == RULE_WS)) {
							alt54 = 1;
						}


						switch (alt54) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1925:3: this_WS_0= RULE_WS
						{
							this_WS_0 = (Token) match(input, RULE_WS, FOLLOW_RULE_WS_in_rulecss_declaration4189);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								newLeafNode(this_WS_0, grammarAccess.getCss_declarationAccess().getWSTerminalRuleCall_0());

							}

						}
							break;

						default:
							break loop54;
						}
					} while (true);

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1929:3: ( (lv_property_1_0= rulecss_property ) )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1930:1: (lv_property_1_0= rulecss_property )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1930:1: (lv_property_1_0= rulecss_property )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1931:3: lv_property_1_0= rulecss_property
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getCss_declarationAccess().getPropertyCss_propertyParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_rulecss_property_in_rulecss_declaration4211);
							lv_property_1_0 = rulecss_property();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getCss_declarationRule());
								}
								set(
										current,
										"property",
										lv_property_1_0,
										"css_property");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1947:2: (this_WS_2= RULE_WS )*
					loop55: do {
						int alt55 = 2;
						int LA55_0 = input.LA(1);

						if ((LA55_0 == RULE_WS)) {
							alt55 = 1;
						}


						switch (alt55) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1947:3: this_WS_2= RULE_WS
						{
							this_WS_2 = (Token) match(input, RULE_WS, FOLLOW_RULE_WS_in_rulecss_declaration4223);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								newLeafNode(this_WS_2, grammarAccess.getCss_declarationAccess().getWSTerminalRuleCall_2());

							}

						}
							break;

						default:
							break loop55;
						}
					} while (true);

					this_COLON_3 = (Token) match(input, RULE_COLON, FOLLOW_RULE_COLON_in_rulecss_declaration4235);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(this_COLON_3, grammarAccess.getCss_declarationAccess().getCOLONTerminalRuleCall_3());

					}
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1955:1: ( (lv_valueTokens_4_0= ruleCssTok ) )+
					int cnt56 = 0;
					loop56: do {
						int alt56 = 2;
						int LA56_0 = input.LA(1);

						if ((LA56_0 == RULE_CSSSTRING || (LA56_0 >= RULE_COMMA && LA56_0 <= RULE_WS) || LA56_0 == RULE_HASHMARK || (LA56_0 >= RULE_PLUS && LA56_0 <= RULE_ONE_INT) || LA56_0 == 41 || LA56_0 == 49 || (LA56_0 >= 56 && LA56_0 <= 59))) {
							alt56 = 1;
						}


						switch (alt56) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1956:1: (lv_valueTokens_4_0= ruleCssTok )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1956:1: (lv_valueTokens_4_0= ruleCssTok )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1957:3: lv_valueTokens_4_0= ruleCssTok
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getCss_declarationAccess().getValueTokensCssTokParserRuleCall_4_0());

								}
								pushFollow(FOLLOW_ruleCssTok_in_rulecss_declaration4255);
								lv_valueTokens_4_0 = ruleCssTok();

								state._fsp--;
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getCss_declarationRule());
									}
									add(
											current,
											"valueTokens",
											lv_valueTokens_4_0,
											"CssTok");
									afterParserOrEnumRuleCall();

								}

							}


						}
							break;

						default:
							if (cnt56 >= 1)
								break loop56;
							if (state.backtracking > 0) {
								state.failed = true;
								return current;
							}
							EarlyExitException eee = new EarlyExitException(56, input);
							throw eee;
						}
						cnt56++;
					} while (true);

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1973:3: ( (lv_important_5_0= RULE_IMPORTANT_SYM ) )?
					int alt57 = 2;
					int LA57_0 = input.LA(1);

					if ((LA57_0 == RULE_IMPORTANT_SYM)) {
						alt57 = 1;
					}
					switch (alt57) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1974:1: (lv_important_5_0= RULE_IMPORTANT_SYM )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1974:1: (lv_important_5_0= RULE_IMPORTANT_SYM )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1975:3: lv_important_5_0= RULE_IMPORTANT_SYM
						{
							lv_important_5_0 = (Token) match(input, RULE_IMPORTANT_SYM, FOLLOW_RULE_IMPORTANT_SYM_in_rulecss_declaration4273);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								newLeafNode(lv_important_5_0, grammarAccess.getCss_declarationAccess().getImportantIMPORTANT_SYMTerminalRuleCall_5_0());

							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElement(grammarAccess.getCss_declarationRule());
								}
								setWithLastConsumed(
										current,
										"important",
										true,
										"IMPORTANT_SYM");

							}

						}


					}
						break;

					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulecss_declaration"


	// $ANTLR start "entryRulecss_property"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1999:1: entryRulecss_property returns [EObject current=null] : iv_rulecss_property= rulecss_property EOF ;
	public final EObject entryRulecss_property() throws RecognitionException {
		EObject current = null;

		EObject iv_rulecss_property = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2000:2: (iv_rulecss_property= rulecss_property EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2001:2: iv_rulecss_property= rulecss_property EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getCss_propertyRule());
				}
				pushFollow(FOLLOW_rulecss_property_in_entryRulecss_property4315);
				iv_rulecss_property = rulecss_property();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_rulecss_property;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRulecss_property4325);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulecss_property"


	// $ANTLR start "rulecss_property"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2008:1: rulecss_property returns [EObject current=null] : ( () ( (lv_name_1_0= ruleValidPropertyIdent ) ) ) ;
	public final EObject rulecss_property() throws RecognitionException {
		EObject current = null;

		AntlrDatatypeRuleToken lv_name_1_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2011:28: ( ( () ( (lv_name_1_0= ruleValidPropertyIdent ) ) ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2012:1: ( () ( (lv_name_1_0= ruleValidPropertyIdent ) ) )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2012:1: ( () ( (lv_name_1_0= ruleValidPropertyIdent ) ) )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2012:2: () ( (lv_name_1_0= ruleValidPropertyIdent ) )
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2012:2: ()
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2013:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getCss_propertyAccess().getCss_propertyAction_0(),
									current);

						}

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2018:2: ( (lv_name_1_0= ruleValidPropertyIdent ) )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2019:1: (lv_name_1_0= ruleValidPropertyIdent )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2019:1: (lv_name_1_0= ruleValidPropertyIdent )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2020:3: lv_name_1_0= ruleValidPropertyIdent
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getCss_propertyAccess().getNameValidPropertyIdentParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_ruleValidPropertyIdent_in_rulecss_property4380);
							lv_name_1_0 = ruleValidPropertyIdent();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getCss_propertyRule());
								}
								set(
										current,
										"name",
										lv_name_1_0,
										"ValidPropertyIdent");
								afterParserOrEnumRuleCall();

							}

						}


					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulecss_property"


	// $ANTLR start "entryRuleValidPropertyIdent"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2044:1: entryRuleValidPropertyIdent returns [String current=null] : iv_ruleValidPropertyIdent= ruleValidPropertyIdent EOF
	// ;
	public final String entryRuleValidPropertyIdent() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleValidPropertyIdent = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2045:2: (iv_ruleValidPropertyIdent= ruleValidPropertyIdent EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2046:2: iv_ruleValidPropertyIdent= ruleValidPropertyIdent EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getValidPropertyIdentRule());
				}
				pushFollow(FOLLOW_ruleValidPropertyIdent_in_entryRuleValidPropertyIdent4417);
				iv_ruleValidPropertyIdent = ruleValidPropertyIdent();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleValidPropertyIdent.getText();
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleValidPropertyIdent4428);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleValidPropertyIdent"


	// $ANTLR start "ruleValidPropertyIdent"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2053:1: ruleValidPropertyIdent returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0=
	// ruleIdentifier ;
	public final AntlrDatatypeRuleToken ruleValidPropertyIdent() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		AntlrDatatypeRuleToken this_Identifier_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2056:28: (this_Identifier_0= ruleIdentifier )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2058:5: this_Identifier_0= ruleIdentifier
			{
				if (state.backtracking == 0) {

					newCompositeNode(grammarAccess.getValidPropertyIdentAccess().getIdentifierParserRuleCall());

				}
				pushFollow(FOLLOW_ruleIdentifier_in_ruleValidPropertyIdent4474);
				this_Identifier_0 = ruleIdentifier();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {

					current.merge(this_Identifier_0);

				}
				if (state.backtracking == 0) {

					afterParserOrEnumRuleCall();

				}

			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleValidPropertyIdent"


	// $ANTLR start "entryRulePseudoClassOrFunc"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2076:1: entryRulePseudoClassOrFunc returns [EObject current=null] : iv_rulePseudoClassOrFunc= rulePseudoClassOrFunc EOF ;
	public final EObject entryRulePseudoClassOrFunc() throws RecognitionException {
		EObject current = null;

		EObject iv_rulePseudoClassOrFunc = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2077:2: (iv_rulePseudoClassOrFunc= rulePseudoClassOrFunc EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2078:2: iv_rulePseudoClassOrFunc= rulePseudoClassOrFunc EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getPseudoClassOrFuncRule());
				}
				pushFollow(FOLLOW_rulePseudoClassOrFunc_in_entryRulePseudoClassOrFunc4518);
				iv_rulePseudoClassOrFunc = rulePseudoClassOrFunc();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_rulePseudoClassOrFunc;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRulePseudoClassOrFunc4528);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulePseudoClassOrFunc"


	// $ANTLR start "rulePseudoClassOrFunc"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2085:1: rulePseudoClassOrFunc returns [EObject current=null] : (this_PseudoClass_0= rulePseudoClass |
	// this_PseudoClassFunction_1= rulePseudoClassFunction ) ;
	public final EObject rulePseudoClassOrFunc() throws RecognitionException {
		EObject current = null;

		EObject this_PseudoClass_0 = null;

		EObject this_PseudoClassFunction_1 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2088:28: ( (this_PseudoClass_0= rulePseudoClass | this_PseudoClassFunction_1= rulePseudoClassFunction ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2089:1: (this_PseudoClass_0= rulePseudoClass | this_PseudoClassFunction_1= rulePseudoClassFunction )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2089:1: (this_PseudoClass_0= rulePseudoClass | this_PseudoClassFunction_1= rulePseudoClassFunction )
				int alt58 = 2;
				alt58 = dfa58.predict(input);
				switch (alt58) {
				case 1:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2090:5: this_PseudoClass_0= rulePseudoClass
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getPseudoClassOrFuncAccess().getPseudoClassParserRuleCall_0());

					}
					pushFollow(FOLLOW_rulePseudoClass_in_rulePseudoClassOrFunc4575);
					this_PseudoClass_0 = rulePseudoClass();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current = this_PseudoClass_0;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 2:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2100:5: this_PseudoClassFunction_1= rulePseudoClassFunction
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getPseudoClassOrFuncAccess().getPseudoClassFunctionParserRuleCall_1());

					}
					pushFollow(FOLLOW_rulePseudoClassFunction_in_rulePseudoClassOrFunc4602);
					this_PseudoClassFunction_1 = rulePseudoClassFunction();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current = this_PseudoClassFunction_1;
						afterParserOrEnumRuleCall();

					}

				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulePseudoClassOrFunc"


	// $ANTLR start "entryRulePseudoClass"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2116:1: entryRulePseudoClass returns [EObject current=null] : iv_rulePseudoClass= rulePseudoClass EOF ;
	public final EObject entryRulePseudoClass() throws RecognitionException {
		EObject current = null;

		EObject iv_rulePseudoClass = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2117:2: (iv_rulePseudoClass= rulePseudoClass EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2118:2: iv_rulePseudoClass= rulePseudoClass EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getPseudoClassRule());
				}
				pushFollow(FOLLOW_rulePseudoClass_in_entryRulePseudoClass4637);
				iv_rulePseudoClass = rulePseudoClass();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_rulePseudoClass;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRulePseudoClass4647);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulePseudoClass"


	// $ANTLR start "rulePseudoClass"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2125:1: rulePseudoClass returns [EObject current=null] : (this_COLON_0= RULE_COLON (this_COLON_1= RULE_COLON )?
	// this_PseudoClassName_2= rulePseudoClassName ) ;
	public final EObject rulePseudoClass() throws RecognitionException {
		EObject current = null;

		Token this_COLON_0 = null;
		Token this_COLON_1 = null;
		EObject this_PseudoClassName_2 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2128:28: ( (this_COLON_0= RULE_COLON (this_COLON_1= RULE_COLON )? this_PseudoClassName_2= rulePseudoClassName ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2129:1: (this_COLON_0= RULE_COLON (this_COLON_1= RULE_COLON )? this_PseudoClassName_2= rulePseudoClassName )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2129:1: (this_COLON_0= RULE_COLON (this_COLON_1= RULE_COLON )? this_PseudoClassName_2= rulePseudoClassName )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2129:2: this_COLON_0= RULE_COLON (this_COLON_1= RULE_COLON )? this_PseudoClassName_2= rulePseudoClassName
				{
					this_COLON_0 = (Token) match(input, RULE_COLON, FOLLOW_RULE_COLON_in_rulePseudoClass4683);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(this_COLON_0, grammarAccess.getPseudoClassAccess().getCOLONTerminalRuleCall_0());

					}
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2133:1: (this_COLON_1= RULE_COLON )?
					int alt59 = 2;
					int LA59_0 = input.LA(1);

					if ((LA59_0 == RULE_COLON)) {
						alt59 = 1;
					}
					switch (alt59) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2133:2: this_COLON_1= RULE_COLON
					{
						this_COLON_1 = (Token) match(input, RULE_COLON, FOLLOW_RULE_COLON_in_rulePseudoClass4694);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							newLeafNode(this_COLON_1, grammarAccess.getPseudoClassAccess().getCOLONTerminalRuleCall_1());

						}

					}
						break;

					}

					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getPseudoClassAccess().getPseudoClassNameParserRuleCall_2());

					}
					pushFollow(FOLLOW_rulePseudoClassName_in_rulePseudoClass4717);
					this_PseudoClassName_2 = rulePseudoClassName();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current = this_PseudoClassName_2;
						afterParserOrEnumRuleCall();

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulePseudoClass"


	// $ANTLR start "entryRulePseudoClassName"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2154:1: entryRulePseudoClassName returns [EObject current=null] : iv_rulePseudoClassName= rulePseudoClassName EOF ;
	public final EObject entryRulePseudoClassName() throws RecognitionException {
		EObject current = null;

		EObject iv_rulePseudoClassName = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2155:2: (iv_rulePseudoClassName= rulePseudoClassName EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2156:2: iv_rulePseudoClassName= rulePseudoClassName EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getPseudoClassNameRule());
				}
				pushFollow(FOLLOW_rulePseudoClassName_in_entryRulePseudoClassName4752);
				iv_rulePseudoClassName = rulePseudoClassName();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_rulePseudoClassName;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRulePseudoClassName4762);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulePseudoClassName"


	// $ANTLR start "rulePseudoClassName"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2163:1: rulePseudoClassName returns [EObject current=null] : ( (lv_name_0_0= ruleIdentifier ) ) ;
	public final EObject rulePseudoClassName() throws RecognitionException {
		EObject current = null;

		AntlrDatatypeRuleToken lv_name_0_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2166:28: ( ( (lv_name_0_0= ruleIdentifier ) ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2167:1: ( (lv_name_0_0= ruleIdentifier ) )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2167:1: ( (lv_name_0_0= ruleIdentifier ) )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2168:1: (lv_name_0_0= ruleIdentifier )
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2168:1: (lv_name_0_0= ruleIdentifier )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2169:3: lv_name_0_0= ruleIdentifier
					{
						if (state.backtracking == 0) {

							newCompositeNode(grammarAccess.getPseudoClassNameAccess().getNameIdentifierParserRuleCall_0());

						}
						pushFollow(FOLLOW_ruleIdentifier_in_rulePseudoClassName4807);
						lv_name_0_0 = ruleIdentifier();

						state._fsp--;
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							if (current == null) {
								current = createModelElementForParent(grammarAccess.getPseudoClassNameRule());
							}
							set(
									current,
									"name",
									lv_name_0_0,
									"Identifier");
							afterParserOrEnumRuleCall();

						}

					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulePseudoClassName"


	// $ANTLR start "entryRulePseudoClassFunction"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2193:1: entryRulePseudoClassFunction returns [EObject current=null] : iv_rulePseudoClassFunction= rulePseudoClassFunction
	// EOF ;
	public final EObject entryRulePseudoClassFunction() throws RecognitionException {
		EObject current = null;

		EObject iv_rulePseudoClassFunction = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2194:2: (iv_rulePseudoClassFunction= rulePseudoClassFunction EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2195:2: iv_rulePseudoClassFunction= rulePseudoClassFunction EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getPseudoClassFunctionRule());
				}
				pushFollow(FOLLOW_rulePseudoClassFunction_in_entryRulePseudoClassFunction4842);
				iv_rulePseudoClassFunction = rulePseudoClassFunction();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_rulePseudoClassFunction;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRulePseudoClassFunction4852);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulePseudoClassFunction"


	// $ANTLR start "rulePseudoClassFunction"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2202:1: rulePseudoClassFunction returns [EObject current=null] : ( ( ( (lv_not_0_0= ruleNotFunctionCall ) ) (
	// (lv_paramSelector_1_0= ruleSimpleSelectorForNegation ) ) otherlv_2= ')' ) | (this_COLON_3= RULE_COLON ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_params_6_0= ruleCssTok ) )* otherlv_7= ')' ) ) ;
	public final EObject rulePseudoClassFunction() throws RecognitionException {
		EObject current = null;

		Token otherlv_2 = null;
		Token this_COLON_3 = null;
		Token otherlv_5 = null;
		Token otherlv_7 = null;
		AntlrDatatypeRuleToken lv_not_0_0 = null;

		EObject lv_paramSelector_1_0 = null;

		AntlrDatatypeRuleToken lv_name_4_0 = null;

		EObject lv_params_6_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2205:28: ( ( ( ( (lv_not_0_0= ruleNotFunctionCall ) ) ( (lv_paramSelector_1_0= ruleSimpleSelectorForNegation ) )
			// otherlv_2= ')' ) | (this_COLON_3= RULE_COLON ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_params_6_0= ruleCssTok ) )* otherlv_7= ')' ) ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2206:1: ( ( ( (lv_not_0_0= ruleNotFunctionCall ) ) ( (lv_paramSelector_1_0= ruleSimpleSelectorForNegation ) )
			// otherlv_2= ')' ) | (this_COLON_3= RULE_COLON ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_params_6_0= ruleCssTok ) )* otherlv_7= ')' ) )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2206:1: ( ( ( (lv_not_0_0= ruleNotFunctionCall ) ) ( (lv_paramSelector_1_0= ruleSimpleSelectorForNegation ) )
				// otherlv_2= ')' ) | (this_COLON_3= RULE_COLON ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_params_6_0= ruleCssTok ) )* otherlv_7= ')' ) )
				int alt61 = 2;
				int LA61_0 = input.LA(1);

				if ((LA61_0 == RULE_COLON)) {
					int LA61_1 = input.LA(2);

					if (((LA61_1 >= RULE_DASH && LA61_1 <= RULE_ONE_NON_HEX_LETTER) || (LA61_1 >= 56 && LA61_1 <= 59))) {
						alt61 = 2;
					} else if ((LA61_1 == 46)) {
						alt61 = 1;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 61, 1, input);

						throw nvae;
					}
				} else {
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 61, 0, input);

					throw nvae;
				}
				switch (alt61) {
				case 1:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2206:2: ( ( (lv_not_0_0= ruleNotFunctionCall ) ) ( (lv_paramSelector_1_0= ruleSimpleSelectorForNegation ) )
				// otherlv_2= ')' )
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2206:2: ( ( (lv_not_0_0= ruleNotFunctionCall ) ) ( (lv_paramSelector_1_0= ruleSimpleSelectorForNegation )
					// ) otherlv_2= ')' )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2206:3: ( (lv_not_0_0= ruleNotFunctionCall ) ) ( (lv_paramSelector_1_0= ruleSimpleSelectorForNegation ) )
					// otherlv_2= ')'
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2206:3: ( (lv_not_0_0= ruleNotFunctionCall ) )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2207:1: (lv_not_0_0= ruleNotFunctionCall )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2207:1: (lv_not_0_0= ruleNotFunctionCall )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2208:3: lv_not_0_0= ruleNotFunctionCall
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getPseudoClassFunctionAccess().getNotNotFunctionCallParserRuleCall_0_0_0());

								}
								pushFollow(FOLLOW_ruleNotFunctionCall_in_rulePseudoClassFunction4899);
								lv_not_0_0 = ruleNotFunctionCall();

								state._fsp--;
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getPseudoClassFunctionRule());
									}
									set(
											current,
											"not",
											true,
											"NotFunctionCall");
									afterParserOrEnumRuleCall();

								}

							}


						}

						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2224:2: ( (lv_paramSelector_1_0= ruleSimpleSelectorForNegation ) )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2225:1: (lv_paramSelector_1_0= ruleSimpleSelectorForNegation )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2225:1: (lv_paramSelector_1_0= ruleSimpleSelectorForNegation )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2226:3: lv_paramSelector_1_0= ruleSimpleSelectorForNegation
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getPseudoClassFunctionAccess().getParamSelectorSimpleSelectorForNegationParserRuleCall_0_1_0());

								}
								pushFollow(FOLLOW_ruleSimpleSelectorForNegation_in_rulePseudoClassFunction4920);
								lv_paramSelector_1_0 = ruleSimpleSelectorForNegation();

								state._fsp--;
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getPseudoClassFunctionRule());
									}
									set(
											current,
											"paramSelector",
											lv_paramSelector_1_0,
											"SimpleSelectorForNegation");
									afterParserOrEnumRuleCall();

								}

							}


						}

						otherlv_2 = (Token) match(input, 44, FOLLOW_44_in_rulePseudoClassFunction4932);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							newLeafNode(otherlv_2, grammarAccess.getPseudoClassFunctionAccess().getRightParenthesisKeyword_0_2());

						}

					}


				}
					break;
				case 2:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2247:6: (this_COLON_3= RULE_COLON ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_params_6_0=
				// ruleCssTok ) )* otherlv_7= ')' )
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2247:6: (this_COLON_3= RULE_COLON ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_params_6_0=
					// ruleCssTok ) )* otherlv_7= ')' )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2247:7: this_COLON_3= RULE_COLON ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_params_6_0=
					// ruleCssTok ) )* otherlv_7= ')'
					{
						this_COLON_3 = (Token) match(input, RULE_COLON, FOLLOW_RULE_COLON_in_rulePseudoClassFunction4951);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							newLeafNode(this_COLON_3, grammarAccess.getPseudoClassFunctionAccess().getCOLONTerminalRuleCall_1_0());

						}
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2251:1: ( (lv_name_4_0= ruleIdentifier ) )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2252:1: (lv_name_4_0= ruleIdentifier )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2252:1: (lv_name_4_0= ruleIdentifier )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2253:3: lv_name_4_0= ruleIdentifier
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getPseudoClassFunctionAccess().getNameIdentifierParserRuleCall_1_1_0());

								}
								pushFollow(FOLLOW_ruleIdentifier_in_rulePseudoClassFunction4971);
								lv_name_4_0 = ruleIdentifier();

								state._fsp--;
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElementForParent(grammarAccess.getPseudoClassFunctionRule());
									}
									set(
											current,
											"name",
											lv_name_4_0,
											"Identifier");
									afterParserOrEnumRuleCall();

								}

							}


						}

						otherlv_5 = (Token) match(input, 45, FOLLOW_45_in_rulePseudoClassFunction4983);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							newLeafNode(otherlv_5, grammarAccess.getPseudoClassFunctionAccess().getLeftParenthesisKeyword_1_2());

						}
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2273:1: ( (lv_params_6_0= ruleCssTok ) )*
						loop60: do {
							int alt60 = 2;
							int LA60_0 = input.LA(1);

							if ((LA60_0 == RULE_CSSSTRING || (LA60_0 >= RULE_COMMA && LA60_0 <= RULE_WS) || LA60_0 == RULE_HASHMARK || (LA60_0 >= RULE_PLUS && LA60_0 <= RULE_ONE_INT) || LA60_0 == 41 || LA60_0 == 49 || (LA60_0 >= 56 && LA60_0 <= 59))) {
								alt60 = 1;
							}


							switch (alt60) {
							case 1:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2274:1: (lv_params_6_0= ruleCssTok )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2274:1: (lv_params_6_0= ruleCssTok )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2275:3: lv_params_6_0= ruleCssTok
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getPseudoClassFunctionAccess().getParamsCssTokParserRuleCall_1_3_0());

									}
									pushFollow(FOLLOW_ruleCssTok_in_rulePseudoClassFunction5004);
									lv_params_6_0 = ruleCssTok();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getPseudoClassFunctionRule());
										}
										add(
												current,
												"params",
												lv_params_6_0,
												"CssTok");
										afterParserOrEnumRuleCall();

									}

								}


							}
								break;

							default:
								break loop60;
							}
						} while (true);

						otherlv_7 = (Token) match(input, 44, FOLLOW_44_in_rulePseudoClassFunction5017);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							newLeafNode(otherlv_7, grammarAccess.getPseudoClassFunctionAccess().getRightParenthesisKeyword_1_4());

						}

					}


				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulePseudoClassFunction"


	// $ANTLR start "entryRuleNotFunctionCall"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2303:1: entryRuleNotFunctionCall returns [String current=null] : iv_ruleNotFunctionCall= ruleNotFunctionCall EOF ;
	public final String entryRuleNotFunctionCall() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleNotFunctionCall = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2304:2: (iv_ruleNotFunctionCall= ruleNotFunctionCall EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2305:2: iv_ruleNotFunctionCall= ruleNotFunctionCall EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getNotFunctionCallRule());
				}
				pushFollow(FOLLOW_ruleNotFunctionCall_in_entryRuleNotFunctionCall5055);
				iv_ruleNotFunctionCall = ruleNotFunctionCall();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleNotFunctionCall.getText();
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleNotFunctionCall5066);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleNotFunctionCall"


	// $ANTLR start "ruleNotFunctionCall"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2312:1: ruleNotFunctionCall returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_COLON_0=
	// RULE_COLON kw= 'not(' ) ;
	public final AntlrDatatypeRuleToken ruleNotFunctionCall() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_COLON_0 = null;
		Token kw = null;

		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2315:28: ( (this_COLON_0= RULE_COLON kw= 'not(' ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2316:1: (this_COLON_0= RULE_COLON kw= 'not(' )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2316:1: (this_COLON_0= RULE_COLON kw= 'not(' )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2316:6: this_COLON_0= RULE_COLON kw= 'not('
				{
					this_COLON_0 = (Token) match(input, RULE_COLON, FOLLOW_RULE_COLON_in_ruleNotFunctionCall5106);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(this_COLON_0);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_COLON_0, grammarAccess.getNotFunctionCallAccess().getCOLONTerminalRuleCall_0());

					}
					kw = (Token) match(input, 46, FOLLOW_46_in_ruleNotFunctionCall5124);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getNotFunctionCallAccess().getNotKeyword_1());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleNotFunctionCall"


	// $ANTLR start "entryRulecombinator"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2337:1: entryRulecombinator returns [String current=null] : iv_rulecombinator= rulecombinator EOF ;
	public final String entryRulecombinator() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_rulecombinator = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2338:2: (iv_rulecombinator= rulecombinator EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2339:2: iv_rulecombinator= rulecombinator EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getCombinatorRule());
				}
				pushFollow(FOLLOW_rulecombinator_in_entryRulecombinator5165);
				iv_rulecombinator = rulecombinator();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_rulecombinator.getText();
				}
				match(input, EOF, FOLLOW_EOF_in_entryRulecombinator5176);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRulecombinator"


	// $ANTLR start "rulecombinator"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2346:1: rulecombinator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_PLUS_0= RULE_PLUS |
	// kw= '>' | kw= '~' ) ;
	public final AntlrDatatypeRuleToken rulecombinator() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_PLUS_0 = null;
		Token kw = null;

		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2349:28: ( (this_PLUS_0= RULE_PLUS | kw= '>' | kw= '~' ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2350:1: (this_PLUS_0= RULE_PLUS | kw= '>' | kw= '~' )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2350:1: (this_PLUS_0= RULE_PLUS | kw= '>' | kw= '~' )
				int alt62 = 3;
				switch (input.LA(1)) {
				case RULE_PLUS: {
					alt62 = 1;
				}
					break;
				case 47: {
					alt62 = 2;
				}
					break;
				case 48: {
					alt62 = 3;
				}
					break;
				default:
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 62, 0, input);

					throw nvae;
				}

				switch (alt62) {
				case 1:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2350:6: this_PLUS_0= RULE_PLUS
				{
					this_PLUS_0 = (Token) match(input, RULE_PLUS, FOLLOW_RULE_PLUS_in_rulecombinator5216);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(this_PLUS_0);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_PLUS_0, grammarAccess.getCombinatorAccess().getPLUSTerminalRuleCall_0());

					}

				}
					break;
				case 2:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2359:2: kw= '>'
				{
					kw = (Token) match(input, 47, FOLLOW_47_in_rulecombinator5240);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getCombinatorAccess().getGreaterThanSignKeyword_1());

					}

				}
					break;
				case 3:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2366:2: kw= '~'
				{
					kw = (Token) match(input, 48, FOLLOW_48_in_rulecombinator5259);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getCombinatorAccess().getTildeKeyword_2());

					}

				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "rulecombinator"


	// $ANTLR start "entryRuleSymbolTok"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2383:1: entryRuleSymbolTok returns [EObject current=null] : iv_ruleSymbolTok= ruleSymbolTok EOF ;
	public final EObject entryRuleSymbolTok() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleSymbolTok = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2384:2: (iv_ruleSymbolTok= ruleSymbolTok EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2385:2: iv_ruleSymbolTok= ruleSymbolTok EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getSymbolTokRule());
				}
				pushFollow(FOLLOW_ruleSymbolTok_in_entryRuleSymbolTok5303);
				iv_ruleSymbolTok = ruleSymbolTok();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleSymbolTok;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleSymbolTok5313);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleSymbolTok"


	// $ANTLR start "ruleSymbolTok"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2392:1: ruleSymbolTok returns [EObject current=null] : ( () ( ( (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT )
	// ) ) ) ;
	public final EObject ruleSymbolTok() throws RecognitionException {
		EObject current = null;

		Token lv_symbol_1_1 = null;
		Token lv_symbol_1_2 = null;

		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2395:28: ( ( () ( ( (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT ) ) ) ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2396:1: ( () ( ( (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT ) ) ) )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2396:1: ( () ( ( (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT ) ) ) )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2396:2: () ( ( (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT ) ) )
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2396:2: ()
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2397:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getSymbolTokAccess().getSymbolTokAction_0(),
									current);

						}

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2402:2: ( ( (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT ) ) )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2403:1: ( (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT ) )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2403:1: ( (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT ) )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2404:1: (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2404:1: (lv_symbol_1_1= RULE_COMMA | lv_symbol_1_2= RULE_PERCENT )
							int alt63 = 2;
							int LA63_0 = input.LA(1);

							if ((LA63_0 == RULE_COMMA)) {
								alt63 = 1;
							} else if ((LA63_0 == RULE_PERCENT)) {
								alt63 = 2;
							} else {
								if (state.backtracking > 0) {
									state.failed = true;
									return current;
								}
								NoViableAltException nvae = new NoViableAltException("", 63, 0, input);

								throw nvae;
							}
							switch (alt63) {
							case 1:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2405:3: lv_symbol_1_1= RULE_COMMA
							{
								lv_symbol_1_1 = (Token) match(input, RULE_COMMA, FOLLOW_RULE_COMMA_in_ruleSymbolTok5366);
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									newLeafNode(lv_symbol_1_1, grammarAccess.getSymbolTokAccess().getSymbolCOMMATerminalRuleCall_1_0_0());

								}
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElement(grammarAccess.getSymbolTokRule());
									}
									setWithLastConsumed(
											current,
											"symbol",
											lv_symbol_1_1,
											"COMMA");

								}

							}
								break;
							case 2:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2420:8: lv_symbol_1_2= RULE_PERCENT
							{
								lv_symbol_1_2 = (Token) match(input, RULE_PERCENT, FOLLOW_RULE_PERCENT_in_ruleSymbolTok5386);
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									newLeafNode(lv_symbol_1_2, grammarAccess.getSymbolTokAccess().getSymbolPERCENTTerminalRuleCall_1_0_1());

								}
								if (state.backtracking == 0) {

									if (current == null) {
										current = createModelElement(grammarAccess.getSymbolTokRule());
									}
									setWithLastConsumed(
											current,
											"symbol",
											lv_symbol_1_2,
											"PERCENT");

								}

							}
								break;

							}


						}


					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleSymbolTok"


	// $ANTLR start "entryRuleWSTok"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2446:1: entryRuleWSTok returns [EObject current=null] : iv_ruleWSTok= ruleWSTok EOF ;
	public final EObject entryRuleWSTok() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleWSTok = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2447:2: (iv_ruleWSTok= ruleWSTok EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2448:2: iv_ruleWSTok= ruleWSTok EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getWSTokRule());
				}
				pushFollow(FOLLOW_ruleWSTok_in_entryRuleWSTok5430);
				iv_ruleWSTok = ruleWSTok();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleWSTok;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleWSTok5440);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleWSTok"


	// $ANTLR start "ruleWSTok"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2455:1: ruleWSTok returns [EObject current=null] : ( () this_WS_1= RULE_WS ) ;
	public final EObject ruleWSTok() throws RecognitionException {
		EObject current = null;

		Token this_WS_1 = null;

		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2458:28: ( ( () this_WS_1= RULE_WS ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2459:1: ( () this_WS_1= RULE_WS )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2459:1: ( () this_WS_1= RULE_WS )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2459:2: () this_WS_1= RULE_WS
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2459:2: ()
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2460:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getWSTokAccess().getWSTokAction_0(),
									current);

						}

					}

					this_WS_1 = (Token) match(input, RULE_WS, FOLLOW_RULE_WS_in_ruleWSTok5485);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(this_WS_1, grammarAccess.getWSTokAccess().getWSTerminalRuleCall_1());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleWSTok"


	// $ANTLR start "entryRuleStringTok"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2477:1: entryRuleStringTok returns [EObject current=null] : iv_ruleStringTok= ruleStringTok EOF ;
	public final EObject entryRuleStringTok() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleStringTok = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2478:2: (iv_ruleStringTok= ruleStringTok EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2479:2: iv_ruleStringTok= ruleStringTok EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getStringTokRule());
				}
				pushFollow(FOLLOW_ruleStringTok_in_entryRuleStringTok5520);
				iv_ruleStringTok = ruleStringTok();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleStringTok;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleStringTok5530);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleStringTok"


	// $ANTLR start "ruleStringTok"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2486:1: ruleStringTok returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_CSSSTRING ) ) ) ;
	public final EObject ruleStringTok() throws RecognitionException {
		EObject current = null;

		Token lv_value_1_0 = null;

		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2489:28: ( ( () ( (lv_value_1_0= RULE_CSSSTRING ) ) ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2490:1: ( () ( (lv_value_1_0= RULE_CSSSTRING ) ) )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2490:1: ( () ( (lv_value_1_0= RULE_CSSSTRING ) ) )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2490:2: () ( (lv_value_1_0= RULE_CSSSTRING ) )
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2490:2: ()
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2491:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getStringTokAccess().getStringTokAction_0(),
									current);

						}

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2496:2: ( (lv_value_1_0= RULE_CSSSTRING ) )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2497:1: (lv_value_1_0= RULE_CSSSTRING )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2497:1: (lv_value_1_0= RULE_CSSSTRING )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2498:3: lv_value_1_0= RULE_CSSSTRING
						{
							lv_value_1_0 = (Token) match(input, RULE_CSSSTRING, FOLLOW_RULE_CSSSTRING_in_ruleStringTok5581);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								newLeafNode(lv_value_1_0, grammarAccess.getStringTokAccess().getValueCSSSTRINGTerminalRuleCall_1_0());

							}
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElement(grammarAccess.getStringTokRule());
								}
								setWithLastConsumed(
										current,
										"value",
										lv_value_1_0,
										"CSSSTRING");

							}

						}


					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleStringTok"


	// $ANTLR start "entryRuleNumberTok"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2522:1: entryRuleNumberTok returns [EObject current=null] : iv_ruleNumberTok= ruleNumberTok EOF ;
	public final EObject entryRuleNumberTok() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleNumberTok = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2523:2: (iv_ruleNumberTok= ruleNumberTok EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2524:2: iv_ruleNumberTok= ruleNumberTok EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getNumberTokRule());
				}
				pushFollow(FOLLOW_ruleNumberTok_in_entryRuleNumberTok5622);
				iv_ruleNumberTok = ruleNumberTok();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleNumberTok;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleNumberTok5632);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleNumberTok"


	// $ANTLR start "ruleNumberTok"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2531:1: ruleNumberTok returns [EObject current=null] : ( () ( (lv_val_1_0= ruleNum ) ) ) ;
	public final EObject ruleNumberTok() throws RecognitionException {
		EObject current = null;

		AntlrDatatypeRuleToken lv_val_1_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2534:28: ( ( () ( (lv_val_1_0= ruleNum ) ) ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2535:1: ( () ( (lv_val_1_0= ruleNum ) ) )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2535:1: ( () ( (lv_val_1_0= ruleNum ) ) )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2535:2: () ( (lv_val_1_0= ruleNum ) )
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2535:2: ()
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2536:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getNumberTokAccess().getNumberTokAction_0(),
									current);

						}

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2541:2: ( (lv_val_1_0= ruleNum ) )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2542:1: (lv_val_1_0= ruleNum )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2542:1: (lv_val_1_0= ruleNum )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2543:3: lv_val_1_0= ruleNum
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getNumberTokAccess().getValNumParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_ruleNum_in_ruleNumberTok5687);
							lv_val_1_0 = ruleNum();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getNumberTokRule());
								}
								set(
										current,
										"val",
										lv_val_1_0,
										"Num");
								afterParserOrEnumRuleCall();

							}

						}


					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleNumberTok"


	// $ANTLR start "entryRuleUrlTok"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2567:1: entryRuleUrlTok returns [EObject current=null] : iv_ruleUrlTok= ruleUrlTok EOF ;
	public final EObject entryRuleUrlTok() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleUrlTok = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2568:2: (iv_ruleUrlTok= ruleUrlTok EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2569:2: iv_ruleUrlTok= ruleUrlTok EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getUrlTokRule());
				}
				pushFollow(FOLLOW_ruleUrlTok_in_entryRuleUrlTok5723);
				iv_ruleUrlTok = ruleUrlTok();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleUrlTok;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleUrlTok5733);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleUrlTok"


	// $ANTLR start "ruleUrlTok"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2576:1: ruleUrlTok returns [EObject current=null] : ( () ( (lv_url_1_0= ruleURLType ) ) ) ;
	public final EObject ruleUrlTok() throws RecognitionException {
		EObject current = null;

		EObject lv_url_1_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2579:28: ( ( () ( (lv_url_1_0= ruleURLType ) ) ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2580:1: ( () ( (lv_url_1_0= ruleURLType ) ) )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2580:1: ( () ( (lv_url_1_0= ruleURLType ) ) )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2580:2: () ( (lv_url_1_0= ruleURLType ) )
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2580:2: ()
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2581:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getUrlTokAccess().getUrlTokAction_0(),
									current);

						}

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2586:2: ( (lv_url_1_0= ruleURLType ) )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2587:1: (lv_url_1_0= ruleURLType )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2587:1: (lv_url_1_0= ruleURLType )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2588:3: lv_url_1_0= ruleURLType
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getUrlTokAccess().getUrlURLTypeParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_ruleURLType_in_ruleUrlTok5788);
							lv_url_1_0 = ruleURLType();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getUrlTokRule());
								}
								set(
										current,
										"url",
										lv_url_1_0,
										"URLType");
								afterParserOrEnumRuleCall();

							}

						}


					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleUrlTok"


	// $ANTLR start "entryRuleColorTok"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2612:1: entryRuleColorTok returns [EObject current=null] : iv_ruleColorTok= ruleColorTok EOF ;
	public final EObject entryRuleColorTok() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleColorTok = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2613:2: (iv_ruleColorTok= ruleColorTok EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2614:2: iv_ruleColorTok= ruleColorTok EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getColorTokRule());
				}
				pushFollow(FOLLOW_ruleColorTok_in_entryRuleColorTok5824);
				iv_ruleColorTok = ruleColorTok();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleColorTok;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleColorTok5834);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleColorTok"


	// $ANTLR start "ruleColorTok"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2621:1: ruleColorTok returns [EObject current=null] : ( () ( (lv_value_1_0= ruleHex ) ) ) ;
	public final EObject ruleColorTok() throws RecognitionException {
		EObject current = null;

		AntlrDatatypeRuleToken lv_value_1_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2624:28: ( ( () ( (lv_value_1_0= ruleHex ) ) ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2625:1: ( () ( (lv_value_1_0= ruleHex ) ) )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2625:1: ( () ( (lv_value_1_0= ruleHex ) ) )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2625:2: () ( (lv_value_1_0= ruleHex ) )
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2625:2: ()
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2626:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getColorTokAccess().getColorTokAction_0(),
									current);

						}

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2631:2: ( (lv_value_1_0= ruleHex ) )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2632:1: (lv_value_1_0= ruleHex )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2632:1: (lv_value_1_0= ruleHex )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2633:3: lv_value_1_0= ruleHex
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getColorTokAccess().getValueHexParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_ruleHex_in_ruleColorTok5889);
							lv_value_1_0 = ruleHex();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getColorTokRule());
								}
								set(
										current,
										"value",
										lv_value_1_0,
										"Hex");
								afterParserOrEnumRuleCall();

							}

						}


					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleColorTok"


	// $ANTLR start "entryRuleIdentifierOrFuncTok"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2657:1: entryRuleIdentifierOrFuncTok returns [EObject current=null] : iv_ruleIdentifierOrFuncTok= ruleIdentifierOrFuncTok
	// EOF ;
	public final EObject entryRuleIdentifierOrFuncTok() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleIdentifierOrFuncTok = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2658:2: (iv_ruleIdentifierOrFuncTok= ruleIdentifierOrFuncTok EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2659:2: iv_ruleIdentifierOrFuncTok= ruleIdentifierOrFuncTok EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getIdentifierOrFuncTokRule());
				}
				pushFollow(FOLLOW_ruleIdentifierOrFuncTok_in_entryRuleIdentifierOrFuncTok5925);
				iv_ruleIdentifierOrFuncTok = ruleIdentifierOrFuncTok();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleIdentifierOrFuncTok;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleIdentifierOrFuncTok5935);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleIdentifierOrFuncTok"


	// $ANTLR start "ruleIdentifierOrFuncTok"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2666:1: ruleIdentifierOrFuncTok returns [EObject current=null] : ( () ( (lv_name_1_0= ruleIdentifier ) ) ( () otherlv_3=
	// '(' ( (lv_params_4_0= ruleCssTok ) )+ otherlv_5= ')' )? ) ;
	public final EObject ruleIdentifierOrFuncTok() throws RecognitionException {
		EObject current = null;

		Token otherlv_3 = null;
		Token otherlv_5 = null;
		AntlrDatatypeRuleToken lv_name_1_0 = null;

		EObject lv_params_4_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2669:28: ( ( () ( (lv_name_1_0= ruleIdentifier ) ) ( () otherlv_3= '(' ( (lv_params_4_0= ruleCssTok ) )+
			// otherlv_5= ')' )? ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2670:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) ( () otherlv_3= '(' ( (lv_params_4_0= ruleCssTok ) )+ otherlv_5=
			// ')' )? )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2670:1: ( () ( (lv_name_1_0= ruleIdentifier ) ) ( () otherlv_3= '(' ( (lv_params_4_0= ruleCssTok ) )+
				// otherlv_5= ')' )? )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2670:2: () ( (lv_name_1_0= ruleIdentifier ) ) ( () otherlv_3= '(' ( (lv_params_4_0= ruleCssTok ) )+ otherlv_5=
				// ')' )?
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2670:2: ()
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2671:5:
					{
						if (state.backtracking == 0) {

							current = forceCreateModelElement(
									grammarAccess.getIdentifierOrFuncTokAccess().getIdentifierTokAction_0(),
									current);

						}

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2676:2: ( (lv_name_1_0= ruleIdentifier ) )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2677:1: (lv_name_1_0= ruleIdentifier )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2677:1: (lv_name_1_0= ruleIdentifier )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2678:3: lv_name_1_0= ruleIdentifier
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getIdentifierOrFuncTokAccess().getNameIdentifierParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_ruleIdentifier_in_ruleIdentifierOrFuncTok5990);
							lv_name_1_0 = ruleIdentifier();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getIdentifierOrFuncTokRule());
								}
								set(
										current,
										"name",
										lv_name_1_0,
										"Identifier");
								afterParserOrEnumRuleCall();

							}

						}


					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2694:2: ( () otherlv_3= '(' ( (lv_params_4_0= ruleCssTok ) )+ otherlv_5= ')' )?
					int alt65 = 2;
					int LA65_0 = input.LA(1);

					if ((LA65_0 == 45)) {
						alt65 = 1;
					}
					switch (alt65) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2694:3: () otherlv_3= '(' ( (lv_params_4_0= ruleCssTok ) )+ otherlv_5= ')'
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2694:3: ()
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2695:5:
						{
							if (state.backtracking == 0) {

								current = forceCreateModelElementAndSet(
										grammarAccess.getIdentifierOrFuncTokAccess().getFuncTokNameAction_2_0(),
										current);

							}

						}

						otherlv_3 = (Token) match(input, 45, FOLLOW_45_in_ruleIdentifierOrFuncTok6012);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							newLeafNode(otherlv_3, grammarAccess.getIdentifierOrFuncTokAccess().getLeftParenthesisKeyword_2_1());

						}
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2704:1: ( (lv_params_4_0= ruleCssTok ) )+
						int cnt64 = 0;
						loop64: do {
							int alt64 = 2;
							int LA64_0 = input.LA(1);

							if ((LA64_0 == RULE_CSSSTRING || (LA64_0 >= RULE_COMMA && LA64_0 <= RULE_WS) || LA64_0 == RULE_HASHMARK || (LA64_0 >= RULE_PLUS && LA64_0 <= RULE_ONE_INT) || LA64_0 == 41 || LA64_0 == 49 || (LA64_0 >= 56 && LA64_0 <= 59))) {
								alt64 = 1;
							}


							switch (alt64) {
							case 1:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2705:1: (lv_params_4_0= ruleCssTok )
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2705:1: (lv_params_4_0= ruleCssTok )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2706:3: lv_params_4_0= ruleCssTok
								{
									if (state.backtracking == 0) {

										newCompositeNode(grammarAccess.getIdentifierOrFuncTokAccess().getParamsCssTokParserRuleCall_2_2_0());

									}
									pushFollow(FOLLOW_ruleCssTok_in_ruleIdentifierOrFuncTok6033);
									lv_params_4_0 = ruleCssTok();

									state._fsp--;
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										if (current == null) {
											current = createModelElementForParent(grammarAccess.getIdentifierOrFuncTokRule());
										}
										add(
												current,
												"params",
												lv_params_4_0,
												"CssTok");
										afterParserOrEnumRuleCall();

									}

								}


							}
								break;

							default:
								if (cnt64 >= 1)
									break loop64;
								if (state.backtracking > 0) {
									state.failed = true;
									return current;
								}
								EarlyExitException eee = new EarlyExitException(64, input);
								throw eee;
							}
							cnt64++;
						} while (true);

						otherlv_5 = (Token) match(input, 44, FOLLOW_44_in_ruleIdentifierOrFuncTok6046);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							newLeafNode(otherlv_5, grammarAccess.getIdentifierOrFuncTokAccess().getRightParenthesisKeyword_2_3());

						}

					}
						break;

					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleIdentifierOrFuncTok"


	// $ANTLR start "entryRuleCssTok"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2734:1: entryRuleCssTok returns [EObject current=null] : iv_ruleCssTok= ruleCssTok EOF ;
	public final EObject entryRuleCssTok() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleCssTok = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2735:2: (iv_ruleCssTok= ruleCssTok EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2736:2: iv_ruleCssTok= ruleCssTok EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getCssTokRule());
				}
				pushFollow(FOLLOW_ruleCssTok_in_entryRuleCssTok6084);
				iv_ruleCssTok = ruleCssTok();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleCssTok;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleCssTok6094);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleCssTok"


	// $ANTLR start "ruleCssTok"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2743:1: ruleCssTok returns [EObject current=null] : (this_IdentifierOrFuncTok_0= ruleIdentifierOrFuncTok |
	// this_SymbolTok_1= ruleSymbolTok | this_WSTok_2= ruleWSTok | this_StringTok_3= ruleStringTok | this_NumberTok_4= ruleNumberTok | this_UrlTok_5= ruleUrlTok | this_ColorTok_6= ruleColorTok ) ;
	public final EObject ruleCssTok() throws RecognitionException {
		EObject current = null;

		EObject this_IdentifierOrFuncTok_0 = null;

		EObject this_SymbolTok_1 = null;

		EObject this_WSTok_2 = null;

		EObject this_StringTok_3 = null;

		EObject this_NumberTok_4 = null;

		EObject this_UrlTok_5 = null;

		EObject this_ColorTok_6 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2746:28: ( (this_IdentifierOrFuncTok_0= ruleIdentifierOrFuncTok | this_SymbolTok_1= ruleSymbolTok | this_WSTok_2=
			// ruleWSTok | this_StringTok_3= ruleStringTok | this_NumberTok_4= ruleNumberTok | this_UrlTok_5= ruleUrlTok | this_ColorTok_6= ruleColorTok ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2747:1: (this_IdentifierOrFuncTok_0= ruleIdentifierOrFuncTok | this_SymbolTok_1= ruleSymbolTok | this_WSTok_2=
			// ruleWSTok | this_StringTok_3= ruleStringTok | this_NumberTok_4= ruleNumberTok | this_UrlTok_5= ruleUrlTok | this_ColorTok_6= ruleColorTok )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2747:1: (this_IdentifierOrFuncTok_0= ruleIdentifierOrFuncTok | this_SymbolTok_1= ruleSymbolTok | this_WSTok_2=
				// ruleWSTok | this_StringTok_3= ruleStringTok | this_NumberTok_4= ruleNumberTok | this_UrlTok_5= ruleUrlTok | this_ColorTok_6= ruleColorTok )
				int alt66 = 7;
				switch (input.LA(1)) {
				case RULE_DASH: {
					int LA66_1 = input.LA(2);

					if ((LA66_1 == RULE_ONE_INT || LA66_1 == 41)) {
						alt66 = 5;
					} else if (((LA66_1 >= RULE_UNDERSCORE && LA66_1 <= RULE_ONE_NON_HEX_LETTER) || (LA66_1 >= 56 && LA66_1 <= 59))) {
						alt66 = 1;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 66, 1, input);

						throw nvae;
					}
				}
					break;
				case RULE_UNDERSCORE:
				case RULE_ONE_HEX_LETTER:
				case RULE_ONE_NON_HEX_LETTER:
				case 56:
				case 57:
				case 58:
				case 59: {
					alt66 = 1;
				}
					break;
				case RULE_COMMA:
				case RULE_PERCENT: {
					alt66 = 2;
				}
					break;
				case RULE_WS: {
					alt66 = 3;
				}
					break;
				case RULE_CSSSTRING: {
					alt66 = 4;
				}
					break;
				case RULE_PLUS:
				case RULE_ONE_INT:
				case 41: {
					alt66 = 5;
				}
					break;
				case 49: {
					alt66 = 6;
				}
					break;
				case RULE_HASHMARK: {
					alt66 = 7;
				}
					break;
				default:
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 66, 0, input);

					throw nvae;
				}

				switch (alt66) {
				case 1:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2748:5: this_IdentifierOrFuncTok_0= ruleIdentifierOrFuncTok
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getCssTokAccess().getIdentifierOrFuncTokParserRuleCall_0());

					}
					pushFollow(FOLLOW_ruleIdentifierOrFuncTok_in_ruleCssTok6141);
					this_IdentifierOrFuncTok_0 = ruleIdentifierOrFuncTok();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current = this_IdentifierOrFuncTok_0;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 2:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2758:5: this_SymbolTok_1= ruleSymbolTok
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getCssTokAccess().getSymbolTokParserRuleCall_1());

					}
					pushFollow(FOLLOW_ruleSymbolTok_in_ruleCssTok6168);
					this_SymbolTok_1 = ruleSymbolTok();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current = this_SymbolTok_1;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 3:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2768:5: this_WSTok_2= ruleWSTok
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getCssTokAccess().getWSTokParserRuleCall_2());

					}
					pushFollow(FOLLOW_ruleWSTok_in_ruleCssTok6195);
					this_WSTok_2 = ruleWSTok();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current = this_WSTok_2;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 4:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2778:5: this_StringTok_3= ruleStringTok
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getCssTokAccess().getStringTokParserRuleCall_3());

					}
					pushFollow(FOLLOW_ruleStringTok_in_ruleCssTok6222);
					this_StringTok_3 = ruleStringTok();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current = this_StringTok_3;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 5:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2788:5: this_NumberTok_4= ruleNumberTok
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getCssTokAccess().getNumberTokParserRuleCall_4());

					}
					pushFollow(FOLLOW_ruleNumberTok_in_ruleCssTok6249);
					this_NumberTok_4 = ruleNumberTok();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current = this_NumberTok_4;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 6:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2798:5: this_UrlTok_5= ruleUrlTok
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getCssTokAccess().getUrlTokParserRuleCall_5());

					}
					pushFollow(FOLLOW_ruleUrlTok_in_ruleCssTok6276);
					this_UrlTok_5 = ruleUrlTok();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current = this_UrlTok_5;
						afterParserOrEnumRuleCall();

					}

				}
					break;
				case 7:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2808:5: this_ColorTok_6= ruleColorTok
				{
					if (state.backtracking == 0) {

						newCompositeNode(grammarAccess.getCssTokAccess().getColorTokParserRuleCall_6());

					}
					pushFollow(FOLLOW_ruleColorTok_in_ruleCssTok6303);
					this_ColorTok_6 = ruleColorTok();

					state._fsp--;
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current = this_ColorTok_6;
						afterParserOrEnumRuleCall();

					}

				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleCssTok"


	// $ANTLR start "entryRuleURLType"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2824:1: entryRuleURLType returns [EObject current=null] : iv_ruleURLType= ruleURLType EOF ;
	public final EObject entryRuleURLType() throws RecognitionException {
		EObject current = null;

		EObject iv_ruleURLType = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2825:2: (iv_ruleURLType= ruleURLType EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2826:2: iv_ruleURLType= ruleURLType EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getURLTypeRule());
				}
				pushFollow(FOLLOW_ruleURLType_in_entryRuleURLType6338);
				iv_ruleURLType = ruleURLType();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleURLType;
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleURLType6348);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleURLType"


	// $ANTLR start "ruleURLType"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2833:1: ruleURLType returns [EObject current=null] : (otherlv_0= 'url(' ( (lv_url_1_0= ruleValidURL ) ) otherlv_2= ')' ) ;
	public final EObject ruleURLType() throws RecognitionException {
		EObject current = null;

		Token otherlv_0 = null;
		Token otherlv_2 = null;
		AntlrDatatypeRuleToken lv_url_1_0 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2836:28: ( (otherlv_0= 'url(' ( (lv_url_1_0= ruleValidURL ) ) otherlv_2= ')' ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2837:1: (otherlv_0= 'url(' ( (lv_url_1_0= ruleValidURL ) ) otherlv_2= ')' )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2837:1: (otherlv_0= 'url(' ( (lv_url_1_0= ruleValidURL ) ) otherlv_2= ')' )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2837:3: otherlv_0= 'url(' ( (lv_url_1_0= ruleValidURL ) ) otherlv_2= ')'
				{
					otherlv_0 = (Token) match(input, 49, FOLLOW_49_in_ruleURLType6385);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_0, grammarAccess.getURLTypeAccess().getUrlKeyword_0());

					}
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2841:1: ( (lv_url_1_0= ruleValidURL ) )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2842:1: (lv_url_1_0= ruleValidURL )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2842:1: (lv_url_1_0= ruleValidURL )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2843:3: lv_url_1_0= ruleValidURL
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getURLTypeAccess().getUrlValidURLParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_ruleValidURL_in_ruleURLType6406);
							lv_url_1_0 = ruleValidURL();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								if (current == null) {
									current = createModelElementForParent(grammarAccess.getURLTypeRule());
								}
								set(
										current,
										"url",
										lv_url_1_0,
										"ValidURL");
								afterParserOrEnumRuleCall();

							}

						}


					}

					otherlv_2 = (Token) match(input, 44, FOLLOW_44_in_ruleURLType6418);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						newLeafNode(otherlv_2, grammarAccess.getURLTypeAccess().getRightParenthesisKeyword_2());

					}

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleURLType"


	// $ANTLR start "entryRuleValidURLSymbol"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2871:1: entryRuleValidURLSymbol returns [String current=null] : iv_ruleValidURLSymbol= ruleValidURLSymbol EOF ;
	public final String entryRuleValidURLSymbol() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleValidURLSymbol = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2872:2: (iv_ruleValidURLSymbol= ruleValidURLSymbol EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2873:2: iv_ruleValidURLSymbol= ruleValidURLSymbol EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getValidURLSymbolRule());
				}
				pushFollow(FOLLOW_ruleValidURLSymbol_in_entryRuleValidURLSymbol6455);
				iv_ruleValidURLSymbol = ruleValidURLSymbol();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleValidURLSymbol.getText();
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleValidURLSymbol6466);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleValidURLSymbol"


	// $ANTLR start "ruleValidURLSymbol"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2880:1: ruleValidURLSymbol returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DASH_0= RULE_DASH
	// | kw= '.' | this_UNDERSCORE_2= RULE_UNDERSCORE | kw= '~' | this_COLON_4= RULE_COLON | kw= '/' | kw= '?' | this_HASHMARK_7= RULE_HASHMARK | kw= '[' | kw= ']' | kw= '@' | kw= '!' | kw= '$' | kw= '&' | kw= '*' | this_PLUS_15= RULE_PLUS | this_COMMA_16=
	// RULE_COMMA | kw= ';' | (kw= '=' this_KeywordHack_19= ruleKeywordHack ) ) ;
	public final AntlrDatatypeRuleToken ruleValidURLSymbol() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_DASH_0 = null;
		Token kw = null;
		Token this_UNDERSCORE_2 = null;
		Token this_COLON_4 = null;
		Token this_HASHMARK_7 = null;
		Token this_PLUS_15 = null;
		Token this_COMMA_16 = null;
		AntlrDatatypeRuleToken this_KeywordHack_19 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2883:28: ( (this_DASH_0= RULE_DASH | kw= '.' | this_UNDERSCORE_2= RULE_UNDERSCORE | kw= '~' | this_COLON_4=
			// RULE_COLON | kw= '/' | kw= '?' | this_HASHMARK_7= RULE_HASHMARK | kw= '[' | kw= ']' | kw= '@' | kw= '!' | kw= '$' | kw= '&' | kw= '*' | this_PLUS_15= RULE_PLUS | this_COMMA_16= RULE_COMMA | kw= ';' | (kw= '=' this_KeywordHack_19= ruleKeywordHack
			// ) ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2884:1: (this_DASH_0= RULE_DASH | kw= '.' | this_UNDERSCORE_2= RULE_UNDERSCORE | kw= '~' | this_COLON_4=
			// RULE_COLON | kw= '/' | kw= '?' | this_HASHMARK_7= RULE_HASHMARK | kw= '[' | kw= ']' | kw= '@' | kw= '!' | kw= '$' | kw= '&' | kw= '*' | this_PLUS_15= RULE_PLUS | this_COMMA_16= RULE_COMMA | kw= ';' | (kw= '=' this_KeywordHack_19= ruleKeywordHack
			// ) )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2884:1: (this_DASH_0= RULE_DASH | kw= '.' | this_UNDERSCORE_2= RULE_UNDERSCORE | kw= '~' | this_COLON_4=
				// RULE_COLON | kw= '/' | kw= '?' | this_HASHMARK_7= RULE_HASHMARK | kw= '[' | kw= ']' | kw= '@' | kw= '!' | kw= '$' | kw= '&' | kw= '*' | this_PLUS_15= RULE_PLUS | this_COMMA_16= RULE_COMMA | kw= ';' | (kw= '=' this_KeywordHack_19=
				// ruleKeywordHack ) )
				int alt67 = 19;
				switch (input.LA(1)) {
				case RULE_DASH: {
					alt67 = 1;
				}
					break;
				case 41: {
					alt67 = 2;
				}
					break;
				case RULE_UNDERSCORE: {
					alt67 = 3;
				}
					break;
				case 48: {
					alt67 = 4;
				}
					break;
				case RULE_COLON: {
					alt67 = 5;
				}
					break;
				case 50: {
					alt67 = 6;
				}
					break;
				case 51: {
					alt67 = 7;
				}
					break;
				case RULE_HASHMARK: {
					alt67 = 8;
				}
					break;
				case 35: {
					alt67 = 9;
				}
					break;
				case 40: {
					alt67 = 10;
				}
					break;
				case 52: {
					alt67 = 11;
				}
					break;
				case 53: {
					alt67 = 12;
				}
					break;
				case 54: {
					alt67 = 13;
				}
					break;
				case 55: {
					alt67 = 14;
				}
					break;
				case 42: {
					alt67 = 15;
				}
					break;
				case RULE_PLUS: {
					alt67 = 16;
				}
					break;
				case RULE_COMMA: {
					alt67 = 17;
				}
					break;
				case 22: {
					alt67 = 18;
				}
					break;
				case 39: {
					alt67 = 19;
				}
					break;
				default:
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 67, 0, input);

					throw nvae;
				}

				switch (alt67) {
				case 1:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2884:6: this_DASH_0= RULE_DASH
				{
					this_DASH_0 = (Token) match(input, RULE_DASH, FOLLOW_RULE_DASH_in_ruleValidURLSymbol6506);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(this_DASH_0);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_DASH_0, grammarAccess.getValidURLSymbolAccess().getDASHTerminalRuleCall_0());

					}

				}
					break;
				case 2:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2893:2: kw= '.'
				{
					kw = (Token) match(input, 41, FOLLOW_41_in_ruleValidURLSymbol6530);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getFullStopKeyword_1());

					}

				}
					break;
				case 3:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2899:10: this_UNDERSCORE_2= RULE_UNDERSCORE
				{
					this_UNDERSCORE_2 = (Token) match(input, RULE_UNDERSCORE, FOLLOW_RULE_UNDERSCORE_in_ruleValidURLSymbol6551);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(this_UNDERSCORE_2);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_UNDERSCORE_2, grammarAccess.getValidURLSymbolAccess().getUNDERSCORETerminalRuleCall_2());

					}

				}
					break;
				case 4:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2908:2: kw= '~'
				{
					kw = (Token) match(input, 48, FOLLOW_48_in_ruleValidURLSymbol6575);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getTildeKeyword_3());

					}

				}
					break;
				case 5:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2914:10: this_COLON_4= RULE_COLON
				{
					this_COLON_4 = (Token) match(input, RULE_COLON, FOLLOW_RULE_COLON_in_ruleValidURLSymbol6596);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(this_COLON_4);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_COLON_4, grammarAccess.getValidURLSymbolAccess().getCOLONTerminalRuleCall_4());

					}

				}
					break;
				case 6:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2923:2: kw= '/'
				{
					kw = (Token) match(input, 50, FOLLOW_50_in_ruleValidURLSymbol6620);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getSolidusKeyword_5());

					}

				}
					break;
				case 7:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2930:2: kw= '?'
				{
					kw = (Token) match(input, 51, FOLLOW_51_in_ruleValidURLSymbol6639);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getQuestionMarkKeyword_6());

					}

				}
					break;
				case 8:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2936:10: this_HASHMARK_7= RULE_HASHMARK
				{
					this_HASHMARK_7 = (Token) match(input, RULE_HASHMARK, FOLLOW_RULE_HASHMARK_in_ruleValidURLSymbol6660);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(this_HASHMARK_7);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_HASHMARK_7, grammarAccess.getValidURLSymbolAccess().getHASHMARKTerminalRuleCall_7());

					}

				}
					break;
				case 9:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2945:2: kw= '['
				{
					kw = (Token) match(input, 35, FOLLOW_35_in_ruleValidURLSymbol6684);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getLeftSquareBracketKeyword_8());

					}

				}
					break;
				case 10:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2952:2: kw= ']'
				{
					kw = (Token) match(input, 40, FOLLOW_40_in_ruleValidURLSymbol6703);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getRightSquareBracketKeyword_9());

					}

				}
					break;
				case 11:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2959:2: kw= '@'
				{
					kw = (Token) match(input, 52, FOLLOW_52_in_ruleValidURLSymbol6722);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getCommercialAtKeyword_10());

					}

				}
					break;
				case 12:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2966:2: kw= '!'
				{
					kw = (Token) match(input, 53, FOLLOW_53_in_ruleValidURLSymbol6741);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getExclamationMarkKeyword_11());

					}

				}
					break;
				case 13:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2973:2: kw= '$'
				{
					kw = (Token) match(input, 54, FOLLOW_54_in_ruleValidURLSymbol6760);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getDollarSignKeyword_12());

					}

				}
					break;
				case 14:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2980:2: kw= '&'
				{
					kw = (Token) match(input, 55, FOLLOW_55_in_ruleValidURLSymbol6779);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getAmpersandKeyword_13());

					}

				}
					break;
				case 15:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2987:2: kw= '*'
				{
					kw = (Token) match(input, 42, FOLLOW_42_in_ruleValidURLSymbol6798);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getAsteriskKeyword_14());

					}

				}
					break;
				case 16:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:2993:10: this_PLUS_15= RULE_PLUS
				{
					this_PLUS_15 = (Token) match(input, RULE_PLUS, FOLLOW_RULE_PLUS_in_ruleValidURLSymbol6819);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(this_PLUS_15);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_PLUS_15, grammarAccess.getValidURLSymbolAccess().getPLUSTerminalRuleCall_15());

					}

				}
					break;
				case 17:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3001:10: this_COMMA_16= RULE_COMMA
				{
					this_COMMA_16 = (Token) match(input, RULE_COMMA, FOLLOW_RULE_COMMA_in_ruleValidURLSymbol6845);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(this_COMMA_16);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_COMMA_16, grammarAccess.getValidURLSymbolAccess().getCOMMATerminalRuleCall_16());

					}

				}
					break;
				case 18:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3010:2: kw= ';'
				{
					kw = (Token) match(input, 22, FOLLOW_22_in_ruleValidURLSymbol6869);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getSemicolonKeyword_17());

					}

				}
					break;
				case 19:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3016:6: (kw= '=' this_KeywordHack_19= ruleKeywordHack )
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3016:6: (kw= '=' this_KeywordHack_19= ruleKeywordHack )
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3017:2: kw= '=' this_KeywordHack_19= ruleKeywordHack
					{
						kw = (Token) match(input, 39, FOLLOW_39_in_ruleValidURLSymbol6889);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							current.merge(kw);
							newLeafNode(kw, grammarAccess.getValidURLSymbolAccess().getEqualsSignKeyword_18_0());

						}
						if (state.backtracking == 0) {

							newCompositeNode(grammarAccess.getValidURLSymbolAccess().getKeywordHackParserRuleCall_18_1());

						}
						pushFollow(FOLLOW_ruleKeywordHack_in_ruleValidURLSymbol6911);
						this_KeywordHack_19 = ruleKeywordHack();

						state._fsp--;
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							current.merge(this_KeywordHack_19);

						}
						if (state.backtracking == 0) {

							afterParserOrEnumRuleCall();

						}

					}


				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleValidURLSymbol"


	// $ANTLR start "entryRuleKeywordHack"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3041:1: entryRuleKeywordHack returns [String current=null] : iv_ruleKeywordHack= ruleKeywordHack EOF ;
	public final String entryRuleKeywordHack() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleKeywordHack = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3042:2: (iv_ruleKeywordHack= ruleKeywordHack EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3043:2: iv_ruleKeywordHack= ruleKeywordHack EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getKeywordHackRule());
				}
				pushFollow(FOLLOW_ruleKeywordHack_in_entryRuleKeywordHack6958);
				iv_ruleKeywordHack = ruleKeywordHack();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleKeywordHack.getText();
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleKeywordHack6969);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleKeywordHack"


	// $ANTLR start "ruleKeywordHack"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3050:1: ruleKeywordHack returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= 'no' |
	// kw= 'url' | kw= 'ur' ) ;
	public final AntlrDatatypeRuleToken ruleKeywordHack() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token kw = null;

		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3053:28: ( (kw= 'not' | kw= 'no' | kw= 'url' | kw= 'ur' ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3054:1: (kw= 'not' | kw= 'no' | kw= 'url' | kw= 'ur' )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3054:1: (kw= 'not' | kw= 'no' | kw= 'url' | kw= 'ur' )
				int alt68 = 4;
				switch (input.LA(1)) {
				case 56: {
					alt68 = 1;
				}
					break;
				case 57: {
					alt68 = 2;
				}
					break;
				case 58: {
					alt68 = 3;
				}
					break;
				case 59: {
					alt68 = 4;
				}
					break;
				default:
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 68, 0, input);

					throw nvae;
				}

				switch (alt68) {
				case 1:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3055:2: kw= 'not'
				{
					kw = (Token) match(input, 56, FOLLOW_56_in_ruleKeywordHack7007);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getKeywordHackAccess().getNotKeyword_0());

					}

				}
					break;
				case 2:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3062:2: kw= 'no'
				{
					kw = (Token) match(input, 57, FOLLOW_57_in_ruleKeywordHack7026);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getKeywordHackAccess().getNoKeyword_1());

					}

				}
					break;
				case 3:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3069:2: kw= 'url'
				{
					kw = (Token) match(input, 58, FOLLOW_58_in_ruleKeywordHack7045);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getKeywordHackAccess().getUrlKeyword_2());

					}

				}
					break;
				case 4:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3076:2: kw= 'ur'
				{
					kw = (Token) match(input, 59, FOLLOW_59_in_ruleKeywordHack7064);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(kw);
						newLeafNode(kw, grammarAccess.getKeywordHackAccess().getUrKeyword_3());

					}

				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleKeywordHack"


	// $ANTLR start "entryRuleValidURL"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3089:1: entryRuleValidURL returns [String current=null] : iv_ruleValidURL= ruleValidURL EOF ;
	public final String entryRuleValidURL() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleValidURL = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3090:2: (iv_ruleValidURL= ruleValidURL EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3091:2: iv_ruleValidURL= ruleValidURL EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getValidURLRule());
				}
				pushFollow(FOLLOW_ruleValidURL_in_entryRuleValidURL7105);
				iv_ruleValidURL = ruleValidURL();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleValidURL.getText();
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleValidURL7116);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleValidURL"


	// $ANTLR start "ruleValidURL"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3098:1: ruleValidURL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CSSSTRING_0=
	// RULE_CSSSTRING | (this_ValidURLSymbol_1= ruleValidURLSymbol | this_KeywordHack_2= ruleKeywordHack | this_ONE_HEX_LETTER_3= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_4= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_5= RULE_ONE_INT | kw= '\\\\ ' | kw=
	// '\\\\(' | kw= '\\\\)' | kw= '\\\\\\'' | kw= '\\\\\"' | (this_PERCENT_11= RULE_PERCENT (this_ONE_INT_12= RULE_ONE_INT | this_ONE_HEX_LETTER_13= RULE_ONE_HEX_LETTER ) (this_ONE_INT_14= RULE_ONE_INT | this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER ) ) )+ ) ;
	public final AntlrDatatypeRuleToken ruleValidURL() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_CSSSTRING_0 = null;
		Token this_ONE_HEX_LETTER_3 = null;
		Token this_ONE_NON_HEX_LETTER_4 = null;
		Token this_ONE_INT_5 = null;
		Token kw = null;
		Token this_PERCENT_11 = null;
		Token this_ONE_INT_12 = null;
		Token this_ONE_HEX_LETTER_13 = null;
		Token this_ONE_INT_14 = null;
		Token this_ONE_HEX_LETTER_15 = null;
		AntlrDatatypeRuleToken this_ValidURLSymbol_1 = null;

		AntlrDatatypeRuleToken this_KeywordHack_2 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3101:28: ( (this_CSSSTRING_0= RULE_CSSSTRING | (this_ValidURLSymbol_1= ruleValidURLSymbol | this_KeywordHack_2=
			// ruleKeywordHack | this_ONE_HEX_LETTER_3= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_4= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_5= RULE_ONE_INT | kw= '\\\\ ' | kw= '\\\\(' | kw= '\\\\)' | kw= '\\\\\\'' | kw= '\\\\\"' | (this_PERCENT_11=
			// RULE_PERCENT (this_ONE_INT_12= RULE_ONE_INT | this_ONE_HEX_LETTER_13= RULE_ONE_HEX_LETTER ) (this_ONE_INT_14= RULE_ONE_INT | this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER ) ) )+ ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3102:1: (this_CSSSTRING_0= RULE_CSSSTRING | (this_ValidURLSymbol_1= ruleValidURLSymbol | this_KeywordHack_2=
			// ruleKeywordHack | this_ONE_HEX_LETTER_3= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_4= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_5= RULE_ONE_INT | kw= '\\\\ ' | kw= '\\\\(' | kw= '\\\\)' | kw= '\\\\\\'' | kw= '\\\\\"' | (this_PERCENT_11=
			// RULE_PERCENT (this_ONE_INT_12= RULE_ONE_INT | this_ONE_HEX_LETTER_13= RULE_ONE_HEX_LETTER ) (this_ONE_INT_14= RULE_ONE_INT | this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER ) ) )+ )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3102:1: (this_CSSSTRING_0= RULE_CSSSTRING | (this_ValidURLSymbol_1= ruleValidURLSymbol | this_KeywordHack_2=
				// ruleKeywordHack | this_ONE_HEX_LETTER_3= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_4= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_5= RULE_ONE_INT | kw= '\\\\ ' | kw= '\\\\(' | kw= '\\\\)' | kw= '\\\\\\'' | kw= '\\\\\"' | (this_PERCENT_11=
				// RULE_PERCENT (this_ONE_INT_12= RULE_ONE_INT | this_ONE_HEX_LETTER_13= RULE_ONE_HEX_LETTER ) (this_ONE_INT_14= RULE_ONE_INT | this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER ) ) )+ )
				int alt72 = 2;
				int LA72_0 = input.LA(1);

				if ((LA72_0 == RULE_CSSSTRING)) {
					alt72 = 1;
				} else if (((LA72_0 >= RULE_COLON && LA72_0 <= RULE_PERCENT) || LA72_0 == RULE_HASHMARK || (LA72_0 >= RULE_PLUS && LA72_0 <= RULE_ONE_INT) || LA72_0 == 22 || LA72_0 == 35 || (LA72_0 >= 39 && LA72_0 <= 42) || LA72_0 == 48
						|| (LA72_0 >= 50 && LA72_0 <= 64))) {
					alt72 = 2;
				} else {
					if (state.backtracking > 0) {
						state.failed = true;
						return current;
					}
					NoViableAltException nvae = new NoViableAltException("", 72, 0, input);

					throw nvae;
				}
				switch (alt72) {
				case 1:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3102:6: this_CSSSTRING_0= RULE_CSSSTRING
				{
					this_CSSSTRING_0 = (Token) match(input, RULE_CSSSTRING, FOLLOW_RULE_CSSSTRING_in_ruleValidURL7156);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(this_CSSSTRING_0);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_CSSSTRING_0, grammarAccess.getValidURLAccess().getCSSSTRINGTerminalRuleCall_0());

					}

				}
					break;
				case 2:
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3110:6: (this_ValidURLSymbol_1= ruleValidURLSymbol | this_KeywordHack_2= ruleKeywordHack |
				// this_ONE_HEX_LETTER_3= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_4= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_5= RULE_ONE_INT | kw= '\\\\ ' | kw= '\\\\(' | kw= '\\\\)' | kw= '\\\\\\'' | kw= '\\\\\"' | (this_PERCENT_11= RULE_PERCENT
				// (this_ONE_INT_12= RULE_ONE_INT | this_ONE_HEX_LETTER_13= RULE_ONE_HEX_LETTER ) (this_ONE_INT_14= RULE_ONE_INT | this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER ) ) )+
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3110:6: (this_ValidURLSymbol_1= ruleValidURLSymbol | this_KeywordHack_2= ruleKeywordHack |
					// this_ONE_HEX_LETTER_3= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_4= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_5= RULE_ONE_INT | kw= '\\\\ ' | kw= '\\\\(' | kw= '\\\\)' | kw= '\\\\\\'' | kw= '\\\\\"' | (this_PERCENT_11= RULE_PERCENT
					// (this_ONE_INT_12= RULE_ONE_INT | this_ONE_HEX_LETTER_13= RULE_ONE_HEX_LETTER ) (this_ONE_INT_14= RULE_ONE_INT | this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER ) ) )+
					int cnt71 = 0;
					loop71: do {
						int alt71 = 12;
						switch (input.LA(1)) {
						case RULE_COLON:
						case RULE_COMMA:
						case RULE_HASHMARK:
						case RULE_PLUS:
						case RULE_DASH:
						case RULE_UNDERSCORE:
						case 22:
						case 35:
						case 39:
						case 40:
						case 41:
						case 42:
						case 48:
						case 50:
						case 51:
						case 52:
						case 53:
						case 54:
						case 55: {
							alt71 = 1;
						}
							break;
						case 56:
						case 57:
						case 58:
						case 59: {
							alt71 = 2;
						}
							break;
						case RULE_ONE_HEX_LETTER: {
							alt71 = 3;
						}
							break;
						case RULE_ONE_NON_HEX_LETTER: {
							alt71 = 4;
						}
							break;
						case RULE_ONE_INT: {
							alt71 = 5;
						}
							break;
						case 60: {
							alt71 = 6;
						}
							break;
						case 61: {
							alt71 = 7;
						}
							break;
						case 62: {
							alt71 = 8;
						}
							break;
						case 63: {
							alt71 = 9;
						}
							break;
						case 64: {
							alt71 = 10;
						}
							break;
						case RULE_PERCENT: {
							alt71 = 11;
						}
							break;

						}

						switch (alt71) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3111:5: this_ValidURLSymbol_1= ruleValidURLSymbol
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getValidURLAccess().getValidURLSymbolParserRuleCall_1_0());

							}
							pushFollow(FOLLOW_ruleValidURLSymbol_in_ruleValidURL7190);
							this_ValidURLSymbol_1 = ruleValidURLSymbol();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								current.merge(this_ValidURLSymbol_1);

							}
							if (state.backtracking == 0) {

								afterParserOrEnumRuleCall();

							}

						}
							break;
						case 2:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3123:5: this_KeywordHack_2= ruleKeywordHack
						{
							if (state.backtracking == 0) {

								newCompositeNode(grammarAccess.getValidURLAccess().getKeywordHackParserRuleCall_1_1());

							}
							pushFollow(FOLLOW_ruleKeywordHack_in_ruleValidURL7223);
							this_KeywordHack_2 = ruleKeywordHack();

							state._fsp--;
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								current.merge(this_KeywordHack_2);

							}
							if (state.backtracking == 0) {

								afterParserOrEnumRuleCall();

							}

						}
							break;
						case 3:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3134:10: this_ONE_HEX_LETTER_3= RULE_ONE_HEX_LETTER
						{
							this_ONE_HEX_LETTER_3 = (Token) match(input, RULE_ONE_HEX_LETTER, FOLLOW_RULE_ONE_HEX_LETTER_in_ruleValidURL7249);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								current.merge(this_ONE_HEX_LETTER_3);

							}
							if (state.backtracking == 0) {

								newLeafNode(this_ONE_HEX_LETTER_3, grammarAccess.getValidURLAccess().getONE_HEX_LETTERTerminalRuleCall_1_2());

							}

						}
							break;
						case 4:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3142:10: this_ONE_NON_HEX_LETTER_4= RULE_ONE_NON_HEX_LETTER
						{
							this_ONE_NON_HEX_LETTER_4 = (Token) match(input, RULE_ONE_NON_HEX_LETTER, FOLLOW_RULE_ONE_NON_HEX_LETTER_in_ruleValidURL7275);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								current.merge(this_ONE_NON_HEX_LETTER_4);

							}
							if (state.backtracking == 0) {

								newLeafNode(this_ONE_NON_HEX_LETTER_4, grammarAccess.getValidURLAccess().getONE_NON_HEX_LETTERTerminalRuleCall_1_3());

							}

						}
							break;
						case 5:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3150:10: this_ONE_INT_5= RULE_ONE_INT
						{
							this_ONE_INT_5 = (Token) match(input, RULE_ONE_INT, FOLLOW_RULE_ONE_INT_in_ruleValidURL7301);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								current.merge(this_ONE_INT_5);

							}
							if (state.backtracking == 0) {

								newLeafNode(this_ONE_INT_5, grammarAccess.getValidURLAccess().getONE_INTTerminalRuleCall_1_4());

							}

						}
							break;
						case 6:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3159:2: kw= '\\\\ '
						{
							kw = (Token) match(input, 60, FOLLOW_60_in_ruleValidURL7325);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								current.merge(kw);
								newLeafNode(kw, grammarAccess.getValidURLAccess().getReverseSolidusSpaceKeyword_1_5());

							}

						}
							break;
						case 7:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3166:2: kw= '\\\\('
						{
							kw = (Token) match(input, 61, FOLLOW_61_in_ruleValidURL7344);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								current.merge(kw);
								newLeafNode(kw, grammarAccess.getValidURLAccess().getReverseSolidusLeftParenthesisKeyword_1_6());

							}

						}
							break;
						case 8:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3173:2: kw= '\\\\)'
						{
							kw = (Token) match(input, 62, FOLLOW_62_in_ruleValidURL7363);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								current.merge(kw);
								newLeafNode(kw, grammarAccess.getValidURLAccess().getReverseSolidusRightParenthesisKeyword_1_7());

							}

						}
							break;
						case 9:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3180:2: kw= '\\\\\\''
						{
							kw = (Token) match(input, 63, FOLLOW_63_in_ruleValidURL7382);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								current.merge(kw);
								newLeafNode(kw, grammarAccess.getValidURLAccess().getReverseSolidusApostropheKeyword_1_8());

							}

						}
							break;
						case 10:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3187:2: kw= '\\\\\"'
						{
							kw = (Token) match(input, 64, FOLLOW_64_in_ruleValidURL7401);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								current.merge(kw);
								newLeafNode(kw, grammarAccess.getValidURLAccess().getReverseSolidusQuotationMarkKeyword_1_9());

							}

						}
							break;
						case 11:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3193:6: (this_PERCENT_11= RULE_PERCENT (this_ONE_INT_12= RULE_ONE_INT | this_ONE_HEX_LETTER_13=
						// RULE_ONE_HEX_LETTER ) (this_ONE_INT_14= RULE_ONE_INT | this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER ) )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3193:6: (this_PERCENT_11= RULE_PERCENT (this_ONE_INT_12= RULE_ONE_INT | this_ONE_HEX_LETTER_13=
							// RULE_ONE_HEX_LETTER ) (this_ONE_INT_14= RULE_ONE_INT | this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER ) )
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3193:11: this_PERCENT_11= RULE_PERCENT (this_ONE_INT_12= RULE_ONE_INT | this_ONE_HEX_LETTER_13=
							// RULE_ONE_HEX_LETTER ) (this_ONE_INT_14= RULE_ONE_INT | this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER )
							{
								this_PERCENT_11 = (Token) match(input, RULE_PERCENT, FOLLOW_RULE_PERCENT_in_ruleValidURL7423);
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									current.merge(this_PERCENT_11);

								}
								if (state.backtracking == 0) {

									newLeafNode(this_PERCENT_11, grammarAccess.getValidURLAccess().getPERCENTTerminalRuleCall_1_10_0());

								}
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3200:1: (this_ONE_INT_12= RULE_ONE_INT | this_ONE_HEX_LETTER_13= RULE_ONE_HEX_LETTER )
								int alt69 = 2;
								int LA69_0 = input.LA(1);

								if ((LA69_0 == RULE_ONE_INT)) {
									alt69 = 1;
								} else if ((LA69_0 == RULE_ONE_HEX_LETTER)) {
									alt69 = 2;
								} else {
									if (state.backtracking > 0) {
										state.failed = true;
										return current;
									}
									NoViableAltException nvae = new NoViableAltException("", 69, 0, input);

									throw nvae;
								}
								switch (alt69) {
								case 1:
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3200:6: this_ONE_INT_12= RULE_ONE_INT
								{
									this_ONE_INT_12 = (Token) match(input, RULE_ONE_INT, FOLLOW_RULE_ONE_INT_in_ruleValidURL7444);
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										current.merge(this_ONE_INT_12);

									}
									if (state.backtracking == 0) {

										newLeafNode(this_ONE_INT_12, grammarAccess.getValidURLAccess().getONE_INTTerminalRuleCall_1_10_1_0());

									}

								}
									break;
								case 2:
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3208:10: this_ONE_HEX_LETTER_13= RULE_ONE_HEX_LETTER
								{
									this_ONE_HEX_LETTER_13 = (Token) match(input, RULE_ONE_HEX_LETTER, FOLLOW_RULE_ONE_HEX_LETTER_in_ruleValidURL7470);
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										current.merge(this_ONE_HEX_LETTER_13);

									}
									if (state.backtracking == 0) {

										newLeafNode(this_ONE_HEX_LETTER_13, grammarAccess.getValidURLAccess().getONE_HEX_LETTERTerminalRuleCall_1_10_1_1());

									}

								}
									break;

								}

								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3215:2: (this_ONE_INT_14= RULE_ONE_INT | this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER )
								int alt70 = 2;
								int LA70_0 = input.LA(1);

								if ((LA70_0 == RULE_ONE_INT)) {
									alt70 = 1;
								} else if ((LA70_0 == RULE_ONE_HEX_LETTER)) {
									alt70 = 2;
								} else {
									if (state.backtracking > 0) {
										state.failed = true;
										return current;
									}
									NoViableAltException nvae = new NoViableAltException("", 70, 0, input);

									throw nvae;
								}
								switch (alt70) {
								case 1:
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3215:7: this_ONE_INT_14= RULE_ONE_INT
								{
									this_ONE_INT_14 = (Token) match(input, RULE_ONE_INT, FOLLOW_RULE_ONE_INT_in_ruleValidURL7492);
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										current.merge(this_ONE_INT_14);

									}
									if (state.backtracking == 0) {

										newLeafNode(this_ONE_INT_14, grammarAccess.getValidURLAccess().getONE_INTTerminalRuleCall_1_10_2_0());

									}

								}
									break;
								case 2:
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3223:10: this_ONE_HEX_LETTER_15= RULE_ONE_HEX_LETTER
								{
									this_ONE_HEX_LETTER_15 = (Token) match(input, RULE_ONE_HEX_LETTER, FOLLOW_RULE_ONE_HEX_LETTER_in_ruleValidURL7518);
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										current.merge(this_ONE_HEX_LETTER_15);

									}
									if (state.backtracking == 0) {

										newLeafNode(this_ONE_HEX_LETTER_15, grammarAccess.getValidURLAccess().getONE_HEX_LETTERTerminalRuleCall_1_10_2_1());

									}

								}
									break;

								}


							}


						}
							break;

						default:
							if (cnt71 >= 1)
								break loop71;
							if (state.backtracking > 0) {
								state.failed = true;
								return current;
							}
							EarlyExitException eee = new EarlyExitException(71, input);
							throw eee;
						}
						cnt71++;
					} while (true);


				}
					break;

				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleValidURL"


	// $ANTLR start "entryRuleIdentifier"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3238:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
	public final String entryRuleIdentifier() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleIdentifier = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3239:2: (iv_ruleIdentifier= ruleIdentifier EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3240:2: iv_ruleIdentifier= ruleIdentifier EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getIdentifierRule());
				}
				pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier7568);
				iv_ruleIdentifier = ruleIdentifier();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleIdentifier.getText();
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleIdentifier7579);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleIdentifier"


	// $ANTLR start "ruleIdentifier"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3247:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_DASH_0= RULE_DASH
	// )? (this_UNDERSCORE_1= RULE_UNDERSCORE | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_3= RULE_ONE_NON_HEX_LETTER | this_KeywordHack_4= ruleKeywordHack ) ( ( ( RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER |
	// RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT | ruleKeywordHack ) )=> (this_UNDERSCORE_5= RULE_UNDERSCORE | this_DASH_6= RULE_DASH | this_ONE_HEX_LETTER_7= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_9= RULE_ONE_INT
	// | this_KeywordHack_10= ruleKeywordHack ) )* ) ;
	public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_DASH_0 = null;
		Token this_UNDERSCORE_1 = null;
		Token this_ONE_HEX_LETTER_2 = null;
		Token this_ONE_NON_HEX_LETTER_3 = null;
		Token this_UNDERSCORE_5 = null;
		Token this_DASH_6 = null;
		Token this_ONE_HEX_LETTER_7 = null;
		Token this_ONE_NON_HEX_LETTER_8 = null;
		Token this_ONE_INT_9 = null;
		AntlrDatatypeRuleToken this_KeywordHack_4 = null;

		AntlrDatatypeRuleToken this_KeywordHack_10 = null;


		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3250:28: ( ( (this_DASH_0= RULE_DASH )? (this_UNDERSCORE_1= RULE_UNDERSCORE | this_ONE_HEX_LETTER_2=
			// RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_3= RULE_ONE_NON_HEX_LETTER | this_KeywordHack_4= ruleKeywordHack ) ( ( ( RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT | ruleKeywordHack ) )=>
			// (this_UNDERSCORE_5= RULE_UNDERSCORE | this_DASH_6= RULE_DASH | this_ONE_HEX_LETTER_7= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_9= RULE_ONE_INT | this_KeywordHack_10= ruleKeywordHack ) )* ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3251:1: ( (this_DASH_0= RULE_DASH )? (this_UNDERSCORE_1= RULE_UNDERSCORE | this_ONE_HEX_LETTER_2=
			// RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_3= RULE_ONE_NON_HEX_LETTER | this_KeywordHack_4= ruleKeywordHack ) ( ( ( RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT | ruleKeywordHack ) )=>
			// (this_UNDERSCORE_5= RULE_UNDERSCORE | this_DASH_6= RULE_DASH | this_ONE_HEX_LETTER_7= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_9= RULE_ONE_INT | this_KeywordHack_10= ruleKeywordHack ) )* )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3251:1: ( (this_DASH_0= RULE_DASH )? (this_UNDERSCORE_1= RULE_UNDERSCORE | this_ONE_HEX_LETTER_2=
				// RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_3= RULE_ONE_NON_HEX_LETTER | this_KeywordHack_4= ruleKeywordHack ) ( ( ( RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT | ruleKeywordHack ) )=>
				// (this_UNDERSCORE_5= RULE_UNDERSCORE | this_DASH_6= RULE_DASH | this_ONE_HEX_LETTER_7= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_9= RULE_ONE_INT | this_KeywordHack_10= ruleKeywordHack ) )* )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3251:2: (this_DASH_0= RULE_DASH )? (this_UNDERSCORE_1= RULE_UNDERSCORE | this_ONE_HEX_LETTER_2=
				// RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_3= RULE_ONE_NON_HEX_LETTER | this_KeywordHack_4= ruleKeywordHack ) ( ( ( RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT | ruleKeywordHack ) )=>
				// (this_UNDERSCORE_5= RULE_UNDERSCORE | this_DASH_6= RULE_DASH | this_ONE_HEX_LETTER_7= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_9= RULE_ONE_INT | this_KeywordHack_10= ruleKeywordHack ) )*
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3251:2: (this_DASH_0= RULE_DASH )?
					int alt73 = 2;
					int LA73_0 = input.LA(1);

					if ((LA73_0 == RULE_DASH)) {
						alt73 = 1;
					}
					switch (alt73) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3251:7: this_DASH_0= RULE_DASH
					{
						this_DASH_0 = (Token) match(input, RULE_DASH, FOLLOW_RULE_DASH_in_ruleIdentifier7620);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							current.merge(this_DASH_0);

						}
						if (state.backtracking == 0) {

							newLeafNode(this_DASH_0, grammarAccess.getIdentifierAccess().getDASHTerminalRuleCall_0());

						}

					}
						break;

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3258:3: (this_UNDERSCORE_1= RULE_UNDERSCORE | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER |
					// this_ONE_NON_HEX_LETTER_3= RULE_ONE_NON_HEX_LETTER | this_KeywordHack_4= ruleKeywordHack )
					int alt74 = 4;
					switch (input.LA(1)) {
					case RULE_UNDERSCORE: {
						alt74 = 1;
					}
						break;
					case RULE_ONE_HEX_LETTER: {
						alt74 = 2;
					}
						break;
					case RULE_ONE_NON_HEX_LETTER: {
						alt74 = 3;
					}
						break;
					case 56:
					case 57:
					case 58:
					case 59: {
						alt74 = 4;
					}
						break;
					default:
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 74, 0, input);

						throw nvae;
					}

					switch (alt74) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3258:8: this_UNDERSCORE_1= RULE_UNDERSCORE
					{
						this_UNDERSCORE_1 = (Token) match(input, RULE_UNDERSCORE, FOLLOW_RULE_UNDERSCORE_in_ruleIdentifier7643);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							current.merge(this_UNDERSCORE_1);

						}
						if (state.backtracking == 0) {

							newLeafNode(this_UNDERSCORE_1, grammarAccess.getIdentifierAccess().getUNDERSCORETerminalRuleCall_1_0());

						}

					}
						break;
					case 2:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3266:10: this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER
					{
						this_ONE_HEX_LETTER_2 = (Token) match(input, RULE_ONE_HEX_LETTER, FOLLOW_RULE_ONE_HEX_LETTER_in_ruleIdentifier7669);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							current.merge(this_ONE_HEX_LETTER_2);

						}
						if (state.backtracking == 0) {

							newLeafNode(this_ONE_HEX_LETTER_2, grammarAccess.getIdentifierAccess().getONE_HEX_LETTERTerminalRuleCall_1_1());

						}

					}
						break;
					case 3:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3274:10: this_ONE_NON_HEX_LETTER_3= RULE_ONE_NON_HEX_LETTER
					{
						this_ONE_NON_HEX_LETTER_3 = (Token) match(input, RULE_ONE_NON_HEX_LETTER, FOLLOW_RULE_ONE_NON_HEX_LETTER_in_ruleIdentifier7695);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							current.merge(this_ONE_NON_HEX_LETTER_3);

						}
						if (state.backtracking == 0) {

							newLeafNode(this_ONE_NON_HEX_LETTER_3, grammarAccess.getIdentifierAccess().getONE_NON_HEX_LETTERTerminalRuleCall_1_2());

						}

					}
						break;
					case 4:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3283:5: this_KeywordHack_4= ruleKeywordHack
					{
						if (state.backtracking == 0) {

							newCompositeNode(grammarAccess.getIdentifierAccess().getKeywordHackParserRuleCall_1_3());

						}
						pushFollow(FOLLOW_ruleKeywordHack_in_ruleIdentifier7728);
						this_KeywordHack_4 = ruleKeywordHack();

						state._fsp--;
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							current.merge(this_KeywordHack_4);

						}
						if (state.backtracking == 0) {

							afterParserOrEnumRuleCall();

						}

					}
						break;

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3293:2: ( ( ( RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT |
					// ruleKeywordHack ) )=> (this_UNDERSCORE_5= RULE_UNDERSCORE | this_DASH_6= RULE_DASH | this_ONE_HEX_LETTER_7= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_9= RULE_ONE_INT | this_KeywordHack_10=
					// ruleKeywordHack ) )*
					loop76: do {
						int alt76 = 2;
						alt76 = dfa76.predict(input);
						switch (alt76) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3293:3: ( ( RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT
						// | ruleKeywordHack ) )=> (this_UNDERSCORE_5= RULE_UNDERSCORE | this_DASH_6= RULE_DASH | this_ONE_HEX_LETTER_7= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_9= RULE_ONE_INT |
						// this_KeywordHack_10= ruleKeywordHack )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3298:26: (this_UNDERSCORE_5= RULE_UNDERSCORE | this_DASH_6= RULE_DASH | this_ONE_HEX_LETTER_7=
							// RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_9= RULE_ONE_INT | this_KeywordHack_10= ruleKeywordHack )
							int alt75 = 6;
							switch (input.LA(1)) {
							case RULE_UNDERSCORE: {
								alt75 = 1;
							}
								break;
							case RULE_DASH: {
								alt75 = 2;
							}
								break;
							case RULE_ONE_HEX_LETTER: {
								alt75 = 3;
							}
								break;
							case RULE_ONE_NON_HEX_LETTER: {
								alt75 = 4;
							}
								break;
							case RULE_ONE_INT: {
								alt75 = 5;
							}
								break;
							case 56:
							case 57:
							case 58:
							case 59: {
								alt75 = 6;
							}
								break;
							default:
								if (state.backtracking > 0) {
									state.failed = true;
									return current;
								}
								NoViableAltException nvae = new NoViableAltException("", 75, 0, input);

								throw nvae;
							}

							switch (alt75) {
							case 1:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3298:31: this_UNDERSCORE_5= RULE_UNDERSCORE
							{
								this_UNDERSCORE_5 = (Token) match(input, RULE_UNDERSCORE, FOLLOW_RULE_UNDERSCORE_in_ruleIdentifier7798);
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									current.merge(this_UNDERSCORE_5);

								}
								if (state.backtracking == 0) {

									newLeafNode(this_UNDERSCORE_5, grammarAccess.getIdentifierAccess().getUNDERSCORETerminalRuleCall_2_0_0());

								}

							}
								break;
							case 2:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3306:10: this_DASH_6= RULE_DASH
							{
								this_DASH_6 = (Token) match(input, RULE_DASH, FOLLOW_RULE_DASH_in_ruleIdentifier7824);
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									current.merge(this_DASH_6);

								}
								if (state.backtracking == 0) {

									newLeafNode(this_DASH_6, grammarAccess.getIdentifierAccess().getDASHTerminalRuleCall_2_0_1());

								}

							}
								break;
							case 3:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3314:10: this_ONE_HEX_LETTER_7= RULE_ONE_HEX_LETTER
							{
								this_ONE_HEX_LETTER_7 = (Token) match(input, RULE_ONE_HEX_LETTER, FOLLOW_RULE_ONE_HEX_LETTER_in_ruleIdentifier7850);
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									current.merge(this_ONE_HEX_LETTER_7);

								}
								if (state.backtracking == 0) {

									newLeafNode(this_ONE_HEX_LETTER_7, grammarAccess.getIdentifierAccess().getONE_HEX_LETTERTerminalRuleCall_2_0_2());

								}

							}
								break;
							case 4:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3322:10: this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER
							{
								this_ONE_NON_HEX_LETTER_8 = (Token) match(input, RULE_ONE_NON_HEX_LETTER, FOLLOW_RULE_ONE_NON_HEX_LETTER_in_ruleIdentifier7876);
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									current.merge(this_ONE_NON_HEX_LETTER_8);

								}
								if (state.backtracking == 0) {

									newLeafNode(this_ONE_NON_HEX_LETTER_8, grammarAccess.getIdentifierAccess().getONE_NON_HEX_LETTERTerminalRuleCall_2_0_3());

								}

							}
								break;
							case 5:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3330:10: this_ONE_INT_9= RULE_ONE_INT
							{
								this_ONE_INT_9 = (Token) match(input, RULE_ONE_INT, FOLLOW_RULE_ONE_INT_in_ruleIdentifier7902);
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									current.merge(this_ONE_INT_9);

								}
								if (state.backtracking == 0) {

									newLeafNode(this_ONE_INT_9, grammarAccess.getIdentifierAccess().getONE_INTTerminalRuleCall_2_0_4());

								}

							}
								break;
							case 6:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3339:5: this_KeywordHack_10= ruleKeywordHack
							{
								if (state.backtracking == 0) {

									newCompositeNode(grammarAccess.getIdentifierAccess().getKeywordHackParserRuleCall_2_0_5());

								}
								pushFollow(FOLLOW_ruleKeywordHack_in_ruleIdentifier7935);
								this_KeywordHack_10 = ruleKeywordHack();

								state._fsp--;
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									current.merge(this_KeywordHack_10);

								}
								if (state.backtracking == 0) {

									afterParserOrEnumRuleCall();

								}

							}
								break;

							}


						}
							break;

						default:
							break loop76;
						}
					} while (true);


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleIdentifier"


	// $ANTLR start "entryRuleNum"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3357:1: entryRuleNum returns [String current=null] : iv_ruleNum= ruleNum EOF ;
	public final String entryRuleNum() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleNum = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3358:2: (iv_ruleNum= ruleNum EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3359:2: iv_ruleNum= ruleNum EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getNumRule());
				}
				pushFollow(FOLLOW_ruleNum_in_entryRuleNum7984);
				iv_ruleNum = ruleNum();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleNum.getText();
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleNum7995);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleNum"


	// $ANTLR start "ruleNum"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3366:1: ruleNum returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_PLUS_0= RULE_PLUS |
	// this_DASH_1= RULE_DASH )? ( (kw= '.' ( ( RULE_ONE_INT )=>this_ONE_INT_3= RULE_ONE_INT )+ ) | ( ( ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT )+ ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT )=>this_ONE_INT_6= RULE_ONE_INT )+ )? ) ) ) ;
	public final AntlrDatatypeRuleToken ruleNum() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_PLUS_0 = null;
		Token this_DASH_1 = null;
		Token kw = null;
		Token this_ONE_INT_3 = null;
		Token this_ONE_INT_4 = null;
		Token this_ONE_INT_6 = null;

		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3369:28: ( ( (this_PLUS_0= RULE_PLUS | this_DASH_1= RULE_DASH )? ( (kw= '.' ( ( RULE_ONE_INT )=>this_ONE_INT_3=
			// RULE_ONE_INT )+ ) | ( ( ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT )+ ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT )=>this_ONE_INT_6= RULE_ONE_INT )+ )? ) ) ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3370:1: ( (this_PLUS_0= RULE_PLUS | this_DASH_1= RULE_DASH )? ( (kw= '.' ( ( RULE_ONE_INT )=>this_ONE_INT_3=
			// RULE_ONE_INT )+ ) | ( ( ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT )+ ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT )=>this_ONE_INT_6= RULE_ONE_INT )+ )? ) ) )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3370:1: ( (this_PLUS_0= RULE_PLUS | this_DASH_1= RULE_DASH )? ( (kw= '.' ( ( RULE_ONE_INT )=>this_ONE_INT_3=
				// RULE_ONE_INT )+ ) | ( ( ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT )+ ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT )=>this_ONE_INT_6= RULE_ONE_INT )+ )? ) ) )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3370:2: (this_PLUS_0= RULE_PLUS | this_DASH_1= RULE_DASH )? ( (kw= '.' ( ( RULE_ONE_INT )=>this_ONE_INT_3=
				// RULE_ONE_INT )+ ) | ( ( ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT )+ ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT )=>this_ONE_INT_6= RULE_ONE_INT )+ )? ) )
				{
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3370:2: (this_PLUS_0= RULE_PLUS | this_DASH_1= RULE_DASH )?
					int alt77 = 3;
					int LA77_0 = input.LA(1);

					if ((LA77_0 == RULE_PLUS)) {
						alt77 = 1;
					} else if ((LA77_0 == RULE_DASH)) {
						alt77 = 2;
					}
					switch (alt77) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3370:7: this_PLUS_0= RULE_PLUS
					{
						this_PLUS_0 = (Token) match(input, RULE_PLUS, FOLLOW_RULE_PLUS_in_ruleNum8036);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							current.merge(this_PLUS_0);

						}
						if (state.backtracking == 0) {

							newLeafNode(this_PLUS_0, grammarAccess.getNumAccess().getPLUSTerminalRuleCall_0_0());

						}

					}
						break;
					case 2:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3378:10: this_DASH_1= RULE_DASH
					{
						this_DASH_1 = (Token) match(input, RULE_DASH, FOLLOW_RULE_DASH_in_ruleNum8062);
						if (state.failed)
							return current;
						if (state.backtracking == 0) {

							current.merge(this_DASH_1);

						}
						if (state.backtracking == 0) {

							newLeafNode(this_DASH_1, grammarAccess.getNumAccess().getDASHTerminalRuleCall_0_1());

						}

					}
						break;

					}

					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3385:3: ( (kw= '.' ( ( RULE_ONE_INT )=>this_ONE_INT_3= RULE_ONE_INT )+ ) | ( ( ( RULE_ONE_INT
					// )=>this_ONE_INT_4= RULE_ONE_INT )+ ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT )=>this_ONE_INT_6= RULE_ONE_INT )+ )? ) )
					int alt82 = 2;
					int LA82_0 = input.LA(1);

					if ((LA82_0 == 41)) {
						alt82 = 1;
					} else if ((LA82_0 == RULE_ONE_INT)) {
						alt82 = 2;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return current;
						}
						NoViableAltException nvae = new NoViableAltException("", 82, 0, input);

						throw nvae;
					}
					switch (alt82) {
					case 1:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3385:4: (kw= '.' ( ( RULE_ONE_INT )=>this_ONE_INT_3= RULE_ONE_INT )+ )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3385:4: (kw= '.' ( ( RULE_ONE_INT )=>this_ONE_INT_3= RULE_ONE_INT )+ )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3386:2: kw= '.' ( ( RULE_ONE_INT )=>this_ONE_INT_3= RULE_ONE_INT )+
						{
							kw = (Token) match(input, 41, FOLLOW_41_in_ruleNum8084);
							if (state.failed)
								return current;
							if (state.backtracking == 0) {

								current.merge(kw);
								newLeafNode(kw, grammarAccess.getNumAccess().getFullStopKeyword_1_0_0());

							}
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3391:1: ( ( RULE_ONE_INT )=>this_ONE_INT_3= RULE_ONE_INT )+
							int cnt78 = 0;
							loop78: do {
								int alt78 = 2;
								int LA78_0 = input.LA(1);

								if ((LA78_0 == RULE_ONE_INT)) {
									int LA78_2 = input.LA(2);

									if ((synpred3_InternalCSS())) {
										alt78 = 1;
									}


								}


								switch (alt78) {
								case 1:
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3391:2: ( RULE_ONE_INT )=>this_ONE_INT_3= RULE_ONE_INT
								{
									this_ONE_INT_3 = (Token) match(input, RULE_ONE_INT, FOLLOW_RULE_ONE_INT_in_ruleNum8105);
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										current.merge(this_ONE_INT_3);

									}
									if (state.backtracking == 0) {

										newLeafNode(this_ONE_INT_3, grammarAccess.getNumAccess().getONE_INTTerminalRuleCall_1_0_1());

									}

								}
									break;

								default:
									if (cnt78 >= 1)
										break loop78;
									if (state.backtracking > 0) {
										state.failed = true;
										return current;
									}
									EarlyExitException eee = new EarlyExitException(78, input);
									throw eee;
								}
								cnt78++;
							} while (true);


						}


					}
						break;
					case 2:
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3399:6: ( ( ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT )+ ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT
					// )=>this_ONE_INT_6= RULE_ONE_INT )+ )? )
					{
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3399:6: ( ( ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT )+ ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT
						// )=>this_ONE_INT_6= RULE_ONE_INT )+ )? )
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3399:7: ( ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT )+ ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT
						// )=>this_ONE_INT_6= RULE_ONE_INT )+ )?
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3399:7: ( ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT )+
							int cnt79 = 0;
							loop79: do {
								int alt79 = 2;
								int LA79_0 = input.LA(1);

								if ((LA79_0 == RULE_ONE_INT)) {
									int LA79_2 = input.LA(2);

									if ((synpred4_InternalCSS())) {
										alt79 = 1;
									}


								}


								switch (alt79) {
								case 1:
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3399:8: ( RULE_ONE_INT )=>this_ONE_INT_4= RULE_ONE_INT
								{
									this_ONE_INT_4 = (Token) match(input, RULE_ONE_INT, FOLLOW_RULE_ONE_INT_in_ruleNum8141);
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										current.merge(this_ONE_INT_4);

									}
									if (state.backtracking == 0) {

										newLeafNode(this_ONE_INT_4, grammarAccess.getNumAccess().getONE_INTTerminalRuleCall_1_1_0());

									}

								}
									break;

								default:
									if (cnt79 >= 1)
										break loop79;
									if (state.backtracking > 0) {
										state.failed = true;
										return current;
									}
									EarlyExitException eee = new EarlyExitException(79, input);
									throw eee;
								}
								cnt79++;
							} while (true);

							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3406:3: ( ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT )=>this_ONE_INT_6= RULE_ONE_INT )+ )?
							int alt81 = 2;
							int LA81_0 = input.LA(1);

							if ((LA81_0 == 41)) {
								int LA81_1 = input.LA(2);

								if ((LA81_1 == RULE_ONE_INT)) {
									int LA81_3 = input.LA(3);

									if ((synpred5_InternalCSS())) {
										alt81 = 1;
									}
								}
							}
							switch (alt81) {
							case 1:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3406:4: ( ( '.' )=>kw= '.' ) ( ( RULE_ONE_INT )=>this_ONE_INT_6= RULE_ONE_INT )+
							{
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3406:4: ( ( '.' )=>kw= '.' )
								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3406:5: ( '.' )=>kw= '.'
								{
									kw = (Token) match(input, 41, FOLLOW_41_in_ruleNum8171);
									if (state.failed)
										return current;
									if (state.backtracking == 0) {

										current.merge(kw);
										newLeafNode(kw, grammarAccess.getNumAccess().getFullStopKeyword_1_1_1_0());

									}

								}

								// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3414:2: ( ( RULE_ONE_INT )=>this_ONE_INT_6= RULE_ONE_INT )+
								int cnt80 = 0;
								loop80: do {
									int alt80 = 2;
									int LA80_0 = input.LA(1);

									if ((LA80_0 == RULE_ONE_INT)) {
										int LA80_2 = input.LA(2);

										if ((synpred6_InternalCSS())) {
											alt80 = 1;
										}


									}


									switch (alt80) {
									case 1:
									// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3414:3: ( RULE_ONE_INT )=>this_ONE_INT_6= RULE_ONE_INT
									{
										this_ONE_INT_6 = (Token) match(input, RULE_ONE_INT, FOLLOW_RULE_ONE_INT_in_ruleNum8193);
										if (state.failed)
											return current;
										if (state.backtracking == 0) {

											current.merge(this_ONE_INT_6);

										}
										if (state.backtracking == 0) {

											newLeafNode(this_ONE_INT_6, grammarAccess.getNumAccess().getONE_INTTerminalRuleCall_1_1_1_1());

										}

									}
										break;

									default:
										if (cnt80 >= 1)
											break loop80;
										if (state.backtracking > 0) {
											state.failed = true;
											return current;
										}
										EarlyExitException eee = new EarlyExitException(80, input);
										throw eee;
									}
									cnt80++;
								} while (true);


							}
								break;

							}


						}


					}
						break;

					}


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleNum"


	// $ANTLR start "entryRuleHex"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3429:1: entryRuleHex returns [String current=null] : iv_ruleHex= ruleHex EOF ;
	public final String entryRuleHex() throws RecognitionException {
		String current = null;

		AntlrDatatypeRuleToken iv_ruleHex = null;


		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3430:2: (iv_ruleHex= ruleHex EOF )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3431:2: iv_ruleHex= ruleHex EOF
			{
				if (state.backtracking == 0) {
					newCompositeNode(grammarAccess.getHexRule());
				}
				pushFollow(FOLLOW_ruleHex_in_entryRuleHex8245);
				iv_ruleHex = ruleHex();

				state._fsp--;
				if (state.failed)
					return current;
				if (state.backtracking == 0) {
					current = iv_ruleHex.getText();
				}
				match(input, EOF, FOLLOW_EOF_in_entryRuleHex8256);
				if (state.failed)
					return current;

			}

		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "entryRuleHex"


	// $ANTLR start "ruleHex"
	// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3438:1: ruleHex returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HASHMARK_0= RULE_HASHMARK (
	// ( ( RULE_ONE_INT | RULE_ONE_HEX_LETTER ) )=> (this_ONE_INT_1= RULE_ONE_INT | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER ) )+ ) ;
	public final AntlrDatatypeRuleToken ruleHex() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

		Token this_HASHMARK_0 = null;
		Token this_ONE_INT_1 = null;
		Token this_ONE_HEX_LETTER_2 = null;

		enterRule();

		try {
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3441:28: ( (this_HASHMARK_0= RULE_HASHMARK ( ( ( RULE_ONE_INT | RULE_ONE_HEX_LETTER ) )=> (this_ONE_INT_1=
			// RULE_ONE_INT | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER ) )+ ) )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3442:1: (this_HASHMARK_0= RULE_HASHMARK ( ( ( RULE_ONE_INT | RULE_ONE_HEX_LETTER ) )=> (this_ONE_INT_1=
			// RULE_ONE_INT | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER ) )+ )
			{
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3442:1: (this_HASHMARK_0= RULE_HASHMARK ( ( ( RULE_ONE_INT | RULE_ONE_HEX_LETTER ) )=> (this_ONE_INT_1=
				// RULE_ONE_INT | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER ) )+ )
				// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3442:6: this_HASHMARK_0= RULE_HASHMARK ( ( ( RULE_ONE_INT | RULE_ONE_HEX_LETTER ) )=> (this_ONE_INT_1=
				// RULE_ONE_INT | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER ) )+
				{
					this_HASHMARK_0 = (Token) match(input, RULE_HASHMARK, FOLLOW_RULE_HASHMARK_in_ruleHex8296);
					if (state.failed)
						return current;
					if (state.backtracking == 0) {

						current.merge(this_HASHMARK_0);

					}
					if (state.backtracking == 0) {

						newLeafNode(this_HASHMARK_0, grammarAccess.getHexAccess().getHASHMARKTerminalRuleCall_0());

					}
					// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3449:1: ( ( ( RULE_ONE_INT | RULE_ONE_HEX_LETTER ) )=> (this_ONE_INT_1= RULE_ONE_INT |
					// this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER ) )+
					int cnt84 = 0;
					loop84: do {
						int alt84 = 2;
						int LA84_0 = input.LA(1);

						if ((LA84_0 == RULE_ONE_HEX_LETTER)) {
							int LA84_2 = input.LA(2);

							if ((synpred7_InternalCSS())) {
								alt84 = 1;
							}


						} else if ((LA84_0 == RULE_ONE_INT)) {
							int LA84_3 = input.LA(2);

							if ((synpred7_InternalCSS())) {
								alt84 = 1;
							}


						}


						switch (alt84) {
						case 1:
						// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3449:2: ( ( RULE_ONE_INT | RULE_ONE_HEX_LETTER ) )=> (this_ONE_INT_1= RULE_ONE_INT |
						// this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER )
						{
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3450:30: (this_ONE_INT_1= RULE_ONE_INT | this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER )
							int alt83 = 2;
							int LA83_0 = input.LA(1);

							if ((LA83_0 == RULE_ONE_INT)) {
								alt83 = 1;
							} else if ((LA83_0 == RULE_ONE_HEX_LETTER)) {
								alt83 = 2;
							} else {
								if (state.backtracking > 0) {
									state.failed = true;
									return current;
								}
								NoViableAltException nvae = new NoViableAltException("", 83, 0, input);

								throw nvae;
							}
							switch (alt83) {
							case 1:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3450:35: this_ONE_INT_1= RULE_ONE_INT
							{
								this_ONE_INT_1 = (Token) match(input, RULE_ONE_INT, FOLLOW_RULE_ONE_INT_in_ruleHex8333);
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									current.merge(this_ONE_INT_1);

								}
								if (state.backtracking == 0) {

									newLeafNode(this_ONE_INT_1, grammarAccess.getHexAccess().getONE_INTTerminalRuleCall_1_0_0());

								}

							}
								break;
							case 2:
							// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3458:10: this_ONE_HEX_LETTER_2= RULE_ONE_HEX_LETTER
							{
								this_ONE_HEX_LETTER_2 = (Token) match(input, RULE_ONE_HEX_LETTER, FOLLOW_RULE_ONE_HEX_LETTER_in_ruleHex8359);
								if (state.failed)
									return current;
								if (state.backtracking == 0) {

									current.merge(this_ONE_HEX_LETTER_2);

								}
								if (state.backtracking == 0) {

									newLeafNode(this_ONE_HEX_LETTER_2, grammarAccess.getHexAccess().getONE_HEX_LETTERTerminalRuleCall_1_0_1());

								}

							}
								break;

							}


						}
							break;

						default:
							if (cnt84 >= 1)
								break loop84;
							if (state.backtracking > 0) {
								state.failed = true;
								return current;
							}
							EarlyExitException eee = new EarlyExitException(84, input);
							throw eee;
						}
						cnt84++;
					} while (true);


				}


			}

			if (state.backtracking == 0) {
				leaveRule();
			}
		}

		catch (RecognitionException re) {
			recover(input, re);
			appendSkippedTokens();
		} finally {
		}
		return current;
	}
	// $ANTLR end "ruleHex"

	// $ANTLR start synpred1_InternalCSS
	public final void synpred1_InternalCSS_fragment() throws RecognitionException {
		// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1257:7: ( ( ruleSubSelectorForNegation ) )
		// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1258:1: ( ruleSubSelectorForNegation )
		{
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1258:1: ( ruleSubSelectorForNegation )
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:1259:1: ruleSubSelectorForNegation
			{
				pushFollow(FOLLOW_ruleSubSelectorForNegation_in_synpred1_InternalCSS2654);
				ruleSubSelectorForNegation();

				state._fsp--;
				if (state.failed)
					return;

			}


		}
	}
	// $ANTLR end synpred1_InternalCSS

	// $ANTLR start synpred2_InternalCSS
	public final void synpred2_InternalCSS_fragment() throws RecognitionException {
		// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3293:3: ( ( RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT |
		// ruleKeywordHack ) )
		// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3293:4: ( RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT | ruleKeywordHack
		// )
		{
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3293:4: ( RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT |
			// ruleKeywordHack )
			int alt85 = 6;
			switch (input.LA(1)) {
			case RULE_UNDERSCORE: {
				alt85 = 1;
			}
				break;
			case RULE_DASH: {
				alt85 = 2;
			}
				break;
			case RULE_ONE_HEX_LETTER: {
				alt85 = 3;
			}
				break;
			case RULE_ONE_NON_HEX_LETTER: {
				alt85 = 4;
			}
				break;
			case RULE_ONE_INT: {
				alt85 = 5;
			}
				break;
			case 56:
			case 57:
			case 58:
			case 59: {
				alt85 = 6;
			}
				break;
			default:
				if (state.backtracking > 0) {
					state.failed = true;
					return;
				}
				NoViableAltException nvae = new NoViableAltException("", 85, 0, input);

				throw nvae;
			}

			switch (alt85) {
			case 1:
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3293:6: RULE_UNDERSCORE
			{
				match(input, RULE_UNDERSCORE, FOLLOW_RULE_UNDERSCORE_in_synpred2_InternalCSS7747);
				if (state.failed)
					return;

			}
				break;
			case 2:
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3294:7: RULE_DASH
			{
				match(input, RULE_DASH, FOLLOW_RULE_DASH_in_synpred2_InternalCSS7755);
				if (state.failed)
					return;

			}
				break;
			case 3:
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3295:7: RULE_ONE_HEX_LETTER
			{
				match(input, RULE_ONE_HEX_LETTER, FOLLOW_RULE_ONE_HEX_LETTER_in_synpred2_InternalCSS7763);
				if (state.failed)
					return;

			}
				break;
			case 4:
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3296:7: RULE_ONE_NON_HEX_LETTER
			{
				match(input, RULE_ONE_NON_HEX_LETTER, FOLLOW_RULE_ONE_NON_HEX_LETTER_in_synpred2_InternalCSS7771);
				if (state.failed)
					return;

			}
				break;
			case 5:
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3297:7: RULE_ONE_INT
			{
				match(input, RULE_ONE_INT, FOLLOW_RULE_ONE_INT_in_synpred2_InternalCSS7779);
				if (state.failed)
					return;

			}
				break;
			case 6:
			// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3298:7: ruleKeywordHack
			{
				pushFollow(FOLLOW_ruleKeywordHack_in_synpred2_InternalCSS7787);
				ruleKeywordHack();

				state._fsp--;
				if (state.failed)
					return;

			}
				break;

			}


		}
	}
	// $ANTLR end synpred2_InternalCSS

	// $ANTLR start synpred3_InternalCSS
	public final void synpred3_InternalCSS_fragment() throws RecognitionException {
		// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3391:2: ( RULE_ONE_INT )
		// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3391:4: RULE_ONE_INT
		{
			match(input, RULE_ONE_INT, FOLLOW_RULE_ONE_INT_in_synpred3_InternalCSS8096);
			if (state.failed)
				return;

		}
	}
	// $ANTLR end synpred3_InternalCSS

	// $ANTLR start synpred4_InternalCSS
	public final void synpred4_InternalCSS_fragment() throws RecognitionException {
		// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3399:8: ( RULE_ONE_INT )
		// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3399:10: RULE_ONE_INT
		{
			match(input, RULE_ONE_INT, FOLLOW_RULE_ONE_INT_in_synpred4_InternalCSS8132);
			if (state.failed)
				return;

		}
	}
	// $ANTLR end synpred4_InternalCSS

	// $ANTLR start synpred5_InternalCSS
	public final void synpred5_InternalCSS_fragment() throws RecognitionException {
		// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3406:5: ( '.' )
		// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3407:2: '.'
		{
			match(input, 41, FOLLOW_41_in_synpred5_InternalCSS8162);
			if (state.failed)
				return;

		}
	}
	// $ANTLR end synpred5_InternalCSS

	// $ANTLR start synpred6_InternalCSS
	public final void synpred6_InternalCSS_fragment() throws RecognitionException {
		// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3414:3: ( RULE_ONE_INT )
		// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3414:5: RULE_ONE_INT
		{
			match(input, RULE_ONE_INT, FOLLOW_RULE_ONE_INT_in_synpred6_InternalCSS8184);
			if (state.failed)
				return;

		}
	}
	// $ANTLR end synpred6_InternalCSS

	// $ANTLR start synpred7_InternalCSS
	public final void synpred7_InternalCSS_fragment() throws RecognitionException {
		// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3449:2: ( ( RULE_ONE_INT | RULE_ONE_HEX_LETTER ) )
		// ../org.eclipse.papyrus.infra.gmfdiag.css3.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/css3/parser/antlr/internal/InternalCSS.g:3449:3: ( RULE_ONE_INT | RULE_ONE_HEX_LETTER )
		{
			if (input.LA(1) == RULE_ONE_HEX_LETTER || input.LA(1) == RULE_ONE_INT) {
				input.consume();
				state.errorRecovery = false;
				state.failed = false;
			} else {
				if (state.backtracking > 0) {
					state.failed = true;
					return;
				}
				MismatchedSetException mse = new MismatchedSetException(null, input);
				throw mse;
			}


		}
	}
	// $ANTLR end synpred7_InternalCSS

	// Delegated rules

	public final boolean synpred4_InternalCSS() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_InternalCSS_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed = false;
		return success;
	}

	public final boolean synpred6_InternalCSS() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred6_InternalCSS_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed = false;
		return success;
	}

	public final boolean synpred5_InternalCSS() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred5_InternalCSS_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed = false;
		return success;
	}

	public final boolean synpred1_InternalCSS() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_InternalCSS_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed = false;
		return success;
	}

	public final boolean synpred2_InternalCSS() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_InternalCSS_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed = false;
		return success;
	}

	public final boolean synpred3_InternalCSS() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_InternalCSS_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed = false;
		return success;
	}

	public final boolean synpred7_InternalCSS() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred7_InternalCSS_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed = false;
		return success;
	}


	protected DFA29 dfa29 = new DFA29(this);
	protected DFA38 dfa38 = new DFA38(this);
	protected DFA39 dfa39 = new DFA39(this);
	protected DFA44 dfa44 = new DFA44(this);
	protected DFA58 dfa58 = new DFA58(this);
	protected DFA76 dfa76 = new DFA76(this);
	static final String DFA29_eotS = "\4\uffff";
	static final String DFA29_eofS = "\4\uffff";
	static final String DFA29_minS = "\2\6\2\uffff";
	static final String DFA29_maxS = "\2\33\2\uffff";
	static final String DFA29_acceptS = "\2\uffff\1\2\1\1";
	static final String DFA29_specialS = "\4\uffff}>";
	static final String[] DFA29_transitionS = {
			"\1\3\1\uffff\1\1\22\uffff\1\2",
			"\1\3\1\uffff\1\1\22\uffff\1\2",
			"",
			""
	};

	static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
	static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
	static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
	static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
	static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
	static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
	static final short[][] DFA29_transition;

	static {
		int numStates = DFA29_transitionS.length;
		DFA29_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
		}
	}

	class DFA29 extends DFA {

		public DFA29(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 29;
			this.eot = DFA29_eot;
			this.eof = DFA29_eof;
			this.min = DFA29_min;
			this.max = DFA29_max;
			this.accept = DFA29_accept;
			this.special = DFA29_special;
			this.transition = DFA29_transition;
		}

		public String getDescription() {
			return "()* loopback of 974:2: ( (this_WS_1= RULE_WS )* this_COMMA_2= RULE_COMMA ( (lv_selectors_3_0= ruleselector ) ) )*";
		}
	}

	static final String DFA38_eotS = "\5\uffff";
	static final String DFA38_eofS = "\1\3\4\uffff";
	static final String DFA38_minS = "\1\6\1\uffff\1\5\2\uffff";
	static final String DFA38_maxS = "\1\60\1\uffff\1\73\2\uffff";
	static final String DFA38_acceptS = "\1\uffff\1\1\1\uffff\1\3\1\2";
	static final String DFA38_specialS = "\5\uffff}>";
	static final String[] DFA38_transitionS = {
			"\1\3\1\uffff\1\2\4\uffff\1\1\15\uffff\1\3\23\uffff\2\1",
			"",
			"\1\4\1\3\1\uffff\1\2\2\uffff\1\4\1\uffff\5\4\11\uffff\1\3" +
					"\7\uffff\1\4\5\uffff\3\4\3\uffff\2\4\7\uffff\4\4",
			"",
			""
	};

	static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
	static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
	static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
	static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
	static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
	static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
	static final short[][] DFA38_transition;

	static {
		int numStates = DFA38_transitionS.length;
		DFA38_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
		}
	}

	class DFA38 extends DFA {

		public DFA38(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 38;
			this.eot = DFA38_eot;
			this.eof = DFA38_eof;
			this.min = DFA38_min;
			this.max = DFA38_max;
			this.accept = DFA38_accept;
			this.special = DFA38_special;
			this.transition = DFA38_transition;
		}

		public String getDescription() {
			return "1095:2: ( ( ( (lv_combinator_1_0= rulecombinator ) ) (this_WS_2= RULE_WS )* ( (lv_selector_3_0= ruleselector ) ) ) | ( (this_WS_4= RULE_WS )+ ( ( (lv_combinator_5_0= rulecombinator ) ) (this_WS_6= RULE_WS )* )? ( (lv_selector_7_0= ruleselector ) ) ) )?";
		}
	}

	static final String DFA39_eotS = "\24\uffff";
	static final String DFA39_eofS = "\2\uffff\7\23\1\uffff\11\23\1\uffff";
	static final String DFA39_minS = "\1\16\1\17\7\5\1\uffff\11\5\1\uffff";
	static final String DFA39_maxS = "\11\73\1\uffff\11\73\1\uffff";
	static final String DFA39_acceptS = "\11\uffff\1\2\11\uffff\1\1";
	static final String DFA39_specialS = "\24\uffff}>";
	static final String[] DFA39_transitionS = {
			"\1\1\1\2\1\3\1\4\30\uffff\2\11\14\uffff\1\5\1\6\1\7\1\10",
			"\1\2\1\3\1\4\46\uffff\1\5\1\6\1\7\1\10",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff" +
					"\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21" +
					"\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff" +
					"\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21" +
					"\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff" +
					"\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21" +
					"\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff" +
					"\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21" +
					"\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff" +
					"\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21" +
					"\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff" +
					"\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21" +
					"\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff" +
					"\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21" +
					"\1\22",
			"",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff" +
					"\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21" +
					"\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff" +
					"\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21" +
					"\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff" +
					"\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21" +
					"\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff" +
					"\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21" +
					"\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff" +
					"\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21" +
					"\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff" +
					"\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21" +
					"\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff" +
					"\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21" +
					"\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff" +
					"\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21" +
					"\1\22",
			"\1\23\5\uffff\1\23\2\uffff\1\13\1\12\1\14\1\15\1\16\20\uffff" +
					"\1\23\5\uffff\1\23\1\uffff\1\11\1\23\13\uffff\1\17\1\20\1\21" +
					"\1\22",
			""
	};

	static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
	static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
	static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
	static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
	static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
	static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
	static final short[][] DFA39_transition;

	static {
		int numStates = DFA39_transitionS.length;
		DFA39_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
		}
	}

	class DFA39 extends DFA {

		public DFA39(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 39;
			this.eot = DFA39_eot;
			this.eof = DFA39_eof;
			this.min = DFA39_min;
			this.max = DFA39_max;
			this.accept = DFA39_accept;
			this.special = DFA39_special;
			this.transition = DFA39_transition;
		}

		public String getDescription() {
			return "1201:3: ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) )";
		}
	}

	static final String DFA44_eotS = "\24\uffff";
	static final String DFA44_eofS = "\2\uffff\7\23\1\uffff\11\23\1\uffff";
	static final String DFA44_minS = "\1\16\1\17\7\5\1\uffff\11\5\1\uffff";
	static final String DFA44_maxS = "\11\73\1\uffff\11\73\1\uffff";
	static final String DFA44_acceptS = "\11\uffff\1\2\11\uffff\1\1";
	static final String DFA44_specialS = "\24\uffff}>";
	static final String[] DFA44_transitionS = {
			"\1\1\1\2\1\3\1\4\30\uffff\2\11\14\uffff\1\5\1\6\1\7\1\10",
			"\1\2\1\3\1\4\46\uffff\1\5\1\6\1\7\1\10",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14" +
					"\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1" +
					"\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14" +
					"\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1" +
					"\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14" +
					"\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1" +
					"\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14" +
					"\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1" +
					"\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14" +
					"\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1" +
					"\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14" +
					"\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1" +
					"\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14" +
					"\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1" +
					"\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14" +
					"\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1" +
					"\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14" +
					"\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1" +
					"\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14" +
					"\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1" +
					"\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14" +
					"\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1" +
					"\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14" +
					"\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1" +
					"\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14" +
					"\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1" +
					"\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14" +
					"\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1" +
					"\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14" +
					"\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1" +
					"\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			"\2\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\13\1\12\1\14" +
					"\1\15\1\16\10\uffff\1\23\7\uffff\1\23\5\uffff\1\23\1\uffff\1" +
					"\11\3\uffff\2\23\7\uffff\1\17\1\20\1\21\1\22",
			""
	};

	static final short[] DFA44_eot = DFA.unpackEncodedString(DFA44_eotS);
	static final short[] DFA44_eof = DFA.unpackEncodedString(DFA44_eofS);
	static final char[] DFA44_min = DFA.unpackEncodedStringToUnsignedChars(DFA44_minS);
	static final char[] DFA44_max = DFA.unpackEncodedStringToUnsignedChars(DFA44_maxS);
	static final short[] DFA44_accept = DFA.unpackEncodedString(DFA44_acceptS);
	static final short[] DFA44_special = DFA.unpackEncodedString(DFA44_specialS);
	static final short[][] DFA44_transition;

	static {
		int numStates = DFA44_transitionS.length;
		DFA44_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA44_transition[i] = DFA.unpackEncodedString(DFA44_transitionS[i]);
		}
	}

	class DFA44 extends DFA {

		public DFA44(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 44;
			this.eot = DFA44_eot;
			this.eof = DFA44_eof;
			this.min = DFA44_min;
			this.max = DFA44_max;
			this.accept = DFA44_accept;
			this.special = DFA44_special;
			this.transition = DFA44_transition;
		}

		public String getDescription() {
			return "1360:3: ( ( (lv_element_0_0= ruleElementSelector ) ) | ( (lv_universal_1_0= ruleUniversalSelector ) ) )";
		}
	}

	static final String DFA58_eotS = "\25\uffff";
	static final String DFA58_eofS = "\4\uffff\7\13\1\uffff\11\13";
	static final String DFA58_minS = "\2\5\1\uffff\1\17\7\5\1\uffff\11\5";
	static final String DFA58_maxS = "\1\5\1\73\1\uffff\10\73\1\uffff\11\73";
	static final String DFA58_acceptS = "\2\uffff\1\2\10\uffff\1\1\11\uffff";
	static final String DFA58_specialS = "\25\uffff}>";
	static final String[] DFA58_transitionS = {
			"\1\1",
			"\1\13\10\uffff\1\3\1\4\1\5\1\6\34\uffff\1\2\11\uffff\1\7\1" +
					"\10\1\11\1\12",
			"",
			"\1\4\1\5\1\6\46\uffff\1\7\1\10\1\11\1\12",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16" +
					"\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1" +
					"\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16" +
					"\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1" +
					"\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16" +
					"\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1" +
					"\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16" +
					"\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1" +
					"\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16" +
					"\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1" +
					"\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16" +
					"\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1" +
					"\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16" +
					"\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1" +
					"\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16" +
					"\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1" +
					"\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16" +
					"\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1" +
					"\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16" +
					"\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1" +
					"\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16" +
					"\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1" +
					"\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16" +
					"\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1" +
					"\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16" +
					"\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1" +
					"\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16" +
					"\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1" +
					"\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16" +
					"\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1" +
					"\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24",
			"\2\13\1\uffff\1\13\2\uffff\1\13\1\uffff\1\13\1\15\1\14\1\16" +
					"\1\17\1\20\10\uffff\1\13\7\uffff\1\13\5\uffff\1\13\3\uffff\1" +
					"\2\1\uffff\2\13\7\uffff\1\21\1\22\1\23\1\24"
	};

	static final short[] DFA58_eot = DFA.unpackEncodedString(DFA58_eotS);
	static final short[] DFA58_eof = DFA.unpackEncodedString(DFA58_eofS);
	static final char[] DFA58_min = DFA.unpackEncodedStringToUnsignedChars(DFA58_minS);
	static final char[] DFA58_max = DFA.unpackEncodedStringToUnsignedChars(DFA58_maxS);
	static final short[] DFA58_accept = DFA.unpackEncodedString(DFA58_acceptS);
	static final short[] DFA58_special = DFA.unpackEncodedString(DFA58_specialS);
	static final short[][] DFA58_transition;

	static {
		int numStates = DFA58_transitionS.length;
		DFA58_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA58_transition[i] = DFA.unpackEncodedString(DFA58_transitionS[i]);
		}
	}

	class DFA58 extends DFA {

		public DFA58(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 58;
			this.eot = DFA58_eot;
			this.eof = DFA58_eof;
			this.min = DFA58_min;
			this.max = DFA58_max;
			this.accept = DFA58_accept;
			this.special = DFA58_special;
			this.transition = DFA58_transition;
		}

		public String getDescription() {
			return "2089:1: (this_PseudoClass_0= rulePseudoClass | this_PseudoClassFunction_1= rulePseudoClassFunction )";
		}
	}

	static final String DFA76_eotS = "\14\uffff";
	static final String DFA76_eofS = "\1\1\13\uffff";
	static final String DFA76_minS = "\1\4\1\uffff\11\0\1\uffff";
	static final String DFA76_maxS = "\1\73\1\uffff\11\0\1\uffff";
	static final String DFA76_acceptS = "\1\uffff\1\2\11\uffff\1\1";
	static final String DFA76_specialS = "\2\uffff\1\6\1\0\1\10\1\1\1\2\1\3\1\4\1\5\1\7\1\uffff}>";
	static final String[] DFA76_transitionS = {
			"\12\1\1\2\1\3\1\4\1\5\1\12\3\uffff\1\1\4\uffff\2\1\6\uffff" +
					"\7\1\1\uffff\3\1\1\uffff\3\1\6\uffff\1\6\1\7\1\10\1\11",
			"",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			""
	};

	static final short[] DFA76_eot = DFA.unpackEncodedString(DFA76_eotS);
	static final short[] DFA76_eof = DFA.unpackEncodedString(DFA76_eofS);
	static final char[] DFA76_min = DFA.unpackEncodedStringToUnsignedChars(DFA76_minS);
	static final char[] DFA76_max = DFA.unpackEncodedStringToUnsignedChars(DFA76_maxS);
	static final short[] DFA76_accept = DFA.unpackEncodedString(DFA76_acceptS);
	static final short[] DFA76_special = DFA.unpackEncodedString(DFA76_specialS);
	static final short[][] DFA76_transition;

	static {
		int numStates = DFA76_transitionS.length;
		DFA76_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA76_transition[i] = DFA.unpackEncodedString(DFA76_transitionS[i]);
		}
	}

	class DFA76 extends DFA {

		public DFA76(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 76;
			this.eot = DFA76_eot;
			this.eof = DFA76_eof;
			this.min = DFA76_min;
			this.max = DFA76_max;
			this.accept = DFA76_accept;
			this.special = DFA76_special;
			this.transition = DFA76_transition;
		}

		public String getDescription() {
			return "()* loopback of 3293:2: ( ( ( RULE_UNDERSCORE | RULE_DASH | RULE_ONE_HEX_LETTER | RULE_ONE_NON_HEX_LETTER | RULE_ONE_INT | ruleKeywordHack ) )=> (this_UNDERSCORE_5= RULE_UNDERSCORE | this_DASH_6= RULE_DASH | this_ONE_HEX_LETTER_7= RULE_ONE_HEX_LETTER | this_ONE_NON_HEX_LETTER_8= RULE_ONE_NON_HEX_LETTER | this_ONE_INT_9= RULE_ONE_INT | this_KeywordHack_10= ruleKeywordHack ) )*";
		}

		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream) _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA76_3 = input.LA(1);


				int index76_3 = input.index();
				input.rewind();
				s = -1;
				if ((synpred2_InternalCSS())) {
					s = 11;
				}

				else if ((true)) {
					s = 1;
				}


				input.seek(index76_3);
				if (s >= 0)
					return s;
				break;
			case 1:
				int LA76_5 = input.LA(1);


				int index76_5 = input.index();
				input.rewind();
				s = -1;
				if ((synpred2_InternalCSS())) {
					s = 11;
				}

				else if ((true)) {
					s = 1;
				}


				input.seek(index76_5);
				if (s >= 0)
					return s;
				break;
			case 2:
				int LA76_6 = input.LA(1);


				int index76_6 = input.index();
				input.rewind();
				s = -1;
				if ((synpred2_InternalCSS())) {
					s = 11;
				}

				else if ((true)) {
					s = 1;
				}


				input.seek(index76_6);
				if (s >= 0)
					return s;
				break;
			case 3:
				int LA76_7 = input.LA(1);


				int index76_7 = input.index();
				input.rewind();
				s = -1;
				if ((synpred2_InternalCSS())) {
					s = 11;
				}

				else if ((true)) {
					s = 1;
				}


				input.seek(index76_7);
				if (s >= 0)
					return s;
				break;
			case 4:
				int LA76_8 = input.LA(1);


				int index76_8 = input.index();
				input.rewind();
				s = -1;
				if ((synpred2_InternalCSS())) {
					s = 11;
				}

				else if ((true)) {
					s = 1;
				}


				input.seek(index76_8);
				if (s >= 0)
					return s;
				break;
			case 5:
				int LA76_9 = input.LA(1);


				int index76_9 = input.index();
				input.rewind();
				s = -1;
				if ((synpred2_InternalCSS())) {
					s = 11;
				}

				else if ((true)) {
					s = 1;
				}


				input.seek(index76_9);
				if (s >= 0)
					return s;
				break;
			case 6:
				int LA76_2 = input.LA(1);


				int index76_2 = input.index();
				input.rewind();
				s = -1;
				if ((synpred2_InternalCSS())) {
					s = 11;
				}

				else if ((true)) {
					s = 1;
				}


				input.seek(index76_2);
				if (s >= 0)
					return s;
				break;
			case 7:
				int LA76_10 = input.LA(1);


				int index76_10 = input.index();
				input.rewind();
				s = -1;
				if ((synpred2_InternalCSS())) {
					s = 11;
				}

				else if ((true)) {
					s = 1;
				}


				input.seek(index76_10);
				if (s >= 0)
					return s;
				break;
			case 8:
				int LA76_4 = input.LA(1);


				int index76_4 = input.index();
				input.rewind();
				s = -1;
				if ((synpred2_InternalCSS())) {
					s = 11;
				}

				else if ((true)) {
					s = 1;
				}


				input.seek(index76_4);
				if (s >= 0)
					return s;
				break;
			}
			if (state.backtracking > 0) {
				state.failed = true;
				return -1;
			}
			NoViableAltException nvae = new NoViableAltException(getDescription(), 76, _s, input);
			error(nvae);
			throw nvae;
		}
	}


	public static final BitSet FOLLOW_rulestylesheet_in_entryRulestylesheet75 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRulestylesheet85 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulecharset_in_rulestylesheet131 = new BitSet(new long[] { 0x0F000E0FE783C822L });
	public static final BitSet FOLLOW_ruleimportExpression_in_rulestylesheet153 = new BitSet(new long[] { 0x0F000E0FE783C822L });
	public static final BitSet FOLLOW_ruleruleset_in_rulestylesheet176 = new BitSet(new long[] { 0x0F000E0FE603C822L });
	public static final BitSet FOLLOW_rulemedia_in_rulestylesheet203 = new BitSet(new long[] { 0x0F000E0FE603C822L });
	public static final BitSet FOLLOW_rulepage_in_rulestylesheet230 = new BitSet(new long[] { 0x0F000E0FE603C822L });
	public static final BitSet FOLLOW_rulefont_face_in_rulestylesheet257 = new BitSet(new long[] { 0x0F000E0FE603C822L });
	public static final BitSet FOLLOW_rulekeyframes_in_rulestylesheet284 = new BitSet(new long[] { 0x0F000E0FE603C822L });
	public static final BitSet FOLLOW_rulecharset_in_entryRulecharset322 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRulecharset332 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_20_in_rulecharset370 = new BitSet(new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_21_in_rulecharset388 = new BitSet(new long[] { 0x0000000000000010L });
	public static final BitSet FOLLOW_RULE_CSSSTRING_in_rulecharset406 = new BitSet(new long[] { 0x0000000000400000L });
	public static final BitSet FOLLOW_22_in_rulecharset423 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleimportExpression_in_entryRuleimportExpression459 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleimportExpression469 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_23_in_ruleimportExpression507 = new BitSet(new long[] { 0x0002000000000010L });
	public static final BitSet FOLLOW_24_in_ruleimportExpression525 = new BitSet(new long[] { 0x0002000000000010L });
	public static final BitSet FOLLOW_RULE_CSSSTRING_in_ruleimportExpression544 = new BitSet(new long[] { 0x0000000000400000L });
	public static final BitSet FOLLOW_ruleURLType_in_ruleimportExpression578 = new BitSet(new long[] { 0x0F0000000043C000L });
	public static final BitSet FOLLOW_rulemedia_list_in_ruleimportExpression598 = new BitSet(new long[] { 0x0000000000400000L });
	public static final BitSet FOLLOW_22_in_ruleimportExpression613 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulepage_in_entryRulepage649 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRulepage659 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_25_in_rulepage706 = new BitSet(new long[] { 0x0000000008000020L });
	public static final BitSet FOLLOW_26_in_rulepage724 = new BitSet(new long[] { 0x0000000008000020L });
	public static final BitSet FOLLOW_rulepseudo_page_in_rulepage746 = new BitSet(new long[] { 0x0000000008000000L });
	public static final BitSet FOLLOW_27_in_rulepage759 = new BitSet(new long[] { 0x0F0000001043C100L });
	public static final BitSet FOLLOW_rulecss_declaration_in_rulepage780 = new BitSet(new long[] { 0x0000000010400000L });
	public static final BitSet FOLLOW_22_in_rulepage794 = new BitSet(new long[] { 0x0F0000001043C100L });
	public static final BitSet FOLLOW_rulecss_declaration_in_rulepage815 = new BitSet(new long[] { 0x0000000010400000L });
	public static final BitSet FOLLOW_28_in_rulepage830 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulepseudo_page_in_entryRulepseudo_page867 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRulepseudo_page878 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_COLON_in_rulepseudo_page918 = new BitSet(new long[] { 0x0F0000000003C000L });
	public static final BitSet FOLLOW_ruleIdentifier_in_rulepseudo_page945 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulemedia_in_entryRulemedia990 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRulemedia1000 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_29_in_rulemedia1038 = new BitSet(new long[] { 0x0F0000000003C000L });
	public static final BitSet FOLLOW_30_in_rulemedia1056 = new BitSet(new long[] { 0x0F0000000003C000L });
	public static final BitSet FOLLOW_rulemedia_list_in_rulemedia1078 = new BitSet(new long[] { 0x0000000008000000L });
	public static final BitSet FOLLOW_27_in_rulemedia1090 = new BitSet(new long[] { 0x0F000E081003C820L });
	public static final BitSet FOLLOW_ruleruleset_in_rulemedia1111 = new BitSet(new long[] { 0x0F000E081003C820L });
	public static final BitSet FOLLOW_28_in_rulemedia1124 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulemedia_list_in_entryRulemedia_list1161 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRulemedia_list1172 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulemedium_in_rulemedia_list1219 = new BitSet(new long[] { 0x0000000000000042L });
	public static final BitSet FOLLOW_RULE_COMMA_in_rulemedia_list1240 = new BitSet(new long[] { 0x0F0000000003C000L });
	public static final BitSet FOLLOW_rulemedium_in_rulemedia_list1267 = new BitSet(new long[] { 0x0000000000000042L });
	public static final BitSet FOLLOW_rulemedium_in_entryRulemedium1315 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRulemedium1326 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleIdentifier_in_rulemedium1372 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulefont_face_in_entryRulefont_face1416 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRulefont_face1426 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_31_in_rulefont_face1473 = new BitSet(new long[] { 0x0000000008000000L });
	public static final BitSet FOLLOW_32_in_rulefont_face1491 = new BitSet(new long[] { 0x0000000008000000L });
	public static final BitSet FOLLOW_27_in_rulefont_face1504 = new BitSet(new long[] { 0x0F0000001043C100L });
	public static final BitSet FOLLOW_rulecss_declaration_in_rulefont_face1525 = new BitSet(new long[] { 0x0000000010400000L });
	public static final BitSet FOLLOW_22_in_rulefont_face1539 = new BitSet(new long[] { 0x0F0000001043C100L });
	public static final BitSet FOLLOW_rulecss_declaration_in_rulefont_face1560 = new BitSet(new long[] { 0x0000000010400000L });
	public static final BitSet FOLLOW_28_in_rulefont_face1575 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulekeyframes_in_entryRulekeyframes1611 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRulekeyframes1621 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_33_in_rulekeyframes1668 = new BitSet(new long[] { 0x0F0000000003C000L });
	public static final BitSet FOLLOW_34_in_rulekeyframes1686 = new BitSet(new long[] { 0x0F0000000003C000L });
	public static final BitSet FOLLOW_ruleIdentifier_in_rulekeyframes1708 = new BitSet(new long[] { 0x0000000008000000L });
	public static final BitSet FOLLOW_27_in_rulekeyframes1720 = new BitSet(new long[] { 0x0F0002001047E000L });
	public static final BitSet FOLLOW_rulekeyframe_selector_in_rulekeyframes1741 = new BitSet(new long[] { 0x0000000010400000L });
	public static final BitSet FOLLOW_22_in_rulekeyframes1755 = new BitSet(new long[] { 0x0F0002001047E000L });
	public static final BitSet FOLLOW_rulekeyframe_selector_in_rulekeyframes1776 = new BitSet(new long[] { 0x0000000010400000L });
	public static final BitSet FOLLOW_28_in_rulekeyframes1791 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulekeyframe_selector_in_entryRulekeyframe_selector1827 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRulekeyframe_selector1837 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleIdentifier_in_rulekeyframe_selector1884 = new BitSet(new long[] { 0x0000000008000000L });
	public static final BitSet FOLLOW_ruleNum_in_rulekeyframe_selector1912 = new BitSet(new long[] { 0x0000000000000080L });
	public static final BitSet FOLLOW_RULE_PERCENT_in_rulekeyframe_selector1923 = new BitSet(new long[] { 0x0000000008000000L });
	public static final BitSet FOLLOW_27_in_rulekeyframe_selector1936 = new BitSet(new long[] { 0x0F0000001043C100L });
	public static final BitSet FOLLOW_rulecss_declaration_in_rulekeyframe_selector1957 = new BitSet(new long[] { 0x0000000010400000L });
	public static final BitSet FOLLOW_22_in_rulekeyframe_selector1971 = new BitSet(new long[] { 0x0F0000001043C100L });
	public static final BitSet FOLLOW_rulecss_declaration_in_rulekeyframe_selector1992 = new BitSet(new long[] { 0x0000000010400000L });
	public static final BitSet FOLLOW_28_in_rulekeyframe_selector2007 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleruleset_in_entryRuleruleset2043 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleruleset2053 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleselector_in_ruleruleset2099 = new BitSet(new long[] { 0x0000000008000140L });
	public static final BitSet FOLLOW_RULE_WS_in_ruleruleset2112 = new BitSet(new long[] { 0x0000000000000140L });
	public static final BitSet FOLLOW_RULE_COMMA_in_ruleruleset2124 = new BitSet(new long[] { 0x0F000E080003C820L });
	public static final BitSet FOLLOW_ruleselector_in_ruleruleset2144 = new BitSet(new long[] { 0x0000000008000140L });
	public static final BitSet FOLLOW_RULE_WS_in_ruleruleset2158 = new BitSet(new long[] { 0x0000000008000100L });
	public static final BitSet FOLLOW_27_in_ruleruleset2171 = new BitSet(new long[] { 0x0F0000001003C100L });
	public static final BitSet FOLLOW_rulecss_declaration_in_ruleruleset2193 = new BitSet(new long[] { 0x0000000010400000L });
	public static final BitSet FOLLOW_22_in_ruleruleset2206 = new BitSet(new long[] { 0x0F0000000003C100L });
	public static final BitSet FOLLOW_rulecss_declaration_in_ruleruleset2227 = new BitSet(new long[] { 0x0000000010400000L });
	public static final BitSet FOLLOW_22_in_ruleruleset2242 = new BitSet(new long[] { 0x0000000010000000L });
	public static final BitSet FOLLOW_28_in_ruleruleset2258 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleselector_in_entryRuleselector2294 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleselector2304 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulesimple_selector_in_ruleselector2350 = new BitSet(new long[] { 0x0001800000002102L });
	public static final BitSet FOLLOW_rulecombinator_in_ruleselector2373 = new BitSet(new long[] { 0x0F000E080003C920L });
	public static final BitSet FOLLOW_RULE_WS_in_ruleselector2385 = new BitSet(new long[] { 0x0F000E080003C920L });
	public static final BitSet FOLLOW_ruleselector_in_ruleselector2407 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_WS_in_ruleselector2427 = new BitSet(new long[] { 0x0F018E080003E920L });
	public static final BitSet FOLLOW_rulecombinator_in_ruleselector2450 = new BitSet(new long[] { 0x0F000E080003C920L });
	public static final BitSet FOLLOW_RULE_WS_in_ruleselector2462 = new BitSet(new long[] { 0x0F000E080003C920L });
	public static final BitSet FOLLOW_ruleselector_in_ruleselector2486 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleSimpleSelectorForNegation_in_entryRuleSimpleSelectorForNegation2525 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleSimpleSelectorForNegation2535 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleElementSelector_in_ruleSimpleSelectorForNegation2583 = new BitSet(new long[] { 0x0000020800000822L });
	public static final BitSet FOLLOW_ruleUniversalSelector_in_ruleSimpleSelectorForNegation2610 = new BitSet(new long[] { 0x0000020800000822L });
	public static final BitSet FOLLOW_ruleSubSelectorForNegation_in_ruleSimpleSelectorForNegation2632 = new BitSet(new long[] { 0x0000020800000822L });
	public static final BitSet FOLLOW_ruleSubSelectorForNegation_in_ruleSimpleSelectorForNegation2671 = new BitSet(new long[] { 0x0000020800000822L });
	public static final BitSet FOLLOW_ruleSubSelectorForNegation_in_entryRuleSubSelectorForNegation2708 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleSubSelectorForNegation2718 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleIdSelector_in_ruleSubSelectorForNegation2765 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleClassSelector_in_ruleSubSelectorForNegation2792 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleAttributeSelector_in_ruleSubSelectorForNegation2819 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulePseudoClass_in_ruleSubSelectorForNegation2846 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulesimple_selector_in_entryRulesimple_selector2881 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRulesimple_selector2891 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleElementSelector_in_rulesimple_selector2939 = new BitSet(new long[] { 0x0F000E080003C822L });
	public static final BitSet FOLLOW_ruleUniversalSelector_in_rulesimple_selector2966 = new BitSet(new long[] { 0x0F000E080003C822L });
	public static final BitSet FOLLOW_ruleSubSelector_in_rulesimple_selector2988 = new BitSet(new long[] { 0x0F000E080003C822L });
	public static final BitSet FOLLOW_ruleSubSelector_in_rulesimple_selector3017 = new BitSet(new long[] { 0x0F000E080003C822L });
	public static final BitSet FOLLOW_ruleSubSelector_in_entryRuleSubSelector3054 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleSubSelector3064 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleIdSelector_in_ruleSubSelector3111 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleClassSelector_in_ruleSubSelector3138 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleAttributeSelector_in_ruleSubSelector3165 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulePseudoClassOrFunc_in_ruleSubSelector3192 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleAttributeSelector_in_entryRuleAttributeSelector3227 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleAttributeSelector3237 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_35_in_ruleAttributeSelector3283 = new BitSet(new long[] { 0x0F0000000003C000L });
	public static final BitSet FOLLOW_ruleIdentifier_in_ruleAttributeSelector3304 = new BitSet(new long[] { 0x000001F000000600L });
	public static final BitSet FOLLOW_36_in_ruleAttributeSelector3325 = new BitSet(new long[] { 0x0F0000000003C010L });
	public static final BitSet FOLLOW_37_in_ruleAttributeSelector3354 = new BitSet(new long[] { 0x0F0000000003C010L });
	public static final BitSet FOLLOW_38_in_ruleAttributeSelector3383 = new BitSet(new long[] { 0x0F0000000003C010L });
	public static final BitSet FOLLOW_39_in_ruleAttributeSelector3412 = new BitSet(new long[] { 0x0F0000000003C010L });
	public static final BitSet FOLLOW_RULE_INCLUDES_in_ruleAttributeSelector3440 = new BitSet(new long[] { 0x0F0000000003C010L });
	public static final BitSet FOLLOW_RULE_DASHMATCH_in_ruleAttributeSelector3460 = new BitSet(new long[] { 0x0F0000000003C010L });
	public static final BitSet FOLLOW_ruleIdentifier_in_ruleAttributeSelector3491 = new BitSet(new long[] { 0x0000010000000000L });
	public static final BitSet FOLLOW_RULE_CSSSTRING_in_ruleAttributeSelector3506 = new BitSet(new long[] { 0x0000010000000000L });
	public static final BitSet FOLLOW_40_in_ruleAttributeSelector3528 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleClassSelector_in_entryRuleClassSelector3564 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleClassSelector3574 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_41_in_ruleClassSelector3620 = new BitSet(new long[] { 0x0F0000000003C000L });
	public static final BitSet FOLLOW_ruleIdentifier_in_ruleClassSelector3641 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleElementSelector_in_entryRuleElementSelector3677 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleElementSelector3687 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleIdentifier_in_ruleElementSelector3742 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleUniversalSelector_in_entryRuleUniversalSelector3778 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleUniversalSelector3788 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulecss_namespace_prefix_in_ruleUniversalSelector3843 = new BitSet(new long[] { 0x0000040000000000L });
	public static final BitSet FOLLOW_42_in_ruleUniversalSelector3856 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleIdSelector_in_entryRuleIdSelector3892 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleIdSelector3902 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_HASHMARK_in_ruleIdSelector3947 = new BitSet(new long[] { 0x0F0000000003C000L });
	public static final BitSet FOLLOW_ruleIdentifier_in_ruleIdSelector3967 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulecss_namespace_prefix_in_entryRulecss_namespace_prefix4004 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRulecss_namespace_prefix4015 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleIdentifier_in_rulecss_namespace_prefix4063 = new BitSet(new long[] { 0x0000080000000000L });
	public static final BitSet FOLLOW_42_in_rulecss_namespace_prefix4087 = new BitSet(new long[] { 0x0000080000000000L });
	public static final BitSet FOLLOW_43_in_rulecss_namespace_prefix4102 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulecss_declaration_in_entryRulecss_declaration4142 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRulecss_declaration4152 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_WS_in_rulecss_declaration4189 = new BitSet(new long[] { 0x0F0000000003C100L });
	public static final BitSet FOLLOW_rulecss_property_in_rulecss_declaration4211 = new BitSet(new long[] { 0x0000000000000120L });
	public static final BitSet FOLLOW_RULE_WS_in_rulecss_declaration4223 = new BitSet(new long[] { 0x0000000000000120L });
	public static final BitSet FOLLOW_RULE_COLON_in_rulecss_declaration4235 = new BitSet(new long[] { 0x0F0202000007E9D0L });
	public static final BitSet FOLLOW_ruleCssTok_in_rulecss_declaration4255 = new BitSet(new long[] { 0x0F0202000007F9D2L });
	public static final BitSet FOLLOW_RULE_IMPORTANT_SYM_in_rulecss_declaration4273 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulecss_property_in_entryRulecss_property4315 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRulecss_property4325 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleValidPropertyIdent_in_rulecss_property4380 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleValidPropertyIdent_in_entryRuleValidPropertyIdent4417 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleValidPropertyIdent4428 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleIdentifier_in_ruleValidPropertyIdent4474 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulePseudoClassOrFunc_in_entryRulePseudoClassOrFunc4518 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRulePseudoClassOrFunc4528 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulePseudoClass_in_rulePseudoClassOrFunc4575 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulePseudoClassFunction_in_rulePseudoClassOrFunc4602 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulePseudoClass_in_entryRulePseudoClass4637 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRulePseudoClass4647 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_COLON_in_rulePseudoClass4683 = new BitSet(new long[] { 0x0F0000000003C020L });
	public static final BitSet FOLLOW_RULE_COLON_in_rulePseudoClass4694 = new BitSet(new long[] { 0x0F0000000003C020L });
	public static final BitSet FOLLOW_rulePseudoClassName_in_rulePseudoClass4717 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulePseudoClassName_in_entryRulePseudoClassName4752 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRulePseudoClassName4762 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleIdentifier_in_rulePseudoClassName4807 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulePseudoClassFunction_in_entryRulePseudoClassFunction4842 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRulePseudoClassFunction4852 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleNotFunctionCall_in_rulePseudoClassFunction4899 = new BitSet(new long[] { 0x0F000E080003C820L });
	public static final BitSet FOLLOW_ruleSimpleSelectorForNegation_in_rulePseudoClassFunction4920 = new BitSet(new long[] { 0x0000100000000000L });
	public static final BitSet FOLLOW_44_in_rulePseudoClassFunction4932 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_COLON_in_rulePseudoClassFunction4951 = new BitSet(new long[] { 0x0F0000000003C000L });
	public static final BitSet FOLLOW_ruleIdentifier_in_rulePseudoClassFunction4971 = new BitSet(new long[] { 0x0000200000000000L });
	public static final BitSet FOLLOW_45_in_rulePseudoClassFunction4983 = new BitSet(new long[] { 0x0F0212000007E9D0L });
	public static final BitSet FOLLOW_ruleCssTok_in_rulePseudoClassFunction5004 = new BitSet(new long[] { 0x0F0212000007E9D0L });
	public static final BitSet FOLLOW_44_in_rulePseudoClassFunction5017 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleNotFunctionCall_in_entryRuleNotFunctionCall5055 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleNotFunctionCall5066 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_COLON_in_ruleNotFunctionCall5106 = new BitSet(new long[] { 0x0000400000000000L });
	public static final BitSet FOLLOW_46_in_ruleNotFunctionCall5124 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_rulecombinator_in_entryRulecombinator5165 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRulecombinator5176 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_PLUS_in_rulecombinator5216 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_47_in_rulecombinator5240 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_48_in_rulecombinator5259 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleSymbolTok_in_entryRuleSymbolTok5303 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleSymbolTok5313 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_COMMA_in_ruleSymbolTok5366 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_PERCENT_in_ruleSymbolTok5386 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleWSTok_in_entryRuleWSTok5430 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleWSTok5440 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_WS_in_ruleWSTok5485 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleStringTok_in_entryRuleStringTok5520 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleStringTok5530 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_CSSSTRING_in_ruleStringTok5581 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleNumberTok_in_entryRuleNumberTok5622 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleNumberTok5632 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleNum_in_ruleNumberTok5687 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleUrlTok_in_entryRuleUrlTok5723 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleUrlTok5733 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleURLType_in_ruleUrlTok5788 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleColorTok_in_entryRuleColorTok5824 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleColorTok5834 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleHex_in_ruleColorTok5889 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleIdentifierOrFuncTok_in_entryRuleIdentifierOrFuncTok5925 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleIdentifierOrFuncTok5935 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleIdentifier_in_ruleIdentifierOrFuncTok5990 = new BitSet(new long[] { 0x0000200000000002L });
	public static final BitSet FOLLOW_45_in_ruleIdentifierOrFuncTok6012 = new BitSet(new long[] { 0x0F0202000007E9D0L });
	public static final BitSet FOLLOW_ruleCssTok_in_ruleIdentifierOrFuncTok6033 = new BitSet(new long[] { 0x0F0212000007E9D0L });
	public static final BitSet FOLLOW_44_in_ruleIdentifierOrFuncTok6046 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleCssTok_in_entryRuleCssTok6084 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleCssTok6094 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleIdentifierOrFuncTok_in_ruleCssTok6141 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleSymbolTok_in_ruleCssTok6168 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleWSTok_in_ruleCssTok6195 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleStringTok_in_ruleCssTok6222 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleNumberTok_in_ruleCssTok6249 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleUrlTok_in_ruleCssTok6276 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleColorTok_in_ruleCssTok6303 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleURLType_in_entryRuleURLType6338 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleURLType6348 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_49_in_ruleURLType6385 = new BitSet(new long[] { 0xFFFD07880047E8F0L, 0x0000000000000001L });
	public static final BitSet FOLLOW_ruleValidURL_in_ruleURLType6406 = new BitSet(new long[] { 0x0000100000000000L });
	public static final BitSet FOLLOW_44_in_ruleURLType6418 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleValidURLSymbol_in_entryRuleValidURLSymbol6455 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleValidURLSymbol6466 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_DASH_in_ruleValidURLSymbol6506 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_41_in_ruleValidURLSymbol6530 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_UNDERSCORE_in_ruleValidURLSymbol6551 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_48_in_ruleValidURLSymbol6575 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_COLON_in_ruleValidURLSymbol6596 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_50_in_ruleValidURLSymbol6620 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_51_in_ruleValidURLSymbol6639 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_HASHMARK_in_ruleValidURLSymbol6660 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_35_in_ruleValidURLSymbol6684 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_40_in_ruleValidURLSymbol6703 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_52_in_ruleValidURLSymbol6722 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_53_in_ruleValidURLSymbol6741 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_54_in_ruleValidURLSymbol6760 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_55_in_ruleValidURLSymbol6779 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_42_in_ruleValidURLSymbol6798 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_PLUS_in_ruleValidURLSymbol6819 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_COMMA_in_ruleValidURLSymbol6845 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_22_in_ruleValidURLSymbol6869 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_39_in_ruleValidURLSymbol6889 = new BitSet(new long[] { 0x0F0000000003C000L });
	public static final BitSet FOLLOW_ruleKeywordHack_in_ruleValidURLSymbol6911 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleKeywordHack_in_entryRuleKeywordHack6958 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleKeywordHack6969 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_56_in_ruleKeywordHack7007 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_57_in_ruleKeywordHack7026 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_58_in_ruleKeywordHack7045 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_59_in_ruleKeywordHack7064 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleValidURL_in_entryRuleValidURL7105 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleValidURL7116 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_CSSSTRING_in_ruleValidURL7156 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleValidURLSymbol_in_ruleValidURL7190 = new BitSet(new long[] { 0xFFFD07880047E8E2L, 0x0000000000000001L });
	public static final BitSet FOLLOW_ruleKeywordHack_in_ruleValidURL7223 = new BitSet(new long[] { 0xFFFD07880047E8E2L, 0x0000000000000001L });
	public static final BitSet FOLLOW_RULE_ONE_HEX_LETTER_in_ruleValidURL7249 = new BitSet(new long[] { 0xFFFD07880047E8E2L, 0x0000000000000001L });
	public static final BitSet FOLLOW_RULE_ONE_NON_HEX_LETTER_in_ruleValidURL7275 = new BitSet(new long[] { 0xFFFD07880047E8E2L, 0x0000000000000001L });
	public static final BitSet FOLLOW_RULE_ONE_INT_in_ruleValidURL7301 = new BitSet(new long[] { 0xFFFD07880047E8E2L, 0x0000000000000001L });
	public static final BitSet FOLLOW_60_in_ruleValidURL7325 = new BitSet(new long[] { 0xFFFD07880047E8E2L, 0x0000000000000001L });
	public static final BitSet FOLLOW_61_in_ruleValidURL7344 = new BitSet(new long[] { 0xFFFD07880047E8E2L, 0x0000000000000001L });
	public static final BitSet FOLLOW_62_in_ruleValidURL7363 = new BitSet(new long[] { 0xFFFD07880047E8E2L, 0x0000000000000001L });
	public static final BitSet FOLLOW_63_in_ruleValidURL7382 = new BitSet(new long[] { 0xFFFD07880047E8E2L, 0x0000000000000001L });
	public static final BitSet FOLLOW_64_in_ruleValidURL7401 = new BitSet(new long[] { 0xFFFD07880047E8E2L, 0x0000000000000001L });
	public static final BitSet FOLLOW_RULE_PERCENT_in_ruleValidURL7423 = new BitSet(new long[] { 0x0000000000050000L });
	public static final BitSet FOLLOW_RULE_ONE_INT_in_ruleValidURL7444 = new BitSet(new long[] { 0x0000000000050000L });
	public static final BitSet FOLLOW_RULE_ONE_HEX_LETTER_in_ruleValidURL7470 = new BitSet(new long[] { 0x0000000000050000L });
	public static final BitSet FOLLOW_RULE_ONE_INT_in_ruleValidURL7492 = new BitSet(new long[] { 0xFFFD07880047E8E2L, 0x0000000000000001L });
	public static final BitSet FOLLOW_RULE_ONE_HEX_LETTER_in_ruleValidURL7518 = new BitSet(new long[] { 0xFFFD07880047E8E2L, 0x0000000000000001L });
	public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier7568 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier7579 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_DASH_in_ruleIdentifier7620 = new BitSet(new long[] { 0x0F0000000003C000L });
	public static final BitSet FOLLOW_RULE_UNDERSCORE_in_ruleIdentifier7643 = new BitSet(new long[] { 0x0F0000000007C002L });
	public static final BitSet FOLLOW_RULE_ONE_HEX_LETTER_in_ruleIdentifier7669 = new BitSet(new long[] { 0x0F0000000007C002L });
	public static final BitSet FOLLOW_RULE_ONE_NON_HEX_LETTER_in_ruleIdentifier7695 = new BitSet(new long[] { 0x0F0000000007C002L });
	public static final BitSet FOLLOW_ruleKeywordHack_in_ruleIdentifier7728 = new BitSet(new long[] { 0x0F0000000007C002L });
	public static final BitSet FOLLOW_RULE_UNDERSCORE_in_ruleIdentifier7798 = new BitSet(new long[] { 0x0F0000000007C002L });
	public static final BitSet FOLLOW_RULE_DASH_in_ruleIdentifier7824 = new BitSet(new long[] { 0x0F0000000007C002L });
	public static final BitSet FOLLOW_RULE_ONE_HEX_LETTER_in_ruleIdentifier7850 = new BitSet(new long[] { 0x0F0000000007C002L });
	public static final BitSet FOLLOW_RULE_ONE_NON_HEX_LETTER_in_ruleIdentifier7876 = new BitSet(new long[] { 0x0F0000000007C002L });
	public static final BitSet FOLLOW_RULE_ONE_INT_in_ruleIdentifier7902 = new BitSet(new long[] { 0x0F0000000007C002L });
	public static final BitSet FOLLOW_ruleKeywordHack_in_ruleIdentifier7935 = new BitSet(new long[] { 0x0F0000000007C002L });
	public static final BitSet FOLLOW_ruleNum_in_entryRuleNum7984 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleNum7995 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_PLUS_in_ruleNum8036 = new BitSet(new long[] { 0x0000020000040000L });
	public static final BitSet FOLLOW_RULE_DASH_in_ruleNum8062 = new BitSet(new long[] { 0x0000020000040000L });
	public static final BitSet FOLLOW_41_in_ruleNum8084 = new BitSet(new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_RULE_ONE_INT_in_ruleNum8105 = new BitSet(new long[] { 0x0000000000040002L });
	public static final BitSet FOLLOW_RULE_ONE_INT_in_ruleNum8141 = new BitSet(new long[] { 0x0000020000040002L });
	public static final BitSet FOLLOW_41_in_ruleNum8171 = new BitSet(new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_RULE_ONE_INT_in_ruleNum8193 = new BitSet(new long[] { 0x0000000000040002L });
	public static final BitSet FOLLOW_ruleHex_in_entryRuleHex8245 = new BitSet(new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_entryRuleHex8256 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_HASHMARK_in_ruleHex8296 = new BitSet(new long[] { 0x0000000000050000L });
	public static final BitSet FOLLOW_RULE_ONE_INT_in_ruleHex8333 = new BitSet(new long[] { 0x0000000000050002L });
	public static final BitSet FOLLOW_RULE_ONE_HEX_LETTER_in_ruleHex8359 = new BitSet(new long[] { 0x0000000000050002L });
	public static final BitSet FOLLOW_ruleSubSelectorForNegation_in_synpred1_InternalCSS2654 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_UNDERSCORE_in_synpred2_InternalCSS7747 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_DASH_in_synpred2_InternalCSS7755 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_ONE_HEX_LETTER_in_synpred2_InternalCSS7763 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_ONE_NON_HEX_LETTER_in_synpred2_InternalCSS7771 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_ONE_INT_in_synpred2_InternalCSS7779 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleKeywordHack_in_synpred2_InternalCSS7787 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_ONE_INT_in_synpred3_InternalCSS8096 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_ONE_INT_in_synpred4_InternalCSS8132 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_41_in_synpred5_InternalCSS8162 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_RULE_ONE_INT_in_synpred6_InternalCSS8184 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_set_in_synpred7_InternalCSS8312 = new BitSet(new long[] { 0x0000000000000002L });

}