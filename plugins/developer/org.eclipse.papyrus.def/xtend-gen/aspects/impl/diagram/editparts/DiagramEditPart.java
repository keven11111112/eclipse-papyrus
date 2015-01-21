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
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.impl.diagram.editparts;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import metamodel.MetaModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.gmf.codegen.gmfgen.GenApplication;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.diagram.commands.CreateShortcutDecorationsCommand;
import xpt.diagram.editparts.Common;
import xpt.diagram.editparts.Utils_qvto;

/**
 * Revisit: [MG]: @Inject extension same-named-api-class -> template extends api-class?
 */
@Singleton
@SuppressWarnings("all")
public class DiagramEditPart extends impl.diagram.editparts.DiagramEditPart {
  @Inject
  @Extension
  private MetaModel _metaModel;
  
  @Inject
  @Extension
  private Utils_qvto _utils_qvto;
  
  @Inject
  private Common xptEditpartsCommon;
  
  @Inject
  private CreateShortcutDecorationsCommand createShoutrtcutDecorationCommand;
  
  public CharSequence extendsListContents(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("org.eclipse.papyrus.infra.gmfdiag.common.editpart.PapyrusDiagramEditPart");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence createDefaultEditPoliciesBody(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("super.createDefaultEditPolicies();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CREATION_ROLE, new org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCreationEditPolicy());");
    _builder.newLine();
    _builder.append("installEditPolicy(org.eclipse.papyrus.uml.diagram.common.editpolicies.DuplicatePasteEditPolicy.PASTE_ROLE, new org.eclipse.papyrus.uml.diagram.common.editpolicies.DuplicatePasteEditPolicy());");
    _builder.newLine();
    _builder.newLine();
    CharSequence _installSemanticEditPolicy = this.xptEditpartsCommon.installSemanticEditPolicy(it);
    _builder.append(_installSemanticEditPolicy, "");
    _builder.newLineIfNotEmpty();
    CharSequence _installCanonicalEditPolicy = this.xptEditpartsCommon.installCanonicalEditPolicy(it);
    _builder.append(_installCanonicalEditPolicy, "");
    _builder.newLineIfNotEmpty();
    {
      boolean _and = false;
      boolean _generateCreateShortcutAction = it.generateCreateShortcutAction();
      if (!_generateCreateShortcutAction) {
        _and = false;
      } else {
        GenEditorGenerator _editorGen = it.getEditorGen();
        GenApplication _application = _editorGen.getApplication();
        boolean _equals = Objects.equal(null, _application);
        _and = _equals;
      }
      if (_and) {
        _builder.append("installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.DRAG_DROP_ROLE, new org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy() {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public org.eclipse.gef.commands.Command getDropObjectsCommand(org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest dropRequest) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("java.util.List<org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor> viewDescriptors = new java.util.ArrayList<org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor>();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("for (java.util.Iterator<?> it = dropRequest.getObjects().iterator(); it.hasNext();) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("Object nextObject = it.next();");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (false == nextObject instanceof org.eclipse.emf.ecore.EObject) {");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("continue;");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("viewDescriptors.add(new org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor(new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter((org.eclipse.emf.ecore.EObject) nextObject), org.eclipse.gmf.runtime.notation.Node.class, null, getDiagramPreferencesHint()));");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return createShortcutsCommand(dropRequest, viewDescriptors);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private org.eclipse.gef.commands.Command createShortcutsCommand(org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest dropRequest, java.util.List<org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor> viewDescriptors) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("org.eclipse.gef.commands.Command command = createViewsAndArrangeCommand(dropRequest, viewDescriptors);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (command != null) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("return command.chain(new org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy(new ");
        CharSequence _qualifiedClassName = this.createShoutrtcutDecorationCommand.qualifiedClassName(it);
        _builder.append(_qualifiedClassName, "\t\t\t");
        _builder.append("(getEditingDomain(), (org.eclipse.gmf.runtime.notation.View) getModel(), viewDescriptors)));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("});");
        _builder.newLine();
      }
    }
    {
      boolean _shouldGenerateDiagramViewmap = this._utils_qvto.shouldGenerateDiagramViewmap(it);
      if (_shouldGenerateDiagramViewmap) {
        _builder.append("// diagram figure does layout; need to install child editpolicy to show selection feedback");
        _builder.newLine();
        _builder.append("installEditPolicy(org.eclipse.gef.EditPolicy.LAYOUT_ROLE, new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected org.eclipse.gef.EditPolicy createChildEditPolicy(org.eclipse.gef.EditPart child) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("final org.eclipse.gef.editpolicies.NonResizableEditPolicy p = new org.eclipse.gef.editpolicies.NonResizableEditPolicy();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("p.setDragAllowed(false);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return p;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected org.eclipse.gef.commands.Command getMoveChildrenCommand(org.eclipse.gef.Request request) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected org.eclipse.gef.commands.Command getCreateCommand(org.eclipse.gef.requests.CreateRequest request) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("});");
        _builder.newLine();
      }
    }
    CharSequence _behaviour = this.xptEditpartsCommon.behaviour(it);
    _builder.append(_behaviour, "");
    _builder.newLineIfNotEmpty();
    _builder.append("// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence featureForMetaclass(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (");
    TypeModelFacet _modelFacet = it.getModelFacet();
    GenClass _metaClass = _modelFacet.getMetaClass();
    CharSequence _MetaClass = this._metaModel.MetaClass(_metaClass);
    _builder.append(_MetaClass, "");
    _builder.append(".equals(class1)) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return ");
    TypeModelFacet _modelFacet_1 = it.getModelFacet();
    GenFeature _containmentMetaFeature = _modelFacet_1.getContainmentMetaFeature();
    CharSequence _MetaFeature = this._metaModel.MetaFeature(_containmentMetaFeature);
    _builder.append(_MetaFeature, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
