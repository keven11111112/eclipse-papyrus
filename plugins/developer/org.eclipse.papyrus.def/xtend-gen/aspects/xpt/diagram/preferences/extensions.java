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
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *    Thibault Landre (Atos Origin) - initial API and implementation
 */
package aspects.xpt.diagram.preferences;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenPreferencePage;
import org.eclipse.gmf.codegen.gmfgen.GenStandardPreferencePage;
import org.eclipse.gmf.codegen.gmfgen.StandardPreferencePages;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import utils.PrefsConstant_qvto;
import xpt.Common;
import xpt.diagram.Utils_qvto;
import xpt.diagram.preferences.PreferenceInitializer;

@Singleton
@SuppressWarnings("all")
public class extensions extends xpt.diagram.preferences.extensions {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private Utils_qvto _utils_qvto;
  
  @Inject
  @Extension
  private PrefsConstant_qvto _prefsConstant_qvto;
  
  @Inject
  private PreferenceInitializer xptPreferenceInitializer;
  
  public CharSequence extensions(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    String _tripleSpace = this._common.tripleSpace(1);
    _builder.append(_tripleSpace, "");
    _builder.append("<extension point=\"org.eclipse.core.runtime.preferences\" id=\"prefs\">");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_1 = this._common.tripleSpace(2);
    _builder.append(_tripleSpace_1, "");
    CharSequence _xmlGeneratedTag = this._common.xmlGeneratedTag();
    _builder.append(_xmlGeneratedTag, "");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_2 = this._common.tripleSpace(2);
    _builder.append(_tripleSpace_2, "");
    _builder.append("<initializer class=\"");
    CharSequence _qualifiedClassName = this.xptPreferenceInitializer.qualifiedClassName(it);
    _builder.append(_qualifiedClassName, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_3 = this._common.tripleSpace(1);
    _builder.append(_tripleSpace_3, "");
    _builder.append("</extension>");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<GenPreferencePage> _preferencePages = it.getPreferencePages();
      boolean _isEmpty = _preferencePages.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        String _tripleSpace_4 = this._common.tripleSpace(1);
        _builder.append(_tripleSpace_4, "");
        _builder.append("<extension point=\"org.eclipse.ui.preferencePages\" id=\"prefpages\">");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_5 = this._common.tripleSpace(2);
        _builder.append(_tripleSpace_5, "");
        CharSequence _xmlGeneratedTag_1 = this._common.xmlGeneratedTag();
        _builder.append(_xmlGeneratedTag_1, "");
        _builder.newLineIfNotEmpty();
        {
          List<GenPreferencePage> _allPreferencePages = this._utils_qvto.allPreferencePages(it);
          for(final GenPreferencePage pref : _allPreferencePages) {
            {
              if ((pref instanceof GenStandardPreferencePage)) {
                CharSequence _papyrusPreferencePage = this.papyrusPreferencePage(((GenStandardPreferencePage) pref));
                _builder.append(_papyrusPreferencePage, "");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        String _tripleSpace_6 = this._common.tripleSpace(1);
        _builder.append(_tripleSpace_6, "");
        _builder.append("</extension>");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence papyrusPreferencePage(final GenStandardPreferencePage it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      StandardPreferencePages _kind = it.getKind();
      boolean _equals = Objects.equal(StandardPreferencePages.GENERAL_LITERAL, _kind);
      if (_equals) {
        _builder.append("<page");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("id=\"");
        String _diagramPreferencePageCategory = this._prefsConstant_qvto.getDiagramPreferencePageCategory();
        _builder.append(_diagramPreferencePageCategory, "      ");
        _builder.append(".");
        GenDiagram _diagram = it.getDiagram();
        GenEditorGenerator _editorGen = _diagram.getEditorGen();
        String _modelID = _editorGen.getModelID();
        _builder.append(_modelID, "      ");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("      ");
        _builder.append("name=\"");
        GenDiagram _diagram_1 = it.getDiagram();
        GenEditorGenerator _editorGen_1 = _diagram_1.getEditorGen();
        String _modelID_1 = _editorGen_1.getModelID();
        _builder.append(_modelID_1, "      ");
        _builder.append(" Diagram\"");
        _builder.newLineIfNotEmpty();
        _builder.append("      ");
        _builder.append("category=\"");
        String _diagramPreferencePageCategory_1 = this._prefsConstant_qvto.getDiagramPreferencePageCategory();
        _builder.append(_diagramPreferencePageCategory_1, "      ");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("      ");
        _builder.append("class=\"");
        String _qualifiedClassName = it.getQualifiedClassName();
        _builder.append(_qualifiedClassName, "      ");
        _builder.append("\">");
        _builder.newLineIfNotEmpty();
        _builder.append("</page>");
        _builder.newLine();
      } else {
        boolean _or = false;
        StandardPreferencePages _kind_1 = it.getKind();
        boolean _equals_1 = Objects.equal(StandardPreferencePages.PRINTING_LITERAL, _kind_1);
        if (_equals_1) {
          _or = true;
        } else {
          StandardPreferencePages _kind_2 = it.getKind();
          boolean _equals_2 = Objects.equal(StandardPreferencePages.RULERS_AND_GRID_LITERAL, _kind_2);
          _or = _equals_2;
        }
        if (_or) {
          _builder.append("<page");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("id=\"");
          String _qualifiedClassName_1 = it.getQualifiedClassName();
          _builder.append(_qualifiedClassName_1, "      ");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
          _builder.append("      ");
          _builder.append("name=\"%prefpage.");
          String _iD = it.getID();
          _builder.append(_iD, "      ");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
          _builder.append("      ");
          _builder.append("category=\"");
          String _diagramPreferencePageCategory_2 = this._prefsConstant_qvto.getDiagramPreferencePageCategory();
          _builder.append(_diagramPreferencePageCategory_2, "      ");
          _builder.append(".");
          GenDiagram _diagram_2 = it.getDiagram();
          GenEditorGenerator _editorGen_2 = _diagram_2.getEditorGen();
          String _modelID_2 = _editorGen_2.getModelID();
          _builder.append(_modelID_2, "      ");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
          _builder.append("      ");
          _builder.append("class=\"");
          String _qualifiedClassName_2 = it.getQualifiedClassName();
          _builder.append(_qualifiedClassName_2, "      ");
          _builder.append("\">");
          _builder.newLineIfNotEmpty();
          _builder.append("</page>");
          _builder.newLine();
        }
      }
    }
    return _builder;
  }
}
