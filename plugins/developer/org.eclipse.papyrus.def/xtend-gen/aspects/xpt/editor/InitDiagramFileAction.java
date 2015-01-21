package aspects.xpt.editor;

import aspects.xpt.editor.VisualIDRegistry;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import plugin.Activator;
import xpt.Common;
import xpt.Externalizer;
import xpt.ExternalizerUtils_qvto;
import xpt.editor.DiagramEditorUtil;

@Singleton
@SuppressWarnings("all")
public class InitDiagramFileAction extends xpt.editor.InitDiagramFileAction {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private ExternalizerUtils_qvto _externalizerUtils_qvto;
  
  @Inject
  private Activator xptActivator;
  
  @Inject
  private DiagramEditorUtil xptDiagramEditorUtil;
  
  @Inject
  private Externalizer xptExternalizer;
  
  public CharSequence classBody_PDE(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("private org.eclipse.ui.IWorkbenchPart targetPart;");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_1, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private org.eclipse.emf.common.util.URI domainModelURI;");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generatedMemberComment_2 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_2, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public void setActivePart(org.eclipse.jface.action.IAction action, org.eclipse.ui.IWorkbenchPart targetPart) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("this.targetPart = targetPart;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generatedMemberComment_3 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_3, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public void selectionChanged(org.eclipse.jface.action.IAction action, org.eclipse.jface.viewers.ISelection selection) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("domainModelURI = null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("action.setEnabled(false);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (selection instanceof org.eclipse.jface.viewers.IStructuredSelection == false || selection.isEmpty()) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.core.resources.IFile file =");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("(org.eclipse.core.resources.IFile) ((org.eclipse.jface.viewers.IStructuredSelection) selection).getFirstElement();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("domainModelURI = org.eclipse.emf.common.util.URI.createPlatformResourceURI(file.getFullPath().toString(), true);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("action.setEnabled(true);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generatedMemberComment_4 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_4, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private org.eclipse.swt.widgets.Shell getShell() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return targetPart.getSite().getShell();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generatedMemberComment_5 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_5, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public void run(org.eclipse.jface.action.IAction action) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain =");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.emf.workspace.WorkspaceEditingDomainFactory.INSTANCE.createEditingDomain();");
    _builder.newLine();
    {
      GenEditorGenerator _editorGen = it.getEditorGen();
      boolean _isSameFileForDiagramAndModel = _editorGen.isSameFileForDiagramAndModel();
      if (_isSameFileForDiagramAndModel) {
        _builder.append("\t");
        _builder.append("org.eclipse.emf.ecore.resource.ResourceSet resourceSet = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("org.eclipse.emf.ecore.resource.ResourceSet resourceSet = editingDomain.getResourceSet();");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("org.eclipse.emf.ecore.EObject diagramRoot = null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.emf.ecore.resource.Resource resource = resourceSet.getResource(domainModelURI, true);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("diagramRoot = resource.getContents().get(0);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} catch (org.eclipse.emf.common.util.WrappedException ex) {");
    _builder.newLine();
    _builder.append("\t\t");
    GenEditorGenerator _editorGen_1 = it.getEditorGen();
    GenPlugin _plugin = _editorGen_1.getPlugin();
    CharSequence _qualifiedClassName = this.xptActivator.qualifiedClassName(_plugin);
    _builder.append(_qualifiedClassName, "\t\t");
    _builder.append(".getInstance().logError(");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("\"Unable to load resource: \" + domainModelURI, ex); ");
    CharSequence _nonNLS = this._common.nonNLS(1);
    _builder.append(_nonNLS, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (diagramRoot == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.jface.dialogs.MessageDialog.openError(getShell(), ");
    _builder.newLine();
    _builder.append("\t\t             ");
    GenEditorGenerator _editorGen_2 = it.getEditorGen();
    String _i18nKeyForInitDiagramFileResourceErrorDialog = this.i18nKeyForInitDiagramFileResourceErrorDialog();
    String _titleKey = this._externalizerUtils_qvto.titleKey(_i18nKeyForInitDiagramFileResourceErrorDialog);
    CharSequence _accessorCall = this.xptExternalizer.accessorCall(_editorGen_2, _titleKey);
    _builder.append(_accessorCall, "\t\t             ");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t             ");
    GenEditorGenerator _editorGen_3 = it.getEditorGen();
    String _i18nKeyForInitDiagramFileResourceErrorDialog_1 = this.i18nKeyForInitDiagramFileResourceErrorDialog();
    String _messageKey = this._externalizerUtils_qvto.messageKey(_i18nKeyForInitDiagramFileResourceErrorDialog_1);
    CharSequence _accessorCall_1 = this.xptExternalizer.accessorCall(_editorGen_3, _messageKey);
    _builder.append(_accessorCall_1, "\t\t             ");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.jface.wizard.Wizard wizard = new ");
    GenEditorGenerator _editorGen_4 = it.getEditorGen();
    GenDiagram _diagram = _editorGen_4.getDiagram();
    String _newDiagramFileWizardQualifiedClassName = _diagram.getNewDiagramFileWizardQualifiedClassName();
    _builder.append(_newDiagramFileWizardQualifiedClassName, "\t");
    _builder.append("(domainModelURI, diagramRoot, editingDomain);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("wizard.setWindowTitle(org.eclipse.osgi.util.NLS.bind(");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    GenEditorGenerator _editorGen_5 = it.getEditorGen();
    String _i18nKeyForInitDiagramFileWizardTitle = this.i18nKeyForInitDiagramFileWizardTitle();
    CharSequence _accessorCall_2 = this.xptExternalizer.accessorCall(_editorGen_5, _i18nKeyForInitDiagramFileWizardTitle);
    _builder.append(_accessorCall_2, "\t\t\t    ");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t    ");
    GenEditorGenerator _editorGen_6 = it.getEditorGen();
    GenDiagram _diagram_1 = _editorGen_6.getDiagram();
    CharSequence _modelID = VisualIDRegistry.modelID(_diagram_1);
    _builder.append(_modelID, "\t\t\t    ");
    _builder.append("));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    GenEditorGenerator _editorGen_7 = it.getEditorGen();
    GenDiagram _diagram_2 = _editorGen_7.getDiagram();
    CharSequence _qualifiedClassName_1 = this.xptDiagramEditorUtil.qualifiedClassName(_diagram_2);
    _builder.append(_qualifiedClassName_1, "\t");
    _builder.append(".runWizard(getShell(), wizard, \"InitDiagramFile\"); ");
    CharSequence _nonNLS_1 = this._common.nonNLS(
      1);
    _builder.append(_nonNLS_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
