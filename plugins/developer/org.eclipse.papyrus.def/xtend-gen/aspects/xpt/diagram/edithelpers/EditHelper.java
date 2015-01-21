/**
 * Copyright (c) 2006-2013 Borland Software Corporation and others
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
package aspects.xpt.diagram.edithelpers;

import com.google.inject.Inject;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.MetamodelType;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import utils.EditHelperUtils_qvto;
import xpt.Common;

@SuppressWarnings("all")
public class EditHelper extends xpt.diagram.edithelpers.EditHelper {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private EditHelperUtils_qvto _editHelperUtils_qvto;
  
  public CharSequence EditHelper(final MetamodelType it) {
    StringConcatenation _builder = new StringConcatenation();
    GenCommonBase _diagramElement = it.getDiagramElement();
    GenDiagram _diagram = _diagramElement.getDiagram();
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
    String _editHelperClassName = it.getEditHelperClassName();
    _builder.append(_editHelperClassName, "");
    _builder.append(" extends ");
    GenCommonBase _diagramElement_1 = it.getDiagramElement();
    GenDiagram _diagram_1 = _diagramElement_1.getDiagram();
    String _baseEditHelperFullName = this._editHelperUtils_qvto.getBaseEditHelperFullName(_diagram_1);
    _builder.append(_baseEditHelperFullName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    CharSequence _additions = this.additions(it);
    _builder.append(_additions, "");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
