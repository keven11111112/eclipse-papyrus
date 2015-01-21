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
 * 	  Remi Schnekenburger (CEA LIST) - modification for Papyrus MDT
 */
package aspects.impl.diagram.editparts;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Arrays;
import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.InnerClassViewmap;
import org.eclipse.gmf.codegen.gmfgen.ModeledViewmap;
import org.eclipse.gmf.codegen.gmfgen.SnippetViewmap;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import xpt.Common;

/**
 * Revisit: [MG]: @Inject extension same-named-api-class -> template extends api-class?
 */
@Singleton
@SuppressWarnings("all")
public class LinkEditPart extends impl.diagram.editparts.LinkEditPart {
  @Inject
  @Extension
  private Common _common;
  
  public CharSequence extendsListContents(final GenLink it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<ExtendedGenView> _filter = Iterators.<ExtendedGenView>filter(_allContents, ExtendedGenView.class);
      final Function1<ExtendedGenView, Boolean> _function = new Function1<ExtendedGenView, Boolean>() {
        public Boolean apply(final ExtendedGenView v) {
          boolean _and = false;
          EList<GenCommonBase> _genView = v.getGenView();
          boolean _contains = _genView.contains(it);
          if (!_contains) {
            _and = false;
          } else {
            String _superOwnedEditPart = v.getSuperOwnedEditPart();
            boolean _notEquals = (!Objects.equal(_superOwnedEditPart, null));
            _and = _notEquals;
          }
          return Boolean.valueOf(_and);
        }
      };
      Iterator<ExtendedGenView> _filter_1 = IteratorExtensions.<ExtendedGenView>filter(_filter, _function);
      int _size = IteratorExtensions.size(_filter_1);
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        {
          Resource _eResource_1 = it.eResource();
          TreeIterator<EObject> _allContents_1 = _eResource_1.getAllContents();
          Iterator<ExtendedGenView> _filter_2 = Iterators.<ExtendedGenView>filter(_allContents_1, ExtendedGenView.class);
          final Function1<ExtendedGenView, Boolean> _function_1 = new Function1<ExtendedGenView, Boolean>() {
            public Boolean apply(final ExtendedGenView v) {
              boolean _and = false;
              EList<GenCommonBase> _genView = v.getGenView();
              boolean _contains = _genView.contains(it);
              if (!_contains) {
                _and = false;
              } else {
                String _superOwnedEditPart = v.getSuperOwnedEditPart();
                boolean _notEquals = (!Objects.equal(_superOwnedEditPart, null));
                _and = _notEquals;
              }
              return Boolean.valueOf(_and);
            }
          };
          Iterator<ExtendedGenView> _filter_3 = IteratorExtensions.<ExtendedGenView>filter(_filter_2, _function_1);
          Iterable<ExtendedGenView> _iterable = IteratorExtensions.<ExtendedGenView>toIterable(_filter_3);
          for(final ExtendedGenView extendedObject : _iterable) {
            CharSequence _specifyInheritance = this.specifyInheritance(extendedObject);
            _builder.append(_specifyInheritance, "");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        _builder.append("org.eclipse.papyrus.infra.gmfdiag.common.editpart.ConnectionEditPart");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence specifyInheritance(final ExtendedGenView it) {
    StringConcatenation _builder = new StringConcatenation();
    String _superOwnedEditPart = it.getSuperOwnedEditPart();
    _builder.append(_superOwnedEditPart, "");
    return _builder;
  }
  
  public CharSequence addFixedChild(final GenLink it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<GenLinkLabel> _labels = it.getLabels();
      int _size = _labels.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        CharSequence _generatedMemberComment = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment, "");
        _builder.newLineIfNotEmpty();
        _builder.append("protected boolean addFixedChild(org.eclipse.gef.EditPart childEditPart) {");
        _builder.newLine();
        {
          EList<GenLinkLabel> _labels_1 = it.getLabels();
          for(final GenLinkLabel label : _labels_1) {
            _builder.append("\t");
            Viewmap _viewmap = label.getViewmap();
            CharSequence _addLabel = this.addLabel(_viewmap, label);
            _builder.append(_addLabel, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("return false;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence removeFixedChild(final GenLink it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<GenLinkLabel> _labels = it.getLabels();
      boolean _isEmpty = _labels.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        CharSequence _generatedMemberComment = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment, "");
        _builder.newLineIfNotEmpty();
        _builder.append("protected boolean removeFixedChild(org.eclipse.gef.EditPart childEditPart) {");
        _builder.newLine();
        {
          EList<GenLinkLabel> _labels_1 = it.getLabels();
          for(final GenLinkLabel label : _labels_1) {
            _builder.append("\t");
            Viewmap _viewmap = label.getViewmap();
            CharSequence _removeLabel = this.removeLabel(_viewmap, label);
            _builder.append(_removeLabel, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("return false;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence addChildVisual(final GenLink it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<GenLinkLabel> _labels = it.getLabels();
      boolean _isEmpty = _labels.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        CharSequence _generatedMemberComment = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment, "");
        _builder.newLineIfNotEmpty();
        _builder.append("protected void addChildVisual(org.eclipse.gef.EditPart childEditPart, int index) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if (addFixedChild(childEditPart)) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("super.addChildVisual(childEditPart, -1);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence removeChildVisual(final GenLink it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<GenLinkLabel> _labels = it.getLabels();
      boolean _isEmpty = _labels.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        CharSequence _generatedMemberComment = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment, "");
        _builder.newLineIfNotEmpty();
        _builder.append("protected void removeChildVisual(org.eclipse.gef.EditPart childEditPart) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if (removeFixedChild(childEditPart)) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("super.removeChildVisual(childEditPart);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  protected CharSequence _createLinkFigure(final ModeledViewmap it, final GenLink link) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public CharSequence modeledViewmapFigureFQN(final ModeledViewmap it) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public CharSequence createLinkFigure(final Viewmap it, final GenLink link) {
    if (it instanceof FigureViewmap) {
      return _createLinkFigure((FigureViewmap)it, link);
    } else if (it instanceof InnerClassViewmap) {
      return _createLinkFigure((InnerClassViewmap)it, link);
    } else if (it instanceof ModeledViewmap) {
      return _createLinkFigure((ModeledViewmap)it, link);
    } else if (it instanceof SnippetViewmap) {
      return _createLinkFigure((SnippetViewmap)it, link);
    } else if (it != null) {
      return _createLinkFigure(it, link);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, link).toString());
    }
  }
}
