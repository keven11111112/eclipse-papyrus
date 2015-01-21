/**
 * Copyright (c) 2007, 2014 Borland Software Corporation, CEA, and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - refactored javaInitilizers not to use methods from GMFGen model
 *                               [221347] Got rid of generated interfaces
 *                               (IObjectInitializer, IFeatureInitializer) and implementation thereof
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *    Christian W. Damus (CEA) - bug 440263
 */
package aspects.xpt.providers;

import aspects.xpt.Common;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import metamodel.MetaModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenElementInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureSeqInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureValueSpec;
import org.eclipse.gmf.codegen.gmfgen.GenLanguage;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkEnd;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.codegen.gmfgen.GenReferenceNewElementSpec;
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.ModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.codegen.gmfgen.ValueExpression;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import plugin.Activator;
import xpt.expressions.AbstractExpression;
import xpt.providers.ElementInitializers_qvto;

/**
 * XXX should generate this class only when there is initialization logic defined in the model
 */
@Singleton
@SuppressWarnings("all")
public class ElementInitializers extends xpt.providers.ElementInitializers {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private ElementInitializers_qvto _elementInitializers_qvto;
  
  @Inject
  private Activator xptActivator;
  
  @Inject
  private AbstractExpression xptAbstractExpression;
  
  @Inject
  private MetaModel xptMetaModel;
  
  protected CharSequence _javaMethod(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isSansDomain = it.isSansDomain();
      boolean _not = (!_isSansDomain);
      if (_not) {
        TypeModelFacet _modelFacet = it.getModelFacet();
        CharSequence _javaMethod = this.javaMethod(_modelFacet, it);
        _builder.append(_javaMethod, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected CharSequence _javaMethod(final GenLink it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isSansDomain = it.isSansDomain();
      boolean _not = (!_isSansDomain);
      if (_not) {
        LinkModelFacet _modelFacet = it.getModelFacet();
        CharSequence _javaMethod = this.javaMethod(_modelFacet, it);
        _builder.append(_javaMethod, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected CharSequence _performInit(final GenFeatureValueSpec it, final GenCommonBase diagramElement, final String instanceVar, final GenClass instanceClass, final List<Integer> counters) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ValueExpression _value = it.getValue();
      GenExpressionProviderBase _provider = _value.getProvider();
      GenLanguage _language = _provider.getLanguage();
      boolean _equals = Objects.equal(_language, GenLanguage.LITERAL_LITERAL);
      if (_equals) {
        GenFeature _feature = it.getFeature();
        ValueExpression _value_1 = it.getValue();
        String _body = _value_1.getBody();
        CharSequence _modifyFeature = this.xptMetaModel.modifyFeature(_feature, instanceVar, instanceClass, _body);
        _builder.append(_modifyFeature, "");
        _builder.newLineIfNotEmpty();
        CharSequence _extraLineBreak = this._common.extraLineBreak();
        _builder.append(_extraLineBreak, "");
        _builder.newLineIfNotEmpty();
      } else {
        String expressionVarName = this._elementInitializers_qvto.getVariableName("value", counters);
        _builder.newLineIfNotEmpty();
        _builder.append("Object ");
        _builder.append(expressionVarName, "");
        _builder.append(" = ");
        ValueExpression _value_2 = it.getValue();
        GenExpressionProviderBase _provider_1 = _value_2.getProvider();
        CharSequence _evaluateExpr = this.evaluateExpr(_provider_1, diagramElement, it, instanceVar);
        _builder.append(_evaluateExpr, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        {
          GenFeature _feature_1 = it.getFeature();
          boolean _isListType = _feature_1.isListType();
          if (_isListType) {
            _builder.append("if (");
            _builder.append(expressionVarName, "");
            _builder.append(" instanceof java.util.Collection) {");
            _builder.newLineIfNotEmpty();
            _builder.append("    ");
            GenFeature _feature_2 = it.getFeature();
            CharSequence _featureValue = this.xptMetaModel.getFeatureValue(_feature_2, instanceVar, instanceClass, true);
            _builder.append(_featureValue, "    ");
            _builder.append(".clear();");
            _builder.newLineIfNotEmpty();
            {
              GenFeature _feature_3 = it.getFeature();
              GenClassifier _typeGenClassifier = _feature_3.getTypeGenClassifier();
              boolean _expressionResultNeedsCast = this._elementInitializers_qvto.expressionResultNeedsCast(_typeGenClassifier);
              if (_expressionResultNeedsCast) {
                _builder.append("    ");
                _builder.append("for (java.util.Iterator it = ((java.util.Collection) ");
                _builder.append(expressionVarName, "    ");
                _builder.append(").iterator(); it.hasNext(); ) {");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("    ");
                _builder.append("Object next = ");
                GenDiagram _diagram = diagramElement.getDiagram();
                CharSequence _qualifiedClassName = this.xptAbstractExpression.qualifiedClassName(_diagram);
                _builder.append(_qualifiedClassName, "        ");
                _builder.append(".performCast(it.next(), ");
                GenFeature _feature_4 = it.getFeature();
                GenClassifier _typeGenClassifier_1 = _feature_4.getTypeGenClassifier();
                CharSequence _MetaClass = this.xptMetaModel.MetaClass(_typeGenClassifier_1);
                _builder.append(_MetaClass, "        ");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("    ");
                GenFeature _feature_5 = it.getFeature();
                CharSequence _featureValue_1 = this.xptMetaModel.getFeatureValue(_feature_5, instanceVar, instanceClass, true);
                _builder.append(_featureValue_1, "        ");
                _builder.append(".add((");
                GenFeature _feature_6 = it.getFeature();
                GenClassifier _typeGenClassifier_2 = _feature_6.getTypeGenClassifier();
                CharSequence _QualifiedClassName = this.xptMetaModel.QualifiedClassName(_typeGenClassifier_2);
                _builder.append(_QualifiedClassName, "        ");
                _builder.append(") next);");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("}");
                _builder.newLine();
              } else {
                _builder.append("    ");
                GenFeature _feature_7 = it.getFeature();
                CharSequence _featureValue_2 = this.xptMetaModel.getFeatureValue(_feature_7, instanceVar, instanceClass, true);
                _builder.append(_featureValue_2, "    ");
                _builder.append(".addAll(((java.util.Collection) ");
                _builder.append(expressionVarName, "    ");
                _builder.append("));");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("} else if(");
            _builder.append(expressionVarName, "");
            _builder.append(" != null) {");
            _builder.newLineIfNotEmpty();
            {
              GenFeature _feature_8 = it.getFeature();
              GenClassifier _typeGenClassifier_3 = _feature_8.getTypeGenClassifier();
              boolean _expressionResultNeedsCast_1 = this._elementInitializers_qvto.expressionResultNeedsCast(_typeGenClassifier_3);
              if (_expressionResultNeedsCast_1) {
                _builder.append("    ");
                _builder.append(expressionVarName, "    ");
                _builder.append(" = ");
                GenDiagram _diagram_1 = diagramElement.getDiagram();
                CharSequence _qualifiedClassName_1 = this.xptAbstractExpression.qualifiedClassName(_diagram_1);
                _builder.append(_qualifiedClassName_1, "    ");
                _builder.append(".performCast(");
                _builder.append(expressionVarName, "    ");
                _builder.append(", ");
                GenFeature _feature_9 = it.getFeature();
                GenClassifier _typeGenClassifier_4 = _feature_9.getTypeGenClassifier();
                CharSequence _MetaClass_1 = this.xptMetaModel.MetaClass(_typeGenClassifier_4);
                _builder.append(_MetaClass_1, "    ");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("    ");
            GenFeature _feature_10 = it.getFeature();
            CharSequence _featureValue_3 = this.xptMetaModel.getFeatureValue(_feature_10, instanceVar, instanceClass, true);
            _builder.append(_featureValue_3, "    ");
            _builder.append(".add((");
            GenFeature _feature_11 = it.getFeature();
            GenClassifier _typeGenClassifier_5 = _feature_11.getTypeGenClassifier();
            CharSequence _QualifiedClassName_1 = this.xptMetaModel.QualifiedClassName(_typeGenClassifier_5);
            _builder.append(_QualifiedClassName_1, "    ");
            _builder.append(") ");
            _builder.append(expressionVarName, "    ");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.append("if(");
            _builder.append(expressionVarName, "");
            _builder.append(" != null) {");
            _builder.newLineIfNotEmpty();
            {
              GenFeature _feature_12 = it.getFeature();
              GenClassifier _typeGenClassifier_6 = _feature_12.getTypeGenClassifier();
              boolean _expressionResultNeedsCast_2 = this._elementInitializers_qvto.expressionResultNeedsCast(_typeGenClassifier_6);
              if (_expressionResultNeedsCast_2) {
                _builder.append("    ");
                CharSequence _extraLineBreak_1 = this._common.extraLineBreak();
                _builder.append(_extraLineBreak_1, "    ");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append(expressionVarName, "    ");
                _builder.append(" = ");
                GenDiagram _diagram_2 = diagramElement.getDiagram();
                CharSequence _qualifiedClassName_2 = this.xptAbstractExpression.qualifiedClassName(_diagram_2);
                _builder.append(_qualifiedClassName_2, "    ");
                _builder.append(".performCast(");
                _builder.append(expressionVarName, "    ");
                _builder.append(", ");
                GenFeature _feature_13 = it.getFeature();
                GenClassifier _typeGenClassifier_7 = _feature_13.getTypeGenClassifier();
                CharSequence _MetaClass_2 = this.xptMetaModel.MetaClass(_typeGenClassifier_7);
                _builder.append(_MetaClass_2, "    ");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("        ");
            GenFeature _feature_14 = it.getFeature();
            CharSequence _setFeatureValue = this.xptMetaModel.setFeatureValue(_feature_14, instanceVar, instanceClass, expressionVarName, true);
            _builder.append(_setFeatureValue, "        ");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }
  
  protected CharSequence _initMethod(final GenFeatureSeqInitializer it, final GenCommonBase diagramElement) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public void init_");
    String _uniqueIdentifier = diagramElement.getUniqueIdentifier();
    _builder.append(_uniqueIdentifier, "");
    _builder.append("(");
    GenClass _elementClass = it.getElementClass();
    CharSequence _QualifiedClassName = this.xptMetaModel.QualifiedClassName(_elementClass);
    _builder.append(_QualifiedClassName, "");
    _builder.append(" instance) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("try {");
    _builder.newLine();
    {
      EList<GenFeatureInitializer> _initializers = it.getInitializers();
      for(final GenFeatureInitializer i : _initializers) {
        _builder.append("\t\t");
        GenClass _elementClass_1 = it.getElementClass();
        EList<GenFeatureInitializer> _initializers_1 = it.getInitializers();
        int _indexOf = _initializers_1.indexOf(i);
        LinkedList<Integer> _newLinkedList = CollectionLiterals.<Integer>newLinkedList(Integer.valueOf(_indexOf));
        CharSequence _performInit = this.performInit(i, diagramElement, "instance", _elementClass_1, _newLinkedList);
        _builder.append(_performInit, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("} catch(RuntimeException e) {");
    _builder.newLine();
    _builder.append("\t\t");
    GenDiagram _diagram = diagramElement.getDiagram();
    GenEditorGenerator _editorGen = _diagram.getEditorGen();
    GenPlugin _plugin = _editorGen.getPlugin();
    CharSequence _qualifiedClassName = this.xptActivator.qualifiedClassName(_plugin);
    _builder.append(_qualifiedClassName, "\t\t");
    _builder.append(".getInstance().logError(\"Element initialization failed\", e); //$NON-NLS-1$");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence javaMethod(final GenLinkEnd it) {
    if (it instanceof GenNode) {
      return _javaMethod((GenNode)it);
    } else if (it instanceof GenLink) {
      return _javaMethod((GenLink)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public CharSequence performInit(final GenFeatureInitializer it, final GenCommonBase diagramElement, final String instanceVar, final GenClass instanceClass, final List<Integer> counters) {
    if (it instanceof GenFeatureValueSpec) {
      return _performInit((GenFeatureValueSpec)it, diagramElement, instanceVar, instanceClass, counters);
    } else if (it instanceof GenReferenceNewElementSpec) {
      return _performInit((GenReferenceNewElementSpec)it, diagramElement, instanceVar, instanceClass, counters);
    } else if (it != null) {
      return _performInit(it, diagramElement, instanceVar, instanceClass, counters);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, diagramElement, instanceVar, instanceClass, counters).toString());
    }
  }
  
  public CharSequence initMethod(final EObject it, final GenCommonBase diagramElement) {
    if (it instanceof GenFeatureSeqInitializer) {
      return _initMethod((GenFeatureSeqInitializer)it, diagramElement);
    } else if (it instanceof TypeModelFacet) {
      return _initMethod((TypeModelFacet)it, diagramElement);
    } else if (it instanceof GenElementInitializer) {
      return _initMethod((GenElementInitializer)it, diagramElement);
    } else if (it instanceof ModelFacet) {
      return _initMethod((ModelFacet)it, diagramElement);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, diagramElement).toString());
    }
  }
}
