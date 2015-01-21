/**
 * Copyright (c) 2008, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 * 	  Vincent Lorenzo (CEA LIST)
 */
package aspects.xpt.editor;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import plugin.Activator;
import xpt.CodeStyle;
import xpt.Common;

@Singleton
@SuppressWarnings("all")
public class DiagramEditorContextMenuProvider extends xpt.editor.DiagramEditorContextMenuProvider {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private CodeStyle _codeStyle;
  
  @Inject
  private Activator xptActivator;
  
  public CharSequence DiagramEditorContextMenuProvider(final GenDiagram it) {
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
    _builder.append(" extends org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private org.eclipse.ui.IWorkbenchPart part;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public DiagramEditorContextMenuProvider(org.eclipse.ui.IWorkbenchPart part, org.eclipse.gef.EditPartViewer viewer) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(part, viewer);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.part = part;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_2 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_2, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public void buildContextMenu(final org.eclipse.jface.action.IMenuManager menu) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("getViewer().flush();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.emf.transaction.util.TransactionUtil.getEditingDomain(");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("(org.eclipse.emf.ecore.EObject) getViewer().getContents().getModel()).runExclusive(new Runnable() {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t");
    GenEditorGenerator _editorGen_1 = it.getEditorGen();
    GenDiagram _diagram = _editorGen_1.getDiagram();
    CharSequence _overrideI = this._codeStyle.overrideI(_diagram);
    _builder.append(_overrideI, "\t\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("public void run() {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.ContributionItemService.getInstance().contributeToPopupMenu(");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("DiagramEditorContextMenuProvider.this, part);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("menu.remove(org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.ACTION_DELETE_FROM_MODEL);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (Exception e) {");
    _builder.newLine();
    _builder.append("\t");
    GenEditorGenerator _editorGen_2 = it.getEditorGen();
    GenPlugin _plugin = _editorGen_2.getPlugin();
    CharSequence _qualifiedClassName = this.xptActivator.qualifiedClassName(_plugin);
    _builder.append(_qualifiedClassName, "\t");
    _builder.append(".getInstance().logError(\"Error building context menu\", e);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
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
