package aspects.xpt.editor;

import aspects.xpt.editor.VisualIDRegistry;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import metamodel.MetaModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.gmf.codegen.gmfgen.GenApplication;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import plugin.Activator;
import xpt.CodeStyle;
import xpt.Common;
import xpt.Externalizer;
import xpt.editor.GenDiagram_qvto;

@Singleton
@SuppressWarnings("all")
public class DiagramEditorUtil extends xpt.editor.DiagramEditorUtil {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private CodeStyle _codeStyle;
  
  @Inject
  @Extension
  private GenDiagram_qvto _genDiagram_qvto;
  
  @Inject
  private Activator xptActivator;
  
  @Inject
  private Externalizer xptExternalizer;
  
  @Inject
  private MetaModel xptMetaModel;
  
  public CharSequence createDiagramMethod(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    String _xifexpression = null;
    GenEditorGenerator _editorGen = it.getEditorGen();
    GenApplication _application = _editorGen.getApplication();
    boolean _equals = Objects.equal(_application, null);
    if (_equals) {
      _xifexpression = "This method should be called within a workspace modify operation since it creates resources.";
    } else {
      _xifexpression = "";
    }
    CharSequence _generatedMemberComment = this._common.generatedMemberComment(_xifexpression);
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public static org.eclipse.emf.ecore.resource.Resource createDiagram(org.eclipse.emf.common.util.URI diagramURI,");
    {
      boolean _standaloneDomainModel = this._genDiagram_qvto.standaloneDomainModel(it);
      if (_standaloneDomainModel) {
        _builder.append(" org.eclipse.emf.common.util.URI modelURI,");
      }
    }
    _builder.append(" org.eclipse.core.runtime.IProgressMonitor progressMonitor) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain = org.eclipse.emf.workspace.WorkspaceEditingDomainFactory.INSTANCE.createEditingDomain();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("progressMonitor.beginTask(");
    GenEditorGenerator _editorGen_1 = it.getEditorGen();
    String _i18nKeyForCreateDiagramProgressTask = this.i18nKeyForCreateDiagramProgressTask(it);
    CharSequence _accessorCall = this.xptExternalizer.accessorCall(_editorGen_1, _i18nKeyForCreateDiagramProgressTask);
    _builder.append(_accessorCall, "\t");
    _builder.append(", 3);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("final org.eclipse.emf.ecore.resource.Resource diagramResource = editingDomain.getResourceSet().createResource(diagramURI);");
    _builder.newLine();
    {
      boolean _standaloneDomainModel_1 = this._genDiagram_qvto.standaloneDomainModel(it);
      if (_standaloneDomainModel_1) {
        _builder.append("\t");
        _builder.append("final org.eclipse.emf.ecore.resource.Resource modelResource = editingDomain.getResourceSet().createResource(modelURI);");
        _builder.newLine();
      } else {
        boolean _and = false;
        GenClass _domainDiagramElement = it.getDomainDiagramElement();
        boolean _notEquals = (!Objects.equal(_domainDiagramElement, null));
        if (!_notEquals) {
          _and = false;
        } else {
          boolean _hasDocumentRoot = this._genDiagram_qvto.hasDocumentRoot(it);
          _and = _hasDocumentRoot;
        }
        if (_and) {
          _builder.append("\t");
          _builder.append("((org.eclipse.emf.ecore.xmi.XMLResource) diagramResource).getDefaultSaveOptions().put(org.eclipse.emf.ecore.xmi.XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("((org.eclipse.emf.ecore.xmi.XMLResource) diagramResource).getDefaultLoadOptions().put(org.eclipse.emf.ecore.xmi.XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);");
          _builder.newLine();
        }
      }
    }
    _builder.append("\t");
    _builder.append("final String diagramName = diagramURI.lastSegment();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand command = new org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand(editingDomain, ");
    GenEditorGenerator _editorGen_2 = it.getEditorGen();
    String _i18nKeyForCreateDiagramCommandLabel = this.i18nKeyForCreateDiagramCommandLabel(it);
    CharSequence _accessorCall_1 = this.xptExternalizer.accessorCall(_editorGen_2, _i18nKeyForCreateDiagramCommandLabel);
    _builder.append(_accessorCall_1, "\t");
    _builder.append(", java.util.Collections.EMPTY_LIST) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    CharSequence _overrideC = this._codeStyle.overrideC(it);
    _builder.append(_overrideC, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("protected org.eclipse.gmf.runtime.common.core.command.CommandResult doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor monitor, org.eclipse.core.runtime.IAdaptable info) throws org.eclipse.core.commands.ExecutionException {");
    _builder.newLine();
    {
      GenClass _domainDiagramElement_1 = it.getDomainDiagramElement();
      boolean _notEquals_1 = (!Objects.equal(_domainDiagramElement_1, null));
      if (_notEquals_1) {
        _builder.append("\t\t\t");
        GenClass _domainDiagramElement_2 = it.getDomainDiagramElement();
        CharSequence _QualifiedClassName = this.xptMetaModel.QualifiedClassName(_domainDiagramElement_2);
        _builder.append(_QualifiedClassName, "\t\t\t");
        _builder.append(" model = createInitialModel();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("attachModelToResource(model, ");
        {
          boolean _standaloneDomainModel_2 = this._genDiagram_qvto.standaloneDomainModel(it);
          if (_standaloneDomainModel_2) {
            _builder.append("model");
          } else {
            _builder.append("diagram");
          }
        }
        _builder.append("Resource);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    CharSequence _extraLineBreak = this._common.extraLineBreak();
    _builder.append(_extraLineBreak, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.gmf.runtime.notation.Diagram diagram = org.eclipse.gmf.runtime.diagram.core.services.ViewService.createDiagram(");
    _builder.newLine();
    {
      GenClass _domainDiagramElement_3 = it.getDomainDiagramElement();
      boolean _notEquals_2 = (!Objects.equal(_domainDiagramElement_3, null));
      if (_notEquals_2) {
        _builder.append("\t\t\t\t");
        GenClass _domainDiagramElement_4 = it.getDomainDiagramElement();
        CharSequence _DowncastToEObject = this.xptMetaModel.DowncastToEObject(_domainDiagramElement_4, "model");
        _builder.append(_DowncastToEObject, "\t\t\t\t");
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t\t");
    CharSequence _modelID = VisualIDRegistry.modelID(it);
    _builder.append(_modelID, "\t\t\t\t");
    _builder.append(", ");
    GenEditorGenerator _editorGen_3 = it.getEditorGen();
    CharSequence _preferenceHintAccess = this.xptActivator.preferenceHintAccess(_editorGen_3);
    _builder.append(_preferenceHintAccess, "\t\t\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("if (diagram != null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("diagramResource.getContents().add(diagram);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("diagram.setName(diagramName);");
    _builder.newLine();
    {
      GenClass _domainDiagramElement_5 = it.getDomainDiagramElement();
      boolean _notEquals_3 = (!Objects.equal(_domainDiagramElement_5, null));
      if (_notEquals_3) {
        _builder.append("\t\t\t\t");
        _builder.append("diagram.setElement(");
        GenClass _domainDiagramElement_6 = it.getDomainDiagramElement();
        CharSequence _DowncastToEObject_1 = this.xptMetaModel.DowncastToEObject(_domainDiagramElement_6, "model");
        _builder.append(_DowncastToEObject_1, "\t\t\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    {
      boolean _standaloneDomainModel_3 = this._genDiagram_qvto.standaloneDomainModel(it);
      if (_standaloneDomainModel_3) {
        _builder.append("modelResource.save(");
        CharSequence _callGetSaveOptions = this.callGetSaveOptions(it);
        _builder.append(_callGetSaveOptions, "\t\t\t\t");
        _builder.append(");");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("diagramResource.save(");
    CharSequence _callGetSaveOptions_1 = this.callGetSaveOptions(it);
    _builder.append(_callGetSaveOptions_1, "\t\t\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("} catch (java.io.IOException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    CharSequence _extraLineBreak_1 = this._common.extraLineBreak();
    _builder.append(_extraLineBreak_1, "\t\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    GenEditorGenerator _editorGen_4 = it.getEditorGen();
    GenPlugin _plugin = _editorGen_4.getPlugin();
    CharSequence _qualifiedClassName = this.xptActivator.qualifiedClassName(_plugin);
    _builder.append(_qualifiedClassName, "\t\t\t\t");
    _builder.append(".getInstance().logError(\"Unable to store model and diagram resources\", e);  ");
    CharSequence _nonNLS = this._common.nonNLS(1);
    _builder.append(_nonNLS, "\t\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return org.eclipse.gmf.runtime.common.core.command.CommandResult.newOKCommandResult();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("};");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.core.commands.operations.OperationHistoryFactory.getOperationHistory().execute(command, new org.eclipse.core.runtime.SubProgressMonitor(progressMonitor, 1), null);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} catch (org.eclipse.core.commands.ExecutionException e) {");
    _builder.newLine();
    _builder.append("\t\t");
    GenEditorGenerator _editorGen_5 = it.getEditorGen();
    GenPlugin _plugin_1 = _editorGen_5.getPlugin();
    CharSequence _qualifiedClassName_1 = this.xptActivator.qualifiedClassName(_plugin_1);
    _builder.append(_qualifiedClassName_1, "\t\t");
    _builder.append(".getInstance().logError(\"Unable to create model and diagram\", e);  ");
    CharSequence _nonNLS_1 = this._common.nonNLS(
      1);
    _builder.append(_nonNLS_1, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    {
      GenEditorGenerator _editorGen_6 = it.getEditorGen();
      GenApplication _application_1 = _editorGen_6.getApplication();
      boolean _equals_1 = Objects.equal(_application_1, null);
      if (_equals_1) {
        _builder.append("\t");
        {
          boolean _standaloneDomainModel_4 = this._genDiagram_qvto.standaloneDomainModel(it);
          if (_standaloneDomainModel_4) {
            _builder.append("setCharset(org.eclipse.emf.workspace.util.WorkspaceSynchronizer.getFile(modelResource));");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("setCharset(org.eclipse.emf.workspace.util.WorkspaceSynchronizer.getFile(diagramResource));");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("return diagramResource;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
