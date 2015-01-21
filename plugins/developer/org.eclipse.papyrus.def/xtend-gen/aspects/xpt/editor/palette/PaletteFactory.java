/**
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.editor.palette;

import aspects.xpt.editor.palette.Utils_qvto;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.codegen.gmfgen.AbstractToolEntry;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.ToolEntry;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;
import xpt.Common_qvto;
import xpt.providers.ElementTypes;

@Singleton
@SuppressWarnings("all")
public class PaletteFactory extends xpt.editor.palette.PaletteFactory {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private Common_qvto _common_qvto;
  
  @Inject
  @Extension
  private Utils_qvto _utils_qvto;
  
  @Inject
  private ElementTypes xptElementTypes;
  
  public CharSequence PaletteFactory(final Palette it) {
    StringConcatenation _builder = new StringConcatenation();
    GenDiagram _diagram = it.getDiagram();
    GenEditorGenerator _editorGen = _diagram.getEditorGen();
    CharSequence _copyright = this._common.copyright(_editorGen);
    _builder.append(_copyright, "");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    String _packageName = it.getPackageName();
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _generatedClassComment = this._common.generatedClassComment();
    _builder.append(_generatedClassComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public class ");
    String _factoryClassName = it.getFactoryClassName();
    _builder.append(_factoryClassName, "");
    _builder.append(" extends org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory.Adapter {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//RS: New Palette generation");
    _builder.newLine();
    _builder.newLine();
    _builder.append("//Generates the ID for the tool elements");
    _builder.newLine();
    _builder.append("//Generate the tool factory (if(ID) createtool...)");
    _builder.newLine();
    {
      Iterable<AbstractToolEntry> _collectTools = this._utils_qvto.collectTools(it);
      for(final AbstractToolEntry tool : _collectTools) {
        CharSequence _generateIDAttribute = this.generateIDAttribute(tool);
        _builder.append(_generateIDAttribute, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public ");
    String _factoryClassName_1 = it.getFactoryClassName();
    _builder.append(_factoryClassName_1, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generateCreateTool = this.generateCreateTool(it);
    _builder.append(_generateCreateTool, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generateGetTemplate = this.generateGetTemplate(it);
    _builder.append(_generateGetTemplate, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    {
      Iterable<AbstractToolEntry> _collectTools_1 = this._utils_qvto.collectTools(it);
      for(final AbstractToolEntry tool_1 : _collectTools_1) {
        CharSequence _createTool = this.createTool(tool_1);
        _builder.append(_createTool, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateCreateTool(final Palette it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public org.eclipse.gef.Tool createTool(String toolId) {");
    _builder.newLine();
    {
      Iterable<AbstractToolEntry> _collectTools = this._utils_qvto.collectTools(it);
      for(final AbstractToolEntry tool : _collectTools) {
        _builder.append("\t\t");
        CharSequence _checkToolID = this.checkToolID(tool);
        _builder.append(_checkToolID, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("// default return: null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence checkToolID(final AbstractToolEntry it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (toolId.equals(");
    String _id = it.getId();
    String _constantIDName = this._utils_qvto.getConstantIDName(_id);
    _builder.append(_constantIDName, "");
    _builder.append(")) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return ");
    String _createMethodName = it.getCreateMethodName();
    _builder.append(_createMethodName, "\t");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateGetTemplate(final Palette it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public Object getTemplate(String templateId) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// default return: null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateIDAttribute(final AbstractToolEntry it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private final static String ");
    String _id = it.getId();
    String _constantIDName = this._utils_qvto.getConstantIDName(_id);
    _builder.append(_constantIDName, "");
    _builder.append(" = ");
    String _id_1 = it.getId();
    _builder.append(_id_1, "");
    _builder.append(";");
    {
      String _id_2 = it.getId();
      boolean _isQuoted = this._utils_qvto.isQuoted(_id_2, "\"");
      if (_isQuoted) {
        CharSequence _nonNLS = this._common.nonNLS();
        _builder.append(_nonNLS, "");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence createTool(final AbstractToolEntry it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private org.eclipse.gef.Tool ");
    String _createMethodName = it.getCreateMethodName();
    _builder.append(_createMethodName, "");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _newTool = this.newTool(((ToolEntry) it), "entry");
    _builder.append(_newTool, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence newTool(final ToolEntry it, final String toolVarName) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<GenCommonBase> _elements = it.getElements();
      boolean _isEmpty = _elements.isEmpty();
      if (_isEmpty) {
        this._common_qvto.ERROR("no elements for tool generation (Palette)");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("java.util.List<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new java.util.ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType>(");
        EList<GenCommonBase> _elements_1 = it.getElements();
        int _size = _elements_1.size();
        _builder.append(_size, "");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        {
          EList<GenCommonBase> _elements_2 = it.getElements();
          for(final GenCommonBase e : _elements_2) {
            _builder.append("\t");
            _builder.append("types.add(");
            CharSequence _accessElementType = this.xptElementTypes.accessElementType(e);
            _builder.append(_accessElementType, "\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t\t");
        _builder.append("org.eclipse.gef.Tool tool = new org.eclipse.papyrus.uml.diagram.common.service.");
        {
          EList<GenNode> _genNodes = it.getGenNodes();
          boolean _isEmpty_1 = _genNodes.isEmpty();
          if (_isEmpty_1) {
            _builder.append("AspectUnspecifiedTypeConnectionTool");
          } else {
            _builder.append("AspectUnspecifiedTypeCreationTool");
          }
        }
        _builder.append("(types);");
        _builder.newLineIfNotEmpty();
        _builder.append("return tool;");
        _builder.newLine();
      }
    }
    return _builder;
  }
}
