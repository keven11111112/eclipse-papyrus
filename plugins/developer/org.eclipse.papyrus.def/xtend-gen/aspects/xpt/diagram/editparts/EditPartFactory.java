/**
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
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
package aspects.xpt.diagram.editparts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;

@Singleton
@SuppressWarnings("all")
public class EditPartFactory extends xpt.diagram.editparts.EditPartFactory {
  @Inject
  @Extension
  private Common _common;
  
  public CharSequence getTextCellEditorLocator(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public static org.eclipse.gef.tools.CellEditorLocator getTextCellEditorLocator(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart source) {");
    _builder.newLine();
    _builder.append("\t\t      ");
    _builder.append("if (source.getFigure() instanceof org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new MultilineCellEditorLocator(");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("(org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure) source.getFigure());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t   ");
    _builder.append("else {");
    _builder.newLine();
    _builder.append("\t\t\t\t      ");
    _builder.append("return org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("       ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("   ");
    _builder.newLine();
    _builder.append("   ");
    _builder.newLine();
    _builder.append("   ");
    CharSequence _generatedClassComment = this._common.generatedClassComment();
    _builder.append(_generatedClassComment, "   ");
    _builder.newLineIfNotEmpty();
    _builder.append("   ");
    _builder.append("static private class MultilineCellEditorLocator implements org.eclipse.gef.tools.CellEditorLocator {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedClassComment_1 = this._common.generatedClassComment();
    _builder.append(_generatedClassComment_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure multilineEditableFigure;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedClassComment_2 = this._common.generatedClassComment();
    _builder.append(_generatedClassComment_2, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public MultilineCellEditorLocator(org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure figure) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("this.multilineEditableFigure = figure;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedClassComment_3 = this._common.generatedClassComment();
    _builder.append(_generatedClassComment_3, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure getMultilineEditableFigure() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return multilineEditableFigure;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedClassComment_4 = this._common.generatedClassComment();
    _builder.append(_generatedClassComment_4, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public void relocate(org.eclipse.jface.viewers.CellEditor celleditor) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.swt.widgets.Text text = (org.eclipse.swt.widgets.Text) celleditor.getControl();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.draw2d.geometry.Rectangle rect = getMultilineEditableFigure().getBounds().getCopy();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("rect.x=getMultilineEditableFigure().getEditionLocation().x;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("rect.y=getMultilineEditableFigure().getEditionLocation().y;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("getMultilineEditableFigure().translateToAbsolute(rect);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (getMultilineEditableFigure().getText().length() > 0) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("rect.setSize(new org.eclipse.draw2d.geometry.Dimension(text.computeSize(rect.width,");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("org.eclipse.swt.SWT.DEFAULT)));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (!rect.equals(new org.eclipse.draw2d.geometry.Rectangle(text.getBounds()))) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("text.setBounds(rect.x, rect.y, rect.width, rect.height);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
