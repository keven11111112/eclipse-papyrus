/**
 * Copyright (c) 2007-2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - [235113] alternative parser access
 *                                 [244419] custom parsers
 *                                 [138179] expression-backed labels
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.impl.parsers;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import impl.parsers.expression_qvto;
import java.util.Arrays;
import metamodel.MetaModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkEnd;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenParserImplementation;
import org.eclipse.gmf.codegen.gmfgen.GenParsers;
import org.eclipse.gmf.codegen.gmfgen.LabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import parsers.ExpressionLabelParser;
import parsers.PredefinedParser;
import plugin.Activator;
import xpt.Common;
import xpt.Common_qvto;
import xpt.editor.VisualIDRegistry;
import xpt.expressions.OclTracker_qvto;
import xpt.expressions.getExpression;
import xpt.providers.ElementTypes;
import xpt.providers.ParserUtils_qvto;

@Singleton
@SuppressWarnings("all")
public class ParserProvider extends impl.parsers.ParserProvider {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private Common_qvto _common_qvto;
  
  @Inject
  @Extension
  private OclTracker_qvto _oclTracker_qvto;
  
  @Inject
  @Extension
  private ParserUtils_qvto _parserUtils_qvto;
  
  @Inject
  @Extension
  private expression_qvto _expression_qvto;
  
  @Inject
  @Extension
  private ExpressionLabelParser _expressionLabelParser;
  
  @Inject
  @Extension
  private PredefinedParser _predefinedParser;
  
  @Inject
  private getExpression xptGetExpression;
  
  @Inject
  private MetaModel xptMetaModel;
  
  @Inject
  private VisualIDRegistry xptVisualIDRegistry;
  
  @Inject
  private ElementTypes xptElementTypes;
  
  @Inject
  private parsers.ParserProvider xptParsers;
  
  @Inject
  private Activator xptActivator;
  
  public CharSequence HintAdapterClass(final GenParsers it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private static class HintAdapter extends org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_1, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("private final org.eclipse.gmf.runtime.emf.type.core.IElementType elementType;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatedMemberComment_2 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_2, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("public HintAdapter(org.eclipse.gmf.runtime.emf.type.core.IElementType type,");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("org.eclipse.emf.ecore.EObject object, String parserHint) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(object, parserHint);");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence __assert = this._common._assert("type != null");
    _builder.append(__assert, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("elementType = type;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatedMemberComment_3 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_3, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("public Object getAdapter(@SuppressWarnings(\"rawtypes\") Class adapter) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (org.eclipse.gmf.runtime.emf.type.core.IElementType.class.equals(adapter)) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return elementType;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return super.getAdapter(adapter);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _dispatch_parsers(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<GenNodeLabel> _labels = it.getLabels();
      for(final GenNodeLabel label : _labels) {
        {
          LabelModelFacet _modelFacet = label.getModelFacet();
          boolean _notEquals = (!Objects.equal(_modelFacet, null));
          if (_notEquals) {
            LabelModelFacet _modelFacet_1 = label.getModelFacet();
            GenParserImplementation _parser = _modelFacet_1.getParser();
            LabelModelFacet _modelFacet_2 = label.getModelFacet();
            CharSequence _dispatch_parser = this.dispatch_parser(_parser, _modelFacet_2, label);
            _builder.append(_dispatch_parser, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  protected CharSequence _dispatch_parsers(final GenLink it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<GenLinkLabel> _labels = it.getLabels();
      for(final GenLinkLabel label : _labels) {
        {
          LabelModelFacet _modelFacet = label.getModelFacet();
          boolean _notEquals = (!Objects.equal(_modelFacet, null));
          if (_notEquals) {
            LabelModelFacet _modelFacet_1 = label.getModelFacet();
            GenParserImplementation _parser = _modelFacet_1.getParser();
            LabelModelFacet _modelFacet_2 = label.getModelFacet();
            CharSequence _dispatch_parser = this.dispatch_parser(_parser, _modelFacet_2, label);
            _builder.append(_dispatch_parser, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  protected CharSequence _dispatch_getParsers(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<GenNodeLabel> _labels = it.getLabels();
      for(final GenNodeLabel label : _labels) {
        {
          LabelModelFacet _modelFacet = label.getModelFacet();
          boolean _notEquals = (!Objects.equal(_modelFacet, null));
          if (_notEquals) {
            LabelModelFacet _modelFacet_1 = label.getModelFacet();
            GenParserImplementation _parser = _modelFacet_1.getParser();
            CharSequence _doGetParser = this.doGetParser(_parser, label);
            _builder.append(_doGetParser, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _dispatch_getParsers(final GenLink it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<GenLinkLabel> _labels = it.getLabels();
      for(final GenLinkLabel label : _labels) {
        {
          LabelModelFacet _modelFacet = label.getModelFacet();
          boolean _notEquals = (!Objects.equal(_modelFacet, null));
          if (_notEquals) {
            LabelModelFacet _modelFacet_1 = label.getModelFacet();
            GenParserImplementation _parser = _modelFacet_1.getParser();
            CharSequence _doGetParser = this.doGetParser(_parser, label);
            _builder.append(_doGetParser, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _dispatch_getParsers(final GenChildLabelNode it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      TypeModelFacet _modelFacet = it.getModelFacet();
      boolean _notEquals = (!Objects.equal(_modelFacet, null));
      if (_notEquals) {
        LabelModelFacet _labelModelFacet = it.getLabelModelFacet();
        GenParserImplementation _parser = _labelModelFacet.getParser();
        CharSequence _doGetParser = this.doGetParser(_parser, it);
        _builder.append(_doGetParser, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence dispatch_parsers(final GenLinkEnd it) {
    if (it instanceof GenChildLabelNode) {
      return _dispatch_parsers((GenChildLabelNode)it);
    } else if (it instanceof GenNode) {
      return _dispatch_parsers((GenNode)it);
    } else if (it instanceof GenLink) {
      return _dispatch_parsers((GenLink)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public CharSequence dispatch_getParsers(final GenLinkEnd it) {
    if (it instanceof GenChildLabelNode) {
      return _dispatch_getParsers((GenChildLabelNode)it);
    } else if (it instanceof GenNode) {
      return _dispatch_getParsers((GenNode)it);
    } else if (it instanceof GenLink) {
      return _dispatch_getParsers((GenLink)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
