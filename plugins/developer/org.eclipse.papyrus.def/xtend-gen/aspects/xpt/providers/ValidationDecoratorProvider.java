/**
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 * 	  Ansgar Radermacher (CEA LIST) - added support for EMF validation
 */
package aspects.xpt.providers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenEditorView;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;
import xpt.editor.Editor;
import xpt.editor.VisualIDRegistry;

/**
 * FIXME: [MG] monolithic template with most of the code "same-generated".
 * Unfortunately, a lot of the logic is based around «IF editorGen.application == null» and we don't have a good ways to deal with taht in GMFT-runtimw
 */
@Singleton
@SuppressWarnings("all")
public class ValidationDecoratorProvider extends xpt.providers.ValidationDecoratorProvider {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  private Editor xptEditor;
  
  @Inject
  private VisualIDRegistry xptVisualIDRegistry;
  
  public CharSequence ValidationDecoratorProvider(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    GenEditorGenerator _editorGen = it.getEditorGen();
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
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("extends org.eclipse.papyrus.uml.diagram.common.providers.ValidationDecoratorProvider");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("implements org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public void createDecorators(org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget decoratorTarget) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.gef.EditPart editPart = (org.eclipse.gef.EditPart) decoratorTarget.getAdapter(org.eclipse.gef.EditPart.class);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (editPart instanceof org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart ||");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("editPart instanceof org.eclipse.gef.editparts.AbstractConnectionEditPart) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Object model = editPart.getModel();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if ((model instanceof org.eclipse.gmf.runtime.notation.View)) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) model;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (!(view instanceof org.eclipse.gmf.runtime.notation.Edge) && !view.isSetElement()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.gef.EditDomain ed = editPart.getViewer().getEditDomain();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (!(ed instanceof org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain)) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (((org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain) ed).getEditorPart() instanceof");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    GenEditorGenerator _editorGen_1 = it.getEditorGen();
    GenEditorView _editor = _editorGen_1.getEditor();
    CharSequence _qualifiedClassName = this.xptEditor.qualifiedClassName(_editor);
    _builder.append(_qualifiedClassName, "\t\t\t\t\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("decoratorTarget.installDecorator(KEY, new StatusDecorator(decoratorTarget));");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public boolean provides(org.eclipse.gmf.runtime.common.core.service.IOperation operation) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (!(operation instanceof org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation)) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget decoratorTarget =");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("((org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation) operation).getDecoratorTarget();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) decoratorTarget.getAdapter(");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("org.eclipse.gmf.runtime.notation.View.class);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return view != null && ");
    CharSequence _modelID = VisualIDRegistry.modelID(it);
    _builder.append(_modelID, "\t\t");
    _builder.append(".equals(");
    CharSequence _modelIDMethodCall = this.xptVisualIDRegistry.getModelIDMethodCall(it);
    _builder.append(_modelIDMethodCall, "\t\t");
    _builder.append("(view));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _additions = this.additions(it);
    _builder.append(_additions, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
