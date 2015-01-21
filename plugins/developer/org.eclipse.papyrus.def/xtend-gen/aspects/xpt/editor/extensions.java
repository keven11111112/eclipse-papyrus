/**
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	 Dmitry Stadnik (Borland) - initial API and implementation
 * 	 Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.editor;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenEditorView;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;

@Singleton
@SuppressWarnings("all")
public class extensions extends xpt.editor.extensions {
  @Inject
  @Extension
  private Common _common;
  
  public CharSequence extensions(final GenEditorGenerator it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _extraLineBreak = this._common.extraLineBreak();
    _builder.append(_extraLineBreak, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
    _builder.newLine();
    CharSequence _extraLineBreak_1 = this._common.extraLineBreak();
    _builder.append(_extraLineBreak_1, "");
    String _outTab = this.outTab();
    _builder.append(_outTab, "");
    _builder.newLineIfNotEmpty();
    String _tripleSpace = this._common.tripleSpace(1);
    _builder.append(_tripleSpace, "");
    _builder.append("<extension point=\"org.eclipse.ui.contexts\" id=\"ui-context\">");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_1 = this._common.tripleSpace(2);
    _builder.append(_tripleSpace_1, "");
    CharSequence _xmlGeneratedTag = this._common.xmlGeneratedTag();
    _builder.append(_xmlGeneratedTag, "");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_2 = this._common.tripleSpace(2);
    _builder.append(_tripleSpace_2, "");
    _builder.append("<context");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_3 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_3, "");
    _builder.append("description=\"%context.description\"");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_4 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_4, "");
    _builder.append("id=\"");
    GenEditorView _editor = it.getEditor();
    String _contextID = _editor.getContextID();
    _builder.append(_contextID, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_5 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_5, "");
    _builder.append("name=\"%context.name\"");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_6 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_6, "");
    _builder.append("parentId=\"org.eclipse.gmf.runtime.diagram.ui.diagramContext\">");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_7 = this._common.tripleSpace(2);
    _builder.append(_tripleSpace_7, "");
    _builder.append("</context>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_8 = this._common.tripleSpace(1);
    _builder.append(_tripleSpace_8, "");
    _builder.append("</extension>");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public String outTab() {
    return "\t";
  }
}
