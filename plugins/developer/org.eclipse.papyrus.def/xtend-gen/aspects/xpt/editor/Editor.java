/**
 * Copyright (c) 2006, 2014 Borland Software Corporation, CEA, and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *    Emilien Perico (Atos Origin) - add code to refactor some classes
 *    Christian W. Damus (CEA) - bug 430648
 *    Christian W. Damus (CEA) - bug 431023
 */
package aspects.xpt.editor;

import aspects.xpt.navigator.NavigatorLinkHelper;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenEditorView;
import org.eclipse.gmf.codegen.gmfgen.GenNavigator;
import org.eclipse.gmf.codegen.gmfgen.GenNavigatorChildReference;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import xpt.CodeStyle;
import xpt.Common;
import xpt.navigator.Utils_qvto;

@Singleton
@SuppressWarnings("all")
public class Editor extends xpt.editor.Editor {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  private NavigatorLinkHelper xptNavigatorLinkHelper;
  
  @Inject
  @Extension
  private Utils_qvto _utils_qvto;
  
  @Inject
  @Extension
  private CodeStyle _codeStyle;
  
  public CharSequence extendsList(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("extends org.eclipse.papyrus.uml.diagram.common.part.UmlGmfDiagramEditor");
    return _builder;
  }
  
  public CharSequence attributes(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public static final String ID = \"");
    String _iD = it.getID();
    _builder.append(_iD, "\t");
    _builder.append("\"; ");
    CharSequence _nonNLS = this._common.nonNLS();
    _builder.append(_nonNLS, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("public static final String CONTEXT_ID = \"");
    String _contextID = it.getContextID();
    _builder.append(_contextID, "");
    _builder.append("\"; ");
    CharSequence _nonNLS_1 = this._common.nonNLS();
    _builder.append(_nonNLS_1, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatedMemberComment_2 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_2, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private org.eclipse.gef.KeyHandler paletteKeyHandler = null;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_3 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_3, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private org.eclipse.swt.events.MouseListener paletteMouseListener = null;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatedMemberComment_4 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_4, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private org.eclipse.papyrus.commands.util.OperationHistoryDirtyState dirtyState;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_5 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_5, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_6 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_6, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("private org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider documentProvider;");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence constructor(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public ");
    String _className = it.getClassName();
    _builder.append(_className, "");
    _builder.append("(org.eclipse.papyrus.infra.core.services.ServicesRegistry servicesRegistry, org.eclipse.gmf.runtime.notation.Diagram diagram) throws org.eclipse.papyrus.infra.core.services.ServiceException{");
    _builder.newLineIfNotEmpty();
    _builder.append("super(servicesRegistry, diagram);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// adds a listener to the palette service, which reacts to palette customizations");
    _builder.newLine();
    _builder.append("org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService.getInstance().addProviderChangeListener(this);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// Share the same editing provider");
    _builder.newLine();
    _builder.append("editingDomain = servicesRegistry.getService(org.eclipse.emf.transaction.TransactionalEditingDomain.class);");
    _builder.newLine();
    _builder.append("documentProvider = new org.eclipse.papyrus.infra.gmfdiag.common.GmfMultiDiagramDocumentProvider(editingDomain);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// overrides editing domain created by super constructor");
    _builder.newLine();
    _builder.append("setDocumentProvider(documentProvider);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getNavigatorSelection(final GenNavigator it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private org.eclipse.jface.viewers.ISelection getNavigatorSelection() {");
    _builder.newLine();
    {
      GenNavigatorChildReference _diagramTopReference = this._utils_qvto.getDiagramTopReference(it);
      boolean _notEquals = (!Objects.equal(_diagramTopReference, null));
      if (_notEquals) {
        _builder.append("\t");
        _builder.append("org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument document = getDiagramDocument();");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    CharSequence _findSelectionBody = this.xptNavigatorLinkHelper.findSelectionBody(it);
    _builder.append(_findSelectionBody, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence createPaletteRoot(final Palette it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.gef.palette.PaletteRoot createPaletteRoot(org.eclipse.gef.palette.PaletteRoot existingPaletteRoot) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gef.palette.PaletteRoot paletteRoot;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (existingPaletteRoot == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paletteRoot = org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService.getInstance().createPalette(this, getDefaultPaletteContent());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService.getInstance().updatePalette(existingPaletteRoot, this, getDefaultPaletteContent());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("paletteRoot = existingPaletteRoot;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("applyCustomizationsToPalette(paletteRoot);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return paletteRoot;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence createPaletteCustomizer(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.gef.ui.palette.PaletteCustomizer createPaletteCustomizer() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return new org.eclipse.papyrus.uml.diagram.common.part.PapyrusPaletteCustomizer(getPreferenceStore());");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence additions(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    CharSequence _createEditingDomain = this.createEditingDomain(it);
    _builder.append(_createEditingDomain, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _configureDiagramEditDomain = this.configureDiagramEditDomain(it);
    _builder.append(_configureDiagramEditDomain, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _doSave = this.doSave(it);
    _builder.append(_doSave, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _dirtyState = this.getDirtyState(it);
    _builder.append(_dirtyState, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _setUndoContext = this.setUndoContext(it);
    _builder.append(_setUndoContext, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _isDirty = this.isDirty(it);
    _builder.append(_isDirty, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _handlePaletteChange = this.handlePaletteChange(it);
    _builder.append(_handlePaletteChange, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _dispose = this.dispose(it);
    _builder.append(_dispose, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _paletteViewer = this.getPaletteViewer(it);
    _builder.append(_paletteViewer, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.newLine();
    CharSequence _constructPaletteViewer = this.constructPaletteViewer(it);
    _builder.append(_constructPaletteViewer, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _createPaletteviewerProvider = this.createPaletteviewerProvider(it);
    _builder.append(_createPaletteviewerProvider, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _graphicalViewer = this.getGraphicalViewer(it);
    _builder.append(_graphicalViewer, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _initializeGraphicalViewer = this.initializeGraphicalViewer(it);
    _builder.append(_initializeGraphicalViewer, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _selectionChanged = this.selectionChanged(it);
    _builder.append(_selectionChanged, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence handlePaletteChange(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public void providerChanged(org.eclipse.gmf.runtime.common.core.service.ProviderChangeEvent event) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// update the palette if the palette service has changed");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService.getInstance().equals(event.getSource())) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService.getInstance().updatePalette(getPaletteViewer().getPaletteRoot(), this,");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("getDefaultPaletteContent());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence constructPaletteViewer(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.gef.ui.palette.PaletteViewer constructPaletteViewer() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return new org.eclipse.papyrus.uml.diagram.common.part.PapyrusPaletteViewer();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence dispose(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public void dispose() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// remove palette service listener");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// remove preference listener");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService.getInstance().removeProviderChangeListener(this);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if(dirtyState != null) {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("dirtyState.dispose();");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("dirtyState = null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("super.dispose();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getPaletteViewer(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.gef.ui.palette.PaletteViewer getPaletteViewer() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return getEditDomain().getPaletteViewer();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence implementsList(final Iterable<String> it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("implements org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener");
    _builder.newLine();
    _builder.append("\t");
    {
      boolean _isEmpty = IterableExtensions.isEmpty(it);
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
        {
          boolean _hasElements = false;
          for(final String string : it) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "\t\t");
            }
            _builder.append("\t");
            _builder.append("\t");
            CharSequence _implementsListEntry = this.implementsListEntry(string);
            _builder.append(_implementsListEntry, "\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence implementsListEntry(final String it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(it, "");
    return _builder;
  }
  
  public CharSequence createPaletteviewerProvider(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.gef.ui.palette.PaletteViewerProvider createPaletteViewerProvider() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("getEditDomain().setPaletteRoot(createPaletteRoot(null));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new org.eclipse.gef.ui.palette.PaletteViewerProvider(getEditDomain()) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t\t\t ");
    _builder.append("* Override to provide the additional behavior for the tools. Will intialize with a");
    _builder.newLine();
    _builder.append("\t\t\t ");
    _builder.append("* PaletteEditPartFactory that has a TrackDragger that understand how to handle the");
    _builder.newLine();
    _builder.append("\t\t\t ");
    _builder.append("* mouseDoubleClick event for shape creation tools. Also will initialize the palette");
    _builder.newLine();
    _builder.append("\t\t\t ");
    _builder.append("* with a defaultTool that is the SelectToolEx that undestands how to handle the enter");
    _builder.newLine();
    _builder.append("\t\t\t ");
    _builder.append("* key which will result in the creation of the shape also.");
    _builder.newLine();
    _builder.append("\t\t\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t\t\t");
    GenEditorGenerator _editorGen = it.getEditorGen();
    GenDiagram _diagram = _editorGen.getDiagram();
    CharSequence _overrideC = this._codeStyle.overrideC(_diagram);
    _builder.append(_overrideC, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("protected void configurePaletteViewer(org.eclipse.gef.ui.palette.PaletteViewer viewer) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("super.configurePaletteViewer(viewer);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("// customize menu...");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("viewer.setContextMenu(new org.eclipse.papyrus.uml.diagram.common.part.PapyrusPaletteContextMenuProvider(viewer));");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("viewer.getKeyHandler().setParent(getPaletteKeyHandler());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("viewer.getControl().addMouseListener(getPaletteMouseListener());");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("// Add a transfer drag target listener that is supported on");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("// palette template entries whose template is a creation tool.");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("// This will enable drag and drop of the palette shape creation");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("// tools.");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("viewer.addDragSourceListener(new org.eclipse.gmf.runtime.diagram.ui.internal.parts.PaletteToolTransferDragSourceListener(viewer));");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("viewer.setCustomizer(createPaletteCustomizer());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    GenEditorGenerator _editorGen_1 = it.getEditorGen();
    GenDiagram _diagram_1 = _editorGen_1.getDiagram();
    CharSequence _overrideC_1 = this._codeStyle.overrideC(_diagram_1);
    _builder.append(_overrideC_1, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("public org.eclipse.gef.ui.palette.PaletteViewer createPaletteViewer(org.eclipse.swt.widgets.Composite parent) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("org.eclipse.gef.ui.palette.PaletteViewer pViewer = constructPaletteViewer();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("pViewer.createControl(parent);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("configurePaletteViewer(pViewer);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("hookPaletteViewer(pViewer);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return pViewer;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t\t\t ");
    _builder.append("* @return Palette Key Handler for the palette");
    _builder.newLine();
    _builder.append("\t\t\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("private org.eclipse.gef.KeyHandler getPaletteKeyHandler() {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (paletteKeyHandler == null) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("paletteKeyHandler = new org.eclipse.gef.KeyHandler() {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t ");
    _builder.append("* Processes a <i>key released </i> event. This method is called by the Tool");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t ");
    _builder.append("* whenever a key is released, and the Tool is in the proper state. Override");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t ");
    _builder.append("* to support pressing the enter key to create a shape or connection");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t ");
    _builder.append("* (between two selected shapes)");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t ");
    _builder.append("* @param event");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t ");
    _builder.append("*            the KeyEvent");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t ");
    _builder.append("* @return <code>true</code> if KeyEvent was handled in some way");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    GenEditorGenerator _editorGen_2 = it.getEditorGen();
    GenDiagram _diagram_2 = _editorGen_2.getDiagram();
    CharSequence _overrideC_2 = this._codeStyle.overrideC(_diagram_2);
    _builder.append(_overrideC_2, "\t\t\t\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("public boolean keyReleased(org.eclipse.swt.events.KeyEvent event) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("if (event.keyCode == org.eclipse.swt.SWT.Selection) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("org.eclipse.gef.Tool tool = getPaletteViewer().getActiveTool().createTool();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("if (toolSupportsAccessibility(tool)) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("tool.keyUp(event, getDiagramGraphicalViewer());");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("// deactivate current selection");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("getPaletteViewer().setActiveTool(null);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("return super.keyReleased(event);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return paletteKeyHandler;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t\t\t ");
    _builder.append("* @return Palette Mouse listener for the palette");
    _builder.newLine();
    _builder.append("\t\t\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("private org.eclipse.swt.events.MouseListener getPaletteMouseListener() {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (paletteMouseListener == null) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("paletteMouseListener = new org.eclipse.swt.events.MouseListener() {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t ");
    _builder.append("* Flag to indicate that the current active tool should be cleared after a");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t ");
    _builder.append("* mouse double-click event.");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("private boolean clearActiveTool = false;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t ");
    _builder.append("* Override to support double-clicking a palette tool entry to create a");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t ");
    _builder.append("* shape or connection (between two selected shapes).");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t ");
    _builder.append("* @see org.eclipse.swt.events.MouseListener#mouseDoubleClick(org.eclipse.swt.events.MouseEvent)");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    GenEditorGenerator _editorGen_3 = it.getEditorGen();
    GenDiagram _diagram_3 = _editorGen_3.getDiagram();
    CharSequence _overrideI = this._codeStyle.overrideI(_diagram_3);
    _builder.append(_overrideI, "\t\t\t\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("public void mouseDoubleClick(org.eclipse.swt.events.MouseEvent e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("org.eclipse.gef.Tool tool = getPaletteViewer().getActiveTool().createTool();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("if (toolSupportsAccessibility(tool)) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("tool.setViewer(getDiagramGraphicalViewer());");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("tool.setEditDomain(getDiagramGraphicalViewer().getEditDomain());");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("tool.mouseDoubleClick(e, getDiagramGraphicalViewer());");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("// Current active tool should be deactivated,");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("// but if it is down here it will get");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("// reactivated deep in GEF palette code after");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("// receiving mouse up events.");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("clearActiveTool = true;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    GenEditorGenerator _editorGen_4 = it.getEditorGen();
    GenDiagram _diagram_4 = _editorGen_4.getDiagram();
    CharSequence _overrideI_1 = this._codeStyle.overrideI(_diagram_4);
    _builder.append(_overrideI_1, "\t\t\t\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("public void mouseDown(org.eclipse.swt.events.MouseEvent e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("// do nothing");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    GenEditorGenerator _editorGen_5 = it.getEditorGen();
    GenDiagram _diagram_5 = _editorGen_5.getDiagram();
    CharSequence _overrideI_2 = this._codeStyle.overrideI(_diagram_5);
    _builder.append(_overrideI_2, "\t\t\t\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("public void mouseUp(org.eclipse.swt.events.MouseEvent e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("// Deactivate current active tool here if a");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("// double-click was handled.");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("if (clearActiveTool) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("getPaletteViewer().setActiveTool(null);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.append("clearActiveTool = false;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return paletteMouseListener;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("};");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence performSaveAs(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void performSaveAs(org.eclipse.core.runtime.IProgressMonitor progressMonitor) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("// Nothing");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getEditingDomain(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public org.eclipse.emf.transaction.TransactionalEditingDomain getEditingDomain() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return editingDomain;");
    _builder.newLine();
    _builder.append("}\t");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence createEditingDomain(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected org.eclipse.emf.transaction.TransactionalEditingDomain createEditingDomain() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// Already configured");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return editingDomain;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence configureDiagramEditDomain(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected void configureDiagramEditDomain() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super.configureDiagramEditDomain();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("getDiagramEditDomain().getDiagramCommandStack().addCommandStackListener(new org.eclipse.gef.commands.CommandStackListener() {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    GenEditorGenerator _editorGen = it.getEditorGen();
    GenDiagram _diagram = _editorGen.getDiagram();
    CharSequence _overrideI = this._codeStyle.overrideI(_diagram);
    _builder.append(_overrideI, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("public void commandStackChanged(java.util.EventObject event) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("firePropertyChange( org.eclipse.ui.IEditorPart.PROP_DIRTY);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence doSave(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public void doSave(org.eclipse.core.runtime.IProgressMonitor progressMonitor) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// The saving of the resource is done by the CoreMultiDiagramEditor");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("getDirtyState().saved();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getDirtyState(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("protected org.eclipse.papyrus.commands.util.OperationHistoryDirtyState getDirtyState() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if(dirtyState == null) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("dirtyState = org.eclipse.papyrus.commands.util.OperationHistoryDirtyState.newInstance(getUndoContext(), getOperationHistory());");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return dirtyState;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence setUndoContext(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("protected void setUndoContext(org.eclipse.core.commands.operations.IUndoContext context) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if(dirtyState != null) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("dirtyState.dispose();");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("dirtyState = null;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("super.setUndoContext(context);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence isDirty(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public boolean isDirty() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return getDirtyState().isDirty();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getDocumentProvider(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected final org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider getDocumentProvider(org.eclipse.ui.IEditorInput input) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return documentProvider;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence setDocumentProvider(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected final void setDocumentProvider(org.eclipse.ui.IEditorInput input) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// Already set in the constructor");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getGraphicalViewer(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public org.eclipse.gef.GraphicalViewer getGraphicalViewer() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return super.getGraphicalViewer();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence initializeGraphicalViewer(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void initializeGraphicalViewer() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super.initializeGraphicalViewer();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// Enable Drop");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("getDiagramGraphicalViewer().addDropTargetListener(");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("new org.eclipse.papyrus.uml.diagram.common.listeners.DropTargetListener(getDiagramGraphicalViewer(), org.eclipse.jface.util.LocalSelectionTransfer.getTransfer()) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("protected Object getJavaObject(org.eclipse.swt.dnd.TransferData data) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("// It is usual for the transfer data not to be set because it is available locally");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("return LocalSelectionTransfer.getTransfer().getSelection();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("protected org.eclipse.emf.transaction.TransactionalEditingDomain getTransactionalEditingDomain() {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("return getEditingDomain();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence selectionChanged(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void selectionChanged(org.eclipse.ui.IWorkbenchPart part, org.eclipse.jface.viewers.ISelection selection) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (getSite().getPage().getActiveEditor() instanceof org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor editor = (org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor) getSite().getPage().getActiveEditor();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// If not the active editor, ignore selection changed.");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (this.equals(editor.getActiveEditor())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("updateActions(getSelectionActions());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("super.selectionChanged(part, selection);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("super.selectionChanged(part, selection);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("super.selectionChanged(part, selection);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// from");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor.selectionChanged(IWorkbenchPart,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// ISelection)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (part == this) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("rebuildStatusLine();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getContextID(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("protected String getContextID() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return CONTEXT_ID;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getAdapter(final GenEditorView it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _or = false;
      boolean _hasPropertySheet = this.hasPropertySheet(it);
      boolean _not = (!_hasPropertySheet);
      if (_not) {
        _or = true;
      } else {
        boolean _hasNavigator = this.hasNavigator(it);
        _or = _hasNavigator;
      }
      if (_or) {
        _builder.newLine();
        CharSequence _generatedMemberComment = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment, "");
        _builder.newLineIfNotEmpty();
        _builder.append("@SuppressWarnings(\"rawtypes\")");
        _builder.newLine();
        _builder.append("public Object getAdapter(Class type) {");
        _builder.newLine();
        {
          boolean _hasPropertySheet_1 = this.hasPropertySheet(it);
          boolean _not_1 = (!_hasPropertySheet_1);
          if (_not_1) {
            _builder.append("\t");
            _builder.append("if (type == org.eclipse.ui.views.properties.IPropertySheetPage.class) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return null;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        {
          boolean _hasNavigator_1 = this.hasNavigator(it);
          if (_hasNavigator_1) {
            _builder.append("\t");
            _builder.append("if (type == org.eclipse.ui.part.IShowInTargetList.class) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return new org.eclipse.ui.part.IShowInTargetList() {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            GenEditorGenerator _editorGen = it.getEditorGen();
            GenDiagram _diagram = _editorGen.getDiagram();
            CharSequence _overrideI = this._codeStyle.overrideI(_diagram);
            _builder.append(_overrideI, "\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("public String[] getShowInTargetIds() {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t\t");
            _builder.append("return new String[] { org.eclipse.ui.navigator.resources.ProjectExplorer.VIEW_ID };");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("};");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("return super.getAdapter(type);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
}
