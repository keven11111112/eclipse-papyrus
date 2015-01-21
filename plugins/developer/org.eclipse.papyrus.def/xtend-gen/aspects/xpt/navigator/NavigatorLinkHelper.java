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
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.navigator;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenNavigator;
import org.eclipse.gmf.codegen.gmfgen.GenNavigatorChildReference;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;
import xpt.navigator.Utils_qvto;

@Singleton
@SuppressWarnings("all")
public class NavigatorLinkHelper extends xpt.navigator.NavigatorLinkHelper {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private Utils_qvto _utils_qvto;
  
  public CharSequence findSelection(final GenNavigator it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public org.eclipse.jface.viewers.IStructuredSelection findSelection(org.eclipse.ui.IEditorInput anInput) {");
    _builder.newLine();
    {
      GenNavigatorChildReference _diagramTopReference = this._utils_qvto.getDiagramTopReference(it);
      boolean _notEquals = (!Objects.equal(_diagramTopReference, null));
      if (_notEquals) {
        _builder.append("\t");
        GenEditorGenerator _editorGen = it.getEditorGen();
        GenPlugin _plugin = _editorGen.getPlugin();
        CharSequence _defineDiagramDocument = this.defineDiagramDocument(_plugin);
        _builder.append(_defineDiagramDocument, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    CharSequence _findSelectionBody = this.findSelectionBody(it);
    _builder.append(_findSelectionBody, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence findSelectionBody(final GenNavigator it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      GenNavigatorChildReference _diagramTopReference = this._utils_qvto.getDiagramTopReference(it);
      boolean _notEquals = (!Objects.equal(_diagramTopReference, null));
      if (_notEquals) {
        GenNavigatorChildReference _diagramTopReference_1 = this._utils_qvto.getDiagramTopReference(it);
        CharSequence _diagramSelection = this.getDiagramSelection(_diagramTopReference_1);
        _builder.append(_diagramSelection, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("return org.eclipse.jface.viewers.StructuredSelection.EMPTY;");
    _builder.newLine();
    return _builder;
  }
}
