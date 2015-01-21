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
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.impl.diagram.editparts;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.DesignLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.LabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.ParentAssignedViewmap;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import parsers.ParserProvider;
import xpt.CodeStyle;
import xpt.Common;
import xpt.Common_qvto;
import xpt.diagram.ViewmapAttributesUtils_qvto;

@Singleton
@SuppressWarnings("all")
public class TextAware extends impl.diagram.editparts.TextAware {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private CodeStyle _codeStyle;
  
  @Inject
  @Extension
  private ViewmapAttributesUtils_qvto _viewmapAttributesUtils_qvto;
  
  @Inject
  @Extension
  private ParserProvider _parserProvider;
  
  @Inject
  @Extension
  private Common_qvto _common_qvto;
  
  public CharSequence fields(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private org.eclipse.gef.tools.DirectEditManager manager;");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_1, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private org.eclipse.gmf.runtime.common.ui.services.parser.IParser parser;");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generatedMemberComment_2 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_2, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private java.util.List<?> parserElements;");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generatedMemberComment_3 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_3, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private String defaultText;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatedMemberComment_4 = this._common.generatedMemberComment("direct edition mode (default, undefined, registered editor, etc.)");
    _builder.append(_generatedMemberComment_4, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("protected int directEditionMode = org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition.UNDEFINED_DIRECT_EDITOR;");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generatedMemberComment_5 = this._common.generatedMemberComment("configuration from a registered edit dialog");
    _builder.append(_generatedMemberComment_5, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration configuration;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    return _builder;
  }
  
  public Object methods(final GenCommonBase it, final boolean needsRefreshBounds, final boolean readOnly, final boolean useElementIcon, final Viewmap viewmap, final LabelModelFacet modelFacet, final GenCommonBase host, final GenDiagram diagram) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    _builder.newLine();
    CharSequence _labelTextHelper = this.getLabelTextHelper(it);
    _builder.append(_labelTextHelper, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _setLabelTextHelper = this.setLabelTextHelper(it);
    _builder.append(_setLabelTextHelper, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _labelIconHelper = this.getLabelIconHelper(it);
    _builder.append(_labelIconHelper, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _setLabelIconHelper = this.setLabelIconHelper(it);
    _builder.append(_setLabelIconHelper, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _labelSetter = this.labelSetter(it);
    _builder.append(_labelSetter, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _modelChildren = this.getModelChildren(it);
    _builder.append(_modelChildren, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _childBySemanticHint = this.getChildBySemanticHint(it);
    _builder.append(_childBySemanticHint, "");
    _builder.newLineIfNotEmpty();
    CharSequence _setParser = this.setParser(it);
    _builder.append(_setParser, "");
    _builder.newLineIfNotEmpty();
    CharSequence _parserElement = this.getParserElement(it, modelFacet);
    _builder.append(_parserElement, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _labelIcon = this.getLabelIcon(it, useElementIcon, diagram);
    _builder.append(_labelIcon, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _labelText = this.getLabelText(it);
    _builder.append(_labelText, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _setLabelText = this.setLabelText(it, diagram);
    _builder.append(_setLabelText, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _editText = this.getEditText(it);
    _builder.append(_editText, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _isEditable = this.isEditable(it, readOnly);
    _builder.append(_isEditable, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _editTextValidator = this.getEditTextValidator(it);
    _builder.append(_editTextValidator, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _completionProcessor = this.getCompletionProcessor(it);
    _builder.append(_completionProcessor, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _parserOptions = this.getParserOptions(it);
    _builder.append(_parserOptions, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _parser = this.getParser(it, modelFacet, diagram, host);
    _builder.append(_parser, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _manager = this.getManager(it, diagram);
    _builder.append(_manager, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _setManager = this.setManager(it);
    _builder.append(_setManager, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _performDirectEdit = this.performDirectEdit(it);
    _builder.append(_performDirectEdit, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _performDirectEditAtPoint = this.performDirectEditAtPoint(it);
    _builder.append(_performDirectEditAtPoint, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _performDirectEditWithInitialChar = this.performDirectEditWithInitialChar(it);
    _builder.append(_performDirectEditWithInitialChar, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _performDirectEditRequest = this.performDirectEditRequest(it, diagram);
    _builder.append(_performDirectEditRequest, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _initializeDirectEditManager = this.initializeDirectEditManager(it);
    _builder.append(_initializeDirectEditManager, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _refreshVisuals = this.refreshVisuals(it, needsRefreshBounds);
    _builder.append(_refreshVisuals, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _refreshLabel = this.refreshLabel(it, diagram);
    _builder.append(_refreshLabel, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _refreshUnderline = this.refreshUnderline(it);
    _builder.append(_refreshUnderline, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _refreshStrikeThrough = this.refreshStrikeThrough(it);
    _builder.append(_refreshStrikeThrough, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _refreshFont = this.refreshFont(it);
    _builder.append(_refreshFont, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _setFontColor = this.setFontColor(it);
    _builder.append(_setFontColor, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _addSemanticListeners = this.addSemanticListeners(it);
    _builder.append(_addSemanticListeners, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _removeSemanticListeners = this.removeSemanticListeners(it);
    _builder.append(_removeSemanticListeners, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _accessibleEditPart = this.getAccessibleEditPart(it);
    _builder.append(_accessibleEditPart, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _fontStyleOwnerView = this.getFontStyleOwnerView(it, viewmap);
    _builder.append(_fontStyleOwnerView, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _directEditionType = this.getDirectEditionType(it, Boolean.valueOf(readOnly));
    _builder.append(_directEditionType, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _checkExtendedEditor = this.checkExtendedEditor(it);
    _builder.append(_checkExtendedEditor, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _checkDefaultEdition = this.checkDefaultEdition(it);
    _builder.append(_checkDefaultEdition, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _initExtendedEditorConfiguration = this.initExtendedEditorConfiguration(it);
    _builder.append(_initExtendedEditorConfiguration, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _updateExtendedEditorConfiguration = this.updateExtendedEditorConfiguration(it);
    _builder.append(_updateExtendedEditorConfiguration, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _performDefaultDirectEditorEdit = this.performDefaultDirectEditorEdit(it);
    _builder.append(_performDefaultDirectEditorEdit, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence labelSetterName(final ParentAssignedViewmap it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _setterName = it.getSetterName();
      boolean _notEquals = (!Objects.equal(_setterName, null));
      if (_notEquals) {
        String _setterName_1 = it.getSetterName();
        _builder.append(_setterName_1, "");
      } else {
        _builder.append("setLabel");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence labelSetterName(final Viewmap it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("setLabel");
    return _builder;
  }
  
  public CharSequence getLabelTextHelper(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected String getLabelTextHelper(org.eclipse.draw2d.IFigure figure) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (figure instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return ((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) figure).getText();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else if (figure instanceof org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return ((org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure) figure).getText();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return ((org.eclipse.draw2d.Label) figure).getText();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence setLabelTextHelper(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void setLabelTextHelper(org.eclipse.draw2d.IFigure figure, String text) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (figure instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) figure).setText(text);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else if (figure instanceof org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("((org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure) figure).setText(text);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("((org.eclipse.draw2d.Label) figure).setText(text);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getLabelIconHelper(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.swt.graphics.Image getLabelIconHelper(org.eclipse.draw2d.IFigure figure) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (figure instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return ((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) figure).getIcon();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else if (figure instanceof org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return ((org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure) figure).getIcon();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return ((org.eclipse.draw2d.Label) figure).getIcon();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence setLabelIconHelper(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void setLabelIconHelper(org.eclipse.draw2d.IFigure figure, org.eclipse.swt.graphics.Image icon) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (figure instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) figure).setIcon(icon);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else if (figure instanceof org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("((org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure) figure).setIcon(icon);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("((org.eclipse.draw2d.Label) figure).setIcon(icon);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence labelSetter(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public void ");
    Viewmap _viewmap = it.getViewmap();
    CharSequence _labelSetterName = this.labelSetterName(_viewmap);
    _builder.append(_labelSetterName, "");
    _builder.append("(");
    Viewmap _viewmap_1 = it.getViewmap();
    CharSequence _labelSetterFigureClassName = this.labelSetterFigureClassName(_viewmap_1);
    _builder.append(_labelSetterFigureClassName, "");
    _builder.append(" figure) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("unregisterVisuals();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("setFigure(figure);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("defaultText = getLabelTextHelper(figure);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("registerVisuals();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("refreshVisuals();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence labelSetterFigureClassName(final ParentAssignedViewmap it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _figureQualifiedClassName = it.getFigureQualifiedClassName();
      boolean _notEquals = (!Objects.equal(_figureQualifiedClassName, null));
      if (_notEquals) {
        String _figureQualifiedClassName_1 = it.getFigureQualifiedClassName();
        _builder.append(_figureQualifiedClassName_1, "");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("org.eclipse.draw2d.IFigure");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence labelSetterFigureClassName(final Viewmap it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("org.eclipse.draw2d.IFigure");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getModelChildren(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected java.util.List<?> getModelChildren() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return java.util.Collections.EMPTY_LIST;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getChildBySemanticHint(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart getChildBySemanticHint(String semanticHint) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence setParser(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public void setParser(org.eclipse.gmf.runtime.common.ui.services.parser.IParser parser) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("this.parser = parser;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getParserElement(final GenCommonBase it, final LabelModelFacet modelFacet) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.emf.ecore.EObject getParserElement() {");
    _builder.newLine();
    {
      boolean _equals = Objects.equal(modelFacet, null);
      if (_equals) {
        _builder.append("org.eclipse.emf.ecore.EObject element = resolveSemanticElement();");
        _builder.newLine();
        _builder.append("return element != null ? element : (org.eclipse.gmf.runtime.notation.View) getModel();");
        _builder.newLine();
        _builder.append("\t");
      } else {
        CharSequence _parserElement = this.getParserElement(modelFacet);
        _builder.append(_parserElement, "");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getParserElement(final LabelModelFacet it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return resolveSemanticElement();");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getParserElement(final DesignLabelModelFacet it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return (org.eclipse.gmf.runtime.notation.View) getModel();");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getLabelIcon(final GenCommonBase it, final boolean useElementIcon, final GenDiagram diagram) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.swt.graphics.Image getLabelIcon() {");
    _builder.newLine();
    {
      if (useElementIcon) {
        _builder.append("\t");
        _builder.append("org.eclipse.emf.ecore.EObject parserElement = getParserElement();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if (parserElement == null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("java.util.List<org.eclipse.gmf.runtime.notation.View> views = org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil.findViews(parserElement, getViewer());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("for (org.eclipse.gmf.runtime.notation.View view : views) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("if (org.eclipse.papyrus.infra.emf.appearance.helper.AppearanceHelper.showElementIcon(view)) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("return ");
        String _elementTypesQualifiedClassName = diagram.getElementTypesQualifiedClassName();
        _builder.append(_elementTypesQualifiedClassName, "\t\t\t");
        _builder.append(".getImage(parserElement.eClass());");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return null;");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("return null;");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getLabelText(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected String getLabelText() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String text = null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.emf.ecore.EObject parserElement = getParserElement();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (parserElement != null && getParser() != null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("text = getParser().getPrintString(");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter(parserElement),");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("getParserOptions().intValue());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (text == null || text.length() == 0) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("text = defaultText;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return text;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence setLabelText(final GenCommonBase it, final GenDiagram diagram) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public void setLabelText(String text) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("setLabelTextHelper(getFigure(), text);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Object pdEditPolicy = getEditPolicy(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (pdEditPolicy instanceof ");
    String _textSelectionEditPolicyQualifiedClassName = diagram.getTextSelectionEditPolicyQualifiedClassName();
    _builder.append(_textSelectionEditPolicyQualifiedClassName, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("((");
    String _textSelectionEditPolicyQualifiedClassName_1 = diagram.getTextSelectionEditPolicyQualifiedClassName();
    _builder.append(_textSelectionEditPolicyQualifiedClassName_1, "\t\t");
    _builder.append(") pdEditPolicy).refreshFeedback();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Object sfEditPolicy = getEditPolicy(org.eclipse.gef.EditPolicy.SELECTION_FEEDBACK_ROLE);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (sfEditPolicy instanceof ");
    String _textSelectionEditPolicyQualifiedClassName_2 = diagram.getTextSelectionEditPolicyQualifiedClassName();
    _builder.append(_textSelectionEditPolicyQualifiedClassName_2, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("((");
    String _textSelectionEditPolicyQualifiedClassName_3 = diagram.getTextSelectionEditPolicyQualifiedClassName();
    _builder.append(_textSelectionEditPolicyQualifiedClassName_3, "\t\t");
    _builder.append(") sfEditPolicy).refreshFeedback();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getEditText(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public String getEditText() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (getParserElement() == null || getParser() == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"\"; ");
    CharSequence _nonNLS = this._common.nonNLS();
    _builder.append(_nonNLS, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return getParser().getEditString(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter(getParserElement()),");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("getParserOptions().intValue());");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence isEditable(final GenCommonBase it, final boolean readOnly) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected boolean isEditable() {");
    _builder.newLine();
    {
      if (readOnly) {
        _builder.append("\t");
        _builder.append("return false;");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("return getParser() != null;");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getEditTextValidator(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public org.eclipse.jface.viewers.ICellEditorValidator getEditTextValidator() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return new org.eclipse.jface.viewers.ICellEditorValidator() {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _overrideI = this._codeStyle.overrideI(it);
    _builder.append(_overrideI, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("public String isValid(final Object value) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (value instanceof String) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("final org.eclipse.emf.ecore.EObject element = getParserElement();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("final org.eclipse.gmf.runtime.common.ui.services.parser.IParser parser = getParser();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus valid =");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("(org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus) getEditingDomain().runExclusive(");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("new org.eclipse.emf.transaction.RunnableWithResult.Impl<java.lang.Object>() {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    CharSequence _overrideI_1 = this._codeStyle.overrideI(it);
    _builder.append(_overrideI_1, "\t\t\t\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("public void run() {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("setResult(parser.isValidEditString(new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter(element), (String) value));");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("return valid.getCode() == org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus.EDITABLE ? null : valid.getMessage();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("} catch (InterruptedException ie) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("ie.printStackTrace();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// shouldn\'t get here");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("};");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getCompletionProcessor(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public org.eclipse.jface.text.contentassist.IContentAssistProcessor getCompletionProcessor() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (getParserElement() == null || getParser() == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return getParser().getCompletionProcessor(new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter(getParserElement()));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getParserOptions(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions getParserOptions() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions.NONE;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getParser(final GenCommonBase it, final LabelModelFacet modelFacet, final GenDiagram diagram, final GenCommonBase host) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public org.eclipse.gmf.runtime.common.ui.services.parser.IParser getParser() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (parser == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("parser = ");
    CharSequence _accessorCall = this._parserProvider.accessorCall(it, host, modelFacet, "getParserElement()");
    _builder.append(_accessorCall, "\t\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return parser;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getManager(final GenCommonBase it, final GenDiagram diagram) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.gef.tools.DirectEditManager getManager() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (manager == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("setManager(new org.eclipse.papyrus.uml.diagram.common.directedit.MultilineLabelDirectEditManager(this,");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.papyrus.uml.diagram.common.directedit.MultilineLabelDirectEditManager.getTextCellEditorClass(this),");
    _builder.newLine();
    _builder.append("\t\t\t");
    String _editPartFactoryQualifiedClassName = diagram.getEditPartFactoryQualifiedClassName();
    _builder.append(_editPartFactoryQualifiedClassName, "\t\t\t");
    _builder.append(".getTextCellEditorLocator(this)));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return manager;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence setManager(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void setManager(org.eclipse.gef.tools.DirectEditManager manager) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("this.manager = manager;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence performDirectEdit(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void performDirectEdit() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.swt.custom.BusyIndicator.showWhile(org.eclipse.swt.widgets.Display.getDefault(), new java.lang.Runnable() {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _overrideI = this._codeStyle.overrideI(it);
    _builder.append(_overrideI, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("public void run() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("getManager().show();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence performDirectEditAtPoint(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void performDirectEdit(org.eclipse.draw2d.geometry.Point eventLocation) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (getManager() instanceof org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("((org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager) getManager()).show(eventLocation.getSWTPoint());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence performDirectEditWithInitialChar(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private void performDirectEdit(char initialCharacter) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (getManager() instanceof org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("((org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager) getManager()).show(initialCharacter);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("performDirectEdit();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence performDirectEditRequest(final GenCommonBase it, final GenDiagram diagram) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void performDirectEditRequest(org.eclipse.gef.Request request) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("final org.eclipse.gef.Request theRequest = request;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition.UNDEFINED_DIRECT_EDITOR == directEditionMode) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("directEditionMode = getDirectEditionType();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("switch (directEditionMode) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition.NO_DIRECT_EDITION:");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// no direct edition mode => does nothing");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition.EXTENDED_DIRECT_EDITOR:");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("updateExtendedEditorConfiguration();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (configuration == null || configuration.getLanguage() == null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// Create default edit manager");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("setManager(new org.eclipse.papyrus.uml.diagram.common.directedit.MultilineLabelDirectEditManager(this,");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.papyrus.uml.diagram.common.directedit.MultilineLabelDirectEditManager.getTextCellEditorClass(this),");
    _builder.newLine();
    _builder.append("\t\t\t");
    String _editPartFactoryQualifiedClassName = diagram.getEditPartFactoryQualifiedClassName();
    _builder.append(_editPartFactoryQualifiedClassName, "\t\t\t");
    _builder.append(".getTextCellEditorLocator(this)));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("performDefaultDirectEditorEdit(theRequest);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("configuration.preEditAction(resolveSemanticElement());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.jface.dialogs.Dialog dialog = null;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (configuration instanceof org.eclipse.papyrus.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("setManager(((org.eclipse.papyrus.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration) configuration).createDirectEditManager(this));");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("initializeDirectEditManager(theRequest);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} else if (configuration instanceof org.eclipse.papyrus.extensionpoints.editors.configuration.IPopupEditorConfiguration) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper helper = ((org.eclipse.papyrus.extensionpoints.editors.configuration.IPopupEditorConfiguration)configuration).createPopupEditorHelper(this) ;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("helper.showEditor() ;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return ;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("else if(configuration instanceof org.eclipse.papyrus.extensionpoints.editors.configuration.IAdvancedEditorConfiguration) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("dialog = ((org.eclipse.papyrus.extensionpoints.editors.configuration.IAdvancedEditorConfiguration)configuration).createDialog(org.eclipse.ui.PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), resolveSemanticElement(), configuration.getTextToEdit(resolveSemanticElement()));");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} else if(configuration instanceof org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("dialog = new org.eclipse.papyrus.extensionpoints.editors.ui.ExtendedDirectEditionDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), resolveSemanticElement(), configuration.getTextToEdit(resolveSemanticElement()), configuration);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("final org.eclipse.jface.dialogs.Dialog finalDialog = dialog;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (org.eclipse.jface.window.Window.OK == dialog.open()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("org.eclipse.emf.transaction.TransactionalEditingDomain domain = getEditingDomain();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("org.eclipse.emf.transaction.RecordingCommand command = new org.eclipse.emf.transaction.RecordingCommand(domain, \"Edit Label\") {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("protected void doExecute() {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("configuration.postEditAction(resolveSemanticElement(), ((org.eclipse.papyrus.extensionpoints.editors.ui.ILabelEditorDialog)finalDialog).getValue());");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("};");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("domain.getCommandStack().execute(command);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition.DEFAULT_DIRECT_EDITOR:");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("initializeDirectEditManager(theRequest);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence initializeDirectEditManager(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void initializeDirectEditManager(final org.eclipse.gef.Request request) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// initialize the direct edit manager");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("getEditingDomain().runExclusive(new Runnable() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    CharSequence _overrideI = this._codeStyle.overrideI(it);
    _builder.append(_overrideI, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("public void run() {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (isActive() && isEditable()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("if (request.getExtendedData().get(");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("Character initialChar = (Character) request.getExtendedData().get(org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("performDirectEdit(initialChar.charValue());");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("else {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("performDirectEdit();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} catch (InterruptedException e) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("e.printStackTrace();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence refreshVisuals(final GenCommonBase it, final boolean needsRefreshBounds) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void refreshVisuals() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("super.refreshVisuals();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("refreshLabel();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("refreshFont();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("refreshFontColor();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("refreshUnderline();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("refreshStrikeThrough();");
    _builder.newLine();
    {
      if (needsRefreshBounds) {
        _builder.append("\t");
        _builder.append("refreshBounds();");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence refreshLabel(final GenCommonBase it, final GenDiagram diagram) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void refreshLabel() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gef.EditPolicy maskLabelPolicy = getEditPolicy(org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if(maskLabelPolicy==null){");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("maskLabelPolicy = getEditPolicy(org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IndirectMaskLabelEditPolicy.INDRIRECT_MASK_MANAGED_LABEL);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (maskLabelPolicy == null) {");
    _builder.newLine();
    {
      boolean _oclIsKindOf = this._common_qvto.oclIsKindOf(it, GenLinkLabel.class);
      if (_oclIsKindOf) {
        _builder.append("\t");
        _builder.append("setLabelTextHelper(getFigure(), getLabelText());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("setLabelIconHelper(getFigure(), getLabelIcon());");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View)getModel();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if(view.isVisible()) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("setLabelTextHelper(getFigure(), getLabelText());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("setLabelIconHelper(getFigure(), getLabelIcon());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("else {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("setLabelTextHelper(getFigure(), \"\"); //$NON-NLS-1$");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("setLabelIconHelper(getFigure(), null);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Object pdEditPolicy = getEditPolicy(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (pdEditPolicy instanceof ");
    String _textSelectionEditPolicyQualifiedClassName = diagram.getTextSelectionEditPolicyQualifiedClassName();
    _builder.append(_textSelectionEditPolicyQualifiedClassName, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("((");
    String _textSelectionEditPolicyQualifiedClassName_1 = diagram.getTextSelectionEditPolicyQualifiedClassName();
    _builder.append(_textSelectionEditPolicyQualifiedClassName_1, "\t\t");
    _builder.append(") pdEditPolicy).refreshFeedback();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Object sfEditPolicy = getEditPolicy(org.eclipse.gef.EditPolicy.SELECTION_FEEDBACK_ROLE);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (sfEditPolicy instanceof ");
    String _textSelectionEditPolicyQualifiedClassName_2 = diagram.getTextSelectionEditPolicyQualifiedClassName();
    _builder.append(_textSelectionEditPolicyQualifiedClassName_2, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("((");
    String _textSelectionEditPolicyQualifiedClassName_3 = diagram.getTextSelectionEditPolicyQualifiedClassName();
    _builder.append(_textSelectionEditPolicyQualifiedClassName_3, "\t\t");
    _builder.append(") sfEditPolicy).refreshFeedback();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence refreshUnderline(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void refreshUnderline() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.notation.FontStyle style =");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("(org.eclipse.gmf.runtime.notation.FontStyle) getFontStyleOwnerView().getStyle(");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (style != null && getFigure() instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) getFigure()).setTextUnderline(style.isUnderline());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if(resolveSemanticElement() instanceof org.eclipse.uml2.uml.Feature){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if(((org.eclipse.uml2.uml.Feature)resolveSemanticElement()).isStatic()){");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel)getFigure()).setTextUnderline(true);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("else{((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel)getFigure()).setTextUnderline(false);}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence refreshStrikeThrough(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void refreshStrikeThrough() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.notation.FontStyle style =");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("(org.eclipse.gmf.runtime.notation.FontStyle) getFontStyleOwnerView().getStyle(");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (style != null && getFigure() instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) getFigure()).setTextStrikeThrough(style.isStrikeThrough());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence refreshFont(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void refreshFont() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.notation.FontStyle style =");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("(org.eclipse.gmf.runtime.notation.FontStyle) getFontStyleOwnerView().getStyle(");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (style != null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.swt.graphics.FontData fontData = new org.eclipse.swt.graphics.FontData(");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("style.getFontName(), style.getFontHeight(),");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("(style.isBold() ? org.eclipse.swt.SWT.BOLD : org.eclipse.swt.SWT.NORMAL) |");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("(style.isItalic() ? org.eclipse.swt.SWT.ITALIC : org.eclipse.swt.SWT.NORMAL));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("setFont(fontData);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence setFontColor(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void setFontColor(org.eclipse.swt.graphics.Color color) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("getFigure().setForegroundColor(color);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence addSemanticListeners(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void addSemanticListeners() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (getParser() instanceof org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.emf.ecore.EObject element = resolveSemanticElement();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("parserElements = ((org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser) getParser()).getSemanticElementsBeingParsed(element);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (int i = 0; i < parserElements.size(); i++) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("addListenerFilter(\"SemanticModel\" + i, this, (org.eclipse.emf.ecore.EObject) parserElements.get(i)); ");
    CharSequence _nonNLS = this._common.nonNLS();
    _builder.append(_nonNLS, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super.addSemanticListeners();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence removeSemanticListeners(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void removeSemanticListeners() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (parserElements != null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (int i = 0; i < parserElements.size(); i++) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("removeListenerFilter(\"SemanticModel\" + i); ");
    CharSequence _nonNLS = this._common.nonNLS();
    _builder.append(_nonNLS, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super.removeSemanticListeners();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getAccessibleEditPart(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.gef.AccessibleEditPart getAccessibleEditPart() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (accessibleEP == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("accessibleEP = new AccessibleGraphicalEditPart() {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    CharSequence _overrideC = this._codeStyle.overrideC(it);
    _builder.append(_overrideC, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("public void getName(org.eclipse.swt.accessibility.AccessibleEvent e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("e.result = getLabelTextHelper(getFigure());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("};");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return accessibleEP;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getFontStyleOwnerView(final GenCommonBase it, final Viewmap viewmap) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("private org.eclipse.gmf.runtime.notation.View getFontStyleOwnerView() {");
    _builder.newLine();
    {
      boolean _isFixedFont = this._viewmapAttributesUtils_qvto.isFixedFont(viewmap);
      if (_isFixedFont) {
        _builder.append("\t");
        _builder.append("return (org.eclipse.gmf.runtime.notation.View) getModel();");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("return getPrimaryView();");
        _builder.newLine();
      }
    }
    _builder.append(" ");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getDirectEditionType(final GenCommonBase it, final Boolean readOnly) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Returns the kind of associated editor for direct edition.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @return an <code>int</code> corresponding to the kind of direct editor, @see org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @generated");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public int getDirectEditionType() {");
    _builder.newLine();
    {
      if ((readOnly).booleanValue()) {
        _builder.append("\t");
        _builder.append("// The label is read-only (defined in GMFGen model)");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition.NO_DIRECT_EDITION;");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("if (checkExtendedEditor()) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("initExtendedEditorConfiguration();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition.EXTENDED_DIRECT_EDITOR;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if (checkDefaultEdition()) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition.DEFAULT_DIRECT_EDITOR;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("// not a named element. no specific editor => do nothing");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition.NO_DIRECT_EDITION;");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence checkExtendedEditor(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Checks if an extended editor is present.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @return <code>true</code> if an extended editor is present.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @generated");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("protected boolean checkExtendedEditor() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (resolveSemanticElement() != null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil.hasSpecificEditorConfiguration(resolveSemanticElement().eClass().getInstanceClassName());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence checkDefaultEdition(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Checks if a default direct edition is available");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @return <code>true</code> if a default direct edition is available");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @generated");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("protected boolean checkDefaultEdition() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return (getParser() != null);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence initExtendedEditorConfiguration(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Initializes the extended editor configuration");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @generated");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("protected void initExtendedEditorConfiguration() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (configuration == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("final String languagePreferred = org.eclipse.papyrus.extensionpoints.editors.Activator.getDefault().getPreferenceStore().getString(org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds.EDITOR_FOR_ELEMENT + resolveSemanticElement().eClass().getInstanceClassName());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (languagePreferred != null && !languagePreferred.equals(\"\")) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("configuration = org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil.findEditorConfiguration(languagePreferred, resolveSemanticElement().eClass().getInstanceClassName());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("configuration = org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil.findEditorConfiguration(org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds.UML_LANGUAGE, resolveSemanticElement().eClass().getInstanceClassName());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence updateExtendedEditorConfiguration(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Updates the preference configuration");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @generated");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("protected void updateExtendedEditorConfiguration() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String languagePreferred = org.eclipse.papyrus.extensionpoints.editors.Activator.getDefault().getPreferenceStore().getString(");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds.EDITOR_FOR_ELEMENT + resolveSemanticElement().eClass().getInstanceClassName());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (languagePreferred != null && !languagePreferred.equals(\"\") && !languagePreferred.equals(configuration.getLanguage())) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("configuration = org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil.findEditorConfiguration(languagePreferred, resolveSemanticElement()");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(".eClass().getInstanceClassName());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else if (org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds.SIMPLE_DIRECT_EDITOR.equals(languagePreferred)) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("configuration = null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence performDefaultDirectEditorEdit(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append("* Performs the direct edit usually used by GMF editors.");
    _builder.newLine();
    _builder.append("* @param theRequest the direct edit request that starts the direct edit system");
    _builder.newLine();
    _builder.append("* @generated");
    _builder.newLine();
    _builder.append("*/");
    _builder.newLine();
    _builder.append("protected void performDefaultDirectEditorEdit(final org.eclipse.gef.Request theRequest) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// initialize the direct edit manager");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("getEditingDomain().runExclusive(new Runnable() {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    CharSequence _overrideI = this._codeStyle.overrideI(it);
    _builder.append(_overrideI, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("public void run() {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (isActive() && isEditable()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("if (theRequest.getExtendedData().get(org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("Character initialChar = (Character) theRequest.getExtendedData().get(");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("performDirectEdit(initialChar.charValue());");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("} else if ((theRequest instanceof org.eclipse.gef.requests.DirectEditRequest) && (getEditText().equals(getLabelText()))) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("org.eclipse.gef.requests.DirectEditRequest editRequest = (org.eclipse.gef.requests.DirectEditRequest) theRequest;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("performDirectEdit(editRequest.getLocation());");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("performDirectEdit();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} catch (InterruptedException e) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("e.printStackTrace();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
