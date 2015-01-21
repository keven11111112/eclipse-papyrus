/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - introduced GenAuditContext entity
 *                                 straightforward and simple #validate() implementation
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.providers;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContext;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRoot;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;
import org.eclipse.gmf.codegen.gmfgen.GenAuditable;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenDiagramElementTarget;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderContainer;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import plugin.Activator;
import xpt.CodeStyle;
import xpt.Common;
import xpt.Common_qvto;
import xpt.GenAuditRoot_qvto;
import xpt.editor.VisualIDRegistry;

@Singleton
@SuppressWarnings("all")
public class ValidationProvider extends xpt.providers.ValidationProvider {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private Common_qvto _common_qvto;
  
  @Inject
  @Extension
  private GenAuditRoot_qvto _genAuditRoot_qvto;
  
  @Inject
  @Extension
  private CodeStyle _codeStyle;
  
  @Inject
  private VisualIDRegistry xptVisualIDRegistry;
  
  @Inject
  private Activator xptActivator;
  
  public CharSequence selectors(final GenAuditRoot it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(it, null));
      if (_notEquals) {
        {
          EList<GenAuditContext> _clientContexts = it.getClientContexts();
          boolean _notEquals_1 = (!Objects.equal(_clientContexts, null));
          if (_notEquals_1) {
            {
              EList<GenAuditContext> _clientContexts_1 = it.getClientContexts();
              for(final GenAuditContext ctx : _clientContexts_1) {
                CharSequence _generatedMemberComment = this._common.generatedMemberComment();
                _builder.append(_generatedMemberComment, "");
                _builder.newLineIfNotEmpty();
                _builder.append("public static class ");
                String _className = ctx.getClassName();
                _builder.append(_className, "");
                _builder.append(" implements org.eclipse.emf.validation.model.IClientSelector {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.newLine();
                _builder.append("\t");
                CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
                _builder.append(_generatedMemberComment_1, "\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("public boolean selects(Object object) {");
                _builder.newLine();
                {
                  EList<GenAuditable> _ruleTargets = ctx.getRuleTargets();
                  Iterable<GenDiagramElementTarget> _filter = Iterables.<GenDiagramElementTarget>filter(_ruleTargets, GenDiagramElementTarget.class);
                  boolean _notEmpty = this._common_qvto.<GenDiagramElementTarget>notEmpty(_filter);
                  if (_notEmpty) {
                    _builder.append("\t");
                    _builder.append("if (isInDefaultEditorContext(object) && object instanceof org.eclipse.gmf.runtime.notation.View) {");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("final int id = ");
                    GenEditorGenerator _editorGen = it.getEditorGen();
                    GenDiagram _diagram = _editorGen.getDiagram();
                    CharSequence _visualIDMethodCall = this.xptVisualIDRegistry.getVisualIDMethodCall(_diagram);
                    _builder.append(_visualIDMethodCall, "\t\t");
                    _builder.append("((org.eclipse.gmf.runtime.notation.View) object);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("boolean result = false;");
                    _builder.newLine();
                    {
                      Iterable<GenCommonBase> _targetDiagramElements = this._genAuditRoot_qvto.getTargetDiagramElements(ctx);
                      for(final GenCommonBase e : _targetDiagramElements) {
                        _builder.append("\t");
                        _builder.append("result = result || id == ");
                        CharSequence _visualID = VisualIDRegistry.visualID(e);
                        _builder.append(_visualID, "\t");
                        _builder.append(";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("return result;");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("return false;");
                    _builder.newLine();
                  } else {
                    _builder.append("\t");
                    _builder.append("return isInDefaultEditorContext(object);");
                    _builder.newLine();
                  }
                }
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence constraintAdapters(final GenAuditRoot it, final GenDiagram diagram) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(it, null));
      if (_notEquals) {
        {
          GenEditorGenerator _editorGen = diagram.getEditorGen();
          GenExpressionProviderContainer _expressionProviders = _editorGen.getExpressionProviders();
          boolean _notEquals_1 = (!Objects.equal(_expressionProviders, null));
          if (_notEquals_1) {
            {
              EList<GenAuditRule> _rules = it.getRules();
              final Function1<GenAuditRule, Boolean> _function = new Function1<GenAuditRule, Boolean>() {
                public Boolean apply(final GenAuditRule a) {
                  return Boolean.valueOf(a.isRequiresConstraintAdapter());
                }
              };
              Iterable<GenAuditRule> _filter = IterableExtensions.<GenAuditRule>filter(_rules, _function);
              for(final GenAuditRule next : _filter) {
                GenEditorGenerator _editorGen_1 = diagram.getEditorGen();
                GenExpressionProviderContainer _expressionProviders_1 = _editorGen_1.getExpressionProviders();
                CharSequence _constraintAdapter = this.constraintAdapter(next, _expressionProviders_1);
                _builder.append(_constraintAdapter, "");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.newLine();
            {
              EList<GenAuditRule> _rules_1 = it.getRules();
              final Function1<GenAuditRule, Boolean> _function_1 = new Function1<GenAuditRule, Boolean>() {
                public Boolean apply(final GenAuditRule a) {
                  return Boolean.valueOf(a.isRequiresConstraintAdapter());
                }
              };
              boolean _exists = IterableExtensions.<GenAuditRule>exists(_rules_1, _function_1);
              if (_exists) {
                CharSequence _constraintAdapters_formatMethod = this.constraintAdapters_formatMethod(it);
                _builder.append(_constraintAdapters_formatMethod, "");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence runWithActiveConstraints(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public static void runWithConstraints(org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain, Runnable operation) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("final Runnable op = operation;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Runnable task = new Runnable() {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _overrideI = this._codeStyle.overrideI(it);
    _builder.append(_overrideI, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("public void run() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("constraintsActive = true;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("op.run();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} finally {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("constraintsActive = false;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("};");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if(editingDomain != null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("editingDomain.runExclusive(task);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (Exception e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    GenEditorGenerator _editorGen = it.getEditorGen();
    GenPlugin _plugin = _editorGen.getPlugin();
    CharSequence _qualifiedClassName = this.xptActivator.qualifiedClassName(_plugin);
    _builder.append(_qualifiedClassName, "\t\t\t");
    _builder.append(".getInstance().logError(\"Validation failed\", e); ");
    CharSequence _nonNLS = this._common.nonNLS(1);
    _builder.append(_nonNLS, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("task.run();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
