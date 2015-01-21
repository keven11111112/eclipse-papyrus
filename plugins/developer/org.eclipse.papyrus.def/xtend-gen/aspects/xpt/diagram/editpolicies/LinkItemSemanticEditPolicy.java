/**
 * Copyright (c) 2007-2012 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Borland) - [243151] explicit source/target for links
 * 								- #386838 - migrate to Xtend2
 * 	  Vincent Lorenzo (CEA-LIST)
 */
package aspects.xpt.diagram.editpolicies;

import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import impl.diagram.commands.DeleteLinkCommand;
import java.util.Arrays;
import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import utils.UtilsItemSemanticEditPolicy;
import xpt.Common;

@Singleton
@SuppressWarnings("all")
public class LinkItemSemanticEditPolicy extends xpt.diagram.editpolicies.LinkItemSemanticEditPolicy {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private DeleteLinkCommand _deleteLinkCommand;
  
  @Inject
  @Extension
  private UtilsItemSemanticEditPolicy _utilsItemSemanticEditPolicy;
  
  protected CharSequence _getDestroySemanticCommand(final TypeLinkModelFacet it, final GenLink genLink) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<EditPartUsingDeleteService> _filter = Iterators.<EditPartUsingDeleteService>filter(_allContents, EditPartUsingDeleteService.class);
      final Function1<EditPartUsingDeleteService, Boolean> _function = new Function1<EditPartUsingDeleteService, Boolean>() {
        public Boolean apply(final EditPartUsingDeleteService v) {
          EList<GenCommonBase> _genView = v.getGenView();
          return Boolean.valueOf(_genView.contains(genLink));
        }
      };
      Iterator<EditPartUsingDeleteService> _filter_1 = IteratorExtensions.<EditPartUsingDeleteService>filter(_filter, _function);
      int _size = IteratorExtensions.size(_filter_1);
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        _builder.newLine();
        _builder.append("\t");
        CharSequence _generatedMemberComment = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _destroyElementCommandByService = this._utilsItemSemanticEditPolicy.getDestroyElementCommandByService(it);
        _builder.append(_destroyElementCommandByService, "\t");
        _builder.newLineIfNotEmpty();
      } else {
        CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment_1, "");
        _builder.newLineIfNotEmpty();
        _builder.append("protected org.eclipse.gef.commands.Command getDestroyElementCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest req) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand cmd = new org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand(getEditingDomain(), null);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("cmd.setTransactionNestingEnabled(true);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("java.util.List<org.eclipse.emf.ecore.EObject> todestroy=new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("todestroy.add(req.getElementToDestroy());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("//cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand(req));");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("cmd.add(new org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper(new org.eclipse.emf.edit.command.DeleteCommand(getEditingDomain(),todestroy )));");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return getGEFWrapper(cmd.reduce());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("//return getGEFWrapper(");
        CharSequence _newDeleteLinkWithClassCommand = this._deleteLinkCommand.newDeleteLinkWithClassCommand(it, genLink, "req");
        _builder.append(_newDeleteLinkWithClassCommand, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence getDestroySemanticCommand(final LinkModelFacet it, final GenLink genLink) {
    if (it instanceof FeatureLinkModelFacet) {
      return _getDestroySemanticCommand((FeatureLinkModelFacet)it, genLink);
    } else if (it instanceof TypeLinkModelFacet) {
      return _getDestroySemanticCommand((TypeLinkModelFacet)it, genLink);
    } else if (it != null) {
      return _getDestroySemanticCommand(it, genLink);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, genLink).toString());
    }
  }
}
