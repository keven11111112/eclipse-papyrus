/**
 * Copyright (c) 2006, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.impl.preferences;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.codegen.gmfgen.GenStandardPreferencePage;
import org.eclipse.gmf.codegen.gmfgen.StandardPreferencePages;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;

@Singleton
@SuppressWarnings("all")
public class StandardPage extends impl.preferences.StandardPage {
  @Inject
  @Extension
  private Common _common;
  
  public CharSequence Main(final GenStandardPreferencePage it) {
    StringConcatenation _builder = new StringConcatenation();
    GenDiagram _diagram = it.getDiagram();
    GenEditorGenerator _editorGen = _diagram.getEditorGen();
    CharSequence _copyright = this._common.copyright(_editorGen);
    _builder.append(_copyright, "");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    CharSequence _packageName = this.packageName(it);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _generatedClassComment = this._common.generatedClassComment();
    _builder.append(_generatedClassComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public class ");
    CharSequence _className = this.className(it);
    _builder.append(_className, "");
    _builder.append(" ");
    CharSequence _extendsList = this.extendsList(it);
    _builder.append(_extendsList, "");
    _builder.append(" ");
    CharSequence _implementsList = this.implementsList(it);
    _builder.append(_implementsList, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public ");
    CharSequence _className_1 = this.className(it);
    _builder.append(_className_1, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("setPreferenceStore(");
    GenDiagram _diagram_1 = it.getDiagram();
    GenEditorGenerator _editorGen_1 = _diagram_1.getEditorGen();
    GenPlugin _plugin = _editorGen_1.getPlugin();
    String _activatorQualifiedClassName = _plugin.getActivatorQualifiedClassName();
    _builder.append(_activatorQualifiedClassName, "\t\t");
    _builder.append(".getInstance().getPreferenceStore());");
    _builder.newLineIfNotEmpty();
    {
      StandardPreferencePages _kind = it.getKind();
      boolean _equals = Objects.equal(StandardPreferencePages.GENERAL_LITERAL, _kind);
      if (_equals) {
        _builder.append("\t\t");
        _builder.append("setPreferenceKey(");
        GenDiagram _diagram_2 = it.getDiagram();
        String _editPartsPackageName = _diagram_2.getEditPartsPackageName();
        _builder.append(_editPartsPackageName, "\t\t");
        _builder.append(".");
        GenDiagram _diagram_3 = it.getDiagram();
        String _editPartClassName = _diagram_3.getEditPartClassName();
        _builder.append(_editPartClassName, "\t\t");
        _builder.append(".MODEL_ID);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence extendsList(final GenStandardPreferencePage it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      StandardPreferencePages _kind = it.getKind();
      boolean _equals = Objects.equal(_kind, StandardPreferencePages.GENERAL_LITERAL);
      if (_equals) {
        _builder.append("extends org.eclipse.papyrus.infra.gmfdiag.preferences.pages.DiagramPreferencePage");
        _builder.newLine();
      } else {
        StandardPreferencePages _kind_1 = it.getKind();
        boolean _equals_1 = Objects.equal(_kind_1, StandardPreferencePages.APPEARANCE_LITERAL);
        if (_equals_1) {
          _builder.append("extends org.eclipse.gmf.runtime.diagram.ui.preferences.AppearancePreferencePage");
          _builder.newLine();
        } else {
          StandardPreferencePages _kind_2 = it.getKind();
          boolean _equals_2 = Objects.equal(_kind_2, StandardPreferencePages.CONNECTIONS_LITERAL);
          if (_equals_2) {
            _builder.append("extends org.eclipse.gmf.runtime.diagram.ui.preferences.ConnectionsPreferencePage");
            _builder.newLine();
          } else {
            StandardPreferencePages _kind_3 = it.getKind();
            boolean _equals_3 = Objects.equal(_kind_3, StandardPreferencePages.PRINTING_LITERAL);
            if (_equals_3) {
              _builder.append("extends org.eclipse.gmf.runtime.diagram.ui.preferences.PrintingPreferencePage");
              _builder.newLine();
            } else {
              StandardPreferencePages _kind_4 = it.getKind();
              boolean _equals_4 = Objects.equal(_kind_4, StandardPreferencePages.RULERS_AND_GRID_LITERAL);
              if (_equals_4) {
                _builder.append("extends org.eclipse.gmf.runtime.diagram.ui.preferences.RulerGridPreferencePage");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    return _builder;
  }
}
