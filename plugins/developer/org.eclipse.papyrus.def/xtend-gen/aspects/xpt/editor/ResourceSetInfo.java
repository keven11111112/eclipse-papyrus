package aspects.xpt.editor;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.CodeStyle;
import xpt.Common;

@Singleton
@SuppressWarnings("all")
public class ResourceSetInfo extends xpt.editor.ResourceSetInfo {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private CodeStyle _codeStyle;
  
  public CharSequence handleResourceChangedSD(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public boolean handleResourceChanged(final org.eclipse.emf.ecore.resource.Resource resource) {");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _updateSynchStateSD = this.updateSynchStateSD(it);
    _builder.append(_updateSynchStateSD, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("org.eclipse.swt.widgets.Display.getDefault().asyncExec(new java.lang.Runnable() {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _overrideI = this._codeStyle.overrideI(it);
    _builder.append(_overrideI, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("public void run() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("handleElementChanged(ResourceSetInfo.this, resource, null);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence handleResourceDeletedSD(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public boolean handleResourceDeleted(org.eclipse.emf.ecore.resource.Resource resource) {");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _updateSynchStateSD = this.updateSynchStateSD(it);
    _builder.append(_updateSynchStateSD, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("org.eclipse.swt.widgets.Display.getDefault().asyncExec(new java.lang.Runnable() {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _overrideI = this._codeStyle.overrideI(it);
    _builder.append(_overrideI, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("public void run() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("fireElementDeleted(ResourceSetInfo.this.getEditorInput());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence handleResourceMovedSD(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public boolean handleResourceMoved(org.eclipse.emf.ecore.resource.Resource resource, final org.eclipse.emf.common.util.URI newURI) {");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _updateSynchStateSD = this.updateSynchStateSD(it);
    _builder.append(_updateSynchStateSD, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("if (myDocument.getDiagram().eResource() == resource) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.swt.widgets.Display.getDefault().asyncExec(new java.lang.Runnable() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    CharSequence _overrideI = this._codeStyle.overrideI(it);
    _builder.append(_overrideI, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("public void run() {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("handleElementMoved(ResourceSetInfo.this.getEditorInput(), newURI);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("handleResourceDeleted(resource);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
