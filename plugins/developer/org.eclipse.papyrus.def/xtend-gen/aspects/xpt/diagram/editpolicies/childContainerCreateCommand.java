/**
 * Copyright (c) 2007, 2009 Borland Software Corporation
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

import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Iterator;
import metamodel.MetaModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.papyrus.papyrusgmfgenextension.GenerateUsingElementTypeCreationCommand;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import xpt.Common;
import xpt.providers.ElementTypes;

@Singleton
@SuppressWarnings("all")
public class childContainerCreateCommand extends xpt.diagram.editpolicies.childContainerCreateCommand {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private ElementTypes _elementTypes;
  
  @Inject
  @Extension
  private MetaModel _metaModel;
  
  public CharSequence childContainerCreateCommand(final Iterable<? extends GenNode> nodes) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isEmpty = IterableExtensions.isEmpty(nodes);
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.newLine();
        CharSequence _generatedMemberComment = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment, "");
        _builder.newLineIfNotEmpty();
        _builder.append("protected org.eclipse.gef.commands.Command getCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest req) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("org.eclipse.gmf.runtime.emf.type.core.IElementType requestElementType = req.getElementType();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if(requestElementType == null) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return super.getCreateCommand(req);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.newLine();
        {
          for(final GenNode n : nodes) {
            {
              boolean _isSansDomain = n.isSansDomain();
              boolean _not_1 = (!_isSansDomain);
              if (_not_1) {
                TypeModelFacet _modelFacet = n.getModelFacet();
                CharSequence _childNodeCreateCommand = this.childNodeCreateCommand(_modelFacet, n);
                _builder.append(_childNodeCreateCommand, "");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append("return super.getCreateCommand(req);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence childNodeCreateCommand(final TypeModelFacet it, final GenNode node) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (");
    CharSequence _accessElementType = this._elementTypes.accessElementType(node);
    _builder.append(_accessElementType, "");
    _builder.append(" == requestElementType) {");
    _builder.newLineIfNotEmpty();
    {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<GenerateUsingElementTypeCreationCommand> _filter = Iterators.<GenerateUsingElementTypeCreationCommand>filter(_allContents, GenerateUsingElementTypeCreationCommand.class);
      int _size = IteratorExtensions.size(_filter);
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("\t");
        _builder.append("// adjust the containment feature");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("org.eclipse.emf.ecore.EReference containmentFeature = ");
        GenFeature _childMetaFeature = it.getChildMetaFeature();
        CharSequence _MetaFeature = this._metaModel.MetaFeature(_childMetaFeature);
        _builder.append(_MetaFeature, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("req.setContainmentFeature(containmentFeature);");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      Resource _eResource_1 = it.eResource();
      TreeIterator<EObject> _allContents_1 = _eResource_1.getAllContents();
      Iterator<GenerateUsingElementTypeCreationCommand> _filter_1 = Iterators.<GenerateUsingElementTypeCreationCommand>filter(_allContents_1, GenerateUsingElementTypeCreationCommand.class);
      int _size_1 = IteratorExtensions.size(_filter_1);
      boolean _greaterThan_1 = (_size_1 > 0);
      if (_greaterThan_1) {
        _builder.append("\t");
        _builder.append("return getGEFWrapper(getSemanticCreationCommand(req));");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("return getGEFWrapper(new ");
        String _createCommandQualifiedClassName = node.getCreateCommandQualifiedClassName();
        _builder.append(_createCommandQualifiedClassName, "\t");
        _builder.append("(req, org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils.getDiagramFrom(getHost())));");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
