/**
 * Copyright (c) 2007, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.diagram.editpolicies;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Iterator;
import metamodel.MetaModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.GenConstraint;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderContainer;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkConstraints;
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.papyrus.papyrusgmfgenextension.GenerateUsingElementTypeCreationCommand;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import plugin.Activator;
import xpt.Common;
import xpt.OclMigrationProblems_qvto;
import xpt.diagram.editpolicies.Utils_qvto;
import xpt.editor.VisualIDRegistry;
import xpt.providers.ElementTypes;

@Singleton
@SuppressWarnings("all")
public class BaseItemSemanticEditPolicy extends xpt.diagram.editpolicies.BaseItemSemanticEditPolicy {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  private Activator xptPluginActivator;
  
  @Inject
  @Extension
  private VisualIDRegistry _visualIDRegistry;
  
  @Inject
  private ElementTypes xptElementTypes;
  
  @Inject
  @Extension
  private OclMigrationProblems_qvto _oclMigrationProblems_qvto;
  
  @Inject
  @Extension
  private Utils_qvto _utils_qvto;
  
  @Inject
  private MetaModel xptMetaModel;
  
  public CharSequence BaseItemSemanticEditPolicy(final GenDiagram it) {
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
    _builder.append(" extends org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _attributes = this.attributes(it);
    _builder.append(_attributes, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _constructor = this.constructor(it);
    _builder.append(_constructor, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment(
      ((((((("Extended request data key to hold editpart visual id.\n" + "Add visual id of edited editpart to extended data of the request\n") + "so command switch can decide what kind of diagram element is being edited.\n") + "It is done in those cases when it\'s not possible to deduce diagram\n") + "element kind from domain element.\n") + "Add the reoriented view to the request extended data so that the view\n ") + "currently edited can be distinguished from other views of the same element\n ") + 
        "and these latter possibly removed if they become inconsistent after reconnect\n"));
    _builder.append(_generatedMemberComment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@SuppressWarnings(\"unchecked\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public org.eclipse.gef.commands.Command getCommand(org.eclipse.gef.Request request) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (request instanceof org.eclipse.gef.requests.ReconnectRequest) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Object view = ((org.eclipse.gef.requests.ReconnectRequest) request).getConnectionEditPart().getModel();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (view instanceof org.eclipse.gmf.runtime.notation.View) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Integer id = new Integer(");
    CharSequence _visualIDMethodCall = this._visualIDRegistry.getVisualIDMethodCall(it);
    _builder.append(_visualIDMethodCall, "\t\t\t\t");
    _builder.append("((org.eclipse.gmf.runtime.notation.View) view));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("request.getExtendedData().put(VISUAL_ID_KEY, id);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("request.getExtendedData().put(GRAPHICAL_RECONNECTED_EDGE, view);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return super.getCommand(request);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment("Returns visual id from request parameters.");
    _builder.append(_generatedMemberComment_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected int getVisualID(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest request) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Object id = request.getParameter(VISUAL_ID_KEY);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return id instanceof Integer ? ((Integer) id).intValue() : -1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _semanticPart = this.semanticPart(it);
    _builder.append(_semanticPart, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_2 = this._common.generatedMemberComment("Returns editing domain from the host edit part.");
    _builder.append(_generatedMemberComment_2, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected org.eclipse.emf.transaction.TransactionalEditingDomain getEditingDomain() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return ((org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart) getHost()).getEditingDomain();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _addDestroyShortcutsCommand = this.addDestroyShortcutsCommand(it);
    _builder.append(_addDestroyShortcutsCommand, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<GenLink> _links = it.getLinks();
      final Function1<GenLink, Boolean> _function = new Function1<GenLink, Boolean>() {
        public Boolean apply(final GenLink link) {
          boolean _isSansDomain = link.isSansDomain();
          return Boolean.valueOf((!_isSansDomain));
        }
      };
      boolean _exists = IterableExtensions.<GenLink>exists(_links, _function);
      if (_exists) {
        CharSequence _linkConstraints = this.linkConstraints(it);
        _builder.append(_linkConstraints, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    CharSequence _additions = this.additions(it);
    _builder.append(_additions, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence addDestroyShortcutsCommand(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment("Clean all shortcuts to the host element from the same diagram");
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void addDestroyShortcutsCommand(org.eclipse.gmf.runtime.common.core.command.ICompositeCommand cmd, org.eclipse.gmf.runtime.notation.View view) {");
    _builder.newLine();
    _builder.append("\t");
    CharSequence __assert = this._common._assert("view.getEAnnotation(\"Shortcut\") == null");
    _builder.append(__assert, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("for (java.util.Iterator<?> it = view.getDiagram().getChildren().iterator(); it.hasNext();) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.gmf.runtime.notation.View nextView = (org.eclipse.gmf.runtime.notation.View) it.next();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (nextView.getEAnnotation(\"Shortcut\") == null || !nextView.isSetElement() || nextView.getElement() != view.getElement()) { ");
    CharSequence _nonNLS = this._common.nonNLS();
    _builder.append(_nonNLS, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("continue;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), nextView));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence attributes(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment("Extended request data key to hold editpart visual id.");
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public static final String VISUAL_ID_KEY = \"visual_id\"; ");
    CharSequence _nonNLS = this._common.nonNLS();
    _builder.append(_nonNLS, "");
    _builder.newLineIfNotEmpty();
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment("Extended request data key to hold the edge view during a reconnect request.");
    _builder.append(_generatedMemberComment_1, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public static final String GRAPHICAL_RECONNECTED_EDGE = \"graphical_edge\"; ");
    CharSequence _nonNLS_1 = this._common.nonNLS();
    _builder.append(_nonNLS_1, "");
    _builder.newLineIfNotEmpty();
    CharSequence _generatedMemberComment_2 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_2, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private final org.eclipse.gmf.runtime.emf.type.core.IElementType myElementType;");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence semanticPart(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _semanticCommand = this.getSemanticCommand(it);
    _builder.append(_semanticCommand, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _addDeleteViewCommand = this.addDeleteViewCommand(it);
    _builder.append(_addDeleteViewCommand, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _editHelperCommand = this.getEditHelperCommand(it);
    _builder.append(_editHelperCommand, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _contextElementType = this.getContextElementType(it);
    _builder.append(_contextElementType, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _semanticCommandSwitch = this.getSemanticCommandSwitch(it);
    _builder.append(_semanticCommandSwitch, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _configureCommand = this.getConfigureCommand(it);
    _builder.append(_configureCommand, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _createRelationshipCommand = this.getCreateRelationshipCommand(it);
    _builder.append(_createRelationshipCommand, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _createCommand = this.getCreateCommand(it);
    _builder.append(_createCommand, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// RS: add code for extended types");
    _builder.newLine();
    CharSequence _createExtendedTypeCommand = this.getCreateExtendedTypeCommand(it);
    _builder.append(_createExtendedTypeCommand, "");
    _builder.newLineIfNotEmpty();
    CharSequence _extendedStartCreateRelationshipCommand = this.getExtendedStartCreateRelationshipCommand(it);
    _builder.append(_extendedStartCreateRelationshipCommand, "");
    _builder.newLineIfNotEmpty();
    CharSequence _extendedCompleteCreateRelationshipCommand = this.getExtendedCompleteCreateRelationshipCommand(it);
    _builder.append(_extendedCompleteCreateRelationshipCommand, "");
    _builder.newLineIfNotEmpty();
    _builder.append("// RS: End of add code for extended types");
    _builder.newLine();
    CharSequence _createSemanticServiceEditCommand = this.getCreateSemanticServiceEditCommand(it);
    _builder.append(_createSemanticServiceEditCommand, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _setCommand = this.getSetCommand(it);
    _builder.append(_setCommand, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _editContextCommand = this.getEditContextCommand(it);
    _builder.append(_editContextCommand, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _destroyElementCommand = this.getDestroyElementCommand(it);
    _builder.append(_destroyElementCommand, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _destroyReferenceCommand = this.getDestroyReferenceCommand(it);
    _builder.append(_destroyReferenceCommand, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _duplicateCommand = this.getDuplicateCommand(it);
    _builder.append(_duplicateCommand, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _moveCommand = this.getMoveCommand(it);
    _builder.append(_moveCommand, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _reorientReferenceRelationshipCommand = this.getReorientReferenceRelationshipCommand(it);
    _builder.append(_reorientReferenceRelationshipCommand, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _reorientRelationshipCommand = this.getReorientRelationshipCommand(it);
    _builder.append(_reorientRelationshipCommand, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _gEFWrapper = this.getGEFWrapper(it);
    _builder.append(_gEFWrapper, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence getContextElementType(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.gmf.runtime.emf.type.core.IElementType getContextElementType(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest request) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.emf.type.core.IElementType requestContextElementType = ");
    CharSequence _qualifiedClassName = this.xptElementTypes.qualifiedClassName(it);
    _builder.append(_qualifiedClassName, "\t");
    _builder.append(".getElementType(getVisualID(request));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return requestContextElementType != null ? requestContextElementType : myElementType;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getCreateRelationshipCommand(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.gef.commands.Command getCreateRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest req) {");
    _builder.newLine();
    {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<GenerateUsingElementTypeCreationCommand> _filter = Iterators.<GenerateUsingElementTypeCreationCommand>filter(_allContents, GenerateUsingElementTypeCreationCommand.class);
      int _size = IteratorExtensions.size(_filter);
      boolean _lessThan = (_size < 1);
      if (_lessThan) {
        _builder.append("\t");
        _builder.append("return null;");
        _builder.newLine();
      }
    }
    {
      Resource _eResource_1 = it.eResource();
      TreeIterator<EObject> _allContents_1 = _eResource_1.getAllContents();
      Iterator<GenerateUsingElementTypeCreationCommand> _filter_1 = Iterators.<GenerateUsingElementTypeCreationCommand>filter(_allContents_1, GenerateUsingElementTypeCreationCommand.class);
      int _size_1 = IteratorExtensions.size(_filter_1);
      boolean _greaterThan = (_size_1 > 0);
      if (_greaterThan) {
        _builder.append("\t");
        _builder.append("org.eclipse.papyrus.infra.services.edit.service.IElementEditService commandService = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(((org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart)getHost()).resolveSemanticElement());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if(req.getElementType() != null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("commandService = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(req.getElementType());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if(commandService == null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("org.eclipse.gmf.runtime.common.core.command.ICommand semanticCommand = commandService.getEditCommand(req);");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if((semanticCommand != null) && (semanticCommand.canExecute())) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return getGEFWrapper(semanticCommand);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("} ");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getCreateCommand(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected org.eclipse.gef.commands.Command getCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest req) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.gmf.runtime.emf.type.core.IElementType requestElementType = req.getElementType();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (requestElementType instanceof org.eclipse.gmf.runtime.emf.type.core.IElementType) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("org.eclipse.papyrus.infra.services.edit.service.IElementEditService commandProvider = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(req.getContainer());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (commandProvider != null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("org.eclipse.gmf.runtime.common.core.command.ICommand command = commandProvider.getEditCommand(req);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (command != null && command.canExecute()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("return new org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy(command);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getCreateExtendedTypeCommand(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("protected org.eclipse.gef.commands.Command getExtendedTypeCreationCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest request, org.eclipse.gmf.runtime.emf.type.core.IElementType requestElementType) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(request.getContainer());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if(provider == null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// Retrieve create command from the Element Edit service");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.gmf.runtime.common.core.command.ICommand createGMFCommand = provider.getEditCommand(request);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return getGEFWrapper(createGMFCommand);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getExtendedStartCreateRelationshipCommand(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("protected org.eclipse.gef.commands.Command getExtendedStartCreateRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest request, org.eclipse.gmf.runtime.emf.type.core.IElementType requestElementType) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(requestElementType);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if(provider == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// Retrieve create command from the Element Edit service");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.common.core.command.ICommand createGMFCommand = provider.getEditCommand(request);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return getGEFWrapper(createGMFCommand);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getExtendedCompleteCreateRelationshipCommand(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("protected org.eclipse.gef.commands.Command getExtendedCompleteCreateRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest request, org.eclipse.gmf.runtime.emf.type.core.IElementType requestElementType) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(requestElementType);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if(provider == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// Retrieve create command from the Element Edit service");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.common.core.command.ICommand createGMFCommand = provider.getEditCommand(request);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return getGEFWrapper(createGMFCommand);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getMoveCommand(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.gef.commands.Command getMoveCommand(org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest req) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("org.eclipse.emf.ecore.EObject targetCEObject = req.getTargetContainer();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if(targetCEObject != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(targetCEObject);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if(provider != null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("org.eclipse.gmf.runtime.common.core.command.ICommand moveCommand = provider.getEditCommand(req);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if(moveCommand != null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("return new org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy(moveCommand);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return getGEFWrapper(new org.eclipse.gmf.runtime.emf.type.core.commands.MoveElementsCommand(req));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * FIXME need to check constraint's provider to ensure we don't generate a field
   * 		for e.g. Java (or Literal, which is unlikely, though) expressions
   * 
   * 		[Papyrus Quick Fix] Do not generate field when the expression is provided
   * 		by a GenJavaExpressionProvider.
   */
  public CharSequence linkConstraints(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public static ");
    String _linkCreationConstraintsClassName = it.getLinkCreationConstraintsClassName();
    _builder.append(_linkCreationConstraintsClassName, "\t");
    _builder.append(" getLinkConstraints() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _linkCreationConstraintsClassName_1 = it.getLinkCreationConstraintsClassName();
    _builder.append(_linkCreationConstraintsClassName_1, "\t\t");
    _builder.append(" cached = ");
    GenEditorGenerator _editorGen = it.getEditorGen();
    CharSequence _instanceAccess = this.xptPluginActivator.instanceAccess(_editorGen);
    _builder.append(_instanceAccess, "\t\t");
    _builder.append(".getLinkConstraints();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("if (cached == null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    GenEditorGenerator _editorGen_1 = it.getEditorGen();
    CharSequence _instanceAccess_1 = this.xptPluginActivator.instanceAccess(_editorGen_1);
    _builder.append(_instanceAccess_1, "\t\t\t");
    _builder.append(".setLinkConstraints(cached = new ");
    String _linkCreationConstraintsClassName_2 = it.getLinkCreationConstraintsClassName();
    _builder.append(_linkCreationConstraintsClassName_2, "\t\t\t");
    _builder.append("());");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return cached;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generatedClassComment = this._common.generatedClassComment();
    _builder.append(_generatedClassComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public static class ");
    String _linkCreationConstraintsClassName_3 = it.getLinkCreationConstraintsClassName();
    _builder.append(_linkCreationConstraintsClassName_3, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public ");
    String _linkCreationConstraintsClassName_4 = it.getLinkCreationConstraintsClassName();
    _builder.append(_linkCreationConstraintsClassName_4, "\t");
    _builder.append("() {");
    _builder.append("\t\t// use static method #getLinkConstraints() to access instance");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<GenLink> _links = it.getLinks();
      for(final GenLink nextLink : _links) {
        _builder.append("\t");
        CharSequence _canCreate = this.canCreate(nextLink);
        _builder.append(_canCreate, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      EList<GenLink> _links_1 = it.getLinks();
      for(final GenLink nextLink_1 : _links_1) {
        _builder.append("\t");
        CharSequence _canExist = this.canExist(nextLink_1);
        _builder.append(_canExist, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * [MG] extracted from LET statement, @see checkEMFConstraints(TypeLinkModelFacet)
   */
  private boolean checkChildFeatureBounds(final TypeLinkModelFacet it) {
    boolean _and = false;
    GenFeature _childMetaFeature = it.getChildMetaFeature();
    GenFeature _containmentMetaFeature = it.getContainmentMetaFeature();
    boolean _notEquals = (!Objects.equal(_childMetaFeature, _containmentMetaFeature));
    if (!_notEquals) {
      _and = false;
    } else {
      GenFeature _childMetaFeature_1 = it.getChildMetaFeature();
      EStructuralFeature _ecoreFeature = _childMetaFeature_1.getEcoreFeature();
      boolean _isUnbounded = this._oclMigrationProblems_qvto.isUnbounded(_ecoreFeature);
      boolean _not = (!_isUnbounded);
      _and = _not;
    }
    return _and;
  }
  
  public CharSequence checkEMFConstraints(final TypeLinkModelFacet it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      GenFeature _containmentMetaFeature = it.getContainmentMetaFeature();
      EStructuralFeature _ecoreFeature = _containmentMetaFeature.getEcoreFeature();
      boolean _notEquals = (!Objects.equal(_ecoreFeature, null));
      if (_notEquals) {
        {
          boolean _or = false;
          GenFeature _containmentMetaFeature_1 = it.getContainmentMetaFeature();
          EStructuralFeature _ecoreFeature_1 = _containmentMetaFeature_1.getEcoreFeature();
          boolean _isUnbounded = this._oclMigrationProblems_qvto.isUnbounded(_ecoreFeature_1);
          boolean _not = (!_isUnbounded);
          if (_not) {
            _or = true;
          } else {
            boolean _checkChildFeatureBounds = this.checkChildFeatureBounds(it);
            _or = _checkChildFeatureBounds;
          }
          if (_or) {
            _builder.append("if (");
            String _containerVariable = this._utils_qvto.getContainerVariable(it);
            _builder.append(_containerVariable, "");
            _builder.append(" != null) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            GenFeature _containmentMetaFeature_2 = it.getContainmentMetaFeature();
            CharSequence _checkEMFConstraints = this.checkEMFConstraints(_containmentMetaFeature_2, it);
            _builder.append(_checkEMFConstraints, "\t\t\t");
            _builder.newLineIfNotEmpty();
            {
              boolean _checkChildFeatureBounds_1 = this.checkChildFeatureBounds(it);
              if (_checkChildFeatureBounds_1) {
                _builder.append("\t\t\t");
                GenFeature _childMetaFeature = it.getChildMetaFeature();
                CharSequence _checkEMFConstraints_1 = this.checkEMFConstraints(_childMetaFeature, it);
                _builder.append(_checkEMFConstraints_1, "\t\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence checkEMFConstraints(final GenFeature it, final TypeLinkModelFacet modelFacet) {
    StringConcatenation _builder = new StringConcatenation();
    {
      GenFeature _containmentMetaFeature = modelFacet.getContainmentMetaFeature();
      EStructuralFeature _ecoreFeature = _containmentMetaFeature.getEcoreFeature();
      boolean _notEquals = (!Objects.equal(_ecoreFeature, null));
      if (_notEquals) {
        {
          EStructuralFeature _ecoreFeature_1 = it.getEcoreFeature();
          boolean _isUnbounded = this._oclMigrationProblems_qvto.isUnbounded(_ecoreFeature_1);
          boolean _not = (!_isUnbounded);
          if (_not) {
            _builder.append("if (");
            String _containerVariable = this._utils_qvto.getContainerVariable(modelFacet);
            GenClass _sourceType = modelFacet.getSourceType();
            CharSequence _featureBoundComparator = this.featureBoundComparator(it, _containerVariable, _sourceType);
            _builder.append(_featureBoundComparator, "");
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return false;");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence canCreate(final GenLink it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public boolean canCreate");
    String _uniqueIdentifier = it.getUniqueIdentifier();
    _builder.append(_uniqueIdentifier, "");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      boolean _isSansDomain = it.isSansDomain();
      boolean _not = (!_isSansDomain);
      if (_not) {
        LinkModelFacet _modelFacet = it.getModelFacet();
        CharSequence _canCreateParameters = this.canCreateParameters(_modelFacet);
        _builder.append(_canCreateParameters, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(") {");
    _builder.newLine();
    {
      boolean _isSansDomain_1 = it.isSansDomain();
      boolean _not_1 = (!_isSansDomain_1);
      if (_not_1) {
        _builder.append("\t");
        LinkModelFacet _modelFacet_1 = it.getModelFacet();
        CharSequence _checkEMFConstraints = this.checkEMFConstraints(_modelFacet_1);
        _builder.append(_checkEMFConstraints, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("return canExist");
    String _uniqueIdentifier_1 = it.getUniqueIdentifier();
    _builder.append(_uniqueIdentifier_1, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      boolean _isSansDomain_2 = it.isSansDomain();
      boolean _not_2 = (!_isSansDomain_2);
      if (_not_2) {
        _builder.append("\t");
        LinkModelFacet _modelFacet_2 = it.getModelFacet();
        CharSequence _canCreateValues = this.canCreateValues(_modelFacet_2);
        _builder.append(_canCreateValues, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append(");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence featureBoundsConditionClause(final GenFeature it, final String targetVar, final GenClass targetType) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EStructuralFeature _ecoreFeature = it.getEcoreFeature();
      boolean _notEquals = (!Objects.equal(_ecoreFeature, null));
      if (_notEquals) {
        {
          EStructuralFeature _ecoreFeature_1 = it.getEcoreFeature();
          boolean _isUnbounded = this._oclMigrationProblems_qvto.isUnbounded(_ecoreFeature_1);
          boolean _not = (!_isUnbounded);
          if (_not) {
            CharSequence _featureBoundComparator = this.featureBoundComparator(it, targetVar, targetType);
            _builder.append(_featureBoundComparator, "");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          boolean _and = false;
          EStructuralFeature _ecoreFeature_2 = it.getEcoreFeature();
          boolean _isSingleValued = this._oclMigrationProblems_qvto.isSingleValued(_ecoreFeature_2);
          boolean _not_1 = (!_isSingleValued);
          if (!_not_1) {
            _and = false;
          } else {
            EStructuralFeature _ecoreFeature_3 = it.getEcoreFeature();
            boolean _isUnbounded_1 = this._oclMigrationProblems_qvto.isUnbounded(_ecoreFeature_3);
            boolean _not_2 = (!_isUnbounded_1);
            _and = _not_2;
          }
          if (_and) {
            _builder.append(" || ");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          EStructuralFeature _ecoreFeature_4 = it.getEcoreFeature();
          boolean _isSingleValued_1 = this._oclMigrationProblems_qvto.isSingleValued(_ecoreFeature_4);
          boolean _not_3 = (!_isSingleValued_1);
          if (_not_3) {
            CharSequence _featureUniquenessComparator = this.featureUniquenessComparator(it, targetVar, targetType);
            _builder.append(_featureUniquenessComparator, "\t");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence featureBoundComparator(final GenFeature it, final String featureVar, final GenClass featureVarGenClass) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _featureValue = this.xptMetaModel.getFeatureValue(it, featureVar, featureVarGenClass);
    _builder.append(_featureValue, "");
    _builder.newLineIfNotEmpty();
    {
      EStructuralFeature _ecoreFeature = it.getEcoreFeature();
      int _upperBound = _ecoreFeature.getUpperBound();
      boolean _equals = (_upperBound == 1);
      if (_equals) {
        _builder.append("!= null");
        _builder.newLine();
      } else {
        _builder.append(".size() >= ");
        EStructuralFeature _ecoreFeature_1 = it.getEcoreFeature();
        int _upperBound_1 = _ecoreFeature_1.getUpperBound();
        _builder.append(_upperBound_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence getCreateSemanticServiceEditCommand(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<GenerateUsingElementTypeCreationCommand> _filter = Iterators.<GenerateUsingElementTypeCreationCommand>filter(_allContents, GenerateUsingElementTypeCreationCommand.class);
      int _size = IteratorExtensions.size(_filter);
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        CharSequence _generatedMemberComment = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment, "");
        _builder.newLineIfNotEmpty();
        _builder.append("protected org.eclipse.gmf.runtime.common.core.command.ICommand getSemanticCreationCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest req) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("org.eclipse.papyrus.infra.services.edit.service.IElementEditService commandService = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(req.getContainer());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if(commandService == null) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return commandService.getEditCommand(req);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  /**
   * XXX for now, both constraints are injected into single method
   * 			which may not be suitable for modification especially when mixing
   * 			java and ocl constraints (former requires manual code).
   * 		Better approach would be:
   * 			if either is non-null and providers are not the same - introduce two methods,
   * 			to check source and target separately. Otherwize, do it inplace.
   */
  public CharSequence canExist(final GenLink it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public boolean canExist");
    String _uniqueIdentifier = it.getUniqueIdentifier();
    _builder.append(_uniqueIdentifier, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      boolean _isSansDomain = it.isSansDomain();
      boolean _not = (!_isSansDomain);
      if (_not) {
        LinkModelFacet _modelFacet = it.getModelFacet();
        CharSequence _canExistParameters = this.canExistParameters(_modelFacet);
        _builder.append(_canExistParameters, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(") {");
    _builder.newLine();
    {
      boolean _and = false;
      boolean _and_1 = false;
      GenLinkConstraints _creationConstraints = it.getCreationConstraints();
      boolean _notEquals = (!Objects.equal(_creationConstraints, null));
      if (!_notEquals) {
        _and_1 = false;
      } else {
        GenLinkConstraints _creationConstraints_1 = it.getCreationConstraints();
        boolean _isValid = _creationConstraints_1.isValid();
        _and_1 = _isValid;
      }
      if (!_and_1) {
        _and = false;
      } else {
        GenDiagram _diagram = it.getDiagram();
        GenEditorGenerator _editorGen = _diagram.getEditorGen();
        GenExpressionProviderContainer _expressionProviders = _editorGen.getExpressionProviders();
        boolean _notEquals_1 = (!Objects.equal(_expressionProviders, null));
        _and = _notEquals_1;
      }
      if (_and) {
        _builder.append("try {");
        _builder.newLine();
        {
          GenLinkConstraints _creationConstraints_2 = it.getCreationConstraints();
          GenConstraint _sourceEnd = _creationConstraints_2.getSourceEnd();
          boolean _notEquals_2 = (!Objects.equal(_sourceEnd, null));
          if (_notEquals_2) {
            GenLinkConstraints _creationConstraints_3 = it.getCreationConstraints();
            GenConstraint _sourceEnd_1 = _creationConstraints_3.getSourceEnd();
            GenExpressionProviderBase _provider = _sourceEnd_1.getProvider();
            GenLinkConstraints _creationConstraints_4 = it.getCreationConstraints();
            GenConstraint _sourceEnd_2 = _creationConstraints_4.getSourceEnd();
            GenLinkConstraints _creationConstraints_5 = it.getCreationConstraints();
            GenClass _sourceEndContextClass = _creationConstraints_5.getSourceEndContextClass();
            GenLinkConstraints _creationConstraints_6 = it.getCreationConstraints();
            GenClass _targetEndContextClass = _creationConstraints_6.getTargetEndContextClass();
            CharSequence _checkAdditionalConstraint = this.checkAdditionalConstraint(_provider, _sourceEnd_2, "source", "target", _sourceEndContextClass, _targetEndContextClass);
            _builder.append(_checkAdditionalConstraint, "");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          GenLinkConstraints _creationConstraints_7 = it.getCreationConstraints();
          GenConstraint _targetEnd = _creationConstraints_7.getTargetEnd();
          boolean _notEquals_3 = (!Objects.equal(_targetEnd, null));
          if (_notEquals_3) {
            GenLinkConstraints _creationConstraints_8 = it.getCreationConstraints();
            GenConstraint _targetEnd_1 = _creationConstraints_8.getTargetEnd();
            GenExpressionProviderBase _provider_1 = _targetEnd_1.getProvider();
            GenLinkConstraints _creationConstraints_9 = it.getCreationConstraints();
            GenConstraint _targetEnd_2 = _creationConstraints_9.getTargetEnd();
            GenLinkConstraints _creationConstraints_10 = it.getCreationConstraints();
            GenClass _targetEndContextClass_1 = _creationConstraints_10.getTargetEndContextClass();
            GenLinkConstraints _creationConstraints_11 = it.getCreationConstraints();
            GenClass _sourceEndContextClass_1 = _creationConstraints_11.getSourceEndContextClass();
            CharSequence _checkAdditionalConstraint_1 = this.checkAdditionalConstraint(_provider_1, _targetEnd_2, "target", "source", _targetEndContextClass_1, _sourceEndContextClass_1);
            _builder.append(_checkAdditionalConstraint_1, "");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("return true;");
        _builder.newLine();
        _builder.append("} catch(Exception e) {\t");
        _builder.newLine();
        _builder.append("\t");
        GenDiagram _diagram_1 = it.getDiagram();
        GenEditorGenerator _editorGen_1 = _diagram_1.getEditorGen();
        CharSequence _instanceAccess = this.xptPluginActivator.instanceAccess(_editorGen_1);
        _builder.append(_instanceAccess, "\t");
        _builder.append(".logError(\"Link constraint evaluation error\", e); ");
        CharSequence _nonNLS = this._common.nonNLS();
        _builder.append(_nonNLS, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("return false;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      } else {
        _builder.append("return true;");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
