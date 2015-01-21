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
 *    Dmitry Stadnik (Borland) - creation logic was moved in commands
 *    Michael Golubev (Borland) - [243151] explicit source/target for links
 *    							- #386838 - migrate to Xtend2
 *    Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package aspects.xpt.diagram.editpolicies;

import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkEnd;
import org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingReorientService;
import org.eclipse.papyrus.papyrusgmfgenextension.GenerateUsingElementTypeCreationCommand;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import xpt.Common;
import xpt.diagram.commands.CreateLinkCommand;
import xpt.diagram.editpolicies.Utils_qvto;
import xpt.editor.VisualIDRegistry;
import xpt.providers.ElementTypes;

/**
 * Start  		start of link creation.
 * 				User click to this editpart and start dragging with link tool.
 * Complete 	end of the command
 * 				User points to this editpart as a link target and release mouse button.
 * 
 * Outgoing 	the node is link source
 * 				This element could be a source for this type of link.
 * Incoming		the node is link destination
 * 				This element could be a target for this type of link.
 * 
 * Parameters:
 * 
 * 	diagram 	GenDiagram used to collect all defined links
 * 
 * 	this		Instance of GenLinkEnd for the element link could be creates to/from.
 * 				This could be GenNode or GenLink in case of links to links,
 *              in the latter case it is assumed that its a TypeLink (so its model facet is LinkTypeModelFacet),
 *              because RefLinks don't have underlying semantic identity
 */
@Singleton
@SuppressWarnings("all")
public class linkCommands extends xpt.diagram.editpolicies.linkCommands {
  @Inject
  @Extension
  private Utils_qvto _utils_qvto;
  
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  private aspects.xpt.diagram.editpolicies.Utils_qvto aspectsUtils_qvto;
  
  @Inject
  private VisualIDRegistry xptVisualIDRegistry;
  
  @Inject
  private ElementTypes xptElementTypes;
  
  @Inject
  private CreateLinkCommand xptCreateLinkCommand;
  
  public CharSequence createLinkCommands(final GenLinkEnd it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<GenerateUsingElementTypeCreationCommand> _filter = Iterators.<GenerateUsingElementTypeCreationCommand>filter(_allContents, GenerateUsingElementTypeCreationCommand.class);
      int _size = IteratorExtensions.size(_filter);
      boolean _lessThan = (_size < 1);
      if (_lessThan) {
        _builder.newLine();
        CharSequence _generatedMemberComment = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment, "");
        _builder.newLineIfNotEmpty();
        _builder.append("protected org.eclipse.gef.commands.Command getCreateRelationshipCommand(");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest req) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("org.eclipse.gef.commands.Command command = req.getTarget() == null ?");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return command != null ? command : super.getCreateRelationshipCommand(req);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_1, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.gef.commands.Command getStartCreateRelationshipCommand(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest req) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.emf.type.core.IElementType requestElementType = req.getElementType();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if(requestElementType == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.emf.type.core.IElementType baseElementType = requestElementType;");
    _builder.newLine();
    {
      Boolean _containsCreateStartLinkCommand = this.aspectsUtils_qvto.containsCreateStartLinkCommand(it);
      if ((_containsCreateStartLinkCommand).booleanValue()) {
        _builder.append("\t");
        _builder.append("boolean isExtendedType = true;");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      Iterable<GenLink> _allPotentialLinks = this._utils_qvto.getAllPotentialLinks(it);
      for(final GenLink l : _allPotentialLinks) {
        _builder.append("\t");
        CharSequence _startLinkCommands = this.startLinkCommands(l, it);
        _builder.append(_startLinkCommands, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generatedMemberComment_2 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_2, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.gef.commands.Command getCompleteCreateRelationshipCommand(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest req) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.emf.type.core.IElementType requestElementType = req.getElementType();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if(requestElementType == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.emf.type.core.IElementType baseElementType = requestElementType;");
    _builder.newLine();
    {
      Boolean _containsCreateCompleteLinkCommand = this.aspectsUtils_qvto.containsCreateCompleteLinkCommand(it);
      if ((_containsCreateCompleteLinkCommand).booleanValue()) {
        _builder.append("\t");
        _builder.append("boolean isExtendedType = true;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      Iterable<GenLink> _allPotentialLinks_1 = this._utils_qvto.getAllPotentialLinks(it);
      for(final GenLink l_1 : _allPotentialLinks_1) {
        _builder.append("\t");
        CharSequence _completeLinkCommands = this.completeLinkCommands(l_1, it);
        _builder.append(_completeLinkCommands, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence startLinkCommands(final GenLink it, final GenLinkEnd linkEnd) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (");
    CharSequence _accessElementType = this.xptElementTypes.accessElementType(it);
    _builder.append(_accessElementType, "");
    _builder.append(" == baseElementType) {");
    _builder.newLineIfNotEmpty();
    {
      boolean _createStartLinkCommand = this._utils_qvto.createStartLinkCommand(it, linkEnd);
      if (_createStartLinkCommand) {
        _builder.append("if(isExtendedType) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return getExtendedStartCreateRelationshipCommand(req, requestElementType);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return getGEFWrapper(new ");
        CharSequence _qualifiedClassName = this.xptCreateLinkCommand.qualifiedClassName(it);
        _builder.append(_qualifiedClassName, "\t\t");
        _builder.append("(req,");
        _builder.newLineIfNotEmpty();
        {
          boolean _createStartIncomingLinkCommand = this._utils_qvto.createStartIncomingLinkCommand(it, linkEnd);
          if (_createStartIncomingLinkCommand) {
            _builder.append("\t\t\t");
            _builder.append("req.getTarget(), req.getSource()");
            _builder.newLine();
          } else {
            _builder.append("\t\t\t");
            _builder.append("req.getSource(), req.getTarget()");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("));");
        _builder.newLine();
      } else {
        _builder.append("return null;");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence completeLinkCommands(final GenLink it, final GenLinkEnd linkEnd) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (");
    CharSequence _accessElementType = this.xptElementTypes.accessElementType(it);
    _builder.append(_accessElementType, "");
    _builder.append(" == baseElementType) {");
    _builder.newLineIfNotEmpty();
    {
      boolean _createCompleteLinkCommand = this._utils_qvto.createCompleteLinkCommand(it, linkEnd);
      if (_createCompleteLinkCommand) {
        _builder.append("\t");
        _builder.append("if(isExtendedType) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return getExtendedCompleteCreateRelationshipCommand(req, requestElementType);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return getGEFWrapper(new ");
        CharSequence _qualifiedClassName = this.xptCreateLinkCommand.qualifiedClassName(it);
        _builder.append(_qualifiedClassName, "\t\t");
        _builder.append("(req,");
        _builder.newLineIfNotEmpty();
        {
          boolean _createCompleteOutgoingLinkCommand = this._utils_qvto.createCompleteOutgoingLinkCommand(it, linkEnd);
          if (_createCompleteOutgoingLinkCommand) {
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("req.getTarget(), req.getSource()");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("req.getSource(), req.getTarget()");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("));");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("return null;");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence reorientTypeLinkCommands(final GenLinkEnd it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment(
      ("Returns command to reorient EClass based link. New link target or source\n" + "should be the domain model element associated with this node.\n"));
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected org.eclipse.gef.commands.Command getReorientRelationshipCommand(");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest req) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch (getVisualID(req)) {");
    _builder.newLine();
    {
      Iterable<GenLink> _reroutableTypeLinks = this._utils_qvto.getReroutableTypeLinks(it);
      for(final GenLink link : _reroutableTypeLinks) {
        _builder.append("\t\t\t");
        CharSequence _reorientLinkCommandWithService = this.reorientLinkCommandWithService(link);
        _builder.append(_reorientLinkCommandWithService, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    CharSequence _callReorientCommand = this.callReorientCommand(it);
    _builder.append(_callReorientCommand, "\t\t\t");
    _builder.newLineIfNotEmpty();
    {
      Iterable<GenLink> _reroutableTypeLinks_1 = this._utils_qvto.getReroutableTypeLinks(it);
      for(final GenLink link_1 : _reroutableTypeLinks_1) {
        _builder.append("\t\t\t");
        CharSequence _reorientLinkCommandWithoutService = this.reorientLinkCommandWithoutService(link_1);
        _builder.append(_reorientLinkCommandWithoutService, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return super.getReorientRelationshipCommand(req);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence reorientLinkCommandWithService(final GenLink it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<EditPartUsingReorientService> _filter = Iterators.<EditPartUsingReorientService>filter(_allContents, EditPartUsingReorientService.class);
      final Function1<EditPartUsingReorientService, Boolean> _function = new Function1<EditPartUsingReorientService, Boolean>() {
        public Boolean apply(final EditPartUsingReorientService v) {
          EList<GenLink> _genView = v.getGenView();
          return Boolean.valueOf(_genView.contains(it));
        }
      };
      Iterator<EditPartUsingReorientService> _filter_1 = IteratorExtensions.<EditPartUsingReorientService>filter(_filter, _function);
      int _size = IteratorExtensions.size(_filter_1);
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        CharSequence _caseVisualID = this.xptVisualIDRegistry.caseVisualID(it);
        _builder.append(_caseVisualID, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence callReorientCommand(final GenLinkEnd it) {
    StringConcatenation _builder = new StringConcatenation();
    Resource _eResource = it.eResource();
    TreeIterator<EObject> _allContents = _eResource.getAllContents();
    Iterator<EditPartUsingReorientService> rServiceNodes = Iterators.<EditPartUsingReorientService>filter(_allContents, EditPartUsingReorientService.class);
    _builder.newLineIfNotEmpty();
    {
      boolean _isEmpty = IteratorExtensions.isEmpty(rServiceNodes);
      boolean _not = (!_isEmpty);
      if (_not) {
        {
          final Function1<EditPartUsingReorientService, Boolean> _function = new Function1<EditPartUsingReorientService, Boolean>() {
            public Boolean apply(final EditPartUsingReorientService rServiceNode) {
              EList<GenLink> _genView = rServiceNode.getGenView();
              final Function1<GenLink, Boolean> _function = new Function1<GenLink, Boolean>() {
                public Boolean apply(final GenLink view) {
                  Iterable<GenLink> _reroutableTypeLinks = linkCommands.this._utils_qvto.getReroutableTypeLinks(it);
                  List<GenLink> _list = IterableExtensions.<GenLink>toList(_reroutableTypeLinks);
                  return Boolean.valueOf(_list.contains(view));
                }
              };
              Iterable<GenLink> _filter = IterableExtensions.<GenLink>filter(_genView, _function);
              boolean _isEmpty = IterableExtensions.isEmpty(_filter);
              return Boolean.valueOf((!_isEmpty));
            }
          };
          Iterator<EditPartUsingReorientService> _filter = IteratorExtensions.<EditPartUsingReorientService>filter(rServiceNodes, _function);
          boolean _isEmpty_1 = IteratorExtensions.isEmpty(_filter);
          boolean _not_1 = (!_isEmpty_1);
          if (_not_1) {
            _builder.append("org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider =org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(req.getRelationship());");
            _builder.newLine();
            _builder.append(" ");
            _builder.append("if(provider == null) {");
            _builder.newLine();
            _builder.append("           ");
            _builder.append("return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;");
            _builder.newLine();
            _builder.append(" ");
            _builder.append("}");
            _builder.newLine();
            _builder.append(" ");
            _builder.append("// Retrieve re-orient command from the Element Edit service");
            _builder.newLine();
            _builder.append(" ");
            _builder.append("org.eclipse.gmf.runtime.common.core.command.ICommand reorientCommand = provider.getEditCommand(req);");
            _builder.newLine();
            _builder.append("          ");
            _builder.append("if(reorientCommand == null) {");
            _builder.newLine();
            _builder.append("           ");
            _builder.append("return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;");
            _builder.newLine();
            _builder.append("          ");
            _builder.append("}");
            _builder.newLine();
            _builder.append(" ");
            _builder.append("return getGEFWrapper(reorientCommand.reduce());");
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence reorientLinkCommandWithoutService(final GenLink it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<EditPartUsingReorientService> _filter = Iterators.<EditPartUsingReorientService>filter(_allContents, EditPartUsingReorientService.class);
      final Function1<EditPartUsingReorientService, Boolean> _function = new Function1<EditPartUsingReorientService, Boolean>() {
        public Boolean apply(final EditPartUsingReorientService v) {
          EList<GenLink> _genView = v.getGenView();
          return Boolean.valueOf(_genView.contains(it));
        }
      };
      Iterator<EditPartUsingReorientService> _filter_1 = IteratorExtensions.<EditPartUsingReorientService>filter(_filter, _function);
      int _size = IteratorExtensions.size(_filter_1);
      boolean _equals = (_size == 0);
      if (_equals) {
        CharSequence _reorientLinkCommand = this.reorientLinkCommand(it);
        _builder.append(_reorientLinkCommand, "");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
