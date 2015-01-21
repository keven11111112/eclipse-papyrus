package aspects.xpt.diagram.editpolicies;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.CodeStyle;
import xpt.Common;

@Singleton
@SuppressWarnings("all")
public class TextSelectionEditPolicy extends xpt.diagram.editpolicies.TextSelectionEditPolicy {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private CodeStyle _codeStyle;
  
  public CharSequence textFeedback_createFocusFeedbackFigure(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.draw2d.IFigure createFocusFeedbackFigure() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return new org.eclipse.draw2d.Figure() {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _overrideC = this._codeStyle.overrideC(it);
    _builder.append(_overrideC, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected void paintFigure(org.eclipse.draw2d.Graphics graphics) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("graphics.drawFocus(getBounds().getResized(-1, -1));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("};");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence textFeedback_getHostPositionListener(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private org.eclipse.draw2d.FigureListener getHostPositionListener() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (hostPositionListener == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("hostPositionListener = new org.eclipse.draw2d.FigureListener() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    CharSequence _overrideI = this._codeStyle.overrideI(it);
    _builder.append(_overrideI, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("public void figureMoved(org.eclipse.draw2d.IFigure source) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("refreshFeedback();");
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
    _builder.append("return hostPositionListener;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
