/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Ed Seidewitz
 */
package org.eclipse.papyrus.uml.alf.formatting;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.papyrus.uml.alf.services.AlfGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#formatting
 * on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
@SuppressWarnings("all")
public class AlfFormatter extends AbstractDeclarativeFormatter {
  @Inject
  @Extension
  private AlfGrammarAccess _alfGrammarAccess;
  
  @Override
  protected void configureFormatting(final FormattingConfig c) {
    List<Pair<Keyword, Keyword>> _findKeywordPairs = this._alfGrammarAccess.findKeywordPairs("(", ")");
    for (final Pair<Keyword, Keyword> pair : _findKeywordPairs) {
      {
        FormattingConfig.NoSpaceLocator _setNoSpace = c.setNoSpace();
        Keyword _first = pair.getFirst();
        _setNoSpace.after(_first);
        FormattingConfig.NoSpaceLocator _setNoSpace_1 = c.setNoSpace();
        Keyword _second = pair.getSecond();
        _setNoSpace_1.before(_second);
      }
    }
    List<Pair<Keyword, Keyword>> _findKeywordPairs_1 = this._alfGrammarAccess.findKeywordPairs("<", ">");
    for (final Pair<Keyword, Keyword> pair_1 : _findKeywordPairs_1) {
      {
        FormattingConfig.NoSpaceLocator _setNoSpace = c.setNoSpace();
        Keyword _first = pair_1.getFirst();
        _setNoSpace.before(_first);
        FormattingConfig.NoLinewrapLocator _setNoLinewrap = c.setNoLinewrap();
        Keyword _first_1 = pair_1.getFirst();
        _setNoLinewrap.around(_first_1);
        FormattingConfig.NoLinewrapLocator _setNoLinewrap_1 = c.setNoLinewrap();
        Keyword _second = pair_1.getSecond();
        _setNoLinewrap_1.before(_second);
      }
    }
    List<Keyword> _findKeywords = this._alfGrammarAccess.findKeywords("[");
    for (final Keyword openBracket : _findKeywords) {
      FormattingConfig.NoSpaceLocator _setNoSpace = c.setNoSpace();
      _setNoSpace.around(openBracket);
    }
    List<Keyword> _findKeywords_1 = this._alfGrammarAccess.findKeywords("]");
    for (final Keyword closeBracket : _findKeywords_1) {
      FormattingConfig.NoSpaceLocator _setNoSpace_1 = c.setNoSpace();
      _setNoSpace_1.before(closeBracket);
    }
    List<Keyword> _findKeywords_2 = this._alfGrammarAccess.findKeywords(".");
    for (final Keyword dot : _findKeywords_2) {
      FormattingConfig.NoSpaceLocator _setNoSpace_2 = c.setNoSpace();
      _setNoSpace_2.around(dot);
    }
    List<Keyword> _findKeywords_3 = this._alfGrammarAccess.findKeywords("..");
    for (final Keyword dots : _findKeywords_3) {
      FormattingConfig.NoSpaceLocator _setNoSpace_3 = c.setNoSpace();
      _setNoSpace_3.around(dots);
    }
    List<Keyword> _findKeywords_4 = this._alfGrammarAccess.findKeywords("->");
    for (final Keyword arrow : _findKeywords_4) {
      FormattingConfig.NoSpaceLocator _setNoSpace_4 = c.setNoSpace();
      _setNoSpace_4.around(arrow);
    }
    List<Keyword> _findKeywords_5 = this._alfGrammarAccess.findKeywords("=>");
    for (final Keyword arrow_1 : _findKeywords_5) {
      FormattingConfig.NoSpaceLocator _setNoSpace_5 = c.setNoSpace();
      _setNoSpace_5.around(arrow_1);
    }
    List<Keyword> _findKeywords_6 = this._alfGrammarAccess.findKeywords(",");
    for (final Keyword comma : _findKeywords_6) {
      FormattingConfig.NoSpaceLocator _setNoSpace_6 = c.setNoSpace();
      _setNoSpace_6.before(comma);
    }
    List<Keyword> _findKeywords_7 = this._alfGrammarAccess.findKeywords(":");
    for (final Keyword colon : _findKeywords_7) {
      {
        FormattingConfig.NoSpaceLocator _setNoSpace_7 = c.setNoSpace();
        _setNoSpace_7.before(colon);
        FormattingConfig.NoLinewrapLocator _setNoLinewrap = c.setNoLinewrap();
        _setNoLinewrap.after(colon);
      }
    }
    List<Keyword> _findKeywords_8 = this._alfGrammarAccess.findKeywords("::");
    for (final Keyword colons : _findKeywords_8) {
      FormattingConfig.NoSpaceLocator _setNoSpace_7 = c.setNoSpace();
      _setNoSpace_7.around(colons);
    }
    List<Keyword> _findKeywords_9 = this._alfGrammarAccess.findKeywords(";");
    for (final Keyword semicolon : _findKeywords_9) {
      {
        FormattingConfig.LinewrapLocator _setLinewrap = c.setLinewrap();
        _setLinewrap.after(semicolon);
        FormattingConfig.NoSpaceLocator _setNoSpace_8 = c.setNoSpace();
        _setNoSpace_8.before(semicolon);
      }
    }
    List<Keyword> _findKeywords_10 = this._alfGrammarAccess.findKeywords("@");
    for (final Keyword atSign : _findKeywords_10) {
      FormattingConfig.NoSpaceLocator _setNoSpace_8 = c.setNoSpace();
      _setNoSpace_8.after(atSign);
    }
    FormattingConfig.LinewrapLocator _setLinewrap = c.setLinewrap(0, 1, 2);
    TerminalRule _sL_COMMENTRule = this._alfGrammarAccess.getSL_COMMENTRule();
    _setLinewrap.before(_sL_COMMENTRule);
    FormattingConfig.LinewrapLocator _setLinewrap_1 = c.setLinewrap(0, 1, 2);
    TerminalRule _mL_COMMENTRule = this._alfGrammarAccess.getML_COMMENTRule();
    _setLinewrap_1.before(_mL_COMMENTRule);
    FormattingConfig.LinewrapLocator _setLinewrap_2 = c.setLinewrap(0, 1, 1);
    TerminalRule _mL_COMMENTRule_1 = this._alfGrammarAccess.getML_COMMENTRule();
    _setLinewrap_2.after(_mL_COMMENTRule_1);
    FormattingConfig.LinewrapLocator _setLinewrap_3 = c.setLinewrap(0, 2, 2);
    TerminalRule _dOCUMENTATION_COMMENTRule = this._alfGrammarAccess.getDOCUMENTATION_COMMENTRule();
    _setLinewrap_3.before(_dOCUMENTATION_COMMENTRule);
    FormattingConfig.LinewrapLocator _setLinewrap_4 = c.setLinewrap(0, 1, 1);
    TerminalRule _dOCUMENTATION_COMMENTRule_1 = this._alfGrammarAccess.getDOCUMENTATION_COMMENTRule();
    _setLinewrap_4.after(_dOCUMENTATION_COMMENTRule_1);
    FormattingConfig.NoSpaceLocator _setNoSpace_9 = c.setNoSpace();
    AlfGrammarAccess.TupleElements _tupleAccess = this._alfGrammarAccess.getTupleAccess();
    Keyword _leftParenthesisKeyword_0 = _tupleAccess.getLeftParenthesisKeyword_0();
    _setNoSpace_9.before(_leftParenthesisKeyword_0);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement = c.setIndentationIncrement();
    AlfGrammarAccess.TupleElements _tupleAccess_1 = this._alfGrammarAccess.getTupleAccess();
    Keyword _leftParenthesisKeyword_0_1 = _tupleAccess_1.getLeftParenthesisKeyword_0();
    _setIndentationIncrement.after(_leftParenthesisKeyword_0_1);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement = c.setIndentationDecrement();
    AlfGrammarAccess.TupleElements _tupleAccess_2 = this._alfGrammarAccess.getTupleAccess();
    Keyword _rightParenthesisKeyword_2 = _tupleAccess_2.getRightParenthesisKeyword_2();
    _setIndentationDecrement.before(_rightParenthesisKeyword_2);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_1 = c.setIndentationIncrement();
    AlfGrammarAccess.BlockElements _blockAccess = this._alfGrammarAccess.getBlockAccess();
    Keyword _leftCurlyBracketKeyword_1 = _blockAccess.getLeftCurlyBracketKeyword_1();
    _setIndentationIncrement_1.after(_leftCurlyBracketKeyword_1);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_1 = c.setIndentationDecrement();
    AlfGrammarAccess.BlockElements _blockAccess_1 = this._alfGrammarAccess.getBlockAccess();
    Keyword _rightCurlyBracketKeyword_3 = _blockAccess_1.getRightCurlyBracketKeyword_3();
    _setIndentationDecrement_1.before(_rightCurlyBracketKeyword_3);
    FormattingConfig.LinewrapLocator _setLinewrap_5 = c.setLinewrap();
    AlfGrammarAccess.BlockElements _blockAccess_2 = this._alfGrammarAccess.getBlockAccess();
    Keyword _leftCurlyBracketKeyword_1_1 = _blockAccess_2.getLeftCurlyBracketKeyword_1();
    _setLinewrap_5.after(_leftCurlyBracketKeyword_1_1);
    FormattingConfig.LinewrapLocator _setLinewrap_6 = c.setLinewrap();
    AlfGrammarAccess.BlockElements _blockAccess_3 = this._alfGrammarAccess.getBlockAccess();
    Keyword _rightCurlyBracketKeyword_3_1 = _blockAccess_3.getRightCurlyBracketKeyword_3();
    _setLinewrap_6.after(_rightCurlyBracketKeyword_3_1);
    FormattingConfig.LinewrapLocator _setLinewrap_7 = c.setLinewrap(2);
    ParserRule _namespaceDeclarationRule = this._alfGrammarAccess.getNamespaceDeclarationRule();
    _setLinewrap_7.after(_namespaceDeclarationRule);
    FormattingConfig.LinewrapLocator _setLinewrap_8 = c.setLinewrap(0, 1, 1);
    ParserRule _namespaceDefinitionRule = this._alfGrammarAccess.getNamespaceDefinitionRule();
    _setLinewrap_8.before(_namespaceDefinitionRule);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_2 = c.setIndentationIncrement();
    AlfGrammarAccess.PackageDefinitionElements _packageDefinitionAccess = this._alfGrammarAccess.getPackageDefinitionAccess();
    Keyword _leftCurlyBracketKeyword_2 = _packageDefinitionAccess.getLeftCurlyBracketKeyword_2();
    _setIndentationIncrement_2.after(_leftCurlyBracketKeyword_2);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_2 = c.setIndentationDecrement();
    AlfGrammarAccess.PackageDefinitionElements _packageDefinitionAccess_1 = this._alfGrammarAccess.getPackageDefinitionAccess();
    Keyword _rightCurlyBracketKeyword_4 = _packageDefinitionAccess_1.getRightCurlyBracketKeyword_4();
    _setIndentationDecrement_2.before(_rightCurlyBracketKeyword_4);
    FormattingConfig.LinewrapLocator _setLinewrap_9 = c.setLinewrap(2);
    AlfGrammarAccess.PackageDefinitionElements _packageDefinitionAccess_2 = this._alfGrammarAccess.getPackageDefinitionAccess();
    Keyword _leftCurlyBracketKeyword_2_1 = _packageDefinitionAccess_2.getLeftCurlyBracketKeyword_2();
    _setLinewrap_9.after(_leftCurlyBracketKeyword_2_1);
    FormattingConfig.LinewrapLocator _setLinewrap_10 = c.setLinewrap(2);
    AlfGrammarAccess.PackageDefinitionElements _packageDefinitionAccess_3 = this._alfGrammarAccess.getPackageDefinitionAccess();
    Keyword _rightCurlyBracketKeyword_4_1 = _packageDefinitionAccess_3.getRightCurlyBracketKeyword_4();
    _setLinewrap_10.before(_rightCurlyBracketKeyword_4_1);
    FormattingConfig.LinewrapLocator _setLinewrap_11 = c.setLinewrap();
    AlfGrammarAccess.PackageDefinitionElements _packageDefinitionAccess_4 = this._alfGrammarAccess.getPackageDefinitionAccess();
    Keyword _rightCurlyBracketKeyword_4_2 = _packageDefinitionAccess_4.getRightCurlyBracketKeyword_4();
    _setLinewrap_11.after(_rightCurlyBracketKeyword_4_2);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_3 = c.setIndentationIncrement();
    AlfGrammarAccess.PackageDefinitionOrStubElements _packageDefinitionOrStubAccess = this._alfGrammarAccess.getPackageDefinitionOrStubAccess();
    Keyword _leftCurlyBracketKeyword_2_1_0 = _packageDefinitionOrStubAccess.getLeftCurlyBracketKeyword_2_1_0();
    _setIndentationIncrement_3.after(_leftCurlyBracketKeyword_2_1_0);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_3 = c.setIndentationDecrement();
    AlfGrammarAccess.PackageDefinitionOrStubElements _packageDefinitionOrStubAccess_1 = this._alfGrammarAccess.getPackageDefinitionOrStubAccess();
    Keyword _rightCurlyBracketKeyword_2_1_2 = _packageDefinitionOrStubAccess_1.getRightCurlyBracketKeyword_2_1_2();
    _setIndentationDecrement_3.before(_rightCurlyBracketKeyword_2_1_2);
    FormattingConfig.LinewrapLocator _setLinewrap_12 = c.setLinewrap(2);
    AlfGrammarAccess.PackageDefinitionOrStubElements _packageDefinitionOrStubAccess_2 = this._alfGrammarAccess.getPackageDefinitionOrStubAccess();
    Keyword _leftCurlyBracketKeyword_2_1_0_1 = _packageDefinitionOrStubAccess_2.getLeftCurlyBracketKeyword_2_1_0();
    _setLinewrap_12.after(_leftCurlyBracketKeyword_2_1_0_1);
    FormattingConfig.LinewrapLocator _setLinewrap_13 = c.setLinewrap(2);
    AlfGrammarAccess.PackageDefinitionOrStubElements _packageDefinitionOrStubAccess_3 = this._alfGrammarAccess.getPackageDefinitionOrStubAccess();
    Keyword _rightCurlyBracketKeyword_2_1_2_1 = _packageDefinitionOrStubAccess_3.getRightCurlyBracketKeyword_2_1_2();
    _setLinewrap_13.before(_rightCurlyBracketKeyword_2_1_2_1);
    FormattingConfig.LinewrapLocator _setLinewrap_14 = c.setLinewrap(2);
    AlfGrammarAccess.PackageDefinitionOrStubElements _packageDefinitionOrStubAccess_4 = this._alfGrammarAccess.getPackageDefinitionOrStubAccess();
    Keyword _rightCurlyBracketKeyword_2_1_2_2 = _packageDefinitionOrStubAccess_4.getRightCurlyBracketKeyword_2_1_2();
    _setLinewrap_14.after(_rightCurlyBracketKeyword_2_1_2_2);
    FormattingConfig.LinewrapLocator _setLinewrap_15 = c.setLinewrap(0, 1, 1);
    ParserRule _importVisibilityIndicatorRule = this._alfGrammarAccess.getImportVisibilityIndicatorRule();
    _setLinewrap_15.before(_importVisibilityIndicatorRule);
    FormattingConfig.NoSpaceLocator _setNoSpace_10 = c.setNoSpace();
    AlfGrammarAccess.ClassDeclarationElements _classDeclarationAccess = this._alfGrammarAccess.getClassDeclarationAccess();
    Keyword _lessThanSignKeyword_3_0 = _classDeclarationAccess.getLessThanSignKeyword_3_0();
    _setNoSpace_10.after(_lessThanSignKeyword_3_0);
    FormattingConfig.NoSpaceLocator _setNoSpace_11 = c.setNoSpace();
    AlfGrammarAccess.ClassDeclarationElements _classDeclarationAccess_1 = this._alfGrammarAccess.getClassDeclarationAccess();
    Keyword _greaterThanSignKeyword_3_3 = _classDeclarationAccess_1.getGreaterThanSignKeyword_3_3();
    _setNoSpace_11.before(_greaterThanSignKeyword_3_3);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_4 = c.setIndentationIncrement();
    AlfGrammarAccess.ClassDefinitionElements _classDefinitionAccess = this._alfGrammarAccess.getClassDefinitionAccess();
    Keyword _leftCurlyBracketKeyword_1_2 = _classDefinitionAccess.getLeftCurlyBracketKeyword_1();
    _setIndentationIncrement_4.after(_leftCurlyBracketKeyword_1_2);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_4 = c.setIndentationDecrement();
    AlfGrammarAccess.ClassDefinitionElements _classDefinitionAccess_1 = this._alfGrammarAccess.getClassDefinitionAccess();
    Keyword _rightCurlyBracketKeyword_3_2 = _classDefinitionAccess_1.getRightCurlyBracketKeyword_3();
    _setIndentationDecrement_4.before(_rightCurlyBracketKeyword_3_2);
    FormattingConfig.LinewrapLocator _setLinewrap_16 = c.setLinewrap(2);
    AlfGrammarAccess.ClassDefinitionElements _classDefinitionAccess_2 = this._alfGrammarAccess.getClassDefinitionAccess();
    Keyword _leftCurlyBracketKeyword_1_3 = _classDefinitionAccess_2.getLeftCurlyBracketKeyword_1();
    _setLinewrap_16.after(_leftCurlyBracketKeyword_1_3);
    FormattingConfig.LinewrapLocator _setLinewrap_17 = c.setLinewrap(2);
    AlfGrammarAccess.ClassDefinitionElements _classDefinitionAccess_3 = this._alfGrammarAccess.getClassDefinitionAccess();
    Keyword _rightCurlyBracketKeyword_3_3 = _classDefinitionAccess_3.getRightCurlyBracketKeyword_3();
    _setLinewrap_17.before(_rightCurlyBracketKeyword_3_3);
    FormattingConfig.LinewrapLocator _setLinewrap_18 = c.setLinewrap();
    AlfGrammarAccess.ClassDefinitionElements _classDefinitionAccess_4 = this._alfGrammarAccess.getClassDefinitionAccess();
    Keyword _rightCurlyBracketKeyword_3_4 = _classDefinitionAccess_4.getRightCurlyBracketKeyword_3();
    _setLinewrap_18.after(_rightCurlyBracketKeyword_3_4);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_5 = c.setIndentationIncrement();
    AlfGrammarAccess.ClassDefinitionOrStubElements _classDefinitionOrStubAccess = this._alfGrammarAccess.getClassDefinitionOrStubAccess();
    Keyword _leftCurlyBracketKeyword_1_1_0 = _classDefinitionOrStubAccess.getLeftCurlyBracketKeyword_1_1_0();
    _setIndentationIncrement_5.after(_leftCurlyBracketKeyword_1_1_0);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_5 = c.setIndentationDecrement();
    AlfGrammarAccess.ClassDefinitionOrStubElements _classDefinitionOrStubAccess_1 = this._alfGrammarAccess.getClassDefinitionOrStubAccess();
    Keyword _rightCurlyBracketKeyword_1_1_2 = _classDefinitionOrStubAccess_1.getRightCurlyBracketKeyword_1_1_2();
    _setIndentationDecrement_5.before(_rightCurlyBracketKeyword_1_1_2);
    FormattingConfig.LinewrapLocator _setLinewrap_19 = c.setLinewrap(2);
    AlfGrammarAccess.ClassDefinitionOrStubElements _classDefinitionOrStubAccess_2 = this._alfGrammarAccess.getClassDefinitionOrStubAccess();
    Keyword _leftCurlyBracketKeyword_1_1_0_1 = _classDefinitionOrStubAccess_2.getLeftCurlyBracketKeyword_1_1_0();
    _setLinewrap_19.after(_leftCurlyBracketKeyword_1_1_0_1);
    FormattingConfig.LinewrapLocator _setLinewrap_20 = c.setLinewrap(2);
    AlfGrammarAccess.ClassDefinitionOrStubElements _classDefinitionOrStubAccess_3 = this._alfGrammarAccess.getClassDefinitionOrStubAccess();
    Keyword _rightCurlyBracketKeyword_1_1_2_1 = _classDefinitionOrStubAccess_3.getRightCurlyBracketKeyword_1_1_2();
    _setLinewrap_20.before(_rightCurlyBracketKeyword_1_1_2_1);
    FormattingConfig.LinewrapLocator _setLinewrap_21 = c.setLinewrap(2);
    AlfGrammarAccess.ClassDefinitionOrStubElements _classDefinitionOrStubAccess_4 = this._alfGrammarAccess.getClassDefinitionOrStubAccess();
    Keyword _rightCurlyBracketKeyword_1_1_2_2 = _classDefinitionOrStubAccess_4.getRightCurlyBracketKeyword_1_1_2();
    _setLinewrap_21.after(_rightCurlyBracketKeyword_1_1_2_2);
    FormattingConfig.LinewrapLocator _setLinewrap_22 = c.setLinewrap();
    ParserRule _visibilityIndicatorRule = this._alfGrammarAccess.getVisibilityIndicatorRule();
    _setLinewrap_22.before(_visibilityIndicatorRule);
    FormattingConfig.NoSpaceLocator _setNoSpace_12 = c.setNoSpace();
    AlfGrammarAccess.ActiveClassDeclarationElements _activeClassDeclarationAccess = this._alfGrammarAccess.getActiveClassDeclarationAccess();
    Keyword _lessThanSignKeyword_4_0 = _activeClassDeclarationAccess.getLessThanSignKeyword_4_0();
    _setNoSpace_12.after(_lessThanSignKeyword_4_0);
    FormattingConfig.NoSpaceLocator _setNoSpace_13 = c.setNoSpace();
    AlfGrammarAccess.ActiveClassDeclarationElements _activeClassDeclarationAccess_1 = this._alfGrammarAccess.getActiveClassDeclarationAccess();
    Keyword _greaterThanSignKeyword_4_3 = _activeClassDeclarationAccess_1.getGreaterThanSignKeyword_4_3();
    _setNoSpace_13.before(_greaterThanSignKeyword_4_3);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_6 = c.setIndentationIncrement();
    AlfGrammarAccess.ActiveClassDefinitionElements _activeClassDefinitionAccess = this._alfGrammarAccess.getActiveClassDefinitionAccess();
    Keyword _leftCurlyBracketKeyword_1_4 = _activeClassDefinitionAccess.getLeftCurlyBracketKeyword_1();
    _setIndentationIncrement_6.after(_leftCurlyBracketKeyword_1_4);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_6 = c.setIndentationDecrement();
    AlfGrammarAccess.ActiveClassDefinitionElements _activeClassDefinitionAccess_1 = this._alfGrammarAccess.getActiveClassDefinitionAccess();
    Keyword _rightCurlyBracketKeyword_3_5 = _activeClassDefinitionAccess_1.getRightCurlyBracketKeyword_3();
    _setIndentationDecrement_6.before(_rightCurlyBracketKeyword_3_5);
    FormattingConfig.LinewrapLocator _setLinewrap_23 = c.setLinewrap(2);
    AlfGrammarAccess.ActiveClassDefinitionElements _activeClassDefinitionAccess_2 = this._alfGrammarAccess.getActiveClassDefinitionAccess();
    Keyword _leftCurlyBracketKeyword_1_5 = _activeClassDefinitionAccess_2.getLeftCurlyBracketKeyword_1();
    _setLinewrap_23.after(_leftCurlyBracketKeyword_1_5);
    FormattingConfig.LinewrapLocator _setLinewrap_24 = c.setLinewrap(2);
    AlfGrammarAccess.ActiveClassDefinitionElements _activeClassDefinitionAccess_3 = this._alfGrammarAccess.getActiveClassDefinitionAccess();
    Keyword _rightCurlyBracketKeyword_3_6 = _activeClassDefinitionAccess_3.getRightCurlyBracketKeyword_3();
    _setLinewrap_24.before(_rightCurlyBracketKeyword_3_6);
    FormattingConfig.LinewrapLocator _setLinewrap_25 = c.setLinewrap();
    AlfGrammarAccess.ActiveClassDefinitionElements _activeClassDefinitionAccess_4 = this._alfGrammarAccess.getActiveClassDefinitionAccess();
    Keyword _rightCurlyBracketKeyword_3_7 = _activeClassDefinitionAccess_4.getRightCurlyBracketKeyword_3();
    _setLinewrap_25.after(_rightCurlyBracketKeyword_3_7);
    FormattingConfig.NoLinewrapLocator _setNoLinewrap = c.setNoLinewrap();
    AlfGrammarAccess.ActiveClassDefinitionElements _activeClassDefinitionAccess_5 = this._alfGrammarAccess.getActiveClassDefinitionAccess();
    Keyword _doKeyword_4_0 = _activeClassDefinitionAccess_5.getDoKeyword_4_0();
    _setNoLinewrap.before(_doKeyword_4_0);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_7 = c.setIndentationIncrement();
    AlfGrammarAccess.ActiveClassDefinitionOrStubElements _activeClassDefinitionOrStubAccess = this._alfGrammarAccess.getActiveClassDefinitionOrStubAccess();
    Keyword _leftCurlyBracketKeyword_1_1_0_2 = _activeClassDefinitionOrStubAccess.getLeftCurlyBracketKeyword_1_1_0();
    _setIndentationIncrement_7.after(_leftCurlyBracketKeyword_1_1_0_2);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_7 = c.setIndentationDecrement();
    AlfGrammarAccess.ActiveClassDefinitionOrStubElements _activeClassDefinitionOrStubAccess_1 = this._alfGrammarAccess.getActiveClassDefinitionOrStubAccess();
    Keyword _rightCurlyBracketKeyword_1_1_2_3 = _activeClassDefinitionOrStubAccess_1.getRightCurlyBracketKeyword_1_1_2();
    _setIndentationDecrement_7.before(_rightCurlyBracketKeyword_1_1_2_3);
    FormattingConfig.LinewrapLocator _setLinewrap_26 = c.setLinewrap(2);
    AlfGrammarAccess.ActiveClassDefinitionOrStubElements _activeClassDefinitionOrStubAccess_2 = this._alfGrammarAccess.getActiveClassDefinitionOrStubAccess();
    Keyword _leftCurlyBracketKeyword_1_1_0_3 = _activeClassDefinitionOrStubAccess_2.getLeftCurlyBracketKeyword_1_1_0();
    _setLinewrap_26.after(_leftCurlyBracketKeyword_1_1_0_3);
    FormattingConfig.LinewrapLocator _setLinewrap_27 = c.setLinewrap(2);
    AlfGrammarAccess.ActiveClassDefinitionOrStubElements _activeClassDefinitionOrStubAccess_3 = this._alfGrammarAccess.getActiveClassDefinitionOrStubAccess();
    Keyword _rightCurlyBracketKeyword_1_1_2_4 = _activeClassDefinitionOrStubAccess_3.getRightCurlyBracketKeyword_1_1_2();
    _setLinewrap_27.before(_rightCurlyBracketKeyword_1_1_2_4);
    FormattingConfig.LinewrapLocator _setLinewrap_28 = c.setLinewrap(2);
    AlfGrammarAccess.ActiveClassDefinitionOrStubElements _activeClassDefinitionOrStubAccess_4 = this._alfGrammarAccess.getActiveClassDefinitionOrStubAccess();
    Keyword _rightCurlyBracketKeyword_1_1_2_5 = _activeClassDefinitionOrStubAccess_4.getRightCurlyBracketKeyword_1_1_2();
    _setLinewrap_28.after(_rightCurlyBracketKeyword_1_1_2_5);
    FormattingConfig.NoLinewrapLocator _setNoLinewrap_1 = c.setNoLinewrap();
    AlfGrammarAccess.ActiveClassDefinitionOrStubElements _activeClassDefinitionOrStubAccess_5 = this._alfGrammarAccess.getActiveClassDefinitionOrStubAccess();
    Keyword _doKeyword_1_1_3_0 = _activeClassDefinitionOrStubAccess_5.getDoKeyword_1_1_3_0();
    _setNoLinewrap_1.before(_doKeyword_1_1_3_0);
    FormattingConfig.LinewrapLocator _setLinewrap_29 = c.setLinewrap(2);
    ParserRule _behaviorClauseRule = this._alfGrammarAccess.getBehaviorClauseRule();
    _setLinewrap_29.after(_behaviorClauseRule);
    FormattingConfig.NoSpaceLocator _setNoSpace_14 = c.setNoSpace();
    AlfGrammarAccess.DataTypeDeclarationElements _dataTypeDeclarationAccess = this._alfGrammarAccess.getDataTypeDeclarationAccess();
    Keyword _lessThanSignKeyword_3_0_1 = _dataTypeDeclarationAccess.getLessThanSignKeyword_3_0();
    _setNoSpace_14.after(_lessThanSignKeyword_3_0_1);
    FormattingConfig.NoSpaceLocator _setNoSpace_15 = c.setNoSpace();
    AlfGrammarAccess.DataTypeDeclarationElements _dataTypeDeclarationAccess_1 = this._alfGrammarAccess.getDataTypeDeclarationAccess();
    Keyword _greaterThanSignKeyword_3_3_1 = _dataTypeDeclarationAccess_1.getGreaterThanSignKeyword_3_3();
    _setNoSpace_15.before(_greaterThanSignKeyword_3_3_1);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_8 = c.setIndentationIncrement();
    AlfGrammarAccess.DataTypeDefinitionElements _dataTypeDefinitionAccess = this._alfGrammarAccess.getDataTypeDefinitionAccess();
    Keyword _leftCurlyBracketKeyword_1_6 = _dataTypeDefinitionAccess.getLeftCurlyBracketKeyword_1();
    _setIndentationIncrement_8.after(_leftCurlyBracketKeyword_1_6);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_8 = c.setIndentationDecrement();
    AlfGrammarAccess.DataTypeDefinitionElements _dataTypeDefinitionAccess_1 = this._alfGrammarAccess.getDataTypeDefinitionAccess();
    Keyword _rightCurlyBracketKeyword_3_8 = _dataTypeDefinitionAccess_1.getRightCurlyBracketKeyword_3();
    _setIndentationDecrement_8.before(_rightCurlyBracketKeyword_3_8);
    FormattingConfig.LinewrapLocator _setLinewrap_30 = c.setLinewrap();
    AlfGrammarAccess.DataTypeDefinitionElements _dataTypeDefinitionAccess_2 = this._alfGrammarAccess.getDataTypeDefinitionAccess();
    Keyword _leftCurlyBracketKeyword_1_7 = _dataTypeDefinitionAccess_2.getLeftCurlyBracketKeyword_1();
    _setLinewrap_30.after(_leftCurlyBracketKeyword_1_7);
    FormattingConfig.LinewrapLocator _setLinewrap_31 = c.setLinewrap();
    AlfGrammarAccess.DataTypeDefinitionElements _dataTypeDefinitionAccess_3 = this._alfGrammarAccess.getDataTypeDefinitionAccess();
    Keyword _rightCurlyBracketKeyword_3_9 = _dataTypeDefinitionAccess_3.getRightCurlyBracketKeyword_3();
    _setLinewrap_31.after(_rightCurlyBracketKeyword_3_9);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_9 = c.setIndentationIncrement();
    AlfGrammarAccess.DataTypeDefinitionOrStubElements _dataTypeDefinitionOrStubAccess = this._alfGrammarAccess.getDataTypeDefinitionOrStubAccess();
    Keyword _leftCurlyBracketKeyword_1_1_0_4 = _dataTypeDefinitionOrStubAccess.getLeftCurlyBracketKeyword_1_1_0();
    _setIndentationIncrement_9.after(_leftCurlyBracketKeyword_1_1_0_4);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_9 = c.setIndentationDecrement();
    AlfGrammarAccess.DataTypeDefinitionOrStubElements _dataTypeDefinitionOrStubAccess_1 = this._alfGrammarAccess.getDataTypeDefinitionOrStubAccess();
    Keyword _rightCurlyBracketKeyword_1_1_2_6 = _dataTypeDefinitionOrStubAccess_1.getRightCurlyBracketKeyword_1_1_2();
    _setIndentationDecrement_9.before(_rightCurlyBracketKeyword_1_1_2_6);
    FormattingConfig.LinewrapLocator _setLinewrap_32 = c.setLinewrap();
    AlfGrammarAccess.DataTypeDefinitionOrStubElements _dataTypeDefinitionOrStubAccess_2 = this._alfGrammarAccess.getDataTypeDefinitionOrStubAccess();
    Keyword _leftCurlyBracketKeyword_1_1_0_5 = _dataTypeDefinitionOrStubAccess_2.getLeftCurlyBracketKeyword_1_1_0();
    _setLinewrap_32.after(_leftCurlyBracketKeyword_1_1_0_5);
    FormattingConfig.LinewrapLocator _setLinewrap_33 = c.setLinewrap(2);
    AlfGrammarAccess.DataTypeDefinitionOrStubElements _dataTypeDefinitionOrStubAccess_3 = this._alfGrammarAccess.getDataTypeDefinitionOrStubAccess();
    Keyword _rightCurlyBracketKeyword_1_1_2_7 = _dataTypeDefinitionOrStubAccess_3.getRightCurlyBracketKeyword_1_1_2();
    _setLinewrap_33.after(_rightCurlyBracketKeyword_1_1_2_7);
    FormattingConfig.NoSpaceLocator _setNoSpace_16 = c.setNoSpace();
    AlfGrammarAccess.AssociationDeclarationElements _associationDeclarationAccess = this._alfGrammarAccess.getAssociationDeclarationAccess();
    Keyword _lessThanSignKeyword_3_0_2 = _associationDeclarationAccess.getLessThanSignKeyword_3_0();
    _setNoSpace_16.after(_lessThanSignKeyword_3_0_2);
    FormattingConfig.NoSpaceLocator _setNoSpace_17 = c.setNoSpace();
    AlfGrammarAccess.AssociationDeclarationElements _associationDeclarationAccess_1 = this._alfGrammarAccess.getAssociationDeclarationAccess();
    Keyword _greaterThanSignKeyword_3_3_2 = _associationDeclarationAccess_1.getGreaterThanSignKeyword_3_3();
    _setNoSpace_17.before(_greaterThanSignKeyword_3_3_2);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_10 = c.setIndentationIncrement();
    AlfGrammarAccess.AssociationDefinitionElements _associationDefinitionAccess = this._alfGrammarAccess.getAssociationDefinitionAccess();
    Keyword _leftCurlyBracketKeyword_1_8 = _associationDefinitionAccess.getLeftCurlyBracketKeyword_1();
    _setIndentationIncrement_10.after(_leftCurlyBracketKeyword_1_8);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_10 = c.setIndentationDecrement();
    AlfGrammarAccess.AssociationDefinitionElements _associationDefinitionAccess_1 = this._alfGrammarAccess.getAssociationDefinitionAccess();
    Keyword _rightCurlyBracketKeyword_3_10 = _associationDefinitionAccess_1.getRightCurlyBracketKeyword_3();
    _setIndentationDecrement_10.before(_rightCurlyBracketKeyword_3_10);
    FormattingConfig.LinewrapLocator _setLinewrap_34 = c.setLinewrap();
    AlfGrammarAccess.AssociationDefinitionElements _associationDefinitionAccess_2 = this._alfGrammarAccess.getAssociationDefinitionAccess();
    Keyword _leftCurlyBracketKeyword_1_9 = _associationDefinitionAccess_2.getLeftCurlyBracketKeyword_1();
    _setLinewrap_34.after(_leftCurlyBracketKeyword_1_9);
    FormattingConfig.LinewrapLocator _setLinewrap_35 = c.setLinewrap();
    AlfGrammarAccess.AssociationDefinitionElements _associationDefinitionAccess_3 = this._alfGrammarAccess.getAssociationDefinitionAccess();
    Keyword _rightCurlyBracketKeyword_3_11 = _associationDefinitionAccess_3.getRightCurlyBracketKeyword_3();
    _setLinewrap_35.after(_rightCurlyBracketKeyword_3_11);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_11 = c.setIndentationIncrement();
    AlfGrammarAccess.AssociationDefinitionOrStubElements _associationDefinitionOrStubAccess = this._alfGrammarAccess.getAssociationDefinitionOrStubAccess();
    Keyword _leftCurlyBracketKeyword_1_1_0_6 = _associationDefinitionOrStubAccess.getLeftCurlyBracketKeyword_1_1_0();
    _setIndentationIncrement_11.after(_leftCurlyBracketKeyword_1_1_0_6);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_11 = c.setIndentationDecrement();
    AlfGrammarAccess.AssociationDefinitionOrStubElements _associationDefinitionOrStubAccess_1 = this._alfGrammarAccess.getAssociationDefinitionOrStubAccess();
    Keyword _rightCurlyBracketKeyword_1_1_2_8 = _associationDefinitionOrStubAccess_1.getRightCurlyBracketKeyword_1_1_2();
    _setIndentationDecrement_11.before(_rightCurlyBracketKeyword_1_1_2_8);
    FormattingConfig.LinewrapLocator _setLinewrap_36 = c.setLinewrap();
    AlfGrammarAccess.AssociationDefinitionOrStubElements _associationDefinitionOrStubAccess_2 = this._alfGrammarAccess.getAssociationDefinitionOrStubAccess();
    Keyword _leftCurlyBracketKeyword_1_1_0_7 = _associationDefinitionOrStubAccess_2.getLeftCurlyBracketKeyword_1_1_0();
    _setLinewrap_36.after(_leftCurlyBracketKeyword_1_1_0_7);
    FormattingConfig.LinewrapLocator _setLinewrap_37 = c.setLinewrap(2);
    AlfGrammarAccess.AssociationDefinitionOrStubElements _associationDefinitionOrStubAccess_3 = this._alfGrammarAccess.getAssociationDefinitionOrStubAccess();
    Keyword _rightCurlyBracketKeyword_1_1_2_9 = _associationDefinitionOrStubAccess_3.getRightCurlyBracketKeyword_1_1_2();
    _setLinewrap_37.after(_rightCurlyBracketKeyword_1_1_2_9);
    FormattingConfig.NoSpaceLocator _setNoSpace_18 = c.setNoSpace();
    AlfGrammarAccess.SignalDeclarationElements _signalDeclarationAccess = this._alfGrammarAccess.getSignalDeclarationAccess();
    Keyword _lessThanSignKeyword_3_0_3 = _signalDeclarationAccess.getLessThanSignKeyword_3_0();
    _setNoSpace_18.after(_lessThanSignKeyword_3_0_3);
    FormattingConfig.NoSpaceLocator _setNoSpace_19 = c.setNoSpace();
    AlfGrammarAccess.SignalDeclarationElements _signalDeclarationAccess_1 = this._alfGrammarAccess.getSignalDeclarationAccess();
    Keyword _greaterThanSignKeyword_3_3_3 = _signalDeclarationAccess_1.getGreaterThanSignKeyword_3_3();
    _setNoSpace_19.before(_greaterThanSignKeyword_3_3_3);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_12 = c.setIndentationIncrement();
    AlfGrammarAccess.SignalDefinitionElements _signalDefinitionAccess = this._alfGrammarAccess.getSignalDefinitionAccess();
    Keyword _leftCurlyBracketKeyword_1_10 = _signalDefinitionAccess.getLeftCurlyBracketKeyword_1();
    _setIndentationIncrement_12.after(_leftCurlyBracketKeyword_1_10);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_12 = c.setIndentationDecrement();
    AlfGrammarAccess.SignalDefinitionElements _signalDefinitionAccess_1 = this._alfGrammarAccess.getSignalDefinitionAccess();
    Keyword _rightCurlyBracketKeyword_3_12 = _signalDefinitionAccess_1.getRightCurlyBracketKeyword_3();
    _setIndentationDecrement_12.before(_rightCurlyBracketKeyword_3_12);
    FormattingConfig.LinewrapLocator _setLinewrap_38 = c.setLinewrap();
    AlfGrammarAccess.SignalDefinitionElements _signalDefinitionAccess_2 = this._alfGrammarAccess.getSignalDefinitionAccess();
    Keyword _leftCurlyBracketKeyword_1_11 = _signalDefinitionAccess_2.getLeftCurlyBracketKeyword_1();
    _setLinewrap_38.after(_leftCurlyBracketKeyword_1_11);
    FormattingConfig.LinewrapLocator _setLinewrap_39 = c.setLinewrap();
    AlfGrammarAccess.SignalDefinitionElements _signalDefinitionAccess_3 = this._alfGrammarAccess.getSignalDefinitionAccess();
    Keyword _rightCurlyBracketKeyword_3_13 = _signalDefinitionAccess_3.getRightCurlyBracketKeyword_3();
    _setLinewrap_39.after(_rightCurlyBracketKeyword_3_13);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_13 = c.setIndentationIncrement();
    AlfGrammarAccess.SignalDefinitionOrStubElements _signalDefinitionOrStubAccess = this._alfGrammarAccess.getSignalDefinitionOrStubAccess();
    Keyword _leftCurlyBracketKeyword_1_1_0_8 = _signalDefinitionOrStubAccess.getLeftCurlyBracketKeyword_1_1_0();
    _setIndentationIncrement_13.after(_leftCurlyBracketKeyword_1_1_0_8);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_13 = c.setIndentationDecrement();
    AlfGrammarAccess.SignalDefinitionOrStubElements _signalDefinitionOrStubAccess_1 = this._alfGrammarAccess.getSignalDefinitionOrStubAccess();
    Keyword _rightCurlyBracketKeyword_1_1_2_10 = _signalDefinitionOrStubAccess_1.getRightCurlyBracketKeyword_1_1_2();
    _setIndentationDecrement_13.before(_rightCurlyBracketKeyword_1_1_2_10);
    FormattingConfig.LinewrapLocator _setLinewrap_40 = c.setLinewrap();
    AlfGrammarAccess.SignalDefinitionOrStubElements _signalDefinitionOrStubAccess_2 = this._alfGrammarAccess.getSignalDefinitionOrStubAccess();
    Keyword _leftCurlyBracketKeyword_1_1_0_9 = _signalDefinitionOrStubAccess_2.getLeftCurlyBracketKeyword_1_1_0();
    _setLinewrap_40.after(_leftCurlyBracketKeyword_1_1_0_9);
    FormattingConfig.LinewrapLocator _setLinewrap_41 = c.setLinewrap(2);
    AlfGrammarAccess.SignalDefinitionOrStubElements _signalDefinitionOrStubAccess_3 = this._alfGrammarAccess.getSignalDefinitionOrStubAccess();
    Keyword _rightCurlyBracketKeyword_1_1_2_11 = _signalDefinitionOrStubAccess_3.getRightCurlyBracketKeyword_1_1_2();
    _setLinewrap_41.after(_rightCurlyBracketKeyword_1_1_2_11);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_14 = c.setIndentationIncrement();
    AlfGrammarAccess.SignalReceptionDefinitionOrStubElements _signalReceptionDefinitionOrStubAccess = this._alfGrammarAccess.getSignalReceptionDefinitionOrStubAccess();
    Keyword _leftCurlyBracketKeyword_1_1_0_10 = _signalReceptionDefinitionOrStubAccess.getLeftCurlyBracketKeyword_1_1_0();
    _setIndentationIncrement_14.after(_leftCurlyBracketKeyword_1_1_0_10);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_14 = c.setIndentationDecrement();
    AlfGrammarAccess.SignalReceptionDefinitionOrStubElements _signalReceptionDefinitionOrStubAccess_1 = this._alfGrammarAccess.getSignalReceptionDefinitionOrStubAccess();
    Keyword _rightCurlyBracketKeyword_1_1_2_12 = _signalReceptionDefinitionOrStubAccess_1.getRightCurlyBracketKeyword_1_1_2();
    _setIndentationDecrement_14.before(_rightCurlyBracketKeyword_1_1_2_12);
    FormattingConfig.LinewrapLocator _setLinewrap_42 = c.setLinewrap();
    AlfGrammarAccess.SignalReceptionDefinitionOrStubElements _signalReceptionDefinitionOrStubAccess_2 = this._alfGrammarAccess.getSignalReceptionDefinitionOrStubAccess();
    Keyword _leftCurlyBracketKeyword_1_1_0_11 = _signalReceptionDefinitionOrStubAccess_2.getLeftCurlyBracketKeyword_1_1_0();
    _setLinewrap_42.after(_leftCurlyBracketKeyword_1_1_0_11);
    FormattingConfig.LinewrapLocator _setLinewrap_43 = c.setLinewrap(2);
    AlfGrammarAccess.SignalReceptionDefinitionOrStubElements _signalReceptionDefinitionOrStubAccess_3 = this._alfGrammarAccess.getSignalReceptionDefinitionOrStubAccess();
    Keyword _rightCurlyBracketKeyword_1_1_2_13 = _signalReceptionDefinitionOrStubAccess_3.getRightCurlyBracketKeyword_1_1_2();
    _setLinewrap_43.after(_rightCurlyBracketKeyword_1_1_2_13);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_15 = c.setIndentationIncrement();
    AlfGrammarAccess.EnumerationDefinitionElements _enumerationDefinitionAccess = this._alfGrammarAccess.getEnumerationDefinitionAccess();
    Keyword _leftCurlyBracketKeyword_1_12 = _enumerationDefinitionAccess.getLeftCurlyBracketKeyword_1();
    _setIndentationIncrement_15.after(_leftCurlyBracketKeyword_1_12);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_15 = c.setIndentationDecrement();
    AlfGrammarAccess.EnumerationDefinitionElements _enumerationDefinitionAccess_1 = this._alfGrammarAccess.getEnumerationDefinitionAccess();
    Keyword _rightCurlyBracketKeyword_3_14 = _enumerationDefinitionAccess_1.getRightCurlyBracketKeyword_3();
    _setIndentationDecrement_15.before(_rightCurlyBracketKeyword_3_14);
    FormattingConfig.LinewrapLocator _setLinewrap_44 = c.setLinewrap();
    AlfGrammarAccess.EnumerationDefinitionElements _enumerationDefinitionAccess_2 = this._alfGrammarAccess.getEnumerationDefinitionAccess();
    Keyword _rightCurlyBracketKeyword_3_15 = _enumerationDefinitionAccess_2.getRightCurlyBracketKeyword_3();
    _setLinewrap_44.after(_rightCurlyBracketKeyword_3_15);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_16 = c.setIndentationIncrement();
    AlfGrammarAccess.EnumerationDefinitionOrStubElements _enumerationDefinitionOrStubAccess = this._alfGrammarAccess.getEnumerationDefinitionOrStubAccess();
    Keyword _leftCurlyBracketKeyword_1_1_0_12 = _enumerationDefinitionOrStubAccess.getLeftCurlyBracketKeyword_1_1_0();
    _setIndentationIncrement_16.after(_leftCurlyBracketKeyword_1_1_0_12);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_16 = c.setIndentationDecrement();
    AlfGrammarAccess.EnumerationDefinitionOrStubElements _enumerationDefinitionOrStubAccess_1 = this._alfGrammarAccess.getEnumerationDefinitionOrStubAccess();
    Keyword _rightCurlyBracketKeyword_1_1_2_14 = _enumerationDefinitionOrStubAccess_1.getRightCurlyBracketKeyword_1_1_2();
    _setIndentationDecrement_16.before(_rightCurlyBracketKeyword_1_1_2_14);
    FormattingConfig.LinewrapLocator _setLinewrap_45 = c.setLinewrap(2);
    AlfGrammarAccess.EnumerationDefinitionOrStubElements _enumerationDefinitionOrStubAccess_2 = this._alfGrammarAccess.getEnumerationDefinitionOrStubAccess();
    Keyword _rightCurlyBracketKeyword_1_1_2_15 = _enumerationDefinitionOrStubAccess_2.getRightCurlyBracketKeyword_1_1_2();
    _setLinewrap_45.after(_rightCurlyBracketKeyword_1_1_2_15);
    FormattingConfig.NoSpaceLocator _setNoSpace_20 = c.setNoSpace();
    AlfGrammarAccess.ActivityDeclarationElements _activityDeclarationAccess = this._alfGrammarAccess.getActivityDeclarationAccess();
    Keyword _lessThanSignKeyword_2_0 = _activityDeclarationAccess.getLessThanSignKeyword_2_0();
    _setNoSpace_20.after(_lessThanSignKeyword_2_0);
    FormattingConfig.NoSpaceLocator _setNoSpace_21 = c.setNoSpace();
    AlfGrammarAccess.ActivityDeclarationElements _activityDeclarationAccess_1 = this._alfGrammarAccess.getActivityDeclarationAccess();
    Keyword _greaterThanSignKeyword_2_3 = _activityDeclarationAccess_1.getGreaterThanSignKeyword_2_3();
    _setNoSpace_21.before(_greaterThanSignKeyword_2_3);
    FormattingConfig.NoSpaceLocator _setNoSpace_22 = c.setNoSpace();
    AlfGrammarAccess.ActivityDeclarationElements _activityDeclarationAccess_2 = this._alfGrammarAccess.getActivityDeclarationAccess();
    Keyword _leftParenthesisKeyword_3 = _activityDeclarationAccess_2.getLeftParenthesisKeyword_3();
    _setNoSpace_22.before(_leftParenthesisKeyword_3);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_17 = c.setIndentationIncrement();
    AlfGrammarAccess.ActivityDeclarationElements _activityDeclarationAccess_3 = this._alfGrammarAccess.getActivityDeclarationAccess();
    Keyword _leftParenthesisKeyword_3_1 = _activityDeclarationAccess_3.getLeftParenthesisKeyword_3();
    _setIndentationIncrement_17.after(_leftParenthesisKeyword_3_1);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_17 = c.setIndentationDecrement();
    AlfGrammarAccess.ActivityDeclarationElements _activityDeclarationAccess_4 = this._alfGrammarAccess.getActivityDeclarationAccess();
    Keyword _rightParenthesisKeyword_5 = _activityDeclarationAccess_4.getRightParenthesisKeyword_5();
    _setIndentationDecrement_17.before(_rightParenthesisKeyword_5);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_18 = c.setIndentationIncrement();
    AlfGrammarAccess.ReturnParameterDefinitionElements _returnParameterDefinitionAccess = this._alfGrammarAccess.getReturnParameterDefinitionAccess();
    Keyword _colonKeyword_0 = _returnParameterDefinitionAccess.getColonKeyword_0();
    _setIndentationIncrement_18.after(_colonKeyword_0);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_18 = c.setIndentationDecrement();
    ParserRule _returnParameterDefinitionRule = this._alfGrammarAccess.getReturnParameterDefinitionRule();
    _setIndentationDecrement_18.after(_returnParameterDefinitionRule);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_19 = c.setIndentationIncrement();
    AlfGrammarAccess.PropertyDeclarationElements _propertyDeclarationAccess = this._alfGrammarAccess.getPropertyDeclarationAccess();
    Keyword _colonKeyword_1 = _propertyDeclarationAccess.getColonKeyword_1();
    _setIndentationIncrement_19.after(_colonKeyword_1);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_19 = c.setIndentationDecrement();
    AlfGrammarAccess.PropertyDefinitionElements _propertyDefinitionAccess = this._alfGrammarAccess.getPropertyDefinitionAccess();
    Keyword _semicolonKeyword_1 = _propertyDefinitionAccess.getSemicolonKeyword_1();
    _setIndentationDecrement_19.after(_semicolonKeyword_1);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_20 = c.setIndentationDecrement();
    AlfGrammarAccess.AttributeDefinitionElements _attributeDefinitionAccess = this._alfGrammarAccess.getAttributeDefinitionAccess();
    Keyword _semicolonKeyword_2 = _attributeDefinitionAccess.getSemicolonKeyword_2();
    _setIndentationDecrement_20.after(_semicolonKeyword_2);
    FormattingConfig.NoSpaceLocator _setNoSpace_23 = c.setNoSpace();
    AlfGrammarAccess.OperationDeclarationElements _operationDeclarationAccess = this._alfGrammarAccess.getOperationDeclarationAccess();
    Keyword _leftParenthesisKeyword_2 = _operationDeclarationAccess.getLeftParenthesisKeyword_2();
    _setNoSpace_23.before(_leftParenthesisKeyword_2);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_20 = c.setIndentationIncrement();
    AlfGrammarAccess.OperationDeclarationElements _operationDeclarationAccess_1 = this._alfGrammarAccess.getOperationDeclarationAccess();
    Keyword _leftParenthesisKeyword_2_1 = _operationDeclarationAccess_1.getLeftParenthesisKeyword_2();
    _setIndentationIncrement_20.after(_leftParenthesisKeyword_2_1);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_21 = c.setIndentationDecrement();
    AlfGrammarAccess.OperationDeclarationElements _operationDeclarationAccess_2 = this._alfGrammarAccess.getOperationDeclarationAccess();
    Keyword _rightParenthesisKeyword_4 = _operationDeclarationAccess_2.getRightParenthesisKeyword_4();
    _setIndentationDecrement_21.before(_rightParenthesisKeyword_4);
    FormattingConfig.NoLinewrapLocator _setNoLinewrap_2 = c.setNoLinewrap();
    ParserRule _parameterDirectionRule = this._alfGrammarAccess.getParameterDirectionRule();
    _setNoLinewrap_2.after(_parameterDirectionRule);
  }
}
