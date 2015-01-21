/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - #372479, #386838
 */
package aspects.xpt.editor;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Arrays;
import metamodel.MetaModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenConstraint;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderContainer;
import org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.codegen.gmfgen.ValueExpression;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import xpt.CodeStyle;
import xpt.Common;
import xpt.expressions.getExpression;

@Singleton
@SuppressWarnings("all")
public class VisualIDRegistry extends xpt.editor.VisualIDRegistry {
  @Inject
  @Extension
  private MetaModel _metaModel;
  
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  private CodeStyle xptCodeStyle;
  
  @Inject
  private getExpression xptGetExpression;
  
  public CharSequence getDiagramVisualID(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public static int ");
    CharSequence _diagramVisualIDMethodName = this.getDiagramVisualIDMethodName(it);
    _builder.append(_diagramVisualIDMethodName, "");
    _builder.append("(org.eclipse.emf.ecore.EObject domainElement) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("if (domainElement == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _unrecognizedVID = this.unrecognizedVID(it);
    _builder.append(_unrecognizedVID, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ");
    int _visualID = it.getVisualID();
    _builder.append(_visualID, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Support for extra contstraints to check about model element.
   * Includes expression fields for interpreted constrains (like ocl or regexp).
   * For each model element that has an associated constraint, there's a method is<DomainElement>_<UID>()
   * that performs extra specification as defined by value expression
   * 
   * FIXME don't use static fields, replace with instance/separate cache (e.g. accessible from Activator)
   */
  public CharSequence constraintMethods(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      GenEditorGenerator _editorGen = it.getEditorGen();
      GenExpressionProviderContainer _expressionProviders = _editorGen.getExpressionProviders();
      boolean _notEquals = (!Objects.equal(null, _expressionProviders));
      if (_notEquals) {
        {
          EList<GenTopLevelNode> _topLevelNodes = it.getTopLevelNodes();
          final Function1<GenTopLevelNode, Boolean> _function = new Function1<GenTopLevelNode, Boolean>() {
            public Boolean apply(final GenTopLevelNode n) {
              boolean _isSansDomain = n.isSansDomain();
              return Boolean.valueOf((!_isSansDomain));
            }
          };
          Iterable<GenTopLevelNode> _filter = IterableExtensions.<GenTopLevelNode>filter(_topLevelNodes, _function);
          final Function1<GenTopLevelNode, Boolean> _function_1 = new Function1<GenTopLevelNode, Boolean>() {
            public Boolean apply(final GenTopLevelNode n) {
              TypeModelFacet _modelFacet = n.getModelFacet();
              GenConstraint _modelElementSelector = _modelFacet.getModelElementSelector();
              return Boolean.valueOf((!Objects.equal(_modelElementSelector, null)));
            }
          };
          Iterable<GenTopLevelNode> _filter_1 = IterableExtensions.<GenTopLevelNode>filter(_filter, _function_1);
          for(final GenTopLevelNode topNode : _filter_1) {
            CharSequence _constraintMethod = this.constraintMethod(topNode);
            _builder.append(_constraintMethod, "");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          EList<GenChildNode> _childNodes = it.getChildNodes();
          final Function1<GenChildNode, Boolean> _function_2 = new Function1<GenChildNode, Boolean>() {
            public Boolean apply(final GenChildNode n) {
              boolean _isSansDomain = n.isSansDomain();
              return Boolean.valueOf((!_isSansDomain));
            }
          };
          Iterable<GenChildNode> _filter_2 = IterableExtensions.<GenChildNode>filter(_childNodes, _function_2);
          final Function1<GenChildNode, Boolean> _function_3 = new Function1<GenChildNode, Boolean>() {
            public Boolean apply(final GenChildNode n) {
              TypeModelFacet _modelFacet = n.getModelFacet();
              GenConstraint _modelElementSelector = _modelFacet.getModelElementSelector();
              return Boolean.valueOf((!Objects.equal(_modelElementSelector, null)));
            }
          };
          Iterable<GenChildNode> _filter_3 = IterableExtensions.<GenChildNode>filter(_filter_2, _function_3);
          for(final GenChildNode childNode : _filter_3) {
            CharSequence _constraintMethod_1 = this.constraintMethod(childNode);
            _builder.append(_constraintMethod_1, "");
          }
        }
        _builder.newLineIfNotEmpty();
        {
          EList<GenLink> _links = it.getLinks();
          final Function1<GenLink, Boolean> _function_4 = new Function1<GenLink, Boolean>() {
            public Boolean apply(final GenLink n) {
              boolean _isSansDomain = n.isSansDomain();
              return Boolean.valueOf((!_isSansDomain));
            }
          };
          Iterable<GenLink> _filter_4 = IterableExtensions.<GenLink>filter(_links, _function_4);
          for(final GenLink link : _filter_4) {
            LinkModelFacet _modelFacet = link.getModelFacet();
            CharSequence _constraintMethod_2 = this.constraintMethod(_modelFacet, link);
            _builder.append(_constraintMethod_2, "");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence checkDomainElementConstraints(final TypeModelFacet it, final GenCommonBase commonBase) {
    StringConcatenation _builder = new StringConcatenation();
    {
      GenConstraint _modelElementSelector = it.getModelElementSelector();
      boolean _notEquals = (!Objects.equal(null, _modelElementSelector));
      if (_notEquals) {
        {
          boolean _or = false;
          if ((commonBase instanceof GenLink)) {
            _or = true;
          } else {
            _or = (!(it.getModelElementSelector().getProvider() instanceof GenJavaExpressionProvider));
          }
          if (_or) {
            _builder.append("&& ");
            CharSequence _domainElementConstraintMethodName = this.domainElementConstraintMethodName(commonBase);
            _builder.append(_domainElementConstraintMethodName, "");
            _builder.append("(");
            GenClass _metaClass = it.getMetaClass();
            CharSequence _CastEObject = this._metaModel.CastEObject(_metaClass, "domainElement");
            _builder.append(_CastEObject, "");
            _builder.append(")");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("&& ");
            CharSequence _domainElementConstraintMethodName_1 = this.domainElementConstraintMethodName(commonBase);
            _builder.append(_domainElementConstraintMethodName_1, "");
            _builder.append("(containerView, ");
            GenClass _metaClass_1 = it.getMetaClass();
            CharSequence _CastEObject_1 = this._metaModel.CastEObject(_metaClass_1, "domainElement");
            _builder.append(_CastEObject_1, "");
            _builder.append(")");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  protected CharSequence _domainElementConstraintMethod(final GenJavaExpressionProvider it, final GenCommonBase diagramElement, final ValueExpression expression, final GenClass context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t");
    _builder.newLineIfNotEmpty();
    {
      if ((diagramElement instanceof GenLink)) {
        _builder.append("private static boolean ");
        CharSequence _domainElementConstraintMethodName = this.domainElementConstraintMethodName(diagramElement);
        _builder.append(_domainElementConstraintMethodName, "");
        _builder.append("(");
        CharSequence _QualifiedClassName = this._metaModel.QualifiedClassName(context);
        _builder.append(_QualifiedClassName, "");
        _builder.append(" domainElement) {");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("private static boolean ");
        CharSequence _domainElementConstraintMethodName_1 = this.domainElementConstraintMethodName(diagramElement);
        _builder.append(_domainElementConstraintMethodName_1, "");
        _builder.append("(org.eclipse.gmf.runtime.notation.View containerView, ");
        CharSequence _QualifiedClassName_1 = this._metaModel.QualifiedClassName(context);
        _builder.append(_QualifiedClassName_1, "");
        _builder.append(" domainElement) {");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _and = false;
      boolean _isInjectExpressionBody = it.isInjectExpressionBody();
      if (!_isInjectExpressionBody) {
        _and = false;
      } else {
        boolean _and_1 = false;
        String _body = expression.getBody();
        boolean _notEquals = (!Objects.equal(_body, null));
        if (!_notEquals) {
          _and_1 = false;
        } else {
          String _body_1 = expression.getBody();
          int _length = _body_1.length();
          boolean _notEquals_1 = (_length != 0);
          _and_1 = _notEquals_1;
        }
        _and = _and_1;
      }
      if (_and) {
        String _body_2 = expression.getBody();
        _builder.append(_body_2, "");
        _builder.newLineIfNotEmpty();
      } else {
        boolean _or = false;
        boolean _isThrowException = it.isThrowException();
        if (_isThrowException) {
          _or = true;
        } else {
          boolean _and_2 = false;
          boolean _isInjectExpressionBody_1 = it.isInjectExpressionBody();
          if (!_isInjectExpressionBody_1) {
            _and_2 = false;
          } else {
            boolean _or_1 = false;
            String _body_3 = expression.getBody();
            boolean _equals = Objects.equal(_body_3, null);
            if (_equals) {
              _or_1 = true;
            } else {
              String _body_4 = expression.getBody();
              int _length_1 = _body_4.length();
              boolean _equals_1 = (_length_1 == 0);
              _or_1 = _equals_1;
            }
            _and_2 = _or_1;
          }
          _or = _and_2;
        }
        if (_or) {
          _builder.append("// FIXME: implement this method ");
          _builder.newLine();
          _builder.append("// Ensure that you remove @generated or mark it @generated NOT");
          _builder.newLine();
          _builder.append("throw new java.lang.UnsupportedOperationException(\"No java implementation provided in \'");
          CharSequence _domainElementConstraintMethodName_2 = this.domainElementConstraintMethodName(diagramElement);
          _builder.append(_domainElementConstraintMethodName_2, "");
          _builder.append("\' operation\");");
          CharSequence _nonNLS = this._common.nonNLS();
          _builder.append(_nonNLS, "");
          _builder.newLineIfNotEmpty();
        } else {
          _builder.append("return false;");
          _builder.newLine();
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence runtimeTypedInstance(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedClassComment = this._common.generatedClassComment();
    _builder.append(_generatedClassComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public static final org.eclipse.gmf.tooling.runtime.structure.DiagramStructure ");
    CharSequence _runtimeTypedInstanceName = this.runtimeTypedInstanceName(it);
    _builder.append(_runtimeTypedInstanceName, "");
    _builder.append(" = new org.eclipse.gmf.tooling.runtime.structure.DiagramStructure() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _overrideC = this.xptCodeStyle.overrideC(it);
    _builder.append(_overrideC, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public int ");
    CharSequence _visualIdMethodName = this.getVisualIdMethodName(it);
    _builder.append(_visualIdMethodName, "\t");
    _builder.append("(org.eclipse.gmf.runtime.notation.View view) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return ");
    CharSequence _visualIDMethodCall = this.getVisualIDMethodCall(it);
    _builder.append(_visualIDMethodCall, "\t\t");
    _builder.append("(view);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _overrideC_1 = this.xptCodeStyle.overrideC(it);
    _builder.append(_overrideC_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public String ");
    CharSequence _modelIDMethodName = this.getModelIDMethodName(it);
    _builder.append(_modelIDMethodName, "\t");
    _builder.append("(org.eclipse.gmf.runtime.notation.View view) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return ");
    CharSequence _modelIDMethodCall = this.getModelIDMethodCall(it);
    _builder.append(_modelIDMethodCall, "\t\t");
    _builder.append("(view);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_2 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_2, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _overrideC_2 = this.xptCodeStyle.overrideC(it);
    _builder.append(_overrideC_2, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public int ");
    CharSequence _nodeVisualIDMethodName = this.getNodeVisualIDMethodName(it);
    _builder.append(_nodeVisualIDMethodName, "\t");
    _builder.append("(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.emf.ecore.EObject domainElement) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return ");
    CharSequence _nodeVisualIDMethodCall = this.getNodeVisualIDMethodCall(it);
    _builder.append(_nodeVisualIDMethodCall, "\t\t");
    _builder.append("(containerView, domainElement);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_3 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_3, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _overrideC_3 = this.xptCodeStyle.overrideC(it);
    _builder.append(_overrideC_3, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public boolean ");
    CharSequence _checkNodeVisualIDMethodName = this.checkNodeVisualIDMethodName(it);
    _builder.append(_checkNodeVisualIDMethodName, "\t");
    _builder.append("(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.emf.ecore.EObject domainElement, int candidate) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return ");
    CharSequence _checkNodeVisualIDMethodCall = this.checkNodeVisualIDMethodCall(it);
    _builder.append(_checkNodeVisualIDMethodCall, "\t\t");
    _builder.append("(containerView, domainElement, candidate);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_4 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_4, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _overrideC_4 = this.xptCodeStyle.overrideC(it);
    _builder.append(_overrideC_4, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public boolean ");
    CharSequence _isCompartmentVisualIDMethodName = this.isCompartmentVisualIDMethodName(it);
    _builder.append(_isCompartmentVisualIDMethodName, "\t");
    _builder.append("(int visualID) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return ");
    CharSequence _isCompartmentVisualIDMethodCall = this.isCompartmentVisualIDMethodCall(it);
    _builder.append(_isCompartmentVisualIDMethodCall, "\t\t");
    _builder.append("(visualID);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_5 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_5, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _overrideC_5 = this.xptCodeStyle.overrideC(it);
    _builder.append(_overrideC_5, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public boolean ");
    CharSequence _isSemanticLeafVisualIDMethodName = this.isSemanticLeafVisualIDMethodName(it);
    _builder.append(_isSemanticLeafVisualIDMethodName, "\t");
    _builder.append("(int visualID) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return ");
    CharSequence _isSemanticLeafVisualIDMethodCall = this.isSemanticLeafVisualIDMethodCall(it);
    _builder.append(_isSemanticLeafVisualIDMethodCall, "\t\t");
    _builder.append("(visualID);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getModelID(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public static String ");
    CharSequence _modelIDMethodName = this.getModelIDMethodName(it);
    _builder.append(_modelIDMethodName, "");
    _builder.append("(org.eclipse.gmf.runtime.notation.View view) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.notation.View diagram = view.getDiagram();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("while (view != diagram) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.emf.ecore.EAnnotation annotation = view.getEAnnotation(\"Shortcut\"); ");
    CharSequence _nonNLS = this._common.nonNLS(1);
    _builder.append(_nonNLS, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("if (annotation != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return annotation.getDetails().get(\"modelID\"); ");
    CharSequence _nonNLS_1 = this._common.nonNLS(1);
    _builder.append(_nonNLS_1, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("view = (org.eclipse.gmf.runtime.notation.View) view.eContainer();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return diagram != null ? diagram.getType() : null;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence domainElementConstraintMethod(final GenExpressionProviderBase it, final GenCommonBase diagramElement, final ValueExpression expression, final GenClass context) {
    if (it instanceof GenExpressionInterpreter) {
      return _domainElementConstraintMethod((GenExpressionInterpreter)it, diagramElement, expression, context);
    } else if (it instanceof GenJavaExpressionProvider) {
      return _domainElementConstraintMethod((GenJavaExpressionProvider)it, diagramElement, expression, context);
    } else if (it != null) {
      return _domainElementConstraintMethod(it, diagramElement, expression, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, diagramElement, expression, context).toString());
    }
  }
}
