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
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.diagram.editparts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;
import xpt.diagram.editparts.Utils_qvto;

@Singleton
@SuppressWarnings("all")
public class NodeEditPart extends diagram.editparts.NodeEditPart {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private Utils_qvto _utils_qvto;
  
  @Inject
  private impl.diagram.editparts.NodeEditPart xptNodeEditPartImpl;
  
  @Inject
  private aspects.impl.diagram.editparts.NodeEditPart aspectsNodeEditPartImpl;
  
  public CharSequence Main(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    GenDiagram _diagram = it.getDiagram();
    GenEditorGenerator _editorGen = _diagram.getEditorGen();
    CharSequence _copyright = this._common.copyright(_editorGen);
    _builder.append(_copyright, "");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    CharSequence _packageName = this.xptNodeEditPartImpl.packageName(it);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _generatedClassComment = this._common.generatedClassComment();
    _builder.append(_generatedClassComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public class ");
    CharSequence _className = this.xptNodeEditPartImpl.className(it);
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
    CharSequence _attributes = this.attributes(it);
    _builder.append(_attributes, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _constructor = this.xptNodeEditPartImpl.constructor(it);
    _builder.append(_constructor, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _createDefaultEditPolicies = this.createDefaultEditPolicies(it);
    _builder.append(_createDefaultEditPolicies, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _createLayoutEditPolicy = this.xptNodeEditPartImpl.createLayoutEditPolicy(it);
    _builder.append(_createLayoutEditPolicy, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    CharSequence _specificHandleNotificationEvent = this.aspectsNodeEditPartImpl.specificHandleNotificationEvent(it);
    _builder.append(_specificHandleNotificationEvent, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    Viewmap _viewmap = it.getViewmap();
    CharSequence _createNodeShape = this.xptNodeEditPartImpl.createNodeShape(_viewmap, it);
    _builder.append(_createNodeShape, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      boolean _hasFixedChildren = this._utils_qvto.hasFixedChildren(it);
      if (_hasFixedChildren) {
        _builder.append("\t");
        CharSequence _addFixedChild = this.xptNodeEditPartImpl.addFixedChild(it);
        _builder.append(_addFixedChild, "\t");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        CharSequence _removeFixedChild = this.xptNodeEditPartImpl.removeFixedChild(it);
        _builder.append(_removeFixedChild, "\t");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        CharSequence _addChildVisual = this.xptNodeEditPartImpl.addChildVisual(it);
        _builder.append(_addChildVisual, "\t");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        CharSequence _removeChildVisual = this.xptNodeEditPartImpl.removeChildVisual(it);
        _builder.append(_removeChildVisual, "\t");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        CharSequence _contentPaneFor = this.xptNodeEditPartImpl.getContentPaneFor(it);
        _builder.append(_contentPaneFor, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    CharSequence _addBorderItem = this.xptNodeEditPartImpl.addBorderItem(it);
    _builder.append(_addBorderItem, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _createNodePlate = this.xptNodeEditPartImpl.createNodePlate(it);
    _builder.append(_createNodePlate, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _primaryDragEditPolicy = this.xptNodeEditPartImpl.getPrimaryDragEditPolicy(it);
    _builder.append(_primaryDragEditPolicy, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _createFigure = this.xptNodeEditPartImpl.createFigure(it);
    _builder.append(_createFigure, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _setupContentPane = this.xptNodeEditPartImpl.setupContentPane(it);
    _builder.append(_setupContentPane, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _contentPane = this.xptNodeEditPartImpl.getContentPane(it);
    _builder.append(_contentPane, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _setForegroundColor = this.xptNodeEditPartImpl.setForegroundColor(it);
    _builder.append(_setForegroundColor, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _setLineWidth = this.xptNodeEditPartImpl.setLineWidth(it);
    _builder.append(_setLineWidth, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _setLineStyle = this.xptNodeEditPartImpl.setLineStyle(it);
    _builder.append(_setLineStyle, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _primaryChildEditPart = this.xptNodeEditPartImpl.getPrimaryChildEditPart(it);
    _builder.append(_primaryChildEditPart, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    {
      boolean _hasChildrenInListCompartments = this._utils_qvto.hasChildrenInListCompartments(it);
      if (_hasChildrenInListCompartments) {
        CharSequence _targetEditPartMethod = this.xptNodeEditPartImpl.getTargetEditPartMethod(it);
        _builder.append(_targetEditPartMethod, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    CharSequence _handleNotificationEvent = this.handleNotificationEvent(it);
    _builder.append(_handleNotificationEvent, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    Viewmap _viewmap_1 = it.getViewmap();
    CharSequence _innerClassDeclaration = this.xptNodeEditPartImpl.innerClassDeclaration(_viewmap_1);
    _builder.append(_innerClassDeclaration, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _additions = this.additions(it);
    _builder.append(_additions, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence extendsList(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    _builder.append("extends ");
    CharSequence _extendsListContents = this.aspectsNodeEditPartImpl.extendsListContents(it);
    _builder.append(_extendsListContents, " ");
    return _builder;
  }
}
