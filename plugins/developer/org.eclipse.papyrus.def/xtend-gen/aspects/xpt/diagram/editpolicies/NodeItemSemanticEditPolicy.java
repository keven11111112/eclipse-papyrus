/**
 * Copyright (c) 2007-2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - [257632] do not rely on EditPart presence for element deletion
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.diagram.editpolicies;

import aspects.xpt.diagram.editpolicies.BaseItemSemanticEditPolicy;
import aspects.xpt.diagram.editpolicies.linkCommands;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import utils.UtilsItemSemanticEditPolicy;
import xpt.Common;
import xpt.diagram.editpolicies.Utils_qvto;
import xpt.diagram.editpolicies.childContainerCreateCommand;
import xpt.editor.VisualIDRegistry;

/**
 * This template should be called only for non-design nodes (modelFacet != null)
 * 	because *ItemSemanticEditPolicy responsible for dealing with semantic model
 * 	elements and meaningless (should not be generated) for pure design nodes.
 */
@Singleton
@SuppressWarnings("all")
public class NodeItemSemanticEditPolicy extends xpt.diagram.editpolicies.NodeItemSemanticEditPolicy {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private Utils_qvto _utils_qvto;
  
  @Inject
  @Extension
  private UtilsItemSemanticEditPolicy _utilsItemSemanticEditPolicy;
  
  @Inject
  private BaseItemSemanticEditPolicy xptBaseItemSemanticEditPolicy;
  
  @Inject
  private childContainerCreateCommand xptChildContainerCreateCommand;
  
  @Inject
  private linkCommands xptLinkCommands;
  
  @Inject
  private VisualIDRegistry xptVisualIDRegistry;
  
  public CharSequence NodeItemSemanticEditPolicy(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    GenDiagram _diagram = it.getDiagram();
    GenEditorGenerator _editorGen = _diagram.getEditorGen();
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
    _builder.append(" extends ");
    GenDiagram _diagram_1 = it.getDiagram();
    CharSequence _qualifiedClassName = this.xptBaseItemSemanticEditPolicy.qualifiedClassName(_diagram_1);
    _builder.append(_qualifiedClassName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    Object _defaultConstructor = this.xptBaseItemSemanticEditPolicy.defaultConstructor(it);
    _builder.append(_defaultConstructor, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    EList<GenChildNode> _childNodes = it.getChildNodes();
    CharSequence _childContainerCreateCommand = this.xptChildContainerCreateCommand.childContainerCreateCommand(_childNodes);
    _builder.append(_childContainerCreateCommand, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<EditPartUsingDeleteService> _filter = Iterators.<EditPartUsingDeleteService>filter(_allContents, EditPartUsingDeleteService.class);
      final Function1<EditPartUsingDeleteService, Boolean> _function = new Function1<EditPartUsingDeleteService, Boolean>() {
        public Boolean apply(final EditPartUsingDeleteService v) {
          EList<GenCommonBase> _genView = v.getGenView();
          return Boolean.valueOf(_genView.contains(it));
        }
      };
      Iterator<EditPartUsingDeleteService> _filter_1 = IteratorExtensions.<EditPartUsingDeleteService>filter(_filter, _function);
      int _size = IteratorExtensions.size(_filter_1);
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        CharSequence _generatedMemberComment = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment, "");
        _builder.newLineIfNotEmpty();
        CharSequence _destroyElementCommandByService = this._utilsItemSemanticEditPolicy.getDestroyElementCommandByService(it);
        _builder.append(_destroyElementCommandByService, "");
        _builder.newLineIfNotEmpty();
      } else {
        CharSequence _destroyElementCommand = this.getDestroyElementCommand(it);
        _builder.append(_destroyElementCommand, "");
        _builder.newLineIfNotEmpty();
        {
          boolean _hasChildrenOrCompartments = this._utils_qvto.hasChildrenOrCompartments(it);
          if (_hasChildrenOrCompartments) {
            CharSequence _addDestroyChildNodesCommand = this.addDestroyChildNodesCommand(it);
            _builder.append(_addDestroyChildNodesCommand, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("\t");
    CharSequence _linkCommands = this.xptLinkCommands.linkCommands(it);
    _builder.append(_linkCommands, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _additions = this.additions(it);
    _builder.append(_additions, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getDestroyElementCommand(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.gef.commands.Command getDestroyElementCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest req) {");
    _builder.newLine();
    _builder.append(" \t");
    _builder.append("org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) getHost().getModel();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand cmd = new org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand(getEditingDomain(), null);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("cmd.setTransactionNestingEnabled(true);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.emf.ecore.EAnnotation annotation = view.getEAnnotation(\"Shortcut\");");
    CharSequence _nonNLS = this._common.nonNLS();
    _builder.append(_nonNLS, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("if (annotation == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// there are indirectly referenced children, need extra commands: ");
    EList<GenChildNode> _childNodes = it.getChildNodes();
    EList<GenCompartment> _compartments = it.getCompartments();
    final Function1<GenCompartment, EList<GenChildNode>> _function = new Function1<GenCompartment, EList<GenChildNode>>() {
      public EList<GenChildNode> apply(final GenCompartment c) {
        return c.getChildNodes();
      }
    };
    List<EList<GenChildNode>> _map = ListExtensions.<GenCompartment, EList<GenChildNode>>map(_compartments, _function);
    Iterable<GenChildNode> _flatten = Iterables.<GenChildNode>concat(_map);
    Iterable<GenChildNode> _union = NodeItemSemanticEditPolicy.<GenChildNode>union(_childNodes, _flatten);
    final Function1<GenChildNode, Boolean> _function_1 = new Function1<GenChildNode, Boolean>() {
      public Boolean apply(final GenChildNode gcn) {
        boolean _isDirectlyOwned = NodeItemSemanticEditPolicy.this._utils_qvto.isDirectlyOwned(gcn, it);
        return Boolean.valueOf((!_isDirectlyOwned));
      }
    };
    boolean _exists = IterableExtensions.<GenChildNode>exists(_union, _function_1);
    _builder.append(_exists, "\t\t");
    _builder.newLineIfNotEmpty();
    {
      boolean _hasChildrenOrCompartments = this._utils_qvto.hasChildrenOrCompartments(it);
      if (_hasChildrenOrCompartments) {
        _builder.append("\t");
        _builder.append("addDestroyChildNodesCommand(cmd);");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("addDestroyShortcutsCommand(cmd, view);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// delete host element");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("java.util.List<org.eclipse.emf.ecore.EObject> todestroy=new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("todestroy.add(req.getElementToDestroy());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand(req));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("cmd.add(new org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper(new org.eclipse.emf.edit.command.DeleteCommand(getEditingDomain(),todestroy )));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.append("\t\tcmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), view));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return getGEFWrapper(cmd.reduce());");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence addDestroyChildNodesCommand(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void addDestroyChildNodesCommand(org.eclipse.gmf.runtime.common.core.command.ICompositeCommand cmd) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) getHost().getModel();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (java.util.Iterator<?> nit = view.getChildren().iterator(); nit.hasNext();) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.gmf.runtime.notation.Node node = (org.eclipse.gmf.runtime.notation.Node) nit.next();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch (");
    GenDiagram _diagram = it.getDiagram();
    CharSequence _visualIDMethodCall = this.xptVisualIDRegistry.getVisualIDMethodCall(_diagram);
    _builder.append(_visualIDMethodCall, "\t\t");
    _builder.append("(node)) {");
    _builder.newLineIfNotEmpty();
    {
      EList<GenChildNode> _childNodes = it.getChildNodes();
      for(final GenChildNode cn : _childNodes) {
        _builder.append("\t\t");
        CharSequence _destroyChildNodes = this.destroyChildNodes(cn, "node", it);
        _builder.append(_destroyChildNodes, "\t\t");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<GenCompartment> _compartments = it.getCompartments();
      for(final GenCompartment compartment : _compartments) {
        _builder.append("\t\t");
        CharSequence _caseVisualID = this.xptVisualIDRegistry.caseVisualID(compartment);
        _builder.append(_caseVisualID, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("for (java.util.Iterator<?> cit = node.getChildren().iterator(); cit.hasNext();) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("org.eclipse.gmf.runtime.notation.Node cnode = (org.eclipse.gmf.runtime.notation.Node) cit.next();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("switch (");
        GenDiagram _diagram_1 = it.getDiagram();
        CharSequence _visualIDMethodCall_1 = this.xptVisualIDRegistry.getVisualIDMethodCall(_diagram_1);
        _builder.append(_visualIDMethodCall_1, "\t\t\t\t");
        _builder.append("(cnode)) {");
        _builder.newLineIfNotEmpty();
        {
          EList<GenChildNode> _childNodes_1 = compartment.getChildNodes();
          for(final GenChildNode cn_1 : _childNodes_1) {
            _builder.append("\t\t");
            _builder.append("\t\t");
            CharSequence _destroyChildNodes_1 = this.destroyChildNodes(cn_1, "cnode", it);
            _builder.append(_destroyChildNodes_1, "\t\t\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("break;");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * @param view - Notation element for the passed node
   * assumes 'cmd' to point to composite command
   */
  public CharSequence destroyEdges(final GenNode it, final String view) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    {
      EList<GenLink> _genIncomingLinks = it.getGenIncomingLinks();
      boolean _isEmpty = _genIncomingLinks.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("for (java.util.Iterator<?> it = ");
        _builder.append(view, "");
        _builder.append(".getTargetEdges().iterator(); it.hasNext();) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("org.eclipse.gmf.runtime.notation.Edge incomingLink = (org.eclipse.gmf.runtime.notation.Edge) it.next();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("switch(");
        GenDiagram _diagram = it.getDiagram();
        CharSequence _visualIDMethodCall = this.xptVisualIDRegistry.getVisualIDMethodCall(_diagram);
        _builder.append(_visualIDMethodCall, "\t");
        _builder.append("(incomingLink)) {");
        _builder.newLineIfNotEmpty();
        {
          EList<GenLink> _genIncomingLinks_1 = it.getGenIncomingLinks();
          final Function1<GenLink, Boolean> _function = new Function1<GenLink, Boolean>() {
            public Boolean apply(final GenLink l) {
              LinkModelFacet _modelFacet = l.getModelFacet();
              return Boolean.valueOf((_modelFacet instanceof FeatureLinkModelFacet));
            }
          };
          Iterable<GenLink> _filter = IterableExtensions.<GenLink>filter(_genIncomingLinks_1, _function);
          boolean _isEmpty_1 = IterableExtensions.isEmpty(_filter);
          boolean _not_1 = (!_isEmpty_1);
          if (_not_1) {
            {
              EList<GenLink> _genIncomingLinks_2 = it.getGenIncomingLinks();
              final Function1<GenLink, Boolean> _function_1 = new Function1<GenLink, Boolean>() {
                public Boolean apply(final GenLink l) {
                  LinkModelFacet _modelFacet = l.getModelFacet();
                  return Boolean.valueOf((_modelFacet instanceof FeatureLinkModelFacet));
                }
              };
              Iterable<GenLink> _filter_1 = IterableExtensions.<GenLink>filter(_genIncomingLinks_2, _function_1);
              for(final GenLink il : _filter_1) {
                _builder.append("case ");
                CharSequence _visualID = VisualIDRegistry.visualID(il);
                _builder.append(_visualID, "");
                _builder.append(":");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t\t\t");
            _builder.append("org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest destroyRefReq = new org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand(destroyRefReq));");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), incomingLink));");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("break;");
            _builder.newLine();
          }
        }
        {
          EList<GenLink> _genIncomingLinks_3 = it.getGenIncomingLinks();
          final Function1<GenLink, Boolean> _function_2 = new Function1<GenLink, Boolean>() {
            public Boolean apply(final GenLink l) {
              LinkModelFacet _modelFacet = l.getModelFacet();
              return Boolean.valueOf((_modelFacet instanceof TypeLinkModelFacet));
            }
          };
          Iterable<GenLink> _filter_2 = IterableExtensions.<GenLink>filter(_genIncomingLinks_3, _function_2);
          boolean _isEmpty_2 = IterableExtensions.isEmpty(_filter_2);
          boolean _not_2 = (!_isEmpty_2);
          if (_not_2) {
            {
              EList<GenLink> _genIncomingLinks_4 = it.getGenIncomingLinks();
              final Function1<GenLink, Boolean> _function_3 = new Function1<GenLink, Boolean>() {
                public Boolean apply(final GenLink l) {
                  LinkModelFacet _modelFacet = l.getModelFacet();
                  return Boolean.valueOf((_modelFacet instanceof TypeLinkModelFacet));
                }
              };
              Iterable<GenLink> _filter_3 = IterableExtensions.<GenLink>filter(_genIncomingLinks_4, _function_3);
              for(final GenLink il_1 : _filter_3) {
                _builder.append("case ");
                CharSequence _visualID_1 = VisualIDRegistry.visualID(il_1);
                _builder.append(_visualID_1, "");
                _builder.append(":");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t\t\t");
            _builder.append("org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest destroyEltReq = new org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest(incomingLink.getElement(), false);");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand(destroyEltReq));");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), incomingLink));");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("break;");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      EList<GenLink> _genOutgoingLinks = it.getGenOutgoingLinks();
      boolean _isEmpty_3 = _genOutgoingLinks.isEmpty();
      if (_isEmpty_3) {
        _builder.append("for (java.util.Iterator<?> it = ");
        _builder.append(view, "");
        _builder.append(".getSourceEdges().iterator(); it.hasNext();) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("org.eclipse.gmf.runtime.notation.Edge outgoingLink = (org.eclipse.gmf.runtime.notation.Edge) it.next();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("switch(");
        GenDiagram _diagram_1 = it.getDiagram();
        CharSequence _visualIDMethodCall_1 = this.xptVisualIDRegistry.getVisualIDMethodCall(_diagram_1);
        _builder.append(_visualIDMethodCall_1, "\t");
        _builder.append("(outgoingLink)) {");
        _builder.newLineIfNotEmpty();
        {
          EList<GenLink> _genOutgoingLinks_1 = it.getGenOutgoingLinks();
          final Function1<GenLink, Boolean> _function_4 = new Function1<GenLink, Boolean>() {
            public Boolean apply(final GenLink l) {
              LinkModelFacet _modelFacet = l.getModelFacet();
              return Boolean.valueOf((_modelFacet instanceof FeatureLinkModelFacet));
            }
          };
          Iterable<GenLink> _filter_4 = IterableExtensions.<GenLink>filter(_genOutgoingLinks_1, _function_4);
          boolean _isEmpty_4 = IterableExtensions.isEmpty(_filter_4);
          boolean _not_3 = (!_isEmpty_4);
          if (_not_3) {
            {
              EList<GenLink> _genOutgoingLinks_2 = it.getGenOutgoingLinks();
              final Function1<GenLink, Boolean> _function_5 = new Function1<GenLink, Boolean>() {
                public Boolean apply(final GenLink l) {
                  LinkModelFacet _modelFacet = l.getModelFacet();
                  return Boolean.valueOf((_modelFacet instanceof FeatureLinkModelFacet));
                }
              };
              Iterable<GenLink> _filter_5 = IterableExtensions.<GenLink>filter(_genOutgoingLinks_2, _function_5);
              for(final GenLink ol : _filter_5) {
                _builder.append("case ");
                CharSequence _visualID_2 = VisualIDRegistry.visualID(ol);
                _builder.append(_visualID_2, "");
                _builder.append(":");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t\t\t");
            _builder.append("org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest destroyRefReq = new org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand(destroyRefReq));");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), outgoingLink));");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("break;");
            _builder.newLine();
          }
        }
        {
          EList<GenLink> _genOutgoingLinks_3 = it.getGenOutgoingLinks();
          final Function1<GenLink, Boolean> _function_6 = new Function1<GenLink, Boolean>() {
            public Boolean apply(final GenLink l) {
              LinkModelFacet _modelFacet = l.getModelFacet();
              return Boolean.valueOf((_modelFacet instanceof TypeLinkModelFacet));
            }
          };
          Iterable<GenLink> _filter_6 = IterableExtensions.<GenLink>filter(_genOutgoingLinks_3, _function_6);
          boolean _isEmpty_5 = IterableExtensions.isEmpty(_filter_6);
          boolean _not_4 = (!_isEmpty_5);
          if (_not_4) {
            {
              EList<GenLink> _genOutgoingLinks_4 = it.getGenOutgoingLinks();
              final Function1<GenLink, Boolean> _function_7 = new Function1<GenLink, Boolean>() {
                public Boolean apply(final GenLink l) {
                  LinkModelFacet _modelFacet = l.getModelFacet();
                  return Boolean.valueOf((_modelFacet instanceof TypeLinkModelFacet));
                }
              };
              Iterable<GenLink> _filter_7 = IterableExtensions.<GenLink>filter(_genOutgoingLinks_4, _function_7);
              for(final GenLink ol_1 : _filter_7) {
                _builder.append("case ");
                CharSequence _visualID_3 = VisualIDRegistry.visualID(ol_1);
                _builder.append(_visualID_3, "");
                _builder.append(":");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t\t\t");
            _builder.append("org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest destroyEltReq = new org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest(outgoingLink.getElement(), false);");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand(destroyEltReq));");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), outgoingLink));");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("break;");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  private static <T extends Object> Iterable<T> union(final Iterable<? extends T> listA, final Iterable<? extends T> listB) {
    List<T> result = CollectionLiterals.<T>newLinkedList();
    Iterables.<T>addAll(result, listA);
    Iterables.<T>addAll(result, listB);
    return result;
  }
}
